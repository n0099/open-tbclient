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
import com.xiaomi.mipush.sdk.Constants;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class s {
    private static long aVq = 0;
    private static long aVr = 0;
    private static int aVs = 0;
    private static a aVt = new a();
    private static r aVu = new r();
    private static r aVv = new r();
    private static String aVw = null;
    private static Object syncLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        r aVA;
        r aVB;
        r aVC;
        r aVD;
        r aVE;
        r aVF;
        r aVG;
        r aVH;
        r aVI;
        r aVJ;
        r aVK;
        r aVL;
        r aVM;
        r aVN;
        int aVx;
        boolean aVy;
        r aVz;

        private a() {
            this.aVx = 0;
            this.aVz = new r();
            this.aVA = new r();
            this.aVB = new r();
            this.aVC = new r();
            this.aVD = new r();
            this.aVE = new r();
            this.aVF = new r();
            this.aVG = new r();
            this.aVH = new r();
            this.aVI = new r();
            this.aVJ = new r();
            this.aVK = new r();
            this.aVL = new r();
            this.aVM = new r();
            this.aVN = new r();
        }

        public int Cm() {
            return this.aVz.num + this.aVA.num + this.aVB.num + this.aVC.num + this.aVD.num;
        }

        public int Cn() {
            return this.aVz.num + this.aVA.num + this.aVB.num + this.aVC.num + this.aVD.num + this.aVE.num + this.aVF.num + this.aVG.num + this.aVH.num + this.aVI.num + this.aVJ.num + this.aVK.num + this.aVL.num + this.aVM.num + this.aVN.num;
        }

        public int Co() {
            return this.aVE.num + this.aVF.num + this.aVG.num + this.aVH.num + this.aVI.num;
        }

        public int Cp() {
            return this.aVJ.num + this.aVK.num + this.aVL.num + this.aVM.num + this.aVN.num;
        }

        public void reset() {
            this.aVx = 0;
            this.aVz.reset();
            this.aVA.reset();
            this.aVB.reset();
            this.aVC.reset();
            this.aVD.reset();
            this.aVE.reset();
            this.aVF.reset();
            this.aVG.reset();
            this.aVH.reset();
            this.aVI.reset();
            this.aVJ.reset();
            this.aVK.reset();
            this.aVL.reset();
            this.aVM.reset();
            this.aVN.reset();
        }
    }

    private static r a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return aVt.aVz;
            }
            if (str.startsWith("http://tb.himg")) {
                return aVt.aVA;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aVt.aVB;
            }
            if (z2 && z3) {
                return aVt.aVD;
            }
            return aVt.aVC;
        } else if (com.baidu.adp.lib.util.j.oO()) {
            if (z2) {
                return aVt.aVE;
            }
            if (str.startsWith("http://tb.himg")) {
                return aVt.aVF;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aVt.aVG;
            }
            return aVt.aVH;
        } else if (z2) {
            return aVt.aVJ;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return aVt.aVK;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aVt.aVL;
            }
            return aVt.aVM;
        }
    }

    public static com.baidu.adp.lib.stats.a nn() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (syncLock) {
                aVu.num++;
                aVu.time += j;
                if (aVu.num >= 100) {
                    Cf();
                }
            }
        }
    }

    public static void Cf() {
        if (aVu.num > 10) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append(SocialConstants.PARAM_ACT, "locStat");
            nn.append("costTime", String.valueOf(aVu.time));
            nn.append("num", String.valueOf(aVu.num));
            nn.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", nn);
            aVu.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.l.pa() && dVar != null) {
            String str6 = "";
            boolean hi = com.baidu.tbadk.util.i.hi(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().aYq) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean oK = com.baidu.adp.lib.util.j.oK();
            if (!z5) {
                z4 = false;
            } else if (oK) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aIA);
            } else if (com.baidu.adp.lib.util.j.oO()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aIC);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aIB);
            }
            boolean z6 = false;
            if (hi && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (hi && oK && z6) {
                if (z) {
                    p.getInstance().insertNormalData(j, str);
                } else {
                    str6 = t.Cq().Cr();
                    if (!TextUtils.isEmpty(str6)) {
                        p.getInstance().insertErrorData(dVar.ajm, str);
                    }
                }
            }
            if (hi) {
                aVw = str;
            }
            boolean z7 = false;
            if (dVar.ajo != null && dVar.ajo.length() > 0) {
                z7 = true;
            }
            synchronized (syncLock) {
                r a2 = a(oK, hi, str2, z7);
                boolean z8 = aVt.aVy;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.ajg += j2;
                        aVt.aVy = true;
                        if (z4) {
                            a2.aVp++;
                        }
                        aVs = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.oJ()) {
                            int i2 = aVs + 1;
                            aVs = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.ob().getMaxAlertCount("alert_img", 5)) {
                                BdStatisticsManager.getInstance().alert("alert_img", "imgFailedCnt_" + String.valueOf(aVs) + "_url=" + str2);
                            }
                        }
                        a2.aVo++;
                        aVt.aVy = false;
                    }
                }
                int Cn = aVt.Cn();
                if (Cn > 100 || (Cn > 0 && z8 != aVt.aVy)) {
                    Cg();
                }
            }
            if (z && z5) {
                if (!oK || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aIA) {
                    if (oK || !com.baidu.adp.lib.util.j.oO() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aIC) {
                        if (!oK && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aIB) {
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
                aVar = nn();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = t.Cq().Cr();
            }
            if (!hi || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = t.Cq().ee(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = Ci();
            }
            aVar.append("url", str);
            aVar.append(SocialConstants.PARAM_ACT, "dl");
            aVar.append("result", z ? "1" : "0");
            aVar.append("fullurl", str2);
            aVar.append("netlib", String.valueOf(dVar.ajs));
            aVar.append("costTime", String.valueOf(j));
            aVar.append("connTime", String.valueOf(dVar.connectTime));
            aVar.append("rspTime", String.valueOf(dVar.ajh));
            aVar.append("retry", String.valueOf(dVar.aji));
            aVar.append("localIp", d.getIp());
            aVar.append("tiebaIp", str6);
            aVar.append("cdnIp", str4);
            aVar.append("useIp", dVar.ajo);
            aVar.append("dnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.append("connBaidu", String.valueOf(Cj()));
            }
            aVar.append("memory", Ck());
            aVar.append("task", Cl());
            aVar.append(NotificationCompat.CATEGORY_STATUS, String.valueOf(dVar.ajn));
            aVar.append("up", String.valueOf(dVar.ajf));
            aVar.append("down", String.valueOf(dVar.ajg));
            aVar.append("isCDN", hi ? "1" : "0");
            aVar.append("isWebp", bool.booleanValue() ? "1" : "0");
            aVar.append("isMobileProxy", z3 ? "1" : "0");
            aVar.append(com.baidu.fsg.base.statistics.b.k, dVar.ajl);
            aVar.append("reason", str3);
            if (i != 0) {
                aVar.h("procType", Integer.valueOf(i));
            }
            if (dVar.ajq != null) {
                aVar.append("tracecode1", dVar.ajq);
            }
            if (dVar.ajr != null) {
                aVar.append("tracecode2", dVar.ajr);
            }
            BdStatisticsManager.getInstance().debug("img", aVar);
            if (hi && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                aVt.aVx++;
            }
        }
    }

    public static void Cg() {
        if (aVt.Cn() > 10) {
            if (aVt.Cm() > 0) {
                a(aVt.aVz, aVt.aVA, aVt.aVB, aVt.aVD, aVt.aVC, 10000);
                com.baidu.tbadk.k.n.b(aVt.aVz, aVt.aVA, aVt.aVB, aVt.aVD, aVt.aVC, 3);
            }
            if (aVt.Cp() > 0) {
                a(aVt.aVJ, aVt.aVK, aVt.aVL, aVt.aVN, aVt.aVM, 100002);
                com.baidu.tbadk.k.n.b(aVt.aVJ, aVt.aVK, aVt.aVL, aVt.aVN, aVt.aVM, 2);
            }
            if (aVt.Co() > 0) {
                a(aVt.aVE, aVt.aVF, aVt.aVG, aVt.aVI, aVt.aVH, AccountCenterCallback.REQUEST_CODE_LOGIN);
                com.baidu.tbadk.k.n.b(aVt.aVE, aVt.aVF, aVt.aVG, aVt.aVI, aVt.aVH, 1);
            }
            aVt.reset();
        }
    }

    public static void a(r rVar, r rVar2, r rVar3, r rVar4, r rVar5, int i) {
        if (rVar != null && rVar2 != null && rVar3 != null && rVar4 != null && rVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = t.Cq().Cr();
            }
            if (aVw != null && TextUtils.isEmpty("")) {
                str2 = t.Cq().ee(aVw);
            }
            if (TextUtils.isEmpty("")) {
                str3 = Ci();
            }
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append(SocialConstants.PARAM_ACT, "dlStat");
            nn.append("cdnCostTime", String.valueOf(rVar.time));
            nn.append("cdnNum", String.valueOf(rVar.num));
            nn.append("cdnFailnum", String.valueOf(rVar.aVo));
            nn.append("portraitCostTime", String.valueOf(rVar2.time));
            nn.append("portraitNum", String.valueOf(rVar2.num));
            nn.append("portraitFailnum", String.valueOf(rVar2.aVo));
            nn.append("tiebaCostTime", String.valueOf(rVar3.time));
            nn.append("tiebaNum", String.valueOf(rVar3.num));
            nn.append("tiebaFailnum", String.valueOf(rVar3.aVo));
            nn.append("otherCostTime", String.valueOf(rVar5.time));
            nn.append("otherNum", String.valueOf(rVar5.num));
            nn.append("otherFailnum", String.valueOf(rVar5.aVo));
            nn.append("directIpCostTime", String.valueOf(rVar4.time));
            nn.append("directIpNum", String.valueOf(rVar4.num));
            nn.append("directIpFailnum", String.valueOf(rVar4.aVo));
            nn.append("dnsFailNum", String.valueOf(aVt.aVx));
            if (10000 == i) {
                nn.append("isWifi", "1");
                nn.append("netType", "WIFI");
            } else if (100002 == i) {
                nn.append("netType", "3G");
                nn.append("isWifi", "0");
            } else {
                nn.append("netType", "2G");
                nn.append("isWifi", "0");
            }
            nn.append("localIp", d.getIp());
            nn.append("tbIp", str);
            nn.append("cdnIp", str2);
            nn.append("dnsIp", str3);
            BdStatisticsManager.getInstance().debug("img", nn);
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.l.pa()) {
            synchronized (syncLock) {
                aVv.num++;
                if (z) {
                    aVv.time += j;
                } else {
                    aVv.aVo++;
                }
                if (aVv.num >= 100) {
                    Ch();
                }
            }
            if (!z) {
                if (aVar == null) {
                    aVar = nn();
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

    public static void Ch() {
        if (aVv.num > 10) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append(SocialConstants.PARAM_ACT, "dcStat");
            nn.append("costTime", String.valueOf(aVv.time));
            nn.append("num", String.valueOf(aVv.num));
            nn.append("failnum", String.valueOf(aVv.aVo));
            BdStatisticsManager.getInstance().debug("img", nn);
            com.baidu.tbadk.k.n.a(aVv.num, aVv.aVo, aVv.time);
            aVv.reset();
        }
    }

    public static void ed(String str) {
        com.baidu.adp.lib.stats.a nn = nn();
        nn.append(SocialConstants.PARAM_ACT, "assistant");
        nn.append("content", str);
        BdStatisticsManager.getInstance().debug("img", nn);
    }

    private static String Ci() {
        try {
            DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApp().getSystemService("wifi")).getDhcpInfo();
            return intToIp(dhcpInfo.dns1) + Constants.ACCEPT_TIME_SEPARATOR_SP + intToIp(dhcpInfo.dns2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String intToIp(int i) {
        return (i & 255) + com.baidu.ar.util.Constants.DOT + ((i >> 8) & 255) + com.baidu.ar.util.Constants.DOT + ((i >> 16) & 255) + com.baidu.ar.util.Constants.DOT + ((i >> 24) & 255);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [599=5] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long Cj() {
        HttpURLConnection httpURLConnection;
        long j;
        if (aVq >= 3) {
            return aVr;
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
            if (aVq > -1) {
                aVr = ((aVr * aVq) + j) / (aVq + 1);
            } else {
                aVr = j;
            }
            aVq++;
            return j;
        }
        return j;
    }

    private static String Ck() {
        return com.baidu.tbadk.imageManager.c.Mx().lN();
    }

    private static String Cl() {
        return com.baidu.adp.lib.asyncTask.a.lO().lN();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.a nn = nn();
        nn.append(SocialConstants.PARAM_ACT, "getCDNList");
        nn.append("errorNum", str);
        nn.append("errorMsg", str2);
        nn.append("isShortNetError", z2 ? "1" : "0");
        nn.append("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug("img", nn);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = t.Cq().ee(str);
        }
        String Ci = Ci();
        String ip = d.getIp();
        com.baidu.adp.lib.stats.a nn = nn();
        nn.append(SocialConstants.PARAM_ACT, "tachometerCDN");
        nn.append("errorNum", str3);
        nn.append("execption", str4);
        nn.append("size", str5);
        nn.append("isScuess", z ? "1" : "0");
        nn.append("url", str);
        nn.append("localIp", ip);
        nn.append("cdnIp", str6);
        nn.append("dnsIP", Ci);
        nn.append("usedIp", str2);
        nn.append("isUsedIp", z2 ? "0" : "1");
        nn.append("costTime", String.valueOf(j));
        BdStatisticsManager.getInstance().debug("img", nn);
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
                    com.baidu.adp.lib.stats.a nn = nn();
                    nn.append(SocialConstants.PARAM_ACT, "mobileTachometerCDN");
                    nn.append("costTime", String.valueOf(j));
                    nn.append("ipList", sb.toString());
                    BdStatisticsManager.getInstance().debug("img", nn);
                    return;
                }
            }
        }
    }

    public static void d(boolean z, String str) {
        com.baidu.adp.lib.stats.a nn = nn();
        nn.append(SocialConstants.PARAM_ACT, "getCDNList");
        nn.append("isSuccess", z ? "1" : "0");
        nn.append("errorMsg", str);
        BdStatisticsManager.getInstance().debug("img", nn);
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
