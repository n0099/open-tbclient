package c.a.r0.n3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;
    public static volatile s a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized s a() {
        InterceptResult invokeV;
        s sVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (t.class) {
                if (a == null) {
                    a = new s();
                }
                sVar = a;
            }
            return sVar;
        }
        return (s) invokeV.objValue;
    }
}
