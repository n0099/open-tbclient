package com.baidu.n.a.a;

import android.content.Context;
/* loaded from: classes6.dex */
public abstract class d implements c {
    protected boolean lCR;
    protected boolean lCo;
    protected String lCq;
    protected String lCr;
    protected String lCs;
    protected Context mCtx;
    protected int mStatusCode = -200;

    public d(Context context) {
        if (context != null) {
            this.mCtx = context.getApplicationContext();
        }
    }

    @Override // com.baidu.n.a.a.c
    public boolean dhR() {
        return this.lCo;
    }

    @Override // com.baidu.n.a.a.c
    public boolean isSupport() {
        return this.lCR;
    }

    @Override // com.baidu.n.a.a.c
    public String dic() {
        return this.lCq;
    }

    @Override // com.baidu.n.a.a.c
    public String did() {
        return this.lCr;
    }

    @Override // com.baidu.n.a.a.c
    public String die() {
        return this.lCs;
    }

    @Override // com.baidu.n.a.a.c
    public int getStatusCode() {
        return this.mStatusCode;
    }

    @Override // com.baidu.n.a.a.c
    public void uW(boolean z) {
        this.lCo = z;
    }

    @Override // com.baidu.n.a.a.c
    public void uX(boolean z) {
        this.lCR = z;
    }

    @Override // com.baidu.n.a.a.c
    public void NJ(String str) {
        this.lCq = str;
    }

    @Override // com.baidu.n.a.a.c
    public void NK(String str) {
        this.lCr = str;
    }

    @Override // com.baidu.n.a.a.c
    public void NL(String str) {
        this.lCs = str;
    }

    @Override // com.baidu.n.a.a.c
    public void He(int i) {
        this.mStatusCode = i;
    }
}
