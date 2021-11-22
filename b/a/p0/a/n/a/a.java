package b.a.p0.a.n.a;

import android.content.Context;
import android.text.TextUtils;
import b.a.p0.a.d2.e;
import b.a.p0.a.f2.f.z;
import b.a.p0.a.h2.c.d;
import b.a.p0.a.h2.c.i;
import b.a.p0.a.h2.c.j.b;
import b.a.p0.a.n2.n;
import b.a.p0.a.z2.g1.c;
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
    public String f7051c;

    /* renamed from: b.a.p0.a.n.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0309a implements c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f7052e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f7053f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f7054g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f7055h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7056i;
        public final /* synthetic */ UnitedSchemeEntity j;
        public final /* synthetic */ a k;

        public C0309a(a aVar, e eVar, Context context, boolean z, String str, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
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
            this.k = aVar;
            this.f7052e = eVar;
            this.f7053f = context;
            this.f7054g = z;
            this.f7055h = str;
            this.f7056i = callbackHandler;
            this.j = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.p0.a.z2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                boolean e2 = this.f7052e.M().e(this.f7053f);
                if (!d.h(iVar)) {
                    if (!e2 && !this.f7054g) {
                        n.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 4, this.f7055h);
                    }
                    d.q(iVar, this.f7056i, this.k.f7051c);
                    return;
                }
                if (e2 && !this.f7054g) {
                    n.S("success", 4, this.f7055h);
                }
                this.k.l(this.f7053f, this.j, this.f7056i, this.f7052e, this.f7055h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements b.a.p0.a.n.a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7057a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f7058b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f7059c;

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
            this.f7059c = aVar;
            this.f7057a = callbackHandler;
            this.f7058b = unitedSchemeEntity;
        }

        @Override // b.a.p0.a.n.a.b
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 1) {
                    UnitedSchemeUtility.safeCallback(this.f7057a, this.f7058b, UnitedSchemeUtility.wrapCallbackParams(1002, "user cancel this operation").toString(), this.f7059c.f7051c);
                } else {
                    UnitedSchemeUtility.safeCallback(this.f7057a, this.f7058b, UnitedSchemeUtility.wrapCallbackParams(1003, "close failed").toString(), this.f7059c.f7051c);
                }
            }
        }

        @Override // b.a.p0.a.n.a.b
        public void b(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                UnitedSchemeUtility.safeCallback(this.f7057a, this.f7058b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString(), this.f7059c.f7051c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b.a.p0.a.f2.e eVar) {
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

    @Override // b.a.p0.a.f2.f.z
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                b.a.p0.a.e0.d.i("ChooseAddress", "swanApp is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
                return false;
            } else if (eVar.m0()) {
                boolean z = z.f5228b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            } else {
                JSONObject m = m(unitedSchemeEntity.getParam("params"));
                String optString = m.optString("cb");
                this.f7051c = optString;
                if (TextUtils.isEmpty(optString)) {
                    b.a.p0.a.e0.d.i("ChooseAddress", "cb is empty");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                String optString2 = m.optString("invokeFrom");
                boolean e2 = eVar.M().e(context);
                if (!e2) {
                    n.S("show", 4, optString2);
                }
                eVar.d0().h(context, "mapp_choose_address", d.j(m), new C0309a(this, eVar, context, e2, optString2, callbackHandler, unitedSchemeEntity));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void l(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, eVar, str) == null) {
            b.a.p0.a.c1.a.j0().a(context, eVar.f4474f, eVar.N(), new b(this, callbackHandler, unitedSchemeEntity));
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
                boolean z = z.f5228b;
                return new JSONObject();
            }
        }
        return (JSONObject) invokeL.objValue;
    }
}
