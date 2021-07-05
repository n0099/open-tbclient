package com.alipay.security.mobile.module.b;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String a(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, context, str, str2)) == null) {
            synchronized (a.class) {
                String str3 = null;
                if (context != null) {
                    if (!com.alipay.security.mobile.module.a.a.a(str) && !com.alipay.security.mobile.module.a.a.a(str2)) {
                        try {
                            a2 = e.a(context, str, str2, "");
                        } catch (Throwable unused) {
                        }
                        if (com.alipay.security.mobile.module.a.a.a(a2)) {
                            return null;
                        }
                        str3 = com.alipay.security.mobile.module.a.a.c.b(com.alipay.security.mobile.module.a.a.c.a(), a2);
                        return str3;
                    }
                }
                return null;
            }
        }
        return (String) invokeLLL.objValue;
    }

    public static void a(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, context, str, str2, str3) == null) {
            synchronized (a.class) {
                if (com.alipay.security.mobile.module.a.a.a(str) || com.alipay.security.mobile.module.a.a.a(str2) || context == null) {
                    return;
                }
                try {
                    String a2 = com.alipay.security.mobile.module.a.a.c.a(com.alipay.security.mobile.module.a.a.c.a(), str3);
                    HashMap hashMap = new HashMap();
                    hashMap.put(str2, a2);
                    e.a(context, str, hashMap);
                } catch (Throwable unused) {
                }
            }
        }
    }
}
