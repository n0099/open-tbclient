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
    public static final boolean f4046a = ApollonConstants.DEBUG & true;

    /* renamed from: b  reason: collision with root package name */
    public static final String f4047b = "SafeWebView";

    /* renamed from: c  reason: collision with root package name */
    public volatile b f4048c;

    /* loaded from: classes.dex */
    public static class SafeChromeClient extends WebChromeClient implements NoProguard {

        /* renamed from: a  reason: collision with root package name */
        public boolean f4049a;

        private void a(WebView webView) {
            if (webView instanceof SafeWebView) {
                ((SafeWebView) webView).impactJavascriptInterfaces();
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if (SafeWebView.f4046a) {
                Log.i(SafeWebView.f4047b, "onJsPrompt: " + str);
                Log.i(SafeWebView.f4047b, "msg: " + str2);
                Log.i(SafeWebView.f4047b, "defaultValue" + str3);
            }
            if ((webView instanceof SafeWebView) && ((SafeWebView) webView).jsCallJava(str, str2, str3, jsPromptResult)) {
                return true;
            }
            return super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            if (i <= 25) {
                this.f4049a = false;
            } else if (!this.f4049a) {
                a(webView);
                this.f4049a = true;
                if (SafeWebView.f4046a) {
                    Log.d(SafeWebView.f4047b, " inject js interface completely on progress " + i);
                }
            }
            super.onProgressChanged(webView, i);
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            if (this.f4049a) {
                return;
            }
            this.f4049a = false;
            if (SafeWebView.f4046a) {
                Log.i(SafeWebView.f4047b, "onReceivedTitle: " + str);
            }
            a(webView);
            super.onReceivedTitle(webView, str);
            this.f4049a = true;
        }
    }

    /* loaded from: classes.dex */
    public static class SafeWebViewClient extends WebViewClient implements NoProguard {

        /* renamed from: a  reason: collision with root package name */
        public boolean f4050a;

        private void a(WebView webView) {
            if (webView instanceof SafeWebView) {
                ((SafeWebView) webView).impactJavascriptInterfaces();
            }
        }

        @Override // android.webkit.WebViewClient
        public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            if (this.f4050a) {
                return;
            }
            this.f4050a = false;
            if (SafeWebView.f4046a) {
                Log.i(SafeWebView.f4047b, "doUpdateVisitedHistory: " + str);
            }
            a(webView);
            super.doUpdateVisitedHistory(webView, str, z);
            this.f4050a = true;
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            if (this.f4050a) {
                return;
            }
            this.f4050a = false;
            if (SafeWebView.f4046a) {
                Log.i(SafeWebView.f4047b, "onLoadResource: " + str);
            }
            super.onLoadResource(webView, str);
            this.f4050a = true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (this.f4050a) {
                return;
            }
            this.f4050a = false;
            if (SafeWebView.f4046a) {
                Log.i(SafeWebView.f4047b, "onPageFinished: " + str);
            }
            a(webView);
            super.onPageFinished(webView, str);
            this.f4050a = false;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (this.f4050a) {
                return;
            }
            this.f4050a = false;
            if (SafeWebView.f4046a) {
                Log.i(SafeWebView.f4047b, "onPageStarted: " + str);
            }
            a(webView);
            super.onPageStarted(webView, str, bitmap);
            this.f4050a = true;
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        }

        @Override // android.webkit.WebViewClient
        @SuppressLint({"NewApi"})
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            boolean z;
            int i = Build.VERSION.SDK_INT;
            if (i >= 14 && i < 16) {
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
    public SafeWebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet, i, z);
        this.f4048c = null;
        a(context);
    }

    @SuppressLint({"NewApi"})
    private boolean b() {
        int i = Build.VERSION.SDK_INT;
        if (i < 11 || i >= 17) {
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
        if (this.f4048c == null) {
            synchronized (this) {
                if (this.f4048c == null) {
                    this.f4048c = new b();
                }
            }
        }
        return this.f4048c;
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
        if (f4046a) {
            Log.i(f4047b, "impactJavascriptInterfaces done!");
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

    public SafeWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4048c = null;
        a(context);
    }

    public SafeWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4048c = null;
        a(context);
    }

    public SafeWebView(Context context) {
        super(context);
        this.f4048c = null;
        a(context);
    }
}
