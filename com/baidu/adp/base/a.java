package com.baidu.adp.base;

import android.app.Activity;
import com.baidu.adp.lib.util.StringUtils;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class a {
    private static ArrayList<SoftReference<Activity>> np;
    private static a nq;
    private InterfaceC0000a nr;
    private int ns = 0;

    /* renamed from: com.baidu.adp.base.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0000a {
        void onActivityClosed();
    }

    public void a(InterfaceC0000a interfaceC0000a) {
        this.nr = interfaceC0000a;
    }

    private a() {
        if (np == null) {
            np = new ArrayList<>(20);
        }
    }

    public static a dF() {
        if (nq == null) {
            nq = new a();
        }
        return nq;
    }

    public int getSize() {
        return np.size();
    }

    public void g(Activity activity) {
        if (activity != null) {
            np.add(new SoftReference<>(activity));
            r(this.ns);
        }
    }

    public Activity q(int i) {
        int size = np.size();
        if (size == 0) {
            return null;
        }
        if (i < 0 || i >= size) {
            return null;
        }
        SoftReference<Activity> remove = np.remove(i);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }

    public void h(Activity activity) {
        if (activity != null) {
            int size = np.size();
            if (size == 0) {
                if (this.nr != null) {
                    this.nr.onActivityClosed();
                    return;
                }
                return;
            }
            for (int i = size - 1; i >= 0; i--) {
                SoftReference<Activity> softReference = np.get(i);
                if (softReference == null) {
                    np.remove(i);
                } else if (activity.equals(softReference.get())) {
                    np.remove(i);
                    if (np.size() == 0 && this.nr != null) {
                        this.nr.onActivityClosed();
                        return;
                    }
                    return;
                } else if (np.size() == 0 && this.nr != null) {
                    this.nr.onActivityClosed();
                }
            }
        }
    }

    public Activity dG() {
        SoftReference<Activity> softReference;
        int size = np.size();
        if (size != 0 && (softReference = np.get(size - 1)) != null) {
            return softReference.get();
        }
        return null;
    }

    public void setActivityStackMaxSize(int i) {
        if (i >= 10 || i == 0) {
            this.ns = i;
        }
    }

    public void dH() {
        r(3);
    }

    public void dI() {
        Activity activity;
        if (np != null) {
            while (!np.isEmpty()) {
                SoftReference<Activity> remove = np.remove(0);
                if (remove != null && remove.get() != null && (activity = remove.get()) != null) {
                    activity.finish();
                }
            }
        }
        if (this.nr != null) {
            this.nr.onActivityClosed();
        }
    }

    public int getActivityStackMaxSize() {
        return this.ns;
    }

    private void r(int i) {
        if (i != 0) {
            int size = dF().getSize();
            while (size > i) {
                size--;
                Activity q = dF().q(1);
                if (q != null) {
                    q.finish();
                }
            }
        }
    }

    public String dJ() {
        Activity activity;
        String str;
        if (np == null || np.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<SoftReference<Activity>> it = np.iterator();
        while (it.hasNext()) {
            SoftReference<Activity> next = it.next();
            if (next != null && (activity = next.get()) != null) {
                if (activity == null || activity.getClass() == null) {
                    str = "";
                } else {
                    str = activity.getClass().getSimpleName();
                }
                if (!StringUtils.isNull(str)) {
                    sb.append(String.valueOf(str) + ";");
                }
            }
        }
        return sb.toString();
    }
}
