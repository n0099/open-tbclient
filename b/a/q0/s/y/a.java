package b.a.q0.s.y;

import androidx.core.view.InputDeviceCompat;
import b.a.q0.s.e0.b;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f14430a = null;

    /* renamed from: b  reason: collision with root package name */
    public static int f14431b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static String f14432c = null;

    /* renamed from: d  reason: collision with root package name */
    public static int f14433d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static int f14434e = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1937693813, "Lb/a/q0/s/y/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1937693813, "Lb/a/q0/s/y/a;");
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            if (f14434e < 0) {
                f14434e = b.j().k("app_restart_times", 0);
            }
            TiebaStatic.log(new StatisticItem("c14429").addParam("obj_type", 1).addParam("obj_source", f14434e >= 1 ? 2 : 1));
        }
    }

    public static void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, null, j) == null) {
            if (f14434e < 0) {
                f14434e = b.j().k("app_restart_times", 0);
            }
            TiebaStatic.log(new StatisticItem("c14429").addParam("obj_type", 2).addParam("obj_source", f14434e < 1 ? 1 : 2).addParam(TiebaStatic.Params.OBJ_PARAM2, j));
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            if (f14434e < 0) {
                f14434e = b.j().k("app_restart_times", 0);
            }
            TiebaStatic.log(new StatisticItem("c14430").addParam("obj_source", f14434e >= 1 ? 2 : 1));
        }
    }

    public static void d(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, str, z) == null) {
            f14430a = str;
            f14431b = z ? 1 : 0;
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            f14432c = f14430a;
            f14433d = f14431b;
        }
    }
}
