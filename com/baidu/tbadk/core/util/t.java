package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.sapi2.callback.AccountCenterCallback;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.tencent.open.SocialConstants;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class t {
    private static long aoG = 0;
    private static long aoH = 0;
    private static int aoI = 0;
    private static a aoJ = new a();
    private static s aoK = new s();
    private static s aoL = new s();
    private static String aoM = null;
    private static Object syncLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int aoN;
        boolean aoO;
        s aoP;
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

        private a() {
            this.aoN = 0;
            this.aoP = new s();
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
        }

        public int yw() {
            return this.aoP.num + this.aoQ.num + this.aoR.num + this.aoS.num + this.aoT.num;
        }

        public int yx() {
            return this.aoP.num + this.aoQ.num + this.aoR.num + this.aoS.num + this.aoT.num + this.aoU.num + this.aoV.num + this.aoW.num + this.aoX.num + this.aoY.num + this.aoZ.num + this.apa.num + this.apb.num + this.apc.num + this.apd.num;
        }

        public int yy() {
            return this.aoU.num + this.aoV.num + this.aoW.num + this.aoX.num + this.aoY.num;
        }

        public int yz() {
            return this.aoZ.num + this.apa.num + this.apb.num + this.apc.num + this.apd.num;
        }

        public void reset() {
            this.aoN = 0;
            this.aoP.reset();
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
        }
    }

    private static s a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return aoJ.aoP;
            }
            if (str.startsWith("http://tb.himg")) {
                return aoJ.aoQ;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aoJ.aoR;
            }
            if (z2 && z3) {
                return aoJ.aoT;
            }
            return aoJ.aoS;
        } else if (com.baidu.adp.lib.util.j.jI()) {
            if (z2) {
                return aoJ.aoU;
            }
            if (str.startsWith("http://tb.himg")) {
                return aoJ.aoV;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aoJ.aoW;
            }
            return aoJ.aoX;
        } else if (z2) {
            return aoJ.aoZ;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return aoJ.apa;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aoJ.apb;
            }
            return aoJ.apc;
        }
    }

    public static com.baidu.adp.lib.stats.a ih() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (syncLock) {
                aoK.num++;
                aoK.time += j;
                if (aoK.num >= 100) {
                    yp();
                }
            }
        }
    }

    public static void yp() {
        if (aoK.num > 10) {
            com.baidu.adp.lib.stats.a ih = ih();
            ih.append(SocialConstants.PARAM_ACT, "locStat");
            ih.append("costTime", String.valueOf(aoK.time));
            ih.append("num", String.valueOf(aoK.num));
            ih.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", ih);
            aoK.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.l.jU() && dVar != null) {
            String str6 = "";
            boolean hv = com.baidu.tbadk.util.i.hv(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().arR) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean jE = com.baidu.adp.lib.util.j.jE();
            if (!z5) {
                z4 = false;
            } else if (jE) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().abN);
            } else if (com.baidu.adp.lib.util.j.jI()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().abP);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().abO);
            }
            boolean z6 = false;
            if (hv && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (hv && jE && z6) {
                if (z) {
                    q.getInstance().insertNormalData(j, str);
                } else {
                    str6 = u.yA().yB();
                    if (!TextUtils.isEmpty(str6)) {
                        q.getInstance().insertErrorData(dVar.zL, str);
                    }
                }
            }
            if (hv) {
                aoM = str;
            }
            boolean z7 = false;
            if (dVar.zN != null && dVar.zN.length() > 0) {
                z7 = true;
            }
            synchronized (syncLock) {
                s a2 = a(jE, hv, str2, z7);
                boolean z8 = aoJ.aoO;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.zF += j2;
                        aoJ.aoO = true;
                        if (z4) {
                            a2.aoF++;
                        }
                        aoI = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.jD()) {
                            int i2 = aoI + 1;
                            aoI = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.iV().getMaxAlertCount("alert_img", 5)) {
                                BdStatisticsManager.getInstance().alert("alert_img", "imgFailedCnt_" + String.valueOf(aoI) + "_url=" + str2);
                            }
                        }
                        a2.aoE++;
                        aoJ.aoO = false;
                    }
                }
                int yx = aoJ.yx();
                if (yx > 100 || (yx > 0 && z8 != aoJ.aoO)) {
                    yq();
                }
            }
            if (z && z5) {
                if (!jE || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().abN) {
                    if (jE || !com.baidu.adp.lib.util.j.jI() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().abP) {
                        if (!jE && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().abO) {
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
                aVar = ih();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = u.yA().yB();
            }
            if (!hv || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = u.yA().ew(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = ys();
            }
            aVar.append("url", str);
            aVar.append(SocialConstants.PARAM_ACT, "dl");
            aVar.append("result", z ? "1" : "0");
            aVar.append("fullurl", str2);
            aVar.append("netlib", String.valueOf(dVar.zR));
            aVar.append("costTime", String.valueOf(j));
            aVar.append("connTime", String.valueOf(dVar.connectTime));
            aVar.append("rspTime", String.valueOf(dVar.zG));
            aVar.append("retry", String.valueOf(dVar.zH));
            aVar.append("localIp", d.getIp());
            aVar.append("tiebaIp", str6);
            aVar.append("cdnIp", str4);
            aVar.append("useIp", dVar.zN);
            aVar.append("dnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.append("connBaidu", String.valueOf(yt()));
            }
            aVar.append("memory", yu());
            aVar.append("task", yv());
            aVar.append(NotificationCompat.CATEGORY_STATUS, String.valueOf(dVar.zM));
            aVar.append("up", String.valueOf(dVar.zE));
            aVar.append("down", String.valueOf(dVar.zF));
            aVar.append("isCDN", hv ? "1" : "0");
            aVar.append("isWebp", bool.booleanValue() ? "1" : "0");
            aVar.append("isMobileProxy", z3 ? "1" : "0");
            aVar.append(com.baidu.fsg.base.statistics.b.k, dVar.zK);
            aVar.append("reason", str3);
            if (i != 0) {
                aVar.f("procType", Integer.valueOf(i));
            }
            if (dVar.zP != null) {
                aVar.append("tracecode1", dVar.zP);
            }
            if (dVar.zQ != null) {
                aVar.append("tracecode2", dVar.zQ);
            }
            BdStatisticsManager.getInstance().debug("img", aVar);
            if (hv && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                aoJ.aoN++;
            }
        }
    }

    public static void yq() {
        if (aoJ.yx() > 10) {
            if (aoJ.yw() > 0) {
                a(aoJ.aoP, aoJ.aoQ, aoJ.aoR, aoJ.aoT, aoJ.aoS, 10000);
                com.baidu.tbadk.k.k.b(aoJ.aoP, aoJ.aoQ, aoJ.aoR, aoJ.aoT, aoJ.aoS, 3);
            }
            if (aoJ.yz() > 0) {
                a(aoJ.aoZ, aoJ.apa, aoJ.apb, aoJ.apd, aoJ.apc, 100002);
                com.baidu.tbadk.k.k.b(aoJ.aoZ, aoJ.apa, aoJ.apb, aoJ.apd, aoJ.apc, 2);
            }
            if (aoJ.yy() > 0) {
                a(aoJ.aoU, aoJ.aoV, aoJ.aoW, aoJ.aoY, aoJ.aoX, AccountCenterCallback.REQUEST_CODE_LOGIN);
                com.baidu.tbadk.k.k.b(aoJ.aoU, aoJ.aoV, aoJ.aoW, aoJ.aoY, aoJ.aoX, 1);
            }
            aoJ.reset();
        }
    }

    public static void a(s sVar, s sVar2, s sVar3, s sVar4, s sVar5, int i) {
        if (sVar != null && sVar2 != null && sVar3 != null && sVar4 != null && sVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = u.yA().yB();
            }
            if (aoM != null && TextUtils.isEmpty("")) {
                str2 = u.yA().ew(aoM);
            }
            if (TextUtils.isEmpty("")) {
                str3 = ys();
            }
            com.baidu.adp.lib.stats.a ih = ih();
            ih.append(SocialConstants.PARAM_ACT, "dlStat");
            ih.append("cdnCostTime", String.valueOf(sVar.time));
            ih.append("cdnNum", String.valueOf(sVar.num));
            ih.append("cdnFailnum", String.valueOf(sVar.aoE));
            ih.append("portraitCostTime", String.valueOf(sVar2.time));
            ih.append("portraitNum", String.valueOf(sVar2.num));
            ih.append("portraitFailnum", String.valueOf(sVar2.aoE));
            ih.append("tiebaCostTime", String.valueOf(sVar3.time));
            ih.append("tiebaNum", String.valueOf(sVar3.num));
            ih.append("tiebaFailnum", String.valueOf(sVar3.aoE));
            ih.append("otherCostTime", String.valueOf(sVar5.time));
            ih.append("otherNum", String.valueOf(sVar5.num));
            ih.append("otherFailnum", String.valueOf(sVar5.aoE));
            ih.append("directIpCostTime", String.valueOf(sVar4.time));
            ih.append("directIpNum", String.valueOf(sVar4.num));
            ih.append("directIpFailnum", String.valueOf(sVar4.aoE));
            ih.append("dnsFailNum", String.valueOf(aoJ.aoN));
            if (10000 == i) {
                ih.append("isWifi", "1");
                ih.append("netType", "WIFI");
            } else if (100002 == i) {
                ih.append("netType", "3G");
                ih.append("isWifi", "0");
            } else {
                ih.append("netType", "2G");
                ih.append("isWifi", "0");
            }
            ih.append("localIp", d.getIp());
            ih.append("tbIp", str);
            ih.append("cdnIp", str2);
            ih.append("dnsIp", str3);
            BdStatisticsManager.getInstance().debug("img", ih);
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.l.jU()) {
            synchronized (syncLock) {
                aoL.num++;
                if (z) {
                    aoL.time += j;
                } else {
                    aoL.aoE++;
                }
                if (aoL.num >= 100) {
                    yr();
                }
            }
            if (!z) {
                if (aVar == null) {
                    aVar = ih();
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
                BdStatisticsManager.getInstance().debug("img", aVar);
            }
        }
    }

    public static void yr() {
        if (aoL.num > 10) {
            com.baidu.adp.lib.stats.a ih = ih();
            ih.append(SocialConstants.PARAM_ACT, "dcStat");
            ih.append("costTime", String.valueOf(aoL.time));
            ih.append("num", String.valueOf(aoL.num));
            ih.append("failnum", String.valueOf(aoL.aoE));
            BdStatisticsManager.getInstance().debug("img", ih);
            com.baidu.tbadk.k.k.a(aoL.num, aoL.aoE, aoL.time);
            aoL.reset();
        }
    }

    public static void ev(String str) {
        com.baidu.adp.lib.stats.a ih = ih();
        ih.append(SocialConstants.PARAM_ACT, "assistant");
        ih.append("content", str);
        BdStatisticsManager.getInstance().debug("img", ih);
    }

    private static String ys() {
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
    private static long yt() {
        HttpURLConnection httpURLConnection;
        long j;
        if (aoG >= 3) {
            return aoH;
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
            if (aoG > -1) {
                aoH = ((aoH * aoG) + j) / (aoG + 1);
            } else {
                aoH = j;
            }
            aoG++;
            return j;
        }
        return j;
    }

    private static String yu() {
        return com.baidu.tbadk.imageManager.c.ID().gI();
    }

    private static String yv() {
        return com.baidu.adp.lib.asyncTask.a.gJ().gI();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.a ih = ih();
        ih.append(SocialConstants.PARAM_ACT, "getCDNList");
        ih.append("errorNum", str);
        ih.append("errorMsg", str2);
        ih.append("isShortNetError", z2 ? "1" : "0");
        ih.append("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug("img", ih);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = u.yA().ew(str);
        }
        String ys = ys();
        String ip = d.getIp();
        com.baidu.adp.lib.stats.a ih = ih();
        ih.append(SocialConstants.PARAM_ACT, "tachometerCDN");
        ih.append("errorNum", str3);
        ih.append("execption", str4);
        ih.append("size", str5);
        ih.append("isScuess", z ? "1" : "0");
        ih.append("url", str);
        ih.append("localIp", ip);
        ih.append("cdnIp", str6);
        ih.append("dnsIP", ys);
        ih.append("usedIp", str2);
        ih.append("isUsedIp", z2 ? "0" : "1");
        ih.append("costTime", String.valueOf(j));
        BdStatisticsManager.getInstance().debug("img", ih);
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
                    com.baidu.adp.lib.stats.a ih = ih();
                    ih.append(SocialConstants.PARAM_ACT, "mobileTachometerCDN");
                    ih.append("costTime", String.valueOf(j));
                    ih.append("ipList", sb.toString());
                    BdStatisticsManager.getInstance().debug("img", ih);
                    return;
                }
            }
        }
    }

    public static void d(boolean z, String str) {
        com.baidu.adp.lib.stats.a ih = ih();
        ih.append(SocialConstants.PARAM_ACT, "getCDNList");
        ih.append("isSuccess", z ? "1" : "0");
        ih.append("errorMsg", str);
        BdStatisticsManager.getInstance().debug("img", ih);
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
