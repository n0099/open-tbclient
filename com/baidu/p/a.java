package com.baidu.p;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class a {
    protected int mStatusCode;
    protected boolean oPb;
    protected boolean oPc;
    protected String oPd;
    protected String oPe;
    protected String oPf;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i) {
        this.oPb = z;
        this.oPc = z2;
        this.oPd = str;
        this.oPe = str2;
        this.oPf = str3;
        this.mStatusCode = i;
    }

    public String ejV() {
        return TextUtils.isEmpty(this.oPd) ? this.oPd : new com.baidu.p.a.c.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(this.oPd.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.oPb + ", isSupport=" + this.oPc + ", OAID='" + this.oPd + "', EncodedOAID='" + ejV() + "', AAID='" + this.oPe + "', VAID='" + this.oPf + "', StatusCode='" + this.mStatusCode + "'}";
    }
}
