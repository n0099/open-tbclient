package com.baidu.mapsdkplatform.comapi.map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.baidu.mapapi.UIMsg;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapBaseIndoorMapInfo;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.model.ParcelItem;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.j;
import com.baidu.mapsdkplatform.comjni.map.basemap.BaseMapCallback;
import com.baidu.mapsdkplatform.comjni.map.basemap.JNIBaseMap;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.kwad.sdk.core.config.item.TipsConfigItem;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public class e implements com.baidu.mapsdkplatform.comjni.map.basemap.b {
    public static int O;
    public static int P;
    public static List<JNIBaseMap> as;
    public aj C;
    public ai D;
    public Context E;
    public List<d> F;
    public x G;
    public g H;
    public ae I;
    public ah J;
    public n K;
    public com.baidu.mapsdkplatform.comapi.map.a L;
    public o M;
    public af N;
    public int Q;
    public int R;
    public int S;
    public VelocityTracker U;
    public long V;
    public long W;
    public long X;
    public long Y;
    public int Z;
    public float aa;
    public float ab;
    public boolean ac;
    public long ad;
    public long ae;
    public float ah;
    public float ai;
    public float aj;
    public float ak;
    public f an;
    public String ao;
    public int ap;
    public b aq;
    public c ar;
    public com.baidu.mapsdkplatform.comjni.map.basemap.a i;
    public long j;
    public boolean k;
    public int l;
    public boolean n;
    public boolean o;
    public boolean p;
    public LatLngBounds q;
    public MapStatus r;
    public boolean t;
    public boolean u;
    public static final String s = j.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    public static float f7612d = 1096.0f;
    public static long m = 0;

    /* renamed from: a  reason: collision with root package name */
    public float f7613a = 21.0f;

    /* renamed from: b  reason: collision with root package name */
    public float f7614b = 4.0f;

    /* renamed from: c  reason: collision with root package name */
    public float f7615c = 21.0f;
    public boolean v = true;
    public boolean w = false;
    public boolean x = false;
    public boolean y = false;
    public boolean z = true;

    /* renamed from: e  reason: collision with root package name */
    public boolean f7616e = true;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7617f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f7618g = false;
    public boolean A = true;
    public boolean B = false;
    public j.a T = new j.a();
    public boolean af = false;
    public boolean ag = false;
    public long al = 0;
    public long am = 0;
    public boolean at = false;
    public Queue<a> au = new LinkedList();

    /* renamed from: h  reason: collision with root package name */
    public List<l> f7619h = new ArrayList();

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f7620a;

        /* renamed from: b  reason: collision with root package name */
        public int f7621b;

        /* renamed from: c  reason: collision with root package name */
        public int f7622c;

        /* renamed from: d  reason: collision with root package name */
        public int f7623d;

        /* renamed from: e  reason: collision with root package name */
        public Bundle f7624e;

        public a(long j, int i, int i2, int i3) {
            this.f7620a = j;
            this.f7621b = i;
            this.f7622c = i2;
            this.f7623d = i3;
        }

        public a(Bundle bundle) {
            this.f7624e = bundle;
        }
    }

    public e(Context context, String str, int i) {
        this.E = context;
        this.ao = str;
        this.ap = i;
    }

    private void Q() {
        if (!this.x && !this.u && !this.t && !this.y) {
            this.f7613a = this.f7615c;
            return;
        }
        if (this.f7613a > 20.0f) {
            this.f7613a = 20.0f;
        }
        if (E().f7570a > 20.0f) {
            ab E = E();
            E.f7570a = 20.0f;
            a(E);
        }
    }

    private void R() {
        if (this.n) {
            return;
        }
        this.n = true;
        this.o = false;
        List<l> list = this.f7619h;
        if (list != null) {
            for (l lVar : list) {
                if (lVar != null) {
                    lVar.a(E());
                }
            }
        }
    }

    private boolean S() {
        if (this.i == null || !this.k) {
            return true;
        }
        this.ag = false;
        if (this.f7616e) {
            float f2 = (float) (this.am - this.al);
            float abs = (Math.abs(this.aj - this.ah) * 1000.0f) / f2;
            float abs2 = (Math.abs(this.ak - this.ai) * 1000.0f) / f2;
            float sqrt = (float) Math.sqrt((abs * abs) + (abs2 * abs2));
            if (sqrt <= 500.0f) {
                return false;
            }
            A();
            a(34, (int) (sqrt * 0.6f), (((int) this.ak) << 16) | ((int) this.aj));
            L();
            return true;
        }
        return false;
    }

    private Activity a(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return a(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    private void a(d dVar) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.i;
        if (aVar == null) {
            return;
        }
        dVar.f7608a = aVar.a(dVar.f7610c, dVar.f7611d, dVar.f7609b);
        this.F.add(dVar);
    }

    private void a(String str, String str2, long j) {
        try {
            Class<?> cls = Class.forName(str);
            cls.getMethod(str2, Long.TYPE).invoke(cls.newInstance(), Long.valueOf(j));
        } catch (Exception unused) {
        }
    }

    private void b(MotionEvent motionEvent) {
        if (this.T.f7646e) {
            return;
        }
        long downTime = motionEvent.getDownTime();
        this.ae = downTime;
        if (downTime - this.ad < 400) {
            downTime = (Math.abs(motionEvent.getX() - this.aa) >= 120.0f || Math.abs(motionEvent.getY() - this.ab) >= 120.0f) ? this.ae : 0L;
        }
        this.ad = downTime;
        this.aa = motionEvent.getX();
        this.ab = motionEvent.getY();
        a(4, 0, (((int) motionEvent.getY()) << 16) | ((int) motionEvent.getX()));
        this.ac = true;
    }

    private void b(String str, Bundle bundle) {
        if (this.i == null) {
            return;
        }
        this.H.a(str);
        this.H.a(bundle);
        this.i.b(this.H.f7608a);
    }

    private boolean c(MotionEvent motionEvent) {
        if (!this.T.f7646e && System.currentTimeMillis() - m >= 300) {
            if (this.p) {
                List<l> list = this.f7619h;
                if (list != null) {
                    for (l lVar : list) {
                        GeoPoint b2 = b((int) motionEvent.getX(), (int) motionEvent.getY());
                        if (lVar != null) {
                            lVar.d(b2);
                        }
                    }
                }
                return true;
            }
            float abs = Math.abs(motionEvent.getX() - this.aa);
            float abs2 = Math.abs(motionEvent.getY() - this.ab);
            int i = (SysOSUtil.getDensity() > 1.5d ? 1 : (SysOSUtil.getDensity() == 1.5d ? 0 : -1));
            double density = SysOSUtil.getDensity();
            if (i > 0) {
                density *= 1.5d;
            }
            float f2 = (float) density;
            if (!this.ac || abs / f2 > 3.0f || abs2 / f2 > 3.0f) {
                this.ac = false;
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (x < 0) {
                    x = 0;
                }
                if (y < 0) {
                    y = 0;
                }
                if (this.f7616e) {
                    BaiduMap.mapStatusReason = 1 | BaiduMap.mapStatusReason;
                    R();
                    a(3, 0, (y << 16) | x);
                }
                return false;
            }
            return true;
        }
        return true;
    }

    private boolean d(MotionEvent motionEvent) {
        if (this.p) {
            List<l> list = this.f7619h;
            if (list != null) {
                for (l lVar : list) {
                    GeoPoint b2 = b((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (lVar != null) {
                        lVar.e(b2);
                    }
                }
            }
            this.p = false;
            return true;
        }
        boolean z = !this.T.f7646e && motionEvent.getEventTime() - this.ae < 400 && Math.abs(motionEvent.getX() - this.aa) < 10.0f && Math.abs(motionEvent.getY() - this.ab) < 10.0f;
        L();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (z) {
            return false;
        }
        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
        a(5, 0, (y << 16) | x);
        return true;
    }

    private boolean e(float f2, float f3) {
        if (this.i == null || !this.k) {
            return true;
        }
        this.af = false;
        GeoPoint b2 = b((int) f2, (int) f3);
        if (b2 != null) {
            List<l> list = this.f7619h;
            if (list != null) {
                for (l lVar : list) {
                    if (lVar != null) {
                        lVar.b(b2);
                    }
                }
            }
            if (this.f7617f) {
                ab E = E();
                E.f7570a += 1.0f;
                E.f7573d = b2.getLongitudeE6();
                E.f7574e = b2.getLatitudeE6();
                a(E, 300);
                m = System.currentTimeMillis();
                return true;
            }
        }
        return false;
    }

    private boolean e(Bundle bundle) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.i;
        if (aVar == null) {
            return false;
        }
        return aVar.e(bundle);
    }

    private boolean f(Bundle bundle) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        if (bundle == null || (aVar = this.i) == null) {
            return false;
        }
        boolean d2 = aVar.d(bundle);
        if (d2) {
            e(d2);
            this.i.b(this.C.f7608a);
        }
        return d2;
    }

    private void g(Bundle bundle) {
        int i;
        int i2;
        if (bundle.get("param") == null ? (i = bundle.getInt("type")) != h.ground.ordinal() && i < h.arc.ordinal() : (i2 = (bundle = (Bundle) bundle.get("param")).getInt("type")) != h.ground.ordinal() && i2 < h.arc.ordinal()) {
            h.popup.ordinal();
        }
        bundle.putLong("layer_addr", this.J.f7608a);
    }

    public static void l(boolean z) {
        List<JNIBaseMap> b2 = com.baidu.mapsdkplatform.comjni.map.basemap.a.b();
        as = b2;
        if (b2 == null || b2.size() == 0) {
            com.baidu.mapsdkplatform.comjni.map.basemap.a.b(0L, z);
            return;
        }
        com.baidu.mapsdkplatform.comjni.map.basemap.a.b(as.get(0).f7897a, z);
        for (JNIBaseMap jNIBaseMap : as) {
            if (jNIBaseMap != null) {
                jNIBaseMap.ClearLayer(jNIBaseMap.f7897a, -1L);
            }
        }
    }

    public void A() {
        if (this.n || this.o) {
            return;
        }
        this.o = true;
        List<l> list = this.f7619h;
        if (list == null) {
            return;
        }
        for (l lVar : list) {
            if (lVar != null) {
                lVar.a(E());
            }
        }
    }

    public void B() {
        this.o = false;
        this.n = false;
        List<l> list = this.f7619h;
        if (list == null) {
            return;
        }
        for (l lVar : list) {
            if (lVar != null) {
                lVar.c(E());
            }
        }
    }

    public boolean C() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.i;
        if (aVar != null) {
            return aVar.a(this.I.f7608a);
        }
        return false;
    }

    public boolean D() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.i;
        if (aVar != null) {
            return aVar.a(this.ar.f7608a);
        }
        return false;
    }

    public ab E() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.i;
        if (aVar == null) {
            return null;
        }
        Bundle h2 = aVar.h();
        ab abVar = new ab();
        abVar.a(h2);
        return abVar;
    }

    public LatLngBounds F() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.i;
        if (aVar == null) {
            return null;
        }
        Bundle i = aVar.i();
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        int i2 = i.getInt("maxCoorx");
        int i3 = i.getInt("minCoorx");
        builder.include(CoordUtil.mc2ll(new GeoPoint(i.getInt("minCoory"), i2))).include(CoordUtil.mc2ll(new GeoPoint(i.getInt("maxCoory"), i3)));
        return builder.build();
    }

    public int G() {
        return this.Q;
    }

    public int H() {
        return this.R;
    }

    public ab I() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.i;
        if (aVar == null) {
            return null;
        }
        Bundle j = aVar.j();
        ab abVar = new ab();
        abVar.a(j);
        return abVar;
    }

    public double J() {
        return E().m;
    }

    public void K() {
        List<l> list;
        this.n = false;
        if (this.o || (list = this.f7619h) == null) {
            return;
        }
        for (l lVar : list) {
            if (lVar != null) {
                lVar.c(E());
            }
        }
    }

    public void L() {
        this.S = 0;
        j.a aVar = this.T;
        aVar.f7646e = false;
        aVar.f7649h = 0.0d;
    }

    public float[] M() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.i;
        if (aVar == null) {
            return null;
        }
        return aVar.u();
    }

    public float[] N() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.i;
        if (aVar == null) {
            return null;
        }
        return aVar.v();
    }

    public Queue<a> O() {
        return this.au;
    }

    public void P() {
        if (this.au.isEmpty()) {
            return;
        }
        a poll = this.au.poll();
        if (poll.f7624e == null) {
            com.baidu.mapsdkplatform.comjni.map.basemap.a.a(poll.f7620a, poll.f7621b, poll.f7622c, poll.f7623d);
        } else if (this.i != null) {
            A();
            this.i.a(poll.f7624e);
        }
    }

    public float a(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.k) {
            if (this.i == null) {
                return 0.0f;
            }
            Bundle bundle = new Bundle();
            bundle.putInt(CustomDialogData.POS_LEFT, i);
            bundle.putInt("right", i3);
            bundle.putInt(TipsConfigItem.TipConfigData.BOTTOM, i4);
            bundle.putInt("top", i2);
            bundle.putInt("hasHW", 1);
            bundle.putInt("width", i5);
            bundle.putInt("height", i6);
            return this.i.c(bundle);
        }
        return 12.0f;
    }

    public int a(int i, int i2, int i3) {
        if (this.at) {
            this.au.add(new a(this.j, i, i2, i3));
            return 0;
        }
        return com.baidu.mapsdkplatform.comjni.map.basemap.a.a(this.j, i, i2, i3);
    }

    @Override // com.baidu.mapsdkplatform.comjni.map.basemap.b
    public int a(Bundle bundle, long j, int i, Bundle bundle2) {
        ag agVar;
        g gVar = this.H;
        if (j == gVar.f7608a) {
            bundle.putString("jsondata", gVar.a());
            bundle.putBundle("param", this.H.b());
            agVar = this.H;
        } else {
            x xVar = this.G;
            if (j == xVar.f7608a) {
                bundle.putString("jsondata", xVar.a());
                bundle.putBundle("param", this.G.b());
                agVar = this.G;
            } else if (j == this.K.f7608a) {
                bundle.putBundle("param", this.M.a(bundle2.getInt("x"), bundle2.getInt("y"), bundle2.getInt("zoom")));
                agVar = this.K;
            } else if (j != this.C.f7608a) {
                return 0;
            } else {
                bundle.putBundle("param", this.D.a(bundle2.getInt("x"), bundle2.getInt("y"), bundle2.getInt("zoom"), this.E));
                agVar = this.C;
            }
        }
        return agVar.f7599g;
    }

    public Point a(GeoPoint geoPoint) {
        return this.N.a(geoPoint);
    }

    public void a() {
        this.F = new ArrayList();
        f fVar = new f();
        this.an = fVar;
        a(fVar);
        b bVar = new b();
        this.aq = bVar;
        a(bVar);
        n nVar = new n();
        this.K = nVar;
        a(nVar);
        com.baidu.mapsdkplatform.comapi.map.a aVar = new com.baidu.mapsdkplatform.comapi.map.a();
        this.L = aVar;
        a(aVar);
        a(new p());
        ae aeVar = new ae();
        this.I = aeVar;
        a(aeVar);
        c cVar = new c();
        this.ar = cVar;
        a(cVar);
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar2 = this.i;
        if (aVar2 != null) {
            aVar2.e(false);
        }
        ah ahVar = new ah();
        this.J = ahVar;
        a(ahVar);
        g gVar = new g();
        this.H = gVar;
        a(gVar);
        x xVar = new x();
        this.G = xVar;
        a(xVar);
    }

    public void a(float f2, float f3) {
        this.f7613a = f2;
        this.f7615c = f2;
        this.f7614b = f3;
    }

    public void a(int i) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = new com.baidu.mapsdkplatform.comjni.map.basemap.a();
        this.i = aVar;
        aVar.a(i);
        long a2 = this.i.a();
        this.j = a2;
        a("com.baidu.platform.comapi.wnplatform.walkmap.WNaviBaiduMap", "setId", a2);
        this.l = SysOSUtil.getDensityDpi() < 180 ? 18 : SysOSUtil.getDensityDpi() < 240 ? 25 : SysOSUtil.getDensityDpi() < 320 ? 37 : 50;
        String moduleFileName = SysOSUtil.getModuleFileName();
        String appSDCardPath = EnvironmentUtilities.getAppSDCardPath();
        String appCachePath = EnvironmentUtilities.getAppCachePath();
        String appSecondCachePath = EnvironmentUtilities.getAppSecondCachePath();
        int mapTmpStgMax = EnvironmentUtilities.getMapTmpStgMax();
        int domTmpStgMax = EnvironmentUtilities.getDomTmpStgMax();
        int itsTmpStgMax = EnvironmentUtilities.getItsTmpStgMax();
        String str = SysOSUtil.getDensityDpi() >= 180 ? "/h/" : "/l/";
        String str2 = moduleFileName + "/cfg";
        String str3 = appSDCardPath + "/vmp";
        String str4 = str2 + "/a/";
        String str5 = str2 + "/a/";
        String str6 = str2 + "/idrres/";
        String str7 = str3 + str;
        String str8 = str3 + str;
        String str9 = appCachePath + "/tmp/";
        String str10 = appSecondCachePath + "/tmp/";
        Activity a3 = a(this.E);
        if (a3 == null) {
            throw new RuntimeException("Please give the right context.");
        }
        Display defaultDisplay = a3.getWindowManager().getDefaultDisplay();
        this.i.a(str4, str7, str9, str10, str8, str5, this.ao, this.ap, str6, defaultDisplay.getWidth(), defaultDisplay.getHeight(), SysOSUtil.getDensityDpi(), mapTmpStgMax, domTmpStgMax, itsTmpStgMax, 0);
    }

    public void a(int i, int i2) {
        this.Q = i;
        this.R = i2;
    }

    public void a(long j, long j2, long j3, long j4, boolean z) {
        this.i.a(j, j2, j3, j4, z);
    }

    public void a(Bitmap bitmap) {
        Bundle bundle;
        if (this.i == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("type", 0);
            jSONObject2.put("x", O);
            jSONObject2.put("y", P);
            jSONObject2.put("hidetime", 1000);
            jSONArray.put(jSONObject2);
            jSONObject.put("data", jSONArray);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (bitmap == null) {
            bundle = null;
        } else {
            Bundle bundle2 = new Bundle();
            ArrayList arrayList = new ArrayList();
            ParcelItem parcelItem = new ParcelItem();
            Bundle bundle3 = new Bundle();
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getWidth() * bitmap.getHeight() * 4);
            bitmap.copyPixelsToBuffer(allocate);
            bundle3.putByteArray("imgdata", allocate.array());
            bundle3.putInt("imgindex", bitmap.hashCode());
            bundle3.putInt("imgH", bitmap.getHeight());
            bundle3.putInt("imgW", bitmap.getWidth());
            bundle3.putInt("hasIcon", 1);
            parcelItem.setBundle(bundle3);
            arrayList.add(parcelItem);
            if (arrayList.size() > 0) {
                ParcelItem[] parcelItemArr = new ParcelItem[arrayList.size()];
                for (int i = 0; i < arrayList.size(); i++) {
                    parcelItemArr[i] = (ParcelItem) arrayList.get(i);
                }
                bundle2.putParcelableArray("icondata", parcelItemArr);
            }
            bundle = bundle2;
        }
        b(jSONObject.toString(), bundle);
        this.i.b(this.H.f7608a);
    }

    public void a(Handler handler) {
        MessageCenter.registMessage(4000, handler);
        MessageCenter.registMessage(39, handler);
        MessageCenter.registMessage(41, handler);
        MessageCenter.registMessage(49, handler);
        MessageCenter.registMessage(UIMsg.m_AppUI.V_WM_VDATAENGINE, handler);
        MessageCenter.registMessage(50, handler);
        MessageCenter.registMessage(999, handler);
        BaseMapCallback.addLayerDataInterface(this.j, this);
    }

    public void a(LatLngBounds latLngBounds) {
        if (latLngBounds == null || this.i == null) {
            return;
        }
        LatLng latLng = latLngBounds.northeast;
        LatLng latLng2 = latLngBounds.southwest;
        GeoPoint ll2mc = CoordUtil.ll2mc(latLng);
        GeoPoint ll2mc2 = CoordUtil.ll2mc(latLng2);
        int longitudeE6 = (int) ll2mc2.getLongitudeE6();
        int latitudeE6 = (int) ll2mc.getLatitudeE6();
        Bundle bundle = new Bundle();
        bundle.putInt("maxCoorx", (int) ll2mc.getLongitudeE6());
        bundle.putInt("minCoory", (int) ll2mc2.getLatitudeE6());
        bundle.putInt("minCoorx", longitudeE6);
        bundle.putInt("maxCoory", latitudeE6);
        this.i.b(bundle);
    }

    public void a(ab abVar) {
        if (this.i == null || abVar == null) {
            return;
        }
        Bundle a2 = abVar.a(this);
        a2.putInt("animation", 0);
        a2.putInt("animatime", 0);
        this.i.a(a2);
    }

    public void a(ab abVar, int i) {
        if (this.i == null) {
            return;
        }
        Bundle a2 = abVar.a(this);
        a2.putInt("animation", 1);
        a2.putInt("animatime", i);
        if (this.at) {
            this.au.add(new a(a2));
            return;
        }
        A();
        this.i.a(a2);
    }

    public void a(ai aiVar) {
        this.D = aiVar;
    }

    public void a(l lVar) {
        if (lVar == null) {
            return;
        }
        this.f7619h.add(lVar);
    }

    public void a(o oVar) {
        this.M = oVar;
    }

    public void a(z zVar) {
        new ab();
        if (zVar == null) {
            zVar = new z();
        }
        ab abVar = zVar.f7686a;
        this.z = zVar.f7691f;
        this.A = zVar.f7689d;
        this.f7616e = zVar.f7690e;
        this.f7617f = zVar.f7692g;
        this.i.a(abVar.a(this));
        this.i.c(y.DEFAULT.ordinal());
        boolean z = zVar.f7687b;
        this.v = z;
        if (z) {
            O = (int) (SysOSUtil.getDensity() * 40.0f);
            P = (int) (SysOSUtil.getDensity() * 40.0f);
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("x", O);
                jSONObject2.put("y", P);
                jSONObject2.put("hidetime", 1000);
                jSONArray.put(jSONObject2);
                jSONObject.put("data", jSONArray);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.H.a(jSONObject.toString());
            this.i.a(this.H.f7608a, true);
        } else {
            this.i.a(this.H.f7608a, false);
        }
        int i = zVar.f7688c;
        if (i == 2) {
            a(true);
        }
        if (i == 3) {
            this.i.a(this.an.f7608a, false);
            this.i.a(this.ar.f7608a, false);
            this.i.a(this.I.f7608a, false);
            this.i.e(false);
        }
    }

    public void a(String str, Bundle bundle) {
        if (this.i == null) {
            return;
        }
        this.G.a(str);
        this.G.a(bundle);
        this.i.b(this.G.f7608a);
    }

    public void a(List<Bundle> list) {
        if (this.i == null || list == null) {
            return;
        }
        int size = list.size();
        Bundle[] bundleArr = new Bundle[list.size()];
        for (int i = 0; i < size; i++) {
            g(list.get(i));
            bundleArr[i] = list.get(i);
        }
        this.i.a(bundleArr);
    }

    public void a(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.i;
        if (aVar == null) {
            return;
        }
        if (!aVar.a(this.an.f7608a)) {
            this.i.a(this.an.f7608a, true);
        }
        this.u = z;
        Q();
        this.i.a(this.u);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00ae A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(float f2, float f3, float f4, float f5) {
        float f6;
        j.a aVar;
        boolean z;
        float f7;
        float f8;
        int i;
        int i2;
        float f9;
        float f10;
        int i3 = this.R;
        float f11 = i3 - f3;
        float f12 = i3 - f5;
        j.a aVar2 = this.T;
        if (aVar2.f7646e) {
            if (this.S == 0) {
                if (aVar2.f7644c - f11 <= 0.0f || aVar2.f7645d - f12 <= 0.0f) {
                    j.a aVar3 = this.T;
                    if (aVar3.f7644c - f11 >= 0.0f || aVar3.f7645d - f12 >= 0.0f) {
                        z = true;
                        this.S = 2;
                        if (this.S == 0) {
                            return z;
                        }
                    }
                }
                double atan2 = Math.atan2(f12 - f11, f4 - f2);
                j.a aVar4 = this.T;
                double atan22 = atan2 - Math.atan2(aVar4.f7645d - aVar4.f7644c, aVar4.f7643b - aVar4.f7642a);
                double sqrt = Math.sqrt((f10 * f10) + (f9 * f9)) / this.T.f7649h;
                int log = (int) ((Math.log(sqrt) / Math.log(2.0d)) * 10000.0d);
                int i4 = (int) ((atan22 * 180.0d) / 3.1416d);
                if ((sqrt <= 0.0d || (log <= 3000 && log >= -3000)) && Math.abs(i4) < 10) {
                    z = true;
                    this.S = 1;
                } else {
                    this.S = 2;
                    z = true;
                }
                if (this.S == 0) {
                }
            } else {
                z = true;
            }
            if (this.S == z && this.z) {
                j.a aVar5 = this.T;
                if (aVar5.f7644c - f11 <= 0.0f || aVar5.f7645d - f12 <= 0.0f) {
                    j.a aVar6 = this.T;
                    if (aVar6.f7644c - f11 < 0.0f && aVar6.f7645d - f12 < 0.0f) {
                        R();
                        i2 = 87;
                    }
                } else {
                    R();
                    i2 = 83;
                }
                a(1, i2, 0);
            } else {
                int i5 = this.S;
                if (i5 == 2 || i5 == 4 || i5 == 3) {
                    double atan23 = Math.atan2(f12 - f11, f4 - f2);
                    j.a aVar7 = this.T;
                    double atan24 = atan23 - Math.atan2(aVar7.f7645d - aVar7.f7644c, aVar7.f7643b - aVar7.f7642a);
                    double sqrt2 = Math.sqrt((f8 * f8) + (f7 * f7)) / this.T.f7649h;
                    int log2 = (int) ((Math.log(sqrt2) / Math.log(2.0d)) * 10000.0d);
                    j.a aVar8 = this.T;
                    double atan25 = Math.atan2(aVar8.f7648g - aVar8.f7644c, aVar8.f7647f - aVar8.f7642a);
                    j.a aVar9 = this.T;
                    float f13 = aVar9.f7647f;
                    float f14 = aVar9.f7642a;
                    float f15 = (f13 - f14) * (f13 - f14);
                    float f16 = aVar9.f7648g;
                    float f17 = aVar9.f7644c;
                    double sqrt3 = Math.sqrt(f15 + ((f16 - f17) * (f16 - f17)));
                    double d2 = atan25 + atan24;
                    f6 = f12;
                    float cos = (float) ((Math.cos(d2) * sqrt3 * sqrt2) + f2);
                    float sin = (float) ((sqrt3 * Math.sin(d2) * sqrt2) + f11);
                    int i6 = (int) ((atan24 * 180.0d) / 3.1416d);
                    if (sqrt2 > 0.0d && (3 == this.S || (Math.abs(log2) > 2000 && 2 == this.S))) {
                        this.S = 3;
                        float f18 = E().f7570a;
                        if (this.f7617f) {
                            if (sqrt2 <= 1.0d) {
                                i = 3;
                                if (f18 <= this.f7614b) {
                                    return false;
                                }
                                R();
                            } else if (f18 >= this.f7613a) {
                                return false;
                            } else {
                                R();
                                i = 3;
                            }
                            a(UIMsg.k_event.V_WM_ROTATE, i, log2);
                        }
                    } else if (i6 != 0 && (4 == this.S || (Math.abs(i6) > 10 && 2 == this.S))) {
                        this.S = 4;
                        if (this.A) {
                            BaiduMap.mapStatusReason |= 1;
                            R();
                            a(UIMsg.k_event.V_WM_ROTATE, 1, i6);
                        }
                    }
                    j.a aVar10 = this.T;
                    aVar10.f7647f = cos;
                    aVar10.f7648g = sin;
                    if (2 != this.S) {
                        j.a aVar11 = this.T;
                        aVar11.f7644c = f11;
                        aVar11.f7645d = f6;
                        aVar11.f7642a = f2;
                        aVar11.f7643b = f4;
                    }
                    aVar = this.T;
                    if (aVar.f7646e) {
                        aVar.f7647f = this.Q / 2;
                        aVar.f7648g = this.R / 2;
                        aVar.f7646e = true;
                        if (0.0d == aVar.f7649h) {
                            float f19 = aVar.f7643b;
                            float f20 = aVar.f7642a;
                            float f21 = (f19 - f20) * (f19 - f20);
                            float f22 = aVar.f7645d;
                            float f23 = aVar.f7644c;
                            this.T.f7649h = Math.sqrt(f21 + ((f22 - f23) * (f22 - f23)));
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
            }
        }
        f6 = f12;
        if (2 != this.S) {
        }
        aVar = this.T;
        if (aVar.f7646e) {
        }
    }

    @Override // com.baidu.mapsdkplatform.comjni.map.basemap.b
    public boolean a(long j) {
        Iterator<d> it = this.F.iterator();
        while (it.hasNext()) {
            if (it.next().f7608a == j) {
                return true;
            }
        }
        return false;
    }

    public boolean a(Point point) {
        int i;
        int i2;
        if (point != null && this.i != null && (i = point.x) >= 0 && (i2 = point.y) >= 0) {
            O = i;
            P = i2;
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("x", O);
                jSONObject2.put("y", P);
                jSONObject2.put("hidetime", 1000);
                jSONArray.put(jSONObject2);
                jSONObject.put("data", jSONArray);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.H.a(jSONObject.toString());
            this.i.b(this.H.f7608a);
            return true;
        }
        return false;
    }

    public boolean a(Bundle bundle) {
        if (this.i == null) {
            return false;
        }
        aj ajVar = new aj();
        this.C = ajVar;
        long a2 = this.i.a(ajVar.f7610c, ajVar.f7611d, ajVar.f7609b);
        if (a2 != 0) {
            aj ajVar2 = this.C;
            ajVar2.f7608a = a2;
            this.F.add(ajVar2);
            bundle.putLong("sdktileaddr", a2);
            if (e(bundle) && f(bundle)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:160:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01bf A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(MotionEvent motionEvent) {
        int i;
        float xVelocity;
        float f2;
        j.a aVar;
        float f3;
        boolean z;
        float f4;
        float f5;
        e eVar;
        int i2;
        int i3;
        int i4;
        int i5;
        float f6;
        float f7;
        j.a aVar2;
        ab E;
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 2 && (!c((int) motionEvent.getX(0), (int) motionEvent.getY(0)) || !c((int) motionEvent.getX(1), (int) motionEvent.getY(1)))) {
            pointerCount = 1;
        }
        if (pointerCount != 2) {
            int action = motionEvent.getAction();
            if (action == 0) {
                b(motionEvent);
            } else if (action == 1) {
                return d(motionEvent);
            } else {
                if (action != 2) {
                    return false;
                }
                c(motionEvent);
            }
            return true;
        }
        float y = this.R - motionEvent.getY(0);
        float y2 = this.R - motionEvent.getY(1);
        float x = motionEvent.getX(0);
        float x2 = motionEvent.getX(1);
        int action2 = motionEvent.getAction();
        if (action2 != 5) {
            if (action2 == 6) {
                this.Y = motionEvent.getEventTime();
            } else if (action2 != 261) {
                if (action2 == 262) {
                    this.X = motionEvent.getEventTime();
                }
                if (this.U == null) {
                    this.U = VelocityTracker.obtain();
                }
                this.U.addMovement(motionEvent);
                int minimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
                this.U.computeCurrentVelocity(1000, ViewConfiguration.getMaximumFlingVelocity());
                xVelocity = this.U.getXVelocity(1);
                float yVelocity = this.U.getYVelocity(1);
                float xVelocity2 = this.U.getXVelocity(2);
                float yVelocity2 = this.U.getYVelocity(2);
                f2 = minimumFlingVelocity;
                if (Math.abs(xVelocity) <= f2 || Math.abs(yVelocity) > f2 || Math.abs(xVelocity2) > f2 || Math.abs(yVelocity2) > f2) {
                    aVar = this.T;
                    if (aVar.f7646e) {
                        if (this.S == 0) {
                            if (aVar.f7644c - y <= 0.0f || aVar.f7645d - y2 <= 0.0f) {
                                j.a aVar3 = this.T;
                                if (aVar3.f7644c - y >= 0.0f || aVar3.f7645d - y2 >= 0.0f) {
                                    f3 = y2;
                                    z = true;
                                    this.S = 2;
                                    if (this.S == 0) {
                                        return z;
                                    }
                                }
                            }
                            f3 = y2;
                            double atan2 = Math.atan2(y2 - y, x2 - x);
                            j.a aVar4 = this.T;
                            double atan22 = atan2 - Math.atan2(aVar4.f7645d - aVar4.f7644c, aVar4.f7643b - aVar4.f7642a);
                            double sqrt = Math.sqrt((f7 * f7) + (f6 * f6)) / this.T.f7649h;
                            int log = (int) ((Math.log(sqrt) / Math.log(2.0d)) * 10000.0d);
                            int i6 = (int) ((atan22 * 180.0d) / 3.1416d);
                            if ((sqrt <= 0.0d || (log <= 3000 && log >= -3000)) && Math.abs(i6) < 10) {
                                z = true;
                                this.S = 1;
                            } else {
                                this.S = 2;
                                z = true;
                            }
                            if (this.S == 0) {
                            }
                        } else {
                            f3 = y2;
                            z = true;
                        }
                        if (this.S == z && this.z) {
                            j.a aVar5 = this.T;
                            if (aVar5.f7644c - y <= 0.0f || aVar5.f7645d - f3 <= 0.0f) {
                                j.a aVar6 = this.T;
                                if (aVar6.f7644c - y < 0.0f && aVar6.f7645d - f3 < 0.0f) {
                                    i4 = 1;
                                    BaiduMap.mapStatusReason |= 1;
                                    R();
                                    i5 = 87;
                                }
                            } else {
                                i4 = 1;
                                BaiduMap.mapStatusReason |= 1;
                                R();
                                i5 = 83;
                            }
                            a(i4, i5, 0);
                        } else {
                            int i7 = this.S;
                            if (i7 == 2 || i7 == 4 || i7 == 3) {
                                double atan23 = Math.atan2(f3 - y, x2 - x);
                                j.a aVar7 = this.T;
                                double atan24 = atan23 - Math.atan2(aVar7.f7645d - aVar7.f7644c, aVar7.f7643b - aVar7.f7642a);
                                double sqrt2 = Math.sqrt((f5 * f5) + (f4 * f4)) / this.T.f7649h;
                                int log2 = (int) ((Math.log(sqrt2) / Math.log(2.0d)) * 10000.0d);
                                j.a aVar8 = this.T;
                                double atan25 = Math.atan2(aVar8.f7648g - aVar8.f7644c, aVar8.f7647f - aVar8.f7642a);
                                j.a aVar9 = this.T;
                                float f8 = aVar9.f7647f;
                                float f9 = aVar9.f7642a;
                                float f10 = aVar9.f7648g;
                                float f11 = aVar9.f7644c;
                                double sqrt3 = Math.sqrt(((f8 - f9) * (f8 - f9)) + ((f10 - f11) * (f10 - f11)));
                                double d2 = atan25 + atan24;
                                float cos = (float) ((Math.cos(d2) * sqrt3 * sqrt2) + x);
                                float sin = (float) ((sqrt3 * Math.sin(d2) * sqrt2) + y);
                                int i8 = (int) ((atan24 * 180.0d) / 3.1416d);
                                eVar = this;
                                if (sqrt2 > 0.0d && (3 == eVar.S || (Math.abs(log2) > 2000 && 2 == eVar.S))) {
                                    eVar.S = 3;
                                    float f12 = E().f7570a;
                                    if (eVar.f7617f) {
                                        if (sqrt2 <= 1.0d) {
                                            i2 = log2;
                                            i3 = 3;
                                            if (f12 <= eVar.f7614b) {
                                                return false;
                                            }
                                            BaiduMap.mapStatusReason |= 1;
                                            R();
                                        } else if (f12 >= eVar.f7613a) {
                                            return false;
                                        } else {
                                            BaiduMap.mapStatusReason |= 1;
                                            R();
                                            i2 = log2;
                                            i3 = 3;
                                        }
                                        eVar.a(UIMsg.k_event.V_WM_ROTATE, i3, i2);
                                    }
                                } else if (i8 != 0 && (4 == eVar.S || (Math.abs(i8) > 10 && 2 == eVar.S))) {
                                    eVar.S = 4;
                                    if (eVar.A) {
                                        R();
                                        eVar.a(UIMsg.k_event.V_WM_ROTATE, 1, i8);
                                    }
                                }
                                j.a aVar10 = eVar.T;
                                aVar10.f7647f = cos;
                                aVar10.f7648g = sin;
                                if (2 != eVar.S) {
                                    j.a aVar11 = eVar.T;
                                    aVar11.f7644c = y;
                                    aVar11.f7645d = f3;
                                    aVar11.f7642a = x;
                                    aVar11.f7643b = x2;
                                }
                                aVar2 = eVar.T;
                                if (aVar2.f7646e) {
                                    return true;
                                }
                                aVar2.f7647f = eVar.Q / 2;
                                aVar2.f7648g = eVar.R / 2;
                                aVar2.f7646e = true;
                                if (0.0d == aVar2.f7649h) {
                                    float f13 = aVar2.f7643b;
                                    float f14 = aVar2.f7642a;
                                    float f15 = (f13 - f14) * (f13 - f14);
                                    float f16 = aVar2.f7645d;
                                    float f17 = aVar2.f7644c;
                                    eVar.T.f7649h = Math.sqrt(f15 + ((f16 - f17) * (f16 - f17)));
                                    return true;
                                }
                                return true;
                            }
                        }
                        eVar = this;
                        if (2 != eVar.S) {
                        }
                        aVar2 = eVar.T;
                        if (aVar2.f7646e) {
                        }
                    }
                } else if (this.S == 0 && this.Z == 0) {
                    long j = this.X;
                    long j2 = this.Y;
                    if (j <= j2) {
                        j = j2;
                    }
                    this.X = j;
                    long j3 = this.V;
                    long j4 = this.W;
                    if (j3 < j4) {
                        j3 = j4;
                    }
                    this.V = j3;
                    if (this.X - j3 < 200 && this.f7617f && (E = E()) != null) {
                        E.f7570a -= 1.0f;
                        BaiduMap.mapStatusReason |= 1;
                        a(E, 300);
                    }
                }
                eVar = this;
                f3 = y2;
                if (2 != eVar.S) {
                }
                aVar2 = eVar.T;
                if (aVar2.f7646e) {
                }
            } else {
                this.V = motionEvent.getEventTime();
            }
            i = this.Z + 1;
            this.Z = i;
            if (this.U == null) {
            }
            this.U.addMovement(motionEvent);
            int minimumFlingVelocity2 = ViewConfiguration.getMinimumFlingVelocity();
            this.U.computeCurrentVelocity(1000, ViewConfiguration.getMaximumFlingVelocity());
            xVelocity = this.U.getXVelocity(1);
            float yVelocity3 = this.U.getYVelocity(1);
            float xVelocity22 = this.U.getXVelocity(2);
            float yVelocity22 = this.U.getYVelocity(2);
            f2 = minimumFlingVelocity2;
            if (Math.abs(xVelocity) <= f2) {
            }
            aVar = this.T;
            if (aVar.f7646e) {
            }
            eVar = this;
            f3 = y2;
            if (2 != eVar.S) {
            }
            aVar2 = eVar.T;
            if (aVar2.f7646e) {
            }
        } else {
            this.W = motionEvent.getEventTime();
        }
        i = this.Z - 1;
        this.Z = i;
        if (this.U == null) {
        }
        this.U.addMovement(motionEvent);
        int minimumFlingVelocity22 = ViewConfiguration.getMinimumFlingVelocity();
        this.U.computeCurrentVelocity(1000, ViewConfiguration.getMaximumFlingVelocity());
        xVelocity = this.U.getXVelocity(1);
        float yVelocity32 = this.U.getYVelocity(1);
        float xVelocity222 = this.U.getXVelocity(2);
        float yVelocity222 = this.U.getYVelocity(2);
        f2 = minimumFlingVelocity22;
        if (Math.abs(xVelocity) <= f2) {
        }
        aVar = this.T;
        if (aVar.f7646e) {
        }
        eVar = this;
        f3 = y2;
        if (2 != eVar.S) {
        }
        aVar2 = eVar.T;
        if (aVar2.f7646e) {
        }
    }

    public boolean a(String str, String str2) {
        return this.i.a(str, str2);
    }

    public GeoPoint b(int i, int i2) {
        return this.N.a(i, i2);
    }

    public void b(float f2, float f3) {
        if (this.T.f7646e) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.ae = currentTimeMillis;
        if (currentTimeMillis - this.ad < 400) {
            if (Math.abs(f2 - this.aa) < 120.0f && Math.abs(f3 - this.ab) < 120.0f) {
                this.ad = 0L;
                this.af = true;
                this.aa = f2;
                this.ab = f3;
                a(4, 0, ((int) f2) | (((int) f3) << 16));
                this.ac = true;
            }
            currentTimeMillis = this.ae;
        }
        this.ad = currentTimeMillis;
        this.aa = f2;
        this.ab = f3;
        a(4, 0, ((int) f2) | (((int) f3) << 16));
        this.ac = true;
    }

    public void b(int i) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.i;
        if (aVar != null) {
            aVar.b(i);
            this.i = null;
        }
    }

    public void b(Bundle bundle) {
        if (this.i == null) {
            return;
        }
        g(bundle);
        this.i.f(bundle);
    }

    public void b(Handler handler) {
        MessageCenter.unregistMessage(4000, handler);
        MessageCenter.unregistMessage(41, handler);
        MessageCenter.unregistMessage(49, handler);
        MessageCenter.unregistMessage(39, handler);
        MessageCenter.unregistMessage(UIMsg.m_AppUI.V_WM_VDATAENGINE, handler);
        MessageCenter.unregistMessage(50, handler);
        MessageCenter.unregistMessage(999, handler);
        BaseMapCallback.removeLayerDataInterface(this.j);
    }

    public void b(boolean z) {
        this.B = z;
    }

    public boolean b() {
        return this.B;
    }

    public void c() {
        if (this.i == null) {
            return;
        }
        for (d dVar : this.F) {
            this.i.a(dVar.f7608a, false);
        }
    }

    public void c(Bundle bundle) {
        if (this.i == null) {
            return;
        }
        g(bundle);
        this.i.g(bundle);
    }

    public void c(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        long j;
        d dVar;
        if (z) {
            aVar = this.i;
            j = this.J.f7608a;
            dVar = this.G;
        } else {
            aVar = this.i;
            j = this.G.f7608a;
            dVar = this.J;
        }
        aVar.a(j, dVar.f7608a);
    }

    public boolean c(float f2, float f3) {
        if (!this.T.f7646e && System.currentTimeMillis() - m >= 300) {
            if (this.p) {
                List<l> list = this.f7619h;
                if (list != null) {
                    for (l lVar : list) {
                        GeoPoint b2 = b((int) f2, (int) f3);
                        if (lVar != null) {
                            lVar.d(b2);
                        }
                    }
                }
                return true;
            }
            float abs = Math.abs(f2 - this.aa);
            float abs2 = Math.abs(f3 - this.ab);
            int i = (SysOSUtil.getDensity() > 1.5d ? 1 : (SysOSUtil.getDensity() == 1.5d ? 0 : -1));
            double density = SysOSUtil.getDensity();
            if (i > 0) {
                density *= 1.5d;
            }
            float f4 = (float) density;
            if (!this.ac || abs / f4 > 3.0f || abs2 / f4 > 3.0f) {
                this.ac = false;
                int i2 = (int) f2;
                int i3 = (int) f3;
                if (i2 < 0) {
                    i2 = 0;
                }
                if (i3 < 0) {
                    i3 = 0;
                }
                if (this.f7616e) {
                    this.ah = this.aj;
                    this.ai = this.ak;
                    this.aj = f2;
                    this.ak = f3;
                    this.al = this.am;
                    this.am = System.currentTimeMillis();
                    this.ag = true;
                    R();
                    a(3, 0, (i3 << 16) | i2);
                }
                return false;
            }
            return true;
        }
        return true;
    }

    public boolean c(int i, int i2) {
        return i >= 0 && i <= this.Q + 0 && i2 >= 0 && i2 <= this.R + 0;
    }

    public void d() {
        if (this.i == null) {
            return;
        }
        for (d dVar : this.F) {
            if ((dVar instanceof x) || (dVar instanceof com.baidu.mapsdkplatform.comapi.map.a) || (dVar instanceof n)) {
                this.i.a(dVar.f7608a, false);
            } else {
                this.i.a(dVar.f7608a, true);
            }
        }
        this.i.c(false);
    }

    public void d(Bundle bundle) {
        if (this.i == null) {
            return;
        }
        g(bundle);
        this.i.h(bundle);
    }

    public void d(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.i;
        if (aVar == null) {
            return;
        }
        aVar.a(this.H.f7608a, z);
    }

    public boolean d(float f2, float f3) {
        if (this.p) {
            List<l> list = this.f7619h;
            if (list != null) {
                for (l lVar : list) {
                    GeoPoint b2 = b((int) f2, (int) f3);
                    if (lVar != null) {
                        lVar.e(b2);
                    }
                }
            }
            this.p = false;
            return true;
        }
        if (!this.T.f7646e) {
            if (this.af) {
                return e(f2, f3);
            }
            if (this.ag) {
                return S();
            }
            if (System.currentTimeMillis() - this.ae < 400 && Math.abs(f2 - this.aa) < 10.0f && Math.abs(f3 - this.ab) < 10.0f) {
                L();
                return true;
            }
        }
        L();
        int i = (int) f2;
        int i2 = (int) f3;
        if (i < 0) {
            i = 0;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        a(5, 0, i | (i2 << 16));
        return true;
    }

    public void e(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.i;
        if (aVar == null) {
            return;
        }
        aVar.a(this.C.f7608a, z);
    }

    public boolean e() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        aj ajVar = this.C;
        if (ajVar == null || (aVar = this.i) == null) {
            return false;
        }
        return aVar.c(ajVar.f7608a);
    }

    public void f() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.i;
        if (aVar == null) {
            return;
        }
        this.N = new af(aVar);
    }

    public void f(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.i;
        if (aVar == null) {
            return;
        }
        aVar.a(this.an.f7608a, z);
    }

    public void g(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.i;
        if (aVar == null) {
            return;
        }
        this.y = z;
        aVar.b(z);
    }

    public boolean g() {
        return this.t;
    }

    public String h() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.i;
        if (aVar == null) {
            return null;
        }
        return aVar.e(this.H.f7608a);
    }

    public void h(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.i;
        if (aVar == null) {
            return;
        }
        this.t = z;
        aVar.c(z);
    }

    public void i(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.i;
        if (aVar == null) {
            return;
        }
        aVar.d(z);
    }

    public boolean i() {
        return this.y;
    }

    public void j(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.i;
        if (aVar == null) {
            return;
        }
        this.v = z;
        aVar.a(this.H.f7608a, z);
    }

    public boolean j() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.i;
        if (aVar == null) {
            return false;
        }
        return aVar.k();
    }

    public void k(boolean z) {
        float f2 = z ? 22.0f : 21.0f;
        this.f7613a = f2;
        this.f7615c = f2;
        this.i.e(z);
        this.i.d(this.aq.f7608a);
        this.i.d(this.ar.f7608a);
    }

    public boolean k() {
        return this.u;
    }

    public boolean l() {
        return this.i.a(this.an.f7608a);
    }

    public void m(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.i;
        if (aVar == null) {
            return;
        }
        this.w = z;
        aVar.a(this.G.f7608a, z);
    }

    public boolean m() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.i;
        if (aVar == null) {
            return false;
        }
        return aVar.o();
    }

    public void n() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.i;
        if (aVar == null) {
            return;
        }
        aVar.d(this.J.f7608a);
    }

    public void n(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.i;
        if (aVar == null) {
            return;
        }
        this.x = z;
        aVar.a(this.K.f7608a, z);
    }

    public void o() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.i;
        if (aVar == null) {
            return;
        }
        aVar.p();
        this.i.b(this.K.f7608a);
    }

    public void o(boolean z) {
        this.f7616e = z;
    }

    public MapBaseIndoorMapInfo p() {
        return this.i.q();
    }

    public void p(boolean z) {
        this.f7617f = z;
    }

    public void q(boolean z) {
        this.f7618g = z;
    }

    public boolean q() {
        return this.i.r();
    }

    public void r(boolean z) {
        this.A = z;
    }

    public boolean r() {
        return this.v;
    }

    public void s(boolean z) {
        this.z = z;
    }

    public boolean s() {
        return this.w;
    }

    public void t() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.i;
        if (aVar == null) {
            return;
        }
        aVar.b(this.K.f7608a);
    }

    public void t(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.i;
        if (aVar != null) {
            aVar.a(this.I.f7608a, z);
        }
    }

    public void u() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.i;
        if (aVar == null) {
            return;
        }
        aVar.e();
    }

    public void u(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.i;
        if (aVar != null) {
            aVar.a(this.ar.f7608a, z);
        }
    }

    public void v() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.i;
        if (aVar == null) {
            return;
        }
        aVar.f();
    }

    public void v(boolean z) {
        this.at = z;
    }

    public boolean w() {
        return this.f7616e;
    }

    public boolean x() {
        return this.f7617f;
    }

    public boolean y() {
        return this.A;
    }

    public boolean z() {
        return this.z;
    }
}
