package com.baidu.swan.apps.view.narootview;

import androidx.annotation.NonNull;
/* loaded from: classes8.dex */
public class b {
    private int dQT;
    private int dQU;
    private int mFlags = 0;

    @NonNull
    public b ku(int i) {
        this.mFlags |= i;
        return this;
    }

    public void kv(int i) {
        this.mFlags &= i ^ (-1);
    }

    public boolean isFixed() {
        return (this.mFlags & 1) == 1;
    }

    public int aOZ() {
        return this.dQT;
    }

    public void kw(int i) {
        this.dQT = i;
    }

    public int aPa() {
        return this.dQU;
    }

    public void kx(int i) {
        this.dQU = i;
    }
}
