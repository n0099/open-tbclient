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
    private static long apf = 0;
    private static long apg = 0;
    private static int aph = 0;
    private static a api = new a();
    private static s apj = new s();
    private static s apk = new s();
    private static String apl = null;
    private static Object syncLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        s apA;
        s apB;
        s apC;
        s apD;
        int apm;
        boolean apn;
        s apo;
        s apq;
        s apr;
        s aps;
        s apt;
        s apu;
        s apv;
        s apw;
        s apx;
        s apy;
        s apz;

        private a() {
            this.apm = 0;
            this.apo = new s();
            this.apq = new s();
            this.apr = new s();
            this.aps = new s();
            this.apt = new s();
            this.apu = new s();
            this.apv = new s();
            this.apw = new s();
            this.apx = new s();
            this.apy = new s();
            this.apz = new s();
            this.apA = new s();
            this.apB = new s();
            this.apC = new s();
            this.apD = new s();
        }

        public int yK() {
            return this.apo.num + this.apq.num + this.apr.num + this.aps.num + this.apt.num;
        }

        public int yL() {
            return this.apo.num + this.apq.num + this.apr.num + this.aps.num + this.apt.num + this.apu.num + this.apv.num + this.apw.num + this.apx.num + this.apy.num + this.apz.num + this.apA.num + this.apB.num + this.apC.num + this.apD.num;
        }

        public int yM() {
            return this.apu.num + this.apv.num + this.apw.num + this.apx.num + this.apy.num;
        }

        public int yN() {
            return this.apz.num + this.apA.num + this.apB.num + this.apC.num + this.apD.num;
        }

        public void reset() {
            this.apm = 0;
            this.apo.reset();
            this.apq.reset();
            this.apr.reset();
            this.aps.reset();
            this.apt.reset();
            this.apu.reset();
            this.apv.reset();
            this.apw.reset();
            this.apx.reset();
            this.apy.reset();
            this.apz.reset();
            this.apA.reset();
            this.apB.reset();
            this.apC.reset();
            this.apD.reset();
        }
    }

    private static s a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return api.apo;
            }
            if (str.startsWith("http://tb.himg")) {
                return api.apq;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return api.apr;
            }
            if (z2 && z3) {
                return api.apt;
            }
            return api.aps;
        } else if (com.baidu.adp.lib.util.j.jI()) {
            if (z2) {
                return api.apu;
            }
            if (str.startsWith("http://tb.himg")) {
                return api.apv;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return api.apw;
            }
            return api.apx;
        } else if (z2) {
            return api.apz;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return api.apA;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return api.apB;
            }
            return api.apC;
        }
    }

    public static com.baidu.adp.lib.stats.a ih() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (syncLock) {
                apj.num++;
                apj.time += j;
                if (apj.num >= 100) {
                    yD();
                }
            }
        }
    }

    public static void yD() {
        if (apj.num > 10) {
            com.baidu.adp.lib.stats.a ih = ih();
            ih.append(SocialConstants.PARAM_ACT, "locStat");
            ih.append("costTime", String.valueOf(apj.time));
            ih.append("num", String.valueOf(apj.num));
            ih.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, ih);
            apj.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.l.jU() && dVar != null) {
            String str6 = "";
            boolean hz = com.baidu.tbadk.util.i.hz(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().asu) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean jE = com.baidu.adp.lib.util.j.jE();
            if (!z5) {
                z4 = false;
            } else if (jE) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().abS);
            } else if (com.baidu.adp.lib.util.j.jI()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().abU);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().abT);
            }
            boolean z6 = false;
            if (hz && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (hz && jE && z6) {
                if (z) {
                    q.getInstance().insertNormalData(j, str);
                } else {
                    str6 = u.yO().yP();
                    if (!TextUtils.isEmpty(str6)) {
                        q.getInstance().insertErrorData(dVar.zJ, str);
                    }
                }
            }
            if (hz) {
                apl = str;
            }
            boolean z7 = false;
            if (dVar.zL != null && dVar.zL.length() > 0) {
                z7 = true;
            }
            synchronized (syncLock) {
                s a2 = a(jE, hz, str2, z7);
                boolean z8 = api.apn;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.zD += j2;
                        api.apn = true;
                        if (z4) {
                            a2.ape++;
                        }
                        aph = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.jD()) {
                            int i2 = aph + 1;
                            aph = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.iV().getMaxAlertCount("alert_img", 5)) {
                                BdStatisticsManager.getInstance().alert("alert_img", "imgFailedCnt_" + String.valueOf(aph) + "_url=" + str2);
                            }
                        }
                        a2.apd++;
                        api.apn = false;
                    }
                }
                int yL = api.yL();
                if (yL > 100 || (yL > 0 && z8 != api.apn)) {
                    yE();
                }
            }
            if (z && z5) {
                if (!jE || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().abS) {
                    if (jE || !com.baidu.adp.lib.util.j.jI() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().abU) {
                        if (!jE && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().abT) {
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
                str6 = u.yO().yP();
            }
            if (!hz || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = u.yO().ez(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = yG();
            }
            aVar.append("url", str);
            aVar.append(SocialConstants.PARAM_ACT, "dl");
            aVar.append("result", z ? "1" : "0");
            aVar.append("fullurl", str2);
            aVar.append("netlib", String.valueOf(dVar.zP));
            aVar.append("costTime", String.valueOf(j));
            aVar.append("connTime", String.valueOf(dVar.connectTime));
            aVar.append("rspTime", String.valueOf(dVar.zE));
            aVar.append("retry", String.valueOf(dVar.zF));
            aVar.append("localIp", d.getIp());
            aVar.append("tiebaIp", str6);
            aVar.append("cdnIp", str4);
            aVar.append("useIp", dVar.zL);
            aVar.append("dnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.append("connBaidu", String.valueOf(yH()));
            }
            aVar.append("memory", yI());
            aVar.append("task", yJ());
            aVar.append(NotificationCompat.CATEGORY_STATUS, String.valueOf(dVar.zK));
            aVar.append("up", String.valueOf(dVar.zC));
            aVar.append("down", String.valueOf(dVar.zD));
            aVar.append("isCDN", hz ? "1" : "0");
            aVar.append("isWebp", bool.booleanValue() ? "1" : "0");
            aVar.append("isMobileProxy", z3 ? "1" : "0");
            aVar.append(com.baidu.fsg.base.statistics.b.k, dVar.zI);
            aVar.append("reason", str3);
            if (i != 0) {
                aVar.f("procType", Integer.valueOf(i));
            }
            if (dVar.zN != null) {
                aVar.append("tracecode1", dVar.zN);
            }
            if (dVar.zO != null) {
                aVar.append("tracecode2", dVar.zO);
            }
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, aVar);
            if (hz && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                api.apm++;
            }
        }
    }

    public static void yE() {
        if (api.yL() > 10) {
            if (api.yK() > 0) {
                a(api.apo, api.apq, api.apr, api.apt, api.aps, 10000);
                com.baidu.tbadk.k.k.b(api.apo, api.apq, api.apr, api.apt, api.aps, 3);
            }
            if (api.yN() > 0) {
                a(api.apz, api.apA, api.apB, api.apD, api.apC, 100002);
                com.baidu.tbadk.k.k.b(api.apz, api.apA, api.apB, api.apD, api.apC, 2);
            }
            if (api.yM() > 0) {
                a(api.apu, api.apv, api.apw, api.apy, api.apx, 100001);
                com.baidu.tbadk.k.k.b(api.apu, api.apv, api.apw, api.apy, api.apx, 1);
            }
            api.reset();
        }
    }

    public static void a(s sVar, s sVar2, s sVar3, s sVar4, s sVar5, int i) {
        if (sVar != null && sVar2 != null && sVar3 != null && sVar4 != null && sVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = u.yO().yP();
            }
            if (apl != null && TextUtils.isEmpty("")) {
                str2 = u.yO().ez(apl);
            }
            if (TextUtils.isEmpty("")) {
                str3 = yG();
            }
            com.baidu.adp.lib.stats.a ih = ih();
            ih.append(SocialConstants.PARAM_ACT, "dlStat");
            ih.append("cdnCostTime", String.valueOf(sVar.time));
            ih.append("cdnNum", String.valueOf(sVar.num));
            ih.append("cdnFailnum", String.valueOf(sVar.apd));
            ih.append("portraitCostTime", String.valueOf(sVar2.time));
            ih.append("portraitNum", String.valueOf(sVar2.num));
            ih.append("portraitFailnum", String.valueOf(sVar2.apd));
            ih.append("tiebaCostTime", String.valueOf(sVar3.time));
            ih.append("tiebaNum", String.valueOf(sVar3.num));
            ih.append("tiebaFailnum", String.valueOf(sVar3.apd));
            ih.append("otherCostTime", String.valueOf(sVar5.time));
            ih.append("otherNum", String.valueOf(sVar5.num));
            ih.append("otherFailnum", String.valueOf(sVar5.apd));
            ih.append("directIpCostTime", String.valueOf(sVar4.time));
            ih.append("directIpNum", String.valueOf(sVar4.num));
            ih.append("directIpFailnum", String.valueOf(sVar4.apd));
            ih.append("dnsFailNum", String.valueOf(api.apm));
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
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, ih);
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.l.jU()) {
            synchronized (syncLock) {
                apk.num++;
                if (z) {
                    apk.time += j;
                } else {
                    apk.apd++;
                }
                if (apk.num >= 100) {
                    yF();
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
                BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, aVar);
            }
        }
    }

    public static void yF() {
        if (apk.num > 10) {
            com.baidu.adp.lib.stats.a ih = ih();
            ih.append(SocialConstants.PARAM_ACT, "dcStat");
            ih.append("costTime", String.valueOf(apk.time));
            ih.append("num", String.valueOf(apk.num));
            ih.append("failnum", String.valueOf(apk.apd));
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, ih);
            com.baidu.tbadk.k.k.a(apk.num, apk.apd, apk.time);
            apk.reset();
        }
    }

    public static void ey(String str) {
        com.baidu.adp.lib.stats.a ih = ih();
        ih.append(SocialConstants.PARAM_ACT, "assistant");
        ih.append("content", str);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, ih);
    }

    private static String yG() {
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
    private static long yH() {
        HttpURLConnection httpURLConnection;
        long j;
        if (apf >= 3) {
            return apg;
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
            if (apf > -1) {
                apg = ((apg * apf) + j) / (apf + 1);
            } else {
                apg = j;
            }
            apf++;
            return j;
        }
        return j;
    }

    private static String yI() {
        return com.baidu.tbadk.imageManager.c.IV().gI();
    }

    private static String yJ() {
        return com.baidu.adp.lib.asyncTask.a.gJ().gI();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.a ih = ih();
        ih.append(SocialConstants.PARAM_ACT, "getCDNList");
        ih.append("errorNum", str);
        ih.append("errorMsg", str2);
        ih.append("isShortNetError", z2 ? "1" : "0");
        ih.append("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, ih);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = u.yO().ez(str);
        }
        String yG = yG();
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
        ih.append("dnsIP", yG);
        ih.append("usedIp", str2);
        ih.append("isUsedIp", z2 ? "0" : "1");
        ih.append("costTime", String.valueOf(j));
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, ih);
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
                    BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, ih);
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
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, ih);
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
