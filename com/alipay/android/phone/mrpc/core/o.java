package com.alipay.android.phone.mrpc.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
/* loaded from: classes.dex */
public final class o extends t {

    /* renamed from: b  reason: collision with root package name */
    public String f1678b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f1679c;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1683g;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<Header> f1681e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f1682f = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public String f1680d = "application/x-www-form-urlencoded";

    public o(String str) {
        this.f1678b = str;
    }

    public final String a() {
        return this.f1678b;
    }

    public final void a(String str) {
        this.f1680d = str;
    }

    public final void a(String str, String str2) {
        if (this.f1682f == null) {
            this.f1682f = new HashMap();
        }
        this.f1682f.put(str, str2);
    }

    public final void a(Header header) {
        this.f1681e.add(header);
    }

    public final void a(boolean z) {
        this.f1683g = z;
    }

    public final void a(byte[] bArr) {
        this.f1679c = bArr;
    }

    public final String b(String str) {
        Map<String, String> map = this.f1682f;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public final byte[] b() {
        return this.f1679c;
    }

    public final String c() {
        return this.f1680d;
    }

    public final ArrayList<Header> d() {
        return this.f1681e;
    }

    public final boolean e() {
        return this.f1683g;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && o.class == obj.getClass()) {
            o oVar = (o) obj;
            byte[] bArr = this.f1679c;
            if (bArr == null) {
                if (oVar.f1679c != null) {
                    return false;
                }
            } else if (!bArr.equals(oVar.f1679c)) {
                return false;
            }
            String str = this.f1678b;
            String str2 = oVar.f1678b;
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
        Map<String, String> map = this.f1682f;
        int hashCode = ((map == null || !map.containsKey("id")) ? 1 : this.f1682f.get("id").hashCode() + 31) * 31;
        String str = this.f1678b;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return String.format("Url : %s,HttpHeader: %s", this.f1678b, this.f1681e);
    }
}
