package c.a.p0.a.j2;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.v2.o0;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashSet;
/* loaded from: classes.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static int f7015a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(820913889, "Lc/a/p0/a/j2/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(820913889, "Lc/a/p0/a/j2/j;");
                return;
            }
        }
        boolean z = c.a.p0.a.k.f7085a;
        f7015a = 0;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String o = o0.o(str);
            if (TextUtils.isEmpty(o)) {
                return str;
            }
            HashSet hashSet = new HashSet();
            hashSet.add("bduss");
            hashSet.add("bduss".toUpperCase());
            String i2 = o0.i(o, hashSet);
            String f2 = o0.f(str);
            return f2 + "?" + i2;
        }
        return (String) invokeL.objValue;
    }

    public static int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f7015a : invokeV.intValue;
    }

    public static void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i2) == null) {
            f7015a = i2;
        }
    }

    public static <EvenT extends c.a.p0.a.j2.p.e> EvenT d(EvenT event, String str, Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, event, str, obj)) == null) {
            if (event != null && !TextUtils.isEmpty(str)) {
                event.a(str, obj);
            }
            return event;
        }
        return (EvenT) invokeLLL.objValue;
    }

    public static <EvenT extends c.a.p0.a.j2.p.e> EvenT e(EvenT event) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, event)) == null) {
            d(event, "isDownloading", String.valueOf(c.a.p0.a.a2.d.g().r().s0() ? 1 : 0));
            return event;
        }
        return (EvenT) invokeL.objValue;
    }

    public static <EvenT extends c.a.p0.a.j2.p.e> EvenT f(EvenT event) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, event)) == null) {
            d(event, "launchType", b() == 2 ? "2" : "1");
            return event;
        }
        return (EvenT) invokeL.objValue;
    }

    public static <EvenT extends c.a.p0.a.j2.p.e> EvenT g(EvenT event) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, event)) == null) {
            d(event, "packageState", String.valueOf(c.a.p0.a.a2.d.g().r().r0()));
            return event;
        }
        return (EvenT) invokeL.objValue;
    }

    public static <EvenT extends c.a.p0.a.j2.p.e> EvenT h(EvenT event) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, event)) == null) {
            d(event, "coreState", String.valueOf(c.a.p0.a.h0.u.g.r0()));
            return event;
        }
        return (EvenT) invokeL.objValue;
    }
}
