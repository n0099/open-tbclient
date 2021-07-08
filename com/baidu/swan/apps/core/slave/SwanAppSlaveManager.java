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
import d.a.n0.a.a2.n.g;
import d.a.n0.a.h0.i.i;
import d.a.n0.a.h0.j.d;
import d.a.n0.a.h0.j.e;
import d.a.n0.a.k;
import d.a.n0.a.p.e.b;
import d.a.n0.a.r1.h;
import d.a.n0.a.r1.k.f;
import d.a.n0.a.t.a;
import d.a.n0.a.v2.q;
import d.a.n0.a.v2.x;
import d.a.n0.a.y0.k.c;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
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
    public d.a.n0.a.w2.k.a E;
    @Nullable
    public d.a.n0.a.c0.e.a F;
    public e G;
    public FrameLayout H;
    public d I;
    public d J;
    public String K;
    public d.a.n0.a.p.e.j.d L;
    public d.a.n0.a.h0.t.b M;

    /* loaded from: classes3.dex */
    public class SwanAppSlaveWebviewClientExt extends BdSailorWebViewClientExt {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppSlaveManager this$0;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ long f10979e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ HybridUbcFlow f10980f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ SwanAppSlaveWebviewClientExt f10981g;

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
                this.f10981g = swanAppSlaveWebviewClientExt;
                this.f10979e = j;
                this.f10980f = hybridUbcFlow;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (h.f47065b) {
                        if (SwanAppSlaveManager.N) {
                            Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from fcp delay");
                        }
                        this.f10981g.this$0.l1(true);
                        return;
                    }
                    if (this.f10981g.this$0.L.f46628c <= 0) {
                        j = this.f10979e;
                    } else {
                        j = this.f10981g.this$0.L.f46628c;
                    }
                    this.f10980f.A("fmp_type", this.f10981g.this$0.L.f46632g);
                    HybridUbcFlow hybridUbcFlow = this.f10980f;
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(j);
                    hybridUbcFlow.C(ubcFlowEvent);
                    hybridUbcFlow.z(this.f10981g.this$0);
                    if (SwanAppSlaveManager.N) {
                        Log.d("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + this.f10981g.this$0.L.f46632g + " , fmpTypeName=" + this.f10981g.this$0.L.a());
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
                d.a.n0.a.e0.d.h("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstContentfulPaintExt");
                super.onFirstContentfulPaintExt(bdSailorWebView, str);
                long currentTimeMillis = System.currentTimeMillis();
                if (SwanAppSlaveManager.N) {
                    Log.d("SwanAppSlaveManager", "on fcp: real fcp = " + currentTimeMillis);
                }
                this.this$0.L.f46627b = currentTimeMillis;
                f.j().n().a(this.this$0.L.f46627b);
                i.l(this.this$0.L.f46627b);
                long b2 = h.f47065b ? currentTimeMillis : this.this$0.L.b();
                if (SwanAppSlaveManager.N) {
                    Log.d("SwanAppSlaveManager", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime=" + b2 + " , aligned search=" + h.f47065b);
                }
                HybridUbcFlow p = h.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_paint");
                ubcFlowEvent.h(b2);
                p.C(ubcFlowEvent);
                if (SwanAppSlaveManager.P != null) {
                    SwanAppSlaveManager.P.a();
                }
                d.a.n0.a.u.f.a.d().f();
                this.this$0.M.a();
                if (this.this$0.L.f46628c == 0) {
                    this.this$0.L.f46628c = b2;
                    d.a.n0.a.p.e.j.d dVar = this.this$0.L;
                    dVar.f46632g = dVar.c(b2);
                    p.A("fmp_type", "1");
                    UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent2.h(this.this$0.L.f46627b);
                    p.C(ubcFlowEvent2);
                    if (h.f47066c) {
                        return;
                    }
                }
                long I = d.a.n0.a.c1.a.Z().I();
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
                d.a.n0.a.e0.d.h("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstImagePaintExt");
                super.onFirstImagePaintExt(bdSailorWebView, str);
                this.this$0.L.f46630e = System.currentTimeMillis();
                f.j().n().g(this.this$0.L.f46630e);
                if (SwanAppSlaveManager.N) {
                    Log.d("SwanAppSlaveManager", "on fip: real fip = " + this.this$0.L.f46630e);
                }
                if (h.f47065b) {
                    if (SwanAppSlaveManager.N) {
                        Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from fip");
                    }
                    this.this$0.l1(false);
                } else if (this.this$0.L.f46628c == 0) {
                    HybridUbcFlow p = h.p("startup");
                    p.A("fmp_type", "3");
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(this.this$0.L.f46630e);
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
                if (SwanAppSlaveManager.N) {
                    Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstPaintDidEx");
                }
                super.onFirstPaintDidExt(bdSailorWebView, str);
                this.this$0.L.f46626a = System.currentTimeMillis();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, bdSailorWebView, str) == null) {
                d.a.n0.a.e0.d.h("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedExt");
                super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
                this.this$0.L.f46628c = System.currentTimeMillis();
                this.this$0.L.f46632g = "0";
                f.j().n().e(this.this$0.L.f46628c);
                if (SwanAppSlaveManager.N) {
                    Log.d("SwanAppSlaveManager", "on fmp: real fmp = " + this.this$0.L.f46628c);
                }
                HybridUbcFlow d2 = h.d("startup");
                if (d2 != null) {
                    d2.A("webviewComponent", "1");
                    d2.A("fmp_type", "0");
                    d2.B("value", "arrive_success");
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(this.this$0.L.f46628c);
                    ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE);
                    d2.C(ubcFlowEvent);
                    d2.z(this.this$0);
                    d.a.n0.a.p.e.j.d dVar = this.this$0.L;
                    d.a.n0.a.e0.d.a("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(this.this$0.L.f46628c), " , fmpType=", dVar.f46632g, " , fmpTypeName=", dVar.a());
                    h.t();
                }
                d.a.n0.a.u.f.a.d().g();
                this.this$0.M.g();
                this.this$0.M.b();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, bdSailorWebView, str) == null) {
                d.a.n0.a.e0.d.h("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstTextPaintExt");
                super.onFirstTextPaintExt(bdSailorWebView, str);
                this.this$0.L.f46629d = System.currentTimeMillis();
                f.j().n().f(this.this$0.L.f46629d);
                if (SwanAppSlaveManager.N) {
                    Log.d("SwanAppSlaveManager", "on ftp: real ftp = " + this.this$0.L.f46629d);
                }
                if (h.f47065b) {
                    if (SwanAppSlaveManager.N) {
                        Log.d("SwanAppSlaveManager", "-> onCalibrateFmp: from ftp");
                    }
                    this.this$0.l1(false);
                } else if (this.this$0.L.f46628c == 0) {
                    HybridUbcFlow p = h.p("startup");
                    p.A("fmp_type", "2");
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(this.this$0.L.f46629d);
                    p.C(ubcFlowEvent);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFullScreenModeExt(BdSailorWebView bdSailorWebView, boolean z, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{bdSailorWebView, Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
                if (SwanAppSlaveManager.N) {
                    Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFullScreenModeEx");
                }
                super.onFullScreenModeExt(bdSailorWebView, z, i2, i3);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public String onGetErrorHtmlExt(BdSailorWebView bdSailorWebView, int i2, String str, String str2) {
            InterceptResult invokeLILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048583, this, bdSailorWebView, i2, str, str2)) == null) {
                if (SwanAppSlaveManager.N) {
                    Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onGetErrorHtmlSailor");
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
                if (SwanAppSlaveManager.N) {
                    Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onKeywordExtensionEx");
                }
                return super.onKeywordExtensionExt(bdSailorWebView, str, str2);
            }
            return invokeLLL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageBackOrForwardExt(BdSailorWebView bdSailorWebView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048585, this, bdSailorWebView, i2) == null) {
                if (SwanAppSlaveManager.N) {
                    Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onGoBackOrForwardEx");
                }
                super.onPageBackOrForwardExt(bdSailorWebView, i2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageCanBeScaledExt(BdSailorWebView bdSailorWebView, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048586, this, bdSailorWebView, z) == null) {
                if (SwanAppSlaveManager.N) {
                    Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onPageCanBeScaledEx");
                }
                super.onPageCanBeScaledExt(bdSailorWebView, z);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPreloadUrlFoundExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048587, this, bdSailorWebView, str) == null) {
                if (SwanAppSlaveManager.N) {
                    Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onPreloadUrlFoundEx：" + str);
                }
                super.onPreloadUrlFoundExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onSecurityCheckResultExt(BdSailorWebView bdSailorWebView, String str, WebViewClient.SecurityInfo securityInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048588, this, bdSailorWebView, str, securityInfo) == null) {
                if (SwanAppSlaveManager.N) {
                    Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onSecurityCheckResultEx");
                }
                super.onSecurityCheckResultExt(bdSailorWebView, str, securityInfo);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onUrlRedirectedExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048589, this, bdSailorWebView, str, str2) == null) {
                if (SwanAppSlaveManager.N) {
                    Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onUrlRedirected");
                }
                super.onUrlRedirectedExt(bdSailorWebView, str, str2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean shouldHandleImageExt(BdSailorWebView bdSailorWebView, String str, String str2, String str3, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{bdSailorWebView, str, str2, str3, Boolean.valueOf(z)})) == null) {
                if (SwanAppSlaveManager.N) {
                    Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::canHandleImageEx");
                }
                return super.shouldHandleImageExt(bdSailorWebView, str, str2, str3, z);
            }
            return invokeCommon.booleanValue;
        }

        public /* synthetic */ SwanAppSlaveWebviewClientExt(SwanAppSlaveManager swanAppSlaveManager, a aVar) {
            this(swanAppSlaveManager);
        }
    }

    /* loaded from: classes3.dex */
    public class a implements PullToRefreshBase.h<NgWebView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SwanAppSlaveManager f10982a;

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
            this.f10982a = swanAppSlaveManager;
        }

        @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.h
        public void a(PullToRefreshBase<NgWebView> pullToRefreshBase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pullToRefreshBase) == null) {
            }
        }

        @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.h
        public void b(PullToRefreshBase<NgWebView> pullToRefreshBase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pullToRefreshBase) == null) {
                d.a.n0.a.g1.f.V().m(this.f10982a.b(), new d.a.n0.a.o0.d.b("PullDownRefresh"));
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
        N = k.f45831a;
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
        this.M = new d.a.n0.a.h0.t.b(this);
    }

    public static void m1(a.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fVar) == null) {
            P = fVar;
        }
    }

    @Override // d.a.n0.a.p.e.b
    public void B(FrameLayout frameLayout, g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, frameLayout, gVar) == null) || frameLayout == null) {
            return;
        }
        frameLayout.setBackgroundColor(gVar.f43428e);
    }

    @Override // d.a.n0.a.p.d.z0
    public double F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 1.0d;
        }
        return invokeV.doubleValue;
    }

    @Override // d.a.n0.a.p.e.b
    public void G(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            u().setVisibility(i2);
            d.a.n0.a.w2.k.a aVar = this.E;
            if (aVar != null) {
                aVar.h(i2);
            }
            if (h0() != null) {
                h0().setVisibility(i2);
            }
            SwanAppWebViewWidget swanAppWebViewWidget = this.C;
            if (swanAppWebViewWidget == null || swanAppWebViewWidget.u() == null) {
                return;
            }
            d.a.n0.a.c2.f.r0.d params = this.C.getParams();
            this.C.u().setVisibility(i2 == 0 && params != null && !params.j ? 0 : 8);
        }
    }

    @Override // d.a.n0.a.p.e.b
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            SwanAppWebViewWidget swanAppWebViewWidget = this.C;
            if (swanAppWebViewWidget == null || !swanAppWebViewWidget.u().canGoBack()) {
                return false;
            }
            this.C.u().goBack();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.n0.a.p.e.b
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? BdZeusUtil.isWebkitLoaded() : invokeV.booleanValue;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            String b2 = b();
            this.f10937f.getCurrentWebView().addZeusPluginFactory(new d.a.n0.a.y0.k.d(b2));
            this.f10937f.getCurrentWebView().addZeusPluginFactory(new d.a.n0.a.y0.e.b(b2));
            this.f10937f.getCurrentWebView().addZeusPluginFactory(new d.a.n0.a.y0.i.b(b2));
            this.f10937f.getCurrentWebView().addZeusPluginFactory(new c(b2));
            this.f10937f.getCurrentWebView().addZeusPluginFactory(new d.a.n0.a.y0.f.c(b2));
            this.f10937f.getCurrentWebView().addZeusPluginFactory(new d.a.n0.a.y0.g.d(b2));
            this.f10937f.getCurrentWebView().addZeusPluginFactory(new d.a.n0.a.y0.g.c(b2));
        }
    }

    @Override // d.a.n0.a.p.e.b
    public void M(d.a.n0.a.h0.u.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) || dVar == null) {
            return;
        }
        if (N) {
            Log.d("SwanAppSlaveManager", "pathList item: " + dVar.f45244a);
        }
        this.f10937f.getSettings().setCodeCacheSetting(d.a.n0.a.h0.d.b.a("appjs", dVar.f45244a));
    }

    @Override // d.a.n0.a.p.e.b
    public d.a.n0.a.p.e.j.d O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.L : (d.a.n0.a.p.e.j.d) invokeV.objValue;
    }

    @Override // d.a.n0.a.p.e.b
    public void Q(FrameLayout frameLayout, g gVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, frameLayout, gVar) == null) || frameLayout == null) {
            return;
        }
        if (gVar.f43429f) {
            this.D = new PullToRefreshNgWebView(this.f10936e.getBaseContext(), this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
            t(SwanAppConfigData.s(gVar.f43427d));
            o1(this.D);
            l(frameLayout, this.D);
        } else {
            l(frameLayout, u());
        }
        this.H = frameLayout;
        if (this.E == null) {
            this.E = new d.a.n0.a.w2.k.a(this.f10936e.getBaseContext(), this, frameLayout);
        }
        if (this.F == null) {
            this.F = new d.a.n0.a.c0.e.a(this.f10936e.getBaseContext(), this.E);
        }
    }

    @Override // d.a.n0.a.p.e.b
    public void S(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.B = str;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.S0();
        }
    }

    @Override // d.a.n0.a.p.e.b
    public void U() {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (activity = d.a.n0.a.g1.f.V().getActivity()) == null) {
            return;
        }
        x.a(activity, activity.getWindow().getDecorView().getWindowToken());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void U0(SwanAppWebViewManager.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, eVar) == null) {
            super.U0(eVar);
            eVar.f10968a = true;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.V0();
            j1();
            d.a.n0.a.c2.f.k kVar = new d.a.n0.a.c2.f.k(this.l);
            kVar.j(this);
            this.l.b(kVar);
            this.L = new d.a.n0.a.p.e.j.d();
            Z0(new SwanAppSlaveWebviewClientExt(this, null));
        }
    }

    @Override // d.a.n0.a.p.e.b
    public boolean X(d.a.n0.a.c2.f.r0.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, dVar)) == null) {
            if (this.C != null) {
                if (!TextUtils.isEmpty(dVar.o)) {
                    this.C.b1(dVar.o);
                }
                this.C.N1(dVar.q);
                this.C.loadUrl(dVar.n);
                this.C.P1(dVar);
                if (dVar.l == null) {
                    dVar.l = d.a.n0.a.l1.e.a.a.d();
                }
                if (this.C.u() != null) {
                    this.C.u().setVisibility(dVar.j ? 8 : 0);
                }
                d dVar2 = this.I;
                if (dVar2 != null) {
                    this.C.Z(dVar2);
                }
                d dVar3 = this.J;
                if (dVar3 != null) {
                    this.C.q1(dVar3);
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.n0.a.p.e.b
    public boolean Y(d.a.n0.a.c2.f.r0.d dVar) {
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
                n1(this.H, this.C.u());
                this.C.P1(dVar);
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

    @Override // d.a.n0.a.p.e.b
    public void Z(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, dVar) == null) {
            this.I = dVar;
        }
    }

    @Override // d.a.n0.a.p.e.b
    public void a0(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, eVar) == null) {
            this.G = eVar;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.n0.a.p.e.d
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.A : (String) invokeV.objValue;
    }

    @Override // d.a.n0.a.p.e.b
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? u().getParent() != null : invokeV.booleanValue;
    }

    @Override // d.a.n0.a.p.e.b
    @Nullable
    public d.a.n0.a.c0.e.a d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.F : (d.a.n0.a.c0.e.a) invokeV.objValue;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.n0.a.p.e.d
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            Y(null);
            U();
            super.destroy();
            d.a.n0.a.c1.a.F().i(this);
            d.a.n0.a.w2.k.a aVar = this.E;
            if (aVar != null) {
                aVar.f();
            }
            d.a.n0.a.c0.e.a aVar2 = this.F;
            if (aVar2 != null) {
                aVar2.c();
            }
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.n0.a.p.e.d
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

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.n0.a.p.e.d
    public void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            d.a.n0.a.i1.b.d(this.A);
            d.a.n0.a.y0.g.e.a().c(this.A);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.a.p.e.b
    @Nullable
    /* renamed from: g1 */
    public SwanAppWebViewWidget m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.C : (SwanAppWebViewWidget) invokeV.objValue;
    }

    @Override // d.a.n0.a.p.e.b
    public PullToRefreshBaseWebView h0() {
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

    public void h1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.M.c();
        }
    }

    @Override // d.a.n0.a.p.e.b
    public void i(d.a.n0.a.l1.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, bVar) == null) {
            this.M.h(bVar);
        }
    }

    @Override // d.a.n0.a.p.e.b
    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            SwanAppWebViewWidget swanAppWebViewWidget = this.C;
            d.a.n0.a.p.e.j.d O2 = swanAppWebViewWidget != null ? swanAppWebViewWidget.O() : this.L;
            return O2 != null && TextUtils.equals(O2.f46632g, "0") && O2.f46628c > 0;
        }
        return invokeV.booleanValue;
    }

    public final boolean i1(ViewGroup viewGroup, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048605, this, viewGroup, view)) == null) {
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

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, motionEvent)) == null) {
            SwanAppWebViewWidget swanAppWebViewWidget = this.C;
            if (swanAppWebViewWidget != null) {
                return swanAppWebViewWidget.isSlidable(motionEvent);
            }
            return this.f10937f.isSlidable(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.n0.a.p.e.b
    public String j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.K : (String) invokeV.objValue;
    }

    public final void j1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.A = String.valueOf(O);
            O++;
        }
    }

    @NonNull
    public SwanAppWebViewWidget k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? new SwanAppWebViewWidget(this.f10936e.getBaseContext()) : (SwanAppWebViewWidget) invokeV.objValue;
    }

    @Override // d.a.n0.a.p.e.b
    public void l(ViewGroup viewGroup, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048610, this, viewGroup, view) == null) || viewGroup == null || view == null || i1(viewGroup, view)) {
            return;
        }
        viewGroup.addView(view, new FrameLayout.LayoutParams(-1, -1));
    }

    public final void l1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            if (N) {
                Log.d("SwanAppSlaveManager", "onCalibrateFmp: =========== start with isNaPaintFlowDone=" + z);
                Log.d("SwanAppSlaveManager", "onCalibrateFmp: before calibrate mPaintTiming=" + this.L.toString());
            }
            this.L.d();
            long j = this.L.f46628c;
            String str = this.L.f46632g;
            if (N) {
                Log.d("SwanAppSlaveManager", "onCalibrateFmp: after calibrate mPaintTiming=" + this.L.toString());
            }
            if (N && (j <= 0 || TextUtils.isEmpty(str))) {
                throw new RuntimeException("onCalibratedFmp with illegal fmp=" + j + " , fmpType=" + str + " \n" + this.L.toString());
            }
            HybridUbcFlow p = h.p("startup");
            p.A("fmp_type", str);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
            ubcFlowEvent.h(j);
            ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE);
            p.C(ubcFlowEvent);
            p.B("value", "arrive_success");
            if (N) {
                Log.d("SwanAppSlaveManager", "onCalibrateFmp: ===========  end with fmp=" + j + " , fmpType=" + str + " , fmpTypeName=" + this.L.a());
            }
            if (z) {
                if (N) {
                    Log.d("SwanAppSlaveManager", "onCalibrateFmp: naPaintFlowDone with fmp=" + j + " , fmpType=" + str + " , fmpTypeName=" + this.L.a());
                }
                p.z(this);
            }
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.n0.a.p.e.d
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            super.loadUrl(str);
            if (d.a.n0.a.e0.d.d()) {
                d.a.n0.a.h0.e.b.b();
            }
        }
    }

    public final void n1(ViewGroup viewGroup, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048614, this, viewGroup, view) == null) || viewGroup == null || view == null || !i1(viewGroup, view)) {
            return;
        }
        viewGroup.removeView(view);
    }

    @Override // d.a.n0.a.p.e.b
    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.B : (String) invokeV.objValue;
    }

    public void o1(PullToRefreshBaseWebView pullToRefreshBaseWebView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, pullToRefreshBaseWebView) == null) || pullToRefreshBaseWebView == null) {
            return;
        }
        this.D.setOnRefreshListener(new a(this));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.n0.a.p.e.d
    public void onJSLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            d.a.n0.a.h0.u.g.N().m0(false);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.n0.a.p.e.d
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            super.onPause();
            this.M.d();
            d.a.n0.a.c1.a.F().f(this);
            SwanAppWebViewWidget swanAppWebViewWidget = this.C;
            if (swanAppWebViewWidget != null) {
                swanAppWebViewWidget.onPause();
            }
            if (d.a.n0.a.a2.e.i() != null) {
                d.a.n0.a.a2.e.i().E().y(false);
            }
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.n0.a.p.e.d
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            super.onResume();
            this.M.e();
            d.a.n0.a.c1.a.F().d(this);
            SwanAppWebViewWidget swanAppWebViewWidget = this.C;
            if (swanAppWebViewWidget != null) {
                swanAppWebViewWidget.onResume();
            }
            if (d.a.n0.a.a2.e.i() != null) {
                d.a.n0.a.a2.e.i().E().y(true);
            }
            p1();
        }
    }

    public final void p1() {
        NgWebView ngWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || d.a.n0.a.j1.e.b.d() || d.a.n0.a.j1.e.b.e()) {
            return;
        }
        SwanAppWebViewWidget swanAppWebViewWidget = this.C;
        if (swanAppWebViewWidget != null && swanAppWebViewWidget.u() != null) {
            ngWebView = this.C.u();
        } else {
            ngWebView = this.f10937f;
        }
        ngWebView.getSettings().setTextZoom(d.a.n0.a.j1.e.b.a(d.a.n0.a.j1.e.b.b()));
    }

    public void q1(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, dVar) == null) {
            this.J = dVar;
        }
    }

    @Override // d.a.n0.a.p.e.b
    public boolean t(int i2) {
        InterceptResult invokeI;
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048622, this, i2)) == null) {
            PullToRefreshNgWebView pullToRefreshNgWebView = this.D;
            if (pullToRefreshNgWebView == null || (neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) pullToRefreshNgWebView.getHeaderLoadingLayout()) == null) {
                return false;
            }
            return neutralHeaderLoadingLayout.p(i2);
        }
        return invokeI.booleanValue;
    }

    @Override // d.a.n0.a.p.e.b
    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            this.K = str;
            SwanAppWebViewWidget swanAppWebViewWidget = this.C;
            if (swanAppWebViewWidget != null) {
                swanAppWebViewWidget.x(str);
            }
        }
    }

    @Override // d.a.n0.a.p.e.b
    public boolean y(d.a.n0.a.c2.f.r0.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, dVar)) == null) {
            if (dVar != null && this.H != null) {
                PullToRefreshNgWebView pullToRefreshNgWebView = this.D;
                if (pullToRefreshNgWebView != null) {
                    pullToRefreshNgWebView.w(false);
                    this.D.setPullRefreshEnabled(false);
                }
                if (this.C == null) {
                    if (N && !(this.f10936e.getBaseContext() instanceof Activity)) {
                        Log.e("SwanAppSlaveManager", Log.getStackTraceString(new Exception("context is not activity.")));
                    }
                    SwanAppWebViewWidget k1 = k1();
                    this.C = k1;
                    k1.x(this.K);
                    this.C.O1(this);
                    if (!TextUtils.isEmpty(dVar.o)) {
                        this.C.b1(dVar.o);
                    }
                    if (dVar.l == null) {
                        dVar.l = d.a.n0.a.l1.e.a.a.d();
                    }
                    l(this.H, this.C.u());
                    if (this.C.u() != null) {
                        this.C.u().setVisibility(dVar.j ? 8 : 0);
                        p1();
                    }
                    this.C.N1(dVar.q);
                    this.C.loadUrl(dVar.n);
                    this.C.P1(dVar);
                    e eVar = this.G;
                    if (eVar != null) {
                        eVar.a(this.C);
                    }
                    d dVar2 = this.I;
                    if (dVar2 != null) {
                        this.C.Z(dVar2);
                    }
                    d dVar3 = this.J;
                    if (dVar3 != null) {
                        this.C.q1(dVar3);
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
