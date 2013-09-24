package com.baidu.browser.webkit.zeus;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import com.baidu.browser.core.BdNoProGuard;
import com.baidu.browser.webkit.BdWebChromeClient;
import com.baidu.browser.webkit.BdWebView;
import com.baidu.zeus.ConsoleMessage;
import com.baidu.zeus.GeolocationPermissions;
import com.baidu.zeus.JsPromptResult;
import com.baidu.zeus.JsResult;
import com.baidu.zeus.ValueCallback;
import com.baidu.zeus.WebChromeClient;
import com.baidu.zeus.WebStorage;
import com.baidu.zeus.WebView;
/* loaded from: classes.dex */
public class BdZeusWebChromeClient extends WebChromeClient implements BdNoProGuard {
    private BdWebChromeClient mWebChromeClient;

    public BdZeusWebChromeClient(BdWebChromeClient bdWebChromeClient) {
        this.mWebChromeClient = bdWebChromeClient;
    }

    @Override // com.baidu.zeus.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        this.mWebChromeClient.onProgressChanged(this.mWebChromeClient.obtainWebViewWrapper(webView), i);
    }

    @Override // com.baidu.zeus.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        this.mWebChromeClient.onReceivedTitle(this.mWebChromeClient.obtainWebViewWrapper(webView), str);
    }

    @Override // com.baidu.zeus.WebChromeClient
    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        this.mWebChromeClient.onReceivedIcon(this.mWebChromeClient.obtainWebViewWrapper(webView), bitmap);
    }

    @Override // com.baidu.zeus.WebChromeClient
    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        this.mWebChromeClient.onReceivedTouchIconUrl(this.mWebChromeClient.obtainWebViewWrapper(webView), str, z);
    }

    @Override // com.baidu.zeus.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.mWebChromeClient.onShowCustomView(view, this.mWebChromeClient.obtainCustomViewCallbackWrapper(customViewCallback));
    }

    @Override // com.baidu.zeus.WebChromeClient
    public void onHideCustomView() {
        this.mWebChromeClient.onHideCustomView();
    }

    @Override // com.baidu.zeus.WebChromeClient
    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        BdWebView obtainWebViewWrapper = this.mWebChromeClient.obtainWebViewWrapper(webView);
        return this.mWebChromeClient.onCreateWindow(obtainWebViewWrapper, z, z2, message, this.mWebChromeClient.obtainWebViewTransportWrapper(obtainWebViewWrapper, (WebView.WebViewTransport) message.obj));
    }

    @Override // com.baidu.zeus.WebChromeClient
    public void onRequestFocus(WebView webView) {
        this.mWebChromeClient.onRequestFocus(this.mWebChromeClient.obtainWebViewWrapper(webView));
    }

    @Override // com.baidu.zeus.WebChromeClient
    public void onCloseWindow(WebView webView) {
        this.mWebChromeClient.onCloseWindow(this.mWebChromeClient.obtainWebViewWrapper(webView));
    }

    @Override // com.baidu.zeus.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return this.mWebChromeClient.onJsAlert(this.mWebChromeClient.obtainWebViewWrapper(webView), str, str2, this.mWebChromeClient.obtainJsResultWrapper(jsResult));
    }

    @Override // com.baidu.zeus.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return this.mWebChromeClient.onJsConfirm(this.mWebChromeClient.obtainWebViewWrapper(webView), str, str2, this.mWebChromeClient.obtainJsResultWrapper(jsResult));
    }

    @Override // com.baidu.zeus.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return this.mWebChromeClient.onJsPrompt(this.mWebChromeClient.obtainWebViewWrapper(webView), str, str2, str3, this.mWebChromeClient.obtainJsPromptResultWrapper(jsPromptResult));
    }

    @Override // com.baidu.zeus.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return this.mWebChromeClient.onJsBeforeUnload(this.mWebChromeClient.obtainWebViewWrapper(webView), str, str2, this.mWebChromeClient.obtainJsResultWrapper(jsResult));
    }

    @Override // com.baidu.zeus.WebChromeClient
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        this.mWebChromeClient.onExceededDatabaseQuota(str, str2, j, j2, j3, this.mWebChromeClient.obtainQuotaUpdaterWrapper(quotaUpdater));
    }

    @Override // com.baidu.zeus.WebChromeClient
    public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        this.mWebChromeClient.onReachedMaxAppCacheSize(j, j2, this.mWebChromeClient.obtainQuotaUpdaterWrapper(quotaUpdater));
    }

    @Override // com.baidu.zeus.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        this.mWebChromeClient.onGeolocationPermissionsShowPrompt(str, this.mWebChromeClient.obtainGeolocationPermissionsCallbackWrapper(callback));
    }

    @Override // com.baidu.zeus.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        this.mWebChromeClient.onGeolocationPermissionsHidePrompt();
    }

    @Override // com.baidu.zeus.WebChromeClient
    public boolean onJsTimeout() {
        return this.mWebChromeClient.onJsTimeout();
    }

    @Override // com.baidu.zeus.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return this.mWebChromeClient.onConsoleMessage(this.mWebChromeClient.obtainConsoleMessageWrapper(consoleMessage));
    }

    @Override // com.baidu.zeus.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        return this.mWebChromeClient.getDefaultVideoPoster();
    }

    @Override // com.baidu.zeus.WebChromeClient
    public View getVideoLoadingProgressView() {
        return this.mWebChromeClient.getVideoLoadingProgressView();
    }

    @Override // com.baidu.zeus.WebChromeClient
    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        this.mWebChromeClient.getVisitedHistory(this.mWebChromeClient.obtainValueCallbackStringArrayWrapper(valueCallback));
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        this.mWebChromeClient.openFileChooser(this.mWebChromeClient.obtainValueCallbackUriWrapper(valueCallback), str, str2);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
        this.mWebChromeClient.openFileChooser(this.mWebChromeClient.obtainValueCallbackUriWrapper(valueCallback), str);
    }

    @Override // com.baidu.zeus.WebChromeClient
    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        this.mWebChromeClient.openFileChooser(this.mWebChromeClient.obtainValueCallbackUriWrapper(valueCallback));
    }

    @Override // com.baidu.zeus.WebChromeClient
    public String getStringById(int i) {
        return this.mWebChromeClient.getStringById(i);
    }

    @Override // com.baidu.zeus.WebChromeClient
    public void hideMagnifier(WebView webView, int i, int i2) {
        this.mWebChromeClient.hideMagnifier(this.mWebChromeClient.obtainWebViewWrapper(webView), i, i2);
    }

    @Override // com.baidu.zeus.WebChromeClient
    public void HideSelectionActionDialog(WebView webView) {
        this.mWebChromeClient.hideSelectionActionDialog(this.mWebChromeClient.obtainWebViewWrapper(webView));
    }

    @Override // com.baidu.zeus.WebChromeClient
    public void moveMagnifier(WebView webView, int i, int i2, int i3, int i4) {
        this.mWebChromeClient.moveMagnifier(this.mWebChromeClient.obtainWebViewWrapper(webView), i, i2, i3, i4);
    }

    @Override // com.baidu.zeus.WebChromeClient
    public void PerformLongClick(WebView webView, int i, String str, String str2, int i2, int i3) {
        this.mWebChromeClient.performLongClick(this.mWebChromeClient.obtainWebViewWrapper(webView), i, str, str2, i2, i3);
    }

    @Override // com.baidu.zeus.WebChromeClient
    public void showMagnifier(WebView webView, int i, int i2, int i3, int i4) {
        this.mWebChromeClient.showMagnifier(this.mWebChromeClient.obtainWebViewWrapper(webView), i, i2, i3, i4);
    }

    @Override // com.baidu.zeus.WebChromeClient
    public void ShowSelectionActionDialog(WebView webView, int i, int i2, int i3, int i4, String str) {
        this.mWebChromeClient.showSelectionActionDialog(this.mWebChromeClient.obtainWebViewWrapper(webView), i, i2, i3, i4, str);
    }

    @Override // com.baidu.zeus.WebChromeClient
    public void onSetLoadURL(WebView webView, String str) {
        this.mWebChromeClient.onSetLoadURL(this.mWebChromeClient.obtainWebViewWrapper(webView), str);
    }

    @Override // com.baidu.zeus.WebChromeClient
    public void copyText(WebView webView, String str) {
        this.mWebChromeClient.copyText(this.mWebChromeClient.obtainWebViewWrapper(webView), str);
    }
}
