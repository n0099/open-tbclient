package com.baidu.adp.widget.a;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private SparseArray<c> Vk = new SparseArray<>();

    public boolean h(int i, int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return false;
        }
        this.Vk.put(i, new c(i2, i3));
        return true;
    }

    public c aI(int i) {
        return this.Vk.get(i);
    }

    public boolean aJ(int i) {
        c aI = aI(i);
        return aI != null && aI.getWidth() > 0 && aI.getHeight() > 0;
    }
}
