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
/* loaded from: classes.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f2020a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1255003070, "Lcom/alipay/sdk/util/j;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1255003070, "Lcom/alipay/sdk/util/j;");
        }
    }

    public j() {
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

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            try {
                return PreferenceManager.getDefaultSharedPreferences(context).contains(str);
            } catch (Throwable th) {
                c.a(th);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str) == null) {
            try {
                PreferenceManager.getDefaultSharedPreferences(context).edit().remove(str).commit();
            } catch (Throwable th) {
                c.a(th);
            }
        }
    }

    public static void a(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, context, str, str2) == null) {
            try {
                String a2 = com.alipay.sdk.encrypt.e.a(a(context), str2);
                if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(a2)) {
                    com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f1858c, com.alipay.sdk.app.statistic.c.z, String.format("%s,%s", str, str2));
                }
                PreferenceManager.getDefaultSharedPreferences(context).edit().putString(str, a2).commit();
            } catch (Throwable th) {
                c.a(th);
            }
        }
    }

    public static String b(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, context, str, str2)) == null) {
            try {
                String string = PreferenceManager.getDefaultSharedPreferences(context).getString(str, str2);
                r0 = TextUtils.isEmpty(string) ? null : com.alipay.sdk.encrypt.e.b(a(context), string);
                if (!TextUtils.isEmpty(string) && TextUtils.isEmpty(r0)) {
                    com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f1858c, com.alipay.sdk.app.statistic.c.y, String.format("%s,%s", str, string));
                }
            } catch (Exception e2) {
                c.a(e2);
            }
            return r0;
        }
        return (String) invokeLLL.objValue;
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (TextUtils.isEmpty(f2020a)) {
                try {
                    str = context.getApplicationContext().getPackageName();
                } catch (Throwable th) {
                    c.a(th);
                    str = "";
                }
                f2020a = (str + "0000000000000000000000000000").substring(0, 24);
            }
            return f2020a;
        }
        return (String) invokeL.objValue;
    }
}
