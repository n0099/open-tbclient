package com.baidu.platform.comapi.walknavi.g;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.mapapi.walknavi.model.RouteGuideKind;
import com.baidu.mapapi.walknavi.model.WalkNaviDisplayOption;
import com.baidu.platform.comapi.walknavi.segmentbrowse.widget.TestLinearLayout;
import com.baidu.platform.comapi.walknavi.segmentbrowse.widget.TestScaleView;
import com.baidu.platform.comapi.wnplatform.h.e;
import com.baidu.platform.comapi.wnplatform.o.f;
import com.baidu.tieba.R;
import java.math.BigDecimal;
/* loaded from: classes8.dex */
public class a extends com.baidu.platform.comapi.wnplatform.n.a {
    private LinearLayout A;
    private TextView B;
    private TextView C;
    private TextView D;
    private TestScaleView E;
    private View F;
    private com.baidu.platform.comapi.walknavi.widget.d G;
    private TextView H;
    private float I;
    private double J;
    private int O;
    private int P;
    private RelativeLayout U;
    private RelativeLayout V;
    private RelativeLayout W;
    private TextView X;
    private TextView Y;
    private ImageView Z;
    private ImageView aa;
    private View ac;
    private AnimationDrawable ad;
    Point d;
    LatLng e;
    LatLng f;
    private Activity i;
    private View j;
    private com.baidu.platform.comapi.walknavi.g.b.c k;
    private com.baidu.platform.comapi.walknavi.widget.a l;
    private com.baidu.platform.comapi.walknavi.widget.a m;
    private FrameLayout r;
    private com.baidu.platform.comapi.walknavi.segmentbrowse.widget.g s;
    private com.baidu.platform.comapi.walknavi.segmentbrowse.widget.h t;
    private com.baidu.platform.comapi.walknavi.segmentbrowse.widget.i u;
    private TestLinearLayout x;
    private TestLinearLayout y;
    private com.baidu.platform.comapi.walknavi.g.b.a n = null;
    private Handler o = new Handler();
    private boolean p = true;
    private CountDownTimerC0191a q = null;
    private int v = 0;
    private boolean w = false;
    private boolean z = false;
    public Bitmap a = null;
    public Bitmap b = null;
    public Bitmap c = null;
    private Bitmap K = BitmapFactory.decodeResource(com.baidu.platform.comapi.wnplatform.o.a.a.b(), R.drawable.abc_scrubber_primary_mtrl_alpha);
    private BitmapDescriptor L = BitmapDescriptorFactory.fromBitmap(this.K);
    private Bitmap M = BitmapFactory.decodeResource(com.baidu.platform.comapi.wnplatform.o.a.a.b(), R.drawable.abc_scrubber_control_to_pressed_mtrl_005);
    private BitmapDescriptor N = BitmapDescriptorFactory.fromBitmap(this.M);
    private Handler Q = new com.baidu.platform.comapi.walknavi.g.b(this);
    private Runnable R = new m(this);
    private Runnable S = new o(this);
    private Runnable T = new p(this);
    private String ab = "";
    final Runnable g = new f(this);
    private Runnable ae = new j(this);
    private int af = -1;
    final Runnable h = new l(this);
    private com.baidu.platform.comapi.wnplatform.walkmap.c ag = new n(this);

    /* loaded from: classes8.dex */
    public interface b {
        void a(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Point A() {
        if (this.d == null) {
            this.d = com.baidu.platform.comapi.walknavi.b.a().L();
        }
        return this.d;
    }

    private LatLng B() {
        if (this.f == null) {
            this.f = com.baidu.platform.comapi.walknavi.b.a().N();
        }
        return this.f;
    }

    private LatLng C() {
        if (this.e == null) {
            this.e = com.baidu.platform.comapi.walknavi.b.a().M();
        }
        return this.e;
    }

    public com.baidu.platform.comapi.walknavi.g.b.c k() {
        return this.k;
    }

    public a(Activity activity) {
        this.j = null;
        this.i = activity;
        this.j = com.baidu.platform.comapi.wnplatform.o.a.a.a(activity, R.layout.abc_activity_chooser_view_list_item, null);
        K();
        E();
    }

    private void D() {
        int b2 = com.baidu.platform.comapi.walknavi.b.a().D().b();
        com.baidu.platform.comapi.wnplatform.d.a.a("tag", "traffic size:" + b2);
        if (b2 != 0) {
            int[] iArr = new int[b2];
            int[] iArr2 = new int[b2];
            int[] iArr3 = new int[b2];
            com.baidu.platform.comapi.walknavi.b.a().D().a(iArr, iArr2, iArr3);
            com.baidu.platform.comapi.wnplatform.g.a.b().a(this.i, iArr, iArr2, iArr3);
        }
    }

    public void e(int i) {
        if (i == 1) {
            com.baidu.platform.comapi.walknavi.b.a().G().a().showScaleControl(true);
            com.baidu.platform.comapi.walknavi.b.a().G().a().showZoomControls(false);
            com.baidu.platform.comapi.walknavi.b.a().G().a().getMap().getUiSettings().setAllGesturesEnabled(true);
            a(this.i, com.baidu.platform.comapi.walknavi.b.a().G().a(), 70, 0, 0, 60);
        } else if (i == 2) {
            com.baidu.platform.comapi.walknavi.b.a().G().a().showScaleControl(false);
            com.baidu.platform.comapi.walknavi.b.a().G().a().showZoomControls(false);
            com.baidu.platform.comapi.walknavi.b.a().G().a().getMap().getUiSettings().setAllGesturesEnabled(false);
            a(this.i, com.baidu.platform.comapi.walknavi.b.a().G().a(), 0, 0, 0, 0);
        }
    }

    public void a(int i, boolean z) {
        e(i);
        if (i == 2) {
            com.baidu.platform.comapi.walknavi.b.a().H().b("WALKNAVI_FIRST_AR", false);
            if (!com.baidu.platform.comapi.walknavi.b.a().H().a("WALKNAVI_AR_HINT_HAS_SHOW", false)) {
                this.Q.postDelayed(this.T, 10000L);
            }
            if (!com.baidu.platform.comapi.walknavi.b.a().H().a("WALKNAVI_AR_ADJUST_HAS_SHOW", false)) {
                this.Q.postDelayed(this.S, 30000L);
            }
            b(i, z);
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE);
            com.baidu.platform.comapi.walknavi.b.a().D().j();
            this.Q.postDelayed(new q(this), 500L);
        } else if (i == 1) {
            this.Q.removeCallbacks(this.T);
            this.Q.removeCallbacks(this.S);
            b(i, z);
        }
    }

    private void b(int i, boolean z) {
        if (this.r != null) {
            if (i == 2) {
                this.r.setBackgroundColor(Color.parseColor("#cc061835"));
                this.G.a(Color.parseColor("#cc061835"));
                this.G.b(-1);
            } else {
                this.r.setBackgroundColor(Color.parseColor("#ffffffff"));
                this.G.a(Color.parseColor("#ffffffff"));
                this.G.b(ViewCompat.MEASURED_STATE_MASK);
            }
        }
        if (this.x != null) {
            if (i == 2) {
                this.x.setVisibility(8);
            } else {
                this.x.setVisibility(0);
            }
        }
        if (this.y != null) {
            if (i == 2) {
                this.y.setVisibility(0);
            } else {
                this.y.setVisibility(8);
            }
        }
        if (this.F != null) {
            if (i == 2) {
                this.F.setVisibility(8);
            } else {
                this.F.setVisibility(0);
            }
        }
        if (this.U != null) {
            if (i == 2) {
                this.U.setVisibility(0);
            } else {
                this.U.setVisibility(8);
            }
        }
        if (i == 2) {
            com.baidu.platform.comapi.walknavi.b.a().A();
        } else {
            com.baidu.platform.comapi.walknavi.b.a().z();
        }
        if (this.E != null) {
            this.E.refresh();
        }
        if (this.k != null) {
            this.k.a(i, z);
        }
        f(i);
    }

    private void f(int i) {
        if (i == 2) {
            this.A.setBackgroundColor(Color.parseColor("#cc061835"));
            this.C.setTextColor(-1);
            this.D.setTextColor(-1);
            this.B.setTextColor(-1);
        } else if (i == 1) {
            this.A.setBackgroundColor(-1);
            this.C.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            this.D.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            this.B.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
    }

    private void E() {
        int a = com.baidu.platform.comapi.walknavi.b.a().D().a();
        com.baidu.platform.comapi.wnplatform.d.a.a("tag", "all size:" + a);
        if (a > 2) {
            int[] iArr = new int[a - 2];
            int[] iArr2 = new int[a - 2];
            int[] iArr3 = new int[a - 2];
            com.baidu.platform.comapi.walknavi.b.a().D().b(iArr, iArr2, iArr3);
            com.baidu.platform.comapi.wnplatform.g.c.b().a(this.i, iArr, iArr2, iArr3);
        }
    }

    private void F() {
        if (this.a != null && !this.a.isRecycled()) {
            this.a.recycle();
            this.a = null;
        }
        if (this.b != null && !this.b.isRecycled()) {
            this.b.recycle();
            this.b = null;
        }
        if (this.c != null && !this.c.isRecycled()) {
            this.c.recycle();
            this.c = null;
        }
    }

    private void G() {
        if (this.K != null && !this.K.isRecycled()) {
            this.K.recycle();
            this.K = null;
        }
        if (this.M != null && !this.M.isRecycled()) {
            this.M.recycle();
            this.M = null;
        }
        if (this.L != null) {
            this.L.recycle();
            this.L = null;
        }
        if (this.N != null) {
            this.N.recycle();
            this.N = null;
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a, com.baidu.platform.comapi.walknavi.a
    public void release() {
        P();
        if (this.o != null) {
            this.o.removeCallbacks(this.g);
            this.o = null;
        }
        if (this.k != null) {
            this.k.g();
        }
        this.n = null;
        F();
        G();
        this.H = null;
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a, com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        O();
        return true;
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public boolean c() {
        return this.j == null || this.i == null;
    }

    private void H() {
        this.U = (RelativeLayout) this.j.findViewById(2131165297);
        this.U.setVisibility(0);
        this.U.setOnClickListener(new r(this));
        this.V = (RelativeLayout) this.j.findViewById(R.raw.ala_live2);
        this.X = (TextView) this.j.findViewById(R.raw.bottom_bar_bg_1);
        this.Y = (TextView) this.j.findViewById(R.raw.hconfig);
        this.W = (RelativeLayout) this.j.findViewById(R.raw.icon_refresh1);
        this.Z = (ImageView) this.j.findViewById(R.raw.icon_refresh1_1);
        this.aa = (ImageView) this.j.findViewById(R.raw.icon_refresh2_1);
    }

    public void m() {
        this.V.setVisibility(0);
        this.W.setVisibility(8);
        this.Z.setVisibility(8);
        this.aa.setVisibility(8);
    }

    public void a(boolean z, boolean z2, boolean z3, boolean z4) {
        this.V.setVisibility(8);
        this.W.setVisibility(0);
        if (z) {
            this.Z.setVisibility(0);
            this.aa.setVisibility(8);
        }
        if (z2) {
            this.aa.setVisibility(0);
            this.Z.setVisibility(8);
        }
    }

    private int I() {
        return (this.O - com.baidu.platform.comapi.wnplatform.o.g.a(this.i, 40)) + 0;
    }

    public int p() {
        return com.baidu.platform.comapi.wnplatform.o.g.a(this.i, 32);
    }

    public void a(float f, float f2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5 = true;
        boolean z6 = false;
        if (this.U != null) {
            if (com.baidu.platform.comapi.walknavi.b.a().u() == 2) {
                if (f == 0.0f && f2 == 0.0f) {
                    this.U.setVisibility(8);
                } else {
                    this.U.setVisibility(0);
                }
                if (f < 0.0f) {
                    z = false;
                    z2 = true;
                    z3 = false;
                    f = 0.0f;
                } else if (f >= 0.0f && f < I()) {
                    z = false;
                    z2 = false;
                    z3 = true;
                } else if (f >= I()) {
                    f = I();
                    z = true;
                    z2 = false;
                    z3 = false;
                } else {
                    z = false;
                    z2 = false;
                    z3 = true;
                }
                if (f2 < p()) {
                    f2 = p();
                    z4 = false;
                } else if (f2 >= 0.0f && f2 < this.P) {
                    z4 = true;
                    z5 = false;
                } else if (f2 > this.P) {
                    f2 = this.P;
                    z4 = false;
                    z6 = true;
                    z5 = false;
                } else {
                    z4 = true;
                    z5 = false;
                }
                if (z3 && z4) {
                    m();
                } else {
                    a(z2, z, z5, z6);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.U.getLayoutParams();
                layoutParams.leftMargin = (int) f;
                layoutParams.topMargin = (int) f2;
                this.U.setLayoutParams(layoutParams);
                return;
            }
            this.U.setVisibility(8);
        }
    }

    public void s() {
        if (this.ac != null) {
            this.ac.setVisibility(0);
        }
        if (this.ad != null) {
            this.ad.start();
        }
    }

    public void u() {
        if (this.ac != null) {
            this.ac.setVisibility(8);
        }
        if (this.ad != null) {
            this.ad.stop();
        }
    }

    private void J() {
        this.ac = this.j.findViewById(2131165299);
        this.ac.setVisibility(8);
        this.ac.setOnClickListener(new s(this));
        ((ImageView) this.j.findViewById(2131165302)).setOnClickListener(new t(this));
        this.ad = (AnimationDrawable) ((ImageView) this.j.findViewById(2131165300)).getBackground();
    }

    private void K() {
        J();
        H();
        com.baidu.platform.comapi.walknavi.b.a().G().a().getMap().addOverlay(new MarkerOptions().position(C()).icon(this.L).zIndex(9).draggable(false));
        com.baidu.platform.comapi.walknavi.b.a().G().a().getMap().addOverlay(new MarkerOptions().position(B()).icon(this.N).zIndex(9).draggable(false));
        this.F = this.j.findViewById(R.raw.sapi_camera_too_near);
        this.k = new com.baidu.platform.comapi.walknavi.g.b.c(this.i, this, this.j);
        this.k.h().setOnClickListener(new u(this));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.i.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.a = displayMetrics.widthPixels;
        com.baidu.platform.comapi.wnplatform.d.a.a("walk engine", "screen width" + com.baidu.platform.comapi.walknavi.segmentbrowse.c.a);
        c cVar = new c(this);
        if (cVar != null) {
            this.k.a(cVar);
        }
        this.G = new com.baidu.platform.comapi.walknavi.widget.d(this.i, this, this.j);
        this.r = (FrameLayout) this.j.findViewById(R.raw.sapi_camera_nod);
        this.x = (TestLinearLayout) this.j.findViewById(R.raw.sapi_camera_open_mouth);
        this.y = (TestLinearLayout) this.j.findViewById(R.raw.sapi_camera_photo_done);
        this.A = (LinearLayout) this.j.findViewById(R.raw.rim_video_lrc_tip);
        this.B = (TextView) this.j.findViewById(R.raw.rim_video_put_face_round);
        this.C = (TextView) this.j.findViewById(R.raw.rim_video_too_far);
        this.D = (TextView) this.j.findViewById(R.raw.rim_video_too_near);
        this.E = (TestScaleView) this.j.findViewById(R.raw.sapi_camera_blink);
        Bundle U = com.baidu.platform.comapi.walknavi.b.a().U();
        if (U != null) {
            this.C.setText(U.getString("distance"));
            this.D.setText(U.getString("time"));
        }
        if (com.baidu.platform.comapi.walknavi.b.a().J() == 4) {
            this.A.setVisibility(8);
            this.B.setText("全程");
        } else {
            this.A.setVisibility(8);
            this.E.setVisibility(0);
        }
        com.baidu.platform.comapi.walknavi.segmentbrowse.widget.e.a(com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(this.i));
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public int n() {
        if (this.r == null || this.A == null) {
            return 50;
        }
        return this.r.getHeight() + this.A.getHeight();
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public View h() {
        return this.j;
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void d() {
        this.p = false;
        if (com.baidu.platform.comapi.walknavi.b.a().J() != 4) {
            L();
        }
        if (this.k != null) {
            this.k.d();
            this.k.c();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void e() {
        this.p = true;
    }

    public void a(boolean z, int i) {
        String b2;
        System.out.println("WalkUIController showQuitDialog");
        try {
            if (this.i == null || this.i.isFinishing()) {
                com.baidu.platform.comapi.wnplatform.k.a.a().a("FootNaviPG.exitNavi");
                v();
                return;
            }
            com.baidu.platform.comapi.walknavi.widget.a b3 = new com.baidu.platform.comapi.walknavi.widget.a(this.i).a(true).b(com.baidu.platform.comapi.wnplatform.o.a.a.b(this.i, R.string.abc_activity_chooser_view_see_all));
            if (com.baidu.platform.comapi.walknavi.g.a.b.a == 2) {
                b2 = com.baidu.platform.comapi.wnplatform.o.a.a.b(this.i, R.string.abc_action_mode_done);
            } else {
                b2 = com.baidu.platform.comapi.wnplatform.o.a.a.b(this.i, i);
            }
            this.l = b3.a(b2).d(com.baidu.platform.comapi.wnplatform.o.a.a.b(this.i, R.string.abc_action_bar_home_description)).b().b(new e(this)).c(com.baidu.platform.comapi.wnplatform.o.a.a.b(this.i, R.string.abc_activitychooserview_choose_application)).a(new d(this));
            if (z) {
                this.q = new CountDownTimerC0191a(7000L, 1000L, this.i, this.l);
                this.q.start();
            }
            if (!this.l.isShowing() && this.i != null && !this.i.isFinishing()) {
                this.l.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void q() {
        WalkNaviDisplayOption l;
        if (this.k != null) {
            this.k.j();
        }
        if (this.Q != null && this.R != null) {
            this.Q.removeCallbacks(this.R);
        }
        if (this.l != null && this.l.isShowing() && this.i != null && !this.i.isFinishing()) {
            this.l.dismiss();
        }
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.r();
        v();
        if (this.j != null) {
            ViewParent parent = this.j.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeAllViews();
            }
            this.j = null;
        }
        if (this.i != null && !this.i.isFinishing() && ((l = com.baidu.platform.comapi.walknavi.b.a().l()) == null || !l.isIsRunInFragment())) {
            this.i.finish();
        }
        com.baidu.platform.comapi.walknavi.b.a().m();
        this.i = null;
    }

    public void v() {
        if (this.n != null) {
            this.n.y();
        }
    }

    private void L() {
        if (!this.p) {
            if (!com.baidu.platform.comapi.walknavi.b.a().P().c()) {
                M();
            } else {
                N();
            }
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void i() {
        Q();
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void l() {
        if (this.k != null) {
            this.k.e();
        }
        if (this.o != null && this.g != null) {
            this.o.removeCallbacks(this.g);
            this.o.postDelayed(this.g, 20000L);
        }
    }

    public void w() {
        if (this.o != null && this.g != null) {
            this.o.removeCallbacks(this.g);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void a(com.baidu.platform.comapi.walknavi.g.b.a aVar) {
        this.n = aVar;
    }

    private void M() {
        if (this.i != null) {
            try {
                if (this.m == null) {
                    this.m = new com.baidu.platform.comapi.walknavi.widget.a(this.i).b(com.baidu.platform.comapi.wnplatform.o.a.a.b(this.i, R.string.abc_activity_chooser_view_see_all)).a(com.baidu.platform.comapi.wnplatform.o.a.a.b(this.i, R.string.abc_capital_off)).c(com.baidu.platform.comapi.wnplatform.o.a.a.b(this.i, R.string.abc_capital_on)).a().a(new h(this)).d(com.baidu.platform.comapi.wnplatform.o.a.a.b(this.i, R.string.abc_activitychooserview_choose_application)).b(new g(this));
                    this.m.setOnCancelListener(new i(this));
                }
                if (this.i != null && !this.i.isFinishing()) {
                    this.m.show();
                }
            } catch (Exception e) {
            }
        }
    }

    private void N() {
        try {
            if (this.m != null && this.i != null && !this.i.isFinishing()) {
                if (this.m.isShowing()) {
                    this.m.dismiss();
                }
                this.m = null;
            }
        } catch (Exception e) {
        }
    }

    public void x() {
        a(false, R.string.abc_action_bar_up_description);
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void c(int i) {
        if (this.k != null) {
            this.k.c(i);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void a(boolean z) {
        if (this.k != null) {
            this.k.a(z);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public int j() {
        return 12;
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public int f() {
        return (int) (com.baidu.platform.comapi.wnplatform.o.b.b.a().d() * 155.0f);
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public int g() {
        return (int) (com.baidu.platform.comapi.wnplatform.o.b.b.a().d() * 30.0f);
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void b(int i) {
        if (this.o != null && this.ae != null) {
            this.o.removeCallbacks(this.ae);
            this.o.postDelayed(this.ae, i);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void o() {
        if (this.o != null && this.ae != null) {
            this.o.removeCallbacks(this.ae);
        }
    }

    public void y() {
        com.baidu.platform.comapi.wnplatform.k.a.a().a("FootNaviAutoComplete");
        if (this.k != null) {
            this.k.e();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void b(Bundle bundle) {
        int i = bundle.getInt("simpleUpdateType");
        if (i != e.a.a && i != e.a.d && bundle.containsKey("enGuideType")) {
            int i2 = bundle.getInt("enGuideType");
            int b2 = com.baidu.platform.comapi.walknavi.g.a.c.b(com.baidu.platform.comapi.wnplatform.h.c.a(RouteGuideKind.values()[i2]));
            if (i2 != 0) {
                String string = bundle.getString("usGuideText");
                if (("到达目的地".equals(string) || b2 == R.drawable.abc_scrubber_track_mtrl_alpha || b2 == R.drawable.abc_seekbar_thumb_material || b2 == R.drawable.abc_seekbar_tick_mark_material) && com.baidu.platform.comapi.walknavi.b.a().l().isShowDialogWithExitNavi()) {
                    z();
                }
                this.G.a(b2, string);
                this.G.d();
            }
        }
    }

    public void a(RouteGuideKind routeGuideKind) {
        if (com.baidu.platform.comapi.walknavi.d.j.a().a(routeGuideKind)) {
            com.baidu.platform.comapi.walknavi.d.j.a().c();
        }
        if (com.baidu.platform.comapi.walknavi.d.j.a().b(routeGuideKind)) {
            com.baidu.platform.comapi.walknavi.d.j.a().d();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void c(Bundle bundle) {
        if (bundle.getInt("updatetype") == e.a.c) {
            this.A.setVisibility(0);
            int i = bundle.getInt("totaldist");
            int i2 = bundle.getInt("totaltime");
            StringBuffer stringBuffer = new StringBuffer();
            com.baidu.platform.comapi.wnplatform.o.f.a(i, f.a.ZH, stringBuffer);
            b(stringBuffer.toString());
            c(com.baidu.platform.comapi.wnplatform.o.f.a(i2, 2));
            if (this.E != null) {
                int b2 = com.baidu.platform.comapi.walknavi.b.a().R().b();
                this.E.setPassLengthAndTotalLength(b2 - i, b2);
            }
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void a(byte[] bArr) {
        if (bArr == null || bArr.length > 0) {
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void d(Bundle bundle) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public float r() {
        return this.I;
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void a(Bundle bundle) {
        float f;
        Exception e;
        double d = 0.0d;
        try {
            this.I = bundle.getFloat("curSpeed");
            this.af = bundle.getInt("AddDist");
            d = new BigDecimal(bundle.getInt("AddDist") / 1000.0f).setScale(1, 4).doubleValue();
            f = bundle.getInt("RouteDist") / 1000.0f;
            try {
                float f2 = bundle.getFloat("calorie");
                com.baidu.platform.comapi.wnplatform.d.a.b("walk cal:" + f2 + "or:" + bundle.getFloat("calorie"));
                double doubleValue = new BigDecimal(f2).setScale(1, 4).doubleValue();
                if (this.k != null) {
                    this.k.a((int) doubleValue);
                }
            } catch (Exception e2) {
                e = e2;
                com.baidu.platform.comapi.wnplatform.d.a.b(com.baidu.fsg.base.statistics.b.k + e.getMessage());
                this.J = d / f;
            }
        } catch (Exception e3) {
            f = 0.0f;
            e = e3;
        }
        this.J = d / f;
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void e(Bundle bundle) {
        com.baidu.platform.comapi.wnplatform.d.a.b("onCompassInfoUpdate" + bundle.toString());
        if (com.baidu.platform.comapi.walknavi.b.a().J() == 4 && bundle.containsKey("uid")) {
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(bundle.getInt("uid"));
            com.baidu.platform.comapi.walknavi.segmentbrowse.a aVar = new com.baidu.platform.comapi.walknavi.segmentbrowse.a();
            aVar.b(bundle.getInt("uid"));
            aVar.a(com.baidu.platform.comapi.walknavi.segmentbrowse.widget.e.a(bundle, false));
            aVar.b(com.baidu.platform.comapi.walknavi.segmentbrowse.widget.e.a(bundle));
            if (bundle.containsKey("usGuideText")) {
                aVar.b(bundle.getString("usGuideText"));
            }
            if (bundle.containsKey("enGuideType")) {
                aVar.a(com.baidu.platform.comapi.wnplatform.h.c.a(RouteGuideKind.values()[bundle.getInt("enGuideType")]));
            }
            if (bundle.containsKey("nParagraphLength")) {
                aVar.a(bundle.getInt("nParagraphLength"));
            }
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(aVar);
            this.r.removeAllViews();
            new Handler().postDelayed(new k(this), 500L);
            com.baidu.platform.comapi.walknavi.b.a().D().a(true);
            this.s = new com.baidu.platform.comapi.walknavi.segmentbrowse.widget.g(this.i, this);
            this.r.addView(this.s);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void f(Bundle bundle) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.b
    public void b(Message message) {
        com.baidu.platform.comapi.wnplatform.k.a.a().a("FootNaviPG.farAway");
        this.r.removeAllViews();
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.r();
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE);
        if (this.G != null) {
            this.G.a(R.drawable.abc_tab_indicator_material, "您已偏离路线");
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.b
    public void c(Message message) {
        this.k.b(3);
        this.G.a(R.drawable.abc_vector_test, "偏航规划中...");
        com.baidu.platform.comapi.walknavi.b.a().C().a();
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.b
    public void d(Message message) {
        com.baidu.platform.comapi.wnplatform.k.a.a().a("FootNaviPG.reRoute");
        if (!this.p) {
            com.baidu.platform.comapi.walknavi.b.a().F().run("收到偏航算路成功消息");
        }
        D();
        this.k.b(4);
        this.G.a(R.drawable.abc_vector_test, "偏航规划成功");
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.b
    public void e(Message message) {
        y();
        if (com.baidu.platform.comapi.walknavi.b.a().l().isShowDialogWithExitNavi()) {
            z();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.b
    public void f(Message message) {
    }

    public void z() {
        if (this.o != null && this.h != null) {
            this.o.removeCallbacks(this.h);
            this.o.postDelayed(this.h, 3000L);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.c.a
    public void d(int i) {
        L();
    }

    @Override // com.baidu.platform.comapi.wnplatform.c.a
    public void a(Message message) {
        if (message.arg1 == 0) {
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE);
            if (this.G != null) {
                this.G.a(R.drawable.abc_text_select_handle_left_mtrl_dark, "");
                this.G.c();
            }
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void a() {
        com.baidu.platform.comapi.walknavi.b.a().D().i();
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void b() {
        com.baidu.platform.comapi.walknavi.b.a().G().a(1);
        if (com.baidu.platform.comapi.walknavi.b.a().J() == 4) {
            com.baidu.platform.comapi.walknavi.b.a().F().setInitialState("Entry");
        }
        Q();
        com.baidu.platform.comapi.walknavi.b.a().D().h();
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void a(int i) {
    }

    private void O() {
        com.baidu.platform.comapi.walknavi.b.a().C().a(this);
        com.baidu.platform.comapi.walknavi.b.a().E().a((com.baidu.platform.comapi.wnplatform.h.a) this);
        com.baidu.platform.comapi.walknavi.b.a().E().a((com.baidu.platform.comapi.wnplatform.h.b) this);
        com.baidu.platform.comapi.walknavi.b.a().P().a(this);
    }

    private void P() {
        com.baidu.platform.comapi.walknavi.b.a().C().a((com.baidu.platform.comapi.wnplatform.i.a) null);
        com.baidu.platform.comapi.walknavi.b.a().E().b((com.baidu.platform.comapi.wnplatform.h.a) null);
        com.baidu.platform.comapi.walknavi.b.a().E().b((com.baidu.platform.comapi.wnplatform.h.b) null);
        com.baidu.platform.comapi.walknavi.b.a().P().b((com.baidu.platform.comapi.wnplatform.c.a) null);
    }

    private void Q() {
        if (this.k != null) {
            this.k.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.r();
        if (this.i != null) {
            com.baidu.platform.comapi.walknavi.g.c.c.a(this.i, com.baidu.platform.comapi.wnplatform.o.a.a.b(this.i, R.string.abc_search_hint));
        }
        v();
    }

    private void b(String str) {
        if (this.C != null && !TextUtils.isEmpty(str)) {
            this.C.setText(str);
        }
    }

    private void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.D.setText(str);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void a(String str) {
    }

    /* renamed from: com.baidu.platform.comapi.walknavi.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class CountDownTimerC0191a extends CountDownTimer {
        Activity a;
        com.baidu.platform.comapi.walknavi.widget.a b;

        public CountDownTimerC0191a(long j, long j2, Activity activity, com.baidu.platform.comapi.walknavi.widget.a aVar) {
            super(j, j2);
            this.a = activity;
            this.b = aVar;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            if (this.b != null) {
                ((Button) this.b.c()).setText("确定(" + ((j / 1000) - 1) + ")");
            }
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (this.a != null && !this.a.isFinishing()) {
                this.b.dismiss();
            }
            a.this.q();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public Handler t() {
        return this.Q;
    }
}
