package com.baidu.adp.widget.a;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private SparseArray<c> xz = new SparseArray<>();

    public boolean g(int i, int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return false;
        }
        this.xz.put(i, new c(i2, i3));
        return true;
    }

    public c aa(int i) {
        return this.xz.get(i);
    }

    public boolean ab(int i) {
        c aa = aa(i);
        return aa != null && aa.getWidth() > 0 && aa.getHeight() > 0;
    }
}
