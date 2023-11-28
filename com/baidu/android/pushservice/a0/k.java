package com.baidu.android.pushservice.a0;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kuaishou.weapon.p0.t;
/* loaded from: classes.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(483530670, "Lcom/baidu/android/pushservice/a0/k;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(483530670, "Lcom/baidu/android/pushservice/a0/k;");
        }
    }

    public static int a(Context context, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65537, null, context, str, i)) == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("pst_bdservice_v1", 0);
            return sharedPreferences.contains(str) ? sharedPreferences.getInt(str, i) : context.getSharedPreferences(t.s, 0).getInt(str, i);
        }
        return invokeLLI.intValue;
    }

    public static long a(Context context, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, str, Long.valueOf(j)})) == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("pst_bdservice_v1", 0);
            return sharedPreferences.contains(str) ? sharedPreferences.getLong(str, j) : context.getSharedPreferences(t.s, 0).getLong(str, j);
        }
        return invokeCommon.longValue;
    }

    public static void a(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, context, str, str2) == null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("pst_bdservice_v1", 0).edit();
                edit.putString(str, str2);
                edit.commit();
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            return context.getSharedPreferences("pst_bdservice_v1", 0).contains(str) || context.getSharedPreferences(t.s, 0).contains(str);
        }
        return invokeLL.booleanValue;
    }

    public static int b(Context context, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65541, null, context, str, i)) == null) ? context.getSharedPreferences("pst_bdservice_v1", 0).getInt(str, i) : invokeLLI.intValue;
    }

    public static String b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) ? context.getSharedPreferences("pst_bdservice_v1", 0).getString(str, "") : (String) invokeLL.objValue;
    }

    public static void b(Context context, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{context, str, Long.valueOf(j)}) == null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("pst_bdservice_v1", 0).edit();
                edit.putLong(str, j);
                edit.commit();
            } catch (Exception unused) {
            }
        }
    }

    public static void c(Context context, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65544, null, context, str, i) == null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("pst_bdservice_v1", 0).edit();
                edit.putInt(str, i);
                edit.commit();
            } catch (Exception unused) {
            }
        }
    }
}
