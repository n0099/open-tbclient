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
    private static long dMr = 0;
    private static long dMs = 0;
    private static int dMt = 0;
    private static a dMu = new a();
    private static r dMv = new r();
    private static r dMw = new r();
    private static String dMx = null;
    private static Object syncLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        r dMA;
        r dMB;
        r dMC;
        r dMD;
        r dME;
        r dMF;
        r dMG;
        r dMH;
        r dMI;
        r dMJ;
        r dMK;
        r dML;
        r dMM;
        r dMN;
        r dMO;
        int dMy;
        boolean dMz;

        private a() {
            this.dMy = 0;
            this.dMA = new r();
            this.dMB = new r();
            this.dMC = new r();
            this.dMD = new r();
            this.dME = new r();
            this.dMF = new r();
            this.dMG = new r();
            this.dMH = new r();
            this.dMI = new r();
            this.dMJ = new r();
            this.dMK = new r();
            this.dML = new r();
            this.dMM = new r();
            this.dMN = new r();
            this.dMO = new r();
        }

        public int aUr() {
            return this.dMA.num + this.dMB.num + this.dMC.num + this.dMD.num + this.dME.num;
        }

        public int aUs() {
            return this.dMA.num + this.dMB.num + this.dMC.num + this.dMD.num + this.dME.num + this.dMF.num + this.dMG.num + this.dMH.num + this.dMI.num + this.dMJ.num + this.dMK.num + this.dML.num + this.dMM.num + this.dMN.num + this.dMO.num;
        }

        public int aUt() {
            return this.dMF.num + this.dMG.num + this.dMH.num + this.dMI.num + this.dMJ.num;
        }

        public int aUu() {
            return this.dMK.num + this.dML.num + this.dMM.num + this.dMN.num + this.dMO.num;
        }

        public void reset() {
            this.dMy = 0;
            this.dMA.reset();
            this.dMB.reset();
            this.dMC.reset();
            this.dMD.reset();
            this.dME.reset();
            this.dMF.reset();
            this.dMG.reset();
            this.dMH.reset();
            this.dMI.reset();
            this.dMJ.reset();
            this.dMK.reset();
            this.dML.reset();
            this.dMM.reset();
            this.dMN.reset();
            this.dMO.reset();
        }
    }

    private static r a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return dMu.dMA;
            }
            if (str.startsWith("http://tb.himg")) {
                return dMu.dMB;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return dMu.dMC;
            }
            if (z2 && z3) {
                return dMu.dME;
            }
            return dMu.dMD;
        } else if (com.baidu.adp.lib.util.j.is2GNet()) {
            if (z2) {
                return dMu.dMF;
            }
            if (str.startsWith("http://tb.himg")) {
                return dMu.dMG;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return dMu.dMH;
            }
            return dMu.dMI;
        } else if (z2) {
            return dMu.dMK;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return dMu.dML;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return dMu.dMM;
            }
            return dMu.dMN;
        }
    }

    public static com.baidu.adp.lib.stats.a kY() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (syncLock) {
                dMv.num++;
                dMv.time += j;
                if (dMv.num >= 100) {
                    aUk();
                }
            }
        }
    }

    public static void aUk() {
        if (dMv.num > 10) {
            com.baidu.adp.lib.stats.a kY = kY();
            kY.append("act", "locStat");
            kY.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(dMv.time));
            kY.append("num", String.valueOf(dMv.num));
            kY.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", kY);
            dMv.reset();
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
                if (!com.baidu.tbadk.core.util.a.e.getInstance().dOB) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean isWifiNet = com.baidu.adp.lib.util.j.isWifiNet();
            if (!z5) {
                z4 = false;
            } else if (isWifiNet) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().dyM);
            } else if (com.baidu.adp.lib.util.j.is2GNet()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().dyO);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().dyN);
            }
            boolean z6 = false;
            if (isCdn && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (isCdn && isWifiNet && z6) {
                if (z) {
                    p.getInstance().insertNormalData(j, str);
                } else {
                    str6 = t.aUv().aUw();
                    if (!TextUtils.isEmpty(str6)) {
                        p.getInstance().insertErrorData(dVar.Ke, str);
                    }
                }
            }
            if (isCdn) {
                dMx = str;
            }
            boolean z7 = false;
            if (dVar.Kg != null && dVar.Kg.length() > 0) {
                z7 = true;
            }
            synchronized (syncLock) {
                r a2 = a(isWifiNet, isCdn, str2, z7);
                boolean z8 = dMu.dMz;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.downloadSize += j2;
                        dMu.dMz = true;
                        if (z4) {
                            a2.slownum++;
                        }
                        dMt = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            int i2 = dMt + 1;
                            dMt = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.lX().getMaxAlertCount(BdStatsConstant.AlertTypeKey.ALERT_IMG, 5)) {
                                BdStatisticsManager.getInstance().alert(BdStatsConstant.AlertTypeKey.ALERT_IMG, "imgFailedCnt_" + String.valueOf(dMt) + "_url=" + str2);
                            }
                        }
                        a2.failnum++;
                        dMu.dMz = false;
                    }
                }
                int aUs = dMu.aUs();
                if (aUs > 100 || (aUs > 0 && z8 != dMu.dMz)) {
                    aUl();
                }
            }
            if (z && z5) {
                if (!isWifiNet || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().dyM) {
                    if (isWifiNet || !com.baidu.adp.lib.util.j.is2GNet() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().dyO) {
                        if (!isWifiNet && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().dyN) {
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
                aVar = kY();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = t.aUv().aUw();
            }
            if (!isCdn || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = t.aUv().wm(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = aUn();
            }
            aVar.append("url", str);
            aVar.append("act", IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS);
            aVar.append("result", z ? "1" : "0");
            aVar.append("requrl", str2);
            aVar.append("netlib", dVar.Ko == 0 ? "Apache" : "HttpManager");
            aVar.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
            aVar.append("connTime", String.valueOf(dVar.connectTime));
            aVar.append("rspTime", String.valueOf(dVar.Kc));
            aVar.append("retry", String.valueOf(dVar.retry));
            aVar.append("clientIp", d.getIp());
            aVar.append("tiebaIp", str6);
            String wl = t.aUv().wl(str);
            if (!TextUtils.isEmpty(wl)) {
                aVar.append("domainIp", wl);
            }
            aVar.append("wifiDnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.append("connBaidu", String.valueOf(aUo()));
            }
            aVar.append("memory", aUp());
            aVar.append("task", aUq());
            aVar.append("status", String.valueOf(dVar.Kf));
            aVar.append("up", String.valueOf(dVar.Kb));
            aVar.append("down", String.valueOf(dVar.downloadSize));
            aVar.append("isCDN", isCdn ? "1" : "0");
            aVar.append("isWebp", bool.booleanValue() ? "1" : "0");
            aVar.append("isMobileProxy", z3 ? "1" : "0");
            aVar.append("exception", dVar.exception);
            aVar.append(TiebaInitialize.LogFields.REASON, str3);
            if (i != 0) {
                aVar.append("procType", Integer.valueOf(i));
            }
            if (dVar.Km != null) {
                aVar.append("tracecode1", dVar.Km);
            }
            if (dVar.Kn != null) {
                aVar.append("tracecode2", dVar.Kn);
            }
            if (!aq.isEmpty(dVar.Kg)) {
                aVar.append("httpDnsIp", dVar.Kg);
            } else {
                aVar.append("httpDnsIp", dVar.Kh);
            }
            aVar.append("ipIndex", Integer.valueOf(dVar.Kl));
            aVar.append("dnsSwitch1", Boolean.valueOf(com.baidu.adp.lib.network.http.c.JS));
            aVar.append("dnsSwitch2", Boolean.valueOf(UseHttpdnsSdkSwitch.isOn()));
            aVar.append("httpDnsIpList", dVar.Kk);
            aVar.append("dnsResolveType", dVar.Ki);
            aVar.append("dnsResolveStatus", dVar.Kj);
            aVar.append("isUseIpDirectConnect", Boolean.valueOf(dVar.JQ));
            aVar.append("redirectUrl", dVar.redirectUrl);
            BdStatisticsManager.getInstance().debug("img", aVar);
            if (isCdn && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                dMu.dMy++;
            }
        }
    }

    public static void aUl() {
        if (dMu.aUs() > 10) {
            if (dMu.aUr() > 0) {
                a(dMu.dMA, dMu.dMB, dMu.dMC, dMu.dME, dMu.dMD, 10000);
                com.baidu.tbadk.n.k.b(dMu.dMA, dMu.dMB, dMu.dMC, dMu.dME, dMu.dMD, 3);
            }
            if (dMu.aUu() > 0) {
                a(dMu.dMK, dMu.dML, dMu.dMM, dMu.dMO, dMu.dMN, 100002);
                com.baidu.tbadk.n.k.b(dMu.dMK, dMu.dML, dMu.dMM, dMu.dMO, dMu.dMN, 2);
            }
            if (dMu.aUt() > 0) {
                a(dMu.dMF, dMu.dMG, dMu.dMH, dMu.dMJ, dMu.dMI, 100001);
                com.baidu.tbadk.n.k.b(dMu.dMF, dMu.dMG, dMu.dMH, dMu.dMJ, dMu.dMI, 1);
            }
            dMu.reset();
        }
    }

    public static void a(r rVar, r rVar2, r rVar3, r rVar4, r rVar5, int i) {
        if (rVar != null && rVar2 != null && rVar3 != null && rVar4 != null && rVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = t.aUv().aUw();
            }
            if (dMx != null && TextUtils.isEmpty("")) {
                str2 = t.aUv().wm(dMx);
            }
            if (TextUtils.isEmpty("")) {
                str3 = aUn();
            }
            com.baidu.adp.lib.stats.a kY = kY();
            kY.append("act", "dlStat");
            kY.append("cdnCostTime", String.valueOf(rVar.time));
            kY.append("cdnNum", String.valueOf(rVar.num));
            kY.append("cdnFailnum", String.valueOf(rVar.failnum));
            kY.append("portraitCostTime", String.valueOf(rVar2.time));
            kY.append("portraitNum", String.valueOf(rVar2.num));
            kY.append("portraitFailnum", String.valueOf(rVar2.failnum));
            kY.append("tiebaCostTime", String.valueOf(rVar3.time));
            kY.append("tiebaNum", String.valueOf(rVar3.num));
            kY.append("tiebaFailnum", String.valueOf(rVar3.failnum));
            kY.append("otherCostTime", String.valueOf(rVar5.time));
            kY.append("otherNum", String.valueOf(rVar5.num));
            kY.append("otherFailnum", String.valueOf(rVar5.failnum));
            kY.append("directIpCostTime", String.valueOf(rVar4.time));
            kY.append("directIpNum", String.valueOf(rVar4.num));
            kY.append("directIpFailnum", String.valueOf(rVar4.failnum));
            kY.append("dnsFailNum", String.valueOf(dMu.dMy));
            if (10000 == i) {
                kY.append("isWifi", "1");
                kY.append("netType", "WIFI");
            } else if (100002 == i) {
                kY.append("netType", "3G");
                kY.append("isWifi", "0");
            } else {
                kY.append("netType", "2G");
                kY.append("isWifi", "0");
            }
            kY.append("localIp", d.getIp());
            kY.append("tbIp", str);
            kY.append("cdnIp", str2);
            kY.append("dnsIp", str3);
            BdStatisticsManager.getInstance().debug("img", kY);
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4, com.baidu.adp.lib.network.http.d dVar) {
        if (com.baidu.adp.lib.util.l.isNetOk()) {
            synchronized (syncLock) {
                dMw.num++;
                if (z) {
                    dMw.time += j;
                } else {
                    dMw.failnum++;
                }
                if (dMw.num >= 100) {
                    aUm();
                }
            }
            if (!z) {
                if (aVar == null) {
                    aVar = kY();
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
                    aVar.append("httpDnsIp", dVar.Kh);
                    aVar.append("ipIndex", Integer.valueOf(dVar.Kl));
                    aVar.append("httpDnsIpList", dVar.Kk);
                    aVar.append("dnsResolveType", dVar.Ki);
                    aVar.append("dnsSwitch1", Boolean.valueOf(com.baidu.adp.lib.network.http.c.JS));
                    aVar.append("dnsSwitch2", Boolean.valueOf(UseHttpdnsSdkSwitch.isOn()));
                    aVar.append("dnsResolveStatus", dVar.Kj);
                    aVar.append("isUseIpDirectConnect", Boolean.valueOf(dVar.JQ));
                }
                BdStatisticsManager.getInstance().debug("img", aVar);
            }
        }
    }

    public static void u(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a kY = kY();
        kY.append("act", "ml");
        kY.append("fullURL", str2);
        kY.append("type", str);
        kY.append(TiebaInitialize.LogFields.REASON, str3);
        kY.append("extra", str4);
        BdStatisticsManager.getInstance().debug("img", kY);
    }

    public static void aUm() {
        if (dMw.num > 10) {
            com.baidu.adp.lib.stats.a kY = kY();
            kY.append("act", "dcStat");
            kY.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(dMw.time));
            kY.append("num", String.valueOf(dMw.num));
            kY.append("failnum", String.valueOf(dMw.failnum));
            BdStatisticsManager.getInstance().debug("img", kY);
            com.baidu.tbadk.n.k.b(dMw.num, dMw.failnum, dMw.time);
            dMw.reset();
        }
    }

    public static void wk(String str) {
        com.baidu.adp.lib.stats.a kY = kY();
        kY.append("act", "assistant");
        kY.append("content", str);
        BdStatisticsManager.getInstance().debug("img", kY);
    }

    private static String aUn() {
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
    private static long aUo() {
        HttpURLConnection httpURLConnection;
        long j;
        if (dMr >= 3) {
            return dMs;
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
            if (dMr > -1) {
                dMs = ((dMs * dMr) + j) / (dMr + 1);
            } else {
                dMs = j;
            }
            dMr++;
            return j;
        }
        return j;
    }

    private static String aUp() {
        return com.baidu.tbadk.imageManager.c.beu().toLogString();
    }

    private static String aUq() {
        return com.baidu.adp.lib.asyncTask.a.jX().toLogString();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.a kY = kY();
        kY.append("act", "getCDNList");
        kY.append("errorNum", str);
        kY.append(TiebaInitialize.LogFields.ERROR_MESSAGE, str2);
        kY.append("isShortNetError", z2 ? "1" : "0");
        kY.append("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug("img", kY);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = t.aUv().wm(str);
        }
        String aUn = aUn();
        String ip = d.getIp();
        com.baidu.adp.lib.stats.a kY = kY();
        kY.append("act", "tachometerCDN");
        kY.append("errorNum", str3);
        kY.append("execption", str4);
        kY.append(TiebaInitialize.LogFields.SIZE, str5);
        kY.append("isScuess", z ? "1" : "0");
        kY.append("url", str);
        kY.append("localIp", ip);
        kY.append("cdnIp", str6);
        kY.append("dnsIP", aUn);
        kY.append("usedIp", str2);
        kY.append("isUsedIp", z2 ? "0" : "1");
        kY.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
        BdStatisticsManager.getInstance().debug("img", kY);
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
                    com.baidu.adp.lib.stats.a kY = kY();
                    kY.append("act", "mobileTachometerCDN");
                    kY.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
                    kY.append("ipList", sb.toString());
                    BdStatisticsManager.getInstance().debug("img", kY);
                    return;
                }
            }
        }
    }

    public static void k(boolean z, String str) {
        com.baidu.adp.lib.stats.a kY = kY();
        kY.append("act", "getCDNList");
        kY.append("isSuccess", z ? "1" : "0");
        kY.append(TiebaInitialize.LogFields.ERROR_MESSAGE, str);
        BdStatisticsManager.getInstance().debug("img", kY);
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
