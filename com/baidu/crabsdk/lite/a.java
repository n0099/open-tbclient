package com.baidu.crabsdk.lite;

import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import java.net.Proxy;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, HashMap<String, Object>> f4639a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static String f4640b = null;

    /* renamed from: c  reason: collision with root package name */
    public static int f4641c = 10;

    /* renamed from: d  reason: collision with root package name */
    public static int f4642d = 200;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f4643e = true;

    /* renamed from: f  reason: collision with root package name */
    public static long f4644f = StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD;

    /* renamed from: g  reason: collision with root package name */
    public static HashMap<String, Integer> f4645g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    public static boolean f4646h;

    /* renamed from: i  reason: collision with root package name */
    public static boolean f4647i;
    public static boolean j;
    public static boolean k;
    public static Proxy l;
    public static String m;
    public static String n;
    public static String o;

    static {
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA);
        f4646h = true;
        f4647i = true;
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
        if (f4646h) {
            if (m == null || (hashMap = f4639a.get(str)) == null || (obj = hashMap.get("domain_url")) == null) {
                return "https://crab.baidu.com/api_int/add_crab";
            }
            return ((String) obj) + "api_int/add_crab";
        }
        return n;
    }

    public static String b(String str) {
        HashMap<String, Object> hashMap;
        Object obj;
        if (f4646h) {
            if (m == null || (hashMap = f4639a.get(str)) == null || (obj = hashMap.get("domain_url")) == null) {
                return "https://crab.baidu.com/api_anr/add_crab";
            }
            return ((String) obj) + "api_int/add_crab";
        }
        return o;
    }

    public static String c(String str) {
        HashMap<String, Object> hashMap;
        Object obj;
        if (f4646h) {
            if (m == null || (hashMap = f4639a.get(str)) == null || (obj = hashMap.get("domain_url")) == null) {
                return "https://crab.baidu.com/api/newsync2";
            }
            return ((String) obj) + "api_int/add_crab";
        }
        return "http://cq01-tdw-bfe02.cq01.baidu.com:8090/batsdk/api/newsync2";
    }
}
