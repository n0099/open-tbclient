package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b aij = null;
    private SparseArray<e> aii = new SparseArray<>();

    private b() {
    }

    public static b uV() {
        if (aij == null) {
            synchronized (b.class) {
                if (aij == null) {
                    aij = new b();
                }
            }
        }
        return aij;
    }

    public View j(Context context, int i) {
        if (this.aii.get(i) == null) {
            return null;
        }
        return this.aii.get(i).createView(context);
    }

    public void a(int i, e eVar) {
        this.aii.put(i, eVar);
    }
}
