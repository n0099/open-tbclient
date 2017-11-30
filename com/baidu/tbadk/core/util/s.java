package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.xiaomi.mipush.sdk.Constants;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class s {
    private static long afB = 0;
    private static long afC = 0;
    private static int afD = 0;
    private static a afE = new a();
    private static r afF = new r();
    private static r afG = new r();
    private static String afH = null;
    private static Object syncLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int afI;
        boolean afJ;
        r afK;
        r afL;
        r afM;
        r afN;
        r afO;
        r afP;
        r afQ;
        r afR;
        r afS;
        r afT;
        r afU;
        r afV;
        r afW;
        r afX;
        r afY;

        private a() {
            this.afI = 0;
            this.afK = new r();
            this.afL = new r();
            this.afM = new r();
            this.afN = new r();
            this.afO = new r();
            this.afP = new r();
            this.afQ = new r();
            this.afR = new r();
            this.afS = new r();
            this.afT = new r();
            this.afU = new r();
            this.afV = new r();
            this.afW = new r();
            this.afX = new r();
            this.afY = new r();
        }

        public int uD() {
            return this.afK.num + this.afL.num + this.afM.num + this.afN.num + this.afO.num;
        }

        public int uE() {
            return this.afK.num + this.afL.num + this.afM.num + this.afN.num + this.afO.num + this.afP.num + this.afQ.num + this.afR.num + this.afS.num + this.afT.num + this.afU.num + this.afV.num + this.afW.num + this.afX.num + this.afY.num;
        }

        public int uF() {
            return this.afP.num + this.afQ.num + this.afR.num + this.afS.num + this.afT.num;
        }

        public int uG() {
            return this.afU.num + this.afV.num + this.afW.num + this.afX.num + this.afY.num;
        }

        public void reset() {
            this.afI = 0;
            this.afK.reset();
            this.afL.reset();
            this.afM.reset();
            this.afN.reset();
            this.afO.reset();
            this.afP.reset();
            this.afQ.reset();
            this.afR.reset();
            this.afS.reset();
            this.afT.reset();
            this.afU.reset();
            this.afV.reset();
            this.afW.reset();
            this.afX.reset();
            this.afY.reset();
        }
    }

    private static r a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return afE.afK;
            }
            if (str.startsWith("http://tb.himg")) {
                return afE.afL;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return afE.afM;
            }
            if (z2 && z3) {
                return afE.afO;
            }
            return afE.afN;
        } else if (com.baidu.adp.lib.util.j.hm()) {
            if (z2) {
                return afE.afP;
            }
            if (str.startsWith("http://tb.himg")) {
                return afE.afQ;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return afE.afR;
            }
            return afE.afS;
        } else if (z2) {
            return afE.afU;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return afE.afV;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return afE.afW;
            }
            return afE.afX;
        }
    }

    public static com.baidu.adp.lib.stats.a fK() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (syncLock) {
                afF.num++;
                afF.time += j;
                if (afF.num >= 100) {
                    uw();
                }
            }
        }
    }

    public static void uw() {
        if (afF.num > 10) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("act", "locStat");
            fK.p("costTime", String.valueOf(afF.time));
            fK.p("num", String.valueOf(afF.num));
            fK.p("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", fK);
            afF.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.l.hy() && dVar != null) {
            String str6 = "";
            boolean gO = com.baidu.tbadk.util.i.gO(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().aiz) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean hi = com.baidu.adp.lib.util.j.hi();
            if (!z5) {
                z4 = false;
            } else if (hi) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().SD);
            } else if (com.baidu.adp.lib.util.j.hm()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().SF);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().SE);
            }
            boolean z6 = false;
            if (gO && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (gO && hi && z6) {
                if (z) {
                    p.getInstance().insertNormalData(j, str);
                } else {
                    str6 = t.uH().uI();
                    if (!TextUtils.isEmpty(str6)) {
                        p.getInstance().insertErrorData(dVar.uZ, str);
                    }
                }
            }
            if (gO) {
                afH = str;
            }
            boolean z7 = false;
            if (dVar.vb != null && dVar.vb.length() > 0) {
                z7 = true;
            }
            synchronized (syncLock) {
                r a2 = a(hi, gO, str2, z7);
                boolean z8 = afE.afJ;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.uT += j2;
                        afE.afJ = true;
                        if (z4) {
                            a2.afA++;
                        }
                        afD = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.hh()) {
                            int i2 = afD + 1;
                            afD = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.gz().getMaxAlertCount("alert_img", 5)) {
                                BdStatisticsManager.getInstance().alert("alert_img", "imgFailedCnt_" + String.valueOf(afD) + "_url=" + str2);
                            }
                        }
                        a2.afz++;
                        afE.afJ = false;
                    }
                }
                int uE = afE.uE();
                if (uE > 100 || (uE > 0 && z8 != afE.afJ)) {
                    ux();
                }
            }
            if (z && z5) {
                if (!hi || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().SD) {
                    if (hi || !com.baidu.adp.lib.util.j.hm() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().SF) {
                        if (!hi && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().SE) {
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
                aVar = fK();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = t.uH().uI();
            }
            if (!gO || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = t.uH().dG(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = uz();
            }
            aVar.p("url", str);
            aVar.p("act", "dl");
            aVar.p("result", z ? "1" : "0");
            aVar.p("fullurl", str2);
            aVar.p("netlib", String.valueOf(dVar.vf));
            aVar.p("costTime", String.valueOf(j));
            aVar.p("connTime", String.valueOf(dVar.connectTime));
            aVar.p("rspTime", String.valueOf(dVar.uU));
            aVar.p("retry", String.valueOf(dVar.uV));
            aVar.p("localIp", d.getIp());
            aVar.p("tiebaIp", str6);
            aVar.p("cdnIp", str4);
            aVar.p("useIp", dVar.vb);
            aVar.p("dnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.p("connBaidu", String.valueOf(uA()));
            }
            aVar.p("memory", uB());
            aVar.p("task", uC());
            aVar.p("status", String.valueOf(dVar.va));
            aVar.p("up", String.valueOf(dVar.uS));
            aVar.p("down", String.valueOf(dVar.uT));
            aVar.p("isCDN", gO ? "1" : "0");
            aVar.p("isWebp", bool.booleanValue() ? "1" : "0");
            aVar.p("isMobileProxy", z3 ? "1" : "0");
            aVar.p("exception", dVar.uY);
            aVar.p("reason", str3);
            if (i != 0) {
                aVar.c("procType", Integer.valueOf(i));
            }
            if (dVar.vd != null) {
                aVar.p("tracecode1", dVar.vd);
            }
            if (dVar.ve != null) {
                aVar.p("tracecode2", dVar.ve);
            }
            BdStatisticsManager.getInstance().debug("img", aVar);
            if (gO && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                afE.afI++;
            }
        }
    }

    public static void ux() {
        if (afE.uE() > 10) {
            if (afE.uD() > 0) {
                a(afE.afK, afE.afL, afE.afM, afE.afO, afE.afN, 10000);
                com.baidu.tbadk.k.o.b(afE.afK, afE.afL, afE.afM, afE.afO, afE.afN, 3);
            }
            if (afE.uG() > 0) {
                a(afE.afU, afE.afV, afE.afW, afE.afY, afE.afX, 100002);
                com.baidu.tbadk.k.o.b(afE.afU, afE.afV, afE.afW, afE.afY, afE.afX, 2);
            }
            if (afE.uF() > 0) {
                a(afE.afP, afE.afQ, afE.afR, afE.afT, afE.afS, 100001);
                com.baidu.tbadk.k.o.b(afE.afP, afE.afQ, afE.afR, afE.afT, afE.afS, 1);
            }
            afE.reset();
        }
    }

    public static void a(r rVar, r rVar2, r rVar3, r rVar4, r rVar5, int i) {
        if (rVar != null && rVar2 != null && rVar3 != null && rVar4 != null && rVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = t.uH().uI();
            }
            if (afH != null && TextUtils.isEmpty("")) {
                str2 = t.uH().dG(afH);
            }
            if (TextUtils.isEmpty("")) {
                str3 = uz();
            }
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("act", "dlStat");
            fK.p("cdnCostTime", String.valueOf(rVar.time));
            fK.p("cdnNum", String.valueOf(rVar.num));
            fK.p("cdnFailnum", String.valueOf(rVar.afz));
            fK.p("portraitCostTime", String.valueOf(rVar2.time));
            fK.p("portraitNum", String.valueOf(rVar2.num));
            fK.p("portraitFailnum", String.valueOf(rVar2.afz));
            fK.p("tiebaCostTime", String.valueOf(rVar3.time));
            fK.p("tiebaNum", String.valueOf(rVar3.num));
            fK.p("tiebaFailnum", String.valueOf(rVar3.afz));
            fK.p("otherCostTime", String.valueOf(rVar5.time));
            fK.p("otherNum", String.valueOf(rVar5.num));
            fK.p("otherFailnum", String.valueOf(rVar5.afz));
            fK.p("directIpCostTime", String.valueOf(rVar4.time));
            fK.p("directIpNum", String.valueOf(rVar4.num));
            fK.p("directIpFailnum", String.valueOf(rVar4.afz));
            fK.p("dnsFailNum", String.valueOf(afE.afI));
            if (10000 == i) {
                fK.p("isWifi", "1");
                fK.p("netType", "WIFI");
            } else if (100002 == i) {
                fK.p("netType", "3G");
                fK.p("isWifi", "0");
            } else {
                fK.p("netType", "2G");
                fK.p("isWifi", "0");
            }
            fK.p("localIp", d.getIp());
            fK.p("tbIp", str);
            fK.p("cdnIp", str2);
            fK.p("dnsIp", str3);
            BdStatisticsManager.getInstance().debug("img", fK);
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.l.hy()) {
            synchronized (syncLock) {
                afG.num++;
                if (z) {
                    afG.time += j;
                } else {
                    afG.afz++;
                }
                if (afG.num >= 100) {
                    uy();
                }
            }
            if (!z) {
                if (aVar == null) {
                    aVar = fK();
                }
                aVar.p("act", "dc");
                aVar.p("costTime", String.valueOf(j));
                aVar.p("url", str);
                aVar.p("fullURL", str2);
                aVar.p("isWebp", z3 ? "1" : "0");
                aVar.p("isCDN", z2 ? "1" : "0");
                aVar.p("length", String.valueOf(i));
                aVar.p("reason", str3);
                aVar.p("result", z ? "0" : "1");
                aVar.p("execption", str4);
                BdStatisticsManager.getInstance().debug("img", aVar);
            }
        }
    }

    public static void uy() {
        if (afG.num > 10) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("act", "dcStat");
            fK.p("costTime", String.valueOf(afG.time));
            fK.p("num", String.valueOf(afG.num));
            fK.p("failnum", String.valueOf(afG.afz));
            BdStatisticsManager.getInstance().debug("img", fK);
            com.baidu.tbadk.k.o.a(afG.num, afG.afz, afG.time);
            afG.reset();
        }
    }

    public static void dF(String str) {
        com.baidu.adp.lib.stats.a fK = fK();
        fK.p("act", "assistant");
        fK.p("content", str);
        BdStatisticsManager.getInstance().debug("img", fK);
    }

    private static String uz() {
        try {
            DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApp().getSystemService("wifi")).getDhcpInfo();
            return intToIp(dhcpInfo.dns1) + Constants.ACCEPT_TIME_SEPARATOR_SP + intToIp(dhcpInfo.dns2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String intToIp(int i) {
        return (i & MotionEventCompat.ACTION_MASK) + "." + ((i >> 8) & MotionEventCompat.ACTION_MASK) + "." + ((i >> 16) & MotionEventCompat.ACTION_MASK) + "." + ((i >> 24) & MotionEventCompat.ACTION_MASK);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [599=5] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long uA() {
        HttpURLConnection httpURLConnection;
        long j;
        if (afB >= 3) {
            return afC;
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
            if (afB > -1) {
                afC = ((afC * afB) + j) / (afB + 1);
            } else {
                afC = j;
            }
            afB++;
            return j;
        }
        return j;
    }

    private static String uB() {
        return com.baidu.tbadk.imageManager.c.Ez().ei();
    }

    private static String uC() {
        return com.baidu.adp.lib.asyncTask.a.ej().ei();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.a fK = fK();
        fK.p("act", "getCDNList");
        fK.p("errorNum", str);
        fK.p("errorMsg", str2);
        fK.p("isShortNetError", z2 ? "1" : "0");
        fK.p("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug("img", fK);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = t.uH().dG(str);
        }
        String uz = uz();
        String ip = d.getIp();
        com.baidu.adp.lib.stats.a fK = fK();
        fK.p("act", "tachometerCDN");
        fK.p("errorNum", str3);
        fK.p("execption", str4);
        fK.p("size", str5);
        fK.p("isScuess", z ? "1" : "0");
        fK.p("url", str);
        fK.p("localIp", ip);
        fK.p("cdnIp", str6);
        fK.p("dnsIP", uz);
        fK.p("usedIp", str2);
        fK.p("isUsedIp", z2 ? "0" : "1");
        fK.p("costTime", String.valueOf(j));
        BdStatisticsManager.getInstance().debug("img", fK);
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
                    com.baidu.adp.lib.stats.a fK = fK();
                    fK.p("act", "mobileTachometerCDN");
                    fK.p("costTime", String.valueOf(j));
                    fK.p("ipList", sb.toString());
                    BdStatisticsManager.getInstance().debug("img", fK);
                    return;
                }
            }
        }
    }

    public static void d(boolean z, String str) {
        com.baidu.adp.lib.stats.a fK = fK();
        fK.p("act", "getCDNList");
        fK.p("isSuccess", z ? "1" : "0");
        fK.p("errorMsg", str);
        BdStatisticsManager.getInstance().debug("img", fK);
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
