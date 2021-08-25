package c.a.q0.d3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile g f16890a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized g a() {
        InterceptResult invokeV;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (h.class) {
                if (f16890a == null) {
                    f16890a = new g();
                }
                gVar = f16890a;
            }
            return gVar;
        }
        return (g) invokeV.objValue;
    }
}
