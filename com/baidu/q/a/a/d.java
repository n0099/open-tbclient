package com.baidu.q.a.a;

import android.content.Context;
/* loaded from: classes25.dex */
public abstract class d implements c {
    protected Context mCtx;
    protected int mStatusCode = -200;
    protected boolean nrJ;
    protected boolean nrg;
    protected String nri;
    protected String nrj;
    protected String nrk;

    public d(Context context) {
        if (context != null) {
            this.mCtx = context.getApplicationContext();
        }
    }

    @Override // com.baidu.q.a.a.c
    public boolean dQS() {
        return this.nrg;
    }

    @Override // com.baidu.q.a.a.c
    public boolean isSupport() {
        return this.nrJ;
    }

    @Override // com.baidu.q.a.a.c
    public String getOAID() {
        return this.nri;
    }

    @Override // com.baidu.q.a.a.c
    public String getAAID() {
        return this.nrj;
    }

    @Override // com.baidu.q.a.a.c
    public String getVAID() {
        return this.nrk;
    }

    @Override // com.baidu.q.a.a.c
    public int getStatusCode() {
        return this.mStatusCode;
    }

    @Override // com.baidu.q.a.a.c
    public void xV(boolean z) {
        this.nrg = z;
    }

    @Override // com.baidu.q.a.a.c
    public void xW(boolean z) {
        this.nrJ = z;
    }

    @Override // com.baidu.q.a.a.c
    public void UC(String str) {
        this.nri = str;
    }

    @Override // com.baidu.q.a.a.c
    public void UD(String str) {
        this.nrj = str;
    }

    @Override // com.baidu.q.a.a.c
    public void UE(String str) {
        this.nrk = str;
    }

    @Override // com.baidu.q.a.a.c
    public void Ln(int i) {
        this.mStatusCode = i;
    }
}
