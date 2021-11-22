package b.a.p0.a.h2.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import b.a.p0.a.f2.f.z;
import b.a.p0.a.n2.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements b.a.p0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f6295e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6296f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6297g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Activity f6298h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f6299i;
        public final /* synthetic */ String j;
        public final /* synthetic */ g k;

        public a(g gVar, boolean z, CallbackHandler callbackHandler, String str, Activity activity, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, Boolean.valueOf(z), callbackHandler, str, activity, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = gVar;
            this.f6295e = z;
            this.f6296f = callbackHandler;
            this.f6297g = str;
            this.f6298h = activity;
            this.f6299i = str2;
            this.j = str3;
        }

        @Override // b.a.p0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    this.k.k(this.f6295e, this.f6296f, this.f6297g, this.f6298h, this.f6299i, "snsapi_userinfo", this.j);
                } else {
                    this.f6296f.handleSchemeDispatchCallback(this.f6297g, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a.p0.a.z2.g1.c<b.a.p0.a.h2.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f6300e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f6301f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6302g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6303h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f6304i;
        public final /* synthetic */ g j;

        public b(g gVar, Activity activity, boolean z, String str, CallbackHandler callbackHandler, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, activity, Boolean.valueOf(z), str, callbackHandler, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = gVar;
            this.f6300e = activity;
            this.f6301f = z;
            this.f6302g = str;
            this.f6303h = callbackHandler;
            this.f6304i = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(b.a.p0.a.h2.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                b.a.p0.a.e0.d.b("OpenData", "onOpenDataCallback:: ", aVar);
                b.a.p0.a.d2.e c2 = this.j.c();
                boolean e2 = c2 != null ? c2.M().e(this.f6300e) : false;
                if (!aVar.E()) {
                    if (!e2 && !this.f6301f) {
                        n.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 3, this.f6302g);
                    }
                    b.a.p0.a.h2.c.d.n(aVar, this.f6303h, this.f6304i);
                    return;
                }
                if (e2 && !this.f6301f) {
                    n.S("success", 3, this.f6302g);
                }
                this.f6303h.handleSchemeDispatchCallback(this.f6304i, UnitedSchemeUtility.wrapCallbackParams(aVar.f6459g, 0).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(b.a.p0.a.f2.e eVar) {
        super(eVar, "/swanAPI/getUserInfo");
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

    @Override // b.a.p0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, b.a.p0.a.d2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
                b.a.p0.a.c1.b.j().c(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                b.a.p0.a.c1.b.j().c(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                b.a.p0.a.c1.b.j().c(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                return false;
            }
            Activity x = context instanceof Activity ? (Activity) context : eVar.x();
            if (x == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
                b.a.p0.a.c1.b.j().c(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString());
                return false;
            }
            String optString2 = optParamsAsJo.optString("invokeFrom");
            if (!eVar.M().e(context)) {
                n.S("show", 3, optString2);
            }
            String f2 = b.a.p0.a.w1.h.b.f(optParamsAsJo.optString("__plugin__", null));
            b.a.p0.a.m.b M = eVar.M();
            boolean j = b.a.p0.a.h2.c.d.j(optParamsAsJo);
            if (!M.e(context) && j) {
                M.f(x, null, new a(this, j, callbackHandler, optString, x, f2, optString2));
            } else {
                k(j, callbackHandler, optString, x, f2, "snsapi_userinfo", optString2);
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(boolean z, CallbackHandler callbackHandler, String str, Activity activity, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), callbackHandler, str, activity, str2, str3, str4}) == null) {
            b.a.p0.a.d2.e a0 = b.a.p0.a.d2.e.a0();
            b.a.p0.a.h2.d.a.B(activity, str3, str2, z, "getUserInfoApi", new b(this, activity, a0 != null ? a0.M().e(activity) : false, str4, callbackHandler, str));
        }
    }
}
