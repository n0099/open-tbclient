package com.baidu.n.a.a;

import android.content.Context;
/* loaded from: classes4.dex */
public abstract class d implements c {
    protected Context mCtx;
    protected int mStatusCode = -200;
    protected boolean oKA;
    protected String oKC;
    protected String oKD;
    protected String oKE;
    protected boolean oLc;

    public d(Context context) {
        if (context != null) {
            this.mCtx = context.getApplicationContext();
        }
    }

    @Override // com.baidu.n.a.a.c
    public boolean egl() {
        return this.oKA;
    }

    @Override // com.baidu.n.a.a.c
    public boolean isSupport() {
        return this.oLc;
    }

    @Override // com.baidu.n.a.a.c
    public String getOAID() {
        return this.oKC;
    }

    @Override // com.baidu.n.a.a.c
    public String getAAID() {
        return this.oKD;
    }

    @Override // com.baidu.n.a.a.c
    public String getVAID() {
        return this.oKE;
    }

    @Override // com.baidu.n.a.a.c
    public int getStatusCode() {
        return this.mStatusCode;
    }

    @Override // com.baidu.n.a.a.c
    public void Al(boolean z) {
        this.oKA = z;
    }

    @Override // com.baidu.n.a.a.c
    public void Am(boolean z) {
        this.oLc = z;
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
    public void WQ(String str) {
        this.oKE = str;
    }

    @Override // com.baidu.n.a.a.c
    public void MX(int i) {
        this.mStatusCode = i;
    }
}
