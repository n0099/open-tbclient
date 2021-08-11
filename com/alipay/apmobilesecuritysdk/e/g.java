package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized String a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, str)) == null) {
            synchronized (g.class) {
                String a2 = com.alipay.security.mobile.module.c.e.a(context, "openapi_file_pri", "openApi" + str, "");
                if (com.alipay.security.mobile.module.a.a.a(a2)) {
                    return "";
                }
                String b2 = com.alipay.security.mobile.module.a.a.c.b(com.alipay.security.mobile.module.a.a.c.a(), a2);
                return com.alipay.security.mobile.module.a.a.a(b2) ? "" : b2;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            synchronized (g.class) {
            }
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            synchronized (g.class) {
                SharedPreferences.Editor edit = context.getSharedPreferences("openapi_file_pri", 0).edit();
                if (edit != null) {
                    edit.clear();
                    edit.commit();
                }
            }
        }
    }

    public static synchronized void a(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, context, str, str2) == null) {
            synchronized (g.class) {
                try {
                    SharedPreferences.Editor edit = context.getSharedPreferences("openapi_file_pri", 0).edit();
                    if (edit != null) {
                        edit.putString("openApi" + str, com.alipay.security.mobile.module.a.a.c.a(com.alipay.security.mobile.module.a.a.c.a(), str2));
                        edit.commit();
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }
}
