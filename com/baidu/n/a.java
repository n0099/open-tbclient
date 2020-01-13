package com.baidu.n;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class a {
    protected boolean lBp;
    protected boolean lBq;
    protected String lBr;
    protected String lBs;
    protected String lBt;
    protected int mStatusCode;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i) {
        this.lBp = z;
        this.lBq = z2;
        this.lBr = str;
        this.lBs = str2;
        this.lBt = str3;
        this.mStatusCode = i;
    }

    public boolean dgy() {
        return this.lBp;
    }

    public boolean isSupport() {
        return this.lBq;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public String dgz() {
        return TextUtils.isEmpty(this.lBr) ? this.lBr : new com.baidu.n.a.c.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(this.lBr.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.lBp + ", isSupport=" + this.lBq + ", OAID='" + this.lBr + "', EncodedOAID='" + dgz() + "', AAID='" + this.lBs + "', VAID='" + this.lBt + "', StatusCode='" + this.mStatusCode + "'}";
    }
}
