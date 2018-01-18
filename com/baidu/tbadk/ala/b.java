package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b aFL = null;
    private SparseArray<d> aFK = new SparseArray<>();

    private b() {
    }

    public static b uY() {
        if (aFL == null) {
            synchronized (b.class) {
                if (aFL == null) {
                    aFL = new b();
                }
            }
        }
        return aFL;
    }

    public View t(Context context, int i) {
        if (this.aFK.get(i) == null) {
            return null;
        }
        return this.aFK.get(i).aH(context);
    }

    public void a(int i, d dVar) {
        this.aFK.put(i, dVar);
    }
}
