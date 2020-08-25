package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes2.dex */
public class b {
    private static b dRA = null;
    private SparseArray<e> dRz = new SparseArray<>();

    private b() {
    }

    public static b bar() {
        if (dRA == null) {
            synchronized (b.class) {
                if (dRA == null) {
                    dRA = new b();
                }
            }
        }
        return dRA;
    }

    public View q(Context context, int i) {
        if (this.dRz.get(i) == null) {
            return null;
        }
        return this.dRz.get(i).createView(context);
    }

    public void a(int i, e eVar) {
        this.dRz.put(i, eVar);
    }
}
