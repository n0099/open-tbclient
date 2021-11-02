package b.a.p0.e.h;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f9629a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized a a() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (b.class) {
                if (f9629a == null) {
                    f9629a = new a();
                }
                aVar = f9629a;
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }
}
