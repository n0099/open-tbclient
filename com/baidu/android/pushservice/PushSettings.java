package com.baidu.android.pushservice;

import android.content.Context;
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
/* loaded from: classes6.dex */
public class PushSettings {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f34959a = -1;

    /* renamed from: b  reason: collision with root package name */
    public static int f34960b = -1;

    /* renamed from: c  reason: collision with root package name */
    public static int f34961c = -1;

    /* renamed from: d  reason: collision with root package name */
    public static int f34962d = -1;

    /* renamed from: e  reason: collision with root package name */
    public static int f34963e = -1;

    /* renamed from: f  reason: collision with root package name */
    public static int f34964f = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1444861764, "Lcom/baidu/android/pushservice/PushSettings;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1444861764, "Lcom/baidu/android/pushservice/PushSettings;");
        }
    }

    public PushSettings() {
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

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            String a2 = com.baidu.android.pushservice.j.i.a(context, "com.baidu.pushservice.channel_id");
            return TextUtils.isEmpty(a2) ? com.baidu.android.pushservice.c.c.a(context, false) : a2;
        }
        return (String) invokeL.objValue;
    }

    public static void a(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65539, null, context, i2) == null) || context == null) {
            return;
        }
        com.baidu.android.pushservice.j.i.a(context, "com.baidu.pushservice.sd", i2);
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str) == null) {
            com.baidu.android.pushservice.j.i.a(context, "com.baidu.pushservice.channel_token", str);
            com.baidu.android.pushservice.c.c.a(context, str);
        }
    }

    public static void a(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, context, str, str2) == null) {
            com.baidu.android.pushservice.j.i.a(context, "com.baidu.pushservice.channel_id", str);
            com.baidu.android.pushservice.j.i.a(context, "com.baidu.pushservice.channel_id_new", str2);
            com.baidu.android.pushservice.c.c.a(context, str, str2);
        }
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            String a2 = com.baidu.android.pushservice.j.i.a(context, "com.baidu.pushservice.channel_id_new");
            return TextUtils.isEmpty(a2) ? com.baidu.android.pushservice.c.c.a(context, true) : a2;
        }
        return (String) invokeL.objValue;
    }

    public static void b(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65543, null, context, i2) == null) {
            com.baidu.android.pushservice.j.i.a(context, "com.baidu.pushservice.track.failcount", i2);
        }
    }

    public static void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65544, null, context, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        com.baidu.android.pushservice.j.i.b(context, "com.baidu.pushservice.app_id", str);
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            String a2 = com.baidu.android.pushservice.j.i.a(context, "com.baidu.pushservice.channel_token");
            return TextUtils.isEmpty(a2) ? com.baidu.android.pushservice.c.c.c(context) : a2;
        }
        return (String) invokeL.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) ? com.baidu.android.pushservice.j.i.a(context, "com.baidu.pushservice.app_id") : (String) invokeL.objValue;
    }

    public static boolean e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) ? context != null && f34959a == 1 : invokeL.booleanValue;
    }

    public static void enableDebugMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, null, z) == null) {
            f34959a = z ? 1 : 0;
        }
    }

    public static boolean f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            try {
                return (context.getApplicationInfo().flags & 2) != 0;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            if (context == null) {
                return false;
            }
            if (f34960b == -1) {
                f34960b = com.baidu.android.pushservice.j.i.b(context, "com.baidu.android.pushservice.PushSettings.xm_proxy_mode", -1);
            }
            return f34960b == 1;
        }
        return invokeL.booleanValue;
    }

    public static boolean h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            if (context == null) {
                return false;
            }
            if (f34962d == -1) {
                f34962d = com.baidu.android.pushservice.j.i.b(context, "com.baidu.android.pushservice.PushSettings.mz_proxy_mode", -1);
            }
            return f34962d == 1;
        }
        return invokeL.booleanValue;
    }

    public static boolean i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) {
            if (context == null) {
                return false;
            }
            if (f34963e == -1) {
                f34963e = com.baidu.android.pushservice.j.i.b(context, "com.baidu.android.pushservice.PushSettings.op_proxy_mode", -1);
            }
            return f34963e == 1;
        }
        return invokeL.booleanValue;
    }

    public static boolean j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) {
            if (context == null) {
                return false;
            }
            if (f34964f == -1) {
                f34964f = com.baidu.android.pushservice.j.i.b(context, "com.baidu.android.pushservice.PushSettings.vi_proxy_mode", -1);
            }
            return f34964f == 1;
        }
        return invokeL.booleanValue;
    }

    public static boolean k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) {
            if (context == null) {
                return false;
            }
            if (f34961c == -1) {
                f34961c = com.baidu.android.pushservice.j.i.b(context, "com.baidu.android.pushservice.PushSettings.hw_proxy_mode", -1);
            }
            return f34961c == 1;
        }
        return invokeL.booleanValue;
    }

    public static void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, context) == null) {
            com.baidu.android.pushservice.j.i.a(context, "com.baidu.pushservice.track", System.currentTimeMillis());
        }
    }

    public static boolean m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, context)) == null) {
            long b2 = com.baidu.android.pushservice.j.i.b(context, "com.baidu.pushservice.track");
            if (b2 > 0) {
                return System.currentTimeMillis() - b2 >= ((long) ((com.baidu.android.pushservice.b.d.h(context) * 3600) * 1000));
            }
            l(context);
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65557, null, context)) == null) ? com.baidu.android.pushservice.j.i.b(context, "com.baidu.pushservice.track.failcount", 1) : invokeL.intValue;
    }

    public static boolean o(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, context)) == null) ? com.baidu.android.pushservice.j.i.b(context, "com.baidu.pushservice.need.logtofile", -1) == 1 : invokeL.booleanValue;
    }
}
