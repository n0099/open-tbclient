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
import com.baidu.mapapi.bikenavi.model.RouteGuideKind;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.platform.comapi.walknavi.segmentbrowse.widget.TestLinearLayout;
import com.baidu.platform.comapi.walknavi.segmentbrowse.widget.TestScaleView;
import com.baidu.platform.comapi.wnplatform.h.d;
import com.baidu.platform.comapi.wnplatform.o.e;
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
import com.baidu.tieba.R;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.math.BigDecimal;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends com.baidu.platform.comapi.wnplatform.n.a {
    private LinearLayout A;
    private TextView B;
    private TextView C;
    private TextView D;
    private TestScaleView E;
    private View F;
    private com.baidu.platform.comapi.walknavi.widget.d G;
    private TextView H;
    private double I;
    private int J;
    private int K;
    private RelativeLayout P;
    private RelativeLayout Q;
    private RelativeLayout R;
    private TextView S;
    private TextView T;
    private ImageView U;
    private ImageView V;
    private View X;
    private AnimationDrawable Y;
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
    private CountDownTimerC0103a q = null;
    private int v = 0;
    private boolean w = false;
    private boolean z = false;
    public Bitmap a = null;
    public Bitmap b = null;
    public Bitmap c = null;
    private Handler L = new b(this);
    private Runnable M = new m(this);
    private Runnable N = new n(this);
    private Runnable O = new o(this);
    private String W = "";
    final Runnable g = new e(this);
    private Runnable Z = new i(this);
    private int aa = -1;
    final Runnable h = new k(this);
    private com.baidu.platform.comapi.wnplatform.walkmap.c ab = new l(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int a(a aVar, int i) {
        int i2 = aVar.v - i;
        aVar.v = i2;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Point y() {
        if (this.d == null) {
            this.d = com.baidu.platform.comapi.walknavi.b.a().G();
        }
        return this.d;
    }

    private LatLng z() {
        if (this.f == null) {
            this.f = com.baidu.platform.comapi.walknavi.b.a().I();
        }
        return this.f;
    }

    private LatLng A() {
        if (this.e == null) {
            this.e = com.baidu.platform.comapi.walknavi.b.a().H();
        }
        return this.e;
    }

    public a(Activity activity) {
        this.j = null;
        this.i = activity;
        this.j = com.baidu.platform.comapi.wnplatform.o.a.a.a(activity, R.layout.abc_activity_chooser_view, null);
        H();
        C();
    }

    private void B() {
        int b = com.baidu.platform.comapi.walknavi.b.a().y().b();
        com.baidu.platform.comapi.wnplatform.c.a.a("tag", "traffic size:" + b);
        if (b != 0) {
            int[] iArr = new int[b];
            int[] iArr2 = new int[b];
            int[] iArr3 = new int[b];
            com.baidu.platform.comapi.walknavi.b.a().y().a(iArr, iArr2, iArr3);
            com.baidu.platform.comapi.wnplatform.g.a.b().a(this.i, iArr, iArr2, iArr3);
        }
    }

    public void e(int i) {
        if (i == 1) {
            com.baidu.platform.comapi.walknavi.b.a().B().a().showScaleControl(true);
            com.baidu.platform.comapi.walknavi.b.a().B().a().showZoomControls(false);
            com.baidu.platform.comapi.walknavi.b.a().B().a().getMap().getUiSettings().setAllGesturesEnabled(true);
            a(this.i, com.baidu.platform.comapi.walknavi.b.a().B().a(), 70, 0, 0, 60);
        } else if (i == 2) {
            com.baidu.platform.comapi.walknavi.b.a().B().a().showScaleControl(false);
            com.baidu.platform.comapi.walknavi.b.a().B().a().showZoomControls(false);
            com.baidu.platform.comapi.walknavi.b.a().B().a().getMap().getUiSettings().setAllGesturesEnabled(false);
            a(this.i, com.baidu.platform.comapi.walknavi.b.a().B().a(), 0, 0, 0, 0);
        }
    }

    public void a(int i, boolean z) {
        e(i);
        if (i == 2) {
            com.baidu.platform.comapi.walknavi.b.a().C().b("WALKNAVI_FIRST_AR", false);
            if (!com.baidu.platform.comapi.walknavi.b.a().C().a("WALKNAVI_AR_HINT_HAS_SHOW", false)) {
                this.L.postDelayed(this.O, ErrDef.Feature.WEIGHT);
            }
            if (!com.baidu.platform.comapi.walknavi.b.a().C().a("WALKNAVI_AR_ADJUST_HAS_SHOW", false)) {
                this.L.postDelayed(this.N, StatisticConfig.MIN_UPLOAD_INTERVAL);
            }
            b(i, z);
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE);
            com.baidu.platform.comapi.walknavi.b.a().y().i();
            com.baidu.platform.comapi.walknavi.b.a().B().a(com.baidu.platform.comapi.walknavi.b.a().B().i());
        } else if (i == 1) {
            this.L.removeCallbacks(this.O);
            this.L.removeCallbacks(this.N);
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
                this.G.b(-16777216);
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
        if (this.P != null) {
            if (i == 2) {
                this.P.setVisibility(0);
            } else {
                this.P.setVisibility(8);
            }
        }
        if (i == 2) {
            com.baidu.platform.comapi.walknavi.b.a().v();
        } else {
            com.baidu.platform.comapi.walknavi.b.a().u();
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
            this.C.setTextColor(-16777216);
            this.D.setTextColor(-16777216);
            this.B.setTextColor(-16777216);
        }
    }

    private void C() {
        int a = com.baidu.platform.comapi.walknavi.b.a().y().a();
        com.baidu.platform.comapi.wnplatform.c.a.a("tag", "all size:" + a);
        if (a > 2) {
            int[] iArr = new int[a - 2];
            int[] iArr2 = new int[a - 2];
            int[] iArr3 = new int[a - 2];
            com.baidu.platform.comapi.walknavi.b.a().y().b(iArr, iArr2, iArr3);
            com.baidu.platform.comapi.wnplatform.g.b.b().a(this.i, iArr, iArr2, iArr3);
        }
    }

    private void D() {
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

    @Override // com.baidu.platform.comapi.wnplatform.n.a, com.baidu.platform.comapi.walknavi.a
    public void release() {
        N();
        if (this.o != null) {
            this.o.removeCallbacks(this.g);
            this.o = null;
        }
        if (this.k != null) {
            this.k.d();
        }
        this.n = null;
        D();
        this.H = null;
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a, com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        M();
        return true;
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public boolean c() {
        return this.j == null || this.i == null;
    }

    public RelativeLayout k() {
        return this.k.g();
    }

    private void E() {
        this.P = (RelativeLayout) this.j.findViewById(2131165294);
        this.P.setVisibility(0);
        this.P.setOnClickListener(new p(this));
        this.Q = (RelativeLayout) this.j.findViewById(R.raw.rim_video_lrc_tip);
        this.S = (TextView) this.j.findViewById(R.raw.rim_video_too_near);
        this.T = (TextView) this.j.findViewById(R.raw.sapi_camera_blink);
        this.R = (RelativeLayout) this.j.findViewById(R.raw.sapi_camera_found_face);
        this.U = (ImageView) this.j.findViewById(R.raw.sapi_camera_nod);
        this.V = (ImageView) this.j.findViewById(R.raw.sapi_camera_photo_done);
    }

    public void m() {
        this.Q.setVisibility(0);
        this.R.setVisibility(8);
        this.U.setVisibility(8);
        this.V.setVisibility(8);
    }

    public void a(boolean z, boolean z2, boolean z3, boolean z4) {
        this.Q.setVisibility(8);
        this.R.setVisibility(0);
        if (z) {
            this.U.setVisibility(0);
            this.V.setVisibility(8);
        }
        if (z2) {
            this.V.setVisibility(0);
            this.U.setVisibility(8);
        }
    }

    private int F() {
        return (this.J - com.baidu.platform.comapi.wnplatform.o.f.a(this.i, 40)) + 0;
    }

    public int p() {
        return com.baidu.platform.comapi.wnplatform.o.f.a(this.i, 32);
    }

    public void a(float f, float f2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5 = true;
        boolean z6 = false;
        if (this.P != null) {
            if (com.baidu.platform.comapi.walknavi.b.a().o() == 2) {
                if (f == 0.0f && f2 == 0.0f) {
                    this.P.setVisibility(8);
                } else {
                    this.P.setVisibility(0);
                }
                if (f < 0.0f) {
                    z = false;
                    z2 = true;
                    z3 = false;
                    f = 0.0f;
                } else if (f >= 0.0f && f < F()) {
                    z = false;
                    z2 = false;
                    z3 = true;
                } else if (f >= F()) {
                    f = F();
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
                } else if (f2 >= 0.0f && f2 < this.K) {
                    z4 = true;
                    z5 = false;
                } else if (f2 > this.K) {
                    f2 = this.K;
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
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.P.getLayoutParams();
                layoutParams.leftMargin = (int) f;
                layoutParams.topMargin = (int) f2;
                this.P.setLayoutParams(layoutParams);
                return;
            }
            this.P.setVisibility(8);
        }
    }

    public void q() {
        if (this.X != null) {
            this.X.setVisibility(0);
        }
        if (this.Y != null) {
            this.Y.start();
        }
    }

    public void s() {
        if (this.X != null) {
            this.X.setVisibility(8);
        }
        if (this.Y != null) {
            this.Y.stop();
        }
    }

    private void G() {
        this.X = this.j.findViewById(2131165296);
        this.X.setVisibility(8);
        this.X.setOnClickListener(new q(this));
        ((ImageView) this.j.findViewById(2131165299)).setOnClickListener(new r(this));
        this.Y = (AnimationDrawable) ((ImageView) this.j.findViewById(2131165297)).getBackground();
    }

    private void H() {
        G();
        E();
        com.baidu.platform.comapi.walknavi.b.a().B().a().getMap().addOverlay(new MarkerOptions().position(A()).icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(com.baidu.platform.comapi.wnplatform.o.a.a.a(), R.drawable.abc_scrubber_primary_mtrl_alpha))).zIndex(9).draggable(false));
        com.baidu.platform.comapi.walknavi.b.a().B().a().getMap().addOverlay(new MarkerOptions().position(z()).icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(com.baidu.platform.comapi.wnplatform.o.a.a.a(), R.drawable.abc_scrubber_control_to_pressed_mtrl_005))).zIndex(9).draggable(false));
        this.F = this.j.findViewById(2131165260);
        this.k = new com.baidu.platform.comapi.walknavi.g.b.c(this.i, this, this.j);
        this.k.h().setOnClickListener(new s(this));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.i.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.a = displayMetrics.widthPixels;
        com.baidu.platform.comapi.wnplatform.c.a.a("walk engine", "screen width" + com.baidu.platform.comapi.walknavi.segmentbrowse.c.a);
        t tVar = new t(this);
        if (tVar != null) {
            this.k.a(tVar);
        }
        this.G = new com.baidu.platform.comapi.walknavi.widget.d(this.i, this, this.j);
        this.r = (FrameLayout) this.j.findViewById(2131165255);
        this.x = (TestLinearLayout) this.j.findViewById(2131165256);
        this.y = (TestLinearLayout) this.j.findViewById(2131165257);
        this.A = (LinearLayout) this.j.findViewById(2131165249);
        this.B = (TextView) this.j.findViewById(2131165250);
        this.C = (TextView) this.j.findViewById(2131165251);
        this.D = (TextView) this.j.findViewById(2131165252);
        this.E = (TestScaleView) this.j.findViewById(2131165253);
        Bundle P = com.baidu.platform.comapi.walknavi.b.a().P();
        if (P != null) {
            this.C.setText(P.getString("distance"));
            this.D.setText(P.getString("time"));
        }
        if (com.baidu.platform.comapi.walknavi.b.a().E() == 4) {
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
        if (com.baidu.platform.comapi.walknavi.b.a().E() != 4) {
            J();
        }
        if (this.k != null) {
            this.k.c();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void e() {
        this.p = true;
    }

    public void a(boolean z, int i) {
        System.out.println("WalkUIController showQuitDialog");
        try {
            if (this.i == null || this.i.isFinishing()) {
                com.baidu.platform.comapi.wnplatform.k.a.a().a("FootNaviPG.exitNavi");
                t();
                return;
            }
            this.l = new com.baidu.platform.comapi.walknavi.widget.a(this.i).a(true).b(com.baidu.platform.comapi.wnplatform.o.a.a.b(this.i, R.string.abc_action_menu_overflow_description)).a(com.baidu.platform.comapi.walknavi.g.a.b.a == 2 ? com.baidu.platform.comapi.wnplatform.o.a.a.b(this.i, R.string.abc_action_bar_up_description) : com.baidu.platform.comapi.wnplatform.o.a.a.b(this.i, i)).d(com.baidu.platform.comapi.wnplatform.o.a.a.b(this.i, R.string.abc_action_bar_home_description)).b().b(new d(this)).c(com.baidu.platform.comapi.wnplatform.o.a.a.b(this.i, R.string.abc_action_mode_done)).a(new c(this));
            if (z) {
                this.q = new CountDownTimerC0103a(7000L, 1000L, this.i, this.l);
                this.q.start();
            }
            if (!this.l.isShowing() && this.i != null && !this.i.isFinishing()) {
                this.l.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        ViewParent parent;
        if (this.L != null && this.M != null) {
            this.L.removeCallbacks(this.M);
        }
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.r();
        t();
        if (this.j != null && (parent = this.j.getParent()) != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeAllViews();
        }
        if (this.i != null && !this.i.isFinishing()) {
            this.i.finish();
        }
        this.i = null;
    }

    public void t() {
        if (this.n != null) {
            this.n.t();
        }
    }

    private void J() {
        if (!this.p) {
            if (!com.baidu.platform.comapi.walknavi.b.a().K().d()) {
                K();
            } else {
                L();
            }
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void i() {
        O();
        if (this.k != null) {
            this.k.e();
        }
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

    public void u() {
        if (this.o != null && this.g != null) {
            this.o.removeCallbacks(this.g);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void a(com.baidu.platform.comapi.walknavi.g.b.a aVar) {
        this.n = aVar;
    }

    private void K() {
        if (this.i != null) {
            try {
                if (this.m == null) {
                    this.m = new com.baidu.platform.comapi.walknavi.widget.a(this.i).b(com.baidu.platform.comapi.wnplatform.o.a.a.b(this.i, R.string.abc_action_menu_overflow_description)).a(com.baidu.platform.comapi.wnplatform.o.a.a.b(this.i, R.string.abc_activity_chooser_view_see_all)).c(com.baidu.platform.comapi.wnplatform.o.a.a.b(this.i, R.string.abc_activitychooserview_choose_application)).a().a(new g(this)).d(com.baidu.platform.comapi.wnplatform.o.a.a.b(this.i, R.string.abc_action_mode_done)).b(new f(this));
                    this.m.setOnCancelListener(new h(this));
                }
                if (this.i != null && !this.i.isFinishing()) {
                    this.m.show();
                }
            } catch (Exception e) {
            }
        }
    }

    private void L() {
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

    public void v() {
        int i;
        try {
            i = (int) new JSONObject(com.baidu.platform.comapi.walknavi.b.a().q()).optDouble("dDistance");
        } catch (JSONException e) {
            e.printStackTrace();
            i = 0;
        }
        if (i <= 100) {
            I();
        } else {
            a(false, R.string.abc_action_bar_home_description_format);
        }
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
        if (this.o != null && this.Z != null) {
            this.o.removeCallbacks(this.Z);
            this.o.postDelayed(this.Z, i);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void o() {
        if (this.o != null && this.Z != null) {
            this.o.removeCallbacks(this.Z);
        }
    }

    public void w() {
        com.baidu.platform.comapi.wnplatform.k.a.a().a("FootNaviAutoComplete");
        if (this.k != null) {
            this.k.e();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void b(Bundle bundle) {
        int i = bundle.getInt("simpleUpdateType");
        if (i != d.a.a && i != d.a.d && bundle.containsKey("enGuideType")) {
            int i2 = bundle.getInt("enGuideType");
            int b = com.baidu.platform.comapi.walknavi.g.a.c.b(com.baidu.platform.comapi.wnplatform.h.c.a(RouteGuideKind.values()[i2]));
            if (i2 != 0) {
                String string = bundle.getString("usGuideText");
                if ("到达目的地".equals(string) || b == R.drawable.abc_scrubber_track_mtrl_alpha || b == R.drawable.abc_seekbar_thumb_material || b == R.drawable.abc_seekbar_tick_mark_material) {
                    x();
                }
                this.G.a(b, string);
                this.G.d();
            }
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void c(Bundle bundle) {
        if (bundle.getInt("updatetype") == d.a.c) {
            this.A.setVisibility(0);
            int i = bundle.getInt("totaldist");
            int i2 = bundle.getInt("totaltime");
            StringBuffer stringBuffer = new StringBuffer();
            com.baidu.platform.comapi.wnplatform.o.e.a(i, e.a.ZH, stringBuffer);
            b(stringBuffer.toString());
            c(com.baidu.platform.comapi.wnplatform.o.e.a(i2, 2));
            if (this.E != null) {
                int b = com.baidu.platform.comapi.walknavi.b.a().M().b();
                this.E.setPassLengthAndTotalLength(b - i, b);
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

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void a(Bundle bundle) {
        float f;
        Exception e;
        double d = 0.0d;
        try {
            this.aa = bundle.getInt("AddDist");
            d = new BigDecimal(bundle.getInt("AddDist") / 1000.0f).setScale(1, 4).doubleValue();
            f = bundle.getInt("RouteDist") / 1000.0f;
            try {
                float f2 = bundle.getFloat("calorie");
                com.baidu.platform.comapi.wnplatform.c.a.b("walk cal:" + f2 + "or:" + bundle.getFloat("calorie"));
                double doubleValue = new BigDecimal(f2).setScale(1, 4).doubleValue();
                if (this.k != null) {
                    this.k.a((int) doubleValue);
                }
            } catch (Exception e2) {
                e = e2;
                com.baidu.platform.comapi.wnplatform.c.a.b(com.baidu.fsg.base.statistics.b.k + e.getMessage());
                this.I = d / f;
            }
        } catch (Exception e3) {
            f = 0.0f;
            e = e3;
        }
        this.I = d / f;
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void e(Bundle bundle) {
        com.baidu.platform.comapi.wnplatform.c.a.b("onCompassInfoUpdate" + bundle.toString());
        if (com.baidu.platform.comapi.walknavi.b.a().E() == 4 && bundle.containsKey("uid")) {
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
            new Handler().postDelayed(new j(this), 500L);
            com.baidu.platform.comapi.walknavi.b.a().y().a(true);
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
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.b
    public void d(Message message) {
        com.baidu.platform.comapi.wnplatform.k.a.a().a("FootNaviPG.reRoute");
        if (!this.p) {
            com.baidu.platform.comapi.walknavi.b.a().A().run("收到偏航算路成功消息");
        }
        B();
        this.k.b(4);
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.b
    public void e(Message message) {
        w();
        x();
    }

    public void x() {
        if (this.o != null && this.h != null) {
            this.o.removeCallbacks(this.h);
            this.o.postDelayed(this.h, 3000L);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.b.a
    public void d(int i) {
        J();
    }

    @Override // com.baidu.platform.comapi.wnplatform.b.a
    public void a(Message message) {
        if (message.arg1 == 0) {
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE);
            if (this.G != null) {
                this.G.a(R.drawable.abc_text_select_handle_left_mtrl_dark, "");
                this.G.c();
                com.baidu.platform.comapi.walknavi.b.a().a(com.baidu.platform.comapi.walknavi.b.a().K().b());
            }
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void a() {
        com.baidu.platform.comapi.walknavi.b.a().y().h();
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void b() {
        com.baidu.platform.comapi.walknavi.b.a().B().a(1);
        if (com.baidu.platform.comapi.walknavi.b.a().E() == 4) {
            com.baidu.platform.comapi.walknavi.b.a().A().setInitialState("Entry");
        }
        O();
        com.baidu.platform.comapi.walknavi.b.a().y().g();
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void a(int i) {
    }

    private void M() {
        com.baidu.platform.comapi.walknavi.b.a().x().a(this);
        com.baidu.platform.comapi.walknavi.b.a().z().a((com.baidu.platform.comapi.wnplatform.h.a) this);
        com.baidu.platform.comapi.walknavi.b.a().z().a((com.baidu.platform.comapi.wnplatform.h.b) this);
        com.baidu.platform.comapi.walknavi.b.a().K().a(this);
    }

    private void N() {
        com.baidu.platform.comapi.walknavi.b.a().x().a((com.baidu.platform.comapi.wnplatform.i.a) null);
        com.baidu.platform.comapi.walknavi.b.a().z().b((com.baidu.platform.comapi.wnplatform.h.a) null);
        com.baidu.platform.comapi.walknavi.b.a().z().b((com.baidu.platform.comapi.wnplatform.h.b) null);
        com.baidu.platform.comapi.walknavi.b.a().K().b((com.baidu.platform.comapi.wnplatform.b.a) null);
    }

    private void O() {
        if (this.k != null) {
            this.k.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.r();
        if (this.i != null) {
            com.baidu.platform.comapi.walknavi.g.c.b.a(this.i, com.baidu.platform.comapi.wnplatform.o.a.a.b(this.i, R.string.abc_capital_off));
        }
        t();
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
    /* loaded from: classes4.dex */
    public class CountDownTimerC0103a extends CountDownTimer {
        Activity a;
        com.baidu.platform.comapi.walknavi.widget.a b;

        public CountDownTimerC0103a(long j, long j2, Activity activity, com.baidu.platform.comapi.walknavi.widget.a aVar) {
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
            a.this.I();
            if (this.a != null && !this.a.isFinishing()) {
                this.b.dismiss();
            }
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public Handler r() {
        return this.L;
    }
}
