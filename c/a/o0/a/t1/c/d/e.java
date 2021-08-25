package c.a.o0.a.t1.c.d;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import c.a.o0.a.e2.c.i;
import c.a.o0.a.e2.c.j.f;
import c.a.o0.a.k;
import c.a.o0.a.u.e.a.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e extends c.a.o0.a.t1.c.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.o0.a.v2.e1.b<i<f.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.h0.j.b f8672e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.t1.c.c.a f8673f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.e2.d.a f8674g;

        public a(e eVar, c.a.o0.a.h0.j.b bVar, c.a.o0.a.t1.c.c.a aVar, c.a.o0.a.e2.d.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, bVar, aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8672e = bVar;
            this.f8673f = aVar;
            this.f8674g = aVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<f.d> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar != null && iVar.c() && !TextUtils.isEmpty(iVar.f5554a.f5572a)) {
                    JSONObject jSONObject = this.f8674g.f5590g;
                    if (jSONObject != null) {
                        try {
                            jSONObject.put("code", iVar.f5554a.f5572a);
                            this.f8673f.f8650d = true;
                        } catch (JSONException e2) {
                            if (k.f7049a) {
                                c.a.o0.a.t1.d.a.a(Log.getStackTraceString(e2));
                            }
                        }
                        this.f8673f.f8651e = jSONObject.toString();
                    }
                    this.f8672e.a(this.f8673f);
                    return;
                }
                c.a.o0.a.t1.d.a.a("login failure, can't get login code");
                this.f8672e.a(this.f8673f);
            }
        }
    }

    public e() {
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

    @Override // c.a.o0.a.t1.c.d.b
    public c.a.o0.a.u.h.b b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            return null;
        }
        return (c.a.o0.a.u.h.b) invokeL.objValue;
    }

    @Override // c.a.o0.a.t1.c.d.b
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "snsapi_userinfo" : (String) invokeV.objValue;
    }

    @Override // c.a.o0.a.t1.c.d.b
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "SwanPluginUserInfoFunPage" : (String) invokeV.objValue;
    }

    @Override // c.a.o0.a.t1.c.d.a
    public void p(SwanAppActivity swanAppActivity, String str, c.a.o0.a.t1.c.b.b bVar, c.a.o0.a.e2.d.a aVar, c.a.o0.a.h0.j.b<c.a.o0.a.t1.c.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, swanAppActivity, str, bVar, aVar, bVar2) == null) {
            c.a.o0.a.t1.c.c.a aVar2 = new c.a.o0.a.t1.c.c.a(bVar.f8643f);
            aVar2.f8647a = bVar.f8642e;
            if (aVar != null && aVar.f5593j.a() == 0) {
                c.a.o0.a.t1.d.a.a("obtain user info detail, get login code");
                c.C0382c c0382c = new c.C0382c(bVar.f8644g);
                Bundle bundle = new Bundle();
                bundle.putString("__plugin__", bVar.f8638a);
                c.a.o0.a.a2.d.g().r().T().r(swanAppActivity, c0382c, bundle, new a(this, bVar2, aVar2, aVar), "SwanPluginUserInfoFunPage");
                return;
            }
            c.a.o0.a.t1.d.a.a("open data result failure");
            bVar2.a(aVar2);
        }
    }
}
