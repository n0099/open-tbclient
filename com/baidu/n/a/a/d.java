package com.baidu.n.a.a;

import android.content.Context;
/* loaded from: classes6.dex */
public abstract class d implements c {
    protected boolean lCG;
    protected boolean lCd;
    protected String lCf;
    protected String lCg;
    protected String lCh;
    protected Context mCtx;
    protected int mStatusCode = -200;

    public d(Context context) {
        if (context != null) {
            this.mCtx = context.getApplicationContext();
        }
    }

    @Override // com.baidu.n.a.a.c
    public boolean dhQ() {
        return this.lCd;
    }

    @Override // com.baidu.n.a.a.c
    public boolean isSupport() {
        return this.lCG;
    }

    @Override // com.baidu.n.a.a.c
    public String dib() {
        return this.lCf;
    }

    @Override // com.baidu.n.a.a.c
    public String dic() {
        return this.lCg;
    }

    @Override // com.baidu.n.a.a.c
    public String did() {
        return this.lCh;
    }

    @Override // com.baidu.n.a.a.c
    public int getStatusCode() {
        return this.mStatusCode;
    }

    @Override // com.baidu.n.a.a.c
    public void uW(boolean z) {
        this.lCd = z;
    }

    @Override // com.baidu.n.a.a.c
    public void uX(boolean z) {
        this.lCG = z;
    }

    @Override // com.baidu.n.a.a.c
    public void NI(String str) {
        this.lCf = str;
    }

    @Override // com.baidu.n.a.a.c
    public void NJ(String str) {
        this.lCg = str;
    }

    @Override // com.baidu.n.a.a.c
    public void NK(String str) {
        this.lCh = str;
    }

    @Override // com.baidu.n.a.a.c
    public void He(int i) {
        this.mStatusCode = i;
    }
}
