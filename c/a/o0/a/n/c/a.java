package c.a.o0.a.n.c;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import c.a.o0.a.a2.e;
import c.a.o0.a.c2.f.a0;
import c.a.o0.a.e2.c.d;
import c.a.o0.a.e2.c.i;
import c.a.o0.a.e2.c.j.b;
import c.a.o0.a.j2.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.result.OAuthResult;
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
public class a extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.o0.a.n.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0307a implements c.a.o0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f7422e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f7423f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f7424g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f7425h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7426i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f7427j;
        public final /* synthetic */ UnitedSchemeEntity k;
        public final /* synthetic */ a l;

        public C0307a(a aVar, e eVar, Context context, boolean z, String str, CallbackHandler callbackHandler, String str2, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, eVar, context, Boolean.valueOf(z), str, callbackHandler, str2, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = aVar;
            this.f7422e = eVar;
            this.f7423f = context;
            this.f7424g = z;
            this.f7425h = str;
            this.f7426i = callbackHandler;
            this.f7427j = str2;
            this.k = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                boolean e2 = this.f7422e.j().e(this.f7423f);
                if (!d.h(iVar)) {
                    if (!e2 && !this.f7424g) {
                        k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 5, this.f7425h);
                    }
                    d.p(iVar, this.f7426i, this.f7427j);
                    return;
                }
                c.a.o0.a.e0.d.g("chooseInvoiceTitle", OAuthResult.RESULT_MSG_SUCCESS);
                Context context = this.f7423f;
                Context x = context instanceof Activity ? (Activity) context : this.f7422e.x();
                if (x == null) {
                    UnitedSchemeUtility.safeCallback(this.f7426i, this.k, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString(), this.f7427j);
                    return;
                }
                if (e2 && !this.f7424g) {
                    k.M("success", 5, this.f7425h);
                }
                this.l.k(x, this.f7426i, this.k, this.f7422e, this.f7427j, this.f7425h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.o0.a.n.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7428a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f7429b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f7430c;

        public b(a aVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callbackHandler, unitedSchemeEntity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7428a = callbackHandler;
            this.f7429b = unitedSchemeEntity;
            this.f7430c = str;
        }

        @Override // c.a.o0.a.n.c.b
        public void a(int i2) {
            String jSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 1) {
                    c.a.o0.a.e0.d.g("chooseInvoiceTitle", "choose invoice cancel");
                    jSONObject = UnitedSchemeUtility.wrapCallbackParams(1002, "choose invoice cancel").toString();
                } else {
                    c.a.o0.a.e0.d.g("chooseInvoiceTitle", "choose invoice failed");
                    jSONObject = UnitedSchemeUtility.wrapCallbackParams(1003, "choose invoice failed").toString();
                }
                UnitedSchemeUtility.safeCallback(this.f7428a, this.f7429b, jSONObject, this.f7430c);
            }
        }

        @Override // c.a.o0.a.n.c.b
        public void b(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                c.a.o0.a.e0.d.g("chooseInvoiceTitle", "choose success");
                UnitedSchemeUtility.safeCallback(this.f7428a, this.f7429b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString(), this.f7430c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.o0.a.c2.e eVar) {
        super(eVar, "/swanAPI/chooseInvoiceTitle");
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
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            c.a.o0.a.e0.d.g("chooseInvoiceTitle", "发票调起");
            if (eVar == null) {
                c.a.o0.a.e0.d.b("chooseInvoiceTitle", "empty swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
                return false;
            } else if (eVar.d0()) {
                boolean z = a0.f4738b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            } else {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    c.a.o0.a.e0.d.b("chooseInvoiceTitle", "empty joParams");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                    return false;
                }
                String optString = optParamsAsJo.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    c.a.o0.a.e0.d.b("chooseInvoiceTitle", "empty cb");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                    return false;
                }
                String optString2 = optParamsAsJo.optString("invokeFrom");
                boolean e2 = eVar.j().e(context);
                if (!e2) {
                    k.M("show", 5, optString2);
                }
                eVar.T().h(context, "mapp_choose_invoice", d.i(optParamsAsJo), new C0307a(this, eVar, context, e2, optString2, callbackHandler, optString, unitedSchemeEntity));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, e eVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, callbackHandler, unitedSchemeEntity, eVar, str, str2}) == null) {
            c.a.o0.a.c1.a.d0().a(context, eVar.f4530f, eVar.D(), new b(this, callbackHandler, unitedSchemeEntity, str));
        }
    }
}
