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
    private static e Mr = null;
    public static boolean h = false;
    private double MB;
    public d.b Ms;
    private double z;
    final int e = 1000;
    private boolean j = true;
    private String k = null;
    private BDLocation Mt = null;
    private BDLocation Mu = null;
    private com.baidu.location.f.i Mv = null;
    private com.baidu.location.f.a Mw = null;
    private com.baidu.location.f.i Mx = null;
    private com.baidu.location.f.a My = null;
    private boolean r = true;
    private volatile boolean s = false;
    private boolean t = false;
    private long u = 0;
    private long Mz = 0;
    private Address MA = null;
    private String x = null;
    private List<Poi> y = null;
    private boolean B = false;
    private long C = 0;
    private long MC = 0;
    private a MD = null;
    private boolean F = false;
    private boolean G = false;
    private boolean H = true;
    public final Handler g = new d.a();
    private boolean I = false;
    private b ME = null;
    private boolean MF = false;

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
            if (e.this.MF) {
                e.this.MF = false;
            }
            if (e.this.t) {
                e.this.t = false;
                e.this.j(null);
            }
        }
    }

    private e() {
        this.Ms = null;
        this.Ms = new d.b();
    }

    private boolean a(com.baidu.location.f.a aVar) {
        this.Mo = com.baidu.location.f.c.nm().ni();
        if (this.Mo == aVar) {
            return false;
        }
        return this.Mo == null || aVar == null || !aVar.a(this.Mo);
    }

    private boolean a(com.baidu.location.f.i iVar) {
        this.Mn = com.baidu.location.f.k.nv().nt();
        if (iVar == this.Mn) {
            return false;
        }
        return this.Mn == null || iVar == null || !iVar.c(this.Mn);
    }

    private boolean b(com.baidu.location.f.a aVar) {
        if (aVar == null) {
            return false;
        }
        return this.My == null || !aVar.a(this.My);
    }

    private void c(Message message) {
        boolean z = message.getData().getBoolean("isWaitingLocTag", false);
        if (z) {
            h = true;
        }
        if (z) {
        }
        int e = com.baidu.location.a.a.mw().e(message);
        f.mz().d();
        switch (e) {
            case 1:
                g(message);
                return;
            case 2:
                i(message);
                return;
            case 3:
                if (com.baidu.location.f.f.np().i()) {
                    h(message);
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(e)));
        }
    }

    private void g(Message message) {
        if (com.baidu.location.f.f.np().i()) {
            h(message);
            f.mz().c();
            return;
        }
        i(message);
        f.mz().b();
    }

    private void h(Message message) {
        BDLocation bDLocation = new BDLocation(com.baidu.location.f.f.np().f());
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.MB, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.MA != null) {
                    bDLocation.setAddr(this.MA);
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
        this.Mt = bDLocation;
        this.Mu = null;
        com.baidu.location.a.a.mw().a(bDLocation);
    }

    private void i(Message message) {
        if (this.r) {
            this.MC = SystemClock.uptimeMillis();
            j(message);
        } else if (this.s) {
        } else {
            this.MC = SystemClock.uptimeMillis();
            if (!com.baidu.location.f.k.nv().e()) {
                j(message);
                return;
            }
            this.t = true;
            if (this.ME == null) {
                this.ME = new b();
            }
            if (this.MF && this.ME != null) {
                this.g.removeCallbacks(this.ME);
            }
            this.g.postDelayed(this.ME, 3500L);
            this.MF = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Message message) {
        if (this.s) {
            return;
        }
        if (System.currentTimeMillis() - this.u < 1000 && this.Mt != null) {
            com.baidu.location.a.a.mw().a(this.Mt);
            k();
            return;
        }
        if (this.MC > 0) {
            com.baidu.location.c.f.mP().mQ().a(this.MC);
        } else {
            com.baidu.location.c.f.mP().mQ().a(SystemClock.uptimeMillis());
        }
        this.s = true;
        this.j = a(this.Mw);
        if (!a(this.Mv) && !this.j && this.Mt != null && !this.B) {
            if (this.Mu != null && System.currentTimeMillis() - this.Mz > 30000) {
                this.Mt = this.Mu;
                this.Mu = null;
            }
            if (f.mz().f()) {
                this.Mt.setDirection(f.mz().h());
            }
            com.baidu.location.a.a.mw().a(this.Mt);
            k();
            return;
        }
        this.u = System.currentTimeMillis();
        String a2 = a((String) null);
        if (a2 == null) {
            if (this.Mt != null) {
                com.baidu.location.a.a.mw().a(this.Mt);
                k();
                return;
            }
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLocType(62);
            com.baidu.location.a.a.mw().a(bDLocation);
            k();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.C > TbConfig.USE_TIME_INTERVAL) {
                this.C = currentTimeMillis;
                com.baidu.location.c.f.mP().a("TypeCriteriaException");
                return;
            }
            return;
        }
        if (this.k != null) {
            a2 = a2 + this.k;
            this.k = null;
        }
        com.baidu.location.c.f.mP().mQ().b(SystemClock.uptimeMillis());
        this.Ms.a(a2);
        this.Mw = this.Mo;
        this.Mv = this.Mn;
        if (j()) {
            this.Mw = this.Mo;
            this.Mv = this.Mn;
        }
        if (com.baidu.location.e.d.mT().h()) {
            if (this.MD == null) {
                this.MD = new a();
            }
            this.g.postDelayed(this.MD, com.baidu.location.e.d.mT().a(com.baidu.location.f.c.a(com.baidu.location.f.c.nm().e())));
            this.F = true;
        }
        if (this.r) {
            this.r = false;
            if (com.baidu.location.f.k.nv().g() && message != null && com.baidu.location.a.a.mw().f(message) < 1000 && com.baidu.location.e.d.mT().d()) {
                com.baidu.location.e.d.mT().i();
            }
            com.baidu.location.c.a.mK().b();
        }
    }

    private boolean j() {
        BDLocation bDLocation = null;
        double random = Math.random();
        long uptimeMillis = SystemClock.uptimeMillis();
        com.baidu.location.f.a ni = com.baidu.location.f.c.nm().ni();
        com.baidu.location.f.i ns = com.baidu.location.f.k.nv().ns();
        boolean z = ni != null && ni.e() && (ns == null || ns.a() == 0);
        if (com.baidu.location.e.d.mT().d() && com.baidu.location.e.d.mT().f() && (z || (0.0d < random && random < com.baidu.location.e.d.mT().mY()))) {
            bDLocation = com.baidu.location.e.d.mT().a(com.baidu.location.f.c.nm().ni(), com.baidu.location.f.k.nv().ns(), null, d.b.IS_MIX_MODE, d.a.NEED_TO_LOG);
        }
        if (bDLocation != null && bDLocation.getLocType() == 66 && this.s) {
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            bDLocation2.setLocType(BDLocation.TypeNetWorkLocation);
            if (this.s) {
                com.baidu.location.c.g gVar = new com.baidu.location.c.g();
                gVar.a(this.MC);
                gVar.b(uptimeMillis);
                gVar.c(uptimeMillis);
                gVar.d(SystemClock.uptimeMillis());
                gVar.a("ofs");
                if (this.Mw != null) {
                    gVar.b(this.Mw.h());
                    gVar.b("&offtag=1");
                }
                com.baidu.location.c.f.mP().a(gVar);
                this.G = true;
                com.baidu.location.a.a.mw().a(bDLocation2);
                this.Mt = bDLocation2;
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
        if (this.Mt != null) {
            j.mG().c();
        }
    }

    public static synchronized e my() {
        e eVar;
        synchronized (e.class) {
            if (Mr == null) {
                Mr = new e();
            }
            eVar = Mr;
        }
        return eVar;
    }

    @Override // com.baidu.location.a.d
    public void a() {
        BDLocation bDLocation;
        if (this.MD != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.MD);
        }
        if (com.baidu.location.f.f.np().i()) {
            BDLocation bDLocation2 = new BDLocation(com.baidu.location.f.f.np().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.MB, this.z, bDLocation2.getLatitude(), bDLocation2.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.MA != null) {
                        bDLocation2.setAddr(this.MA);
                    }
                    if (this.x != null) {
                        bDLocation2.setLocationDescribe(this.x);
                    }
                    if (this.y != null) {
                        bDLocation2.setPoiList(this.y);
                    }
                }
            }
            com.baidu.location.a.a.mw().a(bDLocation2);
            k();
        } else if (this.G) {
            k();
        } else {
            com.baidu.location.c.f.mP().mQ().c(SystemClock.uptimeMillis());
            if (com.baidu.location.e.d.mT().d() && com.baidu.location.e.d.mT().e()) {
                bDLocation = com.baidu.location.e.d.mT().a(com.baidu.location.f.c.nm().ni(), com.baidu.location.f.k.nv().ns(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
                if (bDLocation != null && bDLocation.getLocType() == 66) {
                    com.baidu.location.a.a.mw().a(bDLocation);
                }
            } else {
                bDLocation = null;
            }
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                if (this.j || this.Mt == null) {
                    BDLocation ab = com.baidu.location.e.a.mS().ab(false);
                    com.baidu.location.a.a.mw().a(ab);
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
                    com.baidu.location.a.a.mw().a(this.Mt);
                }
            }
            com.baidu.location.c.f.mP().mQ().d(SystemClock.uptimeMillis());
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                this.Mt = null;
                com.baidu.location.c.f.mP().mQ().a("off");
                if (this.Mw != null) {
                    com.baidu.location.c.f.mP().mQ().b(this.Mw.h());
                }
                com.baidu.location.c.f.mP().c();
            } else {
                this.Mt = bDLocation;
                com.baidu.location.c.f.mP().mQ().a("ofs");
                if (this.Mw != null) {
                    com.baidu.location.c.f.mP().mQ().b(this.Mw.h());
                }
                com.baidu.location.c.f.mP().c();
            }
            this.Mu = null;
            k();
        }
    }

    @Override // com.baidu.location.a.d
    public void a(Message message) {
        boolean z;
        if (this.MD != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.MD);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            this.MA = bDLocation.getAddress();
            this.z = bDLocation.getLongitude();
            this.MB = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.x = bDLocation.getLocationDescribe();
            this.z = bDLocation.getLongitude();
            this.MB = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.y = bDLocation.getPoiList();
            this.z = bDLocation.getLongitude();
            this.MB = bDLocation.getLatitude();
        }
        if (com.baidu.location.f.f.np().i()) {
            BDLocation bDLocation3 = new BDLocation(com.baidu.location.f.f.np().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.MB, this.z, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.MA != null) {
                        bDLocation3.setAddr(this.MA);
                    }
                    if (this.x != null) {
                        bDLocation3.setLocationDescribe(this.x);
                    }
                    if (this.y != null) {
                        bDLocation3.setPoiList(this.y);
                    }
                }
            }
            com.baidu.location.a.a.mw().a(bDLocation3);
            k();
        } else if (bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("sky")) {
            bDLocation.setNetworkLocationType("wf");
            com.baidu.location.a.a.mw().a(bDLocation);
            this.Mz = System.currentTimeMillis();
            this.Mt = bDLocation;
        } else if (this.G) {
            float[] fArr2 = new float[2];
            if (this.Mt != null) {
                Location.distanceBetween(this.Mt.getLatitude(), this.Mt.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
            }
            if (fArr2[0] > 10.0f) {
                this.Mt = bDLocation;
                if (!this.H) {
                    this.H = false;
                    com.baidu.location.a.a.mw().a(bDLocation);
                }
            }
            k();
        } else {
            com.baidu.location.c.f.mP().mQ().c(SystemClock.uptimeMillis());
            this.Mu = null;
            if (bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && this.Mt != null && this.Mt.getLocType() == 161 && "wf".equals(this.Mt.getNetworkLocationType()) && System.currentTimeMillis() - this.Mz < 30000) {
                z = true;
                this.Mu = bDLocation;
            } else {
                z = false;
            }
            if (z) {
                com.baidu.location.a.a.mw().a(this.Mt);
            } else {
                com.baidu.location.a.a.mw().a(bDLocation);
                this.Mz = System.currentTimeMillis();
                com.baidu.location.c.f.mP().mQ().d(SystemClock.uptimeMillis());
                if (bDLocation.getLocType() == 161) {
                    com.baidu.location.c.f.mP().mQ().a("ons");
                    if (this.Mw != null) {
                        com.baidu.location.c.f.mP().mQ().b(this.Mw.h());
                    }
                } else {
                    com.baidu.location.c.f.mP().mQ().a("onf");
                    if (this.Mw != null) {
                        com.baidu.location.c.f.mP().mQ().b(this.Mw.h());
                    }
                    com.baidu.location.c.f.mP().c();
                }
            }
            if (!com.baidu.location.h.i.d(bDLocation)) {
                this.Mt = null;
            } else if (!z) {
                this.Mt = bDLocation;
            }
            int h2 = com.baidu.location.h.i.h(c, "ssid\":\"", "\"");
            if (h2 == Integer.MIN_VALUE || this.Mv == null) {
                this.k = null;
            } else {
                this.k = this.Mv.c(h2);
            }
            if (com.baidu.location.e.d.mT().d() && bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && b(this.Mw)) {
                com.baidu.location.e.d.mT().a(this.Mw, null, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.My = this.Mw;
            }
            if (com.baidu.location.e.d.mT().d() && bDLocation.getLocType() == 161 && "wf".equals(bDLocation.getNetworkLocationType())) {
                com.baidu.location.e.d.mT().a(null, this.Mv, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.Mx = this.Mv;
            }
            if (this.Mw != null) {
                com.baidu.location.e.a.mS().a(c, this.Mw, this.Mv, bDLocation2);
            }
            if (com.baidu.location.f.k.nv().g()) {
                com.baidu.location.e.d.mT().i();
                com.baidu.location.e.d.mT().m();
            }
            k();
        }
    }

    public void a(boolean z) {
        BDLocation bDLocation = null;
        if (com.baidu.location.e.d.mT().d() && com.baidu.location.e.d.mT().g()) {
            bDLocation = com.baidu.location.e.d.mT().a(com.baidu.location.f.c.nm().ni(), com.baidu.location.f.k.nv().ns(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
            if ((bDLocation == null || bDLocation.getLocType() == 67) && z) {
                bDLocation = com.baidu.location.e.a.mS().ab(false);
            }
        } else if (z) {
            bDLocation = com.baidu.location.e.a.mS().ab(false);
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
            com.baidu.location.a.a.mw().a(bDLocation);
        }
    }

    public Address b(BDLocation bDLocation) {
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.MB, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] >= 100.0f) {
                this.x = null;
                this.y = null;
                this.B = true;
                i(null);
            } else if (this.MA != null) {
                return this.MA;
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
            com.baidu.location.c.a.mK().d();
            return;
        }
        j(null);
        this.t = false;
    }

    public void i() {
        this.Mt = null;
    }
}
