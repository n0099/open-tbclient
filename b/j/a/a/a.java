package b.j.a.a;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import b.j.a.a.c;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, context) == null) {
            b.f33107b = c.b.f33114a.b(b.a(context));
            b.f33106a = true;
        }
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (b.f33106a) {
                return b.f33107b;
            }
            throw new RuntimeException("SDK Need Init First!");
        }
        return invokeV.booleanValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (b.f33106a) {
                return c.b.f33114a.a(b.a(context), "OUID");
            }
            throw new RuntimeException("SDK Need Init First!");
        }
        return (String) invokeL.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (b.f33106a) {
                return c.b.f33114a.a(b.a(context), "DUID");
            }
            throw new RuntimeException("SDK Need Init First!");
        }
        return (String) invokeL.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (b.f33106a) {
                return c.b.f33114a.a(b.a(context), "AUID");
            }
            throw new RuntimeException("SDK Need Init First!");
        }
        return (String) invokeL.objValue;
    }
}
