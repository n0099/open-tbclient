package b.a.r.h.c.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a(byte[] bArr, b.a.r.h.b.e.a aVar) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, bArr, aVar)) == null) {
            b.a.r.h.b.a b2 = b.a.r.h.b.a.b();
            b2.c(2, aVar);
            return b2.a(bArr);
        }
        return (byte[]) invokeLL.objValue;
    }
}
