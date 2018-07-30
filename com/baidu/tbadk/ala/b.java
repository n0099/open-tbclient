package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b ZU = null;
    private SparseArray<d> ZT = new SparseArray<>();

    private b() {
    }

    public static b rx() {
        if (ZU == null) {
            synchronized (b.class) {
                if (ZU == null) {
                    ZU = new b();
                }
            }
        }
        return ZU;
    }

    public View g(Context context, int i) {
        if (this.ZT.get(i) == null) {
            return null;
        }
        return this.ZT.get(i).aB(context);
    }

    public void a(int i, d dVar) {
        this.ZT.put(i, dVar);
    }
}
