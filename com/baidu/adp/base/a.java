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
    private static ArrayList<SoftReference<Activity>> lD;
    private static a lE;
    private InterfaceC0002a lF;
    private int lG = 0;

    /* renamed from: com.baidu.adp.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0002a {
        void onActivityClosed();
    }

    public void a(InterfaceC0002a interfaceC0002a) {
        this.lF = interfaceC0002a;
    }

    private a() {
        if (lD == null) {
            lD = new ArrayList<>(20);
        }
    }

    public static a bJ() {
        if (lE == null) {
            lE = new a();
        }
        return lE;
    }

    public int getSize() {
        return lD.size();
    }

    public void j(Activity activity) {
        if (activity != null) {
            lD.add(new SoftReference<>(activity));
            x(this.lG);
        }
    }

    public Activity w(int i) {
        int size = lD.size();
        if (size == 0) {
            return null;
        }
        if (i < 0 || i >= size) {
            return null;
        }
        SoftReference<Activity> remove = lD.remove(i);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }

    public void k(Activity activity) {
        if (activity != null) {
            int size = lD.size();
            if (size == 0) {
                if (this.lF != null) {
                    this.lF.onActivityClosed();
                    return;
                }
                return;
            }
            for (int i = size - 1; i >= 0; i--) {
                SoftReference<Activity> softReference = lD.get(i);
                if (softReference == null) {
                    lD.remove(i);
                } else if (activity.equals(softReference.get())) {
                    lD.remove(i);
                    if (lD.size() == 0 && this.lF != null) {
                        this.lF.onActivityClosed();
                        return;
                    }
                    return;
                } else if (lD.size() == 0 && this.lF != null) {
                    this.lF.onActivityClosed();
                }
            }
        }
    }

    public Activity bK() {
        SoftReference<Activity> softReference;
        int size = lD.size();
        if (size != 0 && (softReference = lD.get(size - 1)) != null) {
            return softReference.get();
        }
        return null;
    }

    public void setActivityStackMaxSize(int i) {
        if (i >= 10 || i == 0) {
            this.lG = i;
        }
    }

    public void bL() {
        x(3);
    }

    public void bM() {
        Activity activity;
        if (lD != null) {
            while (!lD.isEmpty()) {
                SoftReference<Activity> remove = lD.remove(0);
                if (remove != null && remove.get() != null && (activity = remove.get()) != null) {
                    activity.finish();
                }
            }
        }
        if (this.lF != null) {
            this.lF.onActivityClosed();
        }
    }

    public int getActivityStackMaxSize() {
        return this.lG;
    }

    private void x(int i) {
        if (i != 0) {
            int size = bJ().getSize();
            while (size > i) {
                size--;
                Activity w = bJ().w(1);
                if (w != null) {
                    w.finish();
                }
            }
        }
    }

    public String bN() {
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        String str;
        Activity activity;
        String str2;
        if (lD == null || lD.size() == 0) {
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
        Iterator<SoftReference<Activity>> it = lD.iterator();
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
