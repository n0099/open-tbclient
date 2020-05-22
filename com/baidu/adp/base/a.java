package com.baidu.adp.base;

import android.app.Activity;
import android.app.ActivityManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class a {
    private static a Gc;
    private static ArrayList<SoftReference<Activity>> sActivityStack;
    private InterfaceC0016a Gd;
    private int mActivityStackMaxSize = 0;

    /* renamed from: com.baidu.adp.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0016a {
        void onActivityClosed();
    }

    public void a(InterfaceC0016a interfaceC0016a) {
        this.Gd = interfaceC0016a;
    }

    private a() {
        if (sActivityStack == null) {
            sActivityStack = new ArrayList<>(20);
        }
    }

    public static a jm() {
        if (Gc == null) {
            Gc = new a();
        }
        return Gc;
    }

    public int getSize() {
        return sActivityStack.size();
    }

    public void pushActivity(Activity activity) {
        if (activity != null) {
            sActivityStack.add(new SoftReference<>(activity));
            checkAndMaintainActivityStack(this.mActivityStackMaxSize);
        }
    }

    public Activity popActivity(int i) {
        int size = sActivityStack.size();
        if (size == 0) {
            return null;
        }
        if (i < 0 || i >= size) {
            return null;
        }
        SoftReference<Activity> remove = sActivityStack.remove(i);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }

    public void popActivity(Activity activity) {
        if (activity != null) {
            int size = sActivityStack.size();
            if (size == 0) {
                if (this.Gd != null) {
                    this.Gd.onActivityClosed();
                    return;
                }
                return;
            }
            for (int i = size - 1; i >= 0; i--) {
                SoftReference<Activity> softReference = sActivityStack.get(i);
                if (softReference == null) {
                    sActivityStack.remove(i);
                } else if (activity.equals(softReference.get())) {
                    sActivityStack.remove(i);
                    if (sActivityStack.size() == 0 && this.Gd != null) {
                        this.Gd.onActivityClosed();
                        return;
                    }
                    return;
                } else if (sActivityStack.size() == 0 && this.Gd != null) {
                    this.Gd.onActivityClosed();
                }
            }
        }
    }

    public Activity currentActivity() {
        SoftReference<Activity> softReference;
        int size = sActivityStack.size();
        if (size != 0 && (softReference = sActivityStack.get(size - 1)) != null) {
            return softReference.get();
        }
        return null;
    }

    public boolean bi(String str) {
        if (sActivityStack.size() == 0) {
            return false;
        }
        Iterator<SoftReference<Activity>> it = sActivityStack.iterator();
        while (it.hasNext()) {
            SoftReference<Activity> next = it.next();
            if (next != null && next.get() != null && next.get().getClass().getSimpleName() != null && next.get().getClass().getSimpleName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void setActivityStackMaxSize(int i) {
        if (i >= 10 || i == 0) {
            this.mActivityStackMaxSize = i;
        }
    }

    public void releaseAllPossibleAcitivities() {
        checkAndMaintainActivityStack(3);
    }

    public void releaseAllAcitivities() {
        Activity activity;
        if (sActivityStack != null) {
            while (!sActivityStack.isEmpty()) {
                SoftReference<Activity> remove = sActivityStack.remove(0);
                if (remove != null && remove.get() != null && (activity = remove.get()) != null) {
                    activity.finish();
                }
            }
        }
        if (this.Gd != null) {
            this.Gd.onActivityClosed();
        }
    }

    public int getActivityStackMaxSize() {
        return this.mActivityStackMaxSize;
    }

    private void checkAndMaintainActivityStack(int i) {
        if (i != 0) {
            int size = jm().getSize();
            while (size > i) {
                size--;
                Activity popActivity = jm().popActivity(1);
                if (popActivity != null) {
                    popActivity.finish();
                }
            }
        }
    }

    public String jn() {
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        String str;
        Activity activity;
        String str2;
        if (sActivityStack == null || sActivityStack.size() == 0) {
            try {
                if (BdBaseApplication.getInst() != null && (activityManager = (ActivityManager) BdBaseApplication.getInst().getSystemService(PushConstants.INTENT_ACTIVITY_NAME)) != null && (runningTasks = activityManager.getRunningTasks(1)) != null && runningTasks.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                        if (runningTaskInfo != null) {
                            String str3 = runningTaskInfo.topActivity != null ? "top:" + runningTaskInfo.topActivity.getClassName() : "";
                            if (runningTaskInfo.baseActivity != null) {
                                str3 = str3 + "&base:" + runningTaskInfo.baseActivity.getClassName();
                            }
                            str = str3 + "&numbers:" + runningTaskInfo.numActivities;
                        } else {
                            str = "";
                        }
                        if (!StringUtils.isNull(str)) {
                            sb.append(str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                        }
                    }
                    return sb.toString();
                }
            } catch (Exception e) {
            }
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator<SoftReference<Activity>> it = sActivityStack.iterator();
        while (it.hasNext()) {
            SoftReference<Activity> next = it.next();
            if (next != null && (activity = next.get()) != null) {
                if (activity == null || activity.getClass() == null) {
                    str2 = "";
                } else {
                    str2 = activity.getClass().getSimpleName();
                }
                if (!StringUtils.isNull(str2)) {
                    sb2.append(str2 + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                }
            }
        }
        return sb2.toString();
    }
}
