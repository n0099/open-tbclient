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
public class w {
    private static long aeo = 0;
    private static long aep = 0;
    private static int aeq = 0;
    private static a aer = new a(null);
    private static v aes = new v();
    private static v aet = new v();
    private static String aeu = null;
    private static Object wB = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        v aeA;
        v aeB;
        v aeC;
        v aeD;
        v aeE;
        v aeF;
        v aeG;
        v aeH;
        v aeI;
        v aeJ;
        v aeK;
        v aeL;
        int aev;
        boolean aew;
        v aex;
        v aey;
        v aez;

        private a() {
            this.aev = 0;
            this.aex = new v();
            this.aey = new v();
            this.aez = new v();
            this.aeA = new v();
            this.aeB = new v();
            this.aeC = new v();
            this.aeD = new v();
            this.aeE = new v();
            this.aeF = new v();
            this.aeG = new v();
            this.aeH = new v();
            this.aeI = new v();
            this.aeJ = new v();
            this.aeK = new v();
            this.aeL = new v();
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [75=4] */
        public int uI() {
            return this.aex.num + this.aey.num + this.aez.num + this.aeA.num + this.aeB.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [81=14] */
        public int uJ() {
            return this.aex.num + this.aey.num + this.aez.num + this.aeA.num + this.aeB.num + this.aeC.num + this.aeD.num + this.aeE.num + this.aeF.num + this.aeG.num + this.aeH.num + this.aeI.num + this.aeJ.num + this.aeK.num + this.aeL.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [92=4] */
        public int uK() {
            return this.aeC.num + this.aeD.num + this.aeE.num + this.aeF.num + this.aeG.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [98=4] */
        public int uL() {
            return this.aeH.num + this.aeI.num + this.aeJ.num + this.aeK.num + this.aeL.num;
        }

        public void reset() {
            this.aev = 0;
            this.aex.reset();
            this.aey.reset();
            this.aez.reset();
            this.aeA.reset();
            this.aeB.reset();
            this.aeC.reset();
            this.aeD.reset();
            this.aeE.reset();
            this.aeF.reset();
            this.aeG.reset();
            this.aeH.reset();
            this.aeI.reset();
            this.aeJ.reset();
            this.aeK.reset();
            this.aeL.reset();
        }
    }

    private static v a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return aer.aex;
            }
            if (str.startsWith("http://tb.himg")) {
                return aer.aey;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aer.aez;
            }
            if (z2 && z3) {
                return aer.aeB;
            }
            return aer.aeA;
        } else if (com.baidu.adp.lib.util.i.ho()) {
            if (z2) {
                return aer.aeC;
            }
            if (str.startsWith("http://tb.himg")) {
                return aer.aeD;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aer.aeE;
            }
            return aer.aeF;
        } else if (z2) {
            return aer.aeH;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return aer.aeI;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aer.aeJ;
            }
            return aer.aeK;
        }
    }

    public static com.baidu.adp.lib.stats.c fM() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.c cVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (wB) {
                aes.num++;
                aes.time += j;
                if (aes.num >= 100) {
                    uB();
                }
            }
        }
    }

    public static void uB() {
        if (aes.num > 10) {
            com.baidu.adp.lib.stats.c fM = fM();
            fM.p("act", "locStat");
            fM.p("costTime", String.valueOf(aes.time));
            fM.p("num", String.valueOf(aes.num));
            fM.p("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", fM);
            aes.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.c cVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.e eVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.k.hA() && eVar != null) {
            String str6 = "";
            boolean gx = com.baidu.tbadk.util.i.gx(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().ahf) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean hk = com.baidu.adp.lib.util.i.hk();
            if (!z5) {
                z4 = false;
            } else if (hk) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().QN);
            } else if (com.baidu.adp.lib.util.i.ho()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().QP);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().QO);
            }
            boolean z6 = false;
            if (gx && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (gx && hk && z6) {
                if (z) {
                    t.getInstance().insertNormalData(j, str);
                } else {
                    str6 = x.uM().uN();
                    if (!TextUtils.isEmpty(str6)) {
                        t.getInstance().insertErrorData(eVar.vA, str);
                    }
                }
            }
            if (gx) {
                aeu = str;
            }
            boolean z7 = false;
            if (eVar.vC != null && eVar.vC.length() > 0) {
                z7 = true;
            }
            synchronized (wB) {
                v a2 = a(hk, gx, str2, z7);
                boolean z8 = aer.aew;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.vu += j2;
                        aer.aew = true;
                        if (z4) {
                            a2.aen++;
                        }
                        aeq = 0;
                    } else {
                        if (com.baidu.adp.lib.util.i.hj()) {
                            int i2 = aeq + 1;
                            aeq = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.gB().getMaxAlertCount("alert_img", 5)) {
                                BdStatisticsManager.getInstance().alert("alert_img", "imgFailedCnt_" + String.valueOf(aeq) + "_url=" + str2);
                            }
                        }
                        a2.aem++;
                        aer.aew = false;
                    }
                }
                int uJ = aer.uJ();
                if (uJ > 100 || (uJ > 0 && z8 != aer.aew)) {
                    uC();
                }
            }
            if (z && z5) {
                if (!hk || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().QN) {
                    if (hk || !com.baidu.adp.lib.util.i.ho() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().QP) {
                        if (!hk && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().QO) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (cVar == null) {
                cVar = fM();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = x.uM().uN();
            }
            if (!gx || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = x.uM().dE(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = uE();
            }
            cVar.p("url", str);
            cVar.p("act", "dl");
            cVar.p("result", z ? "1" : "0");
            cVar.p("fullurl", str2);
            cVar.p("netlib", String.valueOf(eVar.vG));
            cVar.p("costTime", String.valueOf(j));
            cVar.p("connTime", String.valueOf(eVar.connectTime));
            cVar.p("rspTime", String.valueOf(eVar.vv));
            cVar.p("retry", String.valueOf(eVar.vw));
            cVar.p("localIp", d.getIp());
            cVar.p("tiebaIp", str6);
            cVar.p("cdnIp", str4);
            cVar.p("useIp", eVar.vC);
            cVar.p("dnsIp", str5);
            if (eVar.connectTime > 1500 || eVar.connectTime < 0) {
                cVar.p("connBaidu", String.valueOf(uF()));
            }
            cVar.p("memory", uG());
            cVar.p("task", uH());
            cVar.p("status", String.valueOf(eVar.vB));
            cVar.p("up", String.valueOf(eVar.vt));
            cVar.p("down", String.valueOf(eVar.vu));
            cVar.p("isCDN", gx ? "1" : "0");
            cVar.p("isWebp", bool.booleanValue() ? "1" : "0");
            cVar.p("isMobileProxy", z3 ? "1" : "0");
            cVar.p("exception", eVar.vz);
            cVar.p("reason", str3);
            if (i != 0) {
                cVar.d("procType", Integer.valueOf(i));
            }
            if (eVar.vE != null) {
                cVar.p("tracecode1", eVar.vE);
            }
            if (eVar.vF != null) {
                cVar.p("tracecode2", eVar.vF);
            }
            BdStatisticsManager.getInstance().debug("img", cVar);
            if (gx && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                aer.aev++;
            }
        }
    }

    public static void uC() {
        if (aer.uJ() > 10) {
            if (aer.uI() > 0) {
                a(aer.aex, aer.aey, aer.aez, aer.aeB, aer.aeA, 10000);
                com.baidu.tbadk.j.x.b(aer.aex, aer.aey, aer.aez, aer.aeB, aer.aeA, 3);
            }
            if (aer.uL() > 0) {
                a(aer.aeH, aer.aeI, aer.aeJ, aer.aeL, aer.aeK, 100002);
                com.baidu.tbadk.j.x.b(aer.aeH, aer.aeI, aer.aeJ, aer.aeL, aer.aeK, 2);
            }
            if (aer.uK() > 0) {
                a(aer.aeC, aer.aeD, aer.aeE, aer.aeG, aer.aeF, 100001);
                com.baidu.tbadk.j.x.b(aer.aeC, aer.aeD, aer.aeE, aer.aeG, aer.aeF, 1);
            }
            aer.reset();
        }
    }

    public static void a(v vVar, v vVar2, v vVar3, v vVar4, v vVar5, int i) {
        if (vVar != null && vVar2 != null && vVar3 != null && vVar4 != null && vVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = x.uM().uN();
            }
            if (aeu != null && TextUtils.isEmpty("")) {
                str2 = x.uM().dE(aeu);
            }
            if (TextUtils.isEmpty("")) {
                str3 = uE();
            }
            com.baidu.adp.lib.stats.c fM = fM();
            fM.p("act", "dlStat");
            fM.p("cdnCostTime", String.valueOf(vVar.time));
            fM.p("cdnNum", String.valueOf(vVar.num));
            fM.p("cdnFailnum", String.valueOf(vVar.aem));
            fM.p("portraitCostTime", String.valueOf(vVar2.time));
            fM.p("portraitNum", String.valueOf(vVar2.num));
            fM.p("portraitFailnum", String.valueOf(vVar2.aem));
            fM.p("tiebaCostTime", String.valueOf(vVar3.time));
            fM.p("tiebaNum", String.valueOf(vVar3.num));
            fM.p("tiebaFailnum", String.valueOf(vVar3.aem));
            fM.p("otherCostTime", String.valueOf(vVar5.time));
            fM.p("otherNum", String.valueOf(vVar5.num));
            fM.p("otherFailnum", String.valueOf(vVar5.aem));
            fM.p("directIpCostTime", String.valueOf(vVar4.time));
            fM.p("directIpNum", String.valueOf(vVar4.num));
            fM.p("directIpFailnum", String.valueOf(vVar4.aem));
            fM.p("dnsFailNum", String.valueOf(aer.aev));
            if (10000 == i) {
                fM.p("isWifi", "1");
                fM.p("netType", "WIFI");
            } else if (100002 == i) {
                fM.p("netType", "3G");
                fM.p("isWifi", "0");
            } else {
                fM.p("netType", "2G");
                fM.p("isWifi", "0");
            }
            fM.p("localIp", d.getIp());
            fM.p("tbIp", str);
            fM.p("cdnIp", str2);
            fM.p("dnsIp", str3);
            BdStatisticsManager.getInstance().debug("img", fM);
        }
    }

    public static void a(com.baidu.adp.lib.stats.c cVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.k.hA()) {
            synchronized (wB) {
                aet.num++;
                if (z) {
                    aet.time += j;
                } else {
                    aet.aem++;
                }
                if (aet.num >= 100) {
                    uD();
                }
            }
            if (!z) {
                if (cVar == null) {
                    cVar = fM();
                }
                cVar.p("act", "dc");
                cVar.p("costTime", String.valueOf(j));
                cVar.p("url", str);
                cVar.p("fullURL", str2);
                cVar.p("isWebp", z3 ? "1" : "0");
                cVar.p("isCDN", z2 ? "1" : "0");
                cVar.p("length", String.valueOf(i));
                cVar.p("reason", str3);
                cVar.p("result", z ? "0" : "1");
                cVar.p("execption", str4);
                BdStatisticsManager.getInstance().debug("img", cVar);
            }
        }
    }

    public static void uD() {
        if (aet.num > 10) {
            com.baidu.adp.lib.stats.c fM = fM();
            fM.p("act", "dcStat");
            fM.p("costTime", String.valueOf(aet.time));
            fM.p("num", String.valueOf(aet.num));
            fM.p("failnum", String.valueOf(aet.aem));
            BdStatisticsManager.getInstance().debug("img", fM);
            com.baidu.tbadk.j.x.a(aet.num, aet.aem, aet.time);
            aet.reset();
        }
    }

    public static void dD(String str) {
        com.baidu.adp.lib.stats.c fM = fM();
        fM.p("act", "assistant");
        fM.p("content", str);
        BdStatisticsManager.getInstance().debug("img", fM);
    }

    private static String uE() {
        try {
            DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApp().getSystemService("wifi")).getDhcpInfo();
            return String.valueOf(intToIp(dhcpInfo.dns1)) + Constants.ACCEPT_TIME_SEPARATOR_SP + intToIp(dhcpInfo.dns2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String intToIp(int i) {
        return String.valueOf(i & MotionEventCompat.ACTION_MASK) + "." + ((i >> 8) & MotionEventCompat.ACTION_MASK) + "." + ((i >> 16) & MotionEventCompat.ACTION_MASK) + "." + ((i >> 24) & MotionEventCompat.ACTION_MASK);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [599=4] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long uF() {
        HttpURLConnection httpURLConnection;
        long j;
        if (aeo >= 3) {
            return aep;
        }
        long currentTimeMillis = System.currentTimeMillis();
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(TbDomainConfig.DOMAIN_HTTPS_BAIDU).openConnection();
            try {
                httpURLConnection.setConnectTimeout(TbConfig.NOTIFY_YUN_PUSH);
                httpURLConnection.connect();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.g.a.g(httpURLConnection);
                j = currentTimeMillis2;
            } catch (SocketTimeoutException e) {
                com.baidu.adp.lib.g.a.g(httpURLConnection);
                j = 2500;
                if (j > 0) {
                }
            } catch (Exception e2) {
                httpURLConnection2 = httpURLConnection;
                com.baidu.adp.lib.g.a.g(httpURLConnection2);
                j = -1;
                if (j > 0) {
                }
            } catch (Throwable th) {
                httpURLConnection2 = httpURLConnection;
                th = th;
                com.baidu.adp.lib.g.a.g(httpURLConnection2);
                throw th;
            }
        } catch (SocketTimeoutException e3) {
            httpURLConnection = null;
        } catch (Exception e4) {
        } catch (Throwable th2) {
            th = th2;
        }
        if (j > 0) {
            if (aeo > -1) {
                aep = ((aep * aeo) + j) / (aeo + 1);
            } else {
                aep = j;
            }
            aeo++;
            return j;
        }
        return j;
    }

    private static String uG() {
        return com.baidu.tbadk.imageManager.c.Eb().el();
    }

    private static String uH() {
        return com.baidu.adp.lib.asyncTask.c.em().el();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.c fM = fM();
        fM.p("act", "getCDNList");
        fM.p("errorNum", str);
        fM.p("errorMsg", str2);
        fM.p("isShortNetError", z2 ? "1" : "0");
        fM.p("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug("img", fM);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = x.uM().dE(str);
        }
        String uE = uE();
        String ip = d.getIp();
        com.baidu.adp.lib.stats.c fM = fM();
        fM.p("act", "tachometerCDN");
        fM.p("errorNum", str3);
        fM.p("execption", str4);
        fM.p("size", str5);
        fM.p("isScuess", z ? "1" : "0");
        fM.p("url", str);
        fM.p("localIp", ip);
        fM.p("cdnIp", str6);
        fM.p("dnsIP", uE);
        fM.p("usedIp", str2);
        fM.p("isUsedIp", z2 ? "0" : "1");
        fM.p("costTime", String.valueOf(j));
        BdStatisticsManager.getInstance().debug("img", fM);
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
                    com.baidu.adp.lib.stats.c fM = fM();
                    fM.p("act", "mobileTachometerCDN");
                    fM.p("costTime", String.valueOf(j));
                    fM.p("ipList", sb.toString());
                    BdStatisticsManager.getInstance().debug("img", fM);
                    return;
                }
            }
        }
    }

    public static void c(boolean z, String str) {
        com.baidu.adp.lib.stats.c fM = fM();
        fM.p("act", "getCDNList");
        fM.p("isSuccess", z ? "1" : "0");
        fM.p("errorMsg", str);
        BdStatisticsManager.getInstance().debug("img", fM);
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
