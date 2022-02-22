package c.a.t0.b1.i;

import c.a.t0.b1.e.c;
import c.a.t0.b1.e.d;
import com.baidu.adp.BdUniqueId;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public abstract class b<Q extends c.a.t0.b1.e.c, P extends c.a.t0.b1.e.d> extends a implements e<P> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h(BdUniqueId bdUniqueId);

    public abstract void i(c.a.t0.b1.b bVar);
}
