package com.baidu.tbadk.core.d;

import android.graphics.Bitmap;
import android.net.Uri;
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
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
public class c extends WebChromeClient {
    private final a abV;
    private WebChromeClient abW;
    private s abX;

    public c() {
        this(null);
    }

    public c(WebChromeClient webChromeClient) {
        this.abV = new a(this);
        this.abW = webChromeClient;
    }

    public void a(s sVar) {
        this.abX = sVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String O(String str, String str2) {
        return this.abX.O(str, str2);
    }

    public void a(WebChromeClient webChromeClient) {
        this.abW = webChromeClient;
    }

    /* loaded from: classes.dex */
    private static final class a {
        private final c abY;

        public a(c cVar) {
            this.abY = cVar;
        }

        public boolean P(String str, String str2) {
            return !TextUtils.isEmpty(str2) && r.cJ(str) && str2.startsWith("ctieba://");
        }

        public String Q(String str, String str2) {
            return this.abY.O(str, str2.substring("ctieba://".length()));
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (this.abV.P(str, str2)) {
            jsPromptResult.confirm(this.abV.Q(str, str2));
            return true;
        } else if (this.abW != null) {
            return this.abW.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        } else {
            return true;
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        if (this.abW != null) {
            this.abW.onProgressChanged(webView, i);
        } else {
            super.onProgressChanged(webView, i);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        if (this.abW != null) {
            this.abW.onReceivedTitle(webView, str);
        } else {
            super.onReceivedTitle(webView, str);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        if (this.abW != null) {
            this.abW.onReceivedIcon(webView, bitmap);
        } else {
            super.onReceivedIcon(webView, bitmap);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        if (this.abW != null) {
            this.abW.onReceivedTouchIconUrl(webView, str, z);
        } else {
            super.onReceivedTouchIconUrl(webView, str, z);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        if (this.abW != null) {
            this.abW.onShowCustomView(view, customViewCallback);
        } else {
            super.onShowCustomView(view, customViewCallback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        if (this.abW != null) {
            this.abW.onShowCustomView(view, i, customViewCallback);
        } else {
            super.onShowCustomView(view, i, customViewCallback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        if (this.abW != null) {
            this.abW.onHideCustomView();
        } else {
            super.onHideCustomView();
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        return this.abW != null ? this.abW.onCreateWindow(webView, z, z2, message) : super.onCreateWindow(webView, z, z2, message);
    }

    @Override // android.webkit.WebChromeClient
    public void onRequestFocus(WebView webView) {
        if (this.abW != null) {
            this.abW.onRequestFocus(webView);
        } else {
            super.onRequestFocus(webView);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(WebView webView) {
        if (this.abW != null) {
            this.abW.onCloseWindow(webView);
        } else {
            super.onCloseWindow(webView);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return this.abW != null ? this.abW.onJsAlert(webView, str, str2, jsResult) : super.onJsAlert(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return this.abW != null ? this.abW.onJsConfirm(webView, str, str2, jsResult) : super.onJsConfirm(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return this.abW != null ? this.abW.onJsBeforeUnload(webView, str, str2, jsResult) : super.onJsBeforeUnload(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        if (this.abW != null) {
            this.abW.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
        } else {
            super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        if (this.abW != null) {
            this.abW.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
        } else {
            super.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        if (this.abW != null) {
            this.abW.onGeolocationPermissionsShowPrompt(str, callback);
        } else {
            super.onGeolocationPermissionsShowPrompt(str, callback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        if (this.abW != null) {
            this.abW.onGeolocationPermissionsHidePrompt();
        } else {
            super.onGeolocationPermissionsHidePrompt();
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsTimeout() {
        return this.abW != null ? this.abW.onJsTimeout() : super.onJsTimeout();
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public void onConsoleMessage(String str, int i, String str2) {
        if (this.abW != null) {
            this.abW.onConsoleMessage(str, i, str2);
        } else {
            super.onConsoleMessage(str, i, str2);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return this.abW != null ? this.abW.onConsoleMessage(consoleMessage) : super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        return this.abW != null ? this.abW.getDefaultVideoPoster() : super.getDefaultVideoPoster();
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        return this.abW != null ? this.abW.getVideoLoadingProgressView() : super.getVideoLoadingProgressView();
    }

    @Override // android.webkit.WebChromeClient
    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        if (this.abW != null) {
            this.abW.getVisitedHistory(valueCallback);
        } else {
            super.getVisitedHistory(valueCallback);
        }
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        if (this.abW != null) {
            try {
                this.abW.getClass().getDeclaredMethod("openFileChooser", ValueCallback.class).invoke(this.abW, valueCallback);
            } catch (IllegalAccessException e) {
                e.cH(e.getMessage());
            } catch (NoSuchMethodException e2) {
                e.cH(e2.getMessage());
            } catch (InvocationTargetException e3) {
                e.cH(e3.getMessage());
            } catch (Throwable th) {
                e.cH(th.getMessage());
            }
        }
    }

    public void openFileChooser(ValueCallback valueCallback, String str) {
        if (this.abW != null) {
            try {
                this.abW.getClass().getDeclaredMethod("openFileChooser", ValueCallback.class, String.class).invoke(this.abW, valueCallback, str);
            } catch (IllegalAccessException e) {
                e.cH(e.getMessage());
            } catch (NoSuchMethodException e2) {
                e.cH(e2.getMessage());
            } catch (InvocationTargetException e3) {
                e.cH(e3.getMessage());
            } catch (Throwable th) {
                e.cH(th.getMessage());
            }
        }
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        if (this.abW != null) {
            try {
                this.abW.getClass().getDeclaredMethod("openFileChooser", ValueCallback.class, String.class, String.class).invoke(this.abW, valueCallback, str, str2);
            } catch (IllegalAccessException e) {
                e.cH(e.getMessage());
            } catch (NoSuchMethodException e2) {
                e.cH(e2.getMessage());
            } catch (InvocationTargetException e3) {
                e.cH(e3.getMessage());
            } catch (Throwable th) {
                e.cH(th.getMessage());
            }
        }
    }
}
