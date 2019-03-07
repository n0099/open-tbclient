package com.baidu.swan.apps.view.d;

import android.support.annotation.NonNull;
/* loaded from: classes2.dex */
public class b {
    private int aZH;
    private int aZI;
    private int mFlags = 0;

    @NonNull
    public b ez(int i) {
        this.mFlags |= i;
        return this;
    }

    public void removeFlags(int i) {
        this.mFlags &= i ^ (-1);
    }

    public boolean isFixed() {
        return (this.mFlags & 1) == 1;
    }

    public int Nc() {
        return this.aZH;
    }

    public void eA(int i) {
        this.aZH = i;
    }

    public int Nd() {
        return this.aZI;
    }

    public void eB(int i) {
        this.aZI = i;
    }
}
