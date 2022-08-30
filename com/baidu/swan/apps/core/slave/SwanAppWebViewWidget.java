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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.a02;
import com.baidu.tieba.a53;
import com.baidu.tieba.ay1;
import com.baidu.tieba.fu2;
import com.baidu.tieba.g02;
import com.baidu.tieba.gu2;
import com.baidu.tieba.hk2;
import com.baidu.tieba.i02;
import com.baidu.tieba.j02;
import com.baidu.tieba.jd3;
import com.baidu.tieba.jn1;
import com.baidu.tieba.kh1;
import com.baidu.tieba.mk1;
import com.baidu.tieba.nm2;
import com.baidu.tieba.nu2;
import com.baidu.tieba.o02;
import com.baidu.tieba.o22;
import com.baidu.tieba.r13;
import com.baidu.tieba.rn1;
import com.baidu.tieba.se3;
import com.baidu.tieba.t73;
import com.baidu.tieba.ud3;
import com.baidu.tieba.ue3;
import com.baidu.tieba.vs2;
import com.baidu.tieba.w02;
import com.baidu.tieba.y43;
import com.baidu.tieba.z03;
import com.baidu.tieba.zw2;
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
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SwanAppWebViewWidget extends SwanAppSlaveManager implements jn1<NgWebView> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean Z;
    public static final String[] a0;
    public transient /* synthetic */ FieldHolder $fh;
    public g N;
    public f O;
    public e P;
    @Nullable
    public y43 Q;
    public w02 R;
    public int S;
    public int T;
    public o22 U;
    public String V;
    public SwanAppSlaveManager W;
    public boolean X;
    public boolean Y;

    /* loaded from: classes2.dex */
    public class SwanAppWebChromeClient extends BdSailorWebChromeClient {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppWebViewWidget this$0;

        /* loaded from: classes2.dex */
        public class a implements w02.b {
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

            @Override // com.baidu.tieba.w02.b
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
                this.this$0.N1();
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedTitle(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdSailorWebView, str) == null) {
                super.onReceivedTitle(bdSailorWebView, str);
                if (se3.r(str)) {
                    return;
                }
                this.this$0.V = str;
                o22 o22Var = this.this$0.U;
                if (o22Var != null) {
                    o22Var.d(str);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onShowCustomView(BdSailorWebView bdSailorWebView, View view2, WebChromeClient.CustomViewCallback customViewCallback) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, bdSailorWebView, view2, customViewCallback)) == null) ? onShowCustomView(bdSailorWebView, view2, 0, customViewCallback) : invokeLLL.booleanValue;
        }

        public /* synthetic */ SwanAppWebChromeClient(SwanAppWebViewWidget swanAppWebViewWidget, a aVar) {
            this(swanAppWebViewWidget);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onShowCustomView(BdSailorWebView bdSailorWebView, View view2, int i, WebChromeClient.CustomViewCallback customViewCallback) {
            InterceptResult invokeLLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(Constants.METHOD_SEND_USER_MSG, this, bdSailorWebView, view2, i, customViewCallback)) == null) {
                if (this.this$0.R == null) {
                    this.this$0.R = new w02(this.this$0.a.getBaseContext());
                }
                this.this$0.R.c(view2, i, new a(this));
                return true;
            }
            return invokeLLIL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class SwanAppWebViewWidgetClientExt extends BdSailorWebViewClientExt {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppWebViewWidget this$0;

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;
            public final /* synthetic */ HybridUbcFlow b;
            public final /* synthetic */ SwanAppWebViewWidgetClientExt c;

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
                this.c = swanAppWebViewWidgetClientExt;
                this.a = j;
                this.b = hybridUbcFlow;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.c.this$0.H.c <= 0) {
                        j = this.a;
                    } else {
                        j = this.c.this$0.H.c;
                    }
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(j);
                    this.b.D("fmp_type", this.c.this$0.H.g);
                    SwanAppWebViewWidget swanAppWebViewWidget = this.c.this$0;
                    swanAppWebViewWidget.L.f(swanAppWebViewWidget.H.g, true);
                    this.c.this$0.L.d(ubcFlowEvent, false);
                    HybridUbcFlow hybridUbcFlow = this.b;
                    hybridUbcFlow.F(ubcFlowEvent);
                    hybridUbcFlow.S();
                    if (SwanAppWebViewWidget.Z) {
                        Log.d("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + this.c.this$0.H.g + " , fmpTypeName=" + this.c.this$0.H.a());
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
                ay1.k("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstContentfulPaintExt");
                super.onFirstContentfulPaintExt(bdSailorWebView, str);
                long currentTimeMillis = System.currentTimeMillis();
                if (SwanAppWebViewWidget.Z) {
                    Log.d("SwanAppWebViewWidget", "on fcp: real fcp = " + currentTimeMillis);
                }
                this.this$0.H.b = currentTimeMillis;
                nu2.h().l().a(this.this$0.H.b);
                long b = this.this$0.H.b();
                if (SwanAppWebViewWidget.Z) {
                    Log.d("SwanAppWebViewWidget", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime" + b + " , aligned search=false");
                }
                HybridUbcFlow p = fu2.p("startup");
                if (this.this$0.m1()) {
                    this.this$0.L.e(true);
                    p.b("fmp_data_record", this.this$0.L);
                }
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_paint");
                ubcFlowEvent.h(b);
                p.F(ubcFlowEvent);
                if (this.this$0.W != null) {
                    this.this$0.W.I.a();
                }
                if (this.this$0.H.c == 0) {
                    this.this$0.H.c = b;
                    rn1 rn1Var = this.this$0.H;
                    rn1Var.g = rn1Var.c(b);
                    p.D("fmp_type", "1");
                    UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent2.h(this.this$0.H.b);
                    p.F(ubcFlowEvent2);
                    this.this$0.L.f("1", false);
                    this.this$0.L.d(ubcFlowEvent2, false);
                    return;
                }
                long G = hk2.g0().G();
                if (G < 0) {
                    G = 3000;
                }
                ud3.c(new a(this, b, p), "fmp record", G, TimeUnit.MILLISECONDS);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdSailorWebView, str) == null) {
                ay1.k("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstImagePaintExt");
                super.onFirstImagePaintExt(bdSailorWebView, str);
                this.this$0.H.e = System.currentTimeMillis();
                nu2.h().l().e(this.this$0.H.e);
                if (SwanAppWebViewWidget.Z) {
                    Log.d("SwanAppWebViewWidget", "on fip: real fip = " + this.this$0.H.e);
                }
                if (this.this$0.H.c == 0) {
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(this.this$0.H.e);
                    HybridUbcFlow p = fu2.p("startup");
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
                fu2.q("route", this.this$0.G).F(new UbcFlowEvent("web_widget_first_layout"));
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
                fu2.q("route", this.this$0.G).F(new UbcFlowEvent("web_widget_first_paint"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, bdSailorWebView, str) == null) {
                ay1.k("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstScreenPaintFinishedEx");
                super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
                this.this$0.H.c = System.currentTimeMillis();
                this.this$0.H.g = "0";
                nu2.h().l().c(this.this$0.H.c);
                if (SwanAppWebViewWidget.Z) {
                    Log.d("SwanAppWebViewWidget", "on fmp: real fmp = " + this.this$0.H.c);
                }
                HybridUbcFlow d = fu2.d("startup");
                if (d != null) {
                    if (TextUtils.isEmpty(str)) {
                        str = "0";
                    }
                    d.D("webviewComponent", str);
                    d.D("fmp_type", "0");
                    d.E("value", "arrive_success");
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(this.this$0.H.c);
                    ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE);
                    this.this$0.L.f("0", true);
                    this.this$0.L.d(ubcFlowEvent, true);
                    d.F(ubcFlowEvent);
                    d.S();
                    rn1 rn1Var = this.this$0.H;
                    ay1.b("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(this.this$0.H.c), " , fmpType=", rn1Var.g, " , fmpTypeName=", rn1Var.a());
                    fu2.t();
                }
                if (!TextUtils.isEmpty(this.this$0.G)) {
                    gu2.f(this.this$0.G);
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
                ay1.k("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstTextPaintExt");
                super.onFirstTextPaintExt(bdSailorWebView, str);
                this.this$0.H.d = System.currentTimeMillis();
                nu2.h().l().d(this.this$0.H.d);
                if (SwanAppWebViewWidget.Z) {
                    Log.d("SwanAppWebViewWidget", "on ftp: real ftp = " + this.this$0.H.d);
                }
                if (this.this$0.H.c == 0) {
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(this.this$0.H.d);
                    HybridUbcFlow p = fu2.p("startup");
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
                if (hk2.g0().x() && this.this$0.V1() && r13.k()) {
                    return false;
                }
                if (hk2.g0().x() && this.this$0.U1() && !r13.h(str)) {
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

    /* loaded from: classes2.dex */
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
                t73.W(str, bdSailorWebView.getSettings().getUserAgentString());
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdSailorWebView, str) == null) {
                ay1.b("SwanAppWebViewWidget", "onPageFinished, url: " + str);
                if (this.this$0.V1() && r13.k()) {
                    this.this$0.L1().c(str);
                } else {
                    this.this$0.L1().b();
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageStarted(BdSailorWebView bdSailorWebView, String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, bdSailorWebView, str, bitmap) == null) {
                ay1.b("SwanAppWebViewWidget", "onPageStarted, url: " + str);
                if (this.this$0.V1() && r13.k()) {
                    this.this$0.L1().f(str);
                } else {
                    this.this$0.L1().d();
                }
                this.this$0.H1();
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
                this.this$0.K1().c();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedHttpError(BdSailorWebView bdSailorWebView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048580, this, bdSailorWebView, webResourceRequest, webResourceResponse) == null) {
                super.onReceivedHttpError(bdSailorWebView, webResourceRequest, webResourceResponse);
                o22 o22Var = this.this$0.U;
                if (o22Var != null) {
                    o22Var.a(webResourceResponse != null ? webResourceResponse.getStatusCode() : 0);
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
                Uri A = ue3.A(str);
                if (A != null) {
                    jd3.g(this.this$0.a, new Intent("android.intent.action.DIAL", A));
                    return true;
                }
                o22 o22Var = this.this$0.F;
                if (o22Var != null) {
                    return o22Var.b(str);
                }
                if (!zw2.A()) {
                    if (SwanAppWebViewWidget.Z) {
                        Log.w("SwanAppWebViewWidget", "checkWebHost: Debug下鉴权未开启");
                    }
                    return false;
                } else if (this.this$0.I1(str)) {
                    return true;
                } else {
                    if (!this.this$0.U1() || r13.h(str)) {
                        return false;
                    }
                    this.this$0.W1(str);
                    return true;
                }
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class a implements vs2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ SwanAppWebViewWidget b;

        /* renamed from: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0177a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0177a(a aVar) {
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
                    this.a.b.r().loadUrl(this.a.a);
                }
            }
        }

        /* loaded from: classes2.dex */
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
                    aVar.b.W1(aVar.a);
                    this.a.b.L1().c("none");
                }
            }
        }

        /* loaded from: classes2.dex */
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
                    aVar.b.W1(aVar.a);
                    this.a.b.L1().c("none");
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
            this.b = swanAppWebViewWidget;
            this.a = str;
        }

        @Override // com.baidu.tieba.vs2.b
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                ay1.b("SwanAppWebViewWidget", "isblockdomain request success, response data: " + jSONObject + ", url: " + this.a);
                if (jSONObject != null && jSONObject.optInt(TiebaStatic.LogFields.RESULT, -1) == 0) {
                    ue3.a0(new RunnableC0177a(this));
                    return;
                }
                ay1.o("SwanAppWebViewWidget", "isblockdomain request success, but check result failed: " + jSONObject + ", url: " + this.a);
                ue3.a0(new b(this));
            }
        }

        @Override // com.baidu.tieba.vs2.b
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                ay1.o("SwanAppWebViewWidget", "isblockdomain request failed, msg: " + str + ", url: " + this.a);
                ue3.a0(new c(this));
            }
        }
    }

    /* loaded from: classes2.dex */
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && SwanAppNetworkUtils.i(this.a.r().getContext())) {
                if (!this.a.U1() || r13.h(this.a.r().getUrl())) {
                    this.a.r().reload();
                    this.a.O.a();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements a02 {
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

        @Override // com.baidu.tieba.a02
        public boolean n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.a.J1().a();
                this.a.r().setOnWebViewHookHandler(this.a);
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.a02
        public boolean t(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? z : invokeZ.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ g02 b;
        public final /* synthetic */ SwanAppWebViewWidget c;

        public d(SwanAppWebViewWidget swanAppWebViewWidget, View view2, g02 g02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppWebViewWidget, view2, g02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = swanAppWebViewWidget;
            this.a = view2;
            this.b = g02Var;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (SwanAppWebViewWidget.Z) {
                    Log.d("SwanAppWebViewWidget", "onGlobalLayout");
                }
                this.c.P1(this.a, this.b);
            }
        }
    }

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public static class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public EfficientProgressBar a;
        public String b;

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
            efficientProgressBar.setProgressDrawable(context.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0801b2));
            this.a.setId(R.id.obfuscated_res_0x7f0901a4);
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
                int indexOf2 = this.b.indexOf("#");
                if (str.equals(indexOf2 == -1 ? this.b : this.b.substring(0, indexOf2))) {
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
                    this.b = "none";
                } else {
                    this.b = str;
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
        Z = kh1.a;
        a0 = new String[]{"http", "https"};
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
        Y0(new WebViewWidgetClient(this));
        X0(new SwanAppWebChromeClient(this, null));
        Z0(new SwanAppWebViewWidgetClientExt(this, null));
        VideoPlayerFactory b2 = hk2.g().b();
        if (b2 != null) {
            this.b.getCurrentWebView().setVideoPlayerFactory(b2);
        }
        T1();
        X1(context);
        r().setOnWebViewHookHandler(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            SwanAppSlaveManager swanAppSlaveManager = this.W;
            return (swanAppSlaveManager == null || swanAppSlaveManager.I.c) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void H1() {
        j02 V;
        g02 m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (V = nm2.U().V()) == null || (m = V.m()) == null || m.V() == null) {
            return;
        }
        View view2 = null;
        if (m instanceof i02) {
            if (((i02) m).o3().j() == null) {
                return;
            }
            view2 = m.V().findViewById(R.id.obfuscated_res_0x7f09017b);
        } else if (m instanceof o02) {
            if (((o02) m).j() == null || m.V() == null) {
                return;
            }
            view2 = m.V().findViewById(R.id.obfuscated_res_0x7f091f76);
        }
        if (view2 == null) {
            return;
        }
        view2.getViewTreeObserver().addOnGlobalLayoutListener(new d(this, view2, m));
    }

    public final boolean I1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (V1() && r13.k()) {
                if (r13.j(str)) {
                    ue3.W(this.a, str);
                    return true;
                } else if (TextUtils.isEmpty(str) || str.startsWith("http")) {
                    vs2 vs2Var = new vs2();
                    vs2Var.g(str);
                    L1().e("none");
                    vs2Var.d(new a(this, str));
                    return true;
                } else {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final e J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.P == null) {
                this.P = new e(r().getContext(), r());
            }
            return this.P;
        }
        return (e) invokeV.objValue;
    }

    public final f K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.O == null) {
                f fVar = new f(r().getContext(), r());
                this.O = fVar;
                fVar.b(new b(this));
            }
            return this.O;
        }
        return (f) invokeV.objValue;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public g L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.N == null) {
                this.N = new g(r().getContext(), r());
            }
            return this.N;
        }
        return (g) invokeV.objValue;
    }

    public int M1() {
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

    public final void N1() {
        w02 w02Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (w02Var = this.R) == null) {
            return;
        }
        w02Var.a();
    }

    public final void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            R0("document.querySelector('video').pause();");
        }
    }

    public final void P1(View view2, g02 g02Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, view2, g02Var) == null) || g02Var == null || g02Var.l0()) {
            return;
        }
        Rect rect = new Rect();
        view2.getWindowVisibleDisplayFrame(rect);
        int i = rect.bottom - rect.top;
        int i2 = this.S;
        if (i == i2) {
            return;
        }
        if (i2 - i > 200) {
            int i3 = 0;
            if (g02Var instanceof i02) {
                i02 i02Var = (i02) g02Var;
                if (i02Var.e2() && i02Var.D3()) {
                    i3 = view2.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0700fa);
                }
            }
            view2.getLayoutParams().height = i3 + i + this.T;
        } else {
            view2.getLayoutParams().height = -1;
        }
        view2.requestLayout();
        this.S = i;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void Q0(SwanAppWebViewManager swanAppWebViewManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, swanAppWebViewManager) == null) {
            super.Q0(swanAppWebViewManager);
        }
    }

    public void Q1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.X = z;
        }
    }

    public void R1(SwanAppSlaveManager swanAppSlaveManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, swanAppSlaveManager) == null) {
            this.W = swanAppSlaveManager;
        }
    }

    public void S1(@Nullable y43 y43Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, y43Var) == null) {
            this.Q = y43Var;
        }
    }

    public final void T1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.b.getSettings().setLoadWithOverviewMode(true);
            this.b.getSettings().setUseWideViewPort(true);
            this.b.getSettings().setSupportZoom(true);
            this.b.getSettings().setBuiltInZoomControls(true);
            this.b.getSettings().setDisplayZoomControls(false);
        }
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    public void U0(SwanAppWebViewManager.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, dVar) == null) {
            super.U0(dVar);
            dVar.a = false;
        }
    }

    public boolean U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.X : invokeV.booleanValue;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    public void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.V0();
            a53 a53Var = new a53(this.h);
            a53Var.j(this);
            this.h.b(a53Var);
        }
    }

    public boolean V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.Y : invokeV.booleanValue;
    }

    public final void W1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            URL url = new URL(str);
            for (String str2 : a0) {
                if (TextUtils.equals(url.getProtocol(), str2)) {
                    J1().b(str);
                    r().setOnWebViewHookHandler(new c(this));
                    return;
                }
            }
        } catch (MalformedURLException e2) {
            if (Z) {
                e2.printStackTrace();
            }
        }
    }

    public final void X1(Context context) {
        mk1 a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, context) == null) || (a2 = z03.K().x().a().a()) == null) {
            return;
        }
        a2.a(context);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.tieba.gn1
    public void Y(o22 o22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, o22Var) == null) {
            this.U = o22Var;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.in1
    public String b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? "ai_apps_widget" : (String) invokeV.objValue;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.in1
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            this.U = null;
            super.destroy();
        }
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.in1
    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.e0();
        }
    }

    @Override // com.baidu.tieba.jn1
    @Nullable
    public y43 getParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.Q : (y43) invokeV.objValue;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.in1
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            if (!zw2.A()) {
                if (Z) {
                    Log.w("SwanAppWebViewWidget", "checkWebHost: Debug下鉴权未开启");
                }
                e eVar = this.P;
                if (eVar != null) {
                    eVar.a();
                }
                super.loadUrl(str);
            } else if (I1(str)) {
            } else {
                if (U1() && !r13.h(str)) {
                    J1().b(str);
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

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.a02
    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            L1().b();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.in1
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            super.onPause();
            O1();
        }
    }
}
