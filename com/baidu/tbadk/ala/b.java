package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b dRE = null;
    private SparseArray<e> dRD = new SparseArray<>();

    private b() {
    }

    public static b bar() {
        if (dRE == null) {
            synchronized (b.class) {
                if (dRE == null) {
                    dRE = new b();
                }
            }
        }
        return dRE;
    }

    public View q(Context context, int i) {
        if (this.dRD.get(i) == null) {
            return null;
        }
        return this.dRD.get(i).createView(context);
    }

    public void a(int i, e eVar) {
        this.dRD.put(i, eVar);
    }
}
