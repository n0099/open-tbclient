package c.a.o0.e.p;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f10413a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized c a() {
        InterceptResult invokeV;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (d.class) {
                if (f10413a == null) {
                    f10413a = new c();
                }
                cVar = f10413a;
            }
            return cVar;
        }
        return (c) invokeV.objValue;
    }
}
