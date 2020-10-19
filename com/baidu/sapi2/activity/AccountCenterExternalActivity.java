package com.baidu.sapi2.activity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.callback.AccountCenterCallback;
import com.baidu.sapi2.dto.AccountCenterDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.result.AccountCenterResult;
import com.baidu.sapi2.utils.Log;
/* loaded from: classes5.dex */
public class AccountCenterExternalActivity extends AccountCenterActivity {
    public static final String EXTRA_EXTERNAL_URL = "extra_external_url";
    private static final String G = AccountCenterExternalActivity.class.getSimpleName();
    private String F;

    public void finishActivity() {
        super.finish();
    }

    @Override // com.baidu.sapi2.activity.AccountCenterActivity
    protected void loadAccountCenter(String str) {
        this.F = getIntent().getStringExtra("extra_external_url");
        this.sapiWebView.loadUrl(this.F);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.AccountCenterActivity, com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1004 && i2 == -1) {
            b();
            this.loginStatusChange = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.AccountCenterActivity, com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        a();
    }

    @Override // com.baidu.sapi2.activity.AccountCenterActivity, com.baidu.sapi2.activity.SlideActiviy, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.d(G, "AccountCenterExternalActivity onCreate");
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() { // from class: com.baidu.sapi2.activity.AccountCenterExternalActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
            public boolean onBack() {
                AccountCenterExternalActivity.this.a();
                return false;
            }
        });
        this.sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.AccountCenterExternalActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                AccountCenterExternalActivity.this.finishActivity();
            }
        });
        this.sapiWebView.setOnSlidePageFinishCallback(new SapiWebView.OnSlidePageFinishCallback() { // from class: com.baidu.sapi2.activity.AccountCenterExternalActivity.3
            @Override // com.baidu.sapi2.SapiWebView.OnSlidePageFinishCallback
            public void onFinish(String str) {
                if ("accountCenter".equals(str)) {
                    Intent intent = new Intent(AccountCenterExternalActivity.this, AccountCenterActivity.class);
                    intent.setFlags(67108864);
                    AccountCenterExternalActivity.this.startActivity(intent);
                }
                if ("quit".equals(str)) {
                    AccountCenterExternalActivity.this.b();
                }
            }
        });
        this.sapiWebView.setSwitchAccountCallback(new SapiWebView.SwitchAccountCallback() { // from class: com.baidu.sapi2.activity.AccountCenterExternalActivity.4
            @Override // com.baidu.sapi2.SapiWebView.SwitchAccountCallback
            public void onAccountSwitch(SapiWebView.SwitchAccountCallback.Result result) {
                AccountCenterCallback accountCenterCallback = CoreViewRouter.getInstance().getAccountCenterCallback();
                AccountCenterDTO accountCenterDTO = CoreViewRouter.getInstance().getAccountCenterDTO();
                if (accountCenterDTO != null && accountCenterDTO.handleLogin && accountCenterCallback != null) {
                    AccountCenterResult accountCenterResult = new AccountCenterResult() { // from class: com.baidu.sapi2.activity.AccountCenterExternalActivity.4.1
                        @Override // com.baidu.sapi2.result.AccountCenterResult
                        public void loginSuc() {
                            super.loginSuc();
                            AccountCenterExternalActivity.this.b();
                            AccountCenterExternalActivity.this.loginStatusChange = true;
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
                Intent intent = new Intent(AccountCenterExternalActivity.this, LoginActivity.class);
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
                AccountCenterExternalActivity.this.startActivityForResult(intent, 1004);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.AccountCenterActivity, com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.sapiWebView.loadUrl(SapiWebView.FN_SWITCH_VIEW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Intent intent = new Intent(this, AccountCenterActivity.class);
        intent.setFlags(67108864);
        intent.putExtra("action", "quit");
        PendingIntent.getActivity(getApplicationContext(), 0, intent, 134217728);
        startActivity(intent);
    }
}
