package com.baidu.adp.widget.a;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private SparseArray<c> Tj = new SparseArray<>();

    public boolean h(int i, int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return false;
        }
        this.Tj.put(i, new c(i2, i3));
        return true;
    }

    public c as(int i) {
        return this.Tj.get(i);
    }

    public boolean at(int i) {
        c as = as(i);
        return as != null && as.getWidth() > 0 && as.getHeight() > 0;
    }
}
