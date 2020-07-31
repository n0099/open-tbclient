package com.baidu.adp.widget.a;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private SparseArray<c> TU = new SparseArray<>();

    public boolean h(int i, int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return false;
        }
        this.TU.put(i, new c(i2, i3));
        return true;
    }

    public c aB(int i) {
        return this.TU.get(i);
    }

    public boolean aC(int i) {
        c aB = aB(i);
        return aB != null && aB.getWidth() > 0 && aB.getHeight() > 0;
    }
}
