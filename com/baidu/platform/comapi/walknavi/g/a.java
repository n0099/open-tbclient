package com.baidu.platform.comapi.walknavi.g;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.walknavi.model.RouteGuideKind;
import com.baidu.mapapi.walknavi.model.WalkNaviDisplayOption;
import com.baidu.platform.comapi.walknavi.segmentbrowse.widget.TestLinearLayout;
import com.baidu.platform.comapi.walknavi.segmentbrowse.widget.TestScaleView;
import com.baidu.platform.comapi.wnplatform.i.e;
import com.baidu.platform.comapi.wnplatform.p.g;
import com.baidu.tieba.R;
import java.math.BigDecimal;
/* loaded from: classes3.dex */
public class a extends com.baidu.platform.comapi.wnplatform.o.a {
    private static int I = 0;
    private double A;
    private RelativeLayout M;
    private View O;
    private AnimationDrawable P;
    private String R;
    private String S;
    LatLng d;
    LatLng e;
    private Activity g;
    private View h;
    private com.baidu.platform.comapi.walknavi.g.c.c i;
    private com.baidu.platform.comapi.walknavi.widget.a j;
    private com.baidu.platform.comapi.walknavi.widget.a k;
    private FrameLayout p;
    private com.baidu.platform.comapi.walknavi.segmentbrowse.widget.e q;
    private TestLinearLayout t;
    private TestLinearLayout u;
    private TestScaleView w;
    private com.baidu.platform.comapi.walknavi.widget.d x;
    private TextView y;
    private float z;
    private com.baidu.platform.comapi.walknavi.g.c.a l = null;
    private Handler m = new Handler();
    private boolean n = true;
    private CountDownTimerC0249a o = null;
    private int r = 0;
    private boolean s = false;
    private boolean v = false;
    public Bitmap a = null;
    public Bitmap b = null;
    public Bitmap c = null;
    private com.baidu.platform.comapi.walknavi.g.a.a B = null;
    private Bitmap C = BitmapFactory.decodeResource(com.baidu.platform.comapi.wnplatform.p.a.a.b(), R.drawable.abc_scrubber_primary_mtrl_alpha);
    private BitmapDescriptor D = BitmapDescriptorFactory.fromBitmap(this.C);
    private Bitmap E = BitmapFactory.decodeResource(com.baidu.platform.comapi.wnplatform.p.a.a.b(), R.drawable.abc_scrubber_control_to_pressed_mtrl_005);
    private BitmapDescriptor F = BitmapDescriptorFactory.fromBitmap(this.E);
    private Handler G = new com.baidu.platform.comapi.walknavi.g.b(this);
    private double H = 0.0d;
    private Runnable J = new m(this);
    private Runnable K = new p(this);
    private Runnable L = new q(this);
    private String N = "";
    final Runnable f = new g(this);
    private Runnable Q = new k(this);
    private int T = -1;
    private final Runnable U = new n(this);
    private com.baidu.platform.comapi.wnplatform.walkmap.c V = new o(this);

    /* loaded from: classes3.dex */
    public interface b {
        void a(int i);

        void b(int i);
    }

    private LatLng y() {
        if (this.e == null) {
            this.e = com.baidu.platform.comapi.walknavi.b.a().P();
        }
        return this.e;
    }

    private LatLng z() {
        if (this.d == null) {
            this.d = com.baidu.platform.comapi.walknavi.b.a().O();
        }
        return this.d;
    }

    public com.baidu.platform.comapi.walknavi.g.c.c k() {
        return this.i;
    }

    public a(Activity activity) {
        this.h = null;
        this.g = activity;
        this.h = com.baidu.platform.comapi.wnplatform.p.a.a.a(activity, 2130903051, null);
        H();
        D();
    }

    private void A() {
        int b2 = com.baidu.platform.comapi.walknavi.b.a().G().b();
        com.baidu.platform.comapi.wnplatform.d.a.a("tag", "traffic size:" + b2);
        if (b2 != 0) {
            int[] iArr = new int[b2];
            int[] iArr2 = new int[b2];
            int[] iArr3 = new int[b2];
            com.baidu.platform.comapi.walknavi.b.a().G().a(iArr, iArr2, iArr3);
            com.baidu.platform.comapi.wnplatform.h.a.b().a(this.g, iArr, iArr2, iArr3);
        }
    }

    public void e(int i) {
        if (com.baidu.platform.comapi.wnplatform.a.a().b()) {
            com.baidu.platform.comapi.walknavi.b.a().J().a().showScaleControl(true);
            com.baidu.platform.comapi.walknavi.b.a().J().a().showZoomControls(false);
            com.baidu.platform.comapi.walknavi.b.a().J().a().getMap().getUiSettings().setAllGesturesEnabled(true);
            a(this.g, com.baidu.platform.comapi.walknavi.b.a().J().a(), 60, 0, 0, 75);
        } else if (com.baidu.platform.comapi.wnplatform.a.a().c()) {
            com.baidu.platform.comapi.walknavi.b.a().J().a().showScaleControl(false);
            com.baidu.platform.comapi.walknavi.b.a().J().a().showZoomControls(false);
            com.baidu.platform.comapi.walknavi.b.a().J().a().getMap().getUiSettings().setAllGesturesEnabled(false);
            a(this.g, com.baidu.platform.comapi.walknavi.b.a().J().a(), 0, 0, 0, 0);
        }
    }

    public void a(int i, boolean z) {
        e(i);
        if (com.baidu.platform.comapi.wnplatform.a.a().c()) {
            com.baidu.platform.comapi.walknavi.b.a().K().b("WALKNAVI_FIRST_AR", false);
            if (!com.baidu.platform.comapi.walknavi.b.a().K().a("WALKNAVI_AR_HINT_HAS_SHOW", false)) {
                this.G.postDelayed(this.L, 10000L);
            }
            if (!com.baidu.platform.comapi.walknavi.b.a().K().a("WALKNAVI_AR_ADJUST_HAS_SHOW", false)) {
                this.G.postDelayed(this.K, 30000L);
            }
            b(i, z);
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE);
            com.baidu.platform.comapi.walknavi.b.a().G().j();
            this.G.postDelayed(new r(this), 500L);
        } else if (com.baidu.platform.comapi.wnplatform.a.a().b()) {
            this.G.removeCallbacks(this.L);
            this.G.removeCallbacks(this.K);
            b(i, z);
        }
    }

    private void b(int i, boolean z) {
        if (this.p != null) {
            if (com.baidu.platform.comapi.wnplatform.a.a().c()) {
                this.x.a(0);
                this.x.h();
                new RelativeLayout.LayoutParams(-1, C() + a((Context) this.g)).addRule(3, 2131165271);
            } else {
                new RelativeLayout.LayoutParams(-1, B() + a((Context) this.g)).addRule(3, 2131165271);
                this.x.b(R.drawable.aiapps_login_getmobile_dark_bg);
                this.x.g();
            }
        }
        if (this.t != null) {
            if (com.baidu.platform.comapi.wnplatform.a.a().c()) {
                this.t.setVisibility(8);
            } else {
                this.t.setVisibility(0);
            }
        }
        if (this.u != null) {
            if (com.baidu.platform.comapi.wnplatform.a.a().c()) {
                this.u.setVisibility(0);
            } else {
                this.u.setVisibility(8);
            }
        }
        if (this.M != null) {
            if (com.baidu.platform.comapi.wnplatform.a.a().c()) {
                this.M.setVisibility(0);
            } else {
                this.M.setVisibility(8);
            }
        }
        this.B.b();
        if (com.baidu.platform.comapi.wnplatform.a.a().c()) {
            com.baidu.platform.comapi.walknavi.b.a().D();
        } else {
            com.baidu.platform.comapi.walknavi.b.a().C();
        }
        if (this.w != null) {
            this.w.refresh();
        }
        if (this.i != null) {
            this.i.a(i, z);
        }
        f(i);
    }

    private int B() {
        int b2 = (int) (com.baidu.platform.comapi.wnplatform.p.h.b(this.g) / 2.9d);
        int a = com.baidu.platform.comapi.wnplatform.p.h.a(this.g, com.baidu.platform.comapi.wnplatform.p.h.a);
        return b2 > a ? a : b2;
    }

    private int C() {
        int b2 = (int) (com.baidu.platform.comapi.wnplatform.p.h.b(this.g) / 2.7d);
        int a = com.baidu.platform.comapi.wnplatform.p.h.a(this.g, com.baidu.platform.comapi.wnplatform.p.h.b);
        if (b2 <= a) {
            a = b2;
        }
        return a - a((Context) this.g);
    }

    public static int a(Context context) {
        Resources resources;
        int identifier;
        if (context == null || (identifier = (resources = context.getResources()).getIdentifier("status_bar_height", "dimen", "android")) <= 0) {
            return 0;
        }
        return resources.getDimensionPixelSize(identifier);
    }

    private void f(int i) {
        if (i == 2) {
            if (this.i != null && !this.i.m() && this.i.i() != null) {
                this.i.i().setBackgroundColor(Color.parseColor("#cc061835"));
                this.i.i().setTextColor(-1);
            }
        } else if (i == 1 && this.i != null && !this.i.m() && this.i.i() != null) {
            this.i.i().setBackgroundColor(-1);
            this.i.i().setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
    }

    private void D() {
        int a = com.baidu.platform.comapi.walknavi.b.a().G().a();
        com.baidu.platform.comapi.wnplatform.d.a.a("tag", "all size:" + a);
        if (a > 2) {
            int[] iArr = new int[a - 2];
            int[] iArr2 = new int[a - 2];
            int[] iArr3 = new int[a - 2];
            com.baidu.platform.comapi.walknavi.b.a().G().b(iArr, iArr2, iArr3);
            com.baidu.platform.comapi.wnplatform.h.c.b().a(this.g, iArr, iArr2, iArr3);
        }
    }

    private void E() {
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

    private void F() {
        if (this.C != null && !this.C.isRecycled()) {
            this.C.recycle();
            this.C = null;
        }
        if (this.E != null && !this.E.isRecycled()) {
            this.E.recycle();
            this.E = null;
        }
        if (this.D != null) {
            this.D.recycle();
            this.D = null;
        }
        if (this.F != null) {
            this.F.recycle();
            this.F = null;
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a, com.baidu.platform.comapi.walknavi.a
    public void release() {
        O();
        if (this.m != null) {
            this.m.removeCallbacks(this.f);
            this.m = null;
        }
        if (this.i != null) {
            this.i.g();
        }
        E();
        F();
        this.y = null;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a, com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        N();
        a(this.g);
        return true;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public boolean c() {
        return this.h == null || this.g == null;
    }

    public void m() {
        if (this.O != null) {
            this.O.setVisibility(0);
        }
        if (this.P != null) {
            this.P.start();
        }
    }

    public void p() {
        if (this.O != null) {
            this.O.setVisibility(8);
        }
        if (this.P != null) {
            this.P.stop();
        }
    }

    private void G() {
        if (this.h != null) {
            this.O = this.h.findViewById(2131165320);
            this.O.setVisibility(8);
            this.O.setOnClickListener(new s(this));
            ImageView imageView = (ImageView) this.h.findViewById(2131165323);
            if (imageView != null) {
                imageView.setOnClickListener(new t(this));
            }
            ImageView imageView2 = (ImageView) this.h.findViewById(2131165321);
            if (imageView2 != null) {
                this.P = (AnimationDrawable) imageView2.getBackground();
            }
        }
    }

    private void H() {
        G();
        com.baidu.platform.comapi.walknavi.b.a().J().a().getMap().addOverlay(new MarkerOptions().position(z()).icon(this.D).zIndex(9).draggable(false));
        com.baidu.platform.comapi.walknavi.b.a().J().a().getMap().addOverlay(new MarkerOptions().position(y()).icon(this.F).zIndex(9).draggable(false));
        this.i = new com.baidu.platform.comapi.walknavi.g.c.c(this.g, this, this.h);
        if (this.i != null && this.i.h() != null) {
            this.i.h().setOnClickListener(new u(this));
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.g.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.a = displayMetrics.widthPixels;
        com.baidu.platform.comapi.wnplatform.d.a.a("walk engine", "screen width" + com.baidu.platform.comapi.walknavi.segmentbrowse.c.a);
        c cVar = new c(this);
        if (this.i != null && cVar != null) {
            this.i.a(cVar);
        }
        this.x = new com.baidu.platform.comapi.walknavi.widget.d(this.g, this, this.h);
        this.p = (FrameLayout) this.h.findViewById(2131165274);
        this.t = (TestLinearLayout) this.h.findViewById(2131165275);
        this.u = (TestLinearLayout) this.h.findViewById(2131165276);
        I();
        this.w = (TestScaleView) this.h.findViewById(2131165271);
        if (com.baidu.platform.comapi.walknavi.b.a().M() == 4) {
            if (this.i != null && this.i.i() != null) {
                this.i.i().setVisibility(8);
                this.i.i().setText("全程");
            }
        } else {
            this.w.setVisibility(0);
        }
        this.B = new com.baidu.platform.comapi.walknavi.g.a.a((ViewGroup) this.h, this.g);
        this.B.a();
        com.baidu.platform.comapi.walknavi.segmentbrowse.widget.d.a(com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(this.g));
    }

    private void I() {
        String a = com.baidu.platform.comapi.walknavi.b.a().U().a().a();
        String b2 = com.baidu.platform.comapi.walknavi.b.a().U().a().b();
        if (!a.isEmpty()) {
            if (this.i != null) {
                a(a, b2);
                if (this.i != null && this.i.i() != null) {
                    this.i.i().setVisibility(0);
                }
            }
            this.x.a(a, b2);
        }
    }

    private void a(Activity activity) {
        BaiduMap map;
        com.baidu.platform.comapi.wnplatform.walkmap.d J = com.baidu.platform.comapi.walknavi.b.a().J();
        if (J != null && J.a() != null && (map = J.a().getMap()) != null) {
            map.setOnBaseIndoorMapListener(new d(this));
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public int n() {
        if (this.p == null || this.i == null || this.i.i() == null) {
            return 50;
        }
        return this.p.getHeight() + this.i.i().getHeight();
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public View h() {
        return this.h;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void d() {
        this.n = false;
        if (com.baidu.platform.comapi.walknavi.b.a().M() != 4) {
            J();
        }
        if (this.i != null) {
            this.i.d();
            this.i.c();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void e() {
        this.n = true;
    }

    public void a(boolean z, int i) {
        String b2;
        System.out.println("WalkUIController showQuitDialog");
        try {
            if (this.g == null || this.g.isFinishing()) {
                com.baidu.platform.comapi.wnplatform.l.a.a().a("FootNaviPG.exitNavi");
                t();
                return;
            }
            com.baidu.platform.comapi.walknavi.widget.a b3 = new com.baidu.platform.comapi.walknavi.widget.a(this.g).a(true).b(com.baidu.platform.comapi.wnplatform.p.a.a.b(this.g, R.raw.ala_play));
            if (com.baidu.platform.comapi.walknavi.g.b.b.a == 2) {
                b2 = com.baidu.platform.comapi.wnplatform.p.a.a.b(this.g, R.raw.ala_live2);
            } else {
                b2 = com.baidu.platform.comapi.wnplatform.p.a.a.b(this.g, i);
            }
            this.j = b3.a(b2).d(com.baidu.platform.comapi.wnplatform.p.a.a.b(this.g, R.raw.ad_refresh_load)).b().b(new f(this)).c(com.baidu.platform.comapi.wnplatform.p.a.a.b(this.g, R.raw.bottom_bar_bg)).a(new e(this));
            if (z) {
                this.o = new CountDownTimerC0249a(6000L, 1000L, this.g, this.j);
                this.o.start();
            }
            if (!this.j.isShowing() && this.g != null && !this.g.isFinishing()) {
                this.j.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void q() {
        WalkNaviDisplayOption n;
        if (this.i != null) {
            this.i.k();
        }
        if (this.G != null && this.J != null) {
            this.G.removeCallbacks(this.J);
        }
        if (this.j != null && this.j.isShowing() && this.g != null && !this.g.isFinishing()) {
            this.j.dismiss();
        }
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.o();
        t();
        if (this.h != null) {
            ViewParent parent = this.h.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeAllViews();
            }
            this.h = null;
        }
        if (this.g != null && !this.g.isFinishing() && ((n = com.baidu.platform.comapi.walknavi.b.a().n()) == null || !n.isIsRunInFragment())) {
            this.g.finish();
        }
        com.baidu.platform.comapi.walknavi.b.a().o();
        this.g = null;
    }

    public void t() {
        if (this.l != null) {
            this.l.B();
            this.l = null;
        }
    }

    private void J() {
        if (!this.n) {
            if (!com.baidu.platform.comapi.walknavi.b.a().S().c()) {
                K();
            } else {
                L();
            }
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void i() {
        P();
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void l() {
        if (this.i != null) {
            this.i.e();
        }
        if (this.m != null && this.f != null) {
            this.m.removeCallbacks(this.f);
            this.m.postDelayed(this.f, 20000L);
        }
    }

    public void v() {
        if (this.m != null && this.f != null) {
            this.m.removeCallbacks(this.f);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void a(com.baidu.platform.comapi.walknavi.g.c.a aVar) {
        this.l = aVar;
    }

    private void K() {
        if (this.g != null) {
            try {
                if (this.k == null) {
                    this.k = new com.baidu.platform.comapi.walknavi.widget.a(this.g).b(com.baidu.platform.comapi.wnplatform.p.a.a.b(this.g, R.raw.ala_play)).a(com.baidu.platform.comapi.wnplatform.p.a.a.b(this.g, R.raw.bottom_bar_bg_1)).c(com.baidu.platform.comapi.wnplatform.p.a.a.b(this.g, R.raw.card_live_bg)).a().a(new i(this)).d(com.baidu.platform.comapi.wnplatform.p.a.a.b(this.g, R.raw.bottom_bar_bg)).b(new h(this));
                    this.k.setOnCancelListener(new j(this));
                }
                if (this.g != null && !this.g.isFinishing()) {
                    this.k.show();
                }
            } catch (Exception e) {
            }
        }
    }

    private void L() {
        try {
            if (this.k != null && this.g != null && !this.g.isFinishing()) {
                if (this.k.isShowing()) {
                    this.k.dismiss();
                }
                this.k = null;
            }
        } catch (Exception e) {
        }
    }

    public void w() {
        a(false, R.raw.aiapp_guide);
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void c(int i) {
        if (this.i != null) {
            this.i.c(i);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void a(boolean z) {
        if (this.i != null) {
            this.i.a(z);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public int j() {
        return 12;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public int f() {
        return (int) (com.baidu.platform.comapi.wnplatform.p.b.b.a().d() * 155.0f);
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public int g() {
        return (int) (com.baidu.platform.comapi.wnplatform.p.b.b.a().d() * 30.0f);
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void b(int i) {
        if (this.m != null && this.Q != null) {
            this.m.removeCallbacks(this.Q);
            this.m.postDelayed(this.Q, i);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void o() {
        if (this.m != null && this.Q != null) {
            this.m.removeCallbacks(this.Q);
        }
    }

    public void x() {
        com.baidu.platform.comapi.wnplatform.l.a.a().a("FootNaviAutoComplete");
        if (this.i != null) {
            this.i.e();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void b(Bundle bundle) {
        if (bundle != null) {
            if (bundle.containsKey("floor") && !TextUtils.isEmpty(bundle.getString("floor")) && bundle.containsKey("building") && !TextUtils.isEmpty(bundle.getString("building")) && com.baidu.platform.comapi.wnplatform.a.a().b() && com.baidu.platform.comapi.wnplatform.a.a().i()) {
                String string = bundle.getString("floor");
                String string2 = bundle.getString("building");
                this.R = string;
                this.S = string2;
                this.B.a(string);
                com.baidu.platform.comapi.wnplatform.p.e.a(string, string2, false);
            }
            int i = bundle.getInt("simpleUpdateType");
            if (i != e.a.a && i != e.a.d && bundle.containsKey("enGuideType")) {
                int i2 = bundle.getInt("enGuideType");
                int c = com.baidu.platform.comapi.walknavi.g.b.c.c(com.baidu.platform.comapi.wnplatform.i.c.a(RouteGuideKind.values()[i2]));
                if (i2 != 0) {
                    String string3 = bundle.getString("usGuideText");
                    if (("到达目的地".equals(string3) || c == R.drawable.abc_scrubber_track_mtrl_alpha || c == R.drawable.abc_seekbar_thumb_material || c == R.drawable.abc_seekbar_tick_mark_material) && (com.baidu.platform.comapi.walknavi.b.a().n() == null || com.baidu.platform.comapi.walknavi.b.a().n().isShowDialogWithExitNavi())) {
                        M();
                    }
                    this.x.a(c, string3);
                    this.x.d();
                }
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

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void c(Bundle bundle) {
        if (bundle.getInt("updatetype") == e.a.c) {
            if (this.i != null && this.i.i() != null) {
                this.i.i().setVisibility(0);
            }
            int i = bundle.getInt("totaldist");
            int i2 = bundle.getInt("totaltime");
            StringBuffer stringBuffer = new StringBuffer();
            com.baidu.platform.comapi.wnplatform.p.g.a(i, g.b.ZH, stringBuffer);
            String stringBuffer2 = stringBuffer.toString();
            String a = com.baidu.platform.comapi.wnplatform.p.g.a(i2, 2);
            a(stringBuffer2, a);
            if (this.x != null) {
                this.x.a(stringBuffer2, a);
            }
            if (this.w != null) {
                int b2 = com.baidu.platform.comapi.walknavi.b.a().U().b();
                this.w.setPassLengthAndTotalLength(b2 - i, b2);
            }
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void a(byte[] bArr) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void d(Bundle bundle) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public float r() {
        return this.z;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void s() {
        this.B.c();
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void a(Bundle bundle) {
        float f;
        Exception e;
        double d = 0.0d;
        try {
            this.z = bundle.getFloat("curSpeed");
            this.T = bundle.getInt("AddDist");
            d = new BigDecimal(bundle.getInt("AddDist") / 1000.0f).setScale(1, 4).doubleValue();
            f = bundle.getInt("RouteDist") / 1000.0f;
            try {
                float f2 = bundle.getFloat("calorie");
                com.baidu.platform.comapi.wnplatform.d.a.b("walk cal:" + f2 + "or:" + bundle.getFloat("calorie"));
                double doubleValue = new BigDecimal(f2).setScale(1, 4).doubleValue();
                if (this.i != null) {
                    this.i.a((int) doubleValue);
                }
            } catch (Exception e2) {
                e = e2;
                com.baidu.platform.comapi.wnplatform.d.a.b("exception" + e.getMessage());
                this.A = d / f;
            }
        } catch (Exception e3) {
            f = 0.0f;
            e = e3;
        }
        this.A = d / f;
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void e(Bundle bundle) {
        com.baidu.platform.comapi.wnplatform.d.a.b("onCompassInfoUpdate" + bundle.toString());
        if (com.baidu.platform.comapi.walknavi.b.a().M() == 4 && bundle.containsKey("uid")) {
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(bundle.getInt("uid"));
            com.baidu.platform.comapi.walknavi.segmentbrowse.a aVar = new com.baidu.platform.comapi.walknavi.segmentbrowse.a();
            aVar.b(bundle.getInt("uid"));
            aVar.a(com.baidu.platform.comapi.walknavi.segmentbrowse.widget.d.a(bundle, false));
            aVar.b(com.baidu.platform.comapi.walknavi.segmentbrowse.widget.d.a(bundle));
            if (bundle.containsKey("usGuideText")) {
                aVar.b(bundle.getString("usGuideText"));
            }
            if (bundle.containsKey("enGuideType")) {
                aVar.a(com.baidu.platform.comapi.wnplatform.i.c.a(RouteGuideKind.values()[bundle.getInt("enGuideType")]));
            }
            if (bundle.containsKey("nParagraphLength")) {
                aVar.a(bundle.getInt("nParagraphLength"));
            }
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(aVar);
            this.p.removeAllViews();
            new Handler().postDelayed(new l(this), 500L);
            com.baidu.platform.comapi.walknavi.b.a().G().a(true);
            this.q = new com.baidu.platform.comapi.walknavi.segmentbrowse.widget.e(this.g, this);
            this.p.addView(this.q);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void f(Bundle bundle) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void b(Message message) {
        com.baidu.platform.comapi.wnplatform.l.a.a().a("FootNaviPG.farAway");
        this.p.removeAllViews();
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.o();
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE);
        if (this.x != null) {
            this.x.a(R.drawable.abc_text_select_handle_middle_mtrl_light, "您已偏离路线");
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void c(Message message) {
        if (this.i != null) {
            this.i.b(3);
        }
        this.x.a(R.drawable.action_bar_bookmark_trash, "偏航规划中...");
        com.baidu.platform.comapi.walknavi.b.a().F().b();
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void d(Message message) {
        com.baidu.platform.comapi.wnplatform.l.a.a().a("FootNaviPG.reRoute");
        if (!this.n) {
            com.baidu.platform.comapi.walknavi.b.a().I().run("收到偏航算路成功消息");
        }
        A();
        if (this.i != null) {
            this.i.b(4);
        }
        this.x.a(R.drawable.action_bar_bookmark_trash, "偏航规划成功");
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void e(Message message) {
        if (com.baidu.platform.comapi.walknavi.b.a().G().q()) {
            com.baidu.platform.comapi.walknavi.b.a().a(true, false);
            return;
        }
        x();
        if (com.baidu.platform.comapi.walknavi.b.a().n() == null || com.baidu.platform.comapi.walknavi.b.a().n().isShowDialogWithExitNavi()) {
            M();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void f(Message message) {
        if (com.baidu.platform.comapi.walknavi.b.a().G().q()) {
            com.baidu.platform.comapi.walknavi.b.a().a(false);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void g(Message message) {
        if (com.baidu.platform.comapi.walknavi.b.a().G().q()) {
            x();
            if (com.baidu.platform.comapi.walknavi.b.a().n() == null || com.baidu.platform.comapi.walknavi.b.a().n().isShowDialogWithExitNavi()) {
                M();
            }
        }
    }

    private void M() {
        if (this.m != null && this.U != null) {
            this.m.removeCallbacks(this.U);
            this.m.postDelayed(this.U, IMConnection.RETRY_DELAY_TIMES);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.c.a
    public void d(int i) {
        J();
    }

    @Override // com.baidu.platform.comapi.wnplatform.c.a
    public void a(Message message) {
        if (message.arg1 == 0) {
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE);
            if (this.x != null) {
                this.x.a(R.drawable.abc_textfield_activated_mtrl_alpha, "");
                this.x.c();
            }
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.c
    public void a() {
        com.baidu.platform.comapi.walknavi.b.a().G().i();
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.c
    public void b() {
        com.baidu.platform.comapi.walknavi.b.a().J().a(1);
        if (com.baidu.platform.comapi.walknavi.b.a().M() == 4) {
            com.baidu.platform.comapi.walknavi.b.a().I().setInitialState("Entry");
        }
        P();
        com.baidu.platform.comapi.walknavi.b.a().G().h();
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.c
    public void a(int i) {
    }

    private void N() {
        com.baidu.platform.comapi.walknavi.b.a().F().a(this);
        com.baidu.platform.comapi.walknavi.b.a().H().a((com.baidu.platform.comapi.wnplatform.i.a) this);
        com.baidu.platform.comapi.walknavi.b.a().H().a((com.baidu.platform.comapi.wnplatform.i.b) this);
        com.baidu.platform.comapi.walknavi.b.a().S().a(this);
    }

    private void O() {
        com.baidu.platform.comapi.walknavi.b.a().F().a((com.baidu.platform.comapi.wnplatform.j.c) null);
        com.baidu.platform.comapi.walknavi.b.a().H().b((com.baidu.platform.comapi.wnplatform.i.a) this);
        com.baidu.platform.comapi.walknavi.b.a().H().b((com.baidu.platform.comapi.wnplatform.i.b) this);
        com.baidu.platform.comapi.walknavi.b.a().S().b(this);
    }

    private void P() {
        if (this.i != null) {
            this.i.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.o();
        if (this.g != null) {
            com.baidu.platform.comapi.walknavi.g.d.c.a(this.g, com.baidu.platform.comapi.wnplatform.p.a.a.b(this.g, R.raw.card_live_bg_black));
        }
        t();
    }

    private void a(String str, String str2) {
        if (this.i != null && this.i.i() != null) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                this.i.i().setVisibility(8);
                return;
            }
            StringBuffer stringBuffer = new StringBuffer("全程剩余:");
            if (!TextUtils.isEmpty(str)) {
                stringBuffer.append(str);
                stringBuffer.append(" ");
            }
            if (!TextUtils.isEmpty(str2)) {
                stringBuffer.append(str2);
            }
            this.i.i().setText(stringBuffer);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void a(String str) {
    }

    /* renamed from: com.baidu.platform.comapi.walknavi.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class CountDownTimerC0249a extends CountDownTimer {
        Activity a;
        com.baidu.platform.comapi.walknavi.widget.a b;

        public CountDownTimerC0249a(long j, long j2, Activity activity, com.baidu.platform.comapi.walknavi.widget.a aVar) {
            super(j, j2);
            this.a = activity;
            this.b = aVar;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            if (this.b != null) {
                ((Button) this.b.c()).setText("确定(" + (j / 1000) + ")");
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

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public Handler u() {
        return this.G;
    }
}
