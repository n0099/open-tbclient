package com.baidu.q;

import android.text.TextUtils;
/* loaded from: classes12.dex */
public class a {
    protected int mStatusCode;
    protected boolean ngN;
    protected boolean ngO;
    protected String ngP;
    protected String ngQ;
    protected String ngR;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i) {
        this.ngN = z;
        this.ngO = z2;
        this.ngP = str;
        this.ngQ = str2;
        this.ngR = str3;
        this.mStatusCode = i;
    }

    public boolean dML() {
        return this.ngN;
    }

    public boolean isSupport() {
        return this.ngO;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public String dMM() {
        return TextUtils.isEmpty(this.ngP) ? this.ngP : new com.baidu.q.a.c.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(this.ngP.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.ngN + ", isSupport=" + this.ngO + ", OAID='" + this.ngP + "', EncodedOAID='" + dMM() + "', AAID='" + this.ngQ + "', VAID='" + this.ngR + "', StatusCode='" + this.mStatusCode + "'}";
    }
}
