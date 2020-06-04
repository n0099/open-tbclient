package com.baidu.l.a.a;

import android.content.Context;
/* loaded from: classes6.dex */
public abstract class d implements c {
    protected Context mCtx;
    protected int mStatusCode = -200;
    protected boolean mjQ;
    protected String mjS;
    protected String mjT;
    protected String mjU;
    protected boolean mkt;

    public d(Context context) {
        if (context != null) {
            this.mCtx = context.getApplicationContext();
        }
    }

    @Override // com.baidu.l.a.a.c
    public boolean dtd() {
        return this.mjQ;
    }

    @Override // com.baidu.l.a.a.c
    public boolean isSupport() {
        return this.mkt;
    }

    @Override // com.baidu.l.a.a.c
    public String getOAID() {
        return this.mjS;
    }

    @Override // com.baidu.l.a.a.c
    public String getAAID() {
        return this.mjT;
    }

    @Override // com.baidu.l.a.a.c
    public String getVAID() {
        return this.mjU;
    }

    @Override // com.baidu.l.a.a.c
    public int getStatusCode() {
        return this.mStatusCode;
    }

    @Override // com.baidu.l.a.a.c
    public void vT(boolean z) {
        this.mjQ = z;
    }

    @Override // com.baidu.l.a.a.c
    public void vU(boolean z) {
        this.mkt = z;
    }

    @Override // com.baidu.l.a.a.c
    public void PC(String str) {
        this.mjS = str;
    }

    @Override // com.baidu.l.a.a.c
    public void PD(String str) {
        this.mjT = str;
    }

    @Override // com.baidu.l.a.a.c
    public void PE(String str) {
        this.mjU = str;
    }

    @Override // com.baidu.l.a.a.c
    public void GG(int i) {
        this.mStatusCode = i;
    }
}
