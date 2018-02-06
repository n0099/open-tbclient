package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b aHh = null;
    private SparseArray<d> aHg = new SparseArray<>();

    private b() {
    }

    public static b vL() {
        if (aHh == null) {
            synchronized (b.class) {
                if (aHh == null) {
                    aHh = new b();
                }
            }
        }
        return aHh;
    }

    public View u(Context context, int i) {
        if (this.aHg.get(i) == null) {
            return null;
        }
        return this.aHg.get(i).aG(context);
    }

    public void a(int i, d dVar) {
        this.aHg.put(i, dVar);
    }
}
