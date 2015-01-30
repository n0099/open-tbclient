package com.baidu.adp.base;

import android.app.Activity;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class a {
    private static ArrayList<SoftReference<Activity>> cf;
    private static a cg;
    private b ch;
    private int ci = 0;

    public void a(b bVar) {
        this.ch = bVar;
    }

    private a() {
        if (cf == null) {
            cf = new ArrayList<>(20);
        }
    }

    public static a ah() {
        if (cg == null) {
            cg = new a();
        }
        return cg;
    }

    public int getSize() {
        return cf.size();
    }

    public void g(Activity activity) {
        if (activity != null) {
            cf.add(new SoftReference<>(activity));
            n(this.ci);
        }
    }

    public Activity m(int i) {
        int size = cf.size();
        if (size == 0) {
            return null;
        }
        if (i < 0 || i >= size) {
            return null;
        }
        SoftReference<Activity> remove = cf.remove(i);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }

    public void h(Activity activity) {
        if (activity != null) {
            int size = cf.size();
            if (size == 0) {
                if (this.ch != null) {
                    this.ch.onActivityClosed();
                    return;
                }
                return;
            }
            for (int i = size - 1; i >= 0; i--) {
                SoftReference<Activity> softReference = cf.get(i);
                if (softReference == null) {
                    cf.remove(i);
                } else if (activity.equals(softReference.get())) {
                    cf.remove(i);
                    if (cf.size() == 0 && this.ch != null) {
                        this.ch.onActivityClosed();
                        return;
                    }
                    return;
                } else if (size == 0 && this.ch != null) {
                    this.ch.onActivityClosed();
                }
            }
        }
    }

    public void setActivityStackMaxSize(int i) {
        if (i >= 10 || i == 0) {
            this.ci = i;
        }
    }

    public void ai() {
        n(3);
    }

    public void aj() {
        if (cf != null) {
            while (!cf.isEmpty()) {
                SoftReference<Activity> remove = cf.remove(0);
                if (remove != null && remove.get() != null) {
                    remove.get().finish();
                }
            }
        }
        if (this.ch != null) {
            this.ch.onActivityClosed();
        }
    }

    public int getActivityStackMaxSize() {
        return this.ci;
    }

    private void n(int i) {
        if (i != 0) {
            int size = ah().getSize();
            while (size > i) {
                size--;
                Activity m = ah().m(1);
                if (m != null) {
                    m.finish();
                }
            }
        }
    }
}
