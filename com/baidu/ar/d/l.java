package com.baidu.ar.d;
/* loaded from: classes10.dex */
public class l {
    private String I;
    private int mX;
    private boolean mY;

    public l(String str, boolean z) {
        this.mX = -1;
        this.I = str;
        this.mY = z;
    }

    public l(String str, boolean z, int i) {
        this.mX = -1;
        this.I = str;
        this.mY = z;
        this.mX = i;
    }

    public String dd() {
        return this.I;
    }

    public int dl() {
        return this.mX;
    }

    public boolean isSuccess() {
        return this.mY;
    }
}
