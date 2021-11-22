package b.a.p0.a.f2.f.f0;

import b.a.p0.a.d2.e;
import b.a.p0.a.d2.h;
import b.a.p0.a.d2.i;
import b.a.p0.a.d2.k;
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

    /* renamed from: h  reason: collision with root package name */
    public String f4930h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(h hVar) {
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

    @Override // b.a.p0.a.f2.f.f0.a
    public void H(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && L() && (str2 = this.f4930h) != null && str2.equals(str)) {
            b.a.p0.a.d2.d J = b.a.p0.a.d2.d.J();
            if (J.D()) {
                if (J.r().m0()) {
                    J.o("flag_finish_activity", "flag_remove_task");
                    return;
                }
                b.a.p0.a.u2.a aVar = new b.a.p0.a.u2.a();
                aVar.k(10L);
                aVar.i(2107L);
                aVar.d("app forbidden");
                k.x0(b.a.p0.q.g.a.i().u(str), b.a.p0.a.c1.a.c(), J.r().V(), false, null, aVar);
            }
        }
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (e.a0() == null || this.f4928f == 0) ? false : true : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.z2.g1.c
    /* renamed from: M */
    public void onCallback(i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            if (b.a.p0.a.y1.b.d.I(aVar.D(), "swan_forbidden_kill_on_client")) {
                this.f4928f = aVar.j("ipc_forbidden_flag", 1);
                this.f4930h = aVar.o("mAppId", b.a.p0.a.d2.d.J().getAppId());
            }
            if (b.a.p0.a.y1.b.d.I(aVar.D(), "swan_kill_to_client")) {
                b.a.p0.a.d2.d.J().o("flag_finish_activity", "flag_remove_task");
            }
        }
    }
}
