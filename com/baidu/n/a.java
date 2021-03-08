package com.baidu.n;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class a {
    protected boolean mIsSupport;
    protected int mStatusCode;
    protected boolean oXn;
    protected String oXo;
    protected String oXp;
    protected String oXq;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i) {
        this.oXn = z;
        this.mIsSupport = z2;
        this.oXo = str;
        this.oXp = str2;
        this.oXq = str3;
        this.mStatusCode = i;
    }

    public String eiM() {
        return TextUtils.isEmpty(this.oXo) ? this.oXo : new com.baidu.n.a.c.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(this.oXo.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.oXn + ", isSupport=" + this.mIsSupport + ", OAID='" + this.oXo + "', EncodedOAID='" + eiM() + "', AAID='" + this.oXp + "', VAID='" + this.oXq + "', StatusCode='" + this.mStatusCode + "'}";
    }
}
