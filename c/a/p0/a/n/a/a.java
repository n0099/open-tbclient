package c.a.p0.a.n.a;

import android.content.Context;
import android.text.TextUtils;
import c.a.p0.a.d2.e;
import c.a.p0.a.f2.f.z;
import c.a.p0.a.h2.c.d;
import c.a.p0.a.h2.c.i;
import c.a.p0.a.h2.c.j.b;
import c.a.p0.a.n2.n;
import c.a.p0.a.z2.g1.c;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public String f6830c;

    /* renamed from: c.a.p0.a.n.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0365a implements c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f6831e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f6832f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f6833g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f6834h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f6835i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6836j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ a f6837k;

        public C0365a(a aVar, e eVar, Context context, boolean z, String str, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, eVar, context, Boolean.valueOf(z), str, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6837k = aVar;
            this.f6831e = eVar;
            this.f6832f = context;
            this.f6833g = z;
            this.f6834h = str;
            this.f6835i = callbackHandler;
            this.f6836j = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                boolean e2 = this.f6831e.M().e(this.f6832f);
                if (!d.h(iVar)) {
                    if (!e2 && !this.f6833g) {
                        n.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 4, this.f6834h);
                    }
                    d.q(iVar, this.f6835i, this.f6837k.f6830c);
                    return;
                }
                if (e2 && !this.f6833g) {
                    n.S("success", 4, this.f6834h);
                }
                this.f6837k.l(this.f6832f, this.f6836j, this.f6835i, this.f6831e, this.f6834h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.n.a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f6838b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f6839c;

        public b(a aVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6839c = aVar;
            this.a = callbackHandler;
            this.f6838b = unitedSchemeEntity;
        }

        @Override // c.a.p0.a.n.a.b
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 1) {
                    UnitedSchemeUtility.safeCallback(this.a, this.f6838b, UnitedSchemeUtility.wrapCallbackParams(1002, "user cancel this operation").toString(), this.f6839c.f6830c);
                } else {
                    UnitedSchemeUtility.safeCallback(this.a, this.f6838b, UnitedSchemeUtility.wrapCallbackParams(1003, "close failed").toString(), this.f6839c.f6830c);
                }
            }
        }

        @Override // c.a.p0.a.n.a.b
        public void b(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                UnitedSchemeUtility.safeCallback(this.a, this.f6838b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString(), this.f6839c.f6830c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.p0.a.f2.e eVar) {
        super(eVar, "/swanAPI/chooseAddress");
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
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                c.a.p0.a.e0.d.i("ChooseAddress", "swanApp is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
                return false;
            } else if (eVar.m0()) {
                boolean z = z.f5296b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            } else {
                JSONObject m = m(unitedSchemeEntity.getParam("params"));
                String optString = m.optString("cb");
                this.f6830c = optString;
                if (TextUtils.isEmpty(optString)) {
                    c.a.p0.a.e0.d.i("ChooseAddress", "cb is empty");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                String optString2 = m.optString("invokeFrom");
                boolean e2 = eVar.M().e(context);
                if (!e2) {
                    n.S("show", 4, optString2);
                }
                eVar.d0().h(context, "mapp_choose_address", d.j(m), new C0365a(this, eVar, context, e2, optString2, callbackHandler, unitedSchemeEntity));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void l(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, eVar, str) == null) {
            c.a.p0.a.c1.a.j0().a(context, eVar.f4616f, eVar.N(), new b(this, callbackHandler, unitedSchemeEntity));
        }
    }

    public final JSONObject m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new JSONObject();
            }
            try {
                return new JSONObject(str);
            } catch (JSONException unused) {
                boolean z = z.f5296b;
                return new JSONObject();
            }
        }
        return (JSONObject) invokeL.objValue;
    }
}
