package com.baidu.swan.apps.view.narootview;

import android.support.annotation.NonNull;
/* loaded from: classes9.dex */
public class b {
    private int bWA;
    private int bWB;
    private int mFlags = 0;

    @NonNull
    public b gV(int i) {
        this.mFlags |= i;
        return this;
    }

    public void gW(int i) {
        this.mFlags &= i ^ (-1);
    }

    public boolean isFixed() {
        return (this.mFlags & 1) == 1;
    }

    public int afe() {
        return this.bWA;
    }

    public void gX(int i) {
        this.bWA = i;
    }

    public int aff() {
        return this.bWB;
    }

    public void gY(int i) {
        this.bWB = i;
    }
}
