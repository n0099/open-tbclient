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
    private static e MX = null;
    public static boolean h = false;
    public d.b MY;
    private double Nh;
    private double z;
    final int e = 1000;
    private boolean j = true;
    private String k = null;
    private BDLocation MZ = null;
    private BDLocation Na = null;
    private com.baidu.location.f.i Nb = null;
    private com.baidu.location.f.a Nc = null;
    private com.baidu.location.f.i Nd = null;
    private com.baidu.location.f.a Ne = null;
    private boolean r = true;
    private volatile boolean s = false;
    private boolean t = false;
    private long u = 0;
    private long Nf = 0;
    private Address Ng = null;
    private String x = null;
    private List<Poi> y = null;
    private boolean B = false;
    private long C = 0;
    private long Ni = 0;
    private a Nj = null;
    private boolean F = false;
    private boolean G = false;
    private boolean H = true;
    public final Handler g = new d.a();
    private boolean I = false;
    private b Nk = null;
    private boolean Nl = false;

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
            if (e.this.Nl) {
                e.this.Nl = false;
            }
            if (e.this.t) {
                e.this.t = false;
                e.this.j(null);
            }
        }
    }

    private e() {
        this.MY = null;
        this.MY = new d.b();
    }

    private boolean a(com.baidu.location.f.a aVar) {
        this.MU = com.baidu.location.f.c.nF().nB();
        if (this.MU == aVar) {
            return false;
        }
        return this.MU == null || aVar == null || !aVar.a(this.MU);
    }

    private boolean a(com.baidu.location.f.i iVar) {
        this.MT = com.baidu.location.f.k.nO().nM();
        if (iVar == this.MT) {
            return false;
        }
        return this.MT == null || iVar == null || !iVar.c(this.MT);
    }

    private boolean b(com.baidu.location.f.a aVar) {
        if (aVar == null) {
            return false;
        }
        return this.Ne == null || !aVar.a(this.Ne);
    }

    private void c(Message message) {
        boolean z = message.getData().getBoolean("isWaitingLocTag", false);
        if (z) {
            h = true;
        }
        if (z) {
        }
        int e = com.baidu.location.a.a.mP().e(message);
        f.mS().d();
        switch (e) {
            case 1:
                g(message);
                return;
            case 2:
                i(message);
                return;
            case 3:
                if (com.baidu.location.f.f.nI().i()) {
                    h(message);
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(e)));
        }
    }

    private void g(Message message) {
        if (com.baidu.location.f.f.nI().i()) {
            h(message);
            f.mS().c();
            return;
        }
        i(message);
        f.mS().b();
    }

    private void h(Message message) {
        BDLocation bDLocation = new BDLocation(com.baidu.location.f.f.nI().f());
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.Nh, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.Ng != null) {
                    bDLocation.setAddr(this.Ng);
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
        this.MZ = bDLocation;
        this.Na = null;
        com.baidu.location.a.a.mP().a(bDLocation);
    }

    private void i(Message message) {
        if (this.r) {
            this.Ni = SystemClock.uptimeMillis();
            j(message);
        } else if (this.s) {
        } else {
            this.Ni = SystemClock.uptimeMillis();
            if (!com.baidu.location.f.k.nO().e()) {
                j(message);
                return;
            }
            this.t = true;
            if (this.Nk == null) {
                this.Nk = new b();
            }
            if (this.Nl && this.Nk != null) {
                this.g.removeCallbacks(this.Nk);
            }
            this.g.postDelayed(this.Nk, 3500L);
            this.Nl = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Message message) {
        if (this.s) {
            return;
        }
        if (System.currentTimeMillis() - this.u < 1000 && this.MZ != null) {
            com.baidu.location.a.a.mP().a(this.MZ);
            k();
            return;
        }
        if (this.Ni > 0) {
            com.baidu.location.c.f.ni().nj().a(this.Ni);
        } else {
            com.baidu.location.c.f.ni().nj().a(SystemClock.uptimeMillis());
        }
        this.s = true;
        this.j = a(this.Nc);
        if (!a(this.Nb) && !this.j && this.MZ != null && !this.B) {
            if (this.Na != null && System.currentTimeMillis() - this.Nf > 30000) {
                this.MZ = this.Na;
                this.Na = null;
            }
            if (f.mS().f()) {
                this.MZ.setDirection(f.mS().h());
            }
            com.baidu.location.a.a.mP().a(this.MZ);
            k();
            return;
        }
        this.u = System.currentTimeMillis();
        String a2 = a((String) null);
        if (a2 == null) {
            if (this.MZ != null) {
                com.baidu.location.a.a.mP().a(this.MZ);
                k();
                return;
            }
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLocType(62);
            com.baidu.location.a.a.mP().a(bDLocation);
            k();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.C > TbConfig.USE_TIME_INTERVAL) {
                this.C = currentTimeMillis;
                com.baidu.location.c.f.ni().a("TypeCriteriaException");
                return;
            }
            return;
        }
        if (this.k != null) {
            a2 = a2 + this.k;
            this.k = null;
        }
        com.baidu.location.c.f.ni().nj().b(SystemClock.uptimeMillis());
        this.MY.a(a2);
        this.Nc = this.MU;
        this.Nb = this.MT;
        if (j()) {
            this.Nc = this.MU;
            this.Nb = this.MT;
        }
        if (com.baidu.location.e.d.nm().h()) {
            if (this.Nj == null) {
                this.Nj = new a();
            }
            this.g.postDelayed(this.Nj, com.baidu.location.e.d.nm().a(com.baidu.location.f.c.a(com.baidu.location.f.c.nF().e())));
            this.F = true;
        }
        if (this.r) {
            this.r = false;
            if (com.baidu.location.f.k.nO().g() && message != null && com.baidu.location.a.a.mP().f(message) < 1000 && com.baidu.location.e.d.nm().d()) {
                com.baidu.location.e.d.nm().i();
            }
            com.baidu.location.c.a.nd().b();
        }
    }

    private boolean j() {
        BDLocation bDLocation = null;
        double random = Math.random();
        long uptimeMillis = SystemClock.uptimeMillis();
        com.baidu.location.f.a nB = com.baidu.location.f.c.nF().nB();
        com.baidu.location.f.i nL = com.baidu.location.f.k.nO().nL();
        boolean z = nB != null && nB.e() && (nL == null || nL.a() == 0);
        if (com.baidu.location.e.d.nm().d() && com.baidu.location.e.d.nm().f() && (z || (0.0d < random && random < com.baidu.location.e.d.nm().nr()))) {
            bDLocation = com.baidu.location.e.d.nm().a(com.baidu.location.f.c.nF().nB(), com.baidu.location.f.k.nO().nL(), null, d.b.IS_MIX_MODE, d.a.NEED_TO_LOG);
        }
        if (bDLocation != null && bDLocation.getLocType() == 66 && this.s) {
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            bDLocation2.setLocType(BDLocation.TypeNetWorkLocation);
            if (this.s) {
                com.baidu.location.c.g gVar = new com.baidu.location.c.g();
                gVar.a(this.Ni);
                gVar.b(uptimeMillis);
                gVar.c(uptimeMillis);
                gVar.d(SystemClock.uptimeMillis());
                gVar.a("ofs");
                if (this.Nc != null) {
                    gVar.b(this.Nc.h());
                    gVar.b("&offtag=1");
                }
                com.baidu.location.c.f.ni().a(gVar);
                this.G = true;
                com.baidu.location.a.a.mP().a(bDLocation2);
                this.MZ = bDLocation2;
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
        if (this.MZ != null) {
            j.mZ().c();
        }
    }

    public static synchronized e mR() {
        e eVar;
        synchronized (e.class) {
            if (MX == null) {
                MX = new e();
            }
            eVar = MX;
        }
        return eVar;
    }

    @Override // com.baidu.location.a.d
    public void a() {
        BDLocation bDLocation;
        if (this.Nj != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.Nj);
        }
        if (com.baidu.location.f.f.nI().i()) {
            BDLocation bDLocation2 = new BDLocation(com.baidu.location.f.f.nI().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.Nh, this.z, bDLocation2.getLatitude(), bDLocation2.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.Ng != null) {
                        bDLocation2.setAddr(this.Ng);
                    }
                    if (this.x != null) {
                        bDLocation2.setLocationDescribe(this.x);
                    }
                    if (this.y != null) {
                        bDLocation2.setPoiList(this.y);
                    }
                }
            }
            com.baidu.location.a.a.mP().a(bDLocation2);
            k();
        } else if (this.G) {
            k();
        } else {
            com.baidu.location.c.f.ni().nj().c(SystemClock.uptimeMillis());
            if (com.baidu.location.e.d.nm().d() && com.baidu.location.e.d.nm().e()) {
                bDLocation = com.baidu.location.e.d.nm().a(com.baidu.location.f.c.nF().nB(), com.baidu.location.f.k.nO().nL(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
                if (bDLocation != null && bDLocation.getLocType() == 66) {
                    com.baidu.location.a.a.mP().a(bDLocation);
                }
            } else {
                bDLocation = null;
            }
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                if (this.j || this.MZ == null) {
                    BDLocation ac = com.baidu.location.e.a.nl().ac(false);
                    com.baidu.location.a.a.mP().a(ac);
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
                    com.baidu.location.a.a.mP().a(this.MZ);
                }
            }
            com.baidu.location.c.f.ni().nj().d(SystemClock.uptimeMillis());
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                this.MZ = null;
                com.baidu.location.c.f.ni().nj().a("off");
                if (this.Nc != null) {
                    com.baidu.location.c.f.ni().nj().b(this.Nc.h());
                }
                com.baidu.location.c.f.ni().c();
            } else {
                this.MZ = bDLocation;
                com.baidu.location.c.f.ni().nj().a("ofs");
                if (this.Nc != null) {
                    com.baidu.location.c.f.ni().nj().b(this.Nc.h());
                }
                com.baidu.location.c.f.ni().c();
            }
            this.Na = null;
            k();
        }
    }

    @Override // com.baidu.location.a.d
    public void a(Message message) {
        boolean z;
        if (this.Nj != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.Nj);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            this.Ng = bDLocation.getAddress();
            this.z = bDLocation.getLongitude();
            this.Nh = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.x = bDLocation.getLocationDescribe();
            this.z = bDLocation.getLongitude();
            this.Nh = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.y = bDLocation.getPoiList();
            this.z = bDLocation.getLongitude();
            this.Nh = bDLocation.getLatitude();
        }
        if (com.baidu.location.f.f.nI().i()) {
            BDLocation bDLocation3 = new BDLocation(com.baidu.location.f.f.nI().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.Nh, this.z, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.Ng != null) {
                        bDLocation3.setAddr(this.Ng);
                    }
                    if (this.x != null) {
                        bDLocation3.setLocationDescribe(this.x);
                    }
                    if (this.y != null) {
                        bDLocation3.setPoiList(this.y);
                    }
                }
            }
            com.baidu.location.a.a.mP().a(bDLocation3);
            k();
        } else if (bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("sky")) {
            bDLocation.setNetworkLocationType("wf");
            com.baidu.location.a.a.mP().a(bDLocation);
            this.Nf = System.currentTimeMillis();
            this.MZ = bDLocation;
        } else if (this.G) {
            float[] fArr2 = new float[2];
            if (this.MZ != null) {
                Location.distanceBetween(this.MZ.getLatitude(), this.MZ.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
            }
            if (fArr2[0] > 10.0f) {
                this.MZ = bDLocation;
                if (!this.H) {
                    this.H = false;
                    com.baidu.location.a.a.mP().a(bDLocation);
                }
            }
            k();
        } else {
            com.baidu.location.c.f.ni().nj().c(SystemClock.uptimeMillis());
            this.Na = null;
            if (bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && this.MZ != null && this.MZ.getLocType() == 161 && "wf".equals(this.MZ.getNetworkLocationType()) && System.currentTimeMillis() - this.Nf < 30000) {
                z = true;
                this.Na = bDLocation;
            } else {
                z = false;
            }
            if (z) {
                com.baidu.location.a.a.mP().a(this.MZ);
            } else {
                com.baidu.location.a.a.mP().a(bDLocation);
                this.Nf = System.currentTimeMillis();
                com.baidu.location.c.f.ni().nj().d(SystemClock.uptimeMillis());
                if (bDLocation.getLocType() == 161) {
                    com.baidu.location.c.f.ni().nj().a("ons");
                    if (this.Nc != null) {
                        com.baidu.location.c.f.ni().nj().b(this.Nc.h());
                    }
                } else {
                    com.baidu.location.c.f.ni().nj().a("onf");
                    if (this.Nc != null) {
                        com.baidu.location.c.f.ni().nj().b(this.Nc.h());
                    }
                    com.baidu.location.c.f.ni().c();
                }
            }
            if (!com.baidu.location.h.i.d(bDLocation)) {
                this.MZ = null;
            } else if (!z) {
                this.MZ = bDLocation;
            }
            int h2 = com.baidu.location.h.i.h(c, "ssid\":\"", "\"");
            if (h2 == Integer.MIN_VALUE || this.Nb == null) {
                this.k = null;
            } else {
                this.k = this.Nb.c(h2);
            }
            if (com.baidu.location.e.d.nm().d() && bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && b(this.Nc)) {
                com.baidu.location.e.d.nm().a(this.Nc, null, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.Ne = this.Nc;
            }
            if (com.baidu.location.e.d.nm().d() && bDLocation.getLocType() == 161 && "wf".equals(bDLocation.getNetworkLocationType())) {
                com.baidu.location.e.d.nm().a(null, this.Nb, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.Nd = this.Nb;
            }
            if (this.Nc != null) {
                com.baidu.location.e.a.nl().a(c, this.Nc, this.Nb, bDLocation2);
            }
            if (com.baidu.location.f.k.nO().g()) {
                com.baidu.location.e.d.nm().i();
                com.baidu.location.e.d.nm().m();
            }
            k();
        }
    }

    public void a(boolean z) {
        BDLocation bDLocation = null;
        if (com.baidu.location.e.d.nm().d() && com.baidu.location.e.d.nm().g()) {
            bDLocation = com.baidu.location.e.d.nm().a(com.baidu.location.f.c.nF().nB(), com.baidu.location.f.k.nO().nL(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
            if ((bDLocation == null || bDLocation.getLocType() == 67) && z) {
                bDLocation = com.baidu.location.e.a.nl().ac(false);
            }
        } else if (z) {
            bDLocation = com.baidu.location.e.a.nl().ac(false);
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
            com.baidu.location.a.a.mP().a(bDLocation);
        }
    }

    public Address b(BDLocation bDLocation) {
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.Nh, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] >= 100.0f) {
                this.x = null;
                this.y = null;
                this.B = true;
                i(null);
            } else if (this.Ng != null) {
                return this.Ng;
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
            com.baidu.location.c.a.nd().d();
            return;
        }
        j(null);
        this.t = false;
    }

    public void i() {
        this.MZ = null;
    }
}
