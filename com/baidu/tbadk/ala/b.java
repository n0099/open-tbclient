package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class b {
    private static b QK = null;
    private SparseArray<d> QJ = new SparseArray<>();

    private b() {
    }

    public static b nz() {
        if (QK == null) {
            synchronized (b.class) {
                if (QK == null) {
                    QK = new b();
                }
            }
        }
        return QK;
    }

    public View h(Context context, int i) {
        if (this.QJ.get(i) == null) {
            return null;
        }
        return this.QJ.get(i).ax(context);
    }

    public void a(int i, d dVar) {
        this.QJ.put(i, dVar);
    }
}
