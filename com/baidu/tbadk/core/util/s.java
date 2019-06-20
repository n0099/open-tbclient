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
    private static long bQu = 0;
    private static long bQv = 0;
    private static int bQw = 0;
    private static a bQx = new a();
    private static r bQy = new r();
    private static r bQz = new r();
    private static String bQA = null;
    private static Object syncLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int bQB;
        boolean bQC;
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
        r bQR;

        private a() {
            this.bQB = 0;
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
            this.bQR = new r();
        }

        public int ahp() {
            return this.bQD.num + this.bQE.num + this.bQF.num + this.bQG.num + this.bQH.num;
        }

        public int ahq() {
            return this.bQD.num + this.bQE.num + this.bQF.num + this.bQG.num + this.bQH.num + this.bQI.num + this.bQJ.num + this.bQK.num + this.bQL.num + this.bQM.num + this.bQN.num + this.bQO.num + this.bQP.num + this.bQQ.num + this.bQR.num;
        }

        public int ahr() {
            return this.bQI.num + this.bQJ.num + this.bQK.num + this.bQL.num + this.bQM.num;
        }

        public int ahs() {
            return this.bQN.num + this.bQO.num + this.bQP.num + this.bQQ.num + this.bQR.num;
        }

        public void reset() {
            this.bQB = 0;
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
            this.bQR.reset();
        }
    }

    private static r a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return bQx.bQD;
            }
            if (str.startsWith("http://tb.himg")) {
                return bQx.bQE;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return bQx.bQF;
            }
            if (z2 && z3) {
                return bQx.bQH;
            }
            return bQx.bQG;
        } else if (com.baidu.adp.lib.util.j.jX()) {
            if (z2) {
                return bQx.bQI;
            }
            if (str.startsWith("http://tb.himg")) {
                return bQx.bQJ;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return bQx.bQK;
            }
            return bQx.bQL;
        } else if (z2) {
            return bQx.bQN;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return bQx.bQO;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return bQx.bQP;
            }
            return bQx.bQQ;
        }
    }

    public static com.baidu.adp.lib.stats.a iw() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (syncLock) {
                bQy.num++;
                bQy.time += j;
                if (bQy.num >= 100) {
                    ahi();
                }
            }
        }
    }

    public static void ahi() {
        if (bQy.num > 10) {
            com.baidu.adp.lib.stats.a iw = iw();
            iw.append(SocialConstants.PARAM_ACT, "locStat");
            iw.append("costTime", String.valueOf(bQy.time));
            iw.append("num", String.valueOf(bQy.num));
            iw.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iw);
            bQy.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.l.ki() && dVar != null) {
            String str6 = "";
            boolean qO = com.baidu.tbadk.util.l.qO(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().bTK) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean jT = com.baidu.adp.lib.util.j.jT();
            if (!z5) {
                z4 = false;
            } else if (jT) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().bBH);
            } else if (com.baidu.adp.lib.util.j.jX()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().bBJ);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().bBI);
            }
            boolean z6 = false;
            if (qO && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (qO && jT && z6) {
                if (z) {
                    p.getInstance().insertNormalData(j, str);
                } else {
                    str6 = t.aht().ahu();
                    if (!TextUtils.isEmpty(str6)) {
                        p.getInstance().insertErrorData(dVar.Au, str);
                    }
                }
            }
            if (qO) {
                bQA = str;
            }
            boolean z7 = false;
            if (dVar.Aw != null && dVar.Aw.length() > 0) {
                z7 = true;
            }
            synchronized (syncLock) {
                r a2 = a(jT, qO, str2, z7);
                boolean z8 = bQx.bQC;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.Ao += j2;
                        bQx.bQC = true;
                        if (z4) {
                            a2.bQt++;
                        }
                        bQw = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.jS()) {
                            int i2 = bQw + 1;
                            bQw = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.jk().getMaxAlertCount("alert_img", 5)) {
                                BdStatisticsManager.getInstance().alert("alert_img", "imgFailedCnt_" + String.valueOf(bQw) + "_url=" + str2);
                            }
                        }
                        a2.bQs++;
                        bQx.bQC = false;
                    }
                }
                int ahq = bQx.ahq();
                if (ahq > 100 || (ahq > 0 && z8 != bQx.bQC)) {
                    ahj();
                }
            }
            if (z && z5) {
                if (!jT || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().bBH) {
                    if (jT || !com.baidu.adp.lib.util.j.jX() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().bBJ) {
                        if (!jT && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().bBI) {
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
            if (!qO || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = t.aht().nC(str);
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
            aVar.append("netlib", String.valueOf(dVar.AA));
            aVar.append("costTime", String.valueOf(j));
            aVar.append("connTime", String.valueOf(dVar.connectTime));
            aVar.append("rspTime", String.valueOf(dVar.Ap));
            aVar.append("retry", String.valueOf(dVar.Aq));
            aVar.append("localIp", d.getIp());
            aVar.append("tiebaIp", str6);
            aVar.append("cdnIp", str4);
            aVar.append("useIp", dVar.Aw);
            aVar.append("dnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.append("connBaidu", String.valueOf(ahm()));
            }
            aVar.append("memory", ahn());
            aVar.append("task", aho());
            aVar.append("status", String.valueOf(dVar.Av));
            aVar.append("up", String.valueOf(dVar.An));
            aVar.append("down", String.valueOf(dVar.Ao));
            aVar.append("isCDN", qO ? "1" : "0");
            aVar.append("isWebp", bool.booleanValue() ? "1" : "0");
            aVar.append("isMobileProxy", z3 ? "1" : "0");
            aVar.append("exception", dVar.At);
            aVar.append("reason", str3);
            if (i != 0) {
                aVar.c("procType", Integer.valueOf(i));
            }
            if (dVar.Ay != null) {
                aVar.append("tracecode1", dVar.Ay);
            }
            if (dVar.Az != null) {
                aVar.append("tracecode2", dVar.Az);
            }
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, aVar);
            if (qO && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                bQx.bQB++;
            }
        }
    }

    public static void ahj() {
        if (bQx.ahq() > 10) {
            if (bQx.ahp() > 0) {
                a(bQx.bQD, bQx.bQE, bQx.bQF, bQx.bQH, bQx.bQG, 10000);
                com.baidu.tbadk.p.k.b(bQx.bQD, bQx.bQE, bQx.bQF, bQx.bQH, bQx.bQG, 3);
            }
            if (bQx.ahs() > 0) {
                a(bQx.bQN, bQx.bQO, bQx.bQP, bQx.bQR, bQx.bQQ, 100002);
                com.baidu.tbadk.p.k.b(bQx.bQN, bQx.bQO, bQx.bQP, bQx.bQR, bQx.bQQ, 2);
            }
            if (bQx.ahr() > 0) {
                a(bQx.bQI, bQx.bQJ, bQx.bQK, bQx.bQM, bQx.bQL, 100001);
                com.baidu.tbadk.p.k.b(bQx.bQI, bQx.bQJ, bQx.bQK, bQx.bQM, bQx.bQL, 1);
            }
            bQx.reset();
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
            if (bQA != null && TextUtils.isEmpty("")) {
                str2 = t.aht().nC(bQA);
            }
            if (TextUtils.isEmpty("")) {
                str3 = ahl();
            }
            com.baidu.adp.lib.stats.a iw = iw();
            iw.append(SocialConstants.PARAM_ACT, "dlStat");
            iw.append("cdnCostTime", String.valueOf(rVar.time));
            iw.append("cdnNum", String.valueOf(rVar.num));
            iw.append("cdnFailnum", String.valueOf(rVar.bQs));
            iw.append("portraitCostTime", String.valueOf(rVar2.time));
            iw.append("portraitNum", String.valueOf(rVar2.num));
            iw.append("portraitFailnum", String.valueOf(rVar2.bQs));
            iw.append("tiebaCostTime", String.valueOf(rVar3.time));
            iw.append("tiebaNum", String.valueOf(rVar3.num));
            iw.append("tiebaFailnum", String.valueOf(rVar3.bQs));
            iw.append("otherCostTime", String.valueOf(rVar5.time));
            iw.append("otherNum", String.valueOf(rVar5.num));
            iw.append("otherFailnum", String.valueOf(rVar5.bQs));
            iw.append("directIpCostTime", String.valueOf(rVar4.time));
            iw.append("directIpNum", String.valueOf(rVar4.num));
            iw.append("directIpFailnum", String.valueOf(rVar4.bQs));
            iw.append("dnsFailNum", String.valueOf(bQx.bQB));
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
                bQz.num++;
                if (z) {
                    bQz.time += j;
                } else {
                    bQz.bQs++;
                }
                if (bQz.num >= 100) {
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
        if (bQz.num > 10) {
            com.baidu.adp.lib.stats.a iw = iw();
            iw.append(SocialConstants.PARAM_ACT, "dcStat");
            iw.append("costTime", String.valueOf(bQz.time));
            iw.append("num", String.valueOf(bQz.num));
            iw.append("failnum", String.valueOf(bQz.bQs));
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iw);
            com.baidu.tbadk.p.k.b(bQz.num, bQz.bQs, bQz.time);
            bQz.reset();
        }
    }

    public static void nB(String str) {
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
        if (bQu >= 3) {
            return bQv;
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
            if (bQu > -1) {
                bQv = ((bQv * bQu) + j) / (bQu + 1);
            } else {
                bQv = j;
            }
            bQu++;
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
            str6 = t.aht().nC(str);
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
