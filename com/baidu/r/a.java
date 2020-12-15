package com.baidu.r;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public class a {
    protected int mStatusCode;
    protected boolean oIU;
    protected boolean oIV;
    protected String oIW;
    protected String oIX;
    protected String oIY;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i) {
        this.oIU = z;
        this.oIV = z2;
        this.oIW = str;
        this.oIX = str2;
        this.oIY = str3;
        this.mStatusCode = i;
    }

    public String ejQ() {
        return TextUtils.isEmpty(this.oIW) ? this.oIW : new com.baidu.r.a.c.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(this.oIW.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.oIU + ", isSupport=" + this.oIV + ", OAID='" + this.oIW + "', EncodedOAID='" + ejQ() + "', AAID='" + this.oIX + "', VAID='" + this.oIY + "', StatusCode='" + this.mStatusCode + "'}";
    }
}
