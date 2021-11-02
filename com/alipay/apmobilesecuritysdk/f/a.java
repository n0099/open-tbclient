package com.alipay.apmobilesecuritysdk.f;

import android.content.Context;
import android.os.Environment;
import androidx.core.view.InputDeviceCompat;
import com.alipay.security.mobile.module.c.e;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes6.dex */
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
            if (context == null || com.alipay.security.mobile.module.a.a.a(str)) {
                return null;
            }
            if (!com.alipay.security.mobile.module.a.a.a(str2)) {
                try {
                    a2 = e.a(context, str, str2, "");
                    if (com.alipay.security.mobile.module.a.a.a(a2)) {
                        return null;
                    }
                } catch (Throwable unused) {
                    return null;
                }
            }
            return com.alipay.security.mobile.module.a.a.c.b(com.alipay.security.mobile.module.a.a.c.a(), a2);
        }
        return (String) invokeLLL.objValue;
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            synchronized (a.class) {
                if (com.alipay.security.mobile.module.a.a.a(str) || com.alipay.security.mobile.module.a.a.a(str2)) {
                    return null;
                }
                String a2 = com.alipay.security.mobile.module.c.b.a(str);
                if (com.alipay.security.mobile.module.a.a.a(a2)) {
                    return null;
                }
                String string = new JSONObject(a2).getString(str2);
                if (com.alipay.security.mobile.module.a.a.a(string)) {
                    return null;
                }
                return com.alipay.security.mobile.module.a.a.c.b(com.alipay.security.mobile.module.a.a.c.a(), string);
            }
        }
        return (String) invokeLL.objValue;
    }

    public static void a(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65539, null, context, str, str2, str3) == null) && !com.alipay.security.mobile.module.a.a.a(str) && !com.alipay.security.mobile.module.a.a.a(str2) && context != null) {
            try {
                String a2 = com.alipay.security.mobile.module.a.a.c.a(com.alipay.security.mobile.module.a.a.c.a(), str3);
                HashMap hashMap = new HashMap();
                hashMap.put(str2, a2);
                e.a(context, str, hashMap);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX DEBUG: Throwable added to exception handler: 'Exception', keep only Throwable */
    public static void a(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, str3) == null) {
            synchronized (a.class) {
                if (com.alipay.security.mobile.module.a.a.a(str) || com.alipay.security.mobile.module.a.a.a(str2)) {
                    return;
                }
                try {
                    String a2 = com.alipay.security.mobile.module.c.b.a(str);
                    JSONObject jSONObject = new JSONObject();
                    if (com.alipay.security.mobile.module.a.a.b(a2)) {
                        try {
                            jSONObject = new JSONObject(a2);
                        } catch (Exception unused) {
                            jSONObject = new JSONObject();
                        }
                    }
                    jSONObject.put(str2, com.alipay.security.mobile.module.a.a.c.a(com.alipay.security.mobile.module.a.a.c.a(), str3));
                    jSONObject.toString();
                    try {
                        System.clearProperty(str);
                    } catch (Throwable unused2) {
                    }
                    if (com.alipay.security.mobile.module.c.c.a()) {
                        String str4 = ".SystemConfig" + File.separator + str;
                        if (com.alipay.security.mobile.module.c.c.a()) {
                            File file = new File(Environment.getExternalStorageDirectory(), str4);
                            if (file.exists() && file.isFile()) {
                                file.delete();
                            }
                        }
                    }
                } catch (Throwable unused3) {
                }
            }
        }
    }
}
