package com.baidu.n.a.a;

import android.content.Context;
/* loaded from: classes4.dex */
public abstract class d implements c {
    protected boolean lxQ;
    protected String lxS;
    protected String lxT;
    protected String lxU;
    protected boolean lyu;
    protected Context mCtx;
    protected int mStatusCode = -200;

    public d(Context context) {
        if (context != null) {
            this.mCtx = context.getApplicationContext();
        }
    }

    @Override // com.baidu.n.a.a.c
    public boolean dfw() {
        return this.lxQ;
    }

    @Override // com.baidu.n.a.a.c
    public boolean isSupport() {
        return this.lyu;
    }

    @Override // com.baidu.n.a.a.c
    public String dfH() {
        return this.lxS;
    }

    @Override // com.baidu.n.a.a.c
    public String dfI() {
        return this.lxT;
    }

    @Override // com.baidu.n.a.a.c
    public String dfJ() {
        return this.lxU;
    }

    @Override // com.baidu.n.a.a.c
    public int getStatusCode() {
        return this.mStatusCode;
    }

    @Override // com.baidu.n.a.a.c
    public void uH(boolean z) {
        this.lxQ = z;
    }

    @Override // com.baidu.n.a.a.c
    public void uI(boolean z) {
        this.lyu = z;
    }

    @Override // com.baidu.n.a.a.c
    public void Nm(String str) {
        this.lxS = str;
    }

    @Override // com.baidu.n.a.a.c
    public void Nn(String str) {
        this.lxT = str;
    }

    @Override // com.baidu.n.a.a.c
    public void No(String str) {
        this.lxU = str;
    }

    @Override // com.baidu.n.a.a.c
    public void GU(int i) {
        this.mStatusCode = i;
    }
}
