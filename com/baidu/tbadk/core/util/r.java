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
public class r {
    private static long agf = 0;
    private static long agg = 0;
    private static int agh = 0;
    private static a agi = new a();
    private static q agj = new q();
    private static q agk = new q();
    private static String agl = null;
    private static Object yd = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        q agA;
        q agB;
        q agC;
        int agm;
        boolean agn;
        q ago;
        q agp;
        q agq;
        q agr;
        q ags;
        q agt;
        q agu;
        q agv;
        q agw;
        q agx;
        q agy;
        q agz;

        private a() {
            this.agm = 0;
            this.ago = new q();
            this.agp = new q();
            this.agq = new q();
            this.agr = new q();
            this.ags = new q();
            this.agt = new q();
            this.agu = new q();
            this.agv = new q();
            this.agw = new q();
            this.agx = new q();
            this.agy = new q();
            this.agz = new q();
            this.agA = new q();
            this.agB = new q();
            this.agC = new q();
        }

        public int uY() {
            return this.ago.num + this.agp.num + this.agq.num + this.agr.num + this.ags.num;
        }

        public int uZ() {
            return this.ago.num + this.agp.num + this.agq.num + this.agr.num + this.ags.num + this.agt.num + this.agu.num + this.agv.num + this.agw.num + this.agx.num + this.agy.num + this.agz.num + this.agA.num + this.agB.num + this.agC.num;
        }

        public int va() {
            return this.agt.num + this.agu.num + this.agv.num + this.agw.num + this.agx.num;
        }

        public int vb() {
            return this.agy.num + this.agz.num + this.agA.num + this.agB.num + this.agC.num;
        }

        public void reset() {
            this.agm = 0;
            this.ago.reset();
            this.agp.reset();
            this.agq.reset();
            this.agr.reset();
            this.ags.reset();
            this.agt.reset();
            this.agu.reset();
            this.agv.reset();
            this.agw.reset();
            this.agx.reset();
            this.agy.reset();
            this.agz.reset();
            this.agA.reset();
            this.agB.reset();
            this.agC.reset();
        }
    }

    private static q a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return agi.ago;
            }
            if (str.startsWith("http://tb.himg")) {
                return agi.agp;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return agi.agq;
            }
            if (z2 && z3) {
                return agi.ags;
            }
            return agi.agr;
        } else if (com.baidu.adp.lib.util.i.hw()) {
            if (z2) {
                return agi.agt;
            }
            if (str.startsWith("http://tb.himg")) {
                return agi.agu;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return agi.agv;
            }
            return agi.agw;
        } else if (z2) {
            return agi.agy;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return agi.agz;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return agi.agA;
            }
            return agi.agB;
        }
    }

    public static com.baidu.adp.lib.stats.a fV() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (yd) {
                agj.num++;
                agj.time += j;
                if (agj.num >= 100) {
                    uR();
                }
            }
        }
    }

    public static void uR() {
        if (agj.num > 10) {
            com.baidu.adp.lib.stats.a fV = fV();
            fV.p("act", "locStat");
            fV.p("costTime", String.valueOf(agj.time));
            fV.p("num", String.valueOf(agj.num));
            fV.p("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", fV);
            agj.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.k.hI() && dVar != null) {
            String str6 = "";
            boolean gI = com.baidu.tbadk.util.i.gI(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().aiU) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean hs = com.baidu.adp.lib.util.i.hs();
            if (!z5) {
                z4 = false;
            } else if (hs) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Sz);
            } else if (com.baidu.adp.lib.util.i.hw()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().SB);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().SA);
            }
            boolean z6 = false;
            if (gI && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (gI && hs && z6) {
                if (z) {
                    o.getInstance().insertNormalData(j, str);
                } else {
                    str6 = s.vc().vd();
                    if (!TextUtils.isEmpty(str6)) {
                        o.getInstance().insertErrorData(dVar.xd, str);
                    }
                }
            }
            if (gI) {
                agl = str;
            }
            boolean z7 = false;
            if (dVar.xf != null && dVar.xf.length() > 0) {
                z7 = true;
            }
            synchronized (yd) {
                q a2 = a(hs, gI, str2, z7);
                boolean z8 = agi.agn;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.wY += j2;
                        agi.agn = true;
                        if (z4) {
                            a2.agd++;
                        }
                        agh = 0;
                    } else {
                        if (com.baidu.adp.lib.util.i.hr()) {
                            int i2 = agh + 1;
                            agh = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.gJ().getMaxAlertCount("alert_img", 5)) {
                                BdStatisticsManager.getInstance().alert("alert_img", "imgFailedCnt_" + String.valueOf(agh) + "_url=" + str2);
                            }
                        }
                        a2.agc++;
                        agi.agn = false;
                    }
                }
                int uZ = agi.uZ();
                if (uZ > 100 || (uZ > 0 && z8 != agi.agn)) {
                    uS();
                }
            }
            if (z && z5) {
                if (!hs || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Sz) {
                    if (hs || !com.baidu.adp.lib.util.i.hw() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().SB) {
                        if (!hs && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().SA) {
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
                aVar = fV();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = s.vc().vd();
            }
            if (!gI || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = s.vc().dN(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = uU();
            }
            aVar.p("url", str);
            aVar.p("act", "dl");
            aVar.p("result", z ? "1" : "0");
            aVar.p("fullurl", str2);
            aVar.p("netlib", String.valueOf(dVar.xj));
            aVar.p("costTime", String.valueOf(j));
            aVar.p("connTime", String.valueOf(dVar.connectTime));
            aVar.p("rspTime", String.valueOf(dVar.wZ));
            aVar.p("retry", String.valueOf(dVar.retry));
            aVar.p("localIp", d.getIp());
            aVar.p("tiebaIp", str6);
            aVar.p("cdnIp", str4);
            aVar.p("useIp", dVar.xf);
            aVar.p("dnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.p("connBaidu", String.valueOf(uV()));
            }
            aVar.p("memory", uW());
            aVar.p("task", uX());
            aVar.p("status", String.valueOf(dVar.xe));
            aVar.p("up", String.valueOf(dVar.wX));
            aVar.p("down", String.valueOf(dVar.wY));
            aVar.p("isCDN", gI ? "1" : "0");
            aVar.p("isWebp", bool.booleanValue() ? "1" : "0");
            aVar.p("isMobileProxy", z3 ? "1" : "0");
            aVar.p("exception", dVar.xc);
            aVar.p("reason", str3);
            if (i != 0) {
                aVar.d("procType", Integer.valueOf(i));
            }
            if (dVar.xh != null) {
                aVar.p("tracecode1", dVar.xh);
            }
            if (dVar.xi != null) {
                aVar.p("tracecode2", dVar.xi);
            }
            BdStatisticsManager.getInstance().debug("img", aVar);
            if (gI && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                agi.agm++;
            }
        }
    }

    public static void uS() {
        if (agi.uZ() > 10) {
            if (agi.uY() > 0) {
                a(agi.ago, agi.agp, agi.agq, agi.ags, agi.agr, 10000);
                com.baidu.tbadk.l.o.b(agi.ago, agi.agp, agi.agq, agi.ags, agi.agr, 3);
            }
            if (agi.vb() > 0) {
                a(agi.agy, agi.agz, agi.agA, agi.agC, agi.agB, 100002);
                com.baidu.tbadk.l.o.b(agi.agy, agi.agz, agi.agA, agi.agC, agi.agB, 2);
            }
            if (agi.va() > 0) {
                a(agi.agt, agi.agu, agi.agv, agi.agx, agi.agw, 100001);
                com.baidu.tbadk.l.o.b(agi.agt, agi.agu, agi.agv, agi.agx, agi.agw, 1);
            }
            agi.reset();
        }
    }

    public static void a(q qVar, q qVar2, q qVar3, q qVar4, q qVar5, int i) {
        if (qVar != null && qVar2 != null && qVar3 != null && qVar4 != null && qVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = s.vc().vd();
            }
            if (agl != null && TextUtils.isEmpty("")) {
                str2 = s.vc().dN(agl);
            }
            if (TextUtils.isEmpty("")) {
                str3 = uU();
            }
            com.baidu.adp.lib.stats.a fV = fV();
            fV.p("act", "dlStat");
            fV.p("cdnCostTime", String.valueOf(qVar.time));
            fV.p("cdnNum", String.valueOf(qVar.num));
            fV.p("cdnFailnum", String.valueOf(qVar.agc));
            fV.p("portraitCostTime", String.valueOf(qVar2.time));
            fV.p("portraitNum", String.valueOf(qVar2.num));
            fV.p("portraitFailnum", String.valueOf(qVar2.agc));
            fV.p("tiebaCostTime", String.valueOf(qVar3.time));
            fV.p("tiebaNum", String.valueOf(qVar3.num));
            fV.p("tiebaFailnum", String.valueOf(qVar3.agc));
            fV.p("otherCostTime", String.valueOf(qVar5.time));
            fV.p("otherNum", String.valueOf(qVar5.num));
            fV.p("otherFailnum", String.valueOf(qVar5.agc));
            fV.p("directIpCostTime", String.valueOf(qVar4.time));
            fV.p("directIpNum", String.valueOf(qVar4.num));
            fV.p("directIpFailnum", String.valueOf(qVar4.agc));
            fV.p("dnsFailNum", String.valueOf(agi.agm));
            if (10000 == i) {
                fV.p("isWifi", "1");
                fV.p("netType", "WIFI");
            } else if (100002 == i) {
                fV.p("netType", "3G");
                fV.p("isWifi", "0");
            } else {
                fV.p("netType", "2G");
                fV.p("isWifi", "0");
            }
            fV.p("localIp", d.getIp());
            fV.p("tbIp", str);
            fV.p("cdnIp", str2);
            fV.p("dnsIp", str3);
            BdStatisticsManager.getInstance().debug("img", fV);
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.k.hI()) {
            synchronized (yd) {
                agk.num++;
                if (z) {
                    agk.time += j;
                } else {
                    agk.agc++;
                }
                if (agk.num >= 100) {
                    uT();
                }
            }
            if (!z) {
                if (aVar == null) {
                    aVar = fV();
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

    public static void uT() {
        if (agk.num > 10) {
            com.baidu.adp.lib.stats.a fV = fV();
            fV.p("act", "dcStat");
            fV.p("costTime", String.valueOf(agk.time));
            fV.p("num", String.valueOf(agk.num));
            fV.p("failnum", String.valueOf(agk.agc));
            BdStatisticsManager.getInstance().debug("img", fV);
            com.baidu.tbadk.l.o.a(agk.num, agk.agc, agk.time);
            agk.reset();
        }
    }

    public static void dM(String str) {
        com.baidu.adp.lib.stats.a fV = fV();
        fV.p("act", "assistant");
        fV.p("content", str);
        BdStatisticsManager.getInstance().debug("img", fV);
    }

    private static String uU() {
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
    private static long uV() {
        HttpURLConnection httpURLConnection;
        long j;
        if (agf >= 3) {
            return agg;
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
            com.baidu.adp.lib.g.a.h(httpURLConnection);
            j = currentTimeMillis2;
        } catch (SocketTimeoutException e3) {
            com.baidu.adp.lib.g.a.h(httpURLConnection);
            j = 2500;
            if (j > 0) {
            }
        } catch (Exception e4) {
            httpURLConnection2 = httpURLConnection;
            com.baidu.adp.lib.g.a.h(httpURLConnection2);
            j = -1;
            if (j > 0) {
            }
        } catch (Throwable th2) {
            httpURLConnection2 = httpURLConnection;
            th = th2;
            com.baidu.adp.lib.g.a.h(httpURLConnection2);
            throw th;
        }
        if (j > 0) {
            if (agf > -1) {
                agg = ((agg * agf) + j) / (agf + 1);
            } else {
                agg = j;
            }
            agf++;
            return j;
        }
        return j;
    }

    private static String uW() {
        return com.baidu.tbadk.imageManager.c.Ex().eu();
    }

    private static String uX() {
        return com.baidu.adp.lib.asyncTask.a.ev().eu();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.a fV = fV();
        fV.p("act", "getCDNList");
        fV.p("errorNum", str);
        fV.p("errorMsg", str2);
        fV.p("isShortNetError", z2 ? "1" : "0");
        fV.p("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug("img", fV);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = s.vc().dN(str);
        }
        String uU = uU();
        String ip = d.getIp();
        com.baidu.adp.lib.stats.a fV = fV();
        fV.p("act", "tachometerCDN");
        fV.p("errorNum", str3);
        fV.p("execption", str4);
        fV.p("size", str5);
        fV.p("isScuess", z ? "1" : "0");
        fV.p("url", str);
        fV.p("localIp", ip);
        fV.p("cdnIp", str6);
        fV.p("dnsIP", uU);
        fV.p("usedIp", str2);
        fV.p("isUsedIp", z2 ? "0" : "1");
        fV.p("costTime", String.valueOf(j));
        BdStatisticsManager.getInstance().debug("img", fV);
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
                    com.baidu.adp.lib.stats.a fV = fV();
                    fV.p("act", "mobileTachometerCDN");
                    fV.p("costTime", String.valueOf(j));
                    fV.p("ipList", sb.toString());
                    BdStatisticsManager.getInstance().debug("img", fV);
                    return;
                }
            }
        }
    }

    public static void c(boolean z, String str) {
        com.baidu.adp.lib.stats.a fV = fV();
        fV.p("act", "getCDNList");
        fV.p("isSuccess", z ? "1" : "0");
        fV.p("errorMsg", str);
        BdStatisticsManager.getInstance().debug("img", fV);
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
