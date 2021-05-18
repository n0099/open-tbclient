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
import com.baidu.webkit.sdk.VideoPlayerFactory;
import com.baidu.webkit.sdk.WebChromeClient;
import com.baidu.webkit.sdk.WebResourceRequest;
import com.baidu.webkit.sdk.WebResourceResponse;
import d.a.i0.a.h0.g.g;
import d.a.i0.a.h0.h.e;
import d.a.i0.a.k;
import d.a.i0.a.r1.h;
import d.a.i0.a.r1.i;
import d.a.i0.a.r1.k.f;
import d.a.i0.a.v2.o0;
import d.a.i0.a.v2.q;
import d.a.i0.a.v2.q0;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class SwanAppWebViewWidget extends SwanAppSlaveManager implements d.a.i0.a.p.e.e<NgWebView> {
    public static final boolean b0 = k.f43025a;
    public static final String[] c0 = {"http", "https"};
    public e Q;
    public d R;
    public c S;
    @Nullable
    public d.a.i0.a.c2.f.r0.d T;
    public d.a.i0.a.h0.h.e U;
    public int V;
    public d.a.i0.a.h0.j.d W;
    public String X;
    public SwanAppSlaveManager Y;
    public boolean Z;
    public int a0;

    /* loaded from: classes2.dex */
    public class SwanAppWebChromeClient extends BdSailorWebChromeClient {

        /* loaded from: classes2.dex */
        public class a implements e.a {
            public a(SwanAppWebChromeClient swanAppWebChromeClient) {
            }

            @Override // d.a.i0.a.h0.h.e.a
            public void onCustomViewHidden() {
            }
        }

        public SwanAppWebChromeClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onHideCustomView(BdSailorWebView bdSailorWebView) {
            SwanAppWebViewWidget.this.K1();
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedTitle(BdSailorWebView bdSailorWebView, String str) {
            super.onReceivedTitle(bdSailorWebView, str);
            if (o0.r(str)) {
                return;
            }
            SwanAppWebViewWidget.this.X = str;
            d.a.i0.a.h0.j.d dVar = SwanAppWebViewWidget.this.W;
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
            if (SwanAppWebViewWidget.this.U == null) {
                SwanAppWebViewWidget.this.U = new d.a.i0.a.h0.h.e(SwanAppWebViewWidget.this.f10802e.getBaseContext());
            }
            SwanAppWebViewWidget.this.U.c(view, i2, new a(this));
            return true;
        }
    }

    /* loaded from: classes2.dex */
    public class SwanAppWebViewWidgetClientExt extends BdSailorWebViewClientExt {

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ long f10849e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ HybridUbcFlow f10850f;

            public a(long j, HybridUbcFlow hybridUbcFlow) {
                this.f10849e = j;
                this.f10850f = hybridUbcFlow;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                if (h.f44263b) {
                    if (SwanAppWebViewWidget.b0) {
                        Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from fcp delay");
                    }
                    SwanAppWebViewWidget.this.l1(true);
                    return;
                }
                if (SwanAppWebViewWidget.this.L.f43826c <= 0) {
                    j = this.f10849e;
                } else {
                    j = SwanAppWebViewWidget.this.L.f43826c;
                }
                this.f10850f.A("fmp_type", SwanAppWebViewWidget.this.L.f43830g);
                HybridUbcFlow hybridUbcFlow = this.f10850f;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(j);
                hybridUbcFlow.C(ubcFlowEvent);
                hybridUbcFlow.P();
                if (SwanAppWebViewWidget.b0) {
                    Log.d("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + SwanAppWebViewWidget.this.L.f43830g + " , fmpTypeName=" + SwanAppWebViewWidget.this.L.a());
                }
            }
        }

        public SwanAppWebViewWidgetClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            d.a.i0.a.e0.d.h("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstContentfulPaintExt");
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            long currentTimeMillis = System.currentTimeMillis();
            if (SwanAppWebViewWidget.b0) {
                Log.d("SwanAppWebViewWidget", "on fcp: real fcp = " + currentTimeMillis);
            }
            SwanAppWebViewWidget.this.L.f43825b = currentTimeMillis;
            f.j().n().a(SwanAppWebViewWidget.this.L.f43825b);
            long b2 = h.f44263b ? currentTimeMillis : SwanAppWebViewWidget.this.L.b();
            if (SwanAppWebViewWidget.b0) {
                Log.d("SwanAppWebViewWidget", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime" + b2 + " , aligned search=" + h.f44263b);
            }
            HybridUbcFlow p = h.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_paint");
            ubcFlowEvent.h(b2);
            p.C(ubcFlowEvent);
            if (SwanAppWebViewWidget.this.Y != null) {
                SwanAppWebViewWidget.this.Y.M.a();
            }
            if (SwanAppWebViewWidget.this.L.f43826c == 0) {
                SwanAppWebViewWidget.this.L.f43826c = b2;
                d.a.i0.a.p.e.j.d dVar = SwanAppWebViewWidget.this.L;
                dVar.f43830g = dVar.c(b2);
                p.A("fmp_type", "1");
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent2.h(SwanAppWebViewWidget.this.L.f43825b);
                p.C(ubcFlowEvent2);
                if (h.f44264c) {
                    return;
                }
            }
            long I = d.a.i0.a.c1.a.Z().I();
            if (I < 0) {
                I = 3000;
            }
            q.c(new a(b2, p), "fmp record", I, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            d.a.i0.a.e0.d.h("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.L.f43828e = System.currentTimeMillis();
            f.j().n().g(SwanAppWebViewWidget.this.L.f43828e);
            if (SwanAppWebViewWidget.b0) {
                Log.d("SwanAppWebViewWidget", "on fip: real fip = " + SwanAppWebViewWidget.this.L.f43828e);
            }
            if (h.f44263b) {
                if (SwanAppWebViewWidget.b0) {
                    Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from fip");
                }
                SwanAppWebViewWidget.this.l1(false);
            } else if (SwanAppWebViewWidget.this.L.f43826c == 0) {
                HybridUbcFlow p = h.p("startup");
                p.A("fmp_type", "3");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppWebViewWidget.this.L.f43828e);
                p.C(ubcFlowEvent);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstLayoutDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstLayoutDidExt(bdSailorWebView, str);
            if (TextUtils.isEmpty(SwanAppWebViewWidget.this.K)) {
                return;
            }
            h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, SwanAppWebViewWidget.this.K).C(new UbcFlowEvent("web_widget_first_layout"));
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstPaintDidExt(BdSailorWebView bdSailorWebView, String str) {
            super.onFirstPaintDidExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.L.f43824a = System.currentTimeMillis();
            if (TextUtils.isEmpty(SwanAppWebViewWidget.this.K)) {
                return;
            }
            h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, SwanAppWebViewWidget.this.K).C(new UbcFlowEvent("web_widget_first_paint"));
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            d.a.i0.a.e0.d.h("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstScreenPaintFinishedEx");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.L.f43826c = System.currentTimeMillis();
            SwanAppWebViewWidget.this.L.f43830g = "0";
            f.j().n().e(SwanAppWebViewWidget.this.L.f43826c);
            if (SwanAppWebViewWidget.b0) {
                Log.d("SwanAppWebViewWidget", "on fmp: real fmp = " + SwanAppWebViewWidget.this.L.f43826c);
            }
            HybridUbcFlow d2 = h.d("startup");
            if (d2 != null) {
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                d2.A("webviewComponent", str);
                d2.A("fmp_type", "0");
                d2.B("value", "arrive_success");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppWebViewWidget.this.L.f43826c);
                ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE);
                d2.C(ubcFlowEvent);
                d2.P();
                d.a.i0.a.p.e.j.d dVar = SwanAppWebViewWidget.this.L;
                d.a.i0.a.e0.d.a("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppWebViewWidget.this.L.f43826c), " , fmpType=", dVar.f43830g, " , fmpTypeName=", dVar.a());
                h.t();
            }
            if (!TextUtils.isEmpty(SwanAppWebViewWidget.this.K)) {
                i.f(SwanAppWebViewWidget.this.K);
                SwanAppWebViewWidget.this.K = "";
            }
            if (SwanAppWebViewWidget.this.Y != null) {
                SwanAppWebViewWidget.this.Y.M.g();
                SwanAppWebViewWidget.this.Y.M.b();
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstTextPaintExt(BdSailorWebView bdSailorWebView, String str) {
            d.a.i0.a.e0.d.h("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.L.f43827d = System.currentTimeMillis();
            f.j().n().f(SwanAppWebViewWidget.this.L.f43827d);
            if (SwanAppWebViewWidget.b0) {
                Log.d("SwanAppWebViewWidget", "on ftp: real ftp = " + SwanAppWebViewWidget.this.L.f43827d);
            }
            if (h.f44263b) {
                if (SwanAppWebViewWidget.b0) {
                    Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from ftp");
                }
                SwanAppWebViewWidget.this.l1(false);
            } else if (SwanAppWebViewWidget.this.L.f43826c == 0) {
                HybridUbcFlow p = h.p("startup");
                p.A("fmp_type", "2");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppWebViewWidget.this.L.f43827d);
                p.C(ubcFlowEvent);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            if (d.a.i0.a.c1.a.Z().z() && SwanAppWebViewWidget.this.R1() && !d.a.i0.a.b2.a.b.h(str)) {
                if (SwanAppWebViewWidget.b0) {
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
        public class a implements d.a.i0.a.h0.f.c {
            public a() {
            }

            @Override // d.a.i0.a.h0.f.c
            public boolean q() {
                SwanAppWebViewWidget.this.G1().a();
                SwanAppWebViewWidget.this.u().setOnWebViewHookHandler(null);
                return true;
            }

            @Override // d.a.i0.a.h0.f.c
            public boolean w(boolean z) {
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
                for (String str2 : SwanAppWebViewWidget.c0) {
                    if (TextUtils.equals(url.getProtocol(), str2)) {
                        SwanAppWebViewWidget.this.G1().b(str);
                        SwanAppWebViewWidget.this.u().setOnWebViewHookHandler(new a());
                        return;
                    }
                }
            } catch (MalformedURLException e2) {
                if (SwanAppWebViewWidget.b0) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageFinished(BdSailorWebView bdSailorWebView, String str) {
            SwanAppWebViewWidget.this.I1().b();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageStarted(BdSailorWebView bdSailorWebView, String str, Bitmap bitmap) {
            SwanAppWebViewWidget.this.I1().c();
            SwanAppWebViewWidget.this.F1();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i2, String str, String str2) {
            super.onReceivedError(bdSailorWebView, i2, str, str2);
            if (i2 == -10) {
                return;
            }
            SwanAppWebViewWidget.this.H1().c();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedHttpError(BdSailorWebView bdSailorWebView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(bdSailorWebView, webResourceRequest, webResourceResponse);
            d.a.i0.a.h0.j.d dVar = SwanAppWebViewWidget.this.W;
            if (dVar != null) {
                dVar.b(webResourceResponse != null ? webResourceResponse.getStatusCode() : 0);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.b0) {
                Log.d("SwanAppWebViewWidget", "shouldOverrideUrlLoading url: " + str);
            }
            Uri A = q0.A(str);
            if (A != null) {
                d.a.i0.a.v2.f.g(SwanAppWebViewWidget.this.f10802e, new Intent("android.intent.action.DIAL", A));
                return true;
            }
            SwanAppWebViewWidget swanAppWebViewWidget = SwanAppWebViewWidget.this;
            d.a.i0.a.h0.j.d dVar = swanAppWebViewWidget.J;
            if (dVar != null) {
                return dVar.c(str);
            }
            if (!swanAppWebViewWidget.R1() || d.a.i0.a.b2.a.b.h(str)) {
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
            if (SwanAppNetworkUtils.i(SwanAppWebViewWidget.this.u().getContext())) {
                if (!SwanAppWebViewWidget.this.R1() || d.a.i0.a.b2.a.b.h(SwanAppWebViewWidget.this.u().getUrl())) {
                    SwanAppWebViewWidget.this.u().reload();
                    SwanAppWebViewWidget.this.R.a();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f10854e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.h0.g.d f10855f;

        public b(View view, d.a.i0.a.h0.g.d dVar) {
            this.f10854e = view;
            this.f10855f = dVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (SwanAppWebViewWidget.b0) {
                Log.d("SwanAppWebViewWidget", "onGlobalLayout");
            }
            SwanAppWebViewWidget.this.M1(this.f10854e, this.f10855f);
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public DomainErrorView f10857a;

        public c(@NonNull Context context, @NonNull ViewGroup viewGroup) {
            DomainErrorView domainErrorView = new DomainErrorView(context);
            this.f10857a = domainErrorView;
            domainErrorView.setBackgroundColor(-1);
            viewGroup.addView(this.f10857a, new FrameLayout.LayoutParams(-1, -1));
            this.f10857a.setVisibility(8);
        }

        public void a() {
            this.f10857a.setVisibility(8);
        }

        public void b(String str) {
            this.f10857a.b(str);
            this.f10857a.setVisibility(0);
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public NetworkErrorView f10858a;

        public d(@NonNull Context context, @NonNull ViewGroup viewGroup) {
            NetworkErrorView networkErrorView = new NetworkErrorView(context);
            this.f10858a = networkErrorView;
            networkErrorView.setBackgroundColor(-1);
            viewGroup.addView(this.f10858a, new FrameLayout.LayoutParams(-1, -1));
            this.f10858a.setVisibility(8);
        }

        public void a() {
            this.f10858a.setVisibility(8);
        }

        public void b(View.OnClickListener onClickListener) {
            this.f10858a.setOnClickListener(onClickListener);
            this.f10858a.setReloadClickListener(onClickListener);
        }

        public void c() {
            this.f10858a.setVisibility(0);
        }
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public EfficientProgressBar f10859a;

        public e(@NonNull Context context, @NonNull ViewGroup viewGroup) {
            this.f10859a = null;
            EfficientProgressBar efficientProgressBar = new EfficientProgressBar(context);
            this.f10859a = efficientProgressBar;
            efficientProgressBar.setProgressDrawable(context.getResources().getDrawable(d.a.i0.a.e.aiapps_progress_thumb));
            this.f10859a.setId(d.a.i0.a.f.aiapps_nbsearch_web_loading_progress_bar);
            this.f10859a.setVisibility(4);
            this.f10859a.setFocusable(false);
            this.f10859a.setClickable(false);
            viewGroup.addView(this.f10859a);
        }

        public void b() {
            this.f10859a.setProgress(100, true);
        }

        public void c() {
            this.f10859a.f();
            d(0);
        }

        public void d(int i2) {
            this.f10859a.setProgress(i2, true);
        }
    }

    public SwanAppWebViewWidget(Context context) {
        super(context);
        this.Z = true;
        this.a0 = 200;
        Y0(new WebViewWidgetClient());
        X0(new SwanAppWebChromeClient(this, null));
        Z0(new SwanAppWebViewWidgetClientExt(this, null));
        VideoPlayerFactory b2 = d.a.i0.a.c1.a.f().b();
        if (b2 != null) {
            this.f10803f.getCurrentWebView().setVideoPlayerFactory(b2);
        }
        Q1();
        S1(context);
    }

    public void F1() {
        d.a.i0.a.h0.g.d m;
        g W = d.a.i0.a.g1.f.V().W();
        if (W == null || (m = W.m()) == null || m.b0() == null) {
            return;
        }
        View view = null;
        if (m instanceof d.a.i0.a.h0.g.f) {
            if (((d.a.i0.a.h0.g.f) m).b3().m() == null) {
                return;
            }
            view = m.b0().findViewById(d.a.i0.a.f.ai_apps_fragment_base_view);
        } else if (m instanceof d.a.i0.a.h0.g.k) {
            if (((d.a.i0.a.h0.g.k) m).m() == null || m.b0() == null) {
                return;
            }
            view = m.b0().findViewById(d.a.i0.a.f.swan_app_webview_fragment);
        }
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new b(view, m));
    }

    public final c G1() {
        if (this.S == null) {
            this.S = new c(u().getContext(), u());
        }
        return this.S;
    }

    public final d H1() {
        if (this.R == null) {
            d dVar = new d(u().getContext(), u());
            this.R = dVar;
            dVar.b(new a());
        }
        return this.R;
    }

    public final e I1() {
        if (this.Q == null) {
            this.Q = new e(u().getContext(), u());
        }
        return this.Q;
    }

    public int J1() {
        EfficientProgressBar efficientProgressBar;
        e eVar = this.Q;
        if (eVar == null || (efficientProgressBar = eVar.f10859a) == null) {
            return 0;
        }
        return efficientProgressBar.getHeight();
    }

    public final void K1() {
        d.a.i0.a.h0.h.e eVar = this.U;
        if (eVar != null) {
            eVar.a();
        }
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    public void L0() {
    }

    public final void L1() {
        R0("document.querySelector('video').pause();");
    }

    public final void M1(View view, d.a.i0.a.h0.g.d dVar) {
        if (dVar == null || dVar.p0()) {
            return;
        }
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int i2 = rect.bottom - rect.top;
        int i3 = this.V;
        if (i2 == i3) {
            return;
        }
        if (i3 - i2 > this.a0) {
            int i4 = 0;
            if (dVar instanceof d.a.i0.a.h0.g.f) {
                d.a.i0.a.h0.g.f fVar = (d.a.i0.a.h0.g.f) dVar;
                if (fVar.Z1() && fVar.q3()) {
                    i4 = view.getResources().getDimensionPixelSize(d.a.i0.a.d.aiapps_bottom_tab_height);
                }
            }
            view.getLayoutParams().height = i4 + i2;
        } else {
            view.getLayoutParams().height = -1;
        }
        view.requestLayout();
        this.V = i2;
    }

    public void N1(boolean z) {
        this.Z = z;
    }

    public void O1(SwanAppSlaveManager swanAppSlaveManager) {
        this.Y = swanAppSlaveManager;
    }

    public void P1(@Nullable d.a.i0.a.c2.f.r0.d dVar) {
        this.T = dVar;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void Q0(SwanAppWebViewManager swanAppWebViewManager) {
        super.Q0(swanAppWebViewManager);
    }

    public final void Q1() {
        this.f10803f.getSettings().setLoadWithOverviewMode(true);
        this.f10803f.getSettings().setUseWideViewPort(true);
        this.f10803f.getSettings().setSupportZoom(true);
        this.f10803f.getSettings().setBuiltInZoomControls(true);
        this.f10803f.getSettings().setDisplayZoomControls(false);
    }

    public boolean R1() {
        return this.Z;
    }

    public final void S1(Context context) {
        d.a.i0.a.p.d.b a2 = d.a.i0.a.a2.d.g().y().a().a();
        if (a2 != null) {
            a2.a(context);
        }
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    public void U0(SwanAppWebViewManager.e eVar) {
        super.U0(eVar);
        eVar.f10834a = false;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    public void V0() {
        super.V0();
        d.a.i0.a.c2.f.r0.f fVar = new d.a.i0.a.c2.f.r0.f(this.l);
        fVar.j(this);
        this.l.b(fVar);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, d.a.i0.a.p.e.b
    public void Z(d.a.i0.a.h0.j.d dVar) {
        this.W = dVar;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.i0.a.p.e.d
    public String c0() {
        return "ai_apps_widget";
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.i0.a.p.e.d
    public void destroy() {
        this.W = null;
        super.destroy();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.i0.a.p.e.d
    public void f0() {
        super.f0();
    }

    @Override // d.a.i0.a.p.e.e
    @Nullable
    public d.a.i0.a.c2.f.r0.d getParams() {
        return this.T;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.i0.a.p.e.d
    public void loadUrl(String str) {
        if (R1() && !d.a.i0.a.b2.a.b.h(str)) {
            G1().b(str);
        } else {
            super.loadUrl(str);
        }
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, d.a.i0.a.p.e.d
    public void onPause() {
        super.onPause();
        L1();
    }
}
