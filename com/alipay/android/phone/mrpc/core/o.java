package com.alipay.android.phone.mrpc.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
/* loaded from: classes.dex */
public final class o extends t {

    /* renamed from: b  reason: collision with root package name */
    public String f1703b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f1704c;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1708g;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<Header> f1706e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f1707f = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public String f1705d = "application/x-www-form-urlencoded";

    public o(String str) {
        this.f1703b = str;
    }

    public final String a() {
        return this.f1703b;
    }

    public final void a(String str) {
        this.f1705d = str;
    }

    public final void a(String str, String str2) {
        if (this.f1707f == null) {
            this.f1707f = new HashMap();
        }
        this.f1707f.put(str, str2);
    }

    public final void a(Header header) {
        this.f1706e.add(header);
    }

    public final void a(boolean z) {
        this.f1708g = z;
    }

    public final void a(byte[] bArr) {
        this.f1704c = bArr;
    }

    public final String b(String str) {
        Map<String, String> map = this.f1707f;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public final byte[] b() {
        return this.f1704c;
    }

    public final String c() {
        return this.f1705d;
    }

    public final ArrayList<Header> d() {
        return this.f1706e;
    }

    public final boolean e() {
        return this.f1708g;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && o.class == obj.getClass()) {
            o oVar = (o) obj;
            byte[] bArr = this.f1704c;
            if (bArr == null) {
                if (oVar.f1704c != null) {
                    return false;
                }
            } else if (!bArr.equals(oVar.f1704c)) {
                return false;
            }
            String str = this.f1703b;
            String str2 = oVar.f1703b;
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
        Map<String, String> map = this.f1707f;
        int hashCode = ((map == null || !map.containsKey("id")) ? 1 : this.f1707f.get("id").hashCode() + 31) * 31;
        String str = this.f1703b;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return String.format("Url : %s,HttpHeader: %s", this.f1703b, this.f1706e);
    }
}
