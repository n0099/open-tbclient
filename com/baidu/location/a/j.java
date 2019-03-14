package com.baidu.location.a;

import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Poi;
import com.baidu.location.a.h;
import com.baidu.location.d.d;
import com.baidu.mobstat.Config;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.util.List;
/* loaded from: classes3.dex */
public class j extends h {
    public h.b e;
    private double y;
    private double z;
    private static j h = null;
    public static boolean g = false;
    private boolean i = true;
    private String j = null;
    private BDLocation k = null;
    private BDLocation l = null;
    private com.baidu.location.e.e m = null;
    private com.baidu.location.e.a n = null;
    private com.baidu.location.e.e o = null;
    private com.baidu.location.e.a p = null;
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
    public final Handler f = new h.a();
    private boolean H = false;
    private boolean I = false;
    private b J = null;
    private boolean K = false;
    private int L = 0;
    private long M = 0;
    private boolean N = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j.this.E) {
                j.this.E = false;
                if (j.this.F || com.baidu.location.e.d.a().i()) {
                    return;
                }
                j.this.a(false, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j.this.K) {
                j.this.K = false;
            }
            if (j.this.s) {
                j.this.s = false;
                j.this.h(null);
            }
        }
    }

    private j() {
        this.e = null;
        this.e = new h.b();
    }

    private boolean a(com.baidu.location.e.a aVar) {
        this.b = com.baidu.location.e.b.a().f();
        if (this.b == aVar) {
            return false;
        }
        return this.b == null || aVar == null || !aVar.a(this.b);
    }

    private boolean a(com.baidu.location.e.e eVar) {
        this.a = com.baidu.location.e.f.a().p();
        if (eVar == this.a) {
            return false;
        }
        return this.a == null || eVar == null || !eVar.c(this.a);
    }

    private boolean b(com.baidu.location.e.a aVar) {
        if (aVar == null) {
            return false;
        }
        return this.p == null || !aVar.a(this.p);
    }

    public static synchronized j c() {
        j jVar;
        synchronized (j.class) {
            if (h == null) {
                h = new j();
            }
            jVar = h;
        }
        return jVar;
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
                if (com.baidu.location.e.d.a().i()) {
                    e(message);
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(d)));
        }
    }

    private void d(Message message) {
        if (com.baidu.location.e.d.a().i()) {
            e(message);
            l.a().c();
            return;
        }
        g(message);
        l.a().b();
    }

    private void e(Message message) {
        BDLocation bDLocation = new BDLocation(com.baidu.location.e.d.a().f());
        if (com.baidu.location.g.g.g.equals("all") || com.baidu.location.g.g.h || com.baidu.location.g.g.j) {
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
        if (!com.baidu.location.e.f.a().g()) {
            h(message);
            return;
        }
        this.s = true;
        if (this.J == null) {
            this.J = new b();
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
        if (com.baidu.location.e.f.a().k()) {
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
                m();
                return;
            }
            this.r = true;
            this.i = a(this.n);
            if (!a(this.m) && !this.i && this.k != null && !this.A) {
                if (this.l != null && System.currentTimeMillis() - this.u > StatisticConfig.MIN_UPLOAD_INTERVAL) {
                    this.k = this.l;
                    this.l = null;
                }
                if (l.a().d()) {
                    this.k.setDirection(l.a().e());
                }
                if (this.k.getLocType() == 62) {
                    long currentTimeMillis2 = System.currentTimeMillis() - this.M;
                    if (currentTimeMillis2 > 0) {
                        j = currentTimeMillis2;
                    }
                }
                if (this.k.getLocType() == 61 || this.k.getLocType() == 161 || (this.k.getLocType() == 62 && j < 15000)) {
                    com.baidu.location.a.a.a().a(this.k);
                    m();
                    return;
                }
            }
            this.t = System.currentTimeMillis();
            String a2 = a((String) null);
            this.I = false;
            if (a2 == null) {
                this.I = true;
                this.M = System.currentTimeMillis();
                String[] l = l();
                long currentTimeMillis3 = System.currentTimeMillis();
                if (currentTimeMillis3 - this.B > 60000) {
                    this.B = currentTimeMillis3;
                }
                String m = com.baidu.location.e.f.a().m();
                a2 = m != null ? m + b() + l[0] : "" + b() + l[0];
                if (this.b != null && this.b.h() != null) {
                    a2 = this.b.h() + a2;
                }
                String a3 = com.baidu.location.g.b.a().a(true);
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
            this.m = this.a;
            if (!com.baidu.location.e.d.a().i()) {
                k();
            }
            if (com.baidu.location.d.d.a().h()) {
                if (this.D == null) {
                    this.D = new a();
                }
                this.f.postDelayed(this.D, com.baidu.location.d.d.a().a(com.baidu.location.e.c.a(com.baidu.location.e.b.a().e())));
                this.E = true;
            }
            if (this.q) {
                this.q = false;
                com.baidu.location.b.b.a().b();
            }
            if (this.L > 0) {
                if (this.L == 2) {
                    com.baidu.location.e.f.a().g();
                }
                this.L = 0;
            }
        }
    }

    private boolean k() {
        boolean z;
        BDLocation bDLocation = null;
        double random = Math.random();
        SystemClock.uptimeMillis();
        com.baidu.location.e.a f = com.baidu.location.e.b.a().f();
        com.baidu.location.e.e o = com.baidu.location.e.f.a().o();
        long f2 = (o == null || o.a() <= 0) ? 0L : o.f();
        boolean z2 = f != null && f.e() && (o == null || o.a() == 0);
        if (com.baidu.location.d.d.a().d() && com.baidu.location.d.d.a().f() && f2 < 60 && (z2 || (0.0d < random && random < com.baidu.location.d.d.a().o()))) {
            BDLocation a2 = com.baidu.location.d.d.a().a(com.baidu.location.e.b.a().f(), com.baidu.location.e.f.a().o(), null, d.b.IS_MIX_MODE, d.a.NEED_TO_LOG);
            if (a2 == null) {
                z = false;
            } else {
                z = (com.baidu.location.g.g.g.equals("all") && a2.getAddrStr() == null) ? false : true;
                if (com.baidu.location.g.g.h && a2.getLocationDescribe() == null) {
                    z = false;
                }
                if (com.baidu.location.g.g.j && a2.getPoiList() == null) {
                    z = false;
                }
            }
            if (z) {
                bDLocation = a2;
            }
        }
        if (bDLocation != null && bDLocation.getLocType() == 66 && this.r) {
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            bDLocation2.setLocType(BDLocation.TypeNetWorkLocation);
            if (this.r) {
                this.F = true;
                com.baidu.location.a.a.a().a(bDLocation2);
                this.k = bDLocation2;
                return true;
            }
            return false;
        }
        return false;
    }

    private String[] l() {
        boolean z;
        String[] strArr = {"", "Location failed beacuse we can not get any loc information!"};
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("&apl=");
        int b2 = com.baidu.location.g.g.b(com.baidu.location.f.getServiceContext());
        if (b2 == 1) {
            strArr[1] = "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!";
        }
        stringBuffer.append(b2);
        String d = com.baidu.location.g.g.d(com.baidu.location.f.getServiceContext());
        if (d.contains("0|0|")) {
            strArr[1] = "Location failed beacuse we can not get any loc information without any location permission!";
        }
        stringBuffer.append(d);
        if (Build.VERSION.SDK_INT >= 23) {
            stringBuffer.append("&loc=");
            int c = com.baidu.location.g.g.c(com.baidu.location.f.getServiceContext());
            if (c == 0) {
                strArr[1] = "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!";
                z = true;
            } else {
                z = false;
            }
            stringBuffer.append(c);
        } else {
            z = false;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            stringBuffer.append("&lmd=");
            int c2 = com.baidu.location.g.g.c(com.baidu.location.f.getServiceContext());
            if (c2 >= 0) {
                stringBuffer.append(c2);
            }
        }
        String g2 = com.baidu.location.e.b.a().g();
        String h2 = com.baidu.location.e.f.a().h();
        stringBuffer.append(h2);
        stringBuffer.append(g2);
        stringBuffer.append(com.baidu.location.g.g.e(com.baidu.location.f.getServiceContext()));
        if (b2 == 1) {
            com.baidu.location.a.b.a().a(62, 7, "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!");
        } else if (d.contains("0|0|")) {
            com.baidu.location.a.b.a().a(62, 4, "Location failed beacuse we can not get any loc information without any location permission!");
        } else if (z) {
            com.baidu.location.a.b.a().a(62, 5, "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!");
        } else if (g2 == null || h2 == null || !g2.equals("&sim=1") || h2.equals("&wifio=1")) {
            com.baidu.location.a.b.a().a(62, 9, "Location failed beacuse we can not get any loc information!");
        } else {
            com.baidu.location.a.b.a().a(62, 6, "Location failed beacuse we can not get any loc information , you can insert a sim card or open wifi and try again!");
        }
        strArr[0] = stringBuffer.toString();
        return strArr;
    }

    private void m() {
        this.r = false;
        this.F = false;
        this.G = false;
        this.A = false;
        n();
        if (this.N) {
            this.N = false;
        }
    }

    private void n() {
        if (this.k == null || !com.baidu.location.e.f.j()) {
            return;
        }
        q.a().d();
    }

    public Address a(BDLocation bDLocation) {
        if (com.baidu.location.g.g.g.equals("all") || com.baidu.location.g.g.h || com.baidu.location.g.g.j) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.z, this.y, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] >= 100.0f) {
                this.w = null;
                this.x = null;
                this.A = true;
                this.f.post(new Runnable() { // from class: com.baidu.location.a.j.1
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.g(null);
                    }
                });
            } else if (this.v != null) {
                return this.v;
            }
        }
        return null;
    }

    @Override // com.baidu.location.a.h
    public void a() {
        BDLocation bDLocation;
        BDLocation bDLocation2;
        if (this.D != null && this.E) {
            this.E = false;
            this.f.removeCallbacks(this.D);
        }
        if (com.baidu.location.e.d.a().i()) {
            BDLocation bDLocation3 = new BDLocation(com.baidu.location.e.d.a().f());
            if (com.baidu.location.g.g.g.equals("all") || com.baidu.location.g.g.h || com.baidu.location.g.g.j) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.z, this.y, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.v != null) {
                        bDLocation3.setAddr(this.v);
                    }
                    if (this.w != null) {
                        bDLocation3.setLocationDescribe(this.w);
                    }
                    if (this.x != null) {
                        bDLocation3.setPoiList(this.x);
                    }
                }
            }
            com.baidu.location.a.a.a().a(bDLocation3);
            m();
        } else if (this.F) {
            m();
        } else {
            if (com.baidu.location.d.d.a().d() && com.baidu.location.d.d.a().e()) {
                bDLocation = com.baidu.location.d.d.a().a(com.baidu.location.e.b.a().f(), com.baidu.location.e.f.a().o(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
                if (bDLocation != null && bDLocation.getLocType() == 66) {
                    com.baidu.location.a.a.a().a(bDLocation);
                }
            } else {
                bDLocation = null;
            }
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                if (this.i || this.k == null) {
                    if (com.baidu.location.d.a.a().a) {
                        bDLocation2 = com.baidu.location.d.a.a().a(false);
                    } else if (bDLocation == null) {
                        BDLocation bDLocation4 = new BDLocation();
                        bDLocation4.setLocType(67);
                        bDLocation2 = bDLocation4;
                    } else {
                        bDLocation2 = bDLocation;
                    }
                    if (bDLocation2 != null) {
                        com.baidu.location.a.a.a().a(bDLocation2);
                        if (bDLocation2.getLocType() == 67 && !this.I) {
                            com.baidu.location.a.b.a().a(67, 3, "Offline location failed, please check the net (wifi/cell)!");
                        }
                        boolean z = true;
                        if (com.baidu.location.g.g.g.equals("all") && bDLocation2.getAddrStr() == null) {
                            z = false;
                        }
                        if (com.baidu.location.g.g.h && bDLocation2.getLocationDescribe() == null) {
                            z = false;
                        }
                        if (com.baidu.location.g.g.j && bDLocation2.getPoiList() == null) {
                            z = false;
                        }
                        if (!z) {
                            bDLocation2.setLocType(67);
                        }
                    }
                } else {
                    com.baidu.location.a.a.a().a(this.k);
                }
            }
            this.l = null;
            m();
        }
    }

    @Override // com.baidu.location.a.h
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

    public void a(boolean z, boolean z2) {
        BDLocation bDLocation = null;
        if (com.baidu.location.d.d.a().d() && com.baidu.location.d.d.a().g()) {
            bDLocation = com.baidu.location.d.d.a().a(com.baidu.location.e.b.a().f(), com.baidu.location.e.f.a().o(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
            if ((bDLocation == null || bDLocation.getLocType() == 67) && z && com.baidu.location.d.a.a().a) {
                bDLocation = com.baidu.location.d.a.a().a(false);
            }
        } else if (z && com.baidu.location.d.a.a().a) {
            bDLocation = com.baidu.location.d.a.a().a(false);
        }
        if (bDLocation == null || bDLocation.getLocType() != 66) {
            return;
        }
        boolean z3 = true;
        if (com.baidu.location.g.g.g.equals("all") && bDLocation.getAddrStr() == null) {
            z3 = false;
        }
        if (com.baidu.location.g.g.h && bDLocation.getLocationDescribe() == null) {
            z3 = false;
        }
        if (com.baidu.location.g.g.j && bDLocation.getPoiList() == null) {
            z3 = false;
        }
        if (z3 || z2) {
            com.baidu.location.a.a.a().a(bDLocation);
        }
    }

    public void b(Message message) {
        if (this.H) {
            c(message);
        }
    }

    public void b(BDLocation bDLocation) {
        String h2;
        int c;
        boolean z = true;
        BDLocation bDLocation2 = new BDLocation(bDLocation);
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
        if (com.baidu.location.e.d.a().i()) {
            BDLocation bDLocation3 = new BDLocation(com.baidu.location.e.d.a().f());
            if (com.baidu.location.g.g.g.equals("all") || com.baidu.location.g.g.h || com.baidu.location.g.g.j) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.z, this.y, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.v != null) {
                        bDLocation3.setAddr(this.v);
                    }
                    if (this.w != null) {
                        bDLocation3.setLocationDescribe(this.w);
                    }
                    if (this.x != null) {
                        bDLocation3.setPoiList(this.x);
                    }
                }
            }
            com.baidu.location.a.a.a().a(bDLocation3);
            m();
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
            m();
        } else {
            if (bDLocation.getLocType() == 167) {
                com.baidu.location.a.b.a().a(BDLocation.TypeServerError, 8, "NetWork location failed because baidu location service can not caculate the location!");
            } else if (bDLocation.getLocType() == 161) {
                if (Build.VERSION.SDK_INT >= 19 && ((c = com.baidu.location.g.g.c(com.baidu.location.f.getServiceContext())) == 0 || c == 2)) {
                    com.baidu.location.a.b.a().a(BDLocation.TypeNetWorkLocation, 1, "NetWork location successful, open gps will be better!");
                } else if (bDLocation.getRadius() >= 100.0f && bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals(Config.CELL_LOCATION) && (h2 = com.baidu.location.e.f.a().h()) != null && !h2.equals("&wifio=1")) {
                    com.baidu.location.a.b.a().a(BDLocation.TypeNetWorkLocation, 2, "NetWork location successful, open wifi will be better!");
                }
            }
            this.l = null;
            if (bDLocation.getLocType() == 161 && Config.CELL_LOCATION.equals(bDLocation.getNetworkLocationType()) && this.k != null && this.k.getLocType() == 161 && "wf".equals(this.k.getNetworkLocationType()) && System.currentTimeMillis() - this.u < StatisticConfig.MIN_UPLOAD_INTERVAL) {
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
            if (!com.baidu.location.g.g.a(bDLocation)) {
                this.k = null;
            } else if (!z) {
                this.k = bDLocation;
            }
            int a2 = com.baidu.location.g.g.a(c, "ssid\":\"", "\"");
            if (a2 == Integer.MIN_VALUE || this.m == null) {
                this.j = null;
            } else {
                this.j = this.m.d(a2);
            }
            if (com.baidu.location.d.d.a().d() && bDLocation.getLocType() == 161 && Config.CELL_LOCATION.equals(bDLocation.getNetworkLocationType()) && b(this.n)) {
                com.baidu.location.d.d.a().a(this.n, null, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.p = this.n;
            }
            if (com.baidu.location.d.d.a().d() && bDLocation.getLocType() == 161 && "wf".equals(bDLocation.getNetworkLocationType())) {
                com.baidu.location.d.d.a().a(null, this.m, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.o = this.m;
            }
            if (this.n != null) {
                com.baidu.location.d.a.a().a(c, this.n, this.m, bDLocation2);
            }
            if (com.baidu.location.e.f.j()) {
                com.baidu.location.d.d.a().i();
                com.baidu.location.d.d.a().m();
            }
            m();
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
        j();
        this.H = false;
    }

    public String f() {
        return this.w;
    }

    public List<Poi> g() {
        return this.x;
    }

    public boolean h() {
        return this.i;
    }

    public void i() {
        if (!this.s) {
            com.baidu.location.b.b.a().d();
            return;
        }
        h(null);
        this.s = false;
    }

    public void j() {
        this.k = null;
    }
}
