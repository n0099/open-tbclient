package com.baidu.sofire.b;

import com.baidu.sofire.g.d;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f10089a;

    /* renamed from: b  reason: collision with root package name */
    public String f10090b;

    /* renamed from: c  reason: collision with root package name */
    public String f10091c;

    /* renamed from: d  reason: collision with root package name */
    public String f10092d;

    /* renamed from: e  reason: collision with root package name */
    public String f10093e;

    public static String a(a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("0", aVar.f10089a);
            jSONObject.put("1", aVar.f10091c);
            jSONObject.put("2", aVar.f10092d);
            jSONObject.put("3", aVar.f10093e);
            jSONObject.put("4", aVar.f10090b);
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
            String str = this.f10092d;
            if (str == null) {
                if (aVar.f10092d != null) {
                    return false;
                }
            } else if (!str.equals(aVar.f10092d)) {
                return false;
            }
            String str2 = this.f10093e;
            if (str2 == null) {
                if (aVar.f10093e != null) {
                    return false;
                }
            } else if (!str2.equals(aVar.f10093e)) {
                return false;
            }
            String str3 = this.f10090b;
            if (str3 == null) {
                if (aVar.f10090b != null) {
                    return false;
                }
            } else if (!str3.equals(aVar.f10090b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f10092d;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.f10093e;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f10090b;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public static a a(String str) {
        a aVar = new a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.f10089a = jSONObject.optString("0");
            aVar.f10091c = jSONObject.optString("1");
            aVar.f10092d = jSONObject.optString("2");
            aVar.f10093e = jSONObject.optString("3");
            aVar.f10090b = jSONObject.optString("4");
            return aVar;
        } catch (Exception unused) {
            d.a();
            return null;
        }
    }
}
