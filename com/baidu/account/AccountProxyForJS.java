package com.baidu.account;

import android.app.Activity;
import android.webkit.WebView;
import com.baidu.account.AccountProxy;
/* loaded from: classes.dex */
public class AccountProxyForJS {
    private AccountProxy mAccountProxy;
    private WebView mWebView;

    public AccountProxyForJS(Activity activity, WebView webView) {
        this.mAccountProxy = new AccountProxy(activity);
        this.mWebView = webView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tokenCallback(String str, String str2) {
        if (this.mWebView == null || str == null) {
            return;
        }
        this.mWebView.loadUrl("javascript:" + str + "(\"" + str2 + "\")");
    }

    public int getNumOfAccounts(String str) {
        return this.mAccountProxy.getNumOfAccounts(str);
    }

    public void getTokenAsync(String str, final String str2) {
        this.mAccountProxy.getTokenAsync(str, new AccountProxy.TokenCallback() { // from class: com.baidu.account.AccountProxyForJS.1
            @Override // com.baidu.account.AccountProxy.TokenCallback
            public void callBack(String str3) {
                AccountProxyForJS.this.tokenCallback(str2, str3);
            }
        });
    }

    public String getTokenSync(String str) {
        return this.mAccountProxy.getTokenSync(str);
    }

    public boolean hasBaiduAccount() {
        return this.mAccountProxy.hasBaiduAccount();
    }

    public void setAccount(String str) {
        this.mAccountProxy.setAccount(str);
    }
}
