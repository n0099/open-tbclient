package c.a.o0.g.f;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f10911a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized d a() {
        InterceptResult invokeV;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (e.class) {
                if (f10911a == null) {
                    f10911a = new d();
                }
                dVar = f10911a;
            }
            return dVar;
        }
        return (d) invokeV.objValue;
    }
}
