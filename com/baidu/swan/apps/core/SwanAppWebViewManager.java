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
import d.b.h0.a.e0.g;
import d.b.h0.a.e0.i.a;
import d.b.h0.a.e0.m.b;
import d.b.h0.a.i2.h0;
import d.b.h0.a.i2.k0;
import d.b.h0.a.k;
import d.b.h0.a.r1.e;
import d.b.h0.a.t1.j;
import d.b.h0.a.v1.c.h;
import d.b.h0.a.v1.c.i.b;
import d.b.h0.a.z0.i;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class SwanAppWebViewManager implements d.b.h0.a.p.d.d<NgWebView>, d.b.h0.a.e0.k.b, d.b.h0.a.e0.k.c, d.b.h0.a.q1.a.e.a<NgWebView>, SwanAppSelectPopView.a {
    public static final boolean z = k.f45772a;

    /* renamed from: e  reason: collision with root package name */
    public MutableContextWrapper f11822e;

    /* renamed from: f  reason: collision with root package name */
    public NgWebView f11823f;

    /* renamed from: g  reason: collision with root package name */
    public BdSailorWebViewClient f11824g;

    /* renamed from: h  reason: collision with root package name */
    public BdSailorWebViewClientExt f11825h;
    public BdSailorWebChromeClient i;
    public d.b.h0.a.e0.m.b j;
    public UnitedSchemeMainDispatcher k;
    public j l;
    public g n;
    public String t;
    public d.b.h0.a.s0.j.b u;
    public String v;
    public String w;
    public Handler m = new Handler(Looper.getMainLooper());
    public final d o = new d(this);
    public List<d.b.h0.a.e0.n.c> p = new ArrayList();
    public boolean q = false;
    public Drawable r = null;
    public Drawable s = null;
    public int x = -1;
    public d.b.h0.a.x0.b.a y = new d.b.h0.a.x0.b.a();

    /* loaded from: classes2.dex */
    public class SwanAppWebChromeClient extends BdSailorWebChromeClient {

        /* loaded from: classes2.dex */
        public class a implements b.s {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ JsPromptResult f11826a;

            public a(SwanAppWebChromeClient swanAppWebChromeClient, JsPromptResult jsPromptResult) {
                this.f11826a = jsPromptResult;
            }

            @Override // d.b.h0.a.e0.m.b.s
            public void a() {
                this.f11826a.cancel();
            }

            @Override // d.b.h0.a.e0.m.b.s
            public void b(String str) {
                this.f11826a.confirm(str);
            }

            @Override // d.b.h0.a.e0.m.b.s
            public void onCancel() {
                this.f11826a.cancel();
            }
        }

        /* loaded from: classes2.dex */
        public class b implements b.s {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ JsResult f11827a;

            public b(SwanAppWebChromeClient swanAppWebChromeClient, JsResult jsResult) {
                this.f11827a = jsResult;
            }

            @Override // d.b.h0.a.e0.m.b.s
            public void a() {
                this.f11827a.cancel();
            }

            @Override // d.b.h0.a.e0.m.b.s
            public void b(String str) {
                this.f11827a.confirm();
            }

            @Override // d.b.h0.a.e0.m.b.s
            public void onCancel() {
                this.f11827a.cancel();
            }
        }

        /* loaded from: classes2.dex */
        public class c implements b.s {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ JsResult f11828a;

            public c(SwanAppWebChromeClient swanAppWebChromeClient, JsResult jsResult) {
                this.f11828a = jsResult;
            }

            @Override // d.b.h0.a.e0.m.b.s
            public void a() {
                this.f11828a.cancel();
            }

            @Override // d.b.h0.a.e0.m.b.s
            public void b(String str) {
                this.f11828a.confirm();
            }

            @Override // d.b.h0.a.e0.m.b.s
            public void onCancel() {
                this.f11828a.cancel();
            }
        }

        /* loaded from: classes2.dex */
        public class d implements d.b.h0.a.i2.u0.b<h<b.e>> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f11829e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ GeolocationPermissions.Callback f11830f;

            public d(String str, GeolocationPermissions.Callback callback) {
                this.f11829e = str;
                this.f11830f = callback;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(h<b.e> hVar) {
                if (d.b.h0.a.v1.c.c.h(hVar)) {
                    SwanAppWebViewManager.this.C0(this.f11829e, this.f11830f);
                } else {
                    SwanAppWebViewManager.this.Q0(this.f11829e, this.f11830f);
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
                SwanAppWebViewManager.this.Q0(str, callback);
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
            if (SwanAppWebViewManager.this.z0() != null) {
                SwanAppWebViewManager.this.z0().d();
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
                int i2 = d.b.h0.a.r1.d.e().f46451g;
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
            if (SwanAppWebViewManager.this.z0() != null) {
                SwanAppWebViewManager.this.z0().g(view, i, null);
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

    /* loaded from: classes2.dex */
    public class SwanAppWebViewClient extends BdSailorWebViewClient {

        /* loaded from: classes2.dex */
        public class a implements b.t {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ SslErrorHandler f11833a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ BdSailorWebView f11834b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ SslError f11835c;

            public a(SslErrorHandler sslErrorHandler, BdSailorWebView bdSailorWebView, SslError sslError) {
                this.f11833a = sslErrorHandler;
                this.f11834b = bdSailorWebView;
                this.f11835c = sslError;
            }

            @Override // d.b.h0.a.e0.m.b.t
            public void a() {
                this.f11833a.proceed();
            }

            @Override // d.b.h0.a.e0.m.b.t
            public void b() {
                this.f11833a.cancel();
            }

            @Override // d.b.h0.a.e0.m.b.t
            public void c() {
                SwanAppWebViewClient.this.onReceivedSslError(this.f11834b, this.f11833a, this.f11835c);
            }
        }

        /* loaded from: classes2.dex */
        public class b implements b.r {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ BdSailorWebView f11837a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f11838b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f11839c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ HttpAuthHandler f11840d;

            public b(SwanAppWebViewClient swanAppWebViewClient, BdSailorWebView bdSailorWebView, String str, String str2, HttpAuthHandler httpAuthHandler) {
                this.f11837a = bdSailorWebView;
                this.f11838b = str;
                this.f11839c = str2;
                this.f11840d = httpAuthHandler;
            }

            @Override // d.b.h0.a.e0.m.b.r
            public void a(String str, String str2) {
                BdSailorWebView bdSailorWebView = this.f11837a;
                if (bdSailorWebView != null) {
                    bdSailorWebView.setHttpAuthUsernamePassword(this.f11838b, this.f11839c, str, str2);
                }
                this.f11840d.proceed(str, str2);
            }

            @Override // d.b.h0.a.e0.m.b.r
            public void b() {
                this.f11840d.cancel();
            }
        }

        public SwanAppWebViewClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void doUpdateVisitedHistory(BdSailorWebView bdSailorWebView, String str, boolean z) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::doUpdateVisitedHistory");
            }
            if (SwanAppWebViewManager.this.f11824g != null) {
                SwanAppWebViewManager.this.f11824g.doUpdateVisitedHistory(bdSailorWebView, str, z);
            } else {
                super.doUpdateVisitedHistory(bdSailorWebView, str, z);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onFormResubmission(BdSailorWebView bdSailorWebView, Message message, Message message2) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFormResubmission");
            }
            if (SwanAppWebViewManager.this.f11824g != null) {
                SwanAppWebViewManager.this.f11824g.onFormResubmission(bdSailorWebView, message, message2);
            } else {
                super.onFormResubmission(bdSailorWebView, message, message2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onLoadResource(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onLoadResource：" + str);
            }
            if (SwanAppWebViewManager.this.f11824g != null) {
                SwanAppWebViewManager.this.f11824g.onLoadResource(bdSailorWebView, str);
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
                WebView currentWebView = SwanAppWebViewManager.this.f11823f.getCurrentWebView();
                if (currentWebView != null) {
                    currentWebView.setBackground(SwanAppWebViewManager.this.r);
                    SwanAppWebViewManager.this.q = false;
                }
                AbsoluteLayout webViewImpl = SwanAppWebViewManager.this.f11823f.getWebViewImpl();
                if (webViewImpl != null) {
                    webViewImpl.setBackground(SwanAppWebViewManager.this.s);
                }
            }
            if (SwanAppWebViewManager.this.n != null) {
                SwanAppWebViewManager.this.n.a(str);
            }
            if (SwanAppWebViewManager.this.f11824g != null) {
                SwanAppWebViewManager.this.f11824g.onPageFinished(bdSailorWebView, str);
            } else {
                super.onPageFinished(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageStarted(BdSailorWebView bdSailorWebView, String str, Bitmap bitmap) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onPageStarted url: " + str);
            }
            if (SwanAppWebViewManager.this.f11824g != null) {
                SwanAppWebViewManager.this.f11824g.onPageStarted(bdSailorWebView, str, bitmap);
            } else {
                super.onPageStarted(bdSailorWebView, str, bitmap);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedClientCertRequest(BdSailorWebView bdSailorWebView, ClientCertRequest clientCertRequest) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedClientCertRequest");
            }
            if (SwanAppWebViewManager.this.f11824g != null) {
                SwanAppWebViewManager.this.f11824g.onReceivedClientCertRequest(bdSailorWebView, clientCertRequest);
            } else {
                super.onReceivedClientCertRequest(bdSailorWebView, clientCertRequest);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedError errorCode: " + i + " ,failingUrl: " + str2);
            }
            if (SwanAppWebViewManager.this.f11824g != null) {
                SwanAppWebViewManager.this.f11824g.onReceivedError(bdSailorWebView, i, str, str2);
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
            } else if (SwanAppWebViewManager.this.f11823f.isShown()) {
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
            if (SwanAppWebViewManager.this.f11824g != null) {
                SwanAppWebViewManager.this.f11824g.onReceivedHttpError(bdSailorWebView, webResourceRequest, webResourceResponse);
            } else {
                super.onReceivedHttpError(bdSailorWebView, webResourceRequest, webResourceResponse);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedLoginRequest(BdSailorWebView bdSailorWebView, String str, String str2, String str3) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedLoginRequest");
            }
            if (SwanAppWebViewManager.this.f11824g != null) {
                SwanAppWebViewManager.this.f11824g.onReceivedLoginRequest(bdSailorWebView, str, str2, str3);
            } else {
                super.onReceivedLoginRequest(bdSailorWebView, str, str2, str3);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedSslError(BdSailorWebView bdSailorWebView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedSslError");
            }
            if (SwanAppWebViewManager.this.f11823f.isShown()) {
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
            if (SwanAppWebViewManager.this.f11824g != null) {
                SwanAppWebViewManager.this.f11824g.onScaleChanged(bdSailorWebView, f2, f3);
            } else {
                super.onScaleChanged(bdSailorWebView, f2, f3);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onUnhandledKeyEvent(BdSailorWebView bdSailorWebView, KeyEvent keyEvent) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onUnhandledKeyEvent");
            }
            if (SwanAppWebViewManager.this.f11824g != null) {
                SwanAppWebViewManager.this.f11824g.onUnhandledKeyEvent(bdSailorWebView, keyEvent);
            } else {
                super.onUnhandledKeyEvent(bdSailorWebView, keyEvent);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public WebResourceResponse shouldInterceptRequest(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::shouldInterceptRequest url: " + str);
            }
            if (SwanAppWebViewManager.this.f11824g != null) {
                return SwanAppWebViewManager.this.f11824g.shouldInterceptRequest(bdSailorWebView, str);
            }
            return super.shouldInterceptRequest(bdSailorWebView, str);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideKeyEvent(BdSailorWebView bdSailorWebView, KeyEvent keyEvent) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::shouldOverrideKeyEvent");
            }
            if (SwanAppWebViewManager.this.f11824g == null || !SwanAppWebViewManager.this.f11824g.shouldOverrideKeyEvent(bdSailorWebView, keyEvent)) {
                return super.shouldOverrideKeyEvent(bdSailorWebView, keyEvent);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::shouldOverrideUrlLoading url: " + str);
            }
            if (SwanAppWebViewManager.this.f11824g != null) {
                return SwanAppWebViewManager.this.f11824g.shouldOverrideUrlLoading(bdSailorWebView, str);
            }
            return true;
        }

        public /* synthetic */ SwanAppWebViewClient(SwanAppWebViewManager swanAppWebViewManager, a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public class SwanAppWebViewClientExt extends BdSailorWebViewClientExt {
        public SwanAppWebViewClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstContentfulPaintExt");
            }
            if (SwanAppWebViewManager.this.f11825h != null) {
                SwanAppWebViewManager.this.f11825h.onFirstContentfulPaintExt(bdSailorWebView, str);
            } else {
                super.onFirstContentfulPaintExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstImagePaintExt");
            }
            if (SwanAppWebViewManager.this.f11825h != null) {
                SwanAppWebViewManager.this.f11825h.onFirstImagePaintExt(bdSailorWebView, str);
            } else {
                super.onFirstImagePaintExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.this.f11825h != null) {
                SwanAppWebViewManager.this.f11825h.onFirstLayoutDidExt(bdSailorWebView, str);
            } else {
                super.onFirstLayoutDidExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstPaintDidEx");
            }
            if (SwanAppWebViewManager.this.f11825h != null) {
                SwanAppWebViewManager.this.f11825h.onFirstPaintDidExt(bdSailorWebView, str);
            } else {
                super.onFirstPaintDidExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstScreenPaintFinishedEx");
            }
            if (SwanAppWebViewManager.this.f11825h != null) {
                SwanAppWebViewManager.this.f11825h.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            } else {
                super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstTextPaintExt");
            }
            if (SwanAppWebViewManager.this.f11825h != null) {
                SwanAppWebViewManager.this.f11825h.onFirstTextPaintExt(bdSailorWebView, str);
            } else {
                super.onFirstTextPaintExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFullScreenModeExt(BdSailorWebView bdSailorWebView, boolean z, int i, int i2) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFullScreenModeEx");
            }
            if (SwanAppWebViewManager.this.f11825h != null) {
                SwanAppWebViewManager.this.f11825h.onFullScreenModeExt(bdSailorWebView, z, i, i2);
            } else {
                super.onFullScreenModeExt(bdSailorWebView, z, i, i2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public String onGetErrorHtmlExt(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onGetErrorHtmlSailor");
            }
            if (SwanAppWebViewManager.this.f11825h != null) {
                return SwanAppWebViewManager.this.f11825h.onGetErrorHtmlExt(bdSailorWebView, i, str, str2);
            }
            return super.onGetErrorHtmlExt(bdSailorWebView, i, str, str2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onKeywordExtensionExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onKeywordExtensionEx");
            }
            if (SwanAppWebViewManager.this.f11825h != null) {
                return SwanAppWebViewManager.this.f11825h.onKeywordExtensionExt(bdSailorWebView, str, str2);
            }
            return super.onKeywordExtensionExt(bdSailorWebView, str, str2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageBackOrForwardExt(BdSailorWebView bdSailorWebView, int i) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onGoBackOrForwardEx");
            }
            if (SwanAppWebViewManager.this.f11825h != null) {
                SwanAppWebViewManager.this.f11825h.onPageBackOrForwardExt(bdSailorWebView, i);
            } else {
                super.onPageBackOrForwardExt(bdSailorWebView, i);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageCanBeScaledExt(BdSailorWebView bdSailorWebView, boolean z) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onPageCanBeScaledEx");
            }
            if (SwanAppWebViewManager.this.f11825h != null) {
                SwanAppWebViewManager.this.f11825h.onPageCanBeScaledExt(bdSailorWebView, z);
            } else {
                super.onPageCanBeScaledExt(bdSailorWebView, z);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPreloadUrlFoundExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onPreloadUrlFoundEx：" + str);
            }
            if (SwanAppWebViewManager.this.f11825h != null) {
                SwanAppWebViewManager.this.f11825h.onPreloadUrlFoundExt(bdSailorWebView, str);
            } else {
                super.onPreloadUrlFoundExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onSecurityCheckResultExt(BdSailorWebView bdSailorWebView, String str, WebViewClient.SecurityInfo securityInfo) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onSecurityCheckResultEx");
            }
            if (SwanAppWebViewManager.this.f11825h != null) {
                SwanAppWebViewManager.this.f11825h.onSecurityCheckResultExt(bdSailorWebView, str, securityInfo);
            } else {
                super.onSecurityCheckResultExt(bdSailorWebView, str, securityInfo);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onSubFrameBeforeRequest url: " + str);
            }
            if (SwanAppWebViewManager.this.f11825h != null) {
                return SwanAppWebViewManager.this.f11825h.onSubFrameBeforeRequest(bdSailorWebView, str);
            }
            return super.onSubFrameBeforeRequest(bdSailorWebView, str);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onUrlRedirectedExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onUrlRedirected");
            }
            if (SwanAppWebViewManager.this.f11825h != null) {
                SwanAppWebViewManager.this.f11825h.onUrlRedirectedExt(bdSailorWebView, str, str2);
            } else {
                super.onUrlRedirectedExt(bdSailorWebView, str, str2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean shouldHandleImageExt(BdSailorWebView bdSailorWebView, String str, String str2, String str3, boolean z) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::canHandleImageEx");
            }
            if (SwanAppWebViewManager.this.f11825h == null || !SwanAppWebViewManager.this.f11825h.shouldHandleImageExt(bdSailorWebView, str, str2, str3, z)) {
                return super.shouldHandleImageExt(bdSailorWebView, str, str2, str3, z);
            }
            return true;
        }

        public /* synthetic */ SwanAppWebViewClientExt(SwanAppWebViewManager swanAppWebViewManager, a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11841e;

        public a(String str) {
            this.f11841e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.f11841e;
            if (!str.startsWith("javascript:")) {
                str = "javascript:" + str;
            }
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "webview load js:" + str);
            }
            SwanAppWebViewManager.this.f11823f.evaluateJavascript(str, null);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11843e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f11844f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f11845g;

        public b(String str, String str2, String str3) {
            this.f11843e = str;
            this.f11844f = str2;
            this.f11845g = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "handleSchemeDispatchCallback callback: " + this.f11843e);
                Log.d("SwanAppWebViewManager", "handleSchemeDispatchCallback params: " + this.f11844f);
            }
            if (SwanAppWebViewManager.this.f11823f.isDestroyed()) {
                if (SwanAppWebViewManager.z) {
                    Log.e("SwanAppWebViewManager", "handleSchemeDispatchCallback webview is destroyed.");
                    return;
                }
                return;
            }
            SwanAppWebViewManager.this.f11823f.evaluateJavascript("javascript:" + this.f11843e + "(" + this.f11845g + SmallTailInfo.EMOTION_SUFFIX, null);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.b.h0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f11847a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GeolocationPermissions.Callback f11848b;

        public c(String str, GeolocationPermissions.Callback callback) {
            this.f11847a = str;
            this.f11848b = callback;
        }

        @Override // d.b.h0.a.k1.b
        public void a(String str) {
            if (SwanAppWebViewManager.z) {
                Log.e("SwanAppWebViewManager", str + "");
            }
            SwanAppWebViewManager.this.w0(this.f11847a, this.f11848b);
        }

        @Override // d.b.h0.a.k1.b
        public void b(int i, String str) {
            if (SwanAppWebViewManager.z) {
                Log.e("SwanAppWebViewManager", str + "");
            }
            SwanAppWebViewManager.this.Q0(this.f11847a, this.f11848b);
        }
    }

    /* loaded from: classes2.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public boolean f11850a = false;

        public d(SwanAppWebViewManager swanAppWebViewManager) {
        }
    }

    static {
        d.b.h0.g.i0.f.d.i();
        V8Engine.getInstance(0L);
    }

    public SwanAppWebViewManager(Context context) {
        this.f11822e = new MutableContextWrapper(context);
        d.b.h0.a.e0.k.d.a.k().l();
        D0();
        M0();
    }

    @Override // d.b.h0.a.p.d.d
    @UiThread
    public void A() {
        this.f11823f.onResume();
        this.f11823f.resumeTimers();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.a.p.d.d
    /* renamed from: A0 */
    public NgWebView F() {
        return this.f11823f;
    }

    public void B0() {
        this.f11823f.goBack();
    }

    @Override // d.b.h0.a.p.d.d
    @UiThread
    public void C() {
        this.f11823f.onPause();
        this.f11823f.pauseTimers();
    }

    @SuppressLint({"NewApi"})
    public final void C0(String str, GeolocationPermissions.Callback callback) {
        d.b.h0.a.k1.a.a("android.permission.ACCESS_FINE_LOCATION", new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, d.b.h0.a.r1.d.e().n(), new c(str, callback));
    }

    @DebugTrace
    public final void D0() {
        O0(this.o);
        H0();
        K0(this);
        E0();
        J0();
        G0();
        I0();
        P0();
        F0();
    }

    public final void E0() {
        if (this.k == null) {
            this.k = new UnitedSchemeMainDispatcher();
        }
    }

    public abstract void F0();

    @Override // d.b.h0.a.p.d.d
    public void G(d.b.h0.a.e0.n.c cVar) {
        if (cVar == null || this.p.contains(cVar)) {
            return;
        }
        this.p.add(cVar);
    }

    public void G0() {
        this.y.e(this.f11823f, this.f11822e.getBaseContext(), this, this.k);
    }

    public final void H0() {
        if (d.b.h0.a.w0.a.N().n()) {
            this.f11823f = new NgWebView(this.f11822e);
        } else {
            this.f11823f = new NgWebView(this.f11822e.getBaseContext());
        }
        if (this.f11823f.getCurrentWebView() != null) {
            this.r = this.f11823f.getCurrentWebView().getBackground();
            AbsoluteLayout webViewImpl = this.f11823f.getWebViewImpl();
            if (webViewImpl != null) {
                this.s = webViewImpl.getBackground();
            }
        }
        if (this.o.f11850a) {
            this.f11823f.setBackgroundColorForSwanApp(0);
            if (!BdZeusUtil.isWebkitLoaded()) {
                this.q = true;
            }
        }
        this.f11823f.setScrollBarStyle(0);
        this.j = new d.b.h0.a.e0.m.b(this.f11822e.getBaseContext());
        if (z) {
            Log.d("SwanAppWebViewManager", "WebViewManager " + hashCode() + " initializing Clients");
        }
        this.f11823f.setWebViewClient(new SwanAppWebViewClient(this, null));
        this.f11823f.setWebViewClientExt(new SwanAppWebViewClientExt(this, null));
        this.f11823f.setWebChromeClient(new SwanAppWebChromeClient(this, null));
        this.f11823f.setWebChromeClientExt(new SwanAppWebChromeClientExt(this, null));
        this.f11823f.setOverScrollMode(2);
        this.f11823f.setOnCommonEventHandler(this);
        this.f11823f.setWebViewManager(this);
        this.f11823f.getCurrentWebView().setLongClickable(true);
        this.f11823f.setSelectPopWindowListener(this);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void I0() {
        BdSailorWebSettings settings = this.f11823f.getSettings();
        ISailorWebSettingsExt settingsExt = this.f11823f.getSettingsExt();
        settings.setWebViewFrameNameSailor(T());
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
        String path = this.f11822e.getDir("databases", 0).getPath();
        String path2 = this.f11822e.getDir("geolocation", 0).getPath();
        String path3 = this.f11822e.getDir("appcache", 0).getPath();
        settings.setGeolocationDatabasePath(path2);
        settings.setDatabasePath(path);
        settings.setAppCachePath(path3);
        if (((ActivityManager) this.f11822e.getSystemService("activity")).getMemoryClass() > 16) {
            settings.setPageCacheCapacity(5);
        } else {
            settings.setPageCacheCapacity(1);
        }
        this.v = settings.getUserAgentString();
        V0(this.w);
        try {
            settings.setPluginState(WebSettings.PluginState.ON_DEMAND);
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (NoClassDefFoundError e3) {
            e3.printStackTrace();
        }
    }

    @Override // d.b.h0.a.p.d.d
    public void J(d.b.h0.a.e0.n.c cVar) {
        if (cVar != null && this.p.contains(cVar)) {
            this.p.remove(cVar);
        }
    }

    public void J0() {
        UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = this.k;
        if (unitedSchemeMainDispatcher != null) {
            this.l = d.b.h0.a.t1.e.a(unitedSchemeMainDispatcher);
            return;
        }
        throw new IllegalStateException("initSwanAppDispatcher() must be called after initDispatcher()");
    }

    public void K0(SwanAppWebViewManager swanAppWebViewManager) {
        this.y.f(this.f11822e.getBaseContext(), this.f11823f);
    }

    public void L0(String str) {
        k0.X(new a(str));
    }

    @CallSuper
    public void M0() {
        i.a(this);
    }

    @Override // d.b.h0.a.e0.k.c
    public boolean N(boolean z2) {
        return z2;
    }

    @CallSuper
    public void N0() {
        this.w = null;
        i.b(this);
    }

    public void O0(d dVar) {
    }

    public void P0() {
    }

    public final void Q0(String str, GeolocationPermissions.Callback callback) {
        if (z) {
            Log.d("SwanAppWebViewManager", "rejectGeoLocationOnce origin: " + str);
        }
        callback.invoke(str, false, false);
    }

    public final void R0(BdSailorWebChromeClient bdSailorWebChromeClient) {
        this.i = bdSailorWebChromeClient;
    }

    public final void S0(BdSailorWebViewClient bdSailorWebViewClient) {
        this.f11824g = bdSailorWebViewClient;
    }

    @Override // d.b.h0.a.p.d.d
    public String T() {
        return "ai_apps";
    }

    public final void T0(BdSailorWebViewClientExt bdSailorWebViewClientExt) {
        this.f11825h = bdSailorWebViewClientExt;
    }

    public void U0(int i) {
        this.x = i;
        if (z) {
            Log.d("SwanAppWebViewManager", "CustomView orientation has been set to [" + this.x + "] for once");
        }
    }

    public void V0(String str) {
        this.w = str;
        BdSailorWebSettings settings = this.f11823f.getSettings();
        String str2 = this.v;
        if (!TextUtils.isEmpty(str)) {
            str2 = String.format("%s %s", str2, str);
        }
        String b2 = d.b.h0.a.g2.a.b(str2);
        if (TextUtils.equals(b2, this.t)) {
            return;
        }
        this.t = b2;
        settings.setUserAgentString(b2);
        if (z) {
            Log.i("SwanAppWebViewManager", "set ua:" + this.t);
        }
    }

    public final void W0() {
        ISailorWebViewExt webViewExt = this.f11823f.getWebViewExt();
        if (webViewExt != null) {
            webViewExt.emulateShiftHeldOnNormalTextExt();
        }
    }

    @Override // d.b.h0.a.p.d.d
    public void X() {
    }

    public final void X0(String str) {
        if (a.b.h(0) && !TextUtils.isEmpty(str)) {
            String path = Uri.parse(str).getPath();
            if (z) {
                Log.d("SwanAppWebViewManager", "pathList item: " + str + " ,folder: " + path + " ,parent: " + new File(path).getParent());
            }
            if (TextUtils.isEmpty(path)) {
                return;
            }
            this.f11823f.getSettings().setCodeCacheSetting(d.b.h0.a.e0.i.b.a("appframe", new File(path).getParent()));
        }
    }

    @Override // d.b.h0.a.p.d.d
    public String b() {
        return this.t;
    }

    @Override // d.b.h0.a.p.d.d
    public abstract String c();

    @Override // d.b.h0.a.p.d.d
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
        this.f11822e.setBaseContext(activity);
    }

    @Override // d.b.h0.a.p.d.d
    public void destroy() {
        this.m.removeCallbacks(null);
        this.f11823f.destroy();
        this.p.clear();
        N0();
    }

    @Override // d.b.h0.a.e0.k.b
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.swan.apps.core.container.view.SwanAppSelectPopView.a
    public void doSelectionCopy(String str) {
        y0();
        d.b.h0.a.w0.a.f0().a(str, this.f11822e.getBaseContext());
    }

    @Override // com.baidu.swan.apps.core.container.view.SwanAppSelectPopView.a
    public void doSelectionSearch(String str) {
        y0();
        d.b.h0.a.w0.a.f0().e(str, this.f11822e.getBaseContext());
    }

    @Override // d.b.h0.a.p.d.d
    public void e(g gVar) {
        this.n = gVar;
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public String getCurrentPageUrl() {
        return F().getUrl();
    }

    @Override // com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        return 0;
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public void handleSchemeDispatchCallback(String str, String str2) {
        this.m.post(new b(str, str2, TextUtils.isEmpty(str2) ? "" : JSONObject.quote(str2)));
    }

    @Override // d.b.h0.a.p.d.d
    public void loadUrl(String str) {
        X0(str);
        this.f11823f.loadUrl(str);
    }

    @Override // d.b.h0.a.p.d.d
    public void onJSLoaded() {
    }

    @Override // d.b.h0.a.e0.k.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.f11823f.canGoBack()) {
            B0();
            return true;
        }
        return false;
    }

    @Override // d.b.h0.a.p.d.d
    @CallSuper
    public void onPause() {
        this.f11823f.onPause();
        i.c(this);
    }

    @Override // d.b.h0.a.p.d.d
    @CallSuper
    public void onResume() {
        this.f11823f.onResume();
        i.d(this);
    }

    @Override // d.b.h0.a.e0.k.b
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        List<d.b.h0.a.e0.n.c> list = this.p;
        if (list != null) {
            for (d.b.h0.a.e0.n.c cVar : list) {
                if (cVar != null) {
                    cVar.onScrollChanged(i, i2, i3, i4);
                }
            }
        }
    }

    @Override // d.b.h0.a.e0.k.b
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // d.b.h0.a.e0.k.c
    public boolean u() {
        return false;
    }

    public final void w0(String str, GeolocationPermissions.Callback callback) {
        if (z) {
            Log.d("SwanAppWebViewManager", "allowGeoLocationOnce origin: " + str);
        }
        callback.invoke(str, true, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.a.q1.a.e.a
    /* renamed from: x0 */
    public NgWebView H(Context context) {
        this.f11822e.setBaseContext(context);
        if (this.f11823f == null) {
            H0();
        }
        return this.f11823f;
    }

    public void y0() {
        d.b.h0.a.w0.a.f0().b(this.f11823f);
    }

    @Nullable
    public synchronized d.b.h0.a.s0.j.b z0() {
        if (this.u == null) {
            if (!d.b.h0.a.r1.d.e().s().d()) {
                return null;
            }
            SwanAppActivity n = d.b.h0.a.r1.d.e().n();
            if (n == null) {
                return null;
            }
            this.u = new d.b.h0.a.s0.j.b(n, c());
        }
        return this.u;
    }

    /* loaded from: classes2.dex */
    public class SwanAppWebChromeClientExt extends BdSailorWebChromeClientExt {
        public boolean mIsFirstTimeShow;

        /* loaded from: classes2.dex */
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
                d.b.h0.a.c0.c.a("SwanAppWebViewManager", "onReceiveValue: " + str);
                JsonReader jsonReader = new JsonReader(new StringReader(str));
                jsonReader.setLenient(true);
                try {
                    try {
                        if (jsonReader.peek() != JsonToken.NULL && jsonReader.peek() == JsonToken.STRING) {
                            String nextString = jsonReader.nextString();
                            if (!TextUtils.isEmpty(nextString)) {
                                d.b.h0.a.w0.a.f0().c(SwanAppWebViewManager.this.f11823f, nextString);
                            }
                        }
                    } catch (IOException e2) {
                        if (SwanAppWebViewManager.z) {
                            e2.printStackTrace();
                        }
                    }
                } finally {
                    d.b.h0.p.d.a(jsonReader);
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
            SwanAppWebViewManager.this.f11823f.hidePopWindow();
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
                SwanAppWebViewManager.this.W0();
            } else if (type == 5) {
                SwanAppWebViewManager.this.f11823f.evaluateJavascript(String.format("javascript:(function(){return window.getImageSrcByCoordinate(%s,%s);})()", Integer.valueOf(h0.H(i)), Integer.valueOf(h0.H(i2))), new a());
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClientExt
        public void showSelectionActionDialogExt(BdSailorWebView bdSailorWebView, int i, int i2, int i3, int i4, String str) {
            super.showSelectionActionDialogExt(bdSailorWebView, i, i2, i3, i4, str);
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "showSelectionActionDialogExt: " + i3 + ZeusCrashHandler.NAME_SEPERATOR + i4 + ZeusCrashHandler.NAME_SEPERATOR + i + ZeusCrashHandler.NAME_SEPERATOR + i2 + ZeusCrashHandler.NAME_SEPERATOR + str);
            }
            d.b.h0.a.w0.a.f0().d(SwanAppWebViewManager.this.f11823f, i, i2, i3, i4, str, this.mIsFirstTimeShow);
            this.mIsFirstTimeShow = false;
        }

        public /* synthetic */ SwanAppWebChromeClientExt(SwanAppWebViewManager swanAppWebViewManager, a aVar) {
            this();
        }
    }
}
