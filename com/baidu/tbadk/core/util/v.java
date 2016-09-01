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
    private static long Zx = 0;
    private static long Zy = 0;
    private static int Zz = 0;
    private static a ZA = new a(null);
    private static u ZB = new u();
    private static u ZC = new u();
    private static String ZD = null;
    private static Object pt = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        int ZE;
        boolean ZF;
        u ZG;
        u ZH;
        u ZI;
        u ZJ;
        u ZK;
        u ZL;
        u ZM;
        u ZN;
        u ZO;
        u ZP;
        u ZQ;
        u ZR;
        u ZS;
        u ZT;
        u ZU;

        private a() {
            this.ZE = 0;
            this.ZG = new u();
            this.ZH = new u();
            this.ZI = new u();
            this.ZJ = new u();
            this.ZK = new u();
            this.ZL = new u();
            this.ZM = new u();
            this.ZN = new u();
            this.ZO = new u();
            this.ZP = new u();
            this.ZQ = new u();
            this.ZR = new u();
            this.ZS = new u();
            this.ZT = new u();
            this.ZU = new u();
        }

        /* synthetic */ a(a aVar) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [74=4] */
        public int uq() {
            return this.ZG.num + this.ZH.num + this.ZI.num + this.ZJ.num + this.ZK.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [80=14] */
        public int ur() {
            return this.ZG.num + this.ZH.num + this.ZI.num + this.ZJ.num + this.ZK.num + this.ZL.num + this.ZM.num + this.ZN.num + this.ZO.num + this.ZP.num + this.ZQ.num + this.ZR.num + this.ZS.num + this.ZT.num + this.ZU.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [91=4] */
        public int us() {
            return this.ZL.num + this.ZM.num + this.ZN.num + this.ZO.num + this.ZP.num;
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [97=4] */
        public int ut() {
            return this.ZQ.num + this.ZR.num + this.ZS.num + this.ZT.num + this.ZU.num;
        }

        public void reset() {
            this.ZE = 0;
            this.ZG.reset();
            this.ZH.reset();
            this.ZI.reset();
            this.ZJ.reset();
            this.ZK.reset();
            this.ZL.reset();
            this.ZM.reset();
            this.ZN.reset();
            this.ZO.reset();
            this.ZP.reset();
            this.ZQ.reset();
            this.ZR.reset();
            this.ZS.reset();
            this.ZT.reset();
            this.ZU.reset();
        }
    }

    private static u a(boolean z, boolean z2, String str, boolean z3) {
        if (z) {
            if (z2 && !z3) {
                return ZA.ZG;
            }
            if (str.startsWith("http://tb.himg")) {
                return ZA.ZH;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return ZA.ZI;
            }
            if (z2 && z3) {
                return ZA.ZK;
            }
            return ZA.ZJ;
        } else if (com.baidu.adp.lib.util.i.gr()) {
            if (z2) {
                return ZA.ZL;
            }
            if (str.startsWith("http://tb.himg")) {
                return ZA.ZM;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return ZA.ZN;
            }
            return ZA.ZO;
        } else if (z2) {
            return ZA.ZQ;
        } else {
            if (str.startsWith("http://tb.himg")) {
                return ZA.ZR;
            }
            if (str.startsWith("http://c.tieba.baidu.com")) {
                return ZA.ZS;
            }
            return ZA.ZT;
        }
    }

    public static com.baidu.adp.lib.stats.d eB() {
        return com.baidu.adp.lib.stats.a.eI().ao("dbg");
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, boolean z, long j, boolean z2) {
        if (z && z2) {
            synchronized (pt) {
                ZB.num++;
                ZB.time += j;
                if (ZB.num >= 100) {
                    uj();
                }
            }
        }
    }

    public static void uj() {
        if (ZB.num > 10) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("act", "locStat");
            eB.q("costTime", String.valueOf(ZB.time));
            eB.q("num", String.valueOf(ZB.num));
            eB.q("isWifi", "1");
            com.baidu.adp.lib.stats.a.eI().b("img", eB);
            ZB.reset();
        }
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, boolean z, String str2, boolean z2, Boolean bool, com.baidu.adp.lib.network.http.e eVar, String str3, long j, boolean z3, long j2, int i) {
        boolean z4;
        String str4;
        String str5;
        if (com.baidu.adp.lib.util.k.gD() && eVar != null) {
            String str6 = "";
            boolean go = com.baidu.tbadk.util.h.go(str2);
            boolean z5 = false;
            if (com.baidu.tbadk.core.util.a.e.getInstance() != null) {
                z5 = true;
                if (!com.baidu.tbadk.core.util.a.e.getInstance().acv) {
                    com.baidu.tbadk.core.util.a.e.getInstance().init();
                }
            }
            boolean gn = com.baidu.adp.lib.util.i.gn();
            if (!z5) {
                z4 = false;
            } else if (gn) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Nf);
            } else if (com.baidu.adp.lib.util.i.gr()) {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Nh);
            } else {
                z4 = j > ((long) com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Ng);
            }
            boolean z6 = false;
            if (go && z5) {
                z6 = com.baidu.tbadk.core.util.a.e.getInstance().isShouldCDNFallBack();
            }
            if (go && gn && z6) {
                if (z) {
                    r.getInstance().insertNormalData(j, str);
                } else {
                    str6 = w.uu().uv();
                    if (!TextUtils.isEmpty(str6)) {
                        r.getInstance().insertErrorData(eVar.ol, str);
                    }
                }
            }
            if (go) {
                ZD = str;
            }
            boolean z7 = false;
            if (eVar.oo != null && eVar.oo.length() > 0) {
                z7 = true;
            }
            synchronized (pt) {
                u a2 = a(gn, go, str2, z7);
                boolean z8 = ZA.ZF;
                if (a2 != null) {
                    a2.num++;
                    if (z) {
                        a2.time += j;
                        a2.od += j2;
                        ZA.ZF = true;
                        if (z4) {
                            a2.Zw++;
                        }
                        Zz = 0;
                    } else {
                        if (com.baidu.adp.lib.util.i.gm()) {
                            int i2 = Zz + 1;
                            Zz = i2;
                            if (i2 >= com.baidu.adp.lib.stats.switchs.a.fD().getMaxAlertCount("alert_img", 5)) {
                                com.baidu.adp.lib.stats.a.eI().p("alert_img", "imgFailedCnt_" + String.valueOf(Zz) + "_url=" + str2);
                            }
                        }
                        a2.Zv++;
                        ZA.ZF = false;
                    }
                }
                int ur = ZA.ur();
                if (ur > 100 || (ur > 0 && z8 != ZA.ZF)) {
                    uk();
                }
            }
            if (z && z5) {
                if (!gn || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Nf) {
                    if (gn || !com.baidu.adp.lib.util.i.gr() || j >= com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Nh) {
                        if (!gn && j < com.baidu.tbadk.core.util.a.e.getInstance().getCDNImageTimeData().Ng) {
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
                dVar = eB();
            }
            if (TextUtils.isEmpty(str6)) {
                str6 = w.uu().uv();
            }
            if (!go || !TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = w.uu().dm(str);
            }
            if (!TextUtils.isEmpty("")) {
                str5 = "";
            } else {
                str5 = um();
            }
            dVar.q("url", str);
            dVar.q("act", "dl");
            dVar.q("result", z ? "1" : "0");
            dVar.q("fullurl", str2);
            dVar.q("netlib", String.valueOf(eVar.ou));
            dVar.q("costTime", String.valueOf(j));
            dVar.q("connTime", String.valueOf(eVar.oe));
            dVar.q("rspTime", String.valueOf(eVar.of));
            dVar.q("retry", String.valueOf(eVar.og));
            dVar.q("localIp", e.getIp());
            dVar.q("tiebaIp", str6);
            dVar.q("cdnIp", str4);
            dVar.q("useIp", eVar.oo);
            dVar.q("dnsIp", str5);
            if (eVar.oe > 1500 || eVar.oe < 0) {
                dVar.q("connBaidu", String.valueOf(un()));
            }
            dVar.q("memory", uo());
            dVar.q("task", up());
            dVar.q("status", String.valueOf(eVar.om));
            dVar.q("up", String.valueOf(eVar.oc));
            dVar.q("down", String.valueOf(eVar.od));
            dVar.q("isCDN", go ? "1" : "0");
            dVar.q("isWebp", bool.booleanValue() ? "1" : "0");
            dVar.q("isMobileProxy", z3 ? "1" : "0");
            dVar.q("exception", eVar.oj);
            dVar.q("reason", str3);
            if (i != 0) {
                dVar.d("procType", Integer.valueOf(i));
            }
            if (eVar.or != null) {
                dVar.q("tracecode1", eVar.or);
            }
            if (eVar.ot != null) {
                dVar.q("tracecode2", eVar.ot);
            }
            com.baidu.adp.lib.stats.a.eI().b("img", dVar);
            if (go && !TextUtils.isEmpty(str6) && TextUtils.isEmpty(str4) && !z) {
                ZA.ZE++;
            }
        }
    }

    public static void uk() {
        if (ZA.ur() > 10) {
            if (ZA.uq() > 0) {
                a(ZA.ZG, ZA.ZH, ZA.ZI, ZA.ZK, ZA.ZJ, 10000);
                com.baidu.tbadk.performanceLog.x.b(ZA.ZG, ZA.ZH, ZA.ZI, ZA.ZK, ZA.ZJ, 3);
            }
            if (ZA.ut() > 0) {
                a(ZA.ZQ, ZA.ZR, ZA.ZS, ZA.ZU, ZA.ZT, 100002);
                com.baidu.tbadk.performanceLog.x.b(ZA.ZQ, ZA.ZR, ZA.ZS, ZA.ZU, ZA.ZT, 2);
            }
            if (ZA.us() > 0) {
                a(ZA.ZL, ZA.ZM, ZA.ZN, ZA.ZP, ZA.ZO, 100001);
                com.baidu.tbadk.performanceLog.x.b(ZA.ZL, ZA.ZM, ZA.ZN, ZA.ZP, ZA.ZO, 1);
            }
            ZA.reset();
        }
    }

    public static void a(u uVar, u uVar2, u uVar3, u uVar4, u uVar5, int i) {
        if (uVar != null && uVar2 != null && uVar3 != null && uVar4 != null && uVar5 != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty("")) {
                str = w.uu().uv();
            }
            if (ZD != null && TextUtils.isEmpty("")) {
                str2 = w.uu().dm(ZD);
            }
            if (TextUtils.isEmpty("")) {
                str3 = um();
            }
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("act", "dlStat");
            eB.q("cdnCostTime", String.valueOf(uVar.time));
            eB.q("cdnNum", String.valueOf(uVar.num));
            eB.q("cdnFailnum", String.valueOf(uVar.Zv));
            eB.q("portraitCostTime", String.valueOf(uVar2.time));
            eB.q("portraitNum", String.valueOf(uVar2.num));
            eB.q("portraitFailnum", String.valueOf(uVar2.Zv));
            eB.q("tiebaCostTime", String.valueOf(uVar3.time));
            eB.q("tiebaNum", String.valueOf(uVar3.num));
            eB.q("tiebaFailnum", String.valueOf(uVar3.Zv));
            eB.q("otherCostTime", String.valueOf(uVar5.time));
            eB.q("otherNum", String.valueOf(uVar5.num));
            eB.q("otherFailnum", String.valueOf(uVar5.Zv));
            eB.q("directIpCostTime", String.valueOf(uVar4.time));
            eB.q("directIpNum", String.valueOf(uVar4.num));
            eB.q("directIpFailnum", String.valueOf(uVar4.Zv));
            eB.q("dnsFailNum", String.valueOf(ZA.ZE));
            if (10000 == i) {
                eB.q("isWifi", "1");
                eB.q("netType", "WIFI");
            } else if (100002 == i) {
                eB.q("netType", "3G");
                eB.q("isWifi", "0");
            } else {
                eB.q("netType", "2G");
                eB.q("isWifi", "0");
            }
            eB.q("localIp", e.getIp());
            eB.q("tbIp", str);
            eB.q("cdnIp", str2);
            eB.q("dnsIp", str3);
            com.baidu.adp.lib.stats.a.eI().b("img", eB);
        }
    }

    public static void a(com.baidu.adp.lib.stats.d dVar, String str, String str2, boolean z, boolean z2, boolean z3, int i, String str3, long j, String str4) {
        if (com.baidu.adp.lib.util.k.gD()) {
            synchronized (pt) {
                ZC.num++;
                if (z) {
                    ZC.time += j;
                } else {
                    ZC.Zv++;
                }
                if (ZC.num >= 100) {
                    ul();
                }
            }
            if (!z) {
                if (dVar == null) {
                    dVar = eB();
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
                com.baidu.adp.lib.stats.a.eI().b("img", dVar);
            }
        }
    }

    public static void ul() {
        if (ZC.num > 10) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("act", "dcStat");
            eB.q("costTime", String.valueOf(ZC.time));
            eB.q("num", String.valueOf(ZC.num));
            eB.q("failnum", String.valueOf(ZC.Zv));
            com.baidu.adp.lib.stats.a.eI().b("img", eB);
            com.baidu.tbadk.performanceLog.x.a(ZC.num, ZC.Zv, ZC.time);
            ZC.reset();
        }
    }

    public static void dl(String str) {
        com.baidu.adp.lib.stats.d eB = eB();
        eB.q("act", "assistant");
        eB.q(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, str);
        com.baidu.adp.lib.stats.a.eI().b("img", eB);
    }

    private static String um() {
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
    private static long un() {
        HttpURLConnection httpURLConnection;
        long j;
        if (Zx >= 3) {
            return Zy;
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
            if (Zx > -1) {
                Zy = ((Zy * Zx) + j) / (Zx + 1);
            } else {
                Zy = j;
            }
            Zx++;
            return j;
        }
        return j;
    }

    private static String uo() {
        return com.baidu.tbadk.imageManager.c.Ek().df();
    }

    private static String up() {
        return com.baidu.adp.lib.asyncTask.c.dg().df();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.d eB = eB();
        eB.q("act", "getCDNList");
        eB.q("errorNum", str);
        eB.q(EcommSellerErrorActivityConfig.ERROR_MSG, str2);
        eB.q("isShortNetError", z2 ? "1" : "0");
        eB.q("isSuccess", z ? "1" : "0");
        com.baidu.adp.lib.stats.a.eI().b("img", eB);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = w.uu().dm(str);
        }
        String um = um();
        String ip = e.getIp();
        com.baidu.adp.lib.stats.d eB = eB();
        eB.q("act", "tachometerCDN");
        eB.q("errorNum", str3);
        eB.q("execption", str4);
        eB.q("size", str5);
        eB.q("isScuess", z ? "1" : "0");
        eB.q("url", str);
        eB.q("localIp", ip);
        eB.q("cdnIp", str6);
        eB.q("dnsIP", um);
        eB.q("usedIp", str2);
        eB.q("isUsedIp", z2 ? "0" : "1");
        eB.q("costTime", String.valueOf(j));
        com.baidu.adp.lib.stats.a.eI().b("img", eB);
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
                    com.baidu.adp.lib.stats.d eB = eB();
                    eB.q("act", "mobileTachometerCDN");
                    eB.q("costTime", String.valueOf(j));
                    eB.q("ipList", sb.toString());
                    com.baidu.adp.lib.stats.a.eI().b("img", eB);
                    return;
                }
            }
        }
    }

    public static void d(boolean z, String str) {
        com.baidu.adp.lib.stats.d eB = eB();
        eB.q("act", "getCDNList");
        eB.q("isSuccess", z ? "1" : "0");
        eB.q(EcommSellerErrorActivityConfig.ERROR_MSG, str);
        com.baidu.adp.lib.stats.a.eI().b("img", eB);
    }

    public static void a(String str, int i, int i2, int i3) {
        if (i == -1) {
            i = 0;
        }
        if (i2 == -1) {
            i2 = 0;
        }
        com.baidu.adp.lib.stats.a.eI().eventStat(null, str, "imgHttpSwitch", 1, "1sterrcode", String.valueOf(i), "2nderrcode", String.valueOf(i2), "2imgFailed", String.valueOf(i3));
    }
}
