package com.baidu.adp.base;

import android.app.Activity;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class a {
    private static ArrayList<SoftReference<Activity>> ce;
    private static a cf;
    private b cg;
    private int ch = 0;

    public void a(b bVar) {
        this.cg = bVar;
    }

    private a() {
        if (ce == null) {
            ce = new ArrayList<>(20);
        }
    }

    public static a ah() {
        if (cf == null) {
            cf = new a();
        }
        return cf;
    }

    public int getSize() {
        return ce.size();
    }

    public void g(Activity activity) {
        if (activity != null) {
            ce.add(new SoftReference<>(activity));
            n(this.ch);
        }
    }

    public Activity m(int i) {
        int size = ce.size();
        if (size == 0) {
            return null;
        }
        if (i < 0 || i >= size) {
            return null;
        }
        SoftReference<Activity> remove = ce.remove(i);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }

    public void h(Activity activity) {
        if (activity != null) {
            int size = ce.size();
            if (size == 0) {
                if (this.cg != null) {
                    this.cg.onActivityClosed();
                    return;
                }
                return;
            }
            for (int i = size - 1; i >= 0; i--) {
                SoftReference<Activity> softReference = ce.get(i);
                if (softReference == null) {
                    ce.remove(i);
                } else if (activity.equals(softReference.get())) {
                    ce.remove(i);
                    if (ce.size() == 0 && this.cg != null) {
                        this.cg.onActivityClosed();
                        return;
                    }
                    return;
                } else if (size == 0 && this.cg != null) {
                    this.cg.onActivityClosed();
                }
            }
        }
    }

    public void setActivityStackMaxSize(int i) {
        if (i >= 10 || i == 0) {
            this.ch = i;
        }
    }

    public void ai() {
        n(3);
    }

    public void aj() {
        if (ce != null) {
            while (!ce.isEmpty()) {
                SoftReference<Activity> remove = ce.remove(0);
                if (remove != null && remove.get() != null) {
                    remove.get().finish();
                }
            }
        }
        if (this.cg != null) {
            this.cg.onActivityClosed();
        }
    }

    public int getActivityStackMaxSize() {
        return this.ch;
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
