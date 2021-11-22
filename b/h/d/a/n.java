package b.h.d.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public final class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void A(boolean z, String str, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{Boolean.valueOf(z), str, obj}) == null) && !z) {
            throw new IllegalStateException(q.b(str, obj));
        }
    }

    public static void B(boolean z, String str, Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Boolean.valueOf(z), str, obj, obj2}) == null) && !z) {
            throw new IllegalStateException(q.b(str, obj, obj2));
        }
    }

    public static String a(int i2, int i3, String str) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65538, null, i2, i3, str)) == null) {
            if (i2 < 0) {
                return q.b("%s (%s) must not be negative", str, Integer.valueOf(i2));
            }
            if (i3 >= 0) {
                return q.b("%s (%s) must be less than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
            }
            throw new IllegalArgumentException("negative size: " + i3);
        }
        return (String) invokeIIL.objValue;
    }

    public static String b(int i2, int i3, String str) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65539, null, i2, i3, str)) == null) {
            if (i2 < 0) {
                return q.b("%s (%s) must not be negative", str, Integer.valueOf(i2));
            }
            if (i3 >= 0) {
                return q.b("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i2), Integer.valueOf(i3));
            }
            throw new IllegalArgumentException("negative size: " + i3);
        }
        return (String) invokeIIL.objValue;
    }

    public static String c(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(InputDeviceCompat.SOURCE_TRACKBALL, null, i2, i3, i4)) == null) {
            if (i2 < 0 || i2 > i4) {
                return b(i2, i4, "start index");
            }
            return (i3 < 0 || i3 > i4) ? b(i3, i4, "end index") : q.b("end index (%s) must not be less than start index (%s)", Integer.valueOf(i3), Integer.valueOf(i2));
        }
        return (String) invokeIII.objValue;
    }

    public static void d(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, null, z) == null) && !z) {
            throw new IllegalArgumentException();
        }
    }

    public static void e(boolean z, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(AdIconUtil.BAIDU_LOGO_ID, null, z, obj) == null) && !z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void f(boolean z, String str, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{Boolean.valueOf(z), str, Integer.valueOf(i2)}) == null) && !z) {
            throw new IllegalArgumentException(q.b(str, Integer.valueOf(i2)));
        }
    }

    public static void g(boolean z, String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{Boolean.valueOf(z), str, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) && !z) {
            throw new IllegalArgumentException(q.b(str, Integer.valueOf(i2), Integer.valueOf(i3)));
        }
    }

    public static void h(boolean z, String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{Boolean.valueOf(z), str, Long.valueOf(j)}) == null) && !z) {
            throw new IllegalArgumentException(q.b(str, Long.valueOf(j)));
        }
    }

    public static void i(boolean z, String str, long j, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{Boolean.valueOf(z), str, Long.valueOf(j), Long.valueOf(j2)}) == null) && !z) {
            throw new IllegalArgumentException(q.b(str, Long.valueOf(j), Long.valueOf(j2)));
        }
    }

    public static void j(boolean z, String str, long j, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{Boolean.valueOf(z), str, Long.valueOf(j), obj}) == null) && !z) {
            throw new IllegalArgumentException(q.b(str, Long.valueOf(j), obj));
        }
    }

    public static void k(boolean z, String str, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{Boolean.valueOf(z), str, obj}) == null) && !z) {
            throw new IllegalArgumentException(q.b(str, obj));
        }
    }

    public static void l(boolean z, String str, Object obj, Object obj2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{Boolean.valueOf(z), str, obj, obj2}) == null) && !z) {
            throw new IllegalArgumentException(q.b(str, obj, obj2));
        }
    }

    public static void m(boolean z, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Boolean.valueOf(z), str, obj, obj2, obj3, obj4}) == null) && !z) {
            throw new IllegalArgumentException(q.b(str, obj, obj2, obj3, obj4));
        }
    }

    public static int n(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65551, null, i2, i3)) == null) {
            o(i2, i3, "index");
            return i2;
        }
        return invokeII.intValue;
    }

    public static int o(int i2, int i3, String str) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65552, null, i2, i3, str)) == null) {
            if (i2 < 0 || i2 >= i3) {
                throw new IndexOutOfBoundsException(a(i2, i3, str));
            }
            return i2;
        }
        return invokeIIL.intValue;
    }

    public static <T> T p(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, t)) == null) {
            if (t != null) {
                return t;
            }
            throw null;
        }
        return (T) invokeL.objValue;
    }

    public static <T> T q(T t, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65554, null, t, obj)) == null) {
            if (t != null) {
                return t;
            }
            throw new NullPointerException(String.valueOf(obj));
        }
        return (T) invokeLL.objValue;
    }

    public static <T> T r(T t, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65555, null, t, str, obj)) == null) {
            if (t != null) {
                return t;
            }
            throw new NullPointerException(q.b(str, obj));
        }
        return (T) invokeLLL.objValue;
    }

    public static <T> T s(T t, String str, Object obj, Object obj2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65556, null, t, str, obj, obj2)) == null) {
            if (t != null) {
                return t;
            }
            throw new NullPointerException(q.b(str, obj, obj2));
        }
        return (T) invokeLLLL.objValue;
    }

    public static int t(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65557, null, i2, i3)) == null) {
            u(i2, i3, "index");
            return i2;
        }
        return invokeII.intValue;
    }

    public static int u(int i2, int i3, String str) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65558, null, i2, i3, str)) == null) {
            if (i2 < 0 || i2 > i3) {
                throw new IndexOutOfBoundsException(b(i2, i3, str));
            }
            return i2;
        }
        return invokeIIL.intValue;
    }

    public static void v(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(65559, null, i2, i3, i4) == null) {
            if (i2 < 0 || i3 < i2 || i3 > i4) {
                throw new IndexOutOfBoundsException(c(i2, i3, i4));
            }
        }
    }

    public static void w(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(65560, null, z) == null) && !z) {
            throw new IllegalStateException();
        }
    }

    public static void x(boolean z, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(65561, null, z, obj) == null) && !z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void y(boolean z, String str, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65562, null, new Object[]{Boolean.valueOf(z), str, Integer.valueOf(i2)}) == null) && !z) {
            throw new IllegalStateException(q.b(str, Integer.valueOf(i2)));
        }
    }

    public static void z(boolean z, String str, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65563, null, new Object[]{Boolean.valueOf(z), str, Long.valueOf(j)}) == null) && !z) {
            throw new IllegalStateException(q.b(str, Long.valueOf(j)));
        }
    }
}
