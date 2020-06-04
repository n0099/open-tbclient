package com.baidu.swan.apps.view.narootview;

import android.support.annotation.NonNull;
/* loaded from: classes11.dex */
public class b {
    private int cNn;
    private int cNo;
    private int mFlags = 0;

    @NonNull
    public b hS(int i) {
        this.mFlags |= i;
        return this;
    }

    public void hT(int i) {
        this.mFlags &= i ^ (-1);
    }

    public boolean isFixed() {
        return (this.mFlags & 1) == 1;
    }

    public int auF() {
        return this.cNn;
    }

    public void hU(int i) {
        this.cNn = i;
    }

    public int auG() {
        return this.cNo;
    }

    public void hV(int i) {
        this.cNo = i;
    }
}
