package com.baidu.tbadk.browser;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.util.aw;
/* loaded from: classes.dex */
public class q extends WebViewClient {
    final /* synthetic */ TbWebViewActivity xA;

    /* JADX INFO: Access modifiers changed from: protected */
    public q(TbWebViewActivity tbWebViewActivity) {
        this.xA = tbWebViewActivity;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        String str2;
        ImageView imageView;
        ImageView imageView2;
        ProgressBar progressBar;
        ImageView imageView3;
        ImageView imageView4;
        String str3;
        String str4;
        String str5;
        super.onPageFinished(webView, str);
        if (this.xA.mWebView != null) {
            this.xA.mUrl = this.xA.mWebView.getUrl();
            str2 = this.xA.mUrl;
            if (str2 != null) {
                str3 = this.xA.mUrl;
                int indexOf = str3.indexOf(47, 8);
                if (indexOf > 8) {
                    str5 = this.xA.mUrl;
                    str4 = str5.substring(0, indexOf);
                } else {
                    str4 = this.xA.mUrl;
                }
                if (!str4.contains("lecai.com") && !str4.contains("baidu.com")) {
                    this.xA.shouldShowInstallPluginDialog();
                }
            }
            if (this.xA.mWebView.canGoBack()) {
                imageView3 = this.xA.mBottomBack;
                imageView3.setEnabled(true);
                imageView4 = this.xA.mBottomBack;
                aw.c(imageView4, com.baidu.tieba.u.icon_webview_return_n);
            } else {
                imageView = this.xA.mBottomBack;
                imageView.setEnabled(false);
                imageView2 = this.xA.mBottomBack;
                imageView2.setImageDrawable(this.xA.getResources().getDrawable(com.baidu.tieba.u.icon_webview_return_dd));
            }
            progressBar = this.xA.mProgressBar;
            progressBar.setVisibility(8);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        ImageView imageView;
        ImageView imageView2;
        ProgressBar progressBar;
        ImageView imageView3;
        super.onPageStarted(webView, str, bitmap);
        if (this.xA.mWebView != null) {
            imageView = this.xA.mBottomBack;
            imageView.setImageDrawable(this.xA.getResources().getDrawable(com.baidu.tieba.u.icon_webview_return_dd));
            if (this.xA.mWebView.canGoBack()) {
                imageView3 = this.xA.mBottomBack;
                imageView3.setEnabled(true);
            } else {
                imageView2 = this.xA.mBottomBack;
                imageView2.setEnabled(false);
            }
            progressBar = this.xA.mProgressBar;
            progressBar.setVisibility(0);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return this.xA.shouldOverrideUrlLoading(webView, str);
    }
}
