package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b Rs = null;
    private SparseArray<d> Rr = new SparseArray<>();

    private b() {
    }

    public static b nD() {
        if (Rs == null) {
            synchronized (b.class) {
                if (Rs == null) {
                    Rs = new b();
                }
            }
        }
        return Rs;
    }

    public View h(Context context, int i) {
        if (this.Rr.get(i) == null) {
            return null;
        }
        return this.Rr.get(i).ar(context);
    }

    public void a(int i, d dVar) {
        this.Rr.put(i, dVar);
    }
}
