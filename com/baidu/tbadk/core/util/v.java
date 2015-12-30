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
public class v {
    private static long aaB = 0;
    private static long aaC = 0;
    private static a aaD = new a(null);
    private static b aaE = new b(null);
    private static b aaF = new b(null);
    private static String aaG = null;
    private static Object vU = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        int aaY;
        int aaZ;
        int num;
        long time;
        long uT;

        private b() {
            this.num = 0;
            this.aaY = 0;
            this.time = 0L;
            this.uT = 0L;
            this.aaZ = 0;
        }

        /* synthetic */ b(b bVar) {
            this();
        }

        public void reset() {
            this.num = 0;
            this.aaY = 0;
            this.time = 0L;
            this.uT = 0L;
            this.aaZ = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int aaH;
        boolean aaI;
        b aaJ;
        b aaK;
        b aaL;
        b aaM;
        b aaN;
        b aaO;
        b aaP;
        b aaQ;
        b aaR;
        b aaS;
        b aaT;
        b aaU;
        b aaV;
        b aaW;
        b aaX;

        private a() {
            this.aaH = 0;
            this.aaJ = new b(null);
            this.aaK = new b(null);
            this.aaL = new b(null);
            this.aaM = new b(null);
            this.aaN = new b(null);
            this.aaO = new b(null);
            this.aaP = new b(null);
            this.aaQ = new b(null);
            this.aaR = new b(null);
            this.aaS = new b(null);
            this.aaT = new b(null);
            this.aaU = new b(null);
            this.aaV = new b(null);
            this.aaW = new b(null);
            this.aaX = new b(null);
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [88=4] */
        public int uh() {
            return this.aaJ.num + this.aaK.num + this.aaL.num + this.aaM.num + this.aaN.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [94=14] */
        public int ui() {
            return this.aaJ.num + this.aaK.num + this.aaL.num + this.aaM.num + this.aaN.num + this.aaO.num + this.aaP.num + this.aaQ.num + this.aaR.num + this.aaS.num + this.aaT.num + this.aaU.num + this.aaV.num + this.aaW.num + this.aaX.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [105=4] */
        public int uj() {
            return this.aaO.num + this.aaP.num + this.aaQ.num + this.aaR.num + this.aaS.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [111=4] */
        public int uk() {
            return this.aaT.num + this.aaU.num + this.aaV.num + this.aaW.num + this.aaX.num;
        }

        public void reset() {
            this.aaH = 0;
            this.aaJ.reset();
            this.aaK.reset();
            this.aaL.reset();
            this.aaM.reset();
            this.aaN.reset();
            this.aaO.reset();
            this.aaP.reset();
            this.aaQ.reset();
            this.aaR.reset();
            this.aaS.reset();
            this.aaT.reset();
            this.aaU.reset();
            this.aaV.reset();
            this.aaW.reset();
            this.aaX.reset();
        }

        public void ul() {
            if (v.aaD.uh() > 0) {
                com.baidu.tbadk.performanceLog.v.a(v.aaD.aaJ.num, v.aaD.aaJ.aaY, v.aaD.aaJ.aaZ, v.aaD.aaJ.uT, v.aaD.aaJ.time, v.aaD.aaK.num, v.aaD.aaK.aaY, v.aaD.aaK.aaZ, v.aaD.aaK.time, v.aaD.aaK.uT, v.aaD.aaL.num, v.aaD.aaL.aaY, v.aaD.aaL.aaZ, v.aaD.aaL.time, v.aaD.aaL.uT, v.aaD.aaN.num, v.aaD.aaN.aaY, v.aaD.aaN.aaZ, v.aaD.aaN.time, v.aaD.aaN.uT, v.aaD.aaM.num, v.aaD.aaM.aaY, v.aaD.aaM.aaZ, v.aaD.aaM.time, v.aaD.aaM.uT, 3);
            }
        }

        public void um() {
            if (v.aaD.uj() > 0) {
                com.baidu.tbadk.performanceLog.v.a(v.aaD.aaO.num, v.aaD.aaO.aaY, v.aaD.aaO.aaZ, v.aaD.aaO.time, v.aaD.aaO.uT, v.aaD.aaP.num, v.aaD.aaP.aaY, v.aaD.aaP.aaZ, v.aaD.aaP.time, v.aaD.aaP.uT, v.aaD.aaQ.num, v.aaD.aaQ.aaY, v.aaD.aaQ.aaZ, v.aaD.aaQ.time, v.aaD.aaQ.uT, v.aaD.aaS.num, v.aaD.aaS.aaY, v.aaD.aaS.aaZ, v.aaD.aaS.time, v.aaD.aaS.uT, v.aaD.aaR.num, v.aaD.aaR.aaY, v.aaD.aaR.aaZ, v.aaD.aaR.time, v.aaD.aaR.uT, 1);
            }
        }

        public void un() {
            if (v.aaD.uk() > 0) {
                com.baidu.tbadk.performanceLog.v.a(v.aaD.aaT.num, v.aaD.aaT.aaY, v.aaD.aaT.aaZ, v.aaD.aaT.time, v.aaD.aaT.uT, v.aaD.aaU.num, v.aaD.aaU.aaY, v.aaD.aaU.aaZ, v.aaD.aaU.time, v.aaD.aaU.uT, v.aaD.aaV.num, v.aaD.aaV.aaY, v.aaD.aaV.aaZ, v.aaD.aaV.time, v.aaD.aaV.uT, v.aaD.aaX.num, v.aaD.aaX.aaY, v.aaD.aaX.aaZ, v.aaD.aaX.time, v.aaD.aaX.uT, v.aaD.aaW.num, v.aaD.aaW.aaY, v.aaD.aaW.aaZ, v.aaD.aaW.time, v.aaD.aaW.uT, 2);
            }
        }
    }

    private static b a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return aaD.aaJ;
            }
            if (str.startsWith("http://tb.himg")) {
                return aaD.aaK;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aaD.aaL;
            }
            if (z2 && z3) {
                return aaD.aaN;
            }
            return aaD.aaM;
        } else if (com.baidu.adp.lib.util.i.iV()) {
            if (z2) {
                return aaD.aaO;
            }
            if (str.startsWith("http://tb.himg")) {
                return aaD.aaP;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aaD.aaQ;
            }
            return aaD.aaR;
        } else if (z2) {
            return aaD.aaT;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return aaD.aaU;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return aaD.aaV;
            }
            return aaD.aaW;
        }
    }

    public static com.baidu.adp.lib.stats.d he() {
        return com.baidu.adp.lib.stats.a.hl().ar("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (vU) {
                aaE.num++;
                aaE.time += j;
                if (aaE.num >= 100) {
                    tZ();
                }
            }
        }
    }

    public static void tZ() {
        if (aaE.num > 10) {
            com.baidu.adp.lib.stats.d he = he();
            he.q("act", "locStat");
            he.q("costTime", String.valueOf(aaE.time));
            he.q("num", String.valueOf(aaE.num));
            he.q("isWifi", "1");
            com.baidu.adp.lib.stats.a.hl().b("img", he);
            aaE.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.d dVar2, String str3, long j, boolean z3, long j2) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.k.jh()) {
            String str6 = "";
            boolean ge = com.baidu.tbadk.util.e.ge(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().adx) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean iR = com.baidu.adp.lib.util.i.iR();
            if (!z5) {
                z4 = false;
            } else if (iR) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Tj);
            } else if (com.baidu.adp.lib.util.i.iV()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Tl);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Tk);
            }
            boolean z6 = false;
            if (ge && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (ge && iR && z6) {
                if (z) {
                    s.getInstance().insertNormalData(j, str);
                } else {
                    str6 = w.uo().up();
                    if (!TextUtils.isEmpty(str6)) {
                        s.getInstance().insertErrorData(dVar2.va, str);
                    }
                }
            }
            if (ge) {
                aaG = str;
            }
            boolean z7 = false;
            if (dVar2.vc != null && dVar2.vc.length() > 0) {
                z7 = true;
            }
            synchronized (vU) {
                b a2 = a(iR, ge, str2, z7);
                boolean z8 = aaD.aaI;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.uT += j2;
                        aaD.aaI = true;
                        if (z4) {
                            a2.aaZ++;
                        }
                    } else {
                        a2.aaY++;
                        aaD.aaI = false;
                    }
                }
                int ui = aaD.ui();
                if (ui > 100 || (ui > 0 && z8 != aaD.aaI)) {
                    ua();
                }
            }
            if (z && z5) {
                if (!iR || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Tj) {
                    if (iR || !com.baidu.adp.lib.util.i.iV() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Tl) {
                        if (!iR && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Tk) {
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
                dVar = he();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = w.uo().up();
            }
            if (!ge || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = w.uo().dp(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = uc();
            }
            dVar.q("url", str);
            dVar.q("act", "dl");
            dVar.q("result", z ? "0" : "1");
            dVar.q("fullurl", str2);
            dVar.q("costTime", String.valueOf(j));
            dVar.q("connTime", String.valueOf(dVar2.uU));
            dVar.q("rspTime", String.valueOf(dVar2.uV));
            dVar.q("retry", String.valueOf(dVar2.uW));
            dVar.q("localIp", f.getIp());
            dVar.q("tiebaIp", str6);
            dVar.q("cdnIp", str4);
            dVar.q("useIp", dVar2.vc);
            dVar.q("dnsIp", str5);
            if (dVar2.uU > 1500 || dVar2.uU < 0) {
                dVar.q("connBaidu", String.valueOf(ud()));
            }
            dVar.q("memory", ue());
            dVar.q("task", uf());
            dVar.q("isWifi", iR ? "1" : "0");
            dVar.q("status", String.valueOf(dVar2.vb));
            dVar.q("up", String.valueOf(dVar2.uS));
            dVar.q("down", String.valueOf(dVar2.uT));
            dVar.q("isCDN", ge ? "1" : "0");
            dVar.q("isWebp", bool.booleanValue() ? "1" : "0");
            dVar.q("isMobileProxy", z3 ? "1" : "0");
            dVar.q("exception", dVar2.uZ);
            dVar.q("reason", str3);
            com.baidu.adp.lib.stats.a.hl().b("img", dVar);
            if (ge && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                aaD.aaH++;
            }
        }
    }

    public static void ua() {
        if (aaD.ui() > 10) {
            if (aaD.uh() > 0) {
                a(aaD.aaJ, aaD.aaK, aaD.aaL, aaD.aaN, aaD.aaM, 10000);
            }
            if (aaD.uk() > 0) {
                a(aaD.aaT, aaD.aaU, aaD.aaV, aaD.aaX, aaD.aaW, 100002);
            }
            if (aaD.uj() > 0) {
                a(aaD.aaO, aaD.aaP, aaD.aaQ, aaD.aaS, aaD.aaR, 100001);
            }
            aaD.ul();
            aaD.um();
            aaD.un();
            aaD.reset();
        }
    }

    public static void a(b bVar, b bVar2, b bVar3, b bVar4, b bVar5, int i) {
        if (bVar != null && bVar2 != null && bVar3 != null && bVar4 != null && bVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = w.uo().up();
            }
            if (aaG != null && TextUtils.isEmpty("")) {
                str2 = w.uo().dp(aaG);
            }
            if (TextUtils.isEmpty("")) {
                str3 = uc();
            }
            com.baidu.adp.lib.stats.d he = he();
            he.q("act", "dlStat");
            he.q("cdnCostTime", String.valueOf(bVar.time));
            he.q("cdnNum", String.valueOf(bVar.num));
            he.q("cdnFailnum", String.valueOf(bVar.aaY));
            he.q("portraitCostTime", String.valueOf(bVar2.time));
            he.q("portraitNum", String.valueOf(bVar2.num));
            he.q("portraitFailnum", String.valueOf(bVar2.aaY));
            he.q("tiebaCostTime", String.valueOf(bVar3.time));
            he.q("tiebaNum", String.valueOf(bVar3.num));
            he.q("tiebaFailnum", String.valueOf(bVar3.aaY));
            he.q("otherCostTime", String.valueOf(bVar5.time));
            he.q("otherNum", String.valueOf(bVar5.num));
            he.q("otherFailnum", String.valueOf(bVar5.aaY));
            he.q("directIpCostTime", String.valueOf(bVar4.time));
            he.q("directIpNum", String.valueOf(bVar4.num));
            he.q("directIpFailnum", String.valueOf(bVar4.aaY));
            he.q("dnsFailNum", String.valueOf(aaD.aaH));
            if (10000 == i) {
                he.q("isWifi", "1");
                he.q("netType", "WIFI");
            } else if (100002 == i) {
                he.q("netType", "3G");
                he.q("isWifi", "0");
            } else {
                he.q("netType", "2G");
                he.q("isWifi", "0");
            }
            he.q("localIp", f.getIp());
            he.q("tbIp", str);
            he.q("cdnIp", str2);
            he.q("dnsIp", str3);
            com.baidu.adp.lib.stats.a.hl().b("img", he);
        }
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.k.jh()) {
            synchronized (vU) {
                aaF.num++;
                if (z) {
                    aaF.time += j;
                } else {
                    aaF.aaY++;
                }
                if (aaF.num >= 100) {
                    ub();
                }
            }
            if (!z) {
                if (dVar == null) {
                    dVar = he();
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
                com.baidu.adp.lib.stats.a.hl().b("img", dVar);
            }
        }
    }

    public static void ub() {
        if (aaF.num > 10) {
            com.baidu.adp.lib.stats.d he = he();
            he.q("act", "dcStat");
            he.q("costTime", String.valueOf(aaF.time));
            he.q("num", String.valueOf(aaF.num));
            he.q("failnum", String.valueOf(aaF.aaY));
            com.baidu.adp.lib.stats.a.hl().b("img", he);
            com.baidu.tbadk.performanceLog.v.a(aaF.num, aaF.aaY, aaF.time);
            aaF.reset();
        }
    }

    public static void dn(String str) {
        com.baidu.adp.lib.stats.d he = he();
        he.q("act", "assistant");
        he.q(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
        com.baidu.adp.lib.stats.a.hl().b("img", he);
    }

    private static String uc() {
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
    private static long ud() {
        HttpURLConnection httpURLConnection;
        long j;
        if (aaB >= 3) {
            return aaC;
        }
        long currentTimeMillis = System.currentTimeMillis();
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL("http://www.baidu.com/").openConnection();
            try {
                httpURLConnection.setConnectTimeout(2500);
                httpURLConnection.connect();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.h.a.e(httpURLConnection);
                j = currentTimeMillis2;
            } catch (SocketTimeoutException e) {
                com.baidu.adp.lib.h.a.e(httpURLConnection);
                j = 2500;
                if (j > 0) {
                }
            } catch (Exception e2) {
                httpURLConnection2 = httpURLConnection;
                com.baidu.adp.lib.h.a.e(httpURLConnection2);
                j = -1;
                if (j > 0) {
                }
            } catch (Throwable th) {
                httpURLConnection2 = httpURLConnection;
                th = th;
                com.baidu.adp.lib.h.a.e(httpURLConnection2);
                throw th;
            }
        } catch (SocketTimeoutException e3) {
            httpURLConnection = null;
        } catch (Exception e4) {
        } catch (Throwable th2) {
            th = th2;
        }
        if (j > 0) {
            if (aaB > -1) {
                aaC = ((aaC * aaB) + j) / (aaB + 1);
            } else {
                aaC = j;
            }
            aaB++;
            return j;
        }
        return j;
    }

    private static String ue() {
        return com.baidu.tbadk.imageManager.c.CM().fN();
    }

    private static String uf() {
        return com.baidu.adp.lib.asyncTask.c.fO().fN();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.d he = he();
        he.q("act", "getCDNList");
        he.q("errorNum", str);
        he.q("errorMsg", str2);
        he.q("isShortNetError", z2 ? "1" : "0");
        he.q("isSuccess", z ? "1" : "0");
        com.baidu.adp.lib.stats.a.hl().b("img", he);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = w.uo().dp(str);
        }
        String uc = uc();
        String ip = f.getIp();
        com.baidu.adp.lib.stats.d he = he();
        he.q("act", "tachometerCDN");
        he.q("errorNum", str3);
        he.q("execption", str4);
        he.q("size", str5);
        he.q("isScuess", z ? "1" : "0");
        he.q("url", str);
        he.q("localIp", ip);
        he.q("cdnIp", str6);
        he.q("dnsIP", uc);
        he.q("usedIp", str2);
        he.q("isUsedIp", z2 ? "0" : "1");
        he.q("costTime", String.valueOf(j));
        com.baidu.adp.lib.stats.a.hl().b("img", he);
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
                    com.baidu.adp.lib.stats.d he = he();
                    he.q("act", "mobileTachometerCDN");
                    he.q("costTime", String.valueOf(j));
                    he.q("ipList", sb.toString());
                    com.baidu.adp.lib.stats.a.hl().b("img", he);
                    return;
                }
            }
        }
    }

    public static void c(boolean z, String str) {
        com.baidu.adp.lib.stats.d he = he();
        he.q("act", "getCDNList");
        he.q("isSuccess", z ? "1" : "0");
        he.q("errorMsg", str);
        com.baidu.adp.lib.stats.a.hl().b("img", he);
    }
}
