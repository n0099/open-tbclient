package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b alL = null;
    private SparseArray<e> alK = new SparseArray<>();

    private b() {
    }

    public static b vZ() {
        if (alL == null) {
            synchronized (b.class) {
                if (alL == null) {
                    alL = new b();
                }
            }
        }
        return alL;
    }

    public View j(Context context, int i) {
        if (this.alK.get(i) == null) {
            return null;
        }
        return this.alK.get(i).createView(context);
    }

    public void a(int i, e eVar) {
        this.alK.put(i, eVar);
    }
}
