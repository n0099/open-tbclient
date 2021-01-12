package com.baidu.adp.widget.a;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private SparseArray<c> Wf = new SparseArray<>();

    public boolean h(int i, int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return false;
        }
        this.Wf.put(i, new c(i2, i3));
        return true;
    }

    public c aN(int i) {
        return this.Wf.get(i);
    }

    public boolean aO(int i) {
        c aN = aN(i);
        return aN != null && aN.getWidth() > 0 && aN.getHeight() > 0;
    }
}
