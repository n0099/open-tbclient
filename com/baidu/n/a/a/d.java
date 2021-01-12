package com.baidu.n.a.a;

import android.content.Context;
/* loaded from: classes4.dex */
public abstract class d implements c {
    protected Context mCtx;
    protected int mStatusCode = -200;
    protected String oKB;
    protected String oKC;
    protected String oKD;
    protected boolean oKz;
    protected boolean oLb;

    public d(Context context) {
        if (context != null) {
            this.mCtx = context.getApplicationContext();
        }
    }

    @Override // com.baidu.n.a.a.c
    public boolean egl() {
        return this.oKz;
    }

    @Override // com.baidu.n.a.a.c
    public boolean isSupport() {
        return this.oLb;
    }

    @Override // com.baidu.n.a.a.c
    public String getOAID() {
        return this.oKB;
    }

    @Override // com.baidu.n.a.a.c
    public String getAAID() {
        return this.oKC;
    }

    @Override // com.baidu.n.a.a.c
    public String getVAID() {
        return this.oKD;
    }

    @Override // com.baidu.n.a.a.c
    public int getStatusCode() {
        return this.mStatusCode;
    }

    @Override // com.baidu.n.a.a.c
    public void Al(boolean z) {
        this.oKz = z;
    }

    @Override // com.baidu.n.a.a.c
    public void Am(boolean z) {
        this.oLb = z;
    }

    @Override // com.baidu.n.a.a.c
    public void WN(String str) {
        this.oKB = str;
    }

    @Override // com.baidu.n.a.a.c
    public void WO(String str) {
        this.oKC = str;
    }

    @Override // com.baidu.n.a.a.c
    public void WP(String str) {
        this.oKD = str;
    }

    @Override // com.baidu.n.a.a.c
    public void MX(int i) {
        this.mStatusCode = i;
    }
}
