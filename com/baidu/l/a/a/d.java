package com.baidu.l.a.a;

import android.content.Context;
/* loaded from: classes6.dex */
public abstract class d implements c {
    protected Context mCtx;
    protected boolean mFP;
    protected String mFR;
    protected String mFS;
    protected String mFT;
    protected boolean mGs;
    protected int mStatusCode = -200;

    public d(Context context) {
        if (context != null) {
            this.mCtx = context.getApplicationContext();
        }
    }

    @Override // com.baidu.l.a.a.c
    public boolean dxK() {
        return this.mFP;
    }

    @Override // com.baidu.l.a.a.c
    public boolean isSupport() {
        return this.mGs;
    }

    @Override // com.baidu.l.a.a.c
    public String getOAID() {
        return this.mFR;
    }

    @Override // com.baidu.l.a.a.c
    public String getAAID() {
        return this.mFS;
    }

    @Override // com.baidu.l.a.a.c
    public String getVAID() {
        return this.mFT;
    }

    @Override // com.baidu.l.a.a.c
    public int getStatusCode() {
        return this.mStatusCode;
    }

    @Override // com.baidu.l.a.a.c
    public void wp(boolean z) {
        this.mFP = z;
    }

    @Override // com.baidu.l.a.a.c
    public void wq(boolean z) {
        this.mGs = z;
    }

    @Override // com.baidu.l.a.a.c
    public void Qp(String str) {
        this.mFR = str;
    }

    @Override // com.baidu.l.a.a.c
    public void Qq(String str) {
        this.mFS = str;
    }

    @Override // com.baidu.l.a.a.c
    public void Qr(String str) {
        this.mFT = str;
    }

    @Override // com.baidu.l.a.a.c
    public void HN(int i) {
        this.mStatusCode = i;
    }
}
