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
import com.baidu.tieba.a04;
import com.baidu.tieba.cb3;
import com.baidu.tieba.db3;
import com.baidu.tieba.f04;
import com.baidu.tieba.fw2;
import com.baidu.tieba.gv2;
import com.baidu.tieba.h04;
import com.baidu.tieba.hr3;
import com.baidu.tieba.i04;
import com.baidu.tieba.iy1;
import com.baidu.tieba.j14;
import com.baidu.tieba.js1;
import com.baidu.tieba.k04;
import com.baidu.tieba.kd2;
import com.baidu.tieba.md2;
import com.baidu.tieba.na2;
import com.baidu.tieba.nb2;
import com.baidu.tieba.nd2;
import com.baidu.tieba.nk3;
import com.baidu.tieba.oc3;
import com.baidu.tieba.qc3;
import com.baidu.tieba.qp3;
import com.baidu.tieba.r03;
import com.baidu.tieba.rb3;
import com.baidu.tieba.s03;
import com.baidu.tieba.tp3;
import com.baidu.tieba.uy1;
import com.baidu.tieba.vy1;
import com.baidu.tieba.wy1;
import com.baidu.tieba.xo3;
import com.baidu.tieba.xy1;
import com.baidu.tieba.y04;
import com.baidu.tieba.z04;
import com.baidu.tieba.z13;
import com.baidu.tieba.zb3;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SwanAppAdLandingFragment extends nb2 implements k04 {
    public static final boolean N1 = js1.a;
    public int A1;
    public String B1;
    public xy1 C1;
    public String D1;
    public String E1;
    public TextView F1;
    public String G1;
    public View I1;
    public String J1;
    public String K1;
    public String N0;
    public r03 P0;
    public j14 Q0;
    public FrameLayout R0;
    public f04 V0;
    public a04 W0;
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
    public db3 H1 = null;
    public i04 L1 = null;
    public View.OnClickListener M1 = new o();

    /* loaded from: classes4.dex */
    public enum LandingType {
        NORMAL,
        VIDEO
    }

    @Override // com.baidu.tieba.nb2, com.baidu.tieba.fb2
    public boolean e2() {
        return true;
    }

    /* loaded from: classes4.dex */
    public class a extends kd2 {

        /* renamed from: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0206a implements Runnable {
            public final /* synthetic */ String a;

            public RunnableC0206a(String str) {
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

        @Override // com.baidu.tieba.kd2, com.baidu.tieba.nd2
        public void d(String str) {
            SwanAppAdLandingFragment swanAppAdLandingFragment = SwanAppAdLandingFragment.this;
            swanAppAdLandingFragment.b4(swanAppAdLandingFragment.H0.canGoBack());
            SwanAppAdLandingFragment.this.f0.post(new RunnableC0206a(str));
        }

        @Override // com.baidu.tieba.kd2, com.baidu.tieba.nd2
        public void e(String str) {
            super.e(str);
            if (!TextUtils.isEmpty(SwanAppAdLandingFragment.this.g1) && SwanAppAdLandingFragment.this.Q0 != null) {
                SwanAppAdLandingFragment.this.Q0.e(SwanAppAdLandingFragment.this.g1);
            }
        }

        @Override // com.baidu.tieba.kd2, com.baidu.tieba.nd2
        public boolean a(String str) {
            if (qc3.e(str) || qc3.f(str)) {
                try {
                    Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(str));
                    zb3 b0 = zb3.b0();
                    if (b0 != null) {
                        b0.w().startActivity(intent);
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

        @Override // com.baidu.tieba.kd2, com.baidu.tieba.nd2
        public void goBack() {
            SwanAppAdLandingFragment swanAppAdLandingFragment = SwanAppAdLandingFragment.this;
            swanAppAdLandingFragment.b4(swanAppAdLandingFragment.H0.canGoBack());
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
            nb2.a3();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            rb3 g = rb3.g(SwanAppAdLandingFragment.this.getContext(), "第三方页面应用未经百度审核");
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
            nb2.f3("adLanding", z13.d(SwanAppAdLandingFragment.this.K1, SwanAppAdLandingFragment.this.K1));
            SwanAppAdLandingFragment.this.H1.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            nb2.f3("adLanding", z13.d(SwanAppAdLandingFragment.this.J1, SwanAppAdLandingFragment.this.J1));
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
    public class h implements s03 {
        @Override // com.baidu.tieba.s03
        public void e(fw2 fw2Var) {
        }

        @Override // com.baidu.tieba.s03
        public boolean f(fw2 fw2Var, int i, int i2) {
            return false;
        }

        public h() {
        }

        @Override // com.baidu.tieba.s03
        public void a(fw2 fw2Var) {
            SwanAppAdLandingFragment.this.z4("vcontinueplay");
        }

        @Override // com.baidu.tieba.s03
        public void b(fw2 fw2Var) {
            SwanAppAdLandingFragment.this.Z0.bringToFront();
            SwanAppAdLandingFragment.this.Z0.setVisibility(0);
            SwanAppAdLandingFragment.this.k1 = 0;
            SwanAppAdLandingFragment.w3(SwanAppAdLandingFragment.this);
            SwanAppAdLandingFragment.this.z4("vplayend");
            SwanAppAdLandingFragment.this.z4("scard");
        }

        @Override // com.baidu.tieba.s03
        public void c(fw2 fw2Var) {
            SwanAppAdLandingFragment.this.z4("vpause");
        }

        @Override // com.baidu.tieba.s03
        public void d(fw2 fw2Var) {
            if (SwanAppAdLandingFragment.this.l1 != 0) {
                SwanAppAdLandingFragment.this.Z0.setVisibility(8);
                SwanAppAdLandingFragment.this.z4("vrepeatedplay");
                return;
            }
            SwanAppAdLandingFragment.this.z4("vstart");
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
    public class j implements a04 {
        public j() {
        }

        @Override // com.baidu.tieba.a04
        public void a(int i) {
            SwanAppAdLandingFragment.this.V0.d(i);
        }

        @Override // com.baidu.tieba.a04
        public void d(String str) {
            SwanAppAdLandingFragment.this.w4(str);
        }

        @Override // com.baidu.tieba.a04
        public void f(boolean z) {
            if (!SwanAppAdLandingFragment.this.G1.equals("1")) {
                return;
            }
            if (z) {
                SwanAppAdLandingFragment.this.A4();
            } else {
                SwanAppAdLandingFragment.this.x4();
            }
        }

        @Override // com.baidu.tieba.a04
        public void b() {
            SwanAppAdLandingFragment.this.z4("appinstallbegin");
        }

        @Override // com.baidu.tieba.a04
        public String e() {
            SwanAppAdLandingFragment.this.z4("appinstallopen");
            SwanAppAdLandingFragment swanAppAdLandingFragment = SwanAppAdLandingFragment.this;
            return swanAppAdLandingFragment.c4(swanAppAdLandingFragment.X0.a);
        }

        @Override // com.baidu.tieba.a04
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
                                SwanAppAdLandingFragment.this.z4("appinstallfinish");
                            }
                        } else {
                            SwanAppAdLandingFragment.this.z4("appdownloadfinish");
                            SwanAppAdLandingFragment.this.z4("appinstallbegin");
                        }
                    } else {
                        SwanAppAdLandingFragment.this.z4("appdownloadcontinue");
                    }
                } else {
                    SwanAppAdLandingFragment.this.z4("appdownloadpause");
                }
            } else {
                SwanAppAdLandingFragment.this.z4("appdownloadbegin");
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
            if (SwanAppAdLandingFragment.this.s4() || SwanAppAdLandingFragment.this.q4()) {
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.height = height;
                this.a.setLayoutParams(layoutParams);
            }
            if (SwanAppAdLandingFragment.this.s4()) {
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
    public class l implements md2 {
        public final /* synthetic */ CustomerAdScrollView a;

        public l(CustomerAdScrollView customerAdScrollView) {
            this.a = customerAdScrollView;
        }

        @Override // com.baidu.tieba.md2
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
    public class m extends na2 {
        public final /* synthetic */ CustomerAdScrollView a;

        public m(CustomerAdScrollView customerAdScrollView) {
            this.a = customerAdScrollView;
        }

        @Override // com.baidu.tieba.na2
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
    public class n implements wy1 {
        public final /* synthetic */ CustomerAdScrollView a;

        public n(CustomerAdScrollView customerAdScrollView) {
            this.a = customerAdScrollView;
        }

        @Override // com.baidu.tieba.wy1
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            CustomerAdScrollView customerAdScrollView = this.a;
            SwanAppAdLandingFragment swanAppAdLandingFragment = SwanAppAdLandingFragment.this;
            customerAdScrollView.setIsFooterLayoutShow(swanAppAdLandingFragment.t4(swanAppAdLandingFragment.o1));
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
            if (id == R.id.obfuscated_res_0x7f09010f) {
                hashMap.put("da_area", "tail_icon");
            } else if (id == R.id.obfuscated_res_0x7f09010c) {
                hashMap.put("da_area", "tail_name");
            } else if (id == R.id.obfuscated_res_0x7f09010d) {
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
            nb2.f3("adLanding", z13.d(SwanAppAdLandingFragment.this.N0, SwanAppAdLandingFragment.this.N0));
        }
    }

    public final void A4() {
        x4();
        this.n1.addView(this.F1);
        this.n1.addView(this.V0.getRealView());
    }

    @Override // com.baidu.tieba.nb2, com.baidu.tieba.fb2
    public boolean H() {
        r03 r03Var;
        if (r4() && (r03Var = this.P0) != null) {
            return r03Var.onBackPressed();
        }
        z4("lpout");
        return super.H();
    }

    @Override // com.baidu.tieba.nb2
    public nd2 b3() {
        return new a();
    }

    public final void f4() {
        tp3.e0(new c());
    }

    @Override // com.baidu.tieba.nb2
    public iy1 j() {
        vy1 vy1Var = new vy1(getContext());
        vy1Var.r().setDownloadListener(new ISailorDownloadListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.9
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
                SwanAppAdLandingFragment.this.d4();
            }
        });
        return vy1Var;
    }

    @Override // com.baidu.tieba.fb2, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        v4();
    }

    @Override // com.baidu.tieba.fb2, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        xy1 xy1Var = this.C1;
        if (xy1Var != null && xy1Var.l() && !n0()) {
            y4();
        }
    }

    public final void p4() {
        int i2;
        xy1 xy1Var = new xy1(getContext());
        this.C1 = xy1Var;
        if (s4()) {
            i2 = this.a1;
        } else {
            i2 = 0;
        }
        xy1Var.o(i2);
        WebViewContainer k2 = this.C1.k();
        this.n1 = k2;
        this.p1.addView(k2);
    }

    public final boolean q4() {
        return TextUtils.equals("swan-custom-ad", this.S0);
    }

    public final boolean r4() {
        if (getActivity().getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }

    public final boolean s4() {
        if (this.O0 == LandingType.VIDEO) {
            return true;
        }
        return false;
    }

    public final void v4() {
        r03 r03Var = this.P0;
        if (r03Var != null && r03Var.n()) {
            this.P0.p();
        }
    }

    public final void x4() {
        this.n1.removeView(this.V0.getRealView());
        this.n1.removeView(this.F1);
    }

    public final void y4() {
        r03 r03Var = this.P0;
        if (r03Var != null && !r03Var.n() && !this.P0.m()) {
            this.P0.s();
        }
    }

    @Override // com.baidu.tieba.nb2, com.baidu.swan.support.v4.app.Fragment
    public void z0() {
        if (s4()) {
            z4("vplayend");
        }
        r03 r03Var = this.P0;
        if (r03Var != null) {
            r03Var.onDestroy();
        }
        if (!this.m1) {
            J2(0);
        }
        super.z0();
    }

    public final void d4() {
        i04 i04Var = this.L1;
        if (i04Var != null) {
            h(i04Var);
            return;
        }
        y04 y04Var = new y04(getContext());
        y04Var.d(this);
        z04 z04Var = new z04(getContext());
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
        y04Var.c(z04Var, jSONObject);
    }

    public final void n4() {
        int i2;
        DisplayMetrics displayMetrics = getActivity().getResources().getDisplayMetrics();
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

    public static /* synthetic */ int w3(SwanAppAdLandingFragment swanAppAdLandingFragment) {
        int i2 = swanAppAdLandingFragment.l1;
        swanAppAdLandingFragment.l1 = i2 + 1;
        return i2;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void D0(boolean z) {
        super.D0(z);
        if (z) {
            v4();
        } else {
            y4();
        }
    }

    @Override // com.baidu.tieba.nb2, com.baidu.tieba.fb2
    public void W1(View view2) {
        super.W1(view2);
        this.f0.setLeftHomeViewSrc(R.drawable.obfuscated_res_0x7f080123);
        this.f0.setLeftHomeViewClickListener(new b());
    }

    public final void b4(boolean z) {
        int i2;
        SwanAppActionBar swanAppActionBar = this.f0;
        if (z) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        swanAppActionBar.setLeftHomeViewVisibility(i2);
    }

    public final String c4(String str) {
        return nk3.a().getString(str, "");
    }

    public final void h4(ViewGroup viewGroup) {
        this.W0 = new j();
        this.X0 = new DownloadParams(this.T0, this.U0);
        h04 h04Var = new h04();
        h04Var.l(getContext(), this.X0, this.W0);
        this.V0 = h04Var;
        h04Var.e(this.X0);
        i4();
    }

    public final boolean t4(View view2) {
        if (view2 != null && view2.getVisibility() == 0) {
            return view2.getGlobalVisibleRect(new Rect());
        }
        return false;
    }

    public final void w4(String str) {
        if (!TextUtils.isEmpty(str)) {
            nk3.a().putString(this.X0.a, str);
        }
    }

    public final void z4(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        r03 r03Var = this.P0;
        if (r03Var != null) {
            hashMap.put("cur_time", String.valueOf(r03Var.e() / 1000));
        }
        j14 j14Var = this.Q0;
        if (j14Var != null) {
            j14Var.d(str, hashMap);
        }
    }

    public final void e4() {
        this.V0.f();
        if (TextUtils.isEmpty(this.X0.b)) {
            String c4 = c4(this.D1);
            this.X0.b = c4;
            this.V0.a(c4);
        }
        if (tp3.F(getContext(), this.X0.b)) {
            A4();
            this.V0.b(DownloadState.INSTALLED);
            return;
        }
        if (TextUtils.isEmpty(this.X0.a)) {
            this.X0.a = this.D1;
        }
        gv2.d().d(getContext(), this.X0.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.W0);
    }

    public final void g4(i04 i04Var, boolean z) {
        float f2;
        db3 db3Var = this.H1;
        if (db3Var != null) {
            db3Var.show();
            return;
        }
        ((ViewGroup) this.I1.findViewById(R.id.obfuscated_res_0x7f0900de)).addView(this.V0.getRealView());
        ((AdImageVIew) this.I1.findViewById(R.id.obfuscated_res_0x7f0900e0)).setImageUrl(i04Var.g());
        ((TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0900dd)).setText(i04Var.c());
        ((TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0900e5)).setText(i04Var.d());
        ((TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0900dc)).setText(i04Var.a());
        ((TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0900e7)).setText(i04Var.j());
        TextView textView = (TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0900df);
        if (!z) {
            textView.setText(i04Var.e());
            textView.setVisibility(0);
        }
        this.J1 = i04Var.h();
        this.K1 = i04Var.i();
        ViewGroup.LayoutParams layoutParams = this.V0.getRealView().getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
            this.V0.getRealView().setLayoutParams(layoutParams);
        }
        int o2 = qp3.o(getContext());
        float l2 = qp3.l(getContext());
        layoutParams.width = o2 - (((int) ((10.0f * l2) + 0.5f)) * 2);
        if (TextUtils.isEmpty(this.X0.b)) {
            String c4 = c4(i04Var.b());
            this.X0.b = c4;
            this.V0.a(c4);
        }
        if (tp3.F(getContext(), this.X0.b)) {
            this.V0.b(DownloadState.INSTALLED);
        }
        if (TextUtils.isEmpty(this.X0.a)) {
            this.X0.a = i04Var.b();
        }
        this.V0.e(this.X0);
        cb3 cb3Var = new cb3(getContext());
        cb3Var.i(true);
        cb3Var.k(false);
        cb3Var.T(false);
        cb3Var.m(false);
        cb3Var.t(false);
        cb3Var.n(new hr3());
        cb3Var.p(R.drawable.obfuscated_res_0x7f08013f);
        cb3Var.F(R.color.obfuscated_res_0x7f060aa1);
        cb3Var.K(new g());
        cb3Var.W(this.I1);
        cb3Var.j();
        if (z) {
            f2 = 225.0f;
        } else {
            f2 = 250.0f;
        }
        cb3Var.q((int) (l2 * f2));
        db3 c2 = cb3Var.c();
        this.H1 = c2;
        Window window = c2.getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setDimAmount(0.65f);
            window.setLayout(qp3.s(getContext()), -2);
            window.setWindowAnimations(R.style.obfuscated_res_0x7f1003b1);
        }
        this.H1.a(false);
        this.H1.setCanceledOnTouchOutside(true);
        this.H1.show();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.k04
    public void h(i04 i04Var) {
        char c2;
        this.L1 = i04Var;
        String f2 = i04Var.f();
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
                        f4();
                        return;
                    }
                    return;
                }
                g4(i04Var, false);
                return;
            }
            g4(i04Var, true);
            return;
        }
        e4();
    }

    public final void i4() {
        View inflate = View.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0099, null);
        this.I1 = inflate;
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0900e4)).setOnClickListener(new d());
        ((TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0900e3)).setOnClickListener(new e());
        ((ImageView) this.I1.findViewById(R.id.obfuscated_res_0x7f09071b)).setOnClickListener(new f());
        TextView textView = new TextView(getContext());
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
        layoutParams.bottomMargin = ((int) (getContext().getResources().getDisplayMetrics().heightPixels * 0.14d)) - 80;
        this.F1.setLayoutParams(layoutParams);
        this.F1.setGravity(81);
    }

    public final void j4(ViewGroup viewGroup, ViewGroup viewGroup2) {
        this.o1 = (LinearLayout) ((LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d08e3, (ViewGroup) null)).findViewById(R.id.obfuscated_res_0x7f0900b5);
        CustomerAdScrollView customerAdScrollView = new CustomerAdScrollView(getContext());
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.addView(viewGroup2, new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(this.o1, new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07080e)));
        customerAdScrollView.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        viewGroup.addView(customerAdScrollView);
        this.G0.s(new l(customerAdScrollView));
        this.G0.b(new m(customerAdScrollView));
        customerAdScrollView.setScrollViewListener(new n(customerAdScrollView));
    }

    public final void k4() {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d08e4, (ViewGroup) null);
        this.n1.addView(relativeLayout, new FrameLayout.LayoutParams(-1, this.z1));
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0900db);
        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0900e8);
        this.x1 = (FrameLayout) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0900e9);
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

    public final void m4() {
        int i2;
        int i3;
        if (this.q1.booleanValue()) {
            k4();
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
        uy1 uy1Var = new uy1(this.h1, this.i1, this.G0.a(), i2, i3, this.k1, this.q1.booleanValue());
        r03 r03Var = new r03(getContext(), uy1Var.a());
        this.P0 = r03Var;
        this.C1.p(r03Var);
        this.P0.v(new h());
        if (this.q1.booleanValue()) {
            this.P0.x(this.x1);
        }
        this.P0.o(uy1Var.a());
        this.P0.w(false);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.tieba.gy1] */
    public final void o4() {
        int i2;
        iy1 j2 = j();
        this.G0 = j2;
        j2.W(b3());
        this.H0 = this.G0.r();
        this.G0.loadUrl(this.N0);
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View covertToView = this.H0.covertToView();
        oc3 oc3Var = new oc3();
        oc3Var.e = SwanAppConfigData.t("#FFFFFF");
        this.G0.y(frameLayout, oc3Var);
        this.G0.N(frameLayout, oc3Var);
        this.G0.i(frameLayout, covertToView);
        if (q4()) {
            j4(this.n1, frameLayout);
        } else {
            this.n1.addView(frameLayout);
        }
        WebViewContainer webViewContainer = this.n1;
        if (webViewContainer != null) {
            webViewContainer.setInternalWebView(this.H0);
        }
        if (s4()) {
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

    public final void l4() {
        int i2;
        String str;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d08e5, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        if (this.q1.booleanValue()) {
            i2 = this.z1;
        } else {
            i2 = this.a1;
        }
        layoutParams.height = i2;
        this.Z0 = (RelativeLayout) relativeLayout.findViewById(R.id.obfuscated_res_0x7f090110);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f090111);
        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f09010f);
        TextView textView = (TextView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f09010c);
        TextView textView2 = (TextView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f09010d);
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
        simpleDraweeView.getHierarchy().setPlaceholderImage(getResources().getDrawable(R.drawable.obfuscated_res_0x7f0813d9));
        if (this.q1.booleanValue()) {
            str = this.B1;
        } else {
            str = this.h1;
        }
        if (!TextUtils.isEmpty(str)) {
            simpleDraweeView.setImageURI(xo3.m(str));
        }
        simpleDraweeView.setVisibility(0);
        simpleDraweeView.setOnClickListener(new i());
        simpleDraweeView2.setOnClickListener(this.M1);
        textView.setOnClickListener(this.M1);
        textView2.setOnClickListener(this.M1);
        this.n1.addView(this.Z0, layoutParams);
        this.Z0.setVisibility(4);
    }

    public final void u4() {
        String K;
        Bundle o2 = o();
        if (o2 == null) {
            return;
        }
        this.N0 = o2.getString("url", "");
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
                K = K(R.string.obfuscated_res_0x7f0f14a7);
            } else {
                K = K(R.string.obfuscated_res_0x7f0f14b0);
            }
            this.d1 = K;
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

    @Override // com.baidu.tieba.nb2, com.baidu.swan.support.v4.app.Fragment
    public void v0(Bundle bundle) {
        boolean z;
        super.v0(bundle);
        u4();
        this.Q0 = new j14(getContext(), this.j1);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (1 == activity.getRequestedOrientation()) {
                z = true;
            } else {
                z = false;
            }
            this.m1 = z;
            if (!z) {
                J2(1);
            }
        }
        if (N1) {
            Log.d("SwanAppAdLandFragment", "onCreate() : " + this);
        }
    }

    @Override // com.baidu.tieba.nb2, com.baidu.swan.support.v4.app.Fragment
    public View y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00e3, viewGroup, false);
        W1(inflate);
        this.p1 = (ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f092250);
        this.R0 = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0901bc);
        n4();
        p4();
        h4(this.n1);
        o4();
        if (s4()) {
            m4();
            l4();
        }
        if (V1()) {
            inflate = Y1(inflate);
        }
        z4("lpin");
        return F1(inflate, this);
    }
}
