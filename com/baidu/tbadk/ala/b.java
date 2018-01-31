package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b aFO = null;
    private SparseArray<d> aFN = new SparseArray<>();

    private b() {
    }

    public static b uZ() {
        if (aFO == null) {
            synchronized (b.class) {
                if (aFO == null) {
                    aFO = new b();
                }
            }
        }
        return aFO;
    }

    public View t(Context context, int i) {
        if (this.aFN.get(i) == null) {
            return null;
        }
        return this.aFN.get(i).aH(context);
    }

    public void a(int i, d dVar) {
        this.aFN.put(i, dVar);
    }
}
