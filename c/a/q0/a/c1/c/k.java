package c.a.q0.a.c1.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
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
