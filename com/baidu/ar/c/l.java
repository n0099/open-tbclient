package com.baidu.ar.c;
/* loaded from: classes3.dex */
public class l {
    private String I;
    private int mp;
    private boolean mq;

    public l(String str, boolean z) {
        this.mp = -1;
        this.I = str;
        this.mq = z;
    }

    public l(String str, boolean z, int i) {
        this.mp = -1;
        this.I = str;
        this.mq = z;
        this.mp = i;
    }

    public String cD() {
        return this.I;
    }

    public int cL() {
        return this.mp;
    }

    public boolean isSuccess() {
        return this.mq;
    }
}
