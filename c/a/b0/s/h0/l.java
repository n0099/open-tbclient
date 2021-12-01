package c.a.b0.s.h0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;
    public static volatile k a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized k a() {
        InterceptResult invokeV;
        k kVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (l.class) {
                if (a == null) {
                    a = new k();
                }
                kVar = a;
            }
            return kVar;
        }
        return (k) invokeV.objValue;
    }
}
