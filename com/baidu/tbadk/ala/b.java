package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b bBo = null;
    private SparseArray<e> bBn = new SparseArray<>();

    private b() {
    }

    public static b aao() {
        if (bBo == null) {
            synchronized (b.class) {
                if (bBo == null) {
                    bBo = new b();
                }
            }
        }
        return bBo;
    }

    public View n(Context context, int i) {
        if (this.bBn.get(i) == null) {
            return null;
        }
        return this.bBn.get(i).createView(context);
    }

    public void a(int i, e eVar) {
        this.bBn.put(i, eVar);
    }
}
