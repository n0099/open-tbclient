package c.p.a.e.b.m;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile c.p.a.e.b.g.n f35222a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile c.p.a.e.b.g.n f35223b;
    public transient /* synthetic */ FieldHolder $fh;

    public l() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static c.p.a.e.b.g.n a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65537, null, z)) == null) {
            if (z && c.p.a.e.b.g.e.s()) {
                if (f35223b == null) {
                    synchronized (l.class) {
                        if (f35223b == null) {
                            f35223b = c.p.a.e.b.g.e.t().b();
                        }
                    }
                }
                return f35223b;
            }
            if (f35222a == null) {
                synchronized (l.class) {
                    if (f35222a == null) {
                        f35222a = new o();
                    }
                }
            }
            return f35222a;
        }
        return (c.p.a.e.b.g.n) invokeZ.objValue;
    }
}
