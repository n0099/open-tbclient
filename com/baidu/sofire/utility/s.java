package com.baidu.sofire.utility;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import java.util.Arrays;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class s {
    public static long A = 0;

    /* renamed from: a  reason: collision with root package name */
    public static String f10440a = null;

    /* renamed from: b  reason: collision with root package name */
    public static long f10441b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static String f10442c = null;

    /* renamed from: d  reason: collision with root package name */
    public static long f10443d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static String f10444e = null;

    /* renamed from: f  reason: collision with root package name */
    public static long f10445f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static String f10446g = null;

    /* renamed from: h  reason: collision with root package name */
    public static long f10447h = 0;

    /* renamed from: i  reason: collision with root package name */
    public static String f10448i = null;
    public static long j = 0;
    public static String k = null;
    public static long l = 0;
    public static String m = null;
    public static long n = 0;
    public static boolean o = true;
    public static boolean p = true;
    public static boolean q = true;
    public static boolean r = true;
    public static boolean s = true;
    public static boolean t = true;
    public static boolean u = true;
    public static boolean v = true;
    public static boolean w = true;
    public static boolean x = true;
    public static boolean y = false;
    public static boolean z;

    public static void a(Context context, JSONObject jSONObject) {
        if (context == null || jSONObject == null) {
            return;
        }
        try {
            com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
            a2.f10322b.putString("p_s_p_c", jSONObject.toString());
            a2.f10322b.commit();
            a(jSONObject);
        } catch (Throwable unused) {
            c.a();
        }
    }

    public static boolean b(Context context) {
        return context != null && q && o(context);
    }

    public static boolean c(Context context) {
        return context != null && r && o(context);
    }

    public static boolean d(Context context) {
        return context != null && s && o(context);
    }

    public static boolean e(Context context) {
        return context != null && t && o(context);
    }

    public static String f(Context context) {
        if (context != null) {
            try {
                if (r && t.a(context)) {
                    if (System.currentTimeMillis() - f10447h < 86400000) {
                        return f10446g;
                    }
                    com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
                    if (TextUtils.isEmpty(f10446g)) {
                        f10446g = a2.z();
                        f10447h = a2.f10321a.getLong("p_s_e_c_t_t", 0L);
                        if (System.currentTimeMillis() - f10447h < 86400000) {
                            return f10446g;
                        }
                    }
                    if (!r.b(context)) {
                        return f10446g;
                    }
                    if (!n(context)) {
                        return f10446g;
                    }
                    String e2 = e.e(context);
                    if (!TextUtils.isEmpty(e2)) {
                        f10446g = e2;
                        f10447h = System.currentTimeMillis();
                        String str = f10446g;
                        if (TextUtils.isEmpty(str)) {
                            a2.f10322b.putString("p_s_e_c_t", "");
                            a2.f10322b.commit();
                        } else {
                            a2.f10322b.putString("p_s_e_c_t", new String(Base64.encode(g.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), str.getBytes("UTF-8"), true), 10), "UTF-8"));
                            a2.f10322b.commit();
                        }
                        a2.g(f10447h);
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        f10447h = currentTimeMillis;
                        a2.g(currentTimeMillis);
                    }
                    return f10446g;
                }
            } catch (Throwable unused) {
                c.a();
                return "";
            }
        }
        return "";
    }

    public static String g(Context context) {
        if (context != null) {
            try {
                if (q && t.a(context)) {
                    if (System.currentTimeMillis() - f10445f < 86400000) {
                        return f10444e;
                    }
                    com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
                    if (TextUtils.isEmpty(f10446g)) {
                        f10444e = a2.A();
                        f10445f = a2.f10321a.getLong("p_s_s_c_t_t", 0L);
                        if (System.currentTimeMillis() - f10445f < 86400000) {
                            return f10444e;
                        }
                    }
                    if (!n(context)) {
                        return f10444e;
                    }
                    String d2 = e.d(context);
                    if (!TextUtils.isEmpty(d2)) {
                        f10444e = d2;
                        f10445f = System.currentTimeMillis();
                        String str = f10444e;
                        if (TextUtils.isEmpty(str)) {
                            a2.f10322b.putString("p_s_s_c_t", "");
                            a2.f10322b.commit();
                        } else {
                            a2.f10322b.putString("p_s_s_c_t", new String(Base64.encode(g.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), str.getBytes("UTF-8"), true), 10), "UTF-8"));
                            a2.f10322b.commit();
                        }
                        a2.h(f10445f);
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        f10445f = currentTimeMillis;
                        a2.h(currentTimeMillis);
                    }
                    return f10444e;
                }
            } catch (Throwable unused) {
                c.a();
                return "";
            }
        }
        return "";
    }

    public static String h(Context context) {
        if (context != null) {
            try {
                if (o && t.a(context)) {
                    if (System.currentTimeMillis() - f10441b < 86400000) {
                        return f10440a;
                    }
                    if ("com.baidu.input_huawei".equals(context.getPackageName())) {
                        return "";
                    }
                    com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
                    if (TextUtils.isEmpty(f10440a)) {
                        f10440a = a2.x();
                        f10441b = a2.f10321a.getLong("p_s_i_t_t", 0L);
                        if (System.currentTimeMillis() - f10441b < 86400000) {
                            return f10440a;
                        }
                    }
                    if (!r.a(context)) {
                        return f10440a;
                    }
                    if (!n(context)) {
                        return f10440a;
                    }
                    String deviceId = Build.VERSION.SDK_INT < 29 ? ((TelephonyManager) context.getSystemService("phone")).getDeviceId() : "";
                    if (!TextUtils.isEmpty(deviceId)) {
                        f10440a = deviceId;
                        f10441b = System.currentTimeMillis();
                        String str = f10440a;
                        if (TextUtils.isEmpty(str)) {
                            a2.f10322b.putString("p_s_i_t", "");
                            a2.f10322b.commit();
                        } else {
                            try {
                                a2.f10322b.putString("p_s_i_t", new String(Base64.encode(g.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), str.getBytes("UTF-8"), true), 10), "UTF-8"));
                                a2.f10322b.commit();
                            } catch (Throwable unused) {
                                c.a();
                            }
                        }
                        a2.e(f10441b);
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        f10441b = currentTimeMillis;
                        a2.e(currentTimeMillis);
                    }
                    return f10440a;
                }
            } catch (Throwable unused2) {
                c.a();
                return "";
            }
        }
        return "";
    }

    public static String i(Context context) {
        if (context != null) {
            try {
                if (p && t.a(context)) {
                    if (System.currentTimeMillis() - f10443d < 86400000) {
                        return f10442c;
                    }
                    com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
                    if (TextUtils.isEmpty(f10442c)) {
                        f10442c = a2.y();
                        f10443d = a2.f10321a.getLong("p_s_a_i_t_t", 0L);
                        if (System.currentTimeMillis() - f10443d < 86400000) {
                            return f10442c;
                        }
                    }
                    if (!n(context)) {
                        return f10442c;
                    }
                    String string = Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
                    if (!TextUtils.isEmpty(string)) {
                        f10442c = string;
                        f10443d = System.currentTimeMillis();
                        String str = f10442c;
                        if (TextUtils.isEmpty(str)) {
                            a2.f10322b.putString("p_s_a_i_t", "");
                            a2.f10322b.commit();
                        } else {
                            try {
                                a2.f10322b.putString("p_s_a_i_t", new String(Base64.encode(g.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), str.getBytes("UTF-8"), true), 10), "UTF-8"));
                                a2.f10322b.commit();
                            } catch (Throwable unused) {
                                c.a();
                            }
                        }
                        a2.f(f10443d);
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        f10443d = currentTimeMillis;
                        a2.f(currentTimeMillis);
                    }
                    return f10442c;
                }
            } catch (Throwable unused2) {
                c.a();
                return "";
            }
        }
        return "";
    }

    public static String j(Context context) {
        if (context != null) {
            try {
                if (x && t.a(context)) {
                    if (System.currentTimeMillis() - j < 86400000) {
                        return f10448i;
                    }
                    com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
                    if (TextUtils.isEmpty(f10448i)) {
                        f10448i = a2.B();
                        j = a2.f10321a.getLong("p_s_o_d_t_t", 0L);
                        if (System.currentTimeMillis() - j < 86400000) {
                            return f10448i;
                        }
                    }
                    if (!n(context)) {
                        return f10448i;
                    }
                    String b2 = com.baidu.sofire.j.a.a().b();
                    if (!TextUtils.isEmpty(b2)) {
                        f10448i = b2;
                        j = System.currentTimeMillis();
                        String str = f10448i;
                        if (TextUtils.isEmpty(str)) {
                            a2.f10322b.putString("p_s_o_d_t", "");
                            a2.f10322b.commit();
                        } else {
                            try {
                                a2.f10322b.putString("p_s_o_d_t", new String(Base64.encode(g.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), str.getBytes("UTF-8"), true), 10), "UTF-8"));
                                a2.f10322b.commit();
                            } catch (Throwable unused) {
                                c.a();
                            }
                        }
                        a2.i(j);
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        j = currentTimeMillis;
                        a2.i(currentTimeMillis);
                    }
                    return f10448i;
                }
            } catch (Throwable unused2) {
                c.a();
                return "";
            }
        }
        return "";
    }

    public static String k(Context context) {
        if (context != null) {
            try {
                if (u && t.a(context)) {
                    if (System.currentTimeMillis() - l < 86400000) {
                        return k;
                    }
                    com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
                    if (TextUtils.isEmpty(k)) {
                        k = a2.C();
                        l = a2.f10321a.getLong("p_s_s_o_t_t", 0L);
                        if (System.currentTimeMillis() - l < 86400000) {
                            return k;
                        }
                    }
                    if (!n(context)) {
                        return k;
                    }
                    String simOperatorName = ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
                    if (!TextUtils.isEmpty(simOperatorName)) {
                        k = simOperatorName;
                        l = System.currentTimeMillis();
                        String str = k;
                        if (TextUtils.isEmpty(str)) {
                            a2.f10322b.putString("p_s_s_o_t", "");
                            a2.f10322b.commit();
                        } else {
                            try {
                                a2.f10322b.putString("p_s_s_o_t", new String(Base64.encode(g.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), str.getBytes("UTF-8"), true), 10), "UTF-8"));
                                a2.f10322b.commit();
                            } catch (Throwable unused) {
                                c.a();
                            }
                        }
                        a2.j(l);
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        l = currentTimeMillis;
                        a2.j(currentTimeMillis);
                    }
                    return k;
                }
            } catch (Throwable unused2) {
                c.a();
                return "";
            }
        }
        return "";
    }

    public static String l(Context context) {
        if (context != null) {
            try {
                if (v && t.a(context)) {
                    if (System.currentTimeMillis() - n < 86400000) {
                        return m;
                    }
                    com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
                    if (TextUtils.isEmpty(m)) {
                        m = a2.D();
                        n = a2.f10321a.getLong("p_s_n_o_t_t", 0L);
                        if (System.currentTimeMillis() - n < 86400000) {
                            return m;
                        }
                    }
                    if (!n(context)) {
                        return m;
                    }
                    String networkOperator = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
                    if (!TextUtils.isEmpty(networkOperator)) {
                        m = networkOperator;
                        n = System.currentTimeMillis();
                        String str = m;
                        if (TextUtils.isEmpty(str)) {
                            a2.f10322b.putString("p_s_n_o_t", "");
                            a2.f10322b.commit();
                        } else {
                            try {
                                a2.f10322b.putString("p_s_n_o_t", new String(Base64.encode(g.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), str.getBytes("UTF-8"), true), 10), "UTF-8"));
                                a2.f10322b.commit();
                            } catch (Throwable unused) {
                                c.a();
                            }
                        }
                        a2.k(n);
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        n = currentTimeMillis;
                        a2.k(currentTimeMillis);
                    }
                    return m;
                }
            } catch (Throwable unused2) {
                c.a();
                return "";
            }
        }
        return "";
    }

    public static boolean m(Context context) {
        if (context == null) {
            return false;
        }
        return w || n(context);
    }

    public static boolean n(Context context) {
        if (System.currentTimeMillis() - A < 1000) {
            return z;
        }
        z = p(context) && q(context);
        A = System.currentTimeMillis();
        return z;
    }

    public static boolean o(Context context) {
        return t.a(context) && n(context);
    }

    public static boolean p(Context context) {
        try {
            return ((PowerManager) context.getSystemService("power")).isScreenOn();
        } catch (Throwable unused) {
            c.a();
            return false;
        }
    }

    public static boolean q(Context context) {
        try {
            if (Build.VERSION.SDK_INT < 21) {
                return r(context);
            }
            if (context != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                    if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.importanceReasonCode == 0 && runningAppProcessInfo.pkgList != null && runningAppProcessInfo.pkgList.length != 0 && Arrays.asList(runningAppProcessInfo.pkgList).contains(context.getPackageName())) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        } catch (Throwable unused) {
            c.a();
            return false;
        }
    }

    public static boolean r(Context context) {
        ActivityManager.RunningTaskInfo runningTaskInfo;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager.getRunningTasks(1) == null || (runningTaskInfo = activityManager.getRunningTasks(1).get(0)) == null) {
                return false;
            }
            return context.getPackageName().equals(runningTaskInfo.topActivity.getPackageName());
        } catch (Throwable unused) {
            c.a();
            return false;
        }
    }

    public static synchronized void a(Context context) {
        synchronized (s.class) {
            if (context == null) {
                return;
            }
            try {
                if (y) {
                    return;
                }
                y = true;
                a(new JSONObject(com.baidu.sofire.h.a.a(context).f10321a.getString("p_s_p_c", "")));
            } catch (Throwable unused) {
                c.a();
            }
        }
    }

    public static void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        w = jSONObject.optInt("0", 1) != 0;
        JSONArray optJSONArray = jSONObject.optJSONArray("1");
        if (optJSONArray == null) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            hashSet.add(Integer.valueOf(optJSONArray.optInt(i2)));
        }
        if (hashSet.contains(27)) {
            o = false;
        } else {
            o = true;
        }
        if (hashSet.contains(34)) {
            u = false;
        } else {
            u = true;
        }
        if (hashSet.contains(40)) {
            p = false;
        } else {
            p = true;
        }
        if (hashSet.contains(41)) {
            x = false;
        } else {
            x = true;
        }
        if (hashSet.contains(42)) {
            q = false;
        } else {
            q = true;
        }
        if (hashSet.contains(43)) {
            s = false;
        } else {
            s = true;
        }
        if (hashSet.contains(44)) {
            r = false;
        } else {
            r = true;
        }
        if (hashSet.contains(45)) {
            t = false;
        } else {
            t = true;
        }
        if (hashSet.contains(46)) {
            v = false;
        } else {
            v = true;
        }
    }
}
