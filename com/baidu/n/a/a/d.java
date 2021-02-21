package com.baidu.n.a.a;

import android.content.Context;
/* loaded from: classes6.dex */
public abstract class d implements c {
    protected Context mCtx;
    protected int mStatusCode = -200;
    protected boolean oVI;
    protected boolean oVi;
    protected String oVj;
    protected String oVk;
    protected String oVl;

    public d(Context context) {
        if (context != null) {
            this.mCtx = context.getApplicationContext();
        }
    }

    @Override // com.baidu.n.a.a.c
    public boolean eiL() {
        return this.oVi;
    }

    @Override // com.baidu.n.a.a.c
    public boolean isSupport() {
        return this.oVI;
    }

    @Override // com.baidu.n.a.a.c
    public String getOAID() {
        return this.oVj;
    }

    @Override // com.baidu.n.a.a.c
    public String getAAID() {
        return this.oVk;
    }

    @Override // com.baidu.n.a.a.c
    public String getVAID() {
        return this.oVl;
    }

    @Override // com.baidu.n.a.a.c
    public int getStatusCode() {
        return this.mStatusCode;
    }

    @Override // com.baidu.n.a.a.c
    public void AE(boolean z) {
        this.oVi = z;
    }

    @Override // com.baidu.n.a.a.c
    public void AF(boolean z) {
        this.oVI = z;
    }

    @Override // com.baidu.n.a.a.c
    public void XZ(String str) {
        this.oVj = str;
    }

    @Override // com.baidu.n.a.a.c
    public void Ya(String str) {
        this.oVk = str;
    }

    @Override // com.baidu.n.a.a.c
    public void Yb(String str) {
        this.oVl = str;
    }

    @Override // com.baidu.n.a.a.c
    public void Nu(int i) {
        this.mStatusCode = i;
    }
}
