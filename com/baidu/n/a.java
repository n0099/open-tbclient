package com.baidu.n;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class a {
    protected boolean mIsSupport;
    protected int mStatusCode;
    protected boolean oVi;
    protected String oVj;
    protected String oVk;
    protected String oVl;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i) {
        this.oVi = z;
        this.mIsSupport = z2;
        this.oVj = str;
        this.oVk = str2;
        this.oVl = str3;
        this.mStatusCode = i;
    }

    public String eiC() {
        return TextUtils.isEmpty(this.oVj) ? this.oVj : new com.baidu.n.a.c.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(this.oVj.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.oVi + ", isSupport=" + this.mIsSupport + ", OAID='" + this.oVj + "', EncodedOAID='" + eiC() + "', AAID='" + this.oVk + "', VAID='" + this.oVl + "', StatusCode='" + this.mStatusCode + "'}";
    }
}
