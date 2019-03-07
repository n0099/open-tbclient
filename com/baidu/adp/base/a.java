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
    private static ArrayList<SoftReference<Activity>> ve;
    private static a vf;
    private InterfaceC0011a vg;
    private int vh = 0;

    /* renamed from: com.baidu.adp.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0011a {
        void onActivityClosed();
    }

    public void a(InterfaceC0011a interfaceC0011a) {
        this.vg = interfaceC0011a;
    }

    private a() {
        if (ve == null) {
            ve = new ArrayList<>(20);
        }
    }

    public static a fT() {
        if (vf == null) {
            vf = new a();
        }
        return vf;
    }

    public int getSize() {
        return ve.size();
    }

    public void l(Activity activity) {
        if (activity != null) {
            ve.add(new SoftReference<>(activity));
            H(this.vh);
        }
    }

    public Activity G(int i) {
        int size = ve.size();
        if (size == 0) {
            return null;
        }
        if (i < 0 || i >= size) {
            return null;
        }
        SoftReference<Activity> remove = ve.remove(i);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }

    public void m(Activity activity) {
        if (activity != null) {
            int size = ve.size();
            if (size == 0) {
                if (this.vg != null) {
                    this.vg.onActivityClosed();
                    return;
                }
                return;
            }
            for (int i = size - 1; i >= 0; i--) {
                SoftReference<Activity> softReference = ve.get(i);
                if (softReference == null) {
                    ve.remove(i);
                } else if (activity.equals(softReference.get())) {
                    ve.remove(i);
                    if (ve.size() == 0 && this.vg != null) {
                        this.vg.onActivityClosed();
                        return;
                    }
                    return;
                } else if (ve.size() == 0 && this.vg != null) {
                    this.vg.onActivityClosed();
                }
            }
        }
    }

    public Activity fU() {
        SoftReference<Activity> softReference;
        int size = ve.size();
        if (size != 0 && (softReference = ve.get(size - 1)) != null) {
            return softReference.get();
        }
        return null;
    }

    public void setActivityStackMaxSize(int i) {
        if (i >= 10 || i == 0) {
            this.vh = i;
        }
    }

    public void fV() {
        H(3);
    }

    public void fW() {
        Activity activity;
        if (ve != null) {
            while (!ve.isEmpty()) {
                SoftReference<Activity> remove = ve.remove(0);
                if (remove != null && remove.get() != null && (activity = remove.get()) != null) {
                    activity.finish();
                }
            }
        }
        if (this.vg != null) {
            this.vg.onActivityClosed();
        }
    }

    public int getActivityStackMaxSize() {
        return this.vh;
    }

    private void H(int i) {
        if (i != 0) {
            int size = fT().getSize();
            while (size > i) {
                size--;
                Activity G = fT().G(1);
                if (G != null) {
                    G.finish();
                }
            }
        }
    }

    public String fX() {
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        String str;
        Activity activity;
        String str2;
        if (ve == null || ve.size() == 0) {
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
        Iterator<SoftReference<Activity>> it = ve.iterator();
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
