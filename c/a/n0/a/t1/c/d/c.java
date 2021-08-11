package c.a.n0.a.t1.c.d;

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
public class c extends c.a.n0.a.t1.c.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.n0.a.n.a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.t1.c.c.a f8421a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.h0.j.b f8422b;

        public a(c cVar, c.a.n0.a.t1.c.c.a aVar, c.a.n0.a.h0.j.b bVar) {
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
            this.f8421a = aVar;
            this.f8422b = bVar;
        }

        @Override // c.a.n0.a.n.a.b
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                c.a.n0.a.t1.d.a.a("obtain address failure, errCode = " + i2);
                this.f8422b.a(this.f8421a);
            }
        }

        @Override // c.a.n0.a.n.a.b
        public void b(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                c.a.n0.a.t1.d.a.a("obtain address success");
                c.a.n0.a.t1.c.c.a aVar = this.f8421a;
                aVar.f8404d = true;
                if (jSONObject != null) {
                    aVar.f8405e = jSONObject.toString();
                }
                this.f8422b.a(this.f8421a);
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

    @Override // c.a.n0.a.t1.c.d.b
    public c.a.n0.a.u.h.b b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            return null;
        }
        return (c.a.n0.a.u.h.b) invokeL.objValue;
    }

    @Override // c.a.n0.a.t1.c.d.b
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "mapp_choose_address" : (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.t1.c.d.b
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "SwanPluginAddressFunPage" : (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.t1.c.d.a
    public void p(SwanAppActivity swanAppActivity, String str, c.a.n0.a.t1.c.b.b bVar, c.a.n0.a.e2.d.a aVar, c.a.n0.a.h0.j.b<c.a.n0.a.t1.c.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, swanAppActivity, str, bVar, aVar, bVar2) == null) {
            c.a.n0.a.t1.c.c.a aVar2 = new c.a.n0.a.t1.c.c.a(bVar.f8397f);
            aVar2.f8401a = bVar.f8396e;
            if (aVar != null && aVar.f5347j.a() != LightappBusinessClient.SVC_ID_H5_TRANSERECORD) {
                c.a.n0.a.t1.d.a.a("obtain address detail");
                c.a.n0.a.c1.a.c0().a(swanAppActivity, str, str, new a(this, aVar2, bVar2));
                return;
            }
            c.a.n0.a.t1.d.a.a("user denied");
            bVar2.a(aVar2);
        }
    }
}
