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
import com.baidu.android.common.others.lang.StringUtil;
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
import com.repackage.az1;
import com.repackage.b72;
import com.repackage.bd3;
import com.repackage.ch2;
import com.repackage.cz1;
import com.repackage.dq2;
import com.repackage.f43;
import com.repackage.ge2;
import com.repackage.gn2;
import com.repackage.h03;
import com.repackage.hq2;
import com.repackage.hx1;
import com.repackage.ia2;
import com.repackage.id3;
import com.repackage.mt2;
import com.repackage.n62;
import com.repackage.nh2;
import com.repackage.nm1;
import com.repackage.nq2;
import com.repackage.oh2;
import com.repackage.oj2;
import com.repackage.p13;
import com.repackage.q62;
import com.repackage.re2;
import com.repackage.rg1;
import com.repackage.tr1;
import com.repackage.u62;
import com.repackage.ul2;
import com.repackage.ut2;
import com.repackage.v12;
import com.repackage.vf3;
import com.repackage.w03;
import com.repackage.w12;
import com.repackage.we2;
import com.repackage.xe2;
import com.repackage.xw1;
import com.repackage.y62;
import com.repackage.ye2;
import com.repackage.ym1;
import com.repackage.zy1;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class SwanAppSlaveManager extends SwanAppWebViewManager implements nm1<NgWebView> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean M;
    public transient /* synthetic */ FieldHolder $fh;
    public vf3 A;
    @Nullable
    public xw1 B;
    public w12 C;
    public FrameLayout D;
    public v12 E;
    public v12 F;
    public String G;
    public ym1 H;
    public n62 I;
    public boolean J;
    public boolean K;
    public u62 L;
    public String w;
    public String x;
    public SwanAppWebViewWidget y;
    public PullToRefreshNgWebView z;

    /* loaded from: classes2.dex */
    public class SwanAppSlaveWebviewClientExt extends BdSailorWebViewClientExt {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppSlaveManager this$0;

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;
            public final /* synthetic */ HybridUbcFlow b;
            public final /* synthetic */ SwanAppSlaveWebviewClientExt c;

            public a(SwanAppSlaveWebviewClientExt swanAppSlaveWebviewClientExt, long j, HybridUbcFlow hybridUbcFlow) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {swanAppSlaveWebviewClientExt, Long.valueOf(j), hybridUbcFlow};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = swanAppSlaveWebviewClientExt;
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
                    SwanAppSlaveManager swanAppSlaveManager = this.c.this$0;
                    swanAppSlaveManager.L.f(swanAppSlaveManager.H.g, true);
                    this.c.this$0.L.d(ubcFlowEvent, false);
                    this.b.D("fmp_type", this.c.this$0.H.g);
                    HybridUbcFlow hybridUbcFlow = this.b;
                    hybridUbcFlow.F(ubcFlowEvent);
                    hybridUbcFlow.C(this.c.this$0);
                    if (SwanAppSlaveManager.M) {
                        Log.d("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + this.c.this$0.H.g + " , fmpTypeName=" + this.c.this$0.H.a());
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                hx1.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstContentfulPaintExt");
                super.onFirstContentfulPaintExt(bdSailorWebView, str);
                long currentTimeMillis = System.currentTimeMillis();
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", "on fcp: real fcp = " + currentTimeMillis);
                }
                this.this$0.H.b = currentTimeMillis;
                ut2.j().n().a(this.this$0.H.b);
                long b = this.this$0.H.b();
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime=" + b + " , aligned search=false");
                }
                HybridUbcFlow p = mt2.p("startup");
                if (this.this$0.o1()) {
                    this.this$0.L.e(true);
                    p.b("fmp_data_record", this.this$0.L);
                }
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_paint");
                ubcFlowEvent.h(b);
                p.F(ubcFlowEvent);
                tr1.d().f();
                this.this$0.I.a();
                if (this.this$0.H.c == 0) {
                    this.this$0.H.c = b;
                    ym1 ym1Var = this.this$0.H;
                    ym1Var.g = ym1Var.c(b);
                    p.D("fmp_type", "1");
                    UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent2.h(this.this$0.H.b);
                    p.F(ubcFlowEvent2);
                    this.this$0.L.f("1", false);
                    this.this$0.L.d(ubcFlowEvent2, false);
                    return;
                }
                long G = oj2.g0().G();
                if (G < 0) {
                    G = 3000;
                }
                bd3.c(new a(this, b, p), "fmp record", G, TimeUnit.MILLISECONDS);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdSailorWebView, str) == null) {
                hx1.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstImagePaintExt");
                super.onFirstImagePaintExt(bdSailorWebView, str);
                this.this$0.H.e = System.currentTimeMillis();
                ut2.j().n().g(this.this$0.H.e);
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", "on fip: real fip = " + this.this$0.H.e);
                }
                if (this.this$0.H.c == 0) {
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(this.this$0.H.e);
                    HybridUbcFlow p = mt2.p("startup");
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
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, bdSailorWebView, str) == null) {
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstPaintDidEx");
                }
                super.onFirstPaintDidExt(bdSailorWebView, str);
                this.this$0.H.a = System.currentTimeMillis();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, bdSailorWebView, str) == null) {
                hx1.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedExt");
                super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
                this.this$0.H.c = System.currentTimeMillis();
                this.this$0.H.g = "0";
                ut2.j().n().e(this.this$0.H.c);
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", "on fmp: real fmp = " + this.this$0.H.c);
                }
                HybridUbcFlow d = mt2.d("startup");
                if (d != null) {
                    d.D("webviewComponent", "1");
                    d.D("fmp_type", "0");
                    d.E("value", "arrive_success");
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(this.this$0.H.c);
                    ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE);
                    this.this$0.L.f("0", true);
                    this.this$0.L.d(ubcFlowEvent, true);
                    d.F(ubcFlowEvent);
                    d.C(this.this$0);
                    ym1 ym1Var = this.this$0.H;
                    hx1.b("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(this.this$0.H.c), " , fmpType=", ym1Var.g, " , fmpTypeName=", ym1Var.a());
                    mt2.t();
                }
                tr1.d().g();
                this.this$0.I.g();
                this.this$0.I.b();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, bdSailorWebView, str) == null) {
                hx1.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstTextPaintExt");
                super.onFirstTextPaintExt(bdSailorWebView, str);
                this.this$0.H.d = System.currentTimeMillis();
                ut2.j().n().f(this.this$0.H.d);
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", "on ftp: real ftp = " + this.this$0.H.d);
                }
                if (this.this$0.H.c == 0) {
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(this.this$0.H.d);
                    HybridUbcFlow p = mt2.p("startup");
                    p.D("fmp_type", "2");
                    p.F(ubcFlowEvent);
                    this.this$0.L.f("2", false);
                    this.this$0.L.d(ubcFlowEvent, false);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFullScreenModeExt(BdSailorWebView bdSailorWebView, boolean z, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{bdSailorWebView, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFullScreenModeEx");
                }
                super.onFullScreenModeExt(bdSailorWebView, z, i, i2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public String onGetErrorHtmlExt(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            InterceptResult invokeLILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLILL = interceptable.invokeLILL(1048583, this, bdSailorWebView, i, str, str2)) == null) {
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onGetErrorHtmlSailor");
                }
                return super.onGetErrorHtmlExt(bdSailorWebView, i, str, str2);
            }
            return (String) invokeLILL.objValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onJsCodeCacheFinished(JsCodeCacheResult jsCodeCacheResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsCodeCacheResult) == null) {
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", jsCodeCacheResult != null ? jsCodeCacheResult.toString() : StringUtil.NULL_STRING);
                }
                if (jsCodeCacheResult == null || !jsCodeCacheResult.isCacheUsed) {
                    return;
                }
                if (TextUtils.equals(jsCodeCacheResult.businessId, "appframe")) {
                    this.this$0.J = true;
                } else if (TextUtils.equals(jsCodeCacheResult.businessId, "appjs")) {
                    this.this$0.K = true;
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onKeywordExtensionExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, bdSailorWebView, str, str2)) == null) {
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onKeywordExtensionEx");
                }
                return super.onKeywordExtensionExt(bdSailorWebView, str, str2);
            }
            return invokeLLL.booleanValue;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageBackOrForwardExt(BdSailorWebView bdSailorWebView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048586, this, bdSailorWebView, i) == null) {
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onGoBackOrForwardEx");
                }
                super.onPageBackOrForwardExt(bdSailorWebView, i);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageCanBeScaledExt(BdSailorWebView bdSailorWebView, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048587, this, bdSailorWebView, z) == null) {
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onPageCanBeScaledEx");
                }
                super.onPageCanBeScaledExt(bdSailorWebView, z);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPreloadUrlFoundExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048588, this, bdSailorWebView, str) == null) {
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onPreloadUrlFoundEx：" + str);
                }
                super.onPreloadUrlFoundExt(bdSailorWebView, str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onSecurityCheckResultExt(BdSailorWebView bdSailorWebView, String str, WebViewClient.SecurityInfo securityInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048589, this, bdSailorWebView, str, securityInfo) == null) {
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onSecurityCheckResultEx");
                }
                super.onSecurityCheckResultExt(bdSailorWebView, str, securityInfo);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onUrlRedirectedExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048590, this, bdSailorWebView, str, str2) == null) {
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onUrlRedirected");
                }
                super.onUrlRedirectedExt(bdSailorWebView, str, str2);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean shouldHandleImageExt(BdSailorWebView bdSailorWebView, String str, String str2, String str3, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{bdSailorWebView, str, str2, str3, Boolean.valueOf(z)})) == null) {
                if (SwanAppSlaveManager.M) {
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

    /* loaded from: classes2.dex */
    public class a implements PullToRefreshBase.h<NgWebView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppSlaveManager a;

        public a(SwanAppSlaveManager swanAppSlaveManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanAppSlaveManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanAppSlaveManager;
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
                ul2.U().m(this.a.b(), new ia2("PullDownRefresh"));
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
        M = rg1.a;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.I = new n62(this);
        this.L = new u62();
    }

    @Override // com.repackage.nm1
    public void A(FrameLayout frameLayout, w03 w03Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, frameLayout, w03Var) == null) || frameLayout == null) {
            return;
        }
        frameLayout.setBackgroundColor(w03Var.e);
    }

    @Override // com.repackage.wl1
    public double B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 1.0d;
        }
        return invokeV.doubleValue;
    }

    @Override // com.repackage.nm1
    public void D(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            t().setVisibility(i);
            vf3 vf3Var = this.A;
            if (vf3Var != null) {
                vf3Var.h(i);
            }
            if (j0() != null) {
                j0().setVisibility(i);
            }
            SwanAppWebViewWidget swanAppWebViewWidget = this.y;
            if (swanAppWebViewWidget == null || swanAppWebViewWidget.t() == null) {
                return;
            }
            f43 params = this.y.getParams();
            this.y.t().setVisibility(i == 0 && params != null && !params.f ? 0 : 8);
        }
    }

    @Override // com.repackage.nm1
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            SwanAppWebViewWidget swanAppWebViewWidget = this.y;
            if (swanAppWebViewWidget == null || !swanAppWebViewWidget.t().canGoBack()) {
                return false;
            }
            this.y.t().goBack();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.nm1
    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? BdZeusUtil.isWebkitLoaded() : invokeV.booleanValue;
    }

    @Override // com.repackage.nm1
    public void N(y62 y62Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, y62Var) == null) || y62Var == null) {
            return;
        }
        if (M) {
            Log.d("SwanAppSlaveManager", "pathList item: " + y62Var.a);
        }
        this.b.getSettings().setCodeCacheSetting(az1.a("appjs", y62Var.a));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            String b = b();
            this.b.getCurrentWebView().addZeusPluginFactory(new oh2(b));
            this.b.getCurrentWebView().addZeusPluginFactory(new ge2(b));
            this.b.getCurrentWebView().addZeusPluginFactory(new ch2(b));
            this.b.getCurrentWebView().addZeusPluginFactory(new nh2(b));
            this.b.getCurrentWebView().addZeusPluginFactory(new re2(b));
            this.b.getCurrentWebView().addZeusPluginFactory(new xe2(b));
            this.b.getCurrentWebView().addZeusPluginFactory(new we2(b));
        }
    }

    @Override // com.repackage.nm1
    public ym1 O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.H : (ym1) invokeV.objValue;
    }

    @Override // com.repackage.nm1
    public void Q(FrameLayout frameLayout, w03 w03Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, frameLayout, w03Var) == null) || frameLayout == null) {
            return;
        }
        if (w03Var.f) {
            this.z = new PullToRefreshNgWebView(this.a.getBaseContext(), this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
            s(SwanAppConfigData.t(w03Var.d));
            r1(this.z);
            k(frameLayout, this.z);
        } else {
            k(frameLayout, t());
        }
        this.D = frameLayout;
        if (this.A == null) {
            this.A = new vf3(this.a.getBaseContext(), this, frameLayout);
        }
        if (this.B == null) {
            this.B = new xw1(this.a.getBaseContext(), this.A);
        }
    }

    @Override // com.repackage.nm1
    public int S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.nm1
    public void T(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.x = str;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void U0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.U0();
        }
    }

    @Override // com.repackage.nm1
    public void V() {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (activity = ul2.U().getActivity()) == null) {
            return;
        }
        id3.a(activity, activity.getWindow().getDecorView().getWindowToken());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void W0(SwanAppWebViewManager.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) {
            super.W0(dVar);
            dVar.a = true;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.X0();
            n1();
            p13 p13Var = new p13(this.h);
            p13Var.j(this);
            this.h.b(p13Var);
            this.H = new ym1();
            b1(new SwanAppSlaveWebviewClientExt(this, null));
        }
    }

    @Override // com.repackage.nm1
    public boolean Y(f43 f43Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, f43Var)) == null) {
            if (this.y != null) {
                if (!TextUtils.isEmpty(f43Var.k)) {
                    this.y.d1(f43Var.k);
                }
                this.y.S1(f43Var.m);
                this.y.loadUrl(f43Var.j);
                this.y.U1(f43Var);
                if (f43Var.h == null) {
                    f43Var.h = nq2.a();
                }
                if (this.y.t() != null) {
                    this.y.t().setVisibility(f43Var.f ? 8 : 0);
                }
                v12 v12Var = this.E;
                if (v12Var != null) {
                    this.y.b0(v12Var);
                }
                v12 v12Var2 = this.F;
                if (v12Var2 != null) {
                    this.y.t1(v12Var2);
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.nm1
    public boolean a0(f43 f43Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, f43Var)) == null) {
            SwanAppWebViewWidget swanAppWebViewWidget = this.y;
            if (swanAppWebViewWidget != null) {
                w12 w12Var = this.C;
                if (w12Var != null) {
                    w12Var.b(swanAppWebViewWidget);
                }
                if (this.E != null) {
                    this.E = null;
                }
                if (this.F != null) {
                    this.F = null;
                }
                q1(this.D, this.y.t());
                this.y.U1(f43Var);
                this.y.destroy();
                this.y = null;
                PullToRefreshNgWebView pullToRefreshNgWebView = this.z;
                if (pullToRefreshNgWebView != null) {
                    pullToRefreshNgWebView.setPullRefreshEnabled(true);
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.repackage.pm1
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.w : (String) invokeV.objValue;
    }

    @Override // com.repackage.nm1
    public void b0(v12 v12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, v12Var) == null) {
            this.E = v12Var;
        }
    }

    @Override // com.repackage.nm1
    public void c0(w12 w12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, w12Var) == null) {
            this.C = w12Var;
        }
    }

    @Override // com.repackage.nm1
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? t().getParent() != null : invokeV.booleanValue;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.repackage.pm1
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            a0(null);
            V();
            super.destroy();
            oj2.J().i(this);
            vf3 vf3Var = this.A;
            if (vf3Var != null) {
                vf3Var.f();
            }
            xw1 xw1Var = this.B;
            if (xw1Var != null) {
                xw1Var.b();
            }
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.repackage.pm1
    public void e(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, activity) == null) {
            super.e(activity);
            SwanAppWebViewWidget swanAppWebViewWidget = this.y;
            if (swanAppWebViewWidget != null) {
                swanAppWebViewWidget.e(activity);
            }
        }
    }

    @Override // com.repackage.nm1
    @Nullable
    public xw1 e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.B : (xw1) invokeV.objValue;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.repackage.pm1
    public void g0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            gn2.d(this.w);
            ye2.a().c(this.w);
        }
    }

    @Override // com.repackage.nm1
    public int h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? zy1.b(this.J, this.K) : invokeV.intValue;
    }

    @Override // com.repackage.nm1
    public void i(hq2 hq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, hq2Var) == null) {
            this.I.h(hq2Var);
        }
    }

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, motionEvent)) == null) {
            SwanAppWebViewWidget swanAppWebViewWidget = this.y;
            if (swanAppWebViewWidget != null) {
                return swanAppWebViewWidget.isSlidable(motionEvent);
            }
            return this.b.isSlidable(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.nm1
    public PullToRefreshBaseWebView j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            PullToRefreshNgWebView pullToRefreshNgWebView = this.z;
            if (pullToRefreshNgWebView == null) {
                return null;
            }
            return pullToRefreshNgWebView;
        }
        return (PullToRefreshBaseWebView) invokeV.objValue;
    }

    @Override // com.repackage.nm1
    public void k(ViewGroup viewGroup, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048605, this, viewGroup, view2) == null) || viewGroup == null || view2 == null || m1(viewGroup, view2)) {
            return;
        }
        viewGroup.addView(view2, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.repackage.nm1
    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            SwanAppWebViewWidget swanAppWebViewWidget = this.y;
            ym1 O = swanAppWebViewWidget != null ? swanAppWebViewWidget.O() : this.H;
            return O != null && TextUtils.equals(O.g, "0") && O.c > 0;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.nm1
    @Nullable
    /* renamed from: k1 */
    public SwanAppWebViewWidget l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.y : (SwanAppWebViewWidget) invokeV.objValue;
    }

    @Override // com.repackage.nm1
    public String l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.G : (String) invokeV.objValue;
    }

    public void l1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.I.c();
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.repackage.pm1
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            super.loadUrl(str);
            if (hx1.f()) {
                cz1.b();
            }
        }
    }

    public final boolean m1(ViewGroup viewGroup, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048612, this, viewGroup, view2)) == null) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (viewGroup.getChildAt(i) == view2) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.repackage.nm1
    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.x : (String) invokeV.objValue;
    }

    public final void n1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.w = q62.a();
        }
    }

    public final boolean o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? !this.I.c : invokeV.booleanValue;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.repackage.pm1
    public void onJSLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            b72.U().w0(false);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.repackage.pm1
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.onPause();
            this.I.d();
            oj2.J().f(this);
            SwanAppWebViewWidget swanAppWebViewWidget = this.y;
            if (swanAppWebViewWidget != null) {
                swanAppWebViewWidget.onPause();
            }
            if (h03.M() != null) {
                h03.M().P().y(false);
            }
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.repackage.pm1
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            super.onResume();
            this.I.e();
            oj2.J().d(this);
            SwanAppWebViewWidget swanAppWebViewWidget = this.y;
            if (swanAppWebViewWidget != null) {
                swanAppWebViewWidget.onResume();
            }
            if (h03.M() != null) {
                h03.M().P().y(true);
            }
            s1();
        }
    }

    @NonNull
    public SwanAppWebViewWidget p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? new SwanAppWebViewWidget(this.a.getBaseContext()) : (SwanAppWebViewWidget) invokeV.objValue;
    }

    public final void q1(ViewGroup viewGroup, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048620, this, viewGroup, view2) == null) || viewGroup == null || view2 == null || !m1(viewGroup, view2)) {
            return;
        }
        viewGroup.removeView(view2);
    }

    public void r1(PullToRefreshBaseWebView pullToRefreshBaseWebView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, pullToRefreshBaseWebView) == null) || pullToRefreshBaseWebView == null) {
            return;
        }
        this.z.setOnRefreshListener(new a(this));
    }

    @Override // com.repackage.nm1
    public boolean s(int i) {
        InterceptResult invokeI;
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048622, this, i)) == null) {
            PullToRefreshNgWebView pullToRefreshNgWebView = this.z;
            if (pullToRefreshNgWebView == null || (neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) pullToRefreshNgWebView.getHeaderLoadingLayout()) == null) {
                return false;
            }
            return neutralHeaderLoadingLayout.p(i);
        }
        return invokeI.booleanValue;
    }

    public final void s1() {
        NgWebView ngWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || dq2.e() || dq2.f()) {
            return;
        }
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null && swanAppWebViewWidget.t() != null) {
            ngWebView = this.y.t();
        } else {
            ngWebView = this.b;
        }
        ngWebView.getSettings().setTextZoom(dq2.a(dq2.b()));
    }

    public void t1(v12 v12Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, v12Var) == null) {
            this.F = v12Var;
        }
    }

    @Override // com.repackage.nm1
    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, str) == null) {
            this.G = str;
            SwanAppWebViewWidget swanAppWebViewWidget = this.y;
            if (swanAppWebViewWidget != null) {
                swanAppWebViewWidget.w(str);
            }
        }
    }

    @Override // com.repackage.nm1
    public boolean x(f43 f43Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, f43Var)) == null) {
            if (f43Var != null && this.D != null) {
                PullToRefreshNgWebView pullToRefreshNgWebView = this.z;
                if (pullToRefreshNgWebView != null) {
                    pullToRefreshNgWebView.w(false);
                    this.z.setPullRefreshEnabled(false);
                }
                if (this.y == null) {
                    if (M && !(this.a.getBaseContext() instanceof Activity)) {
                        Log.e("SwanAppSlaveManager", Log.getStackTraceString(new Exception("context is not activity.")));
                    }
                    SwanAppWebViewWidget p1 = p1();
                    this.y = p1;
                    p1.w(this.G);
                    this.y.T1(this);
                    if (!TextUtils.isEmpty(f43Var.k)) {
                        this.y.d1(f43Var.k);
                    }
                    if (f43Var.h == null) {
                        f43Var.h = nq2.a();
                    }
                    k(this.D, this.y.t());
                    if (this.y.t() != null) {
                        this.y.t().setVisibility(f43Var.f ? 8 : 0);
                        s1();
                    }
                    this.y.S1(f43Var.m);
                    this.y.loadUrl(f43Var.j);
                    this.y.U1(f43Var);
                    w12 w12Var = this.C;
                    if (w12Var != null) {
                        w12Var.a(this.y);
                    }
                    v12 v12Var = this.E;
                    if (v12Var != null) {
                        this.y.b0(v12Var);
                    }
                    v12 v12Var2 = this.F;
                    if (v12Var2 != null) {
                        this.y.t1(v12Var2);
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
