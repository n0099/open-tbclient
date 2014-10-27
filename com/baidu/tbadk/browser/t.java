package com.baidu.tbadk.browser;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends WebViewClient {
    final /* synthetic */ WebTbActivity xR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(WebTbActivity webTbActivity) {
        this.xR = webTbActivity;
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
        if (this.xR.xG.canGoBack()) {
            imageView5 = this.xR.xI;
            imageView5.setEnabled(true);
        } else {
            imageView = this.xR.xI;
            imageView.setEnabled(false);
        }
        if (this.xR.xG.canGoForward()) {
            imageView4 = this.xR.xJ;
            imageView4.setEnabled(true);
        } else {
            imageView2 = this.xR.xJ;
            imageView2.setEnabled(false);
        }
        progressBar = this.xR.xM;
        progressBar.setVisibility(8);
        imageView3 = this.xR.xK;
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
        if (this.xR.xG.canGoBack()) {
            imageView5 = this.xR.xI;
            imageView5.setEnabled(true);
        } else {
            imageView = this.xR.xI;
            imageView.setEnabled(false);
        }
        if (this.xR.xG.canGoForward()) {
            imageView4 = this.xR.xJ;
            imageView4.setEnabled(true);
        } else {
            imageView2 = this.xR.xJ;
            imageView2.setEnabled(false);
        }
        progressBar = this.xR.xM;
        progressBar.setVisibility(0);
        imageView3 = this.xR.xK;
        imageView3.setVisibility(4);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if ((this.xR.xQ == null || !this.xR.xQ.aS(str)) && !com.baidu.tbadk.util.i.r(this.xR, str)) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        return true;
    }
}
