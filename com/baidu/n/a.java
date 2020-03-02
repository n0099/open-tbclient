package com.baidu.n;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class a {
    protected boolean lCd;
    protected boolean lCe;
    protected String lCf;
    protected String lCg;
    protected String lCh;
    protected int mStatusCode;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i) {
        this.lCd = z;
        this.lCe = z2;
        this.lCf = str;
        this.lCg = str2;
        this.lCh = str3;
        this.mStatusCode = i;
    }

    public boolean dhQ() {
        return this.lCd;
    }

    public boolean isSupport() {
        return this.lCe;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public String dhR() {
        return TextUtils.isEmpty(this.lCf) ? this.lCf : new com.baidu.n.a.c.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(this.lCf.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.lCd + ", isSupport=" + this.lCe + ", OAID='" + this.lCf + "', EncodedOAID='" + dhR() + "', AAID='" + this.lCg + "', VAID='" + this.lCh + "', StatusCode='" + this.mStatusCode + "'}";
    }
}
