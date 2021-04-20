package com.baidu.platform.comapi.bikenavi.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.walknavi.model.RouteGuideKind;
import com.baidu.platform.comapi.wnplatform.h.e;
import com.baidu.platform.comapi.wnplatform.o.f;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.R;
import com.baidu.wallet.passport.PassLoginUtil;
import java.math.BigDecimal;
/* loaded from: classes2.dex */
public class b extends com.baidu.platform.comapi.wnplatform.n.a {

    /* renamed from: a  reason: collision with root package name */
    public LatLng f9388a;

    /* renamed from: b  reason: collision with root package name */
    public LatLng f9389b;

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f9390c;

    /* renamed from: d  reason: collision with root package name */
    public final Runnable f9391d;

    /* renamed from: e  reason: collision with root package name */
    public View f9392e;

    /* renamed from: f  reason: collision with root package name */
    public Activity f9393f;

    /* renamed from: g  reason: collision with root package name */
    public com.baidu.platform.comapi.bikenavi.widget.a f9394g;

    /* renamed from: h  reason: collision with root package name */
    public com.baidu.platform.comapi.bikenavi.widget.g f9395h;
    public com.baidu.platform.comapi.walknavi.widget.a i;
    public com.baidu.platform.comapi.walknavi.widget.a j;
    public com.baidu.platform.comapi.walknavi.g.b.a k = null;
    public boolean l;
    public long m;
    public double n;
    public Bitmap o;
    public BitmapDescriptor p;
    public Bitmap q;
    public BitmapDescriptor r;
    public Handler s;
    public Runnable t;
    public int u;
    public a v;
    public com.baidu.platform.comapi.wnplatform.walkmap.c w;

    /* loaded from: classes2.dex */
    public class a extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        public Activity f9396a;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.platform.comapi.walknavi.widget.a f9397b;

        public a(long j, long j2, Activity activity, com.baidu.platform.comapi.walknavi.widget.a aVar) {
            super(j, j2);
            this.f9396a = activity;
            this.f9397b = aVar;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            b.this.q();
            Activity activity = this.f9396a;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            this.f9397b.dismiss();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            com.baidu.platform.comapi.walknavi.widget.a aVar = this.f9397b;
            if (aVar != null) {
                ((Button) aVar.c()).setText("确定(" + ((j / 1000) - 1) + SmallTailInfo.EMOTION_SUFFIX);
            }
        }
    }

    public b(Activity activity) {
        Bitmap decodeResource = BitmapFactory.decodeResource(com.baidu.platform.comapi.wnplatform.o.a.a.b(), 2130837564);
        this.o = decodeResource;
        this.p = BitmapDescriptorFactory.fromBitmap(decodeResource);
        Bitmap decodeResource2 = BitmapFactory.decodeResource(com.baidu.platform.comapi.wnplatform.o.a.a.b(), 2130837563);
        this.q = decodeResource2;
        this.r = BitmapDescriptorFactory.fromBitmap(decodeResource2);
        this.s = new Handler();
        this.t = new c(this);
        this.f9390c = new d(this);
        this.f9391d = new e(this);
        this.u = -1;
        this.v = null;
        this.w = new k(this);
        this.f9393f = activity;
        this.f9392e = com.baidu.platform.comapi.wnplatform.o.a.a.a(activity, R.array.Mask_X004, null);
        v();
        u();
    }

    private void A() {
        com.baidu.platform.comapi.walknavi.b.a().C().a(this);
        com.baidu.platform.comapi.walknavi.b.a().E().a((com.baidu.platform.comapi.wnplatform.h.a) this);
        com.baidu.platform.comapi.walknavi.b.a().E().a((com.baidu.platform.comapi.wnplatform.h.b) this);
        com.baidu.platform.comapi.walknavi.b.a().P().a(this);
    }

    private void B() {
        com.baidu.platform.comapi.walknavi.b.a().C().a((com.baidu.platform.comapi.wnplatform.i.a) null);
        com.baidu.platform.comapi.walknavi.b.a().E().b((com.baidu.platform.comapi.wnplatform.h.a) null);
        com.baidu.platform.comapi.walknavi.b.a().E().b((com.baidu.platform.comapi.wnplatform.h.b) null);
        com.baidu.platform.comapi.walknavi.b.a().P().b((com.baidu.platform.comapi.wnplatform.c.a) null);
    }

    private void C() {
    }

    private void D() {
        int i = (int) (this.n * 100.0d);
        int i2 = 3;
        if (i >= 0 && i < 30) {
            com.baidu.platform.comapi.wnplatform.k.a.a().a("ratio", 0);
        } else if (i >= 30 && i < 50) {
            com.baidu.platform.comapi.wnplatform.k.a.a().a("ratio", 1);
        } else if (i >= 50 && i < 80) {
            com.baidu.platform.comapi.wnplatform.k.a.a().a("ratio", 2);
        } else if (i >= 80 && i <= 100) {
            com.baidu.platform.comapi.wnplatform.k.a.a().a("ratio", 3);
        }
        com.baidu.platform.comapi.wnplatform.k.a.a().a("BikeNaviPG.realDisAndTotalDisRatio");
        int i3 = this.u;
        if (i3 < 0 || i3 > 1000) {
            int i4 = this.u;
            if (i4 <= 1000 || i4 > 3000) {
                int i5 = this.u;
                if (i5 <= 3000 || i5 > 5000) {
                    int i6 = this.u;
                    if (i6 <= 5000 || i6 > 10000) {
                        int i7 = this.u;
                        if (i7 <= 10000 || i7 > 20000) {
                            int i8 = this.u;
                            if (i8 <= 20000 || i8 > 30000) {
                                int i9 = this.u;
                                if (i9 <= 30000 || i9 > 50000) {
                                    i2 = this.u > 50000 ? 7 : -1;
                                } else {
                                    i2 = 6;
                                }
                            } else {
                                i2 = 5;
                            }
                        } else {
                            i2 = 4;
                        }
                    }
                } else {
                    i2 = 2;
                }
            } else {
                i2 = 1;
            }
        } else {
            i2 = 0;
        }
        com.baidu.platform.comapi.wnplatform.k.a.a().a("distance", i2);
        com.baidu.platform.comapi.wnplatform.k.a.a().a("BikeNaviPG.navDistance");
    }

    private void E() {
        if (this.l) {
            return;
        }
        if (!com.baidu.platform.comapi.walknavi.b.a().P().c()) {
            F();
        } else {
            G();
        }
    }

    private void F() {
        try {
            if (this.j == null) {
                com.baidu.platform.comapi.walknavi.widget.a b2 = new com.baidu.platform.comapi.walknavi.widget.a(this.f9393f).b(com.baidu.platform.comapi.wnplatform.o.a.a.b(this.f9393f, R.drawable.res_0x7f080004_avd_show_password__1)).a(com.baidu.platform.comapi.wnplatform.o.a.a.b(this.f9393f, R.drawable.res_0x7f080006_ic_icon_mask_broadcast_svg__0)).c(com.baidu.platform.comapi.wnplatform.o.a.a.b(this.f9393f, R.drawable.res_0x7f080007_ic_icon_mask_card_ba20_svg__0)).a().a(new i(this)).d(com.baidu.platform.comapi.wnplatform.o.a.a.b(this.f9393f, R.drawable.res_0x7f080005_avd_show_password__2)).b(new h(this));
                this.j = b2;
                b2.setOnCancelListener(new j(this));
            }
            if (this.f9393f == null || this.f9393f.isFinishing()) {
                return;
            }
            this.j.show();
        } catch (Exception unused) {
        }
    }

    private void G() {
        Activity activity;
        if (this.j == null || (activity = this.f9393f) == null || activity.isFinishing()) {
            return;
        }
        if (this.j.isShowing()) {
            this.j.dismiss();
        }
        this.j = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.r();
        Activity activity = this.f9393f;
        if (activity != null) {
            com.baidu.platform.comapi.walknavi.g.c.c.a(activity, com.baidu.platform.comapi.wnplatform.o.a.a.b(activity, R.drawable.res_0x7f080008_ic_icon_mask_first24__0));
        }
        s();
    }

    private void u() {
        int a2 = com.baidu.platform.comapi.walknavi.b.a().D().a();
        com.baidu.platform.comapi.wnplatform.d.a.a("yang10", "all size:" + a2);
        if (a2 > 2) {
            int i = a2 - 2;
            int[] iArr = new int[i];
            int[] iArr2 = new int[i];
            int[] iArr3 = new int[i];
            com.baidu.platform.comapi.walknavi.b.a().D().b(iArr, iArr2, iArr3);
            com.baidu.platform.comapi.wnplatform.g.c.b().a(this.f9393f, iArr, iArr2, iArr3);
        }
    }

    private void v() {
        com.baidu.platform.comapi.walknavi.b.a().G().a().getMap().addOverlay(new MarkerOptions().position(x()).icon(this.p).zIndex(9).draggable(false));
        com.baidu.platform.comapi.walknavi.b.a().G().a().getMap().addOverlay(new MarkerOptions().position(w()).icon(this.r).zIndex(9).draggable(false));
        this.f9394g = new com.baidu.platform.comapi.bikenavi.widget.a(this.f9393f, this, this.f9392e);
        this.f9395h = new com.baidu.platform.comapi.bikenavi.widget.g(this.f9393f, this, this.f9392e);
        a(this.f9393f, com.baidu.platform.comapi.walknavi.b.a().G().a(), 70, 0, 0, 60);
    }

    private LatLng w() {
        if (this.f9389b == null) {
            this.f9389b = com.baidu.platform.comapi.walknavi.b.a().N();
        }
        return this.f9389b;
    }

    private LatLng x() {
        if (this.f9388a == null) {
            this.f9388a = com.baidu.platform.comapi.walknavi.b.a().M();
        }
        return this.f9388a;
    }

    private void y() {
        this.m = System.currentTimeMillis();
    }

    private void z() {
        Bitmap bitmap = this.o;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.o.recycle();
            this.o = null;
        }
        Bitmap bitmap2 = this.q;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.q.recycle();
            this.q = null;
        }
        BitmapDescriptor bitmapDescriptor = this.p;
        if (bitmapDescriptor != null) {
            bitmapDescriptor.recycle();
            this.p = null;
        }
        BitmapDescriptor bitmapDescriptor2 = this.r;
        if (bitmapDescriptor2 != null) {
            bitmapDescriptor2.recycle();
            this.r = null;
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void a(int i) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void a(String str) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void a(byte[] bArr) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.b
    public void c(Message message) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void d() {
        this.l = false;
        E();
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void d(Bundle bundle) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void e() {
        this.l = true;
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void e(Bundle bundle) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public int f() {
        return (int) (com.baidu.platform.comapi.wnplatform.o.b.b.a().d() * 45.0f);
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void f(Bundle bundle) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.b
    public void f(Message message) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public int g() {
        return com.baidu.platform.comapi.wnplatform.o.b.b.a().b() - ((int) (com.baidu.platform.comapi.wnplatform.o.b.b.a().d() * 30.0f));
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public View h() {
        return this.f9392e;
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void i() {
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public int j() {
        return 0;
    }

    public void k() {
        Runnable runnable;
        Handler handler = this.s;
        if (handler == null || (runnable = this.f9390c) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void l() {
        Runnable runnable;
        com.baidu.platform.comapi.bikenavi.widget.a aVar = this.f9394g;
        if (aVar != null) {
            aVar.e();
        }
        Handler handler = this.s;
        if (handler == null || (runnable = this.f9390c) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
        this.s.postDelayed(this.f9390c, 15000L);
    }

    public void m() {
        Runnable runnable;
        Handler handler = this.s;
        if (handler == null || (runnable = this.f9391d) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
        this.s.postDelayed(this.f9391d, 3000L);
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public int n() {
        return 0;
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void o() {
        Runnable runnable;
        Handler handler = this.s;
        if (handler == null || (runnable = this.t) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }

    public void p() {
        com.baidu.platform.comapi.wnplatform.k.a.a().a("FootNaviAutoComplete");
        com.baidu.platform.comapi.bikenavi.widget.a aVar = this.f9394g;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void q() {
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.r();
        D();
        s();
        View view = this.f9392e;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeAllViews();
            }
            this.f9392e = null;
        }
        Activity activity = this.f9393f;
        if (activity != null && !activity.isFinishing()) {
            this.f9393f.finish();
        }
        this.f9393f = null;
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public float r() {
        return 0.0f;
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a, com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        A();
        y();
        return true;
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a, com.baidu.platform.comapi.walknavi.a
    public void release() {
        B();
        Handler handler = this.s;
        if (handler != null) {
            handler.removeCallbacks(this.f9390c);
            this.s = null;
        }
        z();
    }

    public void s() {
        com.baidu.platform.comapi.wnplatform.d.a.a("yang13", "call quitNavWhenConfirm:" + this.k);
        com.baidu.platform.comapi.walknavi.g.b.a aVar = this.k;
        if (aVar != null) {
            aVar.y();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public Handler t() {
        return null;
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void a(boolean z) {
        com.baidu.platform.comapi.bikenavi.widget.a aVar = this.f9394g;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void b(int i) {
        Runnable runnable;
        Handler handler = this.s;
        if (handler == null || (runnable = this.t) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
        this.s.postDelayed(this.t, i);
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public boolean c() {
        return this.f9392e == null || this.f9393f == null;
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.b
    public void e(Message message) {
        p();
        m();
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void c(int i) {
        com.baidu.platform.comapi.bikenavi.widget.a aVar = this.f9394g;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.c.a
    public void d(int i) {
        E();
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void a(Bundle bundle) {
        try {
            double doubleValue = new BigDecimal((bundle.getFloat("curSpeed") * 3600.0f) / 1000.0f).setScale(1, 4).doubleValue();
            double doubleValue2 = new BigDecimal((bundle.getFloat("maxSpeed") * 3600.0f) / 1000.0f).setScale(1, 4).doubleValue();
            double doubleValue3 = new BigDecimal((bundle.getFloat("avgSpeed") * 3600.0f) / 1000.0f).setScale(1, 4).doubleValue();
            this.u = bundle.getInt("AddDist");
            double doubleValue4 = new BigDecimal(bundle.getInt("AddDist") / 1000.0f).setScale(1, 4).doubleValue();
            double doubleValue5 = new BigDecimal(bundle.getInt("RouteDist") / 1000.0f).setScale(1, 4).doubleValue();
            this.f9394g.a(new BigDecimal(bundle.getFloat("realDistance")).setScale(1, 4).doubleValue(), bundle.getLong("secTime"));
            float f2 = bundle.getFloat("calorie");
            com.baidu.platform.comapi.wnplatform.d.a.b("bike cal:" + f2 + "or:" + bundle.getFloat("calorie"));
            double doubleValue6 = new BigDecimal((double) f2).setScale(1, 4).doubleValue();
            float f3 = bundle.getFloat("altidiff");
            float f4 = bundle.getFloat("altitude");
            this.n = doubleValue4 / doubleValue5;
            this.f9394g.a(doubleValue, doubleValue3, doubleValue2);
            this.f9394g.a((float) doubleValue6, f3, f4);
        } catch (Exception unused) {
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.b
    public void d(Message message) {
        com.baidu.platform.comapi.wnplatform.k.a.a().a("BikeNaviPG.reRoute");
        com.baidu.platform.comapi.wnplatform.d.a.a("yang13", "call onReRouteComplete");
        if (this.l) {
            return;
        }
        com.baidu.platform.comapi.walknavi.b.a().F().run("收到偏航算路成功消息");
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void b() {
        com.baidu.platform.comapi.walknavi.b.a().G().a(1);
        C();
        com.baidu.platform.comapi.walknavi.b.a().D().h();
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void c(Bundle bundle) {
        if (bundle.getInt("updatetype") == e.a.f9836c) {
            int i = bundle.getInt("totaldist");
            int i2 = bundle.getInt("totaltime");
            StringBuffer stringBuffer = new StringBuffer();
            com.baidu.platform.comapi.wnplatform.o.f.a(i, f.a.ZH, stringBuffer);
            this.f9394g.a(stringBuffer.toString(), com.baidu.platform.comapi.wnplatform.o.f.a(i2, 2));
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.b
    public void b(Message message) {
        com.baidu.platform.comapi.wnplatform.k.a.a().a("BikeNaviPG.farAway");
        com.baidu.platform.comapi.wnplatform.d.a.a("yang13", "call onRouteFarAway");
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.r();
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE);
        com.baidu.platform.comapi.bikenavi.widget.g gVar = this.f9395h;
        if (gVar != null) {
            gVar.a(R.animator.design_fab_hide_motion_spec, "已偏航");
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.h.a
    public void b(Bundle bundle) {
        int i = bundle.getInt("simpleUpdateType");
        if (i == 0 || i == 3 || !bundle.containsKey("enGuideType") || !bundle.containsKey("nDistance2GP")) {
            return;
        }
        int i2 = bundle.getInt("enGuideType");
        int a2 = com.baidu.platform.comapi.bikenavi.c.a.a(com.baidu.platform.comapi.wnplatform.h.c.b(RouteGuideKind.values()[i2]));
        int i3 = bundle.getInt("nDistance2GP");
        int i4 = ((i3 + 5) / 10) * 10;
        if ("到达目的地".equals(bundle.getString("usGuideText"))) {
            m();
        }
        StringBuilder sb = new StringBuilder();
        if (i2 != 0) {
            com.baidu.platform.comapi.wnplatform.d.a.b("update guidance type:" + i2 + "dis:" + i3);
            StringBuffer stringBuffer = new StringBuffer();
            com.baidu.platform.comapi.wnplatform.o.f.a(i4, f.a.ZH, stringBuffer);
            sb.append(stringBuffer.toString());
            int i5 = bundle.getInt("enSpliceType");
            if (i5 == 1) {
                sb.append("前");
            } else if (i5 == 3) {
                sb.append("后");
            }
            this.f9395h.a(a2, sb.toString());
            this.f9395h.d();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void a() {
        com.baidu.platform.comapi.walknavi.b.a().D().i();
    }

    @Override // com.baidu.platform.comapi.wnplatform.c.a
    public void a(Message message) {
        if (message.arg1 == 0) {
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE);
            com.baidu.platform.comapi.bikenavi.widget.g gVar = this.f9395h;
            if (gVar != null) {
                gVar.a(R.animator.design_fab_show_motion_spec, "GPS弱");
                this.f9395h.c();
            }
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void a(Context context, View view, int i, int i2, int i3, int i4) {
        super.a(context, view, i, i2, i3, i4);
    }

    public void a(boolean z, int i) {
        String b2;
        try {
            if (this.f9393f != null && !this.f9393f.isFinishing()) {
                com.baidu.platform.comapi.walknavi.widget.a b3 = new com.baidu.platform.comapi.walknavi.widget.a(this.f9393f).a(true).b(com.baidu.platform.comapi.wnplatform.o.a.a.b(this.f9393f, R.drawable.res_0x7f080004_avd_show_password__1));
                if (com.baidu.platform.comapi.walknavi.g.a.b.f9625a == 2) {
                    b2 = com.baidu.platform.comapi.wnplatform.o.a.a.b(this.f9393f, i);
                } else {
                    b2 = com.baidu.platform.comapi.wnplatform.o.a.a.b(this.f9393f, i);
                }
                this.i = b3.a(b2).d(com.baidu.platform.comapi.wnplatform.o.a.a.b(this.f9393f, R.drawable.res_0x7f080000_avd_hide_password__0)).b().b(new g(this)).c(com.baidu.platform.comapi.wnplatform.o.a.a.b(this.f9393f, R.drawable.res_0x7f080005_avd_show_password__2)).a(new f(this));
                if (z) {
                    a aVar = new a(PassLoginUtil.f25013c, 1000L, this.f9393f, this.i);
                    this.v = aVar;
                    aVar.start();
                }
                if (this.i.isShowing() || this.f9393f == null || this.f9393f.isFinishing()) {
                    return;
                }
                this.i.show();
                return;
            }
            com.baidu.platform.comapi.wnplatform.k.a.a().a("BikeNaviPG.exitNavi");
            s();
        } catch (Exception unused) {
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.n.a
    public void a(com.baidu.platform.comapi.walknavi.g.b.a aVar) {
        this.k = aVar;
    }
}
