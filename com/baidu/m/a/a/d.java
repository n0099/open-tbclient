package com.baidu.m.a.a;

import android.content.Context;
/* loaded from: classes12.dex */
public abstract class d implements c {
    protected Context mCtx;
    protected boolean mNT;
    protected String mNV;
    protected String mNW;
    protected String mNX;
    protected boolean mOw;
    protected int mStatusCode = -200;

    public d(Context context) {
        if (context != null) {
            this.mCtx = context.getApplicationContext();
        }
    }

    @Override // com.baidu.m.a.a.c
    public boolean dAW() {
        return this.mNT;
    }

    @Override // com.baidu.m.a.a.c
    public boolean isSupport() {
        return this.mOw;
    }

    @Override // com.baidu.m.a.a.c
    public String getOAID() {
        return this.mNV;
    }

    @Override // com.baidu.m.a.a.c
    public String getAAID() {
        return this.mNW;
    }

    @Override // com.baidu.m.a.a.c
    public String getVAID() {
        return this.mNX;
    }

    @Override // com.baidu.m.a.a.c
    public int getStatusCode() {
        return this.mStatusCode;
    }

    @Override // com.baidu.m.a.a.c
    public void wU(boolean z) {
        this.mNT = z;
    }

    @Override // com.baidu.m.a.a.c
    public void wV(boolean z) {
        this.mOw = z;
    }

    @Override // com.baidu.m.a.a.c
    public void Ra(String str) {
        this.mNV = str;
    }

    @Override // com.baidu.m.a.a.c
    public void Rb(String str) {
        this.mNW = str;
    }

    @Override // com.baidu.m.a.a.c
    public void Rc(String str) {
        this.mNX = str;
    }

    @Override // com.baidu.m.a.a.c
    public void Ii(int i) {
        this.mStatusCode = i;
    }
}
