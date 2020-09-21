package com.baidu.adp.widget.a;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private SparseArray<c> US = new SparseArray<>();

    public boolean h(int i, int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return false;
        }
        this.US.put(i, new c(i2, i3));
        return true;
    }

    public c aH(int i) {
        return this.US.get(i);
    }

    public boolean aI(int i) {
        c aH = aH(i);
        return aH != null && aH.getWidth() > 0 && aH.getHeight() > 0;
    }
}
