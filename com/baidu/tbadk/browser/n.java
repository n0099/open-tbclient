package com.baidu.tbadk.browser;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bf;
/* loaded from: classes.dex */
public class n extends WebViewClient {
    final /* synthetic */ TbWebViewActivity Bg;

    /* JADX INFO: Access modifiers changed from: protected */
    public n(TbWebViewActivity tbWebViewActivity) {
        this.Bg = tbWebViewActivity;
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
        String unused;
        super.onPageFinished(webView, str);
        if (this.Bg.mWebView != null) {
            this.Bg.mUrl = this.Bg.mWebView.getUrl();
            str2 = this.Bg.mUrl;
            if (str2 != null) {
                str3 = this.Bg.mUrl;
                int indexOf = str3.indexOf(47, 8);
                if (indexOf > 8) {
                    str4 = this.Bg.mUrl;
                    str4.substring(0, indexOf);
                } else {
                    unused = this.Bg.mUrl;
                }
            }
            if (this.Bg.mWebView.canGoBack()) {
                imageView3 = this.Bg.mBottomBack;
                imageView3.setEnabled(true);
                imageView4 = this.Bg.mBottomBack;
                bc.c(imageView4, com.baidu.tieba.v.icon_webview_return_n);
            } else {
                imageView = this.Bg.mBottomBack;
                imageView.setEnabled(false);
                imageView2 = this.Bg.mBottomBack;
                imageView2.setImageDrawable(this.Bg.getResources().getDrawable(com.baidu.tieba.v.icon_webview_return_dd));
            }
            progressBar = this.Bg.mProgressBar;
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
        if (this.Bg.mWebView != null) {
            imageView = this.Bg.mBottomBack;
            imageView.setImageDrawable(this.Bg.getResources().getDrawable(com.baidu.tieba.v.icon_webview_return_dd));
            if (this.Bg.mWebView.canGoBack()) {
                imageView3 = this.Bg.mBottomBack;
                imageView3.setEnabled(true);
            } else {
                imageView2 = this.Bg.mBottomBack;
                imageView2.setEnabled(false);
            }
            progressBar = this.Bg.mProgressBar;
            progressBar.setVisibility(0);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (bf.isEmpty(str)) {
            return false;
        }
        if (com.baidu.tbadk.util.o.a(this.Bg, str)) {
            return true;
        }
        this.Bg.mUrl = str;
        this.Bg.refresh();
        return true;
    }
}
