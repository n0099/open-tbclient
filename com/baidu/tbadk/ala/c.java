package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class c {
    private static c Lx = null;
    private SparseArray<f> Lw = new SparseArray<>();

    private c() {
    }

    public static c np() {
        if (Lx == null) {
            synchronized (c.class) {
                if (Lx == null) {
                    Lx = new c();
                }
            }
        }
        return Lx;
    }

    public View f(Context context, int i) {
        if (this.Lw.get(i) == null) {
            return null;
        }
        return this.Lw.get(i).Q(context);
    }

    public void a(int i, f fVar) {
        this.Lw.put(i, fVar);
    }
}
