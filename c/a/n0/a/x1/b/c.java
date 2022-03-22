package c.a.n0.a.x1.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import c.a.n0.a.d2.n;
import c.a.n0.a.v1.f.z;
import c.a.n0.a.x1.c.j.b;
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
    public class a implements c.a.n0.a.p2.g1.c<c.a.n0.a.x1.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f7558b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Activity f7559c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f7560d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7561e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f7562f;

        public a(c cVar, CallbackHandler callbackHandler, String str, Activity activity, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, callbackHandler, str, activity, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7562f = cVar;
            this.a = callbackHandler;
            this.f7558b = str;
            this.f7559c = activity;
            this.f7560d = str2;
            this.f7561e = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.n0.a.x1.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.n0.a.x1.c.d.h(iVar)) {
                    if (z.f6924b) {
                        Log.i("SwanAppAction", "onCallback: has permission scope_mobile_api");
                    }
                    this.f7562f.m(this.a, this.f7558b, this.f7559c, this.f7560d, this.f7561e, false);
                    return;
                }
                c.a.n0.a.u.d.k("SwanAppAction", "onCallback: no permission scope_mobile_api");
                n.U(this.f7561e, com.baidu.pass.biometrics.face.liveness.b.a.g0, "onCallback: no permission ");
                this.a.handleSchemeDispatchCallback(this.f7558b, UnitedSchemeUtility.wrapCallbackParams(402).toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.n0.a.p2.g1.c<c.a.n0.a.x1.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f7563b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f7564c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7565d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7566e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f7567f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f7568g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c f7569h;

        public b(c cVar, Activity activity, boolean z, String str, CallbackHandler callbackHandler, String str2, String str3, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, activity, Boolean.valueOf(z), str, callbackHandler, str2, str3, Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7569h = cVar;
            this.a = activity;
            this.f7563b = z;
            this.f7564c = str;
            this.f7565d = callbackHandler;
            this.f7566e = str2;
            this.f7567f = str3;
            this.f7568g = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.n0.a.x1.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                c.a.n0.a.u.d.b("OpenData", "onOpenDataCallback:: ", aVar);
                c.a.n0.a.t1.e c2 = this.f7569h.c();
                if (!aVar.D()) {
                    if (c2 != null && !c2.M().e(this.a) && !this.f7563b) {
                        n.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 2, this.f7564c);
                    }
                    if (z.f6924b) {
                        Log.i("SwanAppAction", "onCallback: no open datamobile");
                    }
                    c.a.n0.a.x1.c.d.n(aVar, this.f7565d, this.f7566e);
                    n.U(this.f7567f, com.baidu.pass.biometrics.face.liveness.b.a.g0, "onCallback: no open data");
                    if (this.f7568g) {
                        n.s("click", "telLogin", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                        return;
                    }
                    return;
                }
                c.a.n0.a.u.d.k("SwanAppAction", "onCallback: got open datamobile");
                if (c2 != null && c2.M().e(this.a) && !this.f7563b) {
                    n.S("success", 2, this.f7564c);
                }
                n.T(this.f7567f, "success");
                if (this.f7568g) {
                    n.s("click", "telLogin", "succ_agree");
                }
                this.f7565d.handleSchemeDispatchCallback(this.f7566e, UnitedSchemeUtility.wrapCallbackParams(aVar.f7690g, 0).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(c.a.n0.a.v1.e eVar) {
        super(eVar, "/swanAPI/getPhoneNumber");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.n0.a.v1.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.n0.a.t1.e eVar) {
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
            SwanAppActivity x = c.a.n0.a.t1.d.J().x();
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
            boolean e2 = c.a.n0.a.t1.d.J().r().M().e(activity);
            n.T(str3, "checkScope");
            if (z) {
                n.s("show", "telLogin", null);
            }
            c.a.n0.a.x1.d.a.B(activity, "mobile", null, false, str3, new b(this, activity, e2, str2, callbackHandler, str, str3, z));
        }
    }

    public final void n(CallbackHandler callbackHandler, String str, Activity activity, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, callbackHandler, str, activity, str2, str3) == null) {
            n.T(str3, "checkScope");
            c.a.n0.a.t1.d.J().r().d0().g(c(), "scope_mobile_api", new a(this, callbackHandler, str, activity, str2, str3));
        }
    }
}
