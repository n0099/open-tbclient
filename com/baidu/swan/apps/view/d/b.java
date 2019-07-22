package com.baidu.swan.apps.view.d;

import android.support.annotation.NonNull;
/* loaded from: classes2.dex */
public class b {
    private int bdl;
    private int bdm;
    private int mFlags = 0;

    @NonNull
    public b eN(int i) {
        this.mFlags |= i;
        return this;
    }

    public void eO(int i) {
        this.mFlags &= i ^ (-1);
    }

    public boolean isFixed() {
        return (this.mFlags & 1) == 1;
    }

    public int QB() {
        return this.bdl;
    }

    public void eP(int i) {
        this.bdl = i;
    }

    public int QC() {
        return this.bdm;
    }

    public void eQ(int i) {
        this.bdm = i;
    }
}
