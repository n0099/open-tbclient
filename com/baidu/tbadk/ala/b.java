package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b eEw = null;
    private SparseArray<e> eEv = new SparseArray<>();

    private b() {
    }

    public static b bjv() {
        if (eEw == null) {
            synchronized (b.class) {
                if (eEw == null) {
                    eEw = new b();
                }
            }
        }
        return eEw;
    }

    public View A(Context context, int i) {
        if (this.eEv.get(i) == null) {
            return null;
        }
        return this.eEv.get(i).createView(context);
    }

    public void a(int i, e eVar) {
        this.eEv.put(i, eVar);
    }
}
