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
import com.baidu.tieba.b73;
import com.baidu.tieba.bk3;
import com.baidu.tieba.c63;
import com.baidu.tieba.cv2;
import com.baidu.tieba.dv2;
import com.baidu.tieba.ek3;
import com.baidu.tieba.gt1;
import com.baidu.tieba.ht1;
import com.baidu.tieba.ij3;
import com.baidu.tieba.it1;
import com.baidu.tieba.jt1;
import com.baidu.tieba.jv3;
import com.baidu.tieba.k63;
import com.baidu.tieba.kv3;
import com.baidu.tieba.kw2;
import com.baidu.tieba.lu3;
import com.baidu.tieba.n53;
import com.baidu.tieba.o53;
import com.baidu.tieba.qq2;
import com.baidu.tieba.qu3;
import com.baidu.tieba.rp2;
import com.baidu.tieba.sl3;
import com.baidu.tieba.su3;
import com.baidu.tieba.tu3;
import com.baidu.tieba.us1;
import com.baidu.tieba.uv3;
import com.baidu.tieba.v72;
import com.baidu.tieba.vm1;
import com.baidu.tieba.vu3;
import com.baidu.tieba.x72;
import com.baidu.tieba.y42;
import com.baidu.tieba.y52;
import com.baidu.tieba.y72;
import com.baidu.tieba.ye3;
import com.baidu.tieba.z63;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class SwanAppAdLandingFragment extends y52 implements vu3 {
    public static final boolean N1 = vm1.a;
    public int A1;
    public String B1;
    public jt1 C1;
    public String D1;
    public String E1;
    public TextView F1;
    public String G1;
    public View I1;
    public String J1;
    public String K1;
    public String N0;
    public cv2 P0;
    public uv3 Q0;
    public FrameLayout R0;
    public qu3 V0;
    public lu3 W0;
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
    public o53 H1 = null;
    public tu3 L1 = null;
    public View.OnClickListener M1 = new o();

    /* loaded from: classes4.dex */
    public enum LandingType {
        NORMAL,
        VIDEO
    }

    @Override // com.baidu.tieba.y52, com.baidu.tieba.q52
    public boolean i2() {
        return true;
    }

    /* loaded from: classes4.dex */
    public class a extends v72 {

        /* renamed from: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0198a implements Runnable {
            public final /* synthetic */ String a;

            public RunnableC0198a(String str) {
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

        @Override // com.baidu.tieba.v72, com.baidu.tieba.y72
        public void d(String str) {
            SwanAppAdLandingFragment swanAppAdLandingFragment = SwanAppAdLandingFragment.this;
            swanAppAdLandingFragment.g4(swanAppAdLandingFragment.H0.canGoBack());
            SwanAppAdLandingFragment.this.f0.post(new RunnableC0198a(str));
        }

        @Override // com.baidu.tieba.v72, com.baidu.tieba.y72
        public void e(String str) {
            super.e(str);
            if (!TextUtils.isEmpty(SwanAppAdLandingFragment.this.g1) && SwanAppAdLandingFragment.this.Q0 != null) {
                SwanAppAdLandingFragment.this.Q0.e(SwanAppAdLandingFragment.this.g1);
            }
        }

        @Override // com.baidu.tieba.v72, com.baidu.tieba.y72
        public boolean a(String str) {
            if (b73.e(str) || b73.f(str)) {
                try {
                    Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(str));
                    k63 c0 = k63.c0();
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

        @Override // com.baidu.tieba.v72, com.baidu.tieba.y72
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
            y52.f3();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c63 g = c63.g(SwanAppAdLandingFragment.this.z(), "第三方页面应用未经百度审核");
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
            y52.k3("adLanding", kw2.d(SwanAppAdLandingFragment.this.K1, SwanAppAdLandingFragment.this.K1));
            SwanAppAdLandingFragment.this.H1.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            y52.k3("adLanding", kw2.d(SwanAppAdLandingFragment.this.J1, SwanAppAdLandingFragment.this.J1));
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
    public class h implements dv2 {
        @Override // com.baidu.tieba.dv2
        public void e(qq2 qq2Var) {
        }

        @Override // com.baidu.tieba.dv2
        public boolean f(qq2 qq2Var, int i, int i2) {
            return false;
        }

        public h() {
        }

        @Override // com.baidu.tieba.dv2
        public void a(qq2 qq2Var) {
            SwanAppAdLandingFragment.this.E4("vcontinueplay");
        }

        @Override // com.baidu.tieba.dv2
        public void b(qq2 qq2Var) {
            SwanAppAdLandingFragment.this.Z0.bringToFront();
            SwanAppAdLandingFragment.this.Z0.setVisibility(0);
            SwanAppAdLandingFragment.this.k1 = 0;
            SwanAppAdLandingFragment.B3(SwanAppAdLandingFragment.this);
            SwanAppAdLandingFragment.this.E4("vplayend");
            SwanAppAdLandingFragment.this.E4("scard");
        }

        @Override // com.baidu.tieba.dv2
        public void c(qq2 qq2Var) {
            SwanAppAdLandingFragment.this.E4("vpause");
        }

        @Override // com.baidu.tieba.dv2
        public void d(qq2 qq2Var) {
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
    public class j implements lu3 {
        public j() {
        }

        @Override // com.baidu.tieba.lu3
        public void a(int i) {
            SwanAppAdLandingFragment.this.V0.d(i);
        }

        @Override // com.baidu.tieba.lu3
        public void d(String str) {
            SwanAppAdLandingFragment.this.B4(str);
        }

        @Override // com.baidu.tieba.lu3
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

        @Override // com.baidu.tieba.lu3
        public void b() {
            SwanAppAdLandingFragment.this.E4("appinstallbegin");
        }

        @Override // com.baidu.tieba.lu3
        public String e() {
            SwanAppAdLandingFragment.this.E4("appinstallopen");
            SwanAppAdLandingFragment swanAppAdLandingFragment = SwanAppAdLandingFragment.this;
            return swanAppAdLandingFragment.h4(swanAppAdLandingFragment.X0.a);
        }

        @Override // com.baidu.tieba.lu3
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
    public class l implements x72 {
        public final /* synthetic */ CustomerAdScrollView a;

        public l(CustomerAdScrollView customerAdScrollView) {
            this.a = customerAdScrollView;
        }

        @Override // com.baidu.tieba.x72
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
    public class m extends y42 {
        public final /* synthetic */ CustomerAdScrollView a;

        public m(CustomerAdScrollView customerAdScrollView) {
            this.a = customerAdScrollView;
        }

        @Override // com.baidu.tieba.y42
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
    public class n implements it1 {
        public final /* synthetic */ CustomerAdScrollView a;

        public n(CustomerAdScrollView customerAdScrollView) {
            this.a = customerAdScrollView;
        }

        @Override // com.baidu.tieba.it1
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
            if (id == R.id.obfuscated_res_0x7f090123) {
                hashMap.put("da_area", "tail_icon");
            } else if (id == R.id.obfuscated_res_0x7f090120) {
                hashMap.put("da_area", "tail_name");
            } else if (id == R.id.obfuscated_res_0x7f090121) {
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
            y52.k3("adLanding", kw2.d(SwanAppAdLandingFragment.this.N0, SwanAppAdLandingFragment.this.N0));
        }
    }

    public final void A4() {
        cv2 cv2Var = this.P0;
        if (cv2Var != null && cv2Var.n()) {
            this.P0.p();
        }
    }

    @Override // com.baidu.tieba.y52, com.baidu.swan.support.v4.app.Fragment
    public void C0() {
        if (x4()) {
            E4("vplayend");
        }
        cv2 cv2Var = this.P0;
        if (cv2Var != null) {
            cv2Var.onDestroy();
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
        cv2 cv2Var = this.P0;
        if (cv2Var != null && !cv2Var.n() && !this.P0.m()) {
            this.P0.s();
        }
    }

    public final void F4() {
        C4();
        this.n1.addView(this.F1);
        this.n1.addView(this.V0.getRealView());
    }

    @Override // com.baidu.tieba.y52, com.baidu.tieba.q52
    public boolean G() {
        cv2 cv2Var;
        if (w4() && (cv2Var = this.P0) != null) {
            return cv2Var.onBackPressed();
        }
        E4("lpout");
        return super.G();
    }

    @Override // com.baidu.tieba.y52
    public y72 g3() {
        return new a();
    }

    @Override // com.baidu.tieba.y52
    public us1 j() {
        ht1 ht1Var = new ht1(z());
        ht1Var.getWebView().setDownloadListener(new ISailorDownloadListener() { // from class: com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment.9
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
        return ht1Var;
    }

    public final void k4() {
        ek3.e0(new c());
    }

    @Override // com.baidu.tieba.q52, com.baidu.swan.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        A4();
    }

    @Override // com.baidu.tieba.q52, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        jt1 jt1Var = this.C1;
        if (jt1Var != null && jt1Var.l() && !p0()) {
            D4();
        }
    }

    public final void u4() {
        int i2;
        jt1 jt1Var = new jt1(z());
        this.C1 = jt1Var;
        if (x4()) {
            i2 = this.a1;
        } else {
            i2 = 0;
        }
        jt1Var.o(i2);
        WebViewContainer k2 = this.C1.k();
        this.n1 = k2;
        this.p1.addView(k2);
    }

    public final boolean v4() {
        return TextUtils.equals("swan-custom-ad", this.S0);
    }

    public final boolean w4() {
        if (n().getResources().getConfiguration().orientation == 2) {
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
        tu3 tu3Var = this.L1;
        if (tu3Var != null) {
            h(tu3Var);
            return;
        }
        jv3 jv3Var = new jv3(z());
        jv3Var.d(this);
        kv3 kv3Var = new kv3(z());
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
        jv3Var.c(kv3Var, jSONObject);
    }

    public final void s4() {
        int i2;
        DisplayMetrics displayMetrics = n().getResources().getDisplayMetrics();
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
            ye3.a().putString(this.X0.a, str);
        }
    }

    public final void E4(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        cv2 cv2Var = this.P0;
        if (cv2Var != null) {
            hashMap.put("cur_time", String.valueOf(cv2Var.e() / 1000));
        }
        uv3 uv3Var = this.Q0;
        if (uv3Var != null) {
            uv3Var.d(str, hashMap);
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

    @Override // com.baidu.tieba.y52, com.baidu.tieba.q52
    public void a2(View view2) {
        super.a2(view2);
        this.f0.setLeftHomeViewSrc(R.drawable.obfuscated_res_0x7f080129);
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
        return ye3.a().getString(str, "");
    }

    public final void m4(ViewGroup viewGroup) {
        this.W0 = new j();
        this.X0 = new DownloadParams(this.T0, this.U0);
        su3 su3Var = new su3();
        su3Var.l(z(), this.X0, this.W0);
        this.V0 = su3Var;
        su3Var.e(this.X0);
        n4();
    }

    public final boolean y4(View view2) {
        if (view2 != null && view2.getVisibility() == 0) {
            return view2.getGlobalVisibleRect(new Rect());
        }
        return false;
    }

    @Override // com.baidu.tieba.y52, com.baidu.swan.support.v4.app.Fragment
    public View A0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00e7, viewGroup, false);
        a2(inflate);
        this.p1 = (ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f09241f);
        this.R0 = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0901e2);
        s4();
        u4();
        m4(this.n1);
        t4();
        if (x4()) {
            r4();
            q4();
        }
        if (Z1()) {
            inflate = c2(inflate);
        }
        E4("lpin");
        return I1(inflate, this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.baidu.tieba.vu3
    public void h(tu3 tu3Var) {
        char c2;
        this.L1 = tu3Var;
        String f2 = tu3Var.f();
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
                l4(tu3Var, false);
                return;
            }
            l4(tu3Var, true);
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
        if (ek3.F(z(), this.X0.b)) {
            F4();
            this.V0.b(DownloadState.INSTALLED);
            return;
        }
        if (TextUtils.isEmpty(this.X0.a)) {
            this.X0.a = this.D1;
        }
        rp2.d().d(z(), this.X0.a(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, this.W0);
    }

    public final void l4(tu3 tu3Var, boolean z) {
        float f2;
        o53 o53Var = this.H1;
        if (o53Var != null) {
            o53Var.show();
            return;
        }
        ((ViewGroup) this.I1.findViewById(R.id.obfuscated_res_0x7f0900f2)).addView(this.V0.getRealView());
        ((AdImageVIew) this.I1.findViewById(R.id.obfuscated_res_0x7f0900f4)).setImageUrl(tu3Var.g());
        ((TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0900f1)).setText(tu3Var.c());
        ((TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0900f9)).setText(tu3Var.d());
        ((TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0900f0)).setText(tu3Var.a());
        ((TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0900fb)).setText(tu3Var.j());
        TextView textView = (TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0900f3);
        if (!z) {
            textView.setText(tu3Var.e());
            textView.setVisibility(0);
        }
        this.J1 = tu3Var.h();
        this.K1 = tu3Var.i();
        ViewGroup.LayoutParams layoutParams = this.V0.getRealView().getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
            this.V0.getRealView().setLayoutParams(layoutParams);
        }
        int o2 = bk3.o(z());
        float l2 = bk3.l(z());
        layoutParams.width = o2 - (((int) ((10.0f * l2) + 0.5f)) * 2);
        if (TextUtils.isEmpty(this.X0.b)) {
            String h4 = h4(tu3Var.b());
            this.X0.b = h4;
            this.V0.a(h4);
        }
        if (ek3.F(z(), this.X0.b)) {
            this.V0.b(DownloadState.INSTALLED);
        }
        if (TextUtils.isEmpty(this.X0.a)) {
            this.X0.a = tu3Var.b();
        }
        this.V0.e(this.X0);
        n53 n53Var = new n53(z());
        n53Var.i(true);
        n53Var.k(false);
        n53Var.T(false);
        n53Var.m(false);
        n53Var.t(false);
        n53Var.n(new sl3());
        n53Var.p(R.drawable.obfuscated_res_0x7f080145);
        n53Var.F(R.color.obfuscated_res_0x7f060abe);
        n53Var.K(new g());
        n53Var.W(this.I1);
        n53Var.j();
        if (z) {
            f2 = 225.0f;
        } else {
            f2 = 250.0f;
        }
        n53Var.q((int) (l2 * f2));
        o53 c2 = n53Var.c();
        this.H1 = c2;
        Window window = c2.getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setDimAmount(0.65f);
            window.setLayout(bk3.s(z()), -2);
            window.setWindowAnimations(R.style.obfuscated_res_0x7f1003b3);
        }
        this.H1.a(false);
        this.H1.setCanceledOnTouchOutside(true);
        this.H1.show();
    }

    public final void n4() {
        View inflate = View.inflate(z(), R.layout.obfuscated_res_0x7f0d009d, null);
        this.I1 = inflate;
        ((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0900f8)).setOnClickListener(new d());
        ((TextView) this.I1.findViewById(R.id.obfuscated_res_0x7f0900f7)).setOnClickListener(new e());
        ((ImageView) this.I1.findViewById(R.id.obfuscated_res_0x7f09077a)).setOnClickListener(new f());
        TextView textView = new TextView(z());
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
        layoutParams.bottomMargin = ((int) (z().getResources().getDisplayMetrics().heightPixels * 0.14d)) - 80;
        this.F1.setLayoutParams(layoutParams);
        this.F1.setGravity(81);
    }

    public final void o4(ViewGroup viewGroup, ViewGroup viewGroup2) {
        this.o1 = (LinearLayout) ((LinearLayout) LayoutInflater.from(z()).inflate(R.layout.obfuscated_res_0x7f0d095b, (ViewGroup) null)).findViewById(R.id.obfuscated_res_0x7f0900c6);
        CustomerAdScrollView customerAdScrollView = new CustomerAdScrollView(z());
        LinearLayout linearLayout = new LinearLayout(z());
        linearLayout.setOrientation(1);
        linearLayout.addView(viewGroup2, new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(this.o1, new LinearLayout.LayoutParams(-1, z().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07083c)));
        customerAdScrollView.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        viewGroup.addView(customerAdScrollView);
        this.G0.r(new l(customerAdScrollView));
        this.G0.b(new m(customerAdScrollView));
        customerAdScrollView.setScrollViewListener(new n(customerAdScrollView));
    }

    public final void p4() {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(z()).inflate(R.layout.obfuscated_res_0x7f0d095c, (ViewGroup) null);
        this.n1.addView(relativeLayout, new FrameLayout.LayoutParams(-1, this.z1));
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0900ef);
        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0900fc);
        this.x1 = (FrameLayout) relativeLayout.findViewById(R.id.obfuscated_res_0x7f0900fd);
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
        gt1 gt1Var = new gt1(this.h1, this.i1, this.G0.a(), i2, i3, this.k1, this.q1.booleanValue());
        cv2 cv2Var = new cv2(z(), gt1Var.a());
        this.P0 = cv2Var;
        this.C1.p(cv2Var);
        this.P0.v(new h());
        if (this.q1.booleanValue()) {
            this.P0.x(this.x1);
        }
        this.P0.o(gt1Var.a());
        this.P0.w(false);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.baidu.tieba.ss1] */
    public final void t4() {
        int i2;
        us1 j2 = j();
        this.G0 = j2;
        j2.V(g3());
        this.H0 = this.G0.getWebView();
        this.G0.loadUrl(this.N0);
        FrameLayout frameLayout = new FrameLayout(z());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        View covertToView = this.H0.covertToView();
        z63 z63Var = new z63();
        z63Var.e = SwanAppConfigData.t("#FFFFFF");
        this.G0.x(frameLayout, z63Var);
        this.G0.M(frameLayout, z63Var);
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
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(z()).inflate(R.layout.obfuscated_res_0x7f0d095d, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        if (this.q1.booleanValue()) {
            i2 = this.z1;
        } else {
            i2 = this.a1;
        }
        layoutParams.height = i2;
        this.Z0 = (RelativeLayout) relativeLayout.findViewById(R.id.obfuscated_res_0x7f090124);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f090125);
        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f090123);
        TextView textView = (TextView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f090120);
        TextView textView2 = (TextView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f090121);
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
        simpleDraweeView.getHierarchy().setPlaceholderImage(L().getDrawable(R.drawable.obfuscated_res_0x7f081499));
        if (this.q1.booleanValue()) {
            str = this.B1;
        } else {
            str = this.h1;
        }
        if (!TextUtils.isEmpty(str)) {
            simpleDraweeView.setImageURI(ij3.m(str));
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
        String X;
        Bundle r = r();
        if (r == null) {
            return;
        }
        this.N0 = r.getString("url", "");
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
                X = X(R.string.obfuscated_res_0x7f0f1541);
            } else {
                X = X(R.string.obfuscated_res_0x7f0f154a);
            }
            this.d1 = X;
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

    @Override // com.baidu.tieba.y52, com.baidu.swan.support.v4.app.Fragment
    public void x0(Bundle bundle) {
        boolean z;
        super.x0(bundle);
        z4();
        this.Q0 = new uv3(z(), this.j1);
        FragmentActivity n2 = n();
        if (n2 != null) {
            if (1 == n2.getRequestedOrientation()) {
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
