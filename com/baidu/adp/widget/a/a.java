package com.baidu.adp.widget.a;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private SparseArray<c> zD = new SparseArray<>();

    public boolean g(int i, int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return false;
        }
        this.zD.put(i, new c(i2, i3));
        return true;
    }

    public c ad(int i) {
        return this.zD.get(i);
    }

    public boolean ae(int i) {
        c ad = ad(i);
        return ad != null && ad.getWidth() > 0 && ad.getHeight() > 0;
    }
}
