package com.baidu.tbadk.browser;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends WebViewClient {
    final /* synthetic */ WebTbActivity By;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(WebTbActivity webTbActivity) {
        this.By = webTbActivity;
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
        if (this.By.mWebView.canGoBack()) {
            imageView5 = this.By.Bo;
            imageView5.setEnabled(true);
        } else {
            imageView = this.By.Bo;
            imageView.setEnabled(false);
        }
        if (this.By.mWebView.canGoForward()) {
            imageView4 = this.By.Bp;
            imageView4.setEnabled(true);
        } else {
            imageView2 = this.By.Bp;
            imageView2.setEnabled(false);
        }
        progressBar = this.By.Bs;
        progressBar.setVisibility(8);
        imageView3 = this.By.Bq;
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
        if (this.By.mWebView.canGoBack()) {
            imageView5 = this.By.Bo;
            imageView5.setEnabled(true);
        } else {
            imageView = this.By.Bo;
            imageView.setEnabled(false);
        }
        if (this.By.mWebView.canGoForward()) {
            imageView4 = this.By.Bp;
            imageView4.setEnabled(true);
        } else {
            imageView2 = this.By.Bp;
            imageView2.setEnabled(false);
        }
        progressBar = this.By.Bs;
        progressBar.setVisibility(0);
        imageView3 = this.By.Bq;
        imageView3.setVisibility(4);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if ((this.By.Bx == null || !this.By.Bx.bJ(str)) && !com.baidu.tbadk.util.l.a(this.By, str)) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        return true;
    }
}
