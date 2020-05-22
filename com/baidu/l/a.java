package com.baidu.l;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public class a {
    protected int mStatusCode;
    protected boolean miG;
    protected boolean miH;
    protected String miI;
    protected String miJ;
    protected String miK;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i) {
        this.miG = z;
        this.miH = z2;
        this.miI = str;
        this.miJ = str2;
        this.miK = str3;
        this.mStatusCode = i;
    }

    public boolean dsP() {
        return this.miG;
    }

    public boolean isSupport() {
        return this.miH;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public String dsQ() {
        return TextUtils.isEmpty(this.miI) ? this.miI : new com.baidu.l.a.c.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(this.miI.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.miG + ", isSupport=" + this.miH + ", OAID='" + this.miI + "', EncodedOAID='" + dsQ() + "', AAID='" + this.miJ + "', VAID='" + this.miK + "', StatusCode='" + this.mStatusCode + "'}";
    }
}
