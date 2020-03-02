package com.baidu.swan.apps.view.narootview;

import android.support.annotation.NonNull;
/* loaded from: classes11.dex */
public class b {
    private int caR;
    private int caS;
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

    public int ahN() {
        return this.caR;
    }

    public void ho(int i) {
        this.caR = i;
    }

    public int ahO() {
        return this.caS;
    }

    public void hp(int i) {
        this.caS = i;
    }
}
