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
    private static long afy = 0;
    private static long afz = 0;
    private static int afA = 0;
    private static a afB = new a();
    private static r afC = new r();
    private static r afD = new r();
    private static String afE = null;
    private static Object syncLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int afF;
        boolean afG;
        r afH;
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

        private a() {
            this.afF = 0;
            this.afH = new r();
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
        }

        public int uW() {
            return this.afH.num + this.afI.num + this.afJ.num + this.afK.num + this.afL.num;
        }

        public int uX() {
            return this.afH.num + this.afI.num + this.afJ.num + this.afK.num + this.afL.num + this.afM.num + this.afN.num + this.afO.num + this.afP.num + this.afQ.num + this.afR.num + this.afS.num + this.afT.num + this.afU.num + this.afV.num;
        }

        public int uY() {
            return this.afM.num + this.afN.num + this.afO.num + this.afP.num + this.afQ.num;
        }

        public int uZ() {
            return this.afR.num + this.afS.num + this.afT.num + this.afU.num + this.afV.num;
        }

        public void reset() {
            this.afF = 0;
            this.afH.reset();
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
        }
    }

    private static r a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return afB.afH;
            }
            if (str.startsWith("http://tb.himg")) {
                return afB.afI;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return afB.afJ;
            }
            if (z2 && z3) {
                return afB.afL;
            }
            return afB.afK;
        } else if (com.baidu.adp.lib.util.i.hn()) {
            if (z2) {
                return afB.afM;
            }
            if (str.startsWith("http://tb.himg")) {
                return afB.afN;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return afB.afO;
            }
            return afB.afP;
        } else if (z2) {
            return afB.afR;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return afB.afS;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return afB.afT;
            }
            return afB.afU;
        }
    }

    public static com.baidu.adp.lib.stats.a fL() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (syncLock) {
                afC.num++;
                afC.time += j;
                if (afC.num >= 100) {
                    uP();
                }
            }
        }
    }

    public static void uP() {
        if (afC.num > 10) {
            com.baidu.adp.lib.stats.a fL = fL();
            fL.p("act", "locStat");
            fL.p("costTime", String.valueOf(afC.time));
            fL.p("num", String.valueOf(afC.num));
            fL.p("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", fL);
            afC.reset();
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
                if (!com.baidu.tbadk.core.util.a.e.getInstance().aip) {
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
                afE = str;
            }
            boolean z7 = false;
            if (dVar.uY != null && dVar.uY.length() > 0) {
                z7 = true;
            }
            synchronized (syncLock) {
                r a2 = a(hj, gH, str2, z7);
                boolean z8 = afB.afG;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.uQ += j2;
                        afB.afG = true;
                        if (z4) {
                            a2.afx++;
                        }
                        afA = 0;
                    } else {
                        if (com.baidu.adp.lib.util.i.hi()) {
                            int i2 = afA + 1;
                            afA = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.gA().getMaxAlertCount("alert_img", 5)) {
                                BdStatisticsManager.getInstance().alert("alert_img", "imgFailedCnt_" + String.valueOf(afA) + "_url=" + str2);
                            }
                        }
                        a2.afw++;
                        afB.afG = false;
                    }
                }
                int uX = afB.uX();
                if (uX > 100 || (uX > 0 && z8 != afB.afG)) {
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
                afB.afF++;
            }
        }
    }

    public static void uQ() {
        if (afB.uX() > 10) {
            if (afB.uW() > 0) {
                a(afB.afH, afB.afI, afB.afJ, afB.afL, afB.afK, 10000);
                com.baidu.tbadk.l.o.b(afB.afH, afB.afI, afB.afJ, afB.afL, afB.afK, 3);
            }
            if (afB.uZ() > 0) {
                a(afB.afR, afB.afS, afB.afT, afB.afV, afB.afU, 100002);
                com.baidu.tbadk.l.o.b(afB.afR, afB.afS, afB.afT, afB.afV, afB.afU, 2);
            }
            if (afB.uY() > 0) {
                a(afB.afM, afB.afN, afB.afO, afB.afQ, afB.afP, 100001);
                com.baidu.tbadk.l.o.b(afB.afM, afB.afN, afB.afO, afB.afQ, afB.afP, 1);
            }
            afB.reset();
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
            if (afE != null && TextUtils.isEmpty("")) {
                str2 = t.va().dI(afE);
            }
            if (TextUtils.isEmpty("")) {
                str3 = uS();
            }
            com.baidu.adp.lib.stats.a fL = fL();
            fL.p("act", "dlStat");
            fL.p("cdnCostTime", String.valueOf(rVar.time));
            fL.p("cdnNum", String.valueOf(rVar.num));
            fL.p("cdnFailnum", String.valueOf(rVar.afw));
            fL.p("portraitCostTime", String.valueOf(rVar2.time));
            fL.p("portraitNum", String.valueOf(rVar2.num));
            fL.p("portraitFailnum", String.valueOf(rVar2.afw));
            fL.p("tiebaCostTime", String.valueOf(rVar3.time));
            fL.p("tiebaNum", String.valueOf(rVar3.num));
            fL.p("tiebaFailnum", String.valueOf(rVar3.afw));
            fL.p("otherCostTime", String.valueOf(rVar5.time));
            fL.p("otherNum", String.valueOf(rVar5.num));
            fL.p("otherFailnum", String.valueOf(rVar5.afw));
            fL.p("directIpCostTime", String.valueOf(rVar4.time));
            fL.p("directIpNum", String.valueOf(rVar4.num));
            fL.p("directIpFailnum", String.valueOf(rVar4.afw));
            fL.p("dnsFailNum", String.valueOf(afB.afF));
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
                afD.num++;
                if (z) {
                    afD.time += j;
                } else {
                    afD.afw++;
                }
                if (afD.num >= 100) {
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
        if (afD.num > 10) {
            com.baidu.adp.lib.stats.a fL = fL();
            fL.p("act", "dcStat");
            fL.p("costTime", String.valueOf(afD.time));
            fL.p("num", String.valueOf(afD.num));
            fL.p("failnum", String.valueOf(afD.afw));
            BdStatisticsManager.getInstance().debug("img", fL);
            com.baidu.tbadk.l.o.a(afD.num, afD.afw, afD.time);
            afD.reset();
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
        if (afy >= 3) {
            return afz;
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
            if (afy > -1) {
                afz = ((afz * afy) + j) / (afy + 1);
            } else {
                afz = j;
            }
            afy++;
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
