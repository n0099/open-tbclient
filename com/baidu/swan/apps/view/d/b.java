package com.baidu.swan.apps.view.d;

import android.support.annotation.NonNull;
/* loaded from: classes2.dex */
public class b {
    private int bwG;
    private int bwH;
    private int mFlags = 0;

    @NonNull
    public b fJ(int i) {
        this.mFlags |= i;
        return this;
    }

    public void fK(int i) {
        this.mFlags &= i ^ (-1);
    }

    public boolean isFixed() {
        return (this.mFlags & 1) == 1;
    }

    public int Vv() {
        return this.bwG;
    }

    public void fL(int i) {
        this.bwG = i;
    }

    public int Vw() {
        return this.bwH;
    }

    public void fM(int i) {
        this.bwH = i;
    }
}
