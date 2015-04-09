package com.baidu.tbadk.browser;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class o extends WebViewClient {
    final /* synthetic */ TbWebViewActivity Ns;

    /* JADX INFO: Access modifiers changed from: protected */
    public o(TbWebViewActivity tbWebViewActivity) {
        this.Ns = tbWebViewActivity;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (this.Ns.mWebView != null) {
            this.Ns.mUrl = str;
            if (StringUtils.isNull(this.Ns.mUrlTitle)) {
                this.Ns.mUrlTitle = this.Ns.mWebView.getTitle();
            }
            this.Ns.mView.bJ(this.Ns.mUrlTitle);
            this.Ns.mView.setNavBarVisibility(this.Ns.mIsShowNavBar);
            this.Ns.hideProgressBar();
            this.Ns.stopLoadTimer();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        if (this.Ns.mWebView != null) {
            this.Ns.mWebView.stopLoading();
            this.Ns.stopLoadTimer();
            this.Ns.onReceivedError(i);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        if (this.Ns.mWebView != null) {
            this.Ns.mUrl = str;
            this.Ns.showProgressBar();
            this.Ns.startLoadTimer();
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.baidu.tbadk.util.n.a(this.Ns, str)) {
            return true;
        }
        this.Ns.mUrl = str;
        this.Ns.refresh();
        return true;
    }
}
