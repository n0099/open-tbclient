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
    private static long cUt = 0;
    private static long cUu = 0;
    private static int cUv = 0;
    private static a cUw = new a();
    private static r cUx = new r();
    private static r cUy = new r();
    private static String cUz = null;
    private static Object syncLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int cUA;
        boolean cUB;
        r cUC;
        r cUD;
        r cUE;
        r cUF;
        r cUG;
        r cUH;
        r cUI;
        r cUJ;
        r cUK;
        r cUL;
        r cUM;
        r cUN;
        r cUO;
        r cUP;
        r cUQ;

        private a() {
            this.cUA = 0;
            this.cUC = new r();
            this.cUD = new r();
            this.cUE = new r();
            this.cUF = new r();
            this.cUG = new r();
            this.cUH = new r();
            this.cUI = new r();
            this.cUJ = new r();
            this.cUK = new r();
            this.cUL = new r();
            this.cUM = new r();
            this.cUN = new r();
            this.cUO = new r();
            this.cUP = new r();
            this.cUQ = new r();
        }

        public int aDs() {
            return this.cUC.num + this.cUD.num + this.cUE.num + this.cUF.num + this.cUG.num;
        }

        public int aDt() {
            return this.cUC.num + this.cUD.num + this.cUE.num + this.cUF.num + this.cUG.num + this.cUH.num + this.cUI.num + this.cUJ.num + this.cUK.num + this.cUL.num + this.cUM.num + this.cUN.num + this.cUO.num + this.cUP.num + this.cUQ.num;
        }

        public int aDu() {
            return this.cUH.num + this.cUI.num + this.cUJ.num + this.cUK.num + this.cUL.num;
        }

        public int aDv() {
            return this.cUM.num + this.cUN.num + this.cUO.num + this.cUP.num + this.cUQ.num;
        }

        public void reset() {
            this.cUA = 0;
            this.cUC.reset();
            this.cUD.reset();
            this.cUE.reset();
            this.cUF.reset();
            this.cUG.reset();
            this.cUH.reset();
            this.cUI.reset();
            this.cUJ.reset();
            this.cUK.reset();
            this.cUL.reset();
            this.cUM.reset();
            this.cUN.reset();
            this.cUO.reset();
            this.cUP.reset();
            this.cUQ.reset();
        }
    }

    private static r a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return cUw.cUC;
            }
            if (str.startsWith("http://tb.himg")) {
                return cUw.cUD;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return cUw.cUE;
            }
            if (z2 && z3) {
                return cUw.cUG;
            }
            return cUw.cUF;
        } else if (com.baidu.adp.lib.util.j.is2GNet()) {
            if (z2) {
                return cUw.cUH;
            }
            if (str.startsWith("http://tb.himg")) {
                return cUw.cUI;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return cUw.cUJ;
            }
            return cUw.cUK;
        } else if (z2) {
            return cUw.cUM;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return cUw.cUN;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return cUw.cUO;
            }
            return cUw.cUP;
        }
    }

    public static com.baidu.adp.lib.stats.a gt() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (syncLock) {
                cUx.num++;
                cUx.time += j;
                if (cUx.num >= 100) {
                    aDl();
                }
            }
        }
    }

    public static void aDl() {
        if (cUx.num > 10) {
            com.baidu.adp.lib.stats.a gt = gt();
            gt.append("act", "locStat");
            gt.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(cUx.time));
            gt.append("num", String.valueOf(cUx.num));
            gt.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", gt);
            cUx.reset();
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
                if (!com.baidu.tbadk.core.util.a.e.getInstance().cWA) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean isWifiNet = com.baidu.adp.lib.util.j.isWifiNet();
            if (!z5) {
                z4 = false;
            } else if (isWifiNet) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().cGY);
            } else if (com.baidu.adp.lib.util.j.is2GNet()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().cHa);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().cGZ);
            }
            boolean z6 = false;
            if (isCdn && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (isCdn && isWifiNet && z6) {
                if (z) {
                    p.getInstance().insertNormalData(j, str);
                } else {
                    str6 = t.aDw().aDx();
                    if (!TextUtils.isEmpty(str6)) {
                        p.getInstance().insertErrorData(dVar.qQ, str);
                    }
                }
            }
            if (isCdn) {
                cUz = str;
            }
            boolean z7 = false;
            if (dVar.qS != null && dVar.qS.length() > 0) {
                z7 = true;
            }
            synchronized (syncLock) {
                r a2 = a(isWifiNet, isCdn, str2, z7);
                boolean z8 = cUw.cUB;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.downloadSize += j2;
                        cUw.cUB = true;
                        if (z4) {
                            a2.slownum++;
                        }
                        cUv = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            int i2 = cUv + 1;
                            cUv = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.he().getMaxAlertCount(BdStatsConstant.AlertTypeKey.ALERT_IMG, 5)) {
                                BdStatisticsManager.getInstance().alert(BdStatsConstant.AlertTypeKey.ALERT_IMG, "imgFailedCnt_" + String.valueOf(cUv) + "_url=" + str2);
                            }
                        }
                        a2.failnum++;
                        cUw.cUB = false;
                    }
                }
                int aDt = cUw.aDt();
                if (aDt > 100 || (aDt > 0 && z8 != cUw.cUB)) {
                    aDm();
                }
            }
            if (z && z5) {
                if (!isWifiNet || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().cGY) {
                    if (isWifiNet || !com.baidu.adp.lib.util.j.is2GNet() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().cHa) {
                        if (!isWifiNet && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().cGZ) {
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
                aVar = gt();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = t.aDw().aDx();
            }
            if (!isCdn || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = t.aDw().sX(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = aDo();
            }
            aVar.append("url", str);
            aVar.append("act", IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS);
            aVar.append("result", z ? "1" : "0");
            aVar.append("requrl", str2);
            aVar.append("netlib", dVar.qY == 0 ? "Apache" : "HttpManager");
            aVar.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
            aVar.append("connTime", String.valueOf(dVar.connectTime));
            aVar.append("rspTime", String.valueOf(dVar.qO));
            aVar.append("retry", String.valueOf(dVar.retry));
            aVar.append("clientIp", d.getIp());
            aVar.append("tiebaIp", str6);
            String sW = t.aDw().sW(str);
            if (!TextUtils.isEmpty(sW)) {
                aVar.append("domainIp", sW);
            }
            aVar.append("wifiDnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.append("connBaidu", String.valueOf(aDp()));
            }
            aVar.append("memory", aDq());
            aVar.append("task", aDr());
            aVar.append("status", String.valueOf(dVar.qR));
            aVar.append("up", String.valueOf(dVar.qN));
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
            if (!aq.isEmpty(dVar.qS)) {
                aVar.append("directUseIp", dVar.qS);
            } else {
                aVar.append("directUseIp", dVar.qT);
            }
            aVar.append("dnsResolveType", dVar.qU);
            aVar.append("dnsResolveStatus", dVar.qV);
            aVar.append("isUseIpDirectConnect", Boolean.valueOf(dVar.qF));
            BdStatisticsManager.getInstance().debug("img", aVar);
            if (isCdn && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                cUw.cUA++;
            }
        }
    }

    public static void aDm() {
        if (cUw.aDt() > 10) {
            if (cUw.aDs() > 0) {
                a(cUw.cUC, cUw.cUD, cUw.cUE, cUw.cUG, cUw.cUF, 10000);
                com.baidu.tbadk.n.k.b(cUw.cUC, cUw.cUD, cUw.cUE, cUw.cUG, cUw.cUF, 3);
            }
            if (cUw.aDv() > 0) {
                a(cUw.cUM, cUw.cUN, cUw.cUO, cUw.cUQ, cUw.cUP, 100002);
                com.baidu.tbadk.n.k.b(cUw.cUM, cUw.cUN, cUw.cUO, cUw.cUQ, cUw.cUP, 2);
            }
            if (cUw.aDu() > 0) {
                a(cUw.cUH, cUw.cUI, cUw.cUJ, cUw.cUL, cUw.cUK, 100001);
                com.baidu.tbadk.n.k.b(cUw.cUH, cUw.cUI, cUw.cUJ, cUw.cUL, cUw.cUK, 1);
            }
            cUw.reset();
        }
    }

    public static void a(r rVar, r rVar2, r rVar3, r rVar4, r rVar5, int i) {
        if (rVar != null && rVar2 != null && rVar3 != null && rVar4 != null && rVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = t.aDw().aDx();
            }
            if (cUz != null && TextUtils.isEmpty("")) {
                str2 = t.aDw().sX(cUz);
            }
            if (TextUtils.isEmpty("")) {
                str3 = aDo();
            }
            com.baidu.adp.lib.stats.a gt = gt();
            gt.append("act", "dlStat");
            gt.append("cdnCostTime", String.valueOf(rVar.time));
            gt.append("cdnNum", String.valueOf(rVar.num));
            gt.append("cdnFailnum", String.valueOf(rVar.failnum));
            gt.append("portraitCostTime", String.valueOf(rVar2.time));
            gt.append("portraitNum", String.valueOf(rVar2.num));
            gt.append("portraitFailnum", String.valueOf(rVar2.failnum));
            gt.append("tiebaCostTime", String.valueOf(rVar3.time));
            gt.append("tiebaNum", String.valueOf(rVar3.num));
            gt.append("tiebaFailnum", String.valueOf(rVar3.failnum));
            gt.append("otherCostTime", String.valueOf(rVar5.time));
            gt.append("otherNum", String.valueOf(rVar5.num));
            gt.append("otherFailnum", String.valueOf(rVar5.failnum));
            gt.append("directIpCostTime", String.valueOf(rVar4.time));
            gt.append("directIpNum", String.valueOf(rVar4.num));
            gt.append("directIpFailnum", String.valueOf(rVar4.failnum));
            gt.append("dnsFailNum", String.valueOf(cUw.cUA));
            if (10000 == i) {
                gt.append("isWifi", "1");
                gt.append("netType", "WIFI");
            } else if (100002 == i) {
                gt.append("netType", "3G");
                gt.append("isWifi", "0");
            } else {
                gt.append("netType", "2G");
                gt.append("isWifi", "0");
            }
            gt.append("localIp", d.getIp());
            gt.append("tbIp", str);
            gt.append("cdnIp", str2);
            gt.append("dnsIp", str3);
            BdStatisticsManager.getInstance().debug("img", gt);
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4, com.baidu.adp.lib.network.http.d dVar) {
        if (com.baidu.adp.lib.util.l.isNetOk()) {
            synchronized (syncLock) {
                cUy.num++;
                if (z) {
                    cUy.time += j;
                } else {
                    cUy.failnum++;
                }
                if (cUy.num >= 100) {
                    aDn();
                }
            }
            if (!z) {
                if (aVar == null) {
                    aVar = gt();
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
                    aVar.append("newDnsIp", dVar.qT);
                    aVar.append("dnsResolveType", dVar.qU);
                    aVar.append("dnsResolveStatus", dVar.qV);
                    aVar.append("isUseIpDirectConnect", Boolean.valueOf(dVar.qF));
                }
                BdStatisticsManager.getInstance().debug("img", aVar);
            }
        }
    }

    public static void r(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a gt = gt();
        gt.append("act", "ml");
        gt.append("fullURL", str2);
        gt.append("type", str);
        gt.append(TiebaInitialize.LogFields.REASON, str3);
        gt.append("extra", str4);
        BdStatisticsManager.getInstance().debug("img", gt);
    }

    public static void aDn() {
        if (cUy.num > 10) {
            com.baidu.adp.lib.stats.a gt = gt();
            gt.append("act", "dcStat");
            gt.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(cUy.time));
            gt.append("num", String.valueOf(cUy.num));
            gt.append("failnum", String.valueOf(cUy.failnum));
            BdStatisticsManager.getInstance().debug("img", gt);
            com.baidu.tbadk.n.k.b(cUy.num, cUy.failnum, cUy.time);
            cUy.reset();
        }
    }

    public static void sV(String str) {
        com.baidu.adp.lib.stats.a gt = gt();
        gt.append("act", "assistant");
        gt.append("content", str);
        BdStatisticsManager.getInstance().debug("img", gt);
    }

    private static String aDo() {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [627=5] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long aDp() {
        HttpURLConnection httpURLConnection;
        long j;
        if (cUt >= 3) {
            return cUu;
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
            if (cUt > -1) {
                cUu = ((cUu * cUt) + j) / (cUt + 1);
            } else {
                cUu = j;
            }
            cUt++;
            return j;
        }
        return j;
    }

    private static String aDq() {
        return com.baidu.tbadk.imageManager.c.aMZ().toLogString();
    }

    private static String aDr() {
        return com.baidu.adp.lib.asyncTask.a.fq().toLogString();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.a gt = gt();
        gt.append("act", "getCDNList");
        gt.append("errorNum", str);
        gt.append(TiebaInitialize.LogFields.ERROR_MESSAGE, str2);
        gt.append("isShortNetError", z2 ? "1" : "0");
        gt.append("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug("img", gt);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = t.aDw().sX(str);
        }
        String aDo = aDo();
        String ip = d.getIp();
        com.baidu.adp.lib.stats.a gt = gt();
        gt.append("act", "tachometerCDN");
        gt.append("errorNum", str3);
        gt.append("execption", str4);
        gt.append(TiebaInitialize.LogFields.SIZE, str5);
        gt.append("isScuess", z ? "1" : "0");
        gt.append("url", str);
        gt.append("localIp", ip);
        gt.append("cdnIp", str6);
        gt.append("dnsIP", aDo);
        gt.append("usedIp", str2);
        gt.append("isUsedIp", z2 ? "0" : "1");
        gt.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
        BdStatisticsManager.getInstance().debug("img", gt);
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
                    com.baidu.adp.lib.stats.a gt = gt();
                    gt.append("act", "mobileTachometerCDN");
                    gt.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
                    gt.append("ipList", sb.toString());
                    BdStatisticsManager.getInstance().debug("img", gt);
                    return;
                }
            }
        }
    }

    public static void i(boolean z, String str) {
        com.baidu.adp.lib.stats.a gt = gt();
        gt.append("act", "getCDNList");
        gt.append("isSuccess", z ? "1" : "0");
        gt.append(TiebaInitialize.LogFields.ERROR_MESSAGE, str);
        BdStatisticsManager.getInstance().debug("img", gt);
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
