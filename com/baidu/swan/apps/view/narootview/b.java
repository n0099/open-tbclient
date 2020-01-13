package com.baidu.swan.apps.view.narootview;

import android.support.annotation.NonNull;
/* loaded from: classes10.dex */
public class b {
    private int bWM;
    private int bWN;
    private int mFlags = 0;

    @NonNull
    public b gV(int i) {
        this.mFlags |= i;
        return this;
    }

    public void gW(int i) {
        this.mFlags &= i ^ (-1);
    }

    public boolean isFixed() {
        return (this.mFlags & 1) == 1;
    }

    public int afx() {
        return this.bWM;
    }

    public void gX(int i) {
        this.bWM = i;
    }

    public int afy() {
        return this.bWN;
    }

    public void gY(int i) {
        this.bWN = i;
    }
}
