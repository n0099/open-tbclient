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
    private static long aeK = 0;
    private static long aeL = 0;
    private static int aeM = 0;
    private static a aeN = new a();
    private static q aeO = new q();
    private static q aeP = new q();
    private static String aeQ = null;
    private static Object wC = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int aeR;
        boolean aeS;
        q aeT;
        q aeU;
        q aeV;
        q aeW;
        q aeX;
        q aeY;
        q aeZ;
        q afa;
        q afb;
        q afc;
        q afd;
        q afe;
        q aff;
        q afg;
        q afh;

        private a() {
            this.aeR = 0;
            this.aeT = new q();
            this.aeU = new q();
            this.aeV = new q();
            this.aeW = new q();
            this.aeX = new q();
            this.aeY = new q();
            this.aeZ = new q();
            this.afa = new q();
            this.afb = new q();
            this.afc = new q();
            this.afd = new q();
            this.afe = new q();
            this.aff = new q();
            this.afg = new q();
            this.afh = new q();
        }

        public int uO() {
            return this.aeT.num + this.aeU.num + this.aeV.num + this.aeW.num + this.aeX.num;
        }

        public int uP() {
            return this.aeT.num + this.aeU.num + this.aeV.num + this.aeW.num + this.aeX.num + this.aeY.num + this.aeZ.num + this.afa.num + this.afb.num + this.afc.num + this.afd.num + this.afe.num + this.aff.num + this.afg.num + this.afh.num;
        }

        public int uQ() {
            return this.aeY.num + this.aeZ.num + this.afa.num + this.afb.num + this.afc.num;
        }

        public int uR() {
            return this.afd.num + this.afe.num + this.aff.num + this.afg.num + this.afh.num;
        }

        public void reset() {
            this.aeR = 0;
            this.aeT.reset();
            this.aeU.reset();
            this.aeV.reset();
            this.aeW.reset();
            this.aeX.reset();
            this.aeY.reset();
            this.aeZ.reset();
            this.afa.reset();
            this.afb.reset();
            this.afc.reset();
            this.afd.reset();
            this.afe.reset();
            this.aff.reset();
            this.afg.reset();
            this.afh.reset();
        }
    }

    private static q a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return aeN.aeT;
            }
            if (str.startsWith("http://tb.himg")) {
                return aeN.aeU;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aeN.aeV;
            }
            if (z2 && z3) {
                return aeN.aeX;
            }
            return aeN.aeW;
        } else if (com.baidu.adp.lib.util.i.hm()) {
            if (z2) {
                return aeN.aeY;
            }
            if (str.startsWith("http://tb.himg")) {
                return aeN.aeZ;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aeN.afa;
            }
            return aeN.afb;
        } else if (z2) {
            return aeN.afd;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return aeN.afe;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aeN.aff;
            }
            return aeN.afg;
        }
    }

    public static com.baidu.adp.lib.stats.a fK() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (wC) {
                aeO.num++;
                aeO.time += j;
                if (aeO.num >= 100) {
                    uH();
                }
            }
        }
    }

    public static void uH() {
        if (aeO.num > 10) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("act", "locStat");
            fK.p("costTime", String.valueOf(aeO.time));
            fK.p("num", String.valueOf(aeO.num));
            fK.p("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", fK);
            aeO.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.k.hy() && dVar != null) {
            String str6 = "";
            boolean gD = com.baidu.tbadk.util.i.gD(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().ahB) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean hi = com.baidu.adp.lib.util.i.hi();
            if (!z5) {
                z4 = false;
            } else if (hi) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Rb);
            } else if (com.baidu.adp.lib.util.i.hm()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Rd);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Rc);
            }
            boolean z6 = false;
            if (gD && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (gD && hi && z6) {
                if (z) {
                    o.getInstance().insertNormalData(j, str);
                } else {
                    str6 = s.uS().uT();
                    if (!TextUtils.isEmpty(str6)) {
                        o.getInstance().insertErrorData(dVar.vB, str);
                    }
                }
            }
            if (gD) {
                aeQ = str;
            }
            boolean z7 = false;
            if (dVar.vD != null && dVar.vD.length() > 0) {
                z7 = true;
            }
            synchronized (wC) {
                q a2 = a(hi, gD, str2, z7);
                boolean z8 = aeN.aeS;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.vv += j2;
                        aeN.aeS = true;
                        if (z4) {
                            a2.aeJ++;
                        }
                        aeM = 0;
                    } else {
                        if (com.baidu.adp.lib.util.i.hh()) {
                            int i2 = aeM + 1;
                            aeM = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.gz().getMaxAlertCount("alert_img", 5)) {
                                BdStatisticsManager.getInstance().alert("alert_img", "imgFailedCnt_" + String.valueOf(aeM) + "_url=" + str2);
                            }
                        }
                        a2.aeI++;
                        aeN.aeS = false;
                    }
                }
                int uP = aeN.uP();
                if (uP > 100 || (uP > 0 && z8 != aeN.aeS)) {
                    uI();
                }
            }
            if (z && z5) {
                if (!hi || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Rb) {
                    if (hi || !com.baidu.adp.lib.util.i.hm() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Rd) {
                        if (!hi && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Rc) {
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
                str6 = s.uS().uT();
            }
            if (!gD || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = s.uS().dH(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = uK();
            }
            aVar.p("url", str);
            aVar.p("act", "dl");
            aVar.p("result", z ? "1" : "0");
            aVar.p("fullurl", str2);
            aVar.p("netlib", String.valueOf(dVar.vH));
            aVar.p("costTime", String.valueOf(j));
            aVar.p("connTime", String.valueOf(dVar.connectTime));
            aVar.p("rspTime", String.valueOf(dVar.vw));
            aVar.p("retry", String.valueOf(dVar.vx));
            aVar.p("localIp", d.getIp());
            aVar.p("tiebaIp", str6);
            aVar.p("cdnIp", str4);
            aVar.p("useIp", dVar.vD);
            aVar.p("dnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.p("connBaidu", String.valueOf(uL()));
            }
            aVar.p("memory", uM());
            aVar.p("task", uN());
            aVar.p("status", String.valueOf(dVar.vC));
            aVar.p("up", String.valueOf(dVar.vu));
            aVar.p("down", String.valueOf(dVar.vv));
            aVar.p("isCDN", gD ? "1" : "0");
            aVar.p("isWebp", bool.booleanValue() ? "1" : "0");
            aVar.p("isMobileProxy", z3 ? "1" : "0");
            aVar.p("exception", dVar.vA);
            aVar.p("reason", str3);
            if (i != 0) {
                aVar.d("procType", Integer.valueOf(i));
            }
            if (dVar.vF != null) {
                aVar.p("tracecode1", dVar.vF);
            }
            if (dVar.vG != null) {
                aVar.p("tracecode2", dVar.vG);
            }
            BdStatisticsManager.getInstance().debug("img", aVar);
            if (gD && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                aeN.aeR++;
            }
        }
    }

    public static void uI() {
        if (aeN.uP() > 10) {
            if (aeN.uO() > 0) {
                a(aeN.aeT, aeN.aeU, aeN.aeV, aeN.aeX, aeN.aeW, 10000);
                com.baidu.tbadk.l.o.b(aeN.aeT, aeN.aeU, aeN.aeV, aeN.aeX, aeN.aeW, 3);
            }
            if (aeN.uR() > 0) {
                a(aeN.afd, aeN.afe, aeN.aff, aeN.afh, aeN.afg, 100002);
                com.baidu.tbadk.l.o.b(aeN.afd, aeN.afe, aeN.aff, aeN.afh, aeN.afg, 2);
            }
            if (aeN.uQ() > 0) {
                a(aeN.aeY, aeN.aeZ, aeN.afa, aeN.afc, aeN.afb, 100001);
                com.baidu.tbadk.l.o.b(aeN.aeY, aeN.aeZ, aeN.afa, aeN.afc, aeN.afb, 1);
            }
            aeN.reset();
        }
    }

    public static void a(q qVar, q qVar2, q qVar3, q qVar4, q qVar5, int i) {
        if (qVar != null && qVar2 != null && qVar3 != null && qVar4 != null && qVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = s.uS().uT();
            }
            if (aeQ != null && TextUtils.isEmpty("")) {
                str2 = s.uS().dH(aeQ);
            }
            if (TextUtils.isEmpty("")) {
                str3 = uK();
            }
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("act", "dlStat");
            fK.p("cdnCostTime", String.valueOf(qVar.time));
            fK.p("cdnNum", String.valueOf(qVar.num));
            fK.p("cdnFailnum", String.valueOf(qVar.aeI));
            fK.p("portraitCostTime", String.valueOf(qVar2.time));
            fK.p("portraitNum", String.valueOf(qVar2.num));
            fK.p("portraitFailnum", String.valueOf(qVar2.aeI));
            fK.p("tiebaCostTime", String.valueOf(qVar3.time));
            fK.p("tiebaNum", String.valueOf(qVar3.num));
            fK.p("tiebaFailnum", String.valueOf(qVar3.aeI));
            fK.p("otherCostTime", String.valueOf(qVar5.time));
            fK.p("otherNum", String.valueOf(qVar5.num));
            fK.p("otherFailnum", String.valueOf(qVar5.aeI));
            fK.p("directIpCostTime", String.valueOf(qVar4.time));
            fK.p("directIpNum", String.valueOf(qVar4.num));
            fK.p("directIpFailnum", String.valueOf(qVar4.aeI));
            fK.p("dnsFailNum", String.valueOf(aeN.aeR));
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
        if (com.baidu.adp.lib.util.k.hy()) {
            synchronized (wC) {
                aeP.num++;
                if (z) {
                    aeP.time += j;
                } else {
                    aeP.aeI++;
                }
                if (aeP.num >= 100) {
                    uJ();
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

    public static void uJ() {
        if (aeP.num > 10) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("act", "dcStat");
            fK.p("costTime", String.valueOf(aeP.time));
            fK.p("num", String.valueOf(aeP.num));
            fK.p("failnum", String.valueOf(aeP.aeI));
            BdStatisticsManager.getInstance().debug("img", fK);
            com.baidu.tbadk.l.o.a(aeP.num, aeP.aeI, aeP.time);
            aeP.reset();
        }
    }

    public static void dG(String str) {
        com.baidu.adp.lib.stats.a fK = fK();
        fK.p("act", "assistant");
        fK.p("content", str);
        BdStatisticsManager.getInstance().debug("img", fK);
    }

    private static String uK() {
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
    private static long uL() {
        HttpURLConnection httpURLConnection;
        long j;
        if (aeK >= 3) {
            return aeL;
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
            com.baidu.adp.lib.g.a.g(httpURLConnection);
            j = currentTimeMillis2;
        } catch (SocketTimeoutException e3) {
            com.baidu.adp.lib.g.a.g(httpURLConnection);
            j = 2500;
            if (j > 0) {
            }
        } catch (Exception e4) {
            httpURLConnection2 = httpURLConnection;
            com.baidu.adp.lib.g.a.g(httpURLConnection2);
            j = -1;
            if (j > 0) {
            }
        } catch (Throwable th2) {
            httpURLConnection2 = httpURLConnection;
            th = th2;
            com.baidu.adp.lib.g.a.g(httpURLConnection2);
            throw th;
        }
        if (j > 0) {
            if (aeK > -1) {
                aeL = ((aeL * aeK) + j) / (aeK + 1);
            } else {
                aeL = j;
            }
            aeK++;
            return j;
        }
        return j;
    }

    private static String uM() {
        return com.baidu.tbadk.imageManager.c.Ep().ej();
    }

    private static String uN() {
        return com.baidu.adp.lib.asyncTask.a.ek().ej();
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
            str6 = s.uS().dH(str);
        }
        String uK = uK();
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
        fK.p("dnsIP", uK);
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

    public static void c(boolean z, String str) {
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
