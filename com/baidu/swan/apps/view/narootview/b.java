package com.baidu.swan.apps.view.narootview;

import android.support.annotation.NonNull;
/* loaded from: classes11.dex */
public class b {
    private int cbd;
    private int cbe;
    private int mFlags = 0;

    @NonNull
    public b hm(int i) {
        this.mFlags |= i;
        return this;
    }

    public void hn(int i) {
        this.mFlags &= i ^ (-1);
    }

    public boolean isFixed() {
        return (this.mFlags & 1) == 1;
    }

    public int ahQ() {
        return this.cbd;
    }

    public void ho(int i) {
        this.cbd = i;
    }

    public int ahR() {
        return this.cbe;
    }

    public void hp(int i) {
        this.cbe = i;
    }
}
