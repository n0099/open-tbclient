package com.baidu.tbadk.browser;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends WebViewClient {
    final /* synthetic */ TbWebViewActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(TbWebViewActivity tbWebViewActivity) {
        this.a = tbWebViewActivity;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        BaseWebView baseWebView;
        BaseWebView baseWebView2;
        String str2;
        BaseWebView baseWebView3;
        ImageView imageView;
        ImageView imageView2;
        ProgressBar progressBar;
        ImageView imageView3;
        int i;
        ImageView imageView4;
        ImageView imageView5;
        String str3;
        String str4;
        String str5;
        super.onPageFinished(webView, str);
        baseWebView = this.a.mWebView;
        if (baseWebView != null) {
            TbWebViewActivity tbWebViewActivity = this.a;
            baseWebView2 = this.a.mWebView;
            tbWebViewActivity.mUrl = baseWebView2.getUrl();
            str2 = this.a.mUrl;
            if (str2 != null) {
                str3 = this.a.mUrl;
                int indexOf = str3.indexOf(47, 8);
                if (indexOf > 8) {
                    str5 = this.a.mUrl;
                    str4 = str5.substring(0, indexOf);
                } else {
                    str4 = this.a.mUrl;
                }
                if (!str4.contains("lecai.com") && !str4.contains("baidu.com")) {
                    this.a.shouldShowInstallPluginDialog();
                }
            }
            baseWebView3 = this.a.mWebView;
            if (baseWebView3.canGoBack()) {
                imageView3 = this.a.mBottomBack;
                imageView3.setEnabled(true);
                i = this.a.mSkinType;
                if (i == 1) {
                    imageView5 = this.a.mBottomBack;
                    imageView5.setImageDrawable(this.a.getResources().getDrawable(com.baidu.tieba.t.icon_webview_return_n_1));
                } else {
                    imageView4 = this.a.mBottomBack;
                    imageView4.setImageDrawable(this.a.getResources().getDrawable(com.baidu.tieba.t.icon_webview_return_n));
                }
            } else {
                imageView = this.a.mBottomBack;
                imageView.setEnabled(false);
                imageView2 = this.a.mBottomBack;
                imageView2.setImageDrawable(this.a.getResources().getDrawable(com.baidu.tieba.t.icon_webview_return_dd));
            }
            progressBar = this.a.mProgressBar;
            progressBar.setVisibility(8);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        BaseWebView baseWebView;
        ImageView imageView;
        BaseWebView baseWebView2;
        ImageView imageView2;
        ProgressBar progressBar;
        ImageView imageView3;
        super.onPageStarted(webView, str, bitmap);
        baseWebView = this.a.mWebView;
        if (baseWebView != null) {
            imageView = this.a.mBottomBack;
            imageView.setImageDrawable(this.a.getResources().getDrawable(com.baidu.tieba.t.icon_webview_return_dd));
            baseWebView2 = this.a.mWebView;
            if (baseWebView2.canGoBack()) {
                imageView3 = this.a.mBottomBack;
                imageView3.setEnabled(true);
            } else {
                imageView2 = this.a.mBottomBack;
                imageView2.setEnabled(false);
            }
            progressBar = this.a.mProgressBar;
            progressBar.setVisibility(0);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return this.a.shouldOverrideUrlLoading(webView, str);
    }
}
