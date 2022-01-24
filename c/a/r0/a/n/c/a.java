package c.a.r0.a.n.c;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import c.a.r0.a.d2.e;
import c.a.r0.a.f2.f.z;
import c.a.r0.a.h2.c.d;
import c.a.r0.a.h2.c.i;
import c.a.r0.a.h2.c.j.b;
import c.a.r0.a.n2.n;
import c.a.r0.a.z2.g1.c;
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
public class a extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.r0.a.n.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0474a implements c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f7882e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f7883f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f7884g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f7885h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7886i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f7887j;
        public final /* synthetic */ UnitedSchemeEntity k;
        public final /* synthetic */ a l;

        public C0474a(a aVar, e eVar, Context context, boolean z, String str, CallbackHandler callbackHandler, String str2, UnitedSchemeEntity unitedSchemeEntity) {
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
            this.f7882e = eVar;
            this.f7883f = context;
            this.f7884g = z;
            this.f7885h = str;
            this.f7886i = callbackHandler;
            this.f7887j = str2;
            this.k = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                boolean e2 = this.f7882e.M().e(this.f7883f);
                if (!d.h(iVar)) {
                    if (!e2 && !this.f7884g) {
                        n.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 5, this.f7885h);
                    }
                    d.q(iVar, this.f7886i, this.f7887j);
                    return;
                }
                c.a.r0.a.e0.d.i("chooseInvoiceTitle", OAuthResult.RESULT_MSG_SUCCESS);
                Context context = this.f7883f;
                Context x = context instanceof Activity ? (Activity) context : this.f7882e.x();
                if (x == null) {
                    UnitedSchemeUtility.safeCallback(this.f7886i, this.k, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString(), this.f7887j);
                    return;
                }
                if (e2 && !this.f7884g) {
                    n.S("success", 5, this.f7885h);
                }
                this.l.k(x, this.f7886i, this.k, this.f7882e, this.f7887j, this.f7885h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.r0.a.n.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f7888b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f7889c;

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
            this.a = callbackHandler;
            this.f7888b = unitedSchemeEntity;
            this.f7889c = str;
        }

        @Override // c.a.r0.a.n.c.b
        public void a(int i2) {
            String jSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 1) {
                    c.a.r0.a.e0.d.i("chooseInvoiceTitle", "choose invoice cancel");
                    jSONObject = UnitedSchemeUtility.wrapCallbackParams(1002, "choose invoice cancel").toString();
                } else {
                    c.a.r0.a.e0.d.i("chooseInvoiceTitle", "choose invoice failed");
                    jSONObject = UnitedSchemeUtility.wrapCallbackParams(1003, "choose invoice failed").toString();
                }
                UnitedSchemeUtility.safeCallback(this.a, this.f7888b, jSONObject, this.f7889c);
            }
        }

        @Override // c.a.r0.a.n.c.b
        public void b(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                c.a.r0.a.e0.d.i("chooseInvoiceTitle", "choose success");
                UnitedSchemeUtility.safeCallback(this.a, this.f7888b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString(), this.f7889c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.r0.a.f2.e eVar) {
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

    @Override // c.a.r0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            c.a.r0.a.e0.d.i("chooseInvoiceTitle", "发票调起");
            if (eVar == null) {
                c.a.r0.a.e0.d.c("chooseInvoiceTitle", "empty swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
                return false;
            } else if (eVar.m0()) {
                boolean z = z.f6343b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            } else {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    c.a.r0.a.e0.d.c("chooseInvoiceTitle", "empty joParams");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                    return false;
                }
                String optString = optParamsAsJo.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    c.a.r0.a.e0.d.c("chooseInvoiceTitle", "empty cb");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                    return false;
                }
                String optString2 = optParamsAsJo.optString("invokeFrom");
                boolean e2 = eVar.M().e(context);
                if (!e2) {
                    n.S("show", 5, optString2);
                }
                eVar.d0().h(context, "mapp_choose_invoice", d.j(optParamsAsJo), new C0474a(this, eVar, context, e2, optString2, callbackHandler, optString, unitedSchemeEntity));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, e eVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, callbackHandler, unitedSchemeEntity, eVar, str, str2}) == null) {
            c.a.r0.a.c1.a.k0().a(context, eVar.f5679f, eVar.N(), new b(this, callbackHandler, unitedSchemeEntity, str));
        }
    }
}
