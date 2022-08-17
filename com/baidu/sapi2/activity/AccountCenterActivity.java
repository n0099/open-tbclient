package com.baidu.sapi2.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiJsCallBacks;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.AccountCenterCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.dto.AccountCenterDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.result.AccountCenterResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.sapi2.views.ViewUtility;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class AccountCenterActivity extends SlideActiviy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_LOAD_WEIXIN = "extra_load_weixin";
    public static final String EXTRA_WEIIXIN_BIND_URL = "extra_weixin_bind_url";
    public static final String H;
    public static final String I = "AccountCenterActivity";
    public transient /* synthetic */ FieldHolder $fh;
    public List<PassNameValuePair> C;
    public String D;
    public String E;
    public String F;
    public AccountCenterResult G;
    public boolean mIsAccountCenterTitleBar;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-965595304, "Lcom/baidu/sapi2/activity/AccountCenterActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-965595304, "Lcom/baidu/sapi2/activity/AccountCenterActivity;");
                return;
            }
        }
        H = AccountCenterActivity.class.getSimpleName();
    }

    public AccountCenterActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.G = new AccountCenterResult();
        this.mIsAccountCenterTitleBar = true;
    }

    @Override // com.baidu.sapi2.activity.SlideActiviy
    public void finishActivityAfterSlideOver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (I.equals(getClass().getSimpleName())) {
                this.G.setResultCode(-301);
                this.G.setResultMsg("您已取消操作");
                a(this.G);
                return;
            }
            super.finish();
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public SapiWebDTO getWebDTO() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? CoreViewRouter.getInstance().getAccountCenterDTO() : (SapiWebDTO) invokeV.objValue;
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.init();
            AccountCenterDTO accountCenterDTO = CoreViewRouter.getInstance().getAccountCenterDTO();
            if (accountCenterDTO == null) {
                this.G.setResultCode(-204);
                this.G.setResultMsg("参数错误，请稍后再试");
                a(this.G);
                return;
            }
            this.D = accountCenterDTO.bduss;
            this.E = accountCenterDTO.refer;
            List<PassNameValuePair> list = accountCenterDTO.paramsList;
            this.C = list;
            this.F = accountCenterDTO.accountToolsUrl;
            if (list != null) {
                list.add(new PassNameValuePair(SlideActiviy.EXTRA_PARAMS_SLIDE_PAGE, "1"));
            }
        }
    }

    public void loadAccountCenter(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (!TextUtils.isEmpty(str)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add("pp");
                SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback(this) { // from class: com.baidu.sapi2.activity.AccountCenterActivity.13
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ AccountCenterActivity a;

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
                    public void onFailure(GetTplStokenResult getTplStokenResult) {
                        AccountCenterActivity accountCenterActivity;
                        SapiWebView sapiWebView;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, getTplStokenResult) == null) || (sapiWebView = (accountCenterActivity = this.a).sapiWebView) == null) {
                            return;
                        }
                        sapiWebView.loadAccountCenter(accountCenterActivity.C, null, this.a.E);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onSuccess(GetTplStokenResult getTplStokenResult) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeL(1048580, this, getTplStokenResult) == null) || this.a.sapiWebView == null) {
                            return;
                        }
                        AccountCenterActivity accountCenterActivity = this.a;
                        accountCenterActivity.sapiWebView.loadAccountCenter(accountCenterActivity.C, getTplStokenResult.tplStokenMap.get("pp"), this.a.E);
                    }
                }, str, arrayList);
                return;
            }
            this.G.setResultCode(-204);
            this.G.setResultMsg("参数错误，请稍后再试");
            a(this.G);
        }
    }

    @Override // com.baidu.sapi2.activity.SlideActiviy
    public void loadSlideWebview(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) && SlideActiviy.ACCOUNT_CENTER_PAGE_NAME.equals(str) && !TextUtils.isEmpty(str2)) {
            Intent intent = new Intent(this, AccountCenterExternalActivity.class);
            String queryParameter = Uri.parse(str2).getQueryParameter("topNavType");
            if (!TextUtils.isEmpty(queryParameter) && "1".equals(queryParameter)) {
                intent.putExtra(AccountCenterExternalActivity.EXTRA_EXTERNAL_IS_ACCOUNT_CENTER_TITLEBAR, true);
            }
            intent.putExtra("extra_external_url", str2);
            startActivity(intent);
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i == 1004 && i2 == -1) {
                String stringExtra = intent.getStringExtra("bduss");
                this.D = stringExtra;
                loadAccountCenter(stringExtra);
                this.loginStatusChange = true;
            }
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onBottomBackBtnClick();
            if (TextUtils.isEmpty(this.F)) {
                this.sapiWebView.back();
                return;
            }
            SapiWebView sapiWebView = this.sapiWebView;
            if (sapiWebView != null && sapiWebView.canGoBack()) {
                this.sapiWebView.goBack();
            } else {
                onClose();
            }
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onClose();
            this.G.setResultCode(-301);
            this.G.setResultMsg("您已取消操作");
            a(this.G);
        }
    }

    @Override // com.baidu.sapi2.activity.SlideActiviy, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            try {
                setContentView(R.layout.obfuscated_res_0x7f0d04f4);
                init();
                setupViews();
            } catch (Throwable th) {
                reportWebviewError(th);
                this.G.setResultCode(-202);
                this.G.setResultMsg("网络连接失败，请检查网络设置");
                a(this.G);
            }
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroy();
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048586, this, i, keyEvent)) == null) {
            if (i != 4) {
                return super.onKeyDown(i, keyEvent);
            }
            if (TextUtils.isEmpty(this.F)) {
                this.sapiWebView.onKeyUp(i);
                return true;
            }
            SapiWebView sapiWebView = this.sapiWebView;
            if (sapiWebView != null && sapiWebView.canGoBack()) {
                this.sapiWebView.goBack();
            } else {
                onClose();
            }
            return true;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onLeftBtnClick();
            if (this.executeSubClassMethod) {
                if (TextUtils.isEmpty(this.F)) {
                    this.sapiWebView.back();
                    return;
                }
                SapiWebView sapiWebView = this.sapiWebView;
                if (sapiWebView != null && sapiWebView.canGoBack()) {
                    this.sapiWebView.goBack();
                } else {
                    onClose();
                }
            }
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, intent) == null) {
            super.onNewIntent(intent);
            setIntent(intent);
            String str = H;
            Log.d(str, this + " onNewintent");
            if (AccountCenterActivity.class.getSimpleName().equals(getClass().getSimpleName())) {
                String stringExtra = intent == null ? "" : intent.getStringExtra("action");
                String str2 = H;
                Log.d(str2, this + " slide action is " + stringExtra);
                if (SlideActiviy.SLIDE_ACTION_QUIT.equals(stringExtra)) {
                    finishActivityAfterSlideOver();
                }
            }
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048589, this, i, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onRightBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onRightBtnClick();
        }
    }

    @Override // com.baidu.sapi2.activity.SlideActiviy, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.setupViews();
            AccountCenterDTO accountCenterDTO = CoreViewRouter.getInstance().getAccountCenterDTO();
            if (accountCenterDTO != null) {
                Drawable drawable = accountCenterDTO.backBtnDrawable;
                if (drawable != null) {
                    this.mLeftBtnIv.setImageDrawable(drawable);
                }
                setTitleTextBold(accountCenterDTO.isBoldTitle);
            }
            AccountCenterCallback accountCenterCallback = CoreViewRouter.getInstance().getAccountCenterCallback();
            this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback(this) { // from class: com.baidu.sapi2.activity.AccountCenterActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AccountCenterActivity a;

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
                        this.a.onClose();
                    }
                }
            });
            this.sapiWebView.setLeftBtnVisibleCallback(new SapiWebView.LeftBtnVisibleCallback(this) { // from class: com.baidu.sapi2.activity.AccountCenterActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AccountCenterActivity a;

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

                @Override // com.baidu.sapi2.SapiWebView.LeftBtnVisibleCallback
                public void onLeftBtnVisible(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                        if (i == 0) {
                            this.a.setBtnVisibility(4, 4, 4);
                        } else {
                            this.a.setBtnVisibility(4, 0, 4);
                        }
                    }
                }
            });
            this.sapiWebView.setSwitchAccountCallback(new SapiWebView.SwitchAccountCallback(this, accountCenterCallback) { // from class: com.baidu.sapi2.activity.AccountCenterActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AccountCenterCallback a;
                public final /* synthetic */ AccountCenterActivity b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, accountCenterCallback};
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
                    this.a = accountCenterCallback;
                }

                @Override // com.baidu.sapi2.SapiWebView.SwitchAccountCallback
                public void onAccountSwitch(SapiWebView.SwitchAccountCallback.Result result) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, result) == null) {
                        AccountCenterDTO accountCenterDTO2 = CoreViewRouter.getInstance().getAccountCenterDTO();
                        if (accountCenterDTO2 != null && accountCenterDTO2.handleLogin && this.a != null) {
                            AccountCenterResult accountCenterResult = new AccountCenterResult(this) { // from class: com.baidu.sapi2.activity.AccountCenterActivity.3.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass3 a;

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

                                @Override // com.baidu.sapi2.result.AccountCenterResult
                                public void loginSuc() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        super.loginSuc();
                                        this.a.b.D = SapiContext.getInstance().getCurrentAccount().bduss;
                                        AccountCenterActivity accountCenterActivity = this.a.b;
                                        accountCenterActivity.loadAccountCenter(accountCenterActivity.D);
                                        this.a.b.loginStatusChange = true;
                                    }
                                }
                            };
                            if (result.switchAccountType == 1) {
                                accountCenterResult.preSetUserName = result.userName;
                            }
                            if (result.switchAccountType == 2) {
                                accountCenterResult.preSetUserName = result.displayName;
                                accountCenterResult.encryptedId = result.encryptedUid;
                            }
                            accountCenterResult.setResultCode(-10001);
                            accountCenterResult.setResultMsg("请登录");
                            this.a.onFinish(accountCenterResult);
                            return;
                        }
                        Intent intent = new Intent(this.b, LoginActivity.class);
                        intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2003);
                        int i = result.switchAccountType;
                        if (i == 1) {
                            intent.putExtra("username", result.userName);
                        } else if (i == 2) {
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
                        this.b.startActivityForResult(intent, 1004);
                    }
                }
            });
            this.sapiWebView.setCoverWebBdussCallback(new SapiWebView.CoverWebBdussCallback(this) { // from class: com.baidu.sapi2.activity.AccountCenterActivity.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AccountCenterActivity a;

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

                @Override // com.baidu.sapi2.SapiWebView.CoverWebBdussCallback
                public void onCoverBduss(String str, SapiWebView.CoverWebBdussResult coverWebBdussResult) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLL(1048576, this, str, coverWebBdussResult) == null) || TextUtils.isEmpty(str) || str.equals(this.a.D)) {
                        return;
                    }
                    coverWebBdussResult.setWebBduss(this.a.D);
                }
            });
            this.sapiWebView.setAccountDestoryCallback(new SapiWebView.AccountDestoryCallback(this) { // from class: com.baidu.sapi2.activity.AccountCenterActivity.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AccountCenterActivity a;

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

                @Override // com.baidu.sapi2.SapiWebView.AccountDestoryCallback
                public void onAccountDestory(SapiWebView.AccountDestoryCallback.AccountDestoryResult accountDestoryResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, accountDestoryResult) == null) {
                        AccountCenterDTO accountCenterDTO2 = CoreViewRouter.getInstance().getAccountCenterDTO();
                        if (accountCenterDTO2 != null && accountCenterDTO2.logoutAfterBdussInvalid) {
                            SapiAccountManager.getInstance().logout(4);
                            SapiAccountManager.getInstance().getAccountService().preGetPhoneInfo();
                        }
                        AccountCenterResult accountCenterResult = new AccountCenterResult();
                        accountCenterResult.isAccountDestory = true;
                        this.a.a(accountCenterResult);
                    }
                }
            });
            this.sapiWebView.setAccountChangeCallback(new SapiWebView.AccountChangeCallback(this, accountCenterCallback) { // from class: com.baidu.sapi2.activity.AccountCenterActivity.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AccountCenterCallback a;
                public final /* synthetic */ AccountCenterActivity b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, accountCenterCallback};
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
                    this.a = accountCenterCallback;
                }

                @Override // com.baidu.sapi2.SapiWebView.AccountChangeCallback
                public void onAccountChange() {
                    AccountCenterCallback accountCenterCallback2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (accountCenterCallback2 = this.a) == null) {
                        return;
                    }
                    accountCenterCallback2.onBdussChange();
                }
            });
            this.sapiWebView.setAccountFreezeCallback(new SapiWebView.AccountFreezeCallback(this) { // from class: com.baidu.sapi2.activity.AccountCenterActivity.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AccountCenterActivity a;

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

                @Override // com.baidu.sapi2.SapiWebView.AccountFreezeCallback
                public void onAccountFreeze(SapiWebView.AccountFreezeCallback.AccountFreezeResult accountFreezeResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, accountFreezeResult) == null) {
                        AccountCenterDTO accountCenterDTO2 = CoreViewRouter.getInstance().getAccountCenterDTO();
                        if (accountCenterDTO2 != null && accountCenterDTO2.logoutAfterBdussInvalid) {
                            SapiAccountManager.getInstance().logout(5);
                            SapiAccountManager.getInstance().getAccountService().preGetPhoneInfo();
                        }
                        AccountCenterResult accountCenterResult = new AccountCenterResult();
                        accountCenterResult.isAccountFreeze = true;
                        this.a.a(accountCenterResult);
                    }
                }
            });
            this.sapiWebView.setBdussChangeCallback(new SapiWebView.BdussChangeCallback(this) { // from class: com.baidu.sapi2.activity.AccountCenterActivity.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AccountCenterActivity a;

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

                @Override // com.baidu.sapi2.SapiWebView.BdussChangeCallback
                public void onBdussChange() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.a();
                    }
                }
            });
            this.sapiWebView.setAuthorizationListener(new AuthorizationListener(this) { // from class: com.baidu.sapi2.activity.AccountCenterActivity.9
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AccountCenterActivity a;

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
                public void onFailed(int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i, str) == null) {
                    }
                }

                @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
                public void onSuccess(AccountType accountType) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, accountType) == null) {
                        super.onSuccess(accountType);
                        this.a.G.setResultCode(-10002);
                        AccountCenterActivity accountCenterActivity = this.a;
                        accountCenterActivity.a(accountCenterActivity.G);
                        SapiAccountManager.getGlobalCallback().onLoginStatusChange();
                    }
                }
            });
            this.sapiWebView.setChangePwdCallback(new SapiWebView.ChangePwdCallback(this) { // from class: com.baidu.sapi2.activity.AccountCenterActivity.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AccountCenterActivity a;

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

                @Override // com.baidu.sapi2.SapiWebView.ChangePwdCallback
                public void onSuccess() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.G.setResultCode(-10002);
                        AccountCenterActivity accountCenterActivity = this.a;
                        accountCenterActivity.a(accountCenterActivity.G);
                    }
                }
            });
            if (TextUtils.isEmpty(this.F)) {
                setTitleText(R.string.obfuscated_res_0x7f0f106f);
                loadAccountCenter(this.D);
            } else {
                this.sapiWebView.loadUrl(this.F);
            }
            if (this.mIsAccountCenterTitleBar) {
                this.dividerLine.setVisibility(8);
                SapiConfiguration sapiConfiguration = this.configuration;
                if (sapiConfiguration != null && sapiConfiguration.isDarkMode) {
                    if (this.useTitle) {
                        ViewUtility.enableStatusBarTint(this, getResources().getColor(R.color.obfuscated_res_0x7f060926));
                        setTitleLayoutBg(getResources().getColor(R.color.obfuscated_res_0x7f060926));
                        setTitleTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060928));
                        this.sapiWebView.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f060926));
                    }
                } else if (this.useTitle) {
                    ViewUtility.enableStatusBarTint(this, getResources().getColor(R.color.obfuscated_res_0x7f060928));
                    setTitleLayoutBg(getResources().getColor(R.color.obfuscated_res_0x7f060925));
                    setTitleTextColor(getResources().getColor(R.color.obfuscated_res_0x7f060927));
                    this.sapiWebView.setBackgroundColor(getResources().getColor(R.color.obfuscated_res_0x7f060925));
                }
            }
            this.sapiWebView.setJumpToUriCallBack(new SapiJsCallBacks.JumpToUriCallBack(this, accountCenterCallback) { // from class: com.baidu.sapi2.activity.AccountCenterActivity.11
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AccountCenterCallback a;
                public final /* synthetic */ AccountCenterActivity b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, accountCenterCallback};
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
                    this.a = accountCenterCallback;
                }

                @Override // com.baidu.sapi2.SapiJsCallBacks.JumpToUriCallBack
                public void onJumpTo(String str) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) || this.a == null || TextUtils.isEmpty(str)) {
                        return;
                    }
                    this.a.onJumpTo(str);
                }
            });
            this.sapiWebView.setSyncAccountCallback(new SapiJsCallBacks.SyncAccountCallBack(this, accountCenterCallback) { // from class: com.baidu.sapi2.activity.AccountCenterActivity.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AccountCenterCallback a;
                public final /* synthetic */ AccountCenterActivity b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, accountCenterCallback};
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
                    this.a = accountCenterCallback;
                }

                @Override // com.baidu.sapi2.SapiJsCallBacks.SyncAccountCallBack
                public void onSyncAccount(SapiAccount sapiAccount) {
                    AccountCenterCallback accountCenterCallback2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(1048576, this, sapiAccount) == null) || (accountCenterCallback2 = this.a) == null || sapiAccount == null) {
                        return;
                    }
                    accountCenterCallback2.onSyncAccount(sapiAccount);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AccountCenterResult accountCenterResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, accountCenterResult) == null) {
            SocialLoginBase.setWXLoginCallback(null);
            if (CoreViewRouter.getInstance().getAccountCenterCallback() != null) {
                if (accountCenterResult == null) {
                    accountCenterResult = new AccountCenterResult();
                }
                CoreViewRouter.getInstance().getAccountCenterCallback().onFinish(accountCenterResult);
            }
            finish();
            CoreViewRouter.getInstance().release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            SapiAccountManager.getInstance().getAccountService().web2NativeLogin(new Web2NativeLoginCallback(this) { // from class: com.baidu.sapi2.activity.AccountCenterActivity.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AccountCenterActivity a;

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

                @Override // com.baidu.sapi2.callback.Web2NativeLoginCallback
                public void onBdussEmpty(Web2NativeLoginResult web2NativeLoginResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, web2NativeLoginResult) == null) {
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.LoginStatusAware
                public void onBdussExpired(Web2NativeLoginResult web2NativeLoginResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, web2NativeLoginResult) == null) {
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFailure(Web2NativeLoginResult web2NativeLoginResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048580, this, web2NativeLoginResult) == null) {
                    }
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                    }
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onStart() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048582, this) == null) {
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onSuccess(Web2NativeLoginResult web2NativeLoginResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, web2NativeLoginResult) == null) {
                        AccountCenterCallback accountCenterCallback = CoreViewRouter.getInstance().getAccountCenterCallback();
                        if (SapiUtils.isMethodOverWrited(accountCenterCallback, "onBdussChange", AccountCenterCallback.class, new Class[0])) {
                            accountCenterCallback.onBdussChange();
                        }
                    }
                }
            }, true);
        }
    }
}
