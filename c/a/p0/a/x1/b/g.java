package c.a.p0.a.x1.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import c.a.p0.a.d2.n;
import c.a.p0.a.v1.f.z;
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
    public class a implements c.a.p0.a.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f9017e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9018f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f9019g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Activity f9020h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f9021i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f9022j;
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
            this.f9017e = z;
            this.f9018f = callbackHandler;
            this.f9019g = str;
            this.f9020h = activity;
            this.f9021i = str2;
            this.f9022j = str3;
        }

        @Override // c.a.p0.a.c.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    this.k.k(this.f9017e, this.f9018f, this.f9019g, this.f9020h, this.f9021i, "snsapi_userinfo", this.f9022j);
                } else {
                    this.f9018f.handleSchemeDispatchCallback(this.f9019g, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.p2.g1.c<c.a.p0.a.x1.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f9023e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f9024f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f9025g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f9026h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f9027i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ g f9028j;

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
            this.f9028j = gVar;
            this.f9023e = activity;
            this.f9024f = z;
            this.f9025g = str;
            this.f9026h = callbackHandler;
            this.f9027i = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(c.a.p0.a.x1.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                c.a.p0.a.u.d.b("OpenData", "onOpenDataCallback:: ", aVar);
                c.a.p0.a.t1.e c2 = this.f9028j.c();
                boolean e2 = c2 != null ? c2.M().e(this.f9023e) : false;
                if (!aVar.E()) {
                    if (!e2 && !this.f9024f) {
                        n.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 3, this.f9025g);
                    }
                    c.a.p0.a.x1.c.d.n(aVar, this.f9026h, this.f9027i);
                    return;
                }
                if (e2 && !this.f9024f) {
                    n.S("success", 3, this.f9025g);
                }
                this.f9026h.handleSchemeDispatchCallback(this.f9027i, UnitedSchemeUtility.wrapCallbackParams(aVar.f9165g, 0).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(c.a.p0.a.v1.e eVar) {
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

    @Override // c.a.p0.a.v1.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.t1.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
                c.a.p0.a.s0.b.j().c(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                c.a.p0.a.s0.b.j().c(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                c.a.p0.a.s0.b.j().c(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                return false;
            }
            Activity x = context instanceof Activity ? (Activity) context : eVar.x();
            if (x == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
                c.a.p0.a.s0.b.j().c(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString());
                return false;
            }
            String optString2 = optParamsAsJo.optString("invokeFrom");
            if (!eVar.M().e(context)) {
                n.S("show", 3, optString2);
            }
            String f2 = c.a.p0.a.m1.h.b.f(optParamsAsJo.optString("__plugin__", null));
            c.a.p0.a.c.b M = eVar.M();
            boolean j2 = c.a.p0.a.x1.c.d.j(optParamsAsJo);
            if (!M.e(context) && j2) {
                M.f(x, null, new a(this, j2, callbackHandler, optString, x, f2, optString2));
            } else {
                k(j2, callbackHandler, optString, x, f2, "snsapi_userinfo", optString2);
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(boolean z, CallbackHandler callbackHandler, String str, Activity activity, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), callbackHandler, str, activity, str2, str3, str4}) == null) {
            c.a.p0.a.t1.e a0 = c.a.p0.a.t1.e.a0();
            c.a.p0.a.x1.d.a.B(activity, str3, str2, z, "getUserInfoApi", new b(this, activity, a0 != null ? a0.M().e(activity) : false, str4, callbackHandler, str));
        }
    }
}
