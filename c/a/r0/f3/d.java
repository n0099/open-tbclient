package c.a.r0.f3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f17618a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized c a() {
        InterceptResult invokeV;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (d.class) {
                if (f17618a == null) {
                    f17618a = new c();
                }
                cVar = f17618a;
            }
            return cVar;
        }
        return (c) invokeV.objValue;
    }
}
