package com.baidu.tbadk.browser;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m extends WebViewClient {
    final /* synthetic */ TbWebViewActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(TbWebViewActivity tbWebViewActivity) {
        this.a = tbWebViewActivity;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        BaseWebView baseWebView;
        BaseWebView baseWebView2;
        ImageView imageView;
        ImageView imageView2;
        ProgressBar progressBar;
        ImageView imageView3;
        int i;
        ImageView imageView4;
        ImageView imageView5;
        super.onPageFinished(webView, str);
        TbWebViewActivity tbWebViewActivity = this.a;
        baseWebView = this.a.f;
        tbWebViewActivity.c = baseWebView.getUrl();
        baseWebView2 = this.a.f;
        if (baseWebView2.canGoBack()) {
            imageView3 = this.a.o;
            imageView3.setEnabled(true);
            i = this.a.mSkinType;
            if (i == 1) {
                imageView5 = this.a.o;
                imageView5.setImageDrawable(this.a.getResources().getDrawable(com.baidu.tbadk.i.icon_webview_return_n_1));
            } else {
                imageView4 = this.a.o;
                imageView4.setImageDrawable(this.a.getResources().getDrawable(com.baidu.tbadk.i.icon_webview_return_n));
            }
        } else {
            imageView = this.a.o;
            imageView.setEnabled(false);
            imageView2 = this.a.o;
            imageView2.setImageDrawable(this.a.getResources().getDrawable(com.baidu.tbadk.i.icon_webview_return_dd));
        }
        progressBar = this.a.g;
        progressBar.setVisibility(8);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        ImageView imageView;
        BaseWebView baseWebView;
        ImageView imageView2;
        ProgressBar progressBar;
        ImageView imageView3;
        super.onPageStarted(webView, str, bitmap);
        imageView = this.a.o;
        imageView.setImageDrawable(this.a.getResources().getDrawable(com.baidu.tbadk.i.icon_webview_return_dd));
        baseWebView = this.a.f;
        if (baseWebView.canGoBack()) {
            imageView3 = this.a.o;
            imageView3.setEnabled(true);
        } else {
            imageView2 = this.a.o;
            imageView2.setEnabled(false);
        }
        progressBar = this.a.g;
        progressBar.setVisibility(0);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return this.a.a(str);
    }
}
