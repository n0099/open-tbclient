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
import com.sina.weibo.sdk.statistic.StatisticConfig;
import java.util.List;
/* loaded from: classes2.dex */
public class e extends d {
    private static e VQ = null;
    public static boolean h = false;
    public d.b VR;
    private double Wa;
    private double z;
    final int e = 1000;
    private boolean j = true;
    private String k = null;
    private BDLocation VS = null;
    private BDLocation VT = null;
    private com.baidu.location.f.i VU = null;
    private com.baidu.location.f.a VV = null;
    private com.baidu.location.f.i VW = null;
    private com.baidu.location.f.a VX = null;
    private boolean r = true;
    private volatile boolean s = false;
    private boolean t = false;
    private long u = 0;
    private long v = 0;
    private Address VY = null;
    private String x = null;
    private List<Poi> VZ = null;
    private boolean B = false;
    private long C = 0;
    private long D = 0;
    private a Wb = null;
    private boolean F = false;
    private boolean G = false;
    private boolean H = true;
    public final Handler g = new d.a();
    private boolean I = false;
    private b Wc = null;
    private boolean K = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
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
    /* loaded from: classes2.dex */
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
        this.VR = null;
        this.VR = new d.b();
    }

    private boolean a(com.baidu.location.f.a aVar) {
        this.VN = com.baidu.location.f.c.qV().qR();
        if (this.VN == aVar) {
            return false;
        }
        return this.VN == null || aVar == null || !aVar.a(this.VN);
    }

    private boolean a(com.baidu.location.f.i iVar) {
        this.VM = com.baidu.location.f.k.re().rc();
        if (iVar == this.VM) {
            return false;
        }
        return this.VM == null || iVar == null || !iVar.c(this.VM);
    }

    private boolean b(com.baidu.location.f.a aVar) {
        if (aVar == null) {
            return false;
        }
        return this.VX == null || !aVar.a(this.VX);
    }

    private void c(Message message) {
        boolean z = message.getData().getBoolean("isWaitingLocTag", false);
        if (z) {
            h = true;
        }
        if (z) {
        }
        int g = com.baidu.location.a.a.qg().g(message);
        f.qj().d();
        switch (g) {
            case 1:
                d(message);
                return;
            case 2:
                i(message);
                return;
            case 3:
                if (com.baidu.location.f.f.qY().i()) {
                    e(message);
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(g)));
        }
    }

    private void d(Message message) {
        if (com.baidu.location.f.f.qY().i()) {
            e(message);
            f.qj().c();
            return;
        }
        i(message);
        f.qj().b();
    }

    private void e(Message message) {
        BDLocation bDLocation = new BDLocation(com.baidu.location.f.f.qY().f());
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.Wa, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.VY != null) {
                    bDLocation.setAddr(this.VY);
                }
                if (this.x != null) {
                    bDLocation.setLocationDescribe(this.x);
                }
                if (this.VZ != null) {
                    bDLocation.setPoiList(this.VZ);
                }
            } else {
                this.B = true;
                i(null);
            }
        }
        this.VS = bDLocation;
        this.VT = null;
        com.baidu.location.a.a.qg().a(bDLocation);
    }

    private void i(Message message) {
        if (this.r) {
            this.D = SystemClock.uptimeMillis();
            j(message);
        } else if (this.s) {
        } else {
            this.D = SystemClock.uptimeMillis();
            if (!com.baidu.location.f.k.re().e()) {
                j(message);
                return;
            }
            this.t = true;
            if (this.Wc == null) {
                this.Wc = new b();
            }
            if (this.K && this.Wc != null) {
                this.g.removeCallbacks(this.Wc);
            }
            this.g.postDelayed(this.Wc, 3500L);
            this.K = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Message message) {
        if (this.s) {
            return;
        }
        if (System.currentTimeMillis() - this.u < 1000 && this.VS != null) {
            com.baidu.location.a.a.qg().a(this.VS);
            k();
            return;
        }
        if (this.D > 0) {
            com.baidu.location.c.f.qz().qA().a(this.D);
        } else {
            com.baidu.location.c.f.qz().qA().a(SystemClock.uptimeMillis());
        }
        this.s = true;
        this.j = a(this.VV);
        if (!a(this.VU) && !this.j && this.VS != null && !this.B) {
            if (this.VT != null && System.currentTimeMillis() - this.v > StatisticConfig.MIN_UPLOAD_INTERVAL) {
                this.VS = this.VT;
                this.VT = null;
            }
            if (f.qj().f()) {
                this.VS.setDirection(f.qj().h());
            }
            com.baidu.location.a.a.qg().a(this.VS);
            k();
            return;
        }
        this.u = System.currentTimeMillis();
        String a2 = a((String) null);
        if (a2 == null) {
            if (this.VS != null) {
                com.baidu.location.a.a.qg().a(this.VS);
                k();
                return;
            }
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLocType(62);
            com.baidu.location.a.a.qg().a(bDLocation);
            k();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.C > 60000) {
                this.C = currentTimeMillis;
                com.baidu.location.c.f.qz().a("TypeCriteriaException");
                return;
            }
            return;
        }
        if (this.k != null) {
            a2 = a2 + this.k;
            this.k = null;
        }
        com.baidu.location.c.f.qz().qA().b(SystemClock.uptimeMillis());
        this.VR.a(a2);
        this.VV = this.VN;
        this.VU = this.VM;
        if (j()) {
            this.VV = this.VN;
            this.VU = this.VM;
        }
        if (com.baidu.location.e.d.qD().h()) {
            if (this.Wb == null) {
                this.Wb = new a();
            }
            this.g.postDelayed(this.Wb, com.baidu.location.e.d.qD().a(com.baidu.location.f.c.a(com.baidu.location.f.c.qV().e())));
            this.F = true;
        }
        if (this.r) {
            this.r = false;
            if (com.baidu.location.f.k.re().g() && message != null && com.baidu.location.a.a.qg().h(message) < 1000 && com.baidu.location.e.d.qD().d()) {
                com.baidu.location.e.d.qD().i();
            }
            com.baidu.location.c.a.qu().b();
        }
    }

    private boolean j() {
        BDLocation bDLocation = null;
        double random = Math.random();
        long uptimeMillis = SystemClock.uptimeMillis();
        com.baidu.location.f.a qR = com.baidu.location.f.c.qV().qR();
        com.baidu.location.f.i rb = com.baidu.location.f.k.re().rb();
        boolean z = qR != null && qR.e() && (rb == null || rb.a() == 0);
        if (com.baidu.location.e.d.qD().d() && com.baidu.location.e.d.qD().f() && (z || (0.0d < random && random < com.baidu.location.e.d.qD().o()))) {
            bDLocation = com.baidu.location.e.d.qD().a(com.baidu.location.f.c.qV().qR(), com.baidu.location.f.k.re().rb(), null, d.b.IS_MIX_MODE, d.a.NEED_TO_LOG);
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
                if (this.VV != null) {
                    gVar.b(this.VV.h());
                    gVar.b("&offtag=1");
                }
                com.baidu.location.c.f.qz().a(gVar);
                this.G = true;
                com.baidu.location.a.a.qg().a(bDLocation2);
                this.VS = bDLocation2;
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
        if (this.VS != null) {
            j.qq().c();
        }
    }

    public static synchronized e qi() {
        e eVar;
        synchronized (e.class) {
            if (VQ == null) {
                VQ = new e();
            }
            eVar = VQ;
        }
        return eVar;
    }

    @Override // com.baidu.location.a.d
    public void a() {
        BDLocation bDLocation;
        if (this.Wb != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.Wb);
        }
        if (com.baidu.location.f.f.qY().i()) {
            BDLocation bDLocation2 = new BDLocation(com.baidu.location.f.f.qY().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.Wa, this.z, bDLocation2.getLatitude(), bDLocation2.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.VY != null) {
                        bDLocation2.setAddr(this.VY);
                    }
                    if (this.x != null) {
                        bDLocation2.setLocationDescribe(this.x);
                    }
                    if (this.VZ != null) {
                        bDLocation2.setPoiList(this.VZ);
                    }
                }
            }
            com.baidu.location.a.a.qg().a(bDLocation2);
            k();
        } else if (this.G) {
            k();
        } else {
            com.baidu.location.c.f.qz().qA().c(SystemClock.uptimeMillis());
            if (com.baidu.location.e.d.qD().d() && com.baidu.location.e.d.qD().e()) {
                bDLocation = com.baidu.location.e.d.qD().a(com.baidu.location.f.c.qV().qR(), com.baidu.location.f.k.re().rb(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
                if (bDLocation != null && bDLocation.getLocType() == 66) {
                    com.baidu.location.a.a.qg().a(bDLocation);
                }
            } else {
                bDLocation = null;
            }
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                if (this.j || this.VS == null) {
                    BDLocation af = com.baidu.location.e.a.qC().af(false);
                    com.baidu.location.a.a.qg().a(af);
                    boolean z = true;
                    if (com.baidu.location.h.i.f.equals("all") && af.getAddrStr() == null) {
                        z = false;
                    }
                    if (com.baidu.location.h.i.g && af.getLocationDescribe() == null) {
                        z = false;
                    }
                    if (com.baidu.location.h.i.h && af.getPoiList() == null) {
                        z = false;
                    }
                    if (!z) {
                        af.setLocType(67);
                    }
                    bDLocation = af;
                } else {
                    com.baidu.location.a.a.qg().a(this.VS);
                }
            }
            com.baidu.location.c.f.qz().qA().d(SystemClock.uptimeMillis());
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                this.VS = null;
                com.baidu.location.c.f.qz().qA().a("off");
                if (this.VV != null) {
                    com.baidu.location.c.f.qz().qA().b(this.VV.h());
                }
                com.baidu.location.c.f.qz().c();
            } else {
                this.VS = bDLocation;
                com.baidu.location.c.f.qz().qA().a("ofs");
                if (this.VV != null) {
                    com.baidu.location.c.f.qz().qA().b(this.VV.h());
                }
                com.baidu.location.c.f.qz().c();
            }
            this.VT = null;
            k();
        }
    }

    @Override // com.baidu.location.a.d
    public void a(Message message) {
        boolean z;
        if (this.Wb != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.Wb);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            this.VY = bDLocation.getAddress();
            this.z = bDLocation.getLongitude();
            this.Wa = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.x = bDLocation.getLocationDescribe();
            this.z = bDLocation.getLongitude();
            this.Wa = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.VZ = bDLocation.getPoiList();
            this.z = bDLocation.getLongitude();
            this.Wa = bDLocation.getLatitude();
        }
        if (com.baidu.location.f.f.qY().i()) {
            BDLocation bDLocation3 = new BDLocation(com.baidu.location.f.f.qY().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.Wa, this.z, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.VY != null) {
                        bDLocation3.setAddr(this.VY);
                    }
                    if (this.x != null) {
                        bDLocation3.setLocationDescribe(this.x);
                    }
                    if (this.VZ != null) {
                        bDLocation3.setPoiList(this.VZ);
                    }
                }
            }
            com.baidu.location.a.a.qg().a(bDLocation3);
            k();
        } else if (bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("sky")) {
            bDLocation.setNetworkLocationType("wf");
            com.baidu.location.a.a.qg().a(bDLocation);
            this.v = System.currentTimeMillis();
            this.VS = bDLocation;
        } else if (this.G) {
            float[] fArr2 = new float[2];
            if (this.VS != null) {
                Location.distanceBetween(this.VS.getLatitude(), this.VS.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
            }
            if (fArr2[0] > 10.0f) {
                this.VS = bDLocation;
                if (!this.H) {
                    this.H = false;
                    com.baidu.location.a.a.qg().a(bDLocation);
                }
            }
            k();
        } else {
            com.baidu.location.c.f.qz().qA().c(SystemClock.uptimeMillis());
            this.VT = null;
            if (bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && this.VS != null && this.VS.getLocType() == 161 && "wf".equals(this.VS.getNetworkLocationType()) && System.currentTimeMillis() - this.v < StatisticConfig.MIN_UPLOAD_INTERVAL) {
                z = true;
                this.VT = bDLocation;
            } else {
                z = false;
            }
            if (z) {
                com.baidu.location.a.a.qg().a(this.VS);
            } else {
                com.baidu.location.a.a.qg().a(bDLocation);
                this.v = System.currentTimeMillis();
                com.baidu.location.c.f.qz().qA().d(SystemClock.uptimeMillis());
                if (bDLocation.getLocType() == 161) {
                    com.baidu.location.c.f.qz().qA().a("ons");
                    if (this.VV != null) {
                        com.baidu.location.c.f.qz().qA().b(this.VV.h());
                    }
                } else {
                    com.baidu.location.c.f.qz().qA().a("onf");
                    if (this.VV != null) {
                        com.baidu.location.c.f.qz().qA().b(this.VV.h());
                    }
                    com.baidu.location.c.f.qz().c();
                }
            }
            if (!com.baidu.location.h.i.d(bDLocation)) {
                this.VS = null;
            } else if (!z) {
                this.VS = bDLocation;
            }
            int j = com.baidu.location.h.i.j(c, "ssid\":\"", "\"");
            if (j == Integer.MIN_VALUE || this.VU == null) {
                this.k = null;
            } else {
                this.k = this.VU.c(j);
            }
            if (com.baidu.location.e.d.qD().d() && bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && b(this.VV)) {
                com.baidu.location.e.d.qD().a(this.VV, null, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.VX = this.VV;
            }
            if (com.baidu.location.e.d.qD().d() && bDLocation.getLocType() == 161 && "wf".equals(bDLocation.getNetworkLocationType())) {
                com.baidu.location.e.d.qD().a(null, this.VU, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.VW = this.VU;
            }
            if (this.VV != null) {
                com.baidu.location.e.a.qC().a(c, this.VV, this.VU, bDLocation2);
            }
            if (com.baidu.location.f.k.re().g()) {
                com.baidu.location.e.d.qD().i();
                com.baidu.location.e.d.qD().m();
            }
            k();
        }
    }

    public void a(boolean z) {
        BDLocation bDLocation = null;
        if (com.baidu.location.e.d.qD().d() && com.baidu.location.e.d.qD().g()) {
            bDLocation = com.baidu.location.e.d.qD().a(com.baidu.location.f.c.qV().qR(), com.baidu.location.f.k.re().rb(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
            if ((bDLocation == null || bDLocation.getLocType() == 67) && z) {
                bDLocation = com.baidu.location.e.a.qC().af(false);
            }
        } else if (z) {
            bDLocation = com.baidu.location.e.a.qC().af(false);
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
            com.baidu.location.a.a.qg().a(bDLocation);
        }
    }

    public Address b(BDLocation bDLocation) {
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.Wa, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] >= 100.0f) {
                this.x = null;
                this.VZ = null;
                this.B = true;
                i(null);
            } else if (this.VY != null) {
                return this.VY;
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
        return this.VZ;
    }

    public boolean g() {
        return this.j;
    }

    public void h() {
        if (!this.t) {
            com.baidu.location.c.a.qu().d();
            return;
        }
        j(null);
        this.t = false;
    }

    public void i() {
        this.VS = null;
    }
}
