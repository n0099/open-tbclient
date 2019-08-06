package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.tencent.open.SocialConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class s {
    private static long bRA = 0;
    private static long bRB = 0;
    private static int bRC = 0;
    private static a bRD = new a();
    private static r bRE = new r();
    private static r bRF = new r();
    private static String bRG = null;
    private static Object syncLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int bRH;
        boolean bRI;
        r bRJ;
        r bRK;
        r bRL;
        r bRM;
        r bRN;
        r bRO;
        r bRP;
        r bRQ;
        r bRR;
        r bRS;
        r bRT;
        r bRU;
        r bRV;
        r bRW;
        r bRX;

        private a() {
            this.bRH = 0;
            this.bRJ = new r();
            this.bRK = new r();
            this.bRL = new r();
            this.bRM = new r();
            this.bRN = new r();
            this.bRO = new r();
            this.bRP = new r();
            this.bRQ = new r();
            this.bRR = new r();
            this.bRS = new r();
            this.bRT = new r();
            this.bRU = new r();
            this.bRV = new r();
            this.bRW = new r();
            this.bRX = new r();
        }

        public int ait() {
            return this.bRJ.num + this.bRK.num + this.bRL.num + this.bRM.num + this.bRN.num;
        }

        public int aiu() {
            return this.bRJ.num + this.bRK.num + this.bRL.num + this.bRM.num + this.bRN.num + this.bRO.num + this.bRP.num + this.bRQ.num + this.bRR.num + this.bRS.num + this.bRT.num + this.bRU.num + this.bRV.num + this.bRW.num + this.bRX.num;
        }

        public int aiv() {
            return this.bRO.num + this.bRP.num + this.bRQ.num + this.bRR.num + this.bRS.num;
        }

        public int aiw() {
            return this.bRT.num + this.bRU.num + this.bRV.num + this.bRW.num + this.bRX.num;
        }

        public void reset() {
            this.bRH = 0;
            this.bRJ.reset();
            this.bRK.reset();
            this.bRL.reset();
            this.bRM.reset();
            this.bRN.reset();
            this.bRO.reset();
            this.bRP.reset();
            this.bRQ.reset();
            this.bRR.reset();
            this.bRS.reset();
            this.bRT.reset();
            this.bRU.reset();
            this.bRV.reset();
            this.bRW.reset();
            this.bRX.reset();
        }
    }

    private static r a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return bRD.bRJ;
            }
            if (str.startsWith("http://tb.himg")) {
                return bRD.bRK;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return bRD.bRL;
            }
            if (z2 && z3) {
                return bRD.bRN;
            }
            return bRD.bRM;
        } else if (com.baidu.adp.lib.util.j.kh()) {
            if (z2) {
                return bRD.bRO;
            }
            if (str.startsWith("http://tb.himg")) {
                return bRD.bRP;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return bRD.bRQ;
            }
            return bRD.bRR;
        } else if (z2) {
            return bRD.bRT;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return bRD.bRU;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return bRD.bRV;
            }
            return bRD.bRW;
        }
    }

    public static com.baidu.adp.lib.stats.a iF() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (syncLock) {
                bRE.num++;
                bRE.time += j;
                if (bRE.num >= 100) {
                    aim();
                }
            }
        }
    }

    public static void aim() {
        if (bRE.num > 10) {
            com.baidu.adp.lib.stats.a iF = iF();
            iF.append(SocialConstants.PARAM_ACT, "locStat");
            iF.append("costTime", String.valueOf(bRE.time));
            iF.append("num", String.valueOf(bRE.num));
            iF.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iF);
            bRE.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.l.kt() && dVar != null) {
            String str6 = "";
            boolean rf = com.baidu.tbadk.util.l.rf(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().bUR) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean kd = com.baidu.adp.lib.util.j.kd();
            if (!z5) {
                z4 = false;
            } else if (kd) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().bCE);
            } else if (com.baidu.adp.lib.util.j.kh()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().bCG);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().bCF);
            }
            boolean z6 = false;
            if (rf && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (rf && kd && z6) {
                if (z) {
                    p.getInstance().insertNormalData(j, str);
                } else {
                    str6 = t.aix().aiy();
                    if (!TextUtils.isEmpty(str6)) {
                        p.getInstance().insertErrorData(dVar.AA, str);
                    }
                }
            }
            if (rf) {
                bRG = str;
            }
            boolean z7 = false;
            if (dVar.AC != null && dVar.AC.length() > 0) {
                z7 = true;
            }
            synchronized (syncLock) {
                r a2 = a(kd, rf, str2, z7);
                boolean z8 = bRD.bRI;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.Au += j2;
                        bRD.bRI = true;
                        if (z4) {
                            a2.bRz++;
                        }
                        bRC = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.kc()) {
                            int i2 = bRC + 1;
                            bRC = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.jt().getMaxAlertCount("alert_img", 5)) {
                                BdStatisticsManager.getInstance().alert("alert_img", "imgFailedCnt_" + String.valueOf(bRC) + "_url=" + str2);
                            }
                        }
                        a2.bRy++;
                        bRD.bRI = false;
                    }
                }
                int aiu = bRD.aiu();
                if (aiu > 100 || (aiu > 0 && z8 != bRD.bRI)) {
                    ain();
                }
            }
            if (z && z5) {
                if (!kd || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().bCE) {
                    if (kd || !com.baidu.adp.lib.util.j.kh() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().bCG) {
                        if (!kd && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().bCF) {
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
                aVar = iF();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = t.aix().aiy();
            }
            if (!rf || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = t.aix().nO(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = aip();
            }
            aVar.append("url", str);
            aVar.append(SocialConstants.PARAM_ACT, IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS);
            aVar.append("result", z ? "1" : "0");
            aVar.append("fullurl", str2);
            aVar.append("netlib", String.valueOf(dVar.AG));
            aVar.append("costTime", String.valueOf(j));
            aVar.append("connTime", String.valueOf(dVar.connectTime));
            aVar.append("rspTime", String.valueOf(dVar.Av));
            aVar.append("retry", String.valueOf(dVar.Aw));
            aVar.append("localIp", d.getIp());
            aVar.append("tiebaIp", str6);
            aVar.append("cdnIp", str4);
            aVar.append("useIp", dVar.AC);
            aVar.append("dnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.append("connBaidu", String.valueOf(aiq()));
            }
            aVar.append("memory", air());
            aVar.append("task", ais());
            aVar.append("status", String.valueOf(dVar.AB));
            aVar.append("up", String.valueOf(dVar.At));
            aVar.append("down", String.valueOf(dVar.Au));
            aVar.append("isCDN", rf ? "1" : "0");
            aVar.append("isWebp", bool.booleanValue() ? "1" : "0");
            aVar.append("isMobileProxy", z3 ? "1" : "0");
            aVar.append("exception", dVar.Az);
            aVar.append("reason", str3);
            if (i != 0) {
                aVar.c("procType", Integer.valueOf(i));
            }
            if (dVar.AE != null) {
                aVar.append("tracecode1", dVar.AE);
            }
            if (dVar.AF != null) {
                aVar.append("tracecode2", dVar.AF);
            }
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, aVar);
            if (rf && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                bRD.bRH++;
            }
        }
    }

    public static void ain() {
        if (bRD.aiu() > 10) {
            if (bRD.ait() > 0) {
                a(bRD.bRJ, bRD.bRK, bRD.bRL, bRD.bRN, bRD.bRM, 10000);
                com.baidu.tbadk.p.k.b(bRD.bRJ, bRD.bRK, bRD.bRL, bRD.bRN, bRD.bRM, 3);
            }
            if (bRD.aiw() > 0) {
                a(bRD.bRT, bRD.bRU, bRD.bRV, bRD.bRX, bRD.bRW, 100002);
                com.baidu.tbadk.p.k.b(bRD.bRT, bRD.bRU, bRD.bRV, bRD.bRX, bRD.bRW, 2);
            }
            if (bRD.aiv() > 0) {
                a(bRD.bRO, bRD.bRP, bRD.bRQ, bRD.bRS, bRD.bRR, 100001);
                com.baidu.tbadk.p.k.b(bRD.bRO, bRD.bRP, bRD.bRQ, bRD.bRS, bRD.bRR, 1);
            }
            bRD.reset();
        }
    }

    public static void a(r rVar, r rVar2, r rVar3, r rVar4, r rVar5, int i) {
        if (rVar != null && rVar2 != null && rVar3 != null && rVar4 != null && rVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = t.aix().aiy();
            }
            if (bRG != null && TextUtils.isEmpty("")) {
                str2 = t.aix().nO(bRG);
            }
            if (TextUtils.isEmpty("")) {
                str3 = aip();
            }
            com.baidu.adp.lib.stats.a iF = iF();
            iF.append(SocialConstants.PARAM_ACT, "dlStat");
            iF.append("cdnCostTime", String.valueOf(rVar.time));
            iF.append("cdnNum", String.valueOf(rVar.num));
            iF.append("cdnFailnum", String.valueOf(rVar.bRy));
            iF.append("portraitCostTime", String.valueOf(rVar2.time));
            iF.append("portraitNum", String.valueOf(rVar2.num));
            iF.append("portraitFailnum", String.valueOf(rVar2.bRy));
            iF.append("tiebaCostTime", String.valueOf(rVar3.time));
            iF.append("tiebaNum", String.valueOf(rVar3.num));
            iF.append("tiebaFailnum", String.valueOf(rVar3.bRy));
            iF.append("otherCostTime", String.valueOf(rVar5.time));
            iF.append("otherNum", String.valueOf(rVar5.num));
            iF.append("otherFailnum", String.valueOf(rVar5.bRy));
            iF.append("directIpCostTime", String.valueOf(rVar4.time));
            iF.append("directIpNum", String.valueOf(rVar4.num));
            iF.append("directIpFailnum", String.valueOf(rVar4.bRy));
            iF.append("dnsFailNum", String.valueOf(bRD.bRH));
            if (10000 == i) {
                iF.append("isWifi", "1");
                iF.append("netType", "WIFI");
            } else if (100002 == i) {
                iF.append("netType", "3G");
                iF.append("isWifi", "0");
            } else {
                iF.append("netType", "2G");
                iF.append("isWifi", "0");
            }
            iF.append("localIp", d.getIp());
            iF.append("tbIp", str);
            iF.append("cdnIp", str2);
            iF.append("dnsIp", str3);
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iF);
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.l.kt()) {
            synchronized (syncLock) {
                bRF.num++;
                if (z) {
                    bRF.time += j;
                } else {
                    bRF.bRy++;
                }
                if (bRF.num >= 100) {
                    aio();
                }
            }
            if (!z) {
                if (aVar == null) {
                    aVar = iF();
                }
                aVar.append(SocialConstants.PARAM_ACT, "dc");
                aVar.append("costTime", String.valueOf(j));
                aVar.append("url", str);
                aVar.append("fullURL", str2);
                aVar.append("isWebp", z3 ? "1" : "0");
                aVar.append("isCDN", z2 ? "1" : "0");
                aVar.append("length", String.valueOf(i));
                aVar.append("reason", str3);
                aVar.append("result", z ? "0" : "1");
                aVar.append("execption", str4);
                BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, aVar);
            }
        }
    }

    public static void aio() {
        if (bRF.num > 10) {
            com.baidu.adp.lib.stats.a iF = iF();
            iF.append(SocialConstants.PARAM_ACT, "dcStat");
            iF.append("costTime", String.valueOf(bRF.time));
            iF.append("num", String.valueOf(bRF.num));
            iF.append("failnum", String.valueOf(bRF.bRy));
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iF);
            com.baidu.tbadk.p.k.b(bRF.num, bRF.bRy, bRF.time);
            bRF.reset();
        }
    }

    public static void nN(String str) {
        com.baidu.adp.lib.stats.a iF = iF();
        iF.append(SocialConstants.PARAM_ACT, "assistant");
        iF.append("content", str);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iF);
    }

    private static String aip() {
        try {
            DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApp().getSystemService(IXAdSystemUtils.NT_WIFI)).getDhcpInfo();
            return intToIp(dhcpInfo.dns1) + Constants.ACCEPT_TIME_SEPARATOR_SP + intToIp(dhcpInfo.dns2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String intToIp(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [599=5] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long aiq() {
        HttpURLConnection httpURLConnection;
        long j;
        if (bRA >= 3) {
            return bRB;
        }
        long currentTimeMillis = System.currentTimeMillis();
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(TbDomainConfig.DOMAIN_HTTPS_BAIDU).openConnection();
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
            com.baidu.adp.lib.g.a.f(httpURLConnection);
            j = currentTimeMillis2;
        } catch (SocketTimeoutException e3) {
            com.baidu.adp.lib.g.a.f(httpURLConnection);
            j = 2500;
            if (j > 0) {
            }
        } catch (Exception e4) {
            httpURLConnection2 = httpURLConnection;
            com.baidu.adp.lib.g.a.f(httpURLConnection2);
            j = -1;
            if (j > 0) {
            }
        } catch (Throwable th2) {
            httpURLConnection2 = httpURLConnection;
            th = th2;
            com.baidu.adp.lib.g.a.f(httpURLConnection2);
            throw th;
        }
        if (j > 0) {
            if (bRA > -1) {
                bRB = ((bRB * bRA) + j) / (bRA + 1);
            } else {
                bRB = j;
            }
            bRA++;
            return j;
        }
        return j;
    }

    private static String air() {
        return com.baidu.tbadk.imageManager.c.aty().hd();
    }

    private static String ais() {
        return com.baidu.adp.lib.asyncTask.a.he().hd();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.a iF = iF();
        iF.append(SocialConstants.PARAM_ACT, "getCDNList");
        iF.append("errorNum", str);
        iF.append("errorMsg", str2);
        iF.append("isShortNetError", z2 ? "1" : "0");
        iF.append("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iF);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = t.aix().nO(str);
        }
        String aip = aip();
        String ip = d.getIp();
        com.baidu.adp.lib.stats.a iF = iF();
        iF.append(SocialConstants.PARAM_ACT, "tachometerCDN");
        iF.append("errorNum", str3);
        iF.append("execption", str4);
        iF.append("size", str5);
        iF.append("isScuess", z ? "1" : "0");
        iF.append("url", str);
        iF.append("localIp", ip);
        iF.append("cdnIp", str6);
        iF.append("dnsIP", aip);
        iF.append("usedIp", str2);
        iF.append("isUsedIp", z2 ? "0" : "1");
        iF.append("costTime", String.valueOf(j));
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iF);
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
                    com.baidu.adp.lib.stats.a iF = iF();
                    iF.append(SocialConstants.PARAM_ACT, "mobileTachometerCDN");
                    iF.append("costTime", String.valueOf(j));
                    iF.append("ipList", sb.toString());
                    BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iF);
                    return;
                }
            }
        }
    }

    public static void g(boolean z, String str) {
        com.baidu.adp.lib.stats.a iF = iF();
        iF.append(SocialConstants.PARAM_ACT, "getCDNList");
        iF.append("isSuccess", z ? "1" : "0");
        iF.append("errorMsg", str);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, iF);
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
