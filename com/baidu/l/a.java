package com.baidu.l;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class a {
    protected boolean mFM;
    protected boolean mFN;
    protected String mFO;
    protected String mFP;
    protected String mFQ;
    protected int mStatusCode;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i) {
        this.mFM = z;
        this.mFN = z2;
        this.mFO = str;
        this.mFP = str2;
        this.mFQ = str3;
        this.mStatusCode = i;
    }

    public boolean dxG() {
        return this.mFM;
    }

    public boolean isSupport() {
        return this.mFN;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public String dxH() {
        return TextUtils.isEmpty(this.mFO) ? this.mFO : new com.baidu.l.a.c.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(this.mFO.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.mFM + ", isSupport=" + this.mFN + ", OAID='" + this.mFO + "', EncodedOAID='" + dxH() + "', AAID='" + this.mFP + "', VAID='" + this.mFQ + "', StatusCode='" + this.mStatusCode + "'}";
    }
}
