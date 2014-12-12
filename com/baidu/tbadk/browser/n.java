package com.baidu.tbadk.browser;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.ba;
/* loaded from: classes.dex */
public class n extends WebViewClient {
    final /* synthetic */ TbWebViewActivity Bj;

    /* JADX INFO: Access modifiers changed from: protected */
    public n(TbWebViewActivity tbWebViewActivity) {
        this.Bj = tbWebViewActivity;
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
        if (this.Bj.mWebView != null) {
            this.Bj.mUrl = this.Bj.mWebView.getUrl();
            str2 = this.Bj.mUrl;
            if (str2 != null) {
                str3 = this.Bj.mUrl;
                int indexOf = str3.indexOf(47, 8);
                if (indexOf > 8) {
                    str4 = this.Bj.mUrl;
                    str4.substring(0, indexOf);
                } else {
                    unused = this.Bj.mUrl;
                }
            }
            if (this.Bj.mWebView.canGoBack()) {
                imageView3 = this.Bj.mBottomBack;
                imageView3.setEnabled(true);
                imageView4 = this.Bj.mBottomBack;
                ax.c(imageView4, com.baidu.tieba.v.icon_webview_return_n);
            } else {
                imageView = this.Bj.mBottomBack;
                imageView.setEnabled(false);
                imageView2 = this.Bj.mBottomBack;
                imageView2.setImageDrawable(this.Bj.getResources().getDrawable(com.baidu.tieba.v.icon_webview_return_dd));
            }
            progressBar = this.Bj.mProgressBar;
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
        if (this.Bj.mWebView != null) {
            imageView = this.Bj.mBottomBack;
            imageView.setImageDrawable(this.Bj.getResources().getDrawable(com.baidu.tieba.v.icon_webview_return_dd));
            if (this.Bj.mWebView.canGoBack()) {
                imageView3 = this.Bj.mBottomBack;
                imageView3.setEnabled(true);
            } else {
                imageView2 = this.Bj.mBottomBack;
                imageView2.setEnabled(false);
            }
            progressBar = this.Bj.mProgressBar;
            progressBar.setVisibility(0);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (ba.isEmpty(str)) {
            return false;
        }
        if (com.baidu.tbadk.util.l.a(this.Bj, str)) {
            return true;
        }
        this.Bj.mUrl = str;
        this.Bj.refresh();
        return true;
    }
}
