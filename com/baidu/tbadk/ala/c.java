package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class c {
    private static c QS = null;
    private SparseArray<f> QR = new SparseArray<>();

    private c() {
    }

    public static c oa() {
        if (QS == null) {
            synchronized (c.class) {
                if (QS == null) {
                    QS = new c();
                }
            }
        }
        return QS;
    }

    public View h(Context context, int i) {
        if (this.QR.get(i) == null) {
            return null;
        }
        return this.QR.get(i).aq(context);
    }

    public void a(int i, f fVar) {
        this.QR.put(i, fVar);
    }
}
