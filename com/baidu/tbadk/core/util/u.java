package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class u {
    private static long adN = 0;
    private static long adO = 0;
    private static int adP = 0;
    private static a adQ = new a(null);
    private static t adR = new t();
    private static t adS = new t();
    private static String adT = null;
    private static Object wB = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int adU;
        boolean adV;
        t adW;
        t adX;
        t adY;
        t adZ;
        t aea;
        t aeb;
        t aec;
        t aed;
        t aee;
        t aef;
        t aeg;
        t aeh;
        t aei;
        t aej;
        t aek;

        private a() {
            this.adU = 0;
            this.adW = new t();
            this.adX = new t();
            this.adY = new t();
            this.adZ = new t();
            this.aea = new t();
            this.aeb = new t();
            this.aec = new t();
            this.aed = new t();
            this.aee = new t();
            this.aef = new t();
            this.aeg = new t();
            this.aeh = new t();
            this.aei = new t();
            this.aej = new t();
            this.aek = new t();
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [75=4] */
        public int uw() {
            return this.adW.num + this.adX.num + this.adY.num + this.adZ.num + this.aea.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [81=14] */
        public int ux() {
            return this.adW.num + this.adX.num + this.adY.num + this.adZ.num + this.aea.num + this.aeb.num + this.aec.num + this.aed.num + this.aee.num + this.aef.num + this.aeg.num + this.aeh.num + this.aei.num + this.aej.num + this.aek.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [92=4] */
        public int uy() {
            return this.aeb.num + this.aec.num + this.aed.num + this.aee.num + this.aef.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [98=4] */
        public int uz() {
            return this.aeg.num + this.aeh.num + this.aei.num + this.aej.num + this.aek.num;
        }

        public void reset() {
            this.adU = 0;
            this.adW.reset();
            this.adX.reset();
            this.adY.reset();
            this.adZ.reset();
            this.aea.reset();
            this.aeb.reset();
            this.aec.reset();
            this.aed.reset();
            this.aee.reset();
            this.aef.reset();
            this.aeg.reset();
            this.aeh.reset();
            this.aei.reset();
            this.aej.reset();
            this.aek.reset();
        }
    }

    private static t a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return adQ.adW;
            }
            if (str.startsWith("http://tb.himg")) {
                return adQ.adX;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return adQ.adY;
            }
            if (z2 && z3) {
                return adQ.aea;
            }
            return adQ.adZ;
        } else if (com.baidu.adp.lib.util.i.hp()) {
            if (z2) {
                return adQ.aeb;
            }
            if (str.startsWith("http://tb.himg")) {
                return adQ.aec;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return adQ.aed;
            }
            return adQ.aee;
        } else if (z2) {
            return adQ.aeg;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return adQ.aeh;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return adQ.aei;
            }
            return adQ.aej;
        }
    }

    public static com.baidu.adp.lib.stats.c fN() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.c cVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (wB) {
                adR.num++;
                adR.time += j;
                if (adR.num >= 100) {
                    up();
                }
            }
        }
    }

    public static void up() {
        if (adR.num > 10) {
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("act", "locStat");
            fN.p("costTime", String.valueOf(adR.time));
            fN.p("num", String.valueOf(adR.num));
            fN.p("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", fN);
            adR.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.c cVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.e eVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.k.hB() && eVar != null) {
            String str6 = "";
            boolean gd = com.baidu.tbadk.util.h.gd(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().agG) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean hl = com.baidu.adp.lib.util.i.hl();
            if (!z5) {
                z4 = false;
            } else if (hl) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Rh);
            } else if (com.baidu.adp.lib.util.i.hp()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Rj);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Ri);
            }
            boolean z6 = false;
            if (gd && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (gd && hl && z6) {
                if (z) {
                    r.getInstance().insertNormalData(j, str);
                } else {
                    str6 = v.uA().uB();
                    if (!TextUtils.isEmpty(str6)) {
                        r.getInstance().insertErrorData(eVar.vB, str);
                    }
                }
            }
            if (gd) {
                adT = str;
            }
            boolean z7 = false;
            if (eVar.vD != null && eVar.vD.length() > 0) {
                z7 = true;
            }
            synchronized (wB) {
                t a2 = a(hl, gd, str2, z7);
                boolean z8 = adQ.adV;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.vv += j2;
                        adQ.adV = true;
                        if (z4) {
                            a2.adM++;
                        }
                        adP = 0;
                    } else {
                        if (com.baidu.adp.lib.util.i.hk()) {
                            int i2 = adP + 1;
                            adP = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.gC().getMaxAlertCount("alert_img", 5)) {
                                BdStatisticsManager.getInstance().alert("alert_img", "imgFailedCnt_" + String.valueOf(adP) + "_url=" + str2);
                            }
                        }
                        a2.adL++;
                        adQ.adV = false;
                    }
                }
                int ux = adQ.ux();
                if (ux > 100 || (ux > 0 && z8 != adQ.adV)) {
                    uq();
                }
            }
            if (z && z5) {
                if (!hl || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Rh) {
                    if (hl || !com.baidu.adp.lib.util.i.hp() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Rj) {
                        if (!hl && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Ri) {
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
                cVar = fN();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = v.uA().uB();
            }
            if (!gd || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = v.uA().dn(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = us();
            }
            cVar.p("url", str);
            cVar.p("act", "dl");
            cVar.p("result", z ? "1" : "0");
            cVar.p("fullurl", str2);
            cVar.p("netlib", String.valueOf(eVar.vH));
            cVar.p("costTime", String.valueOf(j));
            cVar.p("connTime", String.valueOf(eVar.connectTime));
            cVar.p("rspTime", String.valueOf(eVar.vw));
            cVar.p("retry", String.valueOf(eVar.vx));
            cVar.p("localIp", d.getIp());
            cVar.p("tiebaIp", str6);
            cVar.p("cdnIp", str4);
            cVar.p("useIp", eVar.vD);
            cVar.p("dnsIp", str5);
            if (eVar.connectTime > 1500 || eVar.connectTime < 0) {
                cVar.p("connBaidu", String.valueOf(ut()));
            }
            cVar.p("memory", uu());
            cVar.p("task", uv());
            cVar.p("status", String.valueOf(eVar.vC));
            cVar.p("up", String.valueOf(eVar.vu));
            cVar.p("down", String.valueOf(eVar.vv));
            cVar.p("isCDN", gd ? "1" : "0");
            cVar.p("isWebp", bool.booleanValue() ? "1" : "0");
            cVar.p("isMobileProxy", z3 ? "1" : "0");
            cVar.p("exception", eVar.vA);
            cVar.p("reason", str3);
            if (i != 0) {
                cVar.d("procType", Integer.valueOf(i));
            }
            if (eVar.vF != null) {
                cVar.p("tracecode1", eVar.vF);
            }
            if (eVar.vG != null) {
                cVar.p("tracecode2", eVar.vG);
            }
            BdStatisticsManager.getInstance().debug("img", cVar);
            if (gd && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                adQ.adU++;
            }
        }
    }

    public static void uq() {
        if (adQ.ux() > 10) {
            if (adQ.uw() > 0) {
                a(adQ.adW, adQ.adX, adQ.adY, adQ.aea, adQ.adZ, 10000);
                com.baidu.tbadk.j.x.b(adQ.adW, adQ.adX, adQ.adY, adQ.aea, adQ.adZ, 3);
            }
            if (adQ.uz() > 0) {
                a(adQ.aeg, adQ.aeh, adQ.aei, adQ.aek, adQ.aej, 100002);
                com.baidu.tbadk.j.x.b(adQ.aeg, adQ.aeh, adQ.aei, adQ.aek, adQ.aej, 2);
            }
            if (adQ.uy() > 0) {
                a(adQ.aeb, adQ.aec, adQ.aed, adQ.aef, adQ.aee, 100001);
                com.baidu.tbadk.j.x.b(adQ.aeb, adQ.aec, adQ.aed, adQ.aef, adQ.aee, 1);
            }
            adQ.reset();
        }
    }

    public static void a(t tVar, t tVar2, t tVar3, t tVar4, t tVar5, int i) {
        if (tVar != null && tVar2 != null && tVar3 != null && tVar4 != null && tVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = v.uA().uB();
            }
            if (adT != null && TextUtils.isEmpty("")) {
                str2 = v.uA().dn(adT);
            }
            if (TextUtils.isEmpty("")) {
                str3 = us();
            }
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("act", "dlStat");
            fN.p("cdnCostTime", String.valueOf(tVar.time));
            fN.p("cdnNum", String.valueOf(tVar.num));
            fN.p("cdnFailnum", String.valueOf(tVar.adL));
            fN.p("portraitCostTime", String.valueOf(tVar2.time));
            fN.p("portraitNum", String.valueOf(tVar2.num));
            fN.p("portraitFailnum", String.valueOf(tVar2.adL));
            fN.p("tiebaCostTime", String.valueOf(tVar3.time));
            fN.p("tiebaNum", String.valueOf(tVar3.num));
            fN.p("tiebaFailnum", String.valueOf(tVar3.adL));
            fN.p("otherCostTime", String.valueOf(tVar5.time));
            fN.p("otherNum", String.valueOf(tVar5.num));
            fN.p("otherFailnum", String.valueOf(tVar5.adL));
            fN.p("directIpCostTime", String.valueOf(tVar4.time));
            fN.p("directIpNum", String.valueOf(tVar4.num));
            fN.p("directIpFailnum", String.valueOf(tVar4.adL));
            fN.p("dnsFailNum", String.valueOf(adQ.adU));
            if (10000 == i) {
                fN.p("isWifi", "1");
                fN.p("netType", "WIFI");
            } else if (100002 == i) {
                fN.p("netType", "3G");
                fN.p("isWifi", "0");
            } else {
                fN.p("netType", "2G");
                fN.p("isWifi", "0");
            }
            fN.p("localIp", d.getIp());
            fN.p("tbIp", str);
            fN.p("cdnIp", str2);
            fN.p("dnsIp", str3);
            BdStatisticsManager.getInstance().debug("img", fN);
        }
    }

    public static void a(com.baidu.adp.lib.stats.c cVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.k.hB()) {
            synchronized (wB) {
                adS.num++;
                if (z) {
                    adS.time += j;
                } else {
                    adS.adL++;
                }
                if (adS.num >= 100) {
                    ur();
                }
            }
            if (!z) {
                if (cVar == null) {
                    cVar = fN();
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

    public static void ur() {
        if (adS.num > 10) {
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("act", "dcStat");
            fN.p("costTime", String.valueOf(adS.time));
            fN.p("num", String.valueOf(adS.num));
            fN.p("failnum", String.valueOf(adS.adL));
            BdStatisticsManager.getInstance().debug("img", fN);
            com.baidu.tbadk.j.x.a(adS.num, adS.adL, adS.time);
            adS.reset();
        }
    }

    public static void dm(String str) {
        com.baidu.adp.lib.stats.c fN = fN();
        fN.p("act", "assistant");
        fN.p("content", str);
        BdStatisticsManager.getInstance().debug("img", fN);
    }

    private static String us() {
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
    private static long ut() {
        HttpURLConnection httpURLConnection;
        long j;
        if (adN >= 3) {
            return adO;
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
            if (adN > -1) {
                adO = ((adO * adN) + j) / (adN + 1);
            } else {
                adO = j;
            }
            adN++;
            return j;
        }
        return j;
    }

    private static String uu() {
        return com.baidu.tbadk.imageManager.c.DN().em();
    }

    private static String uv() {
        return com.baidu.adp.lib.asyncTask.c.en().em();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.c fN = fN();
        fN.p("act", "getCDNList");
        fN.p("errorNum", str);
        fN.p("errorMsg", str2);
        fN.p("isShortNetError", z2 ? "1" : "0");
        fN.p("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug("img", fN);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = v.uA().dn(str);
        }
        String us = us();
        String ip = d.getIp();
        com.baidu.adp.lib.stats.c fN = fN();
        fN.p("act", "tachometerCDN");
        fN.p("errorNum", str3);
        fN.p("execption", str4);
        fN.p("size", str5);
        fN.p("isScuess", z ? "1" : "0");
        fN.p("url", str);
        fN.p("localIp", ip);
        fN.p("cdnIp", str6);
        fN.p("dnsIP", us);
        fN.p("usedIp", str2);
        fN.p("isUsedIp", z2 ? "0" : "1");
        fN.p("costTime", String.valueOf(j));
        BdStatisticsManager.getInstance().debug("img", fN);
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
                    com.baidu.adp.lib.stats.c fN = fN();
                    fN.p("act", "mobileTachometerCDN");
                    fN.p("costTime", String.valueOf(j));
                    fN.p("ipList", sb.toString());
                    BdStatisticsManager.getInstance().debug("img", fN);
                    return;
                }
            }
        }
    }

    public static void c(boolean z, String str) {
        com.baidu.adp.lib.stats.c fN = fN();
        fN.p("act", "getCDNList");
        fN.p("isSuccess", z ? "1" : "0");
        fN.p("errorMsg", str);
        BdStatisticsManager.getInstance().debug("img", fN);
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
