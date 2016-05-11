package com.baidu.tbadk.core.c;

import android.graphics.Bitmap;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
/* loaded from: classes.dex */
public class b extends WebChromeClient {
    private final a Ti;
    private WebChromeClient Tj;
    private r Tk;

    public b() {
        this(null);
    }

    public b(WebChromeClient webChromeClient) {
        this.Ti = new a(this);
        this.Tj = webChromeClient;
    }

    public void a(r rVar) {
        this.Tk = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Q(String str, String str2) {
        return this.Tk.Q(str, str2);
    }

    public void a(WebChromeClient webChromeClient) {
        this.Tj = webChromeClient;
    }

    /* loaded from: classes.dex */
    private static final class a {
        private final b Tl;

        public a(b bVar) {
            this.Tl = bVar;
        }

        public boolean R(String str, String str2) {
            return !TextUtils.isEmpty(str2) && q.cF(str) && str2.startsWith("ctieba://");
        }

        public String S(String str, String str2) {
            return this.Tl.Q(str, str2.substring("ctieba://".length()));
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (this.Ti.R(str, str2)) {
            jsPromptResult.confirm(this.Ti.S(str, str2));
            return true;
        } else if (this.Tj != null) {
            return this.Tj.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        } else {
            return true;
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        if (this.Tj != null) {
            this.Tj.onProgressChanged(webView, i);
        } else {
            super.onProgressChanged(webView, i);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        if (this.Tj != null) {
            this.Tj.onReceivedTitle(webView, str);
        } else {
            super.onReceivedTitle(webView, str);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        if (this.Tj != null) {
            this.Tj.onReceivedIcon(webView, bitmap);
        } else {
            super.onReceivedIcon(webView, bitmap);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        if (this.Tj != null) {
            this.Tj.onReceivedTouchIconUrl(webView, str, z);
        } else {
            super.onReceivedTouchIconUrl(webView, str, z);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        if (this.Tj != null) {
            this.Tj.onShowCustomView(view, customViewCallback);
        } else {
            super.onShowCustomView(view, customViewCallback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        if (this.Tj != null) {
            this.Tj.onShowCustomView(view, i, customViewCallback);
        } else {
            super.onShowCustomView(view, i, customViewCallback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        if (this.Tj != null) {
            this.Tj.onHideCustomView();
        } else {
            super.onHideCustomView();
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        return this.Tj != null ? this.Tj.onCreateWindow(webView, z, z2, message) : super.onCreateWindow(webView, z, z2, message);
    }

    @Override // android.webkit.WebChromeClient
    public void onRequestFocus(WebView webView) {
        if (this.Tj != null) {
            this.Tj.onRequestFocus(webView);
        } else {
            super.onRequestFocus(webView);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(WebView webView) {
        if (this.Tj != null) {
            this.Tj.onCloseWindow(webView);
        } else {
            super.onCloseWindow(webView);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return this.Tj != null ? this.Tj.onJsAlert(webView, str, str2, jsResult) : super.onJsAlert(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return this.Tj != null ? this.Tj.onJsConfirm(webView, str, str2, jsResult) : super.onJsConfirm(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return this.Tj != null ? this.Tj.onJsBeforeUnload(webView, str, str2, jsResult) : super.onJsBeforeUnload(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        if (this.Tj != null) {
            this.Tj.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
        } else {
            super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        if (this.Tj != null) {
            this.Tj.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
        } else {
            super.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        if (this.Tj != null) {
            this.Tj.onGeolocationPermissionsShowPrompt(str, callback);
        } else {
            super.onGeolocationPermissionsShowPrompt(str, callback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        if (this.Tj != null) {
            this.Tj.onGeolocationPermissionsHidePrompt();
        } else {
            super.onGeolocationPermissionsHidePrompt();
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsTimeout() {
        return this.Tj != null ? this.Tj.onJsTimeout() : super.onJsTimeout();
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public void onConsoleMessage(String str, int i, String str2) {
        if (this.Tj != null) {
            this.Tj.onConsoleMessage(str, i, str2);
        } else {
            super.onConsoleMessage(str, i, str2);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return this.Tj != null ? this.Tj.onConsoleMessage(consoleMessage) : super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        return this.Tj != null ? this.Tj.getDefaultVideoPoster() : super.getDefaultVideoPoster();
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        return this.Tj != null ? this.Tj.getVideoLoadingProgressView() : super.getVideoLoadingProgressView();
    }

    @Override // android.webkit.WebChromeClient
    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        if (this.Tj != null) {
            this.Tj.getVisitedHistory(valueCallback);
        } else {
            super.getVisitedHistory(valueCallback);
        }
    }
}
