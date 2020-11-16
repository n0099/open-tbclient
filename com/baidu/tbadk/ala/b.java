package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b esB = null;
    private SparseArray<e> esA = new SparseArray<>();

    private b() {
    }

    public static b bhG() {
        if (esB == null) {
            synchronized (b.class) {
                if (esB == null) {
                    esB = new b();
                }
            }
        }
        return esB;
    }

    public View q(Context context, int i) {
        if (this.esA.get(i) == null) {
            return null;
        }
        return this.esA.get(i).createView(context);
    }

    public void a(int i, e eVar) {
        this.esA.put(i, eVar);
    }
}
