package b.a.p0.a.e2.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import b.a.p0.a.c2.f.a0;
import b.a.p0.a.e2.c.j.b;
import b.a.p0.a.j2.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.v2.e1.b<b.a.p0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4806e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f4807f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Activity f4808g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f4809h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f4810i;
        public final /* synthetic */ c j;

        public a(c cVar, CallbackHandler callbackHandler, String str, Activity activity, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, callbackHandler, str, activity, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = cVar;
            this.f4806e = callbackHandler;
            this.f4807f = str;
            this.f4808g = activity;
            this.f4809h = str2;
            this.f4810i = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(b.a.p0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (b.a.p0.a.e2.c.d.h(iVar)) {
                    boolean unused = a0.f4160b;
                    this.j.m(this.f4806e, this.f4807f, this.f4808g, this.f4809h, this.f4810i);
                    return;
                }
                b.a.p0.a.e0.d.h("SwanAppAction", "onCallback: no permission scope_mobile_api");
                k.O(this.f4810i, com.baidu.pass.biometrics.face.liveness.b.a.g0, "onCallback: no permission ");
                this.f4806e.handleSchemeDispatchCallback(this.f4807f, UnitedSchemeUtility.wrapCallbackParams(402).toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a.p0.a.v2.e1.b<b.a.p0.a.e2.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f4811e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f4812f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f4813g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f4814h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f4815i;
        public final /* synthetic */ String j;
        public final /* synthetic */ c k;

        public b(c cVar, Activity activity, boolean z, String str, CallbackHandler callbackHandler, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, activity, Boolean.valueOf(z), str, callbackHandler, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = cVar;
            this.f4811e = activity;
            this.f4812f = z;
            this.f4813g = str;
            this.f4814h = callbackHandler;
            this.f4815i = str2;
            this.j = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(b.a.p0.a.e2.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                b.a.p0.a.e0.d.a("OpenData", "onOpenDataCallback:: ", aVar);
                b.a.p0.a.a2.e c2 = this.k.c();
                if (!aVar.E()) {
                    if (c2 != null && !c2.j().e(this.f4811e) && !this.f4812f) {
                        k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 2, this.f4813g);
                    }
                    boolean unused = a0.f4160b;
                    b.a.p0.a.e2.c.d.m(aVar, this.f4814h, this.f4815i);
                    k.O(this.j, com.baidu.pass.biometrics.face.liveness.b.a.g0, "onCallback: no open data");
                    return;
                }
                b.a.p0.a.e0.d.h("SwanAppAction", "onCallback: got open datamobile");
                if (c2 != null && c2.j().e(this.f4811e) && !this.f4812f) {
                    k.M("success", 2, this.f4813g);
                }
                k.N(this.j, "success");
                this.f4814h.handleSchemeDispatchCallback(this.f4815i, UnitedSchemeUtility.wrapCallbackParams(aVar.f4981g, 0).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b.a.p0.a.c2.e eVar) {
        super(eVar, "/swanAPI/getPhoneNumber");
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

    @Override // b.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                return false;
            }
            String optString = optParamsAsJo.optString("invokeFrom");
            String str = optString.equals("component") ? "getPhoneNumberButton" : "getPhoneNumberApi";
            k.N(str, "create");
            String optString2 = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                k.O(str, com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty cb");
                return false;
            }
            SwanAppActivity x = b.a.p0.a.a2.d.g().x();
            if (x == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
                k.O(str, com.baidu.pass.biometrics.face.liveness.b.a.g0, "the context is not an activity");
                return false;
            }
            if (!eVar.j().e(context)) {
                k.M("show", 2, optString);
            }
            if (optParamsAsJo.optString("invokeFrom").equals(RetrieveTaskManager.KEY)) {
                n(callbackHandler, optString2, x, optString, str);
            } else {
                m(callbackHandler, optString2, x, optString, str);
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void m(CallbackHandler callbackHandler, String str, Activity activity, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, callbackHandler, str, activity, str2, str3) == null) {
            boolean e2 = b.a.p0.a.a2.d.g().r().j().e(activity);
            k.N(str3, "checkScope");
            b.a.p0.a.e2.d.a.C(activity, "mobile", null, false, str3, new b(this, activity, e2, str2, callbackHandler, str, str3));
        }
    }

    public final void n(CallbackHandler callbackHandler, String str, Activity activity, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, callbackHandler, str, activity, str2, str3) == null) {
            k.N(str3, "checkScope");
            b.a.p0.a.a2.d.g().r().S().g(c(), "scope_mobile_api", new a(this, callbackHandler, str, activity, str2, str3));
        }
    }
}
