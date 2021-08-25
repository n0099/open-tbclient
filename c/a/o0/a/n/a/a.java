package c.a.o0.a.n.a;

import android.content.Context;
import android.text.TextUtils;
import c.a.o0.a.a2.e;
import c.a.o0.a.c2.f.a0;
import c.a.o0.a.e2.c.d;
import c.a.o0.a.e2.c.i;
import c.a.o0.a.e2.c.j.b;
import c.a.o0.a.j2.k;
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
public class a extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public String f7378c;

    /* renamed from: c.a.o0.a.n.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0300a implements c.a.o0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f7379e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f7380f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f7381g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f7382h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7383i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f7384j;
        public final /* synthetic */ a k;

        public C0300a(a aVar, e eVar, Context context, boolean z, String str, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
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
            this.f7379e = eVar;
            this.f7380f = context;
            this.f7381g = z;
            this.f7382h = str;
            this.f7383i = callbackHandler;
            this.f7384j = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                boolean e2 = this.f7379e.j().e(this.f7380f);
                if (!d.h(iVar)) {
                    if (!e2 && !this.f7381g) {
                        k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 4, this.f7382h);
                    }
                    d.p(iVar, this.f7383i, this.k.f7378c);
                    return;
                }
                if (e2 && !this.f7381g) {
                    k.M("success", 4, this.f7382h);
                }
                this.k.l(this.f7380f, this.f7384j, this.f7383i, this.f7379e, this.f7382h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.o0.a.n.a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f7385a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f7386b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f7387c;

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
            this.f7387c = aVar;
            this.f7385a = callbackHandler;
            this.f7386b = unitedSchemeEntity;
        }

        @Override // c.a.o0.a.n.a.b
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == 1) {
                    UnitedSchemeUtility.safeCallback(this.f7385a, this.f7386b, UnitedSchemeUtility.wrapCallbackParams(1002, "user cancel this operation").toString(), this.f7387c.f7378c);
                } else {
                    UnitedSchemeUtility.safeCallback(this.f7385a, this.f7386b, UnitedSchemeUtility.wrapCallbackParams(1003, "close failed").toString(), this.f7387c.f7378c);
                }
            }
        }

        @Override // c.a.o0.a.n.a.b
        public void b(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                UnitedSchemeUtility.safeCallback(this.f7385a, this.f7386b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString(), this.f7387c.f7378c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c.a.o0.a.c2.e eVar) {
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

    @Override // c.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            if (eVar == null) {
                c.a.o0.a.e0.d.g("ChooseAddress", "swanApp is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
                return false;
            } else if (eVar.d0()) {
                boolean z = a0.f4738b;
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            } else {
                JSONObject m = m(unitedSchemeEntity.getParam("params"));
                String optString = m.optString("cb");
                this.f7378c = optString;
                if (TextUtils.isEmpty(optString)) {
                    c.a.o0.a.e0.d.g("ChooseAddress", "cb is empty");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                String optString2 = m.optString("invokeFrom");
                boolean e2 = eVar.j().e(context);
                if (!e2) {
                    k.M("show", 4, optString2);
                }
                eVar.T().h(context, "mapp_choose_address", d.i(m), new C0300a(this, eVar, context, e2, optString2, callbackHandler, unitedSchemeEntity));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void l(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, eVar, str) == null) {
            c.a.o0.a.c1.a.c0().a(context, eVar.f4530f, eVar.D(), new b(this, callbackHandler, unitedSchemeEntity));
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
                boolean z = a0.f4738b;
                return new JSONObject();
            }
        }
        return (JSONObject) invokeL.objValue;
    }
}
