package com.baidu.swan.apps.view.narootview;

import android.support.annotation.NonNull;
/* loaded from: classes3.dex */
public class b {
    private int dgY;
    private int dgZ;
    private int mFlags = 0;

    @NonNull
    public b kH(int i) {
        this.mFlags |= i;
        return this;
    }

    public void kI(int i) {
        this.mFlags &= i ^ (-1);
    }

    public boolean isFixed() {
        return (this.mFlags & 1) == 1;
    }

    public int aGW() {
        return this.dgY;
    }

    public void kJ(int i) {
        this.dgY = i;
    }

    public int aGX() {
        return this.dgZ;
    }

    public void kK(int i) {
        this.dgZ = i;
    }
}
