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
    private static e HC = null;
    public static boolean h = false;
    public d.b HD;
    private double HN;
    private double z;
    final int e = 1000;
    private boolean j = true;
    private String k = null;
    private BDLocation HE = null;
    private BDLocation HF = null;
    private com.baidu.location.f.i HG = null;
    private com.baidu.location.f.a HH = null;
    private com.baidu.location.f.i HI = null;
    private com.baidu.location.f.a HJ = null;
    private boolean r = true;
    private volatile boolean s = false;
    private boolean t = false;
    private long u = 0;
    private long HK = 0;
    private Address HL = null;
    private String x = null;
    private List<Poi> HM = null;
    private boolean B = false;
    private long C = 0;
    private long HO = 0;
    private a HP = null;
    private boolean F = false;
    private boolean G = false;
    private boolean H = true;
    public final Handler g = new d.a();
    private boolean HQ = false;
    private b HR = null;
    private boolean HS = false;

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
            if (e.this.HS) {
                e.this.HS = false;
            }
            if (e.this.t) {
                e.this.t = false;
                e.this.j(null);
            }
        }
    }

    private e() {
        this.HD = null;
        this.HD = new d.b();
    }

    private boolean a(com.baidu.location.f.a aVar) {
        this.Hz = com.baidu.location.f.c.mX().mT();
        if (this.Hz == aVar) {
            return false;
        }
        return this.Hz == null || aVar == null || !aVar.a(this.Hz);
    }

    private boolean a(com.baidu.location.f.i iVar) {
        this.Hy = com.baidu.location.f.k.ng().ne();
        if (iVar == this.Hy) {
            return false;
        }
        return this.Hy == null || iVar == null || !iVar.c(this.Hy);
    }

    private boolean b(com.baidu.location.f.a aVar) {
        if (aVar == null) {
            return false;
        }
        return this.HJ == null || !aVar.a(this.HJ);
    }

    private void c(Message message) {
        boolean z = message.getData().getBoolean("isWaitingLocTag", false);
        if (z) {
            h = true;
        }
        if (z) {
        }
        int e = com.baidu.location.a.a.mi().e(message);
        f.ml().d();
        switch (e) {
            case 1:
                g(message);
                return;
            case 2:
                i(message);
                return;
            case 3:
                if (com.baidu.location.f.f.na().i()) {
                    h(message);
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(e)));
        }
    }

    private void g(Message message) {
        if (com.baidu.location.f.f.na().i()) {
            h(message);
            f.ml().c();
            return;
        }
        i(message);
        f.ml().b();
    }

    private void h(Message message) {
        BDLocation bDLocation = new BDLocation(com.baidu.location.f.f.na().f());
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.HN, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.HL != null) {
                    bDLocation.setAddr(this.HL);
                }
                if (this.x != null) {
                    bDLocation.setLocationDescribe(this.x);
                }
                if (this.HM != null) {
                    bDLocation.setPoiList(this.HM);
                }
            } else {
                this.B = true;
                i(null);
            }
        }
        this.HE = bDLocation;
        this.HF = null;
        com.baidu.location.a.a.mi().a(bDLocation);
    }

    private void i(Message message) {
        if (this.r) {
            this.HO = SystemClock.uptimeMillis();
            j(message);
        } else if (this.s) {
        } else {
            this.HO = SystemClock.uptimeMillis();
            if (!com.baidu.location.f.k.ng().e()) {
                j(message);
                return;
            }
            this.t = true;
            if (this.HR == null) {
                this.HR = new b();
            }
            if (this.HS && this.HR != null) {
                this.g.removeCallbacks(this.HR);
            }
            this.g.postDelayed(this.HR, 3500L);
            this.HS = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Message message) {
        if (this.s) {
            return;
        }
        if (System.currentTimeMillis() - this.u < 1000 && this.HE != null) {
            com.baidu.location.a.a.mi().a(this.HE);
            k();
            return;
        }
        if (this.HO > 0) {
            com.baidu.location.c.f.mB().mC().a(this.HO);
        } else {
            com.baidu.location.c.f.mB().mC().a(SystemClock.uptimeMillis());
        }
        this.s = true;
        this.j = a(this.HH);
        if (!a(this.HG) && !this.j && this.HE != null && !this.B) {
            if (this.HF != null && System.currentTimeMillis() - this.HK > 30000) {
                this.HE = this.HF;
                this.HF = null;
            }
            if (f.ml().f()) {
                this.HE.setDirection(f.ml().h());
            }
            com.baidu.location.a.a.mi().a(this.HE);
            k();
            return;
        }
        this.u = System.currentTimeMillis();
        String a2 = a((String) null);
        if (a2 == null) {
            if (this.HE != null) {
                com.baidu.location.a.a.mi().a(this.HE);
                k();
                return;
            }
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLocType(62);
            com.baidu.location.a.a.mi().a(bDLocation);
            k();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.C > TbConfig.USE_TIME_INTERVAL) {
                this.C = currentTimeMillis;
                com.baidu.location.c.f.mB().a("TypeCriteriaException");
                return;
            }
            return;
        }
        if (this.k != null) {
            a2 = a2 + this.k;
            this.k = null;
        }
        com.baidu.location.c.f.mB().mC().b(SystemClock.uptimeMillis());
        this.HD.a(a2);
        this.HH = this.Hz;
        this.HG = this.Hy;
        if (j()) {
            this.HH = this.Hz;
            this.HG = this.Hy;
        }
        if (com.baidu.location.e.d.mF().h()) {
            if (this.HP == null) {
                this.HP = new a();
            }
            this.g.postDelayed(this.HP, com.baidu.location.e.d.mF().a(com.baidu.location.f.c.a(com.baidu.location.f.c.mX().e())));
            this.F = true;
        }
        if (this.r) {
            this.r = false;
            if (com.baidu.location.f.k.ng().g() && message != null && com.baidu.location.a.a.mi().f(message) < 1000 && com.baidu.location.e.d.mF().d()) {
                com.baidu.location.e.d.mF().i();
            }
            com.baidu.location.c.a.mw().b();
        }
    }

    private boolean j() {
        BDLocation bDLocation = null;
        double random = Math.random();
        long uptimeMillis = SystemClock.uptimeMillis();
        com.baidu.location.f.a mT = com.baidu.location.f.c.mX().mT();
        com.baidu.location.f.i nd = com.baidu.location.f.k.ng().nd();
        boolean z = mT != null && mT.e() && (nd == null || nd.a() == 0);
        if (com.baidu.location.e.d.mF().d() && com.baidu.location.e.d.mF().f() && (z || (0.0d < random && random < com.baidu.location.e.d.mF().mK()))) {
            bDLocation = com.baidu.location.e.d.mF().a(com.baidu.location.f.c.mX().mT(), com.baidu.location.f.k.ng().nd(), null, d.b.IS_MIX_MODE, d.a.NEED_TO_LOG);
        }
        if (bDLocation != null && bDLocation.getLocType() == 66 && this.s) {
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            bDLocation2.setLocType(BDLocation.TypeNetWorkLocation);
            if (this.s) {
                com.baidu.location.c.g gVar = new com.baidu.location.c.g();
                gVar.a(this.HO);
                gVar.b(uptimeMillis);
                gVar.c(uptimeMillis);
                gVar.l(SystemClock.uptimeMillis());
                gVar.a("ofs");
                if (this.HH != null) {
                    gVar.b(this.HH.h());
                    gVar.b("&offtag=1");
                }
                com.baidu.location.c.f.mB().a(gVar);
                this.G = true;
                com.baidu.location.a.a.mi().a(bDLocation2);
                this.HE = bDLocation2;
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
        if (this.HE != null) {
            j.ms().c();
        }
    }

    public static synchronized e mk() {
        e eVar;
        synchronized (e.class) {
            if (HC == null) {
                HC = new e();
            }
            eVar = HC;
        }
        return eVar;
    }

    @Override // com.baidu.location.a.d
    public void a() {
        BDLocation bDLocation;
        if (this.HP != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.HP);
        }
        if (com.baidu.location.f.f.na().i()) {
            BDLocation bDLocation2 = new BDLocation(com.baidu.location.f.f.na().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.HN, this.z, bDLocation2.getLatitude(), bDLocation2.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.HL != null) {
                        bDLocation2.setAddr(this.HL);
                    }
                    if (this.x != null) {
                        bDLocation2.setLocationDescribe(this.x);
                    }
                    if (this.HM != null) {
                        bDLocation2.setPoiList(this.HM);
                    }
                }
            }
            com.baidu.location.a.a.mi().a(bDLocation2);
            k();
        } else if (this.G) {
            k();
        } else {
            com.baidu.location.c.f.mB().mC().c(SystemClock.uptimeMillis());
            if (com.baidu.location.e.d.mF().d() && com.baidu.location.e.d.mF().e()) {
                bDLocation = com.baidu.location.e.d.mF().a(com.baidu.location.f.c.mX().mT(), com.baidu.location.f.k.ng().nd(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
                if (bDLocation != null && bDLocation.getLocType() == 66) {
                    com.baidu.location.a.a.mi().a(bDLocation);
                }
            } else {
                bDLocation = null;
            }
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                if (this.j || this.HE == null) {
                    BDLocation ab = com.baidu.location.e.a.mE().ab(false);
                    com.baidu.location.a.a.mi().a(ab);
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
                    com.baidu.location.a.a.mi().a(this.HE);
                }
            }
            com.baidu.location.c.f.mB().mC().l(SystemClock.uptimeMillis());
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                this.HE = null;
                com.baidu.location.c.f.mB().mC().a("off");
                if (this.HH != null) {
                    com.baidu.location.c.f.mB().mC().b(this.HH.h());
                }
                com.baidu.location.c.f.mB().c();
            } else {
                this.HE = bDLocation;
                com.baidu.location.c.f.mB().mC().a("ofs");
                if (this.HH != null) {
                    com.baidu.location.c.f.mB().mC().b(this.HH.h());
                }
                com.baidu.location.c.f.mB().c();
            }
            this.HF = null;
            k();
        }
    }

    @Override // com.baidu.location.a.d
    public void a(Message message) {
        boolean z;
        if (this.HP != null && this.F) {
            this.F = false;
            this.g.removeCallbacks(this.HP);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            this.HL = bDLocation.getAddress();
            this.z = bDLocation.getLongitude();
            this.HN = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.x = bDLocation.getLocationDescribe();
            this.z = bDLocation.getLongitude();
            this.HN = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.HM = bDLocation.getPoiList();
            this.z = bDLocation.getLongitude();
            this.HN = bDLocation.getLatitude();
        }
        if (com.baidu.location.f.f.na().i()) {
            BDLocation bDLocation3 = new BDLocation(com.baidu.location.f.f.na().f());
            if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.HN, this.z, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.HL != null) {
                        bDLocation3.setAddr(this.HL);
                    }
                    if (this.x != null) {
                        bDLocation3.setLocationDescribe(this.x);
                    }
                    if (this.HM != null) {
                        bDLocation3.setPoiList(this.HM);
                    }
                }
            }
            com.baidu.location.a.a.mi().a(bDLocation3);
            k();
        } else if (bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("sky")) {
            bDLocation.setNetworkLocationType("wf");
            com.baidu.location.a.a.mi().a(bDLocation);
            this.HK = System.currentTimeMillis();
            this.HE = bDLocation;
        } else if (this.G) {
            float[] fArr2 = new float[2];
            if (this.HE != null) {
                Location.distanceBetween(this.HE.getLatitude(), this.HE.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
            }
            if (fArr2[0] > 10.0f) {
                this.HE = bDLocation;
                if (!this.H) {
                    this.H = false;
                    com.baidu.location.a.a.mi().a(bDLocation);
                }
            }
            k();
        } else {
            com.baidu.location.c.f.mB().mC().c(SystemClock.uptimeMillis());
            this.HF = null;
            if (bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && this.HE != null && this.HE.getLocType() == 161 && "wf".equals(this.HE.getNetworkLocationType()) && System.currentTimeMillis() - this.HK < 30000) {
                z = true;
                this.HF = bDLocation;
            } else {
                z = false;
            }
            if (z) {
                com.baidu.location.a.a.mi().a(this.HE);
            } else {
                com.baidu.location.a.a.mi().a(bDLocation);
                this.HK = System.currentTimeMillis();
                com.baidu.location.c.f.mB().mC().l(SystemClock.uptimeMillis());
                if (bDLocation.getLocType() == 161) {
                    com.baidu.location.c.f.mB().mC().a("ons");
                    if (this.HH != null) {
                        com.baidu.location.c.f.mB().mC().b(this.HH.h());
                    }
                } else {
                    com.baidu.location.c.f.mB().mC().a("onf");
                    if (this.HH != null) {
                        com.baidu.location.c.f.mB().mC().b(this.HH.h());
                    }
                    com.baidu.location.c.f.mB().c();
                }
            }
            if (!com.baidu.location.h.i.d(bDLocation)) {
                this.HE = null;
            } else if (!z) {
                this.HE = bDLocation;
            }
            int o = com.baidu.location.h.i.o(c, "ssid\":\"", "\"");
            if (o == Integer.MIN_VALUE || this.HG == null) {
                this.k = null;
            } else {
                this.k = this.HG.c(o);
            }
            if (com.baidu.location.e.d.mF().d() && bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && b(this.HH)) {
                com.baidu.location.e.d.mF().a(this.HH, null, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.HJ = this.HH;
            }
            if (com.baidu.location.e.d.mF().d() && bDLocation.getLocType() == 161 && "wf".equals(bDLocation.getNetworkLocationType())) {
                com.baidu.location.e.d.mF().a(null, this.HG, bDLocation2, d.b.IS_NOT_MIX_MODE, d.a.NO_NEED_TO_LOG);
                this.HI = this.HG;
            }
            if (this.HH != null) {
                com.baidu.location.e.a.mE().a(c, this.HH, this.HG, bDLocation2);
            }
            if (com.baidu.location.f.k.ng().g()) {
                com.baidu.location.e.d.mF().i();
                com.baidu.location.e.d.mF().m();
            }
            k();
        }
    }

    public void a(boolean z) {
        BDLocation bDLocation = null;
        if (com.baidu.location.e.d.mF().d() && com.baidu.location.e.d.mF().g()) {
            bDLocation = com.baidu.location.e.d.mF().a(com.baidu.location.f.c.mX().mT(), com.baidu.location.f.k.ng().nd(), null, d.b.IS_NOT_MIX_MODE, d.a.NEED_TO_LOG);
            if ((bDLocation == null || bDLocation.getLocType() == 67) && z) {
                bDLocation = com.baidu.location.e.a.mE().ab(false);
            }
        } else if (z) {
            bDLocation = com.baidu.location.e.a.mE().ab(false);
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
            com.baidu.location.a.a.mi().a(bDLocation);
        }
    }

    public Address b(BDLocation bDLocation) {
        if (com.baidu.location.h.i.f.equals("all") || com.baidu.location.h.i.g || com.baidu.location.h.i.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.HN, this.z, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] >= 100.0f) {
                this.x = null;
                this.HM = null;
                this.B = true;
                i(null);
            } else if (this.HL != null) {
                return this.HL;
            }
        }
        return null;
    }

    public void b(Message message) {
        if (this.HQ) {
            c(message);
        }
    }

    public void c() {
        this.r = true;
        this.s = false;
        this.HQ = true;
    }

    public void d() {
        this.s = false;
        this.t = false;
        this.G = false;
        this.H = true;
        i();
        this.HQ = false;
    }

    public String e() {
        return this.x;
    }

    public List<Poi> f() {
        return this.HM;
    }

    public boolean g() {
        return this.j;
    }

    public void h() {
        if (!this.t) {
            com.baidu.location.c.a.mw().d();
            return;
        }
        j(null);
        this.t = false;
    }

    public void i() {
        this.HE = null;
    }
}
