package com.alipay.android.phone.mrpc.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
/* loaded from: classes.dex */
public final class o extends t {

    /* renamed from: b  reason: collision with root package name */
    public String f1657b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f1658c;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1662g;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<Header> f1660e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f1661f = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public String f1659d = "application/x-www-form-urlencoded";

    public o(String str) {
        this.f1657b = str;
    }

    public final String a() {
        return this.f1657b;
    }

    public final void a(String str) {
        this.f1659d = str;
    }

    public final void a(String str, String str2) {
        if (this.f1661f == null) {
            this.f1661f = new HashMap();
        }
        this.f1661f.put(str, str2);
    }

    public final void a(Header header) {
        this.f1660e.add(header);
    }

    public final void a(boolean z) {
        this.f1662g = z;
    }

    public final void a(byte[] bArr) {
        this.f1658c = bArr;
    }

    public final String b(String str) {
        Map<String, String> map = this.f1661f;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public final byte[] b() {
        return this.f1658c;
    }

    public final String c() {
        return this.f1659d;
    }

    public final ArrayList<Header> d() {
        return this.f1660e;
    }

    public final boolean e() {
        return this.f1662g;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && o.class == obj.getClass()) {
            o oVar = (o) obj;
            byte[] bArr = this.f1658c;
            if (bArr == null) {
                if (oVar.f1658c != null) {
                    return false;
                }
            } else if (!bArr.equals(oVar.f1658c)) {
                return false;
            }
            String str = this.f1657b;
            String str2 = oVar.f1657b;
            if (str == null) {
                if (str2 != null) {
                    return false;
                }
            } else if (!str.equals(str2)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        Map<String, String> map = this.f1661f;
        int hashCode = ((map == null || !map.containsKey("id")) ? 1 : this.f1661f.get("id").hashCode() + 31) * 31;
        String str = this.f1657b;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return String.format("Url : %s,HttpHeader: %s", this.f1657b, this.f1660e);
    }
}
