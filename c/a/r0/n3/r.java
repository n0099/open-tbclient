package c.a.r0.n3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;
    public static volatile q a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized q a() {
        InterceptResult invokeV;
        q qVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (r.class) {
                if (a == null) {
                    a = new q();
                }
                qVar = a;
            }
            return qVar;
        }
        return (q) invokeV.objValue;
    }
}
