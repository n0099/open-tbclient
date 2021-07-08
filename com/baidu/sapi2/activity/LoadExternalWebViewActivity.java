package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.BaiduRimConstants;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.result.ExtendSysWebViewMethodResult;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.b0.a.f;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class LoadExternalWebViewActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_BUSINESS_FROM = "business_from";
    public static final String EXTRA_BUSINESS_FROM_ONE_KEY_LOGIN = "business_from_one_key_login";
    public static final String EXTRA_BUSINESS_TYPE = "business_type";
    public static final String EXTRA_EXTERNAL_TITLE = "extra_external_title";
    public static final String EXTRA_EXTERNAL_URL = "extra_external_url";
    public static final String RESULT_BUSINESS_TYPE_ACCOUNT_FREEZE = "business_account_freeze";
    public static final String RESULT_BUSINESS_TYPE_PRE_SET_UNAME = "business_pre_set_username";
    public static final int x = 2001;
    public transient /* synthetic */ FieldHolder $fh;
    public String t;
    public String u;
    public String v;
    public AuthorizationListener w;
    public WebAuthResult webAuthResult;

    public LoadExternalWebViewActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.webAuthResult = new WebAuthResult(this) { // from class: com.baidu.sapi2.activity.LoadExternalWebViewActivity.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LoadExternalWebViewActivity f9806a;

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
                this.f9806a = this;
            }

            @Override // com.baidu.sapi2.shell.result.WebAuthResult
            public void finishActivity() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    super.finishActivity();
                    this.f9806a.finish();
                    CoreViewRouter.getInstance().release();
                }
            }

            @Override // com.baidu.sapi2.shell.result.WebAuthResult
            public void finishActivity(boolean z) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                    super.finishActivity();
                    this.f9806a.finish();
                    CoreViewRouter.getInstance().release();
                }
            }
        };
        this.w = new AuthorizationListener(this) { // from class: com.baidu.sapi2.activity.LoadExternalWebViewActivity.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LoadExternalWebViewActivity f9808a;

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
                this.f9808a = this;
            }

            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onFailed(int i4, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i4, str) == null) {
                    if ("business_from_one_key_login".equals(this.f9808a.v)) {
                        new OneKeyLoginSdkCall().loadOneKeyLoginFail(CoreViewRouter.getInstance().getOneKeyLoginCallback(), -103, null);
                    }
                    this.f9808a.webAuthResult.setResultCode(i4);
                    this.f9808a.webAuthResult.setResultMsg(str);
                    WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
                    if (webAuthListener != null) {
                        webAuthListener.onFailure(this.f9808a.webAuthResult);
                        CoreViewRouter.getInstance().release();
                    }
                    this.f9808a.setResult(0);
                    this.f9808a.finish();
                }
            }

            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onSuccess(AccountType accountType) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, accountType) == null) {
                    if ("business_from_one_key_login".equals(this.f9808a.v)) {
                        OneKeyLoginCallback oneKeyLoginCallback = CoreViewRouter.getInstance().getOneKeyLoginCallback();
                        OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
                        oneKeyLoginResult.setResultCode(0);
                        if (oneKeyLoginCallback != null) {
                            oneKeyLoginCallback.onSuccess(oneKeyLoginResult);
                        }
                    }
                    WebAuthListener webAuthListener = CoreViewRouter.getInstance().getWebAuthListener();
                    if (webAuthListener != null) {
                        WebAuthResult webAuthResult = this.f9808a.webAuthResult;
                        webAuthResult.accountType = accountType;
                        webAuthResult.setResultCode(0);
                        webAuthListener.onSuccess(this.f9808a.webAuthResult);
                        CoreViewRouter.getInstance().release();
                    }
                    Intent intent = new Intent();
                    intent.putExtra("account_type", accountType.getType());
                    this.f9808a.setResult(-1, intent);
                    this.f9808a.finish();
                }
            }
        };
    }

    @Override // com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.finish();
            if (CoreViewRouter.getInstance().getExtendSysWebViewMethodCallback() != null) {
                ExtendSysWebViewMethodResult extendSysWebViewMethodResult = new ExtendSysWebViewMethodResult();
                extendSysWebViewMethodResult.params.put(BaiduRimConstants.RETCODE_KEY, -301);
                extendSysWebViewMethodResult.params.put("retMsg", "您已取消操作");
                CoreViewRouter.getInstance().getExtendSysWebViewMethodCallback().onFinish(extendSysWebViewMethodResult);
            }
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
            this.t = getIntent().getStringExtra(EXTRA_EXTERNAL_TITLE);
            this.u = getIntent().getStringExtra("extra_external_url");
            this.v = getIntent().getStringExtra(EXTRA_BUSINESS_FROM);
            if (TextUtils.isEmpty(this.u)) {
                setResult(0);
                finish();
            }
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 2001 && i3 == -1) {
                this.loginStatusChange = true;
                setResult(-1, new Intent());
                finish();
            }
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onBottomBackBtnClick();
            a();
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onClose();
            finish();
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            try {
                setContentView(f.layout_sapi_sdk_webview_with_title_bar);
                init();
                setupViews();
            } catch (Throwable th) {
                reportWebviewError(th);
                finish();
            }
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onLeftBtnClick();
            if (this.executeSubClassMethod) {
                a();
            }
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.setupViews();
            this.sapiWebView.setAuthorizationListener(this.w);
            this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback(this) { // from class: com.baidu.sapi2.activity.LoadExternalWebViewActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LoadExternalWebViewActivity f9809a;

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
                    this.f9809a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
                public boolean onBack() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        this.f9809a.a();
                        return false;
                    }
                    return invokeV.booleanValue;
                }
            });
            this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback(this) { // from class: com.baidu.sapi2.activity.LoadExternalWebViewActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LoadExternalWebViewActivity f9810a;

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
                    this.f9810a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f9810a.finish();
                    }
                }
            });
            this.sapiWebView.setLeftBtnVisibleCallback(new SapiWebView.LeftBtnVisibleCallback(this) { // from class: com.baidu.sapi2.activity.LoadExternalWebViewActivity.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LoadExternalWebViewActivity f9811a;

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
                    this.f9811a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.LeftBtnVisibleCallback
                public void onLeftBtnVisible(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) {
                        if (i2 == 0) {
                            this.f9811a.setBtnVisibility(4, 4, 4);
                        } else {
                            this.f9811a.setBtnVisibility(4, 0, 4);
                        }
                    }
                }
            });
            this.sapiWebView.setCoverWebBdussCallback(new SapiWebView.CoverWebBdussCallback(this) { // from class: com.baidu.sapi2.activity.LoadExternalWebViewActivity.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LoadExternalWebViewActivity f9812a;

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
                    this.f9812a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.CoverWebBdussCallback
                public void onCoverBduss(String str, SapiWebView.CoverWebBdussResult coverWebBdussResult) {
                    SapiAccount currentAccount;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLL(1048576, this, str, coverWebBdussResult) == null) || (currentAccount = SapiContext.getInstance().getCurrentAccount()) == null || TextUtils.isEmpty(str) || str.equals(currentAccount.bduss)) {
                        return;
                    }
                    coverWebBdussResult.setWebBduss(currentAccount.bduss);
                }
            });
            this.sapiWebView.setSwitchAccountCallback(new SapiWebView.SwitchAccountCallback(this) { // from class: com.baidu.sapi2.activity.LoadExternalWebViewActivity.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LoadExternalWebViewActivity f9813a;

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
                    this.f9813a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.SwitchAccountCallback
                public void onAccountSwitch(SapiWebView.SwitchAccountCallback.Result result) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, result) == null) {
                        Intent intent = new Intent(this.f9813a, LoginActivity.class);
                        intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2003);
                        int i2 = result.switchAccountType;
                        if (i2 == 1) {
                            intent.putExtra("username", result.userName);
                        } else if (i2 == 2) {
                            if (result.loginType == 0) {
                                intent.putExtra(LoginActivity.EXTRA_LOGIN_TYPE, WebLoginDTO.EXTRA_LOGIN_WITH_USERNAME);
                            } else {
                                intent.putExtra(LoginActivity.EXTRA_LOGIN_TYPE, WebLoginDTO.EXTRA_LOGIN_WITH_SMS);
                            }
                            intent.putExtra(LoginActivity.EXTRA_LOGIN_FINISH_AFTER_SUC, true);
                            if (!TextUtils.isEmpty(result.displayName)) {
                                intent.putExtra("username", result.displayName);
                            }
                            intent.putExtra(LoginActivity.EXTRA_PARAM_ENCRYPTED_UID, result.encryptedUid);
                        }
                        this.f9813a.startActivityForResult(intent, 2001);
                    }
                }
            });
            this.sapiWebView.setAccountFreezeCallback(new SapiWebView.AccountFreezeCallback(this) { // from class: com.baidu.sapi2.activity.LoadExternalWebViewActivity.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LoadExternalWebViewActivity f9814a;

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
                    this.f9814a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.AccountFreezeCallback
                public void onAccountFreeze(SapiWebView.AccountFreezeCallback.AccountFreezeResult accountFreezeResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, accountFreezeResult) == null) {
                        Intent intent = new Intent();
                        intent.putExtra(LoadExternalWebViewActivity.EXTRA_BUSINESS_TYPE, LoadExternalWebViewActivity.RESULT_BUSINESS_TYPE_ACCOUNT_FREEZE);
                        this.f9814a.setResult(-1, intent);
                        this.f9814a.finish();
                    }
                }
            });
            this.sapiWebView.setPreFillUserNameCallback(new SapiWebView.PreFillUserNameCallback(this) { // from class: com.baidu.sapi2.activity.LoadExternalWebViewActivity.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LoadExternalWebViewActivity f9815a;

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
                    this.f9815a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.PreFillUserNameCallback
                public void onPreFillUserName(SapiWebView.PreFillUserNameCallback.PreFillUserNameResult preFillUserNameResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, preFillUserNameResult) == null) {
                        Intent intent = new Intent();
                        intent.putExtra(LoadExternalWebViewActivity.EXTRA_BUSINESS_TYPE, LoadExternalWebViewActivity.RESULT_BUSINESS_TYPE_PRE_SET_UNAME);
                        intent.putExtra("username", preFillUserNameResult.userName);
                        this.f9815a.setResult(-1, intent);
                    }
                }
            });
            this.sapiWebView.setWebviewPageFinishCallback(new SapiJsCallBacks.WebviewPageFinishCallback(this) { // from class: com.baidu.sapi2.activity.LoadExternalWebViewActivity.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ LoadExternalWebViewActivity f9807a;

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
                    this.f9807a = this;
                }

                @Override // com.baidu.sapi2.SapiJsCallBacks.WebviewPageFinishCallback
                public void onFinish(String str) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) || CoreViewRouter.getInstance().getExtendSysWebViewMethodCallback() == null) {
                        return;
                    }
                    ExtendSysWebViewMethodResult extendSysWebViewMethodResult = new ExtendSysWebViewMethodResult();
                    extendSysWebViewMethodResult.params.put("result", str);
                    CoreViewRouter.getInstance().getExtendSysWebViewMethodCallback().onFinish(extendSysWebViewMethodResult);
                }
            });
            ArrayList arrayList = new ArrayList();
            WebLoginDTO webLoginDTO = CoreViewRouter.getInstance().getWebLoginDTO();
            if (webLoginDTO != null && WebLoginDTO.statExtraValid(webLoginDTO.statExtra)) {
                arrayList.add(new PassNameValuePair("extrajson", webLoginDTO.statExtra));
            }
            this.sapiWebView.loadExternalUrl(this.u, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            SapiWebView sapiWebView = this.sapiWebView;
            if (sapiWebView != null && sapiWebView.canGoBack()) {
                this.sapiWebView.goBack();
            } else {
                finish();
            }
        }
    }
}
