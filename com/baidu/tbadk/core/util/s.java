package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.DefaultConfig;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.tbadk.TbConfig;
import com.xiaomi.mipush.sdk.Constants;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class s {
    private static long chI = 0;
    private static long chJ = 0;
    private static int chK = 0;
    private static a chL = new a();
    private static r chM = new r();
    private static r chN = new r();
    private static String chO = null;
    private static Object syncLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int chP;
        boolean chQ;
        r chR;
        r chS;
        r chT;
        r chU;
        r chV;
        r chW;
        r chX;
        r chY;
        r chZ;
        r cia;
        r cib;
        r cic;
        r cie;
        r cif;
        r cig;

        private a() {
            this.chP = 0;
            this.chR = new r();
            this.chS = new r();
            this.chT = new r();
            this.chU = new r();
            this.chV = new r();
            this.chW = new r();
            this.chX = new r();
            this.chY = new r();
            this.chZ = new r();
            this.cia = new r();
            this.cib = new r();
            this.cic = new r();
            this.cie = new r();
            this.cif = new r();
            this.cig = new r();
        }

        public int amg() {
            return this.chR.num + this.chS.num + this.chT.num + this.chU.num + this.chV.num;
        }

        public int amh() {
            return this.chR.num + this.chS.num + this.chT.num + this.chU.num + this.chV.num + this.chW.num + this.chX.num + this.chY.num + this.chZ.num + this.cia.num + this.cib.num + this.cic.num + this.cie.num + this.cif.num + this.cig.num;
        }

        public int ami() {
            return this.chW.num + this.chX.num + this.chY.num + this.chZ.num + this.cia.num;
        }

        public int amj() {
            return this.cib.num + this.cic.num + this.cie.num + this.cif.num + this.cig.num;
        }

        public void reset() {
            this.chP = 0;
            this.chR.reset();
            this.chS.reset();
            this.chT.reset();
            this.chU.reset();
            this.chV.reset();
            this.chW.reset();
            this.chX.reset();
            this.chY.reset();
            this.chZ.reset();
            this.cia.reset();
            this.cib.reset();
            this.cic.reset();
            this.cie.reset();
            this.cif.reset();
            this.cig.reset();
        }
    }

    private static r a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return chL.chR;
            }
            if (str.startsWith("http://tb.himg")) {
                return chL.chS;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return chL.chT;
            }
            if (z2 && z3) {
                return chL.chV;
            }
            return chL.chU;
        } else if (com.baidu.adp.lib.util.j.is2GNet()) {
            if (z2) {
                return chL.chW;
            }
            if (str.startsWith("http://tb.himg")) {
                return chL.chX;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return chL.chY;
            }
            return chL.chZ;
        } else if (z2) {
            return chL.cib;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return chL.cic;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return chL.cie;
            }
            return chL.cif;
        }
    }

    public static com.baidu.adp.lib.stats.a fU() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (syncLock) {
                chM.num++;
                chM.time += j;
                if (chM.num >= 100) {
                    alZ();
                }
            }
        }
    }

    public static void alZ() {
        if (chM.num > 10) {
            com.baidu.adp.lib.stats.a fU = fU();
            fU.append("act", "locStat");
            fU.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(chM.time));
            fU.append("num", String.valueOf(chM.num));
            fU.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", fU);
            chM.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.l.isNetOk() && dVar != null) {
            String str6 = "";
            boolean isCdn = com.baidu.tbadk.util.k.isCdn(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().cjP) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean isWifiNet = com.baidu.adp.lib.util.j.isWifiNet();
            if (!z5) {
                z4 = false;
            } else if (isWifiNet) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().bUG);
            } else if (com.baidu.adp.lib.util.j.is2GNet()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().bUI);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().bUH);
            }
            boolean z6 = false;
            if (isCdn && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (isCdn && isWifiNet && z6) {
                if (z) {
                    p.getInstance().insertNormalData(j, str);
                } else {
                    str6 = t.amk().aml();
                    if (!TextUtils.isEmpty(str6)) {
                        p.getInstance().insertErrorData(dVar.oz, str);
                    }
                }
            }
            if (isCdn) {
                chO = str;
            }
            boolean z7 = false;
            if (dVar.oB != null && dVar.oB.length() > 0) {
                z7 = true;
            }
            synchronized (syncLock) {
                r a2 = a(isWifiNet, isCdn, str2, z7);
                boolean z8 = chL.chQ;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.downloadSize += j2;
                        chL.chQ = true;
                        if (z4) {
                            a2.slownum++;
                        }
                        chK = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                            int i2 = chK + 1;
                            chK = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.gG().getMaxAlertCount(BdStatsConstant.AlertTypeKey.ALERT_IMG, 5)) {
                                BdStatisticsManager.getInstance().alert(BdStatsConstant.AlertTypeKey.ALERT_IMG, "imgFailedCnt_" + String.valueOf(chK) + "_url=" + str2);
                            }
                        }
                        a2.failnum++;
                        chL.chQ = false;
                    }
                }
                int amh = chL.amh();
                if (amh > 100 || (amh > 0 && z8 != chL.chQ)) {
                    ama();
                }
            }
            if (z && z5) {
                if (!isWifiNet || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().bUG) {
                    if (isWifiNet || !com.baidu.adp.lib.util.j.is2GNet() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().bUI) {
                        if (!isWifiNet && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().bUH) {
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
                aVar = fU();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = t.amk().aml();
            }
            if (!isCdn || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = t.amk().nM(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = amc();
            }
            aVar.append("url", str);
            aVar.append("act", IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS);
            aVar.append("result", z ? "1" : "0");
            aVar.append("fullurl", str2);
            aVar.append("netlib", String.valueOf(dVar.oG));
            aVar.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
            aVar.append("connTime", String.valueOf(dVar.connectTime));
            aVar.append("rspTime", String.valueOf(dVar.ov));
            aVar.append(BdStatsConstant.StatsKey.RETRY_COUNT, String.valueOf(dVar.ow));
            aVar.append("localIp", d.getIp());
            aVar.append("tiebaIp", str6);
            aVar.append("cdnIp", str4);
            aVar.append("useIp", dVar.oB);
            aVar.append("dnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.append("connBaidu", String.valueOf(amd()));
            }
            aVar.append("memory", ame());
            aVar.append("task", amf());
            aVar.append("status", String.valueOf(dVar.oA));
            aVar.append("up", String.valueOf(dVar.ou));
            aVar.append("down", String.valueOf(dVar.downloadSize));
            aVar.append("isCDN", isCdn ? "1" : "0");
            aVar.append("isWebp", bool.booleanValue() ? "1" : "0");
            aVar.append("isMobileProxy", z3 ? "1" : "0");
            aVar.append("exception", dVar.exception);
            aVar.append(TiebaInitialize.LogFields.REASON, str3);
            if (i != 0) {
                aVar.append("procType", Integer.valueOf(i));
            }
            if (dVar.oE != null) {
                aVar.append("tracecode1", dVar.oE);
            }
            if (dVar.oF != null) {
                aVar.append("tracecode2", dVar.oF);
            }
            aVar.append("newDnsIp", dVar.oC);
            aVar.append("dnsResolveType", dVar.oD);
            aVar.append("isUseIpDirectConnect", Boolean.valueOf(dVar.oj));
            BdStatisticsManager.getInstance().debug("img", aVar);
            if (isCdn && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                chL.chP++;
            }
        }
    }

    public static void ama() {
        if (chL.amh() > 10) {
            if (chL.amg() > 0) {
                a(chL.chR, chL.chS, chL.chT, chL.chV, chL.chU, 10000);
                com.baidu.tbadk.p.k.b(chL.chR, chL.chS, chL.chT, chL.chV, chL.chU, 3);
            }
            if (chL.amj() > 0) {
                a(chL.cib, chL.cic, chL.cie, chL.cig, chL.cif, 100002);
                com.baidu.tbadk.p.k.b(chL.cib, chL.cic, chL.cie, chL.cig, chL.cif, 2);
            }
            if (chL.ami() > 0) {
                a(chL.chW, chL.chX, chL.chY, chL.cia, chL.chZ, 100001);
                com.baidu.tbadk.p.k.b(chL.chW, chL.chX, chL.chY, chL.cia, chL.chZ, 1);
            }
            chL.reset();
        }
    }

    public static void a(r rVar, r rVar2, r rVar3, r rVar4, r rVar5, int i) {
        if (rVar != null && rVar2 != null && rVar3 != null && rVar4 != null && rVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = t.amk().aml();
            }
            if (chO != null && TextUtils.isEmpty("")) {
                str2 = t.amk().nM(chO);
            }
            if (TextUtils.isEmpty("")) {
                str3 = amc();
            }
            com.baidu.adp.lib.stats.a fU = fU();
            fU.append("act", "dlStat");
            fU.append("cdnCostTime", String.valueOf(rVar.time));
            fU.append("cdnNum", String.valueOf(rVar.num));
            fU.append("cdnFailnum", String.valueOf(rVar.failnum));
            fU.append("portraitCostTime", String.valueOf(rVar2.time));
            fU.append("portraitNum", String.valueOf(rVar2.num));
            fU.append("portraitFailnum", String.valueOf(rVar2.failnum));
            fU.append("tiebaCostTime", String.valueOf(rVar3.time));
            fU.append("tiebaNum", String.valueOf(rVar3.num));
            fU.append("tiebaFailnum", String.valueOf(rVar3.failnum));
            fU.append("otherCostTime", String.valueOf(rVar5.time));
            fU.append("otherNum", String.valueOf(rVar5.num));
            fU.append("otherFailnum", String.valueOf(rVar5.failnum));
            fU.append("directIpCostTime", String.valueOf(rVar4.time));
            fU.append("directIpNum", String.valueOf(rVar4.num));
            fU.append("directIpFailnum", String.valueOf(rVar4.failnum));
            fU.append("dnsFailNum", String.valueOf(chL.chP));
            if (10000 == i) {
                fU.append("isWifi", "1");
                fU.append("netType", "WIFI");
            } else if (100002 == i) {
                fU.append("netType", "3G");
                fU.append("isWifi", "0");
            } else {
                fU.append("netType", "2G");
                fU.append("isWifi", "0");
            }
            fU.append("localIp", d.getIp());
            fU.append("tbIp", str);
            fU.append("cdnIp", str2);
            fU.append("dnsIp", str3);
            BdStatisticsManager.getInstance().debug("img", fU);
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4, com.baidu.adp.lib.network.http.d dVar) {
        if (com.baidu.adp.lib.util.l.isNetOk()) {
            synchronized (syncLock) {
                chN.num++;
                if (z) {
                    chN.time += j;
                } else {
                    chN.failnum++;
                }
                if (chN.num >= 100) {
                    amb();
                }
            }
            if (!z) {
                if (aVar == null) {
                    aVar = fU();
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
                    aVar.append("newDnsIp", dVar.oC);
                    aVar.append("dnsResolveType", dVar.oD);
                    aVar.append("isUseIpDirectConnect", Boolean.valueOf(dVar.oj));
                }
                BdStatisticsManager.getInstance().debug("img", aVar);
            }
        }
    }

    public static void p(String str, String str2, String str3, String str4) {
        com.baidu.adp.lib.stats.a fU = fU();
        fU.append("act", "ml");
        fU.append("fullURL", str2);
        fU.append("type", str);
        fU.append(TiebaInitialize.LogFields.REASON, str3);
        fU.append("extra", str4);
        BdStatisticsManager.getInstance().debug("img", fU);
    }

    public static void amb() {
        if (chN.num > 10) {
            com.baidu.adp.lib.stats.a fU = fU();
            fU.append("act", "dcStat");
            fU.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(chN.time));
            fU.append("num", String.valueOf(chN.num));
            fU.append("failnum", String.valueOf(chN.failnum));
            BdStatisticsManager.getInstance().debug("img", fU);
            com.baidu.tbadk.p.k.b(chN.num, chN.failnum, chN.time);
            chN.reset();
        }
    }

    public static void nL(String str) {
        com.baidu.adp.lib.stats.a fU = fU();
        fU.append("act", "assistant");
        fU.append("content", str);
        BdStatisticsManager.getInstance().debug("img", fU);
    }

    private static String amc() {
        try {
            DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApp().getSystemService("wifi")).getDhcpInfo();
            return intToIp(dhcpInfo.dns1) + Constants.ACCEPT_TIME_SEPARATOR_SP + intToIp(dhcpInfo.dns2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String intToIp(int i) {
        return (i & 255) + DefaultConfig.TOKEN_SEPARATOR + ((i >> 8) & 255) + DefaultConfig.TOKEN_SEPARATOR + ((i >> 16) & 255) + DefaultConfig.TOKEN_SEPARATOR + ((i >> 24) & 255);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [617=5] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long amd() {
        HttpURLConnection httpURLConnection;
        long j;
        if (chI >= 3) {
            return chJ;
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
            com.baidu.adp.lib.g.a.close(httpURLConnection);
            j = currentTimeMillis2;
        } catch (SocketTimeoutException e3) {
            com.baidu.adp.lib.g.a.close(httpURLConnection);
            j = 2500;
            if (j > 0) {
            }
        } catch (Exception e4) {
            httpURLConnection2 = httpURLConnection;
            com.baidu.adp.lib.g.a.close(httpURLConnection2);
            j = -1;
            if (j > 0) {
            }
        } catch (Throwable th2) {
            httpURLConnection2 = httpURLConnection;
            th = th2;
            com.baidu.adp.lib.g.a.close(httpURLConnection2);
            throw th;
        }
        if (j > 0) {
            if (chI > -1) {
                chJ = ((chJ * chI) + j) / (chI + 1);
            } else {
                chJ = j;
            }
            chI++;
            return j;
        }
        return j;
    }

    private static String ame() {
        return com.baidu.tbadk.imageManager.c.avs().toLogString();
    }

    private static String amf() {
        return com.baidu.adp.lib.asyncTask.a.eW().toLogString();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.a fU = fU();
        fU.append("act", "getCDNList");
        fU.append("errorNum", str);
        fU.append(TiebaInitialize.LogFields.ERROR_MESSAGE, str2);
        fU.append("isShortNetError", z2 ? "1" : "0");
        fU.append("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug("img", fU);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = t.amk().nM(str);
        }
        String amc = amc();
        String ip = d.getIp();
        com.baidu.adp.lib.stats.a fU = fU();
        fU.append("act", "tachometerCDN");
        fU.append("errorNum", str3);
        fU.append("execption", str4);
        fU.append(TiebaInitialize.LogFields.SIZE, str5);
        fU.append("isScuess", z ? "1" : "0");
        fU.append("url", str);
        fU.append("localIp", ip);
        fU.append("cdnIp", str6);
        fU.append("dnsIP", amc);
        fU.append("usedIp", str2);
        fU.append("isUsedIp", z2 ? "0" : "1");
        fU.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
        BdStatisticsManager.getInstance().debug("img", fU);
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
                    com.baidu.adp.lib.stats.a fU = fU();
                    fU.append("act", "mobileTachometerCDN");
                    fU.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
                    fU.append("ipList", sb.toString());
                    BdStatisticsManager.getInstance().debug("img", fU);
                    return;
                }
            }
        }
    }

    public static void h(boolean z, String str) {
        com.baidu.adp.lib.stats.a fU = fU();
        fU.append("act", "getCDNList");
        fU.append("isSuccess", z ? "1" : "0");
        fU.append(TiebaInitialize.LogFields.ERROR_MESSAGE, str);
        BdStatisticsManager.getInstance().debug("img", fU);
    }

    public static void d(com.baidu.adp.lib.stats.a aVar) {
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
