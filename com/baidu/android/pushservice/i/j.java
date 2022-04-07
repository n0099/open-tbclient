package com.baidu.android.pushservice.i;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) ? context.getSharedPreferences("push_client_self_info", 4).getLong("token_save_time", System.currentTimeMillis()) : invokeL.longValue;
    }

    public static synchronized void a(Context context, int i, String str) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putString;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65537, null, context, i, str) == null) {
            synchronized (j.class) {
                try {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("push_client_self_info", 4);
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
                            putString = edit.putString("bd_use_huawei_token", str);
                        } else if (i == 6) {
                            putString = edit.putString("bd_use_xiaomi_regid", str);
                        } else if (i == 7) {
                            putString = edit.putString("bd_use_meizu_pushid", str);
                        } else if (i != 9) {
                            edit.putLong("token_save_time", System.currentTimeMillis()).commit();
                        } else {
                            putString = edit.putString("bd_use_vivo_regid", str);
                        }
                        putString.commit();
                        edit.putLong("token_save_time", System.currentTimeMillis()).commit();
                    }
                } catch (Exception e) {
                    new b.c(context).a(Log.getStackTraceString(e)).a();
                }
            }
        }
    }

    public static void a(Context context, String str, boolean z) {
        SharedPreferences.Editor edit;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65538, null, context, str, z) == null) {
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
            } catch (Exception e) {
                new b.c(context).a(Log.getStackTraceString(e)).a();
            }
        }
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? context.getSharedPreferences("push_client_self_info", 4).getString("bd_use_huawei_token", null) : (String) invokeL.objValue;
    }

    public static boolean b(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, z)) == null) ? context.getSharedPreferences("push_client_self_info", 4).getBoolean(str, z) : invokeLLZ.booleanValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) ? context.getSharedPreferences("push_client_self_info", 4).getString("bd_use_xiaomi_regid", null) : (String) invokeL.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) ? context.getSharedPreferences("push_client_self_info", 4).getString("bd_use_meizu_pushid", null) : (String) invokeL.objValue;
    }
}
