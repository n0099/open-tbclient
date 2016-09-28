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
    private static e Is = null;
    public static boolean h = false;
    private double IE;
    public d.b It;
    private double z;
    final int e = 1000;
    private boolean j = true;
    private String k = null;
    private BDLocation Iu = null;
    private BDLocation Iv = null;
    private com.baidu.location.f.i Iw = null;
    private com.baidu.location.f.a Ix = null;
    private com.baidu.location.f.i Iy = null;
    private com.baidu.location.f.a Iz = null;
    private boolean r = true;
    private volatile boolean s = false;
    private boolean t = false;
    private long u = 0;
    private long IA = 0;
    private Address IB = null;
    private String x = null;
    private List<Poi> IC = null;
    private boolean B = false;
    private long C = 0;
    private long IF = 0;
    private a IG = null;
    private boolean F = false;
    private boolean G = false;
    private boolean H = true;
    public final Handler g = new d.a();
    private boolean IH = false;
    private b II = null;
    private boolean IJ = false;

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
            if (e.this.IJ) {
                e.this.IJ = false;
            }
            if (e.this.t) {
                e.this.t = false;
                e.this.j(null);
            }
        }
    }

    private e() {
        this.It = null;
        this.It = new d.b();
    }

    private boolean a(com.baidu.location.f.a aVar) {
        this.Ip = com.baidu.location.f.c.nc().mY();
        if (this.Ip == aVar) {
            return false;
        }
        return this.Ip == null || aVar == null || !aVar.a(this.Ip);
    }

    private boolean a(com.baidu.location.f.i iVar) {
        this.Io = com.baidu.location.f.k.nl().nj();
        if (iVar == this.Io) {
            return false;
        }
        return this.Io == null || iVar == null || !iVar.c(this.Io);
    }

    private boolean b(com.baidu.location.f.a aVar) {
        if (aVar == null) {
            return false;
        }
        return this.Iz == null || !aVar.a(this.Iz);
    }

    private void c(Message message) {
        boolean z = message.getData().getBoolean("isWaitingLocTag", false);
        if (z) {
            h = true;
        }
        if (z) {
        }
        int e = com.baidu.location.a.a.mn().e(message);
        f.mq().d();
        switch (e) {
            case 1:
                g(message);
                return;
            case 2:
                i(message);
                return;
            case 3:
                if (com.baidu.location.f.f.nf().i()) {
                    h(message);
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(e)));
        }
    }

    private void g(Message message) {
        if (com.baidu.location.f.f.nf().i()) {
            h(message);
            f.mq().c();
            return;
        }
        i(message);
        f.mq().b();
    }

    private void h(Message message) {
        BDLocation bDLocation = new BDLocation(com.baidu.location.f.f.nf().f());
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.IE, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.IB != null) {
                    bDLocation.setAddr(this.IB);
                }
                if (this.x != null) {
                    bDLocation.setLocationDescribe(this.x);
                }
                if (this.IC != null) {
                    bDLocation.setPoiList(this.IC);
                }
            } else {
                this.B = true;
                i(null);
            }
        }
        this.Iu = bDLocation;
        this.Iv = null;
        com.baidu.location.a.a.mn().a(bDLocation);
    }

    private void i(Message message) {
        if (this.r) {
            this.IF = SystemClock.uptimeMillis();
            j(message);
        } else if (this.s) {
        } else {
            this.IF = SystemClock.uptimeMillis();
            if (!com.baidu.location.f.k.nl().e()) {
                j(message);
                return;
            }
            this.t = true;
            if (this.II == null) {
                this.II = new b();
            }
            if (this.IJ && this.II != null) {
                this.g.removeCallbacks(this.II);
            }
            this.g.postDelayed(this.II, 3500L);
            this.IJ = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Message message) {
        if (this.s) {
            return;
        }
        if (System.currentTimeMillis() - this.u < 1000 && this.Iu != null) {
            com.baidu.location.a.a.mn().a(this.Iu);
            k();
            return;
        }
        if (this.IF > 0) {
            com.baidu.location.c.f.mG().mH().a(this.IF);
        } else {
            com.baidu.location.c.f.mG().mH().a(SystemClock.uptimeMillis());
        }
        this.s = true;
        this.j = a(this.Ix);
        if (!a(this.Iw) && !this.j && this.Iu != null && !this.B) {
            if (this.Iv != null && System.currentTimeMillis() - this.IA > 30000) {
                this.Iu = this.Iv;
                this.Iv = null;
            }
            if (f.mq().f()) {
                this.Iu.setDirection(f.mq().h());
            }
            com.baidu.location.a.a.mn().a(this.Iu);
            k();
            return;
        }
        this.u = System.currentTimeMillis();
        String a2 = a((String) null);
        if (a2 == null) {
            if (this.Iu != null) {
                com.baidu.location.a.a.mn().a(this.Iu);
                k();
                return;
            }
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLocType(62);
            com.baidu.location.a.a.mn().a(bDLocation);
            k();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.C > TbConfig.USE_TIME_INTERVAL) {
                this.C = currentTimeMillis;
                com.baidu.location.c.f.mG().a("TypeCriteriaException");
                return;
            }
            return;
        }
        if (this.k != null) {
            a2 = a2 + this.k;
            this.k = null;
        }
        com.baidu.location.c.f.mG().mH().b(SystemClock.uptimeMillis());
        this.It.a(a2);
        this.Ix = this.Ip;
        this.Iw = this.Io;
        if (j()) {
            this.Ix = this.Ip;
            this.Iw = this.Io;
        }
        if (com.baidu.location.e.d.mK().h()) {
            if (this.IG == null) {
                this.IG = new a();
            }
            this.g.postDelayed(this.IG, com.baidu.location.e.d.mK().a(com.baidu.location.f.c.a(com.baidu.location.f.c.nc().e())));
            this.F = true;
        }
        if (this.r) {
            this.r = false;
            if (com.baidu.location.f.k.nl().g() && message != null && com.baidu.location.a.a.mn().f(message) < 1000 && com.baidu.location.e.d.mK().d()) {
                com.baidu.location.e.d.mK().i();
            }
            com.baidu.location.c.a.mB().b();
        }
    }

    private boolean j() {
        BDLocation bDLocation = null;
        double random = Math.random();
        long uptimeMillis = SystemClock.uptimeMillis();
        com.baidu.location.f.a mY = com.baidu.location.f.c.nc().mY();
        com.baidu.location.f.i ni = com.baidu.location.f.k.nl().ni();
        boolean z = mY != null && mY.e() && (ni == null || ni.a() == 0);
        if (com.baidu.location.e.d.mK().d() && com.baidu.location.e.d.mK().f() && (z || (0.0d < random && random < com.baidu.location.e.d.mK().mP()))) {
            bDLocation = com.baidu.location.e.d.mK().a(com.baidu.location.f.c.nc().mY(), com.baidu.location.f.k.nl().ni(), null, d.b.IS_MIX_MODE, d.a.NEED_TO_LOG);
        }
        if (bDLocation != null && bDLocation.getLocType() == 66 && this.s) {
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            bDLocation2.setLocType(BDLocation.TypeNetWorkLocation);
            if (this.s) {
                com.baidu.location.c.g gVar = new com.baidu.location.c.g();
                gVar.a(this.IF);
                gVar.b(uptimeMillis);
                gVar.c(uptimeMillis);
                gVar.m(SystemClock.uptimeMillis());
                gVar.a("ofs");
                if (this.Ix != null) {
                    gVar.b(this.Ix.h());
                    gVar.b("&offtag=1");
                }
                com.baidu.location.c.f.mG().a(gVar);
                this.G = true;
                com.baidu.location.a.a.mn().a(bDLocation2);
                this.Iu = bDLocation2;
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
        if (this.Iu != null) {
            j.mx().c();
        }
    }

    public static synchronized e mp() {
        e eVar;
        synchronized (e.class) {
            if (Is == null) {
                Is = new e();
            }
            eVar = Is;
        }
        return eVar;
    }

    @Override // com.baidu.location.a.d
    public void a() {
        BDLocation bDLocation;
        if (this.IG != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.IG);
        }
        if (com.baidu.location.f.f.nf().i()) {
            BDLocation bDLocation2 = new BDLocation(com.baidu.location.f.f.nf().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.IE, this.z, bDLocation2.getLatitude(), bDLocation2.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.IB != null) {
                        bDLocation2.setAddr(this.IB);
                    }
                    if (this.x != null) {
                        bDLocation2.setLocationDescribe(this.x);
                    }
                    if (this.IC != null) {
                        bDLocation2.setPoiList(this.IC);
                    }
                }
            }
            com.baidu.location.a.a.mn().a(bDLocation2);
            k();
        } else if (this.G) {
            k();
        } else {
            com.baidu.location.c.f.mG().mH().c(SystemClock.uptimeMillis());
            if (com.baidu.location.e.d.mK().d() && com.baidu.location.e.d.mK().e()) {
                bDLocation = com.baidu.location.e.d.mK().a(com.baidu.location.f.c.nc().mY(), com.baidu.location.f.k.nl().ni(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
                if (bDLocation != null && bDLocation.getLocType() == 66) {
                    com.baidu.location.a.a.mn().a(bDLocation);
                }
            } else {
                bDLocation = null;
            }
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                if (this.j || this.Iu == null) {
                    BDLocation ab = com.baidu.location.e.a.mJ().ab(false);
                    com.baidu.location.a.a.mn().a(ab);
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
                    com.baidu.location.a.a.mn().a(this.Iu);
                }
            }
            com.baidu.location.c.f.mG().mH().m(SystemClock.uptimeMillis());
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                this.Iu = null;
                com.baidu.location.c.f.mG().mH().a("off");
                if (this.Ix != null) {
                    com.baidu.location.c.f.mG().mH().b(this.Ix.h());
                }
                com.baidu.location.c.f.mG().c();
            } else {
                this.Iu = bDLocation;
                com.baidu.location.c.f.mG().mH().a("ofs");
                if (this.Ix != null) {
                    com.baidu.location.c.f.mG().mH().b(this.Ix.h());
                }
                com.baidu.location.c.f.mG().c();
            }
            this.Iv = null;
            k();
        }
    }

    @Override // com.baidu.location.a.d
    public void a(Message message) {
        boolean z;
        if (this.IG != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.IG);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            this.IB = bDLocation.getAddress();
            this.z = bDLocation.getLongitude();
            this.IE = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.x = bDLocation.getLocationDescribe();
            this.z = bDLocation.getLongitude();
            this.IE = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.IC = bDLocation.getPoiList();
            this.z = bDLocation.getLongitude();
            this.IE = bDLocation.getLatitude();
        }
        if (com.baidu.location.f.f.nf().i()) {
            BDLocation bDLocation3 = new BDLocation(com.baidu.location.f.f.nf().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.IE, this.z, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.IB != null) {
                        bDLocation3.setAddr(this.IB);
                    }
                    if (this.x != null) {
                        bDLocation3.setLocationDescribe(this.x);
                    }
                    if (this.IC != null) {
                        bDLocation3.setPoiList(this.IC);
                    }
                }
            }
            com.baidu.location.a.a.mn().a(bDLocation3);
            k();
        } else if (bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("sky")) {
            bDLocation.setNetworkLocationType("wf");
            com.baidu.location.a.a.mn().a(bDLocation);
            this.IA = System.currentTimeMillis();
            this.Iu = bDLocation;
        } else if (this.G) {
            float[] fArr2 = new float[2];
            if (this.Iu != null) {
                Location.distanceBetween(this.Iu.getLatitude(), this.Iu.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
            }
            if (fArr2[0] > 10.0f) {
                this.Iu = bDLocation;
                if (!this.H) {
                    this.H = false;
                    com.baidu.location.a.a.mn().a(bDLocation);
                }
            }
            k();
        } else {
            com.baidu.location.c.f.mG().mH().c(SystemClock.uptimeMillis());
            this.Iv = null;
            if (bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && this.Iu != null && this.Iu.getLocType() == 161 && "wf".equals(this.Iu.getNetworkLocationType()) && System.currentTimeMillis() - this.IA < 30000) {
                z = true;
                this.Iv = bDLocation;
            } else {
                z = false;
            }
            if (z) {
                com.baidu.location.a.a.mn().a(this.Iu);
            } else {
                com.baidu.location.a.a.mn().a(bDLocation);
                this.IA = System.currentTimeMillis();
                com.baidu.location.c.f.mG().mH().m(SystemClock.uptimeMillis());
                if (bDLocation.getLocType() == 161) {
                    com.baidu.location.c.f.mG().mH().a("ons");
                    if (this.Ix != null) {
                        com.baidu.location.c.f.mG().mH().b(this.Ix.h());
                    }
                } else {
                    com.baidu.location.c.f.mG().mH().a("onf");
                    if (this.Ix != null) {
                        com.baidu.location.c.f.mG().mH().b(this.Ix.h());
                    }
                    com.baidu.location.c.f.mG().c();
                }
            }
            if (!com.baidu.location.h.i.d(bDLocation)) {
                this.Iu = null;
            } else if (!z) {
                this.Iu = bDLocation;
            }
            int o = com.baidu.location.h.i.o(c, "ssid\":\"", "\"");
            if (o == Integer.MIN_VALUE || this.Iw == null) {
                this.k = null;
            } else {
                this.k = this.Iw.c(o);
            }
            if (com.baidu.location.e.d.mK().d() && bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && b(this.Ix)) {
                com.baidu.location.e.d.mK().a(this.Ix, null, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.Iz = this.Ix;
            }
            if (com.baidu.location.e.d.mK().d() && bDLocation.getLocType() == 161 && "wf".equals(bDLocation.getNetworkLocationType())) {
                com.baidu.location.e.d.mK().a(null, this.Iw, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.Iy = this.Iw;
            }
            if (this.Ix != null) {
                com.baidu.location.e.a.mJ().a(c, this.Ix, this.Iw, bDLocation2);
            }
            if (com.baidu.location.f.k.nl().g()) {
                com.baidu.location.e.d.mK().i();
                com.baidu.location.e.d.mK().m();
            }
            k();
        }
    }

    public void a(boolean z) {
        BDLocation bDLocation = null;
        if (com.baidu.location.e.d.mK().d() && com.baidu.location.e.d.mK().g()) {
            bDLocation = com.baidu.location.e.d.mK().a(com.baidu.location.f.c.nc().mY(), com.baidu.location.f.k.nl().ni(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
            if ((bDLocation == null || bDLocation.getLocType() == 67) && z) {
                bDLocation = com.baidu.location.e.a.mJ().ab(false);
            }
        } else if (z) {
            bDLocation = com.baidu.location.e.a.mJ().ab(false);
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
            com.baidu.location.a.a.mn().a(bDLocation);
        }
    }

    public Address b(BDLocation bDLocation) {
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.IE, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] >= 100.0f) {
                this.x = null;
                this.IC = null;
                this.B = true;
                i(null);
            } else if (this.IB != null) {
                return this.IB;
            }
        }
        return null;
    }

    public void b(Message message) {
        if (this.IH) {
            c(message);
        }
    }

    public void c() {
        this.r = true;
        this.s = false;
        this.IH = true;
    }

    public void d() {
        this.s = false;
        this.t = false;
        this.G = false;
        this.H = true;
        i();
        this.IH = false;
    }

    public String e() {
        return this.x;
    }

    public List<Poi> f() {
        return this.IC;
    }

    public boolean g() {
        return this.j;
    }

    public void h() {
        if (!this.t) {
            com.baidu.location.c.a.mB().d();
            return;
        }
        j(null);
        this.t = false;
    }

    public void i() {
        this.Iu = null;
    }
}
