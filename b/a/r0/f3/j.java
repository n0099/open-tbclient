package b.a.r0.f3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile i f16591a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized i a() {
        InterceptResult invokeV;
        i iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (j.class) {
                if (f16591a == null) {
                    f16591a = new i();
                }
                iVar = f16591a;
            }
            return iVar;
        }
        return (i) invokeV.objValue;
    }
}
