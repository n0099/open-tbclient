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
    private static long Zc = 0;
    private static long Zd = 0;
    private static a Ze = new a(null);
    private static b Zf = new b(null);
    private static b Zg = new b(null);
    private static String Zh = null;
    private static Object vN = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        long ZA;
        int ZB;
        int Zz;
        int num;
        long time;

        private b() {
            this.num = 0;
            this.Zz = 0;
            this.time = 0L;
            this.ZA = 0L;
            this.ZB = 0;
        }

        /* synthetic */ b(b bVar) {
            this();
        }

        public void reset() {
            this.num = 0;
            this.Zz = 0;
            this.time = 0L;
            this.ZA = 0L;
            this.ZB = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int Zi;
        boolean Zj;
        b Zk;
        b Zl;
        b Zm;
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

        private a() {
            this.Zi = 0;
            this.Zk = new b(null);
            this.Zl = new b(null);
            this.Zm = new b(null);
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
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [88=4] */
        public int tP() {
            return this.Zk.num + this.Zl.num + this.Zm.num + this.Zn.num + this.Zo.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [94=14] */
        public int tQ() {
            return this.Zk.num + this.Zl.num + this.Zm.num + this.Zn.num + this.Zo.num + this.Zp.num + this.Zq.num + this.Zr.num + this.Zs.num + this.Zt.num + this.Zu.num + this.Zv.num + this.Zw.num + this.Zx.num + this.Zy.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [105=4] */
        public int tR() {
            return this.Zp.num + this.Zq.num + this.Zr.num + this.Zs.num + this.Zt.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [111=4] */
        public int tS() {
            return this.Zu.num + this.Zv.num + this.Zw.num + this.Zx.num + this.Zy.num;
        }

        public void reset() {
            this.Zi = 0;
            this.Zk.reset();
            this.Zl.reset();
            this.Zm.reset();
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
        }

        public void tT() {
            if (r.Ze.tP() > 0) {
                com.baidu.tbadk.performanceLog.v.a(r.Ze.Zk.num, r.Ze.Zk.Zz, r.Ze.Zk.ZB, r.Ze.Zk.ZA, r.Ze.Zk.time, r.Ze.Zl.num, r.Ze.Zl.Zz, r.Ze.Zl.ZB, r.Ze.Zl.time, r.Ze.Zl.ZA, r.Ze.Zm.num, r.Ze.Zm.Zz, r.Ze.Zm.ZB, r.Ze.Zm.time, r.Ze.Zm.ZA, r.Ze.Zo.num, r.Ze.Zo.Zz, r.Ze.Zo.ZB, r.Ze.Zo.time, r.Ze.Zo.ZA, r.Ze.Zn.num, r.Ze.Zn.Zz, r.Ze.Zn.ZB, r.Ze.Zn.time, r.Ze.Zn.ZA, 3);
            }
        }

        public void tU() {
            if (r.Ze.tR() > 0) {
                com.baidu.tbadk.performanceLog.v.a(r.Ze.Zp.num, r.Ze.Zp.Zz, r.Ze.Zp.ZB, r.Ze.Zp.time, r.Ze.Zp.ZA, r.Ze.Zq.num, r.Ze.Zq.Zz, r.Ze.Zq.ZB, r.Ze.Zq.time, r.Ze.Zq.ZA, r.Ze.Zr.num, r.Ze.Zr.Zz, r.Ze.Zr.ZB, r.Ze.Zr.time, r.Ze.Zr.ZA, r.Ze.Zt.num, r.Ze.Zt.Zz, r.Ze.Zt.ZB, r.Ze.Zt.time, r.Ze.Zt.ZA, r.Ze.Zs.num, r.Ze.Zs.Zz, r.Ze.Zs.ZB, r.Ze.Zs.time, r.Ze.Zs.ZA, 1);
            }
        }

        public void tV() {
            if (r.Ze.tS() > 0) {
                com.baidu.tbadk.performanceLog.v.a(r.Ze.Zu.num, r.Ze.Zu.Zz, r.Ze.Zu.ZB, r.Ze.Zu.time, r.Ze.Zu.ZA, r.Ze.Zv.num, r.Ze.Zv.Zz, r.Ze.Zv.ZB, r.Ze.Zv.time, r.Ze.Zv.ZA, r.Ze.Zw.num, r.Ze.Zw.Zz, r.Ze.Zw.ZB, r.Ze.Zw.time, r.Ze.Zw.ZA, r.Ze.Zy.num, r.Ze.Zy.Zz, r.Ze.Zy.ZB, r.Ze.Zy.time, r.Ze.Zy.ZA, r.Ze.Zx.num, r.Ze.Zx.Zz, r.Ze.Zx.ZB, r.Ze.Zx.time, r.Ze.Zx.ZA, 2);
            }
        }
    }

    private static b a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return Ze.Zk;
            }
            if (str.startsWith("http://tb.himg")) {
                return Ze.Zl;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return Ze.Zm;
            }
            if (z2 && z3) {
                return Ze.Zo;
            }
            return Ze.Zn;
        } else if (com.baidu.adp.lib.util.i.iT()) {
            if (z2) {
                return Ze.Zp;
            }
            if (str.startsWith("http://tb.himg")) {
                return Ze.Zq;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return Ze.Zr;
            }
            return Ze.Zs;
        } else if (z2) {
            return Ze.Zu;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return Ze.Zv;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return Ze.Zw;
            }
            return Ze.Zx;
        }
    }

    public static com.baidu.adp.lib.stats.d hd() {
        return com.baidu.adp.lib.stats.a.hk().ap("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (vN) {
                Zf.num++;
                Zf.time += j;
                if (Zf.num >= 100) {
                    tH();
                }
            }
        }
    }

    public static void tH() {
        if (Zf.num > 10) {
            com.baidu.adp.lib.stats.d hd = hd();
            hd.q("act", "locStat");
            hd.q("costTime", String.valueOf(Zf.time));
            hd.q("num", String.valueOf(Zf.num));
            hd.q("isWifi", "1");
            com.baidu.adp.lib.stats.a.hk().b("img", hd);
            Zf.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar2, String str3, long j, boolean z3, long j2) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.k.jf()) {
            String str6 = "";
            boolean fx = com.baidu.tbadk.util.d.fx(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.httpNet.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.httpNet.e.getInstance().abL) {
                    com.baidu.tbadk.core.util.httpNet.e.getInstance().init();
                }
            }
            boolean iP = com.baidu.adp.lib.util.i.iP();
            if (!z5) {
                z4 = false;
            } else if (iP) {
                z4 = j > ((long) com.baidu.tbadk.core.util.httpNet.e.getInstance().getCDNImageTimeData().SJ);
            } else if (com.baidu.adp.lib.util.i.iT()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.httpNet.e.getInstance().getCDNImageTimeData().SL);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.httpNet.e.getInstance().getCDNImageTimeData().SK);
            }
            boolean z6 = false;
            if (fx && z5) {
                z6 = com.baidu.tbadk.core.util.httpNet.e.getInstance().isShouldCDNFallBack();
            }
            if (fx && iP && z6) {
                if (z) {
                    p.getInstance().insertNormalData(j, str);
                } else {
                    str6 = s.tW().tX();
                    if (!TextUtils.isEmpty(str6)) {
                        p.getInstance().insertErrorData(dVar2.uU, str);
                    }
                }
            }
            if (fx) {
                Zh = str;
            }
            boolean z7 = false;
            if (dVar2.uW != null && dVar2.uW.length() > 0) {
                z7 = true;
            }
            synchronized (vN) {
                b a2 = a(iP, fx, str2, z7);
                boolean z8 = Ze.Zj;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.ZA += j2;
                        Ze.Zj = true;
                        if (z4) {
                            a2.ZB++;
                        }
                    } else {
                        a2.Zz++;
                        Ze.Zj = false;
                    }
                }
                int tQ = Ze.tQ();
                if (tQ > 100 || (tQ > 0 && z8 != Ze.Zj)) {
                    tI();
                }
            }
            if (z && z5) {
                if (!iP || j >= com.baidu.tbadk.core.util.httpNet.e.getInstance().getCDNImageTimeData().SJ) {
                    if (iP || !com.baidu.adp.lib.util.i.iT() || j >= com.baidu.tbadk.core.util.httpNet.e.getInstance().getCDNImageTimeData().SL) {
                        if (!iP && j < com.baidu.tbadk.core.util.httpNet.e.getInstance().getCDNImageTimeData().SK) {
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
                dVar = hd();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = s.tW().tX();
            }
            if (!fx || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = s.tW().cS(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = tK();
            }
            dVar.q("url", str);
            dVar.q("act", "dl");
            dVar.q("result", z ? "0" : "1");
            dVar.q("fullurl", str2);
            dVar.q("costTime", String.valueOf(j));
            dVar.q("connTime", String.valueOf(dVar2.uO));
            dVar.q("rspTime", String.valueOf(dVar2.uP));
            dVar.q("retry", String.valueOf(dVar2.uQ));
            dVar.q("localIp", f.getIp());
            dVar.q("tiebaIp", str6);
            dVar.q("cdnIp", str4);
            dVar.q("useIp", dVar2.uW);
            dVar.q("dnsIp", str5);
            if (dVar2.uO > 1500 || dVar2.uO < 0) {
                dVar.q("connBaidu", String.valueOf(tL()));
            }
            dVar.q("memory", tM());
            dVar.q("task", tN());
            dVar.q("isWifi", iP ? "1" : "0");
            dVar.q("status", String.valueOf(dVar2.uV));
            dVar.q("up", String.valueOf(dVar2.uM));
            dVar.q("down", String.valueOf(dVar2.uN));
            dVar.q("isCDN", fx ? "1" : "0");
            dVar.q("isWebp", bool.booleanValue() ? "1" : "0");
            dVar.q("isMobileProxy", z3 ? "1" : "0");
            dVar.q("exception", dVar2.uT);
            dVar.q("reason", str3);
            com.baidu.adp.lib.stats.a.hk().b("img", dVar);
            if (fx && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                Ze.Zi++;
            }
        }
    }

    public static void tI() {
        if (Ze.tQ() > 10) {
            if (Ze.tP() > 0) {
                a(Ze.Zk, Ze.Zl, Ze.Zm, Ze.Zo, Ze.Zn, 10000);
            }
            if (Ze.tS() > 0) {
                a(Ze.Zu, Ze.Zv, Ze.Zw, Ze.Zy, Ze.Zx, 100002);
            }
            if (Ze.tR() > 0) {
                a(Ze.Zp, Ze.Zq, Ze.Zr, Ze.Zt, Ze.Zs, 100001);
            }
            Ze.tT();
            Ze.tU();
            Ze.tV();
            Ze.reset();
        }
    }

    public static void a(b bVar, b bVar2, b bVar3, b bVar4, b bVar5, int i) {
        if (bVar != null && bVar2 != null && bVar3 != null && bVar4 != null && bVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = s.tW().tX();
            }
            if (Zh != null && TextUtils.isEmpty("")) {
                str2 = s.tW().cS(Zh);
            }
            if (TextUtils.isEmpty("")) {
                str3 = tK();
            }
            com.baidu.adp.lib.stats.d hd = hd();
            hd.q("act", "dlStat");
            hd.q("cdnCostTime", String.valueOf(bVar.time));
            hd.q("cdnNum", String.valueOf(bVar.num));
            hd.q("cdnFailnum", String.valueOf(bVar.Zz));
            hd.q("portraitCostTime", String.valueOf(bVar2.time));
            hd.q("portraitNum", String.valueOf(bVar2.num));
            hd.q("portraitFailnum", String.valueOf(bVar2.Zz));
            hd.q("tiebaCostTime", String.valueOf(bVar3.time));
            hd.q("tiebaNum", String.valueOf(bVar3.num));
            hd.q("tiebaFailnum", String.valueOf(bVar3.Zz));
            hd.q("otherCostTime", String.valueOf(bVar5.time));
            hd.q("otherNum", String.valueOf(bVar5.num));
            hd.q("otherFailnum", String.valueOf(bVar5.Zz));
            hd.q("directIpCostTime", String.valueOf(bVar4.time));
            hd.q("directIpNum", String.valueOf(bVar4.num));
            hd.q("directIpFailnum", String.valueOf(bVar4.Zz));
            hd.q("dnsFailNum", String.valueOf(Ze.Zi));
            if (10000 == i) {
                hd.q("isWifi", "1");
                hd.q("netType", "WIFI");
            } else if (100002 == i) {
                hd.q("netType", "3G");
                hd.q("isWifi", "0");
            } else {
                hd.q("netType", "2G");
                hd.q("isWifi", "0");
            }
            hd.q("localIp", f.getIp());
            hd.q("tbIp", str);
            hd.q("cdnIp", str2);
            hd.q("dnsIp", str3);
            com.baidu.adp.lib.stats.a.hk().b("img", hd);
        }
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.k.jf()) {
            synchronized (vN) {
                Zg.num++;
                if (z) {
                    Zg.time += j;
                } else {
                    Zg.Zz++;
                }
                if (Zg.num >= 100) {
                    tJ();
                }
            }
            if (!z) {
                if (dVar == null) {
                    dVar = hd();
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
                com.baidu.adp.lib.stats.a.hk().b("img", dVar);
            }
        }
    }

    public static void tJ() {
        if (Zg.num > 10) {
            com.baidu.adp.lib.stats.d hd = hd();
            hd.q("act", "dcStat");
            hd.q("costTime", String.valueOf(Zg.time));
            hd.q("num", String.valueOf(Zg.num));
            hd.q("failnum", String.valueOf(Zg.Zz));
            com.baidu.adp.lib.stats.a.hk().b("img", hd);
            com.baidu.tbadk.performanceLog.v.a(Zg.num, Zg.Zz, Zg.time);
            Zg.reset();
        }
    }

    public static void cR(String str) {
        com.baidu.adp.lib.stats.d hd = hd();
        hd.q("act", "assistant");
        hd.q(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
        com.baidu.adp.lib.stats.a.hk().b("img", hd);
    }

    private static String tK() {
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
    private static long tL() {
        HttpURLConnection httpURLConnection;
        long j;
        if (Zc >= 3) {
            return Zd;
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
            if (Zc > -1) {
                Zd = ((Zd * Zc) + j) / (Zc + 1);
            } else {
                Zd = j;
            }
            Zc++;
            return j;
        }
        return j;
    }

    private static String tM() {
        return com.baidu.tbadk.imageManager.c.Ce().fQ();
    }

    private static String tN() {
        return com.baidu.adp.lib.asyncTask.c.fR().fQ();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.d hd = hd();
        hd.q("act", "getCDNList");
        hd.q("errorNum", str);
        hd.q("errorMsg", str2);
        hd.q("isShortNetError", z2 ? "1" : "0");
        hd.q("isSuccess", z ? "1" : "0");
        com.baidu.adp.lib.stats.a.hk().b("img", hd);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = s.tW().cS(str);
        }
        String tK = tK();
        String ip = f.getIp();
        com.baidu.adp.lib.stats.d hd = hd();
        hd.q("act", "tachometerCDN");
        hd.q("errorNum", str3);
        hd.q("execption", str4);
        hd.q("size", str5);
        hd.q("isScuess", z ? "1" : "0");
        hd.q("url", str);
        hd.q("localIp", ip);
        hd.q("cdnIp", str6);
        hd.q("dnsIP", tK);
        hd.q("usedIp", str2);
        hd.q("isUsedIp", z2 ? "0" : "1");
        hd.q("costTime", String.valueOf(j));
        com.baidu.adp.lib.stats.a.hk().b("img", hd);
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
                    com.baidu.adp.lib.stats.d hd = hd();
                    hd.q("act", "mobileTachometerCDN");
                    hd.q("costTime", String.valueOf(j));
                    hd.q("ipList", sb.toString());
                    com.baidu.adp.lib.stats.a.hk().b("img", hd);
                    return;
                }
            }
        }
    }

    public static void d(boolean z, String str) {
        com.baidu.adp.lib.stats.d hd = hd();
        hd.q("act", "getCDNList");
        hd.q("isSuccess", z ? "1" : "0");
        hd.q("errorMsg", str);
        com.baidu.adp.lib.stats.a.hk().b("img", hd);
    }
}
