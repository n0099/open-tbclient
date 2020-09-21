package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b dTO = null;
    private SparseArray<e> dTN = new SparseArray<>();

    private b() {
    }

    public static b bbl() {
        if (dTO == null) {
            synchronized (b.class) {
                if (dTO == null) {
                    dTO = new b();
                }
            }
        }
        return dTO;
    }

    public View q(Context context, int i) {
        if (this.dTN.get(i) == null) {
            return null;
        }
        return this.dTN.get(i).createView(context);
    }

    public void a(int i, e eVar) {
        this.dTN.put(i, eVar);
    }
}
