package c.a.c0.j0.p;

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
    public static i f2012b;

    /* renamed from: c  reason: collision with root package name */
    public static c.a.c0.i0.a f2013c;

    /* renamed from: d  reason: collision with root package name */
    public static k f2014d;

    /* renamed from: e  reason: collision with root package name */
    public static j f2015e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1545791099, "Lc/a/c0/j0/p/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1545791099, "Lc/a/c0/j0/p/b;");
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
                        a = e.f2016b;
                    }
                }
            }
            return a;
        }
        return (e) invokeV.objValue;
    }

    public static c.a.c0.i0.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f2013c == null) {
                synchronized (b.class) {
                    if (f2013c == null) {
                        f2013c = (c.a.c0.i0.a) ServiceManager.getService(c.a.c0.i0.a.a);
                    }
                    if (f2013c == null) {
                        f2013c = c.a.c0.i0.a.f1935b;
                    }
                }
            }
            return f2013c;
        }
        return (c.a.c0.i0.a) invokeV.objValue;
    }

    public static Context c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? c.a.c0.h.a.b() : (Context) invokeV.objValue;
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
            if (f2015e == null) {
                synchronized (b.class) {
                    if (f2015e == null) {
                        f2015e = (j) ServiceManager.getService(j.a);
                    }
                    if (f2015e == null) {
                        f2015e = j.f2019b;
                    }
                }
            }
            return f2015e;
        }
        return (j) invokeV.objValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? c.a.c0.l.h.b().info().a("nad_web_view_forbid_kb_opt_switch", 0) == 1 : invokeV.booleanValue;
    }

    public static i i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (f2012b == null) {
                synchronized (b.class) {
                    if (f2012b == null) {
                        f2012b = (i) ServiceManager.getService(i.a);
                    }
                    if (f2012b == null) {
                        f2012b = i.f2017b;
                    }
                }
            }
            return f2012b;
        }
        return (i) invokeV.objValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? c.a.c0.l.h.b().info().a("nad_web_view_type_switch", 0) == 1 : invokeV.booleanValue;
    }

    public static k k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            if (f2014d == null) {
                synchronized (b.class) {
                    if (f2014d == null) {
                        f2014d = (k) ServiceManager.getService(k.a);
                    }
                    if (f2014d == null) {
                        f2014d = k.f2020b;
                    }
                }
            }
            return f2014d;
        }
        return (k) invokeV.objValue;
    }
}
