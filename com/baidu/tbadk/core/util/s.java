package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.sapi2.callback.AccountCenterCallback;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.xiaomi.mipush.sdk.Constants;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class s {
    private static long afv = 0;
    private static long afw = 0;
    private static int afx = 0;
    private static a afy = new a();
    private static r afz = new r();
    private static r afA = new r();
    private static String afB = null;
    private static Object syncLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int afC;
        boolean afD;
        r afE;
        r afF;
        r afG;
        r afH;
        r afI;
        r afJ;
        r afK;
        r afL;
        r afM;
        r afN;
        r afO;
        r afP;
        r afQ;
        r afR;
        r afS;

        private a() {
            this.afC = 0;
            this.afE = new r();
            this.afF = new r();
            this.afG = new r();
            this.afH = new r();
            this.afI = new r();
            this.afJ = new r();
            this.afK = new r();
            this.afL = new r();
            this.afM = new r();
            this.afN = new r();
            this.afO = new r();
            this.afP = new r();
            this.afQ = new r();
            this.afR = new r();
            this.afS = new r();
        }

        public int uA() {
            return this.afE.num + this.afF.num + this.afG.num + this.afH.num + this.afI.num;
        }

        public int uB() {
            return this.afE.num + this.afF.num + this.afG.num + this.afH.num + this.afI.num + this.afJ.num + this.afK.num + this.afL.num + this.afM.num + this.afN.num + this.afO.num + this.afP.num + this.afQ.num + this.afR.num + this.afS.num;
        }

        public int uC() {
            return this.afJ.num + this.afK.num + this.afL.num + this.afM.num + this.afN.num;
        }

        public int uD() {
            return this.afO.num + this.afP.num + this.afQ.num + this.afR.num + this.afS.num;
        }

        public void reset() {
            this.afC = 0;
            this.afE.reset();
            this.afF.reset();
            this.afG.reset();
            this.afH.reset();
            this.afI.reset();
            this.afJ.reset();
            this.afK.reset();
            this.afL.reset();
            this.afM.reset();
            this.afN.reset();
            this.afO.reset();
            this.afP.reset();
            this.afQ.reset();
            this.afR.reset();
            this.afS.reset();
        }
    }

    private static r a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return afy.afE;
            }
            if (str.startsWith("http://tb.himg")) {
                return afy.afF;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return afy.afG;
            }
            if (z2 && z3) {
                return afy.afI;
            }
            return afy.afH;
        } else if (com.baidu.adp.lib.util.j.hm()) {
            if (z2) {
                return afy.afJ;
            }
            if (str.startsWith("http://tb.himg")) {
                return afy.afK;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return afy.afL;
            }
            return afy.afM;
        } else if (z2) {
            return afy.afO;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return afy.afP;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return afy.afQ;
            }
            return afy.afR;
        }
    }

    public static com.baidu.adp.lib.stats.a fK() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (syncLock) {
                afz.num++;
                afz.time += j;
                if (afz.num >= 100) {
                    ut();
                }
            }
        }
    }

    public static void ut() {
        if (afz.num > 10) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("act", "locStat");
            fK.p("costTime", String.valueOf(afz.time));
            fK.p("num", String.valueOf(afz.num));
            fK.p("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", fK);
            afz.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.l.hy() && dVar != null) {
            String str6 = "";
            boolean gN = com.baidu.tbadk.util.i.gN(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().ait) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean hi = com.baidu.adp.lib.util.j.hi();
            if (!z5) {
                z4 = false;
            } else if (hi) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().SA);
            } else if (com.baidu.adp.lib.util.j.hm()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().SC);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().SB);
            }
            boolean z6 = false;
            if (gN && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (gN && hi && z6) {
                if (z) {
                    p.getInstance().insertNormalData(j, str);
                } else {
                    str6 = t.uE().uF();
                    if (!TextUtils.isEmpty(str6)) {
                        p.getInstance().insertErrorData(dVar.uW, str);
                    }
                }
            }
            if (gN) {
                afB = str;
            }
            boolean z7 = false;
            if (dVar.uY != null && dVar.uY.length() > 0) {
                z7 = true;
            }
            synchronized (syncLock) {
                r a2 = a(hi, gN, str2, z7);
                boolean z8 = afy.afD;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.uQ += j2;
                        afy.afD = true;
                        if (z4) {
                            a2.afu++;
                        }
                        afx = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.hh()) {
                            int i2 = afx + 1;
                            afx = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.gz().getMaxAlertCount("alert_img", 5)) {
                                BdStatisticsManager.getInstance().alert("alert_img", "imgFailedCnt_" + String.valueOf(afx) + "_url=" + str2);
                            }
                        }
                        a2.aft++;
                        afy.afD = false;
                    }
                }
                int uB = afy.uB();
                if (uB > 100 || (uB > 0 && z8 != afy.afD)) {
                    uu();
                }
            }
            if (z && z5) {
                if (!hi || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().SA) {
                    if (hi || !com.baidu.adp.lib.util.j.hm() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().SC) {
                        if (!hi && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().SB) {
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
                str6 = t.uE().uF();
            }
            if (!gN || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = t.uE().dG(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = uw();
            }
            aVar.p("url", str);
            aVar.p("act", "dl");
            aVar.p("result", z ? "1" : "0");
            aVar.p("fullurl", str2);
            aVar.p("netlib", String.valueOf(dVar.vc));
            aVar.p("costTime", String.valueOf(j));
            aVar.p("connTime", String.valueOf(dVar.connectTime));
            aVar.p("rspTime", String.valueOf(dVar.uR));
            aVar.p("retry", String.valueOf(dVar.uS));
            aVar.p("localIp", d.getIp());
            aVar.p("tiebaIp", str6);
            aVar.p("cdnIp", str4);
            aVar.p("useIp", dVar.uY);
            aVar.p("dnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.p("connBaidu", String.valueOf(ux()));
            }
            aVar.p("memory", uy());
            aVar.p("task", uz());
            aVar.p("status", String.valueOf(dVar.uX));
            aVar.p("up", String.valueOf(dVar.uP));
            aVar.p("down", String.valueOf(dVar.uQ));
            aVar.p("isCDN", gN ? "1" : "0");
            aVar.p("isWebp", bool.booleanValue() ? "1" : "0");
            aVar.p("isMobileProxy", z3 ? "1" : "0");
            aVar.p("exception", dVar.uV);
            aVar.p("reason", str3);
            if (i != 0) {
                aVar.c("procType", Integer.valueOf(i));
            }
            if (dVar.va != null) {
                aVar.p("tracecode1", dVar.va);
            }
            if (dVar.vb != null) {
                aVar.p("tracecode2", dVar.vb);
            }
            BdStatisticsManager.getInstance().debug("img", aVar);
            if (gN && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                afy.afC++;
            }
        }
    }

    public static void uu() {
        if (afy.uB() > 10) {
            if (afy.uA() > 0) {
                a(afy.afE, afy.afF, afy.afG, afy.afI, afy.afH, 10000);
                com.baidu.tbadk.k.o.b(afy.afE, afy.afF, afy.afG, afy.afI, afy.afH, 3);
            }
            if (afy.uD() > 0) {
                a(afy.afO, afy.afP, afy.afQ, afy.afS, afy.afR, 100002);
                com.baidu.tbadk.k.o.b(afy.afO, afy.afP, afy.afQ, afy.afS, afy.afR, 2);
            }
            if (afy.uC() > 0) {
                a(afy.afJ, afy.afK, afy.afL, afy.afN, afy.afM, AccountCenterCallback.REQUEST_CODE_LOGIN);
                com.baidu.tbadk.k.o.b(afy.afJ, afy.afK, afy.afL, afy.afN, afy.afM, 1);
            }
            afy.reset();
        }
    }

    public static void a(r rVar, r rVar2, r rVar3, r rVar4, r rVar5, int i) {
        if (rVar != null && rVar2 != null && rVar3 != null && rVar4 != null && rVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = t.uE().uF();
            }
            if (afB != null && TextUtils.isEmpty("")) {
                str2 = t.uE().dG(afB);
            }
            if (TextUtils.isEmpty("")) {
                str3 = uw();
            }
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("act", "dlStat");
            fK.p("cdnCostTime", String.valueOf(rVar.time));
            fK.p("cdnNum", String.valueOf(rVar.num));
            fK.p("cdnFailnum", String.valueOf(rVar.aft));
            fK.p("portraitCostTime", String.valueOf(rVar2.time));
            fK.p("portraitNum", String.valueOf(rVar2.num));
            fK.p("portraitFailnum", String.valueOf(rVar2.aft));
            fK.p("tiebaCostTime", String.valueOf(rVar3.time));
            fK.p("tiebaNum", String.valueOf(rVar3.num));
            fK.p("tiebaFailnum", String.valueOf(rVar3.aft));
            fK.p("otherCostTime", String.valueOf(rVar5.time));
            fK.p("otherNum", String.valueOf(rVar5.num));
            fK.p("otherFailnum", String.valueOf(rVar5.aft));
            fK.p("directIpCostTime", String.valueOf(rVar4.time));
            fK.p("directIpNum", String.valueOf(rVar4.num));
            fK.p("directIpFailnum", String.valueOf(rVar4.aft));
            fK.p("dnsFailNum", String.valueOf(afy.afC));
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
                afA.num++;
                if (z) {
                    afA.time += j;
                } else {
                    afA.aft++;
                }
                if (afA.num >= 100) {
                    uv();
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

    public static void uv() {
        if (afA.num > 10) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("act", "dcStat");
            fK.p("costTime", String.valueOf(afA.time));
            fK.p("num", String.valueOf(afA.num));
            fK.p("failnum", String.valueOf(afA.aft));
            BdStatisticsManager.getInstance().debug("img", fK);
            com.baidu.tbadk.k.o.a(afA.num, afA.aft, afA.time);
            afA.reset();
        }
    }

    public static void dF(String str) {
        com.baidu.adp.lib.stats.a fK = fK();
        fK.p("act", "assistant");
        fK.p("content", str);
        BdStatisticsManager.getInstance().debug("img", fK);
    }

    private static String uw() {
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
    private static long ux() {
        HttpURLConnection httpURLConnection;
        long j;
        if (afv >= 3) {
            return afw;
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
            if (afv > -1) {
                afw = ((afw * afv) + j) / (afv + 1);
            } else {
                afw = j;
            }
            afv++;
            return j;
        }
        return j;
    }

    private static String uy() {
        return com.baidu.tbadk.imageManager.c.EA().ei();
    }

    private static String uz() {
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
            str6 = t.uE().dG(str);
        }
        String uw = uw();
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
        fK.p("dnsIP", uw);
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
