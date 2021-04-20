package com.baidu.sofire.g;

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
public final class r {
    public static long A = 0;

    /* renamed from: a  reason: collision with root package name */
    public static String f11455a = null;

    /* renamed from: b  reason: collision with root package name */
    public static long f11456b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static String f11457c = null;

    /* renamed from: d  reason: collision with root package name */
    public static long f11458d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static String f11459e = null;

    /* renamed from: f  reason: collision with root package name */
    public static long f11460f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static String f11461g = null;

    /* renamed from: h  reason: collision with root package name */
    public static long f11462h = 0;
    public static String i = null;
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
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            eVar.f11392c.putString("p_s_p_c", jSONObject.toString());
            eVar.f11392c.commit();
            a(jSONObject);
        } catch (Throwable unused) {
            d.a();
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
        try {
            if (r && s.a(context)) {
                if (!TextUtils.isEmpty(f11461g) && System.currentTimeMillis() - f11462h < 86400000) {
                    return f11461g;
                }
                com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
                if (TextUtils.isEmpty(f11461g)) {
                    f11461g = eVar.B();
                    f11462h = eVar.f11390a.getLong("p_s_e_c_t_t", 0L);
                    if (!TextUtils.isEmpty(f11461g) && System.currentTimeMillis() - f11462h < 86400000) {
                        return f11461g;
                    }
                }
                if (!q.b(context)) {
                    return f11461g;
                }
                if (!n(context)) {
                    return f11461g;
                }
                String f2 = f.f(context);
                if (!TextUtils.isEmpty(f2)) {
                    f11461g = f2;
                    f11462h = System.currentTimeMillis();
                    String str = f11461g;
                    if (TextUtils.isEmpty(str)) {
                        eVar.f11392c.putString("p_s_e_c_t", "");
                        eVar.f11392c.commit();
                    } else {
                        try {
                            eVar.f11392c.putString("p_s_e_c_t", new String(Base64.encode(a.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), str.getBytes("UTF-8")), 10), "UTF-8"));
                            eVar.f11392c.commit();
                        } catch (Throwable unused) {
                            d.a();
                        }
                    }
                    eVar.f11392c.putLong("p_s_e_c_t_t", f11462h);
                    eVar.f11392c.commit();
                }
                return f11461g;
            }
            return "";
        } catch (Throwable unused2) {
            d.a();
            return "";
        }
    }

    public static String g(Context context) {
        try {
            if (q && s.a(context)) {
                if (!TextUtils.isEmpty(f11459e) && System.currentTimeMillis() - f11460f < 86400000) {
                    return f11459e;
                }
                com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
                if (TextUtils.isEmpty(f11461g)) {
                    f11459e = eVar.C();
                    f11460f = eVar.f11390a.getLong("p_s_s_c_t_t", 0L);
                    if (!TextUtils.isEmpty(f11459e) && System.currentTimeMillis() - f11460f < 86400000) {
                        return f11459e;
                    }
                }
                if (!n(context)) {
                    return f11459e;
                }
                String e2 = f.e(context);
                if (!TextUtils.isEmpty(e2)) {
                    f11459e = e2;
                    f11460f = System.currentTimeMillis();
                    String str = f11459e;
                    if (TextUtils.isEmpty(str)) {
                        eVar.f11392c.putString("p_s_s_c_t", "");
                        eVar.f11392c.commit();
                    } else {
                        eVar.f11392c.putString("p_s_s_c_t", new String(Base64.encode(a.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), str.getBytes("UTF-8")), 10), "UTF-8"));
                        eVar.f11392c.commit();
                    }
                    eVar.f11392c.putLong("p_s_s_c_t_t", f11460f);
                    eVar.f11392c.commit();
                }
                return f11459e;
            }
            return "";
        } catch (Throwable unused) {
            d.a();
            return "";
        }
    }

    public static String h(Context context) {
        try {
            if (o && s.a(context)) {
                if (!TextUtils.isEmpty(f11455a) && System.currentTimeMillis() - f11456b < 86400000) {
                    return f11455a;
                }
                if ("com.baidu.input_huawei".equals(context.getPackageName())) {
                    return "";
                }
                com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
                if (TextUtils.isEmpty(f11455a)) {
                    f11455a = eVar.z();
                    f11456b = eVar.f11390a.getLong("p_s_i_t_t", 0L);
                    if (!TextUtils.isEmpty(f11455a) && System.currentTimeMillis() - f11456b < 86400000) {
                        return f11455a;
                    }
                }
                if (!q.a(context)) {
                    return f11455a;
                }
                if (!n(context)) {
                    return f11455a;
                }
                String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                if (!TextUtils.isEmpty(deviceId)) {
                    f11455a = deviceId;
                    f11456b = System.currentTimeMillis();
                    String str = f11455a;
                    if (TextUtils.isEmpty(str)) {
                        eVar.f11392c.putString("p_s_i_t", "");
                        eVar.f11392c.commit();
                    } else {
                        eVar.f11392c.putString("p_s_i_t", new String(Base64.encode(a.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), str.getBytes("UTF-8")), 10), "UTF-8"));
                        eVar.f11392c.commit();
                    }
                    eVar.f11392c.putLong("p_s_i_t_t", f11456b);
                    eVar.f11392c.commit();
                }
                return f11455a;
            }
            return "";
        } catch (Throwable unused) {
            d.a();
            return "";
        }
    }

    public static String i(Context context) {
        try {
            if (p && s.a(context)) {
                if (!TextUtils.isEmpty(f11457c) && System.currentTimeMillis() - f11458d < 86400000) {
                    return f11457c;
                }
                com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
                if (TextUtils.isEmpty(f11457c)) {
                    f11457c = eVar.A();
                    f11458d = eVar.f11390a.getLong("p_s_a_i_t_t", 0L);
                    if (!TextUtils.isEmpty(f11457c) && System.currentTimeMillis() - f11458d < 86400000) {
                        return f11457c;
                    }
                }
                if (!n(context)) {
                    return f11457c;
                }
                String string = Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
                if (!TextUtils.isEmpty(string)) {
                    f11457c = string;
                    f11458d = System.currentTimeMillis();
                    String str = f11457c;
                    if (TextUtils.isEmpty(str)) {
                        eVar.f11392c.putString("p_s_a_i_t", "");
                        eVar.f11392c.commit();
                    } else {
                        eVar.f11392c.putString("p_s_a_i_t", new String(Base64.encode(a.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), str.getBytes("UTF-8")), 10), "UTF-8"));
                        eVar.f11392c.commit();
                    }
                    eVar.f11392c.putLong("p_s_a_i_t_t", f11458d);
                    eVar.f11392c.commit();
                }
                return f11457c;
            }
            return "";
        } catch (Throwable unused) {
            d.a();
            return "";
        }
    }

    public static String j(Context context) {
        try {
            if (x && s.a(context)) {
                if (!TextUtils.isEmpty(i) && System.currentTimeMillis() - j < 86400000) {
                    return i;
                }
                com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
                if (TextUtils.isEmpty(i)) {
                    i = eVar.D();
                    j = eVar.f11390a.getLong("p_s_o_d_t_t", 0L);
                    if (!TextUtils.isEmpty(i) && System.currentTimeMillis() - j < 86400000) {
                        return i;
                    }
                }
                if (!n(context)) {
                    return i;
                }
                String b2 = com.baidu.sofire.h.a.a().b();
                if (!TextUtils.isEmpty(b2)) {
                    i = b2;
                    j = System.currentTimeMillis();
                    String str = i;
                    if (TextUtils.isEmpty(str)) {
                        eVar.f11392c.putString("p_s_o_d_t", "");
                        eVar.f11392c.commit();
                    } else {
                        eVar.f11392c.putString("p_s_o_d_t", new String(Base64.encode(a.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), str.getBytes("UTF-8")), 10), "UTF-8"));
                        eVar.f11392c.commit();
                    }
                    eVar.f11392c.putLong("p_s_o_d_t_t", j);
                    eVar.f11392c.commit();
                }
                return i;
            }
            return "";
        } catch (Throwable unused) {
            d.a();
            return "";
        }
    }

    public static String k(Context context) {
        try {
            if (u && s.a(context)) {
                if (!TextUtils.isEmpty(k) && System.currentTimeMillis() - l < 86400000) {
                    return k;
                }
                com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
                if (TextUtils.isEmpty(k)) {
                    k = eVar.E();
                    l = eVar.f11390a.getLong("p_s_s_o_t_t", 0L);
                    if (!TextUtils.isEmpty(k) && System.currentTimeMillis() - l < 86400000) {
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
                        eVar.f11392c.putString("p_s_s_o_t", "");
                        eVar.f11392c.commit();
                    } else {
                        try {
                            eVar.f11392c.putString("p_s_s_o_t", new String(Base64.encode(a.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), str.getBytes("UTF-8")), 10), "UTF-8"));
                            eVar.f11392c.commit();
                        } catch (Throwable unused) {
                            d.a();
                        }
                    }
                    eVar.f11392c.putLong("p_s_s_o_t_t", l);
                    eVar.f11392c.commit();
                }
                return k;
            }
            return "";
        } catch (Throwable unused2) {
            d.a();
            return "";
        }
    }

    public static String l(Context context) {
        try {
            if (v && s.a(context)) {
                if (!TextUtils.isEmpty(m) && System.currentTimeMillis() - n < 86400000) {
                    return m;
                }
                com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
                if (TextUtils.isEmpty(m)) {
                    m = eVar.F();
                    n = eVar.f11390a.getLong("p_s_n_o_t_t", 0L);
                    if (!TextUtils.isEmpty(m) && System.currentTimeMillis() - n < 86400000) {
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
                        eVar.f11392c.putString("p_s_n_o_t", "");
                        eVar.f11392c.commit();
                    } else {
                        try {
                            eVar.f11392c.putString("p_s_n_o_t", new String(Base64.encode(a.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), str.getBytes("UTF-8")), 10), "UTF-8"));
                            eVar.f11392c.commit();
                        } catch (Throwable unused) {
                            d.a();
                        }
                    }
                    eVar.f11392c.putLong("p_s_n_o_t_t", n);
                    eVar.f11392c.commit();
                }
                return m;
            }
            return "";
        } catch (Throwable unused2) {
            d.a();
            return "";
        }
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
        return s.a(context) && n(context);
    }

    public static boolean p(Context context) {
        try {
            return ((PowerManager) context.getSystemService("power")).isScreenOn();
        } catch (Throwable unused) {
            d.a();
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
            d.a();
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
            d.a();
            return false;
        }
    }

    public static synchronized void a(Context context) {
        synchronized (r.class) {
            if (context == null) {
                return;
            }
            try {
                if (y) {
                    return;
                }
                y = true;
                a(new JSONObject(new com.baidu.sofire.e(context).f11390a.getString("p_s_p_c", "")));
            } catch (Throwable unused) {
                d.a();
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
