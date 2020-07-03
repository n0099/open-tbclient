package com.baidu.l.a.a;

import android.content.Context;
/* loaded from: classes6.dex */
public abstract class d implements c {
    protected Context mCtx;
    protected boolean mFM;
    protected String mFO;
    protected String mFP;
    protected String mFQ;
    protected boolean mGp;
    protected int mStatusCode = -200;

    public d(Context context) {
        if (context != null) {
            this.mCtx = context.getApplicationContext();
        }
    }

    @Override // com.baidu.l.a.a.c
    public boolean dxG() {
        return this.mFM;
    }

    @Override // com.baidu.l.a.a.c
    public boolean isSupport() {
        return this.mGp;
    }

    @Override // com.baidu.l.a.a.c
    public String getOAID() {
        return this.mFO;
    }

    @Override // com.baidu.l.a.a.c
    public String getAAID() {
        return this.mFP;
    }

    @Override // com.baidu.l.a.a.c
    public String getVAID() {
        return this.mFQ;
    }

    @Override // com.baidu.l.a.a.c
    public int getStatusCode() {
        return this.mStatusCode;
    }

    @Override // com.baidu.l.a.a.c
    public void wp(boolean z) {
        this.mFM = z;
    }

    @Override // com.baidu.l.a.a.c
    public void wq(boolean z) {
        this.mGp = z;
    }

    @Override // com.baidu.l.a.a.c
    public void Qo(String str) {
        this.mFO = str;
    }

    @Override // com.baidu.l.a.a.c
    public void Qp(String str) {
        this.mFP = str;
    }

    @Override // com.baidu.l.a.a.c
    public void Qq(String str) {
        this.mFQ = str;
    }

    @Override // com.baidu.l.a.a.c
    public void HN(int i) {
        this.mStatusCode = i;
    }
}
