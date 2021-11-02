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
import b.a.p0.a.a2.n.g;
import b.a.p0.a.h0.i.i;
import b.a.p0.a.h0.j.d;
import b.a.p0.a.h0.j.e;
import b.a.p0.a.k;
import b.a.p0.a.p.e.b;
import b.a.p0.a.r1.h;
import b.a.p0.a.r1.k.f;
import b.a.p0.a.t.a;
import b.a.p0.a.v2.q;
import b.a.p0.a.v2.x;
import b.a.p0.a.y0.k.c;
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
/* loaded from: classes8.dex */
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
    public b.a.p0.a.w2.k.a E;
    @Nullable
    public b.a.p0.a.c0.e.a F;
    public e G;
    public FrameLayout H;
    public d I;
    public d J;
    public String K;
    public b.a.p0.a.p.e.j.d L;
    public b.a.p0.a.h0.t.b M;

    /* loaded from: classes8.dex */
    public class SwanAppSlaveWebviewClientExt extends BdSailorWebViewClientExt {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppSlaveManager this$0;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ long f43655e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ HybridUbcFlow f43656f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SwanAppSlaveWebviewClientExt f43657g;

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
                this.f43657g = swanAppSlaveWebviewClientExt;
                this.f43655e = j;
                this.f43656f = hybridUbcFlow;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (h.f7629b) {
                        boolean unused = SwanAppSlaveManager.N;
                        this.f43657g.this$0.j1(true);
                        return;
                    }
                    if (this.f43657g.this$0.L.f7194c <= 0) {
                        j = this.f43655e;
                    } else {
                        j = this.f43657g.this$0.L.f7194c;
                    }
                    this.f43656f.A("fmp_type", this.f43657g.this$0.L.f7198g);
                    HybridUbcFlow hybridUbcFlow = this.f43656f;
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(j);
                    hybridUbcFlow.C(ubcFlowEvent);
                    hybridUbcFlow.z(this.f43657g.this$0);
                    if (SwanAppSlaveManager.N) {
                        String str = "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + this.f43657g.this$0.L.f7198g + " , fmpTypeName=" + this.f43657g.this$0.L.a();
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
                b.a.p0.a.e0.d.h("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstContentfulPaintExt");
                super.onFirstContentfulPaintExt(bdSailorWebView, str);
                long currentTimeMillis = System.currentTimeMillis();
                if (SwanAppSlaveManager.N) {
                    String str2 = "on fcp: real fcp = " + currentTimeMillis;
                }
                this.this$0.L.f7193b = currentTimeMillis;
                f.j().n().a(this.this$0.L.f7193b);
                i.l(this.this$0.L.f7193b);
                long b2 = h.f7629b ? currentTimeMillis : this.this$0.L.b();
                if (SwanAppSlaveManager.N) {
                    String str3 = "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime=" + b2 + " , aligned search=" + h.f7629b;
                }
                HybridUbcFlow p = h.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_paint");
                ubcFlowEvent.h(b2);
                p.C(ubcFlowEvent);
                if (SwanAppSlaveManager.P != null) {
                    SwanAppSlaveManager.P.a();
                }
                b.a.p0.a.u.f.a.d().f();
                this.this$0.M.a();
                if (this.this$0.L.f7194c == 0) {
                    this.this$0.L.f7194c = b2;
                    b.a.p0.a.p.e.j.d dVar = this.this$0.L;
                    dVar.f7198g = dVar.c(b2);
                    p.A("fmp_type", "1");
                    UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent2.h(this.this$0.L.f7193b);
                    p.C(ubcFlowEvent2);
                    if (h.f7630c) {
                        return;
                    }
                }
                long I = b.a.p0.a.c1.a.Z().I();
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
                b.a.p0.a.e0.d.h("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstImagePaintExt");
                super.onFirstImagePaintExt(bdSailorWebView, str);
                this.this$0.L.f7196e = System.currentTimeMillis();
                f.j().n().g(this.this$0.L.f7196e);
                if (SwanAppSlaveManager.N) {
                    String str2 = "on fip: real fip = " + this.this$0.L.f7196e;
                }
                if (h.f7629b) {
                    boolean unused = SwanAppSlaveManager.N;
                    this.this$0.j1(false);
                } else if (this.this$0.L.f7194c == 0) {
                    HybridUbcFlow p = h.p("startup");
                    p.A("fmp_type", "3");
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(this.this$0.L.f7196e);
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
                this.this$0.L.f7192a = System.currentTimeMillis();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, bdSailorWebView, str) == null) {
                b.a.p0.a.e0.d.h("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedExt");
                super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
                this.this$0.L.f7194c = System.currentTimeMillis();
                this.this$0.L.f7198g = "0";
                f.j().n().e(this.this$0.L.f7194c);
                if (SwanAppSlaveManager.N) {
                    String str2 = "on fmp: real fmp = " + this.this$0.L.f7194c;
                }
                HybridUbcFlow d2 = h.d("startup");
                if (d2 != null) {
                    d2.A("webviewComponent", "1");
                    d2.A("fmp_type", "0");
                    d2.B("value", "arrive_success");
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(this.this$0.L.f7194c);
                    ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE);
                    d2.C(ubcFlowEvent);
                    d2.z(this.this$0);
                    b.a.p0.a.p.e.j.d dVar = this.this$0.L;
                    b.a.p0.a.e0.d.a("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(this.this$0.L.f7194c), " , fmpType=", dVar.f7198g, " , fmpTypeName=", dVar.a());
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
                b.a.p0.a.e0.d.h("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstTextPaintExt");
                super.onFirstTextPaintExt(bdSailorWebView, str);
                this.this$0.L.f7195d = System.currentTimeMillis();
                f.j().n().f(this.this$0.L.f7195d);
                if (SwanAppSlaveManager.N) {
                    String str2 = "on ftp: real ftp = " + this.this$0.L.f7195d;
                }
                if (h.f7629b) {
                    boolean unused = SwanAppSlaveManager.N;
                    this.this$0.j1(false);
                } else if (this.this$0.L.f7194c == 0) {
                    HybridUbcFlow p = h.p("startup");
                    p.A("fmp_type", "2");
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(this.this$0.L.f7195d);
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

    /* loaded from: classes8.dex */
    public class a implements PullToRefreshBase.j<NgWebView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppSlaveManager f43658a;

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
            this.f43658a = swanAppSlaveManager;
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
                b.a.p0.a.g1.f.T().l(this.f43658a.b(), new b.a.p0.a.o0.d.b("PullDownRefresh"));
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
        N = k.f6397a;
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
        this.M = new b.a.p0.a.h0.t.b(this);
    }

    public static void k1(a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fVar) == null) {
            P = fVar;
        }
    }

    @Override // b.a.p0.a.p.d.z0
    public double A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 1.0d;
        }
        return invokeV.doubleValue;
    }

    @Override // b.a.p0.a.p.e.b
    public void D(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            s().setVisibility(i2);
            b.a.p0.a.w2.k.a aVar = this.E;
            if (aVar != null) {
                aVar.h(i2);
            }
            if (f0() != null) {
                f0().setVisibility(i2);
            }
            SwanAppWebViewWidget swanAppWebViewWidget = this.C;
            if (swanAppWebViewWidget == null || swanAppWebViewWidget.s() == null) {
                return;
            }
            b.a.p0.a.c2.f.r0.d params = this.C.getParams();
            this.C.s().setVisibility(i2 == 0 && params != null && !params.j ? 0 : 8);
        }
    }

    @Override // b.a.p0.a.p.e.b
    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            SwanAppWebViewWidget swanAppWebViewWidget = this.C;
            if (swanAppWebViewWidget == null || !swanAppWebViewWidget.s().canGoBack()) {
                return false;
            }
            this.C.s().goBack();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.p0.a.p.e.b
    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? BdZeusUtil.isWebkitLoaded() : invokeV.booleanValue;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            String b2 = b();
            this.f43607f.getCurrentWebView().addZeusPluginFactory(new b.a.p0.a.y0.k.d(b2));
            this.f43607f.getCurrentWebView().addZeusPluginFactory(new b.a.p0.a.y0.e.b(b2));
            this.f43607f.getCurrentWebView().addZeusPluginFactory(new b.a.p0.a.y0.i.b(b2));
            this.f43607f.getCurrentWebView().addZeusPluginFactory(new c(b2));
            this.f43607f.getCurrentWebView().addZeusPluginFactory(new b.a.p0.a.y0.f.c(b2));
            this.f43607f.getCurrentWebView().addZeusPluginFactory(new b.a.p0.a.y0.g.d(b2));
            this.f43607f.getCurrentWebView().addZeusPluginFactory(new b.a.p0.a.y0.g.c(b2));
        }
    }

    @Override // b.a.p0.a.p.e.b
    public void K(b.a.p0.a.h0.u.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) || dVar == null) {
            return;
        }
        if (N) {
            String str = "pathList item: " + dVar.f5810a;
        }
        this.f43607f.getSettings().setCodeCacheSetting(b.a.p0.a.h0.d.b.a("appjs", dVar.f5810a));
    }

    @Override // b.a.p0.a.p.e.b
    public b.a.p0.a.p.e.j.d M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.L : (b.a.p0.a.p.e.j.d) invokeV.objValue;
    }

    @Override // b.a.p0.a.p.e.b
    public void O(FrameLayout frameLayout, g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, frameLayout, gVar) == null) || frameLayout == null) {
            return;
        }
        if (gVar.f4009f) {
            this.D = new PullToRefreshNgWebView(this.f43606e.getBaseContext(), this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
            r(SwanAppConfigData.s(gVar.f4007d));
            m1(this.D);
            j(frameLayout, this.D);
        } else {
            j(frameLayout, s());
        }
        this.H = frameLayout;
        if (this.E == null) {
            this.E = new b.a.p0.a.w2.k.a(this.f43606e.getBaseContext(), this, frameLayout);
        }
        if (this.F == null) {
            this.F = new b.a.p0.a.c0.e.a(this.f43606e.getBaseContext(), this.E);
        }
    }

    @Override // b.a.p0.a.p.e.b
    public void Q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.B = str;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.Q0();
        }
    }

    @Override // b.a.p0.a.p.e.b
    public void S() {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (activity = b.a.p0.a.g1.f.T().getActivity()) == null) {
            return;
        }
        x.a(activity, activity.getWindow().getDecorView().getWindowToken());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void S0(SwanAppWebViewManager.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, eVar) == null) {
            super.S0(eVar);
            eVar.f43638a = true;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.T0();
            h1();
            b.a.p0.a.c2.f.k kVar = new b.a.p0.a.c2.f.k(this.l);
            kVar.j(this);
            this.l.b(kVar);
            this.L = new b.a.p0.a.p.e.j.d();
            X0(new SwanAppSlaveWebviewClientExt(this, null));
        }
    }

    @Override // b.a.p0.a.p.e.b
    public boolean V(b.a.p0.a.c2.f.r0.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, dVar)) == null) {
            if (this.C != null) {
                if (!TextUtils.isEmpty(dVar.o)) {
                    this.C.Z0(dVar.o);
                }
                this.C.L1(dVar.q);
                this.C.loadUrl(dVar.n);
                this.C.N1(dVar);
                if (dVar.l == null) {
                    dVar.l = b.a.p0.a.l1.e.a.a.a();
                }
                if (this.C.s() != null) {
                    this.C.s().setVisibility(dVar.j ? 8 : 0);
                }
                d dVar2 = this.I;
                if (dVar2 != null) {
                    this.C.X(dVar2);
                }
                d dVar3 = this.J;
                if (dVar3 != null) {
                    this.C.o1(dVar3);
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.p0.a.p.e.b
    public boolean W(b.a.p0.a.c2.f.r0.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, dVar)) == null) {
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
                l1(this.H, this.C.s());
                this.C.N1(dVar);
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
    public void X(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, dVar) == null) {
            this.I = dVar;
        }
    }

    @Override // b.a.p0.a.p.e.b
    public void Y(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, eVar) == null) {
            this.G = eVar;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, b.a.p0.a.p.e.d
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.A : (String) invokeV.objValue;
    }

    @Override // b.a.p0.a.p.e.b
    @Nullable
    public b.a.p0.a.c0.e.a b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.F : (b.a.p0.a.c0.e.a) invokeV.objValue;
    }

    @Override // b.a.p0.a.p.e.b
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? s().getParent() != null : invokeV.booleanValue;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, b.a.p0.a.p.e.d
    public void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            b.a.p0.a.i1.b.d(this.A);
            b.a.p0.a.y0.g.e.a().c(this.A);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, b.a.p0.a.p.e.d
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            W(null);
            S();
            super.destroy();
            b.a.p0.a.c1.a.F().i(this);
            b.a.p0.a.w2.k.a aVar = this.E;
            if (aVar != null) {
                aVar.f();
            }
            b.a.p0.a.c0.e.a aVar2 = this.F;
            if (aVar2 != null) {
                aVar2.b();
            }
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, b.a.p0.a.p.e.d
    public void e(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, activity) == null) {
            super.e(activity);
            SwanAppWebViewWidget swanAppWebViewWidget = this.C;
            if (swanAppWebViewWidget != null) {
                swanAppWebViewWidget.e(activity);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.p0.a.p.e.b
    @Nullable
    /* renamed from: e1 */
    public SwanAppWebViewWidget k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.C : (SwanAppWebViewWidget) invokeV.objValue;
    }

    @Override // b.a.p0.a.p.e.b
    public PullToRefreshBaseWebView f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            PullToRefreshNgWebView pullToRefreshNgWebView = this.D;
            if (pullToRefreshNgWebView == null) {
                return null;
            }
            return pullToRefreshNgWebView;
        }
        return (PullToRefreshBaseWebView) invokeV.objValue;
    }

    public void f1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.M.c();
        }
    }

    @Override // b.a.p0.a.p.e.b
    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            SwanAppWebViewWidget swanAppWebViewWidget = this.C;
            b.a.p0.a.p.e.j.d M = swanAppWebViewWidget != null ? swanAppWebViewWidget.M() : this.L;
            return M != null && TextUtils.equals(M.f7198g, "0") && M.f7194c > 0;
        }
        return invokeV.booleanValue;
    }

    public final boolean g1(ViewGroup viewGroup, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, viewGroup, view)) == null) {
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
    public void h(b.a.p0.a.l1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bVar) == null) {
            this.M.h(bVar);
        }
    }

    @Override // b.a.p0.a.p.e.b
    public String h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.K : (String) invokeV.objValue;
    }

    public final void h1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.A = String.valueOf(O);
            O++;
        }
    }

    @NonNull
    public SwanAppWebViewWidget i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? new SwanAppWebViewWidget(this.f43606e.getBaseContext()) : (SwanAppWebViewWidget) invokeV.objValue;
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
            return this.f43607f.isSlidable(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.p0.a.p.e.b
    public void j(ViewGroup viewGroup, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048609, this, viewGroup, view) == null) || viewGroup == null || view == null || g1(viewGroup, view)) {
            return;
        }
        viewGroup.addView(view, new FrameLayout.LayoutParams(-1, -1));
    }

    public final void j1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            if (N) {
                String str = "onCalibrateFmp: =========== start with isNaPaintFlowDone=" + z;
                String str2 = "onCalibrateFmp: before calibrate mPaintTiming=" + this.L.toString();
            }
            this.L.d();
            long j = this.L.f7194c;
            String str3 = this.L.f7198g;
            if (N) {
                String str4 = "onCalibrateFmp: after calibrate mPaintTiming=" + this.L.toString();
            }
            if (N && (j <= 0 || TextUtils.isEmpty(str3))) {
                throw new RuntimeException("onCalibratedFmp with illegal fmp=" + j + " , fmpType=" + str3 + " \n" + this.L.toString());
            }
            HybridUbcFlow p = h.p("startup");
            p.A("fmp_type", str3);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
            ubcFlowEvent.h(j);
            ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE);
            p.C(ubcFlowEvent);
            p.B("value", "arrive_success");
            if (N) {
                String str5 = "onCalibrateFmp: ===========  end with fmp=" + j + " , fmpType=" + str3 + " , fmpTypeName=" + this.L.a();
            }
            if (z) {
                if (N) {
                    String str6 = "onCalibrateFmp: naPaintFlowDone with fmp=" + j + " , fmpType=" + str3 + " , fmpTypeName=" + this.L.a();
                }
                p.z(this);
            }
        }
    }

    public final void l1(ViewGroup viewGroup, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048612, this, viewGroup, view) == null) || viewGroup == null || view == null || !g1(viewGroup, view)) {
            return;
        }
        viewGroup.removeView(view);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, b.a.p0.a.p.e.d, b.a.p0.a.h0.l.a
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            super.loadUrl(str);
            if (b.a.p0.a.e0.d.d()) {
                b.a.p0.a.h0.e.b.b();
            }
        }
    }

    @Override // b.a.p0.a.p.e.b
    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.B : (String) invokeV.objValue;
    }

    public void m1(PullToRefreshBaseWebView pullToRefreshBaseWebView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, pullToRefreshBaseWebView) == null) || pullToRefreshBaseWebView == null) {
            return;
        }
        this.D.setOnRefreshListener(new a(this));
    }

    public final void n1() {
        NgWebView ngWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || b.a.p0.a.j1.e.b.d() || b.a.p0.a.j1.e.b.e()) {
            return;
        }
        SwanAppWebViewWidget swanAppWebViewWidget = this.C;
        if (swanAppWebViewWidget != null && swanAppWebViewWidget.s() != null) {
            ngWebView = this.C.s();
        } else {
            ngWebView = this.f43607f;
        }
        ngWebView.getSettings().setTextZoom(b.a.p0.a.j1.e.b.a(b.a.p0.a.j1.e.b.b()));
    }

    public void o1(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, dVar) == null) {
            this.J = dVar;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, b.a.p0.a.p.e.d
    public void onJSLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            b.a.p0.a.h0.u.g.M().l0(false);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, b.a.p0.a.p.e.d
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            super.onPause();
            this.M.d();
            b.a.p0.a.c1.a.F().f(this);
            SwanAppWebViewWidget swanAppWebViewWidget = this.C;
            if (swanAppWebViewWidget != null) {
                swanAppWebViewWidget.onPause();
            }
            if (b.a.p0.a.a2.e.i() != null) {
                b.a.p0.a.a2.e.i().D().y(false);
            }
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, b.a.p0.a.p.e.d
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            super.onResume();
            this.M.e();
            b.a.p0.a.c1.a.F().d(this);
            SwanAppWebViewWidget swanAppWebViewWidget = this.C;
            if (swanAppWebViewWidget != null) {
                swanAppWebViewWidget.onResume();
            }
            if (b.a.p0.a.a2.e.i() != null) {
                b.a.p0.a.a2.e.i().D().y(true);
            }
            n1();
        }
    }

    @Override // b.a.p0.a.p.e.b
    public boolean r(int i2) {
        InterceptResult invokeI;
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048621, this, i2)) == null) {
            PullToRefreshNgWebView pullToRefreshNgWebView = this.D;
            if (pullToRefreshNgWebView == null || (neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) pullToRefreshNgWebView.getHeaderLoadingLayout()) == null) {
                return false;
            }
            return neutralHeaderLoadingLayout.setBackgroundTextStyle(i2);
        }
        return invokeI.booleanValue;
    }

    @Override // b.a.p0.a.p.e.b
    public void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.K = str;
            SwanAppWebViewWidget swanAppWebViewWidget = this.C;
            if (swanAppWebViewWidget != null) {
                swanAppWebViewWidget.v(str);
            }
        }
    }

    @Override // b.a.p0.a.p.e.b
    public boolean w(b.a.p0.a.c2.f.r0.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, dVar)) == null) {
            if (dVar != null && this.H != null) {
                PullToRefreshNgWebView pullToRefreshNgWebView = this.D;
                if (pullToRefreshNgWebView != null) {
                    pullToRefreshNgWebView.onPullDownRefreshComplete(false);
                    this.D.setPullRefreshEnabled(false);
                }
                if (this.C == null) {
                    if (N && !(this.f43606e.getBaseContext() instanceof Activity)) {
                        Log.getStackTraceString(new Exception("context is not activity."));
                    }
                    SwanAppWebViewWidget i1 = i1();
                    this.C = i1;
                    i1.v(this.K);
                    this.C.M1(this);
                    if (!TextUtils.isEmpty(dVar.o)) {
                        this.C.Z0(dVar.o);
                    }
                    if (dVar.l == null) {
                        dVar.l = b.a.p0.a.l1.e.a.a.a();
                    }
                    j(this.H, this.C.s());
                    if (this.C.s() != null) {
                        this.C.s().setVisibility(dVar.j ? 8 : 0);
                        n1();
                    }
                    this.C.L1(dVar.q);
                    this.C.loadUrl(dVar.n);
                    this.C.N1(dVar);
                    e eVar = this.G;
                    if (eVar != null) {
                        eVar.a(this.C);
                    }
                    d dVar2 = this.I;
                    if (dVar2 != null) {
                        this.C.X(dVar2);
                    }
                    d dVar3 = this.J;
                    if (dVar3 != null) {
                        this.C.o1(dVar3);
                        return true;
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.p0.a.p.e.b
    public void z(FrameLayout frameLayout, g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048624, this, frameLayout, gVar) == null) || frameLayout == null) {
            return;
        }
        frameLayout.setBackgroundColor(gVar.f4008e);
    }
}
