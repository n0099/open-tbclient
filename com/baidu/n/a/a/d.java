package com.baidu.n.a.a;

import android.content.Context;
/* loaded from: classes6.dex */
public abstract class d implements c {
    protected boolean lDS;
    protected String lDU;
    protected String lDV;
    protected String lDW;
    protected boolean lEv;
    protected Context mCtx;
    protected int mStatusCode = -200;

    public d(Context context) {
        if (context != null) {
            this.mCtx = context.getApplicationContext();
        }
    }

    @Override // com.baidu.n.a.a.c
    public boolean dio() {
        return this.lDS;
    }

    @Override // com.baidu.n.a.a.c
    public boolean isSupport() {
        return this.lEv;
    }

    @Override // com.baidu.n.a.a.c
    public String diz() {
        return this.lDU;
    }

    @Override // com.baidu.n.a.a.c
    public String diA() {
        return this.lDV;
    }

    @Override // com.baidu.n.a.a.c
    public String diB() {
        return this.lDW;
    }

    @Override // com.baidu.n.a.a.c
    public int getStatusCode() {
        return this.mStatusCode;
    }

    @Override // com.baidu.n.a.a.c
    public void vd(boolean z) {
        this.lDS = z;
    }

    @Override // com.baidu.n.a.a.c
    public void ve(boolean z) {
        this.lEv = z;
    }

    @Override // com.baidu.n.a.a.c
    public void NJ(String str) {
        this.lDU = str;
    }

    @Override // com.baidu.n.a.a.c
    public void NK(String str) {
        this.lDV = str;
    }

    @Override // com.baidu.n.a.a.c
    public void NL(String str) {
        this.lDW = str;
    }

    @Override // com.baidu.n.a.a.c
    public void Hk(int i) {
        this.mStatusCode = i;
    }
}
