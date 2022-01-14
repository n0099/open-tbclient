package c.a.r0.a.w1.d.d;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import c.a.r0.a.h2.c.i;
import c.a.r0.a.h2.c.j.f;
import c.a.r0.a.k;
import c.a.r0.a.u.e.a.d;
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
public class e extends c.a.r0.a.w1.d.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.r0.a.z2.g1.c<i<f.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.h0.j.b f9542e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.w1.d.c.a f9543f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.h2.d.a f9544g;

        public a(e eVar, c.a.r0.a.h0.j.b bVar, c.a.r0.a.w1.d.c.a aVar, c.a.r0.a.h2.d.a aVar2) {
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
            this.f9542e = bVar;
            this.f9543f = aVar;
            this.f9544g = aVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<f.d> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar != null && iVar.c() && !TextUtils.isEmpty(iVar.a.a)) {
                    JSONObject jSONObject = this.f9544g.f7190g;
                    if (jSONObject != null) {
                        try {
                            jSONObject.put("code", iVar.a.a);
                            this.f9543f.f9524d = true;
                        } catch (JSONException e2) {
                            if (k.a) {
                                c.a.r0.a.w1.e.a.b(Log.getStackTraceString(e2));
                            }
                        }
                        this.f9543f.f9525e = jSONObject.toString();
                    }
                    this.f9542e.a(this.f9543f);
                    return;
                }
                c.a.r0.a.w1.e.a.b("login failure, can't get login code");
                this.f9542e.a(this.f9543f);
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

    @Override // c.a.r0.a.w1.d.d.b
    public c.a.r0.a.u.h.b b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            return null;
        }
        return (c.a.r0.a.u.h.b) invokeL.objValue;
    }

    @Override // c.a.r0.a.w1.d.d.b
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "snsapi_userinfo" : (String) invokeV.objValue;
    }

    @Override // c.a.r0.a.w1.d.d.b
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "SwanPluginUserInfoFunPage" : (String) invokeV.objValue;
    }

    @Override // c.a.r0.a.w1.d.d.a
    public void p(SwanAppActivity swanAppActivity, String str, c.a.r0.a.w1.d.b.b bVar, c.a.r0.a.h2.d.a aVar, c.a.r0.a.h0.j.b<c.a.r0.a.w1.d.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, swanAppActivity, str, bVar, aVar, bVar2) == null) {
            c.a.r0.a.w1.d.c.a aVar2 = new c.a.r0.a.w1.d.c.a(bVar.f9518f);
            aVar2.a = bVar.f9517e;
            if (aVar != null && aVar.f7193j.a() == 0) {
                c.a.r0.a.w1.e.a.b("obtain user info detail, get login code");
                d.C0561d c0561d = new d.C0561d(bVar.f9519g);
                Bundle bundle = new Bundle();
                bundle.putString("__plugin__", bVar.a);
                c.a.r0.a.d2.d.J().r().d0().r(swanAppActivity, c0561d, bundle, new a(this, bVar2, aVar2, aVar), "SwanPluginUserInfoFunPage");
                return;
            }
            c.a.r0.a.w1.e.a.b("open data result failure");
            bVar2.a(aVar2);
        }
    }
}
