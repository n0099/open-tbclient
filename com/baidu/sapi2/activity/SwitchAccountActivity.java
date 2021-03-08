package com.baidu.sapi2.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import com.baidu.j.a.a;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SwitchAccountDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.AccountType;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SwitchAccountActivity extends BaseActivity {
    private static final String s = "https://wappass.baidu.com/v6/changeAccount";
    private WebAuthResult p = new WebAuthResult() { // from class: com.baidu.sapi2.activity.SwitchAccountActivity.1
        @Override // com.baidu.sapi2.shell.result.WebAuthResult
        public void finishActivity() {
            SwitchAccountActivity.this.finish();
            CoreViewRouter.getInstance().release();
        }
    };
    private WebAuthListener q;
    private SwitchAccountDTO r;

    private String b() {
        WebBackForwardList copyBackForwardList;
        WebHistoryItem currentItem;
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView == null || (copyBackForwardList = sapiWebView.copyBackForwardList()) == null || copyBackForwardList.getSize() == 0 || (currentItem = copyBackForwardList.getCurrentItem()) == null) {
            return null;
        }
        return currentItem.getUrl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
        super.init();
        this.q = CoreViewRouter.getInstance().getWebAuthListener();
        this.r = CoreViewRouter.getInstance().getSwitchAccountDTO();
        if (this.r == null || this.q == null) {
            this.p.setResultCode(-204);
            a(this.p);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        super.onClose();
        this.p.setResultCode(-301);
        a(this.p);
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
            this.p.setResultCode(-202);
            a(this.p);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (!this.executeSubClassMethod) {
            return;
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(a.g.sapi_sdk_title_switch);
        SapiWebView sapiWebView = this.sapiWebView;
        sapiWebView.showSwitchAccount = this.configuration.supportMultipleAccounts;
        sapiWebView.showLinkAccount = this.r.supportQueryAssociatedAccount;
        sapiWebView.setOnFinishCallback(new SapiWebView.OnFinishCallback() { // from class: com.baidu.sapi2.activity.SwitchAccountActivity.2
            @Override // com.baidu.sapi2.SapiWebView.OnFinishCallback
            public void onFinish() {
                SwitchAccountActivity.this.onClose();
            }
        });
        this.sapiWebView.setOnNewBackCallback(new SapiWebView.OnNewBackCallback() { // from class: com.baidu.sapi2.activity.SwitchAccountActivity.3
            @Override // com.baidu.sapi2.SapiWebView.OnNewBackCallback
            public boolean onBack() {
                SwitchAccountActivity.this.a();
                return false;
            }
        });
        this.sapiWebView.setAuthorizationListener(new AuthorizationListener() { // from class: com.baidu.sapi2.activity.SwitchAccountActivity.4
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
        this.sapiWebView.setSwitchAccountCallback(new SapiWebView.SwitchAccountCallback() { // from class: com.baidu.sapi2.activity.SwitchAccountActivity.5
            @Override // com.baidu.sapi2.SapiWebView.SwitchAccountCallback
            public void onAccountSwitch(SapiWebView.SwitchAccountCallback.Result result) {
                WebLoginDTO webLoginDTO = new WebLoginDTO();
                webLoginDTO.finishActivityAfterSuc = false;
                int i = result.switchAccountType;
                if (i == 1) {
                    webLoginDTO.preSetUname = result.userName;
                } else if (i == 2) {
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
                CoreViewRouter.getInstance().startLogin(SwitchAccountActivity.this, new WebAuthListener() { // from class: com.baidu.sapi2.activity.SwitchAccountActivity.5.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFailure(WebAuthResult webAuthResult) {
                        SwitchAccountActivity.this.a(webAuthResult.getResultCode(), webAuthResult.getResultMsg());
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onSuccess(WebAuthResult webAuthResult) {
                        webAuthResult.finishActivity(false);
                        SwitchAccountActivity.this.a(webAuthResult.accountType);
                        if (SwitchAccountActivity.this.sapiWebView != null) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(new PassNameValuePair("changeAccountSuc", "1"));
                            SwitchAccountActivity.this.sapiWebView.loadSwitchAccount(arrayList);
                        }
                    }
                }, webLoginDTO);
            }
        });
        this.sapiWebView.loadSwitchAccount(new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        b();
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && sapiWebView.canGoBack()) {
            String b = b();
            if (b != null && b.startsWith(s)) {
                onClose();
                return;
            } else {
                this.sapiWebView.goBack();
                return;
            }
        }
        onClose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AccountType accountType) {
        this.p.setResultCode(0);
        WebAuthResult webAuthResult = this.p;
        webAuthResult.accountType = accountType;
        this.q.onSuccess(webAuthResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        this.p.setResultCode(i);
        this.p.setResultMsg(str);
        this.q.onFailure(this.p);
    }

    private void a(WebAuthResult webAuthResult) {
        WebAuthListener webAuthListener = this.q;
        if (webAuthListener != null) {
            webAuthListener.onFailure(webAuthResult);
        }
        finish();
        CoreViewRouter.getInstance().release();
    }
}
