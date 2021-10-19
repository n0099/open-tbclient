package c.a.r0.f3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile m f17627a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized m a() {
        InterceptResult invokeV;
        m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (n.class) {
                if (f17627a == null) {
                    f17627a = new m();
                }
                mVar = f17627a;
            }
            return mVar;
        }
        return (m) invokeV.objValue;
    }
}
