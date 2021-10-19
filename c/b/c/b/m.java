package c.b.c.b;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.b.c.b.h.c;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public final class m {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static Context f31628a = null;

    /* renamed from: b  reason: collision with root package name */
    public static long f31629b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static String f31630c = "default";

    /* renamed from: d  reason: collision with root package name */
    public static boolean f31631d;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: e  reason: collision with root package name */
    public static c.b.c.b.h.b f31632e;

    /* renamed from: f  reason: collision with root package name */
    public static c f31633f;

    /* renamed from: g  reason: collision with root package name */
    public static d f31634g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile ConcurrentHashMap<Integer, String> f31635h;

    /* renamed from: i  reason: collision with root package name */
    public static c.b.c.b.h.k f31636i;

    /* renamed from: j  reason: collision with root package name */
    public static volatile int f31637j;
    public static volatile String k;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(185049132, "Lc/b/c/b/m;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(185049132, "Lc/b/c/b/m;");
                return;
            }
        }
        f31633f = new c();
        f31634g = new d();
        f31636i = null;
    }

    public m() {
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

    public static c.b.c.b.h.b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f31632e : (c.b.c.b.h.b) invokeV.objValue;
    }

    public static void b(Context context, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, gVar) == null) {
            f31629b = System.currentTimeMillis();
            f31628a = context;
            f31632e = new c.b.c.b.h.b(context, gVar);
        }
    }

    public static d c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f31634g : (d) invokeV.objValue;
    }

    public static c.b.c.b.h.k d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (f31636i == null) {
                synchronized (m.class) {
                    f31636i = new c.b.c.b.h.k(f31628a);
                }
            }
            return f31636i;
        }
        return (c.b.c.b.h.k) invokeV.objValue;
    }

    public static Context e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f31628a : (Context) invokeV.objValue;
    }

    public static c f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f31633f : (c) invokeV.objValue;
    }

    public static long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? f31629b : invokeV.longValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? f31630c : (String) invokeV.objValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? f31631d : invokeV.booleanValue;
    }

    public static ConcurrentHashMap<Integer, String> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? f31635h : (ConcurrentHashMap) invokeV.objValue;
    }

    public static int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? f31637j : invokeV.intValue;
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) ? k : (String) invokeV.objValue;
    }
}
