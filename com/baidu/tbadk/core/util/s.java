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
    private static long afe = 0;
    private static long aff = 0;
    private static int afg = 0;
    private static a afh = new a();
    private static r afi = new r();
    private static r afj = new r();
    private static String afk = null;
    private static Object syncLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        r afA;
        r afB;
        int afl;
        boolean afm;
        r afn;
        r afo;
        r afp;
        r afq;
        r afr;
        r afs;
        r aft;
        r afu;
        r afv;
        r afw;
        r afx;
        r afy;
        r afz;

        private a() {
            this.afl = 0;
            this.afn = new r();
            this.afo = new r();
            this.afp = new r();
            this.afq = new r();
            this.afr = new r();
            this.afs = new r();
            this.aft = new r();
            this.afu = new r();
            this.afv = new r();
            this.afw = new r();
            this.afx = new r();
            this.afy = new r();
            this.afz = new r();
            this.afA = new r();
            this.afB = new r();
        }

        public int uA() {
            return this.afn.num + this.afo.num + this.afp.num + this.afq.num + this.afr.num;
        }

        public int uB() {
            return this.afn.num + this.afo.num + this.afp.num + this.afq.num + this.afr.num + this.afs.num + this.aft.num + this.afu.num + this.afv.num + this.afw.num + this.afx.num + this.afy.num + this.afz.num + this.afA.num + this.afB.num;
        }

        public int uC() {
            return this.afs.num + this.aft.num + this.afu.num + this.afv.num + this.afw.num;
        }

        public int uD() {
            return this.afx.num + this.afy.num + this.afz.num + this.afA.num + this.afB.num;
        }

        public void reset() {
            this.afl = 0;
            this.afn.reset();
            this.afo.reset();
            this.afp.reset();
            this.afq.reset();
            this.afr.reset();
            this.afs.reset();
            this.aft.reset();
            this.afu.reset();
            this.afv.reset();
            this.afw.reset();
            this.afx.reset();
            this.afy.reset();
            this.afz.reset();
            this.afA.reset();
            this.afB.reset();
        }
    }

    private static r a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return afh.afn;
            }
            if (str.startsWith("http://tb.himg")) {
                return afh.afo;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return afh.afp;
            }
            if (z2 && z3) {
                return afh.afr;
            }
            return afh.afq;
        } else if (com.baidu.adp.lib.util.j.hm()) {
            if (z2) {
                return afh.afs;
            }
            if (str.startsWith("http://tb.himg")) {
                return afh.aft;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return afh.afu;
            }
            return afh.afv;
        } else if (z2) {
            return afh.afx;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return afh.afy;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return afh.afz;
            }
            return afh.afA;
        }
    }

    public static com.baidu.adp.lib.stats.a fK() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (syncLock) {
                afi.num++;
                afi.time += j;
                if (afi.num >= 100) {
                    ut();
                }
            }
        }
    }

    public static void ut() {
        if (afi.num > 10) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("act", "locStat");
            fK.p("costTime", String.valueOf(afi.time));
            fK.p("num", String.valueOf(afi.num));
            fK.p("isWifi", "1");
            BdStatisticsManager.getInstance().debug("img", fK);
            afi.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.a aVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.l.hy() && dVar != null) {
            String str6 = "";
            boolean gK = com.baidu.tbadk.util.i.gK(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().aic) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean hi = com.baidu.adp.lib.util.j.hi();
            if (!z5) {
                z4 = false;
            } else if (hi) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().RW);
            } else if (com.baidu.adp.lib.util.j.hm()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().RY);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().RX);
            }
            boolean z6 = false;
            if (gK && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (gK && hi && z6) {
                if (z) {
                    p.getInstance().insertNormalData(j, str);
                } else {
                    str6 = t.uE().uF();
                    if (!TextUtils.isEmpty(str6)) {
                        p.getInstance().insertErrorData(dVar.uZ, str);
                    }
                }
            }
            if (gK) {
                afk = str;
            }
            boolean z7 = false;
            if (dVar.vb != null && dVar.vb.length() > 0) {
                z7 = true;
            }
            synchronized (syncLock) {
                r a2 = a(hi, gK, str2, z7);
                boolean z8 = afh.afm;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.uT += j2;
                        afh.afm = true;
                        if (z4) {
                            a2.afd++;
                        }
                        afg = 0;
                    } else {
                        if (com.baidu.adp.lib.util.j.hh()) {
                            int i2 = afg + 1;
                            afg = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.gz().getMaxAlertCount("alert_img", 5)) {
                                BdStatisticsManager.getInstance().alert("alert_img", "imgFailedCnt_" + String.valueOf(afg) + "_url=" + str2);
                            }
                        }
                        a2.afc++;
                        afh.afm = false;
                    }
                }
                int uB = afh.uB();
                if (uB > 100 || (uB > 0 && z8 != afh.afm)) {
                    uu();
                }
            }
            if (z && z5) {
                if (!hi || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().RW) {
                    if (hi || !com.baidu.adp.lib.util.j.hm() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().RY) {
                        if (!hi && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().RX) {
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
            if (!gK || !TextUtils.isEmpty("")) {
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
            aVar.p("netlib", String.valueOf(dVar.vf));
            aVar.p("costTime", String.valueOf(j));
            aVar.p("connTime", String.valueOf(dVar.connectTime));
            aVar.p("rspTime", String.valueOf(dVar.uU));
            aVar.p("retry", String.valueOf(dVar.uV));
            aVar.p("localIp", d.getIp());
            aVar.p("tiebaIp", str6);
            aVar.p("cdnIp", str4);
            aVar.p("useIp", dVar.vb);
            aVar.p("dnsIp", str5);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                aVar.p("connBaidu", String.valueOf(ux()));
            }
            aVar.p("memory", uy());
            aVar.p("task", uz());
            aVar.p("status", String.valueOf(dVar.va));
            aVar.p("up", String.valueOf(dVar.uS));
            aVar.p("down", String.valueOf(dVar.uT));
            aVar.p("isCDN", gK ? "1" : "0");
            aVar.p("isWebp", bool.booleanValue() ? "1" : "0");
            aVar.p("isMobileProxy", z3 ? "1" : "0");
            aVar.p("exception", dVar.uY);
            aVar.p("reason", str3);
            if (i != 0) {
                aVar.c("procType", Integer.valueOf(i));
            }
            if (dVar.vd != null) {
                aVar.p("tracecode1", dVar.vd);
            }
            if (dVar.ve != null) {
                aVar.p("tracecode2", dVar.ve);
            }
            BdStatisticsManager.getInstance().debug("img", aVar);
            if (gK && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                afh.afl++;
            }
        }
    }

    public static void uu() {
        if (afh.uB() > 10) {
            if (afh.uA() > 0) {
                a(afh.afn, afh.afo, afh.afp, afh.afr, afh.afq, 10000);
                com.baidu.tbadk.l.o.b(afh.afn, afh.afo, afh.afp, afh.afr, afh.afq, 3);
            }
            if (afh.uD() > 0) {
                a(afh.afx, afh.afy, afh.afz, afh.afB, afh.afA, 100002);
                com.baidu.tbadk.l.o.b(afh.afx, afh.afy, afh.afz, afh.afB, afh.afA, 2);
            }
            if (afh.uC() > 0) {
                a(afh.afs, afh.aft, afh.afu, afh.afw, afh.afv, 100001);
                com.baidu.tbadk.l.o.b(afh.afs, afh.aft, afh.afu, afh.afw, afh.afv, 1);
            }
            afh.reset();
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
            if (afk != null && TextUtils.isEmpty("")) {
                str2 = t.uE().dG(afk);
            }
            if (TextUtils.isEmpty("")) {
                str3 = uw();
            }
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("act", "dlStat");
            fK.p("cdnCostTime", String.valueOf(rVar.time));
            fK.p("cdnNum", String.valueOf(rVar.num));
            fK.p("cdnFailnum", String.valueOf(rVar.afc));
            fK.p("portraitCostTime", String.valueOf(rVar2.time));
            fK.p("portraitNum", String.valueOf(rVar2.num));
            fK.p("portraitFailnum", String.valueOf(rVar2.afc));
            fK.p("tiebaCostTime", String.valueOf(rVar3.time));
            fK.p("tiebaNum", String.valueOf(rVar3.num));
            fK.p("tiebaFailnum", String.valueOf(rVar3.afc));
            fK.p("otherCostTime", String.valueOf(rVar5.time));
            fK.p("otherNum", String.valueOf(rVar5.num));
            fK.p("otherFailnum", String.valueOf(rVar5.afc));
            fK.p("directIpCostTime", String.valueOf(rVar4.time));
            fK.p("directIpNum", String.valueOf(rVar4.num));
            fK.p("directIpFailnum", String.valueOf(rVar4.afc));
            fK.p("dnsFailNum", String.valueOf(afh.afl));
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
                afj.num++;
                if (z) {
                    afj.time += j;
                } else {
                    afj.afc++;
                }
                if (afj.num >= 100) {
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
        if (afj.num > 10) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("act", "dcStat");
            fK.p("costTime", String.valueOf(afj.time));
            fK.p("num", String.valueOf(afj.num));
            fK.p("failnum", String.valueOf(afj.afc));
            BdStatisticsManager.getInstance().debug("img", fK);
            com.baidu.tbadk.l.o.a(afj.num, afj.afc, afj.time);
            afj.reset();
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
        if (afe >= 3) {
            return aff;
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
            if (afe > -1) {
                aff = ((aff * afe) + j) / (afe + 1);
            } else {
                aff = j;
            }
            afe++;
            return j;
        }
        return j;
    }

    private static String uy() {
        return com.baidu.tbadk.imageManager.c.Eg().ei();
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
