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
import com.baidu.tieba.dw2;
import com.baidu.tieba.e92;
import com.baidu.tieba.ek2;
import com.baidu.tieba.ep1;
import com.baidu.tieba.et2;
import com.baidu.tieba.fk2;
import com.baidu.tieba.fm2;
import com.baidu.tieba.g43;
import com.baidu.tieba.h92;
import com.baidu.tieba.ih2;
import com.baidu.tieba.ij1;
import com.baidu.tieba.ku1;
import com.baidu.tieba.l92;
import com.baidu.tieba.lo2;
import com.baidu.tieba.lw2;
import com.baidu.tieba.m42;
import com.baidu.tieba.mi3;
import com.baidu.tieba.n33;
import com.baidu.tieba.n42;
import com.baidu.tieba.nh2;
import com.baidu.tieba.oh2;
import com.baidu.tieba.oz1;
import com.baidu.tieba.p92;
import com.baidu.tieba.ph2;
import com.baidu.tieba.pp1;
import com.baidu.tieba.q12;
import com.baidu.tieba.r12;
import com.baidu.tieba.s92;
import com.baidu.tieba.sf3;
import com.baidu.tieba.t12;
import com.baidu.tieba.tj2;
import com.baidu.tieba.us2;
import com.baidu.tieba.w63;
import com.baidu.tieba.xg2;
import com.baidu.tieba.xp2;
import com.baidu.tieba.y23;
import com.baidu.tieba.ys2;
import com.baidu.tieba.yz1;
import com.baidu.tieba.zc2;
import com.baidu.tieba.zf3;
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
/* loaded from: classes2.dex */
public class SwanAppSlaveManager extends SwanAppWebViewManager implements ep1<NgWebView> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean M;
    public transient /* synthetic */ FieldHolder $fh;
    public mi3 A;
    @Nullable
    public oz1 B;
    public n42 C;
    public FrameLayout D;
    public m42 E;
    public m42 F;
    public String G;
    public pp1 H;
    public e92 I;
    public boolean J;
    public boolean K;
    public l92 L;
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
                yz1.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstContentfulPaintExt");
                super.onFirstContentfulPaintExt(bdSailorWebView, str);
                long currentTimeMillis = System.currentTimeMillis();
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", "on fcp: real fcp = " + currentTimeMillis);
                }
                this.this$0.H.b = currentTimeMillis;
                lw2.h().l().a(this.this$0.H.b);
                long b = this.this$0.H.b();
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime=" + b + " , aligned search=false");
                }
                HybridUbcFlow p = dw2.p("startup");
                if (this.this$0.m1()) {
                    this.this$0.L.e(true);
                    p.b("fmp_data_record", this.this$0.L);
                }
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_paint");
                ubcFlowEvent.h(b);
                p.F(ubcFlowEvent);
                ku1.d().f();
                this.this$0.I.a();
                if (this.this$0.H.c == 0) {
                    this.this$0.H.c = b;
                    pp1 pp1Var = this.this$0.H;
                    pp1Var.g = pp1Var.c(b);
                    p.D("fmp_type", "1");
                    UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent2.h(this.this$0.H.b);
                    p.F(ubcFlowEvent2);
                    this.this$0.L.f("1", false);
                    this.this$0.L.d(ubcFlowEvent2, false);
                    return;
                }
                long F = fm2.g0().F();
                if (F < 0) {
                    F = 3000;
                }
                sf3.c(new a(this, b, p), "fmp record", F, TimeUnit.MILLISECONDS);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdSailorWebView, str) == null) {
                yz1.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstImagePaintExt");
                super.onFirstImagePaintExt(bdSailorWebView, str);
                this.this$0.H.e = System.currentTimeMillis();
                lw2.h().l().e(this.this$0.H.e);
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", "on fip: real fip = " + this.this$0.H.e);
                }
                if (this.this$0.H.c == 0) {
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(this.this$0.H.e);
                    HybridUbcFlow p = dw2.p("startup");
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
                yz1.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedExt");
                super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
                this.this$0.H.c = System.currentTimeMillis();
                this.this$0.H.g = "0";
                lw2.h().l().c(this.this$0.H.c);
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", "on fmp: real fmp = " + this.this$0.H.c);
                }
                HybridUbcFlow d = dw2.d("startup");
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
                    pp1 pp1Var = this.this$0.H;
                    yz1.b("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(this.this$0.H.c), " , fmpType=", pp1Var.g, " , fmpTypeName=", pp1Var.a());
                    dw2.t();
                }
                ku1.d().g();
                this.this$0.I.g();
                this.this$0.I.b();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, bdSailorWebView, str) == null) {
                yz1.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstTextPaintExt");
                super.onFirstTextPaintExt(bdSailorWebView, str);
                this.this$0.H.d = System.currentTimeMillis();
                lw2.h().l().d(this.this$0.H.d);
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", "on ftp: real ftp = " + this.this$0.H.d);
                }
                if (this.this$0.H.c == 0) {
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(this.this$0.H.d);
                    HybridUbcFlow p = dw2.p("startup");
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
                lo2.U().m(this.a.a(), new zc2("PullDownRefresh"));
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
        M = ij1.a;
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
        this.I = new e92(this);
        this.L = new l92();
    }

    @Override // com.baidu.tieba.no1
    public double A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 1.0d;
        }
        return invokeV.doubleValue;
    }

    @Override // com.baidu.tieba.ep1
    public void C(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            r().setVisibility(i);
            mi3 mi3Var = this.A;
            if (mi3Var != null) {
                mi3Var.h(i);
            }
            if (h0() != null) {
                h0().setVisibility(i);
            }
            SwanAppWebViewWidget swanAppWebViewWidget = this.y;
            if (swanAppWebViewWidget == null || swanAppWebViewWidget.r() == null) {
                return;
            }
            w63 params = this.y.getParams();
            this.y.r().setVisibility(i == 0 && params != null && !params.f ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.ep1
    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            SwanAppWebViewWidget swanAppWebViewWidget = this.y;
            if (swanAppWebViewWidget == null || !swanAppWebViewWidget.r().canGoBack()) {
                return false;
            }
            this.y.r().goBack();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ep1
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? BdZeusUtil.isWebkitLoaded() : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ep1
    public void L(p92 p92Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, p92Var) == null) || p92Var == null) {
            return;
        }
        if (M) {
            Log.d("SwanAppSlaveManager", "pathList item: " + p92Var.a);
        }
        this.b.getSettings().setCodeCacheSetting(r12.a("appjs", p92Var.a));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            String a2 = a();
            this.b.getCurrentWebView().addZeusPluginFactory(new fk2(a2));
            this.b.getCurrentWebView().addZeusPluginFactory(new xg2(a2));
            this.b.getCurrentWebView().addZeusPluginFactory(new tj2(a2));
            this.b.getCurrentWebView().addZeusPluginFactory(new ek2(a2));
            this.b.getCurrentWebView().addZeusPluginFactory(new ih2(a2));
            this.b.getCurrentWebView().addZeusPluginFactory(new oh2(a2));
            this.b.getCurrentWebView().addZeusPluginFactory(new nh2(a2));
        }
    }

    @Override // com.baidu.tieba.ep1
    public pp1 M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.H : (pp1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ep1
    public void O(FrameLayout frameLayout, n33 n33Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, frameLayout, n33Var) == null) || frameLayout == null) {
            return;
        }
        if (n33Var.f) {
            this.z = new PullToRefreshNgWebView(this.a.getBaseContext(), this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
            s(SwanAppConfigData.t(n33Var.d));
            p1(this.z);
            j(frameLayout, this.z);
        } else {
            j(frameLayout, r());
        }
        this.D = frameLayout;
        if (this.A == null) {
            this.A = new mi3(this.a.getBaseContext(), this, frameLayout);
        }
        if (this.B == null) {
            this.B = new oz1(this.a.getBaseContext(), this.A);
        }
    }

    @Override // com.baidu.tieba.ep1
    public int Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.ep1
    public void R(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.x = str;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.S0();
        }
    }

    @Override // com.baidu.tieba.ep1
    public void T() {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (activity = lo2.U().getActivity()) == null) {
            return;
        }
        zf3.a(activity, activity.getWindow().getDecorView().getWindowToken());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void U0(SwanAppWebViewManager.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dVar) == null) {
            super.U0(dVar);
            dVar.a = true;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.V0();
            l1();
            g43 g43Var = new g43(this.h);
            g43Var.j(this);
            this.h.b(g43Var);
            this.H = new pp1();
            Z0(new SwanAppSlaveWebviewClientExt(this, null));
        }
    }

    @Override // com.baidu.tieba.ep1
    public boolean W(w63 w63Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, w63Var)) == null) {
            if (this.y != null) {
                if (!TextUtils.isEmpty(w63Var.k)) {
                    this.y.b1(w63Var.k);
                }
                this.y.Q1(w63Var.m);
                this.y.loadUrl(w63Var.j);
                this.y.S1(w63Var);
                if (w63Var.h == null) {
                    w63Var.h = et2.a();
                }
                if (this.y.r() != null) {
                    this.y.r().setVisibility(w63Var.f ? 8 : 0);
                }
                m42 m42Var = this.E;
                if (m42Var != null) {
                    this.y.Y(m42Var);
                }
                m42 m42Var2 = this.F;
                if (m42Var2 != null) {
                    this.y.r1(m42Var2);
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ep1
    public boolean X(w63 w63Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, w63Var)) == null) {
            SwanAppWebViewWidget swanAppWebViewWidget = this.y;
            if (swanAppWebViewWidget != null) {
                n42 n42Var = this.C;
                if (n42Var != null) {
                    n42Var.b(swanAppWebViewWidget);
                }
                if (this.E != null) {
                    this.E = null;
                }
                if (this.F != null) {
                    this.F = null;
                }
                o1(this.D, this.y.r());
                this.y.S1(w63Var);
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

    @Override // com.baidu.tieba.ep1
    public void Y(m42 m42Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, m42Var) == null) {
            this.E = m42Var;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.gp1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.w : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ep1
    public void a0(n42 n42Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, n42Var) == null) {
            this.C = n42Var;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.gp1
    public void attachActivity(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, activity) == null) {
            super.attachActivity(activity);
            SwanAppWebViewWidget swanAppWebViewWidget = this.y;
            if (swanAppWebViewWidget != null) {
                swanAppWebViewWidget.attachActivity(activity);
            }
        }
    }

    @Override // com.baidu.tieba.ep1
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? r().getParent() != null : invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ep1
    @Nullable
    public oz1 c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.B : (oz1) invokeV.objValue;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.gp1
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            X(null);
            T();
            super.destroy();
            fm2.J().i(this);
            mi3 mi3Var = this.A;
            if (mi3Var != null) {
                mi3Var.f();
            }
            oz1 oz1Var = this.B;
            if (oz1Var != null) {
                oz1Var.b();
            }
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.gp1
    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            xp2.d(this.w);
            ph2.a().c(this.w);
        }
    }

    @Override // com.baidu.tieba.ep1
    public int f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? q12.b(this.J, this.K) : invokeV.intValue;
    }

    @Override // com.baidu.tieba.ep1
    public void h(ys2 ys2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, ys2Var) == null) {
            this.I.h(ys2Var);
        }
    }

    @Override // com.baidu.tieba.ep1
    public PullToRefreshBaseWebView h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            PullToRefreshNgWebView pullToRefreshNgWebView = this.z;
            if (pullToRefreshNgWebView == null) {
                return null;
            }
            return pullToRefreshNgWebView;
        }
        return (PullToRefreshBaseWebView) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ep1
    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            SwanAppWebViewWidget swanAppWebViewWidget = this.y;
            pp1 M2 = swanAppWebViewWidget != null ? swanAppWebViewWidget.M() : this.H;
            return M2 != null && TextUtils.equals(M2.g, "0") && M2.c > 0;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ep1
    @Nullable
    /* renamed from: i1 */
    public SwanAppWebViewWidget k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.y : (SwanAppWebViewWidget) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, motionEvent)) == null) {
            SwanAppWebViewWidget swanAppWebViewWidget = this.y;
            if (swanAppWebViewWidget != null) {
                return swanAppWebViewWidget.isSlidable(motionEvent);
            }
            return this.b.isSlidable(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ep1
    public void j(ViewGroup viewGroup, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048606, this, viewGroup, view2) == null) || viewGroup == null || view2 == null || k1(viewGroup, view2)) {
            return;
        }
        viewGroup.addView(view2, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.baidu.tieba.ep1
    public String j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.G : (String) invokeV.objValue;
    }

    public void j1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.I.c();
        }
    }

    public final boolean k1(ViewGroup viewGroup, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048610, this, viewGroup, view2)) == null) {
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

    public final void l1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.w = h92.a();
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.gp1
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            super.loadUrl(str);
            if (yz1.f()) {
                t12.b();
            }
        }
    }

    @Override // com.baidu.tieba.ep1
    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.x : (String) invokeV.objValue;
    }

    public final boolean m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? !this.I.c : invokeV.booleanValue;
    }

    @NonNull
    public SwanAppWebViewWidget n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? new SwanAppWebViewWidget(this.a.getBaseContext()) : (SwanAppWebViewWidget) invokeV.objValue;
    }

    public final void o1(ViewGroup viewGroup, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048616, this, viewGroup, view2) == null) || viewGroup == null || view2 == null || !k1(viewGroup, view2)) {
            return;
        }
        viewGroup.removeView(view2);
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.gp1
    public void onJSLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            s92.U().w0(false);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.gp1
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            super.onPause();
            this.I.d();
            fm2.J().f(this);
            SwanAppWebViewWidget swanAppWebViewWidget = this.y;
            if (swanAppWebViewWidget != null) {
                swanAppWebViewWidget.onPause();
            }
            if (y23.M() != null) {
                y23.M().P().y(false);
            }
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.gp1
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            super.onResume();
            this.I.e();
            fm2.J().d(this);
            SwanAppWebViewWidget swanAppWebViewWidget = this.y;
            if (swanAppWebViewWidget != null) {
                swanAppWebViewWidget.onResume();
            }
            if (y23.M() != null) {
                y23.M().P().y(true);
            }
            q1();
        }
    }

    public void p1(PullToRefreshBaseWebView pullToRefreshBaseWebView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, pullToRefreshBaseWebView) == null) || pullToRefreshBaseWebView == null) {
            return;
        }
        this.z.setOnRefreshListener(new a(this));
    }

    public final void q1() {
        NgWebView ngWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048621, this) == null) || us2.e() || us2.f()) {
            return;
        }
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null && swanAppWebViewWidget.r() != null) {
            ngWebView = this.y.r();
        } else {
            ngWebView = this.b;
        }
        ngWebView.getSettings().setTextZoom(us2.a(us2.b()));
    }

    public void r1(m42 m42Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, m42Var) == null) {
            this.F = m42Var;
        }
    }

    @Override // com.baidu.tieba.ep1
    public boolean s(int i) {
        InterceptResult invokeI;
        NeutralHeaderLoadingLayout neutralHeaderLoadingLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048623, this, i)) == null) {
            PullToRefreshNgWebView pullToRefreshNgWebView = this.z;
            if (pullToRefreshNgWebView == null || (neutralHeaderLoadingLayout = (NeutralHeaderLoadingLayout) pullToRefreshNgWebView.getHeaderLoadingLayout()) == null) {
                return false;
            }
            return neutralHeaderLoadingLayout.p(i);
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tieba.ep1
    public void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            this.G = str;
            SwanAppWebViewWidget swanAppWebViewWidget = this.y;
            if (swanAppWebViewWidget != null) {
                swanAppWebViewWidget.v(str);
            }
        }
    }

    @Override // com.baidu.tieba.ep1
    public boolean w(w63 w63Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, w63Var)) == null) {
            if (w63Var != null && this.D != null) {
                PullToRefreshNgWebView pullToRefreshNgWebView = this.z;
                if (pullToRefreshNgWebView != null) {
                    pullToRefreshNgWebView.w(false);
                    this.z.setPullRefreshEnabled(false);
                }
                if (this.y == null) {
                    if (M && !(this.a.getBaseContext() instanceof Activity)) {
                        Log.e("SwanAppSlaveManager", Log.getStackTraceString(new Exception("context is not activity.")));
                    }
                    SwanAppWebViewWidget n1 = n1();
                    this.y = n1;
                    n1.v(this.G);
                    this.y.R1(this);
                    if (!TextUtils.isEmpty(w63Var.k)) {
                        this.y.b1(w63Var.k);
                    }
                    if (w63Var.h == null) {
                        w63Var.h = et2.a();
                    }
                    j(this.D, this.y.r());
                    if (this.y.r() != null) {
                        this.y.r().setVisibility(w63Var.f ? 8 : 0);
                        q1();
                    }
                    this.y.Q1(w63Var.m);
                    this.y.loadUrl(w63Var.j);
                    this.y.S1(w63Var);
                    n42 n42Var = this.C;
                    if (n42Var != null) {
                        n42Var.a(this.y);
                    }
                    m42 m42Var = this.E;
                    if (m42Var != null) {
                        this.y.Y(m42Var);
                    }
                    m42 m42Var2 = this.F;
                    if (m42Var2 != null) {
                        this.y.r1(m42Var2);
                        return true;
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.ep1
    public void z(FrameLayout frameLayout, n33 n33Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048626, this, frameLayout, n33Var) == null) || frameLayout == null) {
            return;
        }
        frameLayout.setBackgroundColor(n33Var.e);
    }
}
