package b.a.p0.a.c2.f.g0;

import b.a.p0.a.a2.h;
import b.a.p0.a.a2.i;
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

    @Override // b.a.p0.a.c2.f.g0.a
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            b.a.p0.a.v1.b.b v = b.a.p0.a.v1.b.c.E("swan_forbidden_kill_on_client").y("mAppId", str).v("ipc_forbidden_flag", this.f4241f);
            v.I(str);
            v.call();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.v2.e1.b
    /* renamed from: i */
    public void onCallback(i.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) && b.a.p0.a.v1.b.c.f(aVar.C(), "swan_forbidden_kill_on_server")) {
            this.f4241f = aVar.j("ipc_forbidden_flag", 1);
            e(aVar.o("mAppId", b.a.p0.a.a2.d.g().getAppId()));
        }
    }
}
