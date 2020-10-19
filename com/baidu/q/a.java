package com.baidu.q;

import android.text.TextUtils;
/* loaded from: classes7.dex */
public class a {
    protected int mStatusCode;
    protected boolean nGA;
    protected boolean nGB;
    protected String nGC;
    protected String nGD;
    protected String nGE;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i) {
        this.nGA = z;
        this.nGB = z2;
        this.nGC = str;
        this.nGD = str2;
        this.nGE = str3;
        this.mStatusCode = i;
    }

    public boolean dUD() {
        return this.nGA;
    }

    public boolean isSupport() {
        return this.nGB;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public String dUE() {
        return TextUtils.isEmpty(this.nGC) ? this.nGC : new com.baidu.q.a.c.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(this.nGC.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.nGA + ", isSupport=" + this.nGB + ", OAID='" + this.nGC + "', EncodedOAID='" + dUE() + "', AAID='" + this.nGD + "', VAID='" + this.nGE + "', StatusCode='" + this.mStatusCode + "'}";
    }
}
