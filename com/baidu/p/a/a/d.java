package com.baidu.p.a.a;

import android.content.Context;
/* loaded from: classes5.dex */
public abstract class d implements c {
    protected Context mCtx;
    protected int mStatusCode = -200;
    protected boolean oPD;
    protected boolean oPb;
    protected String oPd;
    protected String oPe;
    protected String oPf;

    public d(Context context) {
        if (context != null) {
            this.mCtx = context.getApplicationContext();
        }
    }

    @Override // com.baidu.p.a.a.c
    public boolean eke() {
        return this.oPb;
    }

    @Override // com.baidu.p.a.a.c
    public boolean isSupport() {
        return this.oPD;
    }

    @Override // com.baidu.p.a.a.c
    public String getOAID() {
        return this.oPd;
    }

    @Override // com.baidu.p.a.a.c
    public String getAAID() {
        return this.oPe;
    }

    @Override // com.baidu.p.a.a.c
    public String getVAID() {
        return this.oPf;
    }

    @Override // com.baidu.p.a.a.c
    public int getStatusCode() {
        return this.mStatusCode;
    }

    @Override // com.baidu.p.a.a.c
    public void Ap(boolean z) {
        this.oPb = z;
    }

    @Override // com.baidu.p.a.a.c
    public void Aq(boolean z) {
        this.oPD = z;
    }

    @Override // com.baidu.p.a.a.c
    public void XW(String str) {
        this.oPd = str;
    }

    @Override // com.baidu.p.a.a.c
    public void XX(String str) {
        this.oPe = str;
    }

    @Override // com.baidu.p.a.a.c
    public void XY(String str) {
        this.oPf = str;
    }

    @Override // com.baidu.p.a.a.c
    public void OE(int i) {
        this.mStatusCode = i;
    }
}
