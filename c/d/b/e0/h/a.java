package c.d.b.e0.h;

import c.d.b.b0;
import c.d.b.e0.i.g;
import c.d.b.t;
import c.d.b.w;
import c.d.b.z;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes3.dex */
public final class a implements t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final w a;

    public a(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = wVar;
    }

    @Override // c.d.b.t
    public b0 a(t.a aVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            g gVar = (g) aVar;
            z request = gVar.request();
            f e2 = gVar.e();
            c.d.b.e0.i.c n = e2.n(this.a, aVar, !request.f().equals("GET"));
            c d2 = e2.d();
            if (e2.m()) {
                z.a g2 = request.g();
                g2.a("X-Fallback-Connection", e2.l() ? "1" : "0");
                request = g2.b();
            }
            return gVar.d(request, e2, n, d2);
        }
        return (b0) invokeL.objValue;
    }
}
