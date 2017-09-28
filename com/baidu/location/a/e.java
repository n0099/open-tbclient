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
    private static e Lv = null;
    public static boolean h = false;
    private double LF;
    public d.b Lw;
    private double z;
    final int e = 1000;
    private boolean j = true;
    private String k = null;
    private BDLocation Lx = null;
    private BDLocation Ly = null;
    private com.baidu.location.f.i Lz = null;
    private com.baidu.location.f.a LA = null;
    private com.baidu.location.f.i LB = null;
    private com.baidu.location.f.a LC = null;
    private boolean r = true;
    private volatile boolean s = false;
    private boolean t = false;
    private long u = 0;
    private long LD = 0;
    private Address LE = null;
    private String x = null;
    private List<Poi> y = null;
    private boolean B = false;
    private long LG = 0;
    private long LH = 0;
    private a LI = null;
    private boolean F = false;
    private boolean G = false;
    private boolean H = true;
    public final Handler g = new d.a();
    private boolean I = false;
    private b LJ = null;
    private boolean LK = false;

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
            if (e.this.LK) {
                e.this.LK = false;
            }
            if (e.this.t) {
                e.this.t = false;
                e.this.j(null);
            }
        }
    }

    private e() {
        this.Lw = null;
        this.Lw = new d.b();
    }

    private boolean a(com.baidu.location.f.a aVar) {
        this.Ls = com.baidu.location.f.c.mX().mT();
        if (this.Ls == aVar) {
            return false;
        }
        return this.Ls == null || aVar == null || !aVar.a(this.Ls);
    }

    private boolean a(com.baidu.location.f.i iVar) {
        this.Lr = com.baidu.location.f.k.ng().ne();
        if (iVar == this.Lr) {
            return false;
        }
        return this.Lr == null || iVar == null || !iVar.c(this.Lr);
    }

    private boolean b(com.baidu.location.f.a aVar) {
        if (aVar == null) {
            return false;
        }
        return this.LC == null || !aVar.a(this.LC);
    }

    private void c(Message message) {
        boolean z = message.getData().getBoolean("isWaitingLocTag", false);
        if (z) {
            h = true;
        }
        if (z) {
        }
        int e = com.baidu.location.a.a.me().e(message);
        f.mh().d();
        switch (e) {
            case 1:
                g(message);
                return;
            case 2:
                i(message);
                return;
            case 3:
                if (com.baidu.location.f.f.na().i()) {
                    h(message);
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(e)));
        }
    }

    private void g(Message message) {
        if (com.baidu.location.f.f.na().i()) {
            h(message);
            f.mh().c();
            return;
        }
        i(message);
        f.mh().b();
    }

    private void h(Message message) {
        BDLocation bDLocation = new BDLocation(com.baidu.location.f.f.na().f());
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.LF, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.LE != null) {
                    bDLocation.setAddr(this.LE);
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
        this.Lx = bDLocation;
        this.Ly = null;
        com.baidu.location.a.a.me().a(bDLocation);
    }

    private void i(Message message) {
        if (this.r) {
            this.LH = SystemClock.uptimeMillis();
            j(message);
        } else if (this.s) {
        } else {
            this.LH = SystemClock.uptimeMillis();
            if (!com.baidu.location.f.k.ng().e()) {
                j(message);
                return;
            }
            this.t = true;
            if (this.LJ == null) {
                this.LJ = new b();
            }
            if (this.LK && this.LJ != null) {
                this.g.removeCallbacks(this.LJ);
            }
            this.g.postDelayed(this.LJ, 3500L);
            this.LK = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Message message) {
        if (this.s) {
            return;
        }
        if (System.currentTimeMillis() - this.u < 1000 && this.Lx != null) {
            com.baidu.location.a.a.me().a(this.Lx);
            k();
            return;
        }
        if (this.LH > 0) {
            com.baidu.location.c.f.mA().mB().a(this.LH);
        } else {
            com.baidu.location.c.f.mA().mB().a(SystemClock.uptimeMillis());
        }
        this.s = true;
        this.j = a(this.LA);
        if (!a(this.Lz) && !this.j && this.Lx != null && !this.B) {
            if (this.Ly != null && System.currentTimeMillis() - this.LD > 30000) {
                this.Lx = this.Ly;
                this.Ly = null;
            }
            if (f.mh().f()) {
                this.Lx.setDirection(f.mh().mj());
            }
            com.baidu.location.a.a.me().a(this.Lx);
            k();
            return;
        }
        this.u = System.currentTimeMillis();
        String a2 = a((String) null);
        if (a2 == null) {
            if (this.Lx != null) {
                com.baidu.location.a.a.me().a(this.Lx);
                k();
                return;
            }
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLocType(62);
            com.baidu.location.a.a.me().a(bDLocation);
            k();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.LG > 60000) {
                this.LG = currentTimeMillis;
                com.baidu.location.c.f.mA().a("TypeCriteriaException");
                return;
            }
            return;
        }
        if (this.k != null) {
            a2 = a2 + this.k;
            this.k = null;
        }
        com.baidu.location.c.f.mA().mB().b(SystemClock.uptimeMillis());
        this.Lw.a(a2);
        this.LA = this.Ls;
        this.Lz = this.Lr;
        if (j()) {
            this.LA = this.Ls;
            this.Lz = this.Lr;
        }
        if (com.baidu.location.e.d.mE().h()) {
            if (this.LI == null) {
                this.LI = new a();
            }
            this.g.postDelayed(this.LI, com.baidu.location.e.d.mE().bO(com.baidu.location.f.c.a(com.baidu.location.f.c.mX().e())));
            this.F = true;
        }
        if (this.r) {
            this.r = false;
            if (com.baidu.location.f.k.ng().g() && message != null && com.baidu.location.a.a.me().f(message) < 1000 && com.baidu.location.e.d.mE().d()) {
                com.baidu.location.e.d.mE().i();
            }
            com.baidu.location.c.a.mv().b();
        }
    }

    private boolean j() {
        BDLocation bDLocation = null;
        double random = Math.random();
        long uptimeMillis = SystemClock.uptimeMillis();
        com.baidu.location.f.a mT = com.baidu.location.f.c.mX().mT();
        com.baidu.location.f.i nd = com.baidu.location.f.k.ng().nd();
        boolean z = mT != null && mT.e() && (nd == null || nd.a() == 0);
        if (com.baidu.location.e.d.mE().d() && com.baidu.location.e.d.mE().f() && (z || (0.0d < random && random < com.baidu.location.e.d.mE().o()))) {
            bDLocation = com.baidu.location.e.d.mE().a(com.baidu.location.f.c.mX().mT(), com.baidu.location.f.k.ng().nd(), null, d.b.IS_MIX_MODE, d.a.NEED_TO_LOG);
        }
        if (bDLocation != null && bDLocation.getLocType() == 66 && this.s) {
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            bDLocation2.setLocType(BDLocation.TypeNetWorkLocation);
            if (this.s) {
                com.baidu.location.c.g gVar = new com.baidu.location.c.g();
                gVar.a(this.LH);
                gVar.b(uptimeMillis);
                gVar.c(uptimeMillis);
                gVar.d(SystemClock.uptimeMillis());
                gVar.a("ofs");
                if (this.LA != null) {
                    gVar.b(this.LA.h());
                    gVar.b("&offtag=1");
                }
                com.baidu.location.c.f.mA().a(gVar);
                this.G = true;
                com.baidu.location.a.a.me().a(bDLocation2);
                this.Lx = bDLocation2;
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
        if (this.Lx != null) {
            j.mr().c();
        }
    }

    public static synchronized e mg() {
        e eVar;
        synchronized (e.class) {
            if (Lv == null) {
                Lv = new e();
            }
            eVar = Lv;
        }
        return eVar;
    }

    @Override // com.baidu.location.a.d
    public void a() {
        BDLocation bDLocation;
        if (this.LI != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.LI);
        }
        if (com.baidu.location.f.f.na().i()) {
            BDLocation bDLocation2 = new BDLocation(com.baidu.location.f.f.na().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.LF, this.z, bDLocation2.getLatitude(), bDLocation2.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.LE != null) {
                        bDLocation2.setAddr(this.LE);
                    }
                    if (this.x != null) {
                        bDLocation2.setLocationDescribe(this.x);
                    }
                    if (this.y != null) {
                        bDLocation2.setPoiList(this.y);
                    }
                }
            }
            com.baidu.location.a.a.me().a(bDLocation2);
            k();
        } else if (this.G) {
            k();
        } else {
            com.baidu.location.c.f.mA().mB().c(SystemClock.uptimeMillis());
            if (com.baidu.location.e.d.mE().d() && com.baidu.location.e.d.mE().e()) {
                bDLocation = com.baidu.location.e.d.mE().a(com.baidu.location.f.c.mX().mT(), com.baidu.location.f.k.ng().nd(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
                if (bDLocation != null && bDLocation.getLocType() == 66) {
                    com.baidu.location.a.a.me().a(bDLocation);
                }
            } else {
                bDLocation = null;
            }
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                if (this.j || this.Lx == null) {
                    BDLocation ab = com.baidu.location.e.a.mD().ab(false);
                    com.baidu.location.a.a.me().a(ab);
                    boolean z = true;
                    if (com.baidu.location.h.i.f.equals("all") && ab.getAddrStr() == null) {
                        z = false;
                    }
                    if (com.baidu.location.h.i.g && ab.getLocationDescribe() == null) {
                        z = false;
                    }
                    if (com.baidu.location.h.i.h && ab.getPoiList() == null) {
                        z = false;
                    }
                    if (!z) {
                        ab.setLocType(67);
                    }
                    bDLocation = ab;
                } else {
                    com.baidu.location.a.a.me().a(this.Lx);
                }
            }
            com.baidu.location.c.f.mA().mB().d(SystemClock.uptimeMillis());
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                this.Lx = null;
                com.baidu.location.c.f.mA().mB().a("off");
                if (this.LA != null) {
                    com.baidu.location.c.f.mA().mB().b(this.LA.h());
                }
                com.baidu.location.c.f.mA().c();
            } else {
                this.Lx = bDLocation;
                com.baidu.location.c.f.mA().mB().a("ofs");
                if (this.LA != null) {
                    com.baidu.location.c.f.mA().mB().b(this.LA.h());
                }
                com.baidu.location.c.f.mA().c();
            }
            this.Ly = null;
            k();
        }
    }

    @Override // com.baidu.location.a.d
    public void a(Message message) {
        boolean z;
        if (this.LI != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.LI);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            this.LE = bDLocation.getAddress();
            this.z = bDLocation.getLongitude();
            this.LF = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.x = bDLocation.getLocationDescribe();
            this.z = bDLocation.getLongitude();
            this.LF = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.y = bDLocation.getPoiList();
            this.z = bDLocation.getLongitude();
            this.LF = bDLocation.getLatitude();
        }
        if (com.baidu.location.f.f.na().i()) {
            BDLocation bDLocation3 = new BDLocation(com.baidu.location.f.f.na().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.LF, this.z, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.LE != null) {
                        bDLocation3.setAddr(this.LE);
                    }
                    if (this.x != null) {
                        bDLocation3.setLocationDescribe(this.x);
                    }
                    if (this.y != null) {
                        bDLocation3.setPoiList(this.y);
                    }
                }
            }
            com.baidu.location.a.a.me().a(bDLocation3);
            k();
        } else if (bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("sky")) {
            bDLocation.setNetworkLocationType("wf");
            com.baidu.location.a.a.me().a(bDLocation);
            this.LD = System.currentTimeMillis();
            this.Lx = bDLocation;
        } else if (this.G) {
            float[] fArr2 = new float[2];
            if (this.Lx != null) {
                Location.distanceBetween(this.Lx.getLatitude(), this.Lx.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
            }
            if (fArr2[0] > 10.0f) {
                this.Lx = bDLocation;
                if (!this.H) {
                    this.H = false;
                    com.baidu.location.a.a.me().a(bDLocation);
                }
            }
            k();
        } else {
            com.baidu.location.c.f.mA().mB().c(SystemClock.uptimeMillis());
            this.Ly = null;
            if (bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && this.Lx != null && this.Lx.getLocType() == 161 && "wf".equals(this.Lx.getNetworkLocationType()) && System.currentTimeMillis() - this.LD < 30000) {
                z = true;
                this.Ly = bDLocation;
            } else {
                z = false;
            }
            if (z) {
                com.baidu.location.a.a.me().a(this.Lx);
            } else {
                com.baidu.location.a.a.me().a(bDLocation);
                this.LD = System.currentTimeMillis();
                com.baidu.location.c.f.mA().mB().d(SystemClock.uptimeMillis());
                if (bDLocation.getLocType() == 161) {
                    com.baidu.location.c.f.mA().mB().a("ons");
                    if (this.LA != null) {
                        com.baidu.location.c.f.mA().mB().b(this.LA.h());
                    }
                } else {
                    com.baidu.location.c.f.mA().mB().a("onf");
                    if (this.LA != null) {
                        com.baidu.location.c.f.mA().mB().b(this.LA.h());
                    }
                    com.baidu.location.c.f.mA().c();
                }
            }
            if (!com.baidu.location.h.i.d(bDLocation)) {
                this.Lx = null;
            } else if (!z) {
                this.Lx = bDLocation;
            }
            int h2 = com.baidu.location.h.i.h(c, "ssid\":\"", "\"");
            if (h2 == Integer.MIN_VALUE || this.Lz == null) {
                this.k = null;
            } else {
                this.k = this.Lz.c(h2);
            }
            if (com.baidu.location.e.d.mE().d() && bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && b(this.LA)) {
                com.baidu.location.e.d.mE().a(this.LA, null, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.LC = this.LA;
            }
            if (com.baidu.location.e.d.mE().d() && bDLocation.getLocType() == 161 && "wf".equals(bDLocation.getNetworkLocationType())) {
                com.baidu.location.e.d.mE().a(null, this.Lz, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.LB = this.Lz;
            }
            if (this.LA != null) {
                com.baidu.location.e.a.mD().a(c, this.LA, this.Lz, bDLocation2);
            }
            if (com.baidu.location.f.k.ng().g()) {
                com.baidu.location.e.d.mE().i();
                com.baidu.location.e.d.mE().m();
            }
            k();
        }
    }

    public void a(boolean z) {
        BDLocation bDLocation = null;
        if (com.baidu.location.e.d.mE().d() && com.baidu.location.e.d.mE().g()) {
            bDLocation = com.baidu.location.e.d.mE().a(com.baidu.location.f.c.mX().mT(), com.baidu.location.f.k.ng().nd(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
            if ((bDLocation == null || bDLocation.getLocType() == 67) && z) {
                bDLocation = com.baidu.location.e.a.mD().ab(false);
            }
        } else if (z) {
            bDLocation = com.baidu.location.e.a.mD().ab(false);
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
            com.baidu.location.a.a.me().a(bDLocation);
        }
    }

    public Address b(BDLocation bDLocation) {
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.LF, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] >= 100.0f) {
                this.x = null;
                this.y = null;
                this.B = true;
                i(null);
            } else if (this.LE != null) {
                return this.LE;
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
            com.baidu.location.c.a.mv().d();
            return;
        }
        j(null);
        this.t = false;
    }

    public void i() {
        this.Lx = null;
    }
}
