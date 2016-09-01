package com.baidu.adp.base;

import android.app.Activity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class a {
    private static ArrayList<SoftReference<Activity>> ga;
    private static a gb;
    private InterfaceC0002a gc;
    private int gd = 0;

    /* renamed from: com.baidu.adp.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0002a {
        void onActivityClosed();
    }

    public void a(InterfaceC0002a interfaceC0002a) {
        this.gc = interfaceC0002a;
    }

    private a() {
        if (ga == null) {
            ga = new ArrayList<>(20);
        }
    }

    public static a aS() {
        if (gb == null) {
            gb = new a();
        }
        return gb;
    }

    public int getSize() {
        return ga.size();
    }

    public void h(Activity activity) {
        if (activity != null) {
            ga.add(new SoftReference<>(activity));
            F(this.gd);
        }
    }

    public Activity E(int i) {
        int size = ga.size();
        if (size == 0) {
            return null;
        }
        if (i < 0 || i >= size) {
            return null;
        }
        SoftReference<Activity> remove = ga.remove(i);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }

    public void i(Activity activity) {
        if (activity != null) {
            int size = ga.size();
            if (size == 0) {
                if (this.gc != null) {
                    this.gc.onActivityClosed();
                    return;
                }
                return;
            }
            for (int i = size - 1; i >= 0; i--) {
                SoftReference<Activity> softReference = ga.get(i);
                if (softReference == null) {
                    ga.remove(i);
                } else if (activity.equals(softReference.get())) {
                    ga.remove(i);
                    if (ga.size() == 0 && this.gc != null) {
                        this.gc.onActivityClosed();
                        return;
                    }
                    return;
                } else if (ga.size() == 0 && this.gc != null) {
                    this.gc.onActivityClosed();
                }
            }
        }
    }

    public Activity aT() {
        SoftReference<Activity> softReference;
        int size = ga.size();
        if (size != 0 && (softReference = ga.get(size - 1)) != null) {
            return softReference.get();
        }
        return null;
    }

    public void setActivityStackMaxSize(int i) {
        if (i >= 10 || i == 0) {
            this.gd = i;
        }
    }

    public void aU() {
        F(3);
    }

    public void aV() {
        Activity activity;
        if (ga != null) {
            while (!ga.isEmpty()) {
                SoftReference<Activity> remove = ga.remove(0);
                if (remove != null && remove.get() != null && (activity = remove.get()) != null) {
                    activity.finish();
                }
            }
        }
        if (this.gc != null) {
            this.gc.onActivityClosed();
        }
    }

    public int getActivityStackMaxSize() {
        return this.gd;
    }

    private void F(int i) {
        if (i != 0) {
            int size = aS().getSize();
            while (size > i) {
                size--;
                Activity E = aS().E(1);
                if (E != null) {
                    E.finish();
                }
            }
        }
    }

    public String aW() {
        Activity activity;
        String str;
        if (ga == null || ga.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<SoftReference<Activity>> it = ga.iterator();
        while (it.hasNext()) {
            SoftReference<Activity> next = it.next();
            if (next != null && (activity = next.get()) != null) {
                if (activity == null || activity.getClass() == null) {
                    str = "";
                } else {
                    str = activity.getClass().getSimpleName();
                }
                if (!StringUtils.isNull(str)) {
                    sb.append(String.valueOf(str) + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                }
            }
        }
        return sb.toString();
    }
}
