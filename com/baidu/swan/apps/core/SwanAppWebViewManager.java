package com.baidu.swan.apps.core;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.widget.AbsoluteLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.browser.sailor.BdSailor;
import com.baidu.browser.sailor.BdSailorConfig;
import com.baidu.browser.sailor.BdSailorWebChromeClient;
import com.baidu.browser.sailor.BdSailorWebChromeClientExt;
import com.baidu.browser.sailor.BdSailorWebSettings;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.BdSailorWebViewClient;
import com.baidu.browser.sailor.BdSailorWebViewClientExt;
import com.baidu.browser.sailor.ISailorWebSettingsExt;
import com.baidu.browser.sailor.ISailorWebViewExt;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.core.b.a;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.core.container.view.SwanAppSelectPopView;
import com.baidu.swan.apps.core.e.b;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
import com.baidu.swan.apps.v.i;
import com.baidu.webkit.sdk.ClientCertRequest;
import com.baidu.webkit.sdk.GeolocationPermissions;
import com.baidu.webkit.sdk.HttpAuthHandler;
import com.baidu.webkit.sdk.JsPromptResult;
import com.baidu.webkit.sdk.JsResult;
import com.baidu.webkit.sdk.WebChromeClient;
import com.baidu.webkit.sdk.WebResourceRequest;
import com.baidu.webkit.sdk.WebResourceResponse;
import com.baidu.webkit.sdk.WebSettings;
import com.baidu.webkit.sdk.WebStorage;
import com.baidu.webkit.sdk.WebView;
import com.baidu.webkit.sdk.WebViewClient;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class SwanAppWebViewManager implements com.baidu.swan.apps.adaptation.b.e<NgWebView>, com.baidu.swan.apps.core.container.b, com.baidu.swan.apps.core.container.c, SwanAppSelectPopView.a, com.baidu.swan.apps.res.ui.pullrefresh.a<NgWebView> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected MutableContextWrapper cND;
    protected NgWebView cNE;
    private BdSailorWebViewClient cNF;
    private BdSailorWebViewClientExt cNG;
    private BdSailorWebChromeClient cNH;
    private com.baidu.swan.apps.core.e.b cNI;
    protected j cNJ;
    private g cNK;
    private com.baidu.swan.apps.inlinewidget.e.b cNQ;
    private String cNR;
    private String cNS;
    private UnitedSchemeMainDispatcher mMainDispatcher;
    private String mUserAgent;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private final a cNL = new a();
    private List<com.baidu.swan.apps.core.f.c> cNM = new ArrayList();
    private boolean cNN = false;
    private Drawable cNO = null;
    private Drawable cNP = null;
    private int cNT = -1;
    private com.baidu.swan.apps.jsbridge.a.a cNU = new com.baidu.swan.apps.jsbridge.a.a();

    @Override // com.baidu.swan.apps.adaptation.b.e
    public abstract String aiA();

    protected abstract void amW();

    static {
        com.baidu.swan.games.utils.so.d.aYM();
        V8Engine.getInstance(0L);
    }

    public SwanAppWebViewManager(Context context) {
        this.cND = new MutableContextWrapper(context);
        com.baidu.swan.apps.core.container.a.a.anA().anB();
        init();
        onCreate();
    }

    @DebugTrace
    private void init() {
        a(this.cNL);
        amT();
        a(this);
        amU();
        amV();
        amX();
        initSettings();
        amZ();
        amW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
    }

    private void amT() {
        if (com.baidu.swan.apps.t.a.awB().agB()) {
            this.cNE = new NgWebView(this.cND);
        } else {
            this.cNE = new NgWebView(this.cND.getBaseContext());
        }
        if (this.cNE.getCurrentWebView() != null) {
            this.cNO = this.cNE.getCurrentWebView().getBackground();
            AbsoluteLayout webViewImpl = this.cNE.getWebViewImpl();
            if (webViewImpl != null) {
                this.cNP = webViewImpl.getBackground();
            }
        }
        if (this.cNL.cNX) {
            this.cNE.setBackgroundColorForSwanApp(0);
            if (!BdZeusUtil.isWebkitLoaded()) {
                this.cNN = true;
            }
        }
        this.cNE.setScrollBarStyle(0);
        this.cNI = new com.baidu.swan.apps.core.e.b(this.cND.getBaseContext());
        if (DEBUG) {
            Log.d("SwanAppWebViewManager", "WebViewManager " + hashCode() + " initializing Clients");
        }
        this.cNE.setWebViewClient(new SwanAppWebViewClient());
        this.cNE.setWebViewClientExt(new SwanAppWebViewClientExt());
        this.cNE.setWebChromeClient(new SwanAppWebChromeClient());
        this.cNE.setWebChromeClientExt(new SwanAppWebChromeClientExt());
        this.cNE.setOverScrollMode(2);
        this.cNE.setOnCommonEventHandler(this);
        this.cNE.setWebViewManager(this);
        this.cNE.getCurrentWebView().setLongClickable(true);
        this.cNE.setSelectPopWindowListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.a
    /* renamed from: cI */
    public NgWebView cJ(Context context) {
        this.cND.setBaseContext(context);
        if (this.cNE == null) {
            amT();
        }
        return this.cNE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SwanAppWebViewManager swanAppWebViewManager) {
        this.cNU.a(this.cND.getBaseContext(), this.cNE);
    }

    private void amU() {
        if (this.mMainDispatcher == null) {
            this.mMainDispatcher = new UnitedSchemeMainDispatcher();
        }
    }

    protected void amV() {
        if (this.mMainDispatcher == null) {
            throw new IllegalStateException("initSwanAppDispatcher() must be called after initDispatcher()");
        }
        this.cNJ = com.baidu.swan.apps.scheme.e.a(this.mMainDispatcher);
    }

    protected void amX() {
        this.cNU.a(this.cNE, this.cND.getBaseContext(), this, this.mMainDispatcher);
    }

    @Override // com.baidu.swan.apps.adaptation.b.e
    public void attachActivity(Activity activity) {
        if (DEBUG) {
            Log.i("SwanAppWebViewManager", "attachActivity");
        }
        if (activity == null) {
            if (DEBUG) {
                Log.e("SwanAppWebViewManager", "attachActivity null");
                return;
            }
            return;
        }
        this.cNU.E(activity);
        this.cND.setBaseContext(activity);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void initSettings() {
        BdSailorWebSettings settings = this.cNE.getSettings();
        ISailorWebSettingsExt settingsExt = this.cNE.getSettingsExt();
        settings.setWebViewFrameNameSailor(aiz());
        settings.setLightTouchEnabled(false);
        settings.setNeedInitialFocus(false);
        settings.setJavaScriptEnabled(true);
        settings.setMixedContentMode(0);
        settings.setZeusMutedEnable(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        settings.setSupportMultipleWindows(false);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setTextZoom(100);
        settingsExt.setPlayVideoInFullScreenModeExt(false);
        settingsExt.setUserSelectEnabled(true);
        BdSailor.getInstance().enableFeature(BdSailorConfig.SAILOR_BASE_GEO);
        BdSailor.getInstance().enableFeature(BdSailorConfig.SAILOR_EXT_ADBLOCK);
        BdSailor.getInstance().disableFeature(BdSailorConfig.SAILOR_BASE_SSL);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAppCacheEnabled(true);
        String path = this.cND.getDir(NgWebView.APP_DATABASE_PATH, 0).getPath();
        String path2 = this.cND.getDir(NgWebView.APP_GEO_PATH, 0).getPath();
        String path3 = this.cND.getDir(NgWebView.APP_CACHE_PATH, 0).getPath();
        settings.setGeolocationDatabasePath(path2);
        settings.setDatabasePath(path);
        settings.setAppCachePath(path3);
        if (((ActivityManager) this.cND.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getMemoryClass() > 16) {
            settings.setPageCacheCapacity(5);
        } else {
            settings.setPageCacheCapacity(1);
        }
        this.cNR = settings.getUserAgentString();
        lR(this.cNS);
        try {
            settings.setPluginState(WebSettings.PluginState.ON_DEMAND);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (NoClassDefFoundError e2) {
            e2.printStackTrace();
        }
    }

    public void lR(String str) {
        this.cNS = str;
        BdSailorWebSettings settings = this.cNE.getSettings();
        String str2 = this.cNR;
        if (!TextUtils.isEmpty(str)) {
            str2 = String.format("%s %s", str2, str);
        }
        String tp = com.baidu.swan.apps.am.a.tp(str2);
        if (!TextUtils.equals(tp, this.mUserAgent)) {
            this.mUserAgent = tp;
            settings.setUserAgentString(this.mUserAgent);
            if (DEBUG) {
                Log.i("SwanAppWebViewManager", "set ua:" + this.mUserAgent);
            }
        }
    }

    @Override // com.baidu.swan.apps.core.container.view.SwanAppSelectPopView.a
    public void doSelectionCopy(String str) {
        doSelectionCancel();
        com.baidu.swan.apps.t.a.axu().p(str, this.cND.getBaseContext());
    }

    @Override // com.baidu.swan.apps.core.container.view.SwanAppSelectPopView.a
    public void doSelectionSearch(String str) {
        doSelectionCancel();
        com.baidu.swan.apps.t.a.axu().q(str, this.cND.getBaseContext());
    }

    public void doSelectionCancel() {
        com.baidu.swan.apps.t.a.axu().a(this.cNE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amY() {
        ISailorWebViewExt webViewExt = this.cNE.getWebViewExt();
        if (webViewExt != null) {
            webViewExt.emulateShiftHeldOnNormalTextExt();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void amZ() {
    }

    @Override // com.baidu.swan.apps.adaptation.b.e
    public String aiz() {
        return "ai_apps";
    }

    @Override // com.baidu.swan.apps.adaptation.b.e
    public String getUserAgent() {
        return this.mUserAgent;
    }

    public void loadJavaScript(final String str) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.SwanAppWebViewManager.1
            @Override // java.lang.Runnable
            public void run() {
                String str2 = str;
                if (!str2.startsWith("javascript:")) {
                    str2 = "javascript:" + str2;
                }
                if (SwanAppWebViewManager.DEBUG) {
                    Log.d("SwanAppWebViewManager", "webview load js:" + str2);
                }
                SwanAppWebViewManager.this.cNE.evaluateJavascript(str2, null);
            }
        });
    }

    public boolean isSlidable(MotionEvent motionEvent) {
        if (this.cNE != null) {
            return this.cNE.isSlidable(motionEvent);
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.adaptation.b.e
    /* renamed from: ana */
    public NgWebView aiy() {
        return this.cNE;
    }

    @Override // com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        lS(str);
        this.cNE.loadUrl(str);
    }

    private void lS(String str) {
        if (a.b.fZ(0) && !TextUtils.isEmpty(str)) {
            String path = Uri.parse(str).getPath();
            if (DEBUG) {
                Log.d("SwanAppWebViewManager", "pathList item: " + str + " ,folder: " + path + " ,parent: " + new File(path).getParent());
            }
            if (!TextUtils.isEmpty(path)) {
                this.cNE.getSettings().setCodeCacheSetting(com.baidu.swan.apps.core.b.b.bx("appframe", new File(path).getParent()));
            }
        }
    }

    @CallSuper
    public void onCreate() {
        i.a(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.e
    @CallSuper
    public void onResume() {
        this.cNE.onResume();
        i.b(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.e
    @CallSuper
    public void onPause() {
        this.cNE.onPause();
        i.c(this);
    }

    @CallSuper
    public void onDestroy() {
        this.cNS = null;
        i.d(this);
    }

    public void goBack() {
        this.cNE.goBack();
    }

    @Override // com.baidu.swan.apps.core.container.c
    public boolean anb() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.container.c
    public boolean fa(boolean z) {
        return z;
    }

    @Override // com.baidu.swan.apps.adaptation.b.e
    @UiThread
    public void aiC() {
        this.cNE.onPause();
        this.cNE.pauseTimers();
    }

    @Override // com.baidu.swan.apps.adaptation.b.e
    @UiThread
    public void aiD() {
        this.cNE.onResume();
        this.cNE.resumeTimers();
    }

    @Override // com.baidu.swan.apps.adaptation.b.e
    public void aiB() {
    }

    @Override // com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        this.mHandler.removeCallbacks(null);
        this.cNE.destroy();
        this.cNM.clear();
        onDestroy();
    }

    @Override // com.baidu.swan.apps.adaptation.b.e
    public void a(g gVar) {
        this.cNK = gVar;
    }

    @Override // com.baidu.swan.apps.adaptation.b.e
    public void a(com.baidu.swan.apps.core.f.c cVar) {
        if (cVar != null && !this.cNM.contains(cVar)) {
            this.cNM.add(cVar);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.e
    public void b(com.baidu.swan.apps.core.f.c cVar) {
        if (cVar != null && this.cNM.contains(cVar)) {
            this.cNM.remove(cVar);
        }
    }

    @Override // com.baidu.swan.apps.core.container.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.cNE.canGoBack()) {
            goBack();
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.core.container.b
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        if (this.cNM != null) {
            for (com.baidu.swan.apps.core.f.c cVar : this.cNM) {
                if (cVar != null) {
                    cVar.onScrollChanged(i, i2, i3, i4);
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

    public void gz(int i) {
        this.cNT = i;
        if (DEBUG) {
            Log.d("SwanAppWebViewManager", "CustomView orientation has been set to [" + this.cNT + "] for once");
        }
    }

    public final void a(BdSailorWebViewClient bdSailorWebViewClient) {
        this.cNF = bdSailorWebViewClient;
    }

    public final void a(BdSailorWebViewClientExt bdSailorWebViewClientExt) {
        this.cNG = bdSailorWebViewClientExt;
    }

    public final void a(BdSailorWebChromeClient bdSailorWebChromeClient) {
        this.cNH = bdSailorWebChromeClient;
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public void handleSchemeDispatchCallback(final String str, final String str2) {
        final String quote;
        if (TextUtils.isEmpty(str2)) {
            quote = "";
        } else {
            quote = JSONObject.quote(str2);
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.swan.apps.core.SwanAppWebViewManager.2
            @Override // java.lang.Runnable
            public void run() {
                if (SwanAppWebViewManager.DEBUG) {
                    Log.d("SwanAppWebViewManager", "handleSchemeDispatchCallback callback: " + str);
                    Log.d("SwanAppWebViewManager", "handleSchemeDispatchCallback params: " + str2);
                }
                if (SwanAppWebViewManager.this.cNE.isDestroyed()) {
                    if (SwanAppWebViewManager.DEBUG) {
                        Log.e("SwanAppWebViewManager", "handleSchemeDispatchCallback webview is destroyed.");
                        return;
                    }
                    return;
                }
                SwanAppWebViewManager.this.cNE.evaluateJavascript("javascript:" + str + "(" + quote + ")", null);
            }
        });
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public String getCurrentPageUrl() {
        return aiy().getUrl();
    }

    @Override // com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        return 0;
    }

    @Nullable
    public synchronized com.baidu.swan.apps.inlinewidget.e.b anc() {
        SwanAppActivity aIl;
        com.baidu.swan.apps.inlinewidget.e.b bVar = null;
        synchronized (this) {
            if (this.cNQ == null) {
                if (com.baidu.swan.apps.runtime.d.aIn().aIj().available() && (aIl = com.baidu.swan.apps.runtime.d.aIn().aIl()) != null) {
                    this.cNQ = new com.baidu.swan.apps.inlinewidget.e.b(aIl, aiA());
                }
            }
            bVar = this.cNQ;
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class SwanAppWebViewClient extends BdSailorWebViewClient {
        private SwanAppWebViewClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void doUpdateVisitedHistory(BdSailorWebView bdSailorWebView, String str, boolean z) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::doUpdateVisitedHistory");
            }
            if (SwanAppWebViewManager.this.cNF != null) {
                SwanAppWebViewManager.this.cNF.doUpdateVisitedHistory(bdSailorWebView, str, z);
            } else {
                super.doUpdateVisitedHistory(bdSailorWebView, str, z);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onFormResubmission(BdSailorWebView bdSailorWebView, Message message, Message message2) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFormResubmission");
            }
            if (SwanAppWebViewManager.this.cNF != null) {
                SwanAppWebViewManager.this.cNF.onFormResubmission(bdSailorWebView, message, message2);
            } else {
                super.onFormResubmission(bdSailorWebView, message, message2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onLoadResource(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onLoadResource：" + str);
            }
            if (SwanAppWebViewManager.this.cNF != null) {
                SwanAppWebViewManager.this.cNF.onLoadResource(bdSailorWebView, str);
            } else {
                super.onLoadResource(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedLoginRequest(BdSailorWebView bdSailorWebView, String str, String str2, String str3) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedLoginRequest");
            }
            if (SwanAppWebViewManager.this.cNF != null) {
                SwanAppWebViewManager.this.cNF.onReceivedLoginRequest(bdSailorWebView, str, str2, str3);
            } else {
                super.onReceivedLoginRequest(bdSailorWebView, str, str2, str3);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onScaleChanged(BdSailorWebView bdSailorWebView, float f, float f2) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onScaleChanged");
            }
            if (SwanAppWebViewManager.this.cNF != null) {
                SwanAppWebViewManager.this.cNF.onScaleChanged(bdSailorWebView, f, f2);
            } else {
                super.onScaleChanged(bdSailorWebView, f, f2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onUnhandledKeyEvent(BdSailorWebView bdSailorWebView, KeyEvent keyEvent) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onUnhandledKeyEvent");
            }
            if (SwanAppWebViewManager.this.cNF != null) {
                SwanAppWebViewManager.this.cNF.onUnhandledKeyEvent(bdSailorWebView, keyEvent);
            } else {
                super.onUnhandledKeyEvent(bdSailorWebView, keyEvent);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public WebResourceResponse shouldInterceptRequest(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::shouldInterceptRequest url: " + str);
            }
            if (SwanAppWebViewManager.this.cNF != null) {
                return SwanAppWebViewManager.this.cNF.shouldInterceptRequest(bdSailorWebView, str);
            }
            return super.shouldInterceptRequest(bdSailorWebView, str);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideKeyEvent(BdSailorWebView bdSailorWebView, KeyEvent keyEvent) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::shouldOverrideKeyEvent");
            }
            if (SwanAppWebViewManager.this.cNF == null || !SwanAppWebViewManager.this.cNF.shouldOverrideKeyEvent(bdSailorWebView, keyEvent)) {
                return super.shouldOverrideKeyEvent(bdSailorWebView, keyEvent);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedClientCertRequest(BdSailorWebView bdSailorWebView, ClientCertRequest clientCertRequest) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedClientCertRequest");
            }
            if (SwanAppWebViewManager.this.cNF != null) {
                SwanAppWebViewManager.this.cNF.onReceivedClientCertRequest(bdSailorWebView, clientCertRequest);
            } else {
                super.onReceivedClientCertRequest(bdSailorWebView, clientCertRequest);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::shouldOverrideUrlLoading url: " + str);
            }
            if (SwanAppWebViewManager.this.cNF != null) {
                return SwanAppWebViewManager.this.cNF.shouldOverrideUrlLoading(bdSailorWebView, str);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageStarted(BdSailorWebView bdSailorWebView, String str, Bitmap bitmap) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onPageStarted url: " + str);
            }
            if (SwanAppWebViewManager.this.cNF != null) {
                SwanAppWebViewManager.this.cNF.onPageStarted(bdSailorWebView, str, bitmap);
            } else {
                super.onPageStarted(bdSailorWebView, str, bitmap);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onPageFinished url: " + str);
            }
            if (SwanAppWebViewManager.this.cNN) {
                WebView currentWebView = SwanAppWebViewManager.this.cNE.getCurrentWebView();
                if (currentWebView != null) {
                    currentWebView.setBackground(SwanAppWebViewManager.this.cNO);
                    SwanAppWebViewManager.this.cNN = false;
                }
                AbsoluteLayout webViewImpl = SwanAppWebViewManager.this.cNE.getWebViewImpl();
                if (webViewImpl != null) {
                    webViewImpl.setBackground(SwanAppWebViewManager.this.cNP);
                }
            }
            if (SwanAppWebViewManager.this.cNK != null) {
                SwanAppWebViewManager.this.cNK.gV(str);
            }
            if (SwanAppWebViewManager.this.cNF != null) {
                SwanAppWebViewManager.this.cNF.onPageFinished(bdSailorWebView, str);
            } else {
                super.onPageFinished(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedError errorCode: " + i + " ,failingUrl: " + str2);
            }
            if (SwanAppWebViewManager.this.cNF != null) {
                SwanAppWebViewManager.this.cNF.onReceivedError(bdSailorWebView, i, str, str2);
            } else {
                super.onReceivedError(bdSailorWebView, i, str, str2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedHttpError(BdSailorWebView bdSailorWebView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            if (SwanAppWebViewManager.this.cNF != null) {
                SwanAppWebViewManager.this.cNF.onReceivedHttpError(bdSailorWebView, webResourceRequest, webResourceResponse);
            } else {
                super.onReceivedHttpError(bdSailorWebView, webResourceRequest, webResourceResponse);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedSslError(final BdSailorWebView bdSailorWebView, final SslErrorHandler sslErrorHandler, final SslError sslError) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedSslError");
            }
            if (SwanAppWebViewManager.this.cNE.isShown()) {
                SwanAppWebViewManager.this.cNI.a(new b.c() { // from class: com.baidu.swan.apps.core.SwanAppWebViewManager.SwanAppWebViewClient.1
                    @Override // com.baidu.swan.apps.core.e.b.c
                    public void ane() {
                        sslErrorHandler.proceed();
                    }

                    @Override // com.baidu.swan.apps.core.e.b.c
                    public void anf() {
                        sslErrorHandler.cancel();
                    }

                    @Override // com.baidu.swan.apps.core.e.b.c
                    public void ang() {
                        SwanAppWebViewClient.this.onReceivedSslError(bdSailorWebView, sslErrorHandler, sslError);
                    }
                }, sslErrorHandler, sslError);
            } else {
                sslErrorHandler.cancel();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedHttpAuthRequest(final BdSailorWebView bdSailorWebView, final HttpAuthHandler httpAuthHandler, final String str, final String str2) {
            String str3;
            String str4;
            String[] httpAuthUsernamePassword;
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedHttpAuthRequest");
            }
            if (!httpAuthHandler.useHttpAuthUsernamePassword() || bdSailorWebView == null || (httpAuthUsernamePassword = bdSailorWebView.getHttpAuthUsernamePassword(str, str2)) == null || httpAuthUsernamePassword.length != 2) {
                str3 = null;
                str4 = null;
            } else {
                String str5 = httpAuthUsernamePassword[0];
                str3 = httpAuthUsernamePassword[1];
                str4 = str5;
            }
            if (str4 != null && str3 != null) {
                if (SwanAppWebViewManager.DEBUG) {
                    Log.d("SwanAppWebViewManager", "OnReceivedHttpAuthRequest Reuse Http Auth Username & PassWord");
                }
                httpAuthHandler.proceed(str4, str3);
            } else if (SwanAppWebViewManager.this.cNE.isShown()) {
                if (SwanAppWebViewManager.DEBUG) {
                    Log.d("SwanAppWebViewManager", "OnReceivedHttpAuthRequest show Http Auth dialog ");
                }
                SwanAppWebViewManager.this.cNI.a(new b.a() { // from class: com.baidu.swan.apps.core.SwanAppWebViewManager.SwanAppWebViewClient.2
                    @Override // com.baidu.swan.apps.core.e.b.a
                    public void bu(String str6, String str7) {
                        if (bdSailorWebView != null) {
                            bdSailorWebView.setHttpAuthUsernamePassword(str, str2, str6, str7);
                        }
                        httpAuthHandler.proceed(str6, str7);
                    }

                    @Override // com.baidu.swan.apps.core.e.b.a
                    public void anh() {
                        httpAuthHandler.cancel();
                    }
                }, str, str2);
            } else {
                httpAuthHandler.cancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class SwanAppWebViewClientExt extends BdSailorWebViewClientExt {
        private SwanAppWebViewClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.this.cNG != null) {
                SwanAppWebViewManager.this.cNG.onFirstLayoutDidExt(bdSailorWebView, str);
            } else {
                super.onFirstLayoutDidExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFullScreenModeExt(BdSailorWebView bdSailorWebView, boolean z, int i, int i2) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFullScreenModeEx");
            }
            if (SwanAppWebViewManager.this.cNG != null) {
                SwanAppWebViewManager.this.cNG.onFullScreenModeExt(bdSailorWebView, z, i, i2);
            } else {
                super.onFullScreenModeExt(bdSailorWebView, z, i, i2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPreloadUrlFoundExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onPreloadUrlFoundEx：" + str);
            }
            if (SwanAppWebViewManager.this.cNG != null) {
                SwanAppWebViewManager.this.cNG.onPreloadUrlFoundExt(bdSailorWebView, str);
            } else {
                super.onPreloadUrlFoundExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageCanBeScaledExt(BdSailorWebView bdSailorWebView, boolean z) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onPageCanBeScaledEx");
            }
            if (SwanAppWebViewManager.this.cNG != null) {
                SwanAppWebViewManager.this.cNG.onPageCanBeScaledExt(bdSailorWebView, z);
            } else {
                super.onPageCanBeScaledExt(bdSailorWebView, z);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstPaintDidEx");
            }
            if (SwanAppWebViewManager.this.cNG != null) {
                SwanAppWebViewManager.this.cNG.onFirstPaintDidExt(bdSailorWebView, str);
            } else {
                super.onFirstPaintDidExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstScreenPaintFinishedEx");
            }
            if (SwanAppWebViewManager.this.cNG != null) {
                SwanAppWebViewManager.this.cNG.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            } else {
                super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageBackOrForwardExt(BdSailorWebView bdSailorWebView, int i) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onGoBackOrForwardEx");
            }
            if (SwanAppWebViewManager.this.cNG != null) {
                SwanAppWebViewManager.this.cNG.onPageBackOrForwardExt(bdSailorWebView, i);
            } else {
                super.onPageBackOrForwardExt(bdSailorWebView, i);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean shouldHandleImageExt(BdSailorWebView bdSailorWebView, String str, String str2, String str3, boolean z) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::canHandleImageEx");
            }
            if (SwanAppWebViewManager.this.cNG == null || !SwanAppWebViewManager.this.cNG.shouldHandleImageExt(bdSailorWebView, str, str2, str3, z)) {
                return super.shouldHandleImageExt(bdSailorWebView, str, str2, str3, z);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onSecurityCheckResultExt(BdSailorWebView bdSailorWebView, String str, WebViewClient.SecurityInfo securityInfo) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onSecurityCheckResultEx");
            }
            if (SwanAppWebViewManager.this.cNG != null) {
                SwanAppWebViewManager.this.cNG.onSecurityCheckResultExt(bdSailorWebView, str, securityInfo);
            } else {
                super.onSecurityCheckResultExt(bdSailorWebView, str, securityInfo);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onKeywordExtensionExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onKeywordExtensionEx");
            }
            return SwanAppWebViewManager.this.cNG != null ? SwanAppWebViewManager.this.cNG.onKeywordExtensionExt(bdSailorWebView, str, str2) : super.onKeywordExtensionExt(bdSailorWebView, str, str2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public String onGetErrorHtmlExt(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onGetErrorHtmlSailor");
            }
            return SwanAppWebViewManager.this.cNG != null ? SwanAppWebViewManager.this.cNG.onGetErrorHtmlExt(bdSailorWebView, i, str, str2) : super.onGetErrorHtmlExt(bdSailorWebView, i, str, str2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onUrlRedirectedExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onUrlRedirected");
            }
            if (SwanAppWebViewManager.this.cNG != null) {
                SwanAppWebViewManager.this.cNG.onUrlRedirectedExt(bdSailorWebView, str, str2);
            } else {
                super.onUrlRedirectedExt(bdSailorWebView, str, str2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstContentfulPaintExt");
            }
            if (SwanAppWebViewManager.this.cNG != null) {
                SwanAppWebViewManager.this.cNG.onFirstContentfulPaintExt(bdSailorWebView, str);
            } else {
                super.onFirstContentfulPaintExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstTextPaintExt");
            }
            if (SwanAppWebViewManager.this.cNG != null) {
                SwanAppWebViewManager.this.cNG.onFirstTextPaintExt(bdSailorWebView, str);
            } else {
                super.onFirstTextPaintExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstImagePaintExt");
            }
            if (SwanAppWebViewManager.this.cNG != null) {
                SwanAppWebViewManager.this.cNG.onFirstImagePaintExt(bdSailorWebView, str);
            } else {
                super.onFirstImagePaintExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onSubFrameBeforeRequest url: " + str);
            }
            return SwanAppWebViewManager.this.cNG != null ? SwanAppWebViewManager.this.cNG.onSubFrameBeforeRequest(bdSailorWebView, str) : super.onSubFrameBeforeRequest(bdSailorWebView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class SwanAppWebChromeClient extends BdSailorWebChromeClient {
        private SwanAppWebChromeClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onHideCustomView(BdSailorWebView bdSailorWebView) {
            boolean z = false;
            if (SwanAppWebViewManager.this.cNH != null) {
                z = SwanAppWebViewManager.this.cNH.onHideCustomView(bdSailorWebView);
            }
            if (z) {
                if (SwanAppWebViewManager.DEBUG) {
                    Log.i("SwanAppWebViewManager", "SwanAppWebChromeClient::onHideCustomView by external client");
                }
            } else {
                if (SwanAppWebViewManager.this.anc() != null) {
                    SwanAppWebViewManager.this.anc().hideCustomView();
                }
                if (SwanAppWebViewManager.DEBUG) {
                    Log.i("SwanAppWebViewManager", "SwanAppWebChromeClient::onHideCustomView");
                }
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onShowCustomView(BdSailorWebView bdSailorWebView, View view, WebChromeClient.CustomViewCallback customViewCallback) {
            int i = 0;
            if (SwanAppWebViewManager.this.cNH != null ? SwanAppWebViewManager.this.cNH.onShowCustomView(bdSailorWebView, view, customViewCallback) : false) {
                if (SwanAppWebViewManager.DEBUG) {
                    Log.i("SwanAppWebViewManager", "SwanAppWebChromeClient::onShowCustomView by external client");
                }
            } else {
                if (SwanAppWebViewManager.this.cNT != -1) {
                    i = SwanAppWebViewManager.this.cNT;
                } else {
                    int i2 = com.baidu.swan.apps.runtime.d.aIn().dBO;
                    if (i2 >= 35 && i2 < 180) {
                        i = 8;
                    }
                }
                onShowCustomView(bdSailorWebView, view, i, customViewCallback);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onShowCustomView(BdSailorWebView bdSailorWebView, View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
            SwanAppWebViewManager.this.cNT = -1;
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "CustomView orientation applied, set back to default [" + SwanAppWebViewManager.this.cNT + "]");
            }
            boolean z = false;
            if (SwanAppWebViewManager.this.cNH != null) {
                z = SwanAppWebViewManager.this.cNH.onShowCustomView(bdSailorWebView, view, i, customViewCallback);
            }
            if (z) {
                if (SwanAppWebViewManager.DEBUG) {
                    Log.i("SwanAppWebViewManager", "SwanAppWebChromeClient::onShowCustomView by external client");
                }
            } else {
                if (SwanAppWebViewManager.this.anc() != null) {
                    SwanAppWebViewManager.this.anc().a(view, i, null);
                }
                if (SwanAppWebViewManager.DEBUG) {
                    Log.i("SwanAppWebViewManager", "SwanAppWebChromeClient::onShowCustomView : " + i);
                }
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onCloseWindow(BdSailorWebView bdSailorWebView) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onCloseWindow");
            }
            if (SwanAppWebViewManager.this.cNH != null) {
                SwanAppWebViewManager.this.cNH.onCloseWindow(bdSailorWebView);
            } else {
                super.onCloseWindow(bdSailorWebView);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onConsoleMessage(BdSailorWebView bdSailorWebView, ConsoleMessage consoleMessage) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onConsoleMessage");
            }
            if (SwanAppWebViewManager.this.cNH == null || !SwanAppWebViewManager.this.cNH.onConsoleMessage(bdSailorWebView, consoleMessage)) {
                return super.onConsoleMessage(bdSailorWebView, consoleMessage);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onCreateWindow(BdSailorWebView bdSailorWebView, boolean z, boolean z2, Message message) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onCreateWindow");
            }
            if (SwanAppWebViewManager.this.cNH == null || !SwanAppWebViewManager.this.cNH.onCreateWindow(bdSailorWebView, z, z2, message)) {
                return super.onCreateWindow(bdSailorWebView, z, z2, message);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onExceededDatabaseQuota(BdSailorWebView bdSailorWebView, String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onExceededDatabaseQuota");
            }
            if (SwanAppWebViewManager.this.cNH != null) {
                SwanAppWebViewManager.this.cNH.onExceededDatabaseQuota(bdSailorWebView, str, str2, j, j2, j3, quotaUpdater);
            } else {
                super.onExceededDatabaseQuota(bdSailorWebView, str, str2, j, j2, j3, quotaUpdater);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onJsBeforeUnload(BdSailorWebView bdSailorWebView, String str, String str2, JsResult jsResult) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onJsBeforeUnload：" + str);
            }
            if (SwanAppWebViewManager.this.cNH == null || !SwanAppWebViewManager.this.cNH.onJsBeforeUnload(bdSailorWebView, str, str2, jsResult)) {
                return super.onJsBeforeUnload(bdSailorWebView, str, str2, jsResult);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onJsTimeout(BdSailorWebView bdSailorWebView) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onJsTimeout  ");
            }
            if (SwanAppWebViewManager.this.cNH == null || !SwanAppWebViewManager.this.cNH.onJsTimeout(bdSailorWebView)) {
                return super.onJsTimeout(bdSailorWebView);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReachedMaxAppCacheSize(BdSailorWebView bdSailorWebView, long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onReachedMaxAppCacheSize");
            }
            if (SwanAppWebViewManager.this.cNH != null) {
                SwanAppWebViewManager.this.cNH.onReachedMaxAppCacheSize(bdSailorWebView, j, j2, quotaUpdater);
            } else {
                super.onReachedMaxAppCacheSize(bdSailorWebView, j, j2, quotaUpdater);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedIcon(BdSailorWebView bdSailorWebView, Bitmap bitmap) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onReachedMaxAppCacheSize");
            }
            if (SwanAppWebViewManager.this.cNH != null) {
                SwanAppWebViewManager.this.cNH.onReceivedIcon(bdSailorWebView, bitmap);
            } else {
                super.onReceivedIcon(bdSailorWebView, bitmap);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedTouchIconUrl(BdSailorWebView bdSailorWebView, String str, boolean z) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onReceivedTouchIconUrl");
            }
            if (SwanAppWebViewManager.this.cNH != null) {
                SwanAppWebViewManager.this.cNH.onReceivedTouchIconUrl(bdSailorWebView, str, z);
            } else {
                super.onReceivedTouchIconUrl(bdSailorWebView, str, z);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onRequestFocus(BdSailorWebView bdSailorWebView) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onRequestFocus");
            }
            if (SwanAppWebViewManager.this.cNH != null) {
                SwanAppWebViewManager.this.cNH.onRequestFocus(bdSailorWebView);
            } else {
                super.onRequestFocus(bdSailorWebView);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void openFileChooser(BdSailorWebView bdSailorWebView, ValueCallback valueCallback) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::openFileChooser");
            }
            if (SwanAppWebViewManager.this.cNH != null) {
                SwanAppWebViewManager.this.cNH.openFileChooser(bdSailorWebView, valueCallback);
            } else {
                super.openFileChooser(bdSailorWebView, valueCallback);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void openFileChooser(BdSailorWebView bdSailorWebView, ValueCallback valueCallback, String str) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::openFileChooser");
            }
            if (SwanAppWebViewManager.this.cNH != null) {
                SwanAppWebViewManager.this.cNH.openFileChooser(bdSailorWebView, valueCallback, str);
            } else {
                super.openFileChooser(bdSailorWebView, valueCallback, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void openFileChooser(BdSailorWebView bdSailorWebView, ValueCallback valueCallback, String str, String str2) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::openFileChooser");
            }
            if (SwanAppWebViewManager.this.cNH != null) {
                SwanAppWebViewManager.this.cNH.openFileChooser(bdSailorWebView, valueCallback, str, str2);
            } else {
                super.openFileChooser(bdSailorWebView, valueCallback, str, str2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onShowFileChooser(BdSailorWebView bdSailorWebView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            return super.onShowFileChooser(bdSailorWebView, valueCallback, fileChooserParams);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onProgressChanged(BdSailorWebView bdSailorWebView, int i) {
            if (SwanAppWebViewManager.this.cNH != null) {
                SwanAppWebViewManager.this.cNH.onProgressChanged(bdSailorWebView, i);
            } else {
                super.onProgressChanged(bdSailorWebView, i);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedTitle(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onReceivedTitleInFact : " + str);
            }
            if (SwanAppWebViewManager.this.cNH != null) {
                SwanAppWebViewManager.this.cNH.onReceivedTitle(bdSailorWebView, str);
            } else {
                super.onReceivedTitle(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onJsPrompt(BdSailorWebView bdSailorWebView, String str, String str2, String str3, final JsPromptResult jsPromptResult) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onJsPrompt");
            }
            return SwanAppWebViewManager.this.cNI.a(str, str2, str3, new b.InterfaceC0409b() { // from class: com.baidu.swan.apps.core.SwanAppWebViewManager.SwanAppWebChromeClient.1
                @Override // com.baidu.swan.apps.core.e.b.InterfaceC0409b
                public void and() {
                    jsPromptResult.cancel();
                }

                @Override // com.baidu.swan.apps.core.e.b.InterfaceC0409b
                public void lT(String str4) {
                    jsPromptResult.confirm(str4);
                }

                @Override // com.baidu.swan.apps.core.e.b.InterfaceC0409b
                public void onCancel() {
                    jsPromptResult.cancel();
                }
            });
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onJsAlert(BdSailorWebView bdSailorWebView, String str, String str2, final JsResult jsResult) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onJsAlert");
            }
            return SwanAppWebViewManager.this.cNI.a(str, str2, new b.InterfaceC0409b() { // from class: com.baidu.swan.apps.core.SwanAppWebViewManager.SwanAppWebChromeClient.2
                @Override // com.baidu.swan.apps.core.e.b.InterfaceC0409b
                public void and() {
                    jsResult.cancel();
                }

                @Override // com.baidu.swan.apps.core.e.b.InterfaceC0409b
                public void lT(String str3) {
                    jsResult.confirm();
                }

                @Override // com.baidu.swan.apps.core.e.b.InterfaceC0409b
                public void onCancel() {
                    jsResult.cancel();
                }
            });
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onJsConfirm(BdSailorWebView bdSailorWebView, String str, String str2, final JsResult jsResult) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onJsConfirm");
            }
            return SwanAppWebViewManager.this.cNI.b(str, str2, new b.InterfaceC0409b() { // from class: com.baidu.swan.apps.core.SwanAppWebViewManager.SwanAppWebChromeClient.3
                @Override // com.baidu.swan.apps.core.e.b.InterfaceC0409b
                public void and() {
                    jsResult.cancel();
                }

                @Override // com.baidu.swan.apps.core.e.b.InterfaceC0409b
                public void lT(String str3) {
                    jsResult.confirm();
                }

                @Override // com.baidu.swan.apps.core.e.b.InterfaceC0409b
                public void onCancel() {
                    jsResult.cancel();
                }
            });
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onGeolocationPermissionsHidePrompt(BdSailorWebView bdSailorWebView) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onGeolocationPermissionsHidePrompt");
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onGeolocationPermissionsShowPrompt(BdSailorWebView bdSailorWebView, final String str, final GeolocationPermissions.Callback callback) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onGeolocationPermissionsShowPrompt");
            }
            com.baidu.swan.apps.runtime.e aIr = com.baidu.swan.apps.runtime.e.aIr();
            if (aIr == null || aIr.aIl() == null) {
                SwanAppWebViewManager.this.b(str, callback);
            } else {
                aIr.aID().b(aIr.aIl(), "mapp_location", new com.baidu.swan.apps.ao.e.b<h<b.d>>() { // from class: com.baidu.swan.apps.core.SwanAppWebViewManager.SwanAppWebChromeClient.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ao.e.b
                    /* renamed from: a */
                    public void L(h<b.d> hVar) {
                        if (com.baidu.swan.apps.setting.oauth.c.b(hVar)) {
                            SwanAppWebViewManager.this.c(str, callback);
                        } else {
                            SwanAppWebViewManager.this.b(str, callback);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class SwanAppWebChromeClientExt extends BdSailorWebChromeClientExt {
        private boolean mIsFirstTimeShow;

        private SwanAppWebChromeClientExt() {
            this.mIsFirstTimeShow = true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClientExt
        public void showSelectionActionDialogExt(BdSailorWebView bdSailorWebView, int i, int i2, int i3, int i4, String str) {
            super.showSelectionActionDialogExt(bdSailorWebView, i, i2, i3, i4, str);
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "showSelectionActionDialogExt: " + i3 + " : " + i4 + " : " + i + " : " + i2 + " : " + str);
            }
            com.baidu.swan.apps.t.a.axu().a(SwanAppWebViewManager.this.cNE, i, i2, i3, i4, str, this.mIsFirstTimeShow);
            this.mIsFirstTimeShow = false;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClientExt
        public void hideSelectionActionDialogExt(BdSailorWebView bdSailorWebView) {
            super.hideSelectionActionDialogExt(bdSailorWebView);
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "hideSelectionActionDialogExt: ");
            }
            SwanAppWebViewManager.this.cNE.hidePopWindow();
            this.mIsFirstTimeShow = true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClientExt
        @SuppressLint({"DefaultLocale"})
        public void performLongClickExt(BdSailorWebView bdSailorWebView, WebView.HitTestResult hitTestResult, int i, int i2) {
            super.performLongClickExt(bdSailorWebView, hitTestResult, i, i2);
            if (hitTestResult != null) {
                if (SwanAppWebViewManager.DEBUG) {
                    Log.d("SwanAppWebViewManager", "performLongClickExt: " + hitTestResult.getType() + " : " + i + " : " + i2);
                }
                int type = hitTestResult.getType();
                if (type == 10) {
                    SwanAppWebViewManager.this.amY();
                } else if (type == 5) {
                    SwanAppWebViewManager.this.cNE.evaluateJavascript(String.format("javascript:(function(){return window.getImageSrcByCoordinate(%s,%s);})()", Integer.valueOf(ah.Q(i)), Integer.valueOf(ah.Q(i2))), new ValueCallback<String>() { // from class: com.baidu.swan.apps.core.SwanAppWebViewManager.SwanAppWebChromeClientExt.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str) {
                            if (!TextUtils.isEmpty(str)) {
                                com.baidu.swan.apps.console.c.d("SwanAppWebViewManager", "onReceiveValue: " + str);
                                JsonReader jsonReader = new JsonReader(new StringReader(str));
                                jsonReader.setLenient(true);
                                try {
                                    if (jsonReader.peek() != JsonToken.NULL && jsonReader.peek() == JsonToken.STRING) {
                                        String nextString = jsonReader.nextString();
                                        if (!TextUtils.isEmpty(nextString)) {
                                            com.baidu.swan.apps.t.a.axu().a(SwanAppWebViewManager.this.cNE, nextString);
                                        }
                                    }
                                } catch (IOException e) {
                                    if (SwanAppWebViewManager.DEBUG) {
                                        e.printStackTrace();
                                    }
                                } finally {
                                    com.baidu.swan.c.d.closeSafely(jsonReader);
                                }
                            }
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, GeolocationPermissions.Callback callback) {
        if (DEBUG) {
            Log.d("SwanAppWebViewManager", "allowGeoLocationOnce origin: " + str);
        }
        callback.invoke(str, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, GeolocationPermissions.Callback callback) {
        if (DEBUG) {
            Log.d("SwanAppWebViewManager", "rejectGeoLocationOnce origin: " + str);
        }
        callback.invoke(str, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public void c(final String str, final GeolocationPermissions.Callback callback) {
        com.baidu.swan.apps.ab.a.a("android.permission.ACCESS_FINE_LOCATION", new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, com.baidu.swan.apps.runtime.d.aIn().aIl(), new com.baidu.swan.apps.ab.b() { // from class: com.baidu.swan.apps.core.SwanAppWebViewManager.3
            @Override // com.baidu.swan.apps.ab.b
            public void jC(String str2) {
                if (SwanAppWebViewManager.DEBUG) {
                    Log.e("SwanAppWebViewManager", str2 + "");
                }
                SwanAppWebViewManager.this.a(str, callback);
            }

            @Override // com.baidu.swan.apps.ab.b
            public void ai(int i, String str2) {
                if (SwanAppWebViewManager.DEBUG) {
                    Log.e("SwanAppWebViewManager", str2 + "");
                }
                SwanAppWebViewManager.this.b(str, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes8.dex */
    public class a {
        public boolean cNX = false;

        protected a() {
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.e
    public void onJSLoaded() {
    }
}
