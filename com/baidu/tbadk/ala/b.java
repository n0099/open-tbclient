package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b aGX = null;
    private SparseArray<d> aGW = new SparseArray<>();

    private b() {
    }

    public static b vL() {
        if (aGX == null) {
            synchronized (b.class) {
                if (aGX == null) {
                    aGX = new b();
                }
            }
        }
        return aGX;
    }

    public View u(Context context, int i) {
        if (this.aGW.get(i) == null) {
            return null;
        }
        return this.aGW.get(i).aG(context);
    }

    public void a(int i, d dVar) {
        this.aGW.put(i, dVar);
    }
}
