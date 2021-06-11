package com.baidu.sofire.b;

import com.baidu.sofire.g.d;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f10151a;

    /* renamed from: b  reason: collision with root package name */
    public String f10152b;

    /* renamed from: c  reason: collision with root package name */
    public String f10153c;

    /* renamed from: d  reason: collision with root package name */
    public String f10154d;

    /* renamed from: e  reason: collision with root package name */
    public String f10155e;

    public static String a(a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("0", aVar.f10151a);
            jSONObject.put("1", aVar.f10153c);
            jSONObject.put("2", aVar.f10154d);
            jSONObject.put("3", aVar.f10155e);
            jSONObject.put("4", aVar.f10152b);
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
            String str = this.f10154d;
            if (str == null) {
                if (aVar.f10154d != null) {
                    return false;
                }
            } else if (!str.equals(aVar.f10154d)) {
                return false;
            }
            String str2 = this.f10155e;
            if (str2 == null) {
                if (aVar.f10155e != null) {
                    return false;
                }
            } else if (!str2.equals(aVar.f10155e)) {
                return false;
            }
            String str3 = this.f10152b;
            if (str3 == null) {
                if (aVar.f10152b != null) {
                    return false;
                }
            } else if (!str3.equals(aVar.f10152b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f10154d;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.f10155e;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f10152b;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public static a a(String str) {
        a aVar = new a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.f10151a = jSONObject.optString("0");
            aVar.f10153c = jSONObject.optString("1");
            aVar.f10154d = jSONObject.optString("2");
            aVar.f10155e = jSONObject.optString("3");
            aVar.f10152b = jSONObject.optString("4");
            return aVar;
        } catch (Exception unused) {
            d.a();
            return null;
        }
    }
}
