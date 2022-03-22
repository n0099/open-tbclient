package c.a.n0.j.g0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public static volatile f a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized f a() {
        InterceptResult invokeV;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (g.class) {
                if (a == null) {
                    a = new f();
                }
                fVar = a;
            }
            return fVar;
        }
        return (f) invokeV.objValue;
    }
}
