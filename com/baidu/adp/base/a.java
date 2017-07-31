package com.baidu.adp.base;

import android.app.Activity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class a {
    private static ArrayList<SoftReference<Activity>> oV;
    private static a oW;
    private InterfaceC0001a oX;
    private int oY = 0;

    /* renamed from: com.baidu.adp.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0001a {
        void onActivityClosed();
    }

    public void a(InterfaceC0001a interfaceC0001a) {
        this.oX = interfaceC0001a;
    }

    private a() {
        if (oV == null) {
            oV = new ArrayList<>(20);
        }
    }

    public static a cl() {
        if (oW == null) {
            oW = new a();
        }
        return oW;
    }

    public int getSize() {
        return oV.size();
    }

    public void h(Activity activity) {
        if (activity != null) {
            oV.add(new SoftReference<>(activity));
            H(this.oY);
        }
    }

    public Activity G(int i) {
        int size = oV.size();
        if (size == 0) {
            return null;
        }
        if (i < 0 || i >= size) {
            return null;
        }
        SoftReference<Activity> remove = oV.remove(i);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }

    public void i(Activity activity) {
        if (activity != null) {
            int size = oV.size();
            if (size == 0) {
                if (this.oX != null) {
                    this.oX.onActivityClosed();
                    return;
                }
                return;
            }
            for (int i = size - 1; i >= 0; i--) {
                SoftReference<Activity> softReference = oV.get(i);
                if (softReference == null) {
                    oV.remove(i);
                } else if (activity.equals(softReference.get())) {
                    oV.remove(i);
                    if (oV.size() == 0 && this.oX != null) {
                        this.oX.onActivityClosed();
                        return;
                    }
                    return;
                } else if (oV.size() == 0 && this.oX != null) {
                    this.oX.onActivityClosed();
                }
            }
        }
    }

    public Activity cm() {
        SoftReference<Activity> softReference;
        int size = oV.size();
        if (size != 0 && (softReference = oV.get(size - 1)) != null) {
            return softReference.get();
        }
        return null;
    }

    public void setActivityStackMaxSize(int i) {
        if (i >= 10 || i == 0) {
            this.oY = i;
        }
    }

    public void cn() {
        H(3);
    }

    public void co() {
        Activity activity;
        if (oV != null) {
            while (!oV.isEmpty()) {
                SoftReference<Activity> remove = oV.remove(0);
                if (remove != null && remove.get() != null && (activity = remove.get()) != null) {
                    activity.finish();
                }
            }
        }
        if (this.oX != null) {
            this.oX.onActivityClosed();
        }
    }

    public int getActivityStackMaxSize() {
        return this.oY;
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
        if (oV == null || oV.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<SoftReference<Activity>> it = oV.iterator();
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
