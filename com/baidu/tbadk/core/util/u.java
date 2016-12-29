package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class u {
    private static long ZC = 0;
    private static long ZD = 0;
    private static int ZE = 0;
    private static a ZF = new a(null);
    private static t ZG = new t();
    private static t ZH = new t();
    private static String ZI = null;
    private static Object pu = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int ZJ;
        boolean ZK;
        t ZL;
        t ZM;
        t ZN;
        t ZO;
        t ZP;
        t ZQ;
        t ZR;
        t ZS;
        t ZT;
        t ZU;
        t ZV;
        t ZW;
        t ZX;
        t ZY;
        t ZZ;

        private a() {
            this.ZJ = 0;
            this.ZL = new t();
            this.ZM = new t();
            this.ZN = new t();
            this.ZO = new t();
            this.ZP = new t();
            this.ZQ = new t();
            this.ZR = new t();
            this.ZS = new t();
            this.ZT = new t();
            this.ZU = new t();
            this.ZV = new t();
            this.ZW = new t();
            this.ZX = new t();
            this.ZY = new t();
            this.ZZ = new t();
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [75=4] */
        public int uv() {
            return this.ZL.num + this.ZM.num + this.ZN.num + this.ZO.num + this.ZP.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [81=14] */
        public int uw() {
            return this.ZL.num + this.ZM.num + this.ZN.num + this.ZO.num + this.ZP.num + this.ZQ.num + this.ZR.num + this.ZS.num + this.ZT.num + this.ZU.num + this.ZV.num + this.ZW.num + this.ZX.num + this.ZY.num + this.ZZ.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [92=4] */
        public int ux() {
            return this.ZQ.num + this.ZR.num + this.ZS.num + this.ZT.num + this.ZU.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [98=4] */
        public int uy() {
            return this.ZV.num + this.ZW.num + this.ZX.num + this.ZY.num + this.ZZ.num;
        }

        public void reset() {
            this.ZJ = 0;
            this.ZL.reset();
            this.ZM.reset();
            this.ZN.reset();
            this.ZO.reset();
            this.ZP.reset();
            this.ZQ.reset();
            this.ZR.reset();
            this.ZS.reset();
            this.ZT.reset();
            this.ZU.reset();
            this.ZV.reset();
            this.ZW.reset();
            this.ZX.reset();
            this.ZY.reset();
            this.ZZ.reset();
        }
    }

    private static t a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return ZF.ZL;
            }
            if (str.startsWith("http://tb.himg")) {
                return ZF.ZM;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return ZF.ZN;
            }
            if (z2 && z3) {
                return ZF.ZP;
            }
            return ZF.ZO;
        } else if (com.baidu.adp.lib.util.i.gr()) {
            if (z2) {
                return ZF.ZQ;
            }
            if (str.startsWith("http://tb.himg")) {
                return ZF.ZR;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return ZF.ZS;
            }
            return ZF.ZT;
        } else if (z2) {
            return ZF.ZV;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return ZF.ZW;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return ZF.ZX;
            }
            return ZF.ZY;
        }
    }

    public static com.baidu.adp.lib.stats.d eB() {
        return com.baidu.adp.lib.stats.a.eI().ao("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (pu) {
                ZG.num++;
                ZG.time += j;
                if (ZG.num >= 100) {
                    uo();
                }
            }
        }
    }

    public static void uo() {
        if (ZG.num > 10) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("act", "locStat");
            eB.q("costTime", String.valueOf(ZG.time));
            eB.q("num", String.valueOf(ZG.num));
            eB.q("isWifi", "1");
            com.baidu.adp.lib.stats.a.eI().b("img", eB);
            ZG.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.e eVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.k.gD() && eVar != null) {
            String str6 = "";
            boolean gn = com.baidu.tbadk.util.g.gn(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().acx) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean gn2 = com.baidu.adp.lib.util.i.gn();
            if (!z5) {
                z4 = false;
            } else if (gn2) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Nf);
            } else if (com.baidu.adp.lib.util.i.gr()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Nh);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Ng);
            }
            boolean z6 = false;
            if (gn && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (gn && gn2 && z6) {
                if (z) {
                    r.getInstance().insertNormalData(j, str);
                } else {
                    str6 = v.uz().uA();
                    if (!TextUtils.isEmpty(str6)) {
                        r.getInstance().insertErrorData(eVar.om, str);
                    }
                }
            }
            if (gn) {
                ZI = str;
            }
            boolean z7 = false;
            if (eVar.oq != null && eVar.oq.length() > 0) {
                z7 = true;
            }
            synchronized (pu) {
                t a2 = a(gn2, gn, str2, z7);
                boolean z8 = ZF.ZK;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.oe += j2;
                        ZF.ZK = true;
                        if (z4) {
                            a2.ZB++;
                        }
                        ZE = 0;
                    } else {
                        if (com.baidu.adp.lib.util.i.gm()) {
                            int i2 = ZE + 1;
                            ZE = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.fD().getMaxAlertCount("alert_img", 5)) {
                                com.baidu.adp.lib.stats.a.eI().p("alert_img", "imgFailedCnt_" + String.valueOf(ZE) + "_url=" + str2);
                            }
                        }
                        a2.ZA++;
                        ZF.ZK = false;
                    }
                }
                int uw = ZF.uw();
                if (uw > 100 || (uw > 0 && z8 != ZF.ZK)) {
                    up();
                }
            }
            if (z && z5) {
                if (!gn2 || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Nf) {
                    if (gn2 || !com.baidu.adp.lib.util.i.gr() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Nh) {
                        if (!gn2 && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Ng) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (dVar == null) {
                dVar = eB();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = v.uz().uA();
            }
            if (!gn || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = v.uz().dr(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = ur();
            }
            dVar.q("url", str);
            dVar.q("act", "dl");
            dVar.q("result", z ? "1" : "0");
            dVar.q("fullurl", str2);
            dVar.q("netlib", String.valueOf(eVar.ov));
            dVar.q("costTime", String.valueOf(j));
            dVar.q("connTime", String.valueOf(eVar.of));
            dVar.q("rspTime", String.valueOf(eVar.og));
            dVar.q("retry", String.valueOf(eVar.oh));
            dVar.q("localIp", e.getIp());
            dVar.q("tiebaIp", str6);
            dVar.q("cdnIp", str4);
            dVar.q("useIp", eVar.oq);
            dVar.q("dnsIp", str5);
            if (eVar.of > 1500 || eVar.of < 0) {
                dVar.q("connBaidu", String.valueOf(us()));
            }
            dVar.q("memory", ut());
            dVar.q("task", uu());
            dVar.q("status", String.valueOf(eVar.oo));
            dVar.q("up", String.valueOf(eVar.od));
            dVar.q("down", String.valueOf(eVar.oe));
            dVar.q("isCDN", gn ? "1" : "0");
            dVar.q("isWebp", bool.booleanValue() ? "1" : "0");
            dVar.q("isMobileProxy", z3 ? "1" : "0");
            dVar.q("exception", eVar.ol);
            dVar.q("reason", str3);
            if (i != 0) {
                dVar.d("procType", Integer.valueOf(i));
            }
            if (eVar.ot != null) {
                dVar.q("tracecode1", eVar.ot);
            }
            if (eVar.ou != null) {
                dVar.q("tracecode2", eVar.ou);
            }
            com.baidu.adp.lib.stats.a.eI().b("img", dVar);
            if (gn && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                ZF.ZJ++;
            }
        }
    }

    public static void up() {
        if (ZF.uw() > 10) {
            if (ZF.uv() > 0) {
                a(ZF.ZL, ZF.ZM, ZF.ZN, ZF.ZP, ZF.ZO, 10000);
                com.baidu.tbadk.performanceLog.x.b(ZF.ZL, ZF.ZM, ZF.ZN, ZF.ZP, ZF.ZO, 3);
            }
            if (ZF.uy() > 0) {
                a(ZF.ZV, ZF.ZW, ZF.ZX, ZF.ZZ, ZF.ZY, 100002);
                com.baidu.tbadk.performanceLog.x.b(ZF.ZV, ZF.ZW, ZF.ZX, ZF.ZZ, ZF.ZY, 2);
            }
            if (ZF.ux() > 0) {
                a(ZF.ZQ, ZF.ZR, ZF.ZS, ZF.ZU, ZF.ZT, 100001);
                com.baidu.tbadk.performanceLog.x.b(ZF.ZQ, ZF.ZR, ZF.ZS, ZF.ZU, ZF.ZT, 1);
            }
            ZF.reset();
        }
    }

    public static void a(t tVar, t tVar2, t tVar3, t tVar4, t tVar5, int i) {
        if (tVar != null && tVar2 != null && tVar3 != null && tVar4 != null && tVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = v.uz().uA();
            }
            if (ZI != null && TextUtils.isEmpty("")) {
                str2 = v.uz().dr(ZI);
            }
            if (TextUtils.isEmpty("")) {
                str3 = ur();
            }
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("act", "dlStat");
            eB.q("cdnCostTime", String.valueOf(tVar.time));
            eB.q("cdnNum", String.valueOf(tVar.num));
            eB.q("cdnFailnum", String.valueOf(tVar.ZA));
            eB.q("portraitCostTime", String.valueOf(tVar2.time));
            eB.q("portraitNum", String.valueOf(tVar2.num));
            eB.q("portraitFailnum", String.valueOf(tVar2.ZA));
            eB.q("tiebaCostTime", String.valueOf(tVar3.time));
            eB.q("tiebaNum", String.valueOf(tVar3.num));
            eB.q("tiebaFailnum", String.valueOf(tVar3.ZA));
            eB.q("otherCostTime", String.valueOf(tVar5.time));
            eB.q("otherNum", String.valueOf(tVar5.num));
            eB.q("otherFailnum", String.valueOf(tVar5.ZA));
            eB.q("directIpCostTime", String.valueOf(tVar4.time));
            eB.q("directIpNum", String.valueOf(tVar4.num));
            eB.q("directIpFailnum", String.valueOf(tVar4.ZA));
            eB.q("dnsFailNum", String.valueOf(ZF.ZJ));
            if (10000 == i) {
                eB.q("isWifi", "1");
                eB.q("netType", "WIFI");
            } else if (100002 == i) {
                eB.q("netType", "3G");
                eB.q("isWifi", "0");
            } else {
                eB.q("netType", "2G");
                eB.q("isWifi", "0");
            }
            eB.q("localIp", e.getIp());
            eB.q("tbIp", str);
            eB.q("cdnIp", str2);
            eB.q("dnsIp", str3);
            com.baidu.adp.lib.stats.a.eI().b("img", eB);
        }
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.k.gD()) {
            synchronized (pu) {
                ZH.num++;
                if (z) {
                    ZH.time += j;
                } else {
                    ZH.ZA++;
                }
                if (ZH.num >= 100) {
                    uq();
                }
            }
            if (!z) {
                if (dVar == null) {
                    dVar = eB();
                }
                dVar.q("act", "dc");
                dVar.q("costTime", String.valueOf(j));
                dVar.q("url", str);
                dVar.q("fullURL", str2);
                dVar.q("isWebp", z3 ? "1" : "0");
                dVar.q("isCDN", z2 ? "1" : "0");
                dVar.q("length", String.valueOf(i));
                dVar.q("reason", str3);
                dVar.q("result", z ? "0" : "1");
                dVar.q("execption", str4);
                com.baidu.adp.lib.stats.a.eI().b("img", dVar);
            }
        }
    }

    public static void uq() {
        if (ZH.num > 10) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("act", "dcStat");
            eB.q("costTime", String.valueOf(ZH.time));
            eB.q("num", String.valueOf(ZH.num));
            eB.q("failnum", String.valueOf(ZH.ZA));
            com.baidu.adp.lib.stats.a.eI().b("img", eB);
            com.baidu.tbadk.performanceLog.x.a(ZH.num, ZH.ZA, ZH.time);
            ZH.reset();
        }
    }

    public static void dq(String str) {
        com.baidu.adp.lib.stats.d eB = eB();
        eB.q("act", "assistant");
        eB.q(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
        com.baidu.adp.lib.stats.a.eI().b("img", eB);
    }

    private static String ur() {
        try {
            DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApp().getSystemService("wifi")).getDhcpInfo();
            return String.valueOf(intToIp(dhcpInfo.dns1)) + "," + intToIp(dhcpInfo.dns2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String intToIp(int i) {
        return String.valueOf(i & MotionEventCompat.ACTION_MASK) + "." + ((i >> 8) & MotionEventCompat.ACTION_MASK) + "." + ((i >> 16) & MotionEventCompat.ACTION_MASK) + "." + ((i >> 24) & MotionEventCompat.ACTION_MASK);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [599=4] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long us() {
        HttpURLConnection httpURLConnection;
        long j;
        if (ZC >= 3) {
            return ZD;
        }
        long currentTimeMillis = System.currentTimeMillis();
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(TbDomainConfig.DOMAIN_HTTPS_BAIDU).openConnection();
            try {
                httpURLConnection.setConnectTimeout(2500);
                httpURLConnection.connect();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.h.a.f(httpURLConnection);
                j = currentTimeMillis2;
            } catch (SocketTimeoutException e) {
                com.baidu.adp.lib.h.a.f(httpURLConnection);
                j = 2500;
                if (j > 0) {
                }
            } catch (Exception e2) {
                httpURLConnection2 = httpURLConnection;
                com.baidu.adp.lib.h.a.f(httpURLConnection2);
                j = -1;
                if (j > 0) {
                }
            } catch (Throwable th) {
                httpURLConnection2 = httpURLConnection;
                th = th;
                com.baidu.adp.lib.h.a.f(httpURLConnection2);
                throw th;
            }
        } catch (SocketTimeoutException e3) {
            httpURLConnection = null;
        } catch (Exception e4) {
        } catch (Throwable th2) {
            th = th2;
        }
        if (j > 0) {
            if (ZC > -1) {
                ZD = ((ZD * ZC) + j) / (ZC + 1);
            } else {
                ZD = j;
            }
            ZC++;
            return j;
        }
        return j;
    }

    private static String ut() {
        return com.baidu.tbadk.imageManager.c.DX().df();
    }

    private static String uu() {
        return com.baidu.adp.lib.asyncTask.c.dg().df();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.d eB = eB();
        eB.q("act", "getCDNList");
        eB.q("errorNum", str);
        eB.q("errorMsg", str2);
        eB.q("isShortNetError", z2 ? "1" : "0");
        eB.q("isSuccess", z ? "1" : "0");
        com.baidu.adp.lib.stats.a.eI().b("img", eB);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = v.uz().dr(str);
        }
        String ur = ur();
        String ip = e.getIp();
        com.baidu.adp.lib.stats.d eB = eB();
        eB.q("act", "tachometerCDN");
        eB.q("errorNum", str3);
        eB.q("execption", str4);
        eB.q("size", str5);
        eB.q("isScuess", z ? "1" : "0");
        eB.q("url", str);
        eB.q("localIp", ip);
        eB.q("cdnIp", str6);
        eB.q("dnsIP", ur);
        eB.q("usedIp", str2);
        eB.q("isUsedIp", z2 ? "0" : "1");
        eB.q("costTime", String.valueOf(j));
        com.baidu.adp.lib.stats.a.eI().b("img", eB);
    }

    public static void a(ArrayList<String> arrayList, long j) {
        if (arrayList != null) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    if (i2 != 0) {
                        sb.append(",");
                    }
                    sb.append(arrayList.get(i2));
                    i = i2 + 1;
                } else {
                    com.baidu.adp.lib.stats.d eB = eB();
                    eB.q("act", "mobileTachometerCDN");
                    eB.q("costTime", String.valueOf(j));
                    eB.q("ipList", sb.toString());
                    com.baidu.adp.lib.stats.a.eI().b("img", eB);
                    return;
                }
            }
        }
    }

    public static void d(boolean z, String str) {
        com.baidu.adp.lib.stats.d eB = eB();
        eB.q("act", "getCDNList");
        eB.q("isSuccess", z ? "1" : "0");
        eB.q("errorMsg", str);
        com.baidu.adp.lib.stats.a.eI().b("img", eB);
    }

    public static void a(String str, int i, int i2, int i3) {
        if (i == -1) {
            i = 0;
        }
        if (i2 == -1) {
            i2 = 0;
        }
        com.baidu.adp.lib.stats.a.eI().eventStat(null, str, "imgHttpSwitch", 1, "1sterrcode", String.valueOf(i), "2nderrcode", String.valueOf(i2), "2imgFailed", String.valueOf(i3));
    }
}
