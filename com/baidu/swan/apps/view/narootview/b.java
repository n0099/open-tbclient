package com.baidu.swan.apps.view.narootview;

import android.support.annotation.NonNull;
/* loaded from: classes8.dex */
public class b {
    private int deU;
    private int deV;
    private int mFlags = 0;

    @NonNull
    public b kw(int i) {
        this.mFlags |= i;
        return this;
    }

    public void kx(int i) {
        this.mFlags &= i ^ (-1);
    }

    public boolean isFixed() {
        return (this.mFlags & 1) == 1;
    }

    public int aGm() {
        return this.deU;
    }

    public void ky(int i) {
        this.deU = i;
    }

    public int aGn() {
        return this.deV;
    }

    public void kz(int i) {
        this.deV = i;
    }
}
