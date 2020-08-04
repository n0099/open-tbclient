package com.baidu.m;

import android.text.TextUtils;
/* loaded from: classes8.dex */
public class a {
    protected boolean mNV;
    protected boolean mNW;
    protected String mNX;
    protected String mNY;
    protected String mNZ;
    protected int mStatusCode;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i) {
        this.mNV = z;
        this.mNW = z2;
        this.mNX = str;
        this.mNY = str2;
        this.mNZ = str3;
        this.mStatusCode = i;
    }

    public boolean dAX() {
        return this.mNV;
    }

    public boolean isSupport() {
        return this.mNW;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public String dAY() {
        return TextUtils.isEmpty(this.mNX) ? this.mNX : new com.baidu.m.a.c.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(this.mNX.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.mNV + ", isSupport=" + this.mNW + ", OAID='" + this.mNX + "', EncodedOAID='" + dAY() + "', AAID='" + this.mNY + "', VAID='" + this.mNZ + "', StatusCode='" + this.mStatusCode + "'}";
    }
}
