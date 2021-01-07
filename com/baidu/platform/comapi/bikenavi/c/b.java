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
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.walknavi.model.RouteGuideKind;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.platform.comapi.wnplatform.i.e;
import com.baidu.platform.comapi.wnplatform.p.g;
import com.baidu.tieba.R;
import java.math.BigDecimal;
/* loaded from: classes3.dex */
public class b extends com.baidu.platform.comapi.wnplatform.o.a {

    /* renamed from: a  reason: collision with root package name */
    LatLng f4200a;

    /* renamed from: b  reason: collision with root package name */
    LatLng f4201b;
    private View e;
    private Activity f;
    private com.baidu.platform.comapi.bikenavi.widget.a g;
    private com.baidu.platform.comapi.bikenavi.widget.h h;
    private com.baidu.platform.comapi.walknavi.widget.a i;
    private com.baidu.platform.comapi.walknavi.widget.a j;
    private boolean l;
    private long m;
    private double n;
    private com.baidu.platform.comapi.walknavi.g.c.a k = null;
    private Bitmap o = BitmapFactory.decodeResource(com.baidu.platform.comapi.wnplatform.p.a.a.b(), 2130837564);
    private BitmapDescriptor p = BitmapDescriptorFactory.fromBitmap(this.o);
    private Bitmap q = BitmapFactory.decodeResource(com.baidu.platform.comapi.wnplatform.p.a.a.b(), 2130837563);
    private BitmapDescriptor r = BitmapDescriptorFactory.fromBitmap(this.q);
    private Handler s = new Handler();
    private Runnable t = new c(this);
    final Runnable c = new d(this);
    final Runnable d = new e(this);
    private int u = -1;
    private a v = null;
    private com.baidu.platform.comapi.wnplatform.walkmap.c w = new k(this);

    public b(Activity activity) {
        this.f = activity;
        this.e = com.baidu.platform.comapi.wnplatform.p.a.a.a(activity, R.array.Mask_X006, null);
        w();
        v();
    }

    private void v() {
        int a2 = com.baidu.platform.comapi.walknavi.b.a().G().a();
        com.baidu.platform.comapi.wnplatform.d.a.a("yang10", "all size:" + a2);
        if (a2 > 2) {
            int[] iArr = new int[a2 - 2];
            int[] iArr2 = new int[a2 - 2];
            int[] iArr3 = new int[a2 - 2];
            com.baidu.platform.comapi.walknavi.b.a().G().b(iArr, iArr2, iArr3);
            com.baidu.platform.comapi.wnplatform.h.c.b().a(this.f, iArr, iArr2, iArr3);
        }
    }

    private void w() {
        com.baidu.platform.comapi.walknavi.b.a().J().a().getMap().addOverlay(new MarkerOptions().position(y()).icon(this.p).zIndex(9).draggable(false));
        com.baidu.platform.comapi.walknavi.b.a().J().a().getMap().addOverlay(new MarkerOptions().position(x()).icon(this.r).zIndex(9).draggable(false));
        this.g = new com.baidu.platform.comapi.bikenavi.widget.a(this.f, this, this.e);
        this.h = new com.baidu.platform.comapi.bikenavi.widget.h(this.f, this, this.e);
        a(this.f, com.baidu.platform.comapi.walknavi.b.a().J().a(), 70, 0, 0, 60);
    }

    private LatLng x() {
        if (this.f4201b == null) {
            this.f4201b = com.baidu.platform.comapi.walknavi.b.a().P();
        }
        return this.f4201b;
    }

    private LatLng y() {
        if (this.f4200a == null) {
            this.f4200a = com.baidu.platform.comapi.walknavi.b.a().O();
        }
        return this.f4200a;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public boolean c() {
        return this.e == null || this.f == null;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a, com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        B();
        z();
        return true;
    }

    private void z() {
        this.m = System.currentTimeMillis();
    }

    private void A() {
        if (this.o != null && !this.o.isRecycled()) {
            this.o.recycle();
            this.o = null;
        }
        if (this.q != null && !this.q.isRecycled()) {
            this.q.recycle();
            this.q = null;
        }
        if (this.p != null) {
            this.p.recycle();
            this.p = null;
        }
        if (this.r != null) {
            this.r.recycle();
            this.r = null;
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a, com.baidu.platform.comapi.walknavi.a
    public void release() {
        C();
        if (this.s != null) {
            this.s.removeCallbacks(this.c);
            this.s = null;
        }
        A();
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void d() {
        this.l = false;
        F();
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void e() {
        this.l = true;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public int f() {
        return (int) (com.baidu.platform.comapi.wnplatform.p.b.b.a().d() * 45.0f);
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public int g() {
        return com.baidu.platform.comapi.wnplatform.p.b.b.a().b() - ((int) (com.baidu.platform.comapi.wnplatform.p.b.b.a().d() * 30.0f));
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public View h() {
        return this.e;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void i() {
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public int j() {
        return 0;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void b(int i) {
        if (this.s != null && this.t != null) {
            this.s.removeCallbacks(this.t);
            this.s.postDelayed(this.t, i);
        }
    }

    public void k() {
        if (this.s != null && this.c != null) {
            this.s.removeCallbacks(this.c);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void l() {
        if (this.g != null) {
            this.g.e();
        }
        if (this.s != null && this.c != null) {
            this.s.removeCallbacks(this.c);
            this.s.postDelayed(this.c, 15000L);
        }
    }

    public void m() {
        if (this.s != null && this.d != null) {
            this.s.removeCallbacks(this.d);
            this.s.postDelayed(this.d, IMConnection.RETRY_DELAY_TIMES);
        }
    }

    /* loaded from: classes3.dex */
    public class a extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        Activity f4202a;

        /* renamed from: b  reason: collision with root package name */
        com.baidu.platform.comapi.walknavi.widget.a f4203b;

        public a(long j, long j2, Activity activity, com.baidu.platform.comapi.walknavi.widget.a aVar) {
            super(j, j2);
            this.f4202a = activity;
            this.f4203b = aVar;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            if (this.f4203b != null) {
                ((Button) this.f4203b.c()).setText("确定(" + ((j / 1000) - 1) + ")");
            }
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            b.this.q();
            if (this.f4202a != null && !this.f4202a.isFinishing()) {
                this.f4203b.dismiss();
            }
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public int n() {
        return 0;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void o() {
        if (this.s != null && this.t != null) {
            this.s.removeCallbacks(this.t);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void a(boolean z) {
        if (this.g != null) {
            this.g.a(z);
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void a(Bundle bundle) {
        try {
            double doubleValue = new BigDecimal((bundle.getFloat("curSpeed") * 3600.0f) / 1000.0f).setScale(1, 4).doubleValue();
            double doubleValue2 = new BigDecimal((bundle.getFloat("maxSpeed") * 3600.0f) / 1000.0f).setScale(1, 4).doubleValue();
            double doubleValue3 = new BigDecimal((bundle.getFloat("avgSpeed") * 3600.0f) / 1000.0f).setScale(1, 4).doubleValue();
            this.u = bundle.getInt("AddDist");
            double doubleValue4 = new BigDecimal(bundle.getInt("AddDist") / 1000.0f).setScale(1, 4).doubleValue();
            double doubleValue5 = new BigDecimal(bundle.getInt("RouteDist") / 1000.0f).setScale(1, 4).doubleValue();
            this.g.a(new BigDecimal(bundle.getFloat("realDistance")).setScale(1, 4).doubleValue(), bundle.getLong("secTime"));
            float f = bundle.getFloat("calorie");
            com.baidu.platform.comapi.wnplatform.d.a.b("bike cal:" + f + "or:" + bundle.getFloat("calorie"));
            double doubleValue6 = new BigDecimal(f).setScale(1, 4).doubleValue();
            float f2 = bundle.getFloat("altidiff");
            float f3 = bundle.getFloat("altitude");
            this.n = doubleValue4 / doubleValue5;
            this.g.a(doubleValue, doubleValue3, doubleValue2);
            this.g.a((float) doubleValue6, f2, f3);
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void c(int i) {
        if (this.g != null) {
            this.g.a(i);
        }
    }

    private void B() {
        com.baidu.platform.comapi.walknavi.b.a().F().a(this);
        com.baidu.platform.comapi.walknavi.b.a().H().a((com.baidu.platform.comapi.wnplatform.i.a) this);
        com.baidu.platform.comapi.walknavi.b.a().H().a((com.baidu.platform.comapi.wnplatform.i.b) this);
        com.baidu.platform.comapi.walknavi.b.a().S().a(this);
    }

    private void C() {
        com.baidu.platform.comapi.walknavi.b.a().F().a((com.baidu.platform.comapi.wnplatform.j.c) null);
        com.baidu.platform.comapi.walknavi.b.a().H().b((com.baidu.platform.comapi.wnplatform.i.a) null);
        com.baidu.platform.comapi.walknavi.b.a().H().b((com.baidu.platform.comapi.wnplatform.i.b) null);
        com.baidu.platform.comapi.walknavi.b.a().S().b((com.baidu.platform.comapi.wnplatform.c.a) null);
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.c
    public void a() {
        com.baidu.platform.comapi.walknavi.b.a().G().i();
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.c
    public void b() {
        com.baidu.platform.comapi.walknavi.b.a().J().a(1);
        D();
        com.baidu.platform.comapi.walknavi.b.a().G().h();
    }

    @Override // com.baidu.platform.comapi.wnplatform.j.c
    public void a(int i) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.c.a
    public void d(int i) {
        F();
    }

    @Override // com.baidu.platform.comapi.wnplatform.c.a
    public void a(Message message) {
        if (message.arg1 == 0) {
            com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE);
            if (this.h != null) {
                this.h.a(R.animator.design_fab_show_motion_spec, "GPS弱");
                this.h.c();
            }
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void b(Message message) {
        com.baidu.platform.comapi.wnplatform.l.a.a().a("BikeNaviPG.farAway");
        com.baidu.platform.comapi.wnplatform.d.a.a("yang13", "call onRouteFarAway");
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.o();
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.a(com.baidu.platform.comapi.walknavi.segmentbrowse.b.REFRESH_GUIDANCE);
        if (this.h != null) {
            this.h.a(R.animator.design_fab_hide_motion_spec, "已偏航");
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void c(Message message) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void d(Message message) {
        com.baidu.platform.comapi.wnplatform.l.a.a().a("BikeNaviPG.reRoute");
        com.baidu.platform.comapi.wnplatform.d.a.a("yang13", "call onReRouteComplete");
        if (!this.l) {
            com.baidu.platform.comapi.walknavi.b.a().I().run("收到偏航算路成功消息");
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void e(Message message) {
        p();
        m();
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void f(Message message) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.b
    public void g(Message message) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void b(Bundle bundle) {
        int i = bundle.getInt("simpleUpdateType");
        if (i != 0 && i != 3 && bundle.containsKey("enGuideType") && bundle.containsKey("nDistance2GP")) {
            int i2 = bundle.getInt("enGuideType");
            int a2 = com.baidu.platform.comapi.bikenavi.c.a.a(com.baidu.platform.comapi.wnplatform.i.c.b(RouteGuideKind.values()[i2]));
            int i3 = bundle.getInt("nDistance2GP");
            int i4 = ((i3 + 5) / 10) * 10;
            if ("到达目的地".equals(bundle.getString("usGuideText"))) {
                m();
            }
            StringBuilder sb = new StringBuilder();
            if (i2 != 0) {
                com.baidu.platform.comapi.wnplatform.d.a.b("update guidance type:" + i2 + "dis:" + i3);
                StringBuffer stringBuffer = new StringBuffer();
                com.baidu.platform.comapi.wnplatform.p.g.a(i4, g.b.ZH, stringBuffer);
                sb.append(stringBuffer.toString());
                int i5 = bundle.getInt("enSpliceType");
                if (i5 == 1) {
                    sb.append("前");
                } else if (i5 == 3) {
                    sb.append("后");
                }
                this.h.a(a2, sb.toString());
                this.h.d();
            }
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void c(Bundle bundle) {
        if (bundle.getInt("updatetype") == e.a.c) {
            int i = bundle.getInt("totaldist");
            int i2 = bundle.getInt("totaltime");
            StringBuffer stringBuffer = new StringBuffer();
            com.baidu.platform.comapi.wnplatform.p.g.a(i, g.b.ZH, stringBuffer);
            this.g.a(stringBuffer.toString(), com.baidu.platform.comapi.wnplatform.p.g.a(i2, 2));
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void a(Context context, View view, int i, int i2, int i3, int i4) {
        super.a(context, view, i, i2, i3, i4);
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void a(byte[] bArr) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void d(Bundle bundle) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void e(Bundle bundle) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.i.a
    public void f(Bundle bundle) {
    }

    private void D() {
    }

    public void p() {
        com.baidu.platform.comapi.wnplatform.l.a.a().a("FootNaviAutoComplete");
        if (this.g != null) {
            this.g.e();
        }
    }

    private void E() {
        int i = 0;
        int i2 = (int) (this.n * 100.0d);
        if (i2 >= 0 && i2 < 30) {
            com.baidu.platform.comapi.wnplatform.l.a.a().a(MapBundleKey.OfflineMapKey.OFFLINE_RATION, 0);
        } else if (i2 >= 30 && i2 < 50) {
            com.baidu.platform.comapi.wnplatform.l.a.a().a(MapBundleKey.OfflineMapKey.OFFLINE_RATION, 1);
        } else if (i2 >= 50 && i2 < 80) {
            com.baidu.platform.comapi.wnplatform.l.a.a().a(MapBundleKey.OfflineMapKey.OFFLINE_RATION, 2);
        } else if (i2 >= 80 && i2 <= 100) {
            com.baidu.platform.comapi.wnplatform.l.a.a().a(MapBundleKey.OfflineMapKey.OFFLINE_RATION, 3);
        }
        com.baidu.platform.comapi.wnplatform.l.a.a().a("BikeNaviPG.realDisAndTotalDisRatio");
        if (this.u < 0 || this.u > 1000) {
            if (this.u > 1000 && this.u <= 3000) {
                i = 1;
            } else if (this.u > 3000 && this.u <= 5000) {
                i = 2;
            } else if (this.u > 5000 && this.u <= 10000) {
                i = 3;
            } else if (this.u > 10000 && this.u <= 20000) {
                i = 4;
            } else if (this.u > 20000 && this.u <= 30000) {
                i = 5;
            } else if (this.u > 30000 && this.u <= 50000) {
                i = 6;
            } else if (this.u <= 50000) {
                i = -1;
            } else {
                i = 7;
            }
        }
        com.baidu.platform.comapi.wnplatform.l.a.a().a("distance", i);
        com.baidu.platform.comapi.wnplatform.l.a.a().a("BikeNaviPG.navDistance");
    }

    public void a(boolean z, int i) {
        String b2;
        try {
            if (this.f == null || this.f.isFinishing()) {
                com.baidu.platform.comapi.wnplatform.l.a.a().a("BikeNaviPG.exitNavi");
                t();
                return;
            }
            com.baidu.platform.comapi.walknavi.widget.a b3 = new com.baidu.platform.comapi.walknavi.widget.a(this.f).a(true).b(com.baidu.platform.comapi.wnplatform.p.a.a.b(this.f, R.drawable.res_0x7f080004_avd_show_password__1));
            if (com.baidu.platform.comapi.walknavi.g.b.b.f4504a == 2) {
                b2 = com.baidu.platform.comapi.wnplatform.p.a.a.b(this.f, i);
            } else {
                b2 = com.baidu.platform.comapi.wnplatform.p.a.a.b(this.f, i);
            }
            this.i = b3.a(b2).d(com.baidu.platform.comapi.wnplatform.p.a.a.b(this.f, R.drawable.res_0x7f080000_avd_hide_password__0)).b().b(new g(this)).c(com.baidu.platform.comapi.wnplatform.p.a.a.b(this.f, R.drawable.res_0x7f080005_avd_show_password__2)).a(new f(this));
            if (z) {
                this.v = new a(7000L, 1000L, this.f, this.i);
                this.v.start();
            }
            if (!this.i.isShowing() && this.f != null && !this.f.isFinishing()) {
                this.i.show();
            }
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void q() {
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.o();
        E();
        t();
        if (this.e != null) {
            ViewParent parent = this.e.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeAllViews();
            }
            this.e = null;
        }
        if (this.f != null && !this.f.isFinishing()) {
            this.f.finish();
        }
        this.f = null;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public float r() {
        return 0.0f;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void s() {
    }

    private void F() {
        if (!this.l) {
            if (!com.baidu.platform.comapi.walknavi.b.a().S().c()) {
                G();
            } else {
                H();
            }
        }
    }

    private void G() {
        try {
            if (this.j == null) {
                this.j = new com.baidu.platform.comapi.walknavi.widget.a(this.f).b(com.baidu.platform.comapi.wnplatform.p.a.a.b(this.f, R.drawable.res_0x7f080004_avd_show_password__1)).a(com.baidu.platform.comapi.wnplatform.p.a.a.b(this.f, R.drawable.res_0x7f080006_ic_icon_mask_broadcast_svg__0)).c(com.baidu.platform.comapi.wnplatform.p.a.a.b(this.f, R.drawable.res_0x7f080007_ic_icon_mask_card_ba20_svg__0)).a().a(new i(this)).d(com.baidu.platform.comapi.wnplatform.p.a.a.b(this.f, R.drawable.res_0x7f080005_avd_show_password__2)).b(new h(this));
                this.j.setOnCancelListener(new j(this));
            }
            if (this.f != null && !this.f.isFinishing()) {
                this.j.show();
            }
        } catch (Exception e) {
        }
    }

    private void H() {
        if (this.j != null && this.f != null && !this.f.isFinishing()) {
            if (this.j.isShowing()) {
                this.j.dismiss();
            }
            this.j = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        com.baidu.platform.comapi.walknavi.segmentbrowse.c.o();
        if (this.f != null) {
            com.baidu.platform.comapi.walknavi.g.d.c.a(this.f, com.baidu.platform.comapi.wnplatform.p.a.a.b(this.f, R.drawable.res_0x7f080008_ic_icon_mask_first24__0));
        }
        t();
    }

    public void t() {
        com.baidu.platform.comapi.wnplatform.d.a.a("yang13", "call quitNavWhenConfirm:" + this.k);
        if (this.k != null) {
            this.k.B();
        }
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void a(com.baidu.platform.comapi.walknavi.g.c.a aVar) {
        this.k = aVar;
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public void a(String str) {
    }

    @Override // com.baidu.platform.comapi.wnplatform.o.a
    public Handler u() {
        return null;
    }
}
