package com.baidu.n.a.a;

import android.content.Context;
/* loaded from: classes5.dex */
public abstract class d implements c {
    protected boolean lBX;
    protected boolean lBu;
    protected String lBw;
    protected String lBx;
    protected String lBy;
    protected Context mCtx;
    protected int mStatusCode = -200;

    public d(Context context) {
        if (context != null) {
            this.mCtx = context.getApplicationContext();
        }
    }

    @Override // com.baidu.n.a.a.c
    public boolean dgA() {
        return this.lBu;
    }

    @Override // com.baidu.n.a.a.c
    public boolean isSupport() {
        return this.lBX;
    }

    @Override // com.baidu.n.a.a.c
    public String dgL() {
        return this.lBw;
    }

    @Override // com.baidu.n.a.a.c
    public String dgM() {
        return this.lBx;
    }

    @Override // com.baidu.n.a.a.c
    public String dgN() {
        return this.lBy;
    }

    @Override // com.baidu.n.a.a.c
    public int getStatusCode() {
        return this.mStatusCode;
    }

    @Override // com.baidu.n.a.a.c
    public void uS(boolean z) {
        this.lBu = z;
    }

    @Override // com.baidu.n.a.a.c
    public void uT(boolean z) {
        this.lBX = z;
    }

    @Override // com.baidu.n.a.a.c
    public void Nw(String str) {
        this.lBw = str;
    }

    @Override // com.baidu.n.a.a.c
    public void Nx(String str) {
        this.lBx = str;
    }

    @Override // com.baidu.n.a.a.c
    public void Ny(String str) {
        this.lBy = str;
    }

    @Override // com.baidu.n.a.a.c
    public void GZ(int i) {
        this.mStatusCode = i;
    }
}
