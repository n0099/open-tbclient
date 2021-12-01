package com.alipay.sdk.util;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1255003008, "Lcom/alipay/sdk/util/h;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1255003008, "Lcom/alipay/sdk/util/h;");
        }
    }

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static synchronized boolean a(Context context, String str) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            synchronized (h.class) {
                try {
                    z = PreferenceManager.getDefaultSharedPreferences(context).contains(str);
                } catch (Throwable th) {
                    c.a(th);
                    z = false;
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static synchronized void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, context, str) == null) {
            synchronized (h.class) {
                try {
                    PreferenceManager.getDefaultSharedPreferences(context).edit().remove(str).apply();
                } catch (Throwable th) {
                    c.a(th);
                }
            }
        }
    }

    public static synchronized String a(com.alipay.sdk.sys.a aVar, Context context, String str, String str2) {
        InterceptResult invokeLLLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, aVar, context, str, str2)) == null) {
            synchronized (h.class) {
                try {
                    String string = PreferenceManager.getDefaultSharedPreferences(context).getString(str, str2);
                    str3 = TextUtils.isEmpty(string) ? null : com.alipay.sdk.encrypt.e.a(a(context), string, str);
                    if (!TextUtils.isEmpty(string) && TextUtils.isEmpty(str3)) {
                        com.alipay.sdk.app.statistic.a.b(aVar, com.alipay.sdk.app.statistic.b.m, com.alipay.sdk.app.statistic.b.J, String.format("%s,%s", str, string));
                    }
                } catch (Exception e2) {
                    c.a(e2);
                }
            }
            return str3;
        }
        return (String) invokeLLLL.objValue;
    }

    public static synchronized void b(com.alipay.sdk.sys.a aVar, Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65542, null, aVar, context, str, str2) == null) {
            synchronized (h.class) {
                try {
                    String b2 = com.alipay.sdk.encrypt.e.b(a(context), str2, str);
                    if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(b2)) {
                        com.alipay.sdk.app.statistic.a.b(aVar, com.alipay.sdk.app.statistic.b.m, com.alipay.sdk.app.statistic.b.K, String.format("%s,%s", str, str2));
                    }
                    PreferenceManager.getDefaultSharedPreferences(context).edit().putString(str, b2).apply();
                } catch (Throwable th) {
                    c.a(th);
                }
            }
        }
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (TextUtils.isEmpty(a)) {
                try {
                    str = context.getApplicationContext().getPackageName();
                } catch (Throwable th) {
                    c.a(th);
                    str = "";
                }
                a = (str + "0000000000000000000000000000").substring(0, 24);
            }
            return a;
        }
        return (String) invokeL.objValue;
    }
}
