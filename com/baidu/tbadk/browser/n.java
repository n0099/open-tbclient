package com.baidu.tbadk.browser;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class n extends WebViewClient {
    final /* synthetic */ TbWebViewActivity NJ;

    /* JADX INFO: Access modifiers changed from: protected */
    public n(TbWebViewActivity tbWebViewActivity) {
        this.NJ = tbWebViewActivity;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (this.NJ.mWebView != null) {
            this.NJ.mUrl = str;
            if (StringUtils.isNull(this.NJ.mUrlTitle)) {
                this.NJ.mUrlTitle = this.NJ.mWebView.getTitle();
            }
            this.NJ.mView.bW(this.NJ.mUrlTitle);
            this.NJ.mView.setNavBarVisibility(this.NJ.mIsShowNavBar);
            this.NJ.hideProgressBar();
            this.NJ.stopLoadTimer();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        if (this.NJ.mWebView != null) {
            this.NJ.mWebView.stopLoading();
            this.NJ.stopLoadTimer();
            this.NJ.onReceivedError(i);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        if (this.NJ.mWebView != null) {
            this.NJ.mUrl = str;
            this.NJ.showProgressBar();
            this.NJ.startLoadTimer();
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.baidu.tbadk.util.n.a(this.NJ, str)) {
            return true;
        }
        this.NJ.mUrl = str;
        this.NJ.refresh();
        return true;
    }
}
