package com.baidu.q.a.a;

import android.content.Context;
/* loaded from: classes10.dex */
public abstract class d implements c {
    protected Context mCtx;
    protected int mStatusCode = -200;
    protected boolean nhI;
    protected boolean nhf;
    protected String nhh;
    protected String nhi;
    protected String nhj;

    public d(Context context) {
        if (context != null) {
            this.mCtx = context.getApplicationContext();
        }
    }

    @Override // com.baidu.q.a.a.c
    public boolean dMU() {
        return this.nhf;
    }

    @Override // com.baidu.q.a.a.c
    public boolean isSupport() {
        return this.nhI;
    }

    @Override // com.baidu.q.a.a.c
    public String getOAID() {
        return this.nhh;
    }

    @Override // com.baidu.q.a.a.c
    public String getAAID() {
        return this.nhi;
    }

    @Override // com.baidu.q.a.a.c
    public String getVAID() {
        return this.nhj;
    }

    @Override // com.baidu.q.a.a.c
    public int getStatusCode() {
        return this.mStatusCode;
    }

    @Override // com.baidu.q.a.a.c
    public void xM(boolean z) {
        this.nhf = z;
    }

    @Override // com.baidu.q.a.a.c
    public void xN(boolean z) {
        this.nhI = z;
    }

    @Override // com.baidu.q.a.a.c
    public void Ua(String str) {
        this.nhh = str;
    }

    @Override // com.baidu.q.a.a.c
    public void Ub(String str) {
        this.nhi = str;
    }

    @Override // com.baidu.q.a.a.c
    public void Uc(String str) {
        this.nhj = str;
    }

    @Override // com.baidu.q.a.a.c
    public void KI(int i) {
        this.mStatusCode = i;
    }
}
