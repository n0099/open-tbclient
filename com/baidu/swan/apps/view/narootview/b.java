package com.baidu.swan.apps.view.narootview;

import androidx.annotation.NonNull;
/* loaded from: classes9.dex */
public class b {
    private int dVF;
    private int dVG;
    private int mFlags = 0;

    @NonNull
    public b ma(int i) {
        this.mFlags |= i;
        return this;
    }

    public void mb(int i) {
        this.mFlags &= i ^ (-1);
    }

    public boolean isFixed() {
        return (this.mFlags & 1) == 1;
    }

    public int aSS() {
        return this.dVF;
    }

    public void mc(int i) {
        this.dVF = i;
    }

    public int aST() {
        return this.dVG;
    }

    public void md(int i) {
        this.dVG = i;
    }
}
