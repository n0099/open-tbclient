package com.baidu.l;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class a {
    protected int mStatusCode;
    protected boolean mjQ;
    protected boolean mjR;
    protected String mjS;
    protected String mjT;
    protected String mjU;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i) {
        this.mjQ = z;
        this.mjR = z2;
        this.mjS = str;
        this.mjT = str2;
        this.mjU = str3;
        this.mStatusCode = i;
    }

    public boolean dtd() {
        return this.mjQ;
    }

    public boolean isSupport() {
        return this.mjR;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public String dte() {
        return TextUtils.isEmpty(this.mjS) ? this.mjS : new com.baidu.l.a.c.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(this.mjS.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.mjQ + ", isSupport=" + this.mjR + ", OAID='" + this.mjS + "', EncodedOAID='" + dte() + "', AAID='" + this.mjT + "', VAID='" + this.mjU + "', StatusCode='" + this.mStatusCode + "'}";
    }
}
