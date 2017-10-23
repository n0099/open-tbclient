package com.baidu.tbadk.core.hybrid;

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
    private final a ack;
    private WebChromeClient acl;
    private r acm;

    public c() {
        this(null);
    }

    public c(WebChromeClient webChromeClient) {
        this.ack = new a(this);
        this.acl = webChromeClient;
    }

    public void a(r rVar) {
        this.acm = rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String P(String str, String str2) {
        return this.acm.P(str, str2);
    }

    public void a(WebChromeClient webChromeClient) {
        this.acl = webChromeClient;
    }

    /* loaded from: classes.dex */
    private static final class a {
        private final c acn;

        public a(c cVar) {
            this.acn = cVar;
        }

        public boolean Q(String str, String str2) {
            return !TextUtils.isEmpty(str2) && q.cQ(str) && str2.startsWith("ctieba://");
        }

        public String R(String str, String str2) {
            return this.acn.P(str, str2.substring("ctieba://".length()));
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (this.ack.Q(str, str2)) {
            jsPromptResult.confirm(this.ack.R(str, str2));
            return true;
        } else if (this.acl != null) {
            return this.acl.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        } else {
            return true;
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        if (this.acl != null) {
            this.acl.onProgressChanged(webView, i);
        } else {
            super.onProgressChanged(webView, i);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        if (this.acl != null) {
            this.acl.onReceivedTitle(webView, str);
        } else {
            super.onReceivedTitle(webView, str);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        if (this.acl != null) {
            this.acl.onReceivedIcon(webView, bitmap);
        } else {
            super.onReceivedIcon(webView, bitmap);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        if (this.acl != null) {
            this.acl.onReceivedTouchIconUrl(webView, str, z);
        } else {
            super.onReceivedTouchIconUrl(webView, str, z);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        if (this.acl != null) {
            this.acl.onShowCustomView(view, customViewCallback);
        } else {
            super.onShowCustomView(view, customViewCallback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        if (this.acl != null) {
            this.acl.onShowCustomView(view, i, customViewCallback);
        } else {
            super.onShowCustomView(view, i, customViewCallback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        if (this.acl != null) {
            this.acl.onHideCustomView();
        } else {
            super.onHideCustomView();
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        return this.acl != null ? this.acl.onCreateWindow(webView, z, z2, message) : super.onCreateWindow(webView, z, z2, message);
    }

    @Override // android.webkit.WebChromeClient
    public void onRequestFocus(WebView webView) {
        if (this.acl != null) {
            this.acl.onRequestFocus(webView);
        } else {
            super.onRequestFocus(webView);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(WebView webView) {
        if (this.acl != null) {
            this.acl.onCloseWindow(webView);
        } else {
            super.onCloseWindow(webView);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return this.acl != null ? this.acl.onJsAlert(webView, str, str2, jsResult) : super.onJsAlert(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return this.acl != null ? this.acl.onJsConfirm(webView, str, str2, jsResult) : super.onJsConfirm(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return this.acl != null ? this.acl.onJsBeforeUnload(webView, str, str2, jsResult) : super.onJsBeforeUnload(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        if (this.acl != null) {
            this.acl.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
        } else {
            super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        if (this.acl != null) {
            this.acl.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
        } else {
            super.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        if (this.acl != null) {
            this.acl.onGeolocationPermissionsShowPrompt(str, callback);
        } else {
            super.onGeolocationPermissionsShowPrompt(str, callback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        if (this.acl != null) {
            this.acl.onGeolocationPermissionsHidePrompt();
        } else {
            super.onGeolocationPermissionsHidePrompt();
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsTimeout() {
        return this.acl != null ? this.acl.onJsTimeout() : super.onJsTimeout();
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public void onConsoleMessage(String str, int i, String str2) {
        if (this.acl != null) {
            this.acl.onConsoleMessage(str, i, str2);
        } else {
            super.onConsoleMessage(str, i, str2);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return this.acl != null ? this.acl.onConsoleMessage(consoleMessage) : super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        return this.acl != null ? this.acl.getDefaultVideoPoster() : super.getDefaultVideoPoster();
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        return this.acl != null ? this.acl.getVideoLoadingProgressView() : super.getVideoLoadingProgressView();
    }

    @Override // android.webkit.WebChromeClient
    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        if (this.acl != null) {
            this.acl.getVisitedHistory(valueCallback);
        } else {
            super.getVisitedHistory(valueCallback);
        }
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        if (this.acl != null) {
            try {
                this.acl.getClass().getDeclaredMethod("openFileChooser", ValueCallback.class).invoke(this.acl, valueCallback);
            } catch (IllegalAccessException e) {
                e.cO(e.getMessage());
            } catch (NoSuchMethodException e2) {
                e.cO(e2.getMessage());
            } catch (InvocationTargetException e3) {
                e.cO(e3.getMessage());
            } catch (Throwable th) {
                e.cO(th.getMessage());
            }
        }
    }

    public void openFileChooser(ValueCallback valueCallback, String str) {
        if (this.acl != null) {
            try {
                this.acl.getClass().getDeclaredMethod("openFileChooser", ValueCallback.class, String.class).invoke(this.acl, valueCallback, str);
            } catch (IllegalAccessException e) {
                e.cO(e.getMessage());
            } catch (NoSuchMethodException e2) {
                e.cO(e2.getMessage());
            } catch (InvocationTargetException e3) {
                e.cO(e3.getMessage());
            } catch (Throwable th) {
                e.cO(th.getMessage());
            }
        }
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        if (this.acl != null) {
            try {
                this.acl.getClass().getDeclaredMethod("openFileChooser", ValueCallback.class, String.class, String.class).invoke(this.acl, valueCallback, str, str2);
            } catch (IllegalAccessException e) {
                e.cO(e.getMessage());
            } catch (NoSuchMethodException e2) {
                e.cO(e2.getMessage());
            } catch (InvocationTargetException e3) {
                e.cO(e3.getMessage());
            } catch (Throwable th) {
                e.cO(th.getMessage());
            }
        }
    }
}
