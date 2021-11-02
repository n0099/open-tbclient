package b.a.p0.a.g1;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
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

    /* renamed from: a  reason: collision with root package name */
    public static List<WeakReference<h>> f5140a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1323672129, "Lb/a/p0/a/g1/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1323672129, "Lb/a/p0/a/g1/i;");
                return;
            }
        }
        f5140a = new ArrayList();
    }

    public static void a(b.a.p0.a.p.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, dVar) == null) {
            for (int size = f5140a.size() - 1; size >= 0; size--) {
                h hVar = f5140a.get(size).get();
                if (hVar == null) {
                    f5140a.remove(size);
                } else {
                    hVar.d(dVar);
                }
            }
        }
    }

    public static void b(b.a.p0.a.p.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, dVar) == null) {
            for (int size = f5140a.size() - 1; size >= 0; size--) {
                h hVar = f5140a.get(size).get();
                if (hVar == null) {
                    f5140a.remove(size);
                } else {
                    hVar.b(dVar);
                }
            }
        }
    }

    public static void c(b.a.p0.a.p.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, dVar) == null) {
            for (int size = f5140a.size() - 1; size >= 0; size--) {
                h hVar = f5140a.get(size).get();
                if (hVar == null) {
                    f5140a.remove(size);
                } else {
                    hVar.c(dVar);
                }
            }
        }
    }

    public static void d(b.a.p0.a.p.e.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, dVar) == null) {
            for (int size = f5140a.size() - 1; size >= 0; size--) {
                h hVar = f5140a.get(size).get();
                if (hVar == null) {
                    f5140a.remove(size);
                } else {
                    hVar.a(dVar);
                }
            }
        }
    }

    public static void e(h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, hVar) == null) || hVar == null) {
            return;
        }
        boolean z = false;
        for (int size = f5140a.size() - 1; size >= 0; size--) {
            h hVar2 = f5140a.get(size).get();
            if (hVar2 == null) {
                f5140a.remove(size);
            } else {
                z = hVar2 == hVar;
            }
        }
        if (z) {
            return;
        }
        f5140a.add(new WeakReference<>(hVar));
    }

    public static void f(h hVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, hVar) == null) || hVar == null) {
            return;
        }
        for (int size = f5140a.size() - 1; size >= 0; size--) {
            h hVar2 = f5140a.get(size).get();
            if (hVar2 == null || hVar == hVar2) {
                f5140a.remove(size);
            }
        }
    }
}
