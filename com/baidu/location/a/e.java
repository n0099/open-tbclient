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
    private static e azX = null;
    public static boolean h = false;
    private double aAh;
    public d.b azY;
    private double z;
    final int e = 1000;
    private boolean j = true;
    private String k = null;
    private BDLocation azZ = null;
    private BDLocation aAa = null;
    private com.baidu.location.f.i aAb = null;
    private com.baidu.location.f.a aAc = null;
    private com.baidu.location.f.i aAd = null;
    private com.baidu.location.f.a aAe = null;
    private boolean r = true;
    private volatile boolean s = false;
    private boolean t = false;
    private long u = 0;
    private long v = 0;
    private Address aAf = null;
    private String x = null;
    private List<Poi> aAg = null;
    private boolean B = false;
    private long C = 0;
    private long D = 0;
    private a aAi = null;
    private boolean F = false;
    private boolean G = false;
    private boolean H = true;
    public final Handler g = new d.a();
    private boolean I = false;
    private b aAj = null;
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
        this.azY = null;
        this.azY = new d.b();
    }

    private boolean a(com.baidu.location.f.a aVar) {
        this.azU = com.baidu.location.f.c.ur().un();
        if (this.azU == aVar) {
            return false;
        }
        return this.azU == null || aVar == null || !aVar.a(this.azU);
    }

    private boolean a(com.baidu.location.f.i iVar) {
        this.azT = com.baidu.location.f.k.uA().uy();
        if (iVar == this.azT) {
            return false;
        }
        return this.azT == null || iVar == null || !iVar.c(this.azT);
    }

    private boolean b(com.baidu.location.f.a aVar) {
        if (aVar == null) {
            return false;
        }
        return this.aAe == null || !aVar.a(this.aAe);
    }

    private void c(Message message) {
        boolean z = message.getData().getBoolean("isWaitingLocTag", false);
        if (z) {
            h = true;
        }
        if (z) {
        }
        int e = com.baidu.location.a.a.tz().e(message);
        f.tC().d();
        switch (e) {
            case 1:
                g(message);
                return;
            case 2:
                i(message);
                return;
            case 3:
                if (com.baidu.location.f.f.uu().i()) {
                    h(message);
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(e)));
        }
    }

    private void g(Message message) {
        if (com.baidu.location.f.f.uu().i()) {
            h(message);
            f.tC().c();
            return;
        }
        i(message);
        f.tC().b();
    }

    private void h(Message message) {
        BDLocation bDLocation = new BDLocation(com.baidu.location.f.f.uu().f());
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.aAh, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.aAf != null) {
                    bDLocation.setAddr(this.aAf);
                }
                if (this.x != null) {
                    bDLocation.setLocationDescribe(this.x);
                }
                if (this.aAg != null) {
                    bDLocation.setPoiList(this.aAg);
                }
            } else {
                this.B = true;
                i(null);
            }
        }
        this.azZ = bDLocation;
        this.aAa = null;
        com.baidu.location.a.a.tz().a(bDLocation);
    }

    private void i(Message message) {
        if (this.r) {
            this.D = SystemClock.uptimeMillis();
            j(message);
        } else if (this.s) {
        } else {
            this.D = SystemClock.uptimeMillis();
            if (!com.baidu.location.f.k.uA().e()) {
                j(message);
                return;
            }
            this.t = true;
            if (this.aAj == null) {
                this.aAj = new b();
            }
            if (this.K && this.aAj != null) {
                this.g.removeCallbacks(this.aAj);
            }
            this.g.postDelayed(this.aAj, 3500L);
            this.K = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Message message) {
        if (this.s) {
            return;
        }
        if (System.currentTimeMillis() - this.u < 1000 && this.azZ != null) {
            com.baidu.location.a.a.tz().a(this.azZ);
            k();
            return;
        }
        if (this.D > 0) {
            com.baidu.location.c.f.tV().tW().a(this.D);
        } else {
            com.baidu.location.c.f.tV().tW().a(SystemClock.uptimeMillis());
        }
        this.s = true;
        this.j = a(this.aAc);
        if (!a(this.aAb) && !this.j && this.azZ != null && !this.B) {
            if (this.aAa != null && System.currentTimeMillis() - this.v > 30000) {
                this.azZ = this.aAa;
                this.aAa = null;
            }
            if (f.tC().f()) {
                this.azZ.setDirection(f.tC().tE());
            }
            com.baidu.location.a.a.tz().a(this.azZ);
            k();
            return;
        }
        this.u = System.currentTimeMillis();
        String a2 = a((String) null);
        if (a2 == null) {
            if (this.azZ != null) {
                com.baidu.location.a.a.tz().a(this.azZ);
                k();
                return;
            }
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLocType(62);
            com.baidu.location.a.a.tz().a(bDLocation);
            k();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.C > 60000) {
                this.C = currentTimeMillis;
                com.baidu.location.c.f.tV().a("TypeCriteriaException");
                return;
            }
            return;
        }
        if (this.k != null) {
            a2 = a2 + this.k;
            this.k = null;
        }
        com.baidu.location.c.f.tV().tW().b(SystemClock.uptimeMillis());
        this.azY.a(a2);
        this.aAc = this.azU;
        this.aAb = this.azT;
        if (j()) {
            this.aAc = this.azU;
            this.aAb = this.azT;
        }
        if (com.baidu.location.e.d.tZ().h()) {
            if (this.aAi == null) {
                this.aAi = new a();
            }
            this.g.postDelayed(this.aAi, com.baidu.location.e.d.tZ().a(com.baidu.location.f.c.a(com.baidu.location.f.c.ur().e())));
            this.F = true;
        }
        if (this.r) {
            this.r = false;
            if (com.baidu.location.f.k.uA().g() && message != null && com.baidu.location.a.a.tz().f(message) < 1000 && com.baidu.location.e.d.tZ().d()) {
                com.baidu.location.e.d.tZ().i();
            }
            com.baidu.location.c.a.tQ().b();
        }
    }

    private boolean j() {
        BDLocation bDLocation = null;
        double random = Math.random();
        long uptimeMillis = SystemClock.uptimeMillis();
        com.baidu.location.f.a un = com.baidu.location.f.c.ur().un();
        com.baidu.location.f.i ux = com.baidu.location.f.k.uA().ux();
        boolean z = un != null && un.e() && (ux == null || ux.a() == 0);
        if (com.baidu.location.e.d.tZ().d() && com.baidu.location.e.d.tZ().f() && (z || (0.0d < random && random < com.baidu.location.e.d.tZ().o()))) {
            bDLocation = com.baidu.location.e.d.tZ().a(com.baidu.location.f.c.ur().un(), com.baidu.location.f.k.uA().ux(), null, d.b.IS_MIX_MODE, d.a.NEED_TO_LOG);
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
                if (this.aAc != null) {
                    gVar.b(this.aAc.h());
                    gVar.b("&offtag=1");
                }
                com.baidu.location.c.f.tV().a(gVar);
                this.G = true;
                com.baidu.location.a.a.tz().a(bDLocation2);
                this.azZ = bDLocation2;
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
        if (this.azZ != null) {
            j.tM().c();
        }
    }

    public static synchronized e tB() {
        e eVar;
        synchronized (e.class) {
            if (azX == null) {
                azX = new e();
            }
            eVar = azX;
        }
        return eVar;
    }

    @Override // com.baidu.location.a.d
    public void a() {
        BDLocation bDLocation;
        if (this.aAi != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.aAi);
        }
        if (com.baidu.location.f.f.uu().i()) {
            BDLocation bDLocation2 = new BDLocation(com.baidu.location.f.f.uu().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.aAh, this.z, bDLocation2.getLatitude(), bDLocation2.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.aAf != null) {
                        bDLocation2.setAddr(this.aAf);
                    }
                    if (this.x != null) {
                        bDLocation2.setLocationDescribe(this.x);
                    }
                    if (this.aAg != null) {
                        bDLocation2.setPoiList(this.aAg);
                    }
                }
            }
            com.baidu.location.a.a.tz().a(bDLocation2);
            k();
        } else if (this.G) {
            k();
        } else {
            com.baidu.location.c.f.tV().tW().c(SystemClock.uptimeMillis());
            if (com.baidu.location.e.d.tZ().d() && com.baidu.location.e.d.tZ().e()) {
                bDLocation = com.baidu.location.e.d.tZ().a(com.baidu.location.f.c.ur().un(), com.baidu.location.f.k.uA().ux(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
                if (bDLocation != null && bDLocation.getLocType() == 66) {
                    com.baidu.location.a.a.tz().a(bDLocation);
                }
            } else {
                bDLocation = null;
            }
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                if (this.j || this.azZ == null) {
                    BDLocation aG = com.baidu.location.e.a.tY().aG(false);
                    com.baidu.location.a.a.tz().a(aG);
                    boolean z = true;
                    if (com.baidu.location.h.i.f.equals("all") && aG.getAddrStr() == null) {
                        z = false;
                    }
                    if (com.baidu.location.h.i.g && aG.getLocationDescribe() == null) {
                        z = false;
                    }
                    if (com.baidu.location.h.i.h && aG.getPoiList() == null) {
                        z = false;
                    }
                    if (!z) {
                        aG.setLocType(67);
                    }
                    bDLocation = aG;
                } else {
                    com.baidu.location.a.a.tz().a(this.azZ);
                }
            }
            com.baidu.location.c.f.tV().tW().d(SystemClock.uptimeMillis());
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                this.azZ = null;
                com.baidu.location.c.f.tV().tW().a("off");
                if (this.aAc != null) {
                    com.baidu.location.c.f.tV().tW().b(this.aAc.h());
                }
                com.baidu.location.c.f.tV().c();
            } else {
                this.azZ = bDLocation;
                com.baidu.location.c.f.tV().tW().a("ofs");
                if (this.aAc != null) {
                    com.baidu.location.c.f.tV().tW().b(this.aAc.h());
                }
                com.baidu.location.c.f.tV().c();
            }
            this.aAa = null;
            k();
        }
    }

    @Override // com.baidu.location.a.d
    public void a(Message message) {
        boolean z;
        if (this.aAi != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.aAi);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            this.aAf = bDLocation.getAddress();
            this.z = bDLocation.getLongitude();
            this.aAh = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.x = bDLocation.getLocationDescribe();
            this.z = bDLocation.getLongitude();
            this.aAh = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.aAg = bDLocation.getPoiList();
            this.z = bDLocation.getLongitude();
            this.aAh = bDLocation.getLatitude();
        }
        if (com.baidu.location.f.f.uu().i()) {
            BDLocation bDLocation3 = new BDLocation(com.baidu.location.f.f.uu().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.aAh, this.z, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.aAf != null) {
                        bDLocation3.setAddr(this.aAf);
                    }
                    if (this.x != null) {
                        bDLocation3.setLocationDescribe(this.x);
                    }
                    if (this.aAg != null) {
                        bDLocation3.setPoiList(this.aAg);
                    }
                }
            }
            com.baidu.location.a.a.tz().a(bDLocation3);
            k();
        } else if (bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("sky")) {
            bDLocation.setNetworkLocationType("wf");
            com.baidu.location.a.a.tz().a(bDLocation);
            this.v = System.currentTimeMillis();
            this.azZ = bDLocation;
        } else if (this.G) {
            float[] fArr2 = new float[2];
            if (this.azZ != null) {
                Location.distanceBetween(this.azZ.getLatitude(), this.azZ.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
            }
            if (fArr2[0] > 10.0f) {
                this.azZ = bDLocation;
                if (!this.H) {
                    this.H = false;
                    com.baidu.location.a.a.tz().a(bDLocation);
                }
            }
            k();
        } else {
            com.baidu.location.c.f.tV().tW().c(SystemClock.uptimeMillis());
            this.aAa = null;
            if (bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && this.azZ != null && this.azZ.getLocType() == 161 && "wf".equals(this.azZ.getNetworkLocationType()) && System.currentTimeMillis() - this.v < 30000) {
                z = true;
                this.aAa = bDLocation;
            } else {
                z = false;
            }
            if (z) {
                com.baidu.location.a.a.tz().a(this.azZ);
            } else {
                com.baidu.location.a.a.tz().a(bDLocation);
                this.v = System.currentTimeMillis();
                com.baidu.location.c.f.tV().tW().d(SystemClock.uptimeMillis());
                if (bDLocation.getLocType() == 161) {
                    com.baidu.location.c.f.tV().tW().a("ons");
                    if (this.aAc != null) {
                        com.baidu.location.c.f.tV().tW().b(this.aAc.h());
                    }
                } else {
                    com.baidu.location.c.f.tV().tW().a("onf");
                    if (this.aAc != null) {
                        com.baidu.location.c.f.tV().tW().b(this.aAc.h());
                    }
                    com.baidu.location.c.f.tV().c();
                }
            }
            if (!com.baidu.location.h.i.d(bDLocation)) {
                this.azZ = null;
            } else if (!z) {
                this.azZ = bDLocation;
            }
            int k = com.baidu.location.h.i.k(c, "ssid\":\"", "\"");
            if (k == Integer.MIN_VALUE || this.aAb == null) {
                this.k = null;
            } else {
                this.k = this.aAb.c(k);
            }
            if (com.baidu.location.e.d.tZ().d() && bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && b(this.aAc)) {
                com.baidu.location.e.d.tZ().a(this.aAc, null, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.aAe = this.aAc;
            }
            if (com.baidu.location.e.d.tZ().d() && bDLocation.getLocType() == 161 && "wf".equals(bDLocation.getNetworkLocationType())) {
                com.baidu.location.e.d.tZ().a(null, this.aAb, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.aAd = this.aAb;
            }
            if (this.aAc != null) {
                com.baidu.location.e.a.tY().a(c, this.aAc, this.aAb, bDLocation2);
            }
            if (com.baidu.location.f.k.uA().g()) {
                com.baidu.location.e.d.tZ().i();
                com.baidu.location.e.d.tZ().m();
            }
            k();
        }
    }

    public void a(boolean z) {
        BDLocation bDLocation = null;
        if (com.baidu.location.e.d.tZ().d() && com.baidu.location.e.d.tZ().g()) {
            bDLocation = com.baidu.location.e.d.tZ().a(com.baidu.location.f.c.ur().un(), com.baidu.location.f.k.uA().ux(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
            if ((bDLocation == null || bDLocation.getLocType() == 67) && z) {
                bDLocation = com.baidu.location.e.a.tY().aG(false);
            }
        } else if (z) {
            bDLocation = com.baidu.location.e.a.tY().aG(false);
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
            com.baidu.location.a.a.tz().a(bDLocation);
        }
    }

    public Address b(BDLocation bDLocation) {
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.aAh, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] >= 100.0f) {
                this.x = null;
                this.aAg = null;
                this.B = true;
                i(null);
            } else if (this.aAf != null) {
                return this.aAf;
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
        return this.aAg;
    }

    public boolean g() {
        return this.j;
    }

    public void h() {
        if (!this.t) {
            com.baidu.location.c.a.tQ().d();
            return;
        }
        j(null);
        this.t = false;
    }

    public void i() {
        this.azZ = null;
    }
}
