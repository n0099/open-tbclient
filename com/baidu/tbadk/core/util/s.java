package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.tencent.open.SocialConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class s {
    private static long bIJ = 0;
    private static long bIK = 0;
    private static int bIL = 0;
    private static a bIM = new a();
    private static r bIN = new r();
    private static r bIO = new r();
    private static String bIP = null;
    private static Object syncLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int bIQ;
        boolean bIR;
        r bIS;
        r bIT;
        r bIU;
        r bIV;
        r bIW;
        r bIX;
        r bIY;
        r bIZ;
        r bJa;
        r bJb;
        r bJc;
        r bJd;
        r bJe;
        r bJf;
        r bJg;

        private a() {
            this.bIQ = 0;
            this.bIS = new r();
            this.bIT = new r();
            this.bIU = new r();
            this.bIV = new r();
            this.bIW = new r();
            this.bIX = new r();
            this.bIY = new r();
            this.bIZ = new r();
            this.bJa = new r();
            this.bJb = new r();
            this.bJc = new r();
            this.bJd = new r();
            this.bJe = new r();
            this.bJf = new r();
            this.bJg = new r();
        }

        public int acr() {
            return this.bIS.num + this.bIT.num + this.bIU.num + this.bIV.num + this.bIW.num;
        }

        public int acs() {
            return this.bIS.num + this.bIT.num + this.bIU.num + this.bIV.num + this.bIW.num + this.bIX.num + this.bIY.num + this.bIZ.num + this.bJa.num + this.bJb.num + this.bJc.num + this.bJd.num + this.bJe.num + this.bJf.num + this.bJg.num;
        }

        public int act() {
            return this.bIX.num + this.bIY.num + this.bIZ.num + this.bJa.num + this.bJb.num;
        }

        public int acu() {
            return this.bJc.num + this.bJd.num + this.bJe.num + this.bJf.num + this.bJg.num;
        }

        public void reset() {
            this.bIQ = 0;
            this.bIS.reset();
            this.bIT.reset();
            this.bIU.reset();
            this.bIV.reset();
            this.bIW.reset();
            this.bIX.reset();
            this.bIY.reset();
            this.bIZ.reset();
            this.bJa.reset();
            this.bJb.reset();
            this.bJc.reset();
            this.bJd.reset();
            this.bJe.reset();
            this.bJf.reset();
            this.bJg.reset();
        }
    }

    private static r a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return bIM.bIS;
            }
            if (str.startsWith("http://tb.himg")) {
                return bIM.bIT;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return bIM.bIU;
            }
            if (z2 && z3) {
                return bIM.bIW;
            }
            return bIM.bIV;
        } else if (com.baidu.adp.lib.util.j.ld()) {
            if (z2) {
                return bIM.bIX;
            }
            if (str.startsWith("http://tb.himg")) {
                return bIM.bIY;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return bIM.bIZ;
            }
            return bIM.bJa;
        } else if (z2) {
            return bIM.bJc;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return bIM.bJd;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return bIM.bJe;
            }
            return bIM.bJf;
        }
    }

    public static com.baidu.adp.lib.stats.a jC() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (syncLock) {
                bIN.num++;
                bIN.time += j;
                if (bIN.num >= 100) {
                    ack();
                }
            }
        }
    }

    public static void ack() {
        if (bIN.num > 10) {
            com.baidu.adp.lib.stats.a jC = jC();
            jC.append(SocialConstants.PARAM_ACT, "locStat");
            jC.append("costTime", String.valueOf(bIN.time));
            jC.append("num", String.valueOf(bIN.num));
            jC.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jC);
            bIN.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.l.lo() && dVar != null) {
            String str6 = "";
            boolean pG = com.baidu.tbadk.util.l.pG(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().bLY) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean kZ = com.baidu.adp.lib.util.j.kZ();
            if (!z5) {
                z4 = false;
            } else if (kZ) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().buD);
            } else if (com.baidu.adp.lib.util.j.ld()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().buF);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().buE);
            }
            boolean z6 = false;
            if (pG && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (pG && kZ && z6) {
                if (z) {
                    p.getInstance().insertNormalData(j, str);
                } else {
                    str6 = t.acv().acw();
                    if (!TextUtils.isEmpty(str6)) {
                        p.getInstance().insertErrorData(dVar.CL, str);
                    }
                }
            }
            if (pG) {
                bIP = str;
            }
            boolean z7 = false;
            if (dVar.CN != null && dVar.CN.length() > 0) {
                z7 = true;
            }
            synchronized (syncLock) {
                r a2 = a(kZ, pG, str2, z7);
                boolean z8 = bIM.bIR;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.CF += j2;
                        bIM.bIR = true;
                        if (z4) {
                            a2.bII++;
                        }
                        bIL = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.kY()) {
                            int i2 = bIL + 1;
                            bIL = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.kq().getMaxAlertCount("alert_img", 5)) {
                                BdStatisticsManager.getInstance().alert("alert_img", "imgFailedCnt_" + String.valueOf(bIL) + "_url=" + str2);
                            }
                        }
                        a2.bIH++;
                        bIM.bIR = false;
                    }
                }
                int acs = bIM.acs();
                if (acs > 100 || (acs > 0 && z8 != bIM.bIR)) {
                    acl();
                }
            }
            if (z && z5) {
                if (!kZ || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().buD) {
                    if (kZ || !com.baidu.adp.lib.util.j.ld() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().buF) {
                        if (!kZ && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().buE) {
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
                aVar = jC();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = t.acv().acw();
            }
            if (!pG || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = t.acv().mv(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = acn();
            }
            aVar.append("url", str);
            aVar.append(SocialConstants.PARAM_ACT, "dl");
            aVar.append("result", z ? "1" : "0");
            aVar.append("fullurl", str2);
            aVar.append("netlib", String.valueOf(dVar.CT));
            aVar.append("costTime", String.valueOf(j));
            aVar.append("connTime", String.valueOf(dVar.connectTime));
            aVar.append("rspTime", String.valueOf(dVar.CG));
            aVar.append("retry", String.valueOf(dVar.CH));
            aVar.append("localIp", d.getIp());
            aVar.append("tiebaIp", str6);
            aVar.append("cdnIp", str4);
            aVar.append("useIp", dVar.CN);
            aVar.append("dnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.append("connBaidu", String.valueOf(aco()));
            }
            aVar.append("memory", acp());
            aVar.append("task", acq());
            aVar.append("status", String.valueOf(dVar.CM));
            aVar.append("up", String.valueOf(dVar.CE));
            aVar.append("down", String.valueOf(dVar.CF));
            aVar.append("isCDN", pG ? "1" : "0");
            aVar.append("isWebp", bool.booleanValue() ? "1" : "0");
            aVar.append("isMobileProxy", z3 ? "1" : "0");
            aVar.append("exception", dVar.CK);
            aVar.append("reason", str3);
            if (i != 0) {
                aVar.f("procType", Integer.valueOf(i));
            }
            if (dVar.CP != null) {
                aVar.append("tracecode1", dVar.CP);
            }
            if (dVar.CQ != null) {
                aVar.append("tracecode2", dVar.CQ);
            }
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, aVar);
            if (pG && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                bIM.bIQ++;
            }
        }
    }

    public static void acl() {
        if (bIM.acs() > 10) {
            if (bIM.acr() > 0) {
                a(bIM.bIS, bIM.bIT, bIM.bIU, bIM.bIW, bIM.bIV, 10000);
                com.baidu.tbadk.o.k.b(bIM.bIS, bIM.bIT, bIM.bIU, bIM.bIW, bIM.bIV, 3);
            }
            if (bIM.acu() > 0) {
                a(bIM.bJc, bIM.bJd, bIM.bJe, bIM.bJg, bIM.bJf, 100002);
                com.baidu.tbadk.o.k.b(bIM.bJc, bIM.bJd, bIM.bJe, bIM.bJg, bIM.bJf, 2);
            }
            if (bIM.act() > 0) {
                a(bIM.bIX, bIM.bIY, bIM.bIZ, bIM.bJb, bIM.bJa, 100001);
                com.baidu.tbadk.o.k.b(bIM.bIX, bIM.bIY, bIM.bIZ, bIM.bJb, bIM.bJa, 1);
            }
            bIM.reset();
        }
    }

    public static void a(r rVar, r rVar2, r rVar3, r rVar4, r rVar5, int i) {
        if (rVar != null && rVar2 != null && rVar3 != null && rVar4 != null && rVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = t.acv().acw();
            }
            if (bIP != null && TextUtils.isEmpty("")) {
                str2 = t.acv().mv(bIP);
            }
            if (TextUtils.isEmpty("")) {
                str3 = acn();
            }
            com.baidu.adp.lib.stats.a jC = jC();
            jC.append(SocialConstants.PARAM_ACT, "dlStat");
            jC.append("cdnCostTime", String.valueOf(rVar.time));
            jC.append("cdnNum", String.valueOf(rVar.num));
            jC.append("cdnFailnum", String.valueOf(rVar.bIH));
            jC.append("portraitCostTime", String.valueOf(rVar2.time));
            jC.append("portraitNum", String.valueOf(rVar2.num));
            jC.append("portraitFailnum", String.valueOf(rVar2.bIH));
            jC.append("tiebaCostTime", String.valueOf(rVar3.time));
            jC.append("tiebaNum", String.valueOf(rVar3.num));
            jC.append("tiebaFailnum", String.valueOf(rVar3.bIH));
            jC.append("otherCostTime", String.valueOf(rVar5.time));
            jC.append("otherNum", String.valueOf(rVar5.num));
            jC.append("otherFailnum", String.valueOf(rVar5.bIH));
            jC.append("directIpCostTime", String.valueOf(rVar4.time));
            jC.append("directIpNum", String.valueOf(rVar4.num));
            jC.append("directIpFailnum", String.valueOf(rVar4.bIH));
            jC.append("dnsFailNum", String.valueOf(bIM.bIQ));
            if (10000 == i) {
                jC.append("isWifi", "1");
                jC.append("netType", "WIFI");
            } else if (100002 == i) {
                jC.append("netType", "3G");
                jC.append("isWifi", "0");
            } else {
                jC.append("netType", "2G");
                jC.append("isWifi", "0");
            }
            jC.append("localIp", d.getIp());
            jC.append("tbIp", str);
            jC.append("cdnIp", str2);
            jC.append("dnsIp", str3);
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jC);
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.l.lo()) {
            synchronized (syncLock) {
                bIO.num++;
                if (z) {
                    bIO.time += j;
                } else {
                    bIO.bIH++;
                }
                if (bIO.num >= 100) {
                    acm();
                }
            }
            if (!z) {
                if (aVar == null) {
                    aVar = jC();
                }
                aVar.append(SocialConstants.PARAM_ACT, "dc");
                aVar.append("costTime", String.valueOf(j));
                aVar.append("url", str);
                aVar.append("fullURL", str2);
                aVar.append("isWebp", z3 ? "1" : "0");
                aVar.append("isCDN", z2 ? "1" : "0");
                aVar.append("length", String.valueOf(i));
                aVar.append("reason", str3);
                aVar.append("result", z ? "0" : "1");
                aVar.append("execption", str4);
                BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, aVar);
            }
        }
    }

    public static void acm() {
        if (bIO.num > 10) {
            com.baidu.adp.lib.stats.a jC = jC();
            jC.append(SocialConstants.PARAM_ACT, "dcStat");
            jC.append("costTime", String.valueOf(bIO.time));
            jC.append("num", String.valueOf(bIO.num));
            jC.append("failnum", String.valueOf(bIO.bIH));
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jC);
            com.baidu.tbadk.o.k.a(bIO.num, bIO.bIH, bIO.time);
            bIO.reset();
        }
    }

    public static void mu(String str) {
        com.baidu.adp.lib.stats.a jC = jC();
        jC.append(SocialConstants.PARAM_ACT, "assistant");
        jC.append("content", str);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jC);
    }

    private static String acn() {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [599=5] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long aco() {
        HttpURLConnection httpURLConnection;
        long j;
        if (bIJ >= 3) {
            return bIK;
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
            if (bIJ > -1) {
                bIK = ((bIK * bIJ) + j) / (bIJ + 1);
            } else {
                bIK = j;
            }
            bIJ++;
            return j;
        }
        return j;
    }

    private static String acp() {
        return com.baidu.tbadk.imageManager.c.anm().ia();
    }

    private static String acq() {
        return com.baidu.adp.lib.asyncTask.a.ib().ia();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.a jC = jC();
        jC.append(SocialConstants.PARAM_ACT, "getCDNList");
        jC.append("errorNum", str);
        jC.append("errorMsg", str2);
        jC.append("isShortNetError", z2 ? "1" : "0");
        jC.append("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jC);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = t.acv().mv(str);
        }
        String acn = acn();
        String ip = d.getIp();
        com.baidu.adp.lib.stats.a jC = jC();
        jC.append(SocialConstants.PARAM_ACT, "tachometerCDN");
        jC.append("errorNum", str3);
        jC.append("execption", str4);
        jC.append("size", str5);
        jC.append("isScuess", z ? "1" : "0");
        jC.append("url", str);
        jC.append("localIp", ip);
        jC.append("cdnIp", str6);
        jC.append("dnsIP", acn);
        jC.append("usedIp", str2);
        jC.append("isUsedIp", z2 ? "0" : "1");
        jC.append("costTime", String.valueOf(j));
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jC);
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
                    com.baidu.adp.lib.stats.a jC = jC();
                    jC.append(SocialConstants.PARAM_ACT, "mobileTachometerCDN");
                    jC.append("costTime", String.valueOf(j));
                    jC.append("ipList", sb.toString());
                    BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jC);
                    return;
                }
            }
        }
    }

    public static void h(boolean z, String str) {
        com.baidu.adp.lib.stats.a jC = jC();
        jC.append(SocialConstants.PARAM_ACT, "getCDNList");
        jC.append("isSuccess", z ? "1" : "0");
        jC.append("errorMsg", str);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jC);
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
