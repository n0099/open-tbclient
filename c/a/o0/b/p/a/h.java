package c.a.o0.b.p.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import c.a.o0.a.c2.f.a0;
import c.a.o0.a.e2.c.i;
import c.a.o0.a.e2.c.j.b;
import c.a.o0.a.e2.c.j.f;
import c.a.o0.a.u.e.a.c;
import c.a.o0.a.v2.q0;
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
public class h extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a implements c.a.o0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10183e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f10184f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f10185g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f10186h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.a.a2.e f10187i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c.C0382c f10188j;
        public final /* synthetic */ Bundle k;
        public final /* synthetic */ h l;

        public a(h hVar, CallbackHandler callbackHandler, String str, Context context, String str2, c.a.o0.a.a2.e eVar, c.C0382c c0382c, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, callbackHandler, str, context, str2, eVar, c0382c, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = hVar;
            this.f10183e = callbackHandler;
            this.f10184f = str;
            this.f10185g = context;
            this.f10186h = str2;
            this.f10187i = eVar;
            this.f10188j = c0382c;
            this.k = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (c.a.o0.a.e2.c.d.h(iVar)) {
                    if (this.l.o(this.f10185g, this.f10186h)) {
                        this.l.m(this.f10187i, (Activity) this.f10185g, this.f10188j, this.f10183e, this.f10184f, this.k);
                        return;
                    } else {
                        this.f10183e.handleSchemeDispatchCallback(this.f10184f, UnitedSchemeUtility.wrapCallbackParams(10008, "app not installed").toString());
                        return;
                    }
                }
                c.a.o0.a.e2.c.d.p(iVar, this.f10183e, this.f10184f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.a.o0.a.v2.e1.b<i<f.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.C0382c f10189e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f10190f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f10191g;

        public b(h hVar, c.C0382c c0382c, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, c0382c, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10189e = c0382c;
            this.f10190f = callbackHandler;
            this.f10191g = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<f.d> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!iVar.c()) {
                    c.a.o0.a.e0.d.l("ThirdPartyLoginAction", iVar.b() + " " + this.f10189e.toString());
                    String f2 = c.a.o0.a.e2.c.d.f(iVar.b());
                    if (!TextUtils.isEmpty(f2)) {
                        this.f10190f.handleSchemeDispatchCallback(this.f10191g, UnitedSchemeUtility.wrapCallbackParams(iVar.b(), f2).toString());
                    } else {
                        this.f10190f.handleSchemeDispatchCallback(this.f10191g, UnitedSchemeUtility.wrapCallbackParams(iVar.b()).toString());
                    }
                } else if (TextUtils.isEmpty(iVar.f5554a.f5572a)) {
                    this.f10190f.handleSchemeDispatchCallback(this.f10191g, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                } else {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("code", iVar.f5554a.f5572a);
                        this.f10190f.handleSchemeDispatchCallback(this.f10191g, UnitedSchemeUtility.wrapCallbackParams(jSONObject, iVar.b()).toString());
                    } catch (JSONException e2) {
                        if (a0.f4738b) {
                            e2.printStackTrace();
                        }
                        this.f10190f.handleSchemeDispatchCallback(this.f10191g, UnitedSchemeUtility.wrapCallbackParams(1001, e2.getMessage()).toString());
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(c.a.o0.a.c2.e eVar) {
        super(eVar, "/swanAPI/thirdPartyLogin");
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
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, c.a.o0.a.a2.e eVar) {
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
            c.C0382c c0382c = new c.C0382c(optParamsAsJo);
            Bundle bundle = new Bundle();
            bundle.putInt("key_login_mode", n);
            eVar.T().g(context, "mapp_i_login", new a(this, callbackHandler, optString, context, optString2, eVar, c0382c, bundle));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void m(c.a.o0.a.a2.e eVar, Activity activity, c.C0382c c0382c, CallbackHandler callbackHandler, String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{eVar, activity, c0382c, callbackHandler, str, bundle}) == null) {
            eVar.T().r(activity, c0382c, bundle, new b(this, c0382c, callbackHandler, str), "SwanThirdPartLogin");
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
                    if (str.equals("sms")) {
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
                    if (str.equals("sms")) {
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
