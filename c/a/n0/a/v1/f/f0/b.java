package c.a.n0.a.v1.f.f0;

import c.a.n0.a.t1.e;
import c.a.n0.a.t1.h;
import c.a.n0.a.t1.i;
import c.a.n0.a.t1.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public String f6682d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(h hVar) {
        super(hVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((h) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.n0.a.v1.f.f0.a
    public void H(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && L() && (str2 = this.f6682d) != null && str2.equals(str)) {
            c.a.n0.a.t1.d J = c.a.n0.a.t1.d.J();
            if (J.D()) {
                if (J.r().m0()) {
                    J.o("flag_finish_activity", "flag_remove_task");
                    return;
                }
                c.a.n0.a.k2.a aVar = new c.a.n0.a.k2.a();
                aVar.k(10L);
                aVar.i(2107L);
                aVar.d("app forbidden");
                k.x0(c.a.n0.q.f.a.i().u(str), c.a.n0.a.s0.a.c(), J.r().V(), false, null, aVar);
            }
        }
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (e.a0() == null || this.f6680b == 0) ? false : true : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.p2.g1.c
    /* renamed from: M */
    public void onCallback(i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            if (c.a.n0.a.o1.b.d.I(aVar.D(), "swan_forbidden_kill_on_client")) {
                this.f6680b = aVar.j("ipc_forbidden_flag", 1);
                this.f6682d = aVar.o("mAppId", c.a.n0.a.t1.d.J().getAppId());
            }
            if (c.a.n0.a.o1.b.d.I(aVar.D(), "swan_kill_to_client")) {
                c.a.n0.a.t1.d.J().o("flag_finish_activity", "flag_remove_task");
            }
        }
    }
}
