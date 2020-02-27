package com.baidu.swan.apps.view.narootview;

import android.support.annotation.NonNull;
/* loaded from: classes11.dex */
public class b {
    private int caQ;
    private int caR;
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

    public int ahL() {
        return this.caQ;
    }

    public void ho(int i) {
        this.caQ = i;
    }

    public int ahM() {
        return this.caR;
    }

    public void hp(int i) {
        this.caR = i;
    }
}
