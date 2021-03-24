package com.baidu.crabsdk;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class a {
    public static OnAnrCrashListener P = null;
    public static OnCrashExceedListener Q = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f4634a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f4635b = "alpha";

    /* renamed from: c  reason: collision with root package name */
    public static String f4636c = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f4637d = "UNSET";

    /* renamed from: e  reason: collision with root package name */
    public static int f4638e = 10;

    /* renamed from: f  reason: collision with root package name */
    public static int f4639f = 5;

    /* renamed from: g  reason: collision with root package name */
    public static int f4640g = 10;

    /* renamed from: h  reason: collision with root package name */
    public static int f4641h = 200;
    public static boolean i = true;
    public static int j = 50;
    public static long k = 10800000;
    public static long l = 30000;
    public static boolean m = false;
    public static boolean n = false;
    public static String o = "";
    public static boolean p = false;
    public static boolean q = true;
    public static boolean r = false;
    public static boolean s = false;
    public static int t = 10;
    public static int u = 30;
    public static int v = 10;
    public static int w = 30;
    public static HashMap<String, Integer> x = new HashMap<>();
    public static int y = 0;
    public static int z = -1;
    public static int A = 0;
    public static int B = 0;
    public static final SimpleDateFormat C = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA);
    public static boolean D = false;
    public static boolean E = true;
    public static boolean F = true;
    public static boolean G = true;
    public static boolean H = true;
    public static int I = 1;
    public static boolean J = false;
    public static boolean K = true;
    public static boolean L = false;
    public static ArrayList<String> M = new ArrayList<>();
    public static boolean N = false;
    public static String O = "https://crab.baidu.com/";
    public static String R = "http://yq01-crab-offline01.epc.baidu.com:8123/api/add_crab";
    public static String S = "http://yq01-crab-offline01.epc.baidu.com:8123/api/add_crab";

    public static String a() {
        if (E) {
            return O + "api_int/add_crab";
        }
        return R;
    }

    public static String b() {
        if (E) {
            return O + "api_anr/add_crab";
        }
        return S;
    }

    public static String c() {
        if (E) {
            return O + "api/newsync2";
        }
        return "http://yq01-crab-offline01.epc.baidu.com:8123/api/newsync2";
    }

    public static String d() {
        if (E) {
            return O + "api/add_crab";
        }
        return "http://yq01-crab-offline01.epc.baidu.com:8123/api/add_crab";
    }

    public static String e() {
        return E ? "https://qapm.baidu.com/api/mobile/upload-user-log" : "http://cp01-huatuo-odp.epc.baidu.com:8222/api/mobile/upload-user-log";
    }
}
