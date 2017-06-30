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
    private static e Md = null;
    public static boolean h = false;
    public d.b Me;
    private double Mn;
    private double z;
    final int e = 1000;
    private boolean j = true;
    private String k = null;
    private BDLocation Mf = null;
    private BDLocation Mg = null;
    private com.baidu.location.f.i Mh = null;
    private com.baidu.location.f.a Mi = null;
    private com.baidu.location.f.i Mj = null;
    private com.baidu.location.f.a Mk = null;
    private boolean r = true;
    private volatile boolean s = false;
    private boolean t = false;
    private long u = 0;
    private long Ml = 0;
    private Address Mm = null;
    private String x = null;
    private List<Poi> y = null;
    private boolean B = false;
    private long C = 0;
    private long Mo = 0;
    private a Mp = null;
    private boolean F = false;
    private boolean G = false;
    private boolean H = true;
    public final Handler g = new d.a();
    private boolean I = false;
    private b Mq = null;
    private boolean Mr = false;

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
            if (e.this.Mr) {
                e.this.Mr = false;
            }
            if (e.this.t) {
                e.this.t = false;
                e.this.j(null);
            }
        }
    }

    private e() {
        this.Me = null;
        this.Me = new d.b();
    }

    private boolean a(com.baidu.location.f.a aVar) {
        this.Ma = com.baidu.location.f.c.nb().mX();
        if (this.Ma == aVar) {
            return false;
        }
        return this.Ma == null || aVar == null || !aVar.a(this.Ma);
    }

    private boolean a(com.baidu.location.f.i iVar) {
        this.LZ = com.baidu.location.f.k.nk().ni();
        if (iVar == this.LZ) {
            return false;
        }
        return this.LZ == null || iVar == null || !iVar.c(this.LZ);
    }

    private boolean b(com.baidu.location.f.a aVar) {
        if (aVar == null) {
            return false;
        }
        return this.Mk == null || !aVar.a(this.Mk);
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
                if (com.baidu.location.f.f.ne().i()) {
                    h(message);
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(e)));
        }
    }

    private void g(Message message) {
        if (com.baidu.location.f.f.ne().i()) {
            h(message);
            f.mq().c();
            return;
        }
        i(message);
        f.mq().b();
    }

    private void h(Message message) {
        BDLocation bDLocation = new BDLocation(com.baidu.location.f.f.ne().f());
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.Mn, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.Mm != null) {
                    bDLocation.setAddr(this.Mm);
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
        this.Mf = bDLocation;
        this.Mg = null;
        com.baidu.location.a.a.mn().a(bDLocation);
    }

    private void i(Message message) {
        if (this.r) {
            this.Mo = SystemClock.uptimeMillis();
            j(message);
        } else if (this.s) {
        } else {
            this.Mo = SystemClock.uptimeMillis();
            if (!com.baidu.location.f.k.nk().e()) {
                j(message);
                return;
            }
            this.t = true;
            if (this.Mq == null) {
                this.Mq = new b();
            }
            if (this.Mr && this.Mq != null) {
                this.g.removeCallbacks(this.Mq);
            }
            this.g.postDelayed(this.Mq, 3500L);
            this.Mr = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Message message) {
        if (this.s) {
            return;
        }
        if (System.currentTimeMillis() - this.u < 1000 && this.Mf != null) {
            com.baidu.location.a.a.mn().a(this.Mf);
            k();
            return;
        }
        if (this.Mo > 0) {
            com.baidu.location.c.f.mG().mH().a(this.Mo);
        } else {
            com.baidu.location.c.f.mG().mH().a(SystemClock.uptimeMillis());
        }
        this.s = true;
        this.j = a(this.Mi);
        if (!a(this.Mh) && !this.j && this.Mf != null && !this.B) {
            if (this.Mg != null && System.currentTimeMillis() - this.Ml > 30000) {
                this.Mf = this.Mg;
                this.Mg = null;
            }
            if (f.mq().f()) {
                this.Mf.setDirection(f.mq().h());
            }
            com.baidu.location.a.a.mn().a(this.Mf);
            k();
            return;
        }
        this.u = System.currentTimeMillis();
        String a2 = a((String) null);
        if (a2 == null) {
            if (this.Mf != null) {
                com.baidu.location.a.a.mn().a(this.Mf);
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
        this.Me.a(a2);
        this.Mi = this.Ma;
        this.Mh = this.LZ;
        if (j()) {
            this.Mi = this.Ma;
            this.Mh = this.LZ;
        }
        if (com.baidu.location.e.d.mK().h()) {
            if (this.Mp == null) {
                this.Mp = new a();
            }
            this.g.postDelayed(this.Mp, com.baidu.location.e.d.mK().a(com.baidu.location.f.c.a(com.baidu.location.f.c.nb().e())));
            this.F = true;
        }
        if (this.r) {
            this.r = false;
            if (com.baidu.location.f.k.nk().g() && message != null && com.baidu.location.a.a.mn().f(message) < 1000 && com.baidu.location.e.d.mK().d()) {
                com.baidu.location.e.d.mK().i();
            }
            com.baidu.location.c.a.mB().b();
        }
    }

    private boolean j() {
        BDLocation bDLocation = null;
        double random = Math.random();
        long uptimeMillis = SystemClock.uptimeMillis();
        com.baidu.location.f.a mX = com.baidu.location.f.c.nb().mX();
        com.baidu.location.f.i nh = com.baidu.location.f.k.nk().nh();
        boolean z = mX != null && mX.e() && (nh == null || nh.a() == 0);
        if (com.baidu.location.e.d.mK().d() && com.baidu.location.e.d.mK().f() && (z || (0.0d < random && random < com.baidu.location.e.d.mK().o()))) {
            bDLocation = com.baidu.location.e.d.mK().a(com.baidu.location.f.c.nb().mX(), com.baidu.location.f.k.nk().nh(), null, d.b.IS_MIX_MODE, d.a.NEED_TO_LOG);
        }
        if (bDLocation != null && bDLocation.getLocType() == 66 && this.s) {
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            bDLocation2.setLocType(BDLocation.TypeNetWorkLocation);
            if (this.s) {
                com.baidu.location.c.g gVar = new com.baidu.location.c.g();
                gVar.a(this.Mo);
                gVar.b(uptimeMillis);
                gVar.c(uptimeMillis);
                gVar.d(SystemClock.uptimeMillis());
                gVar.a("ofs");
                if (this.Mi != null) {
                    gVar.b(this.Mi.h());
                    gVar.b("&offtag=1");
                }
                com.baidu.location.c.f.mG().a(gVar);
                this.G = true;
                com.baidu.location.a.a.mn().a(bDLocation2);
                this.Mf = bDLocation2;
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
        if (this.Mf != null) {
            j.mx().c();
        }
    }

    public static synchronized e mp() {
        e eVar;
        synchronized (e.class) {
            if (Md == null) {
                Md = new e();
            }
            eVar = Md;
        }
        return eVar;
    }

    @Override // com.baidu.location.a.d
    public void a() {
        BDLocation bDLocation;
        if (this.Mp != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.Mp);
        }
        if (com.baidu.location.f.f.ne().i()) {
            BDLocation bDLocation2 = new BDLocation(com.baidu.location.f.f.ne().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.Mn, this.z, bDLocation2.getLatitude(), bDLocation2.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.Mm != null) {
                        bDLocation2.setAddr(this.Mm);
                    }
                    if (this.x != null) {
                        bDLocation2.setLocationDescribe(this.x);
                    }
                    if (this.y != null) {
                        bDLocation2.setPoiList(this.y);
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
                bDLocation = com.baidu.location.e.d.mK().a(com.baidu.location.f.c.nb().mX(), com.baidu.location.f.k.nk().nh(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
                if (bDLocation != null && bDLocation.getLocType() == 66) {
                    com.baidu.location.a.a.mn().a(bDLocation);
                }
            } else {
                bDLocation = null;
            }
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                if (this.j || this.Mf == null) {
                    BDLocation aa = com.baidu.location.e.a.mJ().aa(false);
                    com.baidu.location.a.a.mn().a(aa);
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
                    com.baidu.location.a.a.mn().a(this.Mf);
                }
            }
            com.baidu.location.c.f.mG().mH().d(SystemClock.uptimeMillis());
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                this.Mf = null;
                com.baidu.location.c.f.mG().mH().a("off");
                if (this.Mi != null) {
                    com.baidu.location.c.f.mG().mH().b(this.Mi.h());
                }
                com.baidu.location.c.f.mG().c();
            } else {
                this.Mf = bDLocation;
                com.baidu.location.c.f.mG().mH().a("ofs");
                if (this.Mi != null) {
                    com.baidu.location.c.f.mG().mH().b(this.Mi.h());
                }
                com.baidu.location.c.f.mG().c();
            }
            this.Mg = null;
            k();
        }
    }

    @Override // com.baidu.location.a.d
    public void a(Message message) {
        boolean z;
        if (this.Mp != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.Mp);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            this.Mm = bDLocation.getAddress();
            this.z = bDLocation.getLongitude();
            this.Mn = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.x = bDLocation.getLocationDescribe();
            this.z = bDLocation.getLongitude();
            this.Mn = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.y = bDLocation.getPoiList();
            this.z = bDLocation.getLongitude();
            this.Mn = bDLocation.getLatitude();
        }
        if (com.baidu.location.f.f.ne().i()) {
            BDLocation bDLocation3 = new BDLocation(com.baidu.location.f.f.ne().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.Mn, this.z, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.Mm != null) {
                        bDLocation3.setAddr(this.Mm);
                    }
                    if (this.x != null) {
                        bDLocation3.setLocationDescribe(this.x);
                    }
                    if (this.y != null) {
                        bDLocation3.setPoiList(this.y);
                    }
                }
            }
            com.baidu.location.a.a.mn().a(bDLocation3);
            k();
        } else if (bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("sky")) {
            bDLocation.setNetworkLocationType("wf");
            com.baidu.location.a.a.mn().a(bDLocation);
            this.Ml = System.currentTimeMillis();
            this.Mf = bDLocation;
        } else if (this.G) {
            float[] fArr2 = new float[2];
            if (this.Mf != null) {
                Location.distanceBetween(this.Mf.getLatitude(), this.Mf.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
            }
            if (fArr2[0] > 10.0f) {
                this.Mf = bDLocation;
                if (!this.H) {
                    this.H = false;
                    com.baidu.location.a.a.mn().a(bDLocation);
                }
            }
            k();
        } else {
            com.baidu.location.c.f.mG().mH().c(SystemClock.uptimeMillis());
            this.Mg = null;
            if (bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && this.Mf != null && this.Mf.getLocType() == 161 && "wf".equals(this.Mf.getNetworkLocationType()) && System.currentTimeMillis() - this.Ml < 30000) {
                z = true;
                this.Mg = bDLocation;
            } else {
                z = false;
            }
            if (z) {
                com.baidu.location.a.a.mn().a(this.Mf);
            } else {
                com.baidu.location.a.a.mn().a(bDLocation);
                this.Ml = System.currentTimeMillis();
                com.baidu.location.c.f.mG().mH().d(SystemClock.uptimeMillis());
                if (bDLocation.getLocType() == 161) {
                    com.baidu.location.c.f.mG().mH().a("ons");
                    if (this.Mi != null) {
                        com.baidu.location.c.f.mG().mH().b(this.Mi.h());
                    }
                } else {
                    com.baidu.location.c.f.mG().mH().a("onf");
                    if (this.Mi != null) {
                        com.baidu.location.c.f.mG().mH().b(this.Mi.h());
                    }
                    com.baidu.location.c.f.mG().c();
                }
            }
            if (!com.baidu.location.h.i.d(bDLocation)) {
                this.Mf = null;
            } else if (!z) {
                this.Mf = bDLocation;
            }
            int h2 = com.baidu.location.h.i.h(c, "ssid\":\"", "\"");
            if (h2 == Integer.MIN_VALUE || this.Mh == null) {
                this.k = null;
            } else {
                this.k = this.Mh.c(h2);
            }
            if (com.baidu.location.e.d.mK().d() && bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && b(this.Mi)) {
                com.baidu.location.e.d.mK().a(this.Mi, null, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.Mk = this.Mi;
            }
            if (com.baidu.location.e.d.mK().d() && bDLocation.getLocType() == 161 && "wf".equals(bDLocation.getNetworkLocationType())) {
                com.baidu.location.e.d.mK().a(null, this.Mh, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.Mj = this.Mh;
            }
            if (this.Mi != null) {
                com.baidu.location.e.a.mJ().a(c, this.Mi, this.Mh, bDLocation2);
            }
            if (com.baidu.location.f.k.nk().g()) {
                com.baidu.location.e.d.mK().i();
                com.baidu.location.e.d.mK().m();
            }
            k();
        }
    }

    public void a(boolean z) {
        BDLocation bDLocation = null;
        if (com.baidu.location.e.d.mK().d() && com.baidu.location.e.d.mK().g()) {
            bDLocation = com.baidu.location.e.d.mK().a(com.baidu.location.f.c.nb().mX(), com.baidu.location.f.k.nk().nh(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
            if ((bDLocation == null || bDLocation.getLocType() == 67) && z) {
                bDLocation = com.baidu.location.e.a.mJ().aa(false);
            }
        } else if (z) {
            bDLocation = com.baidu.location.e.a.mJ().aa(false);
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
            Location.distanceBetween(this.Mn, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] >= 100.0f) {
                this.x = null;
                this.y = null;
                this.B = true;
                i(null);
            } else if (this.Mm != null) {
                return this.Mm;
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
            com.baidu.location.c.a.mB().d();
            return;
        }
        j(null);
        this.t = false;
    }

    public void i() {
        this.Mf = null;
    }
}
