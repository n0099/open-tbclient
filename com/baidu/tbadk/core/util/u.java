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
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class u {
    private static long eSg = 0;
    private static long eSh = 0;
    private static int eSi = 0;
    private static a eSj = new a();
    private static t eSk = new t();
    private static t eSl = new t();
    private static String eSm = null;
    private static Object Oh = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        t eSA;
        t eSB;
        t eSC;
        t eSD;
        int eSn;
        boolean eSo;
        t eSp;
        t eSq;
        t eSr;
        t eSs;
        t eSt;
        t eSu;
        t eSv;
        t eSw;
        t eSx;
        t eSy;
        t eSz;

        private a() {
            this.eSn = 0;
            this.eSp = new t();
            this.eSq = new t();
            this.eSr = new t();
            this.eSs = new t();
            this.eSt = new t();
            this.eSu = new t();
            this.eSv = new t();
            this.eSw = new t();
            this.eSx = new t();
            this.eSy = new t();
            this.eSz = new t();
            this.eSA = new t();
            this.eSB = new t();
            this.eSC = new t();
            this.eSD = new t();
        }

        public int btm() {
            return this.eSp.num + this.eSq.num + this.eSr.num + this.eSs.num + this.eSt.num;
        }

        public int btn() {
            return this.eSp.num + this.eSq.num + this.eSr.num + this.eSs.num + this.eSt.num + this.eSu.num + this.eSv.num + this.eSw.num + this.eSx.num + this.eSy.num + this.eSz.num + this.eSA.num + this.eSB.num + this.eSC.num + this.eSD.num;
        }

        public int bto() {
            return this.eSu.num + this.eSv.num + this.eSw.num + this.eSx.num + this.eSy.num;
        }

        public int btp() {
            return this.eSz.num + this.eSA.num + this.eSB.num + this.eSC.num + this.eSD.num;
        }

        public void reset() {
            this.eSn = 0;
            this.eSp.reset();
            this.eSq.reset();
            this.eSr.reset();
            this.eSs.reset();
            this.eSt.reset();
            this.eSu.reset();
            this.eSv.reset();
            this.eSw.reset();
            this.eSx.reset();
            this.eSy.reset();
            this.eSz.reset();
            this.eSA.reset();
            this.eSB.reset();
            this.eSC.reset();
            this.eSD.reset();
        }
    }

    private static t a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return eSj.eSp;
            }
            if (str.startsWith("http://tb.himg")) {
                return eSj.eSq;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return eSj.eSr;
            }
            if (z2 && z3) {
                return eSj.eSt;
            }
            return eSj.eSs;
        } else if (com.baidu.adp.lib.util.j.is2GNet()) {
            if (z2) {
                return eSj.eSu;
            }
            if (str.startsWith("http://tb.himg")) {
                return eSj.eSv;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return eSj.eSw;
            }
            return eSj.eSx;
        } else if (z2) {
            return eSj.eSz;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return eSj.eSA;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return eSj.eSB;
            }
            return eSj.eSC;
        }
    }

    public static com.baidu.adp.lib.stats.a mT() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (Oh) {
                eSk.num++;
                eSk.time += j;
                if (eSk.num >= 100) {
                    btf();
                }
            }
        }
    }

    public static void btf() {
        if (eSk.num > 10) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("act", "locStat");
            mT.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(eSk.time));
            mT.append("num", String.valueOf(eSk.num));
            mT.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", mT);
            eSk.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.l.isNetOk() && dVar != null) {
            String str6 = "";
            boolean isCdn = com.baidu.tbadk.util.n.isCdn(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().eUK) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean isWifiNet = com.baidu.adp.lib.util.j.isWifiNet();
            if (!z5) {
                z4 = false;
            } else if (isWifiNet) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().eCk);
            } else if (com.baidu.adp.lib.util.j.is2GNet()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().eCm);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().eCl);
            }
            boolean z6 = false;
            if (isCdn && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (isCdn && isWifiNet && z6) {
                if (z) {
                    r.getInstance().insertNormalData(j, str);
                } else {
                    str6 = v.btq().btr();
                    if (!TextUtils.isEmpty(str6)) {
                        r.getInstance().insertErrorData(dVar.MH, str);
                    }
                }
            }
            if (isCdn) {
                eSm = str;
            }
            boolean z7 = false;
            if (dVar.MJ != null && dVar.MJ.length() > 0) {
                z7 = true;
            }
            synchronized (Oh) {
                t a2 = a(isWifiNet, isCdn, str2, z7);
                boolean z8 = eSj.eSo;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.downloadSize += j2;
                        eSj.eSo = true;
                        if (z4) {
                            a2.slownum++;
                        }
                        eSi = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            int i2 = eSi + 1;
                            eSi = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.nR().getMaxAlertCount(BdStatsConstant.AlertTypeKey.ALERT_IMG, 5)) {
                                BdStatisticsManager.getInstance().alert(BdStatsConstant.AlertTypeKey.ALERT_IMG, "imgFailedCnt_" + String.valueOf(eSi) + "_url=" + str2);
                            }
                        }
                        a2.failnum++;
                        eSj.eSo = false;
                    }
                }
                int btn = eSj.btn();
                if (btn > 100 || (btn > 0 && z8 != eSj.eSo)) {
                    btg();
                }
            }
            if (z && z5) {
                if (!isWifiNet || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().eCk) {
                    if (isWifiNet || !com.baidu.adp.lib.util.j.is2GNet() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().eCm) {
                        if (!isWifiNet && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().eCl) {
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
                aVar = mT();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = v.btq().btr();
            }
            if (!isCdn || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = v.btq().BU(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = bti();
            }
            aVar.append("url", str);
            aVar.append("act", IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS);
            aVar.append("result", z ? "1" : "0");
            aVar.append("requrl", str2);
            aVar.append("netlib", dVar.MT == 0 ? "Apache" : "HttpManager");
            aVar.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
            aVar.append("connTime", String.valueOf(dVar.connectTime));
            aVar.append("rspTime", String.valueOf(dVar.MF));
            aVar.append("retry", String.valueOf(dVar.retry));
            aVar.append("clientIp", d.getIp());
            aVar.append("tiebaIp", str6);
            String BT = v.btq().BT(str);
            if (!TextUtils.isEmpty(BT)) {
                aVar.append("domainIp", BT);
            }
            aVar.append("wifiDnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.append("connBaidu", String.valueOf(btj()));
            }
            aVar.append("memory", btk());
            aVar.append("task", btl());
            aVar.append("status", String.valueOf(dVar.MI));
            aVar.append(MapBundleKey.OfflineMapKey.OFFLINE_UPDATE, String.valueOf(dVar.ME));
            aVar.append("down", String.valueOf(dVar.downloadSize));
            aVar.append("isCDN", isCdn ? "1" : "0");
            aVar.append("isWebp", bool.booleanValue() ? "1" : "0");
            aVar.append("isMobileProxy", z3 ? "1" : "0");
            aVar.append("exception", dVar.exception);
            aVar.append(TiebaInitialize.LogFields.REASON, str3);
            if (i != 0) {
                aVar.append("procType", Integer.valueOf(i));
            }
            if (dVar.MR != null) {
                aVar.append("tracecode1", dVar.MR);
            }
            if (dVar.MS != null) {
                aVar.append("tracecode2", dVar.MS);
            }
            if (!au.isEmpty(dVar.MJ)) {
                aVar.append("httpDnsIp", dVar.MJ);
            } else {
                aVar.append("httpDnsIp", dVar.MK);
            }
            aVar.append("ipIndex", Integer.valueOf(dVar.MQ));
            aVar.append("dnsSwitch1", Boolean.valueOf(com.baidu.adp.lib.network.http.c.Mt));
            aVar.append("dnsSwitch2", Boolean.valueOf(UseHttpdnsSdkSwitch.isOn()));
            aVar.append("httpDnsIpList", dVar.MP);
            aVar.append("dnsResolveType", dVar.MN);
            aVar.append("dnsResolveStatus", dVar.MO);
            aVar.append("isUseIpDirectConnect", Boolean.valueOf(dVar.Mr));
            aVar.append("redirectUrl", dVar.redirectUrl);
            BdStatisticsManager.getInstance().debug("img", aVar);
            if (isCdn && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                eSj.eSn++;
            }
        }
    }

    public static void btg() {
        if (eSj.btn() > 10) {
            if (eSj.btm() > 0) {
                a(eSj.eSp, eSj.eSq, eSj.eSr, eSj.eSt, eSj.eSs, 10000);
                com.baidu.tbadk.n.j.b(eSj.eSp, eSj.eSq, eSj.eSr, eSj.eSt, eSj.eSs, 3);
            }
            if (eSj.btp() > 0) {
                a(eSj.eSz, eSj.eSA, eSj.eSB, eSj.eSD, eSj.eSC, 100002);
                com.baidu.tbadk.n.j.b(eSj.eSz, eSj.eSA, eSj.eSB, eSj.eSD, eSj.eSC, 2);
            }
            if (eSj.bto() > 0) {
                a(eSj.eSu, eSj.eSv, eSj.eSw, eSj.eSy, eSj.eSx, 100001);
                com.baidu.tbadk.n.j.b(eSj.eSu, eSj.eSv, eSj.eSw, eSj.eSy, eSj.eSx, 1);
            }
            eSj.reset();
        }
    }

    public static void a(t tVar, t tVar2, t tVar3, t tVar4, t tVar5, int i) {
        if (tVar != null && tVar2 != null && tVar3 != null && tVar4 != null && tVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = v.btq().btr();
            }
            if (eSm != null && TextUtils.isEmpty("")) {
                str2 = v.btq().BU(eSm);
            }
            if (TextUtils.isEmpty("")) {
                str3 = bti();
            }
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("act", "dlStat");
            mT.append("cdnCostTime", String.valueOf(tVar.time));
            mT.append("cdnNum", String.valueOf(tVar.num));
            mT.append("cdnFailnum", String.valueOf(tVar.failnum));
            mT.append("portraitCostTime", String.valueOf(tVar2.time));
            mT.append("portraitNum", String.valueOf(tVar2.num));
            mT.append("portraitFailnum", String.valueOf(tVar2.failnum));
            mT.append("tiebaCostTime", String.valueOf(tVar3.time));
            mT.append("tiebaNum", String.valueOf(tVar3.num));
            mT.append("tiebaFailnum", String.valueOf(tVar3.failnum));
            mT.append("otherCostTime", String.valueOf(tVar5.time));
            mT.append("otherNum", String.valueOf(tVar5.num));
            mT.append("otherFailnum", String.valueOf(tVar5.failnum));
            mT.append("directIpCostTime", String.valueOf(tVar4.time));
            mT.append("directIpNum", String.valueOf(tVar4.num));
            mT.append("directIpFailnum", String.valueOf(tVar4.failnum));
            mT.append("dnsFailNum", String.valueOf(eSj.eSn));
            if (10000 == i) {
                mT.append("isWifi", "1");
                mT.append("netType", "WIFI");
            } else if (100002 == i) {
                mT.append("netType", "3G");
                mT.append("isWifi", "0");
            } else {
                mT.append("netType", "2G");
                mT.append("isWifi", "0");
            }
            mT.append("localIp", d.getIp());
            mT.append("tbIp", str);
            mT.append("cdnIp", str2);
            mT.append("dnsIp", str3);
            BdStatisticsManager.getInstance().debug("img", mT);
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4, com.baidu.adp.lib.network.http.d dVar) {
        if (com.baidu.adp.lib.util.l.isNetOk()) {
            synchronized (Oh) {
                eSl.num++;
                if (z) {
                    eSl.time += j;
                } else {
                    eSl.failnum++;
                }
                if (eSl.num >= 100) {
                    bth();
                }
            }
            if (!z) {
                if (aVar == null) {
                    aVar = mT();
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
                    aVar.append("httpDnsIp", dVar.MK);
                    aVar.append("ipIndex", Integer.valueOf(dVar.MQ));
                    aVar.append("httpDnsIpList", dVar.MP);
                    aVar.append("dnsResolveType", dVar.MN);
                    aVar.append("dnsSwitch1", Boolean.valueOf(com.baidu.adp.lib.network.http.c.Mt));
                    aVar.append("dnsSwitch2", Boolean.valueOf(UseHttpdnsSdkSwitch.isOn()));
                    aVar.append("dnsResolveStatus", dVar.MO);
                    aVar.append("isUseIpDirectConnect", Boolean.valueOf(dVar.Mr));
                }
                BdStatisticsManager.getInstance().debug("img", aVar);
            }
        }
    }

    public static void v(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a mT = mT();
        mT.append("act", "ml");
        mT.append("fullURL", str2);
        mT.append("type", str);
        mT.append(TiebaInitialize.LogFields.REASON, str3);
        mT.append("extra", str4);
        BdStatisticsManager.getInstance().debug("img", mT);
    }

    public static void bth() {
        if (eSl.num > 10) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("act", "dcStat");
            mT.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(eSl.time));
            mT.append("num", String.valueOf(eSl.num));
            mT.append("failnum", String.valueOf(eSl.failnum));
            BdStatisticsManager.getInstance().debug("img", mT);
            com.baidu.tbadk.n.j.b(eSl.num, eSl.failnum, eSl.time);
            eSl.reset();
        }
    }

    public static void BS(String str) {
        com.baidu.adp.lib.stats.a mT = mT();
        mT.append("act", "assistant");
        mT.append("content", str);
        BdStatisticsManager.getInstance().debug("img", mT);
    }

    private static String bti() {
        try {
            if (ae.btD()) {
                DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApplicationContext().getSystemService("wifi")).getDhcpInfo();
                return intToIp(dhcpInfo.dns1) + "," + intToIp(dhcpInfo.dns2);
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
    private static long btj() {
        HttpURLConnection httpURLConnection;
        long j;
        if (eSg >= 3) {
            return eSh;
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
            if (eSg > -1) {
                eSh = ((eSh * eSg) + j) / (eSg + 1);
            } else {
                eSh = j;
            }
            eSg++;
            return j;
        }
        return j;
    }

    private static String btk() {
        return com.baidu.tbadk.imageManager.c.bDV().toLogString();
    }

    private static String btl() {
        return com.baidu.adp.lib.asyncTask.a.lR().toLogString();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.a mT = mT();
        mT.append("act", "getCDNList");
        mT.append("errorNum", str);
        mT.append(TiebaInitialize.LogFields.ERROR_MESSAGE, str2);
        mT.append("isShortNetError", z2 ? "1" : "0");
        mT.append("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug("img", mT);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = v.btq().BU(str);
        }
        String bti = bti();
        String ip = d.getIp();
        com.baidu.adp.lib.stats.a mT = mT();
        mT.append("act", "tachometerCDN");
        mT.append("errorNum", str3);
        mT.append("execption", str4);
        mT.append("size", str5);
        mT.append("isScuess", z ? "1" : "0");
        mT.append("url", str);
        mT.append("localIp", ip);
        mT.append("cdnIp", str6);
        mT.append("dnsIP", bti);
        mT.append("usedIp", str2);
        mT.append("isUsedIp", z2 ? "0" : "1");
        mT.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
        BdStatisticsManager.getInstance().debug("img", mT);
    }

    public static void a(ArrayList<String> arrayList, long j) {
        if (arrayList != null) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    if (i2 != 0) {
                        sb.append(",");
                    }
                    sb.append(arrayList.get(i2));
                    i = i2 + 1;
                } else {
                    com.baidu.adp.lib.stats.a mT = mT();
                    mT.append("act", "mobileTachometerCDN");
                    mT.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
                    mT.append("ipList", sb.toString());
                    BdStatisticsManager.getInstance().debug("img", mT);
                    return;
                }
            }
        }
    }

    public static void o(boolean z, String str) {
        com.baidu.adp.lib.stats.a mT = mT();
        mT.append("act", "getCDNList");
        mT.append("isSuccess", z ? "1" : "0");
        mT.append(TiebaInitialize.LogFields.ERROR_MESSAGE, str);
        BdStatisticsManager.getInstance().debug("img", mT);
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
