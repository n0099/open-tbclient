package com.alipay.sdk.util;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1987a = "resultStatus";

    /* renamed from: b  reason: collision with root package name */
    public static final String f1988b = "memo";

    /* renamed from: c  reason: collision with root package name */
    public static final String f1989c = "result";

    public static Map<String, String> a(String str) {
        Map<String, String> a2 = a();
        try {
            return b(str);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a("biz", com.alipay.sdk.app.statistic.c.f1825g, th);
            return a2;
        }
    }

    public static Map<String, String> b(String str) {
        String[] split = str.split(";");
        HashMap hashMap = new HashMap();
        for (String str2 : split) {
            String substring = str2.substring(0, str2.indexOf("={"));
            hashMap.put(substring, a(str2, substring));
        }
        return hashMap;
    }

    public static Map<String, String> a() {
        com.alipay.sdk.app.k b2 = com.alipay.sdk.app.k.b(com.alipay.sdk.app.k.CANCELED.a());
        HashMap hashMap = new HashMap();
        hashMap.put(f1987a, Integer.toString(b2.a()));
        hashMap.put(f1988b, b2.b());
        hashMap.put("result", "");
        return hashMap;
    }

    public static String a(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf("}"));
    }
}
