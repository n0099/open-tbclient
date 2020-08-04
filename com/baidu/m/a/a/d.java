package com.baidu.m.a.a;

import android.content.Context;
/* loaded from: classes12.dex */
public abstract class d implements c {
    protected Context mCtx;
    protected boolean mNV;
    protected String mNX;
    protected String mNY;
    protected String mNZ;
    protected boolean mOy;
    protected int mStatusCode = -200;

    public d(Context context) {
        if (context != null) {
            this.mCtx = context.getApplicationContext();
        }
    }

    @Override // com.baidu.m.a.a.c
    public boolean dAX() {
        return this.mNV;
    }

    @Override // com.baidu.m.a.a.c
    public boolean isSupport() {
        return this.mOy;
    }

    @Override // com.baidu.m.a.a.c
    public String getOAID() {
        return this.mNX;
    }

    @Override // com.baidu.m.a.a.c
    public String getAAID() {
        return this.mNY;
    }

    @Override // com.baidu.m.a.a.c
    public String getVAID() {
        return this.mNZ;
    }

    @Override // com.baidu.m.a.a.c
    public int getStatusCode() {
        return this.mStatusCode;
    }

    @Override // com.baidu.m.a.a.c
    public void wU(boolean z) {
        this.mNV = z;
    }

    @Override // com.baidu.m.a.a.c
    public void wV(boolean z) {
        this.mOy = z;
    }

    @Override // com.baidu.m.a.a.c
    public void Ra(String str) {
        this.mNX = str;
    }

    @Override // com.baidu.m.a.a.c
    public void Rb(String str) {
        this.mNY = str;
    }

    @Override // com.baidu.m.a.a.c
    public void Rc(String str) {
        this.mNZ = str;
    }

    @Override // com.baidu.m.a.a.c
    public void Ii(int i) {
        this.mStatusCode = i;
    }
}
