package b.a.r0.f3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile s f16597a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized s a() {
        InterceptResult invokeV;
        s sVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (t.class) {
                if (f16597a == null) {
                    f16597a = new s();
                }
                sVar = f16597a;
            }
            return sVar;
        }
        return (s) invokeV.objValue;
    }
}
