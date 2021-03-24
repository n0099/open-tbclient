package com.alipay.apmobilesecuritysdk.f;

import android.content.Context;
import android.os.Environment;
import com.alipay.security.mobile.module.b.e;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static String a(Context context, String str, String str2) {
        String a2;
        if (context == null || com.alipay.security.mobile.module.a.a.a(str)) {
            return null;
        }
        if (!com.alipay.security.mobile.module.a.a.a(str2)) {
            try {
                a2 = e.a(context, str, str2, "");
                if (com.alipay.security.mobile.module.a.a.a(a2)) {
                    return null;
                }
            } catch (Throwable unused) {
                return null;
            }
        }
        return com.alipay.security.mobile.module.a.a.c.b(com.alipay.security.mobile.module.a.a.c.a(), a2);
    }

    public static String a(String str, String str2) {
        synchronized (a.class) {
            if (com.alipay.security.mobile.module.a.a.a(str) || com.alipay.security.mobile.module.a.a.a(str2)) {
                return null;
            }
            String a2 = com.alipay.security.mobile.module.b.b.a(str);
            if (com.alipay.security.mobile.module.a.a.a(a2)) {
                return null;
            }
            String string = new JSONObject(a2).getString(str2);
            if (com.alipay.security.mobile.module.a.a.a(string)) {
                return null;
            }
            return com.alipay.security.mobile.module.a.a.c.b(com.alipay.security.mobile.module.a.a.c.a(), string);
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (!com.alipay.security.mobile.module.a.a.a(str) && !com.alipay.security.mobile.module.a.a.a(str2) && context != null) {
            try {
                String a2 = com.alipay.security.mobile.module.a.a.c.a(com.alipay.security.mobile.module.a.a.c.a(), str3);
                HashMap hashMap = new HashMap();
                hashMap.put(str2, a2);
                e.a(context, str, hashMap);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX DEBUG: Throwable added to exception handler: 'Exception', keep only Throwable */
    public static void a(String str, String str2, String str3) {
        synchronized (a.class) {
            if (com.alipay.security.mobile.module.a.a.a(str) || com.alipay.security.mobile.module.a.a.a(str2)) {
                return;
            }
            try {
                String a2 = com.alipay.security.mobile.module.b.b.a(str);
                JSONObject jSONObject = new JSONObject();
                if (com.alipay.security.mobile.module.a.a.b(a2)) {
                    try {
                        jSONObject = new JSONObject(a2);
                    } catch (Exception unused) {
                        jSONObject = new JSONObject();
                    }
                }
                jSONObject.put(str2, com.alipay.security.mobile.module.a.a.c.a(com.alipay.security.mobile.module.a.a.c.a(), str3));
                jSONObject.toString();
                try {
                    System.clearProperty(str);
                } catch (Throwable unused2) {
                }
                if (com.alipay.security.mobile.module.b.c.a()) {
                    String str4 = ".SystemConfig" + File.separator + str;
                    if (com.alipay.security.mobile.module.b.c.a()) {
                        File file = new File(Environment.getExternalStorageDirectory(), str4);
                        if (file.exists() && file.isFile()) {
                            file.delete();
                        }
                    }
                }
            } catch (Throwable unused3) {
            }
        }
    }
}
