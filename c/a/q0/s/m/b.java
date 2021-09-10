package c.a.q0.s.m;

import androidx.core.view.InputDeviceCompat;
import c.a.r0.c4.i;
import c.a.r0.j3.r0.g;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f14018a;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? f14018a : (String) invokeV.objValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c() || d() : invokeV.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? "5".equals(f14018a) : invokeV.booleanValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? "6".equals(f14018a) : invokeV.booleanValue;
    }

    public static void e(String str, String str2) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        f14018a = str;
        if (str == null || !str.equals("7")) {
            i2 = 6;
        } else {
            g.i().v(true);
            g.i().A(str2);
            i2 = 7;
        }
        if (i.c()) {
            i.h(null, null, null, null, i2, Boolean.TRUE);
            return;
        }
        i.k(false, false, null, null, null, null, i2, Boolean.TRUE);
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) {
            f14018a = str;
        }
    }
}
