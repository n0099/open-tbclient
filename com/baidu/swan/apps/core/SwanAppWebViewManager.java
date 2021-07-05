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
import androidx.core.view.InputDeviceCompat;
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
import d.a.q0.a.e2.c.i;
import d.a.q0.a.e2.c.j.b;
import d.a.q0.a.h0.h.b;
import d.a.q0.a.k;
import d.a.q0.a.s1.f;
import d.a.q0.a.v2.n0;
import d.a.q0.a.v2.q0;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class SwanAppWebViewManager implements d.a.q0.a.p.e.d<NgWebView>, d.a.q0.a.h0.f.b, d.a.q0.a.h0.f.c, d.a.q0.a.z1.a.d.a<NgWebView>, SwanAppSelectPopView.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public MutableContextWrapper f10919e;

    /* renamed from: f  reason: collision with root package name */
    public NgWebView f10920f;

    /* renamed from: g  reason: collision with root package name */
    public BdSailorWebViewClient f10921g;

    /* renamed from: h  reason: collision with root package name */
    public BdSailorWebViewClientExt f10922h;

    /* renamed from: i  reason: collision with root package name */
    public BdSailorWebChromeClient f10923i;
    public d.a.q0.a.h0.h.b j;
    public UnitedSchemeMainDispatcher k;
    public d.a.q0.a.c2.e l;
    public Handler m;
    public d.a.q0.a.h0.b n;
    public final e o;
    public List<d.a.q0.a.h0.j.c> p;
    public boolean q;
    public Drawable r;
    public Drawable s;
    public String t;
    public d.a.q0.a.y0.j.b u;
    public String v;
    public String w;
    public int x;
    public d.a.q0.a.d1.b.a y;

    /* loaded from: classes4.dex */
    public class SwanAppWebChromeClient extends BdSailorWebChromeClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppWebViewManager this$0;

        /* loaded from: classes4.dex */
        public class a implements b.s {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ JsPromptResult f10924a;

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
                this.f10924a = jsPromptResult;
            }

            @Override // d.a.q0.a.h0.h.b.s
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f10924a.cancel();
                }
            }

            @Override // d.a.q0.a.h0.h.b.s
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    this.f10924a.confirm(str);
                }
            }

            @Override // d.a.q0.a.h0.h.b.s
            public void onCancel() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f10924a.cancel();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements b.s {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ JsResult f10925a;

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
                this.f10925a = jsResult;
            }

            @Override // d.a.q0.a.h0.h.b.s
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f10925a.cancel();
                }
            }

            @Override // d.a.q0.a.h0.h.b.s
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    this.f10925a.confirm();
                }
            }

            @Override // d.a.q0.a.h0.h.b.s
            public void onCancel() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f10925a.cancel();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class c implements b.s {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ JsResult f10926a;

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
                this.f10926a = jsResult;
            }

            @Override // d.a.q0.a.h0.h.b.s
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f10926a.cancel();
                }
            }

            @Override // d.a.q0.a.h0.h.b.s
            public void b(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                    this.f10926a.confirm();
                }
            }

            @Override // d.a.q0.a.h0.h.b.s
            public void onCancel() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f10926a.cancel();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class d implements d.a.q0.a.v2.e1.b<i<b.e>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f10927e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ GeolocationPermissions.Callback f10928f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SwanAppWebChromeClient f10929g;

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
                this.f10929g = swanAppWebChromeClient;
                this.f10927e = str;
                this.f10928f = callback;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.q0.a.v2.e1.b
            /* renamed from: a */
            public void onCallback(i<b.e> iVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                    if (d.a.q0.a.e2.c.d.h(iVar)) {
                        this.f10929g.this$0.I0(this.f10927e, this.f10928f);
                    } else {
                        this.f10929g.this$0.W0(this.f10927e, this.f10928f);
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
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onCloseWindow");
                }
                if (this.this$0.f10923i != null) {
                    this.this$0.f10923i.onCloseWindow(bdSailorWebView);
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
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onConsoleMessage");
                }
                if (this.this$0.f10923i == null || !this.this$0.f10923i.onConsoleMessage(bdSailorWebView, consoleMessage)) {
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
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onCreateWindow");
                }
                if (this.this$0.f10923i == null || !this.this$0.f10923i.onCreateWindow(bdSailorWebView, z, z2, message)) {
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
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onExceededDatabaseQuota");
                }
                if (this.this$0.f10923i != null) {
                    this.this$0.f10923i.onExceededDatabaseQuota(bdSailorWebView, str, str2, j, j2, j3, quotaUpdater);
                } else {
                    super.onExceededDatabaseQuota(bdSailorWebView, str, str2, j, j2, j3, quotaUpdater);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onGeolocationPermissionsHidePrompt(BdSailorWebView bdSailorWebView) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, bdSailorWebView) == null) && SwanAppWebViewManager.z) {
                Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onGeolocationPermissionsHidePrompt");
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onGeolocationPermissionsShowPrompt(BdSailorWebView bdSailorWebView, String str, GeolocationPermissions.Callback callback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048581, this, bdSailorWebView, str, callback) == null) {
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onGeolocationPermissionsShowPrompt");
                }
                d.a.q0.a.a2.e i2 = d.a.q0.a.a2.e.i();
                if (i2 == null || i2.x() == null) {
                    this.this$0.W0(str, callback);
                } else {
                    i2.T().g(i2.x(), "mapp_location", new d(this, str, callback));
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onHideCustomView(BdSailorWebView bdSailorWebView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bdSailorWebView)) == null) {
                if (this.this$0.f10923i != null ? this.this$0.f10923i.onHideCustomView(bdSailorWebView) : false) {
                    if (SwanAppWebViewManager.z) {
                        Log.i("SwanAppWebViewManager", "SwanAppWebChromeClient::onHideCustomView by external client");
                    }
                    return true;
                }
                if (this.this$0.F0() != null) {
                    this.this$0.F0().d();
                }
                if (SwanAppWebViewManager.z) {
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
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onJsAlert");
                }
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
                    Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onJsBeforeUnload：" + str);
                }
                if (this.this$0.f10923i == null || !this.this$0.f10923i.onJsBeforeUnload(bdSailorWebView, str, str2, jsResult)) {
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
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onJsConfirm");
                }
                return this.this$0.j.m(str, str2, new c(this, jsResult));
            }
            return invokeLLLL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onJsPrompt(BdSailorWebView bdSailorWebView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            InterceptResult invokeLLLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048586, this, bdSailorWebView, str, str2, str3, jsPromptResult)) == null) {
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onJsPrompt");
                }
                return this.this$0.j.n(str, str2, str3, new a(this, jsPromptResult));
            }
            return invokeLLLLL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onJsTimeout(BdSailorWebView bdSailorWebView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bdSailorWebView)) == null) {
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onJsTimeout  ");
                }
                if (this.this$0.f10923i == null || !this.this$0.f10923i.onJsTimeout(bdSailorWebView)) {
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
                if (this.this$0.f10923i != null) {
                    this.this$0.f10923i.onProgressChanged(bdSailorWebView, i2);
                } else {
                    super.onProgressChanged(bdSailorWebView, i2);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReachedMaxAppCacheSize(BdSailorWebView bdSailorWebView, long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{bdSailorWebView, Long.valueOf(j), Long.valueOf(j2), quotaUpdater}) == null) {
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onReachedMaxAppCacheSize");
                }
                if (this.this$0.f10923i != null) {
                    this.this$0.f10923i.onReachedMaxAppCacheSize(bdSailorWebView, j, j2, quotaUpdater);
                } else {
                    super.onReachedMaxAppCacheSize(bdSailorWebView, j, j2, quotaUpdater);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedIcon(BdSailorWebView bdSailorWebView, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048590, this, bdSailorWebView, bitmap) == null) {
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onReachedMaxAppCacheSize");
                }
                if (this.this$0.f10923i != null) {
                    this.this$0.f10923i.onReceivedIcon(bdSailorWebView, bitmap);
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
                    Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onReceivedTitleInFact : " + str);
                }
                if (this.this$0.f10923i != null) {
                    this.this$0.f10923i.onReceivedTitle(bdSailorWebView, str);
                } else {
                    super.onReceivedTitle(bdSailorWebView, str);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedTouchIconUrl(BdSailorWebView bdSailorWebView, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048592, this, bdSailorWebView, str, z) == null) {
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onReceivedTouchIconUrl");
                }
                if (this.this$0.f10923i != null) {
                    this.this$0.f10923i.onReceivedTouchIconUrl(bdSailorWebView, str, z);
                } else {
                    super.onReceivedTouchIconUrl(bdSailorWebView, str, z);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onRequestFocus(BdSailorWebView bdSailorWebView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048593, this, bdSailorWebView) == null) {
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::onRequestFocus");
                }
                if (this.this$0.f10923i != null) {
                    this.this$0.f10923i.onRequestFocus(bdSailorWebView);
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
                if (this.this$0.f10923i != null ? this.this$0.f10923i.onShowCustomView(bdSailorWebView, view, customViewCallback) : false) {
                    if (SwanAppWebViewManager.z) {
                        Log.i("SwanAppWebViewManager", "SwanAppWebChromeClient::onShowCustomView by external client");
                    }
                    return true;
                }
                if (this.this$0.x != -1) {
                    i2 = this.this$0.x;
                } else {
                    int i3 = d.a.q0.a.a2.d.g().f46672g;
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
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::openFileChooser");
                }
                if (this.this$0.f10923i != null) {
                    this.this$0.f10923i.openFileChooser(bdSailorWebView, valueCallback);
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
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::openFileChooser");
                }
                if (this.this$0.f10923i != null) {
                    this.this$0.f10923i.openFileChooser(bdSailorWebView, valueCallback, str);
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
                    Log.d("SwanAppWebViewManager", "CustomView orientation applied, set back to default [" + this.this$0.x + PreferencesUtil.RIGHT_MOUNT);
                }
                if (this.this$0.f10923i != null ? this.this$0.f10923i.onShowCustomView(bdSailorWebView, view, i2, customViewCallback) : false) {
                    if (SwanAppWebViewManager.z) {
                        Log.i("SwanAppWebViewManager", "SwanAppWebChromeClient::onShowCustomView by external client");
                    }
                    return true;
                }
                if (this.this$0.F0() != null) {
                    this.this$0.F0().g(view, i2, null);
                }
                if (SwanAppWebViewManager.z) {
                    Log.i("SwanAppWebViewManager", "SwanAppWebChromeClient::onShowCustomView : " + i2);
                }
                return true;
            }
            return invokeLLIL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void openFileChooser(BdSailorWebView bdSailorWebView, ValueCallback valueCallback, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048599, this, bdSailorWebView, valueCallback, str, str2) == null) {
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebChromeClient::openFileChooser");
                }
                if (this.this$0.f10923i != null) {
                    this.this$0.f10923i.openFileChooser(bdSailorWebView, valueCallback, str, str2);
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
        public class a implements b.t {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ SslErrorHandler f10931a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ BdSailorWebView f10932b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ SslError f10933c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ SwanAppWebViewClient f10934d;

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
                this.f10934d = swanAppWebViewClient;
                this.f10931a = sslErrorHandler;
                this.f10932b = bdSailorWebView;
                this.f10933c = sslError;
            }

            @Override // d.a.q0.a.h0.h.b.t
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f10934d.onReceivedSslError(this.f10932b, this.f10931a, this.f10933c);
                }
            }

            @Override // d.a.q0.a.h0.h.b.t
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.f10931a.proceed();
                }
            }

            @Override // d.a.q0.a.h0.h.b.t
            public void c() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f10931a.cancel();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements b.r {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ BdSailorWebView f10935a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f10936b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f10937c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ HttpAuthHandler f10938d;

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
                this.f10935a = bdSailorWebView;
                this.f10936b = str;
                this.f10937c = str2;
                this.f10938d = httpAuthHandler;
            }

            @Override // d.a.q0.a.h0.h.b.r
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f10938d.cancel();
                }
            }

            @Override // d.a.q0.a.h0.h.b.r
            public void b(String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
                    BdSailorWebView bdSailorWebView = this.f10935a;
                    if (bdSailorWebView != null) {
                        bdSailorWebView.setHttpAuthUsernamePassword(this.f10936b, this.f10937c, str, str2);
                    }
                    this.f10938d.proceed(str, str2);
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
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::doUpdateVisitedHistory");
                }
                if (this.this$0.f10921g != null) {
                    this.this$0.f10921g.doUpdateVisitedHistory(bdSailorWebView, str, z);
                } else {
                    super.doUpdateVisitedHistory(bdSailorWebView, str, z);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onFormResubmission(BdSailorWebView bdSailorWebView, Message message, Message message2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdSailorWebView, message, message2) == null) {
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFormResubmission");
                }
                if (this.this$0.f10921g != null) {
                    this.this$0.f10921g.onFormResubmission(bdSailorWebView, message, message2);
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
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onLoadResource：" + str);
                }
                if (this.this$0.f10921g != null) {
                    this.this$0.f10921g.onLoadResource(bdSailorWebView, str);
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
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onPageFinished url: " + str);
                }
                if (this.this$0.q) {
                    WebView currentWebView = this.this$0.f10920f.getCurrentWebView();
                    if (currentWebView != null) {
                        currentWebView.setBackground(this.this$0.r);
                        this.this$0.q = false;
                    }
                    AbsoluteLayout webViewImpl = this.this$0.f10920f.getWebViewImpl();
                    if (webViewImpl != null) {
                        webViewImpl.setBackground(this.this$0.s);
                    }
                }
                if (this.this$0.n != null) {
                    this.this$0.n.a(str);
                }
                if (this.this$0.f10921g != null) {
                    this.this$0.f10921g.onPageFinished(bdSailorWebView, str);
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
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onPageStarted url: " + str);
                }
                if (this.this$0.f10921g != null) {
                    this.this$0.f10921g.onPageStarted(bdSailorWebView, str, bitmap);
                } else {
                    super.onPageStarted(bdSailorWebView, str, bitmap);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedClientCertRequest(BdSailorWebView bdSailorWebView, ClientCertRequest clientCertRequest) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, bdSailorWebView, clientCertRequest) == null) {
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedClientCertRequest");
                }
                if (this.this$0.f10921g != null) {
                    this.this$0.f10921g.onReceivedClientCertRequest(bdSailorWebView, clientCertRequest);
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
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedError errorCode: " + i2 + " ,failingUrl: " + str2);
                }
                if (this.this$0.f10921g != null) {
                    this.this$0.f10921g.onReceivedError(bdSailorWebView, i2, str, str2);
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
                } else if (this.this$0.f10920f.isShown()) {
                    if (SwanAppWebViewManager.z) {
                        Log.d("SwanAppWebViewManager", "OnReceivedHttpAuthRequest show Http Auth dialog ");
                    }
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
                if (this.this$0.f10921g != null) {
                    this.this$0.f10921g.onReceivedHttpError(bdSailorWebView, webResourceRequest, webResourceResponse);
                } else {
                    super.onReceivedHttpError(bdSailorWebView, webResourceRequest, webResourceResponse);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedLoginRequest(BdSailorWebView bdSailorWebView, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048585, this, bdSailorWebView, str, str2, str3) == null) {
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedLoginRequest");
                }
                if (this.this$0.f10921g != null) {
                    this.this$0.f10921g.onReceivedLoginRequest(bdSailorWebView, str, str2, str3);
                } else {
                    super.onReceivedLoginRequest(bdSailorWebView, str, str2, str3);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedSslError(BdSailorWebView bdSailorWebView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048586, this, bdSailorWebView, sslErrorHandler, sslError) == null) {
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onReceivedSslError");
                }
                if (this.this$0.f10920f.isShown()) {
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
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onScaleChanged");
                }
                if (this.this$0.f10921g != null) {
                    this.this$0.f10921g.onScaleChanged(bdSailorWebView, f2, f3);
                } else {
                    super.onScaleChanged(bdSailorWebView, f2, f3);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onUnhandledKeyEvent(BdSailorWebView bdSailorWebView, KeyEvent keyEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048588, this, bdSailorWebView, keyEvent) == null) {
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onUnhandledKeyEvent");
                }
                if (this.this$0.f10921g != null) {
                    this.this$0.f10921g.onUnhandledKeyEvent(bdSailorWebView, keyEvent);
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
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::shouldInterceptRequest");
                }
                WebResourceResponse shouldInterceptRequest = this.this$0.f10921g != null ? this.this$0.f10921g.shouldInterceptRequest(bdSailorWebView, webResourceRequest) : null;
                if (shouldInterceptRequest == null) {
                    shouldInterceptRequest = d.a.q0.a.h0.o.h.a.b().c(webResourceRequest, true);
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
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::shouldOverrideKeyEvent");
                }
                if (this.this$0.f10921g == null || !this.this$0.f10921g.shouldOverrideKeyEvent(bdSailorWebView, keyEvent)) {
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
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::shouldOverrideUrlLoading url: " + str);
                }
                if (this.this$0.f10921g != null) {
                    return this.this$0.f10921g.shouldOverrideUrlLoading(bdSailorWebView, str);
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
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstContentfulPaintExt");
                }
                d.a.q0.a.r1.r.a.f().a(str);
                if (this.this$0.f10922h != null) {
                    this.this$0.f10922h.onFirstContentfulPaintExt(bdSailorWebView, str);
                } else {
                    super.onFirstContentfulPaintExt(bdSailorWebView, str);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdSailorWebView, str) == null) {
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstImagePaintExt");
                }
                if (this.this$0.f10922h != null) {
                    this.this$0.f10922h.onFirstImagePaintExt(bdSailorWebView, str);
                } else {
                    super.onFirstImagePaintExt(bdSailorWebView, str);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bdSailorWebView, str) == null) {
                if (this.this$0.f10922h != null) {
                    this.this$0.f10922h.onFirstLayoutDidExt(bdSailorWebView, str);
                } else {
                    super.onFirstLayoutDidExt(bdSailorWebView, str);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, bdSailorWebView, str) == null) {
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstPaintDidEx");
                }
                if (this.this$0.f10922h != null) {
                    this.this$0.f10922h.onFirstPaintDidExt(bdSailorWebView, str);
                } else {
                    super.onFirstPaintDidExt(bdSailorWebView, str);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, bdSailorWebView, str) == null) {
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstScreenPaintFinishedEx");
                }
                if (this.this$0.f10922h != null) {
                    this.this$0.f10922h.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
                } else {
                    super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, bdSailorWebView, str) == null) {
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFirstTextPaintExt");
                }
                if (this.this$0.f10922h != null) {
                    this.this$0.f10922h.onFirstTextPaintExt(bdSailorWebView, str);
                } else {
                    super.onFirstTextPaintExt(bdSailorWebView, str);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFullScreenModeExt(BdSailorWebView bdSailorWebView, boolean z, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{bdSailorWebView, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onFullScreenModeEx");
                }
                if (this.this$0.f10922h != null) {
                    this.this$0.f10922h.onFullScreenModeExt(bdSailorWebView, z, i2, i3);
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
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onGetErrorHtmlSailor");
                }
                if (this.this$0.f10922h != null) {
                    return this.this$0.f10922h.onGetErrorHtmlExt(bdSailorWebView, i2, str, str2);
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
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onKeywordExtensionEx");
                }
                if (this.this$0.f10922h != null) {
                    return this.this$0.f10922h.onKeywordExtensionExt(bdSailorWebView, str, str2);
                }
                return super.onKeywordExtensionExt(bdSailorWebView, str, str2);
            }
            return invokeLLL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageBackOrForwardExt(BdSailorWebView bdSailorWebView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048585, this, bdSailorWebView, i2) == null) {
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onGoBackOrForwardEx");
                }
                if (this.this$0.f10922h != null) {
                    this.this$0.f10922h.onPageBackOrForwardExt(bdSailorWebView, i2);
                } else {
                    super.onPageBackOrForwardExt(bdSailorWebView, i2);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageCanBeScaledExt(BdSailorWebView bdSailorWebView, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048586, this, bdSailorWebView, z) == null) {
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onPageCanBeScaledEx");
                }
                if (this.this$0.f10922h != null) {
                    this.this$0.f10922h.onPageCanBeScaledExt(bdSailorWebView, z);
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
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onPreloadUrlFoundEx：" + str);
                }
                if (this.this$0.f10922h != null) {
                    this.this$0.f10922h.onPreloadUrlFoundExt(bdSailorWebView, str);
                } else {
                    super.onPreloadUrlFoundExt(bdSailorWebView, str);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onSecurityCheckResultExt(BdSailorWebView bdSailorWebView, String str, WebViewClient.SecurityInfo securityInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048588, this, bdSailorWebView, str, securityInfo) == null) {
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onSecurityCheckResultEx");
                }
                if (this.this$0.f10922h != null) {
                    this.this$0.f10922h.onSecurityCheckResultExt(bdSailorWebView, str, securityInfo);
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
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onSubFrameBeforeRequest url: " + str);
                }
                if (this.this$0.f10922h != null) {
                    return this.this$0.f10922h.onSubFrameBeforeRequest(bdSailorWebView, str);
                }
                return super.onSubFrameBeforeRequest(bdSailorWebView, str);
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onUrlRedirectedExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048590, this, bdSailorWebView, str, str2) == null) {
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::onUrlRedirected");
                }
                if (this.this$0.f10922h != null) {
                    this.this$0.f10922h.onUrlRedirectedExt(bdSailorWebView, str, str2);
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
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "SwanAppWebViewClient::canHandleImageEx");
                }
                if (this.this$0.f10922h == null || !this.this$0.f10922h.shouldHandleImageExt(bdSailorWebView, str, str2, str3, z)) {
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

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10939e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SwanAppWebViewManager f10940f;

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
            this.f10940f = swanAppWebViewManager;
            this.f10939e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String str = this.f10939e;
                if (!str.startsWith("javascript:")) {
                    str = "javascript:" + str;
                }
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "webview load js:" + str);
                }
                this.f10940f.f10920f.evaluateJavascript(str, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.a.q0.a.o0.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f10941g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f10942h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f10943i;
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
            this.f10941g = str;
            this.f10942h = str2;
            this.f10943i = str3;
        }

        @Override // d.a.q0.a.o0.c
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.j.E0(this.f10941g, this.f10942h, this.f10943i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f10944e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f10945f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f10946g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ SwanAppWebViewManager f10947h;

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
            this.f10947h = swanAppWebViewManager;
            this.f10944e = str;
            this.f10945f = str2;
            this.f10946g = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f10947h.E0(this.f10944e, this.f10945f, this.f10946g);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f10948a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GeolocationPermissions.Callback f10949b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SwanAppWebViewManager f10950c;

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
            this.f10950c = swanAppWebViewManager;
            this.f10948a = str;
            this.f10949b = callback;
        }

        @Override // d.a.q0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (SwanAppWebViewManager.z) {
                    Log.e("SwanAppWebViewManager", str + "");
                }
                this.f10950c.B0(this.f10948a, this.f10949b);
            }
        }

        @Override // d.a.q0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                if (SwanAppWebViewManager.z) {
                    Log.e("SwanAppWebViewManager", str + "");
                }
                this.f10950c.W0(this.f10948a, this.f10949b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f10951a;

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
            this.f10951a = false;
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
        z = k.f49133a;
        d.a.q0.a.h2.d.c();
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
        this.y = new d.a.q0.a.d1.b.a();
        this.f10919e = new MutableContextWrapper(context);
        d.a.q0.a.h0.f.d.a.k().l();
        J0();
        S0();
    }

    public final void B0(String str, GeolocationPermissions.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, callback) == null) {
            if (z) {
                Log.d("SwanAppWebViewManager", "allowGeoLocationOnce origin: " + str);
            }
            callback.invoke(str, true, false);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a.z1.a.d.a
    /* renamed from: C0 */
    public NgWebView T(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            this.f10919e.setBaseContext(context);
            if (this.f10920f == null) {
                N0();
            }
            return this.f10920f;
        }
        return (NgWebView) invokeL.objValue;
    }

    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d.a.q0.a.c1.a.t0().a(this.f10920f);
        }
    }

    public final void E0(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, str2, str3) == null) {
            if (z) {
                Log.d("SwanAppWebViewManager", "handleSchemeDispatchCallback callback: " + str);
                Log.d("SwanAppWebViewManager", "handleSchemeDispatchCallback params: " + str2);
            }
            if (this.f10920f.isDestroyed()) {
                if (z) {
                    Log.e("SwanAppWebViewManager", "handleSchemeDispatchCallback webview is destroyed.");
                    return;
                }
                return;
            }
            this.f10920f.evaluateJavascript("javascript:" + str + "(" + str3 + SmallTailInfo.EMOTION_SUFFIX, null);
        }
    }

    @Nullable
    public synchronized d.a.q0.a.y0.j.b F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                if (this.u == null) {
                    if (!d.a.q0.a.a2.d.g().r().e()) {
                        return null;
                    }
                    SwanAppActivity x = d.a.q0.a.a2.d.g().x();
                    if (x == null) {
                        return null;
                    }
                    this.u = new d.a.q0.a.y0.j.b(x, b());
                }
                return this.u;
            }
        }
        return (d.a.q0.a.y0.j.b) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a.p.e.d
    /* renamed from: G0 */
    public NgWebView u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f10920f : (NgWebView) invokeV.objValue;
    }

    public void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f10920f.goBack();
        }
    }

    @SuppressLint({"NewApi"})
    public final void I0(String str, GeolocationPermissions.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, callback) == null) {
            d.a.q0.a.s1.e.e("android.permission.ACCESS_FINE_LOCATION", new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, d.a.q0.a.a2.d.g().x(), new d(this, str, callback));
        }
    }

    @DebugTrace
    public final void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
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
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.k == null) {
            this.k = new UnitedSchemeMainDispatcher();
        }
    }

    public abstract void L0();

    public void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.y.e(this.f10920f, this.f10919e.getBaseContext(), this, this.k);
        }
    }

    public final void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (d.a.q0.a.c1.a.Z().y()) {
                this.f10920f = new NgWebView(this.f10919e);
            } else {
                this.f10920f = new NgWebView(this.f10919e.getBaseContext());
            }
            if (this.f10920f.getCurrentWebView() != null) {
                this.r = this.f10920f.getCurrentWebView().getBackground();
                AbsoluteLayout webViewImpl = this.f10920f.getWebViewImpl();
                if (webViewImpl != null) {
                    this.s = webViewImpl.getBackground();
                }
            }
            if (this.o.f10951a) {
                this.f10920f.setBackgroundColorForSwanApp(0);
                if (!BdZeusUtil.isWebkitLoaded()) {
                    this.q = true;
                }
            }
            this.f10920f.setScrollBarStyle(0);
            this.j = new d.a.q0.a.h0.h.b(this.f10919e.getBaseContext());
            if (z) {
                Log.d("SwanAppWebViewManager", "WebViewManager " + hashCode() + " initializing Clients");
            }
            this.f10920f.setWebViewClient(new SwanAppWebViewClient(this, null));
            this.f10920f.setWebViewClientExt(new SwanAppWebViewClientExt(this, null));
            this.f10920f.setWebChromeClient(new SwanAppWebChromeClient(this, null));
            this.f10920f.setWebChromeClientExt(new SwanAppWebChromeClientExt(this, null));
            this.f10920f.setOverScrollMode(2);
            this.f10920f.setOnCommonEventHandler(this);
            this.f10920f.setWebViewManager(this);
            this.f10920f.getCurrentWebView().setLongClickable(true);
            this.f10920f.setSelectPopWindowListener(this);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            BdSailorWebSettings settings = this.f10920f.getSettings();
            ISailorWebSettingsExt settingsExt = this.f10920f.getSettingsExt();
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
            String path = this.f10919e.getDir("databases", 0).getPath();
            String path2 = this.f10919e.getDir("geolocation", 0).getPath();
            String path3 = this.f10919e.getDir("appcache", 0).getPath();
            settings.setGeolocationDatabasePath(path2);
            settings.setDatabasePath(path);
            settings.setAppCachePath(path3);
            if (((ActivityManager) this.f10919e.getSystemService("activity")).getMemoryClass() > 16) {
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
    }

    @Override // d.a.q0.a.p.e.d
    @UiThread
    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f10920f.onPause();
            this.f10920f.pauseTimers();
        }
    }

    public void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.k == null) {
                if (!z) {
                    K0();
                } else {
                    throw new IllegalStateException("initSwanAppDispatcher() must be called after initDispatcher()");
                }
            }
            this.l = d.a.q0.a.c2.a.a(this.k);
        }
    }

    public void Q0(SwanAppWebViewManager swanAppWebViewManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, swanAppWebViewManager) == null) {
            this.y.f(this.f10919e.getBaseContext(), this.f10920f);
        }
    }

    public void R0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            q0.b0(new a(this, str));
        }
    }

    @CallSuper
    public void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            d.a.q0.a.g1.i.a(this);
        }
    }

    @CallSuper
    public void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.w = null;
            d.a.q0.a.g1.i.b(this);
        }
    }

    public void U0(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, eVar) == null) {
        }
    }

    @Override // d.a.q0.a.p.e.d
    public void V(d.a.q0.a.h0.j.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, cVar) == null) && cVar != null && this.p.contains(cVar)) {
            this.p.remove(cVar);
        }
    }

    public void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
        }
    }

    public final void W0(String str, GeolocationPermissions.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, str, callback) == null) {
            if (z) {
                Log.d("SwanAppWebViewManager", "rejectGeoLocationOnce origin: " + str);
            }
            callback.invoke(str, false, false);
        }
    }

    public final void X0(BdSailorWebChromeClient bdSailorWebChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bdSailorWebChromeClient) == null) {
            this.f10923i = bdSailorWebChromeClient;
        }
    }

    public final void Y0(BdSailorWebViewClient bdSailorWebViewClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bdSailorWebViewClient) == null) {
            this.f10921g = bdSailorWebViewClient;
        }
    }

    public final void Z0(BdSailorWebViewClientExt bdSailorWebViewClientExt) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bdSailorWebViewClientExt) == null) {
            this.f10922h = bdSailorWebViewClientExt;
        }
    }

    @Override // d.a.q0.a.p.e.d
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.t : (String) invokeV.objValue;
    }

    public void a1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            this.x = i2;
            if (z) {
                Log.d("SwanAppWebViewManager", "CustomView orientation has been set to [" + this.x + "] for once");
            }
        }
    }

    @Override // d.a.q0.a.p.e.d
    public abstract String b();

    public void b1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.w = str;
            BdSailorWebSettings settings = this.f10920f.getSettings();
            String str2 = this.v;
            if (!TextUtils.isEmpty(str)) {
                str2 = String.format("%s %s", str2, str);
            }
            String b2 = d.a.q0.a.s2.a.b(str2);
            if (TextUtils.equals(b2, this.t)) {
                return;
            }
            this.t = b2;
            settings.setUserAgentString(b2);
            if (z) {
                Log.i("SwanAppWebViewManager", "set ua:" + this.t);
            }
        }
    }

    @Override // d.a.q0.a.p.e.d
    public void c(d.a.q0.a.h0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, bVar) == null) {
            this.n = bVar;
        }
    }

    @Override // d.a.q0.a.p.e.d
    public String c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? "ai_apps" : (String) invokeV.objValue;
    }

    public final void c1() {
        ISailorWebViewExt webViewExt;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048610, this) == null) || (webViewExt = this.f10920f.getWebViewExt()) == null) {
            return;
        }
        webViewExt.emulateShiftHeldOnNormalTextExt();
    }

    public final void d1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        String path = Uri.parse(str).getPath();
        if (z) {
            Log.d("SwanAppWebViewManager", "pathList item: " + str + " ,folder: " + path + " ,parent: " + new File(path).getParent());
        }
        if (TextUtils.isEmpty(path)) {
            return;
        }
        this.f10920f.getSettings().setCodeCacheSetting(d.a.q0.a.h0.d.b.a("appframe", new File(path).getParent()));
    }

    @Override // d.a.q0.a.p.e.d
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.m.removeCallbacks(null);
            this.f10920f.destroy();
            this.p.clear();
            T0();
        }
    }

    @Override // d.a.q0.a.h0.f.b
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
            D0();
            d.a.q0.a.c1.a.t0().e(str, this.f10919e.getBaseContext());
        }
    }

    @Override // com.baidu.swan.apps.core.container.view.SwanAppSelectPopView.a
    public void doSelectionSearch(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            D0();
            d.a.q0.a.c1.a.t0().d(str, this.f10919e.getBaseContext());
        }
    }

    @Override // d.a.q0.a.p.e.d
    public void e(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, activity) == null) {
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
            this.f10919e.setBaseContext(activity);
        }
    }

    @Override // d.a.q0.a.p.e.d
    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
        }
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

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public void handleSchemeDispatchCallback(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048620, this, str, str2) == null) {
            String quote = TextUtils.isEmpty(str2) ? "" : JSONObject.quote(str2);
            if (d.a.q0.a.r1.l.e.a()) {
                d.a.q0.a.o0.b.b().c(new b(this, str, str2, quote), str);
            } else {
                this.m.post(new c(this, str, str2, quote));
            }
        }
    }

    @Override // d.a.q0.a.p.e.d
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            d1(str);
            this.f10920f.loadUrl(str);
        }
    }

    @Override // d.a.q0.a.p.e.d
    public void onJSLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
        }
    }

    @Override // d.a.q0.a.h0.f.b
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048623, this, i2, keyEvent)) == null) {
            if (i2 == 4 && this.f10920f.canGoBack()) {
                H0();
                return true;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    @Override // d.a.q0.a.p.e.d
    @CallSuper
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            this.f10920f.onPause();
            d.a.q0.a.g1.i.c(this);
        }
    }

    @Override // d.a.q0.a.p.e.d
    @CallSuper
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            this.f10920f.onResume();
            d.a.q0.a.g1.i.d(this);
        }
    }

    @Override // d.a.q0.a.h0.f.b
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        List<d.a.q0.a.h0.j.c> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048626, this, i2, i3, i4, i5) == null) || (list = this.p) == null) {
            return;
        }
        for (d.a.q0.a.h0.j.c cVar : list) {
            if (cVar != null) {
                cVar.onScrollChanged(i2, i3, i4, i5);
            }
        }
    }

    @Override // d.a.q0.a.h0.f.b
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.q0.a.h0.f.c
    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.q0.a.p.e.d
    @UiThread
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            this.f10920f.onResume();
            this.f10920f.resumeTimers();
        }
    }

    @Override // d.a.q0.a.p.e.d
    public void v(d.a.q0.a.h0.j.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048631, this, cVar) == null) || cVar == null || this.p.contains(cVar)) {
            return;
        }
        this.p.add(cVar);
    }

    @Override // d.a.q0.a.h0.f.c
    public boolean w(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048632, this, z2)) == null) ? z2 : invokeZ.booleanValue;
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

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ SwanAppWebChromeClientExt f10930a;

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
                this.f10930a = swanAppWebChromeClientExt;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.webkit.ValueCallback
            /* renamed from: a */
            public void onReceiveValue(String str) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || TextUtils.isEmpty(str)) {
                    return;
                }
                d.a.q0.a.e0.d.a("SwanAppWebViewManager", "onReceiveValue: " + str);
                JsonReader jsonReader = new JsonReader(new StringReader(str));
                jsonReader.setLenient(true);
                try {
                    try {
                        if (jsonReader.peek() != JsonToken.NULL && jsonReader.peek() == JsonToken.STRING) {
                            String nextString = jsonReader.nextString();
                            if (!TextUtils.isEmpty(nextString)) {
                                d.a.q0.a.c1.a.t0().b(this.f10930a.this$0.f10920f, nextString);
                            }
                        }
                    } catch (IOException e2) {
                        if (SwanAppWebViewManager.z) {
                            e2.printStackTrace();
                        }
                    }
                } finally {
                    d.a.q0.t.d.d(jsonReader);
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
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "hideSelectionActionDialogExt: ");
                }
                this.this$0.f10920f.hidePopWindow();
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
                    Log.d("SwanAppWebViewManager", "performLongClickExt: " + hitTestResult.getType() + ZeusCrashHandler.NAME_SEPERATOR + i2 + ZeusCrashHandler.NAME_SEPERATOR + i3);
                }
                int type = hitTestResult.getType();
                if (type == 10) {
                    this.this$0.c1();
                } else if (type == 5) {
                    this.this$0.f10920f.evaluateJavascript(String.format("javascript:(function(){return window.getImageSrcByCoordinate(%s,%s);})()", Integer.valueOf(n0.K(i2)), Integer.valueOf(n0.K(i3))), new a(this));
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClientExt
        public void showSelectionActionDialogExt(BdSailorWebView bdSailorWebView, int i2, int i3, int i4, int i5, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bdSailorWebView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), str}) == null) {
                super.showSelectionActionDialogExt(bdSailorWebView, i2, i3, i4, i5, str);
                if (SwanAppWebViewManager.z) {
                    Log.d("SwanAppWebViewManager", "showSelectionActionDialogExt: " + i4 + ZeusCrashHandler.NAME_SEPERATOR + i5 + ZeusCrashHandler.NAME_SEPERATOR + i2 + ZeusCrashHandler.NAME_SEPERATOR + i3 + ZeusCrashHandler.NAME_SEPERATOR + str);
                }
                d.a.q0.a.c1.a.t0().c(this.this$0.f10920f, i2, i3, i4, i5, str, this.mIsFirstTimeShow);
                this.mIsFirstTimeShow = false;
            }
        }

        public /* synthetic */ SwanAppWebChromeClientExt(SwanAppWebViewManager swanAppWebViewManager, a aVar) {
            this(swanAppWebViewManager);
        }
    }
}
