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
    private static long Zl = 0;
    private static long Zm = 0;
    private static a Zn = new a(null);
    private static b Zo = new b(null);
    private static b Zp = new b(null);
    private static String Zq = null;
    private static Object vM = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        int ZI;
        long ZJ;
        int ZK;
        int num;
        long time;

        private b() {
            this.num = 0;
            this.ZI = 0;
            this.time = 0L;
            this.ZJ = 0L;
            this.ZK = 0;
        }

        /* synthetic */ b(b bVar) {
            this();
        }

        public void reset() {
            this.num = 0;
            this.ZI = 0;
            this.time = 0L;
            this.ZJ = 0L;
            this.ZK = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        b ZA;
        b ZB;
        b ZC;
        b ZD;
        b ZE;
        b ZF;
        b ZG;
        b ZH;
        int Zr;
        boolean Zs;
        b Zt;
        b Zu;
        b Zv;
        b Zw;
        b Zx;
        b Zy;
        b Zz;

        private a() {
            this.Zr = 0;
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
            this.ZE = new b(null);
            this.ZF = new b(null);
            this.ZG = new b(null);
            this.ZH = new b(null);
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [88=4] */
        public int tS() {
            return this.Zt.num + this.Zu.num + this.Zv.num + this.Zw.num + this.Zx.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [94=14] */
        public int tT() {
            return this.Zt.num + this.Zu.num + this.Zv.num + this.Zw.num + this.Zx.num + this.Zy.num + this.Zz.num + this.ZA.num + this.ZB.num + this.ZC.num + this.ZD.num + this.ZE.num + this.ZF.num + this.ZG.num + this.ZH.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [105=4] */
        public int tU() {
            return this.Zy.num + this.Zz.num + this.ZA.num + this.ZB.num + this.ZC.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [111=4] */
        public int tV() {
            return this.ZD.num + this.ZE.num + this.ZF.num + this.ZG.num + this.ZH.num;
        }

        public void reset() {
            this.Zr = 0;
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
            this.ZE.reset();
            this.ZF.reset();
            this.ZG.reset();
            this.ZH.reset();
        }

        public void tW() {
            if (r.Zn.tS() > 0) {
                com.baidu.tbadk.performanceLog.v.a(r.Zn.Zt.num, r.Zn.Zt.ZI, r.Zn.Zt.ZK, r.Zn.Zt.ZJ, r.Zn.Zt.time, r.Zn.Zu.num, r.Zn.Zu.ZI, r.Zn.Zu.ZK, r.Zn.Zu.time, r.Zn.Zu.ZJ, r.Zn.Zv.num, r.Zn.Zv.ZI, r.Zn.Zv.ZK, r.Zn.Zv.time, r.Zn.Zv.ZJ, r.Zn.Zx.num, r.Zn.Zx.ZI, r.Zn.Zx.ZK, r.Zn.Zx.time, r.Zn.Zx.ZJ, r.Zn.Zw.num, r.Zn.Zw.ZI, r.Zn.Zw.ZK, r.Zn.Zw.time, r.Zn.Zw.ZJ, 3);
            }
        }

        public void tX() {
            if (r.Zn.tU() > 0) {
                com.baidu.tbadk.performanceLog.v.a(r.Zn.Zy.num, r.Zn.Zy.ZI, r.Zn.Zy.ZK, r.Zn.Zy.time, r.Zn.Zy.ZJ, r.Zn.Zz.num, r.Zn.Zz.ZI, r.Zn.Zz.ZK, r.Zn.Zz.time, r.Zn.Zz.ZJ, r.Zn.ZA.num, r.Zn.ZA.ZI, r.Zn.ZA.ZK, r.Zn.ZA.time, r.Zn.ZA.ZJ, r.Zn.ZC.num, r.Zn.ZC.ZI, r.Zn.ZC.ZK, r.Zn.ZC.time, r.Zn.ZC.ZJ, r.Zn.ZB.num, r.Zn.ZB.ZI, r.Zn.ZB.ZK, r.Zn.ZB.time, r.Zn.ZB.ZJ, 1);
            }
        }

        public void tY() {
            if (r.Zn.tV() > 0) {
                com.baidu.tbadk.performanceLog.v.a(r.Zn.ZD.num, r.Zn.ZD.ZI, r.Zn.ZD.ZK, r.Zn.ZD.time, r.Zn.ZD.ZJ, r.Zn.ZE.num, r.Zn.ZE.ZI, r.Zn.ZE.ZK, r.Zn.ZE.time, r.Zn.ZE.ZJ, r.Zn.ZF.num, r.Zn.ZF.ZI, r.Zn.ZF.ZK, r.Zn.ZF.time, r.Zn.ZF.ZJ, r.Zn.ZH.num, r.Zn.ZH.ZI, r.Zn.ZH.ZK, r.Zn.ZH.time, r.Zn.ZH.ZJ, r.Zn.ZG.num, r.Zn.ZG.ZI, r.Zn.ZG.ZK, r.Zn.ZG.time, r.Zn.ZG.ZJ, 2);
            }
        }
    }

    private static b a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return Zn.Zt;
            }
            if (str.startsWith("http://tb.himg")) {
                return Zn.Zu;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return Zn.Zv;
            }
            if (z2 && z3) {
                return Zn.Zx;
            }
            return Zn.Zw;
        } else if (com.baidu.adp.lib.util.i.iS()) {
            if (z2) {
                return Zn.Zy;
            }
            if (str.startsWith("http://tb.himg")) {
                return Zn.Zz;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return Zn.ZA;
            }
            return Zn.ZB;
        } else if (z2) {
            return Zn.ZD;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return Zn.ZE;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return Zn.ZF;
            }
            return Zn.ZG;
        }
    }

    public static com.baidu.adp.lib.stats.d hc() {
        return com.baidu.adp.lib.stats.a.hj().an("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (vM) {
                Zo.num++;
                Zo.time += j;
                if (Zo.num >= 100) {
                    tK();
                }
            }
        }
    }

    public static void tK() {
        if (Zo.num > 10) {
            com.baidu.adp.lib.stats.d hc = hc();
            hc.q("act", "locStat");
            hc.q("costTime", String.valueOf(Zo.time));
            hc.q("num", String.valueOf(Zo.num));
            hc.q("isWifi", "1");
            com.baidu.adp.lib.stats.a.hj().b("img", hc);
            Zo.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar2, String str3, long j, boolean z3, long j2) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.k.je()) {
            String str6 = "";
            boolean fM = com.baidu.tbadk.util.e.fM(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().aca) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean iO = com.baidu.adp.lib.util.i.iO();
            if (!z5) {
                z4 = false;
            } else if (iO) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Su);
            } else if (com.baidu.adp.lib.util.i.iS()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Sw);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Sv);
            }
            boolean z6 = false;
            if (fM && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (fM && iO && z6) {
                if (z) {
                    p.getInstance().insertNormalData(j, str);
                } else {
                    str6 = s.tZ().ua();
                    if (!TextUtils.isEmpty(str6)) {
                        p.getInstance().insertErrorData(dVar2.uS, str);
                    }
                }
            }
            if (fM) {
                Zq = str;
            }
            boolean z7 = false;
            if (dVar2.uU != null && dVar2.uU.length() > 0) {
                z7 = true;
            }
            synchronized (vM) {
                b a2 = a(iO, fM, str2, z7);
                boolean z8 = Zn.Zs;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.ZJ += j2;
                        Zn.Zs = true;
                        if (z4) {
                            a2.ZK++;
                        }
                    } else {
                        a2.ZI++;
                        Zn.Zs = false;
                    }
                }
                int tT = Zn.tT();
                if (tT > 100 || (tT > 0 && z8 != Zn.Zs)) {
                    tL();
                }
            }
            if (z && z5) {
                if (!iO || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Su) {
                    if (iO || !com.baidu.adp.lib.util.i.iS() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Sw) {
                        if (!iO && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Sv) {
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
                dVar = hc();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = s.tZ().ua();
            }
            if (!fM || !TextUtils.isEmpty("")) {
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
            dVar.q("isWifi", iO ? "1" : "0");
            dVar.q("status", String.valueOf(dVar2.uT));
            dVar.q("up", String.valueOf(dVar2.uK));
            dVar.q("down", String.valueOf(dVar2.uL));
            dVar.q("isCDN", fM ? "1" : "0");
            dVar.q("isWebp", bool.booleanValue() ? "1" : "0");
            dVar.q("isMobileProxy", z3 ? "1" : "0");
            dVar.q("exception", dVar2.uR);
            dVar.q("reason", str3);
            com.baidu.adp.lib.stats.a.hj().b("img", dVar);
            if (fM && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                Zn.Zr++;
            }
        }
    }

    public static void tL() {
        if (Zn.tT() > 10) {
            if (Zn.tS() > 0) {
                a(Zn.Zt, Zn.Zu, Zn.Zv, Zn.Zx, Zn.Zw, 10000);
            }
            if (Zn.tV() > 0) {
                a(Zn.ZD, Zn.ZE, Zn.ZF, Zn.ZH, Zn.ZG, 100002);
            }
            if (Zn.tU() > 0) {
                a(Zn.Zy, Zn.Zz, Zn.ZA, Zn.ZC, Zn.ZB, 100001);
            }
            Zn.tW();
            Zn.tX();
            Zn.tY();
            Zn.reset();
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
            if (Zq != null && TextUtils.isEmpty("")) {
                str2 = s.tZ().dc(Zq);
            }
            if (TextUtils.isEmpty("")) {
                str3 = tN();
            }
            com.baidu.adp.lib.stats.d hc = hc();
            hc.q("act", "dlStat");
            hc.q("cdnCostTime", String.valueOf(bVar.time));
            hc.q("cdnNum", String.valueOf(bVar.num));
            hc.q("cdnFailnum", String.valueOf(bVar.ZI));
            hc.q("portraitCostTime", String.valueOf(bVar2.time));
            hc.q("portraitNum", String.valueOf(bVar2.num));
            hc.q("portraitFailnum", String.valueOf(bVar2.ZI));
            hc.q("tiebaCostTime", String.valueOf(bVar3.time));
            hc.q("tiebaNum", String.valueOf(bVar3.num));
            hc.q("tiebaFailnum", String.valueOf(bVar3.ZI));
            hc.q("otherCostTime", String.valueOf(bVar5.time));
            hc.q("otherNum", String.valueOf(bVar5.num));
            hc.q("otherFailnum", String.valueOf(bVar5.ZI));
            hc.q("directIpCostTime", String.valueOf(bVar4.time));
            hc.q("directIpNum", String.valueOf(bVar4.num));
            hc.q("directIpFailnum", String.valueOf(bVar4.ZI));
            hc.q("dnsFailNum", String.valueOf(Zn.Zr));
            if (10000 == i) {
                hc.q("isWifi", "1");
                hc.q("netType", "WIFI");
            } else if (100002 == i) {
                hc.q("netType", "3G");
                hc.q("isWifi", "0");
            } else {
                hc.q("netType", "2G");
                hc.q("isWifi", "0");
            }
            hc.q("localIp", f.getIp());
            hc.q("tbIp", str);
            hc.q("cdnIp", str2);
            hc.q("dnsIp", str3);
            com.baidu.adp.lib.stats.a.hj().b("img", hc);
        }
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.k.je()) {
            synchronized (vM) {
                Zp.num++;
                if (z) {
                    Zp.time += j;
                } else {
                    Zp.ZI++;
                }
                if (Zp.num >= 100) {
                    tM();
                }
            }
            if (!z) {
                if (dVar == null) {
                    dVar = hc();
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
                com.baidu.adp.lib.stats.a.hj().b("img", dVar);
            }
        }
    }

    public static void tM() {
        if (Zp.num > 10) {
            com.baidu.adp.lib.stats.d hc = hc();
            hc.q("act", "dcStat");
            hc.q("costTime", String.valueOf(Zp.time));
            hc.q("num", String.valueOf(Zp.num));
            hc.q("failnum", String.valueOf(Zp.ZI));
            com.baidu.adp.lib.stats.a.hj().b("img", hc);
            com.baidu.tbadk.performanceLog.v.a(Zp.num, Zp.ZI, Zp.time);
            Zp.reset();
        }
    }

    public static void db(String str) {
        com.baidu.adp.lib.stats.d hc = hc();
        hc.q("act", "assistant");
        hc.q(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
        com.baidu.adp.lib.stats.a.hj().b("img", hc);
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
        if (Zl >= 3) {
            return Zm;
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
            if (Zl > -1) {
                Zm = ((Zm * Zl) + j) / (Zl + 1);
            } else {
                Zm = j;
            }
            Zl++;
            return j;
        }
        return j;
    }

    private static String tP() {
        return com.baidu.tbadk.imageManager.c.BV().fN();
    }

    private static String tQ() {
        return com.baidu.adp.lib.asyncTask.c.fO().fN();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.d hc = hc();
        hc.q("act", "getCDNList");
        hc.q("errorNum", str);
        hc.q("errorMsg", str2);
        hc.q("isShortNetError", z2 ? "1" : "0");
        hc.q("isSuccess", z ? "1" : "0");
        com.baidu.adp.lib.stats.a.hj().b("img", hc);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = s.tZ().dc(str);
        }
        String tN = tN();
        String ip = f.getIp();
        com.baidu.adp.lib.stats.d hc = hc();
        hc.q("act", "tachometerCDN");
        hc.q("errorNum", str3);
        hc.q("execption", str4);
        hc.q("size", str5);
        hc.q("isScuess", z ? "1" : "0");
        hc.q("url", str);
        hc.q("localIp", ip);
        hc.q("cdnIp", str6);
        hc.q("dnsIP", tN);
        hc.q("usedIp", str2);
        hc.q("isUsedIp", z2 ? "0" : "1");
        hc.q("costTime", String.valueOf(j));
        com.baidu.adp.lib.stats.a.hj().b("img", hc);
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
                    com.baidu.adp.lib.stats.d hc = hc();
                    hc.q("act", "mobileTachometerCDN");
                    hc.q("costTime", String.valueOf(j));
                    hc.q("ipList", sb.toString());
                    com.baidu.adp.lib.stats.a.hj().b("img", hc);
                    return;
                }
            }
        }
    }

    public static void c(boolean z, String str) {
        com.baidu.adp.lib.stats.d hc = hc();
        hc.q("act", "getCDNList");
        hc.q("isSuccess", z ? "1" : "0");
        hc.q("errorMsg", str);
        com.baidu.adp.lib.stats.a.hj().b("img", hc);
    }
}
