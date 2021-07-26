package com.baidu.sapi2.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c0.a.f;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class GrantWebActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String A = "/passport/grantweb";
    public static final String y;
    public static final String z = "openapp";
    public transient /* synthetic */ FieldHolder $fh;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1541706362, "Lcom/baidu/sapi2/activity/GrantWebActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1541706362, "Lcom/baidu/sapi2/activity/GrantWebActivity;");
                return;
            }
        }
        y = GrantWebActivity.class.getSimpleName();
    }

    public GrantWebActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            if (SapiAccountManager.getCheckUrlIsAvailablelister() != null) {
                if (TextUtils.isEmpty(this.v)) {
                    this.v = this.u;
                }
                z2 = SapiAccountManager.getCheckUrlIsAvailablelister().onCheckUrlIsAvailable(this.v);
            } else {
                z2 = false;
            }
            String str = SapiAccountManager.getInstance().getConfignation().environment.getWap() + "/passport/login";
            HashMap hashMap = new HashMap();
            hashMap.put("client", "android");
            hashMap.put("clientfrom", "native");
            hashMap.put("suppcheck", "1");
            hashMap.put("adapter", "3");
            hashMap.put("channel_id", this.t);
            hashMap.put("wap_tpl", this.x);
            hashMap.put("tpl", SapiAccountManager.getInstance().getConfignation().tpl);
            hashMap.put("u", this.u);
            if (z2 && !"true".equals(this.w)) {
                hashMap.put("force", "false");
            } else {
                hashMap.put("force", "true");
            }
            String str2 = str + SapiUtils.mapToUrlParams(hashMap, false) + "#app_auth";
            Log.d(y, "url = " + str2);
            SapiWebView sapiWebView = this.sapiWebView;
            if (sapiWebView != null) {
                sapiWebView.loadUrl(str2);
            }
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.init();
            Uri data = getIntent().getData();
            if (data != null) {
                this.t = data.getQueryParameter("channel_id");
                this.u = data.getQueryParameter("u");
                this.v = data.getQueryParameter("nu");
                this.w = data.getQueryParameter("force");
                this.x = data.getQueryParameter("wap_tpl");
            }
            if (TextUtils.isEmpty(this.t)) {
                finish();
            }
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b();
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            try {
                setContentView(f.layout_sapi_sdk_webview_with_title_bar);
                if (d() && c()) {
                    init();
                    setupViews();
                    return;
                }
                finish();
            } catch (Throwable th) {
                Log.e(th);
                finish();
            }
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b();
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, intent) == null) {
            String str = y;
            Log.d(str, this + " onNewIntent");
            if (SapiAccountManager.getInstance().isLogin() && !TextUtils.isEmpty(SapiUtils.getCookiePtoken())) {
                e();
            } else {
                a(false);
            }
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.setupViews();
            SapiWebView sapiWebView = this.sapiWebView;
            if (sapiWebView != null) {
                sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback(this) { // from class: com.baidu.sapi2.activity.GrantWebActivity.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ GrantWebActivity f9788a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f9788a = this;
                    }

                    @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
                    public boolean onBack() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            this.f9788a.b();
                            return false;
                        }
                        return invokeV.booleanValue;
                    }
                });
                this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback(this) { // from class: com.baidu.sapi2.activity.GrantWebActivity.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ GrantWebActivity f9789a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f9789a = this;
                    }

                    @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
                    public void onFinish() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f9789a.finish();
                        }
                    }
                });
                this.sapiWebView.setAuthorizationListener(new AuthorizationListener(this) { // from class: com.baidu.sapi2.activity.GrantWebActivity.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ GrantWebActivity f9790a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f9790a = this;
                    }

                    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
                    public void onFailed(int i2, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                            Log.d(GrantWebActivity.y, "GrantWebPage login failed");
                            this.f9790a.finish();
                        }
                    }

                    @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
                    public void onSuccess(AccountType accountType) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, accountType) == null) {
                            this.f9790a.e();
                            SapiAccountManager.getGlobalCallback().onLoginStatusChange();
                        }
                    }
                });
                this.sapiWebView.setGrantWebCallback(new SapiJsCallBacks.GrantWebCallback(this) { // from class: com.baidu.sapi2.activity.GrantWebActivity.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ GrantWebActivity f9791a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f9791a = this;
                    }

                    @Override // com.baidu.sapi2.SapiJsCallBacks.GrantWebCallback
                    public void onGrant(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                            if (i2 == 0) {
                                Log.d(GrantWebActivity.y, "after grant web, then back to wap");
                                this.f9791a.finish();
                                return;
                            }
                            Log.d(GrantWebActivity.y, "after grant web, still stay in app");
                            if (SapiAccountManager.getCheckUrlIsAvailablelister() != null) {
                                if (TextUtils.isEmpty(this.f9791a.v)) {
                                    GrantWebActivity grantWebActivity = this.f9791a;
                                    grantWebActivity.v = grantWebActivity.u;
                                }
                                SapiAccountManager.getCheckUrlIsAvailablelister().handleWebPageUrl(this.f9791a.v);
                            }
                            this.f9791a.finish();
                        }
                    }
                });
                this.sapiWebView.setCurrentAccountBdussExpiredCallback(new SapiJsCallBacks.CurrentAccountBdussExpiredCallback(this) { // from class: com.baidu.sapi2.activity.GrantWebActivity.5
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ GrantWebActivity f9792a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f9792a = this;
                    }

                    @Override // com.baidu.sapi2.SapiJsCallBacks.CurrentAccountBdussExpiredCallback
                    public void onBdussExpired() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f9792a.a(true);
                        }
                    }
                });
            }
            if (SapiAccountManager.getInstance().isLogin() && !TextUtils.isEmpty(SapiUtils.getCookiePtoken())) {
                e();
            } else {
                a(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            SapiWebView sapiWebView = this.sapiWebView;
            if (sapiWebView != null && sapiWebView.canGoBack()) {
                this.sapiWebView.goBack();
                return;
            }
            StatService.onEvent("grant_web_cancel", new HashMap());
            finish();
        }
    }

    private boolean c() {
        InterceptResult invokeV;
        Uri data;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            Intent intent = getIntent();
            String scheme = intent.getScheme();
            if (!"android.intent.action.VIEW".equals(intent.getAction()) || (data = intent.getData()) == null) {
                return false;
            }
            String host = data.getHost();
            String path = data.getPath();
            String packageName = SapiAccountManager.getInstance().getConfignation().getContext().getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                packageName = "";
            }
            return z.equals(scheme) && packageName.equals(host) && A.equals(path);
        }
        return invokeV.booleanValue;
    }

    private boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            if (SapiAccountManager.getInstance().getConfignation() == null) {
                SapiAccountManager.getGlobalCallback().onNeedInitPassSdk();
            }
            if (SapiAccountManager.getInstance().getConfignation() == null) {
                Log.e(Log.TAG, "pass sdk has not been initialized");
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.BAIDU_LOGO_ID, this, z2) == null) {
            boolean z3 = SapiAccountManager.getInstance().getConfignation().supportFaceLogin;
            SapiAccountManager.getInstance().getConfignation().supportFaceLogin = false;
            LoginActivity.supportShareLogin = false;
            WebLoginDTO webLoginDTO = new WebLoginDTO();
            webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_USERNAME;
            WebLoginDTO.Config config = new WebLoginDTO.Config();
            config.fastLoginFeatureList = new ArrayList();
            webLoginDTO.config = config;
            webLoginDTO.businessType = 2005;
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            if (z2 && currentAccount != null) {
                webLoginDTO.encryptedId = currentAccount.uid;
                webLoginDTO.preSetUname = currentAccount.displayname;
            }
            CoreViewRouter.getInstance().startLogin(this, new WebAuthListener(this, z3) { // from class: com.baidu.sapi2.activity.GrantWebActivity.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ boolean f9793a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ GrantWebActivity f9794b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Boolean.valueOf(z3)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f9794b = this;
                    this.f9793a = z3;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFailure(WebAuthResult webAuthResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webAuthResult) == null) {
                        LoginActivity.supportShareLogin = true;
                        SapiAccountManager.getInstance().getConfignation().supportFaceLogin = this.f9793a;
                        this.f9794b.finish();
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onSuccess(WebAuthResult webAuthResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, webAuthResult) == null) {
                        this.f9794b.e();
                        SapiAccountManager.getGlobalCallback().onLoginStatusChange();
                        LoginActivity.supportShareLogin = true;
                        SapiAccountManager.getInstance().getConfignation().supportFaceLogin = this.f9793a;
                    }
                }
            }, webLoginDTO);
        }
    }
}
