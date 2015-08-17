package com.baidu.location;

import android.location.Location;
import android.os.Handler;
import android.os.Message;
import com.baidu.location.BDLocation;
import com.baidu.location.aj;
import com.baidu.location.au;
import com.baidu.location.u;
import com.baidu.tbadk.TbConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends aj implements a0, n {
    private static ak eB = null;
    private int eC;
    private av eF;
    private double eI;
    private double eL;
    public aj.a ez;
    final int eR = TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI;
    final int ey = 1000;
    private boolean eM = true;
    private String eS = null;
    private BDLocation eP = null;
    private BDLocation eQ = null;
    private au.b eJ = null;
    private u.a eH = null;
    private boolean eN = true;
    private volatile boolean eA = false;
    private boolean eK = false;
    private long eE = 0;
    private long eG = 0;
    final Handler et = new aj.b();
    private BDLocation.a eO = null;
    private long eD = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ak.this.eK) {
                ak.this.eK = false;
                ak.this.aL();
            }
        }
    }

    private ak() {
        this.eF = null;
        this.ez = null;
        this.eF = new av();
        this.ez = new aj.a();
    }

    private boolean aB() {
        this.ex = au.cc().ch();
        return !this.eF.mo228do(this.ex);
    }

    private void aC() {
        this.eA = false;
        aK();
    }

    public static ak aF() {
        if (eB == null) {
            eB = new ak();
        }
        return eB;
    }

    private void aI() {
        if (this.eN) {
            aL();
        } else if (this.eA) {
        } else {
            if (!au.cc().cd()) {
                aL();
                return;
            }
            this.eK = true;
            this.et.postDelayed(new a(), 2000L);
        }
    }

    private void aK() {
        if (this.eP != null) {
            q.y().F();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL() {
        if (this.eA) {
            return;
        }
        if (System.currentTimeMillis() - this.eE < 1000 && this.eP != null) {
            k.q().m299do(this.eP);
            aC();
            return;
        }
        c.m273if(a0.i, "start network locating ...");
        this.eA = true;
        this.eM = m160if(this.eH);
        if (!m159if(this.eJ) && !this.eM && this.eP != null && this.eC == 0) {
            if (this.eQ != null && System.currentTimeMillis() - this.eG > 30000) {
                this.eP = this.eQ;
                this.eQ = null;
            }
            k.q().m299do(this.eP);
            aC();
            return;
        }
        String h = h(null);
        if (h == null) {
            if (this.eP != null) {
                k.q().m299do(this.eP);
                aC();
                return;
            }
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLocType(62);
            k.q().m299do(bDLocation);
            aC();
            return;
        }
        if (this.eS != null) {
            h = h + this.eS;
            this.eS = null;
        }
        this.ez.e(h);
        this.eH = this.eu;
        this.eJ = this.ex;
        if (this.eN) {
            this.eN = false;
        }
        this.eE = System.currentTimeMillis();
    }

    /* renamed from: char  reason: not valid java name */
    private void m153char(Message message) {
        String aX = z.bc().aX();
        BDLocation bDLocation = new BDLocation(aX);
        if (c.aF.equals("all")) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.eL, this.eI, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f && this.eO != null) {
                bDLocation.m10if(this.eO);
            }
        }
        k.q().m303if(bDLocation, message);
        an.a().a((String) null);
        an.a().m184if(aX);
    }

    /* renamed from: else  reason: not valid java name */
    private void m155else(Message message) {
        c.m273if(a0.i, "on request location ...");
        if (ag.bz().bA()) {
            return;
        }
        int m300for = k.q().m300for(message);
        this.eC = message.arg1;
        switch (m300for) {
            case 1:
                m156goto(message);
                return;
            case 2:
                aI();
                return;
            case 3:
                if (z.bc().aZ()) {
                    m153char(message);
                    if (c.aF.equals("all")) {
                        aI();
                        return;
                    }
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(m300for)));
        }
    }

    /* renamed from: goto  reason: not valid java name */
    private void m156goto(Message message) {
        if (!z.bc().aZ()) {
            aI();
            return;
        }
        m153char(message);
        if (c.aF.equals("all")) {
            aI();
        }
    }

    /* renamed from: if  reason: not valid java name */
    private boolean m159if(au.b bVar) {
        this.ex = au.cc().ch();
        if (bVar == this.ex) {
            return false;
        }
        return this.ex == null || bVar == null || !bVar.a(this.ex);
    }

    /* renamed from: if  reason: not valid java name */
    private boolean m160if(u.a aVar) {
        this.eu = u.au().at();
        if (this.eu == aVar) {
            return false;
        }
        return this.eu == null || aVar == null || !aVar.a(this.eu);
    }

    @Override // com.baidu.location.aj
    void aA() {
        c.m273if(a0.i, "on network exception");
        j.dg().m294if(this.eH, this.eJ);
        if (this.eM || this.eP == null) {
            k.q().m302if(a1.ct().m76case(false), 21);
        } else {
            k.q().m302if(this.eP, 21);
        }
        this.eP = null;
        this.eQ = null;
        this.eF.cm();
        aC();
    }

    public void aD() {
        if (this.eK) {
            aL();
            this.eK = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aE() {
        this.eA = false;
        aG();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aG() {
        this.eP = null;
        this.eF.cm();
    }

    public boolean aH() {
        return this.eM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aJ() {
        this.eN = true;
        this.eA = false;
    }

    @Override // com.baidu.location.aj
    /* renamed from: byte */
    void mo113byte(Message message) {
        boolean z = true;
        c.m273if(a0.i, "on network success");
        BDLocation bDLocation = (BDLocation) message.obj;
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            this.eD = System.currentTimeMillis();
            this.eO = bDLocation.bx();
            this.eI = bDLocation.getLongitude();
            this.eL = bDLocation.getLatitude();
        }
        if (bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("sky")) {
            bDLocation.setNetworkLocationType("wf");
            k.q().m302if(bDLocation, 21);
            this.eG = System.currentTimeMillis();
            this.eP = bDLocation;
            return;
        }
        if (bDLocation.bv() == 0) {
            aa.gs = true;
        } else {
            aa.gs = false;
        }
        this.eQ = null;
        if (bDLocation.bv() == 2 && bDLocation.getLocType() == 167) {
            new s(this.eH, this.eJ, true).N();
        }
        if (bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && this.eP != null && this.eP.getLocType() == 161 && "wf".equals(this.eP.getNetworkLocationType()) && System.currentTimeMillis() - this.eG < 30000) {
            this.eQ = bDLocation;
        } else {
            z = false;
        }
        if (!z.bc().aZ()) {
            if (z) {
                k.q().m302if(this.eP, 21);
            } else {
                k.q().m302if(bDLocation, 21);
                this.eG = System.currentTimeMillis();
            }
        }
        if (!c.m274if(bDLocation)) {
            this.eP = null;
            this.eF.cm();
        } else if (!z) {
            this.eP = bDLocation;
        }
        int m259do = c.m259do(er, "ssid\":\"", "\"");
        if (m259do == Integer.MIN_VALUE || this.eJ == null) {
            this.eS = null;
        } else {
            this.eS = this.eJ.m218do(m259do);
        }
        a1.ct().m77if(er, this.eH, this.eJ, bDLocation2);
        j.dg().de();
        aC();
    }

    /* renamed from: case  reason: not valid java name */
    public void m161case(Message message) {
        m155else(message);
    }

    /* renamed from: for  reason: not valid java name */
    public void m162for(BDLocation bDLocation) {
        aG();
        this.eP = bDLocation;
    }
}
