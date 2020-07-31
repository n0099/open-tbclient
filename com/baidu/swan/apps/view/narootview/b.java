package com.baidu.swan.apps.view.narootview;

import android.support.annotation.NonNull;
/* loaded from: classes7.dex */
public class b {
    private int cVO;
    private int cVP;
    private int mFlags = 0;

    @NonNull
    public b io(int i) {
        this.mFlags |= i;
        return this;
    }

    public void ip(int i) {
        this.mFlags &= i ^ (-1);
    }

    public boolean isFixed() {
        return (this.mFlags & 1) == 1;
    }

    public int aye() {
        return this.cVO;
    }

    public void iq(int i) {
        this.cVO = i;
    }

    public int ayf() {
        return this.cVP;
    }

    public void ir(int i) {
        this.cVP = i;
    }
}
