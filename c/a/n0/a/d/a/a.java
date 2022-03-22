package c.a.n0.a.d.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import c.a.n0.a.d2.n;
import c.a.n0.a.p2.g1.c;
import c.a.n0.a.t1.e;
import c.a.n0.a.v1.f.z;
import c.a.n0.a.x1.c.d;
import c.a.n0.a.x1.c.i;
import c.a.n0.a.x1.c.j.b;
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
    public String f3977c;

    /* renamed from: c.a.n0.a.d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0223a implements c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f3978b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f3979c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f3980d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f3981e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f3982f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f3983g;

        public C0223a(a aVar, e eVar, Context context, boolean z, String str, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, eVar, context, Boolean.valueOf(z), str, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3983g = aVar;
            this.a = eVar;
            this.f3978b = context;
            this.f3979c = z;
            this.f3980d = str;
            this.f3981e = callbackHandler;
            this.f3982f = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                boolean e2 = this.a.M().e(this.f3978b);
                if (!d.h(iVar)) {
                    if (!e2 && !this.f3979c) {
                        n.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 4, this.f3980d);
                    }
                    d.q(iVar, this.f3981e, this.f3983g.f3977c);
                    return;
                }
                if (e2 && !this.f3979c) {
                    n.S("success", 4, this.f3980d);
                }
                this.f3983g.l(this.f3978b, this.f3982f, this.f3981e, this.a, this.f3980d);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.n0.a.d.a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f3984b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f3985c;

        public b(a aVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3985c = aVar;
            this.a = callbackHandler;
            this.f3984b = unitedSchemeEntity;
        }

        @Override // c.a.n0.a.d.a.b
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 1) {
                    UnitedSchemeUtility.safeCallback(this.a, this.f3984b, UnitedSchemeUtility.wrapCallbackParams(1002, "user cancel this operation").toString(), this.f3985c.f3977c);
                } else {
                    UnitedSchemeUtility.safeCallback(this.a, this.f3984b, UnitedSchemeUtility.wrapCallbackParams(1003, "close failed").toString(), this.f3985c.f3977c);
                }
            }
        }

        @Override // c.a.n0.a.d.a.b
        public void b(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                UnitedSchemeUtility.safeCallback(this.a, this.f3984b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString(), this.f3985c.f3977c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.n0.a.v1.e eVar) {
        super(eVar, "/swanAPI/chooseAddress");
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
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                c.a.n0.a.u.d.i("ChooseAddress", "swanApp is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
                return false;
            } else if (eVar.m0()) {
                if (z.f6924b) {
                    Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            } else {
                JSONObject m = m(unitedSchemeEntity.getParam("params"));
                String optString = m.optString("cb");
                this.f3977c = optString;
                if (TextUtils.isEmpty(optString)) {
                    c.a.n0.a.u.d.i("ChooseAddress", "cb is empty");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                String optString2 = m.optString("invokeFrom");
                boolean e2 = eVar.M().e(context);
                if (!e2) {
                    n.S("show", 4, optString2);
                }
                eVar.d0().h(context, "mapp_choose_address", d.j(m), new C0223a(this, eVar, context, e2, optString2, callbackHandler, unitedSchemeEntity));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void l(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, eVar, str) == null) {
            c.a.n0.a.s0.a.j0().a(context, eVar.f6344b, eVar.N(), new b(this, callbackHandler, unitedSchemeEntity));
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
            } catch (JSONException e2) {
                if (z.f6924b) {
                    Log.w("SwanAppAction", "JSONObject parsed error!!", e2);
                }
                return new JSONObject();
            }
        }
        return (JSONObject) invokeL.objValue;
    }
}
