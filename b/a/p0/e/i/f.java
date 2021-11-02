package b.a.p0.e.i;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f9630a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized e a() {
        InterceptResult invokeV;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (f.class) {
                if (f9630a == null) {
                    f9630a = new e();
                }
                eVar = f9630a;
            }
            return eVar;
        }
        return (e) invokeV.objValue;
    }
}
