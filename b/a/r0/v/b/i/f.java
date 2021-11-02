package b.a.r0.v.b.i;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile e f24200a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized e a() {
        InterceptResult invokeV;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (f.class) {
                if (f24200a == null) {
                    f24200a = new e();
                }
                eVar = f24200a;
            }
            return eVar;
        }
        return (e) invokeV.objValue;
    }
}
