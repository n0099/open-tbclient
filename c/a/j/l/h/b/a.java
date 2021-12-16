package c.a.j.l.h.b;

import androidx.core.view.InputDeviceCompat;
import c.a.j.h.c.b.b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
/* loaded from: classes.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1396977412, "Lc/a/j/l/h/b/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1396977412, "Lc/a/j/l/h/b/a;");
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final c.a.j.h.b.i.a a(Class<? extends b<c.a.j.e.b.a>> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cls)) == null) ? new c.a.j.h.b.i.a(cls, c.a.j.e.b.a.class) : (c.a.j.h.b.i.a) invokeL.objValue;
    }

    @JvmStatic
    @JvmOverloads
    public static final c.a.j.h.b.i.b b(Class<? extends c.a.j.h.c.d.b<c.a.j.e.d.a>> cls, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, cls, z)) == null) ? new c.a.j.h.b.i.b(cls, c.a.j.e.d.a.class, z) : (c.a.j.h.b.i.b) invokeLZ.objValue;
    }

    @JvmStatic
    public static final c.a.j.h.b.i.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a(c.a.j.l.h.c.a.class) : (c.a.j.h.b.i.a) invokeV.objValue;
    }

    @JvmStatic
    public static final c.a.j.h.b.i.b d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? b(c.a.j.l.h.d.a.class, true) : (c.a.j.h.b.i.b) invokeV.objValue;
    }
}
