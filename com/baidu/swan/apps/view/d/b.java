package com.baidu.swan.apps.view.d;

import android.support.annotation.NonNull;
/* loaded from: classes2.dex */
public class b {
    private int bcA;
    private int bcz;
    private int mFlags = 0;

    @NonNull
    public b eK(int i) {
        this.mFlags |= i;
        return this;
    }

    public void removeFlags(int i) {
        this.mFlags &= i ^ (-1);
    }

    public boolean isFixed() {
        return (this.mFlags & 1) == 1;
    }

    public int PJ() {
        return this.bcz;
    }

    public void eL(int i) {
        this.bcz = i;
    }

    public int PK() {
        return this.bcA;
    }

    public void eM(int i) {
        this.bcA = i;
    }
}
