package com.baidu.n.a.a;

import android.content.Context;
/* loaded from: classes5.dex */
public abstract class d implements c {
    protected boolean lBS;
    protected boolean lBp;
    protected String lBr;
    protected String lBs;
    protected String lBt;
    protected Context mCtx;
    protected int mStatusCode = -200;

    public d(Context context) {
        if (context != null) {
            this.mCtx = context.getApplicationContext();
        }
    }

    @Override // com.baidu.n.a.a.c
    public boolean dgy() {
        return this.lBp;
    }

    @Override // com.baidu.n.a.a.c
    public boolean isSupport() {
        return this.lBS;
    }

    @Override // com.baidu.n.a.a.c
    public String dgJ() {
        return this.lBr;
    }

    @Override // com.baidu.n.a.a.c
    public String dgK() {
        return this.lBs;
    }

    @Override // com.baidu.n.a.a.c
    public String dgL() {
        return this.lBt;
    }

    @Override // com.baidu.n.a.a.c
    public int getStatusCode() {
        return this.mStatusCode;
    }

    @Override // com.baidu.n.a.a.c
    public void uS(boolean z) {
        this.lBp = z;
    }

    @Override // com.baidu.n.a.a.c
    public void uT(boolean z) {
        this.lBS = z;
    }

    @Override // com.baidu.n.a.a.c
    public void Nw(String str) {
        this.lBr = str;
    }

    @Override // com.baidu.n.a.a.c
    public void Nx(String str) {
        this.lBs = str;
    }

    @Override // com.baidu.n.a.a.c
    public void Ny(String str) {
        this.lBt = str;
    }

    @Override // com.baidu.n.a.a.c
    public void GZ(int i) {
        this.mStatusCode = i;
    }
}
