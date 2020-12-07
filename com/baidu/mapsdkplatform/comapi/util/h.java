package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.mapapi.VersionInfo;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.platform.comapi.util.JsonBuilder;
import com.baidu.searchbox.aps.megapp_interface.BuildConfig;
import com.baidu.webkit.internal.ETAG;
import com.tencent.open.SocialOperation;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes26.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static Context f2255a;
    public static String d;
    private static String h;
    private static String i;
    private static String j;
    private static String k;
    private static int l;
    private static int m;
    private static int n;
    private static int o;
    private static int p;
    private static int q;
    private static String r;
    private static String w;
    private static String x;
    private static final String e = h.class.getSimpleName();
    private static com.baidu.mapsdkplatform.comjni.util.a f = new com.baidu.mapsdkplatform.comjni.util.a();
    private static String g = "02";
    private static String s = "baidu";
    private static String t = "";
    private static String u = "";
    private static String v = "";
    private static String y = "-1";
    private static String z = "-1";
    public static final int b = Integer.parseInt(Build.VERSION.SDK);
    public static float c = 1.0f;
    private static String A = "";
    private static Map<String, String> B = new HashMap();
    private static String C = "";

    public static void a() {
        e();
    }

    public static void a(String str) {
        r = str;
        g();
    }

    public static void a(String str, String str2) {
        y = str2;
        z = str;
        g();
    }

    public static byte[] a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray();
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String b() {
        JsonBuilder jsonBuilder = new JsonBuilder();
        jsonBuilder.object();
        jsonBuilder.putStringValue("cpu", t);
        jsonBuilder.putStringValue("resid", g);
        jsonBuilder.putStringValue("channel", s);
        jsonBuilder.putStringValue("glr", u);
        jsonBuilder.putStringValue("glv", v);
        jsonBuilder.putStringValue("mb", h());
        jsonBuilder.putStringValue("sv", j());
        jsonBuilder.putStringValue("os", l());
        jsonBuilder.key("dpi_x").value(m());
        jsonBuilder.key("dpi_y").value(m());
        jsonBuilder.putStringValue("net", r);
        jsonBuilder.putStringValue("cuid", A);
        jsonBuilder.key(SocialOperation.GAME_SIGNATURE).arrayValue();
        byte[] a2 = a(f2255a);
        if (a2 != null) {
            for (byte b2 : a2) {
                jsonBuilder.value((int) b2);
            }
        }
        jsonBuilder.endArrayValue();
        jsonBuilder.putStringValue("pcn", f2255a.getPackageName());
        jsonBuilder.key("screen_x").value(i());
        jsonBuilder.key("screen_y").value(k());
        jsonBuilder.endObject();
        C = jsonBuilder.getJson();
        return C;
    }

    public static void b(Context context) {
        f2255a = context;
        if (context.getFilesDir() != null) {
            w = context.getFilesDir().getAbsolutePath();
        }
        if (context.getCacheDir() != null) {
            x = context.getCacheDir().getAbsolutePath();
        }
        i = Build.MODEL;
        j = "Android" + Build.VERSION.SDK;
        h = context.getPackageName();
        c(context);
        d(context);
        q();
        A = p();
        Log.e("CUIDTest", "test cuid online = " + A);
        B.put("resid", AppMD5.encodeUrlParamsValue(g));
        B.put("channel", AppMD5.encodeUrlParamsValue(n()));
        B.put("mb", AppMD5.encodeUrlParamsValue(h()));
        B.put("sv", AppMD5.encodeUrlParamsValue(j()));
        B.put("os", AppMD5.encodeUrlParamsValue(l()));
        B.put("dpi", AppMD5.encodeUrlParamsValue(String.format("%d,%d", Integer.valueOf(m()), Integer.valueOf(m()))));
        B.put("cuid", AppMD5.encodeUrlParamsValue(A));
        B.put("pcn", AppMD5.encodeUrlParamsValue(f2255a.getPackageName()));
        B.put("screen", AppMD5.encodeUrlParamsValue(String.format("%d,%d", Integer.valueOf(i()), Integer.valueOf(k()))));
        if (f != null) {
            f.a();
        }
    }

    public static String c() {
        return C;
    }

    private static void c(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            k = VersionInfo.getApiVersion();
            if (k != null && !k.equals("")) {
                k = k.replace('_', '.');
            }
            l = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            k = BuildConfig.VERSION_NAME;
            l = 1;
        }
    }

    public static String d() {
        if (B == null) {
            return null;
        }
        Date date = new Date();
        long seconds = (date.getSeconds() * 1000) + date.getTime();
        B.put("ctm", AppMD5.encodeUrlParamsValue(String.format("%f", Double.valueOf(((seconds % 1000) / 1000.0d) + (seconds / 1000)))));
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : B.entrySet()) {
            sb.append(ETAG.ITEM_SEPARATOR).append(entry.getKey()).append("=").append(entry.getValue());
        }
        return sb.toString();
    }

    private static void d(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = windowManager != null ? windowManager.getDefaultDisplay() : null;
        if (defaultDisplay != null) {
            m = defaultDisplay.getWidth();
            n = defaultDisplay.getHeight();
            defaultDisplay.getMetrics(displayMetrics);
        }
        c = displayMetrics.density;
        o = (int) displayMetrics.xdpi;
        p = (int) displayMetrics.ydpi;
        if (b > 3) {
            q = displayMetrics.densityDpi;
        } else {
            q = 160;
        }
        if (q == 0) {
            q = 160;
        }
    }

    public static void e() {
        if (f != null) {
            f.b();
        }
    }

    public static String f() {
        return r;
    }

    public static void g() {
        B.put("net", AppMD5.encodeUrlParamsValue(f()));
        B.put("appid", AppMD5.encodeUrlParamsValue(y));
        B.put("bduid", "");
        JsonBuilder jsonBuilder = new JsonBuilder();
        jsonBuilder.object();
        jsonBuilder.putStringValue("cpu", t);
        jsonBuilder.putStringValue("resid", g);
        jsonBuilder.putStringValue("channel", s);
        jsonBuilder.putStringValue("glr", u);
        jsonBuilder.putStringValue("glv", v);
        jsonBuilder.putStringValue("mb", h());
        jsonBuilder.putStringValue("sv", j());
        jsonBuilder.putStringValue("os", l());
        jsonBuilder.key("dpi_x").value(m());
        jsonBuilder.key("dpi_y").value(m());
        jsonBuilder.putStringValue("net", r);
        jsonBuilder.putStringValue("cuid", A);
        jsonBuilder.putStringValue("pcn", f2255a.getPackageName());
        jsonBuilder.key("screen_x").value(i());
        jsonBuilder.key("screen_y").value(k());
        jsonBuilder.putStringValue("appid", y);
        jsonBuilder.putStringValue("duid", z);
        if (!TextUtils.isEmpty(d)) {
            jsonBuilder.putStringValue("token", d);
        }
        jsonBuilder.endObject();
        SysUpdateObservable.getInstance().updatePhoneInfo(jsonBuilder.getJson());
    }

    public static String h() {
        return i;
    }

    public static int i() {
        return m;
    }

    public static String j() {
        return k;
    }

    public static int k() {
        return n;
    }

    public static String l() {
        return j;
    }

    public static int m() {
        return q;
    }

    public static String n() {
        return s;
    }

    public static String o() {
        return w;
    }

    public static String p() {
        String str;
        try {
            str = LBSAuthManager.getInstance(f2255a).getCUID();
        } catch (Exception e2) {
            str = "";
        }
        return str == null ? "" : str;
    }

    private static void q() {
        r = "0";
    }
}
