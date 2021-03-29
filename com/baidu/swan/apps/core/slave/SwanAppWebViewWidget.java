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
import d.b.g0.a.e0.m.e;
import d.b.g0.a.i2.i0;
import d.b.g0.a.i2.k0;
import d.b.g0.a.i2.p;
import d.b.g0.a.j1.i;
import d.b.g0.a.j1.j;
import d.b.g0.a.j1.l.f;
import d.b.g0.a.k;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class SwanAppWebViewWidget extends SwanAppSlaveManager implements d.b.g0.a.p.d.e<NgWebView> {
    public static final boolean Y = k.f45051a;
    public static final String[] Z = {"http", "https"};
    public e O;
    public d P;
    public c Q;
    @Nullable
    public d.b.g0.a.t1.k.r0.d R;
    public d.b.g0.a.e0.m.e S;
    public int T;
    public d.b.g0.a.e0.n.d U;
    public String V;
    public boolean W;
    public int X;

    /* loaded from: classes2.dex */
    public class SwanAppWebChromeClient extends BdSailorWebChromeClient {

        /* loaded from: classes2.dex */
        public class a implements e.a {
            public a(SwanAppWebChromeClient swanAppWebChromeClient) {
            }

            @Override // d.b.g0.a.e0.m.e.a
            public void onCustomViewHidden() {
            }
        }

        public SwanAppWebChromeClient() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public boolean onHideCustomView(BdSailorWebView bdSailorWebView) {
            SwanAppWebViewWidget.this.z1();
            return true;
        }

        @Override // com.baidu.browser.sailor.BdSailorWebChromeClient
        public void onReceivedTitle(BdSailorWebView bdSailorWebView, String str) {
            super.onReceivedTitle(bdSailorWebView, str);
            if (i0.p(str)) {
                return;
            }
            SwanAppWebViewWidget.this.V = str;
            d.b.g0.a.e0.n.d dVar = SwanAppWebViewWidget.this.U;
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
        public boolean onShowCustomView(BdSailorWebView bdSailorWebView, View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
            if (SwanAppWebViewWidget.this.S == null) {
                SwanAppWebViewWidget.this.S = new d.b.g0.a.e0.m.e(SwanAppWebViewWidget.this.f12153e.getBaseContext());
            }
            SwanAppWebViewWidget.this.S.c(view, i, new a(this));
            return true;
        }
    }

    /* loaded from: classes2.dex */
    public class SwanAppWebViewWidgetClientExt extends BdSailorWebViewClientExt {

        /* loaded from: classes2.dex */
        public class a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ long f12188e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ HybridUbcFlow f12189f;

            public a(long j, HybridUbcFlow hybridUbcFlow) {
                this.f12188e = j;
                this.f12189f = hybridUbcFlow;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                if (i.f44884b) {
                    if (SwanAppWebViewWidget.Y) {
                        Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from fcp delay");
                    }
                    SwanAppWebViewWidget.this.c1(true);
                    return;
                }
                if (SwanAppWebViewWidget.this.L.f45454c <= 0) {
                    j = this.f12188e;
                } else {
                    j = SwanAppWebViewWidget.this.L.f45454c;
                }
                this.f12189f.y("fmp_type", SwanAppWebViewWidget.this.L.f45458g);
                HybridUbcFlow hybridUbcFlow = this.f12189f;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(j);
                hybridUbcFlow.A(ubcFlowEvent);
                hybridUbcFlow.N();
                if (SwanAppWebViewWidget.Y) {
                    Log.d("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=" + j + " , fmpType" + SwanAppWebViewWidget.this.L.f45458g + " , fmpTypeName=" + SwanAppWebViewWidget.this.L.a());
                }
            }
        }

        public SwanAppWebViewWidgetClientExt() {
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstContentfulPaintExt(BdSailorWebView bdSailorWebView, String str) {
            d.b.g0.a.c0.c.h("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstContentfulPaintExt");
            super.onFirstContentfulPaintExt(bdSailorWebView, str);
            long currentTimeMillis = System.currentTimeMillis();
            if (SwanAppWebViewWidget.Y) {
                Log.d("SwanAppWebViewWidget", "on fcp: real fcp = " + currentTimeMillis);
            }
            SwanAppWebViewWidget.this.L.f45453b = currentTimeMillis;
            f.h().l().a(SwanAppWebViewWidget.this.L.f45453b);
            long b2 = i.f44884b ? currentTimeMillis : SwanAppWebViewWidget.this.L.b();
            if (SwanAppWebViewWidget.Y) {
                Log.d("SwanAppWebViewWidget", "onFirstContentfulPaintExt: fcp=" + currentTimeMillis + " , firstPaintTime" + b2 + " , aligned search=" + i.f44884b);
            }
            HybridUbcFlow o = i.o("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_paint");
            ubcFlowEvent.h(b2);
            o.A(ubcFlowEvent);
            if (SwanAppWebViewWidget.this.L.f45454c == 0) {
                SwanAppWebViewWidget.this.L.f45454c = b2;
                d.b.g0.a.p.d.j.d dVar = SwanAppWebViewWidget.this.L;
                dVar.f45458g = dVar.c(b2);
                o.y("fmp_type", "1");
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent2.h(SwanAppWebViewWidget.this.L.f45453b);
                o.A(ubcFlowEvent2);
            }
            long I = d.b.g0.a.w0.a.N().I();
            if (I < 0) {
                I = 3000;
            }
            p.c(new a(b2, o), "fmp record", I, TimeUnit.MILLISECONDS);
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstImagePaintExt(BdSailorWebView bdSailorWebView, String str) {
            d.b.g0.a.c0.c.h("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstImagePaintExt");
            super.onFirstImagePaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.L.f45456e = System.currentTimeMillis();
            f.h().l().d(SwanAppWebViewWidget.this.L.f45456e);
            if (SwanAppWebViewWidget.Y) {
                Log.d("SwanAppWebViewWidget", "on fip: real fip = " + SwanAppWebViewWidget.this.L.f45456e);
            }
            if (i.f44884b) {
                if (SwanAppWebViewWidget.Y) {
                    Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from fip");
                }
                SwanAppWebViewWidget.this.c1(false);
            } else if (SwanAppWebViewWidget.this.L.f45454c == 0) {
                HybridUbcFlow o = i.o("startup");
                o.y("fmp_type", "3");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppWebViewWidget.this.L.f45456e);
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
            SwanAppWebViewWidget.this.L.f45452a = System.currentTimeMillis();
            if (TextUtils.isEmpty(SwanAppWebViewWidget.this.K)) {
                return;
            }
            i.p(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, SwanAppWebViewWidget.this.K).A(new UbcFlowEvent("web_widget_first_paint"));
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public void onFirstScreenPaintFinishedExt(BdSailorWebView bdSailorWebView, String str) {
            d.b.g0.a.c0.c.h("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstScreenPaintFinishedEx");
            super.onFirstScreenPaintFinishedExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.L.f45454c = System.currentTimeMillis();
            SwanAppWebViewWidget.this.L.f45458g = "0";
            f.h().l().g(SwanAppWebViewWidget.this.L.f45454c);
            if (SwanAppWebViewWidget.Y) {
                Log.d("SwanAppWebViewWidget", "on fmp: real fmp = " + SwanAppWebViewWidget.this.L.f45454c);
            }
            HybridUbcFlow d2 = i.d("startup");
            if (d2 != null) {
                if (TextUtils.isEmpty(str)) {
                    str = "0";
                }
                d2.y("webviewComponent", str);
                d2.y("fmp_type", "0");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppWebViewWidget.this.L.f45454c);
                ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE);
                d2.A(ubcFlowEvent);
                d2.N();
                d2.z("value", "arrive_success");
                d.b.g0.a.p.d.j.d dVar = SwanAppWebViewWidget.this.L;
                d.b.g0.a.c0.c.a("SwanAppWebViewWidget", "onFirstScreenPaintFinishedExt: naPaintFlowDone with fmp=", Long.valueOf(SwanAppWebViewWidget.this.L.f45454c), " , fmpType=", dVar.f45458g, " , fmpTypeName=", dVar.a());
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
            d.b.g0.a.c0.c.h("SwanAppWebViewWidget", "SwanAppWebViewWidgetClientExt::onFirstTextPaintExt");
            super.onFirstTextPaintExt(bdSailorWebView, str);
            SwanAppWebViewWidget.this.L.f45455d = System.currentTimeMillis();
            f.h().l().c(SwanAppWebViewWidget.this.L.f45455d);
            if (SwanAppWebViewWidget.Y) {
                Log.d("SwanAppWebViewWidget", "on ftp: real ftp = " + SwanAppWebViewWidget.this.L.f45455d);
            }
            if (i.f44884b) {
                if (SwanAppWebViewWidget.Y) {
                    Log.d("SwanAppWebViewWidget", "-> onCalibrateFmp: from ftp");
                }
                SwanAppWebViewWidget.this.c1(false);
            } else if (SwanAppWebViewWidget.this.L.f45454c == 0) {
                HybridUbcFlow o = i.o("startup");
                o.y("fmp_type", "2");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_first_meaningful_paint");
                ubcFlowEvent.h(SwanAppWebViewWidget.this.L.f45455d);
                o.A(ubcFlowEvent);
            }
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClientExt
        public boolean onSubFrameBeforeRequest(BdSailorWebView bdSailorWebView, String str) {
            if (d.b.g0.a.w0.a.N().o() && SwanAppWebViewWidget.this.G1() && !d.b.g0.a.s1.a.b.h(str)) {
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
        public class a implements d.b.g0.a.e0.k.c {
            public a() {
            }

            @Override // d.b.g0.a.e0.k.c
            public boolean M(boolean z) {
                return z;
            }

            @Override // d.b.g0.a.e0.k.c
            public boolean u() {
                SwanAppWebViewWidget.this.v1().a();
                SwanAppWebViewWidget.this.getWebView().setOnWebViewHookHandler(null);
                return true;
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
                        SwanAppWebViewWidget.this.v1().b(str);
                        SwanAppWebViewWidget.this.getWebView().setOnWebViewHookHandler(new a());
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
            SwanAppWebViewWidget.this.x1().b();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onPageStarted(BdSailorWebView bdSailorWebView, String str, Bitmap bitmap) {
            SwanAppWebViewWidget.this.x1().c();
            SwanAppWebViewWidget.this.u1();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public void onReceivedError(BdSailorWebView bdSailorWebView, int i, String str, String str2) {
            super.onReceivedError(bdSailorWebView, i, str, str2);
            if (i == -10) {
                return;
            }
            SwanAppWebViewWidget.this.w1().c();
        }

        @Override // com.baidu.browser.sailor.BdSailorWebViewClient
        public boolean shouldOverrideUrlLoading(BdSailorWebView bdSailorWebView, String str) {
            if (SwanAppWebViewWidget.Y) {
                Log.d("SwanAppWebViewWidget", "shouldOverrideUrlLoading url: " + str);
            }
            Uri w = k0.w(str);
            if (w != null) {
                d.b.g0.a.i2.e.f(SwanAppWebViewWidget.this.f12153e, new Intent("android.intent.action.DIAL", w));
                return true;
            }
            SwanAppWebViewWidget swanAppWebViewWidget = SwanAppWebViewWidget.this;
            d.b.g0.a.e0.n.d dVar = swanAppWebViewWidget.J;
            if (dVar != null) {
                return dVar.b(str);
            }
            if (!swanAppWebViewWidget.G1() || d.b.g0.a.s1.a.b.h(str)) {
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
            if (SwanAppNetworkUtils.h(SwanAppWebViewWidget.this.getWebView().getContext())) {
                if (!SwanAppWebViewWidget.this.G1() || d.b.g0.a.s1.a.b.h(SwanAppWebViewWidget.this.getWebView().getUrl())) {
                    SwanAppWebViewWidget.this.getWebView().reload();
                    SwanAppWebViewWidget.this.P.a();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f12193e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.e0.l.c f12194f;

        public b(View view, d.b.g0.a.e0.l.c cVar) {
            this.f12193e = view;
            this.f12194f = cVar;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (SwanAppWebViewWidget.Y) {
                Log.d("SwanAppWebViewWidget", "onGlobalLayout");
            }
            SwanAppWebViewWidget.this.B1(this.f12193e, this.f12194f);
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public DomainErrorView f12196a;

        public c(Context context, ViewGroup viewGroup) {
            if (context != null && viewGroup != null) {
                DomainErrorView domainErrorView = new DomainErrorView(context);
                this.f12196a = domainErrorView;
                domainErrorView.setBackgroundColor(context.getResources().getColor(d.b.g0.a.c.aiapps_white));
                viewGroup.addView(this.f12196a, new FrameLayout.LayoutParams(-1, -1));
                this.f12196a.setVisibility(8);
                return;
            }
            throw new IllegalArgumentException("context and viewGroup must not be null.");
        }

        public void a() {
            this.f12196a.setVisibility(8);
        }

        public void b(String str) {
            this.f12196a.b(str);
            this.f12196a.setVisibility(0);
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public NetworkErrorView f12197a;

        public d(Context context, ViewGroup viewGroup) {
            if (context != null && viewGroup != null) {
                NetworkErrorView networkErrorView = new NetworkErrorView(context);
                this.f12197a = networkErrorView;
                networkErrorView.setBackgroundColor(context.getResources().getColor(d.b.g0.a.c.aiapps_white));
                viewGroup.addView(this.f12197a, new FrameLayout.LayoutParams(-1, -1));
                this.f12197a.setVisibility(8);
                return;
            }
            throw new IllegalArgumentException("context and viewGroup must not be null.");
        }

        public void a() {
            this.f12197a.setVisibility(8);
        }

        public void b(View.OnClickListener onClickListener) {
            this.f12197a.setOnClickListener(onClickListener);
            this.f12197a.setReloadClickListener(onClickListener);
        }

        public void c() {
            this.f12197a.setVisibility(0);
        }
    }

    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public EfficientProgressBar f12198a;

        public e(Context context, ViewGroup viewGroup) {
            this.f12198a = null;
            if (context != null && viewGroup != null) {
                EfficientProgressBar efficientProgressBar = new EfficientProgressBar(context);
                this.f12198a = efficientProgressBar;
                efficientProgressBar.setProgressDrawable(context.getResources().getDrawable(d.b.g0.a.e.aiapps_progress_thumb));
                this.f12198a.setId(d.b.g0.a.f.aiapps_nbsearch_web_loading_progress_bar);
                this.f12198a.setVisibility(4);
                this.f12198a.setFocusable(false);
                this.f12198a.setClickable(false);
                viewGroup.addView(this.f12198a);
                return;
            }
            throw new IllegalArgumentException("context and viewGroup must not be null.");
        }

        public void b() {
            this.f12198a.setProgress(100, true);
        }

        public void c() {
            this.f12198a.f();
            d(0);
        }

        public void d(int i) {
            this.f12198a.setProgress(i, true);
        }
    }

    public SwanAppWebViewWidget(Context context) {
        super(context);
        this.W = true;
        this.X = 200;
        R0(new WebViewWidgetClient());
        Q0(new SwanAppWebChromeClient(this, null));
        S0(new SwanAppWebViewWidgetClientExt(this, null));
        VideoPlayerFactory c2 = d.b.g0.a.w0.a.f().c();
        if (c2 != null) {
            this.f12154f.getCurrentWebView().setVideoPlayerFactory(c2);
        }
        F1();
        H1(context);
    }

    public final void A1() {
        K0("document.querySelector('video').pause();");
    }

    public final void B1(View view, d.b.g0.a.e0.l.c cVar) {
        if (cVar == null || cVar.j0()) {
            return;
        }
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        int i = rect.bottom - rect.top;
        int i2 = this.T;
        if (i == i2) {
            return;
        }
        if (i2 - i > this.X) {
            int i3 = 0;
            if (cVar instanceof d.b.g0.a.e0.l.e) {
                d.b.g0.a.e0.l.e eVar = (d.b.g0.a.e0.l.e) cVar;
                if (eVar.V1() && eVar.g3()) {
                    i3 = view.getResources().getDimensionPixelSize(d.b.g0.a.d.aiapps_bottom_tab_height);
                }
            }
            view.getLayoutParams().height = i3 + i;
        } else {
            view.getLayoutParams().height = i;
        }
        view.requestLayout();
        this.T = i;
    }

    public void C1(boolean z) {
        this.W = z;
    }

    public void D1(@Nullable d.b.g0.a.t1.k.r0.d dVar) {
        this.R = dVar;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    public void E0() {
    }

    public void E1(String str) {
    }

    public final void F1() {
        this.f12154f.getSettings().setLoadWithOverviewMode(true);
        this.f12154f.getSettings().setUseWideViewPort(true);
        this.f12154f.getSettings().setSupportZoom(true);
        this.f12154f.getSettings().setBuiltInZoomControls(true);
        this.f12154f.getSettings().setDisplayZoomControls(false);
    }

    public boolean G1() {
        return this.W;
    }

    public final void H1(Context context) {
        d.b.g0.a.p.c.b b2 = d.b.g0.a.r1.d.e().o().a().b();
        if (b2 != null) {
            b2.a(context);
        }
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager
    public void J0(SwanAppWebViewManager swanAppWebViewManager) {
        super.J0(swanAppWebViewManager);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    public void N0(SwanAppWebViewManager.d dVar) {
        super.N0(dVar);
        dVar.f12181a = false;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager
    public void O0() {
        super.O0();
        d.b.g0.a.t1.k.r0.f fVar = new d.b.g0.a.t1.k.r0.f(this.l);
        fVar.j(this);
        this.l.b(fVar);
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, d.b.g0.a.p.d.b
    public void P(d.b.g0.a.e0.n.d dVar) {
        this.U = dVar;
    }

    @Override // com.baidu.swan.apps.core.SwanAppWebViewManager, d.b.g0.a.p.d.d
    public String S() {
        return "ai_apps_widget";
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, d.b.g0.a.p.d.d
    public void W() {
        super.W();
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, d.b.g0.a.p.d.d
    public void destroy() {
        this.U = null;
        super.destroy();
    }

    @Override // d.b.g0.a.p.d.e
    @Nullable
    public d.b.g0.a.t1.k.r0.d getParams() {
        return this.R;
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, d.b.g0.a.p.d.d
    public void loadUrl(String str) {
        if (G1() && !d.b.g0.a.s1.a.b.h(str)) {
            v1().b(str);
        } else {
            super.loadUrl(str);
        }
    }

    @Override // com.baidu.swan.apps.core.slave.SwanAppSlaveManager, com.baidu.swan.apps.core.SwanAppWebViewManager, d.b.g0.a.p.d.d
    public void onPause() {
        super.onPause();
        A1();
    }

    public void u1() {
        d.b.g0.a.e0.l.c m;
        d.b.g0.a.e0.l.f W = d.b.g0.a.z0.f.V().W();
        if (W == null || (m = W.m()) == null || m.W() == null) {
            return;
        }
        View view = null;
        if (m instanceof d.b.g0.a.e0.l.e) {
            if (((d.b.g0.a.e0.l.e) m).T2().n() == null) {
                return;
            }
            view = m.W().findViewById(d.b.g0.a.f.ai_apps_fragment_base_view);
        } else if (m instanceof d.b.g0.a.e0.l.i) {
            if (((d.b.g0.a.e0.l.i) m).n() == null || m.W() == null) {
                return;
            }
            view = m.W().findViewById(d.b.g0.a.f.swan_app_webview_fragment);
        }
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new b(view, m));
    }

    public final c v1() {
        if (this.Q == null) {
            this.Q = new c(getWebView().getContext(), getWebView());
        }
        return this.Q;
    }

    public final d w1() {
        if (this.P == null) {
            d dVar = new d(getWebView().getContext(), getWebView());
            this.P = dVar;
            dVar.b(new a());
        }
        return this.P;
    }

    public final e x1() {
        if (this.O == null) {
            this.O = new e(getWebView().getContext(), getWebView());
        }
        return this.O;
    }

    public int y1() {
        EfficientProgressBar efficientProgressBar;
        e eVar = this.O;
        if (eVar == null || (efficientProgressBar = eVar.f12198a) == null) {
            return 0;
        }
        return efficientProgressBar.getHeight();
    }

    public final void z1() {
        d.b.g0.a.e0.m.e eVar = this.S;
        if (eVar != null) {
            eVar.a();
        }
    }
}
