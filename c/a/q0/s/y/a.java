package c.a.q0.s.y;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.e0.b;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static SharedPreferences a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f13246b = null;

    /* renamed from: c  reason: collision with root package name */
    public static int f13247c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static String f13248d = null;

    /* renamed from: e  reason: collision with root package name */
    public static int f13249e = 0;

    /* renamed from: f  reason: collision with root package name */
    public static int f13250f = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1644290806, "Lc/a/q0/s/y/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1644290806, "Lc/a/q0/s/y/a;");
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            e(TbadkCoreApplication.getInst());
            f();
            d("c14483", 0, f13250f >= 1 ? 2 : 1);
        }
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            if (f13250f < 0) {
                f13250f = context.getSharedPreferences("settings", 0).getInt("app_restart_times", 0);
            }
            e(context);
            d("c14429", 1, f13250f < 1 ? 1 : 2);
        }
    }

    public static void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, null, i2) == null) {
            e(TbadkCoreApplication.getInst());
            f();
            d("c14482", i2, f13250f >= 1 ? 2 : 1);
        }
    }

    public static void d(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2, i3) == null) {
            Set<String> stringSet = a.getStringSet(str, null);
            if (stringSet == null) {
                stringSet = new HashSet<>();
            }
            stringSet.add(String.format(Locale.CHINA, "%d_%d_%d", Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis())));
            SharedPreferences.Editor edit = a.edit();
            edit.putStringSet(str, stringSet);
            edit.commit();
        }
    }

    public static void e(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, context) == null) && a == null) {
            a = context.getSharedPreferences("growth_funnel_sp", 0);
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65542, null) == null) || f13250f >= 0) {
            return;
        }
        f13250f = b.j().k("app_restart_times", 0);
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            f();
            TiebaStatic.log(new StatisticItem("c14484").addParam("obj_source", f13250f >= 1 ? 2 : 1).addParam(TiebaStatic.Params.OBJ_PARAM3, System.currentTimeMillis()));
        }
    }

    public static void h(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65544, null, j2) == null) {
            f();
            TiebaStatic.log(new StatisticItem("c14429").addParam("obj_type", 2).addParam("obj_source", f13250f < 1 ? 1 : 2).addParam(TiebaStatic.Params.OBJ_PARAM2, j2));
        }
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            f();
            TiebaStatic.log(new StatisticItem("c14430").addParam("obj_source", f13250f >= 1 ? 2 : 1));
        }
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            f();
            e(TbadkCoreApplication.getInst());
            SharedPreferences.Editor edit = a.edit();
            k("c14429", edit);
            k("c14483", edit);
            k("c14482", edit);
            a = null;
        }
    }

    public static void k(String str, SharedPreferences.Editor editor) {
        Set<String> stringSet;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, str, editor) == null) || (stringSet = a.getStringSet(str, null)) == null) {
            return;
        }
        for (String str2 : stringSet) {
            String[] split = str2.split("_");
            if (split != null && split.length == 3) {
                TiebaStatic.log(new StatisticItem(str).addParam("obj_type", split[0]).addParam("obj_source", split[1]).addParam(TiebaStatic.Params.OBJ_PARAM3, split[2]));
            }
        }
        editor.remove(str).apply();
    }

    public static void l(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65548, null, str, z) == null) {
            f13246b = str;
            f13247c = z ? 1 : 0;
        }
    }

    public static void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, null) == null) {
            f13248d = f13246b;
            f13249e = f13247c;
        }
    }
}
