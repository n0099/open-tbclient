package com.baidu.q;

import android.text.TextUtils;
/* loaded from: classes15.dex */
public class a {
    protected int mStatusCode;
    protected boolean otL;
    protected boolean otM;
    protected String otN;
    protected String otO;
    protected String otP;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i) {
        this.otL = z;
        this.otM = z2;
        this.otN = str;
        this.otO = str2;
        this.otP = str3;
        this.mStatusCode = i;
    }

    public String eec() {
        return TextUtils.isEmpty(this.otN) ? this.otN : new com.baidu.q.a.c.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(this.otN.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.otL + ", isSupport=" + this.otM + ", OAID='" + this.otN + "', EncodedOAID='" + eec() + "', AAID='" + this.otO + "', VAID='" + this.otP + "', StatusCode='" + this.mStatusCode + "'}";
    }
}
