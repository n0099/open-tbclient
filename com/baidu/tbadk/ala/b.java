package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b bsP = null;
    private SparseArray<e> bsO = new SparseArray<>();

    private b() {
    }

    public static b UH() {
        if (bsP == null) {
            synchronized (b.class) {
                if (bsP == null) {
                    bsP = new b();
                }
            }
        }
        return bsP;
    }

    public View n(Context context, int i) {
        if (this.bsO.get(i) == null) {
            return null;
        }
        return this.bsO.get(i).createView(context);
    }

    public void a(int i, e eVar) {
        this.bsO.put(i, eVar);
    }
}
