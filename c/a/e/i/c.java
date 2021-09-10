package c.a.e.i;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f2893a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized b a() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (c.class) {
                if (f2893a == null) {
                    f2893a = new b();
                }
                bVar = f2893a;
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }
}
