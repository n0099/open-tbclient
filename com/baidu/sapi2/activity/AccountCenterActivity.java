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
import d.b.x.a.b;
import d.b.x.a.f;
import d.b.x.a.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class AccountCenterActivity extends SlideActiviy {
    public static final String D = AccountCenterActivity.class.getSimpleName();
    public static final String E = "AccountCenterActivity";
    public static final String EXTRA_LOAD_WEIXIN = "extra_load_weixin";
    public static final String EXTRA_WEIIXIN_BIND_URL = "extra_weixin_bind_url";
    public String A;
    public String B;
    public AccountCenterResult C = new AccountCenterResult();
    public boolean mIsAccountCenterTitleBar = true;
    public List<PassNameValuePair> y;
    public String z;

    @Override // com.baidu.sapi2.activity.SlideActiviy
    public void finishActivityAfterSlideOver() {
        if (E.equals(getClass().getSimpleName())) {
            this.C.setResultCode(-301);
            this.C.setResultMsg("您已取消操作");
            a(this.C);
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
            this.C.setResultCode(-204);
            this.C.setResultMsg("参数错误，请稍后再试");
            a(this.C);
            return;
        }
        this.z = accountCenterDTO.bduss;
        this.A = accountCenterDTO.refer;
        List<PassNameValuePair> list = accountCenterDTO.paramsList;
        this.y = list;
        this.B = accountCenterDTO.accountToolsUrl;
        if (list != null) {
            list.add(new PassNameValuePair(SlideActiviy.EXTRA_PARAMS_SLIDE_PAGE, "1"));
        }
    }

    public void loadAccountCenter(String str) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("pp");
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.11
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
                    sapiWebView.loadAccountCenter(accountCenterActivity.y, null, AccountCenterActivity.this.A);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onSuccess(GetTplStokenResult getTplStokenResult) {
                    if (AccountCenterActivity.this.sapiWebView == null) {
                        return;
                    }
                    AccountCenterActivity accountCenterActivity = AccountCenterActivity.this;
                    accountCenterActivity.sapiWebView.loadAccountCenter(accountCenterActivity.y, getTplStokenResult.tplStokenMap.get("pp"), AccountCenterActivity.this.A);
                }
            }, str, arrayList);
            return;
        }
        this.C.setResultCode(-204);
        this.C.setResultMsg("参数错误，请稍后再试");
        a(this.C);
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
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1004 && i2 == -1) {
            String stringExtra = intent.getStringExtra("bduss");
            this.z = stringExtra;
            loadAccountCenter(stringExtra);
            this.loginStatusChange = true;
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        if (TextUtils.isEmpty(this.B)) {
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
        this.C.setResultCode(-301);
        this.C.setResultMsg("您已取消操作");
        a(this.C);
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
            this.C.setResultCode(-202);
            this.C.setResultMsg("网络连接失败，请检查网络设置");
            a(this.C);
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (TextUtils.isEmpty(this.B)) {
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

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            if (TextUtils.isEmpty(this.B)) {
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
        String str = D;
        Log.d(str, this + " onNewintent");
        if (AccountCenterActivity.class.getSimpleName().equals(getClass().getSimpleName())) {
            String stringExtra = intent == null ? "" : intent.getStringExtra("action");
            String str2 = D;
            Log.d(str2, this + " slide action is " + stringExtra);
            if (SlideActiviy.SLIDE_ACTION_QUIT.equals(stringExtra)) {
                finishActivityAfterSlideOver();
            }
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
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
            public void onLeftBtnVisible(int i) {
                if (i == 0) {
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
                            AccountCenterActivity.this.z = SapiContext.getInstance().getCurrentAccount().bduss;
                            AccountCenterActivity accountCenterActivity = AccountCenterActivity.this;
                            accountCenterActivity.loadAccountCenter(accountCenterActivity.z);
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
                AccountCenterActivity.this.startActivityForResult(intent, 1004);
            }
        });
        this.sapiWebView.setCoverWebBdussCallback(new SapiWebView.CoverWebBdussCallback() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.4
            @Override // com.baidu.sapi2.SapiWebView.CoverWebBdussCallback
            public void onCoverBduss(String str, SapiWebView.CoverWebBdussResult coverWebBdussResult) {
                if (TextUtils.isEmpty(str) || str.equals(AccountCenterActivity.this.z)) {
                    return;
                }
                coverWebBdussResult.setWebBduss(AccountCenterActivity.this.z);
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
            public void onFailed(int i, String str) {
            }

            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onSuccess(AccountType accountType) {
                super.onSuccess(accountType);
                AccountCenterActivity.this.C.setResultCode(AccountCenterResult.ERROR_CODE_LOGIN_SUCCESS);
                AccountCenterActivity accountCenterActivity = AccountCenterActivity.this;
                accountCenterActivity.a(accountCenterActivity.C);
                SapiAccountManager.getGlobalCallback().onLoginStatusChange();
            }
        });
        this.sapiWebView.setChangePwdCallback(new SapiWebView.ChangePwdCallback() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.10
            @Override // com.baidu.sapi2.SapiWebView.ChangePwdCallback
            public void onSuccess() {
                AccountCenterActivity.this.C.setResultCode(AccountCenterResult.ERROR_CODE_LOGIN_SUCCESS);
                AccountCenterActivity accountCenterActivity = AccountCenterActivity.this;
                accountCenterActivity.a(accountCenterActivity.C);
            }
        });
        if (TextUtils.isEmpty(this.B)) {
            setTitleText(g.sapi_sdk_title_account_center);
            loadAccountCenter(this.z);
        } else {
            this.sapiWebView.loadUrl(this.B);
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
        SapiAccountManager.getInstance().getAccountService().web2NativeLogin(new Web2NativeLoginCallback() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.12
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
