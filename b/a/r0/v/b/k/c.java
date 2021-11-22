package b.a.r0.v.b.k;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f25673a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized b a() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (c.class) {
                if (f25673a == null) {
                    f25673a = new b();
                }
                bVar = f25673a;
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }
}
