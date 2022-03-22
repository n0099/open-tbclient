package c.a.o0.f1.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1164178786, "Lc/a/o0/f1/b/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1164178786, "Lc/a/o0/f1/b/b;");
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            c.a.o0.r.j0.b.k().D("key_youngster_verify");
        }
    }

    public static String b(c.a.o0.f1.a.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, aVar)) == null) {
            if (aVar == null || StringUtils.isNull(aVar.c()) || StringUtils.isNull(aVar.b()) || StringUtils.isNull(aVar.a())) {
                return "";
            }
            return aVar.c() + "," + aVar.b() + "," + aVar.a();
        }
        return (String) invokeL.objValue;
    }

    public static c.a.o0.f1.a.a c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            String[] split = str.split(",");
            if (split.length > 2) {
                return new c.a.o0.f1.a.a(split[0], split[1], split[2]);
            }
            return null;
        }
        return (c.a.o0.f1.a.a) invokeL.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (StringUtils.isNull(str)) {
                return false;
            }
            String q = c.a.o0.r.j0.b.k().q("key_youngster_verify", "");
            if (StringUtils.isNull(q)) {
                a();
                return false;
            }
            c.a.o0.f1.a.a c2 = c(q);
            if (c2 == null) {
                return false;
            }
            return str.equals(c2.a());
        }
        return invokeL.booleanValue;
    }

    public static void f(String str) {
        AccountData currentAccountInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, str) == null) || StringUtils.isNull(str) || (currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo()) == null) {
            return;
        }
        c.a.o0.r.j0.b.k().y("key_youngster_verify", b(new c.a.o0.f1.a.a(currentAccountInfo.getID(), currentAccountInfo.getPortrait(), str)));
    }
}
