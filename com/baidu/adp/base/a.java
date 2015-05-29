package com.baidu.adp.base;

import android.app.Activity;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.proxy.activity.ActivityProxy;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class a {
    private static ArrayList<SoftReference<Activity>> np;
    private static a nq;
    private b nr;
    private int ns = 0;

    public void a(b bVar) {
        this.nr = bVar;
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
            o(this.ns);
        }
    }

    public Activity n(int i) {
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
                } else if (size == 0 && this.nr != null) {
                    this.nr.onActivityClosed();
                }
            }
        }
    }

    public void setActivityStackMaxSize(int i) {
        if (i >= 10 || i == 0) {
            this.ns = i;
        }
    }

    public void dG() {
        o(3);
    }

    public void dH() {
        if (np != null) {
            while (!np.isEmpty()) {
                SoftReference<Activity> remove = np.remove(0);
                if (remove != null && remove.get() != null) {
                    remove.get().finish();
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

    private void o(int i) {
        if (i != 0) {
            int size = dF().getSize();
            while (size > i) {
                size--;
                Activity n = dF().n(1);
                if (n != null) {
                    n.finish();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x005b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x001a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String dI() {
        String simpleName;
        if (np == null || np.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<SoftReference<Activity>> it = np.iterator();
        while (it.hasNext()) {
            SoftReference<Activity> next = it.next();
            if (next != null && next.get() != null) {
                Activity activity = next.get();
                if (activity instanceof ActivityProxy) {
                    com.baidu.adp.plugin.pluginBase.c kN = ((ActivityProxy) activity).kN();
                    if (kN != null && kN.getClass() != null) {
                        simpleName = kN.getClass().getSimpleName();
                        if (StringUtils.isNull(simpleName)) {
                            sb.append(String.valueOf(simpleName) + ";");
                        }
                    }
                    simpleName = "";
                    if (StringUtils.isNull(simpleName)) {
                    }
                } else {
                    if (activity.getClass() != null) {
                        simpleName = activity.getClass().getSimpleName();
                        if (StringUtils.isNull(simpleName)) {
                        }
                    }
                    simpleName = "";
                    if (StringUtils.isNull(simpleName)) {
                    }
                }
            }
        }
        return sb.toString();
    }
}
