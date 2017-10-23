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
    private static e Lp = null;
    public static boolean h = false;
    public d.b Lq;
    private double Lz;
    private double z;
    final int e = 1000;
    private boolean j = true;
    private String k = null;
    private BDLocation Lr = null;
    private BDLocation Ls = null;
    private com.baidu.location.f.i Lt = null;
    private com.baidu.location.f.a Lu = null;
    private com.baidu.location.f.i Lv = null;
    private com.baidu.location.f.a Lw = null;
    private boolean r = true;
    private volatile boolean s = false;
    private boolean t = false;
    private long u = 0;
    private long Lx = 0;
    private Address Ly = null;
    private String x = null;
    private List<Poi> y = null;
    private boolean B = false;
    private long C = 0;
    private long D = 0;
    private a LA = null;
    private boolean F = false;
    private boolean G = false;
    private boolean H = true;
    public final Handler g = new d.a();
    private boolean I = false;
    private b LB = null;
    private boolean LC = false;

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
            if (e.this.LC) {
                e.this.LC = false;
            }
            if (e.this.t) {
                e.this.t = false;
                e.this.j(null);
            }
        }
    }

    private e() {
        this.Lq = null;
        this.Lq = new d.b();
    }

    private boolean a(com.baidu.location.f.a aVar) {
        this.Lm = com.baidu.location.f.c.mR().mN();
        if (this.Lm == aVar) {
            return false;
        }
        return this.Lm == null || aVar == null || !aVar.a(this.Lm);
    }

    private boolean a(com.baidu.location.f.i iVar) {
        this.Ll = com.baidu.location.f.k.na().mY();
        if (iVar == this.Ll) {
            return false;
        }
        return this.Ll == null || iVar == null || !iVar.c(this.Ll);
    }

    private boolean b(com.baidu.location.f.a aVar) {
        if (aVar == null) {
            return false;
        }
        return this.Lw == null || !aVar.a(this.Lw);
    }

    private void c(Message message) {
        boolean z = message.getData().getBoolean("isWaitingLocTag", false);
        if (z) {
            h = true;
        }
        if (z) {
        }
        int e = com.baidu.location.a.a.lY().e(message);
        f.mb().d();
        switch (e) {
            case 1:
                g(message);
                return;
            case 2:
                i(message);
                return;
            case 3:
                if (com.baidu.location.f.f.mU().i()) {
                    h(message);
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(e)));
        }
    }

    private void g(Message message) {
        if (com.baidu.location.f.f.mU().i()) {
            h(message);
            f.mb().c();
            return;
        }
        i(message);
        f.mb().b();
    }

    private void h(Message message) {
        BDLocation bDLocation = new BDLocation(com.baidu.location.f.f.mU().f());
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.Lz, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.Ly != null) {
                    bDLocation.setAddr(this.Ly);
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
        this.Lr = bDLocation;
        this.Ls = null;
        com.baidu.location.a.a.lY().a(bDLocation);
    }

    private void i(Message message) {
        if (this.r) {
            this.D = SystemClock.uptimeMillis();
            j(message);
        } else if (this.s) {
        } else {
            this.D = SystemClock.uptimeMillis();
            if (!com.baidu.location.f.k.na().e()) {
                j(message);
                return;
            }
            this.t = true;
            if (this.LB == null) {
                this.LB = new b();
            }
            if (this.LC && this.LB != null) {
                this.g.removeCallbacks(this.LB);
            }
            this.g.postDelayed(this.LB, 3500L);
            this.LC = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Message message) {
        if (this.s) {
            return;
        }
        if (System.currentTimeMillis() - this.u < 1000 && this.Lr != null) {
            com.baidu.location.a.a.lY().a(this.Lr);
            k();
            return;
        }
        if (this.D > 0) {
            com.baidu.location.c.f.mu().mv().a(this.D);
        } else {
            com.baidu.location.c.f.mu().mv().a(SystemClock.uptimeMillis());
        }
        this.s = true;
        this.j = a(this.Lu);
        if (!a(this.Lt) && !this.j && this.Lr != null && !this.B) {
            if (this.Ls != null && System.currentTimeMillis() - this.Lx > 30000) {
                this.Lr = this.Ls;
                this.Ls = null;
            }
            if (f.mb().f()) {
                this.Lr.setDirection(f.mb().md());
            }
            com.baidu.location.a.a.lY().a(this.Lr);
            k();
            return;
        }
        this.u = System.currentTimeMillis();
        String a2 = a((String) null);
        if (a2 == null) {
            if (this.Lr != null) {
                com.baidu.location.a.a.lY().a(this.Lr);
                k();
                return;
            }
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLocType(62);
            com.baidu.location.a.a.lY().a(bDLocation);
            k();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.C > 60000) {
                this.C = currentTimeMillis;
                com.baidu.location.c.f.mu().a("TypeCriteriaException");
                return;
            }
            return;
        }
        if (this.k != null) {
            a2 = a2 + this.k;
            this.k = null;
        }
        com.baidu.location.c.f.mu().mv().b(SystemClock.uptimeMillis());
        this.Lq.a(a2);
        this.Lu = this.Lm;
        this.Lt = this.Ll;
        if (j()) {
            this.Lu = this.Lm;
            this.Lt = this.Ll;
        }
        if (com.baidu.location.e.d.my().h()) {
            if (this.LA == null) {
                this.LA = new a();
            }
            this.g.postDelayed(this.LA, com.baidu.location.e.d.my().bN(com.baidu.location.f.c.a(com.baidu.location.f.c.mR().e())));
            this.F = true;
        }
        if (this.r) {
            this.r = false;
            if (com.baidu.location.f.k.na().g() && message != null && com.baidu.location.a.a.lY().f(message) < 1000 && com.baidu.location.e.d.my().d()) {
                com.baidu.location.e.d.my().i();
            }
            com.baidu.location.c.a.mp().b();
        }
    }

    private boolean j() {
        BDLocation bDLocation = null;
        double random = Math.random();
        long uptimeMillis = SystemClock.uptimeMillis();
        com.baidu.location.f.a mN = com.baidu.location.f.c.mR().mN();
        com.baidu.location.f.i mX = com.baidu.location.f.k.na().mX();
        boolean z = mN != null && mN.e() && (mX == null || mX.a() == 0);
        if (com.baidu.location.e.d.my().d() && com.baidu.location.e.d.my().f() && (z || (0.0d < random && random < com.baidu.location.e.d.my().o()))) {
            bDLocation = com.baidu.location.e.d.my().a(com.baidu.location.f.c.mR().mN(), com.baidu.location.f.k.na().mX(), null, d.b.IS_MIX_MODE, d.a.NEED_TO_LOG);
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
                if (this.Lu != null) {
                    gVar.b(this.Lu.h());
                    gVar.b("&offtag=1");
                }
                com.baidu.location.c.f.mu().a(gVar);
                this.G = true;
                com.baidu.location.a.a.lY().a(bDLocation2);
                this.Lr = bDLocation2;
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
        if (this.Lr != null) {
            j.ml().c();
        }
    }

    public static synchronized e ma() {
        e eVar;
        synchronized (e.class) {
            if (Lp == null) {
                Lp = new e();
            }
            eVar = Lp;
        }
        return eVar;
    }

    @Override // com.baidu.location.a.d
    public void a() {
        BDLocation bDLocation;
        if (this.LA != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.LA);
        }
        if (com.baidu.location.f.f.mU().i()) {
            BDLocation bDLocation2 = new BDLocation(com.baidu.location.f.f.mU().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.Lz, this.z, bDLocation2.getLatitude(), bDLocation2.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.Ly != null) {
                        bDLocation2.setAddr(this.Ly);
                    }
                    if (this.x != null) {
                        bDLocation2.setLocationDescribe(this.x);
                    }
                    if (this.y != null) {
                        bDLocation2.setPoiList(this.y);
                    }
                }
            }
            com.baidu.location.a.a.lY().a(bDLocation2);
            k();
        } else if (this.G) {
            k();
        } else {
            com.baidu.location.c.f.mu().mv().c(SystemClock.uptimeMillis());
            if (com.baidu.location.e.d.my().d() && com.baidu.location.e.d.my().e()) {
                bDLocation = com.baidu.location.e.d.my().a(com.baidu.location.f.c.mR().mN(), com.baidu.location.f.k.na().mX(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
                if (bDLocation != null && bDLocation.getLocType() == 66) {
                    com.baidu.location.a.a.lY().a(bDLocation);
                }
            } else {
                bDLocation = null;
            }
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                if (this.j || this.Lr == null) {
                    BDLocation aa = com.baidu.location.e.a.mx().aa(false);
                    com.baidu.location.a.a.lY().a(aa);
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
                    com.baidu.location.a.a.lY().a(this.Lr);
                }
            }
            com.baidu.location.c.f.mu().mv().d(SystemClock.uptimeMillis());
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                this.Lr = null;
                com.baidu.location.c.f.mu().mv().a("off");
                if (this.Lu != null) {
                    com.baidu.location.c.f.mu().mv().b(this.Lu.h());
                }
                com.baidu.location.c.f.mu().c();
            } else {
                this.Lr = bDLocation;
                com.baidu.location.c.f.mu().mv().a("ofs");
                if (this.Lu != null) {
                    com.baidu.location.c.f.mu().mv().b(this.Lu.h());
                }
                com.baidu.location.c.f.mu().c();
            }
            this.Ls = null;
            k();
        }
    }

    @Override // com.baidu.location.a.d
    public void a(Message message) {
        boolean z;
        if (this.LA != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.LA);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            this.Ly = bDLocation.getAddress();
            this.z = bDLocation.getLongitude();
            this.Lz = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.x = bDLocation.getLocationDescribe();
            this.z = bDLocation.getLongitude();
            this.Lz = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.y = bDLocation.getPoiList();
            this.z = bDLocation.getLongitude();
            this.Lz = bDLocation.getLatitude();
        }
        if (com.baidu.location.f.f.mU().i()) {
            BDLocation bDLocation3 = new BDLocation(com.baidu.location.f.f.mU().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.Lz, this.z, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.Ly != null) {
                        bDLocation3.setAddr(this.Ly);
                    }
                    if (this.x != null) {
                        bDLocation3.setLocationDescribe(this.x);
                    }
                    if (this.y != null) {
                        bDLocation3.setPoiList(this.y);
                    }
                }
            }
            com.baidu.location.a.a.lY().a(bDLocation3);
            k();
        } else if (bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("sky")) {
            bDLocation.setNetworkLocationType("wf");
            com.baidu.location.a.a.lY().a(bDLocation);
            this.Lx = System.currentTimeMillis();
            this.Lr = bDLocation;
        } else if (this.G) {
            float[] fArr2 = new float[2];
            if (this.Lr != null) {
                Location.distanceBetween(this.Lr.getLatitude(), this.Lr.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
            }
            if (fArr2[0] > 10.0f) {
                this.Lr = bDLocation;
                if (!this.H) {
                    this.H = false;
                    com.baidu.location.a.a.lY().a(bDLocation);
                }
            }
            k();
        } else {
            com.baidu.location.c.f.mu().mv().c(SystemClock.uptimeMillis());
            this.Ls = null;
            if (bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && this.Lr != null && this.Lr.getLocType() == 161 && "wf".equals(this.Lr.getNetworkLocationType()) && System.currentTimeMillis() - this.Lx < 30000) {
                z = true;
                this.Ls = bDLocation;
            } else {
                z = false;
            }
            if (z) {
                com.baidu.location.a.a.lY().a(this.Lr);
            } else {
                com.baidu.location.a.a.lY().a(bDLocation);
                this.Lx = System.currentTimeMillis();
                com.baidu.location.c.f.mu().mv().d(SystemClock.uptimeMillis());
                if (bDLocation.getLocType() == 161) {
                    com.baidu.location.c.f.mu().mv().a("ons");
                    if (this.Lu != null) {
                        com.baidu.location.c.f.mu().mv().b(this.Lu.h());
                    }
                } else {
                    com.baidu.location.c.f.mu().mv().a("onf");
                    if (this.Lu != null) {
                        com.baidu.location.c.f.mu().mv().b(this.Lu.h());
                    }
                    com.baidu.location.c.f.mu().c();
                }
            }
            if (!com.baidu.location.h.i.d(bDLocation)) {
                this.Lr = null;
            } else if (!z) {
                this.Lr = bDLocation;
            }
            int h2 = com.baidu.location.h.i.h(c, "ssid\":\"", "\"");
            if (h2 == Integer.MIN_VALUE || this.Lt == null) {
                this.k = null;
            } else {
                this.k = this.Lt.c(h2);
            }
            if (com.baidu.location.e.d.my().d() && bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && b(this.Lu)) {
                com.baidu.location.e.d.my().a(this.Lu, null, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.Lw = this.Lu;
            }
            if (com.baidu.location.e.d.my().d() && bDLocation.getLocType() == 161 && "wf".equals(bDLocation.getNetworkLocationType())) {
                com.baidu.location.e.d.my().a(null, this.Lt, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.Lv = this.Lt;
            }
            if (this.Lu != null) {
                com.baidu.location.e.a.mx().a(c, this.Lu, this.Lt, bDLocation2);
            }
            if (com.baidu.location.f.k.na().g()) {
                com.baidu.location.e.d.my().i();
                com.baidu.location.e.d.my().m();
            }
            k();
        }
    }

    public void a(boolean z) {
        BDLocation bDLocation = null;
        if (com.baidu.location.e.d.my().d() && com.baidu.location.e.d.my().g()) {
            bDLocation = com.baidu.location.e.d.my().a(com.baidu.location.f.c.mR().mN(), com.baidu.location.f.k.na().mX(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
            if ((bDLocation == null || bDLocation.getLocType() == 67) && z) {
                bDLocation = com.baidu.location.e.a.mx().aa(false);
            }
        } else if (z) {
            bDLocation = com.baidu.location.e.a.mx().aa(false);
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
            com.baidu.location.a.a.lY().a(bDLocation);
        }
    }

    public Address b(BDLocation bDLocation) {
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.Lz, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] >= 100.0f) {
                this.x = null;
                this.y = null;
                this.B = true;
                i(null);
            } else if (this.Ly != null) {
                return this.Ly;
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
            com.baidu.location.c.a.mp().d();
            return;
        }
        j(null);
        this.t = false;
    }

    public void i() {
        this.Lr = null;
    }
}
