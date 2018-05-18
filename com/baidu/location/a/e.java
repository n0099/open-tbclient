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
    private static e NE = null;
    public static boolean h = false;
    public d.b NF;
    private double NP;
    private double z;
    final int e = 1000;
    private boolean j = true;
    private String k = null;
    private BDLocation NG = null;
    private BDLocation NH = null;
    private com.baidu.location.f.i NI = null;
    private com.baidu.location.f.a NJ = null;
    private com.baidu.location.f.i NK = null;
    private com.baidu.location.f.a NL = null;
    private boolean r = true;
    private volatile boolean s = false;
    private boolean t = false;
    private long u = 0;
    private long v = 0;
    private Address NM = null;
    private String x = null;
    private List<Poi> NN = null;
    private boolean B = false;
    private long C = 0;
    private long D = 0;
    private a NQ = null;
    private boolean F = false;
    private boolean G = false;
    private boolean H = true;
    public final Handler g = new d.a();
    private boolean I = false;
    private b NR = null;
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
        this.NF = null;
        this.NF = new d.b();
    }

    private boolean a(com.baidu.location.f.a aVar) {
        this.NB = com.baidu.location.f.c.nI().nE();
        if (this.NB == aVar) {
            return false;
        }
        return this.NB == null || aVar == null || !aVar.a(this.NB);
    }

    private boolean a(com.baidu.location.f.i iVar) {
        this.NA = com.baidu.location.f.k.nR().nP();
        if (iVar == this.NA) {
            return false;
        }
        return this.NA == null || iVar == null || !iVar.c(this.NA);
    }

    private boolean b(com.baidu.location.f.a aVar) {
        if (aVar == null) {
            return false;
        }
        return this.NL == null || !aVar.a(this.NL);
    }

    private void c(Message message) {
        boolean z = message.getData().getBoolean("isWaitingLocTag", false);
        if (z) {
            h = true;
        }
        if (z) {
        }
        int g = com.baidu.location.a.a.mS().g(message);
        f.mV().d();
        switch (g) {
            case 1:
                d(message);
                return;
            case 2:
                i(message);
                return;
            case 3:
                if (com.baidu.location.f.f.nL().i()) {
                    e(message);
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(g)));
        }
    }

    private void d(Message message) {
        if (com.baidu.location.f.f.nL().i()) {
            e(message);
            f.mV().c();
            return;
        }
        i(message);
        f.mV().b();
    }

    private void e(Message message) {
        BDLocation bDLocation = new BDLocation(com.baidu.location.f.f.nL().f());
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.NP, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.NM != null) {
                    bDLocation.setAddr(this.NM);
                }
                if (this.x != null) {
                    bDLocation.setLocationDescribe(this.x);
                }
                if (this.NN != null) {
                    bDLocation.setPoiList(this.NN);
                }
            } else {
                this.B = true;
                i(null);
            }
        }
        this.NG = bDLocation;
        this.NH = null;
        com.baidu.location.a.a.mS().a(bDLocation);
    }

    private void i(Message message) {
        if (this.r) {
            this.D = SystemClock.uptimeMillis();
            j(message);
        } else if (this.s) {
        } else {
            this.D = SystemClock.uptimeMillis();
            if (!com.baidu.location.f.k.nR().e()) {
                j(message);
                return;
            }
            this.t = true;
            if (this.NR == null) {
                this.NR = new b();
            }
            if (this.K && this.NR != null) {
                this.g.removeCallbacks(this.NR);
            }
            this.g.postDelayed(this.NR, 3500L);
            this.K = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Message message) {
        if (this.s) {
            return;
        }
        if (System.currentTimeMillis() - this.u < 1000 && this.NG != null) {
            com.baidu.location.a.a.mS().a(this.NG);
            k();
            return;
        }
        if (this.D > 0) {
            com.baidu.location.c.f.nm().nn().a(this.D);
        } else {
            com.baidu.location.c.f.nm().nn().a(SystemClock.uptimeMillis());
        }
        this.s = true;
        this.j = a(this.NJ);
        if (!a(this.NI) && !this.j && this.NG != null && !this.B) {
            if (this.NH != null && System.currentTimeMillis() - this.v > StatisticConfig.MIN_UPLOAD_INTERVAL) {
                this.NG = this.NH;
                this.NH = null;
            }
            if (f.mV().f()) {
                this.NG.setDirection(f.mV().h());
            }
            com.baidu.location.a.a.mS().a(this.NG);
            k();
            return;
        }
        this.u = System.currentTimeMillis();
        String a2 = a((String) null);
        if (a2 == null) {
            if (this.NG != null) {
                com.baidu.location.a.a.mS().a(this.NG);
                k();
                return;
            }
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLocType(62);
            com.baidu.location.a.a.mS().a(bDLocation);
            k();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.C > 60000) {
                this.C = currentTimeMillis;
                com.baidu.location.c.f.nm().a("TypeCriteriaException");
                return;
            }
            return;
        }
        if (this.k != null) {
            a2 = a2 + this.k;
            this.k = null;
        }
        com.baidu.location.c.f.nm().nn().b(SystemClock.uptimeMillis());
        this.NF.a(a2);
        this.NJ = this.NB;
        this.NI = this.NA;
        if (j()) {
            this.NJ = this.NB;
            this.NI = this.NA;
        }
        if (com.baidu.location.e.d.nq().h()) {
            if (this.NQ == null) {
                this.NQ = new a();
            }
            this.g.postDelayed(this.NQ, com.baidu.location.e.d.nq().a(com.baidu.location.f.c.a(com.baidu.location.f.c.nI().e())));
            this.F = true;
        }
        if (this.r) {
            this.r = false;
            if (com.baidu.location.f.k.nR().g() && message != null && com.baidu.location.a.a.mS().h(message) < 1000 && com.baidu.location.e.d.nq().d()) {
                com.baidu.location.e.d.nq().i();
            }
            com.baidu.location.c.a.nh().b();
        }
    }

    private boolean j() {
        BDLocation bDLocation = null;
        double random = Math.random();
        long uptimeMillis = SystemClock.uptimeMillis();
        com.baidu.location.f.a nE = com.baidu.location.f.c.nI().nE();
        com.baidu.location.f.i nO = com.baidu.location.f.k.nR().nO();
        boolean z = nE != null && nE.e() && (nO == null || nO.a() == 0);
        if (com.baidu.location.e.d.nq().d() && com.baidu.location.e.d.nq().f() && (z || (0.0d < random && random < com.baidu.location.e.d.nq().o()))) {
            bDLocation = com.baidu.location.e.d.nq().a(com.baidu.location.f.c.nI().nE(), com.baidu.location.f.k.nR().nO(), null, d.b.IS_MIX_MODE, d.a.NEED_TO_LOG);
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
                if (this.NJ != null) {
                    gVar.b(this.NJ.h());
                    gVar.b("&offtag=1");
                }
                com.baidu.location.c.f.nm().a(gVar);
                this.G = true;
                com.baidu.location.a.a.mS().a(bDLocation2);
                this.NG = bDLocation2;
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
        if (this.NG != null) {
            j.nd().c();
        }
    }

    public static synchronized e mU() {
        e eVar;
        synchronized (e.class) {
            if (NE == null) {
                NE = new e();
            }
            eVar = NE;
        }
        return eVar;
    }

    @Override // com.baidu.location.a.d
    public void a() {
        BDLocation bDLocation;
        if (this.NQ != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.NQ);
        }
        if (com.baidu.location.f.f.nL().i()) {
            BDLocation bDLocation2 = new BDLocation(com.baidu.location.f.f.nL().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.NP, this.z, bDLocation2.getLatitude(), bDLocation2.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.NM != null) {
                        bDLocation2.setAddr(this.NM);
                    }
                    if (this.x != null) {
                        bDLocation2.setLocationDescribe(this.x);
                    }
                    if (this.NN != null) {
                        bDLocation2.setPoiList(this.NN);
                    }
                }
            }
            com.baidu.location.a.a.mS().a(bDLocation2);
            k();
        } else if (this.G) {
            k();
        } else {
            com.baidu.location.c.f.nm().nn().c(SystemClock.uptimeMillis());
            if (com.baidu.location.e.d.nq().d() && com.baidu.location.e.d.nq().e()) {
                bDLocation = com.baidu.location.e.d.nq().a(com.baidu.location.f.c.nI().nE(), com.baidu.location.f.k.nR().nO(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
                if (bDLocation != null && bDLocation.getLocType() == 66) {
                    com.baidu.location.a.a.mS().a(bDLocation);
                }
            } else {
                bDLocation = null;
            }
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                if (this.j || this.NG == null) {
                    BDLocation ac = com.baidu.location.e.a.np().ac(false);
                    com.baidu.location.a.a.mS().a(ac);
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
                    com.baidu.location.a.a.mS().a(this.NG);
                }
            }
            com.baidu.location.c.f.nm().nn().d(SystemClock.uptimeMillis());
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                this.NG = null;
                com.baidu.location.c.f.nm().nn().a("off");
                if (this.NJ != null) {
                    com.baidu.location.c.f.nm().nn().b(this.NJ.h());
                }
                com.baidu.location.c.f.nm().c();
            } else {
                this.NG = bDLocation;
                com.baidu.location.c.f.nm().nn().a("ofs");
                if (this.NJ != null) {
                    com.baidu.location.c.f.nm().nn().b(this.NJ.h());
                }
                com.baidu.location.c.f.nm().c();
            }
            this.NH = null;
            k();
        }
    }

    @Override // com.baidu.location.a.d
    public void a(Message message) {
        boolean z;
        if (this.NQ != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.NQ);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            this.NM = bDLocation.getAddress();
            this.z = bDLocation.getLongitude();
            this.NP = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.x = bDLocation.getLocationDescribe();
            this.z = bDLocation.getLongitude();
            this.NP = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.NN = bDLocation.getPoiList();
            this.z = bDLocation.getLongitude();
            this.NP = bDLocation.getLatitude();
        }
        if (com.baidu.location.f.f.nL().i()) {
            BDLocation bDLocation3 = new BDLocation(com.baidu.location.f.f.nL().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.NP, this.z, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.NM != null) {
                        bDLocation3.setAddr(this.NM);
                    }
                    if (this.x != null) {
                        bDLocation3.setLocationDescribe(this.x);
                    }
                    if (this.NN != null) {
                        bDLocation3.setPoiList(this.NN);
                    }
                }
            }
            com.baidu.location.a.a.mS().a(bDLocation3);
            k();
        } else if (bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("sky")) {
            bDLocation.setNetworkLocationType("wf");
            com.baidu.location.a.a.mS().a(bDLocation);
            this.v = System.currentTimeMillis();
            this.NG = bDLocation;
        } else if (this.G) {
            float[] fArr2 = new float[2];
            if (this.NG != null) {
                Location.distanceBetween(this.NG.getLatitude(), this.NG.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
            }
            if (fArr2[0] > 10.0f) {
                this.NG = bDLocation;
                if (!this.H) {
                    this.H = false;
                    com.baidu.location.a.a.mS().a(bDLocation);
                }
            }
            k();
        } else {
            com.baidu.location.c.f.nm().nn().c(SystemClock.uptimeMillis());
            this.NH = null;
            if (bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && this.NG != null && this.NG.getLocType() == 161 && "wf".equals(this.NG.getNetworkLocationType()) && System.currentTimeMillis() - this.v < StatisticConfig.MIN_UPLOAD_INTERVAL) {
                z = true;
                this.NH = bDLocation;
            } else {
                z = false;
            }
            if (z) {
                com.baidu.location.a.a.mS().a(this.NG);
            } else {
                com.baidu.location.a.a.mS().a(bDLocation);
                this.v = System.currentTimeMillis();
                com.baidu.location.c.f.nm().nn().d(SystemClock.uptimeMillis());
                if (bDLocation.getLocType() == 161) {
                    com.baidu.location.c.f.nm().nn().a("ons");
                    if (this.NJ != null) {
                        com.baidu.location.c.f.nm().nn().b(this.NJ.h());
                    }
                } else {
                    com.baidu.location.c.f.nm().nn().a("onf");
                    if (this.NJ != null) {
                        com.baidu.location.c.f.nm().nn().b(this.NJ.h());
                    }
                    com.baidu.location.c.f.nm().c();
                }
            }
            if (!com.baidu.location.h.i.d(bDLocation)) {
                this.NG = null;
            } else if (!z) {
                this.NG = bDLocation;
            }
            int j = com.baidu.location.h.i.j(c, "ssid\":\"", "\"");
            if (j == Integer.MIN_VALUE || this.NI == null) {
                this.k = null;
            } else {
                this.k = this.NI.c(j);
            }
            if (com.baidu.location.e.d.nq().d() && bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && b(this.NJ)) {
                com.baidu.location.e.d.nq().a(this.NJ, null, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.NL = this.NJ;
            }
            if (com.baidu.location.e.d.nq().d() && bDLocation.getLocType() == 161 && "wf".equals(bDLocation.getNetworkLocationType())) {
                com.baidu.location.e.d.nq().a(null, this.NI, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.NK = this.NI;
            }
            if (this.NJ != null) {
                com.baidu.location.e.a.np().a(c, this.NJ, this.NI, bDLocation2);
            }
            if (com.baidu.location.f.k.nR().g()) {
                com.baidu.location.e.d.nq().i();
                com.baidu.location.e.d.nq().m();
            }
            k();
        }
    }

    public void a(boolean z) {
        BDLocation bDLocation = null;
        if (com.baidu.location.e.d.nq().d() && com.baidu.location.e.d.nq().g()) {
            bDLocation = com.baidu.location.e.d.nq().a(com.baidu.location.f.c.nI().nE(), com.baidu.location.f.k.nR().nO(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
            if ((bDLocation == null || bDLocation.getLocType() == 67) && z) {
                bDLocation = com.baidu.location.e.a.np().ac(false);
            }
        } else if (z) {
            bDLocation = com.baidu.location.e.a.np().ac(false);
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
            com.baidu.location.a.a.mS().a(bDLocation);
        }
    }

    public Address b(BDLocation bDLocation) {
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.NP, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] >= 100.0f) {
                this.x = null;
                this.NN = null;
                this.B = true;
                i(null);
            } else if (this.NM != null) {
                return this.NM;
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
        return this.NN;
    }

    public boolean g() {
        return this.j;
    }

    public void h() {
        if (!this.t) {
            com.baidu.location.c.a.nh().d();
            return;
        }
        j(null);
        this.t = false;
    }

    public void i() {
        this.NG = null;
    }
}
