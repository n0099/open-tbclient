package com.baidu.swan.apps.view.narootview;

import android.support.annotation.NonNull;
/* loaded from: classes10.dex */
public class b {
    private int dHw;
    private int dHx;
    private int mFlags = 0;

    @NonNull
    public b lz(int i) {
        this.mFlags |= i;
        return this;
    }

    public void lA(int i) {
        this.mFlags &= i ^ (-1);
    }

    public boolean isFixed() {
        return (this.mFlags & 1) == 1;
    }

    public int aNZ() {
        return this.dHw;
    }

    public void lB(int i) {
        this.dHw = i;
    }

    public int aOa() {
        return this.dHx;
    }

    public void lC(int i) {
        this.dHx = i;
    }
}
