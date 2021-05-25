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
import d.a.l0.a.e2.c.i;
import d.a.l0.a.e2.c.j.b;
import d.a.l0.a.h0.h.b;
import d.a.l0.a.k;
import d.a.l0.a.s1.f;
import d.a.l0.a.v2.n0;
import d.a.l0.a.v2.q0;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class SwanAppWebViewManager implements d.a.l0.a.p.e.d<NgWebView>, d.a.l0.a.h0.f.b, d.a.l0.a.h0.f.c, d.a.l0.a.z1.a.d.a<NgWebView>, SwanAppSelectPopView.a {
    public static final boolean z = k.f43199a;

    /* renamed from: e  reason: collision with root package name */
    public MutableContextWrapper f10703e;

    /* renamed from: f  reason: collision with root package name */
    public NgWebView f10704f;

    /* renamed from: g  reason: collision with root package name */
    public BdSailorWebViewClient f10705g;

    /* renamed from: h  reason: collision with root package name */
    public BdSailorWebViewClientExt f10706h;

    /* renamed from: i  reason: collision with root package name */
    public BdSailorWebChromeClient f10707i;
    public d.a.l0.a.h0.h.b j;
    public UnitedSchemeMainDispatcher k;
    public d.a.l0.a.c2.e l;
    public d.a.l0.a.h0.b n;
    public String t;
    public d.a.l0.a.y0.j.b u;
    public String v;
    public String w;
    public Handler m = new Handler(Looper.getMainLooper());
    public final e o = new e(this);
    public List<d.a.l0.a.h0.j.c> p = new ArrayList();
    public boolean q = false;
    public Drawable r = null;
    public Drawable s = null;
    public int x = -1;
    public d.a.l0.a.d1.b.a y = new d.a.l0.a.d1.b.a();

    /* loaded from: classes2.dex */
    public class SwanAppWebChromeClient extends BdSailorWebChromeClient {

        /* loaded from: classes2.dex */
        public class a implements b.s {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ JsPromptResult f10708a;

            public a(SwanAppWebChromeClient swanAppWebChromeClient, JsPromptResult jsPromptResult) {
                this.f10708a = jsPromptResult;
            }

            @Override // d.a.l0.a.h0.h.b.s
            public void a() {
                this.f10708a.cancel();
            }

            @Override // d.a.l0.a.h0.h.b.s
            public void b(String str) {
                this.f10708a.confirm(str);
            }

            @Override // d.a.l0.a.h0.h.b.s
            public void onCancel() {
                this.f10708a.cancel();
            }
        }

        /* loaded from: classes2.dex */
        public class b implements b.s {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ JsResult f10709a;

            public b(SwanAppWebChromeClient swanAppWebChromeClient, JsResult jsResult) {
                this.f10709a = jsResult;
            }

            @Override // d.a.l0.a.h0.h.b.s
            public void a() {
                this.f10709a.cancel();
            }

            @Override // d.a.l0.a.h0.h.b.s
            public void b(String str) {
                this.f10709a.confirm();
            }

            @Override // d.a.l0.a.h0.h.b.s
            public void onCancel() {
                this.f10709a.cancel();
            }
        }

        /* loaded from: classes2.dex */
        public class c implements b.s {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ JsResult f10710a;

            public c(SwanAppWebChromeClient swanAppWebChromeClient, JsResult jsResult) {
                this.f10710a = jsResult;
            }

            @Override // d.a.l0.a.h0.h.b.s
            public void a() {
                this.f10710a.cancel();
            }

            @Override // d.a.l0.a.h0.h.b.s
            public void b(String str) {
                this.f10710a.confirm();
            }

            @Override // d.a.l0.a.h0.h.b.s
            public void onCancel() {
                this.f10710a.cancel();
            }
        }

        /* loaded from: classes2.dex */
        public class d implements d.a.l0.a.v2.e1.b<i<b.e>> {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f10711e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ GeolocationPermissions.Callback f10712f;

            public d(String str, GeolocationPermissions.Callback callback) {
                this.f10711e = str;
                this.f10712f = callback;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.l0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i<b.e> iVar) {
                if (d.a.l0.a.e2.c.d.h(iVar)) {
                    SwanAppWebViewManager.this.I0(this.f10711e, this.f10712f);
                } else {
                    SwanAppWebViewManager.this.W0(this.f10711e, this.f10712f);
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
            if (SwanAppWebViewManager.this.f10707i != null) {
                SwanAppWebViewManager.this.f10707i.onCloseWindow(bdSailorWebView);
            } else {
                super.onCloseWindow(bdSailorWebView);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onConsoleMessage(BdSailorWebView bdSailorWebView, ConsoleMessage consoleMessage) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onConsoleMessage");
            }
            if (SwanAppWebViewManager.this.f10707i == null || !SwanAppWebViewManager.this.f10707i.onConsoleMessage(bdSailorWebView, consoleMessage)) {
                return super.onConsoleMessage(bdSailorWebView, consoleMessage);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onCreateWindow(BdSailorWebView bdSailorWebView, boolean z, boolean z2, Message message) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onCreateWindow");
            }
            if (SwanAppWebViewManager.this.f10707i == null || !SwanAppWebViewManager.this.f10707i.onCreateWindow(bdSailorWebView, z, z2, message)) {
                return super.onCreateWindow(bdSailorWebView, z, z2, message);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onExceededDatabaseQuota(BdSailorWebView bdSailorWebView, String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onExceededDatabaseQuota");
            }
            if (SwanAppWebViewManager.this.f10707i != null) {
                SwanAppWebViewManager.this.f10707i.onExceededDatabaseQuota(bdSailorWebView, str, str2, j, j2, j3, quotaUpdater);
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
            d.a.l0.a.a2.e i2 = d.a.l0.a.a2.e.i();
            if (i2 == null || i2.x() == null) {
                SwanAppWebViewManager.this.W0(str, callback);
            } else {
                i2.T().g(i2.x(), "mapp_location", new d(str, callback));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onHideCustomView(BdSailorWebView bdSailorWebView) {
            if (SwanAppWebViewManager.this.f10707i != null ? SwanAppWebViewManager.this.f10707i.onHideCustomView(bdSailorWebView) : false) {
                if (SwanAppWebViewManager.z) {
                    Log.i("SwanAppWebViewManager", "SwanAppWebChromeClient::onHideCustomView by external client");
                }
                return true;
            }
            if (SwanAppWebViewManager.this.F0() != null) {
                SwanAppWebViewManager.this.F0().d();
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
            if (SwanAppWebViewManager.this.f10707i == null || !SwanAppWebViewManager.this.f10707i.onJsBeforeUnload(bdSailorWebView, str, str2, jsResult)) {
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
            if (SwanAppWebViewManager.this.f10707i == null || !SwanAppWebViewManager.this.f10707i.onJsTimeout(bdSailorWebView)) {
                return super.onJsTimeout(bdSailorWebView);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onProgressChanged(BdSailorWebView bdSailorWebView, int i2) {
            if (SwanAppWebViewManager.this.f10707i != null) {
                SwanAppWebViewManager.this.f10707i.onProgressChanged(bdSailorWebView, i2);
            } else {
                super.onProgressChanged(bdSailorWebView, i2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReachedMaxAppCacheSize(BdSailorWebView bdSailorWebView, long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onReachedMaxAppCacheSize");
            }
            if (SwanAppWebViewManager.this.f10707i != null) {
                SwanAppWebViewManager.this.f10707i.onReachedMaxAppCacheSize(bdSailorWebView, j, j2, quotaUpdater);
            } else {
                super.onReachedMaxAppCacheSize(bdSailorWebView, j, j2, quotaUpdater);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedIcon(BdSailorWebView bdSailorWebView, Bitmap bitmap) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onReachedMaxAppCacheSize");
            }
            if (SwanAppWebViewManager.this.f10707i != null) {
                SwanAppWebViewManager.this.f10707i.onReceivedIcon(bdSailorWebView, bitmap);
            } else {
                super.onReceivedIcon(bdSailorWebView, bitmap);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedTitle(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onReceivedTitleInFact : " + str);
            }
            if (SwanAppWebViewManager.this.f10707i != null) {
                SwanAppWebViewManager.this.f10707i.onReceivedTitle(bdSailorWebView, str);
            } else {
                super.onReceivedTitle(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedTouchIconUrl(BdSailorWebView bdSailorWebView, String str, boolean z) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onReceivedTouchIconUrl");
            }
            if (SwanAppWebViewManager.this.f10707i != null) {
                SwanAppWebViewManager.this.f10707i.onReceivedTouchIconUrl(bdSailorWebView, str, z);
            } else {
                super.onReceivedTouchIconUrl(bdSailorWebView, str, z);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onRequestFocus(BdSailorWebView bdSailorWebView) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onRequestFocus");
            }
            if (SwanAppWebViewManager.this.f10707i != null) {
                SwanAppWebViewManager.this.f10707i.onRequestFocus(bdSailorWebView);
            } else {
                super.onRequestFocus(bdSailorWebView);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onShowCustomView(BdSailorWebView bdSailorWebView, View view, WebChromeClient.CustomViewCallback customViewCallback) {
            int i2 = 0;
            if (SwanAppWebViewManager.this.f10707i != null ? SwanAppWebViewManager.this.f10707i.onShowCustomView(bdSailorWebView, view, customViewCallback) : false) {
                if (SwanAppWebViewManager.z) {
                    Log.i("SwanAppWebViewManager", "SwanAppWebChromeClient::onShowCustomView by external client");
                }
                return true;
            }
            if (SwanAppWebViewManager.this.x != -1) {
                i2 = SwanAppWebViewManager.this.x;
            } else {
                int i3 = d.a.l0.a.a2.d.g().f40738g;
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
            if (SwanAppWebViewManager.this.f10707i != null) {
                SwanAppWebViewManager.this.f10707i.openFileChooser(bdSailorWebView, valueCallback);
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
            if (SwanAppWebViewManager.this.f10707i != null) {
                SwanAppWebViewManager.this.f10707i.openFileChooser(bdSailorWebView, valueCallback, str);
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
            if (SwanAppWebViewManager.this.f10707i != null ? SwanAppWebViewManager.this.f10707i.onShowCustomView(bdSailorWebView, view, i2, customViewCallback) : false) {
                if (SwanAppWebViewManager.z) {
                    Log.i("SwanAppWebViewManager", "SwanAppWebChromeClient::onShowCustomView by external client");
                }
                return true;
            }
            if (SwanAppWebViewManager.this.F0() != null) {
                SwanAppWebViewManager.this.F0().g(view, i2, null);
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
            if (SwanAppWebViewManager.this.f10707i != null) {
                SwanAppWebViewManager.this.f10707i.openFileChooser(bdSailorWebView, valueCallback, str, str2);
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
            public final /* synthetic */ SslErrorHandler f10715a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ BdSailorWebView f10716b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ SslError f10717c;

            public a(SslErrorHandler sslErrorHandler, BdSailorWebView bdSailorWebView, SslError sslError) {
                this.f10715a = sslErrorHandler;
                this.f10716b = bdSailorWebView;
                this.f10717c = sslError;
            }

            @Override // d.a.l0.a.h0.h.b.t
            public void a() {
                SwanAppWebViewClient.this.onReceivedSslError(this.f10716b, this.f10715a, this.f10717c);
            }

            @Override // d.a.l0.a.h0.h.b.t
            public void b() {
                this.f10715a.proceed();
            }

            @Override // d.a.l0.a.h0.h.b.t
            public void c() {
                this.f10715a.cancel();
            }
        }

        /* loaded from: classes2.dex */
        public class b implements b.r {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ BdSailorWebView f10719a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f10720b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f10721c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ HttpAuthHandler f10722d;

            public b(SwanAppWebViewClient swanAppWebViewClient, BdSailorWebView bdSailorWebView, String str, String str2, HttpAuthHandler httpAuthHandler) {
                this.f10719a = bdSailorWebView;
                this.f10720b = str;
                this.f10721c = str2;
                this.f10722d = httpAuthHandler;
            }

            @Override // d.a.l0.a.h0.h.b.r
            public void a() {
                this.f10722d.cancel();
            }

            @Override // d.a.l0.a.h0.h.b.r
            public void b(String str, String str2) {
                BdSailorWebView bdSailorWebView = this.f10719a;
                if (bdSailorWebView != null) {
                    bdSailorWebView.setHttpAuthUsernamePassword(this.f10720b, this.f10721c, str, str2);
                }
                this.f10722d.proceed(str, str2);
            }
        }

        public SwanAppWebViewClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void doUpdateVisitedHistory(BdSailorWebView bdSailorWebView, String str, boolean z) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::doUpdateVisitedHistory");
            }
            if (SwanAppWebViewManager.this.f10705g != null) {
                SwanAppWebViewManager.this.f10705g.doUpdateVisitedHistory(bdSailorWebView, str, z);
            } else {
                super.doUpdateVisitedHistory(bdSailorWebView, str, z);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onFormResubmission(BdSailorWebView bdSailorWebView, Message message, Message message2) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFormResubmission");
            }
            if (SwanAppWebViewManager.this.f10705g != null) {
                SwanAppWebViewManager.this.f10705g.onFormResubmission(bdSailorWebView, message, message2);
            } else {
                super.onFormResubmission(bdSailorWebView, message, message2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onLoadResource(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onLoadResource：" + str);
            }
            if (SwanAppWebViewManager.this.f10705g != null) {
                SwanAppWebViewManager.this.f10705g.onLoadResource(bdSailorWebView, str);
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
                WebView currentWebView = SwanAppWebViewManager.this.f10704f.getCurrentWebView();
                if (currentWebView != null) {
                    currentWebView.setBackground(SwanAppWebViewManager.this.r);
                    SwanAppWebViewManager.this.q = false;
                }
                AbsoluteLayout webViewImpl = SwanAppWebViewManager.this.f10704f.getWebViewImpl();
                if (webViewImpl != null) {
                    webViewImpl.setBackground(SwanAppWebViewManager.this.s);
                }
            }
            if (SwanAppWebViewManager.this.n != null) {
                SwanAppWebViewManager.this.n.a(str);
            }
            if (SwanAppWebViewManager.this.f10705g != null) {
                SwanAppWebViewManager.this.f10705g.onPageFinished(bdSailorWebView, str);
            } else {
                super.onPageFinished(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageStarted(BdSailorWebView bdSailorWebView, String str, Bitmap bitmap) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onPageStarted url: " + str);
            }
            if (SwanAppWebViewManager.this.f10705g != null) {
                SwanAppWebViewManager.this.f10705g.onPageStarted(bdSailorWebView, str, bitmap);
            } else {
                super.onPageStarted(bdSailorWebView, str, bitmap);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedClientCertRequest(BdSailorWebView bdSailorWebView, ClientCertRequest clientCertRequest) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedClientCertRequest");
            }
            if (SwanAppWebViewManager.this.f10705g != null) {
                SwanAppWebViewManager.this.f10705g.onReceivedClientCertRequest(bdSailorWebView, clientCertRequest);
            } else {
                super.onReceivedClientCertRequest(bdSailorWebView, clientCertRequest);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i2, String str, String str2) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedError errorCode: " + i2 + " ,failingUrl: " + str2);
            }
            if (SwanAppWebViewManager.this.f10705g != null) {
                SwanAppWebViewManager.this.f10705g.onReceivedError(bdSailorWebView, i2, str, str2);
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
            } else if (SwanAppWebViewManager.this.f10704f.isShown()) {
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
            if (SwanAppWebViewManager.this.f10705g != null) {
                SwanAppWebViewManager.this.f10705g.onReceivedHttpError(bdSailorWebView, webResourceRequest, webResourceResponse);
            } else {
                super.onReceivedHttpError(bdSailorWebView, webResourceRequest, webResourceResponse);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedLoginRequest(BdSailorWebView bdSailorWebView, String str, String str2, String str3) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedLoginRequest");
            }
            if (SwanAppWebViewManager.this.f10705g != null) {
                SwanAppWebViewManager.this.f10705g.onReceivedLoginRequest(bdSailorWebView, str, str2, str3);
            } else {
                super.onReceivedLoginRequest(bdSailorWebView, str, str2, str3);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedSslError(BdSailorWebView bdSailorWebView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedSslError");
            }
            if (SwanAppWebViewManager.this.f10704f.isShown()) {
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
            if (SwanAppWebViewManager.this.f10705g != null) {
                SwanAppWebViewManager.this.f10705g.onScaleChanged(bdSailorWebView, f2, f3);
            } else {
                super.onScaleChanged(bdSailorWebView, f2, f3);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onUnhandledKeyEvent(BdSailorWebView bdSailorWebView, KeyEvent keyEvent) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onUnhandledKeyEvent");
            }
            if (SwanAppWebViewManager.this.f10705g != null) {
                SwanAppWebViewManager.this.f10705g.onUnhandledKeyEvent(bdSailorWebView, keyEvent);
            } else {
                super.onUnhandledKeyEvent(bdSailorWebView, keyEvent);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public WebResourceResponse shouldInterceptRequest(BdSailorWebView bdSailorWebView, WebResourceRequest webResourceRequest) {
            if (webResourceRequest == null) {
                return super.shouldInterceptRequest(bdSailorWebView, webResourceRequest);
            }
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::shouldInterceptRequest");
            }
            WebResourceResponse shouldInterceptRequest = SwanAppWebViewManager.this.f10705g != null ? SwanAppWebViewManager.this.f10705g.shouldInterceptRequest(bdSailorWebView, webResourceRequest) : null;
            if (shouldInterceptRequest == null) {
                shouldInterceptRequest = d.a.l0.a.h0.o.h.a.b().c(webResourceRequest, true);
            }
            return shouldInterceptRequest == null ? super.shouldInterceptRequest(bdSailorWebView, webResourceRequest) : shouldInterceptRequest;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideKeyEvent(BdSailorWebView bdSailorWebView, KeyEvent keyEvent) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::shouldOverrideKeyEvent");
            }
            if (SwanAppWebViewManager.this.f10705g == null || !SwanAppWebViewManager.this.f10705g.shouldOverrideKeyEvent(bdSailorWebView, keyEvent)) {
                return super.shouldOverrideKeyEvent(bdSailorWebView, keyEvent);
            }
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::shouldOverrideUrlLoading url: " + str);
            }
            if (SwanAppWebViewManager.this.f10705g != null) {
                return SwanAppWebViewManager.this.f10705g.shouldOverrideUrlLoading(bdSailorWebView, str);
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
            d.a.l0.a.r1.r.a.f().a(str);
            if (SwanAppWebViewManager.this.f10706h != null) {
                SwanAppWebViewManager.this.f10706h.onFirstContentfulPaintExt(bdSailorWebView, str);
            } else {
                super.onFirstContentfulPaintExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstImagePaintExt");
            }
            if (SwanAppWebViewManager.this.f10706h != null) {
                SwanAppWebViewManager.this.f10706h.onFirstImagePaintExt(bdSailorWebView, str);
            } else {
                super.onFirstImagePaintExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.this.f10706h != null) {
                SwanAppWebViewManager.this.f10706h.onFirstLayoutDidExt(bdSailorWebView, str);
            } else {
                super.onFirstLayoutDidExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstPaintDidEx");
            }
            if (SwanAppWebViewManager.this.f10706h != null) {
                SwanAppWebViewManager.this.f10706h.onFirstPaintDidExt(bdSailorWebView, str);
            } else {
                super.onFirstPaintDidExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstScreenPaintFinishedEx");
            }
            if (SwanAppWebViewManager.this.f10706h != null) {
                SwanAppWebViewManager.this.f10706h.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            } else {
                super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstTextPaintExt");
            }
            if (SwanAppWebViewManager.this.f10706h != null) {
                SwanAppWebViewManager.this.f10706h.onFirstTextPaintExt(bdSailorWebView, str);
            } else {
                super.onFirstTextPaintExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFullScreenModeExt(BdSailorWebView bdSailorWebView, boolean z, int i2, int i3) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFullScreenModeEx");
            }
            if (SwanAppWebViewManager.this.f10706h != null) {
                SwanAppWebViewManager.this.f10706h.onFullScreenModeExt(bdSailorWebView, z, i2, i3);
            } else {
                super.onFullScreenModeExt(bdSailorWebView, z, i2, i3);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public String onGetErrorHtmlExt(BdSailorWebView bdSailorWebView, int i2, String str, String str2) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onGetErrorHtmlSailor");
            }
            if (SwanAppWebViewManager.this.f10706h != null) {
                return SwanAppWebViewManager.this.f10706h.onGetErrorHtmlExt(bdSailorWebView, i2, str, str2);
            }
            return super.onGetErrorHtmlExt(bdSailorWebView, i2, str, str2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onKeywordExtensionExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onKeywordExtensionEx");
            }
            if (SwanAppWebViewManager.this.f10706h != null) {
                return SwanAppWebViewManager.this.f10706h.onKeywordExtensionExt(bdSailorWebView, str, str2);
            }
            return super.onKeywordExtensionExt(bdSailorWebView, str, str2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageBackOrForwardExt(BdSailorWebView bdSailorWebView, int i2) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onGoBackOrForwardEx");
            }
            if (SwanAppWebViewManager.this.f10706h != null) {
                SwanAppWebViewManager.this.f10706h.onPageBackOrForwardExt(bdSailorWebView, i2);
            } else {
                super.onPageBackOrForwardExt(bdSailorWebView, i2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageCanBeScaledExt(BdSailorWebView bdSailorWebView, boolean z) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onPageCanBeScaledEx");
            }
            if (SwanAppWebViewManager.this.f10706h != null) {
                SwanAppWebViewManager.this.f10706h.onPageCanBeScaledExt(bdSailorWebView, z);
            } else {
                super.onPageCanBeScaledExt(bdSailorWebView, z);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPreloadUrlFoundExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onPreloadUrlFoundEx：" + str);
            }
            if (SwanAppWebViewManager.this.f10706h != null) {
                SwanAppWebViewManager.this.f10706h.onPreloadUrlFoundExt(bdSailorWebView, str);
            } else {
                super.onPreloadUrlFoundExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onSecurityCheckResultExt(BdSailorWebView bdSailorWebView, String str, WebViewClient.SecurityInfo securityInfo) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onSecurityCheckResultEx");
            }
            if (SwanAppWebViewManager.this.f10706h != null) {
                SwanAppWebViewManager.this.f10706h.onSecurityCheckResultExt(bdSailorWebView, str, securityInfo);
            } else {
                super.onSecurityCheckResultExt(bdSailorWebView, str, securityInfo);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onSubFrameBeforeRequest url: " + str);
            }
            if (SwanAppWebViewManager.this.f10706h != null) {
                return SwanAppWebViewManager.this.f10706h.onSubFrameBeforeRequest(bdSailorWebView, str);
            }
            return super.onSubFrameBeforeRequest(bdSailorWebView, str);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onUrlRedirectedExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onUrlRedirected");
            }
            if (SwanAppWebViewManager.this.f10706h != null) {
                SwanAppWebViewManager.this.f10706h.onUrlRedirectedExt(bdSailorWebView, str, str2);
            } else {
                super.onUrlRedirectedExt(bdSailorWebView, str, str2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean shouldHandleImageExt(BdSailorWebView bdSailorWebView, String str, String str2, String str3, boolean z) {
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::canHandleImageEx");
            }
            if (SwanAppWebViewManager.this.f10706h == null || !SwanAppWebViewManager.this.f10706h.shouldHandleImageExt(bdSailorWebView, str, str2, str3, z)) {
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
        public final /* synthetic */ String f10723e;

        public a(String str) {
            this.f10723e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.f10723e;
            if (!str.startsWith("javascript:")) {
                str = "javascript:" + str;
            }
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "webview load js:" + str);
            }
            SwanAppWebViewManager.this.f10704f.evaluateJavascript(str, null);
        }
    }

    /* loaded from: classes2.dex */
    public class b extends d.a.l0.a.o0.c {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f10725g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f10726h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f10727i;

        public b(String str, String str2, String str3) {
            this.f10725g = str;
            this.f10726h = str2;
            this.f10727i = str3;
        }

        @Override // d.a.l0.a.o0.c
        public void c() {
            SwanAppWebViewManager.this.E0(this.f10725g, this.f10726h, this.f10727i);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10728e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f10729f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f10730g;

        public c(String str, String str2, String str3) {
            this.f10728e = str;
            this.f10729f = str2;
            this.f10730g = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppWebViewManager.this.E0(this.f10728e, this.f10729f, this.f10730g);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f10732a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GeolocationPermissions.Callback f10733b;

        public d(String str, GeolocationPermissions.Callback callback) {
            this.f10732a = str;
            this.f10733b = callback;
        }

        @Override // d.a.l0.a.s1.f
        public void a(String str) {
            if (SwanAppWebViewManager.z) {
                Log.e("SwanAppWebViewManager", str + "");
            }
            SwanAppWebViewManager.this.B0(this.f10732a, this.f10733b);
        }

        @Override // d.a.l0.a.s1.f
        public void b(int i2, String str) {
            if (SwanAppWebViewManager.z) {
                Log.e("SwanAppWebViewManager", str + "");
            }
            SwanAppWebViewManager.this.W0(this.f10732a, this.f10733b);
        }
    }

    /* loaded from: classes2.dex */
    public class e {

        /* renamed from: a  reason: collision with root package name */
        public boolean f10735a = false;

        public e(SwanAppWebViewManager swanAppWebViewManager) {
        }
    }

    static {
        d.a.l0.a.h2.d.c();
        V8Engine.getInstance(0L);
    }

    public SwanAppWebViewManager(Context context) {
        this.f10703e = new MutableContextWrapper(context);
        d.a.l0.a.h0.f.d.a.k().l();
        J0();
        S0();
    }

    public final void B0(String str, GeolocationPermissions.Callback callback) {
        if (z) {
            Log.d("SwanAppWebViewManager", "allowGeoLocationOnce origin: " + str);
        }
        callback.invoke(str, true, false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.z1.a.d.a
    /* renamed from: C0 */
    public NgWebView T(Context context) {
        this.f10703e.setBaseContext(context);
        if (this.f10704f == null) {
            N0();
        }
        return this.f10704f;
    }

    public void D0() {
        d.a.l0.a.c1.a.t0().a(this.f10704f);
    }

    public final void E0(String str, String str2, String str3) {
        if (z) {
            Log.d("SwanAppWebViewManager", "handleSchemeDispatchCallback callback: " + str);
            Log.d("SwanAppWebViewManager", "handleSchemeDispatchCallback params: " + str2);
        }
        if (this.f10704f.isDestroyed()) {
            if (z) {
                Log.e("SwanAppWebViewManager", "handleSchemeDispatchCallback webview is destroyed.");
                return;
            }
            return;
        }
        this.f10704f.evaluateJavascript("javascript:" + str + "(" + str3 + SmallTailInfo.EMOTION_SUFFIX, null);
    }

    @Nullable
    public synchronized d.a.l0.a.y0.j.b F0() {
        if (this.u == null) {
            if (!d.a.l0.a.a2.d.g().r().e()) {
                return null;
            }
            SwanAppActivity x = d.a.l0.a.a2.d.g().x();
            if (x == null) {
                return null;
            }
            this.u = new d.a.l0.a.y0.j.b(x, b());
        }
        return this.u;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.p.e.d
    /* renamed from: G0 */
    public NgWebView u() {
        return this.f10704f;
    }

    public void H0() {
        this.f10704f.goBack();
    }

    @SuppressLint({"NewApi"})
    public final void I0(String str, GeolocationPermissions.Callback callback) {
        d.a.l0.a.s1.e.e("android.permission.ACCESS_FINE_LOCATION", new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, d.a.l0.a.a2.d.g().x(), new d(str, callback));
    }

    @DebugTrace
    public final void J0() {
        U0(this.o);
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
        if (this.k == null) {
            this.k = new UnitedSchemeMainDispatcher();
        }
    }

    public abstract void L0();

    public void M0() {
        this.y.e(this.f10704f, this.f10703e.getBaseContext(), this, this.k);
    }

    public final void N0() {
        if (d.a.l0.a.c1.a.Z().y()) {
            this.f10704f = new NgWebView(this.f10703e);
        } else {
            this.f10704f = new NgWebView(this.f10703e.getBaseContext());
        }
        if (this.f10704f.getCurrentWebView() != null) {
            this.r = this.f10704f.getCurrentWebView().getBackground();
            AbsoluteLayout webViewImpl = this.f10704f.getWebViewImpl();
            if (webViewImpl != null) {
                this.s = webViewImpl.getBackground();
            }
        }
        if (this.o.f10735a) {
            this.f10704f.setBackgroundColorForSwanApp(0);
            if (!BdZeusUtil.isWebkitLoaded()) {
                this.q = true;
            }
        }
        this.f10704f.setScrollBarStyle(0);
        this.j = new d.a.l0.a.h0.h.b(this.f10703e.getBaseContext());
        if (z) {
            Log.d("SwanAppWebViewManager", "WebViewManager " + hashCode() + " initializing Clients");
        }
        this.f10704f.setWebViewClient(new SwanAppWebViewClient(this, null));
        this.f10704f.setWebViewClientExt(new SwanAppWebViewClientExt(this, null));
        this.f10704f.setWebChromeClient(new SwanAppWebChromeClient(this, null));
        this.f10704f.setWebChromeClientExt(new SwanAppWebChromeClientExt(this, null));
        this.f10704f.setOverScrollMode(2);
        this.f10704f.setOnCommonEventHandler(this);
        this.f10704f.setWebViewManager(this);
        this.f10704f.getCurrentWebView().setLongClickable(true);
        this.f10704f.setSelectPopWindowListener(this);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void O0() {
        BdSailorWebSettings settings = this.f10704f.getSettings();
        ISailorWebSettingsExt settingsExt = this.f10704f.getSettingsExt();
        settings.setWebViewFrameNameSailor(c0());
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
        String path = this.f10703e.getDir("databases", 0).getPath();
        String path2 = this.f10703e.getDir("geolocation", 0).getPath();
        String path3 = this.f10703e.getDir("appcache", 0).getPath();
        settings.setGeolocationDatabasePath(path2);
        settings.setDatabasePath(path);
        settings.setAppCachePath(path3);
        if (((ActivityManager) this.f10703e.getSystemService("activity")).getMemoryClass() > 16) {
            settings.setPageCacheCapacity(5);
        } else {
            settings.setPageCacheCapacity(1);
        }
        this.v = settings.getUserAgentString();
        b1(this.w);
        try {
            settings.setPluginState(WebSettings.PluginState.ON_DEMAND);
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (NoClassDefFoundError e3) {
            e3.printStackTrace();
        }
    }

    @Override // d.a.l0.a.p.e.d
    @UiThread
    public void P() {
        this.f10704f.onPause();
        this.f10704f.pauseTimers();
    }

    public void P0() {
        if (this.k == null) {
            if (!z) {
                K0();
            } else {
                throw new IllegalStateException("initSwanAppDispatcher() must be called after initDispatcher()");
            }
        }
        this.l = d.a.l0.a.c2.a.a(this.k);
    }

    public void Q0(SwanAppWebViewManager swanAppWebViewManager) {
        this.y.f(this.f10703e.getBaseContext(), this.f10704f);
    }

    public void R0(String str) {
        q0.b0(new a(str));
    }

    @CallSuper
    public void S0() {
        d.a.l0.a.g1.i.a(this);
    }

    @CallSuper
    public void T0() {
        this.w = null;
        d.a.l0.a.g1.i.b(this);
    }

    @Override // d.a.l0.a.p.e.d
    public void U(d.a.l0.a.h0.j.c cVar) {
        if (cVar != null && this.p.contains(cVar)) {
            this.p.remove(cVar);
        }
    }

    public void U0(e eVar) {
    }

    public void V0() {
    }

    public final void W0(String str, GeolocationPermissions.Callback callback) {
        if (z) {
            Log.d("SwanAppWebViewManager", "rejectGeoLocationOnce origin: " + str);
        }
        callback.invoke(str, false, false);
    }

    public final void X0(BdSailorWebChromeClient bdSailorWebChromeClient) {
        this.f10707i = bdSailorWebChromeClient;
    }

    public final void Y0(BdSailorWebViewClient bdSailorWebViewClient) {
        this.f10705g = bdSailorWebViewClient;
    }

    public final void Z0(BdSailorWebViewClientExt bdSailorWebViewClientExt) {
        this.f10706h = bdSailorWebViewClientExt;
    }

    @Override // d.a.l0.a.p.e.d
    public String a() {
        return this.t;
    }

    public void a1(int i2) {
        this.x = i2;
        if (z) {
            Log.d("SwanAppWebViewManager", "CustomView orientation has been set to [" + this.x + "] for once");
        }
    }

    @Override // d.a.l0.a.p.e.d
    public abstract String b();

    public void b1(String str) {
        this.w = str;
        BdSailorWebSettings settings = this.f10704f.getSettings();
        String str2 = this.v;
        if (!TextUtils.isEmpty(str)) {
            str2 = String.format("%s %s", str2, str);
        }
        String b2 = d.a.l0.a.s2.a.b(str2);
        if (TextUtils.equals(b2, this.t)) {
            return;
        }
        this.t = b2;
        settings.setUserAgentString(b2);
        if (z) {
            Log.i("SwanAppWebViewManager", "set ua:" + this.t);
        }
    }

    @Override // d.a.l0.a.p.e.d
    public void c(d.a.l0.a.h0.b bVar) {
        this.n = bVar;
    }

    @Override // d.a.l0.a.p.e.d
    public String c0() {
        return "ai_apps";
    }

    public final void c1() {
        ISailorWebViewExt webViewExt = this.f10704f.getWebViewExt();
        if (webViewExt != null) {
            webViewExt.emulateShiftHeldOnNormalTextExt();
        }
    }

    public final void d1(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String path = Uri.parse(str).getPath();
        if (z) {
            Log.d("SwanAppWebViewManager", "pathList item: " + str + " ,folder: " + path + " ,parent: " + new File(path).getParent());
        }
        if (TextUtils.isEmpty(path)) {
            return;
        }
        this.f10704f.getSettings().setCodeCacheSetting(d.a.l0.a.h0.d.b.a("appframe", new File(path).getParent()));
    }

    @Override // d.a.l0.a.p.e.d
    public void destroy() {
        this.m.removeCallbacks(null);
        this.f10704f.destroy();
        this.p.clear();
        T0();
    }

    @Override // d.a.l0.a.h0.f.b
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.baidu.swan.apps.core.container.view.SwanAppSelectPopView.a
    public void doSelectionCopy(String str) {
        D0();
        d.a.l0.a.c1.a.t0().e(str, this.f10703e.getBaseContext());
    }

    @Override // com.baidu.swan.apps.core.container.view.SwanAppSelectPopView.a
    public void doSelectionSearch(String str) {
        D0();
        d.a.l0.a.c1.a.t0().d(str, this.f10703e.getBaseContext());
    }

    @Override // d.a.l0.a.p.e.d
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
        this.f10703e.setBaseContext(activity);
    }

    @Override // d.a.l0.a.p.e.d
    public void f0() {
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public String getCurrentPageUrl() {
        return u().getUrl();
    }

    @Override // com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        return 0;
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public void handleSchemeDispatchCallback(String str, String str2) {
        String quote = TextUtils.isEmpty(str2) ? "" : JSONObject.quote(str2);
        if (d.a.l0.a.r1.l.e.a()) {
            d.a.l0.a.o0.b.b().c(new b(str, str2, quote), str);
        } else {
            this.m.post(new c(str, str2, quote));
        }
    }

    @Override // d.a.l0.a.p.e.d
    public void loadUrl(String str) {
        d1(str);
        this.f10704f.loadUrl(str);
    }

    @Override // d.a.l0.a.p.e.d
    public void onJSLoaded() {
    }

    @Override // d.a.l0.a.h0.f.b
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4 && this.f10704f.canGoBack()) {
            H0();
            return true;
        }
        return false;
    }

    @Override // d.a.l0.a.p.e.d
    @CallSuper
    public void onPause() {
        this.f10704f.onPause();
        d.a.l0.a.g1.i.c(this);
    }

    @Override // d.a.l0.a.p.e.d
    @CallSuper
    public void onResume() {
        this.f10704f.onResume();
        d.a.l0.a.g1.i.d(this);
    }

    @Override // d.a.l0.a.h0.f.b
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        List<d.a.l0.a.h0.j.c> list = this.p;
        if (list != null) {
            for (d.a.l0.a.h0.j.c cVar : list) {
                if (cVar != null) {
                    cVar.onScrollChanged(i2, i3, i4, i5);
                }
            }
        }
    }

    @Override // d.a.l0.a.h0.f.b
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // d.a.l0.a.h0.f.c
    public boolean q() {
        return false;
    }

    @Override // d.a.l0.a.p.e.d
    @UiThread
    public void s() {
        this.f10704f.onResume();
        this.f10704f.resumeTimers();
    }

    @Override // d.a.l0.a.p.e.d
    public void v(d.a.l0.a.h0.j.c cVar) {
        if (cVar == null || this.p.contains(cVar)) {
            return;
        }
        this.p.add(cVar);
    }

    @Override // d.a.l0.a.h0.f.c
    public boolean w(boolean z2) {
        return z2;
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
                d.a.l0.a.e0.d.a("SwanAppWebViewManager", "onReceiveValue: " + str);
                JsonReader jsonReader = new JsonReader(new StringReader(str));
                jsonReader.setLenient(true);
                try {
                    try {
                        if (jsonReader.peek() != JsonToken.NULL && jsonReader.peek() == JsonToken.STRING) {
                            String nextString = jsonReader.nextString();
                            if (!TextUtils.isEmpty(nextString)) {
                                d.a.l0.a.c1.a.t0().b(SwanAppWebViewManager.this.f10704f, nextString);
                            }
                        }
                    } catch (IOException e2) {
                        if (SwanAppWebViewManager.z) {
                            e2.printStackTrace();
                        }
                    }
                } finally {
                    d.a.l0.t.d.d(jsonReader);
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
            SwanAppWebViewManager.this.f10704f.hidePopWindow();
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
                SwanAppWebViewManager.this.c1();
            } else if (type == 5) {
                SwanAppWebViewManager.this.f10704f.evaluateJavascript(String.format("javascript:(function(){return window.getImageSrcByCoordinate(%s,%s);})()", Integer.valueOf(n0.K(i2)), Integer.valueOf(n0.K(i3))), new a());
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClientExt
        public void showSelectionActionDialogExt(BdSailorWebView bdSailorWebView, int i2, int i3, int i4, int i5, String str) {
            super.showSelectionActionDialogExt(bdSailorWebView, i2, i3, i4, i5, str);
            if (SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "showSelectionActionDialogExt: " + i4 + ZeusCrashHandler.NAME_SEPERATOR + i5 + ZeusCrashHandler.NAME_SEPERATOR + i2 + ZeusCrashHandler.NAME_SEPERATOR + i3 + ZeusCrashHandler.NAME_SEPERATOR + str);
            }
            d.a.l0.a.c1.a.t0().c(SwanAppWebViewManager.this.f10704f, i2, i3, i4, i5, str, this.mIsFirstTimeShow);
            this.mIsFirstTimeShow = false;
        }

        public /* synthetic */ SwanAppWebChromeClientExt(SwanAppWebViewManager swanAppWebViewManager, a aVar) {
            this();
        }
    }
}
