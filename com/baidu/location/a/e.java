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
    private static e Le = null;
    public static boolean h = false;
    public d.b Lf;
    private double Lo;
    private double z;
    final int e = 1000;
    private boolean j = true;
    private String k = null;
    private BDLocation Lg = null;
    private BDLocation Lh = null;
    private com.baidu.location.f.i Li = null;
    private com.baidu.location.f.a Lj = null;
    private com.baidu.location.f.i Lk = null;
    private com.baidu.location.f.a Ll = null;
    private boolean r = true;
    private volatile boolean s = false;
    private boolean t = false;
    private long u = 0;
    private long Lm = 0;
    private Address Ln = null;
    private String x = null;
    private List<Poi> y = null;
    private boolean B = false;
    private long Lp = 0;
    private long Lq = 0;
    private a Lr = null;
    private boolean F = false;
    private boolean G = false;
    private boolean H = true;
    public final Handler g = new d.a();
    private boolean I = false;
    private b Ls = null;
    private boolean Lt = false;

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
            if (e.this.Lt) {
                e.this.Lt = false;
            }
            if (e.this.t) {
                e.this.t = false;
                e.this.j(null);
            }
        }
    }

    private e() {
        this.Lf = null;
        this.Lf = new d.b();
    }

    private boolean a(com.baidu.location.f.a aVar) {
        this.Lb = com.baidu.location.f.c.mV().mR();
        if (this.Lb == aVar) {
            return false;
        }
        return this.Lb == null || aVar == null || !aVar.a(this.Lb);
    }

    private boolean a(com.baidu.location.f.i iVar) {
        this.La = com.baidu.location.f.k.ne().nc();
        if (iVar == this.La) {
            return false;
        }
        return this.La == null || iVar == null || !iVar.c(this.La);
    }

    private boolean b(com.baidu.location.f.a aVar) {
        if (aVar == null) {
            return false;
        }
        return this.Ll == null || !aVar.a(this.Ll);
    }

    private void c(Message message) {
        boolean z = message.getData().getBoolean("isWaitingLocTag", false);
        if (z) {
            h = true;
        }
        if (z) {
        }
        int e = com.baidu.location.a.a.mc().e(message);
        f.mf().d();
        switch (e) {
            case 1:
                g(message);
                return;
            case 2:
                i(message);
                return;
            case 3:
                if (com.baidu.location.f.f.mY().i()) {
                    h(message);
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(e)));
        }
    }

    private void g(Message message) {
        if (com.baidu.location.f.f.mY().i()) {
            h(message);
            f.mf().c();
            return;
        }
        i(message);
        f.mf().b();
    }

    private void h(Message message) {
        BDLocation bDLocation = new BDLocation(com.baidu.location.f.f.mY().f());
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.Lo, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.Ln != null) {
                    bDLocation.setAddr(this.Ln);
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
        this.Lg = bDLocation;
        this.Lh = null;
        com.baidu.location.a.a.mc().a(bDLocation);
    }

    private void i(Message message) {
        if (this.r) {
            this.Lq = SystemClock.uptimeMillis();
            j(message);
        } else if (this.s) {
        } else {
            this.Lq = SystemClock.uptimeMillis();
            if (!com.baidu.location.f.k.ne().e()) {
                j(message);
                return;
            }
            this.t = true;
            if (this.Ls == null) {
                this.Ls = new b();
            }
            if (this.Lt && this.Ls != null) {
                this.g.removeCallbacks(this.Ls);
            }
            this.g.postDelayed(this.Ls, 3500L);
            this.Lt = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Message message) {
        if (this.s) {
            return;
        }
        if (System.currentTimeMillis() - this.u < 1000 && this.Lg != null) {
            com.baidu.location.a.a.mc().a(this.Lg);
            k();
            return;
        }
        if (this.Lq > 0) {
            com.baidu.location.c.f.my().mz().a(this.Lq);
        } else {
            com.baidu.location.c.f.my().mz().a(SystemClock.uptimeMillis());
        }
        this.s = true;
        this.j = a(this.Lj);
        if (!a(this.Li) && !this.j && this.Lg != null && !this.B) {
            if (this.Lh != null && System.currentTimeMillis() - this.Lm > 30000) {
                this.Lg = this.Lh;
                this.Lh = null;
            }
            if (f.mf().f()) {
                this.Lg.setDirection(f.mf().mh());
            }
            com.baidu.location.a.a.mc().a(this.Lg);
            k();
            return;
        }
        this.u = System.currentTimeMillis();
        String a2 = a((String) null);
        if (a2 == null) {
            if (this.Lg != null) {
                com.baidu.location.a.a.mc().a(this.Lg);
                k();
                return;
            }
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLocType(62);
            com.baidu.location.a.a.mc().a(bDLocation);
            k();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.Lp > TbConfig.USE_TIME_INTERVAL) {
                this.Lp = currentTimeMillis;
                com.baidu.location.c.f.my().a("TypeCriteriaException");
                return;
            }
            return;
        }
        if (this.k != null) {
            a2 = a2 + this.k;
            this.k = null;
        }
        com.baidu.location.c.f.my().mz().b(SystemClock.uptimeMillis());
        this.Lf.a(a2);
        this.Lj = this.Lb;
        this.Li = this.La;
        if (j()) {
            this.Lj = this.Lb;
            this.Li = this.La;
        }
        if (com.baidu.location.e.d.mC().h()) {
            if (this.Lr == null) {
                this.Lr = new a();
            }
            this.g.postDelayed(this.Lr, com.baidu.location.e.d.mC().bO(com.baidu.location.f.c.a(com.baidu.location.f.c.mV().e())));
            this.F = true;
        }
        if (this.r) {
            this.r = false;
            if (com.baidu.location.f.k.ne().g() && message != null && com.baidu.location.a.a.mc().f(message) < 1000 && com.baidu.location.e.d.mC().d()) {
                com.baidu.location.e.d.mC().i();
            }
            com.baidu.location.c.a.mt().b();
        }
    }

    private boolean j() {
        BDLocation bDLocation = null;
        double random = Math.random();
        long uptimeMillis = SystemClock.uptimeMillis();
        com.baidu.location.f.a mR = com.baidu.location.f.c.mV().mR();
        com.baidu.location.f.i nb = com.baidu.location.f.k.ne().nb();
        boolean z = mR != null && mR.e() && (nb == null || nb.a() == 0);
        if (com.baidu.location.e.d.mC().d() && com.baidu.location.e.d.mC().f() && (z || (0.0d < random && random < com.baidu.location.e.d.mC().o()))) {
            bDLocation = com.baidu.location.e.d.mC().a(com.baidu.location.f.c.mV().mR(), com.baidu.location.f.k.ne().nb(), null, d.b.IS_MIX_MODE, d.a.NEED_TO_LOG);
        }
        if (bDLocation != null && bDLocation.getLocType() == 66 && this.s) {
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            bDLocation2.setLocType(BDLocation.TypeNetWorkLocation);
            if (this.s) {
                com.baidu.location.c.g gVar = new com.baidu.location.c.g();
                gVar.a(this.Lq);
                gVar.b(uptimeMillis);
                gVar.c(uptimeMillis);
                gVar.d(SystemClock.uptimeMillis());
                gVar.a("ofs");
                if (this.Lj != null) {
                    gVar.b(this.Lj.h());
                    gVar.b("&offtag=1");
                }
                com.baidu.location.c.f.my().a(gVar);
                this.G = true;
                com.baidu.location.a.a.mc().a(bDLocation2);
                this.Lg = bDLocation2;
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
        if (this.Lg != null) {
            j.mp().c();
        }
    }

    public static synchronized e me() {
        e eVar;
        synchronized (e.class) {
            if (Le == null) {
                Le = new e();
            }
            eVar = Le;
        }
        return eVar;
    }

    @Override // com.baidu.location.a.d
    public void a() {
        BDLocation bDLocation;
        if (this.Lr != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.Lr);
        }
        if (com.baidu.location.f.f.mY().i()) {
            BDLocation bDLocation2 = new BDLocation(com.baidu.location.f.f.mY().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.Lo, this.z, bDLocation2.getLatitude(), bDLocation2.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.Ln != null) {
                        bDLocation2.setAddr(this.Ln);
                    }
                    if (this.x != null) {
                        bDLocation2.setLocationDescribe(this.x);
                    }
                    if (this.y != null) {
                        bDLocation2.setPoiList(this.y);
                    }
                }
            }
            com.baidu.location.a.a.mc().a(bDLocation2);
            k();
        } else if (this.G) {
            k();
        } else {
            com.baidu.location.c.f.my().mz().c(SystemClock.uptimeMillis());
            if (com.baidu.location.e.d.mC().d() && com.baidu.location.e.d.mC().e()) {
                bDLocation = com.baidu.location.e.d.mC().a(com.baidu.location.f.c.mV().mR(), com.baidu.location.f.k.ne().nb(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
                if (bDLocation != null && bDLocation.getLocType() == 66) {
                    com.baidu.location.a.a.mc().a(bDLocation);
                }
            } else {
                bDLocation = null;
            }
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                if (this.j || this.Lg == null) {
                    BDLocation aa = com.baidu.location.e.a.mB().aa(false);
                    com.baidu.location.a.a.mc().a(aa);
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
                    com.baidu.location.a.a.mc().a(this.Lg);
                }
            }
            com.baidu.location.c.f.my().mz().d(SystemClock.uptimeMillis());
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                this.Lg = null;
                com.baidu.location.c.f.my().mz().a("off");
                if (this.Lj != null) {
                    com.baidu.location.c.f.my().mz().b(this.Lj.h());
                }
                com.baidu.location.c.f.my().c();
            } else {
                this.Lg = bDLocation;
                com.baidu.location.c.f.my().mz().a("ofs");
                if (this.Lj != null) {
                    com.baidu.location.c.f.my().mz().b(this.Lj.h());
                }
                com.baidu.location.c.f.my().c();
            }
            this.Lh = null;
            k();
        }
    }

    @Override // com.baidu.location.a.d
    public void a(Message message) {
        boolean z;
        if (this.Lr != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.Lr);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            this.Ln = bDLocation.getAddress();
            this.z = bDLocation.getLongitude();
            this.Lo = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.x = bDLocation.getLocationDescribe();
            this.z = bDLocation.getLongitude();
            this.Lo = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.y = bDLocation.getPoiList();
            this.z = bDLocation.getLongitude();
            this.Lo = bDLocation.getLatitude();
        }
        if (com.baidu.location.f.f.mY().i()) {
            BDLocation bDLocation3 = new BDLocation(com.baidu.location.f.f.mY().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.Lo, this.z, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.Ln != null) {
                        bDLocation3.setAddr(this.Ln);
                    }
                    if (this.x != null) {
                        bDLocation3.setLocationDescribe(this.x);
                    }
                    if (this.y != null) {
                        bDLocation3.setPoiList(this.y);
                    }
                }
            }
            com.baidu.location.a.a.mc().a(bDLocation3);
            k();
        } else if (bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("sky")) {
            bDLocation.setNetworkLocationType("wf");
            com.baidu.location.a.a.mc().a(bDLocation);
            this.Lm = System.currentTimeMillis();
            this.Lg = bDLocation;
        } else if (this.G) {
            float[] fArr2 = new float[2];
            if (this.Lg != null) {
                Location.distanceBetween(this.Lg.getLatitude(), this.Lg.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
            }
            if (fArr2[0] > 10.0f) {
                this.Lg = bDLocation;
                if (!this.H) {
                    this.H = false;
                    com.baidu.location.a.a.mc().a(bDLocation);
                }
            }
            k();
        } else {
            com.baidu.location.c.f.my().mz().c(SystemClock.uptimeMillis());
            this.Lh = null;
            if (bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && this.Lg != null && this.Lg.getLocType() == 161 && "wf".equals(this.Lg.getNetworkLocationType()) && System.currentTimeMillis() - this.Lm < 30000) {
                z = true;
                this.Lh = bDLocation;
            } else {
                z = false;
            }
            if (z) {
                com.baidu.location.a.a.mc().a(this.Lg);
            } else {
                com.baidu.location.a.a.mc().a(bDLocation);
                this.Lm = System.currentTimeMillis();
                com.baidu.location.c.f.my().mz().d(SystemClock.uptimeMillis());
                if (bDLocation.getLocType() == 161) {
                    com.baidu.location.c.f.my().mz().a("ons");
                    if (this.Lj != null) {
                        com.baidu.location.c.f.my().mz().b(this.Lj.h());
                    }
                } else {
                    com.baidu.location.c.f.my().mz().a("onf");
                    if (this.Lj != null) {
                        com.baidu.location.c.f.my().mz().b(this.Lj.h());
                    }
                    com.baidu.location.c.f.my().c();
                }
            }
            if (!com.baidu.location.h.i.d(bDLocation)) {
                this.Lg = null;
            } else if (!z) {
                this.Lg = bDLocation;
            }
            int h2 = com.baidu.location.h.i.h(c, "ssid\":\"", "\"");
            if (h2 == Integer.MIN_VALUE || this.Li == null) {
                this.k = null;
            } else {
                this.k = this.Li.c(h2);
            }
            if (com.baidu.location.e.d.mC().d() && bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && b(this.Lj)) {
                com.baidu.location.e.d.mC().a(this.Lj, null, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.Ll = this.Lj;
            }
            if (com.baidu.location.e.d.mC().d() && bDLocation.getLocType() == 161 && "wf".equals(bDLocation.getNetworkLocationType())) {
                com.baidu.location.e.d.mC().a(null, this.Li, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.Lk = this.Li;
            }
            if (this.Lj != null) {
                com.baidu.location.e.a.mB().a(c, this.Lj, this.Li, bDLocation2);
            }
            if (com.baidu.location.f.k.ne().g()) {
                com.baidu.location.e.d.mC().i();
                com.baidu.location.e.d.mC().m();
            }
            k();
        }
    }

    public void a(boolean z) {
        BDLocation bDLocation = null;
        if (com.baidu.location.e.d.mC().d() && com.baidu.location.e.d.mC().g()) {
            bDLocation = com.baidu.location.e.d.mC().a(com.baidu.location.f.c.mV().mR(), com.baidu.location.f.k.ne().nb(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
            if ((bDLocation == null || bDLocation.getLocType() == 67) && z) {
                bDLocation = com.baidu.location.e.a.mB().aa(false);
            }
        } else if (z) {
            bDLocation = com.baidu.location.e.a.mB().aa(false);
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
            com.baidu.location.a.a.mc().a(bDLocation);
        }
    }

    public Address b(BDLocation bDLocation) {
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.Lo, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] >= 100.0f) {
                this.x = null;
                this.y = null;
                this.B = true;
                i(null);
            } else if (this.Ln != null) {
                return this.Ln;
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
            com.baidu.location.c.a.mt().d();
            return;
        }
        j(null);
        this.t = false;
    }

    public void i() {
        this.Lg = null;
    }
}
