package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b QN = null;
    private SparseArray<d> QM = new SparseArray<>();

    private b() {
    }

    public static b nu() {
        if (QN == null) {
            synchronized (b.class) {
                if (QN == null) {
                    QN = new b();
                }
            }
        }
        return QN;
    }

    public View g(Context context, int i) {
        if (this.QM.get(i) == null) {
            return null;
        }
        return this.QM.get(i).aw(context);
    }

    public void a(int i, d dVar) {
        this.QM.put(i, dVar);
    }
}
