package com.baidu.swan.apps.view.narootview;

import android.support.annotation.NonNull;
/* loaded from: classes11.dex */
public class b {
    private int cAf;
    private int cAg;
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

    public int apY() {
        return this.cAf;
    }

    public void hv(int i) {
        this.cAf = i;
    }

    public int apZ() {
        return this.cAg;
    }

    public void hw(int i) {
        this.cAg = i;
    }
}
