package com.baidu.q.a.a;

import android.content.Context;
/* loaded from: classes5.dex */
public abstract class d implements c {
    protected Context mCtx;
    protected int mStatusCode = -200;
    protected boolean osL;
    protected boolean osi;
    protected String osk;
    protected String osl;
    protected String osm;

    public d(Context context) {
        if (context != null) {
            this.mCtx = context.getApplicationContext();
        }
    }

    @Override // com.baidu.q.a.a.c
    public boolean eed() {
        return this.osi;
    }

    @Override // com.baidu.q.a.a.c
    public boolean isSupport() {
        return this.osL;
    }

    @Override // com.baidu.q.a.a.c
    public String getOAID() {
        return this.osk;
    }

    @Override // com.baidu.q.a.a.c
    public String getAAID() {
        return this.osl;
    }

    @Override // com.baidu.q.a.a.c
    public String getVAID() {
        return this.osm;
    }

    @Override // com.baidu.q.a.a.c
    public int getStatusCode() {
        return this.mStatusCode;
    }

    @Override // com.baidu.q.a.a.c
    public void zD(boolean z) {
        this.osi = z;
    }

    @Override // com.baidu.q.a.a.c
    public void zE(boolean z) {
        this.osL = z;
    }

    @Override // com.baidu.q.a.a.c
    public void Xh(String str) {
        this.osk = str;
    }

    @Override // com.baidu.q.a.a.c
    public void Xi(String str) {
        this.osl = str;
    }

    @Override // com.baidu.q.a.a.c
    public void Xj(String str) {
        this.osm = str;
    }

    @Override // com.baidu.q.a.a.c
    public void No(int i) {
        this.mStatusCode = i;
    }
}
