package com.baidu.swan.apps.adlanding;

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
import com.baidu.swan.apps.adlanding.download.model.SwanAdDownloadState;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import d.a.h0.a.i2.k0;
import d.a.h0.a.i2.t;
import d.a.h0.a.k;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SwanAppAdLandingFragment extends d.a.h0.a.e0.l.i {
    public static final boolean p1 = k.f43101a;
    public String K0;
    public d.a.h0.a.b1.g.a M0;
    public d.a.h0.a.q.b N0;
    public FrameLayout O0;
    public d.a.h0.a.p.c.g S0;
    public d.a.h0.a.q.g.a.a T0;
    public d.a.h0.a.q.g.b.a U0;
    public RelativeLayout W0;
    public RelativeLayout X0;
    public SimpleDraweeView Y0;
    public SimpleDraweeView Z0;
    public TextView a1;
    public TextView b1;
    public int c1;
    public int d1;
    public int e1;
    public String f1;
    public String g1;
    public String h1;
    public String i1;
    public String j1;
    public JSONObject k1;
    public LandingType L0 = LandingType.NORMAL;
    public String P0 = "";
    public String Q0 = "";
    public String R0 = "";
    public SwanAdDownloadState V0 = SwanAdDownloadState.NOT_START;
    public int l1 = 0;
    public int m1 = 0;
    public boolean n1 = true;
    public View.OnClickListener o1 = new j();

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
    public class a extends d.a.h0.a.e0.n.a {

        /* renamed from: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0164a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f11401e;

            public RunnableC0164a(String str) {
                this.f11401e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                SwanAppAdLandingFragment.this.i0.setTitle(TextUtils.isEmpty(this.f11401e) ? "" : this.f11401e);
            }
        }

        public a() {
        }

        @Override // d.a.h0.a.e0.n.a, d.a.h0.a.e0.n.d
        public void a(String str) {
            SwanAppAdLandingFragment swanAppAdLandingFragment = SwanAppAdLandingFragment.this;
            swanAppAdLandingFragment.o3(swanAppAdLandingFragment.z0.canGoBack());
            SwanAppAdLandingFragment.this.i0.post(new RunnableC0164a(str));
        }

        @Override // d.a.h0.a.e0.n.a, d.a.h0.a.e0.n.d
        public void goBack() {
            SwanAppAdLandingFragment swanAppAdLandingFragment = SwanAppAdLandingFragment.this;
            swanAppAdLandingFragment.o3(swanAppAdLandingFragment.z0.canGoBack());
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.h0.a.e0.l.i.E2();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.a.h0.a.b1.g.b {
        public c() {
        }

        @Override // d.a.h0.a.b1.g.b
        public void a(d.a.h0.a.w0.c.j jVar) {
            SwanAppAdLandingFragment.this.N0.c("vcontinueplay");
        }

        @Override // d.a.h0.a.b1.g.b
        public void b(d.a.h0.a.w0.c.j jVar) {
            SwanAppAdLandingFragment.this.X0.bringToFront();
            SwanAppAdLandingFragment.this.X0.setVisibility(0);
            SwanAppAdLandingFragment.this.l1 = 0;
            SwanAppAdLandingFragment.a3(SwanAppAdLandingFragment.this);
            SwanAppAdLandingFragment.this.N0.c("vplayend");
            SwanAppAdLandingFragment.this.N0.c("scard");
        }

        @Override // d.a.h0.a.b1.g.b
        public void c(d.a.h0.a.w0.c.j jVar) {
            SwanAppAdLandingFragment.this.N0.c("vpause");
        }

        @Override // d.a.h0.a.b1.g.b
        public void d(d.a.h0.a.w0.c.j jVar) {
            if (SwanAppAdLandingFragment.this.m1 == 0) {
                SwanAppAdLandingFragment.this.N0.c("vstart");
                return;
            }
            SwanAppAdLandingFragment.this.X0.setVisibility(8);
            SwanAppAdLandingFragment.this.N0.c("vrepeatedplay");
        }

        @Override // d.a.h0.a.b1.g.b
        public void e(d.a.h0.a.w0.c.j jVar) {
        }

        @Override // d.a.h0.a.b1.g.b
        public boolean f(d.a.h0.a.w0.c.j jVar, int i2, int i3) {
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
    public class e implements d.a.h0.a.q.g.a.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f11406a;

        public e(ViewGroup viewGroup) {
            this.f11406a = viewGroup;
        }

        @Override // d.a.h0.a.q.g.a.a
        public void a() {
            SwanAppAdLandingFragment.this.N0.c("appinstallbegin");
        }

        @Override // d.a.h0.a.q.g.a.a
        public void b(SwanAdDownloadState swanAdDownloadState, int i2) {
            SwanAppAdLandingFragment.this.S0.d(i2);
        }

        @Override // d.a.h0.a.q.g.a.a
        public void c(SwanAdDownloadState swanAdDownloadState, int i2) {
            SwanAppAdLandingFragment.this.S0.b(swanAdDownloadState);
            if (SwanAppAdLandingFragment.this.V0 == swanAdDownloadState) {
                return;
            }
            if (SwanAppAdLandingFragment.this.V0 == SwanAdDownloadState.NOT_START && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                SwanAppAdLandingFragment.this.N0.c("appdownloadbegin");
            } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOAD_PAUSED) {
                SwanAppAdLandingFragment.this.N0.c("appdownloadpause");
            } else if (SwanAppAdLandingFragment.this.V0 == SwanAdDownloadState.DOWNLOAD_PAUSED && swanAdDownloadState == SwanAdDownloadState.DOWNLOADING) {
                SwanAppAdLandingFragment.this.N0.c("appdownloadcontinue");
            } else if (swanAdDownloadState == SwanAdDownloadState.DOWNLOADED) {
                SwanAppAdLandingFragment.this.N0.c("appdownloadfinish");
                SwanAppAdLandingFragment.this.N0.c("appinstallbegin");
            } else if (swanAdDownloadState == SwanAdDownloadState.INSTALLED) {
                SwanAppAdLandingFragment.this.N0.c("appinstallfinish");
            }
            SwanAppAdLandingFragment.this.V0 = swanAdDownloadState;
        }

        @Override // d.a.h0.a.q.g.a.a
        public void d(String str) {
            SwanAppAdLandingFragment.this.A3(str);
        }

        @Override // d.a.h0.a.q.g.a.a
        public String e() {
            SwanAppAdLandingFragment.this.N0.c("appinstallopen");
            SwanAppAdLandingFragment swanAppAdLandingFragment = SwanAppAdLandingFragment.this;
            return swanAppAdLandingFragment.p3(swanAppAdLandingFragment.U0.f43556a);
        }

        @Override // d.a.h0.a.q.g.a.a
        public void f(boolean z) {
            if (z) {
                this.f11406a.removeView(SwanAppAdLandingFragment.this.S0.getRealView());
                this.f11406a.addView(SwanAppAdLandingFragment.this.S0.getRealView());
                return;
            }
            this.f11406a.removeView(SwanAppAdLandingFragment.this.S0.getRealView());
        }
    }

    /* loaded from: classes2.dex */
    public class f implements d.a.h0.a.e0.n.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CustomerAdScrollView f11408a;

        public f(CustomerAdScrollView customerAdScrollView) {
            this.f11408a = customerAdScrollView;
        }

        @Override // d.a.h0.a.e0.n.c
        public void onScrollChanged(int i2, int i3, int i4, int i5) {
            this.f11408a.setIsWebViewOnBottom(((((float) SwanAppAdLandingFragment.this.z0.getContentHeight()) * SwanAppAdLandingFragment.this.z0.getScale()) - ((float) SwanAppAdLandingFragment.this.z0.covertToView().getHeight())) - ((float) SwanAppAdLandingFragment.this.z0.getWebViewScrollY()) < 10.0f);
        }
    }

    /* loaded from: classes2.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f11410e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f11411f;

        public g(ViewGroup viewGroup, ViewGroup viewGroup2) {
            this.f11410e = viewGroup;
            this.f11411f = viewGroup2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f11410e.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f11411f.getHeight()));
        }
    }

    /* loaded from: classes2.dex */
    public class h extends d.a.h0.a.e0.g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CustomerAdScrollView f11413a;

        public h(CustomerAdScrollView customerAdScrollView) {
            this.f11413a = customerAdScrollView;
        }

        @Override // d.a.h0.a.e0.g
        public void a(String str) {
            super.a(str);
            if (Math.abs((SwanAppAdLandingFragment.this.z0.getContentHeight() * SwanAppAdLandingFragment.this.z0.getScale()) - SwanAppAdLandingFragment.this.z0.covertToView().getHeight()) < 10.0f) {
                this.f11413a.setIsWebViewOnBottom(true);
            } else {
                this.f11413a.setIsWebViewOnBottom(false);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i implements d.a.h0.a.q.f.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CustomerAdScrollView f11415a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinearLayout f11416b;

        public i(CustomerAdScrollView customerAdScrollView, LinearLayout linearLayout) {
            this.f11415a = customerAdScrollView;
            this.f11416b = linearLayout;
        }

        @Override // d.a.h0.a.q.f.a
        public void onScrollChanged(int i2, int i3, int i4, int i5) {
            this.f11415a.setIsFooterLayoutShow(SwanAppAdLandingFragment.this.y3(this.f11416b));
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
            if (id == d.a.h0.a.f.ad_tail_head_image) {
                hashMap.put("da_area", "tail_icon");
            } else if (id == d.a.h0.a.f.ad_tail_brand_name) {
                hashMap.put("da_area", "tail_name");
            } else if (id == d.a.h0.a.f.ad_tail_btn) {
                hashMap.put("da_area", SwanAppAdLandingFragment.this.e1 == ActionType.DL.value() ? "tail_downloadbtn" : "tail_detailbtn");
            }
            SwanAppAdLandingFragment.this.N0.d("c", hashMap);
            d.a.h0.a.e0.l.i.J2("adLanding", d.a.h0.a.e1.b.c(SwanAppAdLandingFragment.this.K0, SwanAppAdLandingFragment.this.K0));
        }
    }

    public static /* synthetic */ int a3(SwanAppAdLandingFragment swanAppAdLandingFragment) {
        int i2 = swanAppAdLandingFragment.m1;
        swanAppAdLandingFragment.m1 = i2 + 1;
        return i2;
    }

    public final void A3(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.a.h0.a.a2.g.h.a().putString(this.U0.f43556a, str);
    }

    @Override // d.a.h0.a.e0.l.i
    public d.a.h0.a.e0.n.d F2() {
        return new a();
    }

    @Override // d.a.h0.a.e0.l.i, d.a.h0.a.e0.l.c
    public boolean I() {
        d.a.h0.a.b1.g.a aVar;
        if (w3() && (aVar = this.M0) != null) {
            return aVar.onBackPressed();
        }
        this.N0.c("lpout");
        return super.I();
    }

    @Override // d.a.h0.a.e0.l.i, d.a.h0.a.e0.l.c
    public void L1(View view) {
        super.L1(view);
        this.i0.setLeftHomeViewSrc(d.a.h0.a.e.aiapps_action_bar_close_black_selector);
        this.i0.setLeftHomeViewClickListener(new b());
    }

    @Override // d.a.h0.a.e0.l.i, d.a.h0.a.e0.l.c
    public boolean S1() {
        return true;
    }

    @Override // d.a.h0.a.e0.l.i
    public d.a.h0.a.p.d.e l() {
        d.a.h0.a.q.e eVar = new d.a.h0.a.q.e(m());
        eVar.s().setDownloadListener(new ISailorDownloadListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.9
            @Override // com.baidu.browser.sailor.ISailorDownloadListener
            public void onDownloadFlash(String str) {
            }

            @Override // com.baidu.browser.sailor.ISailorDownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                if (SwanAppAdLandingFragment.p1) {
                    Log.d("SwanAppAdLandFragment", "onDownloadStart: url=" + str + ", userAgent=" + str2 + ", mimeType=" + str4);
                }
                SwanAppAdLandingFragment.this.S0.f();
                if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.U0.f43557b)) {
                    String p3 = SwanAppAdLandingFragment.this.p3(str);
                    SwanAppAdLandingFragment.this.U0.f43557b = p3;
                    SwanAppAdLandingFragment.this.S0.a(p3);
                }
                if (k0.C(SwanAppAdLandingFragment.this.m(), SwanAppAdLandingFragment.this.U0.f43557b)) {
                    SwanAppAdLandingFragment.this.O0.removeView(SwanAppAdLandingFragment.this.S0.getRealView());
                    SwanAppAdLandingFragment.this.O0.addView(SwanAppAdLandingFragment.this.S0.getRealView());
                    SwanAppAdLandingFragment.this.S0.b(SwanAdDownloadState.INSTALLED);
                    return;
                }
                if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.U0.f43556a)) {
                    SwanAppAdLandingFragment.this.U0.f43556a = str;
                }
                d.a.h0.a.w0.a.d().a(SwanAppAdLandingFragment.this.m(), SwanAppAdLandingFragment.this.U0.a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, SwanAppAdLandingFragment.this.T0);
            }

            @Override // com.baidu.browser.sailor.ISailorDownloadListener
            public void onPlayVideo(String str) {
            }
        });
        return eVar;
    }

    public final void o3(boolean z) {
        this.i0.setLeftHomeViewVisibility(z ? 0 : 8);
    }

    @Override // d.a.h0.a.e0.l.i, com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        z3();
        FragmentActivity f2 = f();
        if (f2 != null) {
            boolean z = 1 == f2.getRequestedOrientation();
            this.n1 = z;
            if (!z) {
                r2(1);
            }
        }
        if (p1) {
            Log.d("SwanAppAdLandFragment", "onCreate() : " + this);
        }
    }

    @Override // d.a.h0.a.e0.l.i, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (x3()) {
            this.N0.c("vplayend");
        }
        d.a.h0.a.b1.g.a aVar = this.M0;
        if (aVar != null) {
            aVar.onDestroy();
        }
        if (!this.n1) {
            r2(0);
        }
        super.onDestroy();
    }

    public final String p3(String str) {
        return d.a.h0.a.a2.g.h.a().getString(str, "");
    }

    public final void q3(ViewGroup viewGroup) {
        d.a.h0.a.p.c.g a2 = d.a.h0.a.w0.a.a();
        if (a2 == null) {
            return;
        }
        this.T0 = new e(viewGroup);
        this.U0 = new d.a.h0.a.q.g.b.a(this.Q0, this.R0);
        d.a.h0.a.p.c.g c2 = a2.c(m(), this.U0, this.T0);
        this.S0 = c2;
        c2.e(this.U0);
    }

    public final void r3(ViewGroup viewGroup, ViewGroup viewGroup2) {
        LinearLayout linearLayout = (LinearLayout) ((LinearLayout) LayoutInflater.from(m()).inflate(d.a.h0.a.g.swanapp_ad_footer_view, (ViewGroup) null)).findViewById(d.a.h0.a.f.ad_footer);
        CustomerAdScrollView customerAdScrollView = new CustomerAdScrollView(m());
        LinearLayout linearLayout2 = new LinearLayout(m());
        linearLayout2.setOrientation(1);
        linearLayout2.addView(viewGroup2, new LinearLayout.LayoutParams(-1, -2));
        linearLayout2.addView(linearLayout, new LinearLayout.LayoutParams(-1, m().getResources().getDimensionPixelSize(d.a.h0.a.d.swanapp_ad_dimens_footer_height)));
        customerAdScrollView.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        viewGroup.addView(customerAdScrollView);
        this.y0.t(new f(customerAdScrollView));
        viewGroup2.post(new g(viewGroup2, viewGroup));
        this.y0.d(new h(customerAdScrollView));
        customerAdScrollView.setScrollViewListener(new i(customerAdScrollView, linearLayout));
    }

    public final void s3(ViewGroup viewGroup) {
        this.W0 = (RelativeLayout) LayoutInflater.from(m()).inflate(d.a.h0.a.g.swanapp_ad_video_tail_view, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.height = this.c1;
        this.X0 = (RelativeLayout) this.W0.findViewById(d.a.h0.a.f.ad_tail_root);
        this.Y0 = (SimpleDraweeView) this.W0.findViewById(d.a.h0.a.f.ad_tail_video_img);
        this.Z0 = (SimpleDraweeView) this.W0.findViewById(d.a.h0.a.f.ad_tail_head_image);
        this.a1 = (TextView) this.W0.findViewById(d.a.h0.a.f.ad_tail_brand_name);
        this.b1 = (TextView) this.W0.findViewById(d.a.h0.a.f.ad_tail_btn);
        if (!TextUtils.isEmpty(this.f1)) {
            this.b1.setText(this.f1);
            this.b1.setVisibility(0);
        } else {
            this.b1.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.g1)) {
            this.a1.setText(this.g1);
            this.a1.setVisibility(0);
        } else {
            this.a1.setVisibility(4);
        }
        if (!TextUtils.isEmpty(this.h1)) {
            this.Z0.setImageURI(Uri.parse(this.h1));
            this.Z0.setVisibility(0);
        } else {
            this.Z0.setVisibility(8);
        }
        this.Y0.getHierarchy().setPlaceholderImage(t().getDrawable(d.a.h0.a.e.swanapp_ad_tab_video_img_default_icon));
        if (!TextUtils.isEmpty(this.i1)) {
            this.Y0.setImageURI(t.e(this.i1));
        }
        this.Y0.setVisibility(0);
        this.Y0.setOnClickListener(new d());
        this.Z0.setOnClickListener(this.o1);
        this.a1.setOnClickListener(this.o1);
        this.b1.setOnClickListener(this.o1);
        viewGroup.addView(this.X0, layoutParams);
        this.X0.setVisibility(4);
    }

    public final void t3() {
        d.a.h0.a.q.d dVar = new d.a.h0.a.q.d(this.i1, this.j1, this.y0.c(), this.d1, this.c1, this.l1);
        d.a.h0.a.b1.g.a aVar = new d.a.h0.a.b1.g.a(m(), dVar.a());
        this.M0 = aVar;
        aVar.w(new c());
        this.M0.q(dVar.a());
        this.M0.x(false);
    }

    @Override // d.a.h0.a.e0.l.i, com.baidu.swan.support.v4.app.Fragment
    public View u0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.a.h0.a.g.aiapps_webview_fragment, viewGroup, false);
        L1(inflate);
        this.O0 = (FrameLayout) inflate.findViewById(d.a.h0.a.f.aiapps_webView_container);
        u3();
        q3(this.O0);
        v3(this.O0);
        if (x3()) {
            t3();
            s3(this.O0);
        }
        C2(this.O0);
        if (K1()) {
            inflate = N1(inflate);
        }
        d.a.h0.a.q.b bVar = new d.a.h0.a.q.b(m(), this.k1, this.M0);
        this.N0 = bVar;
        bVar.c("lpin");
        return u1(inflate, this);
    }

    public final void u3() {
        DisplayMetrics displayMetrics = f().getResources().getDisplayMetrics();
        int i2 = displayMetrics != null ? displayMetrics.widthPixels : 0;
        this.c1 = (i2 * 9) / 16;
        this.d1 = i2;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [d.a.h0.a.p.d.c] */
    public final void v3(ViewGroup viewGroup) {
        d.a.h0.a.p.d.e l = l();
        this.y0 = l;
        l.X(F2());
        this.z0 = this.y0.s();
        this.y0.loadUrl(this.K0);
        FrameLayout frameLayout = new FrameLayout(m());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View covertToView = this.z0.covertToView();
        d.a.h0.a.r1.n.c cVar = new d.a.h0.a.r1.n.c();
        cVar.f43860e = SwanAppConfigData.s("#FFFFFF");
        this.y0.z(frameLayout, cVar);
        this.y0.O(frameLayout, cVar);
        this.y0.k(frameLayout, covertToView);
        if (x3()) {
            layoutParams.topMargin = this.c1;
        }
        if (TextUtils.equals("swan-custom-ad", this.P0)) {
            r3(viewGroup, frameLayout);
        } else {
            viewGroup.addView(frameLayout);
        }
        covertToView.setLayoutParams(layoutParams);
    }

    public final boolean w3() {
        return f().getResources().getConfiguration().orientation == 2;
    }

    public final boolean x3() {
        return this.L0 == LandingType.VIDEO;
    }

    public final boolean y3(View view) {
        if (view == null || view.getVisibility() != 0) {
            return false;
        }
        return view.getGlobalVisibleRect(new Rect());
    }

    public final void z3() {
        String B;
        Bundle i2 = i();
        if (i2 == null) {
            return;
        }
        this.K0 = i2.getString("url", "");
        if (TextUtils.isEmpty(this.B0)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.B0);
            this.j1 = jSONObject.optString("vurl", "");
            this.i1 = jSONObject.optString("w_picurl", "");
            this.h1 = jSONObject.optString("icon", "");
            int optInt = jSONObject.optInt("act", ActionType.LP.value());
            this.e1 = optInt;
            if (optInt == ActionType.DL.value()) {
                B = B(d.a.h0.a.h.swanapp_ad_download_button);
            } else {
                B = B(d.a.h0.a.h.swanapp_ad_landingpage_button);
            }
            this.f1 = B;
            this.g1 = jSONObject.optString("appname", "");
            this.l1 = jSONObject.optInt("currentTime", 0);
            this.k1 = jSONObject.optJSONObject("monitors");
            this.Q0 = jSONObject.optString("url", "");
            this.R0 = jSONObject.optString("name", "");
            this.P0 = jSONObject.optString("from", "");
        } catch (JSONException e2) {
            if (p1) {
                e2.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(this.j1)) {
            return;
        }
        this.L0 = LandingType.VIDEO;
    }
}
