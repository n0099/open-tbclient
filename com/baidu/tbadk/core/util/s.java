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
    private static long bII = 0;
    private static long bIJ = 0;
    private static int bIK = 0;
    private static a bIL = new a();
    private static r bIM = new r();
    private static r bIN = new r();
    private static String bIO = null;
    private static Object syncLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int bIP;
        boolean bIQ;
        r bIR;
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

        private a() {
            this.bIP = 0;
            this.bIR = new r();
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
        }

        public int acr() {
            return this.bIR.num + this.bIS.num + this.bIT.num + this.bIU.num + this.bIV.num;
        }

        public int acs() {
            return this.bIR.num + this.bIS.num + this.bIT.num + this.bIU.num + this.bIV.num + this.bIW.num + this.bIX.num + this.bIY.num + this.bIZ.num + this.bJa.num + this.bJb.num + this.bJc.num + this.bJd.num + this.bJe.num + this.bJf.num;
        }

        public int act() {
            return this.bIW.num + this.bIX.num + this.bIY.num + this.bIZ.num + this.bJa.num;
        }

        public int acu() {
            return this.bJb.num + this.bJc.num + this.bJd.num + this.bJe.num + this.bJf.num;
        }

        public void reset() {
            this.bIP = 0;
            this.bIR.reset();
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
        }
    }

    private static r a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return bIL.bIR;
            }
            if (str.startsWith("http://tb.himg")) {
                return bIL.bIS;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return bIL.bIT;
            }
            if (z2 && z3) {
                return bIL.bIV;
            }
            return bIL.bIU;
        } else if (com.baidu.adp.lib.util.j.ld()) {
            if (z2) {
                return bIL.bIW;
            }
            if (str.startsWith("http://tb.himg")) {
                return bIL.bIX;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return bIL.bIY;
            }
            return bIL.bIZ;
        } else if (z2) {
            return bIL.bJb;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return bIL.bJc;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return bIL.bJd;
            }
            return bIL.bJe;
        }
    }

    public static com.baidu.adp.lib.stats.a jC() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (syncLock) {
                bIM.num++;
                bIM.time += j;
                if (bIM.num >= 100) {
                    ack();
                }
            }
        }
    }

    public static void ack() {
        if (bIM.num > 10) {
            com.baidu.adp.lib.stats.a jC = jC();
            jC.append(SocialConstants.PARAM_ACT, "locStat");
            jC.append("costTime", String.valueOf(bIM.time));
            jC.append("num", String.valueOf(bIM.num));
            jC.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jC);
            bIM.reset();
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
                if (!com.baidu.tbadk.core.util.a.e.getInstance().bLX) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean kZ = com.baidu.adp.lib.util.j.kZ();
            if (!z5) {
                z4 = false;
            } else if (kZ) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().buC);
            } else if (com.baidu.adp.lib.util.j.ld()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().buE);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().buD);
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
                bIO = str;
            }
            boolean z7 = false;
            if (dVar.CN != null && dVar.CN.length() > 0) {
                z7 = true;
            }
            synchronized (syncLock) {
                r a2 = a(kZ, pG, str2, z7);
                boolean z8 = bIL.bIQ;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.CF += j2;
                        bIL.bIQ = true;
                        if (z4) {
                            a2.bIH++;
                        }
                        bIK = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.kY()) {
                            int i2 = bIK + 1;
                            bIK = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.kq().getMaxAlertCount("alert_img", 5)) {
                                BdStatisticsManager.getInstance().alert("alert_img", "imgFailedCnt_" + String.valueOf(bIK) + "_url=" + str2);
                            }
                        }
                        a2.bIG++;
                        bIL.bIQ = false;
                    }
                }
                int acs = bIL.acs();
                if (acs > 100 || (acs > 0 && z8 != bIL.bIQ)) {
                    acl();
                }
            }
            if (z && z5) {
                if (!kZ || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().buC) {
                    if (kZ || !com.baidu.adp.lib.util.j.ld() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().buE) {
                        if (!kZ && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().buD) {
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
                bIL.bIP++;
            }
        }
    }

    public static void acl() {
        if (bIL.acs() > 10) {
            if (bIL.acr() > 0) {
                a(bIL.bIR, bIL.bIS, bIL.bIT, bIL.bIV, bIL.bIU, 10000);
                com.baidu.tbadk.o.k.b(bIL.bIR, bIL.bIS, bIL.bIT, bIL.bIV, bIL.bIU, 3);
            }
            if (bIL.acu() > 0) {
                a(bIL.bJb, bIL.bJc, bIL.bJd, bIL.bJf, bIL.bJe, 100002);
                com.baidu.tbadk.o.k.b(bIL.bJb, bIL.bJc, bIL.bJd, bIL.bJf, bIL.bJe, 2);
            }
            if (bIL.act() > 0) {
                a(bIL.bIW, bIL.bIX, bIL.bIY, bIL.bJa, bIL.bIZ, 100001);
                com.baidu.tbadk.o.k.b(bIL.bIW, bIL.bIX, bIL.bIY, bIL.bJa, bIL.bIZ, 1);
            }
            bIL.reset();
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
            if (bIO != null && TextUtils.isEmpty("")) {
                str2 = t.acv().mv(bIO);
            }
            if (TextUtils.isEmpty("")) {
                str3 = acn();
            }
            com.baidu.adp.lib.stats.a jC = jC();
            jC.append(SocialConstants.PARAM_ACT, "dlStat");
            jC.append("cdnCostTime", String.valueOf(rVar.time));
            jC.append("cdnNum", String.valueOf(rVar.num));
            jC.append("cdnFailnum", String.valueOf(rVar.bIG));
            jC.append("portraitCostTime", String.valueOf(rVar2.time));
            jC.append("portraitNum", String.valueOf(rVar2.num));
            jC.append("portraitFailnum", String.valueOf(rVar2.bIG));
            jC.append("tiebaCostTime", String.valueOf(rVar3.time));
            jC.append("tiebaNum", String.valueOf(rVar3.num));
            jC.append("tiebaFailnum", String.valueOf(rVar3.bIG));
            jC.append("otherCostTime", String.valueOf(rVar5.time));
            jC.append("otherNum", String.valueOf(rVar5.num));
            jC.append("otherFailnum", String.valueOf(rVar5.bIG));
            jC.append("directIpCostTime", String.valueOf(rVar4.time));
            jC.append("directIpNum", String.valueOf(rVar4.num));
            jC.append("directIpFailnum", String.valueOf(rVar4.bIG));
            jC.append("dnsFailNum", String.valueOf(bIL.bIP));
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
                bIN.num++;
                if (z) {
                    bIN.time += j;
                } else {
                    bIN.bIG++;
                }
                if (bIN.num >= 100) {
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
        if (bIN.num > 10) {
            com.baidu.adp.lib.stats.a jC = jC();
            jC.append(SocialConstants.PARAM_ACT, "dcStat");
            jC.append("costTime", String.valueOf(bIN.time));
            jC.append("num", String.valueOf(bIN.num));
            jC.append("failnum", String.valueOf(bIN.bIG));
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jC);
            com.baidu.tbadk.o.k.a(bIN.num, bIN.bIG, bIN.time);
            bIN.reset();
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
        if (bII >= 3) {
            return bIJ;
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
            if (bII > -1) {
                bIJ = ((bIJ * bII) + j) / (bII + 1);
            } else {
                bIJ = j;
            }
            bII++;
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
