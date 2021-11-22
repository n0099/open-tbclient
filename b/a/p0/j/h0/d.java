package b.a.p0.j.h0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f11173a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized c a() {
        InterceptResult invokeV;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (d.class) {
                if (f11173a == null) {
                    f11173a = new c();
                }
                cVar = f11173a;
            }
            return cVar;
        }
        return (c) invokeV.objValue;
    }
}
