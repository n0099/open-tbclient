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
public class t {
    private static long dTh = 0;
    private static long dTi = 0;
    private static int dTj = 0;
    private static a dTk = new a();
    private static s dTl = new s();
    private static s dTm = new s();
    private static String dTn = null;
    private static Object Mf = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        s dTA;
        s dTB;
        s dTC;
        s dTD;
        s dTE;
        int dTo;
        boolean dTp;
        s dTq;
        s dTr;
        s dTs;
        s dTt;
        s dTu;
        s dTv;
        s dTw;
        s dTx;
        s dTy;
        s dTz;

        private a() {
            this.dTo = 0;
            this.dTq = new s();
            this.dTr = new s();
            this.dTs = new s();
            this.dTt = new s();
            this.dTu = new s();
            this.dTv = new s();
            this.dTw = new s();
            this.dTx = new s();
            this.dTy = new s();
            this.dTz = new s();
            this.dTA = new s();
            this.dTB = new s();
            this.dTC = new s();
            this.dTD = new s();
            this.dTE = new s();
        }

        public int aWl() {
            return this.dTq.num + this.dTr.num + this.dTs.num + this.dTt.num + this.dTu.num;
        }

        public int aWm() {
            return this.dTq.num + this.dTr.num + this.dTs.num + this.dTt.num + this.dTu.num + this.dTv.num + this.dTw.num + this.dTx.num + this.dTy.num + this.dTz.num + this.dTA.num + this.dTB.num + this.dTC.num + this.dTD.num + this.dTE.num;
        }

        public int aWn() {
            return this.dTv.num + this.dTw.num + this.dTx.num + this.dTy.num + this.dTz.num;
        }

        public int aWo() {
            return this.dTA.num + this.dTB.num + this.dTC.num + this.dTD.num + this.dTE.num;
        }

        public void reset() {
            this.dTo = 0;
            this.dTq.reset();
            this.dTr.reset();
            this.dTs.reset();
            this.dTt.reset();
            this.dTu.reset();
            this.dTv.reset();
            this.dTw.reset();
            this.dTx.reset();
            this.dTy.reset();
            this.dTz.reset();
            this.dTA.reset();
            this.dTB.reset();
            this.dTC.reset();
            this.dTD.reset();
            this.dTE.reset();
        }
    }

    private static s a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return dTk.dTq;
            }
            if (str.startsWith("http://tb.himg")) {
                return dTk.dTr;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return dTk.dTs;
            }
            if (z2 && z3) {
                return dTk.dTu;
            }
            return dTk.dTt;
        } else if (com.baidu.adp.lib.util.j.is2GNet()) {
            if (z2) {
                return dTk.dTv;
            }
            if (str.startsWith("http://tb.himg")) {
                return dTk.dTw;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return dTk.dTx;
            }
            return dTk.dTy;
        } else if (z2) {
            return dTk.dTA;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return dTk.dTB;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return dTk.dTC;
            }
            return dTk.dTD;
        }
    }

    public static com.baidu.adp.lib.stats.a lo() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (Mf) {
                dTl.num++;
                dTl.time += j;
                if (dTl.num >= 100) {
                    aWe();
                }
            }
        }
    }

    public static void aWe() {
        if (dTl.num > 10) {
            com.baidu.adp.lib.stats.a lo = lo();
            lo.append("act", "locStat");
            lo.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(dTl.time));
            lo.append("num", String.valueOf(dTl.num));
            lo.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", lo);
            dTl.reset();
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
                if (!com.baidu.tbadk.core.util.a.e.getInstance().dVt) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean isWifiNet = com.baidu.adp.lib.util.j.isWifiNet();
            if (!z5) {
                z4 = false;
            } else if (isWifiNet) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().dFf);
            } else if (com.baidu.adp.lib.util.j.is2GNet()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().dFh);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().dFg);
            }
            boolean z6 = false;
            if (isCdn && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (isCdn && isWifiNet && z6) {
                if (z) {
                    q.getInstance().insertNormalData(j, str);
                } else {
                    str6 = u.aWp().aWq();
                    if (!TextUtils.isEmpty(str6)) {
                        q.getInstance().insertErrorData(dVar.KF, str);
                    }
                }
            }
            if (isCdn) {
                dTn = str;
            }
            boolean z7 = false;
            if (dVar.KH != null && dVar.KH.length() > 0) {
                z7 = true;
            }
            synchronized (Mf) {
                s a2 = a(isWifiNet, isCdn, str2, z7);
                boolean z8 = dTk.dTp;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.downloadSize += j2;
                        dTk.dTp = true;
                        if (z4) {
                            a2.slownum++;
                        }
                        dTj = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            int i2 = dTj + 1;
                            dTj = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.mn().getMaxAlertCount(BdStatsConstant.AlertTypeKey.ALERT_IMG, 5)) {
                                BdStatisticsManager.getInstance().alert(BdStatsConstant.AlertTypeKey.ALERT_IMG, "imgFailedCnt_" + String.valueOf(dTj) + "_url=" + str2);
                            }
                        }
                        a2.failnum++;
                        dTk.dTp = false;
                    }
                }
                int aWm = dTk.aWm();
                if (aWm > 100 || (aWm > 0 && z8 != dTk.dTp)) {
                    aWf();
                }
            }
            if (z && z5) {
                if (!isWifiNet || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().dFf) {
                    if (isWifiNet || !com.baidu.adp.lib.util.j.is2GNet() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().dFh) {
                        if (!isWifiNet && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().dFg) {
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
                str6 = u.aWp().aWq();
            }
            if (!isCdn || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = u.aWp().wC(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = aWh();
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
            String wB = u.aWp().wB(str);
            if (!TextUtils.isEmpty(wB)) {
                aVar.append("domainIp", wB);
            }
            aVar.append("wifiDnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.append("connBaidu", String.valueOf(aWi()));
            }
            aVar.append("memory", aWj());
            aVar.append("task", aWk());
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
            if (!ar.isEmpty(dVar.KH)) {
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
                dTk.dTo++;
            }
        }
    }

    public static void aWf() {
        if (dTk.aWm() > 10) {
            if (dTk.aWl() > 0) {
                a(dTk.dTq, dTk.dTr, dTk.dTs, dTk.dTu, dTk.dTt, 10000);
                com.baidu.tbadk.n.k.b(dTk.dTq, dTk.dTr, dTk.dTs, dTk.dTu, dTk.dTt, 3);
            }
            if (dTk.aWo() > 0) {
                a(dTk.dTA, dTk.dTB, dTk.dTC, dTk.dTE, dTk.dTD, 100002);
                com.baidu.tbadk.n.k.b(dTk.dTA, dTk.dTB, dTk.dTC, dTk.dTE, dTk.dTD, 2);
            }
            if (dTk.aWn() > 0) {
                a(dTk.dTv, dTk.dTw, dTk.dTx, dTk.dTz, dTk.dTy, 100001);
                com.baidu.tbadk.n.k.b(dTk.dTv, dTk.dTw, dTk.dTx, dTk.dTz, dTk.dTy, 1);
            }
            dTk.reset();
        }
    }

    public static void a(s sVar, s sVar2, s sVar3, s sVar4, s sVar5, int i) {
        if (sVar != null && sVar2 != null && sVar3 != null && sVar4 != null && sVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = u.aWp().aWq();
            }
            if (dTn != null && TextUtils.isEmpty("")) {
                str2 = u.aWp().wC(dTn);
            }
            if (TextUtils.isEmpty("")) {
                str3 = aWh();
            }
            com.baidu.adp.lib.stats.a lo = lo();
            lo.append("act", "dlStat");
            lo.append("cdnCostTime", String.valueOf(sVar.time));
            lo.append("cdnNum", String.valueOf(sVar.num));
            lo.append("cdnFailnum", String.valueOf(sVar.failnum));
            lo.append("portraitCostTime", String.valueOf(sVar2.time));
            lo.append("portraitNum", String.valueOf(sVar2.num));
            lo.append("portraitFailnum", String.valueOf(sVar2.failnum));
            lo.append("tiebaCostTime", String.valueOf(sVar3.time));
            lo.append("tiebaNum", String.valueOf(sVar3.num));
            lo.append("tiebaFailnum", String.valueOf(sVar3.failnum));
            lo.append("otherCostTime", String.valueOf(sVar5.time));
            lo.append("otherNum", String.valueOf(sVar5.num));
            lo.append("otherFailnum", String.valueOf(sVar5.failnum));
            lo.append("directIpCostTime", String.valueOf(sVar4.time));
            lo.append("directIpNum", String.valueOf(sVar4.num));
            lo.append("directIpFailnum", String.valueOf(sVar4.failnum));
            lo.append("dnsFailNum", String.valueOf(dTk.dTo));
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
            synchronized (Mf) {
                dTm.num++;
                if (z) {
                    dTm.time += j;
                } else {
                    dTm.failnum++;
                }
                if (dTm.num >= 100) {
                    aWg();
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

    public static void aWg() {
        if (dTm.num > 10) {
            com.baidu.adp.lib.stats.a lo = lo();
            lo.append("act", "dcStat");
            lo.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(dTm.time));
            lo.append("num", String.valueOf(dTm.num));
            lo.append("failnum", String.valueOf(dTm.failnum));
            BdStatisticsManager.getInstance().debug("img", lo);
            com.baidu.tbadk.n.k.b(dTm.num, dTm.failnum, dTm.time);
            dTm.reset();
        }
    }

    public static void wA(String str) {
        com.baidu.adp.lib.stats.a lo = lo();
        lo.append("act", "assistant");
        lo.append("content", str);
        BdStatisticsManager.getInstance().debug("img", lo);
    }

    private static String aWh() {
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
    private static long aWi() {
        HttpURLConnection httpURLConnection;
        long j;
        if (dTh >= 3) {
            return dTi;
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
            if (dTh > -1) {
                dTi = ((dTi * dTh) + j) / (dTh + 1);
            } else {
                dTi = j;
            }
            dTh++;
            return j;
        }
        return j;
    }

    private static String aWj() {
        return com.baidu.tbadk.imageManager.c.bgz().toLogString();
    }

    private static String aWk() {
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
            str6 = u.aWp().wC(str);
        }
        String aWh = aWh();
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
        lo.append("dnsIP", aWh);
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
