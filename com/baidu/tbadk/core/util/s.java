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
    private static long aAi = 0;
    private static long aAj = 0;
    private static int aAk = 0;
    private static a aAl = new a();
    private static r aAm = new r();
    private static r aAn = new r();
    private static String aAo = null;
    private static Object syncLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        r aAA;
        r aAB;
        r aAC;
        r aAD;
        r aAE;
        r aAF;
        int aAp;
        boolean aAq;
        r aAr;
        r aAs;
        r aAt;
        r aAu;
        r aAv;
        r aAw;
        r aAx;
        r aAy;
        r aAz;

        private a() {
            this.aAp = 0;
            this.aAr = new r();
            this.aAs = new r();
            this.aAt = new r();
            this.aAu = new r();
            this.aAv = new r();
            this.aAw = new r();
            this.aAx = new r();
            this.aAy = new r();
            this.aAz = new r();
            this.aAA = new r();
            this.aAB = new r();
            this.aAC = new r();
            this.aAD = new r();
            this.aAE = new r();
            this.aAF = new r();
        }

        public int CW() {
            return this.aAr.num + this.aAs.num + this.aAt.num + this.aAu.num + this.aAv.num;
        }

        public int CX() {
            return this.aAr.num + this.aAs.num + this.aAt.num + this.aAu.num + this.aAv.num + this.aAw.num + this.aAx.num + this.aAy.num + this.aAz.num + this.aAA.num + this.aAB.num + this.aAC.num + this.aAD.num + this.aAE.num + this.aAF.num;
        }

        public int CY() {
            return this.aAw.num + this.aAx.num + this.aAy.num + this.aAz.num + this.aAA.num;
        }

        public int CZ() {
            return this.aAB.num + this.aAC.num + this.aAD.num + this.aAE.num + this.aAF.num;
        }

        public void reset() {
            this.aAp = 0;
            this.aAr.reset();
            this.aAs.reset();
            this.aAt.reset();
            this.aAu.reset();
            this.aAv.reset();
            this.aAw.reset();
            this.aAx.reset();
            this.aAy.reset();
            this.aAz.reset();
            this.aAA.reset();
            this.aAB.reset();
            this.aAC.reset();
            this.aAD.reset();
            this.aAE.reset();
            this.aAF.reset();
        }
    }

    private static r a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return aAl.aAr;
            }
            if (str.startsWith("http://tb.himg")) {
                return aAl.aAs;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aAl.aAt;
            }
            if (z2 && z3) {
                return aAl.aAv;
            }
            return aAl.aAu;
        } else if (com.baidu.adp.lib.util.j.la()) {
            if (z2) {
                return aAl.aAw;
            }
            if (str.startsWith("http://tb.himg")) {
                return aAl.aAx;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aAl.aAy;
            }
            return aAl.aAz;
        } else if (z2) {
            return aAl.aAB;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return aAl.aAC;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aAl.aAD;
            }
            return aAl.aAE;
        }
    }

    public static com.baidu.adp.lib.stats.a jB() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (syncLock) {
                aAm.num++;
                aAm.time += j;
                if (aAm.num >= 100) {
                    CP();
                }
            }
        }
    }

    public static void CP() {
        if (aAm.num > 10) {
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append(SocialConstants.PARAM_ACT, "locStat");
            jB.append("costTime", String.valueOf(aAm.time));
            jB.append("num", String.valueOf(aAm.num));
            jB.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jB);
            aAm.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.l.ll() && dVar != null) {
            String str6 = "";
            boolean iC = com.baidu.tbadk.util.i.iC(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().aDx) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean kW = com.baidu.adp.lib.util.j.kW();
            if (!z5) {
                z4 = false;
            } else if (kW) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().anl);
            } else if (com.baidu.adp.lib.util.j.la()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().ann);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().anm);
            }
            boolean z6 = false;
            if (iC && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (iC && kW && z6) {
                if (z) {
                    p.getInstance().insertNormalData(j, str);
                } else {
                    str6 = t.Da().Db();
                    if (!TextUtils.isEmpty(str6)) {
                        p.getInstance().insertErrorData(dVar.CM, str);
                    }
                }
            }
            if (iC) {
                aAo = str;
            }
            boolean z7 = false;
            if (dVar.CO != null && dVar.CO.length() > 0) {
                z7 = true;
            }
            synchronized (syncLock) {
                r a2 = a(kW, iC, str2, z7);
                boolean z8 = aAl.aAq;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.CG += j2;
                        aAl.aAq = true;
                        if (z4) {
                            a2.aAh++;
                        }
                        aAk = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.kV()) {
                            int i2 = aAk + 1;
                            aAk = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.ko().getMaxAlertCount("alert_img", 5)) {
                                BdStatisticsManager.getInstance().alert("alert_img", "imgFailedCnt_" + String.valueOf(aAk) + "_url=" + str2);
                            }
                        }
                        a2.aAg++;
                        aAl.aAq = false;
                    }
                }
                int CX = aAl.CX();
                if (CX > 100 || (CX > 0 && z8 != aAl.aAq)) {
                    CQ();
                }
            }
            if (z && z5) {
                if (!kW || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().anl) {
                    if (kW || !com.baidu.adp.lib.util.j.la() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().ann) {
                        if (!kW && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().anm) {
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
                str6 = t.Da().Db();
            }
            if (!iC || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = t.Da().fw(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = CS();
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
                aVar.append("connBaidu", String.valueOf(CT()));
            }
            aVar.append("memory", CU());
            aVar.append(WebSocketAction.PARAM_KEY_TASK, CV());
            aVar.append("status", String.valueOf(dVar.CN));
            aVar.append("up", String.valueOf(dVar.CF));
            aVar.append("down", String.valueOf(dVar.CG));
            aVar.append("isCDN", iC ? "1" : "0");
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
            if (iC && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                aAl.aAp++;
            }
        }
    }

    public static void CQ() {
        if (aAl.CX() > 10) {
            if (aAl.CW() > 0) {
                a(aAl.aAr, aAl.aAs, aAl.aAt, aAl.aAv, aAl.aAu, 10000);
                com.baidu.tbadk.l.k.b(aAl.aAr, aAl.aAs, aAl.aAt, aAl.aAv, aAl.aAu, 3);
            }
            if (aAl.CZ() > 0) {
                a(aAl.aAB, aAl.aAC, aAl.aAD, aAl.aAF, aAl.aAE, 100002);
                com.baidu.tbadk.l.k.b(aAl.aAB, aAl.aAC, aAl.aAD, aAl.aAF, aAl.aAE, 2);
            }
            if (aAl.CY() > 0) {
                a(aAl.aAw, aAl.aAx, aAl.aAy, aAl.aAA, aAl.aAz, 100001);
                com.baidu.tbadk.l.k.b(aAl.aAw, aAl.aAx, aAl.aAy, aAl.aAA, aAl.aAz, 1);
            }
            aAl.reset();
        }
    }

    public static void a(r rVar, r rVar2, r rVar3, r rVar4, r rVar5, int i) {
        if (rVar != null && rVar2 != null && rVar3 != null && rVar4 != null && rVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = t.Da().Db();
            }
            if (aAo != null && TextUtils.isEmpty("")) {
                str2 = t.Da().fw(aAo);
            }
            if (TextUtils.isEmpty("")) {
                str3 = CS();
            }
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append(SocialConstants.PARAM_ACT, "dlStat");
            jB.append("cdnCostTime", String.valueOf(rVar.time));
            jB.append("cdnNum", String.valueOf(rVar.num));
            jB.append("cdnFailnum", String.valueOf(rVar.aAg));
            jB.append("portraitCostTime", String.valueOf(rVar2.time));
            jB.append("portraitNum", String.valueOf(rVar2.num));
            jB.append("portraitFailnum", String.valueOf(rVar2.aAg));
            jB.append("tiebaCostTime", String.valueOf(rVar3.time));
            jB.append("tiebaNum", String.valueOf(rVar3.num));
            jB.append("tiebaFailnum", String.valueOf(rVar3.aAg));
            jB.append("otherCostTime", String.valueOf(rVar5.time));
            jB.append("otherNum", String.valueOf(rVar5.num));
            jB.append("otherFailnum", String.valueOf(rVar5.aAg));
            jB.append("directIpCostTime", String.valueOf(rVar4.time));
            jB.append("directIpNum", String.valueOf(rVar4.num));
            jB.append("directIpFailnum", String.valueOf(rVar4.aAg));
            jB.append("dnsFailNum", String.valueOf(aAl.aAp));
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
        if (com.baidu.adp.lib.util.l.ll()) {
            synchronized (syncLock) {
                aAn.num++;
                if (z) {
                    aAn.time += j;
                } else {
                    aAn.aAg++;
                }
                if (aAn.num >= 100) {
                    CR();
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

    public static void CR() {
        if (aAn.num > 10) {
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append(SocialConstants.PARAM_ACT, "dcStat");
            jB.append("costTime", String.valueOf(aAn.time));
            jB.append("num", String.valueOf(aAn.num));
            jB.append("failnum", String.valueOf(aAn.aAg));
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jB);
            com.baidu.tbadk.l.k.a(aAn.num, aAn.aAg, aAn.time);
            aAn.reset();
        }
    }

    public static void fv(String str) {
        com.baidu.adp.lib.stats.a jB = jB();
        jB.append(SocialConstants.PARAM_ACT, "assistant");
        jB.append("content", str);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jB);
    }

    private static String CS() {
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
    private static long CT() {
        HttpURLConnection httpURLConnection;
        long j;
        if (aAi >= 3) {
            return aAj;
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
            if (aAi > -1) {
                aAj = ((aAj * aAi) + j) / (aAi + 1);
            } else {
                aAj = j;
            }
            aAi++;
            return j;
        }
        return j;
    }

    private static String CU() {
        return com.baidu.tbadk.imageManager.c.Nv().ib();
    }

    private static String CV() {
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
            str6 = t.Da().fw(str);
        }
        String CS = CS();
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
        jB.append("dnsIP", CS);
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
