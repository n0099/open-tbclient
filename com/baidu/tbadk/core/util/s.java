package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.xiaomi.mipush.sdk.Constants;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class s {
    private static long aTI = 0;
    private static long aTJ = 0;
    private static int aTK = 0;
    private static a aTL = new a();
    private static r aTM = new r();
    private static r aTN = new r();
    private static String aTO = null;
    private static Object syncLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int aTP;
        boolean aTQ;
        r aTR;
        r aTS;
        r aTT;
        r aTU;
        r aTV;
        r aTW;
        r aTX;
        r aTY;
        r aTZ;
        r aUa;
        r aUb;
        r aUc;
        r aUd;
        r aUe;
        r aUf;

        private a() {
            this.aTP = 0;
            this.aTR = new r();
            this.aTS = new r();
            this.aTT = new r();
            this.aTU = new r();
            this.aTV = new r();
            this.aTW = new r();
            this.aTX = new r();
            this.aTY = new r();
            this.aTZ = new r();
            this.aUa = new r();
            this.aUb = new r();
            this.aUc = new r();
            this.aUd = new r();
            this.aUe = new r();
            this.aUf = new r();
        }

        public int BS() {
            return this.aTR.num + this.aTS.num + this.aTT.num + this.aTU.num + this.aTV.num;
        }

        public int BT() {
            return this.aTR.num + this.aTS.num + this.aTT.num + this.aTU.num + this.aTV.num + this.aTW.num + this.aTX.num + this.aTY.num + this.aTZ.num + this.aUa.num + this.aUb.num + this.aUc.num + this.aUd.num + this.aUe.num + this.aUf.num;
        }

        public int BU() {
            return this.aTW.num + this.aTX.num + this.aTY.num + this.aTZ.num + this.aUa.num;
        }

        public int BV() {
            return this.aUb.num + this.aUc.num + this.aUd.num + this.aUe.num + this.aUf.num;
        }

        public void reset() {
            this.aTP = 0;
            this.aTR.reset();
            this.aTS.reset();
            this.aTT.reset();
            this.aTU.reset();
            this.aTV.reset();
            this.aTW.reset();
            this.aTX.reset();
            this.aTY.reset();
            this.aTZ.reset();
            this.aUa.reset();
            this.aUb.reset();
            this.aUc.reset();
            this.aUd.reset();
            this.aUe.reset();
            this.aUf.reset();
        }
    }

    private static r a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return aTL.aTR;
            }
            if (str.startsWith("http://tb.himg")) {
                return aTL.aTS;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aTL.aTT;
            }
            if (z2 && z3) {
                return aTL.aTV;
            }
            return aTL.aTU;
        } else if (com.baidu.adp.lib.util.j.oN()) {
            if (z2) {
                return aTL.aTW;
            }
            if (str.startsWith("http://tb.himg")) {
                return aTL.aTX;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aTL.aTY;
            }
            return aTL.aTZ;
        } else if (z2) {
            return aTL.aUb;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return aTL.aUc;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aTL.aUd;
            }
            return aTL.aUe;
        }
    }

    public static com.baidu.adp.lib.stats.a nm() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (syncLock) {
                aTM.num++;
                aTM.time += j;
                if (aTM.num >= 100) {
                    BL();
                }
            }
        }
    }

    public static void BL() {
        if (aTM.num > 10) {
            com.baidu.adp.lib.stats.a nm = nm();
            nm.append("act", "locStat");
            nm.append("costTime", String.valueOf(aTM.time));
            nm.append("num", String.valueOf(aTM.num));
            nm.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", nm);
            aTM.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.l.oZ() && dVar != null) {
            String str6 = "";
            boolean gR = com.baidu.tbadk.util.i.gR(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().aWE) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean oJ = com.baidu.adp.lib.util.j.oJ();
            if (!z5) {
                z4 = false;
            } else if (oJ) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aHd);
            } else if (com.baidu.adp.lib.util.j.oN()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aHf);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aHe);
            }
            boolean z6 = false;
            if (gR && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (gR && oJ && z6) {
                if (z) {
                    p.getInstance().insertNormalData(j, str);
                } else {
                    str6 = t.BW().BX();
                    if (!TextUtils.isEmpty(str6)) {
                        p.getInstance().insertErrorData(dVar.ajk, str);
                    }
                }
            }
            if (gR) {
                aTO = str;
            }
            boolean z7 = false;
            if (dVar.ajm != null && dVar.ajm.length() > 0) {
                z7 = true;
            }
            synchronized (syncLock) {
                r a2 = a(oJ, gR, str2, z7);
                boolean z8 = aTL.aTQ;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.aje += j2;
                        aTL.aTQ = true;
                        if (z4) {
                            a2.aTH++;
                        }
                        aTK = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.oI()) {
                            int i2 = aTK + 1;
                            aTK = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.oa().getMaxAlertCount("alert_img", 5)) {
                                BdStatisticsManager.getInstance().alert("alert_img", "imgFailedCnt_" + String.valueOf(aTK) + "_url=" + str2);
                            }
                        }
                        a2.aTG++;
                        aTL.aTQ = false;
                    }
                }
                int BT = aTL.BT();
                if (BT > 100 || (BT > 0 && z8 != aTL.aTQ)) {
                    BM();
                }
            }
            if (z && z5) {
                if (!oJ || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aHd) {
                    if (oJ || !com.baidu.adp.lib.util.j.oN() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aHf) {
                        if (!oJ && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aHe) {
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
                aVar = nm();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = t.BW().BX();
            }
            if (!gR || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = t.BW().dN(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = BO();
            }
            aVar.append("url", str);
            aVar.append("act", "dl");
            aVar.append("result", z ? "1" : "0");
            aVar.append("fullurl", str2);
            aVar.append("netlib", String.valueOf(dVar.ajq));
            aVar.append("costTime", String.valueOf(j));
            aVar.append("connTime", String.valueOf(dVar.connectTime));
            aVar.append("rspTime", String.valueOf(dVar.ajf));
            aVar.append("retry", String.valueOf(dVar.ajg));
            aVar.append("localIp", d.getIp());
            aVar.append("tiebaIp", str6);
            aVar.append("cdnIp", str4);
            aVar.append("useIp", dVar.ajm);
            aVar.append("dnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.append("connBaidu", String.valueOf(BP()));
            }
            aVar.append("memory", BQ());
            aVar.append("task", BR());
            aVar.append(NotificationCompat.CATEGORY_STATUS, String.valueOf(dVar.ajl));
            aVar.append("up", String.valueOf(dVar.ajd));
            aVar.append("down", String.valueOf(dVar.aje));
            aVar.append("isCDN", gR ? "1" : "0");
            aVar.append("isWebp", bool.booleanValue() ? "1" : "0");
            aVar.append("isMobileProxy", z3 ? "1" : "0");
            aVar.append("exception", dVar.ajj);
            aVar.append("reason", str3);
            if (i != 0) {
                aVar.h("procType", Integer.valueOf(i));
            }
            if (dVar.ajo != null) {
                aVar.append("tracecode1", dVar.ajo);
            }
            if (dVar.ajp != null) {
                aVar.append("tracecode2", dVar.ajp);
            }
            BdStatisticsManager.getInstance().debug("img", aVar);
            if (gR && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                aTL.aTP++;
            }
        }
    }

    public static void BM() {
        if (aTL.BT() > 10) {
            if (aTL.BS() > 0) {
                a(aTL.aTR, aTL.aTS, aTL.aTT, aTL.aTV, aTL.aTU, 10000);
                com.baidu.tbadk.k.o.b(aTL.aTR, aTL.aTS, aTL.aTT, aTL.aTV, aTL.aTU, 3);
            }
            if (aTL.BV() > 0) {
                a(aTL.aUb, aTL.aUc, aTL.aUd, aTL.aUf, aTL.aUe, 100002);
                com.baidu.tbadk.k.o.b(aTL.aUb, aTL.aUc, aTL.aUd, aTL.aUf, aTL.aUe, 2);
            }
            if (aTL.BU() > 0) {
                a(aTL.aTW, aTL.aTX, aTL.aTY, aTL.aUa, aTL.aTZ, 100001);
                com.baidu.tbadk.k.o.b(aTL.aTW, aTL.aTX, aTL.aTY, aTL.aUa, aTL.aTZ, 1);
            }
            aTL.reset();
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
            if (aTO != null && TextUtils.isEmpty("")) {
                str2 = t.BW().dN(aTO);
            }
            if (TextUtils.isEmpty("")) {
                str3 = BO();
            }
            com.baidu.adp.lib.stats.a nm = nm();
            nm.append("act", "dlStat");
            nm.append("cdnCostTime", String.valueOf(rVar.time));
            nm.append("cdnNum", String.valueOf(rVar.num));
            nm.append("cdnFailnum", String.valueOf(rVar.aTG));
            nm.append("portraitCostTime", String.valueOf(rVar2.time));
            nm.append("portraitNum", String.valueOf(rVar2.num));
            nm.append("portraitFailnum", String.valueOf(rVar2.aTG));
            nm.append("tiebaCostTime", String.valueOf(rVar3.time));
            nm.append("tiebaNum", String.valueOf(rVar3.num));
            nm.append("tiebaFailnum", String.valueOf(rVar3.aTG));
            nm.append("otherCostTime", String.valueOf(rVar5.time));
            nm.append("otherNum", String.valueOf(rVar5.num));
            nm.append("otherFailnum", String.valueOf(rVar5.aTG));
            nm.append("directIpCostTime", String.valueOf(rVar4.time));
            nm.append("directIpNum", String.valueOf(rVar4.num));
            nm.append("directIpFailnum", String.valueOf(rVar4.aTG));
            nm.append("dnsFailNum", String.valueOf(aTL.aTP));
            if (10000 == i) {
                nm.append("isWifi", "1");
                nm.append("netType", "WIFI");
            } else if (100002 == i) {
                nm.append("netType", "3G");
                nm.append("isWifi", "0");
            } else {
                nm.append("netType", "2G");
                nm.append("isWifi", "0");
            }
            nm.append("localIp", d.getIp());
            nm.append("tbIp", str);
            nm.append("cdnIp", str2);
            nm.append("dnsIp", str3);
            BdStatisticsManager.getInstance().debug("img", nm);
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.l.oZ()) {
            synchronized (syncLock) {
                aTN.num++;
                if (z) {
                    aTN.time += j;
                } else {
                    aTN.aTG++;
                }
                if (aTN.num >= 100) {
                    BN();
                }
            }
            if (!z) {
                if (aVar == null) {
                    aVar = nm();
                }
                aVar.append("act", "dc");
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

    public static void BN() {
        if (aTN.num > 10) {
            com.baidu.adp.lib.stats.a nm = nm();
            nm.append("act", "dcStat");
            nm.append("costTime", String.valueOf(aTN.time));
            nm.append("num", String.valueOf(aTN.num));
            nm.append("failnum", String.valueOf(aTN.aTG));
            BdStatisticsManager.getInstance().debug("img", nm);
            com.baidu.tbadk.k.o.a(aTN.num, aTN.aTG, aTN.time);
            aTN.reset();
        }
    }

    public static void dM(String str) {
        com.baidu.adp.lib.stats.a nm = nm();
        nm.append("act", "assistant");
        nm.append("content", str);
        BdStatisticsManager.getInstance().debug("img", nm);
    }

    private static String BO() {
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
    private static long BP() {
        HttpURLConnection httpURLConnection;
        long j;
        if (aTI >= 3) {
            return aTJ;
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
            if (aTI > -1) {
                aTJ = ((aTJ * aTI) + j) / (aTI + 1);
            } else {
                aTJ = j;
            }
            aTI++;
            return j;
        }
        return j;
    }

    private static String BQ() {
        return com.baidu.tbadk.imageManager.c.LP().lM();
    }

    private static String BR() {
        return com.baidu.adp.lib.asyncTask.a.lN().lM();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.a nm = nm();
        nm.append("act", "getCDNList");
        nm.append("errorNum", str);
        nm.append("errorMsg", str2);
        nm.append("isShortNetError", z2 ? "1" : "0");
        nm.append("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug("img", nm);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = t.BW().dN(str);
        }
        String BO = BO();
        String ip = d.getIp();
        com.baidu.adp.lib.stats.a nm = nm();
        nm.append("act", "tachometerCDN");
        nm.append("errorNum", str3);
        nm.append("execption", str4);
        nm.append("size", str5);
        nm.append("isScuess", z ? "1" : "0");
        nm.append("url", str);
        nm.append("localIp", ip);
        nm.append("cdnIp", str6);
        nm.append("dnsIP", BO);
        nm.append("usedIp", str2);
        nm.append("isUsedIp", z2 ? "0" : "1");
        nm.append("costTime", String.valueOf(j));
        BdStatisticsManager.getInstance().debug("img", nm);
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
                    com.baidu.adp.lib.stats.a nm = nm();
                    nm.append("act", "mobileTachometerCDN");
                    nm.append("costTime", String.valueOf(j));
                    nm.append("ipList", sb.toString());
                    BdStatisticsManager.getInstance().debug("img", nm);
                    return;
                }
            }
        }
    }

    public static void d(boolean z, String str) {
        com.baidu.adp.lib.stats.a nm = nm();
        nm.append("act", "getCDNList");
        nm.append("isSuccess", z ? "1" : "0");
        nm.append("errorMsg", str);
        BdStatisticsManager.getInstance().debug("img", nm);
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
