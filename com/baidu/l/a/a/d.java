package com.baidu.l.a.a;

import android.content.Context;
/* loaded from: classes6.dex */
public abstract class d implements c {
    protected boolean lPO;
    protected boolean lPl;
    protected String lPn;
    protected String lPo;
    protected String lPp;
    protected Context mCtx;
    protected int mStatusCode = -200;

    public d(Context context) {
        if (context != null) {
            this.mCtx = context.getApplicationContext();
        }
    }

    @Override // com.baidu.l.a.a.c
    public boolean dlC() {
        return this.lPl;
    }

    @Override // com.baidu.l.a.a.c
    public boolean isSupport() {
        return this.lPO;
    }

    @Override // com.baidu.l.a.a.c
    public String dlN() {
        return this.lPn;
    }

    @Override // com.baidu.l.a.a.c
    public String dlO() {
        return this.lPo;
    }

    @Override // com.baidu.l.a.a.c
    public String dlP() {
        return this.lPp;
    }

    @Override // com.baidu.l.a.a.c
    public int getStatusCode() {
        return this.mStatusCode;
    }

    @Override // com.baidu.l.a.a.c
    public void vt(boolean z) {
        this.lPl = z;
    }

    @Override // com.baidu.l.a.a.c
    public void vu(boolean z) {
        this.lPO = z;
    }

    @Override // com.baidu.l.a.a.c
    public void NL(String str) {
        this.lPn = str;
    }

    @Override // com.baidu.l.a.a.c
    public void NM(String str) {
        this.lPo = str;
    }

    @Override // com.baidu.l.a.a.c
    public void NN(String str) {
        this.lPp = str;
    }

    @Override // com.baidu.l.a.a.c
    public void FR(int i) {
        this.mStatusCode = i;
    }
}
