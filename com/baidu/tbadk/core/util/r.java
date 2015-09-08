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
    private static Object vL = new Object();

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
        public int tU() {
            return this.Zt.num + this.Zu.num + this.Zv.num + this.Zw.num + this.Zx.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [94=14] */
        public int tV() {
            return this.Zt.num + this.Zu.num + this.Zv.num + this.Zw.num + this.Zx.num + this.Zy.num + this.Zz.num + this.ZA.num + this.ZB.num + this.ZC.num + this.ZD.num + this.ZE.num + this.ZF.num + this.ZG.num + this.ZH.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [105=4] */
        public int tW() {
            return this.Zy.num + this.Zz.num + this.ZA.num + this.ZB.num + this.ZC.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [111=4] */
        public int tX() {
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

        public void tY() {
            if (r.Zn.tU() > 0) {
                com.baidu.tbadk.performanceLog.v.a(r.Zn.Zt.num, r.Zn.Zt.ZI, r.Zn.Zt.ZK, r.Zn.Zt.ZJ, r.Zn.Zt.time, r.Zn.Zu.num, r.Zn.Zu.ZI, r.Zn.Zu.ZK, r.Zn.Zu.time, r.Zn.Zu.ZJ, r.Zn.Zv.num, r.Zn.Zv.ZI, r.Zn.Zv.ZK, r.Zn.Zv.time, r.Zn.Zv.ZJ, r.Zn.Zx.num, r.Zn.Zx.ZI, r.Zn.Zx.ZK, r.Zn.Zx.time, r.Zn.Zx.ZJ, r.Zn.Zw.num, r.Zn.Zw.ZI, r.Zn.Zw.ZK, r.Zn.Zw.time, r.Zn.Zw.ZJ, 3);
            }
        }

        public void tZ() {
            if (r.Zn.tW() > 0) {
                com.baidu.tbadk.performanceLog.v.a(r.Zn.Zy.num, r.Zn.Zy.ZI, r.Zn.Zy.ZK, r.Zn.Zy.time, r.Zn.Zy.ZJ, r.Zn.Zz.num, r.Zn.Zz.ZI, r.Zn.Zz.ZK, r.Zn.Zz.time, r.Zn.Zz.ZJ, r.Zn.ZA.num, r.Zn.ZA.ZI, r.Zn.ZA.ZK, r.Zn.ZA.time, r.Zn.ZA.ZJ, r.Zn.ZC.num, r.Zn.ZC.ZI, r.Zn.ZC.ZK, r.Zn.ZC.time, r.Zn.ZC.ZJ, r.Zn.ZB.num, r.Zn.ZB.ZI, r.Zn.ZB.ZK, r.Zn.ZB.time, r.Zn.ZB.ZJ, 1);
            }
        }

        public void ua() {
            if (r.Zn.tX() > 0) {
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
        } else if (com.baidu.adp.lib.util.i.iQ()) {
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

    public static com.baidu.adp.lib.stats.d ha() {
        return com.baidu.adp.lib.stats.a.hh().ap("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (vL) {
                Zo.num++;
                Zo.time += j;
                if (Zo.num >= 100) {
                    tM();
                }
            }
        }
    }

    public static void tM() {
        if (Zo.num > 10) {
            com.baidu.adp.lib.stats.d ha = ha();
            ha.q("act", "locStat");
            ha.q("costTime", String.valueOf(Zo.time));
            ha.q("num", String.valueOf(Zo.num));
            ha.q("isWifi", "1");
            com.baidu.adp.lib.stats.a.hh().b("img", ha);
            Zo.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar2, String str3, long j, boolean z3, long j2) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.k.jc()) {
            String str6 = "";
            boolean fF = com.baidu.tbadk.util.d.fF(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().abT) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean iM = com.baidu.adp.lib.util.i.iM();
            if (!z5) {
                z4 = false;
            } else if (iM) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().SG);
            } else if (com.baidu.adp.lib.util.i.iQ()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().SI);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().SH);
            }
            boolean z6 = false;
            if (fF && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (fF && iM && z6) {
                if (z) {
                    p.getInstance().insertNormalData(j, str);
                } else {
                    str6 = s.ub().uc();
                    if (!TextUtils.isEmpty(str6)) {
                        p.getInstance().insertErrorData(dVar2.uS, str);
                    }
                }
            }
            if (fF) {
                Zq = str;
            }
            boolean z7 = false;
            if (dVar2.uU != null && dVar2.uU.length() > 0) {
                z7 = true;
            }
            synchronized (vL) {
                b a2 = a(iM, fF, str2, z7);
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
                int tV = Zn.tV();
                if (tV > 100 || (tV > 0 && z8 != Zn.Zs)) {
                    tN();
                }
            }
            if (z && z5) {
                if (!iM || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().SG) {
                    if (iM || !com.baidu.adp.lib.util.i.iQ() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().SI) {
                        if (!iM && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().SH) {
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
                dVar = ha();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = s.ub().uc();
            }
            if (!fF || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = s.ub().cY(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = tP();
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
                dVar.q("connBaidu", String.valueOf(tQ()));
            }
            dVar.q("memory", tR());
            dVar.q("task", tS());
            dVar.q("isWifi", iM ? "1" : "0");
            dVar.q("status", String.valueOf(dVar2.uT));
            dVar.q("up", String.valueOf(dVar2.uK));
            dVar.q("down", String.valueOf(dVar2.uL));
            dVar.q("isCDN", fF ? "1" : "0");
            dVar.q("isWebp", bool.booleanValue() ? "1" : "0");
            dVar.q("isMobileProxy", z3 ? "1" : "0");
            dVar.q("exception", dVar2.uR);
            dVar.q("reason", str3);
            com.baidu.adp.lib.stats.a.hh().b("img", dVar);
            if (fF && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                Zn.Zr++;
            }
        }
    }

    public static void tN() {
        if (Zn.tV() > 10) {
            if (Zn.tU() > 0) {
                a(Zn.Zt, Zn.Zu, Zn.Zv, Zn.Zx, Zn.Zw, 10000);
            }
            if (Zn.tX() > 0) {
                a(Zn.ZD, Zn.ZE, Zn.ZF, Zn.ZH, Zn.ZG, 100002);
            }
            if (Zn.tW() > 0) {
                a(Zn.Zy, Zn.Zz, Zn.ZA, Zn.ZC, Zn.ZB, 100001);
            }
            Zn.tY();
            Zn.tZ();
            Zn.ua();
            Zn.reset();
        }
    }

    public static void a(b bVar, b bVar2, b bVar3, b bVar4, b bVar5, int i) {
        if (bVar != null && bVar2 != null && bVar3 != null && bVar4 != null && bVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = s.ub().uc();
            }
            if (Zq != null && TextUtils.isEmpty("")) {
                str2 = s.ub().cY(Zq);
            }
            if (TextUtils.isEmpty("")) {
                str3 = tP();
            }
            com.baidu.adp.lib.stats.d ha = ha();
            ha.q("act", "dlStat");
            ha.q("cdnCostTime", String.valueOf(bVar.time));
            ha.q("cdnNum", String.valueOf(bVar.num));
            ha.q("cdnFailnum", String.valueOf(bVar.ZI));
            ha.q("portraitCostTime", String.valueOf(bVar2.time));
            ha.q("portraitNum", String.valueOf(bVar2.num));
            ha.q("portraitFailnum", String.valueOf(bVar2.ZI));
            ha.q("tiebaCostTime", String.valueOf(bVar3.time));
            ha.q("tiebaNum", String.valueOf(bVar3.num));
            ha.q("tiebaFailnum", String.valueOf(bVar3.ZI));
            ha.q("otherCostTime", String.valueOf(bVar5.time));
            ha.q("otherNum", String.valueOf(bVar5.num));
            ha.q("otherFailnum", String.valueOf(bVar5.ZI));
            ha.q("directIpCostTime", String.valueOf(bVar4.time));
            ha.q("directIpNum", String.valueOf(bVar4.num));
            ha.q("directIpFailnum", String.valueOf(bVar4.ZI));
            ha.q("dnsFailNum", String.valueOf(Zn.Zr));
            if (10000 == i) {
                ha.q("isWifi", "1");
                ha.q("netType", "WIFI");
            } else if (100002 == i) {
                ha.q("netType", "3G");
                ha.q("isWifi", "0");
            } else {
                ha.q("netType", "2G");
                ha.q("isWifi", "0");
            }
            ha.q("localIp", f.getIp());
            ha.q("tbIp", str);
            ha.q("cdnIp", str2);
            ha.q("dnsIp", str3);
            com.baidu.adp.lib.stats.a.hh().b("img", ha);
        }
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.k.jc()) {
            synchronized (vL) {
                Zp.num++;
                if (z) {
                    Zp.time += j;
                } else {
                    Zp.ZI++;
                }
                if (Zp.num >= 100) {
                    tO();
                }
            }
            if (!z) {
                if (dVar == null) {
                    dVar = ha();
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
                com.baidu.adp.lib.stats.a.hh().b("img", dVar);
            }
        }
    }

    public static void tO() {
        if (Zp.num > 10) {
            com.baidu.adp.lib.stats.d ha = ha();
            ha.q("act", "dcStat");
            ha.q("costTime", String.valueOf(Zp.time));
            ha.q("num", String.valueOf(Zp.num));
            ha.q("failnum", String.valueOf(Zp.ZI));
            com.baidu.adp.lib.stats.a.hh().b("img", ha);
            com.baidu.tbadk.performanceLog.v.a(Zp.num, Zp.ZI, Zp.time);
            Zp.reset();
        }
    }

    public static void cX(String str) {
        com.baidu.adp.lib.stats.d ha = ha();
        ha.q("act", "assistant");
        ha.q(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
        com.baidu.adp.lib.stats.a.hh().b("img", ha);
    }

    private static String tP() {
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
    private static long tQ() {
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

    private static String tR() {
        return com.baidu.tbadk.imageManager.c.Cs().fN();
    }

    private static String tS() {
        return com.baidu.adp.lib.asyncTask.c.fO().fN();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.d ha = ha();
        ha.q("act", "getCDNList");
        ha.q("errorNum", str);
        ha.q("errorMsg", str2);
        ha.q("isShortNetError", z2 ? "1" : "0");
        ha.q("isSuccess", z ? "1" : "0");
        com.baidu.adp.lib.stats.a.hh().b("img", ha);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = s.ub().cY(str);
        }
        String tP = tP();
        String ip = f.getIp();
        com.baidu.adp.lib.stats.d ha = ha();
        ha.q("act", "tachometerCDN");
        ha.q("errorNum", str3);
        ha.q("execption", str4);
        ha.q("size", str5);
        ha.q("isScuess", z ? "1" : "0");
        ha.q("url", str);
        ha.q("localIp", ip);
        ha.q("cdnIp", str6);
        ha.q("dnsIP", tP);
        ha.q("usedIp", str2);
        ha.q("isUsedIp", z2 ? "0" : "1");
        ha.q("costTime", String.valueOf(j));
        com.baidu.adp.lib.stats.a.hh().b("img", ha);
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
                    com.baidu.adp.lib.stats.d ha = ha();
                    ha.q("act", "mobileTachometerCDN");
                    ha.q("costTime", String.valueOf(j));
                    ha.q("ipList", sb.toString());
                    com.baidu.adp.lib.stats.a.hh().b("img", ha);
                    return;
                }
            }
        }
    }

    public static void c(boolean z, String str) {
        com.baidu.adp.lib.stats.d ha = ha();
        ha.q("act", "getCDNList");
        ha.q("isSuccess", z ? "1" : "0");
        ha.q("errorMsg", str);
        com.baidu.adp.lib.stats.a.hh().b("img", ha);
    }
}
