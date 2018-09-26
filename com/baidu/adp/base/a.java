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
    private static ArrayList<SoftReference<Activity>> ut;
    private static a uu;
    private InterfaceC0010a uv;
    private int uw = 0;

    /* renamed from: com.baidu.adp.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0010a {
        void onActivityClosed();
    }

    public void a(InterfaceC0010a interfaceC0010a) {
        this.uv = interfaceC0010a;
    }

    private a() {
        if (ut == null) {
            ut = new ArrayList<>(20);
        }
    }

    public static a fE() {
        if (uu == null) {
            uu = new a();
        }
        return uu;
    }

    public int getSize() {
        return ut.size();
    }

    public void l(Activity activity) {
        if (activity != null) {
            ut.add(new SoftReference<>(activity));
            H(this.uw);
        }
    }

    public Activity G(int i) {
        int size = ut.size();
        if (size == 0) {
            return null;
        }
        if (i < 0 || i >= size) {
            return null;
        }
        SoftReference<Activity> remove = ut.remove(i);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }

    public void m(Activity activity) {
        if (activity != null) {
            int size = ut.size();
            if (size == 0) {
                if (this.uv != null) {
                    this.uv.onActivityClosed();
                    return;
                }
                return;
            }
            for (int i = size - 1; i >= 0; i--) {
                SoftReference<Activity> softReference = ut.get(i);
                if (softReference == null) {
                    ut.remove(i);
                } else if (activity.equals(softReference.get())) {
                    ut.remove(i);
                    if (ut.size() == 0 && this.uv != null) {
                        this.uv.onActivityClosed();
                        return;
                    }
                    return;
                } else if (ut.size() == 0 && this.uv != null) {
                    this.uv.onActivityClosed();
                }
            }
        }
    }

    public Activity fF() {
        SoftReference<Activity> softReference;
        int size = ut.size();
        if (size != 0 && (softReference = ut.get(size - 1)) != null) {
            return softReference.get();
        }
        return null;
    }

    public void setActivityStackMaxSize(int i) {
        if (i >= 10 || i == 0) {
            this.uw = i;
        }
    }

    public void fG() {
        H(3);
    }

    public void fH() {
        Activity activity;
        if (ut != null) {
            while (!ut.isEmpty()) {
                SoftReference<Activity> remove = ut.remove(0);
                if (remove != null && remove.get() != null && (activity = remove.get()) != null) {
                    activity.finish();
                }
            }
        }
        if (this.uv != null) {
            this.uv.onActivityClosed();
        }
    }

    public int getActivityStackMaxSize() {
        return this.uw;
    }

    private void H(int i) {
        if (i != 0) {
            int size = fE().getSize();
            while (size > i) {
                size--;
                Activity G = fE().G(1);
                if (G != null) {
                    G.finish();
                }
            }
        }
    }

    public String fI() {
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        String str;
        Activity activity;
        String str2;
        if (ut == null || ut.size() == 0) {
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
        Iterator<SoftReference<Activity>> it = ut.iterator();
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
