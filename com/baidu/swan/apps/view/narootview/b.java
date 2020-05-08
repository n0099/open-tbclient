package com.baidu.swan.apps.view.narootview;

import android.support.annotation.NonNull;
/* loaded from: classes11.dex */
public class b {
    private int cAl;
    private int cAm;
    private int mFlags = 0;

    @NonNull
    public b ht(int i) {
        this.mFlags |= i;
        return this;
    }

    public void hu(int i) {
        this.mFlags &= i ^ (-1);
    }

    public boolean isFixed() {
        return (this.mFlags & 1) == 1;
    }

    public int apX() {
        return this.cAl;
    }

    public void hv(int i) {
        this.cAl = i;
    }

    public int apY() {
        return this.cAm;
    }

    public void hw(int i) {
        this.cAm = i;
    }
}
