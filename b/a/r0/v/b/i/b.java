package b.a.r0.v.b.i;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f24191a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized a a() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (b.class) {
                if (f24191a == null) {
                    f24191a = new a();
                }
                aVar = f24191a;
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }
}
