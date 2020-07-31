package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.g.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.PassportViewManager;
import com.baidu.sapi2.SapiAccountManager;
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
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes19.dex */
public class AccountCenterActivity extends SlideActiviy {
    private static final String A = "AccountCenterActivity";
    private static final String B = "AccountCenterActivity";
    public static final String EXTRA_LOAD_WEIXIN = "extra_load_weixin";
    public static final String EXTRA_WEIIXIN_BIND_URL = "extra_weixin_bind_url";
    private List<PassNameValuePair> C;
    private String D;
    private String E;
    AccountCenterResult F = new AccountCenterResult();

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        SapiAccountManager.getInstance().getAccountService().web2NativeLogin(new Web2NativeLoginCallback() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.10
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
                AccountCenterCallback accountCenterCallback = PassportSDK.getInstance().getAccountCenterCallback();
                if (SapiUtils.isMethodOverWrited(accountCenterCallback, "onBdussChange", AccountCenterCallback.class, new Class[0])) {
                    accountCenterCallback.onBdussChange();
                }
            }
        }, true);
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void configTitle() {
        setTitleText(a.g.sapi_sdk_title_account_center);
        if (PassportViewManager.getInstance().getTitleViewModule() != null) {
            configCustomTitle();
            return;
        }
        switchDarkmode();
        setBtnVisibility(4, 0, 4);
        setTitleDrawable(null, null, null, null);
        setLeftBtnDrawable(getResources().getDrawable(a.d.sapi_sdk_btn_back), null, null, null);
        if (this.configuration.showBottomBack) {
            setBtnVisibility(4, 4, 4);
        }
    }

    @Override // com.baidu.sapi2.activity.SlideActiviy
    public void finishActivityAfterSlideOver() {
        if ("AccountCenterActivity".equals(getClass().getSimpleName())) {
            this.F.setResultCode(-301);
            this.F.setResultMsg("您已取消操作");
            a(this.F);
            return;
        }
        super.finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public SapiWebDTO getWebDTO() {
        return PassportSDK.getInstance().getAccountCenterDTO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        AccountCenterDTO accountCenterDTO = PassportSDK.getInstance().getAccountCenterDTO();
        if (accountCenterDTO == null) {
            this.F.setResultCode(-204);
            this.F.setResultMsg("参数错误，请稍后再试");
            a(this.F);
            return;
        }
        this.D = accountCenterDTO.bduss;
        this.E = accountCenterDTO.refer;
        this.C = accountCenterDTO.paramsList;
        List<PassNameValuePair> list = this.C;
        if (list != null) {
            list.add(new PassNameValuePair("slidePage", "1"));
        }
    }

    protected void loadAccountCenter(String str) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("pp");
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.9
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
                    if (sapiWebView != null) {
                        sapiWebView.loadAccountCenter(accountCenterActivity.C, null, AccountCenterActivity.this.E);
                    }
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
        this.F.setResultCode(-204);
        this.F.setResultMsg("参数错误，请稍后再试");
        a(this.F);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1004 && i2 == -1) {
            this.D = intent.getStringExtra("bduss");
            loadAccountCenter(this.D);
            this.loginStatusChange = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        this.sapiWebView.back();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        super.onClose();
        this.F.setResultCode(-301);
        this.F.setResultMsg("您已取消操作");
        a(this.F);
    }

    @Override // com.baidu.sapi2.activity.SlideActiviy, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(a.f.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
            this.F.setResultCode(-202);
            this.F.setResultMsg("网络连接失败，请检查网络设置");
            a(this.F);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (!this.executeSubClassMethod) {
            return;
        }
        this.sapiWebView.back();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        Log.d(A, this + " onNewintent");
        if (AccountCenterActivity.class.getSimpleName().equals(getClass().getSimpleName())) {
            String stringExtra = intent == null ? "" : intent.getStringExtra("action");
            Log.d(A, this + " slide action is " + stringExtra);
            if ("quit".equals(stringExtra)) {
                finishActivityAfterSlideOver();
            }
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onRightBtnClick() {
        super.onRightBtnClick();
    }

    @Override // com.baidu.sapi2.activity.SlideActiviy, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    protected void setupViews() {
        super.setupViews();
        configTitle();
        final AccountCenterCallback accountCenterCallback = PassportSDK.getInstance().getAccountCenterCallback();
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
                AccountCenterDTO accountCenterDTO = PassportSDK.getInstance().getAccountCenterDTO();
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
                if (TextUtils.isEmpty(str) || str.equals(AccountCenterActivity.this.D)) {
                    return;
                }
                coverWebBdussResult.setWebBduss(AccountCenterActivity.this.D);
            }
        });
        this.sapiWebView.setAccountDestoryCallback(new SapiWebView.AccountDestoryCallback() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.5
            @Override // com.baidu.sapi2.SapiWebView.AccountDestoryCallback
            public void onAccountDestory(SapiWebView.AccountDestoryCallback.AccountDestoryResult accountDestoryResult) {
                AccountCenterDTO accountCenterDTO = PassportSDK.getInstance().getAccountCenterDTO();
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
                AccountCenterDTO accountCenterDTO = PassportSDK.getInstance().getAccountCenterDTO();
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
                AccountCenterActivity.this.g();
            }
        });
        loadAccountCenter(this.D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AccountCenterResult accountCenterResult) {
        SocialLoginBase.setWXLoginCallback(null);
        if (PassportSDK.getInstance().getAccountCenterCallback() != null) {
            if (accountCenterResult == null) {
                accountCenterResult = new AccountCenterResult();
            }
            PassportSDK.getInstance().getAccountCenterCallback().onFinish(accountCenterResult);
        }
        finish();
        PassportSDK.getInstance().release();
    }
}
