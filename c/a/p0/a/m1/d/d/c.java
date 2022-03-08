package c.a.p0.a.m1.d.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends c.a.p0.a.m1.d.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.p0.a.d.a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.a.m1.d.c.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.x.j.b f6508b;

        public a(c cVar, c.a.p0.a.m1.d.c.a aVar, c.a.p0.a.x.j.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.f6508b = bVar;
        }

        @Override // c.a.p0.a.d.a.b
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                c.a.p0.a.m1.e.a.b("obtain address failure, errCode = " + i2);
                this.f6508b.a(this.a);
            }
        }

        @Override // c.a.p0.a.d.a.b
        public void b(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                c.a.p0.a.m1.e.a.b("obtain address success");
                c.a.p0.a.m1.d.c.a aVar = this.a;
                aVar.f6494d = true;
                if (jSONObject != null) {
                    aVar.f6495e = jSONObject.toString();
                }
                this.f6508b.a(this.a);
            }
        }
    }

    public c() {
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

    @Override // c.a.p0.a.m1.d.d.b
    public c.a.p0.a.k.h.b b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            return null;
        }
        return (c.a.p0.a.k.h.b) invokeL.objValue;
    }

    @Override // c.a.p0.a.m1.d.d.b
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "mapp_choose_address" : (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.m1.d.d.b
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "SwanPluginAddressFunPage" : (String) invokeV.objValue;
    }

    @Override // c.a.p0.a.m1.d.d.a
    public void p(SwanAppActivity swanAppActivity, String str, c.a.p0.a.m1.d.b.b bVar, c.a.p0.a.x1.d.a aVar, c.a.p0.a.x.j.b<c.a.p0.a.m1.d.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, swanAppActivity, str, bVar, aVar, bVar2) == null) {
            c.a.p0.a.m1.d.c.a aVar2 = new c.a.p0.a.m1.d.c.a(bVar.f6488f);
            aVar2.a = bVar.f6487e;
            if (aVar != null && aVar.f9168j.a() != LightappBusinessClient.SVC_ID_H5_TRANSERECORD) {
                c.a.p0.a.m1.e.a.b("obtain address detail");
                c.a.p0.a.s0.a.j0().a(swanAppActivity, str, str, new a(this, aVar2, bVar2));
                return;
            }
            c.a.p0.a.m1.e.a.b("user denied");
            bVar2.a(aVar2);
        }
    }
}
