package com.baidu.n;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class a {
    protected boolean lCb;
    protected boolean lCc;
    protected String lCd;
    protected String lCe;
    protected String lCf;
    protected int mStatusCode;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i) {
        this.lCb = z;
        this.lCc = z2;
        this.lCd = str;
        this.lCe = str2;
        this.lCf = str3;
        this.mStatusCode = i;
    }

    public boolean dhO() {
        return this.lCb;
    }

    public boolean isSupport() {
        return this.lCc;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public String dhP() {
        return TextUtils.isEmpty(this.lCd) ? this.lCd : new com.baidu.n.a.c.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(this.lCd.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.lCb + ", isSupport=" + this.lCc + ", OAID='" + this.lCd + "', EncodedOAID='" + dhP() + "', AAID='" + this.lCe + "', VAID='" + this.lCf + "', StatusCode='" + this.mStatusCode + "'}";
    }
}
