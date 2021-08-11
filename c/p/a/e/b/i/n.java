package c.p.a.e.b.i;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes4.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long a(@NonNull List<i> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, list)) == null) {
            int size = list.size();
            long j2 = 0;
            for (int i2 = 0; i2 < size; i2++) {
                i iVar = list.get(i2);
                if (iVar.h() > j2) {
                    break;
                }
                if (iVar.l() > j2) {
                    j2 = iVar.l();
                }
            }
            return j2;
        }
        return invokeL.longValue;
    }

    public static long b(@NonNull List<i> list) {
        InterceptResult invokeL;
        long j2;
        long j3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, list)) == null) {
            long j4 = 0;
            loop0: while (true) {
                j2 = -1;
                j3 = -1;
                for (i iVar : list) {
                    if (j2 == -1) {
                        if (iVar.a() > 0) {
                            j2 = iVar.h();
                            j3 = iVar.j();
                        }
                    } else if (iVar.h() <= j3) {
                        if (iVar.j() > j3) {
                            j3 = iVar.j();
                        }
                    } else {
                        j4 += j3 - j2;
                        if (iVar.a() > 0) {
                            j2 = iVar.h();
                            j3 = iVar.j();
                        }
                    }
                }
            }
            return (j2 < 0 || j3 <= j2) ? j4 : j4 + (j3 - j2);
        }
        return invokeL.longValue;
    }
}
