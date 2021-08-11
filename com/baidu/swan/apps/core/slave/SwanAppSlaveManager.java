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
import c.a.n0.a.a2.n.g;
import c.a.n0.a.h0.i.i;
import c.a.n0.a.h0.j.d;
import c.a.n0.a.h0.j.e;
import c.a.n0.a.k;
import c.a.n0.a.p.e.b;
import c.a.n0.a.r1.h;
import c.a.n0.a.r1.k.f;
import c.a.n0.a.t.a;
import c.a.n0.a.v2.q;
import c.a.n0.a.v2.x;
import c.a.n0.a.y0.k.c;
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
import com.baidu.webkit.sdk.WebViewClient;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class SwanAppSlaveManager extends SwanAppWebViewManager implements b<NgWebView> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean N;
    public static int O;
    public static a.f P;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String B;
    public SwanAppWebViewWidget C;
    public PullToRefreshNgWebView D;
    public c.a.n0.a.w2.k.a E;
    @Nullable
    public c.a.n0.a.c0.e.a F;
    public e G;
    public FrameLayout H;
    public d I;
    public d J;
    public String K;
    public c.a.n0.a.p.e.j.d L;
    public c.a.n0.a.h0.t.b M;

    /* loaded from: classes6.dex */
    public class SwanAppSlaveWebviewClientExt extends BdSailorWebViewClientExt {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppSlaveManager this$0;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ long f45704e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ HybridUbcFlow f45705f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SwanAppSlaveWebviewClientExt f45706g;

            public a(SwanAppSlaveWebviewClientExt swanAppSlaveWebviewClientExt, long j2, HybridUbcFlow hybridUbcFlow) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {swanAppSlaveWebviewClientExt, Long.valueOf(j2), hybridUbcFlow};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f45706g = swanAppSlaveWebviewClientExt;
                this.f45704e = j2;
                this.f45705f = hybridUbcFlow;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (h.f8072b) {
                        boolean unused = SwanAppSlaveManager.N;
                        this.f45706g.this$0.k1(true);
                        return;
                    }
                    if (this.f45706g.this$0.L.f7619c <= 0) {
                        j2 = this.f45704e;
                    } else {
                        j2 = this.f45706g.this$0.L.f7619c;
                    }
                    this.f45705f.A("fmp_type", this.f45706g.this$0.L.f7623g);
                    HybridUbcFlow hybridUbcFlow = this.f45705f;
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(j2);
                    hybridUbcFlow.C(ubcFlowEvent);
                    hybridUbcFlow.z(this.f45706g.this$0);
                    if (SwanAppSlaveManager.N) {
                        String str = "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j2 + " , fmpType" + this.f45706g.this$0.L.f7623g + " , fmpTypeName=" + this.f45706g.this$0.L.a();
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
                c.a.n0.a.e0.d.h("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstContentfulPaintExt");
                super.onFirstContentfulPaintExt(bdSailorWebView, str);
                long currentTimeMillis = System.currentTimeMillis();
                if (SwanAppSlaveManager.N) {
                    String str2 = "on fcp: real fcp = " + currentTimeMillis;
                }
                this.this$0.L.f7618b = currentTimeMillis;
                f.j().n().a(this.this$0.L.f7618b);
                i.l(this.this$0.L.f7618b);
                long b2 = h.f8072b ? currentTimeMillis : this.this$0.L.b();
                if (SwanAppSlaveManager.N) {
                    String str3 = "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime=" + b2 + " , aligned search=" + h.f8072b;
                }
                HybridUbcFlow p = h.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_paint");
                ubcFlowEvent.h(b2);
                p.C(ubcFlowEvent);
                if (SwanAppSlaveManager.P != null) {
                    SwanAppSlaveManager.P.a();
                }
                c.a.n0.a.u.f.a.d().f();
                this.this$0.M.a();
                if (this.this$0.L.f7619c == 0) {
                    this.this$0.L.f7619c = b2;
                    c.a.n0.a.p.e.j.d dVar = this.this$0.L;
                    dVar.f7623g = dVar.c(b2);
                    p.A("fmp_type", "1");
                    UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent2.h(this.this$0.L.f7618b);
                    p.C(ubcFlowEvent2);
                    if (h.f8073c) {
                        return;
                    }
                }
                long I = c.a.n0.a.c1.a.Z().I();
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
                c.a.n0.a.e0.d.h("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstImagePaintExt");
                super.onFirstImagePaintExt(bdSailorWebView, str);
                this.this$0.L.f7621e = System.currentTimeMillis();
                f.j().n().g(this.this$0.L.f7621e);
                if (SwanAppSlaveManager.N) {
                    String str2 = "on fip: real fip = " + this.this$0.L.f7621e;
                }
                if (h.f8072b) {
                    boolean unused = SwanAppSlaveManager.N;
                    this.this$0.k1(false);
                } else if (this.this$0.L.f7619c == 0) {
                    HybridUbcFlow p = h.p("startup");
                    p.A("fmp_type", "3");
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(this.this$0.L.f7621e);
                    p.C(ubcFlowEvent);
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
                boolean unused = SwanAppSlaveManager.N;
                super.onFirstPaintDidExt(bdSailorWebView, str);
                this.this$0.L.f7617a = System.currentTimeMillis();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, bdSailorWebView, str) == null) {
                c.a.n0.a.e0.d.h("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedExt");
                super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
                this.this$0.L.f7619c = System.currentTimeMillis();
                this.this$0.L.f7623g = "0";
                f.j().n().e(this.this$0.L.f7619c);
                if (SwanAppSlaveManager.N) {
                    String str2 = "on fmp: real fmp = " + this.this$0.L.f7619c;
                }
                HybridUbcFlow d2 = h.d("startup");
                if (d2 != null) {
                    d2.A("webviewComponent", "1");
                    d2.A("fmp_type", "0");
                    d2.B("value", "arrive_success");
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(this.this$0.L.f7619c);
                    ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE);
                    d2.C(ubcFlowEvent);
                    d2.z(this.this$0);
                    c.a.n0.a.p.e.j.d dVar = this.this$0.L;
                    c.a.n0.a.e0.d.a("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(this.this$0.L.f7619c), " , fmpType=", dVar.f7623g, " , fmpTypeName=", dVar.a());
                    h.t();
                }
                c.a.n0.a.u.f.a.d().g();
                this.this$0.M.g();
                this.this$0.M.b();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, bdSailorWebView, str) == null) {
                c.a.n0.a.e0.d.h("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstTextPaintExt");
                super.onFirstTextPaintExt(bdSailorWebView, str);
                this.this$0.L.f7620d = System.currentTimeMillis();
                f.j().n().f(this.this$0.L.f7620d);
                if (SwanAppSlaveManager.N) {
                    String str2 = "on ftp: real ftp = " + this.this$0.L.f7620d;
                }
                if (h.f8072b) {
                    boolean unused = SwanAppSlaveManager.N;
                    this.this$0.k1(false);
                } else if (this.this$0.L.f7619c == 0) {
                    HybridUbcFlow p = h.p("startup");
                    p.A("fmp_type", "2");
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(this.this$0.L.f7620d);
                    p.C(ubcFlowEvent);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFullScreenModeExt(BdSailorWebView bdSailorWebView, boolean z, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{bdSailorWebView, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
                boolean unused = SwanAppSlaveManager.N;
                super.onFullScreenModeExt(bdSailorWebView, z, i2, i3);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public String onGetErrorHtmlExt(BdSailorWebView bdSailorWebView, int i2, String str, String str2) {
            InterceptResult invokeLILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048583, this, bdSailorWebView, i2, str, str2)) == null) {
                boolean unused = SwanAppSlaveManager.N;
                return super.onGetErrorHtmlExt(bdSailorWebView, i2, str, str2);
            }
            return (String) invokeLILL.objValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onKeywordExtensionExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdSailorWebView, str, str2)) == null) {
                boolean unused = SwanAppSlaveManager.N;
                return super.onKeywordExtensionExt(bdSailorWebView, str, str2);
            }
            return invokeLLL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageBackOrForwardExt(BdSailorWebView bdSailorWebView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048585, this, bdSailorWebView, i2) == null) {
                boolean unused = SwanAppSlaveManager.N;
                super.onPageBackOrForwardExt(bdSailorWebView, i2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageCanBeScaledExt(BdSailorWebView bdSailorWebView, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048586, this, bdSailorWebView, z) == null) {
                boolean unused = SwanAppSlaveManager.N;
                super.onPageCanBeScaledExt(bdSailorWebView, z);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPreloadUrlFoundExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, bdSailorWebView, str) == null) {
                if (SwanAppSlaveManager.N) {
                    String str2 = "SwanAppSlaveWebViewClient::onPreloadUrlFoundEx：" + str;
                }
                super.onPreloadUrlFoundExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onSecurityCheckResultExt(BdSailorWebView bdSailorWebView, String str, WebViewClient.SecurityInfo securityInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048588, this, bdSailorWebView, str, securityInfo) == null) {
                boolean unused = SwanAppSlaveManager.N;
                super.onSecurityCheckResultExt(bdSailorWebView, str, securityInfo);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onUrlRedirectedExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048589, this, bdSailorWebView, str, str2) == null) {
                boolean unused = SwanAppSlaveManager.N;
                super.onUrlRedirectedExt(bdSailorWebView, str, str2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean shouldHandleImageExt(BdSailorWebView bdSailorWebView, String str, String str2, String str3, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{bdSailorWebView, str, str2, str3, Boolean.valueOf(z)})) == null) {
                boolean unused = SwanAppSlaveManager.N;
                return super.shouldHandleImageExt(bdSailorWebView, str, str2, str3, z);
            }
            return invokeCommon.booleanValue;
        }

        public /* synthetic */ SwanAppSlaveWebviewClientExt(SwanAppSlaveManager swanAppSlaveManager, a aVar) {
            this(swanAppSlaveManager);
        }
    }

    /* loaded from: classes6.dex */
    public class a implements PullToRefreshBase.j<NgWebView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppSlaveManager f45707a;

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
            this.f45707a = swanAppSlaveManager;
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
                c.a.n0.a.g1.f.V().m(this.f45707a.c(), new c.a.n0.a.o0.d.b("PullDownRefresh"));
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
        N = k.f6803a;
        O = 10;
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
        this.M = new c.a.n0.a.h0.t.b(this);
    }

    public static void l1(a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fVar) == null) {
            P = fVar;
        }
    }

    @Override // c.a.n0.a.p.e.b
    public void A(FrameLayout frameLayout, g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, frameLayout, gVar) == null) || frameLayout == null) {
            return;
        }
        frameLayout.setBackgroundColor(gVar.f4333e);
    }

    @Override // c.a.n0.a.p.d.z0
    public double B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 1.0d;
        }
        return invokeV.doubleValue;
    }

    @Override // c.a.n0.a.p.e.b
    public void D(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            t().setVisibility(i2);
            c.a.n0.a.w2.k.a aVar = this.E;
            if (aVar != null) {
                aVar.h(i2);
            }
            if (g0() != null) {
                g0().setVisibility(i2);
            }
            SwanAppWebViewWidget swanAppWebViewWidget = this.C;
            if (swanAppWebViewWidget == null || swanAppWebViewWidget.t() == null) {
                return;
            }
            c.a.n0.a.c2.f.r0.d params = this.C.getParams();
            this.C.t().setVisibility(i2 == 0 && params != null && !params.f4387j ? 0 : 8);
        }
    }

    @Override // c.a.n0.a.p.e.b
    public boolean J() {
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

    @Override // c.a.n0.a.p.e.b
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? BdZeusUtil.isWebkitLoaded() : invokeV.booleanValue;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            String c2 = c();
            this.f45653f.getCurrentWebView().addZeusPluginFactory(new c.a.n0.a.y0.k.d(c2));
            this.f45653f.getCurrentWebView().addZeusPluginFactory(new c.a.n0.a.y0.e.b(c2));
            this.f45653f.getCurrentWebView().addZeusPluginFactory(new c.a.n0.a.y0.i.b(c2));
            this.f45653f.getCurrentWebView().addZeusPluginFactory(new c(c2));
            this.f45653f.getCurrentWebView().addZeusPluginFactory(new c.a.n0.a.y0.f.c(c2));
            this.f45653f.getCurrentWebView().addZeusPluginFactory(new c.a.n0.a.y0.g.d(c2));
            this.f45653f.getCurrentWebView().addZeusPluginFactory(new c.a.n0.a.y0.g.c(c2));
        }
    }

    @Override // c.a.n0.a.p.e.b
    public void L(c.a.n0.a.h0.u.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) || dVar == null) {
            return;
        }
        if (N) {
            String str = "pathList item: " + dVar.f6196a;
        }
        this.f45653f.getSettings().setCodeCacheSetting(c.a.n0.a.h0.d.b.a("appjs", dVar.f6196a));
    }

    @Override // c.a.n0.a.p.e.b
    public c.a.n0.a.p.e.j.d N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.L : (c.a.n0.a.p.e.j.d) invokeV.objValue;
    }

    @Override // c.a.n0.a.p.e.b
    public void P(FrameLayout frameLayout, g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, frameLayout, gVar) == null) || frameLayout == null) {
            return;
        }
        if (gVar.f4334f) {
            this.D = new PullToRefreshNgWebView(this.f45652e.getBaseContext(), this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
            s(SwanAppConfigData.s(gVar.f4332d));
            n1(this.D);
            k(frameLayout, this.D);
        } else {
            k(frameLayout, t());
        }
        this.H = frameLayout;
        if (this.E == null) {
            this.E = new c.a.n0.a.w2.k.a(this.f45652e.getBaseContext(), this, frameLayout);
        }
        if (this.F == null) {
            this.F = new c.a.n0.a.c0.e.a(this.f45652e.getBaseContext(), this.E);
        }
    }

    @Override // c.a.n0.a.p.e.b
    public void R(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.B = str;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.R0();
        }
    }

    @Override // c.a.n0.a.p.e.b
    public void T() {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (activity = c.a.n0.a.g1.f.V().getActivity()) == null) {
            return;
        }
        x.a(activity, activity.getWindow().getDecorView().getWindowToken());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void T0(SwanAppWebViewManager.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, eVar) == null) {
            super.T0(eVar);
            eVar.f45686a = true;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.U0();
            i1();
            c.a.n0.a.c2.f.k kVar = new c.a.n0.a.c2.f.k(this.l);
            kVar.j(this);
            this.l.b(kVar);
            this.L = new c.a.n0.a.p.e.j.d();
            Y0(new SwanAppSlaveWebviewClientExt(this, null));
        }
    }

    @Override // c.a.n0.a.p.e.b
    public boolean W(c.a.n0.a.c2.f.r0.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, dVar)) == null) {
            if (this.C != null) {
                if (!TextUtils.isEmpty(dVar.o)) {
                    this.C.a1(dVar.o);
                }
                this.C.M1(dVar.q);
                this.C.loadUrl(dVar.n);
                this.C.O1(dVar);
                if (dVar.l == null) {
                    dVar.l = c.a.n0.a.l1.e.a.a.d();
                }
                if (this.C.t() != null) {
                    this.C.t().setVisibility(dVar.f4387j ? 8 : 0);
                }
                d dVar2 = this.I;
                if (dVar2 != null) {
                    this.C.Y(dVar2);
                }
                d dVar3 = this.J;
                if (dVar3 != null) {
                    this.C.p1(dVar3);
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.n0.a.p.e.b
    public boolean X(c.a.n0.a.c2.f.r0.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, dVar)) == null) {
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
                m1(this.H, this.C.t());
                this.C.O1(dVar);
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

    @Override // c.a.n0.a.p.e.b
    public void Y(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, dVar) == null) {
            this.I = dVar;
        }
    }

    @Override // c.a.n0.a.p.e.b
    public void Z(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, eVar) == null) {
            this.G = eVar;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, c.a.n0.a.p.e.d
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.A : (String) invokeV.objValue;
    }

    @Override // c.a.n0.a.p.e.b
    @Nullable
    public c.a.n0.a.c0.e.a c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.F : (c.a.n0.a.c0.e.a) invokeV.objValue;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, c.a.n0.a.p.e.d
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            X(null);
            T();
            super.destroy();
            c.a.n0.a.c1.a.F().i(this);
            c.a.n0.a.w2.k.a aVar = this.E;
            if (aVar != null) {
                aVar.f();
            }
            c.a.n0.a.c0.e.a aVar2 = this.F;
            if (aVar2 != null) {
                aVar2.c();
            }
        }
    }

    @Override // c.a.n0.a.p.e.b
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? t().getParent() != null : invokeV.booleanValue;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, c.a.n0.a.p.e.d
    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            c.a.n0.a.i1.b.d(this.A);
            c.a.n0.a.y0.g.e.a().c(this.A);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, c.a.n0.a.p.e.d
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.n0.a.p.e.b
    @Nullable
    /* renamed from: f1 */
    public SwanAppWebViewWidget l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.C : (SwanAppWebViewWidget) invokeV.objValue;
    }

    @Override // c.a.n0.a.p.e.b
    public PullToRefreshBaseWebView g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            PullToRefreshNgWebView pullToRefreshNgWebView = this.D;
            if (pullToRefreshNgWebView == null) {
                return null;
            }
            return pullToRefreshNgWebView;
        }
        return (PullToRefreshBaseWebView) invokeV.objValue;
    }

    public void g1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.M.c();
        }
    }

    @Override // c.a.n0.a.p.e.b
    public boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            SwanAppWebViewWidget swanAppWebViewWidget = this.C;
            c.a.n0.a.p.e.j.d N2 = swanAppWebViewWidget != null ? swanAppWebViewWidget.N() : this.L;
            return N2 != null && TextUtils.equals(N2.f7623g, "0") && N2.f7619c > 0;
        }
        return invokeV.booleanValue;
    }

    public final boolean h1(ViewGroup viewGroup, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, viewGroup, view)) == null) {
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

    @Override // c.a.n0.a.p.e.b
    public void i(c.a.n0.a.l1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bVar) == null) {
            this.M.h(bVar);
        }
    }

    @Override // c.a.n0.a.p.e.b
    public String i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.K : (String) invokeV.objValue;
    }

    public final void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.A = String.valueOf(O);
            O++;
        }
    }

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, motionEvent)) == null) {
            SwanAppWebViewWidget swanAppWebViewWidget = this.C;
            if (swanAppWebViewWidget != null) {
                return swanAppWebViewWidget.isSlidable(motionEvent);
            }
            return this.f45653f.isSlidable(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public SwanAppWebViewWidget j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? new SwanAppWebViewWidget(this.f45652e.getBaseContext()) : (SwanAppWebViewWidget) invokeV.objValue;
    }

    @Override // c.a.n0.a.p.e.b
    public void k(ViewGroup viewGroup, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048610, this, viewGroup, view) == null) || viewGroup == null || view == null || h1(viewGroup, view)) {
            return;
        }
        viewGroup.addView(view, new FrameLayout.LayoutParams(-1, -1));
    }

    public final void k1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            if (N) {
                String str = "onCalibrateFmp: =========== start with isNaPaintFlowDone=" + z;
                String str2 = "onCalibrateFmp: before calibrate mPaintTiming=" + this.L.toString();
            }
            this.L.d();
            long j2 = this.L.f7619c;
            String str3 = this.L.f7623g;
            if (N) {
                String str4 = "onCalibrateFmp: after calibrate mPaintTiming=" + this.L.toString();
            }
            if (N && (j2 <= 0 || TextUtils.isEmpty(str3))) {
                throw new RuntimeException("onCalibratedFmp with illegal fmp=" + j2 + " , fmpType=" + str3 + " \n" + this.L.toString());
            }
            HybridUbcFlow p = h.p("startup");
            p.A("fmp_type", str3);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
            ubcFlowEvent.h(j2);
            ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE);
            p.C(ubcFlowEvent);
            p.B("value", "arrive_success");
            if (N) {
                String str5 = "onCalibrateFmp: ===========  end with fmp=" + j2 + " , fmpType=" + str3 + " , fmpTypeName=" + this.L.a();
            }
            if (z) {
                if (N) {
                    String str6 = "onCalibrateFmp: naPaintFlowDone with fmp=" + j2 + " , fmpType=" + str3 + " , fmpTypeName=" + this.L.a();
                }
                p.z(this);
            }
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, c.a.n0.a.p.e.d, c.a.n0.a.h0.l.a
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            super.loadUrl(str);
            if (c.a.n0.a.e0.d.d()) {
                c.a.n0.a.h0.e.b.b();
            }
        }
    }

    public final void m1(ViewGroup viewGroup, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048614, this, viewGroup, view) == null) || viewGroup == null || view == null || !h1(viewGroup, view)) {
            return;
        }
        viewGroup.removeView(view);
    }

    @Override // c.a.n0.a.p.e.b
    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.B : (String) invokeV.objValue;
    }

    public void n1(PullToRefreshBaseWebView pullToRefreshBaseWebView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, pullToRefreshBaseWebView) == null) || pullToRefreshBaseWebView == null) {
            return;
        }
        this.D.setOnRefreshListener(new a(this));
    }

    public final void o1() {
        NgWebView ngWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048617, this) == null) || c.a.n0.a.j1.e.b.d() || c.a.n0.a.j1.e.b.e()) {
            return;
        }
        SwanAppWebViewWidget swanAppWebViewWidget = this.C;
        if (swanAppWebViewWidget != null && swanAppWebViewWidget.t() != null) {
            ngWebView = this.C.t();
        } else {
            ngWebView = this.f45653f;
        }
        ngWebView.getSettings().setTextZoom(c.a.n0.a.j1.e.b.a(c.a.n0.a.j1.e.b.b()));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, c.a.n0.a.p.e.d
    public void onJSLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            c.a.n0.a.h0.u.g.N().m0(false);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, c.a.n0.a.p.e.d
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            super.onPause();
            this.M.d();
            c.a.n0.a.c1.a.F().f(this);
            SwanAppWebViewWidget swanAppWebViewWidget = this.C;
            if (swanAppWebViewWidget != null) {
                swanAppWebViewWidget.onPause();
            }
            if (c.a.n0.a.a2.e.i() != null) {
                c.a.n0.a.a2.e.i().E().y(false);
            }
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, c.a.n0.a.p.e.d
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            super.onResume();
            this.M.e();
            c.a.n0.a.c1.a.F().d(this);
            SwanAppWebViewWidget swanAppWebViewWidget = this.C;
            if (swanAppWebViewWidget != null) {
                swanAppWebViewWidget.onResume();
            }
            if (c.a.n0.a.a2.e.i() != null) {
                c.a.n0.a.a2.e.i().E().y(true);
            }
            o1();
        }
    }

    public void p1(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, dVar) == null) {
            this.J = dVar;
        }
    }

    @Override // c.a.n0.a.p.e.b
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

    @Override // c.a.n0.a.p.e.b
    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            this.K = str;
            SwanAppWebViewWidget swanAppWebViewWidget = this.C;
            if (swanAppWebViewWidget != null) {
                swanAppWebViewWidget.w(str);
            }
        }
    }

    @Override // c.a.n0.a.p.e.b
    public boolean x(c.a.n0.a.c2.f.r0.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, dVar)) == null) {
            if (dVar != null && this.H != null) {
                PullToRefreshNgWebView pullToRefreshNgWebView = this.D;
                if (pullToRefreshNgWebView != null) {
                    pullToRefreshNgWebView.onPullDownRefreshComplete(false);
                    this.D.setPullRefreshEnabled(false);
                }
                if (this.C == null) {
                    if (N && !(this.f45652e.getBaseContext() instanceof Activity)) {
                        Log.getStackTraceString(new Exception("context is not activity."));
                    }
                    SwanAppWebViewWidget j1 = j1();
                    this.C = j1;
                    j1.w(this.K);
                    this.C.N1(this);
                    if (!TextUtils.isEmpty(dVar.o)) {
                        this.C.a1(dVar.o);
                    }
                    if (dVar.l == null) {
                        dVar.l = c.a.n0.a.l1.e.a.a.d();
                    }
                    k(this.H, this.C.t());
                    if (this.C.t() != null) {
                        this.C.t().setVisibility(dVar.f4387j ? 8 : 0);
                        o1();
                    }
                    this.C.M1(dVar.q);
                    this.C.loadUrl(dVar.n);
                    this.C.O1(dVar);
                    e eVar = this.G;
                    if (eVar != null) {
                        eVar.a(this.C);
                    }
                    d dVar2 = this.I;
                    if (dVar2 != null) {
                        this.C.Y(dVar2);
                    }
                    d dVar3 = this.J;
                    if (dVar3 != null) {
                        this.C.p1(dVar3);
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
