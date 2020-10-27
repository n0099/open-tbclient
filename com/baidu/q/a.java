package com.baidu.q;

import android.text.TextUtils;
/* loaded from: classes7.dex */
public class a {
    protected int mStatusCode;
    protected boolean ojc;
    protected boolean ojd;
    protected String oje;
    protected String ojf;
    protected String ojg;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i) {
        this.ojc = z;
        this.ojd = z2;
        this.oje = str;
        this.ojf = str2;
        this.ojg = str3;
        this.mStatusCode = i;
    }

    public boolean eav() {
        return this.ojc;
    }

    public boolean isSupport() {
        return this.ojd;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public String eaw() {
        return TextUtils.isEmpty(this.oje) ? this.oje : new com.baidu.q.a.c.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(this.oje.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.ojc + ", isSupport=" + this.ojd + ", OAID='" + this.oje + "', EncodedOAID='" + eaw() + "', AAID='" + this.ojf + "', VAID='" + this.ojg + "', StatusCode='" + this.mStatusCode + "'}";
    }
}
