package com.baidu.tbadk.browser;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends WebViewClient {
    final /* synthetic */ TbWebViewActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(TbWebViewActivity tbWebViewActivity) {
        this.a = tbWebViewActivity;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        BaseWebView baseWebView;
        String str2;
        BaseWebView baseWebView2;
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
        TbWebViewActivity tbWebViewActivity = this.a;
        baseWebView = this.a.f;
        tbWebViewActivity.c = baseWebView.getUrl();
        str2 = this.a.c;
        if (str2 != null) {
            str3 = this.a.c;
            int indexOf = str3.indexOf(47, 8);
            if (indexOf > 8) {
                str5 = this.a.c;
                str4 = str5.substring(0, indexOf);
            } else {
                str4 = this.a.c;
            }
            if (!str4.contains("lecai.com") && !str4.contains("baidu.com")) {
                this.a.i();
            }
        }
        baseWebView2 = this.a.f;
        if (baseWebView2.canGoBack()) {
            imageView3 = this.a.o;
            imageView3.setEnabled(true);
            i = this.a.mSkinType;
            if (i == 1) {
                imageView5 = this.a.o;
                imageView5.setImageDrawable(this.a.getResources().getDrawable(com.baidu.tieba.u.icon_webview_return_n_1));
            } else {
                imageView4 = this.a.o;
                imageView4.setImageDrawable(this.a.getResources().getDrawable(com.baidu.tieba.u.icon_webview_return_n));
            }
        } else {
            imageView = this.a.o;
            imageView.setEnabled(false);
            imageView2 = this.a.o;
            imageView2.setImageDrawable(this.a.getResources().getDrawable(com.baidu.tieba.u.icon_webview_return_dd));
        }
        progressBar = this.a.g;
        progressBar.setVisibility(8);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        ImageView imageView;
        BaseWebView baseWebView;
        ImageView imageView2;
        ProgressBar progressBar;
        ImageView imageView3;
        super.onPageStarted(webView, str, bitmap);
        imageView = this.a.o;
        imageView.setImageDrawable(this.a.getResources().getDrawable(com.baidu.tieba.u.icon_webview_return_dd));
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
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return this.a.a(webView, str);
    }
}
