package com.baidu.android.pushservice.i;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kuaishou.weapon.p0.C0400;
/* loaded from: classes.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long a(Context context, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{context, str, Long.valueOf(j)})) == null) ? context.getSharedPreferences(C0400.f426, 0).getLong(str, j) : invokeCommon.longValue;
    }

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) ? context.getSharedPreferences(C0400.f426, 0).getString(str, "") : (String) invokeLL.objValue;
    }

    public static void a(Context context, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65538, null, context, str, i) == null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences(C0400.f426, 0).edit();
                edit.putInt(str, i);
                edit.commit();
            } catch (Exception e) {
                new b.c(context).a(Log.getStackTraceString(e)).a();
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, long j, String str6, String str7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, str, str2, str3, str4, str5, Long.valueOf(j), str6, str7}) == null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).edit();
                if (j != 0) {
                    edit.putLong("currbindtime", j);
                }
                if (!TextUtils.isEmpty(str6)) {
                    edit.putString("access_token", str6);
                }
                if (!TextUtils.isEmpty(str7)) {
                    edit.putString("secret_key", str7);
                }
                edit.putString("appid", str);
                edit.putString("channel_id", str2);
                if (!TextUtils.isEmpty(str3)) {
                    edit.putString("new_channel_id", str3);
                }
                edit.putString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, str4);
                edit.putString("user_id", str5);
                edit.putBoolean("bind_status", true);
                m.a = 1;
                edit.putLong("version_code", m.c(context, context.getPackageName()));
                edit.apply();
            } catch (Exception e) {
                new b.c(context).a(Log.getStackTraceString(e)).a();
            }
        }
    }

    public static boolean a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, str2)) == null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences(C0400.f426, 0).edit();
                edit.putString(str, str2);
                edit.commit();
                return true;
            } catch (Exception e) {
                new b.c(context).a(Log.getStackTraceString(e)).a();
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static int b(Context context, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65541, null, context, str, i)) == null) ? context.getSharedPreferences(C0400.f426, 0).getInt(str, i) : invokeLLI.intValue;
    }

    public static long b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) ? context.getSharedPreferences(C0400.f426, 0).getLong(str, 0L) : invokeLL.longValue;
    }

    public static void b(Context context, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{context, str, Long.valueOf(j)}) == null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences(C0400.f426, 0).edit();
                edit.putLong(str, j);
                edit.commit();
            } catch (Exception e) {
                new b.c(context).a(Log.getStackTraceString(e)).a();
            }
        }
    }

    public static void b(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, context, str, str2) == null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences(C0400.f426, 0).edit();
                edit.putString(str, str2);
                edit.apply();
            } catch (Exception e) {
                new b.c(context).a(Log.getStackTraceString(e)).a();
            }
        }
    }

    public static String c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, context, str)) == null) ? context.getSharedPreferences("pst_bdservice_v1", 0).getString(str, "") : (String) invokeLL.objValue;
    }

    public static void c(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, context, str, str2) == null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("pst_bdservice_v1", 0).edit();
                edit.putString(str, str2);
                edit.apply();
            } catch (Exception e) {
                new b.c(context).a(Log.getStackTraceString(e)).a();
            }
        }
    }
}
