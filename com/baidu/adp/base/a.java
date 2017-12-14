package com.baidu.adp.base;

import android.app.Activity;
import android.app.ActivityManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class a {
    private static ArrayList<SoftReference<Activity>> mI;
    private static a mJ;
    private InterfaceC0000a mK;
    private int mL = 0;

    /* renamed from: com.baidu.adp.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0000a {
        void onActivityClosed();
    }

    public void a(InterfaceC0000a interfaceC0000a) {
        this.mK = interfaceC0000a;
    }

    private a() {
        if (mI == null) {
            mI = new ArrayList<>(20);
        }
    }

    public static a ca() {
        if (mJ == null) {
            mJ = new a();
        }
        return mJ;
    }

    public int getSize() {
        return mI.size();
    }

    public void h(Activity activity) {
        if (activity != null) {
            mI.add(new SoftReference<>(activity));
            D(this.mL);
        }
    }

    public Activity C(int i) {
        int size = mI.size();
        if (size == 0) {
            return null;
        }
        if (i < 0 || i >= size) {
            return null;
        }
        SoftReference<Activity> remove = mI.remove(i);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }

    public void i(Activity activity) {
        if (activity != null) {
            int size = mI.size();
            if (size == 0) {
                if (this.mK != null) {
                    this.mK.onActivityClosed();
                    return;
                }
                return;
            }
            for (int i = size - 1; i >= 0; i--) {
                SoftReference<Activity> softReference = mI.get(i);
                if (softReference == null) {
                    mI.remove(i);
                } else if (activity.equals(softReference.get())) {
                    mI.remove(i);
                    if (mI.size() == 0 && this.mK != null) {
                        this.mK.onActivityClosed();
                        return;
                    }
                    return;
                } else if (mI.size() == 0 && this.mK != null) {
                    this.mK.onActivityClosed();
                }
            }
        }
    }

    public Activity cb() {
        SoftReference<Activity> softReference;
        int size = mI.size();
        if (size != 0 && (softReference = mI.get(size - 1)) != null) {
            return softReference.get();
        }
        return null;
    }

    public void setActivityStackMaxSize(int i) {
        if (i >= 10 || i == 0) {
            this.mL = i;
        }
    }

    public void cc() {
        D(3);
    }

    public void cd() {
        Activity activity;
        if (mI != null) {
            while (!mI.isEmpty()) {
                SoftReference<Activity> remove = mI.remove(0);
                if (remove != null && remove.get() != null && (activity = remove.get()) != null) {
                    activity.finish();
                }
            }
        }
        if (this.mK != null) {
            this.mK.onActivityClosed();
        }
    }

    public int getActivityStackMaxSize() {
        return this.mL;
    }

    private void D(int i) {
        if (i != 0) {
            int size = ca().getSize();
            while (size > i) {
                size--;
                Activity C = ca().C(1);
                if (C != null) {
                    C.finish();
                }
            }
        }
    }

    public String ce() {
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        String str;
        Activity activity;
        String str2;
        if (mI == null || mI.size() == 0) {
            try {
                if (BdBaseApplication.getInst() != null && (activityManager = (ActivityManager) BdBaseApplication.getInst().getSystemService("activity")) != null && (runningTasks = activityManager.getRunningTasks(1)) != null && runningTasks.size() > 0) {
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
        Iterator<SoftReference<Activity>> it = mI.iterator();
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
