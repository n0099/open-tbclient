package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.tencent.open.SocialConstants;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class t {
    private static long aoH = 0;
    private static long aoI = 0;
    private static int aoJ = 0;
    private static a aoK = new a();
    private static s aoL = new s();
    private static s aoM = new s();
    private static String aoN = null;
    private static Object syncLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int aoO;
        boolean aoP;
        s aoQ;
        s aoR;
        s aoS;
        s aoT;
        s aoU;
        s aoV;
        s aoW;
        s aoX;
        s aoY;
        s aoZ;
        s apa;
        s apb;
        s apc;
        s apd;
        s ape;

        private a() {
            this.aoO = 0;
            this.aoQ = new s();
            this.aoR = new s();
            this.aoS = new s();
            this.aoT = new s();
            this.aoU = new s();
            this.aoV = new s();
            this.aoW = new s();
            this.aoX = new s();
            this.aoY = new s();
            this.aoZ = new s();
            this.apa = new s();
            this.apb = new s();
            this.apc = new s();
            this.apd = new s();
            this.ape = new s();
        }

        public int yz() {
            return this.aoQ.num + this.aoR.num + this.aoS.num + this.aoT.num + this.aoU.num;
        }

        public int yA() {
            return this.aoQ.num + this.aoR.num + this.aoS.num + this.aoT.num + this.aoU.num + this.aoV.num + this.aoW.num + this.aoX.num + this.aoY.num + this.aoZ.num + this.apa.num + this.apb.num + this.apc.num + this.apd.num + this.ape.num;
        }

        public int yB() {
            return this.aoV.num + this.aoW.num + this.aoX.num + this.aoY.num + this.aoZ.num;
        }

        public int yC() {
            return this.apa.num + this.apb.num + this.apc.num + this.apd.num + this.ape.num;
        }

        public void reset() {
            this.aoO = 0;
            this.aoQ.reset();
            this.aoR.reset();
            this.aoS.reset();
            this.aoT.reset();
            this.aoU.reset();
            this.aoV.reset();
            this.aoW.reset();
            this.aoX.reset();
            this.aoY.reset();
            this.aoZ.reset();
            this.apa.reset();
            this.apb.reset();
            this.apc.reset();
            this.apd.reset();
            this.ape.reset();
        }
    }

    private static s a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return aoK.aoQ;
            }
            if (str.startsWith("http://tb.himg")) {
                return aoK.aoR;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aoK.aoS;
            }
            if (z2 && z3) {
                return aoK.aoU;
            }
            return aoK.aoT;
        } else if (com.baidu.adp.lib.util.j.jJ()) {
            if (z2) {
                return aoK.aoV;
            }
            if (str.startsWith("http://tb.himg")) {
                return aoK.aoW;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aoK.aoX;
            }
            return aoK.aoY;
        } else if (z2) {
            return aoK.apa;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return aoK.apb;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aoK.apc;
            }
            return aoK.apd;
        }
    }

    public static com.baidu.adp.lib.stats.a ii() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (syncLock) {
                aoL.num++;
                aoL.time += j;
                if (aoL.num >= 100) {
                    ys();
                }
            }
        }
    }

    public static void ys() {
        if (aoL.num > 10) {
            com.baidu.adp.lib.stats.a ii = ii();
            ii.append(SocialConstants.PARAM_ACT, "locStat");
            ii.append("costTime", String.valueOf(aoL.time));
            ii.append("num", String.valueOf(aoL.num));
            ii.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, ii);
            aoL.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.l.jV() && dVar != null) {
            String str6 = "";
            boolean hw = com.baidu.tbadk.util.h.hw(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().arY) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean jF = com.baidu.adp.lib.util.j.jF();
            if (!z5) {
                z4 = false;
            } else if (jF) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().abx);
            } else if (com.baidu.adp.lib.util.j.jJ()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().abz);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aby);
            }
            boolean z6 = false;
            if (hw && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (hw && jF && z6) {
                if (z) {
                    q.getInstance().insertNormalData(j, str);
                } else {
                    str6 = u.yD().yE();
                    if (!TextUtils.isEmpty(str6)) {
                        q.getInstance().insertErrorData(dVar.zF, str);
                    }
                }
            }
            if (hw) {
                aoN = str;
            }
            boolean z7 = false;
            if (dVar.zH != null && dVar.zH.length() > 0) {
                z7 = true;
            }
            synchronized (syncLock) {
                s a2 = a(jF, hw, str2, z7);
                boolean z8 = aoK.aoP;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.zz += j2;
                        aoK.aoP = true;
                        if (z4) {
                            a2.aoG++;
                        }
                        aoJ = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.jE()) {
                            int i2 = aoJ + 1;
                            aoJ = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.iW().getMaxAlertCount("alert_img", 5)) {
                                BdStatisticsManager.getInstance().alert("alert_img", "imgFailedCnt_" + String.valueOf(aoJ) + "_url=" + str2);
                            }
                        }
                        a2.aoF++;
                        aoK.aoP = false;
                    }
                }
                int yA = aoK.yA();
                if (yA > 100 || (yA > 0 && z8 != aoK.aoP)) {
                    yt();
                }
            }
            if (z && z5) {
                if (!jF || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().abx) {
                    if (jF || !com.baidu.adp.lib.util.j.jJ() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().abz) {
                        if (!jF && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aby) {
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
                aVar = ii();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = u.yD().yE();
            }
            if (!hw || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = u.yD().ex(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = yv();
            }
            aVar.append("url", str);
            aVar.append(SocialConstants.PARAM_ACT, "dl");
            aVar.append("result", z ? "1" : "0");
            aVar.append("fullurl", str2);
            aVar.append("netlib", String.valueOf(dVar.zL));
            aVar.append("costTime", String.valueOf(j));
            aVar.append("connTime", String.valueOf(dVar.connectTime));
            aVar.append("rspTime", String.valueOf(dVar.zA));
            aVar.append("retry", String.valueOf(dVar.zB));
            aVar.append("localIp", d.getIp());
            aVar.append("tiebaIp", str6);
            aVar.append("cdnIp", str4);
            aVar.append("useIp", dVar.zH);
            aVar.append("dnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.append("connBaidu", String.valueOf(yw()));
            }
            aVar.append("memory", yx());
            aVar.append("task", yy());
            aVar.append(NotificationCompat.CATEGORY_STATUS, String.valueOf(dVar.zG));
            aVar.append("up", String.valueOf(dVar.zy));
            aVar.append("down", String.valueOf(dVar.zz));
            aVar.append("isCDN", hw ? "1" : "0");
            aVar.append("isWebp", bool.booleanValue() ? "1" : "0");
            aVar.append("isMobileProxy", z3 ? "1" : "0");
            aVar.append(com.baidu.fsg.base.statistics.b.k, dVar.zE);
            aVar.append("reason", str3);
            if (i != 0) {
                aVar.f("procType", Integer.valueOf(i));
            }
            if (dVar.zJ != null) {
                aVar.append("tracecode1", dVar.zJ);
            }
            if (dVar.zK != null) {
                aVar.append("tracecode2", dVar.zK);
            }
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, aVar);
            if (hw && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                aoK.aoO++;
            }
        }
    }

    public static void yt() {
        if (aoK.yA() > 10) {
            if (aoK.yz() > 0) {
                a(aoK.aoQ, aoK.aoR, aoK.aoS, aoK.aoU, aoK.aoT, 10000);
                com.baidu.tbadk.l.k.b(aoK.aoQ, aoK.aoR, aoK.aoS, aoK.aoU, aoK.aoT, 3);
            }
            if (aoK.yC() > 0) {
                a(aoK.apa, aoK.apb, aoK.apc, aoK.ape, aoK.apd, 100002);
                com.baidu.tbadk.l.k.b(aoK.apa, aoK.apb, aoK.apc, aoK.ape, aoK.apd, 2);
            }
            if (aoK.yB() > 0) {
                a(aoK.aoV, aoK.aoW, aoK.aoX, aoK.aoZ, aoK.aoY, 100001);
                com.baidu.tbadk.l.k.b(aoK.aoV, aoK.aoW, aoK.aoX, aoK.aoZ, aoK.aoY, 1);
            }
            aoK.reset();
        }
    }

    public static void a(s sVar, s sVar2, s sVar3, s sVar4, s sVar5, int i) {
        if (sVar != null && sVar2 != null && sVar3 != null && sVar4 != null && sVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = u.yD().yE();
            }
            if (aoN != null && TextUtils.isEmpty("")) {
                str2 = u.yD().ex(aoN);
            }
            if (TextUtils.isEmpty("")) {
                str3 = yv();
            }
            com.baidu.adp.lib.stats.a ii = ii();
            ii.append(SocialConstants.PARAM_ACT, "dlStat");
            ii.append("cdnCostTime", String.valueOf(sVar.time));
            ii.append("cdnNum", String.valueOf(sVar.num));
            ii.append("cdnFailnum", String.valueOf(sVar.aoF));
            ii.append("portraitCostTime", String.valueOf(sVar2.time));
            ii.append("portraitNum", String.valueOf(sVar2.num));
            ii.append("portraitFailnum", String.valueOf(sVar2.aoF));
            ii.append("tiebaCostTime", String.valueOf(sVar3.time));
            ii.append("tiebaNum", String.valueOf(sVar3.num));
            ii.append("tiebaFailnum", String.valueOf(sVar3.aoF));
            ii.append("otherCostTime", String.valueOf(sVar5.time));
            ii.append("otherNum", String.valueOf(sVar5.num));
            ii.append("otherFailnum", String.valueOf(sVar5.aoF));
            ii.append("directIpCostTime", String.valueOf(sVar4.time));
            ii.append("directIpNum", String.valueOf(sVar4.num));
            ii.append("directIpFailnum", String.valueOf(sVar4.aoF));
            ii.append("dnsFailNum", String.valueOf(aoK.aoO));
            if (10000 == i) {
                ii.append("isWifi", "1");
                ii.append("netType", "WIFI");
            } else if (100002 == i) {
                ii.append("netType", "3G");
                ii.append("isWifi", "0");
            } else {
                ii.append("netType", "2G");
                ii.append("isWifi", "0");
            }
            ii.append("localIp", d.getIp());
            ii.append("tbIp", str);
            ii.append("cdnIp", str2);
            ii.append("dnsIp", str3);
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, ii);
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.l.jV()) {
            synchronized (syncLock) {
                aoM.num++;
                if (z) {
                    aoM.time += j;
                } else {
                    aoM.aoF++;
                }
                if (aoM.num >= 100) {
                    yu();
                }
            }
            if (!z) {
                if (aVar == null) {
                    aVar = ii();
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

    public static void yu() {
        if (aoM.num > 10) {
            com.baidu.adp.lib.stats.a ii = ii();
            ii.append(SocialConstants.PARAM_ACT, "dcStat");
            ii.append("costTime", String.valueOf(aoM.time));
            ii.append("num", String.valueOf(aoM.num));
            ii.append("failnum", String.valueOf(aoM.aoF));
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, ii);
            com.baidu.tbadk.l.k.a(aoM.num, aoM.aoF, aoM.time);
            aoM.reset();
        }
    }

    public static void ew(String str) {
        com.baidu.adp.lib.stats.a ii = ii();
        ii.append(SocialConstants.PARAM_ACT, "assistant");
        ii.append("content", str);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, ii);
    }

    private static String yv() {
        try {
            DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApp().getSystemService("wifi")).getDhcpInfo();
            return intToIp(dhcpInfo.dns1) + "," + intToIp(dhcpInfo.dns2);
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
    private static long yw() {
        HttpURLConnection httpURLConnection;
        long j;
        if (aoH >= 3) {
            return aoI;
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
            if (aoH > -1) {
                aoI = ((aoI * aoH) + j) / (aoH + 1);
            } else {
                aoI = j;
            }
            aoH++;
            return j;
        }
        return j;
    }

    private static String yx() {
        return com.baidu.tbadk.imageManager.c.IQ().gH();
    }

    private static String yy() {
        return com.baidu.adp.lib.asyncTask.a.gI().gH();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.a ii = ii();
        ii.append(SocialConstants.PARAM_ACT, "getCDNList");
        ii.append("errorNum", str);
        ii.append("errorMsg", str2);
        ii.append("isShortNetError", z2 ? "1" : "0");
        ii.append("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, ii);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = u.yD().ex(str);
        }
        String yv = yv();
        String ip = d.getIp();
        com.baidu.adp.lib.stats.a ii = ii();
        ii.append(SocialConstants.PARAM_ACT, "tachometerCDN");
        ii.append("errorNum", str3);
        ii.append("execption", str4);
        ii.append("size", str5);
        ii.append("isScuess", z ? "1" : "0");
        ii.append("url", str);
        ii.append("localIp", ip);
        ii.append("cdnIp", str6);
        ii.append("dnsIP", yv);
        ii.append("usedIp", str2);
        ii.append("isUsedIp", z2 ? "0" : "1");
        ii.append("costTime", String.valueOf(j));
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, ii);
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
                    com.baidu.adp.lib.stats.a ii = ii();
                    ii.append(SocialConstants.PARAM_ACT, "mobileTachometerCDN");
                    ii.append("costTime", String.valueOf(j));
                    ii.append("ipList", sb.toString());
                    BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, ii);
                    return;
                }
            }
        }
    }

    public static void c(boolean z, String str) {
        com.baidu.adp.lib.stats.a ii = ii();
        ii.append(SocialConstants.PARAM_ACT, "getCDNList");
        ii.append("isSuccess", z ? "1" : "0");
        ii.append("errorMsg", str);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, ii);
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
