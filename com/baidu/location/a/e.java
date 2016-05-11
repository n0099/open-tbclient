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
    private static e FN = null;
    public static boolean h = false;
    public d.b FO;
    private double FZ;
    private double z;
    final int e = 1000;
    private boolean j = true;
    private String k = null;
    private BDLocation FP = null;
    private BDLocation FQ = null;
    private com.baidu.location.f.i FR = null;
    private com.baidu.location.f.a FS = null;
    private com.baidu.location.f.i FT = null;
    private com.baidu.location.f.a FU = null;
    private boolean r = true;
    private volatile boolean s = false;
    private boolean t = false;
    private long FV = 0;
    private long FW = 0;
    private Address FX = null;
    private String x = null;
    private List<Poi> FY = null;
    private boolean B = false;
    private long Ga = 0;
    private long Gb = 0;
    private a Gc = null;
    private boolean F = false;
    private boolean G = false;
    private boolean H = true;
    public final Handler g = new d.a();
    private boolean Gd = false;
    private b Ge = null;
    private boolean Gf = false;

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
            if (e.this.Gf) {
                e.this.Gf = false;
            }
            if (e.this.t) {
                e.this.t = false;
                e.this.j(null);
            }
        }
    }

    private e() {
        this.FO = null;
        this.FO = new d.b();
    }

    private boolean a(com.baidu.location.f.a aVar) {
        this.FK = com.baidu.location.f.c.mw().ms();
        if (this.FK == aVar) {
            return false;
        }
        return this.FK == null || aVar == null || !aVar.a(this.FK);
    }

    private boolean a(com.baidu.location.f.i iVar) {
        this.FJ = com.baidu.location.f.k.mF().mD();
        if (iVar == this.FJ) {
            return false;
        }
        return this.FJ == null || iVar == null || !iVar.c(this.FJ);
    }

    private boolean b(com.baidu.location.f.a aVar) {
        if (aVar == null) {
            return false;
        }
        return this.FU == null || !aVar.a(this.FU);
    }

    private void c(Message message) {
        boolean z = message.getData().getBoolean("isWaitingLocTag", false);
        if (z) {
            h = true;
        }
        if (z) {
        }
        int e = com.baidu.location.a.a.lB().e(message);
        f.lE().d();
        switch (e) {
            case 1:
                g(message);
                return;
            case 2:
                i(message);
                return;
            case 3:
                if (com.baidu.location.f.f.mz().i()) {
                    h(message);
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(e)));
        }
    }

    private void g(Message message) {
        if (com.baidu.location.f.f.mz().i()) {
            h(message);
            f.lE().c();
            return;
        }
        i(message);
        f.lE().b();
    }

    private void h(Message message) {
        BDLocation bDLocation = new BDLocation(com.baidu.location.f.f.mz().f());
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.FZ, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.FX != null) {
                    bDLocation.setAddr(this.FX);
                }
                if (this.x != null) {
                    bDLocation.setLocationDescribe(this.x);
                }
                if (this.FY != null) {
                    bDLocation.setPoiList(this.FY);
                }
            } else {
                this.B = true;
                i(null);
            }
        }
        this.FP = bDLocation;
        this.FQ = null;
        com.baidu.location.a.a.lB().a(bDLocation);
    }

    private void i(Message message) {
        if (this.r) {
            this.Gb = SystemClock.uptimeMillis();
            j(message);
        } else if (this.s) {
        } else {
            this.Gb = SystemClock.uptimeMillis();
            if (!com.baidu.location.f.k.mF().e()) {
                j(message);
                return;
            }
            this.t = true;
            if (this.Ge == null) {
                this.Ge = new b();
            }
            if (this.Gf && this.Ge != null) {
                this.g.removeCallbacks(this.Ge);
            }
            this.g.postDelayed(this.Ge, 3500L);
            this.Gf = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Message message) {
        if (this.s) {
            return;
        }
        if (System.currentTimeMillis() - this.FV < 1000 && this.FP != null) {
            com.baidu.location.a.a.lB().a(this.FP);
            k();
            return;
        }
        if (this.Gb > 0) {
            com.baidu.location.c.f.lX().lY().a(this.Gb);
        } else {
            com.baidu.location.c.f.lX().lY().a(SystemClock.uptimeMillis());
        }
        this.s = true;
        this.j = a(this.FS);
        if (!a(this.FR) && !this.j && this.FP != null && !this.B) {
            if (this.FQ != null && System.currentTimeMillis() - this.FW > 30000) {
                this.FP = this.FQ;
                this.FQ = null;
            }
            if (f.lE().f()) {
                this.FP.setDirection(f.lE().lG());
            }
            com.baidu.location.a.a.lB().a(this.FP);
            k();
            return;
        }
        this.FV = System.currentTimeMillis();
        String a2 = a((String) null);
        if (a2 == null) {
            if (this.FP != null) {
                com.baidu.location.a.a.lB().a(this.FP);
                k();
                return;
            }
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLocType(62);
            com.baidu.location.a.a.lB().a(bDLocation);
            k();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.Ga > TbConfig.USE_TIME_INTERVAL) {
                this.Ga = currentTimeMillis;
                com.baidu.location.c.f.lX().a("TypeCriteriaException");
                return;
            }
            return;
        }
        if (this.k != null) {
            a2 = a2 + this.k;
            this.k = null;
        }
        com.baidu.location.c.f.lX().lY().b(SystemClock.uptimeMillis());
        this.FO.a(a2);
        this.FS = this.FK;
        this.FR = this.FJ;
        if (j()) {
            this.FS = this.FK;
            this.FR = this.FJ;
        }
        if (com.baidu.location.e.d.mb().h()) {
            if (this.Gc == null) {
                this.Gc = new a();
            }
            this.g.postDelayed(this.Gc, com.baidu.location.e.d.mb().bO(com.baidu.location.f.c.a(com.baidu.location.f.c.mw().e())));
            this.F = true;
        }
        if (this.r) {
            this.r = false;
            if (com.baidu.location.f.k.mF().g() && message != null && com.baidu.location.a.a.lB().f(message) < 1000 && com.baidu.location.e.d.mb().d()) {
                com.baidu.location.e.d.mb().i();
            }
            com.baidu.location.c.a.lS().b();
        }
    }

    private boolean j() {
        BDLocation bDLocation = null;
        double random = Math.random();
        long uptimeMillis = SystemClock.uptimeMillis();
        com.baidu.location.f.a ms = com.baidu.location.f.c.mw().ms();
        com.baidu.location.f.i mC = com.baidu.location.f.k.mF().mC();
        boolean z = ms != null && ms.e() && (mC == null || mC.a() == 0);
        if (com.baidu.location.e.d.mb().d() && com.baidu.location.e.d.mb().f() && (z || (0.0d < random && random < com.baidu.location.e.d.mb().mh()))) {
            bDLocation = com.baidu.location.e.d.mb().a(com.baidu.location.f.c.mw().ms(), com.baidu.location.f.k.mF().mC(), null, d.b.IS_MIX_MODE, d.a.NEED_TO_LOG);
        }
        if (bDLocation != null && bDLocation.getLocType() == 66 && this.s) {
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            bDLocation2.setLocType(BDLocation.TypeNetWorkLocation);
            if (this.s) {
                com.baidu.location.c.g gVar = new com.baidu.location.c.g();
                gVar.a(this.Gb);
                gVar.b(uptimeMillis);
                gVar.c(uptimeMillis);
                gVar.l(SystemClock.uptimeMillis());
                gVar.a("ofs");
                if (this.FS != null) {
                    gVar.b(this.FS.h());
                    gVar.b("&offtag=1");
                }
                com.baidu.location.c.f.lX().a(gVar);
                this.G = true;
                com.baidu.location.a.a.lB().a(bDLocation2);
                this.FP = bDLocation2;
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
        if (this.FP != null) {
            j.lO().c();
        }
    }

    public static synchronized e lD() {
        e eVar;
        synchronized (e.class) {
            if (FN == null) {
                FN = new e();
            }
            eVar = FN;
        }
        return eVar;
    }

    @Override // com.baidu.location.a.d
    public void a() {
        BDLocation bDLocation;
        if (this.Gc != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.Gc);
        }
        if (com.baidu.location.f.f.mz().i()) {
            BDLocation bDLocation2 = new BDLocation(com.baidu.location.f.f.mz().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.FZ, this.z, bDLocation2.getLatitude(), bDLocation2.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.FX != null) {
                        bDLocation2.setAddr(this.FX);
                    }
                    if (this.x != null) {
                        bDLocation2.setLocationDescribe(this.x);
                    }
                    if (this.FY != null) {
                        bDLocation2.setPoiList(this.FY);
                    }
                }
            }
            com.baidu.location.a.a.lB().a(bDLocation2);
            k();
        } else if (this.G) {
            k();
        } else {
            com.baidu.location.c.f.lX().lY().c(SystemClock.uptimeMillis());
            if (com.baidu.location.e.d.mb().d() && com.baidu.location.e.d.mb().e()) {
                bDLocation = com.baidu.location.e.d.mb().a(com.baidu.location.f.c.mw().ms(), com.baidu.location.f.k.mF().mC(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
                if (bDLocation != null && bDLocation.getLocType() == 66) {
                    com.baidu.location.a.a.lB().a(bDLocation);
                }
            } else {
                bDLocation = null;
            }
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                if (this.j || this.FP == null) {
                    BDLocation X = com.baidu.location.e.a.ma().X(false);
                    com.baidu.location.a.a.lB().a(X);
                    boolean z = true;
                    if (com.baidu.location.h.i.f.equals("all") && X.getAddrStr() == null) {
                        z = false;
                    }
                    if (com.baidu.location.h.i.g && X.getLocationDescribe() == null) {
                        z = false;
                    }
                    if (com.baidu.location.h.i.h && X.getPoiList() == null) {
                        z = false;
                    }
                    if (!z) {
                        X.setLocType(67);
                    }
                    bDLocation = X;
                } else {
                    com.baidu.location.a.a.lB().a(this.FP);
                }
            }
            com.baidu.location.c.f.lX().lY().l(SystemClock.uptimeMillis());
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                this.FP = null;
                com.baidu.location.c.f.lX().lY().a("off");
                if (this.FS != null) {
                    com.baidu.location.c.f.lX().lY().b(this.FS.h());
                }
                com.baidu.location.c.f.lX().c();
            } else {
                this.FP = bDLocation;
                com.baidu.location.c.f.lX().lY().a("ofs");
                if (this.FS != null) {
                    com.baidu.location.c.f.lX().lY().b(this.FS.h());
                }
                com.baidu.location.c.f.lX().c();
            }
            this.FQ = null;
            k();
        }
    }

    @Override // com.baidu.location.a.d
    public void a(Message message) {
        boolean z;
        if (this.Gc != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.Gc);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            this.FX = bDLocation.getAddress();
            this.z = bDLocation.getLongitude();
            this.FZ = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.x = bDLocation.getLocationDescribe();
            this.z = bDLocation.getLongitude();
            this.FZ = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.FY = bDLocation.getPoiList();
            this.z = bDLocation.getLongitude();
            this.FZ = bDLocation.getLatitude();
        }
        if (com.baidu.location.f.f.mz().i()) {
            BDLocation bDLocation3 = new BDLocation(com.baidu.location.f.f.mz().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.FZ, this.z, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.FX != null) {
                        bDLocation3.setAddr(this.FX);
                    }
                    if (this.x != null) {
                        bDLocation3.setLocationDescribe(this.x);
                    }
                    if (this.FY != null) {
                        bDLocation3.setPoiList(this.FY);
                    }
                }
            }
            com.baidu.location.a.a.lB().a(bDLocation3);
            k();
        } else if (bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("sky")) {
            bDLocation.setNetworkLocationType("wf");
            com.baidu.location.a.a.lB().a(bDLocation);
            this.FW = System.currentTimeMillis();
            this.FP = bDLocation;
        } else if (this.G) {
            float[] fArr2 = new float[2];
            if (this.FP != null) {
                Location.distanceBetween(this.FP.getLatitude(), this.FP.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
            }
            if (fArr2[0] > 10.0f) {
                this.FP = bDLocation;
                if (!this.H) {
                    this.H = false;
                    com.baidu.location.a.a.lB().a(bDLocation);
                }
            }
            k();
        } else {
            com.baidu.location.c.f.lX().lY().c(SystemClock.uptimeMillis());
            this.FQ = null;
            if (bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && this.FP != null && this.FP.getLocType() == 161 && "wf".equals(this.FP.getNetworkLocationType()) && System.currentTimeMillis() - this.FW < 30000) {
                z = true;
                this.FQ = bDLocation;
            } else {
                z = false;
            }
            if (z) {
                com.baidu.location.a.a.lB().a(this.FP);
            } else {
                com.baidu.location.a.a.lB().a(bDLocation);
                this.FW = System.currentTimeMillis();
                com.baidu.location.c.f.lX().lY().l(SystemClock.uptimeMillis());
                if (bDLocation.getLocType() == 161) {
                    com.baidu.location.c.f.lX().lY().a("ons");
                    if (this.FS != null) {
                        com.baidu.location.c.f.lX().lY().b(this.FS.h());
                    }
                } else {
                    com.baidu.location.c.f.lX().lY().a("onf");
                    if (this.FS != null) {
                        com.baidu.location.c.f.lX().lY().b(this.FS.h());
                    }
                    com.baidu.location.c.f.lX().c();
                }
            }
            if (!com.baidu.location.h.i.d(bDLocation)) {
                this.FP = null;
            } else if (!z) {
                this.FP = bDLocation;
            }
            int k = com.baidu.location.h.i.k(c, "ssid\":\"", "\"");
            if (k == Integer.MIN_VALUE || this.FR == null) {
                this.k = null;
            } else {
                this.k = this.FR.c(k);
            }
            if (com.baidu.location.e.d.mb().d() && bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && b(this.FS)) {
                com.baidu.location.e.d.mb().a(this.FS, null, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.FU = this.FS;
            }
            if (com.baidu.location.e.d.mb().d() && bDLocation.getLocType() == 161 && "wf".equals(bDLocation.getNetworkLocationType())) {
                com.baidu.location.e.d.mb().a(null, this.FR, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.FT = this.FR;
            }
            if (this.FS != null) {
                com.baidu.location.e.a.ma().a(c, this.FS, this.FR, bDLocation2);
            }
            if (com.baidu.location.f.k.mF().g()) {
                com.baidu.location.e.d.mb().i();
                com.baidu.location.e.d.mb().m();
            }
            k();
        }
    }

    public void a(boolean z) {
        BDLocation bDLocation = null;
        if (com.baidu.location.e.d.mb().d() && com.baidu.location.e.d.mb().g()) {
            bDLocation = com.baidu.location.e.d.mb().a(com.baidu.location.f.c.mw().ms(), com.baidu.location.f.k.mF().mC(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
            if ((bDLocation == null || bDLocation.getLocType() == 67) && z) {
                bDLocation = com.baidu.location.e.a.ma().X(false);
            }
        } else if (z) {
            bDLocation = com.baidu.location.e.a.ma().X(false);
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
            com.baidu.location.a.a.lB().a(bDLocation);
        }
    }

    public Address b(BDLocation bDLocation) {
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.FZ, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] >= 100.0f) {
                this.x = null;
                this.FY = null;
                this.B = true;
                i(null);
            } else if (this.FX != null) {
                return this.FX;
            }
        }
        return null;
    }

    public void b(Message message) {
        if (this.Gd) {
            c(message);
        }
    }

    public void c() {
        this.r = true;
        this.s = false;
        this.Gd = true;
    }

    public void d() {
        this.s = false;
        this.t = false;
        this.G = false;
        this.H = true;
        i();
        this.Gd = false;
    }

    public String e() {
        return this.x;
    }

    public List<Poi> f() {
        return this.FY;
    }

    public boolean g() {
        return this.j;
    }

    public void h() {
        if (!this.t) {
            com.baidu.location.c.a.lS().d();
            return;
        }
        j(null);
        this.t = false;
    }

    public void i() {
        this.FP = null;
    }
}
