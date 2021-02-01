package com.baidu.n.a.a;

import android.content.Context;
/* loaded from: classes6.dex */
public abstract class d implements c {
    protected Context mCtx;
    protected int mStatusCode = -200;
    protected boolean oUI;
    protected String oUJ;
    protected String oUK;
    protected String oUL;
    protected boolean oVi;

    public d(Context context) {
        if (context != null) {
            this.mCtx = context.getApplicationContext();
        }
    }

    @Override // com.baidu.n.a.a.c
    public boolean eiD() {
        return this.oUI;
    }

    @Override // com.baidu.n.a.a.c
    public boolean isSupport() {
        return this.oVi;
    }

    @Override // com.baidu.n.a.a.c
    public String getOAID() {
        return this.oUJ;
    }

    @Override // com.baidu.n.a.a.c
    public String getAAID() {
        return this.oUK;
    }

    @Override // com.baidu.n.a.a.c
    public String getVAID() {
        return this.oUL;
    }

    @Override // com.baidu.n.a.a.c
    public int getStatusCode() {
        return this.mStatusCode;
    }

    @Override // com.baidu.n.a.a.c
    public void AE(boolean z) {
        this.oUI = z;
    }

    @Override // com.baidu.n.a.a.c
    public void AF(boolean z) {
        this.oVi = z;
    }

    @Override // com.baidu.n.a.a.c
    public void XN(String str) {
        this.oUJ = str;
    }

    @Override // com.baidu.n.a.a.c
    public void XO(String str) {
        this.oUK = str;
    }

    @Override // com.baidu.n.a.a.c
    public void XP(String str) {
        this.oUL = str;
    }

    @Override // com.baidu.n.a.a.c
    public void Nt(int i) {
        this.mStatusCode = i;
    }
}
