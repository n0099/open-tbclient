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
import android.widget.AbsoluteLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.e2.c.i;
import b.a.p0.a.e2.c.j.b;
import b.a.p0.a.h0.h.b;
import b.a.p0.a.k;
import b.a.p0.a.s1.f;
import b.a.p0.a.v2.n0;
import b.a.p0.a.v2.q0;
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
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class SwanAppWebViewManager implements b.a.p0.a.p.e.d<NgWebView>, b.a.p0.a.h0.f.b, b.a.p0.a.h0.f.c, b.a.p0.a.z1.a.d.a<NgWebView>, SwanAppSelectPopView.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public MutableContextWrapper f43606e;

    /* renamed from: f  reason: collision with root package name */
    public NgWebView f43607f;

    /* renamed from: g  reason: collision with root package name */
    public BdSailorWebViewClient f43608g;

    /* renamed from: h  reason: collision with root package name */
    public BdSailorWebViewClientExt f43609h;

    /* renamed from: i  reason: collision with root package name */
    public BdSailorWebChromeClient f43610i;
    public b.a.p0.a.h0.h.b j;
    public UnitedSchemeMainDispatcher k;
    public b.a.p0.a.c2.e l;
    public Handler m;
    public b.a.p0.a.h0.b n;
    public final e o;
    public List<b.a.p0.a.h0.j.c> p;
    public boolean q;
    public Drawable r;
    public Drawable s;
    public String t;
    public b.a.p0.a.y0.j.b u;
    public String v;
    public String w;
    public int x;
    public b.a.p0.a.d1.b.a y;

    /* loaded from: classes8.dex */
    public class SwanAppWebChromeClient extends BdSailorWebChromeClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppWebViewManager this$0;

        /* loaded from: classes8.dex */
        public class a implements b.s {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ JsPromptResult f43611a;

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
                this.f43611a = jsPromptResult;
            }

            @Override // b.a.p0.a.h0.h.b.s
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f43611a.cancel();
                }
            }

            @Override // b.a.p0.a.h0.h.b.s
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    this.f43611a.confirm(str);
                }
            }

            @Override // b.a.p0.a.h0.h.b.s
            public void onCancel() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f43611a.cancel();
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements b.s {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ JsResult f43612a;

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
                this.f43612a = jsResult;
            }

            @Override // b.a.p0.a.h0.h.b.s
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f43612a.cancel();
                }
            }

            @Override // b.a.p0.a.h0.h.b.s
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    this.f43612a.confirm();
                }
            }

            @Override // b.a.p0.a.h0.h.b.s
            public void onCancel() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f43612a.cancel();
                }
            }
        }

        /* loaded from: classes8.dex */
        public class c implements b.s {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ JsResult f43613a;

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
                this.f43613a = jsResult;
            }

            @Override // b.a.p0.a.h0.h.b.s
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f43613a.cancel();
                }
            }

            @Override // b.a.p0.a.h0.h.b.s
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    this.f43613a.confirm();
                }
            }

            @Override // b.a.p0.a.h0.h.b.s
            public void onCancel() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f43613a.cancel();
                }
            }
        }

        /* loaded from: classes8.dex */
        public class d implements b.a.p0.a.v2.e1.b<i<b.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43614e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ GeolocationPermissions.Callback f43615f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SwanAppWebChromeClient f43616g;

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
                this.f43616g = swanAppWebChromeClient;
                this.f43614e = str;
                this.f43615f = callback;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.p0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i<b.e> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    if (b.a.p0.a.e2.c.d.h(iVar)) {
                        this.f43616g.this$0.G0(this.f43614e, this.f43615f);
                    } else {
                        this.f43616g.this$0.U0(this.f43614e, this.f43615f);
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
                if (this.this$0.f43610i != null) {
                    this.this$0.f43610i.onCloseWindow(bdSailorWebView);
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
                if (this.this$0.f43610i == null || !this.this$0.f43610i.onConsoleMessage(bdSailorWebView, consoleMessage)) {
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
                if (this.this$0.f43610i == null || !this.this$0.f43610i.onCreateWindow(bdSailorWebView, z, z2, message)) {
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
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f43610i != null) {
                    this.this$0.f43610i.onExceededDatabaseQuota(bdSailorWebView, str, str2, j, j2, j3, quotaUpdater);
                } else {
                    super.onExceededDatabaseQuota(bdSailorWebView, str, str2, j, j2, j3, quotaUpdater);
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
                b.a.p0.a.a2.e i2 = b.a.p0.a.a2.e.i();
                if (i2 == null || i2.x() == null) {
                    this.this$0.U0(str, callback);
                } else {
                    i2.S().g(i2.x(), "mapp_location", new d(this, str, callback));
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onHideCustomView(BdSailorWebView bdSailorWebView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bdSailorWebView)) == null) {
                if (this.this$0.f43610i != null ? this.this$0.f43610i.onHideCustomView(bdSailorWebView) : false) {
                    boolean unused = SwanAppWebViewManager.z;
                    return true;
                }
                if (this.this$0.D0() != null) {
                    this.this$0.D0().d();
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
                return this.this$0.j.l(str, str2, new b(this, jsResult));
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
                if (this.this$0.f43610i == null || !this.this$0.f43610i.onJsBeforeUnload(bdSailorWebView, str, str2, jsResult)) {
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
                return this.this$0.j.m(str, str2, new c(this, jsResult));
            }
            return invokeLLLL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onJsPrompt(BdSailorWebView bdSailorWebView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            InterceptResult invokeLLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048586, this, bdSailorWebView, str, str2, str3, jsPromptResult)) == null) {
                boolean unused = SwanAppWebViewManager.z;
                return this.this$0.j.n(str, str2, str3, new a(this, jsPromptResult));
            }
            return invokeLLLLL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onJsTimeout(BdSailorWebView bdSailorWebView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bdSailorWebView)) == null) {
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f43610i == null || !this.this$0.f43610i.onJsTimeout(bdSailorWebView)) {
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
                if (this.this$0.f43610i != null) {
                    this.this$0.f43610i.onProgressChanged(bdSailorWebView, i2);
                } else {
                    super.onProgressChanged(bdSailorWebView, i2);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReachedMaxAppCacheSize(BdSailorWebView bdSailorWebView, long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{bdSailorWebView, Long.valueOf(j), Long.valueOf(j2), quotaUpdater}) == null) {
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f43610i != null) {
                    this.this$0.f43610i.onReachedMaxAppCacheSize(bdSailorWebView, j, j2, quotaUpdater);
                } else {
                    super.onReachedMaxAppCacheSize(bdSailorWebView, j, j2, quotaUpdater);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedIcon(BdSailorWebView bdSailorWebView, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048590, this, bdSailorWebView, bitmap) == null) {
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f43610i != null) {
                    this.this$0.f43610i.onReceivedIcon(bdSailorWebView, bitmap);
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
                if (this.this$0.f43610i != null) {
                    this.this$0.f43610i.onReceivedTitle(bdSailorWebView, str);
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
                if (this.this$0.f43610i != null) {
                    this.this$0.f43610i.onReceivedTouchIconUrl(bdSailorWebView, str, z);
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
                if (this.this$0.f43610i != null) {
                    this.this$0.f43610i.onRequestFocus(bdSailorWebView);
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
                if (this.this$0.f43610i != null ? this.this$0.f43610i.onShowCustomView(bdSailorWebView, view, customViewCallback) : false) {
                    boolean unused = SwanAppWebViewManager.z;
                    return true;
                }
                if (this.this$0.x != -1) {
                    i2 = this.this$0.x;
                } else {
                    int i3 = b.a.p0.a.a2.d.g().f3950g;
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
                if (this.this$0.f43610i != null) {
                    this.this$0.f43610i.openFileChooser(bdSailorWebView, valueCallback);
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
                if (this.this$0.f43610i != null) {
                    this.this$0.f43610i.openFileChooser(bdSailorWebView, valueCallback, str);
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
                if (this.this$0.f43610i != null ? this.this$0.f43610i.onShowCustomView(bdSailorWebView, view, i2, customViewCallback) : false) {
                    boolean unused = SwanAppWebViewManager.z;
                    return true;
                }
                if (this.this$0.D0() != null) {
                    this.this$0.D0().g(view, i2, null);
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
                if (this.this$0.f43610i != null) {
                    this.this$0.f43610i.openFileChooser(bdSailorWebView, valueCallback, str, str2);
                } else {
                    super.openFileChooser(bdSailorWebView, valueCallback, str, str2);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class SwanAppWebViewClient extends BdSailorWebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppWebViewManager this$0;

        /* loaded from: classes8.dex */
        public class a implements b.t {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ SslErrorHandler f43618a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ BdSailorWebView f43619b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ SslError f43620c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ SwanAppWebViewClient f43621d;

            public a(SwanAppWebViewClient swanAppWebViewClient, SslErrorHandler sslErrorHandler, BdSailorWebView bdSailorWebView, SslError sslError) {
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
                this.f43621d = swanAppWebViewClient;
                this.f43618a = sslErrorHandler;
                this.f43619b = bdSailorWebView;
                this.f43620c = sslError;
            }

            @Override // b.a.p0.a.h0.h.b.t
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f43621d.onReceivedSslError(this.f43619b, this.f43618a, this.f43620c);
                }
            }

            @Override // b.a.p0.a.h0.h.b.t
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f43618a.proceed();
                }
            }

            @Override // b.a.p0.a.h0.h.b.t
            public void c() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f43618a.cancel();
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements b.r {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ BdSailorWebView f43622a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f43623b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f43624c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ HttpAuthHandler f43625d;

            public b(SwanAppWebViewClient swanAppWebViewClient, BdSailorWebView bdSailorWebView, String str, String str2, HttpAuthHandler httpAuthHandler) {
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
                this.f43622a = bdSailorWebView;
                this.f43623b = str;
                this.f43624c = str2;
                this.f43625d = httpAuthHandler;
            }

            @Override // b.a.p0.a.h0.h.b.r
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f43625d.cancel();
                }
            }

            @Override // b.a.p0.a.h0.h.b.r
            public void b(String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
                    BdSailorWebView bdSailorWebView = this.f43622a;
                    if (bdSailorWebView != null) {
                        bdSailorWebView.setHttpAuthUsernamePassword(this.f43623b, this.f43624c, str, str2);
                    }
                    this.f43625d.proceed(str, str2);
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
                if (this.this$0.f43608g != null) {
                    this.this$0.f43608g.doUpdateVisitedHistory(bdSailorWebView, str, z);
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
                if (this.this$0.f43608g != null) {
                    this.this$0.f43608g.onFormResubmission(bdSailorWebView, message, message2);
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
                if (this.this$0.f43608g != null) {
                    this.this$0.f43608g.onLoadResource(bdSailorWebView, str);
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
                    WebView currentWebView = this.this$0.f43607f.getCurrentWebView();
                    if (currentWebView != null) {
                        currentWebView.setBackground(this.this$0.r);
                        this.this$0.q = false;
                    }
                    AbsoluteLayout webViewImpl = this.this$0.f43607f.getWebViewImpl();
                    if (webViewImpl != null) {
                        webViewImpl.setBackground(this.this$0.s);
                    }
                }
                if (this.this$0.n != null) {
                    this.this$0.n.a(str);
                }
                if (this.this$0.f43608g != null) {
                    this.this$0.f43608g.onPageFinished(bdSailorWebView, str);
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
                if (this.this$0.f43608g != null) {
                    this.this$0.f43608g.onPageStarted(bdSailorWebView, str, bitmap);
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
                if (this.this$0.f43608g != null) {
                    this.this$0.f43608g.onReceivedClientCertRequest(bdSailorWebView, clientCertRequest);
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
                if (this.this$0.f43608g != null) {
                    this.this$0.f43608g.onReceivedError(bdSailorWebView, i2, str, str2);
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
                } else if (this.this$0.f43607f.isShown()) {
                    boolean unused3 = SwanAppWebViewManager.z;
                    this.this$0.j.k(new b(this, bdSailorWebView, str, str2, httpAuthHandler), str, str2);
                } else {
                    httpAuthHandler.cancel();
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedHttpError(BdSailorWebView bdSailorWebView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdSailorWebView, webResourceRequest, webResourceResponse) == null) {
                if (this.this$0.f43608g != null) {
                    this.this$0.f43608g.onReceivedHttpError(bdSailorWebView, webResourceRequest, webResourceResponse);
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
                if (this.this$0.f43608g != null) {
                    this.this$0.f43608g.onReceivedLoginRequest(bdSailorWebView, str, str2, str3);
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
                if (this.this$0.f43607f.isShown()) {
                    this.this$0.j.p(new a(this, sslErrorHandler, bdSailorWebView, sslError), sslErrorHandler, sslError);
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
                if (this.this$0.f43608g != null) {
                    this.this$0.f43608g.onScaleChanged(bdSailorWebView, f2, f3);
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
                if (this.this$0.f43608g != null) {
                    this.this$0.f43608g.onUnhandledKeyEvent(bdSailorWebView, keyEvent);
                } else {
                    super.onUnhandledKeyEvent(bdSailorWebView, keyEvent);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public WebResourceResponse shouldInterceptRequest(BdSailorWebView bdSailorWebView, WebResourceRequest webResourceRequest) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, bdSailorWebView, webResourceRequest)) == null) {
                if (webResourceRequest == null) {
                    return super.shouldInterceptRequest(bdSailorWebView, webResourceRequest);
                }
                boolean unused = SwanAppWebViewManager.z;
                WebResourceResponse shouldInterceptRequest = this.this$0.f43608g != null ? this.this$0.f43608g.shouldInterceptRequest(bdSailorWebView, webResourceRequest) : null;
                if (shouldInterceptRequest == null) {
                    shouldInterceptRequest = b.a.p0.a.h0.o.h.a.b().c(webResourceRequest, true);
                }
                return shouldInterceptRequest == null ? super.shouldInterceptRequest(bdSailorWebView, webResourceRequest) : shouldInterceptRequest;
            }
            return (WebResourceResponse) invokeLL.objValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideKeyEvent(BdSailorWebView bdSailorWebView, KeyEvent keyEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, bdSailorWebView, keyEvent)) == null) {
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f43608g == null || !this.this$0.f43608g.shouldOverrideKeyEvent(bdSailorWebView, keyEvent)) {
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
                if (this.this$0.f43608g != null) {
                    return this.this$0.f43608g.shouldOverrideUrlLoading(bdSailorWebView, str);
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        public /* synthetic */ SwanAppWebViewClient(SwanAppWebViewManager swanAppWebViewManager, a aVar) {
            this(swanAppWebViewManager);
        }
    }

    /* loaded from: classes8.dex */
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
                b.a.p0.a.r1.r.a.f().a(str);
                if (this.this$0.f43609h != null) {
                    this.this$0.f43609h.onFirstContentfulPaintExt(bdSailorWebView, str);
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
                if (this.this$0.f43609h != null) {
                    this.this$0.f43609h.onFirstImagePaintExt(bdSailorWebView, str);
                } else {
                    super.onFirstImagePaintExt(bdSailorWebView, str);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bdSailorWebView, str) == null) {
                if (this.this$0.f43609h != null) {
                    this.this$0.f43609h.onFirstLayoutDidExt(bdSailorWebView, str);
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
                if (this.this$0.f43609h != null) {
                    this.this$0.f43609h.onFirstPaintDidExt(bdSailorWebView, str);
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
                if (this.this$0.f43609h != null) {
                    this.this$0.f43609h.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
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
                if (this.this$0.f43609h != null) {
                    this.this$0.f43609h.onFirstTextPaintExt(bdSailorWebView, str);
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
                if (this.this$0.f43609h != null) {
                    this.this$0.f43609h.onFullScreenModeExt(bdSailorWebView, z, i2, i3);
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
                if (this.this$0.f43609h != null) {
                    return this.this$0.f43609h.onGetErrorHtmlExt(bdSailorWebView, i2, str, str2);
                }
                return super.onGetErrorHtmlExt(bdSailorWebView, i2, str, str2);
            }
            return (String) invokeLILL.objValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onKeywordExtensionExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdSailorWebView, str, str2)) == null) {
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f43609h != null) {
                    return this.this$0.f43609h.onKeywordExtensionExt(bdSailorWebView, str, str2);
                }
                return super.onKeywordExtensionExt(bdSailorWebView, str, str2);
            }
            return invokeLLL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageBackOrForwardExt(BdSailorWebView bdSailorWebView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048585, this, bdSailorWebView, i2) == null) {
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f43609h != null) {
                    this.this$0.f43609h.onPageBackOrForwardExt(bdSailorWebView, i2);
                } else {
                    super.onPageBackOrForwardExt(bdSailorWebView, i2);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageCanBeScaledExt(BdSailorWebView bdSailorWebView, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048586, this, bdSailorWebView, z) == null) {
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f43609h != null) {
                    this.this$0.f43609h.onPageCanBeScaledExt(bdSailorWebView, z);
                } else {
                    super.onPageCanBeScaledExt(bdSailorWebView, z);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPreloadUrlFoundExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, bdSailorWebView, str) == null) {
                if (SwanAppWebViewManager.z) {
                    String str2 = "SwanAppWebViewClient::onPreloadUrlFoundEx：" + str;
                }
                if (this.this$0.f43609h != null) {
                    this.this$0.f43609h.onPreloadUrlFoundExt(bdSailorWebView, str);
                } else {
                    super.onPreloadUrlFoundExt(bdSailorWebView, str);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onSecurityCheckResultExt(BdSailorWebView bdSailorWebView, String str, WebViewClient.SecurityInfo securityInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048588, this, bdSailorWebView, str, securityInfo) == null) {
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f43609h != null) {
                    this.this$0.f43609h.onSecurityCheckResultExt(bdSailorWebView, str, securityInfo);
                } else {
                    super.onSecurityCheckResultExt(bdSailorWebView, str, securityInfo);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, bdSailorWebView, str)) == null) {
                if (SwanAppWebViewManager.z) {
                    String str2 = "SwanAppWebViewClient::onSubFrameBeforeRequest url: " + str;
                }
                if (this.this$0.f43609h != null) {
                    return this.this$0.f43609h.onSubFrameBeforeRequest(bdSailorWebView, str);
                }
                return super.onSubFrameBeforeRequest(bdSailorWebView, str);
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onUrlRedirectedExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048590, this, bdSailorWebView, str, str2) == null) {
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f43609h != null) {
                    this.this$0.f43609h.onUrlRedirectedExt(bdSailorWebView, str, str2);
                } else {
                    super.onUrlRedirectedExt(bdSailorWebView, str, str2);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean shouldHandleImageExt(BdSailorWebView bdSailorWebView, String str, String str2, String str3, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{bdSailorWebView, str, str2, str3, Boolean.valueOf(z)})) == null) {
                boolean unused = SwanAppWebViewManager.z;
                if (this.this$0.f43609h == null || !this.this$0.f43609h.shouldHandleImageExt(bdSailorWebView, str, str2, str3, z)) {
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

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43626e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppWebViewManager f43627f;

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
            this.f43627f = swanAppWebViewManager;
            this.f43626e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = this.f43626e;
                if (!str.startsWith("javascript:")) {
                    str = "javascript:" + str;
                }
                if (SwanAppWebViewManager.z) {
                    String str2 = "webview load js:" + str;
                }
                this.f43627f.f43607f.evaluateJavascript(str, null);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends b.a.p0.a.o0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43628g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43629h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f43630i;
        public final /* synthetic */ SwanAppWebViewManager j;

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
            this.j = swanAppWebViewManager;
            this.f43628g = str;
            this.f43629h = str2;
            this.f43630i = str3;
        }

        @Override // b.a.p0.a.o0.c
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.j.C0(this.f43628g, this.f43629h, this.f43630i);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43631e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43632f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43633g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ SwanAppWebViewManager f43634h;

        public c(SwanAppWebViewManager swanAppWebViewManager, String str, String str2, String str3) {
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
            this.f43634h = swanAppWebViewManager;
            this.f43631e = str;
            this.f43632f = str2;
            this.f43633g = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f43634h.C0(this.f43631e, this.f43632f, this.f43633g);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f43635a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GeolocationPermissions.Callback f43636b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SwanAppWebViewManager f43637c;

        public d(SwanAppWebViewManager swanAppWebViewManager, String str, GeolocationPermissions.Callback callback) {
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
            this.f43637c = swanAppWebViewManager;
            this.f43635a = str;
            this.f43636b = callback;
        }

        @Override // b.a.p0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (SwanAppWebViewManager.z) {
                    String str2 = str + "";
                }
                this.f43637c.z0(this.f43635a, this.f43636b);
            }
        }

        @Override // b.a.p0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                if (SwanAppWebViewManager.z) {
                    String str2 = str + "";
                }
                this.f43637c.U0(this.f43635a, this.f43636b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f43638a;

        public e(SwanAppWebViewManager swanAppWebViewManager) {
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
            this.f43638a = false;
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
        z = k.f6397a;
        b.a.p0.a.h2.d.c();
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
        this.o = new e(this);
        this.p = new ArrayList();
        this.q = false;
        this.r = null;
        this.s = null;
        this.x = -1;
        this.y = new b.a.p0.a.d1.b.a();
        this.f43606e = new MutableContextWrapper(context);
        b.a.p0.a.h0.f.d.a.k().l();
        H0();
        Q0();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.z1.a.d.a
    /* renamed from: A0 */
    public NgWebView R(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            this.f43606e.setBaseContext(context);
            if (this.f43607f == null) {
                L0();
            }
            return this.f43607f;
        }
        return (NgWebView) invokeL.objValue;
    }

    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b.a.p0.a.c1.a.t0().a(this.f43607f);
        }
    }

    public final void C0(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3) == null) {
            if (z) {
                String str4 = "handleSchemeDispatchCallback callback: " + str;
                String str5 = "handleSchemeDispatchCallback params: " + str2;
            }
            if (this.f43607f.isDestroyed()) {
                boolean z2 = z;
                return;
            }
            this.f43607f.evaluateJavascript("javascript:" + str + "(" + str3 + SmallTailInfo.EMOTION_SUFFIX, null);
        }
    }

    @Nullable
    public synchronized b.a.p0.a.y0.j.b D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                if (this.u == null) {
                    if (!b.a.p0.a.a2.d.g().r().e()) {
                        return null;
                    }
                    SwanAppActivity x = b.a.p0.a.a2.d.g().x();
                    if (x == null) {
                        return null;
                    }
                    this.u = new b.a.p0.a.y0.j.b(x, b());
                }
                return this.u;
            }
        }
        return (b.a.p0.a.y0.j.b) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.p.e.d
    /* renamed from: E0 */
    public NgWebView s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f43607f : (NgWebView) invokeV.objValue;
    }

    public void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f43607f.goBack();
        }
    }

    @SuppressLint({"NewApi"})
    public final void G0(String str, GeolocationPermissions.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, callback) == null) {
            b.a.p0.a.s1.e.e("android.permission.ACCESS_FINE_LOCATION", new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, b.a.p0.a.a2.d.g().x(), new d(this, str, callback));
        }
    }

    @DebugTrace
    public final void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            S0(this.o);
            L0();
            O0(this);
            I0();
            N0();
            K0();
            M0();
            T0();
            J0();
        }
    }

    public final void I0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.k == null) {
            this.k = new UnitedSchemeMainDispatcher();
        }
    }

    public abstract void J0();

    public void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.y.e(this.f43607f, this.f43606e.getBaseContext(), this, this.k);
        }
    }

    public final void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            if (b.a.p0.a.c1.a.Z().y()) {
                this.f43607f = new NgWebView(this.f43606e);
            } else {
                this.f43607f = new NgWebView(this.f43606e.getBaseContext());
            }
            if (this.f43607f.getCurrentWebView() != null) {
                this.r = this.f43607f.getCurrentWebView().getBackground();
                AbsoluteLayout webViewImpl = this.f43607f.getWebViewImpl();
                if (webViewImpl != null) {
                    this.s = webViewImpl.getBackground();
                }
            }
            if (this.o.f43638a) {
                this.f43607f.setBackgroundColorForSwanApp(0);
                if (!BdZeusUtil.isWebkitLoaded()) {
                    this.q = true;
                }
            }
            this.f43607f.setScrollBarStyle(0);
            this.j = new b.a.p0.a.h0.h.b(this.f43606e.getBaseContext());
            if (z) {
                String str = "WebViewManager " + hashCode() + " initializing Clients";
            }
            this.f43607f.setWebViewClient(new SwanAppWebViewClient(this, null));
            this.f43607f.setWebViewClientExt(new SwanAppWebViewClientExt(this, null));
            this.f43607f.setWebChromeClient(new SwanAppWebChromeClient(this, null));
            this.f43607f.setWebChromeClientExt(new SwanAppWebChromeClientExt(this, null));
            this.f43607f.setOverScrollMode(2);
            this.f43607f.setOnCommonEventHandler(this);
            this.f43607f.setWebViewManager(this);
            this.f43607f.getCurrentWebView().setLongClickable(true);
            this.f43607f.setSelectPopWindowListener(this);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            BdSailorWebSettings settings = this.f43607f.getSettings();
            ISailorWebSettingsExt settingsExt = this.f43607f.getSettingsExt();
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
            String path = this.f43606e.getDir("databases", 0).getPath();
            String path2 = this.f43606e.getDir("geolocation", 0).getPath();
            String path3 = this.f43606e.getDir("appcache", 0).getPath();
            settings.setGeolocationDatabasePath(path2);
            settings.setDatabasePath(path);
            settings.setAppCachePath(path3);
            if (((ActivityManager) this.f43606e.getSystemService("activity")).getMemoryClass() > 16) {
                settings.setPageCacheCapacity(5);
            } else {
                settings.setPageCacheCapacity(1);
            }
            this.v = settings.getUserAgentString();
            Z0(this.w);
            try {
                settings.setPluginState(WebSettings.PluginState.ON_DEMAND);
            } catch (Exception e2) {
                e2.printStackTrace();
            } catch (NoClassDefFoundError e3) {
                e3.printStackTrace();
            }
        }
    }

    @Override // b.a.p0.a.p.e.d
    @UiThread
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f43607f.onPause();
            this.f43607f.pauseTimers();
        }
    }

    public void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.k == null) {
                if (!z) {
                    I0();
                } else {
                    throw new IllegalStateException("initSwanAppDispatcher() must be called after initDispatcher()");
                }
            }
            this.l = b.a.p0.a.c2.a.a(this.k);
        }
    }

    public void O0(SwanAppWebViewManager swanAppWebViewManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, swanAppWebViewManager) == null) {
            this.y.f(this.f43606e.getBaseContext(), this.f43607f);
        }
    }

    public void P0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            q0.b0(new a(this, str));
        }
    }

    @CallSuper
    public void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            b.a.p0.a.g1.i.a(this);
        }
    }

    @CallSuper
    public void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.w = null;
            b.a.p0.a.g1.i.b(this);
        }
    }

    public void S0(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, eVar) == null) {
        }
    }

    @Override // b.a.p0.a.p.e.d
    public void T(b.a.p0.a.h0.j.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, cVar) == null) && cVar != null && this.p.contains(cVar)) {
            this.p.remove(cVar);
        }
    }

    public void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
        }
    }

    public final void U0(String str, GeolocationPermissions.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, str, callback) == null) {
            if (z) {
                String str2 = "rejectGeoLocationOnce origin: " + str;
            }
            callback.invoke(str, false, false);
        }
    }

    public final void V0(BdSailorWebChromeClient bdSailorWebChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bdSailorWebChromeClient) == null) {
            this.f43610i = bdSailorWebChromeClient;
        }
    }

    public final void W0(BdSailorWebViewClient bdSailorWebViewClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bdSailorWebViewClient) == null) {
            this.f43608g = bdSailorWebViewClient;
        }
    }

    public final void X0(BdSailorWebViewClientExt bdSailorWebViewClientExt) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bdSailorWebViewClientExt) == null) {
            this.f43609h = bdSailorWebViewClientExt;
        }
    }

    public void Y0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
            this.x = i2;
            if (z) {
                String str = "CustomView orientation has been set to [" + this.x + "] for once";
            }
        }
    }

    public void Z0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.w = str;
            BdSailorWebSettings settings = this.f43607f.getSettings();
            String str2 = this.v;
            if (!TextUtils.isEmpty(str)) {
                str2 = String.format("%s %s", str2, str);
            }
            String b2 = b.a.p0.a.s2.a.b(str2);
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

    @Override // b.a.p0.a.p.e.d
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.t : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.p.e.d
    public String a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? "ai_apps" : (String) invokeV.objValue;
    }

    public final void a1() {
        ISailorWebViewExt webViewExt;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (webViewExt = this.f43607f.getWebViewExt()) == null) {
            return;
        }
        webViewExt.emulateShiftHeldOnNormalTextExt();
    }

    @Override // b.a.p0.a.p.e.d
    public abstract String b();

    public final void b1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048609, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        String path = Uri.parse(str).getPath();
        if (z) {
            String str2 = "pathList item: " + str + " ,folder: " + path + " ,parent: " + new File(path).getParent();
        }
        if (TextUtils.isEmpty(path)) {
            return;
        }
        this.f43607f.getSettings().setCodeCacheSetting(b.a.p0.a.h0.d.b.a("appframe", new File(path).getParent()));
    }

    @Override // b.a.p0.a.p.e.d
    public void c(b.a.p0.a.h0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, bVar) == null) {
            this.n = bVar;
        }
    }

    @Override // b.a.p0.a.p.e.d
    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
        }
    }

    @Override // b.a.p0.a.p.e.d
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.m.removeCallbacks(null);
            this.f43607f.destroy();
            this.p.clear();
            R0();
        }
    }

    @Override // b.a.p0.a.h0.f.b
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.swan.apps.core.container.view.SwanAppSelectPopView.a
    public void doSelectionCopy(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            B0();
            b.a.p0.a.c1.a.t0().e(str, this.f43606e.getBaseContext());
        }
    }

    @Override // com.baidu.swan.apps.core.container.view.SwanAppSelectPopView.a
    public void doSelectionSearch(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            B0();
            b.a.p0.a.c1.a.t0().d(str, this.f43606e.getBaseContext());
        }
    }

    @Override // b.a.p0.a.p.e.d
    public void e(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, activity) == null) {
            boolean z2 = z;
            if (activity == null) {
                boolean z3 = z;
                return;
            }
            this.y.a(activity);
            this.f43606e.setBaseContext(activity);
        }
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public String getCurrentPageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? s().getUrl() : (String) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public void handleSchemeDispatchCallback(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048619, this, str, str2) == null) {
            String quote = TextUtils.isEmpty(str2) ? "" : JSONObject.quote(str2);
            if (b.a.p0.a.r1.l.e.a()) {
                b.a.p0.a.o0.b.b().c(new b(this, str, str2, quote), str);
            } else {
                this.m.post(new c(this, str, str2, quote));
            }
        }
    }

    @Override // b.a.p0.a.p.e.d, b.a.p0.a.h0.l.a
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
            b1(str);
            this.f43607f.loadUrl(str);
        }
    }

    @Override // b.a.p0.a.h0.f.c
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.p.e.d
    public void onJSLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
        }
    }

    @Override // b.a.p0.a.h0.f.b
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048623, this, i2, keyEvent)) == null) {
            if (i2 == 4 && this.f43607f.canGoBack()) {
                F0();
                return true;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // b.a.p0.a.p.e.d
    @CallSuper
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            this.f43607f.onPause();
            b.a.p0.a.g1.i.c(this);
        }
    }

    @Override // b.a.p0.a.p.e.d
    @CallSuper
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            this.f43607f.onResume();
            b.a.p0.a.g1.i.d(this);
        }
    }

    @Override // b.a.p0.a.h0.f.b
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        List<b.a.p0.a.h0.j.c> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048626, this, i2, i3, i4, i5) == null) || (list = this.p) == null) {
            return;
        }
        for (b.a.p0.a.h0.j.c cVar : list) {
            if (cVar != null) {
                cVar.onScrollChanged(i2, i3, i4, i5);
            }
        }
    }

    @Override // b.a.p0.a.h0.f.b
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.p0.a.p.e.d
    @UiThread
    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            this.f43607f.onResume();
            this.f43607f.resumeTimers();
        }
    }

    @Override // b.a.p0.a.p.e.d
    public void t(b.a.p0.a.h0.j.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048630, this, cVar) == null) || cVar == null || this.p.contains(cVar)) {
            return;
        }
        this.p.add(cVar);
    }

    @Override // b.a.p0.a.h0.f.c
    public boolean u(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048631, this, z2)) == null) ? z2 : invokeZ.booleanValue;
    }

    public final void z0(String str, GeolocationPermissions.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048632, this, str, callback) == null) {
            if (z) {
                String str2 = "allowGeoLocationOnce origin: " + str;
            }
            callback.invoke(str, true, false);
        }
    }

    /* loaded from: classes8.dex */
    public class SwanAppWebChromeClientExt extends BdSailorWebChromeClientExt {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mIsFirstTimeShow;
        public final /* synthetic */ SwanAppWebViewManager this$0;

        /* loaded from: classes8.dex */
        public class a implements ValueCallback<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ SwanAppWebChromeClientExt f43617a;

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
                this.f43617a = swanAppWebChromeClientExt;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.webkit.ValueCallback
            /* renamed from: a */
            public void onReceiveValue(String str) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
                    return;
                }
                b.a.p0.a.e0.d.a("SwanAppWebViewManager", "onReceiveValue: " + str);
                JsonReader jsonReader = new JsonReader(new StringReader(str));
                jsonReader.setLenient(true);
                try {
                    try {
                        if (jsonReader.peek() != JsonToken.NULL && jsonReader.peek() == JsonToken.STRING) {
                            String nextString = jsonReader.nextString();
                            if (!TextUtils.isEmpty(nextString)) {
                                b.a.p0.a.c1.a.t0().b(this.f43617a.this$0.f43607f, nextString);
                            }
                        }
                    } catch (IOException e2) {
                        if (SwanAppWebViewManager.z) {
                            e2.printStackTrace();
                        }
                    }
                } finally {
                    b.a.p0.t.d.d(jsonReader);
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
                this.this$0.f43607f.hidePopWindow();
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
                    this.this$0.a1();
                } else if (type == 5) {
                    this.this$0.f43607f.evaluateJavascript(String.format("javascript:(function(){return window.getImageSrcByCoordinate(%s,%s);})()", Integer.valueOf(n0.L(i2)), Integer.valueOf(n0.L(i3))), new a(this));
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
                b.a.p0.a.c1.a.t0().c(this.this$0.f43607f, i2, i3, i4, i5, str, this.mIsFirstTimeShow);
                this.mIsFirstTimeShow = false;
            }
        }

        public /* synthetic */ SwanAppWebChromeClientExt(SwanAppWebViewManager swanAppWebViewManager, a aVar) {
            this(swanAppWebViewManager);
        }
    }
}
