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
    private final a ami;
    private WebChromeClient amj;
    private q amk;

    public c() {
        this(null);
    }

    public c(WebChromeClient webChromeClient) {
        this.ami = new a(this);
        this.amj = webChromeClient;
    }

    public void a(q qVar) {
        this.amk = qVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String T(String str, String str2) {
        return this.amk.T(str, str2);
    }

    public void a(WebChromeClient webChromeClient) {
        this.amj = webChromeClient;
    }

    /* loaded from: classes.dex */
    private static final class a {
        private final c aml;

        public a(c cVar) {
            this.aml = cVar;
        }

        public boolean U(String str, String str2) {
            return !TextUtils.isEmpty(str2) && p.dG(str) && str2.startsWith("ctieba://");
        }

        public String V(String str, String str2) {
            return this.aml.T(str, str2.substring("ctieba://".length()));
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (this.ami.U(str, str2)) {
            jsPromptResult.confirm(this.ami.V(str, str2));
            return true;
        } else if (this.amj != null) {
            return this.amj.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        } else {
            return true;
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        if (this.amj != null) {
            this.amj.onProgressChanged(webView, i);
        } else {
            super.onProgressChanged(webView, i);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView webView, String str) {
        if (this.amj != null) {
            this.amj.onReceivedTitle(webView, str);
        } else {
            super.onReceivedTitle(webView, str);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
        if (this.amj != null) {
            this.amj.onReceivedIcon(webView, bitmap);
        } else {
            super.onReceivedIcon(webView, bitmap);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
        if (this.amj != null) {
            this.amj.onReceivedTouchIconUrl(webView, str, z);
        } else {
            super.onReceivedTouchIconUrl(webView, str, z);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        if (this.amj != null) {
            this.amj.onShowCustomView(view, customViewCallback);
        } else {
            super.onShowCustomView(view, customViewCallback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        if (this.amj != null) {
            this.amj.onShowCustomView(view, i, customViewCallback);
        } else {
            super.onShowCustomView(view, i, customViewCallback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        if (this.amj != null) {
            this.amj.onHideCustomView();
        } else {
            super.onHideCustomView();
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        return this.amj != null ? this.amj.onCreateWindow(webView, z, z2, message) : super.onCreateWindow(webView, z, z2, message);
    }

    @Override // android.webkit.WebChromeClient
    public void onRequestFocus(WebView webView) {
        if (this.amj != null) {
            this.amj.onRequestFocus(webView);
        } else {
            super.onRequestFocus(webView);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(WebView webView) {
        if (this.amj != null) {
            this.amj.onCloseWindow(webView);
        } else {
            super.onCloseWindow(webView);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return this.amj != null ? this.amj.onJsAlert(webView, str, str2, jsResult) : super.onJsAlert(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return this.amj != null ? this.amj.onJsConfirm(webView, str, str2, jsResult) : super.onJsConfirm(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return this.amj != null ? this.amj.onJsBeforeUnload(webView, str, str2, jsResult) : super.onJsBeforeUnload(webView, str, str2, jsResult);
    }

    @Override // android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        if (this.amj != null) {
            this.amj.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
        } else {
            super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        if (this.amj != null) {
            this.amj.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
        } else {
            super.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        if (this.amj != null) {
            this.amj.onGeolocationPermissionsShowPrompt(str, callback);
        } else {
            super.onGeolocationPermissionsShowPrompt(str, callback);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        if (this.amj != null) {
            this.amj.onGeolocationPermissionsHidePrompt();
        } else {
            super.onGeolocationPermissionsHidePrompt();
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsTimeout() {
        return this.amj != null ? this.amj.onJsTimeout() : super.onJsTimeout();
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public void onConsoleMessage(String str, int i, String str2) {
        if (this.amj != null) {
            this.amj.onConsoleMessage(str, i, str2);
        } else {
            super.onConsoleMessage(str, i, str2);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return this.amj != null ? this.amj.onConsoleMessage(consoleMessage) : super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        return this.amj != null ? this.amj.getDefaultVideoPoster() : super.getDefaultVideoPoster();
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        return this.amj != null ? this.amj.getVideoLoadingProgressView() : super.getVideoLoadingProgressView();
    }

    @Override // android.webkit.WebChromeClient
    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        if (this.amj != null) {
            this.amj.getVisitedHistory(valueCallback);
        } else {
            super.getVisitedHistory(valueCallback);
        }
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        if (this.amj != null) {
            try {
                this.amj.getClass().getDeclaredMethod("openFileChooser", ValueCallback.class).invoke(this.amj, valueCallback);
            } catch (IllegalAccessException e) {
                e.dE(e.getMessage());
            } catch (NoSuchMethodException e2) {
                e.dE(e2.getMessage());
            } catch (InvocationTargetException e3) {
                e.dE(e3.getMessage());
            } catch (Throwable th) {
                e.dE(th.getMessage());
            }
        }
    }

    public void openFileChooser(ValueCallback valueCallback, String str) {
        if (this.amj != null) {
            try {
                this.amj.getClass().getDeclaredMethod("openFileChooser", ValueCallback.class, String.class).invoke(this.amj, valueCallback, str);
            } catch (IllegalAccessException e) {
                e.dE(e.getMessage());
            } catch (NoSuchMethodException e2) {
                e.dE(e2.getMessage());
            } catch (InvocationTargetException e3) {
                e.dE(e3.getMessage());
            } catch (Throwable th) {
                e.dE(th.getMessage());
            }
        }
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        if (this.amj != null) {
            try {
                this.amj.getClass().getDeclaredMethod("openFileChooser", ValueCallback.class, String.class, String.class).invoke(this.amj, valueCallback, str, str2);
            } catch (IllegalAccessException e) {
                e.dE(e.getMessage());
            } catch (NoSuchMethodException e2) {
                e.dE(e2.getMessage());
            } catch (InvocationTargetException e3) {
                e.dE(e3.getMessage());
            } catch (Throwable th) {
                e.dE(th.getMessage());
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
            if (this.amk == null || !(this.amk.getContext() instanceof TbWebViewActivity)) {
                return true;
            }
            TbWebViewActivity tbWebViewActivity = (TbWebViewActivity) this.amk.getContext();
            tbWebViewActivity.setUploadMessageAboveL(valueCallback);
            tbWebViewActivity.startActivityForResult(Intent.createChooser(intent, "File Chooser"), 1);
            return true;
        }
        return false;
    }
}
