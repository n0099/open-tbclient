package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.d.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.PassportViewManager;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.AccountCenterCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.dto.AccountCenterDTO;
import com.baidu.sapi2.dto.SapiWebDTO;
import com.baidu.sapi2.result.AccountCenterResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.SocialType;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
/* loaded from: classes2.dex */
public class AccountCenterActivity extends BaseActivity {
    public static final String EXTRA_LOAD_WEIXIN = "extra_load_weixin";
    public static final String EXTRA_WEIIXIN_BIND_URL = "extra_weixin_bind_url";
    private static final String TAG = "AccountCenterActivity";
    AccountCenterResult accountCenterResult = new AccountCenterResult();
    private String bduss;
    private List<NameValuePair> paramsList;
    private String refer;

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(a.e.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
            this.accountCenterResult.setResultCode(-202);
            this.accountCenterResult.setResultMsg(SapiResult.ERROR_MSG_UNKNOWN);
            finishActivity(this.accountCenterResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        AccountCenterDTO accountCenterDTO = PassportSDK.getInstance().getAccountCenterDTO();
        if (accountCenterDTO == null) {
            this.accountCenterResult.setResultCode(-204);
            this.accountCenterResult.setResultMsg(SapiResult.ERROR_MSG_PARAMS_ERROR);
            finishActivity(this.accountCenterResult);
            return;
        }
        this.bduss = accountCenterDTO.bduss;
        this.refer = accountCenterDTO.refer;
        this.paramsList = accountCenterDTO.paramsList;
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    protected SapiWebDTO getWebDTO() {
        return PassportSDK.getInstance().getAccountCenterDTO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
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
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.3
            @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
            public boolean onBack() {
                if (AccountCenterActivity.this.sapiWebView.canGoBack()) {
                    AccountCenterActivity.this.sapiWebView.goBack();
                    return false;
                }
                AccountCenterActivity.this.onClose();
                return false;
            }
        });
        this.sapiWebView.setSwitchAccountCallback(new SapiWebView.SwitchAccountCallback() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.4
            @Override // com.baidu.sapi2.SapiWebView.SwitchAccountCallback
            public void onAccountSwitch() {
                AccountCenterDTO accountCenterDTO = PassportSDK.getInstance().getAccountCenterDTO();
                if (accountCenterDTO != null && accountCenterDTO.handleLogin && accountCenterCallback != null) {
                    AccountCenterResult accountCenterResult = new AccountCenterResult() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.4.1
                        @Override // com.baidu.sapi2.result.AccountCenterResult
                        public void loginSuc() {
                            super.loginSuc();
                            AccountCenterActivity.this.bduss = SapiAccountManager.getInstance().getSession().bduss;
                            AccountCenterActivity.this.loadAccountCenter(AccountCenterActivity.this.bduss);
                        }
                    };
                    accountCenterResult.setResultCode(-10001);
                    accountCenterResult.setResultMsg("请登录");
                    accountCenterCallback.onFinish(accountCenterResult);
                    return;
                }
                Intent intent = new Intent(AccountCenterActivity.this, LoginActivity.class);
                intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2003);
                AccountCenterActivity.this.startActivityForResult(intent, 1004);
            }

            @Override // com.baidu.sapi2.SapiWebView.SwitchAccountCallback
            public void onAccountSwitch(SapiWebView.SwitchAccountCallback.Result result) {
                AccountCenterDTO accountCenterDTO = PassportSDK.getInstance().getAccountCenterDTO();
                if (accountCenterDTO != null && accountCenterDTO.handleLogin && accountCenterCallback != null) {
                    AccountCenterResult accountCenterResult = new AccountCenterResult() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.4.2
                        @Override // com.baidu.sapi2.result.AccountCenterResult
                        public void loginSuc() {
                            super.loginSuc();
                            AccountCenterActivity.this.bduss = SapiAccountManager.getInstance().getSession().bduss;
                            AccountCenterActivity.this.loadAccountCenter(AccountCenterActivity.this.bduss);
                        }
                    };
                    accountCenterResult.preSetUserName = result.userName;
                    accountCenterResult.setResultCode(-10001);
                    accountCenterResult.setResultMsg("请登录");
                    accountCenterCallback.onFinish(accountCenterResult);
                    return;
                }
                Intent intent = new Intent(AccountCenterActivity.this, LoginActivity.class);
                intent.putExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2003);
                intent.putExtra("username", result.userName);
                AccountCenterActivity.this.startActivityForResult(intent, 1004);
            }
        });
        this.sapiWebView.setSocialBindHandler(new Handler() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.5
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == SocialType.WEIXIN.getType() && !TextUtils.isEmpty((String) message.obj)) {
                    PassportSDK.getInstance().getThirdPartyService().socialBind(AccountCenterActivity.this, SocialType.WEIXIN, 2003, (String) message.obj);
                    SocialLoginBase.setWXLoginCallback(new SocialLoginBase.WXInvokeCallback() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.5.1
                        @Override // com.baidu.sapi2.social.SocialLoginBase.WXInvokeCallback
                        public void onResult(int i, Intent intent) {
                            Bundle extras = intent.getExtras();
                            String string = extras.getString("wx_state");
                            String string2 = extras.getString("wx_code");
                            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                                AccountCenterActivity.this.sapiWebView.weixinSSOLogin(string2, string, true);
                            }
                        }
                    });
                }
            }
        });
        this.sapiWebView.setCoverWebBdussCallback(new SapiWebView.CoverWebBdussCallback() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.6
            @Override // com.baidu.sapi2.SapiWebView.CoverWebBdussCallback
            public void onCoverBduss(String str, SapiWebView.CoverWebBdussResult coverWebBdussResult) {
                if (!TextUtils.isEmpty(str) && !str.equals(AccountCenterActivity.this.bduss)) {
                    coverWebBdussResult.setWebBduss(AccountCenterActivity.this.bduss);
                }
            }
        });
        this.sapiWebView.setAccountDestoryCallback(new SapiWebView.AccountDestoryCallback() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.7
            @Override // com.baidu.sapi2.SapiWebView.AccountDestoryCallback
            public void onAccountDestory(SapiWebView.AccountDestoryCallback.AccountDestoryResult accountDestoryResult) {
                AccountCenterDTO accountCenterDTO = PassportSDK.getInstance().getAccountCenterDTO();
                if (accountCenterDTO != null && accountCenterDTO.logoutAfterBdussInvalid) {
                    SapiAccountManager.getInstance().logout();
                }
                AccountCenterResult accountCenterResult = new AccountCenterResult();
                accountCenterResult.isAccountDestory = true;
                AccountCenterActivity.this.finishActivity(accountCenterResult);
            }
        });
        this.sapiWebView.setAccountChangeCallback(new SapiWebView.AccountChangeCallback() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.8
            @Override // com.baidu.sapi2.SapiWebView.AccountChangeCallback
            public void onAccountChange() {
                if (accountCenterCallback != null) {
                    accountCenterCallback.onBdussChange();
                }
            }
        });
        this.sapiWebView.setAccountFreezeCallback(new SapiWebView.AccountFreezeCallback() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.9
            @Override // com.baidu.sapi2.SapiWebView.AccountFreezeCallback
            public void onAccountFreeze(SapiWebView.AccountFreezeCallback.AccountFreezeResult accountFreezeResult) {
                AccountCenterDTO accountCenterDTO = PassportSDK.getInstance().getAccountCenterDTO();
                if (accountCenterDTO != null && accountCenterDTO.logoutAfterBdussInvalid) {
                    SapiAccountManager.getInstance().logout();
                }
                AccountCenterResult accountCenterResult = new AccountCenterResult();
                accountCenterResult.isAccountFreeze = true;
                AccountCenterActivity.this.finishActivity(accountCenterResult);
            }
        });
        this.sapiWebView.setBdussChangeCallback(new SapiWebView.BdussChangeCallback() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.10
            @Override // com.baidu.sapi2.SapiWebView.BdussChangeCallback
            public void onBdussChange() {
                AccountCenterActivity.this.web2NativeLogin();
            }
        });
        loadAccountCenter(this.bduss);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAccountCenter(String str) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("pp");
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.11
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onSuccess(GetTplStokenResult getTplStokenResult) {
                    AccountCenterActivity.this.sapiWebView.loadAccountCenter(AccountCenterActivity.this.paramsList, getTplStokenResult.tplStokenMap.get("pp"), AccountCenterActivity.this.refer);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFailure(GetTplStokenResult getTplStokenResult) {
                    AccountCenterActivity.this.sapiWebView.loadAccountCenter(AccountCenterActivity.this.paramsList, null, AccountCenterActivity.this.refer);
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onStart() {
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFinish() {
                }
            }, str, arrayList);
            return;
        }
        this.accountCenterResult.setResultCode(-204);
        this.accountCenterResult.setResultMsg(SapiResult.ERROR_MSG_PARAMS_ERROR);
        finishActivity(this.accountCenterResult);
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void configTitle() {
        setTitleText(a.f.sapi_sdk_title_account_center);
        if (PassportViewManager.getInstance().getTitleViewModule() != null) {
            configCustomTitle();
            return;
        }
        setBtnVisibility(4, 0, 4);
        setTitleDrawable(null, null, null, null);
        setTitleTextColor(-16777216);
        setLeftBtnDrawable(getResources().getDrawable(a.c.sapi_sdk_btn_back), null, null, null);
        if (SapiAccountManager.getInstance().getSapiConfiguration().showBottomBack) {
            setBtnVisibility(4, 4, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (this.executeSubClassMethod) {
            goBack();
        }
    }

    private void goBack() {
        if (this.sapiWebView.canGoBack()) {
            this.sapiWebView.back();
        } else {
            onClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onRightBtnClick() {
        super.onRightBtnClick();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        goBack();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        super.onClose();
        this.accountCenterResult.setResultCode(-301);
        this.accountCenterResult.setResultMsg(SapiResult.ERROR_MSG_PROCESSED_END);
        finishActivity(this.accountCenterResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity(AccountCenterResult accountCenterResult) {
        SocialLoginBase.setWXLoginCallback(null);
        if (PassportSDK.getInstance().getAccountCenterCallback() != null) {
            if (accountCenterResult == null) {
                accountCenterResult = new AccountCenterResult();
            }
            PassportSDK.getInstance().getAccountCenterCallback().onFinish(accountCenterResult);
        }
        PassportSDK.getInstance().release();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1004 && i2 == -1) {
            this.bduss = intent.getStringExtra("bduss");
            loadAccountCenter(this.bduss);
        }
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void web2NativeLogin() {
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
            public void onSuccess(Web2NativeLoginResult web2NativeLoginResult) {
                AccountCenterCallback accountCenterCallback = PassportSDK.getInstance().getAccountCenterCallback();
                if (SapiUtils.isMethodOverWrited(accountCenterCallback, "onBdussChange", AccountCenterCallback.class, new Class[0])) {
                    accountCenterCallback.onBdussChange();
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFailure(Web2NativeLoginResult web2NativeLoginResult) {
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onStart() {
            }

            @Override // com.baidu.sapi2.callback.SapiCallback
            public void onFinish() {
            }
        }, true);
    }
}
