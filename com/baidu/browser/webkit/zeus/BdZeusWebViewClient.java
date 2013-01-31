package com.baidu.browser.webkit.zeus;

import android.graphics.Bitmap;
import android.os.Message;
import android.view.KeyEvent;
import com.baidu.browser.webkit.BdWebView;
import com.baidu.browser.webkit.BdWebViewClient;
import com.baidu.zeus.HttpAuthHandler;
import com.baidu.zeus.SslError;
import com.baidu.zeus.SslErrorHandler;
import com.baidu.zeus.WebView;
import com.baidu.zeus.WebViewClient;
/* loaded from: classes.dex */
public class BdZeusWebViewClient extends WebViewClient {
    private BdWebViewClient mWebViewClient;

    public BdZeusWebViewClient(BdWebViewClient bdWebViewClient) {
        this.mWebViewClient = bdWebViewClient;
    }

    @Override // com.baidu.zeus.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return this.mWebViewClient.shouldOverrideUrlLoading(this.mWebViewClient.obtainWebViewWrapper(webView), str);
    }

    @Override // com.baidu.zeus.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.mWebViewClient.onPageStarted(this.mWebViewClient.obtainWebViewWrapper(webView), str, bitmap);
    }

    @Override // com.baidu.zeus.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.mWebViewClient.onPageFinished(this.mWebViewClient.obtainWebViewWrapper(webView), str);
    }

    @Override // com.baidu.zeus.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        this.mWebViewClient.onLoadResource(this.mWebViewClient.obtainWebViewWrapper(webView), str);
    }

    @Override // com.baidu.zeus.WebViewClient
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

    @Override // com.baidu.zeus.WebViewClient
    public void onFormResubmission(WebView webView, Message message, Message message2) {
        this.mWebViewClient.onFormResubmission(this.mWebViewClient.obtainWebViewWrapper(webView), message, message2);
    }

    @Override // com.baidu.zeus.WebViewClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        this.mWebViewClient.doUpdateVisitedHistory(this.mWebViewClient.obtainWebViewWrapper(webView), str, z);
    }

    @Override // com.baidu.zeus.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        this.mWebViewClient.onReceivedSslError(this.mWebViewClient.obtainWebViewWrapper(webView), this.mWebViewClient.obtainSslErrorHandlerWrapper(sslErrorHandler), this.mWebViewClient.obtainSslErrorWrapper(sslError));
    }

    @Override // com.baidu.zeus.WebViewClient
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.mWebViewClient.onReceivedHttpAuthRequest(this.mWebViewClient.obtainWebViewWrapper(webView), this.mWebViewClient.obtainHttpAuthHandlerWrapper(httpAuthHandler), str, str2);
    }

    @Override // com.baidu.zeus.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        return this.mWebViewClient.shouldOverrideKeyEvent(this.mWebViewClient.obtainWebViewWrapper(webView), keyEvent);
    }

    @Override // com.baidu.zeus.WebViewClient
    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        this.mWebViewClient.onUnhandledKeyEvent(this.mWebViewClient.obtainWebViewWrapper(webView), keyEvent);
    }

    @Override // com.baidu.zeus.WebViewClient
    public void onScaleChanged(WebView webView, float f, float f2) {
        this.mWebViewClient.onScaleChanged(this.mWebViewClient.obtainWebViewWrapper(webView), f, f2);
    }

    @Override // com.baidu.zeus.WebViewClient
    public void onBaiduSearchPVCollected(WebView webView) {
        this.mWebViewClient.onBaiduSearchPVCollected(this.mWebViewClient.obtainWebViewWrapper(webView));
    }

    @Override // com.baidu.zeus.WebViewClient
    public void onFirstLayoutDid(WebView webView, String str) {
        this.mWebViewClient.onFirstLayoutDid(this.mWebViewClient.obtainWebViewWrapper(webView), str);
    }

    @Override // com.baidu.zeus.WebViewClient
    public void onSubjectsCollected(WebView webView, boolean z, int i) {
        this.mWebViewClient.onSubjectsCollected(this.mWebViewClient.obtainWebViewWrapper(webView), z, i);
    }

    @Override // com.baidu.zeus.WebViewClient
    public boolean shouldShowSubject(WebView webView, String str, String str2, String str3) {
        return this.mWebViewClient.shouldShowSubject(this.mWebViewClient.obtainWebViewWrapper(webView), str, str2, str3);
    }

    @Override // com.baidu.zeus.WebViewClient
    public void onMainActionsCollected(WebView webView, boolean z, int i) {
        this.mWebViewClient.onMainActionsCollected(this.mWebViewClient.obtainWebViewWrapper(webView), z, i);
    }

    @Override // com.baidu.zeus.WebViewClient
    public void onPageCanBeScaled(WebView webView) {
        this.mWebViewClient.onPageCanBeScaled(this.mWebViewClient.obtainWebViewWrapper(webView));
    }

    @Override // com.baidu.zeus.WebViewClient
    public void onFullScreenMode(WebView webView, boolean z, int i, int i2) {
        this.mWebViewClient.onFullScreenMode(this.mWebViewClient.obtainWebViewWrapper(webView), z, i, i2);
    }

    @Override // com.baidu.zeus.WebViewClient
    public void onHasVideo(WebView webView) {
        this.mWebViewClient.onHasVideo(this.mWebViewClient.obtainWebViewWrapper(webView));
    }
}
