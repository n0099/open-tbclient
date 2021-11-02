package b.a.p0.f.j.m;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f9949a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized d a() {
        InterceptResult invokeV;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (e.class) {
                if (f9949a == null) {
                    f9949a = new d();
                }
                dVar = f9949a;
            }
            return dVar;
        }
        return (d) invokeV.objValue;
    }
}
