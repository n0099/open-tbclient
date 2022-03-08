package c.a.p0.a.s0.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;
    public static volatile l a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized l a() {
        InterceptResult invokeV;
        l lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (m.class) {
                if (a == null) {
                    a = new l();
                }
                lVar = a;
            }
            return lVar;
        }
        return (l) invokeV.objValue;
    }
}
