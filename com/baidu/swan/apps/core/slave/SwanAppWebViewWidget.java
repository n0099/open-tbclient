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
import com.baidu.tieba.R;
import com.baidu.tieba.ar2;
import com.baidu.tieba.b72;
import com.baidu.tieba.c72;
import com.baidu.tieba.ck3;
import com.baidu.tieba.cu1;
import com.baidu.tieba.do1;
import com.baidu.tieba.fr1;
import com.baidu.tieba.g13;
import com.baidu.tieba.gt2;
import com.baidu.tieba.h72;
import com.baidu.tieba.h92;
import com.baidu.tieba.k83;
import com.baidu.tieba.ku1;
import com.baidu.tieba.ll3;
import com.baidu.tieba.me3;
import com.baidu.tieba.nk3;
import com.baidu.tieba.nl3;
import com.baidu.tieba.oz2;
import com.baidu.tieba.p72;
import com.baidu.tieba.rb3;
import com.baidu.tieba.s33;
import com.baidu.tieba.s73;
import com.baidu.tieba.t42;
import com.baidu.tieba.t62;
import com.baidu.tieba.tb3;
import com.baidu.tieba.y03;
import com.baidu.tieba.z03;
import com.baidu.tieba.z62;
import com.baidu.webkit.sdk.VideoPlayerFactory;
import com.baidu.webkit.sdk.WebChromeClient;
import com.baidu.webkit.sdk.WebResourceRequest;
import com.baidu.webkit.sdk.WebResourceResponse;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SwanAppWebViewWidget extends SwanAppSlaveManager implements cu1<NgWebView> {
    public static final boolean Z = do1.a;
    public static final String[] a0 = {"http", "https"};
    public g N;
    public f O;
    public e P;
    @Nullable
    public rb3 Q;
    public p72 R;
    public int S;
    public int T;
    public h92 U;
    public String V;
    public SwanAppSlaveManager W;
    public boolean X;
    public boolean Y;

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    public void L0() {
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.bu1
    public String b0() {
        return "ai_apps_widget";
    }

    /* loaded from: classes3.dex */
    public class SwanAppWebChromeClient extends BdSailorWebChromeClient {

        /* loaded from: classes3.dex */
        public class a implements p72.b {
            @Override // com.baidu.tieba.p72.b
            public void onCustomViewHidden() {
            }

            public a(SwanAppWebChromeClient swanAppWebChromeClient) {
            }
        }

        public SwanAppWebChromeClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onHideCustomView(BdSailorWebView bdSailorWebView) {
            SwanAppWebViewWidget.this.N1();
            return true;
        }

        public /* synthetic */ SwanAppWebChromeClient(SwanAppWebViewWidget swanAppWebViewWidget, a aVar) {
            this();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedTitle(BdSailorWebView bdSailorWebView, String str) {
            super.onReceivedTitle(bdSailorWebView, str);
            if (ll3.r(str)) {
                return;
            }
            SwanAppWebViewWidget.this.V = str;
            h92 h92Var = SwanAppWebViewWidget.this.U;
            if (h92Var != null) {
                h92Var.d(str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onShowCustomView(BdSailorWebView bdSailorWebView, View view2, int i, WebChromeClient.CustomViewCallback customViewCallback) {
            if (SwanAppWebViewWidget.this.R == null) {
                SwanAppWebViewWidget.this.R = new p72(SwanAppWebViewWidget.this.a.getBaseContext());
            }
            SwanAppWebViewWidget.this.R.c(view2, i, new a(this));
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onShowCustomView(BdSailorWebView bdSailorWebView, View view2, WebChromeClient.CustomViewCallback customViewCallback) {
            return onShowCustomView(bdSailorWebView, view2, 0, customViewCallback);
        }
    }

    /* loaded from: classes3.dex */
    public class SwanAppWebViewWidgetClientExt extends BdSailorWebViewClientExt {

        /* loaded from: classes3.dex */
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
                if (SwanAppWebViewWidget.this.H.c <= 0) {
                    j = this.a;
                } else {
                    j = SwanAppWebViewWidget.this.H.c;
                }
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(j);
                this.b.D("fmp_type", SwanAppWebViewWidget.this.H.g);
                SwanAppWebViewWidget swanAppWebViewWidget = SwanAppWebViewWidget.this;
                swanAppWebViewWidget.L.f(swanAppWebViewWidget.H.g, true);
                SwanAppWebViewWidget.this.L.d(ubcFlowEvent, false);
                HybridUbcFlow hybridUbcFlow = this.b;
                hybridUbcFlow.F(ubcFlowEvent);
                hybridUbcFlow.S();
                if (SwanAppWebViewWidget.Z) {
                    Log.d("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + SwanAppWebViewWidget.this.H.g + " , fmpTypeName=" + SwanAppWebViewWidget.this.H.a());
                }
            }
        }

        public SwanAppWebViewWidgetClientExt() {
        }

        public /* synthetic */ SwanAppWebViewWidgetClientExt(SwanAppWebViewWidget swanAppWebViewWidget, a aVar) {
            this();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstLayoutDidExt(bdSailorWebView, str);
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.G)) {
                y03.q("route", SwanAppWebViewWidget.this.G).F(new UbcFlowEvent("web_widget_first_layout"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstPaintDidExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.H.a = System.currentTimeMillis();
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.G)) {
                y03.q("route", SwanAppWebViewWidget.this.G).F(new UbcFlowEvent("web_widget_first_paint"));
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            t42.k("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstContentfulPaintExt");
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            long currentTimeMillis = System.currentTimeMillis();
            if (SwanAppWebViewWidget.Z) {
                Log.d("SwanAppWebViewWidget", "on fcp: real fcp = " + currentTimeMillis);
            }
            SwanAppWebViewWidget.this.H.b = currentTimeMillis;
            g13.h().l().a(SwanAppWebViewWidget.this.H.b);
            long b = SwanAppWebViewWidget.this.H.b();
            if (SwanAppWebViewWidget.Z) {
                Log.d("SwanAppWebViewWidget", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime" + b + " , aligned search=false");
            }
            HybridUbcFlow p = y03.p("startup");
            if (SwanAppWebViewWidget.this.m1()) {
                SwanAppWebViewWidget.this.L.e(true);
                p.b("fmp_data_record", SwanAppWebViewWidget.this.L);
            }
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_paint");
            ubcFlowEvent.h(b);
            p.F(ubcFlowEvent);
            if (SwanAppWebViewWidget.this.W != null) {
                SwanAppWebViewWidget.this.W.I.a();
            }
            if (SwanAppWebViewWidget.this.H.c == 0) {
                SwanAppWebViewWidget.this.H.c = b;
                ku1 ku1Var = SwanAppWebViewWidget.this.H;
                ku1Var.g = ku1Var.c(b);
                p.D("fmp_type", "1");
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent2.h(SwanAppWebViewWidget.this.H.b);
                p.F(ubcFlowEvent2);
                SwanAppWebViewWidget.this.L.f("1", false);
                SwanAppWebViewWidget.this.L.d(ubcFlowEvent2, false);
                return;
            }
            long F = ar2.g0().F();
            if (F < 0) {
                F = 3000;
            }
            nk3.c(new a(b, p), "fmp record", F, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            t42.k("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstScreenPaintFinishedEx");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.H.c = System.currentTimeMillis();
            SwanAppWebViewWidget.this.H.g = "0";
            g13.h().l().c(SwanAppWebViewWidget.this.H.c);
            if (SwanAppWebViewWidget.Z) {
                Log.d("SwanAppWebViewWidget", "on fmp: real fmp = " + SwanAppWebViewWidget.this.H.c);
            }
            HybridUbcFlow d = y03.d("startup");
            if (d != null) {
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                d.D("webviewComponent", str);
                d.D("fmp_type", "0");
                d.E("value", "arrive_success");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppWebViewWidget.this.H.c);
                ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE);
                SwanAppWebViewWidget.this.L.f("0", true);
                SwanAppWebViewWidget.this.L.d(ubcFlowEvent, true);
                d.F(ubcFlowEvent);
                d.S();
                ku1 ku1Var = SwanAppWebViewWidget.this.H;
                t42.b("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppWebViewWidget.this.H.c), " , fmpType=", ku1Var.g, " , fmpTypeName=", ku1Var.a());
                y03.t();
            }
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.G)) {
                z03.f(SwanAppWebViewWidget.this.G);
                SwanAppWebViewWidget.this.G = "";
            }
            if (SwanAppWebViewWidget.this.W != null) {
                SwanAppWebViewWidget.this.W.I.g();
                SwanAppWebViewWidget.this.W.I.b();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            t42.k("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.H.e = System.currentTimeMillis();
            g13.h().l().e(SwanAppWebViewWidget.this.H.e);
            if (SwanAppWebViewWidget.Z) {
                Log.d("SwanAppWebViewWidget", "on fip: real fip = " + SwanAppWebViewWidget.this.H.e);
            }
            if (SwanAppWebViewWidget.this.H.c == 0) {
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppWebViewWidget.this.H.e);
                HybridUbcFlow p = y03.p("startup");
                p.D("fmp_type", "3");
                p.F(ubcFlowEvent);
                SwanAppWebViewWidget.this.L.f("3", false);
                SwanAppWebViewWidget.this.L.d(ubcFlowEvent, false);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            t42.k("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.H.d = System.currentTimeMillis();
            g13.h().l().d(SwanAppWebViewWidget.this.H.d);
            if (SwanAppWebViewWidget.Z) {
                Log.d("SwanAppWebViewWidget", "on ftp: real ftp = " + SwanAppWebViewWidget.this.H.d);
            }
            if (SwanAppWebViewWidget.this.H.c == 0) {
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppWebViewWidget.this.H.d);
                HybridUbcFlow p = y03.p("startup");
                p.D("fmp_type", "2");
                p.F(ubcFlowEvent);
                SwanAppWebViewWidget.this.L.f("2", false);
                SwanAppWebViewWidget.this.L.d(ubcFlowEvent, false);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            if (ar2.g0().w() && SwanAppWebViewWidget.this.V1() && k83.k()) {
                return false;
            }
            if (ar2.g0().w() && SwanAppWebViewWidget.this.U1() && !k83.h(str)) {
                if (SwanAppWebViewWidget.Z) {
                    Log.d("SwanAppWebViewWidget", "WebSafeCheckers.checkWebDomain() failed url: " + str);
                    return true;
                }
                return true;
            }
            return super.onSubFrameBeforeRequest(bdSailorWebView, str);
        }
    }

    /* loaded from: classes3.dex */
    public class a implements oz2.b {
        public final /* synthetic */ String a;

        /* renamed from: com.baidu.swan.apps.core.slave.SwanAppWebViewWidget$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0183a implements Runnable {
            public RunnableC0183a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SwanAppWebViewWidget.this.r().loadUrl(a.this.a);
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                SwanAppWebViewWidget.this.W1(aVar.a);
                SwanAppWebViewWidget.this.L1().c("none");
            }
        }

        /* loaded from: classes3.dex */
        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                SwanAppWebViewWidget.this.W1(aVar.a);
                SwanAppWebViewWidget.this.L1().c("none");
            }
        }

        public a(String str) {
            this.a = str;
        }

        @Override // com.baidu.tieba.oz2.b
        public void a(JSONObject jSONObject) {
            t42.b("SwanAppWebViewWidget", "isblockdomain request success, response data: " + jSONObject + ", url: " + this.a);
            if (jSONObject != null && jSONObject.optInt("result", -1) == 0) {
                nl3.a0(new RunnableC0183a());
                return;
            }
            t42.o("SwanAppWebViewWidget", "isblockdomain request success, but check result failed: " + jSONObject + ", url: " + this.a);
            nl3.a0(new b());
        }

        @Override // com.baidu.tieba.oz2.b
        public void onFail(String str) {
            t42.o("SwanAppWebViewWidget", "isblockdomain request failed, msg: " + str + ", url: " + this.a);
            nl3.a0(new c());
        }
    }

    /* loaded from: classes3.dex */
    public class WebViewWidgetClient extends BdSailorWebViewClient {
        public WebViewWidgetClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void doUpdateVisitedHistory(BdSailorWebView bdSailorWebView, String str, boolean z) {
            super.doUpdateVisitedHistory(bdSailorWebView, str, z);
            me3.W(str, bdSailorWebView.getSettings().getUserAgentString());
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedHttpError(BdSailorWebView bdSailorWebView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            int i;
            super.onReceivedHttpError(bdSailorWebView, webResourceRequest, webResourceResponse);
            h92 h92Var = SwanAppWebViewWidget.this.U;
            if (h92Var != null) {
                if (webResourceResponse != null) {
                    i = webResourceResponse.getStatusCode();
                } else {
                    i = 0;
                }
                h92Var.b(i);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            t42.b("SwanAppWebViewWidget", "onPageFinished, url: " + str);
            if (SwanAppWebViewWidget.this.V1() && k83.k()) {
                SwanAppWebViewWidget.this.L1().c(str);
            } else {
                SwanAppWebViewWidget.this.L1().b();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageStarted(BdSailorWebView bdSailorWebView, String str, Bitmap bitmap) {
            t42.b("SwanAppWebViewWidget", "onPageStarted, url: " + str);
            if (SwanAppWebViewWidget.this.V1() && k83.k()) {
                SwanAppWebViewWidget.this.L1().f(str);
            } else {
                SwanAppWebViewWidget.this.L1().d();
            }
            SwanAppWebViewWidget.this.H1();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            super.onReceivedError(bdSailorWebView, i, str, str2);
            if (i == -10) {
                return;
            }
            SwanAppWebViewWidget.this.K1().c();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.Z) {
                Log.d("SwanAppWebViewWidget", "shouldOverrideUrlLoading url: " + str);
            }
            Uri A = nl3.A(str);
            if (A != null) {
                ck3.g(SwanAppWebViewWidget.this.a, new Intent("android.intent.action.DIAL", A));
                return true;
            }
            h92 h92Var = SwanAppWebViewWidget.this.F;
            if (h92Var != null) {
                return h92Var.a(str);
            }
            if (!s33.A()) {
                if (SwanAppWebViewWidget.Z) {
                    Log.w("SwanAppWebViewWidget", "checkWebHost: Debug下鉴权未开启");
                }
                return false;
            } else if (SwanAppWebViewWidget.this.I1(str)) {
                return true;
            } else {
                if (SwanAppWebViewWidget.this.U1() && !k83.h(str)) {
                    SwanAppWebViewWidget.this.W1(str);
                    return true;
                }
                return false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (!SwanAppNetworkUtils.i(SwanAppWebViewWidget.this.r().getContext())) {
                return;
            }
            if (SwanAppWebViewWidget.this.U1() && !k83.h(SwanAppWebViewWidget.this.r().getUrl())) {
                return;
            }
            SwanAppWebViewWidget.this.r().reload();
            SwanAppWebViewWidget.this.O.a();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements t62 {
        @Override // com.baidu.tieba.t62
        public boolean u(boolean z) {
            return z;
        }

        public c() {
        }

        @Override // com.baidu.tieba.t62
        public boolean o() {
            SwanAppWebViewWidget.this.J1().a();
            SwanAppWebViewWidget.this.r().setOnWebViewHookHandler(SwanAppWebViewWidget.this);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ z62 b;

        public d(View view2, z62 z62Var) {
            this.a = view2;
            this.b = z62Var;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (SwanAppWebViewWidget.Z) {
                Log.d("SwanAppWebViewWidget", "onGlobalLayout");
            }
            SwanAppWebViewWidget.this.P1(this.a, this.b);
        }
    }

    /* loaded from: classes3.dex */
    public static class e {
        public final DomainErrorView a;

        public e(@NonNull Context context, @NonNull ViewGroup viewGroup) {
            DomainErrorView domainErrorView = new DomainErrorView(context);
            this.a = domainErrorView;
            domainErrorView.setBackgroundColor(-1);
            viewGroup.addView(this.a, new FrameLayout.LayoutParams(-1, -1));
            this.a.setVisibility(8);
        }

        public void a() {
            this.a.setVisibility(8);
        }

        public void b(String str) {
            this.a.b(str);
            this.a.setVisibility(0);
        }
    }

    /* loaded from: classes3.dex */
    public static class f {
        public NetworkErrorView a;

        public f(@NonNull Context context, @NonNull ViewGroup viewGroup) {
            NetworkErrorView networkErrorView = new NetworkErrorView(context);
            this.a = networkErrorView;
            networkErrorView.setBackgroundColor(-1);
            viewGroup.addView(this.a, new FrameLayout.LayoutParams(-1, -1));
            this.a.setVisibility(8);
        }

        public void a() {
            this.a.setVisibility(8);
        }

        public void c() {
            this.a.setVisibility(0);
        }

        public void b(View.OnClickListener onClickListener) {
            this.a.setOnClickListener(onClickListener);
            this.a.setReloadClickListener(onClickListener);
        }
    }

    /* loaded from: classes3.dex */
    public static class g {
        public EfficientProgressBar a;
        public String b;

        public g(@NonNull Context context, @NonNull ViewGroup viewGroup) {
            this.a = null;
            EfficientProgressBar efficientProgressBar = new EfficientProgressBar(context);
            this.a = efficientProgressBar;
            efficientProgressBar.setProgressDrawable(context.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0801b4));
            this.a.setId(R.id.obfuscated_res_0x7f0901a9);
            this.a.setVisibility(4);
            this.a.setFocusable(false);
            this.a.setClickable(false);
            viewGroup.addView(this.a);
        }

        public void c(String str) {
            String substring;
            if (TextUtils.isEmpty(str)) {
                str = "none";
            }
            int indexOf = str.indexOf("#");
            if (indexOf != -1) {
                str = str.substring(0, indexOf);
            }
            int indexOf2 = this.b.indexOf("#");
            if (indexOf2 == -1) {
                substring = this.b;
            } else {
                substring = this.b.substring(0, indexOf2);
            }
            if (str.equals(substring)) {
                b();
            }
        }

        public void e(String str) {
            f(str);
            d();
        }

        public void f(String str) {
            if (TextUtils.isEmpty(str)) {
                this.b = "none";
            } else {
                this.b = str;
            }
        }

        public void g(int i) {
            this.a.setProgress(i, true);
        }

        public void b() {
            this.a.setProgress(100, true);
        }

        public void d() {
            this.a.f();
            g(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m1() {
        SwanAppSlaveManager swanAppSlaveManager = this.W;
        if (swanAppSlaveManager != null && !swanAppSlaveManager.I.c) {
            return true;
        }
        return false;
    }

    public final e J1() {
        if (this.P == null) {
            this.P = new e(r().getContext(), r());
        }
        return this.P;
    }

    public final f K1() {
        if (this.O == null) {
            f fVar = new f(r().getContext(), r());
            this.O = fVar;
            fVar.b(new b());
        }
        return this.O;
    }

    public g L1() {
        if (this.N == null) {
            this.N = new g(r().getContext(), r());
        }
        return this.N;
    }

    public int M1() {
        EfficientProgressBar efficientProgressBar;
        g gVar = this.N;
        if (gVar == null || (efficientProgressBar = gVar.a) == null) {
            return 0;
        }
        return efficientProgressBar.getHeight();
    }

    public final void N1() {
        p72 p72Var = this.R;
        if (p72Var != null) {
            p72Var.a();
        }
    }

    public final void O1() {
        R0("document.querySelector('video').pause();");
    }

    public final void T1() {
        this.b.getSettings().setLoadWithOverviewMode(true);
        this.b.getSettings().setUseWideViewPort(true);
        this.b.getSettings().setSupportZoom(true);
        this.b.getSettings().setBuiltInZoomControls(true);
        this.b.getSettings().setDisplayZoomControls(false);
    }

    public boolean U1() {
        return this.X;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    public void V0() {
        super.V0();
        tb3 tb3Var = new tb3(this.h);
        tb3Var.j(this);
        this.h.b(tb3Var);
    }

    public boolean V1() {
        return this.Y;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.bu1
    public void destroy() {
        this.U = null;
        super.destroy();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.bu1
    public void e0() {
        super.e0();
    }

    @Override // com.baidu.tieba.cu1
    @Nullable
    public rb3 getParams() {
        return this.Q;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.t62
    public boolean o() {
        L1().b();
        return false;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.bu1
    public void onPause() {
        super.onPause();
        O1();
    }

    public SwanAppWebViewWidget(Context context) {
        super(context);
        this.T = 0;
        this.X = true;
        this.Y = true;
        Y0(new WebViewWidgetClient());
        X0(new SwanAppWebChromeClient(this, null));
        Z0(new SwanAppWebViewWidgetClientExt(this, null));
        VideoPlayerFactory b2 = ar2.g().b();
        if (b2 != null) {
            this.b.getCurrentWebView().setVideoPlayerFactory(b2);
        }
        T1();
        X1(context);
        r().setOnWebViewHookHandler(this);
    }

    public final boolean I1(String str) {
        if (V1() && k83.k()) {
            if (k83.j(str)) {
                nl3.W(this.a, str);
                return true;
            } else if (!TextUtils.isEmpty(str) && !str.startsWith("http")) {
                return true;
            } else {
                oz2 oz2Var = new oz2();
                oz2Var.g(str);
                L1().e("none");
                oz2Var.d(new a(str));
                return true;
            }
        }
        return false;
    }

    public final void W1(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            URL url = new URL(str);
            for (String str2 : a0) {
                if (TextUtils.equals(url.getProtocol(), str2)) {
                    J1().b(str);
                    r().setOnWebViewHookHandler(new c());
                    return;
                }
            }
        } catch (MalformedURLException e2) {
            if (Z) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, com.baidu.tieba.bu1
    public void loadUrl(String str) {
        if (!s33.A()) {
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
            if (U1() && !k83.h(str)) {
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

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void Q0(SwanAppWebViewManager swanAppWebViewManager) {
        super.Q0(swanAppWebViewManager);
    }

    public void Q1(boolean z) {
        this.X = z;
    }

    public void R1(SwanAppSlaveManager swanAppSlaveManager) {
        this.W = swanAppSlaveManager;
    }

    public void S1(@Nullable rb3 rb3Var) {
        this.Q = rb3Var;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    public void U0(SwanAppWebViewManager.d dVar) {
        super.U0(dVar);
        dVar.a = false;
    }

    public final void X1(Context context) {
        fr1 a2 = s73.K().x().a().a();
        if (a2 != null) {
            a2.a(context);
        }
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.tieba.zt1
    public void Y(h92 h92Var) {
        this.U = h92Var;
    }

    public void H1() {
        z62 m;
        c72 V = gt2.U().V();
        if (V != null && (m = V.m()) != null && m.b0() != null) {
            View view2 = null;
            if (m instanceof b72) {
                if (((b72) m).r3().k() == null) {
                    return;
                }
                view2 = m.b0().findViewById(R.id.obfuscated_res_0x7f090180);
            } else if (m instanceof h72) {
                if (((h72) m).k() == null || m.b0() == null) {
                    return;
                }
                view2 = m.b0().findViewById(R.id.obfuscated_res_0x7f0921a9);
            }
            if (view2 == null) {
                return;
            }
            view2.getViewTreeObserver().addOnGlobalLayoutListener(new d(view2, m));
        }
    }

    public final void P1(View view2, z62 z62Var) {
        if (z62Var != null && !z62Var.n0()) {
            Rect rect = new Rect();
            view2.getWindowVisibleDisplayFrame(rect);
            int i = rect.bottom - rect.top;
            int i2 = this.S;
            if (i == i2) {
                return;
            }
            if (i2 - i > 200) {
                int i3 = 0;
                if (z62Var instanceof b72) {
                    b72 b72Var = (b72) z62Var;
                    if (b72Var.h2() && b72Var.G3()) {
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
    }
}
