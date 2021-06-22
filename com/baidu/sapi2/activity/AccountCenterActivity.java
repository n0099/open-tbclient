package com.baidu.sapi2.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.baidu.sapi2.CoreViewRouter;
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
import d.a.a0.a.b;
import d.a.a0.a.f;
import d.a.a0.a.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class AccountCenterActivity extends SlideActiviy {
    public static final String EXTRA_LOAD_WEIXIN = "extra_load_weixin";
    public static final String EXTRA_WEIIXIN_BIND_URL = "extra_weixin_bind_url";
    public static final String H = AccountCenterActivity.class.getSimpleName();
    public static final String I = "AccountCenterActivity";
    public List<PassNameValuePair> C;
    public String D;
    public String E;
    public String F;
    public AccountCenterResult G = new AccountCenterResult();
    public boolean mIsAccountCenterTitleBar = true;

    @Override // com.baidu.sapi2.activity.SlideActiviy
    public void finishActivityAfterSlideOver() {
        if (I.equals(getClass().getSimpleName())) {
            this.G.setResultCode(-301);
            this.G.setResultMsg("您已取消操作");
            a(this.G);
            return;
        }
        super.finish();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public SapiWebDTO getWebDTO() {
        return CoreViewRouter.getInstance().getAccountCenterDTO();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
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

    public void loadAccountCenter(String str) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("pp");
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.12
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFinish() {
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onStart() {
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFailure(GetTplStokenResult getTplStokenResult) {
                    AccountCenterActivity accountCenterActivity = AccountCenterActivity.this;
                    SapiWebView sapiWebView = accountCenterActivity.sapiWebView;
                    if (sapiWebView == null) {
                        return;
                    }
                    sapiWebView.loadAccountCenter(accountCenterActivity.C, null, AccountCenterActivity.this.E);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onSuccess(GetTplStokenResult getTplStokenResult) {
                    if (AccountCenterActivity.this.sapiWebView == null) {
                        return;
                    }
                    AccountCenterActivity accountCenterActivity = AccountCenterActivity.this;
                    accountCenterActivity.sapiWebView.loadAccountCenter(accountCenterActivity.C, getTplStokenResult.tplStokenMap.get("pp"), AccountCenterActivity.this.E);
                }
            }, str, arrayList);
            return;
        }
        this.G.setResultCode(-204);
        this.G.setResultMsg("参数错误，请稍后再试");
        a(this.G);
    }

    @Override // com.baidu.sapi2.activity.SlideActiviy
    public void loadSlideWebview(String str, String str2, String str3) {
        if (!SlideActiviy.ACCOUNT_CENTER_PAGE_NAME.equals(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        Intent intent = new Intent(this, AccountCenterExternalActivity.class);
        String queryParameter = Uri.parse(str2).getQueryParameter("topNavType");
        if (!TextUtils.isEmpty(queryParameter) && "1".equals(queryParameter)) {
            intent.putExtra(AccountCenterExternalActivity.EXTRA_EXTERNAL_IS_ACCOUNT_CENTER_TITLEBAR, true);
        }
        intent.putExtra("extra_external_url", str2);
        startActivity(intent);
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1004 && i3 == -1) {
            String stringExtra = intent.getStringExtra("bduss");
            this.D = stringExtra;
            loadAccountCenter(stringExtra);
            this.loginStatusChange = true;
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
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

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        super.onClose();
        this.G.setResultCode(-301);
        this.G.setResultMsg("您已取消操作");
        a(this.G);
    }

    @Override // com.baidu.sapi2.activity.SlideActiviy, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(f.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
            this.G.setResultCode(-202);
            this.G.setResultMsg("网络连接失败，请检查网络设置");
            a(this.G);
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (TextUtils.isEmpty(this.F)) {
            this.sapiWebView.onKeyUp(i2);
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

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
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

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
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

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onRightBtnClick() {
        super.onRightBtnClick();
    }

    @Override // com.baidu.sapi2.activity.SlideActiviy, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        final AccountCenterCallback accountCenterCallback = CoreViewRouter.getInstance().getAccountCenterCallback();
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                AccountCenterActivity.this.onClose();
            }
        });
        this.sapiWebView.setLeftBtnVisibleCallback(new SapiWebView.LeftBtnVisibleCallback() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.2
            @Override // com.baidu.sapi2.SapiWebView.LeftBtnVisibleCallback
            public void onLeftBtnVisible(int i2) {
                if (i2 == 0) {
                    AccountCenterActivity.this.setBtnVisibility(4, 4, 4);
                } else {
                    AccountCenterActivity.this.setBtnVisibility(4, 0, 4);
                }
            }
        });
        this.sapiWebView.setSwitchAccountCallback(new SapiWebView.SwitchAccountCallback() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.3
            @Override // com.baidu.sapi2.SapiWebView.SwitchAccountCallback
            public void onAccountSwitch(SapiWebView.SwitchAccountCallback.Result result) {
                AccountCenterDTO accountCenterDTO = CoreViewRouter.getInstance().getAccountCenterDTO();
                if (accountCenterDTO != null && accountCenterDTO.handleLogin && accountCenterCallback != null) {
                    AccountCenterResult accountCenterResult = new AccountCenterResult() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.3.1
                        @Override // com.baidu.sapi2.result.AccountCenterResult
                        public void loginSuc() {
                            super.loginSuc();
                            AccountCenterActivity.this.D = SapiContext.getInstance().getCurrentAccount().bduss;
                            AccountCenterActivity accountCenterActivity = AccountCenterActivity.this;
                            accountCenterActivity.loadAccountCenter(accountCenterActivity.D);
                            AccountCenterActivity.this.loginStatusChange = true;
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
                    accountCenterCallback.onFinish(accountCenterResult);
                    return;
                }
                Intent intent = new Intent(AccountCenterActivity.this, LoginActivity.class);
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
                AccountCenterActivity.this.startActivityForResult(intent, 1004);
            }
        });
        this.sapiWebView.setCoverWebBdussCallback(new SapiWebView.CoverWebBdussCallback() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.4
            @Override // com.baidu.sapi2.SapiWebView.CoverWebBdussCallback
            public void onCoverBduss(String str, SapiWebView.CoverWebBdussResult coverWebBdussResult) {
                if (TextUtils.isEmpty(str) || str.equals(AccountCenterActivity.this.D)) {
                    return;
                }
                coverWebBdussResult.setWebBduss(AccountCenterActivity.this.D);
            }
        });
        this.sapiWebView.setAccountDestoryCallback(new SapiWebView.AccountDestoryCallback() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.5
            @Override // com.baidu.sapi2.SapiWebView.AccountDestoryCallback
            public void onAccountDestory(SapiWebView.AccountDestoryCallback.AccountDestoryResult accountDestoryResult) {
                AccountCenterDTO accountCenterDTO = CoreViewRouter.getInstance().getAccountCenterDTO();
                if (accountCenterDTO != null && accountCenterDTO.logoutAfterBdussInvalid) {
                    SapiAccountManager.getInstance().logout();
                    SapiAccountManager.getInstance().getAccountService().preGetPhoneInfo();
                }
                AccountCenterResult accountCenterResult = new AccountCenterResult();
                accountCenterResult.isAccountDestory = true;
                AccountCenterActivity.this.a(accountCenterResult);
            }
        });
        this.sapiWebView.setAccountChangeCallback(new SapiWebView.AccountChangeCallback() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.6
            @Override // com.baidu.sapi2.SapiWebView.AccountChangeCallback
            public void onAccountChange() {
                AccountCenterCallback accountCenterCallback2 = accountCenterCallback;
                if (accountCenterCallback2 != null) {
                    accountCenterCallback2.onBdussChange();
                }
            }
        });
        this.sapiWebView.setAccountFreezeCallback(new SapiWebView.AccountFreezeCallback() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.7
            @Override // com.baidu.sapi2.SapiWebView.AccountFreezeCallback
            public void onAccountFreeze(SapiWebView.AccountFreezeCallback.AccountFreezeResult accountFreezeResult) {
                AccountCenterDTO accountCenterDTO = CoreViewRouter.getInstance().getAccountCenterDTO();
                if (accountCenterDTO != null && accountCenterDTO.logoutAfterBdussInvalid) {
                    SapiAccountManager.getInstance().logout();
                    SapiAccountManager.getInstance().getAccountService().preGetPhoneInfo();
                }
                AccountCenterResult accountCenterResult = new AccountCenterResult();
                accountCenterResult.isAccountFreeze = true;
                AccountCenterActivity.this.a(accountCenterResult);
            }
        });
        this.sapiWebView.setBdussChangeCallback(new SapiWebView.BdussChangeCallback() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.8
            @Override // com.baidu.sapi2.SapiWebView.BdussChangeCallback
            public void onBdussChange() {
                AccountCenterActivity.this.a();
            }
        });
        this.sapiWebView.setAuthorizationListener(new AuthorizationListener() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.9
            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onFailed(int i2, String str) {
            }

            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onSuccess(AccountType accountType) {
                super.onSuccess(accountType);
                AccountCenterActivity.this.G.setResultCode(-10002);
                AccountCenterActivity accountCenterActivity = AccountCenterActivity.this;
                accountCenterActivity.a(accountCenterActivity.G);
                SapiAccountManager.getGlobalCallback().onLoginStatusChange();
            }
        });
        this.sapiWebView.setChangePwdCallback(new SapiWebView.ChangePwdCallback() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.10
            @Override // com.baidu.sapi2.SapiWebView.ChangePwdCallback
            public void onSuccess() {
                AccountCenterActivity.this.G.setResultCode(-10002);
                AccountCenterActivity accountCenterActivity = AccountCenterActivity.this;
                accountCenterActivity.a(accountCenterActivity.G);
            }
        });
        if (TextUtils.isEmpty(this.F)) {
            setTitleText(g.sapi_sdk_title_account_center);
            loadAccountCenter(this.D);
        } else {
            this.sapiWebView.loadUrl(this.F);
        }
        if (this.mIsAccountCenterTitleBar) {
            this.dividerLine.setVisibility(8);
            SapiConfiguration sapiConfiguration = this.configuration;
            if (sapiConfiguration != null && sapiConfiguration.isDarkMode) {
                if (this.useTitle) {
                    ViewUtility.enableStatusBarTint(this, getResources().getColor(b.sapi_sdk_account_center_titlebar_bg_darkmode));
                    setTitleLayoutBg(getResources().getColor(b.sapi_sdk_account_center_titlebar_bg_darkmode));
                    setTitleTextColor(getResources().getColor(b.sapi_sdk_account_center_titlebar_text_darkmode));
                    this.sapiWebView.setBackgroundColor(getResources().getColor(b.sapi_sdk_account_center_titlebar_bg_darkmode));
                }
            } else if (this.useTitle) {
                ViewUtility.enableStatusBarTint(this, getResources().getColor(b.sapi_sdk_account_center_titlebar_bg));
                setTitleLayoutBg(getResources().getColor(b.sapi_sdk_account_center_titlebar_bg));
                setTitleTextColor(getResources().getColor(b.sapi_sdk_account_center_titlebar_text));
                this.sapiWebView.setBackgroundColor(getResources().getColor(b.sapi_sdk_account_center_titlebar_bg));
            }
        }
        this.sapiWebView.setJumpToUriCallBack(new SapiJsCallBacks.JumpToUriCallBack() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.11
            @Override // com.baidu.sapi2.SapiJsCallBacks.JumpToUriCallBack
            public void onJumpTo(String str) {
                if (CoreViewRouter.getInstance().getAccountCenterCallback() == null || TextUtils.isEmpty(str)) {
                    return;
                }
                CoreViewRouter.getInstance().getAccountCenterCallback().onJumpTo(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AccountCenterResult accountCenterResult) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        SapiAccountManager.getInstance().getAccountService().web2NativeLogin(new Web2NativeLoginCallback() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.13
            @Override // com.baidu.sapi2.callback.Web2NativeLoginCallback
            public void onBdussEmpty(Web2NativeLoginResult web2NativeLoginResult) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.LoginStatusAware
            public void onBdussExpired(Web2NativeLoginResult web2NativeLoginResult) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(Web2NativeLoginResult web2NativeLoginResult) {
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onSuccess(Web2NativeLoginResult web2NativeLoginResult) {
                AccountCenterCallback accountCenterCallback = CoreViewRouter.getInstance().getAccountCenterCallback();
                if (SapiUtils.isMethodOverWrited(accountCenterCallback, "onBdussChange", AccountCenterCallback.class, new Class[0])) {
                    accountCenterCallback.onBdussChange();
                }
            }
        }, true);
    }
}
