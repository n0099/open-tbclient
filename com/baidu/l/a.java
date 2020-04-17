package com.baidu.l;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class a {
    protected boolean lPl;
    protected boolean lPm;
    protected String lPn;
    protected String lPo;
    protected String lPp;
    protected int mStatusCode;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i) {
        this.lPl = z;
        this.lPm = z2;
        this.lPn = str;
        this.lPo = str2;
        this.lPp = str3;
        this.mStatusCode = i;
    }

    public boolean dlC() {
        return this.lPl;
    }

    public boolean isSupport() {
        return this.lPm;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public String dlD() {
        return TextUtils.isEmpty(this.lPn) ? this.lPn : new com.baidu.l.a.c.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(this.lPn.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.lPl + ", isSupport=" + this.lPm + ", OAID='" + this.lPn + "', EncodedOAID='" + dlD() + "', AAID='" + this.lPo + "', VAID='" + this.lPp + "', StatusCode='" + this.mStatusCode + "'}";
    }
}
