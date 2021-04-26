package com.alipay.android.phone.mrpc.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
/* loaded from: classes.dex */
public final class o extends t {

    /* renamed from: b  reason: collision with root package name */
    public String f1644b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f1645c;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1649g;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<Header> f1647e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f1648f = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public String f1646d = "application/x-www-form-urlencoded";

    public o(String str) {
        this.f1644b = str;
    }

    public final String a() {
        return this.f1644b;
    }

    public final void a(String str) {
        this.f1646d = str;
    }

    public final void a(String str, String str2) {
        if (this.f1648f == null) {
            this.f1648f = new HashMap();
        }
        this.f1648f.put(str, str2);
    }

    public final void a(Header header) {
        this.f1647e.add(header);
    }

    public final void a(boolean z) {
        this.f1649g = z;
    }

    public final void a(byte[] bArr) {
        this.f1645c = bArr;
    }

    public final String b(String str) {
        Map<String, String> map = this.f1648f;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public final byte[] b() {
        return this.f1645c;
    }

    public final String c() {
        return this.f1646d;
    }

    public final ArrayList<Header> d() {
        return this.f1647e;
    }

    public final boolean e() {
        return this.f1649g;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && o.class == obj.getClass()) {
            o oVar = (o) obj;
            byte[] bArr = this.f1645c;
            if (bArr == null) {
                if (oVar.f1645c != null) {
                    return false;
                }
            } else if (!bArr.equals(oVar.f1645c)) {
                return false;
            }
            String str = this.f1644b;
            String str2 = oVar.f1644b;
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
        Map<String, String> map = this.f1648f;
        int hashCode = ((map == null || !map.containsKey("id")) ? 1 : this.f1648f.get("id").hashCode() + 31) * 31;
        String str = this.f1644b;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return String.format("Url : %s,HttpHeader: %s", this.f1644b, this.f1647e);
    }
}
