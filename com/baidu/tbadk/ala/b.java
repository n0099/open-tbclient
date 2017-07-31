package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b Rq = null;
    private SparseArray<d> Rp = new SparseArray<>();

    private b() {
    }

    public static b nC() {
        if (Rq == null) {
            synchronized (b.class) {
                if (Rq == null) {
                    Rq = new b();
                }
            }
        }
        return Rq;
    }

    public View h(Context context, int i) {
        if (this.Rp.get(i) == null) {
            return null;
        }
        return this.Rp.get(i).ar(context);
    }

    public void a(int i, d dVar) {
        this.Rp.put(i, dVar);
    }
}
