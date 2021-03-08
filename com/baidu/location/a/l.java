package com.baidu.location.a;

import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Poi;
import com.baidu.location.a.i;
import com.baidu.mobstat.Config;
import com.kwad.sdk.collector.AppStatusRules;
import java.util.List;
/* loaded from: classes4.dex */
public class l extends i {
    public i.b e;
    private double y;
    private double z;
    private static l h = null;
    public static boolean g = false;
    private boolean i = true;
    private String j = null;
    private BDLocation k = null;
    private BDLocation l = null;
    private com.baidu.location.b.h m = null;
    private com.baidu.location.b.a n = null;
    private com.baidu.location.b.h o = null;
    private com.baidu.location.b.a p = null;
    private boolean q = true;
    private volatile boolean r = false;
    private boolean s = false;
    private long t = 0;
    private long u = 0;
    private Address v = null;
    private String w = null;
    private List<Poi> x = null;
    private boolean A = false;
    private long B = 0;
    private long C = 0;
    private a D = null;
    private boolean E = false;
    private boolean F = false;
    private boolean G = true;
    public final Handler f = new i.a();
    private boolean H = false;
    private boolean I = false;
    private b J = null;
    private boolean K = false;
    private int L = 0;
    private long M = 0;
    private boolean N = true;

    /* loaded from: classes4.dex */
    private class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f1927a;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1927a.E) {
                this.f1927a.E = false;
                if (!this.f1927a.F) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(l lVar, m mVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.K) {
                l.this.K = false;
            }
            if (l.this.s) {
                l.this.s = false;
                l.this.h(null);
            }
        }
    }

    private l() {
        this.e = null;
        this.e = new i.b();
    }

    private boolean a(com.baidu.location.b.a aVar) {
        this.b = com.baidu.location.b.b.a().f();
        if (this.b == aVar) {
            return false;
        }
        return this.b == null || aVar == null || !aVar.a(this.b);
    }

    private boolean a(com.baidu.location.b.h hVar) {
        this.f1916a = com.baidu.location.b.i.a().o();
        if (hVar == this.f1916a) {
            return false;
        }
        return this.f1916a == null || hVar == null || !hVar.c(this.f1916a);
    }

    public static synchronized l c() {
        l lVar;
        synchronized (l.class) {
            if (h == null) {
                h = new l();
            }
            lVar = h;
        }
        return lVar;
    }

    private void c(Message message) {
        boolean z = message.getData().getBoolean("isWaitingLocTag", false);
        if (z) {
            g = true;
        }
        if (z) {
        }
        int d = com.baidu.location.a.a.a().d(message);
        switch (d) {
            case 1:
                d(message);
                return;
            case 2:
                g(message);
                return;
            case 3:
                if (com.baidu.location.b.e.a().i()) {
                    e(message);
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(d)));
        }
    }

    private void d(Message message) {
        if (com.baidu.location.b.e.a().i()) {
            e(message);
            o.a().c();
            return;
        }
        g(message);
        o.a().b();
    }

    private void e(Message message) {
        BDLocation bDLocation = new BDLocation(com.baidu.location.b.e.a().f());
        if (com.baidu.location.d.j.g.equals("all") || com.baidu.location.d.j.h || com.baidu.location.d.j.j) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.z, this.y, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.v != null) {
                    bDLocation.setAddr(this.v);
                }
                if (this.w != null) {
                    bDLocation.setLocationDescribe(this.w);
                }
                if (this.x != null) {
                    bDLocation.setPoiList(this.x);
                }
            } else {
                this.A = true;
                g(null);
            }
        }
        this.k = bDLocation;
        this.l = null;
        com.baidu.location.a.a.a().a(bDLocation);
    }

    private void f(Message message) {
        if (!com.baidu.location.b.i.a().f()) {
            h(message);
            return;
        }
        this.s = true;
        if (this.J == null) {
            this.J = new b(this, null);
        }
        if (this.K && this.J != null) {
            this.f.removeCallbacks(this.J);
        }
        this.f.postDelayed(this.J, 3500L);
        this.K = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Message message) {
        this.L = 0;
        if (!this.q) {
            f(message);
            this.C = SystemClock.uptimeMillis();
            return;
        }
        this.L = 1;
        this.C = SystemClock.uptimeMillis();
        if (com.baidu.location.b.i.a().j()) {
            f(message);
        } else {
            h(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Message message) {
        long j = 0;
        long currentTimeMillis = System.currentTimeMillis() - this.t;
        if (!this.r || currentTimeMillis > 12000) {
            if (System.currentTimeMillis() - this.t > 0 && System.currentTimeMillis() - this.t < 1000) {
                if (this.k != null) {
                    com.baidu.location.a.a.a().a(this.k);
                }
                k();
                return;
            }
            this.r = true;
            this.i = a(this.n);
            if (!a(this.m) && !this.i && this.k != null && !this.A) {
                if (this.l != null && System.currentTimeMillis() - this.u > 30000) {
                    this.k = this.l;
                    this.l = null;
                }
                if (o.a().d()) {
                    this.k.setDirection(o.a().e());
                }
                if (this.k.getLocType() == 62) {
                    long currentTimeMillis2 = System.currentTimeMillis() - this.M;
                    if (currentTimeMillis2 > 0) {
                        j = currentTimeMillis2;
                    }
                }
                if (this.k.getLocType() == 61 || this.k.getLocType() == 161 || (this.k.getLocType() == 62 && j < 15000)) {
                    com.baidu.location.a.a.a().a(this.k);
                    k();
                    return;
                }
            }
            this.t = System.currentTimeMillis();
            String a2 = a((String) null);
            this.I = false;
            if (a2 == null) {
                this.I = true;
                this.M = System.currentTimeMillis();
                String[] j2 = j();
                long currentTimeMillis3 = System.currentTimeMillis();
                if (currentTimeMillis3 - this.B > AppStatusRules.DEFAULT_GRANULARITY) {
                    this.B = currentTimeMillis3;
                }
                String l = com.baidu.location.b.i.a().l();
                a2 = l != null ? l + b() + j2[0] : "" + b() + j2[0];
                if (this.b != null && this.b.g() != null) {
                    a2 = this.b.g() + a2;
                }
                String a3 = com.baidu.location.d.b.a().a(true);
                if (a3 != null) {
                    a2 = a2 + a3;
                }
            }
            if (this.j != null) {
                a2 = a2 + this.j;
                this.j = null;
            }
            this.e.a(a2);
            this.n = this.b;
            this.m = this.f1916a;
            if (this.q) {
                this.q = false;
                if (!com.baidu.location.b.i.i() || message == null || com.baidu.location.a.a.a().e(message) < 1000) {
                }
            }
            if (this.L > 0) {
                if (this.L == 2) {
                    com.baidu.location.b.i.a().f();
                }
                this.L = 0;
            }
        }
    }

    private String[] j() {
        boolean z;
        String[] strArr = {"", "Location failed beacuse we can not get any loc information!"};
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("&apl=");
        int a2 = com.baidu.location.d.j.a(com.baidu.location.f.getServiceContext());
        if (a2 == 1) {
            strArr[1] = "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!";
        }
        stringBuffer.append(a2);
        String c = com.baidu.location.d.j.c(com.baidu.location.f.getServiceContext());
        if (c.contains("0|0|")) {
            strArr[1] = "Location failed beacuse we can not get any loc information without any location permission!";
        }
        stringBuffer.append(c);
        if (Build.VERSION.SDK_INT >= 23) {
            stringBuffer.append("&loc=");
            int b2 = com.baidu.location.d.j.b(com.baidu.location.f.getServiceContext());
            if (b2 == 0) {
                strArr[1] = "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!";
                z = true;
            } else {
                z = false;
            }
            stringBuffer.append(b2);
        } else {
            z = false;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            stringBuffer.append("&lmd=");
            int b3 = com.baidu.location.d.j.b(com.baidu.location.f.getServiceContext());
            if (b3 >= 0) {
                stringBuffer.append(b3);
            }
        }
        String g2 = com.baidu.location.b.b.a().g();
        String g3 = com.baidu.location.b.i.a().g();
        stringBuffer.append(g3);
        stringBuffer.append(g2);
        stringBuffer.append(com.baidu.location.d.j.d(com.baidu.location.f.getServiceContext()));
        if (a2 == 1) {
            com.baidu.location.a.b.a().a(62, 7, "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!");
        } else if (c.contains("0|0|")) {
            com.baidu.location.a.b.a().a(62, 4, "Location failed beacuse we can not get any loc information without any location permission!");
        } else if (z) {
            com.baidu.location.a.b.a().a(62, 5, "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!");
        } else if (g2 == null || g3 == null || !g2.equals("&sim=1") || g3.equals("&wifio=1")) {
            com.baidu.location.a.b.a().a(62, 9, "Location failed beacuse we can not get any loc information!");
        } else {
            com.baidu.location.a.b.a().a(62, 6, "Location failed beacuse we can not get any loc information , you can insert a sim card or open wifi and try again!");
        }
        strArr[0] = stringBuffer.toString();
        return strArr;
    }

    private void k() {
        this.r = false;
        this.F = false;
        this.G = false;
        this.A = false;
        l();
        if (this.N) {
            this.N = false;
        }
    }

    private void l() {
        if (this.k == null || !com.baidu.location.b.i.i()) {
            return;
        }
        x.a().d();
    }

    public Address a(BDLocation bDLocation) {
        if (com.baidu.location.d.j.g.equals("all") || com.baidu.location.d.j.h || com.baidu.location.d.j.j) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.z, this.y, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] >= 100.0f) {
                this.w = null;
                this.x = null;
                this.A = true;
                this.f.post(new m(this));
            } else if (this.v != null) {
                return this.v;
            }
        }
        return null;
    }

    @Override // com.baidu.location.a.i
    public void a() {
        if (this.D != null && this.E) {
            this.E = false;
            this.f.removeCallbacks(this.D);
        }
        if (!com.baidu.location.b.e.a().i()) {
            if (this.F) {
                k();
                return;
            }
            if (this.i || this.k == null) {
                BDLocation bDLocation = new BDLocation();
                bDLocation.setLocType(63);
                this.k = null;
                com.baidu.location.a.a.a().a(bDLocation);
            } else {
                com.baidu.location.a.a.a().a(this.k);
            }
            this.l = null;
            k();
            return;
        }
        BDLocation bDLocation2 = new BDLocation(com.baidu.location.b.e.a().f());
        if (com.baidu.location.d.j.g.equals("all") || com.baidu.location.d.j.h || com.baidu.location.d.j.j) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.z, this.y, bDLocation2.getLatitude(), bDLocation2.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.v != null) {
                    bDLocation2.setAddr(this.v);
                }
                if (this.w != null) {
                    bDLocation2.setLocationDescribe(this.w);
                }
                if (this.x != null) {
                    bDLocation2.setPoiList(this.x);
                }
            }
        }
        com.baidu.location.a.a.a().a(bDLocation2);
        k();
    }

    @Override // com.baidu.location.a.i
    public void a(Message message) {
        if (this.D != null && this.E) {
            this.E = false;
            this.f.removeCallbacks(this.D);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        if (bDLocation != null && bDLocation.getLocType() == 167 && this.I) {
            bDLocation.setLocType(62);
        }
        b(bDLocation);
    }

    public void b(Message message) {
        if (this.H) {
            c(message);
        }
    }

    public void b(BDLocation bDLocation) {
        String g2;
        int b2;
        boolean z = true;
        new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            this.v = bDLocation.getAddress();
            this.y = bDLocation.getLongitude();
            this.z = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.w = bDLocation.getLocationDescribe();
            this.y = bDLocation.getLongitude();
            this.z = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.x = bDLocation.getPoiList();
            this.y = bDLocation.getLongitude();
            this.z = bDLocation.getLatitude();
        }
        if (com.baidu.location.b.e.a().i()) {
            BDLocation bDLocation2 = new BDLocation(com.baidu.location.b.e.a().f());
            if (com.baidu.location.d.j.g.equals("all") || com.baidu.location.d.j.h || com.baidu.location.d.j.j) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.z, this.y, bDLocation2.getLatitude(), bDLocation2.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.v != null) {
                        bDLocation2.setAddr(this.v);
                    }
                    if (this.w != null) {
                        bDLocation2.setLocationDescribe(this.w);
                    }
                    if (this.x != null) {
                        bDLocation2.setPoiList(this.x);
                    }
                }
            }
            com.baidu.location.a.a.a().a(bDLocation2);
            k();
        } else if (this.F) {
            float[] fArr2 = new float[2];
            if (this.k != null) {
                Location.distanceBetween(this.k.getLatitude(), this.k.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
            }
            if (fArr2[0] > 10.0f) {
                this.k = bDLocation;
                if (!this.G) {
                    this.G = false;
                    com.baidu.location.a.a.a().a(bDLocation);
                }
            } else if (bDLocation.getUserIndoorState() > -1) {
                this.k = bDLocation;
                com.baidu.location.a.a.a().a(bDLocation);
            }
            k();
        } else {
            if (bDLocation.getLocType() == 167) {
                com.baidu.location.a.b.a().a(167, 8, "NetWork location failed because baidu location service can not caculate the location!");
            } else if (bDLocation.getLocType() == 161) {
                if (Build.VERSION.SDK_INT >= 19 && ((b2 = com.baidu.location.d.j.b(com.baidu.location.f.getServiceContext())) == 0 || b2 == 2)) {
                    com.baidu.location.a.b.a().a(161, 1, "NetWork location successful, open gps will be better!");
                } else if (bDLocation.getRadius() >= 100.0f && bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals(Config.CELL_LOCATION) && (g2 = com.baidu.location.b.i.a().g()) != null && !g2.equals("&wifio=1")) {
                    com.baidu.location.a.b.a().a(161, 2, "NetWork location successful, open wifi will be better!");
                }
            }
            this.l = null;
            if (bDLocation.getLocType() == 161 && Config.CELL_LOCATION.equals(bDLocation.getNetworkLocationType()) && this.k != null && this.k.getLocType() == 161 && "wf".equals(this.k.getNetworkLocationType()) && System.currentTimeMillis() - this.u < 30000) {
                this.l = bDLocation;
            } else {
                z = false;
            }
            if (z) {
                com.baidu.location.a.a.a().a(this.k);
            } else {
                com.baidu.location.a.a.a().a(bDLocation);
                this.u = System.currentTimeMillis();
            }
            if (!com.baidu.location.d.j.a(bDLocation)) {
                this.k = null;
            } else if (!z) {
                this.k = bDLocation;
            }
            int a2 = com.baidu.location.d.j.a(c, "ssid\":\"", "\"");
            if (a2 == Integer.MIN_VALUE || this.m == null) {
                this.j = null;
            } else {
                this.j = this.m.c(a2);
            }
            if (com.baidu.location.b.i.i()) {
            }
            k();
        }
    }

    public void c(BDLocation bDLocation) {
        this.k = new BDLocation(bDLocation);
    }

    public void d() {
        this.q = true;
        this.r = false;
        this.H = true;
    }

    public void e() {
        this.r = false;
        this.s = false;
        this.F = false;
        this.G = true;
        i();
        this.H = false;
    }

    public String f() {
        return this.w;
    }

    public List<Poi> g() {
        return this.x;
    }

    public void h() {
        if (this.s) {
            h(null);
            this.s = false;
        }
    }

    public void i() {
        this.k = null;
    }
}
