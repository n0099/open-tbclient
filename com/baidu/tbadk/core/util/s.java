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
public class s {
    private static long cYU = 0;
    private static long cYV = 0;
    private static int cYW = 0;
    private static a cYX = new a();
    private static r cYY = new r();
    private static r cYZ = new r();
    private static String cZa = null;
    private static Object syncLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int cZb;
        boolean cZc;
        r cZd;
        r cZe;
        r cZf;
        r cZg;
        r cZh;
        r cZi;
        r cZj;
        r cZk;
        r cZl;
        r cZm;
        r cZn;
        r cZo;
        r cZp;
        r cZq;
        r cZr;

        private a() {
            this.cZb = 0;
            this.cZd = new r();
            this.cZe = new r();
            this.cZf = new r();
            this.cZg = new r();
            this.cZh = new r();
            this.cZi = new r();
            this.cZj = new r();
            this.cZk = new r();
            this.cZl = new r();
            this.cZm = new r();
            this.cZn = new r();
            this.cZo = new r();
            this.cZp = new r();
            this.cZq = new r();
            this.cZr = new r();
        }

        public int aGb() {
            return this.cZd.num + this.cZe.num + this.cZf.num + this.cZg.num + this.cZh.num;
        }

        public int aGc() {
            return this.cZd.num + this.cZe.num + this.cZf.num + this.cZg.num + this.cZh.num + this.cZi.num + this.cZj.num + this.cZk.num + this.cZl.num + this.cZm.num + this.cZn.num + this.cZo.num + this.cZp.num + this.cZq.num + this.cZr.num;
        }

        public int aGd() {
            return this.cZi.num + this.cZj.num + this.cZk.num + this.cZl.num + this.cZm.num;
        }

        public int aGe() {
            return this.cZn.num + this.cZo.num + this.cZp.num + this.cZq.num + this.cZr.num;
        }

        public void reset() {
            this.cZb = 0;
            this.cZd.reset();
            this.cZe.reset();
            this.cZf.reset();
            this.cZg.reset();
            this.cZh.reset();
            this.cZi.reset();
            this.cZj.reset();
            this.cZk.reset();
            this.cZl.reset();
            this.cZm.reset();
            this.cZn.reset();
            this.cZo.reset();
            this.cZp.reset();
            this.cZq.reset();
            this.cZr.reset();
        }
    }

    private static r a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return cYX.cZd;
            }
            if (str.startsWith("http://tb.himg")) {
                return cYX.cZe;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return cYX.cZf;
            }
            if (z2 && z3) {
                return cYX.cZh;
            }
            return cYX.cZg;
        } else if (com.baidu.adp.lib.util.j.is2GNet()) {
            if (z2) {
                return cYX.cZi;
            }
            if (str.startsWith("http://tb.himg")) {
                return cYX.cZj;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return cYX.cZk;
            }
            return cYX.cZl;
        } else if (z2) {
            return cYX.cZn;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return cYX.cZo;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return cYX.cZp;
            }
            return cYX.cZq;
        }
    }

    public static com.baidu.adp.lib.stats.a gs() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (syncLock) {
                cYY.num++;
                cYY.time += j;
                if (cYY.num >= 100) {
                    aFU();
                }
            }
        }
    }

    public static void aFU() {
        if (cYY.num > 10) {
            com.baidu.adp.lib.stats.a gs = gs();
            gs.append("act", "locStat");
            gs.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(cYY.time));
            gs.append("num", String.valueOf(cYY.num));
            gs.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", gs);
            cYY.reset();
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
                if (!com.baidu.tbadk.core.util.a.e.getInstance().dbc) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean isWifiNet = com.baidu.adp.lib.util.j.isWifiNet();
            if (!z5) {
                z4 = false;
            } else if (isWifiNet) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().cLA);
            } else if (com.baidu.adp.lib.util.j.is2GNet()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().cLC);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().cLB);
            }
            boolean z6 = false;
            if (isCdn && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (isCdn && isWifiNet && z6) {
                if (z) {
                    p.getInstance().insertNormalData(j, str);
                } else {
                    str6 = t.aGf().aGg();
                    if (!TextUtils.isEmpty(str6)) {
                        p.getInstance().insertErrorData(dVar.qO, str);
                    }
                }
            }
            if (isCdn) {
                cZa = str;
            }
            boolean z7 = false;
            if (dVar.qQ != null && dVar.qQ.length() > 0) {
                z7 = true;
            }
            synchronized (syncLock) {
                r a2 = a(isWifiNet, isCdn, str2, z7);
                boolean z8 = cYX.cZc;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.downloadSize += j2;
                        cYX.cZc = true;
                        if (z4) {
                            a2.slownum++;
                        }
                        cYW = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            int i2 = cYW + 1;
                            cYW = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.hr().getMaxAlertCount(BdStatsConstant.AlertTypeKey.ALERT_IMG, 5)) {
                                BdStatisticsManager.getInstance().alert(BdStatsConstant.AlertTypeKey.ALERT_IMG, "imgFailedCnt_" + String.valueOf(cYW) + "_url=" + str2);
                            }
                        }
                        a2.failnum++;
                        cYX.cZc = false;
                    }
                }
                int aGc = cYX.aGc();
                if (aGc > 100 || (aGc > 0 && z8 != cYX.cZc)) {
                    aFV();
                }
            }
            if (z && z5) {
                if (!isWifiNet || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().cLA) {
                    if (isWifiNet || !com.baidu.adp.lib.util.j.is2GNet() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().cLC) {
                        if (!isWifiNet && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().cLB) {
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
                aVar = gs();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = t.aGf().aGg();
            }
            if (!isCdn || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = t.aGf().tp(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = aFX();
            }
            aVar.append("url", str);
            aVar.append("act", IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS);
            aVar.append("result", z ? "1" : "0");
            aVar.append("requrl", str2);
            aVar.append("netlib", dVar.qY == 0 ? "Apache" : "HttpManager");
            aVar.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
            aVar.append("connTime", String.valueOf(dVar.connectTime));
            aVar.append("rspTime", String.valueOf(dVar.qM));
            aVar.append("retry", String.valueOf(dVar.retry));
            aVar.append("clientIp", d.getIp());
            aVar.append("tiebaIp", str6);
            String str7 = t.aGf().to(str);
            if (!TextUtils.isEmpty(str7)) {
                aVar.append("domainIp", str7);
            }
            aVar.append("wifiDnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.append("connBaidu", String.valueOf(aFY()));
            }
            aVar.append("memory", aFZ());
            aVar.append("task", aGa());
            aVar.append("status", String.valueOf(dVar.qP));
            aVar.append("up", String.valueOf(dVar.qL));
            aVar.append("down", String.valueOf(dVar.downloadSize));
            aVar.append("isCDN", isCdn ? "1" : "0");
            aVar.append("isWebp", bool.booleanValue() ? "1" : "0");
            aVar.append("isMobileProxy", z3 ? "1" : "0");
            aVar.append(com.baidu.fsg.base.statistics.b.k, dVar.exception);
            aVar.append(TiebaInitialize.LogFields.REASON, str3);
            if (i != 0) {
                aVar.append("procType", Integer.valueOf(i));
            }
            if (dVar.qW != null) {
                aVar.append("tracecode1", dVar.qW);
            }
            if (dVar.qX != null) {
                aVar.append("tracecode2", dVar.qX);
            }
            if (!aq.isEmpty(dVar.qQ)) {
                aVar.append("httpDnsIp", dVar.qQ);
            } else {
                aVar.append("httpDnsIp", dVar.qR);
            }
            aVar.append("ipIndex", Integer.valueOf(dVar.qV));
            aVar.append("dnsSwitch1", Boolean.valueOf(com.baidu.adp.lib.network.http.c.qE));
            aVar.append("dnsSwitch2", Boolean.valueOf(UseHttpdnsSdkSwitch.isOn()));
            aVar.append("httpDnsIpList", dVar.qU);
            aVar.append("dnsResolveType", dVar.qS);
            aVar.append("dnsResolveStatus", dVar.qT);
            aVar.append("isUseIpDirectConnect", Boolean.valueOf(dVar.qC));
            BdStatisticsManager.getInstance().debug("img", aVar);
            if (isCdn && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                cYX.cZb++;
            }
        }
    }

    public static void aFV() {
        if (cYX.aGc() > 10) {
            if (cYX.aGb() > 0) {
                a(cYX.cZd, cYX.cZe, cYX.cZf, cYX.cZh, cYX.cZg, 10000);
                com.baidu.tbadk.n.k.b(cYX.cZd, cYX.cZe, cYX.cZf, cYX.cZh, cYX.cZg, 3);
            }
            if (cYX.aGe() > 0) {
                a(cYX.cZn, cYX.cZo, cYX.cZp, cYX.cZr, cYX.cZq, 100002);
                com.baidu.tbadk.n.k.b(cYX.cZn, cYX.cZo, cYX.cZp, cYX.cZr, cYX.cZq, 2);
            }
            if (cYX.aGd() > 0) {
                a(cYX.cZi, cYX.cZj, cYX.cZk, cYX.cZm, cYX.cZl, 100001);
                com.baidu.tbadk.n.k.b(cYX.cZi, cYX.cZj, cYX.cZk, cYX.cZm, cYX.cZl, 1);
            }
            cYX.reset();
        }
    }

    public static void a(r rVar, r rVar2, r rVar3, r rVar4, r rVar5, int i) {
        if (rVar != null && rVar2 != null && rVar3 != null && rVar4 != null && rVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = t.aGf().aGg();
            }
            if (cZa != null && TextUtils.isEmpty("")) {
                str2 = t.aGf().tp(cZa);
            }
            if (TextUtils.isEmpty("")) {
                str3 = aFX();
            }
            com.baidu.adp.lib.stats.a gs = gs();
            gs.append("act", "dlStat");
            gs.append("cdnCostTime", String.valueOf(rVar.time));
            gs.append("cdnNum", String.valueOf(rVar.num));
            gs.append("cdnFailnum", String.valueOf(rVar.failnum));
            gs.append("portraitCostTime", String.valueOf(rVar2.time));
            gs.append("portraitNum", String.valueOf(rVar2.num));
            gs.append("portraitFailnum", String.valueOf(rVar2.failnum));
            gs.append("tiebaCostTime", String.valueOf(rVar3.time));
            gs.append("tiebaNum", String.valueOf(rVar3.num));
            gs.append("tiebaFailnum", String.valueOf(rVar3.failnum));
            gs.append("otherCostTime", String.valueOf(rVar5.time));
            gs.append("otherNum", String.valueOf(rVar5.num));
            gs.append("otherFailnum", String.valueOf(rVar5.failnum));
            gs.append("directIpCostTime", String.valueOf(rVar4.time));
            gs.append("directIpNum", String.valueOf(rVar4.num));
            gs.append("directIpFailnum", String.valueOf(rVar4.failnum));
            gs.append("dnsFailNum", String.valueOf(cYX.cZb));
            if (10000 == i) {
                gs.append("isWifi", "1");
                gs.append("netType", "WIFI");
            } else if (100002 == i) {
                gs.append("netType", "3G");
                gs.append("isWifi", "0");
            } else {
                gs.append("netType", "2G");
                gs.append("isWifi", "0");
            }
            gs.append("localIp", d.getIp());
            gs.append("tbIp", str);
            gs.append("cdnIp", str2);
            gs.append("dnsIp", str3);
            BdStatisticsManager.getInstance().debug("img", gs);
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4, com.baidu.adp.lib.network.http.d dVar) {
        if (com.baidu.adp.lib.util.l.isNetOk()) {
            synchronized (syncLock) {
                cYZ.num++;
                if (z) {
                    cYZ.time += j;
                } else {
                    cYZ.failnum++;
                }
                if (cYZ.num >= 100) {
                    aFW();
                }
            }
            if (!z) {
                if (aVar == null) {
                    aVar = gs();
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
                    aVar.append("httpDnsIp", dVar.qR);
                    aVar.append("ipIndex", Integer.valueOf(dVar.qV));
                    aVar.append("httpDnsIpList", dVar.qU);
                    aVar.append("dnsResolveType", dVar.qS);
                    aVar.append("dnsSwitch1", Boolean.valueOf(com.baidu.adp.lib.network.http.c.qE));
                    aVar.append("dnsSwitch2", Boolean.valueOf(UseHttpdnsSdkSwitch.isOn()));
                    aVar.append("dnsResolveStatus", dVar.qT);
                    aVar.append("isUseIpDirectConnect", Boolean.valueOf(dVar.qC));
                }
                BdStatisticsManager.getInstance().debug("img", aVar);
            }
        }
    }

    public static void u(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a gs = gs();
        gs.append("act", "ml");
        gs.append("fullURL", str2);
        gs.append("type", str);
        gs.append(TiebaInitialize.LogFields.REASON, str3);
        gs.append("extra", str4);
        BdStatisticsManager.getInstance().debug("img", gs);
    }

    public static void aFW() {
        if (cYZ.num > 10) {
            com.baidu.adp.lib.stats.a gs = gs();
            gs.append("act", "dcStat");
            gs.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(cYZ.time));
            gs.append("num", String.valueOf(cYZ.num));
            gs.append("failnum", String.valueOf(cYZ.failnum));
            BdStatisticsManager.getInstance().debug("img", gs);
            com.baidu.tbadk.n.k.b(cYZ.num, cYZ.failnum, cYZ.time);
            cYZ.reset();
        }
    }

    public static void tn(String str) {
        com.baidu.adp.lib.stats.a gs = gs();
        gs.append("act", "assistant");
        gs.append("content", str);
        BdStatisticsManager.getInstance().debug("img", gs);
    }

    private static String aFX() {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [637=5] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long aFY() {
        HttpURLConnection httpURLConnection;
        long j;
        if (cYU >= 3) {
            return cYV;
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
            if (cYU > -1) {
                cYV = ((cYV * cYU) + j) / (cYU + 1);
            } else {
                cYV = j;
            }
            cYU++;
            return j;
        }
        return j;
    }

    private static String aFZ() {
        return com.baidu.tbadk.imageManager.c.aPV().toLogString();
    }

    private static String aGa() {
        return com.baidu.adp.lib.asyncTask.a.fq().toLogString();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.a gs = gs();
        gs.append("act", "getCDNList");
        gs.append("errorNum", str);
        gs.append(TiebaInitialize.LogFields.ERROR_MESSAGE, str2);
        gs.append("isShortNetError", z2 ? "1" : "0");
        gs.append("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug("img", gs);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = t.aGf().tp(str);
        }
        String aFX = aFX();
        String ip = d.getIp();
        com.baidu.adp.lib.stats.a gs = gs();
        gs.append("act", "tachometerCDN");
        gs.append("errorNum", str3);
        gs.append("execption", str4);
        gs.append(TiebaInitialize.LogFields.SIZE, str5);
        gs.append("isScuess", z ? "1" : "0");
        gs.append("url", str);
        gs.append("localIp", ip);
        gs.append("cdnIp", str6);
        gs.append("dnsIP", aFX);
        gs.append("usedIp", str2);
        gs.append("isUsedIp", z2 ? "0" : "1");
        gs.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
        BdStatisticsManager.getInstance().debug("img", gs);
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
                    com.baidu.adp.lib.stats.a gs = gs();
                    gs.append("act", "mobileTachometerCDN");
                    gs.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
                    gs.append("ipList", sb.toString());
                    BdStatisticsManager.getInstance().debug("img", gs);
                    return;
                }
            }
        }
    }

    public static void j(boolean z, String str) {
        com.baidu.adp.lib.stats.a gs = gs();
        gs.append("act", "getCDNList");
        gs.append("isSuccess", z ? "1" : "0");
        gs.append(TiebaInitialize.LogFields.ERROR_MESSAGE, str);
        BdStatisticsManager.getInstance().debug("img", gs);
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
