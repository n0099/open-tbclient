package com.alipay.sdk.util;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f35875a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1255002977, "Lcom/alipay/sdk/util/g;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1255002977, "Lcom/alipay/sdk/util/g;");
        }
    }

    public g() {
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
            synchronized (g.class) {
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
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str) == null) {
            synchronized (g.class) {
                try {
                    PreferenceManager.getDefaultSharedPreferences(context).edit().remove(str).apply();
                } catch (Throwable th) {
                    c.a(th);
                }
            }
        }
    }

    public static synchronized void a(com.alipay.sdk.sys.a aVar, Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65539, null, aVar, context, str, str2) == null) {
            synchronized (g.class) {
                try {
                    String a2 = com.alipay.sdk.encrypt.e.a(a(context), str2, str);
                    if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(a2)) {
                        com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.f35700c, com.alipay.sdk.app.statistic.b.A, String.format("%s,%s", str, str2));
                    }
                    PreferenceManager.getDefaultSharedPreferences(context).edit().putString(str, a2).apply();
                } catch (Throwable th) {
                    c.a(th);
                }
            }
        }
    }

    public static synchronized String b(com.alipay.sdk.sys.a aVar, Context context, String str, String str2) {
        InterceptResult invokeLLLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, null, aVar, context, str, str2)) == null) {
            synchronized (g.class) {
                try {
                    String string = PreferenceManager.getDefaultSharedPreferences(context).getString(str, str2);
                    str3 = TextUtils.isEmpty(string) ? null : com.alipay.sdk.encrypt.e.b(a(context), string, str);
                    if (!TextUtils.isEmpty(string) && TextUtils.isEmpty(str3)) {
                        com.alipay.sdk.app.statistic.a.a(aVar, com.alipay.sdk.app.statistic.b.f35700c, com.alipay.sdk.app.statistic.b.z, String.format("%s,%s", str, string));
                    }
                } catch (Exception e2) {
                    c.a(e2);
                }
            }
            return str3;
        }
        return (String) invokeLLLL.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (TextUtils.isEmpty(f35875a)) {
                try {
                    str = context.getApplicationContext().getPackageName();
                } catch (Throwable th) {
                    c.a(th);
                    str = "";
                }
                f35875a = (str + "0000000000000000000000000000").substring(0, 24);
            }
            return f35875a;
        }
        return (String) invokeL.objValue;
    }
}
