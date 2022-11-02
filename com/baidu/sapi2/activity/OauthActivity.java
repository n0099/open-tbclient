package com.baidu.sapi2.activity;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.SsoHashCallback;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.result.QrAppLoginResult;
import com.baidu.sapi2.result.SsoHashResult;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.QrLoginAction;
import com.baidu.sapi2.views.LoadingDialog;
import com.baidu.sapi2.views.ViewUtility;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class OauthActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String E = "extra_calling_app_id";
    public static final String F = "extra_oauth_result_json";
    public static final String G = "extra_redirect_url";
    public static final String H = "extra_scope";
    public static final String I = "extra_oauth_type";
    public static final String J = "extra_qr_code_url";
    public static final String K = "extra_oauth_sdk_version";
    public static final String L = "extra_pass_sdk_version";
    public static final String M = "extra_oauth_state";
    public static final String N = "2.0.0";
    public static final int O = -201;
    public static final int P = -202;
    public static final int Q = -204;
    public static final int R = -205;
    public static final int S = -208;
    public transient /* synthetic */ FieldHolder $fh;
    public Dialog A;
    public int B;
    public String C;
    public boolean D;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;

    public OauthActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.B = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            SapiWebView sapiWebView = this.sapiWebView;
            if (sapiWebView != null && sapiWebView.canGoBack()) {
                this.sapiWebView.goBack();
                return;
            }
            setResult(0, a(-205));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            SapiAccountManager.getInstance().getAccountService().generateSsoHash(new SsoHashCallback(this) { // from class: com.baidu.sapi2.activity.OauthActivity.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ OauthActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.sapi2.callback.SsoHashCallback, com.baidu.sapi2.callback.SapiCallback
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        OauthActivity oauthActivity = this.a;
                        ViewUtility.dismissDialog(oauthActivity, oauthActivity.A);
                    }
                }

                @Override // com.baidu.sapi2.callback.SsoHashCallback, com.baidu.sapi2.callback.SapiCallback
                public void onStart() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        OauthActivity oauthActivity = this.a;
                        oauthActivity.A = new LoadingDialog.Builder(oauthActivity).setMessage("正在加载中...").setCancelable(false).setCancelOutside(false).createDialog();
                        if (!this.a.isFinishing() && !this.a.A.isShowing()) {
                            this.a.A.show();
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onSuccess(SsoHashResult ssoHashResult) {
                    String str;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, ssoHashResult) == null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("client", "android");
                        hashMap.put("clientfrom", "native");
                        hashMap.put("suppcheck", "1");
                        if (this.a.B == 0) {
                            if (SapiUtils.versionCompareTo(this.a.y, OauthActivity.N) >= 0) {
                                hashMap.put("response_type", "sso_auth_code");
                                hashMap.put("state", this.a.x);
                            } else {
                                hashMap.put("response_type", "sso_token");
                            }
                            hashMap.put(CriusAttrConstants.DISPLAY, "mobile");
                            hashMap.put("scope", this.a.w);
                            hashMap.put("sso_hash", ssoHashResult.ssoHash);
                            hashMap.put("client_id", this.a.u);
                            hashMap.put("redirect_uri", this.a.v);
                            str = (SapiAccountManager.getInstance().getConfignation().environment.getDeviceUrl() + "/oauth/2.0/authorize") + SapiUtils.mapToUrlParams(hashMap, false);
                        } else {
                            hashMap.put("oauth_sso_hash", ssoHashResult.ssoHash);
                            hashMap.put("oauth_redirect_uri", this.a.v);
                            if (SapiUtils.versionCompareTo(this.a.y, OauthActivity.N) >= 0) {
                                hashMap.put("getauthorizationcode", "1");
                            } else {
                                hashMap.put("getaccesstoken", "1");
                            }
                            str = this.a.C + SapiUtils.mapToUrlParams(hashMap, true);
                        }
                        this.a.sapiWebView.loadUrl(str);
                    }
                }
            }, this.t, this.u);
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.B == 1) {
                SapiAccountManager.getInstance().getAccountService().qrAppLogin(new SapiCallback<QrAppLoginResult>(this) { // from class: com.baidu.sapi2.activity.OauthActivity.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ OauthActivity a;

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFailure(QrAppLoginResult qrAppLoginResult) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, qrAppLoginResult) == null) {
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onSuccess(QrAppLoginResult qrAppLoginResult) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048580, this, qrAppLoginResult) == null) {
                        }
                    }

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }
                }, this.C, QrLoginAction.CANCEL.getName());
            }
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i)) == null) {
            return a(i, "");
        }
        return (Intent) invokeI.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent a(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65539, this, i, str)) == null) {
            Intent intent = new Intent();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", i);
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("msg", str);
                }
            } catch (JSONException e) {
                Log.e(e);
            }
            intent.putExtra(F, jSONObject.toString());
            return intent;
        }
        return (Intent) invokeIL.objValue;
    }

    private boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Uri parse = Uri.parse(str);
            parse.getHost();
            String[] strArr = {Uri.decode(parse.getQueryParameter("sign")), Uri.decode(parse.getQueryParameter("client_id")), Uri.decode(parse.getQueryParameter("cmd")), Uri.decode(parse.getQueryParameter("tpl"))};
            for (int i = 0; i < 4; i++) {
                if (TextUtils.isEmpty(strArr[i])) {
                    return false;
                }
            }
            String wap = SapiAccountManager.getInstance().getConfignation().getEnvironment().getWap();
            if (!wap.equals(parse.getScheme() + "://" + parse.getHost())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            if (SapiAccountManager.getInstance().getConfignation() == null) {
                SapiAccountManager.getGlobalCallback().onNeedInitPassSdk();
            }
            if (SapiAccountManager.getInstance().getConfignation() == null) {
                Log.e("pass sdk have not been initialized", new Object[0]);
                setResult(0, a(-201));
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            boolean z = SapiAccountManager.getInstance().getConfignation().supportFaceLogin;
            WebLoginDTO webLoginDTO = new WebLoginDTO();
            webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_USERNAME;
            SapiAccountManager.getInstance().getConfignation().supportFaceLogin = false;
            LoginActivity.supportShareLogin = false;
            WebLoginDTO.Config config = new WebLoginDTO.Config();
            config.fastLoginFeatureList = new ArrayList();
            webLoginDTO.config = config;
            CoreViewRouter.getInstance().startLogin(this, new WebAuthListener(this, z) { // from class: com.baidu.sapi2.activity.OauthActivity.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ boolean a;
                public final /* synthetic */ OauthActivity b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.b = this;
                    this.a = z;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFailure(WebAuthResult webAuthResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webAuthResult) == null) {
                        if (webAuthResult.getResultCode() == -301) {
                            OauthActivity oauthActivity = this.b;
                            oauthActivity.setResult(0, oauthActivity.a(-205));
                            this.b.finish();
                        } else {
                            OauthActivity oauthActivity2 = this.b;
                            oauthActivity2.setResult(0, oauthActivity2.a(-201));
                            this.b.finish();
                        }
                        LoginActivity.supportShareLogin = true;
                        SapiAccountManager.getInstance().getConfignation().supportFaceLogin = this.a;
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onSuccess(WebAuthResult webAuthResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, webAuthResult) == null) {
                        this.b.c();
                        SapiAccountManager.getGlobalCallback().onLoginStatusChange();
                        LoginActivity.supportShareLogin = true;
                        SapiAccountManager.getInstance().getConfignation().supportFaceLogin = this.a;
                        new Handler().postDelayed(new Runnable(this) { // from class: com.baidu.sapi2.activity.OauthActivity.6.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass6 a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.a = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    SapiUtils.hideSoftInput(this.a.b);
                                }
                            }
                        }, 300L);
                    }
                }
            }, webLoginDTO);
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.init();
            this.t = getCallingPackage();
            Intent intent = getIntent();
            this.u = intent.getStringExtra(E);
            this.v = intent.getStringExtra(G);
            this.w = intent.getStringExtra(H);
            this.B = intent.getIntExtra(I, 0);
            this.C = intent.getStringExtra(J);
            this.x = intent.getStringExtra(M);
            this.y = intent.getStringExtra(K);
            if (TextUtils.isEmpty(this.t) || TextUtils.isEmpty(this.u) || TextUtils.isEmpty(this.v) || TextUtils.isEmpty(this.w)) {
                setResult(0, a(-202));
                finish();
                this.D = true;
            }
            if (!TextUtils.isEmpty(this.C) && !a(this.C)) {
                setResult(0, a(-202));
                finish();
                this.D = true;
            }
            String stringExtra = intent.getStringExtra(L);
            this.z = stringExtra;
            if (!TextUtils.isEmpty(stringExtra) && SapiUtils.versionCompareTo(this.z, "9.6.3.3") > 0) {
                setResult(0, a(-208));
                finish();
                this.D = true;
            }
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            try {
                setContentView(R.layout.obfuscated_res_0x7f0d0515);
                if (!b()) {
                    return;
                }
                this.configuration = SapiAccountManager.getInstance().getConfignation();
                init();
                if (this.D) {
                    return;
                }
                setupViews();
            } catch (Throwable unused) {
                setResult(0, a(-201));
                finish();
            }
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.setupViews();
            this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback(this) { // from class: com.baidu.sapi2.activity.OauthActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ OauthActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
                public boolean onBack() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                        return invokeV.booleanValue;
                    }
                    this.a.a();
                    return false;
                }
            });
            this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback(this) { // from class: com.baidu.sapi2.activity.OauthActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ OauthActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        OauthActivity oauthActivity = this.a;
                        oauthActivity.setResult(0, oauthActivity.a(-205));
                        this.a.finish();
                    }
                }
            });
            this.sapiWebView.setAuthorizationListener(new AuthorizationListener(this) { // from class: com.baidu.sapi2.activity.OauthActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ OauthActivity a;

                @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
                public void onFailed(int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i, str) == null) {
                    }
                }

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
                public void onSuccess() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                        return;
                    }
                    this.a.c();
                    SapiAccountManager.getGlobalCallback().onLoginStatusChange();
                }
            });
            SapiJsCallBacks.BdOauthCallback bdOauthCallback = new SapiJsCallBacks.BdOauthCallback(this) { // from class: com.baidu.sapi2.activity.OauthActivity.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ OauthActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.sapi2.SapiJsCallBacks.BdOauthCallback
                public void onCallback(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                        Intent intent = new Intent();
                        if (this.a.B == 0) {
                            Map<String, String> urlParamsToMap = SapiUtils.urlParamsToMap(str.substring(str.indexOf("#") + 1, str.length()));
                            if (urlParamsToMap.containsKey("error")) {
                                OauthActivity oauthActivity = this.a;
                                oauthActivity.setResult(0, oauthActivity.a(-204, urlParamsToMap.get("error")));
                            } else {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("refreshToken", urlParamsToMap.get("refresh_token"));
                                    jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_ACCESS_TOKEN, urlParamsToMap.get("access_token"));
                                    jSONObject.put("expiresIn", urlParamsToMap.get("expires_in"));
                                    jSONObject.put("scope", urlParamsToMap.get("scope"));
                                    jSONObject.put("extra", urlParamsToMap.get("extra"));
                                    jSONObject.put("code", urlParamsToMap.get("code"));
                                    jSONObject.put("state", urlParamsToMap.get("state"));
                                    intent.putExtra(OauthActivity.F, jSONObject.toString());
                                    this.a.setResult(-1, intent);
                                } catch (JSONException e) {
                                    Log.e(e);
                                    OauthActivity oauthActivity2 = this.a;
                                    oauthActivity2.setResult(0, oauthActivity2.a(-201));
                                }
                            }
                        } else {
                            try {
                                JSONObject jSONObject2 = new JSONObject(str);
                                int optInt = jSONObject2.optInt("errNo");
                                jSONObject2.optInt("msg");
                                if (optInt == -301) {
                                    this.a.setResult(0, this.a.a(-205));
                                    this.a.finish();
                                    return;
                                }
                                if (optInt != 400021 && optInt != 400022) {
                                    JSONObject jSONObject3 = new JSONObject();
                                    jSONObject3.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_ACCESS_TOKEN, jSONObject2.optString("access_token"));
                                    jSONObject3.put("openid", jSONObject2.optString("openid"));
                                    jSONObject3.put("expiresIn", jSONObject2.optString("expires_in"));
                                    jSONObject3.put("scope", this.a.w);
                                    jSONObject3.put("code", jSONObject2.optString("authorization_code"));
                                    jSONObject2.put("state", jSONObject2.optString("state"));
                                    intent.putExtra(OauthActivity.F, jSONObject3.toString());
                                    this.a.setResult(-1, intent);
                                }
                                this.a.d();
                                return;
                            } catch (JSONException e2) {
                                Log.e(e2);
                                OauthActivity oauthActivity3 = this.a;
                                oauthActivity3.setResult(0, oauthActivity3.a(-201));
                            }
                        }
                        this.a.finish();
                    }
                }
            };
            SapiJsCallBacks.BdOauthLoginParams bdOauthLoginParams = new SapiJsCallBacks.BdOauthLoginParams();
            bdOauthLoginParams.callingPkg = this.t;
            bdOauthLoginParams.callingAppId = this.u;
            bdOauthLoginParams.redirectUrl = this.v;
            bdOauthLoginParams.callback = bdOauthCallback;
            this.sapiWebView.setBdOauthLoginParams(bdOauthLoginParams);
            if (SapiAccountManager.getInstance().isLogin() && !TextUtils.isEmpty(SapiUtils.getCookiePtoken())) {
                c();
            } else {
                d();
            }
        }
    }
}
