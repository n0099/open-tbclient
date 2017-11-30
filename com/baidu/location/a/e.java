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
    private static e Lb = null;
    public static boolean h = false;
    public d.b Lc;
    private double Lk;
    private double z;
    final int e = 1000;
    private boolean j = true;
    private String k = null;
    private BDLocation Ld = null;
    private BDLocation Le = null;
    private com.baidu.location.f.i Lf = null;
    private com.baidu.location.f.a Lg = null;
    private com.baidu.location.f.i Lh = null;
    private com.baidu.location.f.a Li = null;
    private boolean r = true;
    private volatile boolean s = false;
    private boolean t = false;
    private long u = 0;
    private long v = 0;
    private Address Lj = null;
    private String x = null;
    private List<Poi> y = null;
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
    private boolean Ln = false;

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
            if (e.this.Ln) {
                e.this.Ln = false;
            }
            if (e.this.t) {
                e.this.t = false;
                e.this.j(null);
            }
        }
    }

    private e() {
        this.Lc = null;
        this.Lc = new d.b();
    }

    private boolean a(com.baidu.location.f.a aVar) {
        this.KY = com.baidu.location.f.c.mN().mJ();
        if (this.KY == aVar) {
            return false;
        }
        return this.KY == null || aVar == null || !aVar.a(this.KY);
    }

    private boolean a(com.baidu.location.f.i iVar) {
        this.KX = com.baidu.location.f.k.mW().mU();
        if (iVar == this.KX) {
            return false;
        }
        return this.KX == null || iVar == null || !iVar.c(this.KX);
    }

    private boolean b(com.baidu.location.f.a aVar) {
        if (aVar == null) {
            return false;
        }
        return this.Li == null || !aVar.a(this.Li);
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
                if (this.Lj != null) {
                    bDLocation.setAddr(this.Lj);
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
        this.Ld = bDLocation;
        this.Le = null;
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
            if (this.Ln && this.Lm != null) {
                this.g.removeCallbacks(this.Lm);
            }
            this.g.postDelayed(this.Lm, 3500L);
            this.Ln = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Message message) {
        if (this.s) {
            return;
        }
        if (System.currentTimeMillis() - this.u < 1000 && this.Ld != null) {
            com.baidu.location.a.a.lV().a(this.Ld);
            k();
            return;
        }
        if (this.D > 0) {
            com.baidu.location.c.f.mr().ms().a(this.D);
        } else {
            com.baidu.location.c.f.mr().ms().a(SystemClock.uptimeMillis());
        }
        this.s = true;
        this.j = a(this.Lg);
        if (!a(this.Lf) && !this.j && this.Ld != null && !this.B) {
            if (this.Le != null && System.currentTimeMillis() - this.v > 30000) {
                this.Ld = this.Le;
                this.Le = null;
            }
            if (f.lY().f()) {
                this.Ld.setDirection(f.lY().ma());
            }
            com.baidu.location.a.a.lV().a(this.Ld);
            k();
            return;
        }
        this.u = System.currentTimeMillis();
        String a2 = a((String) null);
        if (a2 == null) {
            if (this.Ld != null) {
                com.baidu.location.a.a.lV().a(this.Ld);
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
        this.Lc.a(a2);
        this.Lg = this.KY;
        this.Lf = this.KX;
        if (j()) {
            this.Lg = this.KY;
            this.Lf = this.KX;
        }
        if (com.baidu.location.e.d.mv().h()) {
            if (this.Ll == null) {
                this.Ll = new a();
            }
            this.g.postDelayed(this.Ll, com.baidu.location.e.d.mv().bN(com.baidu.location.f.c.a(com.baidu.location.f.c.mN().e())));
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
                if (this.Lg != null) {
                    gVar.b(this.Lg.h());
                    gVar.b("&offtag=1");
                }
                com.baidu.location.c.f.mr().a(gVar);
                this.G = true;
                com.baidu.location.a.a.lV().a(bDLocation2);
                this.Ld = bDLocation2;
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
        if (this.Ld != null) {
            j.mi().c();
        }
    }

    public static synchronized e lX() {
        e eVar;
        synchronized (e.class) {
            if (Lb == null) {
                Lb = new e();
            }
            eVar = Lb;
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
                    if (this.Lj != null) {
                        bDLocation2.setAddr(this.Lj);
                    }
                    if (this.x != null) {
                        bDLocation2.setLocationDescribe(this.x);
                    }
                    if (this.y != null) {
                        bDLocation2.setPoiList(this.y);
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
                if (this.j || this.Ld == null) {
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
                    com.baidu.location.a.a.lV().a(this.Ld);
                }
            }
            com.baidu.location.c.f.mr().ms().d(SystemClock.uptimeMillis());
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                this.Ld = null;
                com.baidu.location.c.f.mr().ms().a("off");
                if (this.Lg != null) {
                    com.baidu.location.c.f.mr().ms().b(this.Lg.h());
                }
                com.baidu.location.c.f.mr().c();
            } else {
                this.Ld = bDLocation;
                com.baidu.location.c.f.mr().ms().a("ofs");
                if (this.Lg != null) {
                    com.baidu.location.c.f.mr().ms().b(this.Lg.h());
                }
                com.baidu.location.c.f.mr().c();
            }
            this.Le = null;
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
            this.Lj = bDLocation.getAddress();
            this.z = bDLocation.getLongitude();
            this.Lk = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.x = bDLocation.getLocationDescribe();
            this.z = bDLocation.getLongitude();
            this.Lk = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.y = bDLocation.getPoiList();
            this.z = bDLocation.getLongitude();
            this.Lk = bDLocation.getLatitude();
        }
        if (com.baidu.location.f.f.mQ().i()) {
            BDLocation bDLocation3 = new BDLocation(com.baidu.location.f.f.mQ().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.Lk, this.z, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.Lj != null) {
                        bDLocation3.setAddr(this.Lj);
                    }
                    if (this.x != null) {
                        bDLocation3.setLocationDescribe(this.x);
                    }
                    if (this.y != null) {
                        bDLocation3.setPoiList(this.y);
                    }
                }
            }
            com.baidu.location.a.a.lV().a(bDLocation3);
            k();
        } else if (bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("sky")) {
            bDLocation.setNetworkLocationType("wf");
            com.baidu.location.a.a.lV().a(bDLocation);
            this.v = System.currentTimeMillis();
            this.Ld = bDLocation;
        } else if (this.G) {
            float[] fArr2 = new float[2];
            if (this.Ld != null) {
                Location.distanceBetween(this.Ld.getLatitude(), this.Ld.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
            }
            if (fArr2[0] > 10.0f) {
                this.Ld = bDLocation;
                if (!this.H) {
                    this.H = false;
                    com.baidu.location.a.a.lV().a(bDLocation);
                }
            }
            k();
        } else {
            com.baidu.location.c.f.mr().ms().c(SystemClock.uptimeMillis());
            this.Le = null;
            if (bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && this.Ld != null && this.Ld.getLocType() == 161 && "wf".equals(this.Ld.getNetworkLocationType()) && System.currentTimeMillis() - this.v < 30000) {
                z = true;
                this.Le = bDLocation;
            } else {
                z = false;
            }
            if (z) {
                com.baidu.location.a.a.lV().a(this.Ld);
            } else {
                com.baidu.location.a.a.lV().a(bDLocation);
                this.v = System.currentTimeMillis();
                com.baidu.location.c.f.mr().ms().d(SystemClock.uptimeMillis());
                if (bDLocation.getLocType() == 161) {
                    com.baidu.location.c.f.mr().ms().a("ons");
                    if (this.Lg != null) {
                        com.baidu.location.c.f.mr().ms().b(this.Lg.h());
                    }
                } else {
                    com.baidu.location.c.f.mr().ms().a("onf");
                    if (this.Lg != null) {
                        com.baidu.location.c.f.mr().ms().b(this.Lg.h());
                    }
                    com.baidu.location.c.f.mr().c();
                }
            }
            if (!com.baidu.location.h.i.d(bDLocation)) {
                this.Ld = null;
            } else if (!z) {
                this.Ld = bDLocation;
            }
            int h2 = com.baidu.location.h.i.h(c, "ssid\":\"", "\"");
            if (h2 == Integer.MIN_VALUE || this.Lf == null) {
                this.k = null;
            } else {
                this.k = this.Lf.c(h2);
            }
            if (com.baidu.location.e.d.mv().d() && bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && b(this.Lg)) {
                com.baidu.location.e.d.mv().a(this.Lg, null, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.Li = this.Lg;
            }
            if (com.baidu.location.e.d.mv().d() && bDLocation.getLocType() == 161 && "wf".equals(bDLocation.getNetworkLocationType())) {
                com.baidu.location.e.d.mv().a(null, this.Lf, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.Lh = this.Lf;
            }
            if (this.Lg != null) {
                com.baidu.location.e.a.mu().a(c, this.Lg, this.Lf, bDLocation2);
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
                this.y = null;
                this.B = true;
                i(null);
            } else if (this.Lj != null) {
                return this.Lj;
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
            com.baidu.location.c.a.mm().d();
            return;
        }
        j(null);
        this.t = false;
    }

    public void i() {
        this.Ld = null;
    }
}
