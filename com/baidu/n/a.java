package com.baidu.n;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class a {
    protected int mStatusCode;
    protected boolean oKA;
    protected boolean oKB;
    protected String oKC;
    protected String oKD;
    protected String oKE;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i) {
        this.oKA = z;
        this.oKB = z2;
        this.oKC = str;
        this.oKD = str2;
        this.oKE = str3;
        this.mStatusCode = i;
    }

    public String egc() {
        return TextUtils.isEmpty(this.oKC) ? this.oKC : new com.baidu.n.a.c.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(this.oKC.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.oKA + ", isSupport=" + this.oKB + ", OAID='" + this.oKC + "', EncodedOAID='" + egc() + "', AAID='" + this.oKD + "', VAID='" + this.oKE + "', StatusCode='" + this.mStatusCode + "'}";
    }
}
