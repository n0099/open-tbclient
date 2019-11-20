package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b bTf = null;
    private SparseArray<e> bTe = new SparseArray<>();

    private b() {
    }

    public static b afa() {
        if (bTf == null) {
            synchronized (b.class) {
                if (bTf == null) {
                    bTf = new b();
                }
            }
        }
        return bTf;
    }

    public View l(Context context, int i) {
        if (this.bTe.get(i) == null) {
            return null;
        }
        return this.bTe.get(i).createView(context);
    }

    public void a(int i, e eVar) {
        this.bTe.put(i, eVar);
    }
}
