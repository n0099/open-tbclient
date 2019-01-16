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
    private static long aAK = 0;
    private static long aAL = 0;
    private static int aAM = 0;
    private static a aAN = new a();
    private static r aAO = new r();
    private static r aAP = new r();
    private static String aAQ = null;
    private static Object syncLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int aAR;
        boolean aAS;
        r aAT;
        r aAU;
        r aAV;
        r aAW;
        r aAX;
        r aAY;
        r aAZ;
        r aBa;
        r aBb;
        r aBc;
        r aBd;
        r aBe;
        r aBf;
        r aBg;
        r aBh;

        private a() {
            this.aAR = 0;
            this.aAT = new r();
            this.aAU = new r();
            this.aAV = new r();
            this.aAW = new r();
            this.aAX = new r();
            this.aAY = new r();
            this.aAZ = new r();
            this.aBa = new r();
            this.aBb = new r();
            this.aBc = new r();
            this.aBd = new r();
            this.aBe = new r();
            this.aBf = new r();
            this.aBg = new r();
            this.aBh = new r();
        }

        public int Dj() {
            return this.aAT.num + this.aAU.num + this.aAV.num + this.aAW.num + this.aAX.num;
        }

        public int Dk() {
            return this.aAT.num + this.aAU.num + this.aAV.num + this.aAW.num + this.aAX.num + this.aAY.num + this.aAZ.num + this.aBa.num + this.aBb.num + this.aBc.num + this.aBd.num + this.aBe.num + this.aBf.num + this.aBg.num + this.aBh.num;
        }

        public int Dl() {
            return this.aAY.num + this.aAZ.num + this.aBa.num + this.aBb.num + this.aBc.num;
        }

        public int Dm() {
            return this.aBd.num + this.aBe.num + this.aBf.num + this.aBg.num + this.aBh.num;
        }

        public void reset() {
            this.aAR = 0;
            this.aAT.reset();
            this.aAU.reset();
            this.aAV.reset();
            this.aAW.reset();
            this.aAX.reset();
            this.aAY.reset();
            this.aAZ.reset();
            this.aBa.reset();
            this.aBb.reset();
            this.aBc.reset();
            this.aBd.reset();
            this.aBe.reset();
            this.aBf.reset();
            this.aBg.reset();
            this.aBh.reset();
        }
    }

    private static r a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return aAN.aAT;
            }
            if (str.startsWith("http://tb.himg")) {
                return aAN.aAU;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aAN.aAV;
            }
            if (z2 && z3) {
                return aAN.aAX;
            }
            return aAN.aAW;
        } else if (com.baidu.adp.lib.util.j.la()) {
            if (z2) {
                return aAN.aAY;
            }
            if (str.startsWith("http://tb.himg")) {
                return aAN.aAZ;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aAN.aBa;
            }
            return aAN.aBb;
        } else if (z2) {
            return aAN.aBd;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return aAN.aBe;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aAN.aBf;
            }
            return aAN.aBg;
        }
    }

    public static com.baidu.adp.lib.stats.a jB() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (syncLock) {
                aAO.num++;
                aAO.time += j;
                if (aAO.num >= 100) {
                    Dc();
                }
            }
        }
    }

    public static void Dc() {
        if (aAO.num > 10) {
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append(SocialConstants.PARAM_ACT, "locStat");
            jB.append("costTime", String.valueOf(aAO.time));
            jB.append("num", String.valueOf(aAO.num));
            jB.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jB);
            aAO.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.l.ll() && dVar != null) {
            String str6 = "";
            boolean iQ = com.baidu.tbadk.util.i.iQ(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().aDZ) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean kW = com.baidu.adp.lib.util.j.kW();
            if (!z5) {
                z4 = false;
            } else if (kW) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().anN);
            } else if (com.baidu.adp.lib.util.j.la()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().anP);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().anO);
            }
            boolean z6 = false;
            if (iQ && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (iQ && kW && z6) {
                if (z) {
                    p.getInstance().insertNormalData(j, str);
                } else {
                    str6 = t.Dn().Do();
                    if (!TextUtils.isEmpty(str6)) {
                        p.getInstance().insertErrorData(dVar.CM, str);
                    }
                }
            }
            if (iQ) {
                aAQ = str;
            }
            boolean z7 = false;
            if (dVar.CO != null && dVar.CO.length() > 0) {
                z7 = true;
            }
            synchronized (syncLock) {
                r a2 = a(kW, iQ, str2, z7);
                boolean z8 = aAN.aAS;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.CG += j2;
                        aAN.aAS = true;
                        if (z4) {
                            a2.aAJ++;
                        }
                        aAM = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.kV()) {
                            int i2 = aAM + 1;
                            aAM = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.ko().getMaxAlertCount("alert_img", 5)) {
                                BdStatisticsManager.getInstance().alert("alert_img", "imgFailedCnt_" + String.valueOf(aAM) + "_url=" + str2);
                            }
                        }
                        a2.aAI++;
                        aAN.aAS = false;
                    }
                }
                int Dk = aAN.Dk();
                if (Dk > 100 || (Dk > 0 && z8 != aAN.aAS)) {
                    Dd();
                }
            }
            if (z && z5) {
                if (!kW || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().anN) {
                    if (kW || !com.baidu.adp.lib.util.j.la() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().anP) {
                        if (!kW && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().anO) {
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
                str6 = t.Dn().Do();
            }
            if (!iQ || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = t.Dn().fJ(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = Df();
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
                aVar.append("connBaidu", String.valueOf(Dg()));
            }
            aVar.append("memory", Dh());
            aVar.append(WebSocketAction.PARAM_KEY_TASK, Di());
            aVar.append("status", String.valueOf(dVar.CN));
            aVar.append("up", String.valueOf(dVar.CF));
            aVar.append("down", String.valueOf(dVar.CG));
            aVar.append("isCDN", iQ ? "1" : "0");
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
            if (iQ && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                aAN.aAR++;
            }
        }
    }

    public static void Dd() {
        if (aAN.Dk() > 10) {
            if (aAN.Dj() > 0) {
                a(aAN.aAT, aAN.aAU, aAN.aAV, aAN.aAX, aAN.aAW, 10000);
                com.baidu.tbadk.l.k.b(aAN.aAT, aAN.aAU, aAN.aAV, aAN.aAX, aAN.aAW, 3);
            }
            if (aAN.Dm() > 0) {
                a(aAN.aBd, aAN.aBe, aAN.aBf, aAN.aBh, aAN.aBg, 100002);
                com.baidu.tbadk.l.k.b(aAN.aBd, aAN.aBe, aAN.aBf, aAN.aBh, aAN.aBg, 2);
            }
            if (aAN.Dl() > 0) {
                a(aAN.aAY, aAN.aAZ, aAN.aBa, aAN.aBc, aAN.aBb, 100001);
                com.baidu.tbadk.l.k.b(aAN.aAY, aAN.aAZ, aAN.aBa, aAN.aBc, aAN.aBb, 1);
            }
            aAN.reset();
        }
    }

    public static void a(r rVar, r rVar2, r rVar3, r rVar4, r rVar5, int i) {
        if (rVar != null && rVar2 != null && rVar3 != null && rVar4 != null && rVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = t.Dn().Do();
            }
            if (aAQ != null && TextUtils.isEmpty("")) {
                str2 = t.Dn().fJ(aAQ);
            }
            if (TextUtils.isEmpty("")) {
                str3 = Df();
            }
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append(SocialConstants.PARAM_ACT, "dlStat");
            jB.append("cdnCostTime", String.valueOf(rVar.time));
            jB.append("cdnNum", String.valueOf(rVar.num));
            jB.append("cdnFailnum", String.valueOf(rVar.aAI));
            jB.append("portraitCostTime", String.valueOf(rVar2.time));
            jB.append("portraitNum", String.valueOf(rVar2.num));
            jB.append("portraitFailnum", String.valueOf(rVar2.aAI));
            jB.append("tiebaCostTime", String.valueOf(rVar3.time));
            jB.append("tiebaNum", String.valueOf(rVar3.num));
            jB.append("tiebaFailnum", String.valueOf(rVar3.aAI));
            jB.append("otherCostTime", String.valueOf(rVar5.time));
            jB.append("otherNum", String.valueOf(rVar5.num));
            jB.append("otherFailnum", String.valueOf(rVar5.aAI));
            jB.append("directIpCostTime", String.valueOf(rVar4.time));
            jB.append("directIpNum", String.valueOf(rVar4.num));
            jB.append("directIpFailnum", String.valueOf(rVar4.aAI));
            jB.append("dnsFailNum", String.valueOf(aAN.aAR));
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
                aAP.num++;
                if (z) {
                    aAP.time += j;
                } else {
                    aAP.aAI++;
                }
                if (aAP.num >= 100) {
                    De();
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

    public static void De() {
        if (aAP.num > 10) {
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append(SocialConstants.PARAM_ACT, "dcStat");
            jB.append("costTime", String.valueOf(aAP.time));
            jB.append("num", String.valueOf(aAP.num));
            jB.append("failnum", String.valueOf(aAP.aAI));
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jB);
            com.baidu.tbadk.l.k.a(aAP.num, aAP.aAI, aAP.time);
            aAP.reset();
        }
    }

    public static void fI(String str) {
        com.baidu.adp.lib.stats.a jB = jB();
        jB.append(SocialConstants.PARAM_ACT, "assistant");
        jB.append("content", str);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jB);
    }

    private static String Df() {
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
    private static long Dg() {
        HttpURLConnection httpURLConnection;
        long j;
        if (aAK >= 3) {
            return aAL;
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
            if (aAK > -1) {
                aAL = ((aAL * aAK) + j) / (aAK + 1);
            } else {
                aAL = j;
            }
            aAK++;
            return j;
        }
        return j;
    }

    private static String Dh() {
        return com.baidu.tbadk.imageManager.c.NM().ib();
    }

    private static String Di() {
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
            str6 = t.Dn().fJ(str);
        }
        String Df = Df();
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
        jB.append("dnsIP", Df);
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
