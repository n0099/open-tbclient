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
import android.webkit.WebResourceResponse;
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
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.core.container.view.SwanAppSelectPopView;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.br2;
import com.baidu.tieba.cu1;
import com.baidu.tieba.ds2;
import com.baidu.tieba.eo1;
import com.baidu.tieba.g63;
import com.baidu.tieba.h92;
import com.baidu.tieba.i62;
import com.baidu.tieba.kt2;
import com.baidu.tieba.ll3;
import com.baidu.tieba.n62;
import com.baidu.tieba.n72;
import com.baidu.tieba.n83;
import com.baidu.tieba.nd3;
import com.baidu.tieba.nm3;
import com.baidu.tieba.o23;
import com.baidu.tieba.ol3;
import com.baidu.tieba.r83;
import com.baidu.tieba.rh2;
import com.baidu.tieba.sc3;
import com.baidu.tieba.sh2;
import com.baidu.tieba.t62;
import com.baidu.tieba.t73;
import com.baidu.tieba.tj3;
import com.baidu.tieba.u42;
import com.baidu.tieba.u62;
import com.baidu.tieba.u73;
import com.baidu.tieba.up4;
import com.baidu.tieba.v62;
import com.baidu.tieba.w23;
import com.baidu.tieba.wb2;
import com.baidu.tieba.x23;
import com.baidu.tieba.xc3;
import com.baidu.tieba.xo2;
import com.baidu.tieba.yn4;
import com.baidu.tieba.zc3;
import com.baidu.webkit.sdk.ClientCertRequest;
import com.baidu.webkit.sdk.GeolocationPermissions;
import com.baidu.webkit.sdk.HttpAuthHandler;
import com.baidu.webkit.sdk.JsCodeCacheResult;
import com.baidu.webkit.sdk.JsPromptResult;
import com.baidu.webkit.sdk.JsResult;
import com.baidu.webkit.sdk.WebChromeClient;
import com.baidu.webkit.sdk.WebResourceRequest;
import com.baidu.webkit.sdk.WebSettings;
import com.baidu.webkit.sdk.WebStorage;
import com.baidu.webkit.sdk.WebView;
import com.baidu.webkit.sdk.WebViewClient;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.kuaishou.weapon.p0.h;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class SwanAppWebViewManager implements cu1<NgWebView>, t62, u62, g63<NgWebView>, SwanAppSelectPopView.a {
    public static final boolean v = eo1.a;
    public MutableContextWrapper a;
    public NgWebView b;
    public BdSailorWebViewClient c;
    public BdSailorWebViewClientExt d;
    public BdSailorWebChromeClient e;
    public n72 f;
    public UnitedSchemeMainDispatcher g;
    public r83 h;
    public i62 j;
    public String p;
    public xo2 q;
    public String r;
    public String s;
    public Handler i = new Handler(Looper.getMainLooper());
    public final d k = new d(this);
    public List<h92> l = new ArrayList();
    public boolean m = false;
    public Drawable n = null;
    public Drawable o = null;
    public int t = -1;
    public ds2 u = new ds2();

    public abstract void L0();

    public void U0(d dVar) {
    }

    public void V0() {
    }

    @Override // com.baidu.tieba.cu1
    public abstract String a();

    @Override // com.baidu.tieba.cu1
    public String b0() {
        return "ai_apps";
    }

    @Override // com.baidu.tieba.t62
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tieba.cu1
    public void e0() {
    }

    @Override // com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        return 0;
    }

    @Override // com.baidu.tieba.u62
    public boolean o() {
        return false;
    }

    @Override // com.baidu.tieba.cu1
    public void onJSLoaded() {
    }

    @Override // com.baidu.tieba.t62
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.tieba.u62
    public boolean u(boolean z) {
        return z;
    }

    /* loaded from: classes3.dex */
    public class SwanAppWebChromeClient extends BdSailorWebChromeClient {

        /* loaded from: classes3.dex */
        public class a implements n72.s {
            public final /* synthetic */ JsPromptResult a;

            public a(SwanAppWebChromeClient swanAppWebChromeClient, JsPromptResult jsPromptResult) {
                this.a = jsPromptResult;
            }

            @Override // com.baidu.tieba.n72.s
            public void a() {
                this.a.cancel();
            }

            @Override // com.baidu.tieba.n72.s
            public void onCancel() {
                this.a.cancel();
            }

            @Override // com.baidu.tieba.n72.s
            public void b(String str) {
                this.a.confirm(str);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements n72.s {
            public final /* synthetic */ JsResult a;

            public b(SwanAppWebChromeClient swanAppWebChromeClient, JsResult jsResult) {
                this.a = jsResult;
            }

            @Override // com.baidu.tieba.n72.s
            public void a() {
                this.a.cancel();
            }

            @Override // com.baidu.tieba.n72.s
            public void onCancel() {
                this.a.cancel();
            }

            @Override // com.baidu.tieba.n72.s
            public void b(String str) {
                this.a.confirm();
            }
        }

        /* loaded from: classes3.dex */
        public class c implements n72.s {
            public final /* synthetic */ JsResult a;

            public c(SwanAppWebChromeClient swanAppWebChromeClient, JsResult jsResult) {
                this.a = jsResult;
            }

            @Override // com.baidu.tieba.n72.s
            public void a() {
                this.a.cancel();
            }

            @Override // com.baidu.tieba.n72.s
            public void onCancel() {
                this.a.cancel();
            }

            @Override // com.baidu.tieba.n72.s
            public void b(String str) {
                this.a.confirm();
            }
        }

        /* loaded from: classes3.dex */
        public class d implements nm3<xc3<zc3.e>> {
            public final /* synthetic */ String a;
            public final /* synthetic */ GeolocationPermissions.Callback b;

            public d(String str, GeolocationPermissions.Callback callback) {
                this.a = str;
                this.b = callback;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.nm3
            /* renamed from: b */
            public void a(xc3<zc3.e> xc3Var) {
                if (sc3.h(xc3Var)) {
                    SwanAppWebViewManager.this.I0(this.a, this.b);
                } else {
                    SwanAppWebViewManager.this.W0(this.a, this.b);
                }
            }
        }

        public SwanAppWebChromeClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onCloseWindow(BdSailorWebView bdSailorWebView) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onCloseWindow");
            }
            if (SwanAppWebViewManager.this.e != null) {
                SwanAppWebViewManager.this.e.onCloseWindow(bdSailorWebView);
            } else {
                super.onCloseWindow(bdSailorWebView);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onGeolocationPermissionsHidePrompt(BdSailorWebView bdSailorWebView) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onGeolocationPermissionsHidePrompt");
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onJsTimeout(BdSailorWebView bdSailorWebView) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onJsTimeout  ");
            }
            if (SwanAppWebViewManager.this.e != null && SwanAppWebViewManager.this.e.onJsTimeout(bdSailorWebView)) {
                return true;
            }
            return super.onJsTimeout(bdSailorWebView);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onRequestFocus(BdSailorWebView bdSailorWebView) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onRequestFocus");
            }
            if (SwanAppWebViewManager.this.e != null) {
                SwanAppWebViewManager.this.e.onRequestFocus(bdSailorWebView);
            } else {
                super.onRequestFocus(bdSailorWebView);
            }
        }

        public /* synthetic */ SwanAppWebChromeClient(SwanAppWebViewManager swanAppWebViewManager, a aVar) {
            this();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onConsoleMessage(BdSailorWebView bdSailorWebView, ConsoleMessage consoleMessage) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onConsoleMessage");
            }
            if (SwanAppWebViewManager.this.e != null && SwanAppWebViewManager.this.e.onConsoleMessage(bdSailorWebView, consoleMessage)) {
                return true;
            }
            return super.onConsoleMessage(bdSailorWebView, consoleMessage);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onProgressChanged(BdSailorWebView bdSailorWebView, int i) {
            if (SwanAppWebViewManager.this.e != null) {
                SwanAppWebViewManager.this.e.onProgressChanged(bdSailorWebView, i);
            } else {
                super.onProgressChanged(bdSailorWebView, i);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedIcon(BdSailorWebView bdSailorWebView, Bitmap bitmap) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onReachedMaxAppCacheSize");
            }
            if (SwanAppWebViewManager.this.e != null) {
                SwanAppWebViewManager.this.e.onReceivedIcon(bdSailorWebView, bitmap);
            } else {
                super.onReceivedIcon(bdSailorWebView, bitmap);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedTitle(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onReceivedTitleInFact : " + str);
            }
            if (SwanAppWebViewManager.this.e != null) {
                SwanAppWebViewManager.this.e.onReceivedTitle(bdSailorWebView, str);
            } else {
                super.onReceivedTitle(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void openFileChooser(BdSailorWebView bdSailorWebView, ValueCallback valueCallback) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::openFileChooser");
            }
            if (SwanAppWebViewManager.this.e != null) {
                SwanAppWebViewManager.this.e.openFileChooser(bdSailorWebView, valueCallback);
            } else {
                super.openFileChooser(bdSailorWebView, valueCallback);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onCreateWindow(BdSailorWebView bdSailorWebView, boolean z, boolean z2, Message message) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onCreateWindow");
            }
            if (SwanAppWebViewManager.this.e != null && SwanAppWebViewManager.this.e.onCreateWindow(bdSailorWebView, z, z2, message)) {
                return true;
            }
            return super.onCreateWindow(bdSailorWebView, z, z2, message);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onJsAlert(BdSailorWebView bdSailorWebView, String str, String str2, JsResult jsResult) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onJsAlert");
            }
            return SwanAppWebViewManager.this.f.l(str, str2, new b(this, jsResult));
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onJsConfirm(BdSailorWebView bdSailorWebView, String str, String str2, JsResult jsResult) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onJsConfirm");
            }
            return SwanAppWebViewManager.this.f.m(str, str2, new c(this, jsResult));
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReachedMaxAppCacheSize(BdSailorWebView bdSailorWebView, long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onReachedMaxAppCacheSize");
            }
            if (SwanAppWebViewManager.this.e != null) {
                SwanAppWebViewManager.this.e.onReachedMaxAppCacheSize(bdSailorWebView, j, j2, quotaUpdater);
            } else {
                super.onReachedMaxAppCacheSize(bdSailorWebView, j, j2, quotaUpdater);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void openFileChooser(BdSailorWebView bdSailorWebView, ValueCallback valueCallback, String str, String str2) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::openFileChooser");
            }
            if (SwanAppWebViewManager.this.e != null) {
                SwanAppWebViewManager.this.e.openFileChooser(bdSailorWebView, valueCallback, str, str2);
            } else {
                super.openFileChooser(bdSailorWebView, valueCallback, str, str2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onExceededDatabaseQuota(BdSailorWebView bdSailorWebView, String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onExceededDatabaseQuota");
            }
            if (SwanAppWebViewManager.this.e != null) {
                SwanAppWebViewManager.this.e.onExceededDatabaseQuota(bdSailorWebView, str, str2, j, j2, j3, quotaUpdater);
            } else {
                super.onExceededDatabaseQuota(bdSailorWebView, str, str2, j, j2, j3, quotaUpdater);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onGeolocationPermissionsShowPrompt(BdSailorWebView bdSailorWebView, String str, GeolocationPermissions.Callback callback) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onGeolocationPermissionsShowPrompt");
            }
            u73 M = u73.M();
            if (M == null || M.w() == null) {
                SwanAppWebViewManager.this.W0(str, callback);
            } else {
                M.e0().g(M.w(), "mapp_location", new d(str, callback));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onHideCustomView(BdSailorWebView bdSailorWebView) {
            boolean z;
            if (SwanAppWebViewManager.this.e != null) {
                z = SwanAppWebViewManager.this.e.onHideCustomView(bdSailorWebView);
            } else {
                z = false;
            }
            if (z) {
                if (SwanAppWebViewManager.v) {
                    Log.i("SwanAppWebViewManager", "SwanAppWebChromeClient::onHideCustomView by external client");
                }
                return true;
            }
            if (SwanAppWebViewManager.this.F0() != null) {
                SwanAppWebViewManager.this.F0().d();
            }
            if (SwanAppWebViewManager.v) {
                Log.i("SwanAppWebViewManager", "SwanAppWebChromeClient::onHideCustomView");
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onJsBeforeUnload(BdSailorWebView bdSailorWebView, String str, String str2, JsResult jsResult) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onJsBeforeUnload：" + str);
            }
            if (SwanAppWebViewManager.this.e != null && SwanAppWebViewManager.this.e.onJsBeforeUnload(bdSailorWebView, str, str2, jsResult)) {
                return true;
            }
            return super.onJsBeforeUnload(bdSailorWebView, str, str2, jsResult);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onJsPrompt(BdSailorWebView bdSailorWebView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onJsPrompt");
            }
            return SwanAppWebViewManager.this.f.n(str, str2, str3, new a(this, jsPromptResult));
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedTouchIconUrl(BdSailorWebView bdSailorWebView, String str, boolean z) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onReceivedTouchIconUrl");
            }
            if (SwanAppWebViewManager.this.e != null) {
                SwanAppWebViewManager.this.e.onReceivedTouchIconUrl(bdSailorWebView, str, z);
            } else {
                super.onReceivedTouchIconUrl(bdSailorWebView, str, z);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onShowFileChooser(BdSailorWebView bdSailorWebView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            return super.onShowFileChooser(bdSailorWebView, valueCallback, fileChooserParams);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void openFileChooser(BdSailorWebView bdSailorWebView, ValueCallback valueCallback, String str) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::openFileChooser");
            }
            if (SwanAppWebViewManager.this.e != null) {
                SwanAppWebViewManager.this.e.openFileChooser(bdSailorWebView, valueCallback, str);
            } else {
                super.openFileChooser(bdSailorWebView, valueCallback, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onShowCustomView(BdSailorWebView bdSailorWebView, View view2, int i, WebChromeClient.CustomViewCallback customViewCallback) {
            SwanAppWebViewManager.this.t = -1;
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "CustomView orientation applied, set back to default [" + SwanAppWebViewManager.this.t + PreferencesUtil.RIGHT_MOUNT);
            }
            boolean z = false;
            if (SwanAppWebViewManager.this.e != null) {
                z = SwanAppWebViewManager.this.e.onShowCustomView(bdSailorWebView, view2, i, customViewCallback);
            }
            if (z) {
                if (SwanAppWebViewManager.v) {
                    Log.i("SwanAppWebViewManager", "SwanAppWebChromeClient::onShowCustomView by external client");
                }
                return true;
            }
            if (SwanAppWebViewManager.this.F0() != null) {
                SwanAppWebViewManager.this.F0().g(view2, i, null);
            }
            if (SwanAppWebViewManager.v) {
                Log.i("SwanAppWebViewManager", "SwanAppWebChromeClient::onShowCustomView : " + i);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onShowCustomView(BdSailorWebView bdSailorWebView, View view2, WebChromeClient.CustomViewCallback customViewCallback) {
            boolean z;
            int i = 0;
            if (SwanAppWebViewManager.this.e != null) {
                z = SwanAppWebViewManager.this.e.onShowCustomView(bdSailorWebView, view2, customViewCallback);
            } else {
                z = false;
            }
            if (z) {
                if (SwanAppWebViewManager.v) {
                    Log.i("SwanAppWebViewManager", "SwanAppWebChromeClient::onShowCustomView by external client");
                }
                return true;
            }
            if (SwanAppWebViewManager.this.t != -1) {
                i = SwanAppWebViewManager.this.t;
            } else {
                int i2 = t73.K().c;
                if (i2 >= 35 && i2 < 180) {
                    i = 8;
                }
            }
            onShowCustomView(bdSailorWebView, view2, i, customViewCallback);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class SwanAppWebChromeClientExt extends BdSailorWebChromeClientExt {
        public boolean mIsFirstTimeShow;

        /* loaded from: classes3.dex */
        public class a implements ValueCallback<String> {
            public a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.webkit.ValueCallback
            /* renamed from: a */
            public void onReceiveValue(String str) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                u42.b("SwanAppWebViewManager", "onReceiveValue: " + str);
                JsonReader jsonReader = new JsonReader(new StringReader(str));
                jsonReader.setLenient(true);
                try {
                    try {
                        if (jsonReader.peek() != JsonToken.NULL && jsonReader.peek() == JsonToken.STRING) {
                            String nextString = jsonReader.nextString();
                            if (!TextUtils.isEmpty(nextString)) {
                                br2.E0().b(SwanAppWebViewManager.this.b, nextString);
                            }
                        }
                    } catch (IOException e) {
                        if (SwanAppWebViewManager.v) {
                            e.printStackTrace();
                        }
                    }
                } finally {
                    yn4.d(jsonReader);
                }
            }
        }

        public SwanAppWebChromeClientExt() {
            this.mIsFirstTimeShow = true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClientExt
        public void hideSelectionActionDialogExt(BdSailorWebView bdSailorWebView) {
            super.hideSelectionActionDialogExt(bdSailorWebView);
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "hideSelectionActionDialogExt: ");
            }
            SwanAppWebViewManager.this.b.hidePopWindow();
            this.mIsFirstTimeShow = true;
        }

        public /* synthetic */ SwanAppWebChromeClientExt(SwanAppWebViewManager swanAppWebViewManager, a aVar) {
            this();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClientExt
        @SuppressLint({"DefaultLocale"})
        public void performLongClickExt(BdSailorWebView bdSailorWebView, WebView.HitTestResult hitTestResult, int i, int i2) {
            super.performLongClickExt(bdSailorWebView, hitTestResult, i, i2);
            if (hitTestResult == null) {
                return;
            }
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "performLongClickExt: " + hitTestResult.getType() + ZeusCrashHandler.NAME_SEPERATOR + i + ZeusCrashHandler.NAME_SEPERATOR + i2);
            }
            int type = hitTestResult.getType();
            if (type == 10) {
                SwanAppWebViewManager.this.c1();
            } else if (type == 5) {
                SwanAppWebViewManager.this.b.evaluateJavascript(String.format("javascript:(function(){return window.getImageSrcByCoordinate(%s,%s);})()", Integer.valueOf(ll3.O(i)), Integer.valueOf(ll3.O(i2))), new a());
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClientExt
        public void showSelectionActionDialogExt(BdSailorWebView bdSailorWebView, int i, int i2, int i3, int i4, String str) {
            super.showSelectionActionDialogExt(bdSailorWebView, i, i2, i3, i4, str);
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "showSelectionActionDialogExt: " + i3 + ZeusCrashHandler.NAME_SEPERATOR + i4 + ZeusCrashHandler.NAME_SEPERATOR + i + ZeusCrashHandler.NAME_SEPERATOR + i2 + ZeusCrashHandler.NAME_SEPERATOR + str);
            }
            br2.E0().c(SwanAppWebViewManager.this.b, i, i2, i3, i4, str, this.mIsFirstTimeShow);
            this.mIsFirstTimeShow = false;
        }
    }

    /* loaded from: classes3.dex */
    public class SwanAppWebViewClient extends BdSailorWebViewClient {

        /* loaded from: classes3.dex */
        public class a implements Function1<WebResourceResponse, com.baidu.webkit.sdk.WebResourceResponse> {
            public a(SwanAppWebViewClient swanAppWebViewClient) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public com.baidu.webkit.sdk.WebResourceResponse invoke(WebResourceResponse webResourceResponse) {
                if (webResourceResponse == null) {
                    return null;
                }
                return new com.baidu.webkit.sdk.WebResourceResponse(false, webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase(), webResourceResponse.getResponseHeaders(), webResourceResponse.getData());
            }
        }

        /* loaded from: classes3.dex */
        public class b implements n72.t {
            public final /* synthetic */ SslErrorHandler a;
            public final /* synthetic */ BdSailorWebView b;
            public final /* synthetic */ SslError c;

            public b(SslErrorHandler sslErrorHandler, BdSailorWebView bdSailorWebView, SslError sslError) {
                this.a = sslErrorHandler;
                this.b = bdSailorWebView;
                this.c = sslError;
            }

            @Override // com.baidu.tieba.n72.t
            public void a() {
                SwanAppWebViewClient.this.onReceivedSslError(this.b, this.a, this.c);
            }

            @Override // com.baidu.tieba.n72.t
            public void b() {
                this.a.proceed();
            }

            @Override // com.baidu.tieba.n72.t
            public void c() {
                this.a.cancel();
            }
        }

        /* loaded from: classes3.dex */
        public class c implements n72.r {
            public final /* synthetic */ BdSailorWebView a;
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;
            public final /* synthetic */ HttpAuthHandler d;

            public c(SwanAppWebViewClient swanAppWebViewClient, BdSailorWebView bdSailorWebView, String str, String str2, HttpAuthHandler httpAuthHandler) {
                this.a = bdSailorWebView;
                this.b = str;
                this.c = str2;
                this.d = httpAuthHandler;
            }

            @Override // com.baidu.tieba.n72.r
            public void a() {
                this.d.cancel();
            }

            @Override // com.baidu.tieba.n72.r
            public void b(String str, String str2) {
                BdSailorWebView bdSailorWebView = this.a;
                if (bdSailorWebView != null) {
                    bdSailorWebView.setHttpAuthUsernamePassword(this.b, this.c, str, str2);
                }
                this.d.proceed(str, str2);
            }
        }

        public SwanAppWebViewClient() {
        }

        public /* synthetic */ SwanAppWebViewClient(SwanAppWebViewManager swanAppWebViewManager, a aVar) {
            this();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onLoadResource(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onLoadResource：" + str);
            }
            if (SwanAppWebViewManager.this.c != null) {
                SwanAppWebViewManager.this.c.onLoadResource(bdSailorWebView, str);
            } else {
                super.onLoadResource(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedClientCertRequest(BdSailorWebView bdSailorWebView, ClientCertRequest clientCertRequest) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedClientCertRequest");
            }
            if (SwanAppWebViewManager.this.c != null) {
                SwanAppWebViewManager.this.c.onReceivedClientCertRequest(bdSailorWebView, clientCertRequest);
            } else {
                super.onReceivedClientCertRequest(bdSailorWebView, clientCertRequest);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onUnhandledKeyEvent(BdSailorWebView bdSailorWebView, KeyEvent keyEvent) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onUnhandledKeyEvent");
            }
            if (SwanAppWebViewManager.this.c != null) {
                SwanAppWebViewManager.this.c.onUnhandledKeyEvent(bdSailorWebView, keyEvent);
            } else {
                super.onUnhandledKeyEvent(bdSailorWebView, keyEvent);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideKeyEvent(BdSailorWebView bdSailorWebView, KeyEvent keyEvent) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::shouldOverrideKeyEvent");
            }
            if (SwanAppWebViewManager.this.c != null && SwanAppWebViewManager.this.c.shouldOverrideKeyEvent(bdSailorWebView, keyEvent)) {
                return true;
            }
            return super.shouldOverrideKeyEvent(bdSailorWebView, keyEvent);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::shouldOverrideUrlLoading url: " + str);
            }
            if (SwanAppWebViewManager.this.c != null) {
                return SwanAppWebViewManager.this.c.shouldOverrideUrlLoading(bdSailorWebView, str);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void doUpdateVisitedHistory(BdSailorWebView bdSailorWebView, String str, boolean z) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::doUpdateVisitedHistory");
            }
            if (SwanAppWebViewManager.this.c != null) {
                SwanAppWebViewManager.this.c.doUpdateVisitedHistory(bdSailorWebView, str, z);
            } else {
                super.doUpdateVisitedHistory(bdSailorWebView, str, z);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onFormResubmission(BdSailorWebView bdSailorWebView, Message message, Message message2) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFormResubmission");
            }
            if (SwanAppWebViewManager.this.c != null) {
                SwanAppWebViewManager.this.c.onFormResubmission(bdSailorWebView, message, message2);
            } else {
                super.onFormResubmission(bdSailorWebView, message, message2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageStarted(BdSailorWebView bdSailorWebView, String str, Bitmap bitmap) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onPageStarted url: " + str);
            }
            if (SwanAppWebViewManager.this.c != null) {
                SwanAppWebViewManager.this.c.onPageStarted(bdSailorWebView, str, bitmap);
            } else {
                super.onPageStarted(bdSailorWebView, str, bitmap);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedHttpError(BdSailorWebView bdSailorWebView, WebResourceRequest webResourceRequest, com.baidu.webkit.sdk.WebResourceResponse webResourceResponse) {
            if (SwanAppWebViewManager.this.c != null) {
                SwanAppWebViewManager.this.c.onReceivedHttpError(bdSailorWebView, webResourceRequest, webResourceResponse);
            } else {
                super.onReceivedHttpError(bdSailorWebView, webResourceRequest, webResourceResponse);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedSslError(BdSailorWebView bdSailorWebView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedSslError");
            }
            if (SwanAppWebViewManager.this.b.isShown()) {
                SwanAppWebViewManager.this.f.p(new b(sslErrorHandler, bdSailorWebView, sslError), sslErrorHandler, sslError);
            } else {
                sslErrorHandler.cancel();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onScaleChanged(BdSailorWebView bdSailorWebView, float f, float f2) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onScaleChanged");
            }
            if (SwanAppWebViewManager.this.c != null) {
                SwanAppWebViewManager.this.c.onScaleChanged(bdSailorWebView, f, f2);
            } else {
                super.onScaleChanged(bdSailorWebView, f, f2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onPageFinished url: " + str);
            }
            if (SwanAppWebViewManager.this.m) {
                WebView currentWebView = SwanAppWebViewManager.this.b.getCurrentWebView();
                if (currentWebView != null) {
                    currentWebView.setBackground(SwanAppWebViewManager.this.n);
                    SwanAppWebViewManager.this.m = false;
                }
                View webViewImpl = SwanAppWebViewManager.this.b.getWebViewImpl();
                if (webViewImpl != null) {
                    webViewImpl.setBackground(SwanAppWebViewManager.this.o);
                }
            }
            if (SwanAppWebViewManager.this.j != null) {
                SwanAppWebViewManager.this.j.a(str);
            }
            if (SwanAppWebViewManager.this.c != null) {
                SwanAppWebViewManager.this.c.onPageFinished(bdSailorWebView, str);
            } else {
                super.onPageFinished(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedError errorCode: " + i + " ,failingUrl: " + str2);
            }
            if (SwanAppWebViewManager.this.c != null) {
                SwanAppWebViewManager.this.c.onReceivedError(bdSailorWebView, i, str, str2);
            } else {
                super.onReceivedError(bdSailorWebView, i, str, str2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedHttpAuthRequest(BdSailorWebView bdSailorWebView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            String str3;
            String[] httpAuthUsernamePassword;
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedHttpAuthRequest");
            }
            String str4 = null;
            if (httpAuthHandler.useHttpAuthUsernamePassword() && bdSailorWebView != null && (httpAuthUsernamePassword = bdSailorWebView.getHttpAuthUsernamePassword(str, str2)) != null && httpAuthUsernamePassword.length == 2) {
                str4 = httpAuthUsernamePassword[0];
                str3 = httpAuthUsernamePassword[1];
            } else {
                str3 = null;
            }
            if (str4 != null && str3 != null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "OnReceivedHttpAuthRequest Reuse Http Auth Username & PassWord");
                }
                httpAuthHandler.proceed(str4, str3);
            } else if (SwanAppWebViewManager.this.b.isShown()) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "OnReceivedHttpAuthRequest show Http Auth dialog ");
                }
                SwanAppWebViewManager.this.f.k(new c(this, bdSailorWebView, str, str2, httpAuthHandler), str, str2);
            } else {
                httpAuthHandler.cancel();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedLoginRequest(BdSailorWebView bdSailorWebView, String str, String str2, String str3) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedLoginRequest");
            }
            if (SwanAppWebViewManager.this.c != null) {
                SwanAppWebViewManager.this.c.onReceivedLoginRequest(bdSailorWebView, str, str2, str3);
            } else {
                super.onReceivedLoginRequest(bdSailorWebView, str, str2, str3);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public com.baidu.webkit.sdk.WebResourceResponse shouldInterceptRequest(BdSailorWebView bdSailorWebView, WebResourceRequest webResourceRequest) {
            if (webResourceRequest == null) {
                return super.shouldInterceptRequest(bdSailorWebView, webResourceRequest);
            }
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::shouldInterceptRequest");
            }
            up4 up4Var = up4.b;
            com.baidu.webkit.sdk.WebResourceResponse webResourceResponse = (com.baidu.webkit.sdk.WebResourceResponse) up4Var.c(up4Var.b(webResourceRequest.getUrl()), new a(this));
            if (webResourceResponse != null) {
                return webResourceResponse;
            }
            if (SwanAppWebViewManager.this.c != null) {
                webResourceResponse = SwanAppWebViewManager.this.c.shouldInterceptRequest(bdSailorWebView, webResourceRequest);
            }
            if (webResourceResponse == null) {
                webResourceResponse = wb2.b().c(webResourceRequest, true);
            }
            if (webResourceResponse == null) {
                return super.shouldInterceptRequest(bdSailorWebView, webResourceRequest);
            }
            return webResourceResponse;
        }
    }

    /* loaded from: classes3.dex */
    public class SwanAppWebViewClientExt extends BdSailorWebViewClientExt {
        public SwanAppWebViewClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onJsCodeCacheFinished(JsCodeCacheResult jsCodeCacheResult) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onJsCodeCachedFinished : " + jsCodeCacheResult);
            }
            if (SwanAppWebViewManager.this.d != null) {
                SwanAppWebViewManager.this.d.onJsCodeCacheFinished(jsCodeCacheResult);
            } else {
                super.onJsCodeCacheFinished(jsCodeCacheResult);
            }
        }

        public /* synthetic */ SwanAppWebViewClientExt(SwanAppWebViewManager swanAppWebViewManager, a aVar) {
            this();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstContentfulPaintExt");
            }
            o23.g().a(str);
            if (SwanAppWebViewManager.this.d != null) {
                SwanAppWebViewManager.this.d.onFirstContentfulPaintExt(bdSailorWebView, str);
            } else {
                super.onFirstContentfulPaintExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstImagePaintExt");
            }
            if (SwanAppWebViewManager.this.d != null) {
                SwanAppWebViewManager.this.d.onFirstImagePaintExt(bdSailorWebView, str);
            } else {
                super.onFirstImagePaintExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.this.d != null) {
                SwanAppWebViewManager.this.d.onFirstLayoutDidExt(bdSailorWebView, str);
            } else {
                super.onFirstLayoutDidExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstPaintDidEx");
            }
            if (SwanAppWebViewManager.this.d != null) {
                SwanAppWebViewManager.this.d.onFirstPaintDidExt(bdSailorWebView, str);
            } else {
                super.onFirstPaintDidExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstScreenPaintFinishedEx");
            }
            if (SwanAppWebViewManager.this.d != null) {
                SwanAppWebViewManager.this.d.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            } else {
                super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstTextPaintExt");
            }
            if (SwanAppWebViewManager.this.d != null) {
                SwanAppWebViewManager.this.d.onFirstTextPaintExt(bdSailorWebView, str);
            } else {
                super.onFirstTextPaintExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageBackOrForwardExt(BdSailorWebView bdSailorWebView, int i) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onGoBackOrForwardEx");
            }
            if (SwanAppWebViewManager.this.d != null) {
                SwanAppWebViewManager.this.d.onPageBackOrForwardExt(bdSailorWebView, i);
            } else {
                super.onPageBackOrForwardExt(bdSailorWebView, i);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageCanBeScaledExt(BdSailorWebView bdSailorWebView, boolean z) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onPageCanBeScaledEx");
            }
            if (SwanAppWebViewManager.this.d != null) {
                SwanAppWebViewManager.this.d.onPageCanBeScaledExt(bdSailorWebView, z);
            } else {
                super.onPageCanBeScaledExt(bdSailorWebView, z);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPreloadUrlFoundExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onPreloadUrlFoundEx：" + str);
            }
            if (SwanAppWebViewManager.this.d != null) {
                SwanAppWebViewManager.this.d.onPreloadUrlFoundExt(bdSailorWebView, str);
            } else {
                super.onPreloadUrlFoundExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFullScreenModeExt(BdSailorWebView bdSailorWebView, boolean z, int i, int i2) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFullScreenModeEx");
            }
            if (SwanAppWebViewManager.this.d != null) {
                SwanAppWebViewManager.this.d.onFullScreenModeExt(bdSailorWebView, z, i, i2);
            } else {
                super.onFullScreenModeExt(bdSailorWebView, z, i, i2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public String onGetErrorHtmlExt(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onGetErrorHtmlSailor");
            }
            if (SwanAppWebViewManager.this.d != null) {
                return SwanAppWebViewManager.this.d.onGetErrorHtmlExt(bdSailorWebView, i, str, str2);
            }
            return super.onGetErrorHtmlExt(bdSailorWebView, i, str, str2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onKeywordExtensionExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onKeywordExtensionEx");
            }
            if (SwanAppWebViewManager.this.d != null) {
                return SwanAppWebViewManager.this.d.onKeywordExtensionExt(bdSailorWebView, str, str2);
            }
            return super.onKeywordExtensionExt(bdSailorWebView, str, str2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onSecurityCheckResultExt(BdSailorWebView bdSailorWebView, String str, WebViewClient.SecurityInfo securityInfo) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onSecurityCheckResultEx");
            }
            if (SwanAppWebViewManager.this.d != null) {
                SwanAppWebViewManager.this.d.onSecurityCheckResultExt(bdSailorWebView, str, securityInfo);
            } else {
                super.onSecurityCheckResultExt(bdSailorWebView, str, securityInfo);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onUrlRedirectedExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onUrlRedirected");
            }
            if (SwanAppWebViewManager.this.d != null) {
                SwanAppWebViewManager.this.d.onUrlRedirectedExt(bdSailorWebView, str, str2);
            } else {
                super.onUrlRedirectedExt(bdSailorWebView, str, str2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onSubFrameBeforeRequest url: " + str);
            }
            if (SwanAppWebViewManager.this.d != null) {
                return SwanAppWebViewManager.this.d.onSubFrameBeforeRequest(bdSailorWebView, str);
            }
            return super.onSubFrameBeforeRequest(bdSailorWebView, str);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean shouldHandleImageExt(BdSailorWebView bdSailorWebView, String str, String str2, String str3, boolean z) {
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::canHandleImageEx");
            }
            if (SwanAppWebViewManager.this.d != null && SwanAppWebViewManager.this.d.shouldHandleImageExt(bdSailorWebView, str, str2, str3, z)) {
                return true;
            }
            return super.shouldHandleImageExt(bdSailorWebView, str, str2, str3, z);
        }
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.a;
            if (!str.startsWith("javascript:")) {
                str = "javascript:" + str;
            }
            if (SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "webview load js:" + str);
            }
            SwanAppWebViewManager.this.b.evaluateJavascript(str, null);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends sh2 {
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        public b(String str, String str2, String str3) {
            this.c = str;
            this.d = str2;
            this.e = str3;
        }

        @Override // com.baidu.tieba.sh2
        public void c() {
            SwanAppWebViewManager.this.E0(this.c, this.d, this.e);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements x23 {
        public final /* synthetic */ String a;
        public final /* synthetic */ GeolocationPermissions.Callback b;

        public c(String str, GeolocationPermissions.Callback callback) {
            this.a = str;
            this.b = callback;
        }

        @Override // com.baidu.tieba.x23
        public void a(String str) {
            if (SwanAppWebViewManager.v) {
                Log.w("SwanAppWebViewManager", "#handleLocationAuthorized(success) msg=" + str);
            }
            SwanAppWebViewManager.this.B0(this.a, this.b);
        }

        @Override // com.baidu.tieba.x23
        public void b(int i, String str) {
            if (SwanAppWebViewManager.v) {
                Log.e("SwanAppWebViewManager", "#handleLocationAuthorized(failed) msg=" + str);
            }
            SwanAppWebViewManager.this.W0(this.a, this.b);
        }
    }

    /* loaded from: classes3.dex */
    public class d {
        public boolean a = false;
        public boolean b = false;

        public d(SwanAppWebViewManager swanAppWebViewManager) {
        }
    }

    static {
        nd3.c();
        V8Engine.getInstance(0L);
    }

    public void D0() {
        br2.E0().a(this.b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cu1
    /* renamed from: G0 */
    public NgWebView r() {
        return this.b;
    }

    public void H0() {
        this.b.goBack();
    }

    @DebugTrace
    public final void J0() {
        U0(this.k);
        N0();
        Q0(this);
        K0();
        P0();
        M0();
        O0();
        V0();
        L0();
    }

    public final void K0() {
        if (this.g == null) {
            this.g = new UnitedSchemeMainDispatcher();
        }
    }

    public void M0() {
        this.u.e(this.b, this.a.getBaseContext(), this, this.g);
    }

    @Override // com.baidu.tieba.cu1
    @UiThread
    public void N() {
        this.b.onPause();
        this.b.pauseTimers();
    }

    @SuppressLint({"BDThrowableCheck"})
    public void P0() {
        if (this.g == null) {
            if (!v) {
                K0();
            } else {
                throw new IllegalStateException("initSwanAppDispatcher() must be called after initDispatcher()");
            }
        }
        this.h = n83.a(this.g);
    }

    @CallSuper
    public void S0() {
        kt2.a(this);
    }

    @CallSuper
    public void T0() {
        this.s = null;
        kt2.b(this);
    }

    public final void c1() {
        ISailorWebViewExt webViewExt = this.b.getWebViewExt();
        if (webViewExt != null) {
            webViewExt.emulateShiftHeldOnNormalTextExt();
        }
    }

    @Override // com.baidu.tieba.cu1
    public d d() {
        return this.k;
    }

    @Override // com.baidu.tieba.cu1
    public void destroy() {
        this.i.removeCallbacks(null);
        this.b.destroy();
        this.l.clear();
        T0();
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public String getCurrentPageUrl() {
        return r().getUrl();
    }

    @Override // com.baidu.tieba.cu1
    public String getUserAgent() {
        return this.p;
    }

    @Override // com.baidu.tieba.cu1
    @CallSuper
    public void onPause() {
        this.b.onPause();
        kt2.c(this);
    }

    @Override // com.baidu.tieba.cu1
    @CallSuper
    public void onResume() {
        this.b.onResume();
        kt2.d(this);
    }

    @Override // com.baidu.tieba.cu1
    @UiThread
    public void q() {
        this.b.onResume();
        this.b.resumeTimers();
    }

    public SwanAppWebViewManager(Context context) {
        this.a = new MutableContextWrapper(context);
        v62.k().l();
        J0();
        S0();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.g63
    /* renamed from: C0 */
    public NgWebView S(Context context) {
        this.a.setBaseContext(context);
        if (this.b == null) {
            N0();
        }
        return this.b;
    }

    public void Q0(SwanAppWebViewManager swanAppWebViewManager) {
        this.u.f(this.a.getBaseContext(), this.b);
    }

    public void R0(String str) {
        ol3.e0(new a(str));
    }

    @Override // com.baidu.tieba.cu1
    public void U(h92 h92Var) {
        if (h92Var != null && this.l.contains(h92Var)) {
            this.l.remove(h92Var);
        }
    }

    public final void X0(BdSailorWebChromeClient bdSailorWebChromeClient) {
        this.e = bdSailorWebChromeClient;
    }

    public final void Y0(BdSailorWebViewClient bdSailorWebViewClient) {
        this.c = bdSailorWebViewClient;
    }

    public final void Z0(BdSailorWebViewClientExt bdSailorWebViewClientExt) {
        this.d = bdSailorWebViewClientExt;
    }

    public void a1(int i) {
        this.t = i;
        if (v) {
            Log.d("SwanAppWebViewManager", "CustomView orientation has been set to [" + this.t + "] for once");
        }
    }

    @Override // com.baidu.tieba.cu1
    public void attachActivity(Activity activity) {
        if (v) {
            Log.i("SwanAppWebViewManager", "attachActivity");
        }
        if (activity == null) {
            if (v) {
                Log.e("SwanAppWebViewManager", "attachActivity null");
                return;
            }
            return;
        }
        this.u.a(activity);
        this.a.setBaseContext(activity);
    }

    @Override // com.baidu.tieba.cu1
    public void b(i62 i62Var) {
        this.j = i62Var;
    }

    @Override // com.baidu.swan.apps.core.container.view.SwanAppSelectPopView.a
    public void doSelectionCopy(String str) {
        D0();
        br2.E0().e(str, this.a.getBaseContext());
    }

    @Override // com.baidu.swan.apps.core.container.view.SwanAppSelectPopView.a
    public void doSelectionSearch(String str) {
        D0();
        br2.E0().d(str, this.a.getBaseContext());
    }

    @Override // com.baidu.tieba.cu1
    public void t(h92 h92Var) {
        if (h92Var != null && !this.l.contains(h92Var)) {
            this.l.add(h92Var);
        }
    }

    public final void B0(String str, GeolocationPermissions.Callback callback) {
        if (v) {
            Log.d("SwanAppWebViewManager", "allowGeoLocationOnce origin: " + str);
        }
        callback.invoke(str, true, false);
    }

    public final void I0(String str, GeolocationPermissions.Callback callback) {
        w23.e(h.g, new String[]{h.g, h.h}, 0, t73.K().w(), new c(str, callback));
    }

    public final void W0(String str, GeolocationPermissions.Callback callback) {
        if (v) {
            Log.d("SwanAppWebViewManager", "rejectGeoLocationOnce origin: " + str);
        }
        callback.invoke(str, false, false);
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public void handleSchemeDispatchCallback(String str, String str2) {
        String quote;
        if (TextUtils.isEmpty(str2)) {
            quote = "";
        } else {
            quote = JSONObject.quote(str2);
        }
        rh2.b().c(new b(str, str2, quote), str);
    }

    @Override // com.baidu.tieba.t62
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.b.canGoBack()) {
            H0();
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.t62
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        List<h92> list = this.l;
        if (list != null) {
            for (h92 h92Var : list) {
                if (h92Var != null) {
                    h92Var.onScrollChanged(i, i2, i3, i4);
                }
            }
        }
    }

    public final void E0(String str, String str2, String str3) {
        if (v) {
            Log.d("SwanAppWebViewManager", "handleSchemeDispatchCallback callback: " + str);
            Log.d("SwanAppWebViewManager", "handleSchemeDispatchCallback params: " + str2);
        }
        if (this.b.isDestroyed()) {
            if (v) {
                Log.e("SwanAppWebViewManager", "handleSchemeDispatchCallback webview is destroyed.");
                return;
            }
            return;
        }
        this.b.evaluateJavascript("javascript:" + str + "(" + str3 + SmallTailInfo.EMOTION_SUFFIX, null);
    }

    @Nullable
    public synchronized xo2 F0() {
        if (this.q == null) {
            if (!t73.K().q().I()) {
                return null;
            }
            SwanAppActivity w = t73.K().w();
            if (w == null) {
                return null;
            }
            this.q = new xo2(w, a());
        }
        return this.q;
    }

    public final void N0() {
        if (br2.g0().v()) {
            this.b = new NgWebView(this.a);
        } else {
            this.b = new NgWebView(this.a.getBaseContext());
        }
        if (this.b.getCurrentWebView() != null) {
            this.n = this.b.getCurrentWebView().getBackground();
            View webViewImpl = this.b.getWebViewImpl();
            if (webViewImpl != null) {
                this.o = webViewImpl.getBackground();
            }
        }
        if (this.k.a) {
            this.b.setBackgroundColorForSwanApp(0);
            if (!BdZeusUtil.isWebkitLoaded()) {
                this.m = true;
            }
        }
        this.b.setScrollBarStyle(0);
        this.f = new n72(this.a.getBaseContext());
        if (v) {
            Log.d("SwanAppWebViewManager", "WebViewManager " + hashCode() + " initializing Clients");
        }
        this.b.setWebViewClient(new SwanAppWebViewClient(this, null));
        this.b.setWebViewClientExt(new SwanAppWebViewClientExt(this, null));
        this.b.setWebChromeClient(new SwanAppWebChromeClient(this, null));
        this.b.setWebChromeClientExt(new SwanAppWebChromeClientExt(this, null));
        this.b.setOverScrollMode(2);
        this.b.setOnCommonEventHandler(this);
        this.b.setWebViewManager(this);
        this.b.getCurrentWebView().setLongClickable(true);
        this.b.setSelectPopWindowListener(this);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void O0() {
        BdSailorWebSettings settings = this.b.getSettings();
        ISailorWebSettingsExt settingsExt = this.b.getSettingsExt();
        settings.setWebViewFrameNameSailor(b0());
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
        String path = this.a.getDir("databases", 0).getPath();
        String path2 = this.a.getDir(NgWebView.APP_GEO_PATH, 0).getPath();
        String path3 = this.a.getDir(NgWebView.APP_CACHE_PATH, 0).getPath();
        settings.setGeolocationDatabasePath(path2);
        settings.setDatabasePath(path);
        settings.setAppCachePath(path3);
        if (((ActivityManager) this.a.getSystemService("activity")).getMemoryClass() > 16) {
            settings.setPageCacheCapacity(5);
        } else {
            settings.setPageCacheCapacity(1);
        }
        this.r = settings.getUserAgentString();
        b1(this.s);
        try {
            settings.setPluginState(WebSettings.PluginState.ON_DEMAND);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (NoClassDefFoundError e2) {
            e2.printStackTrace();
        }
    }

    public void b1(String str) {
        this.s = str;
        BdSailorWebSettings settings = this.b.getSettings();
        String str2 = this.r;
        if (!TextUtils.isEmpty(str)) {
            str2 = String.format("%s %s", str2, str);
        }
        String b2 = tj3.b(str2);
        if (!TextUtils.equals(b2, this.p)) {
            this.p = b2;
            settings.setUserAgentString(b2);
            if (v) {
                Log.i("SwanAppWebViewManager", "set ua:" + this.p);
            }
        }
    }

    public final void d1(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String path = Uri.parse(str).getPath();
        if (v) {
            Log.d("SwanAppWebViewManager", "pathList item: " + str + " ,folder: " + path + " ,parent: " + new File(path).getParent());
        }
        if (TextUtils.isEmpty(path)) {
            return;
        }
        this.b.getSettings().setCodeCacheSetting(n62.a("appframe", new File(path).getParent()));
    }

    @Override // com.baidu.tieba.cu1
    public void loadUrl(String str) {
        boolean z;
        if (this.b.getCurrentWebView().getWebView() instanceof android.webkit.WebView) {
            z = !((android.webkit.WebView) this.b.getCurrentWebView().getWebView()).getSettings().getAllowFileAccess();
        } else {
            z = false;
        }
        if (v) {
            Log.d("SwanAppWebViewManager", "isUseWebCompatLoadUrl: " + z);
        }
        if (z && !BdZeusUtil.isWebkitLoaded()) {
            String a2 = up4.b.a(str);
            d1(a2);
            this.b.loadUrl(a2);
            return;
        }
        d1(str);
        this.b.loadUrl(str);
    }
}
