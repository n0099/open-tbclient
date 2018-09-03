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
    private static ArrayList<SoftReference<Activity>> rQ;
    private static a rR;
    private InterfaceC0010a rS;
    private int rT = 0;

    /* renamed from: com.baidu.adp.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0010a {
        void onActivityClosed();
    }

    public void a(InterfaceC0010a interfaceC0010a) {
        this.rS = interfaceC0010a;
    }

    private a() {
        if (rQ == null) {
            rQ = new ArrayList<>(20);
        }
    }

    public static a ew() {
        if (rR == null) {
            rR = new a();
        }
        return rR;
    }

    public int getSize() {
        return rQ.size();
    }

    public void h(Activity activity) {
        if (activity != null) {
            rQ.add(new SoftReference<>(activity));
            z(this.rT);
        }
    }

    public Activity y(int i) {
        int size = rQ.size();
        if (size == 0) {
            return null;
        }
        if (i < 0 || i >= size) {
            return null;
        }
        SoftReference<Activity> remove = rQ.remove(i);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }

    public void i(Activity activity) {
        if (activity != null) {
            int size = rQ.size();
            if (size == 0) {
                if (this.rS != null) {
                    this.rS.onActivityClosed();
                    return;
                }
                return;
            }
            for (int i = size - 1; i >= 0; i--) {
                SoftReference<Activity> softReference = rQ.get(i);
                if (softReference == null) {
                    rQ.remove(i);
                } else if (activity.equals(softReference.get())) {
                    rQ.remove(i);
                    if (rQ.size() == 0 && this.rS != null) {
                        this.rS.onActivityClosed();
                        return;
                    }
                    return;
                } else if (rQ.size() == 0 && this.rS != null) {
                    this.rS.onActivityClosed();
                }
            }
        }
    }

    public Activity ex() {
        SoftReference<Activity> softReference;
        int size = rQ.size();
        if (size != 0 && (softReference = rQ.get(size - 1)) != null) {
            return softReference.get();
        }
        return null;
    }

    public void setActivityStackMaxSize(int i) {
        if (i >= 10 || i == 0) {
            this.rT = i;
        }
    }

    public void ey() {
        z(3);
    }

    public void ez() {
        Activity activity;
        if (rQ != null) {
            while (!rQ.isEmpty()) {
                SoftReference<Activity> remove = rQ.remove(0);
                if (remove != null && remove.get() != null && (activity = remove.get()) != null) {
                    activity.finish();
                }
            }
        }
        if (this.rS != null) {
            this.rS.onActivityClosed();
        }
    }

    public int getActivityStackMaxSize() {
        return this.rT;
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
        if (rQ == null || rQ.size() == 0) {
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
        Iterator<SoftReference<Activity>> it = rQ.iterator();
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
