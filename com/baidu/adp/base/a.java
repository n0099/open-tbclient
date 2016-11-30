package com.baidu.adp.base;

import android.app.Activity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class a {
    private static ArrayList<SoftReference<Activity>> gb;
    private static a gc;
    private InterfaceC0002a gd;
    private int ge = 0;

    /* renamed from: com.baidu.adp.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0002a {
        void onActivityClosed();
    }

    public void a(InterfaceC0002a interfaceC0002a) {
        this.gd = interfaceC0002a;
    }

    private a() {
        if (gb == null) {
            gb = new ArrayList<>(20);
        }
    }

    public static a aS() {
        if (gc == null) {
            gc = new a();
        }
        return gc;
    }

    public int getSize() {
        return gb.size();
    }

    public void h(Activity activity) {
        if (activity != null) {
            gb.add(new SoftReference<>(activity));
            F(this.ge);
        }
    }

    public Activity E(int i) {
        int size = gb.size();
        if (size == 0) {
            return null;
        }
        if (i < 0 || i >= size) {
            return null;
        }
        SoftReference<Activity> remove = gb.remove(i);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }

    public void i(Activity activity) {
        if (activity != null) {
            int size = gb.size();
            if (size == 0) {
                if (this.gd != null) {
                    this.gd.onActivityClosed();
                    return;
                }
                return;
            }
            for (int i = size - 1; i >= 0; i--) {
                SoftReference<Activity> softReference = gb.get(i);
                if (softReference == null) {
                    gb.remove(i);
                } else if (activity.equals(softReference.get())) {
                    gb.remove(i);
                    if (gb.size() == 0 && this.gd != null) {
                        this.gd.onActivityClosed();
                        return;
                    }
                    return;
                } else if (gb.size() == 0 && this.gd != null) {
                    this.gd.onActivityClosed();
                }
            }
        }
    }

    public Activity aT() {
        SoftReference<Activity> softReference;
        int size = gb.size();
        if (size != 0 && (softReference = gb.get(size - 1)) != null) {
            return softReference.get();
        }
        return null;
    }

    public void setActivityStackMaxSize(int i) {
        if (i >= 10 || i == 0) {
            this.ge = i;
        }
    }

    public void aU() {
        F(3);
    }

    public void aV() {
        Activity activity;
        if (gb != null) {
            while (!gb.isEmpty()) {
                SoftReference<Activity> remove = gb.remove(0);
                if (remove != null && remove.get() != null && (activity = remove.get()) != null) {
                    activity.finish();
                }
            }
        }
        if (this.gd != null) {
            this.gd.onActivityClosed();
        }
    }

    public int getActivityStackMaxSize() {
        return this.ge;
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
        if (gb == null || gb.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<SoftReference<Activity>> it = gb.iterator();
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
