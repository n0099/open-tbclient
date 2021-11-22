package com.baidu.swan.apps.core.slave;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.d2.n.g;
import b.a.p0.a.h0.j.d;
import b.a.p0.a.h0.j.e;
import b.a.p0.a.k;
import b.a.p0.a.o0.d.c;
import b.a.p0.a.p.e.b;
import b.a.p0.a.u1.h;
import b.a.p0.a.u1.k.f;
import b.a.p0.a.z2.q;
import b.a.p0.a.z2.x;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.BdSailorWebViewClientExt;
import com.baidu.browser.sailor.util.BdZeusUtil;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.core.container.PullToRefreshNgWebView;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.res.ui.pullrefresh.NeutralHeaderLoadingLayout;
import com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.JsCodeCacheResult;
import com.baidu.webkit.sdk.WebViewClient;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class SwanAppSlaveManager extends SwanAppWebViewManager implements b<NgWebView> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean Q;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String B;
    public SwanAppWebViewWidget C;
    public PullToRefreshNgWebView D;
    public b.a.p0.a.a3.k.a E;
    @Nullable
    public b.a.p0.a.c0.e.a F;
    public e G;
    public FrameLayout H;
    public d I;
    public d J;
    public String K;
    public b.a.p0.a.p.e.j.d L;
    public b.a.p0.a.h0.t.b M;
    public boolean N;
    public boolean O;
    public b.a.p0.a.h0.t.h.a P;

    /* loaded from: classes7.dex */
    public class SwanAppSlaveWebviewClientExt extends BdSailorWebViewClientExt {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppSlaveManager this$0;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ long f44412e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ HybridUbcFlow f44413f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SwanAppSlaveWebviewClientExt f44414g;

            public a(SwanAppSlaveWebviewClientExt swanAppSlaveWebviewClientExt, long j, HybridUbcFlow hybridUbcFlow) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {swanAppSlaveWebviewClientExt, Long.valueOf(j), hybridUbcFlow};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f44414g = swanAppSlaveWebviewClientExt;
                this.f44412e = j;
                this.f44413f = hybridUbcFlow;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.f44414g.this$0.L.f7609c <= 0) {
                        j = this.f44412e;
                    } else {
                        j = this.f44414g.this$0.L.f7609c;
                    }
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(j);
                    SwanAppSlaveManager swanAppSlaveManager = this.f44414g.this$0;
                    swanAppSlaveManager.P.f(swanAppSlaveManager.L.f7613g, true);
                    this.f44414g.this$0.P.d(ubcFlowEvent, false);
                    this.f44413f.D("fmp_type", this.f44414g.this$0.L.f7613g);
                    HybridUbcFlow hybridUbcFlow = this.f44413f;
                    hybridUbcFlow.F(ubcFlowEvent);
                    hybridUbcFlow.C(this.f44414g.this$0);
                    if (SwanAppSlaveManager.Q) {
                        String str = "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + this.f44414g.this$0.L.f7613g + " , fmpTypeName=" + this.f44414g.this$0.L.a();
                    }
                }
            }
        }

        public SwanAppSlaveWebviewClientExt(SwanAppSlaveManager swanAppSlaveManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppSlaveManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = swanAppSlaveManager;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, bdSailorWebView, str) == null) {
                b.a.p0.a.e0.d.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstContentfulPaintExt");
                super.onFirstContentfulPaintExt(bdSailorWebView, str);
                long currentTimeMillis = System.currentTimeMillis();
                if (SwanAppSlaveManager.Q) {
                    String str2 = "on fcp: real fcp = " + currentTimeMillis;
                }
                this.this$0.L.f7608b = currentTimeMillis;
                f.j().n().a(this.this$0.L.f7608b);
                long b2 = this.this$0.L.b();
                if (SwanAppSlaveManager.Q) {
                    String str3 = "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime=" + b2 + " , aligned search=false";
                }
                HybridUbcFlow p = h.p("startup");
                if (this.this$0.o1()) {
                    this.this$0.P.e(true);
                    p.b("fmp_data_record", this.this$0.P);
                }
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_paint");
                ubcFlowEvent.h(b2);
                p.F(ubcFlowEvent);
                b.a.p0.a.u.f.a.d().f();
                this.this$0.M.a();
                if (this.this$0.L.f7609c == 0) {
                    this.this$0.L.f7609c = b2;
                    b.a.p0.a.p.e.j.d dVar = this.this$0.L;
                    dVar.f7613g = dVar.c(b2);
                    p.D("fmp_type", "1");
                    UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent2.h(this.this$0.L.f7608b);
                    p.F(ubcFlowEvent2);
                    this.this$0.P.f("1", false);
                    this.this$0.P.d(ubcFlowEvent2, false);
                    return;
                }
                long G = b.a.p0.a.c1.a.g0().G();
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
                b.a.p0.a.e0.d.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstImagePaintExt");
                super.onFirstImagePaintExt(bdSailorWebView, str);
                this.this$0.L.f7611e = System.currentTimeMillis();
                f.j().n().g(this.this$0.L.f7611e);
                if (SwanAppSlaveManager.Q) {
                    String str2 = "on fip: real fip = " + this.this$0.L.f7611e;
                }
                if (this.this$0.L.f7609c == 0) {
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(this.this$0.L.f7611e);
                    HybridUbcFlow p = h.p("startup");
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
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, bdSailorWebView, str) == null) {
                boolean unused = SwanAppSlaveManager.Q;
                super.onFirstPaintDidExt(bdSailorWebView, str);
                this.this$0.L.f7607a = System.currentTimeMillis();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, bdSailorWebView, str) == null) {
                b.a.p0.a.e0.d.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedExt");
                super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
                this.this$0.L.f7609c = System.currentTimeMillis();
                this.this$0.L.f7613g = "0";
                f.j().n().e(this.this$0.L.f7609c);
                if (SwanAppSlaveManager.Q) {
                    String str2 = "on fmp: real fmp = " + this.this$0.L.f7609c;
                }
                HybridUbcFlow d2 = h.d("startup");
                if (d2 != null) {
                    d2.D("webviewComponent", "1");
                    d2.D("fmp_type", "0");
                    d2.E("value", "arrive_success");
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(this.this$0.L.f7609c);
                    ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE);
                    this.this$0.P.f("0", true);
                    this.this$0.P.d(ubcFlowEvent, true);
                    d2.F(ubcFlowEvent);
                    d2.C(this.this$0);
                    b.a.p0.a.p.e.j.d dVar = this.this$0.L;
                    b.a.p0.a.e0.d.b("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(this.this$0.L.f7609c), " , fmpType=", dVar.f7613g, " , fmpTypeName=", dVar.a());
                    h.t();
                }
                b.a.p0.a.u.f.a.d().g();
                this.this$0.M.g();
                this.this$0.M.b();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, bdSailorWebView, str) == null) {
                b.a.p0.a.e0.d.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstTextPaintExt");
                super.onFirstTextPaintExt(bdSailorWebView, str);
                this.this$0.L.f7610d = System.currentTimeMillis();
                f.j().n().f(this.this$0.L.f7610d);
                if (SwanAppSlaveManager.Q) {
                    String str2 = "on ftp: real ftp = " + this.this$0.L.f7610d;
                }
                if (this.this$0.L.f7609c == 0) {
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(this.this$0.L.f7610d);
                    HybridUbcFlow p = h.p("startup");
                    p.D("fmp_type", "2");
                    p.F(ubcFlowEvent);
                    this.this$0.P.f("2", false);
                    this.this$0.P.d(ubcFlowEvent, false);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFullScreenModeExt(BdSailorWebView bdSailorWebView, boolean z, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{bdSailorWebView, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
                boolean unused = SwanAppSlaveManager.Q;
                super.onFullScreenModeExt(bdSailorWebView, z, i2, i3);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public String onGetErrorHtmlExt(BdSailorWebView bdSailorWebView, int i2, String str, String str2) {
            InterceptResult invokeLILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048583, this, bdSailorWebView, i2, str, str2)) == null) {
                boolean unused = SwanAppSlaveManager.Q;
                return super.onGetErrorHtmlExt(bdSailorWebView, i2, str, str2);
            }
            return (String) invokeLILL.objValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onJsCodeCacheFinished(JsCodeCacheResult jsCodeCacheResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsCodeCacheResult) == null) {
                if (SwanAppSlaveManager.Q && jsCodeCacheResult != null) {
                    jsCodeCacheResult.toString();
                }
                if (jsCodeCacheResult == null || !jsCodeCacheResult.isCacheUsed) {
                    return;
                }
                if (TextUtils.equals(jsCodeCacheResult.businessId, "appframe")) {
                    this.this$0.N = true;
                } else if (TextUtils.equals(jsCodeCacheResult.businessId, "appjs")) {
                    this.this$0.O = true;
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onKeywordExtensionExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, bdSailorWebView, str, str2)) == null) {
                boolean unused = SwanAppSlaveManager.Q;
                return super.onKeywordExtensionExt(bdSailorWebView, str, str2);
            }
            return invokeLLL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageBackOrForwardExt(BdSailorWebView bdSailorWebView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048586, this, bdSailorWebView, i2) == null) {
                boolean unused = SwanAppSlaveManager.Q;
                super.onPageBackOrForwardExt(bdSailorWebView, i2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageCanBeScaledExt(BdSailorWebView bdSailorWebView, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048587, this, bdSailorWebView, z) == null) {
                boolean unused = SwanAppSlaveManager.Q;
                super.onPageCanBeScaledExt(bdSailorWebView, z);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPreloadUrlFoundExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048588, this, bdSailorWebView, str) == null) {
                if (SwanAppSlaveManager.Q) {
                    String str2 = "SwanAppSlaveWebViewClient::onPreloadUrlFoundEx：" + str;
                }
                super.onPreloadUrlFoundExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onSecurityCheckResultExt(BdSailorWebView bdSailorWebView, String str, WebViewClient.SecurityInfo securityInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048589, this, bdSailorWebView, str, securityInfo) == null) {
                boolean unused = SwanAppSlaveManager.Q;
                super.onSecurityCheckResultExt(bdSailorWebView, str, securityInfo);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onUrlRedirectedExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048590, this, bdSailorWebView, str, str2) == null) {
                boolean unused = SwanAppSlaveManager.Q;
                super.onUrlRedirectedExt(bdSailorWebView, str, str2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean shouldHandleImageExt(BdSailorWebView bdSailorWebView, String str, String str2, String str3, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{bdSailorWebView, str, str2, str3, Boolean.valueOf(z)})) == null) {
                boolean unused = SwanAppSlaveManager.Q;
                return super.shouldHandleImageExt(bdSailorWebView, str, str2, str3, z);
            }
            return invokeCommon.booleanValue;
        }

        public /* synthetic */ SwanAppSlaveWebviewClientExt(SwanAppSlaveManager swanAppSlaveManager, a aVar) {
            this(swanAppSlaveManager);
        }
    }

    /* loaded from: classes7.dex */
    public class a implements PullToRefreshBase.j<NgWebView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppSlaveManager f44415a;

        public a(SwanAppSlaveManager swanAppSlaveManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppSlaveManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f44415a = swanAppSlaveManager;
        }

        @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.j
        public void a(PullToRefreshBase<NgWebView> pullToRefreshBase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pullToRefreshBase) == null) {
            }
        }

        @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.j
        public void b(PullToRefreshBase<NgWebView> pullToRefreshBase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pullToRefreshBase) == null) {
                b.a.p0.a.g1.f.U().l(this.f44415a.c(), new c("PullDownRefresh"));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-846831408, "Lcom/baidu/swan/apps/core/slave/SwanAppSlaveManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-846831408, "Lcom/baidu/swan/apps/core/slave/SwanAppSlaveManager;");
                return;
            }
        }
        Q = k.f6863a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanAppSlaveManager(Context context) {
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
        this.M = new b.a.p0.a.h0.t.b(this);
        this.P = new b.a.p0.a.h0.t.h.a();
    }

    @Override // b.a.p0.a.p.e.b
    public void A(FrameLayout frameLayout, g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, frameLayout, gVar) == null) || frameLayout == null) {
            return;
        }
        frameLayout.setBackgroundColor(gVar.f4521e);
    }

    @Override // b.a.p0.a.p.d.f1
    public double B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 1.0d;
        }
        return invokeV.doubleValue;
    }

    @Override // b.a.p0.a.p.e.b
    public void D(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            t().setVisibility(i2);
            b.a.p0.a.a3.k.a aVar = this.E;
            if (aVar != null) {
                aVar.h(i2);
            }
            if (j0() != null) {
                j0().setVisibility(i2);
            }
            SwanAppWebViewWidget swanAppWebViewWidget = this.C;
            if (swanAppWebViewWidget == null || swanAppWebViewWidget.t() == null) {
                return;
            }
            b.a.p0.a.f2.f.q0.d params = this.C.getParams();
            this.C.t().setVisibility(i2 == 0 && params != null && !params.j ? 0 : 8);
        }
    }

    @Override // b.a.p0.a.p.e.b
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            SwanAppWebViewWidget swanAppWebViewWidget = this.C;
            if (swanAppWebViewWidget == null || !swanAppWebViewWidget.t().canGoBack()) {
                return false;
            }
            this.C.t().goBack();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.p.e.b
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? BdZeusUtil.isWebkitLoaded() : invokeV.booleanValue;
    }

    @Override // b.a.p0.a.p.e.b
    public void M(b.a.p0.a.h0.u.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) || dVar == null) {
            return;
        }
        if (Q) {
            String str = "pathList item: " + dVar.f6146a;
        }
        this.f44367f.getSettings().setCodeCacheSetting(b.a.p0.a.h0.d.b.a("appjs", dVar.f6146a));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            String c2 = c();
            this.f44367f.getCurrentWebView().addZeusPluginFactory(new b.a.p0.a.y0.k.d(c2));
            this.f44367f.getCurrentWebView().addZeusPluginFactory(new b.a.p0.a.y0.e.b(c2));
            this.f44367f.getCurrentWebView().addZeusPluginFactory(new b.a.p0.a.y0.i.b(c2));
            this.f44367f.getCurrentWebView().addZeusPluginFactory(new b.a.p0.a.y0.k.c(c2));
            this.f44367f.getCurrentWebView().addZeusPluginFactory(new b.a.p0.a.y0.f.c(c2));
            this.f44367f.getCurrentWebView().addZeusPluginFactory(new b.a.p0.a.y0.g.d(c2));
            this.f44367f.getCurrentWebView().addZeusPluginFactory(new b.a.p0.a.y0.g.c(c2));
        }
    }

    @Override // b.a.p0.a.p.e.b
    public b.a.p0.a.p.e.j.d O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.L : (b.a.p0.a.p.e.j.d) invokeV.objValue;
    }

    @Override // b.a.p0.a.p.e.b
    public void Q(FrameLayout frameLayout, g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, frameLayout, gVar) == null) || frameLayout == null) {
            return;
        }
        if (gVar.f4522f) {
            this.D = new PullToRefreshNgWebView(this.f44366e.getBaseContext(), this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
            s(SwanAppConfigData.t(gVar.f4520d));
            r1(this.D);
            k(frameLayout, this.D);
        } else {
            k(frameLayout, t());
        }
        this.H = frameLayout;
        if (this.E == null) {
            this.E = new b.a.p0.a.a3.k.a(this.f44366e.getBaseContext(), this, frameLayout);
        }
        if (this.F == null) {
            this.F = new b.a.p0.a.c0.e.a(this.f44366e.getBaseContext(), this.E);
        }
    }

    @Override // b.a.p0.a.p.e.b
    public int S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // b.a.p0.a.p.e.b
    public void T(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.B = str;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.U0();
        }
    }

    @Override // b.a.p0.a.p.e.b
    public void V() {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (activity = b.a.p0.a.g1.f.U().getActivity()) == null) {
            return;
        }
        x.a(activity, activity.getWindow().getDecorView().getWindowToken());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void W0(SwanAppWebViewManager.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) {
            super.W0(dVar);
            dVar.f44394a = true;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.X0();
            n1();
            b.a.p0.a.f2.f.k kVar = new b.a.p0.a.f2.f.k(this.l);
            kVar.j(this);
            this.l.b(kVar);
            this.L = new b.a.p0.a.p.e.j.d();
            b1(new SwanAppSlaveWebviewClientExt(this, null));
        }
    }

    @Override // b.a.p0.a.p.e.b
    public boolean Y(b.a.p0.a.f2.f.q0.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, dVar)) == null) {
            if (this.C != null) {
                if (!TextUtils.isEmpty(dVar.o)) {
                    this.C.d1(dVar.o);
                }
                this.C.S1(dVar.q);
                this.C.loadUrl(dVar.n);
                this.C.U1(dVar);
                if (dVar.l == null) {
                    dVar.l = b.a.p0.a.m1.e.a.a.a();
                }
                if (this.C.t() != null) {
                    this.C.t().setVisibility(dVar.j ? 8 : 0);
                }
                d dVar2 = this.I;
                if (dVar2 != null) {
                    this.C.a0(dVar2);
                }
                d dVar3 = this.J;
                if (dVar3 != null) {
                    this.C.t1(dVar3);
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.p0.a.p.e.b
    public boolean Z(b.a.p0.a.f2.f.q0.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, dVar)) == null) {
            SwanAppWebViewWidget swanAppWebViewWidget = this.C;
            if (swanAppWebViewWidget != null) {
                e eVar = this.G;
                if (eVar != null) {
                    eVar.b(swanAppWebViewWidget);
                }
                if (this.I != null) {
                    this.I = null;
                }
                if (this.J != null) {
                    this.J = null;
                }
                q1(this.H, this.C.t());
                this.C.U1(dVar);
                this.C.destroy();
                this.C = null;
                PullToRefreshNgWebView pullToRefreshNgWebView = this.D;
                if (pullToRefreshNgWebView != null) {
                    pullToRefreshNgWebView.setPullRefreshEnabled(true);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.p0.a.p.e.b
    public void a0(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, dVar) == null) {
            this.I = dVar;
        }
    }

    @Override // b.a.p0.a.p.e.b
    public void b0(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, eVar) == null) {
            this.G = eVar;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, b.a.p0.a.p.e.d
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.A : (String) invokeV.objValue;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, b.a.p0.a.p.e.d
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            Z(null);
            V();
            super.destroy();
            b.a.p0.a.c1.a.J().i(this);
            b.a.p0.a.a3.k.a aVar = this.E;
            if (aVar != null) {
                aVar.f();
            }
            b.a.p0.a.c0.e.a aVar2 = this.F;
            if (aVar2 != null) {
                aVar2.b();
            }
        }
    }

    @Override // b.a.p0.a.p.e.b
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? t().getParent() != null : invokeV.booleanValue;
    }

    @Override // b.a.p0.a.p.e.b
    @Nullable
    public b.a.p0.a.c0.e.a e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.F : (b.a.p0.a.c0.e.a) invokeV.objValue;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, b.a.p0.a.p.e.d
    public void f(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, activity) == null) {
            super.f(activity);
            SwanAppWebViewWidget swanAppWebViewWidget = this.C;
            if (swanAppWebViewWidget != null) {
                swanAppWebViewWidget.f(activity);
            }
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, b.a.p0.a.p.e.d
    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            b.a.p0.a.j1.b.d(this.A);
            b.a.p0.a.y0.g.e.a().c(this.A);
        }
    }

    @Override // b.a.p0.a.p.e.b
    public int h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? b.a.p0.a.h0.d.a.b(this.N, this.O) : invokeV.intValue;
    }

    @Override // b.a.p0.a.p.e.b
    public void i(b.a.p0.a.m1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bVar) == null) {
            this.M.h(bVar);
        }
    }

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, motionEvent)) == null) {
            SwanAppWebViewWidget swanAppWebViewWidget = this.C;
            if (swanAppWebViewWidget != null) {
                return swanAppWebViewWidget.isSlidable(motionEvent);
            }
            return this.f44367f.isSlidable(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.p0.a.p.e.b
    public PullToRefreshBaseWebView j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            PullToRefreshNgWebView pullToRefreshNgWebView = this.D;
            if (pullToRefreshNgWebView == null) {
                return null;
            }
            return pullToRefreshNgWebView;
        }
        return (PullToRefreshBaseWebView) invokeV.objValue;
    }

    @Override // b.a.p0.a.p.e.b
    public void k(ViewGroup viewGroup, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048605, this, viewGroup, view) == null) || viewGroup == null || view == null || m1(viewGroup, view)) {
            return;
        }
        viewGroup.addView(view, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // b.a.p0.a.p.e.b
    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            SwanAppWebViewWidget swanAppWebViewWidget = this.C;
            b.a.p0.a.p.e.j.d O = swanAppWebViewWidget != null ? swanAppWebViewWidget.O() : this.L;
            return O != null && TextUtils.equals(O.f7613g, "0") && O.f7609c > 0;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.p.e.b
    @Nullable
    /* renamed from: k1 */
    public SwanAppWebViewWidget l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.C : (SwanAppWebViewWidget) invokeV.objValue;
    }

    @Override // b.a.p0.a.p.e.b
    public String l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.K : (String) invokeV.objValue;
    }

    public void l1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.M.c();
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, b.a.p0.a.p.e.d, b.a.p0.a.h0.l.a
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            super.loadUrl(str);
            if (b.a.p0.a.e0.d.f()) {
                b.a.p0.a.h0.e.b.b();
            }
        }
    }

    public final boolean m1(ViewGroup viewGroup, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048612, this, viewGroup, view)) == null) {
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (viewGroup.getChildAt(i2) == view) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // b.a.p0.a.p.e.b
    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.B : (String) invokeV.objValue;
    }

    public final void n1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.A = b.a.p0.a.h0.t.e.a.a();
        }
    }

    public final boolean o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? !this.M.f6117c : invokeV.booleanValue;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, b.a.p0.a.p.e.d
    public void onJSLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            b.a.p0.a.h0.u.g.U().w0(false);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, b.a.p0.a.p.e.d
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.onPause();
            this.M.d();
            b.a.p0.a.c1.a.J().f(this);
            SwanAppWebViewWidget swanAppWebViewWidget = this.C;
            if (swanAppWebViewWidget != null) {
                swanAppWebViewWidget.onPause();
            }
            if (b.a.p0.a.d2.e.L() != null) {
                b.a.p0.a.d2.e.L().O().y(false);
            }
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, b.a.p0.a.p.e.d
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            super.onResume();
            this.M.e();
            b.a.p0.a.c1.a.J().d(this);
            SwanAppWebViewWidget swanAppWebViewWidget = this.C;
            if (swanAppWebViewWidget != null) {
                swanAppWebViewWidget.onResume();
            }
            if (b.a.p0.a.d2.e.L() != null) {
                b.a.p0.a.d2.e.L().O().y(true);
            }
            s1();
        }
    }

    @NonNull
    public SwanAppWebViewWidget p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? new SwanAppWebViewWidget(this.f44366e.getBaseContext()) : (SwanAppWebViewWidget) invokeV.objValue;
    }

    public final void q1(ViewGroup viewGroup, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048620, this, viewGroup, view) == null) || viewGroup == null || view == null || !m1(viewGroup, view)) {
            return;
        }
        viewGroup.removeView(view);
    }

    public void r1(PullToRefreshBaseWebView pullToRefreshBaseWebView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, pullToRefreshBaseWebView) == null) || pullToRefreshBaseWebView == null) {
            return;
        }
        this.D.setOnRefreshListener(new a(this));
    }

    @Override // b.a.p0.a.p.e.b
    public boolean s(int i2) {
        InterceptResult invokeI;
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048622, this, i2)) == null) {
            PullToRefreshNgWebView pullToRefreshNgWebView = this.D;
            if (pullToRefreshNgWebView == null || (neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) pullToRefreshNgWebView.getHeaderLoadingLayout()) == null) {
                return false;
            }
            return neutralHeaderLoadingLayout.setBackgroundTextStyle(i2);
        }
        return invokeI.booleanValue;
    }

    public final void s1() {
        NgWebView ngWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || b.a.p0.a.k1.f.b.e() || b.a.p0.a.k1.f.b.f()) {
            return;
        }
        SwanAppWebViewWidget swanAppWebViewWidget = this.C;
        if (swanAppWebViewWidget != null && swanAppWebViewWidget.t() != null) {
            ngWebView = this.C.t();
        } else {
            ngWebView = this.f44367f;
        }
        ngWebView.getSettings().setTextZoom(b.a.p0.a.k1.f.b.a(b.a.p0.a.k1.f.b.b()));
    }

    public void t1(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, dVar) == null) {
            this.J = dVar;
        }
    }

    @Override // b.a.p0.a.p.e.b
    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, str) == null) {
            this.K = str;
            SwanAppWebViewWidget swanAppWebViewWidget = this.C;
            if (swanAppWebViewWidget != null) {
                swanAppWebViewWidget.w(str);
            }
        }
    }

    @Override // b.a.p0.a.p.e.b
    public boolean x(b.a.p0.a.f2.f.q0.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, dVar)) == null) {
            if (dVar != null && this.H != null) {
                PullToRefreshNgWebView pullToRefreshNgWebView = this.D;
                if (pullToRefreshNgWebView != null) {
                    pullToRefreshNgWebView.onPullDownRefreshComplete(false);
                    this.D.setPullRefreshEnabled(false);
                }
                if (this.C == null) {
                    if (Q && !(this.f44366e.getBaseContext() instanceof Activity)) {
                        Log.getStackTraceString(new Exception("context is not activity."));
                    }
                    SwanAppWebViewWidget p1 = p1();
                    this.C = p1;
                    p1.w(this.K);
                    this.C.T1(this);
                    if (!TextUtils.isEmpty(dVar.o)) {
                        this.C.d1(dVar.o);
                    }
                    if (dVar.l == null) {
                        dVar.l = b.a.p0.a.m1.e.a.a.a();
                    }
                    k(this.H, this.C.t());
                    if (this.C.t() != null) {
                        this.C.t().setVisibility(dVar.j ? 8 : 0);
                        s1();
                    }
                    this.C.S1(dVar.q);
                    this.C.loadUrl(dVar.n);
                    this.C.U1(dVar);
                    e eVar = this.G;
                    if (eVar != null) {
                        eVar.a(this.C);
                    }
                    d dVar2 = this.I;
                    if (dVar2 != null) {
                        this.C.a0(dVar2);
                    }
                    d dVar3 = this.J;
                    if (dVar3 != null) {
                        this.C.t1(dVar3);
                        return true;
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
