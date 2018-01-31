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
    private static long aTL = 0;
    private static long aTM = 0;
    private static int aTN = 0;
    private static a aTO = new a();
    private static r aTP = new r();
    private static r aTQ = new r();
    private static String aTR = null;
    private static Object syncLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int aTS;
        boolean aTT;
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
        r aUg;
        r aUh;
        r aUi;

        private a() {
            this.aTS = 0;
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
            this.aUg = new r();
            this.aUh = new r();
            this.aUi = new r();
        }

        public int BT() {
            return this.aTU.num + this.aTV.num + this.aTW.num + this.aTX.num + this.aTY.num;
        }

        public int BU() {
            return this.aTU.num + this.aTV.num + this.aTW.num + this.aTX.num + this.aTY.num + this.aTZ.num + this.aUa.num + this.aUb.num + this.aUc.num + this.aUd.num + this.aUe.num + this.aUf.num + this.aUg.num + this.aUh.num + this.aUi.num;
        }

        public int BV() {
            return this.aTZ.num + this.aUa.num + this.aUb.num + this.aUc.num + this.aUd.num;
        }

        public int BW() {
            return this.aUe.num + this.aUf.num + this.aUg.num + this.aUh.num + this.aUi.num;
        }

        public void reset() {
            this.aTS = 0;
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
            this.aUg.reset();
            this.aUh.reset();
            this.aUi.reset();
        }
    }

    private static r a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return aTO.aTU;
            }
            if (str.startsWith("http://tb.himg")) {
                return aTO.aTV;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aTO.aTW;
            }
            if (z2 && z3) {
                return aTO.aTY;
            }
            return aTO.aTX;
        } else if (com.baidu.adp.lib.util.j.oO()) {
            if (z2) {
                return aTO.aTZ;
            }
            if (str.startsWith("http://tb.himg")) {
                return aTO.aUa;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aTO.aUb;
            }
            return aTO.aUc;
        } else if (z2) {
            return aTO.aUe;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return aTO.aUf;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aTO.aUg;
            }
            return aTO.aUh;
        }
    }

    public static com.baidu.adp.lib.stats.a nn() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (syncLock) {
                aTP.num++;
                aTP.time += j;
                if (aTP.num >= 100) {
                    BM();
                }
            }
        }
    }

    public static void BM() {
        if (aTP.num > 10) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append("act", "locStat");
            nn.append("costTime", String.valueOf(aTP.time));
            nn.append("num", String.valueOf(aTP.num));
            nn.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", nn);
            aTP.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.l.pa() && dVar != null) {
            String str6 = "";
            boolean gY = com.baidu.tbadk.util.i.gY(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().aWH) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean oK = com.baidu.adp.lib.util.j.oK();
            if (!z5) {
                z4 = false;
            } else if (oK) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aHg);
            } else if (com.baidu.adp.lib.util.j.oO()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aHi);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aHh);
            }
            boolean z6 = false;
            if (gY && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (gY && oK && z6) {
                if (z) {
                    p.getInstance().insertNormalData(j, str);
                } else {
                    str6 = t.BX().BY();
                    if (!TextUtils.isEmpty(str6)) {
                        p.getInstance().insertErrorData(dVar.ajn, str);
                    }
                }
            }
            if (gY) {
                aTR = str;
            }
            boolean z7 = false;
            if (dVar.ajp != null && dVar.ajp.length() > 0) {
                z7 = true;
            }
            synchronized (syncLock) {
                r a2 = a(oK, gY, str2, z7);
                boolean z8 = aTO.aTT;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.ajh += j2;
                        aTO.aTT = true;
                        if (z4) {
                            a2.aTK++;
                        }
                        aTN = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.oJ()) {
                            int i2 = aTN + 1;
                            aTN = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.ob().getMaxAlertCount("alert_img", 5)) {
                                BdStatisticsManager.getInstance().alert("alert_img", "imgFailedCnt_" + String.valueOf(aTN) + "_url=" + str2);
                            }
                        }
                        a2.aTJ++;
                        aTO.aTT = false;
                    }
                }
                int BU = aTO.BU();
                if (BU > 100 || (BU > 0 && z8 != aTO.aTT)) {
                    BN();
                }
            }
            if (z && z5) {
                if (!oK || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aHg) {
                    if (oK || !com.baidu.adp.lib.util.j.oO() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aHi) {
                        if (!oK && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aHh) {
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
                aVar = nn();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = t.BX().BY();
            }
            if (!gY || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = t.BX().dS(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = BP();
            }
            aVar.append("url", str);
            aVar.append("act", "dl");
            aVar.append("result", z ? "1" : "0");
            aVar.append("fullurl", str2);
            aVar.append("netlib", String.valueOf(dVar.ajt));
            aVar.append("costTime", String.valueOf(j));
            aVar.append("connTime", String.valueOf(dVar.connectTime));
            aVar.append("rspTime", String.valueOf(dVar.aji));
            aVar.append("retry", String.valueOf(dVar.ajj));
            aVar.append("localIp", d.getIp());
            aVar.append("tiebaIp", str6);
            aVar.append("cdnIp", str4);
            aVar.append("useIp", dVar.ajp);
            aVar.append("dnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.append("connBaidu", String.valueOf(BQ()));
            }
            aVar.append("memory", BR());
            aVar.append("task", BS());
            aVar.append(NotificationCompat.CATEGORY_STATUS, String.valueOf(dVar.ajo));
            aVar.append("up", String.valueOf(dVar.ajg));
            aVar.append("down", String.valueOf(dVar.ajh));
            aVar.append("isCDN", gY ? "1" : "0");
            aVar.append("isWebp", bool.booleanValue() ? "1" : "0");
            aVar.append("isMobileProxy", z3 ? "1" : "0");
            aVar.append("exception", dVar.ajm);
            aVar.append("reason", str3);
            if (i != 0) {
                aVar.h("procType", Integer.valueOf(i));
            }
            if (dVar.ajr != null) {
                aVar.append("tracecode1", dVar.ajr);
            }
            if (dVar.ajs != null) {
                aVar.append("tracecode2", dVar.ajs);
            }
            BdStatisticsManager.getInstance().debug("img", aVar);
            if (gY && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                aTO.aTS++;
            }
        }
    }

    public static void BN() {
        if (aTO.BU() > 10) {
            if (aTO.BT() > 0) {
                a(aTO.aTU, aTO.aTV, aTO.aTW, aTO.aTY, aTO.aTX, 10000);
                com.baidu.tbadk.k.o.b(aTO.aTU, aTO.aTV, aTO.aTW, aTO.aTY, aTO.aTX, 3);
            }
            if (aTO.BW() > 0) {
                a(aTO.aUe, aTO.aUf, aTO.aUg, aTO.aUi, aTO.aUh, 100002);
                com.baidu.tbadk.k.o.b(aTO.aUe, aTO.aUf, aTO.aUg, aTO.aUi, aTO.aUh, 2);
            }
            if (aTO.BV() > 0) {
                a(aTO.aTZ, aTO.aUa, aTO.aUb, aTO.aUd, aTO.aUc, 100001);
                com.baidu.tbadk.k.o.b(aTO.aTZ, aTO.aUa, aTO.aUb, aTO.aUd, aTO.aUc, 1);
            }
            aTO.reset();
        }
    }

    public static void a(r rVar, r rVar2, r rVar3, r rVar4, r rVar5, int i) {
        if (rVar != null && rVar2 != null && rVar3 != null && rVar4 != null && rVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = t.BX().BY();
            }
            if (aTR != null && TextUtils.isEmpty("")) {
                str2 = t.BX().dS(aTR);
            }
            if (TextUtils.isEmpty("")) {
                str3 = BP();
            }
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append("act", "dlStat");
            nn.append("cdnCostTime", String.valueOf(rVar.time));
            nn.append("cdnNum", String.valueOf(rVar.num));
            nn.append("cdnFailnum", String.valueOf(rVar.aTJ));
            nn.append("portraitCostTime", String.valueOf(rVar2.time));
            nn.append("portraitNum", String.valueOf(rVar2.num));
            nn.append("portraitFailnum", String.valueOf(rVar2.aTJ));
            nn.append("tiebaCostTime", String.valueOf(rVar3.time));
            nn.append("tiebaNum", String.valueOf(rVar3.num));
            nn.append("tiebaFailnum", String.valueOf(rVar3.aTJ));
            nn.append("otherCostTime", String.valueOf(rVar5.time));
            nn.append("otherNum", String.valueOf(rVar5.num));
            nn.append("otherFailnum", String.valueOf(rVar5.aTJ));
            nn.append("directIpCostTime", String.valueOf(rVar4.time));
            nn.append("directIpNum", String.valueOf(rVar4.num));
            nn.append("directIpFailnum", String.valueOf(rVar4.aTJ));
            nn.append("dnsFailNum", String.valueOf(aTO.aTS));
            if (10000 == i) {
                nn.append("isWifi", "1");
                nn.append("netType", "WIFI");
            } else if (100002 == i) {
                nn.append("netType", "3G");
                nn.append("isWifi", "0");
            } else {
                nn.append("netType", "2G");
                nn.append("isWifi", "0");
            }
            nn.append("localIp", d.getIp());
            nn.append("tbIp", str);
            nn.append("cdnIp", str2);
            nn.append("dnsIp", str3);
            BdStatisticsManager.getInstance().debug("img", nn);
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.l.pa()) {
            synchronized (syncLock) {
                aTQ.num++;
                if (z) {
                    aTQ.time += j;
                } else {
                    aTQ.aTJ++;
                }
                if (aTQ.num >= 100) {
                    BO();
                }
            }
            if (!z) {
                if (aVar == null) {
                    aVar = nn();
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

    public static void BO() {
        if (aTQ.num > 10) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append("act", "dcStat");
            nn.append("costTime", String.valueOf(aTQ.time));
            nn.append("num", String.valueOf(aTQ.num));
            nn.append("failnum", String.valueOf(aTQ.aTJ));
            BdStatisticsManager.getInstance().debug("img", nn);
            com.baidu.tbadk.k.o.a(aTQ.num, aTQ.aTJ, aTQ.time);
            aTQ.reset();
        }
    }

    public static void dR(String str) {
        com.baidu.adp.lib.stats.a nn = nn();
        nn.append("act", "assistant");
        nn.append("content", str);
        BdStatisticsManager.getInstance().debug("img", nn);
    }

    private static String BP() {
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
    private static long BQ() {
        HttpURLConnection httpURLConnection;
        long j;
        if (aTL >= 3) {
            return aTM;
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
            if (aTL > -1) {
                aTM = ((aTM * aTL) + j) / (aTL + 1);
            } else {
                aTM = j;
            }
            aTL++;
            return j;
        }
        return j;
    }

    private static String BR() {
        return com.baidu.tbadk.imageManager.c.LR().lN();
    }

    private static String BS() {
        return com.baidu.adp.lib.asyncTask.a.lO().lN();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.a nn = nn();
        nn.append("act", "getCDNList");
        nn.append("errorNum", str);
        nn.append("errorMsg", str2);
        nn.append("isShortNetError", z2 ? "1" : "0");
        nn.append("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug("img", nn);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = t.BX().dS(str);
        }
        String BP = BP();
        String ip = d.getIp();
        com.baidu.adp.lib.stats.a nn = nn();
        nn.append("act", "tachometerCDN");
        nn.append("errorNum", str3);
        nn.append("execption", str4);
        nn.append("size", str5);
        nn.append("isScuess", z ? "1" : "0");
        nn.append("url", str);
        nn.append("localIp", ip);
        nn.append("cdnIp", str6);
        nn.append("dnsIP", BP);
        nn.append("usedIp", str2);
        nn.append("isUsedIp", z2 ? "0" : "1");
        nn.append("costTime", String.valueOf(j));
        BdStatisticsManager.getInstance().debug("img", nn);
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
                    com.baidu.adp.lib.stats.a nn = nn();
                    nn.append("act", "mobileTachometerCDN");
                    nn.append("costTime", String.valueOf(j));
                    nn.append("ipList", sb.toString());
                    BdStatisticsManager.getInstance().debug("img", nn);
                    return;
                }
            }
        }
    }

    public static void d(boolean z, String str) {
        com.baidu.adp.lib.stats.a nn = nn();
        nn.append("act", "getCDNList");
        nn.append("isSuccess", z ? "1" : "0");
        nn.append("errorMsg", str);
        BdStatisticsManager.getInstance().debug("img", nn);
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
