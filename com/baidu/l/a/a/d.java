package com.baidu.l.a.a;

import android.content.Context;
/* loaded from: classes6.dex */
public abstract class d implements c {
    protected Context mCtx;
    protected int mStatusCode = -200;
    protected boolean miG;
    protected String miI;
    protected String miJ;
    protected String miK;
    protected boolean mjj;

    public d(Context context) {
        if (context != null) {
            this.mCtx = context.getApplicationContext();
        }
    }

    @Override // com.baidu.l.a.a.c
    public boolean dsP() {
        return this.miG;
    }

    @Override // com.baidu.l.a.a.c
    public boolean isSupport() {
        return this.mjj;
    }

    @Override // com.baidu.l.a.a.c
    public String getOAID() {
        return this.miI;
    }

    @Override // com.baidu.l.a.a.c
    public String getAAID() {
        return this.miJ;
    }

    @Override // com.baidu.l.a.a.c
    public String getVAID() {
        return this.miK;
    }

    @Override // com.baidu.l.a.a.c
    public int getStatusCode() {
        return this.mStatusCode;
    }

    @Override // com.baidu.l.a.a.c
    public void vR(boolean z) {
        this.miG = z;
    }

    @Override // com.baidu.l.a.a.c
    public void vS(boolean z) {
        this.mjj = z;
    }

    @Override // com.baidu.l.a.a.c
    public void PB(String str) {
        this.miI = str;
    }

    @Override // com.baidu.l.a.a.c
    public void PC(String str) {
        this.miJ = str;
    }

    @Override // com.baidu.l.a.a.c
    public void PD(String str) {
        this.miK = str;
    }

    @Override // com.baidu.l.a.a.c
    public void GE(int i) {
        this.mStatusCode = i;
    }
}
