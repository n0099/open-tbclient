package c.a.b0.s.h0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public static volatile m a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized m a() {
        InterceptResult invokeV;
        m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (n.class) {
                if (a == null) {
                    a = new m();
                }
                mVar = a;
            }
            return mVar;
        }
        return (m) invokeV.objValue;
    }
}
