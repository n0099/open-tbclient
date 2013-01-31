package com.baidu.browser.webkit;

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
import com.baidu.browser.webkit.BdGeolocationPermissions;
import com.baidu.browser.webkit.BdWebStorage;
import com.baidu.browser.webkit.BdWebView;
import com.baidu.browser.webkit.sys.BdSysWebChromeClient;
import com.baidu.browser.webkit.zeus.BdZeusWebChromeClient;
import com.baidu.zeus.GeolocationPermissions;
import com.baidu.zeus.WebChromeClient;
import com.baidu.zeus.WebStorage;
import com.baidu.zeus.WebView;
import java.lang.ref.SoftReference;
/* loaded from: classes.dex */
public class BdWebChromeClient {
    private SoftReference mConsoleMessageWrapper;
    private SoftReference mCustomViewCallbackWrapper;
    private SoftReference mGeolocationPermissionsCallbackWrapper;
    private SoftReference mJsPromptResultWrapper;
    private SoftReference mJsResultWrapper;
    private SoftReference mQuotaUpdaterWrapper;
    private BdSysWebChromeClient mSysWebChromeClient;
    private SoftReference mValueCallbackStringArrayWrapper;
    private SoftReference mValueCallbackUriWrapper;
    private SoftReference mWebViewTransportWrapper;
    private BdZeusWebChromeClient mZeusWebChromeClient;

    /* loaded from: classes.dex */
    public class BdCustomViewCallback {
        private WebChromeClient.CustomViewCallback mSysCustomViewCallback;
        private WebChromeClient.CustomViewCallback mZeusCustomViewCallback;

        public BdCustomViewCallback(WebChromeClient.CustomViewCallback customViewCallback) {
            this.mSysCustomViewCallback = customViewCallback;
        }

        public BdCustomViewCallback(WebChromeClient.CustomViewCallback customViewCallback) {
            this.mZeusCustomViewCallback = customViewCallback;
        }

        public boolean equals(Object obj) {
            return (obj instanceof BdCustomViewCallback) && unwrap() == ((BdCustomViewCallback) obj).unwrap();
        }

        public int hashCode() {
            return this.mZeusCustomViewCallback != null ? this.mZeusCustomViewCallback.hashCode() : this.mSysCustomViewCallback.hashCode();
        }

        public boolean isContains(Object obj) {
            return this.mZeusCustomViewCallback != null ? this.mZeusCustomViewCallback == obj : this.mSysCustomViewCallback == obj;
        }

        public Object unwrap() {
            return this.mZeusCustomViewCallback != null ? this.mZeusCustomViewCallback : this.mSysCustomViewCallback;
        }

        public void onCustomViewHidden() {
            if (this.mZeusCustomViewCallback != null) {
                this.mZeusCustomViewCallback.onCustomViewHidden();
            } else {
                this.mSysCustomViewCallback.onCustomViewHidden();
            }
        }
    }

    public BdWebChromeClient() {
        if (BdWebViewManager.getInstance().isZeusLoaded()) {
            this.mZeusWebChromeClient = new BdZeusWebChromeClient(this);
        } else {
            this.mSysWebChromeClient = new BdSysWebChromeClient(this);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof BdWebChromeClient) && unwrap() == ((BdWebChromeClient) obj).unwrap();
    }

    public int hashCode() {
        return this.mZeusWebChromeClient != null ? this.mZeusWebChromeClient.hashCode() : this.mSysWebChromeClient.hashCode();
    }

    public boolean isContains(Object obj) {
        return this.mZeusWebChromeClient != null ? this.mZeusWebChromeClient == obj : this.mSysWebChromeClient == obj;
    }

    public Object unwrap() {
        return this.mZeusWebChromeClient != null ? this.mZeusWebChromeClient : this.mSysWebChromeClient;
    }

    public BdWebView obtainWebViewWrapper(WebView webView) {
        return (BdWebView) webView.getTag();
    }

    public BdWebView obtainWebViewWrapper(com.baidu.zeus.WebView webView) {
        return (BdWebView) webView.getTag();
    }

    public BdCustomViewCallback obtainCustomViewCallbackWrapper(WebChromeClient.CustomViewCallback customViewCallback) {
        BdCustomViewCallback bdCustomViewCallback = null;
        if (this.mCustomViewCallbackWrapper != null) {
            bdCustomViewCallback = (BdCustomViewCallback) this.mCustomViewCallbackWrapper.get();
        }
        if (bdCustomViewCallback == null || !bdCustomViewCallback.isContains(customViewCallback)) {
            BdCustomViewCallback bdCustomViewCallback2 = new BdCustomViewCallback(customViewCallback);
            this.mCustomViewCallbackWrapper = new SoftReference(bdCustomViewCallback2);
            return bdCustomViewCallback2;
        }
        return bdCustomViewCallback;
    }

    public BdCustomViewCallback obtainCustomViewCallbackWrapper(WebChromeClient.CustomViewCallback customViewCallback) {
        BdCustomViewCallback bdCustomViewCallback = null;
        if (this.mCustomViewCallbackWrapper != null) {
            bdCustomViewCallback = (BdCustomViewCallback) this.mCustomViewCallbackWrapper.get();
        }
        if (bdCustomViewCallback == null || !bdCustomViewCallback.isContains(customViewCallback)) {
            BdCustomViewCallback bdCustomViewCallback2 = new BdCustomViewCallback(customViewCallback);
            this.mCustomViewCallbackWrapper = new SoftReference(bdCustomViewCallback2);
            return bdCustomViewCallback2;
        }
        return bdCustomViewCallback;
    }

    public BdJsResult obtainJsResultWrapper(JsResult jsResult) {
        BdJsResult bdJsResult = null;
        if (this.mJsResultWrapper != null) {
            bdJsResult = (BdJsResult) this.mJsResultWrapper.get();
        }
        if (bdJsResult == null || !bdJsResult.isContains(jsResult)) {
            BdJsResult bdJsResult2 = new BdJsResult(jsResult);
            this.mJsResultWrapper = new SoftReference(bdJsResult2);
            return bdJsResult2;
        }
        return bdJsResult;
    }

    public BdJsResult obtainJsResultWrapper(com.baidu.zeus.JsResult jsResult) {
        BdJsResult bdJsResult = null;
        if (this.mJsResultWrapper != null) {
            bdJsResult = (BdJsResult) this.mJsResultWrapper.get();
        }
        if (bdJsResult == null || !bdJsResult.isContains(jsResult)) {
            BdJsResult bdJsResult2 = new BdJsResult(jsResult);
            this.mJsResultWrapper = new SoftReference(bdJsResult2);
            return bdJsResult2;
        }
        return bdJsResult;
    }

    public BdJsPromptResult obtainJsPromptResultWrapper(JsPromptResult jsPromptResult) {
        BdJsPromptResult bdJsPromptResult = null;
        if (this.mJsResultWrapper != null) {
            bdJsPromptResult = (BdJsPromptResult) this.mJsPromptResultWrapper.get();
        }
        if (bdJsPromptResult == null || !bdJsPromptResult.isContains(jsPromptResult)) {
            BdJsPromptResult bdJsPromptResult2 = new BdJsPromptResult(jsPromptResult);
            this.mJsPromptResultWrapper = new SoftReference(bdJsPromptResult2);
            return bdJsPromptResult2;
        }
        return bdJsPromptResult;
    }

    public BdJsPromptResult obtainJsPromptResultWrapper(com.baidu.zeus.JsPromptResult jsPromptResult) {
        BdJsPromptResult bdJsPromptResult = null;
        if (this.mJsResultWrapper != null) {
            bdJsPromptResult = (BdJsPromptResult) this.mJsPromptResultWrapper.get();
        }
        if (bdJsPromptResult == null || !bdJsPromptResult.isContains(jsPromptResult)) {
            BdJsPromptResult bdJsPromptResult2 = new BdJsPromptResult(jsPromptResult);
            this.mJsPromptResultWrapper = new SoftReference(bdJsPromptResult2);
            return bdJsPromptResult2;
        }
        return bdJsPromptResult;
    }

    public BdWebStorage.BdQuotaUpdater obtainQuotaUpdaterWrapper(WebStorage.QuotaUpdater quotaUpdater) {
        BdWebStorage.BdQuotaUpdater bdQuotaUpdater = null;
        if (this.mQuotaUpdaterWrapper != null) {
            bdQuotaUpdater = (BdWebStorage.BdQuotaUpdater) this.mQuotaUpdaterWrapper.get();
        }
        if (bdQuotaUpdater == null || !bdQuotaUpdater.isContains(quotaUpdater)) {
            BdWebStorage bdWebStorage = BdWebStorage.getInstance();
            bdWebStorage.getClass();
            BdWebStorage.BdQuotaUpdater bdQuotaUpdater2 = new BdWebStorage.BdQuotaUpdater(quotaUpdater);
            this.mQuotaUpdaterWrapper = new SoftReference(bdQuotaUpdater2);
            return bdQuotaUpdater2;
        }
        return bdQuotaUpdater;
    }

    public BdWebStorage.BdQuotaUpdater obtainQuotaUpdaterWrapper(WebStorage.QuotaUpdater quotaUpdater) {
        BdWebStorage.BdQuotaUpdater bdQuotaUpdater = null;
        if (this.mQuotaUpdaterWrapper != null) {
            bdQuotaUpdater = (BdWebStorage.BdQuotaUpdater) this.mQuotaUpdaterWrapper.get();
        }
        if (bdQuotaUpdater == null || !bdQuotaUpdater.isContains(quotaUpdater)) {
            BdWebStorage bdWebStorage = BdWebStorage.getInstance();
            bdWebStorage.getClass();
            BdWebStorage.BdQuotaUpdater bdQuotaUpdater2 = new BdWebStorage.BdQuotaUpdater(quotaUpdater);
            this.mQuotaUpdaterWrapper = new SoftReference(bdQuotaUpdater2);
            return bdQuotaUpdater2;
        }
        return bdQuotaUpdater;
    }

    public BdGeolocationPermissions.BdCallback obtainGeolocationPermissionsCallbackWrapper(GeolocationPermissions.Callback callback) {
        BdGeolocationPermissions.BdCallback bdCallback = null;
        if (this.mGeolocationPermissionsCallbackWrapper != null) {
            bdCallback = (BdGeolocationPermissions.BdCallback) this.mGeolocationPermissionsCallbackWrapper.get();
        }
        if (bdCallback == null || !bdCallback.isContains(callback)) {
            BdGeolocationPermissions bdGeolocationPermissions = BdGeolocationPermissions.getInstance();
            bdGeolocationPermissions.getClass();
            BdGeolocationPermissions.BdCallback bdCallback2 = new BdGeolocationPermissions.BdCallback(callback);
            this.mGeolocationPermissionsCallbackWrapper = new SoftReference(bdCallback2);
            return bdCallback2;
        }
        return bdCallback;
    }

    public BdGeolocationPermissions.BdCallback obtainGeolocationPermissionsCallbackWrapper(GeolocationPermissions.Callback callback) {
        BdGeolocationPermissions.BdCallback bdCallback = null;
        if (this.mGeolocationPermissionsCallbackWrapper != null) {
            bdCallback = (BdGeolocationPermissions.BdCallback) this.mGeolocationPermissionsCallbackWrapper.get();
        }
        if (bdCallback == null || !bdCallback.isContains(callback)) {
            BdGeolocationPermissions bdGeolocationPermissions = BdGeolocationPermissions.getInstance();
            bdGeolocationPermissions.getClass();
            BdGeolocationPermissions.BdCallback bdCallback2 = new BdGeolocationPermissions.BdCallback(callback);
            this.mGeolocationPermissionsCallbackWrapper = new SoftReference(bdCallback2);
            return bdCallback2;
        }
        return bdCallback;
    }

    public BdConsoleMessage obtainConsoleMessageWrapper(ConsoleMessage consoleMessage) {
        BdConsoleMessage bdConsoleMessage = null;
        if (this.mConsoleMessageWrapper != null) {
            bdConsoleMessage = (BdConsoleMessage) this.mConsoleMessageWrapper.get();
        }
        if (bdConsoleMessage == null || !bdConsoleMessage.isContains(consoleMessage)) {
            BdConsoleMessage bdConsoleMessage2 = new BdConsoleMessage(consoleMessage);
            this.mConsoleMessageWrapper = new SoftReference(bdConsoleMessage2);
            return bdConsoleMessage2;
        }
        return bdConsoleMessage;
    }

    public BdConsoleMessage obtainConsoleMessageWrapper(com.baidu.zeus.ConsoleMessage consoleMessage) {
        BdConsoleMessage bdConsoleMessage = null;
        if (this.mConsoleMessageWrapper != null) {
            bdConsoleMessage = (BdConsoleMessage) this.mConsoleMessageWrapper.get();
        }
        if (bdConsoleMessage == null || !bdConsoleMessage.isContains(consoleMessage)) {
            BdConsoleMessage bdConsoleMessage2 = new BdConsoleMessage(consoleMessage);
            this.mConsoleMessageWrapper = new SoftReference(bdConsoleMessage2);
            return bdConsoleMessage2;
        }
        return bdConsoleMessage;
    }

    public BdValueCallback obtainValueCallbackStringArrayWrapper(ValueCallback valueCallback) {
        BdValueCallback bdValueCallback = null;
        if (this.mValueCallbackStringArrayWrapper != null) {
            bdValueCallback = (BdValueCallback) this.mValueCallbackStringArrayWrapper.get();
        }
        if (bdValueCallback == null || !bdValueCallback.isContains(valueCallback)) {
            BdValueCallback bdValueCallback2 = new BdValueCallback(valueCallback);
            this.mValueCallbackStringArrayWrapper = new SoftReference(bdValueCallback2);
            return bdValueCallback2;
        }
        return bdValueCallback;
    }

    public BdValueCallback obtainValueCallbackStringArrayWrapper(com.baidu.zeus.ValueCallback valueCallback) {
        BdValueCallback bdValueCallback = null;
        if (this.mValueCallbackStringArrayWrapper != null) {
            bdValueCallback = (BdValueCallback) this.mValueCallbackStringArrayWrapper.get();
        }
        if (bdValueCallback == null || !bdValueCallback.isContains(valueCallback)) {
            BdValueCallback bdValueCallback2 = new BdValueCallback(valueCallback);
            this.mValueCallbackStringArrayWrapper = new SoftReference(bdValueCallback2);
            return bdValueCallback2;
        }
        return bdValueCallback;
    }

    public BdValueCallback obtainValueCallbackUriWrapper(ValueCallback valueCallback) {
        BdValueCallback bdValueCallback = null;
        if (this.mValueCallbackUriWrapper != null) {
            bdValueCallback = (BdValueCallback) this.mValueCallbackUriWrapper.get();
        }
        if (bdValueCallback == null || !bdValueCallback.isContains(valueCallback)) {
            BdValueCallback bdValueCallback2 = new BdValueCallback(valueCallback);
            this.mValueCallbackUriWrapper = new SoftReference(bdValueCallback2);
            return bdValueCallback2;
        }
        return bdValueCallback;
    }

    public BdValueCallback obtainValueCallbackUriWrapper(com.baidu.zeus.ValueCallback valueCallback) {
        BdValueCallback bdValueCallback = null;
        if (this.mValueCallbackUriWrapper != null) {
            bdValueCallback = (BdValueCallback) this.mValueCallbackUriWrapper.get();
        }
        if (bdValueCallback == null || !bdValueCallback.isContains(valueCallback)) {
            BdValueCallback bdValueCallback2 = new BdValueCallback(valueCallback);
            this.mValueCallbackUriWrapper = new SoftReference(bdValueCallback2);
            return bdValueCallback2;
        }
        return bdValueCallback;
    }

    public BdWebView.BdWebViewTransport obtainWebViewTransportWrapper(BdWebView bdWebView, WebView.WebViewTransport webViewTransport) {
        BdWebView.BdWebViewTransport bdWebViewTransport = null;
        if (this.mWebViewTransportWrapper != null) {
            bdWebViewTransport = (BdWebView.BdWebViewTransport) this.mWebViewTransportWrapper.get();
        }
        if (bdWebViewTransport == null || !bdWebViewTransport.isContains(webViewTransport)) {
            bdWebView.getClass();
            BdWebView.BdWebViewTransport bdWebViewTransport2 = new BdWebView.BdWebViewTransport(webViewTransport);
            this.mWebViewTransportWrapper = new SoftReference(bdWebViewTransport2);
            return bdWebViewTransport2;
        }
        return bdWebViewTransport;
    }

    public BdWebView.BdWebViewTransport obtainWebViewTransportWrapper(BdWebView bdWebView, WebView.WebViewTransport webViewTransport) {
        BdWebView.BdWebViewTransport bdWebViewTransport = null;
        if (this.mWebViewTransportWrapper != null) {
            bdWebViewTransport = (BdWebView.BdWebViewTransport) this.mWebViewTransportWrapper.get();
        }
        if (bdWebViewTransport == null || !bdWebViewTransport.isContains(webViewTransport)) {
            bdWebView.getClass();
            BdWebView.BdWebViewTransport bdWebViewTransport2 = new BdWebView.BdWebViewTransport(webViewTransport);
            this.mWebViewTransportWrapper = new SoftReference(bdWebViewTransport2);
            return bdWebViewTransport2;
        }
        return bdWebViewTransport;
    }

    public void onProgressChanged(BdWebView bdWebView, int i) {
    }

    public void onReceivedTitle(BdWebView bdWebView, String str) {
    }

    public void onReceivedIcon(BdWebView bdWebView, Bitmap bitmap) {
    }

    public void onReceivedTouchIconUrl(BdWebView bdWebView, String str, boolean z) {
    }

    public void onShowCustomView(View view, BdCustomViewCallback bdCustomViewCallback) {
    }

    public void onShowCustomView(View view, int i, BdCustomViewCallback bdCustomViewCallback) {
    }

    public void onHideCustomView() {
    }

    public boolean onCreateWindow(BdWebView bdWebView, boolean z, boolean z2, Message message, BdWebView.BdWebViewTransport bdWebViewTransport) {
        return false;
    }

    public void onRequestFocus(BdWebView bdWebView) {
    }

    public void onCloseWindow(BdWebView bdWebView) {
    }

    public boolean onJsAlert(BdWebView bdWebView, String str, String str2, BdJsResult bdJsResult) {
        return false;
    }

    public boolean onJsConfirm(BdWebView bdWebView, String str, String str2, BdJsResult bdJsResult) {
        return false;
    }

    public boolean onJsPrompt(BdWebView bdWebView, String str, String str2, String str3, BdJsPromptResult bdJsPromptResult) {
        return false;
    }

    public boolean onJsBeforeUnload(BdWebView bdWebView, String str, String str2, BdJsResult bdJsResult) {
        return false;
    }

    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, BdWebStorage.BdQuotaUpdater bdQuotaUpdater) {
        bdQuotaUpdater.updateQuota(j);
    }

    public void onReachedMaxAppCacheSize(long j, long j2, BdWebStorage.BdQuotaUpdater bdQuotaUpdater) {
        bdQuotaUpdater.updateQuota(0L);
    }

    public void onGeolocationPermissionsShowPrompt(String str, BdGeolocationPermissions.BdCallback bdCallback) {
    }

    public void onGeolocationPermissionsHidePrompt() {
    }

    public boolean onJsTimeout() {
        return true;
    }

    public boolean onConsoleMessage(BdConsoleMessage bdConsoleMessage) {
        return false;
    }

    public Bitmap getDefaultVideoPoster() {
        return null;
    }

    public View getVideoLoadingProgressView() {
        return null;
    }

    public void getVisitedHistory(BdValueCallback bdValueCallback) {
    }

    public void openFileChooser(BdValueCallback bdValueCallback, String str, String str2) {
    }

    public void openFileChooser(BdValueCallback bdValueCallback, String str) {
    }

    public void openFileChooser(BdValueCallback bdValueCallback) {
    }

    public String getStringById(int i) {
        return null;
    }

    public void copyText(BdWebView bdWebView, String str) {
    }

    public void hideMagnifier(BdWebView bdWebView, int i, int i2) {
    }

    public void hideSelectionActionDialog(BdWebView bdWebView) {
    }

    public void moveMagnifier(BdWebView bdWebView, int i, int i2, int i3, int i4) {
    }

    public void performLongClick(BdWebView bdWebView, int i, String str, String str2, int i2, int i3) {
    }

    public void showMagnifier(BdWebView bdWebView, int i, int i2, int i3, int i4) {
    }

    public void showSelectionActionDialog(BdWebView bdWebView, int i, int i2, int i3, int i4, String str) {
    }

    public void onSetLoadURL(BdWebView bdWebView, String str) {
    }
}
