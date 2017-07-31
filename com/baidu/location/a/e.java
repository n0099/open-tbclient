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
    private static e NB = null;
    public static boolean h = false;
    public d.b NC;
    private double NL;
    private double z;
    final int e = 1000;
    private boolean j = true;
    private String k = null;
    private BDLocation ND = null;
    private BDLocation NE = null;
    private com.baidu.location.f.i NF = null;
    private com.baidu.location.f.a NG = null;
    private com.baidu.location.f.i NH = null;
    private com.baidu.location.f.a NI = null;
    private boolean r = true;
    private volatile boolean s = false;
    private boolean t = false;
    private long u = 0;
    private long NJ = 0;
    private Address NK = null;
    private String x = null;
    private List<Poi> y = null;
    private boolean B = false;
    private long C = 0;
    private long NM = 0;
    private a NN = null;
    private boolean F = false;
    private boolean G = false;
    private boolean H = true;
    public final Handler g = new d.a();
    private boolean I = false;
    private b NP = null;
    private boolean NQ = false;

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
            if (e.this.NQ) {
                e.this.NQ = false;
            }
            if (e.this.t) {
                e.this.t = false;
                e.this.j(null);
            }
        }
    }

    private e() {
        this.NC = null;
        this.NC = new d.b();
    }

    private boolean a(com.baidu.location.f.a aVar) {
        this.Ny = com.baidu.location.f.c.ni().ne();
        if (this.Ny == aVar) {
            return false;
        }
        return this.Ny == null || aVar == null || !aVar.a(this.Ny);
    }

    private boolean a(com.baidu.location.f.i iVar) {
        this.Nx = com.baidu.location.f.k.nr().np();
        if (iVar == this.Nx) {
            return false;
        }
        return this.Nx == null || iVar == null || !iVar.c(this.Nx);
    }

    private boolean b(com.baidu.location.f.a aVar) {
        if (aVar == null) {
            return false;
        }
        return this.NI == null || !aVar.a(this.NI);
    }

    private void c(Message message) {
        boolean z = message.getData().getBoolean("isWaitingLocTag", false);
        if (z) {
            h = true;
        }
        if (z) {
        }
        int e = com.baidu.location.a.a.mu().e(message);
        f.mx().d();
        switch (e) {
            case 1:
                g(message);
                return;
            case 2:
                i(message);
                return;
            case 3:
                if (com.baidu.location.f.f.nl().i()) {
                    h(message);
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(e)));
        }
    }

    private void g(Message message) {
        if (com.baidu.location.f.f.nl().i()) {
            h(message);
            f.mx().c();
            return;
        }
        i(message);
        f.mx().b();
    }

    private void h(Message message) {
        BDLocation bDLocation = new BDLocation(com.baidu.location.f.f.nl().f());
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.NL, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.NK != null) {
                    bDLocation.setAddr(this.NK);
                }
                if (this.x != null) {
                    bDLocation.setLocationDescribe(this.x);
                }
                if (this.y != null) {
                    bDLocation.setPoiList(this.y);
                }
            } else {
                this.B = true;
                i(null);
            }
        }
        this.ND = bDLocation;
        this.NE = null;
        com.baidu.location.a.a.mu().a(bDLocation);
    }

    private void i(Message message) {
        if (this.r) {
            this.NM = SystemClock.uptimeMillis();
            j(message);
        } else if (this.s) {
        } else {
            this.NM = SystemClock.uptimeMillis();
            if (!com.baidu.location.f.k.nr().e()) {
                j(message);
                return;
            }
            this.t = true;
            if (this.NP == null) {
                this.NP = new b();
            }
            if (this.NQ && this.NP != null) {
                this.g.removeCallbacks(this.NP);
            }
            this.g.postDelayed(this.NP, 3500L);
            this.NQ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Message message) {
        if (this.s) {
            return;
        }
        if (System.currentTimeMillis() - this.u < 1000 && this.ND != null) {
            com.baidu.location.a.a.mu().a(this.ND);
            k();
            return;
        }
        if (this.NM > 0) {
            com.baidu.location.c.f.mN().mO().a(this.NM);
        } else {
            com.baidu.location.c.f.mN().mO().a(SystemClock.uptimeMillis());
        }
        this.s = true;
        this.j = a(this.NG);
        if (!a(this.NF) && !this.j && this.ND != null && !this.B) {
            if (this.NE != null && System.currentTimeMillis() - this.NJ > 30000) {
                this.ND = this.NE;
                this.NE = null;
            }
            if (f.mx().f()) {
                this.ND.setDirection(f.mx().h());
            }
            com.baidu.location.a.a.mu().a(this.ND);
            k();
            return;
        }
        this.u = System.currentTimeMillis();
        String a2 = a((String) null);
        if (a2 == null) {
            if (this.ND != null) {
                com.baidu.location.a.a.mu().a(this.ND);
                k();
                return;
            }
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLocType(62);
            com.baidu.location.a.a.mu().a(bDLocation);
            k();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.C > TbConfig.USE_TIME_INTERVAL) {
                this.C = currentTimeMillis;
                com.baidu.location.c.f.mN().a("TypeCriteriaException");
                return;
            }
            return;
        }
        if (this.k != null) {
            a2 = a2 + this.k;
            this.k = null;
        }
        com.baidu.location.c.f.mN().mO().b(SystemClock.uptimeMillis());
        this.NC.a(a2);
        this.NG = this.Ny;
        this.NF = this.Nx;
        if (j()) {
            this.NG = this.Ny;
            this.NF = this.Nx;
        }
        if (com.baidu.location.e.d.mR().h()) {
            if (this.NN == null) {
                this.NN = new a();
            }
            this.g.postDelayed(this.NN, com.baidu.location.e.d.mR().a(com.baidu.location.f.c.a(com.baidu.location.f.c.ni().e())));
            this.F = true;
        }
        if (this.r) {
            this.r = false;
            if (com.baidu.location.f.k.nr().g() && message != null && com.baidu.location.a.a.mu().f(message) < 1000 && com.baidu.location.e.d.mR().d()) {
                com.baidu.location.e.d.mR().i();
            }
            com.baidu.location.c.a.mI().b();
        }
    }

    private boolean j() {
        BDLocation bDLocation = null;
        double random = Math.random();
        long uptimeMillis = SystemClock.uptimeMillis();
        com.baidu.location.f.a ne = com.baidu.location.f.c.ni().ne();
        com.baidu.location.f.i no = com.baidu.location.f.k.nr().no();
        boolean z = ne != null && ne.e() && (no == null || no.a() == 0);
        if (com.baidu.location.e.d.mR().d() && com.baidu.location.e.d.mR().f() && (z || (0.0d < random && random < com.baidu.location.e.d.mR().o()))) {
            bDLocation = com.baidu.location.e.d.mR().a(com.baidu.location.f.c.ni().ne(), com.baidu.location.f.k.nr().no(), null, d.b.IS_MIX_MODE, d.a.NEED_TO_LOG);
        }
        if (bDLocation != null && bDLocation.getLocType() == 66 && this.s) {
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            bDLocation2.setLocType(BDLocation.TypeNetWorkLocation);
            if (this.s) {
                com.baidu.location.c.g gVar = new com.baidu.location.c.g();
                gVar.a(this.NM);
                gVar.b(uptimeMillis);
                gVar.c(uptimeMillis);
                gVar.d(SystemClock.uptimeMillis());
                gVar.a("ofs");
                if (this.NG != null) {
                    gVar.b(this.NG.h());
                    gVar.b("&offtag=1");
                }
                com.baidu.location.c.f.mN().a(gVar);
                this.G = true;
                com.baidu.location.a.a.mu().a(bDLocation2);
                this.ND = bDLocation2;
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
        if (this.ND != null) {
            j.mE().c();
        }
    }

    public static synchronized e mw() {
        e eVar;
        synchronized (e.class) {
            if (NB == null) {
                NB = new e();
            }
            eVar = NB;
        }
        return eVar;
    }

    @Override // com.baidu.location.a.d
    public void a() {
        BDLocation bDLocation;
        if (this.NN != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.NN);
        }
        if (com.baidu.location.f.f.nl().i()) {
            BDLocation bDLocation2 = new BDLocation(com.baidu.location.f.f.nl().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.NL, this.z, bDLocation2.getLatitude(), bDLocation2.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.NK != null) {
                        bDLocation2.setAddr(this.NK);
                    }
                    if (this.x != null) {
                        bDLocation2.setLocationDescribe(this.x);
                    }
                    if (this.y != null) {
                        bDLocation2.setPoiList(this.y);
                    }
                }
            }
            com.baidu.location.a.a.mu().a(bDLocation2);
            k();
        } else if (this.G) {
            k();
        } else {
            com.baidu.location.c.f.mN().mO().c(SystemClock.uptimeMillis());
            if (com.baidu.location.e.d.mR().d() && com.baidu.location.e.d.mR().e()) {
                bDLocation = com.baidu.location.e.d.mR().a(com.baidu.location.f.c.ni().ne(), com.baidu.location.f.k.nr().no(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
                if (bDLocation != null && bDLocation.getLocType() == 66) {
                    com.baidu.location.a.a.mu().a(bDLocation);
                }
            } else {
                bDLocation = null;
            }
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                if (this.j || this.ND == null) {
                    BDLocation aa = com.baidu.location.e.a.mQ().aa(false);
                    com.baidu.location.a.a.mu().a(aa);
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
                    com.baidu.location.a.a.mu().a(this.ND);
                }
            }
            com.baidu.location.c.f.mN().mO().d(SystemClock.uptimeMillis());
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                this.ND = null;
                com.baidu.location.c.f.mN().mO().a("off");
                if (this.NG != null) {
                    com.baidu.location.c.f.mN().mO().b(this.NG.h());
                }
                com.baidu.location.c.f.mN().c();
            } else {
                this.ND = bDLocation;
                com.baidu.location.c.f.mN().mO().a("ofs");
                if (this.NG != null) {
                    com.baidu.location.c.f.mN().mO().b(this.NG.h());
                }
                com.baidu.location.c.f.mN().c();
            }
            this.NE = null;
            k();
        }
    }

    @Override // com.baidu.location.a.d
    public void a(Message message) {
        boolean z;
        if (this.NN != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.NN);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            this.NK = bDLocation.getAddress();
            this.z = bDLocation.getLongitude();
            this.NL = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.x = bDLocation.getLocationDescribe();
            this.z = bDLocation.getLongitude();
            this.NL = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.y = bDLocation.getPoiList();
            this.z = bDLocation.getLongitude();
            this.NL = bDLocation.getLatitude();
        }
        if (com.baidu.location.f.f.nl().i()) {
            BDLocation bDLocation3 = new BDLocation(com.baidu.location.f.f.nl().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.NL, this.z, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.NK != null) {
                        bDLocation3.setAddr(this.NK);
                    }
                    if (this.x != null) {
                        bDLocation3.setLocationDescribe(this.x);
                    }
                    if (this.y != null) {
                        bDLocation3.setPoiList(this.y);
                    }
                }
            }
            com.baidu.location.a.a.mu().a(bDLocation3);
            k();
        } else if (bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("sky")) {
            bDLocation.setNetworkLocationType("wf");
            com.baidu.location.a.a.mu().a(bDLocation);
            this.NJ = System.currentTimeMillis();
            this.ND = bDLocation;
        } else if (this.G) {
            float[] fArr2 = new float[2];
            if (this.ND != null) {
                Location.distanceBetween(this.ND.getLatitude(), this.ND.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
            }
            if (fArr2[0] > 10.0f) {
                this.ND = bDLocation;
                if (!this.H) {
                    this.H = false;
                    com.baidu.location.a.a.mu().a(bDLocation);
                }
            }
            k();
        } else {
            com.baidu.location.c.f.mN().mO().c(SystemClock.uptimeMillis());
            this.NE = null;
            if (bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && this.ND != null && this.ND.getLocType() == 161 && "wf".equals(this.ND.getNetworkLocationType()) && System.currentTimeMillis() - this.NJ < 30000) {
                z = true;
                this.NE = bDLocation;
            } else {
                z = false;
            }
            if (z) {
                com.baidu.location.a.a.mu().a(this.ND);
            } else {
                com.baidu.location.a.a.mu().a(bDLocation);
                this.NJ = System.currentTimeMillis();
                com.baidu.location.c.f.mN().mO().d(SystemClock.uptimeMillis());
                if (bDLocation.getLocType() == 161) {
                    com.baidu.location.c.f.mN().mO().a("ons");
                    if (this.NG != null) {
                        com.baidu.location.c.f.mN().mO().b(this.NG.h());
                    }
                } else {
                    com.baidu.location.c.f.mN().mO().a("onf");
                    if (this.NG != null) {
                        com.baidu.location.c.f.mN().mO().b(this.NG.h());
                    }
                    com.baidu.location.c.f.mN().c();
                }
            }
            if (!com.baidu.location.h.i.d(bDLocation)) {
                this.ND = null;
            } else if (!z) {
                this.ND = bDLocation;
            }
            int h2 = com.baidu.location.h.i.h(c, "ssid\":\"", "\"");
            if (h2 == Integer.MIN_VALUE || this.NF == null) {
                this.k = null;
            } else {
                this.k = this.NF.c(h2);
            }
            if (com.baidu.location.e.d.mR().d() && bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && b(this.NG)) {
                com.baidu.location.e.d.mR().a(this.NG, null, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.NI = this.NG;
            }
            if (com.baidu.location.e.d.mR().d() && bDLocation.getLocType() == 161 && "wf".equals(bDLocation.getNetworkLocationType())) {
                com.baidu.location.e.d.mR().a(null, this.NF, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.NH = this.NF;
            }
            if (this.NG != null) {
                com.baidu.location.e.a.mQ().a(c, this.NG, this.NF, bDLocation2);
            }
            if (com.baidu.location.f.k.nr().g()) {
                com.baidu.location.e.d.mR().i();
                com.baidu.location.e.d.mR().m();
            }
            k();
        }
    }

    public void a(boolean z) {
        BDLocation bDLocation = null;
        if (com.baidu.location.e.d.mR().d() && com.baidu.location.e.d.mR().g()) {
            bDLocation = com.baidu.location.e.d.mR().a(com.baidu.location.f.c.ni().ne(), com.baidu.location.f.k.nr().no(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
            if ((bDLocation == null || bDLocation.getLocType() == 67) && z) {
                bDLocation = com.baidu.location.e.a.mQ().aa(false);
            }
        } else if (z) {
            bDLocation = com.baidu.location.e.a.mQ().aa(false);
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
            com.baidu.location.a.a.mu().a(bDLocation);
        }
    }

    public Address b(BDLocation bDLocation) {
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.NL, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] >= 100.0f) {
                this.x = null;
                this.y = null;
                this.B = true;
                i(null);
            } else if (this.NK != null) {
                return this.NK;
            }
        }
        return null;
    }

    public void b(Message message) {
        if (this.I) {
            c(message);
        }
    }

    public void c() {
        this.r = true;
        this.s = false;
        this.I = true;
    }

    public void d() {
        this.s = false;
        this.t = false;
        this.G = false;
        this.H = true;
        i();
        this.I = false;
    }

    public String e() {
        return this.x;
    }

    public List<Poi> f() {
        return this.y;
    }

    public boolean g() {
        return this.j;
    }

    public void h() {
        if (!this.t) {
            com.baidu.location.c.a.mI().d();
            return;
        }
        j(null);
        this.t = false;
    }

    public void i() {
        this.ND = null;
    }
}
