package com.baidu.n.a.a;

import android.content.Context;
/* loaded from: classes6.dex */
public abstract class d implements c {
    protected boolean lCE;
    protected boolean lCb;
    protected String lCd;
    protected String lCe;
    protected String lCf;
    protected Context mCtx;
    protected int mStatusCode = -200;

    public d(Context context) {
        if (context != null) {
            this.mCtx = context.getApplicationContext();
        }
    }

    @Override // com.baidu.n.a.a.c
    public boolean dhO() {
        return this.lCb;
    }

    @Override // com.baidu.n.a.a.c
    public boolean isSupport() {
        return this.lCE;
    }

    @Override // com.baidu.n.a.a.c
    public String dhZ() {
        return this.lCd;
    }

    @Override // com.baidu.n.a.a.c
    public String dia() {
        return this.lCe;
    }

    @Override // com.baidu.n.a.a.c
    public String dib() {
        return this.lCf;
    }

    @Override // com.baidu.n.a.a.c
    public int getStatusCode() {
        return this.mStatusCode;
    }

    @Override // com.baidu.n.a.a.c
    public void uW(boolean z) {
        this.lCb = z;
    }

    @Override // com.baidu.n.a.a.c
    public void uX(boolean z) {
        this.lCE = z;
    }

    @Override // com.baidu.n.a.a.c
    public void NI(String str) {
        this.lCd = str;
    }

    @Override // com.baidu.n.a.a.c
    public void NJ(String str) {
        this.lCe = str;
    }

    @Override // com.baidu.n.a.a.c
    public void NK(String str) {
        this.lCf = str;
    }

    @Override // com.baidu.n.a.a.c
    public void He(int i) {
        this.mStatusCode = i;
    }
}
