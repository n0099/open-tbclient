package com.baidu.sofire.utility;

import android.content.Context;
import android.os.Build;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class v {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f45486a = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1443541929, "Lcom/baidu/sofire/utility/v;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1443541929, "Lcom/baidu/sofire/utility/v;");
        }
    }

    public static void a(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65537, null, context, z) == null) || context == null) {
            return;
        }
        f45486a = z ? 1 : 2;
        c.a(context, ".ffnpp", !z ? 1 : 0);
        if (context != null) {
            com.baidu.sofire.h.a a2 = com.baidu.sofire.h.a.a(context);
            a2.f45343d.putBoolean("s_a_pl", z);
            if (Build.VERSION.SDK_INT >= 9) {
                a2.f45343d.apply();
            } else {
                a2.f45343d.commit();
            }
        }
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null) {
                return false;
            }
            int a2 = c.a(context);
            if (a2 == 1 && (i2 = f45486a) != -1) {
                return i2 == 1;
            }
            boolean z = com.baidu.sofire.h.a.a(context).f45342c.getBoolean("s_a_pl", false);
            boolean z2 = !c.b(context, ".ffnpp");
            if (z && !z2 && a2 == 1) {
                c.a(context, ".ffnpp", 0);
                z2 = true;
            }
            if (a2 == 1) {
                if (z2) {
                    f45486a = 1;
                } else {
                    f45486a = 2;
                }
            }
            return z2;
        }
        return invokeL.booleanValue;
    }
}
