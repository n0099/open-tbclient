package c.a.n0.b.g.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import c.a.n0.a.k.e.a.d;
import c.a.n0.a.p2.q0;
import c.a.n0.a.v1.f.z;
import c.a.n0.a.x1.c.i;
import c.a.n0.a.x1.c.j.b;
import c.a.n0.a.x1.c.j.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.searchbox.account.contants.LoginConstants;
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
public class h extends z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.n0.a.p2.g1.c<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f8056b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f8057c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f8058d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.t1.e f8059e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.C0326d f8060f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Bundle f8061g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ h f8062h;

        public a(h hVar, CallbackHandler callbackHandler, String str, Context context, String str2, c.a.n0.a.t1.e eVar, d.C0326d c0326d, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, callbackHandler, str, context, str2, eVar, c0326d, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8062h = hVar;
            this.a = callbackHandler;
            this.f8056b = str;
            this.f8057c = context;
            this.f8058d = str2;
            this.f8059e = eVar;
            this.f8060f = c0326d;
            this.f8061g = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.n0.a.x1.c.d.h(iVar)) {
                    if (this.f8062h.o(this.f8057c, this.f8058d)) {
                        this.f8062h.m(this.f8059e, (Activity) this.f8057c, this.f8060f, this.a, this.f8056b, this.f8061g);
                        return;
                    } else {
                        this.a.handleSchemeDispatchCallback(this.f8056b, UnitedSchemeUtility.wrapCallbackParams(10008, "app not installed").toString());
                        return;
                    }
                }
                c.a.n0.a.x1.c.d.q(iVar, this.a, this.f8056b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.n0.a.p2.g1.c<i<f.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d.C0326d a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f8063b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f8064c;

        public b(h hVar, d.C0326d c0326d, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, c0326d, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c0326d;
            this.f8063b = callbackHandler;
            this.f8064c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.a.p2.g1.c
        /* renamed from: a */
        public void onCallback(i<f.d> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!iVar.c()) {
                    c.a.n0.a.u.d.o("ThirdPartyLoginAction", iVar.b() + " " + this.a.toString());
                    String f2 = c.a.n0.a.x1.c.d.f(iVar.b());
                    if (!TextUtils.isEmpty(f2)) {
                        this.f8063b.handleSchemeDispatchCallback(this.f8064c, UnitedSchemeUtility.wrapCallbackParams(iVar.b(), f2).toString());
                    } else {
                        this.f8063b.handleSchemeDispatchCallback(this.f8064c, UnitedSchemeUtility.wrapCallbackParams(iVar.b()).toString());
                    }
                } else if (TextUtils.isEmpty(iVar.a.a)) {
                    this.f8063b.handleSchemeDispatchCallback(this.f8064c, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                } else {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("code", iVar.a.a);
                        this.f8063b.handleSchemeDispatchCallback(this.f8064c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, iVar.b()).toString());
                    } catch (JSONException e2) {
                        if (z.f6924b) {
                            e2.printStackTrace();
                        }
                        this.f8063b.handleSchemeDispatchCallback(this.f8064c, UnitedSchemeUtility.wrapCallbackParams(1001, e2.getMessage()).toString());
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(c.a.n0.a.v1.e eVar) {
        super(eVar, "/swanAPI/thirdPartyLogin");
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
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            }
            String optString2 = optParamsAsJo.optString("type", "");
            int n = n(optString2);
            d.C0326d c0326d = new d.C0326d(optParamsAsJo);
            Bundle bundle = new Bundle();
            bundle.putInt("key_login_mode", n);
            eVar.d0().g(context, "mapp_i_login", new a(this, callbackHandler, optString, context, optString2, eVar, c0326d, bundle));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void m(c.a.n0.a.t1.e eVar, Activity activity, d.C0326d c0326d, CallbackHandler callbackHandler, String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{eVar, activity, c0326d, callbackHandler, str, bundle}) == null) {
            eVar.d0().r(activity, c0326d, bundle, new b(this, c0326d, callbackHandler, str), "SwanThirdPartLogin");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final int n(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            switch (str.hashCode()) {
                case -791575966:
                    if (str.equals(ThirdPartyUtil.TYPE_WEIXIN)) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -265713450:
                    if (str.equals("username")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3616:
                    if (str.equals(LoginConstants.QQ_LOGIN)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 114009:
                    if (str.equals(LoginConstants.SMS_LOGIN)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 113011944:
                    if (str.equals("weibo")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 == 2) {
                        return 2;
                    }
                    if (c2 == 3) {
                        return 3;
                    }
                    if (c2 == 4) {
                        return 4;
                    }
                }
                return 1;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final boolean o(Context context, String str) {
        InterceptResult invokeLL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, str)) == null) {
            switch (str.hashCode()) {
                case -791575966:
                    if (str.equals(ThirdPartyUtil.TYPE_WEIXIN)) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -265713450:
                    if (str.equals("username")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 3616:
                    if (str.equals(LoginConstants.QQ_LOGIN)) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 114009:
                    if (str.equals(LoginConstants.SMS_LOGIN)) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 113011944:
                    if (str.equals("weibo")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        return c2 == 3 || c2 == 4;
                    }
                    return q0.F(context, "com.sina.weibo");
                }
                return q0.F(context, "com.tencent.mobileqq");
            }
            return q0.F(context, "com.tencent.mm");
        }
        return invokeLL.booleanValue;
    }
}
