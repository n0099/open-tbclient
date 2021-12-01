package c.a.r0.n3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public static volatile i a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized i a() {
        InterceptResult invokeV;
        i iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (j.class) {
                if (a == null) {
                    a = new i();
                }
                iVar = a;
            }
            return iVar;
        }
        return (i) invokeV.objValue;
    }
}
