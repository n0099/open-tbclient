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
    private static long elz = 0;
    private static long elA = 0;
    private static int elB = 0;
    private static a elC = new a();
    private static t elD = new t();
    private static t elE = new t();
    private static String elF = null;
    private static Object MV = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int elG;
        boolean elH;
        t elI;
        t elJ;
        t elK;
        t elL;
        t elM;
        t elN;
        t elO;
        t elP;
        t elQ;
        t elR;
        t elS;
        t elT;
        t elU;
        t elV;
        t elW;

        private a() {
            this.elG = 0;
            this.elI = new t();
            this.elJ = new t();
            this.elK = new t();
            this.elL = new t();
            this.elM = new t();
            this.elN = new t();
            this.elO = new t();
            this.elP = new t();
            this.elQ = new t();
            this.elR = new t();
            this.elS = new t();
            this.elT = new t();
            this.elU = new t();
            this.elV = new t();
            this.elW = new t();
        }

        public int bjC() {
            return this.elI.num + this.elJ.num + this.elK.num + this.elL.num + this.elM.num;
        }

        public int bjD() {
            return this.elI.num + this.elJ.num + this.elK.num + this.elL.num + this.elM.num + this.elN.num + this.elO.num + this.elP.num + this.elQ.num + this.elR.num + this.elS.num + this.elT.num + this.elU.num + this.elV.num + this.elW.num;
        }

        public int bjE() {
            return this.elN.num + this.elO.num + this.elP.num + this.elQ.num + this.elR.num;
        }

        public int bjF() {
            return this.elS.num + this.elT.num + this.elU.num + this.elV.num + this.elW.num;
        }

        public void reset() {
            this.elG = 0;
            this.elI.reset();
            this.elJ.reset();
            this.elK.reset();
            this.elL.reset();
            this.elM.reset();
            this.elN.reset();
            this.elO.reset();
            this.elP.reset();
            this.elQ.reset();
            this.elR.reset();
            this.elS.reset();
            this.elT.reset();
            this.elU.reset();
            this.elV.reset();
            this.elW.reset();
        }
    }

    private static t a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return elC.elI;
            }
            if (str.startsWith("http://tb.himg")) {
                return elC.elJ;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return elC.elK;
            }
            if (z2 && z3) {
                return elC.elM;
            }
            return elC.elL;
        } else if (com.baidu.adp.lib.util.j.is2GNet()) {
            if (z2) {
                return elC.elN;
            }
            if (str.startsWith("http://tb.himg")) {
                return elC.elO;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return elC.elP;
            }
            return elC.elQ;
        } else if (z2) {
            return elC.elS;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return elC.elT;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return elC.elU;
            }
            return elC.elV;
        }
    }

    public static com.baidu.adp.lib.stats.a mS() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (MV) {
                elD.num++;
                elD.time += j;
                if (elD.num >= 100) {
                    bjv();
                }
            }
        }
    }

    public static void bjv() {
        if (elD.num > 10) {
            com.baidu.adp.lib.stats.a mS = mS();
            mS.append("act", "locStat");
            mS.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(elD.time));
            mS.append("num", String.valueOf(elD.num));
            mS.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", mS);
            elD.reset();
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
                if (!com.baidu.tbadk.core.util.a.e.getInstance().enT) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean isWifiNet = com.baidu.adp.lib.util.j.isWifiNet();
            if (!z5) {
                z4 = false;
            } else if (isWifiNet) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().dWy);
            } else if (com.baidu.adp.lib.util.j.is2GNet()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().dWA);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().dWz);
            }
            boolean z6 = false;
            if (isCdn && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (isCdn && isWifiNet && z6) {
                if (z) {
                    r.getInstance().insertNormalData(j, str);
                } else {
                    str6 = v.bjG().bjH();
                    if (!TextUtils.isEmpty(str6)) {
                        r.getInstance().insertErrorData(dVar.Ls, str);
                    }
                }
            }
            if (isCdn) {
                elF = str;
            }
            boolean z7 = false;
            if (dVar.Lu != null && dVar.Lu.length() > 0) {
                z7 = true;
            }
            synchronized (MV) {
                t a2 = a(isWifiNet, isCdn, str2, z7);
                boolean z8 = elC.elH;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.downloadSize += j2;
                        elC.elH = true;
                        if (z4) {
                            a2.slownum++;
                        }
                        elB = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            int i2 = elB + 1;
                            elB = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.nR().getMaxAlertCount(BdStatsConstant.AlertTypeKey.ALERT_IMG, 5)) {
                                BdStatisticsManager.getInstance().alert(BdStatsConstant.AlertTypeKey.ALERT_IMG, "imgFailedCnt_" + String.valueOf(elB) + "_url=" + str2);
                            }
                        }
                        a2.failnum++;
                        elC.elH = false;
                    }
                }
                int bjD = elC.bjD();
                if (bjD > 100 || (bjD > 0 && z8 != elC.elH)) {
                    bjw();
                }
            }
            if (z && z5) {
                if (!isWifiNet || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().dWy) {
                    if (isWifiNet || !com.baidu.adp.lib.util.j.is2GNet() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().dWA) {
                        if (!isWifiNet && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().dWz) {
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
                aVar = mS();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = v.bjG().bjH();
            }
            if (!isCdn || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = v.bjG().Av(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = bjy();
            }
            aVar.append("url", str);
            aVar.append("act", IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS);
            aVar.append("result", z ? "1" : "0");
            aVar.append("requrl", str2);
            aVar.append("netlib", dVar.LC == 0 ? "Apache" : "HttpManager");
            aVar.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
            aVar.append("connTime", String.valueOf(dVar.connectTime));
            aVar.append("rspTime", String.valueOf(dVar.Lq));
            aVar.append("retry", String.valueOf(dVar.retry));
            aVar.append("clientIp", d.getIp());
            aVar.append("tiebaIp", str6);
            String Au = v.bjG().Au(str);
            if (!TextUtils.isEmpty(Au)) {
                aVar.append("domainIp", Au);
            }
            aVar.append("wifiDnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.append("connBaidu", String.valueOf(bjz()));
            }
            aVar.append("memory", bjA());
            aVar.append("task", bjB());
            aVar.append("status", String.valueOf(dVar.Lt));
            aVar.append(MapBundleKey.OfflineMapKey.OFFLINE_UPDATE, String.valueOf(dVar.Lp));
            aVar.append("down", String.valueOf(dVar.downloadSize));
            aVar.append("isCDN", isCdn ? "1" : "0");
            aVar.append("isWebp", bool.booleanValue() ? "1" : "0");
            aVar.append("isMobileProxy", z3 ? "1" : "0");
            aVar.append("exception", dVar.exception);
            aVar.append(TiebaInitialize.LogFields.REASON, str3);
            if (i != 0) {
                aVar.append("procType", Integer.valueOf(i));
            }
            if (dVar.LA != null) {
                aVar.append("tracecode1", dVar.LA);
            }
            if (dVar.LB != null) {
                aVar.append("tracecode2", dVar.LB);
            }
            if (!at.isEmpty(dVar.Lu)) {
                aVar.append("httpDnsIp", dVar.Lu);
            } else {
                aVar.append("httpDnsIp", dVar.Lv);
            }
            aVar.append("ipIndex", Integer.valueOf(dVar.Lz));
            aVar.append("dnsSwitch1", Boolean.valueOf(com.baidu.adp.lib.network.http.c.Lf));
            aVar.append("dnsSwitch2", Boolean.valueOf(UseHttpdnsSdkSwitch.isOn()));
            aVar.append("httpDnsIpList", dVar.Ly);
            aVar.append("dnsResolveType", dVar.Lw);
            aVar.append("dnsResolveStatus", dVar.Lx);
            aVar.append("isUseIpDirectConnect", Boolean.valueOf(dVar.Ld));
            aVar.append("redirectUrl", dVar.redirectUrl);
            BdStatisticsManager.getInstance().debug("img", aVar);
            if (isCdn && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                elC.elG++;
            }
        }
    }

    public static void bjw() {
        if (elC.bjD() > 10) {
            if (elC.bjC() > 0) {
                a(elC.elI, elC.elJ, elC.elK, elC.elM, elC.elL, 10000);
                com.baidu.tbadk.n.k.b(elC.elI, elC.elJ, elC.elK, elC.elM, elC.elL, 3);
            }
            if (elC.bjF() > 0) {
                a(elC.elS, elC.elT, elC.elU, elC.elW, elC.elV, 100002);
                com.baidu.tbadk.n.k.b(elC.elS, elC.elT, elC.elU, elC.elW, elC.elV, 2);
            }
            if (elC.bjE() > 0) {
                a(elC.elN, elC.elO, elC.elP, elC.elR, elC.elQ, 100001);
                com.baidu.tbadk.n.k.b(elC.elN, elC.elO, elC.elP, elC.elR, elC.elQ, 1);
            }
            elC.reset();
        }
    }

    public static void a(t tVar, t tVar2, t tVar3, t tVar4, t tVar5, int i) {
        if (tVar != null && tVar2 != null && tVar3 != null && tVar4 != null && tVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = v.bjG().bjH();
            }
            if (elF != null && TextUtils.isEmpty("")) {
                str2 = v.bjG().Av(elF);
            }
            if (TextUtils.isEmpty("")) {
                str3 = bjy();
            }
            com.baidu.adp.lib.stats.a mS = mS();
            mS.append("act", "dlStat");
            mS.append("cdnCostTime", String.valueOf(tVar.time));
            mS.append("cdnNum", String.valueOf(tVar.num));
            mS.append("cdnFailnum", String.valueOf(tVar.failnum));
            mS.append("portraitCostTime", String.valueOf(tVar2.time));
            mS.append("portraitNum", String.valueOf(tVar2.num));
            mS.append("portraitFailnum", String.valueOf(tVar2.failnum));
            mS.append("tiebaCostTime", String.valueOf(tVar3.time));
            mS.append("tiebaNum", String.valueOf(tVar3.num));
            mS.append("tiebaFailnum", String.valueOf(tVar3.failnum));
            mS.append("otherCostTime", String.valueOf(tVar5.time));
            mS.append("otherNum", String.valueOf(tVar5.num));
            mS.append("otherFailnum", String.valueOf(tVar5.failnum));
            mS.append("directIpCostTime", String.valueOf(tVar4.time));
            mS.append("directIpNum", String.valueOf(tVar4.num));
            mS.append("directIpFailnum", String.valueOf(tVar4.failnum));
            mS.append("dnsFailNum", String.valueOf(elC.elG));
            if (10000 == i) {
                mS.append("isWifi", "1");
                mS.append("netType", "WIFI");
            } else if (100002 == i) {
                mS.append("netType", "3G");
                mS.append("isWifi", "0");
            } else {
                mS.append("netType", "2G");
                mS.append("isWifi", "0");
            }
            mS.append("localIp", d.getIp());
            mS.append("tbIp", str);
            mS.append("cdnIp", str2);
            mS.append("dnsIp", str3);
            BdStatisticsManager.getInstance().debug("img", mS);
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4, com.baidu.adp.lib.network.http.d dVar) {
        if (com.baidu.adp.lib.util.l.isNetOk()) {
            synchronized (MV) {
                elE.num++;
                if (z) {
                    elE.time += j;
                } else {
                    elE.failnum++;
                }
                if (elE.num >= 100) {
                    bjx();
                }
            }
            if (!z) {
                if (aVar == null) {
                    aVar = mS();
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
                    aVar.append("httpDnsIp", dVar.Lv);
                    aVar.append("ipIndex", Integer.valueOf(dVar.Lz));
                    aVar.append("httpDnsIpList", dVar.Ly);
                    aVar.append("dnsResolveType", dVar.Lw);
                    aVar.append("dnsSwitch1", Boolean.valueOf(com.baidu.adp.lib.network.http.c.Lf));
                    aVar.append("dnsSwitch2", Boolean.valueOf(UseHttpdnsSdkSwitch.isOn()));
                    aVar.append("dnsResolveStatus", dVar.Lx);
                    aVar.append("isUseIpDirectConnect", Boolean.valueOf(dVar.Ld));
                }
                BdStatisticsManager.getInstance().debug("img", aVar);
            }
        }
    }

    public static void u(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a mS = mS();
        mS.append("act", "ml");
        mS.append("fullURL", str2);
        mS.append("type", str);
        mS.append(TiebaInitialize.LogFields.REASON, str3);
        mS.append("extra", str4);
        BdStatisticsManager.getInstance().debug("img", mS);
    }

    public static void bjx() {
        if (elE.num > 10) {
            com.baidu.adp.lib.stats.a mS = mS();
            mS.append("act", "dcStat");
            mS.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(elE.time));
            mS.append("num", String.valueOf(elE.num));
            mS.append("failnum", String.valueOf(elE.failnum));
            BdStatisticsManager.getInstance().debug("img", mS);
            com.baidu.tbadk.n.k.b(elE.num, elE.failnum, elE.time);
            elE.reset();
        }
    }

    public static void At(String str) {
        com.baidu.adp.lib.stats.a mS = mS();
        mS.append("act", "assistant");
        mS.append("content", str);
        BdStatisticsManager.getInstance().debug("img", mS);
    }

    private static String bjy() {
        try {
            if (ae.bjT()) {
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
    private static long bjz() {
        HttpURLConnection httpURLConnection;
        long j;
        if (elz >= 3) {
            return elA;
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
            if (elz > -1) {
                elA = ((elA * elz) + j) / (elz + 1);
            } else {
                elA = j;
            }
            elz++;
            return j;
        }
        return j;
    }

    private static String bjA() {
        return com.baidu.tbadk.imageManager.c.bub().toLogString();
    }

    private static String bjB() {
        return com.baidu.adp.lib.asyncTask.a.lQ().toLogString();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.a mS = mS();
        mS.append("act", "getCDNList");
        mS.append("errorNum", str);
        mS.append(TiebaInitialize.LogFields.ERROR_MESSAGE, str2);
        mS.append("isShortNetError", z2 ? "1" : "0");
        mS.append("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug("img", mS);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = v.bjG().Av(str);
        }
        String bjy = bjy();
        String ip = d.getIp();
        com.baidu.adp.lib.stats.a mS = mS();
        mS.append("act", "tachometerCDN");
        mS.append("errorNum", str3);
        mS.append("execption", str4);
        mS.append("size", str5);
        mS.append("isScuess", z ? "1" : "0");
        mS.append("url", str);
        mS.append("localIp", ip);
        mS.append("cdnIp", str6);
        mS.append("dnsIP", bjy);
        mS.append("usedIp", str2);
        mS.append("isUsedIp", z2 ? "0" : "1");
        mS.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
        BdStatisticsManager.getInstance().debug("img", mS);
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
                    com.baidu.adp.lib.stats.a mS = mS();
                    mS.append("act", "mobileTachometerCDN");
                    mS.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
                    mS.append("ipList", sb.toString());
                    BdStatisticsManager.getInstance().debug("img", mS);
                    return;
                }
            }
        }
    }

    public static void m(boolean z, String str) {
        com.baidu.adp.lib.stats.a mS = mS();
        mS.append("act", "getCDNList");
        mS.append("isSuccess", z ? "1" : "0");
        mS.append(TiebaInitialize.LogFields.ERROR_MESSAGE, str);
        BdStatisticsManager.getInstance().debug("img", mS);
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
