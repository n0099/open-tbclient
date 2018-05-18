package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b Sd = null;
    private SparseArray<d> Sc = new SparseArray<>();

    private b() {
    }

    public static b or() {
        if (Sd == null) {
            synchronized (b.class) {
                if (Sd == null) {
                    Sd = new b();
                }
            }
        }
        return Sd;
    }

    public View f(Context context, int i) {
        if (this.Sc.get(i) == null) {
            return null;
        }
        return this.Sc.get(i).aq(context);
    }

    public void a(int i, d dVar) {
        this.Sc.put(i, dVar);
    }
}
