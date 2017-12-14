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
    private static e La = null;
    public static boolean h = false;
    public d.b Lb;
    private double Lk;
    private double z;
    final int e = 1000;
    private boolean j = true;
    private String k = null;
    private BDLocation Lc = null;
    private BDLocation Ld = null;
    private com.baidu.location.f.i Le = null;
    private com.baidu.location.f.a Lf = null;
    private com.baidu.location.f.i Lg = null;
    private com.baidu.location.f.a Lh = null;
    private boolean r = true;
    private volatile boolean s = false;
    private boolean t = false;
    private long u = 0;
    private long v = 0;
    private Address Li = null;
    private String x = null;
    private List<Poi> Lj = null;
    private boolean B = false;
    private long C = 0;
    private long D = 0;
    private a Ll = null;
    private boolean F = false;
    private boolean G = false;
    private boolean H = true;
    public final Handler g = new d.a();
    private boolean I = false;
    private b Lm = null;
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
        this.Lb = null;
        this.Lb = new d.b();
    }

    private boolean a(com.baidu.location.f.a aVar) {
        this.KX = com.baidu.location.f.c.mN().mJ();
        if (this.KX == aVar) {
            return false;
        }
        return this.KX == null || aVar == null || !aVar.a(this.KX);
    }

    private boolean a(com.baidu.location.f.i iVar) {
        this.KW = com.baidu.location.f.k.mW().mU();
        if (iVar == this.KW) {
            return false;
        }
        return this.KW == null || iVar == null || !iVar.c(this.KW);
    }

    private boolean b(com.baidu.location.f.a aVar) {
        if (aVar == null) {
            return false;
        }
        return this.Lh == null || !aVar.a(this.Lh);
    }

    private void c(Message message) {
        boolean z = message.getData().getBoolean("isWaitingLocTag", false);
        if (z) {
            h = true;
        }
        if (z) {
        }
        int e = com.baidu.location.a.a.lV().e(message);
        f.lY().d();
        switch (e) {
            case 1:
                g(message);
                return;
            case 2:
                i(message);
                return;
            case 3:
                if (com.baidu.location.f.f.mQ().i()) {
                    h(message);
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(e)));
        }
    }

    private void g(Message message) {
        if (com.baidu.location.f.f.mQ().i()) {
            h(message);
            f.lY().c();
            return;
        }
        i(message);
        f.lY().b();
    }

    private void h(Message message) {
        BDLocation bDLocation = new BDLocation(com.baidu.location.f.f.mQ().f());
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.Lk, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.Li != null) {
                    bDLocation.setAddr(this.Li);
                }
                if (this.x != null) {
                    bDLocation.setLocationDescribe(this.x);
                }
                if (this.Lj != null) {
                    bDLocation.setPoiList(this.Lj);
                }
            } else {
                this.B = true;
                i(null);
            }
        }
        this.Lc = bDLocation;
        this.Ld = null;
        com.baidu.location.a.a.lV().a(bDLocation);
    }

    private void i(Message message) {
        if (this.r) {
            this.D = SystemClock.uptimeMillis();
            j(message);
        } else if (this.s) {
        } else {
            this.D = SystemClock.uptimeMillis();
            if (!com.baidu.location.f.k.mW().e()) {
                j(message);
                return;
            }
            this.t = true;
            if (this.Lm == null) {
                this.Lm = new b();
            }
            if (this.K && this.Lm != null) {
                this.g.removeCallbacks(this.Lm);
            }
            this.g.postDelayed(this.Lm, 3500L);
            this.K = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Message message) {
        if (this.s) {
            return;
        }
        if (System.currentTimeMillis() - this.u < 1000 && this.Lc != null) {
            com.baidu.location.a.a.lV().a(this.Lc);
            k();
            return;
        }
        if (this.D > 0) {
            com.baidu.location.c.f.mr().ms().a(this.D);
        } else {
            com.baidu.location.c.f.mr().ms().a(SystemClock.uptimeMillis());
        }
        this.s = true;
        this.j = a(this.Lf);
        if (!a(this.Le) && !this.j && this.Lc != null && !this.B) {
            if (this.Ld != null && System.currentTimeMillis() - this.v > 30000) {
                this.Lc = this.Ld;
                this.Ld = null;
            }
            if (f.lY().f()) {
                this.Lc.setDirection(f.lY().ma());
            }
            com.baidu.location.a.a.lV().a(this.Lc);
            k();
            return;
        }
        this.u = System.currentTimeMillis();
        String a2 = a((String) null);
        if (a2 == null) {
            if (this.Lc != null) {
                com.baidu.location.a.a.lV().a(this.Lc);
                k();
                return;
            }
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLocType(62);
            com.baidu.location.a.a.lV().a(bDLocation);
            k();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.C > 60000) {
                this.C = currentTimeMillis;
                com.baidu.location.c.f.mr().a("TypeCriteriaException");
                return;
            }
            return;
        }
        if (this.k != null) {
            a2 = a2 + this.k;
            this.k = null;
        }
        com.baidu.location.c.f.mr().ms().b(SystemClock.uptimeMillis());
        this.Lb.a(a2);
        this.Lf = this.KX;
        this.Le = this.KW;
        if (j()) {
            this.Lf = this.KX;
            this.Le = this.KW;
        }
        if (com.baidu.location.e.d.mv().h()) {
            if (this.Ll == null) {
                this.Ll = new a();
            }
            this.g.postDelayed(this.Ll, com.baidu.location.e.d.mv().bO(com.baidu.location.f.c.a(com.baidu.location.f.c.mN().e())));
            this.F = true;
        }
        if (this.r) {
            this.r = false;
            if (com.baidu.location.f.k.mW().g() && message != null && com.baidu.location.a.a.lV().f(message) < 1000 && com.baidu.location.e.d.mv().d()) {
                com.baidu.location.e.d.mv().i();
            }
            com.baidu.location.c.a.mm().b();
        }
    }

    private boolean j() {
        BDLocation bDLocation = null;
        double random = Math.random();
        long uptimeMillis = SystemClock.uptimeMillis();
        com.baidu.location.f.a mJ = com.baidu.location.f.c.mN().mJ();
        com.baidu.location.f.i mT = com.baidu.location.f.k.mW().mT();
        boolean z = mJ != null && mJ.e() && (mT == null || mT.a() == 0);
        if (com.baidu.location.e.d.mv().d() && com.baidu.location.e.d.mv().f() && (z || (0.0d < random && random < com.baidu.location.e.d.mv().o()))) {
            bDLocation = com.baidu.location.e.d.mv().a(com.baidu.location.f.c.mN().mJ(), com.baidu.location.f.k.mW().mT(), null, d.b.IS_MIX_MODE, d.a.NEED_TO_LOG);
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
                if (this.Lf != null) {
                    gVar.b(this.Lf.h());
                    gVar.b("&offtag=1");
                }
                com.baidu.location.c.f.mr().a(gVar);
                this.G = true;
                com.baidu.location.a.a.lV().a(bDLocation2);
                this.Lc = bDLocation2;
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
        if (this.Lc != null) {
            j.mi().c();
        }
    }

    public static synchronized e lX() {
        e eVar;
        synchronized (e.class) {
            if (La == null) {
                La = new e();
            }
            eVar = La;
        }
        return eVar;
    }

    @Override // com.baidu.location.a.d
    public void a() {
        BDLocation bDLocation;
        if (this.Ll != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.Ll);
        }
        if (com.baidu.location.f.f.mQ().i()) {
            BDLocation bDLocation2 = new BDLocation(com.baidu.location.f.f.mQ().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.Lk, this.z, bDLocation2.getLatitude(), bDLocation2.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.Li != null) {
                        bDLocation2.setAddr(this.Li);
                    }
                    if (this.x != null) {
                        bDLocation2.setLocationDescribe(this.x);
                    }
                    if (this.Lj != null) {
                        bDLocation2.setPoiList(this.Lj);
                    }
                }
            }
            com.baidu.location.a.a.lV().a(bDLocation2);
            k();
        } else if (this.G) {
            k();
        } else {
            com.baidu.location.c.f.mr().ms().c(SystemClock.uptimeMillis());
            if (com.baidu.location.e.d.mv().d() && com.baidu.location.e.d.mv().e()) {
                bDLocation = com.baidu.location.e.d.mv().a(com.baidu.location.f.c.mN().mJ(), com.baidu.location.f.k.mW().mT(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
                if (bDLocation != null && bDLocation.getLocType() == 66) {
                    com.baidu.location.a.a.lV().a(bDLocation);
                }
            } else {
                bDLocation = null;
            }
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                if (this.j || this.Lc == null) {
                    BDLocation Z = com.baidu.location.e.a.mu().Z(false);
                    com.baidu.location.a.a.lV().a(Z);
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
                    com.baidu.location.a.a.lV().a(this.Lc);
                }
            }
            com.baidu.location.c.f.mr().ms().d(SystemClock.uptimeMillis());
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                this.Lc = null;
                com.baidu.location.c.f.mr().ms().a("off");
                if (this.Lf != null) {
                    com.baidu.location.c.f.mr().ms().b(this.Lf.h());
                }
                com.baidu.location.c.f.mr().c();
            } else {
                this.Lc = bDLocation;
                com.baidu.location.c.f.mr().ms().a("ofs");
                if (this.Lf != null) {
                    com.baidu.location.c.f.mr().ms().b(this.Lf.h());
                }
                com.baidu.location.c.f.mr().c();
            }
            this.Ld = null;
            k();
        }
    }

    @Override // com.baidu.location.a.d
    public void a(Message message) {
        boolean z;
        if (this.Ll != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.Ll);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            this.Li = bDLocation.getAddress();
            this.z = bDLocation.getLongitude();
            this.Lk = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.x = bDLocation.getLocationDescribe();
            this.z = bDLocation.getLongitude();
            this.Lk = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.Lj = bDLocation.getPoiList();
            this.z = bDLocation.getLongitude();
            this.Lk = bDLocation.getLatitude();
        }
        if (com.baidu.location.f.f.mQ().i()) {
            BDLocation bDLocation3 = new BDLocation(com.baidu.location.f.f.mQ().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.Lk, this.z, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.Li != null) {
                        bDLocation3.setAddr(this.Li);
                    }
                    if (this.x != null) {
                        bDLocation3.setLocationDescribe(this.x);
                    }
                    if (this.Lj != null) {
                        bDLocation3.setPoiList(this.Lj);
                    }
                }
            }
            com.baidu.location.a.a.lV().a(bDLocation3);
            k();
        } else if (bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("sky")) {
            bDLocation.setNetworkLocationType("wf");
            com.baidu.location.a.a.lV().a(bDLocation);
            this.v = System.currentTimeMillis();
            this.Lc = bDLocation;
        } else if (this.G) {
            float[] fArr2 = new float[2];
            if (this.Lc != null) {
                Location.distanceBetween(this.Lc.getLatitude(), this.Lc.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
            }
            if (fArr2[0] > 10.0f) {
                this.Lc = bDLocation;
                if (!this.H) {
                    this.H = false;
                    com.baidu.location.a.a.lV().a(bDLocation);
                }
            }
            k();
        } else {
            com.baidu.location.c.f.mr().ms().c(SystemClock.uptimeMillis());
            this.Ld = null;
            if (bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && this.Lc != null && this.Lc.getLocType() == 161 && "wf".equals(this.Lc.getNetworkLocationType()) && System.currentTimeMillis() - this.v < 30000) {
                z = true;
                this.Ld = bDLocation;
            } else {
                z = false;
            }
            if (z) {
                com.baidu.location.a.a.lV().a(this.Lc);
            } else {
                com.baidu.location.a.a.lV().a(bDLocation);
                this.v = System.currentTimeMillis();
                com.baidu.location.c.f.mr().ms().d(SystemClock.uptimeMillis());
                if (bDLocation.getLocType() == 161) {
                    com.baidu.location.c.f.mr().ms().a("ons");
                    if (this.Lf != null) {
                        com.baidu.location.c.f.mr().ms().b(this.Lf.h());
                    }
                } else {
                    com.baidu.location.c.f.mr().ms().a("onf");
                    if (this.Lf != null) {
                        com.baidu.location.c.f.mr().ms().b(this.Lf.h());
                    }
                    com.baidu.location.c.f.mr().c();
                }
            }
            if (!com.baidu.location.h.i.d(bDLocation)) {
                this.Lc = null;
            } else if (!z) {
                this.Lc = bDLocation;
            }
            int j = com.baidu.location.h.i.j(c, "ssid\":\"", "\"");
            if (j == Integer.MIN_VALUE || this.Le == null) {
                this.k = null;
            } else {
                this.k = this.Le.c(j);
            }
            if (com.baidu.location.e.d.mv().d() && bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && b(this.Lf)) {
                com.baidu.location.e.d.mv().a(this.Lf, null, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.Lh = this.Lf;
            }
            if (com.baidu.location.e.d.mv().d() && bDLocation.getLocType() == 161 && "wf".equals(bDLocation.getNetworkLocationType())) {
                com.baidu.location.e.d.mv().a(null, this.Le, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.Lg = this.Le;
            }
            if (this.Lf != null) {
                com.baidu.location.e.a.mu().a(c, this.Lf, this.Le, bDLocation2);
            }
            if (com.baidu.location.f.k.mW().g()) {
                com.baidu.location.e.d.mv().i();
                com.baidu.location.e.d.mv().m();
            }
            k();
        }
    }

    public void a(boolean z) {
        BDLocation bDLocation = null;
        if (com.baidu.location.e.d.mv().d() && com.baidu.location.e.d.mv().g()) {
            bDLocation = com.baidu.location.e.d.mv().a(com.baidu.location.f.c.mN().mJ(), com.baidu.location.f.k.mW().mT(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
            if ((bDLocation == null || bDLocation.getLocType() == 67) && z) {
                bDLocation = com.baidu.location.e.a.mu().Z(false);
            }
        } else if (z) {
            bDLocation = com.baidu.location.e.a.mu().Z(false);
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
            com.baidu.location.a.a.lV().a(bDLocation);
        }
    }

    public Address b(BDLocation bDLocation) {
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.Lk, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] >= 100.0f) {
                this.x = null;
                this.Lj = null;
                this.B = true;
                i(null);
            } else if (this.Li != null) {
                return this.Li;
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
        return this.Lj;
    }

    public boolean g() {
        return this.j;
    }

    public void h() {
        if (!this.t) {
            com.baidu.location.c.a.mm().d();
            return;
        }
        j(null);
        this.t = false;
    }

    public void i() {
        this.Lc = null;
    }
}
