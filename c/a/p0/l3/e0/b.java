package c.a.p0.l3.e0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, a aVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i, aVar)) == null) {
            if (i <= 0) {
                return aVar.a();
            }
            if (aVar.c()) {
                return i + aVar.b();
            }
            return i + aVar.b() + 1;
        }
        return invokeIL.intValue;
    }

    public static <T> boolean b(@NonNull List<T> list, int i, @NonNull a aVar, int i2, @Nullable T t, @Nullable c cVar, @Nullable d dVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{list, Integer.valueOf(i), aVar, Integer.valueOf(i2), t, cVar, dVar})) == null) {
            if (aVar.a() != -1 && aVar.b() != -1) {
                int a = a(i2, aVar);
                if (cVar != null && t != null) {
                    if (i <= i2) {
                        if (dVar != 0) {
                            dVar.a(i, a);
                        }
                        return false;
                    }
                    int i3 = i + 1;
                    if (i3 < a) {
                        if (dVar != 0) {
                            dVar.a(i, a);
                        }
                        return false;
                    }
                    int i4 = i > a ? i3 : a;
                    int k = c.a.p0.b2.o.k.a.k(list);
                    if (i4 >= k && (cVar.b() || i4 > k)) {
                        if (dVar != 0) {
                            dVar.d(i, i4, k, cVar, t);
                        }
                        return false;
                    }
                    cVar.a(i4);
                    if (cVar.b()) {
                        if (dVar != 0) {
                            dVar.e(i, i4, c.a.p0.b2.o.k.a.d(list, i4), cVar, t);
                            return true;
                        }
                        return true;
                    }
                    c.a.p0.b2.o.k.a.b(list, t, i4);
                    if (dVar != 0) {
                        dVar.c(i, i4, cVar, t);
                        return true;
                    }
                    return true;
                } else if (dVar != 0) {
                    dVar.a(i, a);
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}
