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
import d.b.g0.a.i2.k0;
import d.b.g0.a.i2.t;
import d.b.g0.a.k;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SwanAppAdLandingFragment extends d.b.g0.a.e0.l.i {
    public static final boolean p1 = k.f45051a;
    public String K0;
    public d.b.g0.a.b1.g.a M0;
    public d.b.g0.a.q.b N0;
    public FrameLayout O0;
    public d.b.g0.a.p.c.g S0;
    public d.b.g0.a.q.g.a.a T0;
    public d.b.g0.a.q.g.b.a U0;
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

        ActionType(int i) {
            this.type = i;
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
    public class a extends d.b.g0.a.e0.n.a {

        /* renamed from: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0166a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f11904e;

            public RunnableC0166a(String str) {
                this.f11904e = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                SwanAppAdLandingFragment.this.i0.setTitle(TextUtils.isEmpty(this.f11904e) ? "" : this.f11904e);
            }
        }

        public a() {
        }

        @Override // d.b.g0.a.e0.n.a, d.b.g0.a.e0.n.d
        public void a(String str) {
            SwanAppAdLandingFragment swanAppAdLandingFragment = SwanAppAdLandingFragment.this;
            swanAppAdLandingFragment.p3(swanAppAdLandingFragment.z0.canGoBack());
            SwanAppAdLandingFragment.this.i0.post(new RunnableC0166a(str));
        }

        @Override // d.b.g0.a.e0.n.a, d.b.g0.a.e0.n.d
        public void goBack() {
            SwanAppAdLandingFragment swanAppAdLandingFragment = SwanAppAdLandingFragment.this;
            swanAppAdLandingFragment.p3(swanAppAdLandingFragment.z0.canGoBack());
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.g0.a.e0.l.i.F2();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.b.g0.a.b1.g.b {
        public c() {
        }

        @Override // d.b.g0.a.b1.g.b
        public void a(d.b.g0.a.w0.c.j jVar) {
        }

        @Override // d.b.g0.a.b1.g.b
        public boolean b(d.b.g0.a.w0.c.j jVar, int i, int i2) {
            return false;
        }

        @Override // d.b.g0.a.b1.g.b
        public void c(d.b.g0.a.w0.c.j jVar) {
            SwanAppAdLandingFragment.this.N0.c("vcontinueplay");
        }

        @Override // d.b.g0.a.b1.g.b
        public void d(d.b.g0.a.w0.c.j jVar) {
            SwanAppAdLandingFragment.this.X0.bringToFront();
            SwanAppAdLandingFragment.this.X0.setVisibility(0);
            SwanAppAdLandingFragment.this.l1 = 0;
            SwanAppAdLandingFragment.b3(SwanAppAdLandingFragment.this);
            SwanAppAdLandingFragment.this.N0.c("vplayend");
            SwanAppAdLandingFragment.this.N0.c("scard");
        }

        @Override // d.b.g0.a.b1.g.b
        public void e(d.b.g0.a.w0.c.j jVar) {
            SwanAppAdLandingFragment.this.N0.c("vpause");
        }

        @Override // d.b.g0.a.b1.g.b
        public void f(d.b.g0.a.w0.c.j jVar) {
            if (SwanAppAdLandingFragment.this.m1 == 0) {
                SwanAppAdLandingFragment.this.N0.c("vstart");
                return;
            }
            SwanAppAdLandingFragment.this.X0.setVisibility(8);
            SwanAppAdLandingFragment.this.N0.c("vrepeatedplay");
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
    public class e implements d.b.g0.a.q.g.a.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f11909a;

        public e(ViewGroup viewGroup) {
            this.f11909a = viewGroup;
        }

        @Override // d.b.g0.a.q.g.a.a
        public void a(SwanAdDownloadState swanAdDownloadState, int i) {
            SwanAppAdLandingFragment.this.S0.b(i);
        }

        @Override // d.b.g0.a.q.g.a.a
        public void b() {
            SwanAppAdLandingFragment.this.N0.c("appinstallbegin");
        }

        @Override // d.b.g0.a.q.g.a.a
        public void c(SwanAdDownloadState swanAdDownloadState, int i) {
            SwanAppAdLandingFragment.this.S0.e(swanAdDownloadState);
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

        @Override // d.b.g0.a.q.g.a.a
        public void d(String str) {
            SwanAppAdLandingFragment.this.B3(str);
        }

        @Override // d.b.g0.a.q.g.a.a
        public String e() {
            SwanAppAdLandingFragment.this.N0.c("appinstallopen");
            SwanAppAdLandingFragment swanAppAdLandingFragment = SwanAppAdLandingFragment.this;
            return swanAppAdLandingFragment.q3(swanAppAdLandingFragment.U0.f45487a);
        }

        @Override // d.b.g0.a.q.g.a.a
        public void f(boolean z) {
            if (z) {
                this.f11909a.removeView(SwanAppAdLandingFragment.this.S0.getRealView());
                this.f11909a.addView(SwanAppAdLandingFragment.this.S0.getRealView());
                return;
            }
            this.f11909a.removeView(SwanAppAdLandingFragment.this.S0.getRealView());
        }
    }

    /* loaded from: classes2.dex */
    public class f implements d.b.g0.a.e0.n.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CustomerAdScrollView f11911a;

        public f(CustomerAdScrollView customerAdScrollView) {
            this.f11911a = customerAdScrollView;
        }

        @Override // d.b.g0.a.e0.n.c
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            this.f11911a.setIsWebViewOnBottom(((((float) SwanAppAdLandingFragment.this.z0.getContentHeight()) * SwanAppAdLandingFragment.this.z0.getScale()) - ((float) SwanAppAdLandingFragment.this.z0.covertToView().getHeight())) - ((float) SwanAppAdLandingFragment.this.z0.getWebViewScrollY()) < 10.0f);
        }
    }

    /* loaded from: classes2.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f11913e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f11914f;

        public g(ViewGroup viewGroup, ViewGroup viewGroup2) {
            this.f11913e = viewGroup;
            this.f11914f = viewGroup2;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f11913e.setLayoutParams(new LinearLayout.LayoutParams(-1, this.f11914f.getHeight()));
        }
    }

    /* loaded from: classes2.dex */
    public class h extends d.b.g0.a.e0.g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CustomerAdScrollView f11916a;

        public h(CustomerAdScrollView customerAdScrollView) {
            this.f11916a = customerAdScrollView;
        }

        @Override // d.b.g0.a.e0.g
        public void a(String str) {
            super.a(str);
            if (Math.abs((SwanAppAdLandingFragment.this.z0.getContentHeight() * SwanAppAdLandingFragment.this.z0.getScale()) - SwanAppAdLandingFragment.this.z0.covertToView().getHeight()) < 10.0f) {
                this.f11916a.setIsWebViewOnBottom(true);
            } else {
                this.f11916a.setIsWebViewOnBottom(false);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i implements d.b.g0.a.q.f.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CustomerAdScrollView f11918a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinearLayout f11919b;

        public i(CustomerAdScrollView customerAdScrollView, LinearLayout linearLayout) {
            this.f11918a = customerAdScrollView;
            this.f11919b = linearLayout;
        }

        @Override // d.b.g0.a.q.f.a
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            this.f11918a.setIsFooterLayoutShow(SwanAppAdLandingFragment.this.z3(this.f11919b));
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
            if (id == d.b.g0.a.f.ad_tail_head_image) {
                hashMap.put("da_area", "tail_icon");
            } else if (id == d.b.g0.a.f.ad_tail_brand_name) {
                hashMap.put("da_area", "tail_name");
            } else if (id == d.b.g0.a.f.ad_tail_btn) {
                hashMap.put("da_area", SwanAppAdLandingFragment.this.e1 == ActionType.DL.value() ? "tail_downloadbtn" : "tail_detailbtn");
            }
            SwanAppAdLandingFragment.this.N0.d("c", hashMap);
            d.b.g0.a.e0.l.i.K2("adLanding", d.b.g0.a.e1.b.c(SwanAppAdLandingFragment.this.K0, SwanAppAdLandingFragment.this.K0));
        }
    }

    public static /* synthetic */ int b3(SwanAppAdLandingFragment swanAppAdLandingFragment) {
        int i2 = swanAppAdLandingFragment.m1;
        swanAppAdLandingFragment.m1 = i2 + 1;
        return i2;
    }

    public final void A3() {
        String G;
        Bundle j2 = j();
        if (j2 == null) {
            return;
        }
        this.K0 = j2.getString("url", "");
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
                G = G(d.b.g0.a.h.swanapp_ad_download_button);
            } else {
                G = G(d.b.g0.a.h.swanapp_ad_landingpage_button);
            }
            this.f1 = G;
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

    public final void B3(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.b.g0.a.a2.g.h.a().putString(this.U0.f45487a, str);
    }

    @Override // d.b.g0.a.e0.l.i
    public d.b.g0.a.e0.n.d G2() {
        return new a();
    }

    @Override // d.b.g0.a.e0.l.i, d.b.g0.a.e0.l.c
    public void M1(View view) {
        super.M1(view);
        this.i0.setLeftHomeViewSrc(d.b.g0.a.e.aiapps_action_bar_close_black_selector);
        this.i0.setLeftHomeViewClickListener(new b());
    }

    @Override // d.b.g0.a.e0.l.i, d.b.g0.a.e0.l.c
    public boolean T1() {
        return true;
    }

    @Override // d.b.g0.a.e0.l.i
    public d.b.g0.a.p.d.e n() {
        d.b.g0.a.q.e eVar = new d.b.g0.a.q.e(l());
        eVar.getWebView().setDownloadListener(new ISailorDownloadListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.9
            @Override // com.baidu.browser.sailor.ISailorDownloadListener
            public void onDownloadFlash(String str) {
            }

            @Override // com.baidu.browser.sailor.ISailorDownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                if (SwanAppAdLandingFragment.p1) {
                    Log.d("SwanAppAdLandFragment", "onDownloadStart: url=" + str + ", userAgent=" + str2 + ", mimeType=" + str4);
                }
                SwanAppAdLandingFragment.this.S0.d();
                if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.U0.f45488b)) {
                    String q3 = SwanAppAdLandingFragment.this.q3(str);
                    SwanAppAdLandingFragment.this.U0.f45488b = q3;
                    SwanAppAdLandingFragment.this.S0.a(q3);
                }
                if (k0.C(SwanAppAdLandingFragment.this.l(), SwanAppAdLandingFragment.this.U0.f45488b)) {
                    SwanAppAdLandingFragment.this.O0.removeView(SwanAppAdLandingFragment.this.S0.getRealView());
                    SwanAppAdLandingFragment.this.O0.addView(SwanAppAdLandingFragment.this.S0.getRealView());
                    SwanAppAdLandingFragment.this.S0.e(SwanAdDownloadState.INSTALLED);
                    return;
                }
                if (TextUtils.isEmpty(SwanAppAdLandingFragment.this.U0.f45487a)) {
                    SwanAppAdLandingFragment.this.U0.f45487a = str;
                }
                d.b.g0.a.w0.a.d().a(SwanAppAdLandingFragment.this.l(), SwanAppAdLandingFragment.this.U0.a(), SwanAppDownloadAction.SwanAppDownloadType.TYPE_START_DOWNLOAD, SwanAppAdLandingFragment.this.T0);
            }

            @Override // com.baidu.browser.sailor.ISailorDownloadListener
            public void onPlayVideo(String str) {
            }
        });
        return eVar;
    }

    @Override // d.b.g0.a.e0.l.i, com.baidu.swan.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        A3();
        FragmentActivity f2 = f();
        if (f2 != null) {
            boolean z = 1 == f2.getRequestedOrientation();
            this.n1 = z;
            if (!z) {
                s2(1);
            }
        }
        if (p1) {
            Log.d("SwanAppAdLandFragment", "onCreate() : " + this);
        }
    }

    @Override // d.b.g0.a.e0.l.i, com.baidu.swan.support.v4.app.Fragment
    public void onDestroy() {
        if (y3()) {
            this.N0.c("vplayend");
        }
        d.b.g0.a.b1.g.a aVar = this.M0;
        if (aVar != null) {
            aVar.onDestroy();
        }
        if (!this.n1) {
            s2(0);
        }
        super.onDestroy();
    }

    public final void p3(boolean z) {
        this.i0.setLeftHomeViewVisibility(z ? 0 : 8);
    }

    public final String q3(String str) {
        return d.b.g0.a.a2.g.h.a().getString(str, "");
    }

    public final void r3(ViewGroup viewGroup) {
        d.b.g0.a.p.c.g a2 = d.b.g0.a.w0.a.a();
        if (a2 == null) {
            return;
        }
        this.T0 = new e(viewGroup);
        this.U0 = new d.b.g0.a.q.g.b.a(this.Q0, this.R0);
        d.b.g0.a.p.c.g f2 = a2.f(l(), this.U0, this.T0);
        this.S0 = f2;
        f2.c(this.U0);
    }

    public final void s3(ViewGroup viewGroup, ViewGroup viewGroup2) {
        LinearLayout linearLayout = (LinearLayout) ((LinearLayout) LayoutInflater.from(l()).inflate(d.b.g0.a.g.swanapp_ad_footer_view, (ViewGroup) null)).findViewById(d.b.g0.a.f.ad_footer);
        CustomerAdScrollView customerAdScrollView = new CustomerAdScrollView(l());
        LinearLayout linearLayout2 = new LinearLayout(l());
        linearLayout2.setOrientation(1);
        linearLayout2.addView(viewGroup2, new LinearLayout.LayoutParams(-1, -2));
        linearLayout2.addView(linearLayout, new LinearLayout.LayoutParams(-1, l().getResources().getDimensionPixelSize(d.b.g0.a.d.swanapp_ad_dimens_footer_height)));
        customerAdScrollView.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        viewGroup.addView(customerAdScrollView);
        this.y0.F(new f(customerAdScrollView));
        viewGroup2.post(new g(viewGroup2, viewGroup));
        this.y0.e(new h(customerAdScrollView));
        customerAdScrollView.setScrollViewListener(new i(customerAdScrollView, linearLayout));
    }

    public final void t3(ViewGroup viewGroup) {
        this.W0 = (RelativeLayout) LayoutInflater.from(l()).inflate(d.b.g0.a.g.swanapp_ad_video_tail_view, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.height = this.c1;
        this.X0 = (RelativeLayout) this.W0.findViewById(d.b.g0.a.f.ad_tail_root);
        this.Y0 = (SimpleDraweeView) this.W0.findViewById(d.b.g0.a.f.ad_tail_video_img);
        this.Z0 = (SimpleDraweeView) this.W0.findViewById(d.b.g0.a.f.ad_tail_head_image);
        this.a1 = (TextView) this.W0.findViewById(d.b.g0.a.f.ad_tail_brand_name);
        this.b1 = (TextView) this.W0.findViewById(d.b.g0.a.f.ad_tail_btn);
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
        this.Y0.getHierarchy().setPlaceholderImage(u().getDrawable(d.b.g0.a.e.swanapp_ad_tab_video_img_default_icon));
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

    public final void u3() {
        d.b.g0.a.q.d dVar = new d.b.g0.a.q.d(this.i1, this.j1, this.y0.c(), this.d1, this.c1, this.l1);
        d.b.g0.a.b1.g.a aVar = new d.b.g0.a.b1.g.a(l(), dVar.a());
        this.M0 = aVar;
        aVar.w(new c());
        this.M0.q(dVar.a());
        this.M0.x(false);
    }

    @Override // d.b.g0.a.e0.l.i, d.b.g0.a.e0.l.c
    public boolean v() {
        d.b.g0.a.b1.g.a aVar;
        if (x3() && (aVar = this.M0) != null) {
            return aVar.onBackPressed();
        }
        this.N0.c("lpout");
        return super.v();
    }

    @Override // d.b.g0.a.e0.l.i, com.baidu.swan.support.v4.app.Fragment
    public View v0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.b.g0.a.g.aiapps_webview_fragment, viewGroup, false);
        M1(inflate);
        this.O0 = (FrameLayout) inflate.findViewById(d.b.g0.a.f.aiapps_webView_container);
        v3();
        r3(this.O0);
        w3(this.O0);
        if (y3()) {
            u3();
            t3(this.O0);
        }
        D2(this.O0);
        if (L1()) {
            inflate = O1(inflate);
        }
        d.b.g0.a.q.b bVar = new d.b.g0.a.q.b(l(), this.k1, this.M0);
        this.N0 = bVar;
        bVar.c("lpin");
        return v1(inflate, this);
    }

    public final void v3() {
        DisplayMetrics displayMetrics = f().getResources().getDisplayMetrics();
        int i2 = displayMetrics != null ? displayMetrics.widthPixels : 0;
        this.c1 = (i2 * 9) / 16;
        this.d1 = i2;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [d.b.g0.a.p.d.c] */
    public final void w3(ViewGroup viewGroup) {
        d.b.g0.a.p.d.e n = n();
        this.y0 = n;
        n.P(G2());
        this.z0 = this.y0.getWebView();
        this.y0.loadUrl(this.K0);
        FrameLayout frameLayout = new FrameLayout(l());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View covertToView = this.z0.covertToView();
        d.b.g0.a.r1.n.c cVar = new d.b.g0.a.r1.n.c();
        cVar.f45775e = SwanAppConfigData.s("#FFFFFF");
        this.y0.b0(frameLayout, cVar);
        this.y0.E(frameLayout, cVar);
        this.y0.m(frameLayout, covertToView);
        if (y3()) {
            layoutParams.topMargin = this.c1;
        }
        if (TextUtils.equals("swan-custom-ad", this.P0)) {
            s3(viewGroup, frameLayout);
        } else {
            viewGroup.addView(frameLayout);
        }
        covertToView.setLayoutParams(layoutParams);
    }

    public final boolean x3() {
        return f().getResources().getConfiguration().orientation == 2;
    }

    public final boolean y3() {
        return this.L0 == LandingType.VIDEO;
    }

    public final boolean z3(View view) {
        if (view == null || view.getVisibility() != 0) {
            return false;
        }
        return view.getGlobalVisibleRect(new Rect());
    }
}
