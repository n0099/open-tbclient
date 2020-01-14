package com.baidu.n;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class a {
    protected boolean lBu;
    protected boolean lBv;
    protected String lBw;
    protected String lBx;
    protected String lBy;
    protected int mStatusCode;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i) {
        this.lBu = z;
        this.lBv = z2;
        this.lBw = str;
        this.lBx = str2;
        this.lBy = str3;
        this.mStatusCode = i;
    }

    public boolean dgA() {
        return this.lBu;
    }

    public boolean isSupport() {
        return this.lBv;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public String dgB() {
        return TextUtils.isEmpty(this.lBw) ? this.lBw : new com.baidu.n.a.c.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(this.lBw.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.lBu + ", isSupport=" + this.lBv + ", OAID='" + this.lBw + "', EncodedOAID='" + dgB() + "', AAID='" + this.lBx + "', VAID='" + this.lBy + "', StatusCode='" + this.mStatusCode + "'}";
    }
}
