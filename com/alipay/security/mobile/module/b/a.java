package com.alipay.security.mobile.module.b;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    public static String a(Context context, String str, String str2) {
        String a2;
        synchronized (a.class) {
            String str3 = null;
            if (context != null) {
                if (!com.alipay.security.mobile.module.a.a.a(str) && !com.alipay.security.mobile.module.a.a.a(str2)) {
                    try {
                        a2 = e.a(context, str, str2, "");
                    } catch (Throwable unused) {
                    }
                    if (com.alipay.security.mobile.module.a.a.a(a2)) {
                        return null;
                    }
                    str3 = com.alipay.security.mobile.module.a.a.c.b(com.alipay.security.mobile.module.a.a.c.a(), a2);
                    return str3;
                }
            }
            return null;
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        synchronized (a.class) {
            if (com.alipay.security.mobile.module.a.a.a(str) || com.alipay.security.mobile.module.a.a.a(str2) || context == null) {
                return;
            }
            try {
                String a2 = com.alipay.security.mobile.module.a.a.c.a(com.alipay.security.mobile.module.a.a.c.a(), str3);
                HashMap hashMap = new HashMap();
                hashMap.put(str2, a2);
                e.a(context, str, hashMap);
            } catch (Throwable unused) {
            }
        }
    }
}
