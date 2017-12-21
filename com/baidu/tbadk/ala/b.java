package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b Rf = null;
    private SparseArray<d> Re = new SparseArray<>();

    private b() {
    }

    public static b nv() {
        if (Rf == null) {
            synchronized (b.class) {
                if (Rf == null) {
                    Rf = new b();
                }
            }
        }
        return Rf;
    }

    public View g(Context context, int i) {
        if (this.Re.get(i) == null) {
            return null;
        }
        return this.Re.get(i).av(context);
    }

    public void a(int i, d dVar) {
        this.Re.put(i, dVar);
    }
}
