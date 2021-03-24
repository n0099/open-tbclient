package com.alipay.security.mobile.module.b;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class d {
    public static synchronized void a(Context context, String str, String str2, String str3) {
        synchronized (d.class) {
            if (!com.alipay.security.mobile.module.a.a.a(str)) {
                if (!com.alipay.security.mobile.module.a.a.a(str2) && context != null) {
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
    }
}
