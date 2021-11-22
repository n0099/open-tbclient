package b.a.p0.a.c0.d;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.e0.d;
import b.a.p0.a.g1.f;
import b.a.p0.a.k;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1454762353, "Lb/a/p0/a/c0/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1454762353, "Lb/a/p0/a/c0/d/a;");
                return;
            }
        }
        boolean z = k.f6863a;
    }

    @Nullable
    public static <C extends b.a.p0.a.c0.b.a> C a(b.a.p0.a.c0.b.b bVar) {
        InterceptResult invokeL;
        C c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            if (bVar == null) {
                b.a.p0.a.c0.g.a.a("Component-Finder", "find a null component: null model");
                return null;
            }
            String e2 = bVar.e();
            String str = bVar.f4197g;
            if (TextUtils.isEmpty(str)) {
                d.c("Component-Finder", "find a null " + e2 + " : slaveId is empty");
                return null;
            }
            b.a.p0.a.c0.e.a d2 = d(str);
            if (d2 == null) {
                d.c("Component-Finder", "find a null " + e2 + " : null component context");
                return null;
            }
            String str2 = bVar.f4196f;
            if (TextUtils.isEmpty(str2)) {
                d.o("Component-Finder", "find " + e2 + " with a empty componentId");
                List<b.a.p0.a.c0.b.a> list = d2.a().f4269c.get(bVar.f4195e);
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
                c2 = (C) d2.a().f4268b.get(str2);
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
    public static <C extends b.a.p0.a.c0.b.a> C b(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            b.a.p0.a.c0.e.a d2 = d(str);
            if (d2 == null) {
                d.c("Component-Finder", "find a null " + str2 + " : null component context");
                return null;
            }
            C c2 = (C) d2.a().f4268b.get(str2);
            if (c2 == null) {
                d.c("Component-Finder", "find a null " + str2 + " : not exist");
                return null;
            }
            return c2;
        }
        return (C) invokeLL.objValue;
    }

    @Nullable
    public static b.a.p0.a.c0.e.a c(b.a.p0.a.c0.b.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bVar)) == null) {
            if (bVar == null) {
                b.a.p0.a.c0.g.a.a("Component-Finder", "find component context with a null model");
                return null;
            }
            return d(bVar.f4197g);
        }
        return (b.a.p0.a.c0.e.a) invokeL.objValue;
    }

    @Nullable
    public static b.a.p0.a.c0.e.a d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                d.c("Component-Finder", "find component context with a null slave id");
                return null;
            }
            b.a.p0.a.p.e.d A = f.U().A(str);
            if (A instanceof b.a.p0.a.p.e.b) {
                return ((b.a.p0.a.p.e.b) A).e0();
            }
            return null;
        }
        return (b.a.p0.a.c0.e.a) invokeL.objValue;
    }
}
