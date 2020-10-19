package com.baidu.swan.apps.view.narootview;

import android.support.annotation.NonNull;
/* loaded from: classes10.dex */
public class b {
    private int dtg;
    private int dth;
    private int mFlags = 0;

    @NonNull
    public b le(int i) {
        this.mFlags |= i;
        return this;
    }

    public void lf(int i) {
        this.mFlags &= i ^ (-1);
    }

    public boolean isFixed() {
        return (this.mFlags & 1) == 1;
    }

    public int aJF() {
        return this.dtg;
    }

    public void lg(int i) {
        this.dtg = i;
    }

    public int aJG() {
        return this.dth;
    }

    public void lh(int i) {
        this.dth = i;
    }
}
