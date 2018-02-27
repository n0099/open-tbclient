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
    private static e aBs = null;
    public static boolean h = false;
    private double aBC;
    public d.b aBt;
    private double z;
    final int e = 1000;
    private boolean j = true;
    private String k = null;
    private BDLocation aBu = null;
    private BDLocation aBv = null;
    private com.baidu.location.f.i aBw = null;
    private com.baidu.location.f.a aBx = null;
    private com.baidu.location.f.i aBy = null;
    private com.baidu.location.f.a aBz = null;
    private boolean r = true;
    private volatile boolean s = false;
    private boolean t = false;
    private long u = 0;
    private long v = 0;
    private Address aBA = null;
    private String x = null;
    private List<Poi> aBB = null;
    private boolean B = false;
    private long C = 0;
    private long D = 0;
    private a aBD = null;
    private boolean F = false;
    private boolean G = false;
    private boolean H = true;
    public final Handler g = new d.a();
    private boolean I = false;
    private b aBE = null;
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
        this.aBt = null;
        this.aBt = new d.b();
    }

    private boolean a(com.baidu.location.f.a aVar) {
        this.aBp = com.baidu.location.f.c.vd().uZ();
        if (this.aBp == aVar) {
            return false;
        }
        return this.aBp == null || aVar == null || !aVar.a(this.aBp);
    }

    private boolean a(com.baidu.location.f.i iVar) {
        this.aBo = com.baidu.location.f.k.vm().vk();
        if (iVar == this.aBo) {
            return false;
        }
        return this.aBo == null || iVar == null || !iVar.c(this.aBo);
    }

    private boolean b(com.baidu.location.f.a aVar) {
        if (aVar == null) {
            return false;
        }
        return this.aBz == null || !aVar.a(this.aBz);
    }

    private void c(Message message) {
        boolean z = message.getData().getBoolean("isWaitingLocTag", false);
        if (z) {
            h = true;
        }
        if (z) {
        }
        int g = com.baidu.location.a.a.un().g(message);
        f.uq().d();
        switch (g) {
            case 1:
                d(message);
                return;
            case 2:
                i(message);
                return;
            case 3:
                if (com.baidu.location.f.f.vg().i()) {
                    e(message);
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(g)));
        }
    }

    private void d(Message message) {
        if (com.baidu.location.f.f.vg().i()) {
            e(message);
            f.uq().c();
            return;
        }
        i(message);
        f.uq().b();
    }

    private void e(Message message) {
        BDLocation bDLocation = new BDLocation(com.baidu.location.f.f.vg().f());
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.aBC, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.aBA != null) {
                    bDLocation.setAddr(this.aBA);
                }
                if (this.x != null) {
                    bDLocation.setLocationDescribe(this.x);
                }
                if (this.aBB != null) {
                    bDLocation.setPoiList(this.aBB);
                }
            } else {
                this.B = true;
                i(null);
            }
        }
        this.aBu = bDLocation;
        this.aBv = null;
        com.baidu.location.a.a.un().a(bDLocation);
    }

    private void i(Message message) {
        if (this.r) {
            this.D = SystemClock.uptimeMillis();
            j(message);
        } else if (this.s) {
        } else {
            this.D = SystemClock.uptimeMillis();
            if (!com.baidu.location.f.k.vm().e()) {
                j(message);
                return;
            }
            this.t = true;
            if (this.aBE == null) {
                this.aBE = new b();
            }
            if (this.K && this.aBE != null) {
                this.g.removeCallbacks(this.aBE);
            }
            this.g.postDelayed(this.aBE, 3500L);
            this.K = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Message message) {
        if (this.s) {
            return;
        }
        if (System.currentTimeMillis() - this.u < 1000 && this.aBu != null) {
            com.baidu.location.a.a.un().a(this.aBu);
            k();
            return;
        }
        if (this.D > 0) {
            com.baidu.location.c.f.uH().uI().a(this.D);
        } else {
            com.baidu.location.c.f.uH().uI().a(SystemClock.uptimeMillis());
        }
        this.s = true;
        this.j = a(this.aBx);
        if (!a(this.aBw) && !this.j && this.aBu != null && !this.B) {
            if (this.aBv != null && System.currentTimeMillis() - this.v > StatisticConfig.MIN_UPLOAD_INTERVAL) {
                this.aBu = this.aBv;
                this.aBv = null;
            }
            if (f.uq().f()) {
                this.aBu.setDirection(f.uq().h());
            }
            com.baidu.location.a.a.un().a(this.aBu);
            k();
            return;
        }
        this.u = System.currentTimeMillis();
        String a2 = a((String) null);
        if (a2 == null) {
            if (this.aBu != null) {
                com.baidu.location.a.a.un().a(this.aBu);
                k();
                return;
            }
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLocType(62);
            com.baidu.location.a.a.un().a(bDLocation);
            k();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.C > 60000) {
                this.C = currentTimeMillis;
                com.baidu.location.c.f.uH().a("TypeCriteriaException");
                return;
            }
            return;
        }
        if (this.k != null) {
            a2 = a2 + this.k;
            this.k = null;
        }
        com.baidu.location.c.f.uH().uI().b(SystemClock.uptimeMillis());
        this.aBt.a(a2);
        this.aBx = this.aBp;
        this.aBw = this.aBo;
        if (j()) {
            this.aBx = this.aBp;
            this.aBw = this.aBo;
        }
        if (com.baidu.location.e.d.uL().h()) {
            if (this.aBD == null) {
                this.aBD = new a();
            }
            this.g.postDelayed(this.aBD, com.baidu.location.e.d.uL().a(com.baidu.location.f.c.a(com.baidu.location.f.c.vd().e())));
            this.F = true;
        }
        if (this.r) {
            this.r = false;
            if (com.baidu.location.f.k.vm().g() && message != null && com.baidu.location.a.a.un().h(message) < 1000 && com.baidu.location.e.d.uL().d()) {
                com.baidu.location.e.d.uL().i();
            }
            com.baidu.location.c.a.uC().b();
        }
    }

    private boolean j() {
        BDLocation bDLocation = null;
        double random = Math.random();
        long uptimeMillis = SystemClock.uptimeMillis();
        com.baidu.location.f.a uZ = com.baidu.location.f.c.vd().uZ();
        com.baidu.location.f.i vj = com.baidu.location.f.k.vm().vj();
        boolean z = uZ != null && uZ.e() && (vj == null || vj.a() == 0);
        if (com.baidu.location.e.d.uL().d() && com.baidu.location.e.d.uL().f() && (z || (0.0d < random && random < com.baidu.location.e.d.uL().o()))) {
            bDLocation = com.baidu.location.e.d.uL().a(com.baidu.location.f.c.vd().uZ(), com.baidu.location.f.k.vm().vj(), null, d.b.IS_MIX_MODE, d.a.NEED_TO_LOG);
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
                if (this.aBx != null) {
                    gVar.b(this.aBx.h());
                    gVar.b("&offtag=1");
                }
                com.baidu.location.c.f.uH().a(gVar);
                this.G = true;
                com.baidu.location.a.a.un().a(bDLocation2);
                this.aBu = bDLocation2;
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
        if (this.aBu != null) {
            j.uy().c();
        }
    }

    public static synchronized e up() {
        e eVar;
        synchronized (e.class) {
            if (aBs == null) {
                aBs = new e();
            }
            eVar = aBs;
        }
        return eVar;
    }

    @Override // com.baidu.location.a.d
    public void a() {
        BDLocation bDLocation;
        if (this.aBD != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.aBD);
        }
        if (com.baidu.location.f.f.vg().i()) {
            BDLocation bDLocation2 = new BDLocation(com.baidu.location.f.f.vg().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.aBC, this.z, bDLocation2.getLatitude(), bDLocation2.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.aBA != null) {
                        bDLocation2.setAddr(this.aBA);
                    }
                    if (this.x != null) {
                        bDLocation2.setLocationDescribe(this.x);
                    }
                    if (this.aBB != null) {
                        bDLocation2.setPoiList(this.aBB);
                    }
                }
            }
            com.baidu.location.a.a.un().a(bDLocation2);
            k();
        } else if (this.G) {
            k();
        } else {
            com.baidu.location.c.f.uH().uI().c(SystemClock.uptimeMillis());
            if (com.baidu.location.e.d.uL().d() && com.baidu.location.e.d.uL().e()) {
                bDLocation = com.baidu.location.e.d.uL().a(com.baidu.location.f.c.vd().uZ(), com.baidu.location.f.k.vm().vj(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
                if (bDLocation != null && bDLocation.getLocType() == 66) {
                    com.baidu.location.a.a.un().a(bDLocation);
                }
            } else {
                bDLocation = null;
            }
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                if (this.j || this.aBu == null) {
                    BDLocation aJ = com.baidu.location.e.a.uK().aJ(false);
                    com.baidu.location.a.a.un().a(aJ);
                    boolean z = true;
                    if (com.baidu.location.h.i.f.equals("all") && aJ.getAddrStr() == null) {
                        z = false;
                    }
                    if (com.baidu.location.h.i.g && aJ.getLocationDescribe() == null) {
                        z = false;
                    }
                    if (com.baidu.location.h.i.h && aJ.getPoiList() == null) {
                        z = false;
                    }
                    if (!z) {
                        aJ.setLocType(67);
                    }
                    bDLocation = aJ;
                } else {
                    com.baidu.location.a.a.un().a(this.aBu);
                }
            }
            com.baidu.location.c.f.uH().uI().d(SystemClock.uptimeMillis());
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                this.aBu = null;
                com.baidu.location.c.f.uH().uI().a("off");
                if (this.aBx != null) {
                    com.baidu.location.c.f.uH().uI().b(this.aBx.h());
                }
                com.baidu.location.c.f.uH().c();
            } else {
                this.aBu = bDLocation;
                com.baidu.location.c.f.uH().uI().a("ofs");
                if (this.aBx != null) {
                    com.baidu.location.c.f.uH().uI().b(this.aBx.h());
                }
                com.baidu.location.c.f.uH().c();
            }
            this.aBv = null;
            k();
        }
    }

    @Override // com.baidu.location.a.d
    public void a(Message message) {
        boolean z;
        if (this.aBD != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.aBD);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            this.aBA = bDLocation.getAddress();
            this.z = bDLocation.getLongitude();
            this.aBC = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.x = bDLocation.getLocationDescribe();
            this.z = bDLocation.getLongitude();
            this.aBC = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.aBB = bDLocation.getPoiList();
            this.z = bDLocation.getLongitude();
            this.aBC = bDLocation.getLatitude();
        }
        if (com.baidu.location.f.f.vg().i()) {
            BDLocation bDLocation3 = new BDLocation(com.baidu.location.f.f.vg().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.aBC, this.z, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.aBA != null) {
                        bDLocation3.setAddr(this.aBA);
                    }
                    if (this.x != null) {
                        bDLocation3.setLocationDescribe(this.x);
                    }
                    if (this.aBB != null) {
                        bDLocation3.setPoiList(this.aBB);
                    }
                }
            }
            com.baidu.location.a.a.un().a(bDLocation3);
            k();
        } else if (bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("sky")) {
            bDLocation.setNetworkLocationType("wf");
            com.baidu.location.a.a.un().a(bDLocation);
            this.v = System.currentTimeMillis();
            this.aBu = bDLocation;
        } else if (this.G) {
            float[] fArr2 = new float[2];
            if (this.aBu != null) {
                Location.distanceBetween(this.aBu.getLatitude(), this.aBu.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
            }
            if (fArr2[0] > 10.0f) {
                this.aBu = bDLocation;
                if (!this.H) {
                    this.H = false;
                    com.baidu.location.a.a.un().a(bDLocation);
                }
            }
            k();
        } else {
            com.baidu.location.c.f.uH().uI().c(SystemClock.uptimeMillis());
            this.aBv = null;
            if (bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && this.aBu != null && this.aBu.getLocType() == 161 && "wf".equals(this.aBu.getNetworkLocationType()) && System.currentTimeMillis() - this.v < StatisticConfig.MIN_UPLOAD_INTERVAL) {
                z = true;
                this.aBv = bDLocation;
            } else {
                z = false;
            }
            if (z) {
                com.baidu.location.a.a.un().a(this.aBu);
            } else {
                com.baidu.location.a.a.un().a(bDLocation);
                this.v = System.currentTimeMillis();
                com.baidu.location.c.f.uH().uI().d(SystemClock.uptimeMillis());
                if (bDLocation.getLocType() == 161) {
                    com.baidu.location.c.f.uH().uI().a("ons");
                    if (this.aBx != null) {
                        com.baidu.location.c.f.uH().uI().b(this.aBx.h());
                    }
                } else {
                    com.baidu.location.c.f.uH().uI().a("onf");
                    if (this.aBx != null) {
                        com.baidu.location.c.f.uH().uI().b(this.aBx.h());
                    }
                    com.baidu.location.c.f.uH().c();
                }
            }
            if (!com.baidu.location.h.i.d(bDLocation)) {
                this.aBu = null;
            } else if (!z) {
                this.aBu = bDLocation;
            }
            int j = com.baidu.location.h.i.j(c, "ssid\":\"", "\"");
            if (j == Integer.MIN_VALUE || this.aBw == null) {
                this.k = null;
            } else {
                this.k = this.aBw.c(j);
            }
            if (com.baidu.location.e.d.uL().d() && bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && b(this.aBx)) {
                com.baidu.location.e.d.uL().a(this.aBx, null, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.aBz = this.aBx;
            }
            if (com.baidu.location.e.d.uL().d() && bDLocation.getLocType() == 161 && "wf".equals(bDLocation.getNetworkLocationType())) {
                com.baidu.location.e.d.uL().a(null, this.aBw, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.aBy = this.aBw;
            }
            if (this.aBx != null) {
                com.baidu.location.e.a.uK().a(c, this.aBx, this.aBw, bDLocation2);
            }
            if (com.baidu.location.f.k.vm().g()) {
                com.baidu.location.e.d.uL().i();
                com.baidu.location.e.d.uL().m();
            }
            k();
        }
    }

    public void a(boolean z) {
        BDLocation bDLocation = null;
        if (com.baidu.location.e.d.uL().d() && com.baidu.location.e.d.uL().g()) {
            bDLocation = com.baidu.location.e.d.uL().a(com.baidu.location.f.c.vd().uZ(), com.baidu.location.f.k.vm().vj(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
            if ((bDLocation == null || bDLocation.getLocType() == 67) && z) {
                bDLocation = com.baidu.location.e.a.uK().aJ(false);
            }
        } else if (z) {
            bDLocation = com.baidu.location.e.a.uK().aJ(false);
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
            com.baidu.location.a.a.un().a(bDLocation);
        }
    }

    public Address b(BDLocation bDLocation) {
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.aBC, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] >= 100.0f) {
                this.x = null;
                this.aBB = null;
                this.B = true;
                i(null);
            } else if (this.aBA != null) {
                return this.aBA;
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
        return this.aBB;
    }

    public boolean g() {
        return this.j;
    }

    public void h() {
        if (!this.t) {
            com.baidu.location.c.a.uC().d();
            return;
        }
        j(null);
        this.t = false;
    }

    public void i() {
        this.aBu = null;
    }
}
