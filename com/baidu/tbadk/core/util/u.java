package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class u {
    private static long aeg = 0;
    private static long aeh = 0;
    private static int aei = 0;
    private static a aej = new a(null);
    private static t aek = new t();
    private static t ael = new t();
    private static String aem = null;
    private static Object wT = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        t aeA;
        t aeB;
        t aeC;
        t aeD;
        int aen;
        boolean aeo;
        t aep;
        t aeq;
        t aer;
        t aes;
        t aet;
        t aeu;
        t aev;
        t aew;
        t aex;
        t aey;
        t aez;

        private a() {
            this.aen = 0;
            this.aep = new t();
            this.aeq = new t();
            this.aer = new t();
            this.aes = new t();
            this.aet = new t();
            this.aeu = new t();
            this.aev = new t();
            this.aew = new t();
            this.aex = new t();
            this.aey = new t();
            this.aez = new t();
            this.aeA = new t();
            this.aeB = new t();
            this.aeC = new t();
            this.aeD = new t();
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [75=4] */
        public int uM() {
            return this.aep.num + this.aeq.num + this.aer.num + this.aes.num + this.aet.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [81=14] */
        public int uN() {
            return this.aep.num + this.aeq.num + this.aer.num + this.aes.num + this.aet.num + this.aeu.num + this.aev.num + this.aew.num + this.aex.num + this.aey.num + this.aez.num + this.aeA.num + this.aeB.num + this.aeC.num + this.aeD.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [92=4] */
        public int uO() {
            return this.aeu.num + this.aev.num + this.aew.num + this.aex.num + this.aey.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [98=4] */
        public int uP() {
            return this.aez.num + this.aeA.num + this.aeB.num + this.aeC.num + this.aeD.num;
        }

        public void reset() {
            this.aen = 0;
            this.aep.reset();
            this.aeq.reset();
            this.aer.reset();
            this.aes.reset();
            this.aet.reset();
            this.aeu.reset();
            this.aev.reset();
            this.aew.reset();
            this.aex.reset();
            this.aey.reset();
            this.aez.reset();
            this.aeA.reset();
            this.aeB.reset();
            this.aeC.reset();
            this.aeD.reset();
        }
    }

    private static t a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return aej.aep;
            }
            if (str.startsWith("http://tb.himg")) {
                return aej.aeq;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aej.aer;
            }
            if (z2 && z3) {
                return aej.aet;
            }
            return aej.aes;
        } else if (com.baidu.adp.lib.util.i.hj()) {
            if (z2) {
                return aej.aeu;
            }
            if (str.startsWith("http://tb.himg")) {
                return aej.aev;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aej.aew;
            }
            return aej.aex;
        } else if (z2) {
            return aej.aez;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return aej.aeA;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aej.aeB;
            }
            return aej.aeC;
        }
    }

    public static com.baidu.adp.lib.stats.c fH() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.c cVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (wT) {
                aek.num++;
                aek.time += j;
                if (aek.num >= 100) {
                    uF();
                }
            }
        }
    }

    public static void uF() {
        if (aek.num > 10) {
            com.baidu.adp.lib.stats.c fH = fH();
            fH.p("act", "locStat");
            fH.p("costTime", String.valueOf(aek.time));
            fH.p("num", String.valueOf(aek.num));
            fH.p("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", fH);
            aek.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.c cVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.e eVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.k.hv() && eVar != null) {
            String str6 = "";
            boolean fZ = com.baidu.tbadk.util.g.fZ(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().agZ) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean hf = com.baidu.adp.lib.util.i.hf();
            if (!z5) {
                z4 = false;
            } else if (hf) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Rv);
            } else if (com.baidu.adp.lib.util.i.hj()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Rx);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Rw);
            }
            boolean z6 = false;
            if (fZ && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (fZ && hf && z6) {
                if (z) {
                    r.getInstance().insertNormalData(j, str);
                } else {
                    str6 = v.uQ().uR();
                    if (!TextUtils.isEmpty(str6)) {
                        r.getInstance().insertErrorData(eVar.vT, str);
                    }
                }
            }
            if (fZ) {
                aem = str;
            }
            boolean z7 = false;
            if (eVar.vV != null && eVar.vV.length() > 0) {
                z7 = true;
            }
            synchronized (wT) {
                t a2 = a(hf, fZ, str2, z7);
                boolean z8 = aej.aeo;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.vM += j2;
                        aej.aeo = true;
                        if (z4) {
                            a2.aef++;
                        }
                        aei = 0;
                    } else {
                        if (com.baidu.adp.lib.util.i.he()) {
                            int i2 = aei + 1;
                            aei = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.gw().getMaxAlertCount("alert_img", 5)) {
                                BdStatisticsManager.getInstance().alert("alert_img", "imgFailedCnt_" + String.valueOf(aei) + "_url=" + str2);
                            }
                        }
                        a2.aee++;
                        aej.aeo = false;
                    }
                }
                int uN = aej.uN();
                if (uN > 100 || (uN > 0 && z8 != aej.aeo)) {
                    uG();
                }
            }
            if (z && z5) {
                if (!hf || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Rv) {
                    if (hf || !com.baidu.adp.lib.util.i.hj() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Rx) {
                        if (!hf && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Rw) {
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
                cVar = fH();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = v.uQ().uR();
            }
            if (!fZ || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = v.uQ().di(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = uI();
            }
            cVar.p("url", str);
            cVar.p("act", "dl");
            cVar.p("result", z ? "1" : "0");
            cVar.p("fullurl", str2);
            cVar.p("netlib", String.valueOf(eVar.vZ));
            cVar.p("costTime", String.valueOf(j));
            cVar.p("connTime", String.valueOf(eVar.vN));
            cVar.p("rspTime", String.valueOf(eVar.vO));
            cVar.p("retry", String.valueOf(eVar.vP));
            cVar.p("localIp", d.getIp());
            cVar.p("tiebaIp", str6);
            cVar.p("cdnIp", str4);
            cVar.p("useIp", eVar.vV);
            cVar.p("dnsIp", str5);
            if (eVar.vN > 1500 || eVar.vN < 0) {
                cVar.p("connBaidu", String.valueOf(uJ()));
            }
            cVar.p("memory", uK());
            cVar.p("task", uL());
            cVar.p("status", String.valueOf(eVar.vU));
            cVar.p("up", String.valueOf(eVar.vL));
            cVar.p("down", String.valueOf(eVar.vM));
            cVar.p("isCDN", fZ ? "1" : "0");
            cVar.p("isWebp", bool.booleanValue() ? "1" : "0");
            cVar.p("isMobileProxy", z3 ? "1" : "0");
            cVar.p("exception", eVar.vS);
            cVar.p("reason", str3);
            if (i != 0) {
                cVar.d("procType", Integer.valueOf(i));
            }
            if (eVar.vX != null) {
                cVar.p("tracecode1", eVar.vX);
            }
            if (eVar.vY != null) {
                cVar.p("tracecode2", eVar.vY);
            }
            BdStatisticsManager.getInstance().debug("img", cVar);
            if (fZ && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                aej.aen++;
            }
        }
    }

    public static void uG() {
        if (aej.uN() > 10) {
            if (aej.uM() > 0) {
                a(aej.aep, aej.aeq, aej.aer, aej.aet, aej.aes, 10000);
                com.baidu.tbadk.performanceLog.x.b(aej.aep, aej.aeq, aej.aer, aej.aet, aej.aes, 3);
            }
            if (aej.uP() > 0) {
                a(aej.aez, aej.aeA, aej.aeB, aej.aeD, aej.aeC, 100002);
                com.baidu.tbadk.performanceLog.x.b(aej.aez, aej.aeA, aej.aeB, aej.aeD, aej.aeC, 2);
            }
            if (aej.uO() > 0) {
                a(aej.aeu, aej.aev, aej.aew, aej.aey, aej.aex, 100001);
                com.baidu.tbadk.performanceLog.x.b(aej.aeu, aej.aev, aej.aew, aej.aey, aej.aex, 1);
            }
            aej.reset();
        }
    }

    public static void a(t tVar, t tVar2, t tVar3, t tVar4, t tVar5, int i) {
        if (tVar != null && tVar2 != null && tVar3 != null && tVar4 != null && tVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = v.uQ().uR();
            }
            if (aem != null && TextUtils.isEmpty("")) {
                str2 = v.uQ().di(aem);
            }
            if (TextUtils.isEmpty("")) {
                str3 = uI();
            }
            com.baidu.adp.lib.stats.c fH = fH();
            fH.p("act", "dlStat");
            fH.p("cdnCostTime", String.valueOf(tVar.time));
            fH.p("cdnNum", String.valueOf(tVar.num));
            fH.p("cdnFailnum", String.valueOf(tVar.aee));
            fH.p("portraitCostTime", String.valueOf(tVar2.time));
            fH.p("portraitNum", String.valueOf(tVar2.num));
            fH.p("portraitFailnum", String.valueOf(tVar2.aee));
            fH.p("tiebaCostTime", String.valueOf(tVar3.time));
            fH.p("tiebaNum", String.valueOf(tVar3.num));
            fH.p("tiebaFailnum", String.valueOf(tVar3.aee));
            fH.p("otherCostTime", String.valueOf(tVar5.time));
            fH.p("otherNum", String.valueOf(tVar5.num));
            fH.p("otherFailnum", String.valueOf(tVar5.aee));
            fH.p("directIpCostTime", String.valueOf(tVar4.time));
            fH.p("directIpNum", String.valueOf(tVar4.num));
            fH.p("directIpFailnum", String.valueOf(tVar4.aee));
            fH.p("dnsFailNum", String.valueOf(aej.aen));
            if (10000 == i) {
                fH.p("isWifi", "1");
                fH.p("netType", "WIFI");
            } else if (100002 == i) {
                fH.p("netType", "3G");
                fH.p("isWifi", "0");
            } else {
                fH.p("netType", "2G");
                fH.p("isWifi", "0");
            }
            fH.p("localIp", d.getIp());
            fH.p("tbIp", str);
            fH.p("cdnIp", str2);
            fH.p("dnsIp", str3);
            BdStatisticsManager.getInstance().debug("img", fH);
        }
    }

    public static void a(com.baidu.adp.lib.stats.c cVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.k.hv()) {
            synchronized (wT) {
                ael.num++;
                if (z) {
                    ael.time += j;
                } else {
                    ael.aee++;
                }
                if (ael.num >= 100) {
                    uH();
                }
            }
            if (!z) {
                if (cVar == null) {
                    cVar = fH();
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

    public static void uH() {
        if (ael.num > 10) {
            com.baidu.adp.lib.stats.c fH = fH();
            fH.p("act", "dcStat");
            fH.p("costTime", String.valueOf(ael.time));
            fH.p("num", String.valueOf(ael.num));
            fH.p("failnum", String.valueOf(ael.aee));
            BdStatisticsManager.getInstance().debug("img", fH);
            com.baidu.tbadk.performanceLog.x.a(ael.num, ael.aee, ael.time);
            ael.reset();
        }
    }

    public static void dh(String str) {
        com.baidu.adp.lib.stats.c fH = fH();
        fH.p("act", "assistant");
        fH.p(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
        BdStatisticsManager.getInstance().debug("img", fH);
    }

    private static String uI() {
        try {
            DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApp().getSystemService("wifi")).getDhcpInfo();
            return String.valueOf(intToIp(dhcpInfo.dns1)) + "," + intToIp(dhcpInfo.dns2);
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
    private static long uJ() {
        HttpURLConnection httpURLConnection;
        long j;
        if (aeg >= 3) {
            return aeh;
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
            if (aeg > -1) {
                aeh = ((aeh * aeg) + j) / (aeg + 1);
            } else {
                aeh = j;
            }
            aeg++;
            return j;
        }
        return j;
    }

    private static String uK() {
        return com.baidu.tbadk.imageManager.c.El().em();
    }

    private static String uL() {
        return com.baidu.adp.lib.asyncTask.c.en().em();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.c fH = fH();
        fH.p("act", "getCDNList");
        fH.p("errorNum", str);
        fH.p("errorMsg", str2);
        fH.p("isShortNetError", z2 ? "1" : "0");
        fH.p("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug("img", fH);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = v.uQ().di(str);
        }
        String uI = uI();
        String ip = d.getIp();
        com.baidu.adp.lib.stats.c fH = fH();
        fH.p("act", "tachometerCDN");
        fH.p("errorNum", str3);
        fH.p("execption", str4);
        fH.p("size", str5);
        fH.p("isScuess", z ? "1" : "0");
        fH.p("url", str);
        fH.p("localIp", ip);
        fH.p("cdnIp", str6);
        fH.p("dnsIP", uI);
        fH.p("usedIp", str2);
        fH.p("isUsedIp", z2 ? "0" : "1");
        fH.p("costTime", String.valueOf(j));
        BdStatisticsManager.getInstance().debug("img", fH);
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
                    com.baidu.adp.lib.stats.c fH = fH();
                    fH.p("act", "mobileTachometerCDN");
                    fH.p("costTime", String.valueOf(j));
                    fH.p("ipList", sb.toString());
                    BdStatisticsManager.getInstance().debug("img", fH);
                    return;
                }
            }
        }
    }

    public static void d(boolean z, String str) {
        com.baidu.adp.lib.stats.c fH = fH();
        fH.p("act", "getCDNList");
        fH.p("isSuccess", z ? "1" : "0");
        fH.p("errorMsg", str);
        BdStatisticsManager.getInstance().debug("img", fH);
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
