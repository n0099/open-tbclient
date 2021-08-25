package c.a.o0.a.c0.d;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.e0.d;
import c.a.o0.a.g1.f;
import c.a.o0.a.k;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(815145457, "Lc/a/o0/a/c0/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(815145457, "Lc/a/o0/a/c0/d/a;");
                return;
            }
        }
        boolean z = k.f7049a;
    }

    @Nullable
    public static <C extends c.a.o0.a.c0.b.a> C a(c.a.o0.a.c0.b.b bVar) {
        InterceptResult invokeL;
        C c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            if (bVar == null) {
                c.a.o0.a.c0.g.a.a("Component-Finder", "find a null component: null model");
                return null;
            }
            String f2 = bVar.f();
            String str = bVar.f4630g;
            if (TextUtils.isEmpty(str)) {
                d.b("Component-Finder", "find a null " + f2 + " : slaveId is empty");
                return null;
            }
            c.a.o0.a.c0.e.a d2 = d(str);
            if (d2 == null) {
                d.b("Component-Finder", "find a null " + f2 + " : null component context");
                return null;
            }
            String str2 = bVar.f4629f;
            if (TextUtils.isEmpty(str2)) {
                d.l("Component-Finder", "find " + f2 + " with a empty componentId");
                List<c.a.o0.a.c0.b.a> list = d2.a().f4702c.get(bVar.f4628e);
                if (list == null) {
                    d.b("Component-Finder", "find a null " + f2 + " with a empty componentId: fallbackComponents are null ");
                    return null;
                } else if (list.size() <= 0) {
                    d.b("Component-Finder", "find a null " + f2 + " with a empty componentId: fallbackComponents are empty ");
                    return null;
                } else {
                    d.l("Component-Finder", "find " + f2 + " with a empty componentId: fina a fallback component");
                    c2 = (C) list.get(0);
                }
            } else {
                c2 = (C) d2.a().f4701b.get(str2);
            }
            if (c2 == null) {
                d.b("Component-Finder", "find a null " + f2 + " : not exist");
                return null;
            }
            return c2;
        }
        return (C) invokeL.objValue;
    }

    @Nullable
    public static <C extends c.a.o0.a.c0.b.a> C b(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            c.a.o0.a.c0.e.a d2 = d(str);
            if (d2 == null) {
                d.b("Component-Finder", "find a null " + str2 + " : null component context");
                return null;
            }
            C c2 = (C) d2.a().f4701b.get(str2);
            if (c2 == null) {
                d.b("Component-Finder", "find a null " + str2 + " : not exist");
                return null;
            }
            return c2;
        }
        return (C) invokeLL.objValue;
    }

    @Nullable
    public static c.a.o0.a.c0.e.a c(c.a.o0.a.c0.b.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bVar)) == null) {
            if (bVar == null) {
                c.a.o0.a.c0.g.a.a("Component-Finder", "find component context with a null model");
                return null;
            }
            return d(bVar.f4630g);
        }
        return (c.a.o0.a.c0.e.a) invokeL.objValue;
    }

    @Nullable
    public static c.a.o0.a.c0.e.a d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                d.b("Component-Finder", "find component context with a null slave id");
                return null;
            }
            c.a.o0.a.p.e.d B = f.V().B(str);
            if (B instanceof c.a.o0.a.p.e.b) {
                return ((c.a.o0.a.p.e.b) B).c0();
            }
            return null;
        }
        return (c.a.o0.a.c0.e.a) invokeL.objValue;
    }
}
