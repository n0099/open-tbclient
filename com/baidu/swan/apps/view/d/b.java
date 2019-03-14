package com.baidu.swan.apps.view.d;

import android.support.annotation.NonNull;
/* loaded from: classes2.dex */
public class b {
    private int aZI;
    private int aZJ;
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
        return this.aZI;
    }

    public void eA(int i) {
        this.aZI = i;
    }

    public int Nd() {
        return this.aZJ;
    }

    public void eB(int i) {
        this.aZJ = i;
    }
}
