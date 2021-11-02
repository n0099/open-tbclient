package b.a.r0.f3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile q f16596a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized q a() {
        InterceptResult invokeV;
        q qVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (r.class) {
                if (f16596a == null) {
                    f16596a = new q();
                }
                qVar = f16596a;
            }
            return qVar;
        }
        return (q) invokeV.objValue;
    }
}
