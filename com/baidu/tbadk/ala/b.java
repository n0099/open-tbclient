package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b aan = null;
    private SparseArray<d> aam = new SparseArray<>();

    private b() {
    }

    public static b rM() {
        if (aan == null) {
            synchronized (b.class) {
                if (aan == null) {
                    aan = new b();
                }
            }
        }
        return aan;
    }

    public View f(Context context, int i) {
        if (this.aam.get(i) == null) {
            return null;
        }
        return this.aam.get(i).aA(context);
    }

    public void a(int i, d dVar) {
        this.aam.put(i, dVar);
    }
}
