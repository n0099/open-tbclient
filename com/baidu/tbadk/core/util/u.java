package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.switchs.UseHttpdnsSdkSwitch;
import com.xiaomi.mipush.sdk.Constants;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class u {
    private static long dZA = 0;
    private static long dZB = 0;
    private static int dZC = 0;
    private static a dZD = new a();
    private static t dZE = new t();
    private static t dZF = new t();
    private static String dZG = null;
    private static Object Me = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int dZH;
        boolean dZI;
        t dZJ;
        t dZK;
        t dZL;
        t dZM;
        t dZN;
        t dZO;
        t dZP;
        t dZQ;
        t dZR;
        t dZS;
        t dZT;
        t dZU;
        t dZV;
        t dZW;
        t dZX;

        private a() {
            this.dZH = 0;
            this.dZJ = new t();
            this.dZK = new t();
            this.dZL = new t();
            this.dZM = new t();
            this.dZN = new t();
            this.dZO = new t();
            this.dZP = new t();
            this.dZQ = new t();
            this.dZR = new t();
            this.dZS = new t();
            this.dZT = new t();
            this.dZU = new t();
            this.dZV = new t();
            this.dZW = new t();
            this.dZX = new t();
        }

        public int bam() {
            return this.dZJ.num + this.dZK.num + this.dZL.num + this.dZM.num + this.dZN.num;
        }

        public int ban() {
            return this.dZJ.num + this.dZK.num + this.dZL.num + this.dZM.num + this.dZN.num + this.dZO.num + this.dZP.num + this.dZQ.num + this.dZR.num + this.dZS.num + this.dZT.num + this.dZU.num + this.dZV.num + this.dZW.num + this.dZX.num;
        }

        public int bao() {
            return this.dZO.num + this.dZP.num + this.dZQ.num + this.dZR.num + this.dZS.num;
        }

        public int bap() {
            return this.dZT.num + this.dZU.num + this.dZV.num + this.dZW.num + this.dZX.num;
        }

        public void reset() {
            this.dZH = 0;
            this.dZJ.reset();
            this.dZK.reset();
            this.dZL.reset();
            this.dZM.reset();
            this.dZN.reset();
            this.dZO.reset();
            this.dZP.reset();
            this.dZQ.reset();
            this.dZR.reset();
            this.dZS.reset();
            this.dZT.reset();
            this.dZU.reset();
            this.dZV.reset();
            this.dZW.reset();
            this.dZX.reset();
        }
    }

    private static t a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return dZD.dZJ;
            }
            if (str.startsWith("http://tb.himg")) {
                return dZD.dZK;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return dZD.dZL;
            }
            if (z2 && z3) {
                return dZD.dZN;
            }
            return dZD.dZM;
        } else if (com.baidu.adp.lib.util.j.is2GNet()) {
            if (z2) {
                return dZD.dZO;
            }
            if (str.startsWith("http://tb.himg")) {
                return dZD.dZP;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return dZD.dZQ;
            }
            return dZD.dZR;
        } else if (z2) {
            return dZD.dZT;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return dZD.dZU;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return dZD.dZV;
            }
            return dZD.dZW;
        }
    }

    public static com.baidu.adp.lib.stats.a lo() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (Me) {
                dZE.num++;
                dZE.time += j;
                if (dZE.num >= 100) {
                    baf();
                }
            }
        }
    }

    public static void baf() {
        if (dZE.num > 10) {
            com.baidu.adp.lib.stats.a lo = lo();
            lo.append("act", "locStat");
            lo.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(dZE.time));
            lo.append("num", String.valueOf(dZE.num));
            lo.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", lo);
            dZE.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.l.isNetOk() && dVar != null) {
            String str6 = "";
            boolean isCdn = com.baidu.tbadk.util.m.isCdn(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().ebO) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean isWifiNet = com.baidu.adp.lib.util.j.isWifiNet();
            if (!z5) {
                z4 = false;
            } else if (isWifiNet) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().dLc);
            } else if (com.baidu.adp.lib.util.j.is2GNet()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().dLe);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().dLd);
            }
            boolean z6 = false;
            if (isCdn && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (isCdn && isWifiNet && z6) {
                if (z) {
                    r.getInstance().insertNormalData(j, str);
                } else {
                    str6 = v.baq().bar();
                    if (!TextUtils.isEmpty(str6)) {
                        r.getInstance().insertErrorData(dVar.KF, str);
                    }
                }
            }
            if (isCdn) {
                dZG = str;
            }
            boolean z7 = false;
            if (dVar.KH != null && dVar.KH.length() > 0) {
                z7 = true;
            }
            synchronized (Me) {
                t a2 = a(isWifiNet, isCdn, str2, z7);
                boolean z8 = dZD.dZI;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.downloadSize += j2;
                        dZD.dZI = true;
                        if (z4) {
                            a2.slownum++;
                        }
                        dZC = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            int i2 = dZC + 1;
                            dZC = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.mn().getMaxAlertCount(BdStatsConstant.AlertTypeKey.ALERT_IMG, 5)) {
                                BdStatisticsManager.getInstance().alert(BdStatsConstant.AlertTypeKey.ALERT_IMG, "imgFailedCnt_" + String.valueOf(dZC) + "_url=" + str2);
                            }
                        }
                        a2.failnum++;
                        dZD.dZI = false;
                    }
                }
                int ban = dZD.ban();
                if (ban > 100 || (ban > 0 && z8 != dZD.dZI)) {
                    bag();
                }
            }
            if (z && z5) {
                if (!isWifiNet || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().dLc) {
                    if (isWifiNet || !com.baidu.adp.lib.util.j.is2GNet() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().dLe) {
                        if (!isWifiNet && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().dLd) {
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
                aVar = lo();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = v.baq().bar();
            }
            if (!isCdn || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = v.baq().xK(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = bai();
            }
            aVar.append("url", str);
            aVar.append("act", IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS);
            aVar.append("result", z ? "1" : "0");
            aVar.append("requrl", str2);
            aVar.append("netlib", dVar.KP == 0 ? "Apache" : "HttpManager");
            aVar.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
            aVar.append("connTime", String.valueOf(dVar.connectTime));
            aVar.append("rspTime", String.valueOf(dVar.KD));
            aVar.append("retry", String.valueOf(dVar.retry));
            aVar.append("clientIp", d.getIp());
            aVar.append("tiebaIp", str6);
            String xJ = v.baq().xJ(str);
            if (!TextUtils.isEmpty(xJ)) {
                aVar.append("domainIp", xJ);
            }
            aVar.append("wifiDnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.append("connBaidu", String.valueOf(baj()));
            }
            aVar.append("memory", bak());
            aVar.append("task", bal());
            aVar.append("status", String.valueOf(dVar.KG));
            aVar.append("up", String.valueOf(dVar.KC));
            aVar.append("down", String.valueOf(dVar.downloadSize));
            aVar.append("isCDN", isCdn ? "1" : "0");
            aVar.append("isWebp", bool.booleanValue() ? "1" : "0");
            aVar.append("isMobileProxy", z3 ? "1" : "0");
            aVar.append("exception", dVar.exception);
            aVar.append(TiebaInitialize.LogFields.REASON, str3);
            if (i != 0) {
                aVar.append("procType", Integer.valueOf(i));
            }
            if (dVar.KN != null) {
                aVar.append("tracecode1", dVar.KN);
            }
            if (dVar.KO != null) {
                aVar.append("tracecode2", dVar.KO);
            }
            if (!as.isEmpty(dVar.KH)) {
                aVar.append("httpDnsIp", dVar.KH);
            } else {
                aVar.append("httpDnsIp", dVar.KI);
            }
            aVar.append("ipIndex", Integer.valueOf(dVar.KM));
            aVar.append("dnsSwitch1", Boolean.valueOf(com.baidu.adp.lib.network.http.c.Ks));
            aVar.append("dnsSwitch2", Boolean.valueOf(UseHttpdnsSdkSwitch.isOn()));
            aVar.append("httpDnsIpList", dVar.KL);
            aVar.append("dnsResolveType", dVar.KJ);
            aVar.append("dnsResolveStatus", dVar.KK);
            aVar.append("isUseIpDirectConnect", Boolean.valueOf(dVar.Kq));
            aVar.append("redirectUrl", dVar.redirectUrl);
            BdStatisticsManager.getInstance().debug("img", aVar);
            if (isCdn && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                dZD.dZH++;
            }
        }
    }

    public static void bag() {
        if (dZD.ban() > 10) {
            if (dZD.bam() > 0) {
                a(dZD.dZJ, dZD.dZK, dZD.dZL, dZD.dZN, dZD.dZM, 10000);
                com.baidu.tbadk.n.k.b(dZD.dZJ, dZD.dZK, dZD.dZL, dZD.dZN, dZD.dZM, 3);
            }
            if (dZD.bap() > 0) {
                a(dZD.dZT, dZD.dZU, dZD.dZV, dZD.dZX, dZD.dZW, 100002);
                com.baidu.tbadk.n.k.b(dZD.dZT, dZD.dZU, dZD.dZV, dZD.dZX, dZD.dZW, 2);
            }
            if (dZD.bao() > 0) {
                a(dZD.dZO, dZD.dZP, dZD.dZQ, dZD.dZS, dZD.dZR, 100001);
                com.baidu.tbadk.n.k.b(dZD.dZO, dZD.dZP, dZD.dZQ, dZD.dZS, dZD.dZR, 1);
            }
            dZD.reset();
        }
    }

    public static void a(t tVar, t tVar2, t tVar3, t tVar4, t tVar5, int i) {
        if (tVar != null && tVar2 != null && tVar3 != null && tVar4 != null && tVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = v.baq().bar();
            }
            if (dZG != null && TextUtils.isEmpty("")) {
                str2 = v.baq().xK(dZG);
            }
            if (TextUtils.isEmpty("")) {
                str3 = bai();
            }
            com.baidu.adp.lib.stats.a lo = lo();
            lo.append("act", "dlStat");
            lo.append("cdnCostTime", String.valueOf(tVar.time));
            lo.append("cdnNum", String.valueOf(tVar.num));
            lo.append("cdnFailnum", String.valueOf(tVar.failnum));
            lo.append("portraitCostTime", String.valueOf(tVar2.time));
            lo.append("portraitNum", String.valueOf(tVar2.num));
            lo.append("portraitFailnum", String.valueOf(tVar2.failnum));
            lo.append("tiebaCostTime", String.valueOf(tVar3.time));
            lo.append("tiebaNum", String.valueOf(tVar3.num));
            lo.append("tiebaFailnum", String.valueOf(tVar3.failnum));
            lo.append("otherCostTime", String.valueOf(tVar5.time));
            lo.append("otherNum", String.valueOf(tVar5.num));
            lo.append("otherFailnum", String.valueOf(tVar5.failnum));
            lo.append("directIpCostTime", String.valueOf(tVar4.time));
            lo.append("directIpNum", String.valueOf(tVar4.num));
            lo.append("directIpFailnum", String.valueOf(tVar4.failnum));
            lo.append("dnsFailNum", String.valueOf(dZD.dZH));
            if (10000 == i) {
                lo.append("isWifi", "1");
                lo.append("netType", "WIFI");
            } else if (100002 == i) {
                lo.append("netType", "3G");
                lo.append("isWifi", "0");
            } else {
                lo.append("netType", "2G");
                lo.append("isWifi", "0");
            }
            lo.append("localIp", d.getIp());
            lo.append("tbIp", str);
            lo.append("cdnIp", str2);
            lo.append("dnsIp", str3);
            BdStatisticsManager.getInstance().debug("img", lo);
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4, com.baidu.adp.lib.network.http.d dVar) {
        if (com.baidu.adp.lib.util.l.isNetOk()) {
            synchronized (Me) {
                dZF.num++;
                if (z) {
                    dZF.time += j;
                } else {
                    dZF.failnum++;
                }
                if (dZF.num >= 100) {
                    bah();
                }
            }
            if (!z) {
                if (aVar == null) {
                    aVar = lo();
                }
                aVar.append("act", "dc");
                aVar.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
                aVar.append("url", str);
                aVar.append("fullURL", str2);
                aVar.append("isWebp", z3 ? "1" : "0");
                aVar.append("isCDN", z2 ? "1" : "0");
                aVar.append("length", String.valueOf(i));
                aVar.append(TiebaInitialize.LogFields.REASON, str3);
                aVar.append("result", z ? "0" : "1");
                aVar.append("execption", str4);
                if (dVar != null) {
                    aVar.append("httpDnsIp", dVar.KI);
                    aVar.append("ipIndex", Integer.valueOf(dVar.KM));
                    aVar.append("httpDnsIpList", dVar.KL);
                    aVar.append("dnsResolveType", dVar.KJ);
                    aVar.append("dnsSwitch1", Boolean.valueOf(com.baidu.adp.lib.network.http.c.Ks));
                    aVar.append("dnsSwitch2", Boolean.valueOf(UseHttpdnsSdkSwitch.isOn()));
                    aVar.append("dnsResolveStatus", dVar.KK);
                    aVar.append("isUseIpDirectConnect", Boolean.valueOf(dVar.Kq));
                }
                BdStatisticsManager.getInstance().debug("img", aVar);
            }
        }
    }

    public static void u(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a lo = lo();
        lo.append("act", "ml");
        lo.append("fullURL", str2);
        lo.append("type", str);
        lo.append(TiebaInitialize.LogFields.REASON, str3);
        lo.append("extra", str4);
        BdStatisticsManager.getInstance().debug("img", lo);
    }

    public static void bah() {
        if (dZF.num > 10) {
            com.baidu.adp.lib.stats.a lo = lo();
            lo.append("act", "dcStat");
            lo.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(dZF.time));
            lo.append("num", String.valueOf(dZF.num));
            lo.append("failnum", String.valueOf(dZF.failnum));
            BdStatisticsManager.getInstance().debug("img", lo);
            com.baidu.tbadk.n.k.b(dZF.num, dZF.failnum, dZF.time);
            dZF.reset();
        }
    }

    public static void xI(String str) {
        com.baidu.adp.lib.stats.a lo = lo();
        lo.append("act", "assistant");
        lo.append("content", str);
        BdStatisticsManager.getInstance().debug("img", lo);
    }

    private static String bai() {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [638=5] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long baj() {
        HttpURLConnection httpURLConnection;
        long j;
        if (dZA >= 3) {
            return dZB;
        }
        long currentTimeMillis = System.currentTimeMillis();
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL("http://www.baidu.com/").openConnection();
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
            com.baidu.adp.lib.f.a.close(httpURLConnection);
            j = currentTimeMillis2;
        } catch (SocketTimeoutException e3) {
            com.baidu.adp.lib.f.a.close(httpURLConnection);
            j = 2500;
            if (j > 0) {
            }
        } catch (Exception e4) {
            httpURLConnection2 = httpURLConnection;
            com.baidu.adp.lib.f.a.close(httpURLConnection2);
            j = -1;
            if (j > 0) {
            }
        } catch (Throwable th2) {
            httpURLConnection2 = httpURLConnection;
            th = th2;
            com.baidu.adp.lib.f.a.close(httpURLConnection2);
            throw th;
        }
        if (j > 0) {
            if (dZA > -1) {
                dZB = ((dZB * dZA) + j) / (dZA + 1);
            } else {
                dZB = j;
            }
            dZA++;
            return j;
        }
        return j;
    }

    private static String bak() {
        return com.baidu.tbadk.imageManager.c.bkk().toLogString();
    }

    private static String bal() {
        return com.baidu.adp.lib.asyncTask.a.kn().toLogString();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.a lo = lo();
        lo.append("act", "getCDNList");
        lo.append("errorNum", str);
        lo.append(TiebaInitialize.LogFields.ERROR_MESSAGE, str2);
        lo.append("isShortNetError", z2 ? "1" : "0");
        lo.append("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug("img", lo);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = v.baq().xK(str);
        }
        String bai = bai();
        String ip = d.getIp();
        com.baidu.adp.lib.stats.a lo = lo();
        lo.append("act", "tachometerCDN");
        lo.append("errorNum", str3);
        lo.append("execption", str4);
        lo.append(TiebaInitialize.LogFields.SIZE, str5);
        lo.append("isScuess", z ? "1" : "0");
        lo.append("url", str);
        lo.append("localIp", ip);
        lo.append("cdnIp", str6);
        lo.append("dnsIP", bai);
        lo.append("usedIp", str2);
        lo.append("isUsedIp", z2 ? "0" : "1");
        lo.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
        BdStatisticsManager.getInstance().debug("img", lo);
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
                    com.baidu.adp.lib.stats.a lo = lo();
                    lo.append("act", "mobileTachometerCDN");
                    lo.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
                    lo.append("ipList", sb.toString());
                    BdStatisticsManager.getInstance().debug("img", lo);
                    return;
                }
            }
        }
    }

    public static void l(boolean z, String str) {
        com.baidu.adp.lib.stats.a lo = lo();
        lo.append("act", "getCDNList");
        lo.append("isSuccess", z ? "1" : "0");
        lo.append(TiebaInitialize.LogFields.ERROR_MESSAGE, str);
        BdStatisticsManager.getInstance().debug("img", lo);
    }

    public static void e(com.baidu.adp.lib.stats.a aVar) {
        aVar.append("act", "tiebaPic");
        BdStatisticsManager.getInstance().debug("img", aVar);
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
