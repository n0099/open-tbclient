package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.xiaomi.mipush.sdk.Constants;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class s {
    private static long afz = 0;
    private static long afA = 0;
    private static int afB = 0;
    private static a afC = new a();
    private static r afD = new r();
    private static r afE = new r();
    private static String afF = null;
    private static Object syncLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int afG;
        boolean afH;
        r afI;
        r afJ;
        r afK;
        r afL;
        r afM;
        r afN;
        r afO;
        r afP;
        r afQ;
        r afR;
        r afS;
        r afT;
        r afU;
        r afV;
        r afW;

        private a() {
            this.afG = 0;
            this.afI = new r();
            this.afJ = new r();
            this.afK = new r();
            this.afL = new r();
            this.afM = new r();
            this.afN = new r();
            this.afO = new r();
            this.afP = new r();
            this.afQ = new r();
            this.afR = new r();
            this.afS = new r();
            this.afT = new r();
            this.afU = new r();
            this.afV = new r();
            this.afW = new r();
        }

        public int uW() {
            return this.afI.num + this.afJ.num + this.afK.num + this.afL.num + this.afM.num;
        }

        public int uX() {
            return this.afI.num + this.afJ.num + this.afK.num + this.afL.num + this.afM.num + this.afN.num + this.afO.num + this.afP.num + this.afQ.num + this.afR.num + this.afS.num + this.afT.num + this.afU.num + this.afV.num + this.afW.num;
        }

        public int uY() {
            return this.afN.num + this.afO.num + this.afP.num + this.afQ.num + this.afR.num;
        }

        public int uZ() {
            return this.afS.num + this.afT.num + this.afU.num + this.afV.num + this.afW.num;
        }

        public void reset() {
            this.afG = 0;
            this.afI.reset();
            this.afJ.reset();
            this.afK.reset();
            this.afL.reset();
            this.afM.reset();
            this.afN.reset();
            this.afO.reset();
            this.afP.reset();
            this.afQ.reset();
            this.afR.reset();
            this.afS.reset();
            this.afT.reset();
            this.afU.reset();
            this.afV.reset();
            this.afW.reset();
        }
    }

    private static r a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return afC.afI;
            }
            if (str.startsWith("http://tb.himg")) {
                return afC.afJ;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return afC.afK;
            }
            if (z2 && z3) {
                return afC.afM;
            }
            return afC.afL;
        } else if (com.baidu.adp.lib.util.i.hn()) {
            if (z2) {
                return afC.afN;
            }
            if (str.startsWith("http://tb.himg")) {
                return afC.afO;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return afC.afP;
            }
            return afC.afQ;
        } else if (z2) {
            return afC.afS;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return afC.afT;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return afC.afU;
            }
            return afC.afV;
        }
    }

    public static com.baidu.adp.lib.stats.a fL() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (syncLock) {
                afD.num++;
                afD.time += j;
                if (afD.num >= 100) {
                    uP();
                }
            }
        }
    }

    public static void uP() {
        if (afD.num > 10) {
            com.baidu.adp.lib.stats.a fL = fL();
            fL.p("act", "locStat");
            fL.p("costTime", String.valueOf(afD.time));
            fL.p("num", String.valueOf(afD.num));
            fL.p("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", fL);
            afD.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.k.hz() && dVar != null) {
            String str6 = "";
            boolean gH = com.baidu.tbadk.util.i.gH(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().aiq) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean hj = com.baidu.adp.lib.util.i.hj();
            if (!z5) {
                z4 = false;
            } else if (hj) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().RD);
            } else if (com.baidu.adp.lib.util.i.hn()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().RF);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().RE);
            }
            boolean z6 = false;
            if (gH && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (gH && hj && z6) {
                if (z) {
                    p.getInstance().insertNormalData(j, str);
                } else {
                    str6 = t.va().vb();
                    if (!TextUtils.isEmpty(str6)) {
                        p.getInstance().insertErrorData(dVar.uW, str);
                    }
                }
            }
            if (gH) {
                afF = str;
            }
            boolean z7 = false;
            if (dVar.uY != null && dVar.uY.length() > 0) {
                z7 = true;
            }
            synchronized (syncLock) {
                r a2 = a(hj, gH, str2, z7);
                boolean z8 = afC.afH;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.uQ += j2;
                        afC.afH = true;
                        if (z4) {
                            a2.afy++;
                        }
                        afB = 0;
                    } else {
                        if (com.baidu.adp.lib.util.i.hi()) {
                            int i2 = afB + 1;
                            afB = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.gA().getMaxAlertCount("alert_img", 5)) {
                                BdStatisticsManager.getInstance().alert("alert_img", "imgFailedCnt_" + String.valueOf(afB) + "_url=" + str2);
                            }
                        }
                        a2.afx++;
                        afC.afH = false;
                    }
                }
                int uX = afC.uX();
                if (uX > 100 || (uX > 0 && z8 != afC.afH)) {
                    uQ();
                }
            }
            if (z && z5) {
                if (!hj || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().RD) {
                    if (hj || !com.baidu.adp.lib.util.i.hn() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().RF) {
                        if (!hj && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().RE) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (aVar == null) {
                aVar = fL();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = t.va().vb();
            }
            if (!gH || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = t.va().dI(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = uS();
            }
            aVar.p("url", str);
            aVar.p("act", "dl");
            aVar.p("result", z ? "1" : "0");
            aVar.p("fullurl", str2);
            aVar.p("netlib", String.valueOf(dVar.vc));
            aVar.p("costTime", String.valueOf(j));
            aVar.p("connTime", String.valueOf(dVar.connectTime));
            aVar.p("rspTime", String.valueOf(dVar.uR));
            aVar.p("retry", String.valueOf(dVar.uS));
            aVar.p("localIp", d.getIp());
            aVar.p("tiebaIp", str6);
            aVar.p("cdnIp", str4);
            aVar.p("useIp", dVar.uY);
            aVar.p("dnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.p("connBaidu", String.valueOf(uT()));
            }
            aVar.p("memory", uU());
            aVar.p("task", uV());
            aVar.p("status", String.valueOf(dVar.uX));
            aVar.p("up", String.valueOf(dVar.uP));
            aVar.p("down", String.valueOf(dVar.uQ));
            aVar.p("isCDN", gH ? "1" : "0");
            aVar.p("isWebp", bool.booleanValue() ? "1" : "0");
            aVar.p("isMobileProxy", z3 ? "1" : "0");
            aVar.p("exception", dVar.uV);
            aVar.p("reason", str3);
            if (i != 0) {
                aVar.c("procType", Integer.valueOf(i));
            }
            if (dVar.va != null) {
                aVar.p("tracecode1", dVar.va);
            }
            if (dVar.vb != null) {
                aVar.p("tracecode2", dVar.vb);
            }
            BdStatisticsManager.getInstance().debug("img", aVar);
            if (gH && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                afC.afG++;
            }
        }
    }

    public static void uQ() {
        if (afC.uX() > 10) {
            if (afC.uW() > 0) {
                a(afC.afI, afC.afJ, afC.afK, afC.afM, afC.afL, 10000);
                com.baidu.tbadk.l.o.b(afC.afI, afC.afJ, afC.afK, afC.afM, afC.afL, 3);
            }
            if (afC.uZ() > 0) {
                a(afC.afS, afC.afT, afC.afU, afC.afW, afC.afV, 100002);
                com.baidu.tbadk.l.o.b(afC.afS, afC.afT, afC.afU, afC.afW, afC.afV, 2);
            }
            if (afC.uY() > 0) {
                a(afC.afN, afC.afO, afC.afP, afC.afR, afC.afQ, 100001);
                com.baidu.tbadk.l.o.b(afC.afN, afC.afO, afC.afP, afC.afR, afC.afQ, 1);
            }
            afC.reset();
        }
    }

    public static void a(r rVar, r rVar2, r rVar3, r rVar4, r rVar5, int i) {
        if (rVar != null && rVar2 != null && rVar3 != null && rVar4 != null && rVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = t.va().vb();
            }
            if (afF != null && TextUtils.isEmpty("")) {
                str2 = t.va().dI(afF);
            }
            if (TextUtils.isEmpty("")) {
                str3 = uS();
            }
            com.baidu.adp.lib.stats.a fL = fL();
            fL.p("act", "dlStat");
            fL.p("cdnCostTime", String.valueOf(rVar.time));
            fL.p("cdnNum", String.valueOf(rVar.num));
            fL.p("cdnFailnum", String.valueOf(rVar.afx));
            fL.p("portraitCostTime", String.valueOf(rVar2.time));
            fL.p("portraitNum", String.valueOf(rVar2.num));
            fL.p("portraitFailnum", String.valueOf(rVar2.afx));
            fL.p("tiebaCostTime", String.valueOf(rVar3.time));
            fL.p("tiebaNum", String.valueOf(rVar3.num));
            fL.p("tiebaFailnum", String.valueOf(rVar3.afx));
            fL.p("otherCostTime", String.valueOf(rVar5.time));
            fL.p("otherNum", String.valueOf(rVar5.num));
            fL.p("otherFailnum", String.valueOf(rVar5.afx));
            fL.p("directIpCostTime", String.valueOf(rVar4.time));
            fL.p("directIpNum", String.valueOf(rVar4.num));
            fL.p("directIpFailnum", String.valueOf(rVar4.afx));
            fL.p("dnsFailNum", String.valueOf(afC.afG));
            if (10000 == i) {
                fL.p("isWifi", "1");
                fL.p("netType", "WIFI");
            } else if (100002 == i) {
                fL.p("netType", "3G");
                fL.p("isWifi", "0");
            } else {
                fL.p("netType", "2G");
                fL.p("isWifi", "0");
            }
            fL.p("localIp", d.getIp());
            fL.p("tbIp", str);
            fL.p("cdnIp", str2);
            fL.p("dnsIp", str3);
            BdStatisticsManager.getInstance().debug("img", fL);
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.k.hz()) {
            synchronized (syncLock) {
                afE.num++;
                if (z) {
                    afE.time += j;
                } else {
                    afE.afx++;
                }
                if (afE.num >= 100) {
                    uR();
                }
            }
            if (!z) {
                if (aVar == null) {
                    aVar = fL();
                }
                aVar.p("act", "dc");
                aVar.p("costTime", String.valueOf(j));
                aVar.p("url", str);
                aVar.p("fullURL", str2);
                aVar.p("isWebp", z3 ? "1" : "0");
                aVar.p("isCDN", z2 ? "1" : "0");
                aVar.p("length", String.valueOf(i));
                aVar.p("reason", str3);
                aVar.p("result", z ? "0" : "1");
                aVar.p("execption", str4);
                BdStatisticsManager.getInstance().debug("img", aVar);
            }
        }
    }

    public static void uR() {
        if (afE.num > 10) {
            com.baidu.adp.lib.stats.a fL = fL();
            fL.p("act", "dcStat");
            fL.p("costTime", String.valueOf(afE.time));
            fL.p("num", String.valueOf(afE.num));
            fL.p("failnum", String.valueOf(afE.afx));
            BdStatisticsManager.getInstance().debug("img", fL);
            com.baidu.tbadk.l.o.a(afE.num, afE.afx, afE.time);
            afE.reset();
        }
    }

    public static void dH(String str) {
        com.baidu.adp.lib.stats.a fL = fL();
        fL.p("act", "assistant");
        fL.p("content", str);
        BdStatisticsManager.getInstance().debug("img", fL);
    }

    private static String uS() {
        try {
            DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApp().getSystemService("wifi")).getDhcpInfo();
            return intToIp(dhcpInfo.dns1) + Constants.ACCEPT_TIME_SEPARATOR_SP + intToIp(dhcpInfo.dns2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String intToIp(int i) {
        return (i & MotionEventCompat.ACTION_MASK) + "." + ((i >> 8) & MotionEventCompat.ACTION_MASK) + "." + ((i >> 16) & MotionEventCompat.ACTION_MASK) + "." + ((i >> 24) & MotionEventCompat.ACTION_MASK);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [599=5] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long uT() {
        HttpURLConnection httpURLConnection;
        long j;
        if (afz >= 3) {
            return afA;
        }
        long currentTimeMillis = System.currentTimeMillis();
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(TbDomainConfig.DOMAIN_HTTPS_BAIDU).openConnection();
        } catch (SocketTimeoutException e) {
            httpURLConnection = null;
        } catch (Exception e2) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            httpURLConnection.setConnectTimeout(TbConfig.NOTIFY_YUN_PUSH);
            httpURLConnection.connect();
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.adp.lib.g.a.f(httpURLConnection);
            j = currentTimeMillis2;
        } catch (SocketTimeoutException e3) {
            com.baidu.adp.lib.g.a.f(httpURLConnection);
            j = 2500;
            if (j > 0) {
            }
        } catch (Exception e4) {
            httpURLConnection2 = httpURLConnection;
            com.baidu.adp.lib.g.a.f(httpURLConnection2);
            j = -1;
            if (j > 0) {
            }
        } catch (Throwable th2) {
            httpURLConnection2 = httpURLConnection;
            th = th2;
            com.baidu.adp.lib.g.a.f(httpURLConnection2);
            throw th;
        }
        if (j > 0) {
            if (afz > -1) {
                afA = ((afA * afz) + j) / (afz + 1);
            } else {
                afA = j;
            }
            afz++;
            return j;
        }
        return j;
    }

    private static String uU() {
        return com.baidu.tbadk.imageManager.c.Ev().ej();
    }

    private static String uV() {
        return com.baidu.adp.lib.asyncTask.a.ek().ej();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.a fL = fL();
        fL.p("act", "getCDNList");
        fL.p("errorNum", str);
        fL.p("errorMsg", str2);
        fL.p("isShortNetError", z2 ? "1" : "0");
        fL.p("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug("img", fL);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = t.va().dI(str);
        }
        String uS = uS();
        String ip = d.getIp();
        com.baidu.adp.lib.stats.a fL = fL();
        fL.p("act", "tachometerCDN");
        fL.p("errorNum", str3);
        fL.p("execption", str4);
        fL.p("size", str5);
        fL.p("isScuess", z ? "1" : "0");
        fL.p("url", str);
        fL.p("localIp", ip);
        fL.p("cdnIp", str6);
        fL.p("dnsIP", uS);
        fL.p("usedIp", str2);
        fL.p("isUsedIp", z2 ? "0" : "1");
        fL.p("costTime", String.valueOf(j));
        BdStatisticsManager.getInstance().debug("img", fL);
    }

    public static void a(ArrayList<String> arrayList, long j) {
        if (arrayList != null) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    if (i2 != 0) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    sb.append(arrayList.get(i2));
                    i = i2 + 1;
                } else {
                    com.baidu.adp.lib.stats.a fL = fL();
                    fL.p("act", "mobileTachometerCDN");
                    fL.p("costTime", String.valueOf(j));
                    fL.p("ipList", sb.toString());
                    BdStatisticsManager.getInstance().debug("img", fL);
                    return;
                }
            }
        }
    }

    public static void d(boolean z, String str) {
        com.baidu.adp.lib.stats.a fL = fL();
        fL.p("act", "getCDNList");
        fL.p("isSuccess", z ? "1" : "0");
        fL.p("errorMsg", str);
        BdStatisticsManager.getInstance().debug("img", fL);
    }

    public static void a(String str, int i, int i2, int i3) {
        if (i == -1) {
            i = 0;
        }
        if (i2 == -1) {
            i2 = 0;
        }
        BdStatisticsManager.getInstance().eventStat(null, str, "imgHttpSwitch", 1, "1sterrcode", String.valueOf(i), "2nderrcode", String.valueOf(i2), "2imgFailed", String.valueOf(i3));
    }
}
