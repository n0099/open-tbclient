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
    private static long dyi = 0;
    private static long dyj = 0;
    private static int dyk = 0;
    private static a dyl = new a();
    private static r dym = new r();
    private static r dyn = new r();
    private static String dyo = null;
    private static Object syncLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        r dyA;
        r dyB;
        r dyC;
        r dyD;
        r dyE;
        r dyF;
        int dyp;
        boolean dyq;
        r dyr;
        r dys;
        r dyt;
        r dyu;
        r dyv;
        r dyw;
        r dyx;
        r dyy;
        r dyz;

        private a() {
            this.dyp = 0;
            this.dyr = new r();
            this.dys = new r();
            this.dyt = new r();
            this.dyu = new r();
            this.dyv = new r();
            this.dyw = new r();
            this.dyx = new r();
            this.dyy = new r();
            this.dyz = new r();
            this.dyA = new r();
            this.dyB = new r();
            this.dyC = new r();
            this.dyD = new r();
            this.dyE = new r();
            this.dyF = new r();
        }

        public int aOp() {
            return this.dyr.num + this.dys.num + this.dyt.num + this.dyu.num + this.dyv.num;
        }

        public int aOq() {
            return this.dyr.num + this.dys.num + this.dyt.num + this.dyu.num + this.dyv.num + this.dyw.num + this.dyx.num + this.dyy.num + this.dyz.num + this.dyA.num + this.dyB.num + this.dyC.num + this.dyD.num + this.dyE.num + this.dyF.num;
        }

        public int aOr() {
            return this.dyw.num + this.dyx.num + this.dyy.num + this.dyz.num + this.dyA.num;
        }

        public int aOs() {
            return this.dyB.num + this.dyC.num + this.dyD.num + this.dyE.num + this.dyF.num;
        }

        public void reset() {
            this.dyp = 0;
            this.dyr.reset();
            this.dys.reset();
            this.dyt.reset();
            this.dyu.reset();
            this.dyv.reset();
            this.dyw.reset();
            this.dyx.reset();
            this.dyy.reset();
            this.dyz.reset();
            this.dyA.reset();
            this.dyB.reset();
            this.dyC.reset();
            this.dyD.reset();
            this.dyE.reset();
            this.dyF.reset();
        }
    }

    private static r a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return dyl.dyr;
            }
            if (str.startsWith("http://tb.himg")) {
                return dyl.dys;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return dyl.dyt;
            }
            if (z2 && z3) {
                return dyl.dyv;
            }
            return dyl.dyu;
        } else if (com.baidu.adp.lib.util.j.is2GNet()) {
            if (z2) {
                return dyl.dyw;
            }
            if (str.startsWith("http://tb.himg")) {
                return dyl.dyx;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return dyl.dyy;
            }
            return dyl.dyz;
        } else if (z2) {
            return dyl.dyB;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return dyl.dyC;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return dyl.dyD;
            }
            return dyl.dyE;
        }
    }

    public static com.baidu.adp.lib.stats.a kW() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (syncLock) {
                dym.num++;
                dym.time += j;
                if (dym.num >= 100) {
                    aOi();
                }
            }
        }
    }

    public static void aOi() {
        if (dym.num > 10) {
            com.baidu.adp.lib.stats.a kW = kW();
            kW.append("act", "locStat");
            kW.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(dym.time));
            kW.append("num", String.valueOf(dym.num));
            kW.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", kW);
            dym.reset();
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
                if (!com.baidu.tbadk.core.util.a.e.getInstance().dAr) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean isWifiNet = com.baidu.adp.lib.util.j.isWifiNet();
            if (!z5) {
                z4 = false;
            } else if (isWifiNet) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().dkI);
            } else if (com.baidu.adp.lib.util.j.is2GNet()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().dkK);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().dkJ);
            }
            boolean z6 = false;
            if (isCdn && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (isCdn && isWifiNet && z6) {
                if (z) {
                    p.getInstance().insertNormalData(j, str);
                } else {
                    str6 = t.aOt().aOu();
                    if (!TextUtils.isEmpty(str6)) {
                        p.getInstance().insertErrorData(dVar.JP, str);
                    }
                }
            }
            if (isCdn) {
                dyo = str;
            }
            boolean z7 = false;
            if (dVar.JR != null && dVar.JR.length() > 0) {
                z7 = true;
            }
            synchronized (syncLock) {
                r a2 = a(isWifiNet, isCdn, str2, z7);
                boolean z8 = dyl.dyq;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.downloadSize += j2;
                        dyl.dyq = true;
                        if (z4) {
                            a2.slownum++;
                        }
                        dyk = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            int i2 = dyk + 1;
                            dyk = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.lV().getMaxAlertCount(BdStatsConstant.AlertTypeKey.ALERT_IMG, 5)) {
                                BdStatisticsManager.getInstance().alert(BdStatsConstant.AlertTypeKey.ALERT_IMG, "imgFailedCnt_" + String.valueOf(dyk) + "_url=" + str2);
                            }
                        }
                        a2.failnum++;
                        dyl.dyq = false;
                    }
                }
                int aOq = dyl.aOq();
                if (aOq > 100 || (aOq > 0 && z8 != dyl.dyq)) {
                    aOj();
                }
            }
            if (z && z5) {
                if (!isWifiNet || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().dkI) {
                    if (isWifiNet || !com.baidu.adp.lib.util.j.is2GNet() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().dkK) {
                        if (!isWifiNet && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().dkJ) {
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
                aVar = kW();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = t.aOt().aOu();
            }
            if (!isCdn || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = t.aOt().uD(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = aOl();
            }
            aVar.append("url", str);
            aVar.append("act", IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS);
            aVar.append("result", z ? "1" : "0");
            aVar.append("requrl", str2);
            aVar.append("netlib", dVar.JZ == 0 ? "Apache" : "HttpManager");
            aVar.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
            aVar.append("connTime", String.valueOf(dVar.connectTime));
            aVar.append("rspTime", String.valueOf(dVar.JN));
            aVar.append("retry", String.valueOf(dVar.retry));
            aVar.append("clientIp", d.getIp());
            aVar.append("tiebaIp", str6);
            String uC = t.aOt().uC(str);
            if (!TextUtils.isEmpty(uC)) {
                aVar.append("domainIp", uC);
            }
            aVar.append("wifiDnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.append("connBaidu", String.valueOf(aOm()));
            }
            aVar.append("memory", aOn());
            aVar.append("task", aOo());
            aVar.append("status", String.valueOf(dVar.JQ));
            aVar.append("up", String.valueOf(dVar.JM));
            aVar.append("down", String.valueOf(dVar.downloadSize));
            aVar.append("isCDN", isCdn ? "1" : "0");
            aVar.append("isWebp", bool.booleanValue() ? "1" : "0");
            aVar.append("isMobileProxy", z3 ? "1" : "0");
            aVar.append(com.baidu.fsg.base.statistics.b.k, dVar.exception);
            aVar.append(TiebaInitialize.LogFields.REASON, str3);
            if (i != 0) {
                aVar.append("procType", Integer.valueOf(i));
            }
            if (dVar.JX != null) {
                aVar.append("tracecode1", dVar.JX);
            }
            if (dVar.JY != null) {
                aVar.append("tracecode2", dVar.JY);
            }
            if (!aq.isEmpty(dVar.JR)) {
                aVar.append("httpDnsIp", dVar.JR);
            } else {
                aVar.append("httpDnsIp", dVar.JS);
            }
            aVar.append("ipIndex", Integer.valueOf(dVar.JW));
            aVar.append("dnsSwitch1", Boolean.valueOf(com.baidu.adp.lib.network.http.c.JF));
            aVar.append("dnsSwitch2", Boolean.valueOf(UseHttpdnsSdkSwitch.isOn()));
            aVar.append("httpDnsIpList", dVar.JV);
            aVar.append("dnsResolveType", dVar.JT);
            aVar.append("dnsResolveStatus", dVar.JU);
            aVar.append("isUseIpDirectConnect", Boolean.valueOf(dVar.JD));
            aVar.append("redirectUrl", dVar.redirectUrl);
            BdStatisticsManager.getInstance().debug("img", aVar);
            if (isCdn && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                dyl.dyp++;
            }
        }
    }

    public static void aOj() {
        if (dyl.aOq() > 10) {
            if (dyl.aOp() > 0) {
                a(dyl.dyr, dyl.dys, dyl.dyt, dyl.dyv, dyl.dyu, 10000);
                com.baidu.tbadk.n.k.b(dyl.dyr, dyl.dys, dyl.dyt, dyl.dyv, dyl.dyu, 3);
            }
            if (dyl.aOs() > 0) {
                a(dyl.dyB, dyl.dyC, dyl.dyD, dyl.dyF, dyl.dyE, 100002);
                com.baidu.tbadk.n.k.b(dyl.dyB, dyl.dyC, dyl.dyD, dyl.dyF, dyl.dyE, 2);
            }
            if (dyl.aOr() > 0) {
                a(dyl.dyw, dyl.dyx, dyl.dyy, dyl.dyA, dyl.dyz, 100001);
                com.baidu.tbadk.n.k.b(dyl.dyw, dyl.dyx, dyl.dyy, dyl.dyA, dyl.dyz, 1);
            }
            dyl.reset();
        }
    }

    public static void a(r rVar, r rVar2, r rVar3, r rVar4, r rVar5, int i) {
        if (rVar != null && rVar2 != null && rVar3 != null && rVar4 != null && rVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = t.aOt().aOu();
            }
            if (dyo != null && TextUtils.isEmpty("")) {
                str2 = t.aOt().uD(dyo);
            }
            if (TextUtils.isEmpty("")) {
                str3 = aOl();
            }
            com.baidu.adp.lib.stats.a kW = kW();
            kW.append("act", "dlStat");
            kW.append("cdnCostTime", String.valueOf(rVar.time));
            kW.append("cdnNum", String.valueOf(rVar.num));
            kW.append("cdnFailnum", String.valueOf(rVar.failnum));
            kW.append("portraitCostTime", String.valueOf(rVar2.time));
            kW.append("portraitNum", String.valueOf(rVar2.num));
            kW.append("portraitFailnum", String.valueOf(rVar2.failnum));
            kW.append("tiebaCostTime", String.valueOf(rVar3.time));
            kW.append("tiebaNum", String.valueOf(rVar3.num));
            kW.append("tiebaFailnum", String.valueOf(rVar3.failnum));
            kW.append("otherCostTime", String.valueOf(rVar5.time));
            kW.append("otherNum", String.valueOf(rVar5.num));
            kW.append("otherFailnum", String.valueOf(rVar5.failnum));
            kW.append("directIpCostTime", String.valueOf(rVar4.time));
            kW.append("directIpNum", String.valueOf(rVar4.num));
            kW.append("directIpFailnum", String.valueOf(rVar4.failnum));
            kW.append("dnsFailNum", String.valueOf(dyl.dyp));
            if (10000 == i) {
                kW.append("isWifi", "1");
                kW.append("netType", "WIFI");
            } else if (100002 == i) {
                kW.append("netType", "3G");
                kW.append("isWifi", "0");
            } else {
                kW.append("netType", "2G");
                kW.append("isWifi", "0");
            }
            kW.append("localIp", d.getIp());
            kW.append("tbIp", str);
            kW.append("cdnIp", str2);
            kW.append("dnsIp", str3);
            BdStatisticsManager.getInstance().debug("img", kW);
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4, com.baidu.adp.lib.network.http.d dVar) {
        if (com.baidu.adp.lib.util.l.isNetOk()) {
            synchronized (syncLock) {
                dyn.num++;
                if (z) {
                    dyn.time += j;
                } else {
                    dyn.failnum++;
                }
                if (dyn.num >= 100) {
                    aOk();
                }
            }
            if (!z) {
                if (aVar == null) {
                    aVar = kW();
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
                    aVar.append("httpDnsIp", dVar.JS);
                    aVar.append("ipIndex", Integer.valueOf(dVar.JW));
                    aVar.append("httpDnsIpList", dVar.JV);
                    aVar.append("dnsResolveType", dVar.JT);
                    aVar.append("dnsSwitch1", Boolean.valueOf(com.baidu.adp.lib.network.http.c.JF));
                    aVar.append("dnsSwitch2", Boolean.valueOf(UseHttpdnsSdkSwitch.isOn()));
                    aVar.append("dnsResolveStatus", dVar.JU);
                    aVar.append("isUseIpDirectConnect", Boolean.valueOf(dVar.JD));
                }
                BdStatisticsManager.getInstance().debug("img", aVar);
            }
        }
    }

    public static void u(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a kW = kW();
        kW.append("act", "ml");
        kW.append("fullURL", str2);
        kW.append("type", str);
        kW.append(TiebaInitialize.LogFields.REASON, str3);
        kW.append("extra", str4);
        BdStatisticsManager.getInstance().debug("img", kW);
    }

    public static void aOk() {
        if (dyn.num > 10) {
            com.baidu.adp.lib.stats.a kW = kW();
            kW.append("act", "dcStat");
            kW.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(dyn.time));
            kW.append("num", String.valueOf(dyn.num));
            kW.append("failnum", String.valueOf(dyn.failnum));
            BdStatisticsManager.getInstance().debug("img", kW);
            com.baidu.tbadk.n.k.b(dyn.num, dyn.failnum, dyn.time);
            dyn.reset();
        }
    }

    public static void uB(String str) {
        com.baidu.adp.lib.stats.a kW = kW();
        kW.append("act", "assistant");
        kW.append("content", str);
        BdStatisticsManager.getInstance().debug("img", kW);
    }

    private static String aOl() {
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
    private static long aOm() {
        HttpURLConnection httpURLConnection;
        long j;
        if (dyi >= 3) {
            return dyj;
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
            if (dyi > -1) {
                dyj = ((dyj * dyi) + j) / (dyi + 1);
            } else {
                dyj = j;
            }
            dyi++;
            return j;
        }
        return j;
    }

    private static String aOn() {
        return com.baidu.tbadk.imageManager.c.aYm().toLogString();
    }

    private static String aOo() {
        return com.baidu.adp.lib.asyncTask.a.jV().toLogString();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.a kW = kW();
        kW.append("act", "getCDNList");
        kW.append("errorNum", str);
        kW.append(TiebaInitialize.LogFields.ERROR_MESSAGE, str2);
        kW.append("isShortNetError", z2 ? "1" : "0");
        kW.append("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug("img", kW);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = t.aOt().uD(str);
        }
        String aOl = aOl();
        String ip = d.getIp();
        com.baidu.adp.lib.stats.a kW = kW();
        kW.append("act", "tachometerCDN");
        kW.append("errorNum", str3);
        kW.append("execption", str4);
        kW.append(TiebaInitialize.LogFields.SIZE, str5);
        kW.append("isScuess", z ? "1" : "0");
        kW.append("url", str);
        kW.append("localIp", ip);
        kW.append("cdnIp", str6);
        kW.append("dnsIP", aOl);
        kW.append("usedIp", str2);
        kW.append("isUsedIp", z2 ? "0" : "1");
        kW.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
        BdStatisticsManager.getInstance().debug("img", kW);
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
                    com.baidu.adp.lib.stats.a kW = kW();
                    kW.append("act", "mobileTachometerCDN");
                    kW.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
                    kW.append("ipList", sb.toString());
                    BdStatisticsManager.getInstance().debug("img", kW);
                    return;
                }
            }
        }
    }

    public static void k(boolean z, String str) {
        com.baidu.adp.lib.stats.a kW = kW();
        kW.append("act", "getCDNList");
        kW.append("isSuccess", z ? "1" : "0");
        kW.append(TiebaInitialize.LogFields.ERROR_MESSAGE, str);
        BdStatisticsManager.getInstance().debug("img", kW);
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
