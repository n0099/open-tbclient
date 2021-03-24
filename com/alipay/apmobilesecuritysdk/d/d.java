package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class d {
    public static synchronized Map<String, String> a() {
        HashMap hashMap;
        synchronized (d.class) {
            hashMap = new HashMap();
            try {
                new com.alipay.apmobilesecuritysdk.c.b();
                hashMap.put("AE16", "");
            } catch (Throwable unused) {
            }
        }
        return hashMap;
    }

    public static synchronized Map<String, String> a(Context context) {
        HashMap hashMap;
        synchronized (d.class) {
            com.alipay.security.mobile.module.deviceinfo.d a2 = com.alipay.security.mobile.module.deviceinfo.d.a();
            com.alipay.security.mobile.module.deviceinfo.b a3 = com.alipay.security.mobile.module.deviceinfo.b.a();
            hashMap = new HashMap();
            hashMap.put("AE1", a2.b());
            StringBuilder sb = new StringBuilder();
            sb.append(a2.c() ? "1" : "0");
            hashMap.put("AE2", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(a2.a(context) ? "1" : "0");
            hashMap.put("AE3", sb2.toString());
            hashMap.put("AE4", a2.d());
            hashMap.put("AE5", a2.e());
            hashMap.put("AE6", a2.f());
            hashMap.put("AE7", a2.g());
            hashMap.put("AE8", a2.h());
            hashMap.put("AE9", a2.i());
            hashMap.put("AE10", a2.j());
            hashMap.put("AE11", a2.k());
            hashMap.put("AE12", a2.l());
            hashMap.put("AE13", a2.m());
            hashMap.put("AE14", a2.n());
            hashMap.put("AE15", a2.o());
            hashMap.put("AE21", a3.h());
        }
        return hashMap;
    }
}
