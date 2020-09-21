package com.baidu.q;

import android.text.TextUtils;
/* loaded from: classes12.dex */
public class a {
    protected int mStatusCode;
    protected boolean nrg;
    protected boolean nrh;
    protected String nri;
    protected String nrj;
    protected String nrk;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i) {
        this.nrg = z;
        this.nrh = z2;
        this.nri = str;
        this.nrj = str2;
        this.nrk = str3;
        this.mStatusCode = i;
    }

    public boolean dQS() {
        return this.nrg;
    }

    public boolean isSupport() {
        return this.nrh;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public String dQT() {
        return TextUtils.isEmpty(this.nri) ? this.nri : new com.baidu.q.a.c.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(this.nri.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.nrg + ", isSupport=" + this.nrh + ", OAID='" + this.nri + "', EncodedOAID='" + dQT() + "', AAID='" + this.nrj + "', VAID='" + this.nrk + "', StatusCode='" + this.mStatusCode + "'}";
    }
}
