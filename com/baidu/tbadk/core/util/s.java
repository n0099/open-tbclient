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
    private static long bQt = 0;
    private static long bQu = 0;
    private static int bQv = 0;
    private static a bQw = new a();
    private static r bQx = new r();
    private static r bQy = new r();
    private static String bQz = null;
    private static Object syncLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int bQA;
        boolean bQB;
        r bQC;
        r bQD;
        r bQE;
        r bQF;
        r bQG;
        r bQH;
        r bQI;
        r bQJ;
        r bQK;
        r bQL;
        r bQM;
        r bQN;
        r bQO;
        r bQP;
        r bQQ;

        private a() {
            this.bQA = 0;
            this.bQC = new r();
            this.bQD = new r();
            this.bQE = new r();
            this.bQF = new r();
            this.bQG = new r();
            this.bQH = new r();
            this.bQI = new r();
            this.bQJ = new r();
            this.bQK = new r();
            this.bQL = new r();
            this.bQM = new r();
            this.bQN = new r();
            this.bQO = new r();
            this.bQP = new r();
            this.bQQ = new r();
        }

        public int ahp() {
            return this.bQC.num + this.bQD.num + this.bQE.num + this.bQF.num + this.bQG.num;
        }

        public int ahq() {
            return this.bQC.num + this.bQD.num + this.bQE.num + this.bQF.num + this.bQG.num + this.bQH.num + this.bQI.num + this.bQJ.num + this.bQK.num + this.bQL.num + this.bQM.num + this.bQN.num + this.bQO.num + this.bQP.num + this.bQQ.num;
        }

        public int ahr() {
            return this.bQH.num + this.bQI.num + this.bQJ.num + this.bQK.num + this.bQL.num;
        }

        public int ahs() {
            return this.bQM.num + this.bQN.num + this.bQO.num + this.bQP.num + this.bQQ.num;
        }

        public void reset() {
            this.bQA = 0;
            this.bQC.reset();
            this.bQD.reset();
            this.bQE.reset();
            this.bQF.reset();
            this.bQG.reset();
            this.bQH.reset();
            this.bQI.reset();
            this.bQJ.reset();
            this.bQK.reset();
            this.bQL.reset();
            this.bQM.reset();
            this.bQN.reset();
            this.bQO.reset();
            this.bQP.reset();
            this.bQQ.reset();
        }
    }

    private static r a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return bQw.bQC;
            }
            if (str.startsWith("http://tb.himg")) {
                return bQw.bQD;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return bQw.bQE;
            }
            if (z2 && z3) {
                return bQw.bQG;
            }
            return bQw.bQF;
        } else if (com.baidu.adp.lib.util.j.jX()) {
            if (z2) {
                return bQw.bQH;
            }
            if (str.startsWith("http://tb.himg")) {
                return bQw.bQI;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return bQw.bQJ;
            }
            return bQw.bQK;
        } else if (z2) {
            return bQw.bQM;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return bQw.bQN;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return bQw.bQO;
            }
            return bQw.bQP;
        }
    }

    public static com.baidu.adp.lib.stats.a iw() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (syncLock) {
                bQx.num++;
                bQx.time += j;
                if (bQx.num >= 100) {
                    ahi();
                }
            }
        }
    }

    public static void ahi() {
        if (bQx.num > 10) {
            com.baidu.adp.lib.stats.a iw = iw();
            iw.append(SocialConstants.PARAM_ACT, "locStat");
            iw.append("costTime", String.valueOf(bQx.time));
            iw.append("num", String.valueOf(bQx.num));
            iw.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iw);
            bQx.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.l.ki() && dVar != null) {
            String str6 = "";
            boolean qP = com.baidu.tbadk.util.l.qP(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().bTJ) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean jT = com.baidu.adp.lib.util.j.jT();
            if (!z5) {
                z4 = false;
            } else if (jT) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().bBG);
            } else if (com.baidu.adp.lib.util.j.jX()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().bBI);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().bBH);
            }
            boolean z6 = false;
            if (qP && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (qP && jT && z6) {
                if (z) {
                    p.getInstance().insertNormalData(j, str);
                } else {
                    str6 = t.aht().ahu();
                    if (!TextUtils.isEmpty(str6)) {
                        p.getInstance().insertErrorData(dVar.Av, str);
                    }
                }
            }
            if (qP) {
                bQz = str;
            }
            boolean z7 = false;
            if (dVar.Ax != null && dVar.Ax.length() > 0) {
                z7 = true;
            }
            synchronized (syncLock) {
                r a2 = a(jT, qP, str2, z7);
                boolean z8 = bQw.bQB;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.Ap += j2;
                        bQw.bQB = true;
                        if (z4) {
                            a2.bQs++;
                        }
                        bQv = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.jS()) {
                            int i2 = bQv + 1;
                            bQv = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.jk().getMaxAlertCount("alert_img", 5)) {
                                BdStatisticsManager.getInstance().alert("alert_img", "imgFailedCnt_" + String.valueOf(bQv) + "_url=" + str2);
                            }
                        }
                        a2.bQr++;
                        bQw.bQB = false;
                    }
                }
                int ahq = bQw.ahq();
                if (ahq > 100 || (ahq > 0 && z8 != bQw.bQB)) {
                    ahj();
                }
            }
            if (z && z5) {
                if (!jT || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().bBG) {
                    if (jT || !com.baidu.adp.lib.util.j.jX() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().bBI) {
                        if (!jT && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().bBH) {
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
                aVar = iw();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = t.aht().ahu();
            }
            if (!qP || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = t.aht().nD(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = ahl();
            }
            aVar.append("url", str);
            aVar.append(SocialConstants.PARAM_ACT, "dl");
            aVar.append("result", z ? "1" : "0");
            aVar.append("fullurl", str2);
            aVar.append("netlib", String.valueOf(dVar.AB));
            aVar.append("costTime", String.valueOf(j));
            aVar.append("connTime", String.valueOf(dVar.connectTime));
            aVar.append("rspTime", String.valueOf(dVar.Aq));
            aVar.append("retry", String.valueOf(dVar.Ar));
            aVar.append("localIp", d.getIp());
            aVar.append("tiebaIp", str6);
            aVar.append("cdnIp", str4);
            aVar.append("useIp", dVar.Ax);
            aVar.append("dnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.append("connBaidu", String.valueOf(ahm()));
            }
            aVar.append("memory", ahn());
            aVar.append("task", aho());
            aVar.append("status", String.valueOf(dVar.Aw));
            aVar.append("up", String.valueOf(dVar.Ao));
            aVar.append("down", String.valueOf(dVar.Ap));
            aVar.append("isCDN", qP ? "1" : "0");
            aVar.append("isWebp", bool.booleanValue() ? "1" : "0");
            aVar.append("isMobileProxy", z3 ? "1" : "0");
            aVar.append("exception", dVar.Au);
            aVar.append("reason", str3);
            if (i != 0) {
                aVar.c("procType", Integer.valueOf(i));
            }
            if (dVar.Az != null) {
                aVar.append("tracecode1", dVar.Az);
            }
            if (dVar.AA != null) {
                aVar.append("tracecode2", dVar.AA);
            }
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, aVar);
            if (qP && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                bQw.bQA++;
            }
        }
    }

    public static void ahj() {
        if (bQw.ahq() > 10) {
            if (bQw.ahp() > 0) {
                a(bQw.bQC, bQw.bQD, bQw.bQE, bQw.bQG, bQw.bQF, 10000);
                com.baidu.tbadk.p.k.b(bQw.bQC, bQw.bQD, bQw.bQE, bQw.bQG, bQw.bQF, 3);
            }
            if (bQw.ahs() > 0) {
                a(bQw.bQM, bQw.bQN, bQw.bQO, bQw.bQQ, bQw.bQP, 100002);
                com.baidu.tbadk.p.k.b(bQw.bQM, bQw.bQN, bQw.bQO, bQw.bQQ, bQw.bQP, 2);
            }
            if (bQw.ahr() > 0) {
                a(bQw.bQH, bQw.bQI, bQw.bQJ, bQw.bQL, bQw.bQK, 100001);
                com.baidu.tbadk.p.k.b(bQw.bQH, bQw.bQI, bQw.bQJ, bQw.bQL, bQw.bQK, 1);
            }
            bQw.reset();
        }
    }

    public static void a(r rVar, r rVar2, r rVar3, r rVar4, r rVar5, int i) {
        if (rVar != null && rVar2 != null && rVar3 != null && rVar4 != null && rVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = t.aht().ahu();
            }
            if (bQz != null && TextUtils.isEmpty("")) {
                str2 = t.aht().nD(bQz);
            }
            if (TextUtils.isEmpty("")) {
                str3 = ahl();
            }
            com.baidu.adp.lib.stats.a iw = iw();
            iw.append(SocialConstants.PARAM_ACT, "dlStat");
            iw.append("cdnCostTime", String.valueOf(rVar.time));
            iw.append("cdnNum", String.valueOf(rVar.num));
            iw.append("cdnFailnum", String.valueOf(rVar.bQr));
            iw.append("portraitCostTime", String.valueOf(rVar2.time));
            iw.append("portraitNum", String.valueOf(rVar2.num));
            iw.append("portraitFailnum", String.valueOf(rVar2.bQr));
            iw.append("tiebaCostTime", String.valueOf(rVar3.time));
            iw.append("tiebaNum", String.valueOf(rVar3.num));
            iw.append("tiebaFailnum", String.valueOf(rVar3.bQr));
            iw.append("otherCostTime", String.valueOf(rVar5.time));
            iw.append("otherNum", String.valueOf(rVar5.num));
            iw.append("otherFailnum", String.valueOf(rVar5.bQr));
            iw.append("directIpCostTime", String.valueOf(rVar4.time));
            iw.append("directIpNum", String.valueOf(rVar4.num));
            iw.append("directIpFailnum", String.valueOf(rVar4.bQr));
            iw.append("dnsFailNum", String.valueOf(bQw.bQA));
            if (10000 == i) {
                iw.append("isWifi", "1");
                iw.append("netType", "WIFI");
            } else if (100002 == i) {
                iw.append("netType", "3G");
                iw.append("isWifi", "0");
            } else {
                iw.append("netType", "2G");
                iw.append("isWifi", "0");
            }
            iw.append("localIp", d.getIp());
            iw.append("tbIp", str);
            iw.append("cdnIp", str2);
            iw.append("dnsIp", str3);
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iw);
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.l.ki()) {
            synchronized (syncLock) {
                bQy.num++;
                if (z) {
                    bQy.time += j;
                } else {
                    bQy.bQr++;
                }
                if (bQy.num >= 100) {
                    ahk();
                }
            }
            if (!z) {
                if (aVar == null) {
                    aVar = iw();
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

    public static void ahk() {
        if (bQy.num > 10) {
            com.baidu.adp.lib.stats.a iw = iw();
            iw.append(SocialConstants.PARAM_ACT, "dcStat");
            iw.append("costTime", String.valueOf(bQy.time));
            iw.append("num", String.valueOf(bQy.num));
            iw.append("failnum", String.valueOf(bQy.bQr));
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iw);
            com.baidu.tbadk.p.k.b(bQy.num, bQy.bQr, bQy.time);
            bQy.reset();
        }
    }

    public static void nC(String str) {
        com.baidu.adp.lib.stats.a iw = iw();
        iw.append(SocialConstants.PARAM_ACT, "assistant");
        iw.append("content", str);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iw);
    }

    private static String ahl() {
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
    private static long ahm() {
        HttpURLConnection httpURLConnection;
        long j;
        if (bQt >= 3) {
            return bQu;
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
            if (bQt > -1) {
                bQu = ((bQu * bQt) + j) / (bQt + 1);
            } else {
                bQu = j;
            }
            bQt++;
            return j;
        }
        return j;
    }

    private static String ahn() {
        return com.baidu.tbadk.imageManager.c.asp().gU();
    }

    private static String aho() {
        return com.baidu.adp.lib.asyncTask.a.gV().gU();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.a iw = iw();
        iw.append(SocialConstants.PARAM_ACT, "getCDNList");
        iw.append("errorNum", str);
        iw.append("errorMsg", str2);
        iw.append("isShortNetError", z2 ? "1" : "0");
        iw.append("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iw);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = t.aht().nD(str);
        }
        String ahl = ahl();
        String ip = d.getIp();
        com.baidu.adp.lib.stats.a iw = iw();
        iw.append(SocialConstants.PARAM_ACT, "tachometerCDN");
        iw.append("errorNum", str3);
        iw.append("execption", str4);
        iw.append("size", str5);
        iw.append("isScuess", z ? "1" : "0");
        iw.append("url", str);
        iw.append("localIp", ip);
        iw.append("cdnIp", str6);
        iw.append("dnsIP", ahl);
        iw.append("usedIp", str2);
        iw.append("isUsedIp", z2 ? "0" : "1");
        iw.append("costTime", String.valueOf(j));
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iw);
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
                    com.baidu.adp.lib.stats.a iw = iw();
                    iw.append(SocialConstants.PARAM_ACT, "mobileTachometerCDN");
                    iw.append("costTime", String.valueOf(j));
                    iw.append("ipList", sb.toString());
                    BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iw);
                    return;
                }
            }
        }
    }

    public static void g(boolean z, String str) {
        com.baidu.adp.lib.stats.a iw = iw();
        iw.append(SocialConstants.PARAM_ACT, "getCDNList");
        iw.append("isSuccess", z ? "1" : "0");
        iw.append("errorMsg", str);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iw);
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
