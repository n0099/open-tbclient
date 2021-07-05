package com.baidu.crabsdk.lite.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public final class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static SharedPreferences f4709a;

    /* renamed from: b  reason: collision with root package name */
    public static SharedPreferences.Editor f4710b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1349355211, "Lcom/baidu/crabsdk/lite/a/l;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1349355211, "Lcom/baidu/crabsdk/lite/a/l;");
        }
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            if (f4709a == null) {
                f4709a = context.getSharedPreferences("crablite_app_life", 0);
            }
            if (f4710b == null) {
                f4710b = f4709a.edit();
            }
        }
    }

    public static void b(String str) {
        SharedPreferences.Editor editor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, str) == null) || (editor = f4710b) == null) {
            return;
        }
        editor.putInt("used_count_" + str, 0);
        com.baidu.crabsdk.lite.b.c.c(f4710b, false);
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            SharedPreferences.Editor editor = f4710b;
            editor.putInt("used_count_" + str, d(str) + 1);
            com.baidu.crabsdk.lite.b.c.c(f4710b, false);
        }
    }

    public static int d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65540, null, str)) == null) {
            SharedPreferences sharedPreferences = f4709a;
            return sharedPreferences.getInt("used_count_" + str, 0);
        }
        return invokeL.intValue;
    }
}
