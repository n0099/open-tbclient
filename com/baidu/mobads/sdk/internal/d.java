package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.am;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(197698755, "Lcom/baidu/mobads/sdk/internal/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(197698755, "Lcom/baidu/mobads/sdk/internal/d;");
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (d.class) {
                    if (a == null) {
                        a = new d();
                    }
                }
            }
            return a;
        }
        return (d) invokeV.objValue;
    }

    public DexClassLoader a(String str, String str2, String str3, ClassLoader classLoader) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, str, str2, str3, classLoader)) == null) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    file.setReadOnly();
                    return new DexClassLoader(str, str2, str3, classLoader);
                }
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (DexClassLoader) invokeLLLL.objValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException | NullPointerException unused) {
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public void a(double d, am.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Double.valueOf(d), bVar}) == null) {
            co a2 = co.a();
            String c = a2.c(w.a);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("v", "" + d);
            hashMap.put("os", "android");
            hashMap.put("tp", a(bj.a((Context) null).d()));
            hashMap.put("bdr", a(bj.a((Context) null).b()));
            am amVar = new am(a2.a(c, hashMap));
            amVar.a(bVar);
            amVar.b();
        }
    }
}
