package c.a.r0.f3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile s f17631a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized s a() {
        InterceptResult invokeV;
        s sVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (t.class) {
                if (f17631a == null) {
                    f17631a = new s();
                }
                sVar = f17631a;
            }
            return sVar;
        }
        return (s) invokeV.objValue;
    }
}
