package com.baidu.adp.base;

import android.app.Activity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class a {
    private static ArrayList<SoftReference<Activity>> dk;
    private static a dl;
    private InterfaceC0002a dm;
    private int dn = 0;

    /* renamed from: com.baidu.adp.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0002a {
        void onActivityClosed();
    }

    public void a(InterfaceC0002a interfaceC0002a) {
        this.dm = interfaceC0002a;
    }

    private a() {
        if (dk == null) {
            dk = new ArrayList<>(20);
        }
    }

    public static a X() {
        if (dl == null) {
            dl = new a();
        }
        return dl;
    }

    public int getSize() {
        return dk.size();
    }

    public void b(Activity activity) {
        if (activity != null) {
            dk.add(new SoftReference<>(activity));
            p(this.dn);
        }
    }

    public Activity o(int i) {
        int size = dk.size();
        if (size == 0) {
            return null;
        }
        if (i < 0 || i >= size) {
            return null;
        }
        SoftReference<Activity> remove = dk.remove(i);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }

    public void c(Activity activity) {
        if (activity != null) {
            int size = dk.size();
            if (size == 0) {
                if (this.dm != null) {
                    this.dm.onActivityClosed();
                    return;
                }
                return;
            }
            for (int i = size - 1; i >= 0; i--) {
                SoftReference<Activity> softReference = dk.get(i);
                if (softReference == null) {
                    dk.remove(i);
                } else if (activity.equals(softReference.get())) {
                    dk.remove(i);
                    if (dk.size() == 0 && this.dm != null) {
                        this.dm.onActivityClosed();
                        return;
                    }
                    return;
                } else if (dk.size() == 0 && this.dm != null) {
                    this.dm.onActivityClosed();
                }
            }
        }
    }

    public Activity Y() {
        SoftReference<Activity> softReference;
        int size = dk.size();
        if (size != 0 && (softReference = dk.get(size - 1)) != null) {
            return softReference.get();
        }
        return null;
    }

    public void setActivityStackMaxSize(int i) {
        if (i >= 10 || i == 0) {
            this.dn = i;
        }
    }

    public void Z() {
        p(3);
    }

    public void aa() {
        Activity activity;
        if (dk != null) {
            while (!dk.isEmpty()) {
                SoftReference<Activity> remove = dk.remove(0);
                if (remove != null && remove.get() != null && (activity = remove.get()) != null) {
                    activity.finish();
                }
            }
        }
        if (this.dm != null) {
            this.dm.onActivityClosed();
        }
    }

    public int getActivityStackMaxSize() {
        return this.dn;
    }

    private void p(int i) {
        if (i != 0) {
            int size = X().getSize();
            while (size > i) {
                size--;
                Activity o = X().o(1);
                if (o != null) {
                    o.finish();
                }
            }
        }
    }

    public String ab() {
        Activity activity;
        String str;
        if (dk == null || dk.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<SoftReference<Activity>> it = dk.iterator();
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
