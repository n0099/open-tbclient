package com.baidu.sapi2.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import com.baidu.f.a.a;
import com.baidu.sapi2.PassportSDK;
import com.baidu.sapi2.PassportViewManager;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SwitchAccountDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.AccountType;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class SwitchAccountActivity extends BaseActivity {
    private static final String r = "SwitchAccountActivity";
    private static final String s = "https://wappass.baidu.com/v6/changeAccount";
    private WebAuthResult t = new WebAuthResult();
    private WebAuthListener u;
    private SwitchAccountDTO v;

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        f();
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && sapiWebView.canGoBack()) {
            String f = f();
            if (f != null && f.startsWith(s)) {
                onClose();
                return;
            } else {
                this.sapiWebView.goBack();
                return;
            }
        }
        onClose();
    }

    private String f() {
        WebBackForwardList copyBackForwardList;
        WebHistoryItem currentItem;
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || (copyBackForwardList = sapiWebView.copyBackForwardList()) == null || copyBackForwardList.getSize() == 0 || (currentItem = copyBackForwardList.getCurrentItem()) == null) {
            return null;
        }
        return currentItem.getUrl();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void configTitle() {
        setTitleText(a.g.sapi_sdk_title_switch);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        this.u = PassportSDK.getInstance().getWebAuthListener();
        this.v = PassportSDK.getInstance().getSwitchAccountDTO();
        if (this.v == null || this.u == null) {
            this.t.setResultCode(-204);
            a(this.t);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1004 && i2 == -1 && this.sapiWebView != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PassNameValuePair("changeAccountSuc", "1"));
            this.sapiWebView.loadSwitchAccount(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        super.onClose();
        this.t.setResultCode(-301);
        a(this.t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(a.f.layout_sapi_sdk_webview_with_title_bar);
            init();
            setupViews();
        } catch (Throwable th) {
            reportWebviewError(th);
            this.t.setResultCode(-202);
            a(this.t);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (!this.executeSubClassMethod) {
            return;
        }
        e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        configTitle();
        SapiWebView sapiWebView = this.sapiWebView;
        sapiWebView.showSwitchAccount = this.configuration.supportMultipleAccounts;
        sapiWebView.showLinkAccount = this.v.supportQueryAssociatedAccount;
        sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.SwitchAccountActivity.1
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                SwitchAccountActivity.this.onClose();
            }
        });
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() { // from class: com.baidu.sapi2.activity.SwitchAccountActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
            public boolean onBack() {
                SwitchAccountActivity.this.e();
                return false;
            }
        });
        this.sapiWebView.setAuthorizationListener(new AuthorizationListener() { // from class: com.baidu.sapi2.activity.SwitchAccountActivity.3
            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onFailed(int i, String str) {
                SwitchAccountActivity.this.a(i, str);
            }

            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onSuccess(AccountType accountType) {
                super.onSuccess();
                SwitchAccountActivity.this.a(accountType);
            }
        });
        this.sapiWebView.setSwitchAccountCallback(new SapiWebView.SwitchAccountCallback() { // from class: com.baidu.sapi2.activity.SwitchAccountActivity.4
            @Override // com.baidu.sapi2.SapiWebView.SwitchAccountCallback
            public void onAccountSwitch(SapiWebView.SwitchAccountCallback.Result result) {
                Intent intent = new Intent(SwitchAccountActivity.this, LoginActivity.class);
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
                if (!TextUtils.isEmpty(result.extraJson)) {
                    intent.putExtra("extraJson", result.extraJson);
                }
                SwitchAccountActivity.this.startActivityForResult(intent, 1004);
            }
        });
        this.sapiWebView.loadSwitchAccount(new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AccountType accountType) {
        this.t.setResultCode(0);
        WebAuthResult webAuthResult = this.t;
        webAuthResult.accountType = accountType;
        this.u.onSuccess(webAuthResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        this.t.setResultCode(i);
        this.t.setResultMsg(str);
        this.u.onFailure(this.t);
    }

    private void a(WebAuthResult webAuthResult) {
        WebAuthListener webAuthListener = this.u;
        if (webAuthListener != null) {
            webAuthListener.onFailure(webAuthResult);
        }
        finish();
        PassportSDK.getInstance().release();
    }
}
