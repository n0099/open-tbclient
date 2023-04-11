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
import com.baidu.tieba.as2;
import com.baidu.tieba.aw3;
import com.baidu.tieba.br2;
import com.baidu.tieba.cn3;
import com.baidu.tieba.cw3;
import com.baidu.tieba.du1;
import com.baidu.tieba.dw3;
import com.baidu.tieba.eo1;
import com.baidu.tieba.ex3;
import com.baidu.tieba.f92;
import com.baidu.tieba.fw3;
import com.baidu.tieba.h92;
import com.baidu.tieba.i62;
import com.baidu.tieba.i72;
import com.baidu.tieba.i92;
import com.baidu.tieba.ig3;
import com.baidu.tieba.j83;
import com.baidu.tieba.l83;
import com.baidu.tieba.ll3;
import com.baidu.tieba.m73;
import com.baidu.tieba.mw2;
import com.baidu.tieba.nw2;
import com.baidu.tieba.ol3;
import com.baidu.tieba.pu1;
import com.baidu.tieba.qu1;
import com.baidu.tieba.ru1;
import com.baidu.tieba.sk3;
import com.baidu.tieba.su1;
import com.baidu.tieba.tw3;
import com.baidu.tieba.u73;
import com.baidu.tieba.uw3;
import com.baidu.tieba.ux2;
import com.baidu.tieba.vv3;
import com.baidu.tieba.x63;
import com.baidu.tieba.y63;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SwanAppAdLandingFragment extends i72 implements fw3 {
    public static final boolean N1 = eo1.a;
    public int A1;
    public String B1;
    public su1 C1;
    public String D1;
    public String E1;
    public TextView F1;
    public String G1;
    public View I1;
    public String J1;
    public String K1;
    public String N0;
    public mw2 P0;
    public ex3 Q0;
    public FrameLayout R0;
    public aw3 V0;
    public vv3 W0;
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
    public y63 H1 = null;
    public dw3 L1 = null;
    public View.OnClickListener M1 = new o();

    /* loaded from: classes3.dex */
    public enum LandingType {
        NORMAL,
        VIDEO
    }

    @Override // com.baidu.tieba.i72, com.baidu.tieba.a72
    public boolean f2() {
        return true;
    }

    /* loaded from: classes3.dex */
    public class a extends f92 {

        /* renamed from: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0180a implements Runnable {
            public final /* synthetic */ String a;

            public RunnableC0180a(String str) {
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

        @Override // com.baidu.tieba.f92, com.baidu.tieba.i92
        public void d(String str) {
            SwanAppAdLandingFragment swanAppAdLandingFragment = SwanAppAdLandingFragment.this;
            swanAppAdLandingFragment.c4(swanAppAdLandingFragment.H0.canGoBack());
            SwanAppAdLandingFragment.this.f0.post(new RunnableC0180a(str));
        }

        @Override // com.baidu.tieba.f92, com.baidu.tieba.i92
        public void e(String str) {
            super.e(str);
            if (!TextUtils.isEmpty(SwanAppAdLandingFragment.this.g1) && SwanAppAdLandingFragment.this.Q0 != null) {
                SwanAppAdLandingFragment.this.Q0.e(SwanAppAdLandingFragment.this.g1);
            }
        }

        @Override // com.baidu.tieba.f92, com.baidu.tieba.i92
        public boolean a(String str) {
            if (l83.e(str) || l83.f(str)) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    u73 b0 = u73.b0();
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

        @Override // com.baidu.tieba.f92, com.baidu.tieba.i92
        public void goBack() {
            SwanAppAdLandingFragment swanAppAdLandingFragment = SwanAppAdLandingFragment.this;
            swanAppAdLandingFragment.c4(swanAppAdLandingFragment.H0.canGoBack());
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            i72.b3();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m73 g = m73.g(SwanAppAdLandingFragment.this.getContext(), "第三方页面应用未经百度审核");
            g.p(ToastLocation.BOTTOM);
            g.G();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            i72.g3("adLanding", ux2.d(SwanAppAdLandingFragment.this.K1, SwanAppAdLandingFragment.this.K1));
            SwanAppAdLandingFragment.this.H1.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            i72.g3("adLanding", ux2.d(SwanAppAdLandingFragment.this.J1, SwanAppAdLandingFragment.this.J1));
            SwanAppAdLandingFragment.this.H1.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SwanAppAdLandingFragment.this.H1.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class g implements DialogInterface.OnCancelListener {
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
        }

        public g() {
        }
    }

    /* loaded from: classes3.dex */
    public class h implements nw2 {
        @Override // com.baidu.tieba.nw2
        public void e(as2 as2Var) {
        }

        @Override // com.baidu.tieba.nw2
        public boolean f(as2 as2Var, int i, int i2) {
            return false;
        }

        public h() {
        }

        @Override // com.baidu.tieba.nw2
        public void a(as2 as2Var) {
            SwanAppAdLandingFragment.this.A4("vcontinueplay");
        }

        @Override // com.baidu.tieba.nw2
        public void b(as2 as2Var) {
            SwanAppAdLandingFragment.this.Z0.bringToFront();
            SwanAppAdLandingFragment.this.Z0.setVisibility(0);
            SwanAppAdLandingFragment.this.k1 = 0;
            SwanAppAdLandingFragment.x3(SwanAppAdLandingFragment.this);
            SwanAppAdLandingFragment.this.A4("vplayend");
            SwanAppAdLandingFragment.this.A4("scard");
        }

        @Override // com.baidu.tieba.nw2
        public void c(as2 as2Var) {
            SwanAppAdLandingFragment.this.A4("vpause");
        }

        @Override // com.baidu.tieba.nw2
        public void d(as2 as2Var) {
            if (SwanAppAdLandingFragment.this.l1 != 0) {
                SwanAppAdLandingFragment.this.Z0.setVisibility(8);
                SwanAppAdLandingFragment.this.A4("vrepeatedplay");
                return;
            }
            SwanAppAdLandingFragment.this.A4("vstart");
        }
    }

    /* loaded from: classes3.dex */
    public class i implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
        }

        public i() {
        }
    }

    /* loaded from: classes3.dex */
    public class j implements vv3 {
        public j() {
        }

        @Override // com.baidu.tieba.vv3
        public void a(int i) {
            SwanAppAdLandingFragment.this.V0.d(i);
        }

        @Override // com.baidu.tieba.vv3
        public void d(String str) {
            SwanAppAdLandingFragment.this.x4(str);
        }

        @Override // com.baidu.tieba.vv3
        public void f(boolean z) {
            if (!SwanAppAdLandingFragment.this.G1.equals("1")) {
                return;
            }
            if (z) {
                SwanAppAdLandingFragment.this.B4();
            } else {
                SwanAppAdLandingFragment.this.y4();
            }
        }

        @Override // com.baidu.tieba.vv3
        public void b() {
            SwanAppAdLandingFragment.this.A4("appinstallbegin");
        }

        @Override // com.baidu.tieba.vv3
        public String e() {
            SwanAppAdLandingFragment.this.A4("appinstallopen");
            SwanAppAdLandingFragment swanAppAdLandingFragment = SwanAppAdLandingFragment.this;
            return swanAppAdLandingFragment.d4(swanAppAdLandingFragment.X0.a);
        }

        @Override // com.baidu.tieba.vv3
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
                                SwanAppAdLandingFragment.this.A4("appinstallfinish");
                            }
                        } else {
                            SwanAppAdLandingFragment.this.A4("appdownloadfinish");
                            SwanAppAdLandingFragment.this.A4("appinstallbegin");
                        }
                    } else {
                        SwanAppAdLandingFragment.this.A4("appdownloadcontinue");
                    }
                } else {
                    SwanAppAdLandingFragment.this.A4("appdownloadpause");
                }
            } else {
                SwanAppAdLandingFragment.this.A4("appdownloadbegin");
            }
            SwanAppAdLandingFragment.this.Y0 = downloadState;
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {
        public final /* synthetic */ View a;

        public k(View view2) {
            this.a = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int height = SwanAppAdLandingFragment.this.R0.getHeight();
            if (SwanAppAdLandingFragment.this.t4() || SwanAppAdLandingFragment.this.r4()) {
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.height = height;
                this.a.setLayoutParams(layoutParams);
            }
            if (SwanAppAdLandingFragment.this.t4()) {
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

    /* loaded from: classes3.dex */
    public class l implements h92 {
        public final /* synthetic */ CustomerAdScrollView a;

        public l(CustomerAdScrollView customerAdScrollView) {
            this.a = customerAdScrollView;
        }

        @Override // com.baidu.tieba.h92
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

    /* loaded from: classes3.dex */
    public class m extends i62 {
        public final /* synthetic */ CustomerAdScrollView a;

        public m(CustomerAdScrollView customerAdScrollView) {
            this.a = customerAdScrollView;
        }

        @Override // com.baidu.tieba.i62
        public void a(String str) {
            super.a(str);
            if (Math.abs((SwanAppAdLandingFragment.this.H0.getContentHeight() * SwanAppAdLandingFragment.this.H0.getScale()) - SwanAppAdLandingFragment.this.H0.covertToView().getHeight()) < 10.0f) {
                this.a.setIsWebViewOnBottom(true);
            } else {
                this.a.setIsWebViewOnBottom(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class n implements ru1 {
        public final /* synthetic */ CustomerAdScrollView a;

        public n(CustomerAdScrollView customerAdScrollView) {
            this.a = customerAdScrollView;
        }

        @Override // com.baidu.tieba.ru1
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            CustomerAdScrollView customerAdScrollView = this.a;
            SwanAppAdLandingFragment swanAppAdLandingFragment = SwanAppAdLandingFragment.this;
            customerAdScrollView.setIsFooterLayoutShow(swanAppAdLandingFragment.u4(swanAppAdLandingFragment.o1));
        }
    }

    /* loaded from: classes3.dex */
    public class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            int id = view2.getId();
            HashMap<String, String> hashMap = new HashMap<>();
            if (id == R.id.obfuscated_res_0x7f090102) {
                hashMap.put("da_area", "tail_icon");
            } else if (id == R.id.obfuscated_res_0x7f0900ff) {
                hashMap.put("da_area", "tail_name");
            } else if (id == R.id.obfuscated_res_0x7f090100) {
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
            i72.g3("adLanding", ux2.d(SwanAppAdLandingFragment.this.N0, SwanAppAdLandingFragment.this.N0));
        }
    }

    @Override // com.baidu.tieba.i72, com.baidu.swan.support.v4.app.Fragment
    public void A0() {
        if (t4()) {
            A4("vplayend");
        }
        mw2 mw2Var = this.P0;
        if (mw2Var != null) {
            mw2Var.onDestroy();
        }
        if (!this.m1) {
            K2(0);
        }
        super.A0();
    }

    public final void B4() {
        y4();
        this.n1.addView(this.F1);
        this.n1.addView(this.V0.getRealView());
    }

    @Override // com.baidu.tieba.i72, com.baidu.tieba.a72
    public boolean I() {
        mw2 mw2Var;
        if (s4() && (mw2Var = this.P0) != null) {
            return mw2Var.onBackPressed();
        }
        A4("lpout");
        return super.I();
    }

    @Override // com.baidu.tieba.i72
    public i92 c3() {
        return new a();
    }

    public final void g4() {
        ol3.e0(new c());
    }

    @Override // com.baidu.tieba.i72
    public du1 k() {
        qu1 qu1Var = new qu1(getContext());
        qu1Var.r().setDownloadListener(new ISailorDownloadListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.9
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
                SwanAppAdLandingFragment.this.e4();
            }
        });
        return qu1Var;
    }

    @Override // com.baidu.tieba.a72, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        w4();
    }

    @Override // com.baidu.tieba.a72, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        su1 su1Var = this.C1;
        if (su1Var != null && su1Var.l() && !o0()) {
            z4();
        }
    }

    public final void q4() {
        int i2;
        su1 su1Var = new su1(getContext());
        this.C1 = su1Var;
        if (t4()) {
            i2 = this.a1;
        } else {
            i2 = 0;
        }
        su1Var.o(i2);
        WebViewContainer k2 = this.C1.k();
        this.n1 = k2;
        this.p1.addView(k2);
    }

    public final boolean r4() {
        return TextUtils.equals("swan-custom-ad", this.S0);
    }

    public final boolean s4() {
        if (getActivity().getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }

    public final boolean t4() {
        if (this.O0 == LandingType.VIDEO) {
            return true;
        }
        return false;
    }

    public final void w4() {
        mw2 mw2Var = this.P0;
        if (mw2Var != null && mw2Var.n()) {
            this.P0.p();
        }
    }

    public final void y4() {
        this.n1.removeView(this.V0.getRealView());
        this.n1.removeView(this.F1);
    }

    public final void z4() {
        mw2 mw2Var = this.P0;
        if (mw2Var != null && !mw2Var.n() && !this.P0.m()) {
            this.P0.s();
        }
    }

    public final void e4() {
        dw3 dw3Var = this.L1;
        if (dw3Var != null) {
            i(dw3Var);
            return;
        }
        tw3 tw3Var = new tw3(getContext());
        tw3Var.d(this);
        uw3 uw3Var = new uw3(getContext());
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
        tw3Var.c(uw3Var, jSONObject);
    }

    public final void o4() {
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

    public static /* synthetic */ int x3(SwanAppAdLandingFragment swanAppAdLandingFragment) {
        int i2 = swanAppAdLandingFragment.l1;
        swanAppAdLandingFragment.l1 = i2 + 1;
        return i2;
    }

    public final void A4(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        mw2 mw2Var = this.P0;
        if (mw2Var != null) {
            hashMap.put("cur_time", String.valueOf(mw2Var.e() / 1000));
        }
        ex3 ex3Var = this.Q0;
        if (ex3Var != null) {
            ex3Var.d(str, hashMap);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void E0(boolean z) {
        super.E0(z);
        if (z) {
            w4();
        } else {
            z4();
        }
    }

    @Override // com.baidu.tieba.i72, com.baidu.tieba.a72
    public void X1(View view2) {
        super.X1(view2);
        this.f0.setLeftHomeViewSrc(R.drawable.obfuscated_res_0x7f08010a);
        this.f0.setLeftHomeViewClickListener(new b());
    }

    public final void c4(boolean z) {
        int i2;
        SwanAppActionBar swanAppActionBar = this.f0;
        if (z) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        swanAppActionBar.setLeftHomeViewVisibility(i2);
    }

    public final String d4(String str) {
        return ig3.a().getString(str, "");
    }

    public final void i4(ViewGroup viewGroup) {
        this.W0 = new j();
        this.X0 = new DownloadParams(this.T0, this.U0);
        cw3 cw3Var = new cw3();
        cw3Var.l(getContext(), this.X0, this.W0);
        this.V0 = cw3Var;
        cw3Var.e(this.X0);
        j4();
    }

    public final boolean u4(View view2) {
        if (view2 != null && view2.getVisibility() == 0) {
            return view2.getGlobalVisibleRect(new Rect());
        }
        return false;
    }

    public final void x4(String str) {
        if (!TextUtils.isEmpty(str)) {
            ig3.a().putString(this.X0.a, str);
        }
    }

    public final void f4() {
        this.V0.f();
        if (TextUtils.isEmpty(this.X0.b)) {
            String d4 = d4(this.D1);
            this.X0.b = d4;
            this.V0.a(d4);
        }
        if (ol3.F(getContext(), this.X0.b)) {
            B4();
            this.V0.b(DownloadState.INSTALLED);
            return;
        }
        if (TextUtils.isEmpty(this.X0.a)) {
            this.X0.a = this.D1;
        }
        br2.d().d(getContext(), this.X0.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.W0);
    }

    public final void h4(dw3 dw3Var, boolean z) {
        float f2;
        y63 y63Var = this.H1;
        if (y63Var != null) {
            y63Var.show();
            return;
        }
        ((ViewGroup) this.I1.findViewById(R.id.obfuscated_res_0x7f0900d1)).addView(this.V0.getRealView());
        ((AdImageVIew) this.I1.findViewById(R.id.obfuscated_res_0x7f0900d3)).setImageUrl(dw3Var.g());
        ((TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0900d0)).setText(dw3Var.c());
        ((TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0900d8)).setText(dw3Var.d());
        ((TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0900cf)).setText(dw3Var.a());
        ((TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0900da)).setText(dw3Var.j());
        TextView textView = (TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0900d2);
        if (!z) {
            textView.setText(dw3Var.e());
            textView.setVisibility(0);
        }
        this.J1 = dw3Var.h();
        this.K1 = dw3Var.i();
        ViewGroup.LayoutParams layoutParams = this.V0.getRealView().getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
            this.V0.getRealView().setLayoutParams(layoutParams);
        }
        int o2 = ll3.o(getContext());
        float l2 = ll3.l(getContext());
        layoutParams.width = o2 - (((int) ((10.0f * l2) + 0.5f)) * 2);
        if (TextUtils.isEmpty(this.X0.b)) {
            String d4 = d4(dw3Var.b());
            this.X0.b = d4;
            this.V0.a(d4);
        }
        if (ol3.F(getContext(), this.X0.b)) {
            this.V0.b(DownloadState.INSTALLED);
        }
        if (TextUtils.isEmpty(this.X0.a)) {
            this.X0.a = dw3Var.b();
        }
        this.V0.e(this.X0);
        x63 x63Var = new x63(getContext());
        x63Var.i(true);
        x63Var.k(false);
        x63Var.T(false);
        x63Var.m(false);
        x63Var.t(false);
        x63Var.n(new cn3());
        x63Var.p(R.drawable.obfuscated_res_0x7f080126);
        x63Var.F(R.color.obfuscated_res_0x7f06090c);
        x63Var.K(new g());
        x63Var.W(this.I1);
        x63Var.j();
        if (z) {
            f2 = 225.0f;
        } else {
            f2 = 250.0f;
        }
        x63Var.q((int) (l2 * f2));
        y63 c2 = x63Var.c();
        this.H1 = c2;
        Window window = c2.getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setDimAmount(0.65f);
            window.setLayout(ll3.s(getContext()), -2);
            window.setWindowAnimations(R.style.obfuscated_res_0x7f1003a3);
        }
        this.H1.a(false);
        this.H1.setCanceledOnTouchOutside(true);
        this.H1.show();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.fw3
    public void i(dw3 dw3Var) {
        char c2;
        this.L1 = dw3Var;
        String f2 = dw3Var.f();
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
                        g4();
                        return;
                    }
                    return;
                }
                h4(dw3Var, false);
                return;
            }
            h4(dw3Var, true);
            return;
        }
        f4();
    }

    public final void j4() {
        View inflate = View.inflate(getContext(), R.layout.obfuscated_res_0x7f0d0096, null);
        this.I1 = inflate;
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0900d7)).setOnClickListener(new d());
        ((TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0900d6)).setOnClickListener(new e());
        ((ImageView) this.I1.findViewById(R.id.obfuscated_res_0x7f0906f9)).setOnClickListener(new f());
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

    public final void k4(ViewGroup viewGroup, ViewGroup viewGroup2) {
        this.o1 = (LinearLayout) ((LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d088c, (ViewGroup) null)).findViewById(R.id.obfuscated_res_0x7f0900a8);
        CustomerAdScrollView customerAdScrollView = new CustomerAdScrollView(getContext());
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.addView(viewGroup2, new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(this.o1, new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0706a9)));
        customerAdScrollView.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        viewGroup.addView(customerAdScrollView);
        this.G0.t(new l(customerAdScrollView));
        this.G0.b(new m(customerAdScrollView));
        customerAdScrollView.setScrollViewListener(new n(customerAdScrollView));
    }

    public final void l4() {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d088d, (ViewGroup) null);
        this.n1.addView(relativeLayout, new FrameLayout.LayoutParams(-1, this.z1));
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0900ce);
        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0900db);
        this.x1 = (FrameLayout) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0900dc);
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

    public final void n4() {
        int i2;
        int i3;
        if (this.q1.booleanValue()) {
            l4();
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
        pu1 pu1Var = new pu1(this.h1, this.i1, this.G0.a(), i2, i3, this.k1, this.q1.booleanValue());
        mw2 mw2Var = new mw2(getContext(), pu1Var.a());
        this.P0 = mw2Var;
        this.C1.p(mw2Var);
        this.P0.v(new h());
        if (this.q1.booleanValue()) {
            this.P0.x(this.x1);
        }
        this.P0.o(pu1Var.a());
        this.P0.w(false);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.tieba.bu1] */
    public final void p4() {
        int i2;
        du1 k2 = k();
        this.G0 = k2;
        k2.Y(c3());
        this.H0 = this.G0.r();
        this.G0.loadUrl(this.N0);
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View covertToView = this.H0.covertToView();
        j83 j83Var = new j83();
        j83Var.e = SwanAppConfigData.t("#FFFFFF");
        this.G0.z(frameLayout, j83Var);
        this.G0.O(frameLayout, j83Var);
        this.G0.j(frameLayout, covertToView);
        if (r4()) {
            k4(this.n1, frameLayout);
        } else {
            this.n1.addView(frameLayout);
        }
        WebViewContainer webViewContainer = this.n1;
        if (webViewContainer != null) {
            webViewContainer.setInternalWebView(this.H0);
        }
        if (t4()) {
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

    public final void m4() {
        int i2;
        String str;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d088e, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        if (this.q1.booleanValue()) {
            i2 = this.z1;
        } else {
            i2 = this.a1;
        }
        layoutParams.height = i2;
        this.Z0 = (RelativeLayout) relativeLayout.findViewById(R.id.obfuscated_res_0x7f090103);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f090104);
        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f090102);
        TextView textView = (TextView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0900ff);
        TextView textView2 = (TextView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f090100);
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
        simpleDraweeView.getHierarchy().setPlaceholderImage(getResources().getDrawable(R.drawable.obfuscated_res_0x7f081206));
        if (this.q1.booleanValue()) {
            str = this.B1;
        } else {
            str = this.h1;
        }
        if (!TextUtils.isEmpty(str)) {
            simpleDraweeView.setImageURI(sk3.m(str));
        }
        simpleDraweeView.setVisibility(0);
        simpleDraweeView.setOnClickListener(new i());
        simpleDraweeView2.setOnClickListener(this.M1);
        textView.setOnClickListener(this.M1);
        textView2.setOnClickListener(this.M1);
        this.n1.addView(this.Z0, layoutParams);
        this.Z0.setVisibility(4);
    }

    public final void v4() {
        String N;
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
                N = N(R.string.obfuscated_res_0x7f0f1366);
            } else {
                N = N(R.string.obfuscated_res_0x7f0f136f);
            }
            this.d1 = N;
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

    @Override // com.baidu.tieba.i72, com.baidu.swan.support.v4.app.Fragment
    public void w0(Bundle bundle) {
        boolean z;
        super.w0(bundle);
        v4();
        this.Q0 = new ex3(getContext(), this.j1);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (1 == activity.getRequestedOrientation()) {
                z = true;
            } else {
                z = false;
            }
            this.m1 = z;
            if (!z) {
                K2(1);
            }
        }
        if (N1) {
            Log.d("SwanAppAdLandFragment", "onCreate() : " + this);
        }
    }

    @Override // com.baidu.tieba.i72, com.baidu.swan.support.v4.app.Fragment
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00e0, viewGroup, false);
        X1(inflate);
        this.p1 = (ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f09219a);
        this.R0 = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0901af);
        o4();
        q4();
        i4(this.n1);
        p4();
        if (t4()) {
            n4();
            m4();
        }
        if (W1()) {
            inflate = Z1(inflate);
        }
        A4("lpin");
        return G1(inflate, this);
    }
}
