package c.a.q0.s.m;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.l4.i;
import c.a.r0.t3.s0.g;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
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

    public static void e(String str, String str2, String str3, String str4) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, str3, str4) == null) || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        a = str;
        if (str != null && str.equals("7")) {
            g.j().y(true);
            g.j().w(str2);
            i2 = 7;
        } else if (TextUtils.equals(str, "8")) {
            g.j().x(8);
            g.j().w(str2);
            i2 = 8;
        } else {
            i2 = 6;
        }
        if (i.b()) {
            i.i(null, null, null, null, i2, Boolean.TRUE, str3, str4);
        } else if (!i.b() && str3 != null) {
            i.m(false, false, null, null, null, null, i2, Boolean.TRUE, str3, str4);
        } else {
            i.l(false, false, null, null, null, null, i2, Boolean.TRUE);
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            a = str;
        }
    }
}
