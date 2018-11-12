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
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ng.ai.apps.impl.map.model.element.MarkerModel;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import com.baidu.searchbox.ng.ai.apps.trace.ErrDef;
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
/* loaded from: classes4.dex */
public class e implements com.baidu.mapsdkplatform.comjni.map.basemap.b {
    private static int N;
    private static int O;
    private static List<JNIBaseMap> ar;
    private aj B;
    private ai C;
    private Context D;
    private List<d> E;
    private x F;
    private g G;
    private ae H;
    private ah I;
    private n J;
    private com.baidu.mapsdkplatform.comapi.map.a K;
    private o L;
    private af M;
    private int P;
    private int Q;
    private int R;
    private VelocityTracker T;
    private long U;
    private long V;
    private long W;
    private long X;
    private int Y;
    private float Z;
    private float aa;
    private boolean ab;
    private long ac;
    private long ad;
    private float ag;
    private float ah;
    private float ai;
    private float aj;
    private f am;
    private String an;
    private int ao;
    private b ap;
    private c aq;
    com.baidu.mapsdkplatform.comjni.map.basemap.a h;
    long i;
    boolean j;
    int k;
    boolean m;
    boolean n;
    boolean o;
    public LatLngBounds p;
    public MapStatus q;
    private boolean s;
    private boolean t;
    private static final String r = j.class.getSimpleName();
    static long l = 0;
    public float a = 21.0f;
    public float b = 4.0f;
    public float c = 21.0f;
    private boolean u = true;
    private boolean v = false;
    private boolean w = false;
    private boolean x = false;
    private boolean y = true;
    boolean d = true;
    boolean e = true;
    boolean f = false;
    private boolean z = true;
    private boolean A = false;
    private j.a S = new j.a();
    private boolean ae = false;
    private boolean af = false;
    private long ak = 0;
    private long al = 0;
    private boolean as = false;
    private Queue<a> at = new LinkedList();
    List<l> g = new ArrayList();

    /* loaded from: classes4.dex */
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
        this.D = context;
        this.an = str;
        this.ao = i;
    }

    private void O() {
        if (!this.w && !this.t && !this.s && !this.x) {
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

    private void P() {
        if (this.m) {
            return;
        }
        this.m = true;
        this.n = false;
        if (this.g != null) {
            for (l lVar : this.g) {
                if (lVar != null) {
                    lVar.a(E());
                }
            }
        }
    }

    private boolean Q() {
        if (this.h == null || !this.j) {
            return true;
        }
        this.af = false;
        if (this.d) {
            long j = this.al - this.ak;
            float abs = (Math.abs(this.ai - this.ag) * 1000.0f) / ((float) j);
            float abs2 = (Math.abs(this.aj - this.ah) * 1000.0f) / ((float) j);
            float sqrt = (float) Math.sqrt((abs2 * abs2) + (abs * abs));
            if (sqrt > 500.0f) {
                A();
                a(34, (int) (sqrt * 0.6f), (((int) this.aj) << 16) | ((int) this.ai));
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
        if (this.h == null) {
            return;
        }
        dVar.a = this.h.a(dVar.c, dVar.d, dVar.b);
        this.E.add(dVar);
    }

    private void a(String str, String str2, long j) {
        try {
            Class<?> cls = Class.forName(str);
            cls.getMethod(str2, Long.TYPE).invoke(cls.newInstance(), Long.valueOf(j));
        } catch (Exception e) {
        }
    }

    private void b(MotionEvent motionEvent) {
        if (this.S.e) {
            return;
        }
        this.ad = motionEvent.getDownTime();
        if (this.ad - this.ac >= 400) {
            this.ac = this.ad;
        } else if (Math.abs(motionEvent.getX() - this.Z) >= 120.0f || Math.abs(motionEvent.getY() - this.aa) >= 120.0f) {
            this.ac = this.ad;
        } else {
            this.ac = 0L;
        }
        this.Z = motionEvent.getX();
        this.aa = motionEvent.getY();
        a(4, 0, ((int) motionEvent.getX()) | (((int) motionEvent.getY()) << 16));
        this.ab = true;
    }

    private void b(String str, Bundle bundle) {
        if (this.h == null) {
            return;
        }
        this.G.a(str);
        this.G.a(bundle);
        this.h.b(this.G.a);
    }

    private boolean c(MotionEvent motionEvent) {
        if (!this.S.e && System.currentTimeMillis() - l >= 300) {
            if (this.o) {
                if (this.g != null) {
                    for (l lVar : this.g) {
                        GeoPoint b = b((int) motionEvent.getX(), (int) motionEvent.getY());
                        if (lVar != null) {
                            lVar.d(b);
                        }
                    }
                }
                return true;
            }
            float abs = Math.abs(motionEvent.getX() - this.Z);
            float abs2 = Math.abs(motionEvent.getY() - this.aa);
            float density = (float) (((double) SysOSUtil.getDensity()) > 1.5d ? SysOSUtil.getDensity() * 1.5d : SysOSUtil.getDensity());
            if (!this.ab || abs / density > 3.0f || abs2 / density > 3.0f) {
                this.ab = false;
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (x < 0) {
                    x = 0;
                }
                if (y < 0) {
                    y = 0;
                }
                if (this.d) {
                    BaiduMap.mapStatusReason |= 1;
                    P();
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
        if (this.o) {
            if (this.g != null) {
                for (l lVar : this.g) {
                    GeoPoint b = b((int) motionEvent.getX(), (int) motionEvent.getY());
                    if (lVar != null) {
                        lVar.e(b);
                    }
                }
            }
            this.o = false;
            return true;
        }
        boolean z = !this.S.e && motionEvent.getEventTime() - this.ad < 400 && Math.abs(motionEvent.getX() - this.Z) < 10.0f && Math.abs(motionEvent.getY() - this.aa) < 10.0f;
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
        if (this.h == null || !this.j) {
            return true;
        }
        this.ae = false;
        GeoPoint b = b((int) f, (int) f2);
        if (b != null) {
            if (this.g != null) {
                for (l lVar : this.g) {
                    if (lVar != null) {
                        lVar.b(b);
                    }
                }
            }
            if (this.e) {
                ab E = E();
                E.a += 1.0f;
                E.d = b.getLongitudeE6();
                E.e = b.getLatitudeE6();
                a(E, 300);
                l = System.currentTimeMillis();
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean e(Bundle bundle) {
        if (this.h == null) {
            return false;
        }
        return this.h.e(bundle);
    }

    private boolean f(Bundle bundle) {
        boolean z = false;
        if (bundle != null && this.h != null && (z = this.h.d(bundle))) {
            e(z);
            this.h.b(this.B.a);
        }
        return z;
    }

    private void g(Bundle bundle) {
        if (bundle.get("param") == null) {
            int i = bundle.getInt("type");
            if (i == h.ground.ordinal()) {
                bundle.putLong("layer_addr", this.I.a);
                return;
            } else if (i >= h.arc.ordinal()) {
                bundle.putLong("layer_addr", this.I.a);
                return;
            } else if (i == h.popup.ordinal()) {
                bundle.putLong("layer_addr", this.I.a);
                return;
            } else {
                bundle.putLong("layer_addr", this.I.a);
                return;
            }
        }
        Bundle bundle2 = (Bundle) bundle.get("param");
        int i2 = bundle2.getInt("type");
        if (i2 == h.ground.ordinal()) {
            bundle2.putLong("layer_addr", this.I.a);
        } else if (i2 >= h.arc.ordinal()) {
            bundle2.putLong("layer_addr", this.I.a);
        } else if (i2 == h.popup.ordinal()) {
            bundle2.putLong("layer_addr", this.I.a);
        } else {
            bundle2.putLong("layer_addr", this.I.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void l(boolean z) {
        ar = com.baidu.mapsdkplatform.comjni.map.basemap.a.b();
        if (ar == null || ar.size() == 0) {
            com.baidu.mapsdkplatform.comjni.map.basemap.a.b(0L, z);
            return;
        }
        com.baidu.mapsdkplatform.comjni.map.basemap.a.b(ar.get(0).a, z);
        for (JNIBaseMap jNIBaseMap : ar) {
            if (jNIBaseMap != null) {
                jNIBaseMap.ClearLayer(jNIBaseMap.a, -1L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A() {
        if (this.m || this.n) {
            return;
        }
        this.n = true;
        if (this.g == null) {
            return;
        }
        for (l lVar : this.g) {
            if (lVar != null) {
                lVar.a(E());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B() {
        this.n = false;
        this.m = false;
        if (this.g == null) {
            return;
        }
        for (l lVar : this.g) {
            if (lVar != null) {
                lVar.c(E());
            }
        }
    }

    public boolean C() {
        if (this.h != null) {
            return this.h.a(this.H.a);
        }
        return false;
    }

    public boolean D() {
        if (this.h != null) {
            return this.h.a(this.aq.a);
        }
        return false;
    }

    public ab E() {
        if (this.h == null) {
            return null;
        }
        Bundle h = this.h.h();
        ab abVar = new ab();
        abVar.a(h);
        return abVar;
    }

    public LatLngBounds F() {
        if (this.h == null) {
            return null;
        }
        Bundle i = this.h.i();
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        int i2 = i.getInt("maxCoorx");
        int i3 = i.getInt("minCoorx");
        builder.include(CoordUtil.mc2ll(new GeoPoint(i.getInt("minCoory"), i2))).include(CoordUtil.mc2ll(new GeoPoint(i.getInt("maxCoory"), i3)));
        return builder.build();
    }

    public int G() {
        return this.P;
    }

    public int H() {
        return this.Q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab I() {
        if (this.h == null) {
            return null;
        }
        Bundle j = this.h.j();
        ab abVar = new ab();
        abVar.a(j);
        return abVar;
    }

    public double J() {
        return E().m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K() {
        this.m = false;
        if (this.n || this.g == null) {
            return;
        }
        for (l lVar : this.g) {
            if (lVar != null) {
                lVar.c(E());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L() {
        this.R = 0;
        this.S.e = false;
        this.S.h = 0.0d;
    }

    public Queue<a> M() {
        return this.at;
    }

    public void N() {
        if (this.at.isEmpty()) {
            return;
        }
        a poll = this.at.poll();
        if (poll.e == null) {
            com.baidu.mapsdkplatform.comjni.map.basemap.a.a(poll.a, poll.b, poll.c, poll.d);
        } else if (this.h != null) {
            A();
            this.h.a(poll.e);
        }
    }

    public float a(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.j) {
            if (this.h == null) {
                return 0.0f;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("left", i);
            bundle.putInt(MarkerModel.SubBase.RIGHT, i3);
            bundle.putInt("bottom", i4);
            bundle.putInt(AiAppsNaViewModel.POSITION_KEY_TOP, i2);
            bundle.putInt("hasHW", 1);
            bundle.putInt("width", i5);
            bundle.putInt("height", i6);
            return this.h.c(bundle);
        }
        return 12.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i, int i2, int i3) {
        if (this.as) {
            this.at.add(new a(this.i, i, i2, i3));
            return 0;
        }
        return com.baidu.mapsdkplatform.comjni.map.basemap.a.a(this.i, i, i2, i3);
    }

    @Override // com.baidu.mapsdkplatform.comjni.map.basemap.b
    public int a(Bundle bundle, long j, int i, Bundle bundle2) {
        if (j == this.G.a) {
            bundle.putString("jsondata", this.G.a());
            bundle.putBundle("param", this.G.b());
            return this.G.g;
        } else if (j == this.F.a) {
            bundle.putString("jsondata", this.F.a());
            bundle.putBundle("param", this.F.b());
            return this.F.g;
        } else if (j == this.J.a) {
            bundle.putBundle("param", this.L.a(bundle2.getInt(Config.EVENT_HEAT_X), bundle2.getInt("y"), bundle2.getInt("zoom")));
            return this.J.g;
        } else if (j == this.B.a) {
            bundle.putBundle("param", this.C.a(bundle2.getInt(Config.EVENT_HEAT_X), bundle2.getInt("y"), bundle2.getInt("zoom"), this.D));
            return this.B.g;
        } else {
            return 0;
        }
    }

    public Point a(GeoPoint geoPoint) {
        return this.M.a(geoPoint);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.E = new ArrayList();
        this.am = new f();
        a(this.am);
        this.ap = new b();
        a(this.ap);
        this.J = new n();
        a(this.J);
        this.K = new com.baidu.mapsdkplatform.comapi.map.a();
        a(this.K);
        a(new p());
        this.H = new ae();
        a(this.H);
        this.aq = new c();
        a(this.aq);
        if (this.h != null) {
            this.h.e(false);
        }
        this.I = new ah();
        a(this.I);
        this.G = new g();
        a(this.G);
        this.F = new x();
        a(this.F);
    }

    public void a(float f, float f2) {
        this.a = f;
        this.c = f;
        this.b = f2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.h = new com.baidu.mapsdkplatform.comjni.map.basemap.a();
        this.h.a(i);
        this.i = this.h.a();
        a("com.baidu.platform.comapi.wnplatform.walkmap.WNaviBaiduMap", "setId", this.i);
        if (SysOSUtil.getDensityDpi() < 180) {
            this.k = 18;
        } else if (SysOSUtil.getDensityDpi() < 240) {
            this.k = 25;
        } else if (SysOSUtil.getDensityDpi() < 320) {
            this.k = 37;
        } else {
            this.k = 50;
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
        Activity a2 = a(this.D);
        if (a2 == null) {
            throw new RuntimeException("Please give the right context.");
        }
        Display defaultDisplay = a2.getWindowManager().getDefaultDisplay();
        this.h.a(str4, str7, str9, str10, str8, str5, this.an, this.ao, str6, defaultDisplay.getWidth(), defaultDisplay.getHeight(), SysOSUtil.getDensityDpi(), mapTmpStgMax, domTmpStgMax, itsTmpStgMax, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2) {
        this.P = i;
        this.Q = i2;
    }

    public void a(long j, long j2, long j3, long j4, boolean z) {
        this.h.a(j, j2, j3, j4, z);
    }

    public void a(Bitmap bitmap) {
        Bundle bundle;
        int i = 0;
        if (this.h == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("type", 0);
            jSONObject2.put(Config.EVENT_HEAT_X, N);
            jSONObject2.put("y", O);
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
        this.h.b(this.G.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Handler handler) {
        MessageCenter.registMessage(UIMsg.m_AppUI.MSG_APP_SAVESCREEN, handler);
        MessageCenter.registMessage(39, handler);
        MessageCenter.registMessage(41, handler);
        MessageCenter.registMessage(49, handler);
        MessageCenter.registMessage(UIMsg.m_AppUI.V_WM_VDATAENGINE, handler);
        MessageCenter.registMessage(50, handler);
        MessageCenter.registMessage(ErrDef.Feature.OVERFLOW, handler);
        BaseMapCallback.addLayerDataInterface(this.i, this);
    }

    public void a(LatLngBounds latLngBounds) {
        if (latLngBounds == null || this.h == null) {
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
        this.h.b(bundle);
    }

    public void a(ab abVar) {
        if (this.h == null || abVar == null) {
            return;
        }
        Bundle a2 = abVar.a(this);
        a2.putInt("animation", 0);
        a2.putInt("animatime", 0);
        this.h.a(a2);
    }

    public void a(ab abVar, int i) {
        if (this.h == null) {
            return;
        }
        Bundle a2 = abVar.a(this);
        a2.putInt("animation", 1);
        a2.putInt("animatime", i);
        if (this.as) {
            this.at.add(new a(a2));
            return;
        }
        A();
        this.h.a(a2);
    }

    public void a(ai aiVar) {
        this.C = aiVar;
    }

    public void a(l lVar) {
        if (lVar == null) {
            return;
        }
        this.g.add(lVar);
    }

    public void a(o oVar) {
        this.L = oVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(z zVar) {
        new ab();
        if (zVar == null) {
            zVar = new z();
        }
        ab abVar = zVar.a;
        this.y = zVar.f;
        this.z = zVar.d;
        this.d = zVar.e;
        this.e = zVar.g;
        this.h.a(abVar.a(this));
        this.h.c(y.DEFAULT.ordinal());
        this.u = zVar.b;
        if (zVar.b) {
            N = (int) (SysOSUtil.getDensity() * 40.0f);
            O = (int) (SysOSUtil.getDensity() * 40.0f);
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(Config.EVENT_HEAT_X, N);
                jSONObject2.put("y", O);
                jSONObject2.put("hidetime", 1000);
                jSONArray.put(jSONObject2);
                jSONObject.put("data", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.G.a(jSONObject.toString());
            this.h.a(this.G.a, true);
        } else {
            this.h.a(this.G.a, false);
        }
        int i = zVar.c;
        if (i == 2) {
            a(true);
        }
        if (i == 3) {
            this.h.a(this.am.a, false);
            this.h.a(this.aq.a, false);
            this.h.a(this.H.a, false);
            this.h.e(false);
        }
    }

    public void a(String str, Bundle bundle) {
        if (this.h == null) {
            return;
        }
        this.F.a(str);
        this.F.a(bundle);
        this.h.b(this.F.a);
    }

    public void a(List<Bundle> list) {
        if (this.h == null || list == null) {
            return;
        }
        int size = list.size();
        Bundle[] bundleArr = new Bundle[list.size()];
        for (int i = 0; i < size; i++) {
            g(list.get(i));
            bundleArr[i] = list.get(i);
        }
        this.h.a(bundleArr);
    }

    public void a(boolean z) {
        if (this.h == null) {
            return;
        }
        if (!this.h.a(this.am.a)) {
            this.h.a(this.am.a, true);
        }
        this.t = z;
        O();
        this.h.a(this.t);
    }

    public boolean a(float f, float f2, float f3, float f4) {
        float f5 = this.Q - f2;
        float f6 = this.Q - f4;
        if (this.S.e) {
            if (this.R == 0) {
                if ((this.S.c - f5 <= 0.0f || this.S.d - f6 <= 0.0f) && (this.S.c - f5 >= 0.0f || this.S.d - f6 >= 0.0f)) {
                    this.R = 2;
                } else {
                    double atan2 = Math.atan2(f6 - f5, f3 - f) - Math.atan2(this.S.d - this.S.c, this.S.b - this.S.a);
                    double sqrt = Math.sqrt(((f3 - f) * (f3 - f)) + ((f6 - f5) * (f6 - f5))) / this.S.h;
                    int log = (int) ((Math.log(sqrt) / Math.log(2.0d)) * 10000.0d);
                    int i = (int) ((atan2 * 180.0d) / 3.1416d);
                    if ((sqrt <= 0.0d || (log <= 3000 && log >= -3000)) && Math.abs(i) < 10) {
                        this.R = 1;
                    } else {
                        this.R = 2;
                    }
                }
                if (this.R == 0) {
                    return true;
                }
            }
            if (this.R == 1 && this.y) {
                if (this.S.c - f5 > 0.0f && this.S.d - f6 > 0.0f) {
                    P();
                    a(1, 83, 0);
                } else if (this.S.c - f5 < 0.0f && this.S.d - f6 < 0.0f) {
                    P();
                    a(1, 87, 0);
                }
            } else if (this.R == 2 || this.R == 4 || this.R == 3) {
                double atan22 = Math.atan2(f6 - f5, f3 - f) - Math.atan2(this.S.d - this.S.c, this.S.b - this.S.a);
                double sqrt2 = Math.sqrt(((f3 - f) * (f3 - f)) + ((f6 - f5) * (f6 - f5))) / this.S.h;
                int log2 = (int) ((Math.log(sqrt2) / Math.log(2.0d)) * 10000.0d);
                double atan23 = Math.atan2(this.S.g - this.S.c, this.S.f - this.S.a);
                double sqrt3 = Math.sqrt(((this.S.f - this.S.a) * (this.S.f - this.S.a)) + ((this.S.g - this.S.c) * (this.S.g - this.S.c)));
                float cos = (float) ((Math.cos(atan23 + atan22) * sqrt3 * sqrt2) + f);
                float sin = (float) ((Math.sin(atan23 + atan22) * sqrt3 * sqrt2) + f5);
                int i2 = (int) ((atan22 * 180.0d) / 3.1416d);
                if (sqrt2 > 0.0d && (3 == this.R || (Math.abs(log2) > 2000 && 2 == this.R))) {
                    this.R = 3;
                    float f7 = E().a;
                    if (this.e) {
                        if (sqrt2 > 1.0d) {
                            if (f7 >= this.a) {
                                return false;
                            }
                            P();
                            a(UIMsg.k_event.V_WM_ROTATE, 3, log2);
                        } else if (f7 <= this.b) {
                            return false;
                        } else {
                            P();
                            a(UIMsg.k_event.V_WM_ROTATE, 3, log2);
                        }
                    }
                } else if (i2 != 0 && (4 == this.R || (Math.abs(i2) > 10 && 2 == this.R))) {
                    this.R = 4;
                    if (this.z) {
                        BaiduMap.mapStatusReason |= 1;
                        P();
                        a(UIMsg.k_event.V_WM_ROTATE, 1, i2);
                    }
                }
                this.S.f = cos;
                this.S.g = sin;
            }
        }
        if (2 != this.R) {
            this.S.c = f5;
            this.S.d = f6;
            this.S.a = f;
            this.S.b = f3;
        }
        if (!this.S.e) {
            this.S.f = this.P / 2;
            this.S.g = this.Q / 2;
            this.S.e = true;
            if (0.0d == this.S.h) {
                this.S.h = Math.sqrt(((this.S.b - this.S.a) * (this.S.b - this.S.a)) + ((this.S.d - this.S.c) * (this.S.d - this.S.c)));
            }
        }
        return true;
    }

    @Override // com.baidu.mapsdkplatform.comjni.map.basemap.b
    public boolean a(long j) {
        Iterator<d> it = this.E.iterator();
        while (it.hasNext()) {
            if (it.next().a == j) {
                return true;
            }
        }
        return false;
    }

    public boolean a(Point point) {
        if (point != null && this.h != null && point.x >= 0 && point.y >= 0) {
            N = point.x;
            O = point.y;
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(Config.EVENT_HEAT_X, N);
                jSONObject2.put("y", O);
                jSONObject2.put("hidetime", 1000);
                jSONArray.put(jSONObject2);
                jSONObject.put("data", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.G.a(jSONObject.toString());
            this.h.b(this.G.a);
            return true;
        }
        return false;
    }

    public boolean a(Bundle bundle) {
        if (this.h == null) {
            return false;
        }
        this.B = new aj();
        long a2 = this.h.a(this.B.c, this.B.d, this.B.b);
        if (a2 != 0) {
            this.B.a = a2;
            this.E.add(this.B);
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
        float y = this.Q - motionEvent.getY(0);
        float y2 = this.Q - motionEvent.getY(1);
        float x = motionEvent.getX(0);
        float x2 = motionEvent.getX(1);
        switch (motionEvent.getAction()) {
            case 5:
                this.V = motionEvent.getEventTime();
                this.Y--;
                break;
            case 6:
                this.X = motionEvent.getEventTime();
                this.Y++;
                break;
            case 261:
                this.U = motionEvent.getEventTime();
                this.Y--;
                break;
            case 262:
                this.W = motionEvent.getEventTime();
                this.Y++;
                break;
        }
        if (this.T == null) {
            this.T = VelocityTracker.obtain();
        }
        this.T.addMovement(motionEvent);
        int minimumFlingVelocity = ViewConfiguration.getMinimumFlingVelocity();
        this.T.computeCurrentVelocity(1000, ViewConfiguration.getMaximumFlingVelocity());
        float xVelocity = this.T.getXVelocity(1);
        float yVelocity = this.T.getYVelocity(1);
        float xVelocity2 = this.T.getXVelocity(2);
        float yVelocity2 = this.T.getYVelocity(2);
        if (Math.abs(xVelocity) > minimumFlingVelocity || Math.abs(yVelocity) > minimumFlingVelocity || Math.abs(xVelocity2) > minimumFlingVelocity || Math.abs(yVelocity2) > minimumFlingVelocity) {
            if (this.S.e) {
                if (this.R == 0) {
                    if ((this.S.c - y <= 0.0f || this.S.d - y2 <= 0.0f) && (this.S.c - y >= 0.0f || this.S.d - y2 >= 0.0f)) {
                        this.R = 2;
                    } else {
                        double atan2 = Math.atan2(y2 - y, x2 - x) - Math.atan2(this.S.d - this.S.c, this.S.b - this.S.a);
                        double sqrt = Math.sqrt(((x2 - x) * (x2 - x)) + ((y2 - y) * (y2 - y))) / this.S.h;
                        int log = (int) ((Math.log(sqrt) / Math.log(2.0d)) * 10000.0d);
                        int i = (int) ((atan2 * 180.0d) / 3.1416d);
                        if ((sqrt <= 0.0d || (log <= 3000 && log >= -3000)) && Math.abs(i) < 10) {
                            this.R = 1;
                        } else {
                            this.R = 2;
                        }
                    }
                    if (this.R == 0) {
                        return true;
                    }
                }
                if (this.R == 1 && this.y) {
                    if (this.S.c - y > 0.0f && this.S.d - y2 > 0.0f) {
                        BaiduMap.mapStatusReason |= 1;
                        P();
                        a(1, 83, 0);
                    } else if (this.S.c - y < 0.0f && this.S.d - y2 < 0.0f) {
                        BaiduMap.mapStatusReason |= 1;
                        P();
                        a(1, 87, 0);
                    }
                } else if (this.R == 2 || this.R == 4 || this.R == 3) {
                    double atan22 = Math.atan2(y2 - y, x2 - x) - Math.atan2(this.S.d - this.S.c, this.S.b - this.S.a);
                    double sqrt2 = Math.sqrt(((x2 - x) * (x2 - x)) + ((y2 - y) * (y2 - y))) / this.S.h;
                    int log2 = (int) ((Math.log(sqrt2) / Math.log(2.0d)) * 10000.0d);
                    double atan23 = Math.atan2(this.S.g - this.S.c, this.S.f - this.S.a);
                    double sqrt3 = Math.sqrt(((this.S.f - this.S.a) * (this.S.f - this.S.a)) + ((this.S.g - this.S.c) * (this.S.g - this.S.c)));
                    float cos = (float) ((Math.cos(atan23 + atan22) * sqrt3 * sqrt2) + x);
                    float sin = (float) ((Math.sin(atan23 + atan22) * sqrt3 * sqrt2) + y);
                    int i2 = (int) ((atan22 * 180.0d) / 3.1416d);
                    if (sqrt2 > 0.0d && (3 == this.R || (Math.abs(log2) > 2000 && 2 == this.R))) {
                        this.R = 3;
                        float f = E().a;
                        if (this.e) {
                            if (sqrt2 > 1.0d) {
                                if (f >= this.a) {
                                    return false;
                                }
                                BaiduMap.mapStatusReason |= 1;
                                P();
                                a(UIMsg.k_event.V_WM_ROTATE, 3, log2);
                            } else if (f <= this.b) {
                                return false;
                            } else {
                                BaiduMap.mapStatusReason |= 1;
                                P();
                                a(UIMsg.k_event.V_WM_ROTATE, 3, log2);
                            }
                        }
                    } else if (i2 != 0 && (4 == this.R || (Math.abs(i2) > 10 && 2 == this.R))) {
                        this.R = 4;
                        if (this.z) {
                            P();
                            a(UIMsg.k_event.V_WM_ROTATE, 1, i2);
                        }
                    }
                    this.S.f = cos;
                    this.S.g = sin;
                }
            }
        } else if (this.R == 0 && this.Y == 0) {
            this.W = this.W > this.X ? this.W : this.X;
            this.U = this.U < this.V ? this.V : this.U;
            if (this.W - this.U < 200 && this.e && (E = E()) != null) {
                E.a -= 1.0f;
                BaiduMap.mapStatusReason |= 1;
                a(E, 300);
            }
        }
        if (2 != this.R) {
            this.S.c = y;
            this.S.d = y2;
            this.S.a = x;
            this.S.b = x2;
        }
        if (!this.S.e) {
            this.S.f = this.P / 2;
            this.S.g = this.Q / 2;
            this.S.e = true;
            if (0.0d == this.S.h) {
                this.S.h = Math.sqrt(((this.S.b - this.S.a) * (this.S.b - this.S.a)) + ((this.S.d - this.S.c) * (this.S.d - this.S.c)));
            }
        }
        return true;
    }

    public boolean a(String str, String str2) {
        return this.h.a(str, str2);
    }

    public GeoPoint b(int i, int i2) {
        return this.M.a(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(float f, float f2) {
        if (this.S.e) {
            return;
        }
        this.ad = System.currentTimeMillis();
        if (this.ad - this.ac >= 400) {
            this.ac = this.ad;
        } else if (Math.abs(f - this.Z) >= 120.0f || Math.abs(f2 - this.aa) >= 120.0f) {
            this.ac = this.ad;
        } else {
            this.ac = 0L;
            this.ae = true;
        }
        this.Z = f;
        this.aa = f2;
        a(4, 0, ((int) f) | (((int) f2) << 16));
        this.ab = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        if (this.h != null) {
            this.h.b(i);
            this.h = null;
        }
    }

    public void b(Bundle bundle) {
        if (this.h == null) {
            return;
        }
        g(bundle);
        this.h.f(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Handler handler) {
        MessageCenter.unregistMessage(UIMsg.m_AppUI.MSG_APP_SAVESCREEN, handler);
        MessageCenter.unregistMessage(41, handler);
        MessageCenter.unregistMessage(49, handler);
        MessageCenter.unregistMessage(39, handler);
        MessageCenter.unregistMessage(UIMsg.m_AppUI.V_WM_VDATAENGINE, handler);
        MessageCenter.unregistMessage(50, handler);
        MessageCenter.unregistMessage(ErrDef.Feature.OVERFLOW, handler);
        BaseMapCallback.removeLayerDataInterface(this.i);
    }

    public void b(boolean z) {
        this.A = z;
    }

    public boolean b() {
        return this.A;
    }

    public void c() {
        if (this.h == null) {
            return;
        }
        for (d dVar : this.E) {
            this.h.a(dVar.a, false);
        }
    }

    public void c(Bundle bundle) {
        if (this.h == null) {
            return;
        }
        g(bundle);
        this.h.g(bundle);
    }

    public void c(boolean z) {
        if (z) {
            this.h.a(this.I.a, this.F.a);
        } else {
            this.h.a(this.F.a, this.I.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(float f, float f2) {
        if (!this.S.e && System.currentTimeMillis() - l >= 300) {
            if (this.o) {
                if (this.g != null) {
                    for (l lVar : this.g) {
                        GeoPoint b = b((int) f, (int) f2);
                        if (lVar != null) {
                            lVar.d(b);
                        }
                    }
                }
                return true;
            }
            float abs = Math.abs(f - this.Z);
            float abs2 = Math.abs(f2 - this.aa);
            float density = (float) (((double) SysOSUtil.getDensity()) > 1.5d ? SysOSUtil.getDensity() * 1.5d : SysOSUtil.getDensity());
            if (!this.ab || abs / density > 3.0f || abs2 / density > 3.0f) {
                this.ab = false;
                int i = (int) f;
                int i2 = (int) f2;
                if (i < 0) {
                    i = 0;
                }
                if (i2 < 0) {
                    i2 = 0;
                }
                if (this.d) {
                    this.ag = this.ai;
                    this.ah = this.aj;
                    this.ai = f;
                    this.aj = f2;
                    this.ak = this.al;
                    this.al = System.currentTimeMillis();
                    this.af = true;
                    P();
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
        return i >= 0 && i <= this.P + 0 && i2 >= 0 && i2 <= this.Q + 0;
    }

    public void d() {
        if (this.h == null) {
            return;
        }
        for (d dVar : this.E) {
            if ((dVar instanceof x) || (dVar instanceof com.baidu.mapsdkplatform.comapi.map.a) || (dVar instanceof n)) {
                this.h.a(dVar.a, false);
            } else {
                this.h.a(dVar.a, true);
            }
        }
        this.h.c(false);
    }

    public void d(Bundle bundle) {
        if (this.h == null) {
            return;
        }
        g(bundle);
        this.h.h(bundle);
    }

    public void d(boolean z) {
        if (this.h == null) {
            return;
        }
        this.h.a(this.G.a, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(float f, float f2) {
        if (this.o) {
            if (this.g != null) {
                for (l lVar : this.g) {
                    GeoPoint b = b((int) f, (int) f2);
                    if (lVar != null) {
                        lVar.e(b);
                    }
                }
            }
            this.o = false;
            return true;
        }
        if (!this.S.e) {
            if (this.ae) {
                return e(f, f2);
            }
            if (this.af) {
                return Q();
            }
            if (System.currentTimeMillis() - this.ad < 400 && Math.abs(f - this.Z) < 10.0f && Math.abs(f2 - this.aa) < 10.0f) {
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
        if (this.h == null) {
            return;
        }
        this.h.a(this.B.a, z);
    }

    public boolean e() {
        if (this.B == null || this.h == null) {
            return false;
        }
        return this.h.c(this.B.a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        if (this.h == null) {
            return;
        }
        this.M = new af(this.h);
    }

    public void f(boolean z) {
        if (this.h == null) {
            return;
        }
        this.h.a(this.am.a, z);
    }

    public void g(boolean z) {
        if (this.h == null) {
            return;
        }
        this.x = z;
        this.h.b(this.x);
    }

    public boolean g() {
        return this.s;
    }

    public String h() {
        if (this.h == null) {
            return null;
        }
        return this.h.e(this.G.a);
    }

    public void h(boolean z) {
        if (this.h == null) {
            return;
        }
        this.s = z;
        this.h.c(this.s);
    }

    public void i(boolean z) {
        if (this.h == null) {
            return;
        }
        this.h.d(z);
    }

    public boolean i() {
        return this.x;
    }

    public void j(boolean z) {
        if (this.h == null) {
            return;
        }
        this.u = z;
        this.h.a(this.G.a, z);
    }

    public boolean j() {
        if (this.h == null) {
            return false;
        }
        return this.h.k();
    }

    public void k(boolean z) {
        if (z) {
            this.a = 22.0f;
            this.c = 22.0f;
        } else {
            this.a = 21.0f;
            this.c = 21.0f;
        }
        this.h.e(z);
        this.h.d(this.ap.a);
        this.h.d(this.aq.a);
    }

    public boolean k() {
        return this.t;
    }

    public boolean l() {
        return this.h.a(this.am.a);
    }

    public void m(boolean z) {
        if (this.h == null) {
            return;
        }
        this.v = z;
        this.h.a(this.F.a, z);
    }

    public boolean m() {
        if (this.h == null) {
            return false;
        }
        return this.h.o();
    }

    public void n() {
        if (this.h == null) {
            return;
        }
        this.h.d(this.I.a);
    }

    public void n(boolean z) {
        if (this.h == null) {
            return;
        }
        this.w = z;
        this.h.a(this.J.a, z);
    }

    public void o() {
        if (this.h == null) {
            return;
        }
        this.h.p();
        this.h.b(this.J.a);
    }

    public void o(boolean z) {
        this.d = z;
    }

    public MapBaseIndoorMapInfo p() {
        return this.h.q();
    }

    public void p(boolean z) {
        this.e = z;
    }

    public void q(boolean z) {
        this.f = z;
    }

    public boolean q() {
        return this.h.r();
    }

    public void r(boolean z) {
        this.z = z;
    }

    public boolean r() {
        return this.u;
    }

    public void s(boolean z) {
        this.y = z;
    }

    public boolean s() {
        return this.v;
    }

    public void t() {
        if (this.h == null) {
            return;
        }
        this.h.b(this.J.a);
    }

    public void t(boolean z) {
        if (this.h != null) {
            this.h.a(this.H.a, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u() {
        if (this.h == null) {
            return;
        }
        this.h.e();
    }

    public void u(boolean z) {
        if (this.h != null) {
            this.h.a(this.aq.a, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v() {
        if (this.h == null) {
            return;
        }
        this.h.f();
    }

    public void v(boolean z) {
        this.as = z;
    }

    public boolean w() {
        return this.d;
    }

    public boolean x() {
        return this.e;
    }

    public boolean y() {
        return this.z;
    }

    public boolean z() {
        return this.y;
    }
}
