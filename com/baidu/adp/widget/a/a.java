package com.baidu.adp.widget.a;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private SparseArray<c> Tw = new SparseArray<>();

    public boolean h(int i, int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return false;
        }
        this.Tw.put(i, new c(i2, i3));
        return true;
    }

    public c at(int i) {
        return this.Tw.get(i);
    }

    public boolean au(int i) {
        c at = at(i);
        return at != null && at.getWidth() > 0 && at.getHeight() > 0;
    }
}
