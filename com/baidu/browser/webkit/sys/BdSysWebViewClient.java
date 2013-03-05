package com.baidu.browser.webkit.sys;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.browser.webkit.BdWebView;
import com.baidu.browser.webkit.BdWebViewClient;
/* loaded from: classes.dex */
public class BdSysWebViewClient extends WebViewClient {
    private BdWebViewClient mWebViewClient;

    public BdSysWebViewClient(BdWebViewClient bdWebViewClient) {
        this.mWebViewClient = bdWebViewClient;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return this.mWebViewClient.shouldOverrideUrlLoading(this.mWebViewClient.obtainWebViewWrapper(webView), str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.mWebViewClient.onPageStarted(this.mWebViewClient.obtainWebViewWrapper(webView), str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.mWebViewClient.onPageFinished(this.mWebViewClient.obtainWebViewWrapper(webView), str);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        this.mWebViewClient.onLoadResource(this.mWebViewClient.obtainWebViewWrapper(webView), str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        BdWebView obtainWebViewWrapper = this.mWebViewClient.obtainWebViewWrapper(webView);
        switch (i) {
            case -15:
                this.mWebViewClient.onReceivedError(obtainWebViewWrapper, -15, str, str2);
                return;
            case -14:
                this.mWebViewClient.onReceivedError(obtainWebViewWrapper, -14, str, str2);
                return;
            case -13:
                this.mWebViewClient.onReceivedError(obtainWebViewWrapper, -13, str, str2);
                return;
            case -12:
                this.mWebViewClient.onReceivedError(obtainWebViewWrapper, -12, str, str2);
                return;
            case -11:
                this.mWebViewClient.onReceivedError(obtainWebViewWrapper, -11, str, str2);
                return;
            case -10:
                this.mWebViewClient.onReceivedError(obtainWebViewWrapper, -10, str, str2);
                return;
            case -9:
                this.mWebViewClient.onReceivedError(obtainWebViewWrapper, -9, str, str2);
                return;
            case -8:
                this.mWebViewClient.onReceivedError(obtainWebViewWrapper, -8, str, str2);
                return;
            case -7:
                this.mWebViewClient.onReceivedError(obtainWebViewWrapper, -7, str, str2);
                return;
            case -6:
                this.mWebViewClient.onReceivedError(obtainWebViewWrapper, -6, str, str2);
                return;
            case -5:
                this.mWebViewClient.onReceivedError(obtainWebViewWrapper, -5, str, str2);
                return;
            case -4:
                this.mWebViewClient.onReceivedError(obtainWebViewWrapper, -4, str, str2);
                return;
            case -3:
                this.mWebViewClient.onReceivedError(obtainWebViewWrapper, -3, str, str2);
                return;
            case -2:
                this.mWebViewClient.onReceivedError(obtainWebViewWrapper, -2, str, str2);
                return;
            case -1:
                this.mWebViewClient.onReceivedError(obtainWebViewWrapper, -1, str, str2);
                return;
            default:
                this.mWebViewClient.onReceivedError(obtainWebViewWrapper, -1, str, str2);
                return;
        }
    }

    @Override // android.webkit.WebViewClient
    public void onFormResubmission(WebView webView, Message message, Message message2) {
        this.mWebViewClient.onFormResubmission(this.mWebViewClient.obtainWebViewWrapper(webView), message, message2);
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        this.mWebViewClient.doUpdateVisitedHistory(this.mWebViewClient.obtainWebViewWrapper(webView), str, z);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        this.mWebViewClient.onReceivedSslError(this.mWebViewClient.obtainWebViewWrapper(webView), this.mWebViewClient.obtainSslErrorHandlerWrapper(sslErrorHandler), this.mWebViewClient.obtainSslErrorWrapper(sslError));
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.mWebViewClient.onReceivedHttpAuthRequest(this.mWebViewClient.obtainWebViewWrapper(webView), this.mWebViewClient.obtainHttpAuthHandlerWrapper(httpAuthHandler), str, str2);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        return this.mWebViewClient.shouldOverrideKeyEvent(this.mWebViewClient.obtainWebViewWrapper(webView), keyEvent);
    }

    @Override // android.webkit.WebViewClient
    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        this.mWebViewClient.onUnhandledKeyEvent(this.mWebViewClient.obtainWebViewWrapper(webView), keyEvent);
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(WebView webView, float f, float f2) {
        this.mWebViewClient.onScaleChanged(this.mWebViewClient.obtainWebViewWrapper(webView), f, f2);
    }
}
