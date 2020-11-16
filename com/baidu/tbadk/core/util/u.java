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
    private static long eKU = 0;
    private static long eKV = 0;
    private static int eKW = 0;
    private static a eKX = new a();
    private static t eKY = new t();
    private static t eKZ = new t();
    private static String eLa = null;
    private static Object Nm = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int eLb;
        boolean eLc;
        t eLd;
        t eLe;
        t eLf;
        t eLg;
        t eLh;
        t eLi;
        t eLj;
        t eLk;
        t eLl;
        t eLm;
        t eLn;
        t eLo;
        t eLp;
        t eLq;
        t eLr;

        private a() {
            this.eLb = 0;
            this.eLd = new t();
            this.eLe = new t();
            this.eLf = new t();
            this.eLg = new t();
            this.eLh = new t();
            this.eLi = new t();
            this.eLj = new t();
            this.eLk = new t();
            this.eLl = new t();
            this.eLm = new t();
            this.eLn = new t();
            this.eLo = new t();
            this.eLp = new t();
            this.eLq = new t();
            this.eLr = new t();
        }

        public int bpR() {
            return this.eLd.num + this.eLe.num + this.eLf.num + this.eLg.num + this.eLh.num;
        }

        public int bpS() {
            return this.eLd.num + this.eLe.num + this.eLf.num + this.eLg.num + this.eLh.num + this.eLi.num + this.eLj.num + this.eLk.num + this.eLl.num + this.eLm.num + this.eLn.num + this.eLo.num + this.eLp.num + this.eLq.num + this.eLr.num;
        }

        public int bpT() {
            return this.eLi.num + this.eLj.num + this.eLk.num + this.eLl.num + this.eLm.num;
        }

        public int bpU() {
            return this.eLn.num + this.eLo.num + this.eLp.num + this.eLq.num + this.eLr.num;
        }

        public void reset() {
            this.eLb = 0;
            this.eLd.reset();
            this.eLe.reset();
            this.eLf.reset();
            this.eLg.reset();
            this.eLh.reset();
            this.eLi.reset();
            this.eLj.reset();
            this.eLk.reset();
            this.eLl.reset();
            this.eLm.reset();
            this.eLn.reset();
            this.eLo.reset();
            this.eLp.reset();
            this.eLq.reset();
            this.eLr.reset();
        }
    }

    private static t a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return eKX.eLd;
            }
            if (str.startsWith("http://tb.himg")) {
                return eKX.eLe;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return eKX.eLf;
            }
            if (z2 && z3) {
                return eKX.eLh;
            }
            return eKX.eLg;
        } else if (com.baidu.adp.lib.util.j.is2GNet()) {
            if (z2) {
                return eKX.eLi;
            }
            if (str.startsWith("http://tb.himg")) {
                return eKX.eLj;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return eKX.eLk;
            }
            return eKX.eLl;
        } else if (z2) {
            return eKX.eLn;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return eKX.eLo;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return eKX.eLp;
            }
            return eKX.eLq;
        }
    }

    public static com.baidu.adp.lib.stats.a mT() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (Nm) {
                eKY.num++;
                eKY.time += j;
                if (eKY.num >= 100) {
                    bpK();
                }
            }
        }
    }

    public static void bpK() {
        if (eKY.num > 10) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("act", "locStat");
            mT.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(eKY.time));
            mT.append("num", String.valueOf(eKY.num));
            mT.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", mT);
            eKY.reset();
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
                if (!com.baidu.tbadk.core.util.a.e.getInstance().eNv) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean isWifiNet = com.baidu.adp.lib.util.j.isWifiNet();
            if (!z5) {
                z4 = false;
            } else if (isWifiNet) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().evi);
            } else if (com.baidu.adp.lib.util.j.is2GNet()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().evk);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().evj);
            }
            boolean z6 = false;
            if (isCdn && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (isCdn && isWifiNet && z6) {
                if (z) {
                    r.getInstance().insertNormalData(j, str);
                } else {
                    str6 = v.bpV().bpW();
                    if (!TextUtils.isEmpty(str6)) {
                        r.getInstance().insertErrorData(dVar.LM, str);
                    }
                }
            }
            if (isCdn) {
                eLa = str;
            }
            boolean z7 = false;
            if (dVar.LO != null && dVar.LO.length() > 0) {
                z7 = true;
            }
            synchronized (Nm) {
                t a2 = a(isWifiNet, isCdn, str2, z7);
                boolean z8 = eKX.eLc;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.downloadSize += j2;
                        eKX.eLc = true;
                        if (z4) {
                            a2.slownum++;
                        }
                        eKW = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            int i2 = eKW + 1;
                            eKW = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.nS().getMaxAlertCount(BdStatsConstant.AlertTypeKey.ALERT_IMG, 5)) {
                                BdStatisticsManager.getInstance().alert(BdStatsConstant.AlertTypeKey.ALERT_IMG, "imgFailedCnt_" + String.valueOf(eKW) + "_url=" + str2);
                            }
                        }
                        a2.failnum++;
                        eKX.eLc = false;
                    }
                }
                int bpS = eKX.bpS();
                if (bpS > 100 || (bpS > 0 && z8 != eKX.eLc)) {
                    bpL();
                }
            }
            if (z && z5) {
                if (!isWifiNet || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().evi) {
                    if (isWifiNet || !com.baidu.adp.lib.util.j.is2GNet() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().evk) {
                        if (!isWifiNet && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().evj) {
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
                str6 = v.bpV().bpW();
            }
            if (!isCdn || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = v.bpV().Bn(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = bpN();
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
            String Bm = v.bpV().Bm(str);
            if (!TextUtils.isEmpty(Bm)) {
                aVar.append("domainIp", Bm);
            }
            aVar.append("wifiDnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.append("connBaidu", String.valueOf(bpO()));
            }
            aVar.append("memory", bpP());
            aVar.append("task", bpQ());
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
            if (!au.isEmpty(dVar.LO)) {
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
                eKX.eLb++;
            }
        }
    }

    public static void bpL() {
        if (eKX.bpS() > 10) {
            if (eKX.bpR() > 0) {
                a(eKX.eLd, eKX.eLe, eKX.eLf, eKX.eLh, eKX.eLg, 10000);
                com.baidu.tbadk.n.k.b(eKX.eLd, eKX.eLe, eKX.eLf, eKX.eLh, eKX.eLg, 3);
            }
            if (eKX.bpU() > 0) {
                a(eKX.eLn, eKX.eLo, eKX.eLp, eKX.eLr, eKX.eLq, 100002);
                com.baidu.tbadk.n.k.b(eKX.eLn, eKX.eLo, eKX.eLp, eKX.eLr, eKX.eLq, 2);
            }
            if (eKX.bpT() > 0) {
                a(eKX.eLi, eKX.eLj, eKX.eLk, eKX.eLm, eKX.eLl, 100001);
                com.baidu.tbadk.n.k.b(eKX.eLi, eKX.eLj, eKX.eLk, eKX.eLm, eKX.eLl, 1);
            }
            eKX.reset();
        }
    }

    public static void a(t tVar, t tVar2, t tVar3, t tVar4, t tVar5, int i) {
        if (tVar != null && tVar2 != null && tVar3 != null && tVar4 != null && tVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = v.bpV().bpW();
            }
            if (eLa != null && TextUtils.isEmpty("")) {
                str2 = v.bpV().Bn(eLa);
            }
            if (TextUtils.isEmpty("")) {
                str3 = bpN();
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
            mT.append("dnsFailNum", String.valueOf(eKX.eLb));
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
                eKZ.num++;
                if (z) {
                    eKZ.time += j;
                } else {
                    eKZ.failnum++;
                }
                if (eKZ.num >= 100) {
                    bpM();
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

    public static void bpM() {
        if (eKZ.num > 10) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("act", "dcStat");
            mT.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(eKZ.time));
            mT.append("num", String.valueOf(eKZ.num));
            mT.append("failnum", String.valueOf(eKZ.failnum));
            BdStatisticsManager.getInstance().debug("img", mT);
            com.baidu.tbadk.n.k.b(eKZ.num, eKZ.failnum, eKZ.time);
            eKZ.reset();
        }
    }

    public static void Bl(String str) {
        com.baidu.adp.lib.stats.a mT = mT();
        mT.append("act", "assistant");
        mT.append("content", str);
        BdStatisticsManager.getInstance().debug("img", mT);
    }

    private static String bpN() {
        try {
            if (ae.bqi()) {
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
    private static long bpO() {
        HttpURLConnection httpURLConnection;
        long j;
        if (eKU >= 3) {
            return eKV;
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
            if (eKU > -1) {
                eKV = ((eKV * eKU) + j) / (eKU + 1);
            } else {
                eKV = j;
            }
            eKU++;
            return j;
        }
        return j;
    }

    private static String bpP() {
        return com.baidu.tbadk.imageManager.c.bAt().toLogString();
    }

    private static String bpQ() {
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
            str6 = v.bpV().Bn(str);
        }
        String bpN = bpN();
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
        mT.append("dnsIP", bpN);
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

    public static void p(boolean z, String str) {
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
