package com.baidu.adp.base;

import android.app.Activity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class a {
    private static ArrayList<SoftReference<Activity>> dN;
    private static a dO;
    private InterfaceC0002a dP;
    private int dQ = 0;

    /* renamed from: com.baidu.adp.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0002a {
        void onActivityClosed();
    }

    public void a(InterfaceC0002a interfaceC0002a) {
        this.dP = interfaceC0002a;
    }

    private a() {
        if (dN == null) {
            dN = new ArrayList<>(20);
        }
    }

    public static a X() {
        if (dO == null) {
            dO = new a();
        }
        return dO;
    }

    public int getSize() {
        return dN.size();
    }

    public void d(Activity activity) {
        if (activity != null) {
            dN.add(new SoftReference<>(activity));
            s(this.dQ);
        }
    }

    public Activity r(int i) {
        int size = dN.size();
        if (size == 0) {
            return null;
        }
        if (i < 0 || i >= size) {
            return null;
        }
        SoftReference<Activity> remove = dN.remove(i);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }

    public void e(Activity activity) {
        if (activity != null) {
            int size = dN.size();
            if (size == 0) {
                if (this.dP != null) {
                    this.dP.onActivityClosed();
                    return;
                }
                return;
            }
            for (int i = size - 1; i >= 0; i--) {
                SoftReference<Activity> softReference = dN.get(i);
                if (softReference == null) {
                    dN.remove(i);
                } else if (activity.equals(softReference.get())) {
                    dN.remove(i);
                    if (dN.size() == 0 && this.dP != null) {
                        this.dP.onActivityClosed();
                        return;
                    }
                    return;
                } else if (dN.size() == 0 && this.dP != null) {
                    this.dP.onActivityClosed();
                }
            }
        }
    }

    public Activity Y() {
        SoftReference<Activity> softReference;
        int size = dN.size();
        if (size != 0 && (softReference = dN.get(size - 1)) != null) {
            return softReference.get();
        }
        return null;
    }

    public void setActivityStackMaxSize(int i) {
        if (i >= 10 || i == 0) {
            this.dQ = i;
        }
    }

    public void Z() {
        s(3);
    }

    public void aa() {
        Activity activity;
        if (dN != null) {
            while (!dN.isEmpty()) {
                SoftReference<Activity> remove = dN.remove(0);
                if (remove != null && remove.get() != null && (activity = remove.get()) != null) {
                    activity.finish();
                }
            }
        }
        if (this.dP != null) {
            this.dP.onActivityClosed();
        }
    }

    public int getActivityStackMaxSize() {
        return this.dQ;
    }

    private void s(int i) {
        if (i != 0) {
            int size = X().getSize();
            while (size > i) {
                size--;
                Activity r = X().r(1);
                if (r != null) {
                    r.finish();
                }
            }
        }
    }

    public String ab() {
        Activity activity;
        String str;
        if (dN == null || dN.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<SoftReference<Activity>> it = dN.iterator();
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
