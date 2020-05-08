package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b djq = null;
    private SparseArray<e> djp = new SparseArray<>();

    private b() {
    }

    public static b aGN() {
        if (djq == null) {
            synchronized (b.class) {
                if (djq == null) {
                    djq = new b();
                }
            }
        }
        return djq;
    }

    public View p(Context context, int i) {
        if (this.djp.get(i) == null) {
            return null;
        }
        return this.djp.get(i).createView(context);
    }

    public void a(int i, e eVar) {
        this.djp.put(i, eVar);
    }
}
