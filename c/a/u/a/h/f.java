package c.a.u.a.h;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SharedPreferences f26311e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f26312f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f26313g;

        public a(SharedPreferences sharedPreferences, String str, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sharedPreferences, str, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26311e = sharedPreferences;
            this.f26312f = str;
            this.f26313g = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f.D(this.f26311e, this.f26312f, this.f26313g);
            }
        }
    }

    public static void A(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65536, null, context, str, z) == null) {
            E(context, str, Boolean.valueOf(z));
        }
    }

    public static void B(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, null, context, i2) == null) {
            C(context, "conn_type", i2);
        }
    }

    public static void C(Context context, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65538, null, context, str, i2) == null) {
            E(context, str, Integer.valueOf(i2));
        }
    }

    public static void D(SharedPreferences sharedPreferences, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, sharedPreferences, str, obj) == null) {
            if (obj instanceof Boolean) {
                sharedPreferences.edit().putBoolean(str, ((Boolean) obj).booleanValue()).apply();
            } else if (obj instanceof Integer) {
                sharedPreferences.edit().putInt(str, ((Integer) obj).intValue()).apply();
            } else if (obj instanceof Long) {
                sharedPreferences.edit().putLong(str, ((Long) obj).longValue()).apply();
            } else if (obj instanceof Float) {
                sharedPreferences.edit().putFloat(str, ((Float) obj).floatValue()).apply();
            } else if (obj instanceof String) {
                sharedPreferences.edit().putString(str, (String) obj).apply();
            }
        }
    }

    public static void E(Context context, String str, Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, obj) == null) || context == null) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("blcp_sp", 0);
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                c.a.u.a.g.a.a(context).b(new a(sharedPreferences, str, obj));
            } else {
                D(sharedPreferences, str, obj);
            }
        } catch (Throwable th) {
            e.b("SpUtils", th.getMessage());
        }
    }

    public static void F(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, context, str, str2) == null) {
            E(context, str, str2);
        }
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) ? p(context, "blcp_app_id", "") : (String) invokeL.objValue;
    }

    public static boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) ? n(context, "bddns_enable", false) : invokeL.booleanValue;
    }

    public static int d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) ? o(context, "conn_type", 1) : invokeL.intValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) ? p(context, "blcp_cuid", "") : (String) invokeL.objValue;
    }

    public static int f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) ? o(context, "key_vip_connect_type", 3) : invokeL.intValue;
    }

    public static int g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) ? o(context, "lcp_env_debug", 0) : invokeL.intValue;
    }

    public static String h(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, context, i2)) == null) {
            return p(context, "protocol_priority" + i2, " : : ");
        }
        return (String) invokeLI.objValue;
    }

    public static int i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) ? o(context, "protocols_size", 1) : invokeL.intValue;
    }

    public static String j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) ? p(context, "blcp_token", "") : (String) invokeL.objValue;
    }

    public static boolean k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) ? !TextUtils.isEmpty(j(context)) : invokeL.booleanValue;
    }

    public static boolean l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) ? n(context, "lcp_debug", false) : invokeL.booleanValue;
    }

    public static boolean m(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) ? c.a.u.a.h.a.a().b() || n(context, "small_flow", true) : invokeL.booleanValue;
    }

    public static boolean n(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65555, null, context, str, z)) == null) {
            if (context == null) {
                return false;
            }
            return context.getSharedPreferences("blcp_sp", 0).getBoolean(str, z);
        }
        return invokeLLZ.booleanValue;
    }

    public static int o(Context context, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65556, null, context, str, i2)) == null) {
            if (context == null) {
                return -1;
            }
            return context.getSharedPreferences("blcp_sp", 0).getInt(str, i2);
        }
        return invokeLLI.intValue;
    }

    public static String p(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65557, null, context, str, str2)) == null) ? context == null ? "" : context.getSharedPreferences("blcp_sp", 0).getString(str, str2) : (String) invokeLLL.objValue;
    }

    public static void q(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65558, null, context, str) == null) {
            F(context, "blcp_app_id", str);
        }
    }

    public static void r(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65559, null, context, z) == null) {
            A(context, "bddns_enable", z);
        }
    }

    public static void s(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65560, null, context, str) == null) {
            F(context, "blcp_cuid", str);
        }
    }

    public static void t(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65561, null, context, i2) == null) {
            C(context, "key_vip_connect_type", i2);
        }
    }

    public static void u(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65562, null, context, i2) == null) {
            C(context, "lcp_env_debug", i2);
        }
    }

    public static void v(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65563, null, context, z) == null) {
            A(context, "lcp_debug", z);
        }
    }

    public static void w(Context context, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65564, null, context, str, i2) == null) {
            F(context, "protocol_priority" + i2, str);
        }
    }

    public static void x(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65565, null, context, i2) == null) {
            C(context, "protocols_size", i2);
        }
    }

    public static void y(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65566, null, context, z) == null) {
            c.a.u.a.h.a.a().c(z);
            A(context, "small_flow", z);
        }
    }

    public static void z(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65567, null, context, str) == null) {
            F(context, "blcp_token", str);
        }
    }
}
