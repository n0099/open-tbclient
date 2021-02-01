package com.baidu.n;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class a {
    protected boolean mIsSupport;
    protected int mStatusCode;
    protected boolean oUI;
    protected String oUJ;
    protected String oUK;
    protected String oUL;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i) {
        this.oUI = z;
        this.mIsSupport = z2;
        this.oUJ = str;
        this.oUK = str2;
        this.oUL = str3;
        this.mStatusCode = i;
    }

    public String eiu() {
        return TextUtils.isEmpty(this.oUJ) ? this.oUJ : new com.baidu.n.a.c.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(this.oUJ.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.oUI + ", isSupport=" + this.mIsSupport + ", OAID='" + this.oUJ + "', EncodedOAID='" + eiu() + "', AAID='" + this.oUK + "', VAID='" + this.oUL + "', StatusCode='" + this.mStatusCode + "'}";
    }
}
