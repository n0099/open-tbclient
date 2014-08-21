package com.baidu.tbadk.browser;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends WebViewClient {
    final /* synthetic */ WebTbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(WebTbActivity webTbActivity) {
        this.a = webTbActivity;
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
        if (this.a.a.canGoBack()) {
            imageView5 = this.a.j;
            imageView5.setEnabled(true);
        } else {
            imageView = this.a.j;
            imageView.setEnabled(false);
        }
        if (this.a.a.canGoForward()) {
            imageView4 = this.a.k;
            imageView4.setEnabled(true);
        } else {
            imageView2 = this.a.k;
            imageView2.setEnabled(false);
        }
        progressBar = this.a.m;
        progressBar.setVisibility(8);
        imageView3 = this.a.l;
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
        if (this.a.a.canGoBack()) {
            imageView5 = this.a.j;
            imageView5.setEnabled(true);
        } else {
            imageView = this.a.j;
            imageView.setEnabled(false);
        }
        if (this.a.a.canGoForward()) {
            imageView4 = this.a.k;
            imageView4.setEnabled(true);
        } else {
            imageView2 = this.a.k;
            imageView2.setEnabled(false);
        }
        progressBar = this.a.m;
        progressBar.setVisibility(0);
        imageView3 = this.a.l;
        imageView3.setVisibility(4);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if ((this.a.h == null || !this.a.h.a(str)) && !com.baidu.tbadk.b.f.a(this.a, str)) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        return true;
    }
}
