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
    private static ArrayList<SoftReference<Activity>> rZ;
    private static a sa;
    private InterfaceC0010a sb;
    private int sc = 0;

    /* renamed from: com.baidu.adp.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0010a {
        void onActivityClosed();
    }

    public void a(InterfaceC0010a interfaceC0010a) {
        this.sb = interfaceC0010a;
    }

    private a() {
        if (rZ == null) {
            rZ = new ArrayList<>(20);
        }
    }

    public static a ex() {
        if (sa == null) {
            sa = new a();
        }
        return sa;
    }

    public int getSize() {
        return rZ.size();
    }

    public void i(Activity activity) {
        if (activity != null) {
            rZ.add(new SoftReference<>(activity));
            z(this.sc);
        }
    }

    public Activity y(int i) {
        int size = rZ.size();
        if (size == 0) {
            return null;
        }
        if (i < 0 || i >= size) {
            return null;
        }
        SoftReference<Activity> remove = rZ.remove(i);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }

    public void j(Activity activity) {
        if (activity != null) {
            int size = rZ.size();
            if (size == 0) {
                if (this.sb != null) {
                    this.sb.onActivityClosed();
                    return;
                }
                return;
            }
            for (int i = size - 1; i >= 0; i--) {
                SoftReference<Activity> softReference = rZ.get(i);
                if (softReference == null) {
                    rZ.remove(i);
                } else if (activity.equals(softReference.get())) {
                    rZ.remove(i);
                    if (rZ.size() == 0 && this.sb != null) {
                        this.sb.onActivityClosed();
                        return;
                    }
                    return;
                } else if (rZ.size() == 0 && this.sb != null) {
                    this.sb.onActivityClosed();
                }
            }
        }
    }

    public Activity ey() {
        SoftReference<Activity> softReference;
        int size = rZ.size();
        if (size != 0 && (softReference = rZ.get(size - 1)) != null) {
            return softReference.get();
        }
        return null;
    }

    public void setActivityStackMaxSize(int i) {
        if (i >= 10 || i == 0) {
            this.sc = i;
        }
    }

    public void ez() {
        z(3);
    }

    public void eA() {
        Activity activity;
        if (rZ != null) {
            while (!rZ.isEmpty()) {
                SoftReference<Activity> remove = rZ.remove(0);
                if (remove != null && remove.get() != null && (activity = remove.get()) != null) {
                    activity.finish();
                }
            }
        }
        if (this.sb != null) {
            this.sb.onActivityClosed();
        }
    }

    public int getActivityStackMaxSize() {
        return this.sc;
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
        if (rZ == null || rZ.size() == 0) {
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
        Iterator<SoftReference<Activity>> it = rZ.iterator();
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
