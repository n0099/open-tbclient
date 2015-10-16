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
    private static long Zh = 0;
    private static long Zi = 0;
    private static a Zj = new a(null);
    private static b Zk = new b(null);
    private static b Zl = new b(null);
    private static String Zm = null;
    private static Object vM = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        int ZE;
        long ZF;
        int ZG;
        int num;
        long time;

        private b() {
            this.num = 0;
            this.ZE = 0;
            this.time = 0L;
            this.ZF = 0L;
            this.ZG = 0;
        }

        /* synthetic */ b(b bVar) {
            this();
        }

        public void reset() {
            this.num = 0;
            this.ZE = 0;
            this.time = 0L;
            this.ZF = 0L;
            this.ZG = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        b ZA;
        b ZB;
        b ZC;
        b ZD;
        int Zn;
        boolean Zo;
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
            this.Zn = 0;
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
            this.ZC = new b(null);
            this.ZD = new b(null);
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [88=4] */
        public int tS() {
            return this.Zp.num + this.Zq.num + this.Zr.num + this.Zs.num + this.Zt.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [94=14] */
        public int tT() {
            return this.Zp.num + this.Zq.num + this.Zr.num + this.Zs.num + this.Zt.num + this.Zu.num + this.Zv.num + this.Zw.num + this.Zx.num + this.Zy.num + this.Zz.num + this.ZA.num + this.ZB.num + this.ZC.num + this.ZD.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [105=4] */
        public int tU() {
            return this.Zu.num + this.Zv.num + this.Zw.num + this.Zx.num + this.Zy.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [111=4] */
        public int tV() {
            return this.Zz.num + this.ZA.num + this.ZB.num + this.ZC.num + this.ZD.num;
        }

        public void reset() {
            this.Zn = 0;
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
            this.ZC.reset();
            this.ZD.reset();
        }

        public void tW() {
            if (r.Zj.tS() > 0) {
                com.baidu.tbadk.performanceLog.v.a(r.Zj.Zp.num, r.Zj.Zp.ZE, r.Zj.Zp.ZG, r.Zj.Zp.ZF, r.Zj.Zp.time, r.Zj.Zq.num, r.Zj.Zq.ZE, r.Zj.Zq.ZG, r.Zj.Zq.time, r.Zj.Zq.ZF, r.Zj.Zr.num, r.Zj.Zr.ZE, r.Zj.Zr.ZG, r.Zj.Zr.time, r.Zj.Zr.ZF, r.Zj.Zt.num, r.Zj.Zt.ZE, r.Zj.Zt.ZG, r.Zj.Zt.time, r.Zj.Zt.ZF, r.Zj.Zs.num, r.Zj.Zs.ZE, r.Zj.Zs.ZG, r.Zj.Zs.time, r.Zj.Zs.ZF, 3);
            }
        }

        public void tX() {
            if (r.Zj.tU() > 0) {
                com.baidu.tbadk.performanceLog.v.a(r.Zj.Zu.num, r.Zj.Zu.ZE, r.Zj.Zu.ZG, r.Zj.Zu.time, r.Zj.Zu.ZF, r.Zj.Zv.num, r.Zj.Zv.ZE, r.Zj.Zv.ZG, r.Zj.Zv.time, r.Zj.Zv.ZF, r.Zj.Zw.num, r.Zj.Zw.ZE, r.Zj.Zw.ZG, r.Zj.Zw.time, r.Zj.Zw.ZF, r.Zj.Zy.num, r.Zj.Zy.ZE, r.Zj.Zy.ZG, r.Zj.Zy.time, r.Zj.Zy.ZF, r.Zj.Zx.num, r.Zj.Zx.ZE, r.Zj.Zx.ZG, r.Zj.Zx.time, r.Zj.Zx.ZF, 1);
            }
        }

        public void tY() {
            if (r.Zj.tV() > 0) {
                com.baidu.tbadk.performanceLog.v.a(r.Zj.Zz.num, r.Zj.Zz.ZE, r.Zj.Zz.ZG, r.Zj.Zz.time, r.Zj.Zz.ZF, r.Zj.ZA.num, r.Zj.ZA.ZE, r.Zj.ZA.ZG, r.Zj.ZA.time, r.Zj.ZA.ZF, r.Zj.ZB.num, r.Zj.ZB.ZE, r.Zj.ZB.ZG, r.Zj.ZB.time, r.Zj.ZB.ZF, r.Zj.ZD.num, r.Zj.ZD.ZE, r.Zj.ZD.ZG, r.Zj.ZD.time, r.Zj.ZD.ZF, r.Zj.ZC.num, r.Zj.ZC.ZE, r.Zj.ZC.ZG, r.Zj.ZC.time, r.Zj.ZC.ZF, 2);
            }
        }
    }

    private static b a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return Zj.Zp;
            }
            if (str.startsWith("http://tb.himg")) {
                return Zj.Zq;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return Zj.Zr;
            }
            if (z2 && z3) {
                return Zj.Zt;
            }
            return Zj.Zs;
        } else if (com.baidu.adp.lib.util.i.iR()) {
            if (z2) {
                return Zj.Zu;
            }
            if (str.startsWith("http://tb.himg")) {
                return Zj.Zv;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return Zj.Zw;
            }
            return Zj.Zx;
        } else if (z2) {
            return Zj.Zz;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return Zj.ZA;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return Zj.ZB;
            }
            return Zj.ZC;
        }
    }

    public static com.baidu.adp.lib.stats.d hb() {
        return com.baidu.adp.lib.stats.a.hi().ap("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (vM) {
                Zk.num++;
                Zk.time += j;
                if (Zk.num >= 100) {
                    tK();
                }
            }
        }
    }

    public static void tK() {
        if (Zk.num > 10) {
            com.baidu.adp.lib.stats.d hb = hb();
            hb.q("act", "locStat");
            hb.q("costTime", String.valueOf(Zk.time));
            hb.q("num", String.valueOf(Zk.num));
            hb.q("isWifi", "1");
            com.baidu.adp.lib.stats.a.hi().b("img", hb);
            Zk.reset();
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
                if (!com.baidu.tbadk.core.util.a.e.getInstance().abV) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean iN = com.baidu.adp.lib.util.i.iN();
            if (!z5) {
                z4 = false;
            } else if (iN) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().St);
            } else if (com.baidu.adp.lib.util.i.iR()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Sv);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Su);
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
                Zm = str;
            }
            boolean z7 = false;
            if (dVar2.uU != null && dVar2.uU.length() > 0) {
                z7 = true;
            }
            synchronized (vM) {
                b a2 = a(iN, fK, str2, z7);
                boolean z8 = Zj.Zo;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.ZF += j2;
                        Zj.Zo = true;
                        if (z4) {
                            a2.ZG++;
                        }
                    } else {
                        a2.ZE++;
                        Zj.Zo = false;
                    }
                }
                int tT = Zj.tT();
                if (tT > 100 || (tT > 0 && z8 != Zj.Zo)) {
                    tL();
                }
            }
            if (z && z5) {
                if (!iN || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().St) {
                    if (iN || !com.baidu.adp.lib.util.i.iR() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Sv) {
                        if (!iN && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Su) {
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
                str4 = s.tZ().dc(str);
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
                Zj.Zn++;
            }
        }
    }

    public static void tL() {
        if (Zj.tT() > 10) {
            if (Zj.tS() > 0) {
                a(Zj.Zp, Zj.Zq, Zj.Zr, Zj.Zt, Zj.Zs, 10000);
            }
            if (Zj.tV() > 0) {
                a(Zj.Zz, Zj.ZA, Zj.ZB, Zj.ZD, Zj.ZC, 100002);
            }
            if (Zj.tU() > 0) {
                a(Zj.Zu, Zj.Zv, Zj.Zw, Zj.Zy, Zj.Zx, 100001);
            }
            Zj.tW();
            Zj.tX();
            Zj.tY();
            Zj.reset();
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
            if (Zm != null && TextUtils.isEmpty("")) {
                str2 = s.tZ().dc(Zm);
            }
            if (TextUtils.isEmpty("")) {
                str3 = tN();
            }
            com.baidu.adp.lib.stats.d hb = hb();
            hb.q("act", "dlStat");
            hb.q("cdnCostTime", String.valueOf(bVar.time));
            hb.q("cdnNum", String.valueOf(bVar.num));
            hb.q("cdnFailnum", String.valueOf(bVar.ZE));
            hb.q("portraitCostTime", String.valueOf(bVar2.time));
            hb.q("portraitNum", String.valueOf(bVar2.num));
            hb.q("portraitFailnum", String.valueOf(bVar2.ZE));
            hb.q("tiebaCostTime", String.valueOf(bVar3.time));
            hb.q("tiebaNum", String.valueOf(bVar3.num));
            hb.q("tiebaFailnum", String.valueOf(bVar3.ZE));
            hb.q("otherCostTime", String.valueOf(bVar5.time));
            hb.q("otherNum", String.valueOf(bVar5.num));
            hb.q("otherFailnum", String.valueOf(bVar5.ZE));
            hb.q("directIpCostTime", String.valueOf(bVar4.time));
            hb.q("directIpNum", String.valueOf(bVar4.num));
            hb.q("directIpFailnum", String.valueOf(bVar4.ZE));
            hb.q("dnsFailNum", String.valueOf(Zj.Zn));
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
                Zl.num++;
                if (z) {
                    Zl.time += j;
                } else {
                    Zl.ZE++;
                }
                if (Zl.num >= 100) {
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
        if (Zl.num > 10) {
            com.baidu.adp.lib.stats.d hb = hb();
            hb.q("act", "dcStat");
            hb.q("costTime", String.valueOf(Zl.time));
            hb.q("num", String.valueOf(Zl.num));
            hb.q("failnum", String.valueOf(Zl.ZE));
            com.baidu.adp.lib.stats.a.hi().b("img", hb);
            com.baidu.tbadk.performanceLog.v.a(Zl.num, Zl.ZE, Zl.time);
            Zl.reset();
        }
    }

    public static void db(String str) {
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
        if (Zh >= 3) {
            return Zi;
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
            if (Zh > -1) {
                Zi = ((Zi * Zh) + j) / (Zh + 1);
            } else {
                Zi = j;
            }
            Zh++;
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
            str6 = s.tZ().dc(str);
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
