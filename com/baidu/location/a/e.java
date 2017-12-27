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
    private static e azV = null;
    public static boolean h = false;
    private double aAf;
    public d.b azW;
    private double z;
    final int e = 1000;
    private boolean j = true;
    private String k = null;
    private BDLocation azX = null;
    private BDLocation azY = null;
    private com.baidu.location.f.i azZ = null;
    private com.baidu.location.f.a aAa = null;
    private com.baidu.location.f.i aAb = null;
    private com.baidu.location.f.a aAc = null;
    private boolean r = true;
    private volatile boolean s = false;
    private boolean t = false;
    private long u = 0;
    private long v = 0;
    private Address aAd = null;
    private String x = null;
    private List<Poi> aAe = null;
    private boolean B = false;
    private long C = 0;
    private long D = 0;
    private a aAg = null;
    private boolean F = false;
    private boolean G = false;
    private boolean H = true;
    public final Handler g = new d.a();
    private boolean I = false;
    private b aAh = null;
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
        this.azW = null;
        this.azW = new d.b();
    }

    private boolean a(com.baidu.location.f.a aVar) {
        this.azS = com.baidu.location.f.c.uq().um();
        if (this.azS == aVar) {
            return false;
        }
        return this.azS == null || aVar == null || !aVar.a(this.azS);
    }

    private boolean a(com.baidu.location.f.i iVar) {
        this.azR = com.baidu.location.f.k.uz().ux();
        if (iVar == this.azR) {
            return false;
        }
        return this.azR == null || iVar == null || !iVar.c(this.azR);
    }

    private boolean b(com.baidu.location.f.a aVar) {
        if (aVar == null) {
            return false;
        }
        return this.aAc == null || !aVar.a(this.aAc);
    }

    private void c(Message message) {
        boolean z = message.getData().getBoolean("isWaitingLocTag", false);
        if (z) {
            h = true;
        }
        if (z) {
        }
        int e = com.baidu.location.a.a.ty().e(message);
        f.tB().d();
        switch (e) {
            case 1:
                g(message);
                return;
            case 2:
                i(message);
                return;
            case 3:
                if (com.baidu.location.f.f.ut().i()) {
                    h(message);
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(e)));
        }
    }

    private void g(Message message) {
        if (com.baidu.location.f.f.ut().i()) {
            h(message);
            f.tB().c();
            return;
        }
        i(message);
        f.tB().b();
    }

    private void h(Message message) {
        BDLocation bDLocation = new BDLocation(com.baidu.location.f.f.ut().f());
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.aAf, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.aAd != null) {
                    bDLocation.setAddr(this.aAd);
                }
                if (this.x != null) {
                    bDLocation.setLocationDescribe(this.x);
                }
                if (this.aAe != null) {
                    bDLocation.setPoiList(this.aAe);
                }
            } else {
                this.B = true;
                i(null);
            }
        }
        this.azX = bDLocation;
        this.azY = null;
        com.baidu.location.a.a.ty().a(bDLocation);
    }

    private void i(Message message) {
        if (this.r) {
            this.D = SystemClock.uptimeMillis();
            j(message);
        } else if (this.s) {
        } else {
            this.D = SystemClock.uptimeMillis();
            if (!com.baidu.location.f.k.uz().e()) {
                j(message);
                return;
            }
            this.t = true;
            if (this.aAh == null) {
                this.aAh = new b();
            }
            if (this.K && this.aAh != null) {
                this.g.removeCallbacks(this.aAh);
            }
            this.g.postDelayed(this.aAh, 3500L);
            this.K = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Message message) {
        if (this.s) {
            return;
        }
        if (System.currentTimeMillis() - this.u < 1000 && this.azX != null) {
            com.baidu.location.a.a.ty().a(this.azX);
            k();
            return;
        }
        if (this.D > 0) {
            com.baidu.location.c.f.tU().tV().a(this.D);
        } else {
            com.baidu.location.c.f.tU().tV().a(SystemClock.uptimeMillis());
        }
        this.s = true;
        this.j = a(this.aAa);
        if (!a(this.azZ) && !this.j && this.azX != null && !this.B) {
            if (this.azY != null && System.currentTimeMillis() - this.v > 30000) {
                this.azX = this.azY;
                this.azY = null;
            }
            if (f.tB().f()) {
                this.azX.setDirection(f.tB().tD());
            }
            com.baidu.location.a.a.ty().a(this.azX);
            k();
            return;
        }
        this.u = System.currentTimeMillis();
        String a2 = a((String) null);
        if (a2 == null) {
            if (this.azX != null) {
                com.baidu.location.a.a.ty().a(this.azX);
                k();
                return;
            }
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLocType(62);
            com.baidu.location.a.a.ty().a(bDLocation);
            k();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.C > 60000) {
                this.C = currentTimeMillis;
                com.baidu.location.c.f.tU().a("TypeCriteriaException");
                return;
            }
            return;
        }
        if (this.k != null) {
            a2 = a2 + this.k;
            this.k = null;
        }
        com.baidu.location.c.f.tU().tV().b(SystemClock.uptimeMillis());
        this.azW.a(a2);
        this.aAa = this.azS;
        this.azZ = this.azR;
        if (j()) {
            this.aAa = this.azS;
            this.azZ = this.azR;
        }
        if (com.baidu.location.e.d.tY().h()) {
            if (this.aAg == null) {
                this.aAg = new a();
            }
            this.g.postDelayed(this.aAg, com.baidu.location.e.d.tY().a(com.baidu.location.f.c.a(com.baidu.location.f.c.uq().e())));
            this.F = true;
        }
        if (this.r) {
            this.r = false;
            if (com.baidu.location.f.k.uz().g() && message != null && com.baidu.location.a.a.ty().f(message) < 1000 && com.baidu.location.e.d.tY().d()) {
                com.baidu.location.e.d.tY().i();
            }
            com.baidu.location.c.a.tP().b();
        }
    }

    private boolean j() {
        BDLocation bDLocation = null;
        double random = Math.random();
        long uptimeMillis = SystemClock.uptimeMillis();
        com.baidu.location.f.a um = com.baidu.location.f.c.uq().um();
        com.baidu.location.f.i uw = com.baidu.location.f.k.uz().uw();
        boolean z = um != null && um.e() && (uw == null || uw.a() == 0);
        if (com.baidu.location.e.d.tY().d() && com.baidu.location.e.d.tY().f() && (z || (0.0d < random && random < com.baidu.location.e.d.tY().o()))) {
            bDLocation = com.baidu.location.e.d.tY().a(com.baidu.location.f.c.uq().um(), com.baidu.location.f.k.uz().uw(), null, d.b.IS_MIX_MODE, d.a.NEED_TO_LOG);
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
                if (this.aAa != null) {
                    gVar.b(this.aAa.h());
                    gVar.b("&offtag=1");
                }
                com.baidu.location.c.f.tU().a(gVar);
                this.G = true;
                com.baidu.location.a.a.ty().a(bDLocation2);
                this.azX = bDLocation2;
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
        if (this.azX != null) {
            j.tL().c();
        }
    }

    public static synchronized e tA() {
        e eVar;
        synchronized (e.class) {
            if (azV == null) {
                azV = new e();
            }
            eVar = azV;
        }
        return eVar;
    }

    @Override // com.baidu.location.a.d
    public void a() {
        BDLocation bDLocation;
        if (this.aAg != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.aAg);
        }
        if (com.baidu.location.f.f.ut().i()) {
            BDLocation bDLocation2 = new BDLocation(com.baidu.location.f.f.ut().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.aAf, this.z, bDLocation2.getLatitude(), bDLocation2.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.aAd != null) {
                        bDLocation2.setAddr(this.aAd);
                    }
                    if (this.x != null) {
                        bDLocation2.setLocationDescribe(this.x);
                    }
                    if (this.aAe != null) {
                        bDLocation2.setPoiList(this.aAe);
                    }
                }
            }
            com.baidu.location.a.a.ty().a(bDLocation2);
            k();
        } else if (this.G) {
            k();
        } else {
            com.baidu.location.c.f.tU().tV().c(SystemClock.uptimeMillis());
            if (com.baidu.location.e.d.tY().d() && com.baidu.location.e.d.tY().e()) {
                bDLocation = com.baidu.location.e.d.tY().a(com.baidu.location.f.c.uq().um(), com.baidu.location.f.k.uz().uw(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
                if (bDLocation != null && bDLocation.getLocType() == 66) {
                    com.baidu.location.a.a.ty().a(bDLocation);
                }
            } else {
                bDLocation = null;
            }
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                if (this.j || this.azX == null) {
                    BDLocation aF = com.baidu.location.e.a.tX().aF(false);
                    com.baidu.location.a.a.ty().a(aF);
                    boolean z = true;
                    if (com.baidu.location.h.i.f.equals("all") && aF.getAddrStr() == null) {
                        z = false;
                    }
                    if (com.baidu.location.h.i.g && aF.getLocationDescribe() == null) {
                        z = false;
                    }
                    if (com.baidu.location.h.i.h && aF.getPoiList() == null) {
                        z = false;
                    }
                    if (!z) {
                        aF.setLocType(67);
                    }
                    bDLocation = aF;
                } else {
                    com.baidu.location.a.a.ty().a(this.azX);
                }
            }
            com.baidu.location.c.f.tU().tV().d(SystemClock.uptimeMillis());
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                this.azX = null;
                com.baidu.location.c.f.tU().tV().a("off");
                if (this.aAa != null) {
                    com.baidu.location.c.f.tU().tV().b(this.aAa.h());
                }
                com.baidu.location.c.f.tU().c();
            } else {
                this.azX = bDLocation;
                com.baidu.location.c.f.tU().tV().a("ofs");
                if (this.aAa != null) {
                    com.baidu.location.c.f.tU().tV().b(this.aAa.h());
                }
                com.baidu.location.c.f.tU().c();
            }
            this.azY = null;
            k();
        }
    }

    @Override // com.baidu.location.a.d
    public void a(Message message) {
        boolean z;
        if (this.aAg != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.aAg);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            this.aAd = bDLocation.getAddress();
            this.z = bDLocation.getLongitude();
            this.aAf = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.x = bDLocation.getLocationDescribe();
            this.z = bDLocation.getLongitude();
            this.aAf = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.aAe = bDLocation.getPoiList();
            this.z = bDLocation.getLongitude();
            this.aAf = bDLocation.getLatitude();
        }
        if (com.baidu.location.f.f.ut().i()) {
            BDLocation bDLocation3 = new BDLocation(com.baidu.location.f.f.ut().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.aAf, this.z, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.aAd != null) {
                        bDLocation3.setAddr(this.aAd);
                    }
                    if (this.x != null) {
                        bDLocation3.setLocationDescribe(this.x);
                    }
                    if (this.aAe != null) {
                        bDLocation3.setPoiList(this.aAe);
                    }
                }
            }
            com.baidu.location.a.a.ty().a(bDLocation3);
            k();
        } else if (bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("sky")) {
            bDLocation.setNetworkLocationType("wf");
            com.baidu.location.a.a.ty().a(bDLocation);
            this.v = System.currentTimeMillis();
            this.azX = bDLocation;
        } else if (this.G) {
            float[] fArr2 = new float[2];
            if (this.azX != null) {
                Location.distanceBetween(this.azX.getLatitude(), this.azX.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
            }
            if (fArr2[0] > 10.0f) {
                this.azX = bDLocation;
                if (!this.H) {
                    this.H = false;
                    com.baidu.location.a.a.ty().a(bDLocation);
                }
            }
            k();
        } else {
            com.baidu.location.c.f.tU().tV().c(SystemClock.uptimeMillis());
            this.azY = null;
            if (bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && this.azX != null && this.azX.getLocType() == 161 && "wf".equals(this.azX.getNetworkLocationType()) && System.currentTimeMillis() - this.v < 30000) {
                z = true;
                this.azY = bDLocation;
            } else {
                z = false;
            }
            if (z) {
                com.baidu.location.a.a.ty().a(this.azX);
            } else {
                com.baidu.location.a.a.ty().a(bDLocation);
                this.v = System.currentTimeMillis();
                com.baidu.location.c.f.tU().tV().d(SystemClock.uptimeMillis());
                if (bDLocation.getLocType() == 161) {
                    com.baidu.location.c.f.tU().tV().a("ons");
                    if (this.aAa != null) {
                        com.baidu.location.c.f.tU().tV().b(this.aAa.h());
                    }
                } else {
                    com.baidu.location.c.f.tU().tV().a("onf");
                    if (this.aAa != null) {
                        com.baidu.location.c.f.tU().tV().b(this.aAa.h());
                    }
                    com.baidu.location.c.f.tU().c();
                }
            }
            if (!com.baidu.location.h.i.d(bDLocation)) {
                this.azX = null;
            } else if (!z) {
                this.azX = bDLocation;
            }
            int k = com.baidu.location.h.i.k(c, "ssid\":\"", "\"");
            if (k == Integer.MIN_VALUE || this.azZ == null) {
                this.k = null;
            } else {
                this.k = this.azZ.c(k);
            }
            if (com.baidu.location.e.d.tY().d() && bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && b(this.aAa)) {
                com.baidu.location.e.d.tY().a(this.aAa, null, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.aAc = this.aAa;
            }
            if (com.baidu.location.e.d.tY().d() && bDLocation.getLocType() == 161 && "wf".equals(bDLocation.getNetworkLocationType())) {
                com.baidu.location.e.d.tY().a(null, this.azZ, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.aAb = this.azZ;
            }
            if (this.aAa != null) {
                com.baidu.location.e.a.tX().a(c, this.aAa, this.azZ, bDLocation2);
            }
            if (com.baidu.location.f.k.uz().g()) {
                com.baidu.location.e.d.tY().i();
                com.baidu.location.e.d.tY().m();
            }
            k();
        }
    }

    public void a(boolean z) {
        BDLocation bDLocation = null;
        if (com.baidu.location.e.d.tY().d() && com.baidu.location.e.d.tY().g()) {
            bDLocation = com.baidu.location.e.d.tY().a(com.baidu.location.f.c.uq().um(), com.baidu.location.f.k.uz().uw(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
            if ((bDLocation == null || bDLocation.getLocType() == 67) && z) {
                bDLocation = com.baidu.location.e.a.tX().aF(false);
            }
        } else if (z) {
            bDLocation = com.baidu.location.e.a.tX().aF(false);
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
            com.baidu.location.a.a.ty().a(bDLocation);
        }
    }

    public Address b(BDLocation bDLocation) {
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.aAf, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] >= 100.0f) {
                this.x = null;
                this.aAe = null;
                this.B = true;
                i(null);
            } else if (this.aAd != null) {
                return this.aAd;
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
        return this.aAe;
    }

    public boolean g() {
        return this.j;
    }

    public void h() {
        if (!this.t) {
            com.baidu.location.c.a.tP().d();
            return;
        }
        j(null);
        this.t = false;
    }

    public void i() {
        this.azX = null;
    }
}
