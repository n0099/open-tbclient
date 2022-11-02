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
import com.baidu.tieba.au2;
import com.baidu.tieba.c83;
import com.baidu.tieba.di2;
import com.baidu.tieba.dr2;
import com.baidu.tieba.e12;
import com.baidu.tieba.e43;
import com.baidu.tieba.eu2;
import com.baidu.tieba.fe2;
import com.baidu.tieba.fh3;
import com.baidu.tieba.jx2;
import com.baidu.tieba.ka2;
import com.baidu.tieba.kl2;
import com.baidu.tieba.kq1;
import com.baidu.tieba.ku2;
import com.baidu.tieba.ll2;
import com.baidu.tieba.ln2;
import com.baidu.tieba.m53;
import com.baidu.tieba.na2;
import com.baidu.tieba.oi2;
import com.baidu.tieba.ok1;
import com.baidu.tieba.qv1;
import com.baidu.tieba.ra2;
import com.baidu.tieba.rp2;
import com.baidu.tieba.rx2;
import com.baidu.tieba.s52;
import com.baidu.tieba.sj3;
import com.baidu.tieba.t43;
import com.baidu.tieba.t52;
import com.baidu.tieba.ti2;
import com.baidu.tieba.u02;
import com.baidu.tieba.ui2;
import com.baidu.tieba.va2;
import com.baidu.tieba.vi2;
import com.baidu.tieba.vq1;
import com.baidu.tieba.w22;
import com.baidu.tieba.x22;
import com.baidu.tieba.ya2;
import com.baidu.tieba.yg3;
import com.baidu.tieba.z22;
import com.baidu.tieba.zk2;
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
/* loaded from: classes3.dex */
public class SwanAppSlaveManager extends SwanAppWebViewManager implements kq1<NgWebView> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean M;
    public transient /* synthetic */ FieldHolder $fh;
    public sj3 A;
    @Nullable
    public u02 B;
    public t52 C;
    public FrameLayout D;
    public s52 E;
    public s52 F;
    public String G;
    public vq1 H;
    public ka2 I;
    public boolean J;
    public boolean K;
    public ra2 L;
    public String w;
    public String x;
    public SwanAppWebViewWidget y;
    public PullToRefreshNgWebView z;

    @Override // com.baidu.tieba.tp1
    public double A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 1.0d;
        }
        return invokeV.doubleValue;
    }

    @Override // com.baidu.tieba.kq1
    public int Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes3.dex */
    public class SwanAppSlaveWebviewClientExt extends BdSailorWebViewClientExt {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppSlaveManager this$0;

        /* loaded from: classes3.dex */
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

        public /* synthetic */ SwanAppSlaveWebviewClientExt(SwanAppSlaveManager swanAppSlaveManager, a aVar) {
            this(swanAppSlaveManager);
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
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, bdSailorWebView, str) == null) {
                e12.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstContentfulPaintExt");
                super.onFirstContentfulPaintExt(bdSailorWebView, str);
                long currentTimeMillis = System.currentTimeMillis();
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", "on fcp: real fcp = " + currentTimeMillis);
                }
                this.this$0.H.b = currentTimeMillis;
                rx2.h().l().a(this.this$0.H.b);
                long b = this.this$0.H.b();
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime=" + b + " , aligned search=false");
                }
                HybridUbcFlow p = jx2.p("startup");
                if (this.this$0.m1()) {
                    this.this$0.L.e(true);
                    p.b("fmp_data_record", this.this$0.L);
                }
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_paint");
                ubcFlowEvent.h(b);
                p.F(ubcFlowEvent);
                qv1.d().f();
                this.this$0.I.a();
                if (this.this$0.H.c == 0) {
                    this.this$0.H.c = b;
                    vq1 vq1Var = this.this$0.H;
                    vq1Var.g = vq1Var.c(b);
                    p.D("fmp_type", "1");
                    UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent2.h(this.this$0.H.b);
                    p.F(ubcFlowEvent2);
                    this.this$0.L.f("1", false);
                    this.this$0.L.d(ubcFlowEvent2, false);
                    return;
                }
                long F = ln2.g0().F();
                if (F < 0) {
                    F = 3000;
                }
                yg3.c(new a(this, b, p), "fmp record", F, TimeUnit.MILLISECONDS);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, bdSailorWebView, str) == null) {
                e12.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedExt");
                super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
                this.this$0.H.c = System.currentTimeMillis();
                this.this$0.H.g = "0";
                rx2.h().l().c(this.this$0.H.c);
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", "on fmp: real fmp = " + this.this$0.H.c);
                }
                HybridUbcFlow d = jx2.d("startup");
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
                    vq1 vq1Var = this.this$0.H;
                    e12.b("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(this.this$0.H.c), " , fmpType=", vq1Var.g, " , fmpTypeName=", vq1Var.a());
                    jx2.t();
                }
                qv1.d().g();
                this.this$0.I.g();
                this.this$0.I.b();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdSailorWebView, str) == null) {
                e12.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstImagePaintExt");
                super.onFirstImagePaintExt(bdSailorWebView, str);
                this.this$0.H.e = System.currentTimeMillis();
                rx2.h().l().e(this.this$0.H.e);
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", "on fip: real fip = " + this.this$0.H.e);
                }
                if (this.this$0.H.c == 0) {
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(this.this$0.H.e);
                    HybridUbcFlow p = jx2.p("startup");
                    p.D("fmp_type", "3");
                    p.F(ubcFlowEvent);
                    this.this$0.L.f("3", false);
                    this.this$0.L.d(ubcFlowEvent, false);
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, bdSailorWebView, str) == null) {
                e12.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstTextPaintExt");
                super.onFirstTextPaintExt(bdSailorWebView, str);
                this.this$0.H.d = System.currentTimeMillis();
                rx2.h().l().d(this.this$0.H.d);
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", "on ftp: real ftp = " + this.this$0.H.d);
                }
                if (this.this$0.H.c == 0) {
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(this.this$0.H.d);
                    HybridUbcFlow p = jx2.p("startup");
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
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsCodeCacheResult) == null) {
                if (SwanAppSlaveManager.M) {
                    if (jsCodeCacheResult != null) {
                        str = jsCodeCacheResult.toString();
                    } else {
                        str = StringUtil.NULL_STRING;
                    }
                    Log.d("SwanAppSlaveManager", str);
                }
                if (jsCodeCacheResult != null && jsCodeCacheResult.isCacheUsed) {
                    if (TextUtils.equals(jsCodeCacheResult.businessId, "appframe")) {
                        this.this$0.J = true;
                    } else if (TextUtils.equals(jsCodeCacheResult.businessId, "appjs")) {
                        this.this$0.K = true;
                    }
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
    }

    /* loaded from: classes3.dex */
    public class a implements PullToRefreshBase.h<NgWebView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanAppSlaveManager a;

        @Override // com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase.h
        public void a(PullToRefreshBase<NgWebView> pullToRefreshBase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pullToRefreshBase) == null) {
            }
        }

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
        public void b(PullToRefreshBase<NgWebView> pullToRefreshBase) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pullToRefreshBase) == null) {
                rp2.U().m(this.a.a(), new fe2("PullDownRefresh"));
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
        M = ok1.a;
    }

    @Override // com.baidu.tieba.kq1
    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            SwanAppWebViewWidget swanAppWebViewWidget = this.y;
            if (swanAppWebViewWidget != null && swanAppWebViewWidget.r().canGoBack()) {
                this.y.r().goBack();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.kq1
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return BdZeusUtil.isWebkitLoaded();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.kq1
    public vq1 M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.H;
        }
        return (vq1) invokeV.objValue;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.S0();
        }
    }

    @Override // com.baidu.tieba.kq1
    public void T() {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048587, this) != null) || (activity = rp2.U().getActivity()) == null) {
            return;
        }
        fh3.a(activity, activity.getWindow().getDecorView().getWindowToken());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.mq1
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.w;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kq1
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (r().getParent() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.kq1
    @Nullable
    public u02 c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.B;
        }
        return (u02) invokeV.objValue;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.mq1
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            X(null);
            T();
            super.destroy();
            ln2.J().i(this);
            sj3 sj3Var = this.A;
            if (sj3Var != null) {
                sj3Var.f();
            }
            u02 u02Var = this.B;
            if (u02Var != null) {
                u02Var.b();
            }
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.mq1
    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            dr2.d(this.w);
            vi2.a().c(this.w);
        }
    }

    @Override // com.baidu.tieba.kq1
    public int f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return w22.b(this.J, this.K);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.kq1
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kq1
    @Nullable
    /* renamed from: i1 */
    public SwanAppWebViewWidget k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.y;
        }
        return (SwanAppWebViewWidget) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kq1
    public String j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.G;
        }
        return (String) invokeV.objValue;
    }

    public void j1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.I.c();
        }
    }

    public final void l1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.w = na2.a();
        }
    }

    @Override // com.baidu.tieba.kq1
    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.x;
        }
        return (String) invokeV.objValue;
    }

    public final boolean m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return !this.I.c;
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public SwanAppWebViewWidget n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return new SwanAppWebViewWidget(this.a.getBaseContext());
        }
        return (SwanAppWebViewWidget) invokeV.objValue;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.mq1
    public void onJSLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            ya2.U().w0(false);
        }
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
        this.I = new ka2(this);
        this.L = new ra2();
    }

    @Override // com.baidu.tieba.kq1
    public void L(va2 va2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, va2Var) != null) || va2Var == null) {
            return;
        }
        if (M) {
            Log.d("SwanAppSlaveManager", "pathList item: " + va2Var.a);
        }
        this.b.getSettings().setCodeCacheSetting(x22.a("appjs", va2Var.a));
    }

    @Override // com.baidu.tieba.kq1
    public void R(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.x = str;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void U0(SwanAppWebViewManager.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dVar) == null) {
            super.U0(dVar);
            dVar.a = true;
        }
    }

    @Override // com.baidu.tieba.kq1
    public void Y(s52 s52Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, s52Var) == null) {
            this.E = s52Var;
        }
    }

    @Override // com.baidu.tieba.kq1
    public void a0(t52 t52Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, t52Var) == null) {
            this.C = t52Var;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.mq1
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

    @Override // com.baidu.tieba.kq1
    public void h(eu2 eu2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, eu2Var) == null) {
            this.I.h(eu2Var);
        }
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

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.mq1
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            super.loadUrl(str);
            if (e12.f()) {
                z22.b();
            }
        }
    }

    public void p1(PullToRefreshBaseWebView pullToRefreshBaseWebView) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048620, this, pullToRefreshBaseWebView) != null) || pullToRefreshBaseWebView == null) {
            return;
        }
        this.z.setOnRefreshListener(new a(this));
    }

    public void r1(s52 s52Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, s52Var) == null) {
            this.F = s52Var;
        }
    }

    @Override // com.baidu.tieba.kq1
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

    @Override // com.baidu.tieba.kq1
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

    @Override // com.baidu.tieba.kq1
    public void j(ViewGroup viewGroup, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048606, this, viewGroup, view2) != null) || viewGroup == null || view2 == null || k1(viewGroup, view2)) {
            return;
        }
        viewGroup.addView(view2, new FrameLayout.LayoutParams(-1, -1));
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

    public final void o1(ViewGroup viewGroup, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048616, this, viewGroup, view2) != null) || viewGroup == null || view2 == null || !k1(viewGroup, view2)) {
            return;
        }
        viewGroup.removeView(view2);
    }

    @Override // com.baidu.tieba.kq1
    public void z(FrameLayout frameLayout, t43 t43Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048626, this, frameLayout, t43Var) != null) || frameLayout == null) {
            return;
        }
        frameLayout.setBackgroundColor(t43Var.e);
    }

    @Override // com.baidu.tieba.kq1
    public void C(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            r().setVisibility(i);
            sj3 sj3Var = this.A;
            if (sj3Var != null) {
                sj3Var.h(i);
            }
            if (h0() != null) {
                h0().setVisibility(i);
            }
            SwanAppWebViewWidget swanAppWebViewWidget = this.y;
            if (swanAppWebViewWidget != null && swanAppWebViewWidget.r() != null) {
                c83 params = this.y.getParams();
                int i2 = 0;
                if (i == 0 && params != null && !params.f) {
                    z = true;
                } else {
                    z = false;
                }
                NgWebView r = this.y.r();
                if (!z) {
                    i2 = 8;
                }
                r.setVisibility(i2);
            }
        }
    }

    @Override // com.baidu.tieba.kq1
    public boolean X(c83 c83Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, c83Var)) == null) {
            SwanAppWebViewWidget swanAppWebViewWidget = this.y;
            if (swanAppWebViewWidget != null) {
                t52 t52Var = this.C;
                if (t52Var != null) {
                    t52Var.b(swanAppWebViewWidget);
                }
                if (this.E != null) {
                    this.E = null;
                }
                if (this.F != null) {
                    this.F = null;
                }
                o1(this.D, this.y.r());
                this.y.S1(c83Var);
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

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            String a2 = a();
            this.b.getCurrentWebView().addZeusPluginFactory(new ll2(a2));
            this.b.getCurrentWebView().addZeusPluginFactory(new di2(a2));
            this.b.getCurrentWebView().addZeusPluginFactory(new zk2(a2));
            this.b.getCurrentWebView().addZeusPluginFactory(new kl2(a2));
            this.b.getCurrentWebView().addZeusPluginFactory(new oi2(a2));
            this.b.getCurrentWebView().addZeusPluginFactory(new ui2(a2));
            this.b.getCurrentWebView().addZeusPluginFactory(new ti2(a2));
        }
    }

    @Override // com.baidu.tieba.kq1
    public void O(FrameLayout frameLayout, t43 t43Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048583, this, frameLayout, t43Var) != null) || frameLayout == null) {
            return;
        }
        if (t43Var.f) {
            this.z = new PullToRefreshNgWebView(this.a.getBaseContext(), this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
            s(SwanAppConfigData.t(t43Var.d));
            p1(this.z);
            j(frameLayout, this.z);
        } else {
            j(frameLayout, r());
        }
        this.D = frameLayout;
        if (this.A == null) {
            this.A = new sj3(this.a.getBaseContext(), this, frameLayout);
        }
        if (this.B == null) {
            this.B = new u02(this.a.getBaseContext(), this.A);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.V0();
            l1();
            m53 m53Var = new m53(this.h);
            m53Var.j(this);
            this.h.b(m53Var);
            this.H = new vq1();
            Z0(new SwanAppSlaveWebviewClientExt(this, null));
        }
    }

    @Override // com.baidu.tieba.kq1
    public boolean i0() {
        InterceptResult invokeV;
        vq1 vq1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            SwanAppWebViewWidget swanAppWebViewWidget = this.y;
            if (swanAppWebViewWidget != null) {
                vq1Var = swanAppWebViewWidget.M();
            } else {
                vq1Var = this.H;
            }
            if (vq1Var != null && TextUtils.equals(vq1Var.g, "0") && vq1Var.c > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.mq1
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            super.onPause();
            this.I.d();
            ln2.J().f(this);
            SwanAppWebViewWidget swanAppWebViewWidget = this.y;
            if (swanAppWebViewWidget != null) {
                swanAppWebViewWidget.onPause();
            }
            if (e43.M() != null) {
                e43.M().P().y(false);
            }
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.mq1
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            super.onResume();
            this.I.e();
            ln2.J().d(this);
            SwanAppWebViewWidget swanAppWebViewWidget = this.y;
            if (swanAppWebViewWidget != null) {
                swanAppWebViewWidget.onResume();
            }
            if (e43.M() != null) {
                e43.M().P().y(true);
            }
            q1();
        }
    }

    public final void q1() {
        NgWebView ngWebView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048621, this) != null) || au2.e() || au2.f()) {
            return;
        }
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null && swanAppWebViewWidget.r() != null) {
            ngWebView = this.y.r();
        } else {
            ngWebView = this.b;
        }
        ngWebView.getSettings().setTextZoom(au2.a(au2.b()));
    }

    @Override // com.baidu.tieba.kq1
    public boolean W(c83 c83Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, c83Var)) == null) {
            int i = 0;
            if (this.y == null) {
                return false;
            }
            if (!TextUtils.isEmpty(c83Var.k)) {
                this.y.b1(c83Var.k);
            }
            this.y.Q1(c83Var.m);
            this.y.loadUrl(c83Var.j);
            this.y.S1(c83Var);
            if (c83Var.h == null) {
                c83Var.h = ku2.a();
            }
            if (this.y.r() != null) {
                NgWebView r = this.y.r();
                if (c83Var.f) {
                    i = 8;
                }
                r.setVisibility(i);
            }
            s52 s52Var = this.E;
            if (s52Var != null) {
                this.y.Y(s52Var);
            }
            s52 s52Var2 = this.F;
            if (s52Var2 != null) {
                this.y.r1(s52Var2);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.kq1
    public boolean w(c83 c83Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, c83Var)) == null) {
            int i = 0;
            if (c83Var != null && this.D != null) {
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
                    if (!TextUtils.isEmpty(c83Var.k)) {
                        this.y.b1(c83Var.k);
                    }
                    if (c83Var.h == null) {
                        c83Var.h = ku2.a();
                    }
                    j(this.D, this.y.r());
                    if (this.y.r() != null) {
                        NgWebView r = this.y.r();
                        if (c83Var.f) {
                            i = 8;
                        }
                        r.setVisibility(i);
                        q1();
                    }
                    this.y.Q1(c83Var.m);
                    this.y.loadUrl(c83Var.j);
                    this.y.S1(c83Var);
                    t52 t52Var = this.C;
                    if (t52Var != null) {
                        t52Var.a(this.y);
                    }
                    s52 s52Var = this.E;
                    if (s52Var != null) {
                        this.y.Y(s52Var);
                    }
                    s52 s52Var2 = this.F;
                    if (s52Var2 != null) {
                        this.y.r1(s52Var2);
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
