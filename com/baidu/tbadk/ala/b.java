package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b eGD = null;
    private SparseArray<e> eGC = new SparseArray<>();

    private b() {
    }

    public static b bjQ() {
        if (eGD == null) {
            synchronized (b.class) {
                if (eGD == null) {
                    eGD = new b();
                }
            }
        }
        return eGD;
    }

    public View A(Context context, int i) {
        if (this.eGC.get(i) == null) {
            return null;
        }
        return this.eGC.get(i).createView(context);
    }

    public void a(int i, e eVar) {
        this.eGC.put(i, eVar);
    }
}
