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
    private static ArrayList<SoftReference<Activity>> vg;
    private static a vh;
    private InterfaceC0013a vi;
    private int vj = 0;

    /* renamed from: com.baidu.adp.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0013a {
        void onActivityClosed();
    }

    public void a(InterfaceC0013a interfaceC0013a) {
        this.vi = interfaceC0013a;
    }

    private a() {
        if (vg == null) {
            vg = new ArrayList<>(20);
        }
    }

    public static a fW() {
        if (vh == null) {
            vh = new a();
        }
        return vh;
    }

    public int getSize() {
        return vg.size();
    }

    public void l(Activity activity) {
        if (activity != null) {
            vg.add(new SoftReference<>(activity));
            H(this.vj);
        }
    }

    public Activity G(int i) {
        int size = vg.size();
        if (size == 0) {
            return null;
        }
        if (i < 0 || i >= size) {
            return null;
        }
        SoftReference<Activity> remove = vg.remove(i);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }

    public void m(Activity activity) {
        if (activity != null) {
            int size = vg.size();
            if (size == 0) {
                if (this.vi != null) {
                    this.vi.onActivityClosed();
                    return;
                }
                return;
            }
            for (int i = size - 1; i >= 0; i--) {
                SoftReference<Activity> softReference = vg.get(i);
                if (softReference == null) {
                    vg.remove(i);
                } else if (activity.equals(softReference.get())) {
                    vg.remove(i);
                    if (vg.size() == 0 && this.vi != null) {
                        this.vi.onActivityClosed();
                        return;
                    }
                    return;
                } else if (vg.size() == 0 && this.vi != null) {
                    this.vi.onActivityClosed();
                }
            }
        }
    }

    public Activity fX() {
        SoftReference<Activity> softReference;
        int size = vg.size();
        if (size != 0 && (softReference = vg.get(size - 1)) != null) {
            return softReference.get();
        }
        return null;
    }

    public void setActivityStackMaxSize(int i) {
        if (i >= 10 || i == 0) {
            this.vj = i;
        }
    }

    public void fY() {
        H(3);
    }

    public void fZ() {
        Activity activity;
        if (vg != null) {
            while (!vg.isEmpty()) {
                SoftReference<Activity> remove = vg.remove(0);
                if (remove != null && remove.get() != null && (activity = remove.get()) != null) {
                    activity.finish();
                }
            }
        }
        if (this.vi != null) {
            this.vi.onActivityClosed();
        }
    }

    public int getActivityStackMaxSize() {
        return this.vj;
    }

    private void H(int i) {
        if (i != 0) {
            int size = fW().getSize();
            while (size > i) {
                size--;
                Activity G = fW().G(1);
                if (G != null) {
                    G.finish();
                }
            }
        }
    }

    public String ga() {
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        String str;
        Activity activity;
        String str2;
        if (vg == null || vg.size() == 0) {
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
        Iterator<SoftReference<Activity>> it = vg.iterator();
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
