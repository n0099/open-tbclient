package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class c {
    private static c QU = null;
    private SparseArray<f> QT = new SparseArray<>();

    private c() {
    }

    public static c oa() {
        if (QU == null) {
            synchronized (c.class) {
                if (QU == null) {
                    QU = new c();
                }
            }
        }
        return QU;
    }

    public View h(Context context, int i) {
        if (this.QT.get(i) == null) {
            return null;
        }
        return this.QT.get(i).aq(context);
    }

    public void a(int i, f fVar) {
        this.QT.put(i, fVar);
    }
}
