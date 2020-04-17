package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b djm = null;
    private SparseArray<e> djl = new SparseArray<>();

    private b() {
    }

    public static b aGP() {
        if (djm == null) {
            synchronized (b.class) {
                if (djm == null) {
                    djm = new b();
                }
            }
        }
        return djm;
    }

    public View p(Context context, int i) {
        if (this.djl.get(i) == null) {
            return null;
        }
        return this.djl.get(i).createView(context);
    }

    public void a(int i, e eVar) {
        this.djl.put(i, eVar);
    }
}
