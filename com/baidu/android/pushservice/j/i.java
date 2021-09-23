package com.baidu.android.pushservice.j;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, str)) == null) ? context.getSharedPreferences("pst", 0).getString(str, "") : (String) invokeLL.objValue;
    }

    public static void a(Context context, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65537, null, context, str, i2) == null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("pst", 0).edit();
                edit.putInt(str, i2);
                edit.commit();
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
            }
        }
    }

    public static void a(Context context, String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, str, Long.valueOf(j2)}) == null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("pst", 0).edit();
                edit.putLong(str, j2);
                edit.commit();
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, long j2, String str6, String str7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, str, str2, str3, str4, str5, Long.valueOf(j2), str6, str7}) == null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("com.baidu.pushservice.BIND_CACHE", 0).edit();
                if (j2 != 0) {
                    edit.putLong("currbindtime", j2);
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
                m.f37691a = 1;
                edit.putLong("version_code", m.c(context, context.getPackageName()));
                edit.apply();
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
            }
        }
    }

    public static boolean a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, str2)) == null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("pst", 0).edit();
                edit.putString(str, str2);
                edit.commit();
                return true;
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public static int b(Context context, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(AdIconUtil.AD_TEXT_ID, null, context, str, i2)) == null) ? context.getSharedPreferences("pst", 0).getInt(str, i2) : invokeLLI.intValue;
    }

    public static long b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str)) == null) ? context.getSharedPreferences("pst", 0).getLong(str, 0L) : invokeLL.longValue;
    }

    public static void b(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, context, str, str2) == null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("pst", 0).edit();
                edit.putString(str, str2);
                edit.apply();
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
            }
        }
    }

    public static String c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) ? context.getSharedPreferences("pst_bdservice_v1", 0).getString(str, "") : (String) invokeLL.objValue;
    }

    public static void c(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, context, str, str2) == null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("pst_bdservice_v1", 0).edit();
                edit.putString(str, str2);
                edit.apply();
            } catch (Exception e2) {
                new b.c(context).a(Log.getStackTraceString(e2)).a();
            }
        }
    }
}
