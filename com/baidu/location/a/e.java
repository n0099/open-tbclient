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
    private static e Gh = null;
    public static boolean h = false;
    public d.b Gi;
    private double Gs;
    private double z;
    final int e = 1000;
    private boolean j = true;
    private String k = null;
    private BDLocation Gj = null;
    private BDLocation Gk = null;
    private com.baidu.location.f.i Gl = null;
    private com.baidu.location.f.a Gm = null;
    private com.baidu.location.f.i Gn = null;
    private com.baidu.location.f.a Go = null;
    private boolean r = true;
    private volatile boolean s = false;
    private boolean t = false;
    private long u = 0;
    private long Gp = 0;
    private Address Gq = null;
    private String x = null;
    private List<Poi> Gr = null;
    private boolean B = false;
    private long C = 0;
    private long Gt = 0;
    private a Gu = null;
    private boolean F = false;
    private boolean G = false;
    private boolean H = true;
    public final Handler g = new d.a();
    private boolean Gv = false;
    private b Gw = null;
    private boolean Gx = false;

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
            if (e.this.Gx) {
                e.this.Gx = false;
            }
            if (e.this.t) {
                e.this.t = false;
                e.this.j(null);
            }
        }
    }

    private e() {
        this.Gi = null;
        this.Gi = new d.b();
    }

    private boolean a(com.baidu.location.f.a aVar) {
        this.Ge = com.baidu.location.f.c.mh().md();
        if (this.Ge == aVar) {
            return false;
        }
        return this.Ge == null || aVar == null || !aVar.a(this.Ge);
    }

    private boolean a(com.baidu.location.f.i iVar) {
        this.Gd = com.baidu.location.f.k.mq().mo();
        if (iVar == this.Gd) {
            return false;
        }
        return this.Gd == null || iVar == null || !iVar.c(this.Gd);
    }

    private boolean b(com.baidu.location.f.a aVar) {
        if (aVar == null) {
            return false;
        }
        return this.Go == null || !aVar.a(this.Go);
    }

    private void c(Message message) {
        boolean z = message.getData().getBoolean("isWaitingLocTag", false);
        if (z) {
            h = true;
        }
        if (z) {
        }
        int e = com.baidu.location.a.a.ls().e(message);
        f.lv().d();
        switch (e) {
            case 1:
                g(message);
                return;
            case 2:
                i(message);
                return;
            case 3:
                if (com.baidu.location.f.f.mk().i()) {
                    h(message);
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(e)));
        }
    }

    private void g(Message message) {
        if (com.baidu.location.f.f.mk().i()) {
            h(message);
            f.lv().c();
            return;
        }
        i(message);
        f.lv().b();
    }

    private void h(Message message) {
        BDLocation bDLocation = new BDLocation(com.baidu.location.f.f.mk().f());
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.Gs, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.Gq != null) {
                    bDLocation.setAddr(this.Gq);
                }
                if (this.x != null) {
                    bDLocation.setLocationDescribe(this.x);
                }
                if (this.Gr != null) {
                    bDLocation.setPoiList(this.Gr);
                }
            } else {
                this.B = true;
                i(null);
            }
        }
        this.Gj = bDLocation;
        this.Gk = null;
        com.baidu.location.a.a.ls().a(bDLocation);
    }

    private void i(Message message) {
        if (this.r) {
            this.Gt = SystemClock.uptimeMillis();
            j(message);
        } else if (this.s) {
        } else {
            this.Gt = SystemClock.uptimeMillis();
            if (!com.baidu.location.f.k.mq().e()) {
                j(message);
                return;
            }
            this.t = true;
            if (this.Gw == null) {
                this.Gw = new b();
            }
            if (this.Gx && this.Gw != null) {
                this.g.removeCallbacks(this.Gw);
            }
            this.g.postDelayed(this.Gw, 3500L);
            this.Gx = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Message message) {
        if (this.s) {
            return;
        }
        if (System.currentTimeMillis() - this.u < 1000 && this.Gj != null) {
            com.baidu.location.a.a.ls().a(this.Gj);
            k();
            return;
        }
        if (this.Gt > 0) {
            com.baidu.location.c.f.lL().lM().a(this.Gt);
        } else {
            com.baidu.location.c.f.lL().lM().a(SystemClock.uptimeMillis());
        }
        this.s = true;
        this.j = a(this.Gm);
        if (!a(this.Gl) && !this.j && this.Gj != null && !this.B) {
            if (this.Gk != null && System.currentTimeMillis() - this.Gp > 30000) {
                this.Gj = this.Gk;
                this.Gk = null;
            }
            if (f.lv().f()) {
                this.Gj.setDirection(f.lv().h());
            }
            com.baidu.location.a.a.ls().a(this.Gj);
            k();
            return;
        }
        this.u = System.currentTimeMillis();
        String a2 = a((String) null);
        if (a2 == null) {
            if (this.Gj != null) {
                com.baidu.location.a.a.ls().a(this.Gj);
                k();
                return;
            }
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLocType(62);
            com.baidu.location.a.a.ls().a(bDLocation);
            k();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.C > TbConfig.USE_TIME_INTERVAL) {
                this.C = currentTimeMillis;
                com.baidu.location.c.f.lL().a("TypeCriteriaException");
                return;
            }
            return;
        }
        if (this.k != null) {
            a2 = a2 + this.k;
            this.k = null;
        }
        com.baidu.location.c.f.lL().lM().b(SystemClock.uptimeMillis());
        this.Gi.a(a2);
        this.Gm = this.Ge;
        this.Gl = this.Gd;
        if (j()) {
            this.Gm = this.Ge;
            this.Gl = this.Gd;
        }
        if (com.baidu.location.e.d.lP().h()) {
            if (this.Gu == null) {
                this.Gu = new a();
            }
            this.g.postDelayed(this.Gu, com.baidu.location.e.d.lP().a(com.baidu.location.f.c.a(com.baidu.location.f.c.mh().e())));
            this.F = true;
        }
        if (this.r) {
            this.r = false;
            if (com.baidu.location.f.k.mq().g() && message != null && com.baidu.location.a.a.ls().f(message) < 1000 && com.baidu.location.e.d.lP().d()) {
                com.baidu.location.e.d.lP().i();
            }
            com.baidu.location.c.a.lG().b();
        }
    }

    private boolean j() {
        BDLocation bDLocation = null;
        double random = Math.random();
        long uptimeMillis = SystemClock.uptimeMillis();
        com.baidu.location.f.a md = com.baidu.location.f.c.mh().md();
        com.baidu.location.f.i mn = com.baidu.location.f.k.mq().mn();
        boolean z = md != null && md.e() && (mn == null || mn.a() == 0);
        if (com.baidu.location.e.d.lP().d() && com.baidu.location.e.d.lP().f() && (z || (0.0d < random && random < com.baidu.location.e.d.lP().lU()))) {
            bDLocation = com.baidu.location.e.d.lP().a(com.baidu.location.f.c.mh().md(), com.baidu.location.f.k.mq().mn(), null, d.b.IS_MIX_MODE, d.a.NEED_TO_LOG);
        }
        if (bDLocation != null && bDLocation.getLocType() == 66 && this.s) {
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            bDLocation2.setLocType(BDLocation.TypeNetWorkLocation);
            if (this.s) {
                com.baidu.location.c.g gVar = new com.baidu.location.c.g();
                gVar.a(this.Gt);
                gVar.b(uptimeMillis);
                gVar.c(uptimeMillis);
                gVar.m(SystemClock.uptimeMillis());
                gVar.a("ofs");
                if (this.Gm != null) {
                    gVar.b(this.Gm.h());
                    gVar.b("&offtag=1");
                }
                com.baidu.location.c.f.lL().a(gVar);
                this.G = true;
                com.baidu.location.a.a.ls().a(bDLocation2);
                this.Gj = bDLocation2;
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
        if (this.Gj != null) {
            j.lC().c();
        }
    }

    public static synchronized e lu() {
        e eVar;
        synchronized (e.class) {
            if (Gh == null) {
                Gh = new e();
            }
            eVar = Gh;
        }
        return eVar;
    }

    @Override // com.baidu.location.a.d
    public void a() {
        BDLocation bDLocation;
        if (this.Gu != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.Gu);
        }
        if (com.baidu.location.f.f.mk().i()) {
            BDLocation bDLocation2 = new BDLocation(com.baidu.location.f.f.mk().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.Gs, this.z, bDLocation2.getLatitude(), bDLocation2.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.Gq != null) {
                        bDLocation2.setAddr(this.Gq);
                    }
                    if (this.x != null) {
                        bDLocation2.setLocationDescribe(this.x);
                    }
                    if (this.Gr != null) {
                        bDLocation2.setPoiList(this.Gr);
                    }
                }
            }
            com.baidu.location.a.a.ls().a(bDLocation2);
            k();
        } else if (this.G) {
            k();
        } else {
            com.baidu.location.c.f.lL().lM().c(SystemClock.uptimeMillis());
            if (com.baidu.location.e.d.lP().d() && com.baidu.location.e.d.lP().e()) {
                bDLocation = com.baidu.location.e.d.lP().a(com.baidu.location.f.c.mh().md(), com.baidu.location.f.k.mq().mn(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
                if (bDLocation != null && bDLocation.getLocType() == 66) {
                    com.baidu.location.a.a.ls().a(bDLocation);
                }
            } else {
                bDLocation = null;
            }
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                if (this.j || this.Gj == null) {
                    BDLocation Z = com.baidu.location.e.a.lO().Z(false);
                    com.baidu.location.a.a.ls().a(Z);
                    boolean z = true;
                    if (com.baidu.location.h.i.f.equals("all") && Z.getAddrStr() == null) {
                        z = false;
                    }
                    if (com.baidu.location.h.i.g && Z.getLocationDescribe() == null) {
                        z = false;
                    }
                    if (com.baidu.location.h.i.h && Z.getPoiList() == null) {
                        z = false;
                    }
                    if (!z) {
                        Z.setLocType(67);
                    }
                    bDLocation = Z;
                } else {
                    com.baidu.location.a.a.ls().a(this.Gj);
                }
            }
            com.baidu.location.c.f.lL().lM().m(SystemClock.uptimeMillis());
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                this.Gj = null;
                com.baidu.location.c.f.lL().lM().a("off");
                if (this.Gm != null) {
                    com.baidu.location.c.f.lL().lM().b(this.Gm.h());
                }
                com.baidu.location.c.f.lL().c();
            } else {
                this.Gj = bDLocation;
                com.baidu.location.c.f.lL().lM().a("ofs");
                if (this.Gm != null) {
                    com.baidu.location.c.f.lL().lM().b(this.Gm.h());
                }
                com.baidu.location.c.f.lL().c();
            }
            this.Gk = null;
            k();
        }
    }

    @Override // com.baidu.location.a.d
    public void a(Message message) {
        boolean z;
        if (this.Gu != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.Gu);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            this.Gq = bDLocation.getAddress();
            this.z = bDLocation.getLongitude();
            this.Gs = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.x = bDLocation.getLocationDescribe();
            this.z = bDLocation.getLongitude();
            this.Gs = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.Gr = bDLocation.getPoiList();
            this.z = bDLocation.getLongitude();
            this.Gs = bDLocation.getLatitude();
        }
        if (com.baidu.location.f.f.mk().i()) {
            BDLocation bDLocation3 = new BDLocation(com.baidu.location.f.f.mk().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.Gs, this.z, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.Gq != null) {
                        bDLocation3.setAddr(this.Gq);
                    }
                    if (this.x != null) {
                        bDLocation3.setLocationDescribe(this.x);
                    }
                    if (this.Gr != null) {
                        bDLocation3.setPoiList(this.Gr);
                    }
                }
            }
            com.baidu.location.a.a.ls().a(bDLocation3);
            k();
        } else if (bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("sky")) {
            bDLocation.setNetworkLocationType("wf");
            com.baidu.location.a.a.ls().a(bDLocation);
            this.Gp = System.currentTimeMillis();
            this.Gj = bDLocation;
        } else if (this.G) {
            float[] fArr2 = new float[2];
            if (this.Gj != null) {
                Location.distanceBetween(this.Gj.getLatitude(), this.Gj.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
            }
            if (fArr2[0] > 10.0f) {
                this.Gj = bDLocation;
                if (!this.H) {
                    this.H = false;
                    com.baidu.location.a.a.ls().a(bDLocation);
                }
            }
            k();
        } else {
            com.baidu.location.c.f.lL().lM().c(SystemClock.uptimeMillis());
            this.Gk = null;
            if (bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && this.Gj != null && this.Gj.getLocType() == 161 && "wf".equals(this.Gj.getNetworkLocationType()) && System.currentTimeMillis() - this.Gp < 30000) {
                z = true;
                this.Gk = bDLocation;
            } else {
                z = false;
            }
            if (z) {
                com.baidu.location.a.a.ls().a(this.Gj);
            } else {
                com.baidu.location.a.a.ls().a(bDLocation);
                this.Gp = System.currentTimeMillis();
                com.baidu.location.c.f.lL().lM().m(SystemClock.uptimeMillis());
                if (bDLocation.getLocType() == 161) {
                    com.baidu.location.c.f.lL().lM().a("ons");
                    if (this.Gm != null) {
                        com.baidu.location.c.f.lL().lM().b(this.Gm.h());
                    }
                } else {
                    com.baidu.location.c.f.lL().lM().a("onf");
                    if (this.Gm != null) {
                        com.baidu.location.c.f.lL().lM().b(this.Gm.h());
                    }
                    com.baidu.location.c.f.lL().c();
                }
            }
            if (!com.baidu.location.h.i.d(bDLocation)) {
                this.Gj = null;
            } else if (!z) {
                this.Gj = bDLocation;
            }
            int o = com.baidu.location.h.i.o(c, "ssid\":\"", "\"");
            if (o == Integer.MIN_VALUE || this.Gl == null) {
                this.k = null;
            } else {
                this.k = this.Gl.c(o);
            }
            if (com.baidu.location.e.d.lP().d() && bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && b(this.Gm)) {
                com.baidu.location.e.d.lP().a(this.Gm, null, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.Go = this.Gm;
            }
            if (com.baidu.location.e.d.lP().d() && bDLocation.getLocType() == 161 && "wf".equals(bDLocation.getNetworkLocationType())) {
                com.baidu.location.e.d.lP().a(null, this.Gl, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.Gn = this.Gl;
            }
            if (this.Gm != null) {
                com.baidu.location.e.a.lO().a(c, this.Gm, this.Gl, bDLocation2);
            }
            if (com.baidu.location.f.k.mq().g()) {
                com.baidu.location.e.d.lP().i();
                com.baidu.location.e.d.lP().m();
            }
            k();
        }
    }

    public void a(boolean z) {
        BDLocation bDLocation = null;
        if (com.baidu.location.e.d.lP().d() && com.baidu.location.e.d.lP().g()) {
            bDLocation = com.baidu.location.e.d.lP().a(com.baidu.location.f.c.mh().md(), com.baidu.location.f.k.mq().mn(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
            if ((bDLocation == null || bDLocation.getLocType() == 67) && z) {
                bDLocation = com.baidu.location.e.a.lO().Z(false);
            }
        } else if (z) {
            bDLocation = com.baidu.location.e.a.lO().Z(false);
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
            com.baidu.location.a.a.ls().a(bDLocation);
        }
    }

    public Address b(BDLocation bDLocation) {
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.Gs, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] >= 100.0f) {
                this.x = null;
                this.Gr = null;
                this.B = true;
                i(null);
            } else if (this.Gq != null) {
                return this.Gq;
            }
        }
        return null;
    }

    public void b(Message message) {
        if (this.Gv) {
            c(message);
        }
    }

    public void c() {
        this.r = true;
        this.s = false;
        this.Gv = true;
    }

    public void d() {
        this.s = false;
        this.t = false;
        this.G = false;
        this.H = true;
        i();
        this.Gv = false;
    }

    public String e() {
        return this.x;
    }

    public List<Poi> f() {
        return this.Gr;
    }

    public boolean g() {
        return this.j;
    }

    public void h() {
        if (!this.t) {
            com.baidu.location.c.a.lG().d();
            return;
        }
        j(null);
        this.t = false;
    }

    public void i() {
        this.Gj = null;
    }
}
