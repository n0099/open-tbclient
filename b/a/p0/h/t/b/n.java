package b.a.p0.h.t.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile m f10746a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized m a() {
        InterceptResult invokeV;
        m mVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (n.class) {
                if (f10746a == null) {
                    f10746a = new m();
                }
                mVar = f10746a;
            }
            return mVar;
        }
        return (m) invokeV.objValue;
    }
}
