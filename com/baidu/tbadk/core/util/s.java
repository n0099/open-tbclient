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
    private static long aeV = 0;
    private static long aeW = 0;
    private static int aeX = 0;
    private static a aeY = new a();
    private static r aeZ = new r();
    private static r afa = new r();
    private static String afb = null;
    private static Object syncLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int afc;
        boolean afd;
        r afe;
        r aff;
        r afg;
        r afh;
        r afi;
        r afj;
        r afk;
        r afl;
        r afm;
        r afn;
        r afo;
        r afp;
        r afq;
        r afr;
        r afs;

        private a() {
            this.afc = 0;
            this.afe = new r();
            this.aff = new r();
            this.afg = new r();
            this.afh = new r();
            this.afi = new r();
            this.afj = new r();
            this.afk = new r();
            this.afl = new r();
            this.afm = new r();
            this.afn = new r();
            this.afo = new r();
            this.afp = new r();
            this.afq = new r();
            this.afr = new r();
            this.afs = new r();
        }

        public int uA() {
            return this.afe.num + this.aff.num + this.afg.num + this.afh.num + this.afi.num;
        }

        public int uB() {
            return this.afe.num + this.aff.num + this.afg.num + this.afh.num + this.afi.num + this.afj.num + this.afk.num + this.afl.num + this.afm.num + this.afn.num + this.afo.num + this.afp.num + this.afq.num + this.afr.num + this.afs.num;
        }

        public int uC() {
            return this.afj.num + this.afk.num + this.afl.num + this.afm.num + this.afn.num;
        }

        public int uD() {
            return this.afo.num + this.afp.num + this.afq.num + this.afr.num + this.afs.num;
        }

        public void reset() {
            this.afc = 0;
            this.afe.reset();
            this.aff.reset();
            this.afg.reset();
            this.afh.reset();
            this.afi.reset();
            this.afj.reset();
            this.afk.reset();
            this.afl.reset();
            this.afm.reset();
            this.afn.reset();
            this.afo.reset();
            this.afp.reset();
            this.afq.reset();
            this.afr.reset();
            this.afs.reset();
        }
    }

    private static r a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return aeY.afe;
            }
            if (str.startsWith("http://tb.himg")) {
                return aeY.aff;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aeY.afg;
            }
            if (z2 && z3) {
                return aeY.afi;
            }
            return aeY.afh;
        } else if (com.baidu.adp.lib.util.j.hm()) {
            if (z2) {
                return aeY.afj;
            }
            if (str.startsWith("http://tb.himg")) {
                return aeY.afk;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aeY.afl;
            }
            return aeY.afm;
        } else if (z2) {
            return aeY.afo;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return aeY.afp;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aeY.afq;
            }
            return aeY.afr;
        }
    }

    public static com.baidu.adp.lib.stats.a fK() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (syncLock) {
                aeZ.num++;
                aeZ.time += j;
                if (aeZ.num >= 100) {
                    ut();
                }
            }
        }
    }

    public static void ut() {
        if (aeZ.num > 10) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("act", "locStat");
            fK.p("costTime", String.valueOf(aeZ.time));
            fK.p("num", String.valueOf(aeZ.num));
            fK.p("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", fK);
            aeZ.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.l.hy() && dVar != null) {
            String str6 = "";
            boolean gE = com.baidu.tbadk.util.h.gE(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().ahR) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean hi = com.baidu.adp.lib.util.j.hi();
            if (!z5) {
                z4 = false;
            } else if (hi) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().RQ);
            } else if (com.baidu.adp.lib.util.j.hm()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().RS);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().RR);
            }
            boolean z6 = false;
            if (gE && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (gE && hi && z6) {
                if (z) {
                    p.getInstance().insertNormalData(j, str);
                } else {
                    str6 = t.uE().uF();
                    if (!TextUtils.isEmpty(str6)) {
                        p.getInstance().insertErrorData(dVar.uY, str);
                    }
                }
            }
            if (gE) {
                afb = str;
            }
            boolean z7 = false;
            if (dVar.va != null && dVar.va.length() > 0) {
                z7 = true;
            }
            synchronized (syncLock) {
                r a2 = a(hi, gE, str2, z7);
                boolean z8 = aeY.afd;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.uS += j2;
                        aeY.afd = true;
                        if (z4) {
                            a2.aeU++;
                        }
                        aeX = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.hh()) {
                            int i2 = aeX + 1;
                            aeX = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.gz().getMaxAlertCount("alert_img", 5)) {
                                BdStatisticsManager.getInstance().alert("alert_img", "imgFailedCnt_" + String.valueOf(aeX) + "_url=" + str2);
                            }
                        }
                        a2.aeT++;
                        aeY.afd = false;
                    }
                }
                int uB = aeY.uB();
                if (uB > 100 || (uB > 0 && z8 != aeY.afd)) {
                    uu();
                }
            }
            if (z && z5) {
                if (!hi || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().RQ) {
                    if (hi || !com.baidu.adp.lib.util.j.hm() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().RS) {
                        if (!hi && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().RR) {
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
            if (!gE || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = t.uE().dB(str);
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
            aVar.p("netlib", String.valueOf(dVar.ve));
            aVar.p("costTime", String.valueOf(j));
            aVar.p("connTime", String.valueOf(dVar.connectTime));
            aVar.p("rspTime", String.valueOf(dVar.uT));
            aVar.p("retry", String.valueOf(dVar.uU));
            aVar.p("localIp", d.getIp());
            aVar.p("tiebaIp", str6);
            aVar.p("cdnIp", str4);
            aVar.p("useIp", dVar.va);
            aVar.p("dnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.p("connBaidu", String.valueOf(ux()));
            }
            aVar.p("memory", uy());
            aVar.p("task", uz());
            aVar.p("status", String.valueOf(dVar.uZ));
            aVar.p("up", String.valueOf(dVar.uR));
            aVar.p("down", String.valueOf(dVar.uS));
            aVar.p("isCDN", gE ? "1" : "0");
            aVar.p("isWebp", bool.booleanValue() ? "1" : "0");
            aVar.p("isMobileProxy", z3 ? "1" : "0");
            aVar.p("exception", dVar.uX);
            aVar.p("reason", str3);
            if (i != 0) {
                aVar.c("procType", Integer.valueOf(i));
            }
            if (dVar.vc != null) {
                aVar.p("tracecode1", dVar.vc);
            }
            if (dVar.vd != null) {
                aVar.p("tracecode2", dVar.vd);
            }
            BdStatisticsManager.getInstance().debug("img", aVar);
            if (gE && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                aeY.afc++;
            }
        }
    }

    public static void uu() {
        if (aeY.uB() > 10) {
            if (aeY.uA() > 0) {
                a(aeY.afe, aeY.aff, aeY.afg, aeY.afi, aeY.afh, 10000);
                com.baidu.tbadk.k.o.b(aeY.afe, aeY.aff, aeY.afg, aeY.afi, aeY.afh, 3);
            }
            if (aeY.uD() > 0) {
                a(aeY.afo, aeY.afp, aeY.afq, aeY.afs, aeY.afr, 100002);
                com.baidu.tbadk.k.o.b(aeY.afo, aeY.afp, aeY.afq, aeY.afs, aeY.afr, 2);
            }
            if (aeY.uC() > 0) {
                a(aeY.afj, aeY.afk, aeY.afl, aeY.afn, aeY.afm, 100001);
                com.baidu.tbadk.k.o.b(aeY.afj, aeY.afk, aeY.afl, aeY.afn, aeY.afm, 1);
            }
            aeY.reset();
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
            if (afb != null && TextUtils.isEmpty("")) {
                str2 = t.uE().dB(afb);
            }
            if (TextUtils.isEmpty("")) {
                str3 = uw();
            }
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("act", "dlStat");
            fK.p("cdnCostTime", String.valueOf(rVar.time));
            fK.p("cdnNum", String.valueOf(rVar.num));
            fK.p("cdnFailnum", String.valueOf(rVar.aeT));
            fK.p("portraitCostTime", String.valueOf(rVar2.time));
            fK.p("portraitNum", String.valueOf(rVar2.num));
            fK.p("portraitFailnum", String.valueOf(rVar2.aeT));
            fK.p("tiebaCostTime", String.valueOf(rVar3.time));
            fK.p("tiebaNum", String.valueOf(rVar3.num));
            fK.p("tiebaFailnum", String.valueOf(rVar3.aeT));
            fK.p("otherCostTime", String.valueOf(rVar5.time));
            fK.p("otherNum", String.valueOf(rVar5.num));
            fK.p("otherFailnum", String.valueOf(rVar5.aeT));
            fK.p("directIpCostTime", String.valueOf(rVar4.time));
            fK.p("directIpNum", String.valueOf(rVar4.num));
            fK.p("directIpFailnum", String.valueOf(rVar4.aeT));
            fK.p("dnsFailNum", String.valueOf(aeY.afc));
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
                afa.num++;
                if (z) {
                    afa.time += j;
                } else {
                    afa.aeT++;
                }
                if (afa.num >= 100) {
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
        if (afa.num > 10) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("act", "dcStat");
            fK.p("costTime", String.valueOf(afa.time));
            fK.p("num", String.valueOf(afa.num));
            fK.p("failnum", String.valueOf(afa.aeT));
            BdStatisticsManager.getInstance().debug("img", fK);
            com.baidu.tbadk.k.o.a(afa.num, afa.aeT, afa.time);
            afa.reset();
        }
    }

    public static void dA(String str) {
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
        if (aeV >= 3) {
            return aeW;
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
            if (aeV > -1) {
                aeW = ((aeW * aeV) + j) / (aeV + 1);
            } else {
                aeW = j;
            }
            aeV++;
            return j;
        }
        return j;
    }

    private static String uy() {
        return com.baidu.tbadk.imageManager.c.DZ().ei();
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
            str6 = t.uE().dB(str);
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
