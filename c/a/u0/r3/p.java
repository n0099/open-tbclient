package c.a.u0.r3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public static volatile o a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized o a() {
        InterceptResult invokeV;
        o oVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (p.class) {
                if (a == null) {
                    a = new o();
                }
                oVar = a;
            }
            return oVar;
        }
        return (o) invokeV.objValue;
    }
}
