package com.baidu.android.pushservice.g;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.PrintWriter;
import java.io.StringWriter;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, th)) == null) {
            if (th == null) {
                return "";
            }
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            printWriter.close();
            return stringWriter.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void a(String str, String str2, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65537, null, str, str2, context) == null) && PushSettings.e(context) && str2 != null) {
            String str3 = "BDPushSDK-" + str;
        }
    }

    public static void a(String str, Throwable th, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, th, context) == null) {
            b(str, a(th), context);
        }
    }

    public static void b(String str, String str2, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, str, str2, context) == null) && PushSettings.e(context) && str2 != null) {
            String str3 = "BDPushSDK-" + str;
        }
    }

    public static void c(String str, String str2, Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, context) == null) && PushSettings.e(context) && str2 != null) {
            String str3 = "BDPushSDK-" + str;
        }
    }
}
