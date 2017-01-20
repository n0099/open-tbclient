package com.baidu.adp.base;

import android.app.Activity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class a {
    private static ArrayList<SoftReference<Activity>> fY;
    private static a fZ;
    private InterfaceC0001a ga;
    private int gb = 0;

    /* renamed from: com.baidu.adp.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0001a {
        void onActivityClosed();
    }

    public void a(InterfaceC0001a interfaceC0001a) {
        this.ga = interfaceC0001a;
    }

    private a() {
        if (fY == null) {
            fY = new ArrayList<>(20);
        }
    }

    public static a aS() {
        if (fZ == null) {
            fZ = new a();
        }
        return fZ;
    }

    public int getSize() {
        return fY.size();
    }

    public void h(Activity activity) {
        if (activity != null) {
            fY.add(new SoftReference<>(activity));
            G(this.gb);
        }
    }

    public Activity F(int i) {
        int size = fY.size();
        if (size == 0) {
            return null;
        }
        if (i < 0 || i >= size) {
            return null;
        }
        SoftReference<Activity> remove = fY.remove(i);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }

    public void i(Activity activity) {
        if (activity != null) {
            int size = fY.size();
            if (size == 0) {
                if (this.ga != null) {
                    this.ga.onActivityClosed();
                    return;
                }
                return;
            }
            for (int i = size - 1; i >= 0; i--) {
                SoftReference<Activity> softReference = fY.get(i);
                if (softReference == null) {
                    fY.remove(i);
                } else if (activity.equals(softReference.get())) {
                    fY.remove(i);
                    if (fY.size() == 0 && this.ga != null) {
                        this.ga.onActivityClosed();
                        return;
                    }
                    return;
                } else if (fY.size() == 0 && this.ga != null) {
                    this.ga.onActivityClosed();
                }
            }
        }
    }

    public Activity aT() {
        SoftReference<Activity> softReference;
        int size = fY.size();
        if (size != 0 && (softReference = fY.get(size - 1)) != null) {
            return softReference.get();
        }
        return null;
    }

    public void setActivityStackMaxSize(int i) {
        if (i >= 10 || i == 0) {
            this.gb = i;
        }
    }

    public void aU() {
        G(3);
    }

    public void aV() {
        Activity activity;
        if (fY != null) {
            while (!fY.isEmpty()) {
                SoftReference<Activity> remove = fY.remove(0);
                if (remove != null && remove.get() != null && (activity = remove.get()) != null) {
                    activity.finish();
                }
            }
        }
        if (this.ga != null) {
            this.ga.onActivityClosed();
        }
    }

    public int getActivityStackMaxSize() {
        return this.gb;
    }

    private void G(int i) {
        if (i != 0) {
            int size = aS().getSize();
            while (size > i) {
                size--;
                Activity F = aS().F(1);
                if (F != null) {
                    F.finish();
                }
            }
        }
    }

    public String aW() {
        Activity activity;
        String str;
        if (fY == null || fY.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<SoftReference<Activity>> it = fY.iterator();
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
