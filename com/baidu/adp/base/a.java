package com.baidu.adp.base;

import android.app.Activity;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
/* loaded from: classes.dex */
final class a {
    private static ArrayList<SoftReference<Activity>> a;
    private static a b;
    private int c = 0;

    private a() {
        if (a == null) {
            a = new ArrayList<>(20);
        }
    }

    public static a a() {
        if (b == null) {
            b = new a();
        }
        return b;
    }

    public int b() {
        return a.size();
    }

    public void a(Activity activity) {
        if (activity != null) {
            a.add(new SoftReference<>(activity));
            c(this.c);
        }
    }

    public Activity a(int i) {
        int size = a.size();
        if (size == 0) {
            return null;
        }
        if (i < 0 || i >= size) {
            return null;
        }
        SoftReference<Activity> remove = a.remove(i);
        if (remove == null) {
            return null;
        }
        return remove.get();
    }

    public void b(Activity activity) {
        int size;
        if (activity != null && (size = a.size()) != 0) {
            for (int i = size - 1; i >= 0; i--) {
                SoftReference<Activity> softReference = a.get(i);
                if (softReference != null && activity.equals(softReference.get())) {
                    a.remove(i);
                    return;
                }
            }
        }
    }

    public void b(int i) {
        if (i >= 10 || i == 0) {
            this.c = i;
        }
    }

    public void c() {
        c(3);
    }

    public int d() {
        return this.c;
    }

    private void c(int i) {
        if (i != 0) {
            int b2 = a().b();
            while (b2 > i) {
                b2--;
                Activity a2 = a().a(1);
                if (a2 != null) {
                    a2.finish();
                }
            }
        }
    }
}
