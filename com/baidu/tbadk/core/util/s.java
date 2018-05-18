package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.sapi2.callback.AccountCenterCallback;
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
    private static long agA = 0;
    private static long agB = 0;
    private static int agC = 0;
    private static a agD = new a();
    private static r agE = new r();
    private static r agF = new r();
    private static String agG = null;
    private static Object syncLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int agH;
        boolean agI;
        r agJ;
        r agK;
        r agL;
        r agM;
        r agN;
        r agO;
        r agP;
        r agQ;
        r agR;
        r agS;
        r agT;
        r agU;
        r agV;
        r agW;
        r agX;

        private a() {
            this.agH = 0;
            this.agJ = new r();
            this.agK = new r();
            this.agL = new r();
            this.agM = new r();
            this.agN = new r();
            this.agO = new r();
            this.agP = new r();
            this.agQ = new r();
            this.agR = new r();
            this.agS = new r();
            this.agT = new r();
            this.agU = new r();
            this.agV = new r();
            this.agW = new r();
            this.agX = new r();
        }

        public int uV() {
            return this.agJ.num + this.agK.num + this.agL.num + this.agM.num + this.agN.num;
        }

        public int uW() {
            return this.agJ.num + this.agK.num + this.agL.num + this.agM.num + this.agN.num + this.agO.num + this.agP.num + this.agQ.num + this.agR.num + this.agS.num + this.agT.num + this.agU.num + this.agV.num + this.agW.num + this.agX.num;
        }

        public int uX() {
            return this.agO.num + this.agP.num + this.agQ.num + this.agR.num + this.agS.num;
        }

        public int uY() {
            return this.agT.num + this.agU.num + this.agV.num + this.agW.num + this.agX.num;
        }

        public void reset() {
            this.agH = 0;
            this.agJ.reset();
            this.agK.reset();
            this.agL.reset();
            this.agM.reset();
            this.agN.reset();
            this.agO.reset();
            this.agP.reset();
            this.agQ.reset();
            this.agR.reset();
            this.agS.reset();
            this.agT.reset();
            this.agU.reset();
            this.agV.reset();
            this.agW.reset();
            this.agX.reset();
        }
    }

    private static r a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return agD.agJ;
            }
            if (str.startsWith("http://tb.himg")) {
                return agD.agK;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return agD.agL;
            }
            if (z2 && z3) {
                return agD.agN;
            }
            return agD.agM;
        } else if (com.baidu.adp.lib.util.j.gU()) {
            if (z2) {
                return agD.agO;
            }
            if (str.startsWith("http://tb.himg")) {
                return agD.agP;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return agD.agQ;
            }
            return agD.agR;
        } else if (z2) {
            return agD.agT;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return agD.agU;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return agD.agV;
            }
            return agD.agW;
        }
    }

    public static com.baidu.adp.lib.stats.a fq() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (syncLock) {
                agE.num++;
                agE.time += j;
                if (agE.num >= 100) {
                    uO();
                }
            }
        }
    }

    public static void uO() {
        if (agE.num > 10) {
            com.baidu.adp.lib.stats.a fq = fq();
            fq.append(SocialConstants.PARAM_ACT, "locStat");
            fq.append("costTime", String.valueOf(agE.time));
            fq.append("num", String.valueOf(agE.num));
            fq.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", fq);
            agE.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.l.hg() && dVar != null) {
            String str6 = "";
            boolean ha = com.baidu.tbadk.util.i.ha(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().ajJ) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean gQ = com.baidu.adp.lib.util.j.gQ();
            if (!z5) {
                z4 = false;
            } else if (gQ) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().TF);
            } else if (com.baidu.adp.lib.util.j.gU()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().TH);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().TG);
            }
            boolean z6 = false;
            if (ha && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (ha && gQ && z6) {
                if (z) {
                    p.getInstance().insertNormalData(j, str);
                } else {
                    str6 = t.uZ().va();
                    if (!TextUtils.isEmpty(str6)) {
                        p.getInstance().insertErrorData(dVar.tG, str);
                    }
                }
            }
            if (ha) {
                agG = str;
            }
            boolean z7 = false;
            if (dVar.tI != null && dVar.tI.length() > 0) {
                z7 = true;
            }
            synchronized (syncLock) {
                r a2 = a(gQ, ha, str2, z7);
                boolean z8 = agD.agI;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.tA += j2;
                        agD.agI = true;
                        if (z4) {
                            a2.agz++;
                        }
                        agC = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.gP()) {
                            int i2 = agC + 1;
                            agC = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.gg().getMaxAlertCount("alert_img", 5)) {
                                BdStatisticsManager.getInstance().alert("alert_img", "imgFailedCnt_" + String.valueOf(agC) + "_url=" + str2);
                            }
                        }
                        a2.agy++;
                        agD.agI = false;
                    }
                }
                int uW = agD.uW();
                if (uW > 100 || (uW > 0 && z8 != agD.agI)) {
                    uP();
                }
            }
            if (z && z5) {
                if (!gQ || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().TF) {
                    if (gQ || !com.baidu.adp.lib.util.j.gU() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().TH) {
                        if (!gQ && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().TG) {
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
                aVar = fq();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = t.uZ().va();
            }
            if (!ha || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = t.uZ().dW(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = uR();
            }
            aVar.append("url", str);
            aVar.append(SocialConstants.PARAM_ACT, "dl");
            aVar.append("result", z ? "1" : "0");
            aVar.append("fullurl", str2);
            aVar.append("netlib", String.valueOf(dVar.tM));
            aVar.append("costTime", String.valueOf(j));
            aVar.append("connTime", String.valueOf(dVar.connectTime));
            aVar.append("rspTime", String.valueOf(dVar.tB));
            aVar.append("retry", String.valueOf(dVar.tC));
            aVar.append("localIp", d.getIp());
            aVar.append("tiebaIp", str6);
            aVar.append("cdnIp", str4);
            aVar.append("useIp", dVar.tI);
            aVar.append("dnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.append("connBaidu", String.valueOf(uS()));
            }
            aVar.append("memory", uT());
            aVar.append("task", uU());
            aVar.append("status", String.valueOf(dVar.tH));
            aVar.append("up", String.valueOf(dVar.tz));
            aVar.append("down", String.valueOf(dVar.tA));
            aVar.append("isCDN", ha ? "1" : "0");
            aVar.append("isWebp", bool.booleanValue() ? "1" : "0");
            aVar.append("isMobileProxy", z3 ? "1" : "0");
            aVar.append(com.baidu.fsg.base.statistics.b.k, dVar.tF);
            aVar.append("reason", str3);
            if (i != 0) {
                aVar.f("procType", Integer.valueOf(i));
            }
            if (dVar.tK != null) {
                aVar.append("tracecode1", dVar.tK);
            }
            if (dVar.tL != null) {
                aVar.append("tracecode2", dVar.tL);
            }
            BdStatisticsManager.getInstance().debug("img", aVar);
            if (ha && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                agD.agH++;
            }
        }
    }

    public static void uP() {
        if (agD.uW() > 10) {
            if (agD.uV() > 0) {
                a(agD.agJ, agD.agK, agD.agL, agD.agN, agD.agM, 10000);
                com.baidu.tbadk.k.n.b(agD.agJ, agD.agK, agD.agL, agD.agN, agD.agM, 3);
            }
            if (agD.uY() > 0) {
                a(agD.agT, agD.agU, agD.agV, agD.agX, agD.agW, 100002);
                com.baidu.tbadk.k.n.b(agD.agT, agD.agU, agD.agV, agD.agX, agD.agW, 2);
            }
            if (agD.uX() > 0) {
                a(agD.agO, agD.agP, agD.agQ, agD.agS, agD.agR, AccountCenterCallback.REQUEST_CODE_LOGIN);
                com.baidu.tbadk.k.n.b(agD.agO, agD.agP, agD.agQ, agD.agS, agD.agR, 1);
            }
            agD.reset();
        }
    }

    public static void a(r rVar, r rVar2, r rVar3, r rVar4, r rVar5, int i) {
        if (rVar != null && rVar2 != null && rVar3 != null && rVar4 != null && rVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = t.uZ().va();
            }
            if (agG != null && TextUtils.isEmpty("")) {
                str2 = t.uZ().dW(agG);
            }
            if (TextUtils.isEmpty("")) {
                str3 = uR();
            }
            com.baidu.adp.lib.stats.a fq = fq();
            fq.append(SocialConstants.PARAM_ACT, "dlStat");
            fq.append("cdnCostTime", String.valueOf(rVar.time));
            fq.append("cdnNum", String.valueOf(rVar.num));
            fq.append("cdnFailnum", String.valueOf(rVar.agy));
            fq.append("portraitCostTime", String.valueOf(rVar2.time));
            fq.append("portraitNum", String.valueOf(rVar2.num));
            fq.append("portraitFailnum", String.valueOf(rVar2.agy));
            fq.append("tiebaCostTime", String.valueOf(rVar3.time));
            fq.append("tiebaNum", String.valueOf(rVar3.num));
            fq.append("tiebaFailnum", String.valueOf(rVar3.agy));
            fq.append("otherCostTime", String.valueOf(rVar5.time));
            fq.append("otherNum", String.valueOf(rVar5.num));
            fq.append("otherFailnum", String.valueOf(rVar5.agy));
            fq.append("directIpCostTime", String.valueOf(rVar4.time));
            fq.append("directIpNum", String.valueOf(rVar4.num));
            fq.append("directIpFailnum", String.valueOf(rVar4.agy));
            fq.append("dnsFailNum", String.valueOf(agD.agH));
            if (10000 == i) {
                fq.append("isWifi", "1");
                fq.append("netType", "WIFI");
            } else if (100002 == i) {
                fq.append("netType", "3G");
                fq.append("isWifi", "0");
            } else {
                fq.append("netType", "2G");
                fq.append("isWifi", "0");
            }
            fq.append("localIp", d.getIp());
            fq.append("tbIp", str);
            fq.append("cdnIp", str2);
            fq.append("dnsIp", str3);
            BdStatisticsManager.getInstance().debug("img", fq);
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.l.hg()) {
            synchronized (syncLock) {
                agF.num++;
                if (z) {
                    agF.time += j;
                } else {
                    agF.agy++;
                }
                if (agF.num >= 100) {
                    uQ();
                }
            }
            if (!z) {
                if (aVar == null) {
                    aVar = fq();
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
                BdStatisticsManager.getInstance().debug("img", aVar);
            }
        }
    }

    public static void uQ() {
        if (agF.num > 10) {
            com.baidu.adp.lib.stats.a fq = fq();
            fq.append(SocialConstants.PARAM_ACT, "dcStat");
            fq.append("costTime", String.valueOf(agF.time));
            fq.append("num", String.valueOf(agF.num));
            fq.append("failnum", String.valueOf(agF.agy));
            BdStatisticsManager.getInstance().debug("img", fq);
            com.baidu.tbadk.k.n.a(agF.num, agF.agy, agF.time);
            agF.reset();
        }
    }

    public static void dV(String str) {
        com.baidu.adp.lib.stats.a fq = fq();
        fq.append(SocialConstants.PARAM_ACT, "assistant");
        fq.append("content", str);
        BdStatisticsManager.getInstance().debug("img", fq);
    }

    private static String uR() {
        try {
            DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApp().getSystemService("wifi")).getDhcpInfo();
            return intToIp(dhcpInfo.dns1) + Constants.ACCEPT_TIME_SEPARATOR_SP + intToIp(dhcpInfo.dns2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String intToIp(int i) {
        return (i & 255) + com.baidu.ar.util.Constants.DOT + ((i >> 8) & 255) + com.baidu.ar.util.Constants.DOT + ((i >> 16) & 255) + com.baidu.ar.util.Constants.DOT + ((i >> 24) & 255);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [599=5] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long uS() {
        HttpURLConnection httpURLConnection;
        long j;
        if (agA >= 3) {
            return agB;
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
            if (agA > -1) {
                agB = ((agB * agA) + j) / (agA + 1);
            } else {
                agB = j;
            }
            agA++;
            return j;
        }
        return j;
    }

    private static String uT() {
        return com.baidu.tbadk.imageManager.c.EY().dR();
    }

    private static String uU() {
        return com.baidu.adp.lib.asyncTask.a.dS().dR();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.a fq = fq();
        fq.append(SocialConstants.PARAM_ACT, "getCDNList");
        fq.append("errorNum", str);
        fq.append("errorMsg", str2);
        fq.append("isShortNetError", z2 ? "1" : "0");
        fq.append("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug("img", fq);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = t.uZ().dW(str);
        }
        String uR = uR();
        String ip = d.getIp();
        com.baidu.adp.lib.stats.a fq = fq();
        fq.append(SocialConstants.PARAM_ACT, "tachometerCDN");
        fq.append("errorNum", str3);
        fq.append("execption", str4);
        fq.append("size", str5);
        fq.append("isScuess", z ? "1" : "0");
        fq.append("url", str);
        fq.append("localIp", ip);
        fq.append("cdnIp", str6);
        fq.append("dnsIP", uR);
        fq.append("usedIp", str2);
        fq.append("isUsedIp", z2 ? "0" : "1");
        fq.append("costTime", String.valueOf(j));
        BdStatisticsManager.getInstance().debug("img", fq);
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
                    com.baidu.adp.lib.stats.a fq = fq();
                    fq.append(SocialConstants.PARAM_ACT, "mobileTachometerCDN");
                    fq.append("costTime", String.valueOf(j));
                    fq.append("ipList", sb.toString());
                    BdStatisticsManager.getInstance().debug("img", fq);
                    return;
                }
            }
        }
    }

    public static void d(boolean z, String str) {
        com.baidu.adp.lib.stats.a fq = fq();
        fq.append(SocialConstants.PARAM_ACT, "getCDNList");
        fq.append("isSuccess", z ? "1" : "0");
        fq.append("errorMsg", str);
        BdStatisticsManager.getInstance().debug("img", fq);
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
