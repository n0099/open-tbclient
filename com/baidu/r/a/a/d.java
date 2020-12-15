package com.baidu.r.a.a;

import android.content.Context;
/* loaded from: classes14.dex */
public abstract class d implements c {
    protected Context mCtx;
    protected int mStatusCode = -200;
    protected boolean oIU;
    protected String oIW;
    protected String oIX;
    protected String oIY;
    protected boolean oJw;

    public d(Context context) {
        if (context != null) {
            this.mCtx = context.getApplicationContext();
        }
    }

    @Override // com.baidu.r.a.a.c
    public boolean ejZ() {
        return this.oIU;
    }

    @Override // com.baidu.r.a.a.c
    public boolean isSupport() {
        return this.oJw;
    }

    @Override // com.baidu.r.a.a.c
    public String getOAID() {
        return this.oIW;
    }

    @Override // com.baidu.r.a.a.c
    public String getAAID() {
        return this.oIX;
    }

    @Override // com.baidu.r.a.a.c
    public String getVAID() {
        return this.oIY;
    }

    @Override // com.baidu.r.a.a.c
    public int getStatusCode() {
        return this.mStatusCode;
    }

    @Override // com.baidu.r.a.a.c
    public void Ao(boolean z) {
        this.oIU = z;
    }

    @Override // com.baidu.r.a.a.c
    public void Ap(boolean z) {
        this.oJw = z;
    }

    @Override // com.baidu.r.a.a.c
    public void Yn(String str) {
        this.oIW = str;
    }

    @Override // com.baidu.r.a.a.c
    public void Yo(String str) {
        this.oIX = str;
    }

    @Override // com.baidu.r.a.a.c
    public void Yp(String str) {
        this.oIY = str;
    }

    @Override // com.baidu.r.a.a.c
    public void OP(int i) {
        this.mStatusCode = i;
    }
}
