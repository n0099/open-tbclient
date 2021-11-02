package b.a.p0.a.c1.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f4132a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized a a() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (b.class) {
                if (f4132a == null) {
                    f4132a = new a();
                }
                aVar = f4132a;
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }
}
