package com.baidu.r;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class a {
    protected int mStatusCode;
    protected boolean oIS;
    protected boolean oIT;
    protected String oIU;
    protected String oIV;
    protected String oIW;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i) {
        this.oIS = z;
        this.oIT = z2;
        this.oIU = str;
        this.oIV = str2;
        this.oIW = str3;
        this.mStatusCode = i;
    }

    public String ejP() {
        return TextUtils.isEmpty(this.oIU) ? this.oIU : new com.baidu.r.a.c.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(this.oIU.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.oIS + ", isSupport=" + this.oIT + ", OAID='" + this.oIU + "', EncodedOAID='" + ejP() + "', AAID='" + this.oIV + "', VAID='" + this.oIW + "', StatusCode='" + this.mStatusCode + "'}";
    }
}
