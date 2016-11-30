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
    private static e Iu = null;
    public static boolean h = false;
    private double IG;
    public d.b Iv;
    private double z;
    final int e = 1000;
    private boolean j = true;
    private String k = null;
    private BDLocation Iw = null;
    private BDLocation Ix = null;
    private com.baidu.location.f.i Iy = null;
    private com.baidu.location.f.a Iz = null;
    private com.baidu.location.f.i IA = null;
    private com.baidu.location.f.a IB = null;
    private boolean r = true;
    private volatile boolean s = false;
    private boolean t = false;
    private long u = 0;
    private long IC = 0;
    private Address IE = null;
    private String x = null;
    private List<Poi> IF = null;
    private boolean B = false;
    private long C = 0;
    private long IH = 0;
    private a II = null;
    private boolean F = false;
    private boolean G = false;
    private boolean H = true;
    public final Handler g = new d.a();
    private boolean IJ = false;
    private b IK = null;
    private boolean IL = false;

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
            if (e.this.IL) {
                e.this.IL = false;
            }
            if (e.this.t) {
                e.this.t = false;
                e.this.j(null);
            }
        }
    }

    private e() {
        this.Iv = null;
        this.Iv = new d.b();
    }

    private boolean a(com.baidu.location.f.a aVar) {
        this.Ir = com.baidu.location.f.c.nf().nb();
        if (this.Ir == aVar) {
            return false;
        }
        return this.Ir == null || aVar == null || !aVar.a(this.Ir);
    }

    private boolean a(com.baidu.location.f.i iVar) {
        this.Iq = com.baidu.location.f.k.no().nm();
        if (iVar == this.Iq) {
            return false;
        }
        return this.Iq == null || iVar == null || !iVar.c(this.Iq);
    }

    private boolean b(com.baidu.location.f.a aVar) {
        if (aVar == null) {
            return false;
        }
        return this.IB == null || !aVar.a(this.IB);
    }

    private void c(Message message) {
        boolean z = message.getData().getBoolean("isWaitingLocTag", false);
        if (z) {
            h = true;
        }
        if (z) {
        }
        int e = com.baidu.location.a.a.mq().e(message);
        f.mt().d();
        switch (e) {
            case 1:
                g(message);
                return;
            case 2:
                i(message);
                return;
            case 3:
                if (com.baidu.location.f.f.ni().i()) {
                    h(message);
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(e)));
        }
    }

    private void g(Message message) {
        if (com.baidu.location.f.f.ni().i()) {
            h(message);
            f.mt().c();
            return;
        }
        i(message);
        f.mt().b();
    }

    private void h(Message message) {
        BDLocation bDLocation = new BDLocation(com.baidu.location.f.f.ni().f());
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.IG, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.IE != null) {
                    bDLocation.setAddr(this.IE);
                }
                if (this.x != null) {
                    bDLocation.setLocationDescribe(this.x);
                }
                if (this.IF != null) {
                    bDLocation.setPoiList(this.IF);
                }
            } else {
                this.B = true;
                i(null);
            }
        }
        this.Iw = bDLocation;
        this.Ix = null;
        com.baidu.location.a.a.mq().a(bDLocation);
    }

    private void i(Message message) {
        if (this.r) {
            this.IH = SystemClock.uptimeMillis();
            j(message);
        } else if (this.s) {
        } else {
            this.IH = SystemClock.uptimeMillis();
            if (!com.baidu.location.f.k.no().e()) {
                j(message);
                return;
            }
            this.t = true;
            if (this.IK == null) {
                this.IK = new b();
            }
            if (this.IL && this.IK != null) {
                this.g.removeCallbacks(this.IK);
            }
            this.g.postDelayed(this.IK, 3500L);
            this.IL = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Message message) {
        if (this.s) {
            return;
        }
        if (System.currentTimeMillis() - this.u < 1000 && this.Iw != null) {
            com.baidu.location.a.a.mq().a(this.Iw);
            k();
            return;
        }
        if (this.IH > 0) {
            com.baidu.location.c.f.mJ().mK().a(this.IH);
        } else {
            com.baidu.location.c.f.mJ().mK().a(SystemClock.uptimeMillis());
        }
        this.s = true;
        this.j = a(this.Iz);
        if (!a(this.Iy) && !this.j && this.Iw != null && !this.B) {
            if (this.Ix != null && System.currentTimeMillis() - this.IC > 30000) {
                this.Iw = this.Ix;
                this.Ix = null;
            }
            if (f.mt().f()) {
                this.Iw.setDirection(f.mt().h());
            }
            com.baidu.location.a.a.mq().a(this.Iw);
            k();
            return;
        }
        this.u = System.currentTimeMillis();
        String a2 = a((String) null);
        if (a2 == null) {
            if (this.Iw != null) {
                com.baidu.location.a.a.mq().a(this.Iw);
                k();
                return;
            }
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLocType(62);
            com.baidu.location.a.a.mq().a(bDLocation);
            k();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.C > TbConfig.USE_TIME_INTERVAL) {
                this.C = currentTimeMillis;
                com.baidu.location.c.f.mJ().a("TypeCriteriaException");
                return;
            }
            return;
        }
        if (this.k != null) {
            a2 = a2 + this.k;
            this.k = null;
        }
        com.baidu.location.c.f.mJ().mK().b(SystemClock.uptimeMillis());
        this.Iv.a(a2);
        this.Iz = this.Ir;
        this.Iy = this.Iq;
        if (j()) {
            this.Iz = this.Ir;
            this.Iy = this.Iq;
        }
        if (com.baidu.location.e.d.mN().h()) {
            if (this.II == null) {
                this.II = new a();
            }
            this.g.postDelayed(this.II, com.baidu.location.e.d.mN().a(com.baidu.location.f.c.a(com.baidu.location.f.c.nf().e())));
            this.F = true;
        }
        if (this.r) {
            this.r = false;
            if (com.baidu.location.f.k.no().g() && message != null && com.baidu.location.a.a.mq().f(message) < 1000 && com.baidu.location.e.d.mN().d()) {
                com.baidu.location.e.d.mN().i();
            }
            com.baidu.location.c.a.mE().b();
        }
    }

    private boolean j() {
        BDLocation bDLocation = null;
        double random = Math.random();
        long uptimeMillis = SystemClock.uptimeMillis();
        com.baidu.location.f.a nb = com.baidu.location.f.c.nf().nb();
        com.baidu.location.f.i nl = com.baidu.location.f.k.no().nl();
        boolean z = nb != null && nb.e() && (nl == null || nl.a() == 0);
        if (com.baidu.location.e.d.mN().d() && com.baidu.location.e.d.mN().f() && (z || (0.0d < random && random < com.baidu.location.e.d.mN().mS()))) {
            bDLocation = com.baidu.location.e.d.mN().a(com.baidu.location.f.c.nf().nb(), com.baidu.location.f.k.no().nl(), null, d.b.IS_MIX_MODE, d.a.NEED_TO_LOG);
        }
        if (bDLocation != null && bDLocation.getLocType() == 66 && this.s) {
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            bDLocation2.setLocType(BDLocation.TypeNetWorkLocation);
            if (this.s) {
                com.baidu.location.c.g gVar = new com.baidu.location.c.g();
                gVar.a(this.IH);
                gVar.b(uptimeMillis);
                gVar.c(uptimeMillis);
                gVar.m(SystemClock.uptimeMillis());
                gVar.a("ofs");
                if (this.Iz != null) {
                    gVar.b(this.Iz.h());
                    gVar.b("&offtag=1");
                }
                com.baidu.location.c.f.mJ().a(gVar);
                this.G = true;
                com.baidu.location.a.a.mq().a(bDLocation2);
                this.Iw = bDLocation2;
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
        if (this.Iw != null) {
            j.mA().c();
        }
    }

    public static synchronized e ms() {
        e eVar;
        synchronized (e.class) {
            if (Iu == null) {
                Iu = new e();
            }
            eVar = Iu;
        }
        return eVar;
    }

    @Override // com.baidu.location.a.d
    public void a() {
        BDLocation bDLocation;
        if (this.II != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.II);
        }
        if (com.baidu.location.f.f.ni().i()) {
            BDLocation bDLocation2 = new BDLocation(com.baidu.location.f.f.ni().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.IG, this.z, bDLocation2.getLatitude(), bDLocation2.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.IE != null) {
                        bDLocation2.setAddr(this.IE);
                    }
                    if (this.x != null) {
                        bDLocation2.setLocationDescribe(this.x);
                    }
                    if (this.IF != null) {
                        bDLocation2.setPoiList(this.IF);
                    }
                }
            }
            com.baidu.location.a.a.mq().a(bDLocation2);
            k();
        } else if (this.G) {
            k();
        } else {
            com.baidu.location.c.f.mJ().mK().c(SystemClock.uptimeMillis());
            if (com.baidu.location.e.d.mN().d() && com.baidu.location.e.d.mN().e()) {
                bDLocation = com.baidu.location.e.d.mN().a(com.baidu.location.f.c.nf().nb(), com.baidu.location.f.k.no().nl(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
                if (bDLocation != null && bDLocation.getLocType() == 66) {
                    com.baidu.location.a.a.mq().a(bDLocation);
                }
            } else {
                bDLocation = null;
            }
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                if (this.j || this.Iw == null) {
                    BDLocation ab = com.baidu.location.e.a.mM().ab(false);
                    com.baidu.location.a.a.mq().a(ab);
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
                    com.baidu.location.a.a.mq().a(this.Iw);
                }
            }
            com.baidu.location.c.f.mJ().mK().m(SystemClock.uptimeMillis());
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                this.Iw = null;
                com.baidu.location.c.f.mJ().mK().a("off");
                if (this.Iz != null) {
                    com.baidu.location.c.f.mJ().mK().b(this.Iz.h());
                }
                com.baidu.location.c.f.mJ().c();
            } else {
                this.Iw = bDLocation;
                com.baidu.location.c.f.mJ().mK().a("ofs");
                if (this.Iz != null) {
                    com.baidu.location.c.f.mJ().mK().b(this.Iz.h());
                }
                com.baidu.location.c.f.mJ().c();
            }
            this.Ix = null;
            k();
        }
    }

    @Override // com.baidu.location.a.d
    public void a(Message message) {
        boolean z;
        if (this.II != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.II);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            this.IE = bDLocation.getAddress();
            this.z = bDLocation.getLongitude();
            this.IG = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.x = bDLocation.getLocationDescribe();
            this.z = bDLocation.getLongitude();
            this.IG = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.IF = bDLocation.getPoiList();
            this.z = bDLocation.getLongitude();
            this.IG = bDLocation.getLatitude();
        }
        if (com.baidu.location.f.f.ni().i()) {
            BDLocation bDLocation3 = new BDLocation(com.baidu.location.f.f.ni().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.IG, this.z, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.IE != null) {
                        bDLocation3.setAddr(this.IE);
                    }
                    if (this.x != null) {
                        bDLocation3.setLocationDescribe(this.x);
                    }
                    if (this.IF != null) {
                        bDLocation3.setPoiList(this.IF);
                    }
                }
            }
            com.baidu.location.a.a.mq().a(bDLocation3);
            k();
        } else if (bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("sky")) {
            bDLocation.setNetworkLocationType("wf");
            com.baidu.location.a.a.mq().a(bDLocation);
            this.IC = System.currentTimeMillis();
            this.Iw = bDLocation;
        } else if (this.G) {
            float[] fArr2 = new float[2];
            if (this.Iw != null) {
                Location.distanceBetween(this.Iw.getLatitude(), this.Iw.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
            }
            if (fArr2[0] > 10.0f) {
                this.Iw = bDLocation;
                if (!this.H) {
                    this.H = false;
                    com.baidu.location.a.a.mq().a(bDLocation);
                }
            }
            k();
        } else {
            com.baidu.location.c.f.mJ().mK().c(SystemClock.uptimeMillis());
            this.Ix = null;
            if (bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && this.Iw != null && this.Iw.getLocType() == 161 && "wf".equals(this.Iw.getNetworkLocationType()) && System.currentTimeMillis() - this.IC < 30000) {
                z = true;
                this.Ix = bDLocation;
            } else {
                z = false;
            }
            if (z) {
                com.baidu.location.a.a.mq().a(this.Iw);
            } else {
                com.baidu.location.a.a.mq().a(bDLocation);
                this.IC = System.currentTimeMillis();
                com.baidu.location.c.f.mJ().mK().m(SystemClock.uptimeMillis());
                if (bDLocation.getLocType() == 161) {
                    com.baidu.location.c.f.mJ().mK().a("ons");
                    if (this.Iz != null) {
                        com.baidu.location.c.f.mJ().mK().b(this.Iz.h());
                    }
                } else {
                    com.baidu.location.c.f.mJ().mK().a("onf");
                    if (this.Iz != null) {
                        com.baidu.location.c.f.mJ().mK().b(this.Iz.h());
                    }
                    com.baidu.location.c.f.mJ().c();
                }
            }
            if (!com.baidu.location.h.i.d(bDLocation)) {
                this.Iw = null;
            } else if (!z) {
                this.Iw = bDLocation;
            }
            int o = com.baidu.location.h.i.o(c, "ssid\":\"", "\"");
            if (o == Integer.MIN_VALUE || this.Iy == null) {
                this.k = null;
            } else {
                this.k = this.Iy.c(o);
            }
            if (com.baidu.location.e.d.mN().d() && bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && b(this.Iz)) {
                com.baidu.location.e.d.mN().a(this.Iz, null, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.IB = this.Iz;
            }
            if (com.baidu.location.e.d.mN().d() && bDLocation.getLocType() == 161 && "wf".equals(bDLocation.getNetworkLocationType())) {
                com.baidu.location.e.d.mN().a(null, this.Iy, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.IA = this.Iy;
            }
            if (this.Iz != null) {
                com.baidu.location.e.a.mM().a(c, this.Iz, this.Iy, bDLocation2);
            }
            if (com.baidu.location.f.k.no().g()) {
                com.baidu.location.e.d.mN().i();
                com.baidu.location.e.d.mN().m();
            }
            k();
        }
    }

    public void a(boolean z) {
        BDLocation bDLocation = null;
        if (com.baidu.location.e.d.mN().d() && com.baidu.location.e.d.mN().g()) {
            bDLocation = com.baidu.location.e.d.mN().a(com.baidu.location.f.c.nf().nb(), com.baidu.location.f.k.no().nl(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
            if ((bDLocation == null || bDLocation.getLocType() == 67) && z) {
                bDLocation = com.baidu.location.e.a.mM().ab(false);
            }
        } else if (z) {
            bDLocation = com.baidu.location.e.a.mM().ab(false);
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
            com.baidu.location.a.a.mq().a(bDLocation);
        }
    }

    public Address b(BDLocation bDLocation) {
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.IG, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] >= 100.0f) {
                this.x = null;
                this.IF = null;
                this.B = true;
                i(null);
            } else if (this.IE != null) {
                return this.IE;
            }
        }
        return null;
    }

    public void b(Message message) {
        if (this.IJ) {
            c(message);
        }
    }

    public void c() {
        this.r = true;
        this.s = false;
        this.IJ = true;
    }

    public void d() {
        this.s = false;
        this.t = false;
        this.G = false;
        this.H = true;
        i();
        this.IJ = false;
    }

    public String e() {
        return this.x;
    }

    public List<Poi> f() {
        return this.IF;
    }

    public boolean g() {
        return this.j;
    }

    public void h() {
        if (!this.t) {
            com.baidu.location.c.a.mE().d();
            return;
        }
        j(null);
        this.t = false;
    }

    public void i() {
        this.Iw = null;
    }
}
