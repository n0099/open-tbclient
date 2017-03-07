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
    private static e MJ = null;
    public static boolean h = false;
    public d.b MK;
    private double MU;
    private double z;
    final int e = 1000;
    private boolean j = true;
    private String k = null;
    private BDLocation ML = null;
    private BDLocation MM = null;
    private com.baidu.location.f.i MN = null;
    private com.baidu.location.f.a MO = null;
    private com.baidu.location.f.i MP = null;
    private com.baidu.location.f.a MQ = null;
    private boolean r = true;
    private volatile boolean s = false;
    private boolean t = false;
    private long u = 0;
    private long MR = 0;
    private Address MS = null;
    private String x = null;
    private List<Poi> MT = null;
    private boolean B = false;
    private long C = 0;
    private long MV = 0;
    private a MW = null;
    private boolean F = false;
    private boolean G = false;
    private boolean H = true;
    public final Handler g = new d.a();
    private boolean MX = false;
    private b MY = null;
    private boolean MZ = false;

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
            if (e.this.MZ) {
                e.this.MZ = false;
            }
            if (e.this.t) {
                e.this.t = false;
                e.this.j(null);
            }
        }
    }

    private e() {
        this.MK = null;
        this.MK = new d.b();
    }

    private boolean a(com.baidu.location.f.a aVar) {
        this.MG = com.baidu.location.f.c.nl().nh();
        if (this.MG == aVar) {
            return false;
        }
        return this.MG == null || aVar == null || !aVar.a(this.MG);
    }

    private boolean a(com.baidu.location.f.i iVar) {
        this.MF = com.baidu.location.f.k.nu().ns();
        if (iVar == this.MF) {
            return false;
        }
        return this.MF == null || iVar == null || !iVar.c(this.MF);
    }

    private boolean b(com.baidu.location.f.a aVar) {
        if (aVar == null) {
            return false;
        }
        return this.MQ == null || !aVar.a(this.MQ);
    }

    private void c(Message message) {
        boolean z = message.getData().getBoolean("isWaitingLocTag", false);
        if (z) {
            h = true;
        }
        if (z) {
        }
        int e = com.baidu.location.a.a.mw().e(message);
        f.mz().d();
        switch (e) {
            case 1:
                g(message);
                return;
            case 2:
                i(message);
                return;
            case 3:
                if (com.baidu.location.f.f.no().i()) {
                    h(message);
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(e)));
        }
    }

    private void g(Message message) {
        if (com.baidu.location.f.f.no().i()) {
            h(message);
            f.mz().c();
            return;
        }
        i(message);
        f.mz().b();
    }

    private void h(Message message) {
        BDLocation bDLocation = new BDLocation(com.baidu.location.f.f.no().f());
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.MU, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.MS != null) {
                    bDLocation.setAddr(this.MS);
                }
                if (this.x != null) {
                    bDLocation.setLocationDescribe(this.x);
                }
                if (this.MT != null) {
                    bDLocation.setPoiList(this.MT);
                }
            } else {
                this.B = true;
                i(null);
            }
        }
        this.ML = bDLocation;
        this.MM = null;
        com.baidu.location.a.a.mw().a(bDLocation);
    }

    private void i(Message message) {
        if (this.r) {
            this.MV = SystemClock.uptimeMillis();
            j(message);
        } else if (this.s) {
        } else {
            this.MV = SystemClock.uptimeMillis();
            if (!com.baidu.location.f.k.nu().e()) {
                j(message);
                return;
            }
            this.t = true;
            if (this.MY == null) {
                this.MY = new b();
            }
            if (this.MZ && this.MY != null) {
                this.g.removeCallbacks(this.MY);
            }
            this.g.postDelayed(this.MY, 3500L);
            this.MZ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Message message) {
        if (this.s) {
            return;
        }
        if (System.currentTimeMillis() - this.u < 1000 && this.ML != null) {
            com.baidu.location.a.a.mw().a(this.ML);
            k();
            return;
        }
        if (this.MV > 0) {
            com.baidu.location.c.f.mP().mQ().a(this.MV);
        } else {
            com.baidu.location.c.f.mP().mQ().a(SystemClock.uptimeMillis());
        }
        this.s = true;
        this.j = a(this.MO);
        if (!a(this.MN) && !this.j && this.ML != null && !this.B) {
            if (this.MM != null && System.currentTimeMillis() - this.MR > 30000) {
                this.ML = this.MM;
                this.MM = null;
            }
            if (f.mz().f()) {
                this.ML.setDirection(f.mz().h());
            }
            com.baidu.location.a.a.mw().a(this.ML);
            k();
            return;
        }
        this.u = System.currentTimeMillis();
        String a2 = a((String) null);
        if (a2 == null) {
            if (this.ML != null) {
                com.baidu.location.a.a.mw().a(this.ML);
                k();
                return;
            }
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLocType(62);
            com.baidu.location.a.a.mw().a(bDLocation);
            k();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.C > TbConfig.USE_TIME_INTERVAL) {
                this.C = currentTimeMillis;
                com.baidu.location.c.f.mP().a("TypeCriteriaException");
                return;
            }
            return;
        }
        if (this.k != null) {
            a2 = a2 + this.k;
            this.k = null;
        }
        com.baidu.location.c.f.mP().mQ().b(SystemClock.uptimeMillis());
        this.MK.a(a2);
        this.MO = this.MG;
        this.MN = this.MF;
        if (j()) {
            this.MO = this.MG;
            this.MN = this.MF;
        }
        if (com.baidu.location.e.d.mT().h()) {
            if (this.MW == null) {
                this.MW = new a();
            }
            this.g.postDelayed(this.MW, com.baidu.location.e.d.mT().a(com.baidu.location.f.c.a(com.baidu.location.f.c.nl().e())));
            this.F = true;
        }
        if (this.r) {
            this.r = false;
            if (com.baidu.location.f.k.nu().g() && message != null && com.baidu.location.a.a.mw().f(message) < 1000 && com.baidu.location.e.d.mT().d()) {
                com.baidu.location.e.d.mT().i();
            }
            com.baidu.location.c.a.mK().b();
        }
    }

    private boolean j() {
        BDLocation bDLocation = null;
        double random = Math.random();
        long uptimeMillis = SystemClock.uptimeMillis();
        com.baidu.location.f.a nh = com.baidu.location.f.c.nl().nh();
        com.baidu.location.f.i nr = com.baidu.location.f.k.nu().nr();
        boolean z = nh != null && nh.e() && (nr == null || nr.a() == 0);
        if (com.baidu.location.e.d.mT().d() && com.baidu.location.e.d.mT().f() && (z || (0.0d < random && random < com.baidu.location.e.d.mT().mY()))) {
            bDLocation = com.baidu.location.e.d.mT().a(com.baidu.location.f.c.nl().nh(), com.baidu.location.f.k.nu().nr(), null, d.b.IS_MIX_MODE, d.a.NEED_TO_LOG);
        }
        if (bDLocation != null && bDLocation.getLocType() == 66 && this.s) {
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            bDLocation2.setLocType(BDLocation.TypeNetWorkLocation);
            if (this.s) {
                com.baidu.location.c.g gVar = new com.baidu.location.c.g();
                gVar.a(this.MV);
                gVar.b(uptimeMillis);
                gVar.c(uptimeMillis);
                gVar.d(SystemClock.uptimeMillis());
                gVar.a("ofs");
                if (this.MO != null) {
                    gVar.b(this.MO.h());
                    gVar.b("&offtag=1");
                }
                com.baidu.location.c.f.mP().a(gVar);
                this.G = true;
                com.baidu.location.a.a.mw().a(bDLocation2);
                this.ML = bDLocation2;
                return true;
            }
            return false;
        }
        return false;
    }

    private void k() {
        this.s = false;
        this.G = false;
        this.H = false;
        this.B = false;
        l();
    }

    private void l() {
        if (this.ML != null) {
            j.mG().c();
        }
    }

    public static synchronized e my() {
        e eVar;
        synchronized (e.class) {
            if (MJ == null) {
                MJ = new e();
            }
            eVar = MJ;
        }
        return eVar;
    }

    @Override // com.baidu.location.a.d
    public void a() {
        BDLocation bDLocation;
        if (this.MW != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.MW);
        }
        if (com.baidu.location.f.f.no().i()) {
            BDLocation bDLocation2 = new BDLocation(com.baidu.location.f.f.no().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.MU, this.z, bDLocation2.getLatitude(), bDLocation2.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.MS != null) {
                        bDLocation2.setAddr(this.MS);
                    }
                    if (this.x != null) {
                        bDLocation2.setLocationDescribe(this.x);
                    }
                    if (this.MT != null) {
                        bDLocation2.setPoiList(this.MT);
                    }
                }
            }
            com.baidu.location.a.a.mw().a(bDLocation2);
            k();
        } else if (this.G) {
            k();
        } else {
            com.baidu.location.c.f.mP().mQ().c(SystemClock.uptimeMillis());
            if (com.baidu.location.e.d.mT().d() && com.baidu.location.e.d.mT().e()) {
                bDLocation = com.baidu.location.e.d.mT().a(com.baidu.location.f.c.nl().nh(), com.baidu.location.f.k.nu().nr(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
                if (bDLocation != null && bDLocation.getLocType() == 66) {
                    com.baidu.location.a.a.mw().a(bDLocation);
                }
            } else {
                bDLocation = null;
            }
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                if (this.j || this.ML == null) {
                    BDLocation aa = com.baidu.location.e.a.mS().aa(false);
                    com.baidu.location.a.a.mw().a(aa);
                    boolean z = true;
                    if (com.baidu.location.h.i.f.equals("all") && aa.getAddrStr() == null) {
                        z = false;
                    }
                    if (com.baidu.location.h.i.g && aa.getLocationDescribe() == null) {
                        z = false;
                    }
                    if (com.baidu.location.h.i.h && aa.getPoiList() == null) {
                        z = false;
                    }
                    if (!z) {
                        aa.setLocType(67);
                    }
                    bDLocation = aa;
                } else {
                    com.baidu.location.a.a.mw().a(this.ML);
                }
            }
            com.baidu.location.c.f.mP().mQ().d(SystemClock.uptimeMillis());
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                this.ML = null;
                com.baidu.location.c.f.mP().mQ().a("off");
                if (this.MO != null) {
                    com.baidu.location.c.f.mP().mQ().b(this.MO.h());
                }
                com.baidu.location.c.f.mP().c();
            } else {
                this.ML = bDLocation;
                com.baidu.location.c.f.mP().mQ().a("ofs");
                if (this.MO != null) {
                    com.baidu.location.c.f.mP().mQ().b(this.MO.h());
                }
                com.baidu.location.c.f.mP().c();
            }
            this.MM = null;
            k();
        }
    }

    @Override // com.baidu.location.a.d
    public void a(Message message) {
        boolean z;
        if (this.MW != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.MW);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            this.MS = bDLocation.getAddress();
            this.z = bDLocation.getLongitude();
            this.MU = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.x = bDLocation.getLocationDescribe();
            this.z = bDLocation.getLongitude();
            this.MU = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.MT = bDLocation.getPoiList();
            this.z = bDLocation.getLongitude();
            this.MU = bDLocation.getLatitude();
        }
        if (com.baidu.location.f.f.no().i()) {
            BDLocation bDLocation3 = new BDLocation(com.baidu.location.f.f.no().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.MU, this.z, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.MS != null) {
                        bDLocation3.setAddr(this.MS);
                    }
                    if (this.x != null) {
                        bDLocation3.setLocationDescribe(this.x);
                    }
                    if (this.MT != null) {
                        bDLocation3.setPoiList(this.MT);
                    }
                }
            }
            com.baidu.location.a.a.mw().a(bDLocation3);
            k();
        } else if (bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("sky")) {
            bDLocation.setNetworkLocationType("wf");
            com.baidu.location.a.a.mw().a(bDLocation);
            this.MR = System.currentTimeMillis();
            this.ML = bDLocation;
        } else if (this.G) {
            float[] fArr2 = new float[2];
            if (this.ML != null) {
                Location.distanceBetween(this.ML.getLatitude(), this.ML.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
            }
            if (fArr2[0] > 10.0f) {
                this.ML = bDLocation;
                if (!this.H) {
                    this.H = false;
                    com.baidu.location.a.a.mw().a(bDLocation);
                }
            }
            k();
        } else {
            com.baidu.location.c.f.mP().mQ().c(SystemClock.uptimeMillis());
            this.MM = null;
            if (bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && this.ML != null && this.ML.getLocType() == 161 && "wf".equals(this.ML.getNetworkLocationType()) && System.currentTimeMillis() - this.MR < 30000) {
                z = true;
                this.MM = bDLocation;
            } else {
                z = false;
            }
            if (z) {
                com.baidu.location.a.a.mw().a(this.ML);
            } else {
                com.baidu.location.a.a.mw().a(bDLocation);
                this.MR = System.currentTimeMillis();
                com.baidu.location.c.f.mP().mQ().d(SystemClock.uptimeMillis());
                if (bDLocation.getLocType() == 161) {
                    com.baidu.location.c.f.mP().mQ().a("ons");
                    if (this.MO != null) {
                        com.baidu.location.c.f.mP().mQ().b(this.MO.h());
                    }
                } else {
                    com.baidu.location.c.f.mP().mQ().a("onf");
                    if (this.MO != null) {
                        com.baidu.location.c.f.mP().mQ().b(this.MO.h());
                    }
                    com.baidu.location.c.f.mP().c();
                }
            }
            if (!com.baidu.location.h.i.d(bDLocation)) {
                this.ML = null;
            } else if (!z) {
                this.ML = bDLocation;
            }
            int n = com.baidu.location.h.i.n(c, "ssid\":\"", "\"");
            if (n == Integer.MIN_VALUE || this.MN == null) {
                this.k = null;
            } else {
                this.k = this.MN.c(n);
            }
            if (com.baidu.location.e.d.mT().d() && bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && b(this.MO)) {
                com.baidu.location.e.d.mT().a(this.MO, null, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.MQ = this.MO;
            }
            if (com.baidu.location.e.d.mT().d() && bDLocation.getLocType() == 161 && "wf".equals(bDLocation.getNetworkLocationType())) {
                com.baidu.location.e.d.mT().a(null, this.MN, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.MP = this.MN;
            }
            if (this.MO != null) {
                com.baidu.location.e.a.mS().a(c, this.MO, this.MN, bDLocation2);
            }
            if (com.baidu.location.f.k.nu().g()) {
                com.baidu.location.e.d.mT().i();
                com.baidu.location.e.d.mT().m();
            }
            k();
        }
    }

    public void a(boolean z) {
        BDLocation bDLocation = null;
        if (com.baidu.location.e.d.mT().d() && com.baidu.location.e.d.mT().g()) {
            bDLocation = com.baidu.location.e.d.mT().a(com.baidu.location.f.c.nl().nh(), com.baidu.location.f.k.nu().nr(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
            if ((bDLocation == null || bDLocation.getLocType() == 67) && z) {
                bDLocation = com.baidu.location.e.a.mS().aa(false);
            }
        } else if (z) {
            bDLocation = com.baidu.location.e.a.mS().aa(false);
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
            com.baidu.location.a.a.mw().a(bDLocation);
        }
    }

    public Address b(BDLocation bDLocation) {
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.MU, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] >= 100.0f) {
                this.x = null;
                this.MT = null;
                this.B = true;
                i(null);
            } else if (this.MS != null) {
                return this.MS;
            }
        }
        return null;
    }

    public void b(Message message) {
        if (this.MX) {
            c(message);
        }
    }

    public void c() {
        this.r = true;
        this.s = false;
        this.MX = true;
    }

    public void d() {
        this.s = false;
        this.t = false;
        this.G = false;
        this.H = true;
        i();
        this.MX = false;
    }

    public String e() {
        return this.x;
    }

    public List<Poi> f() {
        return this.MT;
    }

    public boolean g() {
        return this.j;
    }

    public void h() {
        if (!this.t) {
            com.baidu.location.c.a.mK().d();
            return;
        }
        j(null);
        this.t = false;
    }

    public void i() {
        this.ML = null;
    }
}
