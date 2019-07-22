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
    private static ArrayList<SoftReference<Activity>> sI;
    private static a sJ;
    private InterfaceC0011a sK;
    private int sL = 0;

    /* renamed from: com.baidu.adp.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0011a {
        void onActivityClosed();
    }

    public void a(InterfaceC0011a interfaceC0011a) {
        this.sK = interfaceC0011a;
    }

    private a() {
        if (sI == null) {
            sI = new ArrayList<>(20);
        }
    }

    public static a eT() {
        if (sJ == null) {
            sJ = new a();
        }
        return sJ;
    }

    public int getSize() {
        return sI.size();
    }

    public void o(Activity activity) {
        if (activity != null) {
            sI.add(new SoftReference<>(activity));
            z(this.sL);
        }
    }

    public Activity y(int i) {
        int size = sI.size();
        if (size == 0) {
            return null;
        }
        if (i < 0 || i >= size) {
            return null;
        }
        SoftReference<Activity> remove = sI.remove(i);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }

    public void p(Activity activity) {
        if (activity != null) {
            int size = sI.size();
            if (size == 0) {
                if (this.sK != null) {
                    this.sK.onActivityClosed();
                    return;
                }
                return;
            }
            for (int i = size - 1; i >= 0; i--) {
                SoftReference<Activity> softReference = sI.get(i);
                if (softReference == null) {
                    sI.remove(i);
                } else if (activity.equals(softReference.get())) {
                    sI.remove(i);
                    if (sI.size() == 0 && this.sK != null) {
                        this.sK.onActivityClosed();
                        return;
                    }
                    return;
                } else if (sI.size() == 0 && this.sK != null) {
                    this.sK.onActivityClosed();
                }
            }
        }
    }

    public Activity eU() {
        SoftReference<Activity> softReference;
        int size = sI.size();
        if (size != 0 && (softReference = sI.get(size - 1)) != null) {
            return softReference.get();
        }
        return null;
    }

    public void setActivityStackMaxSize(int i) {
        if (i >= 10 || i == 0) {
            this.sL = i;
        }
    }

    public void eV() {
        z(3);
    }

    public void eW() {
        Activity activity;
        if (sI != null) {
            while (!sI.isEmpty()) {
                SoftReference<Activity> remove = sI.remove(0);
                if (remove != null && remove.get() != null && (activity = remove.get()) != null) {
                    activity.finish();
                }
            }
        }
        if (this.sK != null) {
            this.sK.onActivityClosed();
        }
    }

    public int getActivityStackMaxSize() {
        return this.sL;
    }

    private void z(int i) {
        if (i != 0) {
            int size = eT().getSize();
            while (size > i) {
                size--;
                Activity y = eT().y(1);
                if (y != null) {
                    y.finish();
                }
            }
        }
    }

    public String eX() {
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        String str;
        Activity activity;
        String str2;
        if (sI == null || sI.size() == 0) {
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
        Iterator<SoftReference<Activity>> it = sI.iterator();
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
