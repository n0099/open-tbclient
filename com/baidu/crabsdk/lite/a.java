package com.baidu.crabsdk.lite;

import java.net.Proxy;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, HashMap<String, Object>> f4658a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static String f4659b = null;

    /* renamed from: c  reason: collision with root package name */
    public static int f4660c = 10;

    /* renamed from: d  reason: collision with root package name */
    public static int f4661d = 200;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f4662e = true;

    /* renamed from: f  reason: collision with root package name */
    public static long f4663f = 30000;

    /* renamed from: g  reason: collision with root package name */
    public static HashMap<String, Integer> f4664g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    public static boolean f4665h;

    /* renamed from: i  reason: collision with root package name */
    public static boolean f4666i;
    public static boolean j;
    public static boolean k;
    public static Proxy l;
    public static String m;
    public static String n;
    public static String o;

    static {
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA);
        f4665h = true;
        f4666i = true;
        j = true;
        k = false;
        l = null;
        m = null;
        n = "http://cq01-tdw-bfe02.cq01.baidu.com:8123/api/add_crab";
        o = "http://cq01-tdw-bfe02.cq01.baidu.com:8123/api/add_crab";
    }

    public static String a(String str) {
        HashMap<String, Object> hashMap;
        Object obj;
        if (f4665h) {
            if (m == null || (hashMap = f4658a.get(str)) == null || (obj = hashMap.get("domain_url")) == null) {
                return "https://crab.baidu.com/api_int/add_crab";
            }
            return ((String) obj) + "api_int/add_crab";
        }
        return n;
    }

    public static String b(String str) {
        HashMap<String, Object> hashMap;
        Object obj;
        if (f4665h) {
            if (m == null || (hashMap = f4658a.get(str)) == null || (obj = hashMap.get("domain_url")) == null) {
                return "https://crab.baidu.com/api_anr/add_crab";
            }
            return ((String) obj) + "api_int/add_crab";
        }
        return o;
    }

    public static String c(String str) {
        HashMap<String, Object> hashMap;
        Object obj;
        if (f4665h) {
            if (m == null || (hashMap = f4658a.get(str)) == null || (obj = hashMap.get("domain_url")) == null) {
                return "https://crab.baidu.com/api/newsync2";
            }
            return ((String) obj) + "api_int/add_crab";
        }
        return "http://cq01-tdw-bfe02.cq01.baidu.com:8090/batsdk/api/newsync2";
    }
}
