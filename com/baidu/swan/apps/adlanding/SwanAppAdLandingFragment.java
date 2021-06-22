package com.baidu.swan.apps.adlanding;

import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.browser.sailor.ISailorDownloadListener;
import com.baidu.swan.apps.adlanding.customer.CustomerAdScrollView;
import com.baidu.swan.apps.adlanding.customer.WebViewContainer;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import d.a.m0.a.h0.g.k;
import d.a.m0.a.v2.q0;
import d.a.m0.a.v2.u;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SwanAppAdLandingFragment extends k {
    public static final boolean A1 = d.a.m0.a.k.f46983a;
    public String J0;
    public d.a.m0.a.i1.g.a L0;
    public d.a.m0.f.i.q.c M0;
    public FrameLayout N0;
    public d.a.m0.f.i.k.f.f R0;
    public d.a.m0.f.i.k.f.a S0;
    public DownloadParams T0;
    public RelativeLayout V0;
    public int W0;
    public int X0;
    public int Y0;
    public String Z0;
    public String a1;
    public String b1;
    public String c1;
    public String d1;
    public String e1;
    public JSONObject f1;
    public WebViewContainer j1;
    public LinearLayout k1;
    public ViewGroup l1;
    public int n1;
    public int o1;
    public String p1;
    public String q1;
    public float r1;
    public float s1;
    public FrameLayout t1;
    public int u1;
    public int v1;
    public int w1;
    public String x1;
    public d.a.m0.a.q.e.b y1;
    public LandingType K0 = LandingType.NORMAL;
    public String O0 = "";
    public String P0 = "";
    public String Q0 = "";
    public DownloadState U0 = DownloadState.NOT_START;
    public int g1 = 0;
    public int h1 = 0;
    public boolean i1 = true;
    public Boolean m1 = Boolean.FALSE;
    public View.OnClickListener z1 = new j();

    /* loaded from: classes2.dex */
    public enum ActionType {
        LP(1),
        DL(2);
        
        public int type;

        ActionType(int i2) {
            this.type = i2;
        }

        public int value() {
            return this.type;
        }
    }

    /* loaded from: classes2.dex */
    public enum LandingType {
        NORMAL,
        VIDEO
    }

    /* loaded from: classes2.dex */
    public class a extends d.a.m0.a.h0.j.a {

        /* renamed from: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0153a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f10518e;

            public RunnableC0153a(String str) {
                this.f10518e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                SwanAppAdLandingFragment.this.n0.setTitle(TextUtils.isEmpty(this.f10518e) ? "" : this.f10518e);
            }
        }

        public a() {
        }

        @Override // d.a.m0.a.h0.j.a, d.a.m0.a.h0.j.d
        public void a(String str) {
            SwanAppAdLandingFragment swanAppAdLandingFragment = SwanAppAdLandingFragment.this;
            swanAppAdLandingFragment.F3(swanAppAdLandingFragment.D0.canGoBack());
            SwanAppAdLandingFragment.this.n0.post(new RunnableC0153a(str));
        }

        @Override // d.a.m0.a.h0.j.a, d.a.m0.a.h0.j.d
        public boolean c(String str) {
            if (d.a.m0.a.b2.a.b.e(str) || d.a.m0.a.b2.a.b.f(str)) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
                    if (Q != null) {
                        Q.x().startActivity(intent);
                        return true;
                    }
                } catch (Exception e2) {
                    if (SwanAppAdLandingFragment.A1) {
                        e2.printStackTrace();
                    }
                }
            }
            return super.c(str);
        }

        @Override // d.a.m0.a.h0.j.a, d.a.m0.a.h0.j.d
        public void e(String str) {
            super.e(str);
            if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.c1)) {
                return;
            }
            SwanAppAdLandingFragment.this.M0.e(SwanAppAdLandingFragment.this.c1);
        }

        @Override // d.a.m0.a.h0.j.a, d.a.m0.a.h0.j.d
        public void goBack() {
            SwanAppAdLandingFragment swanAppAdLandingFragment = SwanAppAdLandingFragment.this;
            swanAppAdLandingFragment.F3(swanAppAdLandingFragment.D0.canGoBack());
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            k.L2();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.a.m0.a.i1.g.b {
        public c() {
        }

        @Override // d.a.m0.a.i1.g.b
        public void a(d.a.m0.a.c1.d.j jVar) {
            SwanAppAdLandingFragment.this.X3("vcontinueplay");
        }

        @Override // d.a.m0.a.i1.g.b
        public void b(d.a.m0.a.c1.d.j jVar) {
            SwanAppAdLandingFragment.this.V0.bringToFront();
            SwanAppAdLandingFragment.this.V0.setVisibility(0);
            SwanAppAdLandingFragment.this.g1 = 0;
            SwanAppAdLandingFragment.h3(SwanAppAdLandingFragment.this);
            SwanAppAdLandingFragment.this.X3("vplayend");
            SwanAppAdLandingFragment.this.X3("scard");
        }

        @Override // d.a.m0.a.i1.g.b
        public void c(d.a.m0.a.c1.d.j jVar) {
            SwanAppAdLandingFragment.this.X3("vpause");
        }

        @Override // d.a.m0.a.i1.g.b
        public void d(d.a.m0.a.c1.d.j jVar) {
            if (SwanAppAdLandingFragment.this.h1 == 0) {
                SwanAppAdLandingFragment.this.X3("vstart");
                return;
            }
            SwanAppAdLandingFragment.this.V0.setVisibility(8);
            SwanAppAdLandingFragment.this.X3("vrepeatedplay");
        }

        @Override // d.a.m0.a.i1.g.b
        public void e(d.a.m0.a.c1.d.j jVar) {
        }

        @Override // d.a.m0.a.i1.g.b
        public boolean f(d.a.m0.a.c1.d.j jVar, int i2, int i3) {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* loaded from: classes2.dex */
    public class e implements d.a.m0.f.i.k.f.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f10523a;

        public e(ViewGroup viewGroup) {
            this.f10523a = viewGroup;
        }

        @Override // d.a.m0.f.i.k.f.a
        public void a(int i2) {
            SwanAppAdLandingFragment.this.R0.d(i2);
        }

        @Override // d.a.m0.f.i.k.f.a
        public void b() {
            SwanAppAdLandingFragment.this.X3("appinstallbegin");
        }

        @Override // d.a.m0.f.i.k.f.a
        public void c(DownloadState downloadState, int i2) {
            SwanAppAdLandingFragment.this.R0.b(downloadState);
            if (SwanAppAdLandingFragment.this.U0 == downloadState) {
                return;
            }
            if (SwanAppAdLandingFragment.this.U0 == DownloadState.NOT_START && downloadState == DownloadState.DOWNLOADING) {
                SwanAppAdLandingFragment.this.X3("appdownloadbegin");
            } else if (downloadState == DownloadState.DOWNLOAD_PAUSED) {
                SwanAppAdLandingFragment.this.X3("appdownloadpause");
            } else if (SwanAppAdLandingFragment.this.U0 == DownloadState.DOWNLOAD_PAUSED && downloadState == DownloadState.DOWNLOADING) {
                SwanAppAdLandingFragment.this.X3("appdownloadcontinue");
            } else if (downloadState == DownloadState.DOWNLOADED) {
                SwanAppAdLandingFragment.this.X3("appdownloadfinish");
                SwanAppAdLandingFragment.this.X3("appinstallbegin");
            } else if (downloadState == DownloadState.INSTALLED) {
                SwanAppAdLandingFragment.this.X3("appinstallfinish");
            }
            SwanAppAdLandingFragment.this.U0 = downloadState;
        }

        @Override // d.a.m0.f.i.k.f.a
        public void d(String str) {
            SwanAppAdLandingFragment.this.V3(str);
        }

        @Override // d.a.m0.f.i.k.f.a
        public String e() {
            SwanAppAdLandingFragment.this.X3("appinstallopen");
            SwanAppAdLandingFragment swanAppAdLandingFragment = SwanAppAdLandingFragment.this;
            return swanAppAdLandingFragment.G3(swanAppAdLandingFragment.T0.f11678a);
        }

        @Override // d.a.m0.f.i.k.f.a
        public void f(boolean z) {
            if (z) {
                this.f10523a.removeView(SwanAppAdLandingFragment.this.R0.getRealView());
                this.f10523a.addView(SwanAppAdLandingFragment.this.R0.getRealView());
                return;
            }
            this.f10523a.removeView(SwanAppAdLandingFragment.this.R0.getRealView());
        }
    }

    /* loaded from: classes2.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ View f10525e;

        public f(View view) {
            this.f10525e = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            int height = SwanAppAdLandingFragment.this.N0.getHeight();
            if (SwanAppAdLandingFragment.this.R3() || SwanAppAdLandingFragment.this.P3()) {
                ViewGroup.LayoutParams layoutParams = this.f10525e.getLayoutParams();
                layoutParams.height = height;
                this.f10525e.setLayoutParams(layoutParams);
            }
            if (SwanAppAdLandingFragment.this.R3()) {
                ViewGroup.LayoutParams layoutParams2 = SwanAppAdLandingFragment.this.j1.getLayoutParams();
                layoutParams2.height = height + (SwanAppAdLandingFragment.this.m1.booleanValue() ? SwanAppAdLandingFragment.this.v1 : SwanAppAdLandingFragment.this.W0);
                SwanAppAdLandingFragment.this.j1.setLayoutParams(layoutParams2);
            }
            SwanAppAdLandingFragment.this.l1.removeView(SwanAppAdLandingFragment.this.N0);
            if (SwanAppAdLandingFragment.this.k1 != null) {
                SwanAppAdLandingFragment.this.k1.setVisibility(0);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements d.a.m0.a.h0.j.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CustomerAdScrollView f10527a;

        public g(CustomerAdScrollView customerAdScrollView) {
            this.f10527a = customerAdScrollView;
        }

        @Override // d.a.m0.a.h0.j.c
        public void onScrollChanged(int i2, int i3, int i4, int i5) {
            this.f10527a.setIsWebViewOnBottom(((((float) SwanAppAdLandingFragment.this.D0.getContentHeight()) * SwanAppAdLandingFragment.this.D0.getScale()) - ((float) SwanAppAdLandingFragment.this.D0.covertToView().getHeight())) - ((float) SwanAppAdLandingFragment.this.D0.getWebViewScrollY()) < 10.0f);
        }
    }

    /* loaded from: classes2.dex */
    public class h extends d.a.m0.a.h0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CustomerAdScrollView f10529a;

        public h(CustomerAdScrollView customerAdScrollView) {
            this.f10529a = customerAdScrollView;
        }

        @Override // d.a.m0.a.h0.b
        public void a(String str) {
            super.a(str);
            if (Math.abs((SwanAppAdLandingFragment.this.D0.getContentHeight() * SwanAppAdLandingFragment.this.D0.getScale()) - SwanAppAdLandingFragment.this.D0.covertToView().getHeight()) < 10.0f) {
                this.f10529a.setIsWebViewOnBottom(true);
            } else {
                this.f10529a.setIsWebViewOnBottom(false);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i implements d.a.m0.a.q.e.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CustomerAdScrollView f10531a;

        public i(CustomerAdScrollView customerAdScrollView) {
            this.f10531a = customerAdScrollView;
        }

        @Override // d.a.m0.a.q.e.a
        public void onScrollChanged(int i2, int i3, int i4, int i5) {
            CustomerAdScrollView customerAdScrollView = this.f10531a;
            SwanAppAdLandingFragment swanAppAdLandingFragment = SwanAppAdLandingFragment.this;
            customerAdScrollView.setIsFooterLayoutShow(swanAppAdLandingFragment.S3(swanAppAdLandingFragment.k1));
        }
    }

    /* loaded from: classes2.dex */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            HashMap<String, String> hashMap = new HashMap<>();
            if (id == d.a.m0.a.f.ad_tail_head_image) {
                hashMap.put("da_area", "tail_icon");
            } else if (id == d.a.m0.a.f.ad_tail_brand_name) {
                hashMap.put("da_area", "tail_name");
            } else if (id == d.a.m0.a.f.ad_tail_btn) {
                hashMap.put("da_area", SwanAppAdLandingFragment.this.Y0 == ActionType.DL.value() ? "tail_downloadbtn" : "tail_detailbtn");
            }
            SwanAppAdLandingFragment.this.M0.d("c", hashMap);
            k.Q2("adLanding", d.a.m0.a.l1.b.e(SwanAppAdLandingFragment.this.J0, SwanAppAdLandingFragment.this.J0));
        }
    }

    public static /* synthetic */ int h3(SwanAppAdLandingFragment swanAppAdLandingFragment) {
        int i2 = swanAppAdLandingFragment.h1;
        swanAppAdLandingFragment.h1 = i2 + 1;
        return i2;
    }

    @Override // d.a.m0.a.h0.g.k, com.baidu.swan.support.v4.app.Fragment
    public View B0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.a.m0.a.g.aiapps_webview_fragment, viewGroup, false);
        Q1(inflate);
        this.l1 = (ViewGroup) inflate.findViewById(d.a.m0.a.f.swan_app_webview_fragment);
        this.N0 = (FrameLayout) inflate.findViewById(d.a.m0.a.f.aiapps_webView_container);
        M3();
        O3();
        H3(this.j1);
        N3();
        if (R3()) {
            L3();
            K3();
        }
        if (P1()) {
            inflate = S1(inflate);
        }
        this.M0 = new d.a.m0.f.i.q.c(q(), this.f1);
        X3("lpin");
        return A1(inflate, this);
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void F0(boolean z) {
        super.F0(z);
        if (z) {
            U3();
        } else {
            W3();
        }
    }

    public final void F3(boolean z) {
        this.n0.setLeftHomeViewVisibility(z ? 0 : 8);
    }

    public final String G3(String str) {
        return d.a.m0.a.k2.g.h.a().getString(str, "");
    }

    public final void H3(ViewGroup viewGroup) {
        this.S0 = new e(viewGroup);
        this.T0 = new DownloadParams(this.P0, this.Q0);
        d.a.m0.f.i.k.g.b bVar = new d.a.m0.f.i.k.g.b();
        bVar.l(q(), this.T0, this.S0);
        this.R0 = bVar;
        bVar.e(this.T0);
    }

    public final void I3(ViewGroup viewGroup, ViewGroup viewGroup2) {
        this.k1 = (LinearLayout) ((LinearLayout) LayoutInflater.from(q()).inflate(d.a.m0.a.g.swanapp_ad_footer_view, (ViewGroup) null)).findViewById(d.a.m0.a.f.ad_footer);
        CustomerAdScrollView customerAdScrollView = new CustomerAdScrollView(q());
        LinearLayout linearLayout = new LinearLayout(q());
        linearLayout.setOrientation(1);
        linearLayout.addView(viewGroup2, new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(this.k1, new LinearLayout.LayoutParams(-1, q().getResources().getDimensionPixelSize(d.a.m0.a.d.swanapp_ad_dimens_footer_height)));
        customerAdScrollView.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        viewGroup.addView(customerAdScrollView);
        this.C0.v(new g(customerAdScrollView));
        this.C0.c(new h(customerAdScrollView));
        customerAdScrollView.setScrollViewListener(new i(customerAdScrollView));
    }

    public final void J3() {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(q()).inflate(d.a.m0.a.g.swanapp_ad_landing_portrait_video, (ViewGroup) null);
        this.j1.addView(relativeLayout, new FrameLayout.LayoutParams(-1, this.v1));
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) relativeLayout.findViewById(d.a.m0.a.f.ad_landing_bg_image);
        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) relativeLayout.findViewById(d.a.m0.a.f.ad_landing_mask);
        this.t1 = (FrameLayout) relativeLayout.findViewById(d.a.m0.a.f.ad_landing_video);
        if (!TextUtils.isEmpty(this.p1)) {
            simpleDraweeView.setImageURI(Uri.parse(this.p1));
            simpleDraweeView.setOnClickListener(this.z1);
        } else {
            simpleDraweeView.setVisibility(4);
        }
        if (!TextUtils.isEmpty(this.q1)) {
            simpleDraweeView2.setImageURI(Uri.parse(this.q1));
        } else {
            simpleDraweeView2.setVisibility(4);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.t1.getLayoutParams();
        layoutParams.width = this.X0;
        layoutParams.height = this.W0;
        layoutParams.rightMargin = this.w1;
        this.t1.setLayoutParams(layoutParams);
    }

    @Override // d.a.m0.a.h0.g.k, d.a.m0.a.h0.g.d
    public boolean K() {
        d.a.m0.a.i1.g.a aVar;
        if (Q3() && (aVar = this.L0) != null) {
            return aVar.onBackPressed();
        }
        X3("lpout");
        return super.K();
    }

    public final void K3() {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(q()).inflate(d.a.m0.a.g.swanapp_ad_video_tail_view, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.height = this.m1.booleanValue() ? this.v1 : this.W0;
        this.V0 = (RelativeLayout) relativeLayout.findViewById(d.a.m0.a.f.ad_tail_root);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) relativeLayout.findViewById(d.a.m0.a.f.ad_tail_video_img);
        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) relativeLayout.findViewById(d.a.m0.a.f.ad_tail_head_image);
        TextView textView = (TextView) relativeLayout.findViewById(d.a.m0.a.f.ad_tail_brand_name);
        TextView textView2 = (TextView) relativeLayout.findViewById(d.a.m0.a.f.ad_tail_btn);
        if (!TextUtils.isEmpty(this.Z0)) {
            textView2.setText(this.Z0);
            textView2.setVisibility(0);
        } else {
            textView2.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.a1)) {
            textView.setText(this.a1);
            textView.setVisibility(0);
        } else {
            textView.setVisibility(4);
        }
        if (!TextUtils.isEmpty(this.b1)) {
            simpleDraweeView2.setImageURI(Uri.parse(this.b1));
            simpleDraweeView2.setVisibility(0);
        } else {
            simpleDraweeView2.setVisibility(8);
        }
        simpleDraweeView.getHierarchy().setPlaceholderImage(z().getDrawable(d.a.m0.a.e.swanapp_ad_tab_video_img_default_icon));
        String str = this.m1.booleanValue() ? this.x1 : this.d1;
        if (!TextUtils.isEmpty(str)) {
            simpleDraweeView.setImageURI(u.m(str));
        }
        simpleDraweeView.setVisibility(0);
        simpleDraweeView.setOnClickListener(new d());
        simpleDraweeView2.setOnClickListener(this.z1);
        textView.setOnClickListener(this.z1);
        textView2.setOnClickListener(this.z1);
        this.j1.addView(this.V0, layoutParams);
        this.V0.setVisibility(4);
    }

    public final void L3() {
        if (this.m1.booleanValue()) {
            J3();
        }
        d.a.m0.a.q.c cVar = new d.a.m0.a.q.c(this.d1, this.e1, this.C0.b(), this.m1.booleanValue() ? 0 : this.X0, this.m1.booleanValue() ? 0 : this.W0, this.g1, this.m1.booleanValue());
        d.a.m0.a.i1.g.a aVar = new d.a.m0.a.i1.g.a(q(), cVar.a());
        this.L0 = aVar;
        this.y1.p(aVar);
        this.L0.u(new c());
        if (this.m1.booleanValue()) {
            this.L0.w(this.t1);
        }
        this.L0.o(cVar.a());
        this.L0.v(false);
    }

    @Override // d.a.m0.a.h0.g.k
    public d.a.m0.a.h0.j.d M2() {
        return new a();
    }

    public final void M3() {
        DisplayMetrics displayMetrics = h().getResources().getDisplayMetrics();
        int i2 = displayMetrics != null ? displayMetrics.widthPixels : 0;
        if (this.m1.booleanValue()) {
            float f2 = this.o1 / this.n1;
            this.u1 = i2;
            int i3 = (int) (i2 * f2);
            this.v1 = i3;
            this.X0 = (int) (i2 * this.r1);
            this.W0 = i3;
            this.w1 = (int) (i2 * this.s1);
            return;
        }
        this.W0 = (i2 * 9) / 16;
        this.X0 = i2;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [d.a.m0.a.p.e.c] */
    public final void N3() {
        d.a.m0.a.p.e.e m = m();
        this.C0 = m;
        m.Z(M2());
        this.D0 = this.C0.u();
        this.C0.loadUrl(this.J0);
        FrameLayout frameLayout = new FrameLayout(q());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View covertToView = this.D0.covertToView();
        d.a.m0.a.a2.n.g gVar = new d.a.m0.a.a2.n.g();
        gVar.f44580e = SwanAppConfigData.s("#FFFFFF");
        this.C0.B(frameLayout, gVar);
        this.C0.Q(frameLayout, gVar);
        this.C0.l(frameLayout, covertToView);
        if (P3()) {
            I3(this.j1, frameLayout);
        } else {
            this.j1.addView(frameLayout);
        }
        WebViewContainer webViewContainer = this.j1;
        if (webViewContainer != null) {
            webViewContainer.setInternalWebView(this.D0);
        }
        if (R3()) {
            layoutParams.topMargin = this.m1.booleanValue() ? this.v1 : this.W0;
        }
        covertToView.setLayoutParams(layoutParams);
        this.N0.post(new f(covertToView));
    }

    public final void O3() {
        d.a.m0.a.q.e.b bVar = new d.a.m0.a.q.e.b(q());
        this.y1 = bVar;
        bVar.o(R3() ? this.W0 : 0);
        WebViewContainer k = this.y1.k();
        this.j1 = k;
        this.l1.addView(k);
    }

    public final boolean P3() {
        return TextUtils.equals("swan-custom-ad", this.O0);
    }

    @Override // d.a.m0.a.h0.g.k, d.a.m0.a.h0.g.d
    public void Q1(View view) {
        super.Q1(view);
        this.n0.setLeftHomeViewSrc(d.a.m0.a.e.aiapps_action_bar_close_black_selector);
        this.n0.setLeftHomeViewClickListener(new b());
    }

    public final boolean Q3() {
        return h().getResources().getConfiguration().orientation == 2;
    }

    public final boolean R3() {
        return this.K0 == LandingType.VIDEO;
    }

    public final boolean S3(View view) {
        if (view == null || view.getVisibility() != 0) {
            return false;
        }
        return view.getGlobalVisibleRect(new Rect());
    }

    public final void T3() {
        String J;
        Bundle n = n();
        if (n == null) {
            return;
        }
        this.J0 = n.getString("url", "");
        if (TextUtils.isEmpty(this.F0)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.F0);
            this.e1 = jSONObject.optString("vurl", "");
            this.d1 = jSONObject.optString("w_picurl", "");
            this.b1 = jSONObject.optString("icon", "");
            int optInt = jSONObject.optInt("act", ActionType.LP.value());
            this.Y0 = optInt;
            if (optInt == ActionType.DL.value()) {
                J = J(d.a.m0.a.h.swanapp_ad_download_button);
            } else {
                J = J(d.a.m0.a.h.swanapp_ad_landingpage_button);
            }
            this.Z0 = J;
            this.a1 = jSONObject.optString("appname", "");
            this.g1 = jSONObject.optInt("currentTime", 0);
            this.f1 = jSONObject.optJSONObject("monitors");
            this.P0 = jSONObject.optString("url", "");
            this.Q0 = jSONObject.optString("name", "");
            this.O0 = jSONObject.optString("from", "");
            this.c1 = jSONObject.optString("monitorUrl", "");
            this.n1 = jSONObject.optInt("w", 16);
            this.o1 = jSONObject.optInt("h", 9);
            this.p1 = jSONObject.optString("playingbg", "");
            this.q1 = jSONObject.optString("maskUrl", "");
            this.r1 = (float) jSONObject.optDouble("playerWidthRatio", 0.5d);
            this.s1 = (float) jSONObject.optDouble("rightMarginRatio", 0.0d);
            this.x1 = jSONObject.optString("horizontalCover", "");
        } catch (JSONException e2) {
            if (A1) {
                e2.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(this.e1)) {
            this.K0 = LandingType.VIDEO;
        }
        this.m1 = Boolean.valueOf(TextUtils.equals("ad-video-portrait", this.O0));
    }

    public final void U3() {
        d.a.m0.a.i1.g.a aVar = this.L0;
        if (aVar == null || !aVar.n()) {
            return;
        }
        this.L0.p();
    }

    public final void V3(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.a.m0.a.k2.g.h.a().putString(this.T0.f11678a, str);
    }

    public final void W3() {
        d.a.m0.a.i1.g.a aVar = this.L0;
        if (aVar == null || aVar.n() || this.L0.m()) {
            return;
        }
        this.L0.r();
    }

    @Override // d.a.m0.a.h0.g.k, d.a.m0.a.h0.g.d
    public boolean X1() {
        return true;
    }

    public final void X3(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        d.a.m0.a.i1.g.a aVar = this.L0;
        if (aVar != null) {
            hashMap.put("cur_time", String.valueOf(aVar.e() / 1000));
        }
        this.M0.d(str, hashMap);
    }

    @Override // d.a.m0.a.h0.g.k
    public d.a.m0.a.p.e.e m() {
        d.a.m0.a.q.d dVar = new d.a.m0.a.q.d(q());
        dVar.u().setDownloadListener(new ISailorDownloadListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.9
            @Override // com.baidu.browser.sailor.ISailorDownloadListener
            public void onDownloadFlash(String str) {
            }

            @Override // com.baidu.browser.sailor.ISailorDownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                if (SwanAppAdLandingFragment.A1) {
                    Log.d("SwanAppAdLandFragment", "onDownloadStart: url=" + str + ", userAgent=" + str2 + ", mimeType=" + str4);
                }
                SwanAppAdLandingFragment.this.R0.f();
                if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.T0.f11679b)) {
                    String G3 = SwanAppAdLandingFragment.this.G3(str);
                    SwanAppAdLandingFragment.this.T0.f11679b = G3;
                    SwanAppAdLandingFragment.this.R0.a(G3);
                }
                if (q0.F(SwanAppAdLandingFragment.this.q(), SwanAppAdLandingFragment.this.T0.f11679b)) {
                    SwanAppAdLandingFragment.this.j1.removeView(SwanAppAdLandingFragment.this.R0.getRealView());
                    SwanAppAdLandingFragment.this.j1.addView(SwanAppAdLandingFragment.this.R0.getRealView());
                    SwanAppAdLandingFragment.this.R0.b(DownloadState.INSTALLED);
                    return;
                }
                if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.T0.f11678a)) {
                    SwanAppAdLandingFragment.this.T0.f11678a = str;
                }
                d.a.m0.a.c1.a.c().b(SwanAppAdLandingFragment.this.q(), SwanAppAdLandingFragment.this.T0.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, SwanAppAdLandingFragment.this.S0);
            }

            @Override // com.baidu.browser.sailor.ISailorDownloadListener
            public void onPlayVideo(String str) {
            }
        });
        return dVar;
    }

    @Override // d.a.m0.a.h0.g.k, com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        T3();
        FragmentActivity h2 = h();
        if (h2 != null) {
            boolean z = 1 == h2.getRequestedOrientation();
            this.i1 = z;
            if (!z) {
                x2(1);
            }
        }
        if (A1) {
            Log.d("SwanAppAdLandFragment", "onCreate() : " + this);
        }
    }

    @Override // d.a.m0.a.h0.g.k, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (R3()) {
            X3("vplayend");
        }
        d.a.m0.a.i1.g.a aVar = this.L0;
        if (aVar != null) {
            aVar.onDestroy();
        }
        if (!this.i1) {
            x2(0);
        }
        super.onDestroy();
    }

    @Override // d.a.m0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        U3();
    }

    @Override // d.a.m0.a.h0.g.d, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        d.a.m0.a.q.e.b bVar = this.y1;
        if (bVar == null || !bVar.l() || p0()) {
            return;
        }
        W3();
    }
}
