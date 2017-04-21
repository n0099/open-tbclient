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
    private static e MZ = null;
    public static boolean h = false;
    public d.b Na;
    private double Nj;
    private double z;
    final int e = 1000;
    private boolean j = true;
    private String k = null;
    private BDLocation Nb = null;
    private BDLocation Nc = null;
    private com.baidu.location.f.i Nd = null;
    private com.baidu.location.f.a Ne = null;
    private com.baidu.location.f.i Nf = null;
    private com.baidu.location.f.a Ng = null;
    private boolean r = true;
    private volatile boolean s = false;
    private boolean t = false;
    private long u = 0;
    private long Nh = 0;
    private Address Ni = null;
    private String x = null;
    private List<Poi> y = null;
    private boolean B = false;
    private long C = 0;
    private long Nk = 0;
    private a Nl = null;
    private boolean F = false;
    private boolean G = false;
    private boolean H = true;
    public final Handler g = new d.a();
    private boolean I = false;
    private b Nm = null;
    private boolean Nn = false;

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
            if (e.this.Nn) {
                e.this.Nn = false;
            }
            if (e.this.t) {
                e.this.t = false;
                e.this.j(null);
            }
        }
    }

    private e() {
        this.Na = null;
        this.Na = new d.b();
    }

    private boolean a(com.baidu.location.f.a aVar) {
        this.MW = com.baidu.location.f.c.nF().nB();
        if (this.MW == aVar) {
            return false;
        }
        return this.MW == null || aVar == null || !aVar.a(this.MW);
    }

    private boolean a(com.baidu.location.f.i iVar) {
        this.MV = com.baidu.location.f.k.nO().nM();
        if (iVar == this.MV) {
            return false;
        }
        return this.MV == null || iVar == null || !iVar.c(this.MV);
    }

    private boolean b(com.baidu.location.f.a aVar) {
        if (aVar == null) {
            return false;
        }
        return this.Ng == null || !aVar.a(this.Ng);
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
            Location.distanceBetween(this.Nj, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.Ni != null) {
                    bDLocation.setAddr(this.Ni);
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
        this.Nb = bDLocation;
        this.Nc = null;
        com.baidu.location.a.a.mP().a(bDLocation);
    }

    private void i(Message message) {
        if (this.r) {
            this.Nk = SystemClock.uptimeMillis();
            j(message);
        } else if (this.s) {
        } else {
            this.Nk = SystemClock.uptimeMillis();
            if (!com.baidu.location.f.k.nO().e()) {
                j(message);
                return;
            }
            this.t = true;
            if (this.Nm == null) {
                this.Nm = new b();
            }
            if (this.Nn && this.Nm != null) {
                this.g.removeCallbacks(this.Nm);
            }
            this.g.postDelayed(this.Nm, 3500L);
            this.Nn = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Message message) {
        if (this.s) {
            return;
        }
        if (System.currentTimeMillis() - this.u < 1000 && this.Nb != null) {
            com.baidu.location.a.a.mP().a(this.Nb);
            k();
            return;
        }
        if (this.Nk > 0) {
            com.baidu.location.c.f.ni().nj().a(this.Nk);
        } else {
            com.baidu.location.c.f.ni().nj().a(SystemClock.uptimeMillis());
        }
        this.s = true;
        this.j = a(this.Ne);
        if (!a(this.Nd) && !this.j && this.Nb != null && !this.B) {
            if (this.Nc != null && System.currentTimeMillis() - this.Nh > 30000) {
                this.Nb = this.Nc;
                this.Nc = null;
            }
            if (f.mS().f()) {
                this.Nb.setDirection(f.mS().h());
            }
            com.baidu.location.a.a.mP().a(this.Nb);
            k();
            return;
        }
        this.u = System.currentTimeMillis();
        String a2 = a((String) null);
        if (a2 == null) {
            if (this.Nb != null) {
                com.baidu.location.a.a.mP().a(this.Nb);
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
        this.Na.a(a2);
        this.Ne = this.MW;
        this.Nd = this.MV;
        if (j()) {
            this.Ne = this.MW;
            this.Nd = this.MV;
        }
        if (com.baidu.location.e.d.nm().h()) {
            if (this.Nl == null) {
                this.Nl = new a();
            }
            this.g.postDelayed(this.Nl, com.baidu.location.e.d.nm().a(com.baidu.location.f.c.a(com.baidu.location.f.c.nF().e())));
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
                gVar.a(this.Nk);
                gVar.b(uptimeMillis);
                gVar.c(uptimeMillis);
                gVar.d(SystemClock.uptimeMillis());
                gVar.a("ofs");
                if (this.Ne != null) {
                    gVar.b(this.Ne.h());
                    gVar.b("&offtag=1");
                }
                com.baidu.location.c.f.ni().a(gVar);
                this.G = true;
                com.baidu.location.a.a.mP().a(bDLocation2);
                this.Nb = bDLocation2;
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
        if (this.Nb != null) {
            j.mZ().c();
        }
    }

    public static synchronized e mR() {
        e eVar;
        synchronized (e.class) {
            if (MZ == null) {
                MZ = new e();
            }
            eVar = MZ;
        }
        return eVar;
    }

    @Override // com.baidu.location.a.d
    public void a() {
        BDLocation bDLocation;
        if (this.Nl != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.Nl);
        }
        if (com.baidu.location.f.f.nI().i()) {
            BDLocation bDLocation2 = new BDLocation(com.baidu.location.f.f.nI().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.Nj, this.z, bDLocation2.getLatitude(), bDLocation2.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.Ni != null) {
                        bDLocation2.setAddr(this.Ni);
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
                if (this.j || this.Nb == null) {
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
                    com.baidu.location.a.a.mP().a(this.Nb);
                }
            }
            com.baidu.location.c.f.ni().nj().d(SystemClock.uptimeMillis());
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                this.Nb = null;
                com.baidu.location.c.f.ni().nj().a("off");
                if (this.Ne != null) {
                    com.baidu.location.c.f.ni().nj().b(this.Ne.h());
                }
                com.baidu.location.c.f.ni().c();
            } else {
                this.Nb = bDLocation;
                com.baidu.location.c.f.ni().nj().a("ofs");
                if (this.Ne != null) {
                    com.baidu.location.c.f.ni().nj().b(this.Ne.h());
                }
                com.baidu.location.c.f.ni().c();
            }
            this.Nc = null;
            k();
        }
    }

    @Override // com.baidu.location.a.d
    public void a(Message message) {
        boolean z;
        if (this.Nl != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.Nl);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            this.Ni = bDLocation.getAddress();
            this.z = bDLocation.getLongitude();
            this.Nj = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.x = bDLocation.getLocationDescribe();
            this.z = bDLocation.getLongitude();
            this.Nj = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.y = bDLocation.getPoiList();
            this.z = bDLocation.getLongitude();
            this.Nj = bDLocation.getLatitude();
        }
        if (com.baidu.location.f.f.nI().i()) {
            BDLocation bDLocation3 = new BDLocation(com.baidu.location.f.f.nI().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.Nj, this.z, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.Ni != null) {
                        bDLocation3.setAddr(this.Ni);
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
            this.Nh = System.currentTimeMillis();
            this.Nb = bDLocation;
        } else if (this.G) {
            float[] fArr2 = new float[2];
            if (this.Nb != null) {
                Location.distanceBetween(this.Nb.getLatitude(), this.Nb.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
            }
            if (fArr2[0] > 10.0f) {
                this.Nb = bDLocation;
                if (!this.H) {
                    this.H = false;
                    com.baidu.location.a.a.mP().a(bDLocation);
                }
            }
            k();
        } else {
            com.baidu.location.c.f.ni().nj().c(SystemClock.uptimeMillis());
            this.Nc = null;
            if (bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && this.Nb != null && this.Nb.getLocType() == 161 && "wf".equals(this.Nb.getNetworkLocationType()) && System.currentTimeMillis() - this.Nh < 30000) {
                z = true;
                this.Nc = bDLocation;
            } else {
                z = false;
            }
            if (z) {
                com.baidu.location.a.a.mP().a(this.Nb);
            } else {
                com.baidu.location.a.a.mP().a(bDLocation);
                this.Nh = System.currentTimeMillis();
                com.baidu.location.c.f.ni().nj().d(SystemClock.uptimeMillis());
                if (bDLocation.getLocType() == 161) {
                    com.baidu.location.c.f.ni().nj().a("ons");
                    if (this.Ne != null) {
                        com.baidu.location.c.f.ni().nj().b(this.Ne.h());
                    }
                } else {
                    com.baidu.location.c.f.ni().nj().a("onf");
                    if (this.Ne != null) {
                        com.baidu.location.c.f.ni().nj().b(this.Ne.h());
                    }
                    com.baidu.location.c.f.ni().c();
                }
            }
            if (!com.baidu.location.h.i.d(bDLocation)) {
                this.Nb = null;
            } else if (!z) {
                this.Nb = bDLocation;
            }
            int h2 = com.baidu.location.h.i.h(c, "ssid\":\"", "\"");
            if (h2 == Integer.MIN_VALUE || this.Nd == null) {
                this.k = null;
            } else {
                this.k = this.Nd.c(h2);
            }
            if (com.baidu.location.e.d.nm().d() && bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && b(this.Ne)) {
                com.baidu.location.e.d.nm().a(this.Ne, null, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.Ng = this.Ne;
            }
            if (com.baidu.location.e.d.nm().d() && bDLocation.getLocType() == 161 && "wf".equals(bDLocation.getNetworkLocationType())) {
                com.baidu.location.e.d.nm().a(null, this.Nd, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.Nf = this.Nd;
            }
            if (this.Ne != null) {
                com.baidu.location.e.a.nl().a(c, this.Ne, this.Nd, bDLocation2);
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
            Location.distanceBetween(this.Nj, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] >= 100.0f) {
                this.x = null;
                this.y = null;
                this.B = true;
                i(null);
            } else if (this.Ni != null) {
                return this.Ni;
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
        this.Nb = null;
    }
}
