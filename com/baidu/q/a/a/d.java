package com.baidu.q.a.a;

import android.content.Context;
/* loaded from: classes10.dex */
public abstract class d implements c {
    protected Context mCtx;
    protected int mStatusCode = -200;
    protected boolean ngN;
    protected String ngP;
    protected String ngQ;
    protected String ngR;
    protected boolean nhq;

    public d(Context context) {
        if (context != null) {
            this.mCtx = context.getApplicationContext();
        }
    }

    @Override // com.baidu.q.a.a.c
    public boolean dML() {
        return this.ngN;
    }

    @Override // com.baidu.q.a.a.c
    public boolean isSupport() {
        return this.nhq;
    }

    @Override // com.baidu.q.a.a.c
    public String getOAID() {
        return this.ngP;
    }

    @Override // com.baidu.q.a.a.c
    public String getAAID() {
        return this.ngQ;
    }

    @Override // com.baidu.q.a.a.c
    public String getVAID() {
        return this.ngR;
    }

    @Override // com.baidu.q.a.a.c
    public int getStatusCode() {
        return this.mStatusCode;
    }

    @Override // com.baidu.q.a.a.c
    public void xK(boolean z) {
        this.ngN = z;
    }

    @Override // com.baidu.q.a.a.c
    public void xL(boolean z) {
        this.nhq = z;
    }

    @Override // com.baidu.q.a.a.c
    public void Ua(String str) {
        this.ngP = str;
    }

    @Override // com.baidu.q.a.a.c
    public void Ub(String str) {
        this.ngQ = str;
    }

    @Override // com.baidu.q.a.a.c
    public void Uc(String str) {
        this.ngR = str;
    }

    @Override // com.baidu.q.a.a.c
    public void KI(int i) {
        this.mStatusCode = i;
    }
}
