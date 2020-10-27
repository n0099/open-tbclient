package com.baidu.swan.apps.view.narootview;

import android.support.annotation.NonNull;
/* loaded from: classes10.dex */
public class b {
    private int dBE;
    private int dBF;
    private int mFlags = 0;

    @NonNull
    public b lp(int i) {
        this.mFlags |= i;
        return this;
    }

    public void lq(int i) {
        this.mFlags &= i ^ (-1);
    }

    public boolean isFixed() {
        return (this.mFlags & 1) == 1;
    }

    public int aLz() {
        return this.dBE;
    }

    public void lr(int i) {
        this.dBE = i;
    }

    public int aLA() {
        return this.dBF;
    }

    public void ls(int i) {
        this.dBF = i;
    }
}
