package c.a.r0.j.f;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public static volatile boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f11239b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile List<c.a.r0.a.o0.d.c> f11240c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-421391797, "Lc/a/r0/j/f/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-421391797, "Lc/a/r0/j/f/i;");
                return;
            }
        }
        f11240c = new ArrayList();
    }

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && a && !f11239b) {
            synchronized (i.class) {
                if (f11240c != null) {
                    for (int i2 = 0; i2 < f11240c.size(); i2++) {
                        c.a.r0.a.g1.f.U().m("console", f11240c.get(i2));
                    }
                    f11240c.clear();
                    f11240c = null;
                }
            }
            f11239b = true;
        }
    }

    public static String b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? i2 != 6 ? TbConfig.TMP_LOG_DIR_NAME : "debug" : "warn" : "error" : "info" : "debug" : (String) invokeI.objValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            synchronized (i.class) {
                f11240c = new ArrayList();
            }
            f11239b = false;
        }
    }

    public static void d(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65541, null, i2, str) == null) {
            e(b(i2), str);
        }
    }

    public static void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, str, str2) == null) && a) {
            f(c.t(str, str2));
        }
    }

    public static void f(c.a.r0.a.o0.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, cVar) == null) {
            if (!f11239b) {
                synchronized (i.class) {
                    if (f11240c != null) {
                        f11240c.add(cVar);
                        return;
                    }
                }
            }
            c.a.r0.a.g1.f.U().m("console", cVar);
        }
    }

    public static void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) && a) {
            f(c.v(str, str2));
        }
    }

    public static void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, null, z) == null) {
            a = z;
            c.a.r0.a.e0.d.n(z);
        }
    }
}
