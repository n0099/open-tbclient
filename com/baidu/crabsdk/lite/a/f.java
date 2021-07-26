package com.baidu.crabsdk.lite.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Intent f4747a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1349355025, "Lcom/baidu/crabsdk/lite/a/f;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1349355025, "Lcom/baidu/crabsdk/lite/a/f;");
        }
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Object[] objArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (com.baidu.crabsdk.lite.b.c.g() < 5) {
                return "N/A";
            }
            StringBuilder sb = new StringBuilder();
            try {
                for (Object obj : (Object[]) PackageManager.class.getMethod("getSystemAvailableFeatures", null).invoke(context.getPackageManager(), new Object[0])) {
                    String str = (String) obj.getClass().getField("name").get(obj);
                    if (str != null) {
                        sb.append(str);
                    } else {
                        sb.append("glEsVersion = ");
                        sb.append((String) obj.getClass().getMethod("getGlEsVersion", null).invoke(obj, new Object[0]));
                    }
                    sb.append("\n");
                }
            } catch (Throwable unused) {
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void b(String str, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, str, context) == null) && f4747a == null && context != null) {
            try {
                f4747a = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                com.baidu.crabsdk.lite.b.a.c(str, "Battery Broadcast Regist Success");
            } catch (Exception e2) {
                com.baidu.crabsdk.lite.b.a.e(str, "Register Battery Error!", e2);
            }
        }
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            Intent intent = f4747a;
            if (intent == null) {
                return "N/A";
            }
            try {
                float intExtra = (intent.getIntExtra("level", 0) * 100.0f) / f4747a.getIntExtra("scale", 100);
                return ((int) intExtra) + "%";
            } catch (Exception e2) {
                com.baidu.crabsdk.lite.b.a.e(str, "Get Battery Error!", e2);
                return "N/A";
            }
        }
        return (String) invokeL.objValue;
    }
}
