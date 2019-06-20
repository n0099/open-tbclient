package com.baidu.adp.widget.a;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private SparseArray<c> Lx = new SparseArray<>();

    public boolean setPreloadSize(int i, int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return false;
        }
        this.Lx.put(i, new c(i2, i3));
        return true;
    }

    public c getPreloadSize(int i) {
        return this.Lx.get(i);
    }

    public boolean isPreloadSizeReady(int i) {
        c preloadSize = getPreloadSize(i);
        return preloadSize != null && preloadSize.getWidth() > 0 && preloadSize.getHeight() > 0;
    }
}
