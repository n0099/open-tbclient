package c.a.n0.a.s.d;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.u.d;
import c.a.n0.a.w0.f;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-766122538, "Lc/a/n0/a/s/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-766122538, "Lc/a/n0/a/s/d/a;");
                return;
            }
        }
        boolean z = c.a.n0.a.a.a;
    }

    @Nullable
    public static <C extends c.a.n0.a.s.b.a> C a(c.a.n0.a.s.b.b bVar) {
        InterceptResult invokeL;
        C c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            if (bVar == null) {
                c.a.n0.a.s.g.a.a("Component-Finder", "find a null component: null model");
                return null;
            }
            String d2 = bVar.d();
            String str = bVar.f6097c;
            if (TextUtils.isEmpty(str)) {
                d.c("Component-Finder", "find a null " + d2 + " : slaveId is empty");
                return null;
            }
            c.a.n0.a.s.e.a d3 = d(str);
            if (d3 == null) {
                d.c("Component-Finder", "find a null " + d2 + " : null component context");
                return null;
            }
            String str2 = bVar.f6096b;
            if (TextUtils.isEmpty(str2)) {
                d.o("Component-Finder", "find " + d2 + " with a empty componentId");
                List<c.a.n0.a.s.b.a> list = d3.a().f6142c.get(bVar.a);
                if (list == null) {
                    d.c("Component-Finder", "find a null " + d2 + " with a empty componentId: fallbackComponents are null ");
                    return null;
                } else if (list.size() <= 0) {
                    d.c("Component-Finder", "find a null " + d2 + " with a empty componentId: fallbackComponents are empty ");
                    return null;
                } else {
                    d.o("Component-Finder", "find " + d2 + " with a empty componentId: fina a fallback component");
                    c2 = (C) list.get(0);
                }
            } else {
                c2 = (C) d3.a().f6141b.get(str2);
            }
            if (c2 == null) {
                d.c("Component-Finder", "find a null " + d2 + " : not exist");
                return null;
            }
            return c2;
        }
        return (C) invokeL.objValue;
    }

    @Nullable
    public static <C extends c.a.n0.a.s.b.a> C b(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            c.a.n0.a.s.e.a d2 = d(str);
            if (d2 == null) {
                d.c("Component-Finder", "find a null " + str2 + " : null component context");
                return null;
            }
            C c2 = (C) d2.a().f6141b.get(str2);
            if (c2 == null) {
                d.c("Component-Finder", "find a null " + str2 + " : not exist");
                return null;
            }
            return c2;
        }
        return (C) invokeLL.objValue;
    }

    @Nullable
    public static c.a.n0.a.s.e.a c(c.a.n0.a.s.b.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bVar)) == null) {
            if (bVar == null) {
                c.a.n0.a.s.g.a.a("Component-Finder", "find component context with a null model");
                return null;
            }
            return d(bVar.f6097c);
        }
        return (c.a.n0.a.s.e.a) invokeL.objValue;
    }

    @Nullable
    public static c.a.n0.a.s.e.a d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                d.c("Component-Finder", "find component context with a null slave id");
                return null;
            }
            c.a.n0.a.f.e.d A = f.U().A(str);
            if (A instanceof c.a.n0.a.f.e.b) {
                return ((c.a.n0.a.f.e.b) A).f0();
            }
            return null;
        }
        return (c.a.n0.a.s.e.a) invokeL.objValue;
    }
}
