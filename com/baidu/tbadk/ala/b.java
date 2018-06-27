package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b aaq = null;
    private SparseArray<d> aap = new SparseArray<>();

    private b() {
    }

    public static b rM() {
        if (aaq == null) {
            synchronized (b.class) {
                if (aaq == null) {
                    aaq = new b();
                }
            }
        }
        return aaq;
    }

    public View f(Context context, int i) {
        if (this.aap.get(i) == null) {
            return null;
        }
        return this.aap.get(i).aA(context);
    }

    public void a(int i, d dVar) {
        this.aap.put(i, dVar);
    }
}
