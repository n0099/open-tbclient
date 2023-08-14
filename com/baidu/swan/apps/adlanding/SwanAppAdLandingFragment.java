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
import com.baidu.tieba.ba3;
import com.baidu.tieba.ca3;
import com.baidu.tieba.ev2;
import com.baidu.tieba.ez3;
import com.baidu.tieba.fu2;
import com.baidu.tieba.gq3;
import com.baidu.tieba.gz3;
import com.baidu.tieba.hx1;
import com.baidu.tieba.hz3;
import com.baidu.tieba.i04;
import com.baidu.tieba.ir1;
import com.baidu.tieba.jc2;
import com.baidu.tieba.jz3;
import com.baidu.tieba.lc2;
import com.baidu.tieba.m92;
import com.baidu.tieba.ma2;
import com.baidu.tieba.mc2;
import com.baidu.tieba.mj3;
import com.baidu.tieba.nb3;
import com.baidu.tieba.pb3;
import com.baidu.tieba.po3;
import com.baidu.tieba.qa3;
import com.baidu.tieba.qz2;
import com.baidu.tieba.rz2;
import com.baidu.tieba.so3;
import com.baidu.tieba.tx1;
import com.baidu.tieba.ux1;
import com.baidu.tieba.vx1;
import com.baidu.tieba.wn3;
import com.baidu.tieba.wx1;
import com.baidu.tieba.xz3;
import com.baidu.tieba.y03;
import com.baidu.tieba.ya3;
import com.baidu.tieba.yz3;
import com.baidu.tieba.zy3;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SwanAppAdLandingFragment extends ma2 implements jz3 {
    public static final boolean N1 = ir1.a;
    public int A1;
    public String B1;
    public wx1 C1;
    public String D1;
    public String E1;
    public TextView F1;
    public String G1;
    public View I1;
    public String J1;
    public String K1;
    public String N0;
    public qz2 P0;
    public i04 Q0;
    public FrameLayout R0;
    public ez3 V0;
    public zy3 W0;
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
    public ca3 H1 = null;
    public hz3 L1 = null;
    public View.OnClickListener M1 = new o();

    /* loaded from: classes4.dex */
    public enum LandingType {
        NORMAL,
        VIDEO
    }

    @Override // com.baidu.tieba.ma2, com.baidu.tieba.ea2
    public boolean e2() {
        return true;
    }

    /* loaded from: classes4.dex */
    public class a extends jc2 {

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

        @Override // com.baidu.tieba.jc2, com.baidu.tieba.mc2
        public void d(String str) {
            SwanAppAdLandingFragment swanAppAdLandingFragment = SwanAppAdLandingFragment.this;
            swanAppAdLandingFragment.b4(swanAppAdLandingFragment.H0.canGoBack());
            SwanAppAdLandingFragment.this.f0.post(new RunnableC0206a(str));
        }

        @Override // com.baidu.tieba.jc2, com.baidu.tieba.mc2
        public void e(String str) {
            super.e(str);
            if (!TextUtils.isEmpty(SwanAppAdLandingFragment.this.g1) && SwanAppAdLandingFragment.this.Q0 != null) {
                SwanAppAdLandingFragment.this.Q0.e(SwanAppAdLandingFragment.this.g1);
            }
        }

        @Override // com.baidu.tieba.jc2, com.baidu.tieba.mc2
        public boolean a(String str) {
            if (pb3.e(str) || pb3.f(str)) {
                try {
                    Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(str));
                    ya3 b0 = ya3.b0();
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

        @Override // com.baidu.tieba.jc2, com.baidu.tieba.mc2
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
            ma2.a3();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            qa3 g = qa3.g(SwanAppAdLandingFragment.this.getContext(), "第三方页面应用未经百度审核");
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
            ma2.f3("adLanding", y03.d(SwanAppAdLandingFragment.this.K1, SwanAppAdLandingFragment.this.K1));
            SwanAppAdLandingFragment.this.H1.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            ma2.f3("adLanding", y03.d(SwanAppAdLandingFragment.this.J1, SwanAppAdLandingFragment.this.J1));
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
    public class h implements rz2 {
        @Override // com.baidu.tieba.rz2
        public void e(ev2 ev2Var) {
        }

        @Override // com.baidu.tieba.rz2
        public boolean f(ev2 ev2Var, int i, int i2) {
            return false;
        }

        public h() {
        }

        @Override // com.baidu.tieba.rz2
        public void a(ev2 ev2Var) {
            SwanAppAdLandingFragment.this.z4("vcontinueplay");
        }

        @Override // com.baidu.tieba.rz2
        public void b(ev2 ev2Var) {
            SwanAppAdLandingFragment.this.Z0.bringToFront();
            SwanAppAdLandingFragment.this.Z0.setVisibility(0);
            SwanAppAdLandingFragment.this.k1 = 0;
            SwanAppAdLandingFragment.w3(SwanAppAdLandingFragment.this);
            SwanAppAdLandingFragment.this.z4("vplayend");
            SwanAppAdLandingFragment.this.z4("scard");
        }

        @Override // com.baidu.tieba.rz2
        public void c(ev2 ev2Var) {
            SwanAppAdLandingFragment.this.z4("vpause");
        }

        @Override // com.baidu.tieba.rz2
        public void d(ev2 ev2Var) {
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
    public class j implements zy3 {
        public j() {
        }

        @Override // com.baidu.tieba.zy3
        public void a(int i) {
            SwanAppAdLandingFragment.this.V0.d(i);
        }

        @Override // com.baidu.tieba.zy3
        public void d(String str) {
            SwanAppAdLandingFragment.this.w4(str);
        }

        @Override // com.baidu.tieba.zy3
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

        @Override // com.baidu.tieba.zy3
        public void b() {
            SwanAppAdLandingFragment.this.z4("appinstallbegin");
        }

        @Override // com.baidu.tieba.zy3
        public String e() {
            SwanAppAdLandingFragment.this.z4("appinstallopen");
            SwanAppAdLandingFragment swanAppAdLandingFragment = SwanAppAdLandingFragment.this;
            return swanAppAdLandingFragment.c4(swanAppAdLandingFragment.X0.a);
        }

        @Override // com.baidu.tieba.zy3
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
    public class l implements lc2 {
        public final /* synthetic */ CustomerAdScrollView a;

        public l(CustomerAdScrollView customerAdScrollView) {
            this.a = customerAdScrollView;
        }

        @Override // com.baidu.tieba.lc2
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
    public class m extends m92 {
        public final /* synthetic */ CustomerAdScrollView a;

        public m(CustomerAdScrollView customerAdScrollView) {
            this.a = customerAdScrollView;
        }

        @Override // com.baidu.tieba.m92
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
    public class n implements vx1 {
        public final /* synthetic */ CustomerAdScrollView a;

        public n(CustomerAdScrollView customerAdScrollView) {
            this.a = customerAdScrollView;
        }

        @Override // com.baidu.tieba.vx1
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
            ma2.f3("adLanding", y03.d(SwanAppAdLandingFragment.this.N0, SwanAppAdLandingFragment.this.N0));
        }
    }

    public final void A4() {
        x4();
        this.n1.addView(this.F1);
        this.n1.addView(this.V0.getRealView());
    }

    @Override // com.baidu.tieba.ma2, com.baidu.tieba.ea2
    public boolean H() {
        qz2 qz2Var;
        if (r4() && (qz2Var = this.P0) != null) {
            return qz2Var.onBackPressed();
        }
        z4("lpout");
        return super.H();
    }

    @Override // com.baidu.tieba.ma2
    public mc2 b3() {
        return new a();
    }

    public final void f4() {
        so3.e0(new c());
    }

    @Override // com.baidu.tieba.ma2
    public hx1 j() {
        ux1 ux1Var = new ux1(getContext());
        ux1Var.r().setDownloadListener(new ISailorDownloadListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.9
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
        return ux1Var;
    }

    @Override // com.baidu.tieba.ea2, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        v4();
    }

    @Override // com.baidu.tieba.ea2, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        wx1 wx1Var = this.C1;
        if (wx1Var != null && wx1Var.l() && !n0()) {
            y4();
        }
    }

    public final void p4() {
        int i2;
        wx1 wx1Var = new wx1(getContext());
        this.C1 = wx1Var;
        if (s4()) {
            i2 = this.a1;
        } else {
            i2 = 0;
        }
        wx1Var.o(i2);
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
        qz2 qz2Var = this.P0;
        if (qz2Var != null && qz2Var.n()) {
            this.P0.p();
        }
    }

    public final void x4() {
        this.n1.removeView(this.V0.getRealView());
        this.n1.removeView(this.F1);
    }

    public final void y4() {
        qz2 qz2Var = this.P0;
        if (qz2Var != null && !qz2Var.n() && !this.P0.m()) {
            this.P0.s();
        }
    }

    @Override // com.baidu.tieba.ma2, com.baidu.swan.support.v4.app.Fragment
    public void z0() {
        if (s4()) {
            z4("vplayend");
        }
        qz2 qz2Var = this.P0;
        if (qz2Var != null) {
            qz2Var.onDestroy();
        }
        if (!this.m1) {
            J2(0);
        }
        super.z0();
    }

    public final void d4() {
        hz3 hz3Var = this.L1;
        if (hz3Var != null) {
            h(hz3Var);
            return;
        }
        xz3 xz3Var = new xz3(getContext());
        xz3Var.d(this);
        yz3 yz3Var = new yz3(getContext());
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
        xz3Var.c(yz3Var, jSONObject);
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

    @Override // com.baidu.tieba.ma2, com.baidu.tieba.ea2
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
        return mj3.a().getString(str, "");
    }

    public final void h4(ViewGroup viewGroup) {
        this.W0 = new j();
        this.X0 = new DownloadParams(this.T0, this.U0);
        gz3 gz3Var = new gz3();
        gz3Var.l(getContext(), this.X0, this.W0);
        this.V0 = gz3Var;
        gz3Var.e(this.X0);
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
            mj3.a().putString(this.X0.a, str);
        }
    }

    public final void z4(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        qz2 qz2Var = this.P0;
        if (qz2Var != null) {
            hashMap.put("cur_time", String.valueOf(qz2Var.e() / 1000));
        }
        i04 i04Var = this.Q0;
        if (i04Var != null) {
            i04Var.d(str, hashMap);
        }
    }

    public final void e4() {
        this.V0.f();
        if (TextUtils.isEmpty(this.X0.b)) {
            String c4 = c4(this.D1);
            this.X0.b = c4;
            this.V0.a(c4);
        }
        if (so3.F(getContext(), this.X0.b)) {
            A4();
            this.V0.b(DownloadState.INSTALLED);
            return;
        }
        if (TextUtils.isEmpty(this.X0.a)) {
            this.X0.a = this.D1;
        }
        fu2.d().d(getContext(), this.X0.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.W0);
    }

    public final void g4(hz3 hz3Var, boolean z) {
        float f2;
        ca3 ca3Var = this.H1;
        if (ca3Var != null) {
            ca3Var.show();
            return;
        }
        ((ViewGroup) this.I1.findViewById(R.id.obfuscated_res_0x7f0900dd)).addView(this.V0.getRealView());
        ((AdImageVIew) this.I1.findViewById(R.id.obfuscated_res_0x7f0900df)).setImageUrl(hz3Var.g());
        ((TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0900dc)).setText(hz3Var.c());
        ((TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0900e4)).setText(hz3Var.d());
        ((TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0900db)).setText(hz3Var.a());
        ((TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0900e6)).setText(hz3Var.j());
        TextView textView = (TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0900de);
        if (!z) {
            textView.setText(hz3Var.e());
            textView.setVisibility(0);
        }
        this.J1 = hz3Var.h();
        this.K1 = hz3Var.i();
        ViewGroup.LayoutParams layoutParams = this.V0.getRealView().getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
            this.V0.getRealView().setLayoutParams(layoutParams);
        }
        int o2 = po3.o(getContext());
        float l2 = po3.l(getContext());
        layoutParams.width = o2 - (((int) ((10.0f * l2) + 0.5f)) * 2);
        if (TextUtils.isEmpty(this.X0.b)) {
            String c4 = c4(hz3Var.b());
            this.X0.b = c4;
            this.V0.a(c4);
        }
        if (so3.F(getContext(), this.X0.b)) {
            this.V0.b(DownloadState.INSTALLED);
        }
        if (TextUtils.isEmpty(this.X0.a)) {
            this.X0.a = hz3Var.b();
        }
        this.V0.e(this.X0);
        ba3 ba3Var = new ba3(getContext());
        ba3Var.i(true);
        ba3Var.k(false);
        ba3Var.T(false);
        ba3Var.m(false);
        ba3Var.t(false);
        ba3Var.n(new gq3());
        ba3Var.p(R.drawable.obfuscated_res_0x7f08013f);
        ba3Var.F(R.color.obfuscated_res_0x7f060aaa);
        ba3Var.K(new g());
        ba3Var.W(this.I1);
        ba3Var.j();
        if (z) {
            f2 = 225.0f;
        } else {
            f2 = 250.0f;
        }
        ba3Var.q((int) (l2 * f2));
        ca3 c2 = ba3Var.c();
        this.H1 = c2;
        Window window = c2.getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setDimAmount(0.65f);
            window.setLayout(po3.s(getContext()), -2);
            window.setWindowAnimations(R.style.obfuscated_res_0x7f1003b2);
        }
        this.H1.a(false);
        this.H1.setCanceledOnTouchOutside(true);
        this.H1.show();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.jz3
    public void h(hz3 hz3Var) {
        char c2;
        this.L1 = hz3Var;
        String f2 = hz3Var.f();
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
                g4(hz3Var, false);
                return;
            }
            g4(hz3Var, true);
            return;
        }
        e4();
    }

    public final void i4() {
        View inflate = View.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0098, null);
        this.I1 = inflate;
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0900e3)).setOnClickListener(new d());
        ((TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0900e2)).setOnClickListener(new e());
        ((ImageView) this.I1.findViewById(R.id.obfuscated_res_0x7f090733)).setOnClickListener(new f());
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
        this.o1 = (LinearLayout) ((LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d091c, (ViewGroup) null)).findViewById(R.id.obfuscated_res_0x7f0900b4);
        CustomerAdScrollView customerAdScrollView = new CustomerAdScrollView(getContext());
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.addView(viewGroup2, new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(this.o1, new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070824)));
        customerAdScrollView.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        viewGroup.addView(customerAdScrollView);
        this.G0.s(new l(customerAdScrollView));
        this.G0.b(new m(customerAdScrollView));
        customerAdScrollView.setScrollViewListener(new n(customerAdScrollView));
    }

    public final void k4() {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d091d, (ViewGroup) null);
        this.n1.addView(relativeLayout, new FrameLayout.LayoutParams(-1, this.z1));
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0900da);
        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0900e7);
        this.x1 = (FrameLayout) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0900e8);
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
        tx1 tx1Var = new tx1(this.h1, this.i1, this.G0.a(), i2, i3, this.k1, this.q1.booleanValue());
        qz2 qz2Var = new qz2(getContext(), tx1Var.a());
        this.P0 = qz2Var;
        this.C1.p(qz2Var);
        this.P0.v(new h());
        if (this.q1.booleanValue()) {
            this.P0.x(this.x1);
        }
        this.P0.o(tx1Var.a());
        this.P0.w(false);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.tieba.fx1] */
    public final void o4() {
        int i2;
        hx1 j2 = j();
        this.G0 = j2;
        j2.W(b3());
        this.H0 = this.G0.r();
        this.G0.loadUrl(this.N0);
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View covertToView = this.H0.covertToView();
        nb3 nb3Var = new nb3();
        nb3Var.e = SwanAppConfigData.t("#FFFFFF");
        this.G0.y(frameLayout, nb3Var);
        this.G0.N(frameLayout, nb3Var);
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
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d091e, (ViewGroup) null);
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
        simpleDraweeView.getHierarchy().setPlaceholderImage(getResources().getDrawable(R.drawable.obfuscated_res_0x7f081429));
        if (this.q1.booleanValue()) {
            str = this.B1;
        } else {
            str = this.h1;
        }
        if (!TextUtils.isEmpty(str)) {
            simpleDraweeView.setImageURI(wn3.m(str));
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
                K = K(R.string.obfuscated_res_0x7f0f14de);
            } else {
                K = K(R.string.obfuscated_res_0x7f0f14e7);
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

    @Override // com.baidu.tieba.ma2, com.baidu.swan.support.v4.app.Fragment
    public void v0(Bundle bundle) {
        boolean z;
        super.v0(bundle);
        u4();
        this.Q0 = new i04(getContext(), this.j1);
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

    @Override // com.baidu.tieba.ma2, com.baidu.swan.support.v4.app.Fragment
    public View y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00e2, viewGroup, false);
        W1(inflate);
        this.p1 = (ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f092301);
        this.R0 = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0901bd);
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
