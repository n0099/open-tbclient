package com.baidu.location.a;

import android.location.Location;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Poi;
import com.baidu.location.a.d;
import com.baidu.location.e.d;
import com.baidu.tbadk.TbConfig;
import java.util.List;
/* loaded from: classes.dex */
public class e extends d {
    private static e FI = null;
    public static boolean h = false;
    public d.b FJ;
    private double FV;
    private double z;
    final int e = 1000;
    private boolean j = true;
    private String k = null;
    private BDLocation FK = null;
    private BDLocation FL = null;
    private com.baidu.location.f.i FM = null;
    private com.baidu.location.f.a FN = null;
    private com.baidu.location.f.i FO = null;
    private com.baidu.location.f.a FP = null;
    private boolean r = true;
    private volatile boolean s = false;
    private boolean t = false;
    private long FQ = 0;
    private long FR = 0;
    private Address FT = null;
    private String x = null;
    private List<Poi> FU = null;
    private boolean B = false;
    private long FW = 0;
    private long FX = 0;
    private a FY = null;
    private boolean F = false;
    private boolean G = false;
    private boolean FZ = true;
    public final Handler g = new d.a();
    private boolean Ga = false;
    private b Gb = null;
    private boolean Gc = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.F) {
                e.this.F = false;
                if (e.this.G) {
                    return;
                }
                e.this.a(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.Gc) {
                e.this.Gc = false;
            }
            if (e.this.t) {
                e.this.t = false;
                e.this.j(null);
            }
        }
    }

    private e() {
        this.FJ = null;
        this.FJ = new d.b();
    }

    private boolean a(com.baidu.location.f.a aVar) {
        this.FF = com.baidu.location.f.c.mr().mn();
        if (this.FF == aVar) {
            return false;
        }
        return this.FF == null || aVar == null || !aVar.a(this.FF);
    }

    private boolean a(com.baidu.location.f.i iVar) {
        this.FE = com.baidu.location.f.k.mA().my();
        if (iVar == this.FE) {
            return false;
        }
        return this.FE == null || iVar == null || !iVar.c(this.FE);
    }

    private boolean b(com.baidu.location.f.a aVar) {
        if (aVar == null) {
            return false;
        }
        return this.FP == null || !aVar.a(this.FP);
    }

    private void c(Message message) {
        boolean z = message.getData().getBoolean("isWaitingLocTag", false);
        if (z) {
            h = true;
        }
        if (z) {
        }
        int e = com.baidu.location.a.a.lw().e(message);
        f.lz().d();
        switch (e) {
            case 1:
                g(message);
                return;
            case 2:
                i(message);
                return;
            case 3:
                if (com.baidu.location.f.f.mu().i()) {
                    h(message);
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(e)));
        }
    }

    private void g(Message message) {
        if (com.baidu.location.f.f.mu().i()) {
            h(message);
            f.lz().c();
            return;
        }
        i(message);
        f.lz().b();
    }

    private void h(Message message) {
        BDLocation bDLocation = new BDLocation(com.baidu.location.f.f.mu().f());
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.FV, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.FT != null) {
                    bDLocation.setAddr(this.FT);
                }
                if (this.x != null) {
                    bDLocation.setLocationDescribe(this.x);
                }
                if (this.FU != null) {
                    bDLocation.setPoiList(this.FU);
                }
            } else {
                this.B = true;
                i(null);
            }
        }
        this.FK = bDLocation;
        this.FL = null;
        com.baidu.location.a.a.lw().a(bDLocation);
    }

    private void i(Message message) {
        if (this.r) {
            this.FX = SystemClock.uptimeMillis();
            j(message);
        } else if (this.s) {
        } else {
            this.FX = SystemClock.uptimeMillis();
            if (!com.baidu.location.f.k.mA().e()) {
                j(message);
                return;
            }
            this.t = true;
            if (this.Gb == null) {
                this.Gb = new b();
            }
            if (this.Gc && this.Gb != null) {
                this.g.removeCallbacks(this.Gb);
            }
            this.g.postDelayed(this.Gb, 3500L);
            this.Gc = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Message message) {
        if (this.s) {
            return;
        }
        if (System.currentTimeMillis() - this.FQ < 1000 && this.FK != null) {
            com.baidu.location.a.a.lw().a(this.FK);
            k();
            return;
        }
        if (this.FX > 0) {
            com.baidu.location.c.f.lR().lS().a(this.FX);
        } else {
            com.baidu.location.c.f.lR().lS().a(SystemClock.uptimeMillis());
        }
        this.s = true;
        this.j = a(this.FN);
        if (!a(this.FM) && !this.j && this.FK != null && !this.B) {
            if (this.FL != null && System.currentTimeMillis() - this.FR > 30000) {
                this.FK = this.FL;
                this.FL = null;
            }
            if (f.lz().f()) {
                this.FK.setDirection(f.lz().lB());
            }
            com.baidu.location.a.a.lw().a(this.FK);
            k();
            return;
        }
        this.FQ = System.currentTimeMillis();
        String a2 = a((String) null);
        if (a2 == null) {
            if (this.FK != null) {
                com.baidu.location.a.a.lw().a(this.FK);
                k();
                return;
            }
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLocType(62);
            com.baidu.location.a.a.lw().a(bDLocation);
            k();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.FW > TbConfig.USE_TIME_INTERVAL) {
                this.FW = currentTimeMillis;
                com.baidu.location.c.f.lR().a("TypeCriteriaException");
                return;
            }
            return;
        }
        if (this.k != null) {
            a2 = a2 + this.k;
            this.k = null;
        }
        com.baidu.location.c.f.lR().lS().b(SystemClock.uptimeMillis());
        this.FJ.a(a2);
        this.FN = this.FF;
        this.FM = this.FE;
        if (j()) {
            this.FN = this.FF;
            this.FM = this.FE;
        }
        if (com.baidu.location.e.d.lV().h()) {
            if (this.FY == null) {
                this.FY = new a();
            }
            this.g.postDelayed(this.FY, com.baidu.location.e.d.lV().a(com.baidu.location.f.c.a(com.baidu.location.f.c.mr().e())));
            this.F = true;
        }
        if (this.r) {
            this.r = false;
            if (com.baidu.location.f.k.mA().g() && message != null && com.baidu.location.a.a.lw().f(message) < 1000 && com.baidu.location.e.d.lV().d()) {
                com.baidu.location.e.d.lV().i();
            }
            com.baidu.location.c.a.lM().b();
        }
    }

    private boolean j() {
        BDLocation bDLocation = null;
        double random = Math.random();
        long uptimeMillis = SystemClock.uptimeMillis();
        com.baidu.location.f.a mn = com.baidu.location.f.c.mr().mn();
        com.baidu.location.f.i mx = com.baidu.location.f.k.mA().mx();
        boolean z = mn != null && mn.e() && (mx == null || mx.a() == 0);
        if (com.baidu.location.e.d.lV().d() && com.baidu.location.e.d.lV().f() && (z || (0.0d < random && random < com.baidu.location.e.d.lV().mb()))) {
            bDLocation = com.baidu.location.e.d.lV().a(com.baidu.location.f.c.mr().mn(), com.baidu.location.f.k.mA().mx(), null, d.b.IS_MIX_MODE, d.a.NEED_TO_LOG);
        }
        if (bDLocation != null && bDLocation.getLocType() == 66 && this.s) {
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            bDLocation2.setLocType(BDLocation.TypeNetWorkLocation);
            if (this.s) {
                com.baidu.location.c.g gVar = new com.baidu.location.c.g();
                gVar.a(this.FX);
                gVar.b(uptimeMillis);
                gVar.c(uptimeMillis);
                gVar.l(SystemClock.uptimeMillis());
                gVar.a("ofs");
                if (this.FN != null) {
                    gVar.b(this.FN.h());
                    gVar.b("&offtag=1");
                }
                com.baidu.location.c.f.lR().a(gVar);
                this.G = true;
                com.baidu.location.a.a.lw().a(bDLocation2);
                this.FK = bDLocation2;
                return true;
            }
            return false;
        }
        return false;
    }

    private void k() {
        this.s = false;
        this.G = false;
        this.FZ = false;
        this.B = false;
        l();
    }

    private void l() {
        if (this.FK != null) {
            j.lI().c();
        }
    }

    public static synchronized e ly() {
        e eVar;
        synchronized (e.class) {
            if (FI == null) {
                FI = new e();
            }
            eVar = FI;
        }
        return eVar;
    }

    @Override // com.baidu.location.a.d
    public void a() {
        BDLocation bDLocation;
        if (this.FY != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.FY);
        }
        if (com.baidu.location.f.f.mu().i()) {
            BDLocation bDLocation2 = new BDLocation(com.baidu.location.f.f.mu().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.FV, this.z, bDLocation2.getLatitude(), bDLocation2.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.FT != null) {
                        bDLocation2.setAddr(this.FT);
                    }
                    if (this.x != null) {
                        bDLocation2.setLocationDescribe(this.x);
                    }
                    if (this.FU != null) {
                        bDLocation2.setPoiList(this.FU);
                    }
                }
            }
            com.baidu.location.a.a.lw().a(bDLocation2);
            k();
        } else if (this.G) {
            k();
        } else {
            com.baidu.location.c.f.lR().lS().c(SystemClock.uptimeMillis());
            if (com.baidu.location.e.d.lV().d() && com.baidu.location.e.d.lV().e()) {
                bDLocation = com.baidu.location.e.d.lV().a(com.baidu.location.f.c.mr().mn(), com.baidu.location.f.k.mA().mx(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
                if (bDLocation != null && bDLocation.getLocType() == 66) {
                    com.baidu.location.a.a.lw().a(bDLocation);
                }
            } else {
                bDLocation = null;
            }
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                if (this.j || this.FK == null) {
                    BDLocation X = com.baidu.location.e.a.lU().X(false);
                    com.baidu.location.a.a.lw().a(X);
                    boolean z = true;
                    if (com.baidu.location.h.i.f.equals("all") && X.getAddrStr() == null) {
                        z = false;
                    }
                    if (com.baidu.location.h.i.g && X.getLocationDescribe() == null) {
                        z = false;
                    }
                    if (com.baidu.location.h.i.h && X.getPoiList() == null) {
                        z = false;
                    }
                    if (!z) {
                        X.setLocType(67);
                    }
                    bDLocation = X;
                } else {
                    com.baidu.location.a.a.lw().a(this.FK);
                }
            }
            com.baidu.location.c.f.lR().lS().l(SystemClock.uptimeMillis());
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                this.FK = null;
                com.baidu.location.c.f.lR().lS().a("off");
                if (this.FN != null) {
                    com.baidu.location.c.f.lR().lS().b(this.FN.h());
                }
                com.baidu.location.c.f.lR().c();
            } else {
                this.FK = bDLocation;
                com.baidu.location.c.f.lR().lS().a("ofs");
                if (this.FN != null) {
                    com.baidu.location.c.f.lR().lS().b(this.FN.h());
                }
                com.baidu.location.c.f.lR().c();
            }
            this.FL = null;
            k();
        }
    }

    @Override // com.baidu.location.a.d
    public void a(Message message) {
        boolean z;
        if (this.FY != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.FY);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            this.FT = bDLocation.getAddress();
            this.z = bDLocation.getLongitude();
            this.FV = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.x = bDLocation.getLocationDescribe();
            this.z = bDLocation.getLongitude();
            this.FV = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.FU = bDLocation.getPoiList();
            this.z = bDLocation.getLongitude();
            this.FV = bDLocation.getLatitude();
        }
        if (com.baidu.location.f.f.mu().i()) {
            BDLocation bDLocation3 = new BDLocation(com.baidu.location.f.f.mu().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.FV, this.z, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.FT != null) {
                        bDLocation3.setAddr(this.FT);
                    }
                    if (this.x != null) {
                        bDLocation3.setLocationDescribe(this.x);
                    }
                    if (this.FU != null) {
                        bDLocation3.setPoiList(this.FU);
                    }
                }
            }
            com.baidu.location.a.a.lw().a(bDLocation3);
            k();
        } else if (bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("sky")) {
            bDLocation.setNetworkLocationType("wf");
            com.baidu.location.a.a.lw().a(bDLocation);
            this.FR = System.currentTimeMillis();
            this.FK = bDLocation;
        } else if (this.G) {
            float[] fArr2 = new float[2];
            if (this.FK != null) {
                Location.distanceBetween(this.FK.getLatitude(), this.FK.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
            }
            if (fArr2[0] > 10.0f) {
                this.FK = bDLocation;
                if (!this.FZ) {
                    this.FZ = false;
                    com.baidu.location.a.a.lw().a(bDLocation);
                }
            }
            k();
        } else {
            com.baidu.location.c.f.lR().lS().c(SystemClock.uptimeMillis());
            this.FL = null;
            if (bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && this.FK != null && this.FK.getLocType() == 161 && "wf".equals(this.FK.getNetworkLocationType()) && System.currentTimeMillis() - this.FR < 30000) {
                z = true;
                this.FL = bDLocation;
            } else {
                z = false;
            }
            if (z) {
                com.baidu.location.a.a.lw().a(this.FK);
            } else {
                com.baidu.location.a.a.lw().a(bDLocation);
                this.FR = System.currentTimeMillis();
                com.baidu.location.c.f.lR().lS().l(SystemClock.uptimeMillis());
                if (bDLocation.getLocType() == 161) {
                    com.baidu.location.c.f.lR().lS().a("ons");
                    if (this.FN != null) {
                        com.baidu.location.c.f.lR().lS().b(this.FN.h());
                    }
                } else {
                    com.baidu.location.c.f.lR().lS().a("onf");
                    if (this.FN != null) {
                        com.baidu.location.c.f.lR().lS().b(this.FN.h());
                    }
                    com.baidu.location.c.f.lR().c();
                }
            }
            if (!com.baidu.location.h.i.d(bDLocation)) {
                this.FK = null;
            } else if (!z) {
                this.FK = bDLocation;
            }
            int o = com.baidu.location.h.i.o(c, "ssid\":\"", "\"");
            if (o == Integer.MIN_VALUE || this.FM == null) {
                this.k = null;
            } else {
                this.k = this.FM.c(o);
            }
            if (com.baidu.location.e.d.lV().d() && bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && b(this.FN)) {
                com.baidu.location.e.d.lV().a(this.FN, null, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.FP = this.FN;
            }
            if (com.baidu.location.e.d.lV().d() && bDLocation.getLocType() == 161 && "wf".equals(bDLocation.getNetworkLocationType())) {
                com.baidu.location.e.d.lV().a(null, this.FM, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.FO = this.FM;
            }
            if (this.FN != null) {
                com.baidu.location.e.a.lU().a(c, this.FN, this.FM, bDLocation2);
            }
            if (com.baidu.location.f.k.mA().g()) {
                com.baidu.location.e.d.lV().i();
                com.baidu.location.e.d.lV().m();
            }
            k();
        }
    }

    public void a(boolean z) {
        BDLocation bDLocation = null;
        if (com.baidu.location.e.d.lV().d() && com.baidu.location.e.d.lV().g()) {
            bDLocation = com.baidu.location.e.d.lV().a(com.baidu.location.f.c.mr().mn(), com.baidu.location.f.k.mA().mx(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
            if ((bDLocation == null || bDLocation.getLocType() == 67) && z) {
                bDLocation = com.baidu.location.e.a.lU().X(false);
            }
        } else if (z) {
            bDLocation = com.baidu.location.e.a.lU().X(false);
        }
        if (bDLocation == null || bDLocation.getLocType() != 66) {
            return;
        }
        boolean z2 = true;
        if (com.baidu.location.h.i.f.equals("all") && bDLocation.getAddrStr() == null) {
            z2 = false;
        }
        if (com.baidu.location.h.i.g && bDLocation.getLocationDescribe() == null) {
            z2 = false;
        }
        if (com.baidu.location.h.i.h && bDLocation.getPoiList() == null) {
            z2 = false;
        }
        if (z2) {
            com.baidu.location.a.a.lw().a(bDLocation);
        }
    }

    public Address b(BDLocation bDLocation) {
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.FV, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] >= 100.0f) {
                this.x = null;
                this.FU = null;
                this.B = true;
                i(null);
            } else if (this.FT != null) {
                return this.FT;
            }
        }
        return null;
    }

    public void b(Message message) {
        if (this.Ga) {
            c(message);
        }
    }

    public void c() {
        this.r = true;
        this.s = false;
        this.Ga = true;
    }

    public void d() {
        this.s = false;
        this.t = false;
        this.G = false;
        this.FZ = true;
        i();
        this.Ga = false;
    }

    public String e() {
        return this.x;
    }

    public List<Poi> f() {
        return this.FU;
    }

    public boolean g() {
        return this.j;
    }

    public void h() {
        if (!this.t) {
            com.baidu.location.c.a.lM().d();
            return;
        }
        j(null);
        this.t = false;
    }

    public void i() {
        this.FK = null;
    }
}
