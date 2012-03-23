package com.baidu.account;

import android.app.Activity;
import android.webkit.WebView;
import com.baidu.account.AccountProxy;
/* loaded from: classes.dex */
public class AccountProxyForJS {
    private AccountProxy mAccountProxy;
    private WebView mWebView;

    public AccountProxyForJS(Activity context, WebView webview) {
        this.mAccountProxy = new AccountProxy(context);
        this.mWebView = webview;
    }

    public boolean hasBaiduAccount() {
        return this.mAccountProxy.hasBaiduAccount();
    }

    public void setAccount(String accountType) {
        this.mAccountProxy.setAccount(accountType);
    }

    public int getNumOfAccounts(String accountType) {
        return this.mAccountProxy.getNumOfAccounts(accountType);
    }

    public String getTokenSync(String accountType) {
        return this.mAccountProxy.getTokenSync(accountType);
    }

    public void getTokenAsync(String accountType, final String callbackName) {
        this.mAccountProxy.getTokenAsync(accountType, new AccountProxy.TokenCallback() { // from class: com.baidu.account.AccountProxyForJS.1
            @Override // com.baidu.account.AccountProxy.TokenCallback
            public void callBack(String token) {
                AccountProxyForJS.this.tokenCallback(callbackName, token);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tokenCallback(String callbackName, String token) {
        if (this.mWebView != null && callbackName != null) {
            this.mWebView.loadUrl("javascript:" + callbackName + "(\"" + token + "\")");
        }
    }
}
