package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b bsQ = null;
    private SparseArray<e> bsP = new SparseArray<>();

    private b() {
    }

    public static b UH() {
        if (bsQ == null) {
            synchronized (b.class) {
                if (bsQ == null) {
                    bsQ = new b();
                }
            }
        }
        return bsQ;
    }

    public View n(Context context, int i) {
        if (this.bsP.get(i) == null) {
            return null;
        }
        return this.bsP.get(i).createView(context);
    }

    public void a(int i, e eVar) {
        this.bsP.put(i, eVar);
    }
}
