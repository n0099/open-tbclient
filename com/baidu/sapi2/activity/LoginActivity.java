package com.baidu.sapi2.activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.JsPromptResult;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.enums.LoginTypes;
import com.baidu.sapi2.service.AbstractThirdPartyService;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareLoginModel;
import com.baidu.sapi2.share.ShareResultCallback;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.social.WXInvokeCallback;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.sapi2.utils.CommonUtil;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.PtokenStat;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LoginActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String E = "LoginActivity";
    public static final String EXTRA_LOGIN_FINISH_AFTER_SUC = "extra_login_finish_after_suc";
    public static final String EXTRA_LOGIN_TYPE = "extra_login_type";
    public static final String EXTRA_PARAM_ENCRYPTED_UID = "encryptedUid";
    public static final String EXTRA_PARAM_EXTRAS_JSON = "extraJson";
    public static final String EXTRA_PARAM_THIRD_VERIFY_RESPONSE = "response";
    public static final String EXTRA_PARAM_USERNAME = "username";
    public static final int F = 2005;
    public static final int FIX_FLAG_WINDOW_IS_PARTIALLY_OBSCURED = 2;
    public static final String G = "floating_window_tag";
    public static final String H = "login_page_tag";
    public static final int REQUEST_SHARE_V2_LOGIN = 2020;
    public static final int REQUEST_SOCIAL_LOGIN = 2001;
    public static boolean supportShareLogin = true;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String B;
    public List<PassNameValuePair> C;
    public AuthorizationListener D;
    public boolean mNeedSetContentView;
    public SapiWebView sapiWebView;
    public boolean t;
    public boolean u;
    public boolean v;
    public int w;
    public WebAuthResult webAuthResult;
    public String x;
    public String y;
    public String z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1323582129, "Lcom/baidu/sapi2/activity/LoginActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1323582129, "Lcom/baidu/sapi2/activity/LoginActivity;");
        }
    }

    public LoginActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.t = false;
        this.webAuthResult = new WebAuthResult(this) { // from class: com.baidu.sapi2.activity.LoginActivity.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LoginActivity a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.baidu.sapi2.shell.result.WebAuthResult
            public void finishActivity() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.finishActivity();
                    this.a.a(true);
                }
            }

            @Override // com.baidu.sapi2.shell.result.WebAuthResult
            public void finishActivity(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                    super.finishActivity();
                    this.a.a(false);
                }
            }
        };
        this.mNeedSetContentView = true;
        this.D = new AuthorizationListener(this) { // from class: com.baidu.sapi2.activity.LoginActivity.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ LoginActivity a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void beforeSuccess(SapiAccount sapiAccount) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, sapiAccount) == null) {
                    super.beforeSuccess(sapiAccount);
                    WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
                    if (webAuthListener != null) {
                        webAuthListener.beforeSuccess(sapiAccount);
                    }
                }
            }

            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onFailed(int i4, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i4, str) == null) {
                    if (this.a.w == 2003) {
                        this.a.setResult(0);
                        return;
                    }
                    this.a.webAuthResult.setResultCode(i4);
                    this.a.webAuthResult.setResultMsg(str);
                    LoginActivity loginActivity = this.a;
                    loginActivity.loginFail(loginActivity.webAuthResult);
                }
            }

            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public boolean onForgetPwd() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    this.a.startActivity(new Intent(this.a, ForgetPwdActivity.class));
                    return true;
                }
                return invokeV.booleanValue;
            }

            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onSuccess(AccountType accountType) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048579, this, accountType) == null) {
                    super.onSuccess(accountType);
                    this.a.a(accountType, false);
                }
            }
        };
    }

    @Override // com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    @TargetApi(5)
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.finish();
            if (this.w == 2005) {
                startActivity(new Intent(this, GrantWebActivity.class));
            }
            SocialLoginBase.setWXLoginCallback(null);
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public SapiWebDTO getWebDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? CoreViewRouter.getInstance().getWebLoginDTO() : (SapiWebDTO) invokeV.objValue;
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.init();
            this.webAuthResult.activity = this;
            this.v = getIntent().getBooleanExtra(EXTRA_LOGIN_FINISH_AFTER_SUC, true);
        }
    }

    public void loginFail(WebAuthResult webAuthResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, webAuthResult) == null) {
            if (this.w == 2003) {
                finish();
                return;
            }
            WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
            if (webAuthListener != null) {
                webAuthListener.onFailure(webAuthResult);
            }
            finish();
            if (b()) {
                CoreViewRouter.getInstance().release();
            }
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        int intExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048580, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            new ShareCallPacking().onLoginActivityActivityResult(new ShareCallPacking.ShareLoginCallBack(this) { // from class: com.baidu.sapi2.activity.LoginActivity.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LoginActivity a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.baidu.sapi2.share.ShareCallPacking.ShareLoginCallBack
                public void onSuccess() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.a(AccountType.NORMAL, false);
                    }
                }
            }, i2, i3, intent, this.C, "pass");
            if ((i2 == 2001 && i3 == 1001) || this.t) {
                a((AccountType) null, true);
                this.t = false;
            } else if (i2 == 2005) {
                if (i3 == -1) {
                    String str2 = "";
                    if (intent != null) {
                        str2 = intent.getStringExtra(LoadExternalWebViewActivity.EXTRA_BUSINESS_TYPE);
                        str = intent.getStringExtra("username");
                    } else {
                        str = "";
                    }
                    if (LoadExternalWebViewActivity.RESULT_BUSINESS_TYPE_PRE_SET_UNAME.equals(str2)) {
                        this.sapiWebView.preSetUserName(str);
                    } else if (LoadExternalWebViewActivity.RESULT_BUSINESS_TYPE_ACCOUNT_FREEZE.equals(str2)) {
                        this.webAuthResult.isAccountFreeze = true;
                    } else {
                        if (intent == null) {
                            intExtra = AccountType.UNKNOWN.getType();
                        } else {
                            intExtra = intent.getIntExtra("account_type", AccountType.UNKNOWN.getType());
                        }
                        a(AccountType.getAccountType(intExtra), false);
                    }
                }
            } else if (i2 == 2020) {
                a(AccountType.NORMAL, false);
            } else if (i2 == 100004) {
                ShareLoginModel.getInstance().processShareResult(this, intent, new ShareResultCallback(this) { // from class: com.baidu.sapi2.activity.LoginActivity.11
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LoginActivity a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // com.baidu.sapi2.share.ShareResultCallback
                    public void onResultAccount(SapiAccount sapiAccount) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, sapiAccount) == null) {
                            WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
                            if (sapiAccount == null) {
                                Toast.makeText(this.a, "授权失败，请选择其他方式登录", 0).show();
                                WebLoginDTO webLoginDTO = new WebLoginDTO();
                                webLoginDTO.excludeTypes = LoginTypes.SHARE;
                                CoreViewRouter.getInstance().startLogin(webAuthListener, webLoginDTO);
                                return;
                            }
                            if (webAuthListener != null) {
                                WebAuthResult webAuthResult = new WebAuthResult();
                                webAuthResult.accountType = AccountType.NORMAL;
                                webAuthResult.setResultCode(0);
                                webAuthListener.onSuccess(webAuthResult);
                            }
                            this.a.finish();
                            CoreViewRouter.getInstance().release();
                        }
                    }
                });
            }
            if (i2 == 2001 && i3 == 3001) {
                a(intent);
            }
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.sapiWebView.back();
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onClose();
            this.webAuthResult.setResultCode(-301);
            this.webAuthResult.setResultMsg("您已取消操作");
            loginFail(this.webAuthResult);
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        SapiWebView sapiWebView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            try {
                if (this.mNeedSetContentView) {
                    setContentView(R.layout.layout_sapi_sdk_webview_with_title_bar);
                }
                init();
                setupViews();
                a();
                StatService.onEvent(H, new HashMap());
                SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
                if (confignation == null || !confignation.isAgreeDangerousProtocol()) {
                    CommonUtil.showErrorNotice("需要同意隐私协议并同步pass");
                }
                if (getWebDTO() == null || (sapiWebView = this.sapiWebView) == null) {
                    return;
                }
                sapiWebView.mExcludeTypes = getWebDTO().excludeTypes;
            } catch (Throwable th) {
                reportWebviewError(th);
                this.webAuthResult.setResultCode(-202);
                this.webAuthResult.setResultMsg("网络连接失败，请检查网络设置");
                loginFail(this.webAuthResult);
            }
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onLeftBtnClick();
            if (this.executeSubClassMethod) {
                this.sapiWebView.back();
            }
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, intent) == null) {
            super.onNewIntent(intent);
            this.sapiWebView.mExcludeTypes = LoginTypes.SHARE;
            setTitleText(R.string.sapi_sdk_title_sms_login);
            this.sapiWebView.loadLogin(1, this.C);
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onRightBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onRightBtnClick();
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.setupViews();
            WebLoginDTO webLoginDTO = CoreViewRouter.getInstance().getWebLoginDTO();
            this.C = webLoginDTO != null ? webLoginDTO.extraParams : new ArrayList<>();
            this.w = getIntent().getIntExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2001);
            this.x = getIntent().getStringExtra("username");
            this.y = webLoginDTO != null ? webLoginDTO.preLoginName : "";
            this.z = getIntent().getStringExtra(EXTRA_LOGIN_TYPE);
            this.A = getIntent().getStringExtra(EXTRA_PARAM_ENCRYPTED_UID);
            this.B = getIntent().getStringExtra("extraJson");
            SapiWebView sapiWebView = (SapiWebView) findViewById(R.id.sapi_webview);
            this.sapiWebView = sapiWebView;
            sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback(this) { // from class: com.baidu.sapi2.activity.LoginActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LoginActivity a;

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
                    this.a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.onClose();
                    }
                }
            });
            this.sapiWebView.setAuthorizationListener(this.D);
            this.sapiWebView.setSocialLoginHandler(new Handler(this) { // from class: com.baidu.sapi2.activity.LoginActivity.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LoginActivity a;

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
                    this.a = this;
                }

                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, message) == null) {
                        super.handleMessage(message);
                        AbstractThirdPartyService thirdPartyService = CoreViewRouter.getInstance().getThirdPartyService();
                        if (thirdPartyService != null) {
                            LoginActivity loginActivity = this.a;
                            thirdPartyService.loadThirdPartyLogin(loginActivity, (SocialType) message.obj, loginActivity.w, this.a.B);
                            SocialLoginBase.setWXLoginCallback(new WXInvokeCallback(this) { // from class: com.baidu.sapi2.activity.LoginActivity.5.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass5 a;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.a = this;
                                }

                                @Override // com.baidu.sapi2.social.WXInvokeCallback
                                public void onResult(int i2, Intent intent) {
                                    Interceptable interceptable3 = $ic;
                                    if ((interceptable3 == null || interceptable3.invokeIL(1048576, this, i2, intent) == null) && i2 == 1001) {
                                        this.a.a.t = true;
                                    }
                                }
                            });
                        }
                    }
                }
            });
            this.sapiWebView.setLoadExternalWebViewCallback(new SapiWebView.LoadExternalWebViewCallback(this) { // from class: com.baidu.sapi2.activity.LoginActivity.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LoginActivity a;

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
                    this.a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.LoadExternalWebViewCallback
                public void loadExternalWebview(SapiWebView.LoadExternalWebViewResult loadExternalWebViewResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, loadExternalWebViewResult) == null) {
                        Intent intent = new Intent(this.a, LoadExternalWebViewActivity.class);
                        intent.putExtra(LoadExternalWebViewActivity.EXTRA_EXTERNAL_TITLE, loadExternalWebViewResult.defaultTitle);
                        intent.putExtra("extra_external_url", loadExternalWebViewResult.externalUrl);
                        this.a.startActivityForResult(intent, 2005);
                    }
                }
            });
            this.sapiWebView.loadHistoryLogin(new SapiWebView.HistoryLoginCallback(this) { // from class: com.baidu.sapi2.activity.LoginActivity.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LoginActivity a;

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
                    this.a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.HistoryLoginCallback
                public void onSuccess() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(1048576, this) == null) && this.a.v) {
                        this.a.finish();
                    }
                }
            });
            if (supportShareLogin) {
                this.sapiWebView.setShareAccountClickCallback(new SapiWebView.ShareAccountClickCallback(this) { // from class: com.baidu.sapi2.activity.LoginActivity.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ LoginActivity a;

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
                        this.a = this;
                    }

                    @Override // com.baidu.sapi2.SapiWebView.ShareAccountClickCallback
                    public void onClick(String str, String str2, String str3, String str4, String str5) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLLLLL(1048576, this, str, str2, str3, str4, str5) == null) {
                            ShareLoginStat.MakeShareLoginStat.statExtMap.put(ShareLoginStat.MakeShareLoginStat.KEY_FROM_PKG, str);
                            if (ShareLoginModel.getInstance().isMeetShareV4(this.a, str)) {
                                Log.d(LoginActivity.E, "openShareLogin: is meet share_v4");
                                ShareLoginStat.MakeShareLoginStat.statExtMap.put(ShareLoginStat.MakeShareLoginStat.KEY_NEED_AUTH, "0");
                                ShareLoginModel.getInstance().openV4ShareLogin(this.a, str, "pass");
                                return;
                            }
                            Log.d(LoginActivity.E, "openShareLogin: is not share_v4");
                            ShareLoginStat.MakeShareLoginStat.statExtMap.put(ShareLoginStat.MakeShareLoginStat.KEY_NEED_AUTH, "1");
                            ShareCallPacking shareCallPacking = new ShareCallPacking();
                            LoginActivity loginActivity = this.a;
                            shareCallPacking.startLoginShareActivityForResult(loginActivity, str, str2, str3, str4, loginActivity.C, str5, "pass");
                        }
                    }
                });
            }
            this.sapiWebView.setIsForbidRecord(new SapiJsCallBacks.IsForbidRecordCallBack(this) { // from class: com.baidu.sapi2.activity.LoginActivity.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LoginActivity a;

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
                    this.a = this;
                }

                @Override // com.baidu.sapi2.SapiJsCallBacks.IsForbidRecordCallBack
                public void onForbidRecord(Boolean bool) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                        if (bool.booleanValue()) {
                            this.a.getWindow().addFlags(8192);
                        } else {
                            this.a.getWindow().clearFlags(8192);
                        }
                    }
                }
            });
            SapiJsCallBacks.JoinLoginParams joinLoginParams = new SapiJsCallBacks.JoinLoginParams();
            if (!TextUtils.isEmpty(this.A) && !TextUtils.isEmpty(this.x)) {
                if (webLoginDTO == null) {
                    webLoginDTO = new WebLoginDTO();
                }
                webLoginDTO.encryptedId = this.A;
                webLoginDTO.preSetUname = this.x;
            }
            if (webLoginDTO != null) {
                if (!TextUtils.isEmpty(webLoginDTO.encryptedId) || !TextUtils.isEmpty(webLoginDTO.uid) || !TextUtils.isEmpty(webLoginDTO.preSetUname)) {
                    SapiJsCallBacks.DirectedLoginParams directedLoginParams = new SapiJsCallBacks.DirectedLoginParams();
                    directedLoginParams.uid = webLoginDTO.uid;
                    directedLoginParams.encryptedId = webLoginDTO.encryptedId;
                    directedLoginParams.displayname = webLoginDTO.preSetUname;
                    this.C.add(SapiWebView.EXTRA_SUPPORT_DIRECT_LOGIN);
                    this.sapiWebView.setDirectedLoginParams(directedLoginParams);
                }
                if (WebLoginDTO.statExtraValid(webLoginDTO.statExtra)) {
                    this.C.add(new PassNameValuePair("extrajson", WebLoginDTO.getStatExtraDecode(webLoginDTO.statExtra)));
                }
                SapiWebView sapiWebView2 = this.sapiWebView;
                sapiWebView2.shareV2Disable = webLoginDTO.shareV2Disable;
                joinLoginParams.agreement = webLoginDTO.agreement;
                sapiWebView2.setHideSuccessTip(webLoginDTO.hideSuccessTip);
                WebLoginDTO.Config config = webLoginDTO.config;
                if (config != null) {
                    this.sapiWebView.supportTouchGuide = config.supportTouchGuide;
                }
                this.C.add(new PassNameValuePair(SapiWebView.PARAMS_SCREEN_TYPE, String.valueOf(webLoginDTO.screenType)));
                this.C.add(new PassNameValuePair(SapiWebView.PARAMS_IS_ACCEPT_BROWSEMODE_AGREEMENT, String.valueOf(webLoginDTO.isAcceptBrowseModeAgreement)));
            }
            if (!TextUtils.isEmpty(this.B)) {
                try {
                    JSONObject jSONObject = new JSONObject(this.B);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        this.C.add(new PassNameValuePair(next, jSONObject.getString(next)));
                    }
                } catch (JSONException e2) {
                    Log.e(e2);
                }
            }
            if (WebLoginDTO.EXTRA_JOIN_LOGIN_WITH_THIRD_ACCOUNT.equals(this.z)) {
                joinLoginParams.hasThirdAccount = true;
            } else {
                joinLoginParams.hasThirdAccount = false;
            }
            this.sapiWebView.setJoinLoingParams(joinLoginParams);
            setNewLoginTitleAndSetStyleChangeCallBack();
            if (!WebLoginDTO.EXTRA_JOIN_LOGIN_WITH_THIRD_ACCOUNT.equals(this.z) && !WebLoginDTO.EXTRA_JOIN_LOGIN_WITHOUT_THIRD_ACCOUNT.equals(this.z)) {
                if (WebLoginDTO.EXTRA_LOGIN_WITH_SMS.equals(this.z)) {
                    setTitleText(R.string.sapi_sdk_title_sms_login);
                    this.sapiWebView.loadLogin(1, this.C);
                    return;
                } else if (WebLoginDTO.EXTRA_LOGIN_WITH_NAME_PHONE_EMAIL.equals(this.z)) {
                    this.sapiWebView.loadLogin(6, this.C);
                    return;
                } else if (WebLoginDTO.EXTRA_LOGIN_WITH_PRE_LOGIN_NAME.equals(this.z)) {
                    if (!TextUtils.isEmpty(this.y)) {
                        this.C.add(new PassNameValuePair(SapiWebView.PARAMS_LOGIN_WITH_PRE_LOGIN_NAME, this.y));
                    }
                    this.sapiWebView.loadLogin(7, this.C);
                    return;
                } else {
                    if (!TextUtils.isEmpty(this.x)) {
                        this.C.add(new PassNameValuePair(SapiWebView.PARAMS_LOGIN_WITH_USER_NAME, this.x));
                    }
                    setTitleText(R.string.sapi_sdk_title_login);
                    this.sapiWebView.loadLogin(this.C);
                    return;
                }
            }
            this.sapiWebView.loadLogin(4, this.C);
        }
    }

    private boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) ? this.w != 2003 && CoreViewRouter.getInstance().getWebBindWidgetDTO() == null && CoreViewRouter.getInstance().getAccountCenterDTO() == null : invokeV.booleanValue;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
            SapiWebView sapiWebView = this.sapiWebView;
            if (sapiWebView == null || confignation == null || !confignation.supportCheckFloatfLayer) {
                return;
            }
            sapiWebView.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.baidu.sapi2.activity.LoginActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LoginActivity a;

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
                    this.a = this;
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, view, motionEvent)) == null) {
                        if (this.a.u) {
                            return false;
                        }
                        if (((motionEvent.getFlags() & 1) != 0 || (motionEvent.getFlags() & 2) != 0) && motionEvent.getAction() == 1) {
                            int height = this.a.getWindowManager().getDefaultDisplay().getHeight();
                            Toast makeText = Toast.makeText(this.a, "有悬浮窗遮挡，请注意信息安全！", 0);
                            makeText.setGravity(80, 0, (height / 2) - ((int) ((Resources.getSystem().getDisplayMetrics().density * 70.0f) + 0.5f)));
                            makeText.show();
                            this.a.u = true;
                            StatService.onEvent(LoginActivity.G, new HashMap());
                        }
                        return false;
                    }
                    return invokeLL.booleanValue;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AccountType accountType, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65543, this, accountType, z) == null) {
            PtokenStat ptokenStat = new PtokenStat();
            ptokenStat.onEvent(PtokenStat.LOGIN + SapiUtils.getLastLoginType());
            if (this.w == 2003) {
                SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
                Intent intent = new Intent();
                intent.putExtra("bduss", currentAccount.bduss);
                setResult(-1, intent);
                if (this.v) {
                    finish();
                }
            } else if (z) {
                finish();
                if (b()) {
                    CoreViewRouter.getInstance().release();
                }
            } else {
                WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
                if (webAuthListener != null) {
                    WebAuthResult webAuthResult = this.webAuthResult;
                    webAuthResult.accountType = accountType;
                    webAuthResult.setResultCode(0);
                    webAuthListener.onSuccess(this.webAuthResult);
                }
                if (this.v) {
                    finish();
                    if (b()) {
                        CoreViewRouter.getInstance().release();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, this, z) == null) {
            finish();
            if (b() && z) {
                CoreViewRouter.getInstance().release();
            }
        }
    }

    private void a(Intent intent) {
        SapiWebView sapiWebView;
        SapiJsCallBacks.CallBacks jsCallBacks;
        JsPromptResult promptResult;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, intent) == null) || (sapiWebView = this.sapiWebView) == null || (jsCallBacks = sapiWebView.getJsCallBacks()) == null || (promptResult = jsCallBacks.getPromptResult()) == null) {
            return;
        }
        if (intent == null) {
            promptResult.cancel();
            return;
        }
        try {
            promptResult.confirm(intent.getStringExtra("response"));
        } catch (Exception unused) {
            promptResult.cancel();
        }
    }
}
