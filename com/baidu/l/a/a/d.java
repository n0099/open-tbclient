package com.baidu.l.a.a;

import android.content.Context;
/* loaded from: classes6.dex */
public abstract class d implements c {
    protected boolean lPS;
    protected boolean lPp;
    protected String lPr;
    protected String lPs;
    protected String lPt;
    protected Context mCtx;
    protected int mStatusCode = -200;

    public d(Context context) {
        if (context != null) {
            this.mCtx = context.getApplicationContext();
        }
    }

    @Override // com.baidu.l.a.a.c
    public boolean dlA() {
        return this.lPp;
    }

    @Override // com.baidu.l.a.a.c
    public boolean isSupport() {
        return this.lPS;
    }

    @Override // com.baidu.l.a.a.c
    public String dlL() {
        return this.lPr;
    }

    @Override // com.baidu.l.a.a.c
    public String dlM() {
        return this.lPs;
    }

    @Override // com.baidu.l.a.a.c
    public String dlN() {
        return this.lPt;
    }

    @Override // com.baidu.l.a.a.c
    public int getStatusCode() {
        return this.mStatusCode;
    }

    @Override // com.baidu.l.a.a.c
    public void vt(boolean z) {
        this.lPp = z;
    }

    @Override // com.baidu.l.a.a.c
    public void vu(boolean z) {
        this.lPS = z;
    }

    @Override // com.baidu.l.a.a.c
    public void NO(String str) {
        this.lPr = str;
    }

    @Override // com.baidu.l.a.a.c
    public void NP(String str) {
        this.lPs = str;
    }

    @Override // com.baidu.l.a.a.c
    public void NQ(String str) {
        this.lPt = str;
    }

    @Override // com.baidu.l.a.a.c
    public void FR(int i) {
        this.mStatusCode = i;
    }
}
