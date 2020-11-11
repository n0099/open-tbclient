package com.baidu.q;

import android.text.TextUtils;
/* loaded from: classes7.dex */
public class a {
    protected int mStatusCode;
    protected boolean osi;
    protected boolean osj;
    protected String osk;
    protected String osl;
    protected String osm;

    public a(boolean z, boolean z2, String str, String str2, String str3, int i) {
        this.osi = z;
        this.osj = z2;
        this.osk = str;
        this.osl = str2;
        this.osm = str3;
        this.mStatusCode = i;
    }

    public boolean eed() {
        return this.osi;
    }

    public boolean isSupport() {
        return this.osj;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public String eee() {
        return TextUtils.isEmpty(this.osk) ? this.osk : new com.baidu.q.a.c.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(this.osk.getBytes());
    }

    public String toString() {
        return "UnionIDInfo{isTrackLimited=" + this.osi + ", isSupport=" + this.osj + ", OAID='" + this.osk + "', EncodedOAID='" + eee() + "', AAID='" + this.osl + "', VAID='" + this.osm + "', StatusCode='" + this.mStatusCode + "'}";
    }
}
