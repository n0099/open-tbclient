package com.baidu.adp.base;

import android.app.Activity;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
/* loaded from: classes.dex */
final class a {
    private static ArrayList<SoftReference<Activity>> at;
    private static a au;
    private int av = 0;

    private a() {
        if (at == null) {
            at = new ArrayList<>(20);
        }
    }

    public static a M() {
        if (au == null) {
            au = new a();
        }
        return au;
    }

    public int getSize() {
        return at.size();
    }

    public void a(Activity activity) {
        if (activity != null) {
            at.add(new SoftReference<>(activity));
            c(this.av);
        }
    }

    public Activity b(int i) {
        int size = at.size();
        if (size == 0) {
            return null;
        }
        if (i < 0 || i >= size) {
            return null;
        }
        SoftReference<Activity> remove = at.remove(i);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }

    public void b(Activity activity) {
        int size;
        if (activity != null && (size = at.size()) != 0) {
            for (int i = size - 1; i >= 0; i--) {
                SoftReference<Activity> softReference = at.get(i);
                if (softReference != null && activity.equals(softReference.get())) {
                    at.remove(i);
                    return;
                }
            }
        }
    }

    public void setActivityStackMaxSize(int i) {
        if (i >= 10 || i == 0) {
            this.av = i;
        }
    }

    public void N() {
        c(3);
    }

    public int getActivityStackMaxSize() {
        return this.av;
    }

    private void c(int i) {
        if (i != 0) {
            int size = M().getSize();
            while (size > i) {
                size--;
                Activity b = M().b(1);
                if (b != null) {
                    b.finish();
                }
            }
        }
    }
}
