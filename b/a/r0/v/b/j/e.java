package b.a.r0.v.b.j;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f24209a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized d a() {
        InterceptResult invokeV;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (e.class) {
                if (f24209a == null) {
                    f24209a = new d();
                }
                dVar = f24209a;
            }
            return dVar;
        }
        return (d) invokeV.objValue;
    }
}
