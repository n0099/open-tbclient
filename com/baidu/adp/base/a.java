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
    private static ArrayList<SoftReference<Activity>> sF;
    private static a sG;
    private InterfaceC0011a sH;
    private int sI = 0;

    /* renamed from: com.baidu.adp.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0011a {
        void onActivityClosed();
    }

    public void a(InterfaceC0011a interfaceC0011a) {
        this.sH = interfaceC0011a;
    }

    private a() {
        if (sF == null) {
            sF = new ArrayList<>(20);
        }
    }

    public static a eM() {
        if (sG == null) {
            sG = new a();
        }
        return sG;
    }

    public int getSize() {
        return sF.size();
    }

    public void l(Activity activity) {
        if (activity != null) {
            sF.add(new SoftReference<>(activity));
            z(this.sI);
        }
    }

    public Activity y(int i) {
        int size = sF.size();
        if (size == 0) {
            return null;
        }
        if (i < 0 || i >= size) {
            return null;
        }
        SoftReference<Activity> remove = sF.remove(i);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }

    public void m(Activity activity) {
        if (activity != null) {
            int size = sF.size();
            if (size == 0) {
                if (this.sH != null) {
                    this.sH.onActivityClosed();
                    return;
                }
                return;
            }
            for (int i = size - 1; i >= 0; i--) {
                SoftReference<Activity> softReference = sF.get(i);
                if (softReference == null) {
                    sF.remove(i);
                } else if (activity.equals(softReference.get())) {
                    sF.remove(i);
                    if (sF.size() == 0 && this.sH != null) {
                        this.sH.onActivityClosed();
                        return;
                    }
                    return;
                } else if (sF.size() == 0 && this.sH != null) {
                    this.sH.onActivityClosed();
                }
            }
        }
    }

    public Activity eN() {
        SoftReference<Activity> softReference;
        int size = sF.size();
        if (size != 0 && (softReference = sF.get(size - 1)) != null) {
            return softReference.get();
        }
        return null;
    }

    public void setActivityStackMaxSize(int i) {
        if (i >= 10 || i == 0) {
            this.sI = i;
        }
    }

    public void eO() {
        z(3);
    }

    public void eP() {
        Activity activity;
        if (sF != null) {
            while (!sF.isEmpty()) {
                SoftReference<Activity> remove = sF.remove(0);
                if (remove != null && remove.get() != null && (activity = remove.get()) != null) {
                    activity.finish();
                }
            }
        }
        if (this.sH != null) {
            this.sH.onActivityClosed();
        }
    }

    public int getActivityStackMaxSize() {
        return this.sI;
    }

    private void z(int i) {
        if (i != 0) {
            int size = eM().getSize();
            while (size > i) {
                size--;
                Activity y = eM().y(1);
                if (y != null) {
                    y.finish();
                }
            }
        }
    }

    public String eQ() {
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        String str;
        Activity activity;
        String str2;
        if (sF == null || sF.size() == 0) {
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
        Iterator<SoftReference<Activity>> it = sF.iterator();
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
