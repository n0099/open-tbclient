package b.a.p0.a.c1.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile l f4302a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized l a() {
        InterceptResult invokeV;
        l lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (m.class) {
                if (f4302a == null) {
                    f4302a = new l();
                }
                lVar = f4302a;
            }
            return lVar;
        }
        return (l) invokeV.objValue;
    }
}
