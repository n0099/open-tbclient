package com.baidu.swan.apps.view.narootview;

import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public class b {
    private int dUA;
    private int dUB;
    private int mFlags = 0;

    @NonNull
    public b ky(int i) {
        this.mFlags |= i;
        return this;
    }

    public void kz(int i) {
        this.mFlags &= i ^ (-1);
    }

    public boolean isFixed() {
        return (this.mFlags & 1) == 1;
    }

    public int aPv() {
        return this.dUA;
    }

    public void kA(int i) {
        this.dUA = i;
    }

    public int aPw() {
        return this.dUB;
    }

    public void kB(int i) {
        this.dUB = i;
    }
}
