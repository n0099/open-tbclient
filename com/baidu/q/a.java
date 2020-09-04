package com.baidu.q;

import android.text.TextUtils;
/* loaded from: classes12.dex */
public class a {
    protected int mStatusCode;
    protected boolean nhf;
    protected boolean nhg;
    protected String nhh;
    protected String nhi;
    protected String nhj;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i) {
        this.nhf = z;
        this.nhg = z2;
        this.nhh = str;
        this.nhi = str2;
        this.nhj = str3;
        this.mStatusCode = i;
    }

    public boolean dMU() {
        return this.nhf;
    }

    public boolean isSupport() {
        return this.nhg;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public String dMV() {
        return TextUtils.isEmpty(this.nhh) ? this.nhh : new com.baidu.q.a.c.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(this.nhh.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.nhf + ", isSupport=" + this.nhg + ", OAID='" + this.nhh + "', EncodedOAID='" + dMV() + "', AAID='" + this.nhi + "', VAID='" + this.nhj + "', StatusCode='" + this.mStatusCode + "'}";
    }
}
