package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b efP = null;
    private SparseArray<e> efO = new SparseArray<>();

    private b() {
    }

    public static b bdT() {
        if (efP == null) {
            synchronized (b.class) {
                if (efP == null) {
                    efP = new b();
                }
            }
        }
        return efP;
    }

    public View q(Context context, int i) {
        if (this.efO.get(i) == null) {
            return null;
        }
        return this.efO.get(i).createView(context);
    }

    public void a(int i, e eVar) {
        this.efO.put(i, eVar);
    }
}
