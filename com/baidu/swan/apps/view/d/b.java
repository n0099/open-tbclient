package com.baidu.swan.apps.view.d;

import android.support.annotation.NonNull;
/* loaded from: classes2.dex */
public class b {
    private int bvP;
    private int bvQ;
    private int mFlags = 0;

    @NonNull
    public b fI(int i) {
        this.mFlags |= i;
        return this;
    }

    public void fJ(int i) {
        this.mFlags &= i ^ (-1);
    }

    public boolean isFixed() {
        return (this.mFlags & 1) == 1;
    }

    public int Vt() {
        return this.bvP;
    }

    public void fK(int i) {
        this.bvP = i;
    }

    public int Vu() {
        return this.bvQ;
    }

    public void fL(int i) {
        this.bvQ = i;
    }
}
