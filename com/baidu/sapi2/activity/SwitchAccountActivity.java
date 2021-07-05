package com.baidu.sapi2.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SwitchAccountDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.e0.a.f;
import d.a.e0.a.g;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SwitchAccountActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String w = "https://wappass.baidu.com/v6/changeAccount";
    public transient /* synthetic */ FieldHolder $fh;
    public WebAuthResult t;
    public WebAuthListener u;
    public SwitchAccountDTO v;

    public SwitchAccountActivity() {
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
        this.t = new WebAuthResult(this) { // from class: com.baidu.sapi2.activity.SwitchAccountActivity.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ SwitchAccountActivity f9869a;

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
                this.f9869a = this;
            }

            @Override // com.baidu.sapi2.shell.result.WebAuthResult
            public void finishActivity() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f9869a.finish();
                    CoreViewRouter.getInstance().release();
                }
            }
        };
    }

    private String b() {
        InterceptResult invokeV;
        WebBackForwardList copyBackForwardList;
        WebHistoryItem currentItem;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            SapiWebView sapiWebView = this.sapiWebView;
            if (sapiWebView == null || (copyBackForwardList = sapiWebView.copyBackForwardList()) == null || copyBackForwardList.getSize() == 0 || (currentItem = copyBackForwardList.getCurrentItem()) == null) {
                return null;
            }
            return currentItem.getUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.init();
            this.u = CoreViewRouter.getInstance().getWebAuthListener();
            SwitchAccountDTO switchAccountDTO = CoreViewRouter.getInstance().getSwitchAccountDTO();
            this.v = switchAccountDTO;
            if (switchAccountDTO != null && this.u != null) {
                setupViews();
                return;
            }
            this.t.setResultCode(-204);
            a(this.t);
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onBottomBackBtnClick();
            a();
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onClose();
            this.t.setResultCode(-301);
            a(this.t);
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            try {
                setContentView(f.layout_sapi_sdk_webview_with_title_bar);
                init();
            } catch (Throwable th) {
                reportWebviewError(th);
                this.t.setResultCode(-202);
                a(this.t);
            }
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onLeftBtnClick();
            if (this.executeSubClassMethod) {
                a();
            }
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.setupViews();
            setTitleText(g.sapi_sdk_title_switch);
            SapiWebView sapiWebView = this.sapiWebView;
            sapiWebView.showSwitchAccount = this.configuration.supportMultipleAccounts;
            sapiWebView.showLinkAccount = this.v.supportQueryAssociatedAccount;
            sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback(this) { // from class: com.baidu.sapi2.activity.SwitchAccountActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SwitchAccountActivity f9870a;

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
                    this.f9870a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f9870a.onClose();
                    }
                }
            });
            this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback(this) { // from class: com.baidu.sapi2.activity.SwitchAccountActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SwitchAccountActivity f9871a;

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
                    this.f9871a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
                public boolean onBack() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        this.f9871a.a();
                        return false;
                    }
                    return invokeV.booleanValue;
                }
            });
            this.sapiWebView.setAuthorizationListener(new AuthorizationListener(this) { // from class: com.baidu.sapi2.activity.SwitchAccountActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SwitchAccountActivity f9872a;

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
                    this.f9872a = this;
                }

                @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
                public void onFailed(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                        this.f9872a.a(i2, str);
                    }
                }

                @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
                public void onSuccess(AccountType accountType) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, accountType) == null) {
                        super.onSuccess();
                        this.f9872a.a(accountType);
                    }
                }
            });
            this.sapiWebView.setSwitchAccountCallback(new SapiWebView.SwitchAccountCallback(this) { // from class: com.baidu.sapi2.activity.SwitchAccountActivity.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SwitchAccountActivity f9873a;

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
                    this.f9873a = this;
                }

                @Override // com.baidu.sapi2.SapiWebView.SwitchAccountCallback
                public void onAccountSwitch(SapiWebView.SwitchAccountCallback.Result result) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, result) == null) {
                        WebLoginDTO webLoginDTO = new WebLoginDTO();
                        webLoginDTO.finishActivityAfterSuc = false;
                        int i2 = result.switchAccountType;
                        if (i2 == 1) {
                            webLoginDTO.preSetUname = result.userName;
                        } else if (i2 == 2) {
                            if (result.loginType == 0) {
                                webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_USERNAME;
                            } else {
                                webLoginDTO.loginType = WebLoginDTO.EXTRA_LOGIN_WITH_SMS;
                            }
                            if (!TextUtils.isEmpty(result.displayName)) {
                                webLoginDTO.preSetUname = result.displayName;
                            }
                            webLoginDTO.encryptedId = result.encryptedUid;
                        }
                        if (!TextUtils.isEmpty(result.extraJson)) {
                            webLoginDTO.extraJson = result.extraJson;
                        }
                        CoreViewRouter.getInstance().startLogin(this.f9873a, new WebAuthListener(this) { // from class: com.baidu.sapi2.activity.SwitchAccountActivity.5.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass5 f9874a;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f9874a = this;
                            }

                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.sapi2.callback.SapiCallback
                            public void onFailure(WebAuthResult webAuthResult) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, webAuthResult) == null) {
                                    this.f9874a.f9873a.a(webAuthResult.getResultCode(), webAuthResult.getResultMsg());
                                }
                            }

                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // com.baidu.sapi2.callback.SapiCallback
                            public void onSuccess(WebAuthResult webAuthResult) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048579, this, webAuthResult) == null) {
                                    webAuthResult.finishActivity(false);
                                    this.f9874a.f9873a.a(webAuthResult.accountType);
                                    if (this.f9874a.f9873a.sapiWebView != null) {
                                        ArrayList arrayList = new ArrayList();
                                        arrayList.add(new PassNameValuePair("changeAccountSuc", "1"));
                                        this.f9874a.f9873a.sapiWebView.loadSwitchAccount(arrayList);
                                    }
                                }
                            }
                        }, webLoginDTO);
                    }
                }
            });
            this.sapiWebView.loadSwitchAccount(new ArrayList());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            b();
            SapiWebView sapiWebView = this.sapiWebView;
            if (sapiWebView != null && sapiWebView.canGoBack()) {
                String b2 = b();
                if (b2 != null && b2.startsWith(w)) {
                    onClose();
                    return;
                } else {
                    this.sapiWebView.goBack();
                    return;
                }
            }
            onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AccountType accountType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, accountType) == null) {
            this.t.setResultCode(0);
            WebAuthResult webAuthResult = this.t;
            webAuthResult.accountType = accountType;
            this.u.onSuccess(webAuthResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65538, this, i2, str) == null) {
            this.t.setResultCode(i2);
            this.t.setResultMsg(str);
            this.u.onFailure(this.t);
        }
    }

    private void a(WebAuthResult webAuthResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, webAuthResult) == null) {
            WebAuthListener webAuthListener = this.u;
            if (webAuthListener != null) {
                webAuthListener.onFailure(webAuthResult);
            }
            finish();
            CoreViewRouter.getInstance().release();
        }
    }
}
