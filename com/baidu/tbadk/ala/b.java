package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b Rg = null;
    private SparseArray<d> Rf = new SparseArray<>();

    private b() {
    }

    public static b ny() {
        if (Rg == null) {
            synchronized (b.class) {
                if (Rg == null) {
                    Rg = new b();
                }
            }
        }
        return Rg;
    }

    public View g(Context context, int i) {
        if (this.Rf.get(i) == null) {
            return null;
        }
        return this.Rf.get(i).aw(context);
    }

    public void a(int i, d dVar) {
        this.Rf.put(i, dVar);
    }
}
