package com.baidu.q.a.a;

import android.content.Context;
/* loaded from: classes5.dex */
public abstract class d implements c {
    protected Context mCtx;
    protected int mStatusCode = -200;
    protected boolean nGA;
    protected String nGC;
    protected String nGD;
    protected String nGE;
    protected boolean nHd;

    public d(Context context) {
        if (context != null) {
            this.mCtx = context.getApplicationContext();
        }
    }

    @Override // com.baidu.q.a.a.c
    public boolean dUD() {
        return this.nGA;
    }

    @Override // com.baidu.q.a.a.c
    public boolean isSupport() {
        return this.nHd;
    }

    @Override // com.baidu.q.a.a.c
    public String getOAID() {
        return this.nGC;
    }

    @Override // com.baidu.q.a.a.c
    public String getAAID() {
        return this.nGD;
    }

    @Override // com.baidu.q.a.a.c
    public String getVAID() {
        return this.nGE;
    }

    @Override // com.baidu.q.a.a.c
    public int getStatusCode() {
        return this.mStatusCode;
    }

    @Override // com.baidu.q.a.a.c
    public void yC(boolean z) {
        this.nGA = z;
    }

    @Override // com.baidu.q.a.a.c
    public void yD(boolean z) {
        this.nHd = z;
    }

    @Override // com.baidu.q.a.a.c
    public void Vq(String str) {
        this.nGC = str;
    }

    @Override // com.baidu.q.a.a.c
    public void Vr(String str) {
        this.nGD = str;
    }

    @Override // com.baidu.q.a.a.c
    public void Vs(String str) {
        this.nGE = str;
    }

    @Override // com.baidu.q.a.a.c
    public void LT(int i) {
        this.mStatusCode = i;
    }
}
