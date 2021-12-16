package c.a.q0.b.l;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class x {
    public static /* synthetic */ Interceptable $ic;
    public static volatile w a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized w a() {
        InterceptResult invokeV;
        w wVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (x.class) {
                if (a == null) {
                    a = new w();
                }
                wVar = a;
            }
            return wVar;
        }
        return (w) invokeV.objValue;
    }
}
