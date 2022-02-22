package c.a.t0.s.n;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.u0.s4.s;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? a : (String) invokeV.objValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c() || d() : invokeV.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? "5".equals(a) : invokeV.booleanValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? "6".equals(a) : invokeV.booleanValue;
    }

    public static void e(String str, String str2, String str3, String str4, String str5) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, str3, str4, str5) == null) || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        a = str;
        if (str != null && str.equals("7")) {
            c.a.u0.z3.t0.b.k().z(true);
            c.a.u0.z3.t0.b.k().x(str2);
            i2 = 7;
        } else if (TextUtils.equals(str, "8")) {
            c.a.u0.z3.t0.b.k().y(8);
            c.a.u0.z3.t0.b.k().x(str2);
            i2 = 8;
        } else {
            i2 = 6;
        }
        if (s.b()) {
            s.h(null, null, null, null, i2, Boolean.TRUE, str3, str4, str5);
            return;
        }
        s.k(false, false, null, null, null, null, i2, Boolean.TRUE, str3, str4, str5);
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            a = str;
        }
    }
}
