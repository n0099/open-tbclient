package c.a.p0.b.p.a;

import android.content.Context;
import android.text.TextUtils;
import c.a.p0.a.f2.f.z;
import c.a.p0.a.h2.c.i;
import c.a.p0.a.h2.c.j.a;
import c.a.p0.a.n2.n;
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
/* loaded from: classes5.dex */
public class f extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements c.a.p0.a.z2.g1.c<c.a.p0.a.h2.c.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9325e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9326f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f9327g;

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
            this.f9327g = fVar;
            this.f9325e = callbackHandler;
            this.f9326f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.h2.c.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                if (fVar == null || fVar.f6237d) {
                    this.f9327g.n(false, null, this.f9325e, this.f9326f, 10005, "system deny");
                    n.r(10005, fVar);
                    return;
                }
                this.f9327g.p(fVar, this.f9325e, this.f9326f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements c.a.p0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h2.c.f f9328e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9329f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f9330g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ f f9331h;

        public b(f fVar, c.a.p0.a.h2.c.f fVar2, CallbackHandler callbackHandler, String str) {
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
            this.f9331h = fVar;
            this.f9328e = fVar2;
            this.f9329f = callbackHandler;
            this.f9330g = str;
        }

        @Override // c.a.p0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (z.f5296b) {
                    String str = "onResult: loginStatusCode = " + i2;
                }
                if (i2 == -2) {
                    this.f9331h.n(false, null, this.f9329f, this.f9330g, 20050002, "user did cancel login");
                } else if (i2 != 0) {
                    this.f9331h.n(false, null, this.f9329f, this.f9330g, 20050003, "user fail to login");
                } else {
                    this.f9331h.o(this.f9328e.f6236c, c.a.p0.a.g1.f.U().getActivity(), this.f9329f, this.f9330g);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements c.a.p0.a.z2.g1.c<i<a.b>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9332e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f9333f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f9334g;

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
            this.f9334g = fVar;
            this.f9332e = callbackHandler;
            this.f9333f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<a.b> iVar) {
            a.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar == null || !iVar.c() || (bVar = iVar.a) == null || bVar.f6280c == null) {
                    this.f9334g.n(true, null, this.f9332e, this.f9333f, 20050004, "user fail to get mobile information");
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("data", iVar.a.f6280c.optString("data"));
                    jSONObject.put("iv", iVar.a.f6280c.optString("iv"));
                    this.f9334g.n(true, jSONObject, this.f9332e, this.f9333f, 0, "success");
                } catch (JSONException unused) {
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(c.a.p0.a.f2.e eVar) {
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

    @Override // c.a.p0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.d2.e eVar) {
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
            c.a.p0.a.m.b M = c.a.p0.a.d2.d.J().r().M();
            if (M == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty account");
                return false;
            }
            if (M.e(context)) {
                n(true, null, callbackHandler, optString, 20050001, "user already login");
            } else {
                eVar.d0().e("login_with_mobile", new a(this, callbackHandler, optString));
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
                c.a.p0.a.h2.c.j.a a2 = c.a.p0.a.d2.d.J().y().a().b().a(fragmentActivity, z, "login_with_mobile", null);
                a2.o(new c(this, callbackHandler, str));
                a2.call();
                return;
            }
            n(true, null, callbackHandler, str, 20050004, "user fail to get mobile information");
        }
    }

    public final void p(c.a.p0.a.h2.c.f fVar, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, fVar, callbackHandler, str) == null) {
            new c.a.p0.b.p.b.a().h(new b(this, fVar, callbackHandler, str));
        }
    }
}
