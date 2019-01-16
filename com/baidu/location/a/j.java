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
/* loaded from: classes6.dex */
public class j extends h {
    private static j adN = null;
    public static boolean g = false;
    public h.b adO;
    private double y;
    private double z;
    private boolean i = true;
    private String j = null;
    private BDLocation k = null;
    private BDLocation adP = null;
    private com.baidu.location.e.e adQ = null;
    private com.baidu.location.e.a adR = null;
    private com.baidu.location.e.e adS = null;
    private com.baidu.location.e.a adT = null;
    private boolean q = true;
    private volatile boolean r = false;
    private boolean s = false;
    private long t = 0;
    private long u = 0;
    private Address adU = null;
    private String w = null;
    private List<Poi> adV = null;
    private boolean A = false;
    private long adW = 0;
    private long C = 0;
    private a adX = null;
    private boolean E = false;
    private boolean F = false;
    private boolean G = true;
    public final Handler f = new h.a();
    private boolean H = false;
    private boolean I = false;
    private b adY = null;
    private boolean K = false;
    private int L = 0;
    private long adZ = 0;
    private boolean N = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j.this.E) {
                j.this.E = false;
                if (j.this.F || com.baidu.location.e.d.tS().i()) {
                    return;
                }
                j.this.a(false, false);
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
            if (j.this.K) {
                j.this.K = false;
            }
            if (j.this.s) {
                j.this.s = false;
                j.this.m(null);
            }
        }
    }

    private j() {
        this.adO = null;
        this.adO = new h.b();
    }

    private boolean a(com.baidu.location.e.a aVar) {
        this.adJ = com.baidu.location.e.b.tP().tQ();
        if (this.adJ == aVar) {
            return false;
        }
        return this.adJ == null || aVar == null || !aVar.a(this.adJ);
    }

    private boolean a(com.baidu.location.e.e eVar) {
        this.adI = com.baidu.location.e.f.tU().tX();
        if (eVar == this.adI) {
            return false;
        }
        return this.adI == null || eVar == null || !eVar.c(this.adI);
    }

    private boolean b(com.baidu.location.e.a aVar) {
        if (aVar == null) {
            return false;
        }
        return this.adT == null || !aVar.a(this.adT);
    }

    private void c(Message message) {
        boolean z = message.getData().getBoolean("isWaitingLocTag", false);
        if (z) {
            g = true;
        }
        if (z) {
        }
        int l = com.baidu.location.a.a.tf().l(message);
        switch (l) {
            case 1:
                d(message);
                return;
            case 2:
                g(message);
                return;
            case 3:
                if (com.baidu.location.e.d.tS().i()) {
                    e(message);
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(l)));
        }
    }

    private void d(Message message) {
        if (com.baidu.location.e.d.tS().i()) {
            e(message);
            l.tq().c();
            return;
        }
        g(message);
        l.tq().b();
    }

    private void e(Message message) {
        BDLocation bDLocation = new BDLocation(com.baidu.location.e.d.tS().f());
        if (com.baidu.location.g.g.g.equals("all") || com.baidu.location.g.g.h || com.baidu.location.g.g.j) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.z, this.y, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.adU != null) {
                    bDLocation.setAddr(this.adU);
                }
                if (this.w != null) {
                    bDLocation.setLocationDescribe(this.w);
                }
                if (this.adV != null) {
                    bDLocation.setPoiList(this.adV);
                }
            } else {
                this.A = true;
                g(null);
            }
        }
        this.k = bDLocation;
        this.adP = null;
        com.baidu.location.a.a.tf().a(bDLocation);
    }

    private void f(Message message) {
        if (!com.baidu.location.e.f.tU().g()) {
            m(message);
            return;
        }
        this.s = true;
        if (this.adY == null) {
            this.adY = new b();
        }
        if (this.K && this.adY != null) {
            this.f.removeCallbacks(this.adY);
        }
        this.f.postDelayed(this.adY, 3500L);
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
        if (com.baidu.location.e.f.tU().k()) {
            f(message);
        } else {
            m(message);
        }
    }

    private boolean k() {
        boolean z;
        BDLocation bDLocation = null;
        double random = Math.random();
        SystemClock.uptimeMillis();
        com.baidu.location.e.a tQ = com.baidu.location.e.b.tP().tQ();
        com.baidu.location.e.e tW = com.baidu.location.e.f.tU().tW();
        long f = (tW == null || tW.a() <= 0) ? 0L : tW.f();
        boolean z2 = tQ != null && tQ.e() && (tW == null || tW.a() == 0);
        if (com.baidu.location.d.d.tI().d() && com.baidu.location.d.d.tI().f() && f < 60 && (z2 || (0.0d < random && random < com.baidu.location.d.d.tI().o()))) {
            BDLocation a2 = com.baidu.location.d.d.tI().a(com.baidu.location.e.b.tP().tQ(), com.baidu.location.e.f.tU().tW(), null, d.b.IS_MIX_MODE, d.a.NEED_TO_LOG);
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
                com.baidu.location.a.a.tf().a(bDLocation2);
                this.k = bDLocation2;
                return true;
            }
            return false;
        }
        return false;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Message message) {
        long j = 0;
        long currentTimeMillis = System.currentTimeMillis() - this.t;
        if (!this.r || currentTimeMillis > 12000) {
            if (System.currentTimeMillis() - this.t > 0 && System.currentTimeMillis() - this.t < 1000) {
                if (this.k != null) {
                    com.baidu.location.a.a.tf().a(this.k);
                }
                m();
                return;
            }
            this.r = true;
            this.i = a(this.adR);
            if (!a(this.adQ) && !this.i && this.k != null && !this.A) {
                if (this.adP != null && System.currentTimeMillis() - this.u > StatisticConfig.MIN_UPLOAD_INTERVAL) {
                    this.k = this.adP;
                    this.adP = null;
                }
                if (l.tq().d()) {
                    this.k.setDirection(l.tq().e());
                }
                if (this.k.getLocType() == 62) {
                    long currentTimeMillis2 = System.currentTimeMillis() - this.adZ;
                    if (currentTimeMillis2 > 0) {
                        j = currentTimeMillis2;
                    }
                }
                if (this.k.getLocType() == 61 || this.k.getLocType() == 161 || (this.k.getLocType() == 62 && j < 15000)) {
                    com.baidu.location.a.a.tf().a(this.k);
                    m();
                    return;
                }
            }
            this.t = System.currentTimeMillis();
            String a2 = a((String) null);
            this.I = false;
            if (a2 == null) {
                this.I = true;
                this.adZ = System.currentTimeMillis();
                String[] tn = tn();
                long currentTimeMillis3 = System.currentTimeMillis();
                if (currentTimeMillis3 - this.adW > 60000) {
                    this.adW = currentTimeMillis3;
                }
                String m = com.baidu.location.e.f.tU().m();
                a2 = m != null ? m + b() + tn[0] : "" + b() + tn[0];
                if (this.adJ != null && this.adJ.h() != null) {
                    a2 = this.adJ.h() + a2;
                }
                String a3 = com.baidu.location.g.b.tZ().a(true);
                if (a3 != null) {
                    a2 = a2 + a3;
                }
            }
            if (this.j != null) {
                a2 = a2 + this.j;
                this.j = null;
            }
            this.adO.a(a2);
            this.adR = this.adJ;
            this.adQ = this.adI;
            if (!com.baidu.location.e.d.tS().i()) {
                k();
            }
            if (com.baidu.location.d.d.tI().h()) {
                if (this.adX == null) {
                    this.adX = new a();
                }
                this.f.postDelayed(this.adX, com.baidu.location.d.d.tI().a(com.baidu.location.e.c.a(com.baidu.location.e.b.tP().e())));
                this.E = true;
            }
            if (this.q) {
                this.q = false;
                com.baidu.location.b.b.ty().b();
            }
            if (this.L > 0) {
                if (this.L == 2) {
                    com.baidu.location.e.f.tU().g();
                }
                this.L = 0;
            }
        }
    }

    private void n() {
        if (this.k == null || !com.baidu.location.e.f.j()) {
            return;
        }
        q.tw().d();
    }

    public static synchronized j tm() {
        j jVar;
        synchronized (j.class) {
            if (adN == null) {
                adN = new j();
            }
            jVar = adN;
        }
        return jVar;
    }

    private String[] tn() {
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
        String g2 = com.baidu.location.e.b.tP().g();
        String h = com.baidu.location.e.f.tU().h();
        stringBuffer.append(h);
        stringBuffer.append(g2);
        stringBuffer.append(com.baidu.location.g.g.e(com.baidu.location.f.getServiceContext()));
        if (b2 == 1) {
            com.baidu.location.a.b.tg().a(62, 7, "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!");
        } else if (d.contains("0|0|")) {
            com.baidu.location.a.b.tg().a(62, 4, "Location failed beacuse we can not get any loc information without any location permission!");
        } else if (z) {
            com.baidu.location.a.b.tg().a(62, 5, "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!");
        } else if (g2 == null || h == null || !g2.equals("&sim=1") || h.equals("&wifio=1")) {
            com.baidu.location.a.b.tg().a(62, 9, "Location failed beacuse we can not get any loc information!");
        } else {
            com.baidu.location.a.b.tg().a(62, 6, "Location failed beacuse we can not get any loc information , you can insert a sim card or open wifi and try again!");
        }
        strArr[0] = stringBuffer.toString();
        return strArr;
    }

    @Override // com.baidu.location.a.h
    public void a() {
        BDLocation bDLocation;
        BDLocation bDLocation2;
        if (this.adX != null && this.E) {
            this.E = false;
            this.f.removeCallbacks(this.adX);
        }
        if (com.baidu.location.e.d.tS().i()) {
            BDLocation bDLocation3 = new BDLocation(com.baidu.location.e.d.tS().f());
            if (com.baidu.location.g.g.g.equals("all") || com.baidu.location.g.g.h || com.baidu.location.g.g.j) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.z, this.y, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.adU != null) {
                        bDLocation3.setAddr(this.adU);
                    }
                    if (this.w != null) {
                        bDLocation3.setLocationDescribe(this.w);
                    }
                    if (this.adV != null) {
                        bDLocation3.setPoiList(this.adV);
                    }
                }
            }
            com.baidu.location.a.a.tf().a(bDLocation3);
            m();
        } else if (this.F) {
            m();
        } else {
            if (com.baidu.location.d.d.tI().d() && com.baidu.location.d.d.tI().e()) {
                bDLocation = com.baidu.location.d.d.tI().a(com.baidu.location.e.b.tP().tQ(), com.baidu.location.e.f.tU().tW(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
                if (bDLocation != null && bDLocation.getLocType() == 66) {
                    com.baidu.location.a.a.tf().a(bDLocation);
                }
            } else {
                bDLocation = null;
            }
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                if (this.i || this.k == null) {
                    if (com.baidu.location.d.a.tD().a) {
                        bDLocation2 = com.baidu.location.d.a.tD().aM(false);
                    } else if (bDLocation == null) {
                        BDLocation bDLocation4 = new BDLocation();
                        bDLocation4.setLocType(67);
                        bDLocation2 = bDLocation4;
                    } else {
                        bDLocation2 = bDLocation;
                    }
                    if (bDLocation2 != null) {
                        com.baidu.location.a.a.tf().a(bDLocation2);
                        if (bDLocation2.getLocType() == 67 && !this.I) {
                            com.baidu.location.a.b.tg().a(67, 3, "Offline location failed, please check the net (wifi/cell)!");
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
                    com.baidu.location.a.a.tf().a(this.k);
                }
            }
            this.adP = null;
            m();
        }
    }

    @Override // com.baidu.location.a.h
    public void a(Message message) {
        if (this.adX != null && this.E) {
            this.E = false;
            this.f.removeCallbacks(this.adX);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        if (bDLocation != null && bDLocation.getLocType() == 167 && this.I) {
            bDLocation.setLocType(62);
        }
        b(bDLocation);
    }

    public void a(boolean z, boolean z2) {
        BDLocation bDLocation = null;
        if (com.baidu.location.d.d.tI().d() && com.baidu.location.d.d.tI().g()) {
            bDLocation = com.baidu.location.d.d.tI().a(com.baidu.location.e.b.tP().tQ(), com.baidu.location.e.f.tU().tW(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
            if ((bDLocation == null || bDLocation.getLocType() == 67) && z && com.baidu.location.d.a.tD().a) {
                bDLocation = com.baidu.location.d.a.tD().aM(false);
            }
        } else if (z && com.baidu.location.d.a.tD().a) {
            bDLocation = com.baidu.location.d.a.tD().aM(false);
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
            com.baidu.location.a.a.tf().a(bDLocation);
        }
    }

    public void b(Message message) {
        if (this.H) {
            c(message);
        }
    }

    public void b(BDLocation bDLocation) {
        String h;
        int c;
        boolean z = true;
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            this.adU = bDLocation.getAddress();
            this.y = bDLocation.getLongitude();
            this.z = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.w = bDLocation.getLocationDescribe();
            this.y = bDLocation.getLongitude();
            this.z = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.adV = bDLocation.getPoiList();
            this.y = bDLocation.getLongitude();
            this.z = bDLocation.getLatitude();
        }
        if (com.baidu.location.e.d.tS().i()) {
            BDLocation bDLocation3 = new BDLocation(com.baidu.location.e.d.tS().f());
            if (com.baidu.location.g.g.g.equals("all") || com.baidu.location.g.g.h || com.baidu.location.g.g.j) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.z, this.y, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.adU != null) {
                        bDLocation3.setAddr(this.adU);
                    }
                    if (this.w != null) {
                        bDLocation3.setLocationDescribe(this.w);
                    }
                    if (this.adV != null) {
                        bDLocation3.setPoiList(this.adV);
                    }
                }
            }
            com.baidu.location.a.a.tf().a(bDLocation3);
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
                    com.baidu.location.a.a.tf().a(bDLocation);
                }
            } else if (bDLocation.getUserIndoorState() > -1) {
                this.k = bDLocation;
                com.baidu.location.a.a.tf().a(bDLocation);
            }
            m();
        } else {
            if (bDLocation.getLocType() == 167) {
                com.baidu.location.a.b.tg().a(BDLocation.TypeServerError, 8, "NetWork location failed because baidu location service can not caculate the location!");
            } else if (bDLocation.getLocType() == 161) {
                if (Build.VERSION.SDK_INT >= 19 && ((c = com.baidu.location.g.g.c(com.baidu.location.f.getServiceContext())) == 0 || c == 2)) {
                    com.baidu.location.a.b.tg().a(BDLocation.TypeNetWorkLocation, 1, "NetWork location successful, open gps will be better!");
                } else if (bDLocation.getRadius() >= 100.0f && bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals(Config.CELL_LOCATION) && (h = com.baidu.location.e.f.tU().h()) != null && !h.equals("&wifio=1")) {
                    com.baidu.location.a.b.tg().a(BDLocation.TypeNetWorkLocation, 2, "NetWork location successful, open wifi will be better!");
                }
            }
            this.adP = null;
            if (bDLocation.getLocType() == 161 && Config.CELL_LOCATION.equals(bDLocation.getNetworkLocationType()) && this.k != null && this.k.getLocType() == 161 && "wf".equals(this.k.getNetworkLocationType()) && System.currentTimeMillis() - this.u < StatisticConfig.MIN_UPLOAD_INTERVAL) {
                this.adP = bDLocation;
            } else {
                z = false;
            }
            if (z) {
                com.baidu.location.a.a.tf().a(this.k);
            } else {
                com.baidu.location.a.a.tf().a(bDLocation);
                this.u = System.currentTimeMillis();
            }
            if (!com.baidu.location.g.g.g(bDLocation)) {
                this.k = null;
            } else if (!z) {
                this.k = bDLocation;
            }
            int m = com.baidu.location.g.g.m(c, "ssid\":\"", "\"");
            if (m == Integer.MIN_VALUE || this.adQ == null) {
                this.j = null;
            } else {
                this.j = this.adQ.bJ(m);
            }
            if (com.baidu.location.d.d.tI().d() && bDLocation.getLocType() == 161 && Config.CELL_LOCATION.equals(bDLocation.getNetworkLocationType()) && b(this.adR)) {
                com.baidu.location.d.d.tI().a(this.adR, null, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.adT = this.adR;
            }
            if (com.baidu.location.d.d.tI().d() && bDLocation.getLocType() == 161 && "wf".equals(bDLocation.getNetworkLocationType())) {
                com.baidu.location.d.d.tI().a(null, this.adQ, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.adS = this.adQ;
            }
            if (this.adR != null) {
                com.baidu.location.d.a.tD().a(c, this.adR, this.adQ, bDLocation2);
            }
            if (com.baidu.location.e.f.j()) {
                com.baidu.location.d.d.tI().i();
                com.baidu.location.d.d.tI().m();
            }
            m();
        }
    }

    public void c(BDLocation bDLocation) {
        this.k = new BDLocation(bDLocation);
    }

    public Address d(BDLocation bDLocation) {
        if (com.baidu.location.g.g.g.equals("all") || com.baidu.location.g.g.h || com.baidu.location.g.g.j) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.z, this.y, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] >= 100.0f) {
                this.w = null;
                this.adV = null;
                this.A = true;
                this.f.post(new Runnable() { // from class: com.baidu.location.a.j.1
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.g(null);
                    }
                });
            } else if (this.adU != null) {
                return this.adU;
            }
        }
        return null;
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
        return this.adV;
    }

    public boolean h() {
        return this.i;
    }

    public void i() {
        if (!this.s) {
            com.baidu.location.b.b.ty().d();
            return;
        }
        m(null);
        this.s = false;
    }

    public void j() {
        this.k = null;
    }
}
