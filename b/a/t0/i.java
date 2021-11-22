package b.a.t0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile h f29657a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized h a() {
        InterceptResult invokeV;
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (i.class) {
                if (f29657a == null) {
                    f29657a = new h();
                }
                hVar = f29657a;
            }
            return hVar;
        }
        return (h) invokeV.objValue;
    }
}
