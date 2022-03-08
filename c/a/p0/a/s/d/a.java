package c.a.p0.a.s.d;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.u.d;
import c.a.p0.a.w0.f;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-65057960, "Lc/a/p0/a/s/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-65057960, "Lc/a/p0/a/s/d/a;");
                return;
            }
        }
        boolean z = c.a.p0.a.a.a;
    }

    @Nullable
    public static <C extends c.a.p0.a.s.b.a> C a(c.a.p0.a.s.b.b bVar) {
        InterceptResult invokeL;
        C c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            if (bVar == null) {
                c.a.p0.a.s.g.a.a("Component-Finder", "find a null component: null model");
                return null;
            }
            String e2 = bVar.e();
            String str = bVar.f7284g;
            if (TextUtils.isEmpty(str)) {
                d.c("Component-Finder", "find a null " + e2 + " : slaveId is empty");
                return null;
            }
            c.a.p0.a.s.e.a d2 = d(str);
            if (d2 == null) {
                d.c("Component-Finder", "find a null " + e2 + " : null component context");
                return null;
            }
            String str2 = bVar.f7283f;
            if (TextUtils.isEmpty(str2)) {
                d.o("Component-Finder", "find " + e2 + " with a empty componentId");
                List<c.a.p0.a.s.b.a> list = d2.a().f7347c.get(bVar.f7282e);
                if (list == null) {
                    d.c("Component-Finder", "find a null " + e2 + " with a empty componentId: fallbackComponents are null ");
                    return null;
                } else if (list.size() <= 0) {
                    d.c("Component-Finder", "find a null " + e2 + " with a empty componentId: fallbackComponents are empty ");
                    return null;
                } else {
                    d.o("Component-Finder", "find " + e2 + " with a empty componentId: fina a fallback component");
                    c2 = (C) list.get(0);
                }
            } else {
                c2 = (C) d2.a().f7346b.get(str2);
            }
            if (c2 == null) {
                d.c("Component-Finder", "find a null " + e2 + " : not exist");
                return null;
            }
            return c2;
        }
        return (C) invokeL.objValue;
    }

    @Nullable
    public static <C extends c.a.p0.a.s.b.a> C b(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            c.a.p0.a.s.e.a d2 = d(str);
            if (d2 == null) {
                d.c("Component-Finder", "find a null " + str2 + " : null component context");
                return null;
            }
            C c2 = (C) d2.a().f7346b.get(str2);
            if (c2 == null) {
                d.c("Component-Finder", "find a null " + str2 + " : not exist");
                return null;
            }
            return c2;
        }
        return (C) invokeLL.objValue;
    }

    @Nullable
    public static c.a.p0.a.s.e.a c(c.a.p0.a.s.b.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bVar)) == null) {
            if (bVar == null) {
                c.a.p0.a.s.g.a.a("Component-Finder", "find component context with a null model");
                return null;
            }
            return d(bVar.f7284g);
        }
        return (c.a.p0.a.s.e.a) invokeL.objValue;
    }

    @Nullable
    public static c.a.p0.a.s.e.a d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                d.c("Component-Finder", "find component context with a null slave id");
                return null;
            }
            c.a.p0.a.f.e.d A = f.U().A(str);
            if (A instanceof c.a.p0.a.f.e.b) {
                return ((c.a.p0.a.f.e.b) A).e0();
            }
            return null;
        }
        return (c.a.p0.a.s.e.a) invokeL.objValue;
    }
}
