package com.baidu.n.a.a;

import android.content.Context;
/* loaded from: classes4.dex */
public abstract class d implements c {
    protected Context mCtx;
    protected int mStatusCode = -200;
    protected boolean oXN;
    protected boolean oXn;
    protected String oXo;
    protected String oXp;
    protected String oXq;

    public d(Context context) {
        if (context != null) {
            this.mCtx = context.getApplicationContext();
        }
    }

    @Override // com.baidu.n.a.a.c
    public boolean eiV() {
        return this.oXn;
    }

    @Override // com.baidu.n.a.a.c
    public boolean isSupport() {
        return this.oXN;
    }

    @Override // com.baidu.n.a.a.c
    public String getOAID() {
        return this.oXo;
    }

    @Override // com.baidu.n.a.a.c
    public String getAAID() {
        return this.oXp;
    }

    @Override // com.baidu.n.a.a.c
    public String getVAID() {
        return this.oXq;
    }

    @Override // com.baidu.n.a.a.c
    public int getStatusCode() {
        return this.mStatusCode;
    }

    @Override // com.baidu.n.a.a.c
    public void AD(boolean z) {
        this.oXn = z;
    }

    @Override // com.baidu.n.a.a.c
    public void AE(boolean z) {
        this.oXN = z;
    }

    @Override // com.baidu.n.a.a.c
    public void Yg(String str) {
        this.oXo = str;
    }

    @Override // com.baidu.n.a.a.c
    public void Yh(String str) {
        this.oXp = str;
    }

    @Override // com.baidu.n.a.a.c
    public void Yi(String str) {
        this.oXq = str;
    }

    @Override // com.baidu.n.a.a.c
    public void Ny(int i) {
        this.mStatusCode = i;
    }
}
