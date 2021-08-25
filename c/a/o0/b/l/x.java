package c.a.o0.b.l;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class x {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile w f10098a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized w a() {
        InterceptResult invokeV;
        w wVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (x.class) {
                if (f10098a == null) {
                    f10098a = new w();
                }
                wVar = f10098a;
            }
            return wVar;
        }
        return (w) invokeV.objValue;
    }
}
