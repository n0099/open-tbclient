package com.baidu.swan.apps.core;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.widget.AbsoluteLayout;
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
import com.baidu.swan.apps.adaptation.b.e;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.as.aj;
import com.baidu.swan.apps.core.b.a;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.core.container.c;
import com.baidu.swan.apps.core.container.view.SwanAppSelectPopView;
import com.baidu.swan.apps.core.e.b;
import com.baidu.swan.apps.scheme.j;
import com.baidu.swan.apps.setting.oauth.a.b;
import com.baidu.swan.apps.setting.oauth.h;
import com.baidu.swan.apps.y.i;
import com.baidu.swan.games.utils.so.d;
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
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public abstract class SwanAppWebViewManager implements e<NgWebView>, com.baidu.swan.apps.core.container.b, c, SwanAppSelectPopView.a, com.baidu.swan.apps.res.ui.pullrefresh.a<NgWebView> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected NgWebView bKF;
    private BdSailorWebViewClient bKG;
    private BdSailorWebViewClientExt bKH;
    private BdSailorWebChromeClient bKI;
    private com.baidu.swan.apps.core.e.b bKJ;
    protected j bKK;
    private b bKL;
    private aj bKR;
    private com.baidu.swan.apps.r.d.a bKS;
    protected Activity mActivity;
    protected Context mContext;
    private UnitedSchemeMainDispatcher mMainDispatcher;
    private String mUserAgent;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private final a bKM = new a();
    private List<com.baidu.swan.apps.core.f.c> bKN = new ArrayList();
    private boolean bKO = false;
    private Drawable bKP = null;
    private Drawable bKQ = null;
    private int bKT = -1;
    private com.baidu.swan.apps.jsbridge.a.a bKU = new com.baidu.swan.apps.jsbridge.a.a();

    @Override // com.baidu.swan.apps.adaptation.b.e
    public abstract String QF();

    protected abstract void UE();

    static {
        d.ayz();
        V8Engine.getInstance(0L);
    }

    public SwanAppWebViewManager(Context context) {
        com.baidu.swan.apps.core.container.a.a.Vf().Vg();
        init(context);
        onCreate();
    }

    @DebugTrace
    private void init(Context context) {
        a(this.bKM);
        bv(context);
        a(context, this);
        UC();
        UD();
        UF();
        initSettings();
        UH();
        UE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(a aVar) {
    }

    private void bv(Context context) {
        this.mContext = context;
        this.bKF = new NgWebView(context);
        if (this.bKF.getCurrentWebView() != null) {
            this.bKP = this.bKF.getCurrentWebView().getBackground();
            AbsoluteLayout webViewImpl = this.bKF.getWebViewImpl();
            if (webViewImpl != null) {
                this.bKQ = webViewImpl.getBackground();
            }
        }
        if (this.bKM.bKX) {
            this.bKF.setBackgroundColorForSwanApp(0);
            if (!BdZeusUtil.isWebkitLoaded()) {
                this.bKO = true;
            }
        }
        this.bKF.setScrollBarStyle(0);
        this.bKJ = new com.baidu.swan.apps.core.e.b(this.mContext);
        if (DEBUG) {
            Log.d("SwanAppWebViewManager", "WebViewManager " + hashCode() + " initializing Clients");
        }
        this.bKF.setWebViewClient(new SwanAppWebViewClient());
        this.bKF.setWebViewClientExt(new SwanAppWebViewClientExt());
        this.bKF.setWebChromeClient(new SwanAppWebChromeClient());
        this.bKF.setWebChromeClientExt(new SwanAppWebChromeClientExt());
        this.bKF.setOverScrollMode(2);
        this.bKF.setOnCommonEventHandler(this);
        this.bKF.setWebViewManager(this);
        this.bKF.getCurrentWebView().setLongClickable(true);
        this.bKF.setSelectPopWindowListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.res.ui.pullrefresh.a
    /* renamed from: bw */
    public NgWebView bx(Context context) {
        if (this.bKF == null) {
            bv(context);
        }
        return this.bKF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Context context, SwanAppWebViewManager swanAppWebViewManager) {
        this.bKU.a(context, this.bKF);
    }

    private void UC() {
        if (this.mMainDispatcher == null) {
            this.mMainDispatcher = new UnitedSchemeMainDispatcher();
        }
    }

    protected void UD() {
        if (this.mMainDispatcher == null) {
            throw new IllegalStateException("initSwanAppDispatcher() must be called after initDispatcher()");
        }
        this.bKK = com.baidu.swan.apps.scheme.e.a(this.mMainDispatcher);
    }

    protected void UF() {
        this.bKU.a(this.bKF, this.mContext, this, this.mMainDispatcher);
    }

    @Override // com.baidu.swan.apps.adaptation.b.e
    public void D(Activity activity) {
        this.bKU.D(activity);
        this.mActivity = activity;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void initSettings() {
        BdSailorWebSettings settings = this.bKF.getSettings();
        ISailorWebSettingsExt settingsExt = this.bKF.getSettingsExt();
        settings.setWebViewFrameNameSailor(QE());
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
        String path = this.mContext.getDir(NgWebView.APP_DATABASE_PATH, 0).getPath();
        String path2 = this.mContext.getDir(NgWebView.APP_GEO_PATH, 0).getPath();
        String path3 = this.mContext.getDir(NgWebView.APP_CACHE_PATH, 0).getPath();
        settings.setGeolocationDatabasePath(path2);
        settings.setDatabasePath(path);
        settings.setAppCachePath(path3);
        if (((ActivityManager) this.mContext.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getMemoryClass() > 16) {
            settings.setPageCacheCapacity(5);
        } else {
            settings.setPageCacheCapacity(1);
        }
        String nM = com.baidu.swan.apps.aq.a.nM(settings.getUserAgentString());
        if (!TextUtils.equals(nM, this.mUserAgent)) {
            this.mUserAgent = nM;
            settings.setUserAgentString(this.mUserAgent);
            if (DEBUG) {
                Log.i("SwanAppWebViewManager", "set ua:" + this.mUserAgent);
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

    @Override // com.baidu.swan.apps.core.container.view.SwanAppSelectPopView.a
    public void doSelectionCopy(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.bKR == null) {
                this.bKR = aj.cr(this.mContext);
            }
            this.bKR.setText(str);
            doSelectionCancel();
        }
    }

    @Override // com.baidu.swan.apps.core.container.view.SwanAppSelectPopView.a
    public void doSelectionSearch(String str) {
        doSelectionCancel();
    }

    public void doSelectionCancel() {
        this.bKF.doSelectionCancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UG() {
        ISailorWebViewExt webViewExt = this.bKF.getWebViewExt();
        if (webViewExt != null) {
            webViewExt.emulateShiftHeldOnNormalTextExt();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void UH() {
    }

    @Override // com.baidu.swan.apps.adaptation.b.e
    public String QE() {
        return "ai_apps";
    }

    @Override // com.baidu.swan.apps.adaptation.b.e
    public String getUserAgent() {
        return this.mUserAgent;
    }

    public void loadJavaScript(final String str) {
        ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.SwanAppWebViewManager.1
            @Override // java.lang.Runnable
            public void run() {
                String str2 = str;
                if (!str2.startsWith("javascript:")) {
                    str2 = "javascript:" + str2;
                }
                if (SwanAppWebViewManager.DEBUG) {
                    Log.d("SwanAppWebViewManager", "webview load js:" + str2);
                }
                SwanAppWebViewManager.this.bKF.evaluateJavascript(str2, null);
            }
        });
    }

    public boolean isSlidable(MotionEvent motionEvent) {
        if (this.bKF != null) {
            return this.bKF.isSlidable(motionEvent);
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.adaptation.b.e
    /* renamed from: UI */
    public NgWebView QD() {
        return this.bKF;
    }

    @Override // com.baidu.swan.apps.adaptation.b.e
    public void loadUrl(String str) {
        hZ(str);
        this.bKF.loadUrl(str);
    }

    private void hZ(String str) {
        if (a.b.dY(0) && !TextUtils.isEmpty(str)) {
            String path = Uri.parse(str).getPath();
            if (DEBUG) {
                Log.d("SwanAppWebViewManager", "pathList item: " + str + " ,folder: " + path + " ,parent: " + new File(path).getParent());
            }
            if (!TextUtils.isEmpty(path)) {
                this.bKF.getSettings().setCodeCacheSetting(com.baidu.swan.apps.core.b.b.aG("appframe", new File(path).getParent()));
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
        this.bKF.onResume();
        i.b(this);
    }

    @Override // com.baidu.swan.apps.adaptation.b.e
    @CallSuper
    public void onPause() {
        this.bKF.onPause();
        i.c(this);
    }

    @CallSuper
    public void onDestroy() {
        i.d(this);
    }

    public void goBack() {
        this.bKF.goBack();
    }

    @Override // com.baidu.swan.apps.core.container.c
    public boolean UJ() {
        return false;
    }

    @Override // com.baidu.swan.apps.core.container.c
    public boolean dh(boolean z) {
        return z;
    }

    @Override // com.baidu.swan.apps.adaptation.b.e
    public void QG() {
    }

    @Override // com.baidu.swan.apps.adaptation.b.e
    public void destroy() {
        this.mHandler.removeCallbacks(null);
        this.bKF.destroy();
        this.bKN.clear();
        onDestroy();
    }

    @Override // com.baidu.swan.apps.adaptation.b.e
    public void a(b bVar) {
        this.bKL = bVar;
    }

    @Override // com.baidu.swan.apps.adaptation.b.e
    public void a(com.baidu.swan.apps.core.f.c cVar) {
        if (cVar != null && !this.bKN.contains(cVar)) {
            this.bKN.add(cVar);
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.e
    public void b(com.baidu.swan.apps.core.f.c cVar) {
        if (cVar != null && this.bKN.contains(cVar)) {
            this.bKN.remove(cVar);
        }
    }

    @Override // com.baidu.swan.apps.core.container.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.bKF.canGoBack()) {
            goBack();
            return true;
        }
        return false;
    }

    @Override // com.baidu.swan.apps.core.container.b
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        if (this.bKN != null) {
            for (com.baidu.swan.apps.core.f.c cVar : this.bKN) {
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

    public void eu(int i) {
        this.bKT = i;
        if (DEBUG) {
            Log.d("SwanAppWebViewManager", "CustomView orientation has been set to [" + this.bKT + "] for once");
        }
    }

    public final void a(BdSailorWebViewClient bdSailorWebViewClient) {
        this.bKG = bdSailorWebViewClient;
    }

    public final void a(BdSailorWebViewClientExt bdSailorWebViewClientExt) {
        this.bKH = bdSailorWebViewClientExt;
    }

    public final void a(BdSailorWebChromeClient bdSailorWebChromeClient) {
        this.bKI = bdSailorWebChromeClient;
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
                if (SwanAppWebViewManager.this.bKF.isDestroyed()) {
                    if (SwanAppWebViewManager.DEBUG) {
                        Log.e("SwanAppWebViewManager", "handleSchemeDispatchCallback webview is destroyed.");
                        return;
                    }
                    return;
                }
                SwanAppWebViewManager.this.bKF.evaluateJavascript("javascript:" + str + "(" + quote + ")", null);
            }
        });
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public String getCurrentPageUrl() {
        return QD().getUrl();
    }

    @Override // com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        return 0;
    }

    @Nullable
    public synchronized com.baidu.swan.apps.r.d.a UK() {
        SwanAppActivity akI;
        com.baidu.swan.apps.r.d.a aVar = null;
        synchronized (this) {
            if (this.bKS == null) {
                if (com.baidu.swan.apps.runtime.d.akJ().akG().available() && (akI = com.baidu.swan.apps.runtime.d.akJ().akI()) != null) {
                    this.bKS = new com.baidu.swan.apps.r.d.a(akI, QF());
                }
            }
            aVar = this.bKS;
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class SwanAppWebViewClient extends BdSailorWebViewClient {
        private SwanAppWebViewClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void doUpdateVisitedHistory(BdSailorWebView bdSailorWebView, String str, boolean z) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::doUpdateVisitedHistory");
            }
            if (SwanAppWebViewManager.this.bKG != null) {
                SwanAppWebViewManager.this.bKG.doUpdateVisitedHistory(bdSailorWebView, str, z);
            } else {
                super.doUpdateVisitedHistory(bdSailorWebView, str, z);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onFormResubmission(BdSailorWebView bdSailorWebView, Message message, Message message2) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFormResubmission");
            }
            if (SwanAppWebViewManager.this.bKG != null) {
                SwanAppWebViewManager.this.bKG.onFormResubmission(bdSailorWebView, message, message2);
            } else {
                super.onFormResubmission(bdSailorWebView, message, message2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onLoadResource(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onLoadResource：" + str);
            }
            if (SwanAppWebViewManager.this.bKG != null) {
                SwanAppWebViewManager.this.bKG.onLoadResource(bdSailorWebView, str);
            } else {
                super.onLoadResource(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedLoginRequest(BdSailorWebView bdSailorWebView, String str, String str2, String str3) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedLoginRequest");
            }
            if (SwanAppWebViewManager.this.bKG != null) {
                SwanAppWebViewManager.this.bKG.onReceivedLoginRequest(bdSailorWebView, str, str2, str3);
            } else {
                super.onReceivedLoginRequest(bdSailorWebView, str, str2, str3);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onScaleChanged(BdSailorWebView bdSailorWebView, float f, float f2) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onScaleChanged");
            }
            if (SwanAppWebViewManager.this.bKG != null) {
                SwanAppWebViewManager.this.bKG.onScaleChanged(bdSailorWebView, f, f2);
            } else {
                super.onScaleChanged(bdSailorWebView, f, f2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onUnhandledKeyEvent(BdSailorWebView bdSailorWebView, KeyEvent keyEvent) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onUnhandledKeyEvent");
            }
            if (SwanAppWebViewManager.this.bKG != null) {
                SwanAppWebViewManager.this.bKG.onUnhandledKeyEvent(bdSailorWebView, keyEvent);
            } else {
                super.onUnhandledKeyEvent(bdSailorWebView, keyEvent);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public WebResourceResponse shouldInterceptRequest(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::shouldInterceptRequest url: " + str);
            }
            if (SwanAppWebViewManager.this.bKG != null) {
                return SwanAppWebViewManager.this.bKG.shouldInterceptRequest(bdSailorWebView, str);
            }
            return super.shouldInterceptRequest(bdSailorWebView, str);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideKeyEvent(BdSailorWebView bdSailorWebView, KeyEvent keyEvent) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::shouldOverrideKeyEvent");
            }
            if (SwanAppWebViewManager.this.bKG == null || !SwanAppWebViewManager.this.bKG.shouldOverrideKeyEvent(bdSailorWebView, keyEvent)) {
                return super.shouldOverrideKeyEvent(bdSailorWebView, keyEvent);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedClientCertRequest(BdSailorWebView bdSailorWebView, ClientCertRequest clientCertRequest) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedClientCertRequest");
            }
            if (SwanAppWebViewManager.this.bKG != null) {
                SwanAppWebViewManager.this.bKG.onReceivedClientCertRequest(bdSailorWebView, clientCertRequest);
            } else {
                super.onReceivedClientCertRequest(bdSailorWebView, clientCertRequest);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::shouldOverrideUrlLoading url: " + str);
            }
            if (SwanAppWebViewManager.this.bKG != null) {
                return SwanAppWebViewManager.this.bKG.shouldOverrideUrlLoading(bdSailorWebView, str);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageStarted(BdSailorWebView bdSailorWebView, String str, Bitmap bitmap) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onPageStarted url: " + str);
            }
            if (SwanAppWebViewManager.this.bKG != null) {
                SwanAppWebViewManager.this.bKG.onPageStarted(bdSailorWebView, str, bitmap);
            } else {
                super.onPageStarted(bdSailorWebView, str, bitmap);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onPageFinished url: " + str);
            }
            if (SwanAppWebViewManager.this.bKO) {
                WebView currentWebView = SwanAppWebViewManager.this.bKF.getCurrentWebView();
                if (currentWebView != null) {
                    currentWebView.setBackground(SwanAppWebViewManager.this.bKP);
                    SwanAppWebViewManager.this.bKO = false;
                }
                AbsoluteLayout webViewImpl = SwanAppWebViewManager.this.bKF.getWebViewImpl();
                if (webViewImpl != null) {
                    webViewImpl.setBackground(SwanAppWebViewManager.this.bKQ);
                }
            }
            if (SwanAppWebViewManager.this.bKL != null) {
                SwanAppWebViewManager.this.bKL.fe(str);
            }
            if (SwanAppWebViewManager.this.bKG != null) {
                SwanAppWebViewManager.this.bKG.onPageFinished(bdSailorWebView, str);
            } else {
                super.onPageFinished(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedError errorCode: " + i + " ,failingUrl: " + str2);
            }
            if (SwanAppWebViewManager.this.bKG != null) {
                SwanAppWebViewManager.this.bKG.onReceivedError(bdSailorWebView, i, str, str2);
            } else {
                super.onReceivedError(bdSailorWebView, i, str, str2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedHttpError(BdSailorWebView bdSailorWebView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            if (SwanAppWebViewManager.this.bKG != null) {
                SwanAppWebViewManager.this.bKG.onReceivedHttpError(bdSailorWebView, webResourceRequest, webResourceResponse);
            } else {
                super.onReceivedHttpError(bdSailorWebView, webResourceRequest, webResourceResponse);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedSslError(final BdSailorWebView bdSailorWebView, final SslErrorHandler sslErrorHandler, final SslError sslError) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedSslError");
            }
            if (SwanAppWebViewManager.this.bKF.isShown()) {
                SwanAppWebViewManager.this.bKJ.a(new b.c() { // from class: com.baidu.swan.apps.core.SwanAppWebViewManager.SwanAppWebViewClient.1
                    @Override // com.baidu.swan.apps.core.e.b.c
                    public void UM() {
                        sslErrorHandler.proceed();
                    }

                    @Override // com.baidu.swan.apps.core.e.b.c
                    public void UN() {
                        sslErrorHandler.cancel();
                    }

                    @Override // com.baidu.swan.apps.core.e.b.c
                    public void UO() {
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
            String[] httpAuthUsernamePassword;
            String str4 = null;
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedHttpAuthRequest");
            }
            if (!httpAuthHandler.useHttpAuthUsernamePassword() || bdSailorWebView == null || (httpAuthUsernamePassword = bdSailorWebView.getHttpAuthUsernamePassword(str, str2)) == null || httpAuthUsernamePassword.length != 2) {
                str3 = null;
            } else {
                str3 = httpAuthUsernamePassword[0];
                str4 = httpAuthUsernamePassword[1];
            }
            if (str3 != null && str4 != null) {
                if (SwanAppWebViewManager.DEBUG) {
                    Log.d("SwanAppWebViewManager", "OnReceivedHttpAuthRequest Reuse Http Auth Username & PassWord");
                }
                httpAuthHandler.proceed(str3, str4);
            } else if (SwanAppWebViewManager.this.bKF.isShown()) {
                if (SwanAppWebViewManager.DEBUG) {
                    Log.d("SwanAppWebViewManager", "OnReceivedHttpAuthRequest show Http Auth dialog ");
                }
                SwanAppWebViewManager.this.bKJ.a(new b.a() { // from class: com.baidu.swan.apps.core.SwanAppWebViewManager.SwanAppWebViewClient.2
                    @Override // com.baidu.swan.apps.core.e.b.a
                    public void aD(String str5, String str6) {
                        if (bdSailorWebView != null) {
                            bdSailorWebView.setHttpAuthUsernamePassword(str, str2, str5, str6);
                        }
                        httpAuthHandler.proceed(str5, str6);
                    }

                    @Override // com.baidu.swan.apps.core.e.b.a
                    public void UP() {
                        httpAuthHandler.cancel();
                    }
                }, str, str2);
            } else {
                httpAuthHandler.cancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class SwanAppWebViewClientExt extends BdSailorWebViewClientExt {
        private SwanAppWebViewClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.this.bKH != null) {
                SwanAppWebViewManager.this.bKH.onFirstLayoutDidExt(bdSailorWebView, str);
            } else {
                super.onFirstLayoutDidExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFullScreenModeExt(BdSailorWebView bdSailorWebView, boolean z, int i, int i2) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFullScreenModeEx");
            }
            if (SwanAppWebViewManager.this.bKH != null) {
                SwanAppWebViewManager.this.bKH.onFullScreenModeExt(bdSailorWebView, z, i, i2);
            } else {
                super.onFullScreenModeExt(bdSailorWebView, z, i, i2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPreloadUrlFoundExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onPreloadUrlFoundEx：" + str);
            }
            if (SwanAppWebViewManager.this.bKH != null) {
                SwanAppWebViewManager.this.bKH.onPreloadUrlFoundExt(bdSailorWebView, str);
            } else {
                super.onPreloadUrlFoundExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageCanBeScaledExt(BdSailorWebView bdSailorWebView, boolean z) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onPageCanBeScaledEx");
            }
            if (SwanAppWebViewManager.this.bKH != null) {
                SwanAppWebViewManager.this.bKH.onPageCanBeScaledExt(bdSailorWebView, z);
            } else {
                super.onPageCanBeScaledExt(bdSailorWebView, z);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstPaintDidEx");
            }
            if (SwanAppWebViewManager.this.bKH != null) {
                SwanAppWebViewManager.this.bKH.onFirstPaintDidExt(bdSailorWebView, str);
            } else {
                super.onFirstPaintDidExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstScreenPaintFinishedEx");
            }
            if (SwanAppWebViewManager.this.bKH != null) {
                SwanAppWebViewManager.this.bKH.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            } else {
                super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageBackOrForwardExt(BdSailorWebView bdSailorWebView, int i) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onGoBackOrForwardEx");
            }
            if (SwanAppWebViewManager.this.bKH != null) {
                SwanAppWebViewManager.this.bKH.onPageBackOrForwardExt(bdSailorWebView, i);
            } else {
                super.onPageBackOrForwardExt(bdSailorWebView, i);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean shouldHandleImageExt(BdSailorWebView bdSailorWebView, String str, String str2, String str3, boolean z) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::canHandleImageEx");
            }
            if (SwanAppWebViewManager.this.bKH == null || !SwanAppWebViewManager.this.bKH.shouldHandleImageExt(bdSailorWebView, str, str2, str3, z)) {
                return super.shouldHandleImageExt(bdSailorWebView, str, str2, str3, z);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onSecurityCheckResultExt(BdSailorWebView bdSailorWebView, String str, WebViewClient.SecurityInfo securityInfo) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onSecurityCheckResultEx");
            }
            if (SwanAppWebViewManager.this.bKH != null) {
                SwanAppWebViewManager.this.bKH.onSecurityCheckResultExt(bdSailorWebView, str, securityInfo);
            } else {
                super.onSecurityCheckResultExt(bdSailorWebView, str, securityInfo);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onKeywordExtensionExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onKeywordExtensionEx");
            }
            return SwanAppWebViewManager.this.bKH != null ? SwanAppWebViewManager.this.bKH.onKeywordExtensionExt(bdSailorWebView, str, str2) : super.onKeywordExtensionExt(bdSailorWebView, str, str2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public String onGetErrorHtmlExt(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onGetErrorHtmlSailor");
            }
            return SwanAppWebViewManager.this.bKH != null ? SwanAppWebViewManager.this.bKH.onGetErrorHtmlExt(bdSailorWebView, i, str, str2) : super.onGetErrorHtmlExt(bdSailorWebView, i, str, str2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onUrlRedirectedExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onUrlRedirected");
            }
            if (SwanAppWebViewManager.this.bKH != null) {
                SwanAppWebViewManager.this.bKH.onUrlRedirectedExt(bdSailorWebView, str, str2);
            } else {
                super.onUrlRedirectedExt(bdSailorWebView, str, str2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstContentfulPaintExt");
            }
            if (SwanAppWebViewManager.this.bKH != null) {
                SwanAppWebViewManager.this.bKH.onFirstContentfulPaintExt(bdSailorWebView, str);
            } else {
                super.onFirstContentfulPaintExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onSubFrameBeforeRequest url: " + str);
            }
            return SwanAppWebViewManager.this.bKH != null ? SwanAppWebViewManager.this.bKH.onSubFrameBeforeRequest(bdSailorWebView, str) : super.onSubFrameBeforeRequest(bdSailorWebView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class SwanAppWebChromeClient extends BdSailorWebChromeClient {
        private SwanAppWebChromeClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onHideCustomView(BdSailorWebView bdSailorWebView) {
            boolean z = false;
            if (SwanAppWebViewManager.this.bKI != null) {
                z = SwanAppWebViewManager.this.bKI.onHideCustomView(bdSailorWebView);
            }
            if (z) {
                if (SwanAppWebViewManager.DEBUG) {
                    Log.i("SwanAppWebViewManager", "SwanAppWebChromeClient::onHideCustomView by external client");
                }
            } else {
                if (SwanAppWebViewManager.this.UK() != null) {
                    SwanAppWebViewManager.this.UK().hideCustomView();
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
            if (SwanAppWebViewManager.this.bKI != null ? SwanAppWebViewManager.this.bKI.onShowCustomView(bdSailorWebView, view, customViewCallback) : false) {
                if (SwanAppWebViewManager.DEBUG) {
                    Log.i("SwanAppWebViewManager", "SwanAppWebChromeClient::onShowCustomView by external client");
                }
            } else {
                if (SwanAppWebViewManager.this.bKT != -1) {
                    i = SwanAppWebViewManager.this.bKT;
                } else {
                    int i2 = com.baidu.swan.apps.runtime.d.akJ().cnW;
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
            SwanAppWebViewManager.this.bKT = -1;
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "CustomView orientation applied, set back to default [" + SwanAppWebViewManager.this.bKT + "]");
            }
            boolean z = false;
            if (SwanAppWebViewManager.this.bKI != null) {
                z = SwanAppWebViewManager.this.bKI.onShowCustomView(bdSailorWebView, view, i, customViewCallback);
            }
            if (z) {
                if (SwanAppWebViewManager.DEBUG) {
                    Log.i("SwanAppWebViewManager", "SwanAppWebChromeClient::onShowCustomView by external client");
                }
            } else {
                if (SwanAppWebViewManager.this.UK() != null) {
                    SwanAppWebViewManager.this.UK().a(view, i, null);
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
            if (SwanAppWebViewManager.this.bKI != null) {
                SwanAppWebViewManager.this.bKI.onCloseWindow(bdSailorWebView);
            } else {
                super.onCloseWindow(bdSailorWebView);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onConsoleMessage(BdSailorWebView bdSailorWebView, ConsoleMessage consoleMessage) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onConsoleMessage");
            }
            if (SwanAppWebViewManager.this.bKI == null || !SwanAppWebViewManager.this.bKI.onConsoleMessage(bdSailorWebView, consoleMessage)) {
                return super.onConsoleMessage(bdSailorWebView, consoleMessage);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onCreateWindow(BdSailorWebView bdSailorWebView, boolean z, boolean z2, Message message) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onCreateWindow");
            }
            if (SwanAppWebViewManager.this.bKI == null || !SwanAppWebViewManager.this.bKI.onCreateWindow(bdSailorWebView, z, z2, message)) {
                return super.onCreateWindow(bdSailorWebView, z, z2, message);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onExceededDatabaseQuota(BdSailorWebView bdSailorWebView, String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onExceededDatabaseQuota");
            }
            if (SwanAppWebViewManager.this.bKI != null) {
                SwanAppWebViewManager.this.bKI.onExceededDatabaseQuota(bdSailorWebView, str, str2, j, j2, j3, quotaUpdater);
            } else {
                super.onExceededDatabaseQuota(bdSailorWebView, str, str2, j, j2, j3, quotaUpdater);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onJsBeforeUnload(BdSailorWebView bdSailorWebView, String str, String str2, JsResult jsResult) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onJsBeforeUnload：" + str);
            }
            if (SwanAppWebViewManager.this.bKI == null || !SwanAppWebViewManager.this.bKI.onJsBeforeUnload(bdSailorWebView, str, str2, jsResult)) {
                return super.onJsBeforeUnload(bdSailorWebView, str, str2, jsResult);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onJsTimeout(BdSailorWebView bdSailorWebView) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onJsTimeout  ");
            }
            if (SwanAppWebViewManager.this.bKI == null || !SwanAppWebViewManager.this.bKI.onJsTimeout(bdSailorWebView)) {
                return super.onJsTimeout(bdSailorWebView);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReachedMaxAppCacheSize(BdSailorWebView bdSailorWebView, long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onReachedMaxAppCacheSize");
            }
            if (SwanAppWebViewManager.this.bKI != null) {
                SwanAppWebViewManager.this.bKI.onReachedMaxAppCacheSize(bdSailorWebView, j, j2, quotaUpdater);
            } else {
                super.onReachedMaxAppCacheSize(bdSailorWebView, j, j2, quotaUpdater);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedIcon(BdSailorWebView bdSailorWebView, Bitmap bitmap) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onReachedMaxAppCacheSize");
            }
            if (SwanAppWebViewManager.this.bKI != null) {
                SwanAppWebViewManager.this.bKI.onReceivedIcon(bdSailorWebView, bitmap);
            } else {
                super.onReceivedIcon(bdSailorWebView, bitmap);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedTouchIconUrl(BdSailorWebView bdSailorWebView, String str, boolean z) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onReceivedTouchIconUrl");
            }
            if (SwanAppWebViewManager.this.bKI != null) {
                SwanAppWebViewManager.this.bKI.onReceivedTouchIconUrl(bdSailorWebView, str, z);
            } else {
                super.onReceivedTouchIconUrl(bdSailorWebView, str, z);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onRequestFocus(BdSailorWebView bdSailorWebView) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onRequestFocus");
            }
            if (SwanAppWebViewManager.this.bKI != null) {
                SwanAppWebViewManager.this.bKI.onRequestFocus(bdSailorWebView);
            } else {
                super.onRequestFocus(bdSailorWebView);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void openFileChooser(BdSailorWebView bdSailorWebView, ValueCallback valueCallback) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::openFileChooser");
            }
            if (SwanAppWebViewManager.this.bKI != null) {
                SwanAppWebViewManager.this.bKI.openFileChooser(bdSailorWebView, valueCallback);
            } else {
                super.openFileChooser(bdSailorWebView, valueCallback);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void openFileChooser(BdSailorWebView bdSailorWebView, ValueCallback valueCallback, String str) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::openFileChooser");
            }
            if (SwanAppWebViewManager.this.bKI != null) {
                SwanAppWebViewManager.this.bKI.openFileChooser(bdSailorWebView, valueCallback, str);
            } else {
                super.openFileChooser(bdSailorWebView, valueCallback, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void openFileChooser(BdSailorWebView bdSailorWebView, ValueCallback valueCallback, String str, String str2) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::openFileChooser");
            }
            if (SwanAppWebViewManager.this.bKI != null) {
                SwanAppWebViewManager.this.bKI.openFileChooser(bdSailorWebView, valueCallback, str, str2);
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
            if (SwanAppWebViewManager.this.bKI != null) {
                SwanAppWebViewManager.this.bKI.onProgressChanged(bdSailorWebView, i);
            } else {
                super.onProgressChanged(bdSailorWebView, i);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedTitle(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onReceivedTitleInFact : " + str);
            }
            if (SwanAppWebViewManager.this.bKI != null) {
                SwanAppWebViewManager.this.bKI.onReceivedTitle(bdSailorWebView, str);
            } else {
                super.onReceivedTitle(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onJsPrompt(BdSailorWebView bdSailorWebView, String str, String str2, String str3, final JsPromptResult jsPromptResult) {
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onJsPrompt");
            }
            return SwanAppWebViewManager.this.bKJ.a(str, str2, str3, new b.InterfaceC0299b() { // from class: com.baidu.swan.apps.core.SwanAppWebViewManager.SwanAppWebChromeClient.1
                @Override // com.baidu.swan.apps.core.e.b.InterfaceC0299b
                public void UL() {
                    jsPromptResult.cancel();
                }

                @Override // com.baidu.swan.apps.core.e.b.InterfaceC0299b
                public void ia(String str4) {
                    jsPromptResult.confirm(str4);
                }

                @Override // com.baidu.swan.apps.core.e.b.InterfaceC0299b
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
            return SwanAppWebViewManager.this.bKJ.a(str, str2, new b.InterfaceC0299b() { // from class: com.baidu.swan.apps.core.SwanAppWebViewManager.SwanAppWebChromeClient.2
                @Override // com.baidu.swan.apps.core.e.b.InterfaceC0299b
                public void UL() {
                    jsResult.cancel();
                }

                @Override // com.baidu.swan.apps.core.e.b.InterfaceC0299b
                public void ia(String str3) {
                    jsResult.confirm();
                }

                @Override // com.baidu.swan.apps.core.e.b.InterfaceC0299b
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
            return SwanAppWebViewManager.this.bKJ.b(str, str2, new b.InterfaceC0299b() { // from class: com.baidu.swan.apps.core.SwanAppWebViewManager.SwanAppWebChromeClient.3
                @Override // com.baidu.swan.apps.core.e.b.InterfaceC0299b
                public void UL() {
                    jsResult.cancel();
                }

                @Override // com.baidu.swan.apps.core.e.b.InterfaceC0299b
                public void ia(String str3) {
                    jsResult.confirm();
                }

                @Override // com.baidu.swan.apps.core.e.b.InterfaceC0299b
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
            com.baidu.swan.apps.runtime.e akM = com.baidu.swan.apps.runtime.e.akM();
            if (akM == null || akM.akI() == null) {
                SwanAppWebViewManager.this.b(str, callback);
            } else {
                akM.akW().b(akM.akI(), "mapp_location", new com.baidu.swan.apps.as.d.b<h<b.d>>() { // from class: com.baidu.swan.apps.core.SwanAppWebViewManager.SwanAppWebChromeClient.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.as.d.b
                    /* renamed from: a */
                    public void F(h<b.d> hVar) {
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
    /* loaded from: classes11.dex */
    public class SwanAppWebChromeClientExt extends BdSailorWebChromeClientExt {
        private SwanAppWebChromeClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClientExt
        public void showSelectionActionDialogExt(BdSailorWebView bdSailorWebView, int i, int i2, int i3, int i4, String str) {
            super.showSelectionActionDialogExt(bdSailorWebView, i, i2, i3, i4, str);
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "showSelectionActionDialogExt: " + i3 + " : " + i4 + " : " + i + " : " + i2 + " : " + str);
            }
            SwanAppWebViewManager.this.bKF.updateAndShowPopupWindow(i3, i4, i, i2, str, true);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClientExt
        public void hideSelectionActionDialogExt(BdSailorWebView bdSailorWebView) {
            super.hideSelectionActionDialogExt(bdSailorWebView);
            if (SwanAppWebViewManager.DEBUG) {
                Log.d("SwanAppWebViewManager", "hideSelectionActionDialogExt: ");
            }
            SwanAppWebViewManager.this.bKF.hidePopWindow();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClientExt
        public void performLongClickExt(BdSailorWebView bdSailorWebView, WebView.HitTestResult hitTestResult, int i, int i2) {
            super.performLongClickExt(bdSailorWebView, hitTestResult, i, i2);
            if (hitTestResult != null) {
                if (SwanAppWebViewManager.DEBUG) {
                    Log.d("SwanAppWebViewManager", "performLongClickExt: " + hitTestResult.getType() + " : " + i + " : " + i2);
                }
                if (hitTestResult.getType() == 10) {
                    SwanAppWebViewManager.this.UG();
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
        com.baidu.swan.apps.af.a.a("android.permission.ACCESS_FINE_LOCATION", new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, new com.baidu.swan.apps.af.b() { // from class: com.baidu.swan.apps.core.SwanAppWebViewManager.3
            @Override // com.baidu.swan.apps.af.b
            public void gQ(String str2) {
                if (SwanAppWebViewManager.DEBUG) {
                    Log.e("SwanAppWebViewManager", str2 + "");
                }
                SwanAppWebViewManager.this.a(str, callback);
            }

            @Override // com.baidu.swan.apps.af.b
            public void M(int i, String str2) {
                if (SwanAppWebViewManager.DEBUG) {
                    Log.e("SwanAppWebViewManager", str2 + "");
                }
                SwanAppWebViewManager.this.b(str, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes11.dex */
    public class a {
        public boolean bKX = false;

        protected a() {
        }
    }

    @Override // com.baidu.swan.apps.adaptation.b.e
    public void onJSLoaded() {
    }
}
