package com.baidu.swan.apps.view.narootview;

import android.support.annotation.NonNull;
/* loaded from: classes7.dex */
public class b {
    private int dFO;
    private int dFP;
    private int mFlags = 0;

    @NonNull
    public b lv(int i) {
        this.mFlags |= i;
        return this;
    }

    public void lw(int i) {
        this.mFlags &= i ^ (-1);
    }

    public boolean isFixed() {
        return (this.mFlags & 1) == 1;
    }

    public int aNr() {
        return this.dFO;
    }

    public void lx(int i) {
        this.dFO = i;
    }

    public int aNs() {
        return this.dFP;
    }

    public void ly(int i) {
        this.dFP = i;
    }
}
