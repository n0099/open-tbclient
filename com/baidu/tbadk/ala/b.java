package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b Qy = null;
    private SparseArray<d> Qx = new SparseArray<>();

    private b() {
    }

    public static b nr() {
        if (Qy == null) {
            synchronized (b.class) {
                if (Qy == null) {
                    Qy = new b();
                }
            }
        }
        return Qy;
    }

    public View g(Context context, int i) {
        if (this.Qx.get(i) == null) {
            return null;
        }
        return this.Qx.get(i).aw(context);
    }

    public void a(int i, d dVar) {
        this.Qx.put(i, dVar);
    }
}
