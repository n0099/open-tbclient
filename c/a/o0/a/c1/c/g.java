package c.a.o0.a.c1.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile f f4732a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized f a() {
        InterceptResult invokeV;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (g.class) {
                if (f4732a == null) {
                    f4732a = new f();
                }
                fVar = f4732a;
            }
            return fVar;
        }
        return (f) invokeV.objValue;
    }
}
