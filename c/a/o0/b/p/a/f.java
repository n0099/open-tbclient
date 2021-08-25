package c.a.o0.b.p.a;

import android.content.Context;
import android.text.TextUtils;
import c.a.o0.a.c2.f.a0;
import c.a.o0.a.e2.c.i;
import c.a.o0.a.e2.c.j.a;
import c.a.o0.a.j2.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.o0.a.v2.e1.b<c.a.o0.a.e2.c.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10167e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f10168f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f10169g;

        public a(f fVar, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10169g = fVar;
            this.f10167e = callbackHandler;
            this.f10168f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.o0.a.e2.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                if (fVar == null || fVar.f5513d) {
                    this.f10169g.n(false, null, this.f10167e, this.f10168f, 10005, "system deny");
                    k.p(10005, fVar);
                    return;
                }
                this.f10169g.p(fVar, this.f10167e, this.f10168f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.o0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.e2.c.f f10170e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10171f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f10172g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ f f10173h;

        public b(f fVar, c.a.o0.a.e2.c.f fVar2, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, fVar2, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10173h = fVar;
            this.f10170e = fVar2;
            this.f10171f = callbackHandler;
            this.f10172g = str;
        }

        @Override // c.a.o0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (a0.f4738b) {
                    String str = "onResult: loginStatusCode = " + i2;
                }
                if (i2 == -2) {
                    this.f10173h.n(false, null, this.f10171f, this.f10172g, 20050002, "user did cancel login");
                } else if (i2 != 0) {
                    this.f10173h.n(false, null, this.f10171f, this.f10172g, 20050003, "user fail to login");
                } else {
                    this.f10173h.o(this.f10170e.f5512c, c.a.o0.a.g1.f.V().getActivity(), this.f10171f, this.f10172g);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.o0.a.v2.e1.b<i<a.b>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10174e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f10175f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f10176g;

        public c(f fVar, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10176g = fVar;
            this.f10174e = callbackHandler;
            this.f10175f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<a.b> iVar) {
            a.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar == null || !iVar.c() || (bVar = iVar.f5554a) == null || bVar.f5559c == null) {
                    this.f10176g.n(true, null, this.f10174e, this.f10175f, 20050004, "user fail to get mobile information");
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("data", iVar.f5554a.f5559c.optString("data"));
                    jSONObject.put("iv", iVar.f5554a.f5559c.optString("iv"));
                    this.f10176g.n(true, jSONObject, this.f10174e, this.f10175f, 0, "success");
                } catch (JSONException unused) {
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(c.a.o0.a.c2.e eVar) {
        super(eVar, "/swanAPI/getPhoneNumberByLogin");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty params");
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            }
            c.a.o0.a.m.b j2 = c.a.o0.a.a2.d.g().r().j();
            if (j2 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty account");
                return false;
            }
            if (j2.e(context)) {
                n(true, null, callbackHandler, optString, 20050001, "user already login");
            } else {
                eVar.T().e("login_with_mobile", new a(this, callbackHandler, optString));
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void n(boolean z, JSONObject jSONObject, CallbackHandler callbackHandler, String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), jSONObject, callbackHandler, str, Integer.valueOf(i2), str2}) == null) {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject2.put("loginState", z);
                if (jSONObject != null) {
                    jSONObject2.put("mobile", jSONObject);
                }
                jSONObject3 = UnitedSchemeUtility.wrapCallbackParams(jSONObject2, i2, str2);
            } catch (JSONException unused) {
            }
            callbackHandler.handleSchemeDispatchCallback(str, jSONObject3.toString());
        }
    }

    public final void o(boolean z, FragmentActivity fragmentActivity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), fragmentActivity, callbackHandler, str}) == null) {
            if (z) {
                c.a.o0.a.e2.c.j.a a2 = c.a.o0.a.a2.d.g().y().a().b().a(fragmentActivity, z, "login_with_mobile", null);
                a2.p(new c(this, callbackHandler, str));
                a2.a();
                return;
            }
            n(true, null, callbackHandler, str, 20050004, "user fail to get mobile information");
        }
    }

    public final void p(c.a.o0.a.e2.c.f fVar, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, fVar, callbackHandler, str) == null) {
            new c.a.o0.b.p.d.a().h(new b(this, fVar, callbackHandler, str));
        }
    }
}
