package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b bsL = null;
    private SparseArray<e> bsK = new SparseArray<>();

    private b() {
    }

    public static b UK() {
        if (bsL == null) {
            synchronized (b.class) {
                if (bsL == null) {
                    bsL = new b();
                }
            }
        }
        return bsL;
    }

    public View n(Context context, int i) {
        if (this.bsK.get(i) == null) {
            return null;
        }
        return this.bsK.get(i).createView(context);
    }

    public void a(int i, e eVar) {
        this.bsK.put(i, eVar);
    }
}
