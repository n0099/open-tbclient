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
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.kwad.sdk.core.config.item.TipsConfigItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements com.baidu.platform.comapi.walknavi.g.b.a {

    /* renamed from: a  reason: collision with root package name */
    public static int f9453a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f9454b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static int f9455c = 2;
    public int A;
    public int B;
    public LatLng C;
    public LatLng D;
    public WLocData E;
    public int F;
    public int G;
    public boolean H;
    public WalkNaviDisplayOption I;
    public ArrayList<com.baidu.platform.comapi.walknavi.d.a> J;
    public ArrayList<BaseNpcModel> K;
    public Bitmap L;
    public Bitmap M;
    public boolean N;
    public float O;
    public int P;
    public final BroadcastReceiver Q;

    /* renamed from: d  reason: collision with root package name */
    public com.baidu.platform.comapi.walknavi.c.b f9456d;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.platform.comapi.wnplatform.i.b f9457e;

    /* renamed from: f  reason: collision with root package name */
    public com.baidu.platform.comapi.wnplatform.b.a f9458f;

    /* renamed from: g  reason: collision with root package name */
    public com.baidu.platform.comapi.wnplatform.h.f f9459g;

    /* renamed from: h  reason: collision with root package name */
    public WGuideFSM f9460h;
    public com.baidu.platform.comapi.wnplatform.walkmap.d i;
    public com.baidu.platform.comapi.walknavi.a.a j;
    public n k;
    public com.baidu.platform.comapi.wnplatform.m.a l;
    public com.baidu.platform.comapi.wnplatform.j.c m;
    public com.baidu.platform.comapi.wnplatform.c.d n;
    public com.baidu.platform.comapi.wnplatform.model.b o;
    public com.baidu.platform.comapi.wnplatform.n.a p;
    public com.baidu.platform.comapi.wnplatform.l.a q;
    public com.baidu.platform.comapi.wnplatform.a.a r;
    public com.baidu.platform.comapi.wnplatform.f.b s;
    public IWNaviStatusListener t;
    public IBNaviStatusListener u;
    public int v;
    public int w;
    public Bundle x;
    public Context y;
    public Handler z;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final b f9465a = new b(null);
    }

    public /* synthetic */ b(c cVar) {
        this();
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

    private int X() {
        int j = Q() != null ? Q().j() : 0;
        if (j <= 0) {
            return 12;
        }
        return j;
    }

    private void Y() {
        if (com.baidu.platform.comapi.wnplatform.a.a().f()) {
            this.l = new com.baidu.platform.comapi.walknavi.f.a();
        } else if (com.baidu.platform.comapi.wnplatform.a.a().g()) {
            this.l = new com.baidu.platform.comapi.bikenavi.b.a();
        }
    }

    private void Z() {
        com.baidu.platform.comapi.walknavi.b.a.f9463c = 19;
    }

    private void aa() {
        try {
            if (this.y == null || this.Q == null) {
                return;
            }
            this.y.unregisterReceiver(this.Q);
        } catch (IllegalArgumentException e2) {
            com.baidu.platform.comapi.wnplatform.d.a.b(e2.getMessage());
        }
    }

    public void A() {
        G().l();
    }

    public com.baidu.platform.comapi.walknavi.c.b B() {
        if (this.f9456d == null) {
            this.f9456d = new com.baidu.platform.comapi.walknavi.c.b();
        }
        return this.f9456d;
    }

    public com.baidu.platform.comapi.wnplatform.i.b C() {
        if (this.f9457e == null) {
            this.f9457e = new com.baidu.platform.comapi.wnplatform.i.b();
        }
        return this.f9457e;
    }

    public com.baidu.platform.comapi.wnplatform.b.a D() {
        if (this.f9458f == null) {
            this.f9458f = new com.baidu.platform.comapi.wnplatform.b.a();
        }
        return this.f9458f;
    }

    public com.baidu.platform.comapi.wnplatform.h.f E() {
        if (this.f9459g == null) {
            this.f9459g = new com.baidu.platform.comapi.wnplatform.h.f();
        }
        return this.f9459g;
    }

    public WGuideFSM F() {
        if (this.f9460h == null) {
            this.f9460h = new WGuideFSM();
        }
        return this.f9460h;
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

    public int J() {
        return this.A;
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

    public LatLng N() {
        return this.D;
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

    public MapBound T() {
        new Bundle();
        Bundle m = a().D().m();
        int i = m.getInt(CustomDialogData.POS_LEFT);
        int i2 = m.getInt(TipsConfigItem.TipConfigData.BOTTOM);
        int i3 = m.getInt("right");
        int i4 = m.getInt("top");
        MapBound mapBound = new MapBound();
        mapBound.setPtLB(new Point(i, i2));
        mapBound.setPtRT(new Point(i3, i4));
        return mapBound;
    }

    public Bundle U() {
        return this.x;
    }

    public void V() {
        com.baidu.platform.comapi.wnplatform.o.d.a(this.y);
        this.w = 0;
        this.t = null;
        this.u = null;
        com.baidu.platform.comapi.wnplatform.i.b bVar = this.f9457e;
        if (bVar != null) {
            bVar.release();
            this.f9457e = null;
        }
        com.baidu.platform.comapi.wnplatform.b.a aVar = this.f9458f;
        if (aVar != null) {
            aVar.release();
            this.f9458f = null;
        }
        com.baidu.platform.comapi.wnplatform.h.f fVar = this.f9459g;
        if (fVar != null) {
            fVar.release();
            this.f9459g = null;
        }
        WGuideFSM wGuideFSM = this.f9460h;
        if (wGuideFSM != null) {
            wGuideFSM.release();
            this.f9460h = null;
        }
        com.baidu.platform.comapi.wnplatform.walkmap.d dVar = this.i;
        if (dVar != null) {
            dVar.release();
            this.i = null;
        }
        com.baidu.platform.comapi.walknavi.a.a aVar2 = this.j;
        if (aVar2 != null) {
            aVar2.release();
            this.j = null;
        }
        n nVar = this.k;
        if (nVar != null) {
            nVar.release();
            this.k = null;
        }
        com.baidu.platform.comapi.wnplatform.j.c cVar = this.m;
        if (cVar != null) {
            cVar.release();
            this.m = null;
        }
        com.baidu.platform.comapi.wnplatform.c.d dVar2 = this.n;
        if (dVar2 != null) {
            dVar2.release();
            this.n = null;
        }
        com.baidu.platform.comapi.wnplatform.model.b bVar2 = this.o;
        if (bVar2 != null) {
            bVar2.release();
            this.o = null;
        }
        com.baidu.platform.comapi.wnplatform.n.a aVar3 = this.p;
        if (aVar3 != null) {
            aVar3.a((com.baidu.platform.comapi.walknavi.g.b.a) null);
            this.p.release();
            this.p = null;
        }
        com.baidu.platform.comapi.wnplatform.l.a aVar4 = this.q;
        if (aVar4 != null) {
            aVar4.release();
            this.q = null;
        }
        com.baidu.platform.comapi.wnplatform.f.b bVar3 = this.s;
        if (bVar3 != null) {
            bVar3.release();
            this.s = null;
        }
        com.baidu.platform.comapi.wnplatform.a.a aVar5 = this.r;
        if (aVar5 != null) {
            aVar5.release();
            this.r = null;
        }
        ArrayList<com.baidu.platform.comapi.walknavi.d.a> arrayList = this.J;
        if (arrayList != null) {
            arrayList.clear();
            this.J = null;
        }
        ArrayList<BaseNpcModel> arrayList2 = this.K;
        if (arrayList2 != null) {
            arrayList2.clear();
            this.K = null;
        }
        Bitmap bitmap = this.L;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.L.recycle();
            this.L = null;
        }
        Bitmap bitmap2 = this.M;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.M.recycle();
            this.M = null;
        }
        this.f9457e = null;
        this.f9458f = null;
        this.f9459g = null;
        this.f9460h = null;
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

    public void b(String str) {
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
                z = true;
            } else if (type == 1) {
                z2 = true;
            } else if (type == 2) {
                z3 = true;
            }
        }
        return z || (z2 && z3);
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

    public void h() {
        c();
        com.baidu.platform.comapi.wnplatform.j.c cVar = this.m;
        if (cVar != null) {
            cVar.a();
        }
        com.baidu.platform.comapi.wnplatform.n.a aVar = this.p;
        if (aVar != null) {
            aVar.a((com.baidu.platform.comapi.walknavi.g.b.a) null);
            this.p.e();
        }
    }

    public void i() {
        com.baidu.platform.comapi.walknavi.c.b bVar = this.f9456d;
        if (bVar != null) {
            bVar.release();
        }
    }

    public boolean j() {
        com.baidu.platform.comapi.walknavi.c.b bVar = this.f9456d;
        return bVar != null && bVar.a() > 0;
    }

    public void k() {
        G().b();
    }

    public WalkNaviDisplayOption l() {
        return this.I;
    }

    public void m() {
        if (this.I != null) {
            this.I = null;
        }
    }

    public ArrayList<com.baidu.platform.comapi.walknavi.d.a> n() {
        ArrayList<com.baidu.platform.comapi.walknavi.d.a> arrayList = this.J;
        if (arrayList == null || arrayList.size() == 0) {
            c((ArrayList<BaseNpcModel>) null);
        }
        return this.J;
    }

    public ArrayList<BaseNpcModel> o() {
        ArrayList<BaseNpcModel> arrayList = this.K;
        if (arrayList == null || arrayList.size() == 0) {
            b((ArrayList<BaseNpcModel>) null);
        }
        return this.K;
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
        if (com.baidu.platform.comapi.walknavi.g.a.b.f9625a != 4) {
            if (com.baidu.platform.comapi.wnplatform.a.a().c()) {
                e(1);
            } else {
                e(0);
            }
            D().h();
        }
        a().D().a(true);
        G().a(i);
        if (com.baidu.platform.comapi.walknavi.g.a.b.f9625a == 4) {
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

    public void s() {
        a().a(true);
        if (com.baidu.platform.comapi.wnplatform.a.a().b()) {
            G().a().getMap().setMapStatus(MapStatusUpdateFactory.newMapStatus(new MapStatus.Builder(G().a().getMap().getMapStatus()).zoom(21.0f).build()));
            a().F().run("[2D正北]按钮点击");
        }
    }

    public boolean t() {
        return com.baidu.platform.comapi.walknavi.d.e.c().p();
    }

    public int u() {
        return this.P;
    }

    public void v() {
        if (x()) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_token", true);
            bundle.putBoolean("is_phoneinfo", true);
            Set<String> keySet = bundle.keySet();
            if (keySet == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                for (String str : keySet) {
                    if (!TextUtils.equals(str, "glr") && !TextUtils.equals(str, "glv")) {
                        jSONObject.put(str, String.valueOf(bundle.get(str)));
                    }
                }
                a().D().a(jSONObject.toString());
            } catch (Exception e2) {
                com.baidu.platform.comapi.wnplatform.d.a.b(e2.getMessage());
            }
        }
    }

    public void w() {
        com.baidu.platform.comapi.walknavi.d.e.c().i();
        com.baidu.platform.comapi.wnplatform.b.a aVar = this.f9458f;
        if (aVar != null && aVar.g()) {
            this.f9458f.i();
        }
        a().G().a(0);
        aa();
        V();
    }

    public boolean x() {
        return this.w != 0;
    }

    @Override // com.baidu.platform.comapi.walknavi.g.b.a
    public void y() {
        IWNaviStatusListener iWNaviStatusListener = this.t;
        if (iWNaviStatusListener != null) {
            iWNaviStatusListener.onNaviExit();
        }
        IBNaviStatusListener iBNaviStatusListener = this.u;
        if (iBNaviStatusListener != null) {
            iBNaviStatusListener.onNaviExit();
        }
        w();
    }

    public void z() {
        int i;
        int i2 = 0;
        if (Q() != null) {
            i2 = Q().g();
            i = Q().f();
        } else {
            i = 0;
        }
        G().a(i2, i);
    }

    public b() {
        this.f9456d = null;
        this.f9457e = null;
        this.f9458f = null;
        this.f9459g = null;
        this.f9460h = null;
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
        Context a2 = com.baidu.platform.comapi.wnplatform.o.b.a.a();
        if (a2 == null || (sensorManager = (SensorManager) a2.getSystemService("sensor")) == null || (sensorList = sensorManager.getSensorList(-1)) == null || (r0 = sensorList.iterator()) == null) {
            return true;
        }
        for (Sensor sensor : sensorList) {
            if (sensor.getType() == 11) {
                return true;
            }
        }
        return false;
    }

    public void c() {
        com.baidu.platform.comapi.wnplatform.n.a aVar;
        com.baidu.platform.comapi.walknavi.g.b.c k;
        if (!com.baidu.platform.comapi.walknavi.d.e.c().d() || (aVar = this.p) == null || !(aVar instanceof com.baidu.platform.comapi.walknavi.g.a) || (k = ((com.baidu.platform.comapi.walknavi.g.a) aVar).k()) == null) {
            return;
        }
        k.c(false);
    }

    public MapBound f(int i) {
        new Bundle();
        Bundle f2 = a().D().f(i);
        int i2 = f2.getInt(CustomDialogData.POS_LEFT);
        int i3 = f2.getInt(TipsConfigItem.TipConfigData.BOTTOM);
        int i4 = f2.getInt("right");
        int i5 = f2.getInt("top");
        MapBound mapBound = new MapBound();
        mapBound.setPtLB(new Point(i2, i3));
        mapBound.setPtRT(new Point(i4, i5));
        return mapBound;
    }

    public void d(int i) {
        this.B = i;
    }

    public static b a() {
        return a.f9465a;
    }

    public void a(int i, int i2) {
        com.baidu.platform.comapi.wnplatform.a.a().b(i);
        com.baidu.platform.comapi.wnplatform.a.a().c(i2);
        a(i);
        Y();
    }

    private void c(ArrayList<BaseNpcModel> arrayList) {
        ArrayList<com.baidu.platform.comapi.walknavi.d.a> arrayList2 = this.J;
        if (arrayList2 != null) {
            arrayList2.clear();
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
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
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

    public void e(int i) {
        com.baidu.platform.comapi.wnplatform.b.a aVar = this.f9458f;
        if (aVar != null) {
            aVar.h(i);
        }
    }

    public void a(Activity activity, IWRouteGuidanceListener iWRouteGuidanceListener) {
        a(activity).a(iWRouteGuidanceListener);
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

    public void a(Activity activity, IBRouteGuidanceListener iBRouteGuidanceListener) {
        a(activity).a(iBRouteGuidanceListener);
    }

    public com.baidu.platform.comapi.wnplatform.f.b a(Activity activity) {
        if (this.s == null) {
            this.s = new com.baidu.platform.comapi.wnplatform.f.b(activity);
        }
        return this.s;
    }

    private int g(int i) {
        return (com.baidu.platform.comapi.wnplatform.o.f.b() == 1 && com.baidu.platform.comapi.wnplatform.o.f.a()) ? i | 4 : i;
    }

    public void a(Context context, long j, com.baidu.platform.comapi.walknavi.c.a aVar) {
        if (this.f9456d == null) {
            this.f9456d = new com.baidu.platform.comapi.walknavi.c.b();
        }
        this.w = 1;
        this.f9456d.a(context, j, aVar);
    }

    private void b(ArrayList<BaseNpcModel> arrayList) {
        ArrayList<BaseNpcModel> arrayList2 = this.K;
        if (arrayList2 != null) {
            arrayList2.clear();
        } else {
            this.K = new ArrayList<>();
        }
        if (this.L == null) {
            this.L = BitmapFactory.decodeResource(com.baidu.platform.comapi.wnplatform.o.a.a.b(), 2130837786);
        }
        BaseNpcModel baseNpcModel = new BaseNpcModel();
        baseNpcModel.setDownLoadKey("");
        baseNpcModel.setIcon(this.L);
        baseNpcModel.setOriginTitle("经典");
        baseNpcModel.setLoadFromLocal(true);
        this.K.add(baseNpcModel);
        if (this.M == null) {
            this.M = BitmapFactory.decodeResource(com.baidu.platform.comapi.wnplatform.o.a.a.b(), 2130837796);
        }
        BaseNpcModel baseNpcModel2 = new BaseNpcModel();
        baseNpcModel2.setDownLoadKey("10279765");
        baseNpcModel2.setIcon(this.M);
        baseNpcModel2.setOriginTitle("图图");
        baseNpcModel2.setLoadFromLocal(false);
        this.K.add(baseNpcModel2);
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        this.K.addAll(arrayList);
    }

    public void a(Context context, MapView mapView) {
        G().a(context, mapView);
    }

    public void a(com.baidu.platform.comapi.wnplatform.i.a aVar) {
        C().a(aVar);
    }

    public void a(WLocData wLocData) {
        com.baidu.platform.comapi.wnplatform.c.d dVar = this.n;
        if (dVar == null || wLocData == null) {
            return;
        }
        dVar.a(wLocData);
    }

    public void a(WalkNaviDisplayOption walkNaviDisplayOption) {
        this.I = walkNaviDisplayOption;
    }

    public void a(com.baidu.platform.comapi.wnplatform.m.c cVar) {
        I().a(cVar);
    }

    public void a(ArrayList<BaseNpcModel> arrayList) {
        b(arrayList);
        c(arrayList);
    }

    public com.baidu.platform.comapi.walknavi.d.a a(String str) {
        ArrayList<com.baidu.platform.comapi.walknavi.d.a> n = n();
        if (n != null && n.size() != 0) {
            Iterator<com.baidu.platform.comapi.walknavi.d.a> it = n.iterator();
            while (it.hasNext()) {
                com.baidu.platform.comapi.walknavi.d.a next = it.next();
                if (TextUtils.equals(next.c(), str)) {
                    return next;
                }
            }
        }
        return null;
    }

    public void a(BaseNpcModel baseNpcModel) {
        com.baidu.platform.comapi.walknavi.g.b.c k;
        com.baidu.platform.comapi.wnplatform.n.a aVar = this.p;
        if (aVar == null || !(aVar instanceof com.baidu.platform.comapi.walknavi.g.a) || (k = ((com.baidu.platform.comapi.walknavi.g.a) aVar).k()) == null) {
            return;
        }
        k.a(baseNpcModel);
    }

    public void c(int i) {
        this.A = i;
    }

    public void a(IWNPCEngineInitListener iWNPCEngineInitListener) {
        com.baidu.platform.comapi.walknavi.d.e.c().a("10279765", new c(this, iWNPCEngineInitListener));
    }

    public void a(IWMoreNPCModelOnClickListener iWMoreNPCModelOnClickListener) {
        com.baidu.platform.comapi.walknavi.g.b.c k;
        com.baidu.platform.comapi.wnplatform.n.a aVar = this.p;
        if (aVar == null || !(aVar instanceof com.baidu.platform.comapi.walknavi.g.a) || (k = ((com.baidu.platform.comapi.walknavi.g.a) aVar).k()) == null) {
            return;
        }
        k.a(iWMoreNPCModelOnClickListener);
    }

    public void a(IWNPCLoadAndInitListener iWNPCLoadAndInitListener) {
        com.baidu.platform.comapi.walknavi.g.b.c k;
        com.baidu.platform.comapi.wnplatform.n.a aVar = this.p;
        if (aVar == null || !(aVar instanceof com.baidu.platform.comapi.walknavi.g.a) || (k = ((com.baidu.platform.comapi.walknavi.g.a) aVar).k()) == null) {
            return;
        }
        k.a(iWNPCLoadAndInitListener);
    }

    public boolean b(int i) {
        if (D() != null) {
            return this.f9458f.i(i);
        }
        return false;
    }

    public void b(LatLng latLng) {
        this.D = latLng;
    }

    public boolean a(Activity activity, Bundle bundle) {
        boolean a2;
        D().p();
        this.y = activity;
        try {
            if (bundle != null) {
                com.baidu.platform.comapi.walknavi.g.a.b.f9625a = bundle.getInt("wnavi_mode", 1);
            } else {
                com.baidu.platform.comapi.walknavi.g.a.b.f9625a = 1;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
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
        com.baidu.platform.comapi.wnplatform.n.a aVar = this.p;
        if (aVar == null || aVar.c()) {
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
            WLocData wLocData = this.E;
            GeoPoint ll2mc = CoordUtil.ll2mc(new LatLng(wLocData.latitude, wLocData.longitude));
            a().D().a((int) ll2mc.getLongitudeE6(), (int) ll2mc.getLatitudeE6(), 0);
        }
        q();
        int i = com.baidu.platform.comapi.walknavi.g.a.b.f9625a;
        if (i == 1) {
            P().b(activity);
        } else if (i == 3) {
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

    public void a(Context context, a.b bVar, int i) {
        if (context == null) {
            return;
        }
        if (((WifiManager) context.getSystemService("wifi")).isWifiEnabled()) {
            bVar.a(i);
        } else if (i == 1 || i == 3) {
        }
    }

    public void a(boolean z, boolean z2) {
        if (z) {
            a(this.y, new f(this), com.baidu.platform.comapi.wnplatform.o.f.a(z2));
            return;
        }
        a().a(false);
    }

    public void a(int i, boolean z) {
        com.baidu.platform.comapi.wnplatform.a.a().a(i);
        IWNaviStatusListener iWNaviStatusListener = this.t;
        if (iWNaviStatusListener != null) {
            iWNaviStatusListener.onWalkNaviModeChange(i, new h(this, i, z));
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

    public void a(LatLng latLng) {
        this.C = latLng;
    }

    private void a(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PHONE_STATE");
            intentFilter.setPriority(Integer.MAX_VALUE);
            context.registerReceiver(this.Q, intentFilter);
        } catch (Exception unused) {
        }
    }
}
