package com.baidu.swan.apps.view.narootview;

import android.support.annotation.NonNull;
/* loaded from: classes11.dex */
public class b {
    private int cRX;
    private int cRY;
    private int mFlags = 0;

    @NonNull
    public b id(int i) {
        this.mFlags |= i;
        return this;
    }

    public void ie(int i) {
        this.mFlags &= i ^ (-1);
    }

    public boolean isFixed() {
        return (this.mFlags & 1) == 1;
    }

    public int avL() {
        return this.cRX;
    }

    /* renamed from: if  reason: not valid java name */
    public void m27if(int i) {
        this.cRX = i;
    }

    public int avM() {
        return this.cRY;
    }

    public void ig(int i) {
        this.cRY = i;
    }
}
