package c.a.q0.d3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f16887a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized c a() {
        InterceptResult invokeV;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (d.class) {
                if (f16887a == null) {
                    f16887a = new c();
                }
                cVar = f16887a;
            }
            return cVar;
        }
        return (c) invokeV.objValue;
    }
}
