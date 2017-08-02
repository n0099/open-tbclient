package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b PS = null;
    private SparseArray<d> PR = new SparseArray<>();

    private b() {
    }

    public static b ns() {
        if (PS == null) {
            synchronized (b.class) {
                if (PS == null) {
                    PS = new b();
                }
            }
        }
        return PS;
    }

    public View h(Context context, int i) {
        if (this.PR.get(i) == null) {
            return null;
        }
        return this.PR.get(i).aq(context);
    }

    public void a(int i, d dVar) {
        this.PR.put(i, dVar);
    }
}
