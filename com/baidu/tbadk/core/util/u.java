package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.switchs.UseHttpdnsSdkSwitch;
import com.xiaomi.mipush.sdk.Constants;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class u {
    private static long ejg = 0;
    private static long ejh = 0;
    private static int eji = 0;
    private static a ejj = new a();
    private static t ejk = new t();
    private static t ejl = new t();
    private static String ejm = null;
    private static Object MI = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {
        t ejA;
        t ejB;
        t ejC;
        t ejD;
        int ejn;
        boolean ejo;
        t ejp;
        t ejq;
        t ejr;
        t ejs;
        t ejt;
        t eju;
        t ejv;
        t ejw;
        t ejx;
        t ejy;
        t ejz;

        private a() {
            this.ejn = 0;
            this.ejp = new t();
            this.ejq = new t();
            this.ejr = new t();
            this.ejs = new t();
            this.ejt = new t();
            this.eju = new t();
            this.ejv = new t();
            this.ejw = new t();
            this.ejx = new t();
            this.ejy = new t();
            this.ejz = new t();
            this.ejA = new t();
            this.ejB = new t();
            this.ejC = new t();
            this.ejD = new t();
        }

        public int biH() {
            return this.ejp.num + this.ejq.num + this.ejr.num + this.ejs.num + this.ejt.num;
        }

        public int biI() {
            return this.ejp.num + this.ejq.num + this.ejr.num + this.ejs.num + this.ejt.num + this.eju.num + this.ejv.num + this.ejw.num + this.ejx.num + this.ejy.num + this.ejz.num + this.ejA.num + this.ejB.num + this.ejC.num + this.ejD.num;
        }

        public int biJ() {
            return this.eju.num + this.ejv.num + this.ejw.num + this.ejx.num + this.ejy.num;
        }

        public int biK() {
            return this.ejz.num + this.ejA.num + this.ejB.num + this.ejC.num + this.ejD.num;
        }

        public void reset() {
            this.ejn = 0;
            this.ejp.reset();
            this.ejq.reset();
            this.ejr.reset();
            this.ejs.reset();
            this.ejt.reset();
            this.eju.reset();
            this.ejv.reset();
            this.ejw.reset();
            this.ejx.reset();
            this.ejy.reset();
            this.ejz.reset();
            this.ejA.reset();
            this.ejB.reset();
            this.ejC.reset();
            this.ejD.reset();
        }
    }

    private static t a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return ejj.ejp;
            }
            if (str.startsWith("http://tb.himg")) {
                return ejj.ejq;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return ejj.ejr;
            }
            if (z2 && z3) {
                return ejj.ejt;
            }
            return ejj.ejs;
        } else if (com.baidu.adp.lib.util.j.is2GNet()) {
            if (z2) {
                return ejj.eju;
            }
            if (str.startsWith("http://tb.himg")) {
                return ejj.ejv;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return ejj.ejw;
            }
            return ejj.ejx;
        } else if (z2) {
            return ejj.ejz;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return ejj.ejA;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return ejj.ejB;
            }
            return ejj.ejC;
        }
    }

    public static com.baidu.adp.lib.stats.a mN() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (MI) {
                ejk.num++;
                ejk.time += j;
                if (ejk.num >= 100) {
                    biA();
                }
            }
        }
    }

    public static void biA() {
        if (ejk.num > 10) {
            com.baidu.adp.lib.stats.a mN = mN();
            mN.append("act", "locStat");
            mN.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(ejk.time));
            mN.append("num", String.valueOf(ejk.num));
            mN.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", mN);
            ejk.reset();
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
                if (!com.baidu.tbadk.core.util.a.e.getInstance().elx) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean isWifiNet = com.baidu.adp.lib.util.j.isWifiNet();
            if (!z5) {
                z4 = false;
            } else if (isWifiNet) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().dUk);
            } else if (com.baidu.adp.lib.util.j.is2GNet()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().dUm);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().dUl);
            }
            boolean z6 = false;
            if (isCdn && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (isCdn && isWifiNet && z6) {
                if (z) {
                    r.getInstance().insertNormalData(j, str);
                } else {
                    str6 = v.biL().biM();
                    if (!TextUtils.isEmpty(str6)) {
                        r.getInstance().insertErrorData(dVar.Li, str);
                    }
                }
            }
            if (isCdn) {
                ejm = str;
            }
            boolean z7 = false;
            if (dVar.Lk != null && dVar.Lk.length() > 0) {
                z7 = true;
            }
            synchronized (MI) {
                t a2 = a(isWifiNet, isCdn, str2, z7);
                boolean z8 = ejj.ejo;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.downloadSize += j2;
                        ejj.ejo = true;
                        if (z4) {
                            a2.slownum++;
                        }
                        eji = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            int i2 = eji + 1;
                            eji = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.nM().getMaxAlertCount(BdStatsConstant.AlertTypeKey.ALERT_IMG, 5)) {
                                BdStatisticsManager.getInstance().alert(BdStatsConstant.AlertTypeKey.ALERT_IMG, "imgFailedCnt_" + String.valueOf(eji) + "_url=" + str2);
                            }
                        }
                        a2.failnum++;
                        ejj.ejo = false;
                    }
                }
                int biI = ejj.biI();
                if (biI > 100 || (biI > 0 && z8 != ejj.ejo)) {
                    biB();
                }
            }
            if (z && z5) {
                if (!isWifiNet || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().dUk) {
                    if (isWifiNet || !com.baidu.adp.lib.util.j.is2GNet() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().dUm) {
                        if (!isWifiNet && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().dUl) {
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
                aVar = mN();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = v.biL().biM();
            }
            if (!isCdn || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = v.biL().zY(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = biD();
            }
            aVar.append("url", str);
            aVar.append("act", IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS);
            aVar.append("result", z ? "1" : "0");
            aVar.append("requrl", str2);
            aVar.append("netlib", dVar.Ls == 0 ? "Apache" : "HttpManager");
            aVar.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
            aVar.append("connTime", String.valueOf(dVar.connectTime));
            aVar.append("rspTime", String.valueOf(dVar.Lg));
            aVar.append("retry", String.valueOf(dVar.retry));
            aVar.append("clientIp", d.getIp());
            aVar.append("tiebaIp", str6);
            String zX = v.biL().zX(str);
            if (!TextUtils.isEmpty(zX)) {
                aVar.append("domainIp", zX);
            }
            aVar.append("wifiDnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.append("connBaidu", String.valueOf(biE()));
            }
            aVar.append("memory", biF());
            aVar.append("task", biG());
            aVar.append("status", String.valueOf(dVar.Lj));
            aVar.append(MapBundleKey.OfflineMapKey.OFFLINE_UPDATE, String.valueOf(dVar.Lf));
            aVar.append("down", String.valueOf(dVar.downloadSize));
            aVar.append("isCDN", isCdn ? "1" : "0");
            aVar.append("isWebp", bool.booleanValue() ? "1" : "0");
            aVar.append("isMobileProxy", z3 ? "1" : "0");
            aVar.append("exception", dVar.exception);
            aVar.append(TiebaInitialize.LogFields.REASON, str3);
            if (i != 0) {
                aVar.append("procType", Integer.valueOf(i));
            }
            if (dVar.Lq != null) {
                aVar.append("tracecode1", dVar.Lq);
            }
            if (dVar.Lr != null) {
                aVar.append("tracecode2", dVar.Lr);
            }
            if (!at.isEmpty(dVar.Lk)) {
                aVar.append("httpDnsIp", dVar.Lk);
            } else {
                aVar.append("httpDnsIp", dVar.Ll);
            }
            aVar.append("ipIndex", Integer.valueOf(dVar.Lp));
            aVar.append("dnsSwitch1", Boolean.valueOf(com.baidu.adp.lib.network.http.c.KW));
            aVar.append("dnsSwitch2", Boolean.valueOf(UseHttpdnsSdkSwitch.isOn()));
            aVar.append("httpDnsIpList", dVar.Lo);
            aVar.append("dnsResolveType", dVar.Lm);
            aVar.append("dnsResolveStatus", dVar.Ln);
            aVar.append("isUseIpDirectConnect", Boolean.valueOf(dVar.KU));
            aVar.append("redirectUrl", dVar.redirectUrl);
            BdStatisticsManager.getInstance().debug("img", aVar);
            if (isCdn && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                ejj.ejn++;
            }
        }
    }

    public static void biB() {
        if (ejj.biI() > 10) {
            if (ejj.biH() > 0) {
                a(ejj.ejp, ejj.ejq, ejj.ejr, ejj.ejt, ejj.ejs, 10000);
                com.baidu.tbadk.n.k.b(ejj.ejp, ejj.ejq, ejj.ejr, ejj.ejt, ejj.ejs, 3);
            }
            if (ejj.biK() > 0) {
                a(ejj.ejz, ejj.ejA, ejj.ejB, ejj.ejD, ejj.ejC, 100002);
                com.baidu.tbadk.n.k.b(ejj.ejz, ejj.ejA, ejj.ejB, ejj.ejD, ejj.ejC, 2);
            }
            if (ejj.biJ() > 0) {
                a(ejj.eju, ejj.ejv, ejj.ejw, ejj.ejy, ejj.ejx, 100001);
                com.baidu.tbadk.n.k.b(ejj.eju, ejj.ejv, ejj.ejw, ejj.ejy, ejj.ejx, 1);
            }
            ejj.reset();
        }
    }

    public static void a(t tVar, t tVar2, t tVar3, t tVar4, t tVar5, int i) {
        if (tVar != null && tVar2 != null && tVar3 != null && tVar4 != null && tVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = v.biL().biM();
            }
            if (ejm != null && TextUtils.isEmpty("")) {
                str2 = v.biL().zY(ejm);
            }
            if (TextUtils.isEmpty("")) {
                str3 = biD();
            }
            com.baidu.adp.lib.stats.a mN = mN();
            mN.append("act", "dlStat");
            mN.append("cdnCostTime", String.valueOf(tVar.time));
            mN.append("cdnNum", String.valueOf(tVar.num));
            mN.append("cdnFailnum", String.valueOf(tVar.failnum));
            mN.append("portraitCostTime", String.valueOf(tVar2.time));
            mN.append("portraitNum", String.valueOf(tVar2.num));
            mN.append("portraitFailnum", String.valueOf(tVar2.failnum));
            mN.append("tiebaCostTime", String.valueOf(tVar3.time));
            mN.append("tiebaNum", String.valueOf(tVar3.num));
            mN.append("tiebaFailnum", String.valueOf(tVar3.failnum));
            mN.append("otherCostTime", String.valueOf(tVar5.time));
            mN.append("otherNum", String.valueOf(tVar5.num));
            mN.append("otherFailnum", String.valueOf(tVar5.failnum));
            mN.append("directIpCostTime", String.valueOf(tVar4.time));
            mN.append("directIpNum", String.valueOf(tVar4.num));
            mN.append("directIpFailnum", String.valueOf(tVar4.failnum));
            mN.append("dnsFailNum", String.valueOf(ejj.ejn));
            if (10000 == i) {
                mN.append("isWifi", "1");
                mN.append("netType", "WIFI");
            } else if (100002 == i) {
                mN.append("netType", "3G");
                mN.append("isWifi", "0");
            } else {
                mN.append("netType", "2G");
                mN.append("isWifi", "0");
            }
            mN.append("localIp", d.getIp());
            mN.append("tbIp", str);
            mN.append("cdnIp", str2);
            mN.append("dnsIp", str3);
            BdStatisticsManager.getInstance().debug("img", mN);
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4, com.baidu.adp.lib.network.http.d dVar) {
        if (com.baidu.adp.lib.util.l.isNetOk()) {
            synchronized (MI) {
                ejl.num++;
                if (z) {
                    ejl.time += j;
                } else {
                    ejl.failnum++;
                }
                if (ejl.num >= 100) {
                    biC();
                }
            }
            if (!z) {
                if (aVar == null) {
                    aVar = mN();
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
                    aVar.append("httpDnsIp", dVar.Ll);
                    aVar.append("ipIndex", Integer.valueOf(dVar.Lp));
                    aVar.append("httpDnsIpList", dVar.Lo);
                    aVar.append("dnsResolveType", dVar.Lm);
                    aVar.append("dnsSwitch1", Boolean.valueOf(com.baidu.adp.lib.network.http.c.KW));
                    aVar.append("dnsSwitch2", Boolean.valueOf(UseHttpdnsSdkSwitch.isOn()));
                    aVar.append("dnsResolveStatus", dVar.Ln);
                    aVar.append("isUseIpDirectConnect", Boolean.valueOf(dVar.KU));
                }
                BdStatisticsManager.getInstance().debug("img", aVar);
            }
        }
    }

    public static void u(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a mN = mN();
        mN.append("act", "ml");
        mN.append("fullURL", str2);
        mN.append("type", str);
        mN.append(TiebaInitialize.LogFields.REASON, str3);
        mN.append("extra", str4);
        BdStatisticsManager.getInstance().debug("img", mN);
    }

    public static void biC() {
        if (ejl.num > 10) {
            com.baidu.adp.lib.stats.a mN = mN();
            mN.append("act", "dcStat");
            mN.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(ejl.time));
            mN.append("num", String.valueOf(ejl.num));
            mN.append("failnum", String.valueOf(ejl.failnum));
            BdStatisticsManager.getInstance().debug("img", mN);
            com.baidu.tbadk.n.k.b(ejl.num, ejl.failnum, ejl.time);
            ejl.reset();
        }
    }

    public static void zW(String str) {
        com.baidu.adp.lib.stats.a mN = mN();
        mN.append("act", "assistant");
        mN.append("content", str);
        BdStatisticsManager.getInstance().debug("img", mN);
    }

    private static String biD() {
        try {
            if (ae.biY()) {
                DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApplicationContext().getSystemService("wifi")).getDhcpInfo();
                return intToIp(dhcpInfo.dns1) + Constants.ACCEPT_TIME_SEPARATOR_SP + intToIp(dhcpInfo.dns2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
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
    private static long biE() {
        HttpURLConnection httpURLConnection;
        long j;
        if (ejg >= 3) {
            return ejh;
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
            if (ejg > -1) {
                ejh = ((ejh * ejg) + j) / (ejg + 1);
            } else {
                ejh = j;
            }
            ejg++;
            return j;
        }
        return j;
    }

    private static String biF() {
        return com.baidu.tbadk.imageManager.c.bsW().toLogString();
    }

    private static String biG() {
        return com.baidu.adp.lib.asyncTask.a.lM().toLogString();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.a mN = mN();
        mN.append("act", "getCDNList");
        mN.append("errorNum", str);
        mN.append(TiebaInitialize.LogFields.ERROR_MESSAGE, str2);
        mN.append("isShortNetError", z2 ? "1" : "0");
        mN.append("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug("img", mN);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = v.biL().zY(str);
        }
        String biD = biD();
        String ip = d.getIp();
        com.baidu.adp.lib.stats.a mN = mN();
        mN.append("act", "tachometerCDN");
        mN.append("errorNum", str3);
        mN.append("execption", str4);
        mN.append("size", str5);
        mN.append("isScuess", z ? "1" : "0");
        mN.append("url", str);
        mN.append("localIp", ip);
        mN.append("cdnIp", str6);
        mN.append("dnsIP", biD);
        mN.append("usedIp", str2);
        mN.append("isUsedIp", z2 ? "0" : "1");
        mN.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
        BdStatisticsManager.getInstance().debug("img", mN);
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
                    com.baidu.adp.lib.stats.a mN = mN();
                    mN.append("act", "mobileTachometerCDN");
                    mN.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
                    mN.append("ipList", sb.toString());
                    BdStatisticsManager.getInstance().debug("img", mN);
                    return;
                }
            }
        }
    }

    public static void m(boolean z, String str) {
        com.baidu.adp.lib.stats.a mN = mN();
        mN.append("act", "getCDNList");
        mN.append("isSuccess", z ? "1" : "0");
        mN.append(TiebaInitialize.LogFields.ERROR_MESSAGE, str);
        BdStatisticsManager.getInstance().debug("img", mN);
    }

    public static void e(com.baidu.adp.lib.stats.a aVar) {
        aVar.append("act", "tiebaPic");
        BdStatisticsManager.getInstance().debug("img", aVar);
    }

    public static void b(String str, int i, int i2, int i3) {
        if (i == -1) {
            i = 0;
        }
        if (i2 == -1) {
            i2 = 0;
        }
        BdStatisticsManager.getInstance().eventStat(null, str, "imgHttpSwitch", 1, "1sterrcode", String.valueOf(i), "2nderrcode", String.valueOf(i2), "2imgFailed", String.valueOf(i3));
    }
}
