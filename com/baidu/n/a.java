package com.baidu.n;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class a {
    protected int mStatusCode;
    protected boolean oKA;
    protected String oKB;
    protected String oKC;
    protected String oKD;
    protected boolean oKz;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i) {
        this.oKz = z;
        this.oKA = z2;
        this.oKB = str;
        this.oKC = str2;
        this.oKD = str3;
        this.mStatusCode = i;
    }

    public String egc() {
        return TextUtils.isEmpty(this.oKB) ? this.oKB : new com.baidu.n.a.c.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(this.oKB.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.oKz + ", isSupport=" + this.oKA + ", OAID='" + this.oKB + "', EncodedOAID='" + egc() + "', AAID='" + this.oKC + "', VAID='" + this.oKD + "', StatusCode='" + this.mStatusCode + "'}";
    }
}
