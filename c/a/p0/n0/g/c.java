package c.a.p0.n0.g;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes2.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends c.a.p0.n0.f.c.a> T a(c.a.p0.n0.f.c.b bVar, Class<T> type, c.b.a.a.d entity, c.a.p0.n0.e.a item) {
        InterceptResult invokeLLLL;
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, bVar, type, entity, item)) == null) {
            Intrinsics.checkNotNullParameter(bVar, "<this>");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(item, "item");
            c.b.a.a.c f2 = bVar.f();
            if (f2 == null || (t = (T) f2.h(type)) == null) {
                return null;
            }
            entity.a(t);
            t.b(item);
            return t;
        }
        return (T) invokeLLLL.objValue;
    }

    public static final long b(c.a.p0.n0.f.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            Intrinsics.checkNotNullParameter(bVar, "<this>");
            return d(bVar).a();
        }
        return invokeL.longValue;
    }

    public static final c.a.p0.n0.j.b c(c.a.p0.n0.f.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bVar)) == null) {
            Intrinsics.checkNotNullParameter(bVar, "<this>");
            return bVar.i().d();
        }
        return (c.a.p0.n0.j.b) invokeL.objValue;
    }

    public static final c.a.p0.n0.k.b d(c.a.p0.n0.f.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bVar)) == null) {
            Intrinsics.checkNotNullParameter(bVar, "<this>");
            return bVar.i().f();
        }
        return (c.a.p0.n0.k.b) invokeL.objValue;
    }

    public static final boolean e(c.a.p0.n0.f.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar)) == null) {
            Intrinsics.checkNotNullParameter(bVar, "<this>");
            c.b.a.a.c f2 = bVar.f();
            c.a.p0.n0.f.b bVar2 = f2 instanceof c.a.p0.n0.f.b ? (c.a.p0.n0.f.b) f2 : null;
            if (bVar2 == null) {
                return true;
            }
            return bVar2.x();
        }
        return invokeL.booleanValue;
    }
}
