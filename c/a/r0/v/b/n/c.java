package c.a.r0.v.b.n;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile b f25376a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized b a() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (c.class) {
                if (f25376a == null) {
                    f25376a = new b();
                }
                bVar = f25376a;
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }
}
