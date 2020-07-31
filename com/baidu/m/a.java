package com.baidu.m;

import android.text.TextUtils;
/* loaded from: classes8.dex */
public class a {
    protected boolean mNT;
    protected boolean mNU;
    protected String mNV;
    protected String mNW;
    protected String mNX;
    protected int mStatusCode;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i) {
        this.mNT = z;
        this.mNU = z2;
        this.mNV = str;
        this.mNW = str2;
        this.mNX = str3;
        this.mStatusCode = i;
    }

    public boolean dAW() {
        return this.mNT;
    }

    public boolean isSupport() {
        return this.mNU;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public String dAX() {
        return TextUtils.isEmpty(this.mNV) ? this.mNV : new com.baidu.m.a.c.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(this.mNV.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.mNT + ", isSupport=" + this.mNU + ", OAID='" + this.mNV + "', EncodedOAID='" + dAX() + "', AAID='" + this.mNW + "', VAID='" + this.mNX + "', StatusCode='" + this.mStatusCode + "'}";
    }
}
