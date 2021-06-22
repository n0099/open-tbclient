package com.baidu.sofire.c;

import com.baidu.sofire.utility.c;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f10213a;

    /* renamed from: b  reason: collision with root package name */
    public String f10214b;

    /* renamed from: c  reason: collision with root package name */
    public String f10215c;

    /* renamed from: d  reason: collision with root package name */
    public String f10216d;

    /* renamed from: e  reason: collision with root package name */
    public String f10217e;

    public static String a(a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("0", aVar.f10213a);
            jSONObject.put("1", aVar.f10215c);
            jSONObject.put("2", aVar.f10216d);
            jSONObject.put("3", aVar.f10217e);
            jSONObject.put("4", aVar.f10214b);
        } catch (Throwable unused) {
            c.a();
        }
        return jSONObject.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            String str = this.f10216d;
            if (str == null) {
                if (aVar.f10216d != null) {
                    return false;
                }
            } else if (!str.equals(aVar.f10216d)) {
                return false;
            }
            String str2 = this.f10217e;
            if (str2 == null) {
                if (aVar.f10217e != null) {
                    return false;
                }
            } else if (!str2.equals(aVar.f10217e)) {
                return false;
            }
            String str3 = this.f10214b;
            if (str3 == null) {
                if (aVar.f10214b != null) {
                    return false;
                }
            } else if (!str3.equals(aVar.f10214b)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f10216d;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.f10217e;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f10214b;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public static a a(String str) {
        a aVar = new a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.f10213a = jSONObject.optString("0");
            aVar.f10215c = jSONObject.optString("1");
            aVar.f10216d = jSONObject.optString("2");
            aVar.f10217e = jSONObject.optString("3");
            aVar.f10214b = jSONObject.optString("4");
            return aVar;
        } catch (Exception unused) {
            c.a();
            return null;
        }
    }
}
