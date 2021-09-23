package c.a.p0.a.e2.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import c.a.p0.a.c2.f.a0;
import c.a.p0.a.j2.k;
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
public class f extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.p0.a.m.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f5459e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5460f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f5461g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Activity f5462h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f5463i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f5464j;
        public final /* synthetic */ f k;

        public a(f fVar, boolean z, CallbackHandler callbackHandler, String str, Activity activity, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Boolean.valueOf(z), callbackHandler, str, activity, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = fVar;
            this.f5459e = z;
            this.f5460f = callbackHandler;
            this.f5461g = str;
            this.f5462h = activity;
            this.f5463i = str2;
            this.f5464j = str3;
        }

        @Override // c.a.p0.a.m.a
        public void onResult(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 0) {
                    this.k.k(this.f5459e, this.f5460f, this.f5461g, this.f5462h, this.f5463i, "snsapi_userinfo", this.f5464j);
                } else {
                    this.f5460f.handleSchemeDispatchCallback(this.f5461g, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.v2.e1.b<c.a.p0.a.e2.d.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f5465e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f5466f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f5467g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f5468h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f5469i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ f f5470j;

        public b(f fVar, Activity activity, boolean z, String str, CallbackHandler callbackHandler, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, activity, Boolean.valueOf(z), str, callbackHandler, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5470j = fVar;
            this.f5465e = activity;
            this.f5466f = z;
            this.f5467g = str;
            this.f5468h = callbackHandler;
            this.f5469i = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(c.a.p0.a.e2.d.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                c.a.p0.a.e0.d.a("OpenData", "onOpenDataCallback:: ", aVar);
                c.a.p0.a.a2.e c2 = this.f5470j.c();
                boolean e2 = c2 != null ? c2.j().e(this.f5465e) : false;
                if (!aVar.F()) {
                    if (!e2 && !this.f5466f) {
                        k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 3, this.f5467g);
                    }
                    c.a.p0.a.e2.c.d.m(aVar, this.f5468h, this.f5469i);
                    return;
                }
                if (e2 && !this.f5466f) {
                    k.M("success", 3, this.f5467g);
                }
                this.f5468h.handleSchemeDispatchCallback(this.f5469i, UnitedSchemeUtility.wrapCallbackParams(aVar.f5626g, 0).toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(c.a.p0.a.c2.e eVar) {
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

    @Override // c.a.p0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.p0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
                c.a.p0.a.c1.b.j().c(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                c.a.p0.a.c1.b.j().c(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                c.a.p0.a.c1.b.j().c(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                return false;
            }
            Activity x = context instanceof Activity ? (Activity) context : eVar.x();
            if (x == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
                c.a.p0.a.c1.b.j().c(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString());
                return false;
            }
            String optString2 = optParamsAsJo.optString("invokeFrom");
            if (!eVar.j().e(context)) {
                k.M("show", 3, optString2);
            }
            String f2 = c.a.p0.a.t1.g.b.f(optParamsAsJo.optString("__plugin__", null));
            c.a.p0.a.m.b j2 = eVar.j();
            boolean i2 = c.a.p0.a.e2.c.d.i(optParamsAsJo);
            if (!j2.e(context) && i2) {
                j2.f(x, null, new a(this, i2, callbackHandler, optString, x, f2, optString2));
            } else {
                k(i2, callbackHandler, optString, x, f2, "snsapi_userinfo", optString2);
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(boolean z, CallbackHandler callbackHandler, String str, Activity activity, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), callbackHandler, str, activity, str2, str3, str4}) == null) {
            c.a.p0.a.a2.e Q = c.a.p0.a.a2.e.Q();
            c.a.p0.a.e2.d.a.C(activity, str3, str2, z, "getUserInfoApi", new b(this, activity, Q != null ? Q.j().e(activity) : false, str4, callbackHandler, str));
        }
    }
}
