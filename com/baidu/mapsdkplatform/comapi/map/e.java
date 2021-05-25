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
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapapi.common.SysOSUtil;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapBaseIndoorMapInfo;
import com.baidu.mapapi.map.MapStatusUpdate;
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
    public static int N;
    public static int O;
    public static List<JNIBaseMap> ar;
    public aj B;
    public ai C;
    public Context D;
    public List<d> E;
    public x F;
    public g G;
    public ae H;
    public ah I;
    public n J;
    public com.baidu.mapsdkplatform.comapi.map.a K;
    public o L;
    public af M;
    public int P;
    public int Q;
    public int R;
    public VelocityTracker T;
    public long U;
    public long V;
    public long W;
    public long X;
    public int Y;
    public float Z;
    public float aa;
    public boolean ab;
    public long ac;
    public long ad;
    public float ag;
    public float ah;
    public float ai;
    public float aj;
    public f am;
    public String an;
    public int ao;
    public b ap;
    public c aq;

    /* renamed from: i  reason: collision with root package name */
    public com.baidu.mapsdkplatform.comjni.map.basemap.a f7625i;
    public long j;
    public boolean k;
    public int l;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean s;
    public boolean t;
    public static final String r = j.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    public static float f7617d = 1096.0f;
    public static long m = 0;

    /* renamed from: a  reason: collision with root package name */
    public float f7618a = 21.0f;

    /* renamed from: b  reason: collision with root package name */
    public float f7619b = 4.0f;

    /* renamed from: c  reason: collision with root package name */
    public float f7620c = 21.0f;
    public boolean u = true;
    public boolean v = false;
    public boolean w = false;
    public boolean x = false;
    public boolean y = true;

    /* renamed from: e  reason: collision with root package name */
    public boolean f7621e = true;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7622f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f7623g = false;
    public boolean z = true;
    public boolean A = false;
    public j.a S = new j.a();
    public boolean ae = false;
    public boolean af = false;
    public long ak = 0;
    public long al = 0;
    public boolean as = false;
    public Queue<a> at = new LinkedList();
    public MapStatusUpdate q = null;
    public boolean au = false;
    public boolean av = false;

    /* renamed from: h  reason: collision with root package name */
    public List<l> f7624h = new ArrayList();

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f7626a;

        /* renamed from: b  reason: collision with root package name */
        public int f7627b;

        /* renamed from: c  reason: collision with root package name */
        public int f7628c;

        /* renamed from: d  reason: collision with root package name */
        public int f7629d;

        /* renamed from: e  reason: collision with root package name */
        public Bundle f7630e;

        public a(long j, int i2, int i3, int i4) {
            this.f7626a = j;
            this.f7627b = i2;
            this.f7628c = i3;
            this.f7629d = i4;
        }

        public a(Bundle bundle) {
            this.f7630e = bundle;
        }
    }

    public e(Context context, String str, int i2) {
        this.D = context;
        this.an = str;
        this.ao = i2;
    }

    private void R() {
        if (!this.w && !this.t && !this.s && !this.x) {
            this.f7618a = this.f7620c;
            return;
        }
        if (this.f7618a > 20.0f) {
            this.f7618a = 20.0f;
        }
        if (E().f7571a > 20.0f) {
            ab E = E();
            E.f7571a = 20.0f;
            a(E);
        }
    }

    private void S() {
        if (this.n) {
            return;
        }
        this.n = true;
        this.o = false;
        List<l> list = this.f7624h;
        if (list != null) {
            for (l lVar : list) {
                if (lVar != null) {
                    lVar.a(E());
                }
            }
        }
    }

    private boolean T() {
        if (this.f7625i == null || !this.k) {
            return true;
        }
        this.af = false;
        if (this.f7621e) {
            float f2 = (float) (this.al - this.ak);
            float abs = (Math.abs(this.ai - this.ag) * 1000.0f) / f2;
            float abs2 = (Math.abs(this.aj - this.ah) * 1000.0f) / f2;
            float sqrt = (float) Math.sqrt((abs * abs) + (abs2 * abs2));
            if (sqrt <= 500.0f) {
                return false;
            }
            A();
            a(34, (int) (sqrt * 0.6f), (((int) this.aj) << 16) | ((int) this.ai));
            M();
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
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7625i;
        if (aVar == null) {
            return;
        }
        dVar.f7613a = aVar.a(dVar.f7615c, dVar.f7616d, dVar.f7614b);
        this.E.add(dVar);
    }

    private void a(String str, String str2, long j) {
        try {
            Class<?> cls = Class.forName(str);
            cls.getMethod(str2, Long.TYPE).invoke(cls.newInstance(), Long.valueOf(j));
        } catch (Exception unused) {
        }
    }

    private void b(MotionEvent motionEvent) {
        if (this.S.f7653e) {
            return;
        }
        long downTime = motionEvent.getDownTime();
        this.ad = downTime;
        if (downTime - this.ac < 400) {
            downTime = (Math.abs(motionEvent.getX() - this.Z) >= 120.0f || Math.abs(motionEvent.getY() - this.aa) >= 120.0f) ? this.ad : 0L;
        }
        this.ac = downTime;
        this.Z = motionEvent.getX();
        this.aa = motionEvent.getY();
        a(4, 0, (((int) motionEvent.getY()) << 16) | ((int) motionEvent.getX()));
        this.ab = true;
    }

    private void b(String str, Bundle bundle) {
        if (this.f7625i == null) {
            return;
        }
        this.G.a(str);
        this.G.a(bundle);
        this.f7625i.b(this.G.f7613a);
    }

    private boolean c(MotionEvent motionEvent) {
        if (!this.S.f7653e && System.currentTimeMillis() - m >= 300) {
            if (this.p) {
                List<l> list = this.f7624h;
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
            float abs = Math.abs(motionEvent.getX() - this.Z);
            float abs2 = Math.abs(motionEvent.getY() - this.aa);
            int i2 = (SysOSUtil.getDensity() > 1.5d ? 1 : (SysOSUtil.getDensity() == 1.5d ? 0 : -1));
            double density = SysOSUtil.getDensity();
            if (i2 > 0) {
                density *= 1.5d;
            }
            float f2 = (float) density;
            if (!this.ab || abs / f2 > 3.0f || abs2 / f2 > 3.0f) {
                this.ab = false;
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (x < 0) {
                    x = 0;
                }
                if (y < 0) {
                    y = 0;
                }
                if (this.f7621e) {
                    BaiduMap.mapStatusReason = 1 | BaiduMap.mapStatusReason;
                    S();
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
            List<l> list = this.f7624h;
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
        boolean z = !this.S.f7653e && motionEvent.getEventTime() - this.ad < 400 && Math.abs(motionEvent.getX() - this.Z) < 10.0f && Math.abs(motionEvent.getY() - this.aa) < 10.0f;
        M();
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
        if (this.f7625i == null || !this.k) {
            return true;
        }
        this.ae = false;
        GeoPoint b2 = b((int) f2, (int) f3);
        if (b2 != null) {
            List<l> list = this.f7624h;
            if (list != null) {
                for (l lVar : list) {
                    if (lVar != null) {
                        lVar.b(b2);
                    }
                }
            }
            if (this.f7622f) {
                ab E = E();
                E.f7571a += 1.0f;
                E.f7574d = b2.getLongitudeE6();
                E.f7575e = b2.getLatitudeE6();
                a(E, 300);
                m = System.currentTimeMillis();
                return true;
            }
        }
        return false;
    }

    private boolean e(Bundle bundle) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7625i;
        if (aVar == null) {
            return false;
        }
        return aVar.e(bundle);
    }

    private boolean f(Bundle bundle) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        if (bundle == null || (aVar = this.f7625i) == null) {
            return false;
        }
        boolean d2 = aVar.d(bundle);
        if (d2) {
            f(d2);
            this.f7625i.b(this.B.f7613a);
        }
        return d2;
    }

    private void g(Bundle bundle) {
        int i2;
        int i3;
        if (bundle.get("param") == null ? (i2 = bundle.getInt("type")) != h.ground.ordinal() && i2 < h.arc.ordinal() : (i3 = (bundle = (Bundle) bundle.get("param")).getInt("type")) != h.ground.ordinal() && i3 < h.arc.ordinal()) {
            h.popup.ordinal();
        }
        bundle.putLong("layer_addr", this.I.f7613a);
    }

    public static void m(boolean z) {
        List<JNIBaseMap> b2 = com.baidu.mapsdkplatform.comjni.map.basemap.a.b();
        ar = b2;
        if (b2 == null || b2.size() == 0) {
            com.baidu.mapsdkplatform.comjni.map.basemap.a.b(0L, z);
            return;
        }
        com.baidu.mapsdkplatform.comjni.map.basemap.a.b(ar.get(0).f7931a, z);
        for (JNIBaseMap jNIBaseMap : ar) {
            if (jNIBaseMap != null) {
                jNIBaseMap.ClearLayer(jNIBaseMap.f7931a, -1L);
            }
        }
    }

    public void A() {
        if (this.n || this.o) {
            return;
        }
        this.o = true;
        List<l> list = this.f7624h;
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
        List<l> list = this.f7624h;
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
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7625i;
        if (aVar != null) {
            return aVar.a(this.H.f7613a);
        }
        return false;
    }

    public boolean D() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7625i;
        if (aVar != null) {
            return aVar.a(this.aq.f7613a);
        }
        return false;
    }

    public ab E() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7625i;
        if (aVar == null) {
            return null;
        }
        Bundle h2 = aVar.h();
        ab abVar = new ab();
        abVar.a(h2);
        return abVar;
    }

    public LatLngBounds F() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7625i;
        if (aVar == null) {
            return null;
        }
        Bundle i2 = aVar.i();
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        int i3 = i2.getInt("maxCoorx");
        int i4 = i2.getInt("minCoorx");
        builder.include(CoordUtil.mc2ll(new GeoPoint(i2.getInt("minCoory"), i3))).include(CoordUtil.mc2ll(new GeoPoint(i2.getInt("maxCoory"), i4)));
        return builder.build();
    }

    public MapStatusUpdate G() {
        return this.q;
    }

    public int H() {
        return this.P;
    }

    public int I() {
        return this.Q;
    }

    public ab J() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7625i;
        if (aVar == null) {
            return null;
        }
        Bundle j = aVar.j();
        ab abVar = new ab();
        abVar.a(j);
        return abVar;
    }

    public double K() {
        return E().m;
    }

    public void L() {
        List<l> list;
        this.n = false;
        if (this.o || (list = this.f7624h) == null) {
            return;
        }
        for (l lVar : list) {
            if (lVar != null) {
                lVar.c(E());
            }
        }
    }

    public void M() {
        this.R = 0;
        j.a aVar = this.S;
        aVar.f7653e = false;
        aVar.f7656h = 0.0d;
    }

    public float[] N() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7625i;
        if (aVar == null) {
            return null;
        }
        return aVar.u();
    }

    public float[] O() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7625i;
        if (aVar == null) {
            return null;
        }
        return aVar.v();
    }

    public Queue<a> P() {
        return this.at;
    }

    public void Q() {
        if (this.at.isEmpty()) {
            return;
        }
        a poll = this.at.poll();
        if (poll.f7630e == null) {
            com.baidu.mapsdkplatform.comjni.map.basemap.a.a(poll.f7626a, poll.f7627b, poll.f7628c, poll.f7629d);
        } else if (this.f7625i != null) {
            A();
            this.f7625i.a(poll.f7630e);
        }
    }

    public float a(int i2, int i3, int i4, int i5, int i6, int i7) {
        if (this.k) {
            if (this.f7625i == null) {
                return 0.0f;
            }
            Bundle bundle = new Bundle();
            bundle.putInt(CustomDialogData.POS_LEFT, i2);
            bundle.putInt("right", i4);
            bundle.putInt(TipsConfigItem.TipConfigData.BOTTOM, i5);
            bundle.putInt("top", i3);
            bundle.putInt("hasHW", 1);
            bundle.putInt("width", i6);
            bundle.putInt("height", i7);
            return this.f7625i.c(bundle);
        }
        return 12.0f;
    }

    public int a(int i2, int i3, int i4) {
        if (this.as) {
            this.at.add(new a(this.j, i2, i3, i4));
            return 0;
        }
        return com.baidu.mapsdkplatform.comjni.map.basemap.a.a(this.j, i2, i3, i4);
    }

    @Override // com.baidu.mapsdkplatform.comjni.map.basemap.b
    public int a(Bundle bundle, long j, int i2, Bundle bundle2) {
        ag agVar;
        g gVar = this.G;
        if (j == gVar.f7613a) {
            bundle.putString("jsondata", gVar.a());
            bundle.putBundle("param", this.G.b());
            agVar = this.G;
        } else {
            x xVar = this.F;
            if (j == xVar.f7613a) {
                bundle.putString("jsondata", xVar.a());
                bundle.putBundle("param", this.F.b());
                agVar = this.F;
            } else if (j == this.J.f7613a) {
                bundle.putBundle("param", this.L.a(bundle2.getInt("x"), bundle2.getInt("y"), bundle2.getInt("zoom")));
                agVar = this.J;
            } else if (j != this.B.f7613a) {
                return 0;
            } else {
                bundle.putBundle("param", this.C.a(bundle2.getInt("x"), bundle2.getInt("y"), bundle2.getInt("zoom"), this.D));
                agVar = this.B;
            }
        }
        return agVar.f7603g;
    }

    public Point a(GeoPoint geoPoint) {
        return this.M.a(geoPoint);
    }

    public void a() {
        this.E = new ArrayList();
        f fVar = new f();
        this.am = fVar;
        a(fVar);
        b bVar = new b();
        this.ap = bVar;
        a(bVar);
        n nVar = new n();
        this.J = nVar;
        a(nVar);
        com.baidu.mapsdkplatform.comapi.map.a aVar = new com.baidu.mapsdkplatform.comapi.map.a();
        this.K = aVar;
        a(aVar);
        a(new p());
        ae aeVar = new ae();
        this.H = aeVar;
        a(aeVar);
        c cVar = new c();
        this.aq = cVar;
        a(cVar);
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar2 = this.f7625i;
        if (aVar2 != null) {
            aVar2.e(false);
        }
        ah ahVar = new ah();
        this.I = ahVar;
        a(ahVar);
        g gVar = new g();
        this.G = gVar;
        a(gVar);
        x xVar = new x();
        this.F = xVar;
        a(xVar);
    }

    public void a(float f2, float f3) {
        this.f7618a = f2;
        this.f7620c = f2;
        this.f7619b = f3;
    }

    public void a(int i2) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = new com.baidu.mapsdkplatform.comjni.map.basemap.a();
        this.f7625i = aVar;
        aVar.a(i2);
        long a2 = this.f7625i.a();
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
        Activity a3 = a(this.D);
        if (a3 == null) {
            throw new RuntimeException("BDMapSDKException: Please give the right context.");
        }
        Display defaultDisplay = a3.getWindowManager().getDefaultDisplay();
        this.f7625i.a(str4, str7, str9, str10, str8, str5, this.an, this.ao, str6, defaultDisplay.getWidth(), defaultDisplay.getHeight(), SysOSUtil.getDensityDpi(), mapTmpStgMax, domTmpStgMax, itsTmpStgMax, 0);
    }

    public void a(int i2, int i3) {
        this.P = i2;
        this.Q = i3;
    }

    public void a(long j, long j2, long j3, long j4, boolean z) {
        this.f7625i.a(j, j2, j3, j4, z);
    }

    public void a(Bitmap bitmap) {
        Bundle bundle;
        if (this.f7625i == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("type", 0);
            jSONObject2.put("x", N);
            jSONObject2.put("y", O);
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
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    parcelItemArr[i2] = (ParcelItem) arrayList.get(i2);
                }
                bundle2.putParcelableArray("icondata", parcelItemArr);
            }
            bundle = bundle2;
        }
        b(jSONObject.toString(), bundle);
        this.f7625i.b(this.G.f7613a);
    }

    public void a(Handler handler) {
        MessageCenter.registMessage(4000, handler);
        MessageCenter.registMessage(39, handler);
        MessageCenter.registMessage(41, handler);
        MessageCenter.registMessage(49, handler);
        MessageCenter.registMessage(65289, handler);
        MessageCenter.registMessage(50, handler);
        MessageCenter.registMessage(999, handler);
        BaseMapCallback.addLayerDataInterface(this.j, this);
    }

    public void a(MapStatusUpdate mapStatusUpdate) {
        this.q = mapStatusUpdate;
    }

    public void a(LatLngBounds latLngBounds) {
        if (latLngBounds == null || this.f7625i == null) {
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
        this.f7625i.b(bundle);
    }

    public void a(ab abVar) {
        if (this.f7625i == null || abVar == null) {
            return;
        }
        Bundle a2 = abVar.a(this);
        a2.putInt("animation", 0);
        a2.putInt("animatime", 0);
        this.f7625i.a(a2);
    }

    public void a(ab abVar, int i2) {
        if (this.f7625i == null || abVar == null) {
            return;
        }
        Bundle a2 = abVar.a(this);
        a2.putInt("animation", 1);
        a2.putInt("animatime", i2);
        if (this.as) {
            this.at.add(new a(a2));
            return;
        }
        A();
        this.f7625i.a(a2);
    }

    public void a(ai aiVar) {
        this.C = aiVar;
    }

    public void a(l lVar) {
        List<l> list;
        if (lVar == null || (list = this.f7624h) == null) {
            return;
        }
        list.add(lVar);
    }

    public void a(o oVar) {
        this.L = oVar;
    }

    public void a(z zVar) {
        new ab();
        if (zVar == null) {
            zVar = new z();
        }
        ab abVar = zVar.f7695a;
        this.y = zVar.f7700f;
        this.z = zVar.f7698d;
        this.f7621e = zVar.f7699e;
        this.f7622f = zVar.f7701g;
        this.f7625i.a(abVar.a(this));
        this.f7625i.c(y.DEFAULT.ordinal());
        boolean z = zVar.f7696b;
        this.u = z;
        if (z) {
            N = (int) (SysOSUtil.getDensity() * 40.0f);
            O = (int) (SysOSUtil.getDensity() * 40.0f);
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("x", N);
                jSONObject2.put("y", O);
                jSONObject2.put("hidetime", 1000);
                jSONArray.put(jSONObject2);
                jSONObject.put("data", jSONArray);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.G.a(jSONObject.toString());
            this.f7625i.a(this.G.f7613a, true);
        } else {
            this.f7625i.a(this.G.f7613a, false);
        }
        int i2 = zVar.f7697c;
        if (i2 == 2) {
            a(true);
        }
        if (i2 == 3) {
            this.f7625i.a(this.am.f7613a, false);
            this.f7625i.a(this.aq.f7613a, false);
            this.f7625i.a(this.H.f7613a, false);
            this.f7625i.e(false);
        }
    }

    public void a(String str, Bundle bundle) {
        if (this.f7625i == null) {
            return;
        }
        this.F.a(str);
        this.F.a(bundle);
        this.f7625i.b(this.F.f7613a);
    }

    public void a(List<Bundle> list) {
        if (this.f7625i == null || list == null) {
            return;
        }
        int size = list.size();
        Bundle[] bundleArr = new Bundle[list.size()];
        for (int i2 = 0; i2 < size; i2++) {
            g(list.get(i2));
            bundleArr[i2] = list.get(i2);
        }
        this.f7625i.a(bundleArr);
    }

    public void a(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7625i;
        if (aVar == null) {
            return;
        }
        if (!aVar.a(this.am.f7613a)) {
            this.f7625i.a(this.am.f7613a, true);
        }
        this.t = z;
        R();
        this.f7625i.a(this.t);
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
        int i2;
        int i3;
        float f9;
        float f10;
        int i4 = this.Q;
        float f11 = i4 - f3;
        float f12 = i4 - f5;
        j.a aVar2 = this.S;
        if (aVar2.f7653e) {
            if (this.R == 0) {
                if (aVar2.f7651c - f11 <= 0.0f || aVar2.f7652d - f12 <= 0.0f) {
                    j.a aVar3 = this.S;
                    if (aVar3.f7651c - f11 >= 0.0f || aVar3.f7652d - f12 >= 0.0f) {
                        z = true;
                        this.R = 2;
                        if (this.R == 0) {
                            return z;
                        }
                    }
                }
                double atan2 = Math.atan2(f12 - f11, f4 - f2);
                j.a aVar4 = this.S;
                double atan22 = atan2 - Math.atan2(aVar4.f7652d - aVar4.f7651c, aVar4.f7650b - aVar4.f7649a);
                double sqrt = Math.sqrt((f10 * f10) + (f9 * f9)) / this.S.f7656h;
                int log = (int) ((Math.log(sqrt) / Math.log(2.0d)) * 10000.0d);
                int i5 = (int) ((atan22 * 180.0d) / 3.1416d);
                if ((sqrt <= 0.0d || (log <= 3000 && log >= -3000)) && Math.abs(i5) < 10) {
                    z = true;
                    this.R = 1;
                } else {
                    this.R = 2;
                    z = true;
                }
                if (this.R == 0) {
                }
            } else {
                z = true;
            }
            if (this.R == z && this.y) {
                j.a aVar5 = this.S;
                if (aVar5.f7651c - f11 <= 0.0f || aVar5.f7652d - f12 <= 0.0f) {
                    j.a aVar6 = this.S;
                    if (aVar6.f7651c - f11 < 0.0f && aVar6.f7652d - f12 < 0.0f) {
                        S();
                        i3 = 87;
                    }
                } else {
                    S();
                    i3 = 83;
                }
                a(1, i3, 0);
            } else {
                int i6 = this.R;
                if (i6 == 2 || i6 == 4 || i6 == 3) {
                    double atan23 = Math.atan2(f12 - f11, f4 - f2);
                    j.a aVar7 = this.S;
                    double atan24 = atan23 - Math.atan2(aVar7.f7652d - aVar7.f7651c, aVar7.f7650b - aVar7.f7649a);
                    double sqrt2 = Math.sqrt((f8 * f8) + (f7 * f7)) / this.S.f7656h;
                    int log2 = (int) ((Math.log(sqrt2) / Math.log(2.0d)) * 10000.0d);
                    j.a aVar8 = this.S;
                    double atan25 = Math.atan2(aVar8.f7655g - aVar8.f7651c, aVar8.f7654f - aVar8.f7649a);
                    j.a aVar9 = this.S;
                    float f13 = aVar9.f7654f;
                    float f14 = aVar9.f7649a;
                    float f15 = (f13 - f14) * (f13 - f14);
                    float f16 = aVar9.f7655g;
                    float f17 = aVar9.f7651c;
                    double sqrt3 = Math.sqrt(f15 + ((f16 - f17) * (f16 - f17)));
                    double d2 = atan25 + atan24;
                    f6 = f12;
                    float cos = (float) ((Math.cos(d2) * sqrt3 * sqrt2) + f2);
                    float sin = (float) ((sqrt3 * Math.sin(d2) * sqrt2) + f11);
                    int i7 = (int) ((atan24 * 180.0d) / 3.1416d);
                    if (sqrt2 > 0.0d && (3 == this.R || (Math.abs(log2) > 2000 && 2 == this.R))) {
                        this.R = 3;
                        float f18 = E().f7571a;
                        if (this.f7622f) {
                            if (sqrt2 <= 1.0d) {
                                i2 = 3;
                                if (f18 <= this.f7619b) {
                                    return false;
                                }
                                S();
                            } else if (f18 >= this.f7618a) {
                                return false;
                            } else {
                                S();
                                i2 = 3;
                            }
                            a(8193, i2, log2);
                        }
                    } else if (i7 != 0 && (4 == this.R || (Math.abs(i7) > 10 && 2 == this.R))) {
                        this.R = 4;
                        if (this.z) {
                            BaiduMap.mapStatusReason |= 1;
                            S();
                            a(8193, 1, i7);
                        }
                    }
                    j.a aVar10 = this.S;
                    aVar10.f7654f = cos;
                    aVar10.f7655g = sin;
                    if (2 != this.R) {
                        j.a aVar11 = this.S;
                        aVar11.f7651c = f11;
                        aVar11.f7652d = f6;
                        aVar11.f7649a = f2;
                        aVar11.f7650b = f4;
                    }
                    aVar = this.S;
                    if (aVar.f7653e) {
                        aVar.f7654f = this.P / 2;
                        aVar.f7655g = this.Q / 2;
                        aVar.f7653e = true;
                        if (0.0d == aVar.f7656h) {
                            float f19 = aVar.f7650b;
                            float f20 = aVar.f7649a;
                            float f21 = (f19 - f20) * (f19 - f20);
                            float f22 = aVar.f7652d;
                            float f23 = aVar.f7651c;
                            this.S.f7656h = Math.sqrt(f21 + ((f22 - f23) * (f22 - f23)));
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
            }
        }
        f6 = f12;
        if (2 != this.R) {
        }
        aVar = this.S;
        if (aVar.f7653e) {
        }
    }

    @Override // com.baidu.mapsdkplatform.comjni.map.basemap.b
    public boolean a(long j) {
        Iterator<d> it = this.E.iterator();
        while (it.hasNext()) {
            if (it.next().f7613a == j) {
                return true;
            }
        }
        return false;
    }

    public boolean a(Point point) {
        int i2;
        int i3;
        if (point != null && this.f7625i != null && (i2 = point.x) >= 0 && (i3 = point.y) >= 0) {
            N = i2;
            O = i3;
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("x", N);
                jSONObject2.put("y", O);
                jSONObject2.put("hidetime", 1000);
                jSONArray.put(jSONObject2);
                jSONObject.put("data", jSONArray);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.G.a(jSONObject.toString());
            this.f7625i.b(this.G.f7613a);
            return true;
        }
        return false;
    }

    public boolean a(Bundle bundle) {
        if (this.f7625i == null) {
            return false;
        }
        aj ajVar = new aj();
        this.B = ajVar;
        long a2 = this.f7625i.a(ajVar.f7615c, ajVar.f7616d, ajVar.f7614b);
        if (a2 != 0) {
            aj ajVar2 = this.B;
            ajVar2.f7613a = a2;
            this.E.add(ajVar2);
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
        int i2;
        float xVelocity;
        float f2;
        j.a aVar;
        float f3;
        boolean z;
        float f4;
        float f5;
        e eVar;
        int i3;
        int i4;
        int i5;
        int i6;
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
        float y = this.Q - motionEvent.getY(0);
        float y2 = this.Q - motionEvent.getY(1);
        float x = motionEvent.getX(0);
        float x2 = motionEvent.getX(1);
        int action2 = motionEvent.getAction();
        if (action2 != 5) {
            if (action2 == 6) {
                this.X = motionEvent.getEventTime();
            } else if (action2 != 261) {
                if (action2 == 262) {
                    this.W = motionEvent.getEventTime();
                }
                if (this.T == null) {
                    this.T = VelocityTracker.obtain();
                }
                this.T.addMovement(motionEvent);
                int minimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
                this.T.computeCurrentVelocity(1000, ViewConfiguration.getMaximumFlingVelocity());
                xVelocity = this.T.getXVelocity(1);
                float yVelocity = this.T.getYVelocity(1);
                float xVelocity2 = this.T.getXVelocity(2);
                float yVelocity2 = this.T.getYVelocity(2);
                f2 = minimumFlingVelocity;
                if (Math.abs(xVelocity) <= f2 || Math.abs(yVelocity) > f2 || Math.abs(xVelocity2) > f2 || Math.abs(yVelocity2) > f2) {
                    aVar = this.S;
                    if (aVar.f7653e) {
                        if (this.R == 0) {
                            if (aVar.f7651c - y <= 0.0f || aVar.f7652d - y2 <= 0.0f) {
                                j.a aVar3 = this.S;
                                if (aVar3.f7651c - y >= 0.0f || aVar3.f7652d - y2 >= 0.0f) {
                                    f3 = y2;
                                    z = true;
                                    this.R = 2;
                                    if (this.R == 0) {
                                        return z;
                                    }
                                }
                            }
                            f3 = y2;
                            double atan2 = Math.atan2(y2 - y, x2 - x);
                            j.a aVar4 = this.S;
                            double atan22 = atan2 - Math.atan2(aVar4.f7652d - aVar4.f7651c, aVar4.f7650b - aVar4.f7649a);
                            double sqrt = Math.sqrt((f7 * f7) + (f6 * f6)) / this.S.f7656h;
                            int log = (int) ((Math.log(sqrt) / Math.log(2.0d)) * 10000.0d);
                            int i7 = (int) ((atan22 * 180.0d) / 3.1416d);
                            if ((sqrt <= 0.0d || (log <= 3000 && log >= -3000)) && Math.abs(i7) < 10) {
                                z = true;
                                this.R = 1;
                            } else {
                                this.R = 2;
                                z = true;
                            }
                            if (this.R == 0) {
                            }
                        } else {
                            f3 = y2;
                            z = true;
                        }
                        if (this.R == z && this.y) {
                            j.a aVar5 = this.S;
                            if (aVar5.f7651c - y <= 0.0f || aVar5.f7652d - f3 <= 0.0f) {
                                j.a aVar6 = this.S;
                                if (aVar6.f7651c - y < 0.0f && aVar6.f7652d - f3 < 0.0f) {
                                    i5 = 1;
                                    BaiduMap.mapStatusReason |= 1;
                                    S();
                                    i6 = 87;
                                }
                            } else {
                                i5 = 1;
                                BaiduMap.mapStatusReason |= 1;
                                S();
                                i6 = 83;
                            }
                            a(i5, i6, 0);
                        } else {
                            int i8 = this.R;
                            if (i8 == 2 || i8 == 4 || i8 == 3) {
                                double atan23 = Math.atan2(f3 - y, x2 - x);
                                j.a aVar7 = this.S;
                                double atan24 = atan23 - Math.atan2(aVar7.f7652d - aVar7.f7651c, aVar7.f7650b - aVar7.f7649a);
                                double sqrt2 = Math.sqrt((f5 * f5) + (f4 * f4)) / this.S.f7656h;
                                int log2 = (int) ((Math.log(sqrt2) / Math.log(2.0d)) * 10000.0d);
                                j.a aVar8 = this.S;
                                double atan25 = Math.atan2(aVar8.f7655g - aVar8.f7651c, aVar8.f7654f - aVar8.f7649a);
                                j.a aVar9 = this.S;
                                float f8 = aVar9.f7654f;
                                float f9 = aVar9.f7649a;
                                float f10 = aVar9.f7655g;
                                float f11 = aVar9.f7651c;
                                double sqrt3 = Math.sqrt(((f8 - f9) * (f8 - f9)) + ((f10 - f11) * (f10 - f11)));
                                double d2 = atan25 + atan24;
                                float cos = (float) ((Math.cos(d2) * sqrt3 * sqrt2) + x);
                                float sin = (float) ((sqrt3 * Math.sin(d2) * sqrt2) + y);
                                int i9 = (int) ((atan24 * 180.0d) / 3.1416d);
                                eVar = this;
                                if (sqrt2 > 0.0d && (3 == eVar.R || (Math.abs(log2) > 2000 && 2 == eVar.R))) {
                                    eVar.R = 3;
                                    float f12 = E().f7571a;
                                    if (eVar.f7622f) {
                                        if (sqrt2 <= 1.0d) {
                                            i3 = log2;
                                            i4 = 3;
                                            if (f12 <= eVar.f7619b) {
                                                return false;
                                            }
                                            BaiduMap.mapStatusReason |= 1;
                                            S();
                                        } else if (f12 >= eVar.f7618a) {
                                            return false;
                                        } else {
                                            BaiduMap.mapStatusReason |= 1;
                                            S();
                                            i3 = log2;
                                            i4 = 3;
                                        }
                                        eVar.a(8193, i4, i3);
                                    }
                                } else if (i9 != 0 && (4 == eVar.R || (Math.abs(i9) > 10 && 2 == eVar.R))) {
                                    eVar.R = 4;
                                    if (eVar.z) {
                                        S();
                                        eVar.a(8193, 1, i9);
                                    }
                                }
                                j.a aVar10 = eVar.S;
                                aVar10.f7654f = cos;
                                aVar10.f7655g = sin;
                                if (2 != eVar.R) {
                                    j.a aVar11 = eVar.S;
                                    aVar11.f7651c = y;
                                    aVar11.f7652d = f3;
                                    aVar11.f7649a = x;
                                    aVar11.f7650b = x2;
                                }
                                aVar2 = eVar.S;
                                if (aVar2.f7653e) {
                                    return true;
                                }
                                aVar2.f7654f = eVar.P / 2;
                                aVar2.f7655g = eVar.Q / 2;
                                aVar2.f7653e = true;
                                if (0.0d == aVar2.f7656h) {
                                    float f13 = aVar2.f7650b;
                                    float f14 = aVar2.f7649a;
                                    float f15 = (f13 - f14) * (f13 - f14);
                                    float f16 = aVar2.f7652d;
                                    float f17 = aVar2.f7651c;
                                    eVar.S.f7656h = Math.sqrt(f15 + ((f16 - f17) * (f16 - f17)));
                                    return true;
                                }
                                return true;
                            }
                        }
                        eVar = this;
                        if (2 != eVar.R) {
                        }
                        aVar2 = eVar.S;
                        if (aVar2.f7653e) {
                        }
                    }
                } else if (this.R == 0 && this.Y == 0) {
                    long j = this.W;
                    long j2 = this.X;
                    if (j <= j2) {
                        j = j2;
                    }
                    this.W = j;
                    long j3 = this.U;
                    long j4 = this.V;
                    if (j3 < j4) {
                        j3 = j4;
                    }
                    this.U = j3;
                    if (this.W - j3 < 200 && this.f7622f && (E = E()) != null) {
                        E.f7571a -= 1.0f;
                        BaiduMap.mapStatusReason |= 1;
                        a(E, 300);
                    }
                }
                eVar = this;
                f3 = y2;
                if (2 != eVar.R) {
                }
                aVar2 = eVar.S;
                if (aVar2.f7653e) {
                }
            } else {
                this.U = motionEvent.getEventTime();
            }
            i2 = this.Y + 1;
            this.Y = i2;
            if (this.T == null) {
            }
            this.T.addMovement(motionEvent);
            int minimumFlingVelocity2 = ViewConfiguration.getMinimumFlingVelocity();
            this.T.computeCurrentVelocity(1000, ViewConfiguration.getMaximumFlingVelocity());
            xVelocity = this.T.getXVelocity(1);
            float yVelocity3 = this.T.getYVelocity(1);
            float xVelocity22 = this.T.getXVelocity(2);
            float yVelocity22 = this.T.getYVelocity(2);
            f2 = minimumFlingVelocity2;
            if (Math.abs(xVelocity) <= f2) {
            }
            aVar = this.S;
            if (aVar.f7653e) {
            }
            eVar = this;
            f3 = y2;
            if (2 != eVar.R) {
            }
            aVar2 = eVar.S;
            if (aVar2.f7653e) {
            }
        } else {
            this.V = motionEvent.getEventTime();
        }
        i2 = this.Y - 1;
        this.Y = i2;
        if (this.T == null) {
        }
        this.T.addMovement(motionEvent);
        int minimumFlingVelocity22 = ViewConfiguration.getMinimumFlingVelocity();
        this.T.computeCurrentVelocity(1000, ViewConfiguration.getMaximumFlingVelocity());
        xVelocity = this.T.getXVelocity(1);
        float yVelocity32 = this.T.getYVelocity(1);
        float xVelocity222 = this.T.getXVelocity(2);
        float yVelocity222 = this.T.getYVelocity(2);
        f2 = minimumFlingVelocity22;
        if (Math.abs(xVelocity) <= f2) {
        }
        aVar = this.S;
        if (aVar.f7653e) {
        }
        eVar = this;
        f3 = y2;
        if (2 != eVar.R) {
        }
        aVar2 = eVar.S;
        if (aVar2.f7653e) {
        }
    }

    public boolean a(String str, String str2) {
        return this.f7625i.a(str, str2);
    }

    public GeoPoint b(int i2, int i3) {
        return this.M.a(i2, i3);
    }

    public void b(float f2, float f3) {
        if (this.S.f7653e) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.ad = currentTimeMillis;
        if (currentTimeMillis - this.ac < 400) {
            if (Math.abs(f2 - this.Z) < 120.0f && Math.abs(f3 - this.aa) < 120.0f) {
                this.ac = 0L;
                this.ae = true;
                this.Z = f2;
                this.aa = f3;
                a(4, 0, ((int) f2) | (((int) f3) << 16));
                this.ab = true;
            }
            currentTimeMillis = this.ad;
        }
        this.ac = currentTimeMillis;
        this.Z = f2;
        this.aa = f3;
        a(4, 0, ((int) f2) | (((int) f3) << 16));
        this.ab = true;
    }

    public void b(int i2) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7625i;
        if (aVar != null) {
            aVar.b(i2);
            this.f7625i = null;
        }
    }

    public void b(Bundle bundle) {
        if (this.f7625i == null) {
            return;
        }
        g(bundle);
        this.f7625i.f(bundle);
    }

    public void b(Handler handler) {
        MessageCenter.unregistMessage(4000, handler);
        MessageCenter.unregistMessage(41, handler);
        MessageCenter.unregistMessage(49, handler);
        MessageCenter.unregistMessage(39, handler);
        MessageCenter.unregistMessage(65289, handler);
        MessageCenter.unregistMessage(50, handler);
        MessageCenter.unregistMessage(999, handler);
        BaseMapCallback.removeLayerDataInterface(this.j);
    }

    public void b(boolean z) {
        this.A = z;
    }

    public boolean b() {
        return this.A;
    }

    public void c() {
        if (this.f7625i == null) {
            return;
        }
        for (d dVar : this.E) {
            this.f7625i.a(dVar.f7613a, false);
        }
    }

    public void c(Bundle bundle) {
        if (this.f7625i == null) {
            return;
        }
        g(bundle);
        this.f7625i.g(bundle);
    }

    public void c(boolean z) {
        boolean z2;
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7625i;
        if (aVar == null) {
            return;
        }
        if (z) {
            if (this.au) {
                return;
            }
            aVar.a(this.ap.f7613a, this.I.f7613a);
            z2 = true;
        } else if (!this.au) {
            return;
        } else {
            aVar.a(this.I.f7613a, this.ap.f7613a);
            z2 = false;
        }
        this.au = z2;
    }

    public boolean c(float f2, float f3) {
        if (!this.S.f7653e && System.currentTimeMillis() - m >= 300) {
            if (this.p) {
                List<l> list = this.f7624h;
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
            float abs = Math.abs(f2 - this.Z);
            float abs2 = Math.abs(f3 - this.aa);
            int i2 = (SysOSUtil.getDensity() > 1.5d ? 1 : (SysOSUtil.getDensity() == 1.5d ? 0 : -1));
            double density = SysOSUtil.getDensity();
            if (i2 > 0) {
                density *= 1.5d;
            }
            float f4 = (float) density;
            if (!this.ab || abs / f4 > 3.0f || abs2 / f4 > 3.0f) {
                this.ab = false;
                int i3 = (int) f2;
                int i4 = (int) f3;
                if (i3 < 0) {
                    i3 = 0;
                }
                if (i4 < 0) {
                    i4 = 0;
                }
                if (this.f7621e) {
                    this.ag = this.ai;
                    this.ah = this.aj;
                    this.ai = f2;
                    this.aj = f3;
                    this.ak = this.al;
                    this.al = System.currentTimeMillis();
                    this.af = true;
                    S();
                    a(3, 0, (i4 << 16) | i3);
                }
                return false;
            }
            return true;
        }
        return true;
    }

    public boolean c(int i2, int i3) {
        return i2 >= 0 && i2 <= this.P + 0 && i3 >= 0 && i3 <= this.Q + 0;
    }

    public void d() {
        if (this.f7625i == null) {
            return;
        }
        for (d dVar : this.E) {
            if ((dVar instanceof x) || (dVar instanceof com.baidu.mapsdkplatform.comapi.map.a) || (dVar instanceof n)) {
                this.f7625i.a(dVar.f7613a, false);
            } else {
                this.f7625i.a(dVar.f7613a, true);
            }
        }
        this.f7625i.c(false);
    }

    public void d(Bundle bundle) {
        if (this.f7625i == null) {
            return;
        }
        g(bundle);
        this.f7625i.h(bundle);
    }

    public void d(boolean z) {
        boolean z2;
        if (z) {
            if (this.av) {
                return;
            }
            this.f7625i.a(this.I.f7613a, this.F.f7613a);
            z2 = true;
        } else if (!this.av) {
            return;
        } else {
            this.f7625i.a(this.F.f7613a, this.I.f7613a);
            z2 = false;
        }
        this.av = z2;
    }

    public boolean d(float f2, float f3) {
        if (this.p) {
            List<l> list = this.f7624h;
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
        if (!this.S.f7653e) {
            if (this.ae) {
                return e(f2, f3);
            }
            if (this.af) {
                return T();
            }
            if (System.currentTimeMillis() - this.ad < 400 && Math.abs(f2 - this.Z) < 10.0f && Math.abs(f3 - this.aa) < 10.0f) {
                M();
                return true;
            }
        }
        M();
        int i2 = (int) f2;
        int i3 = (int) f3;
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        a(5, 0, i2 | (i3 << 16));
        return true;
    }

    public void e(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7625i;
        if (aVar == null) {
            return;
        }
        aVar.a(this.G.f7613a, z);
    }

    public boolean e() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar;
        aj ajVar = this.B;
        if (ajVar == null || (aVar = this.f7625i) == null) {
            return false;
        }
        return aVar.c(ajVar.f7613a);
    }

    public void f() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7625i;
        if (aVar == null) {
            return;
        }
        this.M = new af(aVar);
    }

    public void f(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7625i;
        if (aVar == null) {
            return;
        }
        aVar.a(this.B.f7613a, z);
    }

    public void g(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7625i;
        if (aVar == null) {
            return;
        }
        aVar.a(this.am.f7613a, z);
    }

    public boolean g() {
        return this.s;
    }

    public String h() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7625i;
        if (aVar == null) {
            return null;
        }
        return aVar.e(this.G.f7613a);
    }

    public void h(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7625i;
        if (aVar == null) {
            return;
        }
        this.x = z;
        aVar.b(z);
    }

    public void i(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7625i;
        if (aVar == null) {
            return;
        }
        this.s = z;
        aVar.c(z);
    }

    public boolean i() {
        return this.x;
    }

    public void j(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7625i;
        if (aVar == null) {
            return;
        }
        aVar.d(z);
    }

    public boolean j() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7625i;
        if (aVar == null) {
            return false;
        }
        return aVar.k();
    }

    public void k(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7625i;
        if (aVar == null) {
            return;
        }
        this.u = z;
        aVar.a(this.G.f7613a, z);
    }

    public boolean k() {
        return this.t;
    }

    public void l(boolean z) {
        float f2 = z ? 22.0f : 21.0f;
        this.f7618a = f2;
        this.f7620c = f2;
        this.f7625i.e(z);
        this.f7625i.d(this.ap.f7613a);
        this.f7625i.d(this.aq.f7613a);
    }

    public boolean l() {
        return this.f7625i.a(this.am.f7613a);
    }

    public boolean m() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7625i;
        if (aVar == null) {
            return false;
        }
        return aVar.o();
    }

    public void n() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7625i;
        if (aVar == null) {
            return;
        }
        aVar.d(this.I.f7613a);
    }

    public void n(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7625i;
        if (aVar == null) {
            return;
        }
        this.v = z;
        aVar.a(this.F.f7613a, z);
    }

    public void o() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7625i;
        if (aVar == null) {
            return;
        }
        aVar.p();
        this.f7625i.b(this.J.f7613a);
    }

    public void o(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7625i;
        if (aVar == null) {
            return;
        }
        this.w = z;
        aVar.a(this.J.f7613a, z);
    }

    public MapBaseIndoorMapInfo p() {
        return this.f7625i.q();
    }

    public void p(boolean z) {
        this.f7621e = z;
    }

    public void q(boolean z) {
        this.f7622f = z;
    }

    public boolean q() {
        return this.f7625i.r();
    }

    public void r(boolean z) {
        this.f7623g = z;
    }

    public boolean r() {
        return this.u;
    }

    public void s(boolean z) {
        this.z = z;
    }

    public boolean s() {
        return this.v;
    }

    public void t() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7625i;
        if (aVar == null) {
            return;
        }
        aVar.b(this.J.f7613a);
    }

    public void t(boolean z) {
        this.y = z;
    }

    public void u() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7625i;
        if (aVar == null) {
            return;
        }
        aVar.e();
    }

    public void u(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7625i;
        if (aVar != null) {
            aVar.a(this.H.f7613a, z);
        }
    }

    public void v() {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7625i;
        if (aVar == null) {
            return;
        }
        aVar.f();
    }

    public void v(boolean z) {
        com.baidu.mapsdkplatform.comjni.map.basemap.a aVar = this.f7625i;
        if (aVar != null) {
            aVar.a(this.aq.f7613a, z);
        }
    }

    public void w(boolean z) {
        this.as = z;
    }

    public boolean w() {
        return this.f7621e;
    }

    public boolean x() {
        return this.f7622f;
    }

    public boolean y() {
        return this.z;
    }

    public boolean z() {
        return this.y;
    }
}
