package com.baidu.tbadk.core.hybrid;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
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
import com.baidu.tbadk.browser.TbWebViewActivity;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
public class c extends WebChromeClient {
    private final a aut;
    private WebChromeClient auu;
    private q auv;

    public c() {
        this(null);
    }

    public c(WebChromeClient webChromeClient) {
        this.aut = new a(this);
        this.auu = webChromeClient;
    }

    public void a(q qVar) {
        this.auv = qVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String am(String str, String str2) {
        return this.auv.am(str, str2);
    }

    public void a(WebChromeClient webChromeClient) {
        this.auu = webChromeClient;
    }

    /* loaded from: classes.dex */
    private static final class a {
        private final c auw;

        public a(c cVar) {
            this.auw = cVar;
        }

        public boolean an(String str, String str2) {
            return !TextUtils.isEmpty(str2) && p.eo(str) && str2.startsWith("ctieba://");
        }

        public String ao(String str, String str2) {
            return this.auw.am(str, str2.substring("ctieba://".length()));
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (this.aut.an(str, str2)) {
            jsPromptResult.confirm(this.aut.ao(str, str2));
            return true;
        } else if (this.auu != null) {
            return this.auu.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        } else {
            return true;
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        if (this.auu != null) {
            this.auu.onProgressChanged(webView, i);
        } else {
            super.onProgressChanged(webView, i);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        if (this.auu != null) {
            this.auu.onReceivedTitle(webView, str);
        } else {
            super.onReceivedTitle(webView, str);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        if (this.auu != null) {
            this.auu.onReceivedIcon(webView, bitmap);
        } else {
            super.onReceivedIcon(webView, bitmap);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        if (this.auu != null) {
            this.auu.onReceivedTouchIconUrl(webView, str, z);
        } else {
            super.onReceivedTouchIconUrl(webView, str, z);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        if (this.auu != null) {
            this.auu.onShowCustomView(view, customViewCallback);
        } else {
            super.onShowCustomView(view, customViewCallback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        if (this.auu != null) {
            this.auu.onShowCustomView(view, i, customViewCallback);
        } else {
            super.onShowCustomView(view, i, customViewCallback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        if (this.auu != null) {
            this.auu.onHideCustomView();
        } else {
            super.onHideCustomView();
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        return this.auu != null ? this.auu.onCreateWindow(webView, z, z2, message) : super.onCreateWindow(webView, z, z2, message);
    }

    @Override // android.webkit.WebChromeClient
    public void onRequestFocus(WebView webView) {
        if (this.auu != null) {
            this.auu.onRequestFocus(webView);
        } else {
            super.onRequestFocus(webView);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(WebView webView) {
        if (this.auu != null) {
            this.auu.onCloseWindow(webView);
        } else {
            super.onCloseWindow(webView);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return this.auu != null ? this.auu.onJsAlert(webView, str, str2, jsResult) : super.onJsAlert(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return this.auu != null ? this.auu.onJsConfirm(webView, str, str2, jsResult) : super.onJsConfirm(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return this.auu != null ? this.auu.onJsBeforeUnload(webView, str, str2, jsResult) : super.onJsBeforeUnload(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        if (this.auu != null) {
            this.auu.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
        } else {
            super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        if (this.auu != null) {
            this.auu.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
        } else {
            super.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        if (this.auu != null) {
            this.auu.onGeolocationPermissionsShowPrompt(str, callback);
        } else {
            super.onGeolocationPermissionsShowPrompt(str, callback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        if (this.auu != null) {
            this.auu.onGeolocationPermissionsHidePrompt();
        } else {
            super.onGeolocationPermissionsHidePrompt();
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsTimeout() {
        return this.auu != null ? this.auu.onJsTimeout() : super.onJsTimeout();
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public void onConsoleMessage(String str, int i, String str2) {
        if (this.auu != null) {
            this.auu.onConsoleMessage(str, i, str2);
        } else {
            super.onConsoleMessage(str, i, str2);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return this.auu != null ? this.auu.onConsoleMessage(consoleMessage) : super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        return this.auu != null ? this.auu.getDefaultVideoPoster() : super.getDefaultVideoPoster();
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        return this.auu != null ? this.auu.getVideoLoadingProgressView() : super.getVideoLoadingProgressView();
    }

    @Override // android.webkit.WebChromeClient
    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        if (this.auu != null) {
            this.auu.getVisitedHistory(valueCallback);
        } else {
            super.getVisitedHistory(valueCallback);
        }
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        if (this.auu != null) {
            try {
                this.auu.getClass().getDeclaredMethod("openFileChooser", ValueCallback.class).invoke(this.auu, valueCallback);
            } catch (IllegalAccessException e) {
                e.em(e.getMessage());
            } catch (NoSuchMethodException e2) {
                e.em(e2.getMessage());
            } catch (InvocationTargetException e3) {
                e.em(e3.getMessage());
            } catch (Throwable th) {
                e.em(th.getMessage());
            }
        }
    }

    public void openFileChooser(ValueCallback valueCallback, String str) {
        if (this.auu != null) {
            try {
                this.auu.getClass().getDeclaredMethod("openFileChooser", ValueCallback.class, String.class).invoke(this.auu, valueCallback, str);
            } catch (IllegalAccessException e) {
                e.em(e.getMessage());
            } catch (NoSuchMethodException e2) {
                e.em(e2.getMessage());
            } catch (InvocationTargetException e3) {
                e.em(e3.getMessage());
            } catch (Throwable th) {
                e.em(th.getMessage());
            }
        }
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        if (this.auu != null) {
            try {
                this.auu.getClass().getDeclaredMethod("openFileChooser", ValueCallback.class, String.class, String.class).invoke(this.auu, valueCallback, str, str2);
            } catch (IllegalAccessException e) {
                e.em(e.getMessage());
            } catch (NoSuchMethodException e2) {
                e.em(e2.getMessage());
            } catch (InvocationTargetException e3) {
                e.em(e3.getMessage());
            } catch (Throwable th) {
                e.em(th.getMessage());
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        if (Build.VERSION.SDK_INT >= 21) {
            boolean z = fileChooserParams.getMode() == 1;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            if (z) {
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            }
            intent.setType("image/*");
            if (this.auv == null || !(this.auv.getContext() instanceof TbWebViewActivity)) {
                return true;
            }
            TbWebViewActivity tbWebViewActivity = (TbWebViewActivity) this.auv.getContext();
            tbWebViewActivity.setUploadMessageAboveL(valueCallback);
            tbWebViewActivity.startActivityForResult(Intent.createChooser(intent, "File Chooser"), 1);
            return true;
        }
        return false;
    }
}
