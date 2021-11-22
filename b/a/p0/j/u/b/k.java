package b.a.p0.j.u.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile j f11466a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized j a() {
        InterceptResult invokeV;
        j jVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (k.class) {
                if (f11466a == null) {
                    f11466a = new j();
                }
                jVar = f11466a;
            }
            return jVar;
        }
        return (j) invokeV.objValue;
    }
}
