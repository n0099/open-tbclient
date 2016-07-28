package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.support.v4.view.MotionEventCompat;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.EcommSellerErrorActivityConfig;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class v {
    private static long WJ = 0;
    private static long WK = 0;
    private static int WL = 0;
    private static a WM = new a(null);
    private static u WN = new u();
    private static u WO = new u();
    private static String WP = null;
    private static Object mV = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int WQ;
        boolean WR;
        u WS;
        u WT;
        u WU;
        u WV;
        u WW;
        u WX;
        u WY;
        u WZ;
        u Xa;
        u Xb;
        u Xc;
        u Xd;
        u Xe;
        u Xf;
        u Xg;

        private a() {
            this.WQ = 0;
            this.WS = new u();
            this.WT = new u();
            this.WU = new u();
            this.WV = new u();
            this.WW = new u();
            this.WX = new u();
            this.WY = new u();
            this.WZ = new u();
            this.Xa = new u();
            this.Xb = new u();
            this.Xc = new u();
            this.Xd = new u();
            this.Xe = new u();
            this.Xf = new u();
            this.Xg = new u();
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [74=4] */
        public int tk() {
            return this.WS.num + this.WT.num + this.WU.num + this.WV.num + this.WW.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [80=14] */
        public int tl() {
            return this.WS.num + this.WT.num + this.WU.num + this.WV.num + this.WW.num + this.WX.num + this.WY.num + this.WZ.num + this.Xa.num + this.Xb.num + this.Xc.num + this.Xd.num + this.Xe.num + this.Xf.num + this.Xg.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [91=4] */
        public int tm() {
            return this.WX.num + this.WY.num + this.WZ.num + this.Xa.num + this.Xb.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
        public int tn() {
            return this.Xc.num + this.Xd.num + this.Xe.num + this.Xf.num + this.Xg.num;
        }

        public void reset() {
            this.WQ = 0;
            this.WS.reset();
            this.WT.reset();
            this.WU.reset();
            this.WV.reset();
            this.WW.reset();
            this.WX.reset();
            this.WY.reset();
            this.WZ.reset();
            this.Xa.reset();
            this.Xb.reset();
            this.Xc.reset();
            this.Xd.reset();
            this.Xe.reset();
            this.Xf.reset();
            this.Xg.reset();
        }
    }

    private static u a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return WM.WS;
            }
            if (str.startsWith("http://tb.himg")) {
                return WM.WT;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return WM.WU;
            }
            if (z2 && z3) {
                return WM.WW;
            }
            return WM.WV;
        } else if (com.baidu.adp.lib.util.i.fv()) {
            if (z2) {
                return WM.WX;
            }
            if (str.startsWith("http://tb.himg")) {
                return WM.WY;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return WM.WZ;
            }
            return WM.Xa;
        } else if (z2) {
            return WM.Xc;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return WM.Xd;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return WM.Xe;
            }
            return WM.Xf;
        }
    }

    public static com.baidu.adp.lib.stats.d dG() {
        return com.baidu.adp.lib.stats.a.dN().an("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (mV) {
                WN.num++;
                WN.time += j;
                if (WN.num >= 100) {
                    td();
                }
            }
        }
    }

    public static void td() {
        if (WN.num > 10) {
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("act", "locStat");
            dG.q("costTime", String.valueOf(WN.time));
            dG.q("num", String.valueOf(WN.num));
            dG.q("isWifi", "1");
            com.baidu.adp.lib.stats.a.dN().b("img", dG);
            WN.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.e eVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.k.fH() && eVar != null) {
            String str6 = "";
            boolean gl = com.baidu.tbadk.util.h.gl(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().ZG) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean fr = com.baidu.adp.lib.util.i.fr();
            if (!z5) {
                z4 = false;
            } else if (fr) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().KS);
            } else if (com.baidu.adp.lib.util.i.fv()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().KU);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().KT);
            }
            boolean z6 = false;
            if (gl && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (gl && fr && z6) {
                if (z) {
                    r.getInstance().insertNormalData(j, str);
                } else {
                    str6 = w.to().tp();
                    if (!TextUtils.isEmpty(str6)) {
                        r.getInstance().insertErrorData(eVar.lR, str);
                    }
                }
            }
            if (gl) {
                WP = str;
            }
            boolean z7 = false;
            if (eVar.lT != null && eVar.lT.length() > 0) {
                z7 = true;
            }
            synchronized (mV) {
                u a2 = a(fr, gl, str2, z7);
                boolean z8 = WM.WR;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.lK += j2;
                        WM.WR = true;
                        if (z4) {
                            a2.WI++;
                        }
                        WL = 0;
                    } else {
                        if (com.baidu.adp.lib.util.i.fq()) {
                            int i2 = WL + 1;
                            WL = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.eI().getMaxAlertCount("alert_img", 5)) {
                                com.baidu.adp.lib.stats.a.dN().p("alert_img", "imgFailedCnt_" + String.valueOf(WL) + "_url=" + str2);
                            }
                        }
                        a2.WH++;
                        WM.WR = false;
                    }
                }
                int tl = WM.tl();
                if (tl > 100 || (tl > 0 && z8 != WM.WR)) {
                    te();
                }
            }
            if (z && z5) {
                if (!fr || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().KS) {
                    if (fr || !com.baidu.adp.lib.util.i.fv() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().KU) {
                        if (!fr && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().KT) {
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
                dVar = dG();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = w.to().tp();
            }
            if (!gl || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = w.to().dj(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = tg();
            }
            dVar.q("url", str);
            dVar.q("act", "dl");
            dVar.q("result", z ? "1" : "0");
            dVar.q("fullurl", str2);
            dVar.q("netlib", String.valueOf(eVar.lX));
            dVar.q("costTime", String.valueOf(j));
            dVar.q("connTime", String.valueOf(eVar.lL));
            dVar.q("rspTime", String.valueOf(eVar.lM));
            dVar.q("retry", String.valueOf(eVar.lN));
            dVar.q("localIp", e.getIp());
            dVar.q("tiebaIp", str6);
            dVar.q("cdnIp", str4);
            dVar.q("useIp", eVar.lT);
            dVar.q("dnsIp", str5);
            if (eVar.lL > 1500 || eVar.lL < 0) {
                dVar.q("connBaidu", String.valueOf(th()));
            }
            dVar.q("memory", ti());
            dVar.q("task", tj());
            dVar.q("status", String.valueOf(eVar.lS));
            dVar.q("up", String.valueOf(eVar.lJ));
            dVar.q("down", String.valueOf(eVar.lK));
            dVar.q("isCDN", gl ? "1" : "0");
            dVar.q("isWebp", bool.booleanValue() ? "1" : "0");
            dVar.q("isMobileProxy", z3 ? "1" : "0");
            dVar.q("exception", eVar.lQ);
            dVar.q("reason", str3);
            if (i != 0) {
                dVar.d("procType", Integer.valueOf(i));
            }
            if (eVar.lV != null) {
                dVar.q("tracecode1", eVar.lV);
            }
            if (eVar.lW != null) {
                dVar.q("tracecode2", eVar.lW);
            }
            com.baidu.adp.lib.stats.a.dN().b("img", dVar);
            if (gl && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                WM.WQ++;
            }
        }
    }

    public static void te() {
        if (WM.tl() > 10) {
            if (WM.tk() > 0) {
                a(WM.WS, WM.WT, WM.WU, WM.WW, WM.WV, 10000);
                com.baidu.tbadk.performanceLog.x.b(WM.WS, WM.WT, WM.WU, WM.WW, WM.WV, 3);
            }
            if (WM.tn() > 0) {
                a(WM.Xc, WM.Xd, WM.Xe, WM.Xg, WM.Xf, 100002);
                com.baidu.tbadk.performanceLog.x.b(WM.Xc, WM.Xd, WM.Xe, WM.Xg, WM.Xf, 2);
            }
            if (WM.tm() > 0) {
                a(WM.WX, WM.WY, WM.WZ, WM.Xb, WM.Xa, 100001);
                com.baidu.tbadk.performanceLog.x.b(WM.WX, WM.WY, WM.WZ, WM.Xb, WM.Xa, 1);
            }
            WM.reset();
        }
    }

    public static void a(u uVar, u uVar2, u uVar3, u uVar4, u uVar5, int i) {
        if (uVar != null && uVar2 != null && uVar3 != null && uVar4 != null && uVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = w.to().tp();
            }
            if (WP != null && TextUtils.isEmpty("")) {
                str2 = w.to().dj(WP);
            }
            if (TextUtils.isEmpty("")) {
                str3 = tg();
            }
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("act", "dlStat");
            dG.q("cdnCostTime", String.valueOf(uVar.time));
            dG.q("cdnNum", String.valueOf(uVar.num));
            dG.q("cdnFailnum", String.valueOf(uVar.WH));
            dG.q("portraitCostTime", String.valueOf(uVar2.time));
            dG.q("portraitNum", String.valueOf(uVar2.num));
            dG.q("portraitFailnum", String.valueOf(uVar2.WH));
            dG.q("tiebaCostTime", String.valueOf(uVar3.time));
            dG.q("tiebaNum", String.valueOf(uVar3.num));
            dG.q("tiebaFailnum", String.valueOf(uVar3.WH));
            dG.q("otherCostTime", String.valueOf(uVar5.time));
            dG.q("otherNum", String.valueOf(uVar5.num));
            dG.q("otherFailnum", String.valueOf(uVar5.WH));
            dG.q("directIpCostTime", String.valueOf(uVar4.time));
            dG.q("directIpNum", String.valueOf(uVar4.num));
            dG.q("directIpFailnum", String.valueOf(uVar4.WH));
            dG.q("dnsFailNum", String.valueOf(WM.WQ));
            if (10000 == i) {
                dG.q("isWifi", "1");
                dG.q("netType", "WIFI");
            } else if (100002 == i) {
                dG.q("netType", "3G");
                dG.q("isWifi", "0");
            } else {
                dG.q("netType", "2G");
                dG.q("isWifi", "0");
            }
            dG.q("localIp", e.getIp());
            dG.q("tbIp", str);
            dG.q("cdnIp", str2);
            dG.q("dnsIp", str3);
            com.baidu.adp.lib.stats.a.dN().b("img", dG);
        }
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.k.fH()) {
            synchronized (mV) {
                WO.num++;
                if (z) {
                    WO.time += j;
                } else {
                    WO.WH++;
                }
                if (WO.num >= 100) {
                    tf();
                }
            }
            if (!z) {
                if (dVar == null) {
                    dVar = dG();
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
                com.baidu.adp.lib.stats.a.dN().b("img", dVar);
            }
        }
    }

    public static void tf() {
        if (WO.num > 10) {
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("act", "dcStat");
            dG.q("costTime", String.valueOf(WO.time));
            dG.q("num", String.valueOf(WO.num));
            dG.q("failnum", String.valueOf(WO.WH));
            com.baidu.adp.lib.stats.a.dN().b("img", dG);
            com.baidu.tbadk.performanceLog.x.a(WO.num, WO.WH, WO.time);
            WO.reset();
        }
    }

    public static void di(String str) {
        com.baidu.adp.lib.stats.d dG = dG();
        dG.q("act", "assistant");
        dG.q(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
        com.baidu.adp.lib.stats.a.dN().b("img", dG);
    }

    private static String tg() {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [598=4] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long th() {
        HttpURLConnection httpURLConnection;
        long j;
        if (WJ >= 3) {
            return WK;
        }
        long currentTimeMillis = System.currentTimeMillis();
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL("http://www.baidu.com/").openConnection();
            try {
                httpURLConnection.setConnectTimeout(2500);
                httpURLConnection.connect();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.h.a.f(httpURLConnection);
                j = currentTimeMillis2;
            } catch (SocketTimeoutException e) {
                com.baidu.adp.lib.h.a.f(httpURLConnection);
                j = 2500;
                if (j > 0) {
                }
            } catch (Exception e2) {
                httpURLConnection2 = httpURLConnection;
                com.baidu.adp.lib.h.a.f(httpURLConnection2);
                j = -1;
                if (j > 0) {
                }
            } catch (Throwable th) {
                httpURLConnection2 = httpURLConnection;
                th = th;
                com.baidu.adp.lib.h.a.f(httpURLConnection2);
                throw th;
            }
        } catch (SocketTimeoutException e3) {
            httpURLConnection = null;
        } catch (Exception e4) {
        } catch (Throwable th2) {
            th = th2;
        }
        if (j > 0) {
            if (WJ > -1) {
                WK = ((WK * WJ) + j) / (WJ + 1);
            } else {
                WK = j;
            }
            WJ++;
            return j;
        }
        return j;
    }

    private static String ti() {
        return com.baidu.tbadk.imageManager.c.CP().ck();
    }

    private static String tj() {
        return com.baidu.adp.lib.asyncTask.c.cl().ck();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.d dG = dG();
        dG.q("act", "getCDNList");
        dG.q("errorNum", str);
        dG.q(EcommSellerErrorActivityConfig.ERROR_MSG, str2);
        dG.q("isShortNetError", z2 ? "1" : "0");
        dG.q("isSuccess", z ? "1" : "0");
        com.baidu.adp.lib.stats.a.dN().b("img", dG);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = w.to().dj(str);
        }
        String tg = tg();
        String ip = e.getIp();
        com.baidu.adp.lib.stats.d dG = dG();
        dG.q("act", "tachometerCDN");
        dG.q("errorNum", str3);
        dG.q("execption", str4);
        dG.q("size", str5);
        dG.q("isScuess", z ? "1" : "0");
        dG.q("url", str);
        dG.q("localIp", ip);
        dG.q("cdnIp", str6);
        dG.q("dnsIP", tg);
        dG.q("usedIp", str2);
        dG.q("isUsedIp", z2 ? "0" : "1");
        dG.q("costTime", String.valueOf(j));
        com.baidu.adp.lib.stats.a.dN().b("img", dG);
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
                    com.baidu.adp.lib.stats.d dG = dG();
                    dG.q("act", "mobileTachometerCDN");
                    dG.q("costTime", String.valueOf(j));
                    dG.q("ipList", sb.toString());
                    com.baidu.adp.lib.stats.a.dN().b("img", dG);
                    return;
                }
            }
        }
    }

    public static void d(boolean z, String str) {
        com.baidu.adp.lib.stats.d dG = dG();
        dG.q("act", "getCDNList");
        dG.q("isSuccess", z ? "1" : "0");
        dG.q(EcommSellerErrorActivityConfig.ERROR_MSG, str);
        com.baidu.adp.lib.stats.a.dN().b("img", dG);
    }

    public static void a(String str, int i, int i2, int i3) {
        if (i == -1) {
            i = 0;
        }
        if (i2 == -1) {
            i2 = 0;
        }
        com.baidu.adp.lib.stats.a.dN().eventStat(null, str, "imgHttpSwitch", 1, "1sterrcode", String.valueOf(i), "2nderrcode", String.valueOf(i2), "2imgFailed", String.valueOf(i3));
    }
}
