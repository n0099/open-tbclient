package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
/* loaded from: classes6.dex */
public class h {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f33934a = "";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1454246386, "Lcom/alipay/apmobilesecuritysdk/e/h;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1454246386, "Lcom/alipay/apmobilesecuritysdk/e/h;");
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

    public static long a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            String a2 = com.alipay.security.mobile.module.c.a.a(context, "vkeyid_settings", "update_time_interval");
            if (com.alipay.security.mobile.module.a.a.b(a2)) {
                try {
                    return Long.parseLong(a2);
                } catch (Exception unused) {
                    return 86400000L;
                }
            }
            return 86400000L;
        }
        return invokeL.longValue;
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, str) == null) {
            a(context, "update_time_interval", str);
        }
    }

    public static void a(Context context, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, str, Long.valueOf(j)}) == null) {
            com.alipay.security.mobile.module.c.a.a(context, "vkeyid_settings", "vkey_valid" + str, String.valueOf(j));
        }
    }

    public static void a(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, context, str, str2) == null) {
            com.alipay.security.mobile.module.c.a.a(context, "vkeyid_settings", str, str2);
        }
    }

    public static void a(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(AdIconUtil.BAIDU_LOGO_ID, null, context, z) == null) {
            a(context, "log_switch", z ? "1" : "0");
        }
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) ? com.alipay.security.mobile.module.c.a.a(context, "vkeyid_settings", "last_apdid_env") : (String) invokeL.objValue;
    }

    public static void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, context, str) == null) {
            a(context, "last_machine_boot_time", str);
        }
    }

    public static void c(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, context, str) == null) {
            a(context, "last_apdid_env", str);
        }
    }

    public static boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            String a2 = com.alipay.security.mobile.module.c.a.a(context, "vkeyid_settings", "log_switch");
            return a2 != null && "1".equals(a2);
        }
        return invokeL.booleanValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) ? com.alipay.security.mobile.module.c.a.a(context, "vkeyid_settings", "dynamic_key") : (String) invokeL.objValue;
    }

    public static void d(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, str) == null) {
            a(context, "agent_switch", str);
        }
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) ? com.alipay.security.mobile.module.c.a.a(context, "vkeyid_settings", "apse_degrade") : (String) invokeL.objValue;
    }

    public static void e(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, context, str) == null) {
            a(context, "dynamic_key", str);
        }
    }

    public static String f(Context context) {
        InterceptResult invokeL;
        String str;
        SharedPreferences.Editor edit;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            synchronized (h.class) {
                if (com.alipay.security.mobile.module.a.a.a(f33934a)) {
                    String a2 = com.alipay.security.mobile.module.c.e.a(context, "alipay_vkey_random", "random", "");
                    f33934a = a2;
                    if (com.alipay.security.mobile.module.a.a.a(a2)) {
                        String a3 = com.alipay.security.mobile.module.a.a.b.a(UUID.randomUUID().toString());
                        f33934a = a3;
                        if (a3 != null && (edit = context.getSharedPreferences("alipay_vkey_random", 0).edit()) != null) {
                            edit.putString("random", a3);
                            edit.commit();
                        }
                    }
                }
                str = f33934a;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static void f(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, context, str) == null) {
            a(context, "webrtc_url", str);
        }
    }

    public static void g(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, context, str) == null) {
            a(context, "apse_degrade", str);
        }
    }

    public static long h(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, context, str)) == null) {
            try {
                String a2 = com.alipay.security.mobile.module.c.a.a(context, "vkeyid_settings", "vkey_valid" + str);
                if (com.alipay.security.mobile.module.a.a.a(a2)) {
                    return 0L;
                }
                return Long.parseLong(a2);
            } catch (Throwable unused) {
                return 0L;
            }
        }
        return invokeLL.longValue;
    }
}
