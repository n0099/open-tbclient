package c.a.u0;

import android.content.Context;
import android.os.IBinder;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class b0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        c.a.u0.n0.c c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65536, null) == null) || (c2 = c.a.u0.o0.d.c()) == null) {
            return;
        }
        c2.b();
    }

    public static Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            c.a.u0.n0.a a = c.a.u0.o0.d.a();
            if (a != null) {
                return a.getAppContext();
            }
            return null;
        }
        return (Context) invokeV.objValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            c.a.u0.n0.a a = c.a.u0.o0.d.a();
            return a != null ? a.c(str) : str;
        }
        return (String) invokeL.objValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            c.a.u0.n0.a a = c.a.u0.o0.d.a();
            if (a != null) {
                return a.d();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static IBinder e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            c.a.u0.n0.c c2 = c.a.u0.o0.d.c();
            if (c2 != null) {
                return c2.a(str);
            }
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    public static int f(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65541, null, str, i2)) == null) {
            c.a.u0.n0.a a = c.a.u0.o0.d.a();
            return a != null ? a.getInt(str, i2) : i2;
        }
        return invokeLI.intValue;
    }

    public static long g(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65542, null, str, j2)) == null) {
            c.a.u0.n0.a a = c.a.u0.o0.d.a();
            return a != null ? a.getLong(str, j2) : j2;
        }
        return invokeLJ.longValue;
    }

    public static String h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            c.a.u0.n0.a a = c.a.u0.o0.d.a();
            return a != null ? a.e(str) : str;
        }
        return (String) invokeL.objValue;
    }

    public static q i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? c.a.u0.o0.d.e() : (q) invokeV.objValue;
    }

    public static u j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? c.a.u0.o0.d.f() : (u) invokeV.objValue;
    }

    public static String k(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65546, null, z)) == null) {
            c.a.u0.n0.a a = c.a.u0.o0.d.a();
            return a != null ? a.b(z) : "";
        }
        return (String) invokeZ.objValue;
    }

    public static boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            c.a.u0.n0.b b2 = c.a.u0.o0.d.b();
            if (b2 != null) {
                return b2.a();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            c.a.u0.n0.a a = c.a.u0.o0.d.a();
            if (a != null) {
                return a.isDebug();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static void n(String str, int i2) {
        c.a.u0.n0.a a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65549, null, str, i2) == null) || (a = c.a.u0.o0.d.a()) == null) {
            return;
        }
        a.putInt(str, i2);
    }

    public static void o(String str, long j2) {
        c.a.u0.n0.a a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65550, null, str, j2) == null) || (a = c.a.u0.o0.d.a()) == null) {
            return;
        }
        a.putLong(str, j2);
    }

    public static void p(String str, String str2) {
        c.a.u0.n0.a a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65551, null, str, str2) == null) || (a = c.a.u0.o0.d.a()) == null) {
            return;
        }
        a.putString(str, str2);
    }

    public static void q(int i2) {
        c.a.u0.n0.a a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65552, null, i2) == null) || (a = c.a.u0.o0.d.a()) == null) {
            return;
        }
        a.a(i2);
    }
}
