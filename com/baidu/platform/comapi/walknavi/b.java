package com.baidu.platform.comapi.walknavi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.ActivityChooserView;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mapapi.bikenavi.adapter.IBNaviStatusListener;
import com.baidu.mapapi.bikenavi.adapter.IBRouteGuidanceListener;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.MapBound;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.mapapi.walknavi.adapter.IWNaviStatusListener;
import com.baidu.mapapi.walknavi.adapter.IWRouteGuidanceListener;
import com.baidu.platform.comapi.walknavi.fsm.WGuideFSM;
import com.baidu.platform.comapi.wnplatform.o.k;
import com.baidu.platform.comjni.jninative.tts.WNaviTTSPlayer;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.element.MarkerModel;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b implements com.baidu.platform.comapi.walknavi.g.b.a {
    public static int a = 0;
    public static int b = 1;
    public static int c = 2;
    private LatLng A;
    private LatLng B;
    private Point C;
    private int D;
    private int E;
    private int F;
    private final BroadcastReceiver G;
    private com.baidu.platform.comapi.walknavi.c.b d;
    private com.baidu.platform.comapi.wnplatform.i.b e;
    private com.baidu.platform.comapi.wnplatform.a.a f;
    private com.baidu.platform.comapi.wnplatform.h.e g;
    private WGuideFSM h;
    private com.baidu.platform.comapi.wnplatform.walkmap.d i;
    private com.baidu.platform.comapi.walknavi.a.a j;
    private k k;
    private com.baidu.platform.comapi.wnplatform.m.a l;
    private com.baidu.platform.comapi.wnplatform.j.c m;
    private com.baidu.platform.comapi.wnplatform.b.c n;
    private com.baidu.platform.comapi.wnplatform.d.b o;
    private com.baidu.platform.comapi.wnplatform.n.a p;
    private com.baidu.platform.comapi.wnplatform.l.a q;
    private com.baidu.platform.comapi.wnplatform.f.b r;
    private IWNaviStatusListener s;
    private IBNaviStatusListener t;
    private int u;
    private int v;
    private Bundle w;
    private Context x;
    private Handler y;
    private int z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a {
        static final b a = new b(null);
    }

    /* synthetic */ b(c cVar) {
        this();
    }

    public static b a() {
        return a.a;
    }

    private b() {
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = 0;
        this.v = 0;
        this.w = new Bundle();
        this.y = new Handler();
        this.D = -1;
        this.E = -1;
        this.G = new g(this);
    }

    public boolean b() {
        SensorManager sensorManager;
        List<Sensor> sensorList;
        Iterator<Sensor> it;
        boolean z;
        Context a2 = com.baidu.platform.comapi.wnplatform.o.b.a.a();
        if (a2 == null || (sensorManager = (SensorManager) a2.getSystemService("sensor")) == null || (sensorList = sensorManager.getSensorList(-1)) == null || (it = sensorList.iterator()) == null) {
            return true;
        }
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else if (it.next().getType() == 11) {
                z = true;
                break;
            }
        }
        return z;
    }

    public boolean c() {
        SensorManager sensorManager;
        List<Sensor> sensorList;
        Context a2 = com.baidu.platform.comapi.wnplatform.o.b.a.a();
        if (a2 == null || (sensorManager = (SensorManager) a2.getSystemService("sensor")) == null || (sensorList = sensorManager.getSensorList(-1)) == null) {
            return false;
        }
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (Sensor sensor : sensorList) {
            int type = sensor.getType();
            if (type == 11) {
                z3 = true;
            } else if (type == 1) {
                z2 = true;
            } else if (type == 2) {
                z = true;
            }
        }
        return z3 || (z2 && z);
    }

    public void a(int i, int i2) {
        com.baidu.platform.comapi.wnplatform.a.a().a(i);
        com.baidu.platform.comapi.wnplatform.a.a().b(i2);
        a(i);
        V();
    }

    public Context d() {
        return this.x;
    }

    public void e() {
        B().b(6);
        if (o() == 1) {
            B().a(1);
        } else if (o() == 2) {
            B().a(0);
        }
        if (this.p != null) {
            J().a(this.x, this.p.r());
            this.p.a(this);
            this.p.d();
        }
        A().runCurrentState();
    }

    public void a(Activity activity, IWRouteGuidanceListener iWRouteGuidanceListener) {
        a(activity).a(iWRouteGuidanceListener);
    }

    public void a(Activity activity, IBRouteGuidanceListener iBRouteGuidanceListener) {
        a(activity).a(iBRouteGuidanceListener);
    }

    public com.baidu.platform.comapi.wnplatform.f.b a(Activity activity) {
        if (this.r == null) {
            this.r = new com.baidu.platform.comapi.wnplatform.f.b(activity);
        }
        return this.r;
    }

    public void f() {
        if (this.m != null) {
            this.m.a();
        }
        if (this.p != null) {
            this.p.a((com.baidu.platform.comapi.walknavi.g.b.a) null);
            this.p.e();
        }
    }

    public void a(Context context, long j, com.baidu.platform.comapi.walknavi.c.a aVar) {
        if (this.d == null) {
            this.d = new com.baidu.platform.comapi.walknavi.c.b();
        }
        this.v = 1;
        this.d.a(context, j, aVar);
    }

    public void g() {
        if (this.d != null) {
            this.d.release();
        }
    }

    public boolean h() {
        return this.d != null && this.d.a() > 0;
    }

    public RelativeLayout i() {
        if (this.p == null || !(this.p instanceof com.baidu.platform.comapi.walknavi.g.a)) {
            return null;
        }
        return ((com.baidu.platform.comapi.walknavi.g.a) this.p).k();
    }

    public boolean a(long j) {
        if (this.d == null) {
            return false;
        }
        return this.d.a(j);
    }

    public void j() {
        this.d.b();
    }

    public void a(Context context, MapView mapView) {
        B().a(context, mapView);
    }

    public void k() {
        B().b();
    }

    public View b(Activity activity) {
        if (com.baidu.platform.comapi.wnplatform.a.a().b() == 0) {
            if (this.p == null) {
                this.p = new com.baidu.platform.comapi.walknavi.g.a(activity);
            }
        } else if (com.baidu.platform.comapi.wnplatform.a.a().b() == 1 && this.p == null) {
            this.p = new com.baidu.platform.comapi.bikenavi.c.b(activity);
        }
        return this.p.h();
    }

    public void a(com.baidu.platform.comapi.wnplatform.i.a aVar) {
        x().a(aVar);
    }

    public void a(com.baidu.platform.comapi.wnplatform.d.a.a aVar) {
        if (this.n != null && aVar != null) {
            this.n.a(aVar);
        }
    }

    public void a(com.baidu.platform.comapi.wnplatform.m.c cVar) {
        D().a(cVar);
    }

    public boolean a(Activity activity, Bundle bundle) {
        boolean a2;
        y().p();
        this.x = activity;
        if (bundle != null) {
            com.baidu.platform.comapi.walknavi.g.a.b.a = bundle.getInt("wnavi_mode", 1);
        } else {
            com.baidu.platform.comapi.walknavi.g.a.b.a = 1;
        }
        if (a().E() != 4) {
            if (D() != null) {
                D().ready();
            }
            if (com.baidu.platform.comapi.wnplatform.a.a().b() == 0) {
                a2 = a().C().a("WALKNAVI_VOICE_ON_OFF", true);
            } else {
                a2 = com.baidu.platform.comapi.wnplatform.a.a().b() == 1 ? a().C().a("BIKENAVI_VOICE_ON_OFF", true) : true;
            }
            if (a2) {
                WNaviTTSPlayer.resumeVoiceTTSOutput();
            } else {
                WNaviTTSPlayer.pauseVoiceTTSOutput();
            }
        } else {
            WNaviTTSPlayer.pauseVoiceTTSOutput();
        }
        B().ready();
        if (this.p == null) {
            if (com.baidu.platform.comapi.wnplatform.a.a().b() == 0) {
                this.p = new com.baidu.platform.comapi.walknavi.g.a(activity);
            } else if (com.baidu.platform.comapi.wnplatform.a.a().b() == 1) {
                this.p = new com.baidu.platform.comapi.bikenavi.c.b(activity);
            }
        }
        if (this.p.c()) {
            return false;
        }
        this.p.ready();
        u();
        if (a().E() != 4) {
            K().a(this.x);
        }
        z().ready();
        x().ready();
        if (this.C != null) {
            a().y().a(this.C.getmPtx(), this.C.getmPty(), 0);
        }
        m();
        if (com.baidu.platform.comapi.walknavi.g.a.b.a == 1) {
            K().b(activity);
        } else if (com.baidu.platform.comapi.walknavi.g.a.b.a == 3) {
            N().ready();
        }
        a((Context) activity);
        W();
        B().c();
        this.v = 2;
        T();
        S();
        if (com.baidu.platform.comapi.wnplatform.a.a().b() == 0) {
            a().a(1, true);
        } else if (com.baidu.platform.comapi.wnplatform.a.a().b() == 1) {
            a().d(0);
            this.F = 1;
        }
        R();
        B().a().getMap().setBaiduHeatMapEnabled(false);
        B().a().getMap().setTrafficEnabled(false);
        B().a().getMap().getUiSettings().setAllGesturesEnabled(true);
        return true;
    }

    private void R() {
        com.baidu.platform.comapi.wnplatform.walkmap.d B = a().B();
        if (B != null && B.a() != null) {
            B.a().getMap().setIndoorEnable(false);
        }
    }

    private void S() {
        if (com.baidu.platform.comapi.wnplatform.a.a().b() == 0) {
            if (a().C().a("WALKNAVI_THREED_MAP_ON_OFF", true)) {
                a().b(-50);
            } else {
                a().b(0);
            }
        }
    }

    private void T() {
        if (this.x != null) {
            AudioManager audioManager = (AudioManager) this.x.getSystemService("audio");
            int streamVolume = audioManager.getStreamVolume(3);
            int streamMaxVolume = audioManager.getStreamMaxVolume(3);
            com.baidu.platform.comapi.wnplatform.c.a.a("yang10", "currentVolume:" + streamVolume);
            com.baidu.platform.comapi.wnplatform.c.a.a("yang10", "max:" + streamMaxVolume);
            if (streamVolume < streamMaxVolume / 2) {
                audioManager.setStreamVolume(3, streamMaxVolume / 2, 0);
            }
        }
    }

    public boolean l() {
        if (this.v < 2) {
            return false;
        }
        MapStatus h = B().h();
        this.v = 3;
        this.p.i();
        B().a(1);
        y().d(U());
        if (com.baidu.platform.comapi.walknavi.g.a.b.a != 4) {
            y().g();
        }
        a().y().a(true);
        B().a(h);
        if (com.baidu.platform.comapi.walknavi.g.a.b.a == 4) {
            y().j();
            return true;
        }
        this.y.postDelayed(new c(this), 500L);
        return true;
    }

    public void m() {
        y().o();
    }

    public int n() {
        return this.D;
    }

    public void a(int i) {
        y().g(i);
    }

    public void a(Bundle bundle) {
        y().b(bundle);
    }

    public void a(int i, String str) {
        this.y.postDelayed(new d(this, str), i);
    }

    public void a(IWNaviStatusListener iWNaviStatusListener) {
        this.s = iWNaviStatusListener;
    }

    public void a(IBNaviStatusListener iBNaviStatusListener) {
        this.t = iBNaviStatusListener;
    }

    public int o() {
        return this.F;
    }

    public void a(int i, boolean z) {
        if (this.s != null) {
            this.s.onWalkNaviModeChange(i, new e(this, i, z));
        }
    }

    public void p() {
        if (s()) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_token", true);
            bundle.putBoolean("is_phoneinfo", true);
            Set<String> keySet = bundle.keySet();
            if (keySet != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    for (String str : keySet) {
                        jSONObject.put(str, String.valueOf(bundle.get(str)));
                    }
                    a().y().a(jSONObject.toString());
                } catch (Exception e) {
                    com.baidu.platform.comapi.wnplatform.c.a.b(e.getMessage());
                }
            }
        }
    }

    public String q() {
        return a().y().l();
    }

    public void r() {
        if (this.f != null && this.f.f()) {
            this.f.h();
        }
        a().B().a(0);
        X();
        Q();
    }

    public boolean s() {
        return this.v != 0;
    }

    public boolean b(int i) {
        if (y() != null) {
            return this.f.i(i);
        }
        return false;
    }

    @Override // com.baidu.platform.comapi.walknavi.g.b.a
    public void t() {
        if (this.s != null) {
            this.s.onNaviExit();
        }
        if (this.t != null) {
            this.t.onNaviExit();
        }
        r();
    }

    private int U() {
        int i = 0;
        if (L() != null) {
            i = L().j();
        }
        if (i <= 0) {
            return 12;
        }
        return i;
    }

    public void u() {
        int i;
        int i2 = 0;
        if (L() != null) {
            i = L().g();
            i2 = L().f();
        } else {
            i = 0;
        }
        B().a(i, i2);
    }

    public void v() {
        B().k();
    }

    public com.baidu.platform.comapi.walknavi.c.b w() {
        if (this.d == null) {
            this.d = new com.baidu.platform.comapi.walknavi.c.b();
        }
        return this.d;
    }

    public com.baidu.platform.comapi.wnplatform.i.b x() {
        if (this.e == null) {
            this.e = new com.baidu.platform.comapi.wnplatform.i.b();
        }
        return this.e;
    }

    public com.baidu.platform.comapi.wnplatform.a.a y() {
        if (this.f == null) {
            this.f = new com.baidu.platform.comapi.wnplatform.a.a();
        }
        return this.f;
    }

    public com.baidu.platform.comapi.wnplatform.h.e z() {
        if (this.g == null) {
            this.g = new com.baidu.platform.comapi.wnplatform.h.e();
        }
        return this.g;
    }

    public WGuideFSM A() {
        if (this.h == null) {
            this.h = new WGuideFSM();
        }
        return this.h;
    }

    public com.baidu.platform.comapi.wnplatform.walkmap.d B() {
        if (this.i == null) {
            this.i = new com.baidu.platform.comapi.wnplatform.walkmap.d();
        }
        return this.i;
    }

    public k C() {
        if (this.k == null) {
            this.k = new k();
        }
        return this.k;
    }

    public com.baidu.platform.comapi.wnplatform.m.a D() {
        return this.l;
    }

    private void V() {
        if (com.baidu.platform.comapi.wnplatform.a.a().b() == 0) {
            this.l = new com.baidu.platform.comapi.walknavi.f.a();
        } else if (com.baidu.platform.comapi.wnplatform.a.a().b() == 1) {
            this.l = new com.baidu.platform.comapi.bikenavi.b.a();
        }
    }

    public int E() {
        return this.z;
    }

    public void c(int i) {
        this.z = i;
    }

    public void d(int i) {
        if (this.f != null) {
            this.f.h(i);
        }
    }

    public Point F() {
        return CoordUtil.ll2point(this.A);
    }

    public Point G() {
        return CoordUtil.ll2point(this.B);
    }

    public LatLng H() {
        return this.A;
    }

    public void a(LatLng latLng) {
        this.A = latLng;
    }

    public LatLng I() {
        return this.B;
    }

    public void b(LatLng latLng) {
        this.B = latLng;
    }

    public com.baidu.platform.comapi.wnplatform.j.c J() {
        if (this.m == null) {
            this.m = new com.baidu.platform.comapi.wnplatform.j.c();
        }
        return this.m;
    }

    public com.baidu.platform.comapi.wnplatform.b.c K() {
        if (this.n == null) {
            this.n = new com.baidu.platform.comapi.wnplatform.b.c();
        }
        return this.n;
    }

    public com.baidu.platform.comapi.wnplatform.n.a L() {
        return this.p;
    }

    public com.baidu.platform.comapi.wnplatform.d.b M() {
        if (this.o == null) {
            this.o = new com.baidu.platform.comapi.wnplatform.d.b();
        }
        return this.o;
    }

    public com.baidu.platform.comapi.wnplatform.l.a N() {
        if (this.q == null) {
            this.q = new com.baidu.platform.comapi.wnplatform.l.a();
        }
        return this.q;
    }

    private void W() {
        com.baidu.platform.comapi.walknavi.b.a.c = 19;
    }

    public MapBound O() {
        new Bundle();
        Bundle m = a().y().m();
        int i = m.getInt("left");
        int i2 = m.getInt("bottom");
        int i3 = m.getInt(MarkerModel.SubBase.RIGHT);
        int i4 = m.getInt(AiAppsNaViewModel.POSITION_KEY_TOP);
        MapBound mapBound = new MapBound();
        mapBound.setPtLB(new Point(i, i2));
        mapBound.setPtRT(new Point(i3, i4));
        return mapBound;
    }

    public MapBound e(int i) {
        new Bundle();
        Bundle f = a().y().f(i);
        int i2 = f.getInt("left");
        int i3 = f.getInt("bottom");
        int i4 = f.getInt(MarkerModel.SubBase.RIGHT);
        int i5 = f.getInt(AiAppsNaViewModel.POSITION_KEY_TOP);
        MapBound mapBound = new MapBound();
        mapBound.setPtLB(new Point(i2, i3));
        mapBound.setPtRT(new Point(i4, i5));
        return mapBound;
    }

    private void a(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PHONE_STATE");
            intentFilter.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            context.registerReceiver(this.G, intentFilter);
        } catch (Exception e) {
        }
    }

    private void X() {
        try {
            if (this.x != null && this.G != null) {
                this.x.unregisterReceiver(this.G);
            }
        } catch (IllegalArgumentException e) {
            com.baidu.platform.comapi.wnplatform.c.a.b(e.getMessage());
        }
    }

    public Bundle P() {
        return this.w;
    }

    public void Q() {
        this.v = 0;
        this.s = null;
        this.t = null;
        if (this.e != null) {
            this.e.release();
            this.e = null;
        }
        if (this.f != null) {
            this.f.release();
            this.f = null;
        }
        if (this.g != null) {
            this.g.release();
            this.g = null;
        }
        if (this.h != null) {
            this.h.release();
            this.h = null;
        }
        if (this.i != null) {
            this.i.release();
            this.i = null;
        }
        if (this.j != null) {
            this.j.release();
            this.j = null;
        }
        if (this.k != null) {
            this.k.release();
            this.k = null;
        }
        if (this.m != null) {
            this.m.release();
            this.m = null;
        }
        if (this.n != null) {
            this.n.release();
            this.n = null;
        }
        if (this.o != null) {
            this.o.release();
            this.o = null;
        }
        if (this.p != null) {
            this.p.a((com.baidu.platform.comapi.walknavi.g.b.a) null);
            this.p.release();
            this.p = null;
        }
        if (this.q != null) {
            this.q.release();
            this.q = null;
        }
        if (this.r != null) {
            this.r.release();
            this.r = null;
        }
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.u = 0;
        com.baidu.platform.comapi.walknavi.g.a.b.a();
    }
}
