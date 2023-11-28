package com.baidu.android.pushservice.a0;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) ? context.getSharedPreferences("push_client_self_info", 4).getString("bd_use_honor_regid", null) : (String) invokeL.objValue;
    }

    public static synchronized void a(Context context, int i, String str) {
        SharedPreferences.Editor edit;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65537, null, context, i, str) == null) {
            synchronized (j.class) {
                try {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("push_client_self_info", 0);
                    int i2 = 5;
                    do {
                        edit = sharedPreferences.edit();
                        i2--;
                        if (edit != null) {
                            break;
                        }
                    } while (i2 > 0);
                    if (edit != null) {
                        if (i == 5) {
                            str2 = "bd_use_huawei_token";
                        } else if (i == 6) {
                            str2 = "bd_use_xiaomi_regid";
                        } else if (i == 7) {
                            str2 = "bd_use_meizu_pushid";
                        } else if (i != 9) {
                            if (i == 10) {
                                edit.putString("bd_use_honor_regid", str).commit();
                            }
                            edit.putLong("token_save_time", System.currentTimeMillis()).apply();
                        } else {
                            str2 = "bd_use_vivo_regid";
                        }
                        edit.putString(str2, str).apply();
                        edit.putLong("token_save_time", System.currentTimeMillis()).apply();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public static boolean a(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, context, str, z)) == null) ? context.getSharedPreferences("push_client_self_info", 4).getBoolean(str, z) : invokeLLZ.booleanValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? context.getSharedPreferences("push_client_self_info", 4).getString("bd_use_huawei_token", null) : (String) invokeL.objValue;
    }

    public static void b(Context context, String str, boolean z) {
        SharedPreferences.Editor edit;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, z) == null) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("push_client_self_info", 4);
                int i = 2;
                do {
                    edit = sharedPreferences.edit();
                    i--;
                    if (edit != null) {
                        break;
                    }
                } while (i > 0);
                if (edit != null) {
                    edit.putBoolean(str, z).commit();
                }
            } catch (Exception unused) {
            }
        }
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) ? context.getSharedPreferences("push_client_self_info", 4).getString("bd_use_meizu_pushid", null) : (String) invokeL.objValue;
    }

    public static long d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) ? context.getSharedPreferences("push_client_self_info", 4).getLong("token_save_time", System.currentTimeMillis()) : invokeL.longValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) ? context.getSharedPreferences("push_client_self_info", 4).getString("bd_use_xiaomi_regid", null) : (String) invokeL.objValue;
    }

    public static boolean f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) ? context.getSharedPreferences("push_client_self_info", 4).contains("token_save_time") && com.baidu.android.pushservice.l.d.i(context).b() != 0 : invokeL.booleanValue;
    }
}
