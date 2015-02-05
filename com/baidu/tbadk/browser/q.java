package com.baidu.tbadk.browser;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends WebViewClient {
    final /* synthetic */ WebTbActivity Bv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(WebTbActivity webTbActivity) {
        this.Bv = webTbActivity;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        ImageView imageView;
        ImageView imageView2;
        ProgressBar progressBar;
        ImageView imageView3;
        ImageView imageView4;
        ImageView imageView5;
        super.onPageFinished(webView, str);
        if (this.Bv.mWebView.canGoBack()) {
            imageView5 = this.Bv.Bl;
            imageView5.setEnabled(true);
        } else {
            imageView = this.Bv.Bl;
            imageView.setEnabled(false);
        }
        if (this.Bv.mWebView.canGoForward()) {
            imageView4 = this.Bv.Bm;
            imageView4.setEnabled(true);
        } else {
            imageView2 = this.Bv.Bm;
            imageView2.setEnabled(false);
        }
        progressBar = this.Bv.Bp;
        progressBar.setVisibility(8);
        imageView3 = this.Bv.Bn;
        imageView3.setVisibility(0);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        ImageView imageView;
        ImageView imageView2;
        ProgressBar progressBar;
        ImageView imageView3;
        ImageView imageView4;
        ImageView imageView5;
        super.onPageStarted(webView, str, bitmap);
        if (this.Bv.mWebView.canGoBack()) {
            imageView5 = this.Bv.Bl;
            imageView5.setEnabled(true);
        } else {
            imageView = this.Bv.Bl;
            imageView.setEnabled(false);
        }
        if (this.Bv.mWebView.canGoForward()) {
            imageView4 = this.Bv.Bm;
            imageView4.setEnabled(true);
        } else {
            imageView2 = this.Bv.Bm;
            imageView2.setEnabled(false);
        }
        progressBar = this.Bv.Bp;
        progressBar.setVisibility(0);
        imageView3 = this.Bv.Bn;
        imageView3.setVisibility(4);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if ((this.Bv.Bu == null || !this.Bv.Bu.bE(str)) && !com.baidu.tbadk.util.o.a(this.Bv, str)) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        return true;
    }
}
