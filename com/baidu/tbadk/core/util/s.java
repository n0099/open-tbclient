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
    private static long aTJ = 0;
    private static long aTK = 0;
    private static int aTL = 0;
    private static a aTM = new a();
    private static r aTN = new r();
    private static r aTO = new r();
    private static String aTP = null;
    private static Object syncLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int aTQ;
        boolean aTR;
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
        r aUg;

        private a() {
            this.aTQ = 0;
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
            this.aUg = new r();
        }

        public int Ca() {
            return this.aTS.num + this.aTT.num + this.aTU.num + this.aTV.num + this.aTW.num;
        }

        public int Cb() {
            return this.aTS.num + this.aTT.num + this.aTU.num + this.aTV.num + this.aTW.num + this.aTX.num + this.aTY.num + this.aTZ.num + this.aUa.num + this.aUb.num + this.aUc.num + this.aUd.num + this.aUe.num + this.aUf.num + this.aUg.num;
        }

        public int Cc() {
            return this.aTX.num + this.aTY.num + this.aTZ.num + this.aUa.num + this.aUb.num;
        }

        public int Cd() {
            return this.aUc.num + this.aUd.num + this.aUe.num + this.aUf.num + this.aUg.num;
        }

        public void reset() {
            this.aTQ = 0;
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
            this.aUg.reset();
        }
    }

    private static r a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return aTM.aTS;
            }
            if (str.startsWith("http://tb.himg")) {
                return aTM.aTT;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aTM.aTU;
            }
            if (z2 && z3) {
                return aTM.aTW;
            }
            return aTM.aTV;
        } else if (com.baidu.adp.lib.util.j.oN()) {
            if (z2) {
                return aTM.aTX;
            }
            if (str.startsWith("http://tb.himg")) {
                return aTM.aTY;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aTM.aTZ;
            }
            return aTM.aUa;
        } else if (z2) {
            return aTM.aUc;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return aTM.aUd;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aTM.aUe;
            }
            return aTM.aUf;
        }
    }

    public static com.baidu.adp.lib.stats.a nm() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (syncLock) {
                aTN.num++;
                aTN.time += j;
                if (aTN.num >= 100) {
                    BT();
                }
            }
        }
    }

    public static void BT() {
        if (aTN.num > 10) {
            com.baidu.adp.lib.stats.a nm = nm();
            nm.append("act", "locStat");
            nm.append("costTime", String.valueOf(aTN.time));
            nm.append("num", String.valueOf(aTN.num));
            nm.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", nm);
            aTN.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.l.oZ() && dVar != null) {
            String str6 = "";
            boolean gQ = com.baidu.tbadk.util.i.gQ(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().aWF) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean oJ = com.baidu.adp.lib.util.j.oJ();
            if (!z5) {
                z4 = false;
            } else if (oJ) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aHf);
            } else if (com.baidu.adp.lib.util.j.oN()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aHh);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aHg);
            }
            boolean z6 = false;
            if (gQ && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (gQ && oJ && z6) {
                if (z) {
                    p.getInstance().insertNormalData(j, str);
                } else {
                    str6 = t.Ce().Cf();
                    if (!TextUtils.isEmpty(str6)) {
                        p.getInstance().insertErrorData(dVar.ajk, str);
                    }
                }
            }
            if (gQ) {
                aTP = str;
            }
            boolean z7 = false;
            if (dVar.ajm != null && dVar.ajm.length() > 0) {
                z7 = true;
            }
            synchronized (syncLock) {
                r a2 = a(oJ, gQ, str2, z7);
                boolean z8 = aTM.aTR;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.aje += j2;
                        aTM.aTR = true;
                        if (z4) {
                            a2.aTI++;
                        }
                        aTL = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.oI()) {
                            int i2 = aTL + 1;
                            aTL = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.oa().getMaxAlertCount("alert_img", 5)) {
                                BdStatisticsManager.getInstance().alert("alert_img", "imgFailedCnt_" + String.valueOf(aTL) + "_url=" + str2);
                            }
                        }
                        a2.aTH++;
                        aTM.aTR = false;
                    }
                }
                int Cb = aTM.Cb();
                if (Cb > 100 || (Cb > 0 && z8 != aTM.aTR)) {
                    BU();
                }
            }
            if (z && z5) {
                if (!oJ || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aHf) {
                    if (oJ || !com.baidu.adp.lib.util.j.oN() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aHh) {
                        if (!oJ && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aHg) {
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
                str6 = t.Ce().Cf();
            }
            if (!gQ || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = t.Ce().dN(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = BW();
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
                aVar.append("connBaidu", String.valueOf(BX()));
            }
            aVar.append("memory", BY());
            aVar.append("task", BZ());
            aVar.append(NotificationCompat.CATEGORY_STATUS, String.valueOf(dVar.ajl));
            aVar.append("up", String.valueOf(dVar.ajd));
            aVar.append("down", String.valueOf(dVar.aje));
            aVar.append("isCDN", gQ ? "1" : "0");
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
            if (gQ && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                aTM.aTQ++;
            }
        }
    }

    public static void BU() {
        if (aTM.Cb() > 10) {
            if (aTM.Ca() > 0) {
                a(aTM.aTS, aTM.aTT, aTM.aTU, aTM.aTW, aTM.aTV, 10000);
                com.baidu.tbadk.k.o.b(aTM.aTS, aTM.aTT, aTM.aTU, aTM.aTW, aTM.aTV, 3);
            }
            if (aTM.Cd() > 0) {
                a(aTM.aUc, aTM.aUd, aTM.aUe, aTM.aUg, aTM.aUf, 100002);
                com.baidu.tbadk.k.o.b(aTM.aUc, aTM.aUd, aTM.aUe, aTM.aUg, aTM.aUf, 2);
            }
            if (aTM.Cc() > 0) {
                a(aTM.aTX, aTM.aTY, aTM.aTZ, aTM.aUb, aTM.aUa, 100001);
                com.baidu.tbadk.k.o.b(aTM.aTX, aTM.aTY, aTM.aTZ, aTM.aUb, aTM.aUa, 1);
            }
            aTM.reset();
        }
    }

    public static void a(r rVar, r rVar2, r rVar3, r rVar4, r rVar5, int i) {
        if (rVar != null && rVar2 != null && rVar3 != null && rVar4 != null && rVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = t.Ce().Cf();
            }
            if (aTP != null && TextUtils.isEmpty("")) {
                str2 = t.Ce().dN(aTP);
            }
            if (TextUtils.isEmpty("")) {
                str3 = BW();
            }
            com.baidu.adp.lib.stats.a nm = nm();
            nm.append("act", "dlStat");
            nm.append("cdnCostTime", String.valueOf(rVar.time));
            nm.append("cdnNum", String.valueOf(rVar.num));
            nm.append("cdnFailnum", String.valueOf(rVar.aTH));
            nm.append("portraitCostTime", String.valueOf(rVar2.time));
            nm.append("portraitNum", String.valueOf(rVar2.num));
            nm.append("portraitFailnum", String.valueOf(rVar2.aTH));
            nm.append("tiebaCostTime", String.valueOf(rVar3.time));
            nm.append("tiebaNum", String.valueOf(rVar3.num));
            nm.append("tiebaFailnum", String.valueOf(rVar3.aTH));
            nm.append("otherCostTime", String.valueOf(rVar5.time));
            nm.append("otherNum", String.valueOf(rVar5.num));
            nm.append("otherFailnum", String.valueOf(rVar5.aTH));
            nm.append("directIpCostTime", String.valueOf(rVar4.time));
            nm.append("directIpNum", String.valueOf(rVar4.num));
            nm.append("directIpFailnum", String.valueOf(rVar4.aTH));
            nm.append("dnsFailNum", String.valueOf(aTM.aTQ));
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
                aTO.num++;
                if (z) {
                    aTO.time += j;
                } else {
                    aTO.aTH++;
                }
                if (aTO.num >= 100) {
                    BV();
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

    public static void BV() {
        if (aTO.num > 10) {
            com.baidu.adp.lib.stats.a nm = nm();
            nm.append("act", "dcStat");
            nm.append("costTime", String.valueOf(aTO.time));
            nm.append("num", String.valueOf(aTO.num));
            nm.append("failnum", String.valueOf(aTO.aTH));
            BdStatisticsManager.getInstance().debug("img", nm);
            com.baidu.tbadk.k.o.a(aTO.num, aTO.aTH, aTO.time);
            aTO.reset();
        }
    }

    public static void dM(String str) {
        com.baidu.adp.lib.stats.a nm = nm();
        nm.append("act", "assistant");
        nm.append("content", str);
        BdStatisticsManager.getInstance().debug("img", nm);
    }

    private static String BW() {
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
    private static long BX() {
        HttpURLConnection httpURLConnection;
        long j;
        if (aTJ >= 3) {
            return aTK;
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
            if (aTJ > -1) {
                aTK = ((aTK * aTJ) + j) / (aTJ + 1);
            } else {
                aTK = j;
            }
            aTJ++;
            return j;
        }
        return j;
    }

    private static String BY() {
        return com.baidu.tbadk.imageManager.c.Mb().lM();
    }

    private static String BZ() {
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
            str6 = t.Ce().dN(str);
        }
        String BW = BW();
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
        nm.append("dnsIP", BW);
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
