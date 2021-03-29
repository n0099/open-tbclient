package com.baidu.sofire.b;

import com.baidu.sofire.g.d;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f11633a;

    /* renamed from: b  reason: collision with root package name */
    public String f11634b;

    /* renamed from: c  reason: collision with root package name */
    public String f11635c;

    /* renamed from: d  reason: collision with root package name */
    public String f11636d;

    /* renamed from: e  reason: collision with root package name */
    public String f11637e;

    public static String a(a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("0", aVar.f11633a);
            jSONObject.put("1", aVar.f11635c);
            jSONObject.put("2", aVar.f11636d);
            jSONObject.put("3", aVar.f11637e);
            jSONObject.put("4", aVar.f11634b);
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
            String str = this.f11636d;
            if (str == null) {
                if (aVar.f11636d != null) {
                    return false;
                }
            } else if (!str.equals(aVar.f11636d)) {
                return false;
            }
            String str2 = this.f11637e;
            if (str2 == null) {
                if (aVar.f11637e != null) {
                    return false;
                }
            } else if (!str2.equals(aVar.f11637e)) {
                return false;
            }
            String str3 = this.f11634b;
            if (str3 == null) {
                if (aVar.f11634b != null) {
                    return false;
                }
            } else if (!str3.equals(aVar.f11634b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f11636d;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.f11637e;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f11634b;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public static a a(String str) {
        a aVar = new a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.f11633a = jSONObject.optString("0");
            aVar.f11635c = jSONObject.optString("1");
            aVar.f11636d = jSONObject.optString("2");
            aVar.f11637e = jSONObject.optString("3");
            aVar.f11634b = jSONObject.optString("4");
            return aVar;
        } catch (Exception unused) {
            d.a();
            return null;
        }
    }
}
