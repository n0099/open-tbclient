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
import c.a.r0.a.f2.e;
import c.a.r0.a.h0.h.b;
import c.a.r0.a.h2.c.i;
import c.a.r0.a.h2.c.j.b;
import c.a.r0.a.k;
import c.a.r0.a.v1.f;
import c.a.r0.a.z2.n0;
import c.a.r0.a.z2.q0;
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
import com.kuaishou.weapon.un.s;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public abstract class SwanAppWebViewManager implements c.a.r0.a.p.e.d<NgWebView>, c.a.r0.a.h0.f.b, c.a.r0.a.h0.f.c, c.a.r0.a.c2.a.d.a<NgWebView>, SwanAppSelectPopView.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public MutableContextWrapper f38735e;

    /* renamed from: f  reason: collision with root package name */
    public NgWebView f38736f;

    /* renamed from: g  reason: collision with root package name */
    public BdSailorWebViewClient f38737g;

    /* renamed from: h  reason: collision with root package name */
    public BdSailorWebViewClientExt f38738h;

    /* renamed from: i  reason: collision with root package name */
    public BdSailorWebChromeClient f38739i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.r0.a.h0.h.b f38740j;
    public UnitedSchemeMainDispatcher k;
    public e l;
    public Handler m;
    public c.a.r0.a.h0.b n;
    public final d o;
    public List<c.a.r0.a.h0.j.c> p;
    public boolean q;
    public Drawable r;
    public Drawable s;
    public String t;
    public c.a.r0.a.y0.j.b u;
    public String v;
    public String w;
    public int x;
    public c.a.r0.a.d1.b.a y;

    /* loaded from: classes11.dex */
    public class SwanAppWebChromeClient extends BdSailorWebChromeClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppWebViewManager this$0;

        /* loaded from: classes11.dex */
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = jsPromptResult;
            }

            @Override // c.a.r0.a.h0.h.b.s
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.cancel();
                }
            }

            @Override // c.a.r0.a.h0.h.b.s
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    this.a.confirm(str);
                }
            }

            @Override // c.a.r0.a.h0.h.b.s
            public void onCancel() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.a.cancel();
                }
            }
        }

        /* loaded from: classes11.dex */
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = jsResult;
            }

            @Override // c.a.r0.a.h0.h.b.s
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.cancel();
                }
            }

            @Override // c.a.r0.a.h0.h.b.s
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    this.a.confirm();
                }
            }

            @Override // c.a.r0.a.h0.h.b.s
            public void onCancel() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.a.cancel();
                }
            }
        }

        /* loaded from: classes11.dex */
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = jsResult;
            }

            @Override // c.a.r0.a.h0.h.b.s
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.cancel();
                }
            }

            @Override // c.a.r0.a.h0.h.b.s
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    this.a.confirm();
                }
            }

            @Override // c.a.r0.a.h0.h.b.s
            public void onCancel() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.a.cancel();
                }
            }
        }

        /* loaded from: classes11.dex */
        public class d implements c.a.r0.a.z2.g1.c<i<b.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f38741e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ GeolocationPermissions.Callback f38742f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SwanAppWebChromeClient f38743g;

            public d(SwanAppWebChromeClient swanAppWebChromeClient, String str, GeolocationPermissions.Callback callback) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {swanAppWebChromeClient, str, callback};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f38743g = swanAppWebChromeClient;
                this.f38741e = str;
                this.f38742f = callback;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.r0.a.z2.g1.c
            /* renamed from: a */
            public void onCallback(i<b.e> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    if (c.a.r0.a.h2.c.d.h(iVar)) {
                        this.f38743g.this$0.K0(this.f38741e, this.f38742f);
                    } else {
                        this.f38743g.this$0.Y0(this.f38741e, this.f38742f);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f38739i != null) {
                    this.this$0.f38739i.onCloseWindow(bdSailorWebView);
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
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f38739i == null || !this.this$0.f38739i.onConsoleMessage(bdSailorWebView, consoleMessage)) {
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
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f38739i == null || !this.this$0.f38739i.onCreateWindow(bdSailorWebView, z, z2, message)) {
                    return super.onCreateWindow(bdSailorWebView, z, z2, message);
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onExceededDatabaseQuota(BdSailorWebView bdSailorWebView, String str, String str2, long j2, long j3, long j4, WebStorage.QuotaUpdater quotaUpdater) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{bdSailorWebView, str, str2, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), quotaUpdater}) == null) {
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f38739i != null) {
                    this.this$0.f38739i.onExceededDatabaseQuota(bdSailorWebView, str, str2, j2, j3, j4, quotaUpdater);
                } else {
                    super.onExceededDatabaseQuota(bdSailorWebView, str, str2, j2, j3, j4, quotaUpdater);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onGeolocationPermissionsHidePrompt(BdSailorWebView bdSailorWebView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, bdSailorWebView) == null) {
                boolean unused = SwanAppWebViewManager.z;
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onGeolocationPermissionsShowPrompt(BdSailorWebView bdSailorWebView, String str, GeolocationPermissions.Callback callback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048581, this, bdSailorWebView, str, callback) == null) {
                boolean unused = SwanAppWebViewManager.z;
                c.a.r0.a.d2.e L = c.a.r0.a.d2.e.L();
                if (L == null || L.x() == null) {
                    this.this$0.Y0(str, callback);
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
                if (this.this$0.f38739i != null ? this.this$0.f38739i.onHideCustomView(bdSailorWebView) : false) {
                    boolean unused = SwanAppWebViewManager.z;
                    return true;
                }
                if (this.this$0.H0() != null) {
                    this.this$0.H0().d();
                }
                boolean unused2 = SwanAppWebViewManager.z;
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onJsAlert(BdSailorWebView bdSailorWebView, String str, String str2, JsResult jsResult) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, bdSailorWebView, str, str2, jsResult)) == null) {
                boolean unused = SwanAppWebViewManager.z;
                return this.this$0.f38740j.l(str, str2, new b(this, jsResult));
            }
            return invokeLLLL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onJsBeforeUnload(BdSailorWebView bdSailorWebView, String str, String str2, JsResult jsResult) {
            InterceptResult invokeLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdSailorWebView, str, str2, jsResult)) == null) {
                if (SwanAppWebViewManager.z) {
                    String str3 = "SwanAppWebChromeClient::onJsBeforeUnload：" + str;
                }
                if (this.this$0.f38739i == null || !this.this$0.f38739i.onJsBeforeUnload(bdSailorWebView, str, str2, jsResult)) {
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
                boolean unused = SwanAppWebViewManager.z;
                return this.this$0.f38740j.m(str, str2, new c(this, jsResult));
            }
            return invokeLLLL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onJsPrompt(BdSailorWebView bdSailorWebView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            InterceptResult invokeLLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048586, this, bdSailorWebView, str, str2, str3, jsPromptResult)) == null) {
                boolean unused = SwanAppWebViewManager.z;
                return this.this$0.f38740j.n(str, str2, str3, new a(this, jsPromptResult));
            }
            return invokeLLLLL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onJsTimeout(BdSailorWebView bdSailorWebView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bdSailorWebView)) == null) {
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f38739i == null || !this.this$0.f38739i.onJsTimeout(bdSailorWebView)) {
                    return super.onJsTimeout(bdSailorWebView);
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onProgressChanged(BdSailorWebView bdSailorWebView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048588, this, bdSailorWebView, i2) == null) {
                if (this.this$0.f38739i != null) {
                    this.this$0.f38739i.onProgressChanged(bdSailorWebView, i2);
                } else {
                    super.onProgressChanged(bdSailorWebView, i2);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReachedMaxAppCacheSize(BdSailorWebView bdSailorWebView, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{bdSailorWebView, Long.valueOf(j2), Long.valueOf(j3), quotaUpdater}) == null) {
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f38739i != null) {
                    this.this$0.f38739i.onReachedMaxAppCacheSize(bdSailorWebView, j2, j3, quotaUpdater);
                } else {
                    super.onReachedMaxAppCacheSize(bdSailorWebView, j2, j3, quotaUpdater);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedIcon(BdSailorWebView bdSailorWebView, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048590, this, bdSailorWebView, bitmap) == null) {
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f38739i != null) {
                    this.this$0.f38739i.onReceivedIcon(bdSailorWebView, bitmap);
                } else {
                    super.onReceivedIcon(bdSailorWebView, bitmap);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedTitle(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048591, this, bdSailorWebView, str) == null) {
                if (SwanAppWebViewManager.z) {
                    String str2 = "SwanAppWebChromeClient::onReceivedTitleInFact : " + str;
                }
                if (this.this$0.f38739i != null) {
                    this.this$0.f38739i.onReceivedTitle(bdSailorWebView, str);
                } else {
                    super.onReceivedTitle(bdSailorWebView, str);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedTouchIconUrl(BdSailorWebView bdSailorWebView, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048592, this, bdSailorWebView, str, z) == null) {
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f38739i != null) {
                    this.this$0.f38739i.onReceivedTouchIconUrl(bdSailorWebView, str, z);
                } else {
                    super.onReceivedTouchIconUrl(bdSailorWebView, str, z);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onRequestFocus(BdSailorWebView bdSailorWebView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, bdSailorWebView) == null) {
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f38739i != null) {
                    this.this$0.f38739i.onRequestFocus(bdSailorWebView);
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
                int i2 = 0;
                if (this.this$0.f38739i != null ? this.this$0.f38739i.onShowCustomView(bdSailorWebView, view, customViewCallback) : false) {
                    boolean unused = SwanAppWebViewManager.z;
                    return true;
                }
                if (this.this$0.x != -1) {
                    i2 = this.this$0.x;
                } else {
                    int i3 = c.a.r0.a.d2.d.J().f5525g;
                    if (i3 >= 35 && i3 < 180) {
                        i2 = 8;
                    }
                }
                onShowCustomView(bdSailorWebView, view, i2, customViewCallback);
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
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f38739i != null) {
                    this.this$0.f38739i.openFileChooser(bdSailorWebView, valueCallback);
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
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f38739i != null) {
                    this.this$0.f38739i.openFileChooser(bdSailorWebView, valueCallback, str);
                } else {
                    super.openFileChooser(bdSailorWebView, valueCallback, str);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onShowCustomView(BdSailorWebView bdSailorWebView, View view, int i2, WebChromeClient.CustomViewCallback customViewCallback) {
            InterceptResult invokeLLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048594, this, bdSailorWebView, view, i2, customViewCallback)) == null) {
                this.this$0.x = -1;
                if (SwanAppWebViewManager.z) {
                    String str = "CustomView orientation applied, set back to default [" + this.this$0.x + PreferencesUtil.RIGHT_MOUNT;
                }
                if (this.this$0.f38739i != null ? this.this$0.f38739i.onShowCustomView(bdSailorWebView, view, i2, customViewCallback) : false) {
                    boolean unused = SwanAppWebViewManager.z;
                    return true;
                }
                if (this.this$0.H0() != null) {
                    this.this$0.H0().g(view, i2, null);
                }
                if (SwanAppWebViewManager.z) {
                    String str2 = "SwanAppWebChromeClient::onShowCustomView : " + i2;
                }
                return true;
            }
            return invokeLLIL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void openFileChooser(BdSailorWebView bdSailorWebView, ValueCallback valueCallback, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048599, this, bdSailorWebView, valueCallback, str, str2) == null) {
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f38739i != null) {
                    this.this$0.f38739i.openFileChooser(bdSailorWebView, valueCallback, str, str2);
                } else {
                    super.openFileChooser(bdSailorWebView, valueCallback, str, str2);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class SwanAppWebViewClient extends BdSailorWebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppWebViewManager this$0;

        /* loaded from: classes11.dex */
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
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

        /* loaded from: classes11.dex */
        public class b implements b.t {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SslErrorHandler a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ BdSailorWebView f38744b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ SslError f38745c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ SwanAppWebViewClient f38746d;

            public b(SwanAppWebViewClient swanAppWebViewClient, SslErrorHandler sslErrorHandler, BdSailorWebView bdSailorWebView, SslError sslError) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {swanAppWebViewClient, sslErrorHandler, bdSailorWebView, sslError};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f38746d = swanAppWebViewClient;
                this.a = sslErrorHandler;
                this.f38744b = bdSailorWebView;
                this.f38745c = sslError;
            }

            @Override // c.a.r0.a.h0.h.b.t
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f38746d.onReceivedSslError(this.f38744b, this.a, this.f38745c);
                }
            }

            @Override // c.a.r0.a.h0.h.b.t
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a.proceed();
                }
            }

            @Override // c.a.r0.a.h0.h.b.t
            public void c() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.a.cancel();
                }
            }
        }

        /* loaded from: classes11.dex */
        public class c implements b.r {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BdSailorWebView a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f38747b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f38748c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ HttpAuthHandler f38749d;

            public c(SwanAppWebViewClient swanAppWebViewClient, BdSailorWebView bdSailorWebView, String str, String str2, HttpAuthHandler httpAuthHandler) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {swanAppWebViewClient, bdSailorWebView, str, str2, httpAuthHandler};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bdSailorWebView;
                this.f38747b = str;
                this.f38748c = str2;
                this.f38749d = httpAuthHandler;
            }

            @Override // c.a.r0.a.h0.h.b.r
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f38749d.cancel();
                }
            }

            @Override // c.a.r0.a.h0.h.b.r
            public void b(String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
                    BdSailorWebView bdSailorWebView = this.a;
                    if (bdSailorWebView != null) {
                        bdSailorWebView.setHttpAuthUsernamePassword(this.f38747b, this.f38748c, str, str2);
                    }
                    this.f38749d.proceed(str, str2);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f38737g != null) {
                    this.this$0.f38737g.doUpdateVisitedHistory(bdSailorWebView, str, z);
                } else {
                    super.doUpdateVisitedHistory(bdSailorWebView, str, z);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onFormResubmission(BdSailorWebView bdSailorWebView, Message message, Message message2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdSailorWebView, message, message2) == null) {
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f38737g != null) {
                    this.this$0.f38737g.onFormResubmission(bdSailorWebView, message, message2);
                } else {
                    super.onFormResubmission(bdSailorWebView, message, message2);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onLoadResource(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bdSailorWebView, str) == null) {
                if (SwanAppWebViewManager.z) {
                    String str2 = "SwanAppWebViewClient::onLoadResource：" + str;
                }
                if (this.this$0.f38737g != null) {
                    this.this$0.f38737g.onLoadResource(bdSailorWebView, str);
                } else {
                    super.onLoadResource(bdSailorWebView, str);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, bdSailorWebView, str) == null) {
                if (SwanAppWebViewManager.z) {
                    String str2 = "SwanAppWebViewClient::onPageFinished url: " + str;
                }
                if (this.this$0.q) {
                    WebView currentWebView = this.this$0.f38736f.getCurrentWebView();
                    if (currentWebView != null) {
                        currentWebView.setBackground(this.this$0.r);
                        this.this$0.q = false;
                    }
                    View webViewImpl = this.this$0.f38736f.getWebViewImpl();
                    if (webViewImpl != null) {
                        webViewImpl.setBackground(this.this$0.s);
                    }
                }
                if (this.this$0.n != null) {
                    this.this$0.n.a(str);
                }
                if (this.this$0.f38737g != null) {
                    this.this$0.f38737g.onPageFinished(bdSailorWebView, str);
                } else {
                    super.onPageFinished(bdSailorWebView, str);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageStarted(BdSailorWebView bdSailorWebView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048580, this, bdSailorWebView, str, bitmap) == null) {
                if (SwanAppWebViewManager.z) {
                    String str2 = "SwanAppWebViewClient::onPageStarted url: " + str;
                }
                if (this.this$0.f38737g != null) {
                    this.this$0.f38737g.onPageStarted(bdSailorWebView, str, bitmap);
                } else {
                    super.onPageStarted(bdSailorWebView, str, bitmap);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedClientCertRequest(BdSailorWebView bdSailorWebView, ClientCertRequest clientCertRequest) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, bdSailorWebView, clientCertRequest) == null) {
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f38737g != null) {
                    this.this$0.f38737g.onReceivedClientCertRequest(bdSailorWebView, clientCertRequest);
                } else {
                    super.onReceivedClientCertRequest(bdSailorWebView, clientCertRequest);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048582, this, bdSailorWebView, i2, str, str2) == null) {
                if (SwanAppWebViewManager.z) {
                    String str3 = "SwanAppWebViewClient::onReceivedError errorCode: " + i2 + " ,failingUrl: " + str2;
                }
                if (this.this$0.f38737g != null) {
                    this.this$0.f38737g.onReceivedError(bdSailorWebView, i2, str, str2);
                } else {
                    super.onReceivedError(bdSailorWebView, i2, str, str2);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedHttpAuthRequest(BdSailorWebView bdSailorWebView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            String str3;
            String[] httpAuthUsernamePassword;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048583, this, bdSailorWebView, httpAuthHandler, str, str2) == null) {
                boolean unused = SwanAppWebViewManager.z;
                String str4 = null;
                if (!httpAuthHandler.useHttpAuthUsernamePassword() || bdSailorWebView == null || (httpAuthUsernamePassword = bdSailorWebView.getHttpAuthUsernamePassword(str, str2)) == null || httpAuthUsernamePassword.length != 2) {
                    str3 = null;
                } else {
                    str4 = httpAuthUsernamePassword[0];
                    str3 = httpAuthUsernamePassword[1];
                }
                if (str4 != null && str3 != null) {
                    boolean unused2 = SwanAppWebViewManager.z;
                    httpAuthHandler.proceed(str4, str3);
                } else if (this.this$0.f38736f.isShown()) {
                    boolean unused3 = SwanAppWebViewManager.z;
                    this.this$0.f38740j.k(new c(this, bdSailorWebView, str, str2, httpAuthHandler), str, str2);
                } else {
                    httpAuthHandler.cancel();
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedHttpError(BdSailorWebView bdSailorWebView, WebResourceRequest webResourceRequest, com.baidu.webkit.sdk.WebResourceResponse webResourceResponse) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdSailorWebView, webResourceRequest, webResourceResponse) == null) {
                if (this.this$0.f38737g != null) {
                    this.this$0.f38737g.onReceivedHttpError(bdSailorWebView, webResourceRequest, webResourceResponse);
                } else {
                    super.onReceivedHttpError(bdSailorWebView, webResourceRequest, webResourceResponse);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedLoginRequest(BdSailorWebView bdSailorWebView, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048585, this, bdSailorWebView, str, str2, str3) == null) {
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f38737g != null) {
                    this.this$0.f38737g.onReceivedLoginRequest(bdSailorWebView, str, str2, str3);
                } else {
                    super.onReceivedLoginRequest(bdSailorWebView, str, str2, str3);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedSslError(BdSailorWebView bdSailorWebView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048586, this, bdSailorWebView, sslErrorHandler, sslError) == null) {
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f38736f.isShown()) {
                    this.this$0.f38740j.p(new b(this, sslErrorHandler, bdSailorWebView, sslError), sslErrorHandler, sslError);
                } else {
                    sslErrorHandler.cancel();
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onScaleChanged(BdSailorWebView bdSailorWebView, float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{bdSailorWebView, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f38737g != null) {
                    this.this$0.f38737g.onScaleChanged(bdSailorWebView, f2, f3);
                } else {
                    super.onScaleChanged(bdSailorWebView, f2, f3);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onUnhandledKeyEvent(BdSailorWebView bdSailorWebView, KeyEvent keyEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048588, this, bdSailorWebView, keyEvent) == null) {
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f38737g != null) {
                    this.this$0.f38737g.onUnhandledKeyEvent(bdSailorWebView, keyEvent);
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
                boolean unused = SwanAppWebViewManager.z;
                c.a.r0.z.b.c cVar = c.a.r0.z.b.c.f12027b;
                com.baidu.webkit.sdk.WebResourceResponse webResourceResponse = (com.baidu.webkit.sdk.WebResourceResponse) cVar.c(cVar.b(webResourceRequest.getUrl()), new a(this));
                if (webResourceResponse != null) {
                    return webResourceResponse;
                }
                if (this.this$0.f38737g != null) {
                    webResourceResponse = this.this$0.f38737g.shouldInterceptRequest(bdSailorWebView, webResourceRequest);
                }
                if (webResourceResponse == null) {
                    webResourceResponse = c.a.r0.a.h0.o.g.a.b().c(webResourceRequest, true);
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
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f38737g == null || !this.this$0.f38737g.shouldOverrideKeyEvent(bdSailorWebView, keyEvent)) {
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
                if (SwanAppWebViewManager.z) {
                    String str2 = "SwanAppWebViewClient::shouldOverrideUrlLoading url: " + str;
                }
                if (this.this$0.f38737g != null) {
                    return this.this$0.f38737g.shouldOverrideUrlLoading(bdSailorWebView, str);
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        public /* synthetic */ SwanAppWebViewClient(SwanAppWebViewManager swanAppWebViewManager, a aVar) {
            this(swanAppWebViewManager);
        }
    }

    /* loaded from: classes11.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                boolean unused = SwanAppWebViewManager.z;
                c.a.r0.a.u1.r.a.g().a(str);
                if (this.this$0.f38738h != null) {
                    this.this$0.f38738h.onFirstContentfulPaintExt(bdSailorWebView, str);
                } else {
                    super.onFirstContentfulPaintExt(bdSailorWebView, str);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdSailorWebView, str) == null) {
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f38738h != null) {
                    this.this$0.f38738h.onFirstImagePaintExt(bdSailorWebView, str);
                } else {
                    super.onFirstImagePaintExt(bdSailorWebView, str);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bdSailorWebView, str) == null) {
                if (this.this$0.f38738h != null) {
                    this.this$0.f38738h.onFirstLayoutDidExt(bdSailorWebView, str);
                } else {
                    super.onFirstLayoutDidExt(bdSailorWebView, str);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, bdSailorWebView, str) == null) {
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f38738h != null) {
                    this.this$0.f38738h.onFirstPaintDidExt(bdSailorWebView, str);
                } else {
                    super.onFirstPaintDidExt(bdSailorWebView, str);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, bdSailorWebView, str) == null) {
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f38738h != null) {
                    this.this$0.f38738h.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
                } else {
                    super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, bdSailorWebView, str) == null) {
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f38738h != null) {
                    this.this$0.f38738h.onFirstTextPaintExt(bdSailorWebView, str);
                } else {
                    super.onFirstTextPaintExt(bdSailorWebView, str);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFullScreenModeExt(BdSailorWebView bdSailorWebView, boolean z, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{bdSailorWebView, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f38738h != null) {
                    this.this$0.f38738h.onFullScreenModeExt(bdSailorWebView, z, i2, i3);
                } else {
                    super.onFullScreenModeExt(bdSailorWebView, z, i2, i3);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public String onGetErrorHtmlExt(BdSailorWebView bdSailorWebView, int i2, String str, String str2) {
            InterceptResult invokeLILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048583, this, bdSailorWebView, i2, str, str2)) == null) {
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f38738h != null) {
                    return this.this$0.f38738h.onGetErrorHtmlExt(bdSailorWebView, i2, str, str2);
                }
                return super.onGetErrorHtmlExt(bdSailorWebView, i2, str, str2);
            }
            return (String) invokeLILL.objValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onJsCodeCacheFinished(JsCodeCacheResult jsCodeCacheResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsCodeCacheResult) == null) {
                if (SwanAppWebViewManager.z) {
                    String str = "SwanAppWebViewClient::onJsCodeCachedFinished : " + jsCodeCacheResult;
                }
                if (this.this$0.f38738h != null) {
                    this.this$0.f38738h.onJsCodeCacheFinished(jsCodeCacheResult);
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
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f38738h != null) {
                    return this.this$0.f38738h.onKeywordExtensionExt(bdSailorWebView, str, str2);
                }
                return super.onKeywordExtensionExt(bdSailorWebView, str, str2);
            }
            return invokeLLL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageBackOrForwardExt(BdSailorWebView bdSailorWebView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048586, this, bdSailorWebView, i2) == null) {
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f38738h != null) {
                    this.this$0.f38738h.onPageBackOrForwardExt(bdSailorWebView, i2);
                } else {
                    super.onPageBackOrForwardExt(bdSailorWebView, i2);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageCanBeScaledExt(BdSailorWebView bdSailorWebView, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048587, this, bdSailorWebView, z) == null) {
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f38738h != null) {
                    this.this$0.f38738h.onPageCanBeScaledExt(bdSailorWebView, z);
                } else {
                    super.onPageCanBeScaledExt(bdSailorWebView, z);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPreloadUrlFoundExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048588, this, bdSailorWebView, str) == null) {
                if (SwanAppWebViewManager.z) {
                    String str2 = "SwanAppWebViewClient::onPreloadUrlFoundEx：" + str;
                }
                if (this.this$0.f38738h != null) {
                    this.this$0.f38738h.onPreloadUrlFoundExt(bdSailorWebView, str);
                } else {
                    super.onPreloadUrlFoundExt(bdSailorWebView, str);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onSecurityCheckResultExt(BdSailorWebView bdSailorWebView, String str, WebViewClient.SecurityInfo securityInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048589, this, bdSailorWebView, str, securityInfo) == null) {
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f38738h != null) {
                    this.this$0.f38738h.onSecurityCheckResultExt(bdSailorWebView, str, securityInfo);
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
                if (SwanAppWebViewManager.z) {
                    String str2 = "SwanAppWebViewClient::onSubFrameBeforeRequest url: " + str;
                }
                if (this.this$0.f38738h != null) {
                    return this.this$0.f38738h.onSubFrameBeforeRequest(bdSailorWebView, str);
                }
                return super.onSubFrameBeforeRequest(bdSailorWebView, str);
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onUrlRedirectedExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048591, this, bdSailorWebView, str, str2) == null) {
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f38738h != null) {
                    this.this$0.f38738h.onUrlRedirectedExt(bdSailorWebView, str, str2);
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
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f38738h == null || !this.this$0.f38738h.shouldHandleImageExt(bdSailorWebView, str, str2, str3, z)) {
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

    /* loaded from: classes11.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f38750e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppWebViewManager f38751f;

        public a(SwanAppWebViewManager swanAppWebViewManager, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppWebViewManager, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38751f = swanAppWebViewManager;
            this.f38750e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = this.f38750e;
                if (!str.startsWith("javascript:")) {
                    str = "javascript:" + str;
                }
                if (SwanAppWebViewManager.z) {
                    String str2 = "webview load js:" + str;
                }
                this.f38751f.f38736f.evaluateJavascript(str, null);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b extends c.a.r0.a.o0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f38752g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f38753h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f38754i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ SwanAppWebViewManager f38755j;

        public b(SwanAppWebViewManager swanAppWebViewManager, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppWebViewManager, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38755j = swanAppWebViewManager;
            this.f38752g = str;
            this.f38753h = str2;
            this.f38754i = str3;
        }

        @Override // c.a.r0.a.o0.c
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f38755j.G0(this.f38752g, this.f38753h, this.f38754i);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f38756e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ GeolocationPermissions.Callback f38757f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SwanAppWebViewManager f38758g;

        public c(SwanAppWebViewManager swanAppWebViewManager, String str, GeolocationPermissions.Callback callback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppWebViewManager, str, callback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38758g = swanAppWebViewManager;
            this.f38756e = str;
            this.f38757f = callback;
        }

        @Override // c.a.r0.a.v1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (SwanAppWebViewManager.z) {
                    String str2 = "#handleLocationAuthorized(success) msg=" + str;
                }
                this.f38758g.D0(this.f38756e, this.f38757f);
            }
        }

        @Override // c.a.r0.a.v1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                if (SwanAppWebViewManager.z) {
                    String str2 = "#handleLocationAuthorized(failed) msg=" + str;
                }
                this.f38758g.Y0(this.f38756e, this.f38757f);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f38759b;

        public d(SwanAppWebViewManager swanAppWebViewManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppWebViewManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = false;
            this.f38759b = false;
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
        z = k.a;
        c.a.r0.a.k2.d.c();
        V8Engine.getInstance(0L);
    }

    public SwanAppWebViewManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = new Handler(Looper.getMainLooper());
        this.o = new d(this);
        this.p = new ArrayList();
        this.q = false;
        this.r = null;
        this.s = null;
        this.x = -1;
        this.y = new c.a.r0.a.d1.b.a();
        this.f38735e = new MutableContextWrapper(context);
        c.a.r0.a.h0.f.d.a.k().l();
        L0();
        U0();
    }

    public final void D0(String str, GeolocationPermissions.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, callback) == null) {
            if (z) {
                String str2 = "allowGeoLocationOnce origin: " + str;
            }
            callback.invoke(str, true, false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.a.c2.a.d.a
    /* renamed from: E0 */
    public NgWebView U(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            this.f38735e.setBaseContext(context);
            if (this.f38736f == null) {
                P0();
            }
            return this.f38736f;
        }
        return (NgWebView) invokeL.objValue;
    }

    public void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.r0.a.c1.a.E0().a(this.f38736f);
        }
    }

    public final void G0(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
            if (z) {
                String str4 = "handleSchemeDispatchCallback callback: " + str;
                String str5 = "handleSchemeDispatchCallback params: " + str2;
            }
            if (this.f38736f.isDestroyed()) {
                boolean z2 = z;
                return;
            }
            this.f38736f.evaluateJavascript("javascript:" + str + "(" + str3 + SmallTailInfo.EMOTION_SUFFIX, null);
        }
    }

    @Nullable
    public synchronized c.a.r0.a.y0.j.b H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                if (this.u == null) {
                    if (!c.a.r0.a.d2.d.J().r().H()) {
                        return null;
                    }
                    SwanAppActivity x = c.a.r0.a.d2.d.J().x();
                    if (x == null) {
                        return null;
                    }
                    this.u = new c.a.r0.a.y0.j.b(x, c());
                }
                return this.u;
            }
        }
        return (c.a.r0.a.y0.j.b) invokeV.objValue;
    }

    @Override // c.a.r0.a.p.e.d
    public d I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.o : (d) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.a.p.e.d
    /* renamed from: I0 */
    public NgWebView t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f38736f : (NgWebView) invokeV.objValue;
    }

    public void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f38736f.goBack();
        }
    }

    public final void K0(String str, GeolocationPermissions.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, callback) == null) {
            c.a.r0.a.v1.e.e(s.f55246g, new String[]{s.f55246g, s.f55247h}, 0, c.a.r0.a.d2.d.J().x(), new c(this, str, callback));
        }
    }

    @DebugTrace
    public final void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            W0(this.o);
            P0();
            S0(this);
            M0();
            R0();
            O0();
            Q0();
            X0();
            N0();
        }
    }

    public final void M0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.k == null) {
            this.k = new UnitedSchemeMainDispatcher();
        }
    }

    public abstract void N0();

    public void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.y.e(this.f38736f, this.f38735e.getBaseContext(), this, this.k);
        }
    }

    @Override // c.a.r0.a.p.e.d
    @UiThread
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f38736f.onPause();
            this.f38736f.pauseTimers();
        }
    }

    public final void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (c.a.r0.a.c1.a.g0().w()) {
                this.f38736f = new NgWebView(this.f38735e);
            } else {
                this.f38736f = new NgWebView(this.f38735e.getBaseContext());
            }
            if (this.f38736f.getCurrentWebView() != null) {
                this.r = this.f38736f.getCurrentWebView().getBackground();
                View webViewImpl = this.f38736f.getWebViewImpl();
                if (webViewImpl != null) {
                    this.s = webViewImpl.getBackground();
                }
            }
            if (this.o.a) {
                this.f38736f.setBackgroundColorForSwanApp(0);
                if (!BdZeusUtil.isWebkitLoaded()) {
                    this.q = true;
                }
            }
            this.f38736f.setScrollBarStyle(0);
            this.f38740j = new c.a.r0.a.h0.h.b(this.f38735e.getBaseContext());
            if (z) {
                String str = "WebViewManager " + hashCode() + " initializing Clients";
            }
            this.f38736f.setWebViewClient(new SwanAppWebViewClient(this, null));
            this.f38736f.setWebViewClientExt(new SwanAppWebViewClientExt(this, null));
            this.f38736f.setWebChromeClient(new SwanAppWebChromeClient(this, null));
            this.f38736f.setWebChromeClientExt(new SwanAppWebChromeClientExt(this, null));
            this.f38736f.setOverScrollMode(2);
            this.f38736f.setOnCommonEventHandler(this);
            this.f38736f.setWebViewManager(this);
            this.f38736f.getCurrentWebView().setLongClickable(true);
            this.f38736f.setSelectPopWindowListener(this);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            BdSailorWebSettings settings = this.f38736f.getSettings();
            ISailorWebSettingsExt settingsExt = this.f38736f.getSettingsExt();
            settings.setWebViewFrameNameSailor(d0());
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
            String path = this.f38735e.getDir("databases", 0).getPath();
            String path2 = this.f38735e.getDir("geolocation", 0).getPath();
            String path3 = this.f38735e.getDir("appcache", 0).getPath();
            settings.setGeolocationDatabasePath(path2);
            settings.setDatabasePath(path);
            settings.setAppCachePath(path3);
            if (((ActivityManager) this.f38735e.getSystemService("activity")).getMemoryClass() > 16) {
                settings.setPageCacheCapacity(5);
            } else {
                settings.setPageCacheCapacity(1);
            }
            this.v = settings.getUserAgentString();
            d1(this.w);
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
    public void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.k == null) {
                if (!z) {
                    M0();
                } else {
                    throw new IllegalStateException("initSwanAppDispatcher() must be called after initDispatcher()");
                }
            }
            this.l = c.a.r0.a.f2.a.a(this.k);
        }
    }

    public void S0(SwanAppWebViewManager swanAppWebViewManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, swanAppWebViewManager) == null) {
            this.y.f(this.f38735e.getBaseContext(), this.f38736f);
        }
    }

    public void T0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            q0.e0(new a(this, str));
        }
    }

    @CallSuper
    public void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            c.a.r0.a.g1.i.a(this);
        }
    }

    @CallSuper
    public void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.w = null;
            c.a.r0.a.g1.i.b(this);
        }
    }

    @Override // c.a.r0.a.p.e.d
    public void W(c.a.r0.a.h0.j.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, cVar) == null) && cVar != null && this.p.contains(cVar)) {
            this.p.remove(cVar);
        }
    }

    public void W0(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, dVar) == null) {
        }
    }

    public void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
        }
    }

    public final void Y0(String str, GeolocationPermissions.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, str, callback) == null) {
            if (z) {
                String str2 = "rejectGeoLocationOnce origin: " + str;
            }
            callback.invoke(str, false, false);
        }
    }

    public final void Z0(BdSailorWebChromeClient bdSailorWebChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bdSailorWebChromeClient) == null) {
            this.f38739i = bdSailorWebChromeClient;
        }
    }

    @Override // c.a.r0.a.p.e.d
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.t : (String) invokeV.objValue;
    }

    public final void a1(BdSailorWebViewClient bdSailorWebViewClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bdSailorWebViewClient) == null) {
            this.f38737g = bdSailorWebViewClient;
        }
    }

    public final void b1(BdSailorWebViewClientExt bdSailorWebViewClientExt) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bdSailorWebViewClientExt) == null) {
            this.f38738h = bdSailorWebViewClientExt;
        }
    }

    @Override // c.a.r0.a.p.e.d
    public abstract String c();

    public void c1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.x = i2;
            if (z) {
                String str = "CustomView orientation has been set to [" + this.x + "] for once";
            }
        }
    }

    @Override // c.a.r0.a.p.e.d
    public void d(c.a.r0.a.h0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, bVar) == null) {
            this.n = bVar;
        }
    }

    @Override // c.a.r0.a.p.e.d
    public String d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? "ai_apps" : (String) invokeV.objValue;
    }

    public void d1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            this.w = str;
            BdSailorWebSettings settings = this.f38736f.getSettings();
            String str2 = this.v;
            if (!TextUtils.isEmpty(str)) {
                str2 = String.format("%s %s", str2, str);
            }
            String b2 = c.a.r0.a.w2.a.b(str2);
            if (TextUtils.equals(b2, this.t)) {
                return;
            }
            this.t = b2;
            settings.setUserAgentString(b2);
            if (z) {
                String str3 = "set ua:" + this.t;
            }
        }
    }

    @Override // c.a.r0.a.p.e.d
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.m.removeCallbacks(null);
            this.f38736f.destroy();
            this.p.clear();
            V0();
        }
    }

    @Override // c.a.r0.a.h0.f.b
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.swan.apps.core.container.view.SwanAppSelectPopView.a
    public void doSelectionCopy(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            F0();
            c.a.r0.a.c1.a.E0().e(str, this.f38735e.getBaseContext());
        }
    }

    @Override // com.baidu.swan.apps.core.container.view.SwanAppSelectPopView.a
    public void doSelectionSearch(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            F0();
            c.a.r0.a.c1.a.E0().d(str, this.f38735e.getBaseContext());
        }
    }

    public final void e1() {
        ISailorWebViewExt webViewExt;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || (webViewExt = this.f38736f.getWebViewExt()) == null) {
            return;
        }
        webViewExt.emulateShiftHeldOnNormalTextExt();
    }

    @Override // c.a.r0.a.p.e.d
    public void f(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, activity) == null) {
            boolean z2 = z;
            if (activity == null) {
                boolean z3 = z;
                return;
            }
            this.y.a(activity);
            this.f38735e.setBaseContext(activity);
        }
    }

    public final void f1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048617, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        String path = Uri.parse(str).getPath();
        if (z) {
            String str2 = "pathList item: " + str + " ,folder: " + path + " ,parent: " + new File(path).getParent();
        }
        if (TextUtils.isEmpty(path)) {
            return;
        }
        this.f38736f.getSettings().setCodeCacheSetting(c.a.r0.a.h0.d.b.a("appframe", new File(path).getParent()));
    }

    @Override // c.a.r0.a.p.e.d
    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
        }
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public String getCurrentPageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? t().getUrl() : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public void handleSchemeDispatchCallback(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048621, this, str, str2) == null) {
            c.a.r0.a.o0.b.b().c(new b(this, str, str2, TextUtils.isEmpty(str2) ? "" : JSONObject.quote(str2)), str);
        }
    }

    @Override // c.a.r0.a.p.e.d, c.a.r0.a.h0.l.a
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            boolean z2 = this.f38736f.getCurrentWebView().getWebView() instanceof android.webkit.WebView ? !((android.webkit.WebView) this.f38736f.getCurrentWebView().getWebView()).getSettings().getAllowFileAccess() : false;
            if (z) {
                String str2 = "isUseWebCompatLoadUrl: " + z2;
            }
            if (z2 && !BdZeusUtil.isWebkitLoaded()) {
                String a2 = c.a.r0.z.b.c.f12027b.a(str);
                f1(a2);
                this.f38736f.loadUrl(a2);
                return;
            }
            f1(str);
            this.f38736f.loadUrl(str);
        }
    }

    @Override // c.a.r0.a.p.e.d
    public void onJSLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
        }
    }

    @Override // c.a.r0.a.h0.f.b
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048624, this, i2, keyEvent)) == null) {
            if (i2 == 4 && this.f38736f.canGoBack()) {
                J0();
                return true;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // c.a.r0.a.p.e.d
    @CallSuper
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            this.f38736f.onPause();
            c.a.r0.a.g1.i.c(this);
        }
    }

    @Override // c.a.r0.a.p.e.d
    @CallSuper
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            this.f38736f.onResume();
            c.a.r0.a.g1.i.d(this);
        }
    }

    @Override // c.a.r0.a.h0.f.b
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        List<c.a.r0.a.h0.j.c> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048627, this, i2, i3, i4, i5) == null) || (list = this.p) == null) {
            return;
        }
        for (c.a.r0.a.h0.j.c cVar : list) {
            if (cVar != null) {
                cVar.onScrollChanged(i2, i3, i4, i5);
            }
        }
    }

    @Override // c.a.r0.a.h0.f.b
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.r0.a.h0.f.c
    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // c.a.r0.a.p.e.d
    @UiThread
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            this.f38736f.onResume();
            this.f38736f.resumeTimers();
        }
    }

    @Override // c.a.r0.a.p.e.d
    public void u(c.a.r0.a.h0.j.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048632, this, cVar) == null) || cVar == null || this.p.contains(cVar)) {
            return;
        }
        this.p.add(cVar);
    }

    @Override // c.a.r0.a.h0.f.c
    public boolean v(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048633, this, z2)) == null) ? z2 : invokeZ.booleanValue;
    }

    /* loaded from: classes11.dex */
    public class SwanAppWebChromeClientExt extends BdSailorWebChromeClientExt {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mIsFirstTimeShow;
        public final /* synthetic */ SwanAppWebViewManager this$0;

        /* loaded from: classes11.dex */
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
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
                c.a.r0.a.e0.d.b("SwanAppWebViewManager", "onReceiveValue: " + str);
                JsonReader jsonReader = new JsonReader(new StringReader(str));
                jsonReader.setLenient(true);
                try {
                    try {
                        if (jsonReader.peek() != JsonToken.NULL && jsonReader.peek() == JsonToken.STRING) {
                            String nextString = jsonReader.nextString();
                            if (!TextUtils.isEmpty(nextString)) {
                                c.a.r0.a.c1.a.E0().b(this.a.this$0.f38736f, nextString);
                            }
                        }
                    } catch (IOException e2) {
                        if (SwanAppWebViewManager.z) {
                            e2.printStackTrace();
                        }
                    }
                } finally {
                    c.a.r0.w.d.d(jsonReader);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                boolean unused = SwanAppWebViewManager.z;
                this.this$0.f38736f.hidePopWindow();
                this.mIsFirstTimeShow = true;
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClientExt
        @SuppressLint({"DefaultLocale"})
        public void performLongClickExt(BdSailorWebView bdSailorWebView, WebView.HitTestResult hitTestResult, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdSailorWebView, hitTestResult, i2, i3) == null) {
                super.performLongClickExt(bdSailorWebView, hitTestResult, i2, i3);
                if (hitTestResult == null) {
                    return;
                }
                if (SwanAppWebViewManager.z) {
                    String str = "performLongClickExt: " + hitTestResult.getType() + ZeusCrashHandler.NAME_SEPERATOR + i2 + ZeusCrashHandler.NAME_SEPERATOR + i3;
                }
                int type = hitTestResult.getType();
                if (type == 10) {
                    this.this$0.e1();
                } else if (type == 5) {
                    this.this$0.f38736f.evaluateJavascript(String.format("javascript:(function(){return window.getImageSrcByCoordinate(%s,%s);})()", Integer.valueOf(n0.P(i2)), Integer.valueOf(n0.P(i3))), new a(this));
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClientExt
        public void showSelectionActionDialogExt(BdSailorWebView bdSailorWebView, int i2, int i3, int i4, int i5, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bdSailorWebView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str}) == null) {
                super.showSelectionActionDialogExt(bdSailorWebView, i2, i3, i4, i5, str);
                if (SwanAppWebViewManager.z) {
                    String str2 = "showSelectionActionDialogExt: " + i4 + ZeusCrashHandler.NAME_SEPERATOR + i5 + ZeusCrashHandler.NAME_SEPERATOR + i2 + ZeusCrashHandler.NAME_SEPERATOR + i3 + ZeusCrashHandler.NAME_SEPERATOR + str;
                }
                c.a.r0.a.c1.a.E0().c(this.this$0.f38736f, i2, i3, i4, i5, str, this.mIsFirstTimeShow);
                this.mIsFirstTimeShow = false;
            }
        }

        public /* synthetic */ SwanAppWebChromeClientExt(SwanAppWebViewManager swanAppWebViewManager, a aVar) {
            this(swanAppWebViewManager);
        }
    }
}
