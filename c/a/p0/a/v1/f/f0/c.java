package c.a.p0.a.v1.f.f0;

import c.a.p0.a.t1.h;
import c.a.p0.a.t1.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(h hVar) {
        super(hVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((h) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.p0.a.v1.f.f0.a
    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            c.a.p0.a.o1.b.c w = c.a.p0.a.o1.b.d.P("swan_forbidden_kill_on_client").z("mAppId", str).w("ipc_forbidden_flag", this.f7893f);
            w.J(str);
            w.call();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.a.p2.g1.c
    /* renamed from: L */
    public void onCallback(i.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && c.a.p0.a.o1.b.d.I(aVar.D(), "swan_forbidden_kill_on_server")) {
            this.f7893f = aVar.j("ipc_forbidden_flag", 1);
            H(aVar.o("mAppId", c.a.p0.a.t1.d.J().getAppId()));
        }
    }
}
