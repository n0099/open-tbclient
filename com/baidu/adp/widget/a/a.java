package com.baidu.adp.widget.a;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private SparseArray<c> zV = new SparseArray<>();

    public boolean g(int i, int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return false;
        }
        this.zV.put(i, new c(i2, i3));
        return true;
    }

    public c ag(int i) {
        return this.zV.get(i);
    }

    public boolean ah(int i) {
        c ag = ag(i);
        return ag != null && ag.getWidth() > 0 && ag.getHeight() > 0;
    }
}
