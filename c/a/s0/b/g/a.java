package c.a.s0.b.g;

import androidx.core.view.InputDeviceCompat;
import c.a.s0.b.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "key_user_last_access_tab_";

    /* renamed from: b  reason: collision with root package name */
    public static String f12258b = "key_frs_new_area_tab_sort_";

    /* renamed from: c  reason: collision with root package name */
    public static int f12259c = Integer.MAX_VALUE;

    /* renamed from: d  reason: collision with root package name */
    public static final String f12260d;

    /* renamed from: e  reason: collision with root package name */
    public static final String f12261e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1837117371, "Lc/a/s0/b/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1837117371, "Lc/a/s0/b/g/a;");
                return;
            }
        }
        f12260d = TbadkCoreApplication.getInst().getString(R.string.frs_hot_tab_name);
        f12261e = TbadkCoreApplication.getInst().getString(R.string.frs_new_area_tab_name);
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return f12258b + TbadkCoreApplication.getCurrentAccount();
        }
        return (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a + TbadkCoreApplication.getCurrentAccount();
        }
        return (String) invokeV.objValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (d.r()) {
                return 1;
            }
            if (d.s()) {
                return 503;
            }
            if (d.t()) {
                return h(e());
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public static int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? c.a.s0.s.h0.b.k().l(a(), f12259c) : invokeV.intValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? c.a.s0.s.h0.b.k().q(b(), f12260d) : (String) invokeV.objValue;
    }

    public static void f(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65542, null, i2) == null) {
            c.a.s0.s.h0.b.k().w(a(), i2);
        }
    }

    public static void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            if (f12260d.equals(str) || f12261e.equals(str)) {
                c.a.s0.s.h0.b.k().y(b(), str);
            }
        }
    }

    public static int h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? (!f12260d.equals(str) && f12261e.equals(str)) ? 503 : 1 : invokeL.intValue;
    }
}
