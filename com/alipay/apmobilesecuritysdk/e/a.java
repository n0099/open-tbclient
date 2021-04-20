package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import com.baidu.mobads.container.util.DeviceUtils;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {
    public static b a(String str) {
        try {
            if (com.alipay.security.mobile.module.a.a.a(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            return new b(jSONObject.optString("apdid"), jSONObject.optString("deviceInfoHash"), jSONObject.optString("timestamp"));
        } catch (Exception e2) {
            com.alipay.apmobilesecuritysdk.c.a.a(e2);
            return null;
        }
    }

    public static synchronized void a() {
        synchronized (a.class) {
        }
    }

    public static synchronized void a(Context context) {
        synchronized (a.class) {
            com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v3", DeviceUtils.KEY_OLD_NAME_STRING, "");
            com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v3", "wxcasxx", "");
        }
    }

    public static synchronized void a(Context context, b bVar) {
        synchronized (a.class) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("apdid", bVar.f1745a);
                jSONObject.put("deviceInfoHash", bVar.f1746b);
                jSONObject.put("timestamp", bVar.f1747c);
                String jSONObject2 = jSONObject.toString();
                com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v3", DeviceUtils.KEY_OLD_NAME_STRING, jSONObject2);
                com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v3", "wxcasxx", jSONObject2);
            } catch (Exception e2) {
                com.alipay.apmobilesecuritysdk.c.a.a(e2);
            }
        }
    }

    public static synchronized b b() {
        synchronized (a.class) {
            String a2 = com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v3", "wxcasxx");
            if (com.alipay.security.mobile.module.a.a.a(a2)) {
                return null;
            }
            return a(a2);
        }
    }

    public static synchronized b b(Context context) {
        b a2;
        synchronized (a.class) {
            String a3 = com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v3", DeviceUtils.KEY_OLD_NAME_STRING);
            if (com.alipay.security.mobile.module.a.a.a(a3)) {
                a3 = com.alipay.apmobilesecuritysdk.f.a.a("wxcasxx_v3", "wxcasxx");
            }
            a2 = a(a3);
        }
        return a2;
    }

    public static synchronized b c(Context context) {
        synchronized (a.class) {
            String a2 = com.alipay.apmobilesecuritysdk.f.a.a(context, "vkeyid_profiles_v3", DeviceUtils.KEY_OLD_NAME_STRING);
            if (com.alipay.security.mobile.module.a.a.a(a2)) {
                return null;
            }
            return a(a2);
        }
    }
}
