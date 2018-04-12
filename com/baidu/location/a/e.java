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
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.util.List;
/* loaded from: classes.dex */
public class e extends d {
    private static e NI = null;
    public static boolean h = false;
    public d.b NJ;
    private double NU;
    private double z;
    final int e = 1000;
    private boolean j = true;
    private String k = null;
    private BDLocation NK = null;
    private BDLocation NL = null;
    private com.baidu.location.f.i NM = null;
    private com.baidu.location.f.a NN = null;
    private com.baidu.location.f.i NP = null;
    private com.baidu.location.f.a NQ = null;
    private boolean r = true;
    private volatile boolean s = false;
    private boolean t = false;
    private long u = 0;
    private long v = 0;
    private Address NR = null;
    private String x = null;
    private List<Poi> NT = null;
    private boolean B = false;
    private long C = 0;
    private long D = 0;
    private a NV = null;
    private boolean F = false;
    private boolean G = false;
    private boolean H = true;
    public final Handler g = new d.a();
    private boolean I = false;
    private b NW = null;
    private boolean K = false;

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
            if (e.this.K) {
                e.this.K = false;
            }
            if (e.this.t) {
                e.this.t = false;
                e.this.j(null);
            }
        }
    }

    private e() {
        this.NJ = null;
        this.NJ = new d.b();
    }

    private boolean a(com.baidu.location.f.a aVar) {
        this.NF = com.baidu.location.f.c.nJ().nF();
        if (this.NF == aVar) {
            return false;
        }
        return this.NF == null || aVar == null || !aVar.a(this.NF);
    }

    private boolean a(com.baidu.location.f.i iVar) {
        this.NE = com.baidu.location.f.k.nS().nQ();
        if (iVar == this.NE) {
            return false;
        }
        return this.NE == null || iVar == null || !iVar.c(this.NE);
    }

    private boolean b(com.baidu.location.f.a aVar) {
        if (aVar == null) {
            return false;
        }
        return this.NQ == null || !aVar.a(this.NQ);
    }

    private void c(Message message) {
        boolean z = message.getData().getBoolean("isWaitingLocTag", false);
        if (z) {
            h = true;
        }
        if (z) {
        }
        int g = com.baidu.location.a.a.mT().g(message);
        f.mW().d();
        switch (g) {
            case 1:
                d(message);
                return;
            case 2:
                i(message);
                return;
            case 3:
                if (com.baidu.location.f.f.nM().i()) {
                    e(message);
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(g)));
        }
    }

    private void d(Message message) {
        if (com.baidu.location.f.f.nM().i()) {
            e(message);
            f.mW().c();
            return;
        }
        i(message);
        f.mW().b();
    }

    private void e(Message message) {
        BDLocation bDLocation = new BDLocation(com.baidu.location.f.f.nM().f());
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.NU, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.NR != null) {
                    bDLocation.setAddr(this.NR);
                }
                if (this.x != null) {
                    bDLocation.setLocationDescribe(this.x);
                }
                if (this.NT != null) {
                    bDLocation.setPoiList(this.NT);
                }
            } else {
                this.B = true;
                i(null);
            }
        }
        this.NK = bDLocation;
        this.NL = null;
        com.baidu.location.a.a.mT().a(bDLocation);
    }

    private void i(Message message) {
        if (this.r) {
            this.D = SystemClock.uptimeMillis();
            j(message);
        } else if (this.s) {
        } else {
            this.D = SystemClock.uptimeMillis();
            if (!com.baidu.location.f.k.nS().e()) {
                j(message);
                return;
            }
            this.t = true;
            if (this.NW == null) {
                this.NW = new b();
            }
            if (this.K && this.NW != null) {
                this.g.removeCallbacks(this.NW);
            }
            this.g.postDelayed(this.NW, 3500L);
            this.K = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Message message) {
        if (this.s) {
            return;
        }
        if (System.currentTimeMillis() - this.u < 1000 && this.NK != null) {
            com.baidu.location.a.a.mT().a(this.NK);
            k();
            return;
        }
        if (this.D > 0) {
            com.baidu.location.c.f.nn().no().a(this.D);
        } else {
            com.baidu.location.c.f.nn().no().a(SystemClock.uptimeMillis());
        }
        this.s = true;
        this.j = a(this.NN);
        if (!a(this.NM) && !this.j && this.NK != null && !this.B) {
            if (this.NL != null && System.currentTimeMillis() - this.v > StatisticConfig.MIN_UPLOAD_INTERVAL) {
                this.NK = this.NL;
                this.NL = null;
            }
            if (f.mW().f()) {
                this.NK.setDirection(f.mW().h());
            }
            com.baidu.location.a.a.mT().a(this.NK);
            k();
            return;
        }
        this.u = System.currentTimeMillis();
        String a2 = a((String) null);
        if (a2 == null) {
            if (this.NK != null) {
                com.baidu.location.a.a.mT().a(this.NK);
                k();
                return;
            }
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLocType(62);
            com.baidu.location.a.a.mT().a(bDLocation);
            k();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.C > 60000) {
                this.C = currentTimeMillis;
                com.baidu.location.c.f.nn().a("TypeCriteriaException");
                return;
            }
            return;
        }
        if (this.k != null) {
            a2 = a2 + this.k;
            this.k = null;
        }
        com.baidu.location.c.f.nn().no().b(SystemClock.uptimeMillis());
        this.NJ.a(a2);
        this.NN = this.NF;
        this.NM = this.NE;
        if (j()) {
            this.NN = this.NF;
            this.NM = this.NE;
        }
        if (com.baidu.location.e.d.nr().h()) {
            if (this.NV == null) {
                this.NV = new a();
            }
            this.g.postDelayed(this.NV, com.baidu.location.e.d.nr().a(com.baidu.location.f.c.a(com.baidu.location.f.c.nJ().e())));
            this.F = true;
        }
        if (this.r) {
            this.r = false;
            if (com.baidu.location.f.k.nS().g() && message != null && com.baidu.location.a.a.mT().h(message) < 1000 && com.baidu.location.e.d.nr().d()) {
                com.baidu.location.e.d.nr().i();
            }
            com.baidu.location.c.a.ni().b();
        }
    }

    private boolean j() {
        BDLocation bDLocation = null;
        double random = Math.random();
        long uptimeMillis = SystemClock.uptimeMillis();
        com.baidu.location.f.a nF = com.baidu.location.f.c.nJ().nF();
        com.baidu.location.f.i nP = com.baidu.location.f.k.nS().nP();
        boolean z = nF != null && nF.e() && (nP == null || nP.a() == 0);
        if (com.baidu.location.e.d.nr().d() && com.baidu.location.e.d.nr().f() && (z || (0.0d < random && random < com.baidu.location.e.d.nr().o()))) {
            bDLocation = com.baidu.location.e.d.nr().a(com.baidu.location.f.c.nJ().nF(), com.baidu.location.f.k.nS().nP(), null, d.b.IS_MIX_MODE, d.a.NEED_TO_LOG);
        }
        if (bDLocation != null && bDLocation.getLocType() == 66 && this.s) {
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            bDLocation2.setLocType(BDLocation.TypeNetWorkLocation);
            if (this.s) {
                com.baidu.location.c.g gVar = new com.baidu.location.c.g();
                gVar.a(this.D);
                gVar.b(uptimeMillis);
                gVar.c(uptimeMillis);
                gVar.d(SystemClock.uptimeMillis());
                gVar.a("ofs");
                if (this.NN != null) {
                    gVar.b(this.NN.h());
                    gVar.b("&offtag=1");
                }
                com.baidu.location.c.f.nn().a(gVar);
                this.G = true;
                com.baidu.location.a.a.mT().a(bDLocation2);
                this.NK = bDLocation2;
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
        if (this.NK != null) {
            j.ne().c();
        }
    }

    public static synchronized e mV() {
        e eVar;
        synchronized (e.class) {
            if (NI == null) {
                NI = new e();
            }
            eVar = NI;
        }
        return eVar;
    }

    @Override // com.baidu.location.a.d
    public void a() {
        BDLocation bDLocation;
        if (this.NV != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.NV);
        }
        if (com.baidu.location.f.f.nM().i()) {
            BDLocation bDLocation2 = new BDLocation(com.baidu.location.f.f.nM().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.NU, this.z, bDLocation2.getLatitude(), bDLocation2.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.NR != null) {
                        bDLocation2.setAddr(this.NR);
                    }
                    if (this.x != null) {
                        bDLocation2.setLocationDescribe(this.x);
                    }
                    if (this.NT != null) {
                        bDLocation2.setPoiList(this.NT);
                    }
                }
            }
            com.baidu.location.a.a.mT().a(bDLocation2);
            k();
        } else if (this.G) {
            k();
        } else {
            com.baidu.location.c.f.nn().no().c(SystemClock.uptimeMillis());
            if (com.baidu.location.e.d.nr().d() && com.baidu.location.e.d.nr().e()) {
                bDLocation = com.baidu.location.e.d.nr().a(com.baidu.location.f.c.nJ().nF(), com.baidu.location.f.k.nS().nP(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
                if (bDLocation != null && bDLocation.getLocType() == 66) {
                    com.baidu.location.a.a.mT().a(bDLocation);
                }
            } else {
                bDLocation = null;
            }
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                if (this.j || this.NK == null) {
                    BDLocation ac = com.baidu.location.e.a.nq().ac(false);
                    com.baidu.location.a.a.mT().a(ac);
                    boolean z = true;
                    if (com.baidu.location.h.i.f.equals("all") && ac.getAddrStr() == null) {
                        z = false;
                    }
                    if (com.baidu.location.h.i.g && ac.getLocationDescribe() == null) {
                        z = false;
                    }
                    if (com.baidu.location.h.i.h && ac.getPoiList() == null) {
                        z = false;
                    }
                    if (!z) {
                        ac.setLocType(67);
                    }
                    bDLocation = ac;
                } else {
                    com.baidu.location.a.a.mT().a(this.NK);
                }
            }
            com.baidu.location.c.f.nn().no().d(SystemClock.uptimeMillis());
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                this.NK = null;
                com.baidu.location.c.f.nn().no().a("off");
                if (this.NN != null) {
                    com.baidu.location.c.f.nn().no().b(this.NN.h());
                }
                com.baidu.location.c.f.nn().c();
            } else {
                this.NK = bDLocation;
                com.baidu.location.c.f.nn().no().a("ofs");
                if (this.NN != null) {
                    com.baidu.location.c.f.nn().no().b(this.NN.h());
                }
                com.baidu.location.c.f.nn().c();
            }
            this.NL = null;
            k();
        }
    }

    @Override // com.baidu.location.a.d
    public void a(Message message) {
        boolean z;
        if (this.NV != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.NV);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            this.NR = bDLocation.getAddress();
            this.z = bDLocation.getLongitude();
            this.NU = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.x = bDLocation.getLocationDescribe();
            this.z = bDLocation.getLongitude();
            this.NU = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.NT = bDLocation.getPoiList();
            this.z = bDLocation.getLongitude();
            this.NU = bDLocation.getLatitude();
        }
        if (com.baidu.location.f.f.nM().i()) {
            BDLocation bDLocation3 = new BDLocation(com.baidu.location.f.f.nM().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.NU, this.z, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.NR != null) {
                        bDLocation3.setAddr(this.NR);
                    }
                    if (this.x != null) {
                        bDLocation3.setLocationDescribe(this.x);
                    }
                    if (this.NT != null) {
                        bDLocation3.setPoiList(this.NT);
                    }
                }
            }
            com.baidu.location.a.a.mT().a(bDLocation3);
            k();
        } else if (bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("sky")) {
            bDLocation.setNetworkLocationType("wf");
            com.baidu.location.a.a.mT().a(bDLocation);
            this.v = System.currentTimeMillis();
            this.NK = bDLocation;
        } else if (this.G) {
            float[] fArr2 = new float[2];
            if (this.NK != null) {
                Location.distanceBetween(this.NK.getLatitude(), this.NK.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
            }
            if (fArr2[0] > 10.0f) {
                this.NK = bDLocation;
                if (!this.H) {
                    this.H = false;
                    com.baidu.location.a.a.mT().a(bDLocation);
                }
            }
            k();
        } else {
            com.baidu.location.c.f.nn().no().c(SystemClock.uptimeMillis());
            this.NL = null;
            if (bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && this.NK != null && this.NK.getLocType() == 161 && "wf".equals(this.NK.getNetworkLocationType()) && System.currentTimeMillis() - this.v < StatisticConfig.MIN_UPLOAD_INTERVAL) {
                z = true;
                this.NL = bDLocation;
            } else {
                z = false;
            }
            if (z) {
                com.baidu.location.a.a.mT().a(this.NK);
            } else {
                com.baidu.location.a.a.mT().a(bDLocation);
                this.v = System.currentTimeMillis();
                com.baidu.location.c.f.nn().no().d(SystemClock.uptimeMillis());
                if (bDLocation.getLocType() == 161) {
                    com.baidu.location.c.f.nn().no().a("ons");
                    if (this.NN != null) {
                        com.baidu.location.c.f.nn().no().b(this.NN.h());
                    }
                } else {
                    com.baidu.location.c.f.nn().no().a("onf");
                    if (this.NN != null) {
                        com.baidu.location.c.f.nn().no().b(this.NN.h());
                    }
                    com.baidu.location.c.f.nn().c();
                }
            }
            if (!com.baidu.location.h.i.d(bDLocation)) {
                this.NK = null;
            } else if (!z) {
                this.NK = bDLocation;
            }
            int j = com.baidu.location.h.i.j(c, "ssid\":\"", "\"");
            if (j == Integer.MIN_VALUE || this.NM == null) {
                this.k = null;
            } else {
                this.k = this.NM.c(j);
            }
            if (com.baidu.location.e.d.nr().d() && bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && b(this.NN)) {
                com.baidu.location.e.d.nr().a(this.NN, null, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.NQ = this.NN;
            }
            if (com.baidu.location.e.d.nr().d() && bDLocation.getLocType() == 161 && "wf".equals(bDLocation.getNetworkLocationType())) {
                com.baidu.location.e.d.nr().a(null, this.NM, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.NP = this.NM;
            }
            if (this.NN != null) {
                com.baidu.location.e.a.nq().a(c, this.NN, this.NM, bDLocation2);
            }
            if (com.baidu.location.f.k.nS().g()) {
                com.baidu.location.e.d.nr().i();
                com.baidu.location.e.d.nr().m();
            }
            k();
        }
    }

    public void a(boolean z) {
        BDLocation bDLocation = null;
        if (com.baidu.location.e.d.nr().d() && com.baidu.location.e.d.nr().g()) {
            bDLocation = com.baidu.location.e.d.nr().a(com.baidu.location.f.c.nJ().nF(), com.baidu.location.f.k.nS().nP(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
            if ((bDLocation == null || bDLocation.getLocType() == 67) && z) {
                bDLocation = com.baidu.location.e.a.nq().ac(false);
            }
        } else if (z) {
            bDLocation = com.baidu.location.e.a.nq().ac(false);
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
            com.baidu.location.a.a.mT().a(bDLocation);
        }
    }

    public Address b(BDLocation bDLocation) {
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.NU, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] >= 100.0f) {
                this.x = null;
                this.NT = null;
                this.B = true;
                i(null);
            } else if (this.NR != null) {
                return this.NR;
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
        return this.NT;
    }

    public boolean g() {
        return this.j;
    }

    public void h() {
        if (!this.t) {
            com.baidu.location.c.a.ni().d();
            return;
        }
        j(null);
        this.t = false;
    }

    public void i() {
        this.NK = null;
    }
}
