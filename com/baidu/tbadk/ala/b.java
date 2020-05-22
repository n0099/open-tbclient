package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b dxq = null;
    private SparseArray<e> dxp = new SparseArray<>();

    private b() {
    }

    public static b aMC() {
        if (dxq == null) {
            synchronized (b.class) {
                if (dxq == null) {
                    dxq = new b();
                }
            }
        }
        return dxq;
    }

    public View p(Context context, int i) {
        if (this.dxp.get(i) == null) {
            return null;
        }
        return this.dxp.get(i).createView(context);
    }

    public void a(int i, e eVar) {
        this.dxp.put(i, eVar);
    }
}
