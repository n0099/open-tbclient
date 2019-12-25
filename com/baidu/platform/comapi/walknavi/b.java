package com.baidu.platform.comapi.walknavi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
import com.baidu.mapapi.bikenavi.adapter.IBNaviStatusListener;
import com.baidu.mapapi.bikenavi.adapter.IBRouteGuidanceListener;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapapi.model.inner.MapBound;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.mapapi.walknavi.adapter.IWMoreNPCModelOnClickListener;
import com.baidu.mapapi.walknavi.adapter.IWNPCEngineInitListener;
import com.baidu.mapapi.walknavi.adapter.IWNPCLoadAndInitListener;
import com.baidu.mapapi.walknavi.adapter.IWNaviStatusListener;
import com.baidu.mapapi.walknavi.adapter.IWRouteGuidanceListener;
import com.baidu.mapapi.walknavi.model.BaseNpcModel;
import com.baidu.mapapi.walknavi.model.WalkNaviDisplayOption;
import com.baidu.platform.comapi.walknavi.fsm.WGuideFSM;
import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;
import com.baidu.platform.comapi.wnplatform.o.n;
import com.baidu.platform.comapi.wnplatform.o.o;
import com.baidu.platform.comjni.jninative.tts.WNaviTTSPlayer;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b implements com.baidu.platform.comapi.walknavi.g.b.a {
    public static int a = 0;
    public static int b = 1;
    public static int c = 2;
    private int A;
    private int B;
    private LatLng C;
    private LatLng D;
    private WLocData E;
    private int F;
    private int G;
    private boolean H;
    private WalkNaviDisplayOption I;
    private ArrayList<com.baidu.platform.comapi.walknavi.d.a> J;
    private ArrayList<BaseNpcModel> K;
    private Bitmap L;
    private Bitmap M;
    private boolean N;
    private float O;
    private int P;
    private final BroadcastReceiver Q;
    private com.baidu.platform.comapi.walknavi.c.b d;
    private com.baidu.platform.comapi.wnplatform.i.b e;
    private com.baidu.platform.comapi.wnplatform.b.a f;
    private com.baidu.platform.comapi.wnplatform.h.f g;
    private WGuideFSM h;
    private com.baidu.platform.comapi.wnplatform.walkmap.d i;
    private com.baidu.platform.comapi.walknavi.a.a j;
    private n k;
    private com.baidu.platform.comapi.wnplatform.m.a l;
    private com.baidu.platform.comapi.wnplatform.j.c m;
    private com.baidu.platform.comapi.wnplatform.c.d n;
    private com.baidu.platform.comapi.wnplatform.model.b o;
    private com.baidu.platform.comapi.wnplatform.n.a p;
    private com.baidu.platform.comapi.wnplatform.l.a q;
    private com.baidu.platform.comapi.wnplatform.a.a r;
    private com.baidu.platform.comapi.wnplatform.f.b s;
    private IWNaviStatusListener t;
    private IBNaviStatusListener u;
    private int v;
    private int w;
    private Bundle x;
    private Context y;
    private Handler z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
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
        this.u = null;
        this.v = 0;
        this.w = 0;
        this.x = new Bundle();
        this.z = new Handler();
        this.F = -1;
        this.G = -1;
        this.H = false;
        this.J = new ArrayList<>();
        this.K = new ArrayList<>();
        this.L = null;
        this.M = null;
        this.N = false;
        this.O = 0.0f;
        this.Q = new j(this);
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

    public void c() {
        com.baidu.platform.comapi.walknavi.g.b.c k;
        if (com.baidu.platform.comapi.walknavi.d.e.c().d() && this.p != null && (this.p instanceof com.baidu.platform.comapi.walknavi.g.a) && (k = ((com.baidu.platform.comapi.walknavi.g.a) this.p).k()) != null) {
            k.c(false);
        }
    }

    public void d() {
        if (com.baidu.platform.comapi.walknavi.d.e.c().d()) {
            com.baidu.platform.comapi.walknavi.d.e.c().f();
        }
    }

    public boolean e() {
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
        com.baidu.platform.comapi.wnplatform.a.a().b(i);
        com.baidu.platform.comapi.wnplatform.a.a().c(i2);
        a(i);
        Y();
    }

    public Context f() {
        return this.y;
    }

    public void g() {
        d();
        if (com.baidu.platform.comapi.wnplatform.a.a().g()) {
            G().a(1);
        } else if (com.baidu.platform.comapi.wnplatform.a.a().f()) {
            if (u() == 1) {
                G().a(1);
            } else if (u() == 2) {
                G().a(0);
            }
        }
        if (this.p != null) {
            O().a(this.y, this.p.t());
            this.p.a(this);
            this.p.d();
        }
        F().runCurrentState();
    }

    public void a(Activity activity, IWRouteGuidanceListener iWRouteGuidanceListener) {
        a(activity).a(iWRouteGuidanceListener);
    }

    public void a(Activity activity, IBRouteGuidanceListener iBRouteGuidanceListener) {
        a(activity).a(iBRouteGuidanceListener);
    }

    public com.baidu.platform.comapi.wnplatform.f.b a(Activity activity) {
        if (this.s == null) {
            this.s = new com.baidu.platform.comapi.wnplatform.f.b(activity);
        }
        return this.s;
    }

    public void h() {
        c();
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
        this.w = 1;
        this.d.a(context, j, aVar);
    }

    public void i() {
        if (this.d != null) {
            this.d.release();
        }
    }

    public boolean j() {
        return this.d != null && this.d.a() > 0;
    }

    public void a(Context context, MapView mapView) {
        G().a(context, mapView);
    }

    public void k() {
        G().b();
    }

    public View b(Activity activity) {
        if (com.baidu.platform.comapi.wnplatform.a.a().f()) {
            if (this.p == null) {
                this.p = new com.baidu.platform.comapi.walknavi.g.a(activity);
            }
        } else if (com.baidu.platform.comapi.wnplatform.a.a().g() && this.p == null) {
            this.p = new com.baidu.platform.comapi.bikenavi.c.b(activity);
        }
        return this.p.h();
    }

    public void a(com.baidu.platform.comapi.wnplatform.i.a aVar) {
        C().a(aVar);
    }

    public void a(WLocData wLocData) {
        if (this.n != null && wLocData != null) {
            this.n.a(wLocData);
        }
    }

    public void a(WalkNaviDisplayOption walkNaviDisplayOption) {
        this.I = walkNaviDisplayOption;
    }

    public WalkNaviDisplayOption l() {
        return this.I;
    }

    public void m() {
        if (this.I != null) {
            this.I = null;
        }
    }

    public void a(com.baidu.platform.comapi.wnplatform.m.c cVar) {
        I().a(cVar);
    }

    public ArrayList<com.baidu.platform.comapi.walknavi.d.a> n() {
        if (this.J == null || this.J.size() == 0) {
            c((ArrayList<BaseNpcModel>) null);
        }
        return this.J;
    }

    public void a(ArrayList<BaseNpcModel> arrayList) {
        b(arrayList);
        c(arrayList);
    }

    public ArrayList<BaseNpcModel> o() {
        if (this.K == null || this.K.size() == 0) {
            b((ArrayList<BaseNpcModel>) null);
        }
        return this.K;
    }

    private void b(ArrayList<BaseNpcModel> arrayList) {
        if (this.K != null) {
            this.K.clear();
        } else {
            this.K = new ArrayList<>();
        }
        if (this.L == null) {
            this.L = BitmapFactory.decodeResource(com.baidu.platform.comapi.wnplatform.o.a.a.b(), R.drawable.aiapps_favorite_guide_bg);
        }
        BaseNpcModel baseNpcModel = new BaseNpcModel();
        baseNpcModel.setDownLoadKey("");
        baseNpcModel.setIcon(this.L);
        baseNpcModel.setOriginTitle("经典");
        baseNpcModel.setLoadFromLocal(true);
        this.K.add(baseNpcModel);
        if (this.M == null) {
            this.M = BitmapFactory.decodeResource(com.baidu.platform.comapi.wnplatform.o.a.a.b(), R.drawable.aiapps_follow_vip_blue);
        }
        BaseNpcModel baseNpcModel2 = new BaseNpcModel();
        baseNpcModel2.setDownLoadKey("10279765");
        baseNpcModel2.setIcon(this.M);
        baseNpcModel2.setOriginTitle("图图");
        baseNpcModel2.setLoadFromLocal(false);
        this.K.add(baseNpcModel2);
        if (arrayList != null && arrayList.size() != 0) {
            this.K.addAll(arrayList);
        }
    }

    private void c(ArrayList<BaseNpcModel> arrayList) {
        if (this.J != null) {
            this.J.clear();
        } else {
            this.J = new ArrayList<>();
        }
        com.baidu.platform.comapi.walknavi.d.a aVar = new com.baidu.platform.comapi.walknavi.d.a();
        aVar.a("");
        aVar.b("经典");
        aVar.a(true);
        aVar.a(this.L);
        this.J.add(aVar);
        com.baidu.platform.comapi.walknavi.d.a aVar2 = new com.baidu.platform.comapi.walknavi.d.a();
        aVar2.a("10279765");
        aVar2.b("图图");
        aVar2.a(false);
        aVar2.a(this.M);
        this.J.add(aVar2);
        if (arrayList != null && arrayList.size() != 0) {
            Iterator<BaseNpcModel> it = arrayList.iterator();
            while (it.hasNext()) {
                BaseNpcModel next = it.next();
                com.baidu.platform.comapi.walknavi.d.a aVar3 = new com.baidu.platform.comapi.walknavi.d.a();
                aVar3.a(next.getDownLoadKey());
                aVar3.b(next.getOriginTitle());
                aVar3.c(next.getModelSize());
                aVar3.d(next.getLocalPath());
                aVar3.a(next.getIcon());
                aVar3.a(next.isLoadFromLocal());
                this.J.add(aVar3);
            }
        }
    }

    public com.baidu.platform.comapi.walknavi.d.a a(String str) {
        ArrayList<com.baidu.platform.comapi.walknavi.d.a> n = n();
        if (n == null || n.size() == 0) {
            return null;
        }
        Iterator<com.baidu.platform.comapi.walknavi.d.a> it = n.iterator();
        while (it.hasNext()) {
            com.baidu.platform.comapi.walknavi.d.a next = it.next();
            if (TextUtils.equals(next.c(), str)) {
                return next;
            }
        }
        return null;
    }

    public void a(BaseNpcModel baseNpcModel) {
        com.baidu.platform.comapi.walknavi.g.b.c k;
        if (this.p != null && (this.p instanceof com.baidu.platform.comapi.walknavi.g.a) && (k = ((com.baidu.platform.comapi.walknavi.g.a) this.p).k()) != null) {
            k.a(baseNpcModel);
        }
    }

    public void a(IWNPCEngineInitListener iWNPCEngineInitListener) {
        com.baidu.platform.comapi.walknavi.d.e.c().a("10279765", new c(this, iWNPCEngineInitListener));
    }

    public void a(IWMoreNPCModelOnClickListener iWMoreNPCModelOnClickListener) {
        com.baidu.platform.comapi.walknavi.g.b.c k;
        if (this.p != null && (this.p instanceof com.baidu.platform.comapi.walknavi.g.a) && (k = ((com.baidu.platform.comapi.walknavi.g.a) this.p).k()) != null) {
            k.a(iWMoreNPCModelOnClickListener);
        }
    }

    public void a(IWNPCLoadAndInitListener iWNPCLoadAndInitListener) {
        com.baidu.platform.comapi.walknavi.g.b.c k;
        if (this.p != null && (this.p instanceof com.baidu.platform.comapi.walknavi.g.a) && (k = ((com.baidu.platform.comapi.walknavi.g.a) this.p).k()) != null) {
            k.a(iWNPCLoadAndInitListener);
        }
    }

    public boolean a(Activity activity, Bundle bundle) {
        boolean a2;
        D().p();
        this.y = activity;
        try {
            if (bundle != null) {
                com.baidu.platform.comapi.walknavi.g.a.b.a = bundle.getInt("wnavi_mode", 1);
            } else {
                com.baidu.platform.comapi.walknavi.g.a.b.a = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (a().J() != 4) {
            if (I() != null) {
                I().ready();
            }
            if (com.baidu.platform.comapi.wnplatform.a.a().f()) {
                a2 = a().H().a("WALKNAVI_VOICE_ON_OFF", true);
            } else {
                a2 = com.baidu.platform.comapi.wnplatform.a.a().g() ? a().H().a("BIKENAVI_VOICE_ON_OFF", true) : true;
            }
            if (a2) {
                WNaviTTSPlayer.resumeVoiceTTSOutput();
            } else {
                WNaviTTSPlayer.pauseVoiceTTSOutput();
            }
        } else {
            WNaviTTSPlayer.pauseVoiceTTSOutput();
        }
        G().ready();
        if (this.p == null) {
            if (com.baidu.platform.comapi.wnplatform.a.a().f()) {
                this.p = new com.baidu.platform.comapi.walknavi.g.a(activity);
            } else if (com.baidu.platform.comapi.wnplatform.a.a().g()) {
                this.p = new com.baidu.platform.comapi.bikenavi.c.b(activity);
            }
        }
        if (this.p == null || this.p.c()) {
            return false;
        }
        this.p.ready();
        z();
        if (a().J() != 4) {
            P().a(this.y);
        }
        E().ready();
        C().ready();
        if (this.E != null) {
            GeoPoint ll2mc = CoordUtil.ll2mc(new LatLng(this.E.latitude, this.E.longitude));
            a().D().a((int) ll2mc.getLongitudeE6(), (int) ll2mc.getLatitudeE6(), 0);
        }
        q();
        if (com.baidu.platform.comapi.walknavi.g.a.b.a == 1) {
            P().b(activity);
        } else if (com.baidu.platform.comapi.walknavi.g.a.b.a == 3) {
            S().ready();
        }
        a((Context) activity);
        Z();
        G().c();
        this.w = 2;
        W();
        if (com.baidu.platform.comapi.wnplatform.a.a().f()) {
            a().a(g(this.B != 1 ? 1 : 2), true);
        } else if (com.baidu.platform.comapi.wnplatform.a.a().g()) {
            a().e(0);
            com.baidu.platform.comapi.wnplatform.a.a().a(1);
        }
        G().a().getMap().setBaiduHeatMapEnabled(false);
        G().a().getMap().setTrafficEnabled(false);
        G().a().getMap().getUiSettings().setAllGesturesEnabled(true);
        G().a().getMap().setMyLocationEnabled(true);
        return true;
    }

    private int g(int i) {
        if (com.baidu.platform.comapi.wnplatform.o.f.b() == 1 && com.baidu.platform.comapi.wnplatform.o.f.a()) {
            return i | 4;
        }
        return i;
    }

    private void W() {
        if (com.baidu.platform.comapi.wnplatform.a.a().f()) {
            if (a().H().a("WALKNAVI_THREED_MAP_ON_OFF", true)) {
                a().b(-50);
            } else {
                a().b(0);
            }
        }
    }

    public boolean p() {
        if (this.w < 2) {
            return false;
        }
        MapStatus i = G().i();
        this.w = 3;
        this.p.i();
        G().a(1);
        D().d(X());
        if (com.baidu.platform.comapi.walknavi.g.a.b.a != 4) {
            if (com.baidu.platform.comapi.wnplatform.a.a().c()) {
                e(1);
            } else {
                e(0);
            }
            D().h();
        }
        a().D().a(true);
        G().a(i);
        if (com.baidu.platform.comapi.walknavi.g.a.b.a == 4) {
            D().k();
            return true;
        }
        this.z.postDelayed(new d(this), 500L);
        return true;
    }

    public void q() {
        D().o();
    }

    public int r() {
        return this.F;
    }

    public void a(int i) {
        D().g(i);
    }

    public void a(Bundle bundle) {
        D().b(bundle);
    }

    public void a(int i, String str) {
        this.z.postDelayed(new e(this, str), i);
    }

    public void a(IWNaviStatusListener iWNaviStatusListener) {
        this.t = iWNaviStatusListener;
    }

    public void a(IBNaviStatusListener iBNaviStatusListener) {
        this.u = iBNaviStatusListener;
    }

    public void a(boolean z) {
        if (z) {
            com.baidu.platform.comapi.wnplatform.a.a().a(com.baidu.platform.comapi.wnplatform.a.a().e() | 4);
            return;
        }
        com.baidu.platform.comapi.wnplatform.a.a().a(com.baidu.platform.comapi.wnplatform.a.a().e() & (-5));
    }

    public void s() {
        a().a(true);
        if (com.baidu.platform.comapi.wnplatform.a.a().b()) {
            G().a().getMap().setMapStatus(MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder(G().a().getMap().getMapStatus()).zoom(21.0f).build()));
            a().F().run("[2D正北]按钮点击");
        }
    }

    public void a(Context context, a.b bVar, int i) {
        if (context != null) {
            if (((WifiManager) context.getSystemService("wifi")).isWifiEnabled()) {
                bVar.a(i);
            } else if (i != 1 && i != 3) {
                if (i == 2) {
                }
            }
        }
    }

    public void a(boolean z, boolean z2) {
        if (z) {
            a(this.y, new f(this), com.baidu.platform.comapi.wnplatform.o.f.a(z2));
            return;
        }
        a().a(false);
    }

    public boolean t() {
        return com.baidu.platform.comapi.walknavi.d.e.c().p();
    }

    public int u() {
        return this.P;
    }

    public void a(int i, boolean z) {
        com.baidu.platform.comapi.wnplatform.a.a().a(i);
        if (this.t != null) {
            this.t.onWalkNaviModeChange(i, new h(this, i, z));
        }
        if (z) {
            if (com.baidu.platform.comapi.wnplatform.a.a().d()) {
                s();
                return;
            }
            a(false, z);
            a().a(false);
        }
    }

    public void v() {
        if (x()) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_token", true);
            bundle.putBoolean("is_phoneinfo", true);
            Set<String> keySet = bundle.keySet();
            if (keySet != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    for (String str : keySet) {
                        if (!TextUtils.equals(str, "glr") && !TextUtils.equals(str, "glv")) {
                            jSONObject.put(str, String.valueOf(bundle.get(str)));
                        }
                    }
                    a().D().a(jSONObject.toString());
                } catch (Exception e) {
                    com.baidu.platform.comapi.wnplatform.d.a.b(e.getMessage());
                }
            }
        }
    }

    public void w() {
        com.baidu.platform.comapi.walknavi.d.e.c().i();
        if (this.f != null && this.f.g()) {
            this.f.i();
        }
        a().G().a(0);
        aa();
        V();
    }

    public boolean x() {
        return this.w != 0;
    }

    public boolean b(int i) {
        if (D() != null) {
            return this.f.i(i);
        }
        return false;
    }

    @Override // com.baidu.platform.comapi.walknavi.g.b.a
    public void y() {
        if (this.t != null) {
            this.t.onNaviExit();
        }
        if (this.u != null) {
            this.u.onNaviExit();
        }
        w();
    }

    private int X() {
        int i = 0;
        if (Q() != null) {
            i = Q().j();
        }
        if (i <= 0) {
            return 12;
        }
        return i;
    }

    public void z() {
        int i;
        int i2 = 0;
        if (Q() != null) {
            i = Q().g();
            i2 = Q().f();
        } else {
            i = 0;
        }
        G().a(i, i2);
    }

    public void A() {
        G().l();
    }

    public com.baidu.platform.comapi.walknavi.c.b B() {
        if (this.d == null) {
            this.d = new com.baidu.platform.comapi.walknavi.c.b();
        }
        return this.d;
    }

    public com.baidu.platform.comapi.wnplatform.i.b C() {
        if (this.e == null) {
            this.e = new com.baidu.platform.comapi.wnplatform.i.b();
        }
        return this.e;
    }

    public com.baidu.platform.comapi.wnplatform.b.a D() {
        if (this.f == null) {
            this.f = new com.baidu.platform.comapi.wnplatform.b.a();
        }
        return this.f;
    }

    public com.baidu.platform.comapi.wnplatform.h.f E() {
        if (this.g == null) {
            this.g = new com.baidu.platform.comapi.wnplatform.h.f();
        }
        return this.g;
    }

    public WGuideFSM F() {
        if (this.h == null) {
            this.h = new WGuideFSM();
        }
        return this.h;
    }

    public com.baidu.platform.comapi.wnplatform.walkmap.d G() {
        if (this.i == null) {
            this.i = new com.baidu.platform.comapi.wnplatform.walkmap.d();
        }
        return this.i;
    }

    public n H() {
        if (this.k == null) {
            this.k = new n();
        }
        return this.k;
    }

    public com.baidu.platform.comapi.wnplatform.m.a I() {
        return this.l;
    }

    private void Y() {
        if (com.baidu.platform.comapi.wnplatform.a.a().f()) {
            this.l = new com.baidu.platform.comapi.walknavi.f.a();
        } else if (com.baidu.platform.comapi.wnplatform.a.a().g()) {
            this.l = new com.baidu.platform.comapi.bikenavi.b.a();
        }
    }

    public int J() {
        return this.A;
    }

    public void c(int i) {
        this.A = i;
    }

    public void d(int i) {
        this.B = i;
    }

    public void e(int i) {
        if (this.f != null) {
            this.f.h(i);
        }
    }

    public Point K() {
        return CoordUtil.ll2point(this.C);
    }

    public Point L() {
        return CoordUtil.ll2point(this.D);
    }

    public LatLng M() {
        return this.C;
    }

    public void a(LatLng latLng) {
        this.C = latLng;
    }

    public LatLng N() {
        return this.D;
    }

    public void b(LatLng latLng) {
        this.D = latLng;
    }

    public com.baidu.platform.comapi.wnplatform.j.c O() {
        if (this.m == null) {
            this.m = new com.baidu.platform.comapi.wnplatform.j.c();
        }
        return this.m;
    }

    public com.baidu.platform.comapi.wnplatform.c.d P() {
        if (this.n == null) {
            this.n = new com.baidu.platform.comapi.wnplatform.c.d();
        }
        return this.n;
    }

    public com.baidu.platform.comapi.wnplatform.n.a Q() {
        return this.p;
    }

    public com.baidu.platform.comapi.wnplatform.model.b R() {
        if (this.o == null) {
            this.o = new com.baidu.platform.comapi.wnplatform.model.b();
        }
        return this.o;
    }

    public com.baidu.platform.comapi.wnplatform.l.a S() {
        if (this.q == null) {
            this.q = new com.baidu.platform.comapi.wnplatform.l.a();
        }
        return this.q;
    }

    private void Z() {
        com.baidu.platform.comapi.walknavi.b.a.c = 19;
    }

    public MapBound T() {
        new Bundle();
        Bundle m = a().D().m();
        int i = m.getInt("left");
        int i2 = m.getInt(VerticalTranslateLayout.BOTTOM);
        int i3 = m.getInt(HorizontalTranslateLayout.RIGHT);
        int i4 = m.getInt(VerticalTranslateLayout.TOP);
        MapBound mapBound = new MapBound();
        mapBound.setPtLB(new Point(i, i2));
        mapBound.setPtRT(new Point(i3, i4));
        return mapBound;
    }

    public MapBound f(int i) {
        new Bundle();
        Bundle f = a().D().f(i);
        int i2 = f.getInt("left");
        int i3 = f.getInt(VerticalTranslateLayout.BOTTOM);
        int i4 = f.getInt(HorizontalTranslateLayout.RIGHT);
        int i5 = f.getInt(VerticalTranslateLayout.TOP);
        MapBound mapBound = new MapBound();
        mapBound.setPtLB(new Point(i2, i3));
        mapBound.setPtRT(new Point(i4, i5));
        return mapBound;
    }

    private void a(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PHONE_STATE");
            intentFilter.setPriority(Integer.MAX_VALUE);
            context.registerReceiver(this.Q, intentFilter);
        } catch (Exception e) {
        }
    }

    private void aa() {
        try {
            if (this.y != null && this.Q != null) {
                this.y.unregisterReceiver(this.Q);
            }
        } catch (IllegalArgumentException e) {
            com.baidu.platform.comapi.wnplatform.d.a.b(e.getMessage());
        }
    }

    public Bundle U() {
        return this.x;
    }

    public void b(String str) {
        if (this.p != null) {
        }
    }

    public void V() {
        com.baidu.platform.comapi.wnplatform.o.d.a(this.y);
        this.w = 0;
        this.t = null;
        this.u = null;
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
        if (this.s != null) {
            this.s.release();
            this.s = null;
        }
        if (this.r != null) {
            this.r.release();
            this.r = null;
        }
        if (this.J != null) {
            this.J.clear();
            this.J = null;
        }
        if (this.K != null) {
            this.K.clear();
            this.K = null;
        }
        if (this.L != null && !this.L.isRecycled()) {
            this.L.recycle();
            this.L = null;
        }
        if (this.M != null && !this.M.isRecycled()) {
            this.M.recycle();
            this.M = null;
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
        this.r = null;
        this.x = null;
        this.v = 0;
        this.y = null;
        com.baidu.platform.comapi.walknavi.g.a.b.a();
        o.a().b();
        com.baidu.platform.comapi.wnplatform.o.a.a.a();
    }
}
