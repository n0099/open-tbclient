package com.baidu.l;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class a {
    protected boolean mFP;
    protected boolean mFQ;
    protected String mFR;
    protected String mFS;
    protected String mFT;
    protected int mStatusCode;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i) {
        this.mFP = z;
        this.mFQ = z2;
        this.mFR = str;
        this.mFS = str2;
        this.mFT = str3;
        this.mStatusCode = i;
    }

    public boolean dxK() {
        return this.mFP;
    }

    public boolean isSupport() {
        return this.mFQ;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public String dxL() {
        return TextUtils.isEmpty(this.mFR) ? this.mFR : new com.baidu.l.a.c.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(this.mFR.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.mFP + ", isSupport=" + this.mFQ + ", OAID='" + this.mFR + "', EncodedOAID='" + dxL() + "', AAID='" + this.mFS + "', VAID='" + this.mFT + "', StatusCode='" + this.mStatusCode + "'}";
    }
}
