package com.baidu.adp.widget.a;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private SparseArray<c> TZ = new SparseArray<>();

    public boolean h(int i, int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return false;
        }
        this.TZ.put(i, new c(i2, i3));
        return true;
    }

    public c az(int i) {
        return this.TZ.get(i);
    }

    public boolean aA(int i) {
        c az = az(i);
        return az != null && az.getWidth() > 0 && az.getHeight() > 0;
    }
}
