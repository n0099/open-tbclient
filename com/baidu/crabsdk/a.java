package com.baidu.crabsdk;

import com.baidu.android.imsdk.internal.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
/* loaded from: classes3.dex */
public final class a {
    public static OnAnrCrashListener P;
    public static OnCrashExceedListener Q;

    /* renamed from: a  reason: collision with root package name */
    public static String f1741a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f1742b = "alpha";
    public static String c = null;
    public static String d = "UNSET";
    public static int e = 10;
    public static int f = 5;
    public static int g = 10;
    public static int h = 200;
    public static boolean i = true;
    public static int j = 50;
    public static long k = Constants.SYNC_MSG_DELAY_TIME;
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
        return E ? O + "api_int/add_crab" : R;
    }

    public static String b() {
        return E ? O + "api_anr/add_crab" : S;
    }

    public static String c() {
        return E ? O + "api/newsync2" : "http://yq01-crab-offline01.epc.baidu.com:8123/api/newsync2";
    }

    public static String d() {
        return E ? O + "api/add_crab" : "http://yq01-crab-offline01.epc.baidu.com:8123/api/add_crab";
    }

    public static String e() {
        return E ? "https://qapm.baidu.com/api/mobile/upload-user-log" : "http://cp01-huatuo-odp.epc.baidu.com:8222/api/mobile/upload-user-log";
    }
}
