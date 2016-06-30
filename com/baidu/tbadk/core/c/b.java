package com.baidu.tbadk.core.c;

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
public class b extends WebChromeClient {
    private WebChromeClient TA;
    private r TB;
    private final a Tz;

    public b() {
        this(null);
    }

    public b(WebChromeClient webChromeClient) {
        this.Tz = new a(this);
        this.TA = webChromeClient;
    }

    public void a(r rVar) {
        this.TB = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String P(String str, String str2) {
        return this.TB.P(str, str2);
    }

    public void a(WebChromeClient webChromeClient) {
        this.TA = webChromeClient;
    }

    /* loaded from: classes.dex */
    private static final class a {
        private final b TC;

        public a(b bVar) {
            this.TC = bVar;
        }

        public boolean Q(String str, String str2) {
            return !TextUtils.isEmpty(str2) && q.cE(str) && str2.startsWith("ctieba://");
        }

        public String R(String str, String str2) {
            return this.TC.P(str, str2.substring("ctieba://".length()));
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (this.Tz.Q(str, str2)) {
            jsPromptResult.confirm(this.Tz.R(str, str2));
            return true;
        } else if (this.TA != null) {
            return this.TA.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        } else {
            return true;
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        if (this.TA != null) {
            this.TA.onProgressChanged(webView, i);
        } else {
            super.onProgressChanged(webView, i);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        if (this.TA != null) {
            this.TA.onReceivedTitle(webView, str);
        } else {
            super.onReceivedTitle(webView, str);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        if (this.TA != null) {
            this.TA.onReceivedIcon(webView, bitmap);
        } else {
            super.onReceivedIcon(webView, bitmap);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        if (this.TA != null) {
            this.TA.onReceivedTouchIconUrl(webView, str, z);
        } else {
            super.onReceivedTouchIconUrl(webView, str, z);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        if (this.TA != null) {
            this.TA.onShowCustomView(view, customViewCallback);
        } else {
            super.onShowCustomView(view, customViewCallback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        if (this.TA != null) {
            this.TA.onShowCustomView(view, i, customViewCallback);
        } else {
            super.onShowCustomView(view, i, customViewCallback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        if (this.TA != null) {
            this.TA.onHideCustomView();
        } else {
            super.onHideCustomView();
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        return this.TA != null ? this.TA.onCreateWindow(webView, z, z2, message) : super.onCreateWindow(webView, z, z2, message);
    }

    @Override // android.webkit.WebChromeClient
    public void onRequestFocus(WebView webView) {
        if (this.TA != null) {
            this.TA.onRequestFocus(webView);
        } else {
            super.onRequestFocus(webView);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(WebView webView) {
        if (this.TA != null) {
            this.TA.onCloseWindow(webView);
        } else {
            super.onCloseWindow(webView);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return this.TA != null ? this.TA.onJsAlert(webView, str, str2, jsResult) : super.onJsAlert(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return this.TA != null ? this.TA.onJsConfirm(webView, str, str2, jsResult) : super.onJsConfirm(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return this.TA != null ? this.TA.onJsBeforeUnload(webView, str, str2, jsResult) : super.onJsBeforeUnload(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        if (this.TA != null) {
            this.TA.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
        } else {
            super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        if (this.TA != null) {
            this.TA.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
        } else {
            super.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        if (this.TA != null) {
            this.TA.onGeolocationPermissionsShowPrompt(str, callback);
        } else {
            super.onGeolocationPermissionsShowPrompt(str, callback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        if (this.TA != null) {
            this.TA.onGeolocationPermissionsHidePrompt();
        } else {
            super.onGeolocationPermissionsHidePrompt();
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsTimeout() {
        return this.TA != null ? this.TA.onJsTimeout() : super.onJsTimeout();
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public void onConsoleMessage(String str, int i, String str2) {
        if (this.TA != null) {
            this.TA.onConsoleMessage(str, i, str2);
        } else {
            super.onConsoleMessage(str, i, str2);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return this.TA != null ? this.TA.onConsoleMessage(consoleMessage) : super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        return this.TA != null ? this.TA.getDefaultVideoPoster() : super.getDefaultVideoPoster();
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        return this.TA != null ? this.TA.getVideoLoadingProgressView() : super.getVideoLoadingProgressView();
    }

    @Override // android.webkit.WebChromeClient
    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        if (this.TA != null) {
            this.TA.getVisitedHistory(valueCallback);
        } else {
            super.getVisitedHistory(valueCallback);
        }
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        if (this.TA != null) {
            try {
                this.TA.getClass().getDeclaredMethod("openFileChooser", ValueCallback.class).invoke(this.TA, valueCallback);
            } catch (IllegalAccessException e) {
                d.cC(e.getMessage());
            } catch (NoSuchMethodException e2) {
                d.cC(e2.getMessage());
            } catch (InvocationTargetException e3) {
                d.cC(e3.getMessage());
            } catch (Throwable th) {
                d.cC(th.getMessage());
            }
        }
    }

    public void openFileChooser(ValueCallback valueCallback, String str) {
        if (this.TA != null) {
            try {
                this.TA.getClass().getDeclaredMethod("openFileChooser", ValueCallback.class, String.class).invoke(this.TA, valueCallback, str);
            } catch (IllegalAccessException e) {
                d.cC(e.getMessage());
            } catch (NoSuchMethodException e2) {
                d.cC(e2.getMessage());
            } catch (InvocationTargetException e3) {
                d.cC(e3.getMessage());
            } catch (Throwable th) {
                d.cC(th.getMessage());
            }
        }
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        if (this.TA != null) {
            try {
                this.TA.getClass().getDeclaredMethod("openFileChooser", ValueCallback.class, String.class, String.class).invoke(this.TA, valueCallback, str, str2);
            } catch (IllegalAccessException e) {
                d.cC(e.getMessage());
            } catch (NoSuchMethodException e2) {
                d.cC(e2.getMessage());
            } catch (InvocationTargetException e3) {
                d.cC(e3.getMessage());
            } catch (Throwable th) {
                d.cC(th.getMessage());
            }
        }
    }
}
