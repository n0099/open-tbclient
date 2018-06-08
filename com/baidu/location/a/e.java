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
/* loaded from: classes.dex */
public class e extends d {
    private static e VO = null;
    public static boolean h = false;
    public d.b VP;
    private double VY;
    private double z;
    final int e = 1000;
    private boolean j = true;
    private String k = null;
    private BDLocation VQ = null;
    private BDLocation VR = null;
    private com.baidu.location.f.i VS = null;
    private com.baidu.location.f.a VT = null;
    private com.baidu.location.f.i VU = null;
    private com.baidu.location.f.a VV = null;
    private boolean r = true;
    private volatile boolean s = false;
    private boolean t = false;
    private long u = 0;
    private long v = 0;
    private Address VW = null;
    private String x = null;
    private List<Poi> VX = null;
    private boolean B = false;
    private long C = 0;
    private long D = 0;
    private a VZ = null;
    private boolean F = false;
    private boolean G = false;
    private boolean H = true;
    public final Handler g = new d.a();
    private boolean I = false;
    private b Wa = null;
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
        this.VP = null;
        this.VP = new d.b();
    }

    private boolean a(com.baidu.location.f.a aVar) {
        this.VL = com.baidu.location.f.c.qV().qR();
        if (this.VL == aVar) {
            return false;
        }
        return this.VL == null || aVar == null || !aVar.a(this.VL);
    }

    private boolean a(com.baidu.location.f.i iVar) {
        this.VK = com.baidu.location.f.k.re().rc();
        if (iVar == this.VK) {
            return false;
        }
        return this.VK == null || iVar == null || !iVar.c(this.VK);
    }

    private boolean b(com.baidu.location.f.a aVar) {
        if (aVar == null) {
            return false;
        }
        return this.VV == null || !aVar.a(this.VV);
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
            Location.distanceBetween(this.VY, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.VW != null) {
                    bDLocation.setAddr(this.VW);
                }
                if (this.x != null) {
                    bDLocation.setLocationDescribe(this.x);
                }
                if (this.VX != null) {
                    bDLocation.setPoiList(this.VX);
                }
            } else {
                this.B = true;
                i(null);
            }
        }
        this.VQ = bDLocation;
        this.VR = null;
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
            if (this.Wa == null) {
                this.Wa = new b();
            }
            if (this.K && this.Wa != null) {
                this.g.removeCallbacks(this.Wa);
            }
            this.g.postDelayed(this.Wa, 3500L);
            this.K = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Message message) {
        if (this.s) {
            return;
        }
        if (System.currentTimeMillis() - this.u < 1000 && this.VQ != null) {
            com.baidu.location.a.a.qg().a(this.VQ);
            k();
            return;
        }
        if (this.D > 0) {
            com.baidu.location.c.f.qz().qA().a(this.D);
        } else {
            com.baidu.location.c.f.qz().qA().a(SystemClock.uptimeMillis());
        }
        this.s = true;
        this.j = a(this.VT);
        if (!a(this.VS) && !this.j && this.VQ != null && !this.B) {
            if (this.VR != null && System.currentTimeMillis() - this.v > StatisticConfig.MIN_UPLOAD_INTERVAL) {
                this.VQ = this.VR;
                this.VR = null;
            }
            if (f.qj().f()) {
                this.VQ.setDirection(f.qj().h());
            }
            com.baidu.location.a.a.qg().a(this.VQ);
            k();
            return;
        }
        this.u = System.currentTimeMillis();
        String a2 = a((String) null);
        if (a2 == null) {
            if (this.VQ != null) {
                com.baidu.location.a.a.qg().a(this.VQ);
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
        this.VP.a(a2);
        this.VT = this.VL;
        this.VS = this.VK;
        if (j()) {
            this.VT = this.VL;
            this.VS = this.VK;
        }
        if (com.baidu.location.e.d.qD().h()) {
            if (this.VZ == null) {
                this.VZ = new a();
            }
            this.g.postDelayed(this.VZ, com.baidu.location.e.d.qD().a(com.baidu.location.f.c.a(com.baidu.location.f.c.qV().e())));
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
                if (this.VT != null) {
                    gVar.b(this.VT.h());
                    gVar.b("&offtag=1");
                }
                com.baidu.location.c.f.qz().a(gVar);
                this.G = true;
                com.baidu.location.a.a.qg().a(bDLocation2);
                this.VQ = bDLocation2;
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
        if (this.VQ != null) {
            j.qq().c();
        }
    }

    public static synchronized e qi() {
        e eVar;
        synchronized (e.class) {
            if (VO == null) {
                VO = new e();
            }
            eVar = VO;
        }
        return eVar;
    }

    @Override // com.baidu.location.a.d
    public void a() {
        BDLocation bDLocation;
        if (this.VZ != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.VZ);
        }
        if (com.baidu.location.f.f.qY().i()) {
            BDLocation bDLocation2 = new BDLocation(com.baidu.location.f.f.qY().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.VY, this.z, bDLocation2.getLatitude(), bDLocation2.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.VW != null) {
                        bDLocation2.setAddr(this.VW);
                    }
                    if (this.x != null) {
                        bDLocation2.setLocationDescribe(this.x);
                    }
                    if (this.VX != null) {
                        bDLocation2.setPoiList(this.VX);
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
                if (this.j || this.VQ == null) {
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
                    com.baidu.location.a.a.qg().a(this.VQ);
                }
            }
            com.baidu.location.c.f.qz().qA().d(SystemClock.uptimeMillis());
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                this.VQ = null;
                com.baidu.location.c.f.qz().qA().a("off");
                if (this.VT != null) {
                    com.baidu.location.c.f.qz().qA().b(this.VT.h());
                }
                com.baidu.location.c.f.qz().c();
            } else {
                this.VQ = bDLocation;
                com.baidu.location.c.f.qz().qA().a("ofs");
                if (this.VT != null) {
                    com.baidu.location.c.f.qz().qA().b(this.VT.h());
                }
                com.baidu.location.c.f.qz().c();
            }
            this.VR = null;
            k();
        }
    }

    @Override // com.baidu.location.a.d
    public void a(Message message) {
        boolean z;
        if (this.VZ != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.VZ);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            this.VW = bDLocation.getAddress();
            this.z = bDLocation.getLongitude();
            this.VY = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.x = bDLocation.getLocationDescribe();
            this.z = bDLocation.getLongitude();
            this.VY = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.VX = bDLocation.getPoiList();
            this.z = bDLocation.getLongitude();
            this.VY = bDLocation.getLatitude();
        }
        if (com.baidu.location.f.f.qY().i()) {
            BDLocation bDLocation3 = new BDLocation(com.baidu.location.f.f.qY().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.VY, this.z, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.VW != null) {
                        bDLocation3.setAddr(this.VW);
                    }
                    if (this.x != null) {
                        bDLocation3.setLocationDescribe(this.x);
                    }
                    if (this.VX != null) {
                        bDLocation3.setPoiList(this.VX);
                    }
                }
            }
            com.baidu.location.a.a.qg().a(bDLocation3);
            k();
        } else if (bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("sky")) {
            bDLocation.setNetworkLocationType("wf");
            com.baidu.location.a.a.qg().a(bDLocation);
            this.v = System.currentTimeMillis();
            this.VQ = bDLocation;
        } else if (this.G) {
            float[] fArr2 = new float[2];
            if (this.VQ != null) {
                Location.distanceBetween(this.VQ.getLatitude(), this.VQ.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
            }
            if (fArr2[0] > 10.0f) {
                this.VQ = bDLocation;
                if (!this.H) {
                    this.H = false;
                    com.baidu.location.a.a.qg().a(bDLocation);
                }
            }
            k();
        } else {
            com.baidu.location.c.f.qz().qA().c(SystemClock.uptimeMillis());
            this.VR = null;
            if (bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && this.VQ != null && this.VQ.getLocType() == 161 && "wf".equals(this.VQ.getNetworkLocationType()) && System.currentTimeMillis() - this.v < StatisticConfig.MIN_UPLOAD_INTERVAL) {
                z = true;
                this.VR = bDLocation;
            } else {
                z = false;
            }
            if (z) {
                com.baidu.location.a.a.qg().a(this.VQ);
            } else {
                com.baidu.location.a.a.qg().a(bDLocation);
                this.v = System.currentTimeMillis();
                com.baidu.location.c.f.qz().qA().d(SystemClock.uptimeMillis());
                if (bDLocation.getLocType() == 161) {
                    com.baidu.location.c.f.qz().qA().a("ons");
                    if (this.VT != null) {
                        com.baidu.location.c.f.qz().qA().b(this.VT.h());
                    }
                } else {
                    com.baidu.location.c.f.qz().qA().a("onf");
                    if (this.VT != null) {
                        com.baidu.location.c.f.qz().qA().b(this.VT.h());
                    }
                    com.baidu.location.c.f.qz().c();
                }
            }
            if (!com.baidu.location.h.i.d(bDLocation)) {
                this.VQ = null;
            } else if (!z) {
                this.VQ = bDLocation;
            }
            int j = com.baidu.location.h.i.j(c, "ssid\":\"", "\"");
            if (j == Integer.MIN_VALUE || this.VS == null) {
                this.k = null;
            } else {
                this.k = this.VS.c(j);
            }
            if (com.baidu.location.e.d.qD().d() && bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && b(this.VT)) {
                com.baidu.location.e.d.qD().a(this.VT, null, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.VV = this.VT;
            }
            if (com.baidu.location.e.d.qD().d() && bDLocation.getLocType() == 161 && "wf".equals(bDLocation.getNetworkLocationType())) {
                com.baidu.location.e.d.qD().a(null, this.VS, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.VU = this.VS;
            }
            if (this.VT != null) {
                com.baidu.location.e.a.qC().a(c, this.VT, this.VS, bDLocation2);
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
            Location.distanceBetween(this.VY, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] >= 100.0f) {
                this.x = null;
                this.VX = null;
                this.B = true;
                i(null);
            } else if (this.VW != null) {
                return this.VW;
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
        return this.VX;
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
        this.VQ = null;
    }
}
