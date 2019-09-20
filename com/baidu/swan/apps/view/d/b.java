package com.baidu.swan.apps.view.d;

import android.support.annotation.NonNull;
/* loaded from: classes2.dex */
public class b {
    private int bdJ;
    private int bdK;
    private int mFlags = 0;

    @NonNull
    public b eO(int i) {
        this.mFlags |= i;
        return this;
    }

    public void eP(int i) {
        this.mFlags &= i ^ (-1);
    }

    public boolean isFixed() {
        return (this.mFlags & 1) == 1;
    }

    public int QF() {
        return this.bdJ;
    }

    public void eQ(int i) {
        this.bdJ = i;
    }

    public int QG() {
        return this.bdK;
    }

    public void eR(int i) {
        this.bdK = i;
    }
}
