package c.a.o0.j;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile i f11679a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized i a() {
        InterceptResult invokeV;
        i iVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (j.class) {
                if (f11679a == null) {
                    f11679a = new i();
                }
                iVar = f11679a;
            }
            return iVar;
        }
        return (i) invokeV.objValue;
    }
}
