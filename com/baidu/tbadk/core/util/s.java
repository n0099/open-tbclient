package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.searchbox.ng.ai.apps.media.chooser.action.ChooseVideoAction;
import com.baidu.searchbox.ng.ai.apps.network.WebSocketAction;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbDomainConfig;
import com.tencent.open.SocialConstants;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class s {
    private static long avV = 0;
    private static long avW = 0;
    private static int avX = 0;
    private static a avY = new a();
    private static r avZ = new r();
    private static r awa = new r();
    private static String awb = null;
    private static Object syncLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int awc;
        boolean awd;
        r awe;
        r awf;
        r awg;
        r awh;
        r awi;
        r awj;
        r awk;
        r awl;
        r awm;
        r awn;
        r awo;
        r awp;
        r awq;
        r awr;
        r aws;

        private a() {
            this.awc = 0;
            this.awe = new r();
            this.awf = new r();
            this.awg = new r();
            this.awh = new r();
            this.awi = new r();
            this.awj = new r();
            this.awk = new r();
            this.awl = new r();
            this.awm = new r();
            this.awn = new r();
            this.awo = new r();
            this.awp = new r();
            this.awq = new r();
            this.awr = new r();
            this.aws = new r();
        }

        public int BL() {
            return this.awe.num + this.awf.num + this.awg.num + this.awh.num + this.awi.num;
        }

        public int BM() {
            return this.awe.num + this.awf.num + this.awg.num + this.awh.num + this.awi.num + this.awj.num + this.awk.num + this.awl.num + this.awm.num + this.awn.num + this.awo.num + this.awp.num + this.awq.num + this.awr.num + this.aws.num;
        }

        public int BN() {
            return this.awj.num + this.awk.num + this.awl.num + this.awm.num + this.awn.num;
        }

        public int BO() {
            return this.awo.num + this.awp.num + this.awq.num + this.awr.num + this.aws.num;
        }

        public void reset() {
            this.awc = 0;
            this.awe.reset();
            this.awf.reset();
            this.awg.reset();
            this.awh.reset();
            this.awi.reset();
            this.awj.reset();
            this.awk.reset();
            this.awl.reset();
            this.awm.reset();
            this.awn.reset();
            this.awo.reset();
            this.awp.reset();
            this.awq.reset();
            this.awr.reset();
            this.aws.reset();
        }
    }

    private static r a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return avY.awe;
            }
            if (str.startsWith("http://tb.himg")) {
                return avY.awf;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return avY.awg;
            }
            if (z2 && z3) {
                return avY.awi;
            }
            return avY.awh;
        } else if (com.baidu.adp.lib.util.j.lc()) {
            if (z2) {
                return avY.awj;
            }
            if (str.startsWith("http://tb.himg")) {
                return avY.awk;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return avY.awl;
            }
            return avY.awm;
        } else if (z2) {
            return avY.awo;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return avY.awp;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return avY.awq;
            }
            return avY.awr;
        }
    }

    public static com.baidu.adp.lib.stats.a jD() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (syncLock) {
                avZ.num++;
                avZ.time += j;
                if (avZ.num >= 100) {
                    BE();
                }
            }
        }
    }

    public static void BE() {
        if (avZ.num > 10) {
            com.baidu.adp.lib.stats.a jD = jD();
            jD.append(SocialConstants.PARAM_ACT, "locStat");
            jD.append("costTime", String.valueOf(avZ.time));
            jD.append("num", String.valueOf(avZ.num));
            jD.append("isWifi", "1");
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jD);
            avZ.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.l.lo() && dVar != null) {
            String str6 = "";
            boolean ii = com.baidu.tbadk.util.i.ii(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().azh) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean kY = com.baidu.adp.lib.util.j.kY();
            if (!z5) {
                z4 = false;
            } else if (kY) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aiW);
            } else if (com.baidu.adp.lib.util.j.lc()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aiY);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aiX);
            }
            boolean z6 = false;
            if (ii && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (ii && kY && z6) {
                if (z) {
                    p.getInstance().insertNormalData(j, str);
                } else {
                    str6 = t.BP().BQ();
                    if (!TextUtils.isEmpty(str6)) {
                        p.getInstance().insertErrorData(dVar.CI, str);
                    }
                }
            }
            if (ii) {
                awb = str;
            }
            boolean z7 = false;
            if (dVar.CK != null && dVar.CK.length() > 0) {
                z7 = true;
            }
            synchronized (syncLock) {
                r a2 = a(kY, ii, str2, z7);
                boolean z8 = avY.awd;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.CC += j2;
                        avY.awd = true;
                        if (z4) {
                            a2.avU++;
                        }
                        avX = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.kX()) {
                            int i2 = avX + 1;
                            avX = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.kq().getMaxAlertCount("alert_img", 5)) {
                                BdStatisticsManager.getInstance().alert("alert_img", "imgFailedCnt_" + String.valueOf(avX) + "_url=" + str2);
                            }
                        }
                        a2.avT++;
                        avY.awd = false;
                    }
                }
                int BM = avY.BM();
                if (BM > 100 || (BM > 0 && z8 != avY.awd)) {
                    BF();
                }
            }
            if (z && z5) {
                if (!kY || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aiW) {
                    if (kY || !com.baidu.adp.lib.util.j.lc() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aiY) {
                        if (!kY && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().aiX) {
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
                aVar = jD();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = t.BP().BQ();
            }
            if (!ii || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = t.BP().fe(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = BH();
            }
            aVar.append("url", str);
            aVar.append(SocialConstants.PARAM_ACT, "dl");
            aVar.append("result", z ? "1" : "0");
            aVar.append("fullurl", str2);
            aVar.append("netlib", String.valueOf(dVar.CO));
            aVar.append("costTime", String.valueOf(j));
            aVar.append("connTime", String.valueOf(dVar.connectTime));
            aVar.append("rspTime", String.valueOf(dVar.CD));
            aVar.append("retry", String.valueOf(dVar.CE));
            aVar.append("localIp", d.getIp());
            aVar.append("tiebaIp", str6);
            aVar.append("cdnIp", str4);
            aVar.append("useIp", dVar.CK);
            aVar.append("dnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.append("connBaidu", String.valueOf(BI()));
            }
            aVar.append("memory", BJ());
            aVar.append(WebSocketAction.PARAM_KEY_TASK, BK());
            aVar.append("status", String.valueOf(dVar.CJ));
            aVar.append("up", String.valueOf(dVar.CB));
            aVar.append("down", String.valueOf(dVar.CC));
            aVar.append("isCDN", ii ? "1" : "0");
            aVar.append("isWebp", bool.booleanValue() ? "1" : "0");
            aVar.append("isMobileProxy", z3 ? "1" : "0");
            aVar.append(com.baidu.fsg.base.statistics.b.k, dVar.CH);
            aVar.append(WebSocketAction.PARAM_KEY_REASON, str3);
            if (i != 0) {
                aVar.f("procType", Integer.valueOf(i));
            }
            if (dVar.CM != null) {
                aVar.append("tracecode1", dVar.CM);
            }
            if (dVar.CN != null) {
                aVar.append("tracecode2", dVar.CN);
            }
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, aVar);
            if (ii && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                avY.awc++;
            }
        }
    }

    public static void BF() {
        if (avY.BM() > 10) {
            if (avY.BL() > 0) {
                a(avY.awe, avY.awf, avY.awg, avY.awi, avY.awh, 10000);
                com.baidu.tbadk.l.k.b(avY.awe, avY.awf, avY.awg, avY.awi, avY.awh, 3);
            }
            if (avY.BO() > 0) {
                a(avY.awo, avY.awp, avY.awq, avY.aws, avY.awr, 100002);
                com.baidu.tbadk.l.k.b(avY.awo, avY.awp, avY.awq, avY.aws, avY.awr, 2);
            }
            if (avY.BN() > 0) {
                a(avY.awj, avY.awk, avY.awl, avY.awn, avY.awm, 100001);
                com.baidu.tbadk.l.k.b(avY.awj, avY.awk, avY.awl, avY.awn, avY.awm, 1);
            }
            avY.reset();
        }
    }

    public static void a(r rVar, r rVar2, r rVar3, r rVar4, r rVar5, int i) {
        if (rVar != null && rVar2 != null && rVar3 != null && rVar4 != null && rVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = t.BP().BQ();
            }
            if (awb != null && TextUtils.isEmpty("")) {
                str2 = t.BP().fe(awb);
            }
            if (TextUtils.isEmpty("")) {
                str3 = BH();
            }
            com.baidu.adp.lib.stats.a jD = jD();
            jD.append(SocialConstants.PARAM_ACT, "dlStat");
            jD.append("cdnCostTime", String.valueOf(rVar.time));
            jD.append("cdnNum", String.valueOf(rVar.num));
            jD.append("cdnFailnum", String.valueOf(rVar.avT));
            jD.append("portraitCostTime", String.valueOf(rVar2.time));
            jD.append("portraitNum", String.valueOf(rVar2.num));
            jD.append("portraitFailnum", String.valueOf(rVar2.avT));
            jD.append("tiebaCostTime", String.valueOf(rVar3.time));
            jD.append("tiebaNum", String.valueOf(rVar3.num));
            jD.append("tiebaFailnum", String.valueOf(rVar3.avT));
            jD.append("otherCostTime", String.valueOf(rVar5.time));
            jD.append("otherNum", String.valueOf(rVar5.num));
            jD.append("otherFailnum", String.valueOf(rVar5.avT));
            jD.append("directIpCostTime", String.valueOf(rVar4.time));
            jD.append("directIpNum", String.valueOf(rVar4.num));
            jD.append("directIpFailnum", String.valueOf(rVar4.avT));
            jD.append("dnsFailNum", String.valueOf(avY.awc));
            if (10000 == i) {
                jD.append("isWifi", "1");
                jD.append("netType", "WIFI");
            } else if (100002 == i) {
                jD.append("netType", "3G");
                jD.append("isWifi", "0");
            } else {
                jD.append("netType", "2G");
                jD.append("isWifi", "0");
            }
            jD.append("localIp", d.getIp());
            jD.append("tbIp", str);
            jD.append("cdnIp", str2);
            jD.append("dnsIp", str3);
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jD);
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.l.lo()) {
            synchronized (syncLock) {
                awa.num++;
                if (z) {
                    awa.time += j;
                } else {
                    awa.avT++;
                }
                if (awa.num >= 100) {
                    BG();
                }
            }
            if (!z) {
                if (aVar == null) {
                    aVar = jD();
                }
                aVar.append(SocialConstants.PARAM_ACT, "dc");
                aVar.append("costTime", String.valueOf(j));
                aVar.append("url", str);
                aVar.append("fullURL", str2);
                aVar.append("isWebp", z3 ? "1" : "0");
                aVar.append("isCDN", z2 ? "1" : "0");
                aVar.append("length", String.valueOf(i));
                aVar.append(WebSocketAction.PARAM_KEY_REASON, str3);
                aVar.append("result", z ? "0" : "1");
                aVar.append("execption", str4);
                BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, aVar);
            }
        }
    }

    public static void BG() {
        if (awa.num > 10) {
            com.baidu.adp.lib.stats.a jD = jD();
            jD.append(SocialConstants.PARAM_ACT, "dcStat");
            jD.append("costTime", String.valueOf(awa.time));
            jD.append("num", String.valueOf(awa.num));
            jD.append("failnum", String.valueOf(awa.avT));
            BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jD);
            com.baidu.tbadk.l.k.a(awa.num, awa.avT, awa.time);
            awa.reset();
        }
    }

    public static void fd(String str) {
        com.baidu.adp.lib.stats.a jD = jD();
        jD.append(SocialConstants.PARAM_ACT, "assistant");
        jD.append("content", str);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jD);
    }

    private static String BH() {
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
    private static long BI() {
        HttpURLConnection httpURLConnection;
        long j;
        if (avV >= 3) {
            return avW;
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
            if (avV > -1) {
                avW = ((avW * avV) + j) / (avV + 1);
            } else {
                avW = j;
            }
            avV++;
            return j;
        }
        return j;
    }

    private static String BJ() {
        return com.baidu.tbadk.imageManager.c.Me().ic();
    }

    private static String BK() {
        return com.baidu.adp.lib.asyncTask.a.id().ic();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.a jD = jD();
        jD.append(SocialConstants.PARAM_ACT, "getCDNList");
        jD.append("errorNum", str);
        jD.append("errorMsg", str2);
        jD.append("isShortNetError", z2 ? "1" : "0");
        jD.append("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jD);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = t.BP().fe(str);
        }
        String BH = BH();
        String ip = d.getIp();
        com.baidu.adp.lib.stats.a jD = jD();
        jD.append(SocialConstants.PARAM_ACT, "tachometerCDN");
        jD.append("errorNum", str3);
        jD.append("execption", str4);
        jD.append(ChooseVideoAction.CB_KEY_SIZE, str5);
        jD.append("isScuess", z ? "1" : "0");
        jD.append("url", str);
        jD.append("localIp", ip);
        jD.append("cdnIp", str6);
        jD.append("dnsIP", BH);
        jD.append("usedIp", str2);
        jD.append("isUsedIp", z2 ? "0" : "1");
        jD.append("costTime", String.valueOf(j));
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jD);
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
                    com.baidu.adp.lib.stats.a jD = jD();
                    jD.append(SocialConstants.PARAM_ACT, "mobileTachometerCDN");
                    jD.append("costTime", String.valueOf(j));
                    jD.append("ipList", sb.toString());
                    BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jD);
                    return;
                }
            }
        }
    }

    public static void c(boolean z, String str) {
        com.baidu.adp.lib.stats.a jD = jD();
        jD.append(SocialConstants.PARAM_ACT, "getCDNList");
        jD.append("isSuccess", z ? "1" : "0");
        jD.append("errorMsg", str);
        BdStatisticsManager.getInstance().debug(SocialConstants.PARAM_IMG_URL, jD);
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
