package c.a.r0.h3.d0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i2, a aVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i2, aVar)) == null) {
            if (i2 <= 0) {
                return aVar.a();
            }
            if (aVar.c()) {
                return i2 + aVar.b();
            }
            return i2 + aVar.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i2, @NonNull a aVar, int i3, @Nullable T t, @Nullable c cVar, @Nullable d dVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i2), aVar, Integer.valueOf(i3), t, cVar, dVar})) == null) {
            if (aVar.a() != -1 && aVar.b() != -1) {
                int a = a(i3, aVar);
                if (cVar != null && t != null) {
                    if (i2 <= i3) {
                        if (dVar != 0) {
                            dVar.a(i2, a);
                        }
                        return false;
                    }
                    int i4 = i2 + 1;
                    if (i4 < a) {
                        if (dVar != 0) {
                            dVar.a(i2, a);
                        }
                        return false;
                    }
                    int i5 = i2 > a ? i4 : a;
                    int k2 = c.a.r0.w1.o.k.a.k(list);
                    if (i5 >= k2 && (cVar.d() || i5 > k2)) {
                        if (dVar != 0) {
                            dVar.d(i2, i5, k2, cVar, t);
                        }
                        return false;
                    }
                    cVar.a(i5);
                    if (cVar.d()) {
                        if (dVar != 0) {
                            dVar.e(i2, i5, c.a.r0.w1.o.k.a.d(list, i5), cVar, t);
                            return true;
                        }
                        return true;
                    }
                    c.a.r0.w1.o.k.a.b(list, t, i5);
                    if (dVar != 0) {
                        dVar.c(i2, i5, cVar, t);
                        return true;
                    }
                    return true;
                } else if (dVar != 0) {
                    dVar.a(i2, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
