package com.baidu.q.a.a;

import android.content.Context;
/* loaded from: classes5.dex */
public abstract class d implements c {
    protected Context mCtx;
    protected int mStatusCode = -200;
    protected boolean ojF;
    protected boolean ojc;
    protected String oje;
    protected String ojf;
    protected String ojg;

    public d(Context context) {
        if (context != null) {
            this.mCtx = context.getApplicationContext();
        }
    }

    @Override // com.baidu.q.a.a.c
    public boolean eav() {
        return this.ojc;
    }

    @Override // com.baidu.q.a.a.c
    public boolean isSupport() {
        return this.ojF;
    }

    @Override // com.baidu.q.a.a.c
    public String getOAID() {
        return this.oje;
    }

    @Override // com.baidu.q.a.a.c
    public String getAAID() {
        return this.ojf;
    }

    @Override // com.baidu.q.a.a.c
    public String getVAID() {
        return this.ojg;
    }

    @Override // com.baidu.q.a.a.c
    public int getStatusCode() {
        return this.mStatusCode;
    }

    @Override // com.baidu.q.a.a.c
    public void zs(boolean z) {
        this.ojc = z;
    }

    @Override // com.baidu.q.a.a.c
    public void zt(boolean z) {
        this.ojF = z;
    }

    @Override // com.baidu.q.a.a.c
    public void WE(String str) {
        this.oje = str;
    }

    @Override // com.baidu.q.a.a.c
    public void WF(String str) {
        this.ojf = str;
    }

    @Override // com.baidu.q.a.a.c
    public void WG(String str) {
        this.ojg = str;
    }

    @Override // com.baidu.q.a.a.c
    public void MV(int i) {
        this.mStatusCode = i;
    }
}
