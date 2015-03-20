package com.baidu.tbadk.browser;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class o extends WebViewClient {
    final /* synthetic */ TbWebViewActivity Nq;

    /* JADX INFO: Access modifiers changed from: protected */
    public o(TbWebViewActivity tbWebViewActivity) {
        this.Nq = tbWebViewActivity;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (this.Nq.mWebView != null) {
            this.Nq.mUrl = str;
            if (StringUtils.isNull(this.Nq.mUrlTitle)) {
                this.Nq.mUrlTitle = this.Nq.mWebView.getTitle();
            }
            this.Nq.mView.bJ(this.Nq.mUrlTitle);
            this.Nq.mView.setNavBarVisibility(this.Nq.mIsShowNavBar);
            this.Nq.hideProgressBar();
            this.Nq.stopLoadTimer();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        if (this.Nq.mWebView != null) {
            this.Nq.mWebView.stopLoading();
            this.Nq.stopLoadTimer();
            this.Nq.onReceivedError(i);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        if (this.Nq.mWebView != null) {
            this.Nq.mUrl = str;
            this.Nq.showProgressBar();
            this.Nq.startLoadTimer();
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.baidu.tbadk.util.n.a(this.Nq, str)) {
            return true;
        }
        this.Nq.mUrl = str;
        this.Nq.refresh();
        return true;
    }
}
