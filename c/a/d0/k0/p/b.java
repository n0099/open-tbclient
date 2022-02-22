package c.a.d0.k0.p;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static e a;

    /* renamed from: b  reason: collision with root package name */
    public static i f2872b;

    /* renamed from: c  reason: collision with root package name */
    public static c.a.d0.j0.a f2873c;

    /* renamed from: d  reason: collision with root package name */
    public static k f2874d;

    /* renamed from: e  reason: collision with root package name */
    public static j f2875e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-854800923, "Lc/a/d0/k0/p/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-854800923, "Lc/a/d0/k0/p/b;");
        }
    }

    public b() {
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

    public static e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (b.class) {
                    if (a == null) {
                        a = (e) ServiceManager.getService(e.a);
                    }
                    if (a == null) {
                        a = e.f2876b;
                    }
                }
            }
            return a;
        }
        return (e) invokeV.objValue;
    }

    public static c.a.d0.j0.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f2873c == null) {
                synchronized (b.class) {
                    if (f2873c == null) {
                        f2873c = (c.a.d0.j0.a) ServiceManager.getService(c.a.d0.j0.a.a);
                    }
                    if (f2873c == null) {
                        f2873c = c.a.d0.j0.a.f2851b;
                    }
                }
            }
            return f2873c;
        }
        return (c.a.d0.j0.a) invokeV.objValue;
    }

    public static Context c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? c.a.d0.h.a.b() : (Context) invokeV.objValue;
    }

    public static f d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? f.a : (f) invokeV.objValue;
    }

    public static c e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? c.a : (c) invokeV.objValue;
    }

    public static d f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? d.a : (d) invokeV.objValue;
    }

    public static j g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (f2875e == null) {
                synchronized (b.class) {
                    if (f2875e == null) {
                        f2875e = (j) ServiceManager.getService(j.a);
                    }
                    if (f2875e == null) {
                        f2875e = j.f2879b;
                    }
                }
            }
            return f2875e;
        }
        return (j) invokeV.objValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? c.a.d0.l.h.b().info().a("nad_web_view_forbid_kb_opt_switch", 0) == 1 : invokeV.booleanValue;
    }

    public static i i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (f2872b == null) {
                synchronized (b.class) {
                    if (f2872b == null) {
                        f2872b = (i) ServiceManager.getService(i.a);
                    }
                    if (f2872b == null) {
                        f2872b = i.f2877b;
                    }
                }
            }
            return f2872b;
        }
        return (i) invokeV.objValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? c.a.d0.l.h.b().info().a("nad_web_view_type_switch", 0) == 1 : invokeV.booleanValue;
    }

    public static k k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (f2874d == null) {
                synchronized (b.class) {
                    if (f2874d == null) {
                        f2874d = (k) ServiceManager.getService(k.a);
                    }
                    if (f2874d == null) {
                        f2874d = k.f2880b;
                    }
                }
            }
            return f2874d;
        }
        return (k) invokeV.objValue;
    }
}
