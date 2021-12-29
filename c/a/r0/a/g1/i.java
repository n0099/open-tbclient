package c.a.r0.a.g1;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public static List<WeakReference<h>> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(425086494, "Lc/a/r0/a/g1/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(425086494, "Lc/a/r0/a/g1/i;");
                return;
            }
        }
        a = new ArrayList();
    }

    public static void a(c.a.r0.a.p.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, dVar) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                h hVar = a.get(size).get();
                if (hVar == null) {
                    a.remove(size);
                } else {
                    hVar.d(dVar);
                }
            }
        }
    }

    public static void b(c.a.r0.a.p.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, dVar) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                h hVar = a.get(size).get();
                if (hVar == null) {
                    a.remove(size);
                } else {
                    hVar.b(dVar);
                }
            }
        }
    }

    public static void c(c.a.r0.a.p.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, dVar) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                h hVar = a.get(size).get();
                if (hVar == null) {
                    a.remove(size);
                } else {
                    hVar.c(dVar);
                }
            }
        }
    }

    public static void d(c.a.r0.a.p.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, dVar) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                h hVar = a.get(size).get();
                if (hVar == null) {
                    a.remove(size);
                } else {
                    hVar.a(dVar);
                }
            }
        }
    }

    public static void e(h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, hVar) == null) || hVar == null) {
            return;
        }
        boolean z = false;
        for (int size = a.size() - 1; size >= 0; size--) {
            h hVar2 = a.get(size).get();
            if (hVar2 == null) {
                a.remove(size);
            } else {
                z = hVar2 == hVar;
            }
        }
        if (z) {
            return;
        }
        a.add(new WeakReference<>(hVar));
    }

    public static void f(h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, null, hVar) == null) || hVar == null) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            h hVar2 = a.get(size).get();
            if (hVar2 == null || hVar == hVar2) {
                a.remove(size);
            }
        }
    }
}
