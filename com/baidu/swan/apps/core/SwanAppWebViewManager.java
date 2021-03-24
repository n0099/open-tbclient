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
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.core.container.view.SwanAppSelectPopView;
import com.baidu.tbadk.core.data.SmallTailInfo;
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
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import d.b.g0.a.e0.g;
import d.b.g0.a.e0.i.a;
import d.b.g0.a.e0.m.b;
import d.b.g0.a.i2.h0;
import d.b.g0.a.i2.k0;
import d.b.g0.a.k;
import d.b.g0.a.r1.e;
import d.b.g0.a.t1.j;
import d.b.g0.a.v1.c.h;
import d.b.g0.a.v1.c.i.b;
import d.b.g0.a.z0.i;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class SwanAppWebViewManager implements d.b.g0.a.p.d.d<NgWebView>, d.b.g0.a.e0.k.b, d.b.g0.a.e0.k.c, d.b.g0.a.q1.a.e.a<NgWebView>, SwanAppSelectPopView.a {
    public static final boolean z = k.f45050a;

    /* renamed from: e  reason: collision with root package name */
    public MutableContextWrapper f12152e;

    /* renamed from: f  reason: collision with root package name */
    public NgWebView f12153f;

    /* renamed from: g  reason: collision with root package name */
    public BdSailorWebViewClient f12154g;

    /* renamed from: h  reason: collision with root package name */
    public BdSailorWebViewClientExt f12155h;
    public BdSailorWebChromeClient i;
    public d.b.g0.a.e0.m.b j;
    public UnitedSchemeMainDispatcher k;
    public j l;
    public g n;
    public String t;
    public d.b.g0.a.s0.j.b u;
    public String v;
    public String w;
    public Handler m = new Handler(Looper.getMainLooper());
    public final d o = new d(this);
    public List<d.b.g0.a.e0.n.c> p = new ArrayList();
    public boolean q = false;
    public Drawable r = null;
    public Drawable s = null;
    public int x = -1;
    public d.b.g0.a.x0.b.a y = new d.b.g0.a.x0.b.a();

    /* loaded from: classes3.dex */
    public class SwanAppWebChromeClient extends BdSailorWebChromeClient {

        /* loaded from: classes3.dex */
        public class a implements b.s {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ JsPromptResult f12156a;

            public a(SwanAppWebChromeClient swanAppWebChromeClient, JsPromptResult jsPromptResult) {
                this.f12156a = jsPromptResult;
            }

            @Override // d.b.g0.a.e0.m.b.s
            public void a() {
                this.f12156a.cancel();
            }

            @Override // d.b.g0.a.e0.m.b.s
            public void b(String str) {
                this.f12156a.confirm(str);
            }

            @Override // d.b.g0.a.e0.m.b.s
            public void onCancel() {
                this.f12156a.cancel();
            }
        }

        /* loaded from: classes3.dex */
        public class b implements b.s {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ JsResult f12157a;

            public b(SwanAppWebChromeClient swanAppWebChromeClient, JsResult jsResult) {
                this.f12157a = jsResult;
            }

            @Override // d.b.g0.a.e0.m.b.s
            public void a() {
                this.f12157a.cancel();
            }

            @Override // d.b.g0.a.e0.m.b.s
            public void b(String str) {
                this.f12157a.confirm();
            }

            @Override // d.b.g0.a.e0.m.b.s
            public void onCancel() {
                this.f12157a.cancel();
            }
        }

        /* loaded from: classes3.dex */
        public class c implements b.s {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ JsResult f12158a;

            public c(SwanAppWebChromeClient swanAppWebChromeClient, JsResult jsResult) {
                this.f12158a = jsResult;
            }

            @Override // d.b.g0.a.e0.m.b.s
            public void a() {
                this.f12158a.cancel();
            }

            @Override // d.b.g0.a.e0.m.b.s
            public void b(String str) {
                this.f12158a.confirm();
            }

            @Override // d.b.g0.a.e0.m.b.s
            public void onCancel() {
                this.f12158a.cancel();
            }
        }

        /* loaded from: classes3.dex */
        public class d implements d.b.g0.a.i2.u0.b<h<b.e>> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f12159e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ GeolocationPermissions.Callback f12160f;

            public d(String str, GeolocationPermissions.Callback callback) {
                this.f12159e = str;
                this.f12160f = callback;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.g0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(h<b.e> hVar) {
                if (d.b.g0.a.v1.c.c.h(hVar)) {
                    SwanAppWebViewManager.this.B0(this.f12159e, this.f12160f);
                } else {
                    SwanAppWebViewManager.this.P0(this.f12159e, this.f12160f);
                }
            }
        }

        public SwanAppWebChromeClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onCloseWindow(BdSailorWebView bdSailorWebView) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onCloseWindow");
            }
            if (SwanAppWebViewManager.this.i != null) {
                SwanAppWebViewManager.this.i.onCloseWindow(bdSailorWebView);
            } else {
                super.onCloseWindow(bdSailorWebView);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onConsoleMessage(BdSailorWebView bdSailorWebView, ConsoleMessage consoleMessage) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onConsoleMessage");
            }
            if (SwanAppWebViewManager.this.i == null || !SwanAppWebViewManager.this.i.onConsoleMessage(bdSailorWebView, consoleMessage)) {
                return super.onConsoleMessage(bdSailorWebView, consoleMessage);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onCreateWindow(BdSailorWebView bdSailorWebView, boolean z, boolean z2, Message message) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onCreateWindow");
            }
            if (SwanAppWebViewManager.this.i == null || !SwanAppWebViewManager.this.i.onCreateWindow(bdSailorWebView, z, z2, message)) {
                return super.onCreateWindow(bdSailorWebView, z, z2, message);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onExceededDatabaseQuota(BdSailorWebView bdSailorWebView, String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onExceededDatabaseQuota");
            }
            if (SwanAppWebViewManager.this.i != null) {
                SwanAppWebViewManager.this.i.onExceededDatabaseQuota(bdSailorWebView, str, str2, j, j2, j3, quotaUpdater);
            } else {
                super.onExceededDatabaseQuota(bdSailorWebView, str, str2, j, j2, j3, quotaUpdater);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onGeolocationPermissionsHidePrompt(BdSailorWebView bdSailorWebView) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onGeolocationPermissionsHidePrompt");
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onGeolocationPermissionsShowPrompt(BdSailorWebView bdSailorWebView, String str, GeolocationPermissions.Callback callback) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onGeolocationPermissionsShowPrompt");
            }
            e y = e.y();
            if (y == null || y.n() == null) {
                SwanAppWebViewManager.this.P0(str, callback);
            } else {
                y.R().g(y.n(), "mapp_location", new d(str, callback));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onHideCustomView(BdSailorWebView bdSailorWebView) {
            if (SwanAppWebViewManager.this.i != null ? SwanAppWebViewManager.this.i.onHideCustomView(bdSailorWebView) : false) {
                if (SwanAppWebViewManager.z) {
                    Log.i("SwanAppWebViewManager", "SwanAppWebChromeClient::onHideCustomView by external client");
                }
                return true;
            }
            if (SwanAppWebViewManager.this.y0() != null) {
                SwanAppWebViewManager.this.y0().d();
            }
            if (SwanAppWebViewManager.z) {
                Log.i("SwanAppWebViewManager", "SwanAppWebChromeClient::onHideCustomView");
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onJsAlert(BdSailorWebView bdSailorWebView, String str, String str2, JsResult jsResult) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onJsAlert");
            }
            return SwanAppWebViewManager.this.j.l(str, str2, new b(this, jsResult));
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onJsBeforeUnload(BdSailorWebView bdSailorWebView, String str, String str2, JsResult jsResult) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onJsBeforeUnload：" + str);
            }
            if (SwanAppWebViewManager.this.i == null || !SwanAppWebViewManager.this.i.onJsBeforeUnload(bdSailorWebView, str, str2, jsResult)) {
                return super.onJsBeforeUnload(bdSailorWebView, str, str2, jsResult);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onJsConfirm(BdSailorWebView bdSailorWebView, String str, String str2, JsResult jsResult) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onJsConfirm");
            }
            return SwanAppWebViewManager.this.j.m(str, str2, new c(this, jsResult));
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onJsPrompt(BdSailorWebView bdSailorWebView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onJsPrompt");
            }
            return SwanAppWebViewManager.this.j.n(str, str2, str3, new a(this, jsPromptResult));
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onJsTimeout(BdSailorWebView bdSailorWebView) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onJsTimeout  ");
            }
            if (SwanAppWebViewManager.this.i == null || !SwanAppWebViewManager.this.i.onJsTimeout(bdSailorWebView)) {
                return super.onJsTimeout(bdSailorWebView);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onProgressChanged(BdSailorWebView bdSailorWebView, int i) {
            if (SwanAppWebViewManager.this.i != null) {
                SwanAppWebViewManager.this.i.onProgressChanged(bdSailorWebView, i);
            } else {
                super.onProgressChanged(bdSailorWebView, i);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReachedMaxAppCacheSize(BdSailorWebView bdSailorWebView, long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onReachedMaxAppCacheSize");
            }
            if (SwanAppWebViewManager.this.i != null) {
                SwanAppWebViewManager.this.i.onReachedMaxAppCacheSize(bdSailorWebView, j, j2, quotaUpdater);
            } else {
                super.onReachedMaxAppCacheSize(bdSailorWebView, j, j2, quotaUpdater);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedIcon(BdSailorWebView bdSailorWebView, Bitmap bitmap) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onReachedMaxAppCacheSize");
            }
            if (SwanAppWebViewManager.this.i != null) {
                SwanAppWebViewManager.this.i.onReceivedIcon(bdSailorWebView, bitmap);
            } else {
                super.onReceivedIcon(bdSailorWebView, bitmap);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedTitle(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onReceivedTitleInFact : " + str);
            }
            if (SwanAppWebViewManager.this.i != null) {
                SwanAppWebViewManager.this.i.onReceivedTitle(bdSailorWebView, str);
            } else {
                super.onReceivedTitle(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedTouchIconUrl(BdSailorWebView bdSailorWebView, String str, boolean z) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onReceivedTouchIconUrl");
            }
            if (SwanAppWebViewManager.this.i != null) {
                SwanAppWebViewManager.this.i.onReceivedTouchIconUrl(bdSailorWebView, str, z);
            } else {
                super.onReceivedTouchIconUrl(bdSailorWebView, str, z);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onRequestFocus(BdSailorWebView bdSailorWebView) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onRequestFocus");
            }
            if (SwanAppWebViewManager.this.i != null) {
                SwanAppWebViewManager.this.i.onRequestFocus(bdSailorWebView);
            } else {
                super.onRequestFocus(bdSailorWebView);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onShowCustomView(BdSailorWebView bdSailorWebView, View view, WebChromeClient.CustomViewCallback customViewCallback) {
            int i = 0;
            if (SwanAppWebViewManager.this.i != null ? SwanAppWebViewManager.this.i.onShowCustomView(bdSailorWebView, view, customViewCallback) : false) {
                if (SwanAppWebViewManager.z) {
                    Log.i("SwanAppWebViewManager", "SwanAppWebChromeClient::onShowCustomView by external client");
                }
                return true;
            }
            if (SwanAppWebViewManager.this.x != -1) {
                i = SwanAppWebViewManager.this.x;
            } else {
                int i2 = d.b.g0.a.r1.d.e().f45729g;
                if (i2 >= 35 && i2 < 180) {
                    i = 8;
                }
            }
            onShowCustomView(bdSailorWebView, view, i, customViewCallback);
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onShowFileChooser(BdSailorWebView bdSailorWebView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            return super.onShowFileChooser(bdSailorWebView, valueCallback, fileChooserParams);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void openFileChooser(BdSailorWebView bdSailorWebView, ValueCallback valueCallback) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::openFileChooser");
            }
            if (SwanAppWebViewManager.this.i != null) {
                SwanAppWebViewManager.this.i.openFileChooser(bdSailorWebView, valueCallback);
            } else {
                super.openFileChooser(bdSailorWebView, valueCallback);
            }
        }

        public /* synthetic */ SwanAppWebChromeClient(SwanAppWebViewManager swanAppWebViewManager, a aVar) {
            this();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void openFileChooser(BdSailorWebView bdSailorWebView, ValueCallback valueCallback, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::openFileChooser");
            }
            if (SwanAppWebViewManager.this.i != null) {
                SwanAppWebViewManager.this.i.openFileChooser(bdSailorWebView, valueCallback, str);
            } else {
                super.openFileChooser(bdSailorWebView, valueCallback, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onShowCustomView(BdSailorWebView bdSailorWebView, View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
            SwanAppWebViewManager.this.x = -1;
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "CustomView orientation applied, set back to default [" + SwanAppWebViewManager.this.x + "]");
            }
            if (SwanAppWebViewManager.this.i != null ? SwanAppWebViewManager.this.i.onShowCustomView(bdSailorWebView, view, i, customViewCallback) : false) {
                if (SwanAppWebViewManager.z) {
                    Log.i("SwanAppWebViewManager", "SwanAppWebChromeClient::onShowCustomView by external client");
                }
                return true;
            }
            if (SwanAppWebViewManager.this.y0() != null) {
                SwanAppWebViewManager.this.y0().g(view, i, null);
            }
            if (SwanAppWebViewManager.z) {
                Log.i("SwanAppWebViewManager", "SwanAppWebChromeClient::onShowCustomView : " + i);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void openFileChooser(BdSailorWebView bdSailorWebView, ValueCallback valueCallback, String str, String str2) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::openFileChooser");
            }
            if (SwanAppWebViewManager.this.i != null) {
                SwanAppWebViewManager.this.i.openFileChooser(bdSailorWebView, valueCallback, str, str2);
            } else {
                super.openFileChooser(bdSailorWebView, valueCallback, str, str2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class SwanAppWebViewClient extends BdSailorWebViewClient {

        /* loaded from: classes3.dex */
        public class a implements b.t {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ SslErrorHandler f12163a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ BdSailorWebView f12164b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ SslError f12165c;

            public a(SslErrorHandler sslErrorHandler, BdSailorWebView bdSailorWebView, SslError sslError) {
                this.f12163a = sslErrorHandler;
                this.f12164b = bdSailorWebView;
                this.f12165c = sslError;
            }

            @Override // d.b.g0.a.e0.m.b.t
            public void a() {
                this.f12163a.proceed();
            }

            @Override // d.b.g0.a.e0.m.b.t
            public void b() {
                this.f12163a.cancel();
            }

            @Override // d.b.g0.a.e0.m.b.t
            public void c() {
                SwanAppWebViewClient.this.onReceivedSslError(this.f12164b, this.f12163a, this.f12165c);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements b.r {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ BdSailorWebView f12167a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f12168b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f12169c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ HttpAuthHandler f12170d;

            public b(SwanAppWebViewClient swanAppWebViewClient, BdSailorWebView bdSailorWebView, String str, String str2, HttpAuthHandler httpAuthHandler) {
                this.f12167a = bdSailorWebView;
                this.f12168b = str;
                this.f12169c = str2;
                this.f12170d = httpAuthHandler;
            }

            @Override // d.b.g0.a.e0.m.b.r
            public void a(String str, String str2) {
                BdSailorWebView bdSailorWebView = this.f12167a;
                if (bdSailorWebView != null) {
                    bdSailorWebView.setHttpAuthUsernamePassword(this.f12168b, this.f12169c, str, str2);
                }
                this.f12170d.proceed(str, str2);
            }

            @Override // d.b.g0.a.e0.m.b.r
            public void b() {
                this.f12170d.cancel();
            }
        }

        public SwanAppWebViewClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void doUpdateVisitedHistory(BdSailorWebView bdSailorWebView, String str, boolean z) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::doUpdateVisitedHistory");
            }
            if (SwanAppWebViewManager.this.f12154g != null) {
                SwanAppWebViewManager.this.f12154g.doUpdateVisitedHistory(bdSailorWebView, str, z);
            } else {
                super.doUpdateVisitedHistory(bdSailorWebView, str, z);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onFormResubmission(BdSailorWebView bdSailorWebView, Message message, Message message2) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFormResubmission");
            }
            if (SwanAppWebViewManager.this.f12154g != null) {
                SwanAppWebViewManager.this.f12154g.onFormResubmission(bdSailorWebView, message, message2);
            } else {
                super.onFormResubmission(bdSailorWebView, message, message2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onLoadResource(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onLoadResource：" + str);
            }
            if (SwanAppWebViewManager.this.f12154g != null) {
                SwanAppWebViewManager.this.f12154g.onLoadResource(bdSailorWebView, str);
            } else {
                super.onLoadResource(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onPageFinished url: " + str);
            }
            if (SwanAppWebViewManager.this.q) {
                WebView currentWebView = SwanAppWebViewManager.this.f12153f.getCurrentWebView();
                if (currentWebView != null) {
                    currentWebView.setBackground(SwanAppWebViewManager.this.r);
                    SwanAppWebViewManager.this.q = false;
                }
                AbsoluteLayout webViewImpl = SwanAppWebViewManager.this.f12153f.getWebViewImpl();
                if (webViewImpl != null) {
                    webViewImpl.setBackground(SwanAppWebViewManager.this.s);
                }
            }
            if (SwanAppWebViewManager.this.n != null) {
                SwanAppWebViewManager.this.n.a(str);
            }
            if (SwanAppWebViewManager.this.f12154g != null) {
                SwanAppWebViewManager.this.f12154g.onPageFinished(bdSailorWebView, str);
            } else {
                super.onPageFinished(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageStarted(BdSailorWebView bdSailorWebView, String str, Bitmap bitmap) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onPageStarted url: " + str);
            }
            if (SwanAppWebViewManager.this.f12154g != null) {
                SwanAppWebViewManager.this.f12154g.onPageStarted(bdSailorWebView, str, bitmap);
            } else {
                super.onPageStarted(bdSailorWebView, str, bitmap);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedClientCertRequest(BdSailorWebView bdSailorWebView, ClientCertRequest clientCertRequest) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedClientCertRequest");
            }
            if (SwanAppWebViewManager.this.f12154g != null) {
                SwanAppWebViewManager.this.f12154g.onReceivedClientCertRequest(bdSailorWebView, clientCertRequest);
            } else {
                super.onReceivedClientCertRequest(bdSailorWebView, clientCertRequest);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedError errorCode: " + i + " ,failingUrl: " + str2);
            }
            if (SwanAppWebViewManager.this.f12154g != null) {
                SwanAppWebViewManager.this.f12154g.onReceivedError(bdSailorWebView, i, str, str2);
            } else {
                super.onReceivedError(bdSailorWebView, i, str, str2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedHttpAuthRequest(BdSailorWebView bdSailorWebView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            String str3;
            String[] httpAuthUsernamePassword;
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedHttpAuthRequest");
            }
            String str4 = null;
            if (!httpAuthHandler.useHttpAuthUsernamePassword() || bdSailorWebView == null || (httpAuthUsernamePassword = bdSailorWebView.getHttpAuthUsernamePassword(str, str2)) == null || httpAuthUsernamePassword.length != 2) {
                str3 = null;
            } else {
                str4 = httpAuthUsernamePassword[0];
                str3 = httpAuthUsernamePassword[1];
            }
            if (str4 != null && str3 != null) {
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "OnReceivedHttpAuthRequest Reuse Http Auth Username & PassWord");
                }
                httpAuthHandler.proceed(str4, str3);
            } else if (SwanAppWebViewManager.this.f12153f.isShown()) {
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "OnReceivedHttpAuthRequest show Http Auth dialog ");
                }
                SwanAppWebViewManager.this.j.k(new b(this, bdSailorWebView, str, str2, httpAuthHandler), str, str2);
            } else {
                httpAuthHandler.cancel();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedHttpError(BdSailorWebView bdSailorWebView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            if (SwanAppWebViewManager.this.f12154g != null) {
                SwanAppWebViewManager.this.f12154g.onReceivedHttpError(bdSailorWebView, webResourceRequest, webResourceResponse);
            } else {
                super.onReceivedHttpError(bdSailorWebView, webResourceRequest, webResourceResponse);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedLoginRequest(BdSailorWebView bdSailorWebView, String str, String str2, String str3) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedLoginRequest");
            }
            if (SwanAppWebViewManager.this.f12154g != null) {
                SwanAppWebViewManager.this.f12154g.onReceivedLoginRequest(bdSailorWebView, str, str2, str3);
            } else {
                super.onReceivedLoginRequest(bdSailorWebView, str, str2, str3);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedSslError(BdSailorWebView bdSailorWebView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedSslError");
            }
            if (SwanAppWebViewManager.this.f12153f.isShown()) {
                SwanAppWebViewManager.this.j.p(new a(sslErrorHandler, bdSailorWebView, sslError), sslErrorHandler, sslError);
            } else {
                sslErrorHandler.cancel();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onScaleChanged(BdSailorWebView bdSailorWebView, float f2, float f3) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onScaleChanged");
            }
            if (SwanAppWebViewManager.this.f12154g != null) {
                SwanAppWebViewManager.this.f12154g.onScaleChanged(bdSailorWebView, f2, f3);
            } else {
                super.onScaleChanged(bdSailorWebView, f2, f3);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onUnhandledKeyEvent(BdSailorWebView bdSailorWebView, KeyEvent keyEvent) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onUnhandledKeyEvent");
            }
            if (SwanAppWebViewManager.this.f12154g != null) {
                SwanAppWebViewManager.this.f12154g.onUnhandledKeyEvent(bdSailorWebView, keyEvent);
            } else {
                super.onUnhandledKeyEvent(bdSailorWebView, keyEvent);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public WebResourceResponse shouldInterceptRequest(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::shouldInterceptRequest url: " + str);
            }
            if (SwanAppWebViewManager.this.f12154g != null) {
                return SwanAppWebViewManager.this.f12154g.shouldInterceptRequest(bdSailorWebView, str);
            }
            return super.shouldInterceptRequest(bdSailorWebView, str);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideKeyEvent(BdSailorWebView bdSailorWebView, KeyEvent keyEvent) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::shouldOverrideKeyEvent");
            }
            if (SwanAppWebViewManager.this.f12154g == null || !SwanAppWebViewManager.this.f12154g.shouldOverrideKeyEvent(bdSailorWebView, keyEvent)) {
                return super.shouldOverrideKeyEvent(bdSailorWebView, keyEvent);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::shouldOverrideUrlLoading url: " + str);
            }
            if (SwanAppWebViewManager.this.f12154g != null) {
                return SwanAppWebViewManager.this.f12154g.shouldOverrideUrlLoading(bdSailorWebView, str);
            }
            return true;
        }

        public /* synthetic */ SwanAppWebViewClient(SwanAppWebViewManager swanAppWebViewManager, a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public class SwanAppWebViewClientExt extends BdSailorWebViewClientExt {
        public SwanAppWebViewClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstContentfulPaintExt");
            }
            if (SwanAppWebViewManager.this.f12155h != null) {
                SwanAppWebViewManager.this.f12155h.onFirstContentfulPaintExt(bdSailorWebView, str);
            } else {
                super.onFirstContentfulPaintExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstImagePaintExt");
            }
            if (SwanAppWebViewManager.this.f12155h != null) {
                SwanAppWebViewManager.this.f12155h.onFirstImagePaintExt(bdSailorWebView, str);
            } else {
                super.onFirstImagePaintExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.this.f12155h != null) {
                SwanAppWebViewManager.this.f12155h.onFirstLayoutDidExt(bdSailorWebView, str);
            } else {
                super.onFirstLayoutDidExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstPaintDidEx");
            }
            if (SwanAppWebViewManager.this.f12155h != null) {
                SwanAppWebViewManager.this.f12155h.onFirstPaintDidExt(bdSailorWebView, str);
            } else {
                super.onFirstPaintDidExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstScreenPaintFinishedEx");
            }
            if (SwanAppWebViewManager.this.f12155h != null) {
                SwanAppWebViewManager.this.f12155h.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            } else {
                super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstTextPaintExt");
            }
            if (SwanAppWebViewManager.this.f12155h != null) {
                SwanAppWebViewManager.this.f12155h.onFirstTextPaintExt(bdSailorWebView, str);
            } else {
                super.onFirstTextPaintExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFullScreenModeExt(BdSailorWebView bdSailorWebView, boolean z, int i, int i2) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFullScreenModeEx");
            }
            if (SwanAppWebViewManager.this.f12155h != null) {
                SwanAppWebViewManager.this.f12155h.onFullScreenModeExt(bdSailorWebView, z, i, i2);
            } else {
                super.onFullScreenModeExt(bdSailorWebView, z, i, i2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public String onGetErrorHtmlExt(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onGetErrorHtmlSailor");
            }
            if (SwanAppWebViewManager.this.f12155h != null) {
                return SwanAppWebViewManager.this.f12155h.onGetErrorHtmlExt(bdSailorWebView, i, str, str2);
            }
            return super.onGetErrorHtmlExt(bdSailorWebView, i, str, str2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onKeywordExtensionExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onKeywordExtensionEx");
            }
            if (SwanAppWebViewManager.this.f12155h != null) {
                return SwanAppWebViewManager.this.f12155h.onKeywordExtensionExt(bdSailorWebView, str, str2);
            }
            return super.onKeywordExtensionExt(bdSailorWebView, str, str2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageBackOrForwardExt(BdSailorWebView bdSailorWebView, int i) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onGoBackOrForwardEx");
            }
            if (SwanAppWebViewManager.this.f12155h != null) {
                SwanAppWebViewManager.this.f12155h.onPageBackOrForwardExt(bdSailorWebView, i);
            } else {
                super.onPageBackOrForwardExt(bdSailorWebView, i);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageCanBeScaledExt(BdSailorWebView bdSailorWebView, boolean z) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onPageCanBeScaledEx");
            }
            if (SwanAppWebViewManager.this.f12155h != null) {
                SwanAppWebViewManager.this.f12155h.onPageCanBeScaledExt(bdSailorWebView, z);
            } else {
                super.onPageCanBeScaledExt(bdSailorWebView, z);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPreloadUrlFoundExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onPreloadUrlFoundEx：" + str);
            }
            if (SwanAppWebViewManager.this.f12155h != null) {
                SwanAppWebViewManager.this.f12155h.onPreloadUrlFoundExt(bdSailorWebView, str);
            } else {
                super.onPreloadUrlFoundExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onSecurityCheckResultExt(BdSailorWebView bdSailorWebView, String str, WebViewClient.SecurityInfo securityInfo) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onSecurityCheckResultEx");
            }
            if (SwanAppWebViewManager.this.f12155h != null) {
                SwanAppWebViewManager.this.f12155h.onSecurityCheckResultExt(bdSailorWebView, str, securityInfo);
            } else {
                super.onSecurityCheckResultExt(bdSailorWebView, str, securityInfo);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onSubFrameBeforeRequest url: " + str);
            }
            if (SwanAppWebViewManager.this.f12155h != null) {
                return SwanAppWebViewManager.this.f12155h.onSubFrameBeforeRequest(bdSailorWebView, str);
            }
            return super.onSubFrameBeforeRequest(bdSailorWebView, str);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onUrlRedirectedExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onUrlRedirected");
            }
            if (SwanAppWebViewManager.this.f12155h != null) {
                SwanAppWebViewManager.this.f12155h.onUrlRedirectedExt(bdSailorWebView, str, str2);
            } else {
                super.onUrlRedirectedExt(bdSailorWebView, str, str2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean shouldHandleImageExt(BdSailorWebView bdSailorWebView, String str, String str2, String str3, boolean z) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::canHandleImageEx");
            }
            if (SwanAppWebViewManager.this.f12155h == null || !SwanAppWebViewManager.this.f12155h.shouldHandleImageExt(bdSailorWebView, str, str2, str3, z)) {
                return super.shouldHandleImageExt(bdSailorWebView, str, str2, str3, z);
            }
            return true;
        }

        public /* synthetic */ SwanAppWebViewClientExt(SwanAppWebViewManager swanAppWebViewManager, a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f12171e;

        public a(String str) {
            this.f12171e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.f12171e;
            if (!str.startsWith("javascript:")) {
                str = "javascript:" + str;
            }
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "webview load js:" + str);
            }
            SwanAppWebViewManager.this.f12153f.evaluateJavascript(str, null);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f12173e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f12174f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f12175g;

        public b(String str, String str2, String str3) {
            this.f12173e = str;
            this.f12174f = str2;
            this.f12175g = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "handleSchemeDispatchCallback callback: " + this.f12173e);
                Log.d("SwanAppWebViewManager", "handleSchemeDispatchCallback params: " + this.f12174f);
            }
            if (SwanAppWebViewManager.this.f12153f.isDestroyed()) {
                if (SwanAppWebViewManager.z) {
                    Log.e("SwanAppWebViewManager", "handleSchemeDispatchCallback webview is destroyed.");
                    return;
                }
                return;
            }
            SwanAppWebViewManager.this.f12153f.evaluateJavascript("javascript:" + this.f12173e + "(" + this.f12175g + SmallTailInfo.EMOTION_SUFFIX, null);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.b.g0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f12177a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GeolocationPermissions.Callback f12178b;

        public c(String str, GeolocationPermissions.Callback callback) {
            this.f12177a = str;
            this.f12178b = callback;
        }

        @Override // d.b.g0.a.k1.b
        public void a(String str) {
            if (SwanAppWebViewManager.z) {
                Log.e("SwanAppWebViewManager", str + "");
            }
            SwanAppWebViewManager.this.v0(this.f12177a, this.f12178b);
        }

        @Override // d.b.g0.a.k1.b
        public void b(int i, String str) {
            if (SwanAppWebViewManager.z) {
                Log.e("SwanAppWebViewManager", str + "");
            }
            SwanAppWebViewManager.this.P0(this.f12177a, this.f12178b);
        }
    }

    /* loaded from: classes3.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public boolean f12180a = false;

        public d(SwanAppWebViewManager swanAppWebViewManager) {
        }
    }

    static {
        d.b.g0.g.i0.f.d.i();
        V8Engine.getInstance(0L);
    }

    public SwanAppWebViewManager(Context context) {
        this.f12152e = new MutableContextWrapper(context);
        d.b.g0.a.e0.k.d.a.k().l();
        C0();
        L0();
    }

    @Override // d.b.g0.a.p.d.d
    @UiThread
    public void A() {
        this.f12153f.onResume();
        this.f12153f.resumeTimers();
    }

    public void A0() {
        this.f12153f.goBack();
    }

    @SuppressLint({"NewApi"})
    public final void B0(String str, GeolocationPermissions.Callback callback) {
        d.b.g0.a.k1.a.a("android.permission.ACCESS_FINE_LOCATION", new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, d.b.g0.a.r1.d.e().n(), new c(str, callback));
    }

    @Override // d.b.g0.a.p.d.d
    @UiThread
    public void C() {
        this.f12153f.onPause();
        this.f12153f.pauseTimers();
    }

    @DebugTrace
    public final void C0() {
        N0(this.o);
        G0();
        J0(this);
        D0();
        I0();
        F0();
        H0();
        O0();
        E0();
    }

    public final void D0() {
        if (this.k == null) {
            this.k = new UnitedSchemeMainDispatcher();
        }
    }

    public abstract void E0();

    @Override // d.b.g0.a.p.d.d
    public void F(d.b.g0.a.e0.n.c cVar) {
        if (cVar == null || this.p.contains(cVar)) {
            return;
        }
        this.p.add(cVar);
    }

    public void F0() {
        this.y.e(this.f12153f, this.f12152e.getBaseContext(), this, this.k);
    }

    public final void G0() {
        if (d.b.g0.a.w0.a.N().n()) {
            this.f12153f = new NgWebView(this.f12152e);
        } else {
            this.f12153f = new NgWebView(this.f12152e.getBaseContext());
        }
        if (this.f12153f.getCurrentWebView() != null) {
            this.r = this.f12153f.getCurrentWebView().getBackground();
            AbsoluteLayout webViewImpl = this.f12153f.getWebViewImpl();
            if (webViewImpl != null) {
                this.s = webViewImpl.getBackground();
            }
        }
        if (this.o.f12180a) {
            this.f12153f.setBackgroundColorForSwanApp(0);
            if (!BdZeusUtil.isWebkitLoaded()) {
                this.q = true;
            }
        }
        this.f12153f.setScrollBarStyle(0);
        this.j = new d.b.g0.a.e0.m.b(this.f12152e.getBaseContext());
        if (z) {
            Log.d("SwanAppWebViewManager", "WebViewManager " + hashCode() + " initializing Clients");
        }
        this.f12153f.setWebViewClient(new SwanAppWebViewClient(this, null));
        this.f12153f.setWebViewClientExt(new SwanAppWebViewClientExt(this, null));
        this.f12153f.setWebChromeClient(new SwanAppWebChromeClient(this, null));
        this.f12153f.setWebChromeClientExt(new SwanAppWebChromeClientExt(this, null));
        this.f12153f.setOverScrollMode(2);
        this.f12153f.setOnCommonEventHandler(this);
        this.f12153f.setWebViewManager(this);
        this.f12153f.getCurrentWebView().setLongClickable(true);
        this.f12153f.setSelectPopWindowListener(this);
    }

    @Override // d.b.g0.a.p.d.d
    public void H(d.b.g0.a.e0.n.c cVar) {
        if (cVar != null && this.p.contains(cVar)) {
            this.p.remove(cVar);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void H0() {
        BdSailorWebSettings settings = this.f12153f.getSettings();
        ISailorWebSettingsExt settingsExt = this.f12153f.getSettingsExt();
        settings.setWebViewFrameNameSailor(S());
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
        String path = this.f12152e.getDir("databases", 0).getPath();
        String path2 = this.f12152e.getDir("geolocation", 0).getPath();
        String path3 = this.f12152e.getDir("appcache", 0).getPath();
        settings.setGeolocationDatabasePath(path2);
        settings.setDatabasePath(path);
        settings.setAppCachePath(path3);
        if (((ActivityManager) this.f12152e.getSystemService("activity")).getMemoryClass() > 16) {
            settings.setPageCacheCapacity(5);
        } else {
            settings.setPageCacheCapacity(1);
        }
        this.v = settings.getUserAgentString();
        U0(this.w);
        try {
            settings.setPluginState(WebSettings.PluginState.ON_DEMAND);
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (NoClassDefFoundError e3) {
            e3.printStackTrace();
        }
    }

    public void I0() {
        UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = this.k;
        if (unitedSchemeMainDispatcher != null) {
            this.l = d.b.g0.a.t1.e.a(unitedSchemeMainDispatcher);
            return;
        }
        throw new IllegalStateException("initSwanAppDispatcher() must be called after initDispatcher()");
    }

    public void J0(SwanAppWebViewManager swanAppWebViewManager) {
        this.y.f(this.f12152e.getBaseContext(), this.f12153f);
    }

    public void K0(String str) {
        k0.X(new a(str));
    }

    @CallSuper
    public void L0() {
        i.a(this);
    }

    @Override // d.b.g0.a.e0.k.c
    public boolean M(boolean z2) {
        return z2;
    }

    @CallSuper
    public void M0() {
        this.w = null;
        i.b(this);
    }

    public void N0(d dVar) {
    }

    public void O0() {
    }

    public final void P0(String str, GeolocationPermissions.Callback callback) {
        if (z) {
            Log.d("SwanAppWebViewManager", "rejectGeoLocationOnce origin: " + str);
        }
        callback.invoke(str, false, false);
    }

    public final void Q0(BdSailorWebChromeClient bdSailorWebChromeClient) {
        this.i = bdSailorWebChromeClient;
    }

    public final void R0(BdSailorWebViewClient bdSailorWebViewClient) {
        this.f12154g = bdSailorWebViewClient;
    }

    @Override // d.b.g0.a.p.d.d
    public String S() {
        return "ai_apps";
    }

    public final void S0(BdSailorWebViewClientExt bdSailorWebViewClientExt) {
        this.f12155h = bdSailorWebViewClientExt;
    }

    public void T0(int i) {
        this.x = i;
        if (z) {
            Log.d("SwanAppWebViewManager", "CustomView orientation has been set to [" + this.x + "] for once");
        }
    }

    public void U0(String str) {
        this.w = str;
        BdSailorWebSettings settings = this.f12153f.getSettings();
        String str2 = this.v;
        if (!TextUtils.isEmpty(str)) {
            str2 = String.format("%s %s", str2, str);
        }
        String b2 = d.b.g0.a.g2.a.b(str2);
        if (TextUtils.equals(b2, this.t)) {
            return;
        }
        this.t = b2;
        settings.setUserAgentString(b2);
        if (z) {
            Log.i("SwanAppWebViewManager", "set ua:" + this.t);
        }
    }

    public final void V0() {
        ISailorWebViewExt webViewExt = this.f12153f.getWebViewExt();
        if (webViewExt != null) {
            webViewExt.emulateShiftHeldOnNormalTextExt();
        }
    }

    @Override // d.b.g0.a.p.d.d
    public void W() {
    }

    public final void W0(String str) {
        if (a.b.h(0) && !TextUtils.isEmpty(str)) {
            String path = Uri.parse(str).getPath();
            if (z) {
                Log.d("SwanAppWebViewManager", "pathList item: " + str + " ,folder: " + path + " ,parent: " + new File(path).getParent());
            }
            if (TextUtils.isEmpty(path)) {
                return;
            }
            this.f12153f.getSettings().setCodeCacheSetting(d.b.g0.a.e0.i.b.a("appframe", new File(path).getParent()));
        }
    }

    @Override // d.b.g0.a.p.d.d
    public String b() {
        return this.t;
    }

    @Override // d.b.g0.a.p.d.d
    public abstract String c();

    @Override // d.b.g0.a.p.d.d
    public void d(Activity activity) {
        if (z) {
            Log.i("SwanAppWebViewManager", "attachActivity");
        }
        if (activity == null) {
            if (z) {
                Log.e("SwanAppWebViewManager", "attachActivity null");
                return;
            }
            return;
        }
        this.y.a(activity);
        this.f12152e.setBaseContext(activity);
    }

    @Override // d.b.g0.a.p.d.d
    public void destroy() {
        this.m.removeCallbacks(null);
        this.f12153f.destroy();
        this.p.clear();
        M0();
    }

    @Override // d.b.g0.a.e0.k.b
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.swan.apps.core.container.view.SwanAppSelectPopView.a
    public void doSelectionCopy(String str) {
        x0();
        d.b.g0.a.w0.a.f0().a(str, this.f12152e.getBaseContext());
    }

    @Override // com.baidu.swan.apps.core.container.view.SwanAppSelectPopView.a
    public void doSelectionSearch(String str) {
        x0();
        d.b.g0.a.w0.a.f0().e(str, this.f12152e.getBaseContext());
    }

    @Override // d.b.g0.a.p.d.d
    public void e(g gVar) {
        this.n = gVar;
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public String getCurrentPageUrl() {
        return getWebView().getUrl();
    }

    @Override // com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        return 0;
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public void handleSchemeDispatchCallback(String str, String str2) {
        this.m.post(new b(str, str2, TextUtils.isEmpty(str2) ? "" : JSONObject.quote(str2)));
    }

    @Override // d.b.g0.a.p.d.d
    public void loadUrl(String str) {
        W0(str);
        this.f12153f.loadUrl(str);
    }

    @Override // d.b.g0.a.p.d.d
    public void onJSLoaded() {
    }

    @Override // d.b.g0.a.e0.k.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.f12153f.canGoBack()) {
            A0();
            return true;
        }
        return false;
    }

    @Override // d.b.g0.a.p.d.d
    @CallSuper
    public void onPause() {
        this.f12153f.onPause();
        i.c(this);
    }

    @Override // d.b.g0.a.p.d.d
    @CallSuper
    public void onResume() {
        this.f12153f.onResume();
        i.d(this);
    }

    @Override // d.b.g0.a.e0.k.b
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        List<d.b.g0.a.e0.n.c> list = this.p;
        if (list != null) {
            for (d.b.g0.a.e0.n.c cVar : list) {
                if (cVar != null) {
                    cVar.onScrollChanged(i, i2, i3, i4);
                }
            }
        }
    }

    @Override // d.b.g0.a.e0.k.b
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // d.b.g0.a.e0.k.c
    public boolean u() {
        return false;
    }

    public final void v0(String str, GeolocationPermissions.Callback callback) {
        if (z) {
            Log.d("SwanAppWebViewManager", "allowGeoLocationOnce origin: " + str);
        }
        callback.invoke(str, true, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.q1.a.e.a
    /* renamed from: w0 */
    public NgWebView G(Context context) {
        this.f12152e.setBaseContext(context);
        if (this.f12153f == null) {
            G0();
        }
        return this.f12153f;
    }

    public void x0() {
        d.b.g0.a.w0.a.f0().b(this.f12153f);
    }

    @Nullable
    public synchronized d.b.g0.a.s0.j.b y0() {
        if (this.u == null) {
            if (!d.b.g0.a.r1.d.e().s().d()) {
                return null;
            }
            SwanAppActivity n = d.b.g0.a.r1.d.e().n();
            if (n == null) {
                return null;
            }
            this.u = new d.b.g0.a.s0.j.b(n, c());
        }
        return this.u;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.p.d.d
    /* renamed from: z0 */
    public NgWebView getWebView() {
        return this.f12153f;
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
                d.b.g0.a.c0.c.a("SwanAppWebViewManager", "onReceiveValue: " + str);
                JsonReader jsonReader = new JsonReader(new StringReader(str));
                jsonReader.setLenient(true);
                try {
                    try {
                        if (jsonReader.peek() != JsonToken.NULL && jsonReader.peek() == JsonToken.STRING) {
                            String nextString = jsonReader.nextString();
                            if (!TextUtils.isEmpty(nextString)) {
                                d.b.g0.a.w0.a.f0().c(SwanAppWebViewManager.this.f12153f, nextString);
                            }
                        }
                    } catch (IOException e2) {
                        if (SwanAppWebViewManager.z) {
                            e2.printStackTrace();
                        }
                    }
                } finally {
                    d.b.g0.p.d.a(jsonReader);
                }
            }
        }

        public SwanAppWebChromeClientExt() {
            this.mIsFirstTimeShow = true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClientExt
        public void hideSelectionActionDialogExt(BdSailorWebView bdSailorWebView) {
            super.hideSelectionActionDialogExt(bdSailorWebView);
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "hideSelectionActionDialogExt: ");
            }
            SwanAppWebViewManager.this.f12153f.hidePopWindow();
            this.mIsFirstTimeShow = true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClientExt
        @SuppressLint({"DefaultLocale"})
        public void performLongClickExt(BdSailorWebView bdSailorWebView, WebView.HitTestResult hitTestResult, int i, int i2) {
            super.performLongClickExt(bdSailorWebView, hitTestResult, i, i2);
            if (hitTestResult == null) {
                return;
            }
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "performLongClickExt: " + hitTestResult.getType() + ZeusCrashHandler.NAME_SEPERATOR + i + ZeusCrashHandler.NAME_SEPERATOR + i2);
            }
            int type = hitTestResult.getType();
            if (type == 10) {
                SwanAppWebViewManager.this.V0();
            } else if (type == 5) {
                SwanAppWebViewManager.this.f12153f.evaluateJavascript(String.format("javascript:(function(){return window.getImageSrcByCoordinate(%s,%s);})()", Integer.valueOf(h0.H(i)), Integer.valueOf(h0.H(i2))), new a());
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClientExt
        public void showSelectionActionDialogExt(BdSailorWebView bdSailorWebView, int i, int i2, int i3, int i4, String str) {
            super.showSelectionActionDialogExt(bdSailorWebView, i, i2, i3, i4, str);
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "showSelectionActionDialogExt: " + i3 + ZeusCrashHandler.NAME_SEPERATOR + i4 + ZeusCrashHandler.NAME_SEPERATOR + i + ZeusCrashHandler.NAME_SEPERATOR + i2 + ZeusCrashHandler.NAME_SEPERATOR + str);
            }
            d.b.g0.a.w0.a.f0().d(SwanAppWebViewManager.this.f12153f, i, i2, i3, i4, str, this.mIsFirstTimeShow);
            this.mIsFirstTimeShow = false;
        }

        public /* synthetic */ SwanAppWebChromeClientExt(SwanAppWebViewManager swanAppWebViewManager, a aVar) {
            this();
        }
    }
}
