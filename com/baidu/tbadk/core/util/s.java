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
public class s {
    private static long arf = 0;
    private static long arg = 0;
    private static int arh = 0;
    private static a ari = new a();
    private static r arj = new r();
    private static r ark = new r();
    private static String arl = null;
    private static Object syncLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        r arA;
        r arB;
        r arC;
        int arm;
        boolean arn;
        r aro;
        r arp;
        r arq;
        r arr;
        r ars;
        r art;
        r aru;
        r arv;
        r arw;
        r arx;
        r ary;
        r arz;

        private a() {
            this.arm = 0;
            this.aro = new r();
            this.arp = new r();
            this.arq = new r();
            this.arr = new r();
            this.ars = new r();
            this.art = new r();
            this.aru = new r();
            this.arv = new r();
            this.arw = new r();
            this.arx = new r();
            this.ary = new r();
            this.arz = new r();
            this.arA = new r();
            this.arB = new r();
            this.arC = new r();
        }

        public int zE() {
            return this.aro.num + this.arp.num + this.arq.num + this.arr.num + this.ars.num;
        }

        public int zF() {
            return this.aro.num + this.arp.num + this.arq.num + this.arr.num + this.ars.num + this.art.num + this.aru.num + this.arv.num + this.arw.num + this.arx.num + this.ary.num + this.arz.num + this.arA.num + this.arB.num + this.arC.num;
        }

        public int zG() {
            return this.art.num + this.aru.num + this.arv.num + this.arw.num + this.arx.num;
        }

        public int zH() {
            return this.ary.num + this.arz.num + this.arA.num + this.arB.num + this.arC.num;
        }

        public void reset() {
            this.arm = 0;
            this.aro.reset();
            this.arp.reset();
            this.arq.reset();
            this.arr.reset();
            this.ars.reset();
            this.art.reset();
            this.aru.reset();
            this.arv.reset();
            this.arw.reset();
            this.arx.reset();
            this.ary.reset();
            this.arz.reset();
            this.arA.reset();
            this.arB.reset();
            this.arC.reset();
        }
    }

    private static r a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return ari.aro;
            }
            if (str.startsWith("http://tb.himg")) {
                return ari.arp;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return ari.arq;
            }
            if (z2 && z3) {
                return ari.ars;
            }
            return ari.arr;
        } else if (com.baidu.adp.lib.util.j.kP()) {
            if (z2) {
                return ari.art;
            }
            if (str.startsWith("http://tb.himg")) {
                return ari.aru;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return ari.arv;
            }
            return ari.arw;
        } else if (z2) {
            return ari.ary;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return ari.arz;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return ari.arA;
            }
            return ari.arB;
        }
    }

    public static com.baidu.adp.lib.stats.a jo() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (syncLock) {
                arj.num++;
                arj.time += j;
                if (arj.num >= 100) {
                    zx();
                }
            }
        }
    }

    public static void zx() {
        if (arj.num > 10) {
            com.baidu.adp.lib.stats.a jo = jo();
            jo.append(SocialConstants.PARAM_ACT, "locStat");
            jo.append("costTime", String.valueOf(arj.time));
            jo.append("num", String.valueOf(arj.num));
            jo.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jo);
            arj.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.l.lb() && dVar != null) {
            String str6 = "";
            boolean hT = com.baidu.tbadk.util.i.hT(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().auw) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean kL = com.baidu.adp.lib.util.j.kL();
            if (!z5) {
                z4 = false;
            } else if (kL) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().adZ);
            } else if (com.baidu.adp.lib.util.j.kP()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aeb);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aea);
            }
            boolean z6 = false;
            if (hT && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (hT && kL && z6) {
                if (z) {
                    p.getInstance().insertNormalData(j, str);
                } else {
                    str6 = t.zI().zJ();
                    if (!TextUtils.isEmpty(str6)) {
                        p.getInstance().insertErrorData(dVar.Ca, str);
                    }
                }
            }
            if (hT) {
                arl = str;
            }
            boolean z7 = false;
            if (dVar.Cc != null && dVar.Cc.length() > 0) {
                z7 = true;
            }
            synchronized (syncLock) {
                r a2 = a(kL, hT, str2, z7);
                boolean z8 = ari.arn;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.BU += j2;
                        ari.arn = true;
                        if (z4) {
                            a2.are++;
                        }
                        arh = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.kK()) {
                            int i2 = arh + 1;
                            arh = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.kc().getMaxAlertCount("alert_img", 5)) {
                                BdStatisticsManager.getInstance().alert("alert_img", "imgFailedCnt_" + String.valueOf(arh) + "_url=" + str2);
                            }
                        }
                        a2.ard++;
                        ari.arn = false;
                    }
                }
                int zF = ari.zF();
                if (zF > 100 || (zF > 0 && z8 != ari.arn)) {
                    zy();
                }
            }
            if (z && z5) {
                if (!kL || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().adZ) {
                    if (kL || !com.baidu.adp.lib.util.j.kP() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aeb) {
                        if (!kL && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aea) {
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
                aVar = jo();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = t.zI().zJ();
            }
            if (!hT || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = t.zI().eP(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = zA();
            }
            aVar.append("url", str);
            aVar.append(SocialConstants.PARAM_ACT, "dl");
            aVar.append("result", z ? "1" : "0");
            aVar.append("fullurl", str2);
            aVar.append("netlib", String.valueOf(dVar.Cg));
            aVar.append("costTime", String.valueOf(j));
            aVar.append("connTime", String.valueOf(dVar.connectTime));
            aVar.append("rspTime", String.valueOf(dVar.BV));
            aVar.append("retry", String.valueOf(dVar.BW));
            aVar.append("localIp", d.getIp());
            aVar.append("tiebaIp", str6);
            aVar.append("cdnIp", str4);
            aVar.append("useIp", dVar.Cc);
            aVar.append("dnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.append("connBaidu", String.valueOf(zB()));
            }
            aVar.append("memory", zC());
            aVar.append("task", zD());
            aVar.append(NotificationCompat.CATEGORY_STATUS, String.valueOf(dVar.Cb));
            aVar.append("up", String.valueOf(dVar.BT));
            aVar.append("down", String.valueOf(dVar.BU));
            aVar.append("isCDN", hT ? "1" : "0");
            aVar.append("isWebp", bool.booleanValue() ? "1" : "0");
            aVar.append("isMobileProxy", z3 ? "1" : "0");
            aVar.append(com.baidu.fsg.base.statistics.b.k, dVar.BZ);
            aVar.append("reason", str3);
            if (i != 0) {
                aVar.f("procType", Integer.valueOf(i));
            }
            if (dVar.Ce != null) {
                aVar.append("tracecode1", dVar.Ce);
            }
            if (dVar.Cf != null) {
                aVar.append("tracecode2", dVar.Cf);
            }
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, aVar);
            if (hT && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                ari.arm++;
            }
        }
    }

    public static void zy() {
        if (ari.zF() > 10) {
            if (ari.zE() > 0) {
                a(ari.aro, ari.arp, ari.arq, ari.ars, ari.arr, 10000);
                com.baidu.tbadk.l.k.b(ari.aro, ari.arp, ari.arq, ari.ars, ari.arr, 3);
            }
            if (ari.zH() > 0) {
                a(ari.ary, ari.arz, ari.arA, ari.arC, ari.arB, 100002);
                com.baidu.tbadk.l.k.b(ari.ary, ari.arz, ari.arA, ari.arC, ari.arB, 2);
            }
            if (ari.zG() > 0) {
                a(ari.art, ari.aru, ari.arv, ari.arx, ari.arw, 100001);
                com.baidu.tbadk.l.k.b(ari.art, ari.aru, ari.arv, ari.arx, ari.arw, 1);
            }
            ari.reset();
        }
    }

    public static void a(r rVar, r rVar2, r rVar3, r rVar4, r rVar5, int i) {
        if (rVar != null && rVar2 != null && rVar3 != null && rVar4 != null && rVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = t.zI().zJ();
            }
            if (arl != null && TextUtils.isEmpty("")) {
                str2 = t.zI().eP(arl);
            }
            if (TextUtils.isEmpty("")) {
                str3 = zA();
            }
            com.baidu.adp.lib.stats.a jo = jo();
            jo.append(SocialConstants.PARAM_ACT, "dlStat");
            jo.append("cdnCostTime", String.valueOf(rVar.time));
            jo.append("cdnNum", String.valueOf(rVar.num));
            jo.append("cdnFailnum", String.valueOf(rVar.ard));
            jo.append("portraitCostTime", String.valueOf(rVar2.time));
            jo.append("portraitNum", String.valueOf(rVar2.num));
            jo.append("portraitFailnum", String.valueOf(rVar2.ard));
            jo.append("tiebaCostTime", String.valueOf(rVar3.time));
            jo.append("tiebaNum", String.valueOf(rVar3.num));
            jo.append("tiebaFailnum", String.valueOf(rVar3.ard));
            jo.append("otherCostTime", String.valueOf(rVar5.time));
            jo.append("otherNum", String.valueOf(rVar5.num));
            jo.append("otherFailnum", String.valueOf(rVar5.ard));
            jo.append("directIpCostTime", String.valueOf(rVar4.time));
            jo.append("directIpNum", String.valueOf(rVar4.num));
            jo.append("directIpFailnum", String.valueOf(rVar4.ard));
            jo.append("dnsFailNum", String.valueOf(ari.arm));
            if (10000 == i) {
                jo.append("isWifi", "1");
                jo.append("netType", "WIFI");
            } else if (100002 == i) {
                jo.append("netType", "3G");
                jo.append("isWifi", "0");
            } else {
                jo.append("netType", "2G");
                jo.append("isWifi", "0");
            }
            jo.append("localIp", d.getIp());
            jo.append("tbIp", str);
            jo.append("cdnIp", str2);
            jo.append("dnsIp", str3);
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jo);
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.l.lb()) {
            synchronized (syncLock) {
                ark.num++;
                if (z) {
                    ark.time += j;
                } else {
                    ark.ard++;
                }
                if (ark.num >= 100) {
                    zz();
                }
            }
            if (!z) {
                if (aVar == null) {
                    aVar = jo();
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

    public static void zz() {
        if (ark.num > 10) {
            com.baidu.adp.lib.stats.a jo = jo();
            jo.append(SocialConstants.PARAM_ACT, "dcStat");
            jo.append("costTime", String.valueOf(ark.time));
            jo.append("num", String.valueOf(ark.num));
            jo.append("failnum", String.valueOf(ark.ard));
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jo);
            com.baidu.tbadk.l.k.a(ark.num, ark.ard, ark.time);
            ark.reset();
        }
    }

    public static void eO(String str) {
        com.baidu.adp.lib.stats.a jo = jo();
        jo.append(SocialConstants.PARAM_ACT, "assistant");
        jo.append("content", str);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jo);
    }

    private static String zA() {
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
    private static long zB() {
        HttpURLConnection httpURLConnection;
        long j;
        if (arf >= 3) {
            return arg;
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
            if (arf > -1) {
                arg = ((arg * arf) + j) / (arf + 1);
            } else {
                arg = j;
            }
            arf++;
            return j;
        }
        return j;
    }

    private static String zC() {
        return com.baidu.tbadk.imageManager.c.Kg().hN();
    }

    private static String zD() {
        return com.baidu.adp.lib.asyncTask.a.hO().hN();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.a jo = jo();
        jo.append(SocialConstants.PARAM_ACT, "getCDNList");
        jo.append("errorNum", str);
        jo.append("errorMsg", str2);
        jo.append("isShortNetError", z2 ? "1" : "0");
        jo.append("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jo);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = t.zI().eP(str);
        }
        String zA = zA();
        String ip = d.getIp();
        com.baidu.adp.lib.stats.a jo = jo();
        jo.append(SocialConstants.PARAM_ACT, "tachometerCDN");
        jo.append("errorNum", str3);
        jo.append("execption", str4);
        jo.append("size", str5);
        jo.append("isScuess", z ? "1" : "0");
        jo.append("url", str);
        jo.append("localIp", ip);
        jo.append("cdnIp", str6);
        jo.append("dnsIP", zA);
        jo.append("usedIp", str2);
        jo.append("isUsedIp", z2 ? "0" : "1");
        jo.append("costTime", String.valueOf(j));
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jo);
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
                    com.baidu.adp.lib.stats.a jo = jo();
                    jo.append(SocialConstants.PARAM_ACT, "mobileTachometerCDN");
                    jo.append("costTime", String.valueOf(j));
                    jo.append("ipList", sb.toString());
                    BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jo);
                    return;
                }
            }
        }
    }

    public static void c(boolean z, String str) {
        com.baidu.adp.lib.stats.a jo = jo();
        jo.append(SocialConstants.PARAM_ACT, "getCDNList");
        jo.append("isSuccess", z ? "1" : "0");
        jo.append("errorMsg", str);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jo);
    }

    public static void b(String str, int i, int i2, int i3) {
        if (i == -1) {
            i = 0;
        }
        if (i2 == -1) {
            i2 = 0;
        }
        BdStatisticsManager.getInstance().eventStat(null, str, "imgHttpSwitch", 1, "1sterrcode", String.valueOf(i), "2nderrcode", String.valueOf(i2), "2imgFailed", String.valueOf(i3));
    }
}
