package com.baidu.mobstat;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class bp extends bm {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "__Baidu_Stat_SDK_SendRem";
    public static bp b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(581658276, "Lcom/baidu/mobstat/bp;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(581658276, "Lcom/baidu/mobstat/bp;");
                return;
            }
        }
        b = new bp();
    }

    public bp() {
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

    public static bp a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b;
        }
        return (bp) invokeV.objValue;
    }

    @Override // com.baidu.mobstat.bm
    public SharedPreferences a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            return context.getSharedPreferences(a, 0);
        }
        return (SharedPreferences) invokeL.objValue;
    }

    public int b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            return a(context, "sendLogtype", 0);
        }
        return invokeL.intValue;
    }

    public int c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, context)) == null) {
            return a(context, "timeinterval", 1);
        }
        return invokeL.intValue;
    }

    public boolean d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, context)) == null) {
            return a(context, "onlywifi", false);
        }
        return invokeL.booleanValue;
    }

    public String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, context)) == null) {
            return a(context, "device_id_2", (String) null);
        }
        return (String) invokeL.objValue;
    }

    public String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, context)) == null) {
            return a(context, "setchannelwithcodevalue", (String) null);
        }
        return (String) invokeL.objValue;
    }

    public boolean g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, context)) == null) {
            return a(context, "setchannelwithcode", false);
        }
        return invokeL.booleanValue;
    }

    public String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, context)) == null) {
            return a(context, "mtjsdkmacss2_2", (String) null);
        }
        return (String) invokeL.objValue;
    }

    public boolean i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, context)) == null) {
            return a(context, "mtjtv", false);
        }
        return invokeL.booleanValue;
    }

    public String j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, context)) == null) {
            return a(context, "mtjsdkmacsstv_2", (String) null);
        }
        return (String) invokeL.objValue;
    }

    public String k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, context)) == null) {
            return a(context, "he.ext", (String) null);
        }
        return (String) invokeL.objValue;
    }

    public String l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, context)) == null) {
            return a(context, "he.push", (String) null);
        }
        return (String) invokeL.objValue;
    }

    public boolean m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, context)) == null) {
            return a(context, "mtjsdkmactrick", true);
        }
        return invokeL.booleanValue;
    }

    public long n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, context)) == null) {
            return a(context, "autotrace_track_js_fetch_time", 0L);
        }
        return invokeL.longValue;
    }

    public long o(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, context)) == null) {
            return a(context, "autotrace_track_js_fetch_interval", 0L);
        }
        return invokeL.longValue;
    }

    public long p(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, context)) == null) {
            return a(context, "autotrace_config_fetch_time", 0L);
        }
        return invokeL.longValue;
    }

    public String q(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, context)) == null) {
            return a(context, "custom_userid", "");
        }
        return (String) invokeL.objValue;
    }

    public String r(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, context)) == null) {
            return a(context, "last_custom_userid", "");
        }
        return (String) invokeL.objValue;
    }

    public String s(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, context)) == null) {
            return a(context, "scheme_time", "");
        }
        return (String) invokeL.objValue;
    }

    public String t(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, context)) == null) {
            return a(context, "encrypt_device_id", "");
        }
        return (String) invokeL.objValue;
    }

    public String u(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, context)) == null) {
            return a(context, Config.USER_PROPERTY, "");
        }
        return (String) invokeL.objValue;
    }

    public String v(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, context)) == null) {
            return a(context, "out_oaid", "");
        }
        return (String) invokeL.objValue;
    }

    public String w(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, context)) == null) {
            return a(context, "api_oaid", "");
        }
        return (String) invokeL.objValue;
    }

    public boolean x(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, context)) == null) {
            return a(context, "bplus", true);
        }
        return invokeL.booleanValue;
    }

    public int y(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, context)) == null) {
            return a(context, "app_list_index", 0);
        }
        return invokeL.intValue;
    }

    public void a(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, i) == null) {
            b(context, "sendLogtype", i);
        }
    }

    public void b(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, context, i) == null) {
            b(context, "timeinterval", i);
        }
    }

    public void c(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048587, this, context, j) == null) {
            b(context, "autotrace_config_fetch_time", j);
        }
    }

    public void d(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, context, str) == null) {
            b(context, "setchannelwithcodevalue", str);
        }
    }

    public void e(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, context, str) == null) {
            b(context, "mtjsdkmacss2_2", str);
        }
    }

    public void f(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, context, str) == null) {
            b(context, "mtjsdkmacsstv_2", str);
        }
    }

    public void g(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, context, str) == null) {
            b(context, "he.ext", str);
        }
    }

    public void h(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, context, str) == null) {
            b(context, "he.push", str);
        }
    }

    public void i(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, context, str) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            b(context, "custom_userid", str);
        }
    }

    public void j(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, context, str) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            b(context, "last_custom_userid", str);
        }
    }

    public void k(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048606, this, context, str) == null) {
            b(context, "scheme_time", str);
        }
    }

    public void l(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, context, str) == null) {
            b(context, "encrypt_device_id", str);
        }
    }

    public void m(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, context, str) == null) {
            b(context, Config.USER_PROPERTY, str);
        }
    }

    public void n(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048612, this, context, str) == null) {
            b(context, "out_oaid", str);
        }
    }

    public void o(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048614, this, context, str) == null) {
            b(context, "api_oaid", str);
        }
    }

    public void a(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, context, j) == null) {
            b(context, "autotrace_track_js_fetch_time", j);
        }
    }

    public void b(Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048583, this, context, j) == null) {
            b(context, "autotrace_track_js_fetch_interval", j);
        }
    }

    public void c(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048588, this, context, z) == null) {
            b(context, "mtjtv", z);
        }
    }

    public void d(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048590, this, context, z) == null) {
            b(context, "mtjsdkmactrick", z);
        }
    }

    public void e(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048594, this, context, z) == null) {
            b(context, "bplus", z);
        }
    }

    public void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, context, str) == null) {
            b(context, "device_id_2", str);
        }
    }

    public void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, str) == null) {
            if (a(context, "cuid", (String) null) != null) {
                c(context, "cuid");
            }
            b(context, "cuidsec_2", str);
            c(context, "cuidsec_2");
            c(context, "cuidsec_1");
            c(context, "cuidsec_2");
        }
    }

    public void a(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048580, this, context, z) == null) {
            b(context, "onlywifi", z);
        }
    }

    public void b(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, context, z) == null) {
            b(context, "setchannelwithcode", z);
        }
    }
}
