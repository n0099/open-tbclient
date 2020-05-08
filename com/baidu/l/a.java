package com.baidu.l;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class a {
    protected boolean lPp;
    protected boolean lPq;
    protected String lPr;
    protected String lPs;
    protected String lPt;
    protected int mStatusCode;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i) {
        this.lPp = z;
        this.lPq = z2;
        this.lPr = str;
        this.lPs = str2;
        this.lPt = str3;
        this.mStatusCode = i;
    }

    public boolean dlz() {
        return this.lPp;
    }

    public boolean isSupport() {
        return this.lPq;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public String dlA() {
        return TextUtils.isEmpty(this.lPr) ? this.lPr : new com.baidu.l.a.c.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(this.lPr.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.lPp + ", isSupport=" + this.lPq + ", OAID='" + this.lPr + "', EncodedOAID='" + dlA() + "', AAID='" + this.lPs + "', VAID='" + this.lPt + "', StatusCode='" + this.mStatusCode + "'}";
    }
}
