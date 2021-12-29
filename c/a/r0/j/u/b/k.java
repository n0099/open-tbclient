package c.a.r0.j.u.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public static volatile j a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized j a() {
        InterceptResult invokeV;
        j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (k.class) {
                if (a == null) {
                    a = new j();
                }
                jVar = a;
            }
            return jVar;
        }
        return (j) invokeV.objValue;
    }
}
