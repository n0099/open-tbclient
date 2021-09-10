package c.j.a.a;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.j.a.a.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, context) == null) {
            b.f34297b = c.b.f34304a.b(b.a(context));
            b.f34296a = true;
        }
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b.f34296a) {
                return b.f34297b;
            }
            throw new RuntimeException("SDK Need Init First!");
        }
        return invokeV.booleanValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (b.f34296a) {
                return c.b.f34304a.a(b.a(context), "OUID");
            }
            throw new RuntimeException("SDK Need Init First!");
        }
        return (String) invokeL.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (b.f34296a) {
                return c.b.f34304a.a(b.a(context), "DUID");
            }
            throw new RuntimeException("SDK Need Init First!");
        }
        return (String) invokeL.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (b.f34296a) {
                return c.b.f34304a.a(b.a(context), "AUID");
            }
            throw new RuntimeException("SDK Need Init First!");
        }
        return (String) invokeL.objValue;
    }
}
