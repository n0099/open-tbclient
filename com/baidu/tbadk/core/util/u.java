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
/* loaded from: classes.dex */
public class u {
    private static long eGg = 0;
    private static long eGh = 0;
    private static int eGi = 0;
    private static a eGj = new a();
    private static t eGk = new t();
    private static t eGl = new t();
    private static String eGm = null;
    private static Object Nm = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        t eGA;
        t eGB;
        t eGC;
        t eGD;
        int eGn;
        boolean eGo;
        t eGp;
        t eGq;
        t eGr;
        t eGs;
        t eGt;
        t eGu;
        t eGv;
        t eGw;
        t eGx;
        t eGy;
        t eGz;

        private a() {
            this.eGn = 0;
            this.eGp = new t();
            this.eGq = new t();
            this.eGr = new t();
            this.eGs = new t();
            this.eGt = new t();
            this.eGu = new t();
            this.eGv = new t();
            this.eGw = new t();
            this.eGx = new t();
            this.eGy = new t();
            this.eGz = new t();
            this.eGA = new t();
            this.eGB = new t();
            this.eGC = new t();
            this.eGD = new t();
        }

        public int boe() {
            return this.eGp.num + this.eGq.num + this.eGr.num + this.eGs.num + this.eGt.num;
        }

        public int bof() {
            return this.eGp.num + this.eGq.num + this.eGr.num + this.eGs.num + this.eGt.num + this.eGu.num + this.eGv.num + this.eGw.num + this.eGx.num + this.eGy.num + this.eGz.num + this.eGA.num + this.eGB.num + this.eGC.num + this.eGD.num;
        }

        public int bog() {
            return this.eGu.num + this.eGv.num + this.eGw.num + this.eGx.num + this.eGy.num;
        }

        public int boh() {
            return this.eGz.num + this.eGA.num + this.eGB.num + this.eGC.num + this.eGD.num;
        }

        public void reset() {
            this.eGn = 0;
            this.eGp.reset();
            this.eGq.reset();
            this.eGr.reset();
            this.eGs.reset();
            this.eGt.reset();
            this.eGu.reset();
            this.eGv.reset();
            this.eGw.reset();
            this.eGx.reset();
            this.eGy.reset();
            this.eGz.reset();
            this.eGA.reset();
            this.eGB.reset();
            this.eGC.reset();
            this.eGD.reset();
        }
    }

    private static t a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return eGj.eGp;
            }
            if (str.startsWith("http://tb.himg")) {
                return eGj.eGq;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return eGj.eGr;
            }
            if (z2 && z3) {
                return eGj.eGt;
            }
            return eGj.eGs;
        } else if (com.baidu.adp.lib.util.j.is2GNet()) {
            if (z2) {
                return eGj.eGu;
            }
            if (str.startsWith("http://tb.himg")) {
                return eGj.eGv;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return eGj.eGw;
            }
            return eGj.eGx;
        } else if (z2) {
            return eGj.eGz;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return eGj.eGA;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return eGj.eGB;
            }
            return eGj.eGC;
        }
    }

    public static com.baidu.adp.lib.stats.a mT() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (Nm) {
                eGk.num++;
                eGk.time += j;
                if (eGk.num >= 100) {
                    bnX();
                }
            }
        }
    }

    public static void bnX() {
        if (eGk.num > 10) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("act", "locStat");
            mT.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(eGk.time));
            mT.append("num", String.valueOf(eGk.num));
            mT.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", mT);
            eGk.reset();
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
                if (!com.baidu.tbadk.core.util.a.e.getInstance().eIC) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean isWifiNet = com.baidu.adp.lib.util.j.isWifiNet();
            if (!z5) {
                z4 = false;
            } else if (isWifiNet) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().eqY);
            } else if (com.baidu.adp.lib.util.j.is2GNet()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().era);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().eqZ);
            }
            boolean z6 = false;
            if (isCdn && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (isCdn && isWifiNet && z6) {
                if (z) {
                    r.getInstance().insertNormalData(j, str);
                } else {
                    str6 = v.boi().boj();
                    if (!TextUtils.isEmpty(str6)) {
                        r.getInstance().insertErrorData(dVar.LM, str);
                    }
                }
            }
            if (isCdn) {
                eGm = str;
            }
            boolean z7 = false;
            if (dVar.LO != null && dVar.LO.length() > 0) {
                z7 = true;
            }
            synchronized (Nm) {
                t a2 = a(isWifiNet, isCdn, str2, z7);
                boolean z8 = eGj.eGo;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.downloadSize += j2;
                        eGj.eGo = true;
                        if (z4) {
                            a2.slownum++;
                        }
                        eGi = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            int i2 = eGi + 1;
                            eGi = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.nS().getMaxAlertCount(BdStatsConstant.AlertTypeKey.ALERT_IMG, 5)) {
                                BdStatisticsManager.getInstance().alert(BdStatsConstant.AlertTypeKey.ALERT_IMG, "imgFailedCnt_" + String.valueOf(eGi) + "_url=" + str2);
                            }
                        }
                        a2.failnum++;
                        eGj.eGo = false;
                    }
                }
                int bof = eGj.bof();
                if (bof > 100 || (bof > 0 && z8 != eGj.eGo)) {
                    bnY();
                }
            }
            if (z && z5) {
                if (!isWifiNet || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().eqY) {
                    if (isWifiNet || !com.baidu.adp.lib.util.j.is2GNet() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().era) {
                        if (!isWifiNet && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().eqZ) {
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
                str6 = v.boi().boj();
            }
            if (!isCdn || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = v.boi().BA(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = boa();
            }
            aVar.append("url", str);
            aVar.append("act", IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS);
            aVar.append("result", z ? "1" : "0");
            aVar.append("requrl", str2);
            aVar.append("netlib", dVar.LY == 0 ? "Apache" : "HttpManager");
            aVar.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
            aVar.append("connTime", String.valueOf(dVar.connectTime));
            aVar.append("rspTime", String.valueOf(dVar.LJ));
            aVar.append("retry", String.valueOf(dVar.retry));
            aVar.append("clientIp", d.getIp());
            aVar.append("tiebaIp", str6);
            String Bz = v.boi().Bz(str);
            if (!TextUtils.isEmpty(Bz)) {
                aVar.append("domainIp", Bz);
            }
            aVar.append("wifiDnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.append("connBaidu", String.valueOf(bob()));
            }
            aVar.append("memory", boc());
            aVar.append("task", bod());
            aVar.append("status", String.valueOf(dVar.LN));
            aVar.append(MapBundleKey.OfflineMapKey.OFFLINE_UPDATE, String.valueOf(dVar.LI));
            aVar.append("down", String.valueOf(dVar.downloadSize));
            aVar.append("isCDN", isCdn ? "1" : "0");
            aVar.append("isWebp", bool.booleanValue() ? "1" : "0");
            aVar.append("isMobileProxy", z3 ? "1" : "0");
            aVar.append("exception", dVar.exception);
            aVar.append(TiebaInitialize.LogFields.REASON, str3);
            if (i != 0) {
                aVar.append("procType", Integer.valueOf(i));
            }
            if (dVar.LW != null) {
                aVar.append("tracecode1", dVar.LW);
            }
            if (dVar.LX != null) {
                aVar.append("tracecode2", dVar.LX);
            }
            if (!at.isEmpty(dVar.LO)) {
                aVar.append("httpDnsIp", dVar.LO);
            } else {
                aVar.append("httpDnsIp", dVar.LQ);
            }
            aVar.append("ipIndex", Integer.valueOf(dVar.LV));
            aVar.append("dnsSwitch1", Boolean.valueOf(com.baidu.adp.lib.network.http.c.Lv));
            aVar.append("dnsSwitch2", Boolean.valueOf(UseHttpdnsSdkSwitch.isOn()));
            aVar.append("httpDnsIpList", dVar.LU);
            aVar.append("dnsResolveType", dVar.LR);
            aVar.append("dnsResolveStatus", dVar.LS);
            aVar.append("isUseIpDirectConnect", Boolean.valueOf(dVar.Lt));
            aVar.append("redirectUrl", dVar.redirectUrl);
            BdStatisticsManager.getInstance().debug("img", aVar);
            if (isCdn && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                eGj.eGn++;
            }
        }
    }

    public static void bnY() {
        if (eGj.bof() > 10) {
            if (eGj.boe() > 0) {
                a(eGj.eGp, eGj.eGq, eGj.eGr, eGj.eGt, eGj.eGs, 10000);
                com.baidu.tbadk.n.k.b(eGj.eGp, eGj.eGq, eGj.eGr, eGj.eGt, eGj.eGs, 3);
            }
            if (eGj.boh() > 0) {
                a(eGj.eGz, eGj.eGA, eGj.eGB, eGj.eGD, eGj.eGC, 100002);
                com.baidu.tbadk.n.k.b(eGj.eGz, eGj.eGA, eGj.eGB, eGj.eGD, eGj.eGC, 2);
            }
            if (eGj.bog() > 0) {
                a(eGj.eGu, eGj.eGv, eGj.eGw, eGj.eGy, eGj.eGx, 100001);
                com.baidu.tbadk.n.k.b(eGj.eGu, eGj.eGv, eGj.eGw, eGj.eGy, eGj.eGx, 1);
            }
            eGj.reset();
        }
    }

    public static void a(t tVar, t tVar2, t tVar3, t tVar4, t tVar5, int i) {
        if (tVar != null && tVar2 != null && tVar3 != null && tVar4 != null && tVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = v.boi().boj();
            }
            if (eGm != null && TextUtils.isEmpty("")) {
                str2 = v.boi().BA(eGm);
            }
            if (TextUtils.isEmpty("")) {
                str3 = boa();
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
            mT.append("dnsFailNum", String.valueOf(eGj.eGn));
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
            synchronized (Nm) {
                eGl.num++;
                if (z) {
                    eGl.time += j;
                } else {
                    eGl.failnum++;
                }
                if (eGl.num >= 100) {
                    bnZ();
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
                    aVar.append("httpDnsIp", dVar.LQ);
                    aVar.append("ipIndex", Integer.valueOf(dVar.LV));
                    aVar.append("httpDnsIpList", dVar.LU);
                    aVar.append("dnsResolveType", dVar.LR);
                    aVar.append("dnsSwitch1", Boolean.valueOf(com.baidu.adp.lib.network.http.c.Lv));
                    aVar.append("dnsSwitch2", Boolean.valueOf(UseHttpdnsSdkSwitch.isOn()));
                    aVar.append("dnsResolveStatus", dVar.LS);
                    aVar.append("isUseIpDirectConnect", Boolean.valueOf(dVar.Lt));
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

    public static void bnZ() {
        if (eGl.num > 10) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("act", "dcStat");
            mT.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(eGl.time));
            mT.append("num", String.valueOf(eGl.num));
            mT.append("failnum", String.valueOf(eGl.failnum));
            BdStatisticsManager.getInstance().debug("img", mT);
            com.baidu.tbadk.n.k.b(eGl.num, eGl.failnum, eGl.time);
            eGl.reset();
        }
    }

    public static void By(String str) {
        com.baidu.adp.lib.stats.a mT = mT();
        mT.append("act", "assistant");
        mT.append("content", str);
        BdStatisticsManager.getInstance().debug("img", mT);
    }

    private static String boa() {
        try {
            if (ae.bov()) {
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
    private static long bob() {
        HttpURLConnection httpURLConnection;
        long j;
        if (eGg >= 3) {
            return eGh;
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
            if (eGg > -1) {
                eGh = ((eGh * eGg) + j) / (eGg + 1);
            } else {
                eGh = j;
            }
            eGg++;
            return j;
        }
        return j;
    }

    private static String boc() {
        return com.baidu.tbadk.imageManager.c.byE().toLogString();
    }

    private static String bod() {
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
            str6 = v.boi().BA(str);
        }
        String boa = boa();
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
        mT.append("dnsIP", boa);
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
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
