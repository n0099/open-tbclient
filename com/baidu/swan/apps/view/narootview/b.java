package com.baidu.swan.apps.view.narootview;

import androidx.annotation.NonNull;
/* loaded from: classes9.dex */
public class b {
    private int dSZ;
    private int dTa;
    private int mFlags = 0;

    @NonNull
    public b kx(int i) {
        this.mFlags |= i;
        return this;
    }

    public void ky(int i) {
        this.mFlags &= i ^ (-1);
    }

    public boolean isFixed() {
        return (this.mFlags & 1) == 1;
    }

    public int aPs() {
        return this.dSZ;
    }

    public void kz(int i) {
        this.dSZ = i;
    }

    public int aPt() {
        return this.dTa;
    }

    public void kA(int i) {
        this.dTa = i;
    }
}
