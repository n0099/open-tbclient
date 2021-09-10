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
import c.a.p0.a.h0.g.g;
import c.a.p0.a.h0.h.c;
import c.a.p0.a.k;
import c.a.p0.a.r1.h;
import c.a.p0.a.r1.i;
import c.a.p0.a.r1.k.f;
import c.a.p0.a.v2.o0;
import c.a.p0.a.v2.q;
import c.a.p0.a.v2.q0;
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
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class SwanAppWebViewWidget extends SwanAppSlaveManager implements c.a.p0.a.p.e.e<NgWebView> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b0;
    public static final String[] c0;
    public transient /* synthetic */ FieldHolder $fh;
    public e Q;
    public d R;
    public c S;
    @Nullable
    public c.a.p0.a.c2.f.r0.d T;
    public c.a.p0.a.h0.h.c U;
    public int V;
    public c.a.p0.a.h0.j.d W;
    public String X;
    public SwanAppSlaveManager Y;
    public boolean Z;
    public int a0;

    /* loaded from: classes6.dex */
    public class SwanAppWebChromeClient extends BdSailorWebChromeClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppWebViewWidget this$0;

        /* loaded from: classes6.dex */
        public class a implements c.a {
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

            @Override // c.a.p0.a.h0.h.c.a
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
                this.this$0.J1();
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
                this.this$0.X = str;
                c.a.p0.a.h0.j.d dVar = this.this$0.W;
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
                if (this.this$0.U == null) {
                    this.this$0.U = new c.a.p0.a.h0.h.c(this.this$0.f45874e.getBaseContext());
                }
                this.this$0.U.c(view, i2, new a(this));
                return true;
            }
            return invokeLLIL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class SwanAppWebViewWidgetClientExt extends BdSailorWebViewClientExt {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppWebViewWidget this$0;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ long f45930e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ HybridUbcFlow f45931f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SwanAppWebViewWidgetClientExt f45932g;

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
                this.f45932g = swanAppWebViewWidgetClientExt;
                this.f45930e = j2;
                this.f45931f = hybridUbcFlow;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (h.f8346b) {
                        boolean unused = SwanAppWebViewWidget.b0;
                        this.f45932g.this$0.k1(true);
                        return;
                    }
                    if (this.f45932g.this$0.L.f7893c <= 0) {
                        j2 = this.f45930e;
                    } else {
                        j2 = this.f45932g.this$0.L.f7893c;
                    }
                    this.f45931f.A("fmp_type", this.f45932g.this$0.L.f7897g);
                    HybridUbcFlow hybridUbcFlow = this.f45931f;
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(j2);
                    hybridUbcFlow.C(ubcFlowEvent);
                    hybridUbcFlow.P();
                    if (SwanAppWebViewWidget.b0) {
                        String str = "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j2 + " , fmpType" + this.f45932g.this$0.L.f7897g + " , fmpTypeName=" + this.f45932g.this$0.L.a();
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
                c.a.p0.a.e0.d.h("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstContentfulPaintExt");
                super.onFirstContentfulPaintExt(bdSailorWebView, str);
                long currentTimeMillis = System.currentTimeMillis();
                if (SwanAppWebViewWidget.b0) {
                    String str2 = "on fcp: real fcp = " + currentTimeMillis;
                }
                this.this$0.L.f7892b = currentTimeMillis;
                f.j().n().a(this.this$0.L.f7892b);
                long b2 = h.f8346b ? currentTimeMillis : this.this$0.L.b();
                if (SwanAppWebViewWidget.b0) {
                    String str3 = "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime" + b2 + " , aligned search=" + h.f8346b;
                }
                HybridUbcFlow p = h.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_paint");
                ubcFlowEvent.h(b2);
                p.C(ubcFlowEvent);
                if (this.this$0.Y != null) {
                    this.this$0.Y.M.a();
                }
                if (this.this$0.L.f7893c == 0) {
                    this.this$0.L.f7893c = b2;
                    c.a.p0.a.p.e.j.d dVar = this.this$0.L;
                    dVar.f7897g = dVar.c(b2);
                    p.A("fmp_type", "1");
                    UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent2.h(this.this$0.L.f7892b);
                    p.C(ubcFlowEvent2);
                    if (h.f8347c) {
                        return;
                    }
                }
                long I = c.a.p0.a.c1.a.Z().I();
                if (I < 0) {
                    I = 3000;
                }
                q.c(new a(this, b2, p), "fmp record", I, TimeUnit.MILLISECONDS);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdSailorWebView, str) == null) {
                c.a.p0.a.e0.d.h("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstImagePaintExt");
                super.onFirstImagePaintExt(bdSailorWebView, str);
                this.this$0.L.f7895e = System.currentTimeMillis();
                f.j().n().g(this.this$0.L.f7895e);
                if (SwanAppWebViewWidget.b0) {
                    String str2 = "on fip: real fip = " + this.this$0.L.f7895e;
                }
                if (h.f8346b) {
                    boolean unused = SwanAppWebViewWidget.b0;
                    this.this$0.k1(false);
                } else if (this.this$0.L.f7893c == 0) {
                    HybridUbcFlow p = h.p("startup");
                    p.A("fmp_type", "3");
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(this.this$0.L.f7895e);
                    p.C(ubcFlowEvent);
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
                h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, this.this$0.K).C(new UbcFlowEvent("web_widget_first_layout"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, bdSailorWebView, str) == null) {
                super.onFirstPaintDidExt(bdSailorWebView, str);
                this.this$0.L.f7891a = System.currentTimeMillis();
                if (TextUtils.isEmpty(this.this$0.K)) {
                    return;
                }
                h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, this.this$0.K).C(new UbcFlowEvent("web_widget_first_paint"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, bdSailorWebView, str) == null) {
                c.a.p0.a.e0.d.h("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstScreenPaintFinishedEx");
                super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
                this.this$0.L.f7893c = System.currentTimeMillis();
                this.this$0.L.f7897g = "0";
                f.j().n().e(this.this$0.L.f7893c);
                if (SwanAppWebViewWidget.b0) {
                    String str2 = "on fmp: real fmp = " + this.this$0.L.f7893c;
                }
                HybridUbcFlow d2 = h.d("startup");
                if (d2 != null) {
                    if (TextUtils.isEmpty(str)) {
                        str = "0";
                    }
                    d2.A("webviewComponent", str);
                    d2.A("fmp_type", "0");
                    d2.B("value", "arrive_success");
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(this.this$0.L.f7893c);
                    ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE);
                    d2.C(ubcFlowEvent);
                    d2.P();
                    c.a.p0.a.p.e.j.d dVar = this.this$0.L;
                    c.a.p0.a.e0.d.a("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(this.this$0.L.f7893c), " , fmpType=", dVar.f7897g, " , fmpTypeName=", dVar.a());
                    h.t();
                }
                if (!TextUtils.isEmpty(this.this$0.K)) {
                    i.f(this.this$0.K);
                    this.this$0.K = "";
                }
                if (this.this$0.Y != null) {
                    this.this$0.Y.M.g();
                    this.this$0.Y.M.b();
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, bdSailorWebView, str) == null) {
                c.a.p0.a.e0.d.h("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstTextPaintExt");
                super.onFirstTextPaintExt(bdSailorWebView, str);
                this.this$0.L.f7894d = System.currentTimeMillis();
                f.j().n().f(this.this$0.L.f7894d);
                if (SwanAppWebViewWidget.b0) {
                    String str2 = "on ftp: real ftp = " + this.this$0.L.f7894d;
                }
                if (h.f8346b) {
                    boolean unused = SwanAppWebViewWidget.b0;
                    this.this$0.k1(false);
                } else if (this.this$0.L.f7893c == 0) {
                    HybridUbcFlow p = h.p("startup");
                    p.A("fmp_type", "2");
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(this.this$0.L.f7894d);
                    p.C(ubcFlowEvent);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bdSailorWebView, str)) == null) {
                if (c.a.p0.a.c1.a.Z().z() && this.this$0.Q1() && !c.a.p0.a.b2.a.b.h(str)) {
                    if (SwanAppWebViewWidget.b0) {
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

    /* loaded from: classes6.dex */
    public class WebViewWidgetClient extends BdSailorWebViewClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppWebViewWidget this$0;

        /* loaded from: classes6.dex */
        public class a implements c.a.p0.a.h0.f.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ WebViewWidgetClient f45933e;

            public a(WebViewWidgetClient webViewWidgetClient) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {webViewWidgetClient};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45933e = webViewWidgetClient;
            }

            @Override // c.a.p0.a.h0.f.c
            public boolean p() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    this.f45933e.this$0.F1().a();
                    this.f45933e.this$0.t().setOnWebViewHookHandler(null);
                    return true;
                }
                return invokeV.booleanValue;
            }

            @Override // c.a.p0.a.h0.f.c
            public boolean v(boolean z) {
                InterceptResult invokeZ;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? z : invokeZ.booleanValue;
            }
        }

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

        private void showDomainErrorView(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(65537, this, str) == null) || TextUtils.isEmpty(str)) {
                return;
            }
            try {
                URL url = new URL(str);
                for (String str2 : SwanAppWebViewWidget.c0) {
                    if (TextUtils.equals(url.getProtocol(), str2)) {
                        this.this$0.F1().b(str);
                        this.this$0.t().setOnWebViewHookHandler(new a(this));
                        return;
                    }
                }
            } catch (MalformedURLException e2) {
                if (SwanAppWebViewWidget.b0) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, bdSailorWebView, str) == null) {
                this.this$0.H1().b();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageStarted(BdSailorWebView bdSailorWebView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdSailorWebView, str, bitmap) == null) {
                this.this$0.H1().c();
                this.this$0.E1();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_SEND_USER_MSG, this, bdSailorWebView, i2, str, str2) == null) {
                super.onReceivedError(bdSailorWebView, i2, str, str2);
                if (i2 == -10) {
                    return;
                }
                this.this$0.G1().c();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedHttpError(BdSailorWebView bdSailorWebView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048579, this, bdSailorWebView, webResourceRequest, webResourceResponse) == null) {
                super.onReceivedHttpError(bdSailorWebView, webResourceRequest, webResourceResponse);
                c.a.p0.a.h0.j.d dVar = this.this$0.W;
                if (dVar != null) {
                    dVar.b(webResourceResponse != null ? webResourceResponse.getStatusCode() : 0);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, bdSailorWebView, str)) == null) {
                if (SwanAppWebViewWidget.b0) {
                    String str2 = "shouldOverrideUrlLoading url: " + str;
                }
                Uri A = q0.A(str);
                if (A != null) {
                    c.a.p0.a.v2.f.g(this.this$0.f45874e, new Intent("android.intent.action.DIAL", A));
                    return true;
                }
                SwanAppWebViewWidget swanAppWebViewWidget = this.this$0;
                c.a.p0.a.h0.j.d dVar = swanAppWebViewWidget.J;
                if (dVar != null) {
                    return dVar.c(str);
                }
                if (!swanAppWebViewWidget.Q1() || c.a.p0.a.b2.a.b.h(str)) {
                    return false;
                }
                showDomainErrorView(str);
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppWebViewWidget f45934e;

        public a(SwanAppWebViewWidget swanAppWebViewWidget) {
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
            this.f45934e = swanAppWebViewWidget;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && SwanAppNetworkUtils.i(this.f45934e.t().getContext())) {
                if (!this.f45934e.Q1() || c.a.p0.a.b2.a.b.h(this.f45934e.t().getUrl())) {
                    this.f45934e.t().reload();
                    this.f45934e.R.a();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f45935e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.h0.g.d f45936f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SwanAppWebViewWidget f45937g;

        public b(SwanAppWebViewWidget swanAppWebViewWidget, View view, c.a.p0.a.h0.g.d dVar) {
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
            this.f45937g = swanAppWebViewWidget;
            this.f45935e = view;
            this.f45936f = dVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean unused = SwanAppWebViewWidget.b0;
                this.f45937g.L1(this.f45935e, this.f45936f);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public DomainErrorView f45938a;

        public c(@NonNull Context context, @NonNull ViewGroup viewGroup) {
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
            this.f45938a = domainErrorView;
            domainErrorView.setBackgroundColor(-1);
            viewGroup.addView(this.f45938a, new FrameLayout.LayoutParams(-1, -1));
            this.f45938a.setVisibility(8);
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f45938a.setVisibility(8);
            }
        }

        public void b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f45938a.showError(str);
                this.f45938a.setVisibility(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetworkErrorView f45939a;

        public d(@NonNull Context context, @NonNull ViewGroup viewGroup) {
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
            this.f45939a = networkErrorView;
            networkErrorView.setBackgroundColor(-1);
            viewGroup.addView(this.f45939a, new FrameLayout.LayoutParams(-1, -1));
            this.f45939a.setVisibility(8);
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f45939a.setVisibility(8);
            }
        }

        public void b(View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onClickListener) == null) {
                this.f45939a.setOnClickListener(onClickListener);
                this.f45939a.setReloadClickListener(onClickListener);
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f45939a.setVisibility(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public EfficientProgressBar f45940a;

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
            this.f45940a = null;
            EfficientProgressBar efficientProgressBar = new EfficientProgressBar(context);
            this.f45940a = efficientProgressBar;
            efficientProgressBar.setProgressDrawable(context.getResources().getDrawable(c.a.p0.a.e.aiapps_progress_thumb));
            this.f45940a.setId(c.a.p0.a.f.aiapps_nbsearch_web_loading_progress_bar);
            this.f45940a.setVisibility(4);
            this.f45940a.setFocusable(false);
            this.f45940a.setClickable(false);
            viewGroup.addView(this.f45940a);
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f45940a.setProgress(100, true);
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f45940a.reset();
                d(0);
            }
        }

        public void d(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                this.f45940a.setProgress(i2, true);
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
        b0 = k.f7077a;
        c0 = new String[]{"http", "https"};
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
        this.Z = true;
        this.a0 = 200;
        X0(new WebViewWidgetClient(this));
        W0(new SwanAppWebChromeClient(this, null));
        Y0(new SwanAppWebViewWidgetClientExt(this, null));
        VideoPlayerFactory b2 = c.a.p0.a.c1.a.f().b();
        if (b2 != null) {
            this.f45875f.getCurrentWebView().setVideoPlayerFactory(b2);
        }
        P1();
        R1(context);
    }

    public void E1() {
        g W;
        c.a.p0.a.h0.g.d m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (W = c.a.p0.a.g1.f.V().W()) == null || (m = W.m()) == null || m.f0() == null) {
            return;
        }
        View view = null;
        if (m instanceof c.a.p0.a.h0.g.f) {
            if (((c.a.p0.a.h0.g.f) m).Z2().l() == null) {
                return;
            }
            view = m.f0().findViewById(c.a.p0.a.f.ai_apps_fragment_base_view);
        } else if (m instanceof c.a.p0.a.h0.g.k) {
            if (((c.a.p0.a.h0.g.k) m).l() == null || m.f0() == null) {
                return;
            }
            view = m.f0().findViewById(c.a.p0.a.f.swan_app_webview_fragment);
        }
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new b(this, view, m));
    }

    public final c F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.S == null) {
                this.S = new c(t().getContext(), t());
            }
            return this.S;
        }
        return (c) invokeV.objValue;
    }

    public final d G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.R == null) {
                d dVar = new d(t().getContext(), t());
                this.R = dVar;
                dVar.b(new a(this));
            }
            return this.R;
        }
        return (d) invokeV.objValue;
    }

    public final e H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.Q == null) {
                this.Q = new e(t().getContext(), t());
            }
            return this.Q;
        }
        return (e) invokeV.objValue;
    }

    public int I1() {
        InterceptResult invokeV;
        EfficientProgressBar efficientProgressBar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            e eVar = this.Q;
            if (eVar == null || (efficientProgressBar = eVar.f45940a) == null) {
                return 0;
            }
            return efficientProgressBar.getHeight();
        }
        return invokeV.intValue;
    }

    public final void J1() {
        c.a.p0.a.h0.h.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (cVar = this.U) == null) {
            return;
        }
        cVar.a();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    public void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public final void K1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Q0("document.querySelector('video').pause();");
        }
    }

    public final void L1(View view, c.a.p0.a.h0.g.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view, dVar) == null) || dVar == null || dVar.o0()) {
            return;
        }
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int i2 = rect.bottom - rect.top;
        int i3 = this.V;
        if (i2 == i3) {
            return;
        }
        if (i3 - i2 > this.a0) {
            int i4 = 0;
            if (dVar instanceof c.a.p0.a.h0.g.f) {
                c.a.p0.a.h0.g.f fVar = (c.a.p0.a.h0.g.f) dVar;
                if (fVar.X1() && fVar.o3()) {
                    i4 = view.getResources().getDimensionPixelSize(c.a.p0.a.d.aiapps_bottom_tab_height);
                }
            }
            view.getLayoutParams().height = i4 + i2;
        } else {
            view.getLayoutParams().height = -1;
        }
        view.requestLayout();
        this.V = i2;
    }

    public void M1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.Z = z;
        }
    }

    public void N1(SwanAppSlaveManager swanAppSlaveManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, swanAppSlaveManager) == null) {
            this.Y = swanAppSlaveManager;
        }
    }

    public void O1(@Nullable c.a.p0.a.c2.f.r0.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
            this.T = dVar;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void P0(SwanAppWebViewManager swanAppWebViewManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, swanAppWebViewManager) == null) {
            super.P0(swanAppWebViewManager);
        }
    }

    public final void P1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f45875f.getSettings().setLoadWithOverviewMode(true);
            this.f45875f.getSettings().setUseWideViewPort(true);
            this.f45875f.getSettings().setSupportZoom(true);
            this.f45875f.getSettings().setBuiltInZoomControls(true);
            this.f45875f.getSettings().setDisplayZoomControls(false);
        }
    }

    public boolean Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.Z : invokeV.booleanValue;
    }

    public final void R1(Context context) {
        c.a.p0.a.p.d.b a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, context) == null) || (a2 = c.a.p0.a.a2.d.g().y().a().a()) == null) {
            return;
        }
        a2.a(context);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    public void T0(SwanAppWebViewManager.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, eVar) == null) {
            super.T0(eVar);
            eVar.f45908a = false;
        }
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    public void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.U0();
            c.a.p0.a.c2.f.r0.f fVar = new c.a.p0.a.c2.f.r0.f(this.l);
            fVar.j(this);
            this.l.b(fVar);
        }
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, c.a.p0.a.p.e.b
    public void Y(c.a.p0.a.h0.j.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, dVar) == null) {
            this.W = dVar;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, c.a.p0.a.p.e.d
    public String b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? "ai_apps_widget" : (String) invokeV.objValue;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, c.a.p0.a.p.e.d
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            this.W = null;
            super.destroy();
        }
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, c.a.p0.a.p.e.d
    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.e0();
        }
    }

    @Override // c.a.p0.a.p.e.e
    @Nullable
    public c.a.p0.a.c2.f.r0.d getParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.T : (c.a.p0.a.c2.f.r0.d) invokeV.objValue;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, c.a.p0.a.p.e.d, c.a.p0.a.h0.l.a
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            if (Q1() && !c.a.p0.a.b2.a.b.h(str)) {
                F1().b(str);
            } else {
                super.loadUrl(str);
            }
        }
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, c.a.p0.a.p.e.d
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onPause();
            K1();
        }
    }
}
