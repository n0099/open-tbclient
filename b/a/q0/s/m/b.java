package b.a.q0.s.m;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.r0.e4.i;
import b.a.r0.m3.s0.g;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static String f13934a;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? f13934a : (String) invokeV.objValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c() || d() : invokeV.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? "5".equals(f13934a) : invokeV.booleanValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? "6".equals(f13934a) : invokeV.booleanValue;
    }

    public static void e(String str, String str2, String str3, String str4) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, str3, str4) == null) || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        f13934a = str;
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
        if (i.c()) {
            i.j(null, null, null, null, i2, Boolean.TRUE, str3, str4);
        } else if (!i.c() && str3 != null) {
            i.n(false, false, null, null, null, null, i2, Boolean.TRUE, str3, str4);
        } else {
            i.m(false, false, null, null, null, null, i2, Boolean.TRUE);
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) {
            f13934a = str;
        }
    }
}
