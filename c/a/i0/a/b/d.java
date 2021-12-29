package c.a.i0.a.b;

import c.a.c0.i.h;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static b a;

    /* renamed from: b  reason: collision with root package name */
    public static c f3791b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1591952492, "Lc/a/i0/a/b/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1591952492, "Lc/a/i0/a/b/d;");
        }
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (h.class) {
                    if (a == null) {
                        a = (b) ServiceManager.getService(b.a);
                    }
                    if (a == null) {
                        a = b.f3789b;
                    }
                }
            }
            return a;
        }
        return (b) invokeV.objValue;
    }

    public static c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f3791b == null) {
                synchronized (h.class) {
                    if (f3791b == null) {
                        f3791b = (c) ServiceManager.getService(c.a);
                    }
                    if (f3791b == null) {
                        f3791b = c.f3790b;
                    }
                }
            }
            return f3791b;
        }
        return (c) invokeV.objValue;
    }
}
