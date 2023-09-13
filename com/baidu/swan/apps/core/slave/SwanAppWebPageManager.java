package com.baidu.swan.apps.core.slave;

import android.util.Log;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.BdSailorWebViewClientExt;
import com.baidu.swan.apps.core.SwanAppWebViewManager;
import com.baidu.swan.apps.core.container.NgWebView;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.bo3;
import com.baidu.tieba.h82;
import com.baidu.tieba.m43;
import com.baidu.tieba.nx1;
import com.baidu.tieba.oh2;
import com.baidu.tieba.ou2;
import com.baidu.tieba.ph2;
import com.baidu.tieba.rr1;
import com.baidu.tieba.t22;
import com.baidu.tieba.u43;
import com.baidu.tieba.yx1;
import com.baidu.webkit.sdk.WebViewClient;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class SwanAppWebPageManager extends SwanAppWebViewManager implements nx1<NgWebView> {
    public static final boolean y = rr1.a;
    public yx1 w;
    public oh2 x;

    /* loaded from: classes4.dex */
    public class SwanAppSlaveWebviewClientExt extends BdSailorWebViewClientExt {

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public final /* synthetic */ long a;
            public final /* synthetic */ HybridUbcFlow b;

            public a(long j, HybridUbcFlow hybridUbcFlow) {
                this.a = j;
                this.b = hybridUbcFlow;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                if (SwanAppWebPageManager.this.w.c <= 0) {
                    j = this.a;
                } else {
                    j = SwanAppWebPageManager.this.w.c;
                }
                this.b.D("fmp_type", SwanAppWebPageManager.this.w.g);
                HybridUbcFlow hybridUbcFlow = this.b;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(j);
                hybridUbcFlow.F(ubcFlowEvent);
                hybridUbcFlow.C(SwanAppWebPageManager.this);
                if (SwanAppWebPageManager.y) {
                    Log.d("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + SwanAppWebPageManager.this.w.g + " , fmpTypeName=" + SwanAppWebPageManager.this.w.a());
                }
            }
        }

        public SwanAppSlaveWebviewClientExt() {
        }

        public /* synthetic */ SwanAppSlaveWebviewClientExt(SwanAppWebPageManager swanAppWebPageManager, ph2 ph2Var) {
            this();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstLayoutDidExt(bdSailorWebView, str);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebPageManager.y) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstPaintDidEx");
            }
            super.onFirstPaintDidExt(bdSailorWebView, str);
            SwanAppWebPageManager.this.w.a = System.currentTimeMillis();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageBackOrForwardExt(BdSailorWebView bdSailorWebView, int i) {
            if (SwanAppWebPageManager.y) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onGoBackOrForwardEx");
            }
            super.onPageBackOrForwardExt(bdSailorWebView, i);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPageCanBeScaledExt(BdSailorWebView bdSailorWebView, boolean z) {
            if (SwanAppWebPageManager.y) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onPageCanBeScaledEx");
            }
            super.onPageCanBeScaledExt(bdSailorWebView, z);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onPreloadUrlFoundExt(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebPageManager.y) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onPreloadUrlFoundEx：" + str);
            }
            super.onPreloadUrlFoundExt(bdSailorWebView, str);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            h82.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstContentfulPaintExt");
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            long currentTimeMillis = System.currentTimeMillis();
            if (SwanAppWebPageManager.y) {
                Log.d("SwanAppSlaveManager", "on fcp: real fcp = " + currentTimeMillis);
            }
            SwanAppWebPageManager.this.w.b = currentTimeMillis;
            u43.h().l().a(SwanAppWebPageManager.this.w.b);
            long b = SwanAppWebPageManager.this.w.b();
            if (SwanAppWebPageManager.y) {
                Log.d("SwanAppSlaveManager", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime=" + b + " , aligned search=false");
            }
            HybridUbcFlow p = m43.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_paint");
            ubcFlowEvent.h(b);
            p.F(ubcFlowEvent);
            t22.d().f();
            SwanAppWebPageManager.this.x.a();
            if (SwanAppWebPageManager.this.w.c == 0) {
                SwanAppWebPageManager.this.w.c = b;
                yx1 yx1Var = SwanAppWebPageManager.this.w;
                yx1Var.g = yx1Var.c(b);
                p.D("fmp_type", "1");
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent2.h(SwanAppWebPageManager.this.w.b);
                p.F(ubcFlowEvent2);
            }
            long F = ou2.g0().F();
            if (F < 0) {
                F = 3000;
            }
            bo3.c(new a(b, p), "fmp record", F, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            h82.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstScreenPaintFinishedExt");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppWebPageManager.this.w.c = System.currentTimeMillis();
            SwanAppWebPageManager.this.w.g = "0";
            u43.h().l().c(SwanAppWebPageManager.this.w.c);
            if (SwanAppWebPageManager.y) {
                Log.d("SwanAppSlaveManager", "on fmp: real fmp = " + SwanAppWebPageManager.this.w.c);
            }
            HybridUbcFlow d = m43.d("startup");
            if (d != null) {
                d.D("webviewComponent", "1");
                d.D("fmp_type", "0");
                d.E("value", "arrive_success");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppWebPageManager.this.w.c);
                ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE);
                d.F(ubcFlowEvent);
                d.C(SwanAppWebPageManager.this);
                yx1 yx1Var = SwanAppWebPageManager.this.w;
                h82.b("SwanAppSlaveManager", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppWebPageManager.this.w.c), " , fmpType=", yx1Var.g, " , fmpTypeName=", yx1Var.a());
                m43.t();
            }
            t22.d().g();
            SwanAppWebPageManager.this.x.c();
            SwanAppWebPageManager.this.x.b();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            h82.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppWebPageManager.this.w.e = System.currentTimeMillis();
            u43.h().l().e(SwanAppWebPageManager.this.w.e);
            if (SwanAppWebPageManager.y) {
                Log.d("SwanAppSlaveManager", "on fip: real fip = " + SwanAppWebPageManager.this.w.e);
            }
            if (SwanAppWebPageManager.this.w.c == 0) {
                HybridUbcFlow p = m43.p("startup");
                p.D("fmp_type", "3");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppWebPageManager.this.w.e);
                p.F(ubcFlowEvent);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            h82.k("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppWebPageManager.this.w.d = System.currentTimeMillis();
            u43.h().l().d(SwanAppWebPageManager.this.w.d);
            if (SwanAppWebPageManager.y) {
                Log.d("SwanAppSlaveManager", "on ftp: real ftp = " + SwanAppWebPageManager.this.w.d);
            }
            if (SwanAppWebPageManager.this.w.c == 0) {
                HybridUbcFlow p = m43.p("startup");
                p.D("fmp_type", "2");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppWebPageManager.this.w.d);
                p.F(ubcFlowEvent);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFullScreenModeExt(BdSailorWebView bdSailorWebView, boolean z, int i, int i2) {
            if (SwanAppWebPageManager.y) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onFullScreenModeEx");
            }
            super.onFullScreenModeExt(bdSailorWebView, z, i, i2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public String onGetErrorHtmlExt(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            if (SwanAppWebPageManager.y) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onGetErrorHtmlSailor");
            }
            return super.onGetErrorHtmlExt(bdSailorWebView, i, str, str2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onKeywordExtensionExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            if (SwanAppWebPageManager.y) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onKeywordExtensionEx");
            }
            return super.onKeywordExtensionExt(bdSailorWebView, str, str2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onSecurityCheckResultExt(BdSailorWebView bdSailorWebView, String str, WebViewClient.SecurityInfo securityInfo) {
            if (SwanAppWebPageManager.y) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onSecurityCheckResultEx");
            }
            super.onSecurityCheckResultExt(bdSailorWebView, str, securityInfo);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onUrlRedirectedExt(BdSailorWebView bdSailorWebView, String str, String str2) {
            if (SwanAppWebPageManager.y) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::onUrlRedirected");
            }
            super.onUrlRedirectedExt(bdSailorWebView, str, str2);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean shouldHandleImageExt(BdSailorWebView bdSailorWebView, String str, String str2, String str3, boolean z) {
            if (SwanAppWebPageManager.y) {
                Log.d("SwanAppSlaveManager", "SwanAppSlaveWebViewClient::canHandleImageEx");
            }
            return super.shouldHandleImageExt(bdSailorWebView, str, str2, str3, z);
        }
    }
}
