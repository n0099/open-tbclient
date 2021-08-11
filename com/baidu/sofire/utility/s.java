package com.baidu.sofire.utility;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Arrays;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class s {
    public static /* synthetic */ Interceptable $ic = null;
    public static long A = 0;

    /* renamed from: a  reason: collision with root package name */
    public static String f45239a = null;

    /* renamed from: b  reason: collision with root package name */
    public static long f45240b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static String f45241c = null;

    /* renamed from: d  reason: collision with root package name */
    public static long f45242d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static String f45243e = null;

    /* renamed from: f  reason: collision with root package name */
    public static long f45244f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static String f45245g = null;

    /* renamed from: h  reason: collision with root package name */
    public static long f45246h = 0;

    /* renamed from: i  reason: collision with root package name */
    public static String f45247i = null;

    /* renamed from: j  reason: collision with root package name */
    public static long f45248j = 0;
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
    public static boolean y;
    public static boolean z;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1443542022, "Lcom/baidu/sofire/utility/s;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1443542022, "Lcom/baidu/sofire/utility/s;");
        }
    }

    public static void a(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, context, jSONObject) == null) || context == null || jSONObject == null) {
            return;
        }
        try {
            com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
            a2.f45118b.putString("p_s_p_c", jSONObject.toString());
            a2.f45118b.commit();
            a(jSONObject);
        } catch (Throwable unused) {
            c.a();
        }
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? context != null && q && o(context) : invokeL.booleanValue;
    }

    public static boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) ? context != null && r && o(context) : invokeL.booleanValue;
    }

    public static boolean d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) ? context != null && s && o(context) : invokeL.booleanValue;
    }

    public static boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) ? context != null && t && o(context) : invokeL.booleanValue;
    }

    public static String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            if (context != null) {
                try {
                    if (r && t.a(context)) {
                        if (System.currentTimeMillis() - f45246h < 86400000) {
                            return f45245g;
                        }
                        com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
                        if (TextUtils.isEmpty(f45245g)) {
                            f45245g = a2.z();
                            f45246h = a2.f45117a.getLong("p_s_e_c_t_t", 0L);
                            if (System.currentTimeMillis() - f45246h < 86400000) {
                                return f45245g;
                            }
                        }
                        if (!r.b(context)) {
                            return f45245g;
                        }
                        if (!n(context)) {
                            return f45245g;
                        }
                        String e2 = e.e(context);
                        if (!TextUtils.isEmpty(e2)) {
                            f45245g = e2;
                            f45246h = System.currentTimeMillis();
                            String str = f45245g;
                            if (TextUtils.isEmpty(str)) {
                                a2.f45118b.putString("p_s_e_c_t", "");
                                a2.f45118b.commit();
                            } else {
                                a2.f45118b.putString("p_s_e_c_t", new String(Base64.encode(g.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), str.getBytes("UTF-8"), true), 10), "UTF-8"));
                                a2.f45118b.commit();
                            }
                            a2.g(f45246h);
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            f45246h = currentTimeMillis;
                            a2.g(currentTimeMillis);
                        }
                        return f45245g;
                    }
                } catch (Throwable unused) {
                    c.a();
                    return "";
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            if (context != null) {
                try {
                    if (q && t.a(context)) {
                        if (System.currentTimeMillis() - f45244f < 86400000) {
                            return f45243e;
                        }
                        com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
                        if (TextUtils.isEmpty(f45245g)) {
                            f45243e = a2.A();
                            f45244f = a2.f45117a.getLong("p_s_s_c_t_t", 0L);
                            if (System.currentTimeMillis() - f45244f < 86400000) {
                                return f45243e;
                            }
                        }
                        if (!n(context)) {
                            return f45243e;
                        }
                        String d2 = e.d(context);
                        if (!TextUtils.isEmpty(d2)) {
                            f45243e = d2;
                            f45244f = System.currentTimeMillis();
                            String str = f45243e;
                            if (TextUtils.isEmpty(str)) {
                                a2.f45118b.putString("p_s_s_c_t", "");
                                a2.f45118b.commit();
                            } else {
                                try {
                                    a2.f45118b.putString("p_s_s_c_t", new String(Base64.encode(g.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), str.getBytes("UTF-8"), true), 10), "UTF-8"));
                                    a2.f45118b.commit();
                                } catch (Throwable unused) {
                                    c.a();
                                }
                            }
                            a2.h(f45244f);
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            f45244f = currentTimeMillis;
                            a2.h(currentTimeMillis);
                        }
                        return f45243e;
                    }
                } catch (Throwable unused2) {
                    c.a();
                    return "";
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            if (context != null) {
                try {
                    if (o && t.a(context)) {
                        if (System.currentTimeMillis() - f45240b < 86400000) {
                            return f45239a;
                        }
                        if ("com.baidu.input_huawei".equals(context.getPackageName())) {
                            return "";
                        }
                        com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
                        if (TextUtils.isEmpty(f45239a)) {
                            f45239a = a2.x();
                            f45240b = a2.f45117a.getLong("p_s_i_t_t", 0L);
                            if (System.currentTimeMillis() - f45240b < 86400000) {
                                return f45239a;
                            }
                        }
                        if (!r.a(context)) {
                            return f45239a;
                        }
                        if (!n(context)) {
                            return f45239a;
                        }
                        String deviceId = Build.VERSION.SDK_INT < 29 ? ((TelephonyManager) context.getSystemService("phone")).getDeviceId() : "";
                        if (!TextUtils.isEmpty(deviceId)) {
                            f45239a = deviceId;
                            f45240b = System.currentTimeMillis();
                            String str = f45239a;
                            if (TextUtils.isEmpty(str)) {
                                a2.f45118b.putString("p_s_i_t", "");
                                a2.f45118b.commit();
                            } else {
                                a2.f45118b.putString("p_s_i_t", new String(Base64.encode(g.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), str.getBytes("UTF-8"), true), 10), "UTF-8"));
                                a2.f45118b.commit();
                            }
                            a2.e(f45240b);
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            f45240b = currentTimeMillis;
                            a2.e(currentTimeMillis);
                        }
                        return f45239a;
                    }
                } catch (Throwable unused) {
                    c.a();
                    return "";
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            if (context != null) {
                try {
                    if (p && t.a(context)) {
                        if (System.currentTimeMillis() - f45242d < 86400000) {
                            return f45241c;
                        }
                        com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
                        if (TextUtils.isEmpty(f45241c)) {
                            f45241c = a2.y();
                            f45242d = a2.f45117a.getLong("p_s_a_i_t_t", 0L);
                            if (System.currentTimeMillis() - f45242d < 86400000) {
                                return f45241c;
                            }
                        }
                        if (!n(context)) {
                            return f45241c;
                        }
                        String string = Settings.Secure.getString(context.getContentResolver(), IAdRequestParam.ANDROID_ID);
                        if (!TextUtils.isEmpty(string)) {
                            f45241c = string;
                            f45242d = System.currentTimeMillis();
                            String str = f45241c;
                            if (TextUtils.isEmpty(str)) {
                                a2.f45118b.putString("p_s_a_i_t", "");
                                a2.f45118b.commit();
                            } else {
                                a2.f45118b.putString("p_s_a_i_t", new String(Base64.encode(g.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), str.getBytes("UTF-8"), true), 10), "UTF-8"));
                                a2.f45118b.commit();
                            }
                            a2.f(f45242d);
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            f45242d = currentTimeMillis;
                            a2.f(currentTimeMillis);
                        }
                        return f45241c;
                    }
                } catch (Throwable unused) {
                    c.a();
                    return "";
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            if (context != null) {
                try {
                    if (x && t.a(context)) {
                        if (System.currentTimeMillis() - f45248j < 86400000) {
                            return f45247i;
                        }
                        com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
                        if (TextUtils.isEmpty(f45247i)) {
                            f45247i = a2.B();
                            f45248j = a2.f45117a.getLong("p_s_o_d_t_t", 0L);
                            if (System.currentTimeMillis() - f45248j < 86400000) {
                                return f45247i;
                            }
                        }
                        if (!n(context)) {
                            return f45247i;
                        }
                        String b2 = com.baidu.sofire.j.a.a().b();
                        if (!TextUtils.isEmpty(b2)) {
                            f45247i = b2;
                            f45248j = System.currentTimeMillis();
                            String str = f45247i;
                            if (TextUtils.isEmpty(str)) {
                                a2.f45118b.putString("p_s_o_d_t", "");
                                a2.f45118b.commit();
                            } else {
                                try {
                                    a2.f45118b.putString("p_s_o_d_t", new String(Base64.encode(g.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), str.getBytes("UTF-8"), true), 10), "UTF-8"));
                                    a2.f45118b.commit();
                                } catch (Throwable unused) {
                                    c.a();
                                }
                            }
                            a2.i(f45248j);
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            f45248j = currentTimeMillis;
                            a2.i(currentTimeMillis);
                        }
                        return f45247i;
                    }
                } catch (Throwable unused2) {
                    c.a();
                    return "";
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            if (context != null) {
                try {
                    if (u && t.a(context)) {
                        if (System.currentTimeMillis() - l < 86400000) {
                            return k;
                        }
                        com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
                        if (TextUtils.isEmpty(k)) {
                            k = a2.C();
                            l = a2.f45117a.getLong("p_s_s_o_t_t", 0L);
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
                                a2.f45118b.putString("p_s_s_o_t", "");
                                a2.f45118b.commit();
                            } else {
                                a2.f45118b.putString("p_s_s_o_t", new String(Base64.encode(g.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), str.getBytes("UTF-8"), true), 10), "UTF-8"));
                                a2.f45118b.commit();
                            }
                            a2.j(l);
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            l = currentTimeMillis;
                            a2.j(currentTimeMillis);
                        }
                        return k;
                    }
                } catch (Throwable unused) {
                    c.a();
                    return "";
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            if (context != null) {
                try {
                    if (v && t.a(context)) {
                        if (System.currentTimeMillis() - n < 86400000) {
                            return m;
                        }
                        com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
                        if (TextUtils.isEmpty(m)) {
                            m = a2.D();
                            n = a2.f45117a.getLong("p_s_n_o_t_t", 0L);
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
                                a2.f45118b.putString("p_s_n_o_t", "");
                                a2.f45118b.commit();
                            } else {
                                a2.f45118b.putString("p_s_n_o_t", new String(Base64.encode(g.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), str.getBytes("UTF-8"), true), 10), "UTF-8"));
                                a2.f45118b.commit();
                            }
                            a2.k(n);
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            n = currentTimeMillis;
                            a2.k(currentTimeMillis);
                        }
                        return m;
                    }
                } catch (Throwable unused) {
                    c.a();
                    return "";
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static boolean m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            if (context == null) {
                return false;
            }
            return w || n(context);
        }
        return invokeL.booleanValue;
    }

    public static boolean n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
            if (System.currentTimeMillis() - A < 1000) {
                return z;
            }
            z = p(context) && q(context);
            A = System.currentTimeMillis();
            return z;
        }
        return invokeL.booleanValue;
    }

    public static boolean o(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) ? t.a(context) && n(context) : invokeL.booleanValue;
    }

    public static boolean p(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) {
            try {
                return ((PowerManager) context.getSystemService("power")).isScreenOn();
            } catch (Throwable unused) {
                c.a();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, context)) == null) {
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
        return invokeL.booleanValue;
    }

    public static boolean r(Context context) {
        InterceptResult invokeL;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, context)) == null) {
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
        return invokeL.booleanValue;
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (s.class) {
                if (context == null) {
                    return;
                }
                try {
                    if (y) {
                        return;
                    }
                    y = true;
                    a(new JSONObject(com.baidu.sofire.h.a.a(context).f45117a.getString("p_s_p_c", "")));
                } catch (Throwable unused) {
                    c.a();
                }
            }
        }
    }

    public static void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, jSONObject) == null) || jSONObject == null) {
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
