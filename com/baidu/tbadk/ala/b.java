package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b aGW = null;
    private SparseArray<d> aGV = new SparseArray<>();

    private b() {
    }

    public static b vL() {
        if (aGW == null) {
            synchronized (b.class) {
                if (aGW == null) {
                    aGW = new b();
                }
            }
        }
        return aGW;
    }

    public View u(Context context, int i) {
        if (this.aGV.get(i) == null) {
            return null;
        }
        return this.aGV.get(i).aG(context);
    }

    public void a(int i, d dVar) {
        this.aGV.put(i, dVar);
    }
}
