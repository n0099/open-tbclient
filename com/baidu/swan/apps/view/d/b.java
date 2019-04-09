package com.baidu.swan.apps.view.d;

import android.support.annotation.NonNull;
/* loaded from: classes2.dex */
public class b {
    private int aZM;
    private int aZN;
    private int mFlags = 0;

    @NonNull
    public b ey(int i) {
        this.mFlags |= i;
        return this;
    }

    public void removeFlags(int i) {
        this.mFlags &= i ^ (-1);
    }

    public boolean isFixed() {
        return (this.mFlags & 1) == 1;
    }

    public int Na() {
        return this.aZM;
    }

    public void ez(int i) {
        this.aZM = i;
    }

    public int Nb() {
        return this.aZN;
    }

    public void eA(int i) {
        this.aZN = i;
    }
}
