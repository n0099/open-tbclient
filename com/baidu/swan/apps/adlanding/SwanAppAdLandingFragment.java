package com.baidu.swan.apps.adlanding;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.browser.sailor.ISailorDownloadListener;
import com.baidu.searchbox.IntentConstants;
import com.baidu.swan.apps.adlanding.customer.CustomerAdScrollView;
import com.baidu.swan.apps.adlanding.customer.WebViewContainer;
import com.baidu.swan.apps.res.widget.toast.ToastLocation;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.swan.game.ad.component.AdImageVIew;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.a72;
import com.baidu.tieba.am1;
import com.baidu.tieba.au3;
import com.baidu.tieba.c72;
import com.baidu.tieba.d42;
import com.baidu.tieba.d52;
import com.baidu.tieba.d72;
import com.baidu.tieba.de3;
import com.baidu.tieba.e63;
import com.baidu.tieba.g63;
import com.baidu.tieba.gj3;
import com.baidu.tieba.h53;
import com.baidu.tieba.hu2;
import com.baidu.tieba.iu2;
import com.baidu.tieba.jj3;
import com.baidu.tieba.ls1;
import com.baidu.tieba.ms1;
import com.baidu.tieba.ni3;
import com.baidu.tieba.ns1;
import com.baidu.tieba.os1;
import com.baidu.tieba.ou3;
import com.baidu.tieba.p53;
import com.baidu.tieba.pu3;
import com.baidu.tieba.pv2;
import com.baidu.tieba.qt3;
import com.baidu.tieba.s43;
import com.baidu.tieba.t43;
import com.baidu.tieba.vp2;
import com.baidu.tieba.vt3;
import com.baidu.tieba.wo2;
import com.baidu.tieba.xk3;
import com.baidu.tieba.xt3;
import com.baidu.tieba.yt3;
import com.baidu.tieba.zr1;
import com.baidu.tieba.zu3;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SwanAppAdLandingFragment extends d52 implements au3 {
    public static final boolean N1 = am1.a;
    public int A1;
    public String B1;
    public os1 C1;
    public String D1;
    public String E1;
    public TextView F1;
    public String G1;
    public View I1;
    public String J1;
    public String K1;
    public String N0;
    public hu2 P0;
    public zu3 Q0;
    public FrameLayout R0;
    public vt3 V0;
    public qt3 W0;
    public DownloadParams X0;
    public RelativeLayout Z0;
    public int a1;
    public int b1;
    public int c1;
    public String d1;
    public String e1;
    public String f1;
    public String g1;
    public String h1;
    public String i1;
    public WebViewContainer n1;
    public LinearLayout o1;
    public ViewGroup p1;
    public int r1;
    public int s1;
    public String t1;
    public String u1;
    public float v1;
    public float w1;
    public FrameLayout x1;
    public int y1;
    public int z1;
    public LandingType O0 = LandingType.NORMAL;
    public String S0 = "";
    public String T0 = "";
    public String U0 = "";
    public DownloadState Y0 = DownloadState.NOT_START;
    public JSONObject j1 = new JSONObject();
    public int k1 = 0;
    public int l1 = 0;
    public boolean m1 = true;
    public Boolean q1 = Boolean.FALSE;
    public t43 H1 = null;
    public yt3 L1 = null;
    public View.OnClickListener M1 = new o();

    /* loaded from: classes4.dex */
    public enum LandingType {
        NORMAL,
        VIDEO
    }

    @Override // com.baidu.tieba.d52, com.baidu.tieba.v42
    public boolean j2() {
        return true;
    }

    /* loaded from: classes4.dex */
    public class a extends a72 {

        /* renamed from: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0197a implements Runnable {
            public final /* synthetic */ String a;

            public RunnableC0197a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str;
                SwanAppActionBar swanAppActionBar = SwanAppAdLandingFragment.this.f0;
                if (TextUtils.isEmpty(this.a)) {
                    str = "";
                } else {
                    str = this.a;
                }
                swanAppActionBar.setTitle(str);
            }
        }

        public a() {
        }

        @Override // com.baidu.tieba.a72, com.baidu.tieba.d72
        public void d(String str) {
            SwanAppAdLandingFragment swanAppAdLandingFragment = SwanAppAdLandingFragment.this;
            swanAppAdLandingFragment.g4(swanAppAdLandingFragment.H0.canGoBack());
            SwanAppAdLandingFragment.this.f0.post(new RunnableC0197a(str));
        }

        @Override // com.baidu.tieba.a72, com.baidu.tieba.d72
        public void e(String str) {
            super.e(str);
            if (!TextUtils.isEmpty(SwanAppAdLandingFragment.this.g1) && SwanAppAdLandingFragment.this.Q0 != null) {
                SwanAppAdLandingFragment.this.Q0.e(SwanAppAdLandingFragment.this.g1);
            }
        }

        @Override // com.baidu.tieba.a72, com.baidu.tieba.d72
        public boolean a(String str) {
            if (g63.e(str) || g63.f(str)) {
                try {
                    Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(str));
                    p53 c0 = p53.c0();
                    if (c0 != null) {
                        c0.w().startActivity(intent);
                        return true;
                    }
                } catch (Exception e) {
                    if (SwanAppAdLandingFragment.N1) {
                        e.printStackTrace();
                    }
                }
            }
            return super.a(str);
        }

        @Override // com.baidu.tieba.a72, com.baidu.tieba.d72
        public void goBack() {
            SwanAppAdLandingFragment swanAppAdLandingFragment = SwanAppAdLandingFragment.this;
            swanAppAdLandingFragment.g4(swanAppAdLandingFragment.H0.canGoBack());
        }
    }

    /* loaded from: classes4.dex */
    public enum ActionType {
        LP(1),
        DL(2);
        
        public int type;

        public int value() {
            return this.type;
        }

        ActionType(int i) {
            this.type = i;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            d52.f3();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h53 g = h53.g(SwanAppAdLandingFragment.this.s(), "第三方页面应用未经百度审核");
            g.p(ToastLocation.BOTTOM);
            g.G();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            d52.k3("adLanding", pv2.d(SwanAppAdLandingFragment.this.K1, SwanAppAdLandingFragment.this.K1));
            SwanAppAdLandingFragment.this.H1.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            d52.k3("adLanding", pv2.d(SwanAppAdLandingFragment.this.J1, SwanAppAdLandingFragment.this.J1));
            SwanAppAdLandingFragment.this.H1.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SwanAppAdLandingFragment.this.H1.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements DialogInterface.OnCancelListener {
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
        }

        public g() {
        }
    }

    /* loaded from: classes4.dex */
    public class h implements iu2 {
        @Override // com.baidu.tieba.iu2
        public void e(vp2 vp2Var) {
        }

        @Override // com.baidu.tieba.iu2
        public boolean f(vp2 vp2Var, int i, int i2) {
            return false;
        }

        public h() {
        }

        @Override // com.baidu.tieba.iu2
        public void a(vp2 vp2Var) {
            SwanAppAdLandingFragment.this.E4("vcontinueplay");
        }

        @Override // com.baidu.tieba.iu2
        public void b(vp2 vp2Var) {
            SwanAppAdLandingFragment.this.Z0.bringToFront();
            SwanAppAdLandingFragment.this.Z0.setVisibility(0);
            SwanAppAdLandingFragment.this.k1 = 0;
            SwanAppAdLandingFragment.B3(SwanAppAdLandingFragment.this);
            SwanAppAdLandingFragment.this.E4("vplayend");
            SwanAppAdLandingFragment.this.E4("scard");
        }

        @Override // com.baidu.tieba.iu2
        public void c(vp2 vp2Var) {
            SwanAppAdLandingFragment.this.E4("vpause");
        }

        @Override // com.baidu.tieba.iu2
        public void d(vp2 vp2Var) {
            if (SwanAppAdLandingFragment.this.l1 != 0) {
                SwanAppAdLandingFragment.this.Z0.setVisibility(8);
                SwanAppAdLandingFragment.this.E4(com.baidu.mobads.sdk.internal.o.b);
                return;
            }
            SwanAppAdLandingFragment.this.E4(com.baidu.mobads.sdk.internal.o.a);
        }
    }

    /* loaded from: classes4.dex */
    public class i implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
        }

        public i() {
        }
    }

    /* loaded from: classes4.dex */
    public class j implements qt3 {
        public j() {
        }

        @Override // com.baidu.tieba.qt3
        public void a(int i) {
            SwanAppAdLandingFragment.this.V0.d(i);
        }

        @Override // com.baidu.tieba.qt3
        public void d(String str) {
            SwanAppAdLandingFragment.this.B4(str);
        }

        @Override // com.baidu.tieba.qt3
        public void f(boolean z) {
            if (!SwanAppAdLandingFragment.this.G1.equals("1")) {
                return;
            }
            if (z) {
                SwanAppAdLandingFragment.this.F4();
            } else {
                SwanAppAdLandingFragment.this.C4();
            }
        }

        @Override // com.baidu.tieba.qt3
        public void b() {
            SwanAppAdLandingFragment.this.E4("appinstallbegin");
        }

        @Override // com.baidu.tieba.qt3
        public String e() {
            SwanAppAdLandingFragment.this.E4("appinstallopen");
            SwanAppAdLandingFragment swanAppAdLandingFragment = SwanAppAdLandingFragment.this;
            return swanAppAdLandingFragment.h4(swanAppAdLandingFragment.X0.a);
        }

        @Override // com.baidu.tieba.qt3
        public void c(DownloadState downloadState, int i) {
            SwanAppAdLandingFragment.this.V0.b(downloadState);
            if (SwanAppAdLandingFragment.this.Y0 == downloadState) {
                return;
            }
            if (SwanAppAdLandingFragment.this.Y0 != DownloadState.NOT_START || downloadState != DownloadState.DOWNLOADING) {
                if (downloadState != DownloadState.DOWNLOAD_PAUSED) {
                    if (SwanAppAdLandingFragment.this.Y0 != DownloadState.DOWNLOAD_PAUSED || downloadState != DownloadState.DOWNLOADING) {
                        if (downloadState != DownloadState.DOWNLOADED) {
                            if (downloadState == DownloadState.INSTALLED) {
                                SwanAppAdLandingFragment.this.E4("appinstallfinish");
                            }
                        } else {
                            SwanAppAdLandingFragment.this.E4("appdownloadfinish");
                            SwanAppAdLandingFragment.this.E4("appinstallbegin");
                        }
                    } else {
                        SwanAppAdLandingFragment.this.E4("appdownloadcontinue");
                    }
                } else {
                    SwanAppAdLandingFragment.this.E4("appdownloadpause");
                }
            } else {
                SwanAppAdLandingFragment.this.E4("appdownloadbegin");
            }
            SwanAppAdLandingFragment.this.Y0 = downloadState;
        }
    }

    /* loaded from: classes4.dex */
    public class k implements Runnable {
        public final /* synthetic */ View a;

        public k(View view2) {
            this.a = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int height = SwanAppAdLandingFragment.this.R0.getHeight();
            if (SwanAppAdLandingFragment.this.x4() || SwanAppAdLandingFragment.this.v4()) {
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.height = height;
                this.a.setLayoutParams(layoutParams);
            }
            if (SwanAppAdLandingFragment.this.x4()) {
                ViewGroup.LayoutParams layoutParams2 = SwanAppAdLandingFragment.this.n1.getLayoutParams();
                layoutParams2.height = height + (SwanAppAdLandingFragment.this.q1.booleanValue() ? SwanAppAdLandingFragment.this.z1 : SwanAppAdLandingFragment.this.a1);
                SwanAppAdLandingFragment.this.n1.setLayoutParams(layoutParams2);
            }
            SwanAppAdLandingFragment.this.p1.removeView(SwanAppAdLandingFragment.this.R0);
            if (SwanAppAdLandingFragment.this.o1 != null) {
                SwanAppAdLandingFragment.this.o1.setVisibility(0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements c72 {
        public final /* synthetic */ CustomerAdScrollView a;

        public l(CustomerAdScrollView customerAdScrollView) {
            this.a = customerAdScrollView;
        }

        @Override // com.baidu.tieba.c72
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            boolean z;
            float contentHeight = ((SwanAppAdLandingFragment.this.H0.getContentHeight() * SwanAppAdLandingFragment.this.H0.getScale()) - SwanAppAdLandingFragment.this.H0.covertToView().getHeight()) - SwanAppAdLandingFragment.this.H0.getWebViewScrollY();
            CustomerAdScrollView customerAdScrollView = this.a;
            if (contentHeight < 10.0f) {
                z = true;
            } else {
                z = false;
            }
            customerAdScrollView.setIsWebViewOnBottom(z);
        }
    }

    /* loaded from: classes4.dex */
    public class m extends d42 {
        public final /* synthetic */ CustomerAdScrollView a;

        public m(CustomerAdScrollView customerAdScrollView) {
            this.a = customerAdScrollView;
        }

        @Override // com.baidu.tieba.d42
        public void a(String str) {
            super.a(str);
            if (Math.abs((SwanAppAdLandingFragment.this.H0.getContentHeight() * SwanAppAdLandingFragment.this.H0.getScale()) - SwanAppAdLandingFragment.this.H0.covertToView().getHeight()) < 10.0f) {
                this.a.setIsWebViewOnBottom(true);
            } else {
                this.a.setIsWebViewOnBottom(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements ns1 {
        public final /* synthetic */ CustomerAdScrollView a;

        public n(CustomerAdScrollView customerAdScrollView) {
            this.a = customerAdScrollView;
        }

        @Override // com.baidu.tieba.ns1
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            CustomerAdScrollView customerAdScrollView = this.a;
            SwanAppAdLandingFragment swanAppAdLandingFragment = SwanAppAdLandingFragment.this;
            customerAdScrollView.setIsFooterLayoutShow(swanAppAdLandingFragment.y4(swanAppAdLandingFragment.o1));
        }
    }

    /* loaded from: classes4.dex */
    public class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            int id = view2.getId();
            HashMap<String, String> hashMap = new HashMap<>();
            if (id == R.id.obfuscated_res_0x7f090110) {
                hashMap.put("da_area", "tail_icon");
            } else if (id == R.id.obfuscated_res_0x7f09010d) {
                hashMap.put("da_area", "tail_name");
            } else if (id == R.id.obfuscated_res_0x7f09010e) {
                if (SwanAppAdLandingFragment.this.c1 == ActionType.DL.value()) {
                    str = "tail_downloadbtn";
                } else {
                    str = "tail_detailbtn";
                }
                hashMap.put("da_area", str);
            }
            if (SwanAppAdLandingFragment.this.Q0 != null) {
                SwanAppAdLandingFragment.this.Q0.d("c", hashMap);
            }
            d52.k3("adLanding", pv2.d(SwanAppAdLandingFragment.this.N0, SwanAppAdLandingFragment.this.N0));
        }
    }

    public final void A4() {
        hu2 hu2Var = this.P0;
        if (hu2Var != null && hu2Var.n()) {
            this.P0.p();
        }
    }

    @Override // com.baidu.tieba.d52, com.baidu.swan.support.v4.app.Fragment
    public void C0() {
        if (x4()) {
            E4("vplayend");
        }
        hu2 hu2Var = this.P0;
        if (hu2Var != null) {
            hu2Var.onDestroy();
        }
        if (!this.m1) {
            O2(0);
        }
        super.C0();
    }

    public final void C4() {
        this.n1.removeView(this.V0.getRealView());
        this.n1.removeView(this.F1);
    }

    public final void D4() {
        hu2 hu2Var = this.P0;
        if (hu2Var != null && !hu2Var.n() && !this.P0.m()) {
            this.P0.s();
        }
    }

    public final void F4() {
        C4();
        this.n1.addView(this.F1);
        this.n1.addView(this.V0.getRealView());
    }

    @Override // com.baidu.tieba.d52, com.baidu.tieba.v42
    public boolean G() {
        hu2 hu2Var;
        if (w4() && (hu2Var = this.P0) != null) {
            return hu2Var.onBackPressed();
        }
        E4("lpout");
        return super.G();
    }

    @Override // com.baidu.tieba.d52
    public d72 g3() {
        return new a();
    }

    @Override // com.baidu.tieba.d52
    public zr1 j() {
        ms1 ms1Var = new ms1(s());
        ms1Var.getWebView().setDownloadListener(new ISailorDownloadListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.9
            @Override // com.baidu.browser.sailor.ISailorDownloadListener
            public void onDownloadFlash(String str) {
            }

            @Override // com.baidu.browser.sailor.ISailorDownloadListener
            public void onPlayVideo(String str) {
            }

            @Override // com.baidu.browser.sailor.ISailorDownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                if (SwanAppAdLandingFragment.N1) {
                    Log.d("SwanAppAdLandFragment", "onDownloadStart: url=" + str + ", userAgent=" + str2 + ", mimeType=" + str4);
                }
                SwanAppAdLandingFragment.this.D1 = str;
                SwanAppAdLandingFragment.this.i4();
            }
        });
        return ms1Var;
    }

    public final void k4() {
        jj3.e0(new c());
    }

    @Override // com.baidu.tieba.v42, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        A4();
    }

    @Override // com.baidu.tieba.v42, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        os1 os1Var = this.C1;
        if (os1Var != null && os1Var.l() && !p0()) {
            D4();
        }
    }

    public final void u4() {
        int i2;
        os1 os1Var = new os1(s());
        this.C1 = os1Var;
        if (x4()) {
            i2 = this.a1;
        } else {
            i2 = 0;
        }
        os1Var.o(i2);
        WebViewContainer k2 = this.C1.k();
        this.n1 = k2;
        this.p1.addView(k2);
    }

    public final boolean v4() {
        return TextUtils.equals("swan-custom-ad", this.S0);
    }

    public final boolean w4() {
        if (m().getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }

    public final boolean x4() {
        if (this.O0 == LandingType.VIDEO) {
            return true;
        }
        return false;
    }

    public final void i4() {
        yt3 yt3Var = this.L1;
        if (yt3Var != null) {
            h(yt3Var);
            return;
        }
        ou3 ou3Var = new ou3(s());
        ou3Var.d(this);
        pu3 pu3Var = new pu3(s());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("charge_url", this.E1);
            jSONObject.put("apk_url", this.D1);
            jSONObject.put("ssl", 1);
        } catch (JSONException e2) {
            if (N1) {
                e2.printStackTrace();
            }
        }
        ou3Var.c(pu3Var, jSONObject);
    }

    public final void s4() {
        int i2;
        DisplayMetrics displayMetrics = m().getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            i2 = displayMetrics.widthPixels;
        } else {
            i2 = 0;
        }
        if (this.q1.booleanValue()) {
            float f2 = this.s1 / this.r1;
            this.y1 = i2;
            int i3 = (int) (i2 * f2);
            this.z1 = i3;
            this.b1 = (int) (i2 * this.v1);
            this.a1 = i3;
            this.A1 = (int) (i2 * this.w1);
            return;
        }
        this.a1 = (i2 * 9) / 16;
        this.b1 = i2;
    }

    public static /* synthetic */ int B3(SwanAppAdLandingFragment swanAppAdLandingFragment) {
        int i2 = swanAppAdLandingFragment.l1;
        swanAppAdLandingFragment.l1 = i2 + 1;
        return i2;
    }

    public final void B4(String str) {
        if (!TextUtils.isEmpty(str)) {
            de3.a().putString(this.X0.a, str);
        }
    }

    public final void E4(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hu2 hu2Var = this.P0;
        if (hu2Var != null) {
            hashMap.put("cur_time", String.valueOf(hu2Var.e() / 1000));
        }
        zu3 zu3Var = this.Q0;
        if (zu3Var != null) {
            zu3Var.d(str, hashMap);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void G0(boolean z) {
        super.G0(z);
        if (z) {
            A4();
        } else {
            D4();
        }
    }

    @Override // com.baidu.tieba.d52, com.baidu.tieba.v42
    public void b2(View view2) {
        super.b2(view2);
        this.f0.setLeftHomeViewSrc(R.drawable.obfuscated_res_0x7f080124);
        this.f0.setLeftHomeViewClickListener(new b());
    }

    public final void g4(boolean z) {
        int i2;
        SwanAppActionBar swanAppActionBar = this.f0;
        if (z) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        swanAppActionBar.setLeftHomeViewVisibility(i2);
    }

    public final String h4(String str) {
        return de3.a().getString(str, "");
    }

    public final void m4(ViewGroup viewGroup) {
        this.W0 = new j();
        this.X0 = new DownloadParams(this.T0, this.U0);
        xt3 xt3Var = new xt3();
        xt3Var.l(s(), this.X0, this.W0);
        this.V0 = xt3Var;
        xt3Var.e(this.X0);
        n4();
    }

    public final boolean y4(View view2) {
        if (view2 != null && view2.getVisibility() == 0) {
            return view2.getGlobalVisibleRect(new Rect());
        }
        return false;
    }

    @Override // com.baidu.tieba.d52, com.baidu.swan.support.v4.app.Fragment
    public View B0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00e4, viewGroup, false);
        b2(inflate);
        this.p1 = (ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f092344);
        this.R0 = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0901bc);
        s4();
        u4();
        m4(this.n1);
        t4();
        if (x4()) {
            r4();
            q4();
        }
        if (a2()) {
            inflate = d2(inflate);
        }
        E4("lpin");
        return J1(inflate, this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.au3
    public void h(yt3 yt3Var) {
        char c2;
        this.L1 = yt3Var;
        String f2 = yt3Var.f();
        this.G1 = f2;
        switch (f2.hashCode()) {
            case 49:
                if (f2.equals("1")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 50:
                if (f2.equals("2")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 51:
                if (f2.equals("3")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 52:
                if (f2.equals("4")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                if (c2 != 2) {
                    if (c2 == 3) {
                        k4();
                        return;
                    }
                    return;
                }
                l4(yt3Var, false);
                return;
            }
            l4(yt3Var, true);
            return;
        }
        j4();
    }

    public final void j4() {
        this.V0.f();
        if (TextUtils.isEmpty(this.X0.b)) {
            String h4 = h4(this.D1);
            this.X0.b = h4;
            this.V0.a(h4);
        }
        if (jj3.F(s(), this.X0.b)) {
            F4();
            this.V0.b(DownloadState.INSTALLED);
            return;
        }
        if (TextUtils.isEmpty(this.X0.a)) {
            this.X0.a = this.D1;
        }
        wo2.d().d(s(), this.X0.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.W0);
    }

    public final void l4(yt3 yt3Var, boolean z) {
        float f2;
        t43 t43Var = this.H1;
        if (t43Var != null) {
            t43Var.show();
            return;
        }
        ((ViewGroup) this.I1.findViewById(R.id.obfuscated_res_0x7f0900df)).addView(this.V0.getRealView());
        ((AdImageVIew) this.I1.findViewById(R.id.obfuscated_res_0x7f0900e1)).setImageUrl(yt3Var.g());
        ((TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0900de)).setText(yt3Var.c());
        ((TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0900e6)).setText(yt3Var.d());
        ((TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0900dd)).setText(yt3Var.a());
        ((TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0900e8)).setText(yt3Var.j());
        TextView textView = (TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0900e0);
        if (!z) {
            textView.setText(yt3Var.e());
            textView.setVisibility(0);
        }
        this.J1 = yt3Var.h();
        this.K1 = yt3Var.i();
        ViewGroup.LayoutParams layoutParams = this.V0.getRealView().getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
            this.V0.getRealView().setLayoutParams(layoutParams);
        }
        int o2 = gj3.o(s());
        float l2 = gj3.l(s());
        layoutParams.width = o2 - (((int) ((10.0f * l2) + 0.5f)) * 2);
        if (TextUtils.isEmpty(this.X0.b)) {
            String h4 = h4(yt3Var.b());
            this.X0.b = h4;
            this.V0.a(h4);
        }
        if (jj3.F(s(), this.X0.b)) {
            this.V0.b(DownloadState.INSTALLED);
        }
        if (TextUtils.isEmpty(this.X0.a)) {
            this.X0.a = yt3Var.b();
        }
        this.V0.e(this.X0);
        s43 s43Var = new s43(s());
        s43Var.i(true);
        s43Var.k(false);
        s43Var.T(false);
        s43Var.m(false);
        s43Var.t(false);
        s43Var.n(new xk3());
        s43Var.p(R.drawable.obfuscated_res_0x7f080140);
        s43Var.F(R.color.obfuscated_res_0x7f060ab7);
        s43Var.K(new g());
        s43Var.W(this.I1);
        s43Var.j();
        if (z) {
            f2 = 225.0f;
        } else {
            f2 = 250.0f;
        }
        s43Var.q((int) (l2 * f2));
        t43 c2 = s43Var.c();
        this.H1 = c2;
        Window window = c2.getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setDimAmount(0.65f);
            window.setLayout(gj3.s(s()), -2);
            window.setWindowAnimations(R.style.obfuscated_res_0x7f1003b3);
        }
        this.H1.a(false);
        this.H1.setCanceledOnTouchOutside(true);
        this.H1.show();
    }

    public final void n4() {
        View inflate = View.inflate(s(), R.layout.obfuscated_res_0x7f0d009a, null);
        this.I1 = inflate;
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0900e5)).setOnClickListener(new d());
        ((TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0900e4)).setOnClickListener(new e());
        ((ImageView) this.I1.findViewById(R.id.obfuscated_res_0x7f09073f)).setOnClickListener(new f());
        TextView textView = new TextView(s());
        this.F1 = textView;
        textView.setText("温馨提示：您已访问至第三方页面");
        this.F1.setTextColor(-16777216);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, -1});
        gradientDrawable.setShape(0);
        this.F1.setBackground(gradientDrawable);
        this.F1.getBackground().setAlpha(180);
        this.F1.setPadding(0, 0, 0, 10);
        this.F1.setGravity(80);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 260);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = ((int) (s().getResources().getDisplayMetrics().heightPixels * 0.14d)) - 80;
        this.F1.setLayoutParams(layoutParams);
        this.F1.setGravity(81);
    }

    public final void o4(ViewGroup viewGroup, ViewGroup viewGroup2) {
        this.o1 = (LinearLayout) ((LinearLayout) LayoutInflater.from(s()).inflate(R.layout.obfuscated_res_0x7f0d0928, (ViewGroup) null)).findViewById(R.id.obfuscated_res_0x7f0900b3);
        CustomerAdScrollView customerAdScrollView = new CustomerAdScrollView(s());
        LinearLayout linearLayout = new LinearLayout(s());
        linearLayout.setOrientation(1);
        linearLayout.addView(viewGroup2, new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(this.o1, new LinearLayout.LayoutParams(-1, s().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070825)));
        customerAdScrollView.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        viewGroup.addView(customerAdScrollView);
        this.G0.r(new l(customerAdScrollView));
        this.G0.b(new m(customerAdScrollView));
        customerAdScrollView.setScrollViewListener(new n(customerAdScrollView));
    }

    public final void p4() {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(s()).inflate(R.layout.obfuscated_res_0x7f0d0929, (ViewGroup) null);
        this.n1.addView(relativeLayout, new FrameLayout.LayoutParams(-1, this.z1));
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0900dc);
        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0900e9);
        this.x1 = (FrameLayout) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0900ea);
        if (!TextUtils.isEmpty(this.t1)) {
            simpleDraweeView.setImageURI(Uri.parse(this.t1));
            simpleDraweeView.setOnClickListener(this.M1);
        } else {
            simpleDraweeView.setVisibility(4);
        }
        if (!TextUtils.isEmpty(this.u1)) {
            simpleDraweeView2.setImageURI(Uri.parse(this.u1));
        } else {
            simpleDraweeView2.setVisibility(4);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.x1.getLayoutParams();
        layoutParams.width = this.b1;
        layoutParams.height = this.a1;
        layoutParams.rightMargin = this.A1;
        this.x1.setLayoutParams(layoutParams);
    }

    public final void r4() {
        int i2;
        int i3;
        if (this.q1.booleanValue()) {
            p4();
        }
        if (this.q1.booleanValue()) {
            i2 = 0;
        } else {
            i2 = this.b1;
        }
        if (this.q1.booleanValue()) {
            i3 = 0;
        } else {
            i3 = this.a1;
        }
        ls1 ls1Var = new ls1(this.h1, this.i1, this.G0.a(), i2, i3, this.k1, this.q1.booleanValue());
        hu2 hu2Var = new hu2(s(), ls1Var.a());
        this.P0 = hu2Var;
        this.C1.p(hu2Var);
        this.P0.v(new h());
        if (this.q1.booleanValue()) {
            this.P0.x(this.x1);
        }
        this.P0.o(ls1Var.a());
        this.P0.w(false);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.tieba.xr1] */
    public final void t4() {
        int i2;
        zr1 j2 = j();
        this.G0 = j2;
        j2.V(g3());
        this.H0 = this.G0.getWebView();
        this.G0.loadUrl(this.N0);
        FrameLayout frameLayout = new FrameLayout(s());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View covertToView = this.H0.covertToView();
        e63 e63Var = new e63();
        e63Var.e = SwanAppConfigData.t("#FFFFFF");
        this.G0.x(frameLayout, e63Var);
        this.G0.M(frameLayout, e63Var);
        this.G0.i(frameLayout, covertToView);
        if (v4()) {
            o4(this.n1, frameLayout);
        } else {
            this.n1.addView(frameLayout);
        }
        WebViewContainer webViewContainer = this.n1;
        if (webViewContainer != null) {
            webViewContainer.setInternalWebView(this.H0);
        }
        if (x4()) {
            if (this.q1.booleanValue()) {
                i2 = this.z1;
            } else {
                i2 = this.a1;
            }
            layoutParams.topMargin = i2;
        }
        covertToView.setLayoutParams(layoutParams);
        this.R0.post(new k(covertToView));
    }

    public final void q4() {
        int i2;
        String str;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(s()).inflate(R.layout.obfuscated_res_0x7f0d092a, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        if (this.q1.booleanValue()) {
            i2 = this.z1;
        } else {
            i2 = this.a1;
        }
        layoutParams.height = i2;
        this.Z0 = (RelativeLayout) relativeLayout.findViewById(R.id.obfuscated_res_0x7f090111);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f090112);
        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f090110);
        TextView textView = (TextView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f09010d);
        TextView textView2 = (TextView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f09010e);
        if (!TextUtils.isEmpty(this.d1)) {
            textView2.setText(this.d1);
            textView2.setVisibility(0);
        } else {
            textView2.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.e1)) {
            textView.setText(this.e1);
            textView.setVisibility(0);
        } else {
            textView.setVisibility(4);
        }
        if (!TextUtils.isEmpty(this.f1)) {
            simpleDraweeView2.setImageURI(Uri.parse(this.f1));
            simpleDraweeView2.setVisibility(0);
        } else {
            simpleDraweeView2.setVisibility(8);
        }
        simpleDraweeView.getHierarchy().setPlaceholderImage(J().getDrawable(R.drawable.obfuscated_res_0x7f08145c));
        if (this.q1.booleanValue()) {
            str = this.B1;
        } else {
            str = this.h1;
        }
        if (!TextUtils.isEmpty(str)) {
            simpleDraweeView.setImageURI(ni3.m(str));
        }
        simpleDraweeView.setVisibility(0);
        simpleDraweeView.setOnClickListener(new i());
        simpleDraweeView2.setOnClickListener(this.M1);
        textView.setOnClickListener(this.M1);
        textView2.setOnClickListener(this.M1);
        this.n1.addView(this.Z0, layoutParams);
        this.Z0.setVisibility(4);
    }

    public final void z4() {
        String S;
        Bundle p = p();
        if (p == null) {
            return;
        }
        this.N0 = p.getString("url", "");
        if (TextUtils.isEmpty(this.J0)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.J0);
            this.i1 = jSONObject.optString("vurl", "");
            this.h1 = jSONObject.optString("w_picurl", "");
            this.f1 = jSONObject.optString("icon", "");
            int optInt = jSONObject.optInt("act", ActionType.LP.value());
            this.c1 = optInt;
            if (optInt == ActionType.DL.value()) {
                S = S(R.string.obfuscated_res_0x7f0f1519);
            } else {
                S = S(R.string.obfuscated_res_0x7f0f1522);
            }
            this.d1 = S;
            this.e1 = jSONObject.optString("appname", "");
            this.k1 = jSONObject.optInt("currentTime", 0);
            this.j1 = jSONObject.optJSONObject("monitors");
            this.T0 = jSONObject.optString("url", "");
            this.U0 = jSONObject.optString("name", "");
            this.S0 = jSONObject.optString("from", "");
            this.g1 = jSONObject.optString("monitorUrl", "");
            this.r1 = jSONObject.optInt("w", 16);
            this.s1 = jSONObject.optInt("h", 9);
            this.t1 = jSONObject.optString("playingbg", "");
            this.u1 = jSONObject.optString("maskUrl", "");
            this.v1 = (float) jSONObject.optDouble("playerWidthRatio", 0.5d);
            this.w1 = (float) jSONObject.optDouble("rightMarginRatio", 0.0d);
            this.B1 = jSONObject.optString("horizontalCover", "");
            this.E1 = jSONObject.optString("costUrl", "");
        } catch (JSONException e2) {
            if (N1) {
                e2.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(this.i1)) {
            this.O0 = LandingType.VIDEO;
        }
        this.q1 = Boolean.valueOf(TextUtils.equals("ad-video-portrait", this.S0));
    }

    @Override // com.baidu.tieba.d52, com.baidu.swan.support.v4.app.Fragment
    public void y0(Bundle bundle) {
        boolean z;
        super.y0(bundle);
        z4();
        this.Q0 = new zu3(s(), this.j1);
        FragmentActivity m2 = m();
        if (m2 != null) {
            if (1 == m2.getRequestedOrientation()) {
                z = true;
            } else {
                z = false;
            }
            this.m1 = z;
            if (!z) {
                O2(1);
            }
        }
        if (N1) {
            Log.d("SwanAppAdLandFragment", "onCreate() : " + this);
        }
    }
}
