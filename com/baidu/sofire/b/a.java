package com.baidu.sofire.b;

import com.baidu.sofire.g.d;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f11121a;

    /* renamed from: b  reason: collision with root package name */
    public String f11122b;

    /* renamed from: c  reason: collision with root package name */
    public String f11123c;

    /* renamed from: d  reason: collision with root package name */
    public String f11124d;

    /* renamed from: e  reason: collision with root package name */
    public String f11125e;

    public static String a(a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("0", aVar.f11121a);
            jSONObject.put("1", aVar.f11123c);
            jSONObject.put("2", aVar.f11124d);
            jSONObject.put("3", aVar.f11125e);
            jSONObject.put("4", aVar.f11122b);
        } catch (Throwable unused) {
            d.a();
        }
        return jSONObject.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            String str = this.f11124d;
            if (str == null) {
                if (aVar.f11124d != null) {
                    return false;
                }
            } else if (!str.equals(aVar.f11124d)) {
                return false;
            }
            String str2 = this.f11125e;
            if (str2 == null) {
                if (aVar.f11125e != null) {
                    return false;
                }
            } else if (!str2.equals(aVar.f11125e)) {
                return false;
            }
            String str3 = this.f11122b;
            if (str3 == null) {
                if (aVar.f11122b != null) {
                    return false;
                }
            } else if (!str3.equals(aVar.f11122b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f11124d;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.f11125e;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f11122b;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public static a a(String str) {
        a aVar = new a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.f11121a = jSONObject.optString("0");
            aVar.f11123c = jSONObject.optString("1");
            aVar.f11124d = jSONObject.optString("2");
            aVar.f11125e = jSONObject.optString("3");
            aVar.f11122b = jSONObject.optString("4");
            return aVar;
        } catch (Exception unused) {
            d.a();
            return null;
        }
    }
}
