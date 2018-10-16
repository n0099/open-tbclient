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
/* loaded from: classes6.dex */
public class j extends g {
    private static j adP = null;
    public static boolean h = false;
    public g.b adQ;
    private double adY;
    private double z;
    final int e = 1000;
    private boolean j = true;
    private String k = null;
    private BDLocation l = null;
    private BDLocation adR = null;
    private com.baidu.location.b.e adS = null;
    private com.baidu.location.b.a adT = null;
    private com.baidu.location.b.e adU = null;
    private com.baidu.location.b.a adV = null;
    private boolean r = true;
    private volatile boolean s = false;
    private boolean t = false;
    private long u = 0;
    private long v = 0;
    private Address adW = null;
    private String x = null;
    private List<Poi> adX = null;
    private boolean B = false;
    private long C = 0;
    private long D = 0;
    private a adZ = null;
    private boolean F = false;
    private boolean G = false;
    private boolean H = true;
    public final Handler g = new g.a();
    private boolean I = false;
    private boolean J = false;
    private b aea = null;
    private boolean L = false;
    private int M = 0;
    private long aeb = 0;
    private boolean O = true;

    /* loaded from: classes6.dex */
    private class a implements Runnable {
        final /* synthetic */ j aec;

        @Override // java.lang.Runnable
        public void run() {
            if (this.aec.F) {
                this.aec.F = false;
                if (!this.aec.G) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
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
                j.this.n(null);
            }
        }
    }

    private j() {
        this.adQ = null;
        this.adQ = new g.b();
    }

    private boolean a(com.baidu.location.b.a aVar) {
        this.adG = com.baidu.location.b.b.tA().tB();
        if (this.adG == aVar) {
            return false;
        }
        return this.adG == null || aVar == null || !aVar.a(this.adG);
    }

    private boolean a(com.baidu.location.b.e eVar) {
        this.adF = com.baidu.location.b.f.tH().tK();
        if (eVar == this.adF) {
            return false;
        }
        return this.adF == null || eVar == null || !eVar.c(this.adF);
    }

    private void c(Message message) {
        boolean z = message.getData().getBoolean("isWaitingLocTag", false);
        if (z) {
            h = true;
        }
        if (z) {
        }
        int j = com.baidu.location.a.a.ti().j(message);
        switch (j) {
            case 1:
                d(message);
                return;
            case 2:
                m(message);
                return;
            case 3:
                if (com.baidu.location.b.d.tF().i()) {
                    e(message);
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(j)));
        }
    }

    private void d(Message message) {
        if (com.baidu.location.b.d.tF().i()) {
            e(message);
            l.tu().c();
            return;
        }
        m(message);
        l.tu().b();
    }

    private void e(Message message) {
        BDLocation bDLocation = new BDLocation(com.baidu.location.b.d.tF().f());
        if (com.baidu.location.d.g.g.equals("all") || com.baidu.location.d.g.h || com.baidu.location.d.g.i) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.adY, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.adW != null) {
                    bDLocation.setAddr(this.adW);
                }
                if (this.x != null) {
                    bDLocation.setLocationDescribe(this.x);
                }
                if (this.adX != null) {
                    bDLocation.setPoiList(this.adX);
                }
            } else {
                this.B = true;
                m(null);
            }
        }
        this.l = bDLocation;
        this.adR = null;
        com.baidu.location.a.a.ti().a(bDLocation);
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

    private void l() {
        if (this.l != null) {
            p.tz().c();
        }
    }

    private void l(Message message) {
        if (!com.baidu.location.b.f.tH().f()) {
            n(message);
            return;
        }
        this.t = true;
        if (this.aea == null) {
            this.aea = new b();
        }
        if (this.L && this.aea != null) {
            this.g.removeCallbacks(this.aea);
        }
        this.g.postDelayed(this.aea, 3500L);
        this.L = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Message message) {
        this.M = 0;
        if (!this.r) {
            l(message);
            this.D = SystemClock.uptimeMillis();
            return;
        }
        this.M = 1;
        this.D = SystemClock.uptimeMillis();
        if (com.baidu.location.b.f.tH().j()) {
            l(message);
        } else {
            n(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Message message) {
        long j = 0;
        long currentTimeMillis = System.currentTimeMillis() - this.u;
        if (!this.s || currentTimeMillis > 12000) {
            if (System.currentTimeMillis() - this.u > 0 && System.currentTimeMillis() - this.u < 1000) {
                if (this.l != null) {
                    com.baidu.location.a.a.ti().a(this.l);
                }
                k();
                return;
            }
            this.s = true;
            this.j = a(this.adT);
            if (!a(this.adS) && !this.j && this.l != null && !this.B) {
                if (this.adR != null && System.currentTimeMillis() - this.v > StatisticConfig.MIN_UPLOAD_INTERVAL) {
                    this.l = this.adR;
                    this.adR = null;
                }
                if (l.tu().d()) {
                    this.l.setDirection(l.tu().e());
                }
                if (this.l.getLocType() == 62) {
                    long currentTimeMillis2 = System.currentTimeMillis() - this.aeb;
                    if (currentTimeMillis2 > 0) {
                        j = currentTimeMillis2;
                    }
                }
                if (this.l.getLocType() == 61 || this.l.getLocType() == 161 || (this.l.getLocType() == 62 && j < 15000)) {
                    com.baidu.location.a.a.ti().a(this.l);
                    k();
                    return;
                }
            }
            this.u = System.currentTimeMillis();
            String a2 = a((String) null);
            this.J = false;
            if (a2 == null) {
                this.J = true;
                this.aeb = System.currentTimeMillis();
                String[] ts = ts();
                long currentTimeMillis3 = System.currentTimeMillis();
                if (currentTimeMillis3 - this.C > 60000) {
                    this.C = currentTimeMillis3;
                }
                String l = com.baidu.location.b.f.tH().l();
                a2 = l != null ? l + b() + ts[0] : "" + b() + ts[0];
                if (this.adG != null && this.adG.g() != null) {
                    a2 = this.adG.g() + a2;
                }
                String a3 = com.baidu.location.d.b.tM().a(true);
                if (a3 != null) {
                    a2 = a2 + a3;
                }
            }
            if (this.k != null) {
                a2 = a2 + this.k;
                this.k = null;
            }
            this.adQ.a(a2);
            this.adT = this.adG;
            this.adS = this.adF;
            if (this.r) {
                this.r = false;
                if (!com.baidu.location.b.f.i() || message == null || com.baidu.location.a.a.ti().k(message) < 1000) {
                }
            }
            if (this.M > 0) {
                if (this.M == 2) {
                    com.baidu.location.b.f.tH().f();
                }
                this.M = 0;
            }
        }
    }

    public static synchronized j tr() {
        j jVar;
        synchronized (j.class) {
            if (adP == null) {
                adP = new j();
            }
            jVar = adP;
        }
        return jVar;
    }

    private String[] ts() {
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
        String g = com.baidu.location.b.b.tA().g();
        String g2 = com.baidu.location.b.f.tH().g();
        stringBuffer.append(g2);
        stringBuffer.append(g);
        stringBuffer.append(com.baidu.location.d.g.d(com.baidu.location.f.getServiceContext()));
        if (a2 == 1) {
            com.baidu.location.a.b.tj().a(62, 7, "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!");
        } else if (c.contains("0|0|")) {
            com.baidu.location.a.b.tj().a(62, 4, "Location failed beacuse we can not get any loc information without any location permission!");
        } else if (z) {
            com.baidu.location.a.b.tj().a(62, 5, "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!");
        } else if (g == null || g2 == null || !g.equals("&sim=1") || g2.equals("&wifio=1")) {
            com.baidu.location.a.b.tj().a(62, 9, "Location failed beacuse we can not get any loc information!");
        } else {
            com.baidu.location.a.b.tj().a(62, 6, "Location failed beacuse we can not get any loc information , you can insert a sim card or open wifi and try again!");
        }
        strArr[0] = stringBuffer.toString();
        return strArr;
    }

    @Override // com.baidu.location.a.g
    public void a() {
        if (this.adZ != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.adZ);
        }
        if (!com.baidu.location.b.d.tF().i()) {
            if (this.G) {
                k();
                return;
            }
            if (this.j || this.l == null) {
                BDLocation bDLocation = new BDLocation();
                bDLocation.setLocType(63);
                this.l = null;
                com.baidu.location.a.a.ti().a(bDLocation);
            } else {
                com.baidu.location.a.a.ti().a(this.l);
            }
            this.adR = null;
            k();
            return;
        }
        BDLocation bDLocation2 = new BDLocation(com.baidu.location.b.d.tF().f());
        if (com.baidu.location.d.g.g.equals("all") || com.baidu.location.d.g.h || com.baidu.location.d.g.i) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.adY, this.z, bDLocation2.getLatitude(), bDLocation2.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.adW != null) {
                    bDLocation2.setAddr(this.adW);
                }
                if (this.x != null) {
                    bDLocation2.setLocationDescribe(this.x);
                }
                if (this.adX != null) {
                    bDLocation2.setPoiList(this.adX);
                }
            }
        }
        com.baidu.location.a.a.ti().a(bDLocation2);
        k();
    }

    @Override // com.baidu.location.a.g
    public void a(Message message) {
        if (this.adZ != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.adZ);
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
            this.adW = bDLocation.getAddress();
            this.z = bDLocation.getLongitude();
            this.adY = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.x = bDLocation.getLocationDescribe();
            this.z = bDLocation.getLongitude();
            this.adY = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.adX = bDLocation.getPoiList();
            this.z = bDLocation.getLongitude();
            this.adY = bDLocation.getLatitude();
        }
        if (com.baidu.location.b.d.tF().i()) {
            BDLocation bDLocation2 = new BDLocation(com.baidu.location.b.d.tF().f());
            if (com.baidu.location.d.g.g.equals("all") || com.baidu.location.d.g.h || com.baidu.location.d.g.i) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.adY, this.z, bDLocation2.getLatitude(), bDLocation2.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.adW != null) {
                        bDLocation2.setAddr(this.adW);
                    }
                    if (this.x != null) {
                        bDLocation2.setLocationDescribe(this.x);
                    }
                    if (this.adX != null) {
                        bDLocation2.setPoiList(this.adX);
                    }
                }
            }
            com.baidu.location.a.a.ti().a(bDLocation2);
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
                    com.baidu.location.a.a.ti().a(bDLocation);
                }
            } else if (bDLocation.getUserIndoorState() > -1) {
                this.l = bDLocation;
                com.baidu.location.a.a.ti().a(bDLocation);
            }
            k();
        } else {
            if (bDLocation.getLocType() == 167) {
                com.baidu.location.a.b.tj().a(BDLocation.TypeServerError, 8, "NetWork location failed because baidu location service can not caculate the location!");
            } else if (bDLocation.getLocType() == 161) {
                if (Build.VERSION.SDK_INT >= 19 && ((b2 = com.baidu.location.d.g.b(com.baidu.location.f.getServiceContext())) == 0 || b2 == 2)) {
                    com.baidu.location.a.b.tj().a(BDLocation.TypeNetWorkLocation, 1, "NetWork location successful, open gps will be better!");
                } else if (bDLocation.getRadius() >= 100.0f && bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals(Config.CELL_LOCATION) && (g = com.baidu.location.b.f.tH().g()) != null && !g.equals("&wifio=1")) {
                    com.baidu.location.a.b.tj().a(BDLocation.TypeNetWorkLocation, 2, "NetWork location successful, open wifi will be better!");
                }
            }
            this.adR = null;
            if (bDLocation.getLocType() == 161 && Config.CELL_LOCATION.equals(bDLocation.getNetworkLocationType()) && this.l != null && this.l.getLocType() == 161 && "wf".equals(this.l.getNetworkLocationType()) && System.currentTimeMillis() - this.v < StatisticConfig.MIN_UPLOAD_INTERVAL) {
                this.adR = bDLocation;
            } else {
                z = false;
            }
            if (z) {
                com.baidu.location.a.a.ti().a(this.l);
            } else {
                com.baidu.location.a.a.ti().a(bDLocation);
                this.v = System.currentTimeMillis();
            }
            if (!com.baidu.location.d.g.f(bDLocation)) {
                this.l = null;
            } else if (!z) {
                this.l = bDLocation;
            }
            int m = com.baidu.location.d.g.m(c, "ssid\":\"", "\"");
            if (m == Integer.MIN_VALUE || this.adS == null) {
                this.k = null;
            } else {
                this.k = this.adS.c(m);
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
            Location.distanceBetween(this.adY, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] >= 100.0f) {
                this.x = null;
                this.adX = null;
                this.B = true;
                this.g.post(new Runnable() { // from class: com.baidu.location.a.j.1
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.m(null);
                    }
                });
            } else if (this.adW != null) {
                return this.adW;
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
        return this.adX;
    }

    public void h() {
        if (this.t) {
            n(null);
            this.t = false;
        }
    }

    public void i() {
        this.l = null;
    }
}
