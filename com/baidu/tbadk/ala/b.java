package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b ZV = null;
    private SparseArray<d> ZU = new SparseArray<>();

    private b() {
    }

    public static b rv() {
        if (ZV == null) {
            synchronized (b.class) {
                if (ZV == null) {
                    ZV = new b();
                }
            }
        }
        return ZV;
    }

    public View g(Context context, int i) {
        if (this.ZU.get(i) == null) {
            return null;
        }
        return this.ZU.get(i).createView(context);
    }

    public void a(int i, d dVar) {
        this.ZU.put(i, dVar);
    }
}
