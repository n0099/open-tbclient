package com.baidu.swan.apps.core.slave;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.d2.n;
import c.a.n0.a.f1.q.a;
import c.a.n0.a.k1.h;
import c.a.n0.a.k1.i;
import c.a.n0.a.p2.o0;
import c.a.n0.a.p2.q;
import c.a.n0.a.p2.q0;
import c.a.n0.a.x.g.l;
import c.a.n0.a.x.h.e;
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
import com.baidu.tieba.R;
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
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SwanAppWebViewWidget extends SwanAppSlaveManager implements c.a.n0.a.f.e.e<NgWebView> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean Z;
    public static final String[] g0;
    public transient /* synthetic */ FieldHolder $fh;
    public g N;
    public f O;
    public e P;
    @Nullable
    public c.a.n0.a.v1.f.q0.d Q;
    public c.a.n0.a.x.h.e R;
    public int S;
    public int T;
    public c.a.n0.a.x.j.d U;
    public String V;
    public SwanAppSlaveManager W;
    public boolean X;
    public boolean Y;

    /* loaded from: classes4.dex */
    public class SwanAppWebChromeClient extends BdSailorWebChromeClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppWebViewWidget this$0;

        /* loaded from: classes4.dex */
        public class a implements e.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(SwanAppWebChromeClient swanAppWebChromeClient) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {swanAppWebChromeClient};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.n0.a.x.h.e.b
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                this.this$0.Q1();
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
                this.this$0.V = str;
                c.a.n0.a.x.j.d dVar = this.this$0.U;
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
        public boolean onShowCustomView(BdSailorWebView bdSailorWebView, View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
            InterceptResult invokeLLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(Constants.METHOD_SEND_USER_MSG, this, bdSailorWebView, view, i, customViewCallback)) == null) {
                if (this.this$0.R == null) {
                    this.this$0.R = new c.a.n0.a.x.h.e(this.this$0.a.getBaseContext());
                }
                this.this$0.R.c(view, i, new a(this));
                return true;
            }
            return invokeLLIL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class SwanAppWebViewWidgetClientExt extends BdSailorWebViewClientExt {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppWebViewWidget this$0;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ HybridUbcFlow f28858b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ SwanAppWebViewWidgetClientExt f28859c;

            public a(SwanAppWebViewWidgetClientExt swanAppWebViewWidgetClientExt, long j, HybridUbcFlow hybridUbcFlow) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {swanAppWebViewWidgetClientExt, Long.valueOf(j), hybridUbcFlow};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f28859c = swanAppWebViewWidgetClientExt;
                this.a = j;
                this.f28858b = hybridUbcFlow;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f28859c.this$0.H.f4339c <= 0) {
                        j = this.a;
                    } else {
                        j = this.f28859c.this$0.H.f4339c;
                    }
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(j);
                    this.f28858b.D("fmp_type", this.f28859c.this$0.H.f4343g);
                    SwanAppWebViewWidget swanAppWebViewWidget = this.f28859c.this$0;
                    swanAppWebViewWidget.L.f(swanAppWebViewWidget.H.f4343g, true);
                    this.f28859c.this$0.L.d(ubcFlowEvent, false);
                    HybridUbcFlow hybridUbcFlow = this.f28858b;
                    hybridUbcFlow.F(ubcFlowEvent);
                    hybridUbcFlow.S();
                    if (SwanAppWebViewWidget.Z) {
                        Log.d("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + this.f28859c.this$0.H.f4343g + " , fmpTypeName=" + this.f28859c.this$0.H.a());
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                c.a.n0.a.u.d.k("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstContentfulPaintExt");
                super.onFirstContentfulPaintExt(bdSailorWebView, str);
                long currentTimeMillis = System.currentTimeMillis();
                if (SwanAppWebViewWidget.Z) {
                    Log.d("SwanAppWebViewWidget", "on fcp: real fcp = " + currentTimeMillis);
                }
                this.this$0.H.f4338b = currentTimeMillis;
                c.a.n0.a.k1.k.f.j().n().a(this.this$0.H.f4338b);
                long b2 = this.this$0.H.b();
                if (SwanAppWebViewWidget.Z) {
                    Log.d("SwanAppWebViewWidget", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime" + b2 + " , aligned search=false");
                }
                HybridUbcFlow p = h.p(NodeJS.STARTUP_SCRIPT_NAME);
                if (this.this$0.p1()) {
                    this.this$0.L.e(true);
                    p.b("fmp_data_record", this.this$0.L);
                }
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_paint");
                ubcFlowEvent.h(b2);
                p.F(ubcFlowEvent);
                if (this.this$0.W != null) {
                    this.this$0.W.I.a();
                }
                if (this.this$0.H.f4339c == 0) {
                    this.this$0.H.f4339c = b2;
                    c.a.n0.a.f.e.j.d dVar = this.this$0.H;
                    dVar.f4343g = dVar.c(b2);
                    p.D("fmp_type", "1");
                    UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent2.h(this.this$0.H.f4338b);
                    p.F(ubcFlowEvent2);
                    this.this$0.L.f("1", false);
                    this.this$0.L.d(ubcFlowEvent2, false);
                    return;
                }
                long G = c.a.n0.a.s0.a.g0().G();
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
                c.a.n0.a.u.d.k("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstImagePaintExt");
                super.onFirstImagePaintExt(bdSailorWebView, str);
                this.this$0.H.f4341e = System.currentTimeMillis();
                c.a.n0.a.k1.k.f.j().n().g(this.this$0.H.f4341e);
                if (SwanAppWebViewWidget.Z) {
                    Log.d("SwanAppWebViewWidget", "on fip: real fip = " + this.this$0.H.f4341e);
                }
                if (this.this$0.H.f4339c == 0) {
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(this.this$0.H.f4341e);
                    HybridUbcFlow p = h.p(NodeJS.STARTUP_SCRIPT_NAME);
                    p.D("fmp_type", "3");
                    p.F(ubcFlowEvent);
                    this.this$0.L.f("3", false);
                    this.this$0.L.d(ubcFlowEvent, false);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bdSailorWebView, str) == null) {
                super.onFirstLayoutDidExt(bdSailorWebView, str);
                if (TextUtils.isEmpty(this.this$0.G)) {
                    return;
                }
                h.q("route", this.this$0.G).F(new UbcFlowEvent("web_widget_first_layout"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, bdSailorWebView, str) == null) {
                super.onFirstPaintDidExt(bdSailorWebView, str);
                this.this$0.H.a = System.currentTimeMillis();
                if (TextUtils.isEmpty(this.this$0.G)) {
                    return;
                }
                h.q("route", this.this$0.G).F(new UbcFlowEvent("web_widget_first_paint"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, bdSailorWebView, str) == null) {
                c.a.n0.a.u.d.k("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstScreenPaintFinishedEx");
                super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
                this.this$0.H.f4339c = System.currentTimeMillis();
                this.this$0.H.f4343g = "0";
                c.a.n0.a.k1.k.f.j().n().e(this.this$0.H.f4339c);
                if (SwanAppWebViewWidget.Z) {
                    Log.d("SwanAppWebViewWidget", "on fmp: real fmp = " + this.this$0.H.f4339c);
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
                    ubcFlowEvent.h(this.this$0.H.f4339c);
                    ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE);
                    this.this$0.L.f("0", true);
                    this.this$0.L.d(ubcFlowEvent, true);
                    d2.F(ubcFlowEvent);
                    d2.S();
                    c.a.n0.a.f.e.j.d dVar = this.this$0.H;
                    c.a.n0.a.u.d.b("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(this.this$0.H.f4339c), " , fmpType=", dVar.f4343g, " , fmpTypeName=", dVar.a());
                    h.t();
                }
                if (!TextUtils.isEmpty(this.this$0.G)) {
                    i.f(this.this$0.G);
                    this.this$0.G = "";
                }
                if (this.this$0.W != null) {
                    this.this$0.W.I.g();
                    this.this$0.W.I.b();
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, bdSailorWebView, str) == null) {
                c.a.n0.a.u.d.k("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstTextPaintExt");
                super.onFirstTextPaintExt(bdSailorWebView, str);
                this.this$0.H.f4340d = System.currentTimeMillis();
                c.a.n0.a.k1.k.f.j().n().f(this.this$0.H.f4340d);
                if (SwanAppWebViewWidget.Z) {
                    Log.d("SwanAppWebViewWidget", "on ftp: real ftp = " + this.this$0.H.f4340d);
                }
                if (this.this$0.H.f4339c == 0) {
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(this.this$0.H.f4340d);
                    HybridUbcFlow p = h.p(NodeJS.STARTUP_SCRIPT_NAME);
                    p.D("fmp_type", "2");
                    p.F(ubcFlowEvent);
                    this.this$0.L.f("2", false);
                    this.this$0.L.d(ubcFlowEvent, false);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bdSailorWebView, str)) == null) {
                if (c.a.n0.a.s0.a.g0().x() && this.this$0.Y1() && c.a.n0.a.u1.a.b.k()) {
                    return false;
                }
                if (c.a.n0.a.s0.a.g0().x() && this.this$0.X1() && !c.a.n0.a.u1.a.b.h(str)) {
                    if (SwanAppWebViewWidget.Z) {
                        Log.d("SwanAppWebViewWidget", "WebSafeCheckers.checkWebDomain() failed url: " + str);
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

    /* loaded from: classes4.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                c.a.n0.a.u.d.b("SwanAppWebViewWidget", "onPageFinished, url: " + str);
                if (this.this$0.Y1() && c.a.n0.a.u1.a.b.k()) {
                    this.this$0.O1().c(str);
                } else {
                    this.this$0.O1().b();
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageStarted(BdSailorWebView bdSailorWebView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, bdSailorWebView, str, bitmap) == null) {
                c.a.n0.a.u.d.b("SwanAppWebViewWidget", "onPageStarted, url: " + str);
                if (this.this$0.Y1() && c.a.n0.a.u1.a.b.k()) {
                    this.this$0.O1().f(str);
                } else {
                    this.this$0.O1().d();
                }
                this.this$0.K1();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048579, this, bdSailorWebView, i, str, str2) == null) {
                super.onReceivedError(bdSailorWebView, i, str, str2);
                if (i == -10) {
                    return;
                }
                this.this$0.N1().c();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedHttpError(BdSailorWebView bdSailorWebView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048580, this, bdSailorWebView, webResourceRequest, webResourceResponse) == null) {
                super.onReceivedHttpError(bdSailorWebView, webResourceRequest, webResourceResponse);
                c.a.n0.a.x.j.d dVar = this.this$0.U;
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
                if (SwanAppWebViewWidget.Z) {
                    Log.d("SwanAppWebViewWidget", "shouldOverrideUrlLoading url: " + str);
                }
                Uri A = q0.A(str);
                if (A != null) {
                    c.a.n0.a.p2.f.g(this.this$0.a, new Intent("android.intent.action.DIAL", A));
                    return true;
                }
                c.a.n0.a.x.j.d dVar = this.this$0.F;
                if (dVar != null) {
                    return dVar.c(str);
                }
                if (!c.a.n0.a.n1.a.a.A()) {
                    if (SwanAppWebViewWidget.Z) {
                        Log.w("SwanAppWebViewWidget", "checkWebHost: Debug下鉴权未开启");
                    }
                    return false;
                } else if (this.this$0.L1(str)) {
                    return true;
                } else {
                    if (!this.this$0.X1() || c.a.n0.a.u1.a.b.h(str)) {
                        return false;
                    }
                    this.this$0.Z1(str);
                    return true;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class a implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwanAppWebViewWidget f28860b;

        /* renamed from: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1817a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC1817a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.f28860b.u().loadUrl(this.a.a);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.a;
                    aVar.f28860b.Z1(aVar.a);
                    this.a.f28860b.O1().c("none");
                }
            }
        }

        /* loaded from: classes4.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public c(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.a;
                    aVar.f28860b.Z1(aVar.a);
                    this.a.f28860b.O1().c("none");
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28860b = swanAppWebViewWidget;
            this.a = str;
        }

        @Override // c.a.n0.a.f1.q.a.b
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                c.a.n0.a.u.d.b("SwanAppWebViewWidget", "isblockdomain request success, response data: " + jSONObject + ", url: " + this.a);
                if (jSONObject != null && jSONObject.optInt("result", -1) == 0) {
                    q0.a0(new RunnableC1817a(this));
                    return;
                }
                c.a.n0.a.u.d.o("SwanAppWebViewWidget", "isblockdomain request success, but check result failed: " + jSONObject + ", url: " + this.a);
                q0.a0(new b(this));
            }
        }

        @Override // c.a.n0.a.f1.q.a.b
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                c.a.n0.a.u.d.o("SwanAppWebViewWidget", "isblockdomain request failed, msg: " + str + ", url: " + this.a);
                q0.a0(new c(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppWebViewWidget a;

        public b(SwanAppWebViewWidget swanAppWebViewWidget) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppWebViewWidget};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppWebViewWidget;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && SwanAppNetworkUtils.i(this.a.u().getContext())) {
                if (!this.a.X1() || c.a.n0.a.u1.a.b.h(this.a.u().getUrl())) {
                    this.a.u().reload();
                    this.a.O.a();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements c.a.n0.a.x.f.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppWebViewWidget a;

        public c(SwanAppWebViewWidget swanAppWebViewWidget) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppWebViewWidget};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppWebViewWidget;
        }

        @Override // c.a.n0.a.x.f.c
        public boolean q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.a.M1().a();
                this.a.u().setOnWebViewHookHandler(this.a);
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.n0.a.x.f.c
        public boolean w(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? z : invokeZ.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.n0.a.x.g.d f28861b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SwanAppWebViewWidget f28862c;

        public d(SwanAppWebViewWidget swanAppWebViewWidget, View view, c.a.n0.a.x.g.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppWebViewWidget, view, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f28862c = swanAppWebViewWidget;
            this.a = view;
            this.f28861b = dVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (SwanAppWebViewWidget.Z) {
                    Log.d("SwanAppWebViewWidget", "onGlobalLayout");
                }
                this.f28862c.S1(this.a, this.f28861b);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                this.a.b(str);
                this.a.setVisibility(0);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

    /* loaded from: classes4.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public EfficientProgressBar a;

        /* renamed from: b  reason: collision with root package name */
        public String f28863b;

        public g(@NonNull Context context, @NonNull ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            EfficientProgressBar efficientProgressBar = new EfficientProgressBar(context);
            this.a = efficientProgressBar;
            efficientProgressBar.setProgressDrawable(context.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0801b3));
            this.a.setId(R.id.obfuscated_res_0x7f0901a2);
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
                int indexOf2 = this.f28863b.indexOf("#");
                if (str.equals(indexOf2 == -1 ? this.f28863b : this.f28863b.substring(0, indexOf2))) {
                    b();
                }
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.f();
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
                    this.f28863b = "none";
                } else {
                    this.f28863b = str;
                }
            }
        }

        public void g(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
                this.a.setProgress(i, true);
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
        Z = c.a.n0.a.a.a;
        g0 = new String[]{"http", "https"};
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.T = 0;
        this.X = true;
        this.Y = true;
        b1(new WebViewWidgetClient(this));
        a1(new SwanAppWebChromeClient(this, null));
        c1(new SwanAppWebViewWidgetClientExt(this, null));
        VideoPlayerFactory b2 = c.a.n0.a.s0.a.g().b();
        if (b2 != null) {
            this.f28827b.getCurrentWebView().setVideoPlayerFactory(b2);
        }
        W1();
        a2(context);
        u().setOnWebViewHookHandler(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            SwanAppSlaveManager swanAppSlaveManager = this.W;
            return (swanAppSlaveManager == null || swanAppSlaveManager.I.f7455c) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void K1() {
        c.a.n0.a.x.g.g V;
        c.a.n0.a.x.g.d m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (V = c.a.n0.a.w0.f.U().V()) == null || (m = V.m()) == null || m.Q() == null) {
            return;
        }
        View view = null;
        if (m instanceof c.a.n0.a.x.g.f) {
            if (((c.a.n0.a.x.g.f) m).m3().m() == null) {
                return;
            }
            view = m.Q().findViewById(R.id.obfuscated_res_0x7f090179);
        } else if (m instanceof l) {
            if (((l) m).m() == null || m.Q() == null) {
                return;
            }
            view = m.Q().findViewById(R.id.obfuscated_res_0x7f091df4);
        }
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new d(this, view, m));
    }

    public final boolean L1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (Y1() && c.a.n0.a.u1.a.b.k()) {
                if (c.a.n0.a.u1.a.b.j(str)) {
                    q0.W(this.a, str);
                    return true;
                } else if (TextUtils.isEmpty(str) || str.startsWith("http")) {
                    c.a.n0.a.f1.q.a aVar = new c.a.n0.a.f1.q.a();
                    aVar.g(str);
                    O1().e("none");
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

    public final e M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.P == null) {
                this.P = new e(u().getContext(), u());
            }
            return this.P;
        }
        return (e) invokeV.objValue;
    }

    public final f N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.O == null) {
                f fVar = new f(u().getContext(), u());
                this.O = fVar;
                fVar.b(new b(this));
            }
            return this.O;
        }
        return (f) invokeV.objValue;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    public void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public g O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.N == null) {
                this.N = new g(u().getContext(), u());
            }
            return this.N;
        }
        return (g) invokeV.objValue;
    }

    public int P1() {
        InterceptResult invokeV;
        EfficientProgressBar efficientProgressBar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            g gVar = this.N;
            if (gVar == null || (efficientProgressBar = gVar.a) == null) {
                return 0;
            }
            return efficientProgressBar.getHeight();
        }
        return invokeV.intValue;
    }

    public final void Q1() {
        c.a.n0.a.x.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (eVar = this.R) == null) {
            return;
        }
        eVar.a();
    }

    public final void R1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            U0("document.querySelector('video').pause();");
        }
    }

    public final void S1(View view, c.a.n0.a.x.g.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, view, dVar) == null) || dVar == null || dVar.h0()) {
            return;
        }
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int i = rect.bottom - rect.top;
        int i2 = this.S;
        if (i == i2) {
            return;
        }
        if (i2 - i > 200) {
            int i3 = 0;
            if (dVar instanceof c.a.n0.a.x.g.f) {
                c.a.n0.a.x.g.f fVar = (c.a.n0.a.x.g.f) dVar;
                if (fVar.c2() && fVar.B3()) {
                    i3 = view.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700fc);
                }
            }
            view.getLayoutParams().height = i3 + i + this.T;
        } else {
            view.getLayoutParams().height = -1;
        }
        view.requestLayout();
        this.S = i;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void T0(SwanAppWebViewManager swanAppWebViewManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, swanAppWebViewManager) == null) {
            super.T0(swanAppWebViewManager);
        }
    }

    public void T1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.X = z;
        }
    }

    public void U1(SwanAppSlaveManager swanAppSlaveManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, swanAppSlaveManager) == null) {
            this.W = swanAppSlaveManager;
        }
    }

    public void V1(@Nullable c.a.n0.a.v1.f.q0.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) {
            this.Q = dVar;
        }
    }

    public final void W1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f28827b.getSettings().setLoadWithOverviewMode(true);
            this.f28827b.getSettings().setUseWideViewPort(true);
            this.f28827b.getSettings().setSupportZoom(true);
            this.f28827b.getSettings().setBuiltInZoomControls(true);
            this.f28827b.getSettings().setDisplayZoomControls(false);
        }
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    public void X0(SwanAppWebViewManager.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, dVar) == null) {
            super.X0(dVar);
            dVar.a = false;
        }
    }

    public boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.X : invokeV.booleanValue;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    public void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.Y0();
            c.a.n0.a.v1.f.q0.f fVar = new c.a.n0.a.v1.f.q0.f(this.f28833h);
            fVar.j(this);
            this.f28833h.b(fVar);
        }
    }

    public boolean Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.Y : invokeV.booleanValue;
    }

    public final void Z1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            URL url = new URL(str);
            for (String str2 : g0) {
                if (TextUtils.equals(url.getProtocol(), str2)) {
                    M1().b(str);
                    u().setOnWebViewHookHandler(new c(this));
                    return;
                }
            }
        } catch (MalformedURLException e2) {
            if (Z) {
                e2.printStackTrace();
            }
        }
    }

    public final void a2(Context context) {
        c.a.n0.a.f.d.c a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, context) == null) || (a2 = c.a.n0.a.t1.d.J().y().a().a()) == null) {
            return;
        }
        a2.a(context);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, c.a.n0.a.f.e.b
    public void c0(c.a.n0.a.x.j.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, dVar) == null) {
            this.U = dVar;
        }
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, c.a.n0.a.f.e.d
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.U = null;
            super.destroy();
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, c.a.n0.a.f.e.d
    public String e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? "ai_apps_widget" : (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.f.e.e
    @Nullable
    public c.a.n0.a.v1.f.q0.d getParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.Q : (c.a.n0.a.v1.f.q0.d) invokeV.objValue;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, c.a.n0.a.f.e.d
    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.h0();
        }
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, c.a.n0.a.f.e.d, c.a.n0.a.x.l.a
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            if (!c.a.n0.a.n1.a.a.A()) {
                if (Z) {
                    Log.w("SwanAppWebViewWidget", "checkWebHost: Debug下鉴权未开启");
                }
                e eVar = this.P;
                if (eVar != null) {
                    eVar.a();
                }
                super.loadUrl(str);
            } else if (L1(str)) {
            } else {
                if (X1() && !c.a.n0.a.u1.a.b.h(str)) {
                    M1().b(str);
                    return;
                }
                e eVar2 = this.P;
                if (eVar2 != null) {
                    eVar2.a();
                }
                super.loadUrl(str);
            }
        }
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, c.a.n0.a.f.e.d
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onPause();
            R1();
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, c.a.n0.a.x.f.c
    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            O1().b();
            return false;
        }
        return invokeV.booleanValue;
    }
}
