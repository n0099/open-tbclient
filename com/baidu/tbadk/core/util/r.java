package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class r {
    private static long Zf = 0;
    private static long Zg = 0;
    private static a Zh = new a(null);
    private static b Zi = new b(null);
    private static b Zj = new b(null);
    private static String Zk = null;
    private static Object vM = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        int ZC;
        long ZD;
        int ZE;
        int num;
        long time;

        private b() {
            this.num = 0;
            this.ZC = 0;
            this.time = 0L;
            this.ZD = 0L;
            this.ZE = 0;
        }

        /* synthetic */ b(b bVar) {
            this();
        }

        public void reset() {
            this.num = 0;
            this.ZC = 0;
            this.time = 0L;
            this.ZD = 0L;
            this.ZE = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        b ZA;
        b ZB;
        int Zl;
        boolean Zm;
        b Zn;
        b Zo;
        b Zp;
        b Zq;
        b Zr;
        b Zs;
        b Zt;
        b Zu;
        b Zv;
        b Zw;
        b Zx;
        b Zy;
        b Zz;

        private a() {
            this.Zl = 0;
            this.Zn = new b(null);
            this.Zo = new b(null);
            this.Zp = new b(null);
            this.Zq = new b(null);
            this.Zr = new b(null);
            this.Zs = new b(null);
            this.Zt = new b(null);
            this.Zu = new b(null);
            this.Zv = new b(null);
            this.Zw = new b(null);
            this.Zx = new b(null);
            this.Zy = new b(null);
            this.Zz = new b(null);
            this.ZA = new b(null);
            this.ZB = new b(null);
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [88=4] */
        public int tS() {
            return this.Zn.num + this.Zo.num + this.Zp.num + this.Zq.num + this.Zr.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [94=14] */
        public int tT() {
            return this.Zn.num + this.Zo.num + this.Zp.num + this.Zq.num + this.Zr.num + this.Zs.num + this.Zt.num + this.Zu.num + this.Zv.num + this.Zw.num + this.Zx.num + this.Zy.num + this.Zz.num + this.ZA.num + this.ZB.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [105=4] */
        public int tU() {
            return this.Zs.num + this.Zt.num + this.Zu.num + this.Zv.num + this.Zw.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [111=4] */
        public int tV() {
            return this.Zx.num + this.Zy.num + this.Zz.num + this.ZA.num + this.ZB.num;
        }

        public void reset() {
            this.Zl = 0;
            this.Zn.reset();
            this.Zo.reset();
            this.Zp.reset();
            this.Zq.reset();
            this.Zr.reset();
            this.Zs.reset();
            this.Zt.reset();
            this.Zu.reset();
            this.Zv.reset();
            this.Zw.reset();
            this.Zx.reset();
            this.Zy.reset();
            this.Zz.reset();
            this.ZA.reset();
            this.ZB.reset();
        }

        public void tW() {
            if (r.Zh.tS() > 0) {
                com.baidu.tbadk.performanceLog.v.a(r.Zh.Zn.num, r.Zh.Zn.ZC, r.Zh.Zn.ZE, r.Zh.Zn.ZD, r.Zh.Zn.time, r.Zh.Zo.num, r.Zh.Zo.ZC, r.Zh.Zo.ZE, r.Zh.Zo.time, r.Zh.Zo.ZD, r.Zh.Zp.num, r.Zh.Zp.ZC, r.Zh.Zp.ZE, r.Zh.Zp.time, r.Zh.Zp.ZD, r.Zh.Zr.num, r.Zh.Zr.ZC, r.Zh.Zr.ZE, r.Zh.Zr.time, r.Zh.Zr.ZD, r.Zh.Zq.num, r.Zh.Zq.ZC, r.Zh.Zq.ZE, r.Zh.Zq.time, r.Zh.Zq.ZD, 3);
            }
        }

        public void tX() {
            if (r.Zh.tU() > 0) {
                com.baidu.tbadk.performanceLog.v.a(r.Zh.Zs.num, r.Zh.Zs.ZC, r.Zh.Zs.ZE, r.Zh.Zs.time, r.Zh.Zs.ZD, r.Zh.Zt.num, r.Zh.Zt.ZC, r.Zh.Zt.ZE, r.Zh.Zt.time, r.Zh.Zt.ZD, r.Zh.Zu.num, r.Zh.Zu.ZC, r.Zh.Zu.ZE, r.Zh.Zu.time, r.Zh.Zu.ZD, r.Zh.Zw.num, r.Zh.Zw.ZC, r.Zh.Zw.ZE, r.Zh.Zw.time, r.Zh.Zw.ZD, r.Zh.Zv.num, r.Zh.Zv.ZC, r.Zh.Zv.ZE, r.Zh.Zv.time, r.Zh.Zv.ZD, 1);
            }
        }

        public void tY() {
            if (r.Zh.tV() > 0) {
                com.baidu.tbadk.performanceLog.v.a(r.Zh.Zx.num, r.Zh.Zx.ZC, r.Zh.Zx.ZE, r.Zh.Zx.time, r.Zh.Zx.ZD, r.Zh.Zy.num, r.Zh.Zy.ZC, r.Zh.Zy.ZE, r.Zh.Zy.time, r.Zh.Zy.ZD, r.Zh.Zz.num, r.Zh.Zz.ZC, r.Zh.Zz.ZE, r.Zh.Zz.time, r.Zh.Zz.ZD, r.Zh.ZB.num, r.Zh.ZB.ZC, r.Zh.ZB.ZE, r.Zh.ZB.time, r.Zh.ZB.ZD, r.Zh.ZA.num, r.Zh.ZA.ZC, r.Zh.ZA.ZE, r.Zh.ZA.time, r.Zh.ZA.ZD, 2);
            }
        }
    }

    private static b a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return Zh.Zn;
            }
            if (str.startsWith("http://tb.himg")) {
                return Zh.Zo;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return Zh.Zp;
            }
            if (z2 && z3) {
                return Zh.Zr;
            }
            return Zh.Zq;
        } else if (com.baidu.adp.lib.util.i.iR()) {
            if (z2) {
                return Zh.Zs;
            }
            if (str.startsWith("http://tb.himg")) {
                return Zh.Zt;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return Zh.Zu;
            }
            return Zh.Zv;
        } else if (z2) {
            return Zh.Zx;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return Zh.Zy;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return Zh.Zz;
            }
            return Zh.ZA;
        }
    }

    public static com.baidu.adp.lib.stats.d hb() {
        return com.baidu.adp.lib.stats.a.hi().ap("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (vM) {
                Zi.num++;
                Zi.time += j;
                if (Zi.num >= 100) {
                    tK();
                }
            }
        }
    }

    public static void tK() {
        if (Zi.num > 10) {
            com.baidu.adp.lib.stats.d hb = hb();
            hb.q("act", "locStat");
            hb.q("costTime", String.valueOf(Zi.time));
            hb.q("num", String.valueOf(Zi.num));
            hb.q("isWifi", "1");
            com.baidu.adp.lib.stats.a.hi().b("img", hb);
            Zi.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar2, String str3, long j, boolean z3, long j2) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.k.jd()) {
            String str6 = "";
            boolean fK = com.baidu.tbadk.util.e.fK(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().abS) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean iN = com.baidu.adp.lib.util.i.iN();
            if (!z5) {
                z4 = false;
            } else if (iN) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Ss);
            } else if (com.baidu.adp.lib.util.i.iR()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Su);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().St);
            }
            boolean z6 = false;
            if (fK && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (fK && iN && z6) {
                if (z) {
                    p.getInstance().insertNormalData(j, str);
                } else {
                    str6 = s.tZ().ua();
                    if (!TextUtils.isEmpty(str6)) {
                        p.getInstance().insertErrorData(dVar2.uS, str);
                    }
                }
            }
            if (fK) {
                Zk = str;
            }
            boolean z7 = false;
            if (dVar2.uU != null && dVar2.uU.length() > 0) {
                z7 = true;
            }
            synchronized (vM) {
                b a2 = a(iN, fK, str2, z7);
                boolean z8 = Zh.Zm;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.ZD += j2;
                        Zh.Zm = true;
                        if (z4) {
                            a2.ZE++;
                        }
                    } else {
                        a2.ZC++;
                        Zh.Zm = false;
                    }
                }
                int tT = Zh.tT();
                if (tT > 100 || (tT > 0 && z8 != Zh.Zm)) {
                    tL();
                }
            }
            if (z && z5) {
                if (!iN || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Ss) {
                    if (iN || !com.baidu.adp.lib.util.i.iR() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Su) {
                        if (!iN && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().St) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (dVar == null) {
                dVar = hb();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = s.tZ().ua();
            }
            if (!fK || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = s.tZ().db(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = tN();
            }
            dVar.q("url", str);
            dVar.q("act", "dl");
            dVar.q("result", z ? "0" : "1");
            dVar.q("fullurl", str2);
            dVar.q("costTime", String.valueOf(j));
            dVar.q("connTime", String.valueOf(dVar2.uM));
            dVar.q("rspTime", String.valueOf(dVar2.uN));
            dVar.q("retry", String.valueOf(dVar2.uO));
            dVar.q("localIp", f.getIp());
            dVar.q("tiebaIp", str6);
            dVar.q("cdnIp", str4);
            dVar.q("useIp", dVar2.uU);
            dVar.q("dnsIp", str5);
            if (dVar2.uM > 1500 || dVar2.uM < 0) {
                dVar.q("connBaidu", String.valueOf(tO()));
            }
            dVar.q("memory", tP());
            dVar.q("task", tQ());
            dVar.q("isWifi", iN ? "1" : "0");
            dVar.q("status", String.valueOf(dVar2.uT));
            dVar.q("up", String.valueOf(dVar2.uK));
            dVar.q("down", String.valueOf(dVar2.uL));
            dVar.q("isCDN", fK ? "1" : "0");
            dVar.q("isWebp", bool.booleanValue() ? "1" : "0");
            dVar.q("isMobileProxy", z3 ? "1" : "0");
            dVar.q("exception", dVar2.uR);
            dVar.q("reason", str3);
            com.baidu.adp.lib.stats.a.hi().b("img", dVar);
            if (fK && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                Zh.Zl++;
            }
        }
    }

    public static void tL() {
        if (Zh.tT() > 10) {
            if (Zh.tS() > 0) {
                a(Zh.Zn, Zh.Zo, Zh.Zp, Zh.Zr, Zh.Zq, 10000);
            }
            if (Zh.tV() > 0) {
                a(Zh.Zx, Zh.Zy, Zh.Zz, Zh.ZB, Zh.ZA, 100002);
            }
            if (Zh.tU() > 0) {
                a(Zh.Zs, Zh.Zt, Zh.Zu, Zh.Zw, Zh.Zv, 100001);
            }
            Zh.tW();
            Zh.tX();
            Zh.tY();
            Zh.reset();
        }
    }

    public static void a(b bVar, b bVar2, b bVar3, b bVar4, b bVar5, int i) {
        if (bVar != null && bVar2 != null && bVar3 != null && bVar4 != null && bVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = s.tZ().ua();
            }
            if (Zk != null && TextUtils.isEmpty("")) {
                str2 = s.tZ().db(Zk);
            }
            if (TextUtils.isEmpty("")) {
                str3 = tN();
            }
            com.baidu.adp.lib.stats.d hb = hb();
            hb.q("act", "dlStat");
            hb.q("cdnCostTime", String.valueOf(bVar.time));
            hb.q("cdnNum", String.valueOf(bVar.num));
            hb.q("cdnFailnum", String.valueOf(bVar.ZC));
            hb.q("portraitCostTime", String.valueOf(bVar2.time));
            hb.q("portraitNum", String.valueOf(bVar2.num));
            hb.q("portraitFailnum", String.valueOf(bVar2.ZC));
            hb.q("tiebaCostTime", String.valueOf(bVar3.time));
            hb.q("tiebaNum", String.valueOf(bVar3.num));
            hb.q("tiebaFailnum", String.valueOf(bVar3.ZC));
            hb.q("otherCostTime", String.valueOf(bVar5.time));
            hb.q("otherNum", String.valueOf(bVar5.num));
            hb.q("otherFailnum", String.valueOf(bVar5.ZC));
            hb.q("directIpCostTime", String.valueOf(bVar4.time));
            hb.q("directIpNum", String.valueOf(bVar4.num));
            hb.q("directIpFailnum", String.valueOf(bVar4.ZC));
            hb.q("dnsFailNum", String.valueOf(Zh.Zl));
            if (10000 == i) {
                hb.q("isWifi", "1");
                hb.q("netType", "WIFI");
            } else if (100002 == i) {
                hb.q("netType", "3G");
                hb.q("isWifi", "0");
            } else {
                hb.q("netType", "2G");
                hb.q("isWifi", "0");
            }
            hb.q("localIp", f.getIp());
            hb.q("tbIp", str);
            hb.q("cdnIp", str2);
            hb.q("dnsIp", str3);
            com.baidu.adp.lib.stats.a.hi().b("img", hb);
        }
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.k.jd()) {
            synchronized (vM) {
                Zj.num++;
                if (z) {
                    Zj.time += j;
                } else {
                    Zj.ZC++;
                }
                if (Zj.num >= 100) {
                    tM();
                }
            }
            if (!z) {
                if (dVar == null) {
                    dVar = hb();
                }
                dVar.q("act", "dc");
                dVar.q("costTime", String.valueOf(j));
                dVar.q("url", str);
                dVar.q("fullURL", str2);
                dVar.q("isWebp", z3 ? "1" : "0");
                dVar.q("isCDN", z2 ? "1" : "0");
                dVar.q("length", String.valueOf(i));
                dVar.q("reason", str3);
                dVar.q("result", z ? "0" : "1");
                dVar.q("execption", str4);
                com.baidu.adp.lib.stats.a.hi().b("img", dVar);
            }
        }
    }

    public static void tM() {
        if (Zj.num > 10) {
            com.baidu.adp.lib.stats.d hb = hb();
            hb.q("act", "dcStat");
            hb.q("costTime", String.valueOf(Zj.time));
            hb.q("num", String.valueOf(Zj.num));
            hb.q("failnum", String.valueOf(Zj.ZC));
            com.baidu.adp.lib.stats.a.hi().b("img", hb);
            com.baidu.tbadk.performanceLog.v.a(Zj.num, Zj.ZC, Zj.time);
            Zj.reset();
        }
    }

    public static void da(String str) {
        com.baidu.adp.lib.stats.d hb = hb();
        hb.q("act", "assistant");
        hb.q(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
        com.baidu.adp.lib.stats.a.hi().b("img", hb);
    }

    private static String tN() {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [678=4] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long tO() {
        HttpURLConnection httpURLConnection;
        long j;
        if (Zf >= 3) {
            return Zg;
        }
        long currentTimeMillis = System.currentTimeMillis();
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL("http://www.baidu.com/").openConnection();
            try {
                httpURLConnection.setConnectTimeout(2500);
                httpURLConnection.connect();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.g.a.e(httpURLConnection);
                j = currentTimeMillis2;
            } catch (SocketTimeoutException e) {
                com.baidu.adp.lib.g.a.e(httpURLConnection);
                j = 2500;
                if (j > 0) {
                }
            } catch (Exception e2) {
                httpURLConnection2 = httpURLConnection;
                com.baidu.adp.lib.g.a.e(httpURLConnection2);
                j = -1;
                if (j > 0) {
                }
            } catch (Throwable th) {
                httpURLConnection2 = httpURLConnection;
                th = th;
                com.baidu.adp.lib.g.a.e(httpURLConnection2);
                throw th;
            }
        } catch (SocketTimeoutException e3) {
            httpURLConnection = null;
        } catch (Exception e4) {
        } catch (Throwable th2) {
            th = th2;
        }
        if (j > 0) {
            if (Zf > -1) {
                Zg = ((Zg * Zf) + j) / (Zf + 1);
            } else {
                Zg = j;
            }
            Zf++;
            return j;
        }
        return j;
    }

    private static String tP() {
        return com.baidu.tbadk.imageManager.c.Cf().fN();
    }

    private static String tQ() {
        return com.baidu.adp.lib.asyncTask.c.fO().fN();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.d hb = hb();
        hb.q("act", "getCDNList");
        hb.q("errorNum", str);
        hb.q("errorMsg", str2);
        hb.q("isShortNetError", z2 ? "1" : "0");
        hb.q("isSuccess", z ? "1" : "0");
        com.baidu.adp.lib.stats.a.hi().b("img", hb);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = s.tZ().db(str);
        }
        String tN = tN();
        String ip = f.getIp();
        com.baidu.adp.lib.stats.d hb = hb();
        hb.q("act", "tachometerCDN");
        hb.q("errorNum", str3);
        hb.q("execption", str4);
        hb.q("size", str5);
        hb.q("isScuess", z ? "1" : "0");
        hb.q("url", str);
        hb.q("localIp", ip);
        hb.q("cdnIp", str6);
        hb.q("dnsIP", tN);
        hb.q("usedIp", str2);
        hb.q("isUsedIp", z2 ? "0" : "1");
        hb.q("costTime", String.valueOf(j));
        com.baidu.adp.lib.stats.a.hi().b("img", hb);
    }

    public static void b(ArrayList<String> arrayList, long j) {
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
                    com.baidu.adp.lib.stats.d hb = hb();
                    hb.q("act", "mobileTachometerCDN");
                    hb.q("costTime", String.valueOf(j));
                    hb.q("ipList", sb.toString());
                    com.baidu.adp.lib.stats.a.hi().b("img", hb);
                    return;
                }
            }
        }
    }

    public static void c(boolean z, String str) {
        com.baidu.adp.lib.stats.d hb = hb();
        hb.q("act", "getCDNList");
        hb.q("isSuccess", z ? "1" : "0");
        hb.q("errorMsg", str);
        com.baidu.adp.lib.stats.a.hi().b("img", hb);
    }
}
