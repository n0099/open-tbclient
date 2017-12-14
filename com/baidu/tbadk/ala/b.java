package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b Re = null;
    private SparseArray<d> Rd = new SparseArray<>();

    private b() {
    }

    public static b nv() {
        if (Re == null) {
            synchronized (b.class) {
                if (Re == null) {
                    Re = new b();
                }
            }
        }
        return Re;
    }

    public View g(Context context, int i) {
        if (this.Rd.get(i) == null) {
            return null;
        }
        return this.Rd.get(i).av(context);
    }

    public void a(int i, d dVar) {
        this.Rd.put(i, dVar);
    }
}
