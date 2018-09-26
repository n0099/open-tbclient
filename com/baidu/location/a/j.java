package com.baidu.location.a;

import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Poi;
import com.baidu.location.a.g;
import com.baidu.mobstat.Config;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.util.List;
/* loaded from: classes2.dex */
public class j extends g {
    private static j Zi = null;
    public static boolean h = false;
    public g.b Zj;
    private double Zr;
    private double z;
    final int e = 1000;
    private boolean j = true;
    private String k = null;
    private BDLocation l = null;
    private BDLocation Zk = null;
    private com.baidu.location.b.e Zl = null;
    private com.baidu.location.b.a Zm = null;
    private com.baidu.location.b.e Zn = null;
    private com.baidu.location.b.a Zo = null;
    private boolean r = true;
    private volatile boolean s = false;
    private boolean t = false;
    private long u = 0;
    private long v = 0;
    private Address Zp = null;
    private String x = null;
    private List<Poi> Zq = null;
    private boolean B = false;
    private long C = 0;
    private long D = 0;
    private a Zs = null;
    private boolean F = false;
    private boolean G = false;
    private boolean H = true;
    public final Handler g = new g.a();
    private boolean I = false;
    private boolean J = false;
    private b Zt = null;
    private boolean L = false;
    private int M = 0;
    private long Zu = 0;
    private boolean O = true;

    /* loaded from: classes2.dex */
    private class a implements Runnable {
        final /* synthetic */ j Zv;

        @Override // java.lang.Runnable
        public void run() {
            if (this.Zv.F) {
                this.Zv.F = false;
                if (!this.Zv.G) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j.this.L) {
                j.this.L = false;
            }
            if (j.this.t) {
                j.this.t = false;
                j.this.k(null);
            }
        }
    }

    private j() {
        this.Zj = null;
        this.Zj = new g.b();
    }

    private boolean a(com.baidu.location.b.a aVar) {
        this.YZ = com.baidu.location.b.b.rG().rH();
        if (this.YZ == aVar) {
            return false;
        }
        return this.YZ == null || aVar == null || !aVar.a(this.YZ);
    }

    private boolean a(com.baidu.location.b.e eVar) {
        this.YY = com.baidu.location.b.f.rN().rQ();
        if (eVar == this.YY) {
            return false;
        }
        return this.YY == null || eVar == null || !eVar.c(this.YY);
    }

    private void c(Message message) {
        boolean z = message.getData().getBoolean("isWaitingLocTag", false);
        if (z) {
            h = true;
        }
        if (z) {
        }
        int g = com.baidu.location.a.a.rp().g(message);
        switch (g) {
            case 1:
                d(message);
                return;
            case 2:
                j(message);
                return;
            case 3:
                if (com.baidu.location.b.d.rL().i()) {
                    e(message);
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(g)));
        }
    }

    private void d(Message message) {
        if (com.baidu.location.b.d.rL().i()) {
            e(message);
            l.rA().c();
            return;
        }
        j(message);
        l.rA().b();
    }

    private void e(Message message) {
        BDLocation bDLocation = new BDLocation(com.baidu.location.b.d.rL().f());
        if (com.baidu.location.d.g.g.equals("all") || com.baidu.location.d.g.h || com.baidu.location.d.g.i) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.Zr, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.Zp != null) {
                    bDLocation.setAddr(this.Zp);
                }
                if (this.x != null) {
                    bDLocation.setLocationDescribe(this.x);
                }
                if (this.Zq != null) {
                    bDLocation.setPoiList(this.Zq);
                }
            } else {
                this.B = true;
                j(null);
            }
        }
        this.l = bDLocation;
        this.Zk = null;
        com.baidu.location.a.a.rp().a(bDLocation);
    }

    private void i(Message message) {
        if (!com.baidu.location.b.f.rN().f()) {
            k(message);
            return;
        }
        this.t = true;
        if (this.Zt == null) {
            this.Zt = new b();
        }
        if (this.L && this.Zt != null) {
            this.g.removeCallbacks(this.Zt);
        }
        this.g.postDelayed(this.Zt, 3500L);
        this.L = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Message message) {
        this.M = 0;
        if (!this.r) {
            i(message);
            this.D = SystemClock.uptimeMillis();
            return;
        }
        this.M = 1;
        this.D = SystemClock.uptimeMillis();
        if (com.baidu.location.b.f.rN().j()) {
            i(message);
        } else {
            k(message);
        }
    }

    private void k() {
        this.s = false;
        this.G = false;
        this.H = false;
        this.B = false;
        l();
        if (this.O) {
            this.O = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Message message) {
        long j = 0;
        long currentTimeMillis = System.currentTimeMillis() - this.u;
        if (!this.s || currentTimeMillis > 12000) {
            if (System.currentTimeMillis() - this.u > 0 && System.currentTimeMillis() - this.u < 1000) {
                if (this.l != null) {
                    com.baidu.location.a.a.rp().a(this.l);
                }
                k();
                return;
            }
            this.s = true;
            this.j = a(this.Zm);
            if (!a(this.Zl) && !this.j && this.l != null && !this.B) {
                if (this.Zk != null && System.currentTimeMillis() - this.v > StatisticConfig.MIN_UPLOAD_INTERVAL) {
                    this.l = this.Zk;
                    this.Zk = null;
                }
                if (l.rA().d()) {
                    this.l.setDirection(l.rA().e());
                }
                if (this.l.getLocType() == 62) {
                    long currentTimeMillis2 = System.currentTimeMillis() - this.Zu;
                    if (currentTimeMillis2 > 0) {
                        j = currentTimeMillis2;
                    }
                }
                if (this.l.getLocType() == 61 || this.l.getLocType() == 161 || (this.l.getLocType() == 62 && j < 15000)) {
                    com.baidu.location.a.a.rp().a(this.l);
                    k();
                    return;
                }
            }
            this.u = System.currentTimeMillis();
            String a2 = a((String) null);
            this.J = false;
            if (a2 == null) {
                this.J = true;
                this.Zu = System.currentTimeMillis();
                String[] ry = ry();
                long currentTimeMillis3 = System.currentTimeMillis();
                if (currentTimeMillis3 - this.C > 60000) {
                    this.C = currentTimeMillis3;
                }
                String l = com.baidu.location.b.f.rN().l();
                a2 = l != null ? l + b() + ry[0] : "" + b() + ry[0];
                if (this.YZ != null && this.YZ.g() != null) {
                    a2 = this.YZ.g() + a2;
                }
                String a3 = com.baidu.location.d.b.rS().a(true);
                if (a3 != null) {
                    a2 = a2 + a3;
                }
            }
            if (this.k != null) {
                a2 = a2 + this.k;
                this.k = null;
            }
            this.Zj.a(a2);
            this.Zm = this.YZ;
            this.Zl = this.YY;
            if (this.r) {
                this.r = false;
                if (!com.baidu.location.b.f.i() || message == null || com.baidu.location.a.a.rp().h(message) < 1000) {
                }
            }
            if (this.M > 0) {
                if (this.M == 2) {
                    com.baidu.location.b.f.rN().f();
                }
                this.M = 0;
            }
        }
    }

    private void l() {
        if (this.l != null) {
            p.rF().c();
        }
    }

    public static synchronized j rx() {
        j jVar;
        synchronized (j.class) {
            if (Zi == null) {
                Zi = new j();
            }
            jVar = Zi;
        }
        return jVar;
    }

    private String[] ry() {
        boolean z;
        String[] strArr = {"", "Location failed beacuse we can not get any loc information!"};
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("&apl=");
        int a2 = com.baidu.location.d.g.a(com.baidu.location.f.getServiceContext());
        if (a2 == 1) {
            strArr[1] = "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!";
        }
        stringBuffer.append(a2);
        String c = com.baidu.location.d.g.c(com.baidu.location.f.getServiceContext());
        if (c.contains("0|0|")) {
            strArr[1] = "Location failed beacuse we can not get any loc information without any location permission!";
        }
        stringBuffer.append(c);
        if (Build.VERSION.SDK_INT >= 23) {
            stringBuffer.append("&loc=");
            int b2 = com.baidu.location.d.g.b(com.baidu.location.f.getServiceContext());
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
            int b3 = com.baidu.location.d.g.b(com.baidu.location.f.getServiceContext());
            if (b3 >= 0) {
                stringBuffer.append(b3);
            }
        }
        String g = com.baidu.location.b.b.rG().g();
        String g2 = com.baidu.location.b.f.rN().g();
        stringBuffer.append(g2);
        stringBuffer.append(g);
        stringBuffer.append(com.baidu.location.d.g.d(com.baidu.location.f.getServiceContext()));
        if (a2 == 1) {
            com.baidu.location.a.b.rq().a(62, 7, "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!");
        } else if (c.contains("0|0|")) {
            com.baidu.location.a.b.rq().a(62, 4, "Location failed beacuse we can not get any loc information without any location permission!");
        } else if (z) {
            com.baidu.location.a.b.rq().a(62, 5, "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!");
        } else if (g == null || g2 == null || !g.equals("&sim=1") || g2.equals("&wifio=1")) {
            com.baidu.location.a.b.rq().a(62, 9, "Location failed beacuse we can not get any loc information!");
        } else {
            com.baidu.location.a.b.rq().a(62, 6, "Location failed beacuse we can not get any loc information , you can insert a sim card or open wifi and try again!");
        }
        strArr[0] = stringBuffer.toString();
        return strArr;
    }

    @Override // com.baidu.location.a.g
    public void a() {
        if (this.Zs != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.Zs);
        }
        if (!com.baidu.location.b.d.rL().i()) {
            if (this.G) {
                k();
                return;
            }
            if (this.j || this.l == null) {
                BDLocation bDLocation = new BDLocation();
                bDLocation.setLocType(63);
                this.l = null;
                com.baidu.location.a.a.rp().a(bDLocation);
            } else {
                com.baidu.location.a.a.rp().a(this.l);
            }
            this.Zk = null;
            k();
            return;
        }
        BDLocation bDLocation2 = new BDLocation(com.baidu.location.b.d.rL().f());
        if (com.baidu.location.d.g.g.equals("all") || com.baidu.location.d.g.h || com.baidu.location.d.g.i) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.Zr, this.z, bDLocation2.getLatitude(), bDLocation2.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.Zp != null) {
                    bDLocation2.setAddr(this.Zp);
                }
                if (this.x != null) {
                    bDLocation2.setLocationDescribe(this.x);
                }
                if (this.Zq != null) {
                    bDLocation2.setPoiList(this.Zq);
                }
            }
        }
        com.baidu.location.a.a.rp().a(bDLocation2);
        k();
    }

    @Override // com.baidu.location.a.g
    public void a(Message message) {
        if (this.Zs != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.Zs);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        if (bDLocation != null && bDLocation.getLocType() == 167 && this.J) {
            bDLocation.setLocType(62);
        }
        b(bDLocation);
    }

    public void b(Message message) {
        if (this.I) {
            c(message);
        }
    }

    public void b(BDLocation bDLocation) {
        String g;
        int b2;
        boolean z = true;
        new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            this.Zp = bDLocation.getAddress();
            this.z = bDLocation.getLongitude();
            this.Zr = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.x = bDLocation.getLocationDescribe();
            this.z = bDLocation.getLongitude();
            this.Zr = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.Zq = bDLocation.getPoiList();
            this.z = bDLocation.getLongitude();
            this.Zr = bDLocation.getLatitude();
        }
        if (com.baidu.location.b.d.rL().i()) {
            BDLocation bDLocation2 = new BDLocation(com.baidu.location.b.d.rL().f());
            if (com.baidu.location.d.g.g.equals("all") || com.baidu.location.d.g.h || com.baidu.location.d.g.i) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.Zr, this.z, bDLocation2.getLatitude(), bDLocation2.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.Zp != null) {
                        bDLocation2.setAddr(this.Zp);
                    }
                    if (this.x != null) {
                        bDLocation2.setLocationDescribe(this.x);
                    }
                    if (this.Zq != null) {
                        bDLocation2.setPoiList(this.Zq);
                    }
                }
            }
            com.baidu.location.a.a.rp().a(bDLocation2);
            k();
        } else if (this.G) {
            float[] fArr2 = new float[2];
            if (this.l != null) {
                Location.distanceBetween(this.l.getLatitude(), this.l.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
            }
            if (fArr2[0] > 10.0f) {
                this.l = bDLocation;
                if (!this.H) {
                    this.H = false;
                    com.baidu.location.a.a.rp().a(bDLocation);
                }
            } else if (bDLocation.getUserIndoorState() > -1) {
                this.l = bDLocation;
                com.baidu.location.a.a.rp().a(bDLocation);
            }
            k();
        } else {
            if (bDLocation.getLocType() == 167) {
                com.baidu.location.a.b.rq().a(BDLocation.TypeServerError, 8, "NetWork location failed because baidu location service can not caculate the location!");
            } else if (bDLocation.getLocType() == 161) {
                if (Build.VERSION.SDK_INT >= 19 && ((b2 = com.baidu.location.d.g.b(com.baidu.location.f.getServiceContext())) == 0 || b2 == 2)) {
                    com.baidu.location.a.b.rq().a(BDLocation.TypeNetWorkLocation, 1, "NetWork location successful, open gps will be better!");
                } else if (bDLocation.getRadius() >= 100.0f && bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals(Config.CELL_LOCATION) && (g = com.baidu.location.b.f.rN().g()) != null && !g.equals("&wifio=1")) {
                    com.baidu.location.a.b.rq().a(BDLocation.TypeNetWorkLocation, 2, "NetWork location successful, open wifi will be better!");
                }
            }
            this.Zk = null;
            if (bDLocation.getLocType() == 161 && Config.CELL_LOCATION.equals(bDLocation.getNetworkLocationType()) && this.l != null && this.l.getLocType() == 161 && "wf".equals(this.l.getNetworkLocationType()) && System.currentTimeMillis() - this.v < StatisticConfig.MIN_UPLOAD_INTERVAL) {
                this.Zk = bDLocation;
            } else {
                z = false;
            }
            if (z) {
                com.baidu.location.a.a.rp().a(this.l);
            } else {
                com.baidu.location.a.a.rp().a(bDLocation);
                this.v = System.currentTimeMillis();
            }
            if (!com.baidu.location.d.g.f(bDLocation)) {
                this.l = null;
            } else if (!z) {
                this.l = bDLocation;
            }
            int j = com.baidu.location.d.g.j(c, "ssid\":\"", "\"");
            if (j == Integer.MIN_VALUE || this.Zl == null) {
                this.k = null;
            } else {
                this.k = this.Zl.c(j);
            }
            if (com.baidu.location.b.f.i()) {
            }
            k();
        }
    }

    public void c(BDLocation bDLocation) {
        this.l = new BDLocation(bDLocation);
    }

    public void d() {
        this.r = true;
        this.s = false;
        this.I = true;
    }

    public Address e(BDLocation bDLocation) {
        if (com.baidu.location.d.g.g.equals("all") || com.baidu.location.d.g.h || com.baidu.location.d.g.i) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.Zr, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] >= 100.0f) {
                this.x = null;
                this.Zq = null;
                this.B = true;
                this.g.post(new Runnable() { // from class: com.baidu.location.a.j.1
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.j(null);
                    }
                });
            } else if (this.Zp != null) {
                return this.Zp;
            }
        }
        return null;
    }

    public void e() {
        this.s = false;
        this.t = false;
        this.G = false;
        this.H = true;
        i();
        this.I = false;
    }

    public String f() {
        return this.x;
    }

    public List<Poi> g() {
        return this.Zq;
    }

    public void h() {
        if (this.t) {
            k(null);
            this.t = false;
        }
    }

    public void i() {
        this.l = null;
    }
}
