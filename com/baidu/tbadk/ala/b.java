package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b dCw = null;
    private SparseArray<e> dCv = new SparseArray<>();

    private b() {
    }

    public static b aOf() {
        if (dCw == null) {
            synchronized (b.class) {
                if (dCw == null) {
                    dCw = new b();
                }
            }
        }
        return dCw;
    }

    public View p(Context context, int i) {
        if (this.dCv.get(i) == null) {
            return null;
        }
        return this.dCv.get(i).createView(context);
    }

    public void a(int i, e eVar) {
        this.dCv.put(i, eVar);
    }
}
