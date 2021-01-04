package com.baidu.platform.comapi.walknavi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
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
import com.baidu.live.tbadk.pay.PayHelper;
import com.baidu.mapapi.bikenavi.adapter.IBNaviStatusListener;
import com.baidu.mapapi.bikenavi.adapter.IBRouteGuidanceListener;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.MapBound;
import com.baidu.mapapi.walknavi.adapter.IWMoreNPCModelOnClickListener;
import com.baidu.mapapi.walknavi.adapter.IWNPCEngineInitListener;
import com.baidu.mapapi.walknavi.adapter.IWNPCLoadAndInitListener;
import com.baidu.mapapi.walknavi.adapter.IWNaviStatusListener;
import com.baidu.mapapi.walknavi.adapter.IWRouteGuidanceListener;
import com.baidu.mapapi.walknavi.model.BaseNpcModel;
import com.baidu.mapapi.walknavi.model.WalkNaviDisplayOption;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.walknavi.fsm.WGuideFSM;
import com.baidu.platform.comapi.walknavi.g.a;
import com.baidu.platform.comapi.wnplatform.model.datastruct.WLocData;
import com.baidu.platform.comapi.wnplatform.p.o;
import com.baidu.platform.comapi.wnplatform.p.p;
import com.baidu.platform.comjni.jninative.tts.WNaviTTSPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class b implements com.baidu.platform.comapi.walknavi.g.c.a {

    /* renamed from: a  reason: collision with root package name */
    public static int f4401a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f4402b = 1;
    public static int c = 2;
    private Handler A;
    private int B;
    private int C;
    private LatLng D;
    private LatLng E;
    private com.baidu.platform.comapi.wnplatform.model.c F;
    private int G;
    private int H;
    private boolean I;
    private WalkNaviDisplayOption J;
    private com.baidu.mapapi.bikenavi.model.b K;
    private ArrayList<com.baidu.platform.comapi.walknavi.d.a> L;
    private ArrayList<BaseNpcModel> M;
    private Bitmap N;
    private Bitmap O;
    private boolean P;
    private int Q;
    private float R;
    private com.baidu.platform.comapi.walknavi.widget.a S;
    private int T;
    private final BroadcastReceiver U;
    private com.baidu.platform.comapi.walknavi.c.b d;
    private com.baidu.platform.comapi.wnplatform.j.d e;
    private com.baidu.platform.comapi.wnplatform.b.a f;
    private com.baidu.platform.comapi.wnplatform.i.f g;
    private WGuideFSM h;
    private com.baidu.platform.comapi.wnplatform.walkmap.d i;
    private com.baidu.platform.comapi.walknavi.a.a j;
    private o k;
    private com.baidu.platform.comapi.wnplatform.n.a l;
    private com.baidu.platform.comapi.wnplatform.k.c m;
    private com.baidu.platform.comapi.wnplatform.c.d n;
    private com.baidu.platform.comapi.wnplatform.model.b o;
    private com.baidu.platform.comapi.wnplatform.o.a p;
    private com.baidu.platform.comapi.wnplatform.m.a q;
    private com.baidu.platform.comapi.wnplatform.a.a r;
    private com.baidu.g.a.d s;
    private com.baidu.platform.comapi.wnplatform.g.b t;
    private IWNaviStatusListener u;
    private IBNaviStatusListener v;
    private int w;
    private int x;
    private Bundle y;
    private Context z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes15.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        static final b f4405a = new b(null);
    }

    /* synthetic */ b(c cVar) {
        this();
    }

    public static b a() {
        return a.f4405a;
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
        this.v = null;
        this.w = 0;
        this.x = 0;
        this.y = new Bundle();
        this.A = new Handler();
        this.G = -1;
        this.H = -1;
        this.I = false;
        this.L = new ArrayList<>();
        this.M = new ArrayList<>();
        this.N = null;
        this.O = null;
        this.P = false;
        this.Q = 0;
        this.R = 0.0f;
        this.U = new l(this);
    }

    public int b() {
        return this.Q;
    }

    public void a(int i) {
        this.Q = i;
    }

    public boolean c() {
        SensorManager sensorManager;
        List<Sensor> sensorList;
        Iterator<Sensor> it;
        boolean z;
        Context a2 = com.baidu.platform.comapi.wnplatform.p.b.a.a();
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

    public void d() {
        com.baidu.platform.comapi.walknavi.g.c.c k;
        if (com.baidu.platform.comapi.walknavi.d.e.c().d() && this.p != null && (this.p instanceof com.baidu.platform.comapi.walknavi.g.a) && (k = ((com.baidu.platform.comapi.walknavi.g.a) this.p).k()) != null) {
            k.c(false);
        }
    }

    public void e() {
        if (com.baidu.platform.comapi.walknavi.d.e.c().d()) {
            com.baidu.platform.comapi.walknavi.d.e.c().f();
        }
    }

    public boolean f() {
        SensorManager sensorManager;
        List<Sensor> sensorList;
        Context a2 = com.baidu.platform.comapi.wnplatform.p.b.a.a();
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
        b(i);
        aa();
    }

    public Context g() {
        return this.z;
    }

    public boolean h() {
        return this.I;
    }

    public void i() {
        e();
        if (com.baidu.platform.comapi.wnplatform.a.a().g()) {
            J().a(1);
        } else if (com.baidu.platform.comapi.wnplatform.a.a().f()) {
            if (x() == 1) {
                J().a(1);
            } else if (x() == 2) {
                J().a(0);
            }
        }
        if (this.p != null) {
            R().a(this.z, this.p.u());
            this.p.a(this);
            this.p.d();
        }
        I().runCurrentState();
    }

    public void a(Activity activity, IWRouteGuidanceListener iWRouteGuidanceListener) {
        a(activity).a(iWRouteGuidanceListener);
    }

    public void a(Activity activity, IBRouteGuidanceListener iBRouteGuidanceListener) {
        a(activity).a(iBRouteGuidanceListener);
    }

    public com.baidu.platform.comapi.wnplatform.g.b a(Activity activity) {
        if (this.t == null) {
            this.t = new com.baidu.platform.comapi.wnplatform.g.b(activity);
        }
        return this.t;
    }

    public void j() {
        d();
        if (this.m != null) {
            this.m.a();
        }
        if (this.p != null) {
            this.p.a((com.baidu.platform.comapi.walknavi.g.c.a) null);
            this.p.e();
        }
    }

    public void a(Context context, long j, com.baidu.platform.comapi.walknavi.c.a aVar) {
        if (this.d == null) {
            this.d = new com.baidu.platform.comapi.walknavi.c.b();
        }
        this.x = 1;
        this.d.a(context, j, aVar);
    }

    public void k() {
        if (this.d != null) {
            this.d.release();
        }
    }

    public boolean l() {
        return this.d != null && this.d.a() > 0;
    }

    public void a(Context context, MapView mapView) {
        J().a(context, mapView);
    }

    public void m() {
        J().b();
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

    public void a(com.baidu.platform.comapi.wnplatform.j.b bVar) {
        F().a(bVar);
    }

    public void a(WLocData wLocData) {
        if (this.n != null && wLocData != null) {
            this.n.a(wLocData);
        }
    }

    public void a(WalkNaviDisplayOption walkNaviDisplayOption) {
        this.J = walkNaviDisplayOption;
    }

    public WalkNaviDisplayOption n() {
        return this.J;
    }

    public void o() {
        if (this.J != null) {
            this.J = null;
        }
    }

    public com.baidu.mapapi.bikenavi.model.b p() {
        return this.K;
    }

    public void a(com.baidu.platform.comapi.wnplatform.n.c cVar) {
        L().a(cVar);
    }

    public ArrayList<com.baidu.platform.comapi.walknavi.d.a> q() {
        if (this.L == null || this.L.size() == 0) {
            c((ArrayList<BaseNpcModel>) null);
        }
        return this.L;
    }

    public void a(ArrayList<BaseNpcModel> arrayList) {
        b(arrayList);
        c(arrayList);
    }

    public ArrayList<BaseNpcModel> r() {
        if (this.M == null || this.M.size() == 0) {
            b((ArrayList<BaseNpcModel>) null);
        }
        return this.M;
    }

    private void b(ArrayList<BaseNpcModel> arrayList) {
        if (this.M != null) {
            this.M.clear();
        } else {
            this.M = new ArrayList<>();
        }
        if (this.N == null) {
            this.N = BitmapFactory.decodeResource(com.baidu.platform.comapi.wnplatform.p.a.a.b(), 2130837854);
        }
        BaseNpcModel baseNpcModel = new BaseNpcModel();
        baseNpcModel.setDownLoadKey("");
        baseNpcModel.setIcon(this.N);
        baseNpcModel.setOriginTitle("经典");
        baseNpcModel.setLoadFromLocal(true);
        this.M.add(baseNpcModel);
        if (this.O == null) {
            this.O = BitmapFactory.decodeResource(com.baidu.platform.comapi.wnplatform.p.a.a.b(), 2130837864);
        }
        BaseNpcModel baseNpcModel2 = new BaseNpcModel();
        baseNpcModel2.setDownLoadKey("10279765");
        baseNpcModel2.setIcon(this.O);
        baseNpcModel2.setOriginTitle("图图");
        baseNpcModel2.setLoadFromLocal(false);
        this.M.add(baseNpcModel2);
        if (arrayList != null && arrayList.size() != 0) {
            this.M.addAll(arrayList);
        }
    }

    private void c(ArrayList<BaseNpcModel> arrayList) {
        if (this.L != null) {
            this.L.clear();
        } else {
            this.L = new ArrayList<>();
        }
        com.baidu.platform.comapi.walknavi.d.a aVar = new com.baidu.platform.comapi.walknavi.d.a();
        aVar.a("");
        aVar.b("经典");
        aVar.a(true);
        aVar.a(this.N);
        this.L.add(aVar);
        com.baidu.platform.comapi.walknavi.d.a aVar2 = new com.baidu.platform.comapi.walknavi.d.a();
        aVar2.a("10279765");
        aVar2.b("图图");
        aVar2.a(false);
        aVar2.a(this.O);
        this.L.add(aVar2);
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
                this.L.add(aVar3);
            }
        }
    }

    public com.baidu.platform.comapi.walknavi.d.a a(String str) {
        ArrayList<com.baidu.platform.comapi.walknavi.d.a> q = q();
        if (q == null || q.size() == 0) {
            return null;
        }
        Iterator<com.baidu.platform.comapi.walknavi.d.a> it = q.iterator();
        while (it.hasNext()) {
            com.baidu.platform.comapi.walknavi.d.a next = it.next();
            if (TextUtils.equals(next.c(), str)) {
                return next;
            }
        }
        return null;
    }

    public void a(BaseNpcModel baseNpcModel) {
        com.baidu.platform.comapi.walknavi.g.c.c k;
        if (this.p != null && (this.p instanceof com.baidu.platform.comapi.walknavi.g.a) && (k = ((com.baidu.platform.comapi.walknavi.g.a) this.p).k()) != null) {
            k.a(baseNpcModel);
        }
    }

    public void a(IWNPCEngineInitListener iWNPCEngineInitListener) {
        com.baidu.platform.comapi.walknavi.d.e.c().a("10279765", new c(this, iWNPCEngineInitListener));
    }

    public void a(IWMoreNPCModelOnClickListener iWMoreNPCModelOnClickListener) {
        com.baidu.platform.comapi.walknavi.g.c.c k;
        if (this.p != null && (this.p instanceof com.baidu.platform.comapi.walknavi.g.a) && (k = ((com.baidu.platform.comapi.walknavi.g.a) this.p).k()) != null) {
            k.a(iWMoreNPCModelOnClickListener);
        }
    }

    public void a(IWNPCLoadAndInitListener iWNPCLoadAndInitListener) {
        com.baidu.platform.comapi.walknavi.g.c.c k;
        if (this.p != null && (this.p instanceof com.baidu.platform.comapi.walknavi.g.a) && (k = ((com.baidu.platform.comapi.walknavi.g.a) this.p).k()) != null) {
            k.a(iWNPCLoadAndInitListener);
        }
    }

    public boolean a(Activity activity, Bundle bundle) {
        boolean a2;
        G().p();
        this.z = activity;
        try {
            if (bundle != null) {
                com.baidu.platform.comapi.walknavi.g.b.b.f4503a = bundle.getInt("wnavi_mode", 1);
            } else {
                com.baidu.platform.comapi.walknavi.g.b.b.f4503a = 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (a().M() != 4) {
            if (L() != null) {
                L().ready();
            }
            if (com.baidu.platform.comapi.wnplatform.a.a().f()) {
                a2 = a().K().a("WALKNAVI_VOICE_ON_OFF", true);
            } else {
                a2 = com.baidu.platform.comapi.wnplatform.a.a().g() ? a().K().a("BIKENAVI_VOICE_ON_OFF", true) : true;
            }
            if (a2) {
                WNaviTTSPlayer.resumeVoiceTTSOutput();
            } else {
                WNaviTTSPlayer.pauseVoiceTTSOutput();
            }
        } else {
            WNaviTTSPlayer.pauseVoiceTTSOutput();
        }
        J().ready();
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
        C();
        if (a().M() != 4) {
            S().a(this.z);
        }
        H().ready();
        F().ready();
        t();
        if (com.baidu.platform.comapi.walknavi.g.b.b.f4503a == 1) {
            S().b(activity);
        } else if (com.baidu.platform.comapi.walknavi.g.b.b.f4503a == 3) {
            V().ready();
        }
        ab();
        J().c();
        this.x = 2;
        Y();
        if (com.baidu.platform.comapi.wnplatform.a.a().f()) {
            a().a(h(this.C == 1 ? 2 : 1), true);
            int a3 = com.baidu.platform.comapi.wnplatform.p.g.a(Q(), b());
            if (a3 == 2 || a3 == 3) {
                a().a(this.z, (a.b) null, a3);
            }
        } else if (com.baidu.platform.comapi.wnplatform.a.a().g()) {
            a().f(0);
            com.baidu.platform.comapi.wnplatform.a.a().a(1);
        }
        J().a().getMap().setBaiduHeatMapEnabled(false);
        J().a().getMap().setTrafficEnabled(false);
        J().a().getMap().setMyLocationEnabled(false);
        return true;
    }

    private int h(int i) {
        if (com.baidu.platform.comapi.wnplatform.p.g.b() == 1 && com.baidu.platform.comapi.wnplatform.p.g.a()) {
            return i | 4;
        }
        return i;
    }

    private void Y() {
        if (com.baidu.platform.comapi.wnplatform.a.a().f()) {
            if (a().K().a("WALKNAVI_THREED_MAP_ON_OFF", true)) {
                a().c(-50);
            } else {
                a().c(0);
            }
        }
    }

    public void a(com.baidu.platform.comapi.wnplatform.model.c cVar) {
        this.F = cVar;
    }

    public boolean s() {
        if (this.x < 2) {
            return false;
        }
        this.I = true;
        MapStatus i = J().i();
        this.x = 3;
        this.p.i();
        J().a(1);
        G().e(Z());
        if (com.baidu.platform.comapi.walknavi.g.b.b.f4503a != 4) {
            if (com.baidu.platform.comapi.wnplatform.a.a().c()) {
                f(1);
            } else {
                f(0);
            }
            G().h();
        }
        a().G().a(true);
        J().a(i);
        if (com.baidu.platform.comapi.walknavi.g.b.b.f4503a == 4) {
            G().k();
            return true;
        }
        this.A.postDelayed(new d(this), 500L);
        return true;
    }

    public void t() {
        G().o();
    }

    public int u() {
        return this.G;
    }

    public void b(int i) {
        G().h(i);
    }

    public void a(Bundle bundle) {
        G().b(bundle);
    }

    public void a(int i, String str) {
        this.A.postDelayed(new e(this, str), i);
    }

    public void a(IWNaviStatusListener iWNaviStatusListener) {
        this.u = iWNaviStatusListener;
    }

    public void a(IBNaviStatusListener iBNaviStatusListener) {
        this.v = iBNaviStatusListener;
    }

    public void a(boolean z) {
        if (z) {
            com.baidu.platform.comapi.wnplatform.p.e.a(true);
            com.baidu.platform.comapi.wnplatform.a.a().a(com.baidu.platform.comapi.wnplatform.a.a().e() | 4);
            return;
        }
        com.baidu.platform.comapi.wnplatform.p.e.a(false);
        com.baidu.platform.comapi.wnplatform.a.a().a(com.baidu.platform.comapi.wnplatform.a.a().e() & (-5));
    }

    public void v() {
        a().a(true);
        if (com.baidu.platform.comapi.wnplatform.a.a().b()) {
            J().a().getMap().setMapStatus(MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder(J().a().getMap().getMapStatus()).zoom(22.0f).build()));
            a().I().run("[2D正北]按钮点击");
        }
    }

    public void a(Context context, a.b bVar, int i) {
        String str;
        if (context != null) {
            try {
                WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
                if (wifiManager.isWifiEnabled()) {
                    if (bVar != null) {
                        bVar.a(i);
                        return;
                    }
                    return;
                }
                if (i == 1 || i == 3) {
                    str = "不导航了";
                } else if (i == 2) {
                    str = "不需要";
                } else {
                    str = PayHelper.STATUS_CANCEL_DESC;
                }
                this.S = new com.baidu.platform.comapi.walknavi.widget.a((Activity) context).a(true).b("温馨提示").a("您所在的商户支持室内导航,开启WIFI即可使用室内导航").c(str).a(new g(this, bVar, i)).d("去开启").b(new f(this, wifiManager, bVar, i));
                if (!this.S.isShowing() && context != null && !((Activity) context).isFinishing()) {
                    this.S.show();
                }
            } catch (Exception e) {
            }
        }
    }

    public void a(boolean z, boolean z2) {
        if (z) {
            a(this.z, new h(this), com.baidu.platform.comapi.wnplatform.p.g.a(z2));
            return;
        }
        a().a(false);
    }

    public boolean w() {
        return com.baidu.platform.comapi.walknavi.d.e.c().p();
    }

    public int x() {
        return this.T;
    }

    public void a(int i, boolean z) {
        com.baidu.platform.comapi.wnplatform.a.a().a(i);
        if (this.u != null) {
            this.u.onWalkNaviModeChange(i, new j(this, i, z));
        }
        if (z) {
            if (com.baidu.platform.comapi.wnplatform.a.a().d()) {
                v();
            } else {
                a().a(false);
            }
        }
    }

    public void y() {
        if (A()) {
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
                    a().G().b(jSONObject.toString());
                } catch (Exception e) {
                    com.baidu.platform.comapi.wnplatform.d.a.b(e.getMessage());
                }
            }
        }
    }

    public void z() {
        com.baidu.platform.comapi.walknavi.d.e.c().i();
        if (this.f != null && this.f.g()) {
            this.f.i();
        }
        if (this.i != null) {
            a().J().a(0);
        }
        a().a(false);
        ac();
        X();
        this.I = false;
    }

    public boolean A() {
        return this.x != 0;
    }

    public boolean c(int i) {
        if (G() != null) {
            return this.f.j(i);
        }
        return false;
    }

    @Override // com.baidu.platform.comapi.walknavi.g.c.a
    public void B() {
        if (this.u != null) {
            this.u.onNaviExit();
        }
        if (this.v != null) {
            this.v.onNaviExit();
        }
        z();
    }

    private int Z() {
        int i = 0;
        if (T() != null) {
            i = T().j();
        }
        if (i <= 0) {
            return 12;
        }
        return i;
    }

    public void C() {
        int i;
        int i2;
        if (T() != null) {
            int g = T().g();
            i = T().f();
            i2 = g;
        } else {
            i = 0;
            i2 = 0;
        }
        J().a(i2, i);
    }

    public void D() {
        J().l();
    }

    public com.baidu.platform.comapi.walknavi.c.b E() {
        if (this.d == null) {
            this.d = new com.baidu.platform.comapi.walknavi.c.b();
        }
        return this.d;
    }

    public com.baidu.platform.comapi.wnplatform.j.d F() {
        if (this.e == null) {
            this.e = new com.baidu.platform.comapi.wnplatform.j.d();
        }
        return this.e;
    }

    public com.baidu.platform.comapi.wnplatform.b.a G() {
        if (this.f == null) {
            this.f = new com.baidu.platform.comapi.wnplatform.b.a();
        }
        return this.f;
    }

    public com.baidu.platform.comapi.wnplatform.i.f H() {
        if (this.g == null) {
            this.g = new com.baidu.platform.comapi.wnplatform.i.f();
        }
        return this.g;
    }

    public WGuideFSM I() {
        if (this.h == null) {
            this.h = new WGuideFSM();
        }
        return this.h;
    }

    public com.baidu.platform.comapi.wnplatform.walkmap.d J() {
        if (this.i == null) {
            this.i = new com.baidu.platform.comapi.wnplatform.walkmap.d();
        }
        return this.i;
    }

    public o K() {
        if (this.k == null) {
            this.k = new o();
        }
        return this.k;
    }

    public com.baidu.platform.comapi.wnplatform.n.a L() {
        return this.l;
    }

    private void aa() {
        if (com.baidu.platform.comapi.wnplatform.a.a().f()) {
            this.l = new com.baidu.platform.comapi.walknavi.f.a();
        } else if (com.baidu.platform.comapi.wnplatform.a.a().g()) {
            this.l = new com.baidu.platform.comapi.bikenavi.b.a();
        }
    }

    public int M() {
        return this.B;
    }

    public void d(int i) {
        this.B = i;
    }

    public void e(int i) {
        this.C = i;
    }

    public void f(int i) {
        if (this.f != null) {
            this.f.i(i);
        }
    }

    public Point N() {
        return CoordUtil.ll2point(this.D);
    }

    public LatLng O() {
        return this.D;
    }

    public void a(LatLng latLng) {
        this.D = latLng;
    }

    public LatLng P() {
        return this.E;
    }

    public void b(LatLng latLng) {
        this.E = latLng;
    }

    public void a(com.baidu.g.a.d dVar) {
        this.s = dVar;
    }

    public com.baidu.g.a.d Q() {
        return this.s;
    }

    public com.baidu.platform.comapi.wnplatform.k.c R() {
        if (this.m == null) {
            this.m = new com.baidu.platform.comapi.wnplatform.k.c();
        }
        return this.m;
    }

    public com.baidu.platform.comapi.wnplatform.c.d S() {
        if (this.n == null) {
            this.n = new com.baidu.platform.comapi.wnplatform.c.d();
        }
        return this.n;
    }

    public com.baidu.platform.comapi.wnplatform.o.a T() {
        return this.p;
    }

    public com.baidu.platform.comapi.wnplatform.model.b U() {
        if (this.o == null) {
            this.o = new com.baidu.platform.comapi.wnplatform.model.b();
        }
        return this.o;
    }

    public com.baidu.platform.comapi.wnplatform.m.a V() {
        if (this.q == null) {
            this.q = new com.baidu.platform.comapi.wnplatform.m.a();
        }
        return this.q;
    }

    private void ab() {
        com.baidu.platform.comapi.walknavi.b.a.c = 19;
    }

    public MapBound W() {
        new Bundle();
        Bundle m = a().G().m();
        if (m == null) {
            return null;
        }
        int i = m.getInt("left");
        int i2 = m.getInt("bottom");
        int i3 = m.getInt(HorizontalTranslateLayout.DIRECTION_RIGHT);
        int i4 = m.getInt(VerticalTranslateLayout.TOP);
        MapBound mapBound = new MapBound();
        mapBound.setPtLB(new Point(i, i2));
        mapBound.setPtRT(new Point(i3, i4));
        return mapBound;
    }

    public MapBound g(int i) {
        new Bundle();
        Bundle g = a().G().g(i);
        int i2 = g.getInt("left");
        int i3 = g.getInt("bottom");
        int i4 = g.getInt(HorizontalTranslateLayout.DIRECTION_RIGHT);
        int i5 = g.getInt(VerticalTranslateLayout.TOP);
        MapBound mapBound = new MapBound();
        mapBound.setPtLB(new Point(i2, i3));
        mapBound.setPtRT(new Point(i4, i5));
        return mapBound;
    }

    private void ac() {
        try {
            if (this.z != null && this.U != null) {
                this.z.unregisterReceiver(this.U);
            }
        } catch (IllegalArgumentException e) {
            com.baidu.platform.comapi.wnplatform.d.a.b(e.getMessage());
        }
    }

    public void b(String str) {
        if (this.p != null) {
        }
    }

    public void X() {
        com.baidu.platform.comapi.wnplatform.p.d.a(this.z);
        this.x = 0;
        this.u = null;
        this.v = null;
        if (this.p != null) {
            this.p.a((com.baidu.platform.comapi.walknavi.g.c.a) null);
            this.p.release();
            this.p = null;
        }
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
        if (this.q != null) {
            this.q.release();
            this.q = null;
        }
        if (this.t != null) {
            this.t.release();
            this.t = null;
        }
        if (this.r != null) {
            this.r.release();
            this.r = null;
        }
        if (this.L != null) {
            this.L.clear();
            this.L = null;
        }
        if (this.M != null) {
            this.M.clear();
            this.M = null;
        }
        if (this.N != null && !this.N.isRecycled()) {
            this.N.recycle();
            this.N = null;
        }
        if (this.O != null && !this.O.isRecycled()) {
            this.O.recycle();
            this.O = null;
        }
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.j = null;
        this.k = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.y = null;
        this.w = 0;
        this.z = null;
        this.s = null;
        com.baidu.platform.comapi.walknavi.g.b.b.a();
        p.a().b();
        com.baidu.platform.comapi.wnplatform.p.a.a.a();
    }
}
