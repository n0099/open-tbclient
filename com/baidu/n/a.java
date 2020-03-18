package com.baidu.n;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class a {
    protected boolean lDS;
    protected boolean lDT;
    protected String lDU;
    protected String lDV;
    protected String lDW;
    protected int mStatusCode;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i) {
        this.lDS = z;
        this.lDT = z2;
        this.lDU = str;
        this.lDV = str2;
        this.lDW = str3;
        this.mStatusCode = i;
    }

    public boolean dio() {
        return this.lDS;
    }

    public boolean isSupport() {
        return this.lDT;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public String dip() {
        return TextUtils.isEmpty(this.lDU) ? this.lDU : new com.baidu.n.a.c.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(this.lDU.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.lDS + ", isSupport=" + this.lDT + ", OAID='" + this.lDU + "', EncodedOAID='" + dip() + "', AAID='" + this.lDV + "', VAID='" + this.lDW + "', StatusCode='" + this.mStatusCode + "'}";
    }
}
