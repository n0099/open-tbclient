package b.a.p0.b.l;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class x {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile w f9359a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized w a() {
        InterceptResult invokeV;
        w wVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (x.class) {
                if (f9359a == null) {
                    f9359a = new w();
                }
                wVar = f9359a;
            }
            return wVar;
        }
        return (w) invokeV.objValue;
    }
}
