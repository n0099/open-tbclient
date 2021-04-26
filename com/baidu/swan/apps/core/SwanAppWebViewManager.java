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
import d.a.h0.a.e0.g;
import d.a.h0.a.e0.i.a;
import d.a.h0.a.e0.m.b;
import d.a.h0.a.i2.h0;
import d.a.h0.a.i2.k0;
import d.a.h0.a.k;
import d.a.h0.a.r1.e;
import d.a.h0.a.t1.j;
import d.a.h0.a.v1.c.h;
import d.a.h0.a.v1.c.i.b;
import d.a.h0.a.z0.i;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class SwanAppWebViewManager implements d.a.h0.a.p.d.d<NgWebView>, d.a.h0.a.e0.k.b, d.a.h0.a.e0.k.c, d.a.h0.a.q1.a.e.a<NgWebView>, SwanAppSelectPopView.a {
    public static final boolean z = k.f43101a;

    /* renamed from: e  reason: collision with root package name */
    public MutableContextWrapper f11656e;

    /* renamed from: f  reason: collision with root package name */
    public NgWebView f11657f;

    /* renamed from: g  reason: collision with root package name */
    public BdSailorWebViewClient f11658g;

    /* renamed from: h  reason: collision with root package name */
    public BdSailorWebViewClientExt f11659h;

    /* renamed from: i  reason: collision with root package name */
    public BdSailorWebChromeClient f11660i;
    public d.a.h0.a.e0.m.b j;
    public UnitedSchemeMainDispatcher k;
    public j l;
    public g n;
    public String t;
    public d.a.h0.a.s0.j.b u;
    public String v;
    public String w;
    public Handler m = new Handler(Looper.getMainLooper());
    public final d o = new d(this);
    public List<d.a.h0.a.e0.n.c> p = new ArrayList();
    public boolean q = false;
    public Drawable r = null;
    public Drawable s = null;
    public int x = -1;
    public d.a.h0.a.x0.b.a y = new d.a.h0.a.x0.b.a();

    /* loaded from: classes2.dex */
    public class SwanAppWebChromeClient extends BdSailorWebChromeClient {

        /* loaded from: classes2.dex */
        public class a implements b.s {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ JsPromptResult f11661a;

            public a(SwanAppWebChromeClient swanAppWebChromeClient, JsPromptResult jsPromptResult) {
                this.f11661a = jsPromptResult;
            }

            @Override // d.a.h0.a.e0.m.b.s
            public void a() {
                this.f11661a.cancel();
            }

            @Override // d.a.h0.a.e0.m.b.s
            public void b(String str) {
                this.f11661a.confirm(str);
            }

            @Override // d.a.h0.a.e0.m.b.s
            public void onCancel() {
                this.f11661a.cancel();
            }
        }

        /* loaded from: classes2.dex */
        public class b implements b.s {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ JsResult f11662a;

            public b(SwanAppWebChromeClient swanAppWebChromeClient, JsResult jsResult) {
                this.f11662a = jsResult;
            }

            @Override // d.a.h0.a.e0.m.b.s
            public void a() {
                this.f11662a.cancel();
            }

            @Override // d.a.h0.a.e0.m.b.s
            public void b(String str) {
                this.f11662a.confirm();
            }

            @Override // d.a.h0.a.e0.m.b.s
            public void onCancel() {
                this.f11662a.cancel();
            }
        }

        /* loaded from: classes2.dex */
        public class c implements b.s {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ JsResult f11663a;

            public c(SwanAppWebChromeClient swanAppWebChromeClient, JsResult jsResult) {
                this.f11663a = jsResult;
            }

            @Override // d.a.h0.a.e0.m.b.s
            public void a() {
                this.f11663a.cancel();
            }

            @Override // d.a.h0.a.e0.m.b.s
            public void b(String str) {
                this.f11663a.confirm();
            }

            @Override // d.a.h0.a.e0.m.b.s
            public void onCancel() {
                this.f11663a.cancel();
            }
        }

        /* loaded from: classes2.dex */
        public class d implements d.a.h0.a.i2.u0.b<h<b.e>> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f11664e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ GeolocationPermissions.Callback f11665f;

            public d(String str, GeolocationPermissions.Callback callback) {
                this.f11664e = str;
                this.f11665f = callback;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.h0.a.i2.u0.b
            /* renamed from: a */
            public void onCallback(h<b.e> hVar) {
                if (d.a.h0.a.v1.c.c.h(hVar)) {
                    SwanAppWebViewManager.this.C0(this.f11664e, this.f11665f);
                } else {
                    SwanAppWebViewManager.this.Q0(this.f11664e, this.f11665f);
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
            if (SwanAppWebViewManager.this.f11660i != null) {
                SwanAppWebViewManager.this.f11660i.onCloseWindow(bdSailorWebView);
            } else {
                super.onCloseWindow(bdSailorWebView);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onConsoleMessage(BdSailorWebView bdSailorWebView, ConsoleMessage consoleMessage) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onConsoleMessage");
            }
            if (SwanAppWebViewManager.this.f11660i == null || !SwanAppWebViewManager.this.f11660i.onConsoleMessage(bdSailorWebView, consoleMessage)) {
                return super.onConsoleMessage(bdSailorWebView, consoleMessage);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onCreateWindow(BdSailorWebView bdSailorWebView, boolean z, boolean z2, Message message) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onCreateWindow");
            }
            if (SwanAppWebViewManager.this.f11660i == null || !SwanAppWebViewManager.this.f11660i.onCreateWindow(bdSailorWebView, z, z2, message)) {
                return super.onCreateWindow(bdSailorWebView, z, z2, message);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onExceededDatabaseQuota(BdSailorWebView bdSailorWebView, String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onExceededDatabaseQuota");
            }
            if (SwanAppWebViewManager.this.f11660i != null) {
                SwanAppWebViewManager.this.f11660i.onExceededDatabaseQuota(bdSailorWebView, str, str2, j, j2, j3, quotaUpdater);
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
            e h2 = e.h();
            if (h2 == null || h2.v() == null) {
                SwanAppWebViewManager.this.Q0(str, callback);
            } else {
                h2.R().g(h2.v(), "mapp_location", new d(str, callback));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onHideCustomView(BdSailorWebView bdSailorWebView) {
            if (SwanAppWebViewManager.this.f11660i != null ? SwanAppWebViewManager.this.f11660i.onHideCustomView(bdSailorWebView) : false) {
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
            if (SwanAppWebViewManager.this.f11660i == null || !SwanAppWebViewManager.this.f11660i.onJsBeforeUnload(bdSailorWebView, str, str2, jsResult)) {
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
            if (SwanAppWebViewManager.this.f11660i == null || !SwanAppWebViewManager.this.f11660i.onJsTimeout(bdSailorWebView)) {
                return super.onJsTimeout(bdSailorWebView);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onProgressChanged(BdSailorWebView bdSailorWebView, int i2) {
            if (SwanAppWebViewManager.this.f11660i != null) {
                SwanAppWebViewManager.this.f11660i.onProgressChanged(bdSailorWebView, i2);
            } else {
                super.onProgressChanged(bdSailorWebView, i2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReachedMaxAppCacheSize(BdSailorWebView bdSailorWebView, long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onReachedMaxAppCacheSize");
            }
            if (SwanAppWebViewManager.this.f11660i != null) {
                SwanAppWebViewManager.this.f11660i.onReachedMaxAppCacheSize(bdSailorWebView, j, j2, quotaUpdater);
            } else {
                super.onReachedMaxAppCacheSize(bdSailorWebView, j, j2, quotaUpdater);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedIcon(BdSailorWebView bdSailorWebView, Bitmap bitmap) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onReachedMaxAppCacheSize");
            }
            if (SwanAppWebViewManager.this.f11660i != null) {
                SwanAppWebViewManager.this.f11660i.onReceivedIcon(bdSailorWebView, bitmap);
            } else {
                super.onReceivedIcon(bdSailorWebView, bitmap);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedTitle(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onReceivedTitleInFact : " + str);
            }
            if (SwanAppWebViewManager.this.f11660i != null) {
                SwanAppWebViewManager.this.f11660i.onReceivedTitle(bdSailorWebView, str);
            } else {
                super.onReceivedTitle(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedTouchIconUrl(BdSailorWebView bdSailorWebView, String str, boolean z) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onReceivedTouchIconUrl");
            }
            if (SwanAppWebViewManager.this.f11660i != null) {
                SwanAppWebViewManager.this.f11660i.onReceivedTouchIconUrl(bdSailorWebView, str, z);
            } else {
                super.onReceivedTouchIconUrl(bdSailorWebView, str, z);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onRequestFocus(BdSailorWebView bdSailorWebView) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onRequestFocus");
            }
            if (SwanAppWebViewManager.this.f11660i != null) {
                SwanAppWebViewManager.this.f11660i.onRequestFocus(bdSailorWebView);
            } else {
                super.onRequestFocus(bdSailorWebView);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onShowCustomView(BdSailorWebView bdSailorWebView, View view, WebChromeClient.CustomViewCallback customViewCallback) {
            int i2 = 0;
            if (SwanAppWebViewManager.this.f11660i != null ? SwanAppWebViewManager.this.f11660i.onShowCustomView(bdSailorWebView, view, customViewCallback) : false) {
                if (SwanAppWebViewManager.z) {
                    Log.i("SwanAppWebViewManager", "SwanAppWebChromeClient::onShowCustomView by external client");
                }
                return true;
            }
            if (SwanAppWebViewManager.this.x != -1) {
                i2 = SwanAppWebViewManager.this.x;
            } else {
                int i3 = d.a.h0.a.r1.d.e().f43812g;
                if (i3 >= 35 && i3 < 180) {
                    i2 = 8;
                }
            }
            onShowCustomView(bdSailorWebView, view, i2, customViewCallback);
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
            if (SwanAppWebViewManager.this.f11660i != null) {
                SwanAppWebViewManager.this.f11660i.openFileChooser(bdSailorWebView, valueCallback);
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
            if (SwanAppWebViewManager.this.f11660i != null) {
                SwanAppWebViewManager.this.f11660i.openFileChooser(bdSailorWebView, valueCallback, str);
            } else {
                super.openFileChooser(bdSailorWebView, valueCallback, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onShowCustomView(BdSailorWebView bdSailorWebView, View view, int i2, WebChromeClient.CustomViewCallback customViewCallback) {
            SwanAppWebViewManager.this.x = -1;
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "CustomView orientation applied, set back to default [" + SwanAppWebViewManager.this.x + "]");
            }
            if (SwanAppWebViewManager.this.f11660i != null ? SwanAppWebViewManager.this.f11660i.onShowCustomView(bdSailorWebView, view, i2, customViewCallback) : false) {
                if (SwanAppWebViewManager.z) {
                    Log.i("SwanAppWebViewManager", "SwanAppWebChromeClient::onShowCustomView by external client");
                }
                return true;
            }
            if (SwanAppWebViewManager.this.z0() != null) {
                SwanAppWebViewManager.this.z0().g(view, i2, null);
            }
            if (SwanAppWebViewManager.z) {
                Log.i("SwanAppWebViewManager", "SwanAppWebChromeClient::onShowCustomView : " + i2);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void openFileChooser(BdSailorWebView bdSailorWebView, ValueCallback valueCallback, String str, String str2) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::openFileChooser");
            }
            if (SwanAppWebViewManager.this.f11660i != null) {
                SwanAppWebViewManager.this.f11660i.openFileChooser(bdSailorWebView, valueCallback, str, str2);
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
            public final /* synthetic */ SslErrorHandler f11668a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ BdSailorWebView f11669b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ SslError f11670c;

            public a(SslErrorHandler sslErrorHandler, BdSailorWebView bdSailorWebView, SslError sslError) {
                this.f11668a = sslErrorHandler;
                this.f11669b = bdSailorWebView;
                this.f11670c = sslError;
            }

            @Override // d.a.h0.a.e0.m.b.t
            public void a() {
                SwanAppWebViewClient.this.onReceivedSslError(this.f11669b, this.f11668a, this.f11670c);
            }

            @Override // d.a.h0.a.e0.m.b.t
            public void b() {
                this.f11668a.proceed();
            }

            @Override // d.a.h0.a.e0.m.b.t
            public void c() {
                this.f11668a.cancel();
            }
        }

        /* loaded from: classes2.dex */
        public class b implements b.r {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ BdSailorWebView f11672a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f11673b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f11674c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ HttpAuthHandler f11675d;

            public b(SwanAppWebViewClient swanAppWebViewClient, BdSailorWebView bdSailorWebView, String str, String str2, HttpAuthHandler httpAuthHandler) {
                this.f11672a = bdSailorWebView;
                this.f11673b = str;
                this.f11674c = str2;
                this.f11675d = httpAuthHandler;
            }

            @Override // d.a.h0.a.e0.m.b.r
            public void a() {
                this.f11675d.cancel();
            }

            @Override // d.a.h0.a.e0.m.b.r
            public void b(String str, String str2) {
                BdSailorWebView bdSailorWebView = this.f11672a;
                if (bdSailorWebView != null) {
                    bdSailorWebView.setHttpAuthUsernamePassword(this.f11673b, this.f11674c, str, str2);
                }
                this.f11675d.proceed(str, str2);
            }
        }

        public SwanAppWebViewClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void doUpdateVisitedHistory(BdSailorWebView bdSailorWebView, String str, boolean z) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::doUpdateVisitedHistory");
            }
            if (SwanAppWebViewManager.this.f11658g != null) {
                SwanAppWebViewManager.this.f11658g.doUpdateVisitedHistory(bdSailorWebView, str, z);
            } else {
                super.doUpdateVisitedHistory(bdSailorWebView, str, z);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onFormResubmission(BdSailorWebView bdSailorWebView, Message message, Message message2) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFormResubmission");
            }
            if (SwanAppWebViewManager.this.f11658g != null) {
                SwanAppWebViewManager.this.f11658g.onFormResubmission(bdSailorWebView, message, message2);
            } else {
                super.onFormResubmission(bdSailorWebView, message, message2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onLoadResource(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onLoadResource：" + str);
            }
            if (SwanAppWebViewManager.this.f11658g != null) {
                SwanAppWebViewManager.this.f11658g.onLoadResource(bdSailorWebView, str);
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
                WebView currentWebView = SwanAppWebViewManager.this.f11657f.getCurrentWebView();
                if (currentWebView != null) {
                    currentWebView.setBackground(SwanAppWebViewManager.this.r);
                    SwanAppWebViewManager.this.q = false;
                }
                AbsoluteLayout webViewImpl = SwanAppWebViewManager.this.f11657f.getWebViewImpl();
                if (webViewImpl != null) {
                    webViewImpl.setBackground(SwanAppWebViewManager.this.s);
                }
            }
            if (SwanAppWebViewManager.this.n != null) {
                SwanAppWebViewManager.this.n.a(str);
            }
            if (SwanAppWebViewManager.this.f11658g != null) {
                SwanAppWebViewManager.this.f11658g.onPageFinished(bdSailorWebView, str);
            } else {
                super.onPageFinished(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageStarted(BdSailorWebView bdSailorWebView, String str, Bitmap bitmap) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onPageStarted url: " + str);
            }
            if (SwanAppWebViewManager.this.f11658g != null) {
                SwanAppWebViewManager.this.f11658g.onPageStarted(bdSailorWebView, str, bitmap);
            } else {
                super.onPageStarted(bdSailorWebView, str, bitmap);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedClientCertRequest(BdSailorWebView bdSailorWebView, ClientCertRequest clientCertRequest) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedClientCertRequest");
            }
            if (SwanAppWebViewManager.this.f11658g != null) {
                SwanAppWebViewManager.this.f11658g.onReceivedClientCertRequest(bdSailorWebView, clientCertRequest);
            } else {
                super.onReceivedClientCertRequest(bdSailorWebView, clientCertRequest);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i2, String str, String str2) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedError errorCode: " + i2 + " ,failingUrl: " + str2);
            }
            if (SwanAppWebViewManager.this.f11658g != null) {
                SwanAppWebViewManager.this.f11658g.onReceivedError(bdSailorWebView, i2, str, str2);
            } else {
                super.onReceivedError(bdSailorWebView, i2, str, str2);
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
            } else if (SwanAppWebViewManager.this.f11657f.isShown()) {
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
            if (SwanAppWebViewManager.this.f11658g != null) {
                SwanAppWebViewManager.this.f11658g.onReceivedHttpError(bdSailorWebView, webResourceRequest, webResourceResponse);
            } else {
                super.onReceivedHttpError(bdSailorWebView, webResourceRequest, webResourceResponse);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedLoginRequest(BdSailorWebView bdSailorWebView, String str, String str2, String str3) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedLoginRequest");
            }
            if (SwanAppWebViewManager.this.f11658g != null) {
                SwanAppWebViewManager.this.f11658g.onReceivedLoginRequest(bdSailorWebView, str, str2, str3);
            } else {
                super.onReceivedLoginRequest(bdSailorWebView, str, str2, str3);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedSslError(BdSailorWebView bdSailorWebView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedSslError");
            }
            if (SwanAppWebViewManager.this.f11657f.isShown()) {
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
            if (SwanAppWebViewManager.this.f11658g != null) {
                SwanAppWebViewManager.this.f11658g.onScaleChanged(bdSailorWebView, f2, f3);
            } else {
                super.onScaleChanged(bdSailorWebView, f2, f3);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onUnhandledKeyEvent(BdSailorWebView bdSailorWebView, KeyEvent keyEvent) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onUnhandledKeyEvent");
            }
            if (SwanAppWebViewManager.this.f11658g != null) {
                SwanAppWebViewManager.this.f11658g.onUnhandledKeyEvent(bdSailorWebView, keyEvent);
            } else {
                super.onUnhandledKeyEvent(bdSailorWebView, keyEvent);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public WebResourceResponse shouldInterceptRequest(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::shouldInterceptRequest url: " + str);
            }
            if (SwanAppWebViewManager.this.f11658g != null) {
                return SwanAppWebViewManager.this.f11658g.shouldInterceptRequest(bdSailorWebView, str);
            }
            return super.shouldInterceptRequest(bdSailorWebView, str);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideKeyEvent(BdSailorWebView bdSailorWebView, KeyEvent keyEvent) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::shouldOverrideKeyEvent");
            }
            if (SwanAppWebViewManager.this.f11658g == null || !SwanAppWebViewManager.this.f11658g.shouldOverrideKeyEvent(bdSailorWebView, keyEvent)) {
                return super.shouldOverrideKeyEvent(bdSailorWebView, keyEvent);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::shouldOverrideUrlLoading url: " + str);
            }
            if (SwanAppWebViewManager.this.f11658g != null) {
                return SwanAppWebViewManager.this.f11658g.shouldOverrideUrlLoading(bdSailorWebView, str);
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
            if (SwanAppWebViewManager.this.f11659h != null) {
                SwanAppWebViewManager.this.f11659h.onFirstContentfulPaintExt(bdSailorWebView, str);
            } else {
                super.onFirstContentfulPaintExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstImagePaintExt");
            }
            if (SwanAppWebViewManager.this.f11659h != null) {
                SwanAppWebViewManager.this.f11659h.onFirstImagePaintExt(bdSailorWebView, str);
            } else {
                super.onFirstImagePaintExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.this.f11659h != null) {
                SwanAppWebViewManager.this.f11659h.onFirstLayoutDidExt(bdSailorWebView, str);
            } else {
                super.onFirstLayoutDidExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstPaintDidEx");
            }
            if (SwanAppWebViewManager.this.f11659h != null) {
                SwanAppWebViewManager.this.f11659h.onFirstPaintDidExt(bdSailorWebView, str);
            } else {
                super.onFirstPaintDidExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstScreenPaintFinishedEx");
            }
            if (SwanAppWebViewManager.this.f11659h != null) {
                SwanAppWebViewManager.this.f11659h.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            } else {
                super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstTextPaintExt");
            }
            if (SwanAppWebViewManager.this.f11659h != null) {
                SwanAppWebViewManager.this.f11659h.onFirstTextPaintExt(bdSailorWebView, str);
            } else {
                super.onFirstTextPaintExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFullScreenModeExt(BdSailorWebView bdSailorWebView, boolean z, int i2, int i3) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFullScreenModeEx");
            }
            if (SwanAppWebViewManager.this.f11659h != null) {
                SwanAppWebViewManager.this.f11659h.onFullScreenModeExt(bdSailorWebView, z, i2, i3);
            } else {
                super.onFullScreenModeExt(bdSailorWebView, z, i2, i3);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public String onGetErrorHtmlExt(BdSailorWebView bdSailorWebView, int i2, String str, String str2) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onGetErrorHtmlSailor");
            }
            if (SwanAppWebViewManager.this.f11659h != null) {
                return SwanAppWebViewManager.this.f11659h.onGetErrorHtmlExt(bdSailorWebView, i2, str, str2);
            }
            return super.onGetErrorHtmlExt(bdSailorWebView, i2, str, str2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onKeywordExtensionExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onKeywordExtensionEx");
            }
            if (SwanAppWebViewManager.this.f11659h != null) {
                return SwanAppWebViewManager.this.f11659h.onKeywordExtensionExt(bdSailorWebView, str, str2);
            }
            return super.onKeywordExtensionExt(bdSailorWebView, str, str2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageBackOrForwardExt(BdSailorWebView bdSailorWebView, int i2) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onGoBackOrForwardEx");
            }
            if (SwanAppWebViewManager.this.f11659h != null) {
                SwanAppWebViewManager.this.f11659h.onPageBackOrForwardExt(bdSailorWebView, i2);
            } else {
                super.onPageBackOrForwardExt(bdSailorWebView, i2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageCanBeScaledExt(BdSailorWebView bdSailorWebView, boolean z) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onPageCanBeScaledEx");
            }
            if (SwanAppWebViewManager.this.f11659h != null) {
                SwanAppWebViewManager.this.f11659h.onPageCanBeScaledExt(bdSailorWebView, z);
            } else {
                super.onPageCanBeScaledExt(bdSailorWebView, z);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPreloadUrlFoundExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onPreloadUrlFoundEx：" + str);
            }
            if (SwanAppWebViewManager.this.f11659h != null) {
                SwanAppWebViewManager.this.f11659h.onPreloadUrlFoundExt(bdSailorWebView, str);
            } else {
                super.onPreloadUrlFoundExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onSecurityCheckResultExt(BdSailorWebView bdSailorWebView, String str, WebViewClient.SecurityInfo securityInfo) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onSecurityCheckResultEx");
            }
            if (SwanAppWebViewManager.this.f11659h != null) {
                SwanAppWebViewManager.this.f11659h.onSecurityCheckResultExt(bdSailorWebView, str, securityInfo);
            } else {
                super.onSecurityCheckResultExt(bdSailorWebView, str, securityInfo);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onSubFrameBeforeRequest url: " + str);
            }
            if (SwanAppWebViewManager.this.f11659h != null) {
                return SwanAppWebViewManager.this.f11659h.onSubFrameBeforeRequest(bdSailorWebView, str);
            }
            return super.onSubFrameBeforeRequest(bdSailorWebView, str);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onUrlRedirectedExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onUrlRedirected");
            }
            if (SwanAppWebViewManager.this.f11659h != null) {
                SwanAppWebViewManager.this.f11659h.onUrlRedirectedExt(bdSailorWebView, str, str2);
            } else {
                super.onUrlRedirectedExt(bdSailorWebView, str, str2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean shouldHandleImageExt(BdSailorWebView bdSailorWebView, String str, String str2, String str3, boolean z) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::canHandleImageEx");
            }
            if (SwanAppWebViewManager.this.f11659h == null || !SwanAppWebViewManager.this.f11659h.shouldHandleImageExt(bdSailorWebView, str, str2, str3, z)) {
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
        public final /* synthetic */ String f11676e;

        public a(String str) {
            this.f11676e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.f11676e;
            if (!str.startsWith("javascript:")) {
                str = "javascript:" + str;
            }
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "webview load js:" + str);
            }
            SwanAppWebViewManager.this.f11657f.evaluateJavascript(str, null);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f11678e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f11679f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f11680g;

        public b(String str, String str2, String str3) {
            this.f11678e = str;
            this.f11679f = str2;
            this.f11680g = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "handleSchemeDispatchCallback callback: " + this.f11678e);
                Log.d("SwanAppWebViewManager", "handleSchemeDispatchCallback params: " + this.f11679f);
            }
            if (SwanAppWebViewManager.this.f11657f.isDestroyed()) {
                if (SwanAppWebViewManager.z) {
                    Log.e("SwanAppWebViewManager", "handleSchemeDispatchCallback webview is destroyed.");
                    return;
                }
                return;
            }
            SwanAppWebViewManager.this.f11657f.evaluateJavascript("javascript:" + this.f11678e + "(" + this.f11680g + SmallTailInfo.EMOTION_SUFFIX, null);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.a.h0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f11682a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GeolocationPermissions.Callback f11683b;

        public c(String str, GeolocationPermissions.Callback callback) {
            this.f11682a = str;
            this.f11683b = callback;
        }

        @Override // d.a.h0.a.k1.b
        public void a(String str) {
            if (SwanAppWebViewManager.z) {
                Log.e("SwanAppWebViewManager", str + "");
            }
            SwanAppWebViewManager.this.w0(this.f11682a, this.f11683b);
        }

        @Override // d.a.h0.a.k1.b
        public void b(int i2, String str) {
            if (SwanAppWebViewManager.z) {
                Log.e("SwanAppWebViewManager", str + "");
            }
            SwanAppWebViewManager.this.Q0(this.f11682a, this.f11683b);
        }
    }

    /* loaded from: classes2.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public boolean f11685a = false;

        public d(SwanAppWebViewManager swanAppWebViewManager) {
        }
    }

    static {
        d.a.h0.g.i0.f.d.i();
        V8Engine.getInstance(0L);
    }

    public SwanAppWebViewManager(Context context) {
        this.f11656e = new MutableContextWrapper(context);
        d.a.h0.a.e0.k.d.a.k().l();
        D0();
        M0();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.a.p.d.d
    /* renamed from: A0 */
    public NgWebView s() {
        return this.f11657f;
    }

    public void B0() {
        this.f11657f.goBack();
    }

    @SuppressLint({"NewApi"})
    public final void C0(String str, GeolocationPermissions.Callback callback) {
        d.a.h0.a.k1.a.a("android.permission.ACCESS_FINE_LOCATION", new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, d.a.h0.a.r1.d.e().v(), new c(str, callback));
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

    public void G0() {
        this.y.e(this.f11657f, this.f11656e.getBaseContext(), this, this.k);
    }

    public final void H0() {
        if (d.a.h0.a.w0.a.N().B()) {
            this.f11657f = new NgWebView(this.f11656e);
        } else {
            this.f11657f = new NgWebView(this.f11656e.getBaseContext());
        }
        if (this.f11657f.getCurrentWebView() != null) {
            this.r = this.f11657f.getCurrentWebView().getBackground();
            AbsoluteLayout webViewImpl = this.f11657f.getWebViewImpl();
            if (webViewImpl != null) {
                this.s = webViewImpl.getBackground();
            }
        }
        if (this.o.f11685a) {
            this.f11657f.setBackgroundColorForSwanApp(0);
            if (!BdZeusUtil.isWebkitLoaded()) {
                this.q = true;
            }
        }
        this.f11657f.setScrollBarStyle(0);
        this.j = new d.a.h0.a.e0.m.b(this.f11656e.getBaseContext());
        if (z) {
            Log.d("SwanAppWebViewManager", "WebViewManager " + hashCode() + " initializing Clients");
        }
        this.f11657f.setWebViewClient(new SwanAppWebViewClient(this, null));
        this.f11657f.setWebViewClientExt(new SwanAppWebViewClientExt(this, null));
        this.f11657f.setWebChromeClient(new SwanAppWebChromeClient(this, null));
        this.f11657f.setWebChromeClientExt(new SwanAppWebChromeClientExt(this, null));
        this.f11657f.setOverScrollMode(2);
        this.f11657f.setOnCommonEventHandler(this);
        this.f11657f.setWebViewManager(this);
        this.f11657f.getCurrentWebView().setLongClickable(true);
        this.f11657f.setSelectPopWindowListener(this);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void I0() {
        BdSailorWebSettings settings = this.f11657f.getSettings();
        ISailorWebSettingsExt settingsExt = this.f11657f.getSettingsExt();
        settings.setWebViewFrameNameSailor(a0());
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
        String path = this.f11656e.getDir("databases", 0).getPath();
        String path2 = this.f11656e.getDir("geolocation", 0).getPath();
        String path3 = this.f11656e.getDir("appcache", 0).getPath();
        settings.setGeolocationDatabasePath(path2);
        settings.setDatabasePath(path);
        settings.setAppCachePath(path3);
        if (((ActivityManager) this.f11656e.getSystemService("activity")).getMemoryClass() > 16) {
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

    public void J0() {
        UnitedSchemeMainDispatcher unitedSchemeMainDispatcher = this.k;
        if (unitedSchemeMainDispatcher != null) {
            this.l = d.a.h0.a.t1.e.a(unitedSchemeMainDispatcher);
            return;
        }
        throw new IllegalStateException("initSwanAppDispatcher() must be called after initDispatcher()");
    }

    public void K0(SwanAppWebViewManager swanAppWebViewManager) {
        this.y.f(this.f11656e.getBaseContext(), this.f11657f);
    }

    public void L0(String str) {
        k0.X(new a(str));
    }

    @CallSuper
    public void M0() {
        i.a(this);
    }

    @Override // d.a.h0.a.p.d.d
    @UiThread
    public void N() {
        this.f11657f.onPause();
        this.f11657f.pauseTimers();
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
        this.f11660i = bdSailorWebChromeClient;
    }

    @Override // d.a.h0.a.p.d.d
    public void S(d.a.h0.a.e0.n.c cVar) {
        if (cVar != null && this.p.contains(cVar)) {
            this.p.remove(cVar);
        }
    }

    public final void S0(BdSailorWebViewClient bdSailorWebViewClient) {
        this.f11658g = bdSailorWebViewClient;
    }

    public final void T0(BdSailorWebViewClientExt bdSailorWebViewClientExt) {
        this.f11659h = bdSailorWebViewClientExt;
    }

    public void U0(int i2) {
        this.x = i2;
        if (z) {
            Log.d("SwanAppWebViewManager", "CustomView orientation has been set to [" + this.x + "] for once");
        }
    }

    public void V0(String str) {
        this.w = str;
        BdSailorWebSettings settings = this.f11657f.getSettings();
        String str2 = this.v;
        if (!TextUtils.isEmpty(str)) {
            str2 = String.format("%s %s", str2, str);
        }
        String b2 = d.a.h0.a.g2.a.b(str2);
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
        ISailorWebViewExt webViewExt = this.f11657f.getWebViewExt();
        if (webViewExt != null) {
            webViewExt.emulateShiftHeldOnNormalTextExt();
        }
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
            this.f11657f.getSettings().setCodeCacheSetting(d.a.h0.a.e0.i.b.a("appframe", new File(path).getParent()));
        }
    }

    @Override // d.a.h0.a.p.d.d
    public String a0() {
        return "ai_apps";
    }

    @Override // d.a.h0.a.p.d.d
    public String b() {
        return this.t;
    }

    @Override // d.a.h0.a.p.d.d
    public abstract String c();

    @Override // d.a.h0.a.p.d.d
    public void d(g gVar) {
        this.n = gVar;
    }

    @Override // d.a.h0.a.p.d.d
    public void d0() {
    }

    @Override // d.a.h0.a.p.d.d
    public void destroy() {
        this.m.removeCallbacks(null);
        this.f11657f.destroy();
        this.p.clear();
        N0();
    }

    @Override // d.a.h0.a.e0.k.b
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.swan.apps.core.container.view.SwanAppSelectPopView.a
    public void doSelectionCopy(String str) {
        y0();
        d.a.h0.a.w0.a.f0().e(str, this.f11656e.getBaseContext());
    }

    @Override // com.baidu.swan.apps.core.container.view.SwanAppSelectPopView.a
    public void doSelectionSearch(String str) {
        y0();
        d.a.h0.a.w0.a.f0().d(str, this.f11656e.getBaseContext());
    }

    @Override // d.a.h0.a.p.d.d
    public void e(Activity activity) {
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
        this.f11656e.setBaseContext(activity);
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public String getCurrentPageUrl() {
        return s().getUrl();
    }

    @Override // com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        return 0;
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public void handleSchemeDispatchCallback(String str, String str2) {
        this.m.post(new b(str, str2, TextUtils.isEmpty(str2) ? "" : JSONObject.quote(str2)));
    }

    @Override // d.a.h0.a.p.d.d
    public void loadUrl(String str) {
        X0(str);
        this.f11657f.loadUrl(str);
    }

    @Override // d.a.h0.a.p.d.d
    public void onJSLoaded() {
    }

    @Override // d.a.h0.a.e0.k.b
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4 && this.f11657f.canGoBack()) {
            B0();
            return true;
        }
        return false;
    }

    @Override // d.a.h0.a.p.d.d
    @CallSuper
    public void onPause() {
        this.f11657f.onPause();
        i.c(this);
    }

    @Override // d.a.h0.a.p.d.d
    @CallSuper
    public void onResume() {
        this.f11657f.onResume();
        i.d(this);
    }

    @Override // d.a.h0.a.e0.k.b
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        List<d.a.h0.a.e0.n.c> list = this.p;
        if (list != null) {
            for (d.a.h0.a.e0.n.c cVar : list) {
                if (cVar != null) {
                    cVar.onScrollChanged(i2, i3, i4, i5);
                }
            }
        }
    }

    @Override // d.a.h0.a.e0.k.b
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // d.a.h0.a.e0.k.c
    public boolean p() {
        return false;
    }

    @Override // d.a.h0.a.p.d.d
    @UiThread
    public void q() {
        this.f11657f.onResume();
        this.f11657f.resumeTimers();
    }

    @Override // d.a.h0.a.p.d.d
    public void t(d.a.h0.a.e0.n.c cVar) {
        if (cVar == null || this.p.contains(cVar)) {
            return;
        }
        this.p.add(cVar);
    }

    @Override // d.a.h0.a.e0.k.c
    public boolean u(boolean z2) {
        return z2;
    }

    public final void w0(String str, GeolocationPermissions.Callback callback) {
        if (z) {
            Log.d("SwanAppWebViewManager", "allowGeoLocationOnce origin: " + str);
        }
        callback.invoke(str, true, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.a.q1.a.e.a
    /* renamed from: x0 */
    public NgWebView Q(Context context) {
        this.f11656e.setBaseContext(context);
        if (this.f11657f == null) {
            H0();
        }
        return this.f11657f;
    }

    public void y0() {
        d.a.h0.a.w0.a.f0().a(this.f11657f);
    }

    @Nullable
    public synchronized d.a.h0.a.s0.j.b z0() {
        if (this.u == null) {
            if (!d.a.h0.a.r1.d.e().p().d()) {
                return null;
            }
            SwanAppActivity v = d.a.h0.a.r1.d.e().v();
            if (v == null) {
                return null;
            }
            this.u = new d.a.h0.a.s0.j.b(v, c());
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
                d.a.h0.a.c0.c.a("SwanAppWebViewManager", "onReceiveValue: " + str);
                JsonReader jsonReader = new JsonReader(new StringReader(str));
                jsonReader.setLenient(true);
                try {
                    try {
                        if (jsonReader.peek() != JsonToken.NULL && jsonReader.peek() == JsonToken.STRING) {
                            String nextString = jsonReader.nextString();
                            if (!TextUtils.isEmpty(nextString)) {
                                d.a.h0.a.w0.a.f0().b(SwanAppWebViewManager.this.f11657f, nextString);
                            }
                        }
                    } catch (IOException e2) {
                        if (SwanAppWebViewManager.z) {
                            e2.printStackTrace();
                        }
                    }
                } finally {
                    d.a.h0.p.d.a(jsonReader);
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
            SwanAppWebViewManager.this.f11657f.hidePopWindow();
            this.mIsFirstTimeShow = true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClientExt
        @SuppressLint({"DefaultLocale"})
        public void performLongClickExt(BdSailorWebView bdSailorWebView, WebView.HitTestResult hitTestResult, int i2, int i3) {
            super.performLongClickExt(bdSailorWebView, hitTestResult, i2, i3);
            if (hitTestResult == null) {
                return;
            }
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "performLongClickExt: " + hitTestResult.getType() + ZeusCrashHandler.NAME_SEPERATOR + i2 + ZeusCrashHandler.NAME_SEPERATOR + i3);
            }
            int type = hitTestResult.getType();
            if (type == 10) {
                SwanAppWebViewManager.this.W0();
            } else if (type == 5) {
                SwanAppWebViewManager.this.f11657f.evaluateJavascript(String.format("javascript:(function(){return window.getImageSrcByCoordinate(%s,%s);})()", Integer.valueOf(h0.H(i2)), Integer.valueOf(h0.H(i3))), new a());
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClientExt
        public void showSelectionActionDialogExt(BdSailorWebView bdSailorWebView, int i2, int i3, int i4, int i5, String str) {
            super.showSelectionActionDialogExt(bdSailorWebView, i2, i3, i4, i5, str);
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "showSelectionActionDialogExt: " + i4 + ZeusCrashHandler.NAME_SEPERATOR + i5 + ZeusCrashHandler.NAME_SEPERATOR + i2 + ZeusCrashHandler.NAME_SEPERATOR + i3 + ZeusCrashHandler.NAME_SEPERATOR + str);
            }
            d.a.h0.a.w0.a.f0().c(SwanAppWebViewManager.this.f11657f, i2, i3, i4, i5, str, this.mIsFirstTimeShow);
            this.mIsFirstTimeShow = false;
        }

        public /* synthetic */ SwanAppWebChromeClientExt(SwanAppWebViewManager swanAppWebViewManager, a aVar) {
            this();
        }
    }
}
