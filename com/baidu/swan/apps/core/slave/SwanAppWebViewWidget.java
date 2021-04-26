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
import com.baidu.webkit.sdk.VideoPlayerFactory;
import com.baidu.webkit.sdk.WebChromeClient;
import d.a.h0.a.e0.m.e;
import d.a.h0.a.i2.i0;
import d.a.h0.a.i2.k0;
import d.a.h0.a.i2.p;
import d.a.h0.a.j1.i;
import d.a.h0.a.j1.j;
import d.a.h0.a.j1.l.f;
import d.a.h0.a.k;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class SwanAppWebViewWidget extends SwanAppSlaveManager implements d.a.h0.a.p.d.e<NgWebView> {
    public static final boolean Y = k.f43101a;
    public static final String[] Z = {"http", "https"};
    public e O;
    public d P;
    public c Q;
    @Nullable
    public d.a.h0.a.t1.k.r0.d R;
    public d.a.h0.a.e0.m.e S;
    public int T;
    public d.a.h0.a.e0.n.d U;
    public String V;
    public boolean W;
    public int X;

    /* loaded from: classes2.dex */
    public class SwanAppWebChromeClient extends BdSailorWebChromeClient {

        /* loaded from: classes2.dex */
        public class a implements e.a {
            public a(SwanAppWebChromeClient swanAppWebChromeClient) {
            }

            @Override // d.a.h0.a.e0.m.e.a
            public void onCustomViewHidden() {
            }
        }

        public SwanAppWebChromeClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onHideCustomView(BdSailorWebView bdSailorWebView) {
            SwanAppWebViewWidget.this.A1();
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedTitle(BdSailorWebView bdSailorWebView, String str) {
            super.onReceivedTitle(bdSailorWebView, str);
            if (i0.p(str)) {
                return;
            }
            SwanAppWebViewWidget.this.V = str;
            d.a.h0.a.e0.n.d dVar = SwanAppWebViewWidget.this.U;
            if (dVar != null) {
                dVar.a(str);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onShowCustomView(BdSailorWebView bdSailorWebView, View view, WebChromeClient.CustomViewCallback customViewCallback) {
            return onShowCustomView(bdSailorWebView, view, 0, customViewCallback);
        }

        public /* synthetic */ SwanAppWebChromeClient(SwanAppWebViewWidget swanAppWebViewWidget, a aVar) {
            this();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onShowCustomView(BdSailorWebView bdSailorWebView, View view, int i2, WebChromeClient.CustomViewCallback customViewCallback) {
            if (SwanAppWebViewWidget.this.S == null) {
                SwanAppWebViewWidget.this.S = new d.a.h0.a.e0.m.e(SwanAppWebViewWidget.this.f11656e.getBaseContext());
            }
            SwanAppWebViewWidget.this.S.c(view, i2, new a(this));
            return true;
        }
    }

    /* loaded from: classes2.dex */
    public class SwanAppWebViewWidgetClientExt extends BdSailorWebViewClientExt {

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ long f11692e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ HybridUbcFlow f11693f;

            public a(long j, HybridUbcFlow hybridUbcFlow) {
                this.f11692e = j;
                this.f11693f = hybridUbcFlow;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                if (i.f42928b) {
                    if (SwanAppWebViewWidget.Y) {
                        Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from fcp delay");
                    }
                    SwanAppWebViewWidget.this.d1(true);
                    return;
                }
                if (SwanAppWebViewWidget.this.L.f43522c <= 0) {
                    j = this.f11692e;
                } else {
                    j = SwanAppWebViewWidget.this.L.f43522c;
                }
                this.f11693f.y("fmp_type", SwanAppWebViewWidget.this.L.f43526g);
                HybridUbcFlow hybridUbcFlow = this.f11693f;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(j);
                hybridUbcFlow.A(ubcFlowEvent);
                hybridUbcFlow.N();
                if (SwanAppWebViewWidget.Y) {
                    Log.d("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + SwanAppWebViewWidget.this.L.f43526g + " , fmpTypeName=" + SwanAppWebViewWidget.this.L.a());
                }
            }
        }

        public SwanAppWebViewWidgetClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            d.a.h0.a.c0.c.h("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstContentfulPaintExt");
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            long currentTimeMillis = System.currentTimeMillis();
            if (SwanAppWebViewWidget.Y) {
                Log.d("SwanAppWebViewWidget", "on fcp: real fcp = " + currentTimeMillis);
            }
            SwanAppWebViewWidget.this.L.f43521b = currentTimeMillis;
            f.h().l().a(SwanAppWebViewWidget.this.L.f43521b);
            long b2 = i.f42928b ? currentTimeMillis : SwanAppWebViewWidget.this.L.b();
            if (SwanAppWebViewWidget.Y) {
                Log.d("SwanAppWebViewWidget", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime" + b2 + " , aligned search=" + i.f42928b);
            }
            HybridUbcFlow o = i.o("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_paint");
            ubcFlowEvent.h(b2);
            o.A(ubcFlowEvent);
            if (SwanAppWebViewWidget.this.L.f43522c == 0) {
                SwanAppWebViewWidget.this.L.f43522c = b2;
                d.a.h0.a.p.d.j.d dVar = SwanAppWebViewWidget.this.L;
                dVar.f43526g = dVar.c(b2);
                o.y("fmp_type", "1");
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent2.h(SwanAppWebViewWidget.this.L.f43521b);
                o.A(ubcFlowEvent2);
            }
            long K = d.a.h0.a.w0.a.N().K();
            if (K < 0) {
                K = 3000;
            }
            p.c(new a(b2, o), "fmp record", K, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            d.a.h0.a.c0.c.h("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.L.f43524e = System.currentTimeMillis();
            f.h().l().f(SwanAppWebViewWidget.this.L.f43524e);
            if (SwanAppWebViewWidget.Y) {
                Log.d("SwanAppWebViewWidget", "on fip: real fip = " + SwanAppWebViewWidget.this.L.f43524e);
            }
            if (i.f42928b) {
                if (SwanAppWebViewWidget.Y) {
                    Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from fip");
                }
                SwanAppWebViewWidget.this.d1(false);
            } else if (SwanAppWebViewWidget.this.L.f43522c == 0) {
                HybridUbcFlow o = i.o("startup");
                o.y("fmp_type", "3");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppWebViewWidget.this.L.f43524e);
                o.A(ubcFlowEvent);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstLayoutDidExt(bdSailorWebView, str);
            if (TextUtils.isEmpty(SwanAppWebViewWidget.this.K)) {
                return;
            }
            i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, SwanAppWebViewWidget.this.K).A(new UbcFlowEvent("web_widget_first_layout"));
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstPaintDidExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.L.f43520a = System.currentTimeMillis();
            if (TextUtils.isEmpty(SwanAppWebViewWidget.this.K)) {
                return;
            }
            i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, SwanAppWebViewWidget.this.K).A(new UbcFlowEvent("web_widget_first_paint"));
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            d.a.h0.a.c0.c.h("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstScreenPaintFinishedEx");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.L.f43522c = System.currentTimeMillis();
            SwanAppWebViewWidget.this.L.f43526g = "0";
            f.h().l().d(SwanAppWebViewWidget.this.L.f43522c);
            if (SwanAppWebViewWidget.Y) {
                Log.d("SwanAppWebViewWidget", "on fmp: real fmp = " + SwanAppWebViewWidget.this.L.f43522c);
            }
            HybridUbcFlow d2 = i.d("startup");
            if (d2 != null) {
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                d2.y("webviewComponent", str);
                d2.y("fmp_type", "0");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppWebViewWidget.this.L.f43522c);
                ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE);
                d2.A(ubcFlowEvent);
                d2.N();
                d2.z("value", "arrive_success");
                d.a.h0.a.p.d.j.d dVar = SwanAppWebViewWidget.this.L;
                d.a.h0.a.c0.c.a("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppWebViewWidget.this.L.f43522c), " , fmpType=", dVar.f43526g, " , fmpTypeName=", dVar.a());
                i.s();
            }
            if (TextUtils.isEmpty(SwanAppWebViewWidget.this.K)) {
                return;
            }
            j.f(SwanAppWebViewWidget.this.K);
            SwanAppWebViewWidget.this.K = "";
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            d.a.h0.a.c0.c.h("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.L.f43523d = System.currentTimeMillis();
            f.h().l().e(SwanAppWebViewWidget.this.L.f43523d);
            if (SwanAppWebViewWidget.Y) {
                Log.d("SwanAppWebViewWidget", "on ftp: real ftp = " + SwanAppWebViewWidget.this.L.f43523d);
            }
            if (i.f42928b) {
                if (SwanAppWebViewWidget.Y) {
                    Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from ftp");
                }
                SwanAppWebViewWidget.this.d1(false);
            } else if (SwanAppWebViewWidget.this.L.f43522c == 0) {
                HybridUbcFlow o = i.o("startup");
                o.y("fmp_type", "2");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppWebViewWidget.this.L.f43523d);
                o.A(ubcFlowEvent);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            if (d.a.h0.a.w0.a.N().C() && SwanAppWebViewWidget.this.H1() && !d.a.h0.a.s1.a.b.h(str)) {
                if (SwanAppWebViewWidget.Y) {
                    Log.d("SwanAppWebViewWidget", "WebSafeCheckers.checkWebDomain() failed url: " + str);
                    return true;
                }
                return true;
            }
            return super.onSubFrameBeforeRequest(bdSailorWebView, str);
        }

        public /* synthetic */ SwanAppWebViewWidgetClientExt(SwanAppWebViewWidget swanAppWebViewWidget, a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public class WebViewWidgetClient extends BdSailorWebViewClient {

        /* loaded from: classes2.dex */
        public class a implements d.a.h0.a.e0.k.c {
            public a() {
            }

            @Override // d.a.h0.a.e0.k.c
            public boolean p() {
                SwanAppWebViewWidget.this.w1().a();
                SwanAppWebViewWidget.this.s().setOnWebViewHookHandler(null);
                return true;
            }

            @Override // d.a.h0.a.e0.k.c
            public boolean u(boolean z) {
                return z;
            }
        }

        public WebViewWidgetClient() {
        }

        private void showDomainErrorView(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                URL url = new URL(str);
                for (String str2 : SwanAppWebViewWidget.Z) {
                    if (TextUtils.equals(url.getProtocol(), str2)) {
                        SwanAppWebViewWidget.this.w1().b(str);
                        SwanAppWebViewWidget.this.s().setOnWebViewHookHandler(new a());
                        return;
                    }
                }
            } catch (MalformedURLException e2) {
                if (SwanAppWebViewWidget.Y) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            SwanAppWebViewWidget.this.y1().b();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageStarted(BdSailorWebView bdSailorWebView, String str, Bitmap bitmap) {
            SwanAppWebViewWidget.this.y1().c();
            SwanAppWebViewWidget.this.v1();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i2, String str, String str2) {
            super.onReceivedError(bdSailorWebView, i2, str, str2);
            if (i2 == -10) {
                return;
            }
            SwanAppWebViewWidget.this.x1().c();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.Y) {
                Log.d("SwanAppWebViewWidget", "shouldOverrideUrlLoading url: " + str);
            }
            Uri w = k0.w(str);
            if (w != null) {
                d.a.h0.a.i2.e.f(SwanAppWebViewWidget.this.f11656e, new Intent("android.intent.action.DIAL", w));
                return true;
            }
            SwanAppWebViewWidget swanAppWebViewWidget = SwanAppWebViewWidget.this;
            d.a.h0.a.e0.n.d dVar = swanAppWebViewWidget.J;
            if (dVar != null) {
                return dVar.b(str);
            }
            if (!swanAppWebViewWidget.H1() || d.a.h0.a.s1.a.b.h(str)) {
                return false;
            }
            showDomainErrorView(str);
            return true;
        }
    }

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SwanAppNetworkUtils.h(SwanAppWebViewWidget.this.s().getContext())) {
                if (!SwanAppWebViewWidget.this.H1() || d.a.h0.a.s1.a.b.h(SwanAppWebViewWidget.this.s().getUrl())) {
                    SwanAppWebViewWidget.this.s().reload();
                    SwanAppWebViewWidget.this.P.a();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f11697e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.e0.l.c f11698f;

        public b(View view, d.a.h0.a.e0.l.c cVar) {
            this.f11697e = view;
            this.f11698f = cVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (SwanAppWebViewWidget.Y) {
                Log.d("SwanAppWebViewWidget", "onGlobalLayout");
            }
            SwanAppWebViewWidget.this.C1(this.f11697e, this.f11698f);
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public DomainErrorView f11700a;

        public c(Context context, ViewGroup viewGroup) {
            if (context != null && viewGroup != null) {
                DomainErrorView domainErrorView = new DomainErrorView(context);
                this.f11700a = domainErrorView;
                domainErrorView.setBackgroundColor(context.getResources().getColor(d.a.h0.a.c.aiapps_white));
                viewGroup.addView(this.f11700a, new FrameLayout.LayoutParams(-1, -1));
                this.f11700a.setVisibility(8);
                return;
            }
            throw new IllegalArgumentException("context and viewGroup must not be null.");
        }

        public void a() {
            this.f11700a.setVisibility(8);
        }

        public void b(String str) {
            this.f11700a.b(str);
            this.f11700a.setVisibility(0);
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public NetworkErrorView f11701a;

        public d(Context context, ViewGroup viewGroup) {
            if (context != null && viewGroup != null) {
                NetworkErrorView networkErrorView = new NetworkErrorView(context);
                this.f11701a = networkErrorView;
                networkErrorView.setBackgroundColor(context.getResources().getColor(d.a.h0.a.c.aiapps_white));
                viewGroup.addView(this.f11701a, new FrameLayout.LayoutParams(-1, -1));
                this.f11701a.setVisibility(8);
                return;
            }
            throw new IllegalArgumentException("context and viewGroup must not be null.");
        }

        public void a() {
            this.f11701a.setVisibility(8);
        }

        public void b(View.OnClickListener onClickListener) {
            this.f11701a.setOnClickListener(onClickListener);
            this.f11701a.setReloadClickListener(onClickListener);
        }

        public void c() {
            this.f11701a.setVisibility(0);
        }
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public EfficientProgressBar f11702a;

        public e(Context context, ViewGroup viewGroup) {
            this.f11702a = null;
            if (context != null && viewGroup != null) {
                EfficientProgressBar efficientProgressBar = new EfficientProgressBar(context);
                this.f11702a = efficientProgressBar;
                efficientProgressBar.setProgressDrawable(context.getResources().getDrawable(d.a.h0.a.e.aiapps_progress_thumb));
                this.f11702a.setId(d.a.h0.a.f.aiapps_nbsearch_web_loading_progress_bar);
                this.f11702a.setVisibility(4);
                this.f11702a.setFocusable(false);
                this.f11702a.setClickable(false);
                viewGroup.addView(this.f11702a);
                return;
            }
            throw new IllegalArgumentException("context and viewGroup must not be null.");
        }

        public void b() {
            this.f11702a.setProgress(100, true);
        }

        public void c() {
            this.f11702a.f();
            d(0);
        }

        public void d(int i2) {
            this.f11702a.setProgress(i2, true);
        }
    }

    public SwanAppWebViewWidget(Context context) {
        super(context);
        this.W = true;
        this.X = 200;
        S0(new WebViewWidgetClient());
        R0(new SwanAppWebChromeClient(this, null));
        T0(new SwanAppWebViewWidgetClientExt(this, null));
        VideoPlayerFactory b2 = d.a.h0.a.w0.a.f().b();
        if (b2 != null) {
            this.f11657f.getCurrentWebView().setVideoPlayerFactory(b2);
        }
        G1();
        I1(context);
    }

    public final void A1() {
        d.a.h0.a.e0.m.e eVar = this.S;
        if (eVar != null) {
            eVar.a();
        }
    }

    public final void B1() {
        L0("document.querySelector('video').pause();");
    }

    public final void C1(View view, d.a.h0.a.e0.l.c cVar) {
        if (cVar == null || cVar.e0()) {
            return;
        }
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int i2 = rect.bottom - rect.top;
        int i3 = this.T;
        if (i2 == i3) {
            return;
        }
        if (i3 - i2 > this.X) {
            int i4 = 0;
            if (cVar instanceof d.a.h0.a.e0.l.e) {
                d.a.h0.a.e0.l.e eVar = (d.a.h0.a.e0.l.e) cVar;
                if (eVar.U1() && eVar.f3()) {
                    i4 = view.getResources().getDimensionPixelSize(d.a.h0.a.d.aiapps_bottom_tab_height);
                }
            }
            view.getLayoutParams().height = i4 + i2;
        } else {
            view.getLayoutParams().height = i2;
        }
        view.requestLayout();
        this.T = i2;
    }

    public void D1(boolean z) {
        this.W = z;
    }

    public void E1(@Nullable d.a.h0.a.t1.k.r0.d dVar) {
        this.R = dVar;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    public void F0() {
    }

    public void F1(String str) {
    }

    public final void G1() {
        this.f11657f.getSettings().setLoadWithOverviewMode(true);
        this.f11657f.getSettings().setUseWideViewPort(true);
        this.f11657f.getSettings().setSupportZoom(true);
        this.f11657f.getSettings().setBuiltInZoomControls(true);
        this.f11657f.getSettings().setDisplayZoomControls(false);
    }

    public boolean H1() {
        return this.W;
    }

    public final void I1(Context context) {
        d.a.h0.a.p.c.b a2 = d.a.h0.a.r1.d.e().w().a().a();
        if (a2 != null) {
            a2.a(context);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void K0(SwanAppWebViewManager swanAppWebViewManager) {
        super.K0(swanAppWebViewManager);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    public void O0(SwanAppWebViewManager.d dVar) {
        super.O0(dVar);
        dVar.f11685a = false;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    public void P0() {
        super.P0();
        d.a.h0.a.t1.k.r0.f fVar = new d.a.h0.a.t1.k.r0.f(this.l);
        fVar.j(this);
        this.l.b(fVar);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, d.a.h0.a.p.d.b
    public void X(d.a.h0.a.e0.n.d dVar) {
        this.U = dVar;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.h0.a.p.d.d
    public String a0() {
        return "ai_apps_widget";
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.h0.a.p.d.d
    public void d0() {
        super.d0();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.h0.a.p.d.d
    public void destroy() {
        this.U = null;
        super.destroy();
    }

    @Override // d.a.h0.a.p.d.e
    @Nullable
    public d.a.h0.a.t1.k.r0.d getParams() {
        return this.R;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.h0.a.p.d.d
    public void loadUrl(String str) {
        if (H1() && !d.a.h0.a.s1.a.b.h(str)) {
            w1().b(str);
        } else {
            super.loadUrl(str);
        }
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.h0.a.p.d.d
    public void onPause() {
        super.onPause();
        B1();
    }

    public void v1() {
        d.a.h0.a.e0.l.c m;
        d.a.h0.a.e0.l.f W = d.a.h0.a.z0.f.V().W();
        if (W == null || (m = W.m()) == null || m.P() == null) {
            return;
        }
        View view = null;
        if (m instanceof d.a.h0.a.e0.l.e) {
            if (((d.a.h0.a.e0.l.e) m).S2().l() == null) {
                return;
            }
            view = m.P().findViewById(d.a.h0.a.f.ai_apps_fragment_base_view);
        } else if (m instanceof d.a.h0.a.e0.l.i) {
            if (((d.a.h0.a.e0.l.i) m).l() == null || m.P() == null) {
                return;
            }
            view = m.P().findViewById(d.a.h0.a.f.swan_app_webview_fragment);
        }
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new b(view, m));
    }

    public final c w1() {
        if (this.Q == null) {
            this.Q = new c(s().getContext(), s());
        }
        return this.Q;
    }

    public final d x1() {
        if (this.P == null) {
            d dVar = new d(s().getContext(), s());
            this.P = dVar;
            dVar.b(new a());
        }
        return this.P;
    }

    public final e y1() {
        if (this.O == null) {
            this.O = new e(s().getContext(), s());
        }
        return this.O;
    }

    public int z1() {
        EfficientProgressBar efficientProgressBar;
        e eVar = this.O;
        if (eVar == null || (efficientProgressBar = eVar.f11702a) == null) {
            return 0;
        }
        return efficientProgressBar.getHeight();
    }
}
