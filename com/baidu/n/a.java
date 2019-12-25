package com.baidu.n;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public class a {
    protected boolean lxQ;
    protected boolean lxR;
    protected String lxS;
    protected String lxT;
    protected String lxU;
    protected int mStatusCode;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i) {
        this.lxQ = z;
        this.lxR = z2;
        this.lxS = str;
        this.lxT = str2;
        this.lxU = str3;
        this.mStatusCode = i;
    }

    public boolean dfw() {
        return this.lxQ;
    }

    public boolean isSupport() {
        return this.lxR;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public String dfx() {
        return TextUtils.isEmpty(this.lxS) ? this.lxS : new com.baidu.n.a.c.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(this.lxS.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.lxQ + ", isSupport=" + this.lxR + ", OAID='" + this.lxS + "', EncodedOAID='" + dfx() + "', AAID='" + this.lxT + "', VAID='" + this.lxU + "', StatusCode='" + this.mStatusCode + "'}";
    }
}
