package com.baidu.n;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class a {
    protected boolean lCo;
    protected boolean lCp;
    protected String lCq;
    protected String lCr;
    protected String lCs;
    protected int mStatusCode;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i) {
        this.lCo = z;
        this.lCp = z2;
        this.lCq = str;
        this.lCr = str2;
        this.lCs = str3;
        this.mStatusCode = i;
    }

    public boolean dhR() {
        return this.lCo;
    }

    public boolean isSupport() {
        return this.lCp;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public String dhS() {
        return TextUtils.isEmpty(this.lCq) ? this.lCq : new com.baidu.n.a.c.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(this.lCq.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.lCo + ", isSupport=" + this.lCp + ", OAID='" + this.lCq + "', EncodedOAID='" + dhS() + "', AAID='" + this.lCr + "', VAID='" + this.lCs + "', StatusCode='" + this.mStatusCode + "'}";
    }
}
