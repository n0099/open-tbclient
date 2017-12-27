package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b aFM = null;
    private SparseArray<d> aFL = new SparseArray<>();

    private b() {
    }

    public static b uY() {
        if (aFM == null) {
            synchronized (b.class) {
                if (aFM == null) {
                    aFM = new b();
                }
            }
        }
        return aFM;
    }

    public View t(Context context, int i) {
        if (this.aFL.get(i) == null) {
            return null;
        }
        return this.aFL.get(i).aH(context);
    }

    public void a(int i, d dVar) {
        this.aFL.put(i, dVar);
    }
}
