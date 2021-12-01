package c.a.p0.a.h2.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import c.a.p0.a.f2.f.z;
import c.a.p0.a.h2.c.j.b;
import c.a.p0.a.n2.n;
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
public class c extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.p0.a.z2.g1.c<c.a.p0.a.h2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6131e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6132f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Activity f6133g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f6134h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f6135i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c f6136j;

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
            this.f6136j = cVar;
            this.f6131e = callbackHandler;
            this.f6132f = str;
            this.f6133g = activity;
            this.f6134h = str2;
            this.f6135i = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.h2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.p0.a.h2.c.d.h(iVar)) {
                    boolean unused = z.f5296b;
                    this.f6136j.m(this.f6131e, this.f6132f, this.f6133g, this.f6134h, this.f6135i, false);
                    return;
                }
                c.a.p0.a.e0.d.k("SwanAppAction", "onCallback: no permission scope_mobile_api");
                n.U(this.f6135i, com.baidu.pass.biometrics.face.liveness.b.a.g0, "onCallback: no permission ");
                this.f6131e.handleSchemeDispatchCallback(this.f6132f, UnitedSchemeUtility.wrapCallbackParams(402).toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.z2.g1.c<c.a.p0.a.h2.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f6137e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f6138f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6139g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6140h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f6141i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f6142j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ boolean f6143k;
        public final /* synthetic */ c l;

        public b(c cVar, Activity activity, boolean z, String str, CallbackHandler callbackHandler, String str2, String str3, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, activity, Boolean.valueOf(z), str, callbackHandler, str2, str3, Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = cVar;
            this.f6137e = activity;
            this.f6138f = z;
            this.f6139g = str;
            this.f6140h = callbackHandler;
            this.f6141i = str2;
            this.f6142j = str3;
            this.f6143k = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.h2.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                c.a.p0.a.e0.d.b("OpenData", "onOpenDataCallback:: ", aVar);
                c.a.p0.a.d2.e c2 = this.l.c();
                if (!aVar.D()) {
                    if (c2 != null && !c2.M().e(this.f6137e) && !this.f6138f) {
                        n.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 2, this.f6139g);
                    }
                    boolean unused = z.f5296b;
                    c.a.p0.a.h2.c.d.n(aVar, this.f6140h, this.f6141i);
                    n.U(this.f6142j, com.baidu.pass.biometrics.face.liveness.b.a.g0, "onCallback: no open data");
                    if (this.f6143k) {
                        n.s("click", "telLogin", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                        return;
                    }
                    return;
                }
                c.a.p0.a.e0.d.k("SwanAppAction", "onCallback: got open datamobile");
                if (c2 != null && c2.M().e(this.f6137e) && !this.f6138f) {
                    n.S("success", 2, this.f6139g);
                }
                n.T(this.f6142j, "success");
                if (this.f6143k) {
                    n.s("click", "telLogin", "succ_agree");
                }
                this.f6140h.handleSchemeDispatchCallback(this.f6141i, UnitedSchemeUtility.wrapCallbackParams(aVar.f6305g, 0).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(c.a.p0.a.f2.e eVar) {
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

    @Override // c.a.p0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.d2.e eVar) {
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
            n.T(str, "create");
            String optString2 = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                n.U(str, com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty cb");
                return false;
            }
            SwanAppActivity x = c.a.p0.a.d2.d.J().x();
            if (x == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
                n.U(str, com.baidu.pass.biometrics.face.liveness.b.a.g0, "the context is not an activity");
                return false;
            }
            if (!eVar.M().e(context)) {
                n.S("show", 2, optString);
            }
            if (optParamsAsJo.optString("invokeFrom").equals(RetrieveTaskManager.KEY)) {
                n(callbackHandler, optString2, x, optString, str);
            } else {
                m(callbackHandler, optString2, x, optString, str, TextUtils.equals("login", optParamsAsJo.optString("from")));
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void m(CallbackHandler callbackHandler, String str, Activity activity, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{callbackHandler, str, activity, str2, str3, Boolean.valueOf(z)}) == null) {
            boolean e2 = c.a.p0.a.d2.d.J().r().M().e(activity);
            n.T(str3, "checkScope");
            if (z) {
                n.s("show", "telLogin", null);
            }
            c.a.p0.a.h2.d.a.B(activity, "mobile", null, false, str3, new b(this, activity, e2, str2, callbackHandler, str, str3, z));
        }
    }

    public final void n(CallbackHandler callbackHandler, String str, Activity activity, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, callbackHandler, str, activity, str2, str3) == null) {
            n.T(str3, "checkScope");
            c.a.p0.a.d2.d.J().r().d0().g(c(), "scope_mobile_api", new a(this, callbackHandler, str, activity, str2, str3));
        }
    }
}
