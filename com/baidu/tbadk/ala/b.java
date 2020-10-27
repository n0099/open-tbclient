package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b eoo = null;
    private SparseArray<e> eon = new SparseArray<>();

    private b() {
    }

    public static b bfM() {
        if (eoo == null) {
            synchronized (b.class) {
                if (eoo == null) {
                    eoo = new b();
                }
            }
        }
        return eoo;
    }

    public View q(Context context, int i) {
        if (this.eon.get(i) == null) {
            return null;
        }
        return this.eon.get(i).createView(context);
    }

    public void a(int i, e eVar) {
        this.eon.put(i, eVar);
    }
}
