package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class d {
    public static c a(String str) {
        try {
            if (com.alipay.security.mobile.module.a.a.a(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            return new c(jSONObject.optString("apdid"), jSONObject.optString("deviceInfoHash"), jSONObject.optString("timestamp"), jSONObject.optString("tid"), jSONObject.optString(com.alipay.sdk.cons.b.f1830g));
        } catch (Exception e2) {
            com.alipay.apmobilesecuritysdk.c.a.a(e2);
            return null;
        }
    }

    public static synchronized void a() {
        synchronized (d.class) {
        }
    }

    public static synchronized void a(Context context) {
        synchronized (d.class) {
            com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4", "");
            com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v4", "key_wxcasxx_v4", "");
        }
    }

    public static synchronized void a(Context context, c cVar) {
        synchronized (d.class) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("apdid", cVar.f1690a);
                jSONObject.put("deviceInfoHash", cVar.f1691b);
                jSONObject.put("timestamp", cVar.f1692c);
                jSONObject.put("tid", cVar.f1693d);
                jSONObject.put(com.alipay.sdk.cons.b.f1830g, cVar.f1694e);
                String jSONObject2 = jSONObject.toString();
                com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4", jSONObject2);
                com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v4", "key_wxcasxx_v4", jSONObject2);
            } catch (Exception e2) {
                com.alipay.apmobilesecuritysdk.c.a.a(e2);
            }
        }
    }

    public static synchronized c b() {
        synchronized (d.class) {
            String a2 = com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v4", "key_wxcasxx_v4");
            if (com.alipay.security.mobile.module.a.a.a(a2)) {
                return null;
            }
            return a(a2);
        }
    }

    public static synchronized c b(Context context) {
        c a2;
        synchronized (d.class) {
            String a3 = com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4");
            if (com.alipay.security.mobile.module.a.a.a(a3)) {
                a3 = com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v4", "key_wxcasxx_v4");
            }
            a2 = a(a3);
        }
        return a2;
    }

    public static synchronized c c(Context context) {
        synchronized (d.class) {
            String a2 = com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v4", "key_deviceid_v4");
            if (com.alipay.security.mobile.module.a.a.a(a2)) {
                return null;
            }
            return a(a2);
        }
    }
}
