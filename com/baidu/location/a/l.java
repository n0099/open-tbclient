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
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import java.util.List;
/* loaded from: classes2.dex */
public class l extends i {

    /* renamed from: g  reason: collision with root package name */
    public static boolean f6809g = false;

    /* renamed from: h  reason: collision with root package name */
    public static l f6810h;

    /* renamed from: e  reason: collision with root package name */
    public i.b f6811e;
    public double y;
    public double z;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6813i = true;
    public String j = null;
    public BDLocation k = null;
    public BDLocation l = null;
    public com.baidu.location.b.h m = null;
    public com.baidu.location.b.a n = null;
    public com.baidu.location.b.h o = null;
    public com.baidu.location.b.a p = null;
    public boolean q = true;
    public volatile boolean r = false;
    public boolean s = false;
    public long t = 0;
    public long u = 0;
    public Address v = null;
    public String w = null;
    public List<Poi> x = null;
    public boolean A = false;
    public long B = 0;
    public long C = 0;
    public a D = null;
    public boolean E = false;
    public boolean F = false;
    public boolean G = true;

    /* renamed from: f  reason: collision with root package name */
    public final Handler f6812f = new i.a();
    public boolean H = false;
    public boolean I = false;
    public b J = null;
    public boolean K = false;
    public int L = 0;
    public long M = 0;
    public boolean N = true;

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f6814a;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f6814a.E) {
                this.f6814a.E = false;
                boolean unused = this.f6814a.F;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        public /* synthetic */ b(l lVar, m mVar) {
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

    public l() {
        this.f6811e = null;
        this.f6811e = new i.b();
    }

    private boolean a(com.baidu.location.b.a aVar) {
        com.baidu.location.b.a f2 = com.baidu.location.b.b.a().f();
        this.f6774b = f2;
        if (f2 == aVar) {
            return false;
        }
        if (f2 == null || aVar == null) {
            return true;
        }
        return !aVar.a(f2);
    }

    private boolean a(com.baidu.location.b.h hVar) {
        com.baidu.location.b.h o = com.baidu.location.b.i.a().o();
        this.f6773a = o;
        if (hVar == o) {
            return false;
        }
        if (o == null || hVar == null) {
            return true;
        }
        return !hVar.c(o);
    }

    public static synchronized l c() {
        l lVar;
        synchronized (l.class) {
            if (f6810h == null) {
                f6810h = new l();
            }
            lVar = f6810h;
        }
        return lVar;
    }

    private void c(Message message) {
        if (message.getData().getBoolean("isWaitingLocTag", false)) {
            f6809g = true;
        }
        int d2 = com.baidu.location.a.a.a().d(message);
        if (d2 == 1) {
            d(message);
        } else if (d2 == 2) {
            g(message);
        } else if (d2 != 3) {
            throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(d2)));
        } else {
            if (com.baidu.location.b.e.a().i()) {
                e(message);
            }
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
        if (com.baidu.location.d.j.f6991g.equals("all") || com.baidu.location.d.j.f6992h || com.baidu.location.d.j.j) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.z, this.y, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                Address address = this.v;
                if (address != null) {
                    bDLocation.setAddr(address);
                }
                String str = this.w;
                if (str != null) {
                    bDLocation.setLocationDescribe(str);
                }
                List<Poi> list = this.x;
                if (list != null) {
                    bDLocation.setPoiList(list);
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
        b bVar;
        if (!com.baidu.location.b.i.a().f()) {
            h(message);
            return;
        }
        this.s = true;
        if (this.J == null) {
            this.J = new b(this, null);
        }
        if (this.K && (bVar = this.J) != null) {
            this.f6812f.removeCallbacks(bVar);
        }
        this.f6812f.postDelayed(this.J, 3500L);
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
        long currentTimeMillis = System.currentTimeMillis() - this.t;
        if (!this.r || currentTimeMillis > 12000) {
            long j = 0;
            if (System.currentTimeMillis() - this.t > 0 && System.currentTimeMillis() - this.t < 1000) {
                if (this.k != null) {
                    com.baidu.location.a.a.a().a(this.k);
                }
                k();
                return;
            }
            this.r = true;
            this.f6813i = a(this.n);
            if (!a(this.m) && !this.f6813i && this.k != null && !this.A) {
                if (this.l != null && System.currentTimeMillis() - this.u > StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD) {
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
                if (currentTimeMillis3 - this.B > 60000) {
                    this.B = currentTimeMillis3;
                }
                String l = com.baidu.location.b.i.a().l();
                if (l != null) {
                    a2 = l + b() + j2[0];
                } else {
                    a2 = "" + b() + j2[0];
                }
                com.baidu.location.b.a aVar = this.f6774b;
                if (aVar != null && aVar.g() != null) {
                    a2 = this.f6774b.g() + a2;
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
            this.f6811e.a(a2);
            this.n = this.f6774b;
            this.m = this.f6773a;
            if (this.q) {
                this.q = false;
                if (com.baidu.location.b.i.i() && message != null) {
                    com.baidu.location.a.a.a().e(message);
                }
            }
            int i2 = this.L;
            if (i2 > 0) {
                if (i2 == 2) {
                    com.baidu.location.b.i.a().f();
                }
                this.L = 0;
            }
        }
    }

    private String[] j() {
        boolean z;
        com.baidu.location.a.b a2;
        int i2;
        String[] strArr = {"", "Location failed beacuse we can not get any loc information!"};
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("&apl=");
        int a3 = com.baidu.location.d.j.a(com.baidu.location.f.getServiceContext());
        String str = "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!";
        if (a3 == 1) {
            strArr[1] = "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!";
        }
        stringBuffer.append(a3);
        String c2 = com.baidu.location.d.j.c(com.baidu.location.f.getServiceContext());
        if (c2.contains("0|0|")) {
            strArr[1] = "Location failed beacuse we can not get any loc information without any location permission!";
        }
        stringBuffer.append(c2);
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
        if (a3 != 1) {
            if (c2.contains("0|0|")) {
                com.baidu.location.a.b.a().a(62, 4, "Location failed beacuse we can not get any loc information without any location permission!");
            } else if (z) {
                com.baidu.location.a.b.a().a(62, 5, "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!");
            } else if (g2 == null || g3 == null || !g2.equals("&sim=1") || g3.equals("&wifio=1")) {
                com.baidu.location.a.b.a().a(62, 9, "Location failed beacuse we can not get any loc information!");
            } else {
                a2 = com.baidu.location.a.b.a();
                i2 = 6;
                str = "Location failed beacuse we can not get any loc information , you can insert a sim card or open wifi and try again!";
            }
            strArr[0] = stringBuffer.toString();
            return strArr;
        }
        a2 = com.baidu.location.a.b.a();
        i2 = 7;
        a2.a(62, i2, str);
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
        if (com.baidu.location.d.j.f6991g.equals("all") || com.baidu.location.d.j.f6992h || com.baidu.location.d.j.j) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.z, this.y, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                Address address = this.v;
                if (address != null) {
                    return address;
                }
            } else {
                this.w = null;
                this.x = null;
                this.A = true;
                this.f6812f.post(new m(this));
            }
        }
        return null;
    }

    @Override // com.baidu.location.a.i
    public void a() {
        a aVar = this.D;
        if (aVar != null && this.E) {
            this.E = false;
            this.f6812f.removeCallbacks(aVar);
        }
        if (com.baidu.location.b.e.a().i()) {
            BDLocation bDLocation = new BDLocation(com.baidu.location.b.e.a().f());
            if (com.baidu.location.d.j.f6991g.equals("all") || com.baidu.location.d.j.f6992h || com.baidu.location.d.j.j) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.z, this.y, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    Address address = this.v;
                    if (address != null) {
                        bDLocation.setAddr(address);
                    }
                    String str = this.w;
                    if (str != null) {
                        bDLocation.setLocationDescribe(str);
                    }
                    List<Poi> list = this.x;
                    if (list != null) {
                        bDLocation.setPoiList(list);
                    }
                }
            }
            com.baidu.location.a.a.a().a(bDLocation);
        } else if (this.F) {
            k();
            return;
        } else {
            if (this.f6813i || this.k == null) {
                BDLocation bDLocation2 = new BDLocation();
                bDLocation2.setLocType(63);
                this.k = null;
                com.baidu.location.a.a.a().a(bDLocation2);
            } else {
                com.baidu.location.a.a.a().a(this.k);
            }
            this.l = null;
        }
        k();
    }

    @Override // com.baidu.location.a.i
    public void a(Message message) {
        a aVar = this.D;
        if (aVar != null && this.E) {
            this.E = false;
            this.f6812f.removeCallbacks(aVar);
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
        com.baidu.location.b.h hVar;
        BDLocation bDLocation2;
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
        boolean z = false;
        if (com.baidu.location.b.e.a().i()) {
            BDLocation bDLocation3 = new BDLocation(com.baidu.location.b.e.a().f());
            if (com.baidu.location.d.j.f6991g.equals("all") || com.baidu.location.d.j.f6992h || com.baidu.location.d.j.j) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.z, this.y, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    Address address = this.v;
                    if (address != null) {
                        bDLocation3.setAddr(address);
                    }
                    String str = this.w;
                    if (str != null) {
                        bDLocation3.setLocationDescribe(str);
                    }
                    List<Poi> list = this.x;
                    if (list != null) {
                        bDLocation3.setPoiList(list);
                    }
                }
            }
            com.baidu.location.a.a.a().a(bDLocation3);
            k();
        } else if (this.F) {
            float[] fArr2 = new float[2];
            BDLocation bDLocation4 = this.k;
            if (bDLocation4 != null) {
                Location.distanceBetween(bDLocation4.getLatitude(), this.k.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
            }
            if (fArr2[0] <= 10.0f) {
                if (bDLocation.getUserIndoorState() > -1) {
                    this.k = bDLocation;
                    com.baidu.location.a.a.a().a(bDLocation);
                }
                k();
            }
            this.k = bDLocation;
            if (!this.G) {
                this.G = false;
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
            if (bDLocation.getLocType() == 161 && Config.CELL_LOCATION.equals(bDLocation.getNetworkLocationType()) && (bDLocation2 = this.k) != null && bDLocation2.getLocType() == 161 && "wf".equals(this.k.getNetworkLocationType()) && System.currentTimeMillis() - this.u < StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD) {
                this.l = bDLocation;
                z = true;
            }
            com.baidu.location.a.a a2 = com.baidu.location.a.a.a();
            if (z) {
                a2.a(this.k);
            } else {
                a2.a(bDLocation);
                this.u = System.currentTimeMillis();
            }
            if (!com.baidu.location.d.j.a(bDLocation)) {
                this.k = null;
            } else if (!z) {
                this.k = bDLocation;
            }
            int a3 = com.baidu.location.d.j.a(i.f6772c, "ssid\":\"", "\"");
            if (a3 == Integer.MIN_VALUE || (hVar = this.m) == null) {
                this.j = null;
            } else {
                this.j = hVar.c(a3);
            }
            com.baidu.location.b.i.i();
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
