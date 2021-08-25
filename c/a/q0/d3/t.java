package c.a.q0.d3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile s f16900a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized s a() {
        InterceptResult invokeV;
        s sVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (t.class) {
                if (f16900a == null) {
                    f16900a = new s();
                }
                sVar = f16900a;
            }
            return sVar;
        }
        return (s) invokeV.objValue;
    }
}
