package com.baidu.r.a.a;

import android.content.Context;
/* loaded from: classes14.dex */
public abstract class d implements c {
    protected Context mCtx;
    protected int mStatusCode = -200;
    protected boolean oIS;
    protected String oIU;
    protected String oIV;
    protected String oIW;
    protected boolean oJu;

    public d(Context context) {
        if (context != null) {
            this.mCtx = context.getApplicationContext();
        }
    }

    @Override // com.baidu.r.a.a.c
    public boolean ejY() {
        return this.oIS;
    }

    @Override // com.baidu.r.a.a.c
    public boolean isSupport() {
        return this.oJu;
    }

    @Override // com.baidu.r.a.a.c
    public String getOAID() {
        return this.oIU;
    }

    @Override // com.baidu.r.a.a.c
    public String getAAID() {
        return this.oIV;
    }

    @Override // com.baidu.r.a.a.c
    public String getVAID() {
        return this.oIW;
    }

    @Override // com.baidu.r.a.a.c
    public int getStatusCode() {
        return this.mStatusCode;
    }

    @Override // com.baidu.r.a.a.c
    public void Ao(boolean z) {
        this.oIS = z;
    }

    @Override // com.baidu.r.a.a.c
    public void Ap(boolean z) {
        this.oJu = z;
    }

    @Override // com.baidu.r.a.a.c
    public void Yn(String str) {
        this.oIU = str;
    }

    @Override // com.baidu.r.a.a.c
    public void Yo(String str) {
        this.oIV = str;
    }

    @Override // com.baidu.r.a.a.c
    public void Yp(String str) {
        this.oIW = str;
    }

    @Override // com.baidu.r.a.a.c
    public void OP(int i) {
        this.mStatusCode = i;
    }
}
