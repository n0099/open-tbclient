package com.baidu.tbadk.browser;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
/* loaded from: classes.dex */
final class r extends WebViewClient {
    final /* synthetic */ WebTbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(WebTbActivity webTbActivity) {
        this.a = webTbActivity;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        ImageView imageView;
        ImageView imageView2;
        ProgressBar progressBar;
        ImageView imageView3;
        ImageView imageView4;
        ImageView imageView5;
        super.onPageFinished(webView, str);
        if (this.a.a.canGoBack()) {
            imageView5 = this.a.g;
            imageView5.setEnabled(true);
        } else {
            imageView = this.a.g;
            imageView.setEnabled(false);
        }
        if (this.a.a.canGoForward()) {
            imageView4 = this.a.h;
            imageView4.setEnabled(true);
        } else {
            imageView2 = this.a.h;
            imageView2.setEnabled(false);
        }
        progressBar = this.a.j;
        progressBar.setVisibility(8);
        imageView3 = this.a.i;
        imageView3.setVisibility(0);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        ImageView imageView;
        ImageView imageView2;
        ProgressBar progressBar;
        ImageView imageView3;
        ImageView imageView4;
        ImageView imageView5;
        super.onPageStarted(webView, str, bitmap);
        if (this.a.a.canGoBack()) {
            imageView5 = this.a.g;
            imageView5.setEnabled(true);
        } else {
            imageView = this.a.g;
            imageView.setEnabled(false);
        }
        if (this.a.a.canGoForward()) {
            imageView4 = this.a.h;
            imageView4.setEnabled(true);
        } else {
            imageView2 = this.a.h;
            imageView2.setEnabled(false);
        }
        progressBar = this.a.j;
        progressBar.setVisibility(0);
        imageView3 = this.a.i;
        imageView3.setVisibility(4);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if ((this.a.f == null || !this.a.f.a()) && !com.baidu.tbadk.d.d.a(this.a, str)) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        return true;
    }
}
