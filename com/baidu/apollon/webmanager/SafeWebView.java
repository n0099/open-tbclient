package com.baidu.apollon.webmanager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.HttpAuthHandler;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.apollon.ApollonConstants;
import com.baidu.apollon.NoProguard;
/* loaded from: classes.dex */
public class SafeWebView extends WebView {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f4142a = ApollonConstants.DEBUG & true;

    /* renamed from: b  reason: collision with root package name */
    public static final String f4143b = "SafeWebView";

    /* renamed from: c  reason: collision with root package name */
    public volatile b f4144c;

    /* loaded from: classes.dex */
    public static class SafeChromeClient extends WebChromeClient implements NoProguard {

        /* renamed from: a  reason: collision with root package name */
        public boolean f4145a;

        private void a(WebView webView) {
            if (webView instanceof SafeWebView) {
                ((SafeWebView) webView).impactJavascriptInterfaces();
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if (SafeWebView.f4142a) {
                Log.i(SafeWebView.f4143b, "onJsPrompt: " + str);
                Log.i(SafeWebView.f4143b, "msg: " + str2);
                Log.i(SafeWebView.f4143b, "defaultValue" + str3);
            }
            if ((webView instanceof SafeWebView) && ((SafeWebView) webView).jsCallJava(str, str2, str3, jsPromptResult)) {
                return true;
            }
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            if (i2 <= 25) {
                this.f4145a = false;
            } else if (!this.f4145a) {
                a(webView);
                this.f4145a = true;
                if (SafeWebView.f4142a) {
                    Log.d(SafeWebView.f4143b, " inject js interface completely on progress " + i2);
                }
            }
            super.onProgressChanged(webView, i2);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            if (this.f4145a) {
                return;
            }
            this.f4145a = false;
            if (SafeWebView.f4142a) {
                Log.i(SafeWebView.f4143b, "onReceivedTitle: " + str);
            }
            a(webView);
            super.onReceivedTitle(webView, str);
            this.f4145a = true;
        }
    }

    /* loaded from: classes.dex */
    public static class SafeWebViewClient extends WebViewClient implements NoProguard {

        /* renamed from: a  reason: collision with root package name */
        public boolean f4146a;

        private void a(WebView webView) {
            if (webView instanceof SafeWebView) {
                ((SafeWebView) webView).impactJavascriptInterfaces();
            }
        }

        @Override // android.webkit.WebViewClient
        public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            if (this.f4146a) {
                return;
            }
            this.f4146a = false;
            if (SafeWebView.f4142a) {
                Log.i(SafeWebView.f4143b, "doUpdateVisitedHistory: " + str);
            }
            a(webView);
            super.doUpdateVisitedHistory(webView, str, z);
            this.f4146a = true;
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            if (this.f4146a) {
                return;
            }
            this.f4146a = false;
            if (SafeWebView.f4142a) {
                Log.i(SafeWebView.f4143b, "onLoadResource: " + str);
            }
            super.onLoadResource(webView, str);
            this.f4146a = true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (this.f4146a) {
                return;
            }
            this.f4146a = false;
            if (SafeWebView.f4142a) {
                Log.i(SafeWebView.f4143b, "onPageFinished: " + str);
            }
            a(webView);
            super.onPageFinished(webView, str);
            this.f4146a = false;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (this.f4146a) {
                return;
            }
            this.f4146a = false;
            if (SafeWebView.f4142a) {
                Log.i(SafeWebView.f4143b, "onPageStarted: " + str);
            }
            a(webView);
            super.onPageStarted(webView, str, bitmap);
            this.f4146a = true;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            boolean z;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 14 && i2 < 16) {
                try {
                    z = webView.getSettings().getAllowFileAccess();
                } catch (Exception unused) {
                    z = false;
                }
                String lowerCase = str == null ? null : str.toLowerCase();
                if (lowerCase != null && !lowerCase.startsWith("file:///android_asset/") && !lowerCase.startsWith("file:///android_res/") && !z && lowerCase.startsWith("file://")) {
                    return new WebResourceResponse(null, null, null);
                }
            }
            return super.shouldInterceptRequest(webView, str);
        }
    }

    @SuppressLint({"NewApi"})
    public SafeWebView(Context context, AttributeSet attributeSet, int i2, boolean z) {
        super(context, attributeSet, i2, z);
        this.f4144c = null;
        a(context);
    }

    @SuppressLint({"NewApi"})
    private boolean b() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 11 || i2 >= 17) {
            return false;
        }
        super.removeJavascriptInterface("searchBoxJavaBridge_");
        super.removeJavascriptInterface("accessibility");
        super.removeJavascriptInterface("accessibilityTraversal");
        return true;
    }

    @Override // android.webkit.WebView
    public void addJavascriptInterface(Object obj, String str) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.addJavascriptInterface(obj, str);
        } else {
            getJsBridge().a(obj, str);
        }
    }

    public void addJsCode(String str, String str2) {
        getJsBridge().a(str, str2);
    }

    public void clearJsCode() {
        getJsBridge().a();
    }

    @Override // android.webkit.WebView
    public void destroy() {
        getJsBridge().c();
        super.destroy();
    }

    public b getJsBridge() {
        if (this.f4144c == null) {
            synchronized (this) {
                if (this.f4144c == null) {
                    this.f4144c = new b();
                }
            }
        }
        return this.f4144c;
    }

    public void impactJavascriptInterfaces() {
        String b2 = getJsBridge().b();
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                evaluateJavascript(b2.substring(11), null);
            } else {
                super.loadUrl(b2);
            }
        } catch (Throwable unused) {
        }
        if (f4142a) {
            Log.i(f4143b, "impactJavascriptInterfaces done!");
        }
    }

    public boolean jsCallJava(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return getJsBridge().a(str, str2, str3, jsPromptResult);
    }

    @Override // android.webkit.WebView
    @SuppressLint({"NewApi"})
    public void removeJavascriptInterface(String str) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.removeJavascriptInterface(str);
        } else {
            getJsBridge().a(str);
        }
    }

    public void removeJsCode(String str) {
        getJsBridge().b(str);
    }

    @Override // android.webkit.WebView
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        if (webChromeClient != null && !(webChromeClient instanceof SafeChromeClient)) {
            throw new RuntimeException("WebChromeClient must be extended from SecureWebChromeClient!!");
        }
        super.setWebChromeClient(webChromeClient);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        if (webViewClient != null && !(webViewClient instanceof SafeWebViewClient)) {
            throw new RuntimeException("WebViewClient must be extended from SafeWebViewClient!!");
        }
        super.setWebViewClient(webViewClient);
    }

    private void a(Context context) {
        setWebChromeClient(new SafeChromeClient());
        setWebViewClient(new SafeWebViewClient());
        getSettings().setAllowFileAccess(false);
        getSettings().setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT <= 18) {
            getSettings().setSavePassword(false);
        }
        b();
    }

    public SafeWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4144c = null;
        a(context);
    }

    public SafeWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4144c = null;
        a(context);
    }

    public SafeWebView(Context context) {
        super(context);
        this.f4144c = null;
        a(context);
    }
}
