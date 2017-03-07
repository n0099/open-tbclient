package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class c {
    private static c Qz = null;
    private SparseArray<f> Qy = new SparseArray<>();

    private c() {
    }

    public static c nD() {
        if (Qz == null) {
            synchronized (c.class) {
                if (Qz == null) {
                    Qz = new c();
                }
            }
        }
        return Qz;
    }

    public View h(Context context, int i) {
        if (this.Qy.get(i) == null) {
            return null;
        }
        return this.Qy.get(i).ao(context);
    }

    public void a(int i, f fVar) {
        this.Qy.put(i, fVar);
    }
}
