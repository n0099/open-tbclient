package com.baidu.sofire.k;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sofire.ac.DeviceInfoCallback;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Arrays;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class m {
    public static /* synthetic */ Interceptable $ic = null;
    public static DeviceInfoCallback a = null;
    public static String b = null;
    public static long c = 0;
    public static String d = null;
    public static long e = 0;
    public static String f = null;
    public static long g = 0;
    public static String h = null;
    public static long i = 0;
    public static boolean j = true;
    public static boolean k = true;
    public static boolean l = true;
    public static boolean m = true;
    public static boolean n = true;
    public static boolean o = true;
    public static boolean p = true;
    public static boolean q;
    public static boolean r;
    public static long s;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, jSONObject) == null) {
            p = jSONObject.optInt("0", 1) != 0;
            JSONArray optJSONArray = jSONObject.optJSONArray("1");
            if (optJSONArray == null) {
                return;
            }
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                hashSet.add(Integer.valueOf(optJSONArray.optInt(i2)));
            }
            if (hashSet.contains(27)) {
                j = false;
            } else {
                j = true;
            }
            hashSet.contains(34);
            if (hashSet.contains(40)) {
                k = false;
            } else {
                k = true;
            }
            hashSet.contains(41);
            if (hashSet.contains(42)) {
                l = false;
            } else {
                l = true;
            }
            if (hashSet.contains(43)) {
                n = false;
            } else {
                n = true;
            }
            if (hashSet.contains(44)) {
                m = false;
            } else {
                m = true;
            }
            if (hashSet.contains(45)) {
                o = false;
            } else {
                o = true;
            }
            hashSet.contains(46);
        }
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? context != null && m && d(context) : invokeL.booleanValue;
    }

    public static boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? context != null && l && d(context) : invokeL.booleanValue;
    }

    public static boolean d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? n.a(context) && e(context) : invokeL.booleanValue;
    }

    public static boolean e(Context context) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (System.currentTimeMillis() - s < 1000) {
                return r;
            }
            boolean z2 = false;
            try {
                z = ((PowerManager) context.getSystemService("power")).isScreenOn();
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
                z = false;
            }
            if (z && j(context)) {
                z2 = true;
            }
            r = z2;
            s = System.currentTimeMillis();
            return r;
        }
        return invokeL.booleanValue;
    }

    public static String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            if (context != null) {
                try {
                    if (k && n.a(context)) {
                        if (System.currentTimeMillis() - e < 86400000) {
                            return d;
                        }
                        com.baidu.sofire.j.a a2 = com.baidu.sofire.j.a.a(context);
                        if (TextUtils.isEmpty(d)) {
                            String string = a2.a.getString("p_s_a_i_t", "");
                            d = TextUtils.isEmpty(string) ? "" : new String(e.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10), true), "UTF-8");
                            e = a2.a.getLong("p_s_a_i_t_t", 0L);
                            if (System.currentTimeMillis() - e < 86400000) {
                                return d;
                            }
                        }
                        if (!e(context)) {
                            return d;
                        }
                        String string2 = Settings.Secure.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
                        if (!TextUtils.isEmpty(string2)) {
                            d = string2;
                            e = System.currentTimeMillis();
                            a2.b(d);
                            a2.a(e);
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            e = currentTimeMillis;
                            a2.a(currentTimeMillis);
                        }
                        return d;
                    }
                } catch (Throwable unused) {
                    int i2 = com.baidu.sofire.a.b.a;
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            try {
                if (m && n.a(context)) {
                    if (System.currentTimeMillis() - i < 86400000) {
                        return h;
                    }
                    com.baidu.sofire.j.a a2 = com.baidu.sofire.j.a.a(context);
                    if (TextUtils.isEmpty(h)) {
                        String string = a2.a.getString("p_s_e_c_t", "");
                        h = TextUtils.isEmpty(string) ? "" : new String(e.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10), true), "UTF-8");
                        i = a2.a.getLong("p_s_e_c_t_t", 0L);
                        if (System.currentTimeMillis() - i < 86400000) {
                            return h;
                        }
                    }
                    if (!(context.checkPermission(com.kuaishou.weapon.p0.h.i, Process.myPid(), Process.myUid()) != -1)) {
                        return h;
                    }
                    if (!e(context)) {
                        return h;
                    }
                    String b2 = c.b(context);
                    if (!TextUtils.isEmpty(b2)) {
                        h = b2;
                        i = System.currentTimeMillis();
                        a2.c(h);
                        a2.b(i);
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        i = currentTimeMillis;
                        a2.b(currentTimeMillis);
                    }
                    return h;
                }
                return "";
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            if (context != null) {
                try {
                    if (j && n.a(context)) {
                        if (System.currentTimeMillis() - c < 86400000) {
                            return b;
                        }
                        if ("com.baidu.input_huawei".equals(context.getPackageName())) {
                            return "";
                        }
                        com.baidu.sofire.j.a a2 = com.baidu.sofire.j.a.a(context);
                        if (TextUtils.isEmpty(b)) {
                            String string = a2.a.getString("p_s_i_t", "");
                            b = TextUtils.isEmpty(string) ? "" : new String(e.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10), true), "UTF-8");
                            c = a2.a.getLong("p_s_i_t_t", 0L);
                            if (System.currentTimeMillis() - c < 86400000) {
                                return b;
                            }
                        }
                        if (!(context.checkPermission(com.kuaishou.weapon.p0.h.c, Process.myPid(), Process.myUid()) != -1)) {
                            return b;
                        }
                        if (!e(context)) {
                            return b;
                        }
                        String deviceId = Build.VERSION.SDK_INT < 29 ? ((TelephonyManager) context.getSystemService("phone")).getDeviceId() : "";
                        if (!TextUtils.isEmpty(deviceId)) {
                            b = deviceId;
                            c = System.currentTimeMillis();
                            a2.e(b);
                            a2.c(c);
                        } else {
                            long currentTimeMillis = System.currentTimeMillis();
                            c = currentTimeMillis;
                            a2.c(currentTimeMillis);
                        }
                        return b;
                    }
                } catch (Throwable unused) {
                    int i2 = com.baidu.sofire.a.b.a;
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            try {
                if (l && n.a(context)) {
                    if (System.currentTimeMillis() - g < 86400000) {
                        return f;
                    }
                    com.baidu.sofire.j.a a2 = com.baidu.sofire.j.a.a(context);
                    if (TextUtils.isEmpty(h)) {
                        String string = a2.a.getString("p_s_s_c_t", "");
                        f = TextUtils.isEmpty(string) ? "" : new String(e.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10), true), "UTF-8");
                        g = a2.a.getLong("p_s_s_c_t_t", 0L);
                        if (System.currentTimeMillis() - g < 86400000) {
                            return f;
                        }
                    }
                    if (!e(context)) {
                        return f;
                    }
                    String c2 = c.c(context);
                    if (!TextUtils.isEmpty(c2)) {
                        f = c2;
                        g = System.currentTimeMillis();
                        a2.g(f);
                        a2.d(g);
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        g = currentTimeMillis;
                        a2.d(currentTimeMillis);
                    }
                    return f;
                }
                return "";
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean j(Context context) {
        InterceptResult invokeL;
        String[] strArr;
        ActivityManager.RunningTaskInfo runningTaskInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            try {
            } catch (Throwable unused) {
                int i2 = com.baidu.sofire.a.b.a;
            }
            if (Build.VERSION.SDK_INT < 21) {
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                if (activityManager.getRunningTasks(1) != null && (runningTaskInfo = activityManager.getRunningTasks(1).get(0)) != null) {
                    return context.getPackageName().equals(runningTaskInfo.topActivity.getPackageName());
                }
                return false;
            }
            if (context != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                    if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.importanceReasonCode == 0 && (strArr = runningAppProcessInfo.pkgList) != null && strArr.length != 0 && Arrays.asList(strArr).contains(context.getPackageName())) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, context) == null) {
            synchronized (m.class) {
                if (context == null) {
                    return;
                }
                try {
                } catch (Throwable unused) {
                    int i2 = com.baidu.sofire.a.b.a;
                }
                if (q) {
                    return;
                }
                q = true;
                a(new JSONObject(com.baidu.sofire.j.a.a(context).a.getString("p_s_p_c", "")));
            }
        }
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context == null) {
                return false;
            }
            return p || e(context);
        }
        return invokeL.booleanValue;
    }
}
