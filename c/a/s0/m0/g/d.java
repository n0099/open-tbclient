package c.a.s0.m0.g;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final c.a.s0.m0.f.d.d.b a(c.b.a.a.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, dVar)) == null) {
            Intrinsics.checkNotNullParameter(dVar, "<this>");
            return (c.a.s0.m0.f.d.d.b) dVar.d(c.a.s0.m0.f.d.d.b.class);
        }
        return (c.a.s0.m0.f.d.d.b) invokeL.objValue;
    }

    public static final c.a.s0.m0.f.d.b b(c.b.a.a.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, dVar)) == null) {
            Intrinsics.checkNotNullParameter(dVar, "<this>");
            return (c.a.s0.m0.f.d.b) dVar.d(c.a.s0.m0.f.d.b.class);
        }
        return (c.a.s0.m0.f.d.b) invokeL.objValue;
    }

    public static final long c(c.b.a.a.d dVar) {
        InterceptResult invokeL;
        c.a.s0.m0.e.a a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, dVar)) == null) {
            Intrinsics.checkNotNullParameter(dVar, "<this>");
            c.a.s0.m0.f.d.b b2 = b(dVar);
            if (b2 == null || (a = b2.a()) == null) {
                return 0L;
            }
            return a.g();
        }
        return invokeL.longValue;
    }

    public static final c.a.s0.m0.f.d.a d(c.b.a.a.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, dVar)) == null) {
            Intrinsics.checkNotNullParameter(dVar, "<this>");
            return (c.a.s0.m0.f.d.a) dVar.d(c.a.s0.m0.f.d.a.class);
        }
        return (c.a.s0.m0.f.d.a) invokeL.objValue;
    }

    public static final c.a.s0.m0.f.d.c e(c.b.a.a.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, dVar)) == null) {
            Intrinsics.checkNotNullParameter(dVar, "<this>");
            return (c.a.s0.m0.f.d.c) dVar.d(c.a.s0.m0.f.d.c.class);
        }
        return (c.a.s0.m0.f.d.c) invokeL.objValue;
    }

    public static final long f(c.b.a.a.d dVar) {
        InterceptResult invokeL;
        c.a.s0.m0.e.a a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, dVar)) == null) {
            Intrinsics.checkNotNullParameter(dVar, "<this>");
            c.a.s0.m0.f.d.b b2 = b(dVar);
            if (b2 == null || (a = b2.a()) == null) {
                return 0L;
            }
            return a.j();
        }
        return invokeL.longValue;
    }

    public static final boolean g(c.b.a.a.d dVar, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65542, null, dVar, j2)) == null) {
            Intrinsics.checkNotNullParameter(dVar, "<this>");
            return j2 - f(dVar) < 0;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean h(c.b.a.a.d dVar, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65543, null, dVar, j2)) == null) {
            Intrinsics.checkNotNullParameter(dVar, "<this>");
            return j2 - f(dVar) > c(dVar);
        }
        return invokeLJ.booleanValue;
    }
}
