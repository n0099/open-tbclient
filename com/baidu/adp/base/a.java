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
    private static ArrayList<SoftReference<Activity>> abp;
    private static a abq;
    private InterfaceC0013a abr;
    private int abt = 0;

    /* renamed from: com.baidu.adp.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0013a {
        void onActivityClosed();
    }

    public void a(InterfaceC0013a interfaceC0013a) {
        this.abr = interfaceC0013a;
    }

    private a() {
        if (abp == null) {
            abp = new ArrayList<>(20);
        }
    }

    public static a jF() {
        if (abq == null) {
            abq = new a();
        }
        return abq;
    }

    public int getSize() {
        return abp.size();
    }

    public void j(Activity activity) {
        if (activity != null) {
            abp.add(new SoftReference<>(activity));
            cx(this.abt);
        }
    }

    public Activity cw(int i) {
        int size = abp.size();
        if (size == 0) {
            return null;
        }
        if (i < 0 || i >= size) {
            return null;
        }
        SoftReference<Activity> remove = abp.remove(i);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }

    public void k(Activity activity) {
        if (activity != null) {
            int size = abp.size();
            if (size == 0) {
                if (this.abr != null) {
                    this.abr.onActivityClosed();
                    return;
                }
                return;
            }
            for (int i = size - 1; i >= 0; i--) {
                SoftReference<Activity> softReference = abp.get(i);
                if (softReference == null) {
                    abp.remove(i);
                } else if (activity.equals(softReference.get())) {
                    abp.remove(i);
                    if (abp.size() == 0 && this.abr != null) {
                        this.abr.onActivityClosed();
                        return;
                    }
                    return;
                } else if (abp.size() == 0 && this.abr != null) {
                    this.abr.onActivityClosed();
                }
            }
        }
    }

    public Activity jG() {
        SoftReference<Activity> softReference;
        int size = abp.size();
        if (size != 0 && (softReference = abp.get(size - 1)) != null) {
            return softReference.get();
        }
        return null;
    }

    public void setActivityStackMaxSize(int i) {
        if (i >= 10 || i == 0) {
            this.abt = i;
        }
    }

    public void jH() {
        cx(3);
    }

    public void jI() {
        Activity activity;
        if (abp != null) {
            while (!abp.isEmpty()) {
                SoftReference<Activity> remove = abp.remove(0);
                if (remove != null && remove.get() != null && (activity = remove.get()) != null) {
                    activity.finish();
                }
            }
        }
        if (this.abr != null) {
            this.abr.onActivityClosed();
        }
    }

    public int getActivityStackMaxSize() {
        return this.abt;
    }

    private void cx(int i) {
        if (i != 0) {
            int size = jF().getSize();
            while (size > i) {
                size--;
                Activity cw = jF().cw(1);
                if (cw != null) {
                    cw.finish();
                }
            }
        }
    }

    public String jJ() {
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        String str;
        Activity activity;
        String str2;
        if (abp == null || abp.size() == 0) {
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
        Iterator<SoftReference<Activity>> it = abp.iterator();
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
