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
import java.util.List;
/* loaded from: classes.dex */
public class e extends d {
    private static e KJ = null;
    public static boolean h = false;
    public d.b KK;
    private double KS;
    private double z;
    final int e = 1000;
    private boolean j = true;
    private String k = null;
    private BDLocation KL = null;
    private BDLocation KM = null;
    private com.baidu.location.f.i KN = null;
    private com.baidu.location.f.a KO = null;
    private com.baidu.location.f.i KP = null;
    private com.baidu.location.f.a KQ = null;
    private boolean r = true;
    private volatile boolean s = false;
    private boolean t = false;
    private long u = 0;
    private long v = 0;
    private Address KR = null;
    private String x = null;
    private List<Poi> y = null;
    private boolean B = false;
    private long C = 0;
    private long D = 0;
    private a KT = null;
    private boolean F = false;
    private boolean G = false;
    private boolean H = true;
    public final Handler g = new d.a();
    private boolean I = false;
    private b KU = null;
    private boolean KV = false;

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
            if (e.this.KV) {
                e.this.KV = false;
            }
            if (e.this.t) {
                e.this.t = false;
                e.this.j(null);
            }
        }
    }

    private e() {
        this.KK = null;
        this.KK = new d.b();
    }

    private boolean a(com.baidu.location.f.a aVar) {
        this.KG = com.baidu.location.f.c.mK().mG();
        if (this.KG == aVar) {
            return false;
        }
        return this.KG == null || aVar == null || !aVar.a(this.KG);
    }

    private boolean a(com.baidu.location.f.i iVar) {
        this.KF = com.baidu.location.f.k.mT().mR();
        if (iVar == this.KF) {
            return false;
        }
        return this.KF == null || iVar == null || !iVar.c(this.KF);
    }

    private boolean b(com.baidu.location.f.a aVar) {
        if (aVar == null) {
            return false;
        }
        return this.KQ == null || !aVar.a(this.KQ);
    }

    private void c(Message message) {
        boolean z = message.getData().getBoolean("isWaitingLocTag", false);
        if (z) {
            h = true;
        }
        if (z) {
        }
        int e = com.baidu.location.a.a.lS().e(message);
        f.lV().d();
        switch (e) {
            case 1:
                g(message);
                return;
            case 2:
                i(message);
                return;
            case 3:
                if (com.baidu.location.f.f.mN().i()) {
                    h(message);
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(e)));
        }
    }

    private void g(Message message) {
        if (com.baidu.location.f.f.mN().i()) {
            h(message);
            f.lV().c();
            return;
        }
        i(message);
        f.lV().b();
    }

    private void h(Message message) {
        BDLocation bDLocation = new BDLocation(com.baidu.location.f.f.mN().f());
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.KS, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.KR != null) {
                    bDLocation.setAddr(this.KR);
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
        this.KL = bDLocation;
        this.KM = null;
        com.baidu.location.a.a.lS().a(bDLocation);
    }

    private void i(Message message) {
        if (this.r) {
            this.D = SystemClock.uptimeMillis();
            j(message);
        } else if (this.s) {
        } else {
            this.D = SystemClock.uptimeMillis();
            if (!com.baidu.location.f.k.mT().e()) {
                j(message);
                return;
            }
            this.t = true;
            if (this.KU == null) {
                this.KU = new b();
            }
            if (this.KV && this.KU != null) {
                this.g.removeCallbacks(this.KU);
            }
            this.g.postDelayed(this.KU, 3500L);
            this.KV = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Message message) {
        if (this.s) {
            return;
        }
        if (System.currentTimeMillis() - this.u < 1000 && this.KL != null) {
            com.baidu.location.a.a.lS().a(this.KL);
            k();
            return;
        }
        if (this.D > 0) {
            com.baidu.location.c.f.mo().mp().a(this.D);
        } else {
            com.baidu.location.c.f.mo().mp().a(SystemClock.uptimeMillis());
        }
        this.s = true;
        this.j = a(this.KO);
        if (!a(this.KN) && !this.j && this.KL != null && !this.B) {
            if (this.KM != null && System.currentTimeMillis() - this.v > 30000) {
                this.KL = this.KM;
                this.KM = null;
            }
            if (f.lV().f()) {
                this.KL.setDirection(f.lV().lX());
            }
            com.baidu.location.a.a.lS().a(this.KL);
            k();
            return;
        }
        this.u = System.currentTimeMillis();
        String a2 = a((String) null);
        if (a2 == null) {
            if (this.KL != null) {
                com.baidu.location.a.a.lS().a(this.KL);
                k();
                return;
            }
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLocType(62);
            com.baidu.location.a.a.lS().a(bDLocation);
            k();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.C > 60000) {
                this.C = currentTimeMillis;
                com.baidu.location.c.f.mo().a("TypeCriteriaException");
                return;
            }
            return;
        }
        if (this.k != null) {
            a2 = a2 + this.k;
            this.k = null;
        }
        com.baidu.location.c.f.mo().mp().b(SystemClock.uptimeMillis());
        this.KK.a(a2);
        this.KO = this.KG;
        this.KN = this.KF;
        if (j()) {
            this.KO = this.KG;
            this.KN = this.KF;
        }
        if (com.baidu.location.e.d.ms().h()) {
            if (this.KT == null) {
                this.KT = new a();
            }
            this.g.postDelayed(this.KT, com.baidu.location.e.d.ms().bN(com.baidu.location.f.c.a(com.baidu.location.f.c.mK().e())));
            this.F = true;
        }
        if (this.r) {
            this.r = false;
            if (com.baidu.location.f.k.mT().g() && message != null && com.baidu.location.a.a.lS().f(message) < 1000 && com.baidu.location.e.d.ms().d()) {
                com.baidu.location.e.d.ms().i();
            }
            com.baidu.location.c.a.mj().b();
        }
    }

    private boolean j() {
        BDLocation bDLocation = null;
        double random = Math.random();
        long uptimeMillis = SystemClock.uptimeMillis();
        com.baidu.location.f.a mG = com.baidu.location.f.c.mK().mG();
        com.baidu.location.f.i mQ = com.baidu.location.f.k.mT().mQ();
        boolean z = mG != null && mG.e() && (mQ == null || mQ.a() == 0);
        if (com.baidu.location.e.d.ms().d() && com.baidu.location.e.d.ms().f() && (z || (0.0d < random && random < com.baidu.location.e.d.ms().o()))) {
            bDLocation = com.baidu.location.e.d.ms().a(com.baidu.location.f.c.mK().mG(), com.baidu.location.f.k.mT().mQ(), null, d.b.IS_MIX_MODE, d.a.NEED_TO_LOG);
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
                if (this.KO != null) {
                    gVar.b(this.KO.h());
                    gVar.b("&offtag=1");
                }
                com.baidu.location.c.f.mo().a(gVar);
                this.G = true;
                com.baidu.location.a.a.lS().a(bDLocation2);
                this.KL = bDLocation2;
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
        if (this.KL != null) {
            j.mf().c();
        }
    }

    public static synchronized e lU() {
        e eVar;
        synchronized (e.class) {
            if (KJ == null) {
                KJ = new e();
            }
            eVar = KJ;
        }
        return eVar;
    }

    @Override // com.baidu.location.a.d
    public void a() {
        BDLocation bDLocation;
        if (this.KT != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.KT);
        }
        if (com.baidu.location.f.f.mN().i()) {
            BDLocation bDLocation2 = new BDLocation(com.baidu.location.f.f.mN().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.KS, this.z, bDLocation2.getLatitude(), bDLocation2.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.KR != null) {
                        bDLocation2.setAddr(this.KR);
                    }
                    if (this.x != null) {
                        bDLocation2.setLocationDescribe(this.x);
                    }
                    if (this.y != null) {
                        bDLocation2.setPoiList(this.y);
                    }
                }
            }
            com.baidu.location.a.a.lS().a(bDLocation2);
            k();
        } else if (this.G) {
            k();
        } else {
            com.baidu.location.c.f.mo().mp().c(SystemClock.uptimeMillis());
            if (com.baidu.location.e.d.ms().d() && com.baidu.location.e.d.ms().e()) {
                bDLocation = com.baidu.location.e.d.ms().a(com.baidu.location.f.c.mK().mG(), com.baidu.location.f.k.mT().mQ(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
                if (bDLocation != null && bDLocation.getLocType() == 66) {
                    com.baidu.location.a.a.lS().a(bDLocation);
                }
            } else {
                bDLocation = null;
            }
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                if (this.j || this.KL == null) {
                    BDLocation Z = com.baidu.location.e.a.mr().Z(false);
                    com.baidu.location.a.a.lS().a(Z);
                    boolean z = true;
                    if (com.baidu.location.h.i.f.equals("all") && Z.getAddrStr() == null) {
                        z = false;
                    }
                    if (com.baidu.location.h.i.g && Z.getLocationDescribe() == null) {
                        z = false;
                    }
                    if (com.baidu.location.h.i.h && Z.getPoiList() == null) {
                        z = false;
                    }
                    if (!z) {
                        Z.setLocType(67);
                    }
                    bDLocation = Z;
                } else {
                    com.baidu.location.a.a.lS().a(this.KL);
                }
            }
            com.baidu.location.c.f.mo().mp().d(SystemClock.uptimeMillis());
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                this.KL = null;
                com.baidu.location.c.f.mo().mp().a("off");
                if (this.KO != null) {
                    com.baidu.location.c.f.mo().mp().b(this.KO.h());
                }
                com.baidu.location.c.f.mo().c();
            } else {
                this.KL = bDLocation;
                com.baidu.location.c.f.mo().mp().a("ofs");
                if (this.KO != null) {
                    com.baidu.location.c.f.mo().mp().b(this.KO.h());
                }
                com.baidu.location.c.f.mo().c();
            }
            this.KM = null;
            k();
        }
    }

    @Override // com.baidu.location.a.d
    public void a(Message message) {
        boolean z;
        if (this.KT != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.KT);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            this.KR = bDLocation.getAddress();
            this.z = bDLocation.getLongitude();
            this.KS = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.x = bDLocation.getLocationDescribe();
            this.z = bDLocation.getLongitude();
            this.KS = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.y = bDLocation.getPoiList();
            this.z = bDLocation.getLongitude();
            this.KS = bDLocation.getLatitude();
        }
        if (com.baidu.location.f.f.mN().i()) {
            BDLocation bDLocation3 = new BDLocation(com.baidu.location.f.f.mN().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.KS, this.z, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.KR != null) {
                        bDLocation3.setAddr(this.KR);
                    }
                    if (this.x != null) {
                        bDLocation3.setLocationDescribe(this.x);
                    }
                    if (this.y != null) {
                        bDLocation3.setPoiList(this.y);
                    }
                }
            }
            com.baidu.location.a.a.lS().a(bDLocation3);
            k();
        } else if (bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("sky")) {
            bDLocation.setNetworkLocationType("wf");
            com.baidu.location.a.a.lS().a(bDLocation);
            this.v = System.currentTimeMillis();
            this.KL = bDLocation;
        } else if (this.G) {
            float[] fArr2 = new float[2];
            if (this.KL != null) {
                Location.distanceBetween(this.KL.getLatitude(), this.KL.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
            }
            if (fArr2[0] > 10.0f) {
                this.KL = bDLocation;
                if (!this.H) {
                    this.H = false;
                    com.baidu.location.a.a.lS().a(bDLocation);
                }
            }
            k();
        } else {
            com.baidu.location.c.f.mo().mp().c(SystemClock.uptimeMillis());
            this.KM = null;
            if (bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && this.KL != null && this.KL.getLocType() == 161 && "wf".equals(this.KL.getNetworkLocationType()) && System.currentTimeMillis() - this.v < 30000) {
                z = true;
                this.KM = bDLocation;
            } else {
                z = false;
            }
            if (z) {
                com.baidu.location.a.a.lS().a(this.KL);
            } else {
                com.baidu.location.a.a.lS().a(bDLocation);
                this.v = System.currentTimeMillis();
                com.baidu.location.c.f.mo().mp().d(SystemClock.uptimeMillis());
                if (bDLocation.getLocType() == 161) {
                    com.baidu.location.c.f.mo().mp().a("ons");
                    if (this.KO != null) {
                        com.baidu.location.c.f.mo().mp().b(this.KO.h());
                    }
                } else {
                    com.baidu.location.c.f.mo().mp().a("onf");
                    if (this.KO != null) {
                        com.baidu.location.c.f.mo().mp().b(this.KO.h());
                    }
                    com.baidu.location.c.f.mo().c();
                }
            }
            if (!com.baidu.location.h.i.d(bDLocation)) {
                this.KL = null;
            } else if (!z) {
                this.KL = bDLocation;
            }
            int h2 = com.baidu.location.h.i.h(c, "ssid\":\"", "\"");
            if (h2 == Integer.MIN_VALUE || this.KN == null) {
                this.k = null;
            } else {
                this.k = this.KN.c(h2);
            }
            if (com.baidu.location.e.d.ms().d() && bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && b(this.KO)) {
                com.baidu.location.e.d.ms().a(this.KO, null, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.KQ = this.KO;
            }
            if (com.baidu.location.e.d.ms().d() && bDLocation.getLocType() == 161 && "wf".equals(bDLocation.getNetworkLocationType())) {
                com.baidu.location.e.d.ms().a(null, this.KN, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.KP = this.KN;
            }
            if (this.KO != null) {
                com.baidu.location.e.a.mr().a(c, this.KO, this.KN, bDLocation2);
            }
            if (com.baidu.location.f.k.mT().g()) {
                com.baidu.location.e.d.ms().i();
                com.baidu.location.e.d.ms().m();
            }
            k();
        }
    }

    public void a(boolean z) {
        BDLocation bDLocation = null;
        if (com.baidu.location.e.d.ms().d() && com.baidu.location.e.d.ms().g()) {
            bDLocation = com.baidu.location.e.d.ms().a(com.baidu.location.f.c.mK().mG(), com.baidu.location.f.k.mT().mQ(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
            if ((bDLocation == null || bDLocation.getLocType() == 67) && z) {
                bDLocation = com.baidu.location.e.a.mr().Z(false);
            }
        } else if (z) {
            bDLocation = com.baidu.location.e.a.mr().Z(false);
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
            com.baidu.location.a.a.lS().a(bDLocation);
        }
    }

    public Address b(BDLocation bDLocation) {
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.KS, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] >= 100.0f) {
                this.x = null;
                this.y = null;
                this.B = true;
                i(null);
            } else if (this.KR != null) {
                return this.KR;
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
            com.baidu.location.c.a.mj().d();
            return;
        }
        j(null);
        this.t = false;
    }

    public void i() {
        this.KL = null;
    }
}
