package com.baidu.sofire.b;

import com.baidu.sofire.g.d;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f11302a;

    /* renamed from: b  reason: collision with root package name */
    public String f11303b;

    /* renamed from: c  reason: collision with root package name */
    public String f11304c;

    /* renamed from: d  reason: collision with root package name */
    public String f11305d;

    /* renamed from: e  reason: collision with root package name */
    public String f11306e;

    public static String a(a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("0", aVar.f11302a);
            jSONObject.put("1", aVar.f11304c);
            jSONObject.put("2", aVar.f11305d);
            jSONObject.put("3", aVar.f11306e);
            jSONObject.put("4", aVar.f11303b);
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
            String str = this.f11305d;
            if (str == null) {
                if (aVar.f11305d != null) {
                    return false;
                }
            } else if (!str.equals(aVar.f11305d)) {
                return false;
            }
            String str2 = this.f11306e;
            if (str2 == null) {
                if (aVar.f11306e != null) {
                    return false;
                }
            } else if (!str2.equals(aVar.f11306e)) {
                return false;
            }
            String str3 = this.f11303b;
            if (str3 == null) {
                if (aVar.f11303b != null) {
                    return false;
                }
            } else if (!str3.equals(aVar.f11303b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f11305d;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.f11306e;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f11303b;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public static a a(String str) {
        a aVar = new a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.f11302a = jSONObject.optString("0");
            aVar.f11304c = jSONObject.optString("1");
            aVar.f11305d = jSONObject.optString("2");
            aVar.f11306e = jSONObject.optString("3");
            aVar.f11303b = jSONObject.optString("4");
            return aVar;
        } catch (Exception unused) {
            d.a();
            return null;
        }
    }
}
