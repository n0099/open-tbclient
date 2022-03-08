package com.alipay.apmobilesecuritysdk.c;

import android.content.Context;
import android.os.Build;
import com.alipay.security.mobile.module.d.d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/* loaded from: classes3.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized void a(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65536, null, context, str, str2, str3) == null) {
            synchronized (a.class) {
                com.alipay.security.mobile.module.d.a b2 = b(context, str, str2, str3);
                d.a(context.getFilesDir().getAbsolutePath() + "/log/ap", new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()) + ".log", b2.toString());
            }
        }
    }

    public static synchronized void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            synchronized (a.class) {
                d.a(str);
            }
        }
    }

    public static synchronized void a(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, th) == null) {
            synchronized (a.class) {
                d.a(th);
            }
        }
    }

    public static com.alipay.security.mobile.module.d.a b(Context context, String str, String str2, String str3) {
        String str4;
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, context, str, str2, str3)) == null) {
            try {
                str4 = context.getPackageName();
            } catch (Throwable unused) {
                str4 = "";
            }
            return new com.alipay.security.mobile.module.d.a(Build.MODEL, str4, "APPSecuritySDK-ALIPAYSDK", "3.4.0.201910161639", str, str2, str3);
        }
        return (com.alipay.security.mobile.module.d.a) invokeLLLL.objValue;
    }
}
