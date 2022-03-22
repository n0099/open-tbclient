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
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.l1.f;
import c.a.n0.a.p2.n0;
import c.a.n0.a.p2.q0;
import c.a.n0.a.v1.e;
import c.a.n0.a.x.h.b;
import c.a.n0.a.x1.c.i;
import c.a.n0.a.x1.c.j.b;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class SwanAppWebViewManager implements c.a.n0.a.f.e.d<NgWebView>, c.a.n0.a.x.f.b, c.a.n0.a.x.f.c, c.a.n0.a.s1.a.d.a<NgWebView>, SwanAppSelectPopView.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean v;
    public transient /* synthetic */ FieldHolder $fh;
    public MutableContextWrapper a;

    /* renamed from: b  reason: collision with root package name */
    public NgWebView f28827b;

    /* renamed from: c  reason: collision with root package name */
    public BdSailorWebViewClient f28828c;

    /* renamed from: d  reason: collision with root package name */
    public BdSailorWebViewClientExt f28829d;

    /* renamed from: e  reason: collision with root package name */
    public BdSailorWebChromeClient f28830e;

    /* renamed from: f  reason: collision with root package name */
    public c.a.n0.a.x.h.b f28831f;

    /* renamed from: g  reason: collision with root package name */
    public UnitedSchemeMainDispatcher f28832g;

    /* renamed from: h  reason: collision with root package name */
    public e f28833h;
    public Handler i;
    public c.a.n0.a.x.b j;
    public final d k;
    public List<c.a.n0.a.x.j.c> l;
    public boolean m;
    public Drawable n;
    public Drawable o;
    public String p;
    public c.a.n0.a.o0.j.b q;
    public String r;
    public String s;
    public int t;
    public c.a.n0.a.t0.b.a u;

    /* loaded from: classes4.dex */
    public class SwanAppWebChromeClient extends BdSailorWebChromeClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppWebViewManager this$0;

        /* loaded from: classes4.dex */
        public class a implements b.s {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ JsPromptResult a;

            public a(SwanAppWebChromeClient swanAppWebChromeClient, JsPromptResult jsPromptResult) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {swanAppWebChromeClient, jsPromptResult};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = jsPromptResult;
            }

            @Override // c.a.n0.a.x.h.b.s
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.cancel();
                }
            }

            @Override // c.a.n0.a.x.h.b.s
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    this.a.confirm(str);
                }
            }

            @Override // c.a.n0.a.x.h.b.s
            public void onCancel() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.a.cancel();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements b.s {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ JsResult a;

            public b(SwanAppWebChromeClient swanAppWebChromeClient, JsResult jsResult) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {swanAppWebChromeClient, jsResult};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = jsResult;
            }

            @Override // c.a.n0.a.x.h.b.s
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.cancel();
                }
            }

            @Override // c.a.n0.a.x.h.b.s
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    this.a.confirm();
                }
            }

            @Override // c.a.n0.a.x.h.b.s
            public void onCancel() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.a.cancel();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class c implements b.s {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ JsResult a;

            public c(SwanAppWebChromeClient swanAppWebChromeClient, JsResult jsResult) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {swanAppWebChromeClient, jsResult};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = jsResult;
            }

            @Override // c.a.n0.a.x.h.b.s
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.cancel();
                }
            }

            @Override // c.a.n0.a.x.h.b.s
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    this.a.confirm();
                }
            }

            @Override // c.a.n0.a.x.h.b.s
            public void onCancel() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.a.cancel();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class d implements c.a.n0.a.p2.g1.c<i<b.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ GeolocationPermissions.Callback f28834b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ SwanAppWebChromeClient f28835c;

            public d(SwanAppWebChromeClient swanAppWebChromeClient, String str, GeolocationPermissions.Callback callback) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {swanAppWebChromeClient, str, callback};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f28835c = swanAppWebChromeClient;
                this.a = str;
                this.f28834b = callback;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.n0.a.p2.g1.c
            /* renamed from: a */
            public void onCallback(i<b.e> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    if (c.a.n0.a.x1.c.d.h(iVar)) {
                        this.f28835c.this$0.L0(this.a, this.f28834b);
                    } else {
                        this.f28835c.this$0.Z0(this.a, this.f28834b);
                    }
                }
            }
        }

        public SwanAppWebChromeClient(SwanAppWebViewManager swanAppWebViewManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppWebViewManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = swanAppWebViewManager;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onCloseWindow(BdSailorWebView bdSailorWebView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdSailorWebView) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onCloseWindow");
                }
                if (this.this$0.f28830e != null) {
                    this.this$0.f28830e.onCloseWindow(bdSailorWebView);
                } else {
                    super.onCloseWindow(bdSailorWebView);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onConsoleMessage(BdSailorWebView bdSailorWebView, ConsoleMessage consoleMessage) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdSailorWebView, consoleMessage)) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onConsoleMessage");
                }
                if (this.this$0.f28830e == null || !this.this$0.f28830e.onConsoleMessage(bdSailorWebView, consoleMessage)) {
                    return super.onConsoleMessage(bdSailorWebView, consoleMessage);
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onCreateWindow(BdSailorWebView bdSailorWebView, boolean z, boolean z2, Message message) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bdSailorWebView, Boolean.valueOf(z), Boolean.valueOf(z2), message})) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onCreateWindow");
                }
                if (this.this$0.f28830e == null || !this.this$0.f28830e.onCreateWindow(bdSailorWebView, z, z2, message)) {
                    return super.onCreateWindow(bdSailorWebView, z, z2, message);
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onExceededDatabaseQuota(BdSailorWebView bdSailorWebView, String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{bdSailorWebView, str, str2, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), quotaUpdater}) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onExceededDatabaseQuota");
                }
                if (this.this$0.f28830e != null) {
                    this.this$0.f28830e.onExceededDatabaseQuota(bdSailorWebView, str, str2, j, j2, j3, quotaUpdater);
                } else {
                    super.onExceededDatabaseQuota(bdSailorWebView, str, str2, j, j2, j3, quotaUpdater);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onGeolocationPermissionsHidePrompt(BdSailorWebView bdSailorWebView) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, bdSailorWebView) == null) && SwanAppWebViewManager.v) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onGeolocationPermissionsHidePrompt");
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onGeolocationPermissionsShowPrompt(BdSailorWebView bdSailorWebView, String str, GeolocationPermissions.Callback callback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048581, this, bdSailorWebView, str, callback) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onGeolocationPermissionsShowPrompt");
                }
                c.a.n0.a.t1.e L = c.a.n0.a.t1.e.L();
                if (L == null || L.x() == null) {
                    this.this$0.Z0(str, callback);
                } else {
                    L.d0().g(L.x(), "mapp_location", new d(this, str, callback));
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onHideCustomView(BdSailorWebView bdSailorWebView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bdSailorWebView)) == null) {
                if (this.this$0.f28830e != null ? this.this$0.f28830e.onHideCustomView(bdSailorWebView) : false) {
                    if (SwanAppWebViewManager.v) {
                        Log.i("SwanAppWebViewManager", "SwanAppWebChromeClient::onHideCustomView by external client");
                    }
                    return true;
                }
                if (this.this$0.I0() != null) {
                    this.this$0.I0().d();
                }
                if (SwanAppWebViewManager.v) {
                    Log.i("SwanAppWebViewManager", "SwanAppWebChromeClient::onHideCustomView");
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onJsAlert(BdSailorWebView bdSailorWebView, String str, String str2, JsResult jsResult) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, bdSailorWebView, str, str2, jsResult)) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onJsAlert");
                }
                return this.this$0.f28831f.l(str, str2, new b(this, jsResult));
            }
            return invokeLLLL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onJsBeforeUnload(BdSailorWebView bdSailorWebView, String str, String str2, JsResult jsResult) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdSailorWebView, str, str2, jsResult)) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onJsBeforeUnload：" + str);
                }
                if (this.this$0.f28830e == null || !this.this$0.f28830e.onJsBeforeUnload(bdSailorWebView, str, str2, jsResult)) {
                    return super.onJsBeforeUnload(bdSailorWebView, str, str2, jsResult);
                }
                return true;
            }
            return invokeLLLL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onJsConfirm(BdSailorWebView bdSailorWebView, String str, String str2, JsResult jsResult) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048585, this, bdSailorWebView, str, str2, jsResult)) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onJsConfirm");
                }
                return this.this$0.f28831f.m(str, str2, new c(this, jsResult));
            }
            return invokeLLLL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onJsPrompt(BdSailorWebView bdSailorWebView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            InterceptResult invokeLLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048586, this, bdSailorWebView, str, str2, str3, jsPromptResult)) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onJsPrompt");
                }
                return this.this$0.f28831f.n(str, str2, str3, new a(this, jsPromptResult));
            }
            return invokeLLLLL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onJsTimeout(BdSailorWebView bdSailorWebView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bdSailorWebView)) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onJsTimeout  ");
                }
                if (this.this$0.f28830e == null || !this.this$0.f28830e.onJsTimeout(bdSailorWebView)) {
                    return super.onJsTimeout(bdSailorWebView);
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onProgressChanged(BdSailorWebView bdSailorWebView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048588, this, bdSailorWebView, i) == null) {
                if (this.this$0.f28830e != null) {
                    this.this$0.f28830e.onProgressChanged(bdSailorWebView, i);
                } else {
                    super.onProgressChanged(bdSailorWebView, i);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReachedMaxAppCacheSize(BdSailorWebView bdSailorWebView, long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{bdSailorWebView, Long.valueOf(j), Long.valueOf(j2), quotaUpdater}) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onReachedMaxAppCacheSize");
                }
                if (this.this$0.f28830e != null) {
                    this.this$0.f28830e.onReachedMaxAppCacheSize(bdSailorWebView, j, j2, quotaUpdater);
                } else {
                    super.onReachedMaxAppCacheSize(bdSailorWebView, j, j2, quotaUpdater);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedIcon(BdSailorWebView bdSailorWebView, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048590, this, bdSailorWebView, bitmap) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onReachedMaxAppCacheSize");
                }
                if (this.this$0.f28830e != null) {
                    this.this$0.f28830e.onReceivedIcon(bdSailorWebView, bitmap);
                } else {
                    super.onReceivedIcon(bdSailorWebView, bitmap);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedTitle(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048591, this, bdSailorWebView, str) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onReceivedTitleInFact : " + str);
                }
                if (this.this$0.f28830e != null) {
                    this.this$0.f28830e.onReceivedTitle(bdSailorWebView, str);
                } else {
                    super.onReceivedTitle(bdSailorWebView, str);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedTouchIconUrl(BdSailorWebView bdSailorWebView, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048592, this, bdSailorWebView, str, z) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onReceivedTouchIconUrl");
                }
                if (this.this$0.f28830e != null) {
                    this.this$0.f28830e.onReceivedTouchIconUrl(bdSailorWebView, str, z);
                } else {
                    super.onReceivedTouchIconUrl(bdSailorWebView, str, z);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onRequestFocus(BdSailorWebView bdSailorWebView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, bdSailorWebView) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onRequestFocus");
                }
                if (this.this$0.f28830e != null) {
                    this.this$0.f28830e.onRequestFocus(bdSailorWebView);
                } else {
                    super.onRequestFocus(bdSailorWebView);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onShowCustomView(BdSailorWebView bdSailorWebView, View view, WebChromeClient.CustomViewCallback customViewCallback) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048595, this, bdSailorWebView, view, customViewCallback)) == null) {
                int i = 0;
                if (this.this$0.f28830e != null ? this.this$0.f28830e.onShowCustomView(bdSailorWebView, view, customViewCallback) : false) {
                    if (SwanAppWebViewManager.v) {
                        Log.i("SwanAppWebViewManager", "SwanAppWebChromeClient::onShowCustomView by external client");
                    }
                    return true;
                }
                if (this.this$0.t != -1) {
                    i = this.this$0.t;
                } else {
                    int i2 = c.a.n0.a.t1.d.J().f6334c;
                    if (i2 >= 35 && i2 < 180) {
                        i = 8;
                    }
                }
                onShowCustomView(bdSailorWebView, view, i, customViewCallback);
                return true;
            }
            return invokeLLL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onShowFileChooser(BdSailorWebView bdSailorWebView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048596, this, bdSailorWebView, valueCallback, fileChooserParams)) == null) ? super.onShowFileChooser(bdSailorWebView, valueCallback, fileChooserParams) : invokeLLL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void openFileChooser(BdSailorWebView bdSailorWebView, ValueCallback valueCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048597, this, bdSailorWebView, valueCallback) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::openFileChooser");
                }
                if (this.this$0.f28830e != null) {
                    this.this$0.f28830e.openFileChooser(bdSailorWebView, valueCallback);
                } else {
                    super.openFileChooser(bdSailorWebView, valueCallback);
                }
            }
        }

        public /* synthetic */ SwanAppWebChromeClient(SwanAppWebViewManager swanAppWebViewManager, a aVar) {
            this(swanAppWebViewManager);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void openFileChooser(BdSailorWebView bdSailorWebView, ValueCallback valueCallback, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048598, this, bdSailorWebView, valueCallback, str) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::openFileChooser");
                }
                if (this.this$0.f28830e != null) {
                    this.this$0.f28830e.openFileChooser(bdSailorWebView, valueCallback, str);
                } else {
                    super.openFileChooser(bdSailorWebView, valueCallback, str);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onShowCustomView(BdSailorWebView bdSailorWebView, View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
            InterceptResult invokeLLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048594, this, bdSailorWebView, view, i, customViewCallback)) == null) {
                this.this$0.t = -1;
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "CustomView orientation applied, set back to default [" + this.this$0.t + PreferencesUtil.RIGHT_MOUNT);
                }
                if (this.this$0.f28830e != null ? this.this$0.f28830e.onShowCustomView(bdSailorWebView, view, i, customViewCallback) : false) {
                    if (SwanAppWebViewManager.v) {
                        Log.i("SwanAppWebViewManager", "SwanAppWebChromeClient::onShowCustomView by external client");
                    }
                    return true;
                }
                if (this.this$0.I0() != null) {
                    this.this$0.I0().g(view, i, null);
                }
                if (SwanAppWebViewManager.v) {
                    Log.i("SwanAppWebViewManager", "SwanAppWebChromeClient::onShowCustomView : " + i);
                }
                return true;
            }
            return invokeLLIL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void openFileChooser(BdSailorWebView bdSailorWebView, ValueCallback valueCallback, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048599, this, bdSailorWebView, valueCallback, str, str2) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::openFileChooser");
                }
                if (this.this$0.f28830e != null) {
                    this.this$0.f28830e.openFileChooser(bdSailorWebView, valueCallback, str, str2);
                } else {
                    super.openFileChooser(bdSailorWebView, valueCallback, str, str2);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class SwanAppWebViewClient extends BdSailorWebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppWebViewManager this$0;

        /* loaded from: classes4.dex */
        public class a implements Function1<WebResourceResponse, com.baidu.webkit.sdk.WebResourceResponse> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(SwanAppWebViewClient swanAppWebViewClient) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {swanAppWebViewClient};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public com.baidu.webkit.sdk.WebResourceResponse invoke(WebResourceResponse webResourceResponse) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, webResourceResponse)) == null) {
                    if (webResourceResponse == null) {
                        return null;
                    }
                    return new com.baidu.webkit.sdk.WebResourceResponse(false, webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase(), webResourceResponse.getResponseHeaders(), webResourceResponse.getData());
                }
                return (com.baidu.webkit.sdk.WebResourceResponse) invokeL.objValue;
            }
        }

        /* loaded from: classes4.dex */
        public class b implements b.t {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SslErrorHandler a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ BdSailorWebView f28836b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ SslError f28837c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ SwanAppWebViewClient f28838d;

            public b(SwanAppWebViewClient swanAppWebViewClient, SslErrorHandler sslErrorHandler, BdSailorWebView bdSailorWebView, SslError sslError) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {swanAppWebViewClient, sslErrorHandler, bdSailorWebView, sslError};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f28838d = swanAppWebViewClient;
                this.a = sslErrorHandler;
                this.f28836b = bdSailorWebView;
                this.f28837c = sslError;
            }

            @Override // c.a.n0.a.x.h.b.t
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f28838d.onReceivedSslError(this.f28836b, this.a, this.f28837c);
                }
            }

            @Override // c.a.n0.a.x.h.b.t
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a.proceed();
                }
            }

            @Override // c.a.n0.a.x.h.b.t
            public void c() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.a.cancel();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class c implements b.r {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BdSailorWebView a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f28839b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f28840c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ HttpAuthHandler f28841d;

            public c(SwanAppWebViewClient swanAppWebViewClient, BdSailorWebView bdSailorWebView, String str, String str2, HttpAuthHandler httpAuthHandler) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {swanAppWebViewClient, bdSailorWebView, str, str2, httpAuthHandler};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bdSailorWebView;
                this.f28839b = str;
                this.f28840c = str2;
                this.f28841d = httpAuthHandler;
            }

            @Override // c.a.n0.a.x.h.b.r
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f28841d.cancel();
                }
            }

            @Override // c.a.n0.a.x.h.b.r
            public void b(String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
                    BdSailorWebView bdSailorWebView = this.a;
                    if (bdSailorWebView != null) {
                        bdSailorWebView.setHttpAuthUsernamePassword(this.f28839b, this.f28840c, str, str2);
                    }
                    this.f28841d.proceed(str, str2);
                }
            }
        }

        public SwanAppWebViewClient(SwanAppWebViewManager swanAppWebViewManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppWebViewManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = swanAppWebViewManager;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void doUpdateVisitedHistory(BdSailorWebView bdSailorWebView, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, bdSailorWebView, str, z) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::doUpdateVisitedHistory");
                }
                if (this.this$0.f28828c != null) {
                    this.this$0.f28828c.doUpdateVisitedHistory(bdSailorWebView, str, z);
                } else {
                    super.doUpdateVisitedHistory(bdSailorWebView, str, z);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onFormResubmission(BdSailorWebView bdSailorWebView, Message message, Message message2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdSailorWebView, message, message2) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFormResubmission");
                }
                if (this.this$0.f28828c != null) {
                    this.this$0.f28828c.onFormResubmission(bdSailorWebView, message, message2);
                } else {
                    super.onFormResubmission(bdSailorWebView, message, message2);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onLoadResource(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bdSailorWebView, str) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onLoadResource：" + str);
                }
                if (this.this$0.f28828c != null) {
                    this.this$0.f28828c.onLoadResource(bdSailorWebView, str);
                } else {
                    super.onLoadResource(bdSailorWebView, str);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, bdSailorWebView, str) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onPageFinished url: " + str);
                }
                if (this.this$0.m) {
                    WebView currentWebView = this.this$0.f28827b.getCurrentWebView();
                    if (currentWebView != null) {
                        currentWebView.setBackground(this.this$0.n);
                        this.this$0.m = false;
                    }
                    View webViewImpl = this.this$0.f28827b.getWebViewImpl();
                    if (webViewImpl != null) {
                        webViewImpl.setBackground(this.this$0.o);
                    }
                }
                if (this.this$0.j != null) {
                    this.this$0.j.a(str);
                }
                if (this.this$0.f28828c != null) {
                    this.this$0.f28828c.onPageFinished(bdSailorWebView, str);
                } else {
                    super.onPageFinished(bdSailorWebView, str);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageStarted(BdSailorWebView bdSailorWebView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048580, this, bdSailorWebView, str, bitmap) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onPageStarted url: " + str);
                }
                if (this.this$0.f28828c != null) {
                    this.this$0.f28828c.onPageStarted(bdSailorWebView, str, bitmap);
                } else {
                    super.onPageStarted(bdSailorWebView, str, bitmap);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedClientCertRequest(BdSailorWebView bdSailorWebView, ClientCertRequest clientCertRequest) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, bdSailorWebView, clientCertRequest) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedClientCertRequest");
                }
                if (this.this$0.f28828c != null) {
                    this.this$0.f28828c.onReceivedClientCertRequest(bdSailorWebView, clientCertRequest);
                } else {
                    super.onReceivedClientCertRequest(bdSailorWebView, clientCertRequest);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048582, this, bdSailorWebView, i, str, str2) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedError errorCode: " + i + " ,failingUrl: " + str2);
                }
                if (this.this$0.f28828c != null) {
                    this.this$0.f28828c.onReceivedError(bdSailorWebView, i, str, str2);
                } else {
                    super.onReceivedError(bdSailorWebView, i, str, str2);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedHttpAuthRequest(BdSailorWebView bdSailorWebView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            String str3;
            String[] httpAuthUsernamePassword;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048583, this, bdSailorWebView, httpAuthHandler, str, str2) == null) {
                if (SwanAppWebViewManager.v) {
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
                    if (SwanAppWebViewManager.v) {
                        Log.d("SwanAppWebViewManager", "OnReceivedHttpAuthRequest Reuse Http Auth Username & PassWord");
                    }
                    httpAuthHandler.proceed(str4, str3);
                } else if (this.this$0.f28827b.isShown()) {
                    if (SwanAppWebViewManager.v) {
                        Log.d("SwanAppWebViewManager", "OnReceivedHttpAuthRequest show Http Auth dialog ");
                    }
                    this.this$0.f28831f.k(new c(this, bdSailorWebView, str, str2, httpAuthHandler), str, str2);
                } else {
                    httpAuthHandler.cancel();
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedHttpError(BdSailorWebView bdSailorWebView, WebResourceRequest webResourceRequest, com.baidu.webkit.sdk.WebResourceResponse webResourceResponse) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdSailorWebView, webResourceRequest, webResourceResponse) == null) {
                if (this.this$0.f28828c != null) {
                    this.this$0.f28828c.onReceivedHttpError(bdSailorWebView, webResourceRequest, webResourceResponse);
                } else {
                    super.onReceivedHttpError(bdSailorWebView, webResourceRequest, webResourceResponse);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedLoginRequest(BdSailorWebView bdSailorWebView, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048585, this, bdSailorWebView, str, str2, str3) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedLoginRequest");
                }
                if (this.this$0.f28828c != null) {
                    this.this$0.f28828c.onReceivedLoginRequest(bdSailorWebView, str, str2, str3);
                } else {
                    super.onReceivedLoginRequest(bdSailorWebView, str, str2, str3);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedSslError(BdSailorWebView bdSailorWebView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048586, this, bdSailorWebView, sslErrorHandler, sslError) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedSslError");
                }
                if (this.this$0.f28827b.isShown()) {
                    this.this$0.f28831f.p(new b(this, sslErrorHandler, bdSailorWebView, sslError), sslErrorHandler, sslError);
                } else {
                    sslErrorHandler.cancel();
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onScaleChanged(BdSailorWebView bdSailorWebView, float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{bdSailorWebView, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onScaleChanged");
                }
                if (this.this$0.f28828c != null) {
                    this.this$0.f28828c.onScaleChanged(bdSailorWebView, f2, f3);
                } else {
                    super.onScaleChanged(bdSailorWebView, f2, f3);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onUnhandledKeyEvent(BdSailorWebView bdSailorWebView, KeyEvent keyEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048588, this, bdSailorWebView, keyEvent) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onUnhandledKeyEvent");
                }
                if (this.this$0.f28828c != null) {
                    this.this$0.f28828c.onUnhandledKeyEvent(bdSailorWebView, keyEvent);
                } else {
                    super.onUnhandledKeyEvent(bdSailorWebView, keyEvent);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public com.baidu.webkit.sdk.WebResourceResponse shouldInterceptRequest(BdSailorWebView bdSailorWebView, WebResourceRequest webResourceRequest) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, bdSailorWebView, webResourceRequest)) == null) {
                if (webResourceRequest == null) {
                    return super.shouldInterceptRequest(bdSailorWebView, webResourceRequest);
                }
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::shouldInterceptRequest");
                }
                c.a.n0.z.b.c cVar = c.a.n0.z.b.c.f9598b;
                com.baidu.webkit.sdk.WebResourceResponse webResourceResponse = (com.baidu.webkit.sdk.WebResourceResponse) cVar.c(cVar.b(webResourceRequest.getUrl()), new a(this));
                if (webResourceResponse != null) {
                    return webResourceResponse;
                }
                if (this.this$0.f28828c != null) {
                    webResourceResponse = this.this$0.f28828c.shouldInterceptRequest(bdSailorWebView, webResourceRequest);
                }
                if (webResourceResponse == null) {
                    webResourceResponse = c.a.n0.a.x.o.g.a.b().c(webResourceRequest, true);
                }
                return webResourceResponse == null ? super.shouldInterceptRequest(bdSailorWebView, webResourceRequest) : webResourceResponse;
            }
            return (com.baidu.webkit.sdk.WebResourceResponse) invokeLL.objValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideKeyEvent(BdSailorWebView bdSailorWebView, KeyEvent keyEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, bdSailorWebView, keyEvent)) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::shouldOverrideKeyEvent");
                }
                if (this.this$0.f28828c == null || !this.this$0.f28828c.shouldOverrideKeyEvent(bdSailorWebView, keyEvent)) {
                    return super.shouldOverrideKeyEvent(bdSailorWebView, keyEvent);
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, bdSailorWebView, str)) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::shouldOverrideUrlLoading url: " + str);
                }
                if (this.this$0.f28828c != null) {
                    return this.this$0.f28828c.shouldOverrideUrlLoading(bdSailorWebView, str);
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        public /* synthetic */ SwanAppWebViewClient(SwanAppWebViewManager swanAppWebViewManager, a aVar) {
            this(swanAppWebViewManager);
        }
    }

    /* loaded from: classes4.dex */
    public class SwanAppWebViewClientExt extends BdSailorWebViewClientExt {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppWebViewManager this$0;

        public SwanAppWebViewClientExt(SwanAppWebViewManager swanAppWebViewManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppWebViewManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = swanAppWebViewManager;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, bdSailorWebView, str) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstContentfulPaintExt");
                }
                c.a.n0.a.k1.r.a.g().a(str);
                if (this.this$0.f28829d != null) {
                    this.this$0.f28829d.onFirstContentfulPaintExt(bdSailorWebView, str);
                } else {
                    super.onFirstContentfulPaintExt(bdSailorWebView, str);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdSailorWebView, str) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstImagePaintExt");
                }
                if (this.this$0.f28829d != null) {
                    this.this$0.f28829d.onFirstImagePaintExt(bdSailorWebView, str);
                } else {
                    super.onFirstImagePaintExt(bdSailorWebView, str);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bdSailorWebView, str) == null) {
                if (this.this$0.f28829d != null) {
                    this.this$0.f28829d.onFirstLayoutDidExt(bdSailorWebView, str);
                } else {
                    super.onFirstLayoutDidExt(bdSailorWebView, str);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, bdSailorWebView, str) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstPaintDidEx");
                }
                if (this.this$0.f28829d != null) {
                    this.this$0.f28829d.onFirstPaintDidExt(bdSailorWebView, str);
                } else {
                    super.onFirstPaintDidExt(bdSailorWebView, str);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, bdSailorWebView, str) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstScreenPaintFinishedEx");
                }
                if (this.this$0.f28829d != null) {
                    this.this$0.f28829d.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
                } else {
                    super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, bdSailorWebView, str) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstTextPaintExt");
                }
                if (this.this$0.f28829d != null) {
                    this.this$0.f28829d.onFirstTextPaintExt(bdSailorWebView, str);
                } else {
                    super.onFirstTextPaintExt(bdSailorWebView, str);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFullScreenModeExt(BdSailorWebView bdSailorWebView, boolean z, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{bdSailorWebView, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFullScreenModeEx");
                }
                if (this.this$0.f28829d != null) {
                    this.this$0.f28829d.onFullScreenModeExt(bdSailorWebView, z, i, i2);
                } else {
                    super.onFullScreenModeExt(bdSailorWebView, z, i, i2);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public String onGetErrorHtmlExt(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            InterceptResult invokeLILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048583, this, bdSailorWebView, i, str, str2)) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onGetErrorHtmlSailor");
                }
                if (this.this$0.f28829d != null) {
                    return this.this$0.f28829d.onGetErrorHtmlExt(bdSailorWebView, i, str, str2);
                }
                return super.onGetErrorHtmlExt(bdSailorWebView, i, str, str2);
            }
            return (String) invokeLILL.objValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onJsCodeCacheFinished(JsCodeCacheResult jsCodeCacheResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsCodeCacheResult) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onJsCodeCachedFinished : " + jsCodeCacheResult);
                }
                if (this.this$0.f28829d != null) {
                    this.this$0.f28829d.onJsCodeCacheFinished(jsCodeCacheResult);
                } else {
                    super.onJsCodeCacheFinished(jsCodeCacheResult);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onKeywordExtensionExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, bdSailorWebView, str, str2)) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onKeywordExtensionEx");
                }
                if (this.this$0.f28829d != null) {
                    return this.this$0.f28829d.onKeywordExtensionExt(bdSailorWebView, str, str2);
                }
                return super.onKeywordExtensionExt(bdSailorWebView, str, str2);
            }
            return invokeLLL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageBackOrForwardExt(BdSailorWebView bdSailorWebView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048586, this, bdSailorWebView, i) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onGoBackOrForwardEx");
                }
                if (this.this$0.f28829d != null) {
                    this.this$0.f28829d.onPageBackOrForwardExt(bdSailorWebView, i);
                } else {
                    super.onPageBackOrForwardExt(bdSailorWebView, i);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageCanBeScaledExt(BdSailorWebView bdSailorWebView, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048587, this, bdSailorWebView, z) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onPageCanBeScaledEx");
                }
                if (this.this$0.f28829d != null) {
                    this.this$0.f28829d.onPageCanBeScaledExt(bdSailorWebView, z);
                } else {
                    super.onPageCanBeScaledExt(bdSailorWebView, z);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPreloadUrlFoundExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048588, this, bdSailorWebView, str) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onPreloadUrlFoundEx：" + str);
                }
                if (this.this$0.f28829d != null) {
                    this.this$0.f28829d.onPreloadUrlFoundExt(bdSailorWebView, str);
                } else {
                    super.onPreloadUrlFoundExt(bdSailorWebView, str);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onSecurityCheckResultExt(BdSailorWebView bdSailorWebView, String str, WebViewClient.SecurityInfo securityInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048589, this, bdSailorWebView, str, securityInfo) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onSecurityCheckResultEx");
                }
                if (this.this$0.f28829d != null) {
                    this.this$0.f28829d.onSecurityCheckResultExt(bdSailorWebView, str, securityInfo);
                } else {
                    super.onSecurityCheckResultExt(bdSailorWebView, str, securityInfo);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, bdSailorWebView, str)) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onSubFrameBeforeRequest url: " + str);
                }
                if (this.this$0.f28829d != null) {
                    return this.this$0.f28829d.onSubFrameBeforeRequest(bdSailorWebView, str);
                }
                return super.onSubFrameBeforeRequest(bdSailorWebView, str);
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onUrlRedirectedExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048591, this, bdSailorWebView, str, str2) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onUrlRedirected");
                }
                if (this.this$0.f28829d != null) {
                    this.this$0.f28829d.onUrlRedirectedExt(bdSailorWebView, str, str2);
                } else {
                    super.onUrlRedirectedExt(bdSailorWebView, str, str2);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean shouldHandleImageExt(BdSailorWebView bdSailorWebView, String str, String str2, String str3, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{bdSailorWebView, str, str2, str3, Boolean.valueOf(z)})) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::canHandleImageEx");
                }
                if (this.this$0.f28829d == null || !this.this$0.f28829d.shouldHandleImageExt(bdSailorWebView, str, str2, str3, z)) {
                    return super.shouldHandleImageExt(bdSailorWebView, str, str2, str3, z);
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }

        public /* synthetic */ SwanAppWebViewClientExt(SwanAppWebViewManager swanAppWebViewManager, a aVar) {
            this(swanAppWebViewManager);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppWebViewManager f28842b;

        public a(SwanAppWebViewManager swanAppWebViewManager, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppWebViewManager, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28842b = swanAppWebViewManager;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = this.a;
                if (!str.startsWith("javascript:")) {
                    str = "javascript:" + str;
                }
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "webview load js:" + str);
                }
                this.f28842b.f28827b.evaluateJavascript(str, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends c.a.n0.a.e0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f28843c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f28844d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f28845e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppWebViewManager f28846f;

        public b(SwanAppWebViewManager swanAppWebViewManager, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppWebViewManager, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28846f = swanAppWebViewManager;
            this.f28843c = str;
            this.f28844d = str2;
            this.f28845e = str3;
        }

        @Override // c.a.n0.a.e0.c
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f28846f.H0(this.f28843c, this.f28844d, this.f28845e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GeolocationPermissions.Callback f28847b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SwanAppWebViewManager f28848c;

        public c(SwanAppWebViewManager swanAppWebViewManager, String str, GeolocationPermissions.Callback callback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppWebViewManager, str, callback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28848c = swanAppWebViewManager;
            this.a = str;
            this.f28847b = callback;
        }

        @Override // c.a.n0.a.l1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.w("SwanAppWebViewManager", "#handleLocationAuthorized(success) msg=" + str);
                }
                this.f28848c.E0(this.a, this.f28847b);
            }
        }

        @Override // c.a.n0.a.l1.f
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                if (SwanAppWebViewManager.v) {
                    Log.e("SwanAppWebViewManager", "#handleLocationAuthorized(failed) msg=" + str);
                }
                this.f28848c.Z0(this.a, this.f28847b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f28849b;

        public d(SwanAppWebViewManager swanAppWebViewManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppWebViewManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = false;
            this.f28849b = false;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-79803046, "Lcom/baidu/swan/apps/core/SwanAppWebViewManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-79803046, "Lcom/baidu/swan/apps/core/SwanAppWebViewManager;");
                return;
            }
        }
        v = c.a.n0.a.a.a;
        c.a.n0.a.a2.d.c();
        V8Engine.getInstance(0L);
    }

    public SwanAppWebViewManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = new Handler(Looper.getMainLooper());
        this.k = new d(this);
        this.l = new ArrayList();
        this.m = false;
        this.n = null;
        this.o = null;
        this.t = -1;
        this.u = new c.a.n0.a.t0.b.a();
        this.a = new MutableContextWrapper(context);
        c.a.n0.a.x.f.d.a.k().l();
        M0();
        V0();
    }

    public final void E0(String str, GeolocationPermissions.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, callback) == null) {
            if (v) {
                Log.d("SwanAppWebViewManager", "allowGeoLocationOnce origin: " + str);
            }
            callback.invoke(str, true, false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.s1.a.d.a
    /* renamed from: F0 */
    public NgWebView V(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            this.a.setBaseContext(context);
            if (this.f28827b == null) {
                Q0();
            }
            return this.f28827b;
        }
        return (NgWebView) invokeL.objValue;
    }

    public void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.n0.a.s0.a.E0().a(this.f28827b);
        }
    }

    public final void H0(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
            if (v) {
                Log.d("SwanAppWebViewManager", "handleSchemeDispatchCallback callback: " + str);
                Log.d("SwanAppWebViewManager", "handleSchemeDispatchCallback params: " + str2);
            }
            if (this.f28827b.isDestroyed()) {
                if (v) {
                    Log.e("SwanAppWebViewManager", "handleSchemeDispatchCallback webview is destroyed.");
                    return;
                }
                return;
            }
            this.f28827b.evaluateJavascript("javascript:" + str + "(" + str3 + SmallTailInfo.EMOTION_SUFFIX, null);
        }
    }

    @Nullable
    public synchronized c.a.n0.a.o0.j.b I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                if (this.q == null) {
                    if (!c.a.n0.a.t1.d.J().r().H()) {
                        return null;
                    }
                    SwanAppActivity x = c.a.n0.a.t1.d.J().x();
                    if (x == null) {
                        return null;
                    }
                    this.q = new c.a.n0.a.o0.j.b(x, c());
                }
                return this.q;
            }
        }
        return (c.a.n0.a.o0.j.b) invokeV.objValue;
    }

    @Override // c.a.n0.a.f.e.d
    public d J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.k : (d) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.f.e.d
    /* renamed from: J0 */
    public NgWebView u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f28827b : (NgWebView) invokeV.objValue;
    }

    public void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f28827b.goBack();
        }
    }

    public final void L0(String str, GeolocationPermissions.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, callback) == null) {
            c.a.n0.a.l1.e.e("android.permission.ACCESS_FINE_LOCATION", new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, c.a.n0.a.t1.d.J().x(), new c(this, str, callback));
        }
    }

    @DebugTrace
    public final void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            X0(this.k);
            Q0();
            T0(this);
            N0();
            S0();
            P0();
            R0();
            Y0();
            O0();
        }
    }

    public final void N0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.f28832g == null) {
            this.f28832g = new UnitedSchemeMainDispatcher();
        }
    }

    public abstract void O0();

    public void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.u.e(this.f28827b, this.a.getBaseContext(), this, this.f28832g);
        }
    }

    @Override // c.a.n0.a.f.e.d
    @UiThread
    public void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f28827b.onPause();
            this.f28827b.pauseTimers();
        }
    }

    public final void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (c.a.n0.a.s0.a.g0().w()) {
                this.f28827b = new NgWebView(this.a);
            } else {
                this.f28827b = new NgWebView(this.a.getBaseContext());
            }
            if (this.f28827b.getCurrentWebView() != null) {
                this.n = this.f28827b.getCurrentWebView().getBackground();
                View webViewImpl = this.f28827b.getWebViewImpl();
                if (webViewImpl != null) {
                    this.o = webViewImpl.getBackground();
                }
            }
            if (this.k.a) {
                this.f28827b.setBackgroundColorForSwanApp(0);
                if (!BdZeusUtil.isWebkitLoaded()) {
                    this.m = true;
                }
            }
            this.f28827b.setScrollBarStyle(0);
            this.f28831f = new c.a.n0.a.x.h.b(this.a.getBaseContext());
            if (v) {
                Log.d("SwanAppWebViewManager", "WebViewManager " + hashCode() + " initializing Clients");
            }
            this.f28827b.setWebViewClient(new SwanAppWebViewClient(this, null));
            this.f28827b.setWebViewClientExt(new SwanAppWebViewClientExt(this, null));
            this.f28827b.setWebChromeClient(new SwanAppWebChromeClient(this, null));
            this.f28827b.setWebChromeClientExt(new SwanAppWebChromeClientExt(this, null));
            this.f28827b.setOverScrollMode(2);
            this.f28827b.setOnCommonEventHandler(this);
            this.f28827b.setWebViewManager(this);
            this.f28827b.getCurrentWebView().setLongClickable(true);
            this.f28827b.setSelectPopWindowListener(this);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            BdSailorWebSettings settings = this.f28827b.getSettings();
            ISailorWebSettingsExt settingsExt = this.f28827b.getSettingsExt();
            settings.setWebViewFrameNameSailor(e0());
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
            String path = this.a.getDir(NgWebView.APP_DATABASE_PATH, 0).getPath();
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
            e1(this.s);
            try {
                settings.setPluginState(WebSettings.PluginState.ON_DEMAND);
            } catch (Exception e2) {
                e2.printStackTrace();
            } catch (NoClassDefFoundError e3) {
                e3.printStackTrace();
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.f28832g == null) {
                if (!v) {
                    N0();
                } else {
                    throw new IllegalStateException("initSwanAppDispatcher() must be called after initDispatcher()");
                }
            }
            this.f28833h = c.a.n0.a.v1.a.a(this.f28832g);
        }
    }

    public void T0(SwanAppWebViewManager swanAppWebViewManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, swanAppWebViewManager) == null) {
            this.u.f(this.a.getBaseContext(), this.f28827b);
        }
    }

    public void U0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            q0.e0(new a(this, str));
        }
    }

    @CallSuper
    public void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            c.a.n0.a.w0.i.a(this);
        }
    }

    @CallSuper
    public void W0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.s = null;
            c.a.n0.a.w0.i.b(this);
        }
    }

    @Override // c.a.n0.a.f.e.d
    public void X(c.a.n0.a.x.j.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, cVar) == null) && cVar != null && this.l.contains(cVar)) {
            this.l.remove(cVar);
        }
    }

    public void X0(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, dVar) == null) {
        }
    }

    public void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
        }
    }

    public final void Z0(String str, GeolocationPermissions.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, str, callback) == null) {
            if (v) {
                Log.d("SwanAppWebViewManager", "rejectGeoLocationOnce origin: " + str);
            }
            callback.invoke(str, false, false);
        }
    }

    @Override // c.a.n0.a.f.e.d
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.p : (String) invokeV.objValue;
    }

    public final void a1(BdSailorWebChromeClient bdSailorWebChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bdSailorWebChromeClient) == null) {
            this.f28830e = bdSailorWebChromeClient;
        }
    }

    public final void b1(BdSailorWebViewClient bdSailorWebViewClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bdSailorWebViewClient) == null) {
            this.f28828c = bdSailorWebViewClient;
        }
    }

    @Override // c.a.n0.a.f.e.d
    public abstract String c();

    public final void c1(BdSailorWebViewClientExt bdSailorWebViewClientExt) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, bdSailorWebViewClientExt) == null) {
            this.f28829d = bdSailorWebViewClientExt;
        }
    }

    @Override // c.a.n0.a.f.e.d
    public void d(c.a.n0.a.x.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bVar) == null) {
            this.j = bVar;
        }
    }

    public void d1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.t = i;
            if (v) {
                Log.d("SwanAppWebViewManager", "CustomView orientation has been set to [" + this.t + "] for once");
            }
        }
    }

    @Override // c.a.n0.a.f.e.d
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.i.removeCallbacks(null);
            this.f28827b.destroy();
            this.l.clear();
            W0();
        }
    }

    @Override // c.a.n0.a.x.f.b
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.swan.apps.core.container.view.SwanAppSelectPopView.a
    public void doSelectionCopy(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            G0();
            c.a.n0.a.s0.a.E0().e(str, this.a.getBaseContext());
        }
    }

    @Override // com.baidu.swan.apps.core.container.view.SwanAppSelectPopView.a
    public void doSelectionSearch(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            G0();
            c.a.n0.a.s0.a.E0().d(str, this.a.getBaseContext());
        }
    }

    @Override // c.a.n0.a.f.e.d
    public String e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? "ai_apps" : (String) invokeV.objValue;
    }

    public void e1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            this.s = str;
            BdSailorWebSettings settings = this.f28827b.getSettings();
            String str2 = this.r;
            if (!TextUtils.isEmpty(str)) {
                str2 = String.format("%s %s", str2, str);
            }
            String b2 = c.a.n0.a.m2.a.b(str2);
            if (TextUtils.equals(b2, this.p)) {
                return;
            }
            this.p = b2;
            settings.setUserAgentString(b2);
            if (v) {
                Log.i("SwanAppWebViewManager", "set ua:" + this.p);
            }
        }
    }

    @Override // c.a.n0.a.f.e.d
    public void f(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, activity) == null) {
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
    }

    public final void f1() {
        ISailorWebViewExt webViewExt;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || (webViewExt = this.f28827b.getWebViewExt()) == null) {
            return;
        }
        webViewExt.emulateShiftHeldOnNormalTextExt();
    }

    public final void g1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048617, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        String path = Uri.parse(str).getPath();
        if (v) {
            Log.d("SwanAppWebViewManager", "pathList item: " + str + " ,folder: " + path + " ,parent: " + new File(path).getParent());
        }
        if (TextUtils.isEmpty(path)) {
            return;
        }
        this.f28827b.getSettings().setCodeCacheSetting(c.a.n0.a.x.d.b.a("appframe", new File(path).getParent()));
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public String getCurrentPageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? u().getUrl() : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // c.a.n0.a.f.e.d
    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public void handleSchemeDispatchCallback(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048621, this, str, str2) == null) {
            c.a.n0.a.e0.b.b().c(new b(this, str, str2, TextUtils.isEmpty(str2) ? "" : JSONObject.quote(str2)), str);
        }
    }

    @Override // c.a.n0.a.f.e.d, c.a.n0.a.x.l.a
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            boolean z = this.f28827b.getCurrentWebView().getWebView() instanceof android.webkit.WebView ? !((android.webkit.WebView) this.f28827b.getCurrentWebView().getWebView()).getSettings().getAllowFileAccess() : false;
            if (v) {
                Log.d("SwanAppWebViewManager", "isUseWebCompatLoadUrl: " + z);
            }
            if (z && !BdZeusUtil.isWebkitLoaded()) {
                String a2 = c.a.n0.z.b.c.f9598b.a(str);
                g1(a2);
                this.f28827b.loadUrl(a2);
                return;
            }
            g1(str);
            this.f28827b.loadUrl(str);
        }
    }

    @Override // c.a.n0.a.f.e.d
    public void onJSLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
        }
    }

    @Override // c.a.n0.a.x.f.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048624, this, i, keyEvent)) == null) {
            if (i == 4 && this.f28827b.canGoBack()) {
                K0();
                return true;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // c.a.n0.a.f.e.d
    @CallSuper
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            this.f28827b.onPause();
            c.a.n0.a.w0.i.c(this);
        }
    }

    @Override // c.a.n0.a.f.e.d
    @CallSuper
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            this.f28827b.onResume();
            c.a.n0.a.w0.i.d(this);
        }
    }

    @Override // c.a.n0.a.x.f.b
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        List<c.a.n0.a.x.j.c> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048627, this, i, i2, i3, i4) == null) || (list = this.l) == null) {
            return;
        }
        for (c.a.n0.a.x.j.c cVar : list) {
            if (cVar != null) {
                cVar.onScrollChanged(i, i2, i3, i4);
            }
        }
    }

    @Override // c.a.n0.a.x.f.b
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.n0.a.x.f.c
    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.n0.a.f.e.d
    @UiThread
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            this.f28827b.onResume();
            this.f28827b.resumeTimers();
        }
    }

    @Override // c.a.n0.a.f.e.d
    public void v(c.a.n0.a.x.j.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048632, this, cVar) == null) || cVar == null || this.l.contains(cVar)) {
            return;
        }
        this.l.add(cVar);
    }

    @Override // c.a.n0.a.x.f.c
    public boolean w(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048633, this, z)) == null) ? z : invokeZ.booleanValue;
    }

    /* loaded from: classes4.dex */
    public class SwanAppWebChromeClientExt extends BdSailorWebChromeClientExt {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mIsFirstTimeShow;
        public final /* synthetic */ SwanAppWebViewManager this$0;

        /* loaded from: classes4.dex */
        public class a implements ValueCallback<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SwanAppWebChromeClientExt a;

            public a(SwanAppWebChromeClientExt swanAppWebChromeClientExt) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {swanAppWebChromeClientExt};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = swanAppWebChromeClientExt;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.webkit.ValueCallback
            /* renamed from: a */
            public void onReceiveValue(String str) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
                    return;
                }
                c.a.n0.a.u.d.b("SwanAppWebViewManager", "onReceiveValue: " + str);
                JsonReader jsonReader = new JsonReader(new StringReader(str));
                jsonReader.setLenient(true);
                try {
                    try {
                        if (jsonReader.peek() != JsonToken.NULL && jsonReader.peek() == JsonToken.STRING) {
                            String nextString = jsonReader.nextString();
                            if (!TextUtils.isEmpty(nextString)) {
                                c.a.n0.a.s0.a.E0().b(this.a.this$0.f28827b, nextString);
                            }
                        }
                    } catch (IOException e2) {
                        if (SwanAppWebViewManager.v) {
                            e2.printStackTrace();
                        }
                    }
                } finally {
                    c.a.n0.w.d.d(jsonReader);
                }
            }
        }

        public SwanAppWebChromeClientExt(SwanAppWebViewManager swanAppWebViewManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppWebViewManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = swanAppWebViewManager;
            this.mIsFirstTimeShow = true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClientExt
        public void hideSelectionActionDialogExt(BdSailorWebView bdSailorWebView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bdSailorWebView) == null) {
                super.hideSelectionActionDialogExt(bdSailorWebView);
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "hideSelectionActionDialogExt: ");
                }
                this.this$0.f28827b.hidePopWindow();
                this.mIsFirstTimeShow = true;
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClientExt
        @SuppressLint({"DefaultLocale"})
        public void performLongClickExt(BdSailorWebView bdSailorWebView, WebView.HitTestResult hitTestResult, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdSailorWebView, hitTestResult, i, i2) == null) {
                super.performLongClickExt(bdSailorWebView, hitTestResult, i, i2);
                if (hitTestResult == null) {
                    return;
                }
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "performLongClickExt: " + hitTestResult.getType() + ZeusCrashHandler.NAME_SEPERATOR + i + ZeusCrashHandler.NAME_SEPERATOR + i2);
                }
                int type = hitTestResult.getType();
                if (type == 10) {
                    this.this$0.f1();
                } else if (type == 5) {
                    this.this$0.f28827b.evaluateJavascript(String.format("javascript:(function(){return window.getImageSrcByCoordinate(%s,%s);})()", Integer.valueOf(n0.O(i)), Integer.valueOf(n0.O(i2))), new a(this));
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClientExt
        public void showSelectionActionDialogExt(BdSailorWebView bdSailorWebView, int i, int i2, int i3, int i4, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bdSailorWebView, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str}) == null) {
                super.showSelectionActionDialogExt(bdSailorWebView, i, i2, i3, i4, str);
                if (SwanAppWebViewManager.v) {
                    Log.d("SwanAppWebViewManager", "showSelectionActionDialogExt: " + i3 + ZeusCrashHandler.NAME_SEPERATOR + i4 + ZeusCrashHandler.NAME_SEPERATOR + i + ZeusCrashHandler.NAME_SEPERATOR + i2 + ZeusCrashHandler.NAME_SEPERATOR + str);
                }
                c.a.n0.a.s0.a.E0().c(this.this$0.f28827b, i, i2, i3, i4, str, this.mIsFirstTimeShow);
                this.mIsFirstTimeShow = false;
            }
        }

        public /* synthetic */ SwanAppWebChromeClientExt(SwanAppWebViewManager swanAppWebViewManager, a aVar) {
            this(swanAppWebViewManager);
        }
    }
}
