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
import com.baidu.live.adp.widget.HorizontalTranslateLayout;
import com.baidu.live.adp.widget.VerticalTranslateLayout;
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
import com.baidu.mobstat.Config;
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
/* loaded from: classes5.dex */
public class e implements com.baidu.mapsdkplatform.comjni.map.basemap.b {
    private static int O;
    private static int P;
    private static List<JNIBaseMap> as;
    private aj C;
    private ai D;
    private Context E;
    private List<d> F;
    private x G;
    private g H;
    private ae I;
    private ah J;
    private n K;
    private com.baidu.mapsdkplatform.comapi.map.a L;
    private o M;
    private af N;
    private int Q;
    private int R;
    private int S;
    private VelocityTracker U;
    private long V;
    private long W;
    private long X;
    private long Y;
    private int Z;
    private float aa;
    private float ab;
    private boolean ac;
    private long ad;
    private long ae;
    private float ah;
    private float ai;
    private float aj;
    private float ak;
    private f an;
    private String ao;
    private int ap;
    private b aq;
    private c ar;
    com.baidu.mapsdkplatform.comjni.map.basemap.a i;
    long j;
    boolean k;
    int l;
    boolean n;
    boolean o;
    boolean p;
    public LatLngBounds q;
    public MapStatus r;
    private boolean t;
    private boolean u;
    private static final String s = j.class.getSimpleName();
    public static float d = 1096.0f;
    static long m = 0;
    public float a = 21.0f;
    public float b = 4.0f;
    public float c = 21.0f;
    private boolean v = true;
    private boolean w = false;
    private boolean x = false;
    private boolean y = false;
    private boolean z = true;
    boolean e = true;
    boolean f = true;
    boolean g = false;
    private boolean A = true;
    private boolean B = false;
    private j.a T = new j.a();
    private boolean af = false;
    private boolean ag = false;
    private long al = 0;
    private long am = 0;
    private boolean at = false;
    private Queue<a> au = new LinkedList();
    List<l> h = new ArrayList();

    /* loaded from: classes5.dex */
    public static class a {
        public long a;
        public int b;
        public int c;
        public int d;
        public Bundle e;

        public a(long j, int i, int i2, int i3) {
            this.a = j;
            this.b = i;
            this.c = i2;
            this.d = i3;
        }

        public a(Bundle bundle) {
            this.e = bundle;
        }
    }

    public e(Context context, String str, int i) {
        this.E = context;
        this.ao = str;
        this.ap = i;
    }

    private void Q() {
        if (!this.x && !this.u && !this.t && !this.y) {
            this.a = this.c;
            return;
        }
        if (this.a > 20.0f) {
            this.a = 20.0f;
        }
        if (E().a > 20.0f) {
            ab E = E();
            E.a = 20.0f;
            a(E);
        }
    }

    private void R() {
        if (this.n) {
            return;
        }
        this.n = true;
        this.o = false;
        if (this.h != null) {
            for (l lVar : this.h) {
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
        if (this.e) {
            long j = this.am - this.al;
            float abs = (Math.abs(this.aj - this.ah) * 1000.0f) / ((float) j);
            float abs2 = (Math.abs(this.ak - this.ai) * 1000.0f) / ((float) j);
            float sqrt = (float) Math.sqrt((abs2 * abs2) + (abs * abs));
            if (sqrt > 500.0f) {
                A();
                a(34, (int) (sqrt * 0.6f), (((int) this.ak) << 16) | ((int) this.aj));
                L();
                return true;
            }
            return false;
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
        if (this.i == null) {
            return;
        }
        dVar.a = this.i.a(dVar.c, dVar.d, dVar.b);
        this.F.add(dVar);
    }

    private void a(String str, String str2, long j) {
        try {
            Class<?> cls = Class.forName(str);
            cls.getMethod(str2, Long.TYPE).invoke(cls.newInstance(), Long.valueOf(j));
        } catch (Exception e) {
        }
    }

    private void b(MotionEvent motionEvent) {
        if (this.T.e) {
            return;
        }
        this.ae = motionEvent.getDownTime();
        if (this.ae - this.ad >= 400) {
            this.ad = this.ae;
        } else if (Math.abs(motionEvent.getX() - this.aa) >= 120.0f || Math.abs(motionEvent.getY() - this.ab) >= 120.0f) {
            this.ad = this.ae;
        } else {
            this.ad = 0L;
        }
        this.aa = motionEvent.getX();
        this.ab = motionEvent.getY();
        a(4, 0, ((int) motionEvent.getX()) | (((int) motionEvent.getY()) << 16));
        this.ac = true;
    }

    private void b(String str, Bundle bundle) {
        if (this.i == null) {
            return;
        }
        this.H.a(str);
        this.H.a(bundle);
        this.i.b(this.H.a);
    }

    private boolean c(MotionEvent motionEvent) {
        if (!this.T.e && System.currentTimeMillis() - m >= 300) {
            if (this.p) {
                if (this.h != null) {
                    for (l lVar : this.h) {
                        GeoPoint b = b((int) motionEvent.getX(), (int) motionEvent.getY());
                        if (lVar != null) {
                            lVar.d(b);
                        }
                    }
                }
                return true;
            }
            float abs = Math.abs(motionEvent.getX() - this.aa);
            float abs2 = Math.abs(motionEvent.getY() - this.ab);
            float density = (float) (((double) SysOSUtil.getDensity()) > 1.5d ? SysOSUtil.getDensity() * 1.5d : SysOSUtil.getDensity());
            if (!this.ac || abs / density > 3.0f || abs2 / density > 3.0f) {
                this.ac = false;
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (x < 0) {
                    x = 0;
                }
                if (y < 0) {
                    y = 0;
                }
                if (this.e) {
                    BaiduMap.mapStatusReason |= 1;
                    R();
                    a(3, 0, (y << 16) | x);
                    return false;
                }
                return false;
            }
            return true;
        }
        return true;
    }

    private boolean d(MotionEvent motionEvent) {
        if (this.p) {
            if (this.h != null) {
                for (l lVar : this.h) {
                    GeoPoint b = b((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (lVar != null) {
                        lVar.e(b);
                    }
                }
            }
            this.p = false;
            return true;
        }
        boolean z = !this.T.e && motionEvent.getEventTime() - this.ae < 400 && Math.abs(motionEvent.getX() - this.aa) < 10.0f && Math.abs(motionEvent.getY() - this.ab) < 10.0f;
        L();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (z) {
            return false;
        }
        if (x < 0) {
            x = 0;
        }
        a(5, 0, ((y < 0 ? 0 : y) << 16) | x);
        return true;
    }

    private boolean e(float f, float f2) {
        if (this.i == null || !this.k) {
            return true;
        }
        this.af = false;
        GeoPoint b = b((int) f, (int) f2);
        if (b != null) {
            if (this.h != null) {
                for (l lVar : this.h) {
                    if (lVar != null) {
                        lVar.b(b);
                    }
                }
            }
            if (this.f) {
                ab E = E();
                E.a += 1.0f;
                E.d = b.getLongitudeE6();
                E.e = b.getLatitudeE6();
                a(E, 300);
                m = System.currentTimeMillis();
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean e(Bundle bundle) {
        if (this.i == null) {
            return false;
        }
        return this.i.e(bundle);
    }

    private boolean f(Bundle bundle) {
        boolean z = false;
        if (bundle != null && this.i != null && (z = this.i.d(bundle))) {
            e(z);
            this.i.b(this.C.a);
        }
        return z;
    }

    private void g(Bundle bundle) {
        if (bundle.get("param") == null) {
            int i = bundle.getInt("type");
            if (i == h.ground.ordinal()) {
                bundle.putLong("layer_addr", this.J.a);
                return;
            } else if (i >= h.arc.ordinal()) {
                bundle.putLong("layer_addr", this.J.a);
                return;
            } else if (i == h.popup.ordinal()) {
                bundle.putLong("layer_addr", this.J.a);
                return;
            } else {
                bundle.putLong("layer_addr", this.J.a);
                return;
            }
        }
        Bundle bundle2 = (Bundle) bundle.get("param");
        int i2 = bundle2.getInt("type");
        if (i2 == h.ground.ordinal()) {
            bundle2.putLong("layer_addr", this.J.a);
        } else if (i2 >= h.arc.ordinal()) {
            bundle2.putLong("layer_addr", this.J.a);
        } else if (i2 == h.popup.ordinal()) {
            bundle2.putLong("layer_addr", this.J.a);
        } else {
            bundle2.putLong("layer_addr", this.J.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void l(boolean z) {
        as = com.baidu.mapsdkplatform.comjni.map.basemap.a.b();
        if (as == null || as.size() == 0) {
            com.baidu.mapsdkplatform.comjni.map.basemap.a.b(0L, z);
            return;
        }
        com.baidu.mapsdkplatform.comjni.map.basemap.a.b(as.get(0).a, z);
        for (JNIBaseMap jNIBaseMap : as) {
            if (jNIBaseMap != null) {
                jNIBaseMap.ClearLayer(jNIBaseMap.a, -1L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A() {
        if (this.n || this.o) {
            return;
        }
        this.o = true;
        if (this.h == null) {
            return;
        }
        for (l lVar : this.h) {
            if (lVar != null) {
                lVar.a(E());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B() {
        this.o = false;
        this.n = false;
        if (this.h == null) {
            return;
        }
        for (l lVar : this.h) {
            if (lVar != null) {
                lVar.c(E());
            }
        }
    }

    public boolean C() {
        if (this.i != null) {
            return this.i.a(this.I.a);
        }
        return false;
    }

    public boolean D() {
        if (this.i != null) {
            return this.i.a(this.ar.a);
        }
        return false;
    }

    public ab E() {
        if (this.i == null) {
            return null;
        }
        Bundle h = this.i.h();
        ab abVar = new ab();
        abVar.a(h);
        return abVar;
    }

    public LatLngBounds F() {
        if (this.i == null) {
            return null;
        }
        Bundle i = this.i.i();
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab I() {
        if (this.i == null) {
            return null;
        }
        Bundle j = this.i.j();
        ab abVar = new ab();
        abVar.a(j);
        return abVar;
    }

    public double J() {
        return E().m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K() {
        this.n = false;
        if (this.o || this.h == null) {
            return;
        }
        for (l lVar : this.h) {
            if (lVar != null) {
                lVar.c(E());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L() {
        this.S = 0;
        this.T.e = false;
        this.T.h = 0.0d;
    }

    public float[] M() {
        if (this.i == null) {
            return null;
        }
        return this.i.u();
    }

    public float[] N() {
        if (this.i == null) {
            return null;
        }
        return this.i.v();
    }

    public Queue<a> O() {
        return this.au;
    }

    public void P() {
        if (this.au.isEmpty()) {
            return;
        }
        a poll = this.au.poll();
        if (poll.e == null) {
            com.baidu.mapsdkplatform.comjni.map.basemap.a.a(poll.a, poll.b, poll.c, poll.d);
        } else if (this.i != null) {
            A();
            this.i.a(poll.e);
        }
    }

    public float a(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.k) {
            if (this.i == null) {
                return 0.0f;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("left", i);
            bundle.putInt(HorizontalTranslateLayout.RIGHT, i3);
            bundle.putInt(VerticalTranslateLayout.BOTTOM, i4);
            bundle.putInt(VerticalTranslateLayout.TOP, i2);
            bundle.putInt("hasHW", 1);
            bundle.putInt("width", i5);
            bundle.putInt("height", i6);
            return this.i.c(bundle);
        }
        return 12.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i, int i2, int i3) {
        if (this.at) {
            this.au.add(new a(this.j, i, i2, i3));
            return 0;
        }
        return com.baidu.mapsdkplatform.comjni.map.basemap.a.a(this.j, i, i2, i3);
    }

    @Override // com.baidu.mapsdkplatform.comjni.map.basemap.b
    public int a(Bundle bundle, long j, int i, Bundle bundle2) {
        if (j == this.H.a) {
            bundle.putString("jsondata", this.H.a());
            bundle.putBundle("param", this.H.b());
            return this.H.g;
        } else if (j == this.G.a) {
            bundle.putString("jsondata", this.G.a());
            bundle.putBundle("param", this.G.b());
            return this.G.g;
        } else if (j == this.K.a) {
            bundle.putBundle("param", this.M.a(bundle2.getInt(Config.EVENT_HEAT_X), bundle2.getInt("y"), bundle2.getInt("zoom")));
            return this.K.g;
        } else if (j == this.C.a) {
            bundle.putBundle("param", this.D.a(bundle2.getInt(Config.EVENT_HEAT_X), bundle2.getInt("y"), bundle2.getInt("zoom"), this.E));
            return this.C.g;
        } else {
            return 0;
        }
    }

    public Point a(GeoPoint geoPoint) {
        return this.N.a(geoPoint);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.F = new ArrayList();
        this.an = new f();
        a(this.an);
        this.aq = new b();
        a(this.aq);
        this.K = new n();
        a(this.K);
        this.L = new com.baidu.mapsdkplatform.comapi.map.a();
        a(this.L);
        a(new p());
        this.I = new ae();
        a(this.I);
        this.ar = new c();
        a(this.ar);
        if (this.i != null) {
            this.i.e(false);
        }
        this.J = new ah();
        a(this.J);
        this.H = new g();
        a(this.H);
        this.G = new x();
        a(this.G);
    }

    public void a(float f, float f2) {
        this.a = f;
        this.c = f;
        this.b = f2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.i = new com.baidu.mapsdkplatform.comjni.map.basemap.a();
        this.i.a(i);
        this.j = this.i.a();
        a("com.baidu.platform.comapi.wnplatform.walkmap.WNaviBaiduMap", "setId", this.j);
        if (SysOSUtil.getDensityDpi() < 180) {
            this.l = 18;
        } else if (SysOSUtil.getDensityDpi() < 240) {
            this.l = 25;
        } else if (SysOSUtil.getDensityDpi() < 320) {
            this.l = 37;
        } else {
            this.l = 50;
        }
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
        Activity a2 = a(this.E);
        if (a2 == null) {
            throw new RuntimeException("Please give the right context.");
        }
        Display defaultDisplay = a2.getWindowManager().getDefaultDisplay();
        this.i.a(str4, str7, str9, str10, str8, str5, this.ao, this.ap, str6, defaultDisplay.getWidth(), defaultDisplay.getHeight(), SysOSUtil.getDensityDpi(), mapTmpStgMax, domTmpStgMax, itsTmpStgMax, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2) {
        this.Q = i;
        this.R = i2;
    }

    public void a(long j, long j2, long j3, long j4, boolean z) {
        this.i.a(j, j2, j3, j4, z);
    }

    public void a(Bitmap bitmap) {
        Bundle bundle;
        int i = 0;
        if (this.i == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("type", 0);
            jSONObject2.put(Config.EVENT_HEAT_X, O);
            jSONObject2.put("y", P);
            jSONObject2.put("hidetime", 1000);
            jSONArray.put(jSONObject2);
            jSONObject.put("data", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
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
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    parcelItemArr[i2] = (ParcelItem) arrayList.get(i2);
                    i = i2 + 1;
                }
                bundle2.putParcelableArray("icondata", parcelItemArr);
            }
            bundle = bundle2;
        }
        b(jSONObject.toString(), bundle);
        this.i.b(this.H.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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
        int latitudeE6 = (int) ll2mc2.getLatitudeE6();
        int longitudeE6 = (int) ll2mc2.getLongitudeE6();
        int latitudeE62 = (int) ll2mc.getLatitudeE6();
        Bundle bundle = new Bundle();
        bundle.putInt("maxCoorx", (int) ll2mc.getLongitudeE6());
        bundle.putInt("minCoory", latitudeE6);
        bundle.putInt("minCoorx", longitudeE6);
        bundle.putInt("maxCoory", latitudeE62);
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
        this.h.add(lVar);
    }

    public void a(o oVar) {
        this.M = oVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(z zVar) {
        new ab();
        if (zVar == null) {
            zVar = new z();
        }
        ab abVar = zVar.a;
        this.z = zVar.f;
        this.A = zVar.d;
        this.e = zVar.e;
        this.f = zVar.g;
        this.i.a(abVar.a(this));
        this.i.c(y.DEFAULT.ordinal());
        this.v = zVar.b;
        if (zVar.b) {
            O = (int) (SysOSUtil.getDensity() * 40.0f);
            P = (int) (SysOSUtil.getDensity() * 40.0f);
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(Config.EVENT_HEAT_X, O);
                jSONObject2.put("y", P);
                jSONObject2.put("hidetime", 1000);
                jSONArray.put(jSONObject2);
                jSONObject.put("data", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.H.a(jSONObject.toString());
            this.i.a(this.H.a, true);
        } else {
            this.i.a(this.H.a, false);
        }
        int i = zVar.c;
        if (i == 2) {
            a(true);
        }
        if (i == 3) {
            this.i.a(this.an.a, false);
            this.i.a(this.ar.a, false);
            this.i.a(this.I.a, false);
            this.i.e(false);
        }
    }

    public void a(String str, Bundle bundle) {
        if (this.i == null) {
            return;
        }
        this.G.a(str);
        this.G.a(bundle);
        this.i.b(this.G.a);
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
        if (this.i == null) {
            return;
        }
        if (!this.i.a(this.an.a)) {
            this.i.a(this.an.a, true);
        }
        this.u = z;
        Q();
        this.i.a(this.u);
    }

    public boolean a(float f, float f2, float f3, float f4) {
        float f5 = this.R - f2;
        float f6 = this.R - f4;
        if (this.T.e) {
            if (this.S == 0) {
                if ((this.T.c - f5 <= 0.0f || this.T.d - f6 <= 0.0f) && (this.T.c - f5 >= 0.0f || this.T.d - f6 >= 0.0f)) {
                    this.S = 2;
                } else {
                    double atan2 = Math.atan2(f6 - f5, f3 - f) - Math.atan2(this.T.d - this.T.c, this.T.b - this.T.a);
                    double sqrt = Math.sqrt(((f3 - f) * (f3 - f)) + ((f6 - f5) * (f6 - f5))) / this.T.h;
                    int log = (int) ((Math.log(sqrt) / Math.log(2.0d)) * 10000.0d);
                    int i = (int) ((atan2 * 180.0d) / 3.1416d);
                    if ((sqrt <= 0.0d || (log <= 3000 && log >= -3000)) && Math.abs(i) < 10) {
                        this.S = 1;
                    } else {
                        this.S = 2;
                    }
                }
                if (this.S == 0) {
                    return true;
                }
            }
            if (this.S == 1 && this.z) {
                if (this.T.c - f5 > 0.0f && this.T.d - f6 > 0.0f) {
                    R();
                    a(1, 83, 0);
                } else if (this.T.c - f5 < 0.0f && this.T.d - f6 < 0.0f) {
                    R();
                    a(1, 87, 0);
                }
            } else if (this.S == 2 || this.S == 4 || this.S == 3) {
                double atan22 = Math.atan2(f6 - f5, f3 - f) - Math.atan2(this.T.d - this.T.c, this.T.b - this.T.a);
                double sqrt2 = Math.sqrt(((f3 - f) * (f3 - f)) + ((f6 - f5) * (f6 - f5))) / this.T.h;
                int log2 = (int) ((Math.log(sqrt2) / Math.log(2.0d)) * 10000.0d);
                double atan23 = Math.atan2(this.T.g - this.T.c, this.T.f - this.T.a);
                double sqrt3 = Math.sqrt(((this.T.f - this.T.a) * (this.T.f - this.T.a)) + ((this.T.g - this.T.c) * (this.T.g - this.T.c)));
                float cos = (float) ((Math.cos(atan23 + atan22) * sqrt3 * sqrt2) + f);
                float sin = (float) ((Math.sin(atan23 + atan22) * sqrt3 * sqrt2) + f5);
                int i2 = (int) ((atan22 * 180.0d) / 3.1416d);
                if (sqrt2 > 0.0d && (3 == this.S || (Math.abs(log2) > 2000 && 2 == this.S))) {
                    this.S = 3;
                    float f7 = E().a;
                    if (this.f) {
                        if (sqrt2 > 1.0d) {
                            if (f7 >= this.a) {
                                return false;
                            }
                            R();
                            a(UIMsg.k_event.V_WM_ROTATE, 3, log2);
                        } else if (f7 <= this.b) {
                            return false;
                        } else {
                            R();
                            a(UIMsg.k_event.V_WM_ROTATE, 3, log2);
                        }
                    }
                } else if (i2 != 0 && (4 == this.S || (Math.abs(i2) > 10 && 2 == this.S))) {
                    this.S = 4;
                    if (this.A) {
                        BaiduMap.mapStatusReason |= 1;
                        R();
                        a(UIMsg.k_event.V_WM_ROTATE, 1, i2);
                    }
                }
                this.T.f = cos;
                this.T.g = sin;
            }
        }
        if (2 != this.S) {
            this.T.c = f5;
            this.T.d = f6;
            this.T.a = f;
            this.T.b = f3;
        }
        if (!this.T.e) {
            this.T.f = this.Q / 2;
            this.T.g = this.R / 2;
            this.T.e = true;
            if (0.0d == this.T.h) {
                this.T.h = Math.sqrt(((this.T.b - this.T.a) * (this.T.b - this.T.a)) + ((this.T.d - this.T.c) * (this.T.d - this.T.c)));
            }
        }
        return true;
    }

    @Override // com.baidu.mapsdkplatform.comjni.map.basemap.b
    public boolean a(long j) {
        Iterator<d> it = this.F.iterator();
        while (it.hasNext()) {
            if (it.next().a == j) {
                return true;
            }
        }
        return false;
    }

    public boolean a(Point point) {
        if (point != null && this.i != null && point.x >= 0 && point.y >= 0) {
            O = point.x;
            P = point.y;
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(Config.EVENT_HEAT_X, O);
                jSONObject2.put("y", P);
                jSONObject2.put("hidetime", 1000);
                jSONArray.put(jSONObject2);
                jSONObject.put("data", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.H.a(jSONObject.toString());
            this.i.b(this.H.a);
            return true;
        }
        return false;
    }

    public boolean a(Bundle bundle) {
        if (this.i == null) {
            return false;
        }
        this.C = new aj();
        long a2 = this.i.a(this.C.c, this.C.d, this.C.b);
        if (a2 != 0) {
            this.C.a = a2;
            this.F.add(this.C);
            bundle.putLong("sdktileaddr", a2);
            return e(bundle) && f(bundle);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(MotionEvent motionEvent) {
        ab E;
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount == 2 && (!c((int) motionEvent.getX(0), (int) motionEvent.getY(0)) || !c((int) motionEvent.getX(1), (int) motionEvent.getY(1)))) {
            pointerCount = 1;
        }
        if (pointerCount != 2) {
            switch (motionEvent.getAction()) {
                case 0:
                    b(motionEvent);
                    return true;
                case 1:
                    return d(motionEvent);
                case 2:
                    c(motionEvent);
                    return true;
                default:
                    return false;
            }
        }
        float y = this.R - motionEvent.getY(0);
        float y2 = this.R - motionEvent.getY(1);
        float x = motionEvent.getX(0);
        float x2 = motionEvent.getX(1);
        switch (motionEvent.getAction()) {
            case 5:
                this.W = motionEvent.getEventTime();
                this.Z--;
                break;
            case 6:
                this.Y = motionEvent.getEventTime();
                this.Z++;
                break;
            case 261:
                this.V = motionEvent.getEventTime();
                this.Z--;
                break;
            case 262:
                this.X = motionEvent.getEventTime();
                this.Z++;
                break;
        }
        if (this.U == null) {
            this.U = VelocityTracker.obtain();
        }
        this.U.addMovement(motionEvent);
        int minimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.U.computeCurrentVelocity(1000, ViewConfiguration.getMaximumFlingVelocity());
        float xVelocity = this.U.getXVelocity(1);
        float yVelocity = this.U.getYVelocity(1);
        float xVelocity2 = this.U.getXVelocity(2);
        float yVelocity2 = this.U.getYVelocity(2);
        if (Math.abs(xVelocity) > minimumFlingVelocity || Math.abs(yVelocity) > minimumFlingVelocity || Math.abs(xVelocity2) > minimumFlingVelocity || Math.abs(yVelocity2) > minimumFlingVelocity) {
            if (this.T.e) {
                if (this.S == 0) {
                    if ((this.T.c - y <= 0.0f || this.T.d - y2 <= 0.0f) && (this.T.c - y >= 0.0f || this.T.d - y2 >= 0.0f)) {
                        this.S = 2;
                    } else {
                        double atan2 = Math.atan2(y2 - y, x2 - x) - Math.atan2(this.T.d - this.T.c, this.T.b - this.T.a);
                        double sqrt = Math.sqrt(((x2 - x) * (x2 - x)) + ((y2 - y) * (y2 - y))) / this.T.h;
                        int log = (int) ((Math.log(sqrt) / Math.log(2.0d)) * 10000.0d);
                        int i = (int) ((atan2 * 180.0d) / 3.1416d);
                        if ((sqrt <= 0.0d || (log <= 3000 && log >= -3000)) && Math.abs(i) < 10) {
                            this.S = 1;
                        } else {
                            this.S = 2;
                        }
                    }
                    if (this.S == 0) {
                        return true;
                    }
                }
                if (this.S == 1 && this.z) {
                    if (this.T.c - y > 0.0f && this.T.d - y2 > 0.0f) {
                        BaiduMap.mapStatusReason |= 1;
                        R();
                        a(1, 83, 0);
                    } else if (this.T.c - y < 0.0f && this.T.d - y2 < 0.0f) {
                        BaiduMap.mapStatusReason |= 1;
                        R();
                        a(1, 87, 0);
                    }
                } else if (this.S == 2 || this.S == 4 || this.S == 3) {
                    double atan22 = Math.atan2(y2 - y, x2 - x) - Math.atan2(this.T.d - this.T.c, this.T.b - this.T.a);
                    double sqrt2 = Math.sqrt(((x2 - x) * (x2 - x)) + ((y2 - y) * (y2 - y))) / this.T.h;
                    int log2 = (int) ((Math.log(sqrt2) / Math.log(2.0d)) * 10000.0d);
                    double atan23 = Math.atan2(this.T.g - this.T.c, this.T.f - this.T.a);
                    double sqrt3 = Math.sqrt(((this.T.f - this.T.a) * (this.T.f - this.T.a)) + ((this.T.g - this.T.c) * (this.T.g - this.T.c)));
                    float cos = (float) ((Math.cos(atan23 + atan22) * sqrt3 * sqrt2) + x);
                    float sin = (float) ((Math.sin(atan23 + atan22) * sqrt3 * sqrt2) + y);
                    int i2 = (int) ((atan22 * 180.0d) / 3.1416d);
                    if (sqrt2 > 0.0d && (3 == this.S || (Math.abs(log2) > 2000 && 2 == this.S))) {
                        this.S = 3;
                        float f = E().a;
                        if (this.f) {
                            if (sqrt2 > 1.0d) {
                                if (f >= this.a) {
                                    return false;
                                }
                                BaiduMap.mapStatusReason |= 1;
                                R();
                                a(UIMsg.k_event.V_WM_ROTATE, 3, log2);
                            } else if (f <= this.b) {
                                return false;
                            } else {
                                BaiduMap.mapStatusReason |= 1;
                                R();
                                a(UIMsg.k_event.V_WM_ROTATE, 3, log2);
                            }
                        }
                    } else if (i2 != 0 && (4 == this.S || (Math.abs(i2) > 10 && 2 == this.S))) {
                        this.S = 4;
                        if (this.A) {
                            R();
                            a(UIMsg.k_event.V_WM_ROTATE, 1, i2);
                        }
                    }
                    this.T.f = cos;
                    this.T.g = sin;
                }
            }
        } else if (this.S == 0 && this.Z == 0) {
            this.X = this.X > this.Y ? this.X : this.Y;
            this.V = this.V < this.W ? this.W : this.V;
            if (this.X - this.V < 200 && this.f && (E = E()) != null) {
                E.a -= 1.0f;
                BaiduMap.mapStatusReason |= 1;
                a(E, 300);
            }
        }
        if (2 != this.S) {
            this.T.c = y;
            this.T.d = y2;
            this.T.a = x;
            this.T.b = x2;
        }
        if (!this.T.e) {
            this.T.f = this.Q / 2;
            this.T.g = this.R / 2;
            this.T.e = true;
            if (0.0d == this.T.h) {
                this.T.h = Math.sqrt(((this.T.b - this.T.a) * (this.T.b - this.T.a)) + ((this.T.d - this.T.c) * (this.T.d - this.T.c)));
            }
        }
        return true;
    }

    public boolean a(String str, String str2) {
        return this.i.a(str, str2);
    }

    public GeoPoint b(int i, int i2) {
        return this.N.a(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(float f, float f2) {
        if (this.T.e) {
            return;
        }
        this.ae = System.currentTimeMillis();
        if (this.ae - this.ad >= 400) {
            this.ad = this.ae;
        } else if (Math.abs(f - this.aa) >= 120.0f || Math.abs(f2 - this.ab) >= 120.0f) {
            this.ad = this.ae;
        } else {
            this.ad = 0L;
            this.af = true;
        }
        this.aa = f;
        this.ab = f2;
        a(4, 0, ((int) f) | (((int) f2) << 16));
        this.ac = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        if (this.i != null) {
            this.i.b(i);
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

    /* JADX INFO: Access modifiers changed from: package-private */
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
            this.i.a(dVar.a, false);
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
        if (z) {
            this.i.a(this.J.a, this.G.a);
        } else {
            this.i.a(this.G.a, this.J.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(float f, float f2) {
        if (!this.T.e && System.currentTimeMillis() - m >= 300) {
            if (this.p) {
                if (this.h != null) {
                    for (l lVar : this.h) {
                        GeoPoint b = b((int) f, (int) f2);
                        if (lVar != null) {
                            lVar.d(b);
                        }
                    }
                }
                return true;
            }
            float abs = Math.abs(f - this.aa);
            float abs2 = Math.abs(f2 - this.ab);
            float density = (float) (((double) SysOSUtil.getDensity()) > 1.5d ? SysOSUtil.getDensity() * 1.5d : SysOSUtil.getDensity());
            if (!this.ac || abs / density > 3.0f || abs2 / density > 3.0f) {
                this.ac = false;
                int i = (int) f;
                int i2 = (int) f2;
                if (i < 0) {
                    i = 0;
                }
                if (i2 < 0) {
                    i2 = 0;
                }
                if (this.e) {
                    this.ah = this.aj;
                    this.ai = this.ak;
                    this.aj = f;
                    this.ak = f2;
                    this.al = this.am;
                    this.am = System.currentTimeMillis();
                    this.ag = true;
                    R();
                    a(3, 0, (i2 << 16) | i);
                    return false;
                }
                return false;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(int i, int i2) {
        return i >= 0 && i <= this.Q + 0 && i2 >= 0 && i2 <= this.R + 0;
    }

    public void d() {
        if (this.i == null) {
            return;
        }
        for (d dVar : this.F) {
            if ((dVar instanceof x) || (dVar instanceof com.baidu.mapsdkplatform.comapi.map.a) || (dVar instanceof n)) {
                this.i.a(dVar.a, false);
            } else {
                this.i.a(dVar.a, true);
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
        if (this.i == null) {
            return;
        }
        this.i.a(this.H.a, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(float f, float f2) {
        if (this.p) {
            if (this.h != null) {
                for (l lVar : this.h) {
                    GeoPoint b = b((int) f, (int) f2);
                    if (lVar != null) {
                        lVar.e(b);
                    }
                }
            }
            this.p = false;
            return true;
        }
        if (!this.T.e) {
            if (this.af) {
                return e(f, f2);
            }
            if (this.ag) {
                return S();
            }
            if (System.currentTimeMillis() - this.ae < 400 && Math.abs(f - this.aa) < 10.0f && Math.abs(f2 - this.ab) < 10.0f) {
                L();
                return true;
            }
        }
        L();
        int i = (int) f;
        int i2 = (int) f2;
        if (i < 0) {
            i = 0;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        a(5, 0, (i2 << 16) | i);
        return true;
    }

    public void e(boolean z) {
        if (this.i == null) {
            return;
        }
        this.i.a(this.C.a, z);
    }

    public boolean e() {
        if (this.C == null || this.i == null) {
            return false;
        }
        return this.i.c(this.C.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        if (this.i == null) {
            return;
        }
        this.N = new af(this.i);
    }

    public void f(boolean z) {
        if (this.i == null) {
            return;
        }
        this.i.a(this.an.a, z);
    }

    public void g(boolean z) {
        if (this.i == null) {
            return;
        }
        this.y = z;
        this.i.b(this.y);
    }

    public boolean g() {
        return this.t;
    }

    public String h() {
        if (this.i == null) {
            return null;
        }
        return this.i.e(this.H.a);
    }

    public void h(boolean z) {
        if (this.i == null) {
            return;
        }
        this.t = z;
        this.i.c(this.t);
    }

    public void i(boolean z) {
        if (this.i == null) {
            return;
        }
        this.i.d(z);
    }

    public boolean i() {
        return this.y;
    }

    public void j(boolean z) {
        if (this.i == null) {
            return;
        }
        this.v = z;
        this.i.a(this.H.a, z);
    }

    public boolean j() {
        if (this.i == null) {
            return false;
        }
        return this.i.k();
    }

    public void k(boolean z) {
        if (z) {
            this.a = 22.0f;
            this.c = 22.0f;
        } else {
            this.a = 21.0f;
            this.c = 21.0f;
        }
        this.i.e(z);
        this.i.d(this.aq.a);
        this.i.d(this.ar.a);
    }

    public boolean k() {
        return this.u;
    }

    public boolean l() {
        return this.i.a(this.an.a);
    }

    public void m(boolean z) {
        if (this.i == null) {
            return;
        }
        this.w = z;
        this.i.a(this.G.a, z);
    }

    public boolean m() {
        if (this.i == null) {
            return false;
        }
        return this.i.o();
    }

    public void n() {
        if (this.i == null) {
            return;
        }
        this.i.d(this.J.a);
    }

    public void n(boolean z) {
        if (this.i == null) {
            return;
        }
        this.x = z;
        this.i.a(this.K.a, z);
    }

    public void o() {
        if (this.i == null) {
            return;
        }
        this.i.p();
        this.i.b(this.K.a);
    }

    public void o(boolean z) {
        this.e = z;
    }

    public MapBaseIndoorMapInfo p() {
        return this.i.q();
    }

    public void p(boolean z) {
        this.f = z;
    }

    public void q(boolean z) {
        this.g = z;
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
        if (this.i == null) {
            return;
        }
        this.i.b(this.K.a);
    }

    public void t(boolean z) {
        if (this.i != null) {
            this.i.a(this.I.a, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u() {
        if (this.i == null) {
            return;
        }
        this.i.e();
    }

    public void u(boolean z) {
        if (this.i != null) {
            this.i.a(this.ar.a, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v() {
        if (this.i == null) {
            return;
        }
        this.i.f();
    }

    public void v(boolean z) {
        this.at = z;
    }

    public boolean w() {
        return this.e;
    }

    public boolean x() {
        return this.f;
    }

    public boolean y() {
        return this.A;
    }

    public boolean z() {
        return this.z;
    }
}
