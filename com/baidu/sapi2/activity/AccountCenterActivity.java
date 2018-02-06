package com.baidu.sapi2.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.c.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.PassportViewManager;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.AccountCenterCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.dto.AccountCenterDTO;
import com.baidu.sapi2.result.AccountCenterResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.SocialType;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
/* loaded from: classes2.dex */
public class AccountCenterActivity extends TitleActivity {
    public static final int REQUEST_CODE_LOGIN = 2001;
    private static final String TAG = "AccountCenterActivity";
    public static final String WX_LOGIN_SUCCESS_ACTION = "com.baidu.sapi2.action.wxlogin";
    private String bduss;
    private List<NameValuePair> paramsList;
    private BroadcastReceiver receiver = new BroadcastReceiver() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Bundle extras = intent.getExtras();
            String string = extras.getString("wx_state");
            AccountCenterActivity.this.sapiWebView.weixinSSOLogin(extras.getString("wx_code"), string, true);
        }
    };

    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.e.layout_sapi_sdk_webview_with_title_bar);
        init();
        setupViews();
        registerReceiver();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity, com.baidu.sapi2.activity.BaseActivity
    public void init() {
        super.init();
        AccountCenterDTO accountCenterDTO = PassportSDK.getInstance().getAccountCenterDTO();
        if (accountCenterDTO == null) {
            finishActivity((AccountCenterResult) null);
            return;
        }
        this.bduss = accountCenterDTO.bduss;
        this.paramsList = accountCenterDTO.paramsList;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.receiver);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity, com.baidu.sapi2.activity.BaseActivity
    public void setupViews() {
        super.setupViews();
        configTitle();
        final AccountCenterCallback accountCenterCallback = PassportSDK.getInstance().getAccountCenterCallback();
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                AccountCenterActivity.this.finishActivity((AccountCenterResult) null);
            }
        });
        this.sapiWebView.setWebViewTitleCallback(new SapiWebView.WebViewTitleCallback() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.3
            @Override // com.baidu.sapi2.SapiWebView.WebViewTitleCallback
            public void onTitleChange(String str) {
                String string = AccountCenterActivity.this.getString(a.f.sapi_sdk_account_center_webview_title_online_service);
                String string2 = AccountCenterActivity.this.getString(a.f.sapi_sdk_account_center_webview_title_common_problem);
                if (string.equals(str)) {
                    str = string2;
                }
                AccountCenterActivity.this.setTitleText(str);
            }
        });
        this.sapiWebView.setLeftBtnVisibleCallback(new SapiWebView.LeftBtnVisibleCallback() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.4
            @Override // com.baidu.sapi2.SapiWebView.LeftBtnVisibleCallback
            public void onLeftBtnVisible(int i) {
                if (i == 0) {
                    AccountCenterActivity.this.setBtnVisibility(4, 4, 4);
                } else {
                    AccountCenterActivity.this.setBtnVisibility(4, 0, 4);
                }
            }
        });
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.5
            @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
            public boolean onBack() {
                if (!AccountCenterActivity.this.sapiWebView.canGoBack()) {
                    AccountCenterActivity.this.finishActivity((AccountCenterResult) null);
                    return false;
                }
                AccountCenterActivity.this.sapiWebView.goBack();
                return false;
            }
        });
        this.sapiWebView.setSwitchAccountCallback(new SapiWebView.SwitchAccountCallback() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.6
            @Override // com.baidu.sapi2.SapiWebView.SwitchAccountCallback
            public void onAccountSwitch() {
                if (SapiUtils.isMethodOverWrited(accountCenterCallback, "onLogin", AccountCenterCallback.class, Context.class, Integer.TYPE, String.class)) {
                    accountCenterCallback.onLogin(AccountCenterActivity.this, AccountCenterCallback.REQUEST_CODE_LOGIN, null);
                    return;
                }
                Intent intent = new Intent(AccountCenterActivity.this, LoginActivity.class);
                intent.putExtra(LoginActivity.EXTRA_PARAM_LOGIN_FROM_BUSINESS, 1);
                AccountCenterActivity.this.startActivityForResult(intent, AccountCenterCallback.REQUEST_CODE_LOGIN);
            }

            @Override // com.baidu.sapi2.SapiWebView.SwitchAccountCallback
            public void onAccountSwitch(SapiWebView.SwitchAccountCallback.Result result) {
                if (SapiUtils.isMethodOverWrited(accountCenterCallback, "onLogin", AccountCenterCallback.class, Context.class, Integer.TYPE, String.class)) {
                    accountCenterCallback.onLogin(AccountCenterActivity.this, AccountCenterCallback.REQUEST_CODE_LOGIN, null);
                    return;
                }
                Intent intent = new Intent(AccountCenterActivity.this, LoginActivity.class);
                intent.putExtra(LoginActivity.EXTRA_PARAM_LOGIN_FROM_BUSINESS, 1);
                intent.putExtra("username", result.userName);
                AccountCenterActivity.this.startActivityForResult(intent, AccountCenterCallback.REQUEST_CODE_LOGIN);
            }
        });
        this.sapiWebView.setSocialBindHandler(new Handler() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.7
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == SocialType.WEIXIN.getType()) {
                    String str = (String) message.obj;
                    if (accountCenterCallback != null) {
                        accountCenterCallback.onSocialBind(str);
                    }
                }
            }
        });
        this.sapiWebView.setCoverWebBdussCallback(new SapiWebView.CoverWebBdussCallback() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.8
            @Override // com.baidu.sapi2.SapiWebView.CoverWebBdussCallback
            public void onCoverBduss(String str, SapiWebView.CoverWebBdussResult coverWebBdussResult) {
                if (!TextUtils.isEmpty(str) && !str.equals(AccountCenterActivity.this.bduss)) {
                    coverWebBdussResult.setWebBduss(AccountCenterActivity.this.bduss);
                }
            }
        });
        this.sapiWebView.setAccountDestoryCallback(new SapiWebView.AccountDestoryCallback() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.9
            @Override // com.baidu.sapi2.SapiWebView.AccountDestoryCallback
            public void onAccountDestory(SapiWebView.AccountDestoryCallback.AccountDestoryResult accountDestoryResult) {
                SapiAccountManager.getInstance().logout();
                AccountCenterResult accountCenterResult = new AccountCenterResult();
                accountCenterResult.isAccountDestory = true;
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

    private void loadAccountCenter(String str) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("pp");
            SapiAccountManager.getInstance().getAccountService().getTplStoken(new GetTplStokenCallback() { // from class: com.baidu.sapi2.activity.AccountCenterActivity.11
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onSuccess(GetTplStokenResult getTplStokenResult) {
                    AccountCenterActivity.this.sapiWebView.loadAccountCenter(AccountCenterActivity.this.paramsList, getTplStokenResult.tplStokenMap.get("pp"));
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFailure(GetTplStokenResult getTplStokenResult) {
                    AccountCenterActivity.this.sapiWebView.loadAccountCenter(AccountCenterActivity.this.paramsList, null);
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
        Toast.makeText(this, getString(a.f.sapi_sdk_account_center_please_relogin), 1).show();
        finishActivity((AccountCenterResult) null);
    }

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WX_LOGIN_SUCCESS_ACTION);
        registerReceiver(this.receiver, intentFilter);
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void configTitle() {
        PassportViewManager.TitleViewModule titleViewModule = PassportViewManager.getInstance().getTitleViewModule();
        if (titleViewModule != null) {
            setTitleLayoutBg(titleViewModule.bgColor);
            setLeftBtnImage(titleViewModule.leftBtnImgResId);
            setLeftBtnImgVisible(titleViewModule.leftBtnImgVisible);
            setLeftBtnTextVisible(titleViewModule.leftBtnTextVisible);
            setLeftBtnTextColor(titleViewModule.leftBtnTextColor);
            setLeftBtnText(titleViewModule.leftBtnText);
            setLeftBtnTextSize(SapiUtils.px2sp(this, titleViewModule.leftBtnTextSize));
            setLeftBtnDrawable(titleViewModule.leftBtnDrawableLeft, titleViewModule.leftBtnDrawableTop, titleViewModule.leftBtnDrawableRight, titleViewModule.leftBtnDrawableBottom);
            setTitleVisible(titleViewModule.titleVisible);
            setTitleText(titleViewModule.titleText);
            setTitleTextColor(titleViewModule.titleTextColor);
            setTitleTextSize(SapiUtils.px2sp(this, titleViewModule.titleTextSize));
            setTitleDrawable(titleViewModule.titleDrawableLeft, titleViewModule.titleDrawableTop, titleViewModule.titleDrawableRight, titleViewModule.titleDrawableBottom);
            setRightBtnVisible(titleViewModule.rightBtnVisible);
            setRightBtnText(titleViewModule.rightBtnText);
            setRightBtnTextSize(SapiUtils.px2sp(this, titleViewModule.rightBtnTextSize));
            setRightBtnColor(titleViewModule.rightBtnTextColor);
            return;
        }
        setBtnVisibility(4, 0, 4);
        setTitleText(a.f.sapi_sdk_account_center_passport);
        setTitleDrawable(null, null, null, null);
        setTitleTextColor(ViewCompat.MEASURED_STATE_MASK);
        setLeftBtnDrawable(getResources().getDrawable(a.c.sapi_sdk_btn_back), null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
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
            finishActivity((AccountCenterResult) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishActivity(AccountCenterResult accountCenterResult) {
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
        if (i == 100001 && i2 == -1) {
            this.bduss = intent.getStringExtra("bduss");
            loadAccountCenter(this.bduss);
        }
    }

    @Override // com.baidu.sapi2.activity.TitleActivity, com.baidu.sapi2.activity.BaseActivity, android.app.Activity
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
