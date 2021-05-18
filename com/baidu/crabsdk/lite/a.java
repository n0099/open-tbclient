package com.baidu.crabsdk.lite;

import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import java.net.Proxy;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, HashMap<String, Object>> f4716a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static String f4717b = null;

    /* renamed from: c  reason: collision with root package name */
    public static int f4718c = 10;

    /* renamed from: d  reason: collision with root package name */
    public static int f4719d = 200;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f4720e = true;

    /* renamed from: f  reason: collision with root package name */
    public static long f4721f = StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD;

    /* renamed from: g  reason: collision with root package name */
    public static HashMap<String, Integer> f4722g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    public static boolean f4723h;

    /* renamed from: i  reason: collision with root package name */
    public static boolean f4724i;
    public static boolean j;
    public static boolean k;
    public static Proxy l;
    public static String m;
    public static String n;
    public static String o;

    static {
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA);
        f4723h = true;
        f4724i = true;
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
        if (f4723h) {
            if (m == null || (hashMap = f4716a.get(str)) == null || (obj = hashMap.get("domain_url")) == null) {
                return "https://crab.baidu.com/api_int/add_crab";
            }
            return ((String) obj) + "api_int/add_crab";
        }
        return n;
    }

    public static String b(String str) {
        HashMap<String, Object> hashMap;
        Object obj;
        if (f4723h) {
            if (m == null || (hashMap = f4716a.get(str)) == null || (obj = hashMap.get("domain_url")) == null) {
                return "https://crab.baidu.com/api_anr/add_crab";
            }
            return ((String) obj) + "api_int/add_crab";
        }
        return o;
    }

    public static String c(String str) {
        HashMap<String, Object> hashMap;
        Object obj;
        if (f4723h) {
            if (m == null || (hashMap = f4716a.get(str)) == null || (obj = hashMap.get("domain_url")) == null) {
                return "https://crab.baidu.com/api/newsync2";
            }
            return ((String) obj) + "api_int/add_crab";
        }
        return "http://cq01-tdw-bfe02.cq01.baidu.com:8090/batsdk/api/newsync2";
    }
}
