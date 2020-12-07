package com.baidu.swan.apps.view.narootview;

import android.support.annotation.NonNull;
/* loaded from: classes25.dex */
public class b {
    private int dMM;
    private int dMN;
    private int mFlags = 0;

    @NonNull
    public b lT(int i) {
        this.mFlags |= i;
        return this;
    }

    public void lU(int i) {
        this.mFlags &= i ^ (-1);
    }

    public boolean isFixed() {
        return (this.mFlags & 1) == 1;
    }

    public int aQx() {
        return this.dMM;
    }

    public void lV(int i) {
        this.dMM = i;
    }

    public int aQy() {
        return this.dMN;
    }

    public void lW(int i) {
        this.dMN = i;
    }
}
