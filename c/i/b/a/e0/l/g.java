package c.i.b.a.e0.l;

import c.i.b.a.a0.m;
import c.i.b.a.i0.l;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(long j2, l lVar, m[] mVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{Long.valueOf(j2), lVar, mVarArr}) == null) {
            while (lVar.a() > 1) {
                int c2 = c(lVar);
                int c3 = c(lVar);
                if (c3 != -1 && c3 <= lVar.a()) {
                    if (b(c2, c3, lVar)) {
                        lVar.K(8);
                        lVar.K(1);
                        int x = (lVar.x() & 31) * 3;
                        int c4 = lVar.c();
                        for (m mVar : mVarArr) {
                            lVar.J(c4);
                            mVar.a(lVar, x);
                            mVar.c(j2, 1, x, 0, null);
                        }
                        lVar.K(c3 - (x + 10));
                    } else {
                        lVar.K(c3);
                    }
                } else {
                    lVar.J(lVar.d());
                }
            }
        }
    }

    public static boolean b(int i2, int i3, l lVar) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65537, null, i2, i3, lVar)) == null) {
            if (i2 != 4 || i3 < 8) {
                return false;
            }
            int c2 = lVar.c();
            int x = lVar.x();
            int D = lVar.D();
            int i4 = lVar.i();
            int x2 = lVar.x();
            lVar.J(c2);
            return x == 181 && D == 49 && i4 == 1195456820 && x2 == 3;
        }
        return invokeIIL.booleanValue;
    }

    public static int c(l lVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, lVar)) == null) {
            int i2 = 0;
            while (lVar.a() != 0) {
                int x = lVar.x();
                i2 += x;
                if (x != 255) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }
}
