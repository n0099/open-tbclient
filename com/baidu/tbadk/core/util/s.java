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
    private static long cUD = 0;
    private static long cUE = 0;
    private static int cUF = 0;
    private static a cUG = new a();
    private static r cUH = new r();
    private static r cUI = new r();
    private static String cUJ = null;
    private static Object syncLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int cUK;
        boolean cUL;
        r cUM;
        r cUN;
        r cUO;
        r cUP;
        r cUQ;
        r cUR;
        r cUS;
        r cUT;
        r cUU;
        r cUV;
        r cUW;
        r cUX;
        r cUY;
        r cUZ;
        r cVa;

        private a() {
            this.cUK = 0;
            this.cUM = new r();
            this.cUN = new r();
            this.cUO = new r();
            this.cUP = new r();
            this.cUQ = new r();
            this.cUR = new r();
            this.cUS = new r();
            this.cUT = new r();
            this.cUU = new r();
            this.cUV = new r();
            this.cUW = new r();
            this.cUX = new r();
            this.cUY = new r();
            this.cUZ = new r();
            this.cVa = new r();
        }

        public int aDL() {
            return this.cUM.num + this.cUN.num + this.cUO.num + this.cUP.num + this.cUQ.num;
        }

        public int aDM() {
            return this.cUM.num + this.cUN.num + this.cUO.num + this.cUP.num + this.cUQ.num + this.cUR.num + this.cUS.num + this.cUT.num + this.cUU.num + this.cUV.num + this.cUW.num + this.cUX.num + this.cUY.num + this.cUZ.num + this.cVa.num;
        }

        public int aDN() {
            return this.cUR.num + this.cUS.num + this.cUT.num + this.cUU.num + this.cUV.num;
        }

        public int aDO() {
            return this.cUW.num + this.cUX.num + this.cUY.num + this.cUZ.num + this.cVa.num;
        }

        public void reset() {
            this.cUK = 0;
            this.cUM.reset();
            this.cUN.reset();
            this.cUO.reset();
            this.cUP.reset();
            this.cUQ.reset();
            this.cUR.reset();
            this.cUS.reset();
            this.cUT.reset();
            this.cUU.reset();
            this.cUV.reset();
            this.cUW.reset();
            this.cUX.reset();
            this.cUY.reset();
            this.cUZ.reset();
            this.cVa.reset();
        }
    }

    private static r a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return cUG.cUM;
            }
            if (str.startsWith("http://tb.himg")) {
                return cUG.cUN;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return cUG.cUO;
            }
            if (z2 && z3) {
                return cUG.cUQ;
            }
            return cUG.cUP;
        } else if (com.baidu.adp.lib.util.j.is2GNet()) {
            if (z2) {
                return cUG.cUR;
            }
            if (str.startsWith("http://tb.himg")) {
                return cUG.cUS;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return cUG.cUT;
            }
            return cUG.cUU;
        } else if (z2) {
            return cUG.cUW;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return cUG.cUX;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return cUG.cUY;
            }
            return cUG.cUZ;
        }
    }

    public static com.baidu.adp.lib.stats.a gs() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (syncLock) {
                cUH.num++;
                cUH.time += j;
                if (cUH.num >= 100) {
                    aDE();
                }
            }
        }
    }

    public static void aDE() {
        if (cUH.num > 10) {
            com.baidu.adp.lib.stats.a gs = gs();
            gs.append("act", "locStat");
            gs.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(cUH.time));
            gs.append("num", String.valueOf(cUH.num));
            gs.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", gs);
            cUH.reset();
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
                if (!com.baidu.tbadk.core.util.a.e.getInstance().cWK) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean isWifiNet = com.baidu.adp.lib.util.j.isWifiNet();
            if (!z5) {
                z4 = false;
            } else if (isWifiNet) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().cHk);
            } else if (com.baidu.adp.lib.util.j.is2GNet()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().cHm);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().cHl);
            }
            boolean z6 = false;
            if (isCdn && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (isCdn && isWifiNet && z6) {
                if (z) {
                    p.getInstance().insertNormalData(j, str);
                } else {
                    str6 = t.aDP().aDQ();
                    if (!TextUtils.isEmpty(str6)) {
                        p.getInstance().insertErrorData(dVar.qO, str);
                    }
                }
            }
            if (isCdn) {
                cUJ = str;
            }
            boolean z7 = false;
            if (dVar.qQ != null && dVar.qQ.length() > 0) {
                z7 = true;
            }
            synchronized (syncLock) {
                r a2 = a(isWifiNet, isCdn, str2, z7);
                boolean z8 = cUG.cUL;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.downloadSize += j2;
                        cUG.cUL = true;
                        if (z4) {
                            a2.slownum++;
                        }
                        cUF = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            int i2 = cUF + 1;
                            cUF = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.hd().getMaxAlertCount(BdStatsConstant.AlertTypeKey.ALERT_IMG, 5)) {
                                BdStatisticsManager.getInstance().alert(BdStatsConstant.AlertTypeKey.ALERT_IMG, "imgFailedCnt_" + String.valueOf(cUF) + "_url=" + str2);
                            }
                        }
                        a2.failnum++;
                        cUG.cUL = false;
                    }
                }
                int aDM = cUG.aDM();
                if (aDM > 100 || (aDM > 0 && z8 != cUG.cUL)) {
                    aDF();
                }
            }
            if (z && z5) {
                if (!isWifiNet || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().cHk) {
                    if (isWifiNet || !com.baidu.adp.lib.util.j.is2GNet() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().cHm) {
                        if (!isWifiNet && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().cHl) {
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
                str6 = t.aDP().aDQ();
            }
            if (!isCdn || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = t.aDP().ta(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = aDH();
            }
            aVar.append("url", str);
            aVar.append("act", IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS);
            aVar.append("result", z ? "1" : "0");
            aVar.append("requrl", str2);
            aVar.append("netlib", dVar.qX == 0 ? "Apache" : "HttpManager");
            aVar.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
            aVar.append("connTime", String.valueOf(dVar.connectTime));
            aVar.append("rspTime", String.valueOf(dVar.qM));
            aVar.append("retry", String.valueOf(dVar.retry));
            aVar.append("clientIp", d.getIp());
            aVar.append("tiebaIp", str6);
            String sZ = t.aDP().sZ(str);
            if (!TextUtils.isEmpty(sZ)) {
                aVar.append("domainIp", sZ);
            }
            aVar.append("wifiDnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.append("connBaidu", String.valueOf(aDI()));
            }
            aVar.append("memory", aDJ());
            aVar.append("task", aDK());
            aVar.append("status", String.valueOf(dVar.qP));
            if (!TextUtils.isEmpty(dVar.redirectUrl)) {
                aVar.append("redirectUrl", dVar.redirectUrl);
            }
            aVar.append("up", String.valueOf(dVar.qL));
            aVar.append("down", String.valueOf(dVar.downloadSize));
            aVar.append("isCDN", isCdn ? "1" : "0");
            aVar.append("isWebp", bool.booleanValue() ? "1" : "0");
            aVar.append("isMobileProxy", z3 ? "1" : "0");
            aVar.append(com.baidu.fsg.base.statistics.b.k, dVar.exception);
            aVar.append(TiebaInitialize.LogFields.REASON, str3);
            if (i != 0) {
                aVar.append("procType", Integer.valueOf(i));
            }
            if (dVar.qV != null) {
                aVar.append("tracecode1", dVar.qV);
            }
            if (dVar.qW != null) {
                aVar.append("tracecode2", dVar.qW);
            }
            if (!aq.isEmpty(dVar.qQ)) {
                aVar.append("directUseIp", dVar.qQ);
            } else {
                aVar.append("directUseIp", dVar.qR);
            }
            aVar.append("dnsResolveType", dVar.qS);
            aVar.append("dnsResolveStatus", dVar.qT);
            aVar.append("isUseIpDirectConnect", Boolean.valueOf(dVar.qC));
            BdStatisticsManager.getInstance().debug("img", aVar);
            if (isCdn && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                cUG.cUK++;
            }
        }
    }

    public static void aDF() {
        if (cUG.aDM() > 10) {
            if (cUG.aDL() > 0) {
                a(cUG.cUM, cUG.cUN, cUG.cUO, cUG.cUQ, cUG.cUP, 10000);
                com.baidu.tbadk.n.k.b(cUG.cUM, cUG.cUN, cUG.cUO, cUG.cUQ, cUG.cUP, 3);
            }
            if (cUG.aDO() > 0) {
                a(cUG.cUW, cUG.cUX, cUG.cUY, cUG.cVa, cUG.cUZ, 100002);
                com.baidu.tbadk.n.k.b(cUG.cUW, cUG.cUX, cUG.cUY, cUG.cVa, cUG.cUZ, 2);
            }
            if (cUG.aDN() > 0) {
                a(cUG.cUR, cUG.cUS, cUG.cUT, cUG.cUV, cUG.cUU, 100001);
                com.baidu.tbadk.n.k.b(cUG.cUR, cUG.cUS, cUG.cUT, cUG.cUV, cUG.cUU, 1);
            }
            cUG.reset();
        }
    }

    public static void a(r rVar, r rVar2, r rVar3, r rVar4, r rVar5, int i) {
        if (rVar != null && rVar2 != null && rVar3 != null && rVar4 != null && rVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = t.aDP().aDQ();
            }
            if (cUJ != null && TextUtils.isEmpty("")) {
                str2 = t.aDP().ta(cUJ);
            }
            if (TextUtils.isEmpty("")) {
                str3 = aDH();
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
            gs.append("dnsFailNum", String.valueOf(cUG.cUK));
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
                cUI.num++;
                if (z) {
                    cUI.time += j;
                } else {
                    cUI.failnum++;
                }
                if (cUI.num >= 100) {
                    aDG();
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
                    aVar.append("newDnsIp", dVar.qR);
                    aVar.append("ipIndex", Integer.valueOf(dVar.qU));
                    aVar.append("dnsResolveType", dVar.qS);
                    aVar.append("dnsResolveStatus", dVar.qT);
                    aVar.append("isUseIpDirectConnect", Boolean.valueOf(dVar.qC));
                }
                BdStatisticsManager.getInstance().debug("img", aVar);
            }
        }
    }

    public static void r(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a gs = gs();
        gs.append("act", "ml");
        gs.append("fullURL", str2);
        gs.append("type", str);
        gs.append(TiebaInitialize.LogFields.REASON, str3);
        gs.append("extra", str4);
        BdStatisticsManager.getInstance().debug("img", gs);
    }

    public static void aDG() {
        if (cUI.num > 10) {
            com.baidu.adp.lib.stats.a gs = gs();
            gs.append("act", "dcStat");
            gs.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(cUI.time));
            gs.append("num", String.valueOf(cUI.num));
            gs.append("failnum", String.valueOf(cUI.failnum));
            BdStatisticsManager.getInstance().debug("img", gs);
            com.baidu.tbadk.n.k.b(cUI.num, cUI.failnum, cUI.time);
            cUI.reset();
        }
    }

    public static void sY(String str) {
        com.baidu.adp.lib.stats.a gs = gs();
        gs.append("act", "assistant");
        gs.append("content", str);
        BdStatisticsManager.getInstance().debug("img", gs);
    }

    private static String aDH() {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [631=5] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long aDI() {
        HttpURLConnection httpURLConnection;
        long j;
        if (cUD >= 3) {
            return cUE;
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
            if (cUD > -1) {
                cUE = ((cUE * cUD) + j) / (cUD + 1);
            } else {
                cUE = j;
            }
            cUD++;
            return j;
        }
        return j;
    }

    private static String aDJ() {
        return com.baidu.tbadk.imageManager.c.aNs().toLogString();
    }

    private static String aDK() {
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
            str6 = t.aDP().ta(str);
        }
        String aDH = aDH();
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
        gs.append("dnsIP", aDH);
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

    public static void i(boolean z, String str) {
        com.baidu.adp.lib.stats.a gs = gs();
        gs.append("act", "getCDNList");
        gs.append("isSuccess", z ? "1" : "0");
        gs.append(TiebaInitialize.LogFields.ERROR_MESSAGE, str);
        BdStatisticsManager.getInstance().debug("img", gs);
    }

    public static void d(com.baidu.adp.lib.stats.a aVar) {
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
