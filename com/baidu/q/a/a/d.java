package com.baidu.q.a.a;

import android.content.Context;
/* loaded from: classes7.dex */
public abstract class d implements c {
    protected Context mCtx;
    protected int mStatusCode = -200;
    protected boolean otL;
    protected String otN;
    protected String otO;
    protected String otP;
    protected boolean oun;

    public d(Context context) {
        if (context != null) {
            this.mCtx = context.getApplicationContext();
        }
    }

    @Override // com.baidu.q.a.a.c
    public boolean eel() {
        return this.otL;
    }

    @Override // com.baidu.q.a.a.c
    public boolean isSupport() {
        return this.oun;
    }

    @Override // com.baidu.q.a.a.c
    public String getOAID() {
        return this.otN;
    }

    @Override // com.baidu.q.a.a.c
    public String getAAID() {
        return this.otO;
    }

    @Override // com.baidu.q.a.a.c
    public String getVAID() {
        return this.otP;
    }

    @Override // com.baidu.q.a.a.c
    public int getStatusCode() {
        return this.mStatusCode;
    }

    @Override // com.baidu.q.a.a.c
    public void zK(boolean z) {
        this.otL = z;
    }

    @Override // com.baidu.q.a.a.c
    public void zL(boolean z) {
        this.oun = z;
    }

    @Override // com.baidu.q.a.a.c
    public void WS(String str) {
        this.otN = str;
    }

    @Override // com.baidu.q.a.a.c
    public void WT(String str) {
        this.otO = str;
    }

    @Override // com.baidu.q.a.a.c
    public void WU(String str) {
        this.otP = str;
    }

    @Override // com.baidu.q.a.a.c
    public void NR(int i) {
        this.mStatusCode = i;
    }
}
