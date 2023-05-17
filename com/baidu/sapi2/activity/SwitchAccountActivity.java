package com.baidu.sapi2.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiWebView;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.dto.SwitchAccountDTO;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.shell.listener.AuthorizationListener;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.AccountType;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class SwitchAccountActivity extends BaseActivity {
    public static final String w = "https://wappass.baidu.com/v6/changeAccount";
    public WebAuthResult t = new WebAuthResult() { // from class: com.baidu.sapi2.activity.SwitchAccountActivity.1
        @Override // com.baidu.sapi2.shell.result.WebAuthResult
        public void finishActivity() {
            SwitchAccountActivity.this.finish();
            CoreViewRouter.getInstance().release();
        }
    };
    public WebAuthListener u;
    public SwitchAccountDTO v;

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        b();
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && sapiWebView.canGoBack()) {
            String b = b();
            if (b != null && b.startsWith(w)) {
                onClose();
                return;
            } else {
                this.sapiWebView.goBack();
                return;
            }
        }
        onClose();
    }

    private String b() {
        WebBackForwardList copyBackForwardList;
        WebHistoryItem currentItem;
        SapiWebView sapiWebView = this.sapiWebView;
        if (sapiWebView != null && (copyBackForwardList = sapiWebView.copyBackForwardList()) != null && copyBackForwardList.getSize() != 0 && (currentItem = copyBackForwardList.getCurrentItem()) != null) {
            return currentItem.getUrl();
        }
        return null;
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void init() {
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

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onBottomBackBtnClick() {
        super.onBottomBackBtnClick();
        a();
    }

    @Override // com.baidu.sapi2.activity.TitleActivity
    public void onClose() {
        super.onClose();
        this.t.setResultCode(-301);
        a(this.t);
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void onLeftBtnClick() {
        super.onLeftBtnClick();
        if (!this.executeSubClassMethod) {
            return;
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        this.t.setResultCode(i);
        this.t.setResultMsg(str);
        this.u.onFailure(this.t);
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.layout_sapi_sdk_webview_with_title_bar);
            init();
        } catch (Throwable th) {
            reportWebviewError(th);
            this.t.setResultCode(-202);
            a(this.t);
        }
    }

    private void a(WebAuthResult webAuthResult) {
        WebAuthListener webAuthListener = this.u;
        if (webAuthListener != null) {
            webAuthListener.onFailure(webAuthResult);
        }
        finish();
        CoreViewRouter.getInstance().release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AccountType accountType) {
        this.t.setResultCode(0);
        WebAuthResult webAuthResult = this.t;
        webAuthResult.accountType = accountType;
        this.u.onSuccess(webAuthResult);
    }

    @Override // com.baidu.sapi2.activity.BaseActivity, com.baidu.sapi2.activity.TitleActivity
    public void setupViews() {
        super.setupViews();
        setTitleText(R.string.sapi_sdk_title_switch);
        SapiWebView sapiWebView = this.sapiWebView;
        sapiWebView.showSwitchAccount = this.configuration.supportMultipleAccounts;
        sapiWebView.showLinkAccount = this.v.supportQueryAssociatedAccount;
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
            public void onSuccess(AccountType accountType) {
                super.onSuccess();
                SwitchAccountActivity.this.a(accountType);
            }

            @Override // com.baidu.sapi2.shell.listener.AuthorizationListener
            public void onFailed(int i, String str) {
                SwitchAccountActivity.this.a(i, str);
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
}
