package com.baidu.browser.webkit.sys;

import android.graphics.Bitmap;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import com.baidu.browser.core.BdNoProGuard;
import com.baidu.browser.webkit.BdWebChromeClient;
import com.baidu.browser.webkit.BdWebView;
/* loaded from: classes.dex */
public class BdSysWebChromeClient extends WebChromeClient implements BdNoProGuard {
    private BdWebChromeClient mWebChromeClient;

    public BdSysWebChromeClient(BdWebChromeClient bdWebChromeClient) {
        this.mWebChromeClient = bdWebChromeClient;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        this.mWebChromeClient.onProgressChanged(this.mWebChromeClient.obtainWebViewWrapper(webView), i);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        this.mWebChromeClient.onReceivedTitle(this.mWebChromeClient.obtainWebViewWrapper(webView), str);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        this.mWebChromeClient.onReceivedIcon(this.mWebChromeClient.obtainWebViewWrapper(webView), bitmap);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        this.mWebChromeClient.onReceivedTouchIconUrl(this.mWebChromeClient.obtainWebViewWrapper(webView), str, z);
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.mWebChromeClient.onShowCustomView(view, this.mWebChromeClient.obtainCustomViewCallbackWrapper(customViewCallback));
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        this.mWebChromeClient.onShowCustomView(view, i, this.mWebChromeClient.obtainCustomViewCallbackWrapper(customViewCallback));
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        this.mWebChromeClient.onHideCustomView();
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        BdWebView obtainWebViewWrapper = this.mWebChromeClient.obtainWebViewWrapper(webView);
        return this.mWebChromeClient.onCreateWindow(obtainWebViewWrapper, z, z2, message, this.mWebChromeClient.obtainWebViewTransportWrapper(obtainWebViewWrapper, (WebView.WebViewTransport) message.obj));
    }

    @Override // android.webkit.WebChromeClient
    public void onRequestFocus(WebView webView) {
        this.mWebChromeClient.onRequestFocus(this.mWebChromeClient.obtainWebViewWrapper(webView));
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(WebView webView) {
        this.mWebChromeClient.onCloseWindow(this.mWebChromeClient.obtainWebViewWrapper(webView));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return this.mWebChromeClient.onJsAlert(this.mWebChromeClient.obtainWebViewWrapper(webView), str, str2, this.mWebChromeClient.obtainJsResultWrapper(jsResult));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return this.mWebChromeClient.onJsConfirm(this.mWebChromeClient.obtainWebViewWrapper(webView), str, str2, this.mWebChromeClient.obtainJsResultWrapper(jsResult));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return this.mWebChromeClient.onJsPrompt(this.mWebChromeClient.obtainWebViewWrapper(webView), str, str2, str3, this.mWebChromeClient.obtainJsPromptResultWrapper(jsPromptResult));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return this.mWebChromeClient.onJsBeforeUnload(this.mWebChromeClient.obtainWebViewWrapper(webView), str, str2, this.mWebChromeClient.obtainJsResultWrapper(jsResult));
    }

    @Override // android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        this.mWebChromeClient.onExceededDatabaseQuota(str, str2, j, j2, j3, this.mWebChromeClient.obtainQuotaUpdaterWrapper(quotaUpdater));
    }

    @Override // android.webkit.WebChromeClient
    public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        this.mWebChromeClient.onReachedMaxAppCacheSize(j, j2, this.mWebChromeClient.obtainQuotaUpdaterWrapper(quotaUpdater));
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        this.mWebChromeClient.onGeolocationPermissionsShowPrompt(str, this.mWebChromeClient.obtainGeolocationPermissionsCallbackWrapper(callback));
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        this.mWebChromeClient.onGeolocationPermissionsHidePrompt();
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsTimeout() {
        return this.mWebChromeClient.onJsTimeout();
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return this.mWebChromeClient.onConsoleMessage(this.mWebChromeClient.obtainConsoleMessageWrapper(consoleMessage));
    }

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        return this.mWebChromeClient.getDefaultVideoPoster();
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        return this.mWebChromeClient.getVideoLoadingProgressView();
    }

    @Override // android.webkit.WebChromeClient
    public void getVisitedHistory(ValueCallback valueCallback) {
        this.mWebChromeClient.getVisitedHistory(this.mWebChromeClient.obtainValueCallbackStringArrayWrapper(valueCallback));
    }

    public void openFileChooser(ValueCallback valueCallback, String str, String str2) {
        this.mWebChromeClient.openFileChooser(this.mWebChromeClient.obtainValueCallbackUriWrapper(valueCallback), str, str2);
    }

    public void openFileChooser(ValueCallback valueCallback, String str) {
        this.mWebChromeClient.openFileChooser(this.mWebChromeClient.obtainValueCallbackUriWrapper(valueCallback), str);
    }

    public void openFileChooser(ValueCallback valueCallback) {
        this.mWebChromeClient.openFileChooser(this.mWebChromeClient.obtainValueCallbackUriWrapper(valueCallback));
    }
}
