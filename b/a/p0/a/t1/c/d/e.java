package b.a.p0.a.t1.c.d;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import b.a.p0.a.e2.c.i;
import b.a.p0.a.e2.c.j.f;
import b.a.p0.a.k;
import b.a.p0.a.u.e.a.c;
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
public class e extends b.a.p0.a.t1.c.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.v2.e1.b<i<f.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.h0.j.b f7974e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.t1.c.c.a f7975f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.e2.d.a f7976g;

        public a(e eVar, b.a.p0.a.h0.j.b bVar, b.a.p0.a.t1.c.c.a aVar, b.a.p0.a.e2.d.a aVar2) {
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
            this.f7974e = bVar;
            this.f7975f = aVar;
            this.f7976g = aVar2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<f.d> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar != null && iVar.c() && !TextUtils.isEmpty(iVar.f4946a.f4964a)) {
                    JSONObject jSONObject = this.f7976g.f4981g;
                    if (jSONObject != null) {
                        try {
                            jSONObject.put("code", iVar.f4946a.f4964a);
                            this.f7975f.f7952d = true;
                        } catch (JSONException e2) {
                            if (k.f6397a) {
                                b.a.p0.a.t1.d.a.a(Log.getStackTraceString(e2));
                            }
                        }
                        this.f7975f.f7953e = jSONObject.toString();
                    }
                    this.f7974e.a(this.f7975f);
                    return;
                }
                b.a.p0.a.t1.d.a.a("login failure, can't get login code");
                this.f7974e.a(this.f7975f);
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

    @Override // b.a.p0.a.t1.c.d.b
    public b.a.p0.a.u.h.b b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            return null;
        }
        return (b.a.p0.a.u.h.b) invokeL.objValue;
    }

    @Override // b.a.p0.a.t1.c.d.b
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "snsapi_userinfo" : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.t1.c.d.b
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "SwanPluginUserInfoFunPage" : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.t1.c.d.a
    public void p(SwanAppActivity swanAppActivity, String str, b.a.p0.a.t1.c.b.b bVar, b.a.p0.a.e2.d.a aVar, b.a.p0.a.h0.j.b<b.a.p0.a.t1.c.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, swanAppActivity, str, bVar, aVar, bVar2) == null) {
            b.a.p0.a.t1.c.c.a aVar2 = new b.a.p0.a.t1.c.c.a(bVar.f7945f);
            aVar2.f7949a = bVar.f7944e;
            if (aVar != null && aVar.j.a() == 0) {
                b.a.p0.a.t1.d.a.a("obtain user info detail, get login code");
                c.C0379c c0379c = new c.C0379c(bVar.f7946g);
                Bundle bundle = new Bundle();
                bundle.putString("__plugin__", bVar.f7940a);
                b.a.p0.a.a2.d.g().r().S().r(swanAppActivity, c0379c, bundle, new a(this, bVar2, aVar2, aVar), "SwanPluginUserInfoFunPage");
                return;
            }
            b.a.p0.a.t1.d.a.a("open data result failure");
            bVar2.a(aVar2);
        }
    }
}
