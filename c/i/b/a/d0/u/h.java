package c.i.b.a.d0.u;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.exoplayer2.upstream.HttpDataSource;
/* loaded from: classes4.dex */
public final class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(c.i.b.a.f0.f fVar, int i2, Exception exc) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, fVar, i2, exc)) == null) ? b(fVar, i2, exc, 60000L) : invokeLIL.booleanValue;
    }

    public static boolean b(c.i.b.a.f0.f fVar, int i2, Exception exc, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{fVar, Integer.valueOf(i2), exc, Long.valueOf(j2)})) == null) {
            if (c(exc)) {
                boolean g2 = fVar.g(i2, j2);
                int i3 = ((HttpDataSource.InvalidResponseCodeException) exc).responseCode;
                if (g2) {
                    String str = "Blacklisted: duration=" + j2 + ", responseCode=" + i3 + ", format=" + fVar.h(i2);
                } else {
                    String str2 = "Blacklisting failed (cannot blacklist last enabled track): responseCode=" + i3 + ", format=" + fVar.h(i2);
                }
                return g2;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean c(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, exc)) == null) {
            if (exc instanceof HttpDataSource.InvalidResponseCodeException) {
                int i2 = ((HttpDataSource.InvalidResponseCodeException) exc).responseCode;
                return i2 == 404 || i2 == 410;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
