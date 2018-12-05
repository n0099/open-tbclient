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
    private static j adE = null;
    public static boolean g = false;
    public h.b adF;
    private double y;
    private double z;
    private boolean i = true;
    private String j = null;
    private BDLocation k = null;
    private BDLocation adG = null;
    private com.baidu.location.e.e adH = null;
    private com.baidu.location.e.a adI = null;
    private com.baidu.location.e.e adJ = null;
    private com.baidu.location.e.a adK = null;
    private boolean q = true;
    private volatile boolean r = false;
    private boolean s = false;
    private long t = 0;
    private long u = 0;
    private Address adL = null;
    private String w = null;
    private List<Poi> adM = null;
    private boolean A = false;
    private long adN = 0;
    private long C = 0;
    private a adO = null;
    private boolean E = false;
    private boolean F = false;
    private boolean G = true;
    public final Handler f = new h.a();
    private boolean H = false;
    private boolean I = false;
    private b adP = null;
    private boolean K = false;
    private int L = 0;
    private long adQ = 0;
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
                if (j.this.F || com.baidu.location.e.d.tO().i()) {
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
        this.adF = null;
        this.adF = new h.b();
    }

    private boolean a(com.baidu.location.e.a aVar) {
        this.adA = com.baidu.location.e.b.tL().tM();
        if (this.adA == aVar) {
            return false;
        }
        return this.adA == null || aVar == null || !aVar.a(this.adA);
    }

    private boolean a(com.baidu.location.e.e eVar) {
        this.adz = com.baidu.location.e.f.tQ().tT();
        if (eVar == this.adz) {
            return false;
        }
        return this.adz == null || eVar == null || !eVar.c(this.adz);
    }

    private boolean b(com.baidu.location.e.a aVar) {
        if (aVar == null) {
            return false;
        }
        return this.adK == null || !aVar.a(this.adK);
    }

    private void c(Message message) {
        boolean z = message.getData().getBoolean("isWaitingLocTag", false);
        if (z) {
            g = true;
        }
        if (z) {
        }
        int l = com.baidu.location.a.a.tb().l(message);
        switch (l) {
            case 1:
                d(message);
                return;
            case 2:
                g(message);
                return;
            case 3:
                if (com.baidu.location.e.d.tO().i()) {
                    e(message);
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(l)));
        }
    }

    private void d(Message message) {
        if (com.baidu.location.e.d.tO().i()) {
            e(message);
            l.tl().c();
            return;
        }
        g(message);
        l.tl().b();
    }

    private void e(Message message) {
        BDLocation bDLocation = new BDLocation(com.baidu.location.e.d.tO().f());
        if (com.baidu.location.g.g.g.equals("all") || com.baidu.location.g.g.h || com.baidu.location.g.g.j) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.z, this.y, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.adL != null) {
                    bDLocation.setAddr(this.adL);
                }
                if (this.w != null) {
                    bDLocation.setLocationDescribe(this.w);
                }
                if (this.adM != null) {
                    bDLocation.setPoiList(this.adM);
                }
            } else {
                this.A = true;
                g(null);
            }
        }
        this.k = bDLocation;
        this.adG = null;
        com.baidu.location.a.a.tb().a(bDLocation);
    }

    private void f(Message message) {
        if (!com.baidu.location.e.f.tQ().g()) {
            m(message);
            return;
        }
        this.s = true;
        if (this.adP == null) {
            this.adP = new b();
        }
        if (this.K && this.adP != null) {
            this.f.removeCallbacks(this.adP);
        }
        this.f.postDelayed(this.adP, 3500L);
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
        if (com.baidu.location.e.f.tQ().k()) {
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
        com.baidu.location.e.a tM = com.baidu.location.e.b.tL().tM();
        com.baidu.location.e.e tS = com.baidu.location.e.f.tQ().tS();
        long f = (tS == null || tS.a() <= 0) ? 0L : tS.f();
        boolean z2 = tM != null && tM.e() && (tS == null || tS.a() == 0);
        if (com.baidu.location.d.d.tE().d() && com.baidu.location.d.d.tE().f() && f < 60 && (z2 || (0.0d < random && random < com.baidu.location.d.d.tE().o()))) {
            BDLocation a2 = com.baidu.location.d.d.tE().a(com.baidu.location.e.b.tL().tM(), com.baidu.location.e.f.tQ().tS(), null, d.b.IS_MIX_MODE, d.a.NEED_TO_LOG);
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
                com.baidu.location.a.a.tb().a(bDLocation2);
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
                    com.baidu.location.a.a.tb().a(this.k);
                }
                m();
                return;
            }
            this.r = true;
            this.i = a(this.adI);
            if (!a(this.adH) && !this.i && this.k != null && !this.A) {
                if (this.adG != null && System.currentTimeMillis() - this.u > StatisticConfig.MIN_UPLOAD_INTERVAL) {
                    this.k = this.adG;
                    this.adG = null;
                }
                if (l.tl().d()) {
                    this.k.setDirection(l.tl().e());
                }
                if (this.k.getLocType() == 62) {
                    long currentTimeMillis2 = System.currentTimeMillis() - this.adQ;
                    if (currentTimeMillis2 > 0) {
                        j = currentTimeMillis2;
                    }
                }
                if (this.k.getLocType() == 61 || this.k.getLocType() == 161 || (this.k.getLocType() == 62 && j < 15000)) {
                    com.baidu.location.a.a.tb().a(this.k);
                    m();
                    return;
                }
            }
            this.t = System.currentTimeMillis();
            String a2 = a((String) null);
            this.I = false;
            if (a2 == null) {
                this.I = true;
                this.adQ = System.currentTimeMillis();
                String[] tj = tj();
                long currentTimeMillis3 = System.currentTimeMillis();
                if (currentTimeMillis3 - this.adN > 60000) {
                    this.adN = currentTimeMillis3;
                }
                String m = com.baidu.location.e.f.tQ().m();
                a2 = m != null ? m + b() + tj[0] : "" + b() + tj[0];
                if (this.adA != null && this.adA.h() != null) {
                    a2 = this.adA.h() + a2;
                }
                String a3 = com.baidu.location.g.b.tV().a(true);
                if (a3 != null) {
                    a2 = a2 + a3;
                }
            }
            if (this.j != null) {
                a2 = a2 + this.j;
                this.j = null;
            }
            this.adF.a(a2);
            this.adI = this.adA;
            this.adH = this.adz;
            if (!com.baidu.location.e.d.tO().i()) {
                k();
            }
            if (com.baidu.location.d.d.tE().h()) {
                if (this.adO == null) {
                    this.adO = new a();
                }
                this.f.postDelayed(this.adO, com.baidu.location.d.d.tE().a(com.baidu.location.e.c.a(com.baidu.location.e.b.tL().e())));
                this.E = true;
            }
            if (this.q) {
                this.q = false;
                com.baidu.location.b.b.tu().b();
            }
            if (this.L > 0) {
                if (this.L == 2) {
                    com.baidu.location.e.f.tQ().g();
                }
                this.L = 0;
            }
        }
    }

    private void n() {
        if (this.k == null || !com.baidu.location.e.f.j()) {
            return;
        }
        q.ts().d();
    }

    public static synchronized j ti() {
        j jVar;
        synchronized (j.class) {
            if (adE == null) {
                adE = new j();
            }
            jVar = adE;
        }
        return jVar;
    }

    private String[] tj() {
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
        String g2 = com.baidu.location.e.b.tL().g();
        String h = com.baidu.location.e.f.tQ().h();
        stringBuffer.append(h);
        stringBuffer.append(g2);
        stringBuffer.append(com.baidu.location.g.g.e(com.baidu.location.f.getServiceContext()));
        if (b2 == 1) {
            com.baidu.location.a.b.tc().a(62, 7, "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!");
        } else if (d.contains("0|0|")) {
            com.baidu.location.a.b.tc().a(62, 4, "Location failed beacuse we can not get any loc information without any location permission!");
        } else if (z) {
            com.baidu.location.a.b.tc().a(62, 5, "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!");
        } else if (g2 == null || h == null || !g2.equals("&sim=1") || h.equals("&wifio=1")) {
            com.baidu.location.a.b.tc().a(62, 9, "Location failed beacuse we can not get any loc information!");
        } else {
            com.baidu.location.a.b.tc().a(62, 6, "Location failed beacuse we can not get any loc information , you can insert a sim card or open wifi and try again!");
        }
        strArr[0] = stringBuffer.toString();
        return strArr;
    }

    @Override // com.baidu.location.a.h
    public void a() {
        BDLocation bDLocation;
        BDLocation bDLocation2;
        if (this.adO != null && this.E) {
            this.E = false;
            this.f.removeCallbacks(this.adO);
        }
        if (com.baidu.location.e.d.tO().i()) {
            BDLocation bDLocation3 = new BDLocation(com.baidu.location.e.d.tO().f());
            if (com.baidu.location.g.g.g.equals("all") || com.baidu.location.g.g.h || com.baidu.location.g.g.j) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.z, this.y, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.adL != null) {
                        bDLocation3.setAddr(this.adL);
                    }
                    if (this.w != null) {
                        bDLocation3.setLocationDescribe(this.w);
                    }
                    if (this.adM != null) {
                        bDLocation3.setPoiList(this.adM);
                    }
                }
            }
            com.baidu.location.a.a.tb().a(bDLocation3);
            m();
        } else if (this.F) {
            m();
        } else {
            if (com.baidu.location.d.d.tE().d() && com.baidu.location.d.d.tE().e()) {
                bDLocation = com.baidu.location.d.d.tE().a(com.baidu.location.e.b.tL().tM(), com.baidu.location.e.f.tQ().tS(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
                if (bDLocation != null && bDLocation.getLocType() == 66) {
                    com.baidu.location.a.a.tb().a(bDLocation);
                }
            } else {
                bDLocation = null;
            }
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                if (this.i || this.k == null) {
                    if (com.baidu.location.d.a.tz().a) {
                        bDLocation2 = com.baidu.location.d.a.tz().aM(false);
                    } else if (bDLocation == null) {
                        BDLocation bDLocation4 = new BDLocation();
                        bDLocation4.setLocType(67);
                        bDLocation2 = bDLocation4;
                    } else {
                        bDLocation2 = bDLocation;
                    }
                    if (bDLocation2 != null) {
                        com.baidu.location.a.a.tb().a(bDLocation2);
                        if (bDLocation2.getLocType() == 67 && !this.I) {
                            com.baidu.location.a.b.tc().a(67, 3, "Offline location failed, please check the net (wifi/cell)!");
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
                    com.baidu.location.a.a.tb().a(this.k);
                }
            }
            this.adG = null;
            m();
        }
    }

    @Override // com.baidu.location.a.h
    public void a(Message message) {
        if (this.adO != null && this.E) {
            this.E = false;
            this.f.removeCallbacks(this.adO);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        if (bDLocation != null && bDLocation.getLocType() == 167 && this.I) {
            bDLocation.setLocType(62);
        }
        b(bDLocation);
    }

    public void a(boolean z, boolean z2) {
        BDLocation bDLocation = null;
        if (com.baidu.location.d.d.tE().d() && com.baidu.location.d.d.tE().g()) {
            bDLocation = com.baidu.location.d.d.tE().a(com.baidu.location.e.b.tL().tM(), com.baidu.location.e.f.tQ().tS(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
            if ((bDLocation == null || bDLocation.getLocType() == 67) && z && com.baidu.location.d.a.tz().a) {
                bDLocation = com.baidu.location.d.a.tz().aM(false);
            }
        } else if (z && com.baidu.location.d.a.tz().a) {
            bDLocation = com.baidu.location.d.a.tz().aM(false);
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
            com.baidu.location.a.a.tb().a(bDLocation);
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
            this.adL = bDLocation.getAddress();
            this.y = bDLocation.getLongitude();
            this.z = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.w = bDLocation.getLocationDescribe();
            this.y = bDLocation.getLongitude();
            this.z = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.adM = bDLocation.getPoiList();
            this.y = bDLocation.getLongitude();
            this.z = bDLocation.getLatitude();
        }
        if (com.baidu.location.e.d.tO().i()) {
            BDLocation bDLocation3 = new BDLocation(com.baidu.location.e.d.tO().f());
            if (com.baidu.location.g.g.g.equals("all") || com.baidu.location.g.g.h || com.baidu.location.g.g.j) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.z, this.y, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.adL != null) {
                        bDLocation3.setAddr(this.adL);
                    }
                    if (this.w != null) {
                        bDLocation3.setLocationDescribe(this.w);
                    }
                    if (this.adM != null) {
                        bDLocation3.setPoiList(this.adM);
                    }
                }
            }
            com.baidu.location.a.a.tb().a(bDLocation3);
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
                    com.baidu.location.a.a.tb().a(bDLocation);
                }
            } else if (bDLocation.getUserIndoorState() > -1) {
                this.k = bDLocation;
                com.baidu.location.a.a.tb().a(bDLocation);
            }
            m();
        } else {
            if (bDLocation.getLocType() == 167) {
                com.baidu.location.a.b.tc().a(BDLocation.TypeServerError, 8, "NetWork location failed because baidu location service can not caculate the location!");
            } else if (bDLocation.getLocType() == 161) {
                if (Build.VERSION.SDK_INT >= 19 && ((c = com.baidu.location.g.g.c(com.baidu.location.f.getServiceContext())) == 0 || c == 2)) {
                    com.baidu.location.a.b.tc().a(BDLocation.TypeNetWorkLocation, 1, "NetWork location successful, open gps will be better!");
                } else if (bDLocation.getRadius() >= 100.0f && bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals(Config.CELL_LOCATION) && (h = com.baidu.location.e.f.tQ().h()) != null && !h.equals("&wifio=1")) {
                    com.baidu.location.a.b.tc().a(BDLocation.TypeNetWorkLocation, 2, "NetWork location successful, open wifi will be better!");
                }
            }
            this.adG = null;
            if (bDLocation.getLocType() == 161 && Config.CELL_LOCATION.equals(bDLocation.getNetworkLocationType()) && this.k != null && this.k.getLocType() == 161 && "wf".equals(this.k.getNetworkLocationType()) && System.currentTimeMillis() - this.u < StatisticConfig.MIN_UPLOAD_INTERVAL) {
                this.adG = bDLocation;
            } else {
                z = false;
            }
            if (z) {
                com.baidu.location.a.a.tb().a(this.k);
            } else {
                com.baidu.location.a.a.tb().a(bDLocation);
                this.u = System.currentTimeMillis();
            }
            if (!com.baidu.location.g.g.g(bDLocation)) {
                this.k = null;
            } else if (!z) {
                this.k = bDLocation;
            }
            int m = com.baidu.location.g.g.m(c, "ssid\":\"", "\"");
            if (m == Integer.MIN_VALUE || this.adH == null) {
                this.j = null;
            } else {
                this.j = this.adH.bJ(m);
            }
            if (com.baidu.location.d.d.tE().d() && bDLocation.getLocType() == 161 && Config.CELL_LOCATION.equals(bDLocation.getNetworkLocationType()) && b(this.adI)) {
                com.baidu.location.d.d.tE().a(this.adI, null, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.adK = this.adI;
            }
            if (com.baidu.location.d.d.tE().d() && bDLocation.getLocType() == 161 && "wf".equals(bDLocation.getNetworkLocationType())) {
                com.baidu.location.d.d.tE().a(null, this.adH, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.adJ = this.adH;
            }
            if (this.adI != null) {
                com.baidu.location.d.a.tz().a(c, this.adI, this.adH, bDLocation2);
            }
            if (com.baidu.location.e.f.j()) {
                com.baidu.location.d.d.tE().i();
                com.baidu.location.d.d.tE().m();
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
                this.adM = null;
                this.A = true;
                this.f.post(new Runnable() { // from class: com.baidu.location.a.j.1
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.g(null);
                    }
                });
            } else if (this.adL != null) {
                return this.adL;
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
        return this.adM;
    }

    public boolean h() {
        return this.i;
    }

    public void i() {
        if (!this.s) {
            com.baidu.location.b.b.tu().d();
            return;
        }
        m(null);
        this.s = false;
    }

    public void j() {
        this.k = null;
    }
}
