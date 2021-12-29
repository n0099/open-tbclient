package com.baidu.swan.apps.core.slave;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.h0.g.l;
import c.a.r0.a.h0.h.c;
import c.a.r0.a.k;
import c.a.r0.a.n2.n;
import c.a.r0.a.p1.q.a;
import c.a.r0.a.u1.h;
import c.a.r0.a.u1.i;
import c.a.r0.a.z2.o0;
import c.a.r0.a.z2.q;
import c.a.r0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.BdSailorWebChromeClient;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.BdSailorWebViewClient;
import com.baidu.browser.sailor.BdSailorWebViewClientExt;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.res.ui.DomainErrorView;
import com.baidu.swan.apps.res.ui.EfficientProgressBar;
import com.baidu.swan.apps.res.ui.NetworkErrorView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.VideoPlayerFactory;
import com.baidu.webkit.sdk.WebChromeClient;
import com.baidu.webkit.sdk.WebResourceRequest;
import com.baidu.webkit.sdk.WebResourceResponse;
import com.kwad.v8.NodeJS;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class SwanAppWebViewWidget extends SwanAppSlaveManager implements c.a.r0.a.p.e.e<NgWebView> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d0;
    public static final String[] e0;
    public transient /* synthetic */ FieldHolder $fh;
    public g R;
    public f S;
    public e T;
    @Nullable
    public c.a.r0.a.f2.f.q0.d U;
    public c.a.r0.a.h0.h.c V;
    public int W;
    public int X;
    public c.a.r0.a.h0.j.d Y;
    public String Z;
    public SwanAppSlaveManager a0;
    public boolean b0;
    public boolean c0;

    /* loaded from: classes11.dex */
    public class SwanAppWebChromeClient extends BdSailorWebChromeClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppWebViewWidget this$0;

        /* loaded from: classes11.dex */
        public class a implements c.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(SwanAppWebChromeClient swanAppWebChromeClient) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {swanAppWebChromeClient};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.r0.a.h0.h.c.b
            public void onCustomViewHidden() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                }
            }
        }

        public SwanAppWebChromeClient(SwanAppWebViewWidget swanAppWebViewWidget) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppWebViewWidget};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = swanAppWebViewWidget;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onHideCustomView(BdSailorWebView bdSailorWebView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bdSailorWebView)) == null) {
                this.this$0.P1();
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedTitle(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdSailorWebView, str) == null) {
                super.onReceivedTitle(bdSailorWebView, str);
                if (o0.r(str)) {
                    return;
                }
                this.this$0.Z = str;
                c.a.r0.a.h0.j.d dVar = this.this$0.Y;
                if (dVar != null) {
                    dVar.a(str);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onShowCustomView(BdSailorWebView bdSailorWebView, View view, WebChromeClient.CustomViewCallback customViewCallback) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, bdSailorWebView, view, customViewCallback)) == null) ? onShowCustomView(bdSailorWebView, view, 0, customViewCallback) : invokeLLL.booleanValue;
        }

        public /* synthetic */ SwanAppWebChromeClient(SwanAppWebViewWidget swanAppWebViewWidget, a aVar) {
            this(swanAppWebViewWidget);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onShowCustomView(BdSailorWebView bdSailorWebView, View view, int i2, WebChromeClient.CustomViewCallback customViewCallback) {
            InterceptResult invokeLLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(Constants.METHOD_SEND_USER_MSG, this, bdSailorWebView, view, i2, customViewCallback)) == null) {
                if (this.this$0.V == null) {
                    this.this$0.V = new c.a.r0.a.h0.h.c(this.this$0.f40061e.getBaseContext());
                }
                this.this$0.V.c(view, i2, new a(this));
                return true;
            }
            return invokeLLIL.booleanValue;
        }
    }

    /* loaded from: classes11.dex */
    public class SwanAppWebViewWidgetClientExt extends BdSailorWebViewClientExt {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppWebViewWidget this$0;

        /* loaded from: classes11.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ long f40107e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ HybridUbcFlow f40108f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SwanAppWebViewWidgetClientExt f40109g;

            public a(SwanAppWebViewWidgetClientExt swanAppWebViewWidgetClientExt, long j2, HybridUbcFlow hybridUbcFlow) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {swanAppWebViewWidgetClientExt, Long.valueOf(j2), hybridUbcFlow};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f40109g = swanAppWebViewWidgetClientExt;
                this.f40107e = j2;
                this.f40108f = hybridUbcFlow;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f40109g.this$0.L.f8343c <= 0) {
                        j2 = this.f40107e;
                    } else {
                        j2 = this.f40109g.this$0.L.f8343c;
                    }
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(j2);
                    this.f40108f.D("fmp_type", this.f40109g.this$0.L.f8347g);
                    SwanAppWebViewWidget swanAppWebViewWidget = this.f40109g.this$0;
                    swanAppWebViewWidget.P.f(swanAppWebViewWidget.L.f8347g, true);
                    this.f40109g.this$0.P.d(ubcFlowEvent, false);
                    HybridUbcFlow hybridUbcFlow = this.f40108f;
                    hybridUbcFlow.F(ubcFlowEvent);
                    hybridUbcFlow.S();
                    if (SwanAppWebViewWidget.d0) {
                        String str = "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j2 + " , fmpType" + this.f40109g.this$0.L.f8347g + " , fmpTypeName=" + this.f40109g.this$0.L.a();
                    }
                }
            }
        }

        public SwanAppWebViewWidgetClientExt(SwanAppWebViewWidget swanAppWebViewWidget) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppWebViewWidget};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = swanAppWebViewWidget;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, bdSailorWebView, str) == null) {
                c.a.r0.a.e0.d.k("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstContentfulPaintExt");
                super.onFirstContentfulPaintExt(bdSailorWebView, str);
                long currentTimeMillis = System.currentTimeMillis();
                if (SwanAppWebViewWidget.d0) {
                    String str2 = "on fcp: real fcp = " + currentTimeMillis;
                }
                this.this$0.L.f8342b = currentTimeMillis;
                c.a.r0.a.u1.k.f.j().n().a(this.this$0.L.f8342b);
                long b2 = this.this$0.L.b();
                if (SwanAppWebViewWidget.d0) {
                    String str3 = "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime" + b2 + " , aligned search=false";
                }
                HybridUbcFlow p = h.p(NodeJS.STARTUP_SCRIPT_NAME);
                if (this.this$0.o1()) {
                    this.this$0.P.e(true);
                    p.b("fmp_data_record", this.this$0.P);
                }
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_paint");
                ubcFlowEvent.h(b2);
                p.F(ubcFlowEvent);
                if (this.this$0.a0 != null) {
                    this.this$0.a0.M.a();
                }
                if (this.this$0.L.f8343c == 0) {
                    this.this$0.L.f8343c = b2;
                    c.a.r0.a.p.e.j.d dVar = this.this$0.L;
                    dVar.f8347g = dVar.c(b2);
                    p.D("fmp_type", "1");
                    UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent2.h(this.this$0.L.f8342b);
                    p.F(ubcFlowEvent2);
                    this.this$0.P.f("1", false);
                    this.this$0.P.d(ubcFlowEvent2, false);
                    return;
                }
                long G = c.a.r0.a.c1.a.g0().G();
                if (G < 0) {
                    G = 3000;
                }
                q.c(new a(this, b2, p), "fmp record", G, TimeUnit.MILLISECONDS);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdSailorWebView, str) == null) {
                c.a.r0.a.e0.d.k("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstImagePaintExt");
                super.onFirstImagePaintExt(bdSailorWebView, str);
                this.this$0.L.f8345e = System.currentTimeMillis();
                c.a.r0.a.u1.k.f.j().n().g(this.this$0.L.f8345e);
                if (SwanAppWebViewWidget.d0) {
                    String str2 = "on fip: real fip = " + this.this$0.L.f8345e;
                }
                if (this.this$0.L.f8343c == 0) {
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(this.this$0.L.f8345e);
                    HybridUbcFlow p = h.p(NodeJS.STARTUP_SCRIPT_NAME);
                    p.D("fmp_type", "3");
                    p.F(ubcFlowEvent);
                    this.this$0.P.f("3", false);
                    this.this$0.P.d(ubcFlowEvent, false);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bdSailorWebView, str) == null) {
                super.onFirstLayoutDidExt(bdSailorWebView, str);
                if (TextUtils.isEmpty(this.this$0.K)) {
                    return;
                }
                h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, this.this$0.K).F(new UbcFlowEvent("web_widget_first_layout"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, bdSailorWebView, str) == null) {
                super.onFirstPaintDidExt(bdSailorWebView, str);
                this.this$0.L.a = System.currentTimeMillis();
                if (TextUtils.isEmpty(this.this$0.K)) {
                    return;
                }
                h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, this.this$0.K).F(new UbcFlowEvent("web_widget_first_paint"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, bdSailorWebView, str) == null) {
                c.a.r0.a.e0.d.k("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstScreenPaintFinishedEx");
                super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
                this.this$0.L.f8343c = System.currentTimeMillis();
                this.this$0.L.f8347g = "0";
                c.a.r0.a.u1.k.f.j().n().e(this.this$0.L.f8343c);
                if (SwanAppWebViewWidget.d0) {
                    String str2 = "on fmp: real fmp = " + this.this$0.L.f8343c;
                }
                HybridUbcFlow d2 = h.d(NodeJS.STARTUP_SCRIPT_NAME);
                if (d2 != null) {
                    if (TextUtils.isEmpty(str)) {
                        str = "0";
                    }
                    d2.D("webviewComponent", str);
                    d2.D("fmp_type", "0");
                    d2.E("value", "arrive_success");
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(this.this$0.L.f8343c);
                    ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE);
                    this.this$0.P.f("0", true);
                    this.this$0.P.d(ubcFlowEvent, true);
                    d2.F(ubcFlowEvent);
                    d2.S();
                    c.a.r0.a.p.e.j.d dVar = this.this$0.L;
                    c.a.r0.a.e0.d.b("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(this.this$0.L.f8343c), " , fmpType=", dVar.f8347g, " , fmpTypeName=", dVar.a());
                    h.t();
                }
                if (!TextUtils.isEmpty(this.this$0.K)) {
                    i.f(this.this$0.K);
                    this.this$0.K = "";
                }
                if (this.this$0.a0 != null) {
                    this.this$0.a0.M.g();
                    this.this$0.a0.M.b();
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, bdSailorWebView, str) == null) {
                c.a.r0.a.e0.d.k("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstTextPaintExt");
                super.onFirstTextPaintExt(bdSailorWebView, str);
                this.this$0.L.f8344d = System.currentTimeMillis();
                c.a.r0.a.u1.k.f.j().n().f(this.this$0.L.f8344d);
                if (SwanAppWebViewWidget.d0) {
                    String str2 = "on ftp: real ftp = " + this.this$0.L.f8344d;
                }
                if (this.this$0.L.f8343c == 0) {
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(this.this$0.L.f8344d);
                    HybridUbcFlow p = h.p(NodeJS.STARTUP_SCRIPT_NAME);
                    p.D("fmp_type", "2");
                    p.F(ubcFlowEvent);
                    this.this$0.P.f("2", false);
                    this.this$0.P.d(ubcFlowEvent, false);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bdSailorWebView, str)) == null) {
                if (c.a.r0.a.c1.a.g0().x() && this.this$0.X1() && c.a.r0.a.e2.a.b.k()) {
                    return false;
                }
                if (c.a.r0.a.c1.a.g0().x() && this.this$0.W1() && !c.a.r0.a.e2.a.b.h(str)) {
                    if (SwanAppWebViewWidget.d0) {
                        String str2 = "WebSafeCheckers.checkWebDomain() failed url: " + str;
                        return true;
                    }
                    return true;
                }
                return super.onSubFrameBeforeRequest(bdSailorWebView, str);
            }
            return invokeLL.booleanValue;
        }

        public /* synthetic */ SwanAppWebViewWidgetClientExt(SwanAppWebViewWidget swanAppWebViewWidget, a aVar) {
            this(swanAppWebViewWidget);
        }
    }

    /* loaded from: classes11.dex */
    public class WebViewWidgetClient extends BdSailorWebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppWebViewWidget this$0;

        public WebViewWidgetClient(SwanAppWebViewWidget swanAppWebViewWidget) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppWebViewWidget};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = swanAppWebViewWidget;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void doUpdateVisitedHistory(BdSailorWebView bdSailorWebView, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, bdSailorWebView, str, z) == null) {
                super.doUpdateVisitedHistory(bdSailorWebView, str, z);
                n.W(str, bdSailorWebView.getSettings().getUserAgentString());
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdSailorWebView, str) == null) {
                c.a.r0.a.e0.d.b("SwanAppWebViewWidget", "onPageFinished, url: " + str);
                if (this.this$0.X1() && c.a.r0.a.e2.a.b.k()) {
                    this.this$0.N1().c(str);
                } else {
                    this.this$0.N1().b();
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageStarted(BdSailorWebView bdSailorWebView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, bdSailorWebView, str, bitmap) == null) {
                c.a.r0.a.e0.d.b("SwanAppWebViewWidget", "onPageStarted, url: " + str);
                if (this.this$0.X1() && c.a.r0.a.e2.a.b.k()) {
                    this.this$0.N1().f(str);
                } else {
                    this.this$0.N1().d();
                }
                this.this$0.J1();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048579, this, bdSailorWebView, i2, str, str2) == null) {
                super.onReceivedError(bdSailorWebView, i2, str, str2);
                if (i2 == -10) {
                    return;
                }
                this.this$0.M1().c();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedHttpError(BdSailorWebView bdSailorWebView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048580, this, bdSailorWebView, webResourceRequest, webResourceResponse) == null) {
                super.onReceivedHttpError(bdSailorWebView, webResourceRequest, webResourceResponse);
                c.a.r0.a.h0.j.d dVar = this.this$0.Y;
                if (dVar != null) {
                    dVar.b(webResourceResponse != null ? webResourceResponse.getStatusCode() : 0);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bdSailorWebView, str)) == null) {
                if (SwanAppWebViewWidget.d0) {
                    String str2 = "shouldOverrideUrlLoading url: " + str;
                }
                Uri A = q0.A(str);
                if (A != null) {
                    c.a.r0.a.z2.f.g(this.this$0.f40061e, new Intent("android.intent.action.DIAL", A));
                    return true;
                }
                c.a.r0.a.h0.j.d dVar = this.this$0.J;
                if (dVar != null) {
                    return dVar.c(str);
                }
                if (!c.a.r0.a.x1.a.a.A()) {
                    boolean unused = SwanAppWebViewWidget.d0;
                    return false;
                } else if (this.this$0.K1(str)) {
                    return true;
                } else {
                    if (!this.this$0.W1() || c.a.r0.a.e2.a.b.h(str)) {
                        return false;
                    }
                    this.this$0.Y1(str);
                    return true;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes11.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppWebViewWidget f40110b;

        /* renamed from: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public class RunnableC1862a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f40111e;

            public RunnableC1862a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f40111e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f40111e.f40110b.t().loadUrl(this.f40111e.a);
                }
            }
        }

        /* loaded from: classes11.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f40112e;

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f40112e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.f40112e;
                    aVar.f40110b.Y1(aVar.a);
                    this.f40112e.f40110b.N1().c("none");
                }
            }
        }

        /* loaded from: classes11.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f40113e;

            public c(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f40113e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.f40113e;
                    aVar.f40110b.Y1(aVar.a);
                    this.f40113e.f40110b.N1().c("none");
                }
            }
        }

        public a(SwanAppWebViewWidget swanAppWebViewWidget, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppWebViewWidget, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40110b = swanAppWebViewWidget;
            this.a = str;
        }

        @Override // c.a.r0.a.p1.q.a.b
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                c.a.r0.a.e0.d.b("SwanAppWebViewWidget", "isblockdomain request success, response data: " + jSONObject + ", url: " + this.a);
                if (jSONObject != null && jSONObject.optInt("result", -1) == 0) {
                    q0.a0(new RunnableC1862a(this));
                    return;
                }
                c.a.r0.a.e0.d.o("SwanAppWebViewWidget", "isblockdomain request success, but check result failed: " + jSONObject + ", url: " + this.a);
                q0.a0(new b(this));
            }
        }

        @Override // c.a.r0.a.p1.q.a.b
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                c.a.r0.a.e0.d.o("SwanAppWebViewWidget", "isblockdomain request failed, msg: " + str + ", url: " + this.a);
                q0.a0(new c(this));
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppWebViewWidget f40114e;

        public b(SwanAppWebViewWidget swanAppWebViewWidget) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppWebViewWidget};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40114e = swanAppWebViewWidget;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && SwanAppNetworkUtils.i(this.f40114e.t().getContext())) {
                if (!this.f40114e.W1() || c.a.r0.a.e2.a.b.h(this.f40114e.t().getUrl())) {
                    this.f40114e.t().reload();
                    this.f40114e.S.a();
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c implements c.a.r0.a.h0.f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppWebViewWidget f40115e;

        public c(SwanAppWebViewWidget swanAppWebViewWidget) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppWebViewWidget};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40115e = swanAppWebViewWidget;
        }

        @Override // c.a.r0.a.h0.f.c
        public boolean p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f40115e.L1().a();
                this.f40115e.t().setOnWebViewHookHandler(this.f40115e);
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.r0.a.h0.f.c
        public boolean v(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? z : invokeZ.booleanValue;
        }
    }

    /* loaded from: classes11.dex */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f40116e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.a.h0.g.d f40117f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SwanAppWebViewWidget f40118g;

        public d(SwanAppWebViewWidget swanAppWebViewWidget, View view, c.a.r0.a.h0.g.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppWebViewWidget, view, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40118g = swanAppWebViewWidget;
            this.f40116e = view;
            this.f40117f = dVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = SwanAppWebViewWidget.d0;
                this.f40118g.R1(this.f40116e, this.f40117f);
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final DomainErrorView a;

        public e(@NonNull Context context, @NonNull ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            DomainErrorView domainErrorView = new DomainErrorView(context);
            this.a = domainErrorView;
            domainErrorView.setBackgroundColor(-1);
            viewGroup.addView(this.a, new FrameLayout.LayoutParams(-1, -1));
            this.a.setVisibility(8);
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.setVisibility(8);
            }
        }

        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.a.showError(str);
                this.a.setVisibility(0);
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetworkErrorView a;

        public f(@NonNull Context context, @NonNull ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            NetworkErrorView networkErrorView = new NetworkErrorView(context);
            this.a = networkErrorView;
            networkErrorView.setBackgroundColor(-1);
            viewGroup.addView(this.a, new FrameLayout.LayoutParams(-1, -1));
            this.a.setVisibility(8);
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.setVisibility(8);
            }
        }

        public void b(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
                this.a.setOnClickListener(onClickListener);
                this.a.setReloadClickListener(onClickListener);
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.setVisibility(0);
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public EfficientProgressBar a;

        /* renamed from: b  reason: collision with root package name */
        public String f40119b;

        public g(@NonNull Context context, @NonNull ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            EfficientProgressBar efficientProgressBar = new EfficientProgressBar(context);
            this.a = efficientProgressBar;
            efficientProgressBar.setProgressDrawable(context.getResources().getDrawable(c.a.r0.a.e.aiapps_progress_thumb));
            this.a.setId(c.a.r0.a.f.aiapps_nbsearch_web_loading_progress_bar);
            this.a.setVisibility(4);
            this.a.setFocusable(false);
            this.a.setClickable(false);
            viewGroup.addView(this.a);
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.setProgress(100, true);
            }
        }

        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (TextUtils.isEmpty(str)) {
                    str = "none";
                }
                int indexOf = str.indexOf("#");
                if (indexOf != -1) {
                    str = str.substring(0, indexOf);
                }
                int indexOf2 = this.f40119b.indexOf("#");
                if (str.equals(indexOf2 == -1 ? this.f40119b : this.f40119b.substring(0, indexOf2))) {
                    b();
                }
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.reset();
                g(0);
            }
        }

        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                f(str);
                d();
            }
        }

        public void f(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                if (TextUtils.isEmpty(str)) {
                    this.f40119b = "none";
                } else {
                    this.f40119b = str;
                }
            }
        }

        public void g(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
                this.a.setProgress(i2, true);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1106964947, "Lcom/baidu/swan/apps/core/slave/SwanAppWebViewWidget;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1106964947, "Lcom/baidu/swan/apps/core/slave/SwanAppWebViewWidget;");
                return;
            }
        }
        d0 = k.a;
        e0 = new String[]{"http", "https"};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppWebViewWidget(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.X = 0;
        this.b0 = true;
        this.c0 = true;
        a1(new WebViewWidgetClient(this));
        Z0(new SwanAppWebChromeClient(this, null));
        b1(new SwanAppWebViewWidgetClientExt(this, null));
        VideoPlayerFactory b2 = c.a.r0.a.c1.a.g().b();
        if (b2 != null) {
            this.f40062f.getCurrentWebView().setVideoPlayerFactory(b2);
        }
        V1();
        Z1(context);
        t().setOnWebViewHookHandler(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            SwanAppSlaveManager swanAppSlaveManager = this.a0;
            return (swanAppSlaveManager == null || swanAppSlaveManager.M.f7041c) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void J1() {
        c.a.r0.a.h0.g.g V;
        c.a.r0.a.h0.g.d m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (V = c.a.r0.a.g1.f.U().V()) == null || (m = V.m()) == null || m.W() == null) {
            return;
        }
        View view = null;
        if (m instanceof c.a.r0.a.h0.g.f) {
            if (((c.a.r0.a.h0.g.f) m).i3().l() == null) {
                return;
            }
            view = m.W().findViewById(c.a.r0.a.f.ai_apps_fragment_base_view);
        } else if (m instanceof l) {
            if (((l) m).l() == null || m.W() == null) {
                return;
            }
            view = m.W().findViewById(c.a.r0.a.f.swan_app_webview_fragment);
        }
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new d(this, view, m));
    }

    public final boolean K1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (X1() && c.a.r0.a.e2.a.b.k()) {
                if (c.a.r0.a.e2.a.b.j(str)) {
                    q0.W(this.f40061e, str);
                    return true;
                } else if (TextUtils.isEmpty(str) || str.startsWith("http")) {
                    c.a.r0.a.p1.q.a aVar = new c.a.r0.a.p1.q.a();
                    aVar.g(str);
                    N1().e("none");
                    aVar.d(new a(this, str));
                    return true;
                } else {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final e L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.T == null) {
                this.T = new e(t().getContext(), t());
            }
            return this.T;
        }
        return (e) invokeV.objValue;
    }

    public final f M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.S == null) {
                f fVar = new f(t().getContext(), t());
                this.S = fVar;
                fVar.b(new b(this));
            }
            return this.S;
        }
        return (f) invokeV.objValue;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    public void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public g N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.R == null) {
                this.R = new g(t().getContext(), t());
            }
            return this.R;
        }
        return (g) invokeV.objValue;
    }

    public int O1() {
        InterceptResult invokeV;
        EfficientProgressBar efficientProgressBar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            g gVar = this.R;
            if (gVar == null || (efficientProgressBar = gVar.a) == null) {
                return 0;
            }
            return efficientProgressBar.getHeight();
        }
        return invokeV.intValue;
    }

    public final void P1() {
        c.a.r0.a.h0.h.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (cVar = this.V) == null) {
            return;
        }
        cVar.a();
    }

    public final void Q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            T0("document.querySelector('video').pause();");
        }
    }

    public final void R1(View view, c.a.r0.a.h0.g.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, view, dVar) == null) || dVar == null || dVar.i0()) {
            return;
        }
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int i2 = rect.bottom - rect.top;
        int i3 = this.W;
        if (i2 == i3) {
            return;
        }
        if (i3 - i2 > 200) {
            int i4 = 0;
            if (dVar instanceof c.a.r0.a.h0.g.f) {
                c.a.r0.a.h0.g.f fVar = (c.a.r0.a.h0.g.f) dVar;
                if (fVar.Y1() && fVar.x3()) {
                    i4 = view.getResources().getDimensionPixelSize(c.a.r0.a.d.aiapps_bottom_tab_height);
                }
            }
            view.getLayoutParams().height = i4 + i2 + this.X;
        } else {
            view.getLayoutParams().height = -1;
        }
        view.requestLayout();
        this.W = i2;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void S0(SwanAppWebViewManager swanAppWebViewManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, swanAppWebViewManager) == null) {
            super.S0(swanAppWebViewManager);
        }
    }

    public void S1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.b0 = z;
        }
    }

    public void T1(SwanAppSlaveManager swanAppSlaveManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, swanAppSlaveManager) == null) {
            this.a0 = swanAppSlaveManager;
        }
    }

    public void U1(@Nullable c.a.r0.a.f2.f.q0.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) {
            this.U = dVar;
        }
    }

    public final void V1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f40062f.getSettings().setLoadWithOverviewMode(true);
            this.f40062f.getSettings().setUseWideViewPort(true);
            this.f40062f.getSettings().setSupportZoom(true);
            this.f40062f.getSettings().setBuiltInZoomControls(true);
            this.f40062f.getSettings().setDisplayZoomControls(false);
        }
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    public void W0(SwanAppWebViewManager.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, dVar) == null) {
            super.W0(dVar);
            dVar.a = false;
        }
    }

    public boolean W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.b0 : invokeV.booleanValue;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    public void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.X0();
            c.a.r0.a.f2.f.q0.f fVar = new c.a.r0.a.f2.f.q0.f(this.l);
            fVar.j(this);
            this.l.b(fVar);
        }
    }

    public boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.c0 : invokeV.booleanValue;
    }

    public final void Y1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            URL url = new URL(str);
            for (String str2 : e0) {
                if (TextUtils.equals(url.getProtocol(), str2)) {
                    L1().b(str);
                    t().setOnWebViewHookHandler(new c(this));
                    return;
                }
            }
        } catch (MalformedURLException e2) {
            if (d0) {
                e2.printStackTrace();
            }
        }
    }

    public final void Z1(Context context) {
        c.a.r0.a.p.d.c a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, context) == null) || (a2 = c.a.r0.a.d2.d.J().y().a().a()) == null) {
            return;
        }
        a2.a(context);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, c.a.r0.a.p.e.b
    public void a0(c.a.r0.a.h0.j.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, dVar) == null) {
            this.Y = dVar;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, c.a.r0.a.p.e.d
    public String d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? "ai_apps_widget" : (String) invokeV.objValue;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, c.a.r0.a.p.e.d
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.Y = null;
            super.destroy();
        }
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, c.a.r0.a.p.e.d
    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.g0();
        }
    }

    @Override // c.a.r0.a.p.e.e
    @Nullable
    public c.a.r0.a.f2.f.q0.d getParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.U : (c.a.r0.a.f2.f.q0.d) invokeV.objValue;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, c.a.r0.a.p.e.d, c.a.r0.a.h0.l.a
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            if (!c.a.r0.a.x1.a.a.A()) {
                boolean z = d0;
                e eVar = this.T;
                if (eVar != null) {
                    eVar.a();
                }
                super.loadUrl(str);
            } else if (K1(str)) {
            } else {
                if (W1() && !c.a.r0.a.e2.a.b.h(str)) {
                    L1().b(str);
                    return;
                }
                e eVar2 = this.T;
                if (eVar2 != null) {
                    eVar2.a();
                }
                super.loadUrl(str);
            }
        }
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, c.a.r0.a.p.e.d
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onPause();
            Q1();
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, c.a.r0.a.h0.f.c
    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            N1().b();
            return false;
        }
        return invokeV.booleanValue;
    }
}
