package com.baidu.tbadk.ala;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
/* loaded from: classes.dex */
public class c {
    private static c Ql = null;
    private SparseArray<f> Qk = new SparseArray<>();

    private c() {
    }

    public static c nH() {
        if (Ql == null) {
            synchronized (c.class) {
                if (Ql == null) {
                    Ql = new c();
                }
            }
        }
        return Ql;
    }

    public View h(Context context, int i) {
        if (this.Qk.get(i) == null) {
            return null;
        }
        return this.Qk.get(i).aq(context);
    }

    public void a(int i, f fVar) {
        this.Qk.put(i, fVar);
    }
}
