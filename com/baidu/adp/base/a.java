package com.baidu.adp.base;

import android.app.Activity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class a {
    private static ArrayList<SoftReference<Activity>> oX;
    private static a oY;
    private InterfaceC0000a oZ;
    private int pa = 0;

    /* renamed from: com.baidu.adp.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0000a {
        void onActivityClosed();
    }

    public void a(InterfaceC0000a interfaceC0000a) {
        this.oZ = interfaceC0000a;
    }

    private a() {
        if (oX == null) {
            oX = new ArrayList<>(20);
        }
    }

    public static a cl() {
        if (oY == null) {
            oY = new a();
        }
        return oY;
    }

    public int getSize() {
        return oX.size();
    }

    public void h(Activity activity) {
        if (activity != null) {
            oX.add(new SoftReference<>(activity));
            H(this.pa);
        }
    }

    public Activity G(int i) {
        int size = oX.size();
        if (size == 0) {
            return null;
        }
        if (i < 0 || i >= size) {
            return null;
        }
        SoftReference<Activity> remove = oX.remove(i);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }

    public void i(Activity activity) {
        if (activity != null) {
            int size = oX.size();
            if (size == 0) {
                if (this.oZ != null) {
                    this.oZ.onActivityClosed();
                    return;
                }
                return;
            }
            for (int i = size - 1; i >= 0; i--) {
                SoftReference<Activity> softReference = oX.get(i);
                if (softReference == null) {
                    oX.remove(i);
                } else if (activity.equals(softReference.get())) {
                    oX.remove(i);
                    if (oX.size() == 0 && this.oZ != null) {
                        this.oZ.onActivityClosed();
                        return;
                    }
                    return;
                } else if (oX.size() == 0 && this.oZ != null) {
                    this.oZ.onActivityClosed();
                }
            }
        }
    }

    public Activity cm() {
        SoftReference<Activity> softReference;
        int size = oX.size();
        if (size != 0 && (softReference = oX.get(size - 1)) != null) {
            return softReference.get();
        }
        return null;
    }

    public void setActivityStackMaxSize(int i) {
        if (i >= 10 || i == 0) {
            this.pa = i;
        }
    }

    public void cn() {
        H(3);
    }

    public void co() {
        Activity activity;
        if (oX != null) {
            while (!oX.isEmpty()) {
                SoftReference<Activity> remove = oX.remove(0);
                if (remove != null && remove.get() != null && (activity = remove.get()) != null) {
                    activity.finish();
                }
            }
        }
        if (this.oZ != null) {
            this.oZ.onActivityClosed();
        }
    }

    public int getActivityStackMaxSize() {
        return this.pa;
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
        if (oX == null || oX.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<SoftReference<Activity>> it = oX.iterator();
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
