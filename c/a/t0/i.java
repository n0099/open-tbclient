package c.a.t0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile h f30083a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized h a() {
        InterceptResult invokeV;
        h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (i.class) {
                if (f30083a == null) {
                    f30083a = new h();
                }
                hVar = f30083a;
            }
            return hVar;
        }
        return (h) invokeV.objValue;
    }
}
