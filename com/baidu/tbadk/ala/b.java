package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b bsM = null;
    private SparseArray<e> bsL = new SparseArray<>();

    private b() {
    }

    public static b UK() {
        if (bsM == null) {
            synchronized (b.class) {
                if (bsM == null) {
                    bsM = new b();
                }
            }
        }
        return bsM;
    }

    public View n(Context context, int i) {
        if (this.bsL.get(i) == null) {
            return null;
        }
        return this.bsL.get(i).createView(context);
    }

    public void a(int i, e eVar) {
        this.bsL.put(i, eVar);
    }
}
