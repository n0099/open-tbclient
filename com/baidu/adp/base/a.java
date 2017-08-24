package com.baidu.adp.base;

import android.app.Activity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class a {
    private static ArrayList<SoftReference<Activity>> oY;
    private static a oZ;
    private InterfaceC0000a pa;
    private int pd = 0;

    /* renamed from: com.baidu.adp.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0000a {
        void onActivityClosed();
    }

    public void a(InterfaceC0000a interfaceC0000a) {
        this.pa = interfaceC0000a;
    }

    private a() {
        if (oY == null) {
            oY = new ArrayList<>(20);
        }
    }

    public static a cl() {
        if (oZ == null) {
            oZ = new a();
        }
        return oZ;
    }

    public int getSize() {
        return oY.size();
    }

    public void h(Activity activity) {
        if (activity != null) {
            oY.add(new SoftReference<>(activity));
            H(this.pd);
        }
    }

    public Activity G(int i) {
        int size = oY.size();
        if (size == 0) {
            return null;
        }
        if (i < 0 || i >= size) {
            return null;
        }
        SoftReference<Activity> remove = oY.remove(i);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }

    public void i(Activity activity) {
        if (activity != null) {
            int size = oY.size();
            if (size == 0) {
                if (this.pa != null) {
                    this.pa.onActivityClosed();
                    return;
                }
                return;
            }
            for (int i = size - 1; i >= 0; i--) {
                SoftReference<Activity> softReference = oY.get(i);
                if (softReference == null) {
                    oY.remove(i);
                } else if (activity.equals(softReference.get())) {
                    oY.remove(i);
                    if (oY.size() == 0 && this.pa != null) {
                        this.pa.onActivityClosed();
                        return;
                    }
                    return;
                } else if (oY.size() == 0 && this.pa != null) {
                    this.pa.onActivityClosed();
                }
            }
        }
    }

    public Activity cm() {
        SoftReference<Activity> softReference;
        int size = oY.size();
        if (size != 0 && (softReference = oY.get(size - 1)) != null) {
            return softReference.get();
        }
        return null;
    }

    public void setActivityStackMaxSize(int i) {
        if (i >= 10 || i == 0) {
            this.pd = i;
        }
    }

    public void cn() {
        H(3);
    }

    public void co() {
        Activity activity;
        if (oY != null) {
            while (!oY.isEmpty()) {
                SoftReference<Activity> remove = oY.remove(0);
                if (remove != null && remove.get() != null && (activity = remove.get()) != null) {
                    activity.finish();
                }
            }
        }
        if (this.pa != null) {
            this.pa.onActivityClosed();
        }
    }

    public int getActivityStackMaxSize() {
        return this.pd;
    }

    private void H(int i) {
        if (i != 0) {
            int size = cl().getSize();
            while (size > i) {
                size--;
                Activity G = cl().G(1);
                if (G != null) {
                    G.finish();
                }
            }
        }
    }

    public String cp() {
        Activity activity;
        String str;
        if (oY == null || oY.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<SoftReference<Activity>> it = oY.iterator();
        while (it.hasNext()) {
            SoftReference<Activity> next = it.next();
            if (next != null && (activity = next.get()) != null) {
                if (activity == null || activity.getClass() == null) {
                    str = "";
                } else {
                    str = activity.getClass().getSimpleName();
                }
                if (!StringUtils.isNull(str)) {
                    sb.append(str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                }
            }
        }
        return sb.toString();
    }
}
