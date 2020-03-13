package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.tbadk.TbConfig;
import com.xiaomi.mipush.sdk.Constants;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class s {
    private static long cYH = 0;
    private static long cYI = 0;
    private static int cYJ = 0;
    private static a cYK = new a();
    private static r cYL = new r();
    private static r cYM = new r();
    private static String cYN = null;
    private static Object syncLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int cYO;
        boolean cYP;
        r cYQ;
        r cYR;
        r cYS;
        r cYT;
        r cYU;
        r cYV;
        r cYW;
        r cYX;
        r cYY;
        r cYZ;
        r cZa;
        r cZb;
        r cZc;
        r cZd;
        r cZe;

        private a() {
            this.cYO = 0;
            this.cYQ = new r();
            this.cYR = new r();
            this.cYS = new r();
            this.cYT = new r();
            this.cYU = new r();
            this.cYV = new r();
            this.cYW = new r();
            this.cYX = new r();
            this.cYY = new r();
            this.cYZ = new r();
            this.cZa = new r();
            this.cZb = new r();
            this.cZc = new r();
            this.cZd = new r();
            this.cZe = new r();
        }

        public int aFX() {
            return this.cYQ.num + this.cYR.num + this.cYS.num + this.cYT.num + this.cYU.num;
        }

        public int aFY() {
            return this.cYQ.num + this.cYR.num + this.cYS.num + this.cYT.num + this.cYU.num + this.cYV.num + this.cYW.num + this.cYX.num + this.cYY.num + this.cYZ.num + this.cZa.num + this.cZb.num + this.cZc.num + this.cZd.num + this.cZe.num;
        }

        public int aFZ() {
            return this.cYV.num + this.cYW.num + this.cYX.num + this.cYY.num + this.cYZ.num;
        }

        public int aGa() {
            return this.cZa.num + this.cZb.num + this.cZc.num + this.cZd.num + this.cZe.num;
        }

        public void reset() {
            this.cYO = 0;
            this.cYQ.reset();
            this.cYR.reset();
            this.cYS.reset();
            this.cYT.reset();
            this.cYU.reset();
            this.cYV.reset();
            this.cYW.reset();
            this.cYX.reset();
            this.cYY.reset();
            this.cYZ.reset();
            this.cZa.reset();
            this.cZb.reset();
            this.cZc.reset();
            this.cZd.reset();
            this.cZe.reset();
        }
    }

    private static r a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return cYK.cYQ;
            }
            if (str.startsWith("http://tb.himg")) {
                return cYK.cYR;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return cYK.cYS;
            }
            if (z2 && z3) {
                return cYK.cYU;
            }
            return cYK.cYT;
        } else if (com.baidu.adp.lib.util.j.is2GNet()) {
            if (z2) {
                return cYK.cYV;
            }
            if (str.startsWith("http://tb.himg")) {
                return cYK.cYW;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return cYK.cYX;
            }
            return cYK.cYY;
        } else if (z2) {
            return cYK.cZa;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return cYK.cZb;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return cYK.cZc;
            }
            return cYK.cZd;
        }
    }

    public static com.baidu.adp.lib.stats.a gs() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (syncLock) {
                cYL.num++;
                cYL.time += j;
                if (cYL.num >= 100) {
                    aFQ();
                }
            }
        }
    }

    public static void aFQ() {
        if (cYL.num > 10) {
            com.baidu.adp.lib.stats.a gs = gs();
            gs.append("act", "locStat");
            gs.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(cYL.time));
            gs.append("num", String.valueOf(cYL.num));
            gs.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", gs);
            cYL.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.l.isNetOk() && dVar != null) {
            String str6 = "";
            boolean isCdn = com.baidu.tbadk.util.m.isCdn(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().daP) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean isWifiNet = com.baidu.adp.lib.util.j.isWifiNet();
            if (!z5) {
                z4 = false;
            } else if (isWifiNet) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().cLp);
            } else if (com.baidu.adp.lib.util.j.is2GNet()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().cLr);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().cLq);
            }
            boolean z6 = false;
            if (isCdn && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (isCdn && isWifiNet && z6) {
                if (z) {
                    p.getInstance().insertNormalData(j, str);
                } else {
                    str6 = t.aGb().aGc();
                    if (!TextUtils.isEmpty(str6)) {
                        p.getInstance().insertErrorData(dVar.qP, str);
                    }
                }
            }
            if (isCdn) {
                cYN = str;
            }
            boolean z7 = false;
            if (dVar.qR != null && dVar.qR.length() > 0) {
                z7 = true;
            }
            synchronized (syncLock) {
                r a2 = a(isWifiNet, isCdn, str2, z7);
                boolean z8 = cYK.cYP;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.downloadSize += j2;
                        cYK.cYP = true;
                        if (z4) {
                            a2.slownum++;
                        }
                        cYJ = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            int i2 = cYJ + 1;
                            cYJ = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.hr().getMaxAlertCount(BdStatsConstant.AlertTypeKey.ALERT_IMG, 5)) {
                                BdStatisticsManager.getInstance().alert(BdStatsConstant.AlertTypeKey.ALERT_IMG, "imgFailedCnt_" + String.valueOf(cYJ) + "_url=" + str2);
                            }
                        }
                        a2.failnum++;
                        cYK.cYP = false;
                    }
                }
                int aFY = cYK.aFY();
                if (aFY > 100 || (aFY > 0 && z8 != cYK.cYP)) {
                    aFR();
                }
            }
            if (z && z5) {
                if (!isWifiNet || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().cLp) {
                    if (isWifiNet || !com.baidu.adp.lib.util.j.is2GNet() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().cLr) {
                        if (!isWifiNet && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().cLq) {
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
                aVar = gs();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = t.aGb().aGc();
            }
            if (!isCdn || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = t.aGb().tq(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = aFT();
            }
            aVar.append("url", str);
            aVar.append("act", IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS);
            aVar.append("result", z ? "1" : "0");
            aVar.append("requrl", str2);
            aVar.append("netlib", dVar.qY == 0 ? "Apache" : "HttpManager");
            aVar.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
            aVar.append("connTime", String.valueOf(dVar.connectTime));
            aVar.append("rspTime", String.valueOf(dVar.qN));
            aVar.append("retry", String.valueOf(dVar.retry));
            aVar.append("clientIp", d.getIp());
            aVar.append("tiebaIp", str6);
            String tp = t.aGb().tp(str);
            if (!TextUtils.isEmpty(tp)) {
                aVar.append("domainIp", tp);
            }
            aVar.append("wifiDnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.append("connBaidu", String.valueOf(aFU()));
            }
            aVar.append("memory", aFV());
            aVar.append("task", aFW());
            aVar.append("status", String.valueOf(dVar.qQ));
            aVar.append("up", String.valueOf(dVar.qM));
            aVar.append("down", String.valueOf(dVar.downloadSize));
            aVar.append("isCDN", isCdn ? "1" : "0");
            aVar.append("isWebp", bool.booleanValue() ? "1" : "0");
            aVar.append("isMobileProxy", z3 ? "1" : "0");
            aVar.append(com.baidu.fsg.base.statistics.b.k, dVar.exception);
            aVar.append(TiebaInitialize.LogFields.REASON, str3);
            if (i != 0) {
                aVar.append("procType", Integer.valueOf(i));
            }
            if (dVar.qW != null) {
                aVar.append("tracecode1", dVar.qW);
            }
            if (dVar.qX != null) {
                aVar.append("tracecode2", dVar.qX);
            }
            if (!aq.isEmpty(dVar.qR)) {
                aVar.append("directUseIp", dVar.qR);
            } else {
                aVar.append("directUseIp", dVar.qS);
            }
            aVar.append("ipIndex", Integer.valueOf(dVar.qV));
            aVar.append("dnsResolveType", dVar.qT);
            aVar.append("dnsResolveStatus", dVar.qU);
            aVar.append("isUseIpDirectConnect", Boolean.valueOf(dVar.qD));
            BdStatisticsManager.getInstance().debug("img", aVar);
            if (isCdn && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                cYK.cYO++;
            }
        }
    }

    public static void aFR() {
        if (cYK.aFY() > 10) {
            if (cYK.aFX() > 0) {
                a(cYK.cYQ, cYK.cYR, cYK.cYS, cYK.cYU, cYK.cYT, 10000);
                com.baidu.tbadk.n.k.b(cYK.cYQ, cYK.cYR, cYK.cYS, cYK.cYU, cYK.cYT, 3);
            }
            if (cYK.aGa() > 0) {
                a(cYK.cZa, cYK.cZb, cYK.cZc, cYK.cZe, cYK.cZd, 100002);
                com.baidu.tbadk.n.k.b(cYK.cZa, cYK.cZb, cYK.cZc, cYK.cZe, cYK.cZd, 2);
            }
            if (cYK.aFZ() > 0) {
                a(cYK.cYV, cYK.cYW, cYK.cYX, cYK.cYZ, cYK.cYY, 100001);
                com.baidu.tbadk.n.k.b(cYK.cYV, cYK.cYW, cYK.cYX, cYK.cYZ, cYK.cYY, 1);
            }
            cYK.reset();
        }
    }

    public static void a(r rVar, r rVar2, r rVar3, r rVar4, r rVar5, int i) {
        if (rVar != null && rVar2 != null && rVar3 != null && rVar4 != null && rVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = t.aGb().aGc();
            }
            if (cYN != null && TextUtils.isEmpty("")) {
                str2 = t.aGb().tq(cYN);
            }
            if (TextUtils.isEmpty("")) {
                str3 = aFT();
            }
            com.baidu.adp.lib.stats.a gs = gs();
            gs.append("act", "dlStat");
            gs.append("cdnCostTime", String.valueOf(rVar.time));
            gs.append("cdnNum", String.valueOf(rVar.num));
            gs.append("cdnFailnum", String.valueOf(rVar.failnum));
            gs.append("portraitCostTime", String.valueOf(rVar2.time));
            gs.append("portraitNum", String.valueOf(rVar2.num));
            gs.append("portraitFailnum", String.valueOf(rVar2.failnum));
            gs.append("tiebaCostTime", String.valueOf(rVar3.time));
            gs.append("tiebaNum", String.valueOf(rVar3.num));
            gs.append("tiebaFailnum", String.valueOf(rVar3.failnum));
            gs.append("otherCostTime", String.valueOf(rVar5.time));
            gs.append("otherNum", String.valueOf(rVar5.num));
            gs.append("otherFailnum", String.valueOf(rVar5.failnum));
            gs.append("directIpCostTime", String.valueOf(rVar4.time));
            gs.append("directIpNum", String.valueOf(rVar4.num));
            gs.append("directIpFailnum", String.valueOf(rVar4.failnum));
            gs.append("dnsFailNum", String.valueOf(cYK.cYO));
            if (10000 == i) {
                gs.append("isWifi", "1");
                gs.append("netType", "WIFI");
            } else if (100002 == i) {
                gs.append("netType", "3G");
                gs.append("isWifi", "0");
            } else {
                gs.append("netType", "2G");
                gs.append("isWifi", "0");
            }
            gs.append("localIp", d.getIp());
            gs.append("tbIp", str);
            gs.append("cdnIp", str2);
            gs.append("dnsIp", str3);
            BdStatisticsManager.getInstance().debug("img", gs);
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4, com.baidu.adp.lib.network.http.d dVar) {
        if (com.baidu.adp.lib.util.l.isNetOk()) {
            synchronized (syncLock) {
                cYM.num++;
                if (z) {
                    cYM.time += j;
                } else {
                    cYM.failnum++;
                }
                if (cYM.num >= 100) {
                    aFS();
                }
            }
            if (!z) {
                if (aVar == null) {
                    aVar = gs();
                }
                aVar.append("act", "dc");
                aVar.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
                aVar.append("url", str);
                aVar.append("fullURL", str2);
                aVar.append("isWebp", z3 ? "1" : "0");
                aVar.append("isCDN", z2 ? "1" : "0");
                aVar.append("length", String.valueOf(i));
                aVar.append(TiebaInitialize.LogFields.REASON, str3);
                aVar.append("result", z ? "0" : "1");
                aVar.append("execption", str4);
                if (dVar != null) {
                    aVar.append("newDnsIp", dVar.qS);
                    aVar.append("ipIndex", Integer.valueOf(dVar.qV));
                    aVar.append("dnsResolveType", dVar.qT);
                    aVar.append("dnsResolveStatus", dVar.qU);
                    aVar.append("isUseIpDirectConnect", Boolean.valueOf(dVar.qD));
                }
                BdStatisticsManager.getInstance().debug("img", aVar);
            }
        }
    }

    public static void u(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a gs = gs();
        gs.append("act", "ml");
        gs.append("fullURL", str2);
        gs.append("type", str);
        gs.append(TiebaInitialize.LogFields.REASON, str3);
        gs.append("extra", str4);
        BdStatisticsManager.getInstance().debug("img", gs);
    }

    public static void aFS() {
        if (cYM.num > 10) {
            com.baidu.adp.lib.stats.a gs = gs();
            gs.append("act", "dcStat");
            gs.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(cYM.time));
            gs.append("num", String.valueOf(cYM.num));
            gs.append("failnum", String.valueOf(cYM.failnum));
            BdStatisticsManager.getInstance().debug("img", gs);
            com.baidu.tbadk.n.k.b(cYM.num, cYM.failnum, cYM.time);
            cYM.reset();
        }
    }

    public static void to(String str) {
        com.baidu.adp.lib.stats.a gs = gs();
        gs.append("act", "assistant");
        gs.append("content", str);
        BdStatisticsManager.getInstance().debug("img", gs);
    }

    private static String aFT() {
        try {
            DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApp().getSystemService("wifi")).getDhcpInfo();
            return intToIp(dhcpInfo.dns1) + Constants.ACCEPT_TIME_SEPARATOR_SP + intToIp(dhcpInfo.dns2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String intToIp(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [629=5] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long aFU() {
        HttpURLConnection httpURLConnection;
        long j;
        if (cYH >= 3) {
            return cYI;
        }
        long currentTimeMillis = System.currentTimeMillis();
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL("http://www.baidu.com/").openConnection();
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
            com.baidu.adp.lib.f.a.close(httpURLConnection);
            j = currentTimeMillis2;
        } catch (SocketTimeoutException e3) {
            com.baidu.adp.lib.f.a.close(httpURLConnection);
            j = 2500;
            if (j > 0) {
            }
        } catch (Exception e4) {
            httpURLConnection2 = httpURLConnection;
            com.baidu.adp.lib.f.a.close(httpURLConnection2);
            j = -1;
            if (j > 0) {
            }
        } catch (Throwable th2) {
            httpURLConnection2 = httpURLConnection;
            th = th2;
            com.baidu.adp.lib.f.a.close(httpURLConnection2);
            throw th;
        }
        if (j > 0) {
            if (cYH > -1) {
                cYI = ((cYI * cYH) + j) / (cYH + 1);
            } else {
                cYI = j;
            }
            cYH++;
            return j;
        }
        return j;
    }

    private static String aFV() {
        return com.baidu.tbadk.imageManager.c.aPR().toLogString();
    }

    private static String aFW() {
        return com.baidu.adp.lib.asyncTask.a.fq().toLogString();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.a gs = gs();
        gs.append("act", "getCDNList");
        gs.append("errorNum", str);
        gs.append(TiebaInitialize.LogFields.ERROR_MESSAGE, str2);
        gs.append("isShortNetError", z2 ? "1" : "0");
        gs.append("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug("img", gs);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = t.aGb().tq(str);
        }
        String aFT = aFT();
        String ip = d.getIp();
        com.baidu.adp.lib.stats.a gs = gs();
        gs.append("act", "tachometerCDN");
        gs.append("errorNum", str3);
        gs.append("execption", str4);
        gs.append(TiebaInitialize.LogFields.SIZE, str5);
        gs.append("isScuess", z ? "1" : "0");
        gs.append("url", str);
        gs.append("localIp", ip);
        gs.append("cdnIp", str6);
        gs.append("dnsIP", aFT);
        gs.append("usedIp", str2);
        gs.append("isUsedIp", z2 ? "0" : "1");
        gs.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
        BdStatisticsManager.getInstance().debug("img", gs);
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
                    com.baidu.adp.lib.stats.a gs = gs();
                    gs.append("act", "mobileTachometerCDN");
                    gs.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
                    gs.append("ipList", sb.toString());
                    BdStatisticsManager.getInstance().debug("img", gs);
                    return;
                }
            }
        }
    }

    public static void j(boolean z, String str) {
        com.baidu.adp.lib.stats.a gs = gs();
        gs.append("act", "getCDNList");
        gs.append("isSuccess", z ? "1" : "0");
        gs.append(TiebaInitialize.LogFields.ERROR_MESSAGE, str);
        BdStatisticsManager.getInstance().debug("img", gs);
    }

    public static void e(com.baidu.adp.lib.stats.a aVar) {
        aVar.append("act", "tiebaPic");
        BdStatisticsManager.getInstance().debug("img", aVar);
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
