package c.a.p0.a.e2.b;

import android.content.Context;
import android.text.TextUtils;
import c.a.p0.a.c2.f.a0;
import c.a.p0.a.e2.c.j.b;
import c.a.p0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.p0.a.e2.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0167a implements c.a.p0.a.v2.e1.b<c.a.p0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5437e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5438f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f5439g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f5440h;

        public C0167a(a aVar, CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5440h = aVar;
            this.f5437e = callbackHandler;
            this.f5438f = str;
            this.f5439g = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.p0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                this.f5440h.k(this.f5437e, this.f5438f, this.f5439g, iVar);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1518533038, "Lc/a/p0/a/e2/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1518533038, "Lc/a/p0/a/e2/b/a;");
                return;
            }
        }
        boolean z = k.f7085a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.p0.a.c2.e eVar) {
        super(eVar, "/swanAPI/authorize");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
                c.a.p0.a.c1.b.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null").toString());
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty joParams");
                c.a.p0.a.c1.b.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty joParams").toString());
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty cb");
                c.a.p0.a.c1.b.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty cb").toString());
                return false;
            }
            String optString2 = optParamsAsJo.optString("scope");
            if (TextUtils.isEmpty(optString2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty scope");
                c.a.p0.a.c1.b.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty scope").toString());
                return false;
            }
            eVar.T().c(context, optString2, false, new C0167a(this, callbackHandler, optString2, optString));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a3, code lost:
        r8 = 10001;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k(CallbackHandler callbackHandler, String str, String str2, c.a.p0.a.e2.c.i<b.e> iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, callbackHandler, str, str2, iVar) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("scope", str);
                if (iVar != null && iVar.f5590a != null) {
                    if (!iVar.c()) {
                        OAuthException a2 = iVar.a();
                        jSONObject.put("errMsg", a2 == null ? "" : a2.getMessage());
                        callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(iVar.b()).toString());
                        c.a.p0.a.c1.b.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(jSONObject, iVar.b()).toString());
                        return;
                    }
                    jSONObject.put("code", iVar.f5590a.f5604a);
                    jSONObject.put("errMsg", iVar.f5590a.f5605b ? "authorize:ok" : "user deny");
                    callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, iVar.f5590a.f5605b ? 0 : 10003).toString());
                    if (iVar.f5590a.f5605b) {
                        return;
                    }
                    c.a.p0.a.c1.b.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(jSONObject, iVar.b()).toString());
                    return;
                }
                int b2 = iVar.b();
                c.a.p0.a.e2.c.d.j("empty auth result", Boolean.TRUE);
                jSONObject.put("errMsg", c.a.p0.a.e2.c.d.f(b2));
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, b2).toString());
                c.a.p0.a.e2.c.d.s("AuthorizeAction", "null == result || null == result.mData");
                c.a.p0.a.c1.b.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(jSONObject, b2).toString());
            } catch (JSONException unused) {
                c.a.p0.a.e2.c.d.j("json exception", Boolean.TRUE);
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(10001, "internal error").toString());
                c.a.p0.a.c1.b.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 10001, "internal error").toString());
            }
        }
    }
}
