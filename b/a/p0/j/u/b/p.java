package b.a.p0.j.u.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile o f11468a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized o a() {
        InterceptResult invokeV;
        o oVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (p.class) {
                if (f11468a == null) {
                    f11468a = new o();
                }
                oVar = f11468a;
            }
            return oVar;
        }
        return (o) invokeV.objValue;
    }
}
