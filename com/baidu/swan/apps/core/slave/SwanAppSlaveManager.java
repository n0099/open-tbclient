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
import com.kwad.v8.NodeJS;
import com.repackage.a72;
import com.repackage.ai2;
import com.repackage.an1;
import com.repackage.ar2;
import com.repackage.bi2;
import com.repackage.bk2;
import com.repackage.c23;
import com.repackage.d72;
import com.repackage.ef2;
import com.repackage.eh1;
import com.repackage.gs1;
import com.repackage.h72;
import com.repackage.hm2;
import com.repackage.hu2;
import com.repackage.i22;
import com.repackage.ig3;
import com.repackage.j13;
import com.repackage.j22;
import com.repackage.jf2;
import com.repackage.kf2;
import com.repackage.kx1;
import com.repackage.l72;
import com.repackage.lf2;
import com.repackage.ln1;
import com.repackage.mz1;
import com.repackage.nz1;
import com.repackage.o72;
import com.repackage.od3;
import com.repackage.ph2;
import com.repackage.pz1;
import com.repackage.qq2;
import com.repackage.s43;
import com.repackage.te2;
import com.repackage.tn2;
import com.repackage.u03;
import com.repackage.uq2;
import com.repackage.ux1;
import com.repackage.va2;
import com.repackage.vd3;
import com.repackage.zt2;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class SwanAppSlaveManager extends SwanAppWebViewManager implements an1<NgWebView> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean M;
    public transient /* synthetic */ FieldHolder $fh;
    public ig3 A;
    @Nullable
    public kx1 B;
    public j22 C;
    public FrameLayout D;
    public i22 E;
    public i22 F;
    public String G;
    public ln1 H;
    public a72 I;
    public boolean J;
    public boolean K;
    public h72 L;
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
                ux1.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstContentfulPaintExt");
                super.onFirstContentfulPaintExt(bdSailorWebView, str);
                long currentTimeMillis = System.currentTimeMillis();
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", "on fcp: real fcp = " + currentTimeMillis);
                }
                this.this$0.H.b = currentTimeMillis;
                hu2.j().n().a(this.this$0.H.b);
                long b = this.this$0.H.b();
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime=" + b + " , aligned search=false");
                }
                HybridUbcFlow p = zt2.p(NodeJS.STARTUP_SCRIPT_NAME);
                if (this.this$0.p1()) {
                    this.this$0.L.e(true);
                    p.b("fmp_data_record", this.this$0.L);
                }
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_paint");
                ubcFlowEvent.h(b);
                p.F(ubcFlowEvent);
                gs1.d().f();
                this.this$0.I.a();
                if (this.this$0.H.c == 0) {
                    this.this$0.H.c = b;
                    ln1 ln1Var = this.this$0.H;
                    ln1Var.g = ln1Var.c(b);
                    p.D("fmp_type", "1");
                    UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent2.h(this.this$0.H.b);
                    p.F(ubcFlowEvent2);
                    this.this$0.L.f("1", false);
                    this.this$0.L.d(ubcFlowEvent2, false);
                    return;
                }
                long G = bk2.g0().G();
                if (G < 0) {
                    G = 3000;
                }
                od3.c(new a(this, b, p), "fmp record", G, TimeUnit.MILLISECONDS);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdSailorWebView, str) == null) {
                ux1.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstImagePaintExt");
                super.onFirstImagePaintExt(bdSailorWebView, str);
                this.this$0.H.e = System.currentTimeMillis();
                hu2.j().n().g(this.this$0.H.e);
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", "on fip: real fip = " + this.this$0.H.e);
                }
                if (this.this$0.H.c == 0) {
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(this.this$0.H.e);
                    HybridUbcFlow p = zt2.p(NodeJS.STARTUP_SCRIPT_NAME);
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
                ux1.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedExt");
                super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
                this.this$0.H.c = System.currentTimeMillis();
                this.this$0.H.g = "0";
                hu2.j().n().e(this.this$0.H.c);
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", "on fmp: real fmp = " + this.this$0.H.c);
                }
                HybridUbcFlow d = zt2.d(NodeJS.STARTUP_SCRIPT_NAME);
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
                    ln1 ln1Var = this.this$0.H;
                    ux1.b("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(this.this$0.H.c), " , fmpType=", ln1Var.g, " , fmpTypeName=", ln1Var.a());
                    zt2.t();
                }
                gs1.d().g();
                this.this$0.I.g();
                this.this$0.I.b();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, bdSailorWebView, str) == null) {
                ux1.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstTextPaintExt");
                super.onFirstTextPaintExt(bdSailorWebView, str);
                this.this$0.H.d = System.currentTimeMillis();
                hu2.j().n().f(this.this$0.H.d);
                if (SwanAppSlaveManager.M) {
                    Log.d("SwanAppSlaveManager", "on ftp: real ftp = " + this.this$0.H.d);
                }
                if (this.this$0.H.c == 0) {
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                    ubcFlowEvent.h(this.this$0.H.d);
                    HybridUbcFlow p = zt2.p(NodeJS.STARTUP_SCRIPT_NAME);
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
                hm2.U().m(this.a.c(), new va2("PullDownRefresh"));
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
        M = eh1.a;
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
        this.I = new a72(this);
        this.L = new h72();
    }

    @Override // com.repackage.an1
    public void B(FrameLayout frameLayout, j13 j13Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, frameLayout, j13Var) == null) || frameLayout == null) {
            return;
        }
        frameLayout.setBackgroundColor(j13Var.e);
    }

    @Override // com.repackage.jm1
    public double C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 1.0d;
        }
        return invokeV.doubleValue;
    }

    @Override // com.repackage.an1
    public void E(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            u().setVisibility(i);
            ig3 ig3Var = this.A;
            if (ig3Var != null) {
                ig3Var.h(i);
            }
            if (k0() != null) {
                k0().setVisibility(i);
            }
            SwanAppWebViewWidget swanAppWebViewWidget = this.y;
            if (swanAppWebViewWidget == null || swanAppWebViewWidget.u() == null) {
                return;
            }
            s43 params = this.y.getParams();
            this.y.u().setVisibility(i == 0 && params != null && !params.f ? 0 : 8);
        }
    }

    @Override // com.repackage.an1
    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            SwanAppWebViewWidget swanAppWebViewWidget = this.y;
            if (swanAppWebViewWidget == null || !swanAppWebViewWidget.u().canGoBack()) {
                return false;
            }
            this.y.u().goBack();
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.an1
    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? BdZeusUtil.isWebkitLoaded() : invokeV.booleanValue;
    }

    @Override // com.repackage.an1
    public void N(l72 l72Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, l72Var) == null) || l72Var == null) {
            return;
        }
        if (M) {
            Log.d("SwanAppSlaveManager", "pathList item: " + l72Var.a);
        }
        this.b.getSettings().setCodeCacheSetting(nz1.a("appjs", l72Var.a));
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            String c = c();
            this.b.getCurrentWebView().addZeusPluginFactory(new bi2(c));
            this.b.getCurrentWebView().addZeusPluginFactory(new te2(c));
            this.b.getCurrentWebView().addZeusPluginFactory(new ph2(c));
            this.b.getCurrentWebView().addZeusPluginFactory(new ai2(c));
            this.b.getCurrentWebView().addZeusPluginFactory(new ef2(c));
            this.b.getCurrentWebView().addZeusPluginFactory(new kf2(c));
            this.b.getCurrentWebView().addZeusPluginFactory(new jf2(c));
        }
    }

    @Override // com.repackage.an1
    public ln1 P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.H : (ln1) invokeV.objValue;
    }

    @Override // com.repackage.an1
    public void R(FrameLayout frameLayout, j13 j13Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, frameLayout, j13Var) == null) || frameLayout == null) {
            return;
        }
        if (j13Var.f) {
            this.z = new PullToRefreshNgWebView(this.a.getBaseContext(), this, PullToRefreshBase.HEADERTYPE.SWAN_APP_HEADER);
            t(SwanAppConfigData.t(j13Var.d));
            s1(this.z);
            l(frameLayout, this.z);
        } else {
            l(frameLayout, u());
        }
        this.D = frameLayout;
        if (this.A == null) {
            this.A = new ig3(this.a.getBaseContext(), this, frameLayout);
        }
        if (this.B == null) {
            this.B = new kx1(this.a.getBaseContext(), this.A);
        }
    }

    @Override // com.repackage.an1
    public int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.an1
    public void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.x = str;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void V0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.V0();
        }
    }

    @Override // com.repackage.an1
    public void W() {
        SwanAppActivity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (activity = hm2.U().getActivity()) == null) {
            return;
        }
        vd3.a(activity, activity.getWindow().getDecorView().getWindowToken());
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void X0(SwanAppWebViewManager.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) {
            super.X0(dVar);
            dVar.a = true;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.Y0();
            o1();
            c23 c23Var = new c23(this.h);
            c23Var.j(this);
            this.h.b(c23Var);
            this.H = new ln1();
            c1(new SwanAppSlaveWebviewClientExt(this, null));
        }
    }

    @Override // com.repackage.an1
    public boolean Z(s43 s43Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, s43Var)) == null) {
            if (this.y != null) {
                if (!TextUtils.isEmpty(s43Var.k)) {
                    this.y.e1(s43Var.k);
                }
                this.y.T1(s43Var.m);
                this.y.loadUrl(s43Var.j);
                this.y.V1(s43Var);
                if (s43Var.h == null) {
                    s43Var.h = ar2.a();
                }
                if (this.y.u() != null) {
                    this.y.u().setVisibility(s43Var.f ? 8 : 0);
                }
                i22 i22Var = this.E;
                if (i22Var != null) {
                    this.y.c0(i22Var);
                }
                i22 i22Var2 = this.F;
                if (i22Var2 != null) {
                    this.y.u1(i22Var2);
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.an1
    public boolean b0(s43 s43Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, s43Var)) == null) {
            SwanAppWebViewWidget swanAppWebViewWidget = this.y;
            if (swanAppWebViewWidget != null) {
                j22 j22Var = this.C;
                if (j22Var != null) {
                    j22Var.b(swanAppWebViewWidget);
                }
                if (this.E != null) {
                    this.E = null;
                }
                if (this.F != null) {
                    this.F = null;
                }
                r1(this.D, this.y.u());
                this.y.V1(s43Var);
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

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.repackage.cn1
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.w : (String) invokeV.objValue;
    }

    @Override // com.repackage.an1
    public void c0(i22 i22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, i22Var) == null) {
            this.E = i22Var;
        }
    }

    @Override // com.repackage.an1
    public void d0(j22 j22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, j22Var) == null) {
            this.C = j22Var;
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.repackage.cn1
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            b0(null);
            W();
            super.destroy();
            bk2.J().i(this);
            ig3 ig3Var = this.A;
            if (ig3Var != null) {
                ig3Var.f();
            }
            kx1 kx1Var = this.B;
            if (kx1Var != null) {
                kx1Var.b();
            }
        }
    }

    @Override // com.repackage.an1
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? u().getParent() != null : invokeV.booleanValue;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.repackage.cn1
    public void f(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, activity) == null) {
            super.f(activity);
            SwanAppWebViewWidget swanAppWebViewWidget = this.y;
            if (swanAppWebViewWidget != null) {
                swanAppWebViewWidget.f(activity);
            }
        }
    }

    @Override // com.repackage.an1
    @Nullable
    public kx1 f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.B : (kx1) invokeV.objValue;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.repackage.cn1
    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            tn2.d(this.w);
            lf2.a().c(this.w);
        }
    }

    @Override // com.repackage.an1
    public int i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? mz1.b(this.J, this.K) : invokeV.intValue;
    }

    @Override // com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, motionEvent)) == null) {
            SwanAppWebViewWidget swanAppWebViewWidget = this.y;
            if (swanAppWebViewWidget != null) {
                return swanAppWebViewWidget.isSlidable(motionEvent);
            }
            return this.b.isSlidable(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.an1
    public void j(uq2 uq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, uq2Var) == null) {
            this.I.h(uq2Var);
        }
    }

    @Override // com.repackage.an1
    public PullToRefreshBaseWebView k0() {
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

    @Override // com.repackage.an1
    public void l(ViewGroup viewGroup, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048605, this, viewGroup, view2) == null) || viewGroup == null || view2 == null || n1(viewGroup, view2)) {
            return;
        }
        viewGroup.addView(view2, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.repackage.an1
    public boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            SwanAppWebViewWidget swanAppWebViewWidget = this.y;
            ln1 P = swanAppWebViewWidget != null ? swanAppWebViewWidget.P() : this.H;
            return P != null && TextUtils.equals(P.g, "0") && P.c > 0;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an1
    @Nullable
    /* renamed from: l1 */
    public SwanAppWebViewWidget m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.y : (SwanAppWebViewWidget) invokeV.objValue;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.repackage.cn1
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            super.loadUrl(str);
            if (ux1.f()) {
                pz1.b();
            }
        }
    }

    @Override // com.repackage.an1
    public String m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.G : (String) invokeV.objValue;
    }

    public void m1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            this.I.c();
        }
    }

    public final boolean n1(ViewGroup viewGroup, View view2) {
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

    @Override // com.repackage.an1
    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.x : (String) invokeV.objValue;
    }

    public final void o1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            this.w = d72.a();
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.repackage.cn1
    public void onJSLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            o72.U().w0(false);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.repackage.cn1
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
            super.onPause();
            this.I.d();
            bk2.J().f(this);
            SwanAppWebViewWidget swanAppWebViewWidget = this.y;
            if (swanAppWebViewWidget != null) {
                swanAppWebViewWidget.onPause();
            }
            if (u03.L() != null) {
                u03.L().O().y(false);
            }
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.repackage.cn1
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.onResume();
            this.I.e();
            bk2.J().d(this);
            SwanAppWebViewWidget swanAppWebViewWidget = this.y;
            if (swanAppWebViewWidget != null) {
                swanAppWebViewWidget.onResume();
            }
            if (u03.L() != null) {
                u03.L().O().y(true);
            }
            t1();
        }
    }

    public final boolean p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? !this.I.c : invokeV.booleanValue;
    }

    @NonNull
    public SwanAppWebViewWidget q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? new SwanAppWebViewWidget(this.a.getBaseContext()) : (SwanAppWebViewWidget) invokeV.objValue;
    }

    public final void r1(ViewGroup viewGroup, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048620, this, viewGroup, view2) == null) || viewGroup == null || view2 == null || !n1(viewGroup, view2)) {
            return;
        }
        viewGroup.removeView(view2);
    }

    public void s1(PullToRefreshBaseWebView pullToRefreshBaseWebView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, pullToRefreshBaseWebView) == null) || pullToRefreshBaseWebView == null) {
            return;
        }
        this.z.setOnRefreshListener(new a(this));
    }

    @Override // com.repackage.an1
    public boolean t(int i) {
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

    public final void t1() {
        NgWebView ngWebView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048623, this) == null) || qq2.e() || qq2.f()) {
            return;
        }
        SwanAppWebViewWidget swanAppWebViewWidget = this.y;
        if (swanAppWebViewWidget != null && swanAppWebViewWidget.u() != null) {
            ngWebView = this.y.u();
        } else {
            ngWebView = this.b;
        }
        ngWebView.getSettings().setTextZoom(qq2.a(qq2.b()));
    }

    public void u1(i22 i22Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, i22Var) == null) {
            this.F = i22Var;
        }
    }

    @Override // com.repackage.an1
    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, str) == null) {
            this.G = str;
            SwanAppWebViewWidget swanAppWebViewWidget = this.y;
            if (swanAppWebViewWidget != null) {
                swanAppWebViewWidget.y(str);
            }
        }
    }

    @Override // com.repackage.an1
    public boolean z(s43 s43Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, s43Var)) == null) {
            if (s43Var != null && this.D != null) {
                PullToRefreshNgWebView pullToRefreshNgWebView = this.z;
                if (pullToRefreshNgWebView != null) {
                    pullToRefreshNgWebView.w(false);
                    this.z.setPullRefreshEnabled(false);
                }
                if (this.y == null) {
                    if (M && !(this.a.getBaseContext() instanceof Activity)) {
                        Log.e("SwanAppSlaveManager", Log.getStackTraceString(new Exception("context is not activity.")));
                    }
                    SwanAppWebViewWidget q1 = q1();
                    this.y = q1;
                    q1.y(this.G);
                    this.y.U1(this);
                    if (!TextUtils.isEmpty(s43Var.k)) {
                        this.y.e1(s43Var.k);
                    }
                    if (s43Var.h == null) {
                        s43Var.h = ar2.a();
                    }
                    l(this.D, this.y.u());
                    if (this.y.u() != null) {
                        this.y.u().setVisibility(s43Var.f ? 8 : 0);
                        t1();
                    }
                    this.y.T1(s43Var.m);
                    this.y.loadUrl(s43Var.j);
                    this.y.V1(s43Var);
                    j22 j22Var = this.C;
                    if (j22Var != null) {
                        j22Var.a(this.y);
                    }
                    i22 i22Var = this.E;
                    if (i22Var != null) {
                        this.y.c0(i22Var);
                    }
                    i22 i22Var2 = this.F;
                    if (i22Var2 != null) {
                        this.y.u1(i22Var2);
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
