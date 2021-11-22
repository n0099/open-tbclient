package b.a.r0.c4.l;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Set<String> f16677a;

    /* renamed from: b  reason: collision with root package name */
    public static Set<String> f16678b;

    /* renamed from: c  reason: collision with root package name */
    public static Set<String> f16679c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1496128691, "Lb/a/r0/c4/l/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1496128691, "Lb/a/r0/c4/l/e;");
                return;
            }
        }
        f16677a = new HashSet();
        f16678b = new HashSet();
        f16679c = new HashSet();
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            f16678b.add(str);
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            f16677a.add(str);
        }
    }

    public static void c(String str, Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, set) == null) {
            StatisticItem statisticItem = new StatisticItem("c14295");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_locate", str);
            statisticItem.param("obj_type", set.size());
            TiebaStatic.log(statisticItem);
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) || f16678b.size() == 0) {
            return;
        }
        c(str, f16678b);
        f16678b.clear();
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) || f16679c.size() == 0) {
            return;
        }
        c(str, f16679c);
        f16679c.clear();
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str) == null) || f16677a.size() == 0) {
            return;
        }
        c(str, f16677a);
        f16677a.clear();
    }
}
