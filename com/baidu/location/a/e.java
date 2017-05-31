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
    private static e Mf = null;
    public static boolean h = false;
    public d.b Mg;
    private double Mp;
    private double z;
    final int e = 1000;
    private boolean j = true;
    private String k = null;
    private BDLocation Mh = null;
    private BDLocation Mi = null;
    private com.baidu.location.f.i Mj = null;
    private com.baidu.location.f.a Mk = null;
    private com.baidu.location.f.i Ml = null;
    private com.baidu.location.f.a Mm = null;
    private boolean r = true;
    private volatile boolean s = false;
    private boolean t = false;
    private long u = 0;
    private long Mn = 0;
    private Address Mo = null;
    private String x = null;
    private List<Poi> y = null;
    private boolean B = false;
    private long C = 0;
    private long Mq = 0;
    private a Mr = null;
    private boolean F = false;
    private boolean G = false;
    private boolean H = true;
    public final Handler g = new d.a();
    private boolean I = false;
    private b Ms = null;
    private boolean Mt = false;

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
            if (e.this.Mt) {
                e.this.Mt = false;
            }
            if (e.this.t) {
                e.this.t = false;
                e.this.j(null);
            }
        }
    }

    private e() {
        this.Mg = null;
        this.Mg = new d.b();
    }

    private boolean a(com.baidu.location.f.a aVar) {
        this.Mc = com.baidu.location.f.c.nf().nb();
        if (this.Mc == aVar) {
            return false;
        }
        return this.Mc == null || aVar == null || !aVar.a(this.Mc);
    }

    private boolean a(com.baidu.location.f.i iVar) {
        this.Mb = com.baidu.location.f.k.no().nm();
        if (iVar == this.Mb) {
            return false;
        }
        return this.Mb == null || iVar == null || !iVar.c(this.Mb);
    }

    private boolean b(com.baidu.location.f.a aVar) {
        if (aVar == null) {
            return false;
        }
        return this.Mm == null || !aVar.a(this.Mm);
    }

    private void c(Message message) {
        boolean z = message.getData().getBoolean("isWaitingLocTag", false);
        if (z) {
            h = true;
        }
        if (z) {
        }
        int e = com.baidu.location.a.a.mp().e(message);
        f.ms().d();
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
            f.ms().c();
            return;
        }
        i(message);
        f.ms().b();
    }

    private void h(Message message) {
        BDLocation bDLocation = new BDLocation(com.baidu.location.f.f.ni().f());
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.Mp, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.Mo != null) {
                    bDLocation.setAddr(this.Mo);
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
        this.Mh = bDLocation;
        this.Mi = null;
        com.baidu.location.a.a.mp().a(bDLocation);
    }

    private void i(Message message) {
        if (this.r) {
            this.Mq = SystemClock.uptimeMillis();
            j(message);
        } else if (this.s) {
        } else {
            this.Mq = SystemClock.uptimeMillis();
            if (!com.baidu.location.f.k.no().e()) {
                j(message);
                return;
            }
            this.t = true;
            if (this.Ms == null) {
                this.Ms = new b();
            }
            if (this.Mt && this.Ms != null) {
                this.g.removeCallbacks(this.Ms);
            }
            this.g.postDelayed(this.Ms, 3500L);
            this.Mt = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Message message) {
        if (this.s) {
            return;
        }
        if (System.currentTimeMillis() - this.u < 1000 && this.Mh != null) {
            com.baidu.location.a.a.mp().a(this.Mh);
            k();
            return;
        }
        if (this.Mq > 0) {
            com.baidu.location.c.f.mI().mJ().a(this.Mq);
        } else {
            com.baidu.location.c.f.mI().mJ().a(SystemClock.uptimeMillis());
        }
        this.s = true;
        this.j = a(this.Mk);
        if (!a(this.Mj) && !this.j && this.Mh != null && !this.B) {
            if (this.Mi != null && System.currentTimeMillis() - this.Mn > 30000) {
                this.Mh = this.Mi;
                this.Mi = null;
            }
            if (f.ms().f()) {
                this.Mh.setDirection(f.ms().h());
            }
            com.baidu.location.a.a.mp().a(this.Mh);
            k();
            return;
        }
        this.u = System.currentTimeMillis();
        String a2 = a((String) null);
        if (a2 == null) {
            if (this.Mh != null) {
                com.baidu.location.a.a.mp().a(this.Mh);
                k();
                return;
            }
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLocType(62);
            com.baidu.location.a.a.mp().a(bDLocation);
            k();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.C > TbConfig.USE_TIME_INTERVAL) {
                this.C = currentTimeMillis;
                com.baidu.location.c.f.mI().a("TypeCriteriaException");
                return;
            }
            return;
        }
        if (this.k != null) {
            a2 = a2 + this.k;
            this.k = null;
        }
        com.baidu.location.c.f.mI().mJ().b(SystemClock.uptimeMillis());
        this.Mg.a(a2);
        this.Mk = this.Mc;
        this.Mj = this.Mb;
        if (j()) {
            this.Mk = this.Mc;
            this.Mj = this.Mb;
        }
        if (com.baidu.location.e.d.mM().h()) {
            if (this.Mr == null) {
                this.Mr = new a();
            }
            this.g.postDelayed(this.Mr, com.baidu.location.e.d.mM().a(com.baidu.location.f.c.a(com.baidu.location.f.c.nf().e())));
            this.F = true;
        }
        if (this.r) {
            this.r = false;
            if (com.baidu.location.f.k.no().g() && message != null && com.baidu.location.a.a.mp().f(message) < 1000 && com.baidu.location.e.d.mM().d()) {
                com.baidu.location.e.d.mM().i();
            }
            com.baidu.location.c.a.mD().b();
        }
    }

    private boolean j() {
        BDLocation bDLocation = null;
        double random = Math.random();
        long uptimeMillis = SystemClock.uptimeMillis();
        com.baidu.location.f.a nb = com.baidu.location.f.c.nf().nb();
        com.baidu.location.f.i nl = com.baidu.location.f.k.no().nl();
        boolean z = nb != null && nb.e() && (nl == null || nl.a() == 0);
        if (com.baidu.location.e.d.mM().d() && com.baidu.location.e.d.mM().f() && (z || (0.0d < random && random < com.baidu.location.e.d.mM().mR()))) {
            bDLocation = com.baidu.location.e.d.mM().a(com.baidu.location.f.c.nf().nb(), com.baidu.location.f.k.no().nl(), null, d.b.IS_MIX_MODE, d.a.NEED_TO_LOG);
        }
        if (bDLocation != null && bDLocation.getLocType() == 66 && this.s) {
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            bDLocation2.setLocType(BDLocation.TypeNetWorkLocation);
            if (this.s) {
                com.baidu.location.c.g gVar = new com.baidu.location.c.g();
                gVar.a(this.Mq);
                gVar.b(uptimeMillis);
                gVar.c(uptimeMillis);
                gVar.d(SystemClock.uptimeMillis());
                gVar.a("ofs");
                if (this.Mk != null) {
                    gVar.b(this.Mk.h());
                    gVar.b("&offtag=1");
                }
                com.baidu.location.c.f.mI().a(gVar);
                this.G = true;
                com.baidu.location.a.a.mp().a(bDLocation2);
                this.Mh = bDLocation2;
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
        if (this.Mh != null) {
            j.mz().c();
        }
    }

    public static synchronized e mr() {
        e eVar;
        synchronized (e.class) {
            if (Mf == null) {
                Mf = new e();
            }
            eVar = Mf;
        }
        return eVar;
    }

    @Override // com.baidu.location.a.d
    public void a() {
        BDLocation bDLocation;
        if (this.Mr != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.Mr);
        }
        if (com.baidu.location.f.f.ni().i()) {
            BDLocation bDLocation2 = new BDLocation(com.baidu.location.f.f.ni().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.Mp, this.z, bDLocation2.getLatitude(), bDLocation2.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.Mo != null) {
                        bDLocation2.setAddr(this.Mo);
                    }
                    if (this.x != null) {
                        bDLocation2.setLocationDescribe(this.x);
                    }
                    if (this.y != null) {
                        bDLocation2.setPoiList(this.y);
                    }
                }
            }
            com.baidu.location.a.a.mp().a(bDLocation2);
            k();
        } else if (this.G) {
            k();
        } else {
            com.baidu.location.c.f.mI().mJ().c(SystemClock.uptimeMillis());
            if (com.baidu.location.e.d.mM().d() && com.baidu.location.e.d.mM().e()) {
                bDLocation = com.baidu.location.e.d.mM().a(com.baidu.location.f.c.nf().nb(), com.baidu.location.f.k.no().nl(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
                if (bDLocation != null && bDLocation.getLocType() == 66) {
                    com.baidu.location.a.a.mp().a(bDLocation);
                }
            } else {
                bDLocation = null;
            }
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                if (this.j || this.Mh == null) {
                    BDLocation aa = com.baidu.location.e.a.mL().aa(false);
                    com.baidu.location.a.a.mp().a(aa);
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
                    com.baidu.location.a.a.mp().a(this.Mh);
                }
            }
            com.baidu.location.c.f.mI().mJ().d(SystemClock.uptimeMillis());
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                this.Mh = null;
                com.baidu.location.c.f.mI().mJ().a("off");
                if (this.Mk != null) {
                    com.baidu.location.c.f.mI().mJ().b(this.Mk.h());
                }
                com.baidu.location.c.f.mI().c();
            } else {
                this.Mh = bDLocation;
                com.baidu.location.c.f.mI().mJ().a("ofs");
                if (this.Mk != null) {
                    com.baidu.location.c.f.mI().mJ().b(this.Mk.h());
                }
                com.baidu.location.c.f.mI().c();
            }
            this.Mi = null;
            k();
        }
    }

    @Override // com.baidu.location.a.d
    public void a(Message message) {
        boolean z;
        if (this.Mr != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.Mr);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            this.Mo = bDLocation.getAddress();
            this.z = bDLocation.getLongitude();
            this.Mp = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.x = bDLocation.getLocationDescribe();
            this.z = bDLocation.getLongitude();
            this.Mp = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.y = bDLocation.getPoiList();
            this.z = bDLocation.getLongitude();
            this.Mp = bDLocation.getLatitude();
        }
        if (com.baidu.location.f.f.ni().i()) {
            BDLocation bDLocation3 = new BDLocation(com.baidu.location.f.f.ni().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.Mp, this.z, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.Mo != null) {
                        bDLocation3.setAddr(this.Mo);
                    }
                    if (this.x != null) {
                        bDLocation3.setLocationDescribe(this.x);
                    }
                    if (this.y != null) {
                        bDLocation3.setPoiList(this.y);
                    }
                }
            }
            com.baidu.location.a.a.mp().a(bDLocation3);
            k();
        } else if (bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("sky")) {
            bDLocation.setNetworkLocationType("wf");
            com.baidu.location.a.a.mp().a(bDLocation);
            this.Mn = System.currentTimeMillis();
            this.Mh = bDLocation;
        } else if (this.G) {
            float[] fArr2 = new float[2];
            if (this.Mh != null) {
                Location.distanceBetween(this.Mh.getLatitude(), this.Mh.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
            }
            if (fArr2[0] > 10.0f) {
                this.Mh = bDLocation;
                if (!this.H) {
                    this.H = false;
                    com.baidu.location.a.a.mp().a(bDLocation);
                }
            }
            k();
        } else {
            com.baidu.location.c.f.mI().mJ().c(SystemClock.uptimeMillis());
            this.Mi = null;
            if (bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && this.Mh != null && this.Mh.getLocType() == 161 && "wf".equals(this.Mh.getNetworkLocationType()) && System.currentTimeMillis() - this.Mn < 30000) {
                z = true;
                this.Mi = bDLocation;
            } else {
                z = false;
            }
            if (z) {
                com.baidu.location.a.a.mp().a(this.Mh);
            } else {
                com.baidu.location.a.a.mp().a(bDLocation);
                this.Mn = System.currentTimeMillis();
                com.baidu.location.c.f.mI().mJ().d(SystemClock.uptimeMillis());
                if (bDLocation.getLocType() == 161) {
                    com.baidu.location.c.f.mI().mJ().a("ons");
                    if (this.Mk != null) {
                        com.baidu.location.c.f.mI().mJ().b(this.Mk.h());
                    }
                } else {
                    com.baidu.location.c.f.mI().mJ().a("onf");
                    if (this.Mk != null) {
                        com.baidu.location.c.f.mI().mJ().b(this.Mk.h());
                    }
                    com.baidu.location.c.f.mI().c();
                }
            }
            if (!com.baidu.location.h.i.d(bDLocation)) {
                this.Mh = null;
            } else if (!z) {
                this.Mh = bDLocation;
            }
            int h2 = com.baidu.location.h.i.h(c, "ssid\":\"", "\"");
            if (h2 == Integer.MIN_VALUE || this.Mj == null) {
                this.k = null;
            } else {
                this.k = this.Mj.c(h2);
            }
            if (com.baidu.location.e.d.mM().d() && bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && b(this.Mk)) {
                com.baidu.location.e.d.mM().a(this.Mk, null, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.Mm = this.Mk;
            }
            if (com.baidu.location.e.d.mM().d() && bDLocation.getLocType() == 161 && "wf".equals(bDLocation.getNetworkLocationType())) {
                com.baidu.location.e.d.mM().a(null, this.Mj, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.Ml = this.Mj;
            }
            if (this.Mk != null) {
                com.baidu.location.e.a.mL().a(c, this.Mk, this.Mj, bDLocation2);
            }
            if (com.baidu.location.f.k.no().g()) {
                com.baidu.location.e.d.mM().i();
                com.baidu.location.e.d.mM().m();
            }
            k();
        }
    }

    public void a(boolean z) {
        BDLocation bDLocation = null;
        if (com.baidu.location.e.d.mM().d() && com.baidu.location.e.d.mM().g()) {
            bDLocation = com.baidu.location.e.d.mM().a(com.baidu.location.f.c.nf().nb(), com.baidu.location.f.k.no().nl(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
            if ((bDLocation == null || bDLocation.getLocType() == 67) && z) {
                bDLocation = com.baidu.location.e.a.mL().aa(false);
            }
        } else if (z) {
            bDLocation = com.baidu.location.e.a.mL().aa(false);
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
            com.baidu.location.a.a.mp().a(bDLocation);
        }
    }

    public Address b(BDLocation bDLocation) {
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.Mp, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] >= 100.0f) {
                this.x = null;
                this.y = null;
                this.B = true;
                i(null);
            } else if (this.Mo != null) {
                return this.Mo;
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
            com.baidu.location.c.a.mD().d();
            return;
        }
        j(null);
        this.t = false;
    }

    public void i() {
        this.Mh = null;
    }
}
