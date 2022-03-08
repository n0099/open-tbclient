package com.baidu.apollon.heartbeat;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f31104b = "last_cfg_request_time";

    /* renamed from: c  reason: collision with root package name */
    public static final String f31105c = "heartbeat_cfg_fingerprint";

    /* renamed from: d  reason: collision with root package name */
    public static final int f31106d = 300;

    /* renamed from: e  reason: collision with root package name */
    public static final String f31107e = "HeartBeatSP";

    /* renamed from: f  reason: collision with root package name */
    public static SharedPreferences f31108f;

    /* renamed from: g  reason: collision with root package name */
    public static SharedPreferences.Editor f31109g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-793707319, "Lcom/baidu/apollon/heartbeat/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-793707319, "Lcom/baidu/apollon/heartbeat/c;");
                return;
            }
        }
        a = c.class.getClass().getSimpleName();
    }

    public c() {
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

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, context) == null) && f31108f == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f31107e, 0);
            f31108f = sharedPreferences;
            f31109g = sharedPreferences.edit();
        }
    }

    public static long b(Context context, String str, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{context, str, Long.valueOf(j2)})) == null) {
            a(context);
            return f31108f.getLong(str, j2);
        }
        return invokeCommon.longValue;
    }

    public static String b(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, context, str, str2)) == null) {
            a(context);
            return f31108f.getString(str, str2);
        }
        return (String) invokeLLL.objValue;
    }

    public static void a(Context context, String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, str, Long.valueOf(j2)}) == null) {
            a(context);
            f31109g.putLong(str, j2);
            f31109g.commit();
        }
    }

    public static void a(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, context, str, str2) == null) {
            a(context);
            f31109g.putString(str, str2);
            f31109g.commit();
        }
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, str) == null) {
            a(context);
            f31109g.remove(str);
            f31109g.commit();
        }
    }
}
