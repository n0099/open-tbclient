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
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.baidu.wallet.passport.PassLoginUtil;
import java.math.BigDecimal;
/* loaded from: classes2.dex */
public class a extends com.baidu.platform.comapi.wnplatform.n.a {
    public LinearLayout A;
    public TextView B;
    public TextView C;
    public TextView D;
    public TestScaleView E;
    public View F;
    public com.baidu.platform.comapi.walknavi.widget.d G;
    public TextView H;
    public float I;
    public double J;
    public Bitmap K;
    public BitmapDescriptor L;
    public Bitmap M;
    public BitmapDescriptor N;
    public int O;
    public int P;
    public Handler Q;
    public Runnable R;
    public Runnable S;
    public Runnable T;
    public RelativeLayout U;
    public RelativeLayout V;
    public RelativeLayout W;
    public TextView X;
    public TextView Y;
    public ImageView Z;
    public ImageView aa;
    public String ab;
    public View ac;
    public AnimationDrawable ad;
    public Runnable ae;
    public int af;
    public com.baidu.platform.comapi.wnplatform.walkmap.c ag;

    /* renamed from: d  reason: collision with root package name */
    public Point f9617d;

    /* renamed from: e  reason: collision with root package name */
    public LatLng f9618e;

    /* renamed from: f  reason: collision with root package name */
    public LatLng f9619f;

    /* renamed from: g  reason: collision with root package name */
    public final Runnable f9620g;

    /* renamed from: h  reason: collision with root package name */
    public final Runnable f9621h;
    public Activity i;
    public View j;
    public com.baidu.platform.comapi.walknavi.g.b.c k;
    public com.baidu.platform.comapi.walknavi.widget.a l;
    public com.baidu.platform.comapi.walknavi.widget.a m;
    public FrameLayout r;
    public com.baidu.platform.comapi.walknavi.segmentbrowse.widget.g s;
    public com.baidu.platform.comapi.walknavi.segmentbrowse.widget.h t;
    public com.baidu.platform.comapi.walknavi.segmentbrowse.widget.i u;
    public TestLinearLayout x;
    public TestLinearLayout y;
    public com.baidu.platform.comapi.walknavi.g.b.a n = null;
    public Handler o = new Handler();
    public boolean p = true;
    public CountDownTimerC0124a q = null;
    public int v = 0;
    public boolean w = false;
    public boolean z = false;

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f9614a = null;

    /* renamed from: b  reason: collision with root package name */
    public Bitmap f9615b = null;

    /* renamed from: c  reason: collision with root package name */
    public Bitmap f9616c = null;

    /* renamed from: com.baidu.platform.comapi.walknavi.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class CountDownTimerC0124a extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        public Activity f9622a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.platform.comapi.walknavi.widget.a f9623b;

        public CountDownTimerC0124a(long j, long j2, Activity activity, com.baidu.platform.comapi.walknavi.widget.a aVar) {
            super(j, j2);
            this.f9622a = activity;
            this.f9623b = aVar;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Activity activity = this.f9622a;
            if (activity != null && !activity.isFinishing()) {
                this.f9623b.dismiss();
            }
            a.this.q();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            com.baidu.platform.comapi.walknavi.widget.a aVar = this.f9623b;
            if (aVar != null) {
                ((Button) aVar.c()).setText("确定(" + ((j / 1000) - 1) + SmallTailInfo.EMOTION_SUFFIX);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(int i);
    }

    public a(Activity activity) {
        this.j = null;
        Bitmap decodeResource = BitmapFactory.decodeResource(com.baidu.platform.comapi.wnplatform.o.a.a.b(), 2130837564);
        this.K = decodeResource;
        this.L = BitmapDescriptorFactory.fromBitmap(decodeResource);
        Bitmap decodeResource2 = BitmapFactory.decodeResource(com.baidu.platform.comapi.wnplatform.o.a.a.b(), 2130837563);
        this.M = decodeResource2;
        this.N = BitmapDescriptorFactory.fromBitmap(decodeResource2);
        this.Q = new com.baidu.platform.comapi.walknavi.g.b(this);
        this.R = new m(this);
        this.S = new o(this);
        this.T = new p(this);
        this.ab = "";
        this.f9620g = new f(this);
        this.ae = new j(this);
        this.af = -1;
        this.f9621h = new l(this);
        this.ag = new n(this);
        this.i = activity;
        this.j = com.baidu.platform.comapi.wnplatform.o.a.a.a(activity, R.array.S_O_X001, null);
        K();
        E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Point A() {
        if (this.f9617d == null) {
            this.f9617d = com.baidu.platform.comapi.walknavi.b.a().L();
        }
        return this.f9617d;
    }

    private LatLng B() {
        if (this.f9619f == null) {
            this.f9619f = com.baidu.platform.comapi.walknavi.b.a().N();
        }
        return this.f9619f;
    }

    private LatLng C() {
        if (this.f9618e == null) {
            this.f9618e = com.baidu.platform.comapi.walknavi.b.a().M();
        }
        return this.f9618e;
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

    private void E() {
        int a2 = com.baidu.platform.comapi.walknavi.b.a().D().a();
        com.baidu.platform.comapi.wnplatform.d.a.a("tag", "all size:" + a2);
        if (a2 > 2) {
            int i = a2 - 2;
            int[] iArr = new int[i];
            int[] iArr2 = new int[i];
            int[] iArr3 = new int[i];
            com.baidu.platform.comapi.walknavi.b.a().D().b(iArr, iArr2, iArr3);
            com.baidu.platform.comapi.wnplatform.g.c.b().a(this.i, iArr, iArr2, iArr3);
        }
    }

    private void F() {
        Bitmap bitmap = this.f9614a;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f9614a.recycle();
            this.f9614a = null;
        }
        Bitmap bitmap2 = this.f9615b;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.f9615b.recycle();
            this.f9615b = null;
        }
        Bitmap bitmap3 = this.f9616c;
        if (bitmap3 == null || bitmap3.isRecycled()) {
            return;
        }
        this.f9616c.recycle();
        this.f9616c = null;
    }

    private void G() {
        Bitmap bitmap = this.K;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.K.recycle();
            this.K = null;
        }
        Bitmap bitmap2 = this.M;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.M.recycle();
            this.M = null;
        }
        BitmapDescriptor bitmapDescriptor = this.L;
        if (bitmapDescriptor != null) {
            bitmapDescriptor.recycle();
            this.L = null;
        }
        BitmapDescriptor bitmapDescriptor2 = this.N;
        if (bitmapDescriptor2 != null) {
            bitmapDescriptor2.recycle();
            this.N = null;
        }
    }

    private void H() {
        RelativeLayout relativeLayout = (RelativeLayout) this.j.findViewById(R.dimen.abc_seekbar_track_background_height_material);
        this.U = relativeLayout;
        relativeLayout.setVisibility(0);
        this.U.setOnClickListener(new r(this));
        this.V = (RelativeLayout) this.j.findViewById(R.dimen.L_X05);
        this.X = (TextView) this.j.findViewById(R.dimen.M_H_X002);
        this.Y = (TextView) this.j.findViewById(R.dimen.M_H_X003);
        this.W = (RelativeLayout) this.j.findViewById(R.dimen.M_H_X004);
        this.Z = (ImageView) this.j.findViewById(R.dimen.M_H_X005);
        this.aa = (ImageView) this.j.findViewById(R.dimen.M_H_X007);
    }

    private int I() {
        return (this.O - com.baidu.platform.comapi.wnplatform.o.g.a(this.i, 40)) + 0;
    }

    private void J() {
        View findViewById = this.j.findViewById(R.dimen.abc_select_dialog_padding_start_material);
        this.ac = findViewById;
        findViewById.setVisibility(8);
        this.ac.setOnClickListener(new s(this));
        ((ImageView) this.j.findViewById(R.dimen.abc_text_size_body_2_material)).setOnClickListener(new t(this));
        this.ad = (AnimationDrawable) ((ImageView) this.j.findViewById(R.dimen.abc_switch_padding)).getBackground();
    }

    private void K() {
        J();
        H();
        com.baidu.platform.comapi.walknavi.b.a().G().a().getMap().addOverlay(new MarkerOptions().position(C()).icon(this.L).zIndex(9).draggable(false));
        com.baidu.platform.comapi.walknavi.b.a().G().a().getMap().addOverlay(new MarkerOptions().position(B()).icon(this.N).zIndex(9).draggable(false));
        this.F = this.j.findViewById(R.dimen.abc_alert_dialog_button_dimen);
        com.baidu.platform.comapi.walknavi.g.b.c cVar = new com.baidu.platform.comapi.walknavi.g.b.c(this.i, this, this.j);
        this.k = cVar;
        cVar.h().setOnClickListener(new u(this));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.i.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.f9725a = displayMetrics.widthPixels;
        com.baidu.platform.comapi.wnplatform.d.a.a("walk engine", "screen width" + com.baidu.platform.comapi.walknavi.segmentbrowse.c.f9725a);
        this.k.a(new c(this));
        this.G = new com.baidu.platform.comapi.walknavi.widget.d(this.i, this, this.j);
        this.r = (FrameLayout) this.j.findViewById(R.dimen.abc_action_bar_subtitle_bottom_margin_material);
        this.x = (TestLinearLayout) this.j.findViewById(R.dimen.abc_action_bar_subtitle_top_margin_material);
        this.y = (TestLinearLayout) this.j.findViewById(R.dimen.abc_action_button_min_height_material);
        this.A = (LinearLayout) this.j.findViewById(R.dimen.abc_action_bar_elevation_material);
        this.B = (TextView) this.j.findViewById(R.dimen.abc_action_bar_icon_vertical_padding_material);
        this.C = (TextView) this.j.findViewById(R.dimen.abc_action_bar_overflow_padding_end_material);
        this.D = (TextView) this.j.findViewById(R.dimen.abc_action_bar_overflow_padding_start_material);
        this.E = (TestScaleView) this.j.findViewById(R.dimen.abc_action_bar_stacked_max_height);
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

    private void L() {
        if (this.p) {
            return;
        }
        if (!com.baidu.platform.comapi.walknavi.b.a().P().c()) {
            M();
        } else {
            N();
        }
    }

    private void M() {
        if (this.i == null) {
            return;
        }
        try {
            if (this.m == null) {
                com.baidu.platform.comapi.walknavi.widget.a b2 = new com.baidu.platform.comapi.walknavi.widget.a(this.i).b(com.baidu.platform.comapi.wnplatform.o.a.a.b(this.i, R.drawable.res_0x7f080004_avd_show_password__1)).a(com.baidu.platform.comapi.wnplatform.o.a.a.b(this.i, R.drawable.res_0x7f080006_ic_icon_mask_broadcast_svg__0)).c(com.baidu.platform.comapi.wnplatform.o.a.a.b(this.i, R.drawable.res_0x7f080007_ic_icon_mask_card_ba20_svg__0)).a().a(new h(this)).d(com.baidu.platform.comapi.wnplatform.o.a.a.b(this.i, R.drawable.res_0x7f080005_avd_show_password__2)).b(new g(this));
                this.m = b2;
                b2.setOnCancelListener(new i(this));
            }
            if (this.i == null || this.i.isFinishing()) {
                return;
            }
            this.m.show();
        } catch (Exception unused) {
        }
    }

    private void N() {
        try {
            if (this.m == null || this.i == null || this.i.isFinishing()) {
                return;
            }
            if (this.m.isShowing()) {
                this.m.dismiss();
            }
            this.m = null;
        } catch (Exception unused) {
        }
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
        com.baidu.platform.comapi.walknavi.g.b.c cVar = this.k;
        if (cVar != null) {
            cVar.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.r();
        Activity activity = this.i;
        if (activity != null) {
            com.baidu.platform.comapi.walknavi.g.c.c.a(activity, com.baidu.platform.comapi.wnplatform.o.a.a.b(activity, R.drawable.res_0x7f080008_ic_icon_mask_first24__0));
        }
        v();
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void a(int i) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void a(String str) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void d(Bundle bundle) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void f(Bundle bundle) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.b
    public void f(Message message) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public int j() {
        return 12;
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void o() {
        Runnable runnable;
        Handler handler = this.o;
        if (handler == null || (runnable = this.ae) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }

    public int p() {
        return com.baidu.platform.comapi.wnplatform.o.g.a(this.i, 32);
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void q() {
        WalkNaviDisplayOption l;
        Activity activity;
        Runnable runnable;
        com.baidu.platform.comapi.walknavi.g.b.c cVar = this.k;
        if (cVar != null) {
            cVar.j();
        }
        Handler handler = this.Q;
        if (handler != null && (runnable = this.R) != null) {
            handler.removeCallbacks(runnable);
        }
        com.baidu.platform.comapi.walknavi.widget.a aVar = this.l;
        if (aVar != null && aVar.isShowing() && (activity = this.i) != null && !activity.isFinishing()) {
            this.l.dismiss();
        }
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.r();
        v();
        View view = this.j;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeAllViews();
            }
            this.j = null;
        }
        Activity activity2 = this.i;
        if (activity2 != null && !activity2.isFinishing() && ((l = com.baidu.platform.comapi.walknavi.b.a().l()) == null || !l.isIsRunInFragment())) {
            this.i.finish();
        }
        com.baidu.platform.comapi.walknavi.b.a().m();
        this.i = null;
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public float r() {
        return this.I;
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a, com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        O();
        return true;
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a, com.baidu.platform.comapi.walknavi.a
    public void release() {
        P();
        Handler handler = this.o;
        if (handler != null) {
            handler.removeCallbacks(this.f9620g);
            this.o = null;
        }
        com.baidu.platform.comapi.walknavi.g.b.c cVar = this.k;
        if (cVar != null) {
            cVar.g();
        }
        this.n = null;
        F();
        G();
        this.H = null;
    }

    public void s() {
        View view = this.ac;
        if (view != null) {
            view.setVisibility(0);
        }
        AnimationDrawable animationDrawable = this.ad;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public Handler t() {
        return this.Q;
    }

    public void u() {
        View view = this.ac;
        if (view != null) {
            view.setVisibility(8);
        }
        AnimationDrawable animationDrawable = this.ad;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    public void v() {
        com.baidu.platform.comapi.walknavi.g.b.a aVar = this.n;
        if (aVar != null) {
            aVar.y();
        }
    }

    public void w() {
        Runnable runnable;
        Handler handler = this.o;
        if (handler == null || (runnable = this.f9620g) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }

    public void x() {
        a(false, R.drawable.res_0x7f080001_avd_hide_password__1);
    }

    public void y() {
        com.baidu.platform.comapi.wnplatform.k.a.a().a("FootNaviAutoComplete");
        com.baidu.platform.comapi.walknavi.g.b.c cVar = this.k;
        if (cVar != null) {
            cVar.e();
        }
    }

    public void z() {
        Runnable runnable;
        Handler handler = this.o;
        if (handler == null || (runnable = this.f9621h) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
        this.o.postDelayed(this.f9621h, 3000L);
    }

    private void b(int i, boolean z) {
        FrameLayout frameLayout = this.r;
        if (frameLayout != null) {
            if (i == 2) {
                frameLayout.setBackgroundColor(Color.parseColor("#cc061835"));
                this.G.a(Color.parseColor("#cc061835"));
                this.G.b(-1);
            } else {
                frameLayout.setBackgroundColor(Color.parseColor("#ffffffff"));
                this.G.a(Color.parseColor("#ffffffff"));
                this.G.b(-16777216);
            }
        }
        TestLinearLayout testLinearLayout = this.x;
        if (testLinearLayout != null) {
            if (i == 2) {
                testLinearLayout.setVisibility(8);
            } else {
                testLinearLayout.setVisibility(0);
            }
        }
        TestLinearLayout testLinearLayout2 = this.y;
        if (testLinearLayout2 != null) {
            if (i == 2) {
                testLinearLayout2.setVisibility(0);
            } else {
                testLinearLayout2.setVisibility(8);
            }
        }
        View view = this.F;
        if (view != null) {
            if (i == 2) {
                view.setVisibility(8);
            } else {
                view.setVisibility(0);
            }
        }
        RelativeLayout relativeLayout = this.U;
        if (relativeLayout != null) {
            if (i == 2) {
                relativeLayout.setVisibility(0);
            } else {
                relativeLayout.setVisibility(8);
            }
        }
        if (i == 2) {
            com.baidu.platform.comapi.walknavi.b.a().A();
        } else {
            com.baidu.platform.comapi.walknavi.b.a().z();
        }
        TestScaleView testScaleView = this.E;
        if (testScaleView != null) {
            testScaleView.refresh();
        }
        com.baidu.platform.comapi.walknavi.g.b.c cVar = this.k;
        if (cVar != null) {
            cVar.a(i, z);
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

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public boolean c() {
        return this.j == null || this.i == null;
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void d() {
        this.p = false;
        if (com.baidu.platform.comapi.walknavi.b.a().J() != 4) {
            L();
        }
        com.baidu.platform.comapi.walknavi.g.b.c cVar = this.k;
        if (cVar != null) {
            cVar.d();
            this.k.c();
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

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public int g() {
        return (int) (com.baidu.platform.comapi.wnplatform.o.b.b.a().d() * 30.0f);
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public View h() {
        return this.j;
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void i() {
        Q();
    }

    public com.baidu.platform.comapi.walknavi.g.b.c k() {
        return this.k;
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void l() {
        Runnable runnable;
        com.baidu.platform.comapi.walknavi.g.b.c cVar = this.k;
        if (cVar != null) {
            cVar.e();
        }
        Handler handler = this.o;
        if (handler == null || (runnable = this.f9620g) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
        this.o.postDelayed(this.f9620g, 20000L);
    }

    public void m() {
        this.V.setVisibility(0);
        this.W.setVisibility(8);
        this.Z.setVisibility(8);
        this.aa.setVisibility(8);
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public int n() {
        FrameLayout frameLayout = this.r;
        if (frameLayout == null || this.A == null) {
            return 50;
        }
        return frameLayout.getHeight() + this.A.getHeight();
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void c(int i) {
        com.baidu.platform.comapi.walknavi.g.b.c cVar = this.k;
        if (cVar != null) {
            cVar.c(i);
        }
    }

    public void a(int i, boolean z) {
        e(i);
        if (i != 2) {
            if (i == 1) {
                this.Q.removeCallbacks(this.T);
                this.Q.removeCallbacks(this.S);
                b(i, z);
                return;
            }
            return;
        }
        com.baidu.platform.comapi.walknavi.b.a().H().b("WALKNAVI_FIRST_AR", false);
        if (!com.baidu.platform.comapi.walknavi.b.a().H().a("WALKNAVI_AR_HINT_HAS_SHOW", false)) {
            this.Q.postDelayed(this.T, 10000L);
        }
        if (!com.baidu.platform.comapi.walknavi.b.a().H().a("WALKNAVI_AR_ADJUST_HAS_SHOW", false)) {
            this.Q.postDelayed(this.S, StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD);
        }
        b(i, z);
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE);
        com.baidu.platform.comapi.walknavi.b.a().D().j();
        this.Q.postDelayed(new q(this), 500L);
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void c(Bundle bundle) {
        if (bundle.getInt("updatetype") == e.a.f9836c) {
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

    @Override // com.baidu.platform.comapi.wnplatform.h.b
    public void d(Message message) {
        com.baidu.platform.comapi.wnplatform.k.a.a().a("FootNaviPG.reRoute");
        if (!this.p) {
            com.baidu.platform.comapi.walknavi.b.a().F().run("收到偏航算路成功消息");
        }
        D();
        this.k.b(4);
        this.G.a(2130837587, "偏航规划成功");
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void e() {
        this.p = true;
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public int f() {
        return (int) (com.baidu.platform.comapi.wnplatform.o.b.b.a().d() * 155.0f);
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
            com.baidu.platform.comapi.walknavi.segmentbrowse.widget.g gVar = new com.baidu.platform.comapi.walknavi.segmentbrowse.widget.g(this.i, this);
            this.s = gVar;
            this.r.addView(gVar);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.c.a
    public void d(int i) {
        L();
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.b
    public void c(Message message) {
        this.k.b(3);
        this.G.a(2130837587, "偏航规划中...");
        com.baidu.platform.comapi.walknavi.b.a().C().a();
    }

    private void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.D.setText(str);
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

    /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(float f2, float f3) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (this.U == null) {
            return;
        }
        if (com.baidu.platform.comapi.walknavi.b.a().u() == 2) {
            boolean z5 = false;
            int i = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i == 0 && f3 == 0.0f) {
                this.U.setVisibility(8);
            } else {
                this.U.setVisibility(0);
            }
            boolean z6 = true;
            if (f2 < 0.0f) {
                f2 = 0.0f;
                z = false;
                z2 = true;
            } else if ((i < 0 || f2 >= I()) && f2 >= I()) {
                f2 = I();
                z = false;
                z2 = false;
                z3 = true;
                if (f3 >= p()) {
                    f3 = p();
                    z4 = false;
                } else {
                    if (f3 < 0.0f || f3 >= this.P) {
                        int i2 = this.P;
                        if (f3 > i2) {
                            f3 = i2;
                            z4 = true;
                            z6 = false;
                        }
                    }
                    z4 = false;
                    z5 = true;
                    z6 = false;
                }
                if (!z && z5) {
                    m();
                } else {
                    a(z2, z3, z6, z4);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.U.getLayoutParams();
                layoutParams.leftMargin = (int) f2;
                layoutParams.topMargin = (int) f3;
                this.U.setLayoutParams(layoutParams);
                return;
            } else {
                z = true;
                z2 = false;
            }
            z3 = false;
            if (f3 >= p()) {
            }
            if (!z) {
            }
            a(z2, z3, z6, z4);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.U.getLayoutParams();
            layoutParams2.leftMargin = (int) f2;
            layoutParams2.topMargin = (int) f3;
            this.U.setLayoutParams(layoutParams2);
            return;
        }
        this.U.setVisibility(8);
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void b(int i) {
        Runnable runnable;
        Handler handler = this.o;
        if (handler == null || (runnable = this.ae) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
        this.o.postDelayed(this.ae, i);
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void b(Bundle bundle) {
        int i = bundle.getInt("simpleUpdateType");
        if (i == e.a.f9834a || i == e.a.f9837d || !bundle.containsKey("enGuideType")) {
            return;
        }
        int i2 = bundle.getInt("enGuideType");
        int b2 = com.baidu.platform.comapi.walknavi.g.a.c.b(com.baidu.platform.comapi.wnplatform.h.c.a(RouteGuideKind.values()[i2]));
        if (i2 != 0) {
            String string = bundle.getString("usGuideText");
            if (("到达目的地".equals(string) || b2 == 2130837565 || b2 == 2130837566 || b2 == 2130837567) && com.baidu.platform.comapi.walknavi.b.a().l().isShowDialogWithExitNavi()) {
                z();
            }
            this.G.a(b2, string);
            this.G.d();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.b
    public void e(Message message) {
        y();
        if (com.baidu.platform.comapi.walknavi.b.a().l().isShowDialogWithExitNavi()) {
            z();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.b
    public void b(Message message) {
        com.baidu.platform.comapi.wnplatform.k.a.a().a("FootNaviPG.farAway");
        this.r.removeAllViews();
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.r();
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE);
        com.baidu.platform.comapi.walknavi.widget.d dVar = this.G;
        if (dVar != null) {
            dVar.a(2130837573, "您已偏离路线");
        }
    }

    public void a(boolean z, int i) {
        String b2;
        System.out.println("WalkUIController showQuitDialog");
        try {
            if (this.i != null && !this.i.isFinishing()) {
                com.baidu.platform.comapi.walknavi.widget.a b3 = new com.baidu.platform.comapi.walknavi.widget.a(this.i).a(true).b(com.baidu.platform.comapi.wnplatform.o.a.a.b(this.i, R.drawable.res_0x7f080004_avd_show_password__1));
                if (com.baidu.platform.comapi.walknavi.g.a.b.f9625a == 2) {
                    b2 = com.baidu.platform.comapi.wnplatform.o.a.a.b(this.i, R.drawable.res_0x7f080003_avd_show_password__0);
                } else {
                    b2 = com.baidu.platform.comapi.wnplatform.o.a.a.b(this.i, i);
                }
                this.l = b3.a(b2).d(com.baidu.platform.comapi.wnplatform.o.a.a.b(this.i, R.drawable.res_0x7f080000_avd_hide_password__0)).b().b(new e(this)).c(com.baidu.platform.comapi.wnplatform.o.a.a.b(this.i, R.drawable.res_0x7f080005_avd_show_password__2)).a(new d(this));
                if (z) {
                    CountDownTimerC0124a countDownTimerC0124a = new CountDownTimerC0124a(PassLoginUtil.f25013c, 1000L, this.i, this.l);
                    this.q = countDownTimerC0124a;
                    countDownTimerC0124a.start();
                }
                if (this.l.isShowing() || this.i == null || this.i.isFinishing()) {
                    return;
                }
                this.l.show();
                return;
            }
            com.baidu.platform.comapi.wnplatform.k.a.a().a("FootNaviPG.exitNavi");
            v();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
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

    private void b(String str) {
        if (this.C == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.C.setText(str);
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void a(com.baidu.platform.comapi.walknavi.g.b.a aVar) {
        this.n = aVar;
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void a(boolean z) {
        com.baidu.platform.comapi.walknavi.g.b.c cVar = this.k;
        if (cVar != null) {
            cVar.a(z);
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
    public void a(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length;
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void a(Bundle bundle) {
        double d2 = 0.0d;
        float f2 = 0.0f;
        try {
            this.I = bundle.getFloat("curSpeed");
            this.af = bundle.getInt("AddDist");
            d2 = new BigDecimal(bundle.getInt("AddDist") / 1000.0f).setScale(1, 4).doubleValue();
            f2 = bundle.getInt("RouteDist") / 1000.0f;
            float f3 = bundle.getFloat("calorie");
            com.baidu.platform.comapi.wnplatform.d.a.b("walk cal:" + f3 + "or:" + bundle.getFloat("calorie"));
            double doubleValue = new BigDecimal((double) f3).setScale(1, 4).doubleValue();
            if (this.k != null) {
                this.k.a((int) doubleValue);
            }
        } catch (Exception e2) {
            com.baidu.platform.comapi.wnplatform.d.a.b("exception" + e2.getMessage());
        }
        this.J = d2 / f2;
    }

    @Override // com.baidu.platform.comapi.wnplatform.c.a
    public void a(Message message) {
        if (message.arg1 == 0) {
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE);
            com.baidu.platform.comapi.walknavi.widget.d dVar = this.G;
            if (dVar != null) {
                dVar.a(2130837576, "");
                this.G.c();
            }
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void a() {
        com.baidu.platform.comapi.walknavi.b.a().D().i();
    }
}
