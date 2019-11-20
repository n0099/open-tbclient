package com.baidu.swan.apps.core;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ClientCertRequest;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.HttpAuthHandler;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.swan.apps.ab.a;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.b.c.e;
import com.baidu.swan.apps.core.container.SystemWebViewImpl;
import com.baidu.swan.apps.core.e.b;
import com.baidu.swan.apps.jsbridge.SwanAppGlobalJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppNativeSwanJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppUtilsJavaScriptInterface;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.w.h;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class b implements TypedCallbackHandler, e<SystemWebViewImpl>, com.baidu.swan.apps.core.container.b, com.baidu.swan.apps.core.container.c, com.baidu.swan.apps.res.ui.pullrefresh.a<SystemWebViewImpl> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected SystemWebViewImpl aIr;
    private WebViewClient aIs;
    private WebChromeClient aIt;
    private com.baidu.swan.apps.core.e.b aIu;
    protected j aIv;
    private SwanAppGlobalJsBridge aIw;
    private SwanAppJsBridge aIx;
    protected SwanAppUtilsJavaScriptInterface aIy;
    private com.baidu.swan.apps.core.c aIz;
    protected Activity mActivity;
    protected Context mContext;
    private UnitedSchemeMainDispatcher mMainDispatcher;
    private String mUserAgent;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private final a aIA = new a();
    private List<com.baidu.swan.apps.core.f.b> aIB = new ArrayList();

    public b(Context context) {
        init(context);
        onCreate();
    }

    @DebugTrace
    private void init(Context context) {
        a(this.aIA);
        aS(context);
        a(context, this);
        DM();
        DN();
        DO();
        initSettings();
        DQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
    }

    private void aS(Context context) {
        this.mContext = context;
        this.aIr = new SystemWebViewImpl(context);
        if (this.aIA.aIF) {
            this.aIr.setBackgroundColor(0);
        }
        this.aIr.setScrollBarStyle(0);
        this.aIr.setLongClickable(true);
        this.aIu = new com.baidu.swan.apps.core.e.b(this.mContext);
        this.aIr.setWebViewClient(new c());
        this.aIr.setWebChromeClient(new C0174b());
        this.aIr.setOverScrollMode(2);
        this.aIr.setOnCommonEventHandler(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.a
    /* renamed from: aT */
    public SystemWebViewImpl aU(Context context) {
        if (this.aIr == null) {
            aS(context);
        }
        return this.aIr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Context context, e eVar) {
        this.aIy = new SwanAppUtilsJavaScriptInterface(context, this.aIr);
        this.aIy.setSource("swan_");
        this.aIy.setForceShareLight(true);
        this.aIr.addJavascriptInterface(this.aIy, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
    }

    private void DM() {
        if (this.mMainDispatcher == null) {
            this.mMainDispatcher = new UnitedSchemeMainDispatcher();
        }
    }

    protected void DN() {
        if (this.mMainDispatcher == null) {
            throw new IllegalStateException("initSwanAppDispatcher() must be called after initDispatcher()");
        }
        this.aIv = com.baidu.swan.apps.scheme.e.a(this.mMainDispatcher);
    }

    private void DO() {
        this.aIr.addJavascriptInterface(new SwanAppNativeSwanJsBridge(), SwanAppNativeSwanJsBridge.JAVASCRIPT_INTERFACE_NAME);
        DP();
    }

    private void DP() {
        this.aIw = new SwanAppGlobalJsBridge(this.mContext, this.mMainDispatcher, this);
        this.aIr.addJavascriptInterface(this.aIw, SwanAppGlobalJsBridge.JAVASCRIPT_INTERFACE_NAME);
        this.aIx = new SwanAppJsBridge(this.mContext, this.mMainDispatcher, this);
        this.aIr.addJavascriptInterface(this.aIx, SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
    }

    @Override // com.baidu.swan.apps.b.c.e
    public void x(Activity activity) {
        if (this.aIw != null) {
            this.aIw.setActivityRef(activity);
        }
        if (this.aIx != null) {
            this.aIx.setActivityRef(activity);
        }
        if (this.aIy != null) {
            this.aIy.setActivity(activity);
        }
        this.mActivity = activity;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void initSettings() {
        WebSettings settings = this.aIr.getSettings();
        settings.setLightTouchEnabled(false);
        settings.setNeedInitialFocus(false);
        settings.setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        settings.setLoadsImagesAutomatically(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        settings.setSupportMultipleWindows(false);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setTextZoom(100);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAppCacheEnabled(true);
        String path = this.mContext.getDir("databases", 0).getPath();
        String path2 = this.mContext.getDir("geolocation", 0).getPath();
        String path3 = this.mContext.getDir("appcache", 0).getPath();
        settings.setGeolocationDatabasePath(path2);
        settings.setDatabasePath(path);
        settings.setAppCachePath(path3);
        String iM = com.baidu.swan.apps.al.a.iM(settings.getUserAgentString());
        if (!TextUtils.equals(iM, this.mUserAgent)) {
            this.mUserAgent = iM;
            settings.setUserAgentString(this.mUserAgent);
            if (DEBUG) {
                Log.i("SwanAppSysWebViewManager", "set ua:" + this.mUserAgent);
            }
        }
        try {
            settings.setPluginState(WebSettings.PluginState.ON_DEMAND);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (NoClassDefFoundError e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void DQ() {
    }

    @Override // com.baidu.swan.apps.b.c.e
    public String Ct() {
        return "ai_apps";
    }

    @Override // com.baidu.swan.apps.b.c.e
    public String getUserAgent() {
        return this.mUserAgent;
    }

    public void loadJavaScript(final String str) {
        ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.b.1
            @Override // java.lang.Runnable
            public void run() {
                String str2 = str;
                if (!str2.startsWith("javascript:")) {
                    str2 = "javascript:" + str2;
                }
                if (b.DEBUG) {
                    Log.d("SwanAppSysWebViewManager", "webview load js:" + str2);
                }
                b.this.aIr.evaluateJavascript(str2, null);
            }
        });
    }

    public boolean isSlidable() {
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.b.c.e
    /* renamed from: DR */
    public SystemWebViewImpl Cs() {
        return this.aIr;
    }

    @Override // com.baidu.swan.apps.b.c.e
    public void loadUrl(String str) {
        this.aIr.loadUrl(str);
    }

    @CallSuper
    public void onCreate() {
        h.a(this);
    }

    @Override // com.baidu.swan.apps.b.c.e
    @CallSuper
    public void onResume() {
        this.aIr.onResume();
        h.b(this);
    }

    @Override // com.baidu.swan.apps.b.c.e
    @CallSuper
    public void onPause() {
        this.aIr.onPause();
        h.c(this);
    }

    @CallSuper
    public void onDestroy() {
        h.d(this);
    }

    public void goBack() {
        this.aIr.goBack();
    }

    @Override // com.baidu.swan.apps.core.container.c
    public void DS() {
    }

    @Override // com.baidu.swan.apps.core.container.c
    public boolean bq(boolean z) {
        return z;
    }

    @Override // com.baidu.swan.apps.b.c.e
    public void destroy() {
        this.mHandler.removeCallbacks(null);
        this.aIr.destroy();
        this.aIB.clear();
        onDestroy();
    }

    @Override // com.baidu.swan.apps.b.c.e
    public void a(com.baidu.swan.apps.core.c cVar) {
        this.aIz = cVar;
    }

    @Override // com.baidu.swan.apps.b.c.e
    public void a(com.baidu.swan.apps.core.f.b bVar) {
        if (bVar != null && !this.aIB.contains(bVar)) {
            this.aIB.add(bVar);
        }
    }

    @Override // com.baidu.swan.apps.b.c.e
    public void b(com.baidu.swan.apps.core.f.b bVar) {
        if (bVar != null && this.aIB.contains(bVar)) {
            this.aIB.remove(bVar);
        }
    }

    @Override // com.baidu.swan.apps.core.container.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.aIr.canGoBack()) {
            goBack();
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.core.container.b
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        if (this.aIB != null) {
            for (com.baidu.swan.apps.core.f.b bVar : this.aIB) {
                if (bVar != null) {
                    bVar.onScrollChanged(i, i2, i3, i4);
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.core.container.b
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.swan.apps.core.container.b
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public final void a(WebViewClient webViewClient) {
        this.aIs = webViewClient;
    }

    public final void a(WebChromeClient webChromeClient) {
        this.aIt = webChromeClient;
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public void handleSchemeDispatchCallback(final String str, final String str2) {
        final String quote;
        if (TextUtils.isEmpty(str2)) {
            quote = "";
        } else {
            quote = JSONObject.quote(str2);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.swan.apps.core.b.2
            @Override // java.lang.Runnable
            public void run() {
                if (b.DEBUG) {
                    Log.d("SwanAppSysWebViewManager", "handleSchemeDispatchCallback callback: " + str);
                    Log.d("SwanAppSysWebViewManager", "handleSchemeDispatchCallback params: " + str2);
                }
                if (b.this.aIr.isDestroyed()) {
                    if (b.DEBUG) {
                        Log.e("SwanAppSysWebViewManager", "handleSchemeDispatchCallback webview is destroyed.");
                        return;
                    }
                    return;
                }
                b.this.aIr.evaluateJavascript("javascript:" + str + "(" + quote + ")", null);
            }
        });
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public String getCurrentPageUrl() {
        return Cs().getUrl();
    }

    @Override // com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends WebViewClient {
        private c() {
        }

        @Override // android.webkit.WebViewClient
        public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            if (b.DEBUG) {
                Log.d("SwanAppSysWebViewManager", "SwanAppWebViewClient::doUpdateVisitedHistory");
            }
            if (b.this.aIs != null) {
                b.this.aIs.doUpdateVisitedHistory(webView, str, z);
            } else {
                super.doUpdateVisitedHistory(webView, str, z);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onFormResubmission(WebView webView, Message message, Message message2) {
            if (b.DEBUG) {
                Log.d("SwanAppSysWebViewManager", "SwanAppWebViewClient::onFormResubmission");
            }
            if (b.this.aIs != null) {
                b.this.aIs.onFormResubmission(webView, message, message2);
            } else {
                super.onFormResubmission(webView, message, message2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            if (b.DEBUG) {
                Log.d("SwanAppSysWebViewManager", "SwanAppWebViewClient::onLoadResource：" + str);
            }
            if (b.this.aIs != null) {
                b.this.aIs.onLoadResource(webView, str);
            } else {
                super.onLoadResource(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            if (b.DEBUG) {
                Log.d("SwanAppSysWebViewManager", "SwanAppWebViewClient::onReceivedLoginRequest");
            }
            if (b.this.aIs != null) {
                b.this.aIs.onReceivedLoginRequest(webView, str, str2, str3);
            } else {
                super.onReceivedLoginRequest(webView, str, str2, str3);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onScaleChanged(WebView webView, float f, float f2) {
            if (b.DEBUG) {
                Log.d("SwanAppSysWebViewManager", "SwanAppWebViewClient::onScaleChanged");
            }
            if (b.this.aIs != null) {
                b.this.aIs.onScaleChanged(webView, f, f2);
            } else {
                super.onScaleChanged(webView, f, f2);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
            if (b.DEBUG) {
                Log.d("SwanAppSysWebViewManager", "SwanAppWebViewClient::onUnhandledKeyEvent");
            }
            if (b.this.aIs != null) {
                b.this.aIs.onUnhandledKeyEvent(webView, keyEvent);
            } else {
                super.onUnhandledKeyEvent(webView, keyEvent);
            }
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            WebResourceResponse shouldInterceptRequest;
            if (b.DEBUG) {
                Log.d("SwanAppSysWebViewManager", "SwanAppWebViewClient::shouldInterceptRequest url: " + str);
            }
            if (b.this.aIs != null) {
                shouldInterceptRequest = b.this.aIs.shouldInterceptRequest(webView, str);
            } else {
                shouldInterceptRequest = super.shouldInterceptRequest(webView, str);
            }
            InputStream inputStream = null;
            if (com.baidu.swan.apps.swancore.b.a.iv(str)) {
                if (b.DEBUG) {
                    Log.d("SwanAppSysWebViewManager", "start create config response stream");
                }
                inputStream = com.baidu.swan.apps.swancore.b.a.SX();
            }
            return inputStream == null ? shouldInterceptRequest : new WebResourceResponse("application/javascript", HTTP.UTF_8, inputStream);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            if (b.DEBUG) {
                Log.d("SwanAppSysWebViewManager", "SwanAppWebViewClient::shouldOverrideKeyEvent");
            }
            if (b.this.aIs == null || !b.this.aIs.shouldOverrideKeyEvent(webView, keyEvent)) {
                return super.shouldOverrideKeyEvent(webView, keyEvent);
            }
            return true;
        }

        @Override // android.webkit.WebViewClient
        @RequiresApi(api = 21)
        public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
            if (b.DEBUG) {
                Log.d("SwanAppSysWebViewManager", "SwanAppWebViewClient::onReceivedClientCertRequest");
            }
            if (b.this.aIs != null) {
                b.this.aIs.onReceivedClientCertRequest(webView, clientCertRequest);
            } else {
                super.onReceivedClientCertRequest(webView, clientCertRequest);
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (b.DEBUG) {
                Log.d("SwanAppSysWebViewManager", "SwanAppWebViewClient::shouldOverrideUrlLoading url: " + str);
            }
            if (b.this.aIs != null) {
                return b.this.aIs.shouldOverrideUrlLoading(webView, str);
            }
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            if (b.DEBUG) {
                Log.d("SwanAppSysWebViewManager", "SwanAppWebViewClient::onPageStarted url: " + str);
            }
            if (b.this.aIs != null) {
                b.this.aIs.onPageStarted(webView, str, bitmap);
            } else {
                super.onPageStarted(webView, str, bitmap);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (b.DEBUG) {
                Log.d("SwanAppSysWebViewManager", "SwanAppWebViewClient::onPageFinished url: " + str);
            }
            if (b.this.aIz != null) {
                b.this.aIz.db(str);
            }
            if (b.this.aIs != null) {
                b.this.aIs.onPageFinished(webView, str);
            } else {
                super.onPageFinished(webView, str);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            if (b.DEBUG) {
                Log.d("SwanAppSysWebViewManager", "SwanAppWebViewClient::onReceivedError errorCode: " + i + " ,failingUrl:" + str2);
            }
            if (b.this.aIs != null) {
                b.this.aIs.onReceivedError(webView, i, str, str2);
            } else {
                super.onReceivedError(webView, i, str, str2);
            }
        }

        @Override // android.webkit.WebViewClient
        @RequiresApi(api = 23)
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            if (b.DEBUG) {
                Log.d("SwanAppSysWebViewManager", "SwanAppWebViewClient::onReceivedError url: " + webResourceRequest.getUrl() + " ,error:" + webResourceError.getErrorCode());
            }
            if (b.this.aIs != null) {
                b.this.aIs.onReceivedError(webView, webResourceRequest, webResourceError);
            } else {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(final WebView webView, final SslErrorHandler sslErrorHandler, final SslError sslError) {
            if (b.DEBUG) {
                Log.d("SwanAppSysWebViewManager", "SwanAppWebViewClient::onReceivedSslError");
            }
            if (b.this.aIr.isShown()) {
                b.this.aIu.a(new b.c() { // from class: com.baidu.swan.apps.core.b.c.1
                    @Override // com.baidu.swan.apps.core.e.b.c
                    public void DU() {
                        sslErrorHandler.proceed();
                    }

                    @Override // com.baidu.swan.apps.core.e.b.c
                    public void DV() {
                        sslErrorHandler.cancel();
                    }

                    @Override // com.baidu.swan.apps.core.e.b.c
                    public void DW() {
                        c.this.onReceivedSslError(webView, sslErrorHandler, sslError);
                    }
                }, sslErrorHandler, sslError);
            } else {
                sslErrorHandler.cancel();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpAuthRequest(final WebView webView, final HttpAuthHandler httpAuthHandler, final String str, final String str2) {
            String str3;
            String[] httpAuthUsernamePassword;
            String str4 = null;
            if (b.DEBUG) {
                Log.d("SwanAppSysWebViewManager", "SwanAppWebViewClient::onReceivedHttpAuthRequest");
            }
            if (!httpAuthHandler.useHttpAuthUsernamePassword() || webView == null || (httpAuthUsernamePassword = webView.getHttpAuthUsernamePassword(str, str2)) == null || httpAuthUsernamePassword.length != 2) {
                str3 = null;
            } else {
                str3 = httpAuthUsernamePassword[0];
                str4 = httpAuthUsernamePassword[1];
            }
            if (str3 != null && str4 != null) {
                if (b.DEBUG) {
                    Log.d("SwanAppSysWebViewManager", "OnReceivedHttpAuthRequest Reuse Http Auth Username & PassWord");
                }
                httpAuthHandler.proceed(str3, str4);
            } else if (b.this.aIr.isShown()) {
                if (b.DEBUG) {
                    Log.d("SwanAppSysWebViewManager", "OnReceivedHttpAuthRequest show Http Auth dialog ");
                }
                b.this.aIu.a(new b.a() { // from class: com.baidu.swan.apps.core.b.c.2
                    @Override // com.baidu.swan.apps.core.e.b.a
                    public void Z(String str5, String str6) {
                        if (webView != null) {
                            webView.setHttpAuthUsernamePassword(str, str2, str5, str6);
                        }
                        httpAuthHandler.proceed(str5, str6);
                    }

                    @Override // com.baidu.swan.apps.core.e.b.a
                    public void DX() {
                        httpAuthHandler.cancel();
                    }
                }, str, str2);
            } else {
                httpAuthHandler.cancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.core.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0174b extends WebChromeClient {
        private C0174b() {
        }

        @Override // android.webkit.WebChromeClient
        public void onHideCustomView() {
            if (b.DEBUG) {
                Log.d("SwanAppSysWebViewManager", "chromeclient::onHideCustomView");
            }
            if (b.this.aIt != null) {
                b.this.aIt.onHideCustomView();
            } else {
                super.onHideCustomView();
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            if (b.DEBUG) {
                Log.d("SwanAppSysWebViewManager", "chromeclient::onShowCustomView");
            }
            if (b.this.aIt != null) {
                b.this.aIt.onShowCustomView(view, customViewCallback);
            } else {
                super.onShowCustomView(view, customViewCallback);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
            if (b.DEBUG) {
                Log.d("SwanAppSysWebViewManager", "chromeclient::onShowCustomView");
            }
            if (b.this.aIt != null) {
                b.this.aIt.onShowCustomView(view, i, customViewCallback);
            } else {
                super.onShowCustomView(view, i, customViewCallback);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onCloseWindow(WebView webView) {
            if (b.DEBUG) {
                Log.d("SwanAppSysWebViewManager", "SwanAppWebChromeClient::onCloseWindow");
            }
            if (b.this.aIt != null) {
                b.this.aIt.onCloseWindow(webView);
            } else {
                super.onCloseWindow(webView);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            if (b.DEBUG) {
                Log.d("SwanAppSysWebViewManager", "SwanAppWebChromeClient::onConsoleMessage");
            }
            if (b.this.aIt == null || !b.this.aIt.onConsoleMessage(consoleMessage)) {
                return super.onConsoleMessage(consoleMessage);
            }
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            if (b.DEBUG) {
                Log.d("SwanAppSysWebViewManager", "SwanAppWebChromeClient::onCreateWindow");
            }
            if (b.this.aIt == null || !b.this.aIt.onCreateWindow(webView, z, z2, message)) {
                return super.onCreateWindow(webView, z, z2, message);
            }
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
            if (b.DEBUG) {
                Log.d("SwanAppSysWebViewManager", "SwanAppWebChromeClient::onExceededDatabaseQuota");
            }
            if (b.this.aIt != null) {
                b.this.aIt.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
            } else {
                super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
            if (b.DEBUG) {
                Log.d("SwanAppSysWebViewManager", "SwanAppWebChromeClient::onJsBeforeUnload：" + str);
            }
            if (b.this.aIt == null || !b.this.aIt.onJsBeforeUnload(webView, str, str2, jsResult)) {
                return super.onJsBeforeUnload(webView, str, str2, jsResult);
            }
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsTimeout() {
            if (b.DEBUG) {
                Log.d("SwanAppSysWebViewManager", "SwanAppWebChromeClient::onJsTimeout  ");
            }
            if (b.this.aIt == null || !b.this.aIt.onJsTimeout()) {
                return super.onJsTimeout();
            }
            return true;
        }

        @Override // android.webkit.WebChromeClient
        public void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
            if (b.DEBUG) {
                Log.d("SwanAppSysWebViewManager", "SwanAppWebChromeClient::onReachedMaxAppCacheSize");
            }
            if (b.this.aIt != null) {
                b.this.aIt.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
            } else {
                super.onReachedMaxAppCacheSize(j, j2, quotaUpdater);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedIcon(WebView webView, Bitmap bitmap) {
            if (b.DEBUG) {
                Log.d("SwanAppSysWebViewManager", "SwanAppWebChromeClient::onReachedMaxAppCacheSize");
            }
            if (b.this.aIt != null) {
                b.this.aIt.onReceivedIcon(webView, bitmap);
            } else {
                super.onReceivedIcon(webView, bitmap);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
            if (b.DEBUG) {
                Log.d("SwanAppSysWebViewManager", "SwanAppWebChromeClient::onReceivedTouchIconUrl");
            }
            if (b.this.aIt != null) {
                b.this.aIt.onReceivedTouchIconUrl(webView, str, z);
            } else {
                super.onReceivedTouchIconUrl(webView, str, z);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onRequestFocus(WebView webView) {
            if (b.DEBUG) {
                Log.d("SwanAppSysWebViewManager", "SwanAppWebChromeClient::onRequestFocus");
            }
            if (b.this.aIt != null) {
                b.this.aIt.onRequestFocus(webView);
            } else {
                super.onRequestFocus(webView);
            }
        }

        @Override // android.webkit.WebChromeClient
        @RequiresApi(api = 21)
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            return b.this.aIt != null ? b.this.aIt.onShowFileChooser(webView, valueCallback, fileChooserParams) : super.onShowFileChooser(webView, valueCallback, fileChooserParams);
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            if (b.this.aIt != null) {
                b.this.aIt.onProgressChanged(webView, i);
            } else {
                super.onProgressChanged(webView, i);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            if (b.DEBUG) {
                Log.d("SwanAppSysWebViewManager", "SwanAppWebChromeClient::onReceivedTitleInFact : " + str);
            }
            if (b.this.aIt != null) {
                b.this.aIt.onReceivedTitle(webView, str);
            } else {
                super.onReceivedTitle(webView, str);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, final JsPromptResult jsPromptResult) {
            if (b.DEBUG) {
                Log.d("SwanAppSysWebViewManager", "SwanAppWebChromeClient::onJsPrompt");
            }
            return b.this.aIu.a(str, str2, str3, new b.InterfaceC0179b() { // from class: com.baidu.swan.apps.core.b.b.1
                @Override // com.baidu.swan.apps.core.e.b.InterfaceC0179b
                public void DT() {
                    jsPromptResult.cancel();
                }

                @Override // com.baidu.swan.apps.core.e.b.InterfaceC0179b
                public void eg(String str4) {
                    jsPromptResult.confirm(str4);
                }

                @Override // com.baidu.swan.apps.core.e.b.InterfaceC0179b
                public void onCancel() {
                    jsPromptResult.cancel();
                }
            });
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
            if (b.DEBUG) {
                Log.d("SwanAppSysWebViewManager", "SwanAppWebChromeClient::onJsAlert");
            }
            return b.this.aIu.a(str, str2, new b.InterfaceC0179b() { // from class: com.baidu.swan.apps.core.b.b.2
                @Override // com.baidu.swan.apps.core.e.b.InterfaceC0179b
                public void DT() {
                    jsResult.cancel();
                }

                @Override // com.baidu.swan.apps.core.e.b.InterfaceC0179b
                public void eg(String str3) {
                    jsResult.confirm();
                }

                @Override // com.baidu.swan.apps.core.e.b.InterfaceC0179b
                public void onCancel() {
                    jsResult.cancel();
                }
            });
        }

        @Override // android.webkit.WebChromeClient
        public boolean onJsConfirm(WebView webView, String str, String str2, final JsResult jsResult) {
            if (b.DEBUG) {
                Log.d("SwanAppSysWebViewManager", "SwanAppWebChromeClient::onJsConfirm");
            }
            return b.this.aIu.b(str, str2, new b.InterfaceC0179b() { // from class: com.baidu.swan.apps.core.b.b.3
                @Override // com.baidu.swan.apps.core.e.b.InterfaceC0179b
                public void DT() {
                    jsResult.cancel();
                }

                @Override // com.baidu.swan.apps.core.e.b.InterfaceC0179b
                public void eg(String str3) {
                    jsResult.confirm();
                }

                @Override // com.baidu.swan.apps.core.e.b.InterfaceC0179b
                public void onCancel() {
                    jsResult.cancel();
                }
            });
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsHidePrompt() {
            if (b.DEBUG) {
                Log.d("SwanAppSysWebViewManager", "SwanAppWebChromeClient::onGeolocationPermissionsHidePrompt");
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(final String str, final GeolocationPermissions.Callback callback) {
            if (b.DEBUG) {
                Log.d("SwanAppSysWebViewManager", "SwanAppWebChromeClient::onGeolocationPermissionsShowPrompt");
            }
            com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
            if (Ra == null || Ra.getActivity() == null) {
                b.this.b(str, callback);
            } else {
                Ra.Rf().a(Ra.getActivity(), "mapp_location", new com.baidu.swan.apps.an.d.a<Boolean>() { // from class: com.baidu.swan.apps.core.b.b.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.an.d.a
                    /* renamed from: b */
                    public void B(Boolean bool) {
                        if (b.DEBUG) {
                            Log.d("SwanAppSysWebViewManager", "SwanAppWebChromeClient::onCallback result: " + bool);
                        }
                        if (bool.booleanValue()) {
                            b.this.c(str, callback);
                        } else {
                            b.this.b(str, callback);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, GeolocationPermissions.Callback callback) {
        if (DEBUG) {
            Log.d("SwanAppSysWebViewManager", "allowGeoLocationOnce origin: " + str);
        }
        callback.invoke(str, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, GeolocationPermissions.Callback callback) {
        if (DEBUG) {
            Log.d("SwanAppSysWebViewManager", "rejectGeoLocationOnce origin: " + str);
        }
        callback.invoke(str, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public void c(final String str, final GeolocationPermissions.Callback callback) {
        if (ac.UC()) {
            a(str, callback);
        } else {
            com.baidu.swan.apps.w.e.LE().a(0, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, new a.InterfaceC0152a() { // from class: com.baidu.swan.apps.core.b.3
                @Override // com.baidu.swan.apps.ab.a.InterfaceC0152a
                public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                    if (i != 0) {
                        if (b.DEBUG) {
                            Log.e("SwanAppSysWebViewManager", "onRequestPermissionsResult requestCode error.");
                        }
                        b.this.b(str, callback);
                        return;
                    }
                    for (int i2 : iArr) {
                        if (i2 == -1) {
                            if (b.DEBUG) {
                                Log.d("SwanAppSysWebViewManager", "onRequestPermissionsResult user reject.");
                            }
                            b.this.b(str, callback);
                            return;
                        }
                    }
                    b.this.a(str, callback);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public class a {
        public boolean aIF = false;

        protected a() {
        }
    }
}
