package com.baidu.batsdk.a;

import android.content.Context;
import android.os.Build;
import com.baidu.batsdk.b.e;
import com.baidu.batsdk.b.g;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class c {
    private static Map<String, Object> a;
    private static long b = 0;

    public static void a(Context context) {
        if (!com.baidu.batsdk.a.c) {
            com.baidu.batsdk.f.a.b("dont sync");
        } else if (System.currentTimeMillis() - b < com.baidu.batsdk.a.h) {
            com.baidu.batsdk.f.a.b("sync wait.");
        } else {
            String e = com.baidu.batsdk.b.b.e(context);
            if ("NONE".equals(e) || "UNKNOWN".equals(e)) {
                com.baidu.batsdk.f.a.b("sync fail, netType is " + e);
                return;
            }
            if ("MOBILE".equals(e) || "WIFI".equals(e)) {
                if (a == null) {
                    HashMap hashMap = new HashMap();
                    a = hashMap;
                    hashMap.put("sdkVN", "1.0.0");
                    a.put("pkgName", e.a());
                    a.put("appVN", e.c());
                    a.put("appKey", com.baidu.batsdk.a.m);
                    a.put("channel", com.baidu.batsdk.a.l);
                    a.put("uid", g.b());
                    a.put("uname", g.d());
                    a.put("osVN", Build.VERSION.RELEASE);
                    a.put("brand", Build.BRAND);
                    a.put("model", Build.MODEL);
                    a.put("screenSize", com.baidu.batsdk.b.b.g(context));
                    a.put("locale", com.baidu.batsdk.b.b.c());
                    a.put("MAC", "N/A");
                }
                Map<String, Object> a2 = com.baidu.batsdk.d.b.a(a);
                if (a2 != null) {
                    com.baidu.batsdk.b.b.a(context, a2);
                    b = System.currentTimeMillis();
                    com.baidu.batsdk.f.a.b("sync success.");
                } else {
                    com.baidu.batsdk.f.a.c("sync fail.");
                }
            }
            com.baidu.batsdk.e.a.a();
            if ("ever".equals(com.baidu.batsdk.b.b.r(context))) {
                com.baidu.batsdk.e.b.a(context);
            }
        }
    }
}
