package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.searchbox.ng.ai.apps.media.chooser.action.ChooseVideoAction;
import com.baidu.searchbox.ng.ai.apps.network.WebSocketAction;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.tencent.open.SocialConstants;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class s {
    private static long awI = 0;
    private static long awJ = 0;
    private static int awK = 0;
    private static a awL = new a();
    private static r awM = new r();
    private static r awN = new r();
    private static String awO = null;
    private static Object syncLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int awP;
        boolean awQ;
        r awR;
        r awS;
        r awT;
        r awU;
        r awV;
        r awW;
        r awX;
        r awY;
        r awZ;
        r axa;
        r axb;
        r axc;
        r axd;
        r axe;
        r axf;

        private a() {
            this.awP = 0;
            this.awR = new r();
            this.awS = new r();
            this.awT = new r();
            this.awU = new r();
            this.awV = new r();
            this.awW = new r();
            this.awX = new r();
            this.awY = new r();
            this.awZ = new r();
            this.axa = new r();
            this.axb = new r();
            this.axc = new r();
            this.axd = new r();
            this.axe = new r();
            this.axf = new r();
        }

        public int BS() {
            return this.awR.num + this.awS.num + this.awT.num + this.awU.num + this.awV.num;
        }

        public int BT() {
            return this.awR.num + this.awS.num + this.awT.num + this.awU.num + this.awV.num + this.awW.num + this.awX.num + this.awY.num + this.awZ.num + this.axa.num + this.axb.num + this.axc.num + this.axd.num + this.axe.num + this.axf.num;
        }

        public int BU() {
            return this.awW.num + this.awX.num + this.awY.num + this.awZ.num + this.axa.num;
        }

        public int BV() {
            return this.axb.num + this.axc.num + this.axd.num + this.axe.num + this.axf.num;
        }

        public void reset() {
            this.awP = 0;
            this.awR.reset();
            this.awS.reset();
            this.awT.reset();
            this.awU.reset();
            this.awV.reset();
            this.awW.reset();
            this.awX.reset();
            this.awY.reset();
            this.awZ.reset();
            this.axa.reset();
            this.axb.reset();
            this.axc.reset();
            this.axd.reset();
            this.axe.reset();
            this.axf.reset();
        }
    }

    private static r a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return awL.awR;
            }
            if (str.startsWith("http://tb.himg")) {
                return awL.awS;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return awL.awT;
            }
            if (z2 && z3) {
                return awL.awV;
            }
            return awL.awU;
        } else if (com.baidu.adp.lib.util.j.la()) {
            if (z2) {
                return awL.awW;
            }
            if (str.startsWith("http://tb.himg")) {
                return awL.awX;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return awL.awY;
            }
            return awL.awZ;
        } else if (z2) {
            return awL.axb;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return awL.axc;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return awL.axd;
            }
            return awL.axe;
        }
    }

    public static com.baidu.adp.lib.stats.a jB() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (syncLock) {
                awM.num++;
                awM.time += j;
                if (awM.num >= 100) {
                    BL();
                }
            }
        }
    }

    public static void BL() {
        if (awM.num > 10) {
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append(SocialConstants.PARAM_ACT, "locStat");
            jB.append("costTime", String.valueOf(awM.time));
            jB.append("num", String.valueOf(awM.num));
            jB.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jB);
            awM.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.l.lm() && dVar != null) {
            String str6 = "";
            boolean ij = com.baidu.tbadk.util.i.ij(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().azW) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean kW = com.baidu.adp.lib.util.j.kW();
            if (!z5) {
                z4 = false;
            } else if (kW) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().ajJ);
            } else if (com.baidu.adp.lib.util.j.la()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().ajL);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().ajK);
            }
            boolean z6 = false;
            if (ij && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (ij && kW && z6) {
                if (z) {
                    p.getInstance().insertNormalData(j, str);
                } else {
                    str6 = t.BW().BX();
                    if (!TextUtils.isEmpty(str6)) {
                        p.getInstance().insertErrorData(dVar.CM, str);
                    }
                }
            }
            if (ij) {
                awO = str;
            }
            boolean z7 = false;
            if (dVar.CO != null && dVar.CO.length() > 0) {
                z7 = true;
            }
            synchronized (syncLock) {
                r a2 = a(kW, ij, str2, z7);
                boolean z8 = awL.awQ;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.CG += j2;
                        awL.awQ = true;
                        if (z4) {
                            a2.awH++;
                        }
                        awK = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.kV()) {
                            int i2 = awK + 1;
                            awK = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.ko().getMaxAlertCount("alert_img", 5)) {
                                BdStatisticsManager.getInstance().alert("alert_img", "imgFailedCnt_" + String.valueOf(awK) + "_url=" + str2);
                            }
                        }
                        a2.awG++;
                        awL.awQ = false;
                    }
                }
                int BT = awL.BT();
                if (BT > 100 || (BT > 0 && z8 != awL.awQ)) {
                    BM();
                }
            }
            if (z && z5) {
                if (!kW || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().ajJ) {
                    if (kW || !com.baidu.adp.lib.util.j.la() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().ajL) {
                        if (!kW && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().ajK) {
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
                aVar = jB();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = t.BW().BX();
            }
            if (!ij || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = t.BW().fe(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = BO();
            }
            aVar.append("url", str);
            aVar.append(SocialConstants.PARAM_ACT, "dl");
            aVar.append("result", z ? "1" : "0");
            aVar.append("fullurl", str2);
            aVar.append("netlib", String.valueOf(dVar.CU));
            aVar.append("costTime", String.valueOf(j));
            aVar.append("connTime", String.valueOf(dVar.connectTime));
            aVar.append("rspTime", String.valueOf(dVar.CH));
            aVar.append("retry", String.valueOf(dVar.CI));
            aVar.append("localIp", d.getIp());
            aVar.append("tiebaIp", str6);
            aVar.append("cdnIp", str4);
            aVar.append("useIp", dVar.CO);
            aVar.append("dnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.append("connBaidu", String.valueOf(BP()));
            }
            aVar.append("memory", BQ());
            aVar.append(WebSocketAction.PARAM_KEY_TASK, BR());
            aVar.append("status", String.valueOf(dVar.CN));
            aVar.append("up", String.valueOf(dVar.CF));
            aVar.append("down", String.valueOf(dVar.CG));
            aVar.append("isCDN", ij ? "1" : "0");
            aVar.append("isWebp", bool.booleanValue() ? "1" : "0");
            aVar.append("isMobileProxy", z3 ? "1" : "0");
            aVar.append(com.baidu.fsg.base.statistics.b.k, dVar.CL);
            aVar.append(WebSocketAction.PARAM_KEY_REASON, str3);
            if (i != 0) {
                aVar.f("procType", Integer.valueOf(i));
            }
            if (dVar.CQ != null) {
                aVar.append("tracecode1", dVar.CQ);
            }
            if (dVar.CT != null) {
                aVar.append("tracecode2", dVar.CT);
            }
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, aVar);
            if (ij && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                awL.awP++;
            }
        }
    }

    public static void BM() {
        if (awL.BT() > 10) {
            if (awL.BS() > 0) {
                a(awL.awR, awL.awS, awL.awT, awL.awV, awL.awU, 10000);
                com.baidu.tbadk.l.k.b(awL.awR, awL.awS, awL.awT, awL.awV, awL.awU, 3);
            }
            if (awL.BV() > 0) {
                a(awL.axb, awL.axc, awL.axd, awL.axf, awL.axe, 100002);
                com.baidu.tbadk.l.k.b(awL.axb, awL.axc, awL.axd, awL.axf, awL.axe, 2);
            }
            if (awL.BU() > 0) {
                a(awL.awW, awL.awX, awL.awY, awL.axa, awL.awZ, 100001);
                com.baidu.tbadk.l.k.b(awL.awW, awL.awX, awL.awY, awL.axa, awL.awZ, 1);
            }
            awL.reset();
        }
    }

    public static void a(r rVar, r rVar2, r rVar3, r rVar4, r rVar5, int i) {
        if (rVar != null && rVar2 != null && rVar3 != null && rVar4 != null && rVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = t.BW().BX();
            }
            if (awO != null && TextUtils.isEmpty("")) {
                str2 = t.BW().fe(awO);
            }
            if (TextUtils.isEmpty("")) {
                str3 = BO();
            }
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append(SocialConstants.PARAM_ACT, "dlStat");
            jB.append("cdnCostTime", String.valueOf(rVar.time));
            jB.append("cdnNum", String.valueOf(rVar.num));
            jB.append("cdnFailnum", String.valueOf(rVar.awG));
            jB.append("portraitCostTime", String.valueOf(rVar2.time));
            jB.append("portraitNum", String.valueOf(rVar2.num));
            jB.append("portraitFailnum", String.valueOf(rVar2.awG));
            jB.append("tiebaCostTime", String.valueOf(rVar3.time));
            jB.append("tiebaNum", String.valueOf(rVar3.num));
            jB.append("tiebaFailnum", String.valueOf(rVar3.awG));
            jB.append("otherCostTime", String.valueOf(rVar5.time));
            jB.append("otherNum", String.valueOf(rVar5.num));
            jB.append("otherFailnum", String.valueOf(rVar5.awG));
            jB.append("directIpCostTime", String.valueOf(rVar4.time));
            jB.append("directIpNum", String.valueOf(rVar4.num));
            jB.append("directIpFailnum", String.valueOf(rVar4.awG));
            jB.append("dnsFailNum", String.valueOf(awL.awP));
            if (10000 == i) {
                jB.append("isWifi", "1");
                jB.append("netType", "WIFI");
            } else if (100002 == i) {
                jB.append("netType", "3G");
                jB.append("isWifi", "0");
            } else {
                jB.append("netType", "2G");
                jB.append("isWifi", "0");
            }
            jB.append("localIp", d.getIp());
            jB.append("tbIp", str);
            jB.append("cdnIp", str2);
            jB.append("dnsIp", str3);
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jB);
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.l.lm()) {
            synchronized (syncLock) {
                awN.num++;
                if (z) {
                    awN.time += j;
                } else {
                    awN.awG++;
                }
                if (awN.num >= 100) {
                    BN();
                }
            }
            if (!z) {
                if (aVar == null) {
                    aVar = jB();
                }
                aVar.append(SocialConstants.PARAM_ACT, "dc");
                aVar.append("costTime", String.valueOf(j));
                aVar.append("url", str);
                aVar.append("fullURL", str2);
                aVar.append("isWebp", z3 ? "1" : "0");
                aVar.append("isCDN", z2 ? "1" : "0");
                aVar.append("length", String.valueOf(i));
                aVar.append(WebSocketAction.PARAM_KEY_REASON, str3);
                aVar.append("result", z ? "0" : "1");
                aVar.append("execption", str4);
                BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, aVar);
            }
        }
    }

    public static void BN() {
        if (awN.num > 10) {
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append(SocialConstants.PARAM_ACT, "dcStat");
            jB.append("costTime", String.valueOf(awN.time));
            jB.append("num", String.valueOf(awN.num));
            jB.append("failnum", String.valueOf(awN.awG));
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jB);
            com.baidu.tbadk.l.k.a(awN.num, awN.awG, awN.time);
            awN.reset();
        }
    }

    public static void fd(String str) {
        com.baidu.adp.lib.stats.a jB = jB();
        jB.append(SocialConstants.PARAM_ACT, "assistant");
        jB.append("content", str);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jB);
    }

    private static String BO() {
        try {
            DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApp().getSystemService("wifi")).getDhcpInfo();
            return intToIp(dhcpInfo.dns1) + "," + intToIp(dhcpInfo.dns2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String intToIp(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [599=5] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long BP() {
        HttpURLConnection httpURLConnection;
        long j;
        if (awI >= 3) {
            return awJ;
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
            com.baidu.adp.lib.g.a.h(httpURLConnection);
            j = currentTimeMillis2;
        } catch (SocketTimeoutException e3) {
            com.baidu.adp.lib.g.a.h(httpURLConnection);
            j = 2500;
            if (j > 0) {
            }
        } catch (Exception e4) {
            httpURLConnection2 = httpURLConnection;
            com.baidu.adp.lib.g.a.h(httpURLConnection2);
            j = -1;
            if (j > 0) {
            }
        } catch (Throwable th2) {
            httpURLConnection2 = httpURLConnection;
            th = th2;
            com.baidu.adp.lib.g.a.h(httpURLConnection2);
            throw th;
        }
        if (j > 0) {
            if (awI > -1) {
                awJ = ((awJ * awI) + j) / (awI + 1);
            } else {
                awJ = j;
            }
            awI++;
            return j;
        }
        return j;
    }

    private static String BQ() {
        return com.baidu.tbadk.imageManager.c.Mq().ib();
    }

    private static String BR() {
        return com.baidu.adp.lib.asyncTask.a.ic().ib();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.a jB = jB();
        jB.append(SocialConstants.PARAM_ACT, "getCDNList");
        jB.append("errorNum", str);
        jB.append("errorMsg", str2);
        jB.append("isShortNetError", z2 ? "1" : "0");
        jB.append("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jB);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = t.BW().fe(str);
        }
        String BO = BO();
        String ip = d.getIp();
        com.baidu.adp.lib.stats.a jB = jB();
        jB.append(SocialConstants.PARAM_ACT, "tachometerCDN");
        jB.append("errorNum", str3);
        jB.append("execption", str4);
        jB.append(ChooseVideoAction.CB_KEY_SIZE, str5);
        jB.append("isScuess", z ? "1" : "0");
        jB.append("url", str);
        jB.append("localIp", ip);
        jB.append("cdnIp", str6);
        jB.append("dnsIP", BO);
        jB.append("usedIp", str2);
        jB.append("isUsedIp", z2 ? "0" : "1");
        jB.append("costTime", String.valueOf(j));
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jB);
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
                    com.baidu.adp.lib.stats.a jB = jB();
                    jB.append(SocialConstants.PARAM_ACT, "mobileTachometerCDN");
                    jB.append("costTime", String.valueOf(j));
                    jB.append("ipList", sb.toString());
                    BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jB);
                    return;
                }
            }
        }
    }

    public static void c(boolean z, String str) {
        com.baidu.adp.lib.stats.a jB = jB();
        jB.append(SocialConstants.PARAM_ACT, "getCDNList");
        jB.append("isSuccess", z ? "1" : "0");
        jB.append("errorMsg", str);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jB);
    }

    public static void b(String str, int i, int i2, int i3) {
        if (i == -1) {
            i = 0;
        }
        if (i2 == -1) {
            i2 = 0;
        }
        BdStatisticsManager.getInstance().eventStat(null, str, "imgHttpSwitch", 1, "1sterrcode", String.valueOf(i), "2nderrcode", String.valueOf(i2), "2imgFailed", String.valueOf(i3));
    }
}
