package com.baidu.location.b;

import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Poi;
import com.baidu.location.PoiRegion;
import com.baidu.location.b.l;
import com.baidu.mobstat.Config;
import java.util.List;
/* loaded from: classes3.dex */
public class o extends l {
    private double A;
    private double B;
    public l.b e;
    private static o i = null;
    public static String f = "0";
    public static boolean h = false;
    private boolean j = true;
    private String k = null;
    private BDLocation l = null;
    private BDLocation m = null;
    private com.baidu.location.c.h n = null;
    private com.baidu.location.c.a o = null;
    private com.baidu.location.c.h p = null;
    private com.baidu.location.c.a q = null;
    private boolean r = true;
    private volatile boolean s = false;
    private boolean t = false;
    private long u = 0;
    private long v = 0;
    private Address w = null;
    private String x = null;
    private List<Poi> y = null;
    private PoiRegion z = null;
    private boolean C = false;
    private long D = 0;
    private long E = 0;
    private a F = null;
    private boolean G = false;
    private boolean H = false;
    private boolean I = true;
    public final Handler g = new l.a();
    private boolean J = false;
    private boolean K = false;
    private b L = null;
    private boolean M = false;
    private int N = 0;
    private long O = 0;
    private boolean P = false;
    private String Q = null;
    private boolean R = false;
    private boolean S = true;

    /* loaded from: classes3.dex */
    private class a implements Runnable {
        final /* synthetic */ o a;

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.G) {
                this.a.G = false;
                if (!this.a.H) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(o oVar, p pVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (o.this.M) {
                o.this.M = false;
            }
            if (o.this.t) {
                o.this.t = false;
                o.this.h(null);
            }
        }
    }

    private o() {
        this.e = null;
        this.e = new l.b();
    }

    private boolean a(com.baidu.location.c.a aVar) {
        this.b = com.baidu.location.c.b.a().f();
        if (this.b == aVar) {
            return false;
        }
        return this.b == null || aVar == null || !aVar.a(this.b);
    }

    private boolean a(com.baidu.location.c.h hVar) {
        this.a = com.baidu.location.c.i.a().o();
        if (hVar == this.a) {
            return false;
        }
        return this.a == null || hVar == null || !hVar.c(this.a);
    }

    public static synchronized o c() {
        o oVar;
        synchronized (o.class) {
            if (i == null) {
                i = new o();
            }
            oVar = i;
        }
        return oVar;
    }

    private void c(Message message) {
        if (!com.baidu.location.e.l.c(com.baidu.location.f.getServiceContext())) {
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLocType(62);
            com.baidu.location.b.b.a().a(bDLocation);
            return;
        }
        if (com.baidu.location.e.l.b()) {
            Log.d(com.baidu.location.e.a.a, "isInforbiddenTime on request location ...");
        }
        boolean z = message.getData().getBoolean("isWaitingLocTag", false);
        if (z) {
            h = true;
        }
        if (z) {
        }
        int d = com.baidu.location.b.b.a().d(message);
        switch (d) {
            case 1:
                d(message);
                return;
            case 2:
                g(message);
                return;
            case 3:
                if (com.baidu.location.c.f.a().j()) {
                    e(message);
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(d)));
        }
    }

    private void d(Message message) {
        if (com.baidu.location.c.f.a().j()) {
            e(message);
            r.a().c();
            return;
        }
        g(message);
        r.a().b();
    }

    private void d(BDLocation bDLocation) {
        if (com.baidu.location.e.l.m || bDLocation.getMockGpsStrategy() <= 0) {
            com.baidu.location.b.b.a().a(bDLocation);
        } else {
            com.baidu.location.b.b.a().c(bDLocation);
        }
    }

    private void e(Message message) {
        BDLocation bDLocation = new BDLocation(com.baidu.location.c.f.a().f());
        if (com.baidu.location.e.l.g.equals("all") || com.baidu.location.e.l.h || com.baidu.location.e.l.j) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.B, this.A, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.w != null) {
                    bDLocation.setAddr(this.w);
                }
                if (this.x != null) {
                    bDLocation.setLocationDescribe(this.x);
                }
                if (this.y != null) {
                    bDLocation.setPoiList(this.y);
                }
                if (this.z != null) {
                    bDLocation.setPoiRegion(this.z);
                }
            } else {
                this.C = true;
                g(null);
            }
        }
        this.l = bDLocation;
        this.m = null;
        d(bDLocation);
    }

    private void f(Message message) {
        if (!com.baidu.location.c.i.a().f()) {
            h(message);
            return;
        }
        this.t = true;
        if (this.L == null) {
            this.L = new b(this, null);
        }
        if (this.M && this.L != null) {
            this.g.removeCallbacks(this.L);
        }
        this.g.postDelayed(this.L, 3500L);
        this.M = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Message message) {
        this.N = 0;
        if (!this.r) {
            f(message);
            this.E = SystemClock.uptimeMillis();
            return;
        }
        this.N = 1;
        this.E = SystemClock.uptimeMillis();
        if (com.baidu.location.c.i.a().j()) {
            f(message);
        } else {
            h(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(Message message) {
        long j;
        long currentTimeMillis = System.currentTimeMillis() - this.u;
        if (!this.s || currentTimeMillis > 12000) {
            if (System.currentTimeMillis() - this.u > 0 && System.currentTimeMillis() - this.u < 1000) {
                if (this.l != null) {
                    com.baidu.location.b.b.a().a(this.l);
                }
                l();
                return;
            }
            this.s = true;
            this.j = a(this.o);
            if (!a(this.n) && !this.j && this.l != null && !this.C) {
                if (this.m != null && System.currentTimeMillis() - this.v > 30000) {
                    this.l = this.m;
                    this.m = null;
                }
                if (r.a().d()) {
                    this.l.setDirection(r.a().e());
                }
                if (this.l.getLocType() == 62) {
                    j = System.currentTimeMillis() - this.O;
                    if (j <= 0) {
                        j = 0;
                    }
                } else {
                    j = 0;
                }
                if (this.l.getLocType() == 61 || this.l.getLocType() == 161 || (this.l.getLocType() == 62 && j < 15000)) {
                    com.baidu.location.b.b.a().a(this.l);
                    l();
                    return;
                }
            }
            this.u = System.currentTimeMillis();
            String a2 = a((String) null);
            this.K = false;
            if (a2 == null) {
                this.K = true;
                this.O = System.currentTimeMillis();
                String[] strArr = new String[2];
                try {
                    strArr = k();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                if (currentTimeMillis2 - this.D > 60000) {
                    this.D = currentTimeMillis2;
                }
                String l = com.baidu.location.c.i.a().l();
                a2 = l != null ? l + b() + strArr[0] : "" + b() + strArr[0];
                if (this.b != null && this.b.h() != null) {
                    a2 = this.b.h() + a2;
                }
                String a3 = com.baidu.location.e.b.a().a(true);
                if (a3 != null) {
                    a2 = a2 + a3;
                }
            }
            if (this.k != null) {
                a2 = a2 + this.k;
                this.k = null;
            }
            this.e.a(a2, this.a != null ? this.a.f() : 0L);
            this.o = this.b;
            this.n = this.a;
            if (this.r) {
                this.r = false;
                if (!com.baidu.location.c.i.a().i() || message == null || com.baidu.location.b.b.a().e(message) < 1000) {
                }
            }
            if (this.N > 0) {
                if (this.N == 2) {
                    com.baidu.location.c.i.a().f();
                }
                this.N = 0;
            }
        }
    }

    private String[] k() {
        boolean z;
        String[] strArr = {"", "Location failed beacuse we can not get any loc information!"};
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("&apl=");
        int a2 = com.baidu.location.e.l.a(com.baidu.location.f.getServiceContext());
        if (a2 == 1) {
            strArr[1] = "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!";
        }
        stringBuffer.append(a2);
        String d = com.baidu.location.e.l.d(com.baidu.location.f.getServiceContext());
        if (d.contains("0|0|")) {
            strArr[1] = "Location failed beacuse we can not get any loc information without any location permission!";
        }
        stringBuffer.append(d);
        if (Build.VERSION.SDK_INT >= 23) {
            stringBuffer.append("&loc=");
            int b2 = com.baidu.location.e.l.b(com.baidu.location.f.getServiceContext());
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
            int b3 = com.baidu.location.e.l.b(com.baidu.location.f.getServiceContext());
            if (b3 >= 0) {
                stringBuffer.append(b3);
            }
        }
        String g = com.baidu.location.c.b.a().g();
        String g2 = com.baidu.location.c.i.a().g();
        stringBuffer.append(g2);
        stringBuffer.append(g);
        stringBuffer.append(com.baidu.location.e.l.e(com.baidu.location.f.getServiceContext()));
        if (a2 == 1) {
            c.a().a(62, 7, "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!");
        } else if (d.contains("0|0|")) {
            c.a().a(62, 4, "Location failed beacuse we can not get any loc information without any location permission!");
        } else if (z) {
            c.a().a(62, 5, "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!");
        } else if (g == null || g2 == null || !g.equals("&sim=1") || g2.equals("&wifio=1")) {
            c.a().a(62, 9, "Location failed beacuse we can not get any loc information!");
        } else {
            c.a().a(62, 6, "Location failed beacuse we can not get any loc information , you can insert a sim card or open wifi and try again!");
        }
        strArr[0] = stringBuffer.toString();
        return strArr;
    }

    private void l() {
        this.s = false;
        this.H = false;
        this.I = false;
        this.C = false;
        m();
        if (this.S) {
            this.S = false;
        }
    }

    private void m() {
        if (this.l == null || !com.baidu.location.c.i.a().i()) {
            return;
        }
        ac.a().d();
    }

    public Address a(BDLocation bDLocation) {
        if (com.baidu.location.e.l.g.equals("all") || com.baidu.location.e.l.h || com.baidu.location.e.l.j) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.B, this.A, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] >= 100.0d) {
                this.x = null;
                this.y = null;
                this.z = null;
                this.C = true;
                this.g.post(new p(this));
            } else if (this.w != null) {
                return this.w;
            }
        }
        return null;
    }

    @Override // com.baidu.location.b.l
    public void a() {
        if (this.F != null && this.G) {
            this.G = false;
            this.g.removeCallbacks(this.F);
        }
        if (!com.baidu.location.c.f.a().j()) {
            if (this.H) {
                l();
                return;
            }
            if (this.j || this.l == null) {
                BDLocation bDLocation = new BDLocation();
                bDLocation.setLocType(63);
                this.l = null;
                com.baidu.location.b.b.a().a(bDLocation);
            } else {
                com.baidu.location.b.b.a().a(this.l);
            }
            this.m = null;
            l();
            return;
        }
        BDLocation bDLocation2 = new BDLocation(com.baidu.location.c.f.a().f());
        if (com.baidu.location.e.l.g.equals("all") || com.baidu.location.e.l.h || com.baidu.location.e.l.j) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.B, this.A, bDLocation2.getLatitude(), bDLocation2.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.w != null) {
                    bDLocation2.setAddr(this.w);
                }
                if (this.x != null) {
                    bDLocation2.setLocationDescribe(this.x);
                }
                if (this.y != null) {
                    bDLocation2.setPoiList(this.y);
                }
                if (this.z != null) {
                    bDLocation2.setPoiRegion(this.z);
                }
            }
        }
        com.baidu.location.b.b.a().a(bDLocation2);
        l();
    }

    @Override // com.baidu.location.b.l
    public void a(Message message) {
        if (this.F != null && this.G) {
            this.G = false;
            this.g.removeCallbacks(this.F);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        if (bDLocation != null && bDLocation.getLocType() == 167 && this.K) {
            bDLocation.setLocType(62);
        }
        b(bDLocation);
    }

    public void b(Message message) {
        if (this.J) {
            c(message);
        }
    }

    public void b(BDLocation bDLocation) {
        String g;
        int b2;
        boolean z = true;
        new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            this.w = bDLocation.getAddress();
            if (this.w != null && this.w.cityCode != null) {
                f = this.w.cityCode;
            }
            this.A = bDLocation.getLongitude();
            this.B = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.x = bDLocation.getLocationDescribe();
            this.A = bDLocation.getLongitude();
            this.B = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.y = bDLocation.getPoiList();
            this.A = bDLocation.getLongitude();
            this.B = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiRegion() != null) {
            this.z = bDLocation.getPoiRegion();
            this.A = bDLocation.getLongitude();
            this.B = bDLocation.getLatitude();
        }
        if (com.baidu.location.c.f.a().j()) {
            BDLocation bDLocation2 = new BDLocation(com.baidu.location.c.f.a().f());
            if (com.baidu.location.e.l.g.equals("all") || com.baidu.location.e.l.h || com.baidu.location.e.l.j) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.B, this.A, bDLocation2.getLatitude(), bDLocation2.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.w != null) {
                        bDLocation2.setAddr(this.w);
                    }
                    if (this.x != null) {
                        bDLocation2.setLocationDescribe(this.x);
                    }
                    if (this.y != null) {
                        bDLocation2.setPoiList(this.y);
                    }
                    if (this.z != null) {
                        bDLocation2.setPoiRegion(this.z);
                    }
                }
            }
            d(bDLocation2);
            l();
        } else if (this.H) {
            float[] fArr2 = new float[2];
            if (this.l != null) {
                Location.distanceBetween(this.l.getLatitude(), this.l.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
            }
            if (fArr2[0] > 10.0f) {
                this.l = bDLocation;
                if (!this.I) {
                    this.I = false;
                    com.baidu.location.b.b.a().a(bDLocation);
                }
            } else if (bDLocation.getUserIndoorState() > -1) {
                this.l = bDLocation;
                com.baidu.location.b.b.a().a(bDLocation);
            }
            l();
        } else {
            if (bDLocation.getLocType() == 167) {
                c.a().a(167, 8, "NetWork location failed because baidu location service can not caculate the location!");
            } else if (bDLocation.getLocType() == 161) {
                if (Build.VERSION.SDK_INT >= 19 && ((b2 = com.baidu.location.e.l.b(com.baidu.location.f.getServiceContext())) == 0 || b2 == 2)) {
                    c.a().a(161, 1, "NetWork location successful, open gps will be better!");
                } else if (bDLocation.getRadius() >= 100.0f && bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals(Config.CELL_LOCATION) && (g = com.baidu.location.c.i.a().g()) != null && !g.equals("&wifio=1")) {
                    c.a().a(161, 2, "NetWork location successful, open wifi will be better!");
                }
            }
            this.m = null;
            if (bDLocation.getLocType() == 161 && Config.CELL_LOCATION.equals(bDLocation.getNetworkLocationType()) && this.l != null && this.l.getLocType() == 161 && "wf".equals(this.l.getNetworkLocationType()) && System.currentTimeMillis() - this.v < 30000) {
                this.m = bDLocation;
            } else {
                z = false;
            }
            if (z) {
                com.baidu.location.b.b.a().a(this.l);
            } else {
                com.baidu.location.b.b.a().a(bDLocation);
                this.v = System.currentTimeMillis();
            }
            if (!com.baidu.location.e.l.a(bDLocation)) {
                this.l = null;
            } else if (!z) {
                this.l = bDLocation;
            }
            int a2 = com.baidu.location.e.l.a(c, "ssid\":\"", "\"");
            if (a2 == Integer.MIN_VALUE || this.n == null) {
                this.k = null;
            } else {
                this.k = this.n.b(a2);
            }
            if (com.baidu.location.c.i.a().i()) {
            }
            l();
        }
    }

    public void c(BDLocation bDLocation) {
        this.l = new BDLocation(bDLocation);
    }

    public void d() {
        this.r = true;
        this.s = false;
        this.J = true;
    }

    public void e() {
        this.s = false;
        this.t = false;
        this.H = false;
        this.I = true;
        j();
        this.J = false;
    }

    public String f() {
        return this.x;
    }

    public List<Poi> g() {
        return this.y;
    }

    public PoiRegion h() {
        return this.z;
    }

    public void i() {
        if (this.t) {
            h(null);
            this.t = false;
        }
    }

    public void j() {
        this.l = null;
    }
}
