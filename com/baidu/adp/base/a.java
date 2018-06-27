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
    private static ArrayList<SoftReference<Activity>> rX;
    private static a rY;
    private InterfaceC0010a rZ;
    private int sa = 0;

    /* renamed from: com.baidu.adp.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0010a {
        void onActivityClosed();
    }

    public void a(InterfaceC0010a interfaceC0010a) {
        this.rZ = interfaceC0010a;
    }

    private a() {
        if (rX == null) {
            rX = new ArrayList<>(20);
        }
    }

    public static a ex() {
        if (rY == null) {
            rY = new a();
        }
        return rY;
    }

    public int getSize() {
        return rX.size();
    }

    public void i(Activity activity) {
        if (activity != null) {
            rX.add(new SoftReference<>(activity));
            z(this.sa);
        }
    }

    public Activity y(int i) {
        int size = rX.size();
        if (size == 0) {
            return null;
        }
        if (i < 0 || i >= size) {
            return null;
        }
        SoftReference<Activity> remove = rX.remove(i);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }

    public void j(Activity activity) {
        if (activity != null) {
            int size = rX.size();
            if (size == 0) {
                if (this.rZ != null) {
                    this.rZ.onActivityClosed();
                    return;
                }
                return;
            }
            for (int i = size - 1; i >= 0; i--) {
                SoftReference<Activity> softReference = rX.get(i);
                if (softReference == null) {
                    rX.remove(i);
                } else if (activity.equals(softReference.get())) {
                    rX.remove(i);
                    if (rX.size() == 0 && this.rZ != null) {
                        this.rZ.onActivityClosed();
                        return;
                    }
                    return;
                } else if (rX.size() == 0 && this.rZ != null) {
                    this.rZ.onActivityClosed();
                }
            }
        }
    }

    public Activity ey() {
        SoftReference<Activity> softReference;
        int size = rX.size();
        if (size != 0 && (softReference = rX.get(size - 1)) != null) {
            return softReference.get();
        }
        return null;
    }

    public void setActivityStackMaxSize(int i) {
        if (i >= 10 || i == 0) {
            this.sa = i;
        }
    }

    public void ez() {
        z(3);
    }

    public void eA() {
        Activity activity;
        if (rX != null) {
            while (!rX.isEmpty()) {
                SoftReference<Activity> remove = rX.remove(0);
                if (remove != null && remove.get() != null && (activity = remove.get()) != null) {
                    activity.finish();
                }
            }
        }
        if (this.rZ != null) {
            this.rZ.onActivityClosed();
        }
    }

    public int getActivityStackMaxSize() {
        return this.sa;
    }

    private void z(int i) {
        if (i != 0) {
            int size = ex().getSize();
            while (size > i) {
                size--;
                Activity y = ex().y(1);
                if (y != null) {
                    y.finish();
                }
            }
        }
    }

    public String eB() {
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        String str;
        Activity activity;
        String str2;
        if (rX == null || rX.size() == 0) {
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
        Iterator<SoftReference<Activity>> it = rX.iterator();
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
