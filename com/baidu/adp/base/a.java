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
    private static ArrayList<SoftReference<Activity>> rP;
    private static a rQ;
    private InterfaceC0010a rR;
    private int rS = 0;

    /* renamed from: com.baidu.adp.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0010a {
        void onActivityClosed();
    }

    public void a(InterfaceC0010a interfaceC0010a) {
        this.rR = interfaceC0010a;
    }

    private a() {
        if (rP == null) {
            rP = new ArrayList<>(20);
        }
    }

    public static a ew() {
        if (rQ == null) {
            rQ = new a();
        }
        return rQ;
    }

    public int getSize() {
        return rP.size();
    }

    public void i(Activity activity) {
        if (activity != null) {
            rP.add(new SoftReference<>(activity));
            z(this.rS);
        }
    }

    public Activity y(int i) {
        int size = rP.size();
        if (size == 0) {
            return null;
        }
        if (i < 0 || i >= size) {
            return null;
        }
        SoftReference<Activity> remove = rP.remove(i);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }

    public void j(Activity activity) {
        if (activity != null) {
            int size = rP.size();
            if (size == 0) {
                if (this.rR != null) {
                    this.rR.onActivityClosed();
                    return;
                }
                return;
            }
            for (int i = size - 1; i >= 0; i--) {
                SoftReference<Activity> softReference = rP.get(i);
                if (softReference == null) {
                    rP.remove(i);
                } else if (activity.equals(softReference.get())) {
                    rP.remove(i);
                    if (rP.size() == 0 && this.rR != null) {
                        this.rR.onActivityClosed();
                        return;
                    }
                    return;
                } else if (rP.size() == 0 && this.rR != null) {
                    this.rR.onActivityClosed();
                }
            }
        }
    }

    public Activity ex() {
        SoftReference<Activity> softReference;
        int size = rP.size();
        if (size != 0 && (softReference = rP.get(size - 1)) != null) {
            return softReference.get();
        }
        return null;
    }

    public void setActivityStackMaxSize(int i) {
        if (i >= 10 || i == 0) {
            this.rS = i;
        }
    }

    public void ey() {
        z(3);
    }

    public void ez() {
        Activity activity;
        if (rP != null) {
            while (!rP.isEmpty()) {
                SoftReference<Activity> remove = rP.remove(0);
                if (remove != null && remove.get() != null && (activity = remove.get()) != null) {
                    activity.finish();
                }
            }
        }
        if (this.rR != null) {
            this.rR.onActivityClosed();
        }
    }

    public int getActivityStackMaxSize() {
        return this.rS;
    }

    private void z(int i) {
        if (i != 0) {
            int size = ew().getSize();
            while (size > i) {
                size--;
                Activity y = ew().y(1);
                if (y != null) {
                    y.finish();
                }
            }
        }
    }

    public String eA() {
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        String str;
        Activity activity;
        String str2;
        if (rP == null || rP.size() == 0) {
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
        Iterator<SoftReference<Activity>> it = rP.iterator();
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
